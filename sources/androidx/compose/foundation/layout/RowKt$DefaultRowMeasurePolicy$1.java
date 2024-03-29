package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "", "totalSize", "", "size", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "outPosition", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Row.kt */
final class RowKt$DefaultRowMeasurePolicy$1 extends Lambda implements Function5<Integer, int[], LayoutDirection, Density, int[], Unit> {
    public static final RowKt$DefaultRowMeasurePolicy$1 INSTANCE = new RowKt$DefaultRowMeasurePolicy$1();

    RowKt$DefaultRowMeasurePolicy$1() {
        super(5);
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
        Arrangement.INSTANCE.getStart().arrange(density, totalSize, size, layoutDirection, outPosition);
    }
}
