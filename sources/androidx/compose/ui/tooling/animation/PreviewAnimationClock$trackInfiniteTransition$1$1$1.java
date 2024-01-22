package androidx.compose.ui.tooling.animation;

import androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock;
import androidx.compose.ui.tooling.animation.clock.InfiniteTransitionClock;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PreviewAnimationClock.kt */
final class PreviewAnimationClock$trackInfiniteTransition$1$1$1 extends Lambda implements Function0<Long> {
    final /* synthetic */ PreviewAnimationClock this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreviewAnimationClock$trackInfiniteTransition$1$1$1(PreviewAnimationClock previewAnimationClock) {
        super(0);
        this.this$0 = previewAnimationClock;
    }

    public final Long invoke() {
        Comparable comparable;
        Iterator it = this.this$0.getAllClocksExceptInfinite().iterator();
        Long l = null;
        if (!it.hasNext()) {
            comparable = null;
        } else {
            comparable = Long.valueOf(((ComposeAnimationClock) it.next()).getMaxDuration());
            while (it.hasNext()) {
                Comparable valueOf = Long.valueOf(((ComposeAnimationClock) it.next()).getMaxDuration());
                if (comparable.compareTo(valueOf) < 0) {
                    comparable = valueOf;
                }
            }
        }
        Long l2 = (Long) comparable;
        long infiniteMaxDurationPerIteration = 0;
        long otherClockMaxDuration = l2 != null ? l2.longValue() : 0;
        Iterator it2 = this.this$0.getInfiniteTransitionClocks$ui_tooling_release().values().iterator();
        if (it2.hasNext()) {
            l = Long.valueOf(((InfiniteTransitionClock) it2.next()).getMaxDurationPerIteration());
            while (it2.hasNext()) {
                Comparable valueOf2 = Long.valueOf(((InfiniteTransitionClock) it2.next()).getMaxDurationPerIteration());
                if (l.compareTo(valueOf2) < 0) {
                    l = valueOf2;
                }
            }
        }
        Long l3 = l;
        if (l3 != null) {
            infiniteMaxDurationPerIteration = l3.longValue();
        }
        return Long.valueOf(Math.max(otherClockMaxDuration, infiniteMaxDurationPerIteration));
    }
}
