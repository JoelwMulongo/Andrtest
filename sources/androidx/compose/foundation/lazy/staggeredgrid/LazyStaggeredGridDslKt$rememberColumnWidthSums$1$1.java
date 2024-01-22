package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridDsl.kt */
final class LazyStaggeredGridDslKt$rememberColumnWidthSums$1$1 extends Lambda implements Function2<Density, Constraints, int[]> {
    final /* synthetic */ StaggeredGridCells $columns;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridDslKt$rememberColumnWidthSums$1$1(PaddingValues paddingValues, StaggeredGridCells staggeredGridCells, Arrangement.Horizontal horizontal) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$columns = staggeredGridCells;
        this.$horizontalArrangement = horizontal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m1038invoke0kLqBqw((Density) p1, ((Constraints) p2).m5936unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final int[] m1038invoke0kLqBqw(Density $this$null, long constraints) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        if (Constraints.m5930getMaxWidthimpl(constraints) != Integer.MAX_VALUE) {
            List $this$invoke_0kLqBqw_u24lambda_u242_u24lambda_u241 = this.$columns.calculateCrossAxisCellSizes($this$null, Constraints.m5930getMaxWidthimpl(constraints) - $this$null.m5961roundToPx0680j_4(Dp.m5986constructorimpl(PaddingKt.calculateStartPadding(this.$contentPadding, LayoutDirection.Ltr) + PaddingKt.calculateEndPadding(this.$contentPadding, LayoutDirection.Ltr))), $this$null.m5961roundToPx0680j_4(this.$horizontalArrangement.m685getSpacingD9Ej5fM()));
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
        throw new IllegalArgumentException("LazyVerticalStaggeredGrid's width should be bound by parent.".toString());
    }
}
