package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0014J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J5\u0010\u001e\u001a\u00020\n*\u00020\t2\u0006\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J\f\u0010\"\u001a\u00020\n*\u00020\tH$R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\rX¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/ui/graphics/painter/Painter;", "", "()V", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "drawLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "layerPaint", "Landroidx/compose/ui/graphics/Paint;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "useLayer", "", "applyAlpha", "applyColorFilter", "applyLayoutDirection", "configureAlpha", "configureColorFilter", "configureLayoutDirection", "rtl", "obtainPaint", "draw", "size", "draw-x_KDEd0", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/ui/graphics/ColorFilter;)V", "onDraw", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Painter.kt */
public abstract class Painter {
    private float alpha = 1.0f;
    private ColorFilter colorFilter;
    private final Function1<DrawScope, Unit> drawLambda = new Painter$drawLambda$1(this);
    private Paint layerPaint;
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private boolean useLayer;

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public abstract long m3867getIntrinsicSizeNHjbRc();

    /* access modifiers changed from: protected */
    public abstract void onDraw(DrawScope drawScope);

    private final Paint obtainPaint() {
        Paint target = this.layerPaint;
        if (target != null) {
            return target;
        }
        Paint target2 = AndroidPaint_androidKt.Paint();
        this.layerPaint = target2;
        return target2;
    }

    private final void configureColorFilter(ColorFilter colorFilter2) {
        if (!Intrinsics.areEqual((Object) this.colorFilter, (Object) colorFilter2)) {
            if (!applyColorFilter(colorFilter2)) {
                if (colorFilter2 == null) {
                    Paint paint = this.layerPaint;
                    if (paint != null) {
                        paint.setColorFilter((ColorFilter) null);
                    }
                    this.useLayer = false;
                } else {
                    obtainPaint().setColorFilter(colorFilter2);
                    this.useLayer = true;
                }
            }
            this.colorFilter = colorFilter2;
        }
    }

    private final void configureAlpha(float alpha2) {
        if (!(this.alpha == alpha2)) {
            if (!applyAlpha(alpha2)) {
                if (alpha2 == 1.0f) {
                    Paint paint = this.layerPaint;
                    if (paint != null) {
                        paint.setAlpha(alpha2);
                    }
                    this.useLayer = false;
                } else {
                    obtainPaint().setAlpha(alpha2);
                    this.useLayer = true;
                }
            }
            this.alpha = alpha2;
        }
    }

    private final void configureLayoutDirection(LayoutDirection rtl) {
        if (this.layoutDirection != rtl) {
            applyLayoutDirection(rtl);
            this.layoutDirection = rtl;
        }
    }

    /* access modifiers changed from: protected */
    public boolean applyAlpha(float alpha2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean applyColorFilter(ColorFilter colorFilter2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean applyLayoutDirection(LayoutDirection layoutDirection2) {
        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
        return false;
    }

    /* renamed from: draw-x_KDEd0$default  reason: not valid java name */
    public static /* synthetic */ void m3865drawx_KDEd0$default(Painter painter, DrawScope drawScope, long j, float f, ColorFilter colorFilter2, int i, Object obj) {
        float f2;
        ColorFilter colorFilter3;
        if (obj == null) {
            if ((i & 2) != 0) {
                f2 = 1.0f;
            } else {
                f2 = f;
            }
            if ((i & 4) != 0) {
                colorFilter3 = null;
            } else {
                colorFilter3 = colorFilter2;
            }
            painter.m3866drawx_KDEd0(drawScope, j, f2, colorFilter3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: draw-x_KDEd0");
    }

    /* renamed from: draw-x_KDEd0  reason: not valid java name */
    public final void m3866drawx_KDEd0(DrawScope $this$draw_u2dx_KDEd0, long size, float alpha2, ColorFilter colorFilter2) {
        float f = alpha2;
        Intrinsics.checkNotNullParameter($this$draw_u2dx_KDEd0, "$this$draw");
        configureAlpha(f);
        configureColorFilter(colorFilter2);
        configureLayoutDirection($this$draw_u2dx_KDEd0.getLayoutDirection());
        float r0 = Size.m2984getWidthimpl($this$draw_u2dx_KDEd0.m3772getSizeNHjbRc()) - Size.m2984getWidthimpl(size);
        float bottom$iv = Size.m2981getHeightimpl($this$draw_u2dx_KDEd0.m3772getSizeNHjbRc()) - Size.m2981getHeightimpl(size);
        DrawScope $this$inset$iv = $this$draw_u2dx_KDEd0;
        float right$iv = r0;
        $this$inset$iv.getDrawContext().getTransform().inset(0.0f, 0.0f, right$iv, bottom$iv);
        DrawScope $this$draw_x_KDEd0_u24lambda_u242 = $this$inset$iv;
        if (f > 0.0f && Size.m2984getWidthimpl(size) > 0.0f && Size.m2981getHeightimpl(size) > 0.0f) {
            if (this.useLayer) {
                Rect layerRect = RectKt.m2955Recttz77jQw(Offset.Companion.m2931getZeroF1C5BW0(), SizeKt.Size(Size.m2984getWidthimpl(size), Size.m2981getHeightimpl(size)));
                DrawScope $this$drawIntoCanvas$iv = $this$draw_x_KDEd0_u24lambda_u242;
                DrawScope drawScope = $this$drawIntoCanvas$iv;
                Canvas $this$withSaveLayer$iv = $this$drawIntoCanvas$iv.getDrawContext().getCanvas();
                try {
                    $this$withSaveLayer$iv.saveLayer(layerRect, obtainPaint());
                    onDraw($this$draw_x_KDEd0_u24lambda_u242);
                } finally {
                    $this$withSaveLayer$iv.restore();
                }
            } else {
                onDraw($this$draw_x_KDEd0_u24lambda_u242);
            }
        }
        $this$inset$iv.getDrawContext().getTransform().inset(-0.0f, -0.0f, -right$iv, -bottom$iv);
    }
}
