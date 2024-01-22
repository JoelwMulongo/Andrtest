package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000b\u001a4\u0010\f\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a<\u0010\u0012\u001a\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a4\u0010\u0014\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a4\u0010\u0015\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a9\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019H\b\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0003H\b¨\u0006\u001d"}, d2 = {"estimateAnimationDurationMillis", "", "stiffness", "", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", "springConstant", "dampingCoefficient", "mass", "", "estimateCriticallyDamped", "roots", "Lkotlin/Pair;", "Landroidx/compose/animation/core/ComplexDouble;", "p0", "v0", "estimateDurationInternal", "initialPosition", "estimateOverDamped", "estimateUnderDamped", "iterateNewtonsMethod", "x", "fn", "Lkotlin/Function1;", "fnPrime", "isNotFinite", "", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SpringEstimation.kt */
public final class SpringEstimationKt {
    public static final long estimateAnimationDurationMillis(float stiffness, float dampingRatio, float initialVelocity, float initialDisplacement, float delta) {
        return estimateAnimationDurationMillis((double) stiffness, (double) dampingRatio, (double) initialVelocity, (double) initialDisplacement, (double) delta);
    }

    public static final long estimateAnimationDurationMillis(double stiffness, double dampingRatio, double initialVelocity, double initialDisplacement, double delta) {
        return estimateDurationInternal(ComplexDoubleKt.complexQuadraticFormula(1.0d, 2.0d * dampingRatio * Math.sqrt(stiffness), stiffness), dampingRatio, initialVelocity, initialDisplacement, delta);
    }

    public static final long estimateAnimationDurationMillis(double springConstant, double dampingCoefficient, double mass, double initialVelocity, double initialDisplacement, double delta) {
        return estimateDurationInternal(ComplexDoubleKt.complexQuadraticFormula(mass, dampingCoefficient, springConstant), dampingCoefficient / (Math.sqrt(springConstant * mass) * 2.0d), initialVelocity, initialDisplacement, delta);
    }

    private static final double estimateUnderDamped(Pair<ComplexDouble, ComplexDouble> roots, double p0, double v0, double delta) {
        double r = roots.getFirst().getReal();
        double c1 = p0;
        double c2 = (v0 - (r * c1)) / roots.getFirst().getImaginary();
        return Math.log(delta / Math.sqrt((c1 * c1) + (c2 * c2))) / r;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e6 A[LOOP:0: B:38:0x00d9->B:42:0x00e6, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final double estimateCriticallyDamped(kotlin.Pair<androidx.compose.animation.core.ComplexDouble, androidx.compose.animation.core.ComplexDouble> r30, double r31, double r33, double r35) {
        /*
            r0 = r35
            java.lang.Object r2 = r30.getFirst()
            androidx.compose.animation.core.ComplexDouble r2 = (androidx.compose.animation.core.ComplexDouble) r2
            double r12 = r2.getReal()
            r14 = r31
            double r2 = r12 * r14
            double r16 = r33 - r2
            double r2 = r0 / r14
            double r2 = java.lang.Math.abs(r2)
            double r2 = java.lang.Math.log(r2)
            double r9 = r2 / r12
            double r2 = r0 / r16
            double r2 = java.lang.Math.abs(r2)
            double r2 = java.lang.Math.log(r2)
            double r2 = estimateCriticallyDamped$t2Iterate(r2, r12)
            double r7 = r2 / r12
            r2 = r9
            r4 = 0
            boolean r5 = java.lang.Double.isInfinite(r2)
            r6 = 0
            r11 = 1
            if (r5 != 0) goto L_0x0041
            boolean r5 = java.lang.Double.isNaN(r2)
            if (r5 != 0) goto L_0x0041
            r5 = r11
            goto L_0x0042
        L_0x0041:
            r5 = r6
        L_0x0042:
            r5 = r5 ^ r11
            if (r5 == 0) goto L_0x0047
            r2 = r7
            goto L_0x0060
        L_0x0047:
            r2 = r7
            r4 = 0
            boolean r5 = java.lang.Double.isInfinite(r2)
            if (r5 != 0) goto L_0x0056
            boolean r5 = java.lang.Double.isNaN(r2)
            if (r5 != 0) goto L_0x0056
            r6 = r11
        L_0x0056:
            r5 = r6 ^ 1
            if (r5 == 0) goto L_0x005c
            r2 = r9
            goto L_0x0060
        L_0x005c:
            double r2 = java.lang.Math.max(r9, r7)
        L_0x0060:
            r18 = r2
            double r2 = r12 * r14
            double r2 = r2 + r16
            double r2 = -r2
            double r4 = r12 * r16
            double r20 = r2 / r4
            boolean r2 = java.lang.Double.isNaN(r20)
            if (r2 != 0) goto L_0x00b1
            r22 = 0
            int r2 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r2 > 0) goto L_0x007c
            r24 = r7
            r26 = r9
            goto L_0x00b5
        L_0x007c:
            int r2 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r2 <= 0) goto L_0x00a2
            r3 = r14
            r5 = r12
            r24 = r7
            r7 = r20
            r26 = r9
            r9 = r16
            double r2 = estimateCriticallyDamped$xInflection(r3, r5, r7, r9)
            double r2 = -r2
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x00a6
            int r2 = (r16 > r22 ? 1 : (r16 == r22 ? 0 : -1))
            if (r2 >= 0) goto L_0x009f
            int r2 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r2 <= 0) goto L_0x009f
            r2 = 0
            r18 = r2
        L_0x009f:
            double r2 = -r0
            r10 = r2
            goto L_0x00b7
        L_0x00a2:
            r24 = r7
            r26 = r9
        L_0x00a6:
            r2 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r2 = r2 / r12
            double r2 = -r2
            double r4 = r14 / r16
            double r2 = r2 - r4
            r18 = r2
            r10 = r0
            goto L_0x00b7
        L_0x00b1:
            r24 = r7
            r26 = r9
        L_0x00b5:
            double r2 = -r0
            r10 = r2
        L_0x00b7:
            androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fn$1 r2 = new androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fn$1
            r3 = r2
            r4 = r14
            r6 = r16
            r8 = r12
            r3.<init>(r4, r6, r8, r10)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fnPrime$1 r22 = new androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fnPrime$1
            r3 = r22
            r4 = r16
            r6 = r12
            r8 = r14
            r3.<init>(r4, r6, r8)
            r3 = r22
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r4 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            r6 = 0
        L_0x00d9:
            r7 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r7 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x011a
            r7 = 100
            if (r6 >= r7) goto L_0x011a
            int r6 = r6 + 1
            r7 = r18
            r9 = 0
            java.lang.Double r0 = java.lang.Double.valueOf(r18)
            java.lang.Object r0 = r2.invoke(r0)
            java.lang.Number r0 = (java.lang.Number) r0
            double r0 = r0.doubleValue()
            r22 = r2
            java.lang.Double r2 = java.lang.Double.valueOf(r18)
            java.lang.Object r2 = r3.invoke(r2)
            java.lang.Number r2 = (java.lang.Number) r2
            double r28 = r2.doubleValue()
            double r0 = r0 / r28
            double r0 = r18 - r0
            r18 = r0
            double r0 = r7 - r18
            double r4 = java.lang.Math.abs(r0)
            r0 = r35
            r2 = r22
            goto L_0x00d9
        L_0x011a:
            r22 = r2
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SpringEstimationKt.estimateCriticallyDamped(kotlin.Pair, double, double, double):double");
    }

    private static final double estimateCriticallyDamped$t2Iterate(double guess, double r) {
        double t = guess;
        for (int i = 0; i < 6; i++) {
            t = guess - Math.log(Math.abs(t / r));
        }
        return t;
    }

    private static final double estimateCriticallyDamped$xInflection(double c1, double r, double tInflection, double c2) {
        return (Math.exp(r * tInflection) * c1) + (c2 * tInflection * Math.exp(r * tInflection));
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x010f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final double estimateOverDamped(kotlin.Pair<androidx.compose.animation.core.ComplexDouble, androidx.compose.animation.core.ComplexDouble> r32, double r33, double r35, double r37) {
        /*
            r0 = r37
            java.lang.Object r2 = r32.getFirst()
            androidx.compose.animation.core.ComplexDouble r2 = (androidx.compose.animation.core.ComplexDouble) r2
            double r14 = r2.getReal()
            java.lang.Object r2 = r32.getSecond()
            androidx.compose.animation.core.ComplexDouble r2 = (androidx.compose.animation.core.ComplexDouble) r2
            double r16 = r2.getReal()
            double r2 = r14 * r33
            double r2 = r2 - r35
            double r4 = r14 - r16
            double r11 = r2 / r4
            double r18 = r33 - r11
            double r2 = r0 / r18
            double r2 = java.lang.Math.abs(r2)
            double r2 = java.lang.Math.log(r2)
            double r9 = r2 / r14
            double r2 = r0 / r11
            double r2 = java.lang.Math.abs(r2)
            double r2 = java.lang.Math.log(r2)
            double r7 = r2 / r16
            r2 = r9
            r4 = 0
            boolean r5 = java.lang.Double.isInfinite(r2)
            r6 = 0
            r13 = 1
            if (r5 != 0) goto L_0x004b
            boolean r5 = java.lang.Double.isNaN(r2)
            if (r5 != 0) goto L_0x004b
            r5 = r13
            goto L_0x004c
        L_0x004b:
            r5 = r6
        L_0x004c:
            r5 = r5 ^ r13
            if (r5 == 0) goto L_0x0051
            r2 = r7
            goto L_0x006a
        L_0x0051:
            r2 = r7
            r4 = 0
            boolean r5 = java.lang.Double.isInfinite(r2)
            if (r5 != 0) goto L_0x0060
            boolean r5 = java.lang.Double.isNaN(r2)
            if (r5 != 0) goto L_0x0060
            r6 = r13
        L_0x0060:
            r5 = r6 ^ 1
            if (r5 == 0) goto L_0x0066
            r2 = r9
            goto L_0x006a
        L_0x0066:
            double r2 = java.lang.Math.max(r9, r7)
        L_0x006a:
            r20 = r2
            double r2 = r18 * r14
            double r4 = -r11
            double r4 = r4 * r16
            double r2 = r2 / r4
            double r2 = java.lang.Math.log(r2)
            double r4 = r16 - r14
            double r22 = r2 / r4
            boolean r2 = java.lang.Double.isNaN(r22)
            if (r2 != 0) goto L_0x00d1
            r24 = 0
            int r2 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r2 > 0) goto L_0x008d
            r26 = r7
            r28 = r9
            r30 = r11
            goto L_0x00d7
        L_0x008d:
            int r2 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r2 <= 0) goto L_0x00b7
            r3 = r18
            r5 = r14
            r26 = r7
            r7 = r22
            r28 = r9
            r9 = r11
            r30 = r11
            r11 = r16
            double r2 = estimateOverDamped$xInflection$0(r3, r5, r7, r9, r11)
            double r2 = -r2
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x00bd
            int r2 = (r30 > r24 ? 1 : (r30 == r24 ? 0 : -1))
            if (r2 <= 0) goto L_0x00b4
            int r2 = (r18 > r24 ? 1 : (r18 == r24 ? 0 : -1))
            if (r2 >= 0) goto L_0x00b4
            r2 = 0
            r20 = r2
        L_0x00b4:
            double r2 = -r0
            r12 = r2
            goto L_0x00d9
        L_0x00b7:
            r26 = r7
            r28 = r9
            r30 = r11
        L_0x00bd:
            double r11 = r30 * r16
            double r11 = r11 * r16
            double r2 = -r11
            double r4 = r18 * r14
            double r4 = r4 * r14
            double r2 = r2 / r4
            double r2 = java.lang.Math.log(r2)
            double r4 = r14 - r16
            double r2 = r2 / r4
            r20 = r2
            r12 = r0
            goto L_0x00d9
        L_0x00d1:
            r26 = r7
            r28 = r9
            r30 = r11
        L_0x00d7:
            double r2 = -r0
            r12 = r2
        L_0x00d9:
            androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fn$1 r2 = new androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fn$1
            r3 = r2
            r4 = r18
            r6 = r14
            r8 = r30
            r10 = r16
            r3.<init>(r4, r6, r8, r10, r12)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fnPrime$1 r24 = new androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fnPrime$1
            r3 = r24
            r3.<init>(r4, r6, r8, r10)
            r3 = r24
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            java.lang.Double r4 = java.lang.Double.valueOf(r20)
            java.lang.Object r4 = r2.invoke(r4)
            java.lang.Number r4 = (java.lang.Number) r4
            double r4 = r4.doubleValue()
            double r4 = java.lang.Math.abs(r4)
            r6 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x0110
            return r20
        L_0x0110:
            r4 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            r6 = 0
        L_0x0116:
            r7 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r7 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x0152
            r7 = 100
            if (r6 >= r7) goto L_0x0152
            int r6 = r6 + 1
            r7 = r20
            r9 = 0
            java.lang.Double r10 = java.lang.Double.valueOf(r20)
            java.lang.Object r10 = r2.invoke(r10)
            java.lang.Number r10 = (java.lang.Number) r10
            double r10 = r10.doubleValue()
            java.lang.Double r0 = java.lang.Double.valueOf(r20)
            java.lang.Object r0 = r3.invoke(r0)
            java.lang.Number r0 = (java.lang.Number) r0
            double r0 = r0.doubleValue()
            double r10 = r10 / r0
            double r0 = r20 - r10
            r20 = r0
            double r0 = r7 - r20
            double r4 = java.lang.Math.abs(r0)
            r0 = r37
            goto L_0x0116
        L_0x0152:
            return r20
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SpringEstimationKt.estimateOverDamped(kotlin.Pair, double, double, double):double");
    }

    private static final double estimateOverDamped$xInflection$0(double c1, double r1, double tInflection, double c2, double r2) {
        return (Math.exp(r1 * tInflection) * c1) + (Math.exp(r2 * tInflection) * c2);
    }

    private static final long estimateDurationInternal(Pair<ComplexDouble, ComplexDouble> roots, double dampingRatio, double initialVelocity, double initialPosition, double delta) {
        double d;
        double d2 = initialVelocity;
        boolean z = true;
        if (initialPosition == 0.0d) {
            if (d2 != 0.0d) {
                z = false;
            }
            if (z) {
                return 0;
            }
        }
        double v0 = initialPosition < 0.0d ? -d2 : d2;
        double p0 = Math.abs(initialPosition);
        if (dampingRatio > 1.0d) {
            d = estimateOverDamped(roots, p0, v0, delta);
        } else if (dampingRatio < 1.0d) {
            d = estimateUnderDamped(roots, p0, v0, delta);
        } else {
            d = estimateCriticallyDamped(roots, p0, v0, delta);
        }
        return (long) (d * 1000.0d);
    }

    private static final double iterateNewtonsMethod(double x, Function1<? super Double, Double> fn, Function1<? super Double, Double> fnPrime) {
        return x - (fn.invoke(Double.valueOf(x)).doubleValue() / fnPrime.invoke(Double.valueOf(x)).doubleValue());
    }

    private static final boolean isNotFinite(double $this$isNotFinite) {
        return !(!Double.isInfinite($this$isNotFinite) && !Double.isNaN($this$isNotFinite));
    }
}
