package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tJ\u0006\u0010\n\u001a\u00020\u0005R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Landroidx/compose/runtime/ProduceFrameSignal;", "", "()V", "pendingFrameContinuation", "awaitFrameRequest", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestFrameLocked", "Lkotlin/coroutines/Continuation;", "takeFrameRequestLocked", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Recomposer.kt */
final class ProduceFrameSignal {
    /* access modifiers changed from: private */
    public Object pendingFrameContinuation;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
        r3 = new kotlinx.coroutines.CancellableContinuationImpl(kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r12), 1);
        r3.initCancellability();
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        monitor-enter(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (access$getPendingFrameContinuation$p(r10) != androidx.compose.runtime.RecomposerKt.access$getProduceAnotherFrame$p()) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
        access$setPendingFrameContinuation$p(r10, androidx.compose.runtime.RecomposerKt.access$getFramePending$p());
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        access$setPendingFrameContinuation$p(r10, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        monitor-exit(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r8 == null) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        r6 = kotlin.Result.Companion;
        r8.resumeWith(kotlin.Result.m6273constructorimpl(kotlin.Unit.INSTANCE));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005a, code lost:
        r1 = r3.getResult();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0064, code lost:
        if (r1 != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0066, code lost:
        kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006d, code lost:
        if (r1 != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0073, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object awaitFrameRequest(java.lang.Object r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            r0 = 0
            monitor-enter(r11)
            r1 = 0
            java.lang.Object r2 = r10.pendingFrameContinuation     // Catch:{ all -> 0x0077 }
            java.lang.Object r3 = androidx.compose.runtime.RecomposerKt.ProduceAnotherFrame     // Catch:{ all -> 0x0077 }
            if (r2 != r3) goto L_0x0015
            java.lang.Object r2 = androidx.compose.runtime.RecomposerKt.FramePending     // Catch:{ all -> 0x0077 }
            r10.pendingFrameContinuation = r2     // Catch:{ all -> 0x0077 }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0077 }
            monitor-exit(r11)
            return r2
        L_0x0015:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0077 }
            monitor-exit(r11)
            r0 = 0
            r1 = r12
            r2 = 0
            kotlinx.coroutines.CancellableContinuationImpl r3 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r1)
            r5 = 1
            r3.<init>(r4, r5)
            r3.initCancellability()
            r4 = r3
            kotlinx.coroutines.CancellableContinuation r4 = (kotlinx.coroutines.CancellableContinuation) r4
            r5 = 0
            r6 = 0
            monitor-enter(r11)
            r7 = 0
            java.lang.Object r8 = r10.pendingFrameContinuation     // Catch:{ all -> 0x0074 }
            java.lang.Object r9 = androidx.compose.runtime.RecomposerKt.ProduceAnotherFrame     // Catch:{ all -> 0x0074 }
            if (r8 != r9) goto L_0x0044
            java.lang.Object r8 = androidx.compose.runtime.RecomposerKt.FramePending     // Catch:{ all -> 0x0074 }
            r10.pendingFrameContinuation = r8     // Catch:{ all -> 0x0074 }
            r8 = r4
            goto L_0x0048
        L_0x0044:
            r10.pendingFrameContinuation = r4     // Catch:{ all -> 0x0074 }
            r8 = 0
        L_0x0048:
            monitor-exit(r11)
            if (r8 == 0) goto L_0x005a
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            java.lang.Object r6 = kotlin.Result.m6273constructorimpl(r6)
            r8.resumeWith(r6)
        L_0x005a:
            java.lang.Object r1 = r3.getResult()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r1 != r2) goto L_0x0069
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r12)
        L_0x0069:
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r1 != r2) goto L_0x0070
            return r1
        L_0x0070:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0074:
            r7 = move-exception
            monitor-exit(r11)
            throw r7
        L_0x0077:
            r1 = move-exception
            monitor-exit(r11)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ProduceFrameSignal.awaitFrameRequest(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void takeFrameRequestLocked() {
        if (this.pendingFrameContinuation == RecomposerKt.FramePending) {
            this.pendingFrameContinuation = null;
            return;
        }
        throw new IllegalStateException("frame not pending".toString());
    }

    public final Continuation<Unit> requestFrameLocked() {
        Object co = this.pendingFrameContinuation;
        if (co instanceof Continuation) {
            this.pendingFrameContinuation = RecomposerKt.FramePending;
            return (Continuation) co;
        }
        if (Intrinsics.areEqual(co, RecomposerKt.ProduceAnotherFrame) ? true : Intrinsics.areEqual(co, RecomposerKt.FramePending)) {
            return null;
        }
        if (co == null) {
            this.pendingFrameContinuation = RecomposerKt.ProduceAnotherFrame;
            return null;
        }
        throw new IllegalStateException(("invalid pendingFrameContinuation " + co).toString());
    }
}
