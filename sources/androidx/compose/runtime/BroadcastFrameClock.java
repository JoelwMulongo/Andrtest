package androidx.compose.runtime;

import androidx.compose.runtime.MonotonicFrameClock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001 B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0012\u001a\u00020\u00042\f\b\u0002\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\nH\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aJ+\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u0002H\u001c0\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fR\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Landroidx/compose/runtime/BroadcastFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "onNewAwaiters", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "awaiters", "", "Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "failureCause", "", "hasAwaiters", "", "getHasAwaiters", "()Z", "lock", "", "spareList", "cancel", "cancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "fail", "cause", "sendFrame", "timeNanos", "", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "FrameAwaiter", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BroadcastFrameClock.kt */
public final class BroadcastFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public List<FrameAwaiter<?>> awaiters;
    /* access modifiers changed from: private */
    public Throwable failureCause;
    /* access modifiers changed from: private */
    public final Object lock;
    /* access modifiers changed from: private */
    public final Function0<Unit> onNewAwaiters;
    private List<FrameAwaiter<?>> spareList;

    public BroadcastFrameClock() {
        this((Function0) null, 1, (DefaultConstructorMarker) null);
    }

    public BroadcastFrameClock(Function0<Unit> onNewAwaiters2) {
        this.onNewAwaiters = onNewAwaiters2;
        this.lock = new Object();
        this.awaiters = new ArrayList();
        this.spareList = new ArrayList();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BroadcastFrameClock(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function0);
    }

    public <R> R fold(R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        return MonotonicFrameClock.DefaultImpls.fold(this, initial, operation);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return MonotonicFrameClock.DefaultImpls.get(this, key);
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, key);
    }

    public CoroutineContext plus(CoroutineContext context) {
        return MonotonicFrameClock.DefaultImpls.plus(this, context);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "R", "", "onFrame", "Lkotlin/Function1;", "", "continuation", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "getContinuation", "()Lkotlin/coroutines/Continuation;", "getOnFrame", "()Lkotlin/jvm/functions/Function1;", "resume", "", "timeNanos", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BroadcastFrameClock.kt */
    private static final class FrameAwaiter<R> {
        private final Continuation<R> continuation;
        private final Function1<Long, R> onFrame;

        public FrameAwaiter(Function1<? super Long, ? extends R> onFrame2, Continuation<? super R> continuation2) {
            Intrinsics.checkNotNullParameter(onFrame2, "onFrame");
            Intrinsics.checkNotNullParameter(continuation2, "continuation");
            this.onFrame = onFrame2;
            this.continuation = continuation2;
        }

        public final Continuation<R> getContinuation() {
            return this.continuation;
        }

        public final Function1<Long, R> getOnFrame() {
            return this.onFrame;
        }

        public final void resume(long timeNanos) {
            Object obj;
            Continuation<R> continuation2 = this.continuation;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m6273constructorimpl(this.onFrame.invoke(Long.valueOf(timeNanos)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6273constructorimpl(ResultKt.createFailure(th));
            }
            continuation2.resumeWith(obj);
        }
    }

    public final boolean getHasAwaiters() {
        boolean z;
        synchronized (this.lock) {
            z = !this.awaiters.isEmpty();
        }
        return z;
    }

    public final void sendFrame(long timeNanos) {
        synchronized (this.lock) {
            List toResume = this.awaiters;
            this.awaiters = this.spareList;
            this.spareList = toResume;
            int size = toResume.size();
            for (int i = 0; i < size; i++) {
                toResume.get(i).resume(timeNanos);
            }
            toResume.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0077, code lost:
        r7.invokeOnCancellation(new androidx.compose.runtime.BroadcastFrameClock$withFrameNanos$2$1(r1, r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0082, code lost:
        if (r6 == false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0088, code lost:
        if (access$getOnNewAwaiters$p(r16) == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        access$getOnNewAwaiters$p(r16).invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0093, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0094, code lost:
        access$fail(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003d, code lost:
        r15 = r17;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <R> java.lang.Object withFrameNanos(kotlin.jvm.functions.Function1<? super java.lang.Long, ? extends R> r17, kotlin.coroutines.Continuation<? super R> r18) {
        /*
            r16 = this;
            r1 = r16
            r2 = 0
            r3 = r18
            r4 = 0
            kotlinx.coroutines.CancellableContinuationImpl r0 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r3)
            r6 = 1
            r0.<init>(r5, r6)
            r5 = r0
            r5.initCancellability()
            r7 = r5
            kotlinx.coroutines.CancellableContinuation r7 = (kotlinx.coroutines.CancellableContinuation) r7
            r8 = 0
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r9 = r0
            java.lang.Object r10 = r16.lock
            r11 = 0
            monitor-enter(r10)
            r0 = 0
            java.lang.Throwable r12 = r16.failureCause     // Catch:{ all -> 0x00aa }
            if (r12 == 0) goto L_0x0040
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch:{ all -> 0x00aa }
            kotlin.Result$Companion r13 = kotlin.Result.Companion     // Catch:{ all -> 0x00aa }
            java.lang.Object r13 = kotlin.ResultKt.createFailure(r12)     // Catch:{ all -> 0x00aa }
            java.lang.Object r13 = kotlin.Result.m6273constructorimpl(r13)     // Catch:{ all -> 0x00aa }
            r6.resumeWith(r13)     // Catch:{ all -> 0x00aa }
            monitor-exit(r10)
            r15 = r17
            goto L_0x0098
        L_0x0040:
            androidx.compose.runtime.BroadcastFrameClock$FrameAwaiter r13 = new androidx.compose.runtime.BroadcastFrameClock$FrameAwaiter     // Catch:{ all -> 0x00aa }
            r14 = r7
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14     // Catch:{ all -> 0x00aa }
            r15 = r17
            r13.<init>(r15, r14)     // Catch:{ all -> 0x00a8 }
            r9.element = r13     // Catch:{ all -> 0x00a8 }
            java.util.List r13 = r16.awaiters     // Catch:{ all -> 0x00a8 }
            java.util.Collection r13 = (java.util.Collection) r13     // Catch:{ all -> 0x00a8 }
            boolean r13 = r13.isEmpty()     // Catch:{ all -> 0x00a8 }
            if (r13 != 0) goto L_0x005a
            r13 = r6
            goto L_0x005b
        L_0x005a:
            r13 = 0
        L_0x005b:
            java.util.List r6 = r16.awaiters     // Catch:{ all -> 0x00a8 }
            T r14 = r9.element     // Catch:{ all -> 0x00a8 }
            if (r14 != 0) goto L_0x006a
            java.lang.String r14 = "awaiter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)     // Catch:{ all -> 0x00a8 }
            r14 = 0
            goto L_0x006e
        L_0x006a:
            T r14 = r9.element     // Catch:{ all -> 0x00a8 }
            androidx.compose.runtime.BroadcastFrameClock$FrameAwaiter r14 = (androidx.compose.runtime.BroadcastFrameClock.FrameAwaiter) r14     // Catch:{ all -> 0x00a8 }
        L_0x006e:
            r6.add(r14)     // Catch:{ all -> 0x00a8 }
            if (r13 != 0) goto L_0x0075
            r6 = 1
            goto L_0x0076
        L_0x0075:
            r6 = 0
        L_0x0076:
            monitor-exit(r10)
            androidx.compose.runtime.BroadcastFrameClock$withFrameNanos$2$1 r0 = new androidx.compose.runtime.BroadcastFrameClock$withFrameNanos$2$1
            r0.<init>(r1, r9)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r7.invokeOnCancellation(r0)
            if (r6 == 0) goto L_0x0097
            kotlin.jvm.functions.Function0 r0 = r16.onNewAwaiters
            if (r0 == 0) goto L_0x0097
            kotlin.jvm.functions.Function0 r0 = r16.onNewAwaiters     // Catch:{ all -> 0x0093 }
            r0.invoke()     // Catch:{ all -> 0x0093 }
            goto L_0x0097
        L_0x0093:
            r0 = move-exception
            r1.fail(r0)
        L_0x0097:
        L_0x0098:
            java.lang.Object r0 = r5.getResult()
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r3) goto L_0x00a6
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r18)
        L_0x00a6:
            return r0
        L_0x00a8:
            r0 = move-exception
            goto L_0x00ad
        L_0x00aa:
            r0 = move-exception
            r15 = r17
        L_0x00ad:
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.BroadcastFrameClock.withFrameNanos(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void fail(Throwable cause) {
        synchronized (this.lock) {
            if (this.failureCause == null) {
                this.failureCause = cause;
                List $this$fastForEach$iv = this.awaiters;
                int size = $this$fastForEach$iv.size();
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    Continuation continuation = $this$fastForEach$iv.get(index$iv).getContinuation();
                    Result.Companion companion = Result.Companion;
                    continuation.resumeWith(Result.m6273constructorimpl(ResultKt.createFailure(cause)));
                }
                this.awaiters.clear();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public static /* synthetic */ void cancel$default(BroadcastFrameClock broadcastFrameClock, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = new CancellationException("clock cancelled");
        }
        broadcastFrameClock.cancel(cancellationException);
    }

    public final void cancel(CancellationException cancellationException) {
        Intrinsics.checkNotNullParameter(cancellationException, "cancellationException");
        fail(cancellationException);
    }
}
