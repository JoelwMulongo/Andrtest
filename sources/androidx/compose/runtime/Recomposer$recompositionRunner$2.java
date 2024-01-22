package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", f = "Recomposer.kt", i = {0, 0}, l = {898}, m = "invokeSuspend", n = {"callingJob", "unregisterApplyObserver"}, s = {"L$0", "L$1"})
/* compiled from: Recomposer.kt */
final class Recomposer$recompositionRunner$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ MonotonicFrameClock $parentFrameClock;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$recompositionRunner$2(Recomposer recomposer, Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super Recomposer$recompositionRunner$2> continuation) {
        super(2, continuation);
        this.this$0 = recomposer;
        this.$block = function3;
        this.$parentFrameClock = monotonicFrameClock;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Recomposer$recompositionRunner$2 recomposer$recompositionRunner$2 = new Recomposer$recompositionRunner$2(this.this$0, this.$block, this.$parentFrameClock, continuation);
        recomposer$recompositionRunner$2.L$0 = obj;
        return recomposer$recompositionRunner$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Recomposer$recompositionRunner$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: androidx.compose.runtime.snapshots.ObserverHandle} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: kotlinx.coroutines.Job} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r17
            int r2 = r1.label
            r3 = 0
            switch(r2) {
                case 0: goto L_0x0027;
                case 1: goto L_0x0014;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0014:
            r2 = r17
            r4 = r18
            java.lang.Object r0 = r2.L$1
            r5 = r0
            androidx.compose.runtime.snapshots.ObserverHandle r5 = (androidx.compose.runtime.snapshots.ObserverHandle) r5
            java.lang.Object r0 = r2.L$0
            r6 = r0
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6
            kotlin.ResultKt.throwOnFailure(r4)     // Catch:{ all -> 0x00d3 }
            goto L_0x00a3
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r18)
            r2 = r17
            r4 = r18
            java.lang.Object r5 = r2.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            kotlin.coroutines.CoroutineContext r6 = r5.getCoroutineContext()
            kotlinx.coroutines.Job r6 = kotlinx.coroutines.JobKt.getJob(r6)
            androidx.compose.runtime.Recomposer r5 = r2.this$0
            r5.registerRunnerJob(r6)
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.Companion
            androidx.compose.runtime.Recomposer$recompositionRunner$2$unregisterApplyObserver$1 r7 = new androidx.compose.runtime.Recomposer$recompositionRunner$2$unregisterApplyObserver$1
            androidx.compose.runtime.Recomposer r8 = r2.this$0
            r7.<init>(r8)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            androidx.compose.runtime.snapshots.ObserverHandle r5 = r5.registerApplyObserver(r7)
            androidx.compose.runtime.Recomposer$Companion r7 = androidx.compose.runtime.Recomposer.Companion
            androidx.compose.runtime.Recomposer r8 = r2.this$0
            androidx.compose.runtime.Recomposer$RecomposerInfoImpl r8 = r8.recomposerInfo
            r7.addRunning(r8)
            androidx.compose.runtime.Recomposer r7 = r2.this$0     // Catch:{ all -> 0x00d3 }
            java.lang.Object r7 = r7.stateLock     // Catch:{ all -> 0x00d3 }
            androidx.compose.runtime.Recomposer r8 = r2.this$0     // Catch:{ all -> 0x00d3 }
            r9 = 0
            monitor-enter(r7)     // Catch:{ all -> 0x00d3 }
            r10 = 0
            java.util.List r8 = r8.knownCompositions     // Catch:{ all -> 0x00d0 }
            r11 = 0
            r12 = 0
            int r13 = r8.size()     // Catch:{ all -> 0x00d0 }
        L_0x0070:
            if (r12 >= r13) goto L_0x0082
            java.lang.Object r14 = r8.get(r12)     // Catch:{ all -> 0x00d0 }
            r15 = r14
            androidx.compose.runtime.ControlledComposition r15 = (androidx.compose.runtime.ControlledComposition) r15     // Catch:{ all -> 0x00d0 }
            r16 = 0
            r15.invalidateAll()     // Catch:{ all -> 0x00d0 }
            int r12 = r12 + 1
            goto L_0x0070
        L_0x0082:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00d0 }
            monitor-exit(r7)     // Catch:{ all -> 0x00d3 }
            androidx.compose.runtime.Recomposer$recompositionRunner$2$2 r7 = new androidx.compose.runtime.Recomposer$recompositionRunner$2$2     // Catch:{ all -> 0x00d3 }
            kotlin.jvm.functions.Function3<kotlinx.coroutines.CoroutineScope, androidx.compose.runtime.MonotonicFrameClock, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r8 = r2.$block     // Catch:{ all -> 0x00d3 }
            androidx.compose.runtime.MonotonicFrameClock r9 = r2.$parentFrameClock     // Catch:{ all -> 0x00d3 }
            r7.<init>(r8, r9, r3)     // Catch:{ all -> 0x00d3 }
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch:{ all -> 0x00d3 }
            r8 = r2
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch:{ all -> 0x00d3 }
            r2.L$0 = r6     // Catch:{ all -> 0x00d3 }
            r2.L$1 = r5     // Catch:{ all -> 0x00d3 }
            r9 = 1
            r2.label = r9     // Catch:{ all -> 0x00d3 }
            java.lang.Object r7 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r7, r8)     // Catch:{ all -> 0x00d3 }
            if (r7 != r0) goto L_0x00a3
            return r0
        L_0x00a3:
            r5.dispose()
            androidx.compose.runtime.Recomposer r0 = r2.this$0
            java.lang.Object r5 = r0.stateLock
            androidx.compose.runtime.Recomposer r0 = r2.this$0
            r7 = 0
            monitor-enter(r5)
            r8 = 0
            kotlinx.coroutines.Job r9 = r0.runnerJob     // Catch:{ all -> 0x00cd }
            if (r9 != r6) goto L_0x00ba
            r0.runnerJob = r3     // Catch:{ all -> 0x00cd }
        L_0x00ba:
            kotlinx.coroutines.CancellableContinuation unused = r0.deriveStateLocked()     // Catch:{ all -> 0x00cd }
            monitor-exit(r5)
            androidx.compose.runtime.Recomposer$Companion r0 = androidx.compose.runtime.Recomposer.Companion
            androidx.compose.runtime.Recomposer r3 = r2.this$0
            androidx.compose.runtime.Recomposer$RecomposerInfoImpl r3 = r3.recomposerInfo
            r0.removeRunning(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00cd:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x00d0:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00d3 }
            throw r0     // Catch:{ all -> 0x00d3 }
        L_0x00d3:
            r0 = move-exception
            r5.dispose()
            androidx.compose.runtime.Recomposer r5 = r2.this$0
            java.lang.Object r5 = r5.stateLock
            androidx.compose.runtime.Recomposer r7 = r2.this$0
            r8 = 0
            monitor-enter(r5)
            r9 = 0
            kotlinx.coroutines.Job r10 = r7.runnerJob     // Catch:{ all -> 0x00fb }
            if (r10 != r6) goto L_0x00eb
            r7.runnerJob = r3     // Catch:{ all -> 0x00fb }
        L_0x00eb:
            kotlinx.coroutines.CancellableContinuation unused = r7.deriveStateLocked()     // Catch:{ all -> 0x00fb }
            monitor-exit(r5)
            androidx.compose.runtime.Recomposer$Companion r3 = androidx.compose.runtime.Recomposer.Companion
            androidx.compose.runtime.Recomposer r5 = r2.this$0
            androidx.compose.runtime.Recomposer$RecomposerInfoImpl r5 = r5.recomposerInfo
            r3.removeRunning(r5)
            throw r0
        L_0x00fb:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$recompositionRunner$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
