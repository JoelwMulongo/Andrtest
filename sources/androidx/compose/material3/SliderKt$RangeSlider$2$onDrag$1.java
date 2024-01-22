package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSlider$2$onDrag$1 extends Lambda implements Function2<Boolean, Float, Unit> {
    final /* synthetic */ Ref.FloatRef $maxPx;
    final /* synthetic */ Ref.FloatRef $minPx;
    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
    final /* synthetic */ MutableState<Float> $rawOffsetEnd;
    final /* synthetic */ MutableState<Float> $rawOffsetStart;
    final /* synthetic */ float[] $tickFractions;
    final /* synthetic */ ClosedFloatingPointRange<Float> $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2$onDrag$1(MutableState<Float> mutableState, MutableState<Float> mutableState2, ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, float[] fArr, Ref.FloatRef floatRef2, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        super(2);
        this.$rawOffsetStart = mutableState;
        this.$rawOffsetEnd = mutableState2;
        this.$value = closedFloatingPointRange;
        this.$minPx = floatRef;
        this.$tickFractions = fArr;
        this.$maxPx = floatRef2;
        this.$onValueChangeState = state;
        this.$valueRange = closedFloatingPointRange2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), ((Number) p2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isStart, float offset) {
        ClosedFloatingPointRange offsetRange;
        if (isStart) {
            MutableState<Float> mutableState = this.$rawOffsetStart;
            mutableState.setValue(Float.valueOf(mutableState.getValue().floatValue() + offset));
            this.$rawOffsetEnd.setValue(Float.valueOf(SliderKt$RangeSlider$2.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, this.$value.getEndInclusive().floatValue())));
            float offsetEnd = this.$rawOffsetEnd.getValue().floatValue();
            offsetRange = RangesKt.rangeTo(SliderKt.snapValueToTick(RangesKt.coerceIn(this.$rawOffsetStart.getValue().floatValue(), this.$minPx.element, offsetEnd), this.$tickFractions, this.$minPx.element, this.$maxPx.element), offsetEnd);
        } else {
            MutableState<Float> mutableState2 = this.$rawOffsetEnd;
            mutableState2.setValue(Float.valueOf(mutableState2.getValue().floatValue() + offset));
            this.$rawOffsetStart.setValue(Float.valueOf(SliderKt$RangeSlider$2.invoke$scaleToOffset(this.$valueRange, this.$minPx, this.$maxPx, this.$value.getStart().floatValue())));
            float offsetStart = this.$rawOffsetStart.getValue().floatValue();
            offsetRange = RangesKt.rangeTo(offsetStart, SliderKt.snapValueToTick(RangesKt.coerceIn(this.$rawOffsetEnd.getValue().floatValue(), offsetStart, this.$maxPx.element), this.$tickFractions, this.$minPx.element, this.$maxPx.element));
        }
        this.$onValueChangeState.getValue().invoke(SliderKt$RangeSlider$2.invoke$scaleToUserValue(this.$minPx, this.$maxPx, this.$valueRange, offsetRange));
    }
}
