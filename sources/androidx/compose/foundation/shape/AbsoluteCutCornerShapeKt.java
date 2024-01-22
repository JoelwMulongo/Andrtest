package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a;\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u000e\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\u000e2\b\b\u0002\u0010\n\u001a\u00020\u000e2\b\b\u0002\u0010\u000b\u001a\u00020\u000e\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"AbsoluteCutCornerShape", "Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "corner", "Landroidx/compose/foundation/shape/CornerSize;", "size", "Landroidx/compose/ui/unit/Dp;", "AbsoluteCutCornerShape-0680j_4", "(F)Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "topLeft", "topRight", "bottomRight", "bottomLeft", "AbsoluteCutCornerShape-a9UjIt4", "(FFFF)Landroidx/compose/foundation/shape/AbsoluteCutCornerShape;", "", "percent", "", "topLeftPercent", "topRightPercent", "bottomRightPercent", "bottomLeftPercent", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AbsoluteCutCornerShape.kt */
public final class AbsoluteCutCornerShapeKt {
    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(CornerSize corner) {
        Intrinsics.checkNotNullParameter(corner, "corner");
        return new AbsoluteCutCornerShape(corner, corner, corner, corner);
    }

    /* renamed from: AbsoluteCutCornerShape-0680j_4  reason: not valid java name */
    public static final AbsoluteCutCornerShape m1092AbsoluteCutCornerShape0680j_4(float size) {
        return AbsoluteCutCornerShape(CornerSizeKt.m1103CornerSize0680j_4(size));
    }

    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(float size) {
        return AbsoluteCutCornerShape(CornerSizeKt.CornerSize(size));
    }

    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(int percent) {
        return AbsoluteCutCornerShape(CornerSizeKt.CornerSize(percent));
    }

    /* renamed from: AbsoluteCutCornerShape-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ AbsoluteCutCornerShape m1094AbsoluteCutCornerShapea9UjIt4$default(float $this$dp$iv, float $this$dp$iv2, float $this$dp$iv3, float $this$dp$iv4, int i, Object obj) {
        if ((i & 1) != 0) {
            $this$dp$iv = Dp.m5986constructorimpl((float) 0);
        }
        if ((i & 2) != 0) {
            $this$dp$iv2 = Dp.m5986constructorimpl((float) 0);
        }
        if ((i & 4) != 0) {
            $this$dp$iv3 = Dp.m5986constructorimpl((float) 0);
        }
        if ((i & 8) != 0) {
            $this$dp$iv4 = Dp.m5986constructorimpl((float) 0);
        }
        return m1093AbsoluteCutCornerShapea9UjIt4($this$dp$iv, $this$dp$iv2, $this$dp$iv3, $this$dp$iv4);
    }

    /* renamed from: AbsoluteCutCornerShape-a9UjIt4  reason: not valid java name */
    public static final AbsoluteCutCornerShape m1093AbsoluteCutCornerShapea9UjIt4(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        return new AbsoluteCutCornerShape(CornerSizeKt.m1103CornerSize0680j_4(topLeft), CornerSizeKt.m1103CornerSize0680j_4(topRight), CornerSizeKt.m1103CornerSize0680j_4(bottomRight), CornerSizeKt.m1103CornerSize0680j_4(bottomLeft));
    }

    public static /* synthetic */ AbsoluteCutCornerShape AbsoluteCutCornerShape$default(float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        return AbsoluteCutCornerShape(f, f2, f3, f4);
    }

    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        return new AbsoluteCutCornerShape(CornerSizeKt.CornerSize(topLeft), CornerSizeKt.CornerSize(topRight), CornerSizeKt.CornerSize(bottomRight), CornerSizeKt.CornerSize(bottomLeft));
    }

    public static /* synthetic */ AbsoluteCutCornerShape AbsoluteCutCornerShape$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        return AbsoluteCutCornerShape(i, i2, i3, i4);
    }

    public static final AbsoluteCutCornerShape AbsoluteCutCornerShape(int topLeftPercent, int topRightPercent, int bottomRightPercent, int bottomLeftPercent) {
        return new AbsoluteCutCornerShape(CornerSizeKt.CornerSize(topLeftPercent), CornerSizeKt.CornerSize(topRightPercent), CornerSizeKt.CornerSize(bottomRightPercent), CornerSizeKt.CornerSize(bottomLeftPercent));
    }
}
