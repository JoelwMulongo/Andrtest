package androidx.compose.material;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SwipeableKt$rememberSwipeableStateFor$1", f = "Swipeable.kt", i = {}, l = {512}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Swipeable.kt */
final class SwipeableKt$rememberSwipeableStateFor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SwipeableState<T> $swipeableState;
    final /* synthetic */ T $value;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableKt$rememberSwipeableStateFor$1(T t, SwipeableState<T> swipeableState, Continuation<? super SwipeableKt$rememberSwipeableStateFor$1> continuation) {
        super(2, continuation);
        this.$value = t;
        this.$swipeableState = swipeableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SwipeableKt$rememberSwipeableStateFor$1(this.$value, this.$swipeableState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SwipeableKt$rememberSwipeableStateFor$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            switch(r1) {
                case 0: goto L_0x0016;
                case 1: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0011:
            r0 = r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x003d
        L_0x0016:
            kotlin.ResultKt.throwOnFailure(r10)
            r1 = r9
            T r2 = r1.$value
            androidx.compose.material.SwipeableState<T> r3 = r1.$swipeableState
            java.lang.Object r3 = r3.getCurrentValue()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 != 0) goto L_0x003e
            androidx.compose.material.SwipeableState<T> r3 = r1.$swipeableState
            T r4 = r1.$value
            r5 = 0
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7 = 2
            r8 = 0
            r2 = 1
            r1.label = r2
            java.lang.Object r2 = androidx.compose.material.SwipeableState.animateTo$default(r3, r4, r5, r6, r7, r8)
            if (r2 != r0) goto L_0x003c
            return r0
        L_0x003c:
            r0 = r1
        L_0x003d:
            r1 = r0
        L_0x003e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableKt$rememberSwipeableStateFor$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
