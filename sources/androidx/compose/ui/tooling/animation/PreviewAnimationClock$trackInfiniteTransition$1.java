package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.ui.tooling.animation.AnimationSearch;
import androidx.compose.ui.tooling.animation.clock.InfiniteTransitionClock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PreviewAnimationClock.kt */
final class PreviewAnimationClock$trackInfiniteTransition$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ AnimationSearch.InfiniteTransitionSearchInfo $animation;
    final /* synthetic */ PreviewAnimationClock this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreviewAnimationClock$trackInfiniteTransition$1(AnimationSearch.InfiniteTransitionSearchInfo infiniteTransitionSearchInfo, PreviewAnimationClock previewAnimationClock) {
        super(1);
        this.$animation = infiniteTransitionSearchInfo;
        this.this$0 = previewAnimationClock;
    }

    public final void invoke(Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        InfiniteTransitionComposeAnimation it2 = InfiniteTransitionComposeAnimation.Companion.parse$ui_tooling_release(this.$animation);
        if (it2 != null) {
            PreviewAnimationClock previewAnimationClock = this.this$0;
            previewAnimationClock.getInfiniteTransitionClocks$ui_tooling_release().put(it2, new InfiniteTransitionClock(it2, new PreviewAnimationClock$trackInfiniteTransition$1$1$1(previewAnimationClock)));
            previewAnimationClock.notifySubscribe((ComposeAnimation) it2);
        }
    }
}
