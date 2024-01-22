package androidx.activity.compose;

import androidx.activity.FullyDrawnReporter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.activity.compose.ReportDrawnKt$ReportDrawnAfter$1", f = "ReportDrawn.kt", i = {0}, l = {182}, m = "invokeSuspend", n = {"$this$reportWhenComplete$iv"}, s = {"L$0"})
/* compiled from: ReportDrawn.kt */
final class ReportDrawnKt$ReportDrawnAfter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ FullyDrawnReporter $fullyDrawnReporter;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReportDrawnKt$ReportDrawnAfter$1(FullyDrawnReporter fullyDrawnReporter, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super ReportDrawnKt$ReportDrawnAfter$1> continuation) {
        super(2, continuation);
        this.$fullyDrawnReporter = fullyDrawnReporter;
        this.$block = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReportDrawnKt$ReportDrawnAfter$1(this.$fullyDrawnReporter, this.$block, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReportDrawnKt$ReportDrawnAfter$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r2.removeReporter();
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            switch(r1) {
                case 0: goto L_0x001d;
                case 1: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0011:
            r0 = r7
            r1 = 0
            java.lang.Object r2 = r0.L$0
            androidx.activity.FullyDrawnReporter r2 = (androidx.activity.FullyDrawnReporter) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x001b }
            goto L_0x0042
        L_0x001b:
            r3 = move-exception
            goto L_0x004d
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r7
            androidx.activity.FullyDrawnReporter r2 = r1.$fullyDrawnReporter
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r3 = r1.$block
            r4 = 0
            r2.addReporter()
            boolean r5 = r2.isFullyDrawnReported()
            if (r5 == 0) goto L_0x0030
            goto L_0x0047
        L_0x0030:
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ all -> 0x004a }
            r1.L$0 = r2     // Catch:{ all -> 0x004a }
            r6 = 1
            r1.label = r6     // Catch:{ all -> 0x004a }
            java.lang.Object r5 = r3.invoke(r5)     // Catch:{ all -> 0x004a }
            if (r5 != r0) goto L_0x0040
            return r0
        L_0x0040:
            r0 = r1
            r1 = r4
        L_0x0042:
            r2.removeReporter()
            r1 = r0
        L_0x0047:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x004a:
            r3 = move-exception
            r0 = r1
            r1 = r4
        L_0x004d:
            r2.removeReporter()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.compose.ReportDrawnKt$ReportDrawnAfter$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
