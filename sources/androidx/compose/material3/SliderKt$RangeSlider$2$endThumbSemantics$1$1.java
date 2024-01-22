package androidx.compose.material3;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSlider$2$endThumbSemantics$1$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ float $coercedStart;
    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2$endThumbSemantics$1$1(State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, float f) {
        super(1);
        this.$onValueChangeState = state;
        this.$coercedStart = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float value) {
        this.$onValueChangeState.getValue().invoke(RangesKt.rangeTo(this.$coercedStart, value));
    }
}
