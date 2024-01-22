package androidx.compose.material3;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aò\u0001\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00032\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020$0)¢\u0006\u0002\b*2\u0006\u0010+\u001a\u00020,2\u0013\u0010-\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010)¢\u0006\u0002\b*2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020$\u0018\u00010)¢\u0006\u0002\b*2\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u0002032\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0011\u0010<\u001a\r\u0012\u0004\u0012\u00020$0)¢\u0006\u0002\b*H\u0001¢\u0006\u0002\u0010=\u001a<\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0011\u0010C\u001a\r\u0012\u0004\u0012\u00020$0)¢\u0006\u0002\b*H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a\u0012\u0010F\u001a\u00020\u00012\b\u0010G\u001a\u0004\u0018\u00010HH\u0000\u001a\u0012\u0010I\u001a\u00020\u00012\b\u0010G\u001a\u0004\u0018\u00010HH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u000e\u0010\r\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0013\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007\"\u000e\u0010\u0015\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0016\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007\"\u000e\u0010\u0018\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0019\u001a\u00020\u001aX\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001c\"\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001f*\u00020 8@X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006J"}, d2 = {"AnimationDuration", "", "ContainerId", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "LeadingId", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "SupportingId", "SupportingTopPadding", "getSupportingTopPadding", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material3/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "supportingText", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/TextFieldColors;", "container", "(Landroidx/compose/material3/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "content", "Decoration-KTwxG1Y", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextFieldImpl.kt */
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    public static final String ContainerId = "Container";
    private static final float HorizontalIconPadding = Dp.m5986constructorimpl((float) 12);
    private static final Modifier IconDefaultSizeModifier = SizeKt.m814defaultMinSizeVpY3zN4(Modifier.Companion, Dp.m5986constructorimpl((float) 48), Dp.m5986constructorimpl((float) 48));
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String SupportingId = "Supporting";
    private static final float SupportingTopPadding = Dp.m5986constructorimpl((float) 4);
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding = Dp.m5986constructorimpl((float) 16);
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);

    /* JADX WARNING: Removed duplicated region for block: B:168:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0327  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x03a6  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x03c9  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x03f9  */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0410  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0444  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x044e  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0451  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x04b2  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x04bb  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x04be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void CommonDecorationBox(androidx.compose.material3.TextFieldType r46, java.lang.String r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, androidx.compose.ui.text.input.VisualTransformation r49, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, boolean r55, boolean r56, boolean r57, androidx.compose.foundation.interaction.InteractionSource r58, androidx.compose.foundation.layout.PaddingValues r59, androidx.compose.material3.TextFieldColors r60, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r61, androidx.compose.runtime.Composer r62, int r63, int r64, int r65) {
        /*
            r15 = r46
            r14 = r47
            r13 = r48
            r12 = r49
            r11 = r50
            r10 = r58
            r9 = r59
            r8 = r60
            r7 = r61
            r6 = r63
            r5 = r64
            r4 = r65
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "innerTextField"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "visualTransformation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "contentPadding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "colors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "container"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 4948732(0x4b82fc, float:6.93465E-39)
            r1 = r62
            androidx.compose.runtime.Composer r3 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(CommonDecorationBox)P(13,14,4,15,7,9,8,12,11,10,3,6,5,2)80@3165L105,84@3320L25,95@3704L10,*107@4336L10,108@4430L22,102@4047L5619:TextFieldImpl.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r1)
            r1 = r63
            r2 = r64
            r16 = r4 & 1
            r17 = 4
            r18 = 2
            if (r16 == 0) goto L_0x0062
            r1 = r1 | 6
            goto L_0x0073
        L_0x0062:
            r16 = r6 & 14
            if (r16 != 0) goto L_0x0073
            boolean r16 = r3.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x006f
            r16 = r17
            goto L_0x0071
        L_0x006f:
            r16 = r18
        L_0x0071:
            r1 = r1 | r16
        L_0x0073:
            r16 = r4 & 2
            r19 = 32
            r20 = 16
            if (r16 == 0) goto L_0x007e
            r1 = r1 | 48
            goto L_0x008f
        L_0x007e:
            r16 = r6 & 112(0x70, float:1.57E-43)
            if (r16 != 0) goto L_0x008f
            boolean r16 = r3.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x008b
            r16 = r19
            goto L_0x008d
        L_0x008b:
            r16 = r20
        L_0x008d:
            r1 = r1 | r16
        L_0x008f:
            r16 = r4 & 4
            r21 = 256(0x100, float:3.59E-43)
            r22 = 128(0x80, float:1.794E-43)
            if (r16 == 0) goto L_0x009a
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x00aa
        L_0x009a:
            r0 = r6 & 896(0x380, float:1.256E-42)
            if (r0 != 0) goto L_0x00aa
            boolean r0 = r3.changed((java.lang.Object) r13)
            if (r0 == 0) goto L_0x00a7
            r0 = r21
            goto L_0x00a9
        L_0x00a7:
            r0 = r22
        L_0x00a9:
            r1 = r1 | r0
        L_0x00aa:
            r0 = r4 & 8
            r23 = 2048(0x800, float:2.87E-42)
            r24 = 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x00b5
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x00c5
        L_0x00b5:
            r0 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r0 != 0) goto L_0x00c5
            boolean r0 = r3.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x00c2
            r0 = r23
            goto L_0x00c4
        L_0x00c2:
            r0 = r24
        L_0x00c4:
            r1 = r1 | r0
        L_0x00c5:
            r0 = r4 & 16
            r25 = 57344(0xe000, float:8.0356E-41)
            r26 = 16384(0x4000, float:2.2959E-41)
            r27 = 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x00d3
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00e3
        L_0x00d3:
            r0 = r6 & r25
            if (r0 != 0) goto L_0x00e3
            boolean r0 = r3.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x00e0
            r0 = r26
            goto L_0x00e2
        L_0x00e0:
            r0 = r27
        L_0x00e2:
            r1 = r1 | r0
        L_0x00e3:
            r0 = r4 & 32
            if (r0 == 0) goto L_0x00ee
            r28 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r28
            r13 = r51
            goto L_0x0106
        L_0x00ee:
            r28 = 458752(0x70000, float:6.42848E-40)
            r28 = r6 & r28
            if (r28 != 0) goto L_0x0104
            r13 = r51
            boolean r28 = r3.changed((java.lang.Object) r13)
            if (r28 == 0) goto L_0x00ff
            r28 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0101
        L_0x00ff:
            r28 = 65536(0x10000, float:9.18355E-41)
        L_0x0101:
            r1 = r1 | r28
            goto L_0x0106
        L_0x0104:
            r13 = r51
        L_0x0106:
            r28 = r4 & 64
            if (r28 == 0) goto L_0x0111
            r29 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r29
            r13 = r52
            goto L_0x0129
        L_0x0111:
            r29 = 3670016(0x380000, float:5.142788E-39)
            r29 = r6 & r29
            if (r29 != 0) goto L_0x0127
            r13 = r52
            boolean r29 = r3.changed((java.lang.Object) r13)
            if (r29 == 0) goto L_0x0122
            r29 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0124
        L_0x0122:
            r29 = 524288(0x80000, float:7.34684E-40)
        L_0x0124:
            r1 = r1 | r29
            goto L_0x0129
        L_0x0127:
            r13 = r52
        L_0x0129:
            r13 = r4 & 128(0x80, float:1.794E-43)
            if (r13 == 0) goto L_0x0134
            r29 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r29
            r15 = r53
            goto L_0x014c
        L_0x0134:
            r29 = 29360128(0x1c00000, float:7.052966E-38)
            r29 = r6 & r29
            if (r29 != 0) goto L_0x014a
            r15 = r53
            boolean r29 = r3.changed((java.lang.Object) r15)
            if (r29 == 0) goto L_0x0145
            r29 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0147
        L_0x0145:
            r29 = 4194304(0x400000, float:5.877472E-39)
        L_0x0147:
            r1 = r1 | r29
            goto L_0x014c
        L_0x014a:
            r15 = r53
        L_0x014c:
            r15 = r4 & 256(0x100, float:3.59E-43)
            if (r15 == 0) goto L_0x0157
            r29 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r29
            r11 = r54
            goto L_0x016f
        L_0x0157:
            r29 = 234881024(0xe000000, float:1.5777218E-30)
            r29 = r6 & r29
            if (r29 != 0) goto L_0x016d
            r11 = r54
            boolean r29 = r3.changed((java.lang.Object) r11)
            if (r29 == 0) goto L_0x0168
            r29 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x016a
        L_0x0168:
            r29 = 33554432(0x2000000, float:9.403955E-38)
        L_0x016a:
            r1 = r1 | r29
            goto L_0x016f
        L_0x016d:
            r11 = r54
        L_0x016f:
            r11 = r4 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x017a
            r29 = 805306368(0x30000000, float:4.656613E-10)
            r1 = r1 | r29
            r6 = r55
            goto L_0x0192
        L_0x017a:
            r29 = 1879048192(0x70000000, float:1.58456325E29)
            r29 = r6 & r29
            if (r29 != 0) goto L_0x0190
            r6 = r55
            boolean r29 = r3.changed((boolean) r6)
            if (r29 == 0) goto L_0x018b
            r29 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x018d
        L_0x018b:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x018d:
            r1 = r1 | r29
            goto L_0x0192
        L_0x0190:
            r6 = r55
        L_0x0192:
            r6 = r4 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x019b
            r2 = r2 | 6
            r12 = r56
            goto L_0x01af
        L_0x019b:
            r29 = r5 & 14
            if (r29 != 0) goto L_0x01ad
            r12 = r56
            boolean r29 = r3.changed((boolean) r12)
            if (r29 == 0) goto L_0x01a8
            goto L_0x01aa
        L_0x01a8:
            r17 = r18
        L_0x01aa:
            r2 = r2 | r17
            goto L_0x01af
        L_0x01ad:
            r12 = r56
        L_0x01af:
            r12 = r4 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x01b8
            r2 = r2 | 48
            r14 = r57
            goto L_0x01cc
        L_0x01b8:
            r17 = r5 & 112(0x70, float:1.57E-43)
            if (r17 != 0) goto L_0x01ca
            r14 = r57
            boolean r17 = r3.changed((boolean) r14)
            if (r17 == 0) goto L_0x01c5
            goto L_0x01c7
        L_0x01c5:
            r19 = r20
        L_0x01c7:
            r2 = r2 | r19
            goto L_0x01cc
        L_0x01ca:
            r14 = r57
        L_0x01cc:
            r14 = r4 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x01d3
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x01e2
        L_0x01d3:
            r14 = r5 & 896(0x380, float:1.256E-42)
            if (r14 != 0) goto L_0x01e2
            boolean r14 = r3.changed((java.lang.Object) r10)
            if (r14 == 0) goto L_0x01de
            goto L_0x01e0
        L_0x01de:
            r21 = r22
        L_0x01e0:
            r2 = r2 | r21
        L_0x01e2:
            r14 = r4 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x01e9
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x01f8
        L_0x01e9:
            r14 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r14 != 0) goto L_0x01f8
            boolean r14 = r3.changed((java.lang.Object) r9)
            if (r14 == 0) goto L_0x01f4
            goto L_0x01f6
        L_0x01f4:
            r23 = r24
        L_0x01f6:
            r2 = r2 | r23
        L_0x01f8:
            r14 = r4 & 16384(0x4000, float:2.2959E-41)
            if (r14 == 0) goto L_0x01ff
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x020e
        L_0x01ff:
            r14 = r5 & r25
            if (r14 != 0) goto L_0x020e
            boolean r14 = r3.changed((java.lang.Object) r8)
            if (r14 == 0) goto L_0x020a
            goto L_0x020c
        L_0x020a:
            r26 = r27
        L_0x020c:
            r2 = r2 | r26
        L_0x020e:
            r14 = 32768(0x8000, float:4.5918E-41)
            r14 = r14 & r4
            if (r14 == 0) goto L_0x0218
            r14 = 196608(0x30000, float:2.75506E-40)
        L_0x0216:
            r2 = r2 | r14
            goto L_0x0229
        L_0x0218:
            r14 = 458752(0x70000, float:6.42848E-40)
            r14 = r14 & r5
            if (r14 != 0) goto L_0x0229
            boolean r14 = r3.changed((java.lang.Object) r7)
            if (r14 == 0) goto L_0x0226
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0216
        L_0x0226:
            r14 = 65536(0x10000, float:9.18355E-41)
            goto L_0x0216
        L_0x0229:
            r14 = r2
            r2 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r2 & r1
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r4) goto L_0x025b
            r2 = 374491(0x5b6db, float:5.24774E-40)
            r2 = r2 & r14
            r4 = 74898(0x12492, float:1.04954E-40)
            if (r2 != r4) goto L_0x025b
            boolean r2 = r3.getSkipping()
            if (r2 != 0) goto L_0x0243
            goto L_0x025b
        L_0x0243:
            r3.skipToGroupEnd()
            r20 = r51
            r21 = r52
            r22 = r53
            r23 = r54
            r24 = r55
            r25 = r56
            r26 = r57
            r39 = r1
            r15 = r3
            r43 = r14
            goto L_0x04b5
        L_0x025b:
            if (r0 == 0) goto L_0x0261
            r0 = 0
            r20 = r0
            goto L_0x0263
        L_0x0261:
            r20 = r51
        L_0x0263:
            if (r28 == 0) goto L_0x0269
            r0 = 0
            r21 = r0
            goto L_0x026b
        L_0x0269:
            r21 = r52
        L_0x026b:
            if (r13 == 0) goto L_0x0271
            r0 = 0
            r22 = r0
            goto L_0x0273
        L_0x0271:
            r22 = r53
        L_0x0273:
            if (r15 == 0) goto L_0x0279
            r0 = 0
            r23 = r0
            goto L_0x027b
        L_0x0279:
            r23 = r54
        L_0x027b:
            if (r11 == 0) goto L_0x0281
            r0 = 0
            r24 = r0
            goto L_0x0283
        L_0x0281:
            r24 = r55
        L_0x0283:
            if (r6 == 0) goto L_0x0289
            r0 = 1
            r25 = r0
            goto L_0x028b
        L_0x0289:
            r25 = r56
        L_0x028b:
            if (r12 == 0) goto L_0x0291
            r0 = 0
            r26 = r0
            goto L_0x0293
        L_0x0291:
            r26 = r57
        L_0x0293:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02a1
            java.lang.String r0 = "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:62)"
            r2 = 4948732(0x4b82fc, float:6.93465E-39)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r14, r0)
        L_0x02a1:
            int r0 = r1 >> 3
            r0 = r0 & 14
            int r2 = r1 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            r2 = 0
            r4 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r3.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r15 = r47
            boolean r4 = r3.changed((java.lang.Object) r15)
            r12 = r49
            boolean r6 = r3.changed((java.lang.Object) r12)
            r4 = r4 | r6
            r6 = r3
            r11 = 0
            java.lang.Object r13 = r6.rememberedValue()
            r16 = 0
            if (r4 != 0) goto L_0x02db
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r57 = r0
            java.lang.Object r0 = r17.getEmpty()
            if (r13 != r0) goto L_0x02d9
            goto L_0x02dd
        L_0x02d9:
            r0 = r13
            goto L_0x0301
        L_0x02db:
            r57 = r0
        L_0x02dd:
            r0 = 0
            r62 = r0
            androidx.compose.ui.text.AnnotatedString r0 = new androidx.compose.ui.text.AnnotatedString
            r17 = 0
            r18 = 0
            r19 = 6
            r27 = 0
            r51 = r0
            r52 = r47
            r53 = r17
            r54 = r18
            r55 = r19
            r56 = r27
            r51.<init>(r52, r53, r54, r55, r56)
            androidx.compose.ui.text.input.TransformedText r0 = r12.filter(r0)
            r6.updateRememberedValue(r0)
        L_0x0301:
            r3.endReplaceableGroup()
            androidx.compose.ui.text.input.TransformedText r0 = (androidx.compose.ui.text.input.TransformedText) r0
            androidx.compose.ui.text.AnnotatedString r0 = r0.getText()
            java.lang.String r0 = r0.getText()
            r27 = r0
            int r0 = r14 >> 6
            r0 = r0 & 14
            androidx.compose.runtime.State r0 = androidx.compose.foundation.interaction.FocusInteractionKt.collectIsFocusedAsState(r10, r3, r0)
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r28 = r0.booleanValue()
            if (r28 == 0) goto L_0x032a
            androidx.compose.material3.InputPhase r2 = androidx.compose.material3.InputPhase.Focused
            goto L_0x033e
        L_0x032a:
            r2 = r27
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0336
            r2 = 1
            goto L_0x0337
        L_0x0336:
            r2 = 0
        L_0x0337:
            if (r2 == 0) goto L_0x033c
            androidx.compose.material3.InputPhase r2 = androidx.compose.material3.InputPhase.UnfocusedEmpty
            goto L_0x033e
        L_0x033c:
            androidx.compose.material3.InputPhase r2 = androidx.compose.material3.InputPhase.UnfocusedNotEmpty
        L_0x033e:
            r11 = r2
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1 r2 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
            r51 = r2
            r52 = r60
            r53 = r25
            r54 = r26
            r55 = r58
            r56 = r14
            r51.<init>(r52, r53, r54, r55, r56)
            r6 = r2
            kotlin.jvm.functions.Function3 r6 = (kotlin.jvm.functions.Function3) r6
            androidx.compose.material3.MaterialTheme r2 = androidx.compose.material3.MaterialTheme.INSTANCE
            r4 = 6
            androidx.compose.material3.Typography r29 = r2.getTypography(r3, r4)
            androidx.compose.ui.text.TextStyle r30 = r29.getBodyLarge()
            androidx.compose.ui.text.TextStyle r31 = r29.getBodySmall()
            r62 = r14
            long r13 = r30.m5494getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            r16 = r1
            long r0 = r2.m3200getUnspecified0d7_KjU()
            boolean r0 = androidx.compose.ui.graphics.Color.m3165equalsimpl0(r13, r0)
            if (r0 == 0) goto L_0x0386
            long r0 = r31.m5494getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r2.m3200getUnspecified0d7_KjU()
            boolean r0 = androidx.compose.ui.graphics.Color.m3165equalsimpl0(r0, r13)
            if (r0 == 0) goto L_0x03a6
        L_0x0386:
            long r0 = r30.m5494getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r2.m3200getUnspecified0d7_KjU()
            boolean r0 = androidx.compose.ui.graphics.Color.m3165equalsimpl0(r0, r13)
            if (r0 != 0) goto L_0x03a8
            long r0 = r31.m5494getColor0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.Companion
            long r13 = r2.m3200getUnspecified0d7_KjU()
            boolean r0 = androidx.compose.ui.graphics.Color.m3165equalsimpl0(r0, r13)
            if (r0 == 0) goto L_0x03a8
        L_0x03a6:
            r0 = 1
            goto L_0x03a9
        L_0x03a8:
            r0 = 0
        L_0x03a9:
            r32 = r0
            androidx.compose.material3.TextFieldTransitionScope r33 = androidx.compose.material3.TextFieldTransitionScope.INSTANCE
            r0 = -646388305(0xffffffffd978e5af, float:-4.37864588E15)
            r3.startReplaceableGroup(r0)
            java.lang.String r0 = "*104@4143L10,105@4237L22"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r0)
            androidx.compose.material3.MaterialTheme r0 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.Typography r0 = r0.getTypography(r3, r4)
            androidx.compose.ui.text.TextStyle r0 = r0.getBodySmall()
            long r0 = r0.m5494getColor0d7_KjU()
            r2 = 0
            if (r32 == 0) goto L_0x03f9
            r13 = r0
            r17 = 0
            r18 = r13
            r34 = 0
            androidx.compose.ui.graphics.Color$Companion r35 = androidx.compose.ui.graphics.Color.Companion
            long r35 = r35.m3200getUnspecified0d7_KjU()
            int r35 = (r18 > r35 ? 1 : (r18 == r35 ? 0 : -1))
            if (r35 == 0) goto L_0x03dd
            r18 = 1
            goto L_0x03df
        L_0x03dd:
            r18 = 0
        L_0x03df:
            if (r18 == 0) goto L_0x03e2
            goto L_0x03f6
        L_0x03e2:
            r18 = 0
            r19 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r19)
            java.lang.Object r4 = r6.invoke(r11, r3, r4)
            androidx.compose.ui.graphics.Color r4 = (androidx.compose.ui.graphics.Color) r4
            long r34 = r4.m3174unboximpl()
            r13 = r34
        L_0x03f6:
            r34 = r13
            goto L_0x03fb
        L_0x03f9:
            r34 = r0
        L_0x03fb:
            r3.endReplaceableGroup()
            androidx.compose.material3.MaterialTheme r0 = androidx.compose.material3.MaterialTheme.INSTANCE
            r1 = 6
            androidx.compose.material3.Typography r0 = r0.getTypography(r3, r1)
            androidx.compose.ui.text.TextStyle r0 = r0.getBodyLarge()
            long r0 = r0.m5494getColor0d7_KjU()
            r2 = 0
            if (r32 == 0) goto L_0x0444
            r13 = r0
            r4 = 0
            r17 = r13
            r19 = 0
            androidx.compose.ui.graphics.Color$Companion r36 = androidx.compose.ui.graphics.Color.Companion
            long r36 = r36.m3200getUnspecified0d7_KjU()
            int r36 = (r17 > r36 ? 1 : (r17 == r36 ? 0 : -1))
            if (r36 == 0) goto L_0x0423
            r19 = 1
            goto L_0x0425
        L_0x0423:
            r19 = 0
        L_0x0425:
            if (r19 == 0) goto L_0x042c
            r52 = r0
            r18 = 0
            goto L_0x0441
        L_0x042c:
            r17 = 0
            r52 = r0
            r18 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r18)
            java.lang.Object r0 = r6.invoke(r11, r3, r0)
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r0 = r0.m3174unboximpl()
            r13 = r0
        L_0x0441:
            r36 = r13
            goto L_0x044a
        L_0x0444:
            r52 = r0
            r18 = 0
            r36 = r52
        L_0x044a:
            if (r50 == 0) goto L_0x0451
            r38 = 1
            goto L_0x0453
        L_0x0451:
            r38 = r18
        L_0x0453:
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3 r14 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3
            r0 = r14
            r39 = r16
            r1 = r50
            r2 = r20
            r13 = r3
            r3 = r27
            r4 = r26
            r5 = r62
            r40 = r6
            r6 = r60
            r7 = r25
            r8 = r58
            r9 = r21
            r10 = r22
            r41 = r11
            r11 = r23
            r12 = r46
            r42 = r13
            r13 = r48
            r43 = r62
            r15 = r14
            r14 = r24
            r44 = r15
            r15 = r59
            r17 = r32
            r18 = r31
            r19 = r61
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = 1915872767(0x7231e5ff, float:3.5236413E30)
            r15 = r42
            r1 = r44
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r2, r1)
            r9 = r0
            kotlin.jvm.functions.Function6 r9 = (kotlin.jvm.functions.Function6) r9
            r11 = 1769472(0x1b0000, float:2.479558E-39)
            r1 = r33
            r2 = r41
            r3 = r34
            r5 = r36
            r7 = r40
            r8 = r38
            r10 = r15
            r1.m2176TransitionDTcfvLk(r2, r3, r5, r7, r8, r9, r10, r11)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x04b5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x04b5:
            androidx.compose.runtime.ScopeUpdateScope r14 = r15.endRestartGroup()
            if (r14 != 0) goto L_0x04be
            r28 = r15
            goto L_0x04f8
        L_0x04be:
            androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$4 r27 = new androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$4
            r0 = r27
            r1 = r46
            r2 = r47
            r3 = r48
            r4 = r49
            r5 = r50
            r6 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r25
            r12 = r26
            r13 = r58
            r45 = r14
            r14 = r59
            r28 = r15
            r15 = r60
            r16 = r61
            r17 = r63
            r18 = r64
            r19 = r65
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = r27
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r45
            r1.updateScope(r0)
        L_0x04f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldImplKt.CommonDecorationBox(androidx.compose.material3.TextFieldType, java.lang.String, kotlin.jvm.functions.Function2, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.foundation.layout.PaddingValues, androidx.compose.material3.TextFieldColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* renamed from: Decoration-KTwxG1Y  reason: not valid java name */
    public static final void m2163DecorationKTwxG1Y(long contentColor, TextStyle typography, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        TextStyle textStyle;
        TextStyle typography2;
        TextStyle typography3;
        long j = contentColor;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-1520066345);
        ComposerKt.sourceInformation($composer2, "C(Decoration)P(1:c#ui.graphics.Color,2):TextFieldImpl.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed(j) ? 4 : 2;
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
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if ((i2 & 896) == 0) {
            $dirty |= $composer2.changed((Object) function2) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                typography3 = null;
            } else {
                typography3 = textStyle;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520066345, $dirty2, -1, "androidx.compose.material3.Decoration (TextFieldImpl.kt:236)");
            }
            Function2 contentWithColor = ComposableLambdaKt.composableLambda($composer2, 1449369305, true, new TextFieldImplKt$Decoration$contentWithColor$1(j, function2, $dirty2));
            if (typography3 != null) {
                $composer2.startReplaceableGroup(1830466317);
                ComposerKt.sourceInformation($composer2, "247@10112L46");
                TextKt.ProvideTextStyle(typography3, contentWithColor, $composer2, (($dirty2 >> 3) & 14) | 48);
            } else {
                $composer2.startReplaceableGroup(1830466369);
                ComposerKt.sourceInformation($composer2, "247@10164L18");
                contentWithColor.invoke($composer2, 6);
            }
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            typography2 = typography3;
        } else {
            $composer2.skipToGroupEnd();
            typography2 = textStyle;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextFieldImplKt$Decoration$1(contentColor, typography2, content, $changed, i));
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

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }
}
