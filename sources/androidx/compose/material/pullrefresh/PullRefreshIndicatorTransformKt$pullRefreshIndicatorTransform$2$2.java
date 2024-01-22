package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullRefreshIndicatorTransform.kt */
final class PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2$2 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ boolean $scale;
    final /* synthetic */ PullRefreshState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2$2(PullRefreshState pullRefreshState, boolean z) {
        super(1);
        this.$state = pullRefreshState;
        this.$scale = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((GraphicsLayerScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setTranslationY(this.$state.getPosition$material_release() - Size.m2981getHeightimpl($this$graphicsLayer.m3346getSizeNHjbRc()));
        if (this.$scale && !this.$state.getRefreshing$material_release()) {
            float scaleFraction = RangesKt.coerceIn(EasingKt.getLinearOutSlowInEasing().transform(this.$state.getPosition$material_release() / this.$state.getThreshold$material_release()), 0.0f, 1.0f);
            $this$graphicsLayer.setScaleX(scaleFraction);
            $this$graphicsLayer.setScaleY(scaleFraction);
        }
    }
}
