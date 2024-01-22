package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ&\u0010!\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0010¨\u0006&"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "", "index", "", "key", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "spacing", "lane", "span", "(ILjava/lang/Object;Ljava/util/List;ZIII)V", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "()Z", "isVisible", "setVisible", "(Z)V", "getKey", "()Ljava/lang/Object;", "getLane", "mainAxisSize", "getMainAxisSize", "getPlaceables", "()Ljava/util/List;", "sizeWithSpacings", "getSizeWithSpacings", "getSpacing", "getSpan", "position", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridPositionedItem;", "mainAxis", "crossAxis", "mainAxisLayoutSize", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasure.kt */
final class LazyStaggeredGridMeasuredItem {
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private boolean isVisible = true;
    private final Object key;
    private final int lane;
    private final int mainAxisSize;
    private final List<Placeable> placeables;
    private final int sizeWithSpacings;
    private final int spacing;
    private final int span;

    public LazyStaggeredGridMeasuredItem(int index2, Object key2, List<? extends Placeable> placeables2, boolean isVertical2, int spacing2, int lane2, int span2) {
        Comparable maxValue$iv;
        int i;
        Object obj = key2;
        List<? extends Placeable> list = placeables2;
        Intrinsics.checkNotNullParameter(obj, "key");
        Intrinsics.checkNotNullParameter(list, "placeables");
        this.index = index2;
        this.key = obj;
        this.placeables = list;
        this.isVertical = isVertical2;
        this.spacing = spacing2;
        this.lane = lane2;
        this.span = span2;
        Object accumulator$iv = 0;
        List $this$fastForEach$iv$iv = this.placeables;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            Placeable placeable = (Placeable) $this$fastForEach$iv$iv.get(index$iv$iv);
            accumulator$iv = Integer.valueOf(((Number) accumulator$iv).intValue() + (this.isVertical ? placeable.getHeight() : placeable.getWidth()));
            index$iv$iv++;
            Object obj2 = key2;
        }
        int intValue = ((Number) accumulator$iv).intValue();
        this.mainAxisSize = intValue;
        this.sizeWithSpacings = RangesKt.coerceAtLeast(intValue + this.spacing, 0);
        List $this$fastMaxOfOrNull$iv = this.placeables;
        if ($this$fastMaxOfOrNull$iv.isEmpty()) {
            maxValue$iv = null;
            i = 0;
        } else {
            i = 0;
            Placeable it = $this$fastMaxOfOrNull$iv.get(0);
            maxValue$iv = Integer.valueOf(this.isVertical ? it.getWidth() : it.getHeight());
            int i$iv = 1;
            int lastIndex = CollectionsKt.getLastIndex($this$fastMaxOfOrNull$iv);
            if (1 <= lastIndex) {
                while (true) {
                    Placeable it2 = $this$fastMaxOfOrNull$iv.get(i$iv);
                    Comparable v$iv = Integer.valueOf(this.isVertical ? it2.getWidth() : it2.getHeight());
                    maxValue$iv = v$iv.compareTo(maxValue$iv) > 0 ? v$iv : maxValue$iv;
                    if (i$iv == lastIndex) {
                        break;
                    }
                    i$iv++;
                }
            }
        }
        Integer num = (Integer) maxValue$iv;
        this.crossAxisSize = num != null ? num.intValue() : i;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Object getKey() {
        return this.key;
    }

    public final List<Placeable> getPlaceables() {
        return this.placeables;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final int getSpacing() {
        return this.spacing;
    }

    public final int getLane() {
        return this.lane;
    }

    public final int getSpan() {
        return this.span;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final void setVisible(boolean z) {
        this.isVisible = z;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final LazyStaggeredGridPositionedItem position(int lane2, int mainAxis, int crossAxis, int mainAxisLayoutSize) {
        long j;
        long j2;
        if (this.isVertical) {
            j = IntOffsetKt.IntOffset(crossAxis, mainAxis);
        } else {
            int i = mainAxis;
            int i2 = crossAxis;
            j = IntOffsetKt.IntOffset(mainAxis, crossAxis);
        }
        int i3 = this.index;
        Object obj = this.key;
        if (this.isVertical) {
            j2 = IntSizeKt.IntSize(this.crossAxisSize, this.sizeWithSpacings);
        } else {
            j2 = IntSizeKt.IntSize(this.sizeWithSpacings, this.crossAxisSize);
        }
        return new LazyStaggeredGridPositionedItem(j, i3, lane2, obj, j2, this.placeables, this.isVertical, mainAxisLayoutSize, (DefaultConstructorMarker) null);
    }
}
