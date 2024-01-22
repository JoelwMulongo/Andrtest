package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1", f = "SnapshotFlow.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {134, 138, 160}, m = "invokeSuspend", n = {"$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue", "found", "$this$flow", "readSet", "readObserver", "appliedChanges", "unregisterApplyObserver", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
/* compiled from: SnapshotFlow.kt */
final class SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T> $block;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(Function0<? extends T> function0, Continuation<? super SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1> continuation) {
        super(2, continuation);
        this.$block = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1 snapshotStateKt__SnapshotFlowKt$snapshotFlow$1 = new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(this.$block, continuation);
        snapshotStateKt__SnapshotFlowKt$snapshotFlow$1.L$0 = obj;
        return snapshotStateKt__SnapshotFlowKt$snapshotFlow$1;
    }

    public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return ((SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e5, code lost:
        r11 = 0;
        r2.L$0 = r10;
        r2.L$1 = r9;
        r2.L$2 = r8;
        r2.L$3 = r7;
        r2.L$4 = r6;
        r2.L$5 = r5;
        r2.I$0 = 0;
        r2.label = 2;
        r12 = r7.receive(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00fe, code lost:
        if (r12 != r0) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0100, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0101, code lost:
        r17 = r5;
        r5 = r4;
        r4 = r12;
        r12 = r10;
        r10 = r9;
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        r4 = (java.util.Set) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x010f, code lost:
        if (r11 != 0) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0115, code lost:
        if (androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.intersects$SnapshotStateKt__SnapshotFlowKt(r10, r4) == false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0118, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011a, code lost:
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011b, code lost:
        r11 = r4;
        r4 = (java.util.Set) kotlinx.coroutines.channels.ChannelResult.m235getOrNullimpl(r8.m250tryReceivePtdJZtk());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0126, code lost:
        if (r4 != null) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0128, code lost:
        if (r11 == 0) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x012a, code lost:
        r10.clear();
        r4 = androidx.compose.runtime.snapshots.Snapshot.Companion.takeSnapshot(r9);
        r11 = r2.$block;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0135, code lost:
        r14 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x013d, code lost:
        r19 = r14.makeCurrent();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r11 = r11.invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r14.restoreCurrent(r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        r4.dispose();
        r3 = r4;
        r3 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0155, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r3, r6) != false) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0157, code lost:
        r4 = r3;
        r2.L$0 = r12;
        r2.L$1 = r10;
        r2.L$2 = r9;
        r2.L$3 = r8;
        r2.L$4 = r7;
        r2.L$5 = r4;
        r2.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x016e, code lost:
        if (r12.emit(r3, r2) != r0) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0170, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0171, code lost:
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r12;
        r17 = r5;
        r5 = r4;
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x017b, code lost:
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x017e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x017f, code lost:
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r14.restoreCurrent(r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0185, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0186, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        r4.dispose();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x018a, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x018b, code lost:
        r4 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r12;
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0195, code lost:
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0198, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0199, code lost:
        r4 = r5;
        r6 = r7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r18
            int r2 = r1.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x0079;
                case 1: goto L_0x005b;
                case 2: goto L_0x0033;
                case 3: goto L_0x0014;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0014:
            r2 = r18
            r4 = r19
            java.lang.Object r5 = r2.L$5
            java.lang.Object r6 = r2.L$4
            androidx.compose.runtime.snapshots.ObserverHandle r6 = (androidx.compose.runtime.snapshots.ObserverHandle) r6
            java.lang.Object r7 = r2.L$3
            kotlinx.coroutines.channels.Channel r7 = (kotlinx.coroutines.channels.Channel) r7
            java.lang.Object r8 = r2.L$2
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r9 = r2.L$1
            java.util.Set r9 = (java.util.Set) r9
            java.lang.Object r10 = r2.L$0
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            kotlin.ResultKt.throwOnFailure(r4)     // Catch:{ all -> 0x01a7 }
            goto L_0x017b
        L_0x0033:
            r2 = r18
            r4 = r19
            int r5 = r2.I$0
            java.lang.Object r6 = r2.L$5
            java.lang.Object r7 = r2.L$4
            androidx.compose.runtime.snapshots.ObserverHandle r7 = (androidx.compose.runtime.snapshots.ObserverHandle) r7
            java.lang.Object r8 = r2.L$3
            kotlinx.coroutines.channels.Channel r8 = (kotlinx.coroutines.channels.Channel) r8
            java.lang.Object r9 = r2.L$2
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r10 = r2.L$1
            java.util.Set r10 = (java.util.Set) r10
            java.lang.Object r11 = r2.L$0
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            kotlin.ResultKt.throwOnFailure(r4)     // Catch:{ all -> 0x0057 }
            r12 = r11
            r11 = r5
            r5 = r4
            goto L_0x010c
        L_0x0057:
            r0 = move-exception
            r6 = r7
            goto L_0x01a8
        L_0x005b:
            r2 = r18
            r4 = r19
            java.lang.Object r5 = r2.L$5
            java.lang.Object r6 = r2.L$4
            androidx.compose.runtime.snapshots.ObserverHandle r6 = (androidx.compose.runtime.snapshots.ObserverHandle) r6
            java.lang.Object r7 = r2.L$3
            kotlinx.coroutines.channels.Channel r7 = (kotlinx.coroutines.channels.Channel) r7
            java.lang.Object r8 = r2.L$2
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r9 = r2.L$1
            java.util.Set r9 = (java.util.Set) r9
            java.lang.Object r10 = r2.L$0
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            kotlin.ResultKt.throwOnFailure(r4)     // Catch:{ all -> 0x01a7 }
            goto L_0x00e4
        L_0x0079:
            kotlin.ResultKt.throwOnFailure(r19)
            r2 = r18
            r4 = r19
            java.lang.Object r5 = r2.L$0
            r10 = r5
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            java.util.LinkedHashSet r5 = new java.util.LinkedHashSet
            r5.<init>()
            r9 = r5
            java.util.Set r9 = (java.util.Set) r9
            androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1 r5 = new androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$readObserver$1
            r5.<init>(r9)
            r8 = r5
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r5 = 2147483647(0x7fffffff, float:NaN)
            r6 = 6
            r7 = 0
            kotlinx.coroutines.channels.Channel r7 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r5, r7, r7, r6, r7)
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.Companion
            androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1 r6 = new androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1$unregisterApplyObserver$1
            r6.<init>(r7)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            androidx.compose.runtime.snapshots.ObserverHandle r6 = r5.registerApplyObserver(r6)
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x01a7 }
            androidx.compose.runtime.snapshots.Snapshot r5 = r5.takeSnapshot(r8)     // Catch:{ all -> 0x01a7 }
            kotlin.jvm.functions.Function0<T> r11 = r2.$block     // Catch:{ all -> 0x01a7 }
            r12 = 0
            r13 = r5
            r14 = 0
            androidx.compose.runtime.snapshots.Snapshot r15 = r13.makeCurrent()     // Catch:{ all -> 0x01a2 }
            java.lang.Object r11 = r11.invoke()     // Catch:{ all -> 0x019c }
            r13.restoreCurrent(r15)     // Catch:{ all -> 0x01a2 }
            r5.dispose()     // Catch:{ all -> 0x01a7 }
            r5 = r11
            r11 = r2
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch:{ all -> 0x01a7 }
            r2.L$0 = r10     // Catch:{ all -> 0x01a7 }
            r2.L$1 = r9     // Catch:{ all -> 0x01a7 }
            r2.L$2 = r8     // Catch:{ all -> 0x01a7 }
            r2.L$3 = r7     // Catch:{ all -> 0x01a7 }
            r2.L$4 = r6     // Catch:{ all -> 0x01a7 }
            r2.L$5 = r5     // Catch:{ all -> 0x01a7 }
            r2.label = r3     // Catch:{ all -> 0x01a7 }
            java.lang.Object r11 = r10.emit(r5, r11)     // Catch:{ all -> 0x01a7 }
            if (r11 != r0) goto L_0x00e4
            return r0
        L_0x00e4:
        L_0x00e5:
            r11 = 0
            r12 = r2
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12     // Catch:{ all -> 0x01a7 }
            r2.L$0 = r10     // Catch:{ all -> 0x01a7 }
            r2.L$1 = r9     // Catch:{ all -> 0x01a7 }
            r2.L$2 = r8     // Catch:{ all -> 0x01a7 }
            r2.L$3 = r7     // Catch:{ all -> 0x01a7 }
            r2.L$4 = r6     // Catch:{ all -> 0x01a7 }
            r2.L$5 = r5     // Catch:{ all -> 0x01a7 }
            r2.I$0 = r11     // Catch:{ all -> 0x01a7 }
            r13 = 2
            r2.label = r13     // Catch:{ all -> 0x01a7 }
            java.lang.Object r12 = r7.receive(r12)     // Catch:{ all -> 0x01a7 }
            if (r12 != r0) goto L_0x0101
            return r0
        L_0x0101:
            r17 = r5
            r5 = r4
            r4 = r12
            r12 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r17
        L_0x010c:
            java.util.Set r4 = (java.util.Set) r4     // Catch:{ all -> 0x0198 }
        L_0x010e:
            if (r11 != 0) goto L_0x011a
            boolean r13 = androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.intersects$SnapshotStateKt__SnapshotFlowKt(r10, r4)     // Catch:{ all -> 0x0198 }
            if (r13 == 0) goto L_0x0118
            goto L_0x011a
        L_0x0118:
            r4 = 0
            goto L_0x011b
        L_0x011a:
            r4 = r3
        L_0x011b:
            r11 = r4
            java.lang.Object r4 = r8.m250tryReceivePtdJZtk()     // Catch:{ all -> 0x0198 }
            java.lang.Object r4 = kotlinx.coroutines.channels.ChannelResult.m235getOrNullimpl(r4)     // Catch:{ all -> 0x0198 }
            java.util.Set r4 = (java.util.Set) r4     // Catch:{ all -> 0x0198 }
            if (r4 != 0) goto L_0x0195
            if (r11 == 0) goto L_0x018b
            r10.clear()     // Catch:{ all -> 0x0198 }
            androidx.compose.runtime.snapshots.Snapshot$Companion r4 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0198 }
            androidx.compose.runtime.snapshots.Snapshot r4 = r4.takeSnapshot(r9)     // Catch:{ all -> 0x0198 }
            kotlin.jvm.functions.Function0<T> r11 = r2.$block     // Catch:{ all -> 0x0198 }
            r13 = 0
            r14 = r4
            r15 = 0
            androidx.compose.runtime.snapshots.Snapshot r16 = r14.makeCurrent()     // Catch:{ all -> 0x0186 }
            r19 = r16
            java.lang.Object r11 = r11.invoke()     // Catch:{ all -> 0x017e }
            r3 = r19
            r14.restoreCurrent(r3)     // Catch:{ all -> 0x0186 }
            r4.dispose()     // Catch:{ all -> 0x0198 }
            r3 = r4
            r3 = r11
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)     // Catch:{ all -> 0x0198 }
            if (r4 != 0) goto L_0x018b
            r4 = r3
            r6 = r2
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch:{ all -> 0x0198 }
            r2.L$0 = r12     // Catch:{ all -> 0x0198 }
            r2.L$1 = r10     // Catch:{ all -> 0x0198 }
            r2.L$2 = r9     // Catch:{ all -> 0x0198 }
            r2.L$3 = r8     // Catch:{ all -> 0x0198 }
            r2.L$4 = r7     // Catch:{ all -> 0x0198 }
            r2.L$5 = r4     // Catch:{ all -> 0x0198 }
            r11 = 3
            r2.label = r11     // Catch:{ all -> 0x0198 }
            java.lang.Object r6 = r12.emit(r3, r6)     // Catch:{ all -> 0x0198 }
            if (r6 != r0) goto L_0x0171
            return r0
        L_0x0171:
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r12
            r17 = r5
            r5 = r4
            r4 = r17
        L_0x017b:
            r3 = 1
            goto L_0x00e5
        L_0x017e:
            r0 = move-exception
            r3 = r19
            r6 = r0
            r14.restoreCurrent(r3)     // Catch:{ all -> 0x0186 }
            throw r6     // Catch:{ all -> 0x0186 }
        L_0x0186:
            r0 = move-exception
            r4.dispose()     // Catch:{ all -> 0x0198 }
            throw r0     // Catch:{ all -> 0x0198 }
        L_0x018b:
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r12
            r3 = 1
            goto L_0x00e5
        L_0x0195:
            r3 = 1
            goto L_0x010e
        L_0x0198:
            r0 = move-exception
            r4 = r5
            r6 = r7
            goto L_0x01a8
        L_0x019c:
            r0 = move-exception
            r3 = r0
            r13.restoreCurrent(r15)     // Catch:{ all -> 0x01a2 }
            throw r3     // Catch:{ all -> 0x01a2 }
        L_0x01a2:
            r0 = move-exception
            r5.dispose()     // Catch:{ all -> 0x01a7 }
            throw r0     // Catch:{ all -> 0x01a7 }
        L_0x01a7:
            r0 = move-exception
        L_0x01a8:
            r6.dispose()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
