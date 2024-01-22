package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J#\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0005J%\u0010\u0019\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R4\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "(II)V", "hadFirstNotEmptyLayout", "", "<set-?>", "Landroidx/compose/foundation/lazy/DataIndex;", "index", "getIndex-jQJCoq8", "()I", "setIndex-ZjPyQlc", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableState;", "lastKnownFirstItemKey", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "requestPosition", "", "requestPosition-AhXoVpI", "update", "update-AhXoVpI", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListScrollPosition.kt */
public final class LazyListScrollPosition {
    private boolean hadFirstNotEmptyLayout;
    private final MutableState index$delegate;
    private Object lastKnownFirstItemKey;
    private final MutableState scrollOffset$delegate;

    public LazyListScrollPosition() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public LazyListScrollPosition(int initialIndex, int initialScrollOffset) {
        this.index$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DataIndex.m881boximpl(DataIndex.m883constructorimpl(initialIndex)), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.scrollOffset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(initialScrollOffset), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyListScrollPosition(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    /* renamed from: getIndex-jQJCoq8  reason: not valid java name */
    public final int m912getIndexjQJCoq8() {
        return ((DataIndex) this.index$delegate.getValue()).m893unboximpl();
    }

    /* renamed from: setIndex-ZjPyQlc  reason: not valid java name */
    public final void m914setIndexZjPyQlc(int i) {
        this.index$delegate.setValue(DataIndex.m881boximpl(i));
    }

    private final void setScrollOffset(int i) {
        this.scrollOffset$delegate.setValue(Integer.valueOf(i));
    }

    public final int getScrollOffset() {
        return ((Number) this.scrollOffset$delegate.getValue()).intValue();
    }

    public final void updateFromMeasureResult(LazyListMeasureResult measureResult) {
        Snapshot previous$iv$iv;
        Intrinsics.checkNotNullParameter(measureResult, "measureResult");
        LazyMeasuredItem firstVisibleItem = measureResult.getFirstVisibleItem();
        this.lastKnownFirstItemKey = firstVisibleItem != null ? firstVisibleItem.getKey() : null;
        if (this.hadFirstNotEmptyLayout || measureResult.getTotalItemsCount() > 0) {
            boolean z = true;
            this.hadFirstNotEmptyLayout = true;
            int scrollOffset = measureResult.getFirstVisibleItemScrollOffset();
            int i = 0;
            if (((float) scrollOffset) < 0.0f) {
                z = false;
            }
            if (z) {
                Snapshot snapshot$iv = Snapshot.Companion.createNonObservableSnapshot();
                Snapshot this_$iv$iv = snapshot$iv;
                try {
                    previous$iv$iv = this_$iv$iv.makeCurrent();
                    LazyMeasuredItem firstVisibleItem2 = measureResult.getFirstVisibleItem();
                    if (firstVisibleItem2 != null) {
                        i = firstVisibleItem2.getIndex();
                    }
                    m911updateAhXoVpI(DataIndex.m883constructorimpl(i), scrollOffset);
                    Unit unit = Unit.INSTANCE;
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    snapshot$iv.dispose();
                } catch (Throwable th) {
                    snapshot$iv.dispose();
                    throw th;
                }
            } else {
                throw new IllegalStateException(("scrollOffset should be non-negative (" + scrollOffset + ')').toString());
            }
        }
    }

    /* renamed from: requestPosition-AhXoVpI  reason: not valid java name */
    public final void m913requestPositionAhXoVpI(int index, int scrollOffset) {
        m911updateAhXoVpI(index, scrollOffset);
        this.lastKnownFirstItemKey = null;
    }

    public final void updateScrollPositionIfTheFirstItemWasMoved(LazyListItemProvider itemProvider) {
        Snapshot previous$iv$iv;
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Snapshot snapshot$iv = Snapshot.Companion.createNonObservableSnapshot();
        Snapshot this_$iv$iv = snapshot$iv;
        try {
            previous$iv$iv = this_$iv$iv.makeCurrent();
            m911updateAhXoVpI(DataIndex.m883constructorimpl(LazyLayoutItemProviderKt.findIndexByKey(itemProvider, this.lastKnownFirstItemKey, m912getIndexjQJCoq8())), getScrollOffset());
            Unit unit = Unit.INSTANCE;
            this_$iv$iv.restoreCurrent(previous$iv$iv);
            snapshot$iv.dispose();
        } catch (Throwable th) {
            snapshot$iv.dispose();
            throw th;
        }
    }

    /* renamed from: update-AhXoVpI  reason: not valid java name */
    private final void m911updateAhXoVpI(int index, int scrollOffset) {
        if (((float) index) >= 0.0f) {
            if (!DataIndex.m886equalsimpl0(index, m912getIndexjQJCoq8())) {
                m914setIndexZjPyQlc(index);
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
