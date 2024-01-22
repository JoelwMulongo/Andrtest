package androidx.compose.material3;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Chip.kt */
final class ChipKt$InputChip$2$1$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ float $avatarOpacity;
    final /* synthetic */ Shape $avatarShape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipKt$InputChip$2$1$1(float f, Shape shape) {
        super(1);
        this.$avatarOpacity = f;
        this.$avatarShape = shape;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((GraphicsLayerScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha(this.$avatarOpacity);
        $this$graphicsLayer.setShape(this.$avatarShape);
        $this$graphicsLayer.setClip(true);
    }
}
