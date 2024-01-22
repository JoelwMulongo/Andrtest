package androidx.compose.material;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001aa\u0010\u0013\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "onClick", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidMenu.android.kt */
public final class AndroidMenu_androidKt {
    /* JADX WARNING: Removed duplicated region for block: B:107:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e5  */
    /* renamed from: DropdownMenu-ILWXrKs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1365DropdownMenuILWXrKs(boolean r34, kotlin.jvm.functions.Function0<kotlin.Unit> r35, androidx.compose.ui.Modifier r36, long r37, androidx.compose.ui.window.PopupProperties r39, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r10 = r35
            r11 = r40
            r12 = r42
            java.lang.String r0 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -840283139(0xffffffffcdea4bfd, float:-4.91356064E8)
            r1 = r41
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,5)81@4099L42,85@4289L51,86@4376L7,90@4500L131,94@4641L400:AndroidMenu.android.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r42
            r2 = r43 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            r14 = r34
            goto L_0x003d
        L_0x002a:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x003b
            r14 = r34
            boolean r2 = r13.changed((boolean) r14)
            if (r2 == 0) goto L_0x0038
            r2 = 4
            goto L_0x0039
        L_0x0038:
            r2 = 2
        L_0x0039:
            r1 = r1 | r2
            goto L_0x003d
        L_0x003b:
            r14 = r34
        L_0x003d:
            r2 = r43 & 2
            if (r2 == 0) goto L_0x0044
            r1 = r1 | 48
            goto L_0x0054
        L_0x0044:
            r2 = r12 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r13.changedInstance(r10)
            if (r2 == 0) goto L_0x0051
            r2 = 32
            goto L_0x0053
        L_0x0051:
            r2 = 16
        L_0x0053:
            r1 = r1 | r2
        L_0x0054:
            r2 = r43 & 4
            if (r2 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r4 = r36
            goto L_0x0072
        L_0x005d:
            r4 = r12 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0070
            r4 = r36
            boolean r5 = r13.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x006c
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r5 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r5
            goto L_0x0072
        L_0x0070:
            r4 = r36
        L_0x0072:
            r5 = r43 & 8
            if (r5 == 0) goto L_0x007b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r6 = r37
            goto L_0x0090
        L_0x007b:
            r6 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x008e
            r6 = r37
            boolean r8 = r13.changed((long) r6)
            if (r8 == 0) goto L_0x008a
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x008c
        L_0x008a:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x008c:
            r1 = r1 | r8
            goto L_0x0090
        L_0x008e:
            r6 = r37
        L_0x0090:
            r8 = r43 & 16
            if (r8 == 0) goto L_0x0099
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r9 = r39
            goto L_0x00b0
        L_0x0099:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r12
            if (r9 != 0) goto L_0x00ae
            r9 = r39
            boolean r15 = r13.changed((java.lang.Object) r9)
            if (r15 == 0) goto L_0x00aa
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ac
        L_0x00aa:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00ac:
            r1 = r1 | r15
            goto L_0x00b0
        L_0x00ae:
            r9 = r39
        L_0x00b0:
            r15 = r43 & 32
            if (r15 == 0) goto L_0x00b8
            r15 = 196608(0x30000, float:2.75506E-40)
        L_0x00b6:
            r1 = r1 | r15
            goto L_0x00c9
        L_0x00b8:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r12
            if (r15 != 0) goto L_0x00c9
            boolean r15 = r13.changedInstance(r11)
            if (r15 == 0) goto L_0x00c6
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00c6:
            r15 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b6
        L_0x00c9:
            r15 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r15
            r3 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r3) goto L_0x00e5
            boolean r1 = r13.getSkipping()
            if (r1 != 0) goto L_0x00da
            goto L_0x00e5
        L_0x00da:
            r13.skipToGroupEnd()
            r16 = r4
            r23 = r6
            r17 = r9
            goto L_0x0287
        L_0x00e5:
            if (r2 == 0) goto L_0x00ee
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r16 = r1
            goto L_0x00f0
        L_0x00ee:
            r16 = r4
        L_0x00f0:
            if (r5 == 0) goto L_0x0107
            r1 = 0
            r2 = 0
            float r3 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r3)
            r2 = 0
            r3 = 0
            float r4 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r4)
            long r1 = androidx.compose.ui.unit.DpKt.m6007DpOffsetYgX7TsA(r1, r2)
            r23 = r1
            goto L_0x0109
        L_0x0107:
            r23 = r6
        L_0x0109:
            if (r8 == 0) goto L_0x0123
            androidx.compose.ui.window.PopupProperties r1 = new androidx.compose.ui.window.PopupProperties
            r26 = 1
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 62
            r33 = 0
            r25 = r1
            r25.<init>(r26, r27, r28, r29, r30, r31, r32, r33)
            r9 = r1
        L_0x0123:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x012f
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:73)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r1, r2)
        L_0x012f:
            r0 = 0
            r1 = r0
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r13.startReplaceableGroup(r3)
            java.lang.String r4 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            r5 = 0
            r6 = r13
            r7 = 0
            java.lang.Object r8 = r6.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r18.getEmpty()
            if (r8 != r3) goto L_0x0163
            r3 = 0
            r37 = r1
            androidx.compose.animation.core.MutableTransitionState r1 = new androidx.compose.animation.core.MutableTransitionState
            r38 = r2
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
            r1.<init>(r2)
            r6.updateRememberedValue(r1)
            goto L_0x0168
        L_0x0163:
            r37 = r1
            r38 = r2
            r1 = r8
        L_0x0168:
            r13.endReplaceableGroup()
            r7 = r1
            androidx.compose.animation.core.MutableTransitionState r7 = (androidx.compose.animation.core.MutableTransitionState) r7
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r34)
            r7.setTargetState(r1)
            java.lang.Object r1 = r7.getCurrentState()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0194
            java.lang.Object r1 = r7.getTargetState()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0190
            goto L_0x0194
        L_0x0190:
            r36 = r7
            goto L_0x027c
        L_0x0194:
            r1 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r13.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            r2 = 0
            r3 = r13
            r4 = 0
            java.lang.Object r5 = r3.rememberedValue()
            r6 = 0
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r5 != r8) goto L_0x01cc
            r8 = 0
            androidx.compose.ui.graphics.TransformOrigin$Companion r17 = androidx.compose.ui.graphics.TransformOrigin.Companion
            long r17 = r17.m3586getCenterSzJe1aQ()
            r36 = r0
            androidx.compose.ui.graphics.TransformOrigin r0 = androidx.compose.ui.graphics.TransformOrigin.m3573boximpl(r17)
            r37 = r1
            r1 = 0
            r38 = r2
            r2 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r1, r2, r1)
            r3.updateRememberedValue(r0)
            goto L_0x01d3
        L_0x01cc:
            r36 = r0
            r37 = r1
            r38 = r2
            r0 = r5
        L_0x01d3:
            r13.endReplaceableGroup()
            r8 = r0
            androidx.compose.runtime.MutableState r8 = (androidx.compose.runtime.MutableState) r8
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r3, r4)
            java.lang.Object r3 = r13.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r25 = r3
            androidx.compose.ui.unit.Density r25 = (androidx.compose.ui.unit.Density) r25
            r0 = 6
            r1 = 0
            r2 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r2)
            java.lang.String r2 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r2)
            boolean r2 = r13.changed((java.lang.Object) r8)
            r3 = r13
            r4 = 0
            java.lang.Object r5 = r3.rememberedValue()
            r6 = 0
            if (r2 != 0) goto L_0x0220
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r36 = r0
            java.lang.Object r0 = r17.getEmpty()
            if (r5 != r0) goto L_0x021e
            goto L_0x0222
        L_0x021e:
            r0 = r5
            goto L_0x0231
        L_0x0220:
            r36 = r0
        L_0x0222:
            r0 = 0
            r37 = r0
            androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1 r0 = new androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
            r0.<init>(r8)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r3.updateRememberedValue(r0)
        L_0x0231:
            r13.endReplaceableGroup()
            r21 = r0
            kotlin.jvm.functions.Function2 r21 = (kotlin.jvm.functions.Function2) r21
            r22 = 0
            androidx.compose.material.DropdownMenuPositionProvider r0 = new androidx.compose.material.DropdownMenuPositionProvider
            r17 = r0
            r18 = r23
            r20 = r25
            r17.<init>(r18, r20, r21, r22)
            r6 = r17
            androidx.compose.ui.window.PopupPositionProvider r6 = (androidx.compose.ui.window.PopupPositionProvider) r6
            androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$1 r5 = new androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$1
            r0 = r5
            r1 = r7
            r2 = r8
            r3 = r16
            r4 = r40
            r36 = r7
            r7 = r5
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = 79632374(0x4bf17f6, float:4.492589E-36)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r0, r1, r7)
            r3 = r0
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r0 = r15 & 112(0x70, float:1.57E-43)
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            int r1 = r15 >> 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r5 = r0 | r1
            r7 = 0
            r0 = r6
            r1 = r35
            r2 = r9
            r4 = r13
            r6 = r7
            androidx.compose.ui.window.AndroidPopup_androidKt.Popup(r0, r1, r2, r3, r4, r5, r6)
        L_0x027c:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0285
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0285:
            r17 = r9
        L_0x0287:
            androidx.compose.runtime.ScopeUpdateScope r9 = r13.endRestartGroup()
            if (r9 != 0) goto L_0x028e
            goto L_0x02ad
        L_0x028e:
            androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$2 r18 = new androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$2
            r0 = r18
            r1 = r34
            r2 = r35
            r3 = r16
            r4 = r23
            r6 = r17
            r7 = r40
            r8 = r42
            r10 = r9
            r9 = r43
            r0.<init>(r1, r2, r3, r4, r6, r7, r8, r9)
            r0 = r18
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x02ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidMenu_androidKt.m1365DropdownMenuILWXrKs(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DropdownMenuItem(kotlin.jvm.functions.Function0<kotlin.Unit> r19, androidx.compose.ui.Modifier r20, boolean r21, androidx.compose.foundation.layout.PaddingValues r22, androidx.compose.foundation.interaction.MutableInteractionSource r23, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r9 = r19
            r10 = r24
            r11 = r26
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -1988562892(0xffffffff8978f034, float:-2.9964857E-33)
            r1 = r25
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DropdownMenuItem)P(5,4,2,1,3)132@6224L39,135@6318L227:AndroidMenu.android.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r26
            r2 = r27 & 1
            if (r2 == 0) goto L_0x0028
            r1 = r1 | 6
            goto L_0x0036
        L_0x0028:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x0036
            boolean r2 = r12.changedInstance(r9)
            if (r2 == 0) goto L_0x0034
            r2 = 4
            goto L_0x0035
        L_0x0034:
            r2 = 2
        L_0x0035:
            r1 = r1 | r2
        L_0x0036:
            r2 = r27 & 2
            if (r2 == 0) goto L_0x003f
            r1 = r1 | 48
            r3 = r20
            goto L_0x0054
        L_0x003f:
            r3 = r11 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0052
            r3 = r20
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004e
            r4 = 32
            goto L_0x0050
        L_0x004e:
            r4 = 16
        L_0x0050:
            r1 = r1 | r4
            goto L_0x0054
        L_0x0052:
            r3 = r20
        L_0x0054:
            r4 = r27 & 4
            if (r4 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r21
            goto L_0x0072
        L_0x005d:
            r5 = r11 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0070
            r5 = r21
            boolean r6 = r12.changed((boolean) r5)
            if (r6 == 0) goto L_0x006c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x006e
        L_0x006c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x006e:
            r1 = r1 | r6
            goto L_0x0072
        L_0x0070:
            r5 = r21
        L_0x0072:
            r6 = r27 & 8
            if (r6 == 0) goto L_0x007b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r22
            goto L_0x0090
        L_0x007b:
            r7 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x008e
            r7 = r22
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x008a
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x008c
        L_0x008a:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x008c:
            r1 = r1 | r8
            goto L_0x0090
        L_0x008e:
            r7 = r22
        L_0x0090:
            r8 = r27 & 16
            r13 = 57344(0xe000, float:8.0356E-41)
            if (r8 == 0) goto L_0x009c
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r14 = r23
            goto L_0x00b1
        L_0x009c:
            r14 = r11 & r13
            if (r14 != 0) goto L_0x00af
            r14 = r23
            boolean r15 = r12.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00ab
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ad
        L_0x00ab:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00ad:
            r1 = r1 | r15
            goto L_0x00b1
        L_0x00af:
            r14 = r23
        L_0x00b1:
            r15 = r27 & 32
            r16 = 458752(0x70000, float:6.42848E-40)
            if (r15 == 0) goto L_0x00bb
            r15 = 196608(0x30000, float:2.75506E-40)
        L_0x00b9:
            r1 = r1 | r15
            goto L_0x00cb
        L_0x00bb:
            r15 = r11 & r16
            if (r15 != 0) goto L_0x00cb
            boolean r15 = r12.changedInstance(r10)
            if (r15 == 0) goto L_0x00c8
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00c8:
            r15 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b9
        L_0x00cb:
            r15 = r1
            r1 = 374491(0x5b6db, float:5.24774E-40)
            r1 = r1 & r15
            r13 = 74898(0x12492, float:1.04954E-40)
            if (r1 != r13) goto L_0x00e6
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x00dc
            goto L_0x00e6
        L_0x00dc:
            r12.skipToGroupEnd()
            r13 = r3
            r17 = r5
            r18 = r7
            goto L_0x0175
        L_0x00e6:
            if (r2 == 0) goto L_0x00ee
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r13 = r1
            goto L_0x00ef
        L_0x00ee:
            r13 = r3
        L_0x00ef:
            if (r4 == 0) goto L_0x00f5
            r1 = 1
            r17 = r1
            goto L_0x00f7
        L_0x00f5:
            r17 = r5
        L_0x00f7:
            if (r6 == 0) goto L_0x0102
            androidx.compose.material.MenuDefaults r1 = androidx.compose.material.MenuDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r1 = r1.getDropdownMenuItemContentPadding()
            r18 = r1
            goto L_0x0104
        L_0x0102:
            r18 = r7
        L_0x0104:
            if (r8 == 0) goto L_0x0138
            r1 = 0
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            r3 = 0
            r4 = r12
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r7 = 0
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r6 != r8) goto L_0x012e
            r8 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r8 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r4.updateRememberedValue(r8)
            goto L_0x012f
        L_0x012e:
            r8 = r6
        L_0x012f:
            r12.endReplaceableGroup()
            r1 = r8
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r14 = r1
        L_0x0138:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0144
            r1 = -1
            java.lang.String r2 = "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:127)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r15, r1, r2)
        L_0x0144:
            r0 = r15 & 14
            r1 = r15 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r15 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r15 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r15
            r0 = r0 | r1
            r1 = r15 & r16
            r7 = r0 | r1
            r8 = 0
            r0 = r19
            r1 = r13
            r2 = r17
            r3 = r18
            r4 = r14
            r5 = r24
            r6 = r12
            androidx.compose.material.MenuKt.DropdownMenuItemContent(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0175
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0175:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 != 0) goto L_0x017c
            goto L_0x0199
        L_0x017c:
            androidx.compose.material.AndroidMenu_androidKt$DropdownMenuItem$2 r16 = new androidx.compose.material.AndroidMenu_androidKt$DropdownMenuItem$2
            r0 = r16
            r1 = r19
            r2 = r13
            r3 = r17
            r4 = r18
            r5 = r14
            r6 = r24
            r7 = r26
            r9 = r8
            r8 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r9.updateScope(r0)
        L_0x0199:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidMenu_androidKt.DropdownMenuItem(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
