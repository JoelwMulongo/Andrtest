package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0001\u0001B7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\u0010\u000eJ\b\u00107\u001a\u00020\u000bH\u0016J\u0010\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020:H\u0014J\u0010\u0010;\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\nH\u0016J\b\u0010<\u001a\u00020\u000bH\u0016J\b\u0010=\u001a\u00020\u001bH\u0016J\b\u0010>\u001a\u00020\u000bH\u0016J\u001d\u0010?\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020AH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\u001d\u0010D\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020FH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010HJ\u0018\u0010I\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u001bH\u0016J%\u0010M\u001a\u00020F2\u0006\u0010N\u001a\u00020F2\u0006\u0010L\u001a\u00020\u001bH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001d\u0010Q\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020RH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bS\u0010TJ0\u0010U\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\u001b2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020X2\u0006\u0010Z\u001a\u00020X2\u0006\u0010[\u001a\u00020XH\u0014J\b\u0010\\\u001a\u00020\u000bH\u0002J\u001d\u0010]\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020_H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010TJ*\u0010a\u001a\u00020\u000b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016J\u001d\u0010b\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020AH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bc\u0010CJ\b\u0010d\u001a\u00020\u000bH\u0016J°\u0001\u0010e\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u00102\u0006\u0010g\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u00102\u0006\u0010i\u001a\u00020\u00102\u0006\u0010j\u001a\u00020\u00102\u0006\u0010k\u001a\u00020\u00102\u0006\u0010l\u001a\u00020\u00102\u0006\u0010m\u001a\u00020\u00102\u0006\u0010n\u001a\u00020\u00102\u0006\u0010o\u001a\u00020\u00102\u0006\u0010p\u001a\u00020)2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020\u001b2\b\u0010t\u001a\u0004\u0018\u00010u2\u0006\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020w2\u0006\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020~H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0005\b\u0010\u0001J\t\u0010\u0001\u001a\u00020\u000bH\u0002R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@FX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u001b@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010(\u001a\u00020)X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010*R\u0016\u0010+\u001a\u0004\u0018\u00010,8BX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000100X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b6\u0010&\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer;", "Landroid/view/View;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "container", "Landroidx/compose/ui/platform/DrawChildContainer;", "drawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "invalidateParentLayer", "Lkotlin/Function0;", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/ui/platform/DrawChildContainer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "value", "", "cameraDistancePx", "getCameraDistancePx", "()F", "setCameraDistancePx", "(F)V", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipBoundsCache", "Landroid/graphics/Rect;", "clipToBounds", "", "getContainer", "()Landroidx/compose/ui/platform/DrawChildContainer;", "drawnWithZ", "isInvalidated", "()Z", "setInvalidated", "(Z)V", "layerId", "", "getLayerId", "()J", "mHasOverlappingRendering", "mTransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "J", "manualClipPath", "Landroidx/compose/ui/graphics/Path;", "getManualClipPath", "()Landroidx/compose/ui/graphics/Path;", "matrixCache", "Landroidx/compose/ui/platform/LayerMatrixCache;", "outlineResolver", "Landroidx/compose/ui/platform/OutlineResolver;", "getOwnerView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "ownerViewId", "getOwnerViewId", "destroy", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawLayer", "forceLayout", "hasOverlappingRendering", "invalidate", "inverseTransform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "inverseTransform-58bKbWc", "([F)V", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "inverse", "mapOffset", "point", "mapOffset-8S9VItk", "(JZ)J", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "onLayout", "changed", "l", "", "t", "r", "b", "resetClipBounds", "resize", "size", "Landroidx/compose/ui/unit/IntSize;", "resize-ozmzZPI", "reuseLayer", "transform", "transform-58bKbWc", "updateDisplayList", "updateLayerProperties", "scaleX", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "updateLayerProperties-dDxr-wY", "(FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJILandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)V", "updateOutlineResolver", "Companion", "UniqueDrawingIdApi29", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewLayer.android.kt */
public final class ViewLayer extends View implements OwnedLayer, GraphicLayerInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ViewOutlineProvider OutlineProvider = new ViewLayer$Companion$OutlineProvider$1();
    private static final Function2<View, Matrix, Unit> getMatrix = ViewLayer$Companion$getMatrix$1.INSTANCE;
    /* access modifiers changed from: private */
    public static boolean hasRetrievedMethod;
    /* access modifiers changed from: private */
    public static Field recreateDisplayList;
    /* access modifiers changed from: private */
    public static boolean shouldUseDispatchDraw;
    /* access modifiers changed from: private */
    public static Method updateDisplayListIfDirtyMethod;
    private final CanvasHolder canvasHolder = new CanvasHolder();
    private Rect clipBoundsCache;
    private boolean clipToBounds;
    private final DrawChildContainer container;
    private Function1<? super Canvas, Unit> drawBlock;
    private boolean drawnWithZ;
    private Function0<Unit> invalidateParentLayer;
    private boolean isInvalidated;
    private final long layerId;
    private boolean mHasOverlappingRendering = true;
    private long mTransformOrigin = TransformOrigin.Companion.m3586getCenterSzJe1aQ();
    private final LayerMatrixCache<View> matrixCache = new LayerMatrixCache<>(getMatrix);
    /* access modifiers changed from: private */
    public final OutlineResolver outlineResolver;
    private final AndroidComposeView ownerView;

    public final AndroidComposeView getOwnerView() {
        return this.ownerView;
    }

    public final DrawChildContainer getContainer() {
        return this.container;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewLayer(AndroidComposeView ownerView2, DrawChildContainer container2, Function1<? super Canvas, Unit> drawBlock2, Function0<Unit> invalidateParentLayer2) {
        super(ownerView2.getContext());
        Intrinsics.checkNotNullParameter(ownerView2, "ownerView");
        Intrinsics.checkNotNullParameter(container2, "container");
        Intrinsics.checkNotNullParameter(drawBlock2, "drawBlock");
        Intrinsics.checkNotNullParameter(invalidateParentLayer2, "invalidateParentLayer");
        this.ownerView = ownerView2;
        this.container = container2;
        this.drawBlock = drawBlock2;
        this.invalidateParentLayer = invalidateParentLayer2;
        this.outlineResolver = new OutlineResolver(ownerView2.getDensity());
        setWillNotDraw(false);
        container2.addView(this);
        this.layerId = (long) View.generateViewId();
    }

    private final Path getManualClipPath() {
        if (!getClipToOutline() || this.outlineResolver.getOutlineClipSupported()) {
            return null;
        }
        return this.outlineResolver.getClipPath();
    }

    public final boolean isInvalidated() {
        return this.isInvalidated;
    }

    private final void setInvalidated(boolean value) {
        if (value != this.isInvalidated) {
            this.isInvalidated = value;
            this.ownerView.notifyLayerIsDirty$ui_release(this, value);
        }
    }

    public long getLayerId() {
        return this.layerId;
    }

    public long getOwnerViewId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return UniqueDrawingIdApi29.getUniqueDrawingId(this.ownerView);
        }
        return -1;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer$UniqueDrawingIdApi29;", "", "()V", "getUniqueDrawingId", "", "view", "Landroid/view/View;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ViewLayer.android.kt */
    private static final class UniqueDrawingIdApi29 {
        public static final UniqueDrawingIdApi29 INSTANCE = new UniqueDrawingIdApi29();

        private UniqueDrawingIdApi29() {
        }

        @JvmStatic
        public static final long getUniqueDrawingId(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return view.getUniqueDrawingId();
        }
    }

    public final float getCameraDistancePx() {
        return getCameraDistance() / ((float) getResources().getDisplayMetrics().densityDpi);
    }

    public final void setCameraDistancePx(float value) {
        setCameraDistance(((float) getResources().getDisplayMetrics().densityDpi) * value);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0130  */
    /* renamed from: updateLayerProperties-dDxr-wY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m5290updateLayerPropertiesdDxrwY(float r22, float r23, float r24, float r25, float r26, float r27, float r28, float r29, float r30, float r31, long r32, androidx.compose.ui.graphics.Shape r34, boolean r35, androidx.compose.ui.graphics.RenderEffect r36, long r37, long r39, int r41, androidx.compose.ui.unit.LayoutDirection r42, androidx.compose.ui.unit.Density r43) {
        /*
            r21 = this;
            r0 = r21
            r8 = r34
            r9 = r41
            java.lang.String r1 = "shape"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.lang.String r1 = "layoutDirection"
            r10 = r42
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            java.lang.String r1 = "density"
            r11 = r43
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            r12 = r32
            r0.mTransformOrigin = r12
            r21.setScaleX(r22)
            r14 = r23
            r0.setScaleY(r14)
            r15 = r24
            r0.setAlpha(r15)
            r7 = r25
            r0.setTranslationX(r7)
            r6 = r26
            r0.setTranslationY(r6)
            r5 = r27
            r0.setElevation(r5)
            r4 = r30
            r0.setRotation(r4)
            r3 = r28
            r0.setRotationX(r3)
            r2 = r29
            r0.setRotationY(r2)
            long r1 = r0.mTransformOrigin
            float r1 = androidx.compose.ui.graphics.TransformOrigin.m3581getPivotFractionXimpl(r1)
            int r2 = r21.getWidth()
            float r2 = (float) r2
            float r1 = r1 * r2
            r0.setPivotX(r1)
            long r1 = r0.mTransformOrigin
            float r1 = androidx.compose.ui.graphics.TransformOrigin.m3582getPivotFractionYimpl(r1)
            int r2 = r21.getHeight()
            float r2 = (float) r2
            float r1 = r1 * r2
            r0.setPivotY(r1)
            r2 = r31
            r0.setCameraDistancePx(r2)
            r16 = 1
            if (r35 == 0) goto L_0x007a
            androidx.compose.ui.graphics.Shape r1 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            if (r8 != r1) goto L_0x007a
            r1 = r16
            goto L_0x007b
        L_0x007a:
            r1 = 0
        L_0x007b:
            r0.clipToBounds = r1
            r21.resetClipBounds()
            androidx.compose.ui.graphics.Path r1 = r21.getManualClipPath()
            if (r1 == 0) goto L_0x0089
            r1 = r16
            goto L_0x008a
        L_0x0089:
            r1 = 0
        L_0x008a:
            if (r35 == 0) goto L_0x0097
            r17 = r1
            androidx.compose.ui.graphics.Shape r1 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            if (r8 == r1) goto L_0x0099
            r1 = r16
            goto L_0x009a
        L_0x0097:
            r17 = r1
        L_0x0099:
            r1 = 0
        L_0x009a:
            r0.setClipToOutline(r1)
            androidx.compose.ui.platform.OutlineResolver r1 = r0.outlineResolver
            float r18 = r21.getAlpha()
            boolean r19 = r21.getClipToOutline()
            float r20 = r21.getElevation()
            r8 = r17
            r2 = r34
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r42
            r7 = r43
            boolean r1 = r1.update(r2, r3, r4, r5, r6, r7)
            r21.updateOutlineResolver()
            androidx.compose.ui.graphics.Path r2 = r21.getManualClipPath()
            if (r2 == 0) goto L_0x00cc
            r2 = r16
            goto L_0x00cd
        L_0x00cc:
            r2 = 0
        L_0x00cd:
            if (r8 != r2) goto L_0x00d3
            if (r2 == 0) goto L_0x00d6
            if (r1 == 0) goto L_0x00d6
        L_0x00d3:
            r21.invalidate()
        L_0x00d6:
            boolean r3 = r0.drawnWithZ
            if (r3 != 0) goto L_0x00ea
            float r3 = r21.getElevation()
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x00ea
            kotlin.jvm.functions.Function0<kotlin.Unit> r3 = r0.invalidateParentLayer
            if (r3 == 0) goto L_0x00ea
            r3.invoke()
        L_0x00ea:
            androidx.compose.ui.platform.LayerMatrixCache<android.view.View> r3 = r0.matrixCache
            r3.invalidate()
            androidx.compose.ui.platform.ViewLayerVerificationHelper28 r3 = androidx.compose.ui.platform.ViewLayerVerificationHelper28.INSTANCE
            r4 = r0
            android.view.View r4 = (android.view.View) r4
            int r5 = androidx.compose.ui.graphics.ColorKt.m3218toArgb8_81llA(r37)
            r3.setOutlineAmbientShadowColor(r4, r5)
            androidx.compose.ui.platform.ViewLayerVerificationHelper28 r3 = androidx.compose.ui.platform.ViewLayerVerificationHelper28.INSTANCE
            r4 = r0
            android.view.View r4 = (android.view.View) r4
            int r5 = androidx.compose.ui.graphics.ColorKt.m3218toArgb8_81llA(r39)
            r3.setOutlineSpotShadowColor(r4, r5)
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 31
            if (r3 < r4) goto L_0x0119
            androidx.compose.ui.platform.ViewLayerVerificationHelper31 r3 = androidx.compose.ui.platform.ViewLayerVerificationHelper31.INSTANCE
            r4 = r0
            android.view.View r4 = (android.view.View) r4
            r5 = r36
            r3.setRenderEffect(r4, r5)
            goto L_0x011b
        L_0x0119:
            r5 = r36
        L_0x011b:
            androidx.compose.ui.graphics.CompositingStrategy$Companion r3 = androidx.compose.ui.graphics.CompositingStrategy.Companion
            int r3 = r3.m3250getOffscreenNrFUSI()
            boolean r3 = androidx.compose.ui.graphics.CompositingStrategy.m3244equalsimpl0(r9, r3)
            r4 = 0
            if (r3 == 0) goto L_0x0130
            r3 = 2
            r0.setLayerType(r3, r4)
            r3 = r16
            goto L_0x0147
        L_0x0130:
            androidx.compose.ui.graphics.CompositingStrategy$Companion r3 = androidx.compose.ui.graphics.CompositingStrategy.Companion
            int r3 = r3.m3249getModulateAlphaNrFUSI()
            boolean r3 = androidx.compose.ui.graphics.CompositingStrategy.m3244equalsimpl0(r9, r3)
            if (r3 == 0) goto L_0x0141
            r3 = 0
            r0.setLayerType(r3, r4)
            goto L_0x0147
        L_0x0141:
            r3 = 0
            r0.setLayerType(r3, r4)
            r3 = r16
        L_0x0147:
            r0.mHasOverlappingRendering = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.ViewLayer.m5290updateLayerPropertiesdDxrwY(float, float, float, float, float, float, float, float, float, float, long, androidx.compose.ui.graphics.Shape, boolean, androidx.compose.ui.graphics.RenderEffect, long, long, int, androidx.compose.ui.unit.LayoutDirection, androidx.compose.ui.unit.Density):void");
    }

    public boolean hasOverlappingRendering() {
        return this.mHasOverlappingRendering;
    }

    /* renamed from: isInLayer-k-4lQ0M  reason: not valid java name */
    public boolean m5285isInLayerk4lQ0M(long position) {
        float x = Offset.m2915getXimpl(position);
        float y = Offset.m2916getYimpl(position);
        if (this.clipToBounds) {
            if (0.0f > x || x >= ((float) getWidth()) || 0.0f > y || y >= ((float) getHeight())) {
                return false;
            }
            return true;
        } else if (getClipToOutline()) {
            return this.outlineResolver.m5267isInOutlinek4lQ0M(position);
        } else {
            return true;
        }
    }

    private final void updateOutlineResolver() {
        ViewOutlineProvider viewOutlineProvider;
        if (this.outlineResolver.getOutline() != null) {
            viewOutlineProvider = OutlineProvider;
        } else {
            viewOutlineProvider = null;
        }
        setOutlineProvider(viewOutlineProvider);
    }

    private final void resetClipBounds() {
        Rect rect;
        if (this.clipToBounds) {
            Rect rect2 = this.clipBoundsCache;
            if (rect2 == null) {
                this.clipBoundsCache = new Rect(0, 0, getWidth(), getHeight());
            } else {
                Intrinsics.checkNotNull(rect2);
                rect2.set(0, 0, getWidth(), getHeight());
            }
            rect = this.clipBoundsCache;
        } else {
            rect = null;
        }
        setClipBounds(rect);
    }

    /* renamed from: resize-ozmzZPI  reason: not valid java name */
    public void m5288resizeozmzZPI(long size) {
        int width = IntSize.m6146getWidthimpl(size);
        int height = IntSize.m6145getHeightimpl(size);
        if (width != getWidth() || height != getHeight()) {
            setPivotX(TransformOrigin.m3581getPivotFractionXimpl(this.mTransformOrigin) * ((float) width));
            setPivotY(TransformOrigin.m3582getPivotFractionYimpl(this.mTransformOrigin) * ((float) height));
            this.outlineResolver.m5268updateuvyYCjk(SizeKt.Size((float) width, (float) height));
            updateOutlineResolver();
            layout(getLeft(), getTop(), getLeft() + width, getTop() + height);
            resetClipBounds();
            this.matrixCache.invalidate();
        }
    }

    /* renamed from: move--gyyYBs  reason: not valid java name */
    public void m5287movegyyYBs(long position) {
        int left = IntOffset.m6104getXimpl(position);
        if (left != getLeft()) {
            offsetLeftAndRight(left - getLeft());
            this.matrixCache.invalidate();
        }
        int top = IntOffset.m6105getYimpl(position);
        if (top != getTop()) {
            offsetTopAndBottom(top - getTop());
            this.matrixCache.invalidate();
        }
    }

    public void drawLayer(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        boolean z = getElevation() > 0.0f;
        this.drawnWithZ = z;
        if (z) {
            canvas.enableZ();
        }
        this.container.drawChild$ui_release(canvas, this, getDrawingTime());
        if (this.drawnWithZ) {
            canvas.disableZ();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(android.graphics.Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        setInvalidated(false);
        CanvasHolder this_$iv = this.canvasHolder;
        android.graphics.Canvas previousCanvas$iv = this_$iv.getAndroidCanvas().getInternalCanvas();
        this_$iv.getAndroidCanvas().setInternalCanvas(canvas);
        Canvas $this$dispatchDraw_u24lambda_u240 = this_$iv.getAndroidCanvas();
        boolean didClip = false;
        if (getManualClipPath() != null || !canvas.isHardwareAccelerated()) {
            didClip = true;
            $this$dispatchDraw_u24lambda_u240.save();
            this.outlineResolver.clipToOutline($this$dispatchDraw_u24lambda_u240);
        }
        Function1<? super Canvas, Unit> function1 = this.drawBlock;
        if (function1 != null) {
            function1.invoke($this$dispatchDraw_u24lambda_u240);
        }
        if (didClip) {
            $this$dispatchDraw_u24lambda_u240.restore();
        }
        this_$iv.getAndroidCanvas().setInternalCanvas(previousCanvas$iv);
    }

    public void invalidate() {
        if (!this.isInvalidated) {
            setInvalidated(true);
            super.invalidate();
            this.ownerView.invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    public void destroy() {
        setInvalidated(false);
        this.ownerView.requestClearInvalidObservations();
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        boolean recycle$ui_release = this.ownerView.recycle$ui_release(this);
        this.container.removeViewInLayout(this);
    }

    public void updateDisplayList() {
        if (this.isInvalidated && !shouldUseDispatchDraw) {
            setInvalidated(false);
            Companion.updateDisplayList(this);
        }
    }

    public void forceLayout() {
    }

    /* renamed from: mapOffset-8S9VItk  reason: not valid java name */
    public long m5286mapOffset8S9VItk(long point, boolean inverse) {
        if (!inverse) {
            return androidx.compose.ui.graphics.Matrix.m3397mapMKHz9U(this.matrixCache.m5241calculateMatrixGrdbGEg(this), point);
        }
        float[] r0 = this.matrixCache.m5240calculateInverseMatrixbWbORWo(this);
        return r0 != null ? androidx.compose.ui.graphics.Matrix.m3397mapMKHz9U(r0, point) : Offset.Companion.m2929getInfiniteF1C5BW0();
    }

    public void mapBounds(MutableRect rect, boolean inverse) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (inverse) {
            float[] matrix = this.matrixCache.m5240calculateInverseMatrixbWbORWo(this);
            if (matrix != null) {
                androidx.compose.ui.graphics.Matrix.m3399mapimpl(matrix, rect);
            } else {
                rect.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        } else {
            androidx.compose.ui.graphics.Matrix.m3399mapimpl(this.matrixCache.m5241calculateMatrixGrdbGEg(this), rect);
        }
    }

    public void reuseLayer(Function1<? super Canvas, Unit> drawBlock2, Function0<Unit> invalidateParentLayer2) {
        Intrinsics.checkNotNullParameter(drawBlock2, "drawBlock");
        Intrinsics.checkNotNullParameter(invalidateParentLayer2, "invalidateParentLayer");
        this.container.addView(this);
        this.clipToBounds = false;
        this.drawnWithZ = false;
        this.mTransformOrigin = TransformOrigin.Companion.m3586getCenterSzJe1aQ();
        this.drawBlock = drawBlock2;
        this.invalidateParentLayer = invalidateParentLayer2;
    }

    /* renamed from: transform-58bKbWc  reason: not valid java name */
    public void m5289transform58bKbWc(float[] matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        androidx.compose.ui.graphics.Matrix.m3408timesAssign58bKbWc(matrix, this.matrixCache.m5241calculateMatrixGrdbGEg(this));
    }

    /* renamed from: inverseTransform-58bKbWc  reason: not valid java name */
    public void m5284inverseTransform58bKbWc(float[] matrix) {
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        float[] inverse = this.matrixCache.m5240calculateInverseMatrixbWbORWo(this);
        if (inverse != null) {
            androidx.compose.ui.graphics.Matrix.m3408timesAssign58bKbWc(matrix, inverse);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\tH\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/platform/ViewLayer$Companion;", "", "()V", "OutlineProvider", "Landroid/view/ViewOutlineProvider;", "getOutlineProvider", "()Landroid/view/ViewOutlineProvider;", "getMatrix", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/graphics/Matrix;", "", "<set-?>", "", "hasRetrievedMethod", "getHasRetrievedMethod", "()Z", "recreateDisplayList", "Ljava/lang/reflect/Field;", "shouldUseDispatchDraw", "getShouldUseDispatchDraw", "setShouldUseDispatchDraw$ui_release", "(Z)V", "updateDisplayListIfDirtyMethod", "Ljava/lang/reflect/Method;", "updateDisplayList", "view", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ViewLayer.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewOutlineProvider getOutlineProvider() {
            return ViewLayer.OutlineProvider;
        }

        public final boolean getHasRetrievedMethod() {
            return ViewLayer.hasRetrievedMethod;
        }

        public final boolean getShouldUseDispatchDraw() {
            return ViewLayer.shouldUseDispatchDraw;
        }

        public final void setShouldUseDispatchDraw$ui_release(boolean z) {
            ViewLayer.shouldUseDispatchDraw = z;
        }

        public final void updateDisplayList(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            try {
                if (!getHasRetrievedMethod()) {
                    ViewLayer.hasRetrievedMethod = true;
                    Object[] objArr = {"updateDisplayListIfDirty", new Class[0]};
                    ViewLayer.updateDisplayListIfDirtyMethod = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, new Class[0].getClass()}).invoke(View.class, objArr);
                    Object[] objArr2 = {"mRecreateDisplayList"};
                    ViewLayer.recreateDisplayList = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(View.class, objArr2);
                    Method getDeclaredMethod = ViewLayer.updateDisplayListIfDirtyMethod;
                    if (getDeclaredMethod != null) {
                        getDeclaredMethod.setAccessible(true);
                    }
                    Field access$getRecreateDisplayList$cp = ViewLayer.recreateDisplayList;
                    if (access$getRecreateDisplayList$cp != null) {
                        access$getRecreateDisplayList$cp.setAccessible(true);
                    }
                }
                Field access$getRecreateDisplayList$cp2 = ViewLayer.recreateDisplayList;
                if (access$getRecreateDisplayList$cp2 != null) {
                    access$getRecreateDisplayList$cp2.setBoolean(view, true);
                }
                Method access$getUpdateDisplayListIfDirtyMethod$cp = ViewLayer.updateDisplayListIfDirtyMethod;
                if (access$getUpdateDisplayListIfDirtyMethod$cp != null) {
                    access$getUpdateDisplayListIfDirtyMethod$cp.invoke(view, new Object[0]);
                }
            } catch (Throwable th) {
                setShouldUseDispatchDraw$ui_release(true);
            }
        }
    }
}
