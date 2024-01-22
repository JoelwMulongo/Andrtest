package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 1}, l = {746, 766, 767}, m = "invokeSuspend", n = {"recomposeCoroutineScope", "frameSignal", "frameLoop", "frameLoop"}, s = {"L$0", "L$1", "L$2", "L$0"})
/* compiled from: Recomposer.kt */
final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $recomposeCoroutineContext;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(CoroutineContext coroutineContext, Recomposer recomposer, Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.$recomposeCoroutineContext = coroutineContext;
        this.this$0 = recomposer;
    }

    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeConcurrentlyAndApplyChanges$2 recomposer$runRecomposeConcurrentlyAndApplyChanges$2 = new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2(this.$recomposeCoroutineContext, this.this$0, continuation);
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$0 = coroutineScope;
        recomposer$runRecomposeConcurrentlyAndApplyChanges$2.L$1 = monotonicFrameClock;
        return recomposer$runRecomposeConcurrentlyAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00b2, code lost:
        if (r2.this$0.getShouldKeepRecomposing() == false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00b4, code lost:
        r2.L$0 = r8;
        r2.L$1 = r7;
        r2.L$2 = r5;
        r2.label = r4 ? 1 : 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00c5, code lost:
        if (r2.this$0.awaitWorkAvailable(r2) != r0) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00c7, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c8, code lost:
        r14 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c9, code lost:
        r15 = r2.this$0.stateLock;
        r13 = r2.this$0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d4, code lost:
        monitor-enter(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d5, code lost:
        r12 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r8 = r12.snapshotInvalidations;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e6, code lost:
        if ((r8.isEmpty() ^ r4) == false) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e8, code lost:
        r9 = r12.knownCompositions;
        r11 = 0;
        r3 = r9.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f3, code lost:
        if (r11 >= r3) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00f5, code lost:
        ((androidx.compose.runtime.ControlledComposition) r9.get(r11)).recordModificationsOf(r8);
        r11 = r11 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x010c, code lost:
        r12.snapshotInvalidations = new java.util.LinkedHashSet();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0117, code lost:
        r3 = r12.compositionInvalidations;
        r11 = r3.size();
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0123, code lost:
        if (r10 >= r11) goto L_0x0174;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0125, code lost:
        r9 = (androidx.compose.runtime.ControlledComposition) r3.get(r10);
        r13.concurrentCompositionsOutstanding = r13.concurrentCompositionsOutstanding + 1;
        r26 = r9;
        kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r14, androidx.compose.runtime.CompositionKt.getRecomposeCoroutineContext(r9), (kotlinx.coroutines.CoroutineStart) null, new androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1(r13, r9, (kotlin.coroutines.Continuation<? super androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1>) null), 2, (java.lang.Object) null);
        r10 = r10 + 1;
        r12 = r12;
        r11 = r11;
        r13 = r13;
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0174, code lost:
        r29 = r0;
        r22 = r10;
        r0 = r12;
        r24 = r13;
        r0.compositionInvalidations.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0189, code lost:
        if (r0.deriveStateLocked() != null) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0190, code lost:
        if (r24.getHasConcurrentFrameWorkLocked() == false) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0192, code lost:
        r0 = r7.requestFrameLocked();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0197, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0199, code lost:
        monitor-exit(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x019b, code lost:
        if (r0 == null) goto L_0x01a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x019d, code lost:
        r3 = kotlin.Result.Companion;
        r0.resumeWith(kotlin.Result.m6273constructorimpl(kotlin.Unit.INSTANCE));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01a8, code lost:
        r0 = r29;
        r8 = r14;
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01bb, code lost:
        throw new java.lang.IllegalStateException("called outside of runRecomposeAndApplyChanges".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01bf, code lost:
        r2.L$0 = r5;
        r7 = null;
        r2.L$1 = null;
        r2.L$2 = null;
        r2.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01d8, code lost:
        if (kotlinx.coroutines.JobKt.cancelAndJoin(kotlinx.coroutines.JobKt.getJob(r8.getCoroutineContext()), r2) != r0) goto L_0x01db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01da, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01db, code lost:
        r4 = r6;
        r27 = r2;
        r2 = r0;
        r0 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01e1, code lost:
        r0.L$0 = r7;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01ed, code lost:
        if (kotlinx.coroutines.JobKt.cancelAndJoin(r5, r0) != r2) goto L_0x01f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01ef, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01f0, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01f3, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r29) {
        /*
            r28 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r28
            int r2 = r1.label
            r3 = 0
            r4 = 1
            switch(r2) {
                case 0: goto L_0x004c;
                case 1: goto L_0x0031;
                case 2: goto L_0x001e;
                case 3: goto L_0x0015;
                default: goto L_0x000d;
            }
        L_0x000d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0015:
            r0 = r28
            r2 = r29
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x01f1
        L_0x001e:
            r2 = r28
            r4 = r29
            java.lang.Object r5 = r2.L$0
            kotlinx.coroutines.Job r5 = (kotlinx.coroutines.Job) r5
            kotlin.ResultKt.throwOnFailure(r4)
            r7 = r3
            r27 = r2
            r2 = r0
            r0 = r27
            goto L_0x01e1
        L_0x0031:
            r2 = r28
            r5 = r29
            java.lang.Object r6 = r2.L$2
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6
            java.lang.Object r7 = r2.L$1
            androidx.compose.runtime.ProduceFrameSignal r7 = (androidx.compose.runtime.ProduceFrameSignal) r7
            java.lang.Object r8 = r2.L$0
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            kotlin.ResultKt.throwOnFailure(r5)
            r14 = r8
            r27 = r6
            r6 = r5
            r5 = r27
            goto L_0x00c9
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r29)
            r2 = r28
            r5 = r29
            java.lang.Object r6 = r2.L$0
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            java.lang.Object r7 = r2.L$1
            r13 = r7
            androidx.compose.runtime.MonotonicFrameClock r13 = (androidx.compose.runtime.MonotonicFrameClock) r13
            kotlin.coroutines.CoroutineContext r7 = r2.$recomposeCoroutineContext
            kotlinx.coroutines.Job$Key r8 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r8 = (kotlin.coroutines.CoroutineContext.Key) r8
            kotlin.coroutines.CoroutineContext$Element r7 = r7.get(r8)
            if (r7 != 0) goto L_0x006a
            r7 = r4
            goto L_0x006b
        L_0x006a:
            r7 = 0
        L_0x006b:
            kotlin.coroutines.CoroutineContext r8 = r2.$recomposeCoroutineContext
            if (r7 == 0) goto L_0x01f4
            kotlin.coroutines.CoroutineContext r7 = r6.getCoroutineContext()
            kotlin.coroutines.CoroutineContext r8 = r2.$recomposeCoroutineContext
            kotlin.coroutines.CoroutineContext r7 = r7.plus(r8)
            kotlin.coroutines.CoroutineContext r8 = r6.getCoroutineContext()
            kotlinx.coroutines.Job r8 = kotlinx.coroutines.JobKt.getJob(r8)
            kotlinx.coroutines.CompletableJob r8 = kotlinx.coroutines.JobKt.Job((kotlinx.coroutines.Job) r8)
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            kotlin.coroutines.CoroutineContext r7 = r7.plus(r8)
            kotlinx.coroutines.CoroutineScope r14 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r7)
            androidx.compose.runtime.ProduceFrameSignal r7 = new androidx.compose.runtime.ProduceFrameSignal
            r7.<init>()
            r15 = r7
            r8 = 0
            r9 = 0
            androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1 r7 = new androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1
            androidx.compose.runtime.Recomposer r10 = r2.this$0
            r7.<init>(r10, r13, r15, r3)
            r10 = r7
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r11 = 3
            r12 = 0
            r7 = r6
            kotlinx.coroutines.Job r7 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r7, r8, r9, r10, r11, r12)
            r6 = r5
            r5 = r7
            r8 = r14
            r7 = r15
        L_0x00ac:
            androidx.compose.runtime.Recomposer r9 = r2.this$0
            boolean r9 = r9.getShouldKeepRecomposing()
            if (r9 == 0) goto L_0x01bf
            androidx.compose.runtime.Recomposer r9 = r2.this$0
            r10 = r2
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r2.L$0 = r8
            r2.L$1 = r7
            r2.L$2 = r5
            r2.label = r4
            java.lang.Object r9 = r9.awaitWorkAvailable(r10)
            if (r9 != r0) goto L_0x00c8
            return r0
        L_0x00c8:
            r14 = r8
        L_0x00c9:
            androidx.compose.runtime.Recomposer r8 = r2.this$0
            java.lang.Object r15 = r8.stateLock
            androidx.compose.runtime.Recomposer r13 = r2.this$0
            r16 = 0
            monitor-enter(r15)
            r17 = 0
            r12 = r13
            r18 = 0
            java.util.Set r8 = r12.snapshotInvalidations     // Catch:{ all -> 0x01bc }
            r9 = r8
            java.util.Collection r9 = (java.util.Collection) r9     // Catch:{ all -> 0x01bc }
            boolean r9 = r9.isEmpty()     // Catch:{ all -> 0x01bc }
            r9 = r9 ^ r4
            if (r9 == 0) goto L_0x0117
            java.util.List r9 = r12.knownCompositions     // Catch:{ all -> 0x01bc }
            r10 = 0
            r11 = 0
            int r3 = r9.size()     // Catch:{ all -> 0x01bc }
        L_0x00f3:
            if (r11 >= r3) goto L_0x010c
            java.lang.Object r19 = r9.get(r11)     // Catch:{ all -> 0x01bc }
            r20 = r19
            androidx.compose.runtime.ControlledComposition r20 = (androidx.compose.runtime.ControlledComposition) r20     // Catch:{ all -> 0x01bc }
            r29 = r20
            r20 = 0
            r4 = r29
            r4.recordModificationsOf(r8)     // Catch:{ all -> 0x01bc }
            int r11 = r11 + 1
            r4 = 1
            goto L_0x00f3
        L_0x010c:
            java.util.LinkedHashSet r3 = new java.util.LinkedHashSet     // Catch:{ all -> 0x01bc }
            r3.<init>()     // Catch:{ all -> 0x01bc }
            java.util.Set r3 = (java.util.Set) r3     // Catch:{ all -> 0x01bc }
            r12.snapshotInvalidations = r3     // Catch:{ all -> 0x01bc }
        L_0x0117:
            java.util.List r3 = r12.compositionInvalidations     // Catch:{ all -> 0x01bc }
            r4 = 0
            r8 = 0
            int r11 = r3.size()     // Catch:{ all -> 0x01bc }
            r10 = r8
        L_0x0123:
            if (r10 >= r11) goto L_0x0174
            java.lang.Object r8 = r3.get(r10)     // Catch:{ all -> 0x01bc }
            r19 = r8
            r8 = r19
            androidx.compose.runtime.ControlledComposition r8 = (androidx.compose.runtime.ControlledComposition) r8     // Catch:{ all -> 0x01bc }
            r9 = r8
            r20 = 0
            int r8 = r13.concurrentCompositionsOutstanding     // Catch:{ all -> 0x01bc }
            r21 = 1
            int r8 = r8 + 1
            r13.concurrentCompositionsOutstanding = r8     // Catch:{ all -> 0x01bc }
            kotlin.coroutines.CoroutineContext r22 = androidx.compose.runtime.CompositionKt.getRecomposeCoroutineContext(r9)     // Catch:{ all -> 0x01bc }
            r23 = 0
            androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1 r8 = new androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$1$1     // Catch:{ all -> 0x01bc }
            r29 = r0
            r0 = 0
            r8.<init>(r13, r9, r0)     // Catch:{ all -> 0x01bc }
            r0 = r8
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0     // Catch:{ all -> 0x01bc }
            r24 = 2
            r25 = 0
            r8 = r14
            r26 = r9
            r9 = r22
            r22 = r10
            r10 = r23
            r23 = r11
            r11 = r0
            r0 = r12
            r12 = r24
            r24 = r13
            r13 = r25
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x01bc }
            int r10 = r22 + 1
            r12 = r0
            r11 = r23
            r13 = r24
            r0 = r29
            goto L_0x0123
        L_0x0174:
            r29 = r0
            r22 = r10
            r0 = r12
            r24 = r13
            r21 = 1
            java.util.List r3 = r0.compositionInvalidations     // Catch:{ all -> 0x01bc }
            r3.clear()     // Catch:{ all -> 0x01bc }
            kotlinx.coroutines.CancellableContinuation r3 = r0.deriveStateLocked()     // Catch:{ all -> 0x01bc }
            if (r3 != 0) goto L_0x01b0
            boolean r0 = r24.getHasConcurrentFrameWorkLocked()     // Catch:{ all -> 0x01bc }
            if (r0 == 0) goto L_0x0197
            kotlin.coroutines.Continuation r0 = r7.requestFrameLocked()     // Catch:{ all -> 0x01bc }
            goto L_0x0198
        L_0x0197:
            r0 = 0
        L_0x0198:
            monitor-exit(r15)
            if (r0 == 0) goto L_0x01a8
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            java.lang.Object r3 = kotlin.Result.m6273constructorimpl(r3)
            r0.resumeWith(r3)
        L_0x01a8:
            r0 = r29
            r8 = r14
            r4 = r21
            r3 = 0
            goto L_0x00ac
        L_0x01b0:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ all -> 0x01bc }
            java.lang.String r4 = "called outside of runRecomposeAndApplyChanges"
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01bc }
            r3.<init>(r4)     // Catch:{ all -> 0x01bc }
            throw r3     // Catch:{ all -> 0x01bc }
        L_0x01bc:
            r0 = move-exception
            monitor-exit(r15)
            throw r0
        L_0x01bf:
            kotlin.coroutines.CoroutineContext r3 = r8.getCoroutineContext()
            kotlinx.coroutines.Job r3 = kotlinx.coroutines.JobKt.getJob(r3)
            r4 = r2
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r2.L$0 = r5
            r7 = 0
            r2.L$1 = r7
            r2.L$2 = r7
            r9 = 2
            r2.label = r9
            java.lang.Object r3 = kotlinx.coroutines.JobKt.cancelAndJoin(r3, r4)
            if (r3 != r0) goto L_0x01db
            return r0
        L_0x01db:
            r4 = r6
            r27 = r2
            r2 = r0
            r0 = r27
        L_0x01e1:
            r3 = r0
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r0.L$0 = r7
            r6 = 3
            r0.label = r6
            java.lang.Object r3 = kotlinx.coroutines.JobKt.cancelAndJoin(r5, r3)
            if (r3 != r2) goto L_0x01f0
            return r2
        L_0x01f0:
            r2 = r4
        L_0x01f1:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x01f4:
            r0 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "recomposeCoroutineContext may not contain a Job; found "
            java.lang.StringBuilder r3 = r3.append(r4)
            kotlinx.coroutines.Job$Key r4 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r4 = (kotlin.coroutines.CoroutineContext.Key) r4
            kotlin.coroutines.CoroutineContext$Element r4 = r8.get(r4)
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r0 = r3.toString()
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
