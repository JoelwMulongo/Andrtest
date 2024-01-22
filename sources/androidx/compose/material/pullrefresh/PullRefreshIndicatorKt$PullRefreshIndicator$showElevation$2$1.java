package androidx.compose.material.pullrefresh;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullRefreshIndicator.kt */
final class PullRefreshIndicatorKt$PullRefreshIndicator$showElevation$2$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ boolean $refreshing;
    final /* synthetic */ PullRefreshState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullRefreshIndicatorKt$PullRefreshIndicator$showElevation$2$1(boolean z, PullRefreshState pullRefreshState) {
        super(0);
        this.$refreshing = z;
        this.$state = pullRefreshState;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(this.$refreshing || this.$state.getPosition$material_release() > 0.5f);
    }
}
