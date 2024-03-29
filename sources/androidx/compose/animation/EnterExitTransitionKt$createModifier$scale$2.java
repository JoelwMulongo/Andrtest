package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class EnterExitTransitionKt$createModifier$scale$2 extends Lambda implements Function3<Transition.Segment<EnterExitState>, Composer, Integer, FiniteAnimationSpec<Float>> {
    final /* synthetic */ EnterTransition $enter;
    final /* synthetic */ ExitTransition $exit;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnterExitTransitionKt$createModifier$scale$2(EnterTransition enterTransition, ExitTransition exitTransition) {
        super(3);
        this.$enter = enterTransition;
        this.$exit = exitTransition;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Transition.Segment<EnterExitState>) (Transition.Segment) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> $this$animateFloat, Composer $composer, int $changed) {
        FiniteAnimationSpec<Float> finiteAnimationSpec;
        Intrinsics.checkNotNullParameter($this$animateFloat, "$this$animateFloat");
        $composer.startReplaceableGroup(-53984035);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-53984035, $changed, -1, "androidx.compose.animation.createModifier.<anonymous> (EnterExitTransition.kt:884)");
        }
        if ($this$animateFloat.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
            Scale scale = this.$enter.getData$animation_release().getScale();
            if (scale == null || (finiteAnimationSpec = scale.getAnimationSpec()) == null) {
                finiteAnimationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
            }
        } else if ($this$animateFloat.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit)) {
            Scale scale2 = this.$exit.getData$animation_release().getScale();
            if (scale2 == null || (finiteAnimationSpec = scale2.getAnimationSpec()) == null) {
                finiteAnimationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
            }
        } else {
            finiteAnimationSpec = EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return finiteAnimationSpec;
    }
}
