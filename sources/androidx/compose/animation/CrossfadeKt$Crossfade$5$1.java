package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Crossfade.kt */
final class CrossfadeKt$Crossfade$5$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
    final /* synthetic */ Function3<T, Composer, Integer, Unit> $content;
    final /* synthetic */ T $stateForContent;
    final /* synthetic */ Transition<T> $this_Crossfade;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CrossfadeKt$Crossfade$5$1(Transition<T> transition, int i, FiniteAnimationSpec<Float> finiteAnimationSpec, T t, Function3<? super T, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$this_Crossfade = transition;
        this.$$dirty = i;
        this.$animationSpec = finiteAnimationSpec;
        this.$stateForContent = t;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final float invoke$lambda$1(State<Float> $alpha$delegate) {
        return ((Number) $alpha$delegate.getValue()).floatValue();
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv$iv;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C128@5454L128,131@5626L22,131@5599L115:Crossfade.kt#xbi5r1");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1426421288, i, -1, "androidx.compose.animation.Crossfade.<anonymous>.<anonymous> (Crossfade.kt:127)");
            }
            Transition transition = this.$this_Crossfade;
            Function3 transitionSpec$iv = new CrossfadeKt$Crossfade$5$1$alpha$2(this.$animationSpec);
            T t = this.$stateForContent;
            int $changed$iv = this.$$dirty & 14;
            composer.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation(composer, "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            int $changed$iv$iv = ($changed$iv & 14) | (($changed$iv << 3) & 896) | (($changed$iv << 3) & 7168) | (($changed$iv << 3) & 57344);
            Transition $this$animateValue$iv$iv = transition;
            composer.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
            Object it = $this$animateValue$iv$iv.getCurrentState();
            int $changed2 = ($changed$iv$iv >> 9) & 112;
            Composer $composer2 = $composer;
            $composer2.startReplaceableGroup(-438678252);
            ComposerKt.sourceInformation($composer2, "C:Crossfade.kt#xbi5r1");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-438678252, $changed2, -1, "androidx.compose.animation.Crossfade.<anonymous>.<anonymous>.<anonymous> (Crossfade.kt:130)");
            }
            float f = 1.0f;
            float f2 = Intrinsics.areEqual(it, (Object) t) != 0 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2.endReplaceableGroup();
            Object initialValue$iv$iv = Float.valueOf(f2);
            Object it2 = $this$animateValue$iv$iv.getTargetState();
            int $changed3 = ($changed$iv$iv >> 9) & 112;
            Composer $composer3 = $composer;
            $composer3.startReplaceableGroup(-438678252);
            ComposerKt.sourceInformation($composer3, "C:Crossfade.kt#xbi5r1");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-438678252, $changed3, -1, "androidx.compose.animation.Crossfade.<anonymous>.<anonymous>.<anonymous> (Crossfade.kt:130)");
            }
            if (!Intrinsics.areEqual(it2, (Object) t)) {
                f = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer3.endReplaceableGroup();
            State<Float> createTransitionAnimation = TransitionKt.createTransitionAnimation($this$animateValue$iv$iv, initialValue$iv$iv, Float.valueOf(f), (FiniteAnimationSpec) transitionSpec$iv.invoke($this$animateValue$iv$iv.getSegment(), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112)), vectorConverter, "FloatAnimation", $composer, ($changed$iv$iv & 14) | (($changed$iv$iv << 9) & 57344) | (($changed$iv$iv << 6) & 458752));
            $composer.endReplaceableGroup();
            $composer.endReplaceableGroup();
            State<Float> state = createTransitionAnimation;
            Modifier modifier = Modifier.Companion;
            composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = composer.changed((Object) state);
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = (Function1) new CrossfadeKt$Crossfade$5$1$1$1(state);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            Modifier modifier$iv = GraphicsLayerModifierKt.graphicsLayer(modifier, (Function1) value$iv$iv);
            Function3<T, Composer, Integer, Unit> function3 = this.$content;
            T t2 = this.$stateForContent;
            int i2 = this.$$dirty;
            composer.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            State<Float> state2 = state;
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
            Modifier modifier2 = modifier$iv;
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
            Composer $composer$iv = $composer;
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            $composer$iv.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation($composer$iv, "C72@3384L9:Box.kt#2w3rfo");
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            if ((($changed$iv$iv$iv >> 9) & 14 & 11) != 2 || !$composer$iv.getSkipping()) {
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i3 = ((0 >> 6) & 112) | 6;
                int i4 = $changed$iv$iv$iv;
                Composer $composer4 = $composer$iv;
                ComposerKt.sourceInformationMarkerStart($composer4, 2090121434, "C132@5672L24:Crossfade.kt#xbi5r1");
                function3.invoke(t2, $composer4, Integer.valueOf((i2 >> 9) & 112));
                ComposerKt.sourceInformationMarkerEnd($composer4);
            } else {
                $composer$iv.skipToGroupEnd();
                int i5 = $changed$iv$iv$iv;
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
