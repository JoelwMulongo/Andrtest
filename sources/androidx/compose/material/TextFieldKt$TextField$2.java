package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextField.kt */
final class TextFieldKt$TextField$2 extends Lambda implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ String $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldKt$TextField$2(String str, boolean z, boolean z2, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, TextFieldColors textFieldColors, int i, int i2) {
        super(3);
        this.$value = str;
        this.$enabled = z;
        this.$singleLine = z2;
        this.$visualTransformation = visualTransformation;
        this.$interactionSource = mutableInteractionSource;
        this.$isError = z3;
        this.$label = function2;
        this.$placeholder = function22;
        this.$leadingIcon = function23;
        this.$trailingIcon = function24;
        this.$colors = textFieldColors;
        this.$$dirty = i;
        this.$$dirty1 = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer, int $changed) {
        Function2<? super Composer, ? super Integer, Unit> function2 = innerTextField;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(function2, "innerTextField");
        ComposerKt.sourceInformation(composer, "C211@10686L538:TextField.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= composer.changedInstance(function2) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(989834338, $dirty2, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:209)");
            }
            boolean z = this.$isError;
            Function2<Composer, Integer, Unit> function22 = this.$label;
            Function2<Composer, Integer, Unit> function23 = this.$placeholder;
            Function2<Composer, Integer, Unit> function24 = this.$leadingIcon;
            Function2<Composer, Integer, Unit> function25 = this.$trailingIcon;
            TextFieldColors textFieldColors = this.$colors;
            int $dirty3 = $dirty2;
            int i = this.$$dirty;
            int i2 = this.$$dirty1;
            TextFieldDefaults.INSTANCE.TextFieldDecorationBox(this.$value, innerTextField, this.$enabled, this.$singleLine, this.$visualTransformation, this.$interactionSource, z, function22, function23, function24, function25, textFieldColors, (PaddingValues) null, $composer, ((i2 >> 3) & 7168) | (i & 14) | (($dirty3 << 3) & 112) | ((i >> 3) & 896) | ((i2 << 9) & 57344) | ((i2 >> 6) & 458752) | ((i2 << 18) & 3670016) | ((i << 3) & 29360128) | ((i << 3) & 234881024) | ((i << 3) & 1879048192), ((i >> 27) & 14) | 3072 | ((i2 >> 24) & 112), 4096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
        int i3 = $dirty2;
    }
}
