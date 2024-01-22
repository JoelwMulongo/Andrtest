package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class EnterExitTransitionKt$slideInOut$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ String $labelPrefix;
    final /* synthetic */ State<Slide> $slideIn;
    final /* synthetic */ State<Slide> $slideOut;
    final /* synthetic */ Transition<EnterExitState> $transition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnterExitTransitionKt$slideInOut$1(Transition<EnterExitState> transition, State<Slide> state, State<Slide> state2, String str) {
        super(3);
        this.$transition = transition;
        this.$slideIn = state;
        this.$slideOut = state2;
        this.$labelPrefix = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    private static final boolean invoke$lambda$1(MutableState<Boolean> $shouldAnimate$delegate) {
        return ((Boolean) $shouldAnimate$delegate.getValue()).booleanValue();
    }

    private static final void invoke$lambda$2(MutableState<Boolean> $shouldAnimate$delegate, boolean value) {
        $shouldAnimate$delegate.setValue(Boolean.valueOf(value));
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        MutableState key1$iv;
        Modifier modifier;
        Object value$iv$iv;
        Object value$iv$iv2;
        Modifier modifier2 = $this$composed;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
        composer.startReplaceableGroup(158379472);
        ComposerKt.sourceInformation(composer, "C954@41309L46,966@41734L33,964@41658L119,968@41801L88:EnterExitTransition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(158379472, $changed, -1, "androidx.compose.animation.slideInOut.<anonymous> (EnterExitTransition.kt:951)");
        } else {
            int i = $changed;
        }
        Transition<EnterExitState> transition = this.$transition;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) transition);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            Transition<EnterExitState> transition2 = transition;
            key1$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            $this$cache$iv$iv.updateRememberedValue(key1$iv);
        } else {
            Transition<EnterExitState> transition3 = transition;
            key1$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MutableState shouldAnimate$delegate = key1$iv;
        if (this.$transition.getCurrentState() == this.$transition.getTargetState() && !this.$transition.isSeeking()) {
            invoke$lambda$2(shouldAnimate$delegate, false);
        } else if (!(this.$slideIn.getValue() == null && this.$slideOut.getValue() == null)) {
            invoke$lambda$2(shouldAnimate$delegate, true);
        }
        if (invoke$lambda$1(shouldAnimate$delegate)) {
            Transition<EnterExitState> transition4 = this.$transition;
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
            String str = this.$labelPrefix;
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv2 = $composer;
            Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
            if (it$iv$iv2 == Composer.Companion.getEmpty()) {
                value$iv$iv = str + " slide";
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv2;
            }
            $composer.endReplaceableGroup();
            Transition.DeferredAnimation animation = TransitionKt.createDeferredAnimation(transition4, vectorConverter, (String) value$iv$iv, $composer, 448, 0);
            Object key1$iv2 = this.$transition;
            State<Slide> state = this.$slideIn;
            State<Slide> state2 = this.$slideOut;
            composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv2 = composer.changed(key1$iv2);
            Composer $this$cache$iv$iv3 = $composer;
            Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
            if (invalid$iv$iv2 || it$iv$iv3 == Composer.Companion.getEmpty()) {
                value$iv$iv2 = new SlideModifier(animation, state, state2);
                $this$cache$iv$iv3.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv3;
            }
            $composer.endReplaceableGroup();
            modifier = modifier2.then((SlideModifier) value$iv$iv2);
        } else {
            modifier = modifier2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return modifier;
    }
}
