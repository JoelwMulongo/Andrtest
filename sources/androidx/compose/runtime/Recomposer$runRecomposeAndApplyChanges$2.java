package androidx.compose.runtime;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "parentFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2", f = "Recomposer.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {492, 510}, m = "invokeSuspend", n = {"parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete", "parentFrameClock", "toRecompose", "toInsert", "toApply", "toLateApply", "toComplete"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* compiled from: Recomposer.kt */
final class Recomposer$runRecomposeAndApplyChanges$2 extends SuspendLambda implements Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeAndApplyChanges$2(Recomposer recomposer, Continuation<? super Recomposer$runRecomposeAndApplyChanges$2> continuation) {
        super(3, continuation);
        this.this$0 = recomposer;
    }

    public final Object invoke(CoroutineScope coroutineScope, MonotonicFrameClock monotonicFrameClock, Continuation<? super Unit> continuation) {
        Recomposer$runRecomposeAndApplyChanges$2 recomposer$runRecomposeAndApplyChanges$2 = new Recomposer$runRecomposeAndApplyChanges$2(this.this$0, continuation);
        recomposer$runRecomposeAndApplyChanges$2.L$0 = monotonicFrameClock;
        return recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r20
            int r2 = r1.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x006a;
                case 1: goto L_0x0044;
                case 2: goto L_0x0014;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0014:
            r2 = r20
            r4 = r21
            java.lang.Object r5 = r2.L$5
            java.util.Set r5 = (java.util.Set) r5
            java.lang.Object r6 = r2.L$4
            java.util.Set r6 = (java.util.Set) r6
            java.lang.Object r7 = r2.L$3
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r2.L$2
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r2.L$1
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r2.L$0
            androidx.compose.runtime.MonotonicFrameClock r10 = (androidx.compose.runtime.MonotonicFrameClock) r10
            kotlin.ResultKt.throwOnFailure(r4)
            r17 = r10
            r10 = r5
            r5 = r17
            r18 = r9
            r9 = r6
            r6 = r18
            r19 = r8
            r8 = r7
            r7 = r19
            goto L_0x011f
        L_0x0044:
            r2 = r20
            r4 = r21
            java.lang.Object r5 = r2.L$5
            java.util.Set r5 = (java.util.Set) r5
            java.lang.Object r6 = r2.L$4
            java.util.Set r6 = (java.util.Set) r6
            java.lang.Object r7 = r2.L$3
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r2.L$2
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r2.L$1
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r10 = r2.L$0
            androidx.compose.runtime.MonotonicFrameClock r10 = (androidx.compose.runtime.MonotonicFrameClock) r10
            kotlin.ResultKt.throwOnFailure(r4)
            r11 = r5
            r12 = r6
            r15 = r7
            r14 = r8
            r13 = r9
            r5 = r10
            goto L_0x00bf
        L_0x006a:
            kotlin.ResultKt.throwOnFailure(r21)
            r2 = r20
            r4 = r21
            java.lang.Object r5 = r2.L$0
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.List r8 = (java.util.List) r8
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            java.util.Set r9 = (java.util.Set) r9
            java.util.LinkedHashSet r10 = new java.util.LinkedHashSet
            r10.<init>()
            java.util.Set r10 = (java.util.Set) r10
        L_0x0098:
            androidx.compose.runtime.Recomposer r11 = r2.this$0
            boolean r11 = r11.getShouldKeepRecomposing()
            if (r11 == 0) goto L_0x012a
            androidx.compose.runtime.Recomposer r11 = r2.this$0
            r12 = r2
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r2.L$0 = r5
            r2.L$1 = r6
            r2.L$2 = r7
            r2.L$3 = r8
            r2.L$4 = r9
            r2.L$5 = r10
            r2.label = r3
            java.lang.Object r11 = r11.awaitWorkAvailable(r12)
            if (r11 != r0) goto L_0x00ba
            return r0
        L_0x00ba:
            r13 = r6
            r14 = r7
            r15 = r8
            r12 = r9
            r11 = r10
        L_0x00bf:
            androidx.compose.runtime.Recomposer r6 = r2.this$0
            java.lang.Object r6 = r6.stateLock
            androidx.compose.runtime.Recomposer r7 = r2.this$0
            r8 = 0
            monitor-enter(r6)
            r9 = 0
            boolean r10 = r7.getHasFrameWorkLocked()     // Catch:{ all -> 0x0127 }
            r16 = 0
            if (r10 != 0) goto L_0x00df
            r7.recordComposerModificationsLocked()     // Catch:{ all -> 0x0127 }
            boolean r7 = r7.getHasFrameWorkLocked()     // Catch:{ all -> 0x0127 }
            if (r7 != 0) goto L_0x00e0
            r16 = r3
            goto L_0x00e0
        L_0x00df:
        L_0x00e0:
            monitor-exit(r6)
            if (r16 == 0) goto L_0x00ea
            r10 = r11
            r9 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            goto L_0x0098
        L_0x00ea:
            androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$2 r16 = new androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2$2
            androidx.compose.runtime.Recomposer r7 = r2.this$0
            r6 = r16
            r8 = r13
            r9 = r14
            r10 = r12
            r21 = r11
            r11 = r15
            r3 = r12
            r12 = r21
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r6 = r16
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r7 = r2
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r2.L$0 = r5
            r2.L$1 = r13
            r2.L$2 = r14
            r2.L$3 = r15
            r2.L$4 = r3
            r10 = r21
            r2.L$5 = r10
            r8 = 2
            r2.label = r8
            java.lang.Object r6 = r5.withFrameNanos(r6, r7)
            if (r6 != r0) goto L_0x011b
            return r0
        L_0x011b:
            r9 = r3
            r6 = r13
            r7 = r14
            r8 = r15
        L_0x011f:
            androidx.compose.runtime.Recomposer r3 = r2.this$0
            r3.discardUnusedValues()
            r3 = 1
            goto L_0x0098
        L_0x0127:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L_0x012a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer$runRecomposeAndApplyChanges$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$clearRecompositionState(List<ControlledComposition> toRecompose, List<MovableContentStateReference> toInsert, List<ControlledComposition> toApply, Set<ControlledComposition> toLateApply, Set<ControlledComposition> toComplete) {
        toRecompose.clear();
        toInsert.clear();
        toApply.clear();
        toLateApply.clear();
        toComplete.clear();
    }

    /* access modifiers changed from: private */
    public static final void invokeSuspend$fillToInsert(List<MovableContentStateReference> toInsert, Recomposer this$02) {
        toInsert.clear();
        synchronized (this$02.stateLock) {
            List $this$fastForEach$iv = this$02.compositionValuesAwaitingInsert;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                toInsert.add((MovableContentStateReference) $this$fastForEach$iv.get(index$iv));
            }
            this$02.compositionValuesAwaitingInsert.clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
