package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
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
final class ListItemKt$leadingContent$1 extends Lambda implements Function3<RowScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingContent;
    final /* synthetic */ boolean $topAlign;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListItemKt$leadingContent$1(long j, boolean z, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(3);
        this.$contentColor = j;
        this.$topAlign = z;
        this.$leadingContent = function2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((RowScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final RowScope $this$null, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        ComposerKt.sourceInformation($composer, "C315@12372L554:ListItem.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer.changed((Object) $this$null) ? 4 : 2;
        }
        if (($dirty & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1755598478, $changed, -1, "androidx.compose.material3.leadingContent.<anonymous> (ListItem.kt:314)");
            }
            ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(this.$contentColor))};
            final boolean z = this.$topAlign;
            final Function2<Composer, Integer, Unit> function2 = this.$leadingContent;
            final int i = this.$$changed;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer, -1636714958, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    Composer composer = $composer;
                    int i = $changed;
                    ComposerKt.sourceInformation(composer, "C:ListItem.kt#uh7d8r");
                    if ((i & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1636714958, i, -1, "androidx.compose.material3.leadingContent.<anonymous>.<anonymous> (ListItem.kt:316)");
                        }
                        if (z) {
                            composer.startReplaceableGroup(377880875);
                            ComposerKt.sourceInformation(composer, "318@12497L171");
                            Modifier modifier$iv = PaddingKt.m764paddingqDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, ListItemKt.LeadingContentEndPadding, 0.0f, 11, (Object) null);
                            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                            Function2<Composer, Integer, Unit> function2 = function2;
                            int i2 = i;
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
                            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
                            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                            int $changed$iv$iv$iv = ((((54 << 3) & 112) << 9) & 7168) | 6;
                            if (!($composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer.startReusableNode();
                            if ($composer.getInserting()) {
                                composer.createNode(factory$iv$iv$iv);
                            } else {
                                $composer.useNode();
                            }
                            $composer.disableReusing();
                            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer);
                            Modifier modifier = modifier$iv;
                            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
                            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
                            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
                            $composer.enableReusing();
                            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                            composer.startReplaceableGroup(2058660585);
                            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                            Composer $composer$iv = $composer;
                            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                            $composer$iv.startReplaceableGroup(-2137368960);
                            ComposerKt.sourceInformation($composer$iv, "C72@3384L9:Box.kt#2w3rfo");
                            if (($changed$iv & 11) != 2 || !$composer$iv.getSkipping()) {
                                int $changed2 = ((54 >> 6) & 112) | 6;
                                int i3 = $changed$iv;
                                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                Composer $composer2 = $composer$iv;
                                $composer2.startReplaceableGroup(781903379);
                                ComposerKt.sourceInformation($composer2, "C321@12650L16:ListItem.kt#uh7d8r");
                                int i4 = $changed2;
                                if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                    function2.invoke($composer2, Integer.valueOf(i2 & 14));
                                } else {
                                    $composer2.skipToGroupEnd();
                                }
                                $composer2.endReplaceableGroup();
                            } else {
                                $composer$iv.skipToGroupEnd();
                                int i5 = $changed$iv;
                            }
                            $composer$iv.endReplaceableGroup();
                            $composer.endReplaceableGroup();
                            $composer.endNode();
                            $composer.endReplaceableGroup();
                            $composer.endReplaceableGroup();
                            $composer.endReplaceableGroup();
                        } else {
                            composer.startReplaceableGroup(377881084);
                            ComposerKt.sourceInformation(composer, "323@12706L196");
                            Modifier modifier$iv2 = PaddingKt.m764paddingqDBjuR0$default($this$null.align(Modifier.Companion, Alignment.Companion.getCenterVertically()), 0.0f, 0.0f, ListItemKt.LeadingContentEndPadding, 0.0f, 11, (Object) null);
                            Function2<Composer, Integer, Unit> function22 = function2;
                            int i6 = i;
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
                            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume5 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume6 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                            Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                            Modifier modifier2 = modifier$iv2;
                            int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                            if (!($composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer.startReusableNode();
                            if ($composer.getInserting()) {
                                composer.createNode(factory$iv$iv$iv2);
                            } else {
                                $composer.useNode();
                            }
                            $composer.disableReusing();
                            Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2787constructorimpl($composer);
                            Alignment alignment = contentAlignment$iv2;
                            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                            $composer.enableReusing();
                            skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                            composer.startReplaceableGroup(2058660585);
                            Composer $composer$iv2 = $composer;
                            ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv2;
                            $composer$iv2.startReplaceableGroup(-2137368960);
                            ComposerKt.sourceInformation($composer$iv2, "C72@3384L9:Box.kt#2w3rfo");
                            if ((($changed$iv$iv$iv2 >> 9) & 14 & 11) != 2 || !$composer$iv2.getSkipping()) {
                                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                                Composer $composer3 = $composer$iv2;
                                $composer3.startReplaceableGroup(-1395522852);
                                ComposerKt.sourceInformation($composer3, "C327@12884L16:ListItem.kt#uh7d8r");
                                int i7 = $changed$iv$iv$iv2;
                                if (((((0 >> 6) & 112) | 6) & 81) != 16 || !$composer3.getSkipping()) {
                                    function22.invoke($composer3, Integer.valueOf(i6 & 14));
                                } else {
                                    $composer3.skipToGroupEnd();
                                }
                                $composer3.endReplaceableGroup();
                            } else {
                                $composer$iv2.skipToGroupEnd();
                                int i8 = $changed$iv$iv$iv2;
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
                }
            }), $composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
