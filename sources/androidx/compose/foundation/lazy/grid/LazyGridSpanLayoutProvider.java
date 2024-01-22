package androidx.compose.foundation.lazy.grid;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0003+,-B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001e\u001a\u00020\u0006H\u0002ø\u0001\u0000J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006J\u001e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\b\u0010'\u001a\u00020(H\u0002J\u0016\u0010)\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;)V", "bucketSize", "", "getBucketSize", "()I", "buckets", "Ljava/util/ArrayList;", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "Lkotlin/collections/ArrayList;", "cachedBucket", "", "cachedBucketIndex", "lastLineIndex", "lastLineStartItemIndex", "lastLineStartKnownSpan", "previousDefaultSpans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "value", "slotsPerLine", "getSlotsPerLine", "setSlotsPerLine", "(I)V", "totalSize", "getTotalSize", "getDefaultSpans", "currentSlotsPerLine", "getLineConfiguration", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "lineIndex", "getLineIndexOfItem", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "itemIndex", "getLineIndexOfItem--_Ze7BM", "(I)I", "invalidateCache", "", "spanOf", "maxSpan", "Bucket", "LazyGridItemSpanScopeImpl", "LineConfiguration", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridSpanLayoutProvider.kt */
public final class LazyGridSpanLayoutProvider {
    private final ArrayList<Bucket> buckets;
    private final List<Integer> cachedBucket = new ArrayList();
    private int cachedBucketIndex = -1;
    private final LazyGridItemProvider itemProvider;
    private int lastLineIndex;
    private int lastLineStartItemIndex;
    private int lastLineStartKnownSpan;
    private List<GridItemSpan> previousDefaultSpans = CollectionsKt.emptyList();
    private int slotsPerLine;

    public LazyGridSpanLayoutProvider(LazyGridItemProvider itemProvider2) {
        Intrinsics.checkNotNullParameter(itemProvider2, "itemProvider");
        this.itemProvider = itemProvider2;
        ArrayList $this$buckets_u24lambda_u240 = new ArrayList();
        $this$buckets_u24lambda_u240.add(new Bucket(0, 0, 2, (DefaultConstructorMarker) null));
        this.buckets = $this$buckets_u24lambda_u240;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001e\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "", "firstItemIndex", "", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "(ILjava/util/List;)V", "getFirstItemIndex", "()I", "getSpans", "()Ljava/util/List;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyGridSpanLayoutProvider.kt */
    public static final class LineConfiguration {
        public static final int $stable = 8;
        private final int firstItemIndex;
        private final List<GridItemSpan> spans;

        public LineConfiguration(int firstItemIndex2, List<GridItemSpan> spans2) {
            Intrinsics.checkNotNullParameter(spans2, "spans");
            this.firstItemIndex = firstItemIndex2;
            this.spans = spans2;
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final List<GridItemSpan> getSpans() {
            return this.spans;
        }
    }

    private final int getBucketSize() {
        return ((int) Math.sqrt((((double) getTotalSize()) * 1.0d) / ((double) this.slotsPerLine))) + 1;
    }

    private final List<GridItemSpan> getDefaultSpans(int currentSlotsPerLine) {
        if (currentSlotsPerLine == this.previousDefaultSpans.size()) {
            return this.previousDefaultSpans;
        }
        ArrayList arrayList = new ArrayList(currentSlotsPerLine);
        for (int i = 0; i < currentSlotsPerLine; i++) {
            int i2 = i;
            arrayList.add(GridItemSpan.m924boximpl(LazyGridSpanKt.GridItemSpan(1)));
        }
        List it = arrayList;
        this.previousDefaultSpans = it;
        return it;
    }

    public final int getTotalSize() {
        return this.itemProvider.getItemCount();
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    public final void setSlotsPerLine(int value) {
        if (value != this.slotsPerLine) {
            this.slotsPerLine = value;
            invalidateCache();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b4 A[LOOP:0: B:33:0x00b4->B:78:0x00b4, LOOP_START, PHI: r2 r4 r5 
      PHI: (r2v6 'currentLine' int) = (r2v5 'currentLine' int), (r2v7 'currentLine' int) binds: [B:32:0x00b2, B:78:0x00b4] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v5 'currentItemIndex' int) = (r4v4 'currentItemIndex' int), (r4v8 'currentItemIndex' int) binds: [B:32:0x00b2, B:78:0x00b4] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r5v3 'knownCurrentItemSpan' int) = (r5v2 'knownCurrentItemSpan' int), (r5v10 'knownCurrentItemSpan' int) binds: [B:32:0x00b2, B:78:0x00b4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0170  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.LineConfiguration getLineConfiguration(int r14) {
        /*
            r13 = this;
            androidx.compose.foundation.lazy.grid.LazyGridItemProvider r0 = r13.itemProvider
            boolean r0 = r0.getHasCustomSpans()
            r1 = 0
            if (r0 != 0) goto L_0x0026
            int r0 = r13.slotsPerLine
            int r0 = r0 * r14
            androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration r2 = new androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration
            int r3 = r13.slotsPerLine
            int r4 = r13.getTotalSize()
            int r4 = r4 - r0
            int r3 = kotlin.ranges.RangesKt.coerceAtMost((int) r3, (int) r4)
            int r1 = kotlin.ranges.RangesKt.coerceAtLeast((int) r3, (int) r1)
            java.util.List r1 = r13.getDefaultSpans(r1)
            r2.<init>(r0, r1)
            return r2
        L_0x0026:
            int r0 = r13.getBucketSize()
            int r0 = r14 / r0
            java.util.ArrayList<androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket> r2 = r13.buckets
            int r2 = r2.size()
            r3 = 1
            int r2 = r2 - r3
            int r0 = java.lang.Math.min(r0, r2)
            int r2 = r13.getBucketSize()
            int r2 = r2 * r0
            java.util.ArrayList<androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket> r4 = r13.buckets
            java.lang.Object r4 = r4.get(r0)
            androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket r4 = (androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.Bucket) r4
            int r4 = r4.getFirstItemIndex()
            r5 = 0
            java.util.ArrayList<androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket> r6 = r13.buckets
            java.lang.Object r6 = r6.get(r0)
            androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket r6 = (androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.Bucket) r6
            int r5 = r6.getFirstItemKnownSpan()
            int r6 = r13.lastLineIndex
            if (r2 > r6) goto L_0x005e
            if (r6 > r14) goto L_0x005e
            r6 = r3
            goto L_0x005f
        L_0x005e:
            r6 = r1
        L_0x005f:
            if (r6 == 0) goto L_0x0068
            int r2 = r13.lastLineIndex
            int r4 = r13.lastLineStartItemIndex
            int r5 = r13.lastLineStartKnownSpan
            goto L_0x0086
        L_0x0068:
            int r6 = r13.cachedBucketIndex
            if (r0 != r6) goto L_0x0086
            int r6 = r14 - r2
            java.util.List<java.lang.Integer> r7 = r13.cachedBucket
            int r7 = r7.size()
            if (r6 >= r7) goto L_0x0086
            java.util.List<java.lang.Integer> r6 = r13.cachedBucket
            int r7 = r14 - r2
            java.lang.Object r6 = r6.get(r7)
            java.lang.Number r6 = (java.lang.Number) r6
            int r4 = r6.intValue()
            r2 = r14
            r5 = 0
        L_0x0086:
            int r6 = r13.getBucketSize()
            int r6 = r2 % r6
            if (r6 != 0) goto L_0x00a0
            int r6 = r13.getBucketSize()
            int r7 = r14 - r2
            r8 = 2
            if (r8 > r7) goto L_0x009b
            if (r7 >= r6) goto L_0x009b
            r6 = r3
            goto L_0x009c
        L_0x009b:
            r6 = r1
        L_0x009c:
            if (r6 == 0) goto L_0x00a0
            r6 = r3
            goto L_0x00a1
        L_0x00a0:
            r6 = r1
        L_0x00a1:
            if (r6 == 0) goto L_0x00ab
            r13.cachedBucketIndex = r0
            java.util.List<java.lang.Integer> r7 = r13.cachedBucket
            r7.clear()
        L_0x00ab:
            if (r2 > r14) goto L_0x00af
            r7 = r3
            goto L_0x00b0
        L_0x00af:
            r7 = r1
        L_0x00b0:
            java.lang.String r8 = "Check failed."
            if (r7 == 0) goto L_0x0170
        L_0x00b4:
            if (r2 >= r14) goto L_0x0129
            int r7 = r13.getTotalSize()
            if (r4 >= r7) goto L_0x0129
            if (r6 == 0) goto L_0x00c7
            java.util.List<java.lang.Integer> r7 = r13.cachedBucket
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            r7.add(r9)
        L_0x00c7:
            r7 = 0
        L_0x00c8:
            int r9 = r13.slotsPerLine
            if (r7 >= r9) goto L_0x00f0
            int r9 = r13.getTotalSize()
            if (r4 >= r9) goto L_0x00f0
            if (r5 != 0) goto L_0x00df
            int r9 = r13.slotsPerLine
            int r9 = r9 - r7
            int r9 = r13.spanOf(r4, r9)
            r12 = r9
            r9 = r5
            r5 = r12
            goto L_0x00e2
        L_0x00df:
            r9 = r5
            r10 = 0
            r9 = 0
        L_0x00e2:
            int r10 = r7 + r5
            int r11 = r13.slotsPerLine
            if (r10 <= r11) goto L_0x00eb
            r9 = r5
            goto L_0x00f0
        L_0x00eb:
            int r4 = r4 + 1
            int r7 = r7 + r5
            r5 = r9
            goto L_0x00c8
        L_0x00f0:
            int r2 = r2 + 1
            int r9 = r13.getBucketSize()
            int r9 = r2 % r9
            if (r9 != 0) goto L_0x00b4
            int r9 = r13.getTotalSize()
            if (r4 >= r9) goto L_0x00b4
            int r9 = r13.getBucketSize()
            int r9 = r2 / r9
            java.util.ArrayList<androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket> r10 = r13.buckets
            int r10 = r10.size()
            if (r10 != r9) goto L_0x0111
            r10 = r3
            goto L_0x0112
        L_0x0111:
            r10 = r1
        L_0x0112:
            if (r10 == 0) goto L_0x011f
            java.util.ArrayList<androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket> r10 = r13.buckets
            androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket r11 = new androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket
            r11.<init>(r4, r5)
            r10.add(r11)
            goto L_0x00b4
        L_0x011f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r3 = r8.toString()
            r1.<init>(r3)
            throw r1
        L_0x0129:
            r13.lastLineIndex = r14
            r13.lastLineStartItemIndex = r4
            r13.lastLineStartKnownSpan = r5
            r1 = r4
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
            r7 = 0
        L_0x0138:
            int r8 = r13.slotsPerLine
            if (r7 >= r8) goto L_0x016a
            int r8 = r13.getTotalSize()
            if (r4 >= r8) goto L_0x016a
            if (r5 != 0) goto L_0x014f
            int r8 = r13.slotsPerLine
            int r8 = r8 - r7
            int r8 = r13.spanOf(r4, r8)
            r12 = r8
            r8 = r5
            r5 = r12
            goto L_0x0152
        L_0x014f:
            r8 = r5
            r9 = 0
            r8 = 0
        L_0x0152:
            int r9 = r7 + r5
            int r10 = r13.slotsPerLine
            if (r9 > r10) goto L_0x0169
            int r4 = r4 + 1
            long r9 = androidx.compose.foundation.lazy.grid.LazyGridSpanKt.GridItemSpan(r5)
            androidx.compose.foundation.lazy.grid.GridItemSpan r9 = androidx.compose.foundation.lazy.grid.GridItemSpan.m924boximpl(r9)
            r3.add(r9)
            int r7 = r7 + r5
            r5 = r8
            goto L_0x0138
        L_0x0169:
            r5 = r8
        L_0x016a:
            androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration r8 = new androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration
            r8.<init>(r1, r3)
            return r8
        L_0x0170:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r3 = r8.toString()
            r1.<init>(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.getLineConfiguration(int):androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration");
    }

    /* renamed from: getLineIndexOfItem--_Ze7BM  reason: not valid java name */
    public final int m979getLineIndexOfItem_Ze7BM(int itemIndex) {
        if (getTotalSize() <= 0) {
            return LineIndex.m988constructorimpl(0);
        }
        if (!(itemIndex < getTotalSize())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!this.itemProvider.getHasCustomSpans()) {
            return LineIndex.m988constructorimpl(itemIndex / this.slotsPerLine);
        } else {
            int it = CollectionsKt.binarySearch$default((List) this.buckets, 0, 0, (Function1) new LazyGridSpanLayoutProvider$getLineIndexOfItem$lowerBoundBucket$1(itemIndex), 3, (Object) null);
            if (it < 0) {
                it = (-it) - 2;
            }
            int currentLine = getBucketSize() * it;
            int span = this.buckets.get(it).getFirstItemIndex();
            if (span <= itemIndex) {
                int spansUsed = 0;
                while (span < itemIndex) {
                    int currentItemIndex = span + 1;
                    int span2 = spanOf(span, this.slotsPerLine - spansUsed);
                    int i = spansUsed + span2;
                    int i2 = this.slotsPerLine;
                    if (i < i2) {
                        spansUsed += span2;
                    } else if (spansUsed + span2 == i2) {
                        currentLine++;
                        spansUsed = 0;
                    } else {
                        currentLine++;
                        spansUsed = span2;
                    }
                    if (currentLine % getBucketSize() == 0 && currentLine / getBucketSize() >= this.buckets.size()) {
                        this.buckets.add(new Bucket(currentItemIndex - (spansUsed > 0 ? 1 : 0), 0, 2, (DefaultConstructorMarker) null));
                    }
                    span = currentItemIndex;
                }
                if (spanOf(itemIndex, this.slotsPerLine - spansUsed) + spansUsed > this.slotsPerLine) {
                    currentLine++;
                }
                return LineIndex.m988constructorimpl(currentLine);
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final int spanOf(int itemIndex, int maxSpan) {
        LazyGridItemProvider $this$spanOf_u24lambda_u247 = this.itemProvider;
        LazyGridItemSpanScopeImpl $this$spanOf_u24lambda_u247_u24lambda_u246 = LazyGridItemSpanScopeImpl.INSTANCE;
        $this$spanOf_u24lambda_u247_u24lambda_u246.setMaxCurrentLineSpan(maxSpan);
        $this$spanOf_u24lambda_u247_u24lambda_u246.setMaxLineSpan(this.slotsPerLine);
        return RangesKt.coerceIn(GridItemSpan.m928getCurrentLineSpanimpl($this$spanOf_u24lambda_u247.m958getSpan_orMbw($this$spanOf_u24lambda_u247_u24lambda_u246, itemIndex)), 1, this.slotsPerLine);
    }

    private final void invalidateCache() {
        this.buckets.clear();
        this.buckets.add(new Bucket(0, 0, 2, (DefaultConstructorMarker) null));
        this.lastLineIndex = 0;
        this.lastLineStartItemIndex = 0;
        this.lastLineStartKnownSpan = 0;
        this.cachedBucketIndex = -1;
        this.cachedBucket.clear();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "", "firstItemIndex", "", "firstItemKnownSpan", "(II)V", "getFirstItemIndex", "()I", "getFirstItemKnownSpan", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyGridSpanLayoutProvider.kt */
    private static final class Bucket {
        private final int firstItemIndex;
        private final int firstItemKnownSpan;

        public Bucket(int firstItemIndex2, int firstItemKnownSpan2) {
            this.firstItemIndex = firstItemIndex2;
            this.firstItemKnownSpan = firstItemKnownSpan2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Bucket(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? 0 : i2);
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final int getFirstItemKnownSpan() {
            return this.firstItemKnownSpan;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LazyGridItemSpanScopeImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "()V", "maxCurrentLineSpan", "", "getMaxCurrentLineSpan", "()I", "setMaxCurrentLineSpan", "(I)V", "maxLineSpan", "getMaxLineSpan", "setMaxLineSpan", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LazyGridSpanLayoutProvider.kt */
    private static final class LazyGridItemSpanScopeImpl implements LazyGridItemSpanScope {
        public static final LazyGridItemSpanScopeImpl INSTANCE = new LazyGridItemSpanScopeImpl();
        private static int maxCurrentLineSpan;
        private static int maxLineSpan;

        private LazyGridItemSpanScopeImpl() {
        }

        public int getMaxCurrentLineSpan() {
            return maxCurrentLineSpan;
        }

        public void setMaxCurrentLineSpan(int i) {
            maxCurrentLineSpan = i;
        }

        public int getMaxLineSpan() {
            return maxLineSpan;
        }

        public void setMaxLineSpan(int i) {
            maxLineSpan = i;
        }
    }
}
