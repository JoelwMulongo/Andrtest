package androidx.compose.ui.tooling.animation;

import androidx.compose.ui.tooling.animation.AnimationSearch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/tooling/animation/AnimationSearch$InfiniteTransitionSearchInfo;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimationSearch.kt */
final class AnimationSearch$infiniteTransitionSearch$1 extends Lambda implements Function1<AnimationSearch.InfiniteTransitionSearchInfo, Unit> {
    final /* synthetic */ AnimationSearch this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimationSearch$infiniteTransitionSearch$1(AnimationSearch animationSearch) {
        super(1);
        this.this$0 = animationSearch;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((AnimationSearch.InfiniteTransitionSearchInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(AnimationSearch.InfiniteTransitionSearchInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ((PreviewAnimationClock) this.this$0.clock.invoke()).trackInfiniteTransition(it);
    }
}
