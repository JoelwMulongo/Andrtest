package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a-\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0003H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"CornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "x", "", "y", "(FF)J", "lerp", "start", "stop", "fraction", "lerp-3Ry4LBc", "(JJF)J", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CornerRadius.kt */
public final class CornerRadiusKt {
    public static final long CornerRadius(float x, float y) {
        return CornerRadius.m2884constructorimpl((((long) Float.floatToIntBits(x)) << 32) | (4294967295L & ((long) Float.floatToIntBits(y))));
    }

    public static /* synthetic */ long CornerRadius$default(float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = f;
        }
        return CornerRadius(f, f2);
    }

    /* renamed from: lerp-3Ry4LBc  reason: not valid java name */
    public static final long m2901lerp3Ry4LBc(long start, long stop, float fraction) {
        return CornerRadius(MathHelpersKt.lerp(CornerRadius.m2890getXimpl(start), CornerRadius.m2890getXimpl(stop), fraction), MathHelpersKt.lerp(CornerRadius.m2891getYimpl(start), CornerRadius.m2891getYimpl(stop), fraction));
    }
}
