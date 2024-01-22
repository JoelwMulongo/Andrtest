package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
final class ListItemKt$trailingContent$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ boolean $topAlign;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListItemKt$trailingContent$1(boolean z, long j, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(3);
        this.$topAlign = z;
        this.$contentColor = j;
        this.$trailingContent = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((RowScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope $this$null, Composer $composer, int $changed) {
        RowScope rowScope = $this$null;
        Composer composer = $composer;
        int i = $changed;
        Intrinsics.checkNotNullParameter(rowScope, "$this$null");
        ComposerKt.sourceInformation(composer, "C:ListItem.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= composer.changed((Object) rowScope) ? 4 : 2;
        }
        if (($dirty & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1301939978, i, -1, "androidx.compose.material3.trailingContent.<anonymous> (ListItem.kt:339)");
            }
            if (this.$topAlign) {
                composer.startReplaceableGroup(1857837855);
                ComposerKt.sourceInformation(composer, "341@13158L348");
                Modifier modifier$iv = PaddingKt.m762paddingVpY3zN4$default(Modifier.Companion, ListItemKt.TrailingHorizontalPadding, 0.0f, 2, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                long j = this.$contentColor;
                Function2<Composer, Integer, Unit> function2 = this.$trailingContent;
                int i2 = this.$$changed;
                composer.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                composer.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                int i3 = $dirty;
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer);
                Density density$iv$iv = (Density) consume;
                Alignment alignment = contentAlignment$iv;
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer);
                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer);
                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                Modifier modifier = modifier$iv;
                int $changed$iv$iv$iv = ((((54 << 3) & 112) << 9) & 7168) | 6;
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
                Density density = density$iv$iv;
                $composer$iv.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation($composer$iv, "C72@3384L9:Box.kt#2w3rfo");
                if ((($changed$iv$iv$iv >> 9) & 14 & 11) != 2 || !$composer$iv.getSkipping()) {
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    LayoutDirection layoutDirection = layoutDirection$iv$iv;
                    Composer $composer2 = $composer$iv;
                    $composer2.startReplaceableGroup(-1890987531);
                    ComposerKt.sourceInformation($composer2, "C345@13323L181:ListItem.kt#uh7d8r");
                    int i4 = $changed$iv$iv$iv;
                    if (((((54 >> 6) & 112) | 6) & 81) != 16 || !$composer2.getSkipping()) {
                        ListItemKt.m1973ProvideTextStyleFromToken3JVO9M(j, ListTokens.INSTANCE.getListItemTrailingSupportingTextFont(), function2, $composer2, ((i2 >> 3) & 14) | 48 | ((i2 << 6) & 896));
                    } else {
                        $composer2.skipToGroupEnd();
                    }
                    $composer2.endReplaceableGroup();
                } else {
                    $composer$iv.skipToGroupEnd();
                    LayoutDirection layoutDirection2 = layoutDirection$iv$iv;
                    int i5 = $changed$iv$iv$iv;
                }
                $composer$iv.endReplaceableGroup();
                $composer.endReplaceableGroup();
                $composer.endNode();
                $composer.endReplaceableGroup();
                $composer.endReplaceableGroup();
                $composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(1857838233);
                ComposerKt.sourceInformation(composer, "351@13536L369");
                Modifier modifier$iv2 = PaddingKt.m762paddingVpY3zN4$default(rowScope.align(Modifier.Companion, Alignment.Companion.getCenterVertically()), ListItemKt.TrailingHorizontalPadding, 0.0f, 2, (Object) null);
                long j2 = this.$contentColor;
                Function2<Composer, Integer, Unit> function22 = this.$trailingContent;
                int i6 = this.$$changed;
                composer.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                composer.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = composer.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer);
                Density density$iv$iv2 = (Density) consume4;
                Alignment alignment2 = contentAlignment$iv2;
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                Modifier modifier2 = modifier$iv2;
                int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    composer.createNode(constructor2);
                } else {
                    $composer.useNode();
                }
                $composer.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2787constructorimpl($composer);
                Function0<ComposeUiNode> function02 = constructor2;
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer.enableReusing();
                skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                composer.startReplaceableGroup(2058660585);
                Composer $composer$iv2 = $composer;
                Density density2 = density$iv$iv2;
                $composer$iv2.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation($composer$iv2, "C72@3384L9:Box.kt#2w3rfo");
                if ((($changed$iv$iv$iv2 >> 9) & 14 & 11) != 2 || !$composer$iv2.getSkipping()) {
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    LayoutDirection layoutDirection3 = layoutDirection$iv$iv2;
                    Composer $composer3 = $composer$iv2;
                    $composer3.startReplaceableGroup(-471095028);
                    ComposerKt.sourceInformation($composer3, "C356@13722L181:ListItem.kt#uh7d8r");
                    if (((((0 >> 6) & 112) | 6) & 81) != 16 || !$composer3.getSkipping()) {
                        ListItemKt.m1973ProvideTextStyleFromToken3JVO9M(j2, ListTokens.INSTANCE.getListItemTrailingSupportingTextFont(), function22, $composer3, ((i6 >> 3) & 14) | 48 | ((i6 << 6) & 896));
                    } else {
                        $composer3.skipToGroupEnd();
                    }
                    $composer3.endReplaceableGroup();
                } else {
                    $composer$iv2.skipToGroupEnd();
                    LayoutDirection layoutDirection4 = layoutDirection$iv$iv2;
                }
                $composer$iv2.endReplaceableGroup();
                $composer.endReplaceableGroup();
                $composer.endNode();
                $composer.endReplaceableGroup();
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
        int i7 = $dirty;
    }
}
