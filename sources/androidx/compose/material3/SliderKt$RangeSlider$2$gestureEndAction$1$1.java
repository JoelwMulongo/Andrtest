package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSlider$2$gestureEndAction$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2$gestureEndAction$1$1(Function0<Unit> function0) {
        super(1);
        this.$onValueChangeFinished = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean it) {
        Function0<Unit> function0 = this.$onValueChangeFinished;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
