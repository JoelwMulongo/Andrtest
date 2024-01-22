package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"blur", "Landroidx/compose/ui/Modifier;", "radius", "Landroidx/compose/ui/unit/Dp;", "edgeTreatment", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "blur-F8QBwvs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "radiusX", "radiusY", "blur-1fqS-gw", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Blur.kt */
public final class BlurKt {
    /* renamed from: blur-1fqS-gw$default  reason: not valid java name */
    public static /* synthetic */ Modifier m2811blur1fqSgw$default(Modifier modifier, float f, float f2, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m2814boximpl(BlurredEdgeTreatment.Companion.m2821getRectangleGoahg());
        }
        return m2810blur1fqSgw(modifier, f, f2, blurredEdgeTreatment.m2820unboximpl());
    }

    /* renamed from: blur-1fqS-gw  reason: not valid java name */
    public static final Modifier m2810blur1fqSgw(Modifier $this$blur_u2d1fqS_u2dgw, float radiusX, float radiusY, Shape edgeTreatment) {
        int tileMode;
        boolean clip;
        Intrinsics.checkNotNullParameter($this$blur_u2d1fqS_u2dgw, "$this$blur");
        if (edgeTreatment != null) {
            clip = true;
            tileMode = TileMode.Companion.m3568getClamp3opZhB0();
        } else {
            clip = false;
            tileMode = TileMode.Companion.m3569getDecal3opZhB0();
        }
        return ((Dp.m5985compareTo0680j_4(radiusX, Dp.m5986constructorimpl((float) 0)) <= 0 || Dp.m5985compareTo0680j_4(radiusY, Dp.m5986constructorimpl((float) 0)) <= 0) && !clip) ? $this$blur_u2d1fqS_u2dgw : GraphicsLayerModifierKt.graphicsLayer($this$blur_u2d1fqS_u2dgw, new BlurKt$blur$1(radiusX, radiusY, tileMode, edgeTreatment, clip));
    }

    /* renamed from: blur-F8QBwvs$default  reason: not valid java name */
    public static /* synthetic */ Modifier m2813blurF8QBwvs$default(Modifier modifier, float f, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m2814boximpl(BlurredEdgeTreatment.Companion.m2821getRectangleGoahg());
        }
        return m2812blurF8QBwvs(modifier, f, blurredEdgeTreatment.m2820unboximpl());
    }

    /* renamed from: blur-F8QBwvs  reason: not valid java name */
    public static final Modifier m2812blurF8QBwvs(Modifier $this$blur_u2dF8QBwvs, float radius, Shape edgeTreatment) {
        Intrinsics.checkNotNullParameter($this$blur_u2dF8QBwvs, "$this$blur");
        return m2810blur1fqSgw($this$blur_u2dF8QBwvs, radius, radius, edgeTreatment);
    }
}
