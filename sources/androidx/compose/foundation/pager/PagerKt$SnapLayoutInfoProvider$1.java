package androidx.compose.foundation.pager;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\f\u0010\n\u001a\u00020\u0007*\u00020\bH\u0016J\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f*\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"androidx/compose/foundation/pager/PagerKt$SnapLayoutInfoProvider$1", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "calculateApproachOffset", "", "Landroidx/compose/ui/unit/Density;", "initialVelocity", "calculateSnapStepSize", "calculateSnappingOffsetBounds", "Lkotlin/ranges/ClosedFloatingPointRange;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Pager.kt */
public final class PagerKt$SnapLayoutInfoProvider$1 implements SnapLayoutInfoProvider {
    final /* synthetic */ DecayAnimationSpec<Float> $decayAnimationSpec;
    final /* synthetic */ PagerSnapDistance $pagerSnapDistance;
    final /* synthetic */ PagerState $pagerState;

    PagerKt$SnapLayoutInfoProvider$1(PagerState $pagerState2, DecayAnimationSpec<Float> $decayAnimationSpec2, PagerSnapDistance $pagerSnapDistance2) {
        this.$pagerState = $pagerState2;
        this.$decayAnimationSpec = $decayAnimationSpec2;
        this.$pagerSnapDistance = $pagerSnapDistance2;
    }

    public final LazyListLayoutInfo getLayoutInfo() {
        return this.$pagerState.getLayoutInfo$foundation_release();
    }

    public ClosedFloatingPointRange<Float> calculateSnappingOffsetBounds(Density $this$calculateSnappingOffsetBounds) {
        Intrinsics.checkNotNullParameter($this$calculateSnappingOffsetBounds, "<this>");
        float lowerBoundOffset = Float.NEGATIVE_INFINITY;
        float upperBoundOffset = Float.POSITIVE_INFINITY;
        List $this$fastForEach$iv = getLayoutInfo().getVisibleItemsInfo();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            float offset = LazyListSnapLayoutInfoProviderKt.calculateDistanceToDesiredSnapPosition($this$calculateSnappingOffsetBounds, getLayoutInfo(), $this$fastForEach$iv.get(index$iv), PagerStateKt.getSnapAlignmentStartToStart());
            if (offset <= 0.0f && offset > lowerBoundOffset) {
                lowerBoundOffset = offset;
            }
            if (offset >= 0.0f && offset < upperBoundOffset) {
                upperBoundOffset = offset;
            }
        }
        return RangesKt.rangeTo(lowerBoundOffset, upperBoundOffset);
    }

    public float calculateSnapStepSize(Density $this$calculateSnapStepSize) {
        Intrinsics.checkNotNullParameter($this$calculateSnapStepSize, "<this>");
        LazyListLayoutInfo $this$calculateSnapStepSize_u24lambda_u242 = getLayoutInfo();
        if (!(!$this$calculateSnapStepSize_u24lambda_u242.getVisibleItemsInfo().isEmpty())) {
            return 0.0f;
        }
        int sum$iv = 0;
        List $this$fastForEach$iv$iv = $this$calculateSnapStepSize_u24lambda_u242.getVisibleItemsInfo();
        int size = $this$fastForEach$iv$iv.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            sum$iv += ((LazyListItemInfo) $this$fastForEach$iv$iv.get(index$iv$iv)).getSize();
        }
        return ((float) sum$iv) / ((float) $this$calculateSnapStepSize_u24lambda_u242.getVisibleItemsInfo().size());
    }

    public float calculateApproachOffset(Density $this$calculateApproachOffset, float initialVelocity) {
        int i;
        Object it$iv;
        float f;
        float f2;
        float f3 = initialVelocity;
        Intrinsics.checkNotNullParameter($this$calculateApproachOffset, "<this>");
        int effectivePageSizePx = this.$pagerState.getPageSize$foundation_release() + this.$pagerState.getPageSpacing$foundation_release();
        float animationOffsetPx = DecayAnimationSpecKt.calculateTargetValue(this.$decayAnimationSpec, 0.0f, f3);
        LazyListItemInfo it = this.$pagerState.getFirstVisiblePage$foundation_release();
        if (it != null) {
            i = f3 < 0.0f ? it.getIndex() + 1 : it.getIndex();
        } else {
            i = this.$pagerState.getCurrentPage();
        }
        int startPage = i;
        List $this$fastForEach$iv$iv = getLayoutInfo().getVisibleItemsInfo();
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (true) {
            if (index$iv$iv >= size) {
                it$iv = null;
                break;
            }
            it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            if (((LazyListItemInfo) it$iv).getIndex() == startPage) {
                break;
            }
            index$iv$iv++;
        }
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) it$iv;
        int scrollOffset = lazyListItemInfo != null ? lazyListItemInfo.getOffset() : 0;
        float targetPageValue = (((float) (startPage * effectivePageSizePx)) + animationOffsetPx) / ((float) effectivePageSizePx);
        if (f3 > 0.0f) {
            f = (float) Math.ceil((double) targetPageValue);
        } else {
            f = (float) Math.floor((double) targetPageValue);
        }
        int flingApproachOffsetPx = RangesKt.coerceAtLeast(Math.abs((RangesKt.coerceIn(this.$pagerSnapDistance.calculateTargetPage(startPage, RangesKt.coerceIn((int) f, 0, this.$pagerState.getPageCount$foundation_release()), initialVelocity, this.$pagerState.getPageSize$foundation_release(), this.$pagerState.getPageSpacing$foundation_release()), 0, this.$pagerState.getPageCount$foundation_release()) - startPage) * effectivePageSizePx) - Math.abs(scrollOffset), 0);
        if (flingApproachOffsetPx == 0) {
            f2 = (float) flingApproachOffsetPx;
        } else {
            f2 = ((float) flingApproachOffsetPx) * Math.signum(initialVelocity);
        }
        float f4 = f2;
        return f2;
    }
}
