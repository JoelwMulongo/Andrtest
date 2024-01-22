package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$SliderImpl$onValueChangeState$1$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ Function1<Float, Unit> $onValueChange;
    final /* synthetic */ float $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$SliderImpl$onValueChangeState$1$1(float f, Function1<? super Float, Unit> function1) {
        super(1);
        this.$value = f;
        this.$onValueChange = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float it) {
        if (!(it == this.$value)) {
            this.$onValueChange.invoke(Float.valueOf(it));
        }
    }
}
