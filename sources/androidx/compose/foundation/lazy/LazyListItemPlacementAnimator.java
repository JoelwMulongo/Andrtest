package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
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

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00162\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0002J;\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0019ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&J4\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00160\u00122\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020(J\u0018\u00100\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u00101\u001a\u00020\rH\u0002J\u0014\u00102\u001a\u00020\u0005*\u00020\r2\u0006\u00103\u001a\u00020\bH\u0002J\u001c\u00104\u001a\u00020\u0019*\u00020\bH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000fj\b\u0012\u0004\u0012\u00020\u0001`\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\b*\u00020\u00198BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "(Lkotlinx/coroutines/CoroutineScope;Z)V", "firstVisibleIndex", "", "keyToIndexMap", "", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/ItemInfo;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "movingInFromStartBound", "mainAxis", "Landroidx/compose/ui/unit/IntOffset;", "getMainAxis--gyyYBs", "(J)I", "createItemInfo", "item", "mainAxisOffset", "getAnimatedOffset", "key", "placeableIndex", "minOffset", "maxOffset", "rawOffset", "getAnimatedOffset-YT5a7pE", "(Ljava/lang/Object;IIIJ)J", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "reset", "startAnimationsIfNeeded", "itemInfo", "isWithinBounds", "mainAxisLayoutSize", "toOffset", "toOffset-Bjo55l4", "(I)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListItemPlacementAnimator.kt */
public final class LazyListItemPlacementAnimator {
    private int firstVisibleIndex;
    private final boolean isVertical;
    /* access modifiers changed from: private */
    public Map<Object, Integer> keyToIndexMap = MapsKt.emptyMap();
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyMeasuredItem> movingAwayToEndBound = new ArrayList();
    private final List<LazyMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyListPositionedItem> movingInFromEndBound = new ArrayList();
    private final List<LazyListPositionedItem> movingInFromStartBound = new ArrayList();
    private final CoroutineScope scope;

    public LazyListItemPlacementAnimator(CoroutineScope scope2, boolean isVertical2) {
        Intrinsics.checkNotNullParameter(scope2, "scope");
        this.scope = scope2;
        this.isVertical = isVertical2;
    }

    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, List<LazyListPositionedItem> positionedItems, LazyMeasuredItemProvider itemProvider) {
        boolean z;
        boolean inProgress;
        int $i$f$forEach;
        int previousFirstVisibleIndex;
        int i;
        int $i$f$fastForEach;
        int i2 = layoutWidth;
        int i3 = layoutHeight;
        Intrinsics.checkNotNullParameter(positionedItems, "positionedItems");
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        List $this$fastForEach$iv$iv = positionedItems;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (true) {
            if (index$iv$iv >= size) {
                z = false;
                break;
            } else if (((LazyListPositionedItem) $this$fastForEach$iv$iv.get(index$iv$iv)).getHasAnimations()) {
                z = true;
                break;
            } else {
                index$iv$iv++;
            }
        }
        if (z || !this.keyToItemInfoMap.isEmpty()) {
            int previousFirstVisibleIndex2 = this.firstVisibleIndex;
            LazyListPositionedItem lazyListPositionedItem = (LazyListPositionedItem) CollectionsKt.firstOrNull(positionedItems);
            this.firstVisibleIndex = lazyListPositionedItem != null ? lazyListPositionedItem.getIndex() : 0;
            Map previousKeyToIndexMap = this.keyToIndexMap;
            this.keyToIndexMap = itemProvider.getKeyToIndexMap();
            int mainAxisLayoutSize = this.isVertical ? i3 : i2;
            long notAnimatableDelta = m898toOffsetBjo55l4(consumedScroll);
            this.movingAwayKeys.addAll(this.keyToItemInfoMap.keySet());
            List $this$fastForEach$iv = positionedItems;
            int $i$f$fastForEach2 = false;
            int index$iv = 0;
            int size2 = $this$fastForEach$iv.size();
            while (index$iv < size2) {
                LazyListPositionedItem item = $this$fastForEach$iv.get(index$iv);
                List $this$fastForEach$iv2 = $this$fastForEach$iv;
                this.movingAwayKeys.remove(item.getKey());
                if (item.getHasAnimations()) {
                    ItemInfo itemInfo = this.keyToItemInfoMap.get(item.getKey());
                    if (itemInfo == null) {
                        Integer previousIndex = previousKeyToIndexMap.get(item.getKey());
                        if (previousIndex != null) {
                            $i$f$fastForEach = $i$f$fastForEach2;
                            i = size2;
                            if (item.getIndex() != previousIndex.intValue()) {
                                if (previousIndex.intValue() < previousFirstVisibleIndex2) {
                                    this.movingInFromStartBound.add(item);
                                    previousFirstVisibleIndex = previousFirstVisibleIndex2;
                                } else {
                                    this.movingInFromEndBound.add(item);
                                    previousFirstVisibleIndex = previousFirstVisibleIndex2;
                                }
                            }
                        } else {
                            $i$f$fastForEach = $i$f$fastForEach2;
                            i = size2;
                        }
                        previousFirstVisibleIndex = previousFirstVisibleIndex2;
                        Integer num = previousIndex;
                        this.keyToItemInfoMap.put(item.getKey(), createItemInfo$default(this, item, 0, 2, (Object) null));
                    } else {
                        previousFirstVisibleIndex = previousFirstVisibleIndex2;
                        $i$f$fastForEach = $i$f$fastForEach2;
                        i = size2;
                        long arg0$iv = itemInfo.m895getNotAnimatableDeltanOccac();
                        itemInfo.m896setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(arg0$iv) + IntOffset.m6104getXimpl(notAnimatableDelta), IntOffset.m6105getYimpl(arg0$iv) + IntOffset.m6105getYimpl(notAnimatableDelta)));
                        startAnimationsIfNeeded(item, itemInfo);
                    }
                } else {
                    previousFirstVisibleIndex = previousFirstVisibleIndex2;
                    $i$f$fastForEach = $i$f$fastForEach2;
                    i = size2;
                    this.keyToItemInfoMap.remove(item.getKey());
                }
                index$iv++;
                List<LazyListPositionedItem> list = positionedItems;
                LazyMeasuredItemProvider lazyMeasuredItemProvider = itemProvider;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                $i$f$fastForEach2 = $i$f$fastForEach;
                size2 = i;
                previousFirstVisibleIndex2 = previousFirstVisibleIndex;
            }
            List list2 = $this$fastForEach$iv;
            int i4 = $i$f$fastForEach2;
            int currentMainAxisOffset = 0;
            List $this$sortByDescending$iv = this.movingInFromStartBound;
            if ($this$sortByDescending$iv.size() > 1) {
                CollectionsKt.sortWith($this$sortByDescending$iv, new LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1(previousKeyToIndexMap));
            }
            List $this$fastForEach$iv3 = this.movingInFromStartBound;
            int $i$f$fastForEach3 = false;
            int index$iv2 = 0;
            int size3 = $this$fastForEach$iv3.size();
            while (index$iv2 < size3) {
                LazyListPositionedItem item2 = $this$fastForEach$iv3.get(index$iv2);
                int mainAxisOffset = (0 - currentMainAxisOffset) - item2.getSize();
                int currentMainAxisOffset2 = currentMainAxisOffset + item2.getSize();
                ItemInfo itemInfo2 = createItemInfo(item2, mainAxisOffset);
                this.keyToItemInfoMap.put(item2.getKey(), itemInfo2);
                startAnimationsIfNeeded(item2, itemInfo2);
                index$iv2++;
                currentMainAxisOffset = currentMainAxisOffset2;
                $this$fastForEach$iv3 = $this$fastForEach$iv3;
                $i$f$fastForEach3 = $i$f$fastForEach3;
            }
            int i5 = $i$f$fastForEach3;
            int currentMainAxisOffset3 = 0;
            List $this$sortBy$iv = this.movingInFromEndBound;
            if ($this$sortBy$iv.size() > 1) {
                CollectionsKt.sortWith($this$sortBy$iv, new LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$1(previousKeyToIndexMap));
            }
            List $this$fastForEach$iv4 = this.movingInFromEndBound;
            int $i$f$fastForEach4 = false;
            int index$iv3 = 0;
            int size4 = $this$fastForEach$iv4.size();
            while (index$iv3 < size4) {
                LazyListPositionedItem item3 = $this$fastForEach$iv4.get(index$iv3);
                int currentMainAxisOffset4 = currentMainAxisOffset3 + item3.getSize();
                ItemInfo itemInfo3 = createItemInfo(item3, mainAxisLayoutSize + currentMainAxisOffset3);
                this.keyToItemInfoMap.put(item3.getKey(), itemInfo3);
                startAnimationsIfNeeded(item3, itemInfo3);
                index$iv3++;
                currentMainAxisOffset3 = currentMainAxisOffset4;
                $this$fastForEach$iv4 = $this$fastForEach$iv4;
                $i$f$fastForEach4 = $i$f$fastForEach4;
            }
            int i6 = $i$f$fastForEach4;
            Iterable $this$forEach$iv = this.movingAwayKeys;
            int $i$f$forEach2 = false;
            for (Object key : $this$forEach$iv) {
                ItemInfo itemInfo4 = (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, key);
                Integer newIndex = this.keyToIndexMap.get(key);
                List $this$fastForEach$iv$iv2 = itemInfo4.getPlaceables();
                int currentMainAxisOffset5 = currentMainAxisOffset3;
                int currentMainAxisOffset6 = $this$fastForEach$iv$iv2.size();
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                int index$iv$iv2 = 0;
                while (true) {
                    if (index$iv$iv2 >= currentMainAxisOffset6) {
                        inProgress = false;
                        break;
                    }
                    int i7 = currentMainAxisOffset6;
                    List $this$fastForEach$iv$iv3 = $this$fastForEach$iv$iv2;
                    if (((PlaceableInfo) $this$fastForEach$iv$iv3.get(index$iv$iv2)).getInProgress()) {
                        inProgress = true;
                        break;
                    }
                    index$iv$iv2++;
                    $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv3;
                    currentMainAxisOffset6 = i7;
                }
                if (itemInfo4.getPlaceables().isEmpty()) {
                    $i$f$forEach = $i$f$forEach2;
                } else if (newIndex == null) {
                    $i$f$forEach = $i$f$forEach2;
                } else if (!inProgress && Intrinsics.areEqual((Object) newIndex, (Object) previousKeyToIndexMap.get(key))) {
                    boolean z2 = inProgress;
                    $i$f$forEach = $i$f$forEach2;
                } else if (inProgress || isWithinBounds(itemInfo4, mainAxisLayoutSize)) {
                    boolean z3 = inProgress;
                    LazyMeasuredItem item4 = itemProvider.m917getAndMeasureZjPyQlc(DataIndex.m883constructorimpl(newIndex.intValue()));
                    $i$f$forEach = $i$f$forEach2;
                    if (newIndex.intValue() < this.firstVisibleIndex) {
                        this.movingAwayToStartBound.add(item4);
                    } else {
                        this.movingAwayToEndBound.add(item4);
                    }
                    $i$f$forEach2 = $i$f$forEach;
                    currentMainAxisOffset3 = currentMainAxisOffset5;
                    $this$forEach$iv = $this$forEach$iv2;
                } else {
                    boolean z4 = inProgress;
                    $i$f$forEach = $i$f$forEach2;
                }
                this.keyToItemInfoMap.remove(key);
                $i$f$forEach2 = $i$f$forEach;
                currentMainAxisOffset3 = currentMainAxisOffset5;
                $this$forEach$iv = $this$forEach$iv2;
            }
            Iterable iterable = $this$forEach$iv;
            int i8 = $i$f$forEach2;
            int currentMainAxisOffset7 = 0;
            List $this$sortByDescending$iv2 = this.movingAwayToStartBound;
            if ($this$sortByDescending$iv2.size() > 1) {
                CollectionsKt.sortWith($this$sortByDescending$iv2, new LazyListItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2(this));
            }
            List $this$fastForEach$iv5 = this.movingAwayToStartBound;
            int $i$f$fastForEach5 = false;
            int index$iv4 = 0;
            int size5 = $this$fastForEach$iv5.size();
            while (index$iv4 < size5) {
                LazyMeasuredItem item5 = $this$fastForEach$iv5.get(index$iv4);
                int mainAxisOffset2 = (0 - currentMainAxisOffset7) - item5.getSize();
                int currentMainAxisOffset8 = currentMainAxisOffset7 + item5.getSize();
                List $this$fastForEach$iv6 = $this$fastForEach$iv5;
                LazyListPositionedItem positionedItem = item5.position(mainAxisOffset2, i2, i3);
                positionedItems.add(positionedItem);
                startAnimationsIfNeeded(positionedItem, (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, item5.getKey()));
                index$iv4++;
                currentMainAxisOffset7 = currentMainAxisOffset8;
                $this$fastForEach$iv5 = $this$fastForEach$iv6;
                $i$f$fastForEach5 = $i$f$fastForEach5;
            }
            int i9 = $i$f$fastForEach5;
            List<LazyListPositionedItem> list3 = positionedItems;
            int currentMainAxisOffset9 = 0;
            List $this$sortBy$iv2 = this.movingAwayToEndBound;
            if ($this$sortBy$iv2.size() > 1) {
                CollectionsKt.sortWith($this$sortBy$iv2, new LazyListItemPlacementAnimator$onMeasured$$inlined$sortBy$2(this));
            }
            List $this$fastForEach$iv7 = this.movingAwayToEndBound;
            int index$iv5 = 0;
            int size6 = $this$fastForEach$iv7.size();
            while (index$iv5 < size6) {
                LazyMeasuredItem item6 = $this$fastForEach$iv7.get(index$iv5);
                int currentMainAxisOffset10 = currentMainAxisOffset9 + item6.getSize();
                Map previousKeyToIndexMap2 = previousKeyToIndexMap;
                LazyListPositionedItem positionedItem2 = item6.position(mainAxisLayoutSize + currentMainAxisOffset9, i2, i3);
                list3.add(positionedItem2);
                startAnimationsIfNeeded(positionedItem2, (ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, item6.getKey()));
                index$iv5++;
                $this$fastForEach$iv7 = $this$fastForEach$iv7;
                currentMainAxisOffset9 = currentMainAxisOffset10;
                previousKeyToIndexMap = previousKeyToIndexMap2;
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
    public final long m899getAnimatedOffsetYT5a7pE(Object key, int placeableIndex, int minOffset, int maxOffset, long rawOffset) {
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
        long other$iv = itemInfo.m895getNotAnimatableDeltanOccac();
        long currentValue = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(arg0$iv) + IntOffset.m6104getXimpl(other$iv), IntOffset.m6105getYimpl(arg0$iv) + IntOffset.m6105getYimpl(other$iv));
        long arg0$iv2 = item.m921getTargetOffsetnOccac();
        long other$iv2 = itemInfo.m895getNotAnimatableDeltanOccac();
        long arg0$iv3 = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(arg0$iv2) + IntOffset.m6104getXimpl(other$iv2), IntOffset.m6105getYimpl(arg0$iv2) + IntOffset.m6105getYimpl(other$iv2));
        if (item.getInProgress() && ((m897getMainAxisgyyYBs(arg0$iv3) <= i && m897getMainAxisgyyYBs(currentValue) <= i) || (m897getMainAxisgyyYBs(arg0$iv3) >= i2 && m897getMainAxisgyyYBs(currentValue) >= i2))) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyListItemPlacementAnimator$getAnimatedOffset$1(item, (Continuation<? super LazyListItemPlacementAnimator$getAnimatedOffset$1>) null), 3, (Object) null);
        }
        return currentValue;
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyToIndexMap = MapsKt.emptyMap();
        this.firstVisibleIndex = -1;
    }

    static /* synthetic */ ItemInfo createItemInfo$default(LazyListItemPlacementAnimator lazyListItemPlacementAnimator, LazyListPositionedItem lazyListPositionedItem, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = lazyListItemPlacementAnimator.m897getMainAxisgyyYBs(lazyListPositionedItem.m910getOffsetBjo55l4(0));
        }
        return lazyListItemPlacementAnimator.createItemInfo(lazyListPositionedItem, i);
    }

    private final ItemInfo createItemInfo(LazyListPositionedItem item, int mainAxisOffset) {
        long targetFirstPlaceableOffset;
        LazyListPositionedItem lazyListPositionedItem = item;
        ItemInfo newItemInfo = new ItemInfo();
        int i = 0;
        long firstPlaceableOffset = lazyListPositionedItem.m910getOffsetBjo55l4(0);
        if (this.isVertical) {
            targetFirstPlaceableOffset = IntOffset.m6100copyiSbpLlY$default(firstPlaceableOffset, 0, mainAxisOffset, 1, (Object) null);
        } else {
            targetFirstPlaceableOffset = IntOffset.m6100copyiSbpLlY$default(firstPlaceableOffset, mainAxisOffset, 0, 2, (Object) null);
        }
        int placeablesCount = item.getPlaceablesCount();
        while (i < placeablesCount) {
            int placeableIndex = i;
            long arg0$iv = lazyListPositionedItem.m910getOffsetBjo55l4(placeableIndex);
            long diffToFirstPlaceableOffset = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(arg0$iv) - IntOffset.m6104getXimpl(firstPlaceableOffset), IntOffset.m6105getYimpl(arg0$iv) - IntOffset.m6105getYimpl(firstPlaceableOffset));
            newItemInfo.getPlaceables().add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(targetFirstPlaceableOffset) + IntOffset.m6104getXimpl(diffToFirstPlaceableOffset), IntOffset.m6105getYimpl(targetFirstPlaceableOffset) + IntOffset.m6105getYimpl(diffToFirstPlaceableOffset)), lazyListPositionedItem.getMainAxisSize(placeableIndex), (DefaultConstructorMarker) null));
            i++;
            placeablesCount = placeablesCount;
            targetFirstPlaceableOffset = targetFirstPlaceableOffset;
        }
        return newItemInfo;
    }

    private final void startAnimationsIfNeeded(LazyListPositionedItem item, ItemInfo itemInfo) {
        List $this$fastForEachIndexed$iv;
        Object obj;
        LazyListPositionedItem lazyListPositionedItem = item;
        while (itemInfo.getPlaceables().size() > item.getPlaceablesCount()) {
            CollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (itemInfo.getPlaceables().size() < item.getPlaceablesCount()) {
            int newPlaceableInfoIndex = itemInfo.getPlaceables().size();
            long rawOffset = lazyListPositionedItem.m910getOffsetBjo55l4(newPlaceableInfoIndex);
            List<PlaceableInfo> placeables = itemInfo.getPlaceables();
            long other$iv = itemInfo.m895getNotAnimatableDeltanOccac();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(rawOffset) - IntOffset.m6104getXimpl(other$iv), IntOffset.m6105getYimpl(rawOffset) - IntOffset.m6105getYimpl(other$iv)), lazyListPositionedItem.getMainAxisSize(newPlaceableInfoIndex), (DefaultConstructorMarker) null));
        }
        List $this$fastForEachIndexed$iv2 = itemInfo.getPlaceables();
        int index$iv = 0;
        int size = $this$fastForEachIndexed$iv2.size();
        while (index$iv < size) {
            PlaceableInfo placeableInfo = $this$fastForEachIndexed$iv2.get(index$iv);
            int index = index$iv;
            long arg0$iv = placeableInfo.m921getTargetOffsetnOccac();
            long other$iv2 = itemInfo.m895getNotAnimatableDeltanOccac();
            long arg0$iv2 = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(arg0$iv) + IntOffset.m6104getXimpl(other$iv2), IntOffset.m6105getYimpl(arg0$iv) + IntOffset.m6105getYimpl(other$iv2));
            long currentOffset = lazyListPositionedItem.m910getOffsetBjo55l4(index);
            placeableInfo.setMainAxisSize(lazyListPositionedItem.getMainAxisSize(index));
            FiniteAnimationSpec animationSpec = lazyListPositionedItem.getAnimationSpec(index);
            if (!IntOffset.m6103equalsimpl0(arg0$iv2, currentOffset)) {
                long other$iv3 = itemInfo.m895getNotAnimatableDeltanOccac();
                $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
                placeableInfo.m922setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(currentOffset) - IntOffset.m6104getXimpl(other$iv3), IntOffset.m6105getYimpl(currentOffset) - IntOffset.m6105getYimpl(other$iv3)));
                if (animationSpec != null) {
                    placeableInfo.setInProgress(true);
                    obj = null;
                    Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1(placeableInfo, animationSpec, (Continuation<? super LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1>) null), 3, (Object) null);
                } else {
                    obj = null;
                }
            } else {
                obj = null;
                $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
            }
            index$iv++;
            lazyListPositionedItem = item;
            Object obj2 = obj;
            $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0060 A[LOOP:0: B:1:0x0010->B:10:0x0060, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x006c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean isWithinBounds(androidx.compose.foundation.lazy.ItemInfo r23, int r24) {
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
            androidx.compose.foundation.lazy.PlaceableInfo r11 = (androidx.compose.foundation.lazy.PlaceableInfo) r11
            r12 = 0
            long r13 = r11.m921getTargetOffsetnOccac()
            long r15 = r23.m895getNotAnimatableDeltanOccac()
            r17 = 0
            int r18 = androidx.compose.ui.unit.IntOffset.m6104getXimpl(r13)
            int r19 = androidx.compose.ui.unit.IntOffset.m6104getXimpl(r15)
            int r7 = r18 + r19
            int r18 = androidx.compose.ui.unit.IntOffset.m6105getYimpl(r13)
            int r19 = androidx.compose.ui.unit.IntOffset.m6105getYimpl(r15)
            r21 = r1
            int r1 = r18 + r19
            long r13 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r7, r1)
            int r1 = r0.m897getMainAxisgyyYBs(r13)
            int r7 = r11.getMainAxisSize()
            int r1 = r1 + r7
            r7 = 1
            if (r1 <= 0) goto L_0x0058
            int r1 = r0.m897getMainAxisgyyYBs(r13)
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator.isWithinBounds(androidx.compose.foundation.lazy.ItemInfo, int):boolean");
    }

    /* renamed from: toOffset-Bjo55l4  reason: not valid java name */
    private final long m898toOffsetBjo55l4(int $this$toOffset_u2dBjo55l4) {
        boolean z = this.isVertical;
        int i = 0;
        int i2 = z ? 0 : $this$toOffset_u2dBjo55l4;
        if (z) {
            i = $this$toOffset_u2dBjo55l4;
        }
        return IntOffsetKt.IntOffset(i2, i);
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m897getMainAxisgyyYBs(long $this$mainAxis) {
        return this.isVertical ? IntOffset.m6105getYimpl($this$mainAxis) : IntOffset.m6104getXimpl($this$mainAxis);
    }
}
