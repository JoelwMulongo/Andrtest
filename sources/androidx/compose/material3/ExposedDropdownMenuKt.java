package androidx.compose.material3;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001aQ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a6\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\bH\u0002\u001aE\u0010\u0018\u001a\u00020\n*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010\u001e\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "updateHeight", "view", "Landroid/view/View;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "verticalMarginInPx", "", "onHeightUpdate", "expandable", "Lkotlin/Function0;", "menuDescription", "", "expandedDescription", "collapsedDescription", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExposedDropdownMenu.kt */
public final class ExposedDropdownMenuKt {
    /* access modifiers changed from: private */
    public static final float ExposedDropdownMenuItemHorizontalPadding = Dp.m5986constructorimpl((float) 16);

    /* JADX WARNING: Removed duplicated region for block: B:80:0x0332  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x03b3  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x03b9  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0435  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ExposedDropdownMenuBox(boolean r34, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r35, androidx.compose.ui.Modifier r36, kotlin.jvm.functions.Function3<? super androidx.compose.material3.ExposedDropdownMenuBoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r11 = r34
            r12 = r35
            r13 = r37
            r14 = r39
            java.lang.String r0 = "onExpandedChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -1990697039(0xffffffff89585fb1, float:-2.6045048E-33)
            r1 = r38
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ExposedDropdownMenuBox)P(1,3,2)108@5104L7,109@5137L7,110@5162L30,111@5215L30,113@5346L37,115@5410L29,117@5457L1282,147@6745L45,151@6796L70,155@6872L379:ExposedDropdownMenu.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r1)
            r1 = r39
            r2 = r40 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            goto L_0x0038
        L_0x002a:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r15.changed((boolean) r11)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = 2
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r40 & 2
            if (r2 == 0) goto L_0x003f
            r1 = r1 | 48
            goto L_0x004f
        L_0x003f:
            r2 = r14 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004f
            boolean r2 = r15.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x004c
            r2 = 32
            goto L_0x004e
        L_0x004c:
            r2 = 16
        L_0x004e:
            r1 = r1 | r2
        L_0x004f:
            r2 = r40 & 4
            if (r2 == 0) goto L_0x0058
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r36
            goto L_0x006d
        L_0x0058:
            r3 = r14 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x006b
            r3 = r36
            boolean r4 = r15.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0067
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r1 = r1 | r4
            goto L_0x006d
        L_0x006b:
            r3 = r36
        L_0x006d:
            r4 = r40 & 8
            if (r4 == 0) goto L_0x0074
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0074:
            r4 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0084
            boolean r4 = r15.changed((java.lang.Object) r13)
            if (r4 == 0) goto L_0x0081
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x0081:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r1 = r1 | r4
        L_0x0084:
            r8 = r1
            r1 = r8 & 5851(0x16db, float:8.199E-42)
            r4 = 1170(0x492, float:1.64E-42)
            if (r1 != r4) goto L_0x009c
            boolean r1 = r15.getSkipping()
            if (r1 != 0) goto L_0x0092
            goto L_0x009c
        L_0x0092:
            r15.skipToGroupEnd()
            r16 = r3
            r32 = r8
            r7 = r11
            goto L_0x0438
        L_0x009c:
            if (r2 == 0) goto L_0x00a5
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            r16 = r1
            goto L_0x00a7
        L_0x00a5:
            r16 = r3
        L_0x00a7:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00b3
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.kt:102)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r8, r1, r2)
        L_0x00b3:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r2 = 0
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r7, r6)
            java.lang.Object r3 = r15.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r5 = r3
            androidx.compose.ui.unit.Density r5 = (androidx.compose.ui.unit.Density) r5
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 0
            r2 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r7, r6)
            java.lang.Object r3 = r15.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r4 = r3
            android.view.View r4 = (android.view.View) r4
            r3 = 0
            r0 = r3
            r1 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r2)
            java.lang.String r7 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r7)
            r17 = 0
            r38 = r15
            r18 = 0
            java.lang.Object r9 = r38.rememberedValue()
            r20 = 0
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r21.getEmpty()
            r10 = 0
            if (r9 != r2) goto L_0x0118
            r2 = 0
            r23 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            r3 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r10, r3, r10)
            r2 = r38
            r2.updateRememberedValue(r0)
            goto L_0x011d
        L_0x0118:
            r2 = r38
            r23 = r0
            r0 = r9
        L_0x011d:
            r15.endReplaceableGroup()
            r17 = r0
            androidx.compose.runtime.MutableState r17 = (androidx.compose.runtime.MutableState) r17
            r0 = 0
            r1 = r0
            r0 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r7)
            r2 = 0
            r3 = r15
            r9 = 0
            java.lang.Object r10 = r3.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r23 = r0
            java.lang.Object r0 = r20.getEmpty()
            if (r10 != r0) goto L_0x015d
            r0 = 0
            r25 = r0
            r20 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)
            r26 = r1
            r38 = r10
            r1 = 0
            r10 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r1, r10, r1)
            r3.updateRememberedValue(r0)
            goto L_0x0164
        L_0x015d:
            r26 = r1
            r38 = r10
            r10 = 2
            r0 = r38
        L_0x0164:
            r15.endReplaceableGroup()
            r9 = r0
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            r0 = r5
            r1 = 0
            float r2 = androidx.compose.material3.MenuKt.getMenuVerticalMargin()
            int r3 = r0.m5961roundToPx0680j_4(r2)
            r0 = 0
            r1 = r0
            r0 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r7)
            r2 = 0
            r38 = r15
            r18 = 0
            java.lang.Object r10 = r38.rememberedValue()
            r20 = 0
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r25 = r0
            java.lang.Object r0 = r23.getEmpty()
            if (r10 != r0) goto L_0x01a8
            r0 = 0
            androidx.compose.ui.node.Ref r23 = new androidx.compose.ui.node.Ref
            r23.<init>()
            r0 = r23
            r23 = r1
            r1 = r38
            r1.updateRememberedValue(r0)
            goto L_0x01ad
        L_0x01a8:
            r23 = r1
            r1 = r38
            r0 = r10
        L_0x01ad:
            r15.endReplaceableGroup()
            r10 = r0
            androidx.compose.ui.node.Ref r10 = (androidx.compose.ui.node.Ref) r10
            r18 = 0
            r0 = r18
            r1 = 0
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r2)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r7)
            r2 = 0
            r7 = r15
            r20 = 0
            r38 = r0
            java.lang.Object r0 = r7.rememberedValue()
            r22 = 0
            androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
            r24 = r1
            java.lang.Object r1 = r23.getEmpty()
            if (r0 != r1) goto L_0x01e6
            r1 = 0
            androidx.compose.ui.focus.FocusRequester r23 = new androidx.compose.ui.focus.FocusRequester
            r23.<init>()
            r1 = r23
            r7.updateRememberedValue(r1)
            goto L_0x01e7
        L_0x01e6:
            r1 = r0
        L_0x01e7:
            r15.endReplaceableGroup()
            r7 = r1
            androidx.compose.ui.focus.FocusRequester r7 = (androidx.compose.ui.focus.FocusRequester) r7
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r34)
            int r1 = m1916ExposedDropdownMenuBox$lambda4(r9)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r2 = m1914ExposedDropdownMenuBox$lambda1(r17)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object[] r0 = new java.lang.Object[]{r0, r12, r5, r1, r2}
            r1 = 8
            r2 = r0
            r20 = r1
            r22 = 0
            r0 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r15.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r0)
            r0 = 0
            int r1 = r2.length
            r23 = r0
            r0 = r18
        L_0x021f:
            if (r0 >= r1) goto L_0x0230
            r24 = r1
            r1 = r2[r0]
            boolean r25 = r15.changed((java.lang.Object) r1)
            r23 = r23 | r25
            int r0 = r0 + 1
            r1 = r24
            goto L_0x021f
        L_0x0230:
            r1 = r15
            r24 = 0
            java.lang.Object r0 = r1.rememberedValue()
            r25 = 0
            if (r23 != 0) goto L_0x025f
            androidx.compose.runtime.Composer$Companion r26 = androidx.compose.runtime.Composer.Companion
            r38 = r1
            java.lang.Object r1 = r26.getEmpty()
            if (r0 != r1) goto L_0x0246
            goto L_0x0261
        L_0x0246:
            r12 = r38
            r28 = r0
            r29 = r2
            r38 = r3
            r18 = r4
            r30 = r5
            r14 = r6
            r31 = r7
            r32 = r8
            r36 = r9
            r33 = r10
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            goto L_0x0297
        L_0x025f:
            r38 = r1
        L_0x0261:
            r26 = 0
            androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 r27 = new androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1
            r28 = r0
            r0 = r27
            r12 = r38
            r1 = r34
            r29 = r2
            r2 = r35
            r38 = r3
            r14 = r18
            r3 = r8
            r18 = r4
            r4 = r7
            r30 = r5
            r5 = r10
            r14 = r6
            r6 = r18
            r31 = r7
            r11 = 2023513938(0x789c5f52, float:2.5372864E34)
            r7 = r38
            r32 = r8
            r8 = r17
            r36 = r9
            r33 = r10
            r10 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r12.updateRememberedValue(r0)
        L_0x0297:
            r15.endReplaceableGroup()
            androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 r0 = (androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1) r0
            int r1 = r32 >> 6
            r1 = r1 & 14
            r2 = 0
            r3 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r15.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r3)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getTopStart()
            r4 = 0
            int r5 = r1 >> 3
            r5 = r5 & 14
            int r6 = r1 >> 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r5 = r5 | r6
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r4, r15, r5)
            int r6 = r1 << 3
            r6 = r6 & 112(0x70, float:1.57E-43)
            r7 = 0
            r8 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r15.startReplaceableGroup(r8)
            java.lang.String r8 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r8)
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r8 = (androidx.compose.runtime.CompositionLocal) r8
            r9 = 6
            r10 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r11, r14)
            java.lang.Object r12 = r15.consume(r8)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r8 = r12
            androidx.compose.ui.unit.Density r8 = (androidx.compose.ui.unit.Density) r8
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r9 = (androidx.compose.runtime.CompositionLocal) r9
            r10 = 6
            r12 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r11, r14)
            java.lang.Object r19 = r15.consume(r9)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r9 = r19
            androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r10 = (androidx.compose.runtime.CompositionLocal) r10
            r12 = 6
            r19 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r11, r14)
            java.lang.Object r11 = r15.consume(r10)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r15)
            r10 = r11
            androidx.compose.ui.platform.ViewConfiguration r10 = (androidx.compose.ui.platform.ViewConfiguration) r10
            androidx.compose.ui.node.ComposeUiNode$Companion r11 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r11 = r11.getConstructor()
            kotlin.jvm.functions.Function3 r12 = androidx.compose.ui.layout.LayoutKt.materializerOf(r16)
            int r14 = r6 << 9
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r14 = r14 | 6
            r19 = 0
            r20 = r2
            androidx.compose.runtime.Applier r2 = r15.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x0335
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0335:
            r15.startReusableNode()
            boolean r2 = r15.getInserting()
            if (r2 == 0) goto L_0x0342
            r15.createNode(r11)
            goto L_0x0345
        L_0x0342:
            r15.useNode()
        L_0x0345:
            r15.disableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m2787constructorimpl(r15)
            r21 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r22 = androidx.compose.ui.node.ComposeUiNode.Companion
            r23 = r3
            kotlin.jvm.functions.Function2 r3 = r22.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r5, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r8, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r9, r3)
            androidx.compose.ui.node.ComposeUiNode$Companion r3 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r3 = r3.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r2, r10, r3)
            r15.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r15)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r2)
            int r3 = r14 >> 3
            r3 = r3 & 112(0x70, float:1.57E-43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.invoke(r2, r15, r3)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r15.startReplaceableGroup(r2)
            int r2 = r14 >> 9
            r2 = r2 & 14
            r3 = r15
            r21 = 0
            r22 = r4
            r4 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r3.startReplaceableGroup(r4)
            java.lang.String r4 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r3, r4)
            r4 = r2 & 11
            r24 = r2
            r2 = 2
            if (r4 != r2) goto L_0x03b9
            boolean r2 = r3.getSkipping()
            if (r2 != 0) goto L_0x03b3
            goto L_0x03b9
        L_0x03b3:
            r3.skipToGroupEnd()
            r27 = r1
            goto L_0x03fa
        L_0x03b9:
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r4 = r1 >> 6
            r4 = r4 & 112(0x70, float:1.57E-43)
            r4 = r4 | 6
            androidx.compose.foundation.layout.BoxScope r2 = (androidx.compose.foundation.layout.BoxScope) r2
            r25 = r3
            r26 = 0
            r27 = r1
            r1 = -738793417(0xffffffffd3f6e837, float:-2.12091575E12)
            r28 = r2
            r2 = r25
            r2.startReplaceableGroup(r1)
            java.lang.String r1 = "C148@6775L9:ExposedDropdownMenu.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            r1 = r4 & 81
            r25 = r4
            r4 = 16
            if (r1 != r4) goto L_0x03eb
            boolean r1 = r2.getSkipping()
            if (r1 != 0) goto L_0x03e7
            goto L_0x03eb
        L_0x03e7:
            r2.skipToGroupEnd()
            goto L_0x03f6
        L_0x03eb:
            int r1 = r32 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r13.invoke(r0, r2, r1)
        L_0x03f6:
            r2.endReplaceableGroup()
        L_0x03fa:
            r3.endReplaceableGroup()
            r15.endReplaceableGroup()
            r15.endNode()
            r15.endReplaceableGroup()
            r15.endReplaceableGroup()
            androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$2 r1 = new androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$2
            r7 = r34
            r2 = r31
            r1.<init>(r7, r2)
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r3 = 0
            androidx.compose.runtime.EffectsKt.SideEffect(r1, r15, r3)
            androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$3 r1 = new androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$3
            r4 = r36
            r5 = r38
            r3 = r18
            r6 = r33
            r1.<init>(r3, r6, r5, r4)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r8 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect((java.lang.Object) r3, (kotlin.jvm.functions.Function1<? super androidx.compose.runtime.DisposableEffectScope, ? extends androidx.compose.runtime.DisposableEffectResult>) r1, (androidx.compose.runtime.Composer) r15, (int) r8)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0438
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0438:
            androidx.compose.runtime.ScopeUpdateScope r8 = r15.endRestartGroup()
            if (r8 != 0) goto L_0x043f
            goto L_0x0456
        L_0x043f:
            androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4 r9 = new androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$4
            r0 = r9
            r1 = r34
            r2 = r35
            r3 = r16
            r4 = r37
            r5 = r39
            r6 = r40
            r0.<init>(r1, r2, r3, r4, r5, r6)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r8.updateScope(r9)
        L_0x0456:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuKt.ExposedDropdownMenuBox(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuBox$lambda-1  reason: not valid java name */
    public static final int m1914ExposedDropdownMenuBox$lambda1(MutableState<Integer> $width$delegate) {
        return ((Number) $width$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuBox$lambda-2  reason: not valid java name */
    public static final void m1915ExposedDropdownMenuBox$lambda2(MutableState<Integer> $width$delegate, int value) {
        $width$delegate.setValue(Integer.valueOf(value));
    }

    /* access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuBox$lambda-4  reason: not valid java name */
    public static final int m1916ExposedDropdownMenuBox$lambda4(MutableState<Integer> $menuHeight$delegate) {
        return ((Number) $menuHeight$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ExposedDropdownMenuBox$lambda-5  reason: not valid java name */
    public static final void m1917ExposedDropdownMenuBox$lambda5(MutableState<Integer> $menuHeight$delegate, int value) {
        $menuHeight$delegate.setValue(Integer.valueOf(value));
    }

    /* access modifiers changed from: private */
    public static final Modifier expandable(Modifier $this$expandable, boolean expanded, Function0<Unit> onExpandedChange, String menuDescription, String expandedDescription, String collapsedDescription, Composer $composer, int $changed, int i) {
        String expandedDescription2;
        String collapsedDescription2;
        Object value$iv$iv;
        boolean z;
        Function0<Unit> function0 = onExpandedChange;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(1006563320);
        ComposerKt.sourceInformation(composer, "C(expandable)P(1,4,3,2)525@26777L38,526@26851L31,527@26919L32,528@26976L392,542@27379L187:ExposedDropdownMenu.kt#uh7d8r");
        String menuDescription2 = (i & 4) != 0 ? Strings_androidKt.m2089getStringNWtq28(Strings.Companion.m2083getExposedDropdownMenuadMyvUU(), composer, 6) : menuDescription;
        if ((i & 8) != 0) {
            expandedDescription2 = Strings_androidKt.m2089getStringNWtq28(Strings.Companion.m2085getMenuExpandedadMyvUU(), composer, 6);
        } else {
            expandedDescription2 = expandedDescription;
        }
        if ((i & 16) != 0) {
            collapsedDescription2 = Strings_androidKt.m2089getStringNWtq28(Strings.Companion.m2084getMenuCollapsedadMyvUU(), composer, 6);
        } else {
            collapsedDescription2 = collapsedDescription;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1006563320, i2, -1, "androidx.compose.material3.expandable (ExposedDropdownMenu.kt:522)");
        }
        Unit unit = Unit.INSTANCE;
        int $changed$iv = ((i2 >> 6) & 14) | 64;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) function0);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            int i3 = $changed$iv;
            value$iv$iv = (Function2) new ExposedDropdownMenuKt$expandable$1$1(function0, (Continuation<? super ExposedDropdownMenuKt$expandable$1$1>) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            int i4 = $changed$iv;
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput($this$expandable, (Object) unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv);
        Object[] keys$iv = {Boolean.valueOf(expanded), expandedDescription2, collapsedDescription2, menuDescription2, function0};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv2 = $composer;
        Object value$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv || value$iv$iv2 == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv2;
            z = false;
            value$iv$iv2 = new ExposedDropdownMenuKt$expandable$2$1(expanded, expandedDescription2, collapsedDescription2, menuDescription2, onExpandedChange);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            Object obj2 = value$iv$iv2;
            Composer composer2 = $this$cache$iv$iv2;
            z = false;
        }
        $composer.endReplaceableGroup();
        Modifier semantics$default = SemanticsModifierKt.semantics$default(pointerInput, z, (Function1) value$iv$iv2, 1, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return semantics$default;
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
