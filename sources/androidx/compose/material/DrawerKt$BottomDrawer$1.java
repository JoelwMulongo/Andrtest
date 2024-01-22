package androidx.compose.material;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Drawer.kt */
final class DrawerKt$BottomDrawer$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ BottomDrawerState $drawerState;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerKt$BottomDrawer$1(boolean z, BottomDrawerState bottomDrawerState, Function2<? super Composer, ? super Integer, Unit> function2, int i, long j, Shape shape, long j2, long j3, float f, CoroutineScope coroutineScope, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$gesturesEnabled = z;
        this.$drawerState = bottomDrawerState;
        this.$content = function2;
        this.$$dirty = i;
        this.$scrimColor = j;
        this.$drawerShape = shape;
        this.$drawerBackgroundColor = j2;
        this.$drawerContentColor = j3;
        this.$drawerElevation = f;
        this.$scope = coroutineScope;
        this.$drawerContent = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((BoxWithConstraintsScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0328  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0361  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x03c2  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0449  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope r59, androidx.compose.runtime.Composer r60, int r61) {
        /*
            r58 = this;
            r0 = r58
            r1 = r59
            r2 = r60
            r3 = r61
            java.lang.String r4 = "$this$BoxWithConstraints"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "C535@19776L51,*554@20616L7,576@21303L1672:Drawer.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r4)
            r4 = r61
            r5 = r3 & 14
            if (r5 != 0) goto L_0x0022
            boolean r5 = r2.changed((java.lang.Object) r1)
            if (r5 == 0) goto L_0x0020
            r5 = 4
            goto L_0x0021
        L_0x0020:
            r5 = 2
        L_0x0021:
            r4 = r4 | r5
        L_0x0022:
            r5 = r4 & 91
            r7 = 18
            if (r5 != r7) goto L_0x0036
            boolean r5 = r60.getSkipping()
            if (r5 != 0) goto L_0x002f
            goto L_0x0036
        L_0x002f:
            r60.skipToGroupEnd()
            r19 = r4
            goto L_0x044c
        L_0x0036:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x0045
            r5 = -1
            java.lang.String r7 = "androidx.compose.material.BottomDrawer.<anonymous> (Drawer.kt:533)"
            r8 = 1220102512(0x48b94970, float:379467.5)
            androidx.compose.runtime.ComposerKt.traceEventStart(r8, r3, r5, r7)
        L_0x0045:
            long r7 = r59.m714getConstraintsmsEJaDk()
            int r5 = androidx.compose.ui.unit.Constraints.m5929getMaxHeightimpl(r7)
            float r5 = (float) r5
            java.lang.Float r7 = java.lang.Float.valueOf(r5)
            r8 = 0
            r9 = r8
            r10 = 0
            r11 = 1157296644(0x44faf204, float:2007.563)
            r2.startReplaceableGroup(r11)
            java.lang.String r12 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r12)
            boolean r13 = r2.changed((java.lang.Object) r7)
            r14 = r60
            r15 = 0
            java.lang.Object r11 = r14.rememberedValue()
            r17 = 0
            r8 = 0
            if (r13 != 0) goto L_0x007b
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r18.getEmpty()
            if (r11 != r6) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            r1 = r11
            goto L_0x008a
        L_0x007b:
            r6 = 0
            java.lang.Float r1 = java.lang.Float.valueOf(r5)
            r3 = 2
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r1, r8, r3, r8)
            r14.updateRememberedValue(r1)
        L_0x008a:
            r60.endReplaceableGroup()
            androidx.compose.runtime.MutableState r1 = (androidx.compose.runtime.MutableState) r1
            long r6 = r59.m714getConstraintsmsEJaDk()
            int r3 = androidx.compose.ui.unit.Constraints.m5930getMaxWidthimpl(r6)
            long r6 = r59.m714getConstraintsmsEJaDk()
            int r6 = androidx.compose.ui.unit.Constraints.m5929getMaxHeightimpl(r6)
            r7 = 1
            if (r3 <= r6) goto L_0x00a6
            r3 = r7
            goto L_0x00a7
        L_0x00a6:
            r3 = 0
        L_0x00a7:
            r6 = 0
            r9 = 1056964608(0x3f000000, float:0.5)
            float r9 = r9 * r5
            float r10 = invoke$lambda$1(r1)
            float r10 = r5 - r10
            float r10 = java.lang.Math.max(r6, r10)
            float r11 = invoke$lambda$1(r1)
            int r11 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x00f3
            if (r3 == 0) goto L_0x00c1
            r14 = 2
            goto L_0x00f4
        L_0x00c1:
            r11 = 3
            kotlin.Pair[] r11 = new kotlin.Pair[r11]
            java.lang.Float r13 = java.lang.Float.valueOf(r5)
            androidx.compose.material.BottomDrawerValue r14 = androidx.compose.material.BottomDrawerValue.Closed
            kotlin.Pair r13 = kotlin.TuplesKt.to(r13, r14)
            r14 = 0
            r11[r14] = r13
            java.lang.Float r13 = java.lang.Float.valueOf(r9)
            androidx.compose.material.BottomDrawerValue r14 = androidx.compose.material.BottomDrawerValue.Open
            kotlin.Pair r13 = kotlin.TuplesKt.to(r13, r14)
            r11[r7] = r13
            java.lang.Float r13 = java.lang.Float.valueOf(r10)
            androidx.compose.material.BottomDrawerValue r14 = androidx.compose.material.BottomDrawerValue.Expanded
            kotlin.Pair r13 = kotlin.TuplesKt.to(r13, r14)
            r14 = 2
            r11[r14] = r13
            java.util.Map r11 = kotlin.collections.MapsKt.mapOf(r11)
            r22 = r11
            goto L_0x0116
        L_0x00f3:
            r14 = 2
        L_0x00f4:
            kotlin.Pair[] r11 = new kotlin.Pair[r14]
            java.lang.Float r13 = java.lang.Float.valueOf(r5)
            androidx.compose.material.BottomDrawerValue r14 = androidx.compose.material.BottomDrawerValue.Closed
            kotlin.Pair r13 = kotlin.TuplesKt.to(r13, r14)
            r14 = 0
            r11[r14] = r13
            java.lang.Float r13 = java.lang.Float.valueOf(r10)
            androidx.compose.material.BottomDrawerValue r14 = androidx.compose.material.BottomDrawerValue.Expanded
            kotlin.Pair r13 = kotlin.TuplesKt.to(r13, r14)
            r11[r7] = r13
            java.util.Map r11 = kotlin.collections.MapsKt.mapOf(r11)
            r22 = r11
        L_0x0116:
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r11 = (androidx.compose.runtime.CompositionLocal) r11
            r13 = 0
            r14 = 0
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r7 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r15, r7)
            java.lang.Object r7 = r2.consume(r11)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r60)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            r11 = 0
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            r23 = r13
            androidx.compose.ui.Modifier r23 = (androidx.compose.ui.Modifier) r23
            r24 = 0
            r25 = 0
            long r13 = r59.m714getConstraintsmsEJaDk()
            int r13 = androidx.compose.ui.unit.Constraints.m5930getMaxWidthimpl(r13)
            float r26 = r7.m5964toDpu2uoSUM((int) r13)
            long r13 = r59.m714getConstraintsmsEJaDk()
            int r13 = androidx.compose.ui.unit.Constraints.m5929getMaxHeightimpl(r13)
            float r27 = r7.m5964toDpu2uoSUM((int) r13)
            r28 = 3
            r29 = 0
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m834sizeInqDBjuR0$default(r23, r24, r25, r26, r27, r28, r29)
            boolean r11 = r0.$gesturesEnabled
            if (r11 == 0) goto L_0x0170
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
            androidx.compose.material.BottomDrawerState r13 = r0.$drawerState
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r13 = r13.getNestedScrollConnection$material_release()
            r14 = 2
            androidx.compose.ui.Modifier r11 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll$default(r11, r13, r8, r14, r8)
            goto L_0x0174
        L_0x0170:
            androidx.compose.ui.Modifier$Companion r11 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r11 = (androidx.compose.ui.Modifier) r11
        L_0x0174:
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r20 = r13.then(r11)
            androidx.compose.material.BottomDrawerState r13 = r0.$drawerState
            r21 = r13
            androidx.compose.material.SwipeableState r21 = (androidx.compose.material.SwipeableState) r21
            androidx.compose.foundation.gestures.Orientation r23 = androidx.compose.foundation.gestures.Orientation.Vertical
            boolean r13 = r0.$gesturesEnabled
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 368(0x170, float:5.16E-43)
            r31 = 0
            r24 = r13
            androidx.compose.ui.Modifier r13 = androidx.compose.material.SwipeableKt.m1633swipeablepPrIpRY$default(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r14 = r0.$content
            int r8 = r0.$$dirty
            r20 = r3
            r19 = r4
            long r3 = r0.$scrimColor
            androidx.compose.material.BottomDrawerState r15 = r0.$drawerState
            r35 = r5
            androidx.compose.ui.graphics.Shape r5 = r0.$drawerShape
            r36 = r9
            r37 = r10
            long r9 = r0.$drawerBackgroundColor
            r29 = r9
            long r9 = r0.$drawerContentColor
            r38 = r6
            float r6 = r0.$drawerElevation
            r39 = r11
            boolean r11 = r0.$gesturesEnabled
            r31 = r6
            kotlinx.coroutines.CoroutineScope r6 = r0.$scope
            r32 = r9
            kotlin.jvm.functions.Function3<androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r9 = r0.$drawerContent
            r10 = 0
            r40 = 0
            r0 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r0 = r0.getTopStart()
            r34 = r5
            r5 = 0
            int r23 = r10 >> 3
            r23 = r23 & 14
            int r24 = r10 >> 3
            r24 = r24 & 112(0x70, float:1.57E-43)
            r41 = r9
            r9 = r23 | r24
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r0, r5, r2, r9)
            int r23 = r10 << 3
            r23 = r23 & 112(0x70, float:1.57E-43)
            r42 = r23
            r43 = 0
            r44 = r0
            r0 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r2.startReplaceableGroup(r0)
            java.lang.String r0 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r0)
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r23 = 6
            r24 = 0
            r45 = r5
            java.lang.String r5 = "C:CompositionLocal.kt#9igjgp"
            r46 = r1
            r1 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r1, r5)
            java.lang.Object r1 = r2.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r60)
            r0 = r1
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r23 = 6
            r24 = 0
            r47 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r7, r5)
            java.lang.Object r7 = r2.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r60)
            r1 = r7
            androidx.compose.ui.unit.LayoutDirection r1 = (androidx.compose.ui.unit.LayoutDirection) r1
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r23 = 6
            r24 = 0
            r48 = r12
            r12 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r12, r5)
            java.lang.Object r5 = r2.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r60)
            androidx.compose.ui.platform.ViewConfiguration r5 = (androidx.compose.ui.platform.ViewConfiguration) r5
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r7 = r7.getConstructor()
            kotlin.jvm.functions.Function3 r12 = androidx.compose.ui.layout.LayoutKt.materializerOf(r13)
            r21 = r13
            int r13 = r42 << 9
            r13 = r13 & 7168(0x1c00, float:1.0045E-41)
            r23 = r3
            r3 = 6
            r4 = r13 | 6
            r13 = 0
            androidx.compose.runtime.Applier r3 = r60.getApplier()
            boolean r3 = r3 instanceof androidx.compose.runtime.Applier
            if (r3 != 0) goto L_0x027a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x027a:
            r60.startReusableNode()
            boolean r3 = r60.getInserting()
            if (r3 == 0) goto L_0x0287
            r2.createNode(r7)
            goto L_0x028a
        L_0x0287:
            r60.useNode()
        L_0x028a:
            r60.disableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m2787constructorimpl(r60)
            r25 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r26 = androidx.compose.ui.node.ComposeUiNode.Companion
            r50 = r7
            kotlin.jvm.functions.Function2 r7 = r26.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r9, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r0, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r1, r7)
            androidx.compose.ui.node.ComposeUiNode$Companion r7 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r7 = r7.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r3, r5, r7)
            r60.enableReusing()
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r60)
            androidx.compose.runtime.SkippableUpdater r3 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r3)
            int r7 = r4 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r12.invoke(r3, r2, r7)
            r3 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r2.startReplaceableGroup(r3)
            int r3 = r4 >> 9
            r3 = r3 & 14
            r7 = r60
            r51 = 0
            r52 = r0
            r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r53 = r1
            java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r7, r0, r1)
            androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = r10 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r25 = 6
            r1 = r1 | 6
            androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
            r54 = r7
            r55 = 0
            r56 = r0
            r0 = 1720990324(0x66943a74, float:3.4999425E23)
            r57 = r1
            java.lang.String r1 = "C577@21332L9,578@21354L427,589@21815L33,592@21932L63,593@22038L105,590@21861L1104:Drawer.kt#jmzs0o"
            r2 = r54
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
            int r0 = r8 >> 27
            r0 = r0 & 14
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r14.invoke(r2, r0)
            androidx.compose.material.DrawerKt$BottomDrawer$1$1$1 r0 = new androidx.compose.material.DrawerKt$BottomDrawer$1$1$1
            r0.<init>(r11, r15, r6)
            r25 = r0
            kotlin.jvm.functions.Function0 r25 = (kotlin.jvm.functions.Function0) r25
            java.lang.Object r0 = r15.getTargetValue()
            androidx.compose.material.BottomDrawerValue r1 = androidx.compose.material.BottomDrawerValue.Closed
            if (r0 == r1) goto L_0x0328
            r26 = 1
            goto L_0x032a
        L_0x0328:
            r26 = 0
        L_0x032a:
            int r0 = r8 >> 24
            r28 = r0 & 14
            r27 = r2
            androidx.compose.material.DrawerKt.m1487BottomDrawerScrim3JVO9M(r23, r25, r26, r27, r28)
            androidx.compose.material.Strings$Companion r0 = androidx.compose.material.Strings.Companion
            int r0 = r0.m1615getNavigationMenuUdPEhr4()
            r1 = 6
            java.lang.String r0 = androidx.compose.material.Strings_androidKt.m1618getString4foXLRw(r0, r2, r1)
            int r1 = r8 >> 6
            r1 = r1 & 14
            r11 = 0
            r14 = 1157296644(0x44faf204, float:2007.563)
            r2.startReplaceableGroup(r14)
            r14 = r48
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r14)
            boolean r23 = r2.changed((java.lang.Object) r15)
            r24 = r2
            r25 = 0
            r26 = r1
            java.lang.Object r1 = r24.rememberedValue()
            r27 = 0
            if (r23 != 0) goto L_0x0371
            androidx.compose.runtime.Composer$Companion r28 = androidx.compose.runtime.Composer.Companion
            r48 = r3
            java.lang.Object r3 = r28.getEmpty()
            if (r1 != r3) goto L_0x036c
            goto L_0x0373
        L_0x036c:
            r28 = r1
            r3 = r24
            goto L_0x0384
        L_0x0371:
            r48 = r3
        L_0x0373:
            r3 = 0
            r28 = r1
            androidx.compose.material.DrawerKt$BottomDrawer$1$1$2$1 r1 = new androidx.compose.material.DrawerKt$BottomDrawer$1$1$2$1
            r1.<init>(r15)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r3 = r24
            r3.updateRememberedValue(r1)
        L_0x0384:
            r2.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r3 = r47
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.OffsetKt.offset(r3, r1)
            r11 = 0
            r23 = r11
            r11 = 0
            r3 = 1157296644(0x44faf204, float:2007.563)
            r2.startReplaceableGroup(r3)
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r14)
            r3 = r46
            boolean r14 = r2.changed((java.lang.Object) r3)
            r16 = r2
            r24 = 0
            r46 = r4
            java.lang.Object r4 = r16.rememberedValue()
            r25 = 0
            if (r14 != 0) goto L_0x03c2
            androidx.compose.runtime.Composer$Companion r26 = androidx.compose.runtime.Composer.Companion
            r49 = r5
            java.lang.Object r5 = r26.getEmpty()
            if (r4 != r5) goto L_0x03bd
            goto L_0x03c4
        L_0x03bd:
            r26 = r4
            r5 = r16
            goto L_0x03d5
        L_0x03c2:
            r49 = r5
        L_0x03c4:
            r5 = 0
            r26 = r4
            androidx.compose.material.DrawerKt$BottomDrawer$1$1$3$1 r4 = new androidx.compose.material.DrawerKt$BottomDrawer$1$1$3$1
            r4.<init>(r3)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r5 = r16
            r5.updateRememberedValue(r4)
        L_0x03d5:
            r2.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r1, r4)
            androidx.compose.material.DrawerKt$BottomDrawer$1$1$4 r4 = new androidx.compose.material.DrawerKt$BottomDrawer$1$1$4
            r4.<init>(r0, r15, r6)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r5 = 0
            r6 = 1
            r11 = 0
            androidx.compose.ui.Modifier r23 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r1, r11, r4, r6, r5)
            r1 = 0
            androidx.compose.material.DrawerKt$BottomDrawer$1$1$5 r4 = new androidx.compose.material.DrawerKt$BottomDrawer$1$1$5
            r5 = r41
            r4.<init>(r5, r8)
            r5 = 457750254(0x1b48b6ee, float:1.660272E-22)
            androidx.compose.runtime.internal.ComposableLambda r4 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r5, r6, r4)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            int r5 = r8 >> 9
            r5 = r5 & 112(0x70, float:1.57E-43)
            r6 = 1572864(0x180000, float:2.204052E-39)
            r5 = r5 | r6
            int r6 = r8 >> 12
            r11 = r6 & 896(0x380, float:1.256E-42)
            r5 = r5 | r11
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | r6
            r6 = 458752(0x70000, float:6.42848E-40)
            r6 = r6 & r8
            r5 = r5 | r6
            r6 = 16
            r24 = r34
            r25 = r29
            r27 = r32
            r29 = r1
            r30 = r31
            r31 = r4
            r32 = r2
            r33 = r5
            r34 = r6
            androidx.compose.material.SurfaceKt.m1620SurfaceFjzlyU(r23, r24, r25, r27, r29, r30, r31, r32, r33, r34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r7)
            r60.endReplaceableGroup()
            r60.endNode()
            r60.endReplaceableGroup()
            r60.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x044c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x044c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt$BottomDrawer$1.invoke(androidx.compose.foundation.layout.BoxWithConstraintsScope, androidx.compose.runtime.Composer, int):void");
    }

    private static final float invoke$lambda$1(MutableState<Float> $drawerHeight$delegate) {
        return ((Number) $drawerHeight$delegate.getValue()).floatValue();
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$2(MutableState<Float> $drawerHeight$delegate, float value) {
        $drawerHeight$delegate.setValue(Float.valueOf(value));
    }
}
