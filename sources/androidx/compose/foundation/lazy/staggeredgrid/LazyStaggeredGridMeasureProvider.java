package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0018ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "", "isVertical", "", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "resolvedSlotSums", "", "crossAxisSpacing", "", "measuredItemFactory", "Landroidx/compose/foundation/lazy/staggeredgrid/MeasuredItemFactory;", "(ZLandroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;[IILandroidx/compose/foundation/lazy/staggeredgrid/MeasuredItemFactory;)V", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "slot", "span", "childConstraints-JhjzzOo", "(II)J", "getAndMeasure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "index", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "getAndMeasure-jy6DScQ", "(IJ)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasure.kt */
final class LazyStaggeredGridMeasureProvider {
    private final int crossAxisSpacing;
    private final boolean isVertical;
    private final LazyLayoutItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;
    private final MeasuredItemFactory measuredItemFactory;
    private final int[] resolvedSlotSums;

    public LazyStaggeredGridMeasureProvider(boolean isVertical2, LazyLayoutItemProvider itemProvider2, LazyLayoutMeasureScope measureScope2, int[] resolvedSlotSums2, int crossAxisSpacing2, MeasuredItemFactory measuredItemFactory2) {
        Intrinsics.checkNotNullParameter(itemProvider2, "itemProvider");
        Intrinsics.checkNotNullParameter(measureScope2, "measureScope");
        Intrinsics.checkNotNullParameter(resolvedSlotSums2, "resolvedSlotSums");
        Intrinsics.checkNotNullParameter(measuredItemFactory2, "measuredItemFactory");
        this.isVertical = isVertical2;
        this.itemProvider = itemProvider2;
        this.measureScope = measureScope2;
        this.resolvedSlotSums = resolvedSlotSums2;
        this.crossAxisSpacing = crossAxisSpacing2;
        this.measuredItemFactory = measuredItemFactory2;
    }

    /* renamed from: childConstraints-JhjzzOo  reason: not valid java name */
    private final long m1054childConstraintsJhjzzOo(int slot, int span) {
        int crossAxisSize = (this.resolvedSlotSums[(slot + span) - 1] - (slot == 0 ? 0 : this.resolvedSlotSums[slot - 1])) + (this.crossAxisSpacing * (span - 1));
        if (this.isVertical) {
            return Constraints.Companion.m5940fixedWidthOenEA2s(crossAxisSize);
        }
        return Constraints.Companion.m5939fixedHeightOenEA2s(crossAxisSize);
    }

    /* renamed from: getAndMeasure-jy6DScQ  reason: not valid java name */
    public final LazyStaggeredGridMeasuredItem m1055getAndMeasurejy6DScQ(int index, long span) {
        int i = index;
        long value$iv$iv$iv = span;
        return this.measuredItemFactory.createItem(index, (int) (span >> 32), ((int) (span & 4294967295L)) - ((int) (span >> 32)), this.itemProvider.getKey(i), this.measureScope.m1009measure0kLqBqw(i, m1054childConstraintsJhjzzOo((int) (span >> 32), ((int) (value$iv$iv$iv & 4294967295L)) - ((int) (value$iv$iv$iv >> 32)))));
    }
}
