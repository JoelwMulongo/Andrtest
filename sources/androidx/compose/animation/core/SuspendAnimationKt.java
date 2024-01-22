package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u001a\u0001\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u000b2\u0006\u0010\f\u001a\u0002H\u00072\u0006\u0010\r\u001a\u0002H\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u0001H\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001as\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u001026\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aa\u0010\u0019\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u001a26\u0010\u0011\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001av\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H@ø\u0001\u0000¢\u0006\u0002\u0010$\u001ap\u0010\u0019\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070%2\b\b\u0002\u0010&\u001a\u00020'2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H@ø\u0001\u0000¢\u0006\u0002\u0010(\u001az\u0010)\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2\u0006\u0010\r\u001a\u0002H\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00102\b\b\u0002\u0010&\u001a\u00020'2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H@ø\u0001\u0000¢\u0006\u0002\u0010*\u001aZ\u0010+\u001a\u0002H,\"\u0004\b\u0000\u0010,\"\u0004\b\u0001\u0010\u0007\"\b\b\u0002\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2!\u0010-\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(.\u0012\u0004\u0012\u0002H,0!H@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a\u0001\u00100\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0006\u0010.\u001a\u00020 2\u0006\u00101\u001a\u00020 2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2#\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0002\u001a\u0001\u00104\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0006\u0010.\u001a\u00020 2\u0006\u0010\u0000\u001a\u00020\u00012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001c2#\u0010\u0011\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b#H\u0002\u001a<\u00105\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\b\b\u0001\u0010\b*\u00020\t*\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\"2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u001cH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u00066"}, d2 = {"durationScale", "", "Lkotlin/coroutines/CoroutineContext;", "getDurationScale", "(Lkotlin/coroutines/CoroutineContext;)F", "animate", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocity", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "velocity", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(FFFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateDecay", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "(FFLandroidx/compose/animation/core/FloatDecayAnimationSpec;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/AnimationState;", "animation", "Landroidx/compose/animation/core/Animation;", "startTimeNanos", "", "Lkotlin/Function1;", "Landroidx/compose/animation/core/AnimationScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/Animation;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "sequentialAnimation", "", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callWithFrameNanos", "R", "onFrame", "frameTimeNanos", "(Landroidx/compose/animation/core/Animation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doAnimationFrame", "playTimeNanos", "anim", "state", "doAnimationFrameWithScale", "updateState", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SuspendAnimation.kt */
public final class SuspendAnimationKt {
    public static /* synthetic */ Object animate$default(float f, float f2, float f3, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i, Object obj) {
        float f4;
        AnimationSpec animationSpec2;
        if ((i & 4) != 0) {
            f4 = 0.0f;
        } else {
            f4 = f3;
        }
        if ((i & 8) != 0) {
            animationSpec2 = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        } else {
            animationSpec2 = animationSpec;
        }
        return animate(f, f2, f4, animationSpec2, function2, continuation);
    }

    public static final Object animate(float initialValue, float targetValue, float initialVelocity, AnimationSpec<Float> animationSpec, Function2<? super Float, ? super Float, Unit> block, Continuation<? super Unit> $completion) {
        Object animate = animate(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Boxing.boxFloat(initialValue), Boxing.boxFloat(targetValue), Boxing.boxFloat(initialVelocity), animationSpec, block, $completion);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static final Object animateDecay(float initialValue, float initialVelocity, FloatDecayAnimationSpec animationSpec, Function2<? super Float, ? super Float, Unit> block, Continuation<? super Unit> $completion) {
        Object animate$default = animate$default(AnimationStateKt.AnimationState$default(initialValue, initialVelocity, 0, 0, false, 28, (Object) null), AnimationKt.DecayAnimation(animationSpec, initialValue, initialVelocity), 0, new SuspendAnimationKt$animateDecay$2(block), $completion, 2, (Object) null);
        return animate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animate$default(TwoWayConverter twoWayConverter, Object obj, Object obj2, Object obj3, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i, Object obj4) {
        Object obj5;
        if ((i & 8) != 0) {
            obj5 = null;
        } else {
            obj5 = obj3;
        }
        return animate(twoWayConverter, obj, obj2, obj5, (i & 16) != 0 ? AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null) : animationSpec, function2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x006d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, V extends androidx.compose.animation.core.AnimationVector> java.lang.Object animate(androidx.compose.animation.core.TwoWayConverter<T, V> r18, T r19, T r20, T r21, androidx.compose.animation.core.AnimationSpec<T> r22, kotlin.jvm.functions.Function2<? super T, ? super T, kotlin.Unit> r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            if (r21 == 0) goto L_0x0016
            r0 = r21
            r1 = 0
            kotlin.jvm.functions.Function1 r2 = r18.getConvertToVector()
            java.lang.Object r2 = r2.invoke(r0)
            androidx.compose.animation.core.AnimationVector r2 = (androidx.compose.animation.core.AnimationVector) r2
            if (r2 != 0) goto L_0x0012
            goto L_0x0016
        L_0x0012:
            r15 = r19
            r6 = r2
            goto L_0x0027
        L_0x0016:
            kotlin.jvm.functions.Function1 r0 = r18.getConvertToVector()
            r15 = r19
            java.lang.Object r0 = r0.invoke(r15)
            androidx.compose.animation.core.AnimationVector r0 = (androidx.compose.animation.core.AnimationVector) r0
            androidx.compose.animation.core.AnimationVector r2 = androidx.compose.animation.core.AnimationVectorsKt.newInstance(r0)
            r6 = r2
        L_0x0027:
            androidx.compose.animation.core.TargetBasedAnimation r0 = new androidx.compose.animation.core.TargetBasedAnimation
            r1 = r0
            r2 = r22
            r3 = r18
            r4 = r19
            r5 = r20
            r1.<init>(r2, r3, r4, r5, r6)
            androidx.compose.animation.core.AnimationState r1 = new androidx.compose.animation.core.AnimationState
            r11 = 0
            r13 = 0
            r2 = 0
            r16 = 56
            r17 = 0
            r7 = r1
            r8 = r18
            r9 = r19
            r10 = r6
            r15 = r2
            r7.<init>(r8, r9, r10, r11, r13, r15, r16, r17)
            r8 = r0
            androidx.compose.animation.core.Animation r8 = (androidx.compose.animation.core.Animation) r8
            r9 = 0
            androidx.compose.animation.core.SuspendAnimationKt$animate$3 r2 = new androidx.compose.animation.core.SuspendAnimationKt$animate$3
            r4 = r23
            r2.<init>(r4, r3)
            r11 = r2
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r13 = 2
            r14 = 0
            r12 = r24
            java.lang.Object r1 = animate$default(r7, r8, r9, r11, r12, r13, r14)
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r1 != r2) goto L_0x006e
            return r1
        L_0x006e:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SuspendAnimationKt.animate(androidx.compose.animation.core.TwoWayConverter, java.lang.Object, java.lang.Object, java.lang.Object, androidx.compose.animation.core.AnimationSpec, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object animateTo$default(AnimationState animationState, Object obj, AnimationSpec animationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj2) {
        AnimationSpec animationSpec2;
        boolean z2;
        Function1 function12;
        if ((i & 2) != 0) {
            animationSpec2 = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);
        } else {
            animationSpec2 = animationSpec;
        }
        if ((i & 4) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if ((i & 8) != 0) {
            function12 = SuspendAnimationKt$animateTo$2.INSTANCE;
        } else {
            function12 = function1;
        }
        return animateTo(animationState, obj, animationSpec2, z2, function12, continuation);
    }

    public static final <T, V extends AnimationVector> Object animateTo(AnimationState<T, V> $this$animateTo, T targetValue, AnimationSpec<T> animationSpec, boolean sequentialAnimation, Function1<? super AnimationScope<T, V>, Unit> block, Continuation<? super Unit> $completion) {
        Object animate = animate($this$animateTo, new TargetBasedAnimation(animationSpec, $this$animateTo.getTypeConverter(), $this$animateTo.getValue(), targetValue, $this$animateTo.getVelocityVector()), sequentialAnimation ? $this$animateTo.getLastFrameTimeNanos() : Long.MIN_VALUE, block, $completion);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateDecay$default(AnimationState animationState, DecayAnimationSpec decayAnimationSpec, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = SuspendAnimationKt$animateDecay$4.INSTANCE;
        }
        return animateDecay(animationState, decayAnimationSpec, z, function1, (Continuation<? super Unit>) continuation);
    }

    public static final <T, V extends AnimationVector> Object animateDecay(AnimationState<T, V> $this$animateDecay, DecayAnimationSpec<T> animationSpec, boolean sequentialAnimation, Function1<? super AnimationScope<T, V>, Unit> block, Continuation<? super Unit> $completion) {
        Object animate = animate($this$animateDecay, new DecayAnimation(animationSpec, $this$animateDecay.getTypeConverter(), $this$animateDecay.getValue(), $this$animateDecay.getVelocityVector()), sequentialAnimation ? $this$animateDecay.getLastFrameTimeNanos() : Long.MIN_VALUE, block, $completion);
        return animate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animate : Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b1, code lost:
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r4 = r3.element;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0126, code lost:
        if (((androidx.compose.animation.core.AnimationScope) r4).isRunning() == false) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0128, code lost:
        r23 = r3;
        r1.L$0 = r7;
        r1.L$1 = r6;
        r1.L$2 = r5;
        r1.L$3 = r3;
        r1.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0152, code lost:
        if (callWithFrameNanos(r6, new androidx.compose.animation.core.SuspendAnimationKt$animate$9(r23, getDurationScale(r1.getContext()), r6, r7, r5), r1) != r0) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0154, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0158, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0159, code lost:
        r0 = e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, V extends androidx.compose.animation.core.AnimationVector> java.lang.Object animate(androidx.compose.animation.core.AnimationState<T, V> r22, androidx.compose.animation.core.Animation<T, V> r23, long r24, kotlin.jvm.functions.Function1<? super androidx.compose.animation.core.AnimationScope<T, V>, kotlin.Unit> r26, kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
            r0 = r27
            boolean r1 = r0 instanceof androidx.compose.animation.core.SuspendAnimationKt$animate$4
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.animation.core.SuspendAnimationKt$animate$4 r1 = (androidx.compose.animation.core.SuspendAnimationKt$animate$4) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.animation.core.SuspendAnimationKt$animate$4 r1 = new androidx.compose.animation.core.SuspendAnimationKt$animate$4
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r2 = r1.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            switch(r3) {
                case 0: goto L_0x0060;
                case 1: goto L_0x0046;
                case 2: goto L_0x002f;
                default: goto L_0x0027;
            }
        L_0x0027:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002f:
            java.lang.Object r3 = r1.L$3
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r5 = r1.L$2
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.lang.Object r6 = r1.L$1
            androidx.compose.animation.core.Animation r6 = (androidx.compose.animation.core.Animation) r6
            java.lang.Object r7 = r1.L$0
            androidx.compose.animation.core.AnimationState r7 = (androidx.compose.animation.core.AnimationState) r7
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ CancellationException -> 0x005b }
            r21 = 1
            goto L_0x0155
        L_0x0046:
            java.lang.Object r3 = r1.L$3
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r5 = r1.L$2
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.lang.Object r6 = r1.L$1
            androidx.compose.animation.core.Animation r6 = (androidx.compose.animation.core.Animation) r6
            java.lang.Object r7 = r1.L$0
            androidx.compose.animation.core.AnimationState r7 = (androidx.compose.animation.core.AnimationState) r7
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ CancellationException -> 0x005b }
            r15 = 1
            goto L_0x00b1
        L_0x005b:
            r0 = move-exception
            r21 = 1
            goto L_0x0169
        L_0x0060:
            kotlin.ResultKt.throwOnFailure(r2)
            r7 = r22
            r5 = r24
            r3 = r26
            r15 = r23
            r8 = 0
            java.lang.Object r16 = r15.getValueFromNanos(r8)
            androidx.compose.animation.core.AnimationVector r17 = r15.getVelocityVectorFromNanos(r8)
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            r13 = r8
            r8 = -9223372036854775808
            int r8 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x00c6
            kotlin.coroutines.CoroutineContext r5 = r1.getContext()     // Catch:{ CancellationException -> 0x00be }
            float r14 = getDurationScale(r5)     // Catch:{ CancellationException -> 0x00be }
            androidx.compose.animation.core.SuspendAnimationKt$animate$6 r5 = new androidx.compose.animation.core.SuspendAnimationKt$animate$6     // Catch:{ CancellationException -> 0x00be }
            r8 = r5
            r9 = r13
            r10 = r16
            r11 = r15
            r12 = r17
            r6 = r13
            r13 = r7
            r4 = r15
            r15 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ CancellationException -> 0x00b7 }
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5     // Catch:{ CancellationException -> 0x00b7 }
            r1.L$0 = r7     // Catch:{ CancellationException -> 0x00b7 }
            r1.L$1 = r4     // Catch:{ CancellationException -> 0x00b7 }
            r1.L$2 = r3     // Catch:{ CancellationException -> 0x00b7 }
            r1.L$3 = r6     // Catch:{ CancellationException -> 0x00b7 }
            r15 = 1
            r1.label = r15     // Catch:{ CancellationException -> 0x00b5 }
            java.lang.Object r5 = callWithFrameNanos(r4, r5, r1)     // Catch:{ CancellationException -> 0x00b5 }
            if (r5 != r0) goto L_0x00ae
            return r0
        L_0x00ae:
            r5 = r3
            r3 = r6
            r6 = r4
        L_0x00b1:
            r21 = r15
            goto L_0x011b
        L_0x00b5:
            r0 = move-exception
            goto L_0x00b9
        L_0x00b7:
            r0 = move-exception
            r15 = 1
        L_0x00b9:
            r3 = r6
            r21 = r15
            goto L_0x0169
        L_0x00be:
            r0 = move-exception
            r6 = r13
            r15 = 1
            r3 = r6
            r21 = r15
            goto L_0x0169
        L_0x00c6:
            r14 = r13
            r4 = r15
            r15 = 1
            androidx.compose.animation.core.AnimationScope r12 = new androidx.compose.animation.core.AnimationScope     // Catch:{ CancellationException -> 0x0160 }
            androidx.compose.animation.core.TwoWayConverter r10 = r4.getTypeConverter()     // Catch:{ CancellationException -> 0x0160 }
            java.lang.Object r18 = r4.getTargetValue()     // Catch:{ CancellationException -> 0x0160 }
            r19 = 1
            androidx.compose.animation.core.SuspendAnimationKt$animate$7 r8 = new androidx.compose.animation.core.SuspendAnimationKt$animate$7     // Catch:{ CancellationException -> 0x0160 }
            r8.<init>(r7)     // Catch:{ CancellationException -> 0x0160 }
            r20 = r8
            kotlin.jvm.functions.Function0 r20 = (kotlin.jvm.functions.Function0) r20     // Catch:{ CancellationException -> 0x0160 }
            r8 = r12
            r9 = r16
            r11 = r17
            r22 = r12
            r12 = r5
            r27 = r2
            r2 = r14
            r14 = r18
            r21 = r15
            r15 = r5
            r17 = r19
            r18 = r20
            r8.<init>(r9, r10, r11, r12, r14, r15, r17, r18)     // Catch:{ CancellationException -> 0x015b }
            r8 = r22
            r15 = 0
            kotlin.coroutines.CoroutineContext r9 = r1.getContext()     // Catch:{ CancellationException -> 0x015b }
            float r11 = getDurationScale(r9)     // Catch:{ CancellationException -> 0x015b }
            r9 = r5
            r12 = r4
            r13 = r7
            r14 = r3
            doAnimationFrameWithScale(r8, r9, r11, r12, r13, r14)     // Catch:{ CancellationException -> 0x015b }
            r5 = r22
            r2.element = r5     // Catch:{ CancellationException -> 0x015b }
            r5 = r3
            r6 = r4
            r3 = r2
            r2 = r27
        L_0x011b:
            T r4 = r3.element     // Catch:{ CancellationException -> 0x0159 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ CancellationException -> 0x0159 }
            androidx.compose.animation.core.AnimationScope r4 = (androidx.compose.animation.core.AnimationScope) r4     // Catch:{ CancellationException -> 0x0159 }
            boolean r4 = r4.isRunning()     // Catch:{ CancellationException -> 0x0159 }
            if (r4 == 0) goto L_0x0156
            kotlin.coroutines.CoroutineContext r4 = r1.getContext()     // Catch:{ CancellationException -> 0x0159 }
            float r4 = getDurationScale(r4)     // Catch:{ CancellationException -> 0x0159 }
            r24 = r4
            androidx.compose.animation.core.SuspendAnimationKt$animate$9 r4 = new androidx.compose.animation.core.SuspendAnimationKt$animate$9     // Catch:{ CancellationException -> 0x0159 }
            r22 = r4
            r23 = r3
            r25 = r6
            r26 = r7
            r27 = r5
            r22.<init>(r23, r24, r25, r26, r27)     // Catch:{ CancellationException -> 0x0159 }
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4     // Catch:{ CancellationException -> 0x0159 }
            r1.L$0 = r7     // Catch:{ CancellationException -> 0x0159 }
            r1.L$1 = r6     // Catch:{ CancellationException -> 0x0159 }
            r1.L$2 = r5     // Catch:{ CancellationException -> 0x0159 }
            r1.L$3 = r3     // Catch:{ CancellationException -> 0x0159 }
            r8 = 2
            r1.label = r8     // Catch:{ CancellationException -> 0x0159 }
            java.lang.Object r4 = callWithFrameNanos(r6, r4, r1)     // Catch:{ CancellationException -> 0x0159 }
            if (r4 != r0) goto L_0x0155
            return r0
        L_0x0155:
            goto L_0x011b
        L_0x0156:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0159:
            r0 = move-exception
            goto L_0x0169
        L_0x015b:
            r0 = move-exception
            r3 = r2
            r2 = r27
            goto L_0x0169
        L_0x0160:
            r0 = move-exception
            r27 = r2
            r2 = r14
            r21 = r15
            r3 = r2
            r2 = r27
        L_0x0169:
            T r4 = r3.element
            androidx.compose.animation.core.AnimationScope r4 = (androidx.compose.animation.core.AnimationScope) r4
            r5 = 0
            if (r4 != 0) goto L_0x0171
            goto L_0x0174
        L_0x0171:
            r4.setRunning$animation_core_release(r5)
        L_0x0174:
            T r4 = r3.element
            androidx.compose.animation.core.AnimationScope r4 = (androidx.compose.animation.core.AnimationScope) r4
            if (r4 == 0) goto L_0x0189
            long r3 = r4.getLastFrameTimeNanos()
            long r8 = r7.getLastFrameTimeNanos()
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x0189
            r4 = r21
            goto L_0x018a
        L_0x0189:
            r4 = r5
        L_0x018a:
            if (r4 == 0) goto L_0x018f
            r7.setRunning$animation_core_release(r5)
        L_0x018f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SuspendAnimationKt.animate(androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.Animation, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object animate$default(AnimationState animationState, Animation animation, long j, Function1 function1, Continuation continuation, int i, Object obj) {
        long j2;
        Function1 function12;
        if ((i & 2) != 0) {
            j2 = Long.MIN_VALUE;
        } else {
            j2 = j;
        }
        if ((i & 4) != 0) {
            function12 = SuspendAnimationKt$animate$5.INSTANCE;
        } else {
            function12 = function1;
        }
        return animate(animationState, animation, j2, function12, continuation);
    }

    /* access modifiers changed from: private */
    public static final <R, T, V extends AnimationVector> Object callWithFrameNanos(Animation<T, V> $this$callWithFrameNanos, Function1<? super Long, ? extends R> onFrame, Continuation<? super R> $completion) {
        if ($this$callWithFrameNanos.isInfinite()) {
            return InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(onFrame, $completion);
        }
        return MonotonicFrameClockKt.withFrameNanos(new SuspendAnimationKt$callWithFrameNanos$2(onFrame), $completion);
    }

    public static final float getDurationScale(CoroutineContext $this$durationScale) {
        Intrinsics.checkNotNullParameter($this$durationScale, "<this>");
        MotionDurationScale motionDurationScale = (MotionDurationScale) $this$durationScale.get(MotionDurationScale.Key);
        float scale = motionDurationScale != null ? motionDurationScale.getScaleFactor() : 1.0f;
        if (scale >= 0.0f) {
            return scale;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final <T, V extends AnimationVector> void updateState(AnimationScope<T, V> $this$updateState, AnimationState<T, V> state) {
        Intrinsics.checkNotNullParameter($this$updateState, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        state.setValue$animation_core_release($this$updateState.getValue());
        AnimationVectorsKt.copyFrom(state.getVelocityVector(), $this$updateState.getVelocityVector());
        state.setFinishedTimeNanos$animation_core_release($this$updateState.getFinishedTimeNanos());
        state.setLastFrameTimeNanos$animation_core_release($this$updateState.getLastFrameTimeNanos());
        state.setRunning$animation_core_release($this$updateState.isRunning());
    }

    /* access modifiers changed from: private */
    public static final <T, V extends AnimationVector> void doAnimationFrameWithScale(AnimationScope<T, V> $this$doAnimationFrameWithScale, long frameTimeNanos, float durationScale, Animation<T, V> anim, AnimationState<T, V> state, Function1<? super AnimationScope<T, V>, Unit> block) {
        long playTimeNanos;
        if (durationScale == 0.0f) {
            playTimeNanos = anim.getDurationNanos();
        } else {
            playTimeNanos = (long) (((float) (frameTimeNanos - $this$doAnimationFrameWithScale.getStartTimeNanos())) / durationScale);
        }
        doAnimationFrame($this$doAnimationFrameWithScale, frameTimeNanos, playTimeNanos, anim, state, block);
    }

    private static final <T, V extends AnimationVector> void doAnimationFrame(AnimationScope<T, V> $this$doAnimationFrame, long frameTimeNanos, long playTimeNanos, Animation<T, V> anim, AnimationState<T, V> state, Function1<? super AnimationScope<T, V>, Unit> block) {
        $this$doAnimationFrame.setLastFrameTimeNanos$animation_core_release(frameTimeNanos);
        $this$doAnimationFrame.setValue$animation_core_release(anim.getValueFromNanos(playTimeNanos));
        $this$doAnimationFrame.setVelocityVector$animation_core_release(anim.getVelocityVectorFromNanos(playTimeNanos));
        if (anim.isFinishedFromNanos(playTimeNanos)) {
            $this$doAnimationFrame.setFinishedTimeNanos$animation_core_release($this$doAnimationFrame.getLastFrameTimeNanos());
            $this$doAnimationFrame.setRunning$animation_core_release(false);
        }
        updateState($this$doAnimationFrame, state);
        block.invoke($this$doAnimationFrame);
    }
}
