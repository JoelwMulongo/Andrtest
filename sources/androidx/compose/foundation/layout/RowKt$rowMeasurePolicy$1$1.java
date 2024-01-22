package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Row.kt */
final class RowKt$rowMeasurePolicy$1$1 extends Lambda implements Function5<Integer, int[], LayoutDirection, Density, int[], Unit> {
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RowKt$rowMeasurePolicy$1$1(Arrangement.Horizontal horizontal) {
        super(5);
        this.$horizontalArrangement = horizontal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4, Object p5) {
        invoke(((Number) p1).intValue(), (int[]) p2, (LayoutDirection) p3, (Density) p4, (int[]) p5);
        return Unit.INSTANCE;
    }

    public final void invoke(int totalSize, int[] size, LayoutDirection layoutDirection, Density density, int[] outPosition) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
        this.$horizontalArrangement.arrange(density, totalSize, size, layoutDirection, outPosition);
    }
}
