package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u001b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a;\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u000e\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\u000e2\b\b\u0002\u0010\n\u001a\u00020\u000e2\b\b\u0002\u0010\u000b\u001a\u00020\u000e\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"AbsoluteRoundedCornerShape", "Landroidx/compose/foundation/shape/AbsoluteRoundedCornerShape;", "corner", "Landroidx/compose/foundation/shape/CornerSize;", "size", "Landroidx/compose/ui/unit/Dp;", "AbsoluteRoundedCornerShape-0680j_4", "(F)Landroidx/compose/foundation/shape/AbsoluteRoundedCornerShape;", "topLeft", "topRight", "bottomRight", "bottomLeft", "AbsoluteRoundedCornerShape-a9UjIt4", "(FFFF)Landroidx/compose/foundation/shape/AbsoluteRoundedCornerShape;", "", "percent", "", "topLeftPercent", "topRightPercent", "bottomRightPercent", "bottomLeftPercent", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AbsoluteRoundedCornerShape.kt */
public final class AbsoluteRoundedCornerShapeKt {
    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(CornerSize corner) {
        Intrinsics.checkNotNullParameter(corner, "corner");
        return new AbsoluteRoundedCornerShape(corner, corner, corner, corner);
    }

    /* renamed from: AbsoluteRoundedCornerShape-0680j_4  reason: not valid java name */
    public static final AbsoluteRoundedCornerShape m1097AbsoluteRoundedCornerShape0680j_4(float size) {
        return AbsoluteRoundedCornerShape(CornerSizeKt.m1103CornerSize0680j_4(size));
    }

    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(float size) {
        return AbsoluteRoundedCornerShape(CornerSizeKt.CornerSize(size));
    }

    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(int percent) {
        return AbsoluteRoundedCornerShape(CornerSizeKt.CornerSize(percent));
    }

    /* renamed from: AbsoluteRoundedCornerShape-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ AbsoluteRoundedCornerShape m1099AbsoluteRoundedCornerShapea9UjIt4$default(float $this$dp$iv, float $this$dp$iv2, float $this$dp$iv3, float $this$dp$iv4, int i, Object obj) {
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
        return m1098AbsoluteRoundedCornerShapea9UjIt4($this$dp$iv, $this$dp$iv2, $this$dp$iv3, $this$dp$iv4);
    }

    /* renamed from: AbsoluteRoundedCornerShape-a9UjIt4  reason: not valid java name */
    public static final AbsoluteRoundedCornerShape m1098AbsoluteRoundedCornerShapea9UjIt4(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        return new AbsoluteRoundedCornerShape(CornerSizeKt.m1103CornerSize0680j_4(topLeft), CornerSizeKt.m1103CornerSize0680j_4(topRight), CornerSizeKt.m1103CornerSize0680j_4(bottomRight), CornerSizeKt.m1103CornerSize0680j_4(bottomLeft));
    }

    public static /* synthetic */ AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape$default(float f, float f2, float f3, float f4, int i, Object obj) {
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
        return AbsoluteRoundedCornerShape(f, f2, f3, f4);
    }

    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(float topLeft, float topRight, float bottomRight, float bottomLeft) {
        return new AbsoluteRoundedCornerShape(CornerSizeKt.CornerSize(topLeft), CornerSizeKt.CornerSize(topRight), CornerSizeKt.CornerSize(bottomRight), CornerSizeKt.CornerSize(bottomLeft));
    }

    public static /* synthetic */ AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape$default(int i, int i2, int i3, int i4, int i5, Object obj) {
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
        return AbsoluteRoundedCornerShape(i, i2, i3, i4);
    }

    public static final AbsoluteRoundedCornerShape AbsoluteRoundedCornerShape(int topLeftPercent, int topRightPercent, int bottomRightPercent, int bottomLeftPercent) {
        return new AbsoluteRoundedCornerShape(CornerSizeKt.CornerSize(topLeftPercent), CornerSizeKt.CornerSize(topRightPercent), CornerSizeKt.CornerSize(bottomRightPercent), CornerSizeKt.CornerSize(bottomLeftPercent));
    }
}
