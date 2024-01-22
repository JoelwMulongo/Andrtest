package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0017\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\b\u001a5\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\f¢\u0006\u0002\b\rH\b¢\u0006\u0002\u0010\u000e\u001aJ\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\f2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\fH\b\u001a;\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\u00020\u00122\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016H\u0002¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u00020\u0006*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001d0\u001cH\u0002¢\u0006\u0002\u0010#\u001a\u001c\u0010$\u001a\u00020\u0003*\u00020\u00122\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0016H\u0002\u001a\u001c\u0010'\u001a\u00020\u0016*\u00020\u00122\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0016H\u0002\u001a.\u0010*\u001a\u00020\u0003*\u00020+2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\fH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a\f\u0010.\u001a\u00020\u0016*\u00020\u001fH\u0002\u001a2\u0010/\u001a\u00020\u0016\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u001c2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00160\fH\b¢\u0006\u0002\u00100\u001a\u0016\u00101\u001a\u00020\u0016*\u00020\u001f2\b\b\u0002\u00102\u001a\u00020\u0016H\u0000\u001a!\u00103\u001a\u00020\u0016*\u00020\u001f2\u0006\u00104\u001a\u00020+H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106\u001a,\u00107\u001a\u000208*\u00020\u00122\u0006\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u0001H\u0003\u001ay\u0010=\u001a\u000208*\u00020\n2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00012\u0006\u0010F\u001a\u00020\u00012\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00162\u0006\u0010J\u001a\u00020\u00162\u0006\u0010K\u001a\u00020\u00162\u0006\u0010L\u001a\u00020\u00162\u0006\u0010M\u001a\u00020\u0016H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bN\u0010O\u001a\u0014\u0010P\u001a\u00020\u0003*\u00020\u001f2\u0006\u0010Q\u001a\u00020\u0016H\u0002\u001a!\u0010R\u001a\u00020\u001f*\u00020\u001f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\fH\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006S"}, d2 = {"DebugLoggingEnabled", "", "debugLog", "", "message", "Lkotlin/Function0;", "", "withDebugLogging", "T", "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "calculateExtraItems", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridPositionedItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "position", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "filter", "", "Lkotlin/ParameterName;", "name", "itemIndex", "calculatePositionedItems", "measuredItems", "", "Lkotlin/collections/ArrayDeque;", "itemScrollOffsets", "", "mainAxisLayoutSize", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[II)Ljava/util/List;", "debugRender", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "ensureIndicesInRange", "indices", "itemCount", "findPreviousItemIndex", "item", "lane", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "indexOfMaxValue", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMinValue", "minBound", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "initialScrollDelta", "initialItemIndices", "initialItemOffsets", "canRestartMeasure", "measureStaggeredGrid", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlotSums", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "crossAxisSpacing", "beforeContentPadding", "afterContentPadding", "measureStaggeredGrid-BTfHGGE", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;[IJZZJIIIII)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "offsetBy", "delta", "transform", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasure.kt */
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;

    private static final <T> T withDebugLogging(LazyLayoutMeasureScope scope, Function1<? super LazyLayoutMeasureScope, ? extends T> block) {
        return block.invoke(scope);
    }

    private static final String debugRender(ArrayDeque<LazyStaggeredGridMeasuredItem>[] $this$debugRender) {
        return "";
    }

    private static final void debugLog(Function0<String> message) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: androidx.compose.runtime.snapshots.Snapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: androidx.compose.runtime.snapshots.Snapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: androidx.compose.runtime.snapshots.Snapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v4, resolved type: androidx.compose.runtime.snapshots.Snapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v5, resolved type: androidx.compose.runtime.snapshots.Snapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v6, resolved type: androidx.compose.runtime.snapshots.Snapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v8, resolved type: androidx.compose.runtime.snapshots.Snapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v10, resolved type: androidx.compose.runtime.snapshots.Snapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v14, resolved type: androidx.compose.runtime.snapshots.Snapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v15, resolved type: androidx.compose.runtime.snapshots.Snapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v17, resolved type: androidx.compose.runtime.snapshots.Snapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v21, resolved type: androidx.compose.runtime.snapshots.Snapshot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v22, resolved type: androidx.compose.runtime.snapshots.Snapshot} */
    /* JADX WARNING: type inference failed for: r16v20 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measureStaggeredGrid-BTfHGGE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult m1051measureStaggeredGridBTfHGGE(androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope r21, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r22, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider r23, int[] r24, long r25, boolean r27, boolean r28, long r29, int r31, int r32, int r33, int r34, int r35) {
        /*
            r1 = r24
            r8 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r7 = r27
            r14 = r28
            r10 = r29
            r9 = r31
            r15 = r32
            r16 = r33
            r12 = r34
            r13 = r35
            java.lang.String r0 = "$this$measureStaggeredGrid"
            r18 = r2
            r2 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "state"
            r2 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "itemProvider"
            r2 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "resolvedSlotSums"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext r0 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext
            r1 = r0
            r17 = 0
            r2 = r18
            r1.<init>(r2, r3, r4, r5, r7, r8, r9, r10, r12, r13, r14, r15, r16, r17)
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r2 = r0
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r3 = r0
            androidx.compose.runtime.snapshots.Snapshot$Companion r4 = androidx.compose.runtime.snapshots.Snapshot.Companion
            r5 = 0
            androidx.compose.runtime.snapshots.Snapshot r6 = r4.createNonObservableSnapshot()
            r7 = r6
            r8 = 0
            androidx.compose.runtime.snapshots.Snapshot r0 = r7.makeCurrent()     // Catch:{ all -> 0x0162 }
            r9 = r0
            r0 = 0
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScrollPosition r10 = r22.getScrollPosition$foundation_release()     // Catch:{ all -> 0x0153 }
            int[] r10 = r10.getIndices()     // Catch:{ all -> 0x0153 }
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScrollPosition r11 = r22.getScrollPosition$foundation_release()     // Catch:{ all -> 0x0153 }
            int[] r11 = r11.getOffsets()     // Catch:{ all -> 0x0153 }
            int r12 = r10.length     // Catch:{ all -> 0x0153 }
            r13 = r24
            int r14 = r13.length     // Catch:{ all -> 0x0151 }
            if (r12 != r14) goto L_0x0092
            r19 = r0
            r18 = r4
            r20 = r5
            r16 = r6
            r12 = r10
            r4 = 0
            goto L_0x0102
        L_0x0092:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r12 = r1.getLaneInfo()     // Catch:{ all -> 0x0151 }
            r12.reset()     // Catch:{ all -> 0x0151 }
            int r12 = r13.length     // Catch:{ all -> 0x0151 }
            int[] r12 = new int[r12]     // Catch:{ all -> 0x0151 }
            r14 = r12
            r17 = 0
            r18 = 0
            int r15 = r14.length     // Catch:{ all -> 0x0151 }
            r19 = r0
            r0 = r18
        L_0x00a6:
            if (r0 >= r15) goto L_0x00f9
            r18 = r4
            int r4 = r10.length     // Catch:{ all -> 0x00f2 }
            if (r0 >= r4) goto L_0x00c8
            r4 = r10[r0]     // Catch:{ all -> 0x00c1 }
            r20 = r5
            r5 = -1
            if (r4 == r5) goto L_0x00ca
            r4 = r10[r0]     // Catch:{ all -> 0x00bc }
            r5 = r4
            r16 = r6
            r4 = 0
            goto L_0x00de
        L_0x00bc:
            r0 = move-exception
            r16 = r6
            goto L_0x015c
        L_0x00c1:
            r0 = move-exception
            r20 = r5
            r16 = r6
            goto L_0x015c
        L_0x00c8:
            r20 = r5
        L_0x00ca:
            if (r0 != 0) goto L_0x00d1
            r16 = r6
            r4 = 0
            r5 = 0
            goto L_0x00de
        L_0x00d1:
            r16 = r6
            r4 = 0
            long r5 = androidx.compose.foundation.lazy.staggeredgrid.SpanRange.m1061constructorimpl(r4, r0)     // Catch:{ all -> 0x014f }
            int r5 = m1050maxInRangejy6DScQ(r14, r5)     // Catch:{ all -> 0x014f }
            r6 = 1
            int r5 = r5 + r6
        L_0x00de:
            r14[r0] = r5     // Catch:{ all -> 0x014f }
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLaneInfo r5 = r1.getLaneInfo()     // Catch:{ all -> 0x014f }
            r6 = r14[r0]     // Catch:{ all -> 0x014f }
            r5.setLane(r6, r0)     // Catch:{ all -> 0x014f }
            int r0 = r0 + 1
            r6 = r16
            r4 = r18
            r5 = r20
            goto L_0x00a6
        L_0x00f2:
            r0 = move-exception
            r20 = r5
            r16 = r6
            goto L_0x015c
        L_0x00f9:
            r18 = r4
            r20 = r5
            r16 = r6
            r4 = 0
        L_0x0102:
            r2.element = r12     // Catch:{ all -> 0x014f }
            int r0 = r11.length     // Catch:{ all -> 0x014f }
            int r5 = r13.length     // Catch:{ all -> 0x014f }
            if (r0 != r5) goto L_0x010b
            r0 = r11
            goto L_0x0129
        L_0x010b:
            int r0 = r13.length     // Catch:{ all -> 0x014f }
            int[] r0 = new int[r0]     // Catch:{ all -> 0x014f }
            r5 = r0
            r6 = 0
            r12 = 0
            int r14 = r5.length     // Catch:{ all -> 0x014f }
        L_0x0112:
            if (r12 >= r14) goto L_0x0127
            int r15 = r11.length     // Catch:{ all -> 0x014f }
            if (r12 >= r15) goto L_0x011a
            r15 = r11[r12]     // Catch:{ all -> 0x014f }
            goto L_0x0122
        L_0x011a:
            if (r12 != 0) goto L_0x011e
            r15 = r4
            goto L_0x0122
        L_0x011e:
            int r15 = r12 + -1
            r15 = r5[r15]     // Catch:{ all -> 0x014f }
        L_0x0122:
            r5[r12] = r15     // Catch:{ all -> 0x014f }
            int r12 = r12 + 1
            goto L_0x0112
        L_0x0127:
        L_0x0129:
            r3.element = r0     // Catch:{ all -> 0x014f }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x014f }
            r7.restoreCurrent(r9)     // Catch:{ all -> 0x0160 }
            r16.dispose()
            float r0 = r22.getScrollToBeConsumed$foundation_release()
            int r0 = kotlin.math.MathKt.roundToInt((float) r0)
            T r4 = r2.element
            int[] r4 = (int[]) r4
            T r5 = r3.element
            int[] r5 = (int[]) r5
            r6 = 1
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult r0 = measure(r1, r0, r4, r5, r6)
            return r0
        L_0x014f:
            r0 = move-exception
            goto L_0x015c
        L_0x0151:
            r0 = move-exception
            goto L_0x0156
        L_0x0153:
            r0 = move-exception
            r13 = r24
        L_0x0156:
            r18 = r4
            r20 = r5
            r16 = r6
        L_0x015c:
            r7.restoreCurrent(r9)     // Catch:{ all -> 0x0160 }
            throw r0     // Catch:{ all -> 0x0160 }
        L_0x0160:
            r0 = move-exception
            goto L_0x016b
        L_0x0162:
            r0 = move-exception
            r13 = r24
            r18 = r4
            r20 = r5
            r16 = r6
        L_0x016b:
            r16.dispose()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt.m1051measureStaggeredGridBTfHGGE(androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState, androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemProvider, int[], long, boolean, boolean, long, int, int, int, int, int):androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult");
    }

    private static final LazyStaggeredGridMeasureResult measure(LazyStaggeredGridMeasureContext $this$measure, int initialScrollDelta, int[] initialItemIndices, int[] initialItemOffsets, boolean canRestartMeasure) {
        int itemCount;
        int initialLaneToMeasure;
        int initialLaneToMeasure2;
        int scrollDelta;
        boolean z;
        int itemCount2;
        boolean z2;
        boolean z3;
        int maxOffset;
        int[] currentItemIndices;
        int itemCount3;
        int[] firstItemIndices;
        int[] currentItemOffsets;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext;
        int toScrollBack;
        float consumedScroll;
        int layoutWidth;
        int layoutHeight;
        boolean z4;
        boolean canScrollForward;
        boolean z5;
        List extraItemsBefore;
        ArrayDeque[] measuredItems;
        boolean z6;
        int layoutWidth2;
        int layoutHeight2;
        List $this$fastForEach$iv$iv;
        boolean z7;
        int scrollDelta2;
        int maxOffsetLane;
        boolean gapDetected;
        int maxOffsetLane2;
        int[] currentItemOffsets2;
        int scrollDelta3;
        boolean gapDetected2;
        boolean gapDetected3;
        int currentIndex;
        boolean gapDetected4;
        int initialLaneToMeasure3;
        int i;
        int i2;
        int[] gaps;
        int initialLaneToMeasure4;
        int initialItemsMeasured;
        boolean z8;
        String str;
        int scrollDelta4;
        int[] firstItemIndices2;
        int minOffset;
        int laneToCheckForGaps;
        int initialItemsMeasured2;
        int initialLaneToMeasure5;
        int i3;
        int i4;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = $this$measure;
        int[] iArr = initialItemIndices;
        int[] iArr2 = initialItemOffsets;
        LazyLayoutMeasureScope $this$measure_u24lambda_u2437 = $this$measure.getMeasureScope();
        int itemCount4 = $this$measure.getItemProvider().getItemCount();
        if (itemCount4 <= 0) {
            itemCount = itemCount4;
        } else if ($this$measure.getLaneCount() == 0) {
            itemCount = itemCount4;
        } else {
            int scrollDelta5 = initialScrollDelta;
            int[] firstItemIndices3 = Arrays.copyOf(iArr, iArr.length);
            String str2 = "copyOf(this, size)";
            Intrinsics.checkNotNullExpressionValue(firstItemIndices3, str2);
            int[] firstItemOffsets = Arrays.copyOf(iArr2, iArr2.length);
            Intrinsics.checkNotNullExpressionValue(firstItemOffsets, str2);
            ensureIndicesInRange(lazyStaggeredGridMeasureContext2, firstItemIndices3, itemCount4);
            offsetBy(firstItemOffsets, -scrollDelta5);
            int laneCount = $this$measure.getLaneCount();
            ArrayDeque[] arrayDequeArr = new ArrayDeque[laneCount];
            for (int i5 = 0; i5 < laneCount; i5++) {
                arrayDequeArr[i5] = new ArrayDeque(16);
            }
            ArrayDeque[] measuredItems2 = arrayDequeArr;
            offsetBy(firstItemOffsets, -$this$measure.getBeforeContentPadding());
            int laneToCheckForGaps2 = -1;
            while (true) {
                if (!measure$lambda$37$hasSpaceBeforeFirst(firstItemIndices3, firstItemOffsets, lazyStaggeredGridMeasureContext2)) {
                    initialLaneToMeasure = itemCount4;
                    int i6 = laneToCheckForGaps2;
                    break;
                }
                int laneIndex = indexOfMaxValue(firstItemIndices3);
                int itemIndex = firstItemIndices3[laneIndex];
                int length = firstItemOffsets.length;
                for (int i7 = 0; i7 < length; i7++) {
                    if (firstItemIndices3[i7] != firstItemIndices3[laneIndex] && firstItemOffsets[i7] < firstItemOffsets[laneIndex]) {
                        firstItemOffsets[i7] = firstItemOffsets[laneIndex];
                    }
                }
                int previousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, itemIndex, laneIndex);
                if (previousItemIndex < 0) {
                    laneToCheckForGaps2 = laneIndex;
                    initialLaneToMeasure = itemCount4;
                    break;
                }
                long spanRange = lazyStaggeredGridMeasureContext2.m1047getSpanRangelOCCd4c($this$measure.getItemProvider(), previousItemIndex, laneIndex);
                LazyStaggeredGridLaneInfo laneInfo = $this$measure.getLaneInfo();
                long $this$laneInfo$iv = spanRange;
                long $this$isFullSpan$iv$iv = $this$laneInfo$iv;
                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = $this$measure;
                int laneToCheckForGaps3 = laneToCheckForGaps2;
                int itemCount5 = itemCount4;
                if (((int) ($this$isFullSpan$iv$iv & 4294967295L)) - ((int) ($this$isFullSpan$iv$iv >> 32)) != 1) {
                    i4 = -2;
                } else {
                    i4 = (int) ($this$laneInfo$iv >> 32);
                }
                laneInfo.setLane(previousItemIndex, i4);
                LazyStaggeredGridMeasuredItem measuredItem = $this$measure.getMeasuredItemProvider().m1055getAndMeasurejy6DScQ(previousItemIndex, spanRange);
                int offset = m1050maxInRangejy6DScQ(firstItemOffsets, spanRange);
                long $this$isFullSpan$iv = spanRange;
                int i8 = laneIndex;
                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext4 = $this$measure;
                long j = $this$isFullSpan$iv;
                int[] gaps2 = ((int) ($this$isFullSpan$iv & 4294967295L)) - ((int) ($this$isFullSpan$iv >> 32)) != 1 ? $this$measure.getLaneInfo().getGaps(previousItemIndex) : null;
                long $this$forEach_u2dnIS5qE8$iv = spanRange;
                int i9 = itemIndex;
                long j2 = spanRange;
                long j3 = $this$forEach_u2dnIS5qE8$iv;
                int i10 = (int) ($this$forEach_u2dnIS5qE8$iv & 4294967295L);
                for (int i$iv = (int) ($this$forEach_u2dnIS5qE8$iv >> 32); i$iv < i10; i$iv++) {
                    int lane = i$iv;
                    firstItemIndices3[lane] = previousItemIndex;
                    firstItemOffsets[lane] = offset + measuredItem.getSizeWithSpacings() + (gaps2 == null ? 0 : gaps2[lane]);
                }
                int[] iArr3 = initialItemIndices;
                int[] iArr4 = initialItemOffsets;
                laneToCheckForGaps2 = laneToCheckForGaps3;
                itemCount4 = itemCount5;
            }
            int minOffset2 = -$this$measure.getBeforeContentPadding();
            if (firstItemOffsets[0] < minOffset2) {
                scrollDelta5 += firstItemOffsets[0];
                offsetBy(firstItemOffsets, minOffset2 - firstItemOffsets[0]);
            }
            offsetBy(firstItemOffsets, $this$measure.getBeforeContentPadding());
            int i11 = -1;
            int laneToCheckForGaps4 = laneToCheckForGaps2 == -1 ? ArraysKt.indexOf(firstItemIndices3, 0) : laneToCheckForGaps2;
            if (laneToCheckForGaps4 != -1) {
                int lane2 = laneToCheckForGaps4;
                if (measure$lambda$37$misalignedStart(firstItemIndices3, lazyStaggeredGridMeasureContext2, firstItemOffsets, lane2) && canRestartMeasure) {
                    $this$measure.getLaneInfo().reset();
                    int length2 = firstItemIndices3.length;
                    int[] iArr5 = new int[length2];
                    for (int i12 = 0; i12 < length2; i12++) {
                        iArr5[i12] = -1;
                    }
                    int length3 = firstItemOffsets.length;
                    int[] iArr6 = new int[length3];
                    for (int i13 = 0; i13 < length3; i13++) {
                        iArr6[i13] = firstItemOffsets[lane2];
                    }
                    return measure(lazyStaggeredGridMeasureContext2, scrollDelta, iArr5, iArr6, false);
                }
            }
            int[] currentItemIndices2 = Arrays.copyOf(firstItemIndices3, firstItemIndices3.length);
            Intrinsics.checkNotNullExpressionValue(currentItemIndices2, str2);
            int length4 = firstItemOffsets.length;
            int[] iArr7 = new int[length4];
            for (int i14 = 0; i14 < length4; i14++) {
                iArr7[i14] = -firstItemOffsets[i14];
            }
            int[] currentItemOffsets3 = iArr7;
            int maxOffset2 = RangesKt.coerceAtLeast($this$measure.getMainAxisAvailableSize() + $this$measure.getAfterContentPadding(), 0);
            int initialItemsMeasured3 = 0;
            int initialLaneToMeasure6 = indexOfMinValue$default(currentItemIndices2, 0, 1, (Object) null);
            while (initialLaneToMeasure6 != i11 && initialItemsMeasured3 < $this$measure.getLaneCount()) {
                int itemIndex2 = currentItemIndices2[initialLaneToMeasure6];
                int laneIndex2 = initialLaneToMeasure6;
                int initialLaneToMeasure7 = indexOfMinValue(currentItemIndices2, itemIndex2);
                int initialItemsMeasured4 = initialItemsMeasured3 + 1;
                if (itemIndex2 >= 0) {
                    initialLaneToMeasure5 = initialLaneToMeasure7;
                    initialItemsMeasured2 = initialItemsMeasured4;
                    long spanRange2 = lazyStaggeredGridMeasureContext2.m1047getSpanRangelOCCd4c($this$measure.getItemProvider(), itemIndex2, laneIndex2);
                    LazyStaggeredGridMeasuredItem measuredItem2 = $this$measure.getMeasuredItemProvider().m1055getAndMeasurejy6DScQ(itemIndex2, spanRange2);
                    laneToCheckForGaps = laneToCheckForGaps4;
                    LazyStaggeredGridLaneInfo laneInfo2 = $this$measure.getLaneInfo();
                    long $this$laneInfo$iv2 = spanRange2;
                    long $this$isFullSpan$iv$iv2 = $this$laneInfo$iv2;
                    LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext5 = $this$measure;
                    scrollDelta4 = scrollDelta;
                    firstItemIndices2 = firstItemIndices3;
                    str = str2;
                    if (((int) ($this$isFullSpan$iv$iv2 & 4294967295L)) - ((int) ($this$isFullSpan$iv$iv2 >> 32)) != 1) {
                        i3 = -2;
                    } else {
                        i3 = (int) ($this$laneInfo$iv2 >> 32);
                    }
                    laneInfo2.setLane(itemIndex2, i3);
                    int offset2 = m1050maxInRangejy6DScQ(currentItemOffsets3, spanRange2) + measuredItem2.getSizeWithSpacings();
                    long value$iv$iv$iv = spanRange2;
                    minOffset = minOffset2;
                    int i15 = (int) (value$iv$iv$iv & 4294967295L);
                    int i$iv2 = (int) (value$iv$iv$iv >> 32);
                    while (i$iv2 < i15) {
                        int lane3 = i$iv2;
                        currentItemOffsets3[lane3] = offset2;
                        currentItemIndices2[lane3] = itemIndex2;
                        measuredItems2[lane3].addLast(measuredItem2);
                        i$iv2++;
                        offset2 = offset2;
                    }
                    if (currentItemOffsets3[(int) (spanRange2 >> 32)] <= minOffset + $this$measure.getMainAxisSpacing()) {
                        measuredItem2.setVisible(false);
                    }
                    long $this$isFullSpan$iv2 = spanRange2;
                    long value$iv$iv$iv$iv = $this$isFullSpan$iv2;
                    LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext6 = $this$measure;
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = measuredItem2;
                    long j4 = $this$isFullSpan$iv2;
                    if (((int) (value$iv$iv$iv$iv & 4294967295L)) - ((int) (value$iv$iv$iv$iv >> 32)) != 1) {
                        initialItemsMeasured3 = $this$measure.getLaneCount();
                        lazyStaggeredGridMeasureContext2 = $this$measure;
                        initialLaneToMeasure6 = initialLaneToMeasure5;
                        laneToCheckForGaps4 = laneToCheckForGaps;
                        minOffset2 = minOffset;
                        firstItemIndices3 = firstItemIndices2;
                        scrollDelta = scrollDelta4;
                        str2 = str;
                        i11 = -1;
                    }
                } else {
                    scrollDelta4 = scrollDelta;
                    minOffset = minOffset2;
                    firstItemIndices2 = firstItemIndices3;
                    str = str2;
                    laneToCheckForGaps = laneToCheckForGaps4;
                    initialLaneToMeasure5 = initialLaneToMeasure7;
                    initialItemsMeasured2 = initialItemsMeasured4;
                }
                lazyStaggeredGridMeasureContext2 = $this$measure;
                initialLaneToMeasure6 = initialLaneToMeasure5;
                initialItemsMeasured3 = initialItemsMeasured2;
                laneToCheckForGaps4 = laneToCheckForGaps;
                minOffset2 = minOffset;
                firstItemIndices3 = firstItemIndices2;
                scrollDelta = scrollDelta4;
                str2 = str;
                i11 = -1;
            }
            int scrollDelta6 = scrollDelta;
            int minOffset3 = minOffset2;
            int[] firstItemIndices4 = firstItemIndices3;
            String str3 = str2;
            int i16 = laneToCheckForGaps4;
            while (true) {
                int[] $this$any$iv = currentItemOffsets3;
                int length5 = $this$any$iv.length;
                int i17 = 0;
                while (true) {
                    if (i17 >= length5) {
                        z = false;
                        break;
                    }
                    int it = $this$any$iv[i17];
                    if (it < maxOffset2 || it <= 0) {
                        z = true;
                        break;
                    }
                    i17++;
                }
                if (!z) {
                    ArrayDeque[] arrayDequeArr2 = measuredItems2;
                    int length6 = arrayDequeArr2.length;
                    int i18 = 0;
                    while (true) {
                        if (i18 >= length6) {
                            z8 = true;
                            break;
                        } else if (!arrayDequeArr2[i18].isEmpty()) {
                            z8 = false;
                            break;
                        } else {
                            i18++;
                        }
                    }
                    if (!z8) {
                        itemCount2 = initialLaneToMeasure2;
                        break;
                    }
                }
                int currentLaneIndex = indexOfMinValue$default(currentItemOffsets3, 0, 1, (Object) null);
                int previousItemIndex2 = ArraysKt.maxOrThrow(currentItemIndices2);
                int itemIndex3 = previousItemIndex2 + 1;
                itemCount2 = initialLaneToMeasure2;
                if (itemIndex3 >= itemCount2) {
                    break;
                }
                int itemCount6 = itemCount2;
                int[] currentItemOffsets4 = currentItemOffsets3;
                int maxOffset3 = maxOffset2;
                int initialLaneToMeasure8 = initialLaneToMeasure6;
                int[] firstItemIndices5 = firstItemIndices4;
                int scrollDelta7 = scrollDelta6;
                ArrayDeque[] measuredItems3 = measuredItems2;
                int[] currentItemIndices3 = currentItemIndices2;
                String str4 = str3;
                int initialItemsMeasured5 = initialItemsMeasured3;
                long spanRange3 = $this$measure.m1047getSpanRangelOCCd4c($this$measure.getItemProvider(), itemIndex3, currentLaneIndex);
                LazyStaggeredGridLaneInfo laneInfo3 = $this$measure.getLaneInfo();
                long $this$laneInfo$iv3 = spanRange3;
                long $this$isFullSpan$iv$iv3 = $this$laneInfo$iv3;
                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext7 = $this$measure;
                int[] firstItemOffsets2 = firstItemOffsets;
                int i19 = currentLaneIndex;
                if (((int) ($this$isFullSpan$iv$iv3 & 4294967295L)) - ((int) ($this$isFullSpan$iv$iv3 >> 32)) != 1) {
                    i2 = -2;
                } else {
                    i2 = (int) ($this$laneInfo$iv3 >> 32);
                }
                laneInfo3.setLane(itemIndex3, i2);
                LazyStaggeredGridMeasuredItem measuredItem3 = $this$measure.getMeasuredItemProvider().m1055getAndMeasurejy6DScQ(itemIndex3, spanRange3);
                int offset3 = m1050maxInRangejy6DScQ(currentItemOffsets4, spanRange3);
                long $this$isFullSpan$iv3 = spanRange3;
                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext8 = $this$measure;
                long value$iv$iv$iv$iv2 = $this$isFullSpan$iv3;
                int scrollDelta8 = scrollDelta7;
                long j5 = $this$isFullSpan$iv3;
                if (((int) (value$iv$iv$iv$iv2 & 4294967295L)) - ((int) (value$iv$iv$iv$iv2 >> 32)) != 1) {
                    gaps = $this$measure.getLaneInfo().getGaps(itemIndex3);
                    if (gaps == null) {
                        gaps = new int[$this$measure.getLaneCount()];
                    }
                } else {
                    gaps = null;
                }
                long value$iv$iv$iv2 = spanRange3;
                int[] gaps3 = gaps;
                int i20 = (int) (value$iv$iv$iv2 & 4294967295L);
                int i$iv3 = (int) (value$iv$iv$iv2 >> 32);
                while (i$iv3 < i20) {
                    int lane4 = i$iv3;
                    if (gaps3 != null) {
                        gaps3[lane4] = offset3 - currentItemOffsets4[lane4];
                    }
                    currentItemIndices3[lane4] = itemIndex3;
                    currentItemOffsets4[lane4] = offset3 + measuredItem3.getSizeWithSpacings();
                    measuredItems3[lane4].addLast(measuredItem3);
                    i$iv3++;
                    previousItemIndex2 = previousItemIndex2;
                }
                $this$measure.getLaneInfo().setGaps(itemIndex3, gaps3);
                if (currentItemOffsets4[(int) (spanRange3 >> 32)] <= minOffset3 + $this$measure.getMainAxisSpacing()) {
                    measuredItem3.setVisible(false);
                    currentItemOffsets3 = currentItemOffsets4;
                    firstItemOffsets = firstItemOffsets2;
                    initialLaneToMeasure4 = initialLaneToMeasure8;
                    measuredItems2 = measuredItems3;
                    initialItemsMeasured = initialItemsMeasured5;
                    maxOffset2 = maxOffset3;
                    str3 = str4;
                    firstItemIndices4 = firstItemIndices5;
                    initialLaneToMeasure2 = itemCount6;
                    currentItemIndices2 = currentItemIndices3;
                    scrollDelta6 = scrollDelta8;
                } else {
                    currentItemOffsets3 = currentItemOffsets4;
                    firstItemOffsets = firstItemOffsets2;
                    initialLaneToMeasure4 = initialLaneToMeasure8;
                    measuredItems2 = measuredItems3;
                    initialItemsMeasured = initialItemsMeasured5;
                    maxOffset2 = maxOffset3;
                    str3 = str4;
                    firstItemIndices4 = firstItemIndices5;
                    initialLaneToMeasure2 = itemCount6;
                    currentItemIndices2 = currentItemIndices3;
                    scrollDelta6 = scrollDelta8;
                }
            }
            int length7 = measuredItems2.length;
            for (int laneIndex3 = 0; laneIndex3 < length7; laneIndex3++) {
                ArrayDeque laneItems = measuredItems2[laneIndex3];
                while (laneItems.size() > 1 && !((LazyStaggeredGridMeasuredItem) laneItems.first()).isVisible()) {
                    LazyStaggeredGridMeasuredItem item = (LazyStaggeredGridMeasuredItem) laneItems.removeFirst();
                    int[] gaps4 = item.getSpan() != 1 ? $this$measure.getLaneInfo().getGaps(item.getIndex()) : null;
                    firstItemOffsets[laneIndex3] = firstItemOffsets[laneIndex3] - (item.getSizeWithSpacings() + (gaps4 == null ? 0 : gaps4[laneIndex3]));
                }
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) laneItems.firstOrNull();
                firstItemIndices4[laneIndex3] = lazyStaggeredGridMeasuredItem2 != null ? lazyStaggeredGridMeasuredItem2.getIndex() : -1;
            }
            int[] $this$any$iv2 = currentItemIndices2;
            int length8 = $this$any$iv2.length;
            int i21 = 0;
            while (true) {
                if (i21 >= length8) {
                    z2 = false;
                    break;
                }
                if (($this$any$iv2[i21] == itemCount2 + -1 ? 1 : 0) != 0) {
                    z2 = true;
                    break;
                }
                i21++;
            }
            if (z2) {
                offsetBy(currentItemOffsets3, -$this$measure.getMainAxisSpacing());
            }
            int[] $this$all$iv = currentItemOffsets3;
            int length9 = $this$all$iv.length;
            int i22 = 0;
            while (true) {
                if (i22 >= length9) {
                    z3 = true;
                    break;
                }
                if (($this$all$iv[i22] < $this$measure.getMainAxisAvailableSize() ? 1 : 0) == 0) {
                    z3 = false;
                    break;
                }
                i22++;
            }
            if (z3) {
                int maxOffsetLane3 = indexOfMaxValue(currentItemOffsets3);
                int toScrollBack2 = $this$measure.getMainAxisAvailableSize() - currentItemOffsets3[maxOffsetLane3];
                offsetBy(firstItemOffsets, -toScrollBack2);
                offsetBy(currentItemOffsets3, toScrollBack2);
                boolean gapDetected5 = false;
                while (true) {
                    int[] $this$any$iv3 = firstItemOffsets;
                    int length10 = $this$any$iv3.length;
                    int i23 = 0;
                    while (true) {
                        if (i23 >= length10) {
                            maxOffsetLane = maxOffsetLane3;
                            gapDetected = gapDetected5;
                            maxOffsetLane2 = 0;
                            break;
                        }
                        maxOffsetLane = maxOffsetLane3;
                        gapDetected = gapDetected5;
                        if ($this$any$iv3[i23] < $this$measure.getBeforeContentPadding()) {
                            maxOffsetLane2 = 1;
                            break;
                        }
                        i23++;
                        maxOffsetLane3 = maxOffsetLane;
                        gapDetected5 = gapDetected;
                    }
                    if (maxOffsetLane2 == 0) {
                        currentItemOffsets2 = currentItemOffsets3;
                        maxOffset = maxOffset2;
                        int i24 = initialLaneToMeasure6;
                        firstItemIndices = firstItemIndices4;
                        scrollDelta3 = scrollDelta6;
                        itemCount3 = itemCount2;
                        currentItemIndices = currentItemIndices2;
                        gapDetected2 = gapDetected;
                        break;
                    }
                    int laneIndex4 = indexOfMinValue$default(firstItemOffsets, 0, 1, (Object) null);
                    if (laneIndex4 != indexOfMaxValue(firstItemIndices4)) {
                        gapDetected3 = true;
                    } else {
                        gapDetected3 = gapDetected;
                    }
                    if (firstItemIndices4[laneIndex4] == -1) {
                        currentIndex = itemCount2;
                    } else {
                        currentIndex = firstItemIndices4[laneIndex4];
                    }
                    LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext9 = $this$measure;
                    int previousIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext9, currentIndex, laneIndex4);
                    if (previousIndex < 0) {
                        if (!gapDetected3) {
                            firstItemIndices = firstItemIndices4;
                            if (!measure$lambda$37$misalignedStart(firstItemIndices, lazyStaggeredGridMeasureContext9, firstItemOffsets, laneIndex4)) {
                                int i25 = currentIndex;
                                gapDetected4 = gapDetected3;
                                int i26 = initialLaneToMeasure6;
                                initialLaneToMeasure3 = scrollDelta6;
                                itemCount3 = itemCount2;
                                currentItemIndices = currentItemIndices2;
                                currentItemOffsets2 = currentItemOffsets3;
                                maxOffset = maxOffset2;
                                scrollDelta3 = initialLaneToMeasure3;
                                gapDetected2 = gapDetected4;
                            }
                        } else {
                            firstItemIndices = firstItemIndices4;
                        }
                        if (canRestartMeasure) {
                            $this$measure.getLaneInfo().reset();
                            int length11 = firstItemIndices.length;
                            int i27 = currentIndex;
                            int[] iArr8 = new int[length11];
                            boolean z9 = gapDetected3;
                            for (int i28 = 0; i28 < length11; i28++) {
                                iArr8[i28] = -1;
                            }
                            int length12 = firstItemOffsets.length;
                            int[] iArr9 = new int[length12];
                            int i29 = initialLaneToMeasure6;
                            for (int initialLaneToMeasure9 = 0; initialLaneToMeasure9 < length12; initialLaneToMeasure9++) {
                                iArr9[initialLaneToMeasure9] = firstItemOffsets[laneIndex4];
                            }
                            return measure(lazyStaggeredGridMeasureContext9, scrollDelta6, iArr8, iArr9, false);
                        }
                        gapDetected4 = gapDetected3;
                        int i30 = initialLaneToMeasure6;
                        initialLaneToMeasure3 = scrollDelta6;
                        itemCount3 = itemCount2;
                        currentItemIndices = currentItemIndices2;
                        currentItemOffsets2 = currentItemOffsets3;
                        maxOffset = maxOffset2;
                        scrollDelta3 = initialLaneToMeasure3;
                        gapDetected2 = gapDetected4;
                    } else {
                        boolean gapDetected6 = gapDetected3;
                        int initialLaneToMeasure10 = initialLaneToMeasure6;
                        int[] firstItemIndices6 = firstItemIndices4;
                        int scrollDelta9 = scrollDelta6;
                        int itemCount7 = itemCount2;
                        long spanRange4 = lazyStaggeredGridMeasureContext9.m1047getSpanRangelOCCd4c($this$measure.getItemProvider(), previousIndex, laneIndex4);
                        LazyStaggeredGridLaneInfo laneInfo4 = $this$measure.getLaneInfo();
                        long $this$laneInfo$iv4 = spanRange4;
                        long $this$isFullSpan$iv$iv4 = $this$laneInfo$iv4;
                        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext10 = $this$measure;
                        int[] currentItemIndices4 = currentItemIndices2;
                        int[] currentItemOffsets5 = currentItemOffsets3;
                        int maxOffset4 = maxOffset2;
                        if (((int) ($this$isFullSpan$iv$iv4 & 4294967295L)) - ((int) ($this$isFullSpan$iv$iv4 >> 32)) != 1) {
                            int i31 = laneIndex4;
                            i = -2;
                        } else {
                            int i32 = laneIndex4;
                            i = (int) ($this$laneInfo$iv4 >> 32);
                        }
                        laneInfo4.setLane(previousIndex, i);
                        LazyStaggeredGridMeasuredItem measuredItem4 = $this$measure.getMeasuredItemProvider().m1055getAndMeasurejy6DScQ(previousIndex, spanRange4);
                        int offset4 = m1050maxInRangejy6DScQ(firstItemOffsets, spanRange4);
                        long $this$isFullSpan$iv4 = spanRange4;
                        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext11 = $this$measure;
                        int scrollDelta10 = scrollDelta9;
                        long j6 = $this$isFullSpan$iv4;
                        int[] gaps5 = ((int) ($this$isFullSpan$iv4 & 4294967295L)) - ((int) ($this$isFullSpan$iv4 >> 32)) != 1 ? $this$measure.getLaneInfo().getGaps(previousIndex) : null;
                        long value$iv$iv$iv3 = spanRange4;
                        long j7 = spanRange4;
                        int i$iv4 = (int) (value$iv$iv$iv3 >> 32);
                        int i33 = (int) (value$iv$iv$iv3 & 4294967295L);
                        gapDetected5 = gapDetected6;
                        while (i$iv4 < i33) {
                            int lane5 = i$iv4;
                            int i34 = i33;
                            if (firstItemOffsets[lane5] != offset4) {
                                gapDetected5 = true;
                            }
                            measuredItems2[lane5].addFirst(measuredItem4);
                            firstItemIndices6[lane5] = previousIndex;
                            firstItemOffsets[lane5] = offset4 + measuredItem4.getSizeWithSpacings() + (gaps5 == null ? 0 : gaps5[lane5]);
                            i$iv4++;
                            i33 = i34;
                        }
                        maxOffsetLane3 = maxOffsetLane;
                        initialLaneToMeasure6 = initialLaneToMeasure10;
                        itemCount2 = itemCount7;
                        currentItemIndices2 = currentItemIndices4;
                        maxOffset2 = maxOffset4;
                        currentItemOffsets3 = currentItemOffsets5;
                        firstItemIndices4 = firstItemIndices6;
                        scrollDelta6 = scrollDelta10;
                    }
                }
                if (!gapDetected2 || !canRestartMeasure) {
                    lazyStaggeredGridMeasureContext = $this$measure;
                    int scrollDelta11 = scrollDelta3 + toScrollBack2;
                    int minOffsetLane = indexOfMinValue$default(firstItemOffsets, 0, 1, (Object) null);
                    if (firstItemOffsets[minOffsetLane] < 0) {
                        int offsetValue = firstItemOffsets[minOffsetLane];
                        currentItemOffsets = currentItemOffsets2;
                        offsetBy(currentItemOffsets, offsetValue);
                        offsetBy(firstItemOffsets, -offsetValue);
                        toScrollBack = scrollDelta11 + offsetValue;
                    } else {
                        currentItemOffsets = currentItemOffsets2;
                        toScrollBack = scrollDelta11;
                    }
                } else {
                    $this$measure.getLaneInfo().reset();
                    return measure($this$measure, scrollDelta3, firstItemIndices, firstItemOffsets, false);
                }
            } else {
                currentItemOffsets = currentItemOffsets3;
                maxOffset = maxOffset2;
                int i35 = initialLaneToMeasure6;
                firstItemIndices = firstItemIndices4;
                int scrollDelta12 = scrollDelta6;
                itemCount3 = itemCount2;
                currentItemIndices = currentItemIndices2;
                lazyStaggeredGridMeasureContext = $this$measure;
                toScrollBack = scrollDelta12;
            }
            if (MathKt.getSign(MathKt.roundToInt($this$measure.getState().getScrollToBeConsumed$foundation_release())) != MathKt.getSign(toScrollBack) || Math.abs(MathKt.roundToInt($this$measure.getState().getScrollToBeConsumed$foundation_release())) < Math.abs(toScrollBack)) {
                consumedScroll = $this$measure.getState().getScrollToBeConsumed$foundation_release();
            } else {
                consumedScroll = (float) toScrollBack;
            }
            int[] itemScrollOffsets = Arrays.copyOf(firstItemOffsets, firstItemOffsets.length);
            Intrinsics.checkNotNullExpressionValue(itemScrollOffsets, str3);
            int length13 = itemScrollOffsets.length;
            for (int i$iv5 = 0; i$iv5 < length13; i$iv5++) {
                itemScrollOffsets[i$iv5] = -itemScrollOffsets[i$iv5];
            }
            if ($this$measure.getBeforeContentPadding() > 0) {
                int laneIndex5 = 0;
                int length14 = measuredItems2.length;
                while (laneIndex5 < length14) {
                    ArrayDeque laneItems2 = measuredItems2[laneIndex5];
                    int i36 = 0;
                    int size = laneItems2.size();
                    while (true) {
                        if (i36 >= size) {
                            scrollDelta2 = toScrollBack;
                            break;
                        }
                        LazyStaggeredGridMeasuredItem item2 = (LazyStaggeredGridMeasuredItem) laneItems2.get(i36);
                        int[] gaps6 = $this$measure.getLaneInfo().getGaps(item2.getIndex());
                        int size2 = item2.getSizeWithSpacings() + (gaps6 == null ? 0 : gaps6[laneIndex5]);
                        scrollDelta2 = toScrollBack;
                        if (i36 == CollectionsKt.getLastIndex(laneItems2) || firstItemOffsets[laneIndex5] == 0 || firstItemOffsets[laneIndex5] < size2) {
                            break;
                        }
                        firstItemOffsets[laneIndex5] = firstItemOffsets[laneIndex5] - size2;
                        firstItemIndices[laneIndex5] = ((LazyStaggeredGridMeasuredItem) laneItems2.get(i36 + 1)).getIndex();
                        i36++;
                        toScrollBack = scrollDelta2;
                    }
                    laneIndex5++;
                    toScrollBack = scrollDelta2;
                }
                int scrollDelta13 = toScrollBack;
            } else {
                int scrollDelta14 = toScrollBack;
            }
            if ($this$measure.isVertical() != 0) {
                layoutWidth = Constraints.m5930getMaxWidthimpl($this$measure.m1044getConstraintsmsEJaDk());
            } else {
                layoutWidth = ConstraintsKt.m5944constrainWidthK40F9xA($this$measure.m1044getConstraintsmsEJaDk(), ArraysKt.maxOrThrow(currentItemOffsets));
            }
            if ($this$measure.isVertical()) {
                layoutHeight = ConstraintsKt.m5943constrainHeightK40F9xA($this$measure.m1044getConstraintsmsEJaDk(), ArraysKt.maxOrThrow(currentItemOffsets));
            } else {
                layoutHeight = Constraints.m5929getMaxHeightimpl($this$measure.m1044getConstraintsmsEJaDk());
            }
            int mainAxisLayoutSize = Math.min($this$measure.isVertical() ? layoutHeight : layoutWidth, $this$measure.getMainAxisAvailableSize());
            int extraItemOffset = itemScrollOffsets[0];
            LazyStaggeredGridMeasureContext $this$calculateExtraItems$iv = $this$measure;
            List list = null;
            LazyLayoutPinnedItemList pinnedItems$iv = $this$calculateExtraItems$iv.getState().getPinnedItems$foundation_release();
            List $this$fastForEach$iv$iv2 = pinnedItems$iv;
            int extraItemOffset2 = extraItemOffset;
            int extraItemOffset3 = $this$fastForEach$iv$iv2.size();
            int index$iv$iv = 0;
            while (index$iv$iv < extraItemOffset3) {
                LazyLayoutPinnedItemList.PinnedItem item$iv = (LazyLayoutPinnedItemList.PinnedItem) $this$fastForEach$iv$iv2.get(index$iv$iv);
                int i37 = extraItemOffset3;
                LazyLayoutPinnedItemList pinnedItems$iv2 = pinnedItems$iv;
                int initialItemsMeasured6 = initialItemsMeasured3;
                int index$iv = LazyLayoutItemProviderKt.findIndexByKey($this$calculateExtraItems$iv.getItemProvider(), item$iv.getKey(), item$iv.getIndex());
                int itemIndex4 = index$iv;
                int lane6 = $this$measure.getLaneInfo().getLane(itemIndex4);
                switch (lane6) {
                    case -2:
                    case -1:
                        layoutHeight2 = layoutHeight;
                        $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                        int[] $this$all$iv2 = firstItemIndices;
                        int layoutHeight3 = $this$all$iv2.length;
                        layoutWidth2 = layoutWidth;
                        int layoutWidth3 = 0;
                        while (true) {
                            if (layoutWidth3 >= layoutHeight3) {
                                z7 = true;
                                break;
                            } else {
                                int i38 = layoutHeight3;
                                if (($this$all$iv2[layoutWidth3] > itemIndex4 ? 1 : 0) == 0) {
                                    z7 = false;
                                    break;
                                } else {
                                    layoutWidth3++;
                                    layoutHeight3 = i38;
                                }
                            }
                        }
                    default:
                        layoutWidth2 = layoutWidth;
                        layoutHeight2 = layoutHeight;
                        $this$fastForEach$iv$iv = $this$fastForEach$iv$iv2;
                        if (firstItemIndices[lane6] <= itemIndex4) {
                            z7 = false;
                            break;
                        } else {
                            z7 = true;
                            break;
                        }
                }
                if (z7) {
                    long spanRange$iv = $this$calculateExtraItems$iv.m1047getSpanRangelOCCd4c($this$calculateExtraItems$iv.getItemProvider(), index$iv, 0);
                    if (list == null) {
                        list = (List) new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem measuredItem$iv = $this$calculateExtraItems$iv.getMeasuredItemProvider().m1055getAndMeasurejy6DScQ(index$iv, spanRange$iv);
                    LazyStaggeredGridMeasuredItem it2 = measuredItem$iv;
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem3 = measuredItem$iv;
                    int extraItemOffset4 = extraItemOffset2 - it2.getSizeWithSpacings();
                    int i39 = index$iv;
                    list.add(it2.position(0, extraItemOffset4, 0, mainAxisLayoutSize));
                    extraItemOffset2 = extraItemOffset4;
                }
                index$iv$iv++;
                pinnedItems$iv = pinnedItems$iv2;
                extraItemOffset3 = i37;
                $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv;
                initialItemsMeasured3 = initialItemsMeasured6;
                layoutHeight = layoutHeight2;
                layoutWidth = layoutWidth2;
            }
            int layoutWidth4 = layoutWidth;
            int layoutHeight4 = layoutHeight;
            LazyLayoutPinnedItemList lazyLayoutPinnedItemList = pinnedItems$iv;
            int i40 = initialItemsMeasured3;
            List list2 = $this$fastForEach$iv$iv2;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            List extraItemsBefore2 = list;
            List positionedItems = calculatePositionedItems(lazyStaggeredGridMeasureContext, measuredItems2, itemScrollOffsets, mainAxisLayoutSize);
            int extraItemOffset5 = itemScrollOffsets[0];
            LazyStaggeredGridMeasureContext $this$calculateExtraItems$iv2 = $this$measure;
            List list3 = null;
            LazyLayoutPinnedItemList pinnedItems$iv3 = $this$calculateExtraItems$iv2.getState().getPinnedItems$foundation_release();
            List $this$fastForEach$iv$iv3 = pinnedItems$iv3;
            int itemCount8 = false;
            int[] iArr10 = itemScrollOffsets;
            int size3 = $this$fastForEach$iv$iv3.size();
            int index$iv$iv2 = 0;
            while (index$iv$iv2 < size3) {
                LazyLayoutPinnedItemList.PinnedItem item$iv2 = (LazyLayoutPinnedItemList.PinnedItem) $this$fastForEach$iv$iv3.get(index$iv$iv2);
                int i41 = size3;
                LazyLayoutPinnedItemList pinnedItems$iv4 = pinnedItems$iv3;
                List $this$fastForEach$iv$iv4 = $this$fastForEach$iv$iv3;
                int index$iv2 = LazyLayoutItemProviderKt.findIndexByKey($this$calculateExtraItems$iv2.getItemProvider(), item$iv2.getKey(), item$iv2.getIndex());
                int itemIndex5 = index$iv2;
                int $i$f$fastForEach = itemCount8;
                int itemCount9 = itemCount3;
                if (itemIndex5 < itemCount9) {
                    int lane7 = $this$measure.getLaneInfo().getLane(itemIndex5);
                    switch (lane7) {
                        case -2:
                        case -1:
                            extraItemsBefore = extraItemsBefore2;
                            measuredItems = measuredItems2;
                            int[] $this$all$iv3 = currentItemIndices;
                            int length15 = $this$all$iv3.length;
                            int i42 = 0;
                            while (true) {
                                if (i42 >= length15) {
                                    z6 = true;
                                    break;
                                } else {
                                    int i43 = length15;
                                    if (($this$all$iv3[i42] < itemIndex5 ? 1 : 0) == 0) {
                                        z6 = false;
                                        break;
                                    } else {
                                        i42++;
                                        length15 = i43;
                                    }
                                }
                            }
                        default:
                            extraItemsBefore = extraItemsBefore2;
                            measuredItems = measuredItems2;
                            if (currentItemIndices[lane7] >= itemIndex5) {
                                z6 = false;
                                break;
                            } else {
                                z6 = true;
                                break;
                            }
                    }
                } else {
                    extraItemsBefore = extraItemsBefore2;
                    measuredItems = measuredItems2;
                    z6 = false;
                }
                if (z6) {
                    long spanRange$iv2 = $this$calculateExtraItems$iv2.m1047getSpanRangelOCCd4c($this$calculateExtraItems$iv2.getItemProvider(), index$iv2, 0);
                    if (list3 == null) {
                        list3 = (List) new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem measuredItem$iv2 = $this$calculateExtraItems$iv2.getMeasuredItemProvider().m1055getAndMeasurejy6DScQ(index$iv2, spanRange$iv2);
                    LazyStaggeredGridMeasuredItem it3 = measuredItem$iv2;
                    int i44 = index$iv2;
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem4 = measuredItem$iv2;
                    LazyStaggeredGridPositionedItem positionedItem = it3.position(0, extraItemOffset5, 0, mainAxisLayoutSize);
                    extraItemOffset5 += it3.getSizeWithSpacings();
                    list3.add(positionedItem);
                }
                index$iv$iv2++;
                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext12 = $this$measure;
                pinnedItems$iv3 = pinnedItems$iv4;
                size3 = i41;
                $this$fastForEach$iv$iv3 = $this$fastForEach$iv$iv4;
                measuredItems2 = measuredItems;
                extraItemsBefore2 = extraItemsBefore;
                itemCount3 = itemCount9;
                itemCount8 = $i$f$fastForEach;
            }
            List extraItemsBefore3 = extraItemsBefore2;
            LazyLayoutPinnedItemList lazyLayoutPinnedItemList2 = pinnedItems$iv3;
            List list4 = $this$fastForEach$iv$iv3;
            int i45 = itemCount8;
            int itemCount10 = itemCount3;
            ArrayDeque[] arrayDequeArr3 = measuredItems2;
            if (list3 == null) {
                list3 = CollectionsKt.emptyList();
            }
            List extraItemsAfter = list3;
            boolean canScrollBackward = firstItemIndices[0] != 0 || firstItemOffsets[0] > 0;
            int[] $this$any$iv4 = currentItemOffsets;
            int length16 = $this$any$iv4.length;
            int i46 = 0;
            while (true) {
                if (i46 < length16) {
                    if (($this$any$iv4[i46] > $this$measure.getMainAxisAvailableSize() ? 1 : 0) != 0) {
                        z4 = true;
                    } else {
                        i46++;
                    }
                } else {
                    z4 = false;
                }
            }
            if (!z4) {
                int[] $this$all$iv4 = currentItemIndices;
                int length17 = $this$all$iv4.length;
                int i47 = 0;
                while (true) {
                    if (i47 < length17) {
                        if (($this$all$iv4[i47] < itemCount10 + -1 ? 1 : 0) == 0) {
                            z5 = false;
                        } else {
                            i47++;
                        }
                    } else {
                        z5 = true;
                    }
                }
                if (!z5) {
                    canScrollForward = false;
                    return new LazyStaggeredGridMeasureResult(firstItemIndices, firstItemOffsets, consumedScroll, MeasureScope.layout$default($this$measure_u24lambda_u2437, layoutWidth4, layoutHeight4, (Map) null, new LazyStaggeredGridMeasureKt$measure$1$29(extraItemsBefore3, positionedItems, extraItemsAfter, $this$measure), 4, (Object) null), canScrollForward, canScrollBackward, $this$measure.isVertical(), itemCount10, positionedItems, IntSizeKt.IntSize(layoutWidth4, layoutHeight4), minOffset3, maxOffset, $this$measure.getBeforeContentPadding(), $this$measure.getAfterContentPadding(), $this$measure.getMainAxisSpacing(), (DefaultConstructorMarker) null);
                }
            }
            canScrollForward = true;
            return new LazyStaggeredGridMeasureResult(firstItemIndices, firstItemOffsets, consumedScroll, MeasureScope.layout$default($this$measure_u24lambda_u2437, layoutWidth4, layoutHeight4, (Map) null, new LazyStaggeredGridMeasureKt$measure$1$29(extraItemsBefore3, positionedItems, extraItemsAfter, $this$measure), 4, (Object) null), canScrollForward, canScrollBackward, $this$measure.isVertical(), itemCount10, positionedItems, IntSizeKt.IntSize(layoutWidth4, layoutHeight4), minOffset3, maxOffset, $this$measure.getBeforeContentPadding(), $this$measure.getAfterContentPadding(), $this$measure.getMainAxisSpacing(), (DefaultConstructorMarker) null);
        }
        return new LazyStaggeredGridMeasureResult(initialItemIndices, initialItemOffsets, 0.0f, MeasureScope.layout$default($this$measure_u24lambda_u2437, Constraints.m5932getMinWidthimpl($this$measure.m1044getConstraintsmsEJaDk()), Constraints.m5931getMinHeightimpl($this$measure.m1044getConstraintsmsEJaDk()), (Map) null, LazyStaggeredGridMeasureKt$measure$1$1.INSTANCE, 4, (Object) null), false, false, $this$measure.isVertical(), itemCount, CollectionsKt.emptyList(), IntSizeKt.IntSize(Constraints.m5932getMinWidthimpl($this$measure.m1044getConstraintsmsEJaDk()), Constraints.m5931getMinHeightimpl($this$measure.m1044getConstraintsmsEJaDk())), -$this$measure.getBeforeContentPadding(), $this$measure.getMainAxisAvailableSize() + $this$measure.getAfterContentPadding(), $this$measure.getBeforeContentPadding(), $this$measure.getAfterContentPadding(), $this$measure.getMainAxisSpacing(), (DefaultConstructorMarker) null);
    }

    private static final boolean measure$lambda$37$hasSpaceBeforeFirst(int[] firstItemIndices, int[] firstItemOffsets, LazyStaggeredGridMeasureContext $this_measure) {
        int length = firstItemIndices.length;
        for (int lane = 0; lane < length; lane++) {
            int itemIndex = firstItemIndices[lane];
            if (firstItemOffsets[lane] < Math.max(-$this_measure.getMainAxisSpacing(), 0) && itemIndex > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$37$misalignedStart(int[] firstItemIndices, LazyStaggeredGridMeasureContext $this_measure, int[] firstItemOffsets, int referenceLane) {
        int lane = 0;
        int length = firstItemIndices.length;
        while (true) {
            boolean misalignedOffsets = false;
            if (lane < length) {
                if (findPreviousItemIndex($this_measure, firstItemIndices[lane], lane) == -1 && firstItemOffsets[lane] != firstItemOffsets[referenceLane]) {
                    misalignedOffsets = true;
                }
                if (misalignedOffsets) {
                    return true;
                }
                lane++;
            } else {
                int length2 = firstItemIndices.length;
                for (int lane2 = 0; lane2 < length2; lane2++) {
                    if (findPreviousItemIndex($this_measure, firstItemIndices[lane2], lane2) != -1 && firstItemOffsets[lane2] >= firstItemOffsets[referenceLane]) {
                        return true;
                    }
                }
                int firstItemLane = $this_measure.getLaneInfo().getLane(0);
                if (firstItemLane == 0 || firstItemLane == -1 || firstItemLane == -2) {
                    return false;
                }
                return true;
            }
        }
    }

    private static final List<LazyStaggeredGridPositionedItem> calculatePositionedItems(LazyStaggeredGridMeasureContext $this$calculatePositionedItems, ArrayDeque<LazyStaggeredGridMeasuredItem>[] measuredItems, int[] itemScrollOffsets, int mainAxisLayoutSize) {
        boolean z;
        int crossAxisOffset;
        ArrayDeque[] arrayDequeArr = measuredItems;
        int[] iArr = itemScrollOffsets;
        int i = 0;
        for (ArrayDeque it : arrayDequeArr) {
            i += it.size();
        }
        ArrayList positionedItems = new ArrayList(i);
        while (true) {
            ArrayDeque[] arrayDequeArr2 = measuredItems;
            int length = arrayDequeArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                }
                z = true;
                if (!arrayDequeArr2[i2].isEmpty()) {
                    break;
                }
                i2++;
            }
            if (z) {
                ArrayDeque[] arrayDequeArr3 = measuredItems;
                int result$iv = -1;
                int min$iv = Integer.MAX_VALUE;
                int length2 = arrayDequeArr3.length;
                for (int i$iv = 0; i$iv < length2; i$iv++) {
                    LazyStaggeredGridMeasuredItem firstOrNull = arrayDequeArr3[i$iv].firstOrNull();
                    int value$iv = firstOrNull != null ? firstOrNull.getIndex() : Integer.MAX_VALUE;
                    if (min$iv > value$iv) {
                        min$iv = value$iv;
                        result$iv = i$iv;
                    }
                }
                int laneIndex = result$iv;
                LazyStaggeredGridMeasuredItem item = arrayDequeArr[laneIndex].removeFirst();
                if (item.getLane() == laneIndex) {
                    long spanRange = SpanRange.m1061constructorimpl(item.getLane(), item.getSpan());
                    int mainAxisOffset = m1050maxInRangejy6DScQ(iArr, spanRange);
                    if (laneIndex == 0) {
                        crossAxisOffset = 0;
                    } else {
                        crossAxisOffset = $this$calculatePositionedItems.getResolvedSlotSums()[laneIndex - 1] + ($this$calculatePositionedItems.getCrossAxisSpacing() * laneIndex);
                    }
                    if (!item.getPlaceables().isEmpty()) {
                        positionedItems.add(item.position(laneIndex, mainAxisOffset, crossAxisOffset, mainAxisLayoutSize));
                        long $this$forEach_u2dnIS5qE8$iv = spanRange;
                        int i3 = laneIndex;
                        int i4 = (int) ($this$forEach_u2dnIS5qE8$iv & 4294967295L);
                        for (int i$iv2 = (int) ($this$forEach_u2dnIS5qE8$iv >> 32); i$iv2 < i4; i$iv2++) {
                            iArr[i$iv2] = mainAxisOffset + item.getSizeWithSpacings();
                        }
                    }
                }
            } else {
                int i5 = mainAxisLayoutSize;
                return positionedItems;
            }
        }
    }

    private static final List<LazyStaggeredGridPositionedItem> calculateExtraItems(LazyStaggeredGridMeasureContext $this$calculateExtraItems, Function1<? super LazyStaggeredGridMeasuredItem, LazyStaggeredGridPositionedItem> position, Function1<? super Integer, Boolean> filter) {
        int $i$f$calculateExtraItems;
        List $this$fastForEach$iv;
        LazyLayoutPinnedItemList pinnedItems;
        int $i$f$calculateExtraItems2 = false;
        List<LazyStaggeredGridPositionedItem> list = null;
        LazyLayoutPinnedItemList pinnedItems2 = $this$calculateExtraItems.getState().getPinnedItems$foundation_release();
        List $this$fastForEach$iv2 = pinnedItems2;
        int index$iv = 0;
        int size = $this$fastForEach$iv2.size();
        while (index$iv < size) {
            LazyLayoutPinnedItemList.PinnedItem item = (LazyLayoutPinnedItemList.PinnedItem) $this$fastForEach$iv2.get(index$iv);
            int index = LazyLayoutItemProviderKt.findIndexByKey($this$calculateExtraItems.getItemProvider(), item.getKey(), item.getIndex());
            if (filter.invoke(Integer.valueOf(index)).booleanValue()) {
                pinnedItems = pinnedItems2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
                long spanRange = $this$calculateExtraItems.m1047getSpanRangelOCCd4c($this$calculateExtraItems.getItemProvider(), index, 0);
                if (list == null) {
                    list = (List) new ArrayList();
                }
                $i$f$calculateExtraItems = $i$f$calculateExtraItems2;
                list.add(position.invoke($this$calculateExtraItems.getMeasuredItemProvider().m1055getAndMeasurejy6DScQ(index, spanRange)));
            } else {
                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = $this$calculateExtraItems;
                Function1<? super LazyStaggeredGridMeasuredItem, LazyStaggeredGridPositionedItem> function1 = position;
                $i$f$calculateExtraItems = $i$f$calculateExtraItems2;
                pinnedItems = pinnedItems2;
                $this$fastForEach$iv = $this$fastForEach$iv2;
            }
            index$iv++;
            pinnedItems2 = pinnedItems;
            $this$fastForEach$iv2 = $this$fastForEach$iv;
            $i$f$calculateExtraItems2 = $i$f$calculateExtraItems;
        }
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = $this$calculateExtraItems;
        Function1<? super LazyStaggeredGridMeasuredItem, LazyStaggeredGridPositionedItem> function12 = position;
        Function1<? super Integer, Boolean> function13 = filter;
        int i = $i$f$calculateExtraItems2;
        LazyLayoutPinnedItemList lazyLayoutPinnedItemList = pinnedItems2;
        List list2 = $this$fastForEach$iv2;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* renamed from: forEach-nIS5qE8  reason: not valid java name */
    private static final void m1049forEachnIS5qE8(long $this$forEach_u2dnIS5qE8, Function1<? super Integer, Unit> block) {
        int i = (int) (4294967295L & $this$forEach_u2dnIS5qE8);
        for (int i2 = (int) ($this$forEach_u2dnIS5qE8 >> 32); i2 < i; i2++) {
            block.invoke(Integer.valueOf(i2));
        }
    }

    private static final void offsetBy(int[] $this$offsetBy, int delta) {
        int length = $this$offsetBy.length;
        for (int i = 0; i < length; i++) {
            $this$offsetBy[i] = $this$offsetBy[i] + delta;
        }
    }

    /* renamed from: maxInRange-jy6DScQ  reason: not valid java name */
    private static final int m1050maxInRangejy6DScQ(int[] $this$maxInRange_u2djy6DScQ, long indexRange) {
        int max = Integer.MIN_VALUE;
        long $this$forEach_u2dnIS5qE8$iv = indexRange;
        int i = (int) (4294967295L & $this$forEach_u2dnIS5qE8$iv);
        for (int i$iv = (int) ($this$forEach_u2dnIS5qE8$iv >> 32); i$iv < i; i$iv++) {
            max = Math.max(max, $this$maxInRange_u2djy6DScQ[i$iv]);
        }
        return max;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    public static final int indexOfMinValue(int[] $this$indexOfMinValue, int minBound) {
        Intrinsics.checkNotNullParameter($this$indexOfMinValue, "<this>");
        int result = -1;
        int min = Integer.MAX_VALUE;
        int length = $this$indexOfMinValue.length;
        for (int i = 0; i < length; i++) {
            int i2 = minBound + 1;
            int i3 = $this$indexOfMinValue[i];
            boolean z = false;
            if (i2 <= i3 && i3 < min) {
                z = true;
            }
            if (z) {
                min = $this$indexOfMinValue[i];
                result = i;
            }
        }
        return result;
    }

    private static final <T> int indexOfMinBy(T[] $this$indexOfMinBy, Function1<? super T, Integer> block) {
        int result = -1;
        int min = Integer.MAX_VALUE;
        int length = $this$indexOfMinBy.length;
        for (int i = 0; i < length; i++) {
            int value = block.invoke($this$indexOfMinBy[i]).intValue();
            if (min > value) {
                min = value;
                result = i;
            }
        }
        return result;
    }

    private static final int indexOfMaxValue(int[] $this$indexOfMaxValue) {
        int result = -1;
        int max = Integer.MIN_VALUE;
        int length = $this$indexOfMaxValue.length;
        for (int i = 0; i < length; i++) {
            if (max < $this$indexOfMaxValue[i]) {
                max = $this$indexOfMaxValue[i];
                result = i;
            }
        }
        return result;
    }

    private static final int[] transform(int[] $this$transform, Function1<? super Integer, Integer> block) {
        int length = $this$transform.length;
        for (int i = 0; i < length; i++) {
            $this$transform[i] = block.invoke(Integer.valueOf($this$transform[i])).intValue();
        }
        return $this$transform;
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext $this$ensureIndicesInRange, int[] indices, int itemCount) {
        int length = indices.length - 1;
        if (length >= 0) {
            do {
                int i = length;
                length--;
                while (true) {
                    if (indices[i] < itemCount && $this$ensureIndicesInRange.getLaneInfo().assignedToLane(indices[i], i)) {
                        break;
                    }
                    indices[i] = findPreviousItemIndex($this$ensureIndicesInRange, indices[i], i);
                }
                if (indices[i] >= 0 && !$this$ensureIndicesInRange.isFullSpan($this$ensureIndicesInRange.getItemProvider(), indices[i])) {
                    $this$ensureIndicesInRange.getLaneInfo().setLane(indices[i], i);
                    continue;
                }
            } while (length >= 0);
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext $this$findPreviousItemIndex, int item, int lane) {
        return $this$findPreviousItemIndex.getLaneInfo().findPreviousItemIndex(item, lane);
    }
}
