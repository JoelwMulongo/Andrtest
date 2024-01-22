package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSlider$onValueChangeState$1$1 extends Lambda implements Function1<ClosedFloatingPointRange<Float>, Unit> {
    final /* synthetic */ Function1<ClosedFloatingPointRange<Float>, Unit> $onValueChange;
    final /* synthetic */ ClosedFloatingPointRange<Float> $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$onValueChangeState$1$1(ClosedFloatingPointRange<Float> closedFloatingPointRange, Function1<? super ClosedFloatingPointRange<Float>, Unit> function1) {
        super(1);
        this.$value = closedFloatingPointRange;
        this.$onValueChange = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((ClosedFloatingPointRange<Float>) (ClosedFloatingPointRange) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(ClosedFloatingPointRange<Float> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!Intrinsics.areEqual((Object) it, (Object) this.$value)) {
            this.$onValueChange.invoke(it);
        }
    }
}
