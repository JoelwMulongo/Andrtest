package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$BottomAppBar$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $actions;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$BottomAppBar$1(Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(3);
        this.$actions = function3;
        this.$$dirty = i;
        this.$floatingActionButton = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((RowScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope $this$BottomAppBar, Composer $composer, int $changed) {
        RowScope rowScope = $this$BottomAppBar;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(rowScope, "$this$BottomAppBar");
        ComposerKt.sourceInformation(composer, "C411@20890L9,413@20948L33,414@20990L303:AppBar.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= composer.changed((Object) rowScope) ? 4 : 2;
        }
        if (($dirty & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1974005449, $dirty, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:410)");
            }
            this.$actions.invoke(rowScope, composer, Integer.valueOf(($dirty & 14) | ((this.$$dirty << 3) & 112)));
            if (this.$floatingActionButton != null) {
                SpacerKt.Spacer(rowScope.weight(Modifier.Companion, 1.0f, true), composer, 0);
                Modifier modifier$iv = PaddingKt.m764paddingqDBjuR0$default(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, AppBarKt.FABVerticalPadding, AppBarKt.FABHorizontalPadding, 0.0f, 9, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                Function2<Composer, Integer, Unit> function2 = this.$floatingActionButton;
                int i = this.$$dirty;
                composer.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
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
                int i2 = $dirty;
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer);
                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                Modifier modifier = modifier$iv;
                int $changed$iv$iv$iv = ((((54 << 3) & 112) << 9) & 7168) | 6;
                Alignment alignment = contentAlignment$iv;
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
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                composer.startReplaceableGroup(2058660585);
                Composer $composer$iv = $composer;
                ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                $composer$iv.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation($composer$iv, "C72@3384L9:Box.kt#2w3rfo");
                LayoutDirection layoutDirection = layoutDirection$iv$iv;
                if ((($changed$iv$iv$iv >> 9) & 14 & 11) != 2 || !$composer$iv.getSkipping()) {
                    int $changed2 = ((54 >> 6) & 112) | 6;
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    Composer $composer2 = $composer$iv;
                    $composer2.startReplaceableGroup(1812284970);
                    ComposerKt.sourceInformation($composer2, "C423@21261L22:AppBar.kt#uh7d8r");
                    int i3 = $changed2;
                    if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                        function2.invoke($composer2, Integer.valueOf((i >> 6) & 14));
                    } else {
                        $composer2.skipToGroupEnd();
                    }
                    $composer2.endReplaceableGroup();
                } else {
                    $composer$iv.skipToGroupEnd();
                }
                $composer$iv.endReplaceableGroup();
                $composer.endReplaceableGroup();
                $composer.endNode();
                $composer.endReplaceableGroup();
                $composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
        int i4 = $dirty;
    }
}
