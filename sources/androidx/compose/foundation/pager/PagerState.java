package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 y2\u00020\u0001:\u0001yB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J3\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u00032\b\b\u0002\u0010_\u001a\u00020\u00052\u000e\b\u0002\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00050aH@ø\u0001\u0000¢\u0006\u0002\u0010bJ\u0011\u0010c\u001a\u00020]H@ø\u0001\u0000¢\u0006\u0002\u0010dJ\u0010\u0010e\u001a\u00020\u00052\u0006\u0010f\u001a\u00020\u0005H\u0016J\u0015\u0010g\u001a\u00020]2\u0006\u0010h\u001a\u000206H\u0000¢\u0006\u0002\biJB\u0010j\u001a\u00020]2\u0006\u0010k\u001a\u00020l2'\u0010m\u001a#\b\u0001\u0012\u0004\u0012\u00020o\u0012\n\u0012\b\u0012\u0004\u0012\u00020]0p\u0012\u0006\u0012\u0004\u0018\u00010q0n¢\u0006\u0002\brH@ø\u0001\u0000¢\u0006\u0002\u0010sJ#\u0010t\u001a\u00020]2\u0006\u0010^\u001a\u00020\u00032\b\b\u0002\u0010_\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010uJ\r\u0010v\u001a\u00020]H\u0000¢\u0006\u0002\bwJ\f\u0010x\u001a\u00020\u0003*\u00020\u0003H\u0002R+\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038B@BX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u00038FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001c\u0010\nR\u001b\u0010\u001f\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\u00020$8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010!R\u0016\u0010)\u001a\u0004\u0018\u00010\u00188@X\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0014R\u0014\u00102\u001a\u0002038@X\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R/\u00107\u001a\u0004\u0018\u0001062\b\u0010\u0007\u001a\u0004\u0018\u0001068B@BX\u0002¢\u0006\u0012\n\u0004\b<\u0010\u000e\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\nR\u0014\u0010?\u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\nR\u0014\u0010A\u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\nR+\u0010C\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038@@@X\u0002¢\u0006\u0012\n\u0004\bF\u0010\u000e\u001a\u0004\bD\u0010\n\"\u0004\bE\u0010\fR\u0014\u0010G\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\bH\u0010!R\u001b\u0010I\u001a\u00020\u00038FX\u0002¢\u0006\f\n\u0004\bK\u0010\u001e\u001a\u0004\bJ\u0010\nR+\u0010L\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038B@BX\u0002¢\u0006\u0012\n\u0004\bO\u0010\u000e\u001a\u0004\bM\u0010\n\"\u0004\bN\u0010\fR+\u0010P\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00058@@@X\u0002¢\u0006\u0012\n\u0004\bT\u0010\u000e\u001a\u0004\bQ\u0010!\"\u0004\bR\u0010SR\u001b\u0010U\u001a\u00020\u00038FX\u0002¢\u0006\f\n\u0004\bW\u0010\u001e\u001a\u0004\bV\u0010\nR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00180Y8BX\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[\u0002\u0004\n\u0002\b\u0019¨\u0006z"}, d2 = {"Landroidx/compose/foundation/pager/PagerState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initialPage", "", "initialPageOffsetFraction", "", "(IF)V", "<set-?>", "animationTargetPage", "getAnimationTargetPage", "()I", "setAnimationTargetPage", "(I)V", "animationTargetPage$delegate", "Landroidx/compose/runtime/MutableState;", "awaitLazyListStateSet", "Landroidx/compose/foundation/pager/AwaitLazyListStateSet;", "canScrollBackward", "", "getCanScrollBackward", "()Z", "canScrollForward", "getCanScrollForward", "closestPageToSnappedPosition", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "getClosestPageToSnappedPosition", "()Landroidx/compose/foundation/lazy/LazyListItemInfo;", "currentPage", "getCurrentPage", "currentPage$delegate", "Landroidx/compose/runtime/State;", "currentPageOffsetFraction", "getCurrentPageOffsetFraction", "()F", "currentPageOffsetFraction$delegate", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "distanceToSnapPosition", "getDistanceToSnapPosition", "firstVisiblePage", "getFirstVisiblePage$foundation_release", "getInitialPage", "getInitialPageOffsetFraction", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "isScrollInProgress", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getLayoutInfo$foundation_release", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "Landroidx/compose/foundation/lazy/LazyListState;", "lazyListState", "getLazyListState", "()Landroidx/compose/foundation/lazy/LazyListState;", "setLazyListState", "(Landroidx/compose/foundation/lazy/LazyListState;)V", "lazyListState$delegate", "pageAvailableSpace", "getPageAvailableSpace", "pageCount", "getPageCount$foundation_release", "pageSize", "getPageSize$foundation_release", "pageSpacing", "getPageSpacing$foundation_release", "setPageSpacing$foundation_release", "pageSpacing$delegate", "positionThresholdFraction", "getPositionThresholdFraction", "settledPage", "getSettledPage", "settledPage$delegate", "settledPageState", "getSettledPageState", "setSettledPageState", "settledPageState$delegate", "snapRemainingScrollOffset", "getSnapRemainingScrollOffset$foundation_release", "setSnapRemainingScrollOffset$foundation_release", "(F)V", "snapRemainingScrollOffset$delegate", "targetPage", "getTargetPage", "targetPage$delegate", "visiblePages", "", "getVisiblePages", "()Ljava/util/List;", "animateScrollToPage", "", "page", "pageOffsetFraction", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitScrollDependencies", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "loadNewState", "newState", "loadNewState$foundation_release", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToPage", "(IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOnScrollStopped", "updateOnScrollStopped$foundation_release", "coerceInPageRange", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
public final class PagerState implements ScrollableState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Saver<PagerState, ?> Saver = ListSaverKt.listSaver(PagerState$Companion$Saver$1.INSTANCE, PagerState$Companion$Saver$2.INSTANCE);
    private final MutableState animationTargetPage$delegate;
    private final AwaitLazyListStateSet awaitLazyListStateSet;
    private final State currentPage$delegate;
    private final State currentPageOffsetFraction$delegate;
    private final int initialPage;
    private final float initialPageOffsetFraction;
    private final MutableState lazyListState$delegate;
    private final MutableState pageSpacing$delegate;
    private final State settledPage$delegate;
    private final MutableState settledPageState$delegate;
    private final MutableState snapRemainingScrollOffset$delegate;
    private final State targetPage$delegate;

    public PagerState() {
        this(0, 0.0f, 3, (DefaultConstructorMarker) null);
    }

    public PagerState(int initialPage2, float initialPageOffsetFraction2) {
        this.initialPage = initialPage2;
        this.initialPageOffsetFraction = initialPageOffsetFraction2;
        double d = (double) initialPageOffsetFraction2;
        if (-0.5d <= d && d <= 0.5d) {
            this.snapRemainingScrollOffset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
            this.lazyListState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            this.pageSpacing$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
            this.awaitLazyListStateSet = new AwaitLazyListStateSet();
            this.currentPage$delegate = SnapshotStateKt.derivedStateOf(new PagerState$currentPage$2(this));
            this.animationTargetPage$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(-1, (SnapshotMutationPolicy) null, 2, (Object) null);
            this.settledPageState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(initialPage2), (SnapshotMutationPolicy) null, 2, (Object) null);
            this.settledPage$delegate = SnapshotStateKt.derivedStateOf(new PagerState$settledPage$2(this));
            this.targetPage$delegate = SnapshotStateKt.derivedStateOf(new PagerState$targetPage$2(this));
            this.currentPageOffsetFraction$delegate = SnapshotStateKt.derivedStateOf(new PagerState$currentPageOffsetFraction$2(this));
            return;
        }
        throw new IllegalArgumentException(("initialPageOffsetFraction " + initialPageOffsetFraction2 + " is not within the range -0.5 to 0.5").toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagerState(int i, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0.0f : f);
    }

    public final int getInitialPage() {
        return this.initialPage;
    }

    public final float getInitialPageOffsetFraction() {
        return this.initialPageOffsetFraction;
    }

    public final float getSnapRemainingScrollOffset$foundation_release() {
        return ((Number) this.snapRemainingScrollOffset$delegate.getValue()).floatValue();
    }

    public final void setSnapRemainingScrollOffset$foundation_release(float f) {
        this.snapRemainingScrollOffset$delegate.setValue(Float.valueOf(f));
    }

    private final LazyListState getLazyListState() {
        return (LazyListState) this.lazyListState$delegate.getValue();
    }

    private final void setLazyListState(LazyListState lazyListState) {
        this.lazyListState$delegate.setValue(lazyListState);
    }

    public final int getPageSpacing$foundation_release() {
        return ((Number) this.pageSpacing$delegate.getValue()).intValue();
    }

    public final void setPageSpacing$foundation_release(int i) {
        this.pageSpacing$delegate.setValue(Integer.valueOf(i));
    }

    public final int getPageSize$foundation_release() {
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.firstOrNull(getVisiblePages());
        if (lazyListItemInfo != null) {
            return lazyListItemInfo.getSize();
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getDensity$foundation_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.ui.unit.Density getDensity() {
        /*
            r1 = this;
            androidx.compose.foundation.lazy.LazyListState r0 = r1.getLazyListState()
            if (r0 == 0) goto L_0x000c
            androidx.compose.ui.unit.Density r0 = r0.getDensity$foundation_release()
            if (r0 != 0) goto L_0x0012
        L_0x000c:
            androidx.compose.foundation.pager.PagerStateKt$UnitDensity$1 r0 = androidx.compose.foundation.pager.PagerStateKt.UnitDensity
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.getDensity():androidx.compose.ui.unit.Density");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getLayoutInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.foundation.lazy.LazyListLayoutInfo getLayoutInfo$foundation_release() {
        /*
            r1 = this;
            androidx.compose.foundation.lazy.LazyListState r0 = r1.getLazyListState()
            if (r0 == 0) goto L_0x000c
            androidx.compose.foundation.lazy.LazyListLayoutInfo r0 = r0.getLayoutInfo()
            if (r0 != 0) goto L_0x0012
        L_0x000c:
            androidx.compose.foundation.pager.PagerStateKt$EmptyLayoutInfo$1 r0 = androidx.compose.foundation.pager.PagerStateKt.EmptyLayoutInfo
            androidx.compose.foundation.lazy.LazyListLayoutInfo r0 = (androidx.compose.foundation.lazy.LazyListLayoutInfo) r0
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.getLayoutInfo$foundation_release():androidx.compose.foundation.lazy.LazyListLayoutInfo");
    }

    private final List<LazyListItemInfo> getVisiblePages() {
        return getLayoutInfo$foundation_release().getVisibleItemsInfo();
    }

    /* access modifiers changed from: private */
    public final int getPageAvailableSpace() {
        return getPageSize$foundation_release() + getPageSpacing$foundation_release();
    }

    /* access modifiers changed from: private */
    public final float getPositionThresholdFraction() {
        return Math.min(getDensity().m5967toPx0680j_4(PagerStateKt.getDefaultPositionThreshold()), ((float) getPageSize$foundation_release()) / 2.0f) / ((float) getPageSize$foundation_release());
    }

    public final int getPageCount$foundation_release() {
        return getLayoutInfo$foundation_release().getTotalItemsCount();
    }

    /* access modifiers changed from: private */
    public final LazyListItemInfo getClosestPageToSnappedPosition() {
        Object maxElem$iv;
        List $this$fastMaxBy$iv = getVisiblePages();
        if ($this$fastMaxBy$iv.isEmpty()) {
            maxElem$iv = null;
        } else {
            maxElem$iv = $this$fastMaxBy$iv.get(0);
            float maxValue$iv = -Math.abs(LazyListSnapLayoutInfoProviderKt.calculateDistanceToDesiredSnapPosition(getDensity(), getLayoutInfo$foundation_release(), (LazyListItemInfo) maxElem$iv, PagerStateKt.getSnapAlignmentStartToStart()));
            int i$iv = 1;
            int lastIndex = CollectionsKt.getLastIndex($this$fastMaxBy$iv);
            if (1 <= lastIndex) {
                while (true) {
                    Object obj = $this$fastMaxBy$iv.get(i$iv);
                    float v$iv = -Math.abs(LazyListSnapLayoutInfoProviderKt.calculateDistanceToDesiredSnapPosition(getDensity(), getLayoutInfo$foundation_release(), (LazyListItemInfo) obj, PagerStateKt.getSnapAlignmentStartToStart()));
                    if (Float.compare(maxValue$iv, v$iv) < 0) {
                        maxElem$iv = obj;
                        maxValue$iv = v$iv;
                    }
                    if (i$iv == lastIndex) {
                        break;
                    }
                    i$iv++;
                }
            }
        }
        return (LazyListItemInfo) maxElem$iv;
    }

    public final LazyListItemInfo getFirstVisiblePage$foundation_release() {
        LazyListItemInfo it;
        boolean z;
        List $this$lastOrNull$iv = getVisiblePages();
        ListIterator iterator$iv = $this$lastOrNull$iv.listIterator($this$lastOrNull$iv.size());
        while (true) {
            if (!iterator$iv.hasPrevious()) {
                it = null;
                break;
            }
            it = iterator$iv.previous();
            if (LazyListSnapLayoutInfoProviderKt.calculateDistanceToDesiredSnapPosition(getDensity(), getLayoutInfo$foundation_release(), it, PagerStateKt.getSnapAlignmentStartToStart()) <= 0.0f) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        return it;
    }

    private final float getDistanceToSnapPosition() {
        LazyListItemInfo it = getClosestPageToSnappedPosition();
        if (it != null) {
            return LazyListSnapLayoutInfoProviderKt.calculateDistanceToDesiredSnapPosition(getDensity(), getLayoutInfo$foundation_release(), it, PagerStateKt.getSnapAlignmentStartToStart());
        }
        return 0.0f;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getInteractionSource();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.foundation.interaction.InteractionSource getInteractionSource() {
        /*
            r1 = this;
            androidx.compose.foundation.lazy.LazyListState r0 = r1.getLazyListState()
            if (r0 == 0) goto L_0x000c
            androidx.compose.foundation.interaction.InteractionSource r0 = r0.getInteractionSource()
            if (r0 != 0) goto L_0x0012
        L_0x000c:
            androidx.compose.foundation.pager.PagerStateKt$EmptyInteractionSources$1 r0 = androidx.compose.foundation.pager.PagerStateKt.EmptyInteractionSources
            androidx.compose.foundation.interaction.InteractionSource r0 = (androidx.compose.foundation.interaction.InteractionSource) r0
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.getInteractionSource():androidx.compose.foundation.interaction.InteractionSource");
    }

    public final int getCurrentPage() {
        return ((Number) this.currentPage$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public final int getAnimationTargetPage() {
        return ((Number) this.animationTargetPage$delegate.getValue()).intValue();
    }

    private final void setAnimationTargetPage(int i) {
        this.animationTargetPage$delegate.setValue(Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    public final int getSettledPageState() {
        return ((Number) this.settledPageState$delegate.getValue()).intValue();
    }

    private final void setSettledPageState(int i) {
        this.settledPageState$delegate.setValue(Integer.valueOf(i));
    }

    public final int getSettledPage() {
        return ((Number) this.settledPage$delegate.getValue()).intValue();
    }

    public final int getTargetPage() {
        return ((Number) this.targetPage$delegate.getValue()).intValue();
    }

    public final float getCurrentPageOffsetFraction() {
        return ((Number) this.currentPageOffsetFraction$delegate.getValue()).floatValue();
    }

    public static /* synthetic */ Object scrollToPage$default(PagerState pagerState, int i, float f, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        return pagerState.scrollToPage(i, f, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object scrollToPage(int r12, float r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof androidx.compose.foundation.pager.PagerState$scrollToPage$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            androidx.compose.foundation.pager.PagerState$scrollToPage$1 r0 = (androidx.compose.foundation.pager.PagerState$scrollToPage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.pager.PagerState$scrollToPage$1 r0 = new androidx.compose.foundation.pager.PagerState$scrollToPage$1
            r0.<init>(r11, r14)
        L_0x0019:
            r14 = r0
            java.lang.Object r0 = r14.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r14.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x003e;
                case 1: goto L_0x0032;
                case 2: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x008a
        L_0x0032:
            float r12 = r14.F$0
            int r13 = r14.I$0
            java.lang.Object r2 = r14.L$0
            androidx.compose.foundation.pager.PagerState r2 = (androidx.compose.foundation.pager.PagerState) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0057
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r11
            r4 = 0
            r14.L$0 = r2
            r14.I$0 = r12
            r14.F$0 = r13
            r14.label = r3
            java.lang.Object r4 = r2.awaitScrollDependencies(r14)
            if (r4 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r10 = r13
            r13 = r12
            r12 = r10
        L_0x0057:
            double r4 = (double) r12
            r6 = -4620693217682128896(0xbfe0000000000000, double:-0.5)
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r7 = 0
            if (r6 > 0) goto L_0x0066
            r8 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 > 0) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r3 = r7
        L_0x0067:
            if (r3 == 0) goto L_0x0099
            int r13 = r2.coerceInPageRange(r13)
            int r3 = r2.getPageAvailableSpace()
            float r3 = (float) r3
            float r3 = r3 * r12
            int r12 = kotlin.math.MathKt.roundToInt((float) r3)
            androidx.compose.foundation.lazy.LazyListState r2 = r2.getLazyListState()
            if (r2 == 0) goto L_0x008d
            r3 = 0
            r14.L$0 = r3
            r3 = 2
            r14.label = r3
            java.lang.Object r12 = r2.scrollToItem(r13, r12, r14)
            if (r12 != r1) goto L_0x008a
            return r1
        L_0x008a:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x008d:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Required value was null."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0099:
            r13 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "pageOffsetFraction "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r12)
            java.lang.String r2 = " is not within the range -0.5 to 0.5"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r12 = r1.toString()
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r12 = r12.toString()
            r13.<init>(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.scrollToPage(int, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object animateScrollToPage$default(PagerState pagerState, int i, float f, AnimationSpec animationSpec, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        if ((i2 & 4) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        return pagerState.animateScrollToPage(i, f, animationSpec, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0090, code lost:
        r6 = (double) r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0096, code lost:
        if (-0.5d > r6) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009c, code lost:
        if (r6 > 0.5d) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009f, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a0, code lost:
        if (r4 == false) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a2, code lost:
        r3 = r14.getCurrentPage();
        r15 = r14.coerceInPageRange(r5);
        r14.setAnimationTargetPage(r15);
        r4 = ((androidx.compose.foundation.lazy.LazyListItemInfo) kotlin.collections.CollectionsKt.first(r14.getVisiblePages())).getIndex();
        r6 = ((androidx.compose.foundation.lazy.LazyListItemInfo) kotlin.collections.CollectionsKt.last(r14.getVisiblePages())).getIndex();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cd, code lost:
        if (r5 <= r14.getCurrentPage()) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cf, code lost:
        if (r5 > r6) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d5, code lost:
        if (r5 >= r14.getCurrentPage()) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d7, code lost:
        if (r5 >= r4) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e3, code lost:
        if (java.lang.Math.abs(r5 - r14.getCurrentPage()) < 3) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e9, code lost:
        if (r5 <= r14.getCurrentPage()) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00eb, code lost:
        r4 = kotlin.ranges.RangesKt.coerceAtLeast(r5 - r14.getVisiblePages().size(), r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00fa, code lost:
        r4 = kotlin.ranges.RangesKt.coerceAtMost(r14.getVisiblePages().size(), r3) + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0107, code lost:
        r8 = r4;
        r3 = r14.getLazyListState();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010f, code lost:
        if (r3 == null) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0111, code lost:
        r0.L$0 = r14;
        r0.L$1 = r13;
        r0.F$0 = r12;
        r0.I$0 = r15;
        r0.I$1 = r8;
        r0.label = 2;
        r17 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x012c, code lost:
        if (androidx.compose.foundation.lazy.LazyListState.scrollToItem$default(r3, r8, 0, r0, 2, (java.lang.Object) null) != r9) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x012e, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x012f, code lost:
        r5 = r12;
        r6 = r13;
        r7 = r14;
        r4 = r15;
        r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0135, code lost:
        r8 = r3;
        r15 = r4;
        r12 = r5;
        r13 = r6;
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0144, code lost:
        throw new java.lang.IllegalArgumentException("Required value was null.".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0145, code lost:
        r8 = r3;
        r3 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0147, code lost:
        r5 = ((float) ((r15 * r3.getPageAvailableSpace()) - (r8 * r3.getPageAvailableSpace()))) + (r3.getDistanceToSnapPosition() + (((float) r3.getPageAvailableSpace()) * r12));
        r4 = r3.getLazyListState();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0168, code lost:
        if (r4 == null) goto L_0x0181;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x016a, code lost:
        r0.L$0 = r3;
        r0.L$1 = null;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0177, code lost:
        if (androidx.compose.foundation.gestures.ScrollExtensionsKt.animateScrollBy(r4, r5, r13, r0) != r9) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0179, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x017a, code lost:
        r3.setAnimationTargetPage(-1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0180, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x018a, code lost:
        throw new java.lang.IllegalArgumentException("Required value was null.".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01af, code lost:
        throw new java.lang.IllegalArgumentException(("pageOffsetFraction " + r12 + " is not within the range -0.5 to 0.5").toString());
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animateScrollToPage(int r19, float r20, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            r18 = this;
            r0 = r22
            boolean r1 = r0 instanceof androidx.compose.foundation.pager.PagerState$animateScrollToPage$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.foundation.pager.PagerState$animateScrollToPage$1 r1 = (androidx.compose.foundation.pager.PagerState$animateScrollToPage$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r18
            goto L_0x0021
        L_0x0019:
            androidx.compose.foundation.pager.PagerState$animateScrollToPage$1 r1 = new androidx.compose.foundation.pager.PagerState$animateScrollToPage$1
            r2 = r18
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r1 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            java.lang.String r10 = "Required value was null."
            r11 = 3
            r4 = 1
            switch(r3) {
                case 0: goto L_0x0067;
                case 1: goto L_0x0054;
                case 2: goto L_0x0041;
                case 3: goto L_0x0038;
                default: goto L_0x0030;
            }
        L_0x0030:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0038:
            java.lang.Object r3 = r0.L$0
            androidx.compose.foundation.pager.PagerState r3 = (androidx.compose.foundation.pager.PagerState) r3
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x017a
        L_0x0041:
            int r3 = r0.I$1
            int r4 = r0.I$0
            float r5 = r0.F$0
            java.lang.Object r6 = r0.L$1
            androidx.compose.animation.core.AnimationSpec r6 = (androidx.compose.animation.core.AnimationSpec) r6
            java.lang.Object r7 = r0.L$0
            androidx.compose.foundation.pager.PagerState r7 = (androidx.compose.foundation.pager.PagerState) r7
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0135
        L_0x0054:
            float r3 = r0.F$0
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$1
            androidx.compose.animation.core.AnimationSpec r6 = (androidx.compose.animation.core.AnimationSpec) r6
            java.lang.Object r7 = r0.L$0
            androidx.compose.foundation.pager.PagerState r7 = (androidx.compose.foundation.pager.PagerState) r7
            kotlin.ResultKt.throwOnFailure(r1)
            r12 = r3
            r13 = r6
            r14 = r7
            goto L_0x0090
        L_0x0067:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r18
            r5 = r20
            r6 = r19
            r7 = r21
            int r8 = r3.getCurrentPage()
            if (r6 != r8) goto L_0x007b
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x007b:
            r0.L$0 = r3
            r0.L$1 = r7
            r0.I$0 = r6
            r0.F$0 = r5
            r0.label = r4
            java.lang.Object r8 = r3.awaitScrollDependencies(r0)
            if (r8 != r9) goto L_0x008c
            return r9
        L_0x008c:
            r14 = r3
            r12 = r5
            r5 = r6
            r13 = r7
        L_0x0090:
            double r6 = (double) r12
            r15 = -4620693217682128896(0xbfe0000000000000, double:-0.5)
            int r3 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1))
            r8 = 0
            if (r3 > 0) goto L_0x009f
            r15 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r3 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r3 > 0) goto L_0x009f
            goto L_0x00a0
        L_0x009f:
            r4 = r8
        L_0x00a0:
            if (r4 == 0) goto L_0x018b
            int r3 = r14.getCurrentPage()
            int r15 = r14.coerceInPageRange(r5)
            r14.setAnimationTargetPage(r15)
            java.util.List r4 = r14.getVisiblePages()
            java.lang.Object r4 = kotlin.collections.CollectionsKt.first(r4)
            androidx.compose.foundation.lazy.LazyListItemInfo r4 = (androidx.compose.foundation.lazy.LazyListItemInfo) r4
            int r4 = r4.getIndex()
            java.util.List r6 = r14.getVisiblePages()
            java.lang.Object r6 = kotlin.collections.CollectionsKt.last(r6)
            androidx.compose.foundation.lazy.LazyListItemInfo r6 = (androidx.compose.foundation.lazy.LazyListItemInfo) r6
            int r6 = r6.getIndex()
            int r7 = r14.getCurrentPage()
            if (r5 <= r7) goto L_0x00d1
            if (r5 > r6) goto L_0x00d9
        L_0x00d1:
            int r6 = r14.getCurrentPage()
            if (r5 >= r6) goto L_0x0145
            if (r5 >= r4) goto L_0x0145
        L_0x00d9:
            int r4 = r14.getCurrentPage()
            int r4 = r5 - r4
            int r4 = java.lang.Math.abs(r4)
            if (r4 < r11) goto L_0x0145
            int r4 = r14.getCurrentPage()
            if (r5 <= r4) goto L_0x00fa
            java.util.List r4 = r14.getVisiblePages()
            int r4 = r4.size()
            int r4 = r5 - r4
            int r4 = kotlin.ranges.RangesKt.coerceAtLeast((int) r4, (int) r3)
            goto L_0x0107
        L_0x00fa:
            java.util.List r4 = r14.getVisiblePages()
            int r4 = r4.size()
            int r4 = kotlin.ranges.RangesKt.coerceAtMost((int) r4, (int) r3)
            int r4 = r4 + r5
        L_0x0107:
            r8 = r4
            r3 = 0
            androidx.compose.foundation.lazy.LazyListState r3 = r14.getLazyListState()
            if (r3 == 0) goto L_0x013b
            r5 = 0
            r7 = 2
            r16 = 0
            r0.L$0 = r14
            r0.L$1 = r13
            r0.F$0 = r12
            r0.I$0 = r15
            r0.I$1 = r8
            r4 = 2
            r0.label = r4
            r4 = r8
            r6 = r0
            r17 = r8
            r8 = r16
            java.lang.Object r3 = androidx.compose.foundation.lazy.LazyListState.scrollToItem$default(r3, r4, r5, r6, r7, r8)
            if (r3 != r9) goto L_0x012f
            return r9
        L_0x012f:
            r5 = r12
            r6 = r13
            r7 = r14
            r4 = r15
            r3 = r17
        L_0x0135:
            r8 = r3
            r15 = r4
            r12 = r5
            r13 = r6
            r3 = r7
            goto L_0x0147
        L_0x013b:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = r10.toString()
            r3.<init>(r4)
            throw r3
        L_0x0145:
            r8 = r3
            r3 = r14
        L_0x0147:
            int r4 = r3.getPageAvailableSpace()
            int r15 = r15 * r4
            int r4 = r3.getPageAvailableSpace()
            int r8 = r8 * r4
            float r4 = r3.getDistanceToSnapPosition()
            int r5 = r3.getPageAvailableSpace()
            float r5 = (float) r5
            float r5 = r5 * r12
            float r4 = r4 + r5
            int r5 = r15 - r8
            float r5 = (float) r5
            float r5 = r5 + r4
            r4 = 0
            androidx.compose.foundation.lazy.LazyListState r4 = r3.getLazyListState()
            if (r4 == 0) goto L_0x0181
            androidx.compose.foundation.gestures.ScrollableState r4 = (androidx.compose.foundation.gestures.ScrollableState) r4
            r0.L$0 = r3
            r6 = 0
            r0.L$1 = r6
            r0.label = r11
            java.lang.Object r4 = androidx.compose.foundation.gestures.ScrollExtensionsKt.animateScrollBy(r4, r5, r13, r0)
            if (r4 != r9) goto L_0x017a
            return r9
        L_0x017a:
            r4 = -1
            r3.setAnimationTargetPage(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0181:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r6 = r10.toString()
            r4.<init>(r6)
            throw r4
        L_0x018b:
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "pageOffsetFraction "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r12)
            java.lang.String r5 = " is not within the range -0.5 to 0.5"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r3 = r4.toString()
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r3 = r3.toString()
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.animateScrollToPage(int, float, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object awaitScrollDependencies(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.pager.PagerState$awaitScrollDependencies$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            androidx.compose.foundation.pager.PagerState$awaitScrollDependencies$1 r0 = (androidx.compose.foundation.pager.PagerState$awaitScrollDependencies$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.pager.PagerState$awaitScrollDependencies$1 r0 = new androidx.compose.foundation.pager.PagerState$awaitScrollDependencies$1
            r0.<init>(r5, r6)
        L_0x0019:
            r6 = r0
            java.lang.Object r0 = r6.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r6.label
            switch(r2) {
                case 0: goto L_0x0039;
                case 1: goto L_0x0031;
                case 2: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0063
        L_0x0031:
            java.lang.Object r2 = r6.L$0
            androidx.compose.foundation.pager.PagerState r2 = (androidx.compose.foundation.pager.PagerState) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x004b
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r5
            androidx.compose.foundation.pager.AwaitLazyListStateSet r3 = r2.awaitLazyListStateSet
            r6.L$0 = r2
            r4 = 1
            r6.label = r4
            java.lang.Object r3 = r3.waitFinalLazyListSetting(r6)
            if (r3 != r1) goto L_0x004b
            return r1
        L_0x004b:
            androidx.compose.foundation.lazy.LazyListState r2 = r2.getLazyListState()
            if (r2 == 0) goto L_0x0066
            androidx.compose.foundation.lazy.AwaitFirstLayoutModifier r2 = r2.getAwaitLayoutModifier$foundation_release()
            r3 = 0
            r6.L$0 = r3
            r3 = 2
            r6.label = r3
            java.lang.Object r2 = r2.waitForFirstLayout(r6)
            if (r2 != r1) goto L_0x0063
            return r1
        L_0x0063:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0066:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Required value was null."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.awaitScrollDependencies(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object scroll(MutatePriority scrollPriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        LazyListState lazyListState = getLazyListState();
        if (lazyListState == null) {
            return Unit.INSTANCE;
        }
        Object scroll = lazyListState.scroll(scrollPriority, block, $completion);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    public float dispatchRawDelta(float delta) {
        LazyListState lazyListState = getLazyListState();
        if (lazyListState != null) {
            return lazyListState.dispatchRawDelta(delta);
        }
        return 0.0f;
    }

    public boolean isScrollInProgress() {
        LazyListState lazyListState = getLazyListState();
        if (lazyListState != null) {
            return lazyListState.isScrollInProgress();
        }
        return false;
    }

    public boolean getCanScrollForward() {
        LazyListState lazyListState = getLazyListState();
        if (lazyListState != null) {
            return lazyListState.getCanScrollForward();
        }
        return true;
    }

    public boolean getCanScrollBackward() {
        LazyListState lazyListState = getLazyListState();
        if (lazyListState != null) {
            return lazyListState.getCanScrollBackward();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final int coerceInPageRange(int $this$coerceInPageRange) {
        if (getPageCount$foundation_release() > 0) {
            return RangesKt.coerceIn($this$coerceInPageRange, 0, getPageCount$foundation_release() - 1);
        }
        return 0;
    }

    public final void updateOnScrollStopped$foundation_release() {
        setSettledPageState(getCurrentPage());
    }

    public final void loadNewState$foundation_release(LazyListState newState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        setLazyListState(newState);
        this.awaitLazyListStateSet.onStateLoaded();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/pager/PagerState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/pager/PagerState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PagerState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<PagerState, ?> getSaver() {
            return PagerState.Saver;
        }
    }
}
