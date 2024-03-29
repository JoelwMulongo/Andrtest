package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$pointerInput$2$2$1", f = "SuspendingPointerInputFilter.kt", i = {}, l = {244}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SuspendingPointerInputFilter.kt */
final class SuspendingPointerInputFilterKt$pointerInput$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ SuspendingPointerInputFilter $filter;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuspendingPointerInputFilterKt$pointerInput$2$2$1(SuspendingPointerInputFilter suspendingPointerInputFilter, Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super SuspendingPointerInputFilterKt$pointerInput$2$2$1> continuation) {
        super(2, continuation);
        this.$filter = suspendingPointerInputFilter;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SuspendingPointerInputFilterKt$pointerInput$2$2$1 suspendingPointerInputFilterKt$pointerInput$2$2$1 = new SuspendingPointerInputFilterKt$pointerInput$2$2$1(this.$filter, this.$block, continuation);
        suspendingPointerInputFilterKt$pointerInput$2$2$1.L$0 = obj;
        return suspendingPointerInputFilterKt$pointerInput$2$2$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuspendingPointerInputFilterKt$pointerInput$2$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.$filter.setCoroutineScope((CoroutineScope) this.L$0);
                Function2<PointerInputScope, Continuation<? super Unit>, Object> function2 = this.$block;
                SuspendingPointerInputFilter suspendingPointerInputFilter = this.$filter;
                this.label = 1;
                if (function2.invoke(suspendingPointerInputFilter, this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
