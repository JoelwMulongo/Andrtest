package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridDsl.kt */
final class LazyStaggeredGridDslKt$rememberRowHeightSums$1$1 extends Lambda implements Function2<Density, Constraints, int[]> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ StaggeredGridCells $rows;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridDslKt$rememberRowHeightSums$1$1(PaddingValues paddingValues, StaggeredGridCells staggeredGridCells, Arrangement.Vertical vertical) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$rows = staggeredGridCells;
        this.$verticalArrangement = vertical;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m1039invoke0kLqBqw((Density) p1, ((Constraints) p2).m5936unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final int[] m1039invoke0kLqBqw(Density $this$null, long constraints) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        if (Constraints.m5929getMaxHeightimpl(constraints) != Integer.MAX_VALUE) {
            List $this$invoke_0kLqBqw_u24lambda_u242_u24lambda_u241 = this.$rows.calculateCrossAxisCellSizes($this$null, Constraints.m5929getMaxHeightimpl(constraints) - $this$null.m5961roundToPx0680j_4(Dp.m5986constructorimpl(this.$contentPadding.m773calculateTopPaddingD9Ej5fM() + this.$contentPadding.m770calculateBottomPaddingD9Ej5fM())), $this$null.m5961roundToPx0680j_4(this.$verticalArrangement.m699getSpacingD9Ej5fM()));
            int size = $this$invoke_0kLqBqw_u24lambda_u242_u24lambda_u241.size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = $this$invoke_0kLqBqw_u24lambda_u242_u24lambda_u241.get(i).intValue();
            }
            int[] result = iArr;
            int size2 = $this$invoke_0kLqBqw_u24lambda_u242_u24lambda_u241.size();
            for (int i2 = 1; i2 < size2; i2++) {
                result[i2] = result[i2] + result[i2 - 1];
            }
            return result;
        }
        throw new IllegalArgumentException("LazyHorizontalStaggeredGrid's height should be bound by parent.".toString());
    }
}
