package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Switch.kt */
final class SwitchKt$Switch$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $checked;
    final /* synthetic */ SwitchColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Boolean, Unit> $onCheckedChange;
    final /* synthetic */ Function2<Composer, Integer, Unit> $thumbContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwitchKt$Switch$5(boolean z, Function1<? super Boolean, Unit> function1, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, boolean z2, SwitchColors switchColors, MutableInteractionSource mutableInteractionSource, int i, int i2) {
        super(2);
        this.$checked = z;
        this.$onCheckedChange = function1;
        this.$modifier = modifier;
        this.$thumbContent = function2;
        this.$enabled = z2;
        this.$colors = switchColors;
        this.$interactionSource = mutableInteractionSource;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SwitchKt.Switch(this.$checked, this.$onCheckedChange, this.$modifier, this.$thumbContent, this.$enabled, this.$colors, this.$interactionSource, composer, this.$$changed | 1, this.$$default);
    }
}
