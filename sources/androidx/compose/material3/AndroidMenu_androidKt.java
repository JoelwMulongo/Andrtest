package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0001\u0010\u0013\u001a\u00020\u00012\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u000f2\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0002\u0010\u001f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "text", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: AndroidMenu.android.kt */
public final class AndroidMenu_androidKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e2  */
    /* renamed from: DropdownMenu-ILWXrKs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1741DropdownMenuILWXrKs(boolean r25, kotlin.jvm.functions.Function0<kotlin.Unit> r26, androidx.compose.ui.Modifier r27, long r28, androidx.compose.ui.window.PopupProperties r30, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r10 = r26
            r11 = r31
            r12 = r33
            java.lang.String r0 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 354826666(0x152639aa, float:3.3568922E-26)
            r1 = r32
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,5)81@4015L42,85@4205L51,86@4292L7,90@4416L131,94@4557L400:AndroidMenu.android.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r33
            r2 = r34 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            r14 = r25
            goto L_0x003d
        L_0x002a:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x003b
            r14 = r25
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
            r14 = r25
        L_0x003d:
            r2 = r34 & 2
            if (r2 == 0) goto L_0x0044
            r1 = r1 | 48
            goto L_0x0054
        L_0x0044:
            r2 = r12 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r13.changed((java.lang.Object) r10)
            if (r2 == 0) goto L_0x0051
            r2 = 32
            goto L_0x0053
        L_0x0051:
            r2 = 16
        L_0x0053:
            r1 = r1 | r2
        L_0x0054:
            r2 = r34 & 4
            if (r2 == 0) goto L_0x005d
            r1 = r1 | 384(0x180, float:5.38E-43)
            r4 = r27
            goto L_0x0072
        L_0x005d:
            r4 = r12 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0070
            r4 = r27
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
            r4 = r27
        L_0x0072:
            r5 = r34 & 8
            if (r5 == 0) goto L_0x007b
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r6 = r28
            goto L_0x0090
        L_0x007b:
            r6 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x008e
            r6 = r28
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
            r6 = r28
        L_0x0090:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r12
            if (r8 != 0) goto L_0x00ab
            r8 = r34 & 16
            if (r8 != 0) goto L_0x00a5
            r8 = r30
            boolean r9 = r13.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00a7
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a9
        L_0x00a5:
            r8 = r30
        L_0x00a7:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x00a9:
            r1 = r1 | r9
            goto L_0x00ad
        L_0x00ab:
            r8 = r30
        L_0x00ad:
            r9 = r34 & 32
            if (r9 == 0) goto L_0x00b5
            r9 = 196608(0x30000, float:2.75506E-40)
        L_0x00b3:
            r1 = r1 | r9
            goto L_0x00c6
        L_0x00b5:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r12
            if (r9 != 0) goto L_0x00c6
            boolean r9 = r13.changed((java.lang.Object) r11)
            if (r9 == 0) goto L_0x00c3
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b3
        L_0x00c3:
            r9 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00b3
        L_0x00c6:
            r9 = 374491(0x5b6db, float:5.24774E-40)
            r9 = r9 & r1
            r15 = 74898(0x12492, float:1.04954E-40)
            if (r9 != r15) goto L_0x00e2
            boolean r9 = r13.getSkipping()
            if (r9 != 0) goto L_0x00d6
            goto L_0x00e2
        L_0x00d6:
            r13.skipToGroupEnd()
            r19 = r1
            r15 = r4
            r16 = r6
            r18 = r8
            goto L_0x02c2
        L_0x00e2:
            r13.startDefaults()
            r9 = r12 & 1
            r15 = -57345(0xffffffffffff1fff, float:NaN)
            if (r9 == 0) goto L_0x0100
            boolean r9 = r13.getDefaultsInvalid()
            if (r9 == 0) goto L_0x00f3
            goto L_0x0100
        L_0x00f3:
            r13.skipToGroupEnd()
            r2 = r34 & 16
            if (r2 == 0) goto L_0x00fb
            r1 = r1 & r15
        L_0x00fb:
            r15 = r8
            r8 = r6
            r6 = r1
            r7 = r4
            goto L_0x0142
        L_0x0100:
            if (r2 == 0) goto L_0x0107
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x0108
        L_0x0107:
            r2 = r4
        L_0x0108:
            if (r5 == 0) goto L_0x011d
            r4 = 0
            r5 = 0
            float r9 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r9)
            r5 = 0
            r9 = 0
            float r3 = (float) r5
            float r3 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r3)
            long r3 = androidx.compose.ui.unit.DpKt.m6007DpOffsetYgX7TsA(r4, r3)
            r6 = r3
        L_0x011d:
            r3 = r34 & 16
            if (r3 == 0) goto L_0x013e
            androidx.compose.ui.window.PopupProperties r3 = new androidx.compose.ui.window.PopupProperties
            r17 = 1
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 62
            r24 = 0
            r16 = r3
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)
            r1 = r1 & r15
            r15 = r3
            r8 = r6
            r6 = r1
            r7 = r2
            goto L_0x0142
        L_0x013e:
            r15 = r8
            r8 = r6
            r6 = r1
            r7 = r2
        L_0x0142:
            r13.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0151
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.DropdownMenu (AndroidMenu.android.kt:73)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r1, r2)
        L_0x0151:
            r0 = 0
            r1 = r0
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r13.startReplaceableGroup(r3)
            java.lang.String r4 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            r5 = 0
            r27 = r13
            r16 = 0
            java.lang.Object r3 = r27.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r18.getEmpty()
            if (r3 != r0) goto L_0x018a
            r0 = 0
            r30 = r0
            androidx.compose.animation.core.MutableTransitionState r0 = new androidx.compose.animation.core.MutableTransitionState
            r19 = r1
            r18 = 0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r18)
            r0.<init>(r1)
            r1 = r27
            r1.updateRememberedValue(r0)
            goto L_0x018f
        L_0x018a:
            r19 = r1
            r1 = r27
            r0 = r3
        L_0x018f:
            r13.endReplaceableGroup()
            androidx.compose.animation.core.MutableTransitionState r0 = (androidx.compose.animation.core.MutableTransitionState) r0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r25)
            r0.setTargetState(r1)
            java.lang.Object r1 = r0.getCurrentState()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x01be
            java.lang.Object r1 = r0.getTargetState()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x01b6
            goto L_0x01be
        L_0x01b6:
            r18 = r0
            r19 = r6
            r27 = r7
            goto L_0x02b3
        L_0x01be:
            r1 = 0
            r2 = 0
            r3 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r13.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r4)
            r3 = 0
            r4 = r13
            r5 = 0
            r27 = r0
            java.lang.Object r0 = r4.rememberedValue()
            r16 = 0
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r28 = r1
            java.lang.Object r1 = r17.getEmpty()
            if (r0 != r1) goto L_0x01fa
            r1 = 0
            androidx.compose.ui.graphics.TransformOrigin$Companion r17 = androidx.compose.ui.graphics.TransformOrigin.Companion
            long r17 = r17.m3586getCenterSzJe1aQ()
            r29 = r0
            androidx.compose.ui.graphics.TransformOrigin r0 = androidx.compose.ui.graphics.TransformOrigin.m3573boximpl(r17)
            r30 = r1
            r1 = 0
            r17 = r2
            r2 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r1, r2, r1)
            r4.updateRememberedValue(r0)
            goto L_0x01fe
        L_0x01fa:
            r29 = r0
            r17 = r2
        L_0x01fe:
            r13.endReplaceableGroup()
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 0
            r3 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r13, r4, r5)
            java.lang.Object r4 = r13.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r13)
            r16 = r4
            androidx.compose.ui.unit.Density r16 = (androidx.compose.ui.unit.Density) r16
            r1 = 6
            r2 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r13.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r3)
            boolean r3 = r13.changed((java.lang.Object) r0)
            r4 = r13
            r5 = 0
            r28 = r1
            java.lang.Object r1 = r4.rememberedValue()
            r17 = 0
            if (r3 != 0) goto L_0x024e
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r29 = r2
            java.lang.Object r2 = r18.getEmpty()
            if (r1 != r2) goto L_0x024b
            goto L_0x0250
        L_0x024b:
            r30 = r1
            goto L_0x025e
        L_0x024e:
            r29 = r2
        L_0x0250:
            r2 = 0
            r30 = r1
            androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1 r1 = new androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
            r1.<init>(r0)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r4.updateRememberedValue(r1)
        L_0x025e:
            r13.endReplaceableGroup()
            r5 = r1
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r17 = 0
            androidx.compose.material3.DropdownMenuPositionProvider r18 = new androidx.compose.material3.DropdownMenuPositionProvider
            r1 = r18
            r2 = r8
            r4 = r16
            r19 = r6
            r6 = r17
            r1.<init>(r2, r4, r5, r6)
            r17 = r18
            r6 = r17
            androidx.compose.ui.window.PopupPositionProvider r6 = (androidx.compose.ui.window.PopupPositionProvider) r6
            androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1 r5 = new androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$1
            r18 = r27
            r20 = r0
            r0 = r5
            r1 = r18
            r2 = r20
            r3 = r7
            r4 = r31
            r27 = r7
            r7 = r5
            r5 = r19
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = -1192563503(0xffffffffb8eaecd1, float:-1.12021E-4)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r0, r1, r7)
            r3 = r0
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r0 = r19 & 112(0x70, float:1.57E-43)
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            int r1 = r19 >> 6
            r1 = r1 & 896(0x380, float:1.256E-42)
            r5 = r0 | r1
            r7 = 0
            r0 = r6
            r1 = r26
            r2 = r15
            r4 = r13
            r6 = r7
            androidx.compose.ui.window.AndroidPopup_androidKt.Popup(r0, r1, r2, r3, r4, r5, r6)
        L_0x02b3:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02bc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02bc:
            r16 = r8
            r18 = r15
            r15 = r27
        L_0x02c2:
            androidx.compose.runtime.ScopeUpdateScope r9 = r13.endRestartGroup()
            if (r9 != 0) goto L_0x02c9
            goto L_0x02e7
        L_0x02c9:
            androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$2 r20 = new androidx.compose.material3.AndroidMenu_androidKt$DropdownMenu$2
            r0 = r20
            r1 = r25
            r2 = r26
            r3 = r15
            r4 = r16
            r6 = r18
            r7 = r31
            r8 = r33
            r10 = r9
            r9 = r34
            r0.<init>(r1, r2, r3, r4, r6, r7, r8, r9)
            r0 = r20
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r10.updateScope(r0)
        L_0x02e7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AndroidMenu_androidKt.m1741DropdownMenuILWXrKs(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void DropdownMenuItem(Function2<? super Composer, ? super Integer, Unit> text, Function0<Unit> onClick, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, boolean enabled, MenuItemColors colors, PaddingValues contentPadding, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i) {
        Function2 function2;
        boolean z;
        Composer $composer2;
        MutableInteractionSource interactionSource2;
        PaddingValues contentPadding2;
        MenuItemColors colors2;
        boolean enabled2;
        Function2 trailingIcon2;
        Function2 leadingIcon2;
        Modifier modifier2;
        int $dirty;
        Modifier modifier3;
        Function2 leadingIcon3;
        Function2 trailingIcon3;
        boolean enabled3;
        MenuItemColors colors3;
        PaddingValues contentPadding3;
        MutableInteractionSource mutableInteractionSource;
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function22 = text;
        Function0<Unit> function0 = onClick;
        int i3 = $changed;
        int i4 = i;
        Intrinsics.checkNotNullParameter(function22, "text");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer3 = $composer.startRestartGroup(1826340448);
        ComposerKt.sourceInformation($composer3, "C(DropdownMenuItem)P(7,6,5,4,8,2)144@6904L12,146@7049L39,148@7098L319:AndroidMenu.android.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i4 & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i3 & 14) == 0) {
            $dirty2 |= $composer3.changed((Object) function22) ? 4 : 2;
        }
        if ((i4 & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i3 & 112) == 0) {
            $dirty2 |= $composer3.changed((Object) function0) ? 32 : 16;
        }
        int i5 = i4 & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
            Modifier modifier4 = modifier;
        } else if ((i3 & 896) == 0) {
            $dirty2 |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier5 = modifier;
        }
        int i6 = i4 & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
            Function2<? super Composer, ? super Integer, Unit> function23 = leadingIcon;
        } else if ((i3 & 7168) == 0) {
            $dirty2 |= $composer3.changed((Object) leadingIcon) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = leadingIcon;
        }
        int i7 = i4 & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
            function2 = trailingIcon;
        } else if ((i3 & 57344) == 0) {
            function2 = trailingIcon;
            $dirty2 |= $composer3.changed((Object) function2) ? 16384 : 8192;
        } else {
            function2 = trailingIcon;
        }
        int i8 = i4 & 32;
        if (i8 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z = enabled;
        } else if ((i3 & 458752) == 0) {
            z = enabled;
            $dirty2 |= $composer3.changed(z) ? 131072 : 65536;
        } else {
            z = enabled;
        }
        if ((i3 & 3670016) == 0) {
            if ((i4 & 64) != 0) {
                MenuItemColors menuItemColors = colors;
            } else if ($composer3.changed((Object) colors)) {
                i2 = 1048576;
                $dirty2 |= i2;
            }
            i2 = 524288;
            $dirty2 |= i2;
        } else {
            MenuItemColors menuItemColors2 = colors;
        }
        int i9 = i4 & 128;
        if (i9 != 0) {
            $dirty2 |= 12582912;
            PaddingValues paddingValues = contentPadding;
        } else if ((i3 & 29360128) == 0) {
            $dirty2 |= $composer3.changed((Object) contentPadding) ? 8388608 : 4194304;
        } else {
            PaddingValues paddingValues2 = contentPadding;
        }
        int i10 = i4 & 256;
        if (i10 != 0) {
            $dirty2 |= 100663296;
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        } else if ((i3 & 234881024) == 0) {
            $dirty2 |= $composer3.changed((Object) interactionSource) ? 67108864 : 33554432;
        } else {
            MutableInteractionSource mutableInteractionSource3 = interactionSource;
        }
        if (($dirty2 & 191739611) != 38347922 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i3 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i6 != 0) {
                    leadingIcon3 = null;
                } else {
                    leadingIcon3 = leadingIcon;
                }
                if (i7 != 0) {
                    trailingIcon3 = null;
                } else {
                    trailingIcon3 = function2;
                }
                if (i8 != 0) {
                    enabled3 = true;
                } else {
                    enabled3 = z;
                }
                if ((i4 & 64) != 0) {
                    colors3 = MenuDefaults.INSTANCE.m1981itemColors5tl4gsc(0, 0, 0, 0, 0, 0, $composer3, 1572864, 63);
                    $dirty2 &= -3670017;
                } else {
                    colors3 = colors;
                }
                if (i9 != 0) {
                    contentPadding3 = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    contentPadding3 = contentPadding;
                }
                if (i10 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    PaddingValues contentPadding4 = contentPadding3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    int $dirty3 = $dirty2;
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                        $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource);
                    } else {
                        mutableInteractionSource = it$iv$iv;
                    }
                    $composer3.endReplaceableGroup();
                    contentPadding2 = contentPadding4;
                    $dirty = $dirty3;
                    interactionSource2 = mutableInteractionSource;
                    modifier2 = modifier3;
                    leadingIcon2 = leadingIcon3;
                    trailingIcon2 = trailingIcon3;
                    enabled2 = enabled3;
                    colors2 = colors3;
                } else {
                    contentPadding2 = contentPadding3;
                    $dirty = $dirty2;
                    interactionSource2 = interactionSource;
                    modifier2 = modifier3;
                    leadingIcon2 = leadingIcon3;
                    trailingIcon2 = trailingIcon3;
                    enabled2 = enabled3;
                    colors2 = colors3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i4 & 64) != 0) {
                    leadingIcon2 = leadingIcon;
                    colors2 = colors;
                    contentPadding2 = contentPadding;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty2 & -3670017;
                    trailingIcon2 = function2;
                    enabled2 = z;
                    modifier2 = modifier;
                } else {
                    leadingIcon2 = leadingIcon;
                    colors2 = colors;
                    contentPadding2 = contentPadding;
                    interactionSource2 = interactionSource;
                    $dirty = $dirty2;
                    trailingIcon2 = function2;
                    enabled2 = z;
                    modifier2 = modifier;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1826340448, $dirty, -1, "androidx.compose.material3.DropdownMenuItem (AndroidMenu.android.kt:137)");
            }
            int i11 = $dirty;
            $composer2 = $composer3;
            MenuKt.DropdownMenuItemContent(text, onClick, modifier2, leadingIcon2, trailingIcon2, enabled2, colors2, contentPadding2, interactionSource2, $composer3, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752) | ($dirty & 3670016) | ($dirty & 29360128) | ($dirty & 234881024));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            leadingIcon2 = leadingIcon;
            colors2 = colors;
            contentPadding2 = contentPadding;
            interactionSource2 = interactionSource;
            int i12 = $dirty2;
            trailingIcon2 = function2;
            $composer2 = $composer3;
            enabled2 = z;
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidMenu_androidKt$DropdownMenuItem$2(text, onClick, modifier2, leadingIcon2, trailingIcon2, enabled2, colors2, contentPadding2, interactionSource2, $changed, i));
        }
    }
}
