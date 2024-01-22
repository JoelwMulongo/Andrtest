package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010-\u001a\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020.2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00122\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010/\u001aÂ\u0001\u00100\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u00101\u001a\r\u0012\u0004\u0012\u00020\n0\u0017¢\u0006\u0002\b\u00182\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0019\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e¢\u0006\u0002\b\u00182\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010$\u001a\u00020\u00122\u0006\u00104\u001a\u0002052\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\n0\u0017¢\u0006\u0002\b\u00182\u0013\u00107\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\u0010:\u001ae\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020&2\u0006\u0010A\u001a\u00020&2\u0006\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u0002052\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001aE\u0010H\u001a\u00020&2\u0006\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020&2\u0006\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020&2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010O\u001a\u0014\u0010P\u001a\u00020\u0010*\u00020\u00102\u0006\u0010Q\u001a\u00020RH\u0000\u001a\u0001\u0010S\u001a\u00020\n*\u00020T2\u0006\u0010U\u001a\u00020&2\u0006\u0010V\u001a\u00020&2\u0006\u0010W\u001a\u00020X2\b\u0010Y\u001a\u0004\u0018\u00010X2\b\u0010Z\u001a\u0004\u0018\u00010X2\b\u0010[\u001a\u0004\u0018\u00010X2\b\u0010\\\u001a\u0004\u0018\u00010X2\u0006\u0010]\u001a\u00020X2\b\u0010^\u001a\u0004\u0018\u00010X2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010_\u001a\u00020&2\u0006\u0010`\u001a\u00020&2\u0006\u00104\u001a\u0002052\u0006\u0010E\u001a\u000205H\u0002\u001al\u0010a\u001a\u00020\n*\u00020T2\u0006\u0010U\u001a\u00020&2\u0006\u0010V\u001a\u00020&2\u0006\u0010b\u001a\u00020X2\b\u0010Z\u001a\u0004\u0018\u00010X2\b\u0010[\u001a\u0004\u0018\u00010X2\b\u0010\\\u001a\u0004\u0018\u00010X2\u0006\u0010]\u001a\u00020X2\b\u0010^\u001a\u0004\u0018\u00010X2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010E\u001a\u0002052\u0006\u00108\u001a\u000209H\u0002\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0019\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006c"}, d2 = {"FirstBaselineOffset", "Landroidx/compose/ui/unit/Dp;", "getFirstBaselineOffset", "()F", "F", "TextFieldBottomPadding", "getTextFieldBottomPadding", "TextFieldTopPadding", "getTextFieldTopPadding", "TextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "textFieldHeight", "hasLabel", "labelBaseline", "leadingHeight", "trailingHeight", "placeholderHeight", "supportingHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-jCXOeKk", "(IZIIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "totalHeight", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "containerPlaceable", "supportingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextField.kt */
public final class TextFieldKt {
    private static final float FirstBaselineOffset = Dp.m5986constructorimpl((float) 20);
    private static final float TextFieldBottomPadding = Dp.m5986constructorimpl((float) 10);
    private static final float TextFieldTopPadding = Dp.m5986constructorimpl((float) 4);

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
        if (r10.changed((java.lang.Object) r96) != false) goto L_0x01de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x01f4, code lost:
        if (r10.changed((java.lang.Object) r97) != false) goto L_0x01fb;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextField(java.lang.String r83, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r84, androidx.compose.ui.Modifier r85, boolean r86, boolean r87, androidx.compose.ui.text.TextStyle r88, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r89, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r90, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r91, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r92, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r93, boolean r94, androidx.compose.ui.text.input.VisualTransformation r95, androidx.compose.foundation.text.KeyboardOptions r96, androidx.compose.foundation.text.KeyboardActions r97, boolean r98, int r99, androidx.compose.foundation.interaction.MutableInteractionSource r100, androidx.compose.ui.graphics.Shape r101, androidx.compose.material3.TextFieldColors r102, androidx.compose.runtime.Composer r103, int r104, int r105, int r106) {
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
            r0 = -1571072018(0xffffffffa25b57ee, float:-2.9726584E-18)
            r1 = r103
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TextField)P(18,10,9,1,12,16,6,11,7,17,15,3,19,5,4,14,8,2,13)163@8420L7,175@9034L39,176@9112L11,177@9173L17,185@9516L15,185@9450L1775:TextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r104
            r2 = r105
            r3 = r11 & 1
            if (r3 == 0) goto L_0x002f
            r1 = r1 | 6
            goto L_0x003d
        L_0x002f:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x003d
            boolean r3 = r10.changed((java.lang.Object) r15)
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
            boolean r3 = r10.changed((java.lang.Object) r14)
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
            boolean r16 = r10.changed((java.lang.Object) r4)
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
            boolean r20 = r10.changed((boolean) r5)
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
            boolean r24 = r10.changed((boolean) r6)
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
            boolean r27 = r10.changed((java.lang.Object) r7)
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
            boolean r30 = r10.changed((java.lang.Object) r8)
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
            r9 = r11 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x010e
            r31 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r31
            r0 = r90
            goto L_0x0126
        L_0x010e:
            r31 = 29360128(0x1c00000, float:7.052966E-38)
            r31 = r13 & r31
            if (r31 != 0) goto L_0x0124
            r0 = r90
            boolean r31 = r10.changed((java.lang.Object) r0)
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
            boolean r31 = r10.changed((java.lang.Object) r4)
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
            boolean r31 = r10.changed((java.lang.Object) r5)
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
            boolean r31 = r10.changed((java.lang.Object) r6)
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
            boolean r19 = r10.changed((boolean) r7)
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
            boolean r19 = r10.changed((java.lang.Object) r8)
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
            boolean r19 = r10.changed((java.lang.Object) r8)
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
            boolean r17 = r10.changed((java.lang.Object) r8)
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
            boolean r18 = r10.changed((boolean) r8)
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
            boolean r19 = r10.changed((int) r8)
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
            boolean r21 = r10.changed((java.lang.Object) r8)
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
            boolean r21 = r10.changed((java.lang.Object) r8)
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
            boolean r21 = r10.changed((java.lang.Object) r8)
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
            boolean r8 = r10.getSkipping()
            if (r8 != 0) goto L_0x02c4
            goto L_0x02f2
        L_0x02c4:
            r10.skipToGroupEnd()
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
            r15 = r10
            goto L_0x0635
        L_0x02f2:
            r10.startDefaults()
            r8 = r13 & 1
            if (r8 == 0) goto L_0x037a
            boolean r8 = r10.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0301
            goto L_0x037a
        L_0x0301:
            r10.skipToGroupEnd()
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
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r8, r12)
            java.lang.Object r8 = r10.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
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
            if (r9 == 0) goto L_0x03ce
            r9 = 0
            goto L_0x03d0
        L_0x03ce:
            r9 = r90
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
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = 0
            r90 = r10
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
            r10.endReplaceableGroup()
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
            androidx.compose.ui.graphics.Shape r0 = r1.getFilledShape(r10, r0)
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
            r72 = r10
            androidx.compose.material3.TextFieldColors r1 = r16.m2157textFieldColorsl59Burw(r17, r19, r21, r23, r25, r27, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r73, r74, r75, r76)
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
            r26 = r9
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
            r26 = r9
            r32 = r12
            r12 = r86
            r7 = r102
            r6 = r103
            r5 = r2
            r8 = r3
        L_0x0522:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0533
            java.lang.String r0 = "androidx.compose.material3.TextField (TextField.kt:157)"
            r1 = -1571072018(0xffffffffa25b57ee, float:-2.9726584E-18)
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r6, r5, r0)
        L_0x0533:
            r0 = -1263332264(0xffffffffb4b31458, float:-3.335615E-7)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "*181@9342L18"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            long r0 = r8.m5494getColor0d7_KjU()
            r2 = 0
            r3 = r0
            r9 = 0
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
            int r9 = r5 >> 24
            r9 = r9 & 112(0x70, float:1.57E-43)
            r4 = r4 | r9
            androidx.compose.runtime.State r4 = r7.textColor$material3_release(r12, r10, r4)
            java.lang.Object r4 = r4.getValue()
            androidx.compose.ui.graphics.Color r4 = (androidx.compose.ui.graphics.Color) r4
            long r16 = r4.m3174unboximpl()
            r37 = r16
        L_0x0574:
            r10.endReplaceableGroup()
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
            r9 = r36
            androidx.compose.runtime.ProvidedValue[] r4 = new androidx.compose.runtime.ProvidedValue[r15]
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            int r1 = r5 >> 27
            r1 = r1 & 14
            androidx.compose.foundation.text.selection.TextSelectionColors r1 = r7.getSelectionColors(r10, r1)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r1 = 0
            r4[r1] = r0
            androidx.compose.material3.TextFieldKt$TextField$2 r3 = new androidx.compose.material3.TextFieldKt$TextField$2
            r0 = r3
            r1 = r23
            r2 = r7
            r79 = r3
            r3 = r30
            r80 = r4
            r4 = r5
            r39 = r5
            r5 = r83
            r40 = r6
            r6 = r84
            r41 = r7
            r7 = r12
            r42 = r8
            r8 = r24
            r81 = r10
            r10 = r32
            r11 = r33
            r43 = r12
            r12 = r77
            r13 = r78
            r14 = r31
            r15 = r34
            r16 = r40
            r17 = r25
            r18 = r26
            r19 = r27
            r20 = r28
            r21 = r29
            r22 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = -1197699922(0xffffffffb89c8cae, float:-7.464863E-5)
            r1 = r79
            r15 = r81
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r2, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 56
            r2 = r80
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r15, (int) r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x061b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x061b:
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
        L_0x0635:
            androidx.compose.runtime.ScopeUpdateScope r14 = r15.endRestartGroup()
            if (r14 != 0) goto L_0x063e
            r38 = r15
            goto L_0x0680
        L_0x063e:
            androidx.compose.material3.TextFieldKt$TextField$3 r37 = new androidx.compose.material3.TextFieldKt$TextField$3
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
        L_0x0680:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
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
        if (r10.changed((java.lang.Object) r96) != false) goto L_0x01de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x01f4, code lost:
        if (r10.changed((java.lang.Object) r97) != false) goto L_0x01fb;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextField(androidx.compose.ui.text.input.TextFieldValue r83, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r84, androidx.compose.ui.Modifier r85, boolean r86, boolean r87, androidx.compose.ui.text.TextStyle r88, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r89, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r90, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r91, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r92, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r93, boolean r94, androidx.compose.ui.text.input.VisualTransformation r95, androidx.compose.foundation.text.KeyboardOptions r96, androidx.compose.foundation.text.KeyboardActions r97, boolean r98, int r99, androidx.compose.foundation.interaction.MutableInteractionSource r100, androidx.compose.ui.graphics.Shape r101, androidx.compose.material3.TextFieldColors r102, androidx.compose.runtime.Composer r103, int r104, int r105, int r106) {
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
            r0 = -830955973(0xffffffffce789e3b, float:-1.04277984E9)
            r1 = r103
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TextField)P(18,10,9,1,12,16,6,11,7,17,15,3,19,5,4,14,8,2,13)300@15974L7,312@16588L39,313@16666L11,314@16727L17,322@17070L15,322@17004L1780:TextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r104
            r2 = r105
            r3 = r11 & 1
            if (r3 == 0) goto L_0x002f
            r1 = r1 | 6
            goto L_0x003d
        L_0x002f:
            r3 = r13 & 14
            if (r3 != 0) goto L_0x003d
            boolean r3 = r10.changed((java.lang.Object) r15)
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
            boolean r3 = r10.changed((java.lang.Object) r14)
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
            boolean r16 = r10.changed((java.lang.Object) r4)
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
            boolean r20 = r10.changed((boolean) r5)
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
            boolean r24 = r10.changed((boolean) r6)
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
            boolean r27 = r10.changed((java.lang.Object) r7)
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
            boolean r30 = r10.changed((java.lang.Object) r8)
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
            r9 = r11 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x010e
            r31 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r31
            r0 = r90
            goto L_0x0126
        L_0x010e:
            r31 = 29360128(0x1c00000, float:7.052966E-38)
            r31 = r13 & r31
            if (r31 != 0) goto L_0x0124
            r0 = r90
            boolean r31 = r10.changed((java.lang.Object) r0)
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
            boolean r31 = r10.changed((java.lang.Object) r4)
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
            boolean r31 = r10.changed((java.lang.Object) r5)
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
            boolean r31 = r10.changed((java.lang.Object) r6)
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
            boolean r19 = r10.changed((boolean) r7)
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
            boolean r19 = r10.changed((java.lang.Object) r8)
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
            boolean r19 = r10.changed((java.lang.Object) r8)
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
            boolean r17 = r10.changed((java.lang.Object) r8)
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
            boolean r18 = r10.changed((boolean) r8)
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
            boolean r19 = r10.changed((int) r8)
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
            boolean r21 = r10.changed((java.lang.Object) r8)
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
            boolean r21 = r10.changed((java.lang.Object) r8)
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
            boolean r21 = r10.changed((java.lang.Object) r8)
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
            boolean r8 = r10.getSkipping()
            if (r8 != 0) goto L_0x02c4
            goto L_0x02f2
        L_0x02c4:
            r10.skipToGroupEnd()
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
            r15 = r10
            goto L_0x0635
        L_0x02f2:
            r10.startDefaults()
            r8 = r13 & 1
            if (r8 == 0) goto L_0x037a
            boolean r8 = r10.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0301
            goto L_0x037a
        L_0x0301:
            r10.skipToGroupEnd()
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
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r8, r12)
            java.lang.Object r8 = r10.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
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
            if (r9 == 0) goto L_0x03ce
            r9 = 0
            goto L_0x03d0
        L_0x03ce:
            r9 = r90
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
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = 0
            r90 = r10
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
            r10.endReplaceableGroup()
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
            androidx.compose.ui.graphics.Shape r0 = r1.getFilledShape(r10, r0)
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
            r72 = r10
            androidx.compose.material3.TextFieldColors r1 = r16.m2157textFieldColorsl59Burw(r17, r19, r21, r23, r25, r27, r28, r30, r32, r34, r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r73, r74, r75, r76)
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
            r26 = r9
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
            r26 = r9
            r32 = r12
            r12 = r86
            r7 = r102
            r6 = r103
            r5 = r2
            r8 = r3
        L_0x0522:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0533
            java.lang.String r0 = "androidx.compose.material3.TextField (TextField.kt:294)"
            r1 = -830955973(0xffffffffce789e3b, float:-1.04277984E9)
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r6, r5, r0)
        L_0x0533:
            r0 = -1263324710(0xffffffffb4b331da, float:-3.337762E-7)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "*318@16896L18"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            long r0 = r8.m5494getColor0d7_KjU()
            r2 = 0
            r3 = r0
            r9 = 0
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
            int r9 = r5 >> 24
            r9 = r9 & 112(0x70, float:1.57E-43)
            r4 = r4 | r9
            androidx.compose.runtime.State r4 = r7.textColor$material3_release(r12, r10, r4)
            java.lang.Object r4 = r4.getValue()
            androidx.compose.ui.graphics.Color r4 = (androidx.compose.ui.graphics.Color) r4
            long r16 = r4.m3174unboximpl()
            r37 = r16
        L_0x0574:
            r10.endReplaceableGroup()
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
            r9 = r36
            androidx.compose.runtime.ProvidedValue[] r4 = new androidx.compose.runtime.ProvidedValue[r15]
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.foundation.text.selection.TextSelectionColorsKt.getLocalTextSelectionColors()
            int r1 = r5 >> 27
            r1 = r1 & 14
            androidx.compose.foundation.text.selection.TextSelectionColors r1 = r7.getSelectionColors(r10, r1)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r1 = 0
            r4[r1] = r0
            androidx.compose.material3.TextFieldKt$TextField$5 r3 = new androidx.compose.material3.TextFieldKt$TextField$5
            r0 = r3
            r1 = r23
            r2 = r7
            r79 = r3
            r3 = r30
            r80 = r4
            r4 = r5
            r39 = r5
            r5 = r83
            r40 = r6
            r6 = r84
            r41 = r7
            r7 = r12
            r42 = r8
            r8 = r24
            r81 = r10
            r10 = r32
            r11 = r33
            r43 = r12
            r12 = r77
            r13 = r78
            r14 = r31
            r15 = r34
            r16 = r40
            r17 = r25
            r18 = r26
            r19 = r27
            r20 = r28
            r21 = r29
            r22 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0 = 765006587(0x2d9912fb, float:1.7402515E-11)
            r1 = r79
            r15 = r81
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r2, r1)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 56
            r2 = r80
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r15, (int) r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x061b
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x061b:
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
        L_0x0635:
            androidx.compose.runtime.ScopeUpdateScope r14 = r15.endRestartGroup()
            if (r14 != 0) goto L_0x063e
            r38 = r15
            goto L_0x0680
        L_0x063e:
            androidx.compose.material3.TextFieldKt$TextField$6 r37 = new androidx.compose.material3.TextFieldKt$TextField$6
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
        L_0x0680:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02ce  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0bbb  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0240  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void TextFieldLayout(androidx.compose.ui.Modifier r55, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, kotlin.jvm.functions.Function3<? super androidx.compose.ui.Modifier, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r58, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r59, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r60, boolean r61, float r62, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r63, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r64, androidx.compose.foundation.layout.PaddingValues r65, androidx.compose.runtime.Composer r66, int r67, int r68) {
        /*
            r14 = r55
            r15 = r56
            r13 = r57
            r12 = r58
            r11 = r59
            r10 = r60
            r9 = r61
            r8 = r62
            r7 = r63
            r6 = r64
            r5 = r65
            r4 = r67
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "textField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "container"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "paddingValues"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 1259241976(0x4b0e81f8, float:9339384.0)
            r1 = r66
            androidx.compose.runtime.Composer r3 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TextFieldLayout)P(4,9,2,6,3,10,7!2,8)384@19422L139,387@19609L7,388@19621L2645:TextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r1)
            r1 = r67
            r2 = r68
            r16 = r4 & 14
            r17 = 4
            if (r16 != 0) goto L_0x0054
            boolean r16 = r3.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x0050
            r16 = r17
            goto L_0x0052
        L_0x0050:
            r16 = 2
        L_0x0052:
            r1 = r1 | r16
        L_0x0054:
            r16 = r4 & 112(0x70, float:1.57E-43)
            if (r16 != 0) goto L_0x0065
            boolean r16 = r3.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x0061
            r16 = 32
            goto L_0x0063
        L_0x0061:
            r16 = 16
        L_0x0063:
            r1 = r1 | r16
        L_0x0065:
            r0 = r4 & 896(0x380, float:1.256E-42)
            if (r0 != 0) goto L_0x0075
            boolean r0 = r3.changed((java.lang.Object) r13)
            if (r0 == 0) goto L_0x0072
            r0 = 256(0x100, float:3.59E-43)
            goto L_0x0074
        L_0x0072:
            r0 = 128(0x80, float:1.794E-43)
        L_0x0074:
            r1 = r1 | r0
        L_0x0075:
            r0 = r4 & 7168(0x1c00, float:1.0045E-41)
            if (r0 != 0) goto L_0x0085
            boolean r0 = r3.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x0082
            r0 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0082:
            r0 = 1024(0x400, float:1.435E-42)
        L_0x0084:
            r1 = r1 | r0
        L_0x0085:
            r0 = 57344(0xe000, float:8.0356E-41)
            r0 = r0 & r4
            if (r0 != 0) goto L_0x0097
            boolean r0 = r3.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x0094
            r0 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0094:
            r0 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r1 = r1 | r0
        L_0x0097:
            r0 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r4
            if (r0 != 0) goto L_0x00a8
            boolean r0 = r3.changed((java.lang.Object) r10)
            if (r0 == 0) goto L_0x00a5
            r0 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a7
        L_0x00a5:
            r0 = 65536(0x10000, float:9.18355E-41)
        L_0x00a7:
            r1 = r1 | r0
        L_0x00a8:
            r0 = 3670016(0x380000, float:5.142788E-39)
            r0 = r0 & r4
            if (r0 != 0) goto L_0x00b9
            boolean r0 = r3.changed((boolean) r9)
            if (r0 == 0) goto L_0x00b6
            r0 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00b8
        L_0x00b6:
            r0 = 524288(0x80000, float:7.34684E-40)
        L_0x00b8:
            r1 = r1 | r0
        L_0x00b9:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r4
            if (r0 != 0) goto L_0x00ca
            boolean r0 = r3.changed((float) r8)
            if (r0 == 0) goto L_0x00c7
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00c9
        L_0x00c7:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x00c9:
            r1 = r1 | r0
        L_0x00ca:
            r0 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r4
            if (r0 != 0) goto L_0x00db
            boolean r0 = r3.changed((java.lang.Object) r7)
            if (r0 == 0) goto L_0x00d8
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00da
        L_0x00d8:
            r0 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00da:
            r1 = r1 | r0
        L_0x00db:
            r0 = 1879048192(0x70000000, float:1.58456325E29)
            r0 = r0 & r4
            if (r0 != 0) goto L_0x00ec
            boolean r0 = r3.changed((java.lang.Object) r6)
            if (r0 == 0) goto L_0x00e9
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x00eb
        L_0x00e9:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x00eb:
            r1 = r1 | r0
        L_0x00ec:
            r0 = r68 & 14
            if (r0 != 0) goto L_0x00fb
            boolean r0 = r3.changed((java.lang.Object) r5)
            if (r0 == 0) goto L_0x00f7
            goto L_0x00f9
        L_0x00f7:
            r17 = 2
        L_0x00f9:
            r2 = r2 | r17
        L_0x00fb:
            r0 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r0 = r0 & r1
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r4) goto L_0x011a
            r0 = r2 & 11
            r4 = 2
            if (r0 != r4) goto L_0x011a
            boolean r0 = r3.getSkipping()
            if (r0 != 0) goto L_0x0110
            goto L_0x011a
        L_0x0110:
            r3.skipToGroupEnd()
            r18 = r2
            r43 = r3
            r9 = r6
            goto L_0x0bbe
        L_0x011a:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0128
            java.lang.String r0 = "androidx.compose.material3.TextFieldLayout (TextField.kt:371)"
            r4 = 1259241976(0x4b0e81f8, float:9339384.0)
            androidx.compose.runtime.ComposerKt.traceEventStart(r4, r1, r2, r0)
        L_0x0128:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r61)
            java.lang.Float r4 = java.lang.Float.valueOf(r62)
            int r17 = r1 >> 18
            r17 = r17 & 14
            int r18 = r1 >> 18
            r18 = r18 & 112(0x70, float:1.57E-43)
            r17 = r17 | r18
            int r14 = r2 << 6
            r14 = r14 & 896(0x380, float:1.256E-42)
            r14 = r17 | r14
            r17 = 0
            r18 = r2
            r2 = 1618982084(0x607fb4c4, float:7.370227E19)
            r3.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r2)
            boolean r2 = r3.changed((java.lang.Object) r0)
            boolean r19 = r3.changed((java.lang.Object) r4)
            r2 = r2 | r19
            boolean r19 = r3.changed((java.lang.Object) r5)
            r2 = r2 | r19
            r19 = r3
            r20 = 0
            r21 = r0
            java.lang.Object r0 = r19.rememberedValue()
            r22 = 0
            if (r2 != 0) goto L_0x017f
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r24 = r2
            java.lang.Object r2 = r23.getEmpty()
            if (r0 != r2) goto L_0x017a
            goto L_0x0181
        L_0x017a:
            r23 = r0
            r2 = r19
            goto L_0x018f
        L_0x017f:
            r24 = r2
        L_0x0181:
            r2 = 0
            r23 = r0
            androidx.compose.material3.TextFieldMeasurePolicy r0 = new androidx.compose.material3.TextFieldMeasurePolicy
            r0.<init>(r9, r8, r5)
            r2 = r19
            r2.updateRememberedValue(r0)
        L_0x018f:
            r3.endReplaceableGroup()
            androidx.compose.material3.TextFieldMeasurePolicy r0 = (androidx.compose.material3.TextFieldMeasurePolicy) r0
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 0
            r14 = 0
            r17 = r4
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r8 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r4, r8)
            java.lang.Object r19 = r3.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r2 = r19
            androidx.compose.ui.unit.LayoutDirection r2 = (androidx.compose.ui.unit.LayoutDirection) r2
            int r14 = r1 << 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            r17 = 0
            r4 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r3.startReplaceableGroup(r4)
            java.lang.String r4 = "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r21 = 6
            r22 = 0
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r9, r8)
            java.lang.Object r9 = r3.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r4 = r9
            androidx.compose.ui.unit.Density r4 = (androidx.compose.ui.unit.Density) r4
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r21 = 6
            r22 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r6, r8)
            java.lang.Object r6 = r3.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r21 = 6
            r22 = 0
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r15, r8)
            java.lang.Object r15 = r3.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r9 = r15
            androidx.compose.ui.platform.ViewConfiguration r9 = (androidx.compose.ui.platform.ViewConfiguration) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r15 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r15 = r15.getConstructor()
            kotlin.jvm.functions.Function3 r21 = androidx.compose.ui.layout.LayoutKt.materializerOf(r55)
            int r13 = r14 << 9
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r13 = r13 | 6
            r22 = r21
            r21 = 0
            r23 = r14
            androidx.compose.runtime.Applier r14 = r3.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x0233
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0233:
            r3.startReusableNode()
            boolean r14 = r3.getInserting()
            if (r14 == 0) goto L_0x0240
            r3.createNode(r15)
            goto L_0x0243
        L_0x0240:
            r3.useNode()
        L_0x0243:
            r3.disableReusing()
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m2787constructorimpl(r3)
            r24 = 0
            r25 = r15
            r15 = r0
            androidx.compose.ui.layout.MeasurePolicy r15 = (androidx.compose.ui.layout.MeasurePolicy) r15
            androidx.compose.ui.node.ComposeUiNode$Companion r26 = androidx.compose.ui.node.ComposeUiNode.Companion
            r27 = r0
            kotlin.jvm.functions.Function2 r0 = r26.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r14, r15, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r14, r4, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r14, r6, r0)
            androidx.compose.ui.node.ComposeUiNode$Companion r0 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r0 = r0.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r14, r9, r0)
            r3.enableReusing()
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r3)
            androidx.compose.runtime.SkippableUpdater r0 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r0)
            int r14 = r13 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r15 = r22
            r15.invoke(r0, r3, r14)
            r0 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r3.startReplaceableGroup(r0)
            int r14 = r13 >> 9
            r14 = r14 & 14
            r22 = r3
            r24 = 0
            r0 = 1036839073(0x3dcce8a1, float:0.10005308)
            r28 = r4
            r4 = r22
            r4.startReplaceableGroup(r0)
            java.lang.String r0 = "C394@19940L11,445@21753L225,455@22034L163:TextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r0)
            r0 = r14 & 11
            r22 = r6
            r6 = 2
            if (r0 != r6) goto L_0x02ce
            boolean r0 = r4.getSkipping()
            if (r0 != 0) goto L_0x02bb
            goto L_0x02ce
        L_0x02bb:
            r4.skipToGroupEnd()
            r45 = r2
            r43 = r3
            r30 = r9
            r31 = r13
            r35 = r14
            r38 = r15
            r9 = r64
            goto L_0x0ba6
        L_0x02ce:
            int r0 = r1 >> 24
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7.invoke(r4, r0)
            r0 = -95277174(0xfffffffffa522f8a, float:-2.7283664E35)
            r4.startReplaceableGroup(r0)
            java.lang.String r0 = "397@20004L269"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r0)
            java.lang.String r0 = "C72@3384L9:Box.kt#2w3rfo"
            java.lang.String r6 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            java.lang.String r7 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            r30 = r9
            if (r11 == 0) goto L_0x048a
            androidx.compose.ui.Modifier$Companion r31 = androidx.compose.ui.Modifier.Companion
            r9 = r31
            androidx.compose.ui.Modifier r9 = (androidx.compose.ui.Modifier) r9
            r31 = r13
            java.lang.String r13 = "Leading"
            androidx.compose.ui.Modifier r9 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r9, r13)
            androidx.compose.ui.Modifier r13 = androidx.compose.material3.TextFieldImplKt.getIconDefaultSizeModifier()
            androidx.compose.ui.Modifier r9 = r9.then(r13)
            androidx.compose.ui.Alignment$Companion r13 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r13 = r13.getCenter()
            r33 = 48
            r34 = 0
            r35 = r14
            r14 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r4.startReplaceableGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r7)
            r14 = 0
            int r36 = r33 >> 3
            r36 = r36 & 14
            int r37 = r33 >> 3
            r37 = r37 & 112(0x70, float:1.57E-43)
            r38 = r15
            r15 = r36 | r37
            androidx.compose.ui.layout.MeasurePolicy r15 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r13, r14, r4, r15)
            int r36 = r33 << 3
            r36 = r36 & 112(0x70, float:1.57E-43)
            r37 = 0
            r39 = r13
            r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r4.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r40 = 6
            r41 = 0
            r42 = r14
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r14, r8)
            java.lang.Object r14 = r4.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r13 = r14
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r40 = 6
            r41 = 0
            r43 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r3, r8)
            java.lang.Object r3 = r4.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r40 = 6
            r41 = 0
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r12, r8)
            java.lang.Object r12 = r4.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.platform.ViewConfiguration r12 = (androidx.compose.ui.platform.ViewConfiguration) r12
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r40 = androidx.compose.ui.layout.LayoutKt.materializerOf(r9)
            r41 = r9
            int r9 = r36 << 9
            r9 = r9 & 7168(0x1c00, float:1.0045E-41)
            r9 = r9 | 6
            r44 = r40
            r40 = 0
            r45 = r2
            androidx.compose.runtime.Applier r2 = r4.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x03b1
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x03b1:
            r4.startReusableNode()
            boolean r2 = r4.getInserting()
            if (r2 == 0) goto L_0x03be
            r4.createNode(r14)
            goto L_0x03c1
        L_0x03be:
            r4.useNode()
        L_0x03c1:
            r4.disableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m2787constructorimpl(r4)
            r46 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r47 = androidx.compose.ui.node.ComposeUiNode.Companion
            r48 = r14
            kotlin.jvm.functions.Function2 r14 = r47.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r15, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r13, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r3, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r12, r14)
            r4.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r4)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r2)
            int r14 = r9 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r46 = r3
            r3 = r44
            r3.invoke(r2, r4, r14)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r4.startReplaceableGroup(r2)
            int r2 = r9 >> 9
            r2 = r2 & 14
            r14 = r4
            r44 = 0
            r47 = r3
            r3 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r14.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r3 = r2 & 11
            r49 = r2
            r2 = 2
            if (r3 != r2) goto L_0x0437
            boolean r2 = r14.getSkipping()
            if (r2 != 0) goto L_0x0431
            goto L_0x0437
        L_0x0431:
            r14.skipToGroupEnd()
            r53 = r9
            goto L_0x0478
        L_0x0437:
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r3 = r33 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r50 = r14
            r51 = 0
            r52 = r2
            r2 = 1990589600(0x76a5fca0, float:1.6833063E33)
            r53 = r9
            r9 = r50
            r9.startReplaceableGroup(r2)
            java.lang.String r2 = "C403@20246L9:TextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r2)
            r2 = r3 & 81
            r50 = r3
            r3 = 16
            if (r2 != r3) goto L_0x0469
            boolean r2 = r9.getSkipping()
            if (r2 != 0) goto L_0x0465
            goto L_0x0469
        L_0x0465:
            r9.skipToGroupEnd()
            goto L_0x0474
        L_0x0469:
            int r2 = r1 >> 12
            r2 = r2 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r11.invoke(r9, r2)
        L_0x0474:
            r9.endReplaceableGroup()
        L_0x0478:
            r14.endReplaceableGroup()
            r4.endReplaceableGroup()
            r4.endNode()
            r4.endReplaceableGroup()
            r4.endReplaceableGroup()
            goto L_0x0494
        L_0x048a:
            r45 = r2
            r43 = r3
            r31 = r13
            r35 = r14
            r38 = r15
        L_0x0494:
            r4.endReplaceableGroup()
            r2 = -95276839(0xfffffffffa5230d9, float:-2.7284327E35)
            r4.startReplaceableGroup(r2)
            java.lang.String r2 = "407@20340L271"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            if (r10 == 0) goto L_0x0639
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
            r4.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r7)
            r13 = 0
            int r14 = r9 >> 3
            r14 = r14 & 14
            int r15 = r9 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r14 = r14 | r15
            androidx.compose.ui.layout.MeasurePolicy r14 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r13, r4, r14)
            int r15 = r9 << 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            r33 = 0
            r34 = r3
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r4.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r6)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r36 = 6
            r37 = 0
            r39 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r12, r8)
            java.lang.Object r12 = r4.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r3 = r12
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r12 = (androidx.compose.runtime.CompositionLocal) r12
            r36 = 6
            r37 = 0
            r40 = r13
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r13, r8)
            java.lang.Object r13 = r4.consume(r12)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r12 = r13
            androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r36 = 6
            r37 = 0
            r41 = r6
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r6, r8)
            java.lang.Object r6 = r4.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.platform.ViewConfiguration r6 = (androidx.compose.ui.platform.ViewConfiguration) r6
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
            androidx.compose.runtime.Applier r15 = r4.getApplier()
            boolean r15 = r15 instanceof androidx.compose.runtime.Applier
            if (r15 != 0) goto L_0x0560
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0560:
            r4.startReusableNode()
            boolean r15 = r4.getInserting()
            if (r15 == 0) goto L_0x056d
            r4.createNode(r13)
            goto L_0x0570
        L_0x056d:
            r4.useNode()
        L_0x0570:
            r4.disableReusing()
            androidx.compose.runtime.Composer r15 = androidx.compose.runtime.Updater.m2787constructorimpl(r4)
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
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r15, r6, r13)
            r4.enableReusing()
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r4)
            androidx.compose.runtime.SkippableUpdater r13 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r13)
            int r15 = r2 >> 3
            r15 = r15 & 112(0x70, float:1.57E-43)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r46 = r3
            r3 = r42
            r3.invoke(r13, r4, r15)
            r13 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r4.startReplaceableGroup(r13)
            int r13 = r2 >> 9
            r13 = r13 & 14
            r15 = r4
            r42 = 0
            r47 = r2
            r2 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r15.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            r2 = r13 & 11
            r49 = r3
            r3 = 2
            if (r2 != r3) goto L_0x05e6
            boolean r2 = r15.getSkipping()
            if (r2 != 0) goto L_0x05e0
            goto L_0x05e6
        L_0x05e0:
            r15.skipToGroupEnd()
            r53 = r6
            goto L_0x0627
        L_0x05e6:
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r3 = r9 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r50 = r15
            r51 = 0
            r52 = r2
            r2 = -305264439(0xffffffffedce08c9, float:-7.9705666E27)
            r53 = r6
            r6 = r50
            r6.startReplaceableGroup(r2)
            java.lang.String r2 = "C413@20583L10:TextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r2)
            r2 = r3 & 81
            r50 = r3
            r3 = 16
            if (r2 != r3) goto L_0x0618
            boolean r2 = r6.getSkipping()
            if (r2 != 0) goto L_0x0614
            goto L_0x0618
        L_0x0614:
            r6.skipToGroupEnd()
            goto L_0x0623
        L_0x0618:
            int r2 = r1 >> 15
            r2 = r2 & 14
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r10.invoke(r6, r2)
        L_0x0623:
            r6.endReplaceableGroup()
        L_0x0627:
            r15.endReplaceableGroup()
            r4.endReplaceableGroup()
            r4.endNode()
            r4.endReplaceableGroup()
            r4.endReplaceableGroup()
            goto L_0x063b
        L_0x0639:
            r41 = r6
        L_0x063b:
            r4.endReplaceableGroup()
            r2 = r45
            float r3 = androidx.compose.foundation.layout.PaddingKt.calculateStartPadding(r5, r2)
            float r6 = androidx.compose.foundation.layout.PaddingKt.calculateEndPadding(r5, r2)
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            r44 = r9
            androidx.compose.ui.Modifier r44 = (androidx.compose.ui.Modifier) r44
            if (r11 == 0) goto L_0x066f
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
            goto L_0x0671
        L_0x066f:
            r45 = r3
        L_0x0671:
            r46 = 0
            if (r10 == 0) goto L_0x0694
            float r9 = androidx.compose.material3.TextFieldImplKt.getHorizontalIconPadding()
            r12 = 0
            float r13 = r6 - r9
            float r9 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r13)
            r12 = 0
            r13 = 0
            float r14 = (float) r12
            float r12 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r14)
            r13 = 0
            float r14 = kotlin.ranges.RangesKt.coerceAtLeast((float) r9, (float) r12)
            float r9 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r14)
            r47 = r9
            goto L_0x0696
        L_0x0694:
            r47 = r6
        L_0x0696:
            r48 = 0
            r49 = 10
            r50 = 0
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.PaddingKt.m764paddingqDBjuR0$default(r44, r45, r46, r47, r48, r49, r50)
            r12 = -95275778(0xfffffffffa5234fe, float:-2.7286429E35)
            r4.startReplaceableGroup(r12)
            java.lang.String r12 = "434@21404L130"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r12)
            r12 = r58
            if (r12 == 0) goto L_0x06c9
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r13 = (androidx.compose.ui.Modifier) r13
            java.lang.String r14 = "Hint"
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r13, r14)
            androidx.compose.ui.Modifier r13 = r13.then(r9)
            int r14 = r1 >> 6
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r12.invoke(r13, r4, r14)
        L_0x06c9:
            r4.endReplaceableGroup()
            r13 = -95275578(0xfffffffffa5235c6, float:-2.7286825E35)
            r4.startReplaceableGroup(r13)
            java.lang.String r13 = "440@21598L128"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r13)
            r13 = r57
            if (r13 == 0) goto L_0x0871
            androidx.compose.ui.Modifier$Companion r14 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r14 = (androidx.compose.ui.Modifier) r14
            java.lang.String r15 = "Label"
            androidx.compose.ui.Modifier r14 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r14, r15)
            androidx.compose.ui.Modifier r14 = r14.then(r9)
            r15 = 0
            r33 = 0
            r45 = r2
            r2 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r4.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r7)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getTopStart()
            r34 = r3
            r3 = 0
            int r36 = r15 >> 3
            r36 = r36 & 14
            int r37 = r15 >> 3
            r37 = r37 & 112(0x70, float:1.57E-43)
            r5 = r36 | r37
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r2, r3, r4, r5)
            int r36 = r15 << 3
            r36 = r36 & 112(0x70, float:1.57E-43)
            r37 = 0
            r39 = r2
            r2 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r4.startReplaceableGroup(r2)
            r2 = r41
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r40 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r41 = r3
            r3 = r40
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r40 = 6
            r42 = 0
            r44 = r6
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r6, r8)
            java.lang.Object r6 = r4.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r3 = r6
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r40 = 6
            r42 = 0
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r10, r8)
            java.lang.Object r10 = r4.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r6 = r10
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r40 = 6
            r42 = 0
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r11, r8)
            java.lang.Object r11 = r4.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r10 = r11
            androidx.compose.ui.platform.ViewConfiguration r10 = (androidx.compose.ui.platform.ViewConfiguration) r10
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r40 = androidx.compose.ui.layout.LayoutKt.materializerOf(r14)
            int r12 = r36 << 9
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r12 = r12 | 6
            r42 = r40
            r40 = 0
            r46 = r14
            androidx.compose.runtime.Applier r14 = r4.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x0799
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0799:
            r4.startReusableNode()
            boolean r14 = r4.getInserting()
            if (r14 == 0) goto L_0x07a6
            r4.createNode(r11)
            goto L_0x07a9
        L_0x07a6:
            r4.useNode()
        L_0x07a9:
            r4.disableReusing()
            androidx.compose.runtime.Composer r14 = androidx.compose.runtime.Updater.m2787constructorimpl(r4)
            r47 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r48 = androidx.compose.ui.node.ComposeUiNode.Companion
            r49 = r11
            kotlin.jvm.functions.Function2 r11 = r48.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r14, r5, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r14, r3, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r14, r6, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r14, r10, r11)
            r4.enableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r4)
            androidx.compose.runtime.SkippableUpdater r11 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r11)
            int r14 = r12 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r47 = r3
            r3 = r42
            r3.invoke(r11, r4, r14)
            r11 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r4.startReplaceableGroup(r11)
            int r11 = r12 >> 9
            r11 = r11 & 14
            r14 = r4
            r42 = 0
            r48 = r3
            r3 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r14.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
            r3 = r11 & 11
            r50 = r5
            r5 = 2
            if (r3 != r5) goto L_0x081f
            boolean r3 = r14.getSkipping()
            if (r3 != 0) goto L_0x0819
            goto L_0x081f
        L_0x0819:
            r14.skipToGroupEnd()
            r54 = r6
            goto L_0x085f
        L_0x081f:
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r5 = r15 >> 6
            r5 = r5 & 112(0x70, float:1.57E-43)
            r5 = r5 | 6
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            r51 = r14
            r52 = 0
            r53 = r3
            r3 = -2011394041(0xffffffff881c9007, float:-4.7113846E-34)
            r54 = r6
            r6 = r51
            r6.startReplaceableGroup(r3)
            java.lang.String r3 = "C443@21717L7:TextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r3)
            r3 = r5 & 81
            r51 = r5
            r5 = 16
            if (r3 != r5) goto L_0x0851
            boolean r3 = r6.getSkipping()
            if (r3 != 0) goto L_0x084d
            goto L_0x0851
        L_0x084d:
            r6.skipToGroupEnd()
            goto L_0x085c
        L_0x0851:
            int r3 = r1 >> 6
            r3 = r3 & 14
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r13.invoke(r6, r3)
        L_0x085c:
            r6.endReplaceableGroup()
        L_0x085f:
            r14.endReplaceableGroup()
            r4.endReplaceableGroup()
            r4.endNode()
            r4.endReplaceableGroup()
            r4.endReplaceableGroup()
            goto L_0x0879
        L_0x0871:
            r45 = r2
            r34 = r3
            r44 = r6
            r2 = r41
        L_0x0879:
            r4.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            java.lang.String r5 = "TextField"
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r3, r5)
            androidx.compose.ui.Modifier r3 = r3.then(r9)
            r5 = 384(0x180, float:5.38E-43)
            r6 = 1
            r10 = 0
            r11 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r4.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r7)
            androidx.compose.ui.Alignment$Companion r11 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r11 = r11.getTopStart()
            int r12 = r5 >> 3
            r12 = r12 & 14
            int r14 = r5 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            r12 = r12 | r14
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r11, r6, r4, r12)
            int r14 = r5 << 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            r15 = 0
            r33 = r6
            r6 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r4.startReplaceableGroup(r6)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r36 = 6
            r37 = 0
            r39 = r9
            r9 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r9, r8)
            java.lang.Object r9 = r4.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r6 = r9
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r36 = 6
            r37 = 0
            r40 = r10
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r10, r8)
            java.lang.Object r10 = r4.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r9 = r10
            androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r36 = 6
            r37 = 0
            r41 = r11
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r11, r8)
            java.lang.Object r11 = r4.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r10 = r11
            androidx.compose.ui.platform.ViewConfiguration r10 = (androidx.compose.ui.platform.ViewConfiguration) r10
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r36 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            r37 = r3
            int r3 = r14 << 9
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r3 = r3 | 6
            r42 = r36
            r36 = 0
            androidx.compose.runtime.Applier r13 = r4.getApplier()
            boolean r13 = r13 instanceof androidx.compose.runtime.Applier
            if (r13 != 0) goto L_0x0933
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0933:
            r4.startReusableNode()
            boolean r13 = r4.getInserting()
            if (r13 == 0) goto L_0x0940
            r4.createNode(r11)
            goto L_0x0943
        L_0x0940:
            r4.useNode()
        L_0x0943:
            r4.disableReusing()
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m2787constructorimpl(r4)
            r46 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r47 = androidx.compose.ui.node.ComposeUiNode.Companion
            r48 = r11
            kotlin.jvm.functions.Function2 r11 = r47.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r13, r12, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r13, r6, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r13, r9, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r13, r10, r11)
            r4.enableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r4)
            androidx.compose.runtime.SkippableUpdater r11 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r11)
            int r13 = r3 >> 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r46 = r6
            r6 = r42
            r6.invoke(r11, r4, r13)
            r11 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r4.startReplaceableGroup(r11)
            int r11 = r3 >> 9
            r11 = r11 & 14
            r13 = r4
            r42 = 0
            r47 = r3
            r3 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r13.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r0)
            r3 = r11 & 11
            r49 = r6
            r6 = 2
            if (r3 != r6) goto L_0x09bb
            boolean r3 = r13.getSkipping()
            if (r3 != 0) goto L_0x09b3
            goto L_0x09bb
        L_0x09b3:
            r13.skipToGroupEnd()
            r6 = r56
            r53 = r5
            goto L_0x0a00
        L_0x09bb:
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r6 = r5 >> 6
            r6 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 | 6
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            r50 = r13
            r51 = 0
            r52 = r3
            r3 = -369728037(0xffffffffe9f665db, float:-3.7234594E25)
            r53 = r5
            r5 = r50
            r5.startReplaceableGroup(r3)
            java.lang.String r3 = "C451@21953L11:TextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r3)
            r3 = r6 & 81
            r50 = r6
            r6 = 16
            if (r3 != r6) goto L_0x09ef
            boolean r3 = r5.getSkipping()
            if (r3 != 0) goto L_0x09e9
            goto L_0x09ef
        L_0x09e9:
            r5.skipToGroupEnd()
            r6 = r56
            goto L_0x09fc
        L_0x09ef:
            int r3 = r1 >> 3
            r3 = r3 & 14
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r6 = r56
            r6.invoke(r5, r3)
        L_0x09fc:
            r5.endReplaceableGroup()
        L_0x0a00:
            r13.endReplaceableGroup()
            r4.endReplaceableGroup()
            r4.endNode()
            r4.endReplaceableGroup()
            r4.endReplaceableGroup()
            r9 = r64
            if (r9 == 0) goto L_0x0ba6
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            java.lang.String r5 = "Supporting"
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r3, r5)
            androidx.compose.material3.TextFieldDefaults r46 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 15
            r52 = 0
            androidx.compose.foundation.layout.PaddingValues r5 = androidx.compose.material3.TextFieldDefaults.m2145supportingTextPaddinga9UjIt4$material3_release$default(r46, r47, r48, r49, r50, r51, r52)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.padding(r3, r5)
            r5 = 0
            r10 = 0
            r11 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r4.startReplaceableGroup(r11)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r7)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r7.getTopStart()
            r11 = 0
            int r12 = r5 >> 3
            r12 = r12 & 14
            int r13 = r5 >> 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r12 = r12 | r13
            androidx.compose.ui.layout.MeasurePolicy r12 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r7, r11, r4, r12)
            int r13 = r5 << 3
            r13 = r13 & 112(0x70, float:1.57E-43)
            r14 = 0
            r15 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r4.startReplaceableGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r15 = 6
            r20 = 0
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r6, r8)
            java.lang.Object r6 = r4.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r2 = r6
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r15 = 6
            r20 = 0
            r32 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r7, r8)
            java.lang.Object r7 = r4.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r6 = r7
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r15 = 6
            r20 = 0
            r33 = r10
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r10, r8)
            java.lang.Object r8 = r4.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r7 = r8
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
            kotlin.jvm.functions.Function3 r10 = androidx.compose.ui.layout.LayoutKt.materializerOf(r3)
            int r15 = r13 << 9
            r15 = r15 & 7168(0x1c00, float:1.0045E-41)
            r15 = r15 | 6
            r19 = 0
            r20 = r3
            androidx.compose.runtime.Applier r3 = r4.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x0ad4
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0ad4:
            r4.startReusableNode()
            boolean r3 = r4.getInserting()
            if (r3 == 0) goto L_0x0ae1
            r4.createNode(r8)
            goto L_0x0ae4
        L_0x0ae1:
            r4.useNode()
        L_0x0ae4:
            r4.disableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m2787constructorimpl(r4)
            r36 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r37 = androidx.compose.ui.node.ComposeUiNode.Companion
            r40 = r8
            kotlin.jvm.functions.Function2 r8 = r37.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r12, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r2, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r6, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r7, r8)
            r4.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r4)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r3)
            int r8 = r15 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r10.invoke(r3, r4, r8)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r4.startReplaceableGroup(r3)
            int r3 = r15 >> 9
            r3 = r3 & 14
            r8 = r4
            r26 = 0
            r36 = r2
            r2 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r8.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
            r0 = r3 & 11
            r2 = 2
            if (r0 != r2) goto L_0x0b54
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x0b4e
            goto L_0x0b54
        L_0x0b4e:
            r8.skipToGroupEnd()
            r41 = r3
            goto L_0x0b94
        L_0x0b54:
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r2 = r5 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r2 = r2 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r66 = r8
            r29 = 0
            r37 = r0
            r0 = -716975194(0xffffffffd543d3a6, float:-1.34571119E13)
            r41 = r3
            r3 = r66
            r3.startReplaceableGroup(r0)
            java.lang.String r0 = "C458@22183L12:TextField.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
            r0 = r2 & 81
            r66 = r2
            r2 = 16
            if (r0 != r2) goto L_0x0b86
            boolean r0 = r3.getSkipping()
            if (r0 != 0) goto L_0x0b82
            goto L_0x0b86
        L_0x0b82:
            r3.skipToGroupEnd()
            goto L_0x0b91
        L_0x0b86:
            int r0 = r1 >> 27
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r9.invoke(r3, r0)
        L_0x0b91:
            r3.endReplaceableGroup()
        L_0x0b94:
            r8.endReplaceableGroup()
            r4.endReplaceableGroup()
            r4.endNode()
            r4.endReplaceableGroup()
            r4.endReplaceableGroup()
        L_0x0ba6:
            r4.endReplaceableGroup()
            r43.endReplaceableGroup()
            r43.endNode()
            r43.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0bbe
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0bbe:
            androidx.compose.runtime.ScopeUpdateScope r14 = r43.endRestartGroup()
            if (r14 != 0) goto L_0x0bcb
            r16 = r1
            r17 = r18
            r18 = r43
            goto L_0x0bf6
        L_0x0bcb:
            androidx.compose.material3.TextFieldKt$TextFieldLayout$2 r15 = new androidx.compose.material3.TextFieldKt$TextFieldLayout$2
            r0 = r15
            r16 = r1
            r1 = r55
            r17 = r18
            r2 = r56
            r18 = r43
            r3 = r57
            r4 = r58
            r5 = r59
            r6 = r60
            r7 = r61
            r8 = r62
            r9 = r63
            r10 = r64
            r11 = r65
            r12 = r67
            r13 = r68
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r14.updateScope(r15)
        L_0x0bf6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldKt.TextFieldLayout(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, float, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateWidth-VsPV1Ek  reason: not valid java name */
    public static final int m2170calculateWidthVsPV1Ek(int leadingWidth, int trailingWidth, int textFieldWidth, int labelWidth, int placeholderWidth, long constraints) {
        return Math.max(leadingWidth + Math.max(textFieldWidth, Math.max(labelWidth, placeholderWidth)) + trailingWidth, Constraints.m5932getMinWidthimpl(constraints));
    }

    /* access modifiers changed from: private */
    /* renamed from: calculateHeight-jCXOeKk  reason: not valid java name */
    public static final int m2169calculateHeightjCXOeKk(int textFieldHeight, boolean hasLabel, int labelBaseline, int leadingHeight, int trailingHeight, int placeholderHeight, int supportingHeight, long constraints, float density, PaddingValues paddingValues) {
        float middleSectionHeight;
        float paddingToLabel = TextFieldTopPadding * density;
        float topPaddingValue = paddingValues.m773calculateTopPaddingD9Ej5fM() * density;
        float bottomPaddingValue = paddingValues.m770calculateBottomPaddingD9Ej5fM() * density;
        int i = textFieldHeight;
        int inputFieldHeight = Math.max(textFieldHeight, placeholderHeight);
        if (hasLabel) {
            middleSectionHeight = ((float) labelBaseline) + paddingToLabel + ((float) inputFieldHeight) + bottomPaddingValue;
        } else {
            int i2 = labelBaseline;
            middleSectionHeight = ((float) inputFieldHeight) + topPaddingValue + bottomPaddingValue;
        }
        int i3 = leadingHeight;
        return Math.max(Constraints.m5931getMinHeightimpl(constraints), Math.max(leadingHeight, Math.max(trailingHeight, MathKt.roundToInt(middleSectionHeight))) + supportingHeight);
    }

    /* access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope $this$placeWithLabel, int width, int totalHeight, Placeable textfieldPlaceable, Placeable labelPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, boolean singleLine, int labelEndPosition, int textPosition, float animationProgress, float density) {
        int i;
        Placeable.PlacementScope.m4903place70tqf50$default($this$placeWithLabel, containerPlaceable, IntOffset.Companion.m6114getZeronOccac(), 0.0f, 2, (Object) null);
        int height = totalHeight - TextFieldImplKt.heightOrZero(supportingPlaceable);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, (Object) null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.Companion.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, (Object) null);
        }
        if (labelPlaceable != null) {
            Placeable it = labelPlaceable;
            if (singleLine) {
                i = Alignment.Companion.getCenterVertically().align(it.getHeight(), height);
            } else {
                i = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * density);
            }
            int startPosition = i;
            Placeable.PlacementScope placementScope = $this$placeWithLabel;
            Placeable.PlacementScope.placeRelative$default(placementScope, it, TextFieldImplKt.widthOrZero(leadingPlaceable), startPosition - MathKt.roundToInt(((float) (startPosition - labelEndPosition)) * animationProgress), 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, textfieldPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0.0f, 4, (Object) null);
        if (placeholderPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, placeholderPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textPosition, 0.0f, 4, (Object) null);
        }
        if (supportingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithLabel, supportingPlaceable, 0, height, 0.0f, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope $this$placeWithoutLabel, int width, int totalHeight, Placeable textPlaceable, Placeable placeholderPlaceable, Placeable leadingPlaceable, Placeable trailingPlaceable, Placeable containerPlaceable, Placeable supportingPlaceable, boolean singleLine, float density, PaddingValues paddingValues) {
        int textVerticalPosition;
        int placeholderVerticalPosition;
        Placeable.PlacementScope.m4903place70tqf50$default($this$placeWithoutLabel, containerPlaceable, IntOffset.Companion.m6114getZeronOccac(), 0.0f, 2, (Object) null);
        int height = totalHeight - TextFieldImplKt.heightOrZero(supportingPlaceable);
        int topPadding = MathKt.roundToInt(paddingValues.m773calculateTopPaddingD9Ej5fM() * density);
        if (leadingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, leadingPlaceable, 0, Alignment.Companion.getCenterVertically().align(leadingPlaceable.getHeight(), height), 0.0f, 4, (Object) null);
        }
        if (trailingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, trailingPlaceable, width - trailingPlaceable.getWidth(), Alignment.Companion.getCenterVertically().align(trailingPlaceable.getHeight(), height), 0.0f, 4, (Object) null);
        }
        if (singleLine) {
            textVerticalPosition = Alignment.Companion.getCenterVertically().align(textPlaceable.getHeight(), height);
        } else {
            textVerticalPosition = topPadding;
        }
        Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, textPlaceable, TextFieldImplKt.widthOrZero(leadingPlaceable), textVerticalPosition, 0.0f, 4, (Object) null);
        if (placeholderPlaceable != null) {
            Placeable it = placeholderPlaceable;
            if (singleLine) {
                placeholderVerticalPosition = Alignment.Companion.getCenterVertically().align(placeholderPlaceable.getHeight(), height);
            } else {
                placeholderVerticalPosition = topPadding;
            }
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, it, TextFieldImplKt.widthOrZero(leadingPlaceable), placeholderVerticalPosition, 0.0f, 4, (Object) null);
        }
        if (supportingPlaceable != null) {
            Placeable.PlacementScope.placeRelative$default($this$placeWithoutLabel, supportingPlaceable, 0, height, 0.0f, 4, (Object) null);
        }
    }

    public static final Modifier drawIndicatorLine(Modifier $this$drawIndicatorLine, BorderStroke indicatorBorder) {
        Intrinsics.checkNotNullParameter($this$drawIndicatorLine, "<this>");
        Intrinsics.checkNotNullParameter(indicatorBorder, "indicatorBorder");
        return DrawModifierKt.drawWithContent($this$drawIndicatorLine, new TextFieldKt$drawIndicatorLine$1(indicatorBorder.m467getWidthD9Ej5fM(), indicatorBorder));
    }

    public static final float getFirstBaselineOffset() {
        return FirstBaselineOffset;
    }

    public static final float getTextFieldBottomPadding() {
        return TextFieldBottomPadding;
    }

    public static final float getTextFieldTopPadding() {
        return TextFieldTopPadding;
    }
}
