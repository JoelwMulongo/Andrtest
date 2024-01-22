package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.tokens.ListTokens;
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
/* compiled from: ListItem.kt */
final class ListItemKt$ListItem$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ ListItemColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $headlineText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingContent;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListItemKt$ListItem$1(Function2<? super Composer, ? super Integer, Unit> function2, ListItemColors listItemColors, int i, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23) {
        super(3);
        this.$leadingContent = function2;
        this.$colors = listItemColors;
        this.$$dirty = i;
        this.$trailingContent = function22;
        this.$headlineText = function23;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((RowScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope $this$ListItem, Composer $composer, int $changed) {
        Composer $composer$iv;
        RowScope rowScope = $this$ListItem;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(rowScope, "$this$ListItem");
        ComposerKt.sourceInformation(composer, "C100@4463L358,114@4995L33,112@4881L209,112@4881L211:ListItem.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= composer.changed((Object) rowScope) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(967218806, $dirty2, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:92)");
            }
            composer.startReplaceableGroup(1316672324);
            ComposerKt.sourceInformation(composer, "96@4340L32,94@4229L205,94@4229L207");
            Function2<Composer, Integer, Unit> function2 = this.$leadingContent;
            if (function2 != null) {
                ListItemKt.m1978leadingContentiJQMabo(function2, this.$colors.leadingIconColor$material3_release(true, composer, ((this.$$dirty >> 15) & 112) | 6).getValue().m3174unboximpl(), false, $composer, ((this.$$dirty >> 12) & 14) | 384).invoke(rowScope, composer, Integer.valueOf($dirty2 & 14));
            }
            $composer.endReplaceableGroup();
            Modifier modifier$iv = rowScope.align(RowScope.weight$default($this$ListItem, Modifier.Companion, 1.0f, false, 2, (Object) null), Alignment.Companion.getCenterVertically());
            ListItemColors listItemColors = this.$colors;
            int i = this.$$dirty;
            Function2<Composer, Integer, Unit> function22 = this.$headlineText;
            composer.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
            Alignment alignment = contentAlignment$iv;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
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
            Composer $composer$iv2 = $composer;
            int i2 = $changed$iv$iv$iv;
            $composer$iv2.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation($composer$iv2, "C72@3384L9:Box.kt#2w3rfo");
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            if ((($changed$iv$iv$iv >> 9) & 14 & 11) != 2 || !$composer$iv2.getSkipping()) {
                int $changed2 = ((0 >> 6) & 112) | 6;
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                Composer $composer2 = $composer$iv2;
                $composer2.startReplaceableGroup(181297456);
                ComposerKt.sourceInformation($composer2, "C106@4666L29,105@4612L195:ListItem.kt#uh7d8r");
                int i3 = $changed2;
                if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                    long r1 = listItemColors.headlineColor$material3_release(true, $composer2, ((i >> 15) & 112) | 6).getValue().m3174unboximpl();
                    int i4 = ((i << 6) & 896) | 48;
                    MeasurePolicy measurePolicy = measurePolicy$iv;
                    Density density = density$iv$iv;
                    $composer$iv = $composer$iv2;
                    ListItemKt.m1973ProvideTextStyleFromToken3JVO9M(r1, ListTokens.INSTANCE.getListItemLabelTextFont(), function22, $composer2, i4);
                } else {
                    $composer2.skipToGroupEnd();
                    MeasurePolicy measurePolicy2 = measurePolicy$iv;
                    Density density2 = density$iv$iv;
                    $composer$iv = $composer$iv2;
                }
                $composer2.endReplaceableGroup();
            } else {
                $composer$iv2.skipToGroupEnd();
                MeasurePolicy measurePolicy3 = measurePolicy$iv;
                Density density3 = density$iv$iv;
                $composer$iv = $composer$iv2;
            }
            $composer$iv.endReplaceableGroup();
            $composer.endReplaceableGroup();
            $composer.endNode();
            $composer.endReplaceableGroup();
            $composer.endReplaceableGroup();
            Function2<Composer, Integer, Unit> function23 = this.$trailingContent;
            if (function23 != null) {
                ListItemKt.m1979trailingContentiJQMabo(function23, this.$colors.trailingIconColor$material3_release(true, composer, ((this.$$dirty >> 15) & 112) | 6).getValue().m3174unboximpl(), false, $composer, ((this.$$dirty >> 15) & 14) | 384).invoke(rowScope, composer, Integer.valueOf($dirty2 & 14));
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
