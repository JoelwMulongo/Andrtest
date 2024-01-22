package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.ui.tooling.animation.clock.AnimatedVisibilityClock;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PreviewAnimationClock.kt */
final class PreviewAnimationClock$trackAnimatedVisibility$2 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Transition<?> $animation;
    final /* synthetic */ Function0<Unit> $onSeek;
    final /* synthetic */ PreviewAnimationClock this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreviewAnimationClock$trackAnimatedVisibility$2(Transition<?> transition, Function0<Unit> function0, PreviewAnimationClock previewAnimationClock) {
        super(1);
        this.$animation = transition;
        this.$onSeek = function0;
        this.this$0 = previewAnimationClock;
    }

    public final void invoke(Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNull(this.$animation, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Boolean>");
        ComposeAnimation parseAnimatedVisibility = AnimatedVisibilityComposeAnimationKt.parseAnimatedVisibility(this.$animation);
        this.$onSeek.invoke();
        Map<AnimatedVisibilityComposeAnimation, AnimatedVisibilityClock> animatedVisibilityClocks$ui_tooling_release = this.this$0.getAnimatedVisibilityClocks$ui_tooling_release();
        AnimatedVisibilityClock $this$invoke_u24lambda_u240 = new AnimatedVisibilityClock(parseAnimatedVisibility);
        $this$invoke_u24lambda_u240.setClockTime(0);
        animatedVisibilityClocks$ui_tooling_release.put(parseAnimatedVisibility, $this$invoke_u24lambda_u240);
        this.this$0.notifySubscribe(parseAnimatedVisibility);
    }
}
