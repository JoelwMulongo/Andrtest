package androidx.compose.foundation;

import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u000b\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u001a/\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a1\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001cH\u0002\u001a:\u0010\u001d\u001a\u00020\u001b*\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001aA\u0010#\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001aW\u0010+\u001a\u00020\u001b*\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010!\u001a\u00020,2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.\u001a\u0012\u0010/\u001a\u00020 *\b\u0012\u0004\u0012\u00020 0\u001fH\u0002\u001a!\u00100\u001a\u000201*\u0002012\u0006\u00102\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00104\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00065"}, d2 = {"createInsetRoundedRect", "Landroidx/compose/ui/geometry/RoundRect;", "widthPx", "", "roundedRect", "createRoundRectPath", "Landroidx/compose/ui/graphics/Path;", "targetPath", "strokeWidth", "fillArea", "", "border", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/BorderStroke;", "shape", "Landroidx/compose/ui/graphics/Shape;", "width", "Landroidx/compose/ui/unit/Dp;", "brush", "Landroidx/compose/ui/graphics/Brush;", "border-ziNgDLE", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "border-xT4_qwU", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "drawContentWithoutBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "drawGenericBorder", "borderCacheRef", "Landroidx/compose/ui/node/Ref;", "Landroidx/compose/foundation/BorderCache;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "drawRectBorder", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "strokeWidthPx", "drawRectBorder-NsqcLGU", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;JJZF)Landroidx/compose/ui/draw/DrawResult;", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "drawRoundRectBorder-SYlcjDY", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/node/Ref;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "obtain", "shrink", "Landroidx/compose/ui/geometry/CornerRadius;", "value", "shrink-Kibmq7A", "(JF)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Border.kt */
public final class BorderKt {
    public static /* synthetic */ Modifier border$default(Modifier modifier, BorderStroke borderStroke, Shape shape, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return border(modifier, borderStroke, shape);
    }

    public static final Modifier border(Modifier $this$border, BorderStroke border, Shape shape) {
        Intrinsics.checkNotNullParameter($this$border, "<this>");
        Intrinsics.checkNotNullParameter(border, OutlinedTextFieldKt.BorderId);
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m461borderziNgDLE($this$border, border.m467getWidthD9Ej5fM(), border.getBrush(), shape);
    }

    /* renamed from: border-xT4_qwU$default  reason: not valid java name */
    public static /* synthetic */ Modifier m460borderxT4_qwU$default(Modifier modifier, float f, long j, Shape shape, int i, Object obj) {
        if ((i & 4) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        return m459borderxT4_qwU(modifier, f, j, shape);
    }

    /* renamed from: border-xT4_qwU  reason: not valid java name */
    public static final Modifier m459borderxT4_qwU(Modifier $this$border_u2dxT4_qwU, float width, long color, Shape shape) {
        Intrinsics.checkNotNullParameter($this$border_u2dxT4_qwU, "$this$border");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m461borderziNgDLE($this$border_u2dxT4_qwU, width, new SolidColor(color, (DefaultConstructorMarker) null), shape);
    }

    /* renamed from: border-ziNgDLE  reason: not valid java name */
    public static final Modifier m461borderziNgDLE(Modifier $this$border_u2dziNgDLE, float width, Brush brush, Shape shape) {
        Intrinsics.checkNotNullParameter($this$border_u2dziNgDLE, "$this$border");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return ComposedModifierKt.composed($this$border_u2dziNgDLE, InspectableValueKt.isDebugInspectorInfoEnabled() ? new BorderKt$borderziNgDLE$$inlined$debugInspectorInfo$1(width, brush, shape) : InspectableValueKt.getNoInspectorInfo(), new BorderKt$border$2(width, shape, brush));
    }

    private static final BorderCache obtain(Ref<BorderCache> $this$obtain) {
        BorderCache value = $this$obtain.getValue();
        if (value != null) {
            return value;
        }
        BorderCache it = new BorderCache((ImageBitmap) null, (Canvas) null, (CanvasDrawScope) null, (Path) null, 15, (DefaultConstructorMarker) null);
        $this$obtain.setValue(it);
        return it;
    }

    /* access modifiers changed from: private */
    public static final DrawResult drawContentWithoutBorder(CacheDrawScope $this$drawContentWithoutBorder) {
        return $this$drawContentWithoutBorder.onDrawWithContent(BorderKt$drawContentWithoutBorder$1.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00cd, code lost:
        if (androidx.compose.ui.graphics.ImageBitmapConfig.m3375equalsimpl(r13, r3) != false) goto L_0x00cf;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.draw.DrawResult drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope r66, androidx.compose.ui.node.Ref<androidx.compose.foundation.BorderCache> r67, androidx.compose.ui.graphics.Brush r68, androidx.compose.ui.graphics.Outline.Generic r69, boolean r70, float r71) {
        /*
            r0 = r66
            r15 = r68
            if (r70 == 0) goto L_0x0015
            androidx.compose.foundation.BorderKt$drawGenericBorder$1 r1 = new androidx.compose.foundation.BorderKt$drawGenericBorder$1
            r14 = r69
            r1.<init>(r14, r15)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            androidx.compose.ui.draw.DrawResult r1 = r0.onDrawWithContent(r1)
            goto L_0x0305
        L_0x0015:
            r14 = r69
            r1 = 0
            r2 = 0
            boolean r3 = r15 instanceof androidx.compose.ui.graphics.SolidColor
            if (r3 == 0) goto L_0x0037
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r3 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r1 = r3.m3380getAlpha8_sVssgQ()
            androidx.compose.ui.graphics.ColorFilter$Companion r3 = androidx.compose.ui.graphics.ColorFilter.Companion
            r4 = r15
            androidx.compose.ui.graphics.SolidColor r4 = (androidx.compose.ui.graphics.SolidColor) r4
            long r4 = r4.m3529getValue0d7_KjU()
            r6 = 0
            r7 = 2
            r8 = 0
            androidx.compose.ui.graphics.ColorFilter r2 = androidx.compose.ui.graphics.ColorFilter.Companion.m3205tintxETnrds$default(r3, r4, r6, r7, r8)
            r13 = r1
            r19 = r2
            goto L_0x0041
        L_0x0037:
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r3 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r1 = r3.m3381getArgb8888_sVssgQ()
            r2 = 0
            r13 = r1
            r19 = r2
        L_0x0041:
            androidx.compose.ui.graphics.Path r1 = r69.getPath()
            androidx.compose.ui.geometry.Rect r12 = r1.getBounds()
            androidx.compose.foundation.BorderCache r20 = obtain(r67)
            androidx.compose.ui.graphics.Path r11 = r20.obtainPath()
            r1 = r11
            r2 = 0
            r1.reset()
            r1.addRect(r12)
            androidx.compose.ui.graphics.Path r3 = r69.getPath()
            androidx.compose.ui.graphics.PathOperation$Companion r4 = androidx.compose.ui.graphics.PathOperation.Companion
            int r4 = r4.m3468getDifferenceb3I0S0c()
            r1.m3444opN5in7k0(r1, r3, r4)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            r10 = r1
            float r1 = r12.getWidth()
            double r1 = (double) r1
            double r1 = java.lang.Math.ceil(r1)
            float r1 = (float) r1
            int r1 = (int) r1
            float r2 = r12.getHeight()
            double r2 = (double) r2
            double r2 = java.lang.Math.ceil(r2)
            float r2 = (float) r2
            int r2 = (int) r2
            long r21 = androidx.compose.ui.unit.IntSizeKt.IntSize(r1, r2)
            r23 = r20
            r24 = 0
            r1 = r66
            r2 = r23
            r25 = r1
            r26 = 0
            androidx.compose.ui.graphics.ImageBitmap r1 = r2.imageBitmap
            androidx.compose.ui.graphics.Canvas r16 = r2.canvas
            r3 = 0
            if (r1 == 0) goto L_0x00a8
            int r4 = r1.m3372getConfig_sVssgQ()
            androidx.compose.ui.graphics.ImageBitmapConfig r4 = androidx.compose.ui.graphics.ImageBitmapConfig.m3373boximpl(r4)
            goto L_0x00a9
        L_0x00a8:
            r4 = r3
        L_0x00a9:
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r5 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r5 = r5.m3381getArgb8888_sVssgQ()
            r6 = 0
            if (r4 != 0) goto L_0x00b4
            r4 = r6
            goto L_0x00bc
        L_0x00b4:
            int r4 = r4.m3379unboximpl()
            boolean r4 = androidx.compose.ui.graphics.ImageBitmapConfig.m3376equalsimpl0(r4, r5)
        L_0x00bc:
            r9 = 1
            if (r4 != 0) goto L_0x00cf
            if (r1 == 0) goto L_0x00c9
            int r3 = r1.m3372getConfig_sVssgQ()
            androidx.compose.ui.graphics.ImageBitmapConfig r3 = androidx.compose.ui.graphics.ImageBitmapConfig.m3373boximpl(r3)
        L_0x00c9:
            boolean r3 = androidx.compose.ui.graphics.ImageBitmapConfig.m3375equalsimpl(r13, r3)
            if (r3 == 0) goto L_0x00d0
        L_0x00cf:
            r6 = r9
        L_0x00d0:
            r27 = r6
            if (r1 == 0) goto L_0x0102
            if (r16 == 0) goto L_0x0102
            long r3 = r25.m2824getSizeNHjbRc()
            float r3 = androidx.compose.ui.geometry.Size.m2984getWidthimpl(r3)
            int r4 = r1.getWidth()
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x0102
            long r3 = r25.m2824getSizeNHjbRc()
            float r3 = androidx.compose.ui.geometry.Size.m2981getHeightimpl(r3)
            int r4 = r1.getHeight()
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x0102
            if (r27 != 0) goto L_0x00fb
            goto L_0x0102
        L_0x00fb:
            r18 = r10
            r8 = r16
            r10 = r9
            r9 = r1
            goto L_0x0133
        L_0x0102:
            int r3 = androidx.compose.ui.unit.IntSize.m6146getWidthimpl(r21)
            int r4 = androidx.compose.ui.unit.IntSize.m6145getHeightimpl(r21)
            r6 = 0
            r7 = 0
            r8 = 24
            r17 = 0
            r5 = r13
            r18 = r10
            r10 = r9
            r9 = r17
            androidx.compose.ui.graphics.ImageBitmap r3 = androidx.compose.ui.graphics.ImageBitmapKt.m3386ImageBitmapx__hDU$default(r3, r4, r5, r6, r7, r8, r9)
            r4 = r3
            r5 = 0
            r2.imageBitmap = r4
            r1 = r3
            androidx.compose.ui.graphics.Canvas r3 = androidx.compose.ui.graphics.CanvasKt.Canvas(r1)
            r4 = r3
            r5 = 0
            r2.canvas = r4
            r16 = r3
            r9 = r1
            r8 = r16
        L_0x0133:
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope r1 = r2.canvasDrawScope
            if (r1 != 0) goto L_0x0143
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope r1 = new androidx.compose.ui.graphics.drawscope.CanvasDrawScope
            r1.<init>()
            r3 = r1
            r4 = 0
            r2.canvasDrawScope = r3
        L_0x0143:
            r28 = r1
            long r6 = androidx.compose.ui.unit.IntSizeKt.m6156toSizeozmzZPI(r21)
            androidx.compose.ui.unit.LayoutDirection r1 = r25.getLayoutDirection()
            r42 = r28
            r5 = r1
            r43 = 0
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r1 = r42.getDrawParams()
            androidx.compose.ui.unit.Density r4 = r1.component1()
            androidx.compose.ui.unit.LayoutDirection r3 = r1.component2()
            androidx.compose.ui.graphics.Canvas r15 = r1.component3()
            r16 = r15
            long r14 = r1.m3672component4NHjbRc()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r1 = r42.getDrawParams()
            r17 = 0
            r10 = r25
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            r1.setDensity(r10)
            r1.setLayoutDirection(r5)
            r1.setCanvas(r8)
            r1.m3675setSizeuvyYCjk(r6)
            r8.save()
            r45 = r42
            androidx.compose.ui.graphics.drawscope.DrawScope r45 = (androidx.compose.ui.graphics.drawscope.DrawScope) r45
            r46 = 0
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r30 = r1.m3190getBlack0d7_KjU()
            r32 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            androidx.compose.ui.graphics.BlendMode$Companion r1 = androidx.compose.ui.graphics.BlendMode.Companion
            int r39 = r1.m3070getClear0nO6VwU()
            r40 = 58
            r41 = 0
            r29 = r45
            r34 = r6
            androidx.compose.ui.graphics.drawscope.DrawScope.m3748drawRectnJ9OG0$default(r29, r30, r32, r34, r36, r37, r38, r39, r40, r41)
            r30 = 0
            float r1 = r12.getLeft()
            float r10 = -r1
            float r1 = r12.getTop()
            float r1 = -r1
            r31 = r29
            r32 = 0
            androidx.compose.ui.graphics.drawscope.DrawContext r17 = r31.getDrawContext()
            r33 = r2
            androidx.compose.ui.graphics.drawscope.DrawTransform r2 = r17.getTransform()
            r2.translate(r10, r1)
            r2 = r1
            r1 = r31
            r34 = 0
            androidx.compose.ui.graphics.Path r17 = r69.getPath()
            r35 = 0
            androidx.compose.ui.graphics.drawscope.Stroke r36 = new androidx.compose.ui.graphics.drawscope.Stroke
            r37 = r2
            r2 = 2
            float r2 = (float) r2
            float r48 = r71 * r2
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = 0
            r53 = 30
            r54 = 0
            r47 = r36
            r47.<init>(r48, r49, r50, r51, r52, r53, r54)
            androidx.compose.ui.graphics.drawscope.DrawStyle r36 = (androidx.compose.ui.graphics.drawscope.DrawStyle) r36
            r39 = 0
            r40 = 52
            r55 = r37
            r2 = r17
            r56 = r3
            r3 = r68
            r57 = r4
            r4 = r35
            r35 = r5
            r5 = r36
            r36 = r6
            r6 = r38
            r7 = r39
            r38 = r8
            r8 = r40
            r39 = r9
            r9 = r41
            androidx.compose.ui.graphics.drawscope.DrawScope.m3743drawPathGBMwjPU$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            long r2 = r1.m3772getSizeNHjbRc()
            float r2 = androidx.compose.ui.geometry.Size.m2984getWidthimpl(r2)
            r3 = 1
            float r3 = (float) r3
            float r2 = r2 + r3
            long r4 = r1.m3772getSizeNHjbRc()
            float r4 = androidx.compose.ui.geometry.Size.m2984getWidthimpl(r4)
            float r2 = r2 / r4
            long r4 = r1.m3772getSizeNHjbRc()
            float r4 = androidx.compose.ui.geometry.Size.m2981getHeightimpl(r4)
            float r4 = r4 + r3
            long r5 = r1.m3772getSizeNHjbRc()
            float r3 = androidx.compose.ui.geometry.Size.m2981getHeightimpl(r5)
            float r4 = r4 / r3
            r3 = r1
            long r5 = r3.m3771getCenterF1C5BW0()
            r7 = 0
            r8 = r3
            r9 = 0
            r40 = r14
            androidx.compose.ui.graphics.drawscope.DrawContext r15 = r8.getDrawContext()
            r44 = 0
            r17 = r13
            long r13 = r15.m3715getSizeNHjbRc()
            androidx.compose.ui.graphics.Canvas r47 = r15.getCanvas()
            r47.save()
            r47 = r1
            androidx.compose.ui.graphics.drawscope.DrawTransform r1 = r15.getTransform()
            r48 = 0
            r1.m3831scale0AR0LA0(r2, r4, r5)
            r58 = r10
            r1 = r18
            r10 = r8
            r48 = 0
            r18 = 0
            r49 = 0
            r50 = 0
            androidx.compose.ui.graphics.BlendMode$Companion r51 = androidx.compose.ui.graphics.BlendMode.Companion
            int r51 = r51.m3070getClear0nO6VwU()
            r52 = 28
            r53 = 0
            r54 = r12
            r12 = r68
            r61 = r2
            r60 = r3
            r2 = r13
            r59 = r17
            r13 = r18
            r62 = r5
            r64 = r40
            r40 = r4
            r4 = r64
            r14 = r49
            r41 = r15
            r6 = r16
            r15 = r50
            r16 = r51
            r17 = r52
            r18 = r53
            androidx.compose.ui.graphics.drawscope.DrawScope.m3743drawPathGBMwjPU$default(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            androidx.compose.ui.graphics.Canvas r10 = r41.getCanvas()
            r10.restore()
            r10 = r41
            r10.m3716setSizeuvyYCjk(r2)
            androidx.compose.ui.graphics.drawscope.DrawContext r2 = r31.getDrawContext()
            androidx.compose.ui.graphics.drawscope.DrawTransform r2 = r2.getTransform()
            r3 = r58
            float r7 = -r3
            r8 = r55
            float r9 = -r8
            r2.translate(r7, r9)
            r38.restore()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r2 = r42.getDrawParams()
            r3 = 0
            r7 = r57
            r2.setDensity(r7)
            r8 = r56
            r2.setLayoutDirection(r8)
            r2.setCanvas(r6)
            r2.m3675setSizeuvyYCjk(r4)
            r39.prepareToDraw()
            r2 = r39
            r1.element = r2
            androidx.compose.foundation.BorderKt$drawGenericBorder$3 r7 = new androidx.compose.foundation.BorderKt$drawGenericBorder$3
            r8 = r1
            r1 = r7
            r2 = r54
            r3 = r8
            r4 = r21
            r6 = r19
            r1.<init>(r2, r3, r4, r6)
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            androidx.compose.ui.draw.DrawResult r1 = r0.onDrawWithContent(r7)
        L_0x0305:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderKt.drawGenericBorder(androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.node.Ref, androidx.compose.ui.graphics.Brush, androidx.compose.ui.graphics.Outline$Generic, boolean, float):androidx.compose.ui.draw.DrawResult");
    }

    /* access modifiers changed from: private */
    /* renamed from: drawRoundRectBorder-SYlcjDY  reason: not valid java name */
    public static final DrawResult m463drawRoundRectBorderSYlcjDY(CacheDrawScope $this$drawRoundRectBorder_u2dSYlcjDY, Ref<BorderCache> borderCacheRef, Brush brush, Outline.Rounded outline, long topLeft, long borderSize, boolean fillArea, float strokeWidth) {
        CacheDrawScope cacheDrawScope = $this$drawRoundRectBorder_u2dSYlcjDY;
        float f = strokeWidth;
        if (!RoundRectKt.isSimple(outline.getRoundRect())) {
            return cacheDrawScope.onDrawWithContent(new BorderKt$drawRoundRectBorder$2(createRoundRectPath(obtain(borderCacheRef).obtainPath(), outline.getRoundRect(), f, fillArea), brush));
        }
        Brush brush2 = brush;
        boolean z = fillArea;
        return cacheDrawScope.onDrawWithContent(new BorderKt$drawRoundRectBorder$1(fillArea, brush, outline.getRoundRect().m2965getTopLeftCornerRadiuskKHJgLs(), f / ((float) 2), strokeWidth, topLeft, borderSize, new Stroke(strokeWidth, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null)));
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [androidx.compose.ui.graphics.drawscope.Fill] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: drawRectBorder-NsqcLGU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.draw.DrawResult m462drawRectBorderNsqcLGU(androidx.compose.ui.draw.CacheDrawScope r16, androidx.compose.ui.graphics.Brush r17, long r18, long r20, boolean r22, float r23) {
        /*
            if (r22 == 0) goto L_0x000a
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m2931getZeroF1C5BW0()
            r4 = r0
            goto L_0x000c
        L_0x000a:
            r4 = r18
        L_0x000c:
            if (r22 == 0) goto L_0x0014
            long r0 = r16.m2824getSizeNHjbRc()
            r6 = r0
            goto L_0x0016
        L_0x0014:
            r6 = r20
        L_0x0016:
            if (r22 == 0) goto L_0x001b
            androidx.compose.ui.graphics.drawscope.Fill r0 = androidx.compose.ui.graphics.drawscope.Fill.INSTANCE
            goto L_0x002a
        L_0x001b:
            androidx.compose.ui.graphics.drawscope.Stroke r0 = new androidx.compose.ui.graphics.drawscope.Stroke
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 30
            r15 = 0
            r8 = r0
            r9 = r23
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
        L_0x002a:
            androidx.compose.ui.graphics.drawscope.DrawStyle r0 = (androidx.compose.ui.graphics.drawscope.DrawStyle) r0
            r8 = r0
            androidx.compose.foundation.BorderKt$drawRectBorder$1 r0 = new androidx.compose.foundation.BorderKt$drawRectBorder$1
            r2 = r0
            r3 = r17
            r2.<init>(r3, r4, r6, r8)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = r16
            androidx.compose.ui.draw.DrawResult r0 = r1.onDrawWithContent(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderKt.m462drawRectBorderNsqcLGU(androidx.compose.ui.draw.CacheDrawScope, androidx.compose.ui.graphics.Brush, long, long, boolean, float):androidx.compose.ui.draw.DrawResult");
    }

    private static final Path createRoundRectPath(Path targetPath, RoundRect roundedRect, float strokeWidth, boolean fillArea) {
        Path $this$createRoundRectPath_u24lambda_u248 = targetPath;
        $this$createRoundRectPath_u24lambda_u248.reset();
        $this$createRoundRectPath_u24lambda_u248.addRoundRect(roundedRect);
        if (!fillArea) {
            Path insetPath = AndroidPath_androidKt.Path();
            insetPath.addRoundRect(createInsetRoundedRect(strokeWidth, roundedRect));
            $this$createRoundRectPath_u24lambda_u248.m3444opN5in7k0($this$createRoundRectPath_u24lambda_u248, insetPath, PathOperation.Companion.m3468getDifferenceb3I0S0c());
        }
        return targetPath;
    }

    private static final RoundRect createInsetRoundedRect(float widthPx, RoundRect roundedRect) {
        float f = widthPx;
        return new RoundRect(widthPx, widthPx, roundedRect.getWidth() - f, roundedRect.getHeight() - f, m464shrinkKibmq7A(roundedRect.m2965getTopLeftCornerRadiuskKHJgLs(), f), m464shrinkKibmq7A(roundedRect.m2966getTopRightCornerRadiuskKHJgLs(), f), m464shrinkKibmq7A(roundedRect.m2964getBottomRightCornerRadiuskKHJgLs(), f), m464shrinkKibmq7A(roundedRect.m2963getBottomLeftCornerRadiuskKHJgLs(), f), (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: shrink-Kibmq7A  reason: not valid java name */
    public static final long m464shrinkKibmq7A(long $this$shrink_u2dKibmq7A, float value) {
        return CornerRadiusKt.CornerRadius(Math.max(0.0f, CornerRadius.m2890getXimpl($this$shrink_u2dKibmq7A) - value), Math.max(0.0f, CornerRadius.m2891getYimpl($this$shrink_u2dKibmq7A) - value));
    }
}
