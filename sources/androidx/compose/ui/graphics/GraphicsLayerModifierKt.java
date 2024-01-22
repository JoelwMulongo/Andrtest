package androidx.compose.ui.graphics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0007\u001a\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a§\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a»\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001aÅ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010#\u001a\u00020$H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\u001a\f\u0010'\u001a\u00020\u0001*\u00020\u0001H\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, d2 = {"graphicsLayer", "Landroidx/compose/ui/Modifier;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "graphicsLayer-sKFY_QE", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;Z)Landroidx/compose/ui/Modifier;", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "graphicsLayer-2Xn7asI", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;)Landroidx/compose/ui/Modifier;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "graphicsLayer-pANQ8Wg", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJ)Landroidx/compose/ui/Modifier;", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "graphicsLayer-Ap8cVGQ", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJI)Landroidx/compose/ui/Modifier;", "toolingGraphicsLayer", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: GraphicsLayerModifier.kt */
public final class GraphicsLayerModifierKt {
    /* renamed from: graphicsLayer-sKFY_QE$default  reason: not valid java name */
    public static /* synthetic */ Modifier m3314graphicsLayersKFY_QE$default(Modifier modifier, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, int i, Object obj) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        Shape shape2;
        boolean z2;
        int i2 = i;
        float f19 = 1.0f;
        if ((i2 & 1) != 0) {
            f11 = 1.0f;
        } else {
            f11 = f;
        }
        if ((i2 & 2) != 0) {
            f12 = 1.0f;
        } else {
            f12 = f2;
        }
        if ((i2 & 4) == 0) {
            f19 = f3;
        }
        float f20 = 0.0f;
        if ((i2 & 8) != 0) {
            f13 = 0.0f;
        } else {
            f13 = f4;
        }
        if ((i2 & 16) != 0) {
            f14 = 0.0f;
        } else {
            f14 = f5;
        }
        if ((i2 & 32) != 0) {
            f15 = 0.0f;
        } else {
            f15 = f6;
        }
        if ((i2 & 64) != 0) {
            f16 = 0.0f;
        } else {
            f16 = f7;
        }
        if ((i2 & 128) != 0) {
            f17 = 0.0f;
        } else {
            f17 = f8;
        }
        if ((i2 & 256) == 0) {
            f20 = f9;
        }
        if ((i2 & 512) != 0) {
            f18 = 8.0f;
        } else {
            f18 = f10;
        }
        long r11 = (i2 & 1024) != 0 ? TransformOrigin.Companion.m3586getCenterSzJe1aQ() : j;
        if ((i2 & 2048) != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        if ((i2 & 4096) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        return m3313graphicsLayersKFY_QE(modifier, f11, f12, f19, f13, f14, f15, f16, f17, f20, f18, r11, shape2, z2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes an optional RenderEffect parameter and shadow color parameters", replaceWith = @ReplaceWith(expression = "Modifier.graphicsLayer(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, null, DefaultShadowColor, DefaultShadowColor)", imports = {"androidx.compose.ui.graphics"}))
    /* renamed from: graphicsLayer-sKFY_QE  reason: not valid java name */
    public static final /* synthetic */ Modifier m3313graphicsLayersKFY_QE(Modifier $this$graphicsLayer_u2dsKFY_QE, float scaleX, float scaleY, float alpha, float translationX, float translationY, float shadowElevation, float rotationX, float rotationY, float rotationZ, float cameraDistance, long transformOrigin, Shape shape, boolean clip) {
        Modifier modifier = $this$graphicsLayer_u2dsKFY_QE;
        Intrinsics.checkNotNullParameter(modifier, "$this$graphicsLayer");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m3310graphicsLayerAp8cVGQ$default(modifier, scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, (RenderEffect) null, 0, 0, 0, 114688, (Object) null);
    }

    /* renamed from: graphicsLayer-2Xn7asI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m3308graphicsLayer2Xn7asI$default(Modifier modifier, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, RenderEffect renderEffect, int i, Object obj) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        Shape shape2;
        boolean z2;
        RenderEffect renderEffect2;
        int i2 = i;
        float f19 = 1.0f;
        if ((i2 & 1) != 0) {
            f11 = 1.0f;
        } else {
            f11 = f;
        }
        if ((i2 & 2) != 0) {
            f12 = 1.0f;
        } else {
            f12 = f2;
        }
        if ((i2 & 4) == 0) {
            f19 = f3;
        }
        float f20 = 0.0f;
        if ((i2 & 8) != 0) {
            f13 = 0.0f;
        } else {
            f13 = f4;
        }
        if ((i2 & 16) != 0) {
            f14 = 0.0f;
        } else {
            f14 = f5;
        }
        if ((i2 & 32) != 0) {
            f15 = 0.0f;
        } else {
            f15 = f6;
        }
        if ((i2 & 64) != 0) {
            f16 = 0.0f;
        } else {
            f16 = f7;
        }
        if ((i2 & 128) != 0) {
            f17 = 0.0f;
        } else {
            f17 = f8;
        }
        if ((i2 & 256) == 0) {
            f20 = f9;
        }
        if ((i2 & 512) != 0) {
            f18 = 8.0f;
        } else {
            f18 = f10;
        }
        long r11 = (i2 & 1024) != 0 ? TransformOrigin.Companion.m3586getCenterSzJe1aQ() : j;
        if ((i2 & 2048) != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        if ((i2 & 4096) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if ((i2 & 8192) != 0) {
            renderEffect2 = null;
        } else {
            renderEffect2 = renderEffect;
        }
        return m3307graphicsLayer2Xn7asI(modifier, f11, f12, f19, f13, f14, f15, f16, f17, f20, f18, r11, shape2, z2, renderEffect2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes shadow color parameters", replaceWith = @ReplaceWith(expression = "Modifier.graphicsLayer(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, null, DefaultShadowColor, DefaultShadowColor)", imports = {"androidx.compose.ui.graphics"}))
    /* renamed from: graphicsLayer-2Xn7asI  reason: not valid java name */
    public static final /* synthetic */ Modifier m3307graphicsLayer2Xn7asI(Modifier $this$graphicsLayer_u2d2Xn7asI, float scaleX, float scaleY, float alpha, float translationX, float translationY, float shadowElevation, float rotationX, float rotationY, float rotationZ, float cameraDistance, long transformOrigin, Shape shape, boolean clip, RenderEffect renderEffect) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer_u2d2Xn7asI, "$this$graphicsLayer");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m3309graphicsLayerAp8cVGQ($this$graphicsLayer_u2d2Xn7asI, scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, renderEffect, GraphicsLayerScopeKt.getDefaultShadowColor(), GraphicsLayerScopeKt.getDefaultShadowColor(), CompositingStrategy.Companion.m3248getAutoNrFUSI());
    }

    /* renamed from: graphicsLayer-pANQ8Wg$default  reason: not valid java name */
    public static /* synthetic */ Modifier m3312graphicsLayerpANQ8Wg$default(Modifier modifier, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i, Object obj) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        Shape shape2;
        boolean z2;
        RenderEffect renderEffect2;
        long j4;
        long j5;
        int i2 = i;
        float f19 = 1.0f;
        if ((i2 & 1) != 0) {
            f11 = 1.0f;
        } else {
            f11 = f;
        }
        if ((i2 & 2) != 0) {
            f12 = 1.0f;
        } else {
            f12 = f2;
        }
        if ((i2 & 4) == 0) {
            f19 = f3;
        }
        float f20 = 0.0f;
        if ((i2 & 8) != 0) {
            f13 = 0.0f;
        } else {
            f13 = f4;
        }
        if ((i2 & 16) != 0) {
            f14 = 0.0f;
        } else {
            f14 = f5;
        }
        if ((i2 & 32) != 0) {
            f15 = 0.0f;
        } else {
            f15 = f6;
        }
        if ((i2 & 64) != 0) {
            f16 = 0.0f;
        } else {
            f16 = f7;
        }
        if ((i2 & 128) != 0) {
            f17 = 0.0f;
        } else {
            f17 = f8;
        }
        if ((i2 & 256) == 0) {
            f20 = f9;
        }
        if ((i2 & 512) != 0) {
            f18 = 8.0f;
        } else {
            f18 = f10;
        }
        long r11 = (i2 & 1024) != 0 ? TransformOrigin.Companion.m3586getCenterSzJe1aQ() : j;
        if ((i2 & 2048) != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        if ((i2 & 4096) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if ((i2 & 8192) != 0) {
            renderEffect2 = null;
        } else {
            renderEffect2 = renderEffect;
        }
        RenderEffect renderEffect3 = renderEffect2;
        if ((i2 & 16384) != 0) {
            j4 = GraphicsLayerScopeKt.getDefaultShadowColor();
        } else {
            j4 = j2;
        }
        if ((i2 & 32768) != 0) {
            j5 = GraphicsLayerScopeKt.getDefaultShadowColor();
        } else {
            j5 = j3;
        }
        return m3311graphicsLayerpANQ8Wg(modifier, f11, f12, f19, f13, f14, f15, f16, f17, f20, f18, r11, shape2, z2, renderEffect3, j4, j5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes a compositing strategy", replaceWith = @ReplaceWith(expression = "Modifier.graphicsLayer(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, null, DefaultShadowColor, DefaultShadowColor, CompositingStrategy.Auto)", imports = {"androidx.compose.ui.graphics"}))
    /* renamed from: graphicsLayer-pANQ8Wg  reason: not valid java name */
    public static final /* synthetic */ Modifier m3311graphicsLayerpANQ8Wg(Modifier $this$graphicsLayer_u2dpANQ8Wg, float scaleX, float scaleY, float alpha, float translationX, float translationY, float shadowElevation, float rotationX, float rotationY, float rotationZ, float cameraDistance, long transformOrigin, Shape shape, boolean clip, RenderEffect renderEffect, long ambientShadowColor, long spotShadowColor) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer_u2dpANQ8Wg, "$this$graphicsLayer");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m3309graphicsLayerAp8cVGQ($this$graphicsLayer_u2dpANQ8Wg, scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, renderEffect, ambientShadowColor, spotShadowColor, CompositingStrategy.Companion.m3248getAutoNrFUSI());
    }

    /* renamed from: graphicsLayer-Ap8cVGQ$default  reason: not valid java name */
    public static /* synthetic */ Modifier m3310graphicsLayerAp8cVGQ$default(Modifier modifier, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i, int i2, Object obj) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        Shape shape2;
        boolean z2;
        RenderEffect renderEffect2;
        long j4;
        long j5;
        int i3 = i2;
        float f19 = 1.0f;
        if ((i3 & 1) != 0) {
            f11 = 1.0f;
        } else {
            f11 = f;
        }
        if ((i3 & 2) != 0) {
            f12 = 1.0f;
        } else {
            f12 = f2;
        }
        if ((i3 & 4) == 0) {
            f19 = f3;
        }
        float f20 = 0.0f;
        if ((i3 & 8) != 0) {
            f13 = 0.0f;
        } else {
            f13 = f4;
        }
        if ((i3 & 16) != 0) {
            f14 = 0.0f;
        } else {
            f14 = f5;
        }
        if ((i3 & 32) != 0) {
            f15 = 0.0f;
        } else {
            f15 = f6;
        }
        if ((i3 & 64) != 0) {
            f16 = 0.0f;
        } else {
            f16 = f7;
        }
        if ((i3 & 128) != 0) {
            f17 = 0.0f;
        } else {
            f17 = f8;
        }
        if ((i3 & 256) == 0) {
            f20 = f9;
        }
        if ((i3 & 512) != 0) {
            f18 = 8.0f;
        } else {
            f18 = f10;
        }
        long r11 = (i3 & 1024) != 0 ? TransformOrigin.Companion.m3586getCenterSzJe1aQ() : j;
        if ((i3 & 2048) != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        if ((i3 & 4096) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if ((i3 & 8192) != 0) {
            renderEffect2 = null;
        } else {
            renderEffect2 = renderEffect;
        }
        RenderEffect renderEffect3 = renderEffect2;
        if ((i3 & 16384) != 0) {
            j4 = GraphicsLayerScopeKt.getDefaultShadowColor();
        } else {
            j4 = j2;
        }
        if ((i3 & 32768) != 0) {
            j5 = GraphicsLayerScopeKt.getDefaultShadowColor();
        } else {
            j5 = j3;
        }
        return m3309graphicsLayerAp8cVGQ(modifier, f11, f12, f19, f13, f14, f15, f16, f17, f20, f18, r11, shape2, z2, renderEffect3, j4, j5, (i3 & 65536) != 0 ? CompositingStrategy.Companion.m3248getAutoNrFUSI() : i);
    }

    /* renamed from: graphicsLayer-Ap8cVGQ  reason: not valid java name */
    public static final Modifier m3309graphicsLayerAp8cVGQ(Modifier $this$graphicsLayer_u2dAp8cVGQ, float scaleX, float scaleY, float alpha, float translationX, float translationY, float shadowElevation, float rotationX, float rotationY, float rotationZ, float cameraDistance, long transformOrigin, Shape shape, boolean clip, RenderEffect renderEffect, long ambientShadowColor, long spotShadowColor, int compositingStrategy) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer_u2dAp8cVGQ, "$this$graphicsLayer");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return $this$graphicsLayer_u2dAp8cVGQ.then(new GraphicsLayerModifierNodeElement(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, renderEffect, ambientShadowColor, spotShadowColor, compositingStrategy, (DefaultConstructorMarker) null));
    }

    public static final Modifier graphicsLayer(Modifier $this$graphicsLayer, Function1<? super GraphicsLayerScope, Unit> block) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return $this$graphicsLayer.then(new BlockGraphicsLayerElement(block));
    }

    public static final Modifier toolingGraphicsLayer(Modifier $this$toolingGraphicsLayer) {
        Modifier modifier = $this$toolingGraphicsLayer;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return InspectableValueKt.isDebugInspectorInfoEnabled() ? modifier.then(m3310graphicsLayerAp8cVGQ$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 0, 131071, (Object) null)) : modifier;
    }
}
