package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.semantics.SemanticsModifierKt;
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
/* compiled from: OutlinedTextField.kt */
final class OutlinedTextFieldKt$OutlinedTextField$5 extends Lambda implements Function2<Composer, Integer, Unit> {
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
    OutlinedTextFieldKt$OutlinedTextField$5(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, TextFieldColors textFieldColors, boolean z, int i, TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, boolean z2, boolean z3, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i2, VisualTransformation visualTransformation, MutableInteractionSource mutableInteractionSource, int i3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Shape shape) {
        super(2);
        this.$label = function2;
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
        Modifier modifier;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C332@17853L20,313@17038L2234:OutlinedTextField.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-719341509, i, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:311)");
            }
            if (this.$label != null) {
                modifier = PaddingKt.m764paddingqDBjuR0$default(SemanticsModifierKt.semantics(this.$modifier, true, AnonymousClass1.INSTANCE), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, (Object) null);
            } else {
                modifier = this.$modifier;
            }
            Modifier r3 = SizeKt.m814defaultMinSizeVpY3zN4(modifier, TextFieldDefaults.INSTANCE.m2151getMinWidthD9Ej5fM(), TextFieldDefaults.INSTANCE.m2150getMinHeightD9Ej5fM());
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
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            TextFieldValue textFieldValue2 = textFieldValue;
            TextFieldValue textFieldValue3 = this.$value;
            Function1<TextFieldValue, Unit> function12 = function1;
            boolean z5 = this.$enabled;
            Modifier modifier2 = r3;
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
            TextFieldColors textFieldColors2 = this.$colors;
            int i5 = this.$$dirty;
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
            final TextFieldColors textFieldColors3 = textFieldColors2;
            final int i6 = i5;
            final int i7 = this.$$dirty1;
            final Shape shape = this.$shape;
            int i8 = this.$$dirty;
            int i9 = (i8 & 57344) | (i8 & 14) | (i8 & 112) | (i8 & 7168) | ((this.$$dirty1 << 9) & 3670016) | (KeyboardActions.$stable << 21);
            int i10 = this.$$dirty1;
            int i11 = i9 | ((i10 << 9) & 29360128) | ((i10 << 9) & 234881024) | ((i10 << 9) & 1879048192);
            int i12 = ((i10 >> 6) & 14) | 24576 | ((i10 >> 15) & 896);
            TextFieldValue textFieldValue5 = textFieldValue2;
            Function1<TextFieldValue, Unit> function13 = function12;
            Modifier modifier3 = modifier2;
            boolean z14 = z7;
            boolean z15 = z8;
            TextStyle textStyle3 = textStyle2;
            KeyboardOptions keyboardOptions3 = keyboardOptions2;
            KeyboardActions keyboardActions3 = keyboardActions2;
            boolean z16 = z10;
            int i13 = i4;
            VisualTransformation visualTransformation5 = visualTransformation3;
            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
            Brush brush = solidColor;
            BasicTextFieldKt.BasicTextField(textFieldValue5, (Function1) function13, modifier3, z14, z15, textStyle3, keyboardOptions3, keyboardActions3, z16, i13, visualTransformation5, (Function1) null, mutableInteractionSource5, brush, (Function3) ComposableLambdaKt.composableLambda($composer, 342910148, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) p1, (Composer) p2, ((Number) p3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer $composer, int $changed) {
                    Function2<? super Composer, ? super Integer, Unit> function2 = innerTextField;
                    Composer composer = $composer;
                    Intrinsics.checkNotNullParameter(function2, "innerTextField");
                    ComposerKt.sourceInformation(composer, "C340@18248L1000:OutlinedTextField.kt#uh7d8r");
                    int $dirty = $changed;
                    if (($changed & 14) == 0) {
                        $dirty |= composer.changed((Object) function2) ? 4 : 2;
                    }
                    int $dirty2 = $dirty;
                    if (($dirty2 & 91) != 18 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(342910148, $dirty2, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:339)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        String text = textFieldValue4.getText();
                        boolean z = z11;
                        boolean z2 = z12;
                        VisualTransformation visualTransformation = visualTransformation4;
                        boolean z3 = z13;
                        TextFieldDefaults textFieldDefaults2 = textFieldDefaults;
                        Composer composer2 = composer;
                        boolean z4 = z11;
                        String str = text;
                        boolean z5 = z13;
                        boolean z6 = z;
                        MutableInteractionSource mutableInteractionSource = mutableInteractionSource4;
                        boolean z7 = z2;
                        TextFieldColors textFieldColors = textFieldColors3;
                        VisualTransformation visualTransformation2 = visualTransformation;
                        Shape shape = shape;
                        InteractionSource interactionSource = mutableInteractionSource4;
                        final boolean z8 = z4;
                        final boolean z9 = z5;
                        final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        final Shape shape2 = shape;
                        final int i = i6;
                        final int i2 = i7;
                        int i3 = i6;
                        int i4 = i7;
                        TextFieldDefaults textFieldDefaults3 = textFieldDefaults2;
                        String str2 = str;
                        textFieldDefaults3.OutlinedTextFieldDecorationBox(str2, innerTextField, z6, z7, visualTransformation2, interactionSource, z3, function26, function27, function28, function29, function210, textFieldColors3, (PaddingValues) null, ComposableLambdaKt.composableLambda(composer2, 119108444, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                invoke((Composer) p1, ((Number) p2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer, int $changed) {
                                int i = $changed;
                                ComposerKt.sourceInformation($composer, "C355@18964L244:OutlinedTextField.kt#uh7d8r");
                                if ((i & 11) != 2 || !$composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(119108444, i, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:354)");
                                    }
                                    TextFieldColors textFieldColors = textFieldColors2;
                                    Shape shape = shape2;
                                    int i2 = i2;
                                    TextFieldDefaults.INSTANCE.m2148OutlinedBorderContainerBoxnbWgWpA(z8, z9, mutableInteractionSource2, textFieldColors, shape, 0.0f, 0.0f, $composer, ((i >> 9) & 14) | 12582912 | (i2 & 112) | ((i2 >> 15) & 896) | ((i2 >> 18) & 7168) | ((i2 >> 12) & 57344), 96);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer.skipToGroupEnd();
                            }
                        }), $composer, (($dirty2 << 3) & 112) | ((i3 >> 3) & 896) | ((i4 >> 6) & 7168) | ((i4 << 6) & 57344) | (458752 & (i4 >> 6)) | ((i4 << 15) & 3670016) | ((i3 << 3) & 29360128) | ((i3 << 3) & 234881024) | ((i3 << 3) & 1879048192), ((i3 >> 27) & 14) | 221184 | ((i4 << 3) & 112) | ((i4 >> 21) & 896), 8192);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                    int i5 = $dirty2;
                }
            }), $composer, i11, i12, 2048);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
