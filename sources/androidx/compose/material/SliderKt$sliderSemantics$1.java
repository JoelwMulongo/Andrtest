package androidx.compose.material;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$sliderSemantics$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ float $coerced;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function1<Float, Unit> $onValueChange;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ int $steps;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$sliderSemantics$1(boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, float f, Function1<? super Float, Unit> function1, Function0<Unit> function0) {
        super(1);
        this.$enabled = z;
        this.$valueRange = closedFloatingPointRange;
        this.$steps = i;
        this.$coerced = f;
        this.$onValueChange = function1;
        this.$onValueChangeFinished = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SemanticsPropertyReceiver) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        if (!this.$enabled) {
            SemanticsPropertiesKt.disabled($this$semantics);
        }
        final ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
        final int i = this.$steps;
        final float f = this.$coerced;
        final Function1<Float, Unit> function1 = this.$onValueChange;
        final Function0<Unit> function0 = this.$onValueChangeFinished;
        SemanticsPropertiesKt.setProgress$default($this$semantics, (String) null, new Function1<Float, Boolean>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).floatValue());
            }

            public final Boolean invoke(float targetValue) {
                float newValue = RangesKt.coerceIn(targetValue, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
                float originalVal = newValue;
                int i = i;
                boolean z = true;
                if (i > 0) {
                    float distance = newValue;
                    int i2 = 0;
                    int i3 = i + 1;
                    if (0 <= i3) {
                        while (true) {
                            float stepValue = MathHelpersKt.lerp(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), ((float) i2) / ((float) (i + 1)));
                            if (Math.abs(stepValue - originalVal) <= distance) {
                                distance = Math.abs(stepValue - originalVal);
                                newValue = stepValue;
                            }
                            if (i2 == i3) {
                                break;
                            }
                            i2++;
                        }
                    }
                }
                float resolvedValue = newValue;
                if (resolvedValue == f) {
                    z = false;
                } else {
                    function1.invoke(Float.valueOf(resolvedValue));
                    Function0<Unit> function0 = function0;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
                return Boolean.valueOf(z);
            }
        }, 1, (Object) null);
    }
}
