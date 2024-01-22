package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\u001a,\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0000\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\n\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\n\u001a\u0015\u0010\f\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\n¨\u0006\r"}, d2 = {"complexQuadraticFormula", "Lkotlin/Pair;", "Landroidx/compose/animation/core/ComplexDouble;", "a", "", "b", "c", "complexSqrt", "num", "minus", "other", "plus", "times", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComplexDouble.kt */
public final class ComplexDoubleKt {
    public static final Pair<ComplexDouble, ComplexDouble> complexQuadraticFormula(double a, double b, double c) {
        double d = b;
        ComplexDouble this_$iv$iv = complexSqrt((d * d) - ((a * 4.0d) * c));
        this_$iv$iv._real = this_$iv$iv._real + (-d);
        double other$iv = a * 2.0d;
        this_$iv$iv._real = this_$iv$iv._real / other$iv;
        this_$iv$iv._imaginary = this_$iv$iv._imaginary / other$iv;
        ComplexDouble firstRoot = this_$iv$iv;
        ComplexDouble this_$iv$iv2 = complexSqrt((d * d) - ((a * 4.0d) * c));
        double d2 = (double) -1;
        this_$iv$iv2._real = this_$iv$iv2._real * d2;
        this_$iv$iv2._imaginary = this_$iv$iv2._imaginary * d2;
        ComplexDouble this_$iv$iv$iv = this_$iv$iv2;
        this_$iv$iv$iv._real = this_$iv$iv$iv._real + (-d);
        double other$iv2 = 2.0d * a;
        ComplexDouble this_$iv = this_$iv$iv$iv;
        this_$iv._real = this_$iv._real / other$iv2;
        this_$iv._imaginary = this_$iv._imaginary / other$iv2;
        return TuplesKt.to(firstRoot, this_$iv);
    }

    public static final ComplexDouble complexSqrt(double num) {
        if (num < 0.0d) {
            return new ComplexDouble(0.0d, Math.sqrt(Math.abs(num)));
        }
        return new ComplexDouble(Math.sqrt(num), 0.0d);
    }

    public static final ComplexDouble plus(double $this$plus, ComplexDouble other) {
        Intrinsics.checkNotNullParameter(other, "other");
        ComplexDouble this_$iv = other;
        this_$iv._real = this_$iv._real + $this$plus;
        return this_$iv;
    }

    public static final ComplexDouble minus(double $this$minus, ComplexDouble other) {
        Intrinsics.checkNotNullParameter(other, "other");
        ComplexDouble other$iv = other;
        double d = (double) -1;
        other$iv._real = other$iv._real * d;
        other$iv._imaginary = other$iv._imaginary * d;
        ComplexDouble this_$iv$iv = other$iv;
        this_$iv$iv._real = this_$iv$iv._real + $this$minus;
        return this_$iv$iv;
    }

    public static final ComplexDouble times(double $this$times, ComplexDouble other) {
        Intrinsics.checkNotNullParameter(other, "other");
        ComplexDouble this_$iv = other;
        this_$iv._real = this_$iv._real * $this$times;
        this_$iv._imaginary = this_$iv._imaginary * $this$times;
        return this_$iv;
    }
}
