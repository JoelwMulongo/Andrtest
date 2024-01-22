package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.pager.PagerState", f = "PagerState.kt", i = {0, 0, 0}, l = {263, 269}, m = "scrollToPage", n = {"this", "page", "pageOffsetFraction"}, s = {"L$0", "I$0", "F$0"})
/* compiled from: PagerState.kt */
final class PagerState$scrollToPage$1 extends ContinuationImpl {
    float F$0;
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PagerState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerState$scrollToPage$1(PagerState pagerState, Continuation<? super PagerState$scrollToPage$1> continuation) {
        super(continuation);
        this.this$0 = pagerState;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.scrollToPage(0, 0.0f, this);
    }
}
