package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ LazyGridItemProvider $itemProvider;
    final /* synthetic */ LazyGridItemPlacementAnimator $placementAnimator;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ Function2<Density, Constraints, List<Integer>> $slotSizesSums;
    final /* synthetic */ LazyGridState $state;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridKt$rememberLazyGridMeasurePolicy$1$1(boolean z, PaddingValues paddingValues, boolean z2, LazyGridState lazyGridState, LazyGridItemProvider lazyGridItemProvider, Function2<? super Density, ? super Constraints, ? extends List<Integer>> function2, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator) {
        super(2);
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$state = lazyGridState;
        this.$itemProvider = lazyGridItemProvider;
        this.$slotSizesSums = function2;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$placementAnimator = lazyGridItemPlacementAnimator;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m961invoke0kLqBqw((LazyLayoutMeasureScope) p1, ((Constraints) p2).m5936unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyGridMeasureResult m961invoke0kLqBqw(LazyLayoutMeasureScope $this$null, long containerConstraints) {
        int i;
        int i2;
        int i3;
        float f;
        float f2;
        int i4;
        long j;
        int spaceBetweenLines;
        long visualItemOffset;
        int mainAxisAvailableSize;
        int spaceBetweenLines2;
        int itemsCount;
        int totalHorizontalPadding;
        int totalVerticalPadding;
        LazyMeasuredItemProvider measuredItemProvider;
        final LazyMeasuredLineProvider measuredLineProvider;
        final LazyGridSpanLayoutProvider spanLayoutProvider;
        LazyGridState lazyGridState;
        Snapshot snapshot$iv;
        Snapshot this_$iv$iv;
        Snapshot previous$iv$iv;
        Snapshot previous$iv$iv2;
        int itemsCount2;
        int firstVisibleLineScrollOffset;
        int firstVisibleLineIndex;
        int spaceBetweenLines3;
        int spaceBetweenLines4;
        LazyLayoutMeasureScope lazyLayoutMeasureScope = $this$null;
        long j2 = containerConstraints;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
        CheckScrollableContainerConstraintsKt.m469checkScrollableContainerConstraintsK40F9xA(j2, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        if (this.$isVertical) {
            i = lazyLayoutMeasureScope.m5961roundToPx0680j_4(this.$contentPadding.m771calculateLeftPaddingu2uoSUM($this$null.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope.m5961roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, $this$null.getLayoutDirection()));
        }
        int startPadding = i;
        if (this.$isVertical) {
            i2 = lazyLayoutMeasureScope.m5961roundToPx0680j_4(this.$contentPadding.m772calculateRightPaddingu2uoSUM($this$null.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope.m5961roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, $this$null.getLayoutDirection()));
        }
        int endPadding = i2;
        int topPadding = lazyLayoutMeasureScope.m5961roundToPx0680j_4(this.$contentPadding.m773calculateTopPaddingD9Ej5fM());
        int bottomPadding = lazyLayoutMeasureScope.m5961roundToPx0680j_4(this.$contentPadding.m770calculateBottomPaddingD9Ej5fM());
        int totalVerticalPadding2 = topPadding + bottomPadding;
        int totalHorizontalPadding2 = startPadding + endPadding;
        boolean z = this.$isVertical;
        int totalMainAxisPadding = z ? totalVerticalPadding2 : totalHorizontalPadding2;
        if (z && !this.$reverseLayout) {
            i3 = topPadding;
        } else if (z && this.$reverseLayout) {
            i3 = bottomPadding;
        } else if (z || this.$reverseLayout) {
            i3 = endPadding;
        } else {
            i3 = startPadding;
        }
        int beforeContentPadding = i3;
        int afterContentPadding = totalMainAxisPadding - beforeContentPadding;
        long contentConstraints = ConstraintsKt.m5946offsetNN6EwU(j2, -totalHorizontalPadding2, -totalVerticalPadding2);
        this.$state.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(this.$itemProvider);
        LazyGridSpanLayoutProvider spanLayoutProvider2 = this.$itemProvider.getSpanLayoutProvider();
        List resolvedSlotSizesSums = this.$slotSizesSums.invoke(lazyLayoutMeasureScope, Constraints.m5918boximpl(containerConstraints));
        spanLayoutProvider2.setSlotsPerLine(resolvedSlotSizesSums.size());
        this.$state.setDensity$foundation_release(lazyLayoutMeasureScope);
        this.$state.setSlotsPerLine$foundation_release(resolvedSlotSizesSums.size());
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical != null) {
                f = vertical.m699getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal != null) {
                f = horizontal.m685getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        float spaceBetweenLinesDp = f;
        int spaceBetweenLines5 = lazyLayoutMeasureScope.m5961roundToPx0680j_4(spaceBetweenLinesDp);
        if (this.$isVertical) {
            Arrangement.Horizontal horizontal2 = this.$horizontalArrangement;
            if (horizontal2 != null) {
                f2 = horizontal2.m685getSpacingD9Ej5fM();
            } else {
                f2 = Dp.m5986constructorimpl((float) 0);
            }
        } else {
            Arrangement.Vertical vertical2 = this.$verticalArrangement;
            if (vertical2 != null) {
                f2 = vertical2.m699getSpacingD9Ej5fM();
            } else {
                f2 = Dp.m5986constructorimpl((float) 0);
            }
        }
        float spaceBetweenSlotsDp = f2;
        int spaceBetweenSlots = lazyLayoutMeasureScope.m5961roundToPx0680j_4(spaceBetweenSlotsDp);
        int itemsCount3 = this.$itemProvider.getItemCount();
        if (this.$isVertical) {
            i4 = Constraints.m5929getMaxHeightimpl(containerConstraints) - totalVerticalPadding2;
        } else {
            i4 = Constraints.m5930getMaxWidthimpl(containerConstraints) - totalHorizontalPadding2;
        }
        int mainAxisAvailableSize2 = i4;
        if (!this.$reverseLayout) {
            spaceBetweenLines3 = spaceBetweenLines5;
        } else if (mainAxisAvailableSize2 > 0) {
            spaceBetweenLines3 = spaceBetweenLines5;
        } else {
            boolean z2 = this.$isVertical;
            if (z2) {
                spaceBetweenLines = spaceBetweenLines5;
                spaceBetweenLines4 = startPadding;
            } else {
                spaceBetweenLines = spaceBetweenLines5;
                spaceBetweenLines4 = startPadding + mainAxisAvailableSize2;
            }
            j = IntOffsetKt.IntOffset(spaceBetweenLines4, z2 ? topPadding + mainAxisAvailableSize2 : topPadding);
            float f3 = spaceBetweenSlotsDp;
            visualItemOffset = j;
            int i5 = startPadding;
            mainAxisAvailableSize = mainAxisAvailableSize2;
            int i6 = endPadding;
            spaceBetweenLines2 = spaceBetweenLines;
            int spaceBetweenSlots2 = spaceBetweenSlots;
            float f4 = spaceBetweenLinesDp;
            itemsCount = itemsCount3;
            List resolvedSlotSizesSums2 = resolvedSlotSizesSums;
            LazyGridSpanLayoutProvider spanLayoutProvider3 = spanLayoutProvider2;
            totalHorizontalPadding = totalHorizontalPadding2;
            totalVerticalPadding = totalVerticalPadding2;
            int i7 = topPadding;
            measuredItemProvider = new LazyMeasuredItemProvider(this.$itemProvider, lazyLayoutMeasureScope, spaceBetweenLines2, new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1($this$null, this.$isVertical, this.$reverseLayout, beforeContentPadding, afterContentPadding, this.$placementAnimator, visualItemOffset));
            measuredLineProvider = new LazyMeasuredLineProvider(this.$isVertical, resolvedSlotSizesSums2, spaceBetweenSlots2, itemsCount, spaceBetweenLines2, measuredItemProvider, spanLayoutProvider3, new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1(this.$isVertical, resolvedSlotSizesSums2, lazyLayoutMeasureScope, spaceBetweenSlots2));
            spanLayoutProvider = spanLayoutProvider3;
            this.$state.setPrefetchInfoRetriever$foundation_release(new Function1<LineIndex, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return m962invokebKFJvoY(((LineIndex) p1).m998unboximpl());
                }

                /* renamed from: invoke-bKFJvoY  reason: not valid java name */
                public final ArrayList<Pair<Integer, Constraints>> m962invokebKFJvoY(int line) {
                    LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = spanLayoutProvider.getLineConfiguration(line);
                    int index = ItemIndex.m934constructorimpl(lineConfiguration.getFirstItemIndex());
                    int slot = 0;
                    ArrayList result = new ArrayList(lineConfiguration.getSpans().size());
                    List $this$fastForEach$iv = lineConfiguration.getSpans();
                    LazyMeasuredLineProvider lazyMeasuredLineProvider = measuredLineProvider;
                    int index$iv = 0;
                    int size = $this$fastForEach$iv.size();
                    while (index$iv < size) {
                        int span = GridItemSpan.m928getCurrentLineSpanimpl($this$fastForEach$iv.get(index$iv).m931unboximpl());
                        result.add(TuplesKt.to(Integer.valueOf(index), Constraints.m5918boximpl(lazyMeasuredLineProvider.m983childConstraintsJhjzzOo$foundation_release(slot, span))));
                        index = ItemIndex.m934constructorimpl(index + 1);
                        slot += span;
                        index$iv++;
                        lineConfiguration = lineConfiguration;
                    }
                    return result;
                }
            });
            Snapshot.Companion this_$iv = Snapshot.Companion;
            lazyGridState = this.$state;
            snapshot$iv = this_$iv.createNonObservableSnapshot();
            this_$iv$iv = snapshot$iv;
            previous$iv$iv = this_$iv$iv.makeCurrent();
            long j3 = visualItemOffset;
            itemsCount2 = itemsCount;
            if (lazyGridState.getFirstVisibleItemIndex() >= itemsCount2 || itemsCount2 <= 0) {
                int firstVisibleLineIndex2 = spanLayoutProvider.m979getLineIndexOfItem_Ze7BM(lazyGridState.getFirstVisibleItemIndex());
                firstVisibleLineScrollOffset = lazyGridState.getFirstVisibleItemScrollOffset();
                firstVisibleLineIndex = firstVisibleLineIndex2;
            } else {
                try {
                    firstVisibleLineIndex = spanLayoutProvider.m979getLineIndexOfItem_Ze7BM(itemsCount2 - 1);
                    firstVisibleLineScrollOffset = 0;
                } catch (Throwable th) {
                    th = th;
                    previous$iv$iv2 = previous$iv$iv;
                    try {
                        this_$iv$iv.restoreCurrent(previous$iv$iv2);
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                        snapshot$iv.dispose();
                        throw th;
                    }
                }
            }
            try {
                Unit unit = Unit.INSTANCE;
                try {
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    snapshot$iv.dispose();
                    final LazyLayoutMeasureScope lazyLayoutMeasureScope2 = $this$null;
                    final long j4 = containerConstraints;
                    final int i8 = totalHorizontalPadding;
                    final int i9 = totalVerticalPadding;
                    LazyGridMeasureResult it = LazyGridMeasureKt.m966measureLazyGridt5wl_D8(itemsCount2, this.$itemProvider, measuredLineProvider, measuredItemProvider, mainAxisAvailableSize, beforeContentPadding, afterContentPadding, spaceBetweenLines2, firstVisibleLineIndex, firstVisibleLineScrollOffset, this.$state.getScrollToBeConsumed$foundation_release(), contentConstraints, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope, this.$placementAnimator, spanLayoutProvider, this.$state.getPinnedItems$foundation_release(), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                            return invoke(((Number) p1).intValue(), ((Number) p2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) p3);
                        }

                        public final MeasureResult invoke(int width, int height, Function1<? super Placeable.PlacementScope, Unit> placement) {
                            Intrinsics.checkNotNullParameter(placement, "placement");
                            return lazyLayoutMeasureScope2.layout(ConstraintsKt.m5944constrainWidthK40F9xA(j4, i8 + width), ConstraintsKt.m5943constrainHeightK40F9xA(j4, i9 + height), MapsKt.emptyMap(), placement);
                        }
                    });
                    this.$state.applyMeasureResult$foundation_release(it);
                    return it;
                } catch (Throwable th3) {
                    th = th3;
                    int i10 = firstVisibleLineIndex;
                    int i11 = firstVisibleLineScrollOffset;
                    snapshot$iv.dispose();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                int i12 = firstVisibleLineScrollOffset;
                int i13 = firstVisibleLineIndex;
                previous$iv$iv2 = previous$iv$iv;
                int i14 = i13;
                this_$iv$iv.restoreCurrent(previous$iv$iv2);
                throw th;
            }
        }
        j = IntOffsetKt.IntOffset(startPadding, topPadding);
        float f32 = spaceBetweenSlotsDp;
        visualItemOffset = j;
        int i52 = startPadding;
        mainAxisAvailableSize = mainAxisAvailableSize2;
        int i62 = endPadding;
        spaceBetweenLines2 = spaceBetweenLines;
        int spaceBetweenSlots22 = spaceBetweenSlots;
        float f42 = spaceBetweenLinesDp;
        itemsCount = itemsCount3;
        List resolvedSlotSizesSums22 = resolvedSlotSizesSums;
        LazyGridSpanLayoutProvider spanLayoutProvider32 = spanLayoutProvider2;
        totalHorizontalPadding = totalHorizontalPadding2;
        totalVerticalPadding = totalVerticalPadding2;
        int i72 = topPadding;
        measuredItemProvider = new LazyMeasuredItemProvider(this.$itemProvider, lazyLayoutMeasureScope, spaceBetweenLines2, new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1($this$null, this.$isVertical, this.$reverseLayout, beforeContentPadding, afterContentPadding, this.$placementAnimator, visualItemOffset));
        measuredLineProvider = new LazyMeasuredLineProvider(this.$isVertical, resolvedSlotSizesSums22, spaceBetweenSlots22, itemsCount, spaceBetweenLines2, measuredItemProvider, spanLayoutProvider32, new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1(this.$isVertical, resolvedSlotSizesSums22, lazyLayoutMeasureScope, spaceBetweenSlots22));
        spanLayoutProvider = spanLayoutProvider32;
        this.$state.setPrefetchInfoRetriever$foundation_release(new Function1<LineIndex, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m962invokebKFJvoY(((LineIndex) p1).m998unboximpl());
            }

            /* renamed from: invoke-bKFJvoY  reason: not valid java name */
            public final ArrayList<Pair<Integer, Constraints>> m962invokebKFJvoY(int line) {
                LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = spanLayoutProvider.getLineConfiguration(line);
                int index = ItemIndex.m934constructorimpl(lineConfiguration.getFirstItemIndex());
                int slot = 0;
                ArrayList result = new ArrayList(lineConfiguration.getSpans().size());
                List $this$fastForEach$iv = lineConfiguration.getSpans();
                LazyMeasuredLineProvider lazyMeasuredLineProvider = measuredLineProvider;
                int index$iv = 0;
                int size = $this$fastForEach$iv.size();
                while (index$iv < size) {
                    int span = GridItemSpan.m928getCurrentLineSpanimpl($this$fastForEach$iv.get(index$iv).m931unboximpl());
                    result.add(TuplesKt.to(Integer.valueOf(index), Constraints.m5918boximpl(lazyMeasuredLineProvider.m983childConstraintsJhjzzOo$foundation_release(slot, span))));
                    index = ItemIndex.m934constructorimpl(index + 1);
                    slot += span;
                    index$iv++;
                    lineConfiguration = lineConfiguration;
                }
                return result;
            }
        });
        Snapshot.Companion this_$iv2 = Snapshot.Companion;
        lazyGridState = this.$state;
        snapshot$iv = this_$iv2.createNonObservableSnapshot();
        this_$iv$iv = snapshot$iv;
        try {
            previous$iv$iv = this_$iv$iv.makeCurrent();
            try {
                long j32 = visualItemOffset;
                itemsCount2 = itemsCount;
                if (lazyGridState.getFirstVisibleItemIndex() >= itemsCount2) {
                }
                try {
                    int firstVisibleLineIndex22 = spanLayoutProvider.m979getLineIndexOfItem_Ze7BM(lazyGridState.getFirstVisibleItemIndex());
                } catch (Throwable th5) {
                    th = th5;
                    previous$iv$iv2 = previous$iv$iv;
                    this_$iv$iv.restoreCurrent(previous$iv$iv2);
                    throw th;
                }
                try {
                    firstVisibleLineScrollOffset = lazyGridState.getFirstVisibleItemScrollOffset();
                    firstVisibleLineIndex = firstVisibleLineIndex22;
                    Unit unit2 = Unit.INSTANCE;
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    snapshot$iv.dispose();
                    final LazyLayoutMeasureScope lazyLayoutMeasureScope22 = $this$null;
                    final long j42 = containerConstraints;
                    final int i82 = totalHorizontalPadding;
                    final int i92 = totalVerticalPadding;
                    LazyGridMeasureResult it2 = LazyGridMeasureKt.m966measureLazyGridt5wl_D8(itemsCount2, this.$itemProvider, measuredLineProvider, measuredItemProvider, mainAxisAvailableSize, beforeContentPadding, afterContentPadding, spaceBetweenLines2, firstVisibleLineIndex, firstVisibleLineScrollOffset, this.$state.getScrollToBeConsumed$foundation_release(), contentConstraints, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope, this.$placementAnimator, spanLayoutProvider, this.$state.getPinnedItems$foundation_release(), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                            return invoke(((Number) p1).intValue(), ((Number) p2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) p3);
                        }

                        public final MeasureResult invoke(int width, int height, Function1<? super Placeable.PlacementScope, Unit> placement) {
                            Intrinsics.checkNotNullParameter(placement, "placement");
                            return lazyLayoutMeasureScope22.layout(ConstraintsKt.m5944constrainWidthK40F9xA(j42, i82 + width), ConstraintsKt.m5943constrainHeightK40F9xA(j42, i92 + height), MapsKt.emptyMap(), placement);
                        }
                    });
                    this.$state.applyMeasureResult$foundation_release(it2);
                    return it2;
                } catch (Throwable th6) {
                    th = th6;
                    previous$iv$iv2 = previous$iv$iv;
                    this_$iv$iv.restoreCurrent(previous$iv$iv2);
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                long j5 = visualItemOffset;
                previous$iv$iv2 = previous$iv$iv;
                int i15 = itemsCount;
                this_$iv$iv.restoreCurrent(previous$iv$iv2);
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            long j6 = visualItemOffset;
            int i16 = itemsCount;
            snapshot$iv.dispose();
            throw th;
        }
    }
}
