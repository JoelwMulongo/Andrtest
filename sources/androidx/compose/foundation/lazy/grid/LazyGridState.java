package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J#\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020\u00032\b\b\u0002\u0010w\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010xJ\u0015\u0010y\u001a\u00020u2\u0006\u0010z\u001a\u00020{H\u0000¢\u0006\u0002\b|J\u0010\u0010}\u001a\u00020u2\u0006\u0010~\u001a\u000204H\u0002J\u0011\u0010\u001a\u00020i2\u0007\u0010\u0001\u001a\u00020iH\u0016J\u0012\u0010\u0001\u001a\u00020u2\u0007\u0010\u0001\u001a\u00020iH\u0002J\u0018\u0010\u0001\u001a\u00020i2\u0007\u0010\u0001\u001a\u00020iH\u0000¢\u0006\u0003\b\u0001JL\u0010\u0001\u001a\u00020u2\b\u0010\u0001\u001a\u00030\u00012-\u0010\u0001\u001a(\b\u0001\u0012\u0005\u0012\u00030\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020u0\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u00010\u0001¢\u0006\u0003\b\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J$\u0010\u0001\u001a\u00020u2\u0006\u0010v\u001a\u00020\u00032\b\b\u0002\u0010w\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010xJ\u001f\u0010\u0001\u001a\u00020u2\u0006\u0010v\u001a\u00020\u00032\u0006\u0010w\u001a\u00020\u0003H\u0000¢\u0006\u0003\b\u0001J\u0019\u0010\u0001\u001a\u00020u2\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8V@RX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R+\u0010\u0015\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8V@RX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u001c8@@@X\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b%\u0010$R\u0011\u0010&\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0010R+\u0010/\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8@@@X\u0002¢\u0006\u0012\n\u0004\b2\u0010\u0014\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012R\u0011\u00103\u001a\u0002048F¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020408X\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010:\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010$R\u0014\u0010<\u001a\u00020=X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R/\u0010A\u001a\u0004\u0018\u00010@2\b\u0010\f\u001a\u0004\u0018\u00010@8@@@X\u0002¢\u0006\u0012\n\u0004\bF\u0010\u0014\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0001\u0010O\u001a/\u0012\u0013\u0012\u00110H¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020N0M0L0G23\u0010\f\u001a/\u0012\u0013\u0012\u00110H¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020N0M0L0G8@@@X\u0002ø\u0001\u0000¢\u0006\u0012\n\u0004\bT\u0010\u0014\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020VX\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0010\"\u0004\b[\u0010\u0012R/\u0010]\u001a\u0004\u0018\u00010\\2\b\u0010\f\u001a\u0004\u0018\u00010\\8B@BX\u0002¢\u0006\u0012\n\u0004\bb\u0010\u0014\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020dX\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u000e\u0010g\u001a\u00020hX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010j\u001a\u00020i2\u0006\u0010\f\u001a\u00020i@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bk\u0010lR\u000e\u0010m\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R+\u0010n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00038@@@X\u0002¢\u0006\u0012\n\u0004\br\u0010\u0014\u001a\u0004\bo\u0010$\"\u0004\bp\u0010qR\u000e\u0010s\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "(II)V", "animateScrollScope", "Landroidx/compose/foundation/lazy/grid/LazyGridAnimateScrollScope;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/AwaitFirstLayoutModifier;", "<set-?>", "", "canScrollBackward", "getCanScrollBackward", "()Z", "setCanScrollBackward", "(Z)V", "canScrollBackward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "currentLinePrefetchHandles", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isScrollInProgress", "isVertical", "isVertical$foundation_release", "setVertical$foundation_release", "isVertical$delegate", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "lineToPrefetch", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "placementAnimator", "getPlacementAnimator$foundation_release", "()Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "setPlacementAnimator$foundation_release", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;)V", "placementAnimator$delegate", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "Lkotlin/ParameterName;", "name", "line", "", "Lkotlin/Pair;", "Landroidx/compose/ui/unit/Constraints;", "prefetchInfoRetriever", "getPrefetchInfoRetriever$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setPrefetchInfoRetriever$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "prefetchInfoRetriever$delegate", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement", "()Landroidx/compose/ui/layout/Remeasurement;", "setRemeasurement", "(Landroidx/compose/ui/layout/Remeasurement;)V", "remeasurement$delegate", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollPosition", "Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "()F", "scrollableState", "slotsPerLine", "getSlotsPerLine$foundation_release", "setSlotsPerLine$foundation_release", "(I)V", "slotsPerLine$delegate", "wasScrollingForward", "animateScrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "applyMeasureResult$foundation_release", "cancelPrefetchIfVisibleItemsChanged", "info", "dispatchRawDelta", "delta", "notifyPrefetch", "onScroll", "distance", "onScroll$foundation_release", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "snapToItemIndexInternal", "snapToItemIndexInternal$foundation_release", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridState.kt */
public final class LazyGridState implements ScrollableState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Saver<LazyGridState, ?> Saver = ListSaverKt.listSaver(LazyGridState$Companion$Saver$1.INSTANCE, LazyGridState$Companion$Saver$2.INSTANCE);
    private final LazyGridAnimateScrollScope animateScrollScope;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private final MutableVector<LazyLayoutPrefetchState.PrefetchHandle> currentLinePrefetchHandles;
    private final MutableState density$delegate;
    private final MutableInteractionSource internalInteractionSource;
    private final MutableState isVertical$delegate;
    private final MutableState<LazyGridLayoutInfo> layoutInfoState;
    private int lineToPrefetch;
    private int numMeasurePasses;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final MutableState placementAnimator$delegate;
    private final MutableState prefetchInfoRetriever$delegate;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private final MutableState remeasurement$delegate;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;
    private final MutableState slotsPerLine$delegate;
    private boolean wasScrollingForward;

    public LazyGridState() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public LazyGridState(int firstVisibleItemIndex, int firstVisibleItemScrollOffset) {
        this.scrollPosition = new LazyGridScrollPosition(firstVisibleItemIndex, firstVisibleItemScrollOffset);
        this.layoutInfoState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(EmptyLazyGridLayoutInfo.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.slotsPerLine$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.density$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DensityKt.Density(1.0f, 1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isVertical$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.scrollableState = ScrollableStateKt.ScrollableState(new LazyGridState$scrollableState$1(this));
        this.prefetchingEnabled = true;
        this.lineToPrefetch = -1;
        this.currentLinePrefetchHandles = new MutableVector<>(new LazyLayoutPrefetchState.PrefetchHandle[16], 0);
        this.remeasurement$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.remeasurementModifier = new LazyGridState$remeasurementModifier$1(this);
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.prefetchInfoRetriever$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(LazyGridState$prefetchInfoRetriever$2.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.placementAnimator$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.animateScrollScope = new LazyGridAnimateScrollScope(this);
        this.pinnedItems = new LazyLayoutPinnedItemList();
        this.canScrollForward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.canScrollBackward$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.prefetchState = new LazyLayoutPrefetchState();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyGridState(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.m977getIndexVZbfaAc();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    public final LazyGridLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    public final float getScrollToBeConsumed$foundation_release() {
        return this.scrollToBeConsumed;
    }

    public final int getSlotsPerLine$foundation_release() {
        return ((Number) this.slotsPerLine$delegate.getValue()).intValue();
    }

    public final void setSlotsPerLine$foundation_release(int i) {
        this.slotsPerLine$delegate.setValue(Integer.valueOf(i));
    }

    public final Density getDensity$foundation_release() {
        return (Density) this.density$delegate.getValue();
    }

    public final void setDensity$foundation_release(Density density) {
        Intrinsics.checkNotNullParameter(density, "<set-?>");
        this.density$delegate.setValue(density);
    }

    public final boolean isVertical$foundation_release() {
        return ((Boolean) this.isVertical$delegate.getValue()).booleanValue();
    }

    public final void setVertical$foundation_release(boolean z) {
        this.isVertical$delegate.setValue(Boolean.valueOf(z));
    }

    public final int getNumMeasurePasses$foundation_release() {
        return this.numMeasurePasses;
    }

    public final boolean getPrefetchingEnabled$foundation_release() {
        return this.prefetchingEnabled;
    }

    public final void setPrefetchingEnabled$foundation_release(boolean z) {
        this.prefetchingEnabled = z;
    }

    private final Remeasurement getRemeasurement() {
        return (Remeasurement) this.remeasurement$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void setRemeasurement(Remeasurement remeasurement) {
        this.remeasurement$delegate.setValue(remeasurement);
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation_release() {
        return this.awaitLayoutModifier;
    }

    public final Function1<LineIndex, List<Pair<Integer, Constraints>>> getPrefetchInfoRetriever$foundation_release() {
        return (Function1) this.prefetchInfoRetriever$delegate.getValue();
    }

    public final void setPrefetchInfoRetriever$foundation_release(Function1<? super LineIndex, ? extends List<Pair<Integer, Constraints>>> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.prefetchInfoRetriever$delegate.setValue(function1);
    }

    public final LazyGridItemPlacementAnimator getPlacementAnimator$foundation_release() {
        return (LazyGridItemPlacementAnimator) this.placementAnimator$delegate.getValue();
    }

    public final void setPlacementAnimator$foundation_release(LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator) {
        this.placementAnimator$delegate.setValue(lazyGridItemPlacementAnimator);
    }

    public final LazyLayoutPinnedItemList getPinnedItems$foundation_release() {
        return this.pinnedItems;
    }

    public static /* synthetic */ Object scrollToItem$default(LazyGridState lazyGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyGridState.scrollToItem(i, i2, continuation);
    }

    public final Object scrollToItem(int index, int scrollOffset, Continuation<? super Unit> $completion) {
        Object scroll$default = ScrollableState.scroll$default(this, (MutatePriority) null, new LazyGridState$scrollToItem$2(this, index, scrollOffset, (Continuation<? super LazyGridState$scrollToItem$2>) null), $completion, 1, (Object) null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    public final void snapToItemIndexInternal$foundation_release(int index, int scrollOffset) {
        this.scrollPosition.m978requestPositionyO3Fmg4(ItemIndex.m934constructorimpl(index), scrollOffset);
        LazyGridItemPlacementAnimator placementAnimator$foundation_release = getPlacementAnimator$foundation_release();
        if (placementAnimator$foundation_release != null) {
            placementAnimator$foundation_release.reset();
        }
        Remeasurement remeasurement = getRemeasurement();
        if (remeasurement != null) {
            remeasurement.forceRemeasure();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object scroll(androidx.compose.foundation.MutatePriority r7, kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1 r0 = (androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1 r0 = new androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1
            r0.<init>(r6, r9)
        L_0x0019:
            r9 = r0
            java.lang.Object r0 = r9.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r9.label
            switch(r2) {
                case 0: goto L_0x0041;
                case 1: goto L_0x0031;
                case 2: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x006d
        L_0x0031:
            java.lang.Object r7 = r9.L$2
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r9.L$1
            androidx.compose.foundation.MutatePriority r8 = (androidx.compose.foundation.MutatePriority) r8
            java.lang.Object r2 = r9.L$0
            androidx.compose.foundation.lazy.grid.LazyGridState r2 = (androidx.compose.foundation.lazy.grid.LazyGridState) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x005a
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r6
            androidx.compose.foundation.lazy.AwaitFirstLayoutModifier r3 = r2.awaitLayoutModifier
            r9.L$0 = r2
            r9.L$1 = r7
            r9.L$2 = r8
            r4 = 1
            r9.label = r4
            java.lang.Object r3 = r3.waitForFirstLayout(r9)
            if (r3 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x005a:
            androidx.compose.foundation.gestures.ScrollableState r3 = r2.scrollableState
            r4 = 0
            r9.L$0 = r4
            r9.L$1 = r4
            r9.L$2 = r4
            r4 = 2
            r9.label = r4
            java.lang.Object r7 = r3.scroll(r8, r7, r9)
            if (r7 != r1) goto L_0x006d
            return r1
        L_0x006d:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridState.scroll(androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
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

    public final float onScroll$foundation_release(float distance) {
        if ((distance < 0.0f && !getCanScrollForward()) || (distance > 0.0f && !getCanScrollBackward())) {
            return 0.0f;
        }
        if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
            float f = this.scrollToBeConsumed + distance;
            this.scrollToBeConsumed = f;
            if (Math.abs(f) > 0.5f) {
                float preScrollToBeConsumed = this.scrollToBeConsumed;
                Remeasurement remeasurement = getRemeasurement();
                if (remeasurement != null) {
                    remeasurement.forceRemeasure();
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

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d1 A[LOOP:1: B:36:0x00cf->B:37:0x00d1, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void notifyPrefetch(float r19) {
        /*
            r18 = this;
            r0 = r18
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r1 = r0.prefetchState
            boolean r2 = r0.prefetchingEnabled
            if (r2 != 0) goto L_0x0009
            return
        L_0x0009:
            androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo r2 = r18.getLayoutInfo()
            java.util.List r3 = r2.getVisibleItemsInfo()
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r4 = 1
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x0112
            r3 = 0
            int r3 = (r19 > r3 ? 1 : (r19 == r3 ? 0 : -1))
            r5 = 0
            if (r3 >= 0) goto L_0x0023
            r3 = r4
            goto L_0x0024
        L_0x0023:
            r3 = r5
        L_0x0024:
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L_0x0053
            java.util.List r8 = r2.getVisibleItemsInfo()
            java.lang.Object r8 = kotlin.collections.CollectionsKt.last(r8)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r8 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r8
            r9 = 0
            boolean r10 = r18.isVertical$foundation_release()
            if (r10 == 0) goto L_0x003e
            int r10 = r8.getRow()
            goto L_0x0042
        L_0x003e:
            int r10 = r8.getColumn()
        L_0x0042:
            int r10 = r10 + r4
            java.util.List r6 = r2.getVisibleItemsInfo()
            java.lang.Object r6 = kotlin.collections.CollectionsKt.last(r6)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r6 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r6
            int r6 = r6.getIndex()
            int r6 = r6 + r4
            goto L_0x007e
        L_0x0053:
            java.util.List r8 = r2.getVisibleItemsInfo()
            java.lang.Object r8 = kotlin.collections.CollectionsKt.first(r8)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r8 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r8
            r9 = 0
            boolean r10 = r18.isVertical$foundation_release()
            if (r10 == 0) goto L_0x0069
            int r10 = r8.getRow()
            goto L_0x006d
        L_0x0069:
            int r10 = r8.getColumn()
        L_0x006d:
            int r10 = r10 + -1
            java.util.List r6 = r2.getVisibleItemsInfo()
            java.lang.Object r6 = kotlin.collections.CollectionsKt.first(r6)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r6 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r6
            int r6 = r6.getIndex()
            int r6 = r6 - r4
        L_0x007e:
            int r7 = r0.lineToPrefetch
            if (r10 == r7) goto L_0x010d
            if (r6 < 0) goto L_0x008b
            int r7 = r2.getTotalItemsCount()
            if (r6 >= r7) goto L_0x008b
            r5 = r4
        L_0x008b:
            if (r5 == 0) goto L_0x0108
            boolean r5 = r0.wasScrollingForward
            if (r5 == r3) goto L_0x00ad
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle> r5 = r0.currentLinePrefetchHandles
            r7 = 0
            int r8 = r5.getSize()
            if (r8 <= 0) goto L_0x00ac
            r9 = 0
            java.lang.Object[] r11 = r5.getContent()
        L_0x00a0:
            r12 = r11[r9]
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle r12 = (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle) r12
            r13 = 0
            r12.cancel()
            int r9 = r9 + r4
            if (r9 < r8) goto L_0x00a0
        L_0x00ac:
        L_0x00ad:
            r0.wasScrollingForward = r3
            r0.lineToPrefetch = r10
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle> r4 = r0.currentLinePrefetchHandles
            r4.clear()
            kotlin.jvm.functions.Function1 r4 = r18.getPrefetchInfoRetriever$foundation_release()
            int r5 = androidx.compose.foundation.lazy.grid.LineIndex.m988constructorimpl(r10)
            androidx.compose.foundation.lazy.grid.LineIndex r5 = androidx.compose.foundation.lazy.grid.LineIndex.m986boximpl(r5)
            java.lang.Object r4 = r4.invoke(r5)
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            r7 = 0
            int r8 = r4.size()
        L_0x00cf:
            if (r7 >= r8) goto L_0x0103
            java.lang.Object r9 = r4.get(r7)
            r11 = r9
            kotlin.Pair r11 = (kotlin.Pair) r11
            r12 = 0
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle> r13 = r0.currentLinePrefetchHandles
            java.lang.Object r14 = r11.getFirst()
            java.lang.Number r14 = (java.lang.Number) r14
            int r14 = r14.intValue()
            java.lang.Object r15 = r11.getSecond()
            androidx.compose.ui.unit.Constraints r15 = (androidx.compose.ui.unit.Constraints) r15
            r16 = r2
            r17 = r3
            long r2 = r15.m5936unboximpl()
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle r2 = r1.m1031schedulePrefetch0kLqBqw(r14, r2)
            r13.add(r2)
            int r7 = r7 + 1
            r2 = r16
            r3 = r17
            goto L_0x00cf
        L_0x0103:
            r16 = r2
            r17 = r3
            goto L_0x0114
        L_0x0108:
            r16 = r2
            r17 = r3
            goto L_0x0114
        L_0x010d:
            r16 = r2
            r17 = r3
            goto L_0x0114
        L_0x0112:
            r16 = r2
        L_0x0114:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridState.notifyPrefetch(float):void");
    }

    private final void cancelPrefetchIfVisibleItemsChanged(LazyGridLayoutInfo info) {
        int expectedLineToPrefetch;
        if (this.lineToPrefetch != -1 && (!info.getVisibleItemsInfo().isEmpty())) {
            if (this.wasScrollingForward) {
                LazyGridItemInfo it = (LazyGridItemInfo) CollectionsKt.last(info.getVisibleItemsInfo());
                expectedLineToPrefetch = (isVertical$foundation_release() ? it.getRow() : it.getColumn()) + 1;
            } else {
                LazyGridItemInfo it2 = (LazyGridItemInfo) CollectionsKt.first(info.getVisibleItemsInfo());
                expectedLineToPrefetch = (isVertical$foundation_release() ? it2.getRow() : it2.getColumn()) - 1;
            }
            if (this.lineToPrefetch != expectedLineToPrefetch) {
                this.lineToPrefetch = -1;
                MutableVector this_$iv = this.currentLinePrefetchHandles;
                int size$iv = this_$iv.getSize();
                if (size$iv > 0) {
                    int i$iv = 0;
                    Object[] content$iv = this_$iv.getContent();
                    do {
                        ((LazyLayoutPrefetchState.PrefetchHandle) content$iv[i$iv]).cancel();
                        i$iv++;
                    } while (i$iv < size$iv);
                }
                this.currentLinePrefetchHandles.clear();
            }
        }
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyGridState lazyGridState, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lazyGridState.animateScrollToItem(i, i2, continuation);
    }

    public final Object animateScrollToItem(int index, int scrollOffset, Continuation<? super Unit> $completion) {
        Object animateScrollToItem = LazyAnimateScrollKt.animateScrollToItem(this.animateScrollScope, index, scrollOffset, $completion);
        return animateScrollToItem == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToItem : Unit.INSTANCE;
    }

    public final void applyMeasureResult$foundation_release(LazyGridMeasureResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.scrollPosition.updateFromMeasureResult(result);
        this.scrollToBeConsumed -= result.getConsumedScroll();
        this.layoutInfoState.setValue(result);
        setCanScrollForward(result.getCanScrollForward());
        LazyGridMeasuredLine firstVisibleLine = result.getFirstVisibleLine();
        boolean z = false;
        if (!((firstVisibleLine != null ? firstVisibleLine.m969getIndexhA7yfN8() : 0) == 0 && result.getFirstVisibleLineScrollOffset() == 0)) {
            z = true;
        }
        setCanScrollBackward(z);
        this.numMeasurePasses++;
        cancelPrefetchIfVisibleItemsChanged(result);
    }

    public final void updateScrollPositionIfTheFirstItemWasMoved$foundation_release(LazyGridItemProvider itemProvider) {
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(itemProvider);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyGridState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<LazyGridState, ?> getSaver() {
            return LazyGridState.Saver;
        }
    }
}
