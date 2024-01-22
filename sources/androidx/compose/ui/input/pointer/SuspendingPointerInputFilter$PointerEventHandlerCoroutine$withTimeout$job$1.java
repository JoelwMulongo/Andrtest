package androidx.compose.ui.input.pointer;

import androidx.compose.ui.input.pointer.SuspendingPointerInputFilter;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1", f = "SuspendingPointerInputFilter.kt", i = {}, l = {620, 621}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SuspendingPointerInputFilter.kt */
final class SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $timeMillis;
    int label;
    final /* synthetic */ SuspendingPointerInputFilter.PointerEventHandlerCoroutine<R> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1(long j, SuspendingPointerInputFilter.PointerEventHandlerCoroutine<R> pointerEventHandlerCoroutine, Continuation<? super SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1> continuation) {
        super(2, continuation);
        this.$timeMillis = j;
        this.this$0 = pointerEventHandlerCoroutine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1(this.$timeMillis, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1 suspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1;
        SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1 suspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                suspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$12 = this;
                suspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$12.label = 1;
                if (DelayKt.delay(suspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$12.$timeMillis - 1, suspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                suspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$12 = this;
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                suspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1 = this;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        suspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$12.label = 2;
        if (DelayKt.delay(1, suspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$12) == coroutine_suspended) {
            return coroutine_suspended;
        }
        suspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1 = suspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$12;
        CancellableContinuation access$getPointerAwaiter$p = suspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1.this$0.pointerAwaiter;
        if (access$getPointerAwaiter$p != null) {
            Result.Companion companion = Result.Companion;
            access$getPointerAwaiter$p.resumeWith(Result.m6273constructorimpl(ResultKt.createFailure(new PointerEventTimeoutCancellationException(suspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1.$timeMillis))));
        }
        return Unit.INSTANCE;
    }
}
