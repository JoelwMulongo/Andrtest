package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001Bn\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0016J6\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bR\u000e\u0010\u000e\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0019\u0010\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\u00020\u0015X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010$\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "", "index", "Landroidx/compose/foundation/lazy/grid/ItemIndex;", "key", "isVertical", "", "crossAxisSize", "", "mainAxisSpacing", "reverseLayout", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "beforeContentPadding", "afterContentPadding", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "(ILjava/lang/Object;ZIIZLandroidx/compose/ui/unit/LayoutDirection;IILjava/util/List;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCrossAxisSize", "()I", "getIndex-VZbfaAc", "I", "getKey", "()Ljava/lang/Object;", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "getMainAxisSpacing", "getPlaceables", "()Ljava/util/List;", "J", "position", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "row", "column", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridMeasuredItem.kt */
public final class LazyGridMeasuredItem {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private final int mainAxisSpacing;
    private final List<Placeable> placeables;
    private final LazyGridItemPlacementAnimator placementAnimator;
    private final boolean reverseLayout;
    private final long visualOffset;

    public /* synthetic */ LazyGridMeasuredItem(int i, Object obj, boolean z, int i2, int i3, boolean z2, LayoutDirection layoutDirection2, int i4, int i5, List list, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, obj, z, i2, i3, z2, layoutDirection2, i4, i5, list, lazyGridItemPlacementAnimator, j);
    }

    private LazyGridMeasuredItem(int index2, Object key2, boolean isVertical2, int crossAxisSize2, int mainAxisSpacing2, boolean reverseLayout2, LayoutDirection layoutDirection2, int beforeContentPadding2, int afterContentPadding2, List<? extends Placeable> placeables2, LazyGridItemPlacementAnimator placementAnimator2, long visualOffset2) {
        this.index = index2;
        this.key = key2;
        this.isVertical = isVertical2;
        this.crossAxisSize = crossAxisSize2;
        this.mainAxisSpacing = mainAxisSpacing2;
        this.reverseLayout = reverseLayout2;
        this.layoutDirection = layoutDirection2;
        this.beforeContentPadding = beforeContentPadding2;
        this.afterContentPadding = afterContentPadding2;
        this.placeables = placeables2;
        this.placementAnimator = placementAnimator2;
        this.visualOffset = visualOffset2;
        int maxMainAxis = 0;
        List $this$fastForEach$iv = this.placeables;
        int size = $this$fastForEach$iv.size();
        int index$iv = 0;
        while (index$iv < size) {
            Placeable it = $this$fastForEach$iv.get(index$iv);
            int i = size;
            maxMainAxis = Math.max(maxMainAxis, this.isVertical ? it.getHeight() : it.getWidth());
            index$iv++;
            size = i;
        }
        this.mainAxisSize = maxMainAxis;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(this.mainAxisSpacing + maxMainAxis, 0);
    }

    /* renamed from: getIndex-VZbfaAc  reason: not valid java name */
    public final int m968getIndexVZbfaAc() {
        return this.index;
    }

    public final Object getKey() {
        return this.key;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final int getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    public final List<Placeable> getPlaceables() {
        return this.placeables;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final LazyGridPositionedItem position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight, int row, int column) {
        int crossAxisOffset2;
        long j;
        long j2;
        int i = mainAxisOffset;
        boolean z = this.isVertical;
        int mainAxisLayoutSize = z ? layoutHeight : layoutWidth;
        int crossAxisLayoutSize = z ? layoutWidth : layoutHeight;
        if (!z || this.layoutDirection != LayoutDirection.Rtl) {
            crossAxisOffset2 = crossAxisOffset;
        } else {
            crossAxisOffset2 = (crossAxisLayoutSize - crossAxisOffset) - this.crossAxisSize;
        }
        if (this.isVertical) {
            j = IntOffsetKt.IntOffset(crossAxisOffset2, i);
        } else {
            j = IntOffsetKt.IntOffset(i, crossAxisOffset2);
        }
        int i2 = this.index;
        Object obj = this.key;
        if (this.isVertical) {
            j2 = IntSizeKt.IntSize(this.crossAxisSize, this.mainAxisSize);
        } else {
            j2 = IntSizeKt.IntSize(this.mainAxisSize, this.crossAxisSize);
        }
        return new LazyGridPositionedItem(j, i2, obj, row, column, j2, -this.beforeContentPadding, mainAxisLayoutSize + this.afterContentPadding, this.isVertical, this.placeables, this.placementAnimator, this.visualOffset, mainAxisLayoutSize, this.reverseLayout, (DefaultConstructorMarker) null);
    }
}
