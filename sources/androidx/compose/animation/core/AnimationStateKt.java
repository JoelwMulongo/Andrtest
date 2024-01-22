package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u001ai\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0002\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\t2\u0006\u0010\n\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u0002H\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0001¢\u0006\u0002\u0010\u0010\u001aB\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00022\u0006\u0010\n\u001a\u00020\u00112\b\b\u0002\u0010\u000b\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0001\u001ak\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u0002\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0007*\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\u00022\b\b\u0002\u0010\u0014\u001a\u0002H\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u0001H\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0001¢\u0006\u0002\u0010\u0016\u001aT\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0002*\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0001\u001a3\u0010\u0018\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0005\"\b\b\u0001\u0010\u0006*\u00020\u0007*\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00060\t2\u0006\u0010\u0014\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0019\"\u001d\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u001a"}, d2 = {"isFinished", "", "Landroidx/compose/animation/core/AnimationState;", "(Landroidx/compose/animation/core/AnimationState;)Z", "AnimationState", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "initialVelocity", "lastFrameTimeNanos", "", "finishedTimeNanos", "isRunning", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;JJZ)Landroidx/compose/animation/core/AnimationState;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "copy", "value", "velocityVector", "(Landroidx/compose/animation/core/AnimationState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;JJZ)Landroidx/compose/animation/core/AnimationState;", "velocity", "createZeroVectorFrom", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimationState.kt */
public final class AnimationStateKt {
    public static final boolean isFinished(AnimationState<?, ?> $this$isFinished) {
        Intrinsics.checkNotNullParameter($this$isFinished, "<this>");
        return $this$isFinished.getFinishedTimeNanos() != Long.MIN_VALUE;
    }

    public static /* synthetic */ AnimationState copy$default(AnimationState animationState, Object obj, AnimationVector animationVector, long j, long j2, boolean z, int i, Object obj2) {
        AnimationVector animationVector2;
        long j3;
        long j4;
        boolean z2;
        if ((i & 1) != 0) {
            obj = animationState.getValue();
        }
        if ((i & 2) != 0) {
            animationVector2 = AnimationVectorsKt.copy(animationState.getVelocityVector());
        } else {
            animationVector2 = animationVector;
        }
        if ((i & 4) != 0) {
            j3 = animationState.getLastFrameTimeNanos();
        } else {
            j3 = j;
        }
        if ((i & 8) != 0) {
            j4 = animationState.getFinishedTimeNanos();
        } else {
            j4 = j2;
        }
        if ((i & 16) != 0) {
            z2 = animationState.isRunning();
        } else {
            z2 = z;
        }
        return copy(animationState, obj, animationVector2, j3, j4, z2);
    }

    public static final <T, V extends AnimationVector> AnimationState<T, V> copy(AnimationState<T, V> $this$copy, T value, V velocityVector, long lastFrameTimeNanos, long finishedTimeNanos, boolean isRunning) {
        AnimationState<T, V> animationState = $this$copy;
        Intrinsics.checkNotNullParameter($this$copy, "<this>");
        return new AnimationState($this$copy.getTypeConverter(), value, velocityVector, lastFrameTimeNanos, finishedTimeNanos, isRunning);
    }

    public static /* synthetic */ AnimationState copy$default(AnimationState animationState, float f, float f2, long j, long j2, boolean z, int i, Object obj) {
        float f3;
        long j3;
        long j4;
        boolean z2;
        if ((i & 1) != 0) {
            f = ((Number) animationState.getValue()).floatValue();
        }
        if ((i & 2) != 0) {
            f3 = ((AnimationVector1D) animationState.getVelocityVector()).getValue();
        } else {
            f3 = f2;
        }
        if ((i & 4) != 0) {
            j3 = animationState.getLastFrameTimeNanos();
        } else {
            j3 = j;
        }
        if ((i & 8) != 0) {
            j4 = animationState.getFinishedTimeNanos();
        } else {
            j4 = j2;
        }
        if ((i & 16) != 0) {
            z2 = animationState.isRunning();
        } else {
            z2 = z;
        }
        return copy((AnimationState<Float, AnimationVector1D>) animationState, f, f3, j3, j4, z2);
    }

    public static final AnimationState<Float, AnimationVector1D> copy(AnimationState<Float, AnimationVector1D> $this$copy, float value, float velocity, long lastFrameTimeNanos, long finishedTimeNanos, boolean isRunning) {
        AnimationState<Float, AnimationVector1D> animationState = $this$copy;
        Intrinsics.checkNotNullParameter($this$copy, "<this>");
        return new AnimationState($this$copy.getTypeConverter(), Float.valueOf(value), AnimationVectorsKt.AnimationVector(velocity), lastFrameTimeNanos, finishedTimeNanos, isRunning);
    }

    public static /* synthetic */ AnimationState AnimationState$default(float f, float f2, long j, long j2, boolean z, int i, Object obj) {
        long j3;
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        long j4 = Long.MIN_VALUE;
        if ((i & 4) != 0) {
            j3 = Long.MIN_VALUE;
        } else {
            j3 = j;
        }
        if ((i & 8) == 0) {
            j4 = j2;
        }
        return AnimationState(f, f2, j3, j4, (i & 16) != 0 ? false : z);
    }

    public static final AnimationState<Float, AnimationVector1D> AnimationState(float initialValue, float initialVelocity, long lastFrameTimeNanos, long finishedTimeNanos, boolean isRunning) {
        return new AnimationState(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(initialValue), AnimationVectorsKt.AnimationVector(initialVelocity), lastFrameTimeNanos, finishedTimeNanos, isRunning);
    }

    public static /* synthetic */ AnimationState AnimationState$default(TwoWayConverter twoWayConverter, Object obj, Object obj2, long j, long j2, boolean z, int i, Object obj3) {
        long j3;
        long j4;
        if ((i & 8) != 0) {
            j3 = Long.MIN_VALUE;
        } else {
            j3 = j;
        }
        if ((i & 16) != 0) {
            j4 = Long.MIN_VALUE;
        } else {
            j4 = j2;
        }
        return AnimationState(twoWayConverter, obj, obj2, j3, j4, (i & 32) != 0 ? false : z);
    }

    public static final <T, V extends AnimationVector> AnimationState<T, V> AnimationState(TwoWayConverter<T, V> typeConverter, T initialValue, T initialVelocity, long lastFrameTimeNanos, long finishedTimeNanos, boolean isRunning) {
        TwoWayConverter<T, V> twoWayConverter = typeConverter;
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        T t = initialVelocity;
        return new AnimationState(typeConverter, initialValue, (AnimationVector) typeConverter.getConvertToVector().invoke(initialVelocity), lastFrameTimeNanos, finishedTimeNanos, isRunning);
    }

    public static final <T, V extends AnimationVector> V createZeroVectorFrom(TwoWayConverter<T, V> $this$createZeroVectorFrom, T value) {
        Intrinsics.checkNotNullParameter($this$createZeroVectorFrom, "<this>");
        return AnimationVectorsKt.newInstance((AnimationVector) $this$createZeroVectorFrom.getConvertToVector().invoke(value));
    }
}
