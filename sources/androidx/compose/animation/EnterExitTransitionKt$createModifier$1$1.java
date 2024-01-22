package androidx.compose.animation;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class EnterExitTransitionKt$createModifier$1$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ State<Float> $alpha$delegate;
    final /* synthetic */ State<Float> $scale$delegate;
    final /* synthetic */ State<TransformOrigin> $transformOrigin$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnterExitTransitionKt$createModifier$1$1(State<Float> state, State<Float> state2, State<TransformOrigin> state3) {
        super(1);
        this.$alpha$delegate = state;
        this.$scale$delegate = state2;
        this.$transformOrigin$delegate = state3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((GraphicsLayerScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha(EnterExitTransitionKt.createModifier$lambda$8(this.$alpha$delegate));
        $this$graphicsLayer.setScaleX(EnterExitTransitionKt.createModifier$lambda$11(this.$scale$delegate));
        $this$graphicsLayer.setScaleY(EnterExitTransitionKt.createModifier$lambda$11(this.$scale$delegate));
        $this$graphicsLayer.m3352setTransformOrigin__ExYCQ(EnterExitTransitionKt.createModifier$lambda$13(this.$transformOrigin$delegate));
    }
}
