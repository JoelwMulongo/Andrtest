package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.pager.AwaitLazyListStateSet", f = "PagerState.kt", i = {0, 0}, l = {418}, m = "waitFinalLazyListSetting", n = {"this", "previousContinuation"}, s = {"L$0", "L$1"})
/* compiled from: PagerState.kt */
final class AwaitLazyListStateSet$waitFinalLazyListSetting$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AwaitLazyListStateSet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AwaitLazyListStateSet$waitFinalLazyListSetting$1(AwaitLazyListStateSet awaitLazyListStateSet, Continuation<? super AwaitLazyListStateSet$waitFinalLazyListSetting$1> continuation) {
        super(continuation);
        this.this$0 = awaitLazyListStateSet;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.waitFinalLazyListSetting(this);
    }
}
