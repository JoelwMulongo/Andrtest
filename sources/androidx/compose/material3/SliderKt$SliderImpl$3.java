package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$SliderImpl$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Float, Unit> $onValueChange;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ int $steps;
    final /* synthetic */ Function3<SliderPositions, Composer, Integer, Unit> $thumb;
    final /* synthetic */ Function3<SliderPositions, Composer, Integer, Unit> $track;
    final /* synthetic */ float $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$SliderImpl$3(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Function1<? super Float, Unit> function1, Function0<Unit> function0, int i, float f, ClosedFloatingPointRange<Float> closedFloatingPointRange, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function32, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
        this.$onValueChange = function1;
        this.$onValueChangeFinished = function0;
        this.$steps = i;
        this.$value = f;
        this.$valueRange = closedFloatingPointRange;
        this.$thumb = function3;
        this.$track = function32;
        this.$$changed = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SliderKt.SliderImpl(this.$modifier, this.$enabled, this.$interactionSource, this.$onValueChange, this.$onValueChangeFinished, this.$steps, this.$value, this.$valueRange, this.$thumb, this.$track, composer, this.$$changed | 1);
    }
}
