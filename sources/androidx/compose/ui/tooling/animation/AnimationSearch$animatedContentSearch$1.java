package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/animation/core/Transition;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimationSearch.kt */
final class AnimationSearch$animatedContentSearch$1 extends Lambda implements Function1<Transition<?>, Unit> {
    final /* synthetic */ AnimationSearch this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimationSearch$animatedContentSearch$1(AnimationSearch animationSearch) {
        super(1);
        this.this$0 = animationSearch;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Transition<?>) (Transition) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Transition<?> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ((PreviewAnimationClock) this.this$0.clock.invoke()).trackAnimatedContent(it);
    }
}
