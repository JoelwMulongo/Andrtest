package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u001a\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\u0010*\u001a\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020+2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)H\u0007¢\u0006\u0002\u0010,\u001aÙ\u0001\u0010-\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0019\u0010\u0016\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\u0002\b\u00152\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010!\u001a\u00020\u000f2\u0006\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00070\u000b2\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0013\u00106\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u00107\u001a\u000208H\u0001ø\u0001\u0000¢\u0006\u0002\u00109\u001a]\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020#2\u0006\u0010=\u001a\u00020#2\u0006\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u0002022\u0006\u00107\u001a\u000208H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a]\u0010F\u001a\u00020#2\u0006\u0010G\u001a\u00020#2\u0006\u0010H\u001a\u00020#2\u0006\u0010I\u001a\u00020#2\u0006\u0010J\u001a\u00020#2\u0006\u0010K\u001a\u00020#2\u0006\u0010L\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u0002022\u0006\u00107\u001a\u000208H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a)\u0010O\u001a\u00020\r*\u00020\r2\u0006\u0010P\u001a\u0002042\u0006\u00107\u001a\u000208H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a\u0001\u0010S\u001a\u00020\u0007*\u00020T2\u0006\u0010U\u001a\u00020#2\u0006\u0010V\u001a\u00020#2\b\u0010W\u001a\u0004\u0018\u00010X2\b\u0010Y\u001a\u0004\u0018\u00010X2\u0006\u0010Z\u001a\u00020X2\b\u0010[\u001a\u0004\u0018\u00010X2\b\u0010\\\u001a\u0004\u0018\u00010X2\u0006\u0010]\u001a\u00020X2\b\u0010^\u001a\u0004\u0018\u00010X2\u0006\u00101\u001a\u0002022\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010C\u001a\u0002022\u0006\u0010_\u001a\u00020`2\u0006\u00107\u001a\u000208H\u0002\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0019\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006a"}, d2 = {"OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "supportingPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IIIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "isLabelInMiddleSection", "calculateWidth-O3s9Psw", "(IIIIIZJFLandroidx/compose/foundation/layout/PaddingValues;)I", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "containerPlaceable", "supportingPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: OutlinedTextField.kt */
public final class OutlinedTextFieldKt {
    /* access modifiers changed from: private */
    public static final float OutlinedTextFieldInnerPadding = Dp.m5986constructorimpl((float) 4);
    private static final float OutlinedTextFieldTopPadding = Dp.m5986constructorimpl((float) 8);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r92v1, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: androidx.compose.ui.text.TextStyle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v52, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v54, resolved type: char} */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x01d7, code lost:
        if (r9.changed((java.lang.Object) r96) != false) goto L_0x01de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x01f4, code lost:
        if (r9.changed((java.lang.Object) r97) != false) goto L_0x01fb;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void OutlinedTextField(java.lang.String r83, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r84, androidx.compose.ui.Modifier r85, boolean r86, boolean r87, androidx.compose.ui.text.TextStyle r88, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r89, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r90, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r91, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r92, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r93, boolean r94, androidx.compose.ui.text.input.VisualTransformation r95, androidx.compose.foundation.text.KeyboardOptions r96, androidx.compose.foundation.text.KeyboardActions r97, boolean r98, int r99, androidx.compose.foundation.interaction.MutableInteractionSource r100, androidx.compose.ui.graphics.Shape r101, androidx.compose.material3.TextFieldColors r102, androidx.compose.runtime.Composer r103, int r104, int r105, int r106) {
        /*
            r15 = r83
            r14 = r84
            r13 = r104
            r12 = r105
            r11 = r106
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 534493230(0x1fdbb82e, float:9.305481E-20)
            r1 = r103
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(OutlinedTextField)P(18,10,9,1,12,16,6,11,7,17,15,3,19,5,4,14,8,2,13)138@7667L7,150@8281L39,151@8359L13,152@8422L25,160@8773L15,160@8707L2376:OutlinedTextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r104
            r2 = r105
            r3 = r11 & 1
            if (r3 == 0) goto L_0x002f
            r1 = r1 | 6
            goto L_0x003d
        L_0x002f:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x003d
            boolean r3 = r9.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x003b
            r3 = 4
            goto L_0x003c
        L_0x003b:
            r3 = 2
        L_0x003c:
            r1 = r1 | r3
        L_0x003d:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0044
            r1 = r1 | 48
            goto L_0x0054
        L_0x0044:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0054
            boolean r3 = r9.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x0051
            r3 = 32
            goto L_0x0053
        L_0x0051:
            r3 = 16
        L_0x0053:
            r1 = r1 | r3
        L_0x0054:
            r3 = r11 & 4
            if (r3 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r4 = r85
            goto L_0x0073
        L_0x005d:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0071
            r4 = r85
            boolean r16 = r9.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x006c
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r16
            goto L_0x0073
        L_0x0071:
            r4 = r85
        L_0x0073:
            r16 = r11 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0080
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r86
            goto L_0x0096
        L_0x0080:
            r5 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0094
            r5 = r86
            boolean r20 = r9.changed((boolean) r5)
            if (r20 == 0) goto L_0x008f
            r20 = r17
            goto L_0x0091
        L_0x008f:
            r20 = r18
        L_0x0091:
            r1 = r1 | r20
            goto L_0x0096
        L_0x0094:
            r5 = r86
        L_0x0096:
            r20 = r11 & 16
            r21 = 16384(0x4000, float:2.2959E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            if (r20 == 0) goto L_0x00a3
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r6 = r87
            goto L_0x00bc
        L_0x00a3:
            r23 = 57344(0xe000, float:8.0356E-41)
            r23 = r13 & r23
            if (r23 != 0) goto L_0x00ba
            r6 = r87
            boolean r24 = r9.changed((boolean) r6)
            if (r24 == 0) goto L_0x00b5
            r24 = r21
            goto L_0x00b7
        L_0x00b5:
            r24 = r22
        L_0x00b7:
            r1 = r1 | r24
            goto L_0x00bc
        L_0x00ba:
            r6 = r87
        L_0x00bc:
            r24 = 458752(0x70000, float:6.42848E-40)
            r24 = r13 & r24
            r25 = 131072(0x20000, float:1.83671E-40)
            r26 = 65536(0x10000, float:9.18355E-41)
            if (r24 != 0) goto L_0x00dc
            r24 = r11 & 32
            if (r24 != 0) goto L_0x00d5
            r7 = r88
            boolean r27 = r9.changed((java.lang.Object) r7)
            if (r27 == 0) goto L_0x00d7
            r27 = r25
            goto L_0x00d9
        L_0x00d5:
            r7 = r88
        L_0x00d7:
            r27 = r26
        L_0x00d9:
            r1 = r1 | r27
            goto L_0x00de
        L_0x00dc:
            r7 = r88
        L_0x00de:
            r27 = r11 & 64
            r28 = 524288(0x80000, float:7.34684E-40)
            if (r27 == 0) goto L_0x00eb
            r29 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r29
            r8 = r89
            goto L_0x0103
        L_0x00eb:
            r29 = 3670016(0x380000, float:5.142788E-39)
            r29 = r13 & r29
            if (r29 != 0) goto L_0x0101
            r8 = r89
            boolean r30 = r9.changed((java.lang.Object) r8)
            if (r30 == 0) goto L_0x00fc
            r30 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fe
        L_0x00fc:
            r30 = r28
        L_0x00fe:
            r1 = r1 | r30
            goto L_0x0103
        L_0x0101:
            r8 = r89
        L_0x0103:
            r10 = r11 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x010e
            r31 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r31
            r0 = r90
            goto L_0x0126
        L_0x010e:
            r31 = 29360128(0x1c00000, float:7.052966E-38)
            r31 = r13 & r31
            if (r31 != 0) goto L_0x0124
            r0 = r90
            boolean r31 = r9.changed((java.lang.Object) r0)
            if (r31 == 0) goto L_0x011f
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0121
        L_0x011f:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x0121:
            r1 = r1 | r31
            goto L_0x0126
        L_0x0124:
            r0 = r90
        L_0x0126:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0131
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r31
            r4 = r91
            goto L_0x0149
        L_0x0131:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r13 & r31
            if (r31 != 0) goto L_0x0147
            r4 = r91
            boolean r31 = r9.changed((java.lang.Object) r4)
            if (r31 == 0) goto L_0x0142
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0144
        L_0x0142:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0144:
            r1 = r1 | r31
            goto L_0x0149
        L_0x0147:
            r4 = r91
        L_0x0149:
            r4 = r11 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0154
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r31
            r5 = r92
            goto L_0x016c
        L_0x0154:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r13 & r31
            if (r31 != 0) goto L_0x016a
            r5 = r92
            boolean r31 = r9.changed((java.lang.Object) r5)
            if (r31 == 0) goto L_0x0165
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0167
        L_0x0165:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0167:
            r1 = r1 | r31
            goto L_0x016c
        L_0x016a:
            r5 = r92
        L_0x016c:
            r5 = r11 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x0175
            r2 = r2 | 6
            r6 = r93
            goto L_0x018b
        L_0x0175:
            r31 = r12 & 14
            if (r31 != 0) goto L_0x0189
            r6 = r93
            boolean r31 = r9.changed((java.lang.Object) r6)
            if (r31 == 0) goto L_0x0184
            r19 = 4
            goto L_0x0186
        L_0x0184:
            r19 = 2
        L_0x0186:
            r2 = r2 | r19
            goto L_0x018b
        L_0x0189:
            r6 = r93
        L_0x018b:
            r6 = r11 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0194
            r2 = r2 | 48
            r7 = r94
            goto L_0x01aa
        L_0x0194:
            r19 = r12 & 112(0x70, float:1.57E-43)
            if (r19 != 0) goto L_0x01a8
            r7 = r94
            boolean r19 = r9.changed((boolean) r7)
            if (r19 == 0) goto L_0x01a3
            r24 = 32
            goto L_0x01a5
        L_0x01a3:
            r24 = 16
        L_0x01a5:
            r2 = r2 | r24
            goto L_0x01aa
        L_0x01a8:
            r7 = r94
        L_0x01aa:
            r7 = r11 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x01b3
            r2 = r2 | 384(0x180, float:5.38E-43)
            r8 = r95
            goto L_0x01c9
        L_0x01b3:
            r8 = r12 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x01c7
            r8 = r95
            boolean r19 = r9.changed((java.lang.Object) r8)
            if (r19 == 0) goto L_0x01c2
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x01c4
        L_0x01c2:
            r29 = 128(0x80, float:1.794E-43)
        L_0x01c4:
            r2 = r2 | r29
            goto L_0x01c9
        L_0x01c7:
            r8 = r95
        L_0x01c9:
            r8 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x01e1
            r8 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r8 != 0) goto L_0x01da
            r8 = r96
            boolean r19 = r9.changed((java.lang.Object) r8)
            if (r19 == 0) goto L_0x01dc
            goto L_0x01de
        L_0x01da:
            r8 = r96
        L_0x01dc:
            r17 = r18
        L_0x01de:
            r2 = r2 | r17
            goto L_0x01e3
        L_0x01e1:
            r8 = r96
        L_0x01e3:
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x01fe
            r8 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r8 != 0) goto L_0x01f7
            r8 = r97
            boolean r17 = r9.changed((java.lang.Object) r8)
            if (r17 == 0) goto L_0x01f9
            goto L_0x01fb
        L_0x01f7:
            r8 = r97
        L_0x01f9:
            r21 = r22
        L_0x01fb:
            r2 = r2 | r21
            goto L_0x0200
        L_0x01fe:
            r8 = r97
        L_0x0200:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r11 & r17
            if (r17 == 0) goto L_0x020e
            r18 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r18
            r8 = r98
            goto L_0x0226
        L_0x020e:
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0224
            r8 = r98
            boolean r18 = r9.changed((boolean) r8)
            if (r18 == 0) goto L_0x021f
            r18 = r25
            goto L_0x0221
        L_0x021f:
            r18 = r26
        L_0x0221:
            r2 = r2 | r18
            goto L_0x0226
        L_0x0224:
            r8 = r98
        L_0x0226:
            r18 = r11 & r26
            if (r18 == 0) goto L_0x0231
            r19 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r19
            r8 = r99
            goto L_0x0249
        L_0x0231:
            r19 = 3670016(0x380000, float:5.142788E-39)
            r19 = r12 & r19
            if (r19 != 0) goto L_0x0247
            r8 = r99
            boolean r19 = r9.changed((int) r8)
            if (r19 == 0) goto L_0x0242
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0244
        L_0x0242:
            r19 = r28
        L_0x0244:
            r2 = r2 | r19
            goto L_0x0249
        L_0x0247:
            r8 = r99
        L_0x0249:
            r19 = r11 & r25
            if (r19 == 0) goto L_0x0254
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 | r21
            r8 = r100
            goto L_0x026c
        L_0x0254:
            r21 = 29360128(0x1c00000, float:7.052966E-38)
            r21 = r12 & r21
            if (r21 != 0) goto L_0x026a
            r8 = r100
            boolean r21 = r9.changed((java.lang.Object) r8)
            if (r21 == 0) goto L_0x0265
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0267
        L_0x0265:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x0267:
            r2 = r2 | r21
            goto L_0x026c
        L_0x026a:
            r8 = r100
        L_0x026c:
            r21 = 234881024(0xe000000, float:1.5777218E-30)
            r21 = r12 & r21
            r22 = 262144(0x40000, float:3.67342E-40)
            if (r21 != 0) goto L_0x028a
            r21 = r11 & r22
            if (r21 != 0) goto L_0x0283
            r8 = r101
            boolean r21 = r9.changed((java.lang.Object) r8)
            if (r21 == 0) goto L_0x0285
            r21 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0287
        L_0x0283:
            r8 = r101
        L_0x0285:
            r21 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0287:
            r2 = r2 | r21
            goto L_0x028c
        L_0x028a:
            r8 = r101
        L_0x028c:
            r21 = 1879048192(0x70000000, float:1.58456325E29)
            r21 = r12 & r21
            if (r21 != 0) goto L_0x02a8
            r21 = r11 & r28
            if (r21 != 0) goto L_0x02a1
            r8 = r102
            boolean r21 = r9.changed((java.lang.Object) r8)
            if (r21 == 0) goto L_0x02a3
            r21 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x02a5
        L_0x02a1:
            r8 = r102
        L_0x02a3:
            r21 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x02a5:
            r2 = r2 | r21
            goto L_0x02aa
        L_0x02a8:
            r8 = r102
        L_0x02aa:
            r21 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r8 = r1 & r21
            r12 = 306783378(0x12492492, float:6.3469493E-28)
            if (r8 != r12) goto L_0x02f2
            r8 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r8 = r8 & r2
            r12 = 306783378(0x12492492, float:6.3469493E-28)
            if (r8 != r12) goto L_0x02f2
            boolean r8 = r9.getSkipping()
            if (r8 != 0) goto L_0x02c4
            goto L_0x02f2
        L_0x02c4:
            r9.skipToGroupEnd()
            r24 = r85
            r43 = r86
            r25 = r87
            r42 = r88
            r26 = r89
            r27 = r90
            r28 = r91
            r29 = r92
            r30 = r93
            r31 = r94
            r32 = r95
            r33 = r96
            r34 = r97
            r77 = r98
            r78 = r99
            r35 = r100
            r36 = r101
            r41 = r102
            r40 = r1
            r39 = r2
            r15 = r9
            goto L_0x0634
        L_0x02f2:
            r9.startDefaults()
            r8 = r13 & 1
            if (r8 == 0) goto L_0x037a
            boolean r8 = r9.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0301
            goto L_0x037a
        L_0x0301:
            r9.skipToGroupEnd()
            r0 = r11 & 32
            if (r0 == 0) goto L_0x030c
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r0
        L_0x030c:
            r0 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0312
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0312:
            r0 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x031a
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r2 = r2 & r0
        L_0x031a:
            r0 = r11 & r22
            if (r0 == 0) goto L_0x0322
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r2 = r2 & r0
        L_0x0322:
            r0 = r11 & r28
            if (r0 == 0) goto L_0x0352
            r0 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r0 = r0 & r2
            r23 = r85
            r12 = r86
            r24 = r87
            r8 = r88
            r25 = r89
            r26 = r90
            r27 = r91
            r28 = r92
            r29 = r93
            r30 = r94
            r31 = r95
            r32 = r96
            r33 = r97
            r77 = r98
            r78 = r99
            r34 = r100
            r35 = r101
            r7 = r102
            r5 = r0
            r6 = r1
            goto L_0x0522
        L_0x0352:
            r23 = r85
            r12 = r86
            r24 = r87
            r8 = r88
            r25 = r89
            r26 = r90
            r27 = r91
            r28 = r92
            r29 = r93
            r30 = r94
            r31 = r95
            r32 = r96
            r33 = r97
            r77 = r98
            r78 = r99
            r34 = r100
            r35 = r101
            r7 = r102
            r6 = r1
            r5 = r2
            goto L_0x0522
        L_0x037a:
            if (r3 == 0) goto L_0x0381
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x0383
        L_0x0381:
            r3 = r85
        L_0x0383:
            if (r16 == 0) goto L_0x0387
            r8 = 1
            goto L_0x0389
        L_0x0387:
            r8 = r86
        L_0x0389:
            if (r20 == 0) goto L_0x038d
            r12 = 0
            goto L_0x038f
        L_0x038d:
            r12 = r87
        L_0x038f:
            r16 = r11 & 32
            if (r16 == 0) goto L_0x03bc
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.material3.TextKt.getLocalTextStyle()
            r85 = r3
            r3 = r16
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r16 = 6
            r20 = 0
            r86 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            r87 = r12
            java.lang.String r12 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r8, r12)
            java.lang.Object r8 = r9.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r3 = r8
            androidx.compose.ui.text.TextStyle r3 = (androidx.compose.ui.text.TextStyle) r3
            r8 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r8
            goto L_0x03c4
        L_0x03bc:
            r85 = r3
            r86 = r8
            r87 = r12
            r3 = r88
        L_0x03c4:
            if (r27 == 0) goto L_0x03c8
            r8 = 0
            goto L_0x03ca
        L_0x03c8:
            r8 = r89
        L_0x03ca:
            if (r10 == 0) goto L_0x03ce
            r10 = 0
            goto L_0x03d0
        L_0x03ce:
            r10 = r90
        L_0x03d0:
            if (r0 == 0) goto L_0x03d4
            r0 = 0
            goto L_0x03d6
        L_0x03d4:
            r0 = r91
        L_0x03d6:
            if (r4 == 0) goto L_0x03da
            r4 = 0
            goto L_0x03dc
        L_0x03da:
            r4 = r92
        L_0x03dc:
            if (r5 == 0) goto L_0x03e0
            r5 = 0
            goto L_0x03e2
        L_0x03e0:
            r5 = r93
        L_0x03e2:
            if (r6 == 0) goto L_0x03e6
            r6 = 0
            goto L_0x03e8
        L_0x03e6:
            r6 = r94
        L_0x03e8:
            if (r7 == 0) goto L_0x03f1
            androidx.compose.ui.text.input.VisualTransformation$Companion r7 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r7 = r7.getNone()
            goto L_0x03f3
        L_0x03f1:
            r7 = r95
        L_0x03f3:
            r12 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L_0x0400
            androidx.compose.foundation.text.KeyboardOptions$Companion r12 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r12 = r12.getDefault()
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0402
        L_0x0400:
            r12 = r96
        L_0x0402:
            r88 = r0
            r0 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0414
            androidx.compose.foundation.text.KeyboardActions$Companion r0 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r0 = r0.getDefault()
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r2 = r2 & r16
            goto L_0x0416
        L_0x0414:
            r0 = r97
        L_0x0416:
            if (r17 == 0) goto L_0x041d
            r16 = 0
            r77 = r16
            goto L_0x041f
        L_0x041d:
            r77 = r98
        L_0x041f:
            if (r18 == 0) goto L_0x0427
            r16 = 2147483647(0x7fffffff, float:NaN)
            r78 = r16
            goto L_0x0429
        L_0x0427:
            r78 = r99
        L_0x0429:
            if (r19 == 0) goto L_0x0470
            r16 = 0
            r17 = 0
            r89 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r0 = 0
            r90 = r9
            r18 = 0
            r91 = r0
            java.lang.Object r0 = r90.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r103 = r1
            java.lang.Object r1 = r20.getEmpty()
            if (r0 != r1) goto L_0x0461
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r92 = r0
            r0 = r90
            r0.updateRememberedValue(r1)
            goto L_0x0467
        L_0x0461:
            r92 = r0
            r0 = r90
            r1 = r92
        L_0x0467:
            r9.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x0476
        L_0x0470:
            r89 = r0
            r103 = r1
            r0 = r100
        L_0x0476:
            r1 = r11 & r22
            if (r1 == 0) goto L_0x0488
            androidx.compose.material3.TextFieldDefaults r1 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            r90 = r0
            r0 = 6
            androidx.compose.ui.graphics.Shape r0 = r1.getOutlinedShape(r9, r0)
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r2 = r2 & r1
            goto L_0x048c
        L_0x0488:
            r90 = r0
            r0 = r101
        L_0x048c:
            r1 = r11 & r28
            if (r1 == 0) goto L_0x0500
            androidx.compose.material3.TextFieldDefaults r16 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r30 = 0
            r32 = 0
            r34 = 0
            r36 = 0
            r38 = 0
            r40 = 0
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r52 = 0
            r54 = 0
            r56 = 0
            r58 = 0
            r60 = 0
            r62 = 0
            r64 = 0
            r66 = 0
            r68 = 0
            r70 = 0
            r73 = 0
            r74 = 0
            r75 = 100663296(0x6000000, float:2.4074124E-35)
            r76 = 268435455(0xfffffff, float:2.5243547E-29)
            r72 = r9
            androidx.compose.material3.TextFieldColors r1 = r16.m2154outlinedTextFieldColorsl59Burw(r17, r19, r21, r23, r25, r27, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r73, r74, r75, r76)
            r16 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r2 = r2 & r16
            r23 = r85
            r24 = r87
            r27 = r88
            r33 = r89
            r34 = r90
            r35 = r0
            r28 = r4
            r29 = r5
            r30 = r6
            r31 = r7
            r25 = r8
            r26 = r10
            r32 = r12
            r12 = r86
            r6 = r103
            r7 = r1
            r5 = r2
            r8 = r3
            goto L_0x0522
        L_0x0500:
            r23 = r85
            r24 = r87
            r27 = r88
            r33 = r89
            r34 = r90
            r35 = r0
            r28 = r4
            r29 = r5
            r30 = r6
            r31 = r7
            r25 = r8
            r26 = r10
            r32 = r12
            r12 = r86
            r7 = r102
            r6 = r103
            r5 = r2
            r8 = r3
        L_0x0522:
            r9.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0533
            java.lang.String r0 = "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:132)"
            r1 = 534493230(0x1fdbb82e, float:9.305481E-20)
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r6, r5, r0)
        L_0x0533:
            r0 = 1663535219(0x63278873, float:3.0904385E21)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "*156@8599L18"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            long r0 = r8.m5494getColor0d7_KjU()
            r2 = 0
            r3 = r0
            r10 = 0
            androidx.compose.ui.graphics.Color$Companion r16 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r16.m3200getUnspecified0d7_KjU()
            int r16 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            r15 = 1
            if (r16 == 0) goto L_0x0553
            r16 = r15
            goto L_0x0555
        L_0x0553:
            r16 = 0
        L_0x0555:
            if (r16 == 0) goto L_0x055a
            r37 = r0
            goto L_0x0574
        L_0x055a:
            r3 = 0
            int r4 = r6 >> 9
            r4 = r4 & 14
            int r10 = r5 >> 24
            r10 = r10 & 112(0x70, float:1.57E-43)
            r4 = r4 | r10
            androidx.compose.runtime.State r4 = r7.textColor$material3_release(r12, r9, r4)
            java.lang.Object r4 = r4.getValue()
            androidx.compose.ui.graphics.Color r4 = (androidx.compose.ui.graphics.Color) r4
            long r16 = r4.m3174unboximpl()
            r37 = r16
        L_0x0574:
            r9.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r0 = new androidx.compose.ui.text.TextStyle
            r36 = r0
            r39 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r59 = 0
            r60 = 262142(0x3fffe, float:3.67339E-40)
            r61 = 0
            r36.<init>((long) r37, (long) r39, (androidx.compose.ui.text.font.FontWeight) r41, (androidx.compose.ui.text.font.FontStyle) r42, (androidx.compose.ui.text.font.FontSynthesis) r43, (androidx.compose.ui.text.font.FontFamily) r44, (java.lang.String) r45, (long) r46, (androidx.compose.ui.text.style.BaselineShift) r48, (androidx.compose.ui.text.style.TextGeometricTransform) r49, (androidx.compose.ui.text.intl.LocaleList) r50, (long) r51, (androidx.compose.ui.text.style.TextDecoration) r53, (androidx.compose.ui.graphics.Shadow) r54, (androidx.compose.ui.text.style.TextAlign) r55, (androidx.compose.ui.text.style.TextDirection) r56, (long) r57, (androidx.compose.ui.text.style.TextIndent) r59, (int) r60, (kotlin.jvm.internal.DefaultConstructorMarker) r61)
            androidx.compose.ui.text.TextStyle r36 = r8.merge((androidx.compose.ui.text.TextStyle) r0)
            r10 = r36
            androidx.compose.runtime.ProvidedValue[] r4 = new androidx.compose.runtime.ProvidedValue[r15]
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            int r1 = r5 >> 27
            r1 = r1 & 14
            androidx.compose.foundation.text.selection.TextSelectionColors r1 = r7.getSelectionColors(r9, r1)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r1 = 0
            r4[r1] = r0
            androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$2 r3 = new androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$2
            r0 = r3
            r1 = r25
            r2 = r23
            r79 = r3
            r3 = r7
            r80 = r4
            r4 = r30
            r39 = r5
            r40 = r6
            r6 = r83
            r41 = r7
            r7 = r84
            r42 = r8
            r8 = r12
            r81 = r9
            r9 = r24
            r11 = r32
            r43 = r12
            r12 = r33
            r13 = r77
            r14 = r78
            r15 = r31
            r16 = r34
            r17 = r40
            r18 = r26
            r19 = r27
            r20 = r28
            r21 = r29
            r22 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = -1801753362(0xffffffff949b6cee, float:-1.5693966E-26)
            r1 = r79
            r15 = r81
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r2, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 56
            r2 = r80
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r15, (int) r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x061a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x061a:
            r36 = r35
            r35 = r34
            r34 = r33
            r33 = r32
            r32 = r31
            r31 = r30
            r30 = r29
            r29 = r28
            r28 = r27
            r27 = r26
            r26 = r25
            r25 = r24
            r24 = r23
        L_0x0634:
            androidx.compose.runtime.ScopeUpdateScope r14 = r15.endRestartGroup()
            if (r14 != 0) goto L_0x063d
            r38 = r15
            goto L_0x067f
        L_0x063d:
            androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$3 r37 = new androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$3
            r0 = r37
            r1 = r83
            r2 = r84
            r3 = r24
            r4 = r43
            r5 = r25
            r6 = r42
            r7 = r26
            r8 = r27
            r9 = r28
            r10 = r29
            r11 = r30
            r12 = r31
            r13 = r32
            r82 = r14
            r14 = r33
            r38 = r15
            r15 = r34
            r16 = r77
            r17 = r78
            r18 = r35
            r19 = r36
            r20 = r41
            r21 = r104
            r22 = r105
            r23 = r106
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r0 = r37
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r82
            r1.updateScope(r0)
        L_0x067f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r92v1, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v33, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: androidx.compose.ui.text.TextStyle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v52, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v54, resolved type: char} */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x01d7, code lost:
        if (r9.changed((java.lang.Object) r96) != false) goto L_0x01de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x01f4, code lost:
        if (r9.changed((java.lang.Object) r97) != false) goto L_0x01fb;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue r83, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r84, androidx.compose.ui.Modifier r85, boolean r86, boolean r87, androidx.compose.ui.text.TextStyle r88, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r89, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r90, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r91, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r92, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r93, boolean r94, androidx.compose.ui.text.input.VisualTransformation r95, androidx.compose.foundation.text.KeyboardOptions r96, androidx.compose.foundation.text.KeyboardActions r97, boolean r98, int r99, androidx.compose.foundation.interaction.MutableInteractionSource r100, androidx.compose.ui.graphics.Shape r101, androidx.compose.material3.TextFieldColors r102, androidx.compose.runtime.Composer r103, int r104, int r105, int r106) {
        /*
            r15 = r83
            r14 = r84
            r13 = r104
            r12 = r105
            r11 = r106
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1040237435(0x3e00c37b, float:0.1257457)
            r1 = r103
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(OutlinedTextField)P(18,10,9,1,12,16,6,11,7,17,15,3,19,5,4,14,8,2,13)289@15857L7,301@16471L39,302@16549L13,303@16612L25,311@16963L15,311@16897L2381:OutlinedTextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r104
            r2 = r105
            r3 = r11 & 1
            if (r3 == 0) goto L_0x002f
            r1 = r1 | 6
            goto L_0x003d
        L_0x002f:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x003d
            boolean r3 = r9.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x003b
            r3 = 4
            goto L_0x003c
        L_0x003b:
            r3 = 2
        L_0x003c:
            r1 = r1 | r3
        L_0x003d:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x0044
            r1 = r1 | 48
            goto L_0x0054
        L_0x0044:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0054
            boolean r3 = r9.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x0051
            r3 = 32
            goto L_0x0053
        L_0x0051:
            r3 = 16
        L_0x0053:
            r1 = r1 | r3
        L_0x0054:
            r3 = r11 & 4
            if (r3 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r4 = r85
            goto L_0x0073
        L_0x005d:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0071
            r4 = r85
            boolean r16 = r9.changed((java.lang.Object) r4)
            if (r16 == 0) goto L_0x006c
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r16
            goto L_0x0073
        L_0x0071:
            r4 = r85
        L_0x0073:
            r16 = r11 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0080
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r86
            goto L_0x0096
        L_0x0080:
            r5 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0094
            r5 = r86
            boolean r20 = r9.changed((boolean) r5)
            if (r20 == 0) goto L_0x008f
            r20 = r17
            goto L_0x0091
        L_0x008f:
            r20 = r18
        L_0x0091:
            r1 = r1 | r20
            goto L_0x0096
        L_0x0094:
            r5 = r86
        L_0x0096:
            r20 = r11 & 16
            r21 = 16384(0x4000, float:2.2959E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            if (r20 == 0) goto L_0x00a3
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r6 = r87
            goto L_0x00bc
        L_0x00a3:
            r23 = 57344(0xe000, float:8.0356E-41)
            r23 = r13 & r23
            if (r23 != 0) goto L_0x00ba
            r6 = r87
            boolean r24 = r9.changed((boolean) r6)
            if (r24 == 0) goto L_0x00b5
            r24 = r21
            goto L_0x00b7
        L_0x00b5:
            r24 = r22
        L_0x00b7:
            r1 = r1 | r24
            goto L_0x00bc
        L_0x00ba:
            r6 = r87
        L_0x00bc:
            r24 = 458752(0x70000, float:6.42848E-40)
            r24 = r13 & r24
            r25 = 131072(0x20000, float:1.83671E-40)
            r26 = 65536(0x10000, float:9.18355E-41)
            if (r24 != 0) goto L_0x00dc
            r24 = r11 & 32
            if (r24 != 0) goto L_0x00d5
            r7 = r88
            boolean r27 = r9.changed((java.lang.Object) r7)
            if (r27 == 0) goto L_0x00d7
            r27 = r25
            goto L_0x00d9
        L_0x00d5:
            r7 = r88
        L_0x00d7:
            r27 = r26
        L_0x00d9:
            r1 = r1 | r27
            goto L_0x00de
        L_0x00dc:
            r7 = r88
        L_0x00de:
            r27 = r11 & 64
            r28 = 524288(0x80000, float:7.34684E-40)
            if (r27 == 0) goto L_0x00eb
            r29 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r29
            r8 = r89
            goto L_0x0103
        L_0x00eb:
            r29 = 3670016(0x380000, float:5.142788E-39)
            r29 = r13 & r29
            if (r29 != 0) goto L_0x0101
            r8 = r89
            boolean r30 = r9.changed((java.lang.Object) r8)
            if (r30 == 0) goto L_0x00fc
            r30 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fe
        L_0x00fc:
            r30 = r28
        L_0x00fe:
            r1 = r1 | r30
            goto L_0x0103
        L_0x0101:
            r8 = r89
        L_0x0103:
            r10 = r11 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x010e
            r31 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r31
            r0 = r90
            goto L_0x0126
        L_0x010e:
            r31 = 29360128(0x1c00000, float:7.052966E-38)
            r31 = r13 & r31
            if (r31 != 0) goto L_0x0124
            r0 = r90
            boolean r31 = r9.changed((java.lang.Object) r0)
            if (r31 == 0) goto L_0x011f
            r31 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0121
        L_0x011f:
            r31 = 4194304(0x400000, float:5.877472E-39)
        L_0x0121:
            r1 = r1 | r31
            goto L_0x0126
        L_0x0124:
            r0 = r90
        L_0x0126:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0131
            r31 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r31
            r4 = r91
            goto L_0x0149
        L_0x0131:
            r31 = 234881024(0xe000000, float:1.5777218E-30)
            r31 = r13 & r31
            if (r31 != 0) goto L_0x0147
            r4 = r91
            boolean r31 = r9.changed((java.lang.Object) r4)
            if (r31 == 0) goto L_0x0142
            r31 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0144
        L_0x0142:
            r31 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0144:
            r1 = r1 | r31
            goto L_0x0149
        L_0x0147:
            r4 = r91
        L_0x0149:
            r4 = r11 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0154
            r31 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r31
            r5 = r92
            goto L_0x016c
        L_0x0154:
            r31 = 1879048192(0x70000000, float:1.58456325E29)
            r31 = r13 & r31
            if (r31 != 0) goto L_0x016a
            r5 = r92
            boolean r31 = r9.changed((java.lang.Object) r5)
            if (r31 == 0) goto L_0x0165
            r31 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0167
        L_0x0165:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0167:
            r1 = r1 | r31
            goto L_0x016c
        L_0x016a:
            r5 = r92
        L_0x016c:
            r5 = r11 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x0175
            r2 = r2 | 6
            r6 = r93
            goto L_0x018b
        L_0x0175:
            r31 = r12 & 14
            if (r31 != 0) goto L_0x0189
            r6 = r93
            boolean r31 = r9.changed((java.lang.Object) r6)
            if (r31 == 0) goto L_0x0184
            r19 = 4
            goto L_0x0186
        L_0x0184:
            r19 = 2
        L_0x0186:
            r2 = r2 | r19
            goto L_0x018b
        L_0x0189:
            r6 = r93
        L_0x018b:
            r6 = r11 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0194
            r2 = r2 | 48
            r7 = r94
            goto L_0x01aa
        L_0x0194:
            r19 = r12 & 112(0x70, float:1.57E-43)
            if (r19 != 0) goto L_0x01a8
            r7 = r94
            boolean r19 = r9.changed((boolean) r7)
            if (r19 == 0) goto L_0x01a3
            r24 = 32
            goto L_0x01a5
        L_0x01a3:
            r24 = 16
        L_0x01a5:
            r2 = r2 | r24
            goto L_0x01aa
        L_0x01a8:
            r7 = r94
        L_0x01aa:
            r7 = r11 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x01b3
            r2 = r2 | 384(0x180, float:5.38E-43)
            r8 = r95
            goto L_0x01c9
        L_0x01b3:
            r8 = r12 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x01c7
            r8 = r95
            boolean r19 = r9.changed((java.lang.Object) r8)
            if (r19 == 0) goto L_0x01c2
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x01c4
        L_0x01c2:
            r29 = 128(0x80, float:1.794E-43)
        L_0x01c4:
            r2 = r2 | r29
            goto L_0x01c9
        L_0x01c7:
            r8 = r95
        L_0x01c9:
            r8 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x01e1
            r8 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r8 != 0) goto L_0x01da
            r8 = r96
            boolean r19 = r9.changed((java.lang.Object) r8)
            if (r19 == 0) goto L_0x01dc
            goto L_0x01de
        L_0x01da:
            r8 = r96
        L_0x01dc:
            r17 = r18
        L_0x01de:
            r2 = r2 | r17
            goto L_0x01e3
        L_0x01e1:
            r8 = r96
        L_0x01e3:
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r12 & r17
            if (r17 != 0) goto L_0x01fe
            r8 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r8 != 0) goto L_0x01f7
            r8 = r97
            boolean r17 = r9.changed((java.lang.Object) r8)
            if (r17 == 0) goto L_0x01f9
            goto L_0x01fb
        L_0x01f7:
            r8 = r97
        L_0x01f9:
            r21 = r22
        L_0x01fb:
            r2 = r2 | r21
            goto L_0x0200
        L_0x01fe:
            r8 = r97
        L_0x0200:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r11 & r17
            if (r17 == 0) goto L_0x020e
            r18 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r18
            r8 = r98
            goto L_0x0226
        L_0x020e:
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r12 & r18
            if (r18 != 0) goto L_0x0224
            r8 = r98
            boolean r18 = r9.changed((boolean) r8)
            if (r18 == 0) goto L_0x021f
            r18 = r25
            goto L_0x0221
        L_0x021f:
            r18 = r26
        L_0x0221:
            r2 = r2 | r18
            goto L_0x0226
        L_0x0224:
            r8 = r98
        L_0x0226:
            r18 = r11 & r26
            if (r18 == 0) goto L_0x0231
            r19 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r19
            r8 = r99
            goto L_0x0249
        L_0x0231:
            r19 = 3670016(0x380000, float:5.142788E-39)
            r19 = r12 & r19
            if (r19 != 0) goto L_0x0247
            r8 = r99
            boolean r19 = r9.changed((int) r8)
            if (r19 == 0) goto L_0x0242
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0244
        L_0x0242:
            r19 = r28
        L_0x0244:
            r2 = r2 | r19
            goto L_0x0249
        L_0x0247:
            r8 = r99
        L_0x0249:
            r19 = r11 & r25
            if (r19 == 0) goto L_0x0254
            r21 = 12582912(0xc00000, float:1.7632415E-38)
            r2 = r2 | r21
            r8 = r100
            goto L_0x026c
        L_0x0254:
            r21 = 29360128(0x1c00000, float:7.052966E-38)
            r21 = r12 & r21
            if (r21 != 0) goto L_0x026a
            r8 = r100
            boolean r21 = r9.changed((java.lang.Object) r8)
            if (r21 == 0) goto L_0x0265
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0267
        L_0x0265:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x0267:
            r2 = r2 | r21
            goto L_0x026c
        L_0x026a:
            r8 = r100
        L_0x026c:
            r21 = 234881024(0xe000000, float:1.5777218E-30)
            r21 = r12 & r21
            r22 = 262144(0x40000, float:3.67342E-40)
            if (r21 != 0) goto L_0x028a
            r21 = r11 & r22
            if (r21 != 0) goto L_0x0283
            r8 = r101
            boolean r21 = r9.changed((java.lang.Object) r8)
            if (r21 == 0) goto L_0x0285
            r21 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0287
        L_0x0283:
            r8 = r101
        L_0x0285:
            r21 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0287:
            r2 = r2 | r21
            goto L_0x028c
        L_0x028a:
            r8 = r101
        L_0x028c:
            r21 = 1879048192(0x70000000, float:1.58456325E29)
            r21 = r12 & r21
            if (r21 != 0) goto L_0x02a8
            r21 = r11 & r28
            if (r21 != 0) goto L_0x02a1
            r8 = r102
            boolean r21 = r9.changed((java.lang.Object) r8)
            if (r21 == 0) goto L_0x02a3
            r21 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x02a5
        L_0x02a1:
            r8 = r102
        L_0x02a3:
            r21 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x02a5:
            r2 = r2 | r21
            goto L_0x02aa
        L_0x02a8:
            r8 = r102
        L_0x02aa:
            r21 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r8 = r1 & r21
            r12 = 306783378(0x12492492, float:6.3469493E-28)
            if (r8 != r12) goto L_0x02f2
            r8 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r8 = r8 & r2
            r12 = 306783378(0x12492492, float:6.3469493E-28)
            if (r8 != r12) goto L_0x02f2
            boolean r8 = r9.getSkipping()
            if (r8 != 0) goto L_0x02c4
            goto L_0x02f2
        L_0x02c4:
            r9.skipToGroupEnd()
            r24 = r85
            r43 = r86
            r25 = r87
            r42 = r88
            r26 = r89
            r27 = r90
            r28 = r91
            r29 = r92
            r30 = r93
            r31 = r94
            r32 = r95
            r33 = r96
            r34 = r97
            r77 = r98
            r78 = r99
            r35 = r100
            r36 = r101
            r41 = r102
            r40 = r1
            r39 = r2
            r15 = r9
            goto L_0x0634
        L_0x02f2:
            r9.startDefaults()
            r8 = r13 & 1
            if (r8 == 0) goto L_0x037a
            boolean r8 = r9.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0301
            goto L_0x037a
        L_0x0301:
            r9.skipToGroupEnd()
            r0 = r11 & 32
            if (r0 == 0) goto L_0x030c
            r0 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r0
        L_0x030c:
            r0 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0312
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0312:
            r0 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x031a
            r0 = -57345(0xffffffffffff1fff, float:NaN)
            r2 = r2 & r0
        L_0x031a:
            r0 = r11 & r22
            if (r0 == 0) goto L_0x0322
            r0 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r2 = r2 & r0
        L_0x0322:
            r0 = r11 & r28
            if (r0 == 0) goto L_0x0352
            r0 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r0 = r0 & r2
            r23 = r85
            r12 = r86
            r24 = r87
            r8 = r88
            r25 = r89
            r26 = r90
            r27 = r91
            r28 = r92
            r29 = r93
            r30 = r94
            r31 = r95
            r32 = r96
            r33 = r97
            r77 = r98
            r78 = r99
            r34 = r100
            r35 = r101
            r7 = r102
            r5 = r0
            r6 = r1
            goto L_0x0522
        L_0x0352:
            r23 = r85
            r12 = r86
            r24 = r87
            r8 = r88
            r25 = r89
            r26 = r90
            r27 = r91
            r28 = r92
            r29 = r93
            r30 = r94
            r31 = r95
            r32 = r96
            r33 = r97
            r77 = r98
            r78 = r99
            r34 = r100
            r35 = r101
            r7 = r102
            r6 = r1
            r5 = r2
            goto L_0x0522
        L_0x037a:
            if (r3 == 0) goto L_0x0381
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x0383
        L_0x0381:
            r3 = r85
        L_0x0383:
            if (r16 == 0) goto L_0x0387
            r8 = 1
            goto L_0x0389
        L_0x0387:
            r8 = r86
        L_0x0389:
            if (r20 == 0) goto L_0x038d
            r12 = 0
            goto L_0x038f
        L_0x038d:
            r12 = r87
        L_0x038f:
            r16 = r11 & 32
            if (r16 == 0) goto L_0x03bc
            androidx.compose.runtime.ProvidableCompositionLocal r16 = androidx.compose.material3.TextKt.getLocalTextStyle()
            r85 = r3
            r3 = r16
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r16 = 6
            r20 = 0
            r86 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            r87 = r12
            java.lang.String r12 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r8, r12)
            java.lang.Object r8 = r9.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r3 = r8
            androidx.compose.ui.text.TextStyle r3 = (androidx.compose.ui.text.TextStyle) r3
            r8 = -458753(0xfffffffffff8ffff, float:NaN)
            r1 = r1 & r8
            goto L_0x03c4
        L_0x03bc:
            r85 = r3
            r86 = r8
            r87 = r12
            r3 = r88
        L_0x03c4:
            if (r27 == 0) goto L_0x03c8
            r8 = 0
            goto L_0x03ca
        L_0x03c8:
            r8 = r89
        L_0x03ca:
            if (r10 == 0) goto L_0x03ce
            r10 = 0
            goto L_0x03d0
        L_0x03ce:
            r10 = r90
        L_0x03d0:
            if (r0 == 0) goto L_0x03d4
            r0 = 0
            goto L_0x03d6
        L_0x03d4:
            r0 = r91
        L_0x03d6:
            if (r4 == 0) goto L_0x03da
            r4 = 0
            goto L_0x03dc
        L_0x03da:
            r4 = r92
        L_0x03dc:
            if (r5 == 0) goto L_0x03e0
            r5 = 0
            goto L_0x03e2
        L_0x03e0:
            r5 = r93
        L_0x03e2:
            if (r6 == 0) goto L_0x03e6
            r6 = 0
            goto L_0x03e8
        L_0x03e6:
            r6 = r94
        L_0x03e8:
            if (r7 == 0) goto L_0x03f1
            androidx.compose.ui.text.input.VisualTransformation$Companion r7 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r7 = r7.getNone()
            goto L_0x03f3
        L_0x03f1:
            r7 = r95
        L_0x03f3:
            r12 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L_0x0400
            androidx.compose.foundation.text.KeyboardOptions$Companion r12 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r12 = r12.getDefault()
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
            goto L_0x0402
        L_0x0400:
            r12 = r96
        L_0x0402:
            r88 = r0
            r0 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0414
            androidx.compose.foundation.text.KeyboardActions$Companion r0 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r0 = r0.getDefault()
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            r2 = r2 & r16
            goto L_0x0416
        L_0x0414:
            r0 = r97
        L_0x0416:
            if (r17 == 0) goto L_0x041d
            r16 = 0
            r77 = r16
            goto L_0x041f
        L_0x041d:
            r77 = r98
        L_0x041f:
            if (r18 == 0) goto L_0x0427
            r16 = 2147483647(0x7fffffff, float:NaN)
            r78 = r16
            goto L_0x0429
        L_0x0427:
            r78 = r99
        L_0x0429:
            if (r19 == 0) goto L_0x0470
            r16 = 0
            r17 = 0
            r89 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r0 = 0
            r90 = r9
            r18 = 0
            r91 = r0
            java.lang.Object r0 = r90.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r103 = r1
            java.lang.Object r1 = r20.getEmpty()
            if (r0 != r1) goto L_0x0461
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r92 = r0
            r0 = r90
            r0.updateRememberedValue(r1)
            goto L_0x0467
        L_0x0461:
            r92 = r0
            r0 = r90
            r1 = r92
        L_0x0467:
            r9.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x0476
        L_0x0470:
            r89 = r0
            r103 = r1
            r0 = r100
        L_0x0476:
            r1 = r11 & r22
            if (r1 == 0) goto L_0x0488
            androidx.compose.material3.TextFieldDefaults r1 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            r90 = r0
            r0 = 6
            androidx.compose.ui.graphics.Shape r0 = r1.getOutlinedShape(r9, r0)
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r2 = r2 & r1
            goto L_0x048c
        L_0x0488:
            r90 = r0
            r0 = r101
        L_0x048c:
            r1 = r11 & r28
            if (r1 == 0) goto L_0x0500
            androidx.compose.material3.TextFieldDefaults r16 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r28 = 0
            r30 = 0
            r32 = 0
            r34 = 0
            r36 = 0
            r38 = 0
            r40 = 0
            r42 = 0
            r44 = 0
            r46 = 0
            r48 = 0
            r50 = 0
            r52 = 0
            r54 = 0
            r56 = 0
            r58 = 0
            r60 = 0
            r62 = 0
            r64 = 0
            r66 = 0
            r68 = 0
            r70 = 0
            r73 = 0
            r74 = 0
            r75 = 100663296(0x6000000, float:2.4074124E-35)
            r76 = 268435455(0xfffffff, float:2.5243547E-29)
            r72 = r9
            androidx.compose.material3.TextFieldColors r1 = r16.m2154outlinedTextFieldColorsl59Burw(r17, r19, r21, r23, r25, r27, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r73, r74, r75, r76)
            r16 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r2 = r2 & r16
            r23 = r85
            r24 = r87
            r27 = r88
            r33 = r89
            r34 = r90
            r35 = r0
            r28 = r4
            r29 = r5
            r30 = r6
            r31 = r7
            r25 = r8
            r26 = r10
            r32 = r12
            r12 = r86
            r6 = r103
            r7 = r1
            r5 = r2
            r8 = r3
            goto L_0x0522
        L_0x0500:
            r23 = r85
            r24 = r87
            r27 = r88
            r33 = r89
            r34 = r90
            r35 = r0
            r28 = r4
            r29 = r5
            r30 = r6
            r31 = r7
            r25 = r8
            r26 = r10
            r32 = r12
            r12 = r86
            r7 = r102
            r6 = r103
            r5 = r2
            r8 = r3
        L_0x0522:
            r9.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0533
            java.lang.String r0 = "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:283)"
            r1 = 1040237435(0x3e00c37b, float:0.1257457)
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r6, r5, r0)
        L_0x0533:
            r0 = 1663543409(0x6327a871, float:3.0927437E21)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "*307@16789L18"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            long r0 = r8.m5494getColor0d7_KjU()
            r2 = 0
            r3 = r0
            r10 = 0
            androidx.compose.ui.graphics.Color$Companion r16 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r16.m3200getUnspecified0d7_KjU()
            int r16 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            r15 = 1
            if (r16 == 0) goto L_0x0553
            r16 = r15
            goto L_0x0555
        L_0x0553:
            r16 = 0
        L_0x0555:
            if (r16 == 0) goto L_0x055a
            r37 = r0
            goto L_0x0574
        L_0x055a:
            r3 = 0
            int r4 = r6 >> 9
            r4 = r4 & 14
            int r10 = r5 >> 24
            r10 = r10 & 112(0x70, float:1.57E-43)
            r4 = r4 | r10
            androidx.compose.runtime.State r4 = r7.textColor$material3_release(r12, r9, r4)
            java.lang.Object r4 = r4.getValue()
            androidx.compose.ui.graphics.Color r4 = (androidx.compose.ui.graphics.Color) r4
            long r16 = r4.m3174unboximpl()
            r37 = r16
        L_0x0574:
            r9.endReplaceableGroup()
            androidx.compose.ui.text.TextStyle r0 = new androidx.compose.ui.text.TextStyle
            r36 = r0
            r39 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r59 = 0
            r60 = 262142(0x3fffe, float:3.67339E-40)
            r61 = 0
            r36.<init>((long) r37, (long) r39, (androidx.compose.ui.text.font.FontWeight) r41, (androidx.compose.ui.text.font.FontStyle) r42, (androidx.compose.ui.text.font.FontSynthesis) r43, (androidx.compose.ui.text.font.FontFamily) r44, (java.lang.String) r45, (long) r46, (androidx.compose.ui.text.style.BaselineShift) r48, (androidx.compose.ui.text.style.TextGeometricTransform) r49, (androidx.compose.ui.text.intl.LocaleList) r50, (long) r51, (androidx.compose.ui.text.style.TextDecoration) r53, (androidx.compose.ui.graphics.Shadow) r54, (androidx.compose.ui.text.style.TextAlign) r55, (androidx.compose.ui.text.style.TextDirection) r56, (long) r57, (androidx.compose.ui.text.style.TextIndent) r59, (int) r60, (kotlin.jvm.internal.DefaultConstructorMarker) r61)
            androidx.compose.ui.text.TextStyle r36 = r8.merge((androidx.compose.ui.text.TextStyle) r0)
            r10 = r36
            androidx.compose.runtime.ProvidedValue[] r4 = new androidx.compose.runtime.ProvidedValue[r15]
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            int r1 = r5 >> 27
            r1 = r1 & 14
            androidx.compose.foundation.text.selection.TextSelectionColors r1 = r7.getSelectionColors(r9, r1)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r1 = 0
            r4[r1] = r0
            androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$5 r3 = new androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$5
            r0 = r3
            r1 = r25
            r2 = r23
            r79 = r3
            r3 = r7
            r80 = r4
            r4 = r30
            r39 = r5
            r40 = r6
            r6 = r83
            r41 = r7
            r7 = r84
            r42 = r8
            r8 = r12
            r81 = r9
            r9 = r24
            r11 = r32
            r43 = r12
            r12 = r33
            r13 = r77
            r14 = r78
            r15 = r31
            r16 = r34
            r17 = r40
            r18 = r26
            r19 = r27
            r20 = r28
            r21 = r29
            r22 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = -719341509(0xffffffffd51fb83b, float:-1.09758508E13)
            r1 = r79
            r15 = r81
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r2, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 56
            r2 = r80
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r15, (int) r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x061a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x061a:
            r36 = r35
            r35 = r34
            r34 = r33
            r33 = r32
            r32 = r31
            r31 = r30
            r30 = r29
            r29 = r28
            r28 = r27
            r27 = r26
            r26 = r25
            r25 = r24
            r24 = r23
        L_0x0634:
            androidx.compose.runtime.ScopeUpdateScope r14 = r15.endRestartGroup()
            if (r14 != 0) goto L_0x063d
            r38 = r15
            goto L_0x067f
        L_0x063d:
            androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$6 r37 = new androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$6
            r0 = r37
            r1 = r83
            r2 = r84
            r3 = r24
            r4 = r43
            r5 = r25
            r6 = r42
            r7 = r26
            r8 = r27
            r9 = r28
            r10 = r29
            r11 = r30
            r12 = r31
            r13 = r32
            r82 = r14
            r14 = r33
            r38 = r15
            r15 = r34
            r16 = r77
            r17 = r78
            r18 = r35
            r19 = r36
            r20 = r41
            r21 = r104
            r22 = r105
            r23 = r106
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r0 = r37
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r82
            r1.updateScope(r0)
        L_0x067f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: androidx.compose.material3.OutlinedTextFieldMeasurePolicy} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x02f0  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0bce  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void OutlinedTextFieldLayout(androidx.compose.ui.Modifier r56, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, kotlin.jvm.functions.Function3<? super androidx.compose.ui.Modifier, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r59, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r60, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r61, boolean r62, float r63, kotlin.jvm.functions.Function1<? super androidx.compose.ui.geometry.Size, kotlin.Unit> r64, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r65, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r66, androidx.compose.foundation.layout.PaddingValues r67, androidx.compose.runtime.Composer r68, int r69, int r70) {
        /*
            r15 = r56
            r14 = r57
            r13 = r58
            r12 = r59
            r11 = r60
            r10 = r61
            r9 = r62
            r8 = r63
            r7 = r64
            r6 = r65
            r5 = r66
            r4 = r67
            r3 = r69
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "textField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "onLabelMeasured"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "container"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "paddingValues"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = -222199799(0xfffffffff2c18009, float:-7.66533E30)
            r1 = r68
            androidx.compose.runtime.Composer r2 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(OutlinedTextFieldLayout)P(4,10,7,2,3,11,8!1,5!1,9)391@20070L239,399@20357L7,400@20369L2109:OutlinedTextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            r1 = r69
            r16 = r70
            r17 = r3 & 14
            r18 = 4
            if (r17 != 0) goto L_0x005c
            boolean r17 = r2.changed((java.lang.Object) r15)
            if (r17 == 0) goto L_0x0058
            r17 = r18
            goto L_0x005a
        L_0x0058:
            r17 = 2
        L_0x005a:
            r1 = r1 | r17
        L_0x005c:
            r17 = r3 & 112(0x70, float:1.57E-43)
            r20 = 32
            if (r17 != 0) goto L_0x006f
            boolean r17 = r2.changed((java.lang.Object) r14)
            if (r17 == 0) goto L_0x006b
            r17 = r20
            goto L_0x006d
        L_0x006b:
            r17 = 16
        L_0x006d:
            r1 = r1 | r17
        L_0x006f:
            r0 = r3 & 896(0x380, float:1.256E-42)
            if (r0 != 0) goto L_0x007f
            boolean r0 = r2.changed((java.lang.Object) r13)
            if (r0 == 0) goto L_0x007c
            r0 = 256(0x100, float:3.59E-43)
            goto L_0x007e
        L_0x007c:
            r0 = 128(0x80, float:1.794E-43)
        L_0x007e:
            r1 = r1 | r0
        L_0x007f:
            r0 = r3 & 7168(0x1c00, float:1.0045E-41)
            if (r0 != 0) goto L_0x008f
            boolean r0 = r2.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x008c
            r0 = 2048(0x800, float:2.87E-42)
            goto L_0x008e
        L_0x008c:
            r0 = 1024(0x400, float:1.435E-42)
        L_0x008e:
            r1 = r1 | r0
        L_0x008f:
            r0 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r3
            if (r0 != 0) goto L_0x00a1
            boolean r0 = r2.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x009e
            r0 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a0
        L_0x009e:
            r0 = 8192(0x2000, float:1.14794E-41)
        L_0x00a0:
            r1 = r1 | r0
        L_0x00a1:
            r0 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r3
            if (r0 != 0) goto L_0x00b2
            boolean r0 = r2.changed((java.lang.Object) r10)
            if (r0 == 0) goto L_0x00af
            r0 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b1
        L_0x00af:
            r0 = 65536(0x10000, float:9.18355E-41)
        L_0x00b1:
            r1 = r1 | r0
        L_0x00b2:
            r0 = 3670016(0x380000, float:5.142788E-39)
            r0 = r0 & r3
            if (r0 != 0) goto L_0x00c3
            boolean r0 = r2.changed((boolean) r9)
            if (r0 == 0) goto L_0x00c0
            r0 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c2
        L_0x00c0:
            r0 = 524288(0x80000, float:7.34684E-40)
        L_0x00c2:
            r1 = r1 | r0
        L_0x00c3:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r3
            if (r0 != 0) goto L_0x00d4
            boolean r0 = r2.changed((float) r8)
            if (r0 == 0) goto L_0x00d1
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00d3
        L_0x00d1:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00d3:
            r1 = r1 | r0
        L_0x00d4:
            r0 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r3
            if (r0 != 0) goto L_0x00e5
            boolean r0 = r2.changed((java.lang.Object) r7)
            if (r0 == 0) goto L_0x00e2
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00e4
        L_0x00e2:
            r0 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00e4:
            r1 = r1 | r0
        L_0x00e5:
            r0 = 1879048192(0x70000000, float:1.58456325E29)
            r0 = r0 & r3
            if (r0 != 0) goto L_0x00f6
            boolean r0 = r2.changed((java.lang.Object) r6)
            if (r0 == 0) goto L_0x00f3
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x00f5
        L_0x00f3:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x00f5:
            r1 = r1 | r0
        L_0x00f6:
            r0 = r70 & 14
            if (r0 != 0) goto L_0x0105
            boolean r0 = r2.changed((java.lang.Object) r5)
            if (r0 == 0) goto L_0x0101
            goto L_0x0103
        L_0x0101:
            r18 = 2
        L_0x0103:
            r16 = r16 | r18
        L_0x0105:
            r0 = r70 & 112(0x70, float:1.57E-43)
            if (r0 != 0) goto L_0x0114
            boolean r0 = r2.changed((java.lang.Object) r4)
            if (r0 == 0) goto L_0x0110
            goto L_0x0112
        L_0x0110:
            r20 = 16
        L_0x0112:
            r16 = r16 | r20
        L_0x0114:
            r0 = r16
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r1 & r16
            r15 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r15) goto L_0x0139
            r3 = r0 & 91
            r15 = 18
            if (r3 != r15) goto L_0x0139
            boolean r3 = r2.getSkipping()
            if (r3 != 0) goto L_0x012d
            goto L_0x0139
        L_0x012d:
            r2.skipToGroupEnd()
            r20 = r0
            r32 = r1
            r43 = r2
            r7 = r5
            goto L_0x0bd1
        L_0x0139:
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x0147
            java.lang.String r3 = "androidx.compose.material3.OutlinedTextFieldLayout (OutlinedTextField.kt:377)"
            r15 = -222199799(0xfffffffff2c18009, float:-7.66533E30)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r1, r0, r3)
        L_0x0147:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r62)
            java.lang.Float r15 = java.lang.Float.valueOf(r63)
            java.lang.Object[] r3 = new java.lang.Object[]{r7, r3, r15, r4}
            r15 = 8
            r16 = 0
            r18 = r15
            r15 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r2.startReplaceableGroup(r15)
            java.lang.String r15 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r15)
            r15 = 0
            r19 = r15
            int r15 = r3.length
            r20 = 0
            r55 = r20
            r20 = r0
            r0 = r55
        L_0x0170:
            if (r0 >= r15) goto L_0x0181
            r21 = r15
            r15 = r3[r0]
            boolean r22 = r2.changed((java.lang.Object) r15)
            r19 = r19 | r22
            int r0 = r0 + 1
            r15 = r21
            goto L_0x0170
        L_0x0181:
            r0 = r2
            r15 = 0
            r21 = r3
            java.lang.Object r3 = r0.rememberedValue()
            r22 = 0
            if (r19 != 0) goto L_0x019b
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r24 = r15
            java.lang.Object r15 = r23.getEmpty()
            if (r3 != r15) goto L_0x0198
            goto L_0x019d
        L_0x0198:
            r23 = r3
            goto L_0x01ad
        L_0x019b:
            r24 = r15
        L_0x019d:
            r15 = 0
            r23 = r3
            androidx.compose.material3.OutlinedTextFieldMeasurePolicy r3 = new androidx.compose.material3.OutlinedTextFieldMeasurePolicy
            r3.<init>(r7, r9, r8, r4)
            r0.updateRememberedValue(r3)
        L_0x01ad:
            r2.endReplaceableGroup()
            r0 = r3
            androidx.compose.material3.OutlinedTextFieldMeasurePolicy r0 = (androidx.compose.material3.OutlinedTextFieldMeasurePolicy) r0
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r15 = 0
            r16 = 0
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r8)
            java.lang.Object r18 = r2.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r3 = r18
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            int r15 = r1 << 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r16 = 0
            r7 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r7)
            java.lang.String r7 = "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r7)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r21 = 6
            r22 = 0
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r9, r8)
            java.lang.Object r9 = r2.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r7 = r9
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r21 = 6
            r22 = 0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r5, r8)
            java.lang.Object r5 = r2.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r21 = 6
            r22 = 0
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r12, r8)
            java.lang.Object r12 = r2.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            r9 = r12
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r12 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r21 = androidx.compose.ui.layout.LayoutKt.materializerOf(r56)
            int r14 = r15 << 9
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r14 = r14 | 6
            r22 = r21
            r21 = 0
            r23 = r15
            androidx.compose.runtime.Applier r15 = r2.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x0251
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0251:
            r2.startReusableNode()
            boolean r15 = r2.getInserting()
            if (r15 == 0) goto L_0x025e
            r2.createNode(r12)
            goto L_0x0261
        L_0x025e:
            r2.useNode()
        L_0x0261:
            r2.disableReusing()
            androidx.compose.runtime.Composer r15 = androidx.compose.runtime.Updater.m2787constructorimpl(r2)
            r24 = 0
            r25 = r12
            r12 = r0
            androidx.compose.ui.layout.MeasurePolicy r12 = (androidx.compose.ui.layout.MeasurePolicy) r12
            androidx.compose.ui.node.ComposeUiNode$Companion r26 = androidx.compose.ui.node.ComposeUiNode.Companion
            r27 = r0
            kotlin.jvm.functions.Function2 r0 = r26.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r12, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r7, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r5, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r9, r0)
            r2.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r2)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r0)
            int r12 = r14 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r15 = r22
            r15.invoke(r0, r2, r12)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r0)
            int r12 = r14 >> 9
            r12 = r12 & 14
            r22 = r2
            r24 = 0
            r0 = -147819150(0xfffffffff7307572, float:-3.579009E33)
            r28 = r5
            r5 = r22
            r5.startReplaceableGroup(r0)
            java.lang.String r0 = "C403@20438L11,442@21889L182,454@22246L163:OutlinedTextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r0)
            r0 = r12 & 11
            r22 = r7
            r7 = 2
            if (r0 != r7) goto L_0x02f0
            boolean r0 = r5.getSkipping()
            if (r0 != 0) goto L_0x02d9
            goto L_0x02f0
        L_0x02d9:
            r5.skipToGroupEnd()
            r7 = r66
            r32 = r1
            r43 = r2
            r45 = r3
            r30 = r9
            r31 = r12
            r35 = r14
            r38 = r15
            r12 = r59
            goto L_0x0bb9
        L_0x02f0:
            int r0 = r1 >> 27
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r6.invoke(r5, r0)
            r0 = 1116449790(0x428babfe, float:69.83592)
            r5.startReplaceableGroup(r0)
            java.lang.String r0 = "406@20502L219"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r0)
            java.lang.String r0 = "C72@3384L9:Box.kt#2w3rfo"
            java.lang.String r7 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            java.lang.String r6 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            r30 = r9
            if (r11 == 0) goto L_0x04ac
            androidx.compose.ui.Modifier$Companion r31 = androidx.compose.ui.Modifier.Companion
            r9 = r31
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            r31 = r12
            java.lang.String r12 = "Leading"
            androidx.compose.ui.Modifier r9 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r9, r12)
            androidx.compose.ui.Modifier r12 = androidx.compose.material3.TextFieldImplKt.getIconDefaultSizeModifier()
            androidx.compose.ui.Modifier r9 = r9.then(r12)
            androidx.compose.ui.Alignment$Companion r12 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r12 = r12.getCenter()
            r33 = 48
            r34 = 0
            r35 = r14
            r14 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r5.startReplaceableGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            r14 = 0
            int r36 = r33 >> 3
            r36 = r36 & 14
            int r37 = r33 >> 3
            r37 = r37 & 112(0x70, float:1.57E-43)
            r38 = r15
            r15 = r36 | r37
            androidx.compose.ui.layout.MeasurePolicy r15 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r12, r14, r5, r15)
            int r36 = r33 << 3
            r36 = r36 & 112(0x70, float:1.57E-43)
            r37 = 0
            r39 = r12
            r12 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r12)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r7)
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r40 = 6
            r41 = 0
            r42 = r14
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r14, r8)
            java.lang.Object r14 = r5.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r12 = r14
            androidx.compose.ui.unit.Density r12 = (androidx.compose.ui.unit.Density) r12
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r40 = 6
            r41 = 0
            r43 = r2
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r2, r8)
            java.lang.Object r2 = r5.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.LayoutDirection r2 = (androidx.compose.ui.unit.LayoutDirection) r2
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r40 = 6
            r41 = 0
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r13, r8)
            java.lang.Object r13 = r5.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.platform.ViewConfiguration r13 = (androidx.compose.ui.platform.ViewConfiguration) r13
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r40 = androidx.compose.ui.layout.LayoutKt.materializerOf(r9)
            r41 = r9
            int r9 = r36 << 9
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | 6
            r44 = r40
            r40 = 0
            r45 = r3
            androidx.compose.runtime.Applier r3 = r5.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x03d3
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03d3:
            r5.startReusableNode()
            boolean r3 = r5.getInserting()
            if (r3 == 0) goto L_0x03e0
            r5.createNode(r14)
            goto L_0x03e3
        L_0x03e0:
            r5.useNode()
        L_0x03e3:
            r5.disableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m2787constructorimpl(r5)
            r46 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r47 = androidx.compose.ui.node.ComposeUiNode.Companion
            r48 = r14
            kotlin.jvm.functions.Function2 r14 = r47.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r15, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r12, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r2, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r13, r14)
            r5.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r3)
            int r14 = r9 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r46 = r2
            r2 = r44
            r2.invoke(r3, r5, r14)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r3)
            int r3 = r9 >> 9
            r3 = r3 & 14
            r14 = r5
            r44 = 0
            r47 = r2
            r2 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r14.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r2 = r3 & 11
            r49 = r3
            r3 = 2
            if (r2 != r3) goto L_0x0459
            boolean r2 = r14.getSkipping()
            if (r2 != 0) goto L_0x0453
            goto L_0x0459
        L_0x0453:
            r14.skipToGroupEnd()
            r53 = r9
            goto L_0x049a
        L_0x0459:
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r3 = r33 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r50 = r14
            r51 = 0
            r52 = r2
            r2 = 2127001777(0x7ec778b1, float:1.3257152E38)
            r53 = r9
            r9 = r50
            r9.startReplaceableGroup(r2)
            java.lang.String r2 = "C410@20694L9:OutlinedTextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            r2 = r3 & 81
            r50 = r3
            r3 = 16
            if (r2 != r3) goto L_0x048b
            boolean r2 = r9.getSkipping()
            if (r2 != 0) goto L_0x0487
            goto L_0x048b
        L_0x0487:
            r9.skipToGroupEnd()
            goto L_0x0496
        L_0x048b:
            int r2 = r1 >> 12
            r2 = r2 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r11.invoke(r9, r2)
        L_0x0496:
            r9.endReplaceableGroup()
        L_0x049a:
            r14.endReplaceableGroup()
            r5.endReplaceableGroup()
            r5.endNode()
            r5.endReplaceableGroup()
            r5.endReplaceableGroup()
            goto L_0x04b6
        L_0x04ac:
            r43 = r2
            r45 = r3
            r31 = r12
            r35 = r14
            r38 = r15
        L_0x04b6:
            r5.endReplaceableGroup()
            r2 = 1116450075(0x428bad1b, float:69.8381)
            r5.startReplaceableGroup(r2)
            java.lang.String r2 = "414@20788L221"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            if (r10 == 0) goto L_0x065b
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            java.lang.String r3 = "Trailing"
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r2, r3)
            androidx.compose.ui.Modifier r3 = androidx.compose.material3.TextFieldImplKt.getIconDefaultSizeModifier()
            androidx.compose.ui.Modifier r2 = r2.then(r3)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getCenter()
            r9 = 48
            r12 = 0
            r13 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r5.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            r13 = 0
            int r14 = r9 >> 3
            r14 = r14 & 14
            int r15 = r9 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r14 = r14 | r15
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r13, r5, r14)
            int r15 = r9 << 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r33 = 0
            r34 = r3
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r7)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r36 = 6
            r37 = 0
            r39 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r12, r8)
            java.lang.Object r12 = r5.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r3 = r12
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r36 = 6
            r37 = 0
            r40 = r13
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r13, r8)
            java.lang.Object r13 = r5.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r12 = r13
            androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r36 = 6
            r37 = 0
            r41 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r7, r8)
            java.lang.Object r7 = r5.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r36 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            r37 = r2
            int r2 = r15 << 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | 6
            r42 = r36
            r36 = 0
            r44 = r15
            androidx.compose.runtime.Applier r15 = r5.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x0582
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0582:
            r5.startReusableNode()
            boolean r15 = r5.getInserting()
            if (r15 == 0) goto L_0x058f
            r5.createNode(r13)
            goto L_0x0592
        L_0x058f:
            r5.useNode()
        L_0x0592:
            r5.disableReusing()
            androidx.compose.runtime.Composer r15 = androidx.compose.runtime.Updater.m2787constructorimpl(r5)
            r46 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r47 = androidx.compose.ui.node.ComposeUiNode.Companion
            r48 = r13
            kotlin.jvm.functions.Function2 r13 = r47.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r14, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r3, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r12, r13)
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r13 = r13.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r7, r13)
            r5.enableReusing()
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r13 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r13)
            int r15 = r2 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r46 = r3
            r3 = r42
            r3.invoke(r13, r5, r15)
            r13 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r13)
            int r13 = r2 >> 9
            r13 = r13 & 14
            r15 = r5
            r42 = 0
            r47 = r2
            r2 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r15.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            r2 = r13 & 11
            r49 = r3
            r3 = 2
            if (r2 != r3) goto L_0x0608
            boolean r2 = r15.getSkipping()
            if (r2 != 0) goto L_0x0602
            goto L_0x0608
        L_0x0602:
            r15.skipToGroupEnd()
            r53 = r7
            goto L_0x0649
        L_0x0608:
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r3 = r9 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r50 = r15
            r51 = 0
            r52 = r2
            r2 = -827051110(0xffffffffceb4339a, float:-1.51164032E9)
            r53 = r7
            r7 = r50
            r7.startReplaceableGroup(r2)
            java.lang.String r2 = "C418@20981L10:OutlinedTextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            r2 = r3 & 81
            r50 = r3
            r3 = 16
            if (r2 != r3) goto L_0x063a
            boolean r2 = r7.getSkipping()
            if (r2 != 0) goto L_0x0636
            goto L_0x063a
        L_0x0636:
            r7.skipToGroupEnd()
            goto L_0x0645
        L_0x063a:
            int r2 = r1 >> 15
            r2 = r2 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.invoke(r7, r2)
        L_0x0645:
            r7.endReplaceableGroup()
        L_0x0649:
            r15.endReplaceableGroup()
            r5.endReplaceableGroup()
            r5.endNode()
            r5.endReplaceableGroup()
            r5.endReplaceableGroup()
            goto L_0x065d
        L_0x065b:
            r41 = r7
        L_0x065d:
            r5.endReplaceableGroup()
            r2 = r45
            float r3 = androidx.compose.foundation.layout.PaddingKt.calculateStartPadding(r4, r2)
            float r7 = androidx.compose.foundation.layout.PaddingKt.calculateEndPadding(r4, r2)
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            r44 = r9
            androidx.compose.ui.Modifier r44 = (androidx.compose.ui.Modifier) r44
            if (r11 == 0) goto L_0x0691
            float r9 = androidx.compose.material3.TextFieldImplKt.getHorizontalIconPadding()
            r12 = 0
            float r13 = r3 - r9
            float r9 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r13)
            r12 = 0
            r13 = 0
            float r14 = (float) r12
            float r12 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r14)
            r13 = 0
            float r14 = kotlin.ranges.RangesKt.coerceAtLeast((float) r9, (float) r12)
            float r9 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r14)
            r45 = r9
            goto L_0x0693
        L_0x0691:
            r45 = r3
        L_0x0693:
            r46 = 0
            if (r10 == 0) goto L_0x06b6
            float r9 = androidx.compose.material3.TextFieldImplKt.getHorizontalIconPadding()
            r12 = 0
            float r13 = r7 - r9
            float r9 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r13)
            r12 = 0
            r13 = 0
            float r14 = (float) r12
            float r12 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r14)
            r13 = 0
            float r14 = kotlin.ranges.RangesKt.coerceAtLeast((float) r9, (float) r12)
            float r9 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r14)
            r47 = r9
            goto L_0x06b8
        L_0x06b6:
            r47 = r7
        L_0x06b8:
            r48 = 0
            r49 = 10
            r50 = 0
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.PaddingKt.m764paddingqDBjuR0$default(r44, r45, r46, r47, r48, r49, r50)
            r12 = 1116451086(0x428bb10e, float:69.84581)
            r5.startReplaceableGroup(r12)
            java.lang.String r12 = "439@21802L59"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r12)
            r13 = r58
            if (r13 == 0) goto L_0x06ea
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            java.lang.String r14 = "Hint"
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r12, r14)
            androidx.compose.ui.Modifier r12 = r12.then(r9)
            int r14 = r1 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r13.invoke(r12, r5, r14)
        L_0x06ea:
            r5.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r12 = (androidx.compose.ui.Modifier) r12
            java.lang.String r14 = "TextField"
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r12, r14)
            androidx.compose.ui.Modifier r12 = r12.then(r9)
            r14 = 1
            r15 = 384(0x180, float:5.38E-43)
            r33 = 0
            r45 = r2
            r2 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r5.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopStart()
            int r34 = r15 >> 3
            r34 = r34 & 14
            int r36 = r15 >> 3
            r36 = r36 & 112(0x70, float:1.57E-43)
            r37 = r3
            r3 = r34 | r36
            androidx.compose.ui.layout.MeasurePolicy r3 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r2, r14, r5, r3)
            int r34 = r15 << 3
            r34 = r34 & 112(0x70, float:1.57E-43)
            r36 = 0
            r39 = r2
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r2)
            r2 = r41
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r40 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r4 = r40
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r40 = 6
            r41 = 0
            r42 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r7, r8)
            java.lang.Object r7 = r5.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r4 = r7
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r40 = 6
            r41 = 0
            r44 = r9
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r9, r8)
            java.lang.Object r9 = r5.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r7 = r9
            androidx.compose.ui.unit.LayoutDirection r7 = (androidx.compose.ui.unit.LayoutDirection) r7
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r40 = 6
            r41 = 0
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r10, r8)
            java.lang.Object r10 = r5.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r9 = r10
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r10 = r10.getConstructor()
            kotlin.jvm.functions.Function3 r40 = androidx.compose.ui.layout.LayoutKt.materializerOf(r12)
            int r11 = r34 << 9
            r11 = r11 & 7168(0x1c00, float:1.0045E-41)
            r11 = r11 | 6
            r41 = r40
            r40 = 0
            r46 = r12
            androidx.compose.runtime.Applier r12 = r5.getApplier()
            boolean r12 = r12 instanceof androidx.compose.runtime.Applier
            if (r12 != 0) goto L_0x07ac
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x07ac:
            r5.startReusableNode()
            boolean r12 = r5.getInserting()
            if (r12 == 0) goto L_0x07b9
            r5.createNode(r10)
            goto L_0x07bc
        L_0x07b9:
            r5.useNode()
        L_0x07bc:
            r5.disableReusing()
            androidx.compose.runtime.Composer r12 = androidx.compose.runtime.Updater.m2787constructorimpl(r5)
            r47 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r48 = androidx.compose.ui.node.ComposeUiNode.Companion
            r49 = r10
            kotlin.jvm.functions.Function2 r10 = r48.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r12, r3, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r12, r4, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r12, r7, r10)
            androidx.compose.ui.node.ComposeUiNode$Companion r10 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r10 = r10.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r12, r9, r10)
            r5.enableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r10 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r10)
            int r12 = r11 >> 3
            r12 = r12 & 112(0x70, float:1.57E-43)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r47 = r3
            r3 = r41
            r3.invoke(r10, r5, r12)
            r10 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r10)
            int r10 = r11 >> 9
            r10 = r10 & 14
            r12 = r5
            r41 = 0
            r48 = r3
            r3 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r12.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r0)
            r3 = r10 & 11
            r50 = r4
            r4 = 2
            if (r3 != r4) goto L_0x0834
            boolean r3 = r12.getSkipping()
            if (r3 != 0) goto L_0x082c
            goto L_0x0834
        L_0x082c:
            r12.skipToGroupEnd()
            r4 = r57
            r54 = r7
            goto L_0x0879
        L_0x0834:
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r4 = r15 >> 6
            r4 = r4 & 112(0x70, float:1.57E-43)
            r4 = r4 | 6
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            r51 = r12
            r52 = 0
            r53 = r3
            r3 = -475693524(0xffffffffe3a57e2c, float:-6.105609E21)
            r54 = r7
            r7 = r51
            r7.startReplaceableGroup(r3)
            java.lang.String r3 = "C446@22046L11:OutlinedTextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r3)
            r3 = r4 & 81
            r51 = r4
            r4 = 16
            if (r3 != r4) goto L_0x0868
            boolean r3 = r7.getSkipping()
            if (r3 != 0) goto L_0x0862
            goto L_0x0868
        L_0x0862:
            r7.skipToGroupEnd()
            r4 = r57
            goto L_0x0875
        L_0x0868:
            int r3 = r1 >> 3
            r3 = r3 & 14
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4 = r57
            r4.invoke(r7, r3)
        L_0x0875:
            r7.endReplaceableGroup()
        L_0x0879:
            r12.endReplaceableGroup()
            r5.endReplaceableGroup()
            r5.endNode()
            r5.endReplaceableGroup()
            r5.endReplaceableGroup()
            r3 = 1116451412(0x428bb254, float:69.8483)
            r5.startReplaceableGroup(r3)
            java.lang.String r3 = "450@22122L54"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r3)
            r12 = r59
            if (r12 == 0) goto L_0x0a21
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            java.lang.String r7 = "Label"
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r3, r7)
            r7 = 6
            r9 = 0
            r10 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r5.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r10 = r10.getTopStart()
            r11 = 0
            int r14 = r7 >> 3
            r14 = r14 & 14
            int r15 = r7 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r14 = r14 | r15
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r10, r11, r5, r14)
            int r15 = r7 << 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r33 = 0
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r4)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r34 = 6
            r36 = 0
            r39 = r9
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r9, r8)
            java.lang.Object r9 = r5.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r4 = r9
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r34 = 6
            r36 = 0
            r40 = r10
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r10, r8)
            java.lang.Object r10 = r5.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r9 = r10
            androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r34 = 6
            r36 = 0
            r41 = r11
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r11, r8)
            java.lang.Object r11 = r5.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r10 = r11
            androidx.compose.ui.platform.ViewConfiguration r10 = (androidx.compose.ui.platform.ViewConfiguration) r10
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r34 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            r36 = r3
            int r3 = r15 << 9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | 6
            r46 = r34
            r34 = 0
            androidx.compose.runtime.Applier r13 = r5.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x0949
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0949:
            r5.startReusableNode()
            boolean r13 = r5.getInserting()
            if (r13 == 0) goto L_0x0956
            r5.createNode(r11)
            goto L_0x0959
        L_0x0956:
            r5.useNode()
        L_0x0959:
            r5.disableReusing()
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m2787constructorimpl(r5)
            r47 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r48 = androidx.compose.ui.node.ComposeUiNode.Companion
            r49 = r11
            kotlin.jvm.functions.Function2 r11 = r48.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r13, r14, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r13, r4, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r13, r9, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r13, r10, r11)
            r5.enableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r11 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r11)
            int r13 = r3 >> 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r47 = r4
            r4 = r46
            r4.invoke(r11, r5, r13)
            r11 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r11)
            int r11 = r3 >> 9
            r11 = r11 & 14
            r13 = r5
            r46 = 0
            r48 = r3
            r3 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r13.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            r3 = r11 & 11
            r50 = r4
            r4 = 2
            if (r3 != r4) goto L_0x09cf
            boolean r3 = r13.getSkipping()
            if (r3 != 0) goto L_0x09c9
            goto L_0x09cf
        L_0x09c9:
            r13.skipToGroupEnd()
            r54 = r7
            goto L_0x0a0f
        L_0x09cf:
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r4 = r7 >> 6
            r4 = r4 & 112(0x70, float:1.57E-43)
            r4 = r4 | 6
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            r51 = r13
            r52 = 0
            r53 = r3
            r3 = -1527117480(0xffffffffa4fa0958, float:-1.08436046E-16)
            r54 = r7
            r7 = r51
            r7.startReplaceableGroup(r3)
            java.lang.String r3 = "C450@22167L7:OutlinedTextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r3)
            r3 = r4 & 81
            r51 = r4
            r4 = 16
            if (r3 != r4) goto L_0x0a01
            boolean r3 = r7.getSkipping()
            if (r3 != 0) goto L_0x09fd
            goto L_0x0a01
        L_0x09fd:
            r7.skipToGroupEnd()
            goto L_0x0a0c
        L_0x0a01:
            int r3 = r1 >> 9
            r3 = r3 & 14
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.invoke(r7, r3)
        L_0x0a0c:
            r7.endReplaceableGroup()
        L_0x0a0f:
            r13.endReplaceableGroup()
            r5.endReplaceableGroup()
            r5.endNode()
            r5.endReplaceableGroup()
            r5.endReplaceableGroup()
        L_0x0a21:
            r5.endReplaceableGroup()
            r7 = r66
            if (r7 == 0) goto L_0x0bb7
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            java.lang.String r4 = "Supporting"
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r3, r4)
            androidx.compose.material3.TextFieldDefaults r46 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 15
            r52 = 0
            androidx.compose.foundation.layout.PaddingValues r4 = androidx.compose.material3.TextFieldDefaults.m2145supportingTextPaddinga9UjIt4$material3_release$default(r46, r47, r48, r49, r50, r51, r52)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.padding(r3, r4)
            r4 = 0
            r9 = 0
            r10 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r5.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r6)
            androidx.compose.ui.Alignment$Companion r6 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r6 = r6.getTopStart()
            r10 = 0
            int r11 = r4 >> 3
            r11 = r11 & 14
            int r13 = r4 >> 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r11 = r11 | r13
            androidx.compose.ui.layout.MeasurePolicy r11 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r6, r10, r5, r11)
            int r13 = r4 << 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r14 = 0
            r15 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r5.startReplaceableGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r15 = 6
            r19 = 0
            r32 = r1
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r1, r8)
            java.lang.Object r1 = r5.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r15 = 6
            r19 = 0
            r33 = r6
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r6, r8)
            java.lang.Object r6 = r5.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r2 = r6
            androidx.compose.ui.unit.LayoutDirection r2 = (androidx.compose.ui.unit.LayoutDirection) r2
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r15 = 6
            r19 = 0
            r34 = r9
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r5, r9, r8)
            java.lang.Object r8 = r5.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r5)
            r6 = r8
            androidx.compose.ui.platform.ViewConfiguration r6 = (androidx.compose.ui.platform.ViewConfiguration) r6
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
            kotlin.jvm.functions.Function3 r9 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            int r15 = r13 << 9
            r15 = r15 & 7168(0x1c00, float:1.0045E-41)
            r15 = r15 | 6
            r18 = 0
            r19 = r3
            androidx.compose.runtime.Applier r3 = r5.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x0ae6
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0ae6:
            r5.startReusableNode()
            boolean r3 = r5.getInserting()
            if (r3 == 0) goto L_0x0af3
            r5.createNode(r8)
            goto L_0x0af6
        L_0x0af3:
            r5.useNode()
        L_0x0af6:
            r5.disableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m2787constructorimpl(r5)
            r36 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r39 = androidx.compose.ui.node.ComposeUiNode.Companion
            r40 = r8
            kotlin.jvm.functions.Function2 r8 = r39.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r11, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r1, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r2, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r6, r8)
            r5.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r5)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r3)
            int r8 = r15 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9.invoke(r3, r5, r8)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r5.startReplaceableGroup(r3)
            int r3 = r15 >> 9
            r3 = r3 & 14
            r8 = r5
            r26 = 0
            r36 = r1
            r1 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r8.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = r3 & 11
            r1 = 2
            if (r0 != r1) goto L_0x0b66
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x0b60
            goto L_0x0b66
        L_0x0b60:
            r8.skipToGroupEnd()
            r41 = r2
            goto L_0x0ba4
        L_0x0b66:
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r4 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r68 = r8
            r29 = 0
            r39 = r0
            r0 = 270332983(0x101cf437, float:3.0953712E-29)
            r41 = r2
            r2 = r68
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "C457@22395L12:OutlinedTextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            r0 = r1 & 81
            r68 = r1
            r1 = 16
            if (r0 != r1) goto L_0x0b98
            boolean r0 = r2.getSkipping()
            if (r0 != 0) goto L_0x0b94
            goto L_0x0b98
        L_0x0b94:
            r2.skipToGroupEnd()
            goto L_0x0ba1
        L_0x0b98:
            r0 = r20 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.invoke(r2, r0)
        L_0x0ba1:
            r2.endReplaceableGroup()
        L_0x0ba4:
            r8.endReplaceableGroup()
            r5.endReplaceableGroup()
            r5.endNode()
            r5.endReplaceableGroup()
            r5.endReplaceableGroup()
            goto L_0x0bb9
        L_0x0bb7:
            r32 = r1
        L_0x0bb9:
            r5.endReplaceableGroup()
            r43.endReplaceableGroup()
            r43.endNode()
            r43.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0bd1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0bd1:
            androidx.compose.runtime.ScopeUpdateScope r15 = r43.endRestartGroup()
            if (r15 != 0) goto L_0x0bde
            r17 = r20
            r18 = r32
            r19 = r43
            goto L_0x0c0e
        L_0x0bde:
            androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextFieldLayout$2 r16 = new androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextFieldLayout$2
            r17 = r20
            r0 = r16
            r18 = r32
            r1 = r56
            r19 = r43
            r2 = r57
            r3 = r58
            r4 = r59
            r5 = r60
            r6 = r61
            r7 = r62
            r8 = r63
            r9 = r64
            r10 = r65
            r11 = r66
            r12 = r67
            r13 = r69
            r14 = r70
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0c0e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextFieldLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, float, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateWidth-O3s9Psw  reason: not valid java name */
    public static final int m2031calculateWidthO3s9Psw(int leadingPlaceableWidth, int trailingPlaceableWidth, int textFieldPlaceableWidth, int labelPlaceableWidth, int placeholderPlaceableWidth, boolean isLabelInMiddleSection, long constraints, float density, PaddingValues paddingValues) {
        int focusedLabelWidth = 0;
        int wrappedWidth = leadingPlaceableWidth + Math.max(textFieldPlaceableWidth, Math.max(isLabelInMiddleSection ? labelPlaceableWidth : 0, placeholderPlaceableWidth)) + trailingPlaceableWidth;
        if (!isLabelInMiddleSection) {
            focusedLabelWidth = labelPlaceableWidth + MathKt.roundToInt(Dp.m5986constructorimpl(paddingValues.m771calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr) + paddingValues.m772calculateRightPaddingu2uoSUM(LayoutDirection.Ltr)) * density);
        }
        return Math.max(wrappedWidth, Math.max(focusedLabelWidth, Constraints.m5932getMinWidthimpl(constraints)));
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateHeight-O3s9Psw  reason: not valid java name */
    public static final int m2030calculateHeightO3s9Psw(int leadingPlaceableHeight, int trailingPlaceableHeight, int textFieldPlaceableHeight, int labelPlaceableHeight, int placeholderPlaceableHeight, int supportingPlaceableHeight, long constraints, float density, PaddingValues paddingValues) {
        return Math.max(Constraints.m5931getMinHeightimpl(constraints), Math.max(leadingPlaceableHeight, Math.max(trailingPlaceableHeight, MathKt.roundToInt(((float) Math.max(textFieldPlaceableHeight, placeholderPlaceableHeight)) + (paddingValues.m770calculateBottomPaddingD9Ej5fM() * density) + Math.max(paddingValues.m773calculateTopPaddingD9Ej5fM() * density, ((float) labelPlaceableHeight) / 2.0f)))) + supportingPlaceableHeight);
    }

    /* access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope $this$place, int totalHeight, int width, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable textFieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, float animationProgress, boolean singleLine, float density, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int i;
        int placeholderVerticalPosition;
        int startPositionY;
        float f;
        Placeable.PlacementScope.m4903place70tqf50$default($this$place, containerPlaceable, IntOffset.Companion.m6114getZeronOccac(), 0.0f, 2, (Object) null);
        int height = totalHeight - TextFieldImplKt.heightOrZero(supportingPlaceable);
        int topPadding = MathKt.roundToInt(paddingValues.m773calculateTopPaddingD9Ej5fM() * density);
        int startPadding = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * density);
        float iconPadding = TextFieldImplKt.getHorizontalIconPadding() * density;
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, (Object) null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.Companion.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, (Object) null);
        }
        if (labelPlaceable != null) {
            Placeable it = labelPlaceable;
            if (singleLine) {
                startPositionY = Alignment.Companion.getCenterVertically().align(it.getHeight(), height);
            } else {
                startPositionY = topPadding;
            }
            float f2 = (float) 1;
            float positionY = (((float) startPositionY) * (f2 - animationProgress)) - (((float) (it.getHeight() / 2)) * animationProgress);
            if (leadingPlaceable == null) {
                f = 0.0f;
            } else {
                f = (((float) TextFieldImplKt.widthOrZero(leadingPlaceable)) - iconPadding) * (f2 - animationProgress);
            }
            int positionX = MathKt.roundToInt(f) + startPadding;
            Placeable.PlacementScope.placeRelative$default($this$place, it, positionX, MathKt.roundToInt(positionY), 0.0f, 4, (Object) null);
        }
        if (singleLine) {
            i = Alignment.Companion.getCenterVertically().align(textFieldPlaceable.getHeight(), height);
        } else {
            i = topPadding;
        }
        Placeable.PlacementScope placementScope = $this$place;
        Placeable placeable = textFieldPlaceable;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(leadingPlaceable), Math.max(i, TextFieldImplKt.heightOrZero(labelPlaceable) / 2), 0.0f, 4, (Object) null);
        if (placeholderPlaceable != null) {
            Placeable it2 = placeholderPlaceable;
            if (singleLine) {
                placeholderVerticalPosition = Alignment.Companion.getCenterVertically().align(it2.getHeight(), height);
            } else {
                placeholderVerticalPosition = topPadding;
            }
            Placeable.PlacementScope.placeRelative$default($this$place, it2, TextFieldImplKt.widthOrZero(leadingPlaceable), placeholderVerticalPosition, 0.0f, 4, (Object) null);
        }
        if (supportingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$place, supportingPlaceable, 0, height, 0.0f, 4, (Object) null);
        }
    }

    /* renamed from: outlineCutout-12SF9DM  reason: not valid java name */
    public static final Modifier m2032outlineCutout12SF9DM(Modifier $this$outlineCutout_u2d12SF9DM, long labelSize, PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter($this$outlineCutout_u2d12SF9DM, "$this$outlineCutout");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return DrawModifierKt.drawWithContent($this$outlineCutout_u2d12SF9DM, new OutlinedTextFieldKt$outlineCutout$1(labelSize, paddingValues));
    }

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }
}
