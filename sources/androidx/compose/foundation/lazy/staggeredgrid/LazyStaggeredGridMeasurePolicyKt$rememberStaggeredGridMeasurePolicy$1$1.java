package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasurePolicy.kt */
final class LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ float $crossAxisSpacing;
    final /* synthetic */ LazyStaggeredGridItemProvider $itemProvider;
    final /* synthetic */ float $mainAxisSpacing;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ Function2<Density, Constraints, int[]> $slotSizesSums;
    final /* synthetic */ LazyStaggeredGridState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1(Orientation orientation, Function2<? super Density, ? super Constraints, int[]> function2, LazyStaggeredGridState lazyStaggeredGridState, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, PaddingValues paddingValues, boolean z, float f, float f2) {
        super(2);
        this.$orientation = orientation;
        this.$slotSizesSums = function2;
        this.$state = lazyStaggeredGridState;
        this.$itemProvider = lazyStaggeredGridItemProvider;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$mainAxisSpacing = f;
        this.$crossAxisSpacing = f2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m1053invoke0kLqBqw((LazyLayoutMeasureScope) p1, ((Constraints) p2).m5936unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyStaggeredGridMeasureResult m1053invoke0kLqBqw(LazyLayoutMeasureScope $this$null, long constraints) {
        long contentOffset;
        LazyLayoutMeasureScope lazyLayoutMeasureScope = $this$null;
        long j = constraints;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
        CheckScrollableContainerConstraintsKt.m469checkScrollableContainerConstraintsK40F9xA(j, this.$orientation);
        int[] resolvedSlotSums = this.$slotSizesSums.invoke(lazyLayoutMeasureScope, Constraints.m5918boximpl(constraints));
        boolean isVertical = this.$orientation == Orientation.Vertical;
        this.$state.setLaneWidthsPrefixSum$foundation_release(resolvedSlotSums);
        this.$state.setVertical$foundation_release(isVertical);
        this.$state.setSpanProvider$foundation_release(this.$itemProvider.getSpanProvider());
        int beforeContentPadding = lazyLayoutMeasureScope.m5961roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.beforePadding(this.$contentPadding, this.$orientation, this.$reverseLayout, $this$null.getLayoutDirection()));
        int afterContentPadding = lazyLayoutMeasureScope.m5961roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.afterPadding(this.$contentPadding, this.$orientation, this.$reverseLayout, $this$null.getLayoutDirection()));
        int startContentPadding = lazyLayoutMeasureScope.m5961roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.startPadding(this.$contentPadding, this.$orientation, $this$null.getLayoutDirection()));
        int mainAxisAvailableSize = ((isVertical ? Constraints.m5929getMaxHeightimpl(constraints) : Constraints.m5930getMaxWidthimpl(constraints)) - beforeContentPadding) - afterContentPadding;
        if (isVertical) {
            contentOffset = IntOffsetKt.IntOffset(startContentPadding, beforeContentPadding);
        } else {
            contentOffset = IntOffsetKt.IntOffset(beforeContentPadding, startContentPadding);
        }
        PaddingValues $this$invoke_0kLqBqw_u24lambda_u240 = this.$contentPadding;
        int horizontalPadding = lazyLayoutMeasureScope.m5961roundToPx0680j_4(Dp.m5986constructorimpl(PaddingKt.calculateStartPadding($this$invoke_0kLqBqw_u24lambda_u240, $this$null.getLayoutDirection()) + PaddingKt.calculateEndPadding($this$invoke_0kLqBqw_u24lambda_u240, $this$null.getLayoutDirection())));
        PaddingValues $this$invoke_0kLqBqw_u24lambda_u241 = this.$contentPadding;
        int verticalPadding = lazyLayoutMeasureScope.m5961roundToPx0680j_4(Dp.m5986constructorimpl($this$invoke_0kLqBqw_u24lambda_u241.m773calculateTopPaddingD9Ej5fM() + $this$invoke_0kLqBqw_u24lambda_u241.m770calculateBottomPaddingD9Ej5fM()));
        int i = verticalPadding;
        int i2 = horizontalPadding;
        int i3 = startContentPadding;
        boolean z = isVertical;
        int[] iArr = resolvedSlotSums;
        LazyStaggeredGridMeasureResult it = LazyStaggeredGridMeasureKt.m1051measureStaggeredGridBTfHGGE($this$null, this.$state, this.$itemProvider, resolvedSlotSums, Constraints.m5921copyZbe2FdA$default(constraints, ConstraintsKt.m5944constrainWidthK40F9xA(j, horizontalPadding), 0, ConstraintsKt.m5943constrainHeightK40F9xA(j, verticalPadding), 0, 10, (Object) null), isVertical, this.$reverseLayout, contentOffset, mainAxisAvailableSize, lazyLayoutMeasureScope.m5961roundToPx0680j_4(this.$mainAxisSpacing), lazyLayoutMeasureScope.m5961roundToPx0680j_4(this.$crossAxisSpacing), beforeContentPadding, afterContentPadding);
        this.$state.applyMeasureResult$foundation_release(it);
        return it;
    }
}
