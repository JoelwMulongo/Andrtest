package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatingActionButton.kt */
final class FloatingActionButtonKt$ExtendedFloatingActionButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ FloatingActionButtonElevation $elevation;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FloatingActionButtonKt$ExtendedFloatingActionButton$3(Function2<? super Composer, ? super Integer, Unit> function2, Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, MutableInteractionSource mutableInteractionSource, Shape shape, long j, long j2, FloatingActionButtonElevation floatingActionButtonElevation, int i, int i2) {
        super(2);
        this.$text = function2;
        this.$onClick = function0;
        this.$modifier = modifier;
        this.$icon = function22;
        this.$interactionSource = mutableInteractionSource;
        this.$shape = shape;
        this.$backgroundColor = j;
        this.$contentColor = j2;
        this.$elevation = floatingActionButtonElevation;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        FloatingActionButtonKt.m1524ExtendedFloatingActionButtonwqdebIU(this.$text, this.$onClick, this.$modifier, this.$icon, this.$interactionSource, this.$shape, this.$backgroundColor, this.$contentColor, this.$elevation, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
