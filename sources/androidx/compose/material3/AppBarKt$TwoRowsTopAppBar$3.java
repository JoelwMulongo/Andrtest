package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$TwoRowsTopAppBar$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $actionsRow;
    final /* synthetic */ State<Color> $appBarContainerColor$delegate;
    final /* synthetic */ float $bottomTitleAlpha;
    final /* synthetic */ TopAppBarColors $colors;
    final /* synthetic */ boolean $hideBottomRowSemantics;
    final /* synthetic */ boolean $hideTopRowSemantics;
    final /* synthetic */ Ref.FloatRef $maxHeightPx;
    final /* synthetic */ Function2<Composer, Integer, Unit> $navigationIcon;
    final /* synthetic */ Ref.FloatRef $pinnedHeightPx;
    final /* synthetic */ TopAppBarScrollBehavior $scrollBehavior;
    final /* synthetic */ Function2<Composer, Integer, Unit> $smallTitle;
    final /* synthetic */ TextStyle $smallTitleTextStyle;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ Ref.IntRef $titleBottomPaddingPx;
    final /* synthetic */ TextStyle $titleTextStyle;
    final /* synthetic */ float $topTitleAlpha;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$TwoRowsTopAppBar$3(WindowInsets windowInsets, Ref.FloatRef floatRef, TopAppBarColors topAppBarColors, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, float f, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i, Ref.FloatRef floatRef2, TopAppBarScrollBehavior topAppBarScrollBehavior, Function2<? super Composer, ? super Integer, Unit> function24, TextStyle textStyle2, float f2, Ref.IntRef intRef, boolean z2, State<Color> state) {
        super(2);
        this.$windowInsets = windowInsets;
        this.$pinnedHeightPx = floatRef;
        this.$colors = topAppBarColors;
        this.$smallTitle = function2;
        this.$smallTitleTextStyle = textStyle;
        this.$topTitleAlpha = f;
        this.$hideTopRowSemantics = z;
        this.$navigationIcon = function22;
        this.$actionsRow = function23;
        this.$$dirty = i;
        this.$maxHeightPx = floatRef2;
        this.$scrollBehavior = topAppBarScrollBehavior;
        this.$title = function24;
        this.$titleTextStyle = textStyle2;
        this.$bottomTitleAlpha = f2;
        this.$titleBottomPaddingPx = intRef;
        this.$hideBottomRowSemantics = z2;
        this.$appBarContainerColor$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer $composer$iv;
        Composer $composer2;
        float f;
        TopAppBarState state;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C1165@52455L1979:AppBar.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1985938853, i, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:1164)");
            }
            WindowInsets windowInsets = this.$windowInsets;
            Ref.FloatRef floatRef = this.$pinnedHeightPx;
            TopAppBarColors topAppBarColors = this.$colors;
            Function2<Composer, Integer, Unit> function2 = this.$smallTitle;
            TextStyle textStyle = this.$smallTitleTextStyle;
            float f2 = this.$topTitleAlpha;
            boolean z = this.$hideTopRowSemantics;
            Function2<Composer, Integer, Unit> function22 = this.$navigationIcon;
            Function2<Composer, Integer, Unit> function23 = this.$actionsRow;
            int i2 = this.$$dirty;
            Ref.FloatRef floatRef2 = this.$maxHeightPx;
            TopAppBarScrollBehavior topAppBarScrollBehavior = this.$scrollBehavior;
            Function2<Composer, Integer, Unit> function24 = this.$title;
            TextStyle textStyle2 = this.$titleTextStyle;
            float f3 = this.$bottomTitleAlpha;
            Ref.IntRef intRef = this.$titleBottomPaddingPx;
            Function2<Composer, Integer, Unit> function25 = function24;
            boolean z2 = this.$hideBottomRowSemantics;
            TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            State<Color> state2 = this.$appBarContainerColor$delegate;
            composer.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            boolean z3 = z2;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Ref.IntRef intRef2 = intRef;
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            Ref.FloatRef floatRef3 = floatRef2;
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            Alignment.Horizontal horizontal = horizontalAlignment$iv;
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Arrangement.Vertical vertical = verticalArrangement$iv;
            Function2<Composer, Integer, Unit> function26 = function23;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv$iv = (Density) consume;
            int i3 = i2;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            boolean z4 = z;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
            Function2<Composer, Integer, Unit> function27 = function22;
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
            materializerOf.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            Composer $composer$iv2 = $composer;
            $composer$iv2.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation($composer$iv2, "C79@3994L9:Column.kt#2w3rfo");
            int i4 = $changed$iv$iv$iv;
            if ((($changed$iv$iv$iv >> 9) & 14 & 11) != 2 || !$composer$iv2.getSkipping()) {
                int $changed2 = ((0 >> 6) & 112) | 6;
                Composer $composer3 = $composer$iv2;
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                $composer3.startReplaceableGroup(80455579);
                ComposerKt.sourceInformation($composer3, "C1166@52476L1044,1188@53533L891:AppBar.kt#uh7d8r");
                if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                    TopAppBarScrollBehavior topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                    MeasurePolicy measurePolicy = measurePolicy$iv;
                    $composer2 = $composer3;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
                    Function2<Composer, Integer, Unit> function28 = function26;
                    int i5 = i3;
                    Function0<ComposeUiNode> function02 = function0;
                    ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                    $composer$iv = $composer$iv2;
                    boolean z5 = z4;
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    int i6 = i5 << 3;
                    Density density = density$iv$iv;
                    TextStyle textStyle3 = textStyle;
                    float f4 = f2;
                    AppBarKt.m1745TopAppBarLayoutkXwM9vE(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(BackgroundKt.m449backgroundbw27NRU$default(Modifier.Companion, AppBarKt.m1747TwoRowsTopAppBar_tjU4iQQ$lambda8(state2), (Shape) null, 2, (Object) null), windowInsets)), floatRef.element, topAppBarColors.m2246getNavigationIconContentColor0d7_KjU$material3_release(), topAppBarColors.m2247getTitleContentColor0d7_KjU$material3_release(), topAppBarColors.m2245getActionIconContentColor0d7_KjU$material3_release(), function2, textStyle3, f4, Arrangement.INSTANCE.getCenter(), start, 0, z5, function27, function28, $composer2, (i6 & 458752) | 905969664 | (i6 & 3670016), ((i5 >> 12) & 896) | 3078);
                    Modifier clipToBounds = ClipKt.clipToBounds(Modifier.Companion);
                    float f5 = floatRef3.element - floatRef.element;
                    if (topAppBarScrollBehavior3 == null || (state = topAppBarScrollBehavior3.getState()) == null) {
                        f = 0.0f;
                    } else {
                        f = state.getHeightOffset();
                    }
                    int i7 = i5 << 12;
                    Function2<Composer, Integer, Unit> function29 = function25;
                    TextStyle textStyle4 = textStyle2;
                    float f6 = f3;
                    boolean z6 = z3;
                    AppBarKt.m1745TopAppBarLayoutkXwM9vE(clipToBounds, f5 + f, topAppBarColors.m2246getNavigationIconContentColor0d7_KjU$material3_release(), topAppBarColors.m2247getTitleContentColor0d7_KjU$material3_release(), topAppBarColors.m2245getActionIconContentColor0d7_KjU$material3_release(), function29, textStyle4, f6, Arrangement.INSTANCE.getBottom(), Arrangement.INSTANCE.getStart(), intRef2.element, z6, ComposableSingletons$AppBarKt.INSTANCE.m1862getLambda11$material3_release(), ComposableSingletons$AppBarKt.INSTANCE.m1863getLambda12$material3_release(), $composer2, (i7 & 458752) | 905969670 | (i7 & 3670016), 3456);
                } else {
                    $composer3.skipToGroupEnd();
                    Density density2 = density$iv$iv;
                    MeasurePolicy measurePolicy2 = measurePolicy$iv;
                    $composer2 = $composer3;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = materializerOf;
                    ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv;
                    $composer$iv = $composer$iv2;
                    Function0<ComposeUiNode> function03 = function0;
                }
                $composer2.endReplaceableGroup();
            } else {
                $composer$iv2.skipToGroupEnd();
                Density density3 = density$iv$iv;
                MeasurePolicy measurePolicy3 = measurePolicy$iv;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = materializerOf;
                ViewConfiguration viewConfiguration3 = viewConfiguration$iv$iv;
                $composer$iv = $composer$iv2;
                Function0<ComposeUiNode> function04 = function0;
            }
            $composer$iv.endReplaceableGroup();
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
        $composer.skipToGroupEnd();
    }
}
