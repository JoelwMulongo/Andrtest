package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultTransformableState$transform$2", f = "TransformableState.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TransformableState.kt */
final class DefaultTransformableState$transform$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<TransformScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ MutatePriority $transformPriority;
    int label;
    final /* synthetic */ DefaultTransformableState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultTransformableState$transform$2(DefaultTransformableState defaultTransformableState, MutatePriority mutatePriority, Function2<? super TransformScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super DefaultTransformableState$transform$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultTransformableState;
        this.$transformPriority = mutatePriority;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultTransformableState$transform$2(this.this$0, this.$transformPriority, this.$block, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultTransformableState$transform$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultTransformableState$transform$2$1", f = "TransformableState.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.DefaultTransformableState$transform$2$1  reason: invalid class name */
    /* compiled from: TransformableState.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(defaultTransformableState, function2, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
            r6.isTransformingState.setValue(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
            return kotlin.Unit.INSTANCE;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 0
                switch(r1) {
                    case 0: goto L_0x0019;
                    case 1: goto L_0x0012;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x0012:
                r0 = r8
                kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0017 }
                goto L_0x003c
            L_0x0017:
                r1 = move-exception
                goto L_0x0051
            L_0x0019:
                kotlin.ResultKt.throwOnFailure(r9)
                r1 = r8
                java.lang.Object r3 = r1.L$0
                androidx.compose.foundation.gestures.TransformScope r3 = (androidx.compose.foundation.gestures.TransformScope) r3
                androidx.compose.foundation.gestures.DefaultTransformableState r4 = r6
                androidx.compose.runtime.MutableState r4 = r4.isTransformingState
                r5 = 1
                java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                r4.setValue(r6)
                kotlin.jvm.functions.Function2<androidx.compose.foundation.gestures.TransformScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r4 = r7     // Catch:{ all -> 0x004d }
                r1.label = r5     // Catch:{ all -> 0x004d }
                java.lang.Object r4 = r4.invoke(r3, r1)     // Catch:{ all -> 0x004d }
                if (r4 != r0) goto L_0x003b
                return r0
            L_0x003b:
                r0 = r1
            L_0x003c:
                androidx.compose.foundation.gestures.DefaultTransformableState r1 = r6
                androidx.compose.runtime.MutableState r1 = r1.isTransformingState
                java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
                r1.setValue(r2)
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            L_0x004d:
                r0 = move-exception
                r7 = r1
                r1 = r0
                r0 = r7
            L_0x0051:
                androidx.compose.foundation.gestures.DefaultTransformableState r3 = r6
                androidx.compose.runtime.MutableState r3 = r3.isTransformingState
                java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
                r3.setValue(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DefaultTransformableState$transform$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MutatorMutex access$getTransformMutex$p = this.this$0.transformMutex;
                TransformScope access$getTransformScope$p = this.this$0.transformScope;
                MutatePriority mutatePriority = this.$transformPriority;
                final DefaultTransformableState defaultTransformableState = this.this$0;
                final Function2<TransformScope, Continuation<? super Unit>, Object> function2 = this.$block;
                this.label = 1;
                if (access$getTransformMutex$p.mutateWith(access$getTransformScope$p, mutatePriority, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) != coroutine_suspended) {
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
