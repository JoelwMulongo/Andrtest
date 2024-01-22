package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldKt$OutlinedTextField$9 extends Lambda implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ TextFieldValue $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutlinedTextFieldKt$OutlinedTextField$9(TextFieldValue textFieldValue, boolean z, boolean z2, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, TextFieldColors textFieldColors, int i, int i2, Shape shape) {
        super(3);
        this.$value = textFieldValue;
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
        this.$shape = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer, int $changed) {
        Function2<? super Composer, ? super Integer, Unit> function2 = innerTextField;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(function2, "innerTextField");
        ComposerKt.sourceInformation(composer, "C392@19598L839:OutlinedTextField.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= composer.changedInstance(function2) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1001528775, $dirty2, -1, "androidx.compose.material.OutlinedTextField.<anonymous> (OutlinedTextField.kt:391)");
            }
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            String text = this.$value.getText();
            boolean z = this.$enabled;
            boolean z2 = this.$singleLine;
            VisualTransformation visualTransformation = this.$visualTransformation;
            boolean z3 = this.$isError;
            Function2<Composer, Integer, Unit> function22 = this.$label;
            Function2<Composer, Integer, Unit> function23 = this.$placeholder;
            Function2<Composer, Integer, Unit> function24 = this.$leadingIcon;
            Function2<Composer, Integer, Unit> function25 = this.$trailingIcon;
            TextFieldColors textFieldColors = this.$colors;
            boolean z4 = this.$enabled;
            TextFieldDefaults textFieldDefaults2 = textFieldDefaults;
            boolean z5 = this.$isError;
            String str = text;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            boolean z6 = z;
            TextFieldColors textFieldColors2 = this.$colors;
            boolean z7 = z2;
            Shape shape = this.$shape;
            VisualTransformation visualTransformation2 = visualTransformation;
            int i = this.$$dirty;
            InteractionSource interactionSource = this.$interactionSource;
            final boolean z8 = z4;
            final boolean z9 = z5;
            final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
            final TextFieldColors textFieldColors3 = textFieldColors2;
            final Shape shape2 = shape;
            final int i2 = i;
            final int i3 = this.$$dirty1;
            Function2 composableLambda = ComposableLambdaKt.composableLambda(composer, -753611134, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    int i = $changed;
                    ComposerKt.sourceInformation($composer, "C406@20202L203:OutlinedTextField.kt#jmzs0o");
                    if ((i & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-753611134, i, -1, "androidx.compose.material.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:405)");
                        }
                        TextFieldColors textFieldColors = textFieldColors3;
                        Shape shape = shape2;
                        int i2 = i3;
                        TextFieldDefaults.INSTANCE.m1670BorderBoxnbWgWpA(z8, z9, mutableInteractionSource2, textFieldColors, shape, 0.0f, 0.0f, $composer, ((i2 >> 9) & 14) | 12582912 | ((i2 << 3) & 112) | ((i2 >> 15) & 896) | ((i2 >> 18) & 7168) | ((i2 >> 12) & 57344), 96);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            });
            int i4 = this.$$dirty;
            int i5 = this.$$dirty1;
            textFieldDefaults2.OutlinedTextFieldDecorationBox(str, innerTextField, z6, z7, visualTransformation2, interactionSource, z3, function22, function23, function24, function25, textFieldColors, (PaddingValues) null, composableLambda, $composer, (($dirty2 << 3) & 112) | ((i4 >> 3) & 896) | ((i5 >> 3) & 7168) | ((i5 << 9) & 57344) | ((i5 >> 6) & 458752) | ((i5 << 18) & 3670016) | ((i4 << 3) & 29360128) | ((i4 << 3) & 234881024) | (1879048192 & (i4 << 3)), ((i4 >> 27) & 14) | 27648 | ((i5 >> 24) & 112), 4096);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
        int i6 = $dirty2;
    }
}
