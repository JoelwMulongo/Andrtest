package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010\"\u001aì\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010$\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020%2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010&\u001aì\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020%2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b23\b\u0002\u0010\u001c\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001eH\u0007¢\u0006\u0002\u0010'¨\u0006("}, d2 = {"BasicTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "innerTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField.kt */
public final class BasicTextFieldKt {
    /* JADX WARNING: Removed duplicated region for block: B:253:0x04a3  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x04b5  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x04d9  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x04dc  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x04e0  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x04e3  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x051d  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x052e  */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x05aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTextField(java.lang.String r40, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r41, androidx.compose.ui.Modifier r42, boolean r43, boolean r44, androidx.compose.ui.text.TextStyle r45, androidx.compose.foundation.text.KeyboardOptions r46, androidx.compose.foundation.text.KeyboardActions r47, boolean r48, int r49, int r50, androidx.compose.ui.text.input.VisualTransformation r51, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r52, androidx.compose.foundation.interaction.MutableInteractionSource r53, androidx.compose.ui.graphics.Brush r54, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, androidx.compose.runtime.Composer r56, int r57, int r58, int r59) {
        /*
            r15 = r40
            r14 = r41
            r13 = r57
            r12 = r58
            r11 = r59
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 945255183(0x3857730f, float:5.136715E-5)
            r1 = r56
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BasicTextField)P(14,10,8,2,11,13,5,4,12,6,7,15,9,3)136@7932L39,143@8326L57,149@8679L216,149@8668L227,158@9216L41,162@9334L373,160@9263L1032:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r57
            r2 = r58
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
            boolean r3 = r10.changedInstance(r14)
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
            r4 = r42
            goto L_0x0073
        L_0x005d:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0071
            r4 = r42
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
            r4 = r42
        L_0x0073:
            r16 = r11 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0080
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r6 = r43
            goto L_0x0096
        L_0x0080:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0094
            r6 = r43
            boolean r20 = r10.changed((boolean) r6)
            if (r20 == 0) goto L_0x008f
            r20 = r17
            goto L_0x0091
        L_0x008f:
            r20 = r18
        L_0x0091:
            r1 = r1 | r20
            goto L_0x0096
        L_0x0094:
            r6 = r43
        L_0x0096:
            r20 = r11 & 16
            r21 = 16384(0x4000, float:2.2959E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            r23 = 57344(0xe000, float:8.0356E-41)
            if (r20 == 0) goto L_0x00a6
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r7 = r44
            goto L_0x00bc
        L_0x00a6:
            r24 = r13 & r23
            if (r24 != 0) goto L_0x00ba
            r7 = r44
            boolean r25 = r10.changed((boolean) r7)
            if (r25 == 0) goto L_0x00b5
            r25 = r21
            goto L_0x00b7
        L_0x00b5:
            r25 = r22
        L_0x00b7:
            r1 = r1 | r25
            goto L_0x00bc
        L_0x00ba:
            r7 = r44
        L_0x00bc:
            r25 = r11 & 32
            r26 = 458752(0x70000, float:6.42848E-40)
            if (r25 == 0) goto L_0x00c9
            r27 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r27
            r8 = r45
            goto L_0x00df
        L_0x00c9:
            r27 = r13 & r26
            if (r27 != 0) goto L_0x00dd
            r8 = r45
            boolean r28 = r10.changed((java.lang.Object) r8)
            if (r28 == 0) goto L_0x00d8
            r28 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00da
        L_0x00d8:
            r28 = 65536(0x10000, float:9.18355E-41)
        L_0x00da:
            r1 = r1 | r28
            goto L_0x00df
        L_0x00dd:
            r8 = r45
        L_0x00df:
            r28 = r11 & 64
            if (r28 == 0) goto L_0x00ea
            r29 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r29
            r9 = r46
            goto L_0x0102
        L_0x00ea:
            r29 = 3670016(0x380000, float:5.142788E-39)
            r29 = r13 & r29
            if (r29 != 0) goto L_0x0100
            r9 = r46
            boolean r30 = r10.changed((java.lang.Object) r9)
            if (r30 == 0) goto L_0x00fb
            r30 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fd
        L_0x00fb:
            r30 = 524288(0x80000, float:7.34684E-40)
        L_0x00fd:
            r1 = r1 | r30
            goto L_0x0102
        L_0x0100:
            r9 = r46
        L_0x0102:
            r5 = r11 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x010d
            r31 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r31
            r0 = r47
            goto L_0x0125
        L_0x010d:
            r31 = 29360128(0x1c00000, float:7.052966E-38)
            r31 = r13 & r31
            if (r31 != 0) goto L_0x0123
            r0 = r47
            boolean r32 = r10.changed((java.lang.Object) r0)
            if (r32 == 0) goto L_0x011e
            r32 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0120
        L_0x011e:
            r32 = 4194304(0x400000, float:5.877472E-39)
        L_0x0120:
            r1 = r1 | r32
            goto L_0x0125
        L_0x0123:
            r0 = r47
        L_0x0125:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0130
            r32 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r32
            r4 = r48
            goto L_0x0148
        L_0x0130:
            r32 = 234881024(0xe000000, float:1.5777218E-30)
            r32 = r13 & r32
            if (r32 != 0) goto L_0x0146
            r4 = r48
            boolean r32 = r10.changed((boolean) r4)
            if (r32 == 0) goto L_0x0141
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0143
        L_0x0141:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0143:
            r1 = r1 | r32
            goto L_0x0148
        L_0x0146:
            r4 = r48
        L_0x0148:
            r32 = 1879048192(0x70000000, float:1.58456325E29)
            r32 = r13 & r32
            if (r32 != 0) goto L_0x0164
            r4 = r11 & 512(0x200, float:7.175E-43)
            if (r4 != 0) goto L_0x015d
            r4 = r49
            boolean r32 = r10.changed((int) r4)
            if (r32 == 0) goto L_0x015f
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0161
        L_0x015d:
            r4 = r49
        L_0x015f:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0161:
            r1 = r1 | r32
            goto L_0x0166
        L_0x0164:
            r4 = r49
        L_0x0166:
            r4 = r11 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x016f
            r2 = r2 | 6
            r6 = r50
            goto L_0x0185
        L_0x016f:
            r32 = r12 & 14
            if (r32 != 0) goto L_0x0183
            r6 = r50
            boolean r32 = r10.changed((int) r6)
            if (r32 == 0) goto L_0x017e
            r32 = 4
            goto L_0x0180
        L_0x017e:
            r32 = 2
        L_0x0180:
            r2 = r2 | r32
            goto L_0x0185
        L_0x0183:
            r6 = r50
        L_0x0185:
            r6 = r11 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x018e
            r2 = r2 | 48
            r7 = r51
            goto L_0x01a4
        L_0x018e:
            r32 = r12 & 112(0x70, float:1.57E-43)
            if (r32 != 0) goto L_0x01a2
            r7 = r51
            boolean r32 = r10.changed((java.lang.Object) r7)
            if (r32 == 0) goto L_0x019d
            r19 = 32
            goto L_0x019f
        L_0x019d:
            r19 = 16
        L_0x019f:
            r2 = r2 | r19
            goto L_0x01a4
        L_0x01a2:
            r7 = r51
        L_0x01a4:
            r7 = r11 & 4096(0x1000, float:5.74E-42)
            if (r7 == 0) goto L_0x01ad
            r2 = r2 | 384(0x180, float:5.38E-43)
            r8 = r52
            goto L_0x01c3
        L_0x01ad:
            r8 = r12 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x01c1
            r8 = r52
            boolean r19 = r10.changedInstance(r8)
            if (r19 == 0) goto L_0x01bc
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x01be
        L_0x01bc:
            r29 = 128(0x80, float:1.794E-43)
        L_0x01be:
            r2 = r2 | r29
            goto L_0x01c3
        L_0x01c1:
            r8 = r52
        L_0x01c3:
            r8 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r8 == 0) goto L_0x01cc
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r9 = r53
            goto L_0x01e0
        L_0x01cc:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x01de
            r9 = r53
            boolean r19 = r10.changed((java.lang.Object) r9)
            if (r19 == 0) goto L_0x01d9
            goto L_0x01db
        L_0x01d9:
            r17 = r18
        L_0x01db:
            r2 = r2 | r17
            goto L_0x01e0
        L_0x01de:
            r9 = r53
        L_0x01e0:
            r9 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x01e9
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r14 = r54
            goto L_0x01fd
        L_0x01e9:
            r17 = r12 & r23
            if (r17 != 0) goto L_0x01fb
            r14 = r54
            boolean r17 = r10.changed((java.lang.Object) r14)
            if (r17 == 0) goto L_0x01f6
            goto L_0x01f8
        L_0x01f6:
            r21 = r22
        L_0x01f8:
            r2 = r2 | r21
            goto L_0x01fd
        L_0x01fb:
            r14 = r54
        L_0x01fd:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r11 & r17
            if (r17 == 0) goto L_0x020b
            r18 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r18
            r12 = r55
            goto L_0x0221
        L_0x020b:
            r18 = r12 & r26
            if (r18 != 0) goto L_0x021f
            r12 = r55
            boolean r18 = r10.changedInstance(r12)
            if (r18 == 0) goto L_0x021a
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x021c
        L_0x021a:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x021c:
            r2 = r2 | r18
            goto L_0x0221
        L_0x021f:
            r12 = r55
        L_0x0221:
            r18 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r1 & r18
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r14) goto L_0x0260
            r12 = 374491(0x5b6db, float:5.24774E-40)
            r12 = r12 & r2
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r12 != r14) goto L_0x0260
            boolean r12 = r10.getSkipping()
            if (r12 != 0) goto L_0x023b
            goto L_0x0260
        L_0x023b:
            r10.skipToGroupEnd()
            r15 = r41
            r20 = r42
            r21 = r43
            r22 = r44
            r23 = r45
            r24 = r46
            r25 = r47
            r26 = r48
            r27 = r49
            r28 = r50
            r29 = r51
            r30 = r52
            r36 = r53
            r37 = r54
            r38 = r55
            r31 = r1
            goto L_0x05c5
        L_0x0260:
            r10.startDefaults()
            r12 = r13 & 1
            r18 = 1
            if (r12 == 0) goto L_0x029a
            boolean r12 = r10.getDefaultsInvalid()
            if (r12 == 0) goto L_0x0270
            goto L_0x029a
        L_0x0270:
            r10.skipToGroupEnd()
            r0 = r11 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x027b
            r0 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r0
        L_0x027b:
            r3 = r42
            r12 = r43
            r0 = r44
            r4 = r46
            r5 = r47
            r6 = r48
            r14 = r49
            r49 = r50
            r8 = r51
            r9 = r52
            r36 = r53
            r37 = r54
            r38 = r55
            r7 = r1
            r1 = r45
            goto L_0x039b
        L_0x029a:
            if (r3 == 0) goto L_0x02a1
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x02a3
        L_0x02a1:
            r3 = r42
        L_0x02a3:
            if (r16 == 0) goto L_0x02a7
            r12 = 1
            goto L_0x02a9
        L_0x02a7:
            r12 = r43
        L_0x02a9:
            if (r20 == 0) goto L_0x02ae
            r16 = 0
            goto L_0x02b0
        L_0x02ae:
            r16 = r44
        L_0x02b0:
            if (r25 == 0) goto L_0x02b9
            androidx.compose.ui.text.TextStyle$Companion r19 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r19 = r19.getDefault()
            goto L_0x02bb
        L_0x02b9:
            r19 = r45
        L_0x02bb:
            if (r28 == 0) goto L_0x02c4
            androidx.compose.foundation.text.KeyboardOptions$Companion r20 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r20 = r20.getDefault()
            goto L_0x02c6
        L_0x02c4:
            r20 = r46
        L_0x02c6:
            if (r5 == 0) goto L_0x02cf
            androidx.compose.foundation.text.KeyboardActions$Companion r5 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r5 = r5.getDefault()
            goto L_0x02d1
        L_0x02cf:
            r5 = r47
        L_0x02d1:
            if (r0 == 0) goto L_0x02d5
            r0 = 0
            goto L_0x02d7
        L_0x02d5:
            r0 = r48
        L_0x02d7:
            r14 = r11 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x02e9
            if (r0 == 0) goto L_0x02e0
            r14 = r18
            goto L_0x02e3
        L_0x02e0:
            r14 = 2147483647(0x7fffffff, float:NaN)
        L_0x02e3:
            r21 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r21
            goto L_0x02eb
        L_0x02e9:
            r14 = r49
        L_0x02eb:
            if (r4 == 0) goto L_0x02ef
            r4 = 1
            goto L_0x02f1
        L_0x02ef:
            r4 = r50
        L_0x02f1:
            if (r6 == 0) goto L_0x02fa
            androidx.compose.ui.text.input.VisualTransformation$Companion r6 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r6 = r6.getNone()
            goto L_0x02fc
        L_0x02fa:
            r6 = r51
        L_0x02fc:
            if (r7 == 0) goto L_0x0303
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$1 r7 = androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$1.INSTANCE
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            goto L_0x0305
        L_0x0303:
            r7 = r52
        L_0x0305:
            if (r8 == 0) goto L_0x034c
            r8 = 0
            r21 = 0
            r42 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = 0
            r43 = r10
            r22 = 0
            r44 = r0
            java.lang.Object r0 = r43.rememberedValue()
            r24 = 0
            androidx.compose.runtime.Composer$Companion r25 = androidx.compose.runtime.Composer.Companion
            r45 = r1
            java.lang.Object r1 = r25.getEmpty()
            if (r0 != r1) goto L_0x033d
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r46 = r0
            r0 = r43
            r0.updateRememberedValue(r1)
            goto L_0x0343
        L_0x033d:
            r46 = r0
            r0 = r43
            r1 = r46
        L_0x0343:
            r10.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x0352
        L_0x034c:
            r42 = r0
            r45 = r1
            r0 = r53
        L_0x0352:
            if (r9 == 0) goto L_0x0366
            androidx.compose.ui.graphics.SolidColor r1 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r8 = androidx.compose.ui.graphics.Color.Companion
            long r8 = r8.m3190getBlack0d7_KjU()
            r43 = r0
            r0 = 0
            r1.<init>(r8, r0)
            r0 = r1
            androidx.compose.ui.graphics.Brush r0 = (androidx.compose.ui.graphics.Brush) r0
            goto L_0x036a
        L_0x0366:
            r43 = r0
            r0 = r54
        L_0x036a:
            if (r17 == 0) goto L_0x0387
            androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt r1 = androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r1 = r1.m1132getLambda1$foundation_release()
            r36 = r43
            r37 = r0
            r38 = r1
            r49 = r4
            r8 = r6
            r9 = r7
            r0 = r16
            r1 = r19
            r4 = r20
            r6 = r42
            r7 = r45
            goto L_0x039b
        L_0x0387:
            r36 = r43
            r38 = r55
            r37 = r0
            r49 = r4
            r8 = r6
            r9 = r7
            r0 = r16
            r1 = r19
            r4 = r20
            r6 = r42
            r7 = r45
        L_0x039b:
            r10.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x03ac
            java.lang.String r11 = "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:122)"
            r13 = 945255183(0x3857730f, float:5.136715E-5)
            androidx.compose.runtime.ComposerKt.traceEventStart(r13, r7, r2, r11)
        L_0x03ac:
            r11 = 0
            r13 = 0
            r50 = r11
            r11 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r11)
            java.lang.String r11 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r11)
            r11 = 0
            r51 = r10
            r16 = 0
            r52 = r11
            java.lang.Object r11 = r51.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r53 = r13
            java.lang.Object r13 = r19.getEmpty()
            if (r11 != r13) goto L_0x0401
            r13 = 0
            r54 = r11
            androidx.compose.ui.text.input.TextFieldValue r11 = new androidx.compose.ui.text.input.TextFieldValue
            r19 = 0
            r21 = 0
            r22 = 6
            r24 = 0
            r42 = r11
            r43 = r40
            r44 = r19
            r46 = r21
            r47 = r22
            r48 = r24
            r42.<init>((java.lang.String) r43, (long) r44, (androidx.compose.ui.text.TextRange) r46, (int) r47, (kotlin.jvm.internal.DefaultConstructorMarker) r48)
            r42 = r13
            r55 = r14
            r13 = 0
            r14 = 2
            androidx.compose.runtime.MutableState r11 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r11, r13, r14, r13)
            r13 = r51
            r13.updateRememberedValue(r11)
            goto L_0x0407
        L_0x0401:
            r13 = r51
            r54 = r11
            r55 = r14
        L_0x0407:
            r10.endReplaceableGroup()
            androidx.compose.runtime.MutableState r11 = (androidx.compose.runtime.MutableState) r11
            androidx.compose.ui.text.input.TextFieldValue r13 = BasicTextField$lambda$2(r11)
            r16 = 0
            r14 = 0
            r19 = 6
            r20 = 0
            r42 = r13
            r43 = r40
            r44 = r16
            r46 = r14
            r47 = r19
            r48 = r20
            androidx.compose.ui.text.input.TextFieldValue r13 = androidx.compose.ui.text.input.TextFieldValue.m5691copy3r_uNRQ$default((androidx.compose.ui.text.input.TextFieldValue) r42, (java.lang.String) r43, (long) r44, (androidx.compose.ui.text.TextRange) r46, (int) r47, (java.lang.Object) r48)
            r14 = 48
            r16 = 0
            r42 = r14
            r14 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r10.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r14)
            boolean r14 = r10.changed((java.lang.Object) r13)
            boolean r17 = r10.changed((java.lang.Object) r11)
            r14 = r14 | r17
            r43 = r10
            r17 = 0
            r44 = r0
            java.lang.Object r0 = r43.rememberedValue()
            r19 = 0
            if (r14 != 0) goto L_0x0462
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r45 = r14
            java.lang.Object r14 = r20.getEmpty()
            if (r0 != r14) goto L_0x045d
            goto L_0x0464
        L_0x045d:
            r14 = r43
            r46 = r0
            goto L_0x0475
        L_0x0462:
            r45 = r14
        L_0x0464:
            r14 = 0
            r46 = r0
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1 r0 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$3$1
            r0.<init>(r13, r11)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r14 = r43
            r14.updateRememberedValue(r0)
        L_0x0475:
            r10.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r14 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r10, r14)
            r0 = r7 & 14
            r14 = 0
            r42 = r0
            r0 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            boolean r0 = r10.changed((java.lang.Object) r15)
            r43 = r10
            r16 = 0
            r45 = r14
            java.lang.Object r14 = r43.rememberedValue()
            r17 = 0
            if (r0 != 0) goto L_0x04b5
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r46 = r0
            java.lang.Object r0 = r19.getEmpty()
            if (r14 != r0) goto L_0x04ae
            goto L_0x04b7
        L_0x04ae:
            r48 = r14
            r0 = r48
            r14 = r43
            goto L_0x04c9
        L_0x04b5:
            r46 = r0
        L_0x04b7:
            r0 = 0
            r47 = r0
            r48 = r14
            r0 = 0
            r14 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r15, r0, r14, r0)
            r14 = r43
            r14.updateRememberedValue(r0)
        L_0x04c9:
            r10.endReplaceableGroup()
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            androidx.compose.ui.text.input.ImeOptions r27 = r4.toImeOptions$foundation_release(r6)
            r24 = r6 ^ 1
            if (r6 == 0) goto L_0x04dc
            r14 = r18
            goto L_0x04de
        L_0x04dc:
            r14 = r49
        L_0x04de:
            if (r6 == 0) goto L_0x04e3
            r25 = r18
            goto L_0x04e5
        L_0x04e3:
            r25 = r55
        L_0x04e5:
            r42 = r4
            int r4 = r7 << 3
            r4 = r4 & 896(0x380, float:1.256E-42)
            r4 = r4 | 6
            r16 = 0
            r43 = r4
            r4 = 1618982084(0x607fb4c4, float:7.370227E19)
            r10.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r4)
            boolean r4 = r10.changed((java.lang.Object) r11)
            boolean r17 = r10.changed((java.lang.Object) r0)
            r4 = r4 | r17
            r15 = r41
            boolean r17 = r10.changed((java.lang.Object) r15)
            r4 = r4 | r17
            r45 = r10
            r17 = 0
            r46 = r6
            java.lang.Object r6 = r45.rememberedValue()
            r18 = 0
            if (r4 != 0) goto L_0x052e
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r47 = r4
            java.lang.Object r4 = r19.getEmpty()
            if (r6 != r4) goto L_0x0528
            goto L_0x0530
        L_0x0528:
            r48 = r0
            r4 = r6
            r0 = r45
            goto L_0x0543
        L_0x052e:
            r47 = r4
        L_0x0530:
            r4 = 0
            r48 = r4
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1 r4 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
            r4.<init>(r15, r11, r0)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r48 = r0
            r0 = r45
            r0.updateRememberedValue(r4)
        L_0x0543:
            r10.endReplaceableGroup()
            r17 = r4
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            r0 = r7 & 896(0x380, float:1.256E-42)
            int r4 = r7 >> 6
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r4
            int r4 = r2 << 9
            r4 = r4 & r23
            r0 = r0 | r4
            int r4 = r2 << 9
            r4 = r4 & r26
            r0 = r0 | r4
            int r4 = r2 << 9
            r6 = 3670016(0x380000, float:5.142788E-39)
            r4 = r4 & r6
            r0 = r0 | r4
            r4 = 29360128(0x1c00000, float:7.052966E-38)
            int r6 = r2 << 9
            r4 = r4 & r6
            r33 = r0 | r4
            int r0 = r7 >> 15
            r0 = r0 & 896(0x380, float:1.256E-42)
            r4 = r7 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r4
            r4 = r7 & r23
            r0 = r0 | r4
            r4 = r2 & r26
            r34 = r0 | r4
            r35 = 0
            r16 = r13
            r18 = r3
            r19 = r1
            r20 = r8
            r21 = r9
            r22 = r36
            r23 = r37
            r26 = r14
            r28 = r5
            r29 = r12
            r30 = r44
            r31 = r38
            r32 = r10
            androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x05ad
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x05ad:
            r24 = r42
            r22 = r44
            r26 = r46
            r28 = r49
            r27 = r55
            r23 = r1
            r20 = r3
            r25 = r5
            r31 = r7
            r29 = r8
            r30 = r9
            r21 = r12
        L_0x05c5:
            androidx.compose.runtime.ScopeUpdateScope r14 = r10.endRestartGroup()
            if (r14 != 0) goto L_0x05d0
            r33 = r2
            r34 = r10
            goto L_0x060d
        L_0x05d0:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$5 r32 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$5
            r0 = r32
            r1 = r40
            r33 = r2
            r2 = r41
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r34 = r10
            r10 = r27
            r11 = r28
            r12 = r29
            r13 = r30
            r15 = r14
            r14 = r36
            r39 = r15
            r15 = r37
            r16 = r38
            r17 = r57
            r18 = r58
            r19 = r59
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r32
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r39
            r1.updateScope(r0)
        L_0x060d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final TextFieldValue BasicTextField$lambda$2(MutableState<TextFieldValue> $textFieldValueState$delegate) {
        return (TextFieldValue) $textFieldValueState$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final void BasicTextField$lambda$3(MutableState<TextFieldValue> $textFieldValueState$delegate, TextFieldValue value) {
        $textFieldValueState$delegate.setValue(value);
    }

    /* access modifiers changed from: private */
    public static final String BasicTextField$lambda$6(MutableState<String> $lastTextValue$delegate) {
        return (String) $lastTextValue$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final void BasicTextField$lambda$7(MutableState<String> $lastTextValue$delegate, String value) {
        $lastTextValue$delegate.setValue(value);
    }

    /* JADX WARNING: Removed duplicated region for block: B:256:0x04b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void BasicTextField(androidx.compose.ui.text.input.TextFieldValue r39, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r40, androidx.compose.ui.Modifier r41, boolean r42, boolean r43, androidx.compose.ui.text.TextStyle r44, androidx.compose.foundation.text.KeyboardOptions r45, androidx.compose.foundation.text.KeyboardActions r46, boolean r47, int r48, int r49, androidx.compose.ui.text.input.VisualTransformation r50, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r51, androidx.compose.foundation.interaction.MutableInteractionSource r52, androidx.compose.ui.graphics.Brush r53, kotlin.jvm.functions.Function3<? super kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, androidx.compose.runtime.Composer r55, int r56, int r57, int r58) {
        /*
            r15 = r39
            r14 = r40
            r13 = r56
            r12 = r57
            r11 = r58
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1804514146(0x6b8eb362, float:3.4502916E26)
            r1 = r55
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(BasicTextField)P(14,10,8,2,11,13,5,4,12,6,7,15,9,3)282@16342L39,289@16644L90,287@16582L740:BasicTextField.kt#423gt5"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r56
            r2 = r57
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
            boolean r3 = r10.changedInstance(r14)
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
            r4 = r41
            goto L_0x0073
        L_0x005d:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0071
            r4 = r41
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
            r4 = r41
        L_0x0073:
            r16 = r11 & 8
            r17 = 2048(0x800, float:2.87E-42)
            r18 = 1024(0x400, float:1.435E-42)
            if (r16 == 0) goto L_0x0080
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r42
            goto L_0x0096
        L_0x0080:
            r5 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0094
            r5 = r42
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
            r5 = r42
        L_0x0096:
            r20 = r11 & 16
            r21 = 16384(0x4000, float:2.2959E-41)
            r22 = 8192(0x2000, float:1.14794E-41)
            r23 = 57344(0xe000, float:8.0356E-41)
            if (r20 == 0) goto L_0x00a6
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r6 = r43
            goto L_0x00bc
        L_0x00a6:
            r24 = r13 & r23
            if (r24 != 0) goto L_0x00ba
            r6 = r43
            boolean r25 = r10.changed((boolean) r6)
            if (r25 == 0) goto L_0x00b5
            r25 = r21
            goto L_0x00b7
        L_0x00b5:
            r25 = r22
        L_0x00b7:
            r1 = r1 | r25
            goto L_0x00bc
        L_0x00ba:
            r6 = r43
        L_0x00bc:
            r25 = r11 & 32
            r26 = 458752(0x70000, float:6.42848E-40)
            if (r25 == 0) goto L_0x00c9
            r27 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r27
            r7 = r44
            goto L_0x00df
        L_0x00c9:
            r27 = r13 & r26
            if (r27 != 0) goto L_0x00dd
            r7 = r44
            boolean r28 = r10.changed((java.lang.Object) r7)
            if (r28 == 0) goto L_0x00d8
            r28 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00da
        L_0x00d8:
            r28 = 65536(0x10000, float:9.18355E-41)
        L_0x00da:
            r1 = r1 | r28
            goto L_0x00df
        L_0x00dd:
            r7 = r44
        L_0x00df:
            r28 = r11 & 64
            if (r28 == 0) goto L_0x00ea
            r29 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r29
            r8 = r45
            goto L_0x0102
        L_0x00ea:
            r29 = 3670016(0x380000, float:5.142788E-39)
            r29 = r13 & r29
            if (r29 != 0) goto L_0x0100
            r8 = r45
            boolean r30 = r10.changed((java.lang.Object) r8)
            if (r30 == 0) goto L_0x00fb
            r30 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00fd
        L_0x00fb:
            r30 = 524288(0x80000, float:7.34684E-40)
        L_0x00fd:
            r1 = r1 | r30
            goto L_0x0102
        L_0x0100:
            r8 = r45
        L_0x0102:
            r9 = r11 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x010d
            r31 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r31
            r0 = r46
            goto L_0x0125
        L_0x010d:
            r31 = 29360128(0x1c00000, float:7.052966E-38)
            r31 = r13 & r31
            if (r31 != 0) goto L_0x0123
            r0 = r46
            boolean r32 = r10.changed((java.lang.Object) r0)
            if (r32 == 0) goto L_0x011e
            r32 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0120
        L_0x011e:
            r32 = 4194304(0x400000, float:5.877472E-39)
        L_0x0120:
            r1 = r1 | r32
            goto L_0x0125
        L_0x0123:
            r0 = r46
        L_0x0125:
            r0 = r11 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0130
            r32 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r32
            r4 = r47
            goto L_0x0148
        L_0x0130:
            r32 = 234881024(0xe000000, float:1.5777218E-30)
            r32 = r13 & r32
            if (r32 != 0) goto L_0x0146
            r4 = r47
            boolean r32 = r10.changed((boolean) r4)
            if (r32 == 0) goto L_0x0141
            r32 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0143
        L_0x0141:
            r32 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0143:
            r1 = r1 | r32
            goto L_0x0148
        L_0x0146:
            r4 = r47
        L_0x0148:
            r32 = 1879048192(0x70000000, float:1.58456325E29)
            r32 = r13 & r32
            if (r32 != 0) goto L_0x0164
            r4 = r11 & 512(0x200, float:7.175E-43)
            if (r4 != 0) goto L_0x015d
            r4 = r48
            boolean r32 = r10.changed((int) r4)
            if (r32 == 0) goto L_0x015f
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0161
        L_0x015d:
            r4 = r48
        L_0x015f:
            r32 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0161:
            r1 = r1 | r32
            goto L_0x0166
        L_0x0164:
            r4 = r48
        L_0x0166:
            r4 = r11 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto L_0x016f
            r2 = r2 | 6
            r5 = r49
            goto L_0x0185
        L_0x016f:
            r32 = r12 & 14
            if (r32 != 0) goto L_0x0183
            r5 = r49
            boolean r32 = r10.changed((int) r5)
            if (r32 == 0) goto L_0x017e
            r19 = 4
            goto L_0x0180
        L_0x017e:
            r19 = 2
        L_0x0180:
            r2 = r2 | r19
            goto L_0x0185
        L_0x0183:
            r5 = r49
        L_0x0185:
            r5 = r11 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x018e
            r2 = r2 | 48
            r6 = r50
            goto L_0x01a4
        L_0x018e:
            r19 = r12 & 112(0x70, float:1.57E-43)
            if (r19 != 0) goto L_0x01a2
            r6 = r50
            boolean r19 = r10.changed((java.lang.Object) r6)
            if (r19 == 0) goto L_0x019d
            r24 = 32
            goto L_0x019f
        L_0x019d:
            r24 = 16
        L_0x019f:
            r2 = r2 | r24
            goto L_0x01a4
        L_0x01a2:
            r6 = r50
        L_0x01a4:
            r6 = r11 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x01ad
            r2 = r2 | 384(0x180, float:5.38E-43)
            r7 = r51
            goto L_0x01c3
        L_0x01ad:
            r7 = r12 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x01c1
            r7 = r51
            boolean r19 = r10.changedInstance(r7)
            if (r19 == 0) goto L_0x01bc
            r29 = 256(0x100, float:3.59E-43)
            goto L_0x01be
        L_0x01bc:
            r29 = 128(0x80, float:1.794E-43)
        L_0x01be:
            r2 = r2 | r29
            goto L_0x01c3
        L_0x01c1:
            r7 = r51
        L_0x01c3:
            r7 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x01cc
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r8 = r52
            goto L_0x01e0
        L_0x01cc:
            r8 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x01de
            r8 = r52
            boolean r19 = r10.changed((java.lang.Object) r8)
            if (r19 == 0) goto L_0x01d9
            goto L_0x01db
        L_0x01d9:
            r17 = r18
        L_0x01db:
            r2 = r2 | r17
            goto L_0x01e0
        L_0x01de:
            r8 = r52
        L_0x01e0:
            r8 = r11 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x01e9
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            r14 = r53
            goto L_0x01fd
        L_0x01e9:
            r17 = r12 & r23
            if (r17 != 0) goto L_0x01fb
            r14 = r53
            boolean r17 = r10.changed((java.lang.Object) r14)
            if (r17 == 0) goto L_0x01f6
            goto L_0x01f8
        L_0x01f6:
            r21 = r22
        L_0x01f8:
            r2 = r2 | r21
            goto L_0x01fd
        L_0x01fb:
            r14 = r53
        L_0x01fd:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r11 & r17
            if (r17 == 0) goto L_0x020b
            r18 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r18
            r12 = r54
            goto L_0x0221
        L_0x020b:
            r18 = r12 & r26
            if (r18 != 0) goto L_0x021f
            r12 = r54
            boolean r18 = r10.changedInstance(r12)
            if (r18 == 0) goto L_0x021a
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x021c
        L_0x021a:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x021c:
            r2 = r2 | r18
            goto L_0x0221
        L_0x021f:
            r12 = r54
        L_0x0221:
            r18 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r12 = r1 & r18
            r14 = 306783378(0x12492492, float:6.3469493E-28)
            if (r12 != r14) goto L_0x0262
            r12 = 374491(0x5b6db, float:5.24774E-40)
            r12 = r12 & r2
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r12 != r14) goto L_0x0262
            boolean r12 = r10.getSkipping()
            if (r12 != 0) goto L_0x023b
            goto L_0x0262
        L_0x023b:
            r10.skipToGroupEnd()
            r20 = r41
            r21 = r42
            r22 = r43
            r24 = r44
            r36 = r45
            r25 = r46
            r31 = r47
            r27 = r48
            r28 = r49
            r29 = r50
            r30 = r51
            r32 = r52
            r33 = r53
            r34 = r54
            r26 = r1
            r23 = r2
            r35 = r10
            goto L_0x04b3
        L_0x0262:
            r10.startDefaults()
            r12 = r13 & 1
            if (r12 == 0) goto L_0x02b9
            boolean r12 = r10.getDefaultsInvalid()
            if (r12 == 0) goto L_0x0270
            goto L_0x02b9
        L_0x0270:
            r10.skipToGroupEnd()
            r0 = r11 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x029a
            r0 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r0 = r0 & r1
            r20 = r41
            r21 = r42
            r22 = r43
            r24 = r44
            r14 = r45
            r25 = r46
            r12 = r47
            r27 = r48
            r28 = r49
            r29 = r50
            r30 = r51
            r32 = r52
            r33 = r53
            r34 = r54
            r9 = r0
            goto L_0x03cd
        L_0x029a:
            r20 = r41
            r21 = r42
            r22 = r43
            r24 = r44
            r14 = r45
            r25 = r46
            r12 = r47
            r27 = r48
            r28 = r49
            r29 = r50
            r30 = r51
            r32 = r52
            r33 = r53
            r34 = r54
            r9 = r1
            goto L_0x03cd
        L_0x02b9:
            if (r3 == 0) goto L_0x02c0
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            goto L_0x02c2
        L_0x02c0:
            r3 = r41
        L_0x02c2:
            if (r16 == 0) goto L_0x02c6
            r12 = 1
            goto L_0x02c8
        L_0x02c6:
            r12 = r42
        L_0x02c8:
            if (r20 == 0) goto L_0x02cd
            r16 = 0
            goto L_0x02cf
        L_0x02cd:
            r16 = r43
        L_0x02cf:
            if (r25 == 0) goto L_0x02d8
            androidx.compose.ui.text.TextStyle$Companion r18 = androidx.compose.ui.text.TextStyle.Companion
            androidx.compose.ui.text.TextStyle r18 = r18.getDefault()
            goto L_0x02da
        L_0x02d8:
            r18 = r44
        L_0x02da:
            if (r28 == 0) goto L_0x02e3
            androidx.compose.foundation.text.KeyboardOptions$Companion r19 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r19 = r19.getDefault()
            goto L_0x02e5
        L_0x02e3:
            r19 = r45
        L_0x02e5:
            if (r9 == 0) goto L_0x02ee
            androidx.compose.foundation.text.KeyboardActions$Companion r9 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r9 = r9.getDefault()
            goto L_0x02f0
        L_0x02ee:
            r9 = r46
        L_0x02f0:
            if (r0 == 0) goto L_0x02f4
            r0 = 0
            goto L_0x02f6
        L_0x02f4:
            r0 = r47
        L_0x02f6:
            r14 = r11 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x0307
            if (r0 == 0) goto L_0x02fe
            r14 = 1
            goto L_0x0301
        L_0x02fe:
            r14 = 2147483647(0x7fffffff, float:NaN)
        L_0x0301:
            r20 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            r1 = r1 & r20
            goto L_0x0309
        L_0x0307:
            r14 = r48
        L_0x0309:
            if (r4 == 0) goto L_0x030d
            r4 = 1
            goto L_0x030f
        L_0x030d:
            r4 = r49
        L_0x030f:
            if (r5 == 0) goto L_0x0318
            androidx.compose.ui.text.input.VisualTransformation$Companion r5 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r5 = r5.getNone()
            goto L_0x031a
        L_0x0318:
            r5 = r50
        L_0x031a:
            if (r6 == 0) goto L_0x0321
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$6 r6 = androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$6.INSTANCE
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            goto L_0x0323
        L_0x0321:
            r6 = r51
        L_0x0323:
            if (r7 == 0) goto L_0x036a
            r7 = 0
            r20 = 0
            r41 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = 0
            r42 = r10
            r21 = 0
            r43 = r0
            java.lang.Object r0 = r42.rememberedValue()
            r22 = 0
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r44 = r1
            java.lang.Object r1 = r24.getEmpty()
            if (r0 != r1) goto L_0x035b
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r45 = r0
            r0 = r42
            r0.updateRememberedValue(r1)
            goto L_0x0361
        L_0x035b:
            r45 = r0
            r0 = r42
            r1 = r45
        L_0x0361:
            r10.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x0370
        L_0x036a:
            r41 = r0
            r44 = r1
            r0 = r52
        L_0x0370:
            if (r8 == 0) goto L_0x0384
            androidx.compose.ui.graphics.SolidColor r1 = new androidx.compose.ui.graphics.SolidColor
            androidx.compose.ui.graphics.Color$Companion r7 = androidx.compose.ui.graphics.Color.Companion
            long r7 = r7.m3190getBlack0d7_KjU()
            r42 = r0
            r0 = 0
            r1.<init>(r7, r0)
            r0 = r1
            androidx.compose.ui.graphics.Brush r0 = (androidx.compose.ui.graphics.Brush) r0
            goto L_0x0388
        L_0x0384:
            r42 = r0
            r0 = r53
        L_0x0388:
            if (r17 == 0) goto L_0x03af
            androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt r1 = androidx.compose.foundation.text.ComposableSingletons$BasicTextFieldKt.INSTANCE
            kotlin.jvm.functions.Function3 r1 = r1.m1133getLambda2$foundation_release()
            r32 = r42
            r33 = r0
            r34 = r1
            r20 = r3
            r28 = r4
            r29 = r5
            r30 = r6
            r25 = r9
            r21 = r12
            r27 = r14
            r22 = r16
            r24 = r18
            r14 = r19
            r12 = r41
            r9 = r44
            goto L_0x03cd
        L_0x03af:
            r32 = r42
            r34 = r54
            r33 = r0
            r20 = r3
            r28 = r4
            r29 = r5
            r30 = r6
            r25 = r9
            r21 = r12
            r27 = r14
            r22 = r16
            r24 = r18
            r14 = r19
            r12 = r41
            r9 = r44
        L_0x03cd:
            r10.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x03de
            java.lang.String r0 = "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:268)"
            r1 = 1804514146(0x6b8eb362, float:3.4502916E26)
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r9, r2, r0)
        L_0x03de:
            androidx.compose.ui.text.input.ImeOptions r16 = r14.toImeOptions$foundation_release(r12)
            r8 = r12 ^ 1
            if (r12 == 0) goto L_0x03ea
            r31 = 1
            goto L_0x03ec
        L_0x03ea:
            r31 = r28
        L_0x03ec:
            if (r12 == 0) goto L_0x03f1
            r35 = 1
            goto L_0x03f3
        L_0x03f1:
            r35 = r27
        L_0x03f3:
            r0 = r9 & 14
            r1 = r9 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = 0
            r3 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r10.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r3)
            boolean r3 = r10.changed((java.lang.Object) r15)
            r7 = r40
            boolean r4 = r10.changed((java.lang.Object) r7)
            r3 = r3 | r4
            r4 = r10
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r17 = 0
            if (r3 != 0) goto L_0x0428
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r41 = r0
            java.lang.Object r0 = r18.getEmpty()
            if (r6 != r0) goto L_0x0426
            goto L_0x042a
        L_0x0426:
            r0 = r6
            goto L_0x0439
        L_0x0428:
            r41 = r0
        L_0x042a:
            r0 = 0
            r42 = r0
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1 r0 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$8$1
            r0.<init>(r15, r7)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r4.updateRememberedValue(r0)
        L_0x0439:
            r10.endReplaceableGroup()
            r1 = r0
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r0 = r9 & 14
            r3 = r9 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            int r3 = r9 >> 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            int r3 = r2 << 9
            r3 = r3 & r23
            r0 = r0 | r3
            int r3 = r2 << 9
            r3 = r3 & r26
            r0 = r0 | r3
            int r3 = r2 << 9
            r4 = 3670016(0x380000, float:5.142788E-39)
            r3 = r3 & r4
            r0 = r0 | r3
            r3 = 29360128(0x1c00000, float:7.052966E-38)
            int r4 = r2 << 9
            r3 = r3 & r4
            r17 = r0 | r3
            int r0 = r9 >> 15
            r0 = r0 & 896(0x380, float:1.256E-42)
            r3 = r9 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = r9 & r23
            r0 = r0 | r3
            r3 = r2 & r26
            r18 = r0 | r3
            r19 = 0
            r0 = r39
            r23 = r2
            r2 = r20
            r3 = r24
            r4 = r29
            r5 = r30
            r6 = r32
            r7 = r33
            r26 = r9
            r9 = r35
            r35 = r10
            r10 = r31
            r11 = r16
            r31 = r12
            r12 = r25
            r13 = r21
            r36 = r14
            r14 = r22
            r15 = r34
            r16 = r35
            androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x04b3
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04b3:
            androidx.compose.runtime.ScopeUpdateScope r15 = r35.endRestartGroup()
            if (r15 != 0) goto L_0x04ba
            goto L_0x04f2
        L_0x04ba:
            androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$9 r37 = new androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$9
            r0 = r37
            r1 = r39
            r2 = r40
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r24
            r7 = r36
            r8 = r25
            r9 = r31
            r10 = r27
            r11 = r28
            r12 = r29
            r13 = r30
            r14 = r32
            r38 = r15
            r15 = r33
            r16 = r34
            r17 = r56
            r18 = r57
            r19 = r58
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r37
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r38
            r1.updateScope(r0)
        L_0x04f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt.BasicTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function1, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ void BasicTextField(String value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, VisualTransformation visualTransformation, Function1 onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3 decorationBox, Composer $composer, int $changed, int $changed1, int i) {
        Function3 decorationBox2;
        Brush cursorBrush2;
        MutableInteractionSource interactionSource2;
        Function1 onTextLayout2;
        Composer $composer2;
        VisualTransformation visualTransformation2;
        int maxLines2;
        boolean singleLine2;
        KeyboardActions keyboardActions2;
        KeyboardOptions keyboardOptions2;
        TextStyle textStyle2;
        boolean enabled2;
        Modifier modifier2;
        boolean readOnly2;
        MutableInteractionSource mutableInteractionSource;
        String str = value;
        Function1 function1 = onValueChange;
        int i2 = $changed;
        int i3 = $changed1;
        int i4 = i;
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-454732590);
        ComposerKt.sourceInformation($composer3, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)326@18012L39,331@18252L579:BasicTextField.kt#423gt5");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i4 & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer3.changed((Object) str) ? 4 : 2;
        }
        if ((i4 & 2) != 0) {
            $dirty |= 48;
        } else if ((i2 & 112) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int i5 = i4 & 4;
        if (i5 != 0) {
            $dirty |= 384;
            Modifier modifier3 = modifier;
        } else if ((i2 & 896) == 0) {
            $dirty |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier4 = modifier;
        }
        int i6 = i4 & 8;
        int i7 = 2048;
        if (i6 != 0) {
            $dirty |= 3072;
            boolean z = enabled;
        } else if ((i2 & 7168) == 0) {
            $dirty |= $composer3.changed(enabled) ? 2048 : 1024;
        } else {
            boolean z2 = enabled;
        }
        int i8 = i4 & 16;
        int i9 = 16384;
        if (i8 != 0) {
            $dirty |= 24576;
            boolean z3 = readOnly;
        } else if ((i2 & 57344) == 0) {
            $dirty |= $composer3.changed(readOnly) ? 16384 : 8192;
        } else {
            boolean z4 = readOnly;
        }
        int i10 = i4 & 32;
        if (i10 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            TextStyle textStyle3 = textStyle;
        } else if ((i2 & 458752) == 0) {
            $dirty |= $composer3.changed((Object) textStyle) ? 131072 : 65536;
        } else {
            TextStyle textStyle4 = textStyle;
        }
        int i11 = i4 & 64;
        if (i11 != 0) {
            $dirty |= 1572864;
            KeyboardOptions keyboardOptions3 = keyboardOptions;
        } else if ((i2 & 3670016) == 0) {
            $dirty |= $composer3.changed((Object) keyboardOptions) ? 1048576 : 524288;
        } else {
            KeyboardOptions keyboardOptions4 = keyboardOptions;
        }
        int i12 = i4 & 128;
        if (i12 != 0) {
            $dirty |= 12582912;
            KeyboardActions keyboardActions3 = keyboardActions;
        } else if ((i2 & 29360128) == 0) {
            $dirty |= $composer3.changed((Object) keyboardActions) ? 8388608 : 4194304;
        } else {
            KeyboardActions keyboardActions4 = keyboardActions;
        }
        int i13 = i4 & 256;
        if (i13 != 0) {
            $dirty |= 100663296;
            boolean z5 = singleLine;
        } else if ((i2 & 234881024) == 0) {
            $dirty |= $composer3.changed(singleLine) ? 67108864 : 33554432;
        } else {
            boolean z6 = singleLine;
        }
        int i14 = i4 & 512;
        if (i14 != 0) {
            $dirty |= 805306368;
            int i15 = maxLines;
        } else if ((i2 & 1879048192) == 0) {
            $dirty |= $composer3.changed(maxLines) ? 536870912 : 268435456;
        } else {
            int i16 = maxLines;
        }
        int i17 = i4 & 1024;
        if (i17 != 0) {
            $dirty1 |= 6;
            VisualTransformation visualTransformation3 = visualTransformation;
        } else if ((i3 & 14) == 0) {
            $dirty1 |= $composer3.changed((Object) visualTransformation) ? 4 : 2;
        } else {
            VisualTransformation visualTransformation4 = visualTransformation;
        }
        int i18 = i4 & 2048;
        if (i18 != 0) {
            $dirty1 |= 48;
            Function1 function12 = onTextLayout;
        } else if ((i3 & 112) == 0) {
            $dirty1 |= $composer3.changedInstance(onTextLayout) ? 32 : 16;
        } else {
            Function1 function13 = onTextLayout;
        }
        int i19 = i4 & 4096;
        if (i19 != 0) {
            $dirty1 |= 384;
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        } else if ((i3 & 896) == 0) {
            $dirty1 |= $composer3.changed((Object) interactionSource) ? 256 : 128;
        } else {
            MutableInteractionSource mutableInteractionSource3 = interactionSource;
        }
        int i20 = i4 & 8192;
        if (i20 != 0) {
            $dirty1 |= 3072;
            Brush brush = cursorBrush;
        } else if ((i3 & 7168) == 0) {
            if (!$composer3.changed((Object) cursorBrush)) {
                i7 = 1024;
            }
            $dirty1 |= i7;
        } else {
            Brush brush2 = cursorBrush;
        }
        int i21 = i4 & 16384;
        if (i21 != 0) {
            $dirty1 |= 24576;
            Function3 function3 = decorationBox;
        } else if ((i3 & 57344) == 0) {
            if (!$composer3.changedInstance(decorationBox)) {
                i9 = 8192;
            }
            $dirty1 |= i9;
        } else {
            Function3 function32 = decorationBox;
        }
        if (($dirty & 1533916891) == 306783378 && (46811 & $dirty1) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            readOnly2 = readOnly;
            textStyle2 = textStyle;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            maxLines2 = maxLines;
            visualTransformation2 = visualTransformation;
            onTextLayout2 = onTextLayout;
            interactionSource2 = interactionSource;
            cursorBrush2 = cursorBrush;
            decorationBox2 = decorationBox;
            int i22 = $dirty;
            int i23 = $dirty1;
            $composer2 = $composer3;
        } else {
            if (i5 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i6 != 0) {
                enabled2 = true;
            } else {
                enabled2 = enabled;
            }
            if (i8 != 0) {
                readOnly2 = false;
            } else {
                readOnly2 = readOnly;
            }
            if (i10 != 0) {
                textStyle2 = TextStyle.Companion.getDefault();
            } else {
                textStyle2 = textStyle;
            }
            if (i11 != 0) {
                keyboardOptions2 = KeyboardOptions.Companion.getDefault();
            } else {
                keyboardOptions2 = keyboardOptions;
            }
            if (i12 != 0) {
                keyboardActions2 = KeyboardActions.Companion.getDefault();
            } else {
                keyboardActions2 = keyboardActions;
            }
            if (i13 != 0) {
                singleLine2 = false;
            } else {
                singleLine2 = singleLine;
            }
            if (i14 != 0) {
                maxLines2 = Integer.MAX_VALUE;
            } else {
                maxLines2 = maxLines;
            }
            if (i17 != 0) {
                visualTransformation2 = VisualTransformation.Companion.getNone();
            } else {
                visualTransformation2 = visualTransformation;
            }
            if (i18 != 0) {
                onTextLayout2 = BasicTextFieldKt$BasicTextField$10.INSTANCE;
            } else {
                onTextLayout2 = onTextLayout;
            }
            if (i19 != 0) {
                $composer3.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                Composer $this$cache$iv$iv = $composer3;
                Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                if (it$iv$iv == Composer.Companion.getEmpty()) {
                    mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                    $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource);
                } else {
                    mutableInteractionSource = it$iv$iv;
                }
                $composer3.endReplaceableGroup();
                interactionSource2 = mutableInteractionSource;
            } else {
                interactionSource2 = interactionSource;
            }
            if (i20 != 0) {
                cursorBrush2 = new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null);
            } else {
                cursorBrush2 = cursorBrush;
            }
            decorationBox2 = i21 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.m1134getLambda3$foundation_release() : decorationBox;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-454732590, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:313)");
            }
            int i24 = $dirty;
            int i25 = $dirty1;
            $composer2 = $composer3;
            BasicTextField(value, (Function1<? super String, Unit>) onValueChange, modifier2, enabled2, readOnly2, textStyle2, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, 1, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) onTextLayout2, interactionSource2, cursorBrush2, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) decorationBox2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | ($dirty & 57344) | ($dirty & 458752) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), (($dirty1 << 3) & 112) | 6 | (($dirty1 << 3) & 896) | (($dirty1 << 3) & 7168) | (($dirty1 << 3) & 57344) | (($dirty1 << 3) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicTextFieldKt$BasicTextField$12(value, onValueChange, modifier2, enabled2, readOnly2, textStyle2, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, visualTransformation2, onTextLayout2, interactionSource2, cursorBrush2, decorationBox2, $changed, $changed1, i));
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ void BasicTextField(TextFieldValue value, Function1 onValueChange, Modifier modifier, boolean enabled, boolean readOnly, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean singleLine, int maxLines, VisualTransformation visualTransformation, Function1 onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, Function3 decorationBox, Composer $composer, int $changed, int $changed1, int i) {
        Function3 decorationBox2;
        Brush cursorBrush2;
        MutableInteractionSource interactionSource2;
        Function1 onTextLayout2;
        Composer $composer2;
        VisualTransformation visualTransformation2;
        int maxLines2;
        boolean singleLine2;
        KeyboardActions keyboardActions2;
        KeyboardOptions keyboardOptions2;
        TextStyle textStyle2;
        boolean enabled2;
        Modifier modifier2;
        boolean readOnly2;
        MutableInteractionSource mutableInteractionSource;
        TextFieldValue textFieldValue = value;
        Function1 function1 = onValueChange;
        int i2 = $changed;
        int i3 = $changed1;
        int i4 = i;
        Intrinsics.checkNotNullParameter(textFieldValue, "value");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-560482651);
        ComposerKt.sourceInformation($composer3, "C(BasicTextField)P(13,9,7,2,10,12,5,4,11,6,14,8,3)366@19537L39,371@19777L579:BasicTextField.kt#423gt5");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i4 & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer3.changed((Object) textFieldValue) ? 4 : 2;
        }
        if ((i4 & 2) != 0) {
            $dirty |= 48;
        } else if ((i2 & 112) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int i5 = i4 & 4;
        if (i5 != 0) {
            $dirty |= 384;
            Modifier modifier3 = modifier;
        } else if ((i2 & 896) == 0) {
            $dirty |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier4 = modifier;
        }
        int i6 = i4 & 8;
        int i7 = 2048;
        if (i6 != 0) {
            $dirty |= 3072;
            boolean z = enabled;
        } else if ((i2 & 7168) == 0) {
            $dirty |= $composer3.changed(enabled) ? 2048 : 1024;
        } else {
            boolean z2 = enabled;
        }
        int i8 = i4 & 16;
        int i9 = 16384;
        if (i8 != 0) {
            $dirty |= 24576;
            boolean z3 = readOnly;
        } else if ((i2 & 57344) == 0) {
            $dirty |= $composer3.changed(readOnly) ? 16384 : 8192;
        } else {
            boolean z4 = readOnly;
        }
        int i10 = i4 & 32;
        if (i10 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            TextStyle textStyle3 = textStyle;
        } else if ((i2 & 458752) == 0) {
            $dirty |= $composer3.changed((Object) textStyle) ? 131072 : 65536;
        } else {
            TextStyle textStyle4 = textStyle;
        }
        int i11 = i4 & 64;
        if (i11 != 0) {
            $dirty |= 1572864;
            KeyboardOptions keyboardOptions3 = keyboardOptions;
        } else if ((i2 & 3670016) == 0) {
            $dirty |= $composer3.changed((Object) keyboardOptions) ? 1048576 : 524288;
        } else {
            KeyboardOptions keyboardOptions4 = keyboardOptions;
        }
        int i12 = i4 & 128;
        if (i12 != 0) {
            $dirty |= 12582912;
            KeyboardActions keyboardActions3 = keyboardActions;
        } else if ((i2 & 29360128) == 0) {
            $dirty |= $composer3.changed((Object) keyboardActions) ? 8388608 : 4194304;
        } else {
            KeyboardActions keyboardActions4 = keyboardActions;
        }
        int i13 = i4 & 256;
        if (i13 != 0) {
            $dirty |= 100663296;
            boolean z5 = singleLine;
        } else if ((i2 & 234881024) == 0) {
            $dirty |= $composer3.changed(singleLine) ? 67108864 : 33554432;
        } else {
            boolean z6 = singleLine;
        }
        int i14 = i4 & 512;
        if (i14 != 0) {
            $dirty |= 805306368;
            int i15 = maxLines;
        } else if ((i2 & 1879048192) == 0) {
            $dirty |= $composer3.changed(maxLines) ? 536870912 : 268435456;
        } else {
            int i16 = maxLines;
        }
        int i17 = i4 & 1024;
        if (i17 != 0) {
            $dirty1 |= 6;
            VisualTransformation visualTransformation3 = visualTransformation;
        } else if ((i3 & 14) == 0) {
            $dirty1 |= $composer3.changed((Object) visualTransformation) ? 4 : 2;
        } else {
            VisualTransformation visualTransformation4 = visualTransformation;
        }
        int i18 = i4 & 2048;
        if (i18 != 0) {
            $dirty1 |= 48;
            Function1 function12 = onTextLayout;
        } else if ((i3 & 112) == 0) {
            $dirty1 |= $composer3.changedInstance(onTextLayout) ? 32 : 16;
        } else {
            Function1 function13 = onTextLayout;
        }
        int i19 = i4 & 4096;
        if (i19 != 0) {
            $dirty1 |= 384;
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        } else if ((i3 & 896) == 0) {
            $dirty1 |= $composer3.changed((Object) interactionSource) ? 256 : 128;
        } else {
            MutableInteractionSource mutableInteractionSource3 = interactionSource;
        }
        int i20 = i4 & 8192;
        if (i20 != 0) {
            $dirty1 |= 3072;
            Brush brush = cursorBrush;
        } else if ((i3 & 7168) == 0) {
            if (!$composer3.changed((Object) cursorBrush)) {
                i7 = 1024;
            }
            $dirty1 |= i7;
        } else {
            Brush brush2 = cursorBrush;
        }
        int i21 = i4 & 16384;
        if (i21 != 0) {
            $dirty1 |= 24576;
            Function3 function3 = decorationBox;
        } else if ((i3 & 57344) == 0) {
            if (!$composer3.changedInstance(decorationBox)) {
                i9 = 8192;
            }
            $dirty1 |= i9;
        } else {
            Function3 function32 = decorationBox;
        }
        if (($dirty & 1533916891) == 306783378 && (46811 & $dirty1) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            enabled2 = enabled;
            readOnly2 = readOnly;
            textStyle2 = textStyle;
            keyboardOptions2 = keyboardOptions;
            keyboardActions2 = keyboardActions;
            singleLine2 = singleLine;
            maxLines2 = maxLines;
            visualTransformation2 = visualTransformation;
            onTextLayout2 = onTextLayout;
            interactionSource2 = interactionSource;
            cursorBrush2 = cursorBrush;
            decorationBox2 = decorationBox;
            int i22 = $dirty;
            int i23 = $dirty1;
            $composer2 = $composer3;
        } else {
            if (i5 != 0) {
                modifier2 = Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (i6 != 0) {
                enabled2 = true;
            } else {
                enabled2 = enabled;
            }
            if (i8 != 0) {
                readOnly2 = false;
            } else {
                readOnly2 = readOnly;
            }
            if (i10 != 0) {
                textStyle2 = TextStyle.Companion.getDefault();
            } else {
                textStyle2 = textStyle;
            }
            if (i11 != 0) {
                keyboardOptions2 = KeyboardOptions.Companion.getDefault();
            } else {
                keyboardOptions2 = keyboardOptions;
            }
            if (i12 != 0) {
                keyboardActions2 = KeyboardActions.Companion.getDefault();
            } else {
                keyboardActions2 = keyboardActions;
            }
            if (i13 != 0) {
                singleLine2 = false;
            } else {
                singleLine2 = singleLine;
            }
            if (i14 != 0) {
                maxLines2 = Integer.MAX_VALUE;
            } else {
                maxLines2 = maxLines;
            }
            if (i17 != 0) {
                visualTransformation2 = VisualTransformation.Companion.getNone();
            } else {
                visualTransformation2 = visualTransformation;
            }
            if (i18 != 0) {
                onTextLayout2 = BasicTextFieldKt$BasicTextField$13.INSTANCE;
            } else {
                onTextLayout2 = onTextLayout;
            }
            if (i19 != 0) {
                $composer3.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                Composer $this$cache$iv$iv = $composer3;
                Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                if (it$iv$iv == Composer.Companion.getEmpty()) {
                    mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                    $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource);
                } else {
                    mutableInteractionSource = it$iv$iv;
                }
                $composer3.endReplaceableGroup();
                interactionSource2 = mutableInteractionSource;
            } else {
                interactionSource2 = interactionSource;
            }
            if (i20 != 0) {
                cursorBrush2 = new SolidColor(Color.Companion.m3190getBlack0d7_KjU(), (DefaultConstructorMarker) null);
            } else {
                cursorBrush2 = cursorBrush;
            }
            decorationBox2 = i21 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.m1135getLambda4$foundation_release() : decorationBox;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-560482651, $dirty, $dirty1, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:353)");
            }
            int i24 = $dirty;
            int i25 = $dirty1;
            $composer2 = $composer3;
            BasicTextField(value, (Function1<? super TextFieldValue, Unit>) onValueChange, modifier2, enabled2, readOnly2, textStyle2, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, 1, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) onTextLayout2, interactionSource2, cursorBrush2, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) decorationBox2, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | ($dirty & 57344) | ($dirty & 458752) | (3670016 & $dirty) | (29360128 & $dirty) | (234881024 & $dirty) | (1879048192 & $dirty), (($dirty1 << 3) & 112) | 6 | (($dirty1 << 3) & 896) | (($dirty1 << 3) & 7168) | (($dirty1 << 3) & 57344) | (($dirty1 << 3) & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BasicTextFieldKt$BasicTextField$15(value, onValueChange, modifier2, enabled2, readOnly2, textStyle2, keyboardOptions2, keyboardActions2, singleLine2, maxLines2, visualTransformation2, onTextLayout2, interactionSource2, cursorBrush2, decorationBox2, $changed, $changed1, i));
        }
    }
}
