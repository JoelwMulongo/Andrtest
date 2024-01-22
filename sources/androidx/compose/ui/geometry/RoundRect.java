package androidx.compose.ui.geometry;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 >2\u00020\u0001:\u0001>BP\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\bø\u0001\u0000¢\u0006\u0002\u0010\fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0019\u0010!\u001a\u00020\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0011J\u0019\u0010#\u001a\u00020\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010\u0011J\u0019\u0010%\u001a\u00020\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u0011J\u0019\u0010'\u001a\u00020\bHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010\u0011J\u001e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.Jf\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0013\u00102\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J(\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003H\u0002J\b\u0010;\u001a\u00020\u0000H\u0002J\b\u0010<\u001a\u00020=H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u000b\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\n\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0019\u0010\u0011R\u001c\u0010\t\u001a\u00020\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006?"}, d2 = {"Landroidx/compose/ui/geometry/RoundRect;", "", "left", "", "top", "right", "bottom", "topLeftCornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "topRightCornerRadius", "bottomRightCornerRadius", "bottomLeftCornerRadius", "(FFFFJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "_scaledRadiiRect", "getBottom", "()F", "getBottomLeftCornerRadius-kKHJgLs", "()J", "J", "getBottomRightCornerRadius-kKHJgLs", "height", "getHeight", "getLeft", "getRight", "getTop", "getTopLeftCornerRadius-kKHJgLs", "getTopRightCornerRadius-kKHJgLs", "width", "getWidth", "component1", "component2", "component3", "component4", "component5", "component5-kKHJgLs", "component6", "component6-kKHJgLs", "component7", "component7-kKHJgLs", "component8", "component8-kKHJgLs", "contains", "", "point", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "copy", "copy-MDFrsts", "(FFFFJJJJ)Landroidx/compose/ui/geometry/RoundRect;", "equals", "other", "hashCode", "", "minRadius", "min", "radius1", "radius2", "limit", "scaledRadiiRect", "toString", "", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RoundRect.kt */
public final class RoundRect {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final RoundRect Zero = RoundRectKt.m2969RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, CornerRadius.Companion.m2900getZerokKHJgLs());
    private RoundRect _scaledRadiiRect;
    private final float bottom;
    private final long bottomLeftCornerRadius;
    private final long bottomRightCornerRadius;
    private final float left;
    private final float right;
    private final float top;
    private final long topLeftCornerRadius;
    private final long topRightCornerRadius;

    public /* synthetic */ RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, j, j2, j3, j4);
    }

    /* renamed from: copy-MDFrsts$default  reason: not valid java name */
    public static /* synthetic */ RoundRect m2956copyMDFrsts$default(RoundRect roundRect, float f, float f2, float f3, float f4, long j, long j2, long j3, long j4, int i, Object obj) {
        RoundRect roundRect2 = roundRect;
        int i2 = i;
        return roundRect.m2962copyMDFrsts((i2 & 1) != 0 ? roundRect2.left : f, (i2 & 2) != 0 ? roundRect2.top : f2, (i2 & 4) != 0 ? roundRect2.right : f3, (i2 & 8) != 0 ? roundRect2.bottom : f4, (i2 & 16) != 0 ? roundRect2.topLeftCornerRadius : j, (i2 & 32) != 0 ? roundRect2.topRightCornerRadius : j2, (i2 & 64) != 0 ? roundRect2.bottomRightCornerRadius : j3, (i2 & 128) != 0 ? roundRect2.bottomLeftCornerRadius : j4);
    }

    public static final RoundRect getZero() {
        return Companion.getZero();
    }

    public final float component1() {
        return this.left;
    }

    public final float component2() {
        return this.top;
    }

    public final float component3() {
        return this.right;
    }

    public final float component4() {
        return this.bottom;
    }

    /* renamed from: component5-kKHJgLs  reason: not valid java name */
    public final long m2957component5kKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* renamed from: component6-kKHJgLs  reason: not valid java name */
    public final long m2958component6kKHJgLs() {
        return this.topRightCornerRadius;
    }

    /* renamed from: component7-kKHJgLs  reason: not valid java name */
    public final long m2959component7kKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    /* renamed from: component8-kKHJgLs  reason: not valid java name */
    public final long m2960component8kKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    /* renamed from: copy-MDFrsts  reason: not valid java name */
    public final RoundRect m2962copyMDFrsts(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
        return new RoundRect(f, f2, f3, f4, j, j2, j3, j4, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundRect)) {
            return false;
        }
        RoundRect roundRect = (RoundRect) obj;
        return Float.compare(this.left, roundRect.left) == 0 && Float.compare(this.top, roundRect.top) == 0 && Float.compare(this.right, roundRect.right) == 0 && Float.compare(this.bottom, roundRect.bottom) == 0 && CornerRadius.m2889equalsimpl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && CornerRadius.m2889equalsimpl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && CornerRadius.m2889equalsimpl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && CornerRadius.m2889equalsimpl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius);
    }

    public int hashCode() {
        return (((((((((((((Float.hashCode(this.left) * 31) + Float.hashCode(this.top)) * 31) + Float.hashCode(this.right)) * 31) + Float.hashCode(this.bottom)) * 31) + CornerRadius.m2892hashCodeimpl(this.topLeftCornerRadius)) * 31) + CornerRadius.m2892hashCodeimpl(this.topRightCornerRadius)) * 31) + CornerRadius.m2892hashCodeimpl(this.bottomRightCornerRadius)) * 31) + CornerRadius.m2892hashCodeimpl(this.bottomLeftCornerRadius);
    }

    private RoundRect(float left2, float top2, float right2, float bottom2, long topLeftCornerRadius2, long topRightCornerRadius2, long bottomRightCornerRadius2, long bottomLeftCornerRadius2) {
        this.left = left2;
        this.top = top2;
        this.right = right2;
        this.bottom = bottom2;
        this.topLeftCornerRadius = topLeftCornerRadius2;
        this.topRightCornerRadius = topRightCornerRadius2;
        this.bottomRightCornerRadius = bottomRightCornerRadius2;
        this.bottomLeftCornerRadius = bottomLeftCornerRadius2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RoundRect(float r18, float r19, float r20, float r21, long r22, long r24, long r26, long r28, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r17 = this;
            r0 = r30
            r1 = r0 & 16
            if (r1 == 0) goto L_0x000e
            androidx.compose.ui.geometry.CornerRadius$Companion r1 = androidx.compose.ui.geometry.CornerRadius.Companion
            long r1 = r1.m2900getZerokKHJgLs()
            r8 = r1
            goto L_0x0010
        L_0x000e:
            r8 = r22
        L_0x0010:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x001c
            androidx.compose.ui.geometry.CornerRadius$Companion r1 = androidx.compose.ui.geometry.CornerRadius.Companion
            long r1 = r1.m2900getZerokKHJgLs()
            r10 = r1
            goto L_0x001e
        L_0x001c:
            r10 = r24
        L_0x001e:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x002a
            androidx.compose.ui.geometry.CornerRadius$Companion r1 = androidx.compose.ui.geometry.CornerRadius.Companion
            long r1 = r1.m2900getZerokKHJgLs()
            r12 = r1
            goto L_0x002c
        L_0x002a:
            r12 = r26
        L_0x002c:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0038
            androidx.compose.ui.geometry.CornerRadius$Companion r0 = androidx.compose.ui.geometry.CornerRadius.Companion
            long r0 = r0.m2900getZerokKHJgLs()
            r14 = r0
            goto L_0x003a
        L_0x0038:
            r14 = r28
        L_0x003a:
            r16 = 0
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r3.<init>(r4, r5, r6, r7, r8, r10, r12, r14, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.geometry.RoundRect.<init>(float, float, float, float, long, long, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getTop() {
        return this.top;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getBottom() {
        return this.bottom;
    }

    /* renamed from: getTopLeftCornerRadius-kKHJgLs  reason: not valid java name */
    public final long m2965getTopLeftCornerRadiuskKHJgLs() {
        return this.topLeftCornerRadius;
    }

    /* renamed from: getTopRightCornerRadius-kKHJgLs  reason: not valid java name */
    public final long m2966getTopRightCornerRadiuskKHJgLs() {
        return this.topRightCornerRadius;
    }

    /* renamed from: getBottomRightCornerRadius-kKHJgLs  reason: not valid java name */
    public final long m2964getBottomRightCornerRadiuskKHJgLs() {
        return this.bottomRightCornerRadius;
    }

    /* renamed from: getBottomLeftCornerRadius-kKHJgLs  reason: not valid java name */
    public final long m2963getBottomLeftCornerRadiuskKHJgLs() {
        return this.bottomLeftCornerRadius;
    }

    public final float getWidth() {
        return this.right - this.left;
    }

    public final float getHeight() {
        return this.bottom - this.top;
    }

    private final RoundRect scaledRadiiRect() {
        RoundRect roundRect = this._scaledRadiiRect;
        if (roundRect != null) {
            return roundRect;
        }
        RoundRect $this$scaledRadiiRect_u24lambda_u240 = this;
        float scale = $this$scaledRadiiRect_u24lambda_u240.minRadius($this$scaledRadiiRect_u24lambda_u240.minRadius($this$scaledRadiiRect_u24lambda_u240.minRadius($this$scaledRadiiRect_u24lambda_u240.minRadius(1.0f, CornerRadius.m2891getYimpl($this$scaledRadiiRect_u24lambda_u240.bottomLeftCornerRadius), CornerRadius.m2891getYimpl($this$scaledRadiiRect_u24lambda_u240.topLeftCornerRadius), $this$scaledRadiiRect_u24lambda_u240.getHeight()), CornerRadius.m2890getXimpl($this$scaledRadiiRect_u24lambda_u240.topLeftCornerRadius), CornerRadius.m2890getXimpl($this$scaledRadiiRect_u24lambda_u240.topRightCornerRadius), $this$scaledRadiiRect_u24lambda_u240.getWidth()), CornerRadius.m2891getYimpl($this$scaledRadiiRect_u24lambda_u240.topRightCornerRadius), CornerRadius.m2891getYimpl($this$scaledRadiiRect_u24lambda_u240.bottomRightCornerRadius), $this$scaledRadiiRect_u24lambda_u240.getHeight()), CornerRadius.m2890getXimpl($this$scaledRadiiRect_u24lambda_u240.bottomRightCornerRadius), CornerRadius.m2890getXimpl($this$scaledRadiiRect_u24lambda_u240.bottomLeftCornerRadius), $this$scaledRadiiRect_u24lambda_u240.getWidth());
        RoundRect it = new RoundRect($this$scaledRadiiRect_u24lambda_u240.left * scale, $this$scaledRadiiRect_u24lambda_u240.top * scale, $this$scaledRadiiRect_u24lambda_u240.right * scale, $this$scaledRadiiRect_u24lambda_u240.bottom * scale, CornerRadiusKt.CornerRadius(CornerRadius.m2890getXimpl($this$scaledRadiiRect_u24lambda_u240.topLeftCornerRadius) * scale, CornerRadius.m2891getYimpl($this$scaledRadiiRect_u24lambda_u240.topLeftCornerRadius) * scale), CornerRadiusKt.CornerRadius(CornerRadius.m2890getXimpl($this$scaledRadiiRect_u24lambda_u240.topRightCornerRadius) * scale, CornerRadius.m2891getYimpl($this$scaledRadiiRect_u24lambda_u240.topRightCornerRadius) * scale), CornerRadiusKt.CornerRadius(CornerRadius.m2890getXimpl($this$scaledRadiiRect_u24lambda_u240.bottomRightCornerRadius) * scale, CornerRadius.m2891getYimpl($this$scaledRadiiRect_u24lambda_u240.bottomRightCornerRadius) * scale), CornerRadiusKt.CornerRadius(CornerRadius.m2890getXimpl($this$scaledRadiiRect_u24lambda_u240.bottomLeftCornerRadius) * scale, CornerRadius.m2891getYimpl($this$scaledRadiiRect_u24lambda_u240.bottomLeftCornerRadius) * scale), (DefaultConstructorMarker) null);
        this._scaledRadiiRect = it;
        return it;
    }

    private final float minRadius(float min, float radius1, float radius2, float limit) {
        float sum = radius1 + radius2;
        if (sum > limit) {
            if (!(sum == 0.0f)) {
                return Math.min(min, limit / sum);
            }
        }
        return min;
    }

    /* renamed from: contains-k-4lQ0M  reason: not valid java name */
    public final boolean m2961containsk4lQ0M(long point) {
        float x;
        float radiusY;
        float radiusX;
        float y;
        if (Offset.m2915getXimpl(point) < this.left || Offset.m2915getXimpl(point) >= this.right || Offset.m2916getYimpl(point) < this.top || Offset.m2916getYimpl(point) >= this.bottom) {
            return false;
        }
        RoundRect scaled = scaledRadiiRect();
        if (Offset.m2915getXimpl(point) < this.left + CornerRadius.m2890getXimpl(scaled.topLeftCornerRadius) && Offset.m2916getYimpl(point) < this.top + CornerRadius.m2891getYimpl(scaled.topLeftCornerRadius)) {
            x = (Offset.m2915getXimpl(point) - this.left) - CornerRadius.m2890getXimpl(scaled.topLeftCornerRadius);
            y = (Offset.m2916getYimpl(point) - this.top) - CornerRadius.m2891getYimpl(scaled.topLeftCornerRadius);
            radiusX = CornerRadius.m2890getXimpl(scaled.topLeftCornerRadius);
            radiusY = CornerRadius.m2891getYimpl(scaled.topLeftCornerRadius);
        } else if (Offset.m2915getXimpl(point) > this.right - CornerRadius.m2890getXimpl(scaled.topRightCornerRadius) && Offset.m2916getYimpl(point) < this.top + CornerRadius.m2891getYimpl(scaled.topRightCornerRadius)) {
            x = (Offset.m2915getXimpl(point) - this.right) + CornerRadius.m2890getXimpl(scaled.topRightCornerRadius);
            y = (Offset.m2916getYimpl(point) - this.top) - CornerRadius.m2891getYimpl(scaled.topRightCornerRadius);
            radiusX = CornerRadius.m2890getXimpl(scaled.topRightCornerRadius);
            radiusY = CornerRadius.m2891getYimpl(scaled.topRightCornerRadius);
        } else if (Offset.m2915getXimpl(point) > this.right - CornerRadius.m2890getXimpl(scaled.bottomRightCornerRadius) && Offset.m2916getYimpl(point) > this.bottom - CornerRadius.m2891getYimpl(scaled.bottomRightCornerRadius)) {
            x = (Offset.m2915getXimpl(point) - this.right) + CornerRadius.m2890getXimpl(scaled.bottomRightCornerRadius);
            y = (Offset.m2916getYimpl(point) - this.bottom) + CornerRadius.m2891getYimpl(scaled.bottomRightCornerRadius);
            radiusX = CornerRadius.m2890getXimpl(scaled.bottomRightCornerRadius);
            radiusY = CornerRadius.m2891getYimpl(scaled.bottomRightCornerRadius);
        } else if (Offset.m2915getXimpl(point) >= this.left + CornerRadius.m2890getXimpl(scaled.bottomLeftCornerRadius) || Offset.m2916getYimpl(point) <= this.bottom - CornerRadius.m2891getYimpl(scaled.bottomLeftCornerRadius)) {
            return true;
        } else {
            x = (Offset.m2915getXimpl(point) - this.left) - CornerRadius.m2890getXimpl(scaled.bottomLeftCornerRadius);
            y = (Offset.m2916getYimpl(point) - this.bottom) + CornerRadius.m2891getYimpl(scaled.bottomLeftCornerRadius);
            radiusX = CornerRadius.m2890getXimpl(scaled.bottomLeftCornerRadius);
            radiusY = CornerRadius.m2891getYimpl(scaled.bottomLeftCornerRadius);
        }
        float radiusY2 = x / radiusX;
        float newY = y / radiusY;
        if ((radiusY2 * radiusY2) + (newY * newY) <= 1.0f) {
            return true;
        }
        return false;
    }

    public String toString() {
        long tlRadius = this.topLeftCornerRadius;
        long trRadius = this.topRightCornerRadius;
        long brRadius = this.bottomRightCornerRadius;
        long blRadius = this.bottomLeftCornerRadius;
        String rect = GeometryUtilsKt.toStringAsFixed(this.left, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.top, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.right, 1) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom, 1);
        if (!CornerRadius.m2889equalsimpl0(tlRadius, trRadius) || !CornerRadius.m2889equalsimpl0(trRadius, brRadius) || !CornerRadius.m2889equalsimpl0(brRadius, blRadius)) {
            return "RoundRect(rect=" + rect + ", topLeft=" + CornerRadius.m2896toStringimpl(tlRadius) + ", topRight=" + CornerRadius.m2896toStringimpl(trRadius) + ", bottomRight=" + CornerRadius.m2896toStringimpl(brRadius) + ", bottomLeft=" + CornerRadius.m2896toStringimpl(blRadius) + ')';
        }
        if (CornerRadius.m2890getXimpl(tlRadius) == CornerRadius.m2891getYimpl(tlRadius)) {
            return "RoundRect(rect=" + rect + ", radius=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m2890getXimpl(tlRadius), 1) + ')';
        }
        return "RoundRect(rect=" + rect + ", x=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m2890getXimpl(tlRadius), 1) + ", y=" + GeometryUtilsKt.toStringAsFixed(CornerRadius.m2891getYimpl(tlRadius), 1) + ')';
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/geometry/RoundRect$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/geometry/RoundRect;", "getZero$annotations", "getZero", "()Landroidx/compose/ui/geometry/RoundRect;", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: RoundRect.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getZero$annotations() {
        }

        private Companion() {
        }

        public final RoundRect getZero() {
            return RoundRect.Zero;
        }
    }
}
