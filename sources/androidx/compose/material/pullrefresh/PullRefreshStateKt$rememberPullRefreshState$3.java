package androidx.compose.material.pullrefresh;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullRefreshState.kt */
final class PullRefreshStateKt$rememberPullRefreshState$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $refreshing;
    final /* synthetic */ Ref.FloatRef $refreshingOffsetPx;
    final /* synthetic */ PullRefreshState $state;
    final /* synthetic */ Ref.FloatRef $thresholdPx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullRefreshStateKt$rememberPullRefreshState$3(PullRefreshState pullRefreshState, boolean z, Ref.FloatRef floatRef, Ref.FloatRef floatRef2) {
        super(0);
        this.$state = pullRefreshState;
        this.$refreshing = z;
        this.$thresholdPx = floatRef;
        this.$refreshingOffsetPx = floatRef2;
    }

    public final void invoke() {
        this.$state.setRefreshing$material_release(this.$refreshing);
        this.$state.setThreshold$material_release(this.$thresholdPx.element);
        this.$state.setRefreshingOffset$material_release(this.$refreshingOffsetPx.element);
    }
}
