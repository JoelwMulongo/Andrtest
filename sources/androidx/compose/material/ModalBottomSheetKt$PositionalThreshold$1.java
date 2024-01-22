package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/unit/Density;", "it", "invoke", "(Landroidx/compose/ui/unit/Density;F)Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
final class ModalBottomSheetKt$PositionalThreshold$1 extends Lambda implements Function2<Density, Float, Float> {
    public static final ModalBottomSheetKt$PositionalThreshold$1 INSTANCE = new ModalBottomSheetKt$PositionalThreshold$1();

    ModalBottomSheetKt$PositionalThreshold$1() {
        super(2);
    }

    public final Float invoke(Density $this$null, float it) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        return Float.valueOf($this$null.m5967toPx0680j_4(Dp.m5986constructorimpl((float) 56)));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return invoke((Density) p1, ((Number) p2).floatValue());
    }
}
