package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004BE\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\fBE\b\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u000eJ\u0015\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010$J\u0015\u0010%\u001a\u00028\u00012\u0006\u0010#\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020(H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00028\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0013\u0010\t\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u00028\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u000b\u001a\u00028\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0016\u0010\n\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0018R\u0010\u0010\u001f\u001a\u00028\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006)"}, d2 = {"Landroidx/compose/animation/core/TargetBasedAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/Animation;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "initialValue", "targetValue", "initialVelocityVector", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;)V", "getAnimationSpec$animation_core_release", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "durationNanos", "", "getDurationNanos", "()J", "endVelocity", "Landroidx/compose/animation/core/AnimationVector;", "getInitialValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "initialValueVector", "isInfinite", "", "()Z", "getTargetValue", "targetValueVector", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getValueFromNanos", "playTimeNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "toString", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Animation.kt */
public final class TargetBasedAnimation<T, V extends AnimationVector> implements Animation<T, V> {
    public static final int $stable = 0;
    private final VectorizedAnimationSpec<V> animationSpec;
    private final long durationNanos;
    private final V endVelocity;
    private final T initialValue;
    private final V initialValueVector;
    private final V initialVelocityVector;
    private final T targetValue;
    private final V targetValueVector;
    private final TwoWayConverter<T, V> typeConverter;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x003c, code lost:
        r2 = androidx.compose.animation.core.AnimationVectorsKt.copy(r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TargetBasedAnimation(androidx.compose.animation.core.VectorizedAnimationSpec<V> r6, androidx.compose.animation.core.TwoWayConverter<T, V> r7, T r8, T r9, V r10) {
        /*
            r5 = this;
            java.lang.String r0 = "animationSpec"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "typeConverter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r5.<init>()
            r5.animationSpec = r6
            r5.typeConverter = r7
            r5.initialValue = r8
            r5.targetValue = r9
            androidx.compose.animation.core.TwoWayConverter r0 = r5.getTypeConverter()
            kotlin.jvm.functions.Function1 r0 = r0.getConvertToVector()
            java.lang.Object r0 = r0.invoke(r8)
            androidx.compose.animation.core.AnimationVector r0 = (androidx.compose.animation.core.AnimationVector) r0
            r5.initialValueVector = r0
            androidx.compose.animation.core.TwoWayConverter r1 = r5.getTypeConverter()
            kotlin.jvm.functions.Function1 r1 = r1.getConvertToVector()
            java.lang.Object r2 = r5.getTargetValue()
            java.lang.Object r1 = r1.invoke(r2)
            androidx.compose.animation.core.AnimationVector r1 = (androidx.compose.animation.core.AnimationVector) r1
            r5.targetValueVector = r1
            if (r10 == 0) goto L_0x0042
            androidx.compose.animation.core.AnimationVector r2 = androidx.compose.animation.core.AnimationVectorsKt.copy(r10)
            if (r2 != 0) goto L_0x0054
        L_0x0042:
            androidx.compose.animation.core.TwoWayConverter r2 = r5.getTypeConverter()
            kotlin.jvm.functions.Function1 r2 = r2.getConvertToVector()
            java.lang.Object r2 = r2.invoke(r8)
            androidx.compose.animation.core.AnimationVector r2 = (androidx.compose.animation.core.AnimationVector) r2
            androidx.compose.animation.core.AnimationVector r2 = androidx.compose.animation.core.AnimationVectorsKt.newInstance(r2)
        L_0x0054:
            r5.initialVelocityVector = r2
            long r3 = r6.getDurationNanos(r0, r1, r2)
            r5.durationNanos = r3
            androidx.compose.animation.core.AnimationVector r0 = r6.getEndVelocity(r0, r1, r2)
            r5.endVelocity = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.TargetBasedAnimation.<init>(androidx.compose.animation.core.VectorizedAnimationSpec, androidx.compose.animation.core.TwoWayConverter, java.lang.Object, java.lang.Object, androidx.compose.animation.core.AnimationVector):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TargetBasedAnimation(VectorizedAnimationSpec vectorizedAnimationSpec, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(vectorizedAnimationSpec, twoWayConverter, obj, obj2, (i & 16) != 0 ? null : animationVector);
    }

    public final VectorizedAnimationSpec<V> getAnimationSpec$animation_core_release() {
        return this.animationSpec;
    }

    public TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public final T getInitialValue() {
        return this.initialValue;
    }

    public T getTargetValue() {
        return this.targetValue;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TargetBasedAnimation(AnimationSpec animationSpec2, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(animationSpec2, twoWayConverter, obj, obj2, (i & 16) != 0 ? null : animationVector);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TargetBasedAnimation(AnimationSpec<T> animationSpec2, TwoWayConverter<T, V> typeConverter2, T initialValue2, T targetValue2, V initialVelocityVector2) {
        this(animationSpec2.vectorize(typeConverter2), typeConverter2, initialValue2, targetValue2, initialVelocityVector2);
        Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
        Intrinsics.checkNotNullParameter(typeConverter2, "typeConverter");
    }

    public boolean isInfinite() {
        return this.animationSpec.isInfinite();
    }

    public T getValueFromNanos(long playTimeNanos) {
        if (isFinishedFromNanos(playTimeNanos)) {
            return getTargetValue();
        }
        AnimationVector it = this.animationSpec.getValueFromNanos(playTimeNanos, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
        int i = 0;
        int size$animation_core_release = it.getSize$animation_core_release();
        while (i < size$animation_core_release) {
            if (!Float.isNaN(it.get$animation_core_release(i))) {
                i++;
            } else {
                throw new IllegalStateException(("AnimationVector cannot contain a NaN. " + it + ". Animation: " + this + ", playTimeNanos: " + playTimeNanos).toString());
            }
        }
        return getTypeConverter().getConvertFromVector().invoke(it);
    }

    public long getDurationNanos() {
        return this.durationNanos;
    }

    public V getVelocityVectorFromNanos(long playTimeNanos) {
        if (isFinishedFromNanos(playTimeNanos)) {
            return this.endVelocity;
        }
        return this.animationSpec.getVelocityFromNanos(playTimeNanos, this.initialValueVector, this.targetValueVector, this.initialVelocityVector);
    }

    public String toString() {
        return "TargetBasedAnimation: " + this.initialValue + " -> " + getTargetValue() + ",initial velocity: " + this.initialVelocityVector + ", duration: " + AnimationKt.getDurationMillis(this) + " ms,animationSpec: " + this.animationSpec;
    }
}
