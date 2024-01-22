package androidx.compose.ui.geometry;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\u001a#\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aC\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a;\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a6\u0010\u0019\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012\u001a\u001e\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0012\u001a\u001f\u00101\u001a\u00020\u0002*\u00020\u00022\u0006\u00102\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b\"\u0015\u0010\f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b\"\u0015\u0010\r\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u0015\u0010\u000e\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000b\"\u0015\u0010\u000f\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\"\u0015\u0010\u0010\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000b\"\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\"\u0015\u0010\u0015\u001a\u00020\u0012*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"boundingRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/geometry/RoundRect;", "getBoundingRect", "(Landroidx/compose/ui/geometry/RoundRect;)Landroidx/compose/ui/geometry/Rect;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter", "(Landroidx/compose/ui/geometry/RoundRect;)J", "isCircle", "", "(Landroidx/compose/ui/geometry/RoundRect;)Z", "isEllipse", "isEmpty", "isFinite", "isRect", "isSimple", "maxDimension", "", "getMaxDimension", "(Landroidx/compose/ui/geometry/RoundRect;)F", "minDimension", "getMinDimension", "safeInnerRect", "getSafeInnerRect", "RoundRect", "rect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "RoundRect-sniSvfs", "(Landroidx/compose/ui/geometry/Rect;J)Landroidx/compose/ui/geometry/RoundRect;", "topLeft", "topRight", "bottomRight", "bottomLeft", "RoundRect-ZAM2FJo", "(Landroidx/compose/ui/geometry/Rect;JJJJ)Landroidx/compose/ui/geometry/RoundRect;", "radiusX", "radiusY", "left", "top", "right", "bottom", "RoundRect-gG7oq9Y", "(FFFFJ)Landroidx/compose/ui/geometry/RoundRect;", "lerp", "start", "stop", "fraction", "translate", "offset", "translate-Uv8p0NA", "(Landroidx/compose/ui/geometry/RoundRect;J)Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: RoundRect.kt */
public final class RoundRectKt {
    public static final RoundRect RoundRect(float left, float top, float right, float bottom, float radiusX, float radiusY) {
        long radius = CornerRadiusKt.CornerRadius(radiusX, radiusY);
        return new RoundRect(left, top, right, bottom, radius, radius, radius, radius, (DefaultConstructorMarker) null);
    }

    /* renamed from: RoundRect-gG7oq9Y  reason: not valid java name */
    public static final RoundRect m2969RoundRectgG7oq9Y(float left, float top, float right, float bottom, long cornerRadius) {
        return RoundRect(left, top, right, bottom, CornerRadius.m2890getXimpl(cornerRadius), CornerRadius.m2891getYimpl(cornerRadius));
    }

    public static final RoundRect RoundRect(Rect rect, float radiusX, float radiusY) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), radiusX, radiusY);
    }

    /* renamed from: RoundRect-sniSvfs  reason: not valid java name */
    public static final RoundRect m2970RoundRectsniSvfs(Rect rect, long cornerRadius) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return RoundRect(rect, CornerRadius.m2890getXimpl(cornerRadius), CornerRadius.m2891getYimpl(cornerRadius));
    }

    /* renamed from: RoundRect-ZAM2FJo$default  reason: not valid java name */
    public static /* synthetic */ RoundRect m2968RoundRectZAM2FJo$default(Rect rect, long j, long j2, long j3, long j4, int i, Object obj) {
        long j5;
        long j6;
        long j7;
        if ((i & 2) != 0) {
            j5 = CornerRadius.Companion.m2900getZerokKHJgLs();
        } else {
            j5 = j;
        }
        if ((i & 4) != 0) {
            j6 = CornerRadius.Companion.m2900getZerokKHJgLs();
        } else {
            j6 = j2;
        }
        if ((i & 8) != 0) {
            j7 = CornerRadius.Companion.m2900getZerokKHJgLs();
        } else {
            j7 = j3;
        }
        return m2967RoundRectZAM2FJo(rect, j5, j6, j7, (i & 16) != 0 ? CornerRadius.Companion.m2900getZerokKHJgLs() : j4);
    }

    /* renamed from: RoundRect-ZAM2FJo  reason: not valid java name */
    public static final RoundRect m2967RoundRectZAM2FJo(Rect rect, long topLeft, long topRight, long bottomRight, long bottomLeft) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return new RoundRect(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), topLeft, topRight, bottomRight, bottomLeft, (DefaultConstructorMarker) null);
    }

    /* renamed from: translate-Uv8p0NA  reason: not valid java name */
    public static final RoundRect m2971translateUv8p0NA(RoundRect $this$translate_u2dUv8p0NA, long offset) {
        Intrinsics.checkNotNullParameter($this$translate_u2dUv8p0NA, "$this$translate");
        return new RoundRect(Offset.m2915getXimpl(offset) + $this$translate_u2dUv8p0NA.getLeft(), Offset.m2916getYimpl(offset) + $this$translate_u2dUv8p0NA.getTop(), Offset.m2915getXimpl(offset) + $this$translate_u2dUv8p0NA.getRight(), Offset.m2916getYimpl(offset) + $this$translate_u2dUv8p0NA.getBottom(), $this$translate_u2dUv8p0NA.m2965getTopLeftCornerRadiuskKHJgLs(), $this$translate_u2dUv8p0NA.m2966getTopRightCornerRadiuskKHJgLs(), $this$translate_u2dUv8p0NA.m2964getBottomRightCornerRadiuskKHJgLs(), $this$translate_u2dUv8p0NA.m2963getBottomLeftCornerRadiuskKHJgLs(), (DefaultConstructorMarker) null);
    }

    public static final Rect getBoundingRect(RoundRect $this$boundingRect) {
        Intrinsics.checkNotNullParameter($this$boundingRect, "<this>");
        return new Rect($this$boundingRect.getLeft(), $this$boundingRect.getTop(), $this$boundingRect.getRight(), $this$boundingRect.getBottom());
    }

    public static final Rect getSafeInnerRect(RoundRect $this$safeInnerRect) {
        Intrinsics.checkNotNullParameter($this$safeInnerRect, "<this>");
        return new Rect($this$safeInnerRect.getLeft() + (Math.max(CornerRadius.m2890getXimpl($this$safeInnerRect.m2963getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m2890getXimpl($this$safeInnerRect.m2965getTopLeftCornerRadiuskKHJgLs())) * 0.29289323f), $this$safeInnerRect.getTop() + (Math.max(CornerRadius.m2891getYimpl($this$safeInnerRect.m2965getTopLeftCornerRadiuskKHJgLs()), CornerRadius.m2891getYimpl($this$safeInnerRect.m2966getTopRightCornerRadiuskKHJgLs())) * 0.29289323f), $this$safeInnerRect.getRight() - (Math.max(CornerRadius.m2890getXimpl($this$safeInnerRect.m2966getTopRightCornerRadiuskKHJgLs()), CornerRadius.m2890getXimpl($this$safeInnerRect.m2964getBottomRightCornerRadiuskKHJgLs())) * 0.29289323f), $this$safeInnerRect.getBottom() - (Math.max(CornerRadius.m2891getYimpl($this$safeInnerRect.m2964getBottomRightCornerRadiuskKHJgLs()), CornerRadius.m2891getYimpl($this$safeInnerRect.m2963getBottomLeftCornerRadiuskKHJgLs())) * 0.29289323f));
    }

    public static final boolean isEmpty(RoundRect $this$isEmpty) {
        Intrinsics.checkNotNullParameter($this$isEmpty, "<this>");
        return $this$isEmpty.getLeft() >= $this$isEmpty.getRight() || $this$isEmpty.getTop() >= $this$isEmpty.getBottom();
    }

    public static final boolean isFinite(RoundRect $this$isFinite) {
        Intrinsics.checkNotNullParameter($this$isFinite, "<this>");
        float left = $this$isFinite.getLeft();
        if (!Float.isInfinite(left) && !Float.isNaN(left)) {
            float top = $this$isFinite.getTop();
            if (!Float.isInfinite(top) && !Float.isNaN(top)) {
                float right = $this$isFinite.getRight();
                if (!Float.isInfinite(right) && !Float.isNaN(right)) {
                    float bottom = $this$isFinite.getBottom();
                    if (!Float.isInfinite(bottom) && !Float.isNaN(bottom)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        if ((androidx.compose.ui.geometry.CornerRadius.m2891getYimpl(r6.m2966getTopRightCornerRadiuskKHJgLs()) == 0.0f) != false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006c, code lost:
        if ((androidx.compose.ui.geometry.CornerRadius.m2891getYimpl(r6.m2963getBottomLeftCornerRadiuskKHJgLs()) == 0.0f) != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if ((androidx.compose.ui.geometry.CornerRadius.m2891getYimpl(r6.m2965getTopLeftCornerRadiuskKHJgLs()) == 0.0f) != false) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isRect(androidx.compose.ui.geometry.RoundRect r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            long r0 = r6.m2965getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2890getXimpl(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0016
            r0 = r2
            goto L_0x0017
        L_0x0016:
            r0 = r3
        L_0x0017:
            if (r0 != 0) goto L_0x002a
            long r4 = r6.m2965getTopLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2891getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0027
            r0 = r2
            goto L_0x0028
        L_0x0027:
            r0 = r3
        L_0x0028:
            if (r0 == 0) goto L_0x0091
        L_0x002a:
            long r4 = r6.m2966getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2890getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0038
            r0 = r2
            goto L_0x0039
        L_0x0038:
            r0 = r3
        L_0x0039:
            if (r0 != 0) goto L_0x004c
            long r4 = r6.m2966getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2891getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0049
            r0 = r2
            goto L_0x004a
        L_0x0049:
            r0 = r3
        L_0x004a:
            if (r0 == 0) goto L_0x0091
        L_0x004c:
            long r4 = r6.m2963getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2890getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x005a
            r0 = r2
            goto L_0x005b
        L_0x005a:
            r0 = r3
        L_0x005b:
            if (r0 != 0) goto L_0x006e
            long r4 = r6.m2963getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2891getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x006b
            r0 = r2
            goto L_0x006c
        L_0x006b:
            r0 = r3
        L_0x006c:
            if (r0 == 0) goto L_0x0091
        L_0x006e:
            long r4 = r6.m2964getBottomRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2890getXimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x007c
            r0 = r2
            goto L_0x007d
        L_0x007c:
            r0 = r3
        L_0x007d:
            if (r0 != 0) goto L_0x0092
            long r4 = r6.m2964getBottomRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2891getYimpl(r4)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x008d
            r0 = r2
            goto L_0x008e
        L_0x008d:
            r0 = r3
        L_0x008e:
            if (r0 == 0) goto L_0x0091
            goto L_0x0092
        L_0x0091:
            r2 = r3
        L_0x0092:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.geometry.RoundRectKt.isRect(androidx.compose.ui.geometry.RoundRect):boolean");
    }

    public static final boolean isEllipse(RoundRect $this$isEllipse) {
        Intrinsics.checkNotNullParameter($this$isEllipse, "<this>");
        if (CornerRadius.m2890getXimpl($this$isEllipse.m2965getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2890getXimpl($this$isEllipse.m2966getTopRightCornerRadiuskKHJgLs())) {
            if (CornerRadius.m2891getYimpl($this$isEllipse.m2965getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2891getYimpl($this$isEllipse.m2966getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m2890getXimpl($this$isEllipse.m2966getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m2890getXimpl($this$isEllipse.m2964getBottomRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.m2891getYimpl($this$isEllipse.m2966getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m2891getYimpl($this$isEllipse.m2964getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.m2890getXimpl($this$isEllipse.m2964getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m2890getXimpl($this$isEllipse.m2963getBottomLeftCornerRadiuskKHJgLs())) {
                            if ((CornerRadius.m2891getYimpl($this$isEllipse.m2964getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m2891getYimpl($this$isEllipse.m2963getBottomLeftCornerRadiuskKHJgLs())) && ((double) $this$isEllipse.getWidth()) <= ((double) CornerRadius.m2890getXimpl($this$isEllipse.m2965getTopLeftCornerRadiuskKHJgLs())) * 2.0d && ((double) $this$isEllipse.getHeight()) <= ((double) CornerRadius.m2891getYimpl($this$isEllipse.m2965getTopLeftCornerRadiuskKHJgLs())) * 2.0d) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isCircle(RoundRect $this$isCircle) {
        Intrinsics.checkNotNullParameter($this$isCircle, "<this>");
        return (($this$isCircle.getWidth() > $this$isCircle.getHeight() ? 1 : ($this$isCircle.getWidth() == $this$isCircle.getHeight() ? 0 : -1)) == 0) && isEllipse($this$isCircle);
    }

    public static final float getMinDimension(RoundRect $this$minDimension) {
        Intrinsics.checkNotNullParameter($this$minDimension, "<this>");
        return Math.min(Math.abs($this$minDimension.getWidth()), Math.abs($this$minDimension.getHeight()));
    }

    public static final float getMaxDimension(RoundRect $this$maxDimension) {
        Intrinsics.checkNotNullParameter($this$maxDimension, "<this>");
        return Math.max(Math.abs($this$maxDimension.getWidth()), Math.abs($this$maxDimension.getHeight()));
    }

    public static final long getCenter(RoundRect $this$center) {
        Intrinsics.checkNotNullParameter($this$center, "<this>");
        return OffsetKt.Offset($this$center.getLeft() + ($this$center.getWidth() / 2.0f), $this$center.getTop() + ($this$center.getHeight() / 2.0f));
    }

    public static final boolean isSimple(RoundRect $this$isSimple) {
        Intrinsics.checkNotNullParameter($this$isSimple, "<this>");
        if (CornerRadius.m2890getXimpl($this$isSimple.m2965getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2891getYimpl($this$isSimple.m2965getTopLeftCornerRadiuskKHJgLs())) {
            if (CornerRadius.m2890getXimpl($this$isSimple.m2965getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2890getXimpl($this$isSimple.m2966getTopRightCornerRadiuskKHJgLs())) {
                if (CornerRadius.m2890getXimpl($this$isSimple.m2965getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2891getYimpl($this$isSimple.m2966getTopRightCornerRadiuskKHJgLs())) {
                    if (CornerRadius.m2890getXimpl($this$isSimple.m2965getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2890getXimpl($this$isSimple.m2964getBottomRightCornerRadiuskKHJgLs())) {
                        if (CornerRadius.m2890getXimpl($this$isSimple.m2965getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2891getYimpl($this$isSimple.m2964getBottomRightCornerRadiuskKHJgLs())) {
                            if (CornerRadius.m2890getXimpl($this$isSimple.m2965getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2890getXimpl($this$isSimple.m2963getBottomLeftCornerRadiuskKHJgLs())) {
                                if (CornerRadius.m2890getXimpl($this$isSimple.m2965getTopLeftCornerRadiuskKHJgLs()) == CornerRadius.m2891getYimpl($this$isSimple.m2963getBottomLeftCornerRadiuskKHJgLs())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final RoundRect lerp(RoundRect start, RoundRect stop, float fraction) {
        float f = fraction;
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(stop, "stop");
        return new RoundRect(MathHelpersKt.lerp(start.getLeft(), stop.getLeft(), f), MathHelpersKt.lerp(start.getTop(), stop.getTop(), f), MathHelpersKt.lerp(start.getRight(), stop.getRight(), f), MathHelpersKt.lerp(start.getBottom(), stop.getBottom(), f), CornerRadiusKt.m2901lerp3Ry4LBc(start.m2965getTopLeftCornerRadiuskKHJgLs(), stop.m2965getTopLeftCornerRadiuskKHJgLs(), f), CornerRadiusKt.m2901lerp3Ry4LBc(start.m2966getTopRightCornerRadiuskKHJgLs(), stop.m2966getTopRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m2901lerp3Ry4LBc(start.m2964getBottomRightCornerRadiuskKHJgLs(), stop.m2964getBottomRightCornerRadiuskKHJgLs(), f), CornerRadiusKt.m2901lerp3Ry4LBc(start.m2963getBottomLeftCornerRadiuskKHJgLs(), stop.m2963getBottomLeftCornerRadiuskKHJgLs(), f), (DefaultConstructorMarker) null);
    }
}
