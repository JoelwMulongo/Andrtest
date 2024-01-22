package androidx.compose.material;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SwipeableV2State", f = "SwipeableV2.kt", i = {0}, l = {335}, m = "animateTo", n = {"this"}, s = {"L$0"})
/* compiled from: SwipeableV2.kt */
final class SwipeableV2State$animateTo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableV2State$animateTo$1(SwipeableV2State<T> swipeableV2State, Continuation<? super SwipeableV2State$animateTo$1> continuation) {
        super(continuation);
        this.this$0 = swipeableV2State;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.animateTo(null, 0.0f, this);
    }
}
