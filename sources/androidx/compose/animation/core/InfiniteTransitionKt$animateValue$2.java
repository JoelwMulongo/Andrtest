package androidx.compose.animation.core;

import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: InfiniteTransition.kt */
final class InfiniteTransitionKt$animateValue$2 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ InfiniteTransition $this_animateValue;
    final /* synthetic */ InfiniteTransition.TransitionAnimationState<T, V> $transitionAnimation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InfiniteTransitionKt$animateValue$2(InfiniteTransition infiniteTransition, InfiniteTransition.TransitionAnimationState<T, V> transitionAnimationState) {
        super(1);
        this.$this_animateValue = infiniteTransition;
        this.$transitionAnimation = transitionAnimationState;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        this.$this_animateValue.addAnimation$animation_core_release(this.$transitionAnimation);
        DisposableEffectScope disposableEffectScope = $this$DisposableEffect;
        return new InfiniteTransitionKt$animateValue$2$invoke$$inlined$onDispose$1(this.$this_animateValue, this.$transitionAnimation);
    }
}
