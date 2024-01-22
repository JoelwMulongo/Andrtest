package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JS\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%J×\u0001\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00103\u001a\u0002042\u0013\b\u0002\u00105\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+H\u0007¢\u0006\u0002\u00106JÂ\u0001\u00107\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00103\u001a\u000204H\u0007¢\u0006\u0002\u00108Jç\u0001\u00109\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010@\u001a\u00020;2\b\b\u0002\u0010A\u001a\u00020;2\b\b\u0002\u0010B\u001a\u00020;2\b\b\u0002\u0010C\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ=\u0010R\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010XJç\u0001\u0010Y\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010Z\u001a\u00020;2\b\b\u0002\u0010[\u001a\u00020;2\b\b\u0002\u0010\\\u001a\u00020;2\b\b\u0002\u0010]\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010QJ=\u0010_\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010XJ=\u0010a\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bb\u0010XJM\u0010c\u001a\u00020d*\u00020d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010e\u001a\u00020\u00062\b\b\u0002\u0010f\u001a\u00020\u0006H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bg\u0010hR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\f\u0010\bR\u001c\u0010\r\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0016\u0010\bR\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006i"}, d2 = {"Landroidx/compose/material/TextFieldDefaults;", "", "()V", "BackgroundOpacity", "", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "IconOpacity", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "OutlinedTextFieldShape", "Landroidx/compose/ui/graphics/Shape;", "getOutlinedTextFieldShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "TextFieldShape", "getTextFieldShape", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "UnfocusedIndicatorLineOpacity", "BorderBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material/TextFieldColors;", "shape", "focusedBorderThickness", "unfocusedBorderThickness", "BorderBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "OutlinedTextFieldDecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "border", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "TextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "outlinedTextFieldColors", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-dx8h9Zs", "(JJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "outlinedTextFieldPadding", "start", "top", "end", "bottom", "outlinedTextFieldPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-dx8h9Zs", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
public final class TextFieldDefaults {
    public static final int $stable = 0;
    public static final float BackgroundOpacity = 0.12f;
    private static final float FocusedBorderThickness = Dp.m5986constructorimpl((float) 2);
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    public static final float IconOpacity = 0.54f;
    private static final float MinHeight = Dp.m5986constructorimpl((float) 56);
    private static final float MinWidth = Dp.m5986constructorimpl((float) 280);
    private static final float UnfocusedBorderThickness = Dp.m5986constructorimpl((float) 1);
    public static final float UnfocusedIndicatorLineOpacity = 0.42f;

    private TextFieldDefaults() {
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m1672getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m1673getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    public final Shape getTextFieldShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1117199624, "C215@7733L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1117199624, $changed, -1, "androidx.compose.material.TextFieldDefaults.<get-TextFieldShape> (TextFieldDefaults.kt:215)");
        }
        CornerBasedShape copy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes($composer, 6).getSmall(), (CornerSize) null, (CornerSize) null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return copy$default;
    }

    public final Shape getOutlinedTextFieldShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1899109048, "C224@8035L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1899109048, $changed, -1, "androidx.compose.material.TextFieldDefaults.<get-OutlinedTextFieldShape> (TextFieldDefaults.kt:224)");
        }
        CornerBasedShape small = MaterialTheme.INSTANCE.getShapes($composer, 6).getSmall();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return small;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m1674getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m1671getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* renamed from: indicatorLine-gv0btCI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1666indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, int i, Object obj) {
        float f3;
        float f4;
        if ((i & 16) != 0) {
            f3 = FocusedBorderThickness;
        } else {
            f3 = f;
        }
        if ((i & 32) != 0) {
            f4 = UnfocusedBorderThickness;
        } else {
            f4 = f2;
        }
        return textFieldDefaults.m1675indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f3, f4);
    }

    /* renamed from: indicatorLine-gv0btCI  reason: not valid java name */
    public final Modifier m1675indicatorLinegv0btCI(Modifier $this$indicatorLine_u2dgv0btCI, boolean enabled, boolean isError, InteractionSource interactionSource, TextFieldColors colors, float focusedIndicatorLineThickness, float unfocusedIndicatorLineThickness) {
        Modifier modifier = $this$indicatorLine_u2dgv0btCI;
        Intrinsics.checkNotNullParameter($this$indicatorLine_u2dgv0btCI, "$this$indicatorLine");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(colors, "colors");
        return ComposedModifierKt.composed($this$indicatorLine_u2dgv0btCI, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TextFieldDefaults$indicatorLinegv0btCI$$inlined$debugInspectorInfo$1(enabled, isError, interactionSource, colors, focusedIndicatorLineThickness, unfocusedIndicatorLineThickness) : InspectableValueKt.getNoInspectorInfo(), new TextFieldDefaults$indicatorLine$2(enabled, isError, interactionSource, colors, focusedIndicatorLineThickness, unfocusedIndicatorLineThickness));
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x011a  */
    /* renamed from: BorderBox-nbWgWpA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1670BorderBoxnbWgWpA(boolean r22, boolean r23, androidx.compose.foundation.interaction.InteractionSource r24, androidx.compose.material.TextFieldColors r25, androidx.compose.ui.graphics.Shape r26, float r27, float r28, androidx.compose.runtime.Composer r29, int r30, int r31) {
        /*
            r21 = this;
            r11 = r21
            r12 = r24
            r13 = r25
            r14 = r30
            r10 = r31
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "colors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 943754022(0x38408b26, float:4.590596E-5)
            r1 = r29
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BorderBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)314@11791L22,318@11975L203,326@12187L47:TextFieldDefaults.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r30
            r2 = r10 & 1
            if (r2 == 0) goto L_0x002e
            r1 = r1 | 6
            r9 = r22
            goto L_0x0041
        L_0x002e:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x003f
            r9 = r22
            boolean r2 = r15.changed((boolean) r9)
            if (r2 == 0) goto L_0x003c
            r2 = 4
            goto L_0x003d
        L_0x003c:
            r2 = 2
        L_0x003d:
            r1 = r1 | r2
            goto L_0x0041
        L_0x003f:
            r9 = r22
        L_0x0041:
            r2 = r10 & 2
            if (r2 == 0) goto L_0x004a
            r1 = r1 | 48
            r8 = r23
            goto L_0x005f
        L_0x004a:
            r2 = r14 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x005d
            r8 = r23
            boolean r2 = r15.changed((boolean) r8)
            if (r2 == 0) goto L_0x0059
            r2 = 32
            goto L_0x005b
        L_0x0059:
            r2 = 16
        L_0x005b:
            r1 = r1 | r2
            goto L_0x005f
        L_0x005d:
            r8 = r23
        L_0x005f:
            r2 = r10 & 4
            if (r2 == 0) goto L_0x0066
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x0076
        L_0x0066:
            r2 = r14 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0076
            boolean r2 = r15.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0073
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0075
        L_0x0073:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0075:
            r1 = r1 | r2
        L_0x0076:
            r2 = r10 & 8
            if (r2 == 0) goto L_0x007d
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x008d
        L_0x007d:
            r2 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x008d
            boolean r2 = r15.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x008a
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x008c
        L_0x008a:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x008c:
            r1 = r1 | r2
        L_0x008d:
            r2 = 57344(0xe000, float:8.0356E-41)
            r3 = r14 & r2
            if (r3 != 0) goto L_0x00a9
            r3 = r10 & 16
            if (r3 != 0) goto L_0x00a3
            r3 = r26
            boolean r4 = r15.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x00a5
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a7
        L_0x00a3:
            r3 = r26
        L_0x00a5:
            r4 = 8192(0x2000, float:1.14794E-41)
        L_0x00a7:
            r1 = r1 | r4
            goto L_0x00ab
        L_0x00a9:
            r3 = r26
        L_0x00ab:
            r4 = 458752(0x70000, float:6.42848E-40)
            r5 = r14 & r4
            if (r5 != 0) goto L_0x00c6
            r5 = r10 & 32
            if (r5 != 0) goto L_0x00c0
            r5 = r27
            boolean r6 = r15.changed((float) r5)
            if (r6 == 0) goto L_0x00c2
            r6 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c4
        L_0x00c0:
            r5 = r27
        L_0x00c2:
            r6 = 65536(0x10000, float:9.18355E-41)
        L_0x00c4:
            r1 = r1 | r6
            goto L_0x00c8
        L_0x00c6:
            r5 = r27
        L_0x00c8:
            r6 = 3670016(0x380000, float:5.142788E-39)
            r6 = r6 & r14
            if (r6 != 0) goto L_0x00e2
            r6 = r10 & 64
            if (r6 != 0) goto L_0x00dc
            r6 = r28
            boolean r7 = r15.changed((float) r6)
            if (r7 == 0) goto L_0x00de
            r7 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e0
        L_0x00dc:
            r6 = r28
        L_0x00de:
            r7 = 524288(0x80000, float:7.34684E-40)
        L_0x00e0:
            r1 = r1 | r7
            goto L_0x00e4
        L_0x00e2:
            r6 = r28
        L_0x00e4:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x00ec
            r7 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00ea:
            r1 = r1 | r7
            goto L_0x00fd
        L_0x00ec:
            r7 = 29360128(0x1c00000, float:7.052966E-38)
            r7 = r7 & r14
            if (r7 != 0) goto L_0x00fd
            boolean r7 = r15.changed((java.lang.Object) r11)
            if (r7 == 0) goto L_0x00fa
            r7 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ea
        L_0x00fa:
            r7 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00ea
        L_0x00fd:
            r7 = 23967451(0x16db6db, float:4.3661218E-38)
            r7 = r7 & r1
            r4 = 4793490(0x492492, float:6.71711E-39)
            if (r7 != r4) goto L_0x011a
            boolean r4 = r15.getSkipping()
            if (r4 != 0) goto L_0x010d
            goto L_0x011a
        L_0x010d:
            r15.skipToGroupEnd()
            r19 = r1
            r16 = r3
            r17 = r5
            r18 = r6
            goto L_0x01d8
        L_0x011a:
            r15.startDefaults()
            r4 = r14 & 1
            r7 = -3670017(0xffffffffffc7ffff, float:NaN)
            r16 = -458753(0xfffffffffff8ffff, float:NaN)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r4 == 0) goto L_0x014c
            boolean r4 = r15.getDefaultsInvalid()
            if (r4 == 0) goto L_0x0131
            goto L_0x014c
        L_0x0131:
            r15.skipToGroupEnd()
            r4 = r10 & 16
            if (r4 == 0) goto L_0x013a
            r1 = r1 & r17
        L_0x013a:
            r4 = r10 & 32
            if (r4 == 0) goto L_0x0140
            r1 = r1 & r16
        L_0x0140:
            r4 = r10 & 64
            if (r4 == 0) goto L_0x0145
            r1 = r1 & r7
        L_0x0145:
            r7 = r3
            r16 = r5
            r17 = r6
            r6 = r1
            goto L_0x0177
        L_0x014c:
            r4 = r10 & 16
            if (r4 == 0) goto L_0x015a
            int r4 = r1 >> 21
            r4 = r4 & 14
            androidx.compose.ui.graphics.Shape r3 = r11.getOutlinedTextFieldShape(r15, r4)
            r1 = r1 & r17
        L_0x015a:
            r4 = r10 & 32
            if (r4 == 0) goto L_0x0163
            float r4 = FocusedBorderThickness
            r1 = r1 & r16
            r5 = r4
        L_0x0163:
            r4 = r10 & 64
            if (r4 == 0) goto L_0x0171
            float r4 = UnfocusedBorderThickness
            r1 = r1 & r7
            r6 = r1
            r7 = r3
            r17 = r4
            r16 = r5
            goto L_0x0177
        L_0x0171:
            r7 = r3
            r16 = r5
            r17 = r6
            r6 = r1
        L_0x0177:
            r15.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0186
            r1 = -1
            java.lang.String r3 = "androidx.compose.material.TextFieldDefaults.BorderBox (TextFieldDefaults.kt:309)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r1, r3)
        L_0x0186:
            r0 = r6 & 14
            r1 = r6 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r6 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r6 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r6 >> 3
            r1 = r1 & r2
            r0 = r0 | r1
            int r1 = r6 >> 3
            r2 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r2
            r18 = r0 | r1
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r16
            r5 = r17
            r19 = r6
            r6 = r15
            r8 = r7
            r7 = r18
            androidx.compose.runtime.State r0 = androidx.compose.material.TextFieldDefaultsKt.m1682animateBorderStrokeAsStateNuRrP5Q(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            java.lang.Object r2 = r0.getValue()
            androidx.compose.foundation.BorderStroke r2 = (androidx.compose.foundation.BorderStroke) r2
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.BorderKt.border(r1, r2, r8)
            r2 = 0
            androidx.compose.foundation.layout.BoxKt.Box(r1, r15, r2)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01d2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01d2:
            r18 = r17
            r17 = r16
            r16 = r8
        L_0x01d8:
            androidx.compose.runtime.ScopeUpdateScope r8 = r15.endRestartGroup()
            if (r8 != 0) goto L_0x01df
            goto L_0x0202
        L_0x01df:
            androidx.compose.material.TextFieldDefaults$BorderBox$1 r20 = new androidx.compose.material.TextFieldDefaults$BorderBox$1
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r16
            r7 = r17
            r11 = r8
            r8 = r18
            r9 = r30
            r10 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x0202:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.m1670BorderBoxnbWgWpA(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: textFieldWithLabelPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m1668textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getFirstBaselineOffset();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldBottomPadding();
        }
        return textFieldDefaults.m1679textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: textFieldWithLabelPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m1679textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m756PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m1669textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1680textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m1680textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m756PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: outlinedTextFieldPadding-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m1667outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return textFieldDefaults.m1677outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: outlinedTextFieldPadding-a9UjIt4  reason: not valid java name */
    public final PaddingValues m1677outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m756PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: textFieldColors-dx8h9Zs  reason: not valid java name */
    public final TextFieldColors m1678textFieldColorsdx8h9Zs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedIndicatorColor, long unfocusedIndicatorColor, long disabledIndicatorColor, long errorIndicatorColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long disabledTextColor2;
        long backgroundColor2;
        long cursorColor2;
        long errorCursorColor2;
        long focusedIndicatorColor2;
        long unfocusedIndicatorColor2;
        long disabledIndicatorColor2;
        long errorIndicatorColor2;
        long leadingIconColor2;
        long disabledLeadingIconColor2;
        long errorLeadingIconColor2;
        long trailingIconColor2;
        long disabledTrailingIconColor2;
        long errorTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(231892599);
        ComposerKt.sourceInformation(composer, "C(textFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)377@14111L7,377@14142L7,378@14215L8,379@14273L6,380@14366L6,381@14430L6,383@14509L6,383@14550L4,385@14624L6,386@14776L8,387@14838L6,389@14912L6,390@15041L8,393@15170L6,394@15301L8,395@15366L6,397@15441L6,397@15482L4,398@15540L6,398@15575L6,399@15658L8,400@15716L6,401@15778L6,401@15813L6,402@15899L8:TextFieldDefaults.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer);
            long r9 = ((Color) consume).m3174unboximpl();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd($composer);
            textColor2 = Color.m3163copywmQWz5c$default(r9, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            textColor2 = textColor;
        }
        if ((i2 & 2) != 0) {
            disabledTextColor2 = Color.m3163copywmQWz5c$default(textColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i2 & 4) != 0) {
            backgroundColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((i2 & 8) != 0) {
            cursorColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1445getPrimary0d7_KjU();
        } else {
            cursorColor2 = cursorColor;
        }
        if ((i2 & 16) != 0) {
            errorCursorColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1439getError0d7_KjU();
        } else {
            errorCursorColor2 = errorCursorColor;
        }
        if ((i2 & 32) != 0) {
            focusedIndicatorColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1445getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            focusedIndicatorColor2 = focusedIndicatorColor;
        }
        if ((i2 & 64) != 0) {
            unfocusedIndicatorColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            unfocusedIndicatorColor2 = unfocusedIndicatorColor;
        }
        if ((i2 & 128) != 0) {
            disabledIndicatorColor2 = Color.m3163copywmQWz5c$default(unfocusedIndicatorColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledIndicatorColor2 = disabledIndicatorColor;
        }
        if ((i2 & 256) != 0) {
            errorIndicatorColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1439getError0d7_KjU();
        } else {
            errorIndicatorColor2 = errorIndicatorColor;
        }
        if ((i2 & 512) != 0) {
            leadingIconColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i2 & 1024) != 0) {
            disabledLeadingIconColor2 = Color.m3163copywmQWz5c$default(leadingIconColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i2 & 2048) != 0) {
            errorLeadingIconColor2 = leadingIconColor2;
        } else {
            errorLeadingIconColor2 = errorLeadingIconColor;
        }
        if ((i2 & 4096) != 0) {
            trailingIconColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i2 & 8192) != 0) {
            disabledTrailingIconColor2 = Color.m3163copywmQWz5c$default(trailingIconColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((i2 & 16384) != 0) {
            errorTrailingIconColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1439getError0d7_KjU();
        } else {
            errorTrailingIconColor2 = errorTrailingIconColor;
        }
        if ((32768 & i2) != 0) {
            focusedLabelColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1445getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((65536 & i2) != 0) {
            unfocusedLabelColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((131072 & i2) != 0) {
            disabledLabelColor2 = Color.m3163copywmQWz5c$default(unfocusedLabelColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((262144 & i2) != 0) {
            errorLabelColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1439getError0d7_KjU();
        } else {
            errorLabelColor2 = errorLabelColor;
        }
        if ((524288 & i2) != 0) {
            placeholderColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i2 & 1048576) != 0) {
            disabledPlaceholderColor2 = Color.m3163copywmQWz5c$default(placeholderColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(231892599, $changed, $changed1, "androidx.compose.material.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:376)");
        } else {
            int i3 = $changed;
            int i4 = $changed1;
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedIndicatorColor2, unfocusedIndicatorColor2, errorIndicatorColor2, disabledIndicatorColor2, leadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, trailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    /* renamed from: outlinedTextFieldColors-dx8h9Zs  reason: not valid java name */
    public final TextFieldColors m1676outlinedTextFieldColorsdx8h9Zs(long textColor, long disabledTextColor, long backgroundColor, long cursorColor, long errorCursorColor, long focusedBorderColor, long unfocusedBorderColor, long disabledBorderColor, long errorBorderColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor, Composer $composer, int $changed, int $changed1, int $changed2, int i) {
        long textColor2;
        long disabledTextColor2;
        long backgroundColor2;
        long cursorColor2;
        long errorCursorColor2;
        long focusedBorderColor2;
        long unfocusedBorderColor2;
        long disabledBorderColor2;
        long errorBorderColor2;
        long leadingIconColor2;
        long disabledLeadingIconColor2;
        long errorLeadingIconColor2;
        long trailingIconColor2;
        long disabledTrailingIconColor2;
        long errorTrailingIconColor2;
        long focusedLabelColor2;
        long unfocusedLabelColor2;
        long disabledLabelColor2;
        long errorLabelColor2;
        long placeholderColor2;
        long disabledPlaceholderColor2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(1762667317);
        ComposerKt.sourceInformation(composer, "C(outlinedTextFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)435@17427L7,435@17458L7,436@17531L8,438@17637L6,439@17701L6,441@17777L6,441@17818L4,443@17889L6,443@17932L8,444@18027L8,445@18086L6,447@18160L6,448@18289L8,451@18418L6,452@18549L8,453@18614L6,455@18689L6,455@18730L4,456@18788L6,456@18823L6,457@18906L8,458@18964L6,459@19026L6,459@19061L6,460@19147L8:TextFieldDefaults.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer);
            long r9 = ((Color) consume).m3174unboximpl();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(ContentAlphaKt.getLocalContentAlpha());
            ComposerKt.sourceInformationMarkerEnd($composer);
            textColor2 = Color.m3163copywmQWz5c$default(r9, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            textColor2 = textColor;
        }
        if ((i2 & 2) != 0) {
            disabledTextColor2 = Color.m3163copywmQWz5c$default(textColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledTextColor2 = disabledTextColor;
        }
        if ((i2 & 4) != 0) {
            backgroundColor2 = Color.Companion.m3199getTransparent0d7_KjU();
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((i2 & 8) != 0) {
            cursorColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1445getPrimary0d7_KjU();
        } else {
            cursorColor2 = cursorColor;
        }
        if ((i2 & 16) != 0) {
            errorCursorColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1439getError0d7_KjU();
        } else {
            errorCursorColor2 = errorCursorColor;
        }
        if ((i2 & 32) != 0) {
            focusedBorderColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1445getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            focusedBorderColor2 = focusedBorderColor;
        }
        if ((i2 & 64) != 0) {
            unfocusedBorderColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            unfocusedBorderColor2 = unfocusedBorderColor;
        }
        if ((i2 & 128) != 0) {
            disabledBorderColor2 = Color.m3163copywmQWz5c$default(unfocusedBorderColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        if ((i2 & 256) != 0) {
            errorBorderColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1439getError0d7_KjU();
        } else {
            errorBorderColor2 = errorBorderColor;
        }
        if ((i2 & 512) != 0) {
            leadingIconColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            leadingIconColor2 = leadingIconColor;
        }
        if ((i2 & 1024) != 0) {
            disabledLeadingIconColor2 = Color.m3163copywmQWz5c$default(leadingIconColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i2 & 2048) != 0) {
            errorLeadingIconColor2 = leadingIconColor2;
        } else {
            errorLeadingIconColor2 = errorLeadingIconColor;
        }
        if ((i2 & 4096) != 0) {
            trailingIconColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            trailingIconColor2 = trailingIconColor;
        }
        if ((i2 & 8192) != 0) {
            disabledTrailingIconColor2 = Color.m3163copywmQWz5c$default(trailingIconColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((i2 & 16384) != 0) {
            errorTrailingIconColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1439getError0d7_KjU();
        } else {
            errorTrailingIconColor2 = errorTrailingIconColor;
        }
        if ((32768 & i2) != 0) {
            focusedLabelColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1445getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            focusedLabelColor2 = focusedLabelColor;
        }
        if ((65536 & i2) != 0) {
            unfocusedLabelColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            unfocusedLabelColor2 = unfocusedLabelColor;
        }
        if ((131072 & i2) != 0) {
            disabledLabelColor2 = Color.m3163copywmQWz5c$default(unfocusedLabelColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((262144 & i2) != 0) {
            errorLabelColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1439getError0d7_KjU();
        } else {
            errorLabelColor2 = errorLabelColor;
        }
        if ((524288 & i2) != 0) {
            placeholderColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            placeholderColor2 = placeholderColor;
        }
        if ((i2 & 1048576) != 0) {
            disabledPlaceholderColor2 = Color.m3163copywmQWz5c$default(placeholderColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledPlaceholderColor2 = disabledPlaceholderColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1762667317, $changed, $changed1, "androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:434)");
        } else {
            int i3 = $changed;
            int i4 = $changed1;
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(textColor2, disabledTextColor2, cursorColor2, errorCursorColor2, focusedBorderColor2, unfocusedBorderColor2, errorBorderColor2, disabledBorderColor2, leadingIconColor2, disabledLeadingIconColor2, errorLeadingIconColor2, trailingIconColor2, disabledTrailingIconColor2, errorTrailingIconColor2, backgroundColor2, focusedLabelColor2, unfocusedLabelColor2, disabledLabelColor2, errorLabelColor2, placeholderColor2, disabledPlaceholderColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01b5, code lost:
        if (r7.changed((java.lang.Object) r80) != false) goto L_0x01bc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0397  */
    /* JADX WARNING: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void TextFieldDecorationBox(java.lang.String r68, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, boolean r70, boolean r71, androidx.compose.ui.text.input.VisualTransformation r72, androidx.compose.foundation.interaction.InteractionSource r73, boolean r74, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, androidx.compose.material.TextFieldColors r79, androidx.compose.foundation.layout.PaddingValues r80, androidx.compose.runtime.Composer r81, int r82, int r83, int r84) {
        /*
            r67 = this;
            r15 = r68
            r13 = r69
            r12 = r72
            r11 = r73
            r10 = r82
            r9 = r83
            r8 = r84
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "innerTextField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1171040065(0x45cca741, float:6548.9067)
            r1 = r81
            androidx.compose.runtime.Composer r7 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TextFieldDecorationBox)P(11,3,2,9,12,4,5,6,8,7,10)554@25036L17,562@25270L569:TextFieldDefaults.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r1)
            r1 = r82
            r2 = r83
            r3 = r8 & 1
            if (r3 == 0) goto L_0x003f
            r1 = r1 | 6
            goto L_0x004d
        L_0x003f:
            r3 = r10 & 14
            if (r3 != 0) goto L_0x004d
            boolean r3 = r7.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x004b
            r3 = 4
            goto L_0x004c
        L_0x004b:
            r3 = 2
        L_0x004c:
            r1 = r1 | r3
        L_0x004d:
            r3 = r8 & 2
            if (r3 == 0) goto L_0x0054
            r1 = r1 | 48
            goto L_0x0064
        L_0x0054:
            r3 = r10 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0064
            boolean r3 = r7.changedInstance(r13)
            if (r3 == 0) goto L_0x0061
            r3 = 32
            goto L_0x0063
        L_0x0061:
            r3 = 16
        L_0x0063:
            r1 = r1 | r3
        L_0x0064:
            r3 = r8 & 4
            r16 = 256(0x100, float:3.59E-43)
            r17 = 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0071
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r70
            goto L_0x0087
        L_0x0071:
            r3 = r10 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0085
            r3 = r70
            boolean r18 = r7.changed((boolean) r3)
            if (r18 == 0) goto L_0x0080
            r18 = r16
            goto L_0x0082
        L_0x0080:
            r18 = r17
        L_0x0082:
            r1 = r1 | r18
            goto L_0x0087
        L_0x0085:
            r3 = r70
        L_0x0087:
            r18 = r8 & 8
            r19 = 1024(0x400, float:1.435E-42)
            r20 = 2048(0x800, float:2.87E-42)
            if (r18 == 0) goto L_0x0094
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r4 = r71
            goto L_0x00aa
        L_0x0094:
            r4 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x00a8
            r4 = r71
            boolean r18 = r7.changed((boolean) r4)
            if (r18 == 0) goto L_0x00a3
            r18 = r20
            goto L_0x00a5
        L_0x00a3:
            r18 = r19
        L_0x00a5:
            r1 = r1 | r18
            goto L_0x00aa
        L_0x00a8:
            r4 = r71
        L_0x00aa:
            r18 = r8 & 16
            r64 = 57344(0xe000, float:8.0356E-41)
            if (r18 == 0) goto L_0x00b4
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00c5
        L_0x00b4:
            r18 = r10 & r64
            if (r18 != 0) goto L_0x00c5
            boolean r18 = r7.changed((java.lang.Object) r12)
            if (r18 == 0) goto L_0x00c1
            r18 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00c3
        L_0x00c1:
            r18 = 8192(0x2000, float:1.14794E-41)
        L_0x00c3:
            r1 = r1 | r18
        L_0x00c5:
            r18 = r8 & 32
            r65 = 458752(0x70000, float:6.42848E-40)
            if (r18 == 0) goto L_0x00d0
            r18 = 196608(0x30000, float:2.75506E-40)
        L_0x00cd:
            r1 = r1 | r18
            goto L_0x00e0
        L_0x00d0:
            r18 = r10 & r65
            if (r18 != 0) goto L_0x00e0
            boolean r18 = r7.changed((java.lang.Object) r11)
            if (r18 == 0) goto L_0x00dd
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cd
        L_0x00dd:
            r18 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00cd
        L_0x00e0:
            r18 = r8 & 64
            if (r18 == 0) goto L_0x00eb
            r21 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r21
            r5 = r74
            goto L_0x0103
        L_0x00eb:
            r21 = 3670016(0x380000, float:5.142788E-39)
            r21 = r10 & r21
            if (r21 != 0) goto L_0x0101
            r5 = r74
            boolean r22 = r7.changed((boolean) r5)
            if (r22 == 0) goto L_0x00fc
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fe
        L_0x00fc:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00fe:
            r1 = r1 | r22
            goto L_0x0103
        L_0x0101:
            r5 = r74
        L_0x0103:
            r6 = r8 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x010e
            r23 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r23
            r14 = r75
            goto L_0x0126
        L_0x010e:
            r23 = 29360128(0x1c00000, float:7.052966E-38)
            r23 = r10 & r23
            if (r23 != 0) goto L_0x0124
            r14 = r75
            boolean r24 = r7.changedInstance(r14)
            if (r24 == 0) goto L_0x011f
            r24 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0121
        L_0x011f:
            r24 = 4194304(0x400000, float:5.877472E-39)
        L_0x0121:
            r1 = r1 | r24
            goto L_0x0126
        L_0x0124:
            r14 = r75
        L_0x0126:
            r0 = r8 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0131
            r24 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r24
            r3 = r76
            goto L_0x0149
        L_0x0131:
            r24 = 234881024(0xe000000, float:1.5777218E-30)
            r24 = r10 & r24
            if (r24 != 0) goto L_0x0147
            r3 = r76
            boolean r24 = r7.changedInstance(r3)
            if (r24 == 0) goto L_0x0142
            r24 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0144
        L_0x0142:
            r24 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0144:
            r1 = r1 | r24
            goto L_0x0149
        L_0x0147:
            r3 = r76
        L_0x0149:
            r3 = r8 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x0154
            r24 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r24
            r4 = r77
            goto L_0x016c
        L_0x0154:
            r24 = 1879048192(0x70000000, float:1.58456325E29)
            r24 = r10 & r24
            if (r24 != 0) goto L_0x016a
            r4 = r77
            boolean r24 = r7.changedInstance(r4)
            if (r24 == 0) goto L_0x0165
            r24 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0167
        L_0x0165:
            r24 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0167:
            r1 = r1 | r24
            goto L_0x016c
        L_0x016a:
            r4 = r77
        L_0x016c:
            r4 = r8 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0175
            r2 = r2 | 6
            r5 = r78
            goto L_0x018b
        L_0x0175:
            r24 = r9 & 14
            if (r24 != 0) goto L_0x0189
            r5 = r78
            boolean r24 = r7.changedInstance(r5)
            if (r24 == 0) goto L_0x0184
            r21 = 4
            goto L_0x0186
        L_0x0184:
            r21 = 2
        L_0x0186:
            r2 = r2 | r21
            goto L_0x018b
        L_0x0189:
            r5 = r78
        L_0x018b:
            r21 = r9 & 112(0x70, float:1.57E-43)
            if (r21 != 0) goto L_0x01a5
            r5 = r8 & 2048(0x800, float:2.87E-42)
            if (r5 != 0) goto L_0x019e
            r5 = r79
            boolean r21 = r7.changed((java.lang.Object) r5)
            if (r21 == 0) goto L_0x01a0
            r22 = 32
            goto L_0x01a2
        L_0x019e:
            r5 = r79
        L_0x01a0:
            r22 = 16
        L_0x01a2:
            r2 = r2 | r22
            goto L_0x01a7
        L_0x01a5:
            r5 = r79
        L_0x01a7:
            r5 = r9 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x01bf
            r5 = r8 & 4096(0x1000, float:5.74E-42)
            if (r5 != 0) goto L_0x01b8
            r5 = r80
            boolean r21 = r7.changed((java.lang.Object) r5)
            if (r21 == 0) goto L_0x01ba
            goto L_0x01bc
        L_0x01b8:
            r5 = r80
        L_0x01ba:
            r16 = r17
        L_0x01bc:
            r2 = r2 | r16
            goto L_0x01c1
        L_0x01bf:
            r5 = r80
        L_0x01c1:
            r5 = r8 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x01ca
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r5 = r67
            goto L_0x01dd
        L_0x01ca:
            r5 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x01db
            r5 = r67
            boolean r16 = r7.changed((java.lang.Object) r5)
            if (r16 == 0) goto L_0x01d8
            r19 = r20
        L_0x01d8:
            r2 = r2 | r19
            goto L_0x01dd
        L_0x01db:
            r5 = r67
        L_0x01dd:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r5 = r1 & r16
            r9 = 306783378(0x12492492, float:6.3469493E-28)
            if (r5 != r9) goto L_0x020d
            r5 = r2 & 5851(0x16db, float:8.199E-42)
            r9 = 1170(0x492, float:1.64E-42)
            if (r5 != r9) goto L_0x020d
            boolean r5 = r7.getSkipping()
            if (r5 != 0) goto L_0x01f4
            goto L_0x020d
        L_0x01f4:
            r7.skipToGroupEnd()
            r19 = r74
            r21 = r76
            r22 = r77
            r23 = r78
            r24 = r79
            r25 = r80
            r26 = r1
            r28 = r2
            r27 = r7
            r20 = r14
            goto L_0x0390
        L_0x020d:
            r7.startDefaults()
            r5 = r10 & 1
            if (r5 == 0) goto L_0x024c
            boolean r5 = r7.getDefaultsInvalid()
            if (r5 == 0) goto L_0x021b
            goto L_0x024c
        L_0x021b:
            r7.skipToGroupEnd()
            r0 = r8 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0224
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0224:
            r0 = r8 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x023b
            r0 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            r19 = r74
            r21 = r76
            r22 = r77
            r23 = r78
            r24 = r79
            r25 = r80
            r9 = r0
            r20 = r14
            goto L_0x02fb
        L_0x023b:
            r19 = r74
            r21 = r76
            r22 = r77
            r23 = r78
            r24 = r79
            r25 = r80
            r9 = r2
            r20 = r14
            goto L_0x02fb
        L_0x024c:
            if (r18 == 0) goto L_0x0250
            r5 = 0
            goto L_0x0252
        L_0x0250:
            r5 = r74
        L_0x0252:
            if (r6 == 0) goto L_0x0256
            r6 = 0
            r14 = r6
        L_0x0256:
            if (r0 == 0) goto L_0x025a
            r0 = 0
            goto L_0x025c
        L_0x025a:
            r0 = r76
        L_0x025c:
            if (r3 == 0) goto L_0x0260
            r3 = 0
            goto L_0x0262
        L_0x0260:
            r3 = r77
        L_0x0262:
            if (r4 == 0) goto L_0x0266
            r4 = 0
            goto L_0x0268
        L_0x0266:
            r4 = r78
        L_0x0268:
            r6 = r8 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x02ac
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r53 = 0
            r55 = 0
            r57 = 0
            r60 = 0
            r61 = 0
            int r6 = r2 >> 6
            r62 = r6 & 112(0x70, float:1.57E-43)
            r63 = 2097151(0x1fffff, float:2.938734E-39)
            r16 = r67
            r59 = r7
            androidx.compose.material.TextFieldColors r6 = r16.m1678textFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x02ae
        L_0x02ac:
            r6 = r79
        L_0x02ae:
            r9 = r8 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x02ec
            if (r14 != 0) goto L_0x02c7
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 15
            r27 = 0
            r21 = r67
            androidx.compose.foundation.layout.PaddingValues r9 = m1669textFieldWithoutLabelPaddinga9UjIt4$default(r21, r22, r23, r24, r25, r26, r27)
            goto L_0x02d9
        L_0x02c7:
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 15
            r27 = 0
            r21 = r67
            androidx.compose.foundation.layout.PaddingValues r9 = m1668textFieldWithLabelPaddinga9UjIt4$default(r21, r22, r23, r24, r25, r26, r27)
        L_0x02d9:
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            r21 = r0
            r22 = r3
            r23 = r4
            r19 = r5
            r24 = r6
            r25 = r9
            r20 = r14
            r9 = r2
            goto L_0x02fb
        L_0x02ec:
            r25 = r80
            r21 = r0
            r9 = r2
            r22 = r3
            r23 = r4
            r19 = r5
            r24 = r6
            r20 = r14
        L_0x02fb:
            r7.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x030c
            java.lang.String r0 = "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:542)"
            r2 = 1171040065(0x45cca741, float:6548.9067)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r9, r0)
        L_0x030c:
            androidx.compose.material.TextFieldType r0 = androidx.compose.material.TextFieldType.Filled
            r14 = 0
            int r2 = r1 << 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | 6
            int r3 = r1 << 3
            r3 = r3 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            int r3 = r1 >> 3
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            int r3 = r1 >> 9
            r3 = r3 & r64
            r2 = r2 | r3
            int r3 = r1 >> 9
            r3 = r3 & r65
            r2 = r2 | r3
            r3 = 3670016(0x380000, float:5.142788E-39)
            int r4 = r1 >> 9
            r3 = r3 & r4
            r2 = r2 | r3
            int r3 = r9 << 21
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r4
            r2 = r2 | r3
            int r3 = r1 << 15
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r4
            r2 = r2 | r3
            int r3 = r1 << 21
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r4
            r16 = r2 | r3
            int r2 = r1 >> 18
            r2 = r2 & 14
            int r3 = r1 >> 12
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = r9 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            int r3 = r9 << 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r17 = r2 | r3
            r18 = 16384(0x4000, float:2.2959E-41)
            r26 = r1
            r1 = r68
            r2 = r69
            r3 = r72
            r4 = r20
            r5 = r21
            r6 = r22
            r27 = r7
            r7 = r23
            r8 = r71
            r28 = r9
            r9 = r70
            r10 = r19
            r11 = r73
            r12 = r25
            r13 = r24
            r15 = r27
            androidx.compose.material.TextFieldImplKt.CommonDecorationBox(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0390
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0390:
            androidx.compose.runtime.ScopeUpdateScope r15 = r27.endRestartGroup()
            if (r15 != 0) goto L_0x0397
            goto L_0x03cb
        L_0x0397:
            androidx.compose.material.TextFieldDefaults$TextFieldDecorationBox$1 r18 = new androidx.compose.material.TextFieldDefaults$TextFieldDecorationBox$1
            r0 = r18
            r1 = r67
            r2 = r68
            r3 = r69
            r4 = r70
            r5 = r71
            r6 = r72
            r7 = r73
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r23
            r13 = r24
            r14 = r25
            r66 = r15
            r15 = r82
            r16 = r83
            r17 = r84
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r66
            r1.updateScope(r0)
        L_0x03cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01b9, code lost:
        if (r8.changed((java.lang.Object) r79) != false) goto L_0x01c0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x03e6  */
    /* JADX WARNING: Removed duplicated region for block: B:212:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0158  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void OutlinedTextFieldDecorationBox(java.lang.String r67, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r68, boolean r69, boolean r70, androidx.compose.ui.text.input.VisualTransformation r71, androidx.compose.foundation.interaction.InteractionSource r72, boolean r73, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, androidx.compose.material.TextFieldColors r78, androidx.compose.foundation.layout.PaddingValues r79, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, androidx.compose.runtime.Composer r81, int r82, int r83, int r84) {
        /*
            r66 = this;
            r15 = r67
            r14 = r68
            r13 = r71
            r12 = r72
            r11 = r82
            r10 = r83
            r9 = r84
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "innerTextField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1280721485(0xffffffffb3a9bdb3, float:-7.904182E-8)
            r1 = r81
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(OutlinedTextFieldDecorationBox)P(12,4,3,10,13,5,6,7,9,8,11,1,2)646@30369L25,652@30600L600:TextFieldDefaults.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r82
            r2 = r83
            r3 = r9 & 1
            if (r3 == 0) goto L_0x003f
            r1 = r1 | 6
            goto L_0x004d
        L_0x003f:
            r3 = r11 & 14
            if (r3 != 0) goto L_0x004d
            boolean r3 = r8.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x004b
            r3 = 4
            goto L_0x004c
        L_0x004b:
            r3 = 2
        L_0x004c:
            r1 = r1 | r3
        L_0x004d:
            r3 = r9 & 2
            if (r3 == 0) goto L_0x0054
            r1 = r1 | 48
            goto L_0x0064
        L_0x0054:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0064
            boolean r3 = r8.changedInstance(r14)
            if (r3 == 0) goto L_0x0061
            r3 = 32
            goto L_0x0063
        L_0x0061:
            r3 = 16
        L_0x0063:
            r1 = r1 | r3
        L_0x0064:
            r3 = r9 & 4
            r16 = 256(0x100, float:3.59E-43)
            r17 = 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x0071
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r69
            goto L_0x0087
        L_0x0071:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0085
            r3 = r69
            boolean r18 = r8.changed((boolean) r3)
            if (r18 == 0) goto L_0x0080
            r18 = r16
            goto L_0x0082
        L_0x0080:
            r18 = r17
        L_0x0082:
            r1 = r1 | r18
            goto L_0x0087
        L_0x0085:
            r3 = r69
        L_0x0087:
            r18 = r9 & 8
            r19 = 1024(0x400, float:1.435E-42)
            r20 = 2048(0x800, float:2.87E-42)
            if (r18 == 0) goto L_0x0094
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r4 = r70
            goto L_0x00aa
        L_0x0094:
            r4 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x00a8
            r4 = r70
            boolean r18 = r8.changed((boolean) r4)
            if (r18 == 0) goto L_0x00a3
            r18 = r20
            goto L_0x00a5
        L_0x00a3:
            r18 = r19
        L_0x00a5:
            r1 = r1 | r18
            goto L_0x00aa
        L_0x00a8:
            r4 = r70
        L_0x00aa:
            r18 = r9 & 16
            r21 = 16384(0x4000, float:2.2959E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            r64 = 57344(0xe000, float:8.0356E-41)
            if (r18 == 0) goto L_0x00b8
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00c9
        L_0x00b8:
            r18 = r11 & r64
            if (r18 != 0) goto L_0x00c9
            boolean r18 = r8.changed((java.lang.Object) r13)
            if (r18 == 0) goto L_0x00c5
            r18 = r21
            goto L_0x00c7
        L_0x00c5:
            r18 = r22
        L_0x00c7:
            r1 = r1 | r18
        L_0x00c9:
            r18 = r9 & 32
            if (r18 == 0) goto L_0x00d2
            r18 = 196608(0x30000, float:2.75506E-40)
        L_0x00cf:
            r1 = r1 | r18
            goto L_0x00e4
        L_0x00d2:
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r11 & r18
            if (r18 != 0) goto L_0x00e4
            boolean r18 = r8.changed((java.lang.Object) r12)
            if (r18 == 0) goto L_0x00e1
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cf
        L_0x00e1:
            r18 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00cf
        L_0x00e4:
            r18 = r9 & 64
            if (r18 == 0) goto L_0x00ef
            r23 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r23
            r5 = r73
            goto L_0x0107
        L_0x00ef:
            r23 = 3670016(0x380000, float:5.142788E-39)
            r23 = r11 & r23
            if (r23 != 0) goto L_0x0105
            r5 = r73
            boolean r24 = r8.changed((boolean) r5)
            if (r24 == 0) goto L_0x0100
            r24 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0102
        L_0x0100:
            r24 = 524288(0x80000, float:7.34684E-40)
        L_0x0102:
            r1 = r1 | r24
            goto L_0x0107
        L_0x0105:
            r5 = r73
        L_0x0107:
            r6 = r9 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x0112
            r25 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r25
            r7 = r74
            goto L_0x012a
        L_0x0112:
            r25 = 29360128(0x1c00000, float:7.052966E-38)
            r25 = r11 & r25
            if (r25 != 0) goto L_0x0128
            r7 = r74
            boolean r26 = r8.changedInstance(r7)
            if (r26 == 0) goto L_0x0123
            r26 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0125
        L_0x0123:
            r26 = 4194304(0x400000, float:5.877472E-39)
        L_0x0125:
            r1 = r1 | r26
            goto L_0x012a
        L_0x0128:
            r7 = r74
        L_0x012a:
            r0 = r9 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0135
            r26 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r26
            r3 = r75
            goto L_0x014d
        L_0x0135:
            r26 = 234881024(0xe000000, float:1.5777218E-30)
            r26 = r11 & r26
            if (r26 != 0) goto L_0x014b
            r3 = r75
            boolean r26 = r8.changedInstance(r3)
            if (r26 == 0) goto L_0x0146
            r26 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0148
        L_0x0146:
            r26 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0148:
            r1 = r1 | r26
            goto L_0x014d
        L_0x014b:
            r3 = r75
        L_0x014d:
            r3 = r9 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x0158
            r26 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r26
            r4 = r76
            goto L_0x0170
        L_0x0158:
            r26 = 1879048192(0x70000000, float:1.58456325E29)
            r26 = r11 & r26
            if (r26 != 0) goto L_0x016e
            r4 = r76
            boolean r26 = r8.changedInstance(r4)
            if (r26 == 0) goto L_0x0169
            r26 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x016b
        L_0x0169:
            r26 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x016b:
            r1 = r1 | r26
            goto L_0x0170
        L_0x016e:
            r4 = r76
        L_0x0170:
            r4 = r9 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x0179
            r2 = r2 | 6
            r5 = r77
            goto L_0x018f
        L_0x0179:
            r26 = r10 & 14
            if (r26 != 0) goto L_0x018d
            r5 = r77
            boolean r26 = r8.changedInstance(r5)
            if (r26 == 0) goto L_0x0188
            r23 = 4
            goto L_0x018a
        L_0x0188:
            r23 = 2
        L_0x018a:
            r2 = r2 | r23
            goto L_0x018f
        L_0x018d:
            r5 = r77
        L_0x018f:
            r23 = r10 & 112(0x70, float:1.57E-43)
            if (r23 != 0) goto L_0x01a9
            r5 = r9 & 2048(0x800, float:2.87E-42)
            if (r5 != 0) goto L_0x01a2
            r5 = r78
            boolean r23 = r8.changed((java.lang.Object) r5)
            if (r23 == 0) goto L_0x01a4
            r24 = 32
            goto L_0x01a6
        L_0x01a2:
            r5 = r78
        L_0x01a4:
            r24 = 16
        L_0x01a6:
            r2 = r2 | r24
            goto L_0x01ab
        L_0x01a9:
            r5 = r78
        L_0x01ab:
            r5 = r10 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x01c3
            r5 = r9 & 4096(0x1000, float:5.74E-42)
            if (r5 != 0) goto L_0x01bc
            r5 = r79
            boolean r23 = r8.changed((java.lang.Object) r5)
            if (r23 == 0) goto L_0x01be
            goto L_0x01c0
        L_0x01bc:
            r5 = r79
        L_0x01be:
            r16 = r17
        L_0x01c0:
            r2 = r2 | r16
            goto L_0x01c5
        L_0x01c3:
            r5 = r79
        L_0x01c5:
            r5 = r9 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x01ce
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r7 = r80
            goto L_0x01e1
        L_0x01ce:
            r7 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x01df
            r7 = r80
            boolean r16 = r8.changedInstance(r7)
            if (r16 == 0) goto L_0x01dc
            r19 = r20
        L_0x01dc:
            r2 = r2 | r19
            goto L_0x01e1
        L_0x01df:
            r7 = r80
        L_0x01e1:
            r7 = r9 & 16384(0x4000, float:2.2959E-41)
            if (r7 == 0) goto L_0x01ea
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r7 = r66
            goto L_0x01fe
        L_0x01ea:
            r7 = r10 & r64
            if (r7 != 0) goto L_0x01fc
            r7 = r66
            boolean r16 = r8.changed((java.lang.Object) r7)
            if (r16 == 0) goto L_0x01f7
            goto L_0x01f9
        L_0x01f7:
            r21 = r22
        L_0x01f9:
            r2 = r2 | r21
            goto L_0x01fe
        L_0x01fc:
            r7 = r66
        L_0x01fe:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r7 = r1 & r16
            r10 = 306783378(0x12492492, float:6.3469493E-28)
            if (r7 != r10) goto L_0x0232
            r7 = 46811(0xb6db, float:6.5596E-41)
            r7 = r7 & r2
            r10 = 9362(0x2492, float:1.3119E-41)
            if (r7 != r10) goto L_0x0232
            boolean r7 = r8.getSkipping()
            if (r7 != 0) goto L_0x0217
            goto L_0x0232
        L_0x0217:
            r8.skipToGroupEnd()
            r19 = r73
            r20 = r74
            r21 = r75
            r22 = r76
            r23 = r77
            r24 = r78
            r25 = r79
            r26 = r80
            r27 = r1
            r29 = r2
            r28 = r8
            goto L_0x03df
        L_0x0232:
            r8.startDefaults()
            r7 = r11 & 1
            if (r7 == 0) goto L_0x0275
            boolean r7 = r8.getDefaultsInvalid()
            if (r7 == 0) goto L_0x0240
            goto L_0x0275
        L_0x0240:
            r8.skipToGroupEnd()
            r0 = r9 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0249
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
        L_0x0249:
            r0 = r9 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0262
            r0 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            r19 = r73
            r20 = r74
            r21 = r75
            r22 = r76
            r23 = r77
            r24 = r78
            r25 = r79
            r26 = r80
            r10 = r0
            goto L_0x0342
        L_0x0262:
            r19 = r73
            r20 = r74
            r21 = r75
            r22 = r76
            r23 = r77
            r24 = r78
            r25 = r79
            r26 = r80
            r10 = r2
            goto L_0x0342
        L_0x0275:
            if (r18 == 0) goto L_0x0279
            r7 = 0
            goto L_0x027b
        L_0x0279:
            r7 = r73
        L_0x027b:
            if (r6 == 0) goto L_0x027f
            r6 = 0
            goto L_0x0281
        L_0x027f:
            r6 = r74
        L_0x0281:
            if (r0 == 0) goto L_0x0285
            r0 = 0
            goto L_0x0287
        L_0x0285:
            r0 = r75
        L_0x0287:
            if (r3 == 0) goto L_0x028b
            r3 = 0
            goto L_0x028d
        L_0x028b:
            r3 = r76
        L_0x028d:
            if (r4 == 0) goto L_0x0291
            r4 = 0
            goto L_0x0293
        L_0x0291:
            r4 = r77
        L_0x0293:
            r10 = r9 & 2048(0x800, float:2.87E-42)
            if (r10 == 0) goto L_0x02d7
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r39 = 0
            r41 = 0
            r43 = 0
            r45 = 0
            r47 = 0
            r49 = 0
            r51 = 0
            r53 = 0
            r55 = 0
            r57 = 0
            r60 = 0
            r61 = 0
            int r10 = r2 >> 9
            r62 = r10 & 112(0x70, float:1.57E-43)
            r63 = 2097151(0x1fffff, float:2.938734E-39)
            r16 = r66
            r59 = r8
            androidx.compose.material.TextFieldColors r10 = r16.m1676outlinedTextFieldColorsdx8h9Zs(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r47, r49, r51, r53, r55, r57, r59, r60, r61, r62, r63)
            r2 = r2 & -113(0xffffffffffffff8f, float:NaN)
            goto L_0x02d9
        L_0x02d7:
            r10 = r78
        L_0x02d9:
            r81 = r0
            r0 = r9 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x02f4
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 15
            r29 = 0
            r23 = r66
            androidx.compose.foundation.layout.PaddingValues r0 = m1667outlinedTextFieldPaddinga9UjIt4$default(r23, r24, r25, r26, r27, r28, r29)
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x02f6
        L_0x02f4:
            r0 = r79
        L_0x02f6:
            if (r5 == 0) goto L_0x032c
            androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$1 r5 = new androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$1
            r73 = r5
            r74 = r69
            r75 = r7
            r76 = r72
            r77 = r10
            r78 = r1
            r79 = r2
            r73.<init>(r74, r75, r76, r77, r78, r79)
            r73 = r0
            r0 = 1261916269(0x4b37506d, float:1.2013677E7)
            r74 = r2
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r8, r0, r2, r5)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r25 = r73
            r21 = r81
            r26 = r0
            r22 = r3
            r23 = r4
            r20 = r6
            r19 = r7
            r24 = r10
            r10 = r74
            goto L_0x0342
        L_0x032c:
            r73 = r0
            r74 = r2
            r25 = r73
            r26 = r80
            r21 = r81
            r22 = r3
            r23 = r4
            r20 = r6
            r19 = r7
            r24 = r10
            r10 = r74
        L_0x0342:
            r8.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0353
            java.lang.String r0 = "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:634)"
            r2 = -1280721485(0xffffffffb3a9bdb3, float:-7.904182E-8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r10, r0)
        L_0x0353:
            androidx.compose.material.TextFieldType r0 = androidx.compose.material.TextFieldType.Outlined
            int r2 = r1 << 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | 6
            int r3 = r1 << 3
            r3 = r3 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            int r3 = r1 >> 3
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            int r3 = r1 >> 9
            r3 = r3 & r64
            r2 = r2 | r3
            int r3 = r1 >> 9
            r4 = 458752(0x70000, float:6.42848E-40)
            r3 = r3 & r4
            r2 = r2 | r3
            int r3 = r1 >> 9
            r4 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r4
            r2 = r2 | r3
            int r3 = r10 << 21
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            r3 = r3 & r4
            r2 = r2 | r3
            int r3 = r1 << 15
            r4 = 234881024(0xe000000, float:1.5777218E-30)
            r3 = r3 & r4
            r2 = r2 | r3
            int r3 = r1 << 21
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r4
            r16 = r2 | r3
            int r2 = r1 >> 18
            r2 = r2 & 14
            int r3 = r1 >> 12
            r3 = r3 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = r10 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            int r3 = r10 << 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            int r3 = r10 << 3
            r3 = r3 & r64
            r17 = r2 | r3
            r18 = 0
            r27 = r1
            r1 = r67
            r2 = r68
            r3 = r71
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r23
            r28 = r8
            r8 = r70
            r9 = r69
            r29 = r10
            r10 = r19
            r11 = r72
            r12 = r25
            r13 = r24
            r14 = r26
            r15 = r28
            androidx.compose.material.TextFieldImplKt.CommonDecorationBox(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03df
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x03df:
            androidx.compose.runtime.ScopeUpdateScope r15 = r28.endRestartGroup()
            if (r15 != 0) goto L_0x03e6
            goto L_0x041c
        L_0x03e6:
            androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$2 r30 = new androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$2
            r0 = r30
            r1 = r66
            r2 = r67
            r3 = r68
            r4 = r69
            r5 = r70
            r6 = r71
            r7 = r72
            r8 = r19
            r9 = r20
            r10 = r21
            r11 = r22
            r12 = r23
            r13 = r24
            r14 = r25
            r65 = r15
            r15 = r26
            r16 = r82
            r17 = r83
            r18 = r84
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r30
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r65
            r1.updateScope(r0)
        L_0x041c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
