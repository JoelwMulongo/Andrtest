package androidx.compose.material3;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aj\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001a|\u0010\u001f\u001a\u00020\u000f*\u00020 2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\"2\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010\u001c\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\b\u0010\t\"\u0013\u0010\n\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0013\u0010\u000b\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005\"\u0019\u0010\f\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\r\u0010\t\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "SwitchHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchWidth", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPadding", "ThumbPathLength", "UncheckedThumbDiameter", "getUncheckedThumbDiameter", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "thumbContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "colors", "Landroidx/compose/material3/SwitchColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/SwitchColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/interaction/InteractionSource;", "thumbShape", "Landroidx/compose/ui/graphics/Shape;", "uncheckedThumbDiameter", "minBound", "maxBound", "SwitchImpl-0DmnUew", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material3/SwitchColors;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;FFFLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Switch.kt */
public final class SwitchKt {
    /* access modifiers changed from: private */
    public static final TweenSpec<Float> AnimationSpec = new TweenSpec(100, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    private static final float SwitchHeight = SwitchTokens.INSTANCE.m2689getTrackHeightD9Ej5fM();
    private static final float SwitchWidth = SwitchTokens.INSTANCE.m2691getTrackWidthD9Ej5fM();
    private static final float ThumbDiameter = SwitchTokens.INSTANCE.m2686getSelectedHandleWidthD9Ej5fM();
    private static final float ThumbPadding = Dp.m5986constructorimpl(Dp.m5986constructorimpl(SwitchHeight - ThumbDiameter) / ((float) 2));
    private static final float ThumbPathLength = Dp.m5986constructorimpl(Dp.m5986constructorimpl(SwitchWidth - ThumbDiameter) - ThumbPadding);
    private static final float UncheckedThumbDiameter = SwitchTokens.INSTANCE.m2693getUnselectedHandleWidthD9Ej5fM();

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v73, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v75, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v77, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0358  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0385  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x039c  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0467  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0473  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0477  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x04e8  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x04fb  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x05bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Switch(boolean r53, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r54, androidx.compose.ui.Modifier r55, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r56, boolean r57, androidx.compose.material3.SwitchColors r58, androidx.compose.foundation.interaction.MutableInteractionSource r59, androidx.compose.runtime.Composer r60, int r61, int r62) {
        /*
            r10 = r54
            r11 = r61
            r0 = 1580463220(0x5e33f474, float:3.24177919E18)
            r1 = r60
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Switch)P(!1,5,4,6,2)96@4503L8,97@4563L39,*106@4851L7,107@4926L7,108@4986L111,113@5161L36,114@5214L24,116@5244L156,121@5406L216,145@6082L759:Switch.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r61
            r2 = r62 & 1
            if (r2 == 0) goto L_0x001d
            r1 = r1 | 6
            r6 = r53
            goto L_0x0030
        L_0x001d:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x002e
            r6 = r53
            boolean r2 = r9.changed((boolean) r6)
            if (r2 == 0) goto L_0x002b
            r2 = 4
            goto L_0x002c
        L_0x002b:
            r2 = 2
        L_0x002c:
            r1 = r1 | r2
            goto L_0x0030
        L_0x002e:
            r6 = r53
        L_0x0030:
            r2 = r62 & 2
            if (r2 == 0) goto L_0x0037
            r1 = r1 | 48
            goto L_0x0047
        L_0x0037:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0047
            boolean r2 = r9.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x0044
            r2 = 32
            goto L_0x0046
        L_0x0044:
            r2 = 16
        L_0x0046:
            r1 = r1 | r2
        L_0x0047:
            r2 = r62 & 4
            if (r2 == 0) goto L_0x0050
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r55
            goto L_0x0065
        L_0x0050:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0063
            r3 = r55
            boolean r4 = r9.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005f
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r1 = r1 | r4
            goto L_0x0065
        L_0x0063:
            r3 = r55
        L_0x0065:
            r4 = r62 & 8
            if (r4 == 0) goto L_0x006e
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r56
            goto L_0x0083
        L_0x006e:
            r5 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0081
            r5 = r56
            boolean r12 = r9.changed((java.lang.Object) r5)
            if (r12 == 0) goto L_0x007d
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r1 = r1 | r12
            goto L_0x0083
        L_0x0081:
            r5 = r56
        L_0x0083:
            r12 = r62 & 16
            if (r12 == 0) goto L_0x008c
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r13 = r57
            goto L_0x00a3
        L_0x008c:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r11
            if (r13 != 0) goto L_0x00a1
            r13 = r57
            boolean r14 = r9.changed((boolean) r13)
            if (r14 == 0) goto L_0x009d
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r1 = r1 | r14
            goto L_0x00a3
        L_0x00a1:
            r13 = r57
        L_0x00a3:
            r49 = 458752(0x70000, float:6.42848E-40)
            r14 = r11 & r49
            if (r14 != 0) goto L_0x00be
            r14 = r62 & 32
            if (r14 != 0) goto L_0x00b8
            r15 = r58
            boolean r14 = r9.changed((java.lang.Object) r15)
            if (r14 == 0) goto L_0x00ba
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bc
        L_0x00b8:
            r15 = r58
        L_0x00ba:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00bc:
            r1 = r1 | r14
            goto L_0x00c0
        L_0x00be:
            r15 = r58
        L_0x00c0:
            r50 = r62 & 64
            r51 = 3670016(0x380000, float:5.142788E-39)
            if (r50 == 0) goto L_0x00cc
            r14 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r14
            r14 = r59
            goto L_0x00e2
        L_0x00cc:
            r14 = r11 & r51
            if (r14 != 0) goto L_0x00e0
            r14 = r59
            boolean r16 = r9.changed((java.lang.Object) r14)
            if (r16 == 0) goto L_0x00db
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dd
        L_0x00db:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00dd:
            r1 = r1 | r16
            goto L_0x00e2
        L_0x00e0:
            r14 = r59
        L_0x00e2:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r7 = r1 & r16
            r8 = 599186(0x92492, float:8.39638E-40)
            if (r7 != r8) goto L_0x0103
            boolean r7 = r9.getSkipping()
            if (r7 != 0) goto L_0x00f3
            goto L_0x0103
        L_0x00f3:
            r9.skipToGroupEnd()
            r48 = r1
            r36 = r3
            r11 = r5
            r26 = r13
            r28 = r14
            r27 = r15
            goto L_0x05bf
        L_0x0103:
            r9.startDefaults()
            r7 = r11 & 1
            r8 = -458753(0xfffffffffff8ffff, float:NaN)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            r15 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            if (r7 == 0) goto L_0x012c
            boolean r7 = r9.getDefaultsInvalid()
            if (r7 == 0) goto L_0x0119
            goto L_0x012c
        L_0x0119:
            r9.skipToGroupEnd()
            r2 = r62 & 32
            if (r2 == 0) goto L_0x0121
            r1 = r1 & r8
        L_0x0121:
            r27 = r58
            r15 = r1
            r7 = r3
            r8 = r5
            r26 = r13
            r28 = r14
            goto L_0x01bf
        L_0x012c:
            if (r2 == 0) goto L_0x0133
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0134
        L_0x0133:
            r2 = r3
        L_0x0134:
            if (r4 == 0) goto L_0x0138
            r3 = 0
            goto L_0x0139
        L_0x0138:
            r3 = r5
        L_0x0139:
            if (r12 == 0) goto L_0x013d
            r4 = 1
            goto L_0x013e
        L_0x013d:
            r4 = r13
        L_0x013e:
            r5 = r62 & 32
            if (r5 == 0) goto L_0x0176
            androidx.compose.material3.SwitchDefaults r12 = androidx.compose.material3.SwitchDefaults.INSTANCE
            r16 = 0
            r13 = r16
            r5 = r15
            r15 = r16
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
            r46 = 0
            r47 = 1572864(0x180000, float:2.204052E-39)
            r48 = 65535(0xffff, float:9.1834E-41)
            r45 = r9
            androidx.compose.material3.SwitchColors r7 = r12.m2113colorsV1nXRL4(r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43, r45, r46, r47, r48)
            r1 = r1 & r8
            goto L_0x0179
        L_0x0176:
            r5 = r15
            r7 = r58
        L_0x0179:
            if (r50 == 0) goto L_0x01b3
            r8 = 0
            r12 = 0
            r9.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r13 = 0
            r14 = r9
            r15 = 0
            java.lang.Object r5 = r14.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r55 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r5 != r1) goto L_0x01a0
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r14.updateRememberedValue(r1)
            goto L_0x01a1
        L_0x01a0:
            r1 = r5
        L_0x01a1:
            r9.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r15 = r55
            r28 = r1
            r8 = r3
            r26 = r4
            r27 = r7
            r7 = r2
            goto L_0x01bf
        L_0x01b3:
            r55 = r1
            r15 = r55
            r28 = r59
            r8 = r3
            r26 = r4
            r27 = r7
            r7 = r2
        L_0x01bf:
            r9.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01d1
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.Switch (Switch.kt:90)"
            r3 = 1580463220(0x5e33f474, float:3.24177919E18)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r15, r1, r2)
        L_0x01d1:
            if (r8 != 0) goto L_0x01d6
            float r1 = UncheckedThumbDiameter
            goto L_0x01d8
        L_0x01d6:
            float r1 = ThumbDiameter
        L_0x01d8:
            r29 = r1
            float r1 = SwitchHeight
            r2 = 0
            float r3 = r1 - r29
            float r1 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r3)
            r2 = 2
            r3 = 0
            float r4 = (float) r2
            float r4 = r1 / r4
            float r1 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r4)
            r14 = r1
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 0
            r3 = 0
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r13 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r12, r13)
            java.lang.Object r4 = r9.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r1 = r4
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            r2 = 0
            float r5 = r1.m5967toPx0680j_4(r14)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 0
            r3 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r12, r13)
            java.lang.Object r4 = r9.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r1 = r4
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            r2 = 0
            float r4 = ThumbPathLength
            float r3 = r1.m5967toPx0680j_4(r4)
            java.lang.Float r1 = java.lang.Float.valueOf(r5)
            java.lang.Float r2 = java.lang.Float.valueOf(r3)
            r12 = 0
            r17 = r12
            r18 = 0
            r12 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r9.startReplaceableGroup(r12)
            java.lang.String r12 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r12)
            boolean r12 = r9.changed((java.lang.Object) r1)
            boolean r19 = r9.changed((java.lang.Object) r2)
            r12 = r12 | r19
            r57 = r9
            r19 = 0
            r58 = r1
            java.lang.Object r1 = r57.rememberedValue()
            r20 = 0
            if (r12 != 0) goto L_0x026a
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r59 = r2
            java.lang.Object r2 = r21.getEmpty()
            if (r1 != r2) goto L_0x0265
            goto L_0x026c
        L_0x0265:
            r2 = r57
            r21 = r1
            goto L_0x027c
        L_0x026a:
            r59 = r2
        L_0x026c:
            r2 = 0
            r21 = r1
            androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1 r1 = new androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1
            r1.<init>(r3, r5)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r2 = r57
            r2.updateRememberedValue(r1)
        L_0x027c:
            r9.endReplaceableGroup()
            r12 = r1
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r53)
            java.lang.Object r1 = r12.invoke(r1)
            java.lang.Number r1 = (java.lang.Number) r1
            float r2 = r1.floatValue()
            r1 = 0
            r17 = r1
            r1 = 0
            r57 = r1
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r9.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r1 = 0
            r58 = r9
            r18 = 0
            r59 = r1
            java.lang.Object r1 = r58.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r3
            java.lang.Object r3 = r20.getEmpty()
            r11 = 0
            if (r1 != r3) goto L_0x02cb
            r3 = 0
            r20 = r1
            r1 = 0
            r22 = r3
            r3 = 2
            androidx.compose.animation.core.Animatable r1 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r2, r1, r3, r11)
            r3 = r58
            r3.updateRememberedValue(r1)
            goto L_0x02cf
        L_0x02cb:
            r3 = r58
            r20 = r1
        L_0x02cf:
            r9.endReplaceableGroup()
            r3 = r1
            androidx.compose.animation.core.Animatable r3 = (androidx.compose.animation.core.Animatable) r3
            r1 = 0
            r17 = r1
            r18 = 0
            r11 = 773894976(0x2e20b340, float:3.6538994E-11)
            r9.startReplaceableGroup(r11)
            java.lang.String r11 = "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r11)
            r11 = r9
            r19 = r1
            r1 = 0
            r58 = r1
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r9.startReplaceableGroup(r1)
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            r0 = 0
            r1 = r9
            r16 = 0
            r59 = r0
            java.lang.Object r0 = r1.rememberedValue()
            r20 = 0
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r23 = r4
            java.lang.Object r4 = r22.getEmpty()
            if (r0 != r4) goto L_0x032a
            r4 = 0
            r22 = 0
            kotlin.coroutines.EmptyCoroutineContext r22 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r24 = r0
            r0 = r22
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r11)
            r22 = r4
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r4 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r4.<init>(r0)
            r0 = r4
            r1.updateRememberedValue(r0)
            goto L_0x032c
        L_0x032a:
            r24 = r0
        L_0x032c:
            r9.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r1 = r0.getCoroutineScope()
            r9.endReplaceableGroup()
            r11 = r1
            androidx.compose.material3.SwitchKt$Switch$2 r0 = new androidx.compose.material3.SwitchKt$Switch$2
            r0.<init>(r3, r5)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r1 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r0, r9, r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r53)
            androidx.compose.material3.SwitchKt$Switch$3 r1 = new androidx.compose.material3.SwitchKt$Switch$3
            r1.<init>(r3, r2, r11)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r4 = r15 & 14
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r0, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r1, (androidx.compose.runtime.Composer) r9, (int) r4)
            if (r10 == 0) goto L_0x0385
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r1 = r1.m5318getSwitcho7Vup1c()
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r4 = 0
            androidx.compose.ui.semantics.Role r16 = androidx.compose.ui.semantics.Role.m5306boximpl(r1)
            r1 = r53
            r30 = r2
            r2 = r28
            r32 = r3
            r31 = r21
            r3 = r4
            r22 = r23
            r4 = r26
            r33 = r5
            r5 = r16
            r6 = r54
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.ToggleableKt.m1083toggleableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0393
        L_0x0385:
            r30 = r2
            r32 = r3
            r33 = r5
            r31 = r21
            r22 = r23
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x0393:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            if (r10 == 0) goto L_0x03a0
            androidx.compose.ui.Modifier r1 = androidx.compose.material3.TouchTargetKt.minimumTouchTargetSize(r1)
        L_0x03a0:
            androidx.compose.ui.Modifier r1 = r7.then(r1)
            androidx.compose.ui.Modifier r1 = r1.then(r0)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getCenter()
            r3 = 0
            r4 = 2
            r5 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r1, r2, r5, r4, r3)
            float r2 = SwitchWidth
            float r3 = SwitchHeight
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m824requiredSizeVpY3zN4(r1, r2, r3)
            r2 = r5
            r3 = 0
            r4 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r9.startReplaceableGroup(r4)
            java.lang.String r4 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r4)
            androidx.compose.ui.Alignment$Companion r4 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r4 = r4.getTopStart()
            r5 = 0
            int r6 = r2 >> 3
            r6 = r6 & 14
            int r16 = r2 >> 3
            r16 = r16 & 112(0x70, float:1.57E-43)
            r6 = r6 | r16
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r4, r5, r9, r6)
            int r16 = r2 << 3
            r16 = r16 & 112(0x70, float:1.57E-43)
            r34 = r16
            r35 = 0
            r56 = r0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r9.startReplaceableGroup(r0)
            java.lang.String r0 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r16 = 6
            r17 = 0
            r57 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r3, r13)
            java.lang.Object r3 = r9.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r0 = r3
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r16 = 6
            r17 = 0
            r58 = r4
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r4, r13)
            java.lang.Object r4 = r9.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r3 = r4
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r16 = 6
            r17 = 0
            r59 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r5, r13)
            java.lang.Object r5 = r9.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r4 = r5
            androidx.compose.ui.platform.ViewConfiguration r4 = (androidx.compose.ui.platform.ViewConfiguration) r4
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r5 = r5.getConstructor()
            kotlin.jvm.functions.Function3 r13 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            r55 = r1
            int r1 = r34 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r36 = r7
            r7 = 6
            r1 = r1 | r7
            r37 = 0
            androidx.compose.runtime.Applier r7 = r9.getApplier()
            boolean r7 = r7 instanceof androidx.compose.runtime.Applier
            if (r7 != 0) goto L_0x046a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x046a:
            r9.startReusableNode()
            boolean r7 = r9.getInserting()
            if (r7 == 0) goto L_0x0477
            r9.createNode(r5)
            goto L_0x047a
        L_0x0477:
            r9.useNode()
        L_0x047a:
            r9.disableReusing()
            androidx.compose.runtime.Composer r7 = androidx.compose.runtime.Updater.m2787constructorimpl(r9)
            r17 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r18 = androidx.compose.ui.node.ComposeUiNode.Companion
            r38 = r5
            kotlin.jvm.functions.Function2 r5 = r18.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r7, r6, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r7, r0, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r7, r3, r5)
            androidx.compose.ui.node.ComposeUiNode$Companion r5 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r5 = r5.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r7, r4, r5)
            r9.enableReusing()
            androidx.compose.runtime.Composer r5 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r9)
            androidx.compose.runtime.SkippableUpdater r5 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r5)
            int r7 = r1 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r13.invoke(r5, r9, r7)
            r5 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r9.startReplaceableGroup(r5)
            int r5 = r1 >> 9
            r5 = r5 & 14
            r7 = r9
            r39 = 0
            r40 = r0
            r0 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r7.startReplaceableGroup(r0)
            java.lang.String r0 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r0)
            r0 = r5 & 11
            r41 = r1
            r1 = 2
            if (r0 != r1) goto L_0x04fb
            boolean r0 = r7.getSkipping()
            if (r0 != 0) goto L_0x04e8
            goto L_0x04fb
        L_0x04e8:
            r7.skipToGroupEnd()
            r45 = r2
            r60 = r3
            r43 = r4
            r46 = r5
            r4 = r12
            r5 = r13
            r47 = r14
            r48 = r15
            goto L_0x05a3
        L_0x04fb:
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r17 = r2 >> 6
            r17 = r17 & 112(0x70, float:1.57E-43)
            r16 = 6
            r42 = r17 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r43 = r7
            r44 = 0
            r1 = 1204996270(0x47d2c8ae, float:107921.36)
            r45 = r2
            r2 = r43
            r2.startReplaceableGroup(r1)
            java.lang.String r1 = "C160@6631L9,154@6384L451:Switch.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            r1 = r42
            r17 = r42 & 14
            if (r17 != 0) goto L_0x052d
            boolean r17 = r2.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x0529
            r52 = 4
            goto L_0x052b
        L_0x0529:
            r52 = 2
        L_0x052b:
            r1 = r1 | r52
        L_0x052d:
            r60 = r3
            r3 = r1 & 91
            r43 = r4
            r4 = 18
            if (r3 != r4) goto L_0x054a
            boolean r3 = r2.getSkipping()
            if (r3 != 0) goto L_0x053e
            goto L_0x054a
        L_0x053e:
            r2.skipToGroupEnd()
            r46 = r5
            r4 = r12
            r5 = r13
            r47 = r14
            r48 = r15
            goto L_0x059f
        L_0x054a:
            androidx.compose.runtime.State r3 = r32.asState()
            androidx.compose.material3.tokens.SwitchTokens r4 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r4 = r4.getHandleShape()
            r46 = r5
            r5 = 6
            androidx.compose.ui.graphics.Shape r19 = androidx.compose.material3.ShapesKt.toShape(r4, r2, r5)
            r18 = r28
            androidx.compose.foundation.interaction.InteractionSource r18 = (androidx.compose.foundation.interaction.InteractionSource) r18
            r4 = r1 & 14
            int r5 = r15 << 3
            r5 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            int r5 = r15 >> 6
            r5 = r5 & 896(0x380, float:1.256E-42)
            r4 = r4 | r5
            int r5 = r15 >> 6
            r5 = r5 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r5
            int r5 = r15 << 6
            r5 = r5 & r49
            r4 = r4 | r5
            r5 = r15 & r51
            r24 = r4 | r5
            r25 = 6
            r4 = r12
            r12 = r0
            r5 = r13
            r13 = r53
            r47 = r14
            r14 = r26
            r48 = r15
            r15 = r27
            r16 = r3
            r17 = r8
            r20 = r29
            r21 = r47
            r23 = r2
            m2115SwitchImpl0DmnUew(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
        L_0x059f:
            r2.endReplaceableGroup()
        L_0x05a3:
            r7.endReplaceableGroup()
            r9.endReplaceableGroup()
            r9.endNode()
            r9.endReplaceableGroup()
            r9.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x05be
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x05be:
            r11 = r8
        L_0x05bf:
            androidx.compose.runtime.ScopeUpdateScope r12 = r9.endRestartGroup()
            if (r12 != 0) goto L_0x05c7
            r14 = r9
            goto L_0x05e4
        L_0x05c7:
            androidx.compose.material3.SwitchKt$Switch$5 r13 = new androidx.compose.material3.SwitchKt$Switch$5
            r0 = r13
            r1 = r53
            r2 = r54
            r3 = r36
            r4 = r11
            r5 = r26
            r6 = r27
            r7 = r28
            r8 = r61
            r14 = r9
            r9 = r62
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x05e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwitchKt.Switch(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, boolean, androidx.compose.material3.SwitchColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x056d  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0579  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x057d  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x05ee  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x05fd  */
    /* renamed from: SwitchImpl-0DmnUew  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2115SwitchImpl0DmnUew(androidx.compose.foundation.layout.BoxScope r65, boolean r66, boolean r67, androidx.compose.material3.SwitchColors r68, androidx.compose.runtime.State<java.lang.Float> r69, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r70, androidx.compose.foundation.interaction.InteractionSource r71, androidx.compose.ui.graphics.Shape r72, float r73, float r74, float r75, androidx.compose.runtime.Composer r76, int r77, int r78) {
        /*
            r14 = r65
            r15 = r66
            r13 = r67
            r12 = r68
            r11 = r70
            r10 = r71
            r9 = r72
            r8 = r73
            r7 = r74
            r6 = r75
            r5 = r77
            r0 = -1968109941(0xffffffff8ab1068b, float:-1.7046941E-32)
            r1 = r76
            androidx.compose.runtime.Composer r4 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SwitchImpl)P(!1,2!1,8,6!1,7,9:c#ui.unit.Dp,5:c#ui.unit.Dp,4:c#ui.unit.Dp)183@7283L28,184@7351L25,*186@7419L7,206@8052L9,213@8261L29,218@8380L951:Switch.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r1)
            r1 = r77
            r2 = r78
            r3 = r5 & 14
            r16 = 4
            if (r3 != 0) goto L_0x0039
            boolean r3 = r4.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x0037
            r3 = r16
            goto L_0x0038
        L_0x0037:
            r3 = 2
        L_0x0038:
            r1 = r1 | r3
        L_0x0039:
            r3 = r5 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0049
            boolean r3 = r4.changed((boolean) r15)
            if (r3 == 0) goto L_0x0046
            r3 = 32
            goto L_0x0048
        L_0x0046:
            r3 = 16
        L_0x0048:
            r1 = r1 | r3
        L_0x0049:
            r3 = r5 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0059
            boolean r3 = r4.changed((boolean) r13)
            if (r3 == 0) goto L_0x0056
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0058
        L_0x0056:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0058:
            r1 = r1 | r3
        L_0x0059:
            r3 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0069
            boolean r3 = r4.changed((java.lang.Object) r12)
            if (r3 == 0) goto L_0x0066
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0068
        L_0x0066:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x0068:
            r1 = r1 | r3
        L_0x0069:
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r5
            if (r3 != 0) goto L_0x007f
            r3 = r69
            boolean r18 = r4.changed((java.lang.Object) r3)
            if (r18 == 0) goto L_0x007a
            r18 = 16384(0x4000, float:2.2959E-41)
            goto L_0x007c
        L_0x007a:
            r18 = 8192(0x2000, float:1.14794E-41)
        L_0x007c:
            r1 = r1 | r18
            goto L_0x0081
        L_0x007f:
            r3 = r69
        L_0x0081:
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r5 & r18
            if (r18 != 0) goto L_0x0094
            boolean r18 = r4.changed((java.lang.Object) r11)
            if (r18 == 0) goto L_0x0090
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0092
        L_0x0090:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x0092:
            r1 = r1 | r18
        L_0x0094:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r5 & r18
            if (r18 != 0) goto L_0x00a7
            boolean r18 = r4.changed((java.lang.Object) r10)
            if (r18 == 0) goto L_0x00a3
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00a5
        L_0x00a3:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00a5:
            r1 = r1 | r18
        L_0x00a7:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r5 & r18
            if (r18 != 0) goto L_0x00ba
            boolean r18 = r4.changed((java.lang.Object) r9)
            if (r18 == 0) goto L_0x00b6
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00b8
        L_0x00b6:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00b8:
            r1 = r1 | r18
        L_0x00ba:
            r18 = 234881024(0xe000000, float:1.5777218E-30)
            r18 = r5 & r18
            if (r18 != 0) goto L_0x00cd
            boolean r18 = r4.changed((float) r8)
            if (r18 == 0) goto L_0x00c9
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00cb
        L_0x00c9:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00cb:
            r1 = r1 | r18
        L_0x00cd:
            r18 = 1879048192(0x70000000, float:1.58456325E29)
            r18 = r5 & r18
            if (r18 != 0) goto L_0x00e0
            boolean r18 = r4.changed((float) r7)
            if (r18 == 0) goto L_0x00dc
            r18 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x00de
        L_0x00dc:
            r18 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x00de:
            r1 = r1 | r18
        L_0x00e0:
            r18 = r78 & 14
            if (r18 != 0) goto L_0x00f1
            boolean r18 = r4.changed((float) r6)
            if (r18 == 0) goto L_0x00ed
            r18 = r16
            goto L_0x00ef
        L_0x00ed:
            r18 = 2
        L_0x00ef:
            r2 = r2 | r18
        L_0x00f1:
            r18 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r0 = r1 & r18
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r3) goto L_0x010f
            r0 = r2 & 11
            r3 = 2
            if (r0 != r3) goto L_0x010f
            boolean r0 = r4.getSkipping()
            if (r0 != 0) goto L_0x0107
            goto L_0x010f
        L_0x0107:
            r4.skipToGroupEnd()
            r18 = r2
            r3 = r11
            goto L_0x06ab
        L_0x010f:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x011d
            java.lang.String r0 = "androidx.compose.material3.SwitchImpl (Switch.kt:171)"
            r3 = -1968109941(0xffffffff8ab1068b, float:-1.7046941E-32)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r2, r0)
        L_0x011d:
            int r0 = r1 >> 6
            r0 = r0 & 14
            r3 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r3
            int r3 = r1 >> 3
            r3 = r3 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            androidx.compose.runtime.State r0 = r12.trackColor$material3_release(r13, r15, r4, r0)
            int r3 = r1 >> 18
            r3 = r3 & 14
            androidx.compose.runtime.State r3 = androidx.compose.foundation.interaction.PressInteractionKt.collectIsPressedAsState(r10, r4, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r18 = r2
            r2 = r17
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r17 = 0
            r20 = 0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r11 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r5, r11)
            java.lang.Object r21 = r4.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r2 = r21
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            r17 = 0
            java.lang.Object r20 = r69.getValue()
            java.lang.Number r20 = (java.lang.Number) r20
            float r5 = r20.floatValue()
            float r2 = r2.m5963toDpu2uoSUM((float) r5)
            boolean r5 = m2118SwitchImpl_0DmnUew$lambda7(r3)
            if (r5 == 0) goto L_0x0173
            androidx.compose.material3.tokens.SwitchTokens r5 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            float r5 = r5.m2684getPressedHandleWidthD9Ej5fM()
            goto L_0x01a6
        L_0x0173:
            float r5 = ThumbDiameter
            r17 = 0
            float r20 = r5 - r8
            float r5 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r20)
            r17 = 0
            float r20 = r2 - r7
            float r17 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r20)
            r20 = 0
            float r22 = r6 - r7
            float r20 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r22)
            r22 = 0
            float r17 = r17 / r20
            r20 = 0
            float r22 = r5 * r17
            float r5 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r22)
            r17 = 0
            float r20 = r8 + r5
            float r20 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r20)
            r5 = r20
        L_0x01a6:
            r17 = r2
            r2 = -993794194(0xffffffffc4c3e76e, float:-1567.2322)
            r4.startReplaceableGroup(r2)
            java.lang.String r2 = "*195@7760L7"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r2)
            boolean r2 = m2118SwitchImpl_0DmnUew$lambda7(r3)
            if (r2 == 0) goto L_0x01fd
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r20 = 0
            r22 = 0
            r23 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r3, r11)
            java.lang.Object r3 = r4.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r2 = r3
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            r3 = 0
            if (r15 == 0) goto L_0x01ee
            float r20 = ThumbPathLength
            androidx.compose.material3.tokens.SwitchTokens r22 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            float r22 = r22.m2690getTrackOutlineWidthD9Ej5fM()
            r24 = 0
            float r25 = r20 - r22
            float r20 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r25)
            r22 = r3
            r3 = r20
            goto L_0x01f8
        L_0x01ee:
            androidx.compose.material3.tokens.SwitchTokens r20 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            float r20 = r20.m2690getTrackOutlineWidthD9Ej5fM()
            r22 = r3
            r3 = r20
        L_0x01f8:
            float r2 = r2.m5967toPx0680j_4(r3)
            goto L_0x0209
        L_0x01fd:
            r23 = r3
            java.lang.Object r2 = r69.getValue()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
        L_0x0209:
            r4.endReplaceableGroup()
            androidx.compose.material3.tokens.SwitchTokens r3 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            androidx.compose.material3.tokens.ShapeKeyTokens r3 = r3.getTrackShape()
            r6 = 6
            androidx.compose.ui.graphics.Shape r3 = androidx.compose.material3.ShapesKt.toShape(r3, r4, r6)
            androidx.compose.ui.Modifier$Companion r20 = androidx.compose.ui.Modifier.Companion
            r6 = r20
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.ui.Alignment$Companion r20 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r20.getCenter()
            androidx.compose.ui.Modifier r6 = r14.align(r6, r7)
            float r7 = SwitchWidth
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m835width3ABfNKs(r6, r7)
            float r7 = SwitchHeight
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m816height3ABfNKs(r6, r7)
            androidx.compose.material3.tokens.SwitchTokens r7 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            float r7 = r7.m2690getTrackOutlineWidthD9Ej5fM()
            int r20 = r1 >> 6
            r20 = r20 & 14
            r24 = r1 & 112(0x70, float:1.57E-43)
            r20 = r20 | r24
            int r8 = r1 >> 3
            r8 = r8 & 896(0x380, float:1.256E-42)
            r8 = r20 | r8
            androidx.compose.runtime.State r8 = r12.borderColor$material3_release(r13, r15, r4, r8)
            java.lang.Object r8 = r8.getValue()
            androidx.compose.ui.graphics.Color r8 = (androidx.compose.ui.graphics.Color) r8
            long r8 = r8.m3174unboximpl()
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.BorderKt.m459borderxT4_qwU(r6, r7, r8, r3)
            long r7 = m2117SwitchImpl_0DmnUew$lambda6(r0)
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.BackgroundKt.m448backgroundbw27NRU(r6, r7, r3)
            r7 = 0
            r8 = r7
            r9 = 0
            r7 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r4.startReplaceableGroup(r7)
            java.lang.String r7 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r7)
            androidx.compose.ui.Alignment$Companion r25 = androidx.compose.ui.Alignment.Companion
            r26 = r0
            androidx.compose.ui.Alignment r0 = r25.getTopStart()
            r25 = r3
            r3 = 0
            int r27 = r8 >> 3
            r27 = r27 & 14
            int r28 = r8 >> 3
            r28 = r28 & 112(0x70, float:1.57E-43)
            r29 = r9
            r9 = r27 | r28
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r0, r3, r4, r9)
            int r27 = r8 << 3
            r27 = r27 & 112(0x70, float:1.57E-43)
            r28 = 0
            r30 = r0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r4.startReplaceableGroup(r0)
            java.lang.String r0 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r32 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            r33 = r3
            r3 = r32
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r32 = 6
            r34 = 0
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r14, r11)
            java.lang.Object r14 = r4.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r3 = r14
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r32 = 6
            r34 = 0
            r35 = r0
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r11)
            java.lang.Object r0 = r4.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.unit.LayoutDirection r0 = (androidx.compose.ui.unit.LayoutDirection) r0
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r32 = 6
            r34 = 0
            r36 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r7, r11)
            java.lang.Object r7 = r4.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r14 = r14.getConstructor()
            kotlin.jvm.functions.Function3 r32 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            r34 = r6
            int r6 = r27 << 9
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r22 = 6
            r6 = r6 | 6
            r37 = r32
            r32 = 0
            r38 = r11
            androidx.compose.runtime.Applier r11 = r4.getApplier()
            boolean r11 = r11 instanceof androidx.compose.runtime.Applier
            if (r11 != 0) goto L_0x031b
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x031b:
            r4.startReusableNode()
            boolean r11 = r4.getInserting()
            if (r11 == 0) goto L_0x0328
            r4.createNode(r14)
            goto L_0x032b
        L_0x0328:
            r4.useNode()
        L_0x032b:
            r4.disableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.Updater.m2787constructorimpl(r4)
            r39 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r40 = androidx.compose.ui.node.ComposeUiNode.Companion
            r41 = r14
            kotlin.jvm.functions.Function2 r14 = r40.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r11, r9, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r11, r3, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r11, r0, r14)
            androidx.compose.ui.node.ComposeUiNode$Companion r14 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r14 = r14.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r11, r7, r14)
            r4.enableReusing()
            androidx.compose.runtime.Composer r11 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r4)
            androidx.compose.runtime.SkippableUpdater r11 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r11)
            int r14 = r6 >> 3
            r14 = r14 & 112(0x70, float:1.57E-43)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r39 = r0
            r0 = r37
            r0.invoke(r11, r4, r14)
            r11 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r4.startReplaceableGroup(r11)
            int r14 = r6 >> 9
            r14 = r14 & 14
            r37 = r4
            r40 = 0
            r11 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r43 = r0
            r0 = r37
            r0.startReplaceableGroup(r11)
            java.lang.String r11 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r11)
            r11 = r14 & 11
            r44 = r3
            r3 = 2
            if (r11 != r3) goto L_0x03b5
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L_0x03a0
            goto L_0x03b5
        L_0x03a0:
            r0.skipToGroupEnd()
            r3 = r70
            r61 = r2
            r46 = r5
            r54 = r6
            r55 = r7
            r16 = r8
            r56 = r9
            r38 = r14
            goto L_0x0690
        L_0x03b5:
            androidx.compose.foundation.layout.BoxScopeInstance r3 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r11 = r8 >> 6
            r11 = r11 & 112(0x70, float:1.57E-43)
            r22 = 6
            r11 = r11 | 6
            androidx.compose.foundation.layout.BoxScope r3 = (androidx.compose.foundation.layout.BoxScope) r3
            r52 = r0
            r53 = 0
            r54 = r6
            r6 = 968687813(0x39bd00c5, float:3.6049463E-4)
            r55 = r7
            r7 = r52
            r7.startReplaceableGroup(r6)
            java.lang.String r6 = "C219@8429L28,224@8617L42,227@8781L64,221@8510L815:Switch.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r6)
            r6 = r11
            r45 = r11 & 14
            if (r45 != 0) goto L_0x03e6
            boolean r45 = r7.changed((java.lang.Object) r3)
            if (r45 == 0) goto L_0x03e2
            goto L_0x03e4
        L_0x03e2:
            r16 = 2
        L_0x03e4:
            r6 = r6 | r16
        L_0x03e6:
            r16 = r8
            r8 = r6 & 91
            r52 = r6
            r6 = 18
            if (r8 != r6) goto L_0x040a
            boolean r6 = r7.getSkipping()
            if (r6 != 0) goto L_0x03f7
            goto L_0x040a
        L_0x03f7:
            r7.skipToGroupEnd()
            r61 = r2
            r59 = r3
            r46 = r5
            r56 = r9
            r58 = r11
            r38 = r14
            r3 = r70
            goto L_0x068c
        L_0x040a:
            int r6 = r1 >> 6
            r6 = r6 & 14
            r8 = r1 & 112(0x70, float:1.57E-43)
            r6 = r6 | r8
            int r8 = r1 >> 3
            r8 = r8 & 896(0x380, float:1.256E-42)
            r6 = r6 | r8
            androidx.compose.runtime.State r6 = r12.thumbColor$material3_release(r13, r15, r7, r6)
            r56 = r9
            long r8 = m2116SwitchImpl_0DmnUew$lambda13$lambda10(r6)
            androidx.compose.ui.Modifier$Companion r45 = androidx.compose.ui.Modifier.Companion
            r57 = r6
            r6 = r45
            androidx.compose.ui.Modifier r6 = (androidx.compose.ui.Modifier) r6
            androidx.compose.ui.Alignment$Companion r45 = androidx.compose.ui.Alignment.Companion
            r58 = r11
            androidx.compose.ui.Alignment r11 = r45.getCenterStart()
            androidx.compose.ui.Modifier r6 = r3.align(r6, r11)
            java.lang.Float r11 = java.lang.Float.valueOf(r2)
            r20 = 0
            r45 = r20
            r46 = 0
            r59 = r3
            r3 = 1157296644(0x44faf204, float:2007.563)
            r7.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r3)
            boolean r3 = r7.changed((java.lang.Object) r11)
            r47 = r7
            r48 = 0
            r49 = r11
            java.lang.Object r11 = r47.rememberedValue()
            r50 = 0
            if (r3 != 0) goto L_0x046f
            androidx.compose.runtime.Composer$Companion r51 = androidx.compose.runtime.Composer.Companion
            r60 = r3
            java.lang.Object r3 = r51.getEmpty()
            if (r11 != r3) goto L_0x0469
            goto L_0x0471
        L_0x0469:
            r61 = r2
            r3 = r11
            r2 = r47
            goto L_0x0483
        L_0x046f:
            r60 = r3
        L_0x0471:
            r3 = 0
            r51 = r3
            androidx.compose.material3.SwitchKt$SwitchImpl$1$1$1 r3 = new androidx.compose.material3.SwitchKt$SwitchImpl$1$1$1
            r3.<init>(r2)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r61 = r2
            r2 = r47
            r2.updateRememberedValue(r3)
        L_0x0483:
            r7.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.OffsetKt.offset(r6, r3)
            r45 = 0
            androidx.compose.material3.tokens.SwitchTokens r3 = androidx.compose.material3.tokens.SwitchTokens.INSTANCE
            float r3 = r3.m2688getStateLayerSizeD9Ej5fM()
            r6 = 2
            r11 = 0
            r46 = r11
            float r11 = (float) r6
            float r11 = r3 / r11
            float r46 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r11)
            r47 = 0
            r50 = 54
            r51 = 4
            r49 = r7
            androidx.compose.foundation.Indication r3 = androidx.compose.material.ripple.RippleKt.m1729rememberRipple9IZ8Weo(r45, r46, r47, r49, r50, r51)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.IndicationKt.indication(r2, r10, r3)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m822requiredSize3ABfNKs(r2, r5)
            r11 = r72
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.BackgroundKt.m448backgroundbw27NRU(r2, r8, r11)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getCenter()
            r6 = 48
            r45 = 0
            r46 = r5
            r5 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r7.startReplaceableGroup(r5)
            r5 = r36
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r5)
            r5 = 0
            int r24 = r6 >> 3
            r24 = r24 & 14
            int r36 = r6 >> 3
            r36 = r36 & 112(0x70, float:1.57E-43)
            r47 = r8
            r8 = r24 | r36
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r5, r7, r8)
            int r9 = r6 << 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            r24 = 0
            r36 = r3
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r7.startReplaceableGroup(r3)
            r3 = r35
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r31 = 6
            r35 = 0
            r49 = r5
            r5 = r38
            r10 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r10, r5)
            java.lang.Object r10 = r7.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r3 = r10
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r31 = 6
            r35 = 0
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r11, r5)
            java.lang.Object r11 = r7.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r10 = r11
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r31 = 6
            r35 = 0
            r38 = r14
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r14, r5)
            java.lang.Object r5 = r7.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r14 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
            r21 = r2
            int r2 = r9 << 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r22 = 6
            r2 = r2 | 6
            r31 = 0
            r35 = r9
            androidx.compose.runtime.Applier r9 = r7.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x0570
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0570:
            r7.startReusableNode()
            boolean r9 = r7.getInserting()
            if (r9 == 0) goto L_0x057d
            r7.createNode(r11)
            goto L_0x0580
        L_0x057d:
            r7.useNode()
        L_0x0580:
            r7.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m2787constructorimpl(r7)
            r50 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r51 = androidx.compose.ui.node.ComposeUiNode.Companion
            r60 = r11
            kotlin.jvm.functions.Function2 r11 = r51.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r9, r8, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r9, r3, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r9, r10, r11)
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r11 = r11.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r9, r5, r11)
            r7.enableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r7)
            androidx.compose.runtime.SkippableUpdater r9 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r9)
            int r11 = r2 >> 3
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r14.invoke(r9, r7, r11)
            r9 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r7.startReplaceableGroup(r9)
            int r9 = r2 >> 9
            r9 = r9 & 14
            r11 = r7
            r42 = 0
            r50 = r2
            r2 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r11.startReplaceableGroup(r2)
            java.lang.String r2 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r2)
            r2 = r9 & 11
            r37 = r3
            r3 = 2
            if (r2 != r3) goto L_0x05fd
            boolean r2 = r11.getSkipping()
            if (r2 != 0) goto L_0x05ee
            goto L_0x05fd
        L_0x05ee:
            r11.skipToGroupEnd()
            r3 = r70
            r62 = r5
            r19 = r6
            r63 = r8
            r64 = r9
            goto L_0x067a
        L_0x05fd:
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r3 = r6 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r22 = 6
            r3 = r3 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r76 = r11
            r22 = 0
            r51 = r2
            r2 = 881862015(0x3490257f, float:2.6849372E-7)
            r62 = r5
            r5 = r76
            r5.startReplaceableGroup(r2)
            java.lang.String r2 = "C234@9107L27,235@9151L150:Switch.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r2)
            r2 = r3 & 81
            r76 = r3
            r3 = 16
            if (r2 != r3) goto L_0x0639
            boolean r2 = r5.getSkipping()
            if (r2 != 0) goto L_0x062d
            goto L_0x0639
        L_0x062d:
            r5.skipToGroupEnd()
            r3 = r70
            r19 = r6
            r63 = r8
            r64 = r9
            goto L_0x0676
        L_0x0639:
            r3 = r70
            if (r3 == 0) goto L_0x0670
            int r2 = r1 >> 6
            r2 = r2 & 14
            r19 = r1 & 112(0x70, float:1.57E-43)
            r2 = r2 | r19
            r19 = r6
            int r6 = r1 >> 3
            r6 = r6 & 896(0x380, float:1.256E-42)
            r2 = r2 | r6
            androidx.compose.runtime.State r2 = r12.iconColor$material3_release(r13, r15, r5, r2)
            r6 = 1
            androidx.compose.runtime.ProvidedValue[] r6 = new androidx.compose.runtime.ProvidedValue[r6]
            r63 = r8
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            r64 = r9
            java.lang.Object r9 = r2.getValue()
            androidx.compose.runtime.ProvidedValue r8 = r8.provides(r9)
            r9 = 0
            r6[r9] = r8
            int r8 = r1 >> 12
            r8 = r8 & 112(0x70, float:1.57E-43)
            r8 = r8 | 8
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r6, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r3, (androidx.compose.runtime.Composer) r5, (int) r8)
            goto L_0x0676
        L_0x0670:
            r19 = r6
            r63 = r8
            r64 = r9
        L_0x0676:
            r5.endReplaceableGroup()
        L_0x067a:
            r11.endReplaceableGroup()
            r7.endReplaceableGroup()
            r7.endNode()
            r7.endReplaceableGroup()
            r7.endReplaceableGroup()
        L_0x068c:
            r7.endReplaceableGroup()
        L_0x0690:
            r0.endReplaceableGroup()
            r4.endReplaceableGroup()
            r4.endNode()
            r4.endReplaceableGroup()
            r4.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x06ab
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x06ab:
            androidx.compose.runtime.ScopeUpdateScope r14 = r4.endRestartGroup()
            if (r14 != 0) goto L_0x06b6
            r17 = r1
            r19 = r4
            goto L_0x06e2
        L_0x06b6:
            androidx.compose.material3.SwitchKt$SwitchImpl$2 r16 = new androidx.compose.material3.SwitchKt$SwitchImpl$2
            r0 = r16
            r17 = r1
            r1 = r65
            r2 = r66
            r3 = r67
            r19 = r4
            r4 = r68
            r5 = r69
            r6 = r70
            r7 = r71
            r8 = r72
            r9 = r73
            r10 = r74
            r11 = r75
            r12 = r77
            r13 = r78
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r14.updateScope(r0)
        L_0x06e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SwitchKt.m2115SwitchImpl0DmnUew(androidx.compose.foundation.layout.BoxScope, boolean, boolean, androidx.compose.material3.SwitchColors, androidx.compose.runtime.State, kotlin.jvm.functions.Function2, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.ui.graphics.Shape, float, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: SwitchImpl_0DmnUew$lambda-6  reason: not valid java name */
    private static final long m2117SwitchImpl_0DmnUew$lambda6(State<Color> $trackColor$delegate) {
        return ((Color) $trackColor$delegate.getValue()).m3174unboximpl();
    }

    /* renamed from: SwitchImpl_0DmnUew$lambda-7  reason: not valid java name */
    private static final boolean m2118SwitchImpl_0DmnUew$lambda7(State<Boolean> $isPressed$delegate) {
        return ((Boolean) $isPressed$delegate.getValue()).booleanValue();
    }

    /* renamed from: SwitchImpl_0DmnUew$lambda-13$lambda-10  reason: not valid java name */
    private static final long m2116SwitchImpl_0DmnUew$lambda13$lambda10(State<Color> $thumbColor$delegate) {
        return ((Color) $thumbColor$delegate.getValue()).m3174unboximpl();
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getUncheckedThumbDiameter() {
        return UncheckedThumbDiameter;
    }
}
