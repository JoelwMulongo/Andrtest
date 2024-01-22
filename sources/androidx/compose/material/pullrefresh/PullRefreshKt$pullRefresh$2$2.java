package androidx.compose.material.pullrefresh;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullRefresh.kt */
/* synthetic */ class PullRefreshKt$pullRefresh$2$2 extends AdaptedFunctionReference implements Function2<Float, Continuation<? super Float>, Object>, SuspendFunction {
    PullRefreshKt$pullRefresh$2$2(Object obj) {
        super(2, obj, PullRefreshState.class, "onRelease", "onRelease$material_release(F)F", 4);
    }

    public final Object invoke(float p0, Continuation<? super Float> $completion) {
        return Boxing.boxFloat(((PullRefreshState) this.receiver).onRelease$material_release(p0));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object $completion) {
        return invoke(((Number) p1).floatValue(), (Continuation<? super Float>) (Continuation) $completion);
    }
}
