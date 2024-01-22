package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b$\u0010%R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006&"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyMeasuredLineProvider;", "", "isVertical", "", "slotSizesSums", "", "", "crossAxisSpacing", "gridItemsCount", "spaceBetweenLines", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "measuredLineFactory", "Landroidx/compose/foundation/lazy/grid/MeasuredLineFactory;", "(ZLjava/util/List;IIILandroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;Landroidx/compose/foundation/lazy/grid/MeasuredLineFactory;)V", "keyToIndexMap", "", "getKeyToIndexMap", "()Ljava/util/Map;", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "startSlot", "span", "childConstraints-JhjzzOo$foundation_release", "(II)J", "getAndMeasure", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "lineIndex", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "getAndMeasure-bKFJvoY", "(I)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "itemConstraints", "itemIndex", "Landroidx/compose/foundation/lazy/grid/ItemIndex;", "itemConstraints-HZ0wssc", "(I)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyMeasuredLineProvider.kt */
public final class LazyMeasuredLineProvider {
    private final int crossAxisSpacing;
    private final int gridItemsCount;
    private final boolean isVertical;
    private final LazyMeasuredItemProvider measuredItemProvider;
    private final MeasuredLineFactory measuredLineFactory;
    private final List<Integer> slotSizesSums;
    private final int spaceBetweenLines;
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    public LazyMeasuredLineProvider(boolean isVertical2, List<Integer> slotSizesSums2, int crossAxisSpacing2, int gridItemsCount2, int spaceBetweenLines2, LazyMeasuredItemProvider measuredItemProvider2, LazyGridSpanLayoutProvider spanLayoutProvider2, MeasuredLineFactory measuredLineFactory2) {
        Intrinsics.checkNotNullParameter(slotSizesSums2, "slotSizesSums");
        Intrinsics.checkNotNullParameter(measuredItemProvider2, "measuredItemProvider");
        Intrinsics.checkNotNullParameter(spanLayoutProvider2, "spanLayoutProvider");
        Intrinsics.checkNotNullParameter(measuredLineFactory2, "measuredLineFactory");
        this.isVertical = isVertical2;
        this.slotSizesSums = slotSizesSums2;
        this.crossAxisSpacing = crossAxisSpacing2;
        this.gridItemsCount = gridItemsCount2;
        this.spaceBetweenLines = spaceBetweenLines2;
        this.measuredItemProvider = measuredItemProvider2;
        this.spanLayoutProvider = spanLayoutProvider2;
        this.measuredLineFactory = measuredLineFactory2;
    }

    /* renamed from: childConstraints-JhjzzOo$foundation_release  reason: not valid java name */
    public final long m983childConstraintsJhjzzOo$foundation_release(int startSlot, int span) {
        int crossAxisSize = RangesKt.coerceAtLeast((this.crossAxisSpacing * (span - 1)) + (this.slotSizesSums.get((startSlot + span) - 1).intValue() - (startSlot == 0 ? 0 : this.slotSizesSums.get(startSlot - 1).intValue())), 0);
        if (this.isVertical) {
            return Constraints.Companion.m5940fixedWidthOenEA2s(crossAxisSize);
        }
        return Constraints.Companion.m5939fixedHeightOenEA2s(crossAxisSize);
    }

    /* renamed from: itemConstraints-HZ0wssc  reason: not valid java name */
    public final long m985itemConstraintsHZ0wssc(int itemIndex) {
        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider = this.spanLayoutProvider;
        return m983childConstraintsJhjzzOo$foundation_release(0, lazyGridSpanLayoutProvider.spanOf(itemIndex, lazyGridSpanLayoutProvider.getSlotsPerLine()));
    }

    /* renamed from: getAndMeasure-bKFJvoY  reason: not valid java name */
    public final LazyGridMeasuredLine m984getAndMeasurebKFJvoY(int lineIndex) {
        int mainAxisSpacing;
        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = this.spanLayoutProvider.getLineConfiguration(lineIndex);
        int lineItemsCount = lineConfiguration.getSpans().size();
        if (lineItemsCount == 0 || lineConfiguration.getFirstItemIndex() + lineItemsCount == this.gridItemsCount) {
            mainAxisSpacing = 0;
        } else {
            mainAxisSpacing = this.spaceBetweenLines;
        }
        int startSlot = 0;
        LazyGridMeasuredItem[] items = new LazyGridMeasuredItem[lineItemsCount];
        for (int i = 0; i < lineItemsCount; i++) {
            int span = GridItemSpan.m928getCurrentLineSpanimpl(lineConfiguration.getSpans().get(i).m931unboximpl());
            LazyGridMeasuredItem r9 = this.measuredItemProvider.m982getAndMeasureednRnyU(ItemIndex.m934constructorimpl(lineConfiguration.getFirstItemIndex() + i), mainAxisSpacing, m983childConstraintsJhjzzOo$foundation_release(startSlot, span));
            LazyGridMeasuredItem lazyGridMeasuredItem = r9;
            startSlot += span;
            Unit unit = Unit.INSTANCE;
            items[i] = r9;
        }
        return this.measuredLineFactory.m1000createLineH9FfpSk(lineIndex, items, lineConfiguration.getSpans(), mainAxisSpacing);
    }

    public final Map<Object, Integer> getKeyToIndexMap() {
        return this.measuredItemProvider.getKeyToIndexMap();
    }
}
