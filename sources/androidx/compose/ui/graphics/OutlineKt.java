package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001aQ\u0010\u0005\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001aQ\u0010\u0005\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0001\u0010\u001a\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042,\u0010\u001b\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b!2,\u0010\"\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110#¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b!2,\u0010%\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b!H\b\u001a\f\u0010'\u001a\u00020(*\u00020#H\u0002\u001a\u0014\u0010)\u001a\u00020**\u00020\u001dH\u0002ø\u0001\u0001¢\u0006\u0002\u0010+\u001a\u0014\u0010)\u001a\u00020**\u00020#H\u0002ø\u0001\u0001¢\u0006\u0002\u0010,\u001a\u0014\u0010-\u001a\u00020.*\u00020\u001dH\u0002ø\u0001\u0001¢\u0006\u0002\u0010+\u001a\u0014\u0010-\u001a\u00020.*\u00020#H\u0002ø\u0001\u0001¢\u0006\u0002\u0010,\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006/"}, d2 = {"addOutline", "", "Landroidx/compose/ui/graphics/Path;", "outline", "Landroidx/compose/ui/graphics/Outline;", "drawOutline", "Landroidx/compose/ui/graphics/Canvas;", "paint", "Landroidx/compose/ui/graphics/Paint;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawOutline-hn5TExg", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawOutline-wDX37Ww", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOutlineHelper", "drawRectBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Rect;", "Lkotlin/ParameterName;", "name", "rect", "Lkotlin/ExtensionFunctionType;", "drawRoundedRectBlock", "Landroidx/compose/ui/geometry/RoundRect;", "rrect", "drawPathBlock", "path", "hasSameCornerRadius", "", "size", "Landroidx/compose/ui/geometry/Size;", "(Landroidx/compose/ui/geometry/Rect;)J", "(Landroidx/compose/ui/geometry/RoundRect;)J", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Outline.kt */
public final class OutlineKt {
    public static final void addOutline(Path $this$addOutline, Outline outline) {
        Intrinsics.checkNotNullParameter($this$addOutline, "<this>");
        Intrinsics.checkNotNullParameter(outline, "outline");
        if (outline instanceof Outline.Rectangle) {
            $this$addOutline.addRect(((Outline.Rectangle) outline).getRect());
        } else if (outline instanceof Outline.Rounded) {
            $this$addOutline.addRoundRect(((Outline.Rounded) outline).getRoundRect());
        } else if (outline instanceof Outline.Generic) {
            Path.m3441addPathUv8p0NA$default($this$addOutline, ((Outline.Generic) outline).getPath(), 0, 2, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: drawOutline-wDX37Ww$default  reason: not valid java name */
    public static /* synthetic */ void m3419drawOutlinewDX37Ww$default(DrawScope drawScope, Outline outline, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        float f2;
        DrawStyle drawStyle2;
        if ((i2 & 4) != 0) {
            f2 = 1.0f;
        } else {
            f2 = f;
        }
        if ((i2 & 8) != 0) {
            drawStyle2 = Fill.INSTANCE;
        } else {
            drawStyle2 = drawStyle;
        }
        m3418drawOutlinewDX37Ww(drawScope, outline, j, f2, drawStyle2, (i2 & 16) != 0 ? null : colorFilter, (i2 & 32) != 0 ? DrawScope.Companion.m3773getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawOutline-wDX37Ww  reason: not valid java name */
    public static final void m3418drawOutlinewDX37Ww(DrawScope $this$drawOutline_u2dwDX37Ww, Outline outline, long color, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        Outline outline2 = outline;
        Intrinsics.checkNotNullParameter($this$drawOutline_u2dwDX37Ww, "$this$drawOutline");
        Intrinsics.checkNotNullParameter(outline2, "outline");
        Intrinsics.checkNotNullParameter(style, "style");
        DrawScope $this$drawOutlineHelper$iv = $this$drawOutline_u2dwDX37Ww;
        if (outline2 instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline2).getRect();
            $this$drawOutlineHelper$iv.m3768drawRectnJ9OG0(color, topLeft(rect), size(rect), alpha, style, colorFilter, blendMode);
        } else if (outline2 instanceof Outline.Rounded) {
            Path path$iv = ((Outline.Rounded) outline2).getRoundRectPath$ui_graphics_release();
            if (path$iv != null) {
                $this$drawOutlineHelper$iv.m3764drawPathLG529CI(path$iv, color, alpha, style, colorFilter, blendMode);
                return;
            }
            RoundRect rrect = ((Outline.Rounded) outline2).getRoundRect();
            float radius = CornerRadius.m2890getXimpl(rrect.m2963getBottomLeftCornerRadiuskKHJgLs());
            float f = radius;
            $this$drawOutlineHelper$iv.m3770drawRoundRectuAw5IA(color, topLeft(rrect), size(rrect), CornerRadiusKt.CornerRadius$default(radius, 0.0f, 2, (Object) null), style, alpha, colorFilter, blendMode);
        } else if (outline2 instanceof Outline.Generic) {
            $this$drawOutlineHelper$iv.m3764drawPathLG529CI(((Outline.Generic) outline2).getPath(), color, alpha, style, colorFilter, blendMode);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: drawOutline-hn5TExg$default  reason: not valid java name */
    public static /* synthetic */ void m3417drawOutlinehn5TExg$default(DrawScope drawScope, Outline outline, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        float f2;
        DrawStyle drawStyle2;
        if ((i2 & 4) != 0) {
            f2 = 1.0f;
        } else {
            f2 = f;
        }
        if ((i2 & 8) != 0) {
            drawStyle2 = Fill.INSTANCE;
        } else {
            drawStyle2 = drawStyle;
        }
        m3416drawOutlinehn5TExg(drawScope, outline, brush, f2, drawStyle2, (i2 & 16) != 0 ? null : colorFilter, (i2 & 32) != 0 ? DrawScope.Companion.m3773getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawOutline-hn5TExg  reason: not valid java name */
    public static final void m3416drawOutlinehn5TExg(DrawScope $this$drawOutline_u2dhn5TExg, Outline outline, Brush brush, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode) {
        Outline outline2 = outline;
        Intrinsics.checkNotNullParameter($this$drawOutline_u2dhn5TExg, "$this$drawOutline");
        Intrinsics.checkNotNullParameter(outline2, "outline");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(style, "style");
        DrawScope $this$drawOutlineHelper$iv = $this$drawOutline_u2dhn5TExg;
        if (outline2 instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline2).getRect();
            $this$drawOutlineHelper$iv.m3767drawRectAsUm42w(brush, topLeft(rect), size(rect), alpha, style, colorFilter, blendMode);
        } else if (outline2 instanceof Outline.Rounded) {
            Path path$iv = ((Outline.Rounded) outline2).getRoundRectPath$ui_graphics_release();
            if (path$iv != null) {
                $this$drawOutlineHelper$iv.m3763drawPathGBMwjPU(path$iv, brush, alpha, style, colorFilter, blendMode);
                return;
            }
            RoundRect rrect = ((Outline.Rounded) outline2).getRoundRect();
            float radius = CornerRadius.m2890getXimpl(rrect.m2963getBottomLeftCornerRadiuskKHJgLs());
            float f = radius;
            $this$drawOutlineHelper$iv.m3769drawRoundRectZuiqVtQ(brush, topLeft(rrect), size(rrect), CornerRadiusKt.CornerRadius$default(radius, 0.0f, 2, (Object) null), alpha, style, colorFilter, blendMode);
        } else if (outline2 instanceof Outline.Generic) {
            $this$drawOutlineHelper$iv.m3763drawPathGBMwjPU(((Outline.Generic) outline2).getPath(), brush, alpha, style, colorFilter, blendMode);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private static final long topLeft(Rect $this$topLeft) {
        return OffsetKt.Offset($this$topLeft.getLeft(), $this$topLeft.getTop());
    }

    private static final long size(Rect $this$size) {
        return SizeKt.Size($this$size.getWidth(), $this$size.getHeight());
    }

    private static final long topLeft(RoundRect $this$topLeft) {
        return OffsetKt.Offset($this$topLeft.getLeft(), $this$topLeft.getTop());
    }

    private static final long size(RoundRect $this$size) {
        return SizeKt.Size($this$size.getWidth(), $this$size.getHeight());
    }

    private static final void drawOutlineHelper(DrawScope $this$drawOutlineHelper, Outline outline, Function2<? super DrawScope, ? super Rect, Unit> drawRectBlock, Function2<? super DrawScope, ? super RoundRect, Unit> drawRoundedRectBlock, Function2<? super DrawScope, ? super Path, Unit> drawPathBlock) {
        if (outline instanceof Outline.Rectangle) {
            drawRectBlock.invoke($this$drawOutlineHelper, ((Outline.Rectangle) outline).getRect());
        } else if (outline instanceof Outline.Rounded) {
            Path path = ((Outline.Rounded) outline).getRoundRectPath$ui_graphics_release();
            if (path != null) {
                drawPathBlock.invoke($this$drawOutlineHelper, path);
            } else {
                drawRoundedRectBlock.invoke($this$drawOutlineHelper, ((Outline.Rounded) outline).getRoundRect());
            }
        } else if (outline instanceof Outline.Generic) {
            drawPathBlock.invoke($this$drawOutlineHelper, ((Outline.Generic) outline).getPath());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final void drawOutline(Canvas $this$drawOutline, Outline outline, Paint paint) {
        Intrinsics.checkNotNullParameter($this$drawOutline, "<this>");
        Intrinsics.checkNotNullParameter(outline, "outline");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (outline instanceof Outline.Rectangle) {
            $this$drawOutline.drawRect(((Outline.Rectangle) outline).getRect(), paint);
        } else if (outline instanceof Outline.Rounded) {
            Path path = ((Outline.Rounded) outline).getRoundRectPath$ui_graphics_release();
            if (path != null) {
                $this$drawOutline.drawPath(path, paint);
                return;
            }
            $this$drawOutline.drawRoundRect(((Outline.Rounded) outline).getRoundRect().getLeft(), ((Outline.Rounded) outline).getRoundRect().getTop(), ((Outline.Rounded) outline).getRoundRect().getRight(), ((Outline.Rounded) outline).getRoundRect().getBottom(), CornerRadius.m2890getXimpl(((Outline.Rounded) outline).getRoundRect().m2963getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m2891getYimpl(((Outline.Rounded) outline).getRoundRect().m2963getBottomLeftCornerRadiuskKHJgLs()), paint);
        } else if (outline instanceof Outline.Generic) {
            $this$drawOutline.drawPath(((Outline.Generic) outline).getPath(), paint);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a2 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean hasSameCornerRadius(androidx.compose.ui.geometry.RoundRect r6) {
        /*
            long r0 = r6.m2963getBottomLeftCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2890getXimpl(r0)
            long r1 = r6.m2964getBottomRightCornerRadiuskKHJgLs()
            float r1 = androidx.compose.ui.geometry.CornerRadius.m2890getXimpl(r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0018
            r0 = r1
            goto L_0x0019
        L_0x0018:
            r0 = r2
        L_0x0019:
            if (r0 == 0) goto L_0x004f
            long r3 = r6.m2964getBottomRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2890getXimpl(r3)
            long r3 = r6.m2966getTopRightCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m2890getXimpl(r3)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0031
            r0 = r1
            goto L_0x0032
        L_0x0031:
            r0 = r2
        L_0x0032:
            if (r0 == 0) goto L_0x004f
            long r3 = r6.m2966getTopRightCornerRadiuskKHJgLs()
            float r0 = androidx.compose.ui.geometry.CornerRadius.m2890getXimpl(r3)
            long r3 = r6.m2965getTopLeftCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m2890getXimpl(r3)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x004a
            r0 = r1
            goto L_0x004b
        L_0x004a:
            r0 = r2
        L_0x004b:
            if (r0 == 0) goto L_0x004f
            r0 = r1
            goto L_0x0050
        L_0x004f:
            r0 = r2
        L_0x0050:
            long r3 = r6.m2963getBottomLeftCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m2891getYimpl(r3)
            long r4 = r6.m2964getBottomRightCornerRadiuskKHJgLs()
            float r4 = androidx.compose.ui.geometry.CornerRadius.m2891getYimpl(r4)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0067
            r3 = r1
            goto L_0x0068
        L_0x0067:
            r3 = r2
        L_0x0068:
            if (r3 == 0) goto L_0x009e
            long r3 = r6.m2964getBottomRightCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m2891getYimpl(r3)
            long r4 = r6.m2966getTopRightCornerRadiuskKHJgLs()
            float r4 = androidx.compose.ui.geometry.CornerRadius.m2891getYimpl(r4)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0080
            r3 = r1
            goto L_0x0081
        L_0x0080:
            r3 = r2
        L_0x0081:
            if (r3 == 0) goto L_0x009e
            long r3 = r6.m2966getTopRightCornerRadiuskKHJgLs()
            float r3 = androidx.compose.ui.geometry.CornerRadius.m2891getYimpl(r3)
            long r4 = r6.m2965getTopLeftCornerRadiuskKHJgLs()
            float r4 = androidx.compose.ui.geometry.CornerRadius.m2891getYimpl(r4)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0099
            r3 = r1
            goto L_0x009a
        L_0x0099:
            r3 = r2
        L_0x009a:
            if (r3 == 0) goto L_0x009e
            r3 = r1
            goto L_0x009f
        L_0x009e:
            r3 = r2
        L_0x009f:
            if (r0 == 0) goto L_0x00a5
            if (r3 == 0) goto L_0x00a5
            goto L_0x00a6
        L_0x00a5:
            r1 = r2
        L_0x00a6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.OutlineKt.hasSameCornerRadius(androidx.compose.ui.geometry.RoundRect):boolean");
    }
}
