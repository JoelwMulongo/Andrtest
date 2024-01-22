package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.RenderEffectKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Blur.kt */
final class BlurKt$blur$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ boolean $clip;
    final /* synthetic */ Shape $edgeTreatment;
    final /* synthetic */ float $radiusX;
    final /* synthetic */ float $radiusY;
    final /* synthetic */ int $tileMode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlurKt$blur$1(float f, float f2, int i, Shape shape, boolean z) {
        super(1);
        this.$radiusX = f;
        this.$radiusY = f2;
        this.$tileMode = i;
        this.$edgeTreatment = shape;
        this.$clip = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((GraphicsLayerScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope $this$graphicsLayer) {
        RenderEffect renderEffect;
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        float horizontalBlurPixels = $this$graphicsLayer.m5967toPx0680j_4(this.$radiusX);
        float verticalBlurPixels = $this$graphicsLayer.m5967toPx0680j_4(this.$radiusY);
        if (horizontalBlurPixels <= 0.0f || verticalBlurPixels <= 0.0f) {
            renderEffect = null;
        } else {
            renderEffect = RenderEffectKt.m3488BlurEffect3YTHUZs(horizontalBlurPixels, verticalBlurPixels, this.$tileMode);
        }
        $this$graphicsLayer.setRenderEffect(renderEffect);
        Shape shape = this.$edgeTreatment;
        if (shape == null) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        $this$graphicsLayer.setShape(shape);
        $this$graphicsLayer.setClip(this.$clip);
    }
}
