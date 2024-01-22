package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$SliderImpl$draggableState$1$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ State<Function1<Float, Unit>> $onValueChangeState;
    final /* synthetic */ MutableState<Float> $pressOffset;
    final /* synthetic */ MutableState<Float> $rawOffset;
    final /* synthetic */ MutableState<Float> $thumbWidth;
    final /* synthetic */ float[] $tickFractions;
    final /* synthetic */ MutableState<Integer> $totalWidth;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$SliderImpl$draggableState$1$1(MutableState<Integer> mutableState, MutableState<Float> mutableState2, MutableState<Float> mutableState3, MutableState<Float> mutableState4, float[] fArr, State<? extends Function1<? super Float, Unit>> state, ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        super(1);
        this.$totalWidth = mutableState;
        this.$thumbWidth = mutableState2;
        this.$rawOffset = mutableState3;
        this.$pressOffset = mutableState4;
        this.$tickFractions = fArr;
        this.$onValueChangeState = state;
        this.$valueRange = closedFloatingPointRange;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float it) {
        float f = (float) 2;
        float maxPx = Math.max(this.$totalWidth.getValue().floatValue() - (this.$thumbWidth.getValue().floatValue() / f), 0.0f);
        float minPx = Math.min(this.$thumbWidth.getValue().floatValue() / f, maxPx);
        MutableState<Float> mutableState = this.$rawOffset;
        mutableState.setValue(Float.valueOf(mutableState.getValue().floatValue() + it + this.$pressOffset.getValue().floatValue()));
        this.$pressOffset.setValue(Float.valueOf(0.0f));
        this.$onValueChangeState.getValue().invoke(Float.valueOf(SliderKt.SliderImpl$scaleToUserValue(this.$valueRange, minPx, maxPx, SliderKt.snapValueToTick(this.$rawOffset.getValue().floatValue(), this.$tickFractions, minPx, maxPx))));
    }
}
