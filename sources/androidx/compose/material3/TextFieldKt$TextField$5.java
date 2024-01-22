package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextField.kt */
final class TextFieldKt$TextField$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ KeyboardActions $keyboardActions;
    final /* synthetic */ KeyboardOptions $keyboardOptions;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ TextStyle $mergedTextStyle;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<TextFieldValue, Unit> $onValueChange;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ TextFieldValue $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldKt$TextField$5(Modifier modifier, TextFieldColors textFieldColors, boolean z, int i, TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, boolean z2, boolean z3, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i2, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, int i3, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Shape shape) {
        super(2);
        this.$modifier = modifier;
        this.$colors = textFieldColors;
        this.$isError = z;
        this.$$dirty1 = i;
        this.$value = textFieldValue;
        this.$onValueChange = function1;
        this.$enabled = z2;
        this.$readOnly = z3;
        this.$mergedTextStyle = textStyle;
        this.$keyboardOptions = keyboardOptions;
        this.$keyboardActions = keyboardActions;
        this.$singleLine = z4;
        this.$maxLines = i2;
        this.$visualTransformation = visualTransformation;
        this.$interactionSource = mutableInteractionSource;
        this.$$dirty = i3;
        this.$label = function2;
        this.$placeholder = function22;
        this.$leadingIcon = function23;
        this.$trailingIcon = function24;
        this.$supportingText = function25;
        this.$shape = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C335@17583L20,324@17145L1633:TextField.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(765006587, i, -1, "androidx.compose.material3.TextField.<anonymous> (TextField.kt:322)");
            }
            Modifier r3 = SizeKt.m814defaultMinSizeVpY3zN4(this.$modifier, TextFieldDefaults.INSTANCE.m2151getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2150getMinHeightD9Ej5fM());
            TextFieldColors textFieldColors = this.$colors;
            boolean z = this.$isError;
            int i2 = this.$$dirty1;
            SolidColor solidColor = new SolidColor(textFieldColors.cursorColor$material3_release(z, composer, ((i2 >> 24) & 112) | ((i2 >> 3) & 14)).getValue().m3174unboximpl(), (DefaultConstructorMarker) null);
            TextFieldValue textFieldValue = this.$value;
            Function1<TextFieldValue, Unit> function1 = this.$onValueChange;
            boolean z2 = this.$enabled;
            boolean z3 = this.$readOnly;
            TextStyle textStyle = this.$mergedTextStyle;
            KeyboardOptions keyboardOptions = this.$keyboardOptions;
            KeyboardActions keyboardActions = this.$keyboardActions;
            boolean z4 = this.$singleLine;
            int i3 = this.$maxLines;
            VisualTransformation visualTransformation = this.$visualTransformation;
            SolidColor solidColor2 = solidColor;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            TextFieldValue textFieldValue2 = textFieldValue;
            TextFieldValue textFieldValue3 = this.$value;
            Function1<TextFieldValue, Unit> function12 = function1;
            boolean z5 = this.$enabled;
            Modifier modifier = r3;
            boolean z6 = this.$singleLine;
            boolean z7 = z2;
            VisualTransformation visualTransformation2 = this.$visualTransformation;
            boolean z8 = z3;
            MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
            TextStyle textStyle2 = textStyle;
            boolean z9 = this.$isError;
            KeyboardOptions keyboardOptions2 = keyboardOptions;
            Function2<Composer, Integer, Unit> function2 = this.$label;
            KeyboardActions keyboardActions2 = keyboardActions;
            Function2<Composer, Integer, Unit> function22 = this.$placeholder;
            boolean z10 = z4;
            Function2<Composer, Integer, Unit> function23 = this.$leadingIcon;
            int i4 = i3;
            Function2<Composer, Integer, Unit> function24 = this.$trailingIcon;
            VisualTransformation visualTransformation3 = visualTransformation;
            Function2<Composer, Integer, Unit> function25 = this.$supportingText;
            MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
            Shape shape = this.$shape;
            Brush brush = solidColor2;
            TextFieldColors textFieldColors2 = this.$colors;
            final TextFieldValue textFieldValue4 = textFieldValue3;
            final boolean z11 = z5;
            final boolean z12 = z6;
            final VisualTransformation visualTransformation4 = visualTransformation2;
            final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
            final boolean z13 = z9;
            final Function2<Composer, Integer, Unit> function26 = function2;
            final Function2<Composer, Integer, Unit> function27 = function22;
            final Function2<Composer, Integer, Unit> function28 = function23;
            final Function2<Composer, Integer, Unit> function29 = function24;
            final Function2<Composer, Integer, Unit> function210 = function25;
            final Shape shape2 = shape;
            final TextFieldColors textFieldColors3 = textFieldColors2;
            final int i5 = this.$$dirty;
            final int i6 = this.$$dirty1;
            int i7 = this.$$dirty;
            int i8 = (i7 & 57344) | (i7 & 14) | (i7 & 112) | (i7 & 7168) | ((this.$$dirty1 << 9) & 3670016) | (KeyboardActions.$stable << 21);
            int i9 = this.$$dirty1;
            int i10 = i8 | ((i9 << 9) & 29360128) | ((i9 << 9) & 234881024) | ((i9 << 9) & 1879048192);
            int i11 = ((i9 >> 6) & 14) | 24576 | ((i9 >> 15) & 896);
            TextFieldValue textFieldValue5 = textFieldValue2;
            Function1<TextFieldValue, Unit> function13 = function12;
            Modifier modifier2 = modifier;
            boolean z14 = z7;
            boolean z15 = z8;
            TextStyle textStyle3 = textStyle2;
            KeyboardOptions keyboardOptions3 = keyboardOptions2;
            KeyboardActions keyboardActions3 = keyboardActions2;
            boolean z16 = z10;
            int i12 = i4;
            VisualTransformation visualTransformation5 = visualTransformation3;
            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
            Brush brush2 = brush;
            BasicTextFieldKt.BasicTextField(textFieldValue5, (Function1) function13, modifier2, z14, z15, textStyle3, keyboardOptions3, keyboardActions3, z16, i12, visualTransformation5, (Function1) null, mutableInteractionSource5, brush2, (Function3) ComposableLambdaKt.composableLambda($composer, 998109572, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) p1, (Composer) p2, ((Number) p3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer, int $changed) {
                    Function2<? super Composer, ? super Integer, Unit> function2 = innerTextField;
                    Composer composer = $composer;
                    Intrinsics.checkNotNullParameter(function2, "innerTextField");
                    ComposerKt.sourceInformation(composer, "C344@18071L683:TextField.kt#uh7d8r");
                    int $dirty = $changed;
                    if (($changed & 14) == 0) {
                        $dirty |= composer.changed((Object) function2) ? 4 : 2;
                    }
                    int $dirty2 = $dirty;
                    if (($dirty2 & 91) != 18 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(998109572, $dirty2, -1, "androidx.compose.material3.TextField.<anonymous>.<anonymous> (TextField.kt:342)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String text = textFieldValue4.getText();
                        boolean z = z13;
                        Function2<Composer, Integer, Unit> function22 = function26;
                        Function2<Composer, Integer, Unit> function23 = function27;
                        Function2<Composer, Integer, Unit> function24 = function28;
                        Function2<Composer, Integer, Unit> function25 = function29;
                        Function2<Composer, Integer, Unit> function26 = function210;
                        int $dirty3 = $dirty2;
                        Shape shape = shape2;
                        TextFieldColors textFieldColors = textFieldColors3;
                        TextFieldDefaults textFieldDefaults2 = textFieldDefaults;
                        int i = i5;
                        int i2 = i6;
                        int i3 = ((i2 >> 6) & 7168) | ((i >> 3) & 896) | (($dirty3 << 3) & 112) | ((i2 << 6) & 57344) | ((i2 >> 6) & 458752) | ((i2 << 15) & 3670016) | ((i << 3) & 29360128) | ((i << 3) & 234881024) | ((i << 3) & 1879048192);
                        int i4 = ((i >> 27) & 14) | 1572864 | ((i2 << 3) & 112) | ((i2 >> 18) & 896) | ((i2 >> 18) & 7168);
                        textFieldDefaults2.TextFieldDecorationBox(text, innerTextField, z11, z12, visualTransformation4, mutableInteractionSource4, z, function22, function23, function24, function25, function26, shape, textFieldColors, (PaddingValues) null, (Function2<? super Composer, ? super Integer, Unit>) null, $composer, i3, i4, 49152);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                    int i5 = $dirty2;
                }
            }), $composer, i10, i11, 2048);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
