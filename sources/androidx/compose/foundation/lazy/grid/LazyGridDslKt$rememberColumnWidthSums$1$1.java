package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridDsl.kt */
final class LazyGridDslKt$rememberColumnWidthSums$1$1 extends Lambda implements Function2<Density, Constraints, List<Integer>> {
    final /* synthetic */ GridCells $columns;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridDslKt$rememberColumnWidthSums$1$1(PaddingValues paddingValues, GridCells gridCells, Arrangement.Horizontal horizontal) {
        super(2);
        this.$contentPadding = paddingValues;
        this.$columns = gridCells;
        this.$horizontalArrangement = horizontal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m951invoke0kLqBqw((Density) p1, ((Constraints) p2).m5936unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final List<Integer> m951invoke0kLqBqw(Density $this$null, long constraints) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        if (Constraints.m5930getMaxWidthimpl(constraints) != Integer.MAX_VALUE) {
            List mutableList = CollectionsKt.toMutableList(this.$columns.calculateCrossAxisCellSizes($this$null, Constraints.m5930getMaxWidthimpl(constraints) - $this$null.m5961roundToPx0680j_4(Dp.m5986constructorimpl(PaddingKt.calculateStartPadding(this.$contentPadding, LayoutDirection.Ltr) + PaddingKt.calculateEndPadding(this.$contentPadding, LayoutDirection.Ltr))), $this$null.m5961roundToPx0680j_4(this.$horizontalArrangement.m685getSpacingD9Ej5fM())));
            List $this$invoke_0kLqBqw_u24lambda_u242_u24lambda_u241 = mutableList;
            int size = $this$invoke_0kLqBqw_u24lambda_u242_u24lambda_u241.size();
            for (int i = 1; i < size; i++) {
                $this$invoke_0kLqBqw_u24lambda_u242_u24lambda_u241.set(i, Integer.valueOf($this$invoke_0kLqBqw_u24lambda_u242_u24lambda_u241.get(i).intValue() + $this$invoke_0kLqBqw_u24lambda_u242_u24lambda_u241.get(i - 1).intValue()));
            }
            return mutableList;
        }
        throw new IllegalArgumentException("LazyVerticalGrid's width should be bound by parent.".toString());
    }
}
