package androidx.compose.animation;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Crossfade.kt */
final class CrossfadeKt$Crossfade$5$1$1$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ State<Float> $alpha$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CrossfadeKt$Crossfade$5$1$1$1(State<Float> state) {
        super(1);
        this.$alpha$delegate = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((GraphicsLayerScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha(CrossfadeKt$Crossfade$5$1.invoke$lambda$1(this.$alpha$delegate));
    }
}
