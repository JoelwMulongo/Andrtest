package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.tooling.ComposeAnimation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PreviewAnimationClock.kt */
final class PreviewAnimationClock$trackUnsupported$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ String $label;
    final /* synthetic */ PreviewAnimationClock this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreviewAnimationClock$trackUnsupported$1(String str, PreviewAnimationClock previewAnimationClock) {
        super(1);
        this.$label = str;
        this.this$0 = previewAnimationClock;
    }

    public final void invoke(Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        UnsupportedComposeAnimation it2 = UnsupportedComposeAnimation.Companion.create(this.$label);
        if (it2 != null) {
            PreviewAnimationClock previewAnimationClock = this.this$0;
            previewAnimationClock.getTrackedUnsupportedAnimations().add(it2);
            previewAnimationClock.notifySubscribe((ComposeAnimation) it2);
        }
    }
}
