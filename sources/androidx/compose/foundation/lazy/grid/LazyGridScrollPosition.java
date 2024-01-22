package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J#\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0005J%\u0010\u0019\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R4\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "(II)V", "hadFirstNotEmptyLayout", "", "<set-?>", "Landroidx/compose/foundation/lazy/grid/ItemIndex;", "index", "getIndex-VZbfaAc", "()I", "setIndex-YGsSkvE", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableState;", "lastKnownFirstItemKey", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "requestPosition", "", "requestPosition-yO3Fmg4", "update", "update-yO3Fmg4", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridScrollPosition.kt */
public final class LazyGridScrollPosition {
    private boolean hadFirstNotEmptyLayout;
    private final MutableState index$delegate;
    private Object lastKnownFirstItemKey;
    private final MutableState scrollOffset$delegate;

    public LazyGridScrollPosition() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public LazyGridScrollPosition(int initialIndex, int initialScrollOffset) {
        this.index$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ItemIndex.m932boximpl(ItemIndex.m934constructorimpl(initialIndex)), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.scrollOffset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(initialScrollOffset), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyGridScrollPosition(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    /* renamed from: setIndex-YGsSkvE  reason: not valid java name */
    private final void m975setIndexYGsSkvE(int i) {
        this.index$delegate.setValue(ItemIndex.m932boximpl(i));
    }

    /* renamed from: getIndex-VZbfaAc  reason: not valid java name */
    public final int m977getIndexVZbfaAc() {
        return ((ItemIndex) this.index$delegate.getValue()).m944unboximpl();
    }

    private final void setScrollOffset(int i) {
        this.scrollOffset$delegate.setValue(Integer.valueOf(i));
    }

    public final int getScrollOffset() {
        return ((Number) this.scrollOffset$delegate.getValue()).intValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r0 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) kotlin.collections.ArraysKt.firstOrNull((T[]) (r0 = r0.getItems()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateFromMeasureResult(androidx.compose.foundation.lazy.grid.LazyGridMeasureResult r11) {
        /*
            r10 = this;
            java.lang.String r0 = "measureResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r0 = r11.getFirstVisibleLine()
            if (r0 == 0) goto L_0x001f
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r0 = r0.getItems()
            if (r0 == 0) goto L_0x001f
            java.lang.Object r0 = kotlin.collections.ArraysKt.firstOrNull((T[]) r0)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r0 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r0
            if (r0 == 0) goto L_0x001f
            java.lang.Object r0 = r0.getKey()
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            r10.lastKnownFirstItemKey = r0
            boolean r0 = r10.hadFirstNotEmptyLayout
            if (r0 != 0) goto L_0x002c
            int r0 = r11.getTotalItemsCount()
            if (r0 <= 0) goto L_0x007c
        L_0x002c:
            r0 = 1
            r10.hadFirstNotEmptyLayout = r0
            int r1 = r11.getFirstVisibleLineScrollOffset()
            float r2 = (float) r1
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            r3 = 0
            if (r2 < 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r0 = r3
        L_0x003c:
            if (r0 == 0) goto L_0x0087
            androidx.compose.runtime.snapshots.Snapshot$Companion r0 = androidx.compose.runtime.snapshots.Snapshot.Companion
            r2 = 0
            androidx.compose.runtime.snapshots.Snapshot r4 = r0.createNonObservableSnapshot()
            r5 = r4
            r6 = 0
            androidx.compose.runtime.snapshots.Snapshot r7 = r5.makeCurrent()     // Catch:{ all -> 0x0082 }
            r8 = 0
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r9 = r11.getFirstVisibleLine()     // Catch:{ all -> 0x007d }
            if (r9 == 0) goto L_0x0068
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r9 = r9.getItems()     // Catch:{ all -> 0x007d }
            if (r9 == 0) goto L_0x0068
            java.lang.Object r9 = kotlin.collections.ArraysKt.firstOrNull((T[]) r9)     // Catch:{ all -> 0x007d }
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r9 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r9     // Catch:{ all -> 0x007d }
            if (r9 == 0) goto L_0x0068
            int r3 = r9.m968getIndexVZbfaAc()     // Catch:{ all -> 0x007d }
        L_0x0068:
            int r3 = androidx.compose.foundation.lazy.grid.ItemIndex.m934constructorimpl(r3)     // Catch:{ all -> 0x007d }
            r10.m976updateyO3Fmg4(r3, r1)     // Catch:{ all -> 0x007d }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007d }
            r5.restoreCurrent(r7)     // Catch:{ all -> 0x0082 }
            r4.dispose()
        L_0x007c:
            return
        L_0x007d:
            r3 = move-exception
            r5.restoreCurrent(r7)     // Catch:{ all -> 0x0082 }
            throw r3     // Catch:{ all -> 0x0082 }
        L_0x0082:
            r3 = move-exception
            r4.dispose()
            throw r3
        L_0x0087:
            r0 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "scrollOffset should be non-negative ("
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r1)
            r3 = 41
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r0 = r2.toString()
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridScrollPosition.updateFromMeasureResult(androidx.compose.foundation.lazy.grid.LazyGridMeasureResult):void");
    }

    /* renamed from: requestPosition-yO3Fmg4  reason: not valid java name */
    public final void m978requestPositionyO3Fmg4(int index, int scrollOffset) {
        m976updateyO3Fmg4(index, scrollOffset);
        this.lastKnownFirstItemKey = null;
    }

    public final void updateScrollPositionIfTheFirstItemWasMoved(LazyGridItemProvider itemProvider) {
        Snapshot previous$iv$iv;
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Snapshot snapshot$iv = Snapshot.Companion.createNonObservableSnapshot();
        Snapshot this_$iv$iv = snapshot$iv;
        try {
            previous$iv$iv = this_$iv$iv.makeCurrent();
            m976updateyO3Fmg4(ItemIndex.m934constructorimpl(LazyLayoutItemProviderKt.findIndexByKey(itemProvider, this.lastKnownFirstItemKey, m977getIndexVZbfaAc())), getScrollOffset());
            Unit unit = Unit.INSTANCE;
            this_$iv$iv.restoreCurrent(previous$iv$iv);
            snapshot$iv.dispose();
        } catch (Throwable th) {
            snapshot$iv.dispose();
            throw th;
        }
    }

    /* renamed from: update-yO3Fmg4  reason: not valid java name */
    private final void m976updateyO3Fmg4(int index, int scrollOffset) {
        if (((float) index) >= 0.0f) {
            if (!ItemIndex.m937equalsimpl0(index, m977getIndexVZbfaAc())) {
                m975setIndexYGsSkvE(index);
            }
            if (scrollOffset != getScrollOffset()) {
                setScrollOffset(scrollOffset);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("Index should be non-negative (" + index + ')').toString());
    }
}
