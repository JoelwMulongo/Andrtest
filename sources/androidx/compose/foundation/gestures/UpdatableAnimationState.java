package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedSpringSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002JM\u0010\u000f\u001a\u00020\u00102!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017H@ø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState;", "", "()V", "isRunning", "", "lastFrameTime", "", "lastVelocity", "Landroidx/compose/animation/core/AnimationVector1D;", "value", "", "getValue", "()F", "setValue", "(F)V", "animateToZero", "", "beforeFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "valueDelta", "afterFrame", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UpdatableAnimationState.kt */
public final class UpdatableAnimationState {
    /* access modifiers changed from: private */
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Deprecated
    public static final VectorizedSpringSpec<AnimationVector1D> RebasableAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null).vectorize((TwoWayConverter) VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE));
    @Deprecated
    public static final float VisibilityThreshold = 0.01f;
    /* access modifiers changed from: private */
    @Deprecated
    public static final AnimationVector1D ZeroVector = new AnimationVector1D(0.0f);
    private boolean isRunning;
    /* access modifiers changed from: private */
    public long lastFrameTime = Long.MIN_VALUE;
    /* access modifiers changed from: private */
    public AnimationVector1D lastVelocity = ZeroVector;
    private float value;

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float f) {
        this.value = f;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0093, code lost:
        if (Companion.isZeroish(r4.value) != false) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0095, code lost:
        r1.L$0 = r4;
        r1.L$1 = r11;
        r1.L$2 = r10;
        r1.F$0 = r12;
        r1.label = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00aa, code lost:
        if (androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(new androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$3(r4, r12, r11), r1) != r0) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ac, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ad, code lost:
        r10.invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b2, code lost:
        if (r12 != 0.0f) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b4, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b6, code lost:
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b7, code lost:
        if (r13 == false) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b9, code lost:
        r15 = r1;
        r1 = r0;
        r0 = r10;
        r10 = r4;
        r4 = r3;
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c0, code lost:
        r15 = r1;
        r1 = r0;
        r0 = r10;
        r10 = r4;
        r4 = r3;
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ce, code lost:
        if (java.lang.Math.abs(r10.value) != 0.0f) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d1, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d2, code lost:
        if (r9 != false) goto L_0x00f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d4, code lost:
        r3.L$0 = r10;
        r3.L$1 = r0;
        r3.L$2 = null;
        r3.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e9, code lost:
        if (androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(new androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$4(r10, r11), r3) != r1) goto L_0x00ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00eb, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ec, code lost:
        r1 = r3;
        r3 = r4;
        r4 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r0.invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f2, code lost:
        r10 = r4;
        r4 = r3;
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f5, code lost:
        r10.lastFrameTime = Long.MIN_VALUE;
        r10.lastVelocity = ZeroVector;
        r10.isRunning = false;
        r0 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0100, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0101, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0102, code lost:
        r1 = r3;
        r3 = r4;
        r4 = r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object animateToZero(kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r17, kotlin.jvm.functions.Function0<kotlin.Unit> r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            r16 = this;
            r0 = r19
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1 r1 = (androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r16
            goto L_0x0021
        L_0x0019:
            androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1 r1 = new androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1
            r2 = r16
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r3 = r1.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 0
            r6 = -9223372036854775808
            r8 = 0
            r9 = 1
            switch(r4) {
                case 0: goto L_0x0062;
                case 1: goto L_0x0049;
                case 2: goto L_0x0039;
                default: goto L_0x0031;
            }
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            java.lang.Object r0 = r1.L$1
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            java.lang.Object r4 = r1.L$0
            androidx.compose.foundation.gestures.UpdatableAnimationState r4 = (androidx.compose.foundation.gestures.UpdatableAnimationState) r4
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x0046 }
            goto L_0x00ef
        L_0x0046:
            r0 = move-exception
            goto L_0x0105
        L_0x0049:
            float r4 = r1.F$0
            java.lang.Object r10 = r1.L$2
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            java.lang.Object r11 = r1.L$1
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            java.lang.Object r12 = r1.L$0
            androidx.compose.foundation.gestures.UpdatableAnimationState r12 = (androidx.compose.foundation.gestures.UpdatableAnimationState) r12
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x005e }
            r15 = r12
            r12 = r4
            r4 = r15
            goto L_0x00ad
        L_0x005e:
            r0 = move-exception
            r4 = r12
            goto L_0x0105
        L_0x0062:
            kotlin.ResultKt.throwOnFailure(r3)
            r4 = r16
            r10 = r18
            r11 = r17
            boolean r12 = r4.isRunning
            r12 = r12 ^ r9
            if (r12 == 0) goto L_0x010e
            kotlin.coroutines.CoroutineContext r12 = r1.getContext()
            androidx.compose.ui.MotionDurationScale$Key r13 = androidx.compose.ui.MotionDurationScale.Key
            kotlin.coroutines.CoroutineContext$Key r13 = (kotlin.coroutines.CoroutineContext.Key) r13
            kotlin.coroutines.CoroutineContext$Element r12 = r12.get(r13)
            androidx.compose.ui.MotionDurationScale r12 = (androidx.compose.ui.MotionDurationScale) r12
            if (r12 == 0) goto L_0x0086
            float r12 = r12.getScaleFactor()
            goto L_0x0088
        L_0x0086:
            r12 = 1065353216(0x3f800000, float:1.0)
        L_0x0088:
            r4.isRunning = r9
        L_0x008b:
            androidx.compose.foundation.gestures.UpdatableAnimationState$Companion r13 = Companion     // Catch:{ all -> 0x0046 }
            float r14 = r4.value     // Catch:{ all -> 0x0046 }
            boolean r13 = r13.isZeroish(r14)     // Catch:{ all -> 0x0046 }
            if (r13 != 0) goto L_0x00c0
            androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$3 r13 = new androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$3     // Catch:{ all -> 0x0046 }
            r13.<init>(r4, r12, r11)     // Catch:{ all -> 0x0046 }
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13     // Catch:{ all -> 0x0046 }
            r1.L$0 = r4     // Catch:{ all -> 0x0046 }
            r1.L$1 = r11     // Catch:{ all -> 0x0046 }
            r1.L$2 = r10     // Catch:{ all -> 0x0046 }
            r1.F$0 = r12     // Catch:{ all -> 0x0046 }
            r1.label = r9     // Catch:{ all -> 0x0046 }
            java.lang.Object r13 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(r13, r1)     // Catch:{ all -> 0x0046 }
            if (r13 != r0) goto L_0x00ad
            return r0
        L_0x00ad:
            r10.invoke()     // Catch:{ all -> 0x0046 }
            int r13 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r13 != 0) goto L_0x00b6
            r13 = r9
            goto L_0x00b7
        L_0x00b6:
            r13 = r8
        L_0x00b7:
            if (r13 == 0) goto L_0x008b
            r15 = r1
            r1 = r0
            r0 = r10
            r10 = r4
            r4 = r3
            r3 = r15
            goto L_0x00c6
        L_0x00c0:
            r15 = r1
            r1 = r0
            r0 = r10
            r10 = r4
            r4 = r3
            r3 = r15
        L_0x00c6:
            float r12 = r10.value     // Catch:{ all -> 0x0101 }
            float r12 = java.lang.Math.abs(r12)     // Catch:{ all -> 0x0101 }
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x00d1
            goto L_0x00d2
        L_0x00d1:
            r9 = r8
        L_0x00d2:
            if (r9 != 0) goto L_0x00f5
            androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$4 r5 = new androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$4     // Catch:{ all -> 0x0101 }
            r5.<init>(r10, r11)     // Catch:{ all -> 0x0101 }
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5     // Catch:{ all -> 0x0101 }
            r3.L$0 = r10     // Catch:{ all -> 0x0101 }
            r3.L$1 = r0     // Catch:{ all -> 0x0101 }
            r9 = 0
            r3.L$2 = r9     // Catch:{ all -> 0x0101 }
            r9 = 2
            r3.label = r9     // Catch:{ all -> 0x0101 }
            java.lang.Object r5 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(r5, r3)     // Catch:{ all -> 0x0101 }
            if (r5 != r1) goto L_0x00ec
            return r1
        L_0x00ec:
            r1 = r3
            r3 = r4
            r4 = r10
        L_0x00ef:
            r0.invoke()     // Catch:{ all -> 0x0046 }
            r10 = r4
            r4 = r3
            r3 = r1
        L_0x00f5:
            r10.lastFrameTime = r6
            androidx.compose.animation.core.AnimationVector1D r0 = ZeroVector
            r10.lastVelocity = r0
            r10.isRunning = r8
            r0 = r10
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0101:
            r0 = move-exception
            r1 = r3
            r3 = r4
            r4 = r10
        L_0x0105:
            r4.lastFrameTime = r6
            androidx.compose.animation.core.AnimationVector1D r5 = ZeroVector
            r4.lastVelocity = r5
            r4.isRunning = r8
            throw r0
        L_0x010e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r5 = "Check failed."
            java.lang.String r5 = r5.toString()
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.UpdatableAnimationState.animateToZero(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\r\u001a\u00020\u000e*\u00020\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState$Companion;", "", "()V", "RebasableAnimationSpec", "Landroidx/compose/animation/core/VectorizedSpringSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "getRebasableAnimationSpec", "()Landroidx/compose/animation/core/VectorizedSpringSpec;", "VisibilityThreshold", "", "ZeroVector", "getZeroVector", "()Landroidx/compose/animation/core/AnimationVector1D;", "isZeroish", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: UpdatableAnimationState.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnimationVector1D getZeroVector() {
            return UpdatableAnimationState.ZeroVector;
        }

        public final VectorizedSpringSpec<AnimationVector1D> getRebasableAnimationSpec() {
            return UpdatableAnimationState.RebasableAnimationSpec;
        }

        public final boolean isZeroish(float $this$isZeroish) {
            return Math.abs($this$isZeroish) < 0.01f;
        }
    }
}
