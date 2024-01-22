package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Menu.kt */
final class MenuKt$DropdownMenuContent$1$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ State<Float> $alpha$delegate;
    final /* synthetic */ State<Float> $scale$delegate;
    final /* synthetic */ MutableState<TransformOrigin> $transformOriginState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MenuKt$DropdownMenuContent$1$1(MutableState<TransformOrigin> mutableState, State<Float> state, State<Float> state2) {
        super(1);
        this.$transformOriginState = mutableState;
        this.$scale$delegate = state;
        this.$alpha$delegate = state2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((GraphicsLayerScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setScaleX(MenuKt.DropdownMenuContent$lambda$1(this.$scale$delegate));
        $this$graphicsLayer.setScaleY(MenuKt.DropdownMenuContent$lambda$1(this.$scale$delegate));
        $this$graphicsLayer.setAlpha(MenuKt.DropdownMenuContent$lambda$3(this.$alpha$delegate));
        $this$graphicsLayer.m3352setTransformOrigin__ExYCQ(this.$transformOriginState.getValue().m3585unboximpl());
    }
}
