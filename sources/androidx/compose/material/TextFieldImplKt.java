package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aß\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&2\u0006\u0010'\u001a\u00020(2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020.2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&H\u0001¢\u0006\u0002\u00108\u001aW\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2 \u0010@\u001a\u001c\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\u0003\u0010\u0000H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a\u0012\u0010E\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\u001a\u0012\u0010H\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0012\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0013\u0010\u0005\"\u000e\u0010\u0014\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0015\u001a\u00020\u0016X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001c8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"AnimationDuration", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "", "LeadingId", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material/TextFieldColors;", "border", "(Landroidx/compose/material/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "content", "Landroidx/compose/runtime/ComposableOpenTarget;", "index", "Decoration-euL9pac", "(JLandroidx/compose/ui/text/TextStyle;Ljava/lang/Float;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldImpl.kt */
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    private static final float HorizontalIconPadding = Dp.m5986constructorimpl((float) 12);
    private static final Modifier IconDefaultSizeModifier = SizeKt.m814defaultMinSizeVpY3zN4(Modifier.Companion, Dp.m5986constructorimpl((float) 48), Dp.m5986constructorimpl((float) 48));
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding = Dp.m5986constructorimpl((float) 16);
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);

    public static final void CommonDecorationBox(TextFieldType type, String value, Function2<? super Composer, ? super Integer, Unit> innerTextField, VisualTransformation visualTransformation, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, boolean singleLine, boolean enabled, boolean isError, InteractionSource interactionSource, PaddingValues contentPadding, TextFieldColors colors, Function2<? super Composer, ? super Integer, Unit> border, Composer $composer, int $changed, int $changed1, int i) {
        Function2 border2;
        boolean isError2;
        boolean isError3;
        boolean enabled2;
        Function2 trailingIcon2;
        Function2 trailingIcon3;
        Function2 leadingIcon2;
        Composer $composer2;
        Function2 placeholder2;
        Function2 leadingIcon3;
        Function2 trailingIcon4;
        boolean singleLine2;
        boolean enabled3;
        boolean isError4;
        Function2 border3;
        Object value$iv$iv;
        InputPhase inputPhase;
        long j;
        long j2;
        boolean z;
        TextFieldType textFieldType = type;
        String str = value;
        Function2<? super Composer, ? super Integer, Unit> function2 = innerTextField;
        VisualTransformation visualTransformation2 = visualTransformation;
        Function2<? super Composer, ? super Integer, Unit> function22 = label;
        InteractionSource interactionSource2 = interactionSource;
        PaddingValues paddingValues = contentPadding;
        TextFieldColors textFieldColors = colors;
        int i2 = $changed;
        int i3 = $changed1;
        int i4 = i;
        Intrinsics.checkNotNullParameter(textFieldType, "type");
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(function2, "innerTextField");
        Intrinsics.checkNotNullParameter(visualTransformation2, "visualTransformation");
        Intrinsics.checkNotNullParameter(interactionSource2, "interactionSource");
        Intrinsics.checkNotNullParameter(paddingValues, "contentPadding");
        Intrinsics.checkNotNullParameter(textFieldColors, "colors");
        Composer $composer3 = $composer.startRestartGroup(-712568069);
        ComposerKt.sourceInformation($composer3, "C(CommonDecorationBox)P(12,13,4,14,7,9,8,11,10,3,6,5,2,1)80@3167L105,84@3322L25,101@3932L10,108@4267L5060:TextFieldImpl.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        int i5 = 4;
        if ((i4 & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer3.changed((Object) textFieldType) ? 4 : 2;
        }
        int i6 = 32;
        if ((i4 & 2) != 0) {
            $dirty |= 48;
        } else if ((i2 & 112) == 0) {
            $dirty |= $composer3.changed((Object) str) ? 32 : 16;
        }
        int i7 = 256;
        if ((i4 & 4) != 0) {
            $dirty |= 384;
        } else if ((i2 & 896) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 256 : 128;
        }
        int i8 = 2048;
        if ((i4 & 8) != 0) {
            $dirty |= 3072;
        } else if ((i2 & 7168) == 0) {
            $dirty |= $composer3.changed((Object) visualTransformation2) ? 2048 : 1024;
        }
        int i9 = 16384;
        if ((i4 & 16) != 0) {
            $dirty |= 24576;
        } else if ((i2 & 57344) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 16384 : 8192;
        }
        int i10 = i4 & 32;
        if (i10 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            Function2<? super Composer, ? super Integer, Unit> function23 = placeholder;
        } else if ((i2 & 458752) == 0) {
            $dirty |= $composer3.changedInstance(placeholder) ? 131072 : 65536;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = placeholder;
        }
        int i11 = i4 & 64;
        if (i11 != 0) {
            $dirty |= 1572864;
            Function2<? super Composer, ? super Integer, Unit> function25 = leadingIcon;
        } else if ((i2 & 3670016) == 0) {
            $dirty |= $composer3.changedInstance(leadingIcon) ? 1048576 : 524288;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function26 = leadingIcon;
        }
        int i12 = i4 & 128;
        if (i12 != 0) {
            $dirty |= 12582912;
            Function2<? super Composer, ? super Integer, Unit> function27 = trailingIcon;
        } else if ((i2 & 29360128) == 0) {
            $dirty |= $composer3.changedInstance(trailingIcon) ? 8388608 : 4194304;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function28 = trailingIcon;
        }
        int i13 = i4 & 256;
        if (i13 != 0) {
            $dirty |= 100663296;
            boolean z2 = singleLine;
        } else if ((i2 & 234881024) == 0) {
            $dirty |= $composer3.changed(singleLine) ? 67108864 : 33554432;
        } else {
            boolean z3 = singleLine;
        }
        int i14 = i4 & 512;
        if (i14 != 0) {
            $dirty |= 805306368;
            boolean z4 = enabled;
        } else if ((i2 & 1879048192) == 0) {
            $dirty |= $composer3.changed(enabled) ? 536870912 : 268435456;
        } else {
            boolean z5 = enabled;
        }
        int i15 = i4 & 1024;
        if (i15 != 0) {
            $dirty1 |= 6;
            boolean z6 = isError;
        } else if ((i3 & 14) == 0) {
            if (!$composer3.changed(isError)) {
                i5 = 2;
            }
            $dirty1 |= i5;
        } else {
            boolean z7 = isError;
        }
        if ((i4 & 2048) != 0) {
            $dirty1 |= 48;
        } else if ((i3 & 112) == 0) {
            if (!$composer3.changed((Object) interactionSource2)) {
                i6 = 16;
            }
            $dirty1 |= i6;
        }
        if ((i4 & 4096) != 0) {
            $dirty1 |= 384;
        } else if ((i3 & 896) == 0) {
            if (!$composer3.changed((Object) paddingValues)) {
                i7 = 128;
            }
            $dirty1 |= i7;
        }
        if ((i4 & 8192) != 0) {
            $dirty1 |= 3072;
        } else if ((i3 & 7168) == 0) {
            if (!$composer3.changed((Object) textFieldColors)) {
                i8 = 1024;
            }
            $dirty1 |= i8;
        }
        int i16 = i4 & 16384;
        if (i16 != 0) {
            $dirty1 |= 24576;
            Function2<? super Composer, ? super Integer, Unit> function29 = border;
        } else if ((i3 & 57344) == 0) {
            if (!$composer3.changedInstance(border)) {
                i9 = 8192;
            }
            $dirty1 |= i9;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function210 = border;
        }
        if (($dirty & 1533916891) == 306783378 && (46811 & $dirty1) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            leadingIcon2 = placeholder;
            trailingIcon3 = leadingIcon;
            trailingIcon2 = trailingIcon;
            enabled2 = singleLine;
            isError3 = enabled;
            isError2 = isError;
            border2 = border;
            int i17 = $dirty;
            int i18 = $dirty1;
            $composer2 = $composer3;
        } else {
            if (i10 != 0) {
                placeholder2 = null;
            } else {
                placeholder2 = placeholder;
            }
            if (i11 != 0) {
                leadingIcon3 = null;
            } else {
                leadingIcon3 = leadingIcon;
            }
            if (i12 != 0) {
                trailingIcon4 = null;
            } else {
                trailingIcon4 = trailingIcon;
            }
            if (i13 != 0) {
                singleLine2 = false;
            } else {
                singleLine2 = singleLine;
            }
            if (i14 != 0) {
                enabled3 = true;
            } else {
                enabled3 = enabled;
            }
            if (i15 != 0) {
                isError4 = false;
            } else {
                isError4 = isError;
            }
            if (i16 != 0) {
                border3 = null;
            } else {
                border3 = border;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-712568069, $dirty, $dirty1, "androidx.compose.material.CommonDecorationBox (TextFieldImpl.kt:63)");
            }
            int $changed$iv = (($dirty >> 3) & 14) | (($dirty >> 6) & 112);
            $composer3.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer3.changed((Object) str) | $composer3.changed((Object) visualTransformation2);
            Composer $this$cache$iv$iv = $composer3;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                int i19 = $changed$iv;
                value$iv$iv = visualTransformation2.filter(new AnnotatedString(value, (List) null, (List) null, 6, (DefaultConstructorMarker) null));
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                int i20 = $changed$iv;
                value$iv$iv = it$iv$iv;
            }
            $composer3.endReplaceableGroup();
            String transformedText = ((TransformedText) value$iv$iv).getText().getText();
            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource2, $composer3, ($dirty1 >> 3) & 14).getValue().booleanValue()) {
                inputPhase = InputPhase.Focused;
            } else {
                if (transformedText.length() == 0) {
                    inputPhase = InputPhase.UnfocusedEmpty;
                } else {
                    inputPhase = InputPhase.UnfocusedNotEmpty;
                }
            }
            InputPhase inputState = inputPhase;
            int $dirty2 = $dirty;
            int $dirty12 = $dirty1;
            Composer $composer4 = $composer3;
            Function3 labelColor = new TextFieldImplKt$CommonDecorationBox$labelColor$1(colors, enabled3, isError4, interactionSource, $dirty2, $dirty12);
            Typography typography = MaterialTheme.INSTANCE.getTypography($composer4, 6);
            TextStyle subtitle1 = typography.getSubtitle1();
            TextStyle caption = typography.getCaption();
            boolean shouldOverrideTextStyleColor = (Color.m3165equalsimpl0(subtitle1.m5494getColor0d7_KjU(), Color.Companion.m3200getUnspecified0d7_KjU()) && !Color.m3165equalsimpl0(caption.m5494getColor0d7_KjU(), Color.Companion.m3200getUnspecified0d7_KjU())) || (!Color.m3165equalsimpl0(subtitle1.m5494getColor0d7_KjU(), Color.Companion.m3200getUnspecified0d7_KjU()) && Color.m3165equalsimpl0(caption.m5494getColor0d7_KjU(), Color.Companion.m3200getUnspecified0d7_KjU()));
            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
            $composer4.startReplaceableGroup(2129141006);
            ComposerKt.sourceInformation($composer4, "*110@4363L10,111@4455L22");
            long $this$CommonDecorationBox_u24lambda_u242 = MaterialTheme.INSTANCE.getTypography($composer4, 6).getCaption().m5494getColor0d7_KjU();
            if (shouldOverrideTextStyleColor) {
                long $this$takeOrElse_u2dDxMtmZc$iv = $this$CommonDecorationBox_u24lambda_u242;
                if (!($this$takeOrElse_u2dDxMtmZc$iv != Color.Companion.m3200getUnspecified0d7_KjU())) {
                    $this$takeOrElse_u2dDxMtmZc$iv = ((Color) labelColor.invoke(inputState, $composer4, 0)).m3174unboximpl();
                }
                j = $this$takeOrElse_u2dDxMtmZc$iv;
            } else {
                j = $this$CommonDecorationBox_u24lambda_u242;
            }
            $composer4.endReplaceableGroup();
            $composer4.startReplaceableGroup(2129141197);
            ComposerKt.sourceInformation($composer4, "*113@4554L10,114@4648L22");
            long $this$CommonDecorationBox_u24lambda_u244 = MaterialTheme.INSTANCE.getTypography($composer4, 6).getSubtitle1().m5494getColor0d7_KjU();
            if (shouldOverrideTextStyleColor) {
                long $this$takeOrElse_u2dDxMtmZc$iv2 = $this$CommonDecorationBox_u24lambda_u244;
                if ($this$takeOrElse_u2dDxMtmZc$iv2 != Color.Companion.m3200getUnspecified0d7_KjU()) {
                    long j3 = $this$CommonDecorationBox_u24lambda_u244;
                    z = false;
                } else {
                    long j4 = $this$CommonDecorationBox_u24lambda_u244;
                    z = false;
                    $this$takeOrElse_u2dDxMtmZc$iv2 = ((Color) labelColor.invoke(inputState, $composer4, 0)).m3174unboximpl();
                }
                j2 = $this$takeOrElse_u2dDxMtmZc$iv2;
            } else {
                z = false;
                j2 = $this$CommonDecorationBox_u24lambda_u244;
            }
            $composer4.endReplaceableGroup();
            boolean z8 = label != null ? true : z;
            TextFieldImplKt$CommonDecorationBox$3 textFieldImplKt$CommonDecorationBox$3 = r0;
            TextFieldImplKt$CommonDecorationBox$3 textFieldImplKt$CommonDecorationBox$32 = new TextFieldImplKt$CommonDecorationBox$3(label, placeholder2, transformedText, isError4, $dirty12, colors, enabled3, interactionSource, $dirty2, leadingIcon3, trailingIcon4, type, innerTextField, singleLine2, contentPadding, shouldOverrideTextStyleColor, border3);
            $composer2 = $composer4;
            textFieldTransitionScope.m1692TransitionDTcfvLk(inputState, j, j2, labelColor, z8, ComposableLambdaKt.composableLambda($composer2, 341865432, true, textFieldImplKt$CommonDecorationBox$3), $composer2, 1769472);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            border2 = border3;
            isError2 = isError4;
            isError3 = enabled3;
            enabled2 = singleLine2;
            trailingIcon2 = trailingIcon4;
            trailingIcon3 = leadingIcon3;
            leadingIcon2 = placeholder2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new TextFieldImplKt$CommonDecorationBox$4(type, value, innerTextField, visualTransformation, label, leadingIcon2, trailingIcon3, trailingIcon2, enabled2, isError3, isError2, interactionSource, contentPadding, colors, border2, $changed, $changed1, i));
    }

    /* renamed from: Decoration-euL9pac  reason: not valid java name */
    public static final void m1683DecorationeuL9pac(long contentColor, TextStyle typography, Float contentAlpha, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        TextStyle textStyle;
        Float f;
        Float contentAlpha2;
        TextStyle typography2;
        TextStyle typography3;
        Float contentAlpha3;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-399493340);
        ComposerKt.sourceInformation($composer2, "C(Decoration)P(2:c#ui.graphics.Color,3,1):TextFieldImpl.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
            long j = contentColor;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 4 : 2;
        } else {
            long j2 = contentColor;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            textStyle = typography;
        } else if ((i2 & 112) == 0) {
            textStyle = typography;
            $dirty |= $composer2.changed((Object) textStyle) ? 32 : 16;
        } else {
            textStyle = typography;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            f = contentAlpha;
        } else if ((i2 & 896) == 0) {
            f = contentAlpha;
            $dirty |= $composer2.changed((Object) f) ? 256 : 128;
        } else {
            f = contentAlpha;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                typography3 = null;
            } else {
                typography3 = textStyle;
            }
            if (i4 != 0) {
                contentAlpha3 = null;
            } else {
                contentAlpha3 = f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-399493340, $dirty2, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:231)");
            }
            Function2 colorAndEmphasis = ComposableLambdaKt.composableLambda($composer2, 494684590, true, new TextFieldImplKt$Decoration$colorAndEmphasis$1(contentColor, contentAlpha3, content, $dirty2));
            if (typography3 != null) {
                $composer2.startReplaceableGroup(-2009952864);
                ComposerKt.sourceInformation($composer2, "252@10230L46");
                TextKt.ProvideTextStyle(typography3, colorAndEmphasis, $composer2, (($dirty2 >> 3) & 14) | 48);
            } else {
                $composer2.startReplaceableGroup(-2009952812);
                ComposerKt.sourceInformation($composer2, "252@10282L18");
                colorAndEmphasis.invoke($composer2, 6);
            }
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            typography2 = typography3;
            contentAlpha2 = contentAlpha3;
        } else {
            $composer2.skipToGroupEnd();
            typography2 = textStyle;
            contentAlpha2 = f;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextFieldImplKt$Decoration$1(contentColor, typography2, contentAlpha2, content, $changed, i));
        }
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final Object getLayoutId(IntrinsicMeasurable $this$layoutId) {
        Intrinsics.checkNotNullParameter($this$layoutId, "<this>");
        Object parentData = $this$layoutId.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }
}
