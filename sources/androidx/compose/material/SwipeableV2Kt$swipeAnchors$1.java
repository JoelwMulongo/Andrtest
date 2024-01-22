package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "Landroidx/compose/ui/unit/Density;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeableV2.kt */
final class SwipeableV2Kt$swipeAnchors$1 extends Lambda implements Function1<Density, Unit> {
    final /* synthetic */ SwipeableV2State<T> $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableV2Kt$swipeAnchors$1(SwipeableV2State<T> swipeableV2State) {
        super(1);
        this.$state = swipeableV2State;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Density) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Density it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.$state.setDensity$material_release(it);
    }
}
