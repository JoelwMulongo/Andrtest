package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/unit/Density;", "distance", "invoke", "(Landroidx/compose/ui/unit/Density;F)Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeableV2.kt */
final class SwipeableV2Kt$fractionalPositionalThreshold$1 extends Lambda implements Function2<Density, Float, Float> {
    final /* synthetic */ float $fraction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableV2Kt$fractionalPositionalThreshold$1(float f) {
        super(2);
        this.$fraction = f;
    }

    public final Float invoke(Density $this$null, float distance) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        return Float.valueOf(this.$fraction * distance);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return invoke((Density) p1, ((Number) p2).floatValue());
    }
}
