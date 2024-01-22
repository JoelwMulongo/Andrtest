package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Drawer.kt */
final class DrawerKt$ModalDrawer$1 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $drawerBackgroundColor;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $drawerContent;
    final /* synthetic */ long $drawerContentColor;
    final /* synthetic */ float $drawerElevation;
    final /* synthetic */ Shape $drawerShape;
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ long $scrimColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerKt$ModalDrawer$1(DrawerState drawerState, boolean z, int i, long j, Shape shape, long j2, long j3, float f, Function2<? super Composer, ? super Integer, Unit> function2, CoroutineScope coroutineScope, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3) {
        super(3);
        this.$drawerState = drawerState;
        this.$gesturesEnabled = z;
        this.$$dirty = i;
        this.$scrimColor = j;
        this.$drawerShape = shape;
        this.$drawerBackgroundColor = j2;
        this.$drawerContentColor = j3;
        this.$drawerElevation = f;
        this.$content = function2;
        this.$scope = coroutineScope;
        this.$drawerContent = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((BoxWithConstraintsScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Function2 value$iv$iv;
        Object value$iv$iv2;
        boolean z;
        Object value$iv$iv3;
        BoxWithConstraintsScope boxWithConstraintsScope = $this$BoxWithConstraints;
        Composer composer = $composer;
        int i = $changed;
        Intrinsics.checkNotNullParameter(boxWithConstraintsScope, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer, "C408@14227L7,420@14724L196,409@14266L3026:Drawer.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= composer.changed((Object) boxWithConstraintsScope) ? 4 : 2;
        }
        if (($dirty & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(816674999, i, -1, "androidx.compose.material.ModalDrawer.<anonymous> (Drawer.kt:398)");
            }
            long modalDrawerConstraints = $this$BoxWithConstraints.m714getConstraintsmsEJaDk();
            if (Constraints.m5926getHasBoundedWidthimpl(modalDrawerConstraints)) {
                float minValue = -((float) Constraints.m5930getMaxWidthimpl(modalDrawerConstraints));
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier swipeableV2$default = SwipeableV2Kt.swipeableV2$default(Modifier.Companion, this.$drawerState.getSwipeableState$material_release(), Orientation.Horizontal, this.$gesturesEnabled, consume == LayoutDirection.Rtl, (MutableInteractionSource) null, 16, (Object) null);
                SwipeableV2State<DrawerValue> swipeableState$material_release = this.$drawerState.getSwipeableState$material_release();
                Set of = SetsKt.setOf(DrawerValue.Closed, DrawerValue.Open);
                Object key1$iv = Float.valueOf(minValue);
                Object key2$iv = Float.valueOf(0.0f);
                composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv = composer.changed(key1$iv) | composer.changed(key2$iv);
                Composer $this$cache$iv$iv = $composer;
                Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                    value$iv$iv = new DrawerKt$ModalDrawer$1$1$1(minValue, 0.0f);
                    $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                    Composer composer2 = $this$cache$iv$iv;
                }
                $composer.endReplaceableGroup();
                Modifier modifier$iv = SwipeableV2Kt.swipeAnchors$default(swipeableV2$default, swipeableState$material_release, of, (AnchorChangeHandler) null, value$iv$iv, 4, (Object) null);
                DrawerState drawerState = this.$drawerState;
                int i2 = this.$$dirty;
                long j = this.$scrimColor;
                Shape shape = this.$drawerShape;
                int i3 = $dirty;
                long j2 = this.$drawerBackgroundColor;
                long j3 = this.$drawerContentColor;
                float f = this.$drawerElevation;
                Function2<Composer, Integer, Unit> function2 = this.$content;
                long j4 = j3;
                boolean z2 = this.$gesturesEnabled;
                CoroutineScope coroutineScope = this.$scope;
                Shape shape2 = shape;
                Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$drawerContent;
                composer.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                long modalDrawerConstraints2 = modalDrawerConstraints;
                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                composer.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                Alignment alignment = contentAlignment$iv;
                String str = "CC:CompositionLocal.kt#9igjgp";
                long j5 = j;
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume2 = composer.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer);
                Density density$iv$iv = (Density) consume2;
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume3 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer);
                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer);
                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
                Modifier modifier = modifier$iv;
                float minValue2 = minValue;
                int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = materializerOf;
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    $composer.useNode();
                }
                $composer.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer);
                Function0<ComposeUiNode> function0 = constructor;
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer.enableReusing();
                MeasurePolicy measurePolicy = measurePolicy$iv;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = function33;
                function34.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                composer.startReplaceableGroup(2058660585);
                int i4 = $changed$iv$iv$iv;
                Composer $composer$iv = $composer;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                int i5 = ((0 >> 6) & 112) | 6;
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
                ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                Composer $composer2 = $composer$iv;
                ComposerKt.sourceInformationMarkerStart($composer2, 413824459, "C427@14945L45,440@15392L106,430@15003L545,445@15582L33,*447@15682L7,456@16146L222,446@15628L1654:Drawer.kt#jmzs0o");
                $composer2.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Modifier modifier$iv2 = Modifier.Companion;
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                Density density = density$iv$iv;
                LayoutDirection layoutDirection = layoutDirection$iv$iv;
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                Alignment alignment2 = contentAlignment$iv2;
                $composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density density$iv$iv2 = (Density) consume5;
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume6;
                int i6 = ($changed$iv$iv$iv >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume7 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume7;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
                Modifier modifier2 = modifier$iv2;
                int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                Composer $composer$iv2 = $composer$iv;
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    $composer2.createNode(constructor2);
                } else {
                    $composer2.useNode();
                }
                $composer2.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2787constructorimpl($composer2);
                Function0<ComposeUiNode> function02 = constructor2;
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer2.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer2.startReplaceableGroup(2058660585);
                int i7 = ($changed$iv$iv$iv2 >> 9) & 14;
                Composer $composer$iv3 = $composer2;
                int i8 = $changed$iv$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i9 = ((0 >> 6) & 112) | 6;
                Composer $composer3 = $composer$iv3;
                ComposerKt.sourceInformationMarkerStart($composer3, 392276226, "C428@14967L9:Drawer.kt#jmzs0o");
                function2.invoke($composer3, Integer.valueOf((i2 >> 27) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer2.endReplaceableGroup();
                $composer2.endNode();
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
                boolean isOpen = drawerState.isOpen();
                Function0 drawerKt$ModalDrawer$1$2$2 = new DrawerKt$ModalDrawer$1$2$2(z2, drawerState, coroutineScope);
                Float valueOf = Float.valueOf(minValue2);
                Object key2$iv2 = Float.valueOf(0.0f);
                int i10 = (i2 & 896) | 48;
                $composer2.startReplaceableGroup(1618982084);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer2.changed((Object) valueOf) | $composer2.changed(key2$iv2) | $composer2.changed((Object) drawerState);
                Composer $this$cache$iv$iv2 = $composer2;
                Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
                if (invalid$iv$iv2 || it$iv$iv2 == Composer.Companion.getEmpty()) {
                    Float f2 = valueOf;
                    z = false;
                    value$iv$iv2 = (Function0) new DrawerKt$ModalDrawer$1$2$3$1(minValue2, 0.0f, drawerState);
                    $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
                } else {
                    Float f3 = valueOf;
                    value$iv$iv2 = it$iv$iv2;
                    z = false;
                    float f4 = minValue2;
                }
                $composer2.endReplaceableGroup();
                DrawerKt.m1489ScrimBx497Mc(isOpen, drawerKt$ModalDrawer$1$2$2, (Function0) value$iv$iv2, j5, $composer2, (i2 >> 15) & 7168);
                String navigationMenu = Strings_androidKt.m1618getString4foXLRw(Strings.Companion.m1615getNavigationMenuUdPEhr4(), $composer2, 6);
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str);
                Object consume8 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density $this$invoke_u24lambda_u245_u24lambda_u243 = (Density) consume8;
                Modifier r2 = SizeKt.m833sizeInqDBjuR0(Modifier.Companion, $this$invoke_u24lambda_u245_u24lambda_u243.m5964toDpu2uoSUM(Constraints.m5932getMinWidthimpl(modalDrawerConstraints2)), $this$invoke_u24lambda_u245_u24lambda_u243.m5964toDpu2uoSUM(Constraints.m5931getMinHeightimpl(modalDrawerConstraints2)), $this$invoke_u24lambda_u245_u24lambda_u243.m5964toDpu2uoSUM(Constraints.m5930getMaxWidthimpl(modalDrawerConstraints2)), $this$invoke_u24lambda_u245_u24lambda_u243.m5964toDpu2uoSUM(Constraints.m5929getMaxHeightimpl(modalDrawerConstraints2)));
                int i11 = (i2 >> 6) & 14;
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv3 = $composer2.changed((Object) drawerState);
                Composer $this$cache$iv$iv3 = $composer2;
                Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
                if (invalid$iv$iv3 || it$iv$iv3 == Composer.Companion.getEmpty()) {
                    boolean z3 = z;
                    value$iv$iv3 = (Function1) new DrawerKt$ModalDrawer$1$2$5$1(drawerState);
                    $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
                } else {
                    boolean z4 = z;
                    value$iv$iv3 = it$iv$iv3;
                }
                $composer2.endReplaceableGroup();
                int i12 = i2 >> 12;
                SurfaceKt.m1620SurfaceFjzlyU(SemanticsModifierKt.semantics$default(PaddingKt.m764paddingqDBjuR0$default(OffsetKt.offset(r2, (Function1) value$iv$iv3), 0.0f, 0.0f, DrawerKt.EndDrawerPadding, 0.0f, 11, (Object) null), false, new DrawerKt$ModalDrawer$1$2$6(navigationMenu, drawerState, coroutineScope), 1, (Object) null), shape2, j2, j4, (BorderStroke) null, f, ComposableLambdaKt.composableLambda($composer2, -1941234439, true, new DrawerKt$ModalDrawer$1$2$7(function32, i2)), $composer2, ((i2 >> 9) & 112) | 1572864 | (i12 & 896) | (i12 & 7168) | (458752 & i2), 16);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer.endReplaceableGroup();
                $composer.endNode();
                $composer.endReplaceableGroup();
                $composer.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Drawer shouldn't have infinite width");
        }
        $composer.skipToGroupEnd();
        int i13 = $dirty;
    }
}
