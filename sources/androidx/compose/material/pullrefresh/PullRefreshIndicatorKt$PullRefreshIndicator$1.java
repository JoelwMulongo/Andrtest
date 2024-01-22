package androidx.compose.material.pullrefresh;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullRefreshIndicator.kt */
final class PullRefreshIndicatorKt$PullRefreshIndicator$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ boolean $refreshing;
    final /* synthetic */ PullRefreshState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullRefreshIndicatorKt$PullRefreshIndicator$1(boolean z, int i, long j, PullRefreshState pullRefreshState) {
        super(2);
        this.$refreshing = z;
        this.$$dirty = i;
        this.$contentColor = j;
        this.$state = pullRefreshState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C92@3786L774:PullRefreshIndicator.kt#t44y28");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-194757728, $changed, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator.<anonymous> (PullRefreshIndicator.kt:91)");
            }
            final long j = this.$contentColor;
            final int i = this.$$dirty;
            final PullRefreshState pullRefreshState = this.$state;
            CrossfadeKt.Crossfade(Boolean.valueOf(this.$refreshing), (Modifier) null, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), ComposableLambdaKt.composableLambda($composer, -2067838016, true, new Function3<Boolean, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                    invoke(((Boolean) p1).booleanValue(), (Composer) p2, ((Number) p3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean refreshing, Composer $composer, int $changed) {
                    boolean z = refreshing;
                    Composer composer = $composer;
                    int i = $changed;
                    ComposerKt.sourceInformation(composer, "C96@3945L605:PullRefreshIndicator.kt#t44y28");
                    int $dirty = $changed;
                    if ((i & 14) == 0) {
                        $dirty |= composer.changed(z) ? 4 : 2;
                    }
                    if (($dirty & 91) != 18 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2067838016, i, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator.<anonymous>.<anonymous> (PullRefreshIndicator.kt:95)");
                        }
                        Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                        long j = j;
                        int i2 = i;
                        PullRefreshState pullRefreshState = pullRefreshState;
                        composer.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
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
                        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
                        int i3 = $dirty;
                        int $changed$iv$iv$iv = ((((54 << 3) & 112) << 9) & 7168) | 6;
                        Modifier modifier = modifier$iv;
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
                        Composer $composer$iv = $composer;
                        ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                        ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i4 = ((54 >> 6) & 112) | 6;
                        Density density$iv$iv2 = density$iv$iv;
                        Composer $composer2 = $composer$iv;
                        ComposerKt.sourceInformationMarkerStart($composer2, -2035147647, "C:PullRefreshIndicator.kt#t44y28");
                        int i5 = ($changed$iv$iv$iv >> 9) & 14;
                        float arg0$iv = Dp.m5986constructorimpl(((float) 2) * Dp.m5986constructorimpl(PullRefreshIndicatorKt.ArcRadius + PullRefreshIndicatorKt.StrokeWidth));
                        if (z) {
                            $composer2.startReplaceableGroup(-2035147561);
                            ComposerKt.sourceInformation($composer2, "103@4193L208");
                            LayoutDirection layoutDirection = layoutDirection$iv$iv;
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
                            Composer $composer3 = $composer2;
                            Density density = density$iv$iv2;
                            MeasurePolicy measurePolicy = measurePolicy$iv;
                            ProgressIndicatorKt.m1570CircularProgressIndicatorLxG7B9w(SizeKt.m830size3ABfNKs(Modifier.Companion, arg0$iv), j, PullRefreshIndicatorKt.StrokeWidth, 0, 0, $composer3, ((i2 >> 9) & true) | true, 24);
                            $composer3.endReplaceableGroup();
                            $composer2 = $composer3;
                        } else {
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = materializerOf;
                            Composer composer2 = $composer2;
                            MeasurePolicy measurePolicy2 = measurePolicy$iv;
                            Density density2 = density$iv$iv2;
                            $composer2.startReplaceableGroup(-2035147307);
                            ComposerKt.sourceInformation($composer2, "109@4447L71");
                            PullRefreshIndicatorKt.m1708CircularArrowIndicatoriJQMabo(pullRefreshState, j, SizeKt.m830size3ABfNKs(Modifier.Companion, arg0$iv), $composer2, ((i2 >> 9) & 112) | 392);
                            $composer2.endReplaceableGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
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
                    int i6 = $dirty;
                }
            }), $composer, (this.$$dirty & 14) | 3456, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
