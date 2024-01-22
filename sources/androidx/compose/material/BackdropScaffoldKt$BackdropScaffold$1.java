package androidx.compose.material;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackdropScaffold.kt */
final class BackdropScaffoldKt$BackdropScaffold$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ Function2<Composer, Integer, Unit> $backLayer;
    final /* synthetic */ Function1<Constraints, Constraints> $calculateBackLayerConstraints;
    final /* synthetic */ long $frontLayerBackgroundColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $frontLayerContent;
    final /* synthetic */ long $frontLayerContentColor;
    final /* synthetic */ float $frontLayerElevation;
    final /* synthetic */ long $frontLayerScrimColor;
    final /* synthetic */ Shape $frontLayerShape;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ float $headerHeight;
    final /* synthetic */ float $headerHeightPx;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $peekHeight;
    final /* synthetic */ float $peekHeightPx;
    final /* synthetic */ BackdropScaffoldState $scaffoldState;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ boolean $stickyFrontLayer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackdropScaffoldKt$BackdropScaffold$1(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function1<? super Constraints, Constraints> function1, float f, boolean z, boolean z2, BackdropScaffoldState backdropScaffoldState, float f2, int i, Shape shape, long j, long j2, float f3, int i2, float f4, float f5, Function2<? super Composer, ? super Integer, Unit> function22, long j3, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$modifier = modifier;
        this.$backLayer = function2;
        this.$calculateBackLayerConstraints = function1;
        this.$headerHeightPx = f;
        this.$stickyFrontLayer = z;
        this.$gesturesEnabled = z2;
        this.$scaffoldState = backdropScaffoldState;
        this.$peekHeightPx = f2;
        this.$$dirty = i;
        this.$frontLayerShape = shape;
        this.$frontLayerBackgroundColor = j;
        this.$frontLayerContentColor = j2;
        this.$frontLayerElevation = f3;
        this.$$dirty1 = i2;
        this.$headerHeight = f4;
        this.$peekHeight = f5;
        this.$frontLayerContent = function22;
        this.$frontLayerScrimColor = j3;
        this.$snackbarHost = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv$iv$iv;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C297@13395L24,298@13428L3119:BackdropScaffold.kt#jmzs0o");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1049909631, i, -1, "androidx.compose.material.BackdropScaffold.<anonymous> (BackdropScaffold.kt:296)");
            }
            composer.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
            Composer composer$iv = $composer;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv$iv = $composer;
            Object it$iv$iv$iv = $this$cache$iv$iv$iv.rememberedValue();
            if (it$iv$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer$iv));
                $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
            } else {
                value$iv$iv$iv = it$iv$iv$iv;
            }
            $composer.endReplaceableGroup();
            final CoroutineScope scope = ((CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv).getCoroutineScope();
            $composer.endReplaceableGroup();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(this.$modifier, 0.0f, 1, (Object) null);
            Function2<Composer, Integer, Unit> function2 = this.$backLayer;
            Function1<Constraints, Constraints> function1 = this.$calculateBackLayerConstraints;
            final float f = this.$headerHeightPx;
            final boolean z = this.$stickyFrontLayer;
            final boolean z2 = this.$gesturesEnabled;
            final BackdropScaffoldState backdropScaffoldState = this.$scaffoldState;
            final float f2 = this.$peekHeightPx;
            final int i2 = this.$$dirty;
            final Shape shape = this.$frontLayerShape;
            AnonymousClass1 r30 = r9;
            final long j = this.$frontLayerBackgroundColor;
            final long j2 = this.$frontLayerContentColor;
            final float f3 = this.$frontLayerElevation;
            final int i3 = this.$$dirty1;
            final float f4 = this.$headerHeight;
            final float f5 = this.$peekHeight;
            final Function2<Composer, Integer, Unit> function22 = this.$frontLayerContent;
            final long j3 = this.$frontLayerScrimColor;
            final Function3<SnackbarHostState, Composer, Integer, Unit> function3 = this.$snackbarHost;
            AnonymousClass1 r9 = new Function4<Constraints, Float, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                    m1379invokejYbf7pk(((Constraints) p1).m5936unboximpl(), ((Number) p2).floatValue(), (Composer) p3, ((Number) p4).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARNING: Removed duplicated region for block: B:47:0x0287  */
                /* JADX WARNING: Removed duplicated region for block: B:50:0x0293  */
                /* JADX WARNING: Removed duplicated region for block: B:51:0x0297  */
                /* JADX WARNING: Removed duplicated region for block: B:54:0x0344  */
                /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
                /* renamed from: invoke-jYbf7pk  reason: not valid java name */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void m1379invokejYbf7pk(long r38, float r40, androidx.compose.runtime.Composer r41, int r42) {
                    /*
                        r37 = this;
                        r0 = r37
                        r1 = r40
                        r14 = r41
                        r15 = r42
                        java.lang.String r2 = "CP(1:c#ui.unit.Constraints)344@15194L57,342@15132L942,366@16117L420:BackdropScaffold.kt#jmzs0o"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r14, r2)
                        r2 = r42
                        r3 = r15 & 14
                        r4 = 2
                        r12 = r38
                        if (r3 != 0) goto L_0x0020
                        boolean r3 = r14.changed((long) r12)
                        if (r3 == 0) goto L_0x001e
                        r3 = 4
                        goto L_0x001f
                    L_0x001e:
                        r3 = r4
                    L_0x001f:
                        r2 = r2 | r3
                    L_0x0020:
                        r3 = r15 & 112(0x70, float:1.57E-43)
                        if (r3 != 0) goto L_0x0030
                        boolean r3 = r14.changed((float) r1)
                        if (r3 == 0) goto L_0x002d
                        r3 = 32
                        goto L_0x002f
                    L_0x002d:
                        r3 = 16
                    L_0x002f:
                        r2 = r2 | r3
                    L_0x0030:
                        r11 = r2
                        r2 = r11 & 731(0x2db, float:1.024E-42)
                        r3 = 146(0x92, float:2.05E-43)
                        if (r2 != r3) goto L_0x0045
                        boolean r2 = r41.getSkipping()
                        if (r2 != 0) goto L_0x003e
                        goto L_0x0045
                    L_0x003e:
                        r41.skipToGroupEnd()
                        r20 = r11
                        goto L_0x0347
                    L_0x0045:
                        boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                        if (r2 == 0) goto L_0x0054
                        r2 = -1
                        java.lang.String r3 = "androidx.compose.material.BackdropScaffold.<anonymous>.<anonymous> (BackdropScaffold.kt:302)"
                        r5 = 1800047509(0x6b4a8b95, float:2.4486217E26)
                        androidx.compose.runtime.ComposerKt.traceEventStart(r5, r15, r2, r3)
                    L_0x0054:
                        int r2 = androidx.compose.ui.unit.Constraints.m5929getMaxHeightimpl(r38)
                        float r10 = (float) r2
                        float r2 = r10
                        float r2 = r10 - r2
                        boolean r3 = r11
                        if (r3 == 0) goto L_0x0068
                        float r2 = java.lang.Math.min(r2, r1)
                        r16 = r2
                        goto L_0x006a
                    L_0x0068:
                        r16 = r2
                    L_0x006a:
                        boolean r2 = r12
                        r3 = 0
                        if (r2 == 0) goto L_0x007e
                        androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
                        androidx.compose.material.BackdropScaffoldState r5 = r13
                        androidx.compose.ui.input.nestedscroll.NestedScrollConnection r5 = r5.getNestedScrollConnection$material_release()
                        androidx.compose.ui.Modifier r2 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll$default(r2, r5, r3, r4, r3)
                        goto L_0x0082
                    L_0x007e:
                        androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
                    L_0x0082:
                        r9 = r2
                        androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r17 = r2.then(r9)
                        androidx.compose.material.BackdropScaffoldState r2 = r13
                        r18 = r2
                        androidx.compose.material.SwipeableState r18 = (androidx.compose.material.SwipeableState) r18
                        kotlin.Pair[] r2 = new kotlin.Pair[r4]
                        float r4 = r14
                        java.lang.Float r4 = java.lang.Float.valueOf(r4)
                        androidx.compose.material.BackdropValue r5 = androidx.compose.material.BackdropValue.Concealed
                        kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r5)
                        r8 = 0
                        r2[r8] = r4
                        java.lang.Float r4 = java.lang.Float.valueOf(r16)
                        androidx.compose.material.BackdropValue r5 = androidx.compose.material.BackdropValue.Revealed
                        kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r5)
                        r6 = 1
                        r2[r6] = r4
                        java.util.Map r19 = kotlin.collections.MapsKt.mapOf(r2)
                        androidx.compose.foundation.gestures.Orientation r20 = androidx.compose.foundation.gestures.Orientation.Vertical
                        boolean r2 = r12
                        r22 = 0
                        r23 = 0
                        r24 = 0
                        r25 = 0
                        r26 = 0
                        r27 = 496(0x1f0, float:6.95E-43)
                        r28 = 0
                        r21 = r2
                        androidx.compose.ui.Modifier r2 = androidx.compose.material.SwipeableKt.m1633swipeablepPrIpRY$default(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
                        androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1 r4 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$swipeable$1
                        androidx.compose.material.BackdropScaffoldState r5 = r13
                        kotlinx.coroutines.CoroutineScope r7 = r24
                        r4.<init>(r5, r7)
                        kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
                        androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r8, r4, r6, r3)
                        r7 = r2
                        androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
                        androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
                        androidx.compose.material.BackdropScaffoldState r3 = r13
                        androidx.compose.material.BackdropScaffoldState r4 = r13
                        int r5 = r15
                        int r5 = r5 >> 12
                        r5 = r5 & 14
                        r17 = 0
                        r8 = 1157296644(0x44faf204, float:2007.563)
                        r14.startReplaceableGroup(r8)
                        java.lang.String r8 = "CC(remember)P(1):Composables.kt#9igjgp"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r14, r8)
                        boolean r8 = r14.changed((java.lang.Object) r3)
                        r19 = r41
                        r20 = 0
                        java.lang.Object r6 = r19.rememberedValue()
                        r22 = 0
                        if (r8 != 0) goto L_0x0112
                        androidx.compose.runtime.Composer$Companion r23 = androidx.compose.runtime.Composer.Companion
                        java.lang.Object r1 = r23.getEmpty()
                        if (r6 != r1) goto L_0x010e
                        goto L_0x0112
                    L_0x010e:
                        r1 = r6
                        r4 = r19
                        goto L_0x0123
                    L_0x0112:
                        r1 = 0
                        r23 = r1
                        androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$1$1 r1 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$1$1
                        r1.<init>(r4)
                        kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
                        r4 = r19
                        r4.updateRememberedValue(r1)
                    L_0x0123:
                        r41.endReplaceableGroup()
                        kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
                        androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.OffsetKt.offset(r2, r1)
                        androidx.compose.ui.Modifier r2 = r1.then(r7)
                        androidx.compose.ui.graphics.Shape r3 = r16
                        long r4 = r17
                        r1 = r7
                        long r6 = r19
                        float r8 = r21
                        r19 = r1
                        androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2 r1 = new androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2
                        r20 = r8
                        float r8 = r25
                        r32 = r9
                        kotlin.jvm.functions.Function2<androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r9 = r26
                        r33 = r10
                        int r10 = r15
                        r13 = r11
                        long r11 = r27
                        r34 = r13
                        androidx.compose.material.BackdropScaffoldState r13 = r13
                        int r15 = r22
                        r35 = r6
                        boolean r6 = r12
                        kotlinx.coroutines.CoroutineScope r7 = r24
                        r22 = r1
                        r23 = r8
                        r24 = r9
                        r25 = r10
                        r26 = r11
                        r28 = r13
                        r29 = r15
                        r30 = r6
                        r31 = r7
                        r22.<init>(r23, r24, r25, r26, r28, r29, r30, r31)
                        r6 = -1065299503(0xffffffffc080d1d1, float:-4.0256124)
                        r7 = 1
                        androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r6, r7, r1)
                        r10 = r1
                        kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
                        int r1 = r22
                        int r6 = r1 >> 3
                        r6 = r6 & 112(0x70, float:1.57E-43)
                        r8 = 1572864(0x180000, float:2.204052E-39)
                        r6 = r6 | r8
                        int r8 = r1 >> 6
                        r8 = r8 & 896(0x380, float:1.256E-42)
                        r6 = r6 | r8
                        int r8 = r1 >> 6
                        r8 = r8 & 7168(0x1c00, float:1.0045E-41)
                        r6 = r6 | r8
                        r8 = 458752(0x70000, float:6.42848E-40)
                        int r1 = r1 << 6
                        r1 = r1 & r8
                        r12 = r6 | r1
                        r13 = 16
                        r15 = r7
                        r1 = r19
                        r6 = r35
                        r9 = r20
                        r8 = 0
                        r17 = 0
                        r18 = r32
                        r19 = r33
                        r20 = r34
                        r11 = r41
                        androidx.compose.material.SurfaceKt.m1620SurfaceFjzlyU(r2, r3, r4, r6, r8, r9, r10, r11, r12, r13)
                        androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
                        r3 = r2
                        androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
                        r4 = 0
                        r5 = 0
                        r6 = 0
                        androidx.compose.material.BackdropScaffoldState r2 = r13
                        boolean r2 = r2.isRevealed()
                        if (r2 == 0) goto L_0x01cd
                        float r2 = r10
                        float r10 = r19 - r2
                        int r2 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
                        if (r2 != 0) goto L_0x01c5
                        r8 = r15
                        goto L_0x01c7
                    L_0x01c5:
                        r8 = r17
                    L_0x01c7:
                        if (r8 == 0) goto L_0x01cd
                        float r2 = r23
                        r7 = r2
                        goto L_0x01d5
                    L_0x01cd:
                        r2 = 0
                        r7 = 0
                        float r8 = (float) r2
                        float r8 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r8)
                        r7 = r8
                    L_0x01d5:
                        r8 = 7
                        r9 = 0
                        androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m764paddingqDBjuR0$default(r3, r4, r5, r6, r7, r8, r9)
                        androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
                        androidx.compose.ui.Alignment r3 = r3.getBottomCenter()
                        kotlin.jvm.functions.Function3<androidx.compose.material.SnackbarHostState, androidx.compose.runtime.Composer, java.lang.Integer, kotlin.Unit> r4 = r29
                        androidx.compose.material.BackdropScaffoldState r5 = r13
                        int r6 = r22
                        r7 = 48
                        r8 = 0
                        r9 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
                        r14.startReplaceableGroup(r9)
                        java.lang.String r9 = "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r14, r9)
                        r9 = 0
                        int r10 = r7 >> 3
                        r10 = r10 & 14
                        int r11 = r7 >> 3
                        r11 = r11 & 112(0x70, float:1.57E-43)
                        r10 = r10 | r11
                        androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r9, r14, r10)
                        int r11 = r7 << 3
                        r11 = r11 & 112(0x70, float:1.57E-43)
                        r12 = 0
                        r13 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
                        r14.startReplaceableGroup(r13)
                        java.lang.String r13 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
                        androidx.compose.runtime.ComposerKt.sourceInformation(r14, r13)
                        androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
                        androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
                        r15 = 6
                        r17 = 0
                        r0 = 2023513938(0x789c5f52, float:2.5372864E34)
                        r21 = r1
                        java.lang.String r1 = "C:CompositionLocal.kt#9igjgp"
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r0, r1)
                        java.lang.Object r22 = r14.consume(r13)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r41)
                        r13 = r22
                        androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
                        androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
                        androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
                        r17 = 6
                        r22 = 0
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r0, r1)
                        java.lang.Object r23 = r14.consume(r15)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r41)
                        r15 = r23
                        androidx.compose.ui.unit.LayoutDirection r15 = (androidx.compose.ui.unit.LayoutDirection) r15
                        androidx.compose.runtime.ProvidableCompositionLocal r17 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
                        r0 = r17
                        androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
                        r17 = 6
                        r23 = 0
                        r24 = r3
                        r3 = 2023513938(0x789c5f52, float:2.5372864E34)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r1)
                        java.lang.Object r1 = r14.consume(r0)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r41)
                        r0 = r1
                        androidx.compose.ui.platform.ViewConfiguration r0 = (androidx.compose.ui.platform.ViewConfiguration) r0
                        androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function0 r1 = r1.getConstructor()
                        kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r2)
                        r17 = r2
                        int r2 = r11 << 9
                        r2 = r2 & 7168(0x1c00, float:1.0045E-41)
                        r2 = r2 | 6
                        r22 = 0
                        r23 = r8
                        androidx.compose.runtime.Applier r8 = r41.getApplier()
                        boolean r8 = r8 instanceof androidx.compose.runtime.Applier
                        if (r8 != 0) goto L_0x028a
                        androidx.compose.runtime.ComposablesKt.invalidApplier()
                    L_0x028a:
                        r41.startReusableNode()
                        boolean r8 = r41.getInserting()
                        if (r8 == 0) goto L_0x0297
                        r14.createNode(r1)
                        goto L_0x029a
                    L_0x0297:
                        r41.useNode()
                    L_0x029a:
                        r41.disableReusing()
                        androidx.compose.runtime.Composer r8 = androidx.compose.runtime.Updater.m2787constructorimpl(r41)
                        r25 = 0
                        androidx.compose.ui.node.ComposeUiNode$Companion r26 = androidx.compose.ui.node.ComposeUiNode.Companion
                        r27 = r1
                        kotlin.jvm.functions.Function2 r1 = r26.getSetMeasurePolicy()
                        androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r8, r10, r1)
                        androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r1 = r1.getSetDensity()
                        androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r8, r13, r1)
                        androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r1 = r1.getSetLayoutDirection()
                        androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r8, r15, r1)
                        androidx.compose.ui.node.ComposeUiNode$Companion r1 = androidx.compose.ui.node.ComposeUiNode.Companion
                        kotlin.jvm.functions.Function2 r1 = r1.getSetViewConfiguration()
                        androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r8, r0, r1)
                        r41.enableReusing()
                        androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r41)
                        androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r1)
                        int r8 = r2 >> 3
                        r8 = r8 & 112(0x70, float:1.57E-43)
                        java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
                        r3.invoke(r1, r14, r8)
                        r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
                        r14.startReplaceableGroup(r1)
                        int r1 = r2 >> 9
                        r1 = r1 & 14
                        r8 = r41
                        r25 = 0
                        r26 = r0
                        r0 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
                        r28 = r1
                        java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r8, r0, r1)
                        androidx.compose.foundation.layout.BoxScopeInstance r0 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
                        int r1 = r7 >> 6
                        r1 = r1 & 112(0x70, float:1.57E-43)
                        r1 = r1 | 6
                        androidx.compose.foundation.layout.BoxScope r0 = (androidx.compose.foundation.layout.BoxScope) r0
                        r29 = r8
                        r30 = 0
                        r31 = r0
                        r0 = 1395535663(0x532e2f2f, float:7.4811592E11)
                        r32 = r1
                        java.lang.String r1 = "C375@16478L45:BackdropScaffold.kt#jmzs0o"
                        r33 = r2
                        r2 = r29
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r2, r0, r1)
                        androidx.compose.material.SnackbarHostState r0 = r5.getSnackbarHostState()
                        int r1 = r6 >> 18
                        r1 = r1 & 112(0x70, float:1.57E-43)
                        java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                        r4.invoke(r0, r2, r1)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r2)
                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r8)
                        r41.endReplaceableGroup()
                        r41.endNode()
                        r41.endReplaceableGroup()
                        r41.endReplaceableGroup()
                        boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                        if (r0 == 0) goto L_0x0347
                        androidx.compose.runtime.ComposerKt.traceEventEnd()
                    L_0x0347:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1.AnonymousClass1.m1379invokejYbf7pk(long, float, androidx.compose.runtime.Composer, int):void");
                }
            };
            BackdropScaffoldKt.BackdropStack(fillMaxSize$default, function2, function1, ComposableLambdaKt.composableLambda(composer, 1800047509, true, r30), $composer, 3120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
