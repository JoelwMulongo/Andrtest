package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u001b\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0017\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ#\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020\u00032\b\b\u0002\u0010o\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010pJ\u0015\u0010q\u001a\u00020m2\u0006\u0010r\u001a\u00020sH\u0000¢\u0006\u0002\btJ\u0010\u0010u\u001a\u00020m2\u0006\u0010v\u001a\u00020>H\u0002J\u0016\u0010w\u001a\u00020m2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00030yH\u0002J\u0010\u0010z\u001a\u00020a2\u0006\u0010{\u001a\u00020aH\u0016J\u0018\u0010|\u001a\u00020\u00072\u0006\u0010}\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0003H\u0002J\u0010\u0010~\u001a\u00020m2\u0006\u0010{\u001a\u00020aH\u0002J\u0011\u0010\u001a\u00020a2\u0007\u0010\u0001\u001a\u00020aH\u0002JL\u0010\u0001\u001a\u00020m2\b\u0010\u0001\u001a\u00030\u00012-\u0010\u0001\u001a(\b\u0001\u0012\u0005\u0012\u00030\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020m0\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u00010\u0001¢\u0006\u0003\b\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J$\u0010\u0001\u001a\u00020m2\u0006\u0010n\u001a\u00020\u00032\b\b\u0002\u0010o\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010pJ\u0019\u0010\u0001\u001a\u00020m2\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0001J$\u0010\u0001\u001a\u00020m*\u00030\u00012\u0006\u0010n\u001a\u00020\u00032\u0006\u0010o\u001a\u00020\u0003H\u0000¢\u0006\u0003\b\u0001R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8V@RX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R+\u0010\u0015\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8V@RX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010\"\u001a\u00020\u00038FX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u001b\u0010'\u001a\u00020\u00038FX\u0002¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b(\u0010$R\u0011\u0010*\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0010R\u001a\u0010/\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012R\u0014\u00102\u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b3\u0010$R\u0014\u00104\u001a\u000205X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0011\u0010=\u001a\u00020>8F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020>0BX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010$\"\u0004\bE\u0010FR\u0014\u0010G\u001a\u00020HX\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0014\u0010K\u001a\u00020LX\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010P\u001a\u00020QX\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0010\"\u0004\bV\u0010\u0012R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010Y\u001a\u00020ZX\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0014\u0010]\u001a\u00020^X\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R\u001e\u0010b\u001a\u00020a2\u0006\u0010\f\u001a\u00020a@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u000e\u0010e\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010f\u001a\u0004\u0018\u00010gX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010k\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemOffset", "(II)V", "initialFirstVisibleItems", "", "initialFirstVisibleOffsets", "([I[I)V", "animateScrollScope", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridAnimateScrollScope;", "<set-?>", "", "canScrollBackward", "getCanScrollBackward", "()Z", "setCanScrollBackward", "(Z)V", "canScrollBackward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "currentItemPrefetchHandles", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "firstVisibleItemIndex", "getFirstVisibleItemIndex", "()I", "firstVisibleItemIndex$delegate", "Landroidx/compose/runtime/State;", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "firstVisibleItemScrollOffset$delegate", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "isScrollInProgress", "isVertical", "isVertical$foundation_release", "setVertical$foundation_release", "laneCount", "getLaneCount$foundation_release", "laneInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "getLaneInfo$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "laneWidthsPrefixSum", "getLaneWidthsPrefixSum$foundation_release", "()[I", "setLaneWidthsPrefixSum$foundation_release", "([I)V", "layoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "measurePassCount", "getMeasurePassCount$foundation_release", "setMeasurePassCount$foundation_release", "(I)V", "mutableInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getMutableInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "prefetchBaseIndex", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "remeasurement", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollPosition", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "getScrollPosition$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "()F", "scrollableState", "spanProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "getSpanProvider$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;", "setSpanProvider$foundation_release", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSpanProvider;)V", "animateScrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "applyMeasureResult$foundation_release", "cancelPrefetchIfVisibleItemsChanged", "info", "clearLeftoverPrefetchHandles", "prefetchHandlesUsed", "", "dispatchRawDelta", "delta", "fillNearestIndices", "itemIndex", "notifyPrefetch", "onScroll", "distance", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "snapToItemInternal", "snapToItemInternal$foundation_release", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridState.kt */
public final class LazyStaggeredGridState implements ScrollableState {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Saver<LazyStaggeredGridState, Object> Saver = ListSaverKt.listSaver(LazyStaggeredGridState$Companion$Saver$1.INSTANCE, LazyStaggeredGridState$Companion$Saver$2.INSTANCE);
    private final LazyStaggeredGridAnimateScrollScope animateScrollScope;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private final Map<Integer, LazyLayoutPrefetchState.PrefetchHandle> currentItemPrefetchHandles;
    private Density density;
    private final State firstVisibleItemIndex$delegate;
    private final State firstVisibleItemScrollOffset$delegate;
    private boolean isVertical;
    private final LazyStaggeredGridLaneInfo laneInfo;
    private int[] laneWidthsPrefixSum;
    private final MutableState<LazyStaggeredGridLayoutInfo> layoutInfoState;
    private int measurePassCount;
    private final MutableInteractionSource mutableInteractionSource;
    private final LazyLayoutPinnedItemList pinnedItems;
    private int prefetchBaseIndex;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    /* access modifiers changed from: private */
    public Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyStaggeredGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;
    private LazyStaggeredGridSpanProvider spanProvider;

    public /* synthetic */ LazyStaggeredGridState(int[] iArr, int[] iArr2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr, iArr2);
    }

    private LazyStaggeredGridState(int[] initialFirstVisibleItems, int[] initialFirstVisibleOffsets) {
        this.firstVisibleItemIndex$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new LazyStaggeredGridState$firstVisibleItemIndex$2(this));
        this.firstVisibleItemScrollOffset$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new LazyStaggeredGridState$firstVisibleItemScrollOffset$2(this));
        this.scrollPosition = new LazyStaggeredGridScrollPosition(initialFirstVisibleItems, initialFirstVisibleOffsets, new LazyStaggeredGridState$scrollPosition$1(this));
        this.layoutInfoState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(EmptyLazyStaggeredGridLayoutInfo.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.laneInfo = new LazyStaggeredGridLaneInfo();
        this.canScrollForward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.canScrollBackward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.animateScrollScope = new LazyStaggeredGridAnimateScrollScope(this);
        this.remeasurementModifier = new LazyStaggeredGridState$remeasurementModifier$1(this);
        this.prefetchingEnabled = true;
        this.prefetchState = new LazyLayoutPrefetchState();
        this.scrollableState = ScrollableStateKt.ScrollableState(new LazyStaggeredGridState$scrollableState$1(this));
        this.laneWidthsPrefixSum = new int[0];
        this.prefetchBaseIndex = -1;
        this.currentItemPrefetchHandles = new LinkedHashMap();
        this.density = DensityKt.Density(1.0f, 1.0f);
        this.mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.pinnedItems = new LazyLayoutPinnedItemList();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyStaggeredGridState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public LazyStaggeredGridState(int initialFirstVisibleItemIndex, int initialFirstVisibleItemOffset) {
        this(new int[]{initialFirstVisibleItemIndex}, new int[]{initialFirstVisibleItemOffset});
    }

    public final int getFirstVisibleItemIndex() {
        return ((Number) this.firstVisibleItemIndex$delegate.getValue()).intValue();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return ((Number) this.firstVisibleItemScrollOffset$delegate.getValue()).intValue();
    }

    public final LazyStaggeredGridScrollPosition getScrollPosition$foundation_release() {
        return this.scrollPosition;
    }

    public final LazyStaggeredGridLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    public final LazyStaggeredGridLaneInfo getLaneInfo$foundation_release() {
        return this.laneInfo;
    }

    private void setCanScrollForward(boolean z) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(z));
    }

    public boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    private void setCanScrollBackward(boolean z) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(z));
    }

    public boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    public final boolean getPrefetchingEnabled$foundation_release() {
        return this.prefetchingEnabled;
    }

    public final void setPrefetchingEnabled$foundation_release(boolean z) {
        this.prefetchingEnabled = z;
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public final float getScrollToBeConsumed$foundation_release() {
        return this.scrollToBeConsumed;
    }

    public final int getMeasurePassCount$foundation_release() {
        return this.measurePassCount;
    }

    public final void setMeasurePassCount$foundation_release(int i) {
        this.measurePassCount = i;
    }

    public final boolean isVertical$foundation_release() {
        return this.isVertical;
    }

    public final void setVertical$foundation_release(boolean z) {
        this.isVertical = z;
    }

    public final int[] getLaneWidthsPrefixSum$foundation_release() {
        return this.laneWidthsPrefixSum;
    }

    public final void setLaneWidthsPrefixSum$foundation_release(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.laneWidthsPrefixSum = iArr;
    }

    public final LazyStaggeredGridSpanProvider getSpanProvider$foundation_release() {
        return this.spanProvider;
    }

    public final void setSpanProvider$foundation_release(LazyStaggeredGridSpanProvider lazyStaggeredGridSpanProvider) {
        this.spanProvider = lazyStaggeredGridSpanProvider;
    }

    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final void setDensity$foundation_release(Density density2) {
        Intrinsics.checkNotNullParameter(density2, "<set-?>");
        this.density = density2;
    }

    public final int getLaneCount$foundation_release() {
        return this.laneWidthsPrefixSum.length;
    }

    public final InteractionSource getInteractionSource() {
        return this.mutableInteractionSource;
    }

    public final MutableInteractionSource getMutableInteractionSource$foundation_release() {
        return this.mutableInteractionSource;
    }

    public final LazyLayoutPinnedItemList getPinnedItems$foundation_release() {
        return this.pinnedItems;
    }

    public Object scroll(MutatePriority scrollPriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        Object scroll = this.scrollableState.scroll(scrollPriority, block, $completion);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    /* access modifiers changed from: private */
    public final float onScroll(float distance) {
        if ((distance < 0.0f && !getCanScrollForward()) || (distance > 0.0f && !getCanScrollBackward())) {
            return 0.0f;
        }
        if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
            float f = this.scrollToBeConsumed + distance;
            this.scrollToBeConsumed = f;
            if (Math.abs(f) > 0.5f) {
                float preScrollToBeConsumed = this.scrollToBeConsumed;
                Remeasurement remeasurement2 = this.remeasurement;
                if (remeasurement2 != null) {
                    remeasurement2.forceRemeasure();
                }
                if (this.prefetchingEnabled) {
                    notifyPrefetch(preScrollToBeConsumed - this.scrollToBeConsumed);
                }
            }
            if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
                return distance;
            }
            float scrollConsumed = distance - this.scrollToBeConsumed;
            this.scrollToBeConsumed = 0.0f;
            return scrollConsumed;
        }
        throw new IllegalStateException(("entered drag with non-zero pending scroll: " + this.scrollToBeConsumed).toString());
    }

    public static /* synthetic */ Object scrollToItem$default(LazyStaggeredGridState lazyStaggeredGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyStaggeredGridState.scrollToItem(i, i2, continuation);
    }

    public final Object scrollToItem(int index, int scrollOffset, Continuation<? super Unit> $completion) {
        Object scroll$default = ScrollableState.scroll$default(this, (MutatePriority) null, new LazyStaggeredGridState$scrollToItem$2(this, index, scrollOffset, (Continuation<? super LazyStaggeredGridState$scrollToItem$2>) null), $completion, 1, (Object) null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyStaggeredGridState lazyStaggeredGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyStaggeredGridState.animateScrollToItem(i, i2, continuation);
    }

    public final Object animateScrollToItem(int index, int scrollOffset, Continuation<? super Unit> $completion) {
        Object animateScrollToItem = LazyAnimateScrollKt.animateScrollToItem(this.animateScrollScope, index, scrollOffset, $completion);
        return animateScrollToItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToItem : Unit.INSTANCE;
    }

    public final void snapToItemInternal$foundation_release(ScrollScope $this$snapToItemInternal, int index, int scrollOffset) {
        Intrinsics.checkNotNullParameter($this$snapToItemInternal, "<this>");
        LazyStaggeredGridItemInfo visibleItem = LazyStaggeredGridMeasureResultKt.findVisibleItem(getLayoutInfo(), index);
        if (visibleItem != null) {
            $this$snapToItemInternal.scrollBy((float) ((this.isVertical ? IntOffset.m6105getYimpl(visibleItem.m1040getOffsetnOccac()) : IntOffset.m6104getXimpl(visibleItem.m1040getOffsetnOccac())) + scrollOffset));
            return;
        }
        this.scrollPosition.requestPosition(index, scrollOffset);
        Remeasurement remeasurement2 = this.remeasurement;
        if (remeasurement2 != null) {
            remeasurement2.forceRemeasure();
        }
    }

    public final void updateScrollPositionIfTheFirstItemWasMoved$foundation_release(LazyLayoutItemProvider itemProvider) {
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(itemProvider);
    }

    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    private final void notifyPrefetch(float delta) {
        int prefetchIndex;
        int i;
        boolean scrollingForward;
        LazyStaggeredGridLayoutInfo info;
        long constraints;
        LazyStaggeredGridLayoutInfo info2 = this.layoutInfoState.getValue();
        boolean z = true;
        if (!info2.getVisibleItemsInfo().isEmpty()) {
            boolean scrollingForward2 = delta < 0.0f;
            if (scrollingForward2) {
                prefetchIndex = ((LazyStaggeredGridItemInfo) CollectionsKt.last(info2.getVisibleItemsInfo())).getIndex();
            } else {
                prefetchIndex = ((LazyStaggeredGridItemInfo) CollectionsKt.first(info2.getVisibleItemsInfo())).getIndex();
            }
            if (prefetchIndex != this.prefetchBaseIndex) {
                this.prefetchBaseIndex = prefetchIndex;
                Set prefetchHandlesUsed = new LinkedHashSet();
                int targetIndex = prefetchIndex;
                int lane = 0;
                int length = this.laneWidthsPrefixSum.length;
                while (true) {
                    if (lane >= length) {
                        boolean z2 = scrollingForward2;
                        break;
                    }
                    int previousIndex = targetIndex;
                    if (scrollingForward2) {
                        i = this.laneInfo.findNextItemIndex(previousIndex, lane);
                    } else {
                        i = this.laneInfo.findPreviousItemIndex(previousIndex, lane);
                    }
                    targetIndex = i;
                    if (!((targetIndex < 0 || targetIndex >= info2.getTotalItemsCount()) ? false : z)) {
                        boolean z3 = scrollingForward2;
                        break;
                    } else if (prefetchHandlesUsed.contains(Integer.valueOf(targetIndex))) {
                        LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo = info2;
                        boolean z4 = scrollingForward2;
                        break;
                    } else {
                        prefetchHandlesUsed.add(Integer.valueOf(targetIndex));
                        if (this.currentItemPrefetchHandles.containsKey(Integer.valueOf(targetIndex))) {
                            info = info2;
                            scrollingForward = scrollingForward2;
                        } else {
                            LazyStaggeredGridSpanProvider lazyStaggeredGridSpanProvider = this.spanProvider;
                            boolean isFullSpan = (lazyStaggeredGridSpanProvider == null || lazyStaggeredGridSpanProvider.isFullSpan(targetIndex) != z) ? false : z;
                            int slot = isFullSpan ? 0 : lane;
                            int span = isFullSpan ? getLaneCount$foundation_release() : z;
                            int[] iArr = this.laneWidthsPrefixSum;
                            int crossAxisSize = iArr[(slot + span) - (z ? 1 : 0)] - (slot == 0 ? 0 : iArr[slot - 1]);
                            if (this.isVertical) {
                                constraints = Constraints.Companion.m5940fixedWidthOenEA2s(crossAxisSize);
                            } else {
                                constraints = Constraints.Companion.m5939fixedHeightOenEA2s(crossAxisSize);
                            }
                            info = info2;
                            scrollingForward = scrollingForward2;
                            this.currentItemPrefetchHandles.put(Integer.valueOf(targetIndex), this.prefetchState.m1031schedulePrefetch0kLqBqw(targetIndex, constraints));
                        }
                        lane++;
                        info2 = info;
                        scrollingForward2 = scrollingForward;
                        z = true;
                    }
                }
                clearLeftoverPrefetchHandles(prefetchHandlesUsed);
                return;
            }
            return;
        }
    }

    private final void clearLeftoverPrefetchHandles(Set<Integer> prefetchHandlesUsed) {
        Iterator iterator = this.currentItemPrefetchHandles.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            if (!prefetchHandlesUsed.contains(entry.getKey())) {
                ((LazyLayoutPrefetchState.PrefetchHandle) entry.getValue()).cancel();
                iterator.remove();
            }
        }
    }

    private final void cancelPrefetchIfVisibleItemsChanged(LazyStaggeredGridLayoutInfo info) {
        List<LazyStaggeredGridItemInfo> visibleItemsInfo = info.getVisibleItemsInfo();
        if (this.prefetchBaseIndex != -1) {
            boolean z = true;
            if (!visibleItemsInfo.isEmpty()) {
                int index = ((LazyStaggeredGridItemInfo) CollectionsKt.first(visibleItemsInfo)).getIndex();
                int index2 = ((LazyStaggeredGridItemInfo) CollectionsKt.last(visibleItemsInfo)).getIndex();
                int i = this.prefetchBaseIndex;
                if (index > i || i > index2) {
                    z = false;
                }
                if (!z) {
                    this.prefetchBaseIndex = -1;
                    for (LazyLayoutPrefetchState.PrefetchHandle it : this.currentItemPrefetchHandles.values()) {
                        it.cancel();
                    }
                    this.currentItemPrefetchHandles.clear();
                }
            }
        }
    }

    public final void applyMeasureResult$foundation_release(LazyStaggeredGridMeasureResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.scrollToBeConsumed -= result.getConsumedScroll();
        setCanScrollBackward(result.getCanScrollBackward());
        setCanScrollForward(result.getCanScrollForward());
        this.layoutInfoState.setValue(result);
        cancelPrefetchIfVisibleItemsChanged(result);
        this.scrollPosition.updateFromMeasureResult(result);
        this.measurePassCount++;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        if (r0.isFullSpan(r12) == true) goto L_0x0010;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int[] fillNearestIndices(int r12, int r13) {
        /*
            r11 = this;
            int[] r6 = new int[r13]
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridSpanProvider r0 = r11.spanProvider
            r1 = 0
            if (r0 == 0) goto L_0x000f
            boolean r0 = r0.isFullSpan(r12)
            r2 = 1
            if (r0 != r2) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r2 = r1
        L_0x0010:
            if (r2 == 0) goto L_0x001c
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            r0 = r6
            r1 = r12
            kotlin.collections.ArraysKt.fill$default((int[]) r0, (int) r1, (int) r2, (int) r3, (int) r4, (java.lang.Object) r5)
            return r6
        L_0x001c:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r0 = r11.laneInfo
            int r2 = r12 + r13
            r0.ensureValidIndex(r2)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r0 = r11.laneInfo
            int r7 = r0.getLane(r12)
            r0 = -1
            if (r7 != r0) goto L_0x002d
            goto L_0x0031
        L_0x002d:
            int r1 = java.lang.Math.min(r7, r13)
        L_0x0031:
            r8 = r1
            r1 = r12
            int r2 = r8 + -1
            r9 = r1
            r10 = r2
        L_0x0037:
            if (r0 >= r10) goto L_0x0054
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r1 = r11.laneInfo
            int r1 = r1.findPreviousItemIndex(r9, r10)
            r6[r10] = r1
            r1 = r6[r10]
            if (r1 != r0) goto L_0x004f
            r1 = -1
            r2 = 0
            r4 = 2
            r5 = 0
            r0 = r6
            r3 = r10
            kotlin.collections.ArraysKt.fill$default((int[]) r0, (int) r1, (int) r2, (int) r3, (int) r4, (java.lang.Object) r5)
            goto L_0x0054
        L_0x004f:
            r9 = r6[r10]
            int r10 = r10 + -1
            goto L_0x0037
        L_0x0054:
            r6[r8] = r12
            r0 = r12
            int r1 = r8 + 1
        L_0x0059:
            if (r1 >= r13) goto L_0x0068
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r2 = r11.laneInfo
            int r2 = r2.findNextItemIndex(r0, r1)
            r6[r1] = r2
            r0 = r6[r1]
            int r1 = r1 + 1
            goto L_0x0059
        L_0x0068:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState.fillNearestIndices(int, int):int[]");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyStaggeredGridState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<LazyStaggeredGridState, Object> getSaver() {
            return LazyStaggeredGridState.Saver;
        }
    }
}
