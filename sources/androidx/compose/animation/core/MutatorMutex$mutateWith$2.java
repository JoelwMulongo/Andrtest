package androidx.compose.animation.core;

import androidx.compose.animation.core.MutatorMutex;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;

@Metadata(d1 = {"\u0000\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "R", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.MutatorMutex$mutateWith$2", f = "InternalMutatorMutex.kt", i = {0, 0, 1, 1}, l = {171, 158}, m = "invokeSuspend", n = {"mutator", "$this$withLock_u24default$iv", "mutator", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: InternalMutatorMutex.kt */
final class MutatorMutex$mutateWith$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function2<T, Continuation<? super R>, Object> $block;
    final /* synthetic */ MutatePriority $priority;
    final /* synthetic */ T $receiver;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ MutatorMutex this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MutatorMutex$mutateWith$2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, T t, Continuation<? super MutatorMutex$mutateWith$2> continuation) {
        super(2, continuation);
        this.$priority = mutatePriority;
        this.this$0 = mutatorMutex;
        this.$block = function2;
        this.$receiver = t;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MutatorMutex$mutateWith$2 mutatorMutex$mutateWith$2 = new MutatorMutex$mutateWith$2(this.$priority, this.this$0, this.$block, this.$receiver, continuation);
        mutatorMutex$mutateWith$2.L$0 = obj;
        return mutatorMutex$mutateWith$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((MutatorMutex$mutateWith$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Throwable th;
        Mutex $this$withLock_u24default$iv;
        Object owner$iv;
        Throwable th2;
        Object owner$iv2;
        MutatorMutex mutatorMutex;
        boolean z;
        MutatorMutex$mutateWith$2 mutatorMutex$mutateWith$2;
        Object mutator;
        Mutex $this$withLock_u24default$iv2;
        Object owner$iv3;
        Function2<T, Continuation<? super R>, Object> function2;
        T t;
        boolean z2;
        MutatorMutex$mutateWith$2 mutatorMutex$mutateWith$22;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                mutatorMutex$mutateWith$22 = this;
                MutatePriority mutatePriority = mutatorMutex$mutateWith$22.$priority;
                CoroutineContext.Element element = ((CoroutineScope) mutatorMutex$mutateWith$22.L$0).getCoroutineContext().get(Job.Key);
                Intrinsics.checkNotNull(element);
                MutatorMutex.Mutator mutator2 = new MutatorMutex.Mutator(mutatePriority, (Job) element);
                mutatorMutex$mutateWith$22.this$0.tryMutateOrCancel(mutator2);
                Mutex $this$withLock_u24default$iv3 = mutatorMutex$mutateWith$22.this$0.mutex;
                function2 = mutatorMutex$mutateWith$22.$block;
                t = mutatorMutex$mutateWith$22.$receiver;
                MutatorMutex mutatorMutex2 = mutatorMutex$mutateWith$22.this$0;
                mutatorMutex$mutateWith$22.L$0 = mutator2;
                mutatorMutex$mutateWith$22.L$1 = $this$withLock_u24default$iv3;
                mutatorMutex$mutateWith$22.L$2 = function2;
                mutatorMutex$mutateWith$22.L$3 = t;
                mutatorMutex$mutateWith$22.L$4 = mutatorMutex2;
                mutatorMutex$mutateWith$22.label = 1;
                if ($this$withLock_u24default$iv3.lock((Object) null, mutatorMutex$mutateWith$22) != coroutine_suspended) {
                    mutator = mutator2;
                    z2 = false;
                    $this$withLock_u24default$iv2 = $this$withLock_u24default$iv3;
                    mutatorMutex = mutatorMutex2;
                    owner$iv3 = null;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                mutatorMutex$mutateWith$22 = this;
                z2 = false;
                mutatorMutex = (MutatorMutex) mutatorMutex$mutateWith$22.L$4;
                t = mutatorMutex$mutateWith$22.L$3;
                function2 = (Function2) mutatorMutex$mutateWith$22.L$2;
                owner$iv3 = null;
                $this$withLock_u24default$iv2 = (Mutex) mutatorMutex$mutateWith$22.L$1;
                mutator = (MutatorMutex.Mutator) mutatorMutex$mutateWith$22.L$0;
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                mutatorMutex$mutateWith$2 = this;
                z = false;
                mutatorMutex = (MutatorMutex) mutatorMutex$mutateWith$2.L$2;
                owner$iv = null;
                $this$withLock_u24default$iv = (Mutex) mutatorMutex$mutateWith$2.L$1;
                owner$iv2 = (MutatorMutex.Mutator) mutatorMutex$mutateWith$2.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    MutatorMutex$mutateWith$2 mutatorMutex$mutateWith$23 = mutatorMutex$mutateWith$2;
                    Object obj = $result;
                    break;
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(mutatorMutex.currentMutator, owner$iv2, (Object) null);
                        throw th2;
                    } catch (Throwable th4) {
                        boolean z3 = z;
                        MutatorMutex$mutateWith$2 mutatorMutex$mutateWith$24 = mutatorMutex$mutateWith$2;
                        Object obj2 = $result;
                        th = th4;
                        $this$withLock_u24default$iv.unlock(owner$iv);
                        throw th;
                    }
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            mutatorMutex$mutateWith$22.L$0 = mutator;
            mutatorMutex$mutateWith$22.L$1 = $this$withLock_u24default$iv2;
            mutatorMutex$mutateWith$22.L$2 = mutatorMutex;
            mutatorMutex$mutateWith$22.L$3 = null;
            mutatorMutex$mutateWith$22.L$4 = null;
            mutatorMutex$mutateWith$22.label = 2;
            Object invoke = function2.invoke(t, mutatorMutex$mutateWith$22);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj3 = $result;
            $result = invoke;
            owner$iv = owner$iv3;
            $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
            owner$iv2 = mutator;
            try {
                MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(mutatorMutex.currentMutator, owner$iv2, (Object) null);
                $this$withLock_u24default$iv.unlock(owner$iv);
                return $result;
            } catch (Throwable th5) {
                th = th5;
                $this$withLock_u24default$iv.unlock(owner$iv);
                throw th;
            }
        } catch (Throwable th6) {
            owner$iv = owner$iv3;
            $this$withLock_u24default$iv = $this$withLock_u24default$iv2;
            owner$iv2 = mutator;
            th2 = th6;
            mutatorMutex$mutateWith$2 = mutatorMutex$mutateWith$22;
            z = z2;
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(mutatorMutex.currentMutator, owner$iv2, (Object) null);
            throw th2;
        }
    }
}
