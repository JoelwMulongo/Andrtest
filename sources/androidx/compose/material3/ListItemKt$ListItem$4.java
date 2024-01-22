package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
final class ListItemKt$ListItem$4 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ ListItemColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $headlineText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingContent;
    final /* synthetic */ Function2<Composer, Integer, Unit> $overlineText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $supportingText;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListItemKt$ListItem$4(Function2<? super Composer, ? super Integer, Unit> function2, ListItemColors listItemColors, int i, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25) {
        super(3);
        this.$leadingContent = function2;
        this.$colors = listItemColors;
        this.$$dirty = i;
        this.$trailingContent = function22;
        this.$overlineText = function23;
        this.$headlineText = function24;
        this.$supportingText = function25;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((RowScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(RowScope $this$ListItem, Composer $composer, int $changed) {
        Composer $composer$iv;
        Composer $composer$iv2;
        Composer $composer2;
        RowScope rowScope = $this$ListItem;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(rowScope, "$this$ListItem");
        ComposerKt.sourceInformation(composer, "C228@9422L865,254@10461L33,252@10347L208,252@10347L210:ListItem.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= composer.changed((Object) rowScope) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1269203265, $dirty2, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:220)");
            }
            composer.startReplaceableGroup(1316677284);
            ComposerKt.sourceInformation(composer, "224@9300L32,222@9189L204,222@9189L206");
            Function2<Composer, Integer, Unit> function2 = this.$leadingContent;
            if (function2 != null) {
                ListItemKt.m1978leadingContentiJQMabo(function2, this.$colors.leadingIconColor$material3_release(true, composer, ((this.$$dirty >> 15) & 112) | 6).getValue().m3174unboximpl(), true, $composer, ((this.$$dirty >> 12) & 14) | 384).invoke(rowScope, composer, Integer.valueOf($dirty2 & 14));
            }
            $composer.endReplaceableGroup();
            Modifier modifier$iv = PaddingKt.m764paddingqDBjuR0$default(RowScope.weight$default($this$ListItem, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 0.0f, ListItemKt.ContentEndPadding, 0.0f, 11, (Object) null);
            ListItemColors listItemColors = this.$colors;
            int i = this.$$dirty;
            Function2<Composer, Integer, Unit> function22 = this.$overlineText;
            Function2<Composer, Integer, Unit> function23 = this.$headlineText;
            Function2<Composer, Integer, Unit> function24 = this.$supportingText;
            composer.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Alignment contentAlignment$iv2 = contentAlignment$iv;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            int $dirty3 = $dirty2;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
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
            Function0 function0 = constructor;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer.enableReusing();
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            function32.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv3 = $composer;
            $composer$iv3.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation($composer$iv3, "C72@3384L9:Box.kt#2w3rfo");
            int i2 = $changed$iv$iv$iv;
            if (($changed$iv & 11) != 2 || !$composer$iv3.getSkipping()) {
                int $changed2 = ((0 >> 6) & 112) | 6;
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                Composer $composer3 = $composer$iv3;
                $composer3.startReplaceableGroup(-729239559);
                ComposerKt.sourceInformation($composer3, "C233@9571L702:ListItem.kt#uh7d8r");
                int i3 = $changed2;
                if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                    $composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation($composer3, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
                    Modifier modifier$iv2 = Modifier.Companion;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Density density = density$iv$iv;
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                    MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    Arrangement.Vertical vertical = verticalArrangement$iv;
                    $composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    Alignment.Horizontal horizontal = horizontalAlignment$iv;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume4 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density density$iv$iv2 = (Density) consume4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume5 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                    Composer $composer$iv4 = $composer$iv3;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume6 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier$iv2);
                    Modifier modifier2 = modifier$iv2;
                    int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                    MeasurePolicy measurePolicy$iv3 = measurePolicy$iv;
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        $composer3.createNode(constructor2);
                    } else {
                        $composer3.useNode();
                    }
                    $composer3.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2787constructorimpl($composer3);
                    Function0<ComposeUiNode> function02 = constructor2;
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                    $composer3.enableReusing();
                    materializerOf2.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                    $composer3.startReplaceableGroup(2058660585);
                    int $changed$iv2 = ($changed$iv$iv$iv2 >> 9) & 14;
                    Composer $composer$iv5 = $composer3;
                    $composer$iv5.startReplaceableGroup(-1163856341);
                    ComposerKt.sourceInformation($composer$iv5, "C79@3994L9:Column.kt#2w3rfo");
                    int i4 = $changed$iv$iv$iv2;
                    if (($changed$iv2 & 11) != 2 || !$composer$iv5.getSkipping()) {
                        Composer $composer4 = $composer$iv5;
                        $composer4.startReplaceableGroup(-466219709);
                        ComposerKt.sourceInformation($composer4, "C235@9658L15,234@9600L196,240@9875L29,239@9817L211,245@10107L17,244@10049L206:ListItem.kt#uh7d8r");
                        int i5 = (((0 >> 6) & 112) | 6) & 81;
                        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                        if (i5 != 16 || !$composer4.getSkipping()) {
                            int i6 = (i >> 18) & 14;
                            Density density2 = density$iv$iv2;
                            $composer$iv2 = $composer$iv5;
                            Composer $composer5 = $composer4;
                            $composer$iv = $composer$iv4;
                            Function0<ComposeUiNode> function03 = function02;
                            MeasurePolicy measurePolicy = measurePolicy$iv3;
                            Function0 factory$iv$iv$iv = function0;
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = materializerOf2;
                            Alignment alignment = contentAlignment$iv2;
                            ListItemKt.m1973ProvideTextStyleFromToken3JVO9M(listItemColors.overlineColor$material3_release($composer4, i6).getValue().m3174unboximpl(), ListTokens.INSTANCE.getListItemOverlineFont(), function22, $composer5, (i & 896) | 48);
                            $composer2 = $composer5;
                            Composer composer2 = $composer2;
                            ListItemKt.m1973ProvideTextStyleFromToken3JVO9M(listItemColors.headlineColor$material3_release(true, $composer2, ((i >> 15) & 112) | 6).getValue().m3174unboximpl(), ListTokens.INSTANCE.getListItemLabelTextFont(), function23, composer2, ((i << 6) & 896) | 48);
                            ListItemKt.m1973ProvideTextStyleFromToken3JVO9M(listItemColors.supportingColor$material3_release($composer2, i6).getValue().m3174unboximpl(), ListTokens.INSTANCE.getListItemSupportingTextFont(), function24, composer2, ((i >> 3) & 896) | 48);
                        } else {
                            $composer4.skipToGroupEnd();
                            Density density3 = density$iv$iv2;
                            $composer$iv2 = $composer$iv5;
                            $composer2 = $composer4;
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = materializerOf2;
                            Alignment alignment2 = contentAlignment$iv2;
                            $composer$iv = $composer$iv4;
                            Function0<ComposeUiNode> function04 = function02;
                            MeasurePolicy measurePolicy2 = measurePolicy$iv3;
                            Function0 factory$iv$iv$iv2 = function0;
                        }
                        $composer2.endReplaceableGroup();
                    } else {
                        $composer$iv5.skipToGroupEnd();
                        Density density4 = density$iv$iv2;
                        $composer$iv2 = $composer$iv5;
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function36 = materializerOf2;
                        Alignment alignment3 = contentAlignment$iv2;
                        $composer$iv = $composer$iv4;
                        Function0<ComposeUiNode> function05 = function02;
                        MeasurePolicy measurePolicy3 = measurePolicy$iv3;
                        Function0 factory$iv$iv$iv3 = function0;
                    }
                    $composer$iv2.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                    $composer3.endNode();
                    $composer3.endReplaceableGroup();
                    $composer3.endReplaceableGroup();
                } else {
                    $composer3.skipToGroupEnd();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function37 = function32;
                    Density density5 = density$iv$iv;
                    ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv;
                    $composer$iv = $composer$iv3;
                    MeasurePolicy measurePolicy4 = measurePolicy$iv;
                    Alignment alignment4 = contentAlignment$iv2;
                    Function0<ComposeUiNode> function06 = function0;
                }
                $composer3.endReplaceableGroup();
            } else {
                $composer$iv3.skipToGroupEnd();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function38 = function32;
                Density density6 = density$iv$iv;
                ViewConfiguration viewConfiguration3 = viewConfiguration$iv$iv;
                $composer$iv = $composer$iv3;
                MeasurePolicy measurePolicy5 = measurePolicy$iv;
                Alignment alignment5 = contentAlignment$iv2;
                Function0<ComposeUiNode> function07 = function0;
            }
            $composer$iv.endReplaceableGroup();
            $composer.endReplaceableGroup();
            $composer.endNode();
            $composer.endReplaceableGroup();
            $composer.endReplaceableGroup();
            Function2<Composer, Integer, Unit> function25 = this.$trailingContent;
            if (function25 != null) {
                ListItemKt.m1979trailingContentiJQMabo(function25, this.$colors.trailingIconColor$material3_release(true, composer, ((this.$$dirty >> 15) & 112) | 6).getValue().m3174unboximpl(), true, $composer, ((this.$$dirty >> 15) & 14) | 384).invoke($this$ListItem, composer, Integer.valueOf($dirty3 & 14));
            } else {
                RowScope rowScope2 = $this$ListItem;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
        RowScope rowScope3 = rowScope;
        int i7 = $dirty2;
    }
}
