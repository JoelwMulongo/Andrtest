package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B7\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00070\u0005\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ-\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001dR\u0014\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001e"}, d2 = {"Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "keyframes", "", "", "Lkotlin/Pair;", "Landroidx/compose/animation/core/Easing;", "durationMillis", "delayMillis", "(Ljava/util/Map;II)V", "getDelayMillis", "()I", "getDurationMillis", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "init", "", "value", "(Landroidx/compose/animation/core/AnimationVector;)V", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorizedAnimationSpec.kt */
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private final int delayMillis;
    private final int durationMillis;
    private final Map<Integer, Pair<V, Easing>> keyframes;
    private V valueVector;
    private V velocityVector;

    public VectorizedKeyframesSpec(Map<Integer, ? extends Pair<? extends V, ? extends Easing>> keyframes2, int durationMillis2, int delayMillis2) {
        Intrinsics.checkNotNullParameter(keyframes2, "keyframes");
        this.keyframes = keyframes2;
        this.durationMillis = durationMillis2;
        this.delayMillis = delayMillis2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VectorizedKeyframesSpec(Map map, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, i, (i3 & 4) != 0 ? 0 : i2);
    }

    public int getDurationMillis() {
        return this.durationMillis;
    }

    public int getDelayMillis() {
        return this.delayMillis;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: androidx.compose.animation.core.Easing} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V getValueFromNanos(long r18, V r20, V r21, V r22) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            r2 = r21
            java.lang.String r3 = "initialValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "targetValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            java.lang.String r3 = "initialVelocity"
            r4 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r5 = r18 / r5
            r3 = r0
            androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec r3 = (androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec) r3
            long r7 = androidx.compose.animation.core.VectorizedAnimationSpecKt.clampPlayTime(r3, r5)
            int r3 = (int) r7
            java.util.Map<java.lang.Integer, kotlin.Pair<V, androidx.compose.animation.core.Easing>> r7 = r0.keyframes
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            boolean r7 = r7.containsKey(r8)
            if (r7 == 0) goto L_0x0046
            java.util.Map<java.lang.Integer, kotlin.Pair<V, androidx.compose.animation.core.Easing>> r7 = r0.keyframes
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            java.lang.Object r7 = kotlin.collections.MapsKt.getValue(r7, r8)
            kotlin.Pair r7 = (kotlin.Pair) r7
            java.lang.Object r7 = r7.getFirst()
            androidx.compose.animation.core.AnimationVector r7 = (androidx.compose.animation.core.AnimationVector) r7
            return r7
        L_0x0046:
            int r7 = r17.getDurationMillis()
            if (r3 < r7) goto L_0x004d
            return r2
        L_0x004d:
            if (r3 > 0) goto L_0x0050
            return r1
        L_0x0050:
            r7 = 0
            r8 = r20
            r9 = r21
            int r10 = r17.getDurationMillis()
            androidx.compose.animation.core.Easing r11 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            java.util.Map<java.lang.Integer, kotlin.Pair<V, androidx.compose.animation.core.Easing>> r12 = r0.keyframes
            java.util.Set r12 = r12.entrySet()
            java.util.Iterator r12 = r12.iterator()
        L_0x0067:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x00a4
            java.lang.Object r13 = r12.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            java.lang.Object r14 = r13.getKey()
            java.lang.Number r14 = (java.lang.Number) r14
            int r14 = r14.intValue()
            java.lang.Object r13 = r13.getValue()
            kotlin.Pair r13 = (kotlin.Pair) r13
            if (r3 <= r14) goto L_0x0097
            if (r14 < r7) goto L_0x0097
            r7 = r14
            java.lang.Object r15 = r13.getFirst()
            r8 = r15
            androidx.compose.animation.core.AnimationVector r8 = (androidx.compose.animation.core.AnimationVector) r8
            java.lang.Object r15 = r13.getSecond()
            r11 = r15
            androidx.compose.animation.core.Easing r11 = (androidx.compose.animation.core.Easing) r11
            goto L_0x0067
        L_0x0097:
            if (r3 >= r14) goto L_0x0067
            if (r14 > r10) goto L_0x0067
            r10 = r14
            java.lang.Object r15 = r13.getFirst()
            r9 = r15
            androidx.compose.animation.core.AnimationVector r9 = (androidx.compose.animation.core.AnimationVector) r9
            goto L_0x0067
        L_0x00a4:
            int r12 = r3 - r7
            float r12 = (float) r12
            int r13 = r10 - r7
            float r13 = (float) r13
            float r12 = r12 / r13
            float r12 = r11.transform(r12)
            r0.init(r1)
            r13 = 0
            int r14 = r8.getSize$animation_core_release()
        L_0x00b8:
            java.lang.String r16 = "valueVector"
            if (r13 >= r14) goto L_0x00db
            V r15 = r0.valueVector
            if (r15 != 0) goto L_0x00c5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)
            r15 = 0
        L_0x00c5:
            float r1 = r8.get$animation_core_release(r13)
            float r2 = r9.get$animation_core_release(r13)
            float r1 = androidx.compose.animation.core.VectorConvertersKt.lerp(r1, r2, r12)
            r15.set$animation_core_release(r13, r1)
            int r13 = r13 + 1
            r1 = r20
            r2 = r21
            goto L_0x00b8
        L_0x00db:
            V r1 = r0.valueVector
            if (r1 != 0) goto L_0x00e4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r16)
            r15 = 0
            goto L_0x00e5
        L_0x00e4:
            r15 = r1
        L_0x00e5:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.VectorizedKeyframesSpec.getValueFromNanos(long, androidx.compose.animation.core.AnimationVector, androidx.compose.animation.core.AnimationVector, androidx.compose.animation.core.AnimationVector):androidx.compose.animation.core.AnimationVector");
    }

    private final void init(V value) {
        if (this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(value);
            this.velocityVector = AnimationVectorsKt.newInstance(value);
        }
    }

    public V getVelocityFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        V v = initialValue;
        V v2 = initialVelocity;
        Intrinsics.checkNotNullParameter(v, "initialValue");
        Intrinsics.checkNotNullParameter(targetValue, "targetValue");
        Intrinsics.checkNotNullParameter(v2, "initialVelocity");
        long clampedPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, playTimeNanos / AnimationKt.MillisToNanos);
        if (clampedPlayTime <= 0) {
            return v2;
        }
        V v3 = initialValue;
        V v4 = targetValue;
        V v5 = initialVelocity;
        AnimationVector startNum = VectorizedAnimationSpecKt.getValueFromMillis(this, clampedPlayTime - 1, v3, v4, v5);
        AnimationVector endNum = VectorizedAnimationSpecKt.getValueFromMillis(this, clampedPlayTime, v3, v4, v5);
        init(v);
        int i = 0;
        int size$animation_core_release = startNum.getSize$animation_core_release();
        while (true) {
            V v6 = null;
            if (i >= size$animation_core_release) {
                break;
            }
            V v7 = this.velocityVector;
            if (v7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            } else {
                v6 = v7;
            }
            v6.set$animation_core_release(i, (startNum.get$animation_core_release(i) - endNum.get$animation_core_release(i)) * 1000.0f);
            i++;
        }
        V v8 = this.velocityVector;
        if (v8 != null) {
            return v8;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }
}
