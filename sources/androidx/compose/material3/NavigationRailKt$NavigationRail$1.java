package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.tokens.NavigationRailTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NavigationRail.kt */
final class NavigationRailKt$NavigationRail$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $header;
    final /* synthetic */ WindowInsets $windowInsets;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationRailKt$NavigationRail$1(WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32) {
        super(2);
        this.$windowInsets = windowInsets;
        this.$header = function3;
        this.$$dirty = i;
        this.$content = function32;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C113@5156L619:NavigationRail.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2092683357, i, -1, "androidx.compose.material3.NavigationRail.<anonymous> (NavigationRail.kt:112)");
            }
            Modifier selectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m762paddingVpY3zN4$default(SizeKt.m837widthInVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), this.$windowInsets), NavigationRailTokens.INSTANCE.m2532getContainerWidthD9Ej5fM(), 0.0f, 2, (Object) null), 0.0f, NavigationRailKt.getNavigationRailVerticalPadding(), 1, (Object) null));
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Arrangement.HorizontalOrVertical r6 = Arrangement.INSTANCE.m677spacedBy0680j_4(NavigationRailKt.getNavigationRailVerticalPadding());
            Function3<ColumnScope, Composer, Integer, Unit> function3 = this.$header;
            int i2 = this.$$dirty;
            Function3<ColumnScope, Composer, Integer, Unit> function32 = this.$content;
            composer.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(r6, centerHorizontally, composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(selectableGroup);
            int $changed$iv$iv$iv = ((((432 << 3) & 112) << 9) & 7168) | 6;
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
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            $composer$iv.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation($composer$iv, "C79@3994L9:Column.kt#2w3rfo");
            if (($changed$iv & 11) != 2 || !$composer$iv.getSkipping()) {
                int $changed2 = ((432 >> 6) & 112) | 6;
                ColumnScope $this$invoke_u24lambda_u2d0 = ColumnScopeInstance.INSTANCE;
                int i3 = $changed$iv;
                Composer $composer2 = $composer$iv;
                $composer2.startReplaceableGroup(-1267890579);
                ComposerKt.sourceInformation($composer2, "C127@5756L9:NavigationRail.kt#uh7d8r");
                int $dirty = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty |= $composer2.changed((Object) $this$invoke_u24lambda_u2d0) ? 4 : 2;
                }
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = materializerOf;
                MeasurePolicy measurePolicy = measurePolicy$iv;
                if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
                    $composer2.startReplaceableGroup(716053607);
                    ComposerKt.sourceInformation($composer2, "124@5652L8,125@5677L52");
                    if (function3 != null) {
                        function3.invoke($this$invoke_u24lambda_u2d0, $composer2, Integer.valueOf(($dirty & 14) | ((i2 >> 6) & 112)));
                        SpacerKt.Spacer(SizeKt.m816height3ABfNKs(Modifier.Companion, NavigationRailKt.NavigationRailHeaderPadding), $composer2, 6);
                    }
                    $composer2.endReplaceableGroup();
                    function32.invoke($this$invoke_u24lambda_u2d0, $composer2, Integer.valueOf(($dirty & 14) | ((i2 >> 12) & 112)));
                } else {
                    $composer2.skipToGroupEnd();
                }
                $composer2.endReplaceableGroup();
            } else {
                $composer$iv.skipToGroupEnd();
                int i4 = $changed$iv;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = materializerOf;
                MeasurePolicy measurePolicy2 = measurePolicy$iv;
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
