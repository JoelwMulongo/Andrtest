package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.pager.PagerState", f = "PagerState.kt", i = {0}, l = {334, 335}, m = "awaitScrollDependencies", n = {"this"}, s = {"L$0"})
/* compiled from: PagerState.kt */
final class PagerState$awaitScrollDependencies$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PagerState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerState$awaitScrollDependencies$1(PagerState pagerState, Continuation<? super PagerState$awaitScrollDependencies$1> continuation) {
        super(continuation);
        this.this$0 = pagerState;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.awaitScrollDependencies(this);
    }
}
