package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J=\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"J\b\u0010#\u001a\u00020\u000fH\u0016JH\u0010$\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J-\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J-\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020-2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106JE\u00107\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u0002092\u0006\u0010=\u001a\u00020;2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010?J-\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020-2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010DJ)\u0010E\u001a\u00020\u000f2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020-0G2\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002ø\u0001\u0001J0\u0010J\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010K\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*H\u0016J3\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020N2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020-0G2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bO\u0010PJ!\u0010L\u001a\u00020\u000f2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020-0G2\u0006\u0010)\u001a\u00020*H\u0002ø\u0001\u0001J \u0010Q\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020R2\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J-\u0010S\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020N2\u0006\u0010F\u001a\u00020R2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bT\u0010UJ \u0010S\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020R2\u0006\u0010)\u001a\u00020*2\u0006\u0010H\u001a\u00020IH\u0002J0\u0010V\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J@\u0010W\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010X\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J-\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010)\u001a\u00020*H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b_\u0010`J\b\u0010a\u001a\u00020\u000fH\u0016J\b\u0010b\u001a\u00020\u000fH\u0016J\u0010\u0010c\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020\u0018H\u0016J\b\u0010e\u001a\u00020\u000fH\u0016J\u0018\u0010f\u001a\u00020\u000f2\u0006\u0010g\u001a\u00020h2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010i\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u00182\u0006\u0010k\u001a\u00020\u0018H\u0016J\u0018\u0010l\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u00182\u0006\u0010k\u001a\u00020\u0018H\u0016J\u0018\u0010m\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020\u00182\u0006\u0010o\u001a\u00020\u0018H\u0016J\u0017\u0010p\u001a\u00020q*\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\br\u0010sR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u00060\u0006j\u0002`\u00078\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006t"}, d2 = {"Landroidx/compose/ui/graphics/AndroidCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "()V", "dstRect", "Landroid/graphics/Rect;", "internalCanvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "getInternalCanvas$annotations", "getInternalCanvas", "()Landroid/graphics/Canvas;", "setInternalCanvas", "(Landroid/graphics/Canvas;)V", "srcRect", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "disableZ", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawCircle", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawLine", "p1", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawLines", "points", "", "stepBy", "", "drawOval", "drawPath", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "drawRawLines", "", "drawRawPoints", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "enableZ", "restore", "rotate", "degrees", "save", "saveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "scale", "sx", "sy", "skew", "translate", "dx", "dy", "toRegionOp", "Landroid/graphics/Region$Op;", "toRegionOp--7u2Bmg", "(I)Landroid/graphics/Region$Op;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidCanvas.android.kt */
public final class AndroidCanvas implements Canvas {
    private final Rect dstRect = new Rect();
    private Canvas internalCanvas = AndroidCanvas_androidKt.EmptyCanvas;
    private final Rect srcRect = new Rect();

    public static /* synthetic */ void getInternalCanvas$annotations() {
    }

    public final Canvas getInternalCanvas() {
        return this.internalCanvas;
    }

    public final void setInternalCanvas(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "<set-?>");
        this.internalCanvas = canvas;
    }

    public void save() {
        this.internalCanvas.save();
    }

    public void restore() {
        this.internalCanvas.restore();
    }

    public void saveLayer(androidx.compose.ui.geometry.Rect bounds, Paint paint) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.saveLayer(bounds.getLeft(), bounds.getTop(), bounds.getRight(), bounds.getBottom(), paint.asFrameworkPaint(), 31);
    }

    public void translate(float dx, float dy) {
        this.internalCanvas.translate(dx, dy);
    }

    public void scale(float sx, float sy) {
        this.internalCanvas.scale(sx, sy);
    }

    public void rotate(float degrees) {
        this.internalCanvas.rotate(degrees);
    }

    public void skew(float sx, float sy) {
        this.internalCanvas.skew(sx, sy);
    }

    /* renamed from: concat-58bKbWc  reason: not valid java name */
    public void m3011concat58bKbWc(float[] matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        if (!MatrixKt.m3415isIdentity58bKbWc(matrix)) {
            Matrix frameworkMatrix = new Matrix();
            AndroidMatrixConversions_androidKt.m3026setFromEL8BTi8(frameworkMatrix, matrix);
            this.internalCanvas.concat(frameworkMatrix);
        }
    }

    /* renamed from: clipRect-N_I0leg  reason: not valid java name */
    public void m3010clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp) {
        this.internalCanvas.clipRect(left, top, right, bottom, m3019toRegionOp7u2Bmg(clipOp));
    }

    /* renamed from: clipPath-mtrdD-E  reason: not valid java name */
    public void m3009clipPathmtrdDE(Path path, int clipOp) {
        Intrinsics.checkNotNullParameter(path, "path");
        Canvas canvas = this.internalCanvas;
        Path $this$asAndroidPath$iv = path;
        if ($this$asAndroidPath$iv instanceof AndroidPath) {
            canvas.clipPath(((AndroidPath) $this$asAndroidPath$iv).getInternalPath(), m3019toRegionOp7u2Bmg(clipOp));
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    /* renamed from: toRegionOp--7u2Bmg  reason: not valid java name */
    public final Region.Op m3019toRegionOp7u2Bmg(int $this$toRegionOp_u2d_u2d7u2Bmg) {
        if (ClipOp.m3148equalsimpl0($this$toRegionOp_u2d_u2d7u2Bmg, ClipOp.Companion.m3152getDifferencertfAjoo())) {
            return Region.Op.DIFFERENCE;
        }
        return Region.Op.INTERSECT;
    }

    /* renamed from: drawLine-Wko1d7g  reason: not valid java name */
    public void m3015drawLineWko1d7g(long p1, long p2, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawLine(Offset.m2915getXimpl(p1), Offset.m2916getYimpl(p1), Offset.m2915getXimpl(p2), Offset.m2916getYimpl(p2), paint.asFrameworkPaint());
    }

    public void drawRect(float left, float top, float right, float bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawRect(left, top, right, bottom, paint.asFrameworkPaint());
    }

    public void drawRoundRect(float left, float top, float right, float bottom, float radiusX, float radiusY, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawRoundRect(left, top, right, bottom, radiusX, radiusY, paint.asFrameworkPaint());
    }

    public void drawOval(float left, float top, float right, float bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawOval(left, top, right, bottom, paint.asFrameworkPaint());
    }

    /* renamed from: drawCircle-9KIMszo  reason: not valid java name */
    public void m3012drawCircle9KIMszo(long center, float radius, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawCircle(Offset.m2915getXimpl(center), Offset.m2916getYimpl(center), radius, paint.asFrameworkPaint());
    }

    public void drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawArc(left, top, right, bottom, startAngle, sweepAngle, useCenter, paint.asFrameworkPaint());
    }

    public void drawPath(Path path, Paint paint) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.internalCanvas;
        Path $this$asAndroidPath$iv = path;
        if ($this$asAndroidPath$iv instanceof AndroidPath) {
            canvas.drawPath(((AndroidPath) $this$asAndroidPath$iv).getInternalPath(), paint.asFrameworkPaint());
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    /* renamed from: drawImage-d-4ec7I  reason: not valid java name */
    public void m3013drawImaged4ec7I(ImageBitmap image, long topLeftOffset, Paint paint) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(image), Offset.m2915getXimpl(topLeftOffset), Offset.m2916getYimpl(topLeftOffset), paint.asFrameworkPaint());
    }

    /* renamed from: drawImageRect-HPBpro0  reason: not valid java name */
    public void m3014drawImageRectHPBpro0(ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, Paint paint) {
        ImageBitmap imageBitmap = image;
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.internalCanvas;
        Bitmap asAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap(image);
        Rect rect = this.srcRect;
        Rect $this$drawImageRect_HPBpro0_u24lambda_u240 = rect;
        $this$drawImageRect_HPBpro0_u24lambda_u240.left = IntOffset.m6104getXimpl(srcOffset);
        $this$drawImageRect_HPBpro0_u24lambda_u240.top = IntOffset.m6105getYimpl(srcOffset);
        $this$drawImageRect_HPBpro0_u24lambda_u240.right = IntOffset.m6104getXimpl(srcOffset) + IntSize.m6146getWidthimpl(srcSize);
        $this$drawImageRect_HPBpro0_u24lambda_u240.bottom = IntOffset.m6105getYimpl(srcOffset) + IntSize.m6145getHeightimpl(srcSize);
        Unit unit = Unit.INSTANCE;
        Rect rect2 = this.dstRect;
        Rect $this$drawImageRect_HPBpro0_u24lambda_u241 = rect2;
        $this$drawImageRect_HPBpro0_u24lambda_u241.left = IntOffset.m6104getXimpl(dstOffset);
        $this$drawImageRect_HPBpro0_u24lambda_u241.top = IntOffset.m6105getYimpl(dstOffset);
        $this$drawImageRect_HPBpro0_u24lambda_u241.right = IntOffset.m6104getXimpl(dstOffset) + IntSize.m6146getWidthimpl(dstSize);
        $this$drawImageRect_HPBpro0_u24lambda_u241.bottom = IntOffset.m6105getYimpl(dstOffset) + IntSize.m6145getHeightimpl(dstSize);
        Unit unit2 = Unit.INSTANCE;
        canvas.drawBitmap(asAndroidBitmap, rect, rect2, paint.asFrameworkPaint());
    }

    /* renamed from: drawPoints-O7TthRY  reason: not valid java name */
    public void m3016drawPointsO7TthRY(int pointMode, List<Offset> points, Paint paint) {
        Intrinsics.checkNotNullParameter(points, "points");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (PointMode.m3477equalsimpl0(pointMode, PointMode.Companion.m3481getLinesr_lszbg())) {
            drawLines(points, paint, 2);
        } else if (PointMode.m3477equalsimpl0(pointMode, PointMode.Companion.m3483getPolygonr_lszbg())) {
            drawLines(points, paint, 1);
        } else if (PointMode.m3477equalsimpl0(pointMode, PointMode.Companion.m3482getPointsr_lszbg())) {
            drawPoints(points, paint);
        }
    }

    public void enableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, true);
    }

    public void disableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, false);
    }

    private final void drawPoints(List<Offset> points, Paint paint) {
        List $this$fastForEach$iv = points;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            long point = $this$fastForEach$iv.get(index$iv).m2925unboximpl();
            this.internalCanvas.drawPoint(Offset.m2915getXimpl(point), Offset.m2916getYimpl(point), paint.asFrameworkPaint());
        }
    }

    private final void drawLines(List<Offset> points, Paint paint, int stepBy) {
        List<Offset> list = points;
        if (points.size() >= 2) {
            IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, points.size() - 1), stepBy);
            int i = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 <= 0 || i > last) && (step2 >= 0 || last > i)) {
                return;
            }
            while (true) {
                long p1 = list.get(i).m2925unboximpl();
                long p2 = list.get(i + 1).m2925unboximpl();
                this.internalCanvas.drawLine(Offset.m2915getXimpl(p1), Offset.m2916getYimpl(p1), Offset.m2915getXimpl(p2), Offset.m2916getYimpl(p2), paint.asFrameworkPaint());
                if (i != last) {
                    i += step2;
                } else {
                    return;
                }
            }
        } else {
            int i2 = stepBy;
        }
    }

    /* renamed from: drawRawPoints-O7TthRY  reason: not valid java name */
    public void m3017drawRawPointsO7TthRY(int pointMode, float[] points, Paint paint) {
        Intrinsics.checkNotNullParameter(points, "points");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (points.length % 2 != 0) {
            throw new IllegalArgumentException("points must have an even number of values");
        } else if (PointMode.m3477equalsimpl0(pointMode, PointMode.Companion.m3481getLinesr_lszbg())) {
            drawRawLines(points, paint, 2);
        } else if (PointMode.m3477equalsimpl0(pointMode, PointMode.Companion.m3483getPolygonr_lszbg())) {
            drawRawLines(points, paint, 1);
        } else if (PointMode.m3477equalsimpl0(pointMode, PointMode.Companion.m3482getPointsr_lszbg())) {
            drawRawPoints(points, paint, 2);
        }
    }

    private final void drawRawPoints(float[] points, Paint paint, int stepBy) {
        if (points.length % 2 == 0) {
            IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, points.length - 1), stepBy);
            int i = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && i <= last) || (step2 < 0 && last <= i)) {
                while (true) {
                    this.internalCanvas.drawPoint(points[i], points[i + 1], paint.asFrameworkPaint());
                    if (i != last) {
                        i += step2;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private final void drawRawLines(float[] points, Paint paint, int stepBy) {
        float[] fArr = points;
        if (fArr.length < 4 || fArr.length % 2 != 0) {
            return;
        }
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, fArr.length - 3), stepBy * 2);
        int i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 <= 0 || i > last) && (step2 >= 0 || last > i)) {
            return;
        }
        while (true) {
            float x1 = fArr[i];
            float y1 = fArr[i + 1];
            float x2 = fArr[i + 2];
            this.internalCanvas.drawLine(x1, y1, x2, fArr[i + 3], paint.asFrameworkPaint());
            if (i != last) {
                i += step2;
            } else {
                return;
            }
        }
    }

    /* renamed from: drawVertices-TPEHhCM  reason: not valid java name */
    public void m3018drawVerticesTPEHhCM(Vertices vertices, int blendMode, Paint paint) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawVertices(AndroidVertexMode_androidKt.m3061toAndroidVertexModeJOOmi9M(vertices.m3597getVertexModec2xauaI()), vertices.getPositions().length, vertices.getPositions(), 0, vertices.getTextureCoordinates(), 0, vertices.getColors(), 0, vertices.getIndices(), 0, vertices.getIndices().length, paint.asFrameworkPaint());
    }
}
