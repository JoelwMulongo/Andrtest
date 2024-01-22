package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Shadow.kt */
final class ShadowKt$shadow$2$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ long $ambientColor;
    final /* synthetic */ boolean $clip;
    final /* synthetic */ float $elevation;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ long $spotColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShadowKt$shadow$2$1(float f, Shape shape, boolean z, long j, long j2) {
        super(1);
        this.$elevation = f;
        this.$shape = shape;
        this.$clip = z;
        this.$ambientColor = j;
        this.$spotColor = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((GraphicsLayerScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setShadowElevation($this$graphicsLayer.m5967toPx0680j_4(this.$elevation));
        $this$graphicsLayer.setShape(this.$shape);
        $this$graphicsLayer.setClip(this.$clip);
        $this$graphicsLayer.m3349setAmbientShadowColor8_81llA(this.$ambientColor);
        $this$graphicsLayer.m3351setSpotShadowColor8_81llA(this.$spotColor);
    }
}
