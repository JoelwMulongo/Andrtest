package androidx.compose.material;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0002\u0010\f\u001a6\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0005H\u0002\u001a\"\u0010\u0015\u001a\u00020\u0007*\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u0019"}, d2 = {"ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "updateHeight", "view", "Landroid/view/View;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "expandable", "Lkotlin/Function0;", "menuLabel", "", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
public final class ExposedDropdownMenuKt {
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02a9  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0385  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0391  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0395  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0467  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0469  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x049b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ExposedDropdownMenuBox(boolean r38, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r39, androidx.compose.ui.Modifier r40, kotlin.jvm.functions.Function3<? super androidx.compose.material.ExposedDropdownMenuBoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            r7 = r38
            r8 = r39
            r9 = r41
            r10 = r43
            java.lang.String r0 = "onExpandedChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 1456052980(0x56c99af4, float:1.10833678E14)
            r1 = r42
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ExposedDropdownMenuBox)P(1,3,2)93@4039L7,94@4072L7,95@4097L30,96@4150L30,98@4281L37,100@4336L486,113@4848L29,127@5259L31,128@5316L38,115@4883L550,134@5450L59,134@5439L70,138@5515L441:ExposedDropdownMenu.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r43
            r2 = r44 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            goto L_0x0038
        L_0x002a:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r11.changed((boolean) r7)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = 2
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r44 & 2
            if (r2 == 0) goto L_0x003f
            r1 = r1 | 48
            goto L_0x004f
        L_0x003f:
            r2 = r10 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004f
            boolean r2 = r11.changedInstance(r8)
            if (r2 == 0) goto L_0x004c
            r2 = 32
            goto L_0x004e
        L_0x004c:
            r2 = 16
        L_0x004e:
            r1 = r1 | r2
        L_0x004f:
            r2 = r44 & 4
            if (r2 == 0) goto L_0x0058
            r1 = r1 | 384(0x180, float:5.38E-43)
            r4 = r40
            goto L_0x006d
        L_0x0058:
            r4 = r10 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006b
            r4 = r40
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0067
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r1 = r1 | r5
            goto L_0x006d
        L_0x006b:
            r4 = r40
        L_0x006d:
            r5 = r44 & 8
            if (r5 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0074:
            r5 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0084
            boolean r5 = r11.changedInstance(r9)
            if (r5 == 0) goto L_0x0081
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x0081:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r1 = r1 | r5
        L_0x0084:
            r12 = r1
            r1 = r12 & 5851(0x16db, float:8.199E-42)
            r5 = 1170(0x492, float:1.64E-42)
            if (r1 != r5) goto L_0x0099
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x0092
            goto L_0x0099
        L_0x0092:
            r11.skipToGroupEnd()
            r17 = r4
            goto L_0x049e
        L_0x0099:
            if (r2 == 0) goto L_0x00a0
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x00a1
        L_0x00a0:
            r1 = r4
        L_0x00a1:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x00ad
            r2 = -1
            java.lang.String r4 = "androidx.compose.material.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:87)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r2, r4)
        L_0x00ad:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r2 = 0
            r4 = 0
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r6)
            java.lang.Object r13 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r0 = r13
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            r4 = 0
            r13 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r6)
            java.lang.Object r6 = r11.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            r2 = r6
            android.view.View r2 = (android.view.View) r2
            r4 = 0
            r6 = r4
            r13 = 0
            r14 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r14)
            java.lang.String r15 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r15)
            r16 = 0
            r40 = r11
            r17 = 0
            java.lang.Object r5 = r40.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r19.getEmpty()
            r3 = 0
            if (r5 != r14) goto L_0x0113
            r14 = 0
            r21 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r4 = 2
            androidx.compose.runtime.MutableState r5 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r5, r3, r4, r3)
            r4 = r5
            r5 = r40
            r5.updateRememberedValue(r4)
            goto L_0x0119
        L_0x0113:
            r21 = r5
            r5 = r40
            r4 = r21
        L_0x0119:
            r11.endReplaceableGroup()
            androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
            r5 = 0
            r6 = r5
            r5 = 0
            r13 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r15)
            r13 = 0
            r14 = r11
            r16 = 0
            java.lang.Object r3 = r14.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r21 = r5
            java.lang.Object r5 = r18.getEmpty()
            if (r3 != r5) goto L_0x0159
            r5 = 0
            r22 = r3
            r18 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r18)
            r23 = r5
            r40 = r6
            r5 = 0
            r6 = 2
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r5, r6, r5)
            r14.updateRememberedValue(r3)
            goto L_0x015d
        L_0x0159:
            r22 = r3
            r40 = r6
        L_0x015d:
            r11.endReplaceableGroup()
            androidx.compose.runtime.MutableState r3 = (androidx.compose.runtime.MutableState) r3
            r5 = r0
            r6 = 0
            float r13 = androidx.compose.material.MenuKt.getMenuVerticalMargin()
            int r5 = r5.m5961roundToPx0680j_4(r13)
            r6 = 0
            r13 = r6
            r6 = 0
            r14 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r14)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r15)
            r14 = 0
            r40 = r11
            r16 = 0
            r17 = r6
            java.lang.Object r6 = r40.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r19.getEmpty()
            if (r6 != r10) goto L_0x01a0
            r10 = 0
            androidx.compose.ui.node.Ref r19 = new androidx.compose.ui.node.Ref
            r19.<init>()
            r10 = r19
            r19 = r6
            r6 = r40
            r6.updateRememberedValue(r10)
            goto L_0x01a6
        L_0x01a0:
            r19 = r6
            r6 = r40
            r10 = r19
        L_0x01a6:
            r11.endReplaceableGroup()
            r6 = r10
            androidx.compose.ui.node.Ref r6 = (androidx.compose.ui.node.Ref) r6
            int r10 = ExposedDropdownMenuBox$lambda$4(r3)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            int r13 = ExposedDropdownMenuBox$lambda$1(r4)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r14 = 0
            r16 = 0
            r40 = r14
            r14 = 1618982084(0x607fb4c4, float:7.370227E19)
            r11.startReplaceableGroup(r14)
            java.lang.String r14 = "CC(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r14)
            boolean r14 = r11.changed((java.lang.Object) r0)
            boolean r17 = r11.changed((java.lang.Object) r10)
            r14 = r14 | r17
            boolean r17 = r11.changed((java.lang.Object) r13)
            r14 = r14 | r17
            r17 = r11
            r18 = 0
            r19 = r10
            java.lang.Object r10 = r17.rememberedValue()
            r21 = 0
            if (r14 != 0) goto L_0x01fc
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r23 = r13
            java.lang.Object r13 = r22.getEmpty()
            if (r10 != r13) goto L_0x01f7
            goto L_0x01fe
        L_0x01f7:
            r22 = r10
            r13 = r17
            goto L_0x020d
        L_0x01fc:
            r23 = r13
        L_0x01fe:
            r13 = 0
            r22 = r10
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 r10 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1
            r10.<init>(r0, r3, r4)
            r13 = r17
            r13.updateRememberedValue(r10)
        L_0x020d:
            r11.endReplaceableGroup()
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 r10 = (androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) r10
            r13 = 0
            r14 = r13
            r13 = 0
            r40 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r0)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r15)
            r0 = 0
            r15 = r11
            r16 = 0
            r17 = r0
            java.lang.Object r0 = r15.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r20 = r13
            java.lang.Object r13 = r19.getEmpty()
            if (r0 != r13) goto L_0x0245
            r13 = 0
            androidx.compose.ui.focus.FocusRequester r19 = new androidx.compose.ui.focus.FocusRequester
            r19.<init>()
            r13 = r19
            r15.updateRememberedValue(r13)
            goto L_0x0246
        L_0x0245:
            r13 = r0
        L_0x0246:
            r11.endReplaceableGroup()
            r0 = r13
            androidx.compose.ui.focus.FocusRequester r0 = (androidx.compose.ui.focus.FocusRequester) r0
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$1 r13 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$1
            r14 = r13
            r15 = r6
            r16 = r2
            r17 = r5
            r18 = r4
            r19 = r3
            r14.<init>(r15, r16, r17, r18, r19)
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r1, r13)
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r38)
            int r15 = r12 >> 3
            r15 = r15 & 14
            int r16 = r12 << 3
            r16 = r16 & 112(0x70, float:1.57E-43)
            r15 = r15 | r16
            r16 = 0
            r17 = r1
            r1 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r1)
            java.lang.String r1 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            boolean r19 = r11.changed((java.lang.Object) r8)
            boolean r20 = r11.changed((java.lang.Object) r14)
            r19 = r19 | r20
            r20 = r11
            r21 = 0
            r22 = r4
            java.lang.Object r4 = r20.rememberedValue()
            r23 = 0
            if (r19 != 0) goto L_0x02a9
            androidx.compose.runtime.Composer$Companion r24 = androidx.compose.runtime.Composer.Companion
            r25 = r14
            java.lang.Object r14 = r24.getEmpty()
            if (r4 != r14) goto L_0x02a4
            goto L_0x02ab
        L_0x02a4:
            r24 = r4
            r14 = r20
            goto L_0x02bc
        L_0x02a9:
            r25 = r14
        L_0x02ab:
            r14 = 0
            r24 = r4
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1 r4 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$2$1
            r4.<init>(r8, r7)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r14 = r20
            r14.updateRememberedValue(r4)
        L_0x02bc:
            r11.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            androidx.compose.material.Strings$Companion r14 = androidx.compose.material.Strings.Companion
            int r14 = r14.m1614getExposedDropdownMenuUdPEhr4()
            r15 = 6
            java.lang.String r14 = androidx.compose.material.Strings_androidKt.m1618getString4foXLRw(r14, r11, r15)
            androidx.compose.ui.Modifier r4 = expandable(r13, r4, r14)
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.focus.FocusRequesterModifierKt.focusRequester(r4, r0)
            r13 = 0
            r14 = r13
            r13 = 0
            r15 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r11.startReplaceableGroup(r15)
            java.lang.String r15 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r15)
            androidx.compose.ui.Alignment$Companion r15 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r15 = r15.getTopStart()
            r8 = 0
            int r19 = r14 >> 3
            r19 = r19 & 14
            int r20 = r14 >> 3
            r20 = r20 & 112(0x70, float:1.57E-43)
            r21 = r13
            r13 = r19 | r20
            androidx.compose.ui.layout.MeasurePolicy r13 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r15, r8, r11, r13)
            int r19 = r14 << 3
            r19 = r19 & 112(0x70, float:1.57E-43)
            r20 = 0
            r23 = r8
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r11.startReplaceableGroup(r8)
            java.lang.String r8 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r8)
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r24 = 6
            r25 = 0
            r26 = r15
            java.lang.String r15 = "C:CompositionLocal.kt#9igjgp"
            r27 = r2
            r2 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r2, r15)
            java.lang.Object r2 = r11.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.Density r2 = (androidx.compose.ui.unit.Density) r2
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r24 = 6
            r25 = 0
            r28 = r3
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r15)
            java.lang.Object r3 = r11.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r24 = 6
            r25 = 0
            r29 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r5, r15)
            java.lang.Object r5 = r11.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
            kotlin.jvm.functions.Function3 r15 = androidx.compose.ui.layout.LayoutKt.materializerOf(r4)
            r42 = r4
            int r4 = r19 << 9
            r4 = r4 & 7168(0x1c00, float:1.0045E-41)
            r16 = 6
            r4 = r4 | 6
            r24 = 0
            r25 = r6
            androidx.compose.runtime.Applier r6 = r11.getApplier()
            boolean r6 = r6 instanceof androidx.compose.runtime.Applier
            if (r6 != 0) goto L_0x0388
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0388:
            r11.startReusableNode()
            boolean r6 = r11.getInserting()
            if (r6 == 0) goto L_0x0395
            r11.createNode(r8)
            goto L_0x0398
        L_0x0395:
            r11.useNode()
        L_0x0398:
            r11.disableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.Updater.m2787constructorimpl(r11)
            r30 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r31 = androidx.compose.ui.node.ComposeUiNode.Companion
            r32 = r8
            kotlin.jvm.functions.Function2 r8 = r31.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r6, r13, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r6, r2, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r6, r3, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r6, r5, r8)
            r11.enableReusing()
            androidx.compose.runtime.Composer r6 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r11)
            androidx.compose.runtime.SkippableUpdater r6 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r6)
            int r8 = r4 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r15.invoke(r6, r11, r8)
            r6 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r11.startReplaceableGroup(r6)
            int r6 = r4 >> 9
            r6 = r6 & 14
            r8 = r11
            r30 = 0
            r31 = r2
            r2 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r33 = r3
            java.lang.String r3 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r2, r3)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r3 = r14 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r16 = 6
            r3 = r3 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r16 = r8
            r34 = 0
            r35 = r2
            r2 = 1560854564(0x5d08c024, float:6.1586972E17)
            r36 = r3
            java.lang.String r3 = "C131@5418L9:ExposedDropdownMenu.kt#jmzs0o"
            r37 = r4
            r4 = r16
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r2, r3)
            int r2 = r12 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r9.invoke(r10, r4, r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
            r11.endReplaceableGroup()
            r11.endNode()
            r11.endReplaceableGroup()
            r11.endReplaceableGroup()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r38)
            r3 = r12 & 14
            r3 = r3 | 48
            r4 = 0
            r5 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r5)
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            boolean r1 = r11.changed((java.lang.Object) r2)
            boolean r5 = r11.changed((java.lang.Object) r0)
            r1 = r1 | r5
            r5 = r11
            r6 = 0
            java.lang.Object r8 = r5.rememberedValue()
            r13 = 0
            if (r1 != 0) goto L_0x0469
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r8 != r14) goto L_0x0467
            goto L_0x0469
        L_0x0467:
            r14 = r8
            goto L_0x0476
        L_0x0469:
            r14 = 0
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4$1 r15 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4$1
            r15.<init>(r7, r0)
            kotlin.jvm.functions.Function0 r15 = (kotlin.jvm.functions.Function0) r15
            r14 = r15
            r5.updateRememberedValue(r14)
        L_0x0476:
            r11.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            r1 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r14, r11, r1)
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5 r1 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5
            r5 = r25
            r2 = r27
            r3 = r28
            r4 = r29
            r1.<init>(r2, r5, r4, r3)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r6 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r2, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r1, (androidx.compose.runtime.Composer) r11, (int) r6)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x049e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x049e:
            androidx.compose.runtime.ScopeUpdateScope r8 = r11.endRestartGroup()
            if (r8 != 0) goto L_0x04a5
            goto L_0x04bc
        L_0x04a5:
            androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$6 r10 = new androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$6
            r0 = r10
            r1 = r38
            r2 = r39
            r3 = r17
            r4 = r41
            r5 = r43
            r6 = r44
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r8.updateScope(r10)
        L_0x04bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuKt.ExposedDropdownMenuBox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$1(MutableState<Integer> $width$delegate) {
        return ((Number) $width$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$2(MutableState<Integer> $width$delegate, int value) {
        $width$delegate.setValue(Integer.valueOf(value));
    }

    /* access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$4(MutableState<Integer> $menuHeight$delegate) {
        return ((Number) $menuHeight$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public static final void ExposedDropdownMenuBox$lambda$5(MutableState<Integer> $menuHeight$delegate, int value) {
        $menuHeight$delegate.setValue(Integer.valueOf(value));
    }

    private static final Modifier expandable(Modifier $this$expandable, Function0<Unit> onExpandedChange, String menuLabel) {
        return SemanticsModifierKt.semantics$default(SuspendingPointerInputFilterKt.pointerInput($this$expandable, (Object) Unit.INSTANCE, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new ExposedDropdownMenuKt$expandable$1(onExpandedChange, (Continuation<? super ExposedDropdownMenuKt$expandable$1>) null)), false, new ExposedDropdownMenuKt$expandable$2(menuLabel, onExpandedChange), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void updateHeight(View view, LayoutCoordinates coordinates, int verticalMarginInPx, Function1<? super Integer, Unit> onHeightUpdate) {
        if (coordinates != null) {
            Rect visibleWindowBounds = new Rect();
            view.getWindowVisibleDisplayFrame(visibleWindowBounds);
            onHeightUpdate.invoke(Integer.valueOf(((int) Math.max(LayoutCoordinatesKt.boundsInWindow(coordinates).getTop() - ((float) visibleWindowBounds.top), ((float) (visibleWindowBounds.bottom - visibleWindowBounds.top)) - LayoutCoordinatesKt.boundsInWindow(coordinates).getBottom())) - verticalMarginInPx));
        }
    }
}
