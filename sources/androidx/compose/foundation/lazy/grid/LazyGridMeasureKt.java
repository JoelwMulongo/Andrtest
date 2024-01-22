package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aR\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\nH\bø\u0001\u0000\u001a\u0001\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#H\u0002\u001aê\u0001\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010\u0003\u001a\u00020\u00042/\u00107\u001a+\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:0\n¢\u0006\u0002\b;\u0012\u0004\u0012\u00020<08H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a$\u0010?\u001a\u00020\u0012*\u00020\u00022\u0006\u0010@\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006A"}, d2 = {"calculateExtraItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "itemConstraints", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/ItemIndex;", "Landroidx/compose/ui/unit/Constraints;", "filter", "", "", "calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "lines", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredLineProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-t5wl_D8", "(ILandroidx/compose/foundation/lazy/grid/LazyGridItemProvider;Landroidx/compose/foundation/lazy/grid/LazyMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "positionExtraItem", "mainAxisOffset", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridMeasure.kt */
public final class LazyGridMeasureKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v9, resolved type: androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x04f5  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x04ff  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0566  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0569  */
    /* renamed from: measureLazyGrid-t5wl_D8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.lazy.grid.LazyGridMeasureResult m966measureLazyGridt5wl_D8(int r47, androidx.compose.foundation.lazy.grid.LazyGridItemProvider r48, androidx.compose.foundation.lazy.grid.LazyMeasuredLineProvider r49, androidx.compose.foundation.lazy.grid.LazyMeasuredItemProvider r50, int r51, int r52, int r53, int r54, int r55, int r56, float r57, long r58, boolean r60, androidx.compose.foundation.layout.Arrangement.Vertical r61, androidx.compose.foundation.layout.Arrangement.Horizontal r62, boolean r63, androidx.compose.ui.unit.Density r64, androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator r65, androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider r66, androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList r67, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>, ? extends androidx.compose.ui.layout.MeasureResult> r68) {
        /*
            r14 = r47
            r15 = r48
            r13 = r49
            r12 = r52
            r10 = r58
            r9 = r67
            r8 = r68
            java.lang.String r0 = "itemProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "measuredLineProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "measuredItemProvider"
            r7 = r50
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "density"
            r6 = r64
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "placementAnimator"
            r3 = r65
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "spanLayoutProvider"
            r2 = r66
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "pinnedItems"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "layout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 0
            r29 = 1
            if (r12 < 0) goto L_0x004d
            r1 = r29
            goto L_0x004e
        L_0x004d:
            r1 = r0
        L_0x004e:
            java.lang.String r4 = "Failed requirement."
            if (r1 == 0) goto L_0x05b8
            if (r53 < 0) goto L_0x0057
            r1 = r29
            goto L_0x0058
        L_0x0057:
            r1 = r0
        L_0x0058:
            if (r1 == 0) goto L_0x05ae
            if (r14 > 0) goto L_0x00a3
            androidx.compose.foundation.lazy.grid.LazyGridMeasureResult r0 = new androidx.compose.foundation.lazy.grid.LazyGridMeasureResult
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            int r1 = androidx.compose.ui.unit.Constraints.m5932getMinWidthimpl(r58)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r4 = androidx.compose.ui.unit.Constraints.m5931getMinHeightimpl(r58)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$1 r5 = androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$1.INSTANCE
            java.lang.Object r1 = r8.invoke(r1, r4, r5)
            r21 = r1
            androidx.compose.ui.layout.MeasureResult r21 = (androidx.compose.ui.layout.MeasureResult) r21
            java.util.List r22 = kotlin.collections.CollectionsKt.emptyList()
            int r1 = -r12
            int r24 = r51 + r53
            r25 = 0
            if (r60 == 0) goto L_0x008f
            androidx.compose.foundation.gestures.Orientation r4 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x0091
        L_0x008f:
            androidx.compose.foundation.gestures.Orientation r4 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x0091:
            r27 = r4
            r16 = r0
            r23 = r1
            r26 = r63
            r28 = r53
            r29 = r54
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return r0
        L_0x00a3:
            r1 = r55
            r5 = r56
            int r16 = kotlin.math.MathKt.roundToInt((float) r57)
            int r5 = r5 - r16
            int r2 = androidx.compose.foundation.lazy.grid.LineIndex.m988constructorimpl(r0)
            boolean r2 = androidx.compose.foundation.lazy.grid.LineIndex.m991equalsimpl0(r1, r2)
            if (r2 == 0) goto L_0x00bc
            if (r5 >= 0) goto L_0x00bc
            int r16 = r16 + r5
            r5 = 0
        L_0x00bc:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            int r0 = -r12
            if (r54 >= 0) goto L_0x00c9
            r17 = r54
            goto L_0x00cb
        L_0x00c9:
            r17 = 0
        L_0x00cb:
            int r0 = r0 + r17
            r31 = r51
            int r5 = r5 + r0
        L_0x00d0:
            if (r5 >= 0) goto L_0x00f9
            r17 = 0
            int r18 = androidx.compose.foundation.lazy.grid.LineIndex.m988constructorimpl(r17)
            r17 = 0
            int r17 = r1 - r18
            if (r17 <= 0) goto L_0x00f9
            int r17 = r1 + -1
            int r3 = androidx.compose.foundation.lazy.grid.LineIndex.m988constructorimpl(r17)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r6 = r13.m984getAndMeasurebKFJvoY(r3)
            r7 = 0
            r2.add(r7, r6)
            int r7 = r6.getMainAxisSizeWithSpacings()
            int r5 = r5 + r7
            r1 = r3
            r7 = r50
            r6 = r64
            r3 = r65
            goto L_0x00d0
        L_0x00f9:
            if (r5 >= r0) goto L_0x00fe
            int r16 = r16 + r5
            r5 = r0
        L_0x00fe:
            int r5 = r5 - r0
            r3 = 0
            r3 = r1
            r7 = r31
            int r6 = r7 + r53
            r17 = r1
            r1 = 0
            int r6 = kotlin.ranges.RangesKt.coerceAtLeast((int) r6, (int) r1)
            r1 = 0
            int r1 = -r5
            r18 = r2
            r19 = 0
            r20 = 0
            r21 = r1
            int r1 = r18.size()
            r46 = r20
            r20 = r5
            r5 = r46
        L_0x0121:
            if (r5 >= r1) goto L_0x014a
            r22 = r1
            r1 = r18
            java.lang.Object r18 = r1.get(r5)
            r23 = r18
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r23 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r23
            r24 = 0
            r25 = 0
            int r26 = r3 + 1
            int r25 = androidx.compose.foundation.lazy.grid.LineIndex.m988constructorimpl(r26)
            r3 = r25
            int r25 = r23.getMainAxisSizeWithSpacings()
            int r21 = r21 + r25
            int r5 = r5 + 1
            r18 = r1
            r1 = r22
            goto L_0x0121
        L_0x014a:
            r1 = r18
            r5 = r20
            r1 = r21
        L_0x0150:
            if (r3 >= r14) goto L_0x01b8
            if (r1 < r6) goto L_0x0162
            if (r1 <= 0) goto L_0x0162
            boolean r18 = r2.isEmpty()
            if (r18 == 0) goto L_0x015d
            goto L_0x0162
        L_0x015d:
            r31 = r0
            r18 = r6
            goto L_0x01bc
        L_0x0162:
            r18 = r6
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r6 = r13.m984getAndMeasurebKFJvoY(r3)
            boolean r19 = r6.isEmpty()
            if (r19 == 0) goto L_0x0171
            r31 = r0
            goto L_0x01bc
        L_0x0171:
            int r19 = r6.getMainAxisSizeWithSpacings()
            int r1 = r1 + r19
            if (r1 > r0) goto L_0x01a2
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r19 = r6.getItems()
            java.lang.Object r19 = kotlin.collections.ArraysKt.last((T[]) r19)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r19 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r19
            r31 = r0
            int r0 = r19.m968getIndexVZbfaAc()
            r19 = r1
            int r1 = r14 + -1
            if (r0 == r1) goto L_0x01a6
            r0 = 1
            r1 = r3
            r20 = 0
            int r21 = r1 + r0
            int r0 = androidx.compose.foundation.lazy.grid.LineIndex.m988constructorimpl(r21)
            int r1 = r6.getMainAxisSizeWithSpacings()
            int r5 = r5 - r1
            r17 = r0
            goto L_0x01a9
        L_0x01a2:
            r31 = r0
            r19 = r1
        L_0x01a6:
            r2.add(r6)
        L_0x01a9:
            r0 = 0
            int r1 = r3 + 1
            int r0 = androidx.compose.foundation.lazy.grid.LineIndex.m988constructorimpl(r1)
            r3 = r0
            r6 = r18
            r1 = r19
            r0 = r31
            goto L_0x0150
        L_0x01b8:
            r31 = r0
            r18 = r6
        L_0x01bc:
            if (r1 >= r7) goto L_0x020e
            int r0 = r7 - r1
            int r5 = r5 - r0
            int r1 = r1 + r0
        L_0x01c2:
            if (r5 >= r12) goto L_0x01f3
            r6 = 0
            int r19 = androidx.compose.foundation.lazy.grid.LineIndex.m988constructorimpl(r6)
            r6 = 0
            int r6 = r17 - r19
            if (r6 <= 0) goto L_0x01ed
            int r6 = r17 + -1
            int r6 = androidx.compose.foundation.lazy.grid.LineIndex.m988constructorimpl(r6)
            r19 = r3
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r3 = r13.m984getAndMeasurebKFJvoY(r6)
            r20 = r7
            r7 = 0
            r2.add(r7, r3)
            int r21 = r3.getMainAxisSizeWithSpacings()
            int r5 = r5 + r21
            r17 = r6
            r3 = r19
            r7 = r20
            goto L_0x01c2
        L_0x01ed:
            r19 = r3
            r20 = r7
            r7 = 0
            goto L_0x01f8
        L_0x01f3:
            r19 = r3
            r20 = r7
            r7 = 0
        L_0x01f8:
            int r16 = r16 + r0
            if (r5 >= 0) goto L_0x0207
            int r16 = r16 + r5
            int r1 = r1 + r5
            r5 = 0
            r0 = r1
            r6 = r5
            r3 = r16
            r30 = r17
            goto L_0x0219
        L_0x0207:
            r0 = r1
            r6 = r5
            r3 = r16
            r30 = r17
            goto L_0x0219
        L_0x020e:
            r19 = r3
            r20 = r7
            r7 = 0
            r0 = r1
            r6 = r5
            r3 = r16
            r30 = r17
        L_0x0219:
            int r1 = kotlin.math.MathKt.roundToInt((float) r57)
            int r1 = kotlin.math.MathKt.getSign((int) r1)
            int r5 = kotlin.math.MathKt.getSign((int) r3)
            if (r1 != r5) goto L_0x0237
            int r1 = kotlin.math.MathKt.roundToInt((float) r57)
            int r1 = java.lang.Math.abs(r1)
            int r5 = java.lang.Math.abs(r3)
            if (r1 < r5) goto L_0x0237
            float r1 = (float) r3
            goto L_0x0239
        L_0x0237:
            r1 = r57
        L_0x0239:
            if (r6 < 0) goto L_0x023f
            r17 = r29
            goto L_0x0241
        L_0x023f:
            r17 = r7
        L_0x0241:
            if (r17 == 0) goto L_0x05a0
            int r4 = -r6
            java.lang.Object r5 = kotlin.collections.CollectionsKt.first(r2)
            r16 = r5
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r16 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r16
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r5 = r16.getItems()
            java.lang.Object r5 = kotlin.collections.ArraysKt.firstOrNull((T[]) r5)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r5 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r5
            if (r5 == 0) goto L_0x025d
            int r17 = r5.m968getIndexVZbfaAc()
            goto L_0x025f
        L_0x025d:
            r17 = r7
        L_0x025f:
            r5 = r17
            java.lang.Object r17 = kotlin.collections.CollectionsKt.lastOrNull(r2)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r17 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r17
            if (r17 == 0) goto L_0x027c
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r17 = r17.getItems()
            if (r17 == 0) goto L_0x027c
            java.lang.Object r17 = kotlin.collections.ArraysKt.lastOrNull((T[]) r17)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r17 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r17
            if (r17 == 0) goto L_0x027c
            int r17 = r17.m968getIndexVZbfaAc()
            goto L_0x027e
        L_0x027c:
            r17 = r7
        L_0x027e:
            r32 = r17
            r17 = 0
            r21 = 0
            r7 = r9
            java.util.List r7 = (java.util.List) r7
            r23 = 0
            r24 = 0
            r25 = r6
            int r6 = r7.size()
            r46 = r24
            r24 = r3
            r3 = r46
        L_0x0298:
            if (r3 >= r6) goto L_0x0352
            java.lang.Object r26 = r7.get(r3)
            r27 = r26
            androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList$PinnedItem r27 = (androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem) r27
            r28 = 0
            r33 = r1
            r1 = r15
            androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider r1 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider) r1
            r34 = r2
            java.lang.Object r2 = r27.getKey()
            r35 = r3
            int r3 = r27.getIndex()
            int r36 = androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt.findIndexByKey(r1, r2, r3)
            r1 = r36
            r2 = 0
            if (r1 < 0) goto L_0x02c3
            if (r1 >= r5) goto L_0x02c3
            r1 = r29
            goto L_0x02c4
        L_0x02c3:
            r1 = 0
        L_0x02c4:
            if (r1 == 0) goto L_0x031c
            int r37 = androidx.compose.foundation.lazy.grid.ItemIndex.m934constructorimpl(r36)
            r1 = r37
            r2 = 0
            long r1 = r13.m985itemConstraintsHZ0wssc(r1)
            r38 = r4
            r3 = r5
            r4 = r1
            r39 = 0
            r40 = 2
            r41 = 0
            r2 = r33
            r1 = r50
            r42 = r2
            r2 = r37
            r43 = r3
            r33 = r19
            r46 = r35
            r35 = r24
            r24 = r46
            r3 = r39
            r39 = r18
            r19 = r25
            r18 = r6
            r6 = r40
            r40 = r20
            r44 = 0
            r20 = r7
            r7 = r41
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r1 = androidx.compose.foundation.lazy.grid.LazyMeasuredItemProvider.m981getAndMeasureednRnyU$default(r1, r2, r3, r4, r6, r7)
            if (r21 != 0) goto L_0x0314
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r21 = r2
            java.util.List r21 = (java.util.List) r21
            r2 = r21
            goto L_0x0316
        L_0x0314:
            r2 = r21
        L_0x0316:
            r2.add(r1)
            r21 = r2
            goto L_0x0336
        L_0x031c:
            r38 = r4
            r43 = r5
            r39 = r18
            r40 = r20
            r42 = r33
            r44 = 0
            r18 = r6
            r20 = r7
            r33 = r19
            r19 = r25
            r46 = r35
            r35 = r24
            r24 = r46
        L_0x0336:
            int r3 = r24 + 1
            r6 = r18
            r25 = r19
            r7 = r20
            r19 = r33
            r2 = r34
            r24 = r35
            r4 = r38
            r18 = r39
            r20 = r40
            r1 = r42
            r5 = r43
            goto L_0x0298
        L_0x0352:
            r42 = r1
            r34 = r2
            r38 = r4
            r43 = r5
            r39 = r18
            r33 = r19
            r40 = r20
            r35 = r24
            r19 = r25
            r44 = 0
            r24 = r3
            r20 = r7
            if (r21 != 0) goto L_0x0374
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r17 = r1
            goto L_0x0376
        L_0x0374:
            r17 = r21
        L_0x0376:
            r18 = 0
            r1 = 0
            r7 = r9
            java.util.List r7 = (java.util.List) r7
            r20 = 0
            r2 = 0
            int r6 = r7.size()
            r21 = r1
            r3 = r2
        L_0x0388:
            if (r3 >= r6) goto L_0x040a
            java.lang.Object r22 = r7.get(r3)
            r23 = r22
            androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList$PinnedItem r23 = (androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem) r23
            r24 = 0
            r1 = r15
            androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider r1 = (androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider) r1
            java.lang.Object r2 = r23.getKey()
            int r4 = r23.getIndex()
            int r25 = androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt.findIndexByKey(r1, r2, r4)
            r1 = r25
            r2 = 0
            r4 = r32
            int r5 = r4 + 1
            if (r5 > r1) goto L_0x03b1
            if (r1 >= r14) goto L_0x03b1
            r1 = r29
            goto L_0x03b3
        L_0x03b1:
            r1 = r44
        L_0x03b3:
            if (r1 == 0) goto L_0x03f6
            int r26 = androidx.compose.foundation.lazy.grid.ItemIndex.m934constructorimpl(r25)
            r1 = r26
            r2 = 0
            long r1 = r13.m985itemConstraintsHZ0wssc(r1)
            r45 = r4
            r4 = r1
            r27 = 0
            r28 = 2
            r32 = 0
            r1 = r50
            r2 = r26
            r36 = r3
            r3 = r27
            r27 = r6
            r6 = r28
            r28 = r7
            r7 = r32
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r1 = androidx.compose.foundation.lazy.grid.LazyMeasuredItemProvider.m981getAndMeasureednRnyU$default(r1, r2, r3, r4, r6, r7)
            if (r21 != 0) goto L_0x03ee
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r21 = r2
            java.util.List r21 = (java.util.List) r21
            r2 = r21
            goto L_0x03f0
        L_0x03ee:
            r2 = r21
        L_0x03f0:
            r2.add(r1)
            r21 = r2
            goto L_0x03fe
        L_0x03f6:
            r36 = r3
            r45 = r4
            r27 = r6
            r28 = r7
        L_0x03fe:
            int r3 = r36 + 1
            r6 = r27
            r7 = r28
            r32 = r45
            goto L_0x0388
        L_0x040a:
            r36 = r3
            r28 = r7
            r45 = r32
            if (r21 != 0) goto L_0x041a
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            r18 = r1
            goto L_0x041c
        L_0x041a:
            r18 = r21
        L_0x041c:
            if (r12 > 0) goto L_0x0429
            if (r54 >= 0) goto L_0x0422
            goto L_0x0429
        L_0x0422:
            r32 = r19
            r7 = r34
            r34 = r16
            goto L_0x045f
        L_0x0429:
            r1 = 0
            int r2 = r34.size()
            r6 = r19
        L_0x0430:
            if (r1 >= r2) goto L_0x0459
            r7 = r34
            java.lang.Object r3 = r7.get(r1)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r3 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r3
            int r3 = r3.getMainAxisSizeWithSpacings()
            if (r6 == 0) goto L_0x0458
            if (r3 > r6) goto L_0x0458
            int r4 = kotlin.collections.CollectionsKt.getLastIndex(r7)
            if (r1 == r4) goto L_0x0458
            int r6 = r6 - r3
            int r4 = r1 + 1
            java.lang.Object r4 = r7.get(r4)
            r16 = r4
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r16 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r16
            int r1 = r1 + 1
            r34 = r7
            goto L_0x0430
        L_0x0458:
            goto L_0x045b
        L_0x0459:
            r7 = r34
        L_0x045b:
            r32 = r6
            r34 = r16
        L_0x045f:
            if (r60 == 0) goto L_0x0468
            int r1 = androidx.compose.ui.unit.Constraints.m5930getMaxWidthimpl(r58)
            r19 = r1
            goto L_0x046e
        L_0x0468:
            int r1 = androidx.compose.ui.unit.ConstraintsKt.m5944constrainWidthK40F9xA(r10, r0)
            r19 = r1
        L_0x046e:
            if (r60 == 0) goto L_0x0478
            int r1 = androidx.compose.ui.unit.ConstraintsKt.m5943constrainHeightK40F9xA(r10, r0)
            r20 = r1
            goto L_0x047e
        L_0x0478:
            int r1 = androidx.compose.ui.unit.Constraints.m5929getMaxHeightimpl(r58)
            r20 = r1
        L_0x047e:
            r16 = r7
            r21 = r0
            r22 = r40
            r23 = r38
            r24 = r60
            r25 = r61
            r26 = r62
            r27 = r63
            r28 = r64
            java.util.List r6 = calculateItemsOffsets(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r5 = r42
            int r2 = (int) r5
            r1 = r65
            r3 = r19
            r4 = r20
            r16 = r5
            r5 = r6
            r15 = r6
            r6 = r50
            r21 = r7
            r7 = r66
            r1.onMeasured(r2, r3, r4, r5, r6, r7)
            int r1 = r14 + -1
            r7 = r45
            if (r7 != r1) goto L_0x04ce
            r6 = r40
            if (r0 <= r6) goto L_0x04cb
            goto L_0x04d0
        L_0x04cb:
            r3 = r44
            goto L_0x04d2
        L_0x04ce:
            r6 = r40
        L_0x04d0:
            r3 = r29
        L_0x04d2:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r20)
            androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3 r4 = new androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3
            r4.<init>(r15)
            java.lang.Object r1 = r8.invoke(r1, r2, r4)
            r5 = r1
            androidx.compose.ui.layout.MeasureResult r5 = (androidx.compose.ui.layout.MeasureResult) r5
            int r4 = -r12
            int r22 = r51 + r53
            boolean r1 = r17.isEmpty()
            if (r1 == 0) goto L_0x04ff
            boolean r1 = r18.isEmpty()
            if (r1 == 0) goto L_0x04ff
            r23 = r0
            r28 = r4
            r24 = r15
            r14 = r43
            goto L_0x0563
        L_0x04ff:
            r1 = r15
            r2 = 0
            r23 = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r24 = r2
            int r2 = r1.size()
            r0.<init>(r2)
            r2 = r1
            r25 = 0
            r26 = 0
            r27 = r1
            int r1 = r2.size()
            r28 = r4
            r4 = r26
        L_0x051f:
            if (r4 >= r1) goto L_0x0559
            java.lang.Object r26 = r2.get(r4)
            r36 = r26
            r37 = 0
            r40 = r1
            r1 = r36
            r36 = r1
            androidx.compose.foundation.lazy.grid.LazyGridPositionedItem r36 = (androidx.compose.foundation.lazy.grid.LazyGridPositionedItem) r36
            r41 = 0
            r42 = r2
            int r2 = r36.getIndex()
            r14 = r43
            if (r14 > r2) goto L_0x0542
            if (r2 > r7) goto L_0x0542
            r2 = r29
            goto L_0x0544
        L_0x0542:
            r2 = r44
        L_0x0544:
            if (r2 == 0) goto L_0x054c
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            r2.add(r1)
        L_0x054c:
            int r4 = r4 + 1
            r43 = r14
            r1 = r40
            r2 = r42
            r14 = r47
            goto L_0x051f
        L_0x0559:
            r42 = r2
            r14 = r43
            r1 = r0
            java.util.List r1 = (java.util.List) r1
            r24 = r1
        L_0x0563:
            if (r60 == 0) goto L_0x0569
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x056b
        L_0x0569:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x056b:
            r25 = r0
            androidx.compose.foundation.lazy.grid.LazyGridMeasureResult r26 = new androidx.compose.foundation.lazy.grid.LazyGridMeasureResult
            r27 = r23
            r23 = r31
            r0 = r26
            r1 = r34
            r2 = r32
            r4 = r16
            r29 = r6
            r6 = r24
            r24 = r7
            r7 = r28
            r8 = r22
            r9 = r47
            r10 = r63
            r11 = r25
            r12 = r53
            r13 = r54
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r26
        L_0x05a0:
            r27 = r0
            r16 = r1
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r4.toString()
            r0.<init>(r1)
            throw r0
        L_0x05ae:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r4.toString()
            r0.<init>(r1)
            throw r0
        L_0x05b8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r4.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.m966measureLazyGridt5wl_D8(int, androidx.compose.foundation.lazy.grid.LazyGridItemProvider, androidx.compose.foundation.lazy.grid.LazyMeasuredLineProvider, androidx.compose.foundation.lazy.grid.LazyMeasuredItemProvider, int, int, int, int, int, int, float, long, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator, androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider, androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.grid.LazyGridMeasureResult");
    }

    private static final List<LazyGridMeasuredItem> calculateExtraItems(LazyLayoutPinnedItemList pinnedItems, LazyMeasuredItemProvider measuredItemProvider, LazyGridItemProvider itemProvider, Function1<? super ItemIndex, Constraints> itemConstraints, Function1<? super Integer, Boolean> filter) {
        List<LazyGridMeasuredItem> list = null;
        List $this$fastForEach$iv = pinnedItems;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            LazyLayoutPinnedItemList.PinnedItem item = (LazyLayoutPinnedItemList.PinnedItem) $this$fastForEach$iv.get(index$iv);
            int index = LazyLayoutItemProviderKt.findIndexByKey(itemProvider, item.getKey(), item.getIndex());
            if (filter.invoke(Integer.valueOf(index)).booleanValue()) {
                int itemIndex = ItemIndex.m934constructorimpl(index);
                LazyGridMeasuredItem measuredItem = LazyMeasuredItemProvider.m981getAndMeasureednRnyU$default(measuredItemProvider, itemIndex, 0, itemConstraints.invoke(ItemIndex.m932boximpl(itemIndex)).m5936unboximpl(), 2, (Object) null);
                if (list == null) {
                    list = (List) new ArrayList();
                }
                list.add(measuredItem);
            }
        }
        Function1<? super Integer, Boolean> function1 = filter;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    private static final List<LazyGridPositionedItem> calculateItemsOffsets(List<LazyGridMeasuredLine> lines, List<LazyGridMeasuredItem> itemsBefore, List<LazyGridMeasuredItem> itemsAfter, int layoutWidth, int layoutHeight, int finalMainAxisOffset, int maxOffset, int firstLineScrollOffset, boolean isVertical, Arrangement.Vertical verticalArrangement, Arrangement.Horizontal horizontalArrangement, boolean reverseLayout, Density density) {
        int[] offsets;
        int relativeOffset;
        List<LazyGridMeasuredLine> list = lines;
        int i = layoutWidth;
        int i2 = layoutHeight;
        boolean z = reverseLayout;
        int mainAxisLayoutSize = isVertical ? i2 : i;
        boolean hasSpareSpace = finalMainAxisOffset < Math.min(mainAxisLayoutSize, maxOffset);
        if (hasSpareSpace) {
            if (!(firstLineScrollOffset == 0)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        int sum$iv = 0;
        List $this$fastForEach$iv$iv = lines;
        int size = $this$fastForEach$iv$iv.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            sum$iv += ((LazyGridMeasuredLine) $this$fastForEach$iv$iv.get(index$iv$iv)).getItems().length;
        }
        ArrayList positionedItems = new ArrayList(sum$iv);
        if (hasSpareSpace) {
            if (itemsBefore.isEmpty() && itemsAfter.isEmpty()) {
                int linesCount = lines.size();
                int[] iArr = new int[linesCount];
                for (int i3 = 0; i3 < linesCount; i3++) {
                    iArr[i3] = list.get(calculateItemsOffsets$reverseAware(i3, z, linesCount)).getMainAxisSize();
                }
                int[] sizes = iArr;
                int[] iArr2 = new int[linesCount];
                for (int i4 = 0; i4 < linesCount; i4++) {
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
                        LazyGridMeasuredLine line = list.get(calculateItemsOffsets$reverseAware(index, z, linesCount));
                        if (z) {
                            relativeOffset = (mainAxisLayoutSize - absoluteOffset) - line.getMainAxisSize();
                        } else {
                            relativeOffset = absoluteOffset;
                        }
                        positionedItems.addAll(line.position(relativeOffset, i, i2));
                        if (index == last) {
                            break;
                        }
                        index += step;
                        list = lines;
                    }
                }
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            int currentMainAxis = firstLineScrollOffset;
            List $this$fastForEach$iv = itemsBefore;
            int index$iv = 0;
            int size2 = $this$fastForEach$iv.size();
            while (index$iv < size2) {
                LazyGridMeasuredItem it = $this$fastForEach$iv.get(index$iv);
                currentMainAxis -= it.getMainAxisSizeWithSpacings();
                positionedItems.add(positionExtraItem(it, currentMainAxis, i, i2));
                index$iv++;
                boolean z2 = reverseLayout;
            }
            int currentMainAxis2 = firstLineScrollOffset;
            List $this$fastForEach$iv2 = lines;
            int size3 = $this$fastForEach$iv2.size();
            for (int index$iv2 = 0; index$iv2 < size3; index$iv2++) {
                LazyGridMeasuredLine it2 = $this$fastForEach$iv2.get(index$iv2);
                positionedItems.addAll(it2.position(currentMainAxis2, i, i2));
                currentMainAxis2 += it2.getMainAxisSizeWithSpacings();
            }
            List $this$fastForEach$iv3 = itemsAfter;
            int size4 = $this$fastForEach$iv3.size();
            for (int index$iv3 = 0; index$iv3 < size4; index$iv3++) {
                LazyGridMeasuredItem it3 = $this$fastForEach$iv3.get(index$iv3);
                positionedItems.add(positionExtraItem(it3, currentMainAxis2, i, i2));
                currentMainAxis2 += it3.getMainAxisSizeWithSpacings();
            }
        }
        return positionedItems;
    }

    private static final int calculateItemsOffsets$reverseAware(int $this$calculateItemsOffsets_u24reverseAware, boolean $reverseLayout, int linesCount) {
        return !$reverseLayout ? $this$calculateItemsOffsets_u24reverseAware : (linesCount - $this$calculateItemsOffsets_u24reverseAware) - 1;
    }

    private static final LazyGridPositionedItem positionExtraItem(LazyGridMeasuredItem $this$positionExtraItem, int mainAxisOffset, int layoutWidth, int layoutHeight) {
        return $this$positionExtraItem.position(mainAxisOffset, 0, layoutWidth, layoutHeight, 0, 0);
    }
}
