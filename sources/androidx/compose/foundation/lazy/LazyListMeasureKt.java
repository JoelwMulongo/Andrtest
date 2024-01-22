package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0002\u001aL\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'H\u0002\u001aS\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,\u001aø\u0001\u0010-\u001a\u00020.2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020!2\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\u00022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u0010\u0014\u001a\u00020\u00042\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020;2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'2/\u0010<\u001a+\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020@0>¢\u0006\u0002\bA\u0012\u0004\u0012\u00020B0=H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010D\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006E"}, d2 = {"EmptyRange", "Lkotlin/Pair;", "", "notInEmptyRange", "", "getNotInEmptyRange", "(I)Z", "calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "items", "", "Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "isVertical", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "createItemsAfterList", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "visibleItems", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "itemsCount", "beyondBoundsItemCount", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "createItemsBeforeList", "currentFirstItemIndex", "Landroidx/compose/foundation/lazy/DataIndex;", "createItemsBeforeList-tv8sHfA", "(Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;ILandroidx/compose/foundation/lazy/LazyMeasuredItemProvider;Landroidx/compose/foundation/lazy/LazyListItemProvider;IILandroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;)Ljava/util/List;", "measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "headerIndexes", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-Hh3qtAg", "(ILandroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;IIIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;ILandroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListMeasure.kt */
public final class LazyListMeasureKt {
    private static final Pair<Integer, Integer> EmptyRange = TuplesKt.to(Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v55, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v8, resolved type: androidx.compose.foundation.lazy.LazyMeasuredItem} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measureLazyList-Hh3qtAg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.lazy.LazyListMeasureResult m906measureLazyListHh3qtAg(int r48, androidx.compose.foundation.lazy.LazyListItemProvider r49, androidx.compose.foundation.lazy.LazyMeasuredItemProvider r50, int r51, int r52, int r53, int r54, int r55, int r56, float r57, long r58, boolean r60, java.util.List<java.lang.Integer> r61, androidx.compose.foundation.layout.Arrangement.Vertical r62, androidx.compose.foundation.layout.Arrangement.Horizontal r63, boolean r64, androidx.compose.ui.unit.Density r65, androidx.compose.foundation.lazy.LazyListItemPlacementAnimator r66, androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo r67, int r68, androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList r69, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>, ? extends androidx.compose.ui.layout.MeasureResult> r70) {
        /*
            r14 = r48
            r15 = r50
            r13 = r52
            r11 = r58
            r10 = r61
            r9 = r70
            java.lang.String r0 = "itemProvider"
            r8 = r49
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "measuredItemProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "headerIndexes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "density"
            r7 = r65
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "placementAnimator"
            r6 = r66
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "beyondBoundsInfo"
            r5 = r67
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "pinnedItems"
            r4 = r69
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "layout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r3 = 0
            r29 = 1
            if (r13 < 0) goto L_0x004c
            r0 = r29
            goto L_0x004d
        L_0x004c:
            r0 = r3
        L_0x004d:
            java.lang.String r1 = "Failed requirement."
            if (r0 == 0) goto L_0x04d1
            if (r53 < 0) goto L_0x0056
            r0 = r29
            goto L_0x0057
        L_0x0056:
            r0 = r3
        L_0x0057:
            if (r0 == 0) goto L_0x04c7
            if (r14 > 0) goto L_0x00a2
            androidx.compose.foundation.lazy.LazyListMeasureResult r0 = new androidx.compose.foundation.lazy.LazyListMeasureResult
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            int r1 = androidx.compose.ui.unit.Constraints.m5932getMinWidthimpl(r58)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r2 = androidx.compose.ui.unit.Constraints.m5931getMinHeightimpl(r58)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$1 r3 = androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$1.INSTANCE
            java.lang.Object r1 = r9.invoke(r1, r2, r3)
            r21 = r1
            androidx.compose.ui.layout.MeasureResult r21 = (androidx.compose.ui.layout.MeasureResult) r21
            java.util.List r22 = kotlin.collections.CollectionsKt.emptyList()
            int r1 = -r13
            int r24 = r51 + r53
            r25 = 0
            if (r60 == 0) goto L_0x008e
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x0090
        L_0x008e:
            androidx.compose.foundation.gestures.Orientation r2 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x0090:
            r27 = r2
            r16 = r0
            r23 = r1
            r26 = r64
            r28 = r53
            r29 = r54
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return r0
        L_0x00a2:
            r0 = r55
            r2 = r56
            if (r0 < r14) goto L_0x00af
            int r16 = r14 + -1
            int r0 = androidx.compose.foundation.lazy.DataIndex.m883constructorimpl(r16)
            r2 = 0
        L_0x00af:
            int r16 = kotlin.math.MathKt.roundToInt((float) r57)
            int r2 = r2 - r16
            int r4 = androidx.compose.foundation.lazy.DataIndex.m883constructorimpl(r3)
            boolean r4 = androidx.compose.foundation.lazy.DataIndex.m886equalsimpl0(r0, r4)
            if (r4 == 0) goto L_0x00c4
            if (r2 >= 0) goto L_0x00c4
            int r16 = r16 + r2
            r2 = 0
        L_0x00c4:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
            int r3 = -r13
            if (r54 >= 0) goto L_0x00d1
            r18 = r54
            goto L_0x00d3
        L_0x00d1:
            r18 = 0
        L_0x00d3:
            int r3 = r3 + r18
            r30 = r51
            int r2 = r2 + r3
            r18 = 0
            r5 = r18
        L_0x00dc:
            if (r2 >= 0) goto L_0x010d
            r17 = 0
            int r18 = androidx.compose.foundation.lazy.DataIndex.m883constructorimpl(r17)
            r19 = 0
            int r18 = r0 - r18
            if (r18 <= 0) goto L_0x010d
            int r18 = r0 + -1
            int r6 = androidx.compose.foundation.lazy.DataIndex.m883constructorimpl(r18)
            androidx.compose.foundation.lazy.LazyMeasuredItem r7 = r15.m917getAndMeasureZjPyQlc(r6)
            r8 = 0
            r4.add(r8, r7)
            int r8 = r7.getCrossAxisSize()
            int r5 = java.lang.Math.max(r5, r8)
            int r8 = r7.getSizeWithSpacings()
            int r2 = r2 + r8
            r0 = r6
            r8 = r49
            r7 = r65
            r6 = r66
            goto L_0x00dc
        L_0x010d:
            if (r2 >= r3) goto L_0x0112
            int r16 = r16 + r2
            r2 = r3
        L_0x0112:
            int r2 = r2 - r3
            r6 = 0
            r6 = r0
            r8 = r30
            int r7 = r8 + r53
            r18 = r0
            r0 = 0
            int r7 = kotlin.ranges.RangesKt.coerceAtLeast((int) r7, (int) r0)
            r0 = 0
            int r0 = -r2
            r19 = r4
            r20 = 0
            r21 = 0
            r22 = r0
            int r0 = r19.size()
            r47 = r21
            r21 = r2
            r2 = r47
        L_0x0135:
            if (r2 >= r0) goto L_0x015e
            r23 = r0
            r0 = r19
            java.lang.Object r19 = r0.get(r2)
            r24 = r19
            androidx.compose.foundation.lazy.LazyMeasuredItem r24 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r24
            r25 = 0
            r26 = 0
            int r27 = r6 + 1
            int r26 = androidx.compose.foundation.lazy.DataIndex.m883constructorimpl(r27)
            r6 = r26
            int r26 = r24.getSizeWithSpacings()
            int r22 = r22 + r26
            int r2 = r2 + 1
            r19 = r0
            r0 = r23
            goto L_0x0135
        L_0x015e:
            r0 = r19
            r2 = r21
            r0 = r22
        L_0x0164:
            if (r6 >= r14) goto L_0x01b8
            if (r0 < r7) goto L_0x0174
            if (r0 <= 0) goto L_0x0174
            boolean r19 = r4.isEmpty()
            if (r19 == 0) goto L_0x0171
            goto L_0x0174
        L_0x0171:
            r30 = r7
            goto L_0x01ba
        L_0x0174:
            r30 = r7
            androidx.compose.foundation.lazy.LazyMeasuredItem r7 = r15.m917getAndMeasureZjPyQlc(r6)
            int r19 = r7.getSizeWithSpacings()
            int r0 = r0 + r19
            if (r0 > r3) goto L_0x019d
            r19 = r0
            int r0 = r14 + -1
            if (r6 == r0) goto L_0x019f
            r0 = 1
            r20 = r6
            r21 = 0
            int r22 = r20 + r0
            int r0 = androidx.compose.foundation.lazy.DataIndex.m883constructorimpl(r22)
            int r18 = r7.getSizeWithSpacings()
            int r2 = r2 - r18
            r18 = r0
            goto L_0x01ab
        L_0x019d:
            r19 = r0
        L_0x019f:
            int r0 = r7.getCrossAxisSize()
            int r0 = java.lang.Math.max(r5, r0)
            r4.add(r7)
            r5 = r0
        L_0x01ab:
            r0 = 0
            int r20 = r6 + 1
            int r0 = androidx.compose.foundation.lazy.DataIndex.m883constructorimpl(r20)
            r6 = r0
            r0 = r19
            r7 = r30
            goto L_0x0164
        L_0x01b8:
            r30 = r7
        L_0x01ba:
            if (r0 >= r8) goto L_0x0217
            int r7 = r8 - r0
            int r2 = r2 - r7
            int r0 = r0 + r7
        L_0x01c0:
            if (r2 >= r13) goto L_0x01fb
            r17 = 0
            int r19 = androidx.compose.foundation.lazy.DataIndex.m883constructorimpl(r17)
            r20 = 0
            int r19 = r18 - r19
            if (r19 <= 0) goto L_0x01f6
            int r19 = r18 + -1
            r20 = r3
            int r3 = androidx.compose.foundation.lazy.DataIndex.m883constructorimpl(r19)
            r19 = r6
            androidx.compose.foundation.lazy.LazyMeasuredItem r6 = r15.m917getAndMeasureZjPyQlc(r3)
            r15 = 0
            r4.add(r15, r6)
            int r15 = r6.getCrossAxisSize()
            int r5 = java.lang.Math.max(r5, r15)
            int r15 = r6.getSizeWithSpacings()
            int r2 = r2 + r15
            r18 = r3
            r15 = r50
            r6 = r19
            r3 = r20
            goto L_0x01c0
        L_0x01f6:
            r20 = r3
            r19 = r6
            goto L_0x01ff
        L_0x01fb:
            r20 = r3
            r19 = r6
        L_0x01ff:
            int r16 = r16 + r7
            if (r2 >= 0) goto L_0x020f
            int r16 = r16 + r2
            int r0 = r0 + r2
            r2 = 0
            r7 = r0
            r6 = r16
            r15 = r18
            r16 = r5
            goto L_0x0222
        L_0x020f:
            r7 = r0
            r6 = r16
            r15 = r18
            r16 = r5
            goto L_0x0222
        L_0x0217:
            r20 = r3
            r19 = r6
            r7 = r0
            r6 = r16
            r15 = r18
            r16 = r5
        L_0x0222:
            int r0 = kotlin.math.MathKt.roundToInt((float) r57)
            int r0 = kotlin.math.MathKt.getSign((int) r0)
            int r3 = kotlin.math.MathKt.getSign((int) r6)
            if (r0 != r3) goto L_0x0240
            int r0 = kotlin.math.MathKt.roundToInt((float) r57)
            int r0 = java.lang.Math.abs(r0)
            int r3 = java.lang.Math.abs(r6)
            if (r0 < r3) goto L_0x0240
            float r0 = (float) r6
            goto L_0x0242
        L_0x0240:
            r0 = r57
        L_0x0242:
            r5 = r0
            if (r2 < 0) goto L_0x0248
            r0 = r29
            goto L_0x0249
        L_0x0248:
            r0 = 0
        L_0x0249:
            if (r0 == 0) goto L_0x04bd
            int r3 = -r2
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r4)
            androidx.compose.foundation.lazy.LazyMeasuredItem r0 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r0
            if (r13 > 0) goto L_0x025d
            if (r54 >= 0) goto L_0x0257
            goto L_0x025d
        L_0x0257:
            r31 = r2
            r21 = r3
            r3 = r0
            goto L_0x0299
        L_0x025d:
            r1 = 0
            r18 = r0
            int r0 = r4.size()
        L_0x0264:
            if (r1 >= r0) goto L_0x0293
            java.lang.Object r21 = r4.get(r1)
            androidx.compose.foundation.lazy.LazyMeasuredItem r21 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r21
            r22 = r0
            int r0 = r21.getSizeWithSpacings()
            if (r2 == 0) goto L_0x0290
            if (r0 > r2) goto L_0x0290
            r21 = r3
            int r3 = kotlin.collections.CollectionsKt.getLastIndex(r4)
            if (r1 == r3) goto L_0x0292
            int r2 = r2 - r0
            int r3 = r1 + 1
            java.lang.Object r3 = r4.get(r3)
            r18 = r3
            androidx.compose.foundation.lazy.LazyMeasuredItem r18 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r18
            int r1 = r1 + 1
            r3 = r21
            r0 = r22
            goto L_0x0264
        L_0x0290:
            r21 = r3
        L_0x0292:
            goto L_0x0295
        L_0x0293:
            r21 = r3
        L_0x0295:
            r31 = r2
            r3 = r18
        L_0x0299:
            r0 = r67
            r1 = r15
            r2 = r50
            r35 = r15
            r33 = r20
            r34 = r21
            r32 = 0
            r15 = r3
            r3 = r49
            r36 = r4
            r4 = r48
            r13 = r5
            r5 = r68
            r37 = r6
            r9 = r19
            r6 = r69
            java.util.List r38 = m905createItemsBeforeListtv8sHfA(r0, r1, r2, r3, r4, r5, r6)
            r0 = r38
            r1 = 0
            r2 = 0
            int r3 = r0.size()
            r6 = r16
        L_0x02cc:
            if (r2 >= r3) goto L_0x02e8
            java.lang.Object r4 = r0.get(r2)
            r5 = r4
            androidx.compose.foundation.lazy.LazyMeasuredItem r5 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r5
            r16 = 0
            r17 = r0
            int r0 = r5.getCrossAxisSize()
            int r6 = java.lang.Math.max(r6, r0)
            int r2 = r2 + 1
            r0 = r17
            goto L_0x02cc
        L_0x02e8:
            r17 = r0
            r0 = r67
            r1 = r36
            r2 = r50
            r3 = r49
            r4 = r48
            r5 = r68
            r16 = r6
            r6 = r69
            java.util.List r39 = createItemsAfterList(r0, r1, r2, r3, r4, r5, r6)
            r0 = r39
            r1 = 0
            r2 = 0
            int r3 = r0.size()
            r6 = r16
        L_0x0311:
            if (r2 >= r3) goto L_0x032d
            java.lang.Object r4 = r0.get(r2)
            r5 = r4
            androidx.compose.foundation.lazy.LazyMeasuredItem r5 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r5
            r16 = 0
            r17 = r0
            int r0 = r5.getCrossAxisSize()
            int r6 = java.lang.Math.max(r6, r0)
            int r2 = r2 + 1
            r0 = r17
            goto L_0x0311
        L_0x032d:
            r17 = r0
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r36)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0349
            boolean r0 = r38.isEmpty()
            if (r0 == 0) goto L_0x0349
            boolean r0 = r39.isEmpty()
            if (r0 == 0) goto L_0x0349
            r3 = r29
            goto L_0x034b
        L_0x0349:
            r3 = r32
        L_0x034b:
            r40 = r3
            if (r60 == 0) goto L_0x0351
            r0 = r6
            goto L_0x0352
        L_0x0351:
            r0 = r7
        L_0x0352:
            int r19 = androidx.compose.ui.unit.ConstraintsKt.m5944constrainWidthK40F9xA(r11, r0)
            if (r60 == 0) goto L_0x035b
            r0 = r7
            goto L_0x035c
        L_0x035b:
            r0 = r6
        L_0x035c:
            int r20 = androidx.compose.ui.unit.ConstraintsKt.m5943constrainHeightK40F9xA(r11, r0)
            r16 = r36
            r17 = r38
            r18 = r39
            r21 = r7
            r22 = r8
            r23 = r34
            r24 = r60
            r25 = r62
            r26 = r63
            r27 = r64
            r28 = r65
            java.util.List r5 = calculateItemsOffsets(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            int r1 = (int) r13
            r0 = r66
            r2 = r19
            r3 = r20
            r4 = r5
            r16 = r5
            r5 = r50
            r0.onMeasured(r1, r2, r3, r4, r5)
            r0 = r10
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x03be
            r0 = r16
            r1 = r50
            r2 = r61
            r3 = r52
            r4 = r19
            r5 = r20
            androidx.compose.foundation.lazy.LazyListPositionedItem r0 = androidx.compose.foundation.lazy.LazyListHeadersKt.findOrComposeLazyListHeader(r0, r1, r2, r3, r4, r5)
            goto L_0x03bf
        L_0x03be:
            r0 = 0
        L_0x03bf:
            r5 = r0
            if (r9 < r14) goto L_0x03ca
            if (r7 <= r8) goto L_0x03c7
            goto L_0x03ca
        L_0x03c7:
            r3 = r32
            goto L_0x03cc
        L_0x03ca:
            r3 = r29
        L_0x03cc:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r19)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r20)
            androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$5 r2 = new androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$5
            r4 = r16
            r2.<init>(r4, r5)
            r17 = r9
            r9 = r70
            java.lang.Object r0 = r9.invoke(r0, r1, r2)
            r16 = r0
            androidx.compose.ui.layout.MeasureResult r16 = (androidx.compose.ui.layout.MeasureResult) r16
            r18 = r13
            r13 = r52
            int r2 = -r13
            int r21 = r8 + r53
            if (r40 == 0) goto L_0x03fc
            r23 = r2
            r27 = r4
            r44 = r6
            r46 = r7
            r6 = r27
            goto L_0x047d
        L_0x03fc:
            r0 = r4
            r1 = 0
            r22 = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r23 = r2
            int r2 = r0.size()
            r1.<init>(r2)
            r2 = r0
            r24 = 0
            r25 = 0
            r26 = r0
            int r0 = r2.size()
            r27 = r4
            r4 = r25
        L_0x041c:
            if (r4 >= r0) goto L_0x0472
            java.lang.Object r25 = r2.get(r4)
            r28 = r25
            r41 = 0
            r42 = r0
            r0 = r28
            r28 = r2
            r2 = r0
            androidx.compose.foundation.lazy.LazyListPositionedItem r2 = (androidx.compose.foundation.lazy.LazyListPositionedItem) r2
            r43 = 0
            r44 = r6
            int r6 = r2.getIndex()
            java.lang.Object r45 = kotlin.collections.CollectionsKt.first(r36)
            androidx.compose.foundation.lazy.LazyMeasuredItem r45 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r45
            r46 = r7
            int r7 = r45.getIndex()
            if (r6 < r7) goto L_0x0455
            int r6 = r2.getIndex()
            java.lang.Object r7 = kotlin.collections.CollectionsKt.last(r36)
            androidx.compose.foundation.lazy.LazyMeasuredItem r7 = (androidx.compose.foundation.lazy.LazyMeasuredItem) r7
            int r7 = r7.getIndex()
            if (r6 <= r7) goto L_0x0457
        L_0x0455:
            if (r2 != r5) goto L_0x045a
        L_0x0457:
            r6 = r29
            goto L_0x045c
        L_0x045a:
            r6 = r32
        L_0x045c:
            if (r6 == 0) goto L_0x0465
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            r2.add(r0)
        L_0x0465:
            int r4 = r4 + 1
            r2 = r28
            r0 = r42
            r6 = r44
            r7 = r46
            goto L_0x041c
        L_0x0472:
            r28 = r2
            r44 = r6
            r46 = r7
            r0 = r1
            java.util.List r0 = (java.util.List) r0
            r6 = r0
        L_0x047d:
            if (r60 == 0) goto L_0x0483
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x0485
        L_0x0483:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x0485:
            r22 = r0
            androidx.compose.foundation.lazy.LazyListMeasureResult r24 = new androidx.compose.foundation.lazy.LazyListMeasureResult
            r0 = r24
            r1 = r15
            r7 = r23
            r2 = r31
            r23 = r27
            r4 = r18
            r25 = r5
            r5 = r16
            r16 = r44
            r26 = r30
            r27 = r46
            r28 = r8
            r8 = r21
            r9 = r48
            r10 = r64
            r11 = r22
            r12 = r53
            r13 = r54
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r24
        L_0x04bd:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x04c7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x04d1:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListMeasureKt.m906measureLazyListHh3qtAg(int, androidx.compose.foundation.lazy.LazyListItemProvider, androidx.compose.foundation.lazy.LazyMeasuredItemProvider, int, int, int, int, int, int, float, long, boolean, java.util.List, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.LazyListItemPlacementAnimator, androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo, int, androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.LazyListMeasureResult");
    }

    private static final int createItemsAfterList$endIndex(LazyListBeyondBoundsInfo $this$createItemsAfterList_u24endIndex, int $itemsCount) {
        return Math.min($this$createItemsAfterList_u24endIndex.getEnd(), $itemsCount - 1);
    }

    private static final List<LazyMeasuredItem> createItemsAfterList(LazyListBeyondBoundsInfo beyondBoundsInfo, List<LazyMeasuredItem> visibleItems, LazyMeasuredItemProvider measuredItemProvider, LazyListItemProvider itemProvider, int itemsCount, int beyondBoundsItemCount, LazyLayoutPinnedItemList pinnedItems) {
        LazyMeasuredItemProvider lazyMeasuredItemProvider = measuredItemProvider;
        int i = itemsCount;
        Ref.ObjectRef list = new Ref.ObjectRef();
        int end = ((LazyMeasuredItem) CollectionsKt.last(visibleItems)).getIndex();
        if (beyondBoundsInfo.hasIntervals()) {
            LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo = beyondBoundsInfo;
            end = Math.max(createItemsAfterList$endIndex(beyondBoundsInfo, i), end);
        } else {
            LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo2 = beyondBoundsInfo;
        }
        int end2 = Math.min(end + beyondBoundsItemCount, i - 1);
        int i2 = ((LazyMeasuredItem) CollectionsKt.last(visibleItems)).getIndex() + 1;
        if (i2 <= end2) {
            while (true) {
                createItemsAfterList$addItem(list, lazyMeasuredItemProvider, i2);
                if (i2 == end2) {
                    break;
                }
                i2++;
            }
        }
        List $this$fastForEach$iv = pinnedItems;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            LazyLayoutPinnedItemList.PinnedItem item = (LazyLayoutPinnedItemList.PinnedItem) $this$fastForEach$iv.get(index$iv);
            int index = LazyLayoutItemProviderKt.findIndexByKey(itemProvider, item.getKey(), item.getIndex());
            if (index > end2 && index < i) {
                createItemsAfterList$addItem(list, lazyMeasuredItemProvider, index);
            }
        }
        List<LazyMeasuredItem> list2 = list.element;
        return list2 == null ? CollectionsKt.emptyList() : list2;
    }

    private static final void createItemsAfterList$addItem(Ref.ObjectRef<List<LazyMeasuredItem>> list, LazyMeasuredItemProvider $measuredItemProvider, int index) {
        if (list.element == null) {
            list.element = (List) new ArrayList();
        }
        T t = list.element;
        if (t != null) {
            ((List) t).add($measuredItemProvider.m917getAndMeasureZjPyQlc(DataIndex.m883constructorimpl(index)));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private static final int createItemsBeforeList_tv8sHfA$startIndex(LazyListBeyondBoundsInfo $this$createItemsBeforeList_tv8sHfA_u24startIndex, int $itemsCount) {
        return Math.min($this$createItemsBeforeList_tv8sHfA_u24startIndex.getStart(), $itemsCount - 1);
    }

    /* renamed from: createItemsBeforeList-tv8sHfA  reason: not valid java name */
    private static final List<LazyMeasuredItem> m905createItemsBeforeListtv8sHfA(LazyListBeyondBoundsInfo beyondBoundsInfo, int currentFirstItemIndex, LazyMeasuredItemProvider measuredItemProvider, LazyListItemProvider itemProvider, int itemsCount, int beyondBoundsItemCount, LazyLayoutPinnedItemList pinnedItems) {
        LazyMeasuredItemProvider lazyMeasuredItemProvider = measuredItemProvider;
        Ref.ObjectRef list = new Ref.ObjectRef();
        int start = currentFirstItemIndex;
        if (beyondBoundsInfo.hasIntervals()) {
            LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo = beyondBoundsInfo;
            start = Math.min(createItemsBeforeList_tv8sHfA$startIndex(beyondBoundsInfo, itemsCount), start);
        } else {
            LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo2 = beyondBoundsInfo;
            int i = itemsCount;
        }
        int start2 = Math.max(0, start - beyondBoundsItemCount);
        int i2 = currentFirstItemIndex - 1;
        if (start2 <= i2) {
            while (true) {
                createItemsBeforeList_tv8sHfA$addItem$5(list, lazyMeasuredItemProvider, i2);
                if (i2 == start2) {
                    break;
                }
                i2--;
            }
        }
        List $this$fastForEach$iv = pinnedItems;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            LazyLayoutPinnedItemList.PinnedItem item = (LazyLayoutPinnedItemList.PinnedItem) $this$fastForEach$iv.get(index$iv);
            int index = LazyLayoutItemProviderKt.findIndexByKey(itemProvider, item.getKey(), item.getIndex());
            if (index < start2) {
                createItemsBeforeList_tv8sHfA$addItem$5(list, lazyMeasuredItemProvider, index);
            }
        }
        List<LazyMeasuredItem> list2 = list.element;
        return list2 == null ? CollectionsKt.emptyList() : list2;
    }

    private static final void createItemsBeforeList_tv8sHfA$addItem$5(Ref.ObjectRef<List<LazyMeasuredItem>> list, LazyMeasuredItemProvider $measuredItemProvider, int index) {
        if (list.element == null) {
            list.element = (List) new ArrayList();
        }
        T t = list.element;
        if (t != null) {
            ((List) t).add($measuredItemProvider.m917getAndMeasureZjPyQlc(DataIndex.m883constructorimpl(index)));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private static final List<LazyListPositionedItem> calculateItemsOffsets(List<LazyMeasuredItem> items, List<LazyMeasuredItem> extraItemsBefore, List<LazyMeasuredItem> extraItemsAfter, int layoutWidth, int layoutHeight, int finalMainAxisOffset, int maxOffset, int itemsScrollOffset, boolean isVertical, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density) {
        int[] offsets;
        int relativeOffset;
        List<LazyMeasuredItem> list = items;
        int i = layoutWidth;
        int i2 = layoutHeight;
        boolean z = reverseLayout;
        int mainAxisLayoutSize = isVertical ? i2 : i;
        boolean z2 = true;
        boolean hasSpareSpace = finalMainAxisOffset < Math.min(mainAxisLayoutSize, maxOffset);
        if (hasSpareSpace) {
            if (!(itemsScrollOffset == 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        ArrayList positionedItems = new ArrayList(items.size() + extraItemsBefore.size() + extraItemsAfter.size());
        if (hasSpareSpace) {
            if (!extraItemsBefore.isEmpty() || !extraItemsAfter.isEmpty()) {
                z2 = false;
            }
            if (z2) {
                int itemsCount = items.size();
                int[] iArr = new int[itemsCount];
                for (int i3 = 0; i3 < itemsCount; i3++) {
                    iArr[i3] = list.get(calculateItemsOffsets$reverseAware(i3, z, itemsCount)).getSize();
                }
                int[] sizes = iArr;
                int[] iArr2 = new int[itemsCount];
                for (int i4 = 0; i4 < itemsCount; i4++) {
                    iArr2[i4] = 0;
                }
                int[] offsets2 = iArr2;
                if (!isVertical) {
                    Density density2 = density;
                    if (horizontalArrangement != null) {
                        offsets = offsets2;
                        int[] iArr3 = sizes;
                        horizontalArrangement.arrange(density, mainAxisLayoutSize, sizes, LayoutDirection.Ltr, offsets);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else if (verticalArrangement != null) {
                    verticalArrangement.arrange(density, mainAxisLayoutSize, sizes, offsets2);
                    offsets = offsets2;
                    int[] iArr4 = sizes;
                } else {
                    Density density3 = density;
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                IntProgression reverseAwareOffsetIndices = ArraysKt.getIndices(offsets);
                if (z) {
                    reverseAwareOffsetIndices = RangesKt.reversed(reverseAwareOffsetIndices);
                }
                int index = reverseAwareOffsetIndices.getFirst();
                int last = reverseAwareOffsetIndices.getLast();
                int step = reverseAwareOffsetIndices.getStep();
                if ((step > 0 && index <= last) || (step < 0 && last <= index)) {
                    while (true) {
                        int absoluteOffset = offsets[index];
                        LazyMeasuredItem item = list.get(calculateItemsOffsets$reverseAware(index, z, itemsCount));
                        if (z) {
                            relativeOffset = (mainAxisLayoutSize - absoluteOffset) - item.getSize();
                        } else {
                            relativeOffset = absoluteOffset;
                        }
                        positionedItems.add(item.position(relativeOffset, i, i2));
                        if (index == last) {
                            break;
                        }
                        index += step;
                        list = items;
                        z = reverseLayout;
                    }
                }
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            int currentMainAxis = itemsScrollOffset;
            List $this$fastForEach$iv = extraItemsBefore;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                LazyMeasuredItem it = $this$fastForEach$iv.get(index$iv);
                currentMainAxis -= it.getSizeWithSpacings();
                positionedItems.add(it.position(currentMainAxis, i, i2));
            }
            int currentMainAxis2 = itemsScrollOffset;
            List $this$fastForEach$iv2 = items;
            int size2 = $this$fastForEach$iv2.size();
            for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                LazyMeasuredItem it2 = $this$fastForEach$iv2.get(index$iv2);
                positionedItems.add(it2.position(currentMainAxis2, i, i2));
                currentMainAxis2 += it2.getSizeWithSpacings();
            }
            List $this$fastForEach$iv3 = extraItemsAfter;
            int size3 = $this$fastForEach$iv3.size();
            for (int index$iv3 = 0; index$iv3 < size3; index$iv3++) {
                LazyMeasuredItem it3 = $this$fastForEach$iv3.get(index$iv3);
                positionedItems.add(it3.position(currentMainAxis2, i, i2));
                currentMainAxis2 += it3.getSizeWithSpacings();
            }
        }
        return positionedItems;
    }

    private static final int calculateItemsOffsets$reverseAware(int $this$calculateItemsOffsets_u24reverseAware, boolean $reverseLayout, int itemsCount) {
        return !$reverseLayout ? $this$calculateItemsOffsets_u24reverseAware : (itemsCount - $this$calculateItemsOffsets_u24reverseAware) - 1;
    }

    private static final boolean getNotInEmptyRange(int $this$notInEmptyRange) {
        return $this$notInEmptyRange != Integer.MIN_VALUE;
    }
}
