package androidx.compose.material.pullrefresh;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullRefreshIndicator.kt */
final class PullRefreshIndicatorKt$CircularArrowIndicator$targetAlpha$2$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ PullRefreshState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullRefreshIndicatorKt$CircularArrowIndicator$targetAlpha$2$1(PullRefreshState pullRefreshState) {
        super(0);
        this.$state = pullRefreshState;
    }

    public final Float invoke() {
        float f = 1.0f;
        if (this.$state.getProgress() < 1.0f) {
            f = 0.3f;
        }
        return Float.valueOf(f);
    }
}
