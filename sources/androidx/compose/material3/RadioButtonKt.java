package androidx.compose.material3;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"RadioAnimationDuration", "", "RadioButtonDotSize", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioStrokeWidth", "RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/RadioButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/RadioButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: RadioButton.kt */
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize = Dp.m5986constructorimpl((float) 12);
    private static final float RadioButtonPadding = Dp.m5986constructorimpl((float) 2);
    /* access modifiers changed from: private */
    public static final float RadioStrokeWidth = Dp.m5986constructorimpl((float) 2);

    /* JADX WARNING: Removed duplicated region for block: B:117:0x029c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RadioButton(boolean r28, kotlin.jvm.functions.Function0<kotlin.Unit> r29, androidx.compose.ui.Modifier r30, boolean r31, androidx.compose.material3.RadioButtonColors r32, androidx.compose.foundation.interaction.MutableInteractionSource r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r9 = r28
            r10 = r29
            r11 = r35
            r0 = 408580840(0x185a72e8, float:2.8233852E-24)
            r1 = r34
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(RadioButton)P(5,4,3,1)77@3761L8,78@3821L39,80@3885L164,84@4078L29,114@5045L415,101@4636L824:RadioButton.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r35
            r2 = r36 & 1
            if (r2 == 0) goto L_0x001d
            r1 = r1 | 6
            goto L_0x002b
        L_0x001d:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x002b
            boolean r2 = r8.changed((boolean) r9)
            if (r2 == 0) goto L_0x0029
            r2 = 4
            goto L_0x002a
        L_0x0029:
            r2 = 2
        L_0x002a:
            r1 = r1 | r2
        L_0x002b:
            r2 = r36 & 2
            if (r2 == 0) goto L_0x0032
            r1 = r1 | 48
            goto L_0x0042
        L_0x0032:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0042
            boolean r2 = r8.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x003f
            r2 = 32
            goto L_0x0041
        L_0x003f:
            r2 = 16
        L_0x0041:
            r1 = r1 | r2
        L_0x0042:
            r2 = r36 & 4
            if (r2 == 0) goto L_0x004b
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r30
            goto L_0x0060
        L_0x004b:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x005e
            r3 = r30
            boolean r4 = r8.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x005a
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x005a:
            r4 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r1 = r1 | r4
            goto L_0x0060
        L_0x005e:
            r3 = r30
        L_0x0060:
            r4 = r36 & 8
            if (r4 == 0) goto L_0x0069
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r31
            goto L_0x007e
        L_0x0069:
            r5 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x007c
            r5 = r31
            boolean r6 = r8.changed((boolean) r5)
            if (r6 == 0) goto L_0x0078
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r1 = r1 | r6
            goto L_0x007e
        L_0x007c:
            r5 = r31
        L_0x007e:
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r11
            if (r6 != 0) goto L_0x0099
            r6 = r36 & 16
            if (r6 != 0) goto L_0x0093
            r6 = r32
            boolean r12 = r8.changed((java.lang.Object) r6)
            if (r12 == 0) goto L_0x0095
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r6 = r32
        L_0x0095:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r1 = r1 | r12
            goto L_0x009b
        L_0x0099:
            r6 = r32
        L_0x009b:
            r24 = r36 & 32
            if (r24 == 0) goto L_0x00a5
            r12 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r12
            r15 = r33
            goto L_0x00bb
        L_0x00a5:
            r12 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r11
            if (r12 != 0) goto L_0x00b9
            r15 = r33
            boolean r12 = r8.changed((java.lang.Object) r15)
            if (r12 == 0) goto L_0x00b5
            r12 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b7
        L_0x00b5:
            r12 = 65536(0x10000, float:9.18355E-41)
        L_0x00b7:
            r1 = r1 | r12
            goto L_0x00bb
        L_0x00b9:
            r15 = r33
        L_0x00bb:
            r12 = 374491(0x5b6db, float:5.24774E-40)
            r12 = r12 & r1
            r13 = 74898(0x12492, float:1.04954E-40)
            if (r12 != r13) goto L_0x00d5
            boolean r12 = r8.getSkipping()
            if (r12 != 0) goto L_0x00cb
            goto L_0x00d5
        L_0x00cb:
            r8.skipToGroupEnd()
            r19 = r1
            r12 = r3
            r13 = r5
            r14 = r6
            goto L_0x029f
        L_0x00d5:
            r8.startDefaults()
            r12 = r11 & 1
            r25 = -57345(0xffffffffffff1fff, float:NaN)
            if (r12 == 0) goto L_0x00f5
            boolean r12 = r8.getDefaultsInvalid()
            if (r12 == 0) goto L_0x00e6
            goto L_0x00f5
        L_0x00e6:
            r8.skipToGroupEnd()
            r2 = r36 & 16
            if (r2 == 0) goto L_0x00ef
            r1 = r1 & r25
        L_0x00ef:
            r7 = r1
            r12 = r3
            r13 = r5
            r14 = r6
            goto L_0x015e
        L_0x00f5:
            if (r2 == 0) goto L_0x00fc
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00fd
        L_0x00fc:
            r2 = r3
        L_0x00fd:
            if (r4 == 0) goto L_0x0101
            r3 = 1
            goto L_0x0102
        L_0x0101:
            r3 = r5
        L_0x0102:
            r4 = r36 & 16
            if (r4 == 0) goto L_0x011e
            androidx.compose.material3.RadioButtonDefaults r12 = androidx.compose.material3.RadioButtonDefaults.INSTANCE
            r13 = 0
            r4 = 0
            r17 = 0
            r19 = 0
            r22 = 24576(0x6000, float:3.4438E-41)
            r23 = 15
            r15 = r4
            r21 = r8
            androidx.compose.material3.RadioButtonColors r4 = r12.m2049colorsro_MJ88(r13, r15, r17, r19, r21, r22, r23)
            r1 = r1 & r25
            goto L_0x011f
        L_0x011e:
            r4 = r6
        L_0x011f:
            if (r24 == 0) goto L_0x0158
            r5 = 0
            r6 = 0
            r12 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r12)
            java.lang.String r12 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r12)
            r12 = 0
            r13 = r8
            r14 = 0
            java.lang.Object r15 = r13.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r17.getEmpty()
            if (r15 != r7) goto L_0x0149
            r7 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r13.updateRememberedValue(r7)
            goto L_0x014a
        L_0x0149:
            r7 = r15
        L_0x014a:
            r8.endReplaceableGroup()
            r5 = r7
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = (androidx.compose.foundation.interaction.MutableInteractionSource) r5
            r7 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r15 = r5
            goto L_0x015e
        L_0x0158:
            r15 = r33
            r7 = r1
            r12 = r2
            r13 = r3
            r14 = r4
        L_0x015e:
            r8.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x016d
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.RadioButton (RadioButton.kt:72)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r7, r1, r2)
        L_0x016d:
            if (r9 == 0) goto L_0x017c
            float r0 = RadioButtonDotSize
            r1 = 2
            r2 = 0
            float r3 = (float) r1
            float r3 = r0 / r3
            float r0 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r3)
            r1 = r0
            goto L_0x0184
        L_0x017c:
            r0 = 0
            r1 = 0
            float r2 = (float) r0
            float r2 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r2)
            r1 = r2
        L_0x0184:
            r0 = 100
            r6 = 0
            r5 = 0
            r2 = 6
            androidx.compose.animation.core.TweenSpec r0 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r0, r6, r5, r2, r5)
            r2 = r0
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r3 = 0
            r0 = 48
            r16 = 4
            r4 = r8
            r5 = r0
            r0 = r6
            r6 = r16
            androidx.compose.runtime.State r6 = androidx.compose.animation.core.AnimateAsStateKt.m379animateDpAsStateKz89ssw(r1, r2, r3, r4, r5, r6)
            int r1 = r7 >> 9
            r1 = r1 & 14
            int r2 = r7 << 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r7 >> 6
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            androidx.compose.runtime.State r5 = r14.radioColor$material3_release(r13, r9, r8, r1)
            r1 = 735546407(0x2bd78c27, float:1.5315569E-12)
            r8.startReplaceableGroup(r1)
            java.lang.String r1 = "93@4433L136"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            if (r10 == 0) goto L_0x0206
            androidx.compose.ui.Modifier$Companion r16 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r17 = r1.m5317getRadioButtono7Vup1c()
            r1 = 0
            androidx.compose.material3.tokens.RadioButtonTokens r2 = androidx.compose.material3.tokens.RadioButtonTokens.INSTANCE
            float r2 = r2.m2654getStateLayerSizeD9Ej5fM()
            r3 = 2
            r4 = 0
            float r0 = (float) r3
            float r0 = r2 / r0
            float r2 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r0)
            r3 = 0
            r0 = 54
            r18 = 4
            r26 = r5
            r5 = r8
            r27 = r6
            r6 = r0
            r19 = r7
            r0 = 2
            r7 = r18
            androidx.compose.foundation.Indication r3 = androidx.compose.material.ripple.RippleKt.m1729rememberRipple9IZ8Weo(r1, r2, r3, r5, r6, r7)
            r1 = r16
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.semantics.Role r5 = androidx.compose.ui.semantics.Role.m5306boximpl(r17)
            r7 = r0
            r6 = 0
            r0 = r1
            r1 = r28
            r2 = r15
            r4 = r13
            r9 = r6
            r6 = r29
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.SelectableKt.m1079selectableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0212
        L_0x0206:
            r9 = r0
            r26 = r5
            r27 = r6
            r19 = r7
            r7 = 2
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x0212:
            r8.endReplaceableGroup()
            if (r10 == 0) goto L_0x0222
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r1 = androidx.compose.material3.TouchTargetKt.minimumTouchTargetSize(r1)
            goto L_0x0226
        L_0x0222:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
        L_0x0226:
            androidx.compose.ui.Modifier r1 = r12.then(r1)
            androidx.compose.ui.Modifier r1 = r1.then(r0)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getCenter()
            r3 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r1, r2, r9, r7, r3)
            float r2 = RadioButtonPadding
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m760padding3ABfNKs(r1, r2)
            androidx.compose.material3.tokens.RadioButtonTokens r2 = androidx.compose.material3.tokens.RadioButtonTokens.INSTANCE
            float r2 = r2.m2653getIconSizeD9Ej5fM()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m822requiredSize3ABfNKs(r1, r2)
            r2 = r9
            r3 = 0
            r4 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r8.startReplaceableGroup(r4)
            java.lang.String r4 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r4)
            r4 = r26
            boolean r5 = r8.changed((java.lang.Object) r4)
            r6 = r27
            boolean r7 = r8.changed((java.lang.Object) r6)
            r5 = r5 | r7
            r7 = r8
            r16 = 0
            java.lang.Object r9 = r7.rememberedValue()
            r17 = 0
            if (r5 != 0) goto L_0x027b
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r31 = r0
            java.lang.Object r0 = r18.getEmpty()
            if (r9 != r0) goto L_0x0279
            goto L_0x027d
        L_0x0279:
            r0 = r9
            goto L_0x028b
        L_0x027b:
            r31 = r0
        L_0x027d:
            r0 = 0
            r32 = r0
            androidx.compose.material3.RadioButtonKt$RadioButton$2$1 r0 = new androidx.compose.material3.RadioButtonKt$RadioButton$2$1
            r0.<init>(r4, r6)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r7.updateRememberedValue(r0)
        L_0x028b:
            r8.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r1, r0, r8, r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x029f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x029f:
            androidx.compose.runtime.ScopeUpdateScope r9 = r8.endRestartGroup()
            if (r9 != 0) goto L_0x02a8
            r17 = r8
            goto L_0x02c4
        L_0x02a8:
            androidx.compose.material3.RadioButtonKt$RadioButton$3 r16 = new androidx.compose.material3.RadioButtonKt$RadioButton$3
            r0 = r16
            r1 = r28
            r2 = r29
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r35
            r17 = r8
            r8 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x02c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.RadioButtonKt.RadioButton(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.RadioButtonColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }
}
