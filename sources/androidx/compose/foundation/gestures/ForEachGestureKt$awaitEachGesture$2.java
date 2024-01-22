package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2", f = "ForEachGesture.kt", i = {0, 1, 2}, l = {104, 107, 112}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "$this$awaitPointerEventScope"}, s = {"L$0", "L$0", "L$0"})
/* compiled from: ForEachGesture.kt */
final class ForEachGestureKt$awaitEachGesture$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ CoroutineContext $currentContext;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ForEachGestureKt$awaitEachGesture$2(CoroutineContext coroutineContext, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ForEachGestureKt$awaitEachGesture$2> continuation) {
        super(2, continuation);
        this.$currentContext = coroutineContext;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ForEachGestureKt$awaitEachGesture$2 forEachGestureKt$awaitEachGesture$2 = new ForEachGestureKt$awaitEachGesture$2(this.$currentContext, this.$block, continuation);
        forEachGestureKt$awaitEachGesture$2.L$0 = obj;
        return forEachGestureKt$awaitEachGesture$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((ForEachGestureKt$awaitEachGesture$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
        r1.L$0 = r2;
        r1.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
        if (androidx.compose.foundation.gestures.ForEachGestureKt.awaitAllPointersUp(r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r1) != r0) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005b, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f A[SYNTHETIC, Splitter:B:15:0x003f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            switch(r1) {
                case 0: goto L_0x002e;
                case 1: goto L_0x0023;
                case 2: goto L_0x001a;
                case 3: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0011:
            r1 = r5
            java.lang.Object r2 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0074
        L_0x001a:
            r1 = r5
            java.lang.Object r2 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ CancellationException -> 0x002c }
            goto L_0x005c
        L_0x0023:
            r1 = r5
            java.lang.Object r2 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ CancellationException -> 0x002c }
            goto L_0x004d
        L_0x002c:
            r3 = move-exception
            goto L_0x005d
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r6)
            r1 = r5
            java.lang.Object r2 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
        L_0x0036:
            kotlin.coroutines.CoroutineContext r3 = r1.$currentContext
            boolean r3 = kotlinx.coroutines.JobKt.isActive(r3)
            if (r3 == 0) goto L_0x0076
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r3 = r1.$block     // Catch:{ CancellationException -> 0x002c }
            r1.L$0 = r2     // Catch:{ CancellationException -> 0x002c }
            r4 = 1
            r1.label = r4     // Catch:{ CancellationException -> 0x002c }
            java.lang.Object r3 = r3.invoke(r2, r1)     // Catch:{ CancellationException -> 0x002c }
            if (r3 != r0) goto L_0x004d
            return r0
        L_0x004d:
            r3 = r1
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch:{ CancellationException -> 0x002c }
            r1.L$0 = r2     // Catch:{ CancellationException -> 0x002c }
            r4 = 2
            r1.label = r4     // Catch:{ CancellationException -> 0x002c }
            java.lang.Object r3 = androidx.compose.foundation.gestures.ForEachGestureKt.awaitAllPointersUp((androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r3)     // Catch:{ CancellationException -> 0x002c }
            if (r3 != r0) goto L_0x005c
            return r0
        L_0x005c:
            goto L_0x0036
        L_0x005d:
            kotlin.coroutines.CoroutineContext r4 = r1.$currentContext
            boolean r4 = kotlinx.coroutines.JobKt.isActive(r4)
            if (r4 == 0) goto L_0x0075
            r3 = r1
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r1.L$0 = r2
            r4 = 3
            r1.label = r4
            java.lang.Object r3 = androidx.compose.foundation.gestures.ForEachGestureKt.awaitAllPointersUp((androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r3)
            if (r3 != r0) goto L_0x0074
            return r0
        L_0x0074:
            goto L_0x0036
        L_0x0075:
            throw r3
        L_0x0076:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
