package androidx.compose.foundation.lazy;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B|\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u001e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003R\u000e\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u000e\u0010\u0014\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\u00020\u0016X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010#\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "", "index", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "beforeContentPadding", "afterContentPadding", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "spacing", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "(ILjava/util/List;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIILandroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;IJLjava/lang/Object;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "getKey", "()Ljava/lang/Object;", "size", "getSize", "sizeWithSpacings", "getSizeWithSpacings", "J", "position", "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "offset", "layoutWidth", "layoutHeight", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyMeasuredItem.kt */
public final class LazyMeasuredItem {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private final List<Placeable> placeables;
    private final LazyListItemPlacementAnimator placementAnimator;
    private final boolean reverseLayout;
    private final int size;
    private final int sizeWithSpacings;
    private final int spacing;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ LazyMeasuredItem(int i, List list, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection2, boolean z2, int i2, int i3, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, int i4, long j, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, z, horizontal, vertical, layoutDirection2, z2, i2, i3, lazyListItemPlacementAnimator, i4, j, obj);
    }

    private LazyMeasuredItem(int index2, List<? extends Placeable> placeables2, boolean isVertical2, Alignment.Horizontal horizontalAlignment2, Alignment.Vertical verticalAlignment2, LayoutDirection layoutDirection2, boolean reverseLayout2, int beforeContentPadding2, int afterContentPadding2, LazyListItemPlacementAnimator placementAnimator2, int spacing2, long visualOffset2, Object key2) {
        this.index = index2;
        this.placeables = placeables2;
        this.isVertical = isVertical2;
        this.horizontalAlignment = horizontalAlignment2;
        this.verticalAlignment = verticalAlignment2;
        this.layoutDirection = layoutDirection2;
        this.reverseLayout = reverseLayout2;
        this.beforeContentPadding = beforeContentPadding2;
        this.afterContentPadding = afterContentPadding2;
        this.placementAnimator = placementAnimator2;
        this.spacing = spacing2;
        this.visualOffset = visualOffset2;
        this.key = key2;
        int mainAxisSize = 0;
        List $this$fastForEach$iv = this.placeables;
        int size2 = $this$fastForEach$iv.size();
        int maxCrossAxis = 0;
        int index$iv = 0;
        while (index$iv < size2) {
            Placeable it = $this$fastForEach$iv.get(index$iv);
            List $this$fastForEach$iv2 = $this$fastForEach$iv;
            mainAxisSize += this.isVertical ? it.getHeight() : it.getWidth();
            maxCrossAxis = Math.max(maxCrossAxis, !this.isVertical ? it.getHeight() : it.getWidth());
            index$iv++;
            $this$fastForEach$iv = $this$fastForEach$iv2;
        }
        this.size = mainAxisSize;
        this.sizeWithSpacings = RangesKt.coerceAtLeast(this.spacing + mainAxisSize, 0);
        this.crossAxisSize = maxCrossAxis;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Object getKey() {
        return this.key;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final LazyListPositionedItem position(int offset, int layoutWidth, int layoutHeight) {
        long placeableOffset;
        List wrappers = new ArrayList();
        int mainAxisLayoutSize = this.isVertical ? layoutHeight : layoutWidth;
        List $this$fastForEach$iv = this.placeables;
        int size2 = $this$fastForEach$iv.size();
        int mainAxisOffset = offset;
        for (int index$iv = 0; index$iv < size2; index$iv++) {
            Placeable it = $this$fastForEach$iv.get(index$iv);
            if (this.isVertical) {
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal != null) {
                    placeableOffset = IntOffsetKt.IntOffset(horizontal.align(it.getWidth(), layoutWidth, this.layoutDirection), mainAxisOffset);
                    int i = layoutHeight;
                } else {
                    int i2 = layoutWidth;
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                int i3 = layoutWidth;
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical != null) {
                    placeableOffset = IntOffsetKt.IntOffset(mainAxisOffset, vertical.align(it.getHeight(), layoutHeight));
                } else {
                    int i4 = layoutHeight;
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            mainAxisOffset += this.isVertical ? it.getHeight() : it.getWidth();
            wrappers.add(new LazyListPlaceableWrapper(placeableOffset, it, (DefaultConstructorMarker) null));
        }
        int i5 = layoutWidth;
        int i6 = layoutHeight;
        int i7 = mainAxisOffset;
        return new LazyListPositionedItem(offset, this.index, this.key, this.size, -this.beforeContentPadding, mainAxisLayoutSize + this.afterContentPadding, this.isVertical, wrappers, this.placementAnimator, this.visualOffset, this.reverseLayout, mainAxisLayoutSize, (DefaultConstructorMarker) null);
    }
}
