package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyList.kt */
final class LazyListKt$rememberLazyListMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult> {
    final /* synthetic */ LazyListBeyondBoundsInfo $beyondBoundsInfo;
    final /* synthetic */ int $beyondBoundsItemCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ LazyListItemProvider $itemProvider;
    final /* synthetic */ LazyListItemPlacementAnimator $placementAnimator;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListKt$rememberLazyListMeasurePolicy$1$1(boolean z, PaddingValues paddingValues, boolean z2, LazyListState lazyListState, LazyListItemProvider lazyListItemProvider, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, int i, Alignment.Horizontal horizontal2, Alignment.Vertical vertical2) {
        super(2);
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$state = lazyListState;
        this.$itemProvider = lazyListItemProvider;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$placementAnimator = lazyListItemPlacementAnimator;
        this.$beyondBoundsInfo = lazyListBeyondBoundsInfo;
        this.$beyondBoundsItemCount = i;
        this.$horizontalAlignment = horizontal2;
        this.$verticalAlignment = vertical2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m900invoke0kLqBqw((LazyLayoutMeasureScope) p1, ((Constraints) p2).m5936unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyListMeasureResult m900invoke0kLqBqw(LazyLayoutMeasureScope $this$null, long containerConstraints) {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        long visualItemOffset;
        int firstVisibleScrollOffset;
        LazyLayoutMeasureScope lazyLayoutMeasureScope = $this$null;
        long j = containerConstraints;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
        CheckScrollableContainerConstraintsKt.m469checkScrollableContainerConstraintsK40F9xA(j, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        if (this.$isVertical) {
            i = lazyLayoutMeasureScope.m5961roundToPx0680j_4(this.$contentPadding.m771calculateLeftPaddingu2uoSUM($this$null.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope.m5961roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, $this$null.getLayoutDirection()));
        }
        int startPadding = i;
        if (this.$isVertical) {
            i2 = lazyLayoutMeasureScope.m5961roundToPx0680j_4(this.$contentPadding.m772calculateRightPaddingu2uoSUM($this$null.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope.m5961roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, $this$null.getLayoutDirection()));
        }
        int endPadding = i2;
        int topPadding = lazyLayoutMeasureScope.m5961roundToPx0680j_4(this.$contentPadding.m773calculateTopPaddingD9Ej5fM());
        int bottomPadding = lazyLayoutMeasureScope.m5961roundToPx0680j_4(this.$contentPadding.m770calculateBottomPaddingD9Ej5fM());
        int totalVerticalPadding = topPadding + bottomPadding;
        int totalHorizontalPadding = startPadding + endPadding;
        boolean z = this.$isVertical;
        int totalMainAxisPadding = z ? totalVerticalPadding : totalHorizontalPadding;
        if (z && !this.$reverseLayout) {
            i3 = topPadding;
        } else if (z && this.$reverseLayout) {
            i3 = bottomPadding;
        } else if (z || this.$reverseLayout) {
            i3 = endPadding;
        } else {
            i3 = startPadding;
        }
        int beforeContentPadding = i3;
        int afterContentPadding = totalMainAxisPadding - beforeContentPadding;
        long contentConstraints = ConstraintsKt.m5946offsetNN6EwU(j, -totalHorizontalPadding, -totalVerticalPadding);
        this.$state.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(this.$itemProvider);
        this.$state.setDensity$foundation_release(lazyLayoutMeasureScope);
        this.$itemProvider.getItemScope().setMaxSize(Constraints.m5930getMaxWidthimpl(contentConstraints), Constraints.m5929getMaxHeightimpl(contentConstraints));
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical != null) {
                f = vertical.m699getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal != null) {
                f = horizontal.m685getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        float spaceBetweenItemsDp = f;
        int spaceBetweenItems = lazyLayoutMeasureScope.m5961roundToPx0680j_4(spaceBetweenItemsDp);
        int itemsCount = this.$itemProvider.getItemCount();
        if (this.$isVertical) {
            i4 = Constraints.m5929getMaxHeightimpl(containerConstraints) - totalVerticalPadding;
        } else {
            i4 = Constraints.m5930getMaxWidthimpl(containerConstraints) - totalHorizontalPadding;
        }
        int mainAxisAvailableSize = i4;
        if (!this.$reverseLayout || mainAxisAvailableSize > 0) {
            visualItemOffset = IntOffsetKt.IntOffset(startPadding, topPadding);
        } else {
            boolean z2 = this.$isVertical;
            visualItemOffset = IntOffsetKt.IntOffset(z2 ? startPadding : startPadding + mainAxisAvailableSize, z2 ? topPadding + mainAxisAvailableSize : topPadding);
        }
        float f2 = spaceBetweenItemsDp;
        int totalHorizontalPadding2 = totalHorizontalPadding;
        int totalVerticalPadding2 = totalVerticalPadding;
        int i5 = topPadding;
        int i6 = startPadding;
        LazyMeasuredItemProvider lazyMeasuredItemProvider = new LazyMeasuredItemProvider(contentConstraints, this.$isVertical, this.$itemProvider, $this$null, new LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(itemsCount, spaceBetweenItems, $this$null, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$reverseLayout, beforeContentPadding, afterContentPadding, this.$placementAnimator, visualItemOffset), (DefaultConstructorMarker) null);
        this.$state.m916setPremeasureConstraintsBRTryo0$foundation_release(lazyMeasuredItemProvider.m918getChildConstraintsmsEJaDk());
        Snapshot.Companion this_$iv = Snapshot.Companion;
        LazyListState lazyListState = this.$state;
        Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
        Snapshot this_$iv$iv = snapshot$iv;
        try {
            Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
            try {
                int firstVisibleItemIndex = DataIndex.m883constructorimpl(lazyListState.getFirstVisibleItemIndex());
                try {
                    firstVisibleScrollOffset = lazyListState.getFirstVisibleItemScrollOffset();
                    try {
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        int i7 = firstVisibleItemIndex;
                        int i8 = firstVisibleScrollOffset;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    int i9 = firstVisibleItemIndex;
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    throw th;
                }
                try {
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    snapshot$iv.dispose();
                    final LazyLayoutMeasureScope lazyLayoutMeasureScope2 = $this$null;
                    final long j2 = containerConstraints;
                    final int i10 = totalHorizontalPadding2;
                    final int i11 = totalVerticalPadding2;
                    LazyListMeasureResult it = LazyListMeasureKt.m906measureLazyListHh3qtAg(itemsCount, this.$itemProvider, lazyMeasuredItemProvider, mainAxisAvailableSize, beforeContentPadding, afterContentPadding, spaceBetweenItems, firstVisibleItemIndex, firstVisibleScrollOffset, this.$state.getScrollToBeConsumed$foundation_release(), contentConstraints, this.$isVertical, this.$itemProvider.getHeaderIndexes(), this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, $this$null, this.$placementAnimator, this.$beyondBoundsInfo, this.$beyondBoundsItemCount, this.$state.getPinnedItems$foundation_release(), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                            return invoke(((Number) p1).intValue(), ((Number) p2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) p3);
                        }

                        public final MeasureResult invoke(int width, int height, Function1<? super Placeable.PlacementScope, Unit> placement) {
                            Intrinsics.checkNotNullParameter(placement, "placement");
                            return lazyLayoutMeasureScope2.layout(ConstraintsKt.m5944constrainWidthK40F9xA(j2, i10 + width), ConstraintsKt.m5943constrainHeightK40F9xA(j2, i11 + height), MapsKt.emptyMap(), placement);
                        }
                    });
                    this.$state.applyMeasureResult$foundation_release(it);
                    return it;
                } catch (Throwable th3) {
                    th = th3;
                    int i12 = firstVisibleItemIndex;
                    int i13 = firstVisibleScrollOffset;
                    snapshot$iv.dispose();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                this_$iv$iv.restoreCurrent(previous$iv$iv);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            snapshot$iv.dispose();
            throw th;
        }
    }
}
