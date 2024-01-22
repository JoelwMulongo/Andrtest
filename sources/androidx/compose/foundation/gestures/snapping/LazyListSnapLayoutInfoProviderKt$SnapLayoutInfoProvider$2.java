package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\f\u0010\n\u001a\u00020\u0007*\u00020\bH\u0016J\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f*\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"androidx/compose/foundation/gestures/snapping/LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$2", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "calculateApproachOffset", "", "Landroidx/compose/ui/unit/Density;", "initialVelocity", "calculateSnapStepSize", "calculateSnappingOffsetBounds", "Lkotlin/ranges/ClosedFloatingPointRange;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListSnapLayoutInfoProvider.kt */
public final class LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$2 implements SnapLayoutInfoProvider {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ Function3<Density, Float, Float, Float> $positionInLayout;

    LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$2(LazyListState $lazyListState2, Function3<? super Density, ? super Float, ? super Float, Float> $positionInLayout2) {
        this.$lazyListState = $lazyListState2;
        this.$positionInLayout = $positionInLayout2;
    }

    private final LazyListLayoutInfo getLayoutInfo() {
        return this.$lazyListState.getLayoutInfo();
    }

    public float calculateApproachOffset(Density $this$calculateApproachOffset, float initialVelocity) {
        Intrinsics.checkNotNullParameter($this$calculateApproachOffset, "<this>");
        float finalDecayOffset = RangesKt.coerceAtLeast(Math.abs(DecayAnimationSpecKt.calculateTargetValue(SplineBasedDecayKt.splineBasedDecay($this$calculateApproachOffset), 0.0f, initialVelocity)) - calculateSnapStepSize($this$calculateApproachOffset), 0.0f);
        if (finalDecayOffset == 0.0f) {
            return finalDecayOffset;
        }
        return Math.signum(initialVelocity) * finalDecayOffset;
    }

    public ClosedFloatingPointRange<Float> calculateSnappingOffsetBounds(Density $this$calculateSnappingOffsetBounds) {
        Intrinsics.checkNotNullParameter($this$calculateSnappingOffsetBounds, "<this>");
        float lowerBoundOffset = Float.NEGATIVE_INFINITY;
        float upperBoundOffset = Float.POSITIVE_INFINITY;
        List $this$fastForEach$iv = getLayoutInfo().getVisibleItemsInfo();
        Function3<Density, Float, Float, Float> function3 = this.$positionInLayout;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            float offset = LazyListSnapLayoutInfoProviderKt.calculateDistanceToDesiredSnapPosition($this$calculateSnappingOffsetBounds, getLayoutInfo(), $this$fastForEach$iv.get(index$iv), function3);
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
}
