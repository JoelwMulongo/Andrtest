package androidx.compose.foundation.lazy;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\u001aF\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0000¨\u0006\f"}, d2 = {"findOrComposeLazyListHeader", "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "composedVisibleItems", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "headerIndexes", "", "", "beforeContentPadding", "layoutWidth", "layoutHeight", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListHeaders.kt */
public final class LazyListHeadersKt {
    public static final LazyListPositionedItem findOrComposeLazyListHeader(List<LazyListPositionedItem> composedVisibleItems, LazyMeasuredItemProvider itemProvider, List<Integer> headerIndexes, int beforeContentPadding, int layoutWidth, int layoutHeight) {
        int headerOffset;
        int i;
        List<LazyListPositionedItem> list = composedVisibleItems;
        LazyMeasuredItemProvider lazyMeasuredItemProvider = itemProvider;
        List<Integer> list2 = headerIndexes;
        int i2 = beforeContentPadding;
        Intrinsics.checkNotNullParameter(list, "composedVisibleItems");
        Intrinsics.checkNotNullParameter(lazyMeasuredItemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(list2, "headerIndexes");
        int currentHeaderOffset = Integer.MIN_VALUE;
        int nextHeaderOffset = Integer.MIN_VALUE;
        int currentHeaderListPosition = -1;
        int nextHeaderListPosition = -1;
        int firstVisible = ((LazyListPositionedItem) CollectionsKt.first(composedVisibleItems)).getIndex();
        int index = 0;
        int size = headerIndexes.size();
        while (index < size && list2.get(index).intValue() <= firstVisible) {
            currentHeaderListPosition = list2.get(index).intValue();
            int i3 = index + 1;
            if (i3 < 0 || i3 > CollectionsKt.getLastIndex(headerIndexes)) {
                i = -1;
            } else {
                i = list2.get(i3);
            }
            nextHeaderListPosition = i.intValue();
            index++;
        }
        int indexInComposedVisibleItems = -1;
        List $this$fastForEachIndexed$iv = composedVisibleItems;
        int size2 = $this$fastForEachIndexed$iv.size();
        for (int index$iv = 0; index$iv < size2; index$iv++) {
            LazyListPositionedItem item = $this$fastForEachIndexed$iv.get(index$iv);
            int index2 = index$iv;
            if (item.getIndex() == currentHeaderListPosition) {
                indexInComposedVisibleItems = index2;
                currentHeaderOffset = item.getOffset();
            } else if (item.getIndex() == nextHeaderListPosition) {
                nextHeaderOffset = item.getOffset();
            }
        }
        if (currentHeaderListPosition == -1) {
            return null;
        }
        LazyMeasuredItem measuredHeaderItem = lazyMeasuredItemProvider.m917getAndMeasureZjPyQlc(DataIndex.m883constructorimpl(currentHeaderListPosition));
        if (currentHeaderOffset != Integer.MIN_VALUE) {
            headerOffset = Math.max(-i2, currentHeaderOffset);
        } else {
            headerOffset = -i2;
        }
        if (nextHeaderOffset != Integer.MIN_VALUE) {
            headerOffset = Math.min(headerOffset, nextHeaderOffset - measuredHeaderItem.getSize());
        }
        LazyListPositionedItem position = measuredHeaderItem.position(headerOffset, layoutWidth, layoutHeight);
        LazyListPositionedItem it = position;
        if (indexInComposedVisibleItems != -1) {
            list.set(indexInComposedVisibleItems, it);
        } else {
            list.add(0, it);
        }
        return position;
    }
}
