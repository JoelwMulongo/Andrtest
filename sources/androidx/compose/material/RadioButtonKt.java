package androidx.compose.material;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0007\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\b\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"RadioAnimationDuration", "", "RadioButtonDotSize", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioButtonRippleRadius", "RadioButtonSize", "RadioRadius", "RadioStrokeWidth", "RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/RadioButtonColors;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/RadioButtonColors;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: RadioButton.kt */
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize = Dp.m5986constructorimpl((float) 12);
    private static final float RadioButtonPadding = Dp.m5986constructorimpl((float) 2);
    private static final float RadioButtonRippleRadius = Dp.m5986constructorimpl((float) 24);
    private static final float RadioButtonSize = Dp.m5986constructorimpl((float) 20);
    /* access modifiers changed from: private */
    public static final float RadioRadius = Dp.m5986constructorimpl(RadioButtonSize / ((float) 2));
    /* access modifiers changed from: private */
    public static final float RadioStrokeWidth = Dp.m5986constructorimpl((float) 2);

    /* JADX WARNING: Removed duplicated region for block: B:117:0x0284  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RadioButton(boolean r25, kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.ui.Modifier r27, boolean r28, androidx.compose.foundation.interaction.MutableInteractionSource r29, androidx.compose.material.RadioButtonColors r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r9 = r25
            r10 = r26
            r11 = r32
            r0 = 1314435585(0x4e58b201, float:9.0888608E8)
            r1 = r31
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(RadioButton)P(5,4,3,1,2)78@3687L39,79@3780L8,81@3813L164,85@4006L29,115@4958L385,102@4551L792:RadioButton.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r32
            r2 = r33 & 1
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
            r2 = r33 & 2
            if (r2 == 0) goto L_0x0032
            r1 = r1 | 48
            goto L_0x0042
        L_0x0032:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0042
            boolean r2 = r8.changedInstance(r10)
            if (r2 == 0) goto L_0x003f
            r2 = 32
            goto L_0x0041
        L_0x003f:
            r2 = 16
        L_0x0041:
            r1 = r1 | r2
        L_0x0042:
            r2 = r33 & 4
            if (r2 == 0) goto L_0x004b
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r27
            goto L_0x0060
        L_0x004b:
            r3 = r11 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x005e
            r3 = r27
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
            r3 = r27
        L_0x0060:
            r4 = r33 & 8
            if (r4 == 0) goto L_0x0069
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r28
            goto L_0x007e
        L_0x0069:
            r5 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x007c
            r5 = r28
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
            r5 = r28
        L_0x007e:
            r6 = r33 & 16
            if (r6 == 0) goto L_0x0087
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r12 = r29
            goto L_0x009e
        L_0x0087:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r11
            if (r12 != 0) goto L_0x009c
            r12 = r29
            boolean r13 = r8.changed((java.lang.Object) r12)
            if (r13 == 0) goto L_0x0098
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009a
        L_0x0098:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009a:
            r1 = r1 | r13
            goto L_0x009e
        L_0x009c:
            r12 = r29
        L_0x009e:
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r11
            if (r13 != 0) goto L_0x00b8
            r13 = r33 & 32
            if (r13 != 0) goto L_0x00b2
            r15 = r30
            boolean r13 = r8.changed((java.lang.Object) r15)
            if (r13 == 0) goto L_0x00b4
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00b2:
            r15 = r30
        L_0x00b4:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b6:
            r1 = r1 | r13
            goto L_0x00ba
        L_0x00b8:
            r15 = r30
        L_0x00ba:
            r13 = 374491(0x5b6db, float:5.24774E-40)
            r13 = r13 & r1
            r14 = 74898(0x12492, float:1.04954E-40)
            if (r13 != r14) goto L_0x00d3
            boolean r13 = r8.getSkipping()
            if (r13 != 0) goto L_0x00ca
            goto L_0x00d3
        L_0x00ca:
            r8.skipToGroupEnd()
            r9 = r1
            r13 = r5
            r14 = r12
            r12 = r3
            goto L_0x0288
        L_0x00d3:
            r8.startDefaults()
            r13 = r11 & 1
            r22 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r13 == 0) goto L_0x00f3
            boolean r13 = r8.getDefaultsInvalid()
            if (r13 == 0) goto L_0x00e4
            goto L_0x00f3
        L_0x00e4:
            r8.skipToGroupEnd()
            r2 = r33 & 32
            if (r2 == 0) goto L_0x00ed
            r1 = r1 & r22
        L_0x00ed:
            r0 = r1
            r13 = r5
            r14 = r12
            r12 = r3
            goto L_0x015a
        L_0x00f3:
            if (r2 == 0) goto L_0x00fa
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x00fb
        L_0x00fa:
            r2 = r3
        L_0x00fb:
            if (r4 == 0) goto L_0x00ff
            r3 = 1
            goto L_0x0100
        L_0x00ff:
            r3 = r5
        L_0x0100:
            if (r6 == 0) goto L_0x0134
            r4 = 0
            r5 = 0
            r6 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r8.startReplaceableGroup(r6)
            java.lang.String r6 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r6)
            r6 = 0
            r13 = r8
            r14 = 0
            java.lang.Object r7 = r13.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r17.getEmpty()
            if (r7 != r0) goto L_0x012b
            r0 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r13.updateRememberedValue(r0)
            goto L_0x012c
        L_0x012b:
            r0 = r7
        L_0x012c:
            r8.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            goto L_0x0135
        L_0x0134:
            r0 = r12
        L_0x0135:
            r4 = r33 & 32
            if (r4 == 0) goto L_0x0154
            androidx.compose.material.RadioButtonDefaults r12 = androidx.compose.material.RadioButtonDefaults.INSTANCE
            r13 = 0
            r4 = 0
            r17 = 0
            r20 = 3072(0xc00, float:4.305E-42)
            r21 = 7
            r15 = r4
            r19 = r8
            androidx.compose.material.RadioButtonColors r4 = r12.m1588colorsRGew2ao(r13, r15, r17, r19, r20, r21)
            r1 = r1 & r22
            r14 = r0
            r0 = r1
            r12 = r2
            r13 = r3
            r15 = r4
            goto L_0x015a
        L_0x0154:
            r15 = r30
            r14 = r0
            r0 = r1
            r12 = r2
            r13 = r3
        L_0x015a:
            r8.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x016c
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.RadioButton (RadioButton.kt:73)"
            r3 = 1314435585(0x4e58b201, float:9.0888608E8)
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r0, r1, r2)
        L_0x016c:
            if (r9 == 0) goto L_0x017a
            float r1 = RadioButtonDotSize
            r2 = 2
            r3 = 0
            float r4 = (float) r2
            float r4 = r1 / r4
            float r1 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r4)
            goto L_0x0182
        L_0x017a:
            r1 = 0
            r2 = 0
            float r3 = (float) r1
            float r3 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r3)
            r1 = r3
        L_0x0182:
            r2 = 100
            r7 = 0
            r6 = 0
            r3 = 6
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r2, r7, r6, r3, r6)
            androidx.compose.animation.core.AnimationSpec r2 = (androidx.compose.animation.core.AnimationSpec) r2
            r3 = 0
            r5 = 48
            r16 = 4
            r4 = r8
            r6 = r16
            androidx.compose.runtime.State r6 = androidx.compose.animation.core.AnimateAsStateKt.m379animateDpAsStateKz89ssw(r1, r2, r3, r4, r5, r6)
            int r1 = r0 >> 9
            r1 = r1 & 14
            int r2 = r0 << 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r0 >> 9
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            androidx.compose.runtime.State r5 = r15.radioColor(r13, r9, r8, r1)
            r1 = 1941632354(0x73baf562, float:2.962476E31)
            r8.startReplaceableGroup(r1)
            java.lang.String r1 = "94@4361L123"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            if (r10 == 0) goto L_0x01f2
            androidx.compose.ui.Modifier$Companion r16 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r17 = r1.m5317getRadioButtono7Vup1c()
            r1 = 0
            float r2 = RadioButtonRippleRadius
            r3 = 0
            r18 = 54
            r19 = 4
            r23 = r5
            r5 = r8
            r24 = r6
            r6 = r18
            r11 = r7
            r9 = 2
            r7 = r19
            androidx.compose.foundation.Indication r3 = androidx.compose.material.ripple.RippleKt.m1729rememberRipple9IZ8Weo(r1, r2, r3, r5, r6, r7)
            r1 = r16
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.semantics.Role r5 = androidx.compose.ui.semantics.Role.m5306boximpl(r17)
            r7 = r0
            r0 = r1
            r1 = r25
            r2 = r14
            r4 = r13
            r6 = r26
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.selection.SelectableKt.m1079selectableO2vRcR0(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x01fd
        L_0x01f2:
            r23 = r5
            r24 = r6
            r11 = r7
            r9 = 2
            r7 = r0
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
        L_0x01fd:
            r8.endReplaceableGroup()
            if (r10 == 0) goto L_0x020d
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r1 = androidx.compose.material.InteractiveComponentSizeKt.minimumInteractiveComponentSize(r1)
            goto L_0x0211
        L_0x020d:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
        L_0x0211:
            androidx.compose.ui.Modifier r1 = r12.then(r1)
            androidx.compose.ui.Modifier r1 = r1.then(r0)
            androidx.compose.ui.Alignment$Companion r2 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r2 = r2.getCenter()
            r3 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r1, r2, r11, r9, r3)
            float r2 = RadioButtonPadding
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.PaddingKt.m760padding3ABfNKs(r1, r2)
            float r2 = RadioButtonSize
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m822requiredSize3ABfNKs(r1, r2)
            r2 = r11
            r3 = 0
            r4 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r8.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r4)
            r4 = r23
            boolean r5 = r8.changed((java.lang.Object) r4)
            r6 = r24
            boolean r9 = r8.changed((java.lang.Object) r6)
            r5 = r5 | r9
            r9 = r8
            r16 = 0
            java.lang.Object r11 = r9.rememberedValue()
            r18 = 0
            if (r5 != 0) goto L_0x0262
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r27 = r0
            java.lang.Object r0 = r19.getEmpty()
            if (r11 != r0) goto L_0x0260
            goto L_0x0264
        L_0x0260:
            r0 = r11
            goto L_0x0273
        L_0x0262:
            r27 = r0
        L_0x0264:
            r0 = 0
            r28 = r0
            androidx.compose.material.RadioButtonKt$RadioButton$2$1 r0 = new androidx.compose.material.RadioButtonKt$RadioButton$2$1
            r0.<init>(r4, r6)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r9.updateRememberedValue(r0)
        L_0x0273:
            r8.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r1, r0, r8, r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0287
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0287:
            r9 = r7
        L_0x0288:
            androidx.compose.runtime.ScopeUpdateScope r11 = r8.endRestartGroup()
            if (r11 != 0) goto L_0x0291
            r17 = r8
            goto L_0x02ad
        L_0x0291:
            androidx.compose.material.RadioButtonKt$RadioButton$3 r16 = new androidx.compose.material.RadioButtonKt$RadioButton$3
            r0 = r16
            r1 = r25
            r2 = r26
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r32
            r17 = r8
            r8 = r33
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r11.updateScope(r0)
        L_0x02ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.RadioButtonKt.RadioButton(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.RadioButtonColors, androidx.compose.runtime.Composer, int, int):void");
    }
}
