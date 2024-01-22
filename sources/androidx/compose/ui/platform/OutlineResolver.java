package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u001b\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u001fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u001b\u00103\u001a\u00020,2\u0006\u0010$\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105J6\u00103\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#2\u0006\u00106\u001a\u00020!2\u0006\u0010+\u001a\u00020\u00062\u0006\u00107\u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003J\b\u00108\u001a\u00020,H\u0002J\u0010\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020\nH\u0002J\u0010\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020(H\u0002J3\u0010@\u001a\u00020\u0006*\u0004\u0018\u00010(2\u0006\u0010A\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020!H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u001b\u001a\u00020\u001cX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001dR\u0019\u0010\u001e\u001a\u00020\u001fX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010$\u001a\u00020\u001cX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010%\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006E"}, d2 = {"Landroidx/compose/ui/platform/OutlineResolver;", "", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)V", "cacheIsDirty", "", "cachedOutline", "Landroid/graphics/Outline;", "cachedRrectPath", "Landroidx/compose/ui/graphics/Path;", "calculatedOutline", "Landroidx/compose/ui/graphics/Outline;", "clipPath", "getClipPath", "()Landroidx/compose/ui/graphics/Path;", "isSupportedOutline", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outline", "getOutline", "()Landroid/graphics/Outline;", "outlineClipSupported", "getOutlineClipSupported", "()Z", "outlineNeeded", "outlinePath", "rectSize", "Landroidx/compose/ui/geometry/Size;", "J", "rectTopLeft", "Landroidx/compose/ui/geometry/Offset;", "roundedCornerRadius", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "size", "tmpOpPath", "tmpPath", "tmpRoundRect", "Landroidx/compose/ui/geometry/RoundRect;", "tmpTouchPointPath", "usePathForClip", "clipToOutline", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "isInOutline", "position", "isInOutline-k-4lQ0M", "(J)Z", "update", "update-uvyYCjk", "(J)V", "alpha", "elevation", "updateCache", "updateCacheWithPath", "composePath", "updateCacheWithRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateCacheWithRoundRect", "roundRect", "isSameBounds", "offset", "radius", "isSameBounds-4L21HEs", "(Landroidx/compose/ui/geometry/RoundRect;JJF)Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OutlineResolver.android.kt */
public final class OutlineResolver {
    private boolean cacheIsDirty;
    private final Outline cachedOutline;
    private Path cachedRrectPath;
    private androidx.compose.ui.graphics.Outline calculatedOutline;
    private Density density;
    private boolean isSupportedOutline = true;
    private LayoutDirection layoutDirection;
    private boolean outlineNeeded;
    private Path outlinePath;
    private long rectSize;
    private long rectTopLeft;
    private float roundedCornerRadius;
    private Shape shape;
    private long size;
    private Path tmpOpPath;
    private Path tmpPath;
    private RoundRect tmpRoundRect;
    private Path tmpTouchPointPath;
    private boolean usePathForClip;

    public OutlineResolver(Density density2) {
        Intrinsics.checkNotNullParameter(density2, "density");
        this.density = density2;
        Outline $this$cachedOutline_u24lambda_u240 = new Outline();
        $this$cachedOutline_u24lambda_u240.setAlpha(1.0f);
        this.cachedOutline = $this$cachedOutline_u24lambda_u240;
        this.size = Size.Companion.m2993getZeroNHjbRc();
        this.shape = RectangleShapeKt.getRectangleShape();
        this.rectTopLeft = Offset.Companion.m2931getZeroF1C5BW0();
        this.rectSize = Size.Companion.m2993getZeroNHjbRc();
        this.layoutDirection = LayoutDirection.Ltr;
    }

    public final Outline getOutline() {
        updateCache();
        if (!this.outlineNeeded || !this.isSupportedOutline) {
            return null;
        }
        return this.cachedOutline;
    }

    public final boolean getOutlineClipSupported() {
        return !this.usePathForClip;
    }

    public final Path getClipPath() {
        updateCache();
        return this.outlinePath;
    }

    public final boolean update(Shape shape2, float alpha, boolean clipToOutline, float elevation, LayoutDirection layoutDirection2, Density density2) {
        Intrinsics.checkNotNullParameter(shape2, "shape");
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        Intrinsics.checkNotNullParameter(density2, "density");
        this.cachedOutline.setAlpha(alpha);
        boolean shapeChanged = !Intrinsics.areEqual((Object) this.shape, (Object) shape2);
        if (shapeChanged) {
            this.shape = shape2;
            this.cacheIsDirty = true;
        }
        boolean outlineNeeded2 = clipToOutline || elevation > 0.0f;
        if (this.outlineNeeded != outlineNeeded2) {
            this.outlineNeeded = outlineNeeded2;
            this.cacheIsDirty = true;
        }
        if (this.layoutDirection != layoutDirection2) {
            this.layoutDirection = layoutDirection2;
            this.cacheIsDirty = true;
        }
        if (!Intrinsics.areEqual((Object) this.density, (Object) density2)) {
            this.density = density2;
            this.cacheIsDirty = true;
        }
        return shapeChanged;
    }

    /* renamed from: isInOutline-k-4lQ0M  reason: not valid java name */
    public final boolean m5267isInOutlinek4lQ0M(long position) {
        androidx.compose.ui.graphics.Outline outline;
        if (this.outlineNeeded && (outline = this.calculatedOutline) != null) {
            return ShapeContainingUtilKt.isInOutline(outline, Offset.m2915getXimpl(position), Offset.m2916getYimpl(position), this.tmpTouchPointPath, this.tmpOpPath);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        if (m5266isSameBounds4L21HEs(r13, r7.rectTopLeft, r7.rectSize, r6) == false) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void clipToOutline(androidx.compose.ui.graphics.Canvas r23) {
        /*
            r22 = this;
            r7 = r22
            r15 = r23
            java.lang.String r0 = "canvas"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            androidx.compose.ui.graphics.Path r14 = r22.getClipPath()
            r8 = 0
            r9 = 0
            r10 = 2
            if (r14 == 0) goto L_0x0018
            androidx.compose.ui.graphics.Canvas.m3125clipPathmtrdDE$default(r15, r14, r8, r10, r9)
            r2 = r14
            goto L_0x00b0
        L_0x0018:
            float r6 = r7.roundedCornerRadius
            r11 = 0
            int r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x007b
            androidx.compose.ui.graphics.Path r12 = r7.tmpPath
            androidx.compose.ui.geometry.RoundRect r13 = r7.tmpRoundRect
            if (r12 == 0) goto L_0x0032
            long r2 = r7.rectTopLeft
            long r4 = r7.rectSize
            r0 = r22
            r1 = r13
            boolean r0 = r0.m5266isSameBounds4L21HEs(r1, r2, r4, r6)
            if (r0 != 0) goto L_0x0076
        L_0x0032:
            long r0 = r7.rectTopLeft
            float r16 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r0)
            long r0 = r7.rectTopLeft
            float r17 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r0)
            long r0 = r7.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r0)
            long r1 = r7.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m2984getWidthimpl(r1)
            float r18 = r0 + r1
            long r0 = r7.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r0)
            long r1 = r7.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m2981getHeightimpl(r1)
            float r19 = r0 + r1
            float r0 = r7.roundedCornerRadius
            long r20 = androidx.compose.ui.geometry.CornerRadiusKt.CornerRadius$default(r0, r11, r10, r9)
            androidx.compose.ui.geometry.RoundRect r13 = androidx.compose.ui.geometry.RoundRectKt.m2969RoundRectgG7oq9Y(r16, r17, r18, r19, r20)
            if (r12 != 0) goto L_0x006c
            androidx.compose.ui.graphics.Path r12 = androidx.compose.ui.graphics.AndroidPath_androidKt.Path()
            goto L_0x006f
        L_0x006c:
            r12.reset()
        L_0x006f:
            r12.addRoundRect(r13)
            r7.tmpRoundRect = r13
            r7.tmpPath = r12
        L_0x0076:
            androidx.compose.ui.graphics.Canvas.m3125clipPathmtrdDE$default(r15, r12, r8, r10, r9)
            r2 = r14
            goto L_0x00b0
        L_0x007b:
            long r0 = r7.rectTopLeft
            float r9 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r0)
            long r0 = r7.rectTopLeft
            float r10 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r0)
            long r0 = r7.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r0)
            long r1 = r7.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m2984getWidthimpl(r1)
            float r11 = r0 + r1
            long r0 = r7.rectTopLeft
            float r0 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r0)
            long r1 = r7.rectSize
            float r1 = androidx.compose.ui.geometry.Size.m2981getHeightimpl(r1)
            float r12 = r0 + r1
            r13 = 0
            r0 = 16
            r1 = 0
            r8 = r23
            r2 = r14
            r14 = r0
            r15 = r1
            androidx.compose.ui.graphics.Canvas.m3126clipRectN_I0leg$default(r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x00b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.OutlineResolver.clipToOutline(androidx.compose.ui.graphics.Canvas):void");
    }

    /* renamed from: update-uvyYCjk  reason: not valid java name */
    public final void m5268updateuvyYCjk(long size2) {
        if (!Size.m2980equalsimpl0(this.size, size2)) {
            this.size = size2;
            this.cacheIsDirty = true;
        }
    }

    private final void updateCache() {
        if (this.cacheIsDirty) {
            this.rectTopLeft = Offset.Companion.m2931getZeroF1C5BW0();
            long j = this.size;
            this.rectSize = j;
            this.roundedCornerRadius = 0.0f;
            this.outlinePath = null;
            this.cacheIsDirty = false;
            this.usePathForClip = false;
            if (!this.outlineNeeded || Size.m2984getWidthimpl(j) <= 0.0f || Size.m2981getHeightimpl(this.size) <= 0.0f) {
                this.cachedOutline.setEmpty();
                return;
            }
            this.isSupportedOutline = true;
            androidx.compose.ui.graphics.Outline outline = this.shape.m3518createOutlinePq9zytI(this.size, this.layoutDirection, this.density);
            this.calculatedOutline = outline;
            if (outline instanceof Outline.Rectangle) {
                updateCacheWithRect(((Outline.Rectangle) outline).getRect());
            } else if (outline instanceof Outline.Rounded) {
                updateCacheWithRoundRect(((Outline.Rounded) outline).getRoundRect());
            } else if (outline instanceof Outline.Generic) {
                updateCacheWithPath(((Outline.Generic) outline).getPath());
            }
        }
    }

    private final void updateCacheWithRect(Rect rect) {
        this.rectTopLeft = OffsetKt.Offset(rect.getLeft(), rect.getTop());
        this.rectSize = SizeKt.Size(rect.getWidth(), rect.getHeight());
        this.cachedOutline.setRect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()));
    }

    private final void updateCacheWithRoundRect(RoundRect roundRect) {
        float radius = CornerRadius.m2890getXimpl(roundRect.m2965getTopLeftCornerRadiuskKHJgLs());
        this.rectTopLeft = OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
        this.rectSize = SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
        if (RoundRectKt.isSimple(roundRect)) {
            this.cachedOutline.setRoundRect(MathKt.roundToInt(roundRect.getLeft()), MathKt.roundToInt(roundRect.getTop()), MathKt.roundToInt(roundRect.getRight()), MathKt.roundToInt(roundRect.getBottom()), radius);
            this.roundedCornerRadius = radius;
            return;
        }
        Path path = this.cachedRrectPath;
        if (path == null) {
            path = AndroidPath_androidKt.Path();
            this.cachedRrectPath = path;
        }
        path.reset();
        path.addRoundRect(roundRect);
        updateCacheWithPath(path);
    }

    private final void updateCacheWithPath(Path composePath) {
        if (Build.VERSION.SDK_INT > 28 || composePath.isConvex()) {
            android.graphics.Outline outline = this.cachedOutline;
            Path $this$asAndroidPath$iv = composePath;
            if ($this$asAndroidPath$iv instanceof AndroidPath) {
                outline.setConvexPath(((AndroidPath) $this$asAndroidPath$iv).getInternalPath());
                this.usePathForClip = !this.cachedOutline.canClip();
            } else {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
        } else {
            this.isSupportedOutline = false;
            this.cachedOutline.setEmpty();
            this.usePathForClip = true;
        }
        this.outlinePath = composePath;
    }

    /* renamed from: isSameBounds-4L21HEs  reason: not valid java name */
    private final boolean m5266isSameBounds4L21HEs(RoundRect $this$isSameBounds_u2d4L21HEs, long offset, long size2, float radius) {
        if ($this$isSameBounds_u2d4L21HEs == null || !RoundRectKt.isSimple($this$isSameBounds_u2d4L21HEs)) {
            return false;
        }
        if (!($this$isSameBounds_u2d4L21HEs.getLeft() == Offset.m2915getXimpl(offset))) {
            return false;
        }
        if (!($this$isSameBounds_u2d4L21HEs.getTop() == Offset.m2916getYimpl(offset))) {
            return false;
        }
        if (!($this$isSameBounds_u2d4L21HEs.getRight() == Offset.m2915getXimpl(offset) + Size.m2984getWidthimpl(size2))) {
            return false;
        }
        if (!($this$isSameBounds_u2d4L21HEs.getBottom() == Offset.m2916getYimpl(offset) + Size.m2981getHeightimpl(size2))) {
            return false;
        }
        if (CornerRadius.m2890getXimpl($this$isSameBounds_u2d4L21HEs.m2965getTopLeftCornerRadiuskKHJgLs()) == radius) {
            return true;
        }
        return false;
    }
}
