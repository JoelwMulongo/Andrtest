package androidx.compose.material;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SwipeableV2State", f = "SwipeableV2.kt", i = {0, 0}, l = {304}, m = "snapTo", n = {"this", "targetValue"}, s = {"L$0", "L$1"})
/* compiled from: SwipeableV2.kt */
final class SwipeableV2State$snapTo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableV2State$snapTo$1(SwipeableV2State<T> swipeableV2State, Continuation<? super SwipeableV2State$snapTo$1> continuation) {
        super(continuation);
        this.this$0 = swipeableV2State;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.snapTo(null, this);
    }
}
