package androidx.compose.material.pullrefresh;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullRefresh.kt */
/* synthetic */ class PullRefreshKt$pullRefresh$2$1 extends FunctionReferenceImpl implements Function1<Float, Float> {
    PullRefreshKt$pullRefresh$2$1(Object obj) {
        super(1, obj, PullRefreshState.class, "onPull", "onPull$material_release(F)F", 0);
    }

    public final Float invoke(float p0) {
        return Float.valueOf(((PullRefreshState) this.receiver).onPull$material_release(p0));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return invoke(((Number) p1).floatValue());
    }
}
