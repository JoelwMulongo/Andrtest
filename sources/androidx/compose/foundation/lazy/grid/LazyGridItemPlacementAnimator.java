package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00162\b\b\u0002\u0010!\u001a\u00020\bH\u0002J;\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u001cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)J<\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00160\u00122\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020+J\u0018\u00105\u001a\u00020+2\u0006\u0010 \u001a\u00020\u00162\u0006\u00106\u001a\u00020\rH\u0002J\u0014\u00107\u001a\u00020\u0005*\u00020\r2\u0006\u00108\u001a\u00020\bH\u0002J\u001c\u00109\u001a\u00020\u001c*\u00020\bH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000fj\b\u0012\u0004\u0012\u00020\u0001`\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\u00020\b*\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\b*\u00020\u001c8BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006<"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "(Lkotlinx/coroutines/CoroutineScope;Z)V", "firstVisibleIndex", "", "keyToIndexMap", "", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/grid/ItemInfo;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "movingInFromStartBound", "line", "getLine", "(Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;)I", "mainAxis", "Landroidx/compose/ui/unit/IntOffset;", "getMainAxis--gyyYBs", "(J)I", "createItemInfo", "item", "mainAxisOffset", "getAnimatedOffset", "key", "placeableIndex", "minOffset", "maxOffset", "rawOffset", "getAnimatedOffset-YT5a7pE", "(Ljava/lang/Object;IIIJ)J", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "reset", "startAnimationsIfNeeded", "itemInfo", "isWithinBounds", "mainAxisLayoutSize", "toOffset", "toOffset-Bjo55l4", "(I)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridItemPlacementAnimator.kt */
public final class LazyGridItemPlacementAnimator {
    private int firstVisibleIndex;
    private final boolean isVertical;
    /* access modifiers changed from: private */
    public Map<Object, Integer> keyToIndexMap = MapsKt.emptyMap();
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyGridMeasuredItem> movingAwayToEndBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyGridPositionedItem> movingInFromEndBound = new ArrayList();
    private final List<LazyGridPositionedItem> movingInFromStartBound = new ArrayList();
    private final CoroutineScope scope;

    public LazyGridItemPlacementAnimator(CoroutineScope scope2, boolean isVertical2) {
        Intrinsics.checkNotNullParameter(scope2, "scope");
        this.scope = scope2;
        this.isVertical = isVertical2;
    }

    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, List<LazyGridPositionedItem> positionedItems, LazyMeasuredItemProvider itemProvider, LazyGridSpanLayoutProvider spanLayoutProvider) {
        boolean z;
        int i;
        int previousLineMainAxisSize;
        boolean inProgress;
        int previousLineMainAxisSize2;
        Object key;
        long j;
        int previousLineMainAxisSize3;
        int i2;
        int previousFirstVisibleIndex;
        int $i$f$fastForEach;
        List $this$fastForEach$iv;
        List<LazyGridPositionedItem> list = positionedItems;
        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider = spanLayoutProvider;
        Intrinsics.checkNotNullParameter(list, "positionedItems");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(lazyGridSpanLayoutProvider, "spanLayoutProvider");
        List $this$fastForEach$iv$iv = positionedItems;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (true) {
            if (index$iv$iv >= size) {
                z = false;
                break;
            } else if (((LazyGridPositionedItem) $this$fastForEach$iv$iv.get(index$iv$iv)).getHasAnimations()) {
                z = true;
                break;
            } else {
                index$iv$iv++;
            }
        }
        if (z || !this.keyToItemInfoMap.isEmpty()) {
            int previousFirstVisibleIndex2 = this.firstVisibleIndex;
            LazyGridPositionedItem lazyGridPositionedItem = (LazyGridPositionedItem) CollectionsKt.firstOrNull(positionedItems);
            this.firstVisibleIndex = lazyGridPositionedItem != null ? lazyGridPositionedItem.getIndex() : 0;
            Map previousKeyToIndexMap = this.keyToIndexMap;
            this.keyToIndexMap = itemProvider.getKeyToIndexMap();
            int mainAxisLayoutSize = this.isVertical ? layoutHeight : layoutWidth;
            long notAnimatableDelta = m956toOffsetBjo55l4(consumedScroll);
            this.movingAwayKeys.addAll(this.keyToItemInfoMap.keySet());
            List $this$fastForEach$iv2 = positionedItems;
            int $i$f$fastForEach2 = false;
            int index$iv = 0;
            int size2 = $this$fastForEach$iv2.size();
            while (index$iv < size2) {
                LazyGridPositionedItem item = $this$fastForEach$iv2.get(index$iv);
                this.movingAwayKeys.remove(item.getKey());
                if (item.getHasAnimations()) {
                    ItemInfo itemInfo = this.keyToItemInfoMap.get(item.getKey());
                    if (itemInfo == null) {
                        Integer previousIndex = previousKeyToIndexMap.get(item.getKey());
                        if (previousIndex != null) {
                            $this$fastForEach$iv = $this$fastForEach$iv2;
                            $i$f$fastForEach = $i$f$fastForEach2;
                            if (item.getIndex() != previousIndex.intValue()) {
                                if (previousIndex.intValue() < previousFirstVisibleIndex2) {
                                    this.movingInFromStartBound.add(item);
                                    previousFirstVisibleIndex = previousFirstVisibleIndex2;
                                    i2 = size2;
                                } else {
                                    this.movingInFromEndBound.add(item);
                                    previousFirstVisibleIndex = previousFirstVisibleIndex2;
                                    i2 = size2;
                                }
                            }
                        } else {
                            $this$fastForEach$iv = $this$fastForEach$iv2;
                            $i$f$fastForEach = $i$f$fastForEach2;
                        }
                        previousFirstVisibleIndex = previousFirstVisibleIndex2;
                        i2 = size2;
                        this.keyToItemInfoMap.put(item.getKey(), createItemInfo$default(this, item, 0, 2, (Object) null));
                    } else {
                        previousFirstVisibleIndex = previousFirstVisibleIndex2;
                        $this$fastForEach$iv = $this$fastForEach$iv2;
                        $i$f$fastForEach = $i$f$fastForEach2;
                        i2 = size2;
                        long arg0$iv = itemInfo.m945getNotAnimatableDeltanOccac();
                        itemInfo.m946setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(arg0$iv) + IntOffset.m6104getXimpl(notAnimatableDelta), IntOffset.m6105getYimpl(arg0$iv) + IntOffset.m6105getYimpl(notAnimatableDelta)));
                        itemInfo.setCrossAxisSize(item.getCrossAxisSize());
                        itemInfo.setCrossAxisOffset(item.getCrossAxisOffset());
                        startAnimationsIfNeeded(item, itemInfo);
                    }
                } else {
                    previousFirstVisibleIndex = previousFirstVisibleIndex2;
                    $this$fastForEach$iv = $this$fastForEach$iv2;
                    $i$f$fastForEach = $i$f$fastForEach2;
                    i2 = size2;
                    this.keyToItemInfoMap.remove(item.getKey());
                }
                index$iv++;
                $this$fastForEach$iv2 = $this$fastForEach$iv;
                $i$f$fastForEach2 = $i$f$fastForEach;
                previousFirstVisibleIndex2 = previousFirstVisibleIndex;
                size2 = i2;
            }
            List list2 = $this$fastForEach$iv2;
            int i3 = $i$f$fastForEach2;
            int currentMainAxisOffset = 0;
            List $this$sortByDescending$iv = this.movingInFromStartBound;
            if ($this$sortByDescending$iv.size() > 1) {
                CollectionsKt.sortWith($this$sortByDescending$iv, new LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1(previousKeyToIndexMap));
            }
            int previousLine = -1;
            int previousLineMainAxisSize4 = 0;
            List $this$fastForEach$iv3 = this.movingInFromStartBound;
            int index$iv2 = 0;
            int size3 = $this$fastForEach$iv3.size();
            while (true) {
                i = -1;
                if (index$iv2 >= size3) {
                    break;
                }
                LazyGridPositionedItem item2 = $this$fastForEach$iv3.get(index$iv2);
                List $this$fastForEach$iv4 = $this$fastForEach$iv3;
                int line = getLine(item2);
                if (line == -1 || line != previousLine) {
                    currentMainAxisOffset += previousLineMainAxisSize4;
                    previousLineMainAxisSize3 = item2.getMainAxisSize();
                    previousLine = line;
                } else {
                    previousLineMainAxisSize3 = Math.max(previousLineMainAxisSize4, item2.getMainAxisSize());
                }
                int currentMainAxisOffset2 = currentMainAxisOffset;
                ItemInfo itemInfo2 = createItemInfo(item2, (0 - currentMainAxisOffset) - item2.getMainAxisSize());
                this.keyToItemInfoMap.put(item2.getKey(), itemInfo2);
                startAnimationsIfNeeded(item2, itemInfo2);
                index$iv2++;
                $this$fastForEach$iv3 = $this$fastForEach$iv4;
                currentMainAxisOffset = currentMainAxisOffset2;
                previousLine = previousLine;
                previousLineMainAxisSize4 = previousLineMainAxisSize3;
            }
            int currentMainAxisOffset3 = 0;
            List $this$sortBy$iv = this.movingInFromEndBound;
            if ($this$sortBy$iv.size() > 1) {
                CollectionsKt.sortWith($this$sortBy$iv, new LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1(previousKeyToIndexMap));
            }
            List $this$fastForEach$iv5 = this.movingInFromEndBound;
            int index$iv3 = 0;
            int size4 = $this$fastForEach$iv5.size();
            int previousLine2 = -1;
            int previousLineMainAxisSize5 = 0;
            while (index$iv3 < size4) {
                LazyGridPositionedItem lazyGridPositionedItem2 = $this$fastForEach$iv5.get(index$iv3);
                LazyGridPositionedItem item3 = lazyGridPositionedItem2;
                LazyGridPositionedItem lazyGridPositionedItem3 = lazyGridPositionedItem2;
                int line2 = getLine(item3);
                if (line2 == i || line2 != previousLine2) {
                    currentMainAxisOffset3 += previousLineMainAxisSize5;
                    previousLineMainAxisSize5 = item3.getMainAxisSize();
                    previousLine2 = line2;
                } else {
                    previousLineMainAxisSize5 = Math.max(previousLineMainAxisSize5, item3.getMainAxisSize());
                }
                int currentMainAxisOffset4 = currentMainAxisOffset3;
                ItemInfo itemInfo3 = createItemInfo(item3, mainAxisLayoutSize + currentMainAxisOffset3);
                int i4 = line2;
                this.keyToItemInfoMap.put(item3.getKey(), itemInfo3);
                startAnimationsIfNeeded(item3, itemInfo3);
                index$iv3++;
                currentMainAxisOffset3 = currentMainAxisOffset4;
                $this$fastForEach$iv5 = $this$fastForEach$iv5;
                i = -1;
            }
            for (Object key2 : this.movingAwayKeys) {
                ItemInfo itemInfo4 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, key2);
                Integer newIndex = this.keyToIndexMap.get(key2);
                List placeables = itemInfo4.getPlaceables();
                List $this$fastForEach$iv$iv2 = placeables;
                int currentMainAxisOffset5 = currentMainAxisOffset3;
                int currentMainAxisOffset6 = $this$fastForEach$iv$iv2.size();
                List<PlaceableInfo> list3 = placeables;
                int index$iv$iv2 = 0;
                while (true) {
                    if (index$iv$iv2 >= currentMainAxisOffset6) {
                        inProgress = false;
                        break;
                    } else if (((PlaceableInfo) $this$fastForEach$iv$iv2.get(index$iv$iv2)).getInProgress()) {
                        inProgress = true;
                        break;
                    } else {
                        index$iv$iv2++;
                    }
                }
                if (itemInfo4.getPlaceables().isEmpty()) {
                    Integer num = newIndex;
                    key = key2;
                    previousLineMainAxisSize2 = previousLineMainAxisSize5;
                } else if (newIndex == null) {
                    Integer num2 = newIndex;
                    key = key2;
                    previousLineMainAxisSize2 = previousLineMainAxisSize5;
                } else if (!inProgress && Intrinsics.areEqual((Object) newIndex, (Object) previousKeyToIndexMap.get(key2))) {
                    ItemInfo itemInfo5 = itemInfo4;
                    Integer num3 = newIndex;
                    key = key2;
                    previousLineMainAxisSize2 = previousLineMainAxisSize5;
                } else if (inProgress || isWithinBounds(itemInfo4, mainAxisLayoutSize)) {
                    int r5 = ItemIndex.m934constructorimpl(newIndex.intValue());
                    if (this.isVertical) {
                        j = Constraints.Companion.m5940fixedWidthOenEA2s(itemInfo4.getCrossAxisSize());
                    } else {
                        j = Constraints.Companion.m5939fixedHeightOenEA2s(itemInfo4.getCrossAxisSize());
                    }
                    ItemInfo itemInfo6 = itemInfo4;
                    Object key3 = key2;
                    previousLineMainAxisSize2 = previousLineMainAxisSize5;
                    LazyGridMeasuredItem item4 = LazyMeasuredItemProvider.m981getAndMeasureednRnyU$default(itemProvider, r5, 0, j, 2, (Object) null);
                    if (newIndex.intValue() < this.firstVisibleIndex) {
                        this.movingAwayToStartBound.add(item4);
                        Object obj = key3;
                    } else {
                        this.movingAwayToEndBound.add(item4);
                        Object obj2 = key3;
                    }
                    previousLineMainAxisSize5 = previousLineMainAxisSize2;
                    currentMainAxisOffset3 = currentMainAxisOffset5;
                } else {
                    ItemInfo itemInfo7 = itemInfo4;
                    Integer num4 = newIndex;
                    key = key2;
                    previousLineMainAxisSize2 = previousLineMainAxisSize5;
                }
                this.keyToItemInfoMap.remove(key);
                previousLineMainAxisSize5 = previousLineMainAxisSize2;
                currentMainAxisOffset3 = currentMainAxisOffset5;
            }
            int i5 = previousLineMainAxisSize5;
            int currentMainAxisOffset7 = 0;
            int previousLine3 = -1;
            int previousLineMainAxisSize6 = 0;
            List $this$sortByDescending$iv2 = this.movingAwayToStartBound;
            if ($this$sortByDescending$iv2.size() > 1) {
                CollectionsKt.sortWith($this$sortByDescending$iv2, new LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2(this));
            }
            List $this$fastForEach$iv6 = this.movingAwayToStartBound;
            int $i$f$fastForEach3 = false;
            int index$iv4 = 0;
            int size5 = $this$fastForEach$iv6.size();
            while (index$iv4 < size5) {
                LazyGridMeasuredItem item5 = $this$fastForEach$iv6.get(index$iv4);
                List $this$fastForEach$iv7 = $this$fastForEach$iv6;
                int line3 = lazyGridSpanLayoutProvider.m979getLineIndexOfItem_Ze7BM(item5.m968getIndexVZbfaAc());
                int $i$f$fastForEach4 = $i$f$fastForEach3;
                if (line3 == -1 || line3 != previousLine3) {
                    currentMainAxisOffset7 += previousLineMainAxisSize6;
                    previousLineMainAxisSize6 = item5.getMainAxisSize();
                    previousLine3 = line3;
                } else {
                    previousLineMainAxisSize6 = Math.max(previousLineMainAxisSize6, item5.getMainAxisSize());
                }
                int mainAxisOffset = (0 - currentMainAxisOffset7) - item5.getMainAxisSize();
                int currentMainAxisOffset8 = currentMainAxisOffset7;
                int previousLine4 = previousLine3;
                ItemInfo itemInfo8 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, item5.getKey());
                LazyGridPositionedItem positionedItem = item5.position(mainAxisOffset, itemInfo8.getCrossAxisOffset(), layoutWidth, layoutHeight, -1, -1);
                list.add(positionedItem);
                startAnimationsIfNeeded(positionedItem, itemInfo8);
                index$iv4++;
                $this$fastForEach$iv6 = $this$fastForEach$iv7;
                $i$f$fastForEach3 = $i$f$fastForEach4;
                currentMainAxisOffset7 = currentMainAxisOffset8;
                previousLine3 = previousLine4;
            }
            int i6 = $i$f$fastForEach3;
            int currentMainAxisOffset9 = 0;
            int previousLine5 = -1;
            int previousLineMainAxisSize7 = 0;
            List $this$sortBy$iv2 = this.movingAwayToEndBound;
            if ($this$sortBy$iv2.size() > 1) {
                CollectionsKt.sortWith($this$sortBy$iv2, new LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2(this));
            }
            List $this$fastForEach$iv8 = this.movingAwayToEndBound;
            int index$iv5 = 0;
            int size6 = $this$fastForEach$iv8.size();
            while (index$iv5 < size6) {
                LazyGridMeasuredItem item6 = $this$fastForEach$iv8.get(index$iv5);
                List $this$fastForEach$iv9 = $this$fastForEach$iv8;
                int line4 = lazyGridSpanLayoutProvider.m979getLineIndexOfItem_Ze7BM(item6.m968getIndexVZbfaAc());
                if (line4 == -1 || line4 != previousLine5) {
                    currentMainAxisOffset9 += previousLineMainAxisSize7;
                    previousLineMainAxisSize = item6.getMainAxisSize();
                    previousLine5 = line4;
                } else {
                    previousLineMainAxisSize = Math.max(previousLineMainAxisSize7, item6.getMainAxisSize());
                }
                previousLineMainAxisSize7 = previousLineMainAxisSize;
                int previousLineMainAxisSize8 = mainAxisLayoutSize + currentMainAxisOffset9;
                int currentMainAxisOffset10 = currentMainAxisOffset9;
                int previousLine6 = previousLine5;
                ItemInfo itemInfo9 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, item6.getKey());
                LazyGridPositionedItem positionedItem2 = item6.position(previousLineMainAxisSize8, itemInfo9.getCrossAxisOffset(), layoutWidth, layoutHeight, -1, -1);
                list.add(positionedItem2);
                startAnimationsIfNeeded(positionedItem2, itemInfo9);
                index$iv5++;
                lazyGridSpanLayoutProvider = spanLayoutProvider;
                $this$fastForEach$iv8 = $this$fastForEach$iv9;
                currentMainAxisOffset9 = currentMainAxisOffset10;
                previousLine5 = previousLine6;
            }
            this.movingInFromStartBound.clear();
            this.movingInFromEndBound.clear();
            this.movingAwayToStartBound.clear();
            this.movingAwayToEndBound.clear();
            this.movingAwayKeys.clear();
            return;
        }
        reset();
    }

    /* renamed from: getAnimatedOffset-YT5a7pE  reason: not valid java name */
    public final long m957getAnimatedOffsetYT5a7pE(Object key, int placeableIndex, int minOffset, int maxOffset, long rawOffset) {
        Object obj = key;
        int i = minOffset;
        int i2 = maxOffset;
        Intrinsics.checkNotNullParameter(obj, "key");
        ItemInfo itemInfo = this.keyToItemInfoMap.get(obj);
        if (itemInfo == null) {
            return rawOffset;
        }
        PlaceableInfo item = itemInfo.getPlaceables().get(placeableIndex);
        long arg0$iv = item.getAnimatedOffset().getValue().m6113unboximpl();
        long other$iv = itemInfo.m945getNotAnimatableDeltanOccac();
        long currentValue = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(arg0$iv) + IntOffset.m6104getXimpl(other$iv), IntOffset.m6105getYimpl(arg0$iv) + IntOffset.m6105getYimpl(other$iv));
        long arg0$iv2 = item.m1001getTargetOffsetnOccac();
        long other$iv2 = itemInfo.m945getNotAnimatableDeltanOccac();
        long arg0$iv3 = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(arg0$iv2) + IntOffset.m6104getXimpl(other$iv2), IntOffset.m6105getYimpl(arg0$iv2) + IntOffset.m6105getYimpl(other$iv2));
        if (item.getInProgress() && ((m955getMainAxisgyyYBs(arg0$iv3) <= i && m955getMainAxisgyyYBs(currentValue) < i) || (m955getMainAxisgyyYBs(arg0$iv3) >= i2 && m955getMainAxisgyyYBs(currentValue) > i2))) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyGridItemPlacementAnimator$getAnimatedOffset$1(item, (Continuation<? super LazyGridItemPlacementAnimator$getAnimatedOffset$1>) null), 3, (Object) null);
        }
        return currentValue;
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyToIndexMap = MapsKt.emptyMap();
        this.firstVisibleIndex = -1;
    }

    static /* synthetic */ ItemInfo createItemInfo$default(LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, LazyGridPositionedItem lazyGridPositionedItem, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = lazyGridItemPlacementAnimator.m955getMainAxisgyyYBs(lazyGridPositionedItem.m971getOffsetnOccac());
        }
        return lazyGridItemPlacementAnimator.createItemInfo(lazyGridPositionedItem, i);
    }

    private final ItemInfo createItemInfo(LazyGridPositionedItem item, int mainAxisOffset) {
        long targetOffset;
        ItemInfo newItemInfo = new ItemInfo(item.getCrossAxisSize(), item.getCrossAxisOffset());
        if (this.isVertical) {
            targetOffset = IntOffset.m6100copyiSbpLlY$default(item.m971getOffsetnOccac(), 0, mainAxisOffset, 1, (Object) null);
        } else {
            targetOffset = IntOffset.m6100copyiSbpLlY$default(item.m971getOffsetnOccac(), mainAxisOffset, 0, 2, (Object) null);
        }
        int placeablesCount = item.getPlaceablesCount();
        for (int placeableIndex = 0; placeableIndex < placeablesCount; placeableIndex++) {
            newItemInfo.getPlaceables().add(new PlaceableInfo(targetOffset, item.getMainAxisSize(placeableIndex), (DefaultConstructorMarker) null));
        }
        return newItemInfo;
    }

    private final void startAnimationsIfNeeded(LazyGridPositionedItem item, ItemInfo itemInfo) {
        List $this$fastForEachIndexed$iv;
        Object obj;
        LazyGridPositionedItem lazyGridPositionedItem = item;
        while (itemInfo.getPlaceables().size() > item.getPlaceablesCount()) {
            CollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (itemInfo.getPlaceables().size() < item.getPlaceablesCount()) {
            int newPlaceableInfoIndex = itemInfo.getPlaceables().size();
            long rawOffset = item.m971getOffsetnOccac();
            List<PlaceableInfo> placeables = itemInfo.getPlaceables();
            long other$iv = itemInfo.m945getNotAnimatableDeltanOccac();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(rawOffset) - IntOffset.m6104getXimpl(other$iv), IntOffset.m6105getYimpl(rawOffset) - IntOffset.m6105getYimpl(other$iv)), lazyGridPositionedItem.getMainAxisSize(newPlaceableInfoIndex), (DefaultConstructorMarker) null));
        }
        List $this$fastForEachIndexed$iv2 = itemInfo.getPlaceables();
        int index$iv = 0;
        int size = $this$fastForEachIndexed$iv2.size();
        while (index$iv < size) {
            PlaceableInfo placeableInfo = $this$fastForEachIndexed$iv2.get(index$iv);
            int index = index$iv;
            long arg0$iv = placeableInfo.m1001getTargetOffsetnOccac();
            long other$iv2 = itemInfo.m945getNotAnimatableDeltanOccac();
            long arg0$iv2 = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(arg0$iv) + IntOffset.m6104getXimpl(other$iv2), IntOffset.m6105getYimpl(arg0$iv) + IntOffset.m6105getYimpl(other$iv2));
            long currentOffset = item.m971getOffsetnOccac();
            placeableInfo.setMainAxisSize(lazyGridPositionedItem.getMainAxisSize(index));
            FiniteAnimationSpec animationSpec = lazyGridPositionedItem.getAnimationSpec(index);
            if (!IntOffset.m6103equalsimpl0(arg0$iv2, currentOffset)) {
                long other$iv3 = itemInfo.m945getNotAnimatableDeltanOccac();
                $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
                placeableInfo.m1002setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(currentOffset) - IntOffset.m6104getXimpl(other$iv3), IntOffset.m6105getYimpl(currentOffset) - IntOffset.m6105getYimpl(other$iv3)));
                if (animationSpec != null) {
                    placeableInfo.setInProgress(true);
                    obj = null;
                    Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyGridItemPlacementAnimator$startAnimationsIfNeeded$1$1(placeableInfo, animationSpec, (Continuation<? super LazyGridItemPlacementAnimator$startAnimationsIfNeeded$1$1>) null), 3, (Object) null);
                } else {
                    obj = null;
                }
            } else {
                obj = null;
                $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
            }
            index$iv++;
            lazyGridPositionedItem = item;
            Object obj2 = obj;
            $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0060 A[LOOP:0: B:1:0x0010->B:10:0x0060, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isWithinBounds(androidx.compose.foundation.lazy.grid.ItemInfo r23, int r24) {
        /*
            r22 = this;
            r0 = r22
            java.util.List r1 = r23.getPlaceables()
            r2 = 0
            r3 = r1
            r4 = 0
            r5 = 0
            int r6 = r3.size()
        L_0x0010:
            if (r5 >= r6) goto L_0x0066
            java.lang.Object r8 = r3.get(r5)
            r9 = r8
            r10 = 0
            r11 = r9
            androidx.compose.foundation.lazy.grid.PlaceableInfo r11 = (androidx.compose.foundation.lazy.grid.PlaceableInfo) r11
            r12 = 0
            long r13 = r11.m1001getTargetOffsetnOccac()
            long r15 = r23.m945getNotAnimatableDeltanOccac()
            r17 = 0
            int r18 = androidx.compose.ui.unit.IntOffset.m6104getXimpl(r13)
            int r19 = androidx.compose.ui.unit.IntOffset.m6104getXimpl(r15)
            int r7 = r18 + r19
            int r18 = androidx.compose.ui.unit.IntOffset.m6105getYimpl(r13)
            int r19 = androidx.compose.ui.unit.IntOffset.m6105getYimpl(r15)
            r21 = r1
            int r1 = r18 + r19
            long r13 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r7, r1)
            int r1 = r0.m955getMainAxisgyyYBs(r13)
            int r7 = r11.getMainAxisSize()
            int r1 = r1 + r7
            r7 = 1
            if (r1 <= 0) goto L_0x0058
            int r1 = r0.m955getMainAxisgyyYBs(r13)
            r15 = r24
            if (r1 >= r15) goto L_0x005a
            r20 = r7
            goto L_0x005c
        L_0x0058:
            r15 = r24
        L_0x005a:
            r20 = 0
        L_0x005c:
            if (r20 == 0) goto L_0x0060
            goto L_0x006c
        L_0x0060:
            int r5 = r5 + 1
            r1 = r21
            goto L_0x0010
        L_0x0066:
            r15 = r24
            r21 = r1
            r7 = 0
        L_0x006c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator.isWithinBounds(androidx.compose.foundation.lazy.grid.ItemInfo, int):boolean");
    }

    /* renamed from: toOffset-Bjo55l4  reason: not valid java name */
    private final long m956toOffsetBjo55l4(int $this$toOffset_u2dBjo55l4) {
        boolean z = this.isVertical;
        int i = 0;
        int i2 = z ? 0 : $this$toOffset_u2dBjo55l4;
        if (z) {
            i = $this$toOffset_u2dBjo55l4;
        }
        return IntOffsetKt.IntOffset(i2, i);
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m955getMainAxisgyyYBs(long $this$mainAxis) {
        return this.isVertical ? IntOffset.m6105getYimpl($this$mainAxis) : IntOffset.m6104getXimpl($this$mainAxis);
    }

    private final int getLine(LazyGridPositionedItem $this$line) {
        return this.isVertical ? $this$line.getRow() : $this$line.getColumn();
    }
}
