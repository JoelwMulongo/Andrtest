package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a,\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b\u001aa\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00110\u000f\"\u0004\b\u0000\u0010\u0010\"\b\b\u0001\u0010\u0011*\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00110\u00152\u0006\u0010\f\u001a\u0002H\u00102\u0006\u0010\u0016\u001a\u0002H\u00102\u0006\u0010\r\u001a\u0002H\u0010¢\u0006\u0002\u0010\u0017\u001aC\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00110\u000f\"\b\b\u0000\u0010\u0011*\u00020\u0012*\b\u0012\u0004\u0012\u0002H\u00110\u00192\u0006\u0010\f\u001a\u0002H\u00112\u0006\u0010\u0016\u001a\u0002H\u00112\u0006\u0010\r\u001a\u0002H\u0011¢\u0006\u0002\u0010\u001a\u001a3\u0010\u001b\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010\"\b\b\u0001\u0010\u0011*\u00020\u0012*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00110\u00032\u0006\u0010\u001c\u001a\u00020\u0001¢\u0006\u0002\u0010\u001d\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\" \u0010\u0002\u001a\u00020\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001e"}, d2 = {"MillisToNanos", "", "durationMillis", "Landroidx/compose/animation/core/Animation;", "getDurationMillis", "(Landroidx/compose/animation/core/Animation;)J", "DecayAnimation", "Landroidx/compose/animation/core/DecayAnimation;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animationSpec", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "initialValue", "initialVelocity", "TargetBasedAnimation", "Landroidx/compose/animation/core/TargetBasedAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/AnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "targetValue", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/animation/core/TargetBasedAnimation;", "createAnimation", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/TargetBasedAnimation;", "getVelocityFromNanos", "playTimeNanos", "(Landroidx/compose/animation/core/Animation;J)Ljava/lang/Object;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Animation.kt */
public final class AnimationKt {
    public static final long MillisToNanos = 1000000;

    public static final long getDurationMillis(Animation<?, ?> $this$durationMillis) {
        Intrinsics.checkNotNullParameter($this$durationMillis, "<this>");
        return $this$durationMillis.getDurationNanos() / MillisToNanos;
    }

    public static final <T, V extends AnimationVector> T getVelocityFromNanos(Animation<T, V> $this$getVelocityFromNanos, long playTimeNanos) {
        Intrinsics.checkNotNullParameter($this$getVelocityFromNanos, "<this>");
        return $this$getVelocityFromNanos.getTypeConverter().getConvertFromVector().invoke($this$getVelocityFromNanos.getVelocityVectorFromNanos(playTimeNanos));
    }

    public static final <V extends AnimationVector> TargetBasedAnimation<V, V> createAnimation(VectorizedAnimationSpec<V> $this$createAnimation, V initialValue, V targetValue, V initialVelocity) {
        Intrinsics.checkNotNullParameter($this$createAnimation, "<this>");
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(initialVelocity, "initialVelocity");
        return new TargetBasedAnimation($this$createAnimation, VectorConvertersKt.TwoWayConverter(AnimationKt$createAnimation$1.INSTANCE, AnimationKt$createAnimation$2.INSTANCE), initialValue, targetValue, initialVelocity);
    }

    public static final <T, V extends AnimationVector> TargetBasedAnimation<T, V> TargetBasedAnimation(AnimationSpec<T> animationSpec, TwoWayConverter<T, V> typeConverter, T initialValue, T targetValue, T initialVelocity) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        return new TargetBasedAnimation(animationSpec, typeConverter, initialValue, targetValue, (AnimationVector) typeConverter.getConvertToVector().invoke(initialVelocity));
    }

    public static /* synthetic */ DecayAnimation DecayAnimation$default(FloatDecayAnimationSpec floatDecayAnimationSpec, float f, float f2, int i, Object obj) {
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        return DecayAnimation(floatDecayAnimationSpec, f, f2);
    }

    public static final DecayAnimation<Float, AnimationVector1D> DecayAnimation(FloatDecayAnimationSpec animationSpec, float initialValue, float initialVelocity) {
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new DecayAnimation<>(DecayAnimationSpecKt.generateDecayAnimationSpec(animationSpec), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(initialValue), AnimationVectorsKt.AnimationVector(initialVelocity));
    }
}
