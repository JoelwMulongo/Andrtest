package androidx.compose.runtime.snapshots;

import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016J\b\u0010,\u001a\u00020\tH\u0016J\u0015\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0010¢\u0006\u0002\b1J\u0015\u00102\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0010¢\u0006\u0002\b3J\r\u00104\u001a\u00020\u0006H\u0010¢\u0006\u0002\b5J\u0015\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u001dH\u0010¢\u0006\u0002\b8J4\u00109\u001a\u00020\u00012\u0014\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016J\u001e\u0010<\u001a\u0002002\u0014\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016R\u0014\u0010\f\u001a\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108V@PX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u00168P@PX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R4\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8P@VX\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\"\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'¨\u0006="}, d2 = {"Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "previousSnapshot", "specifiedReadObserver", "Lkotlin/Function1;", "", "", "specifiedWriteObserver", "mergeParentObservers", "", "ownsPreviousSnapshot", "(Landroidx/compose/runtime/snapshots/MutableSnapshot;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZZ)V", "currentSnapshot", "getCurrentSnapshot", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "value", "", "id", "getId", "()I", "setId$runtime_release", "(I)V", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "getInvalid$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "", "Landroidx/compose/runtime/snapshots/StateObject;", "modified", "getModified$runtime_release", "()Ljava/util/Set;", "setModified", "(Ljava/util/Set;)V", "readOnly", "getReadOnly", "()Z", "getSpecifiedReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "getSpecifiedWriteObserver$runtime_release", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "dispose", "hasPendingChanges", "nestedActivated", "", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "takeNestedMutableSnapshot", "readObserver", "writeObserver", "takeNestedSnapshot", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snapshot.kt */
public final class TransparentObserverMutableSnapshot extends MutableSnapshot {
    private final boolean mergeParentObservers;
    private final boolean ownsPreviousSnapshot;
    private final MutableSnapshot previousSnapshot;
    private final Function1<Object, Unit> specifiedReadObserver;
    private final Function1<Object, Unit> specifiedWriteObserver;

    public final Function1<Object, Unit> getSpecifiedReadObserver$runtime_release() {
        return this.specifiedReadObserver;
    }

    public final Function1<Object, Unit> getSpecifiedWriteObserver$runtime_release() {
        return this.specifiedWriteObserver;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r1 = r5.getReadObserver$runtime_release();
     */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TransparentObserverMutableSnapshot(androidx.compose.runtime.snapshots.MutableSnapshot r5, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r6, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r7, boolean r8, boolean r9) {
        /*
            r4 = this;
            androidx.compose.runtime.snapshots.SnapshotIdSet$Companion r0 = androidx.compose.runtime.snapshots.SnapshotIdSet.Companion
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = r0.getEMPTY()
            if (r5 == 0) goto L_0x0011
            kotlin.jvm.functions.Function1 r1 = r5.getReadObserver$runtime_release()
            if (r1 != 0) goto L_0x001f
        L_0x0011:
            java.util.concurrent.atomic.AtomicReference r1 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot
            java.lang.Object r1 = r1.get()
            androidx.compose.runtime.snapshots.GlobalSnapshot r1 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r1
            kotlin.jvm.functions.Function1 r1 = r1.getReadObserver$runtime_release()
        L_0x001f:
            kotlin.jvm.functions.Function1 r1 = androidx.compose.runtime.snapshots.SnapshotKt.mergedReadObserver(r6, r1, r8)
            if (r5 == 0) goto L_0x002d
            kotlin.jvm.functions.Function1 r2 = r5.getWriteObserver$runtime_release()
            if (r2 != 0) goto L_0x003b
        L_0x002d:
            java.util.concurrent.atomic.AtomicReference r2 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot
            java.lang.Object r2 = r2.get()
            androidx.compose.runtime.snapshots.GlobalSnapshot r2 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r2
            kotlin.jvm.functions.Function1 r2 = r2.getWriteObserver$runtime_release()
        L_0x003b:
            kotlin.jvm.functions.Function1 r2 = androidx.compose.runtime.snapshots.SnapshotKt.mergedWriteObserver(r7, r2)
            r3 = 0
            r4.<init>(r3, r0, r1, r2)
            r4.previousSnapshot = r5
            r4.specifiedReadObserver = r6
            r4.specifiedWriteObserver = r7
            r4.mergeParentObservers = r8
            r4.ownsPreviousSnapshot = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.TransparentObserverMutableSnapshot.<init>(androidx.compose.runtime.snapshots.MutableSnapshot, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, boolean):void");
    }

    private final MutableSnapshot getCurrentSnapshot() {
        MutableSnapshot mutableSnapshot = this.previousSnapshot;
        if (mutableSnapshot != null) {
            return mutableSnapshot;
        }
        Object obj = SnapshotKt.currentGlobalSnapshot.get();
        Intrinsics.checkNotNullExpressionValue(obj, "currentGlobalSnapshot.get()");
        return (MutableSnapshot) obj;
    }

    public void dispose() {
        MutableSnapshot mutableSnapshot;
        setDisposed$runtime_release(true);
        if (this.ownsPreviousSnapshot && (mutableSnapshot = this.previousSnapshot) != null) {
            mutableSnapshot.dispose();
        }
    }

    public int getId() {
        return getCurrentSnapshot().getId();
    }

    public void setId$runtime_release(int value) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public SnapshotIdSet getInvalid$runtime_release() {
        return getCurrentSnapshot().getInvalid$runtime_release();
    }

    public void setInvalid$runtime_release(SnapshotIdSet value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public boolean hasPendingChanges() {
        return getCurrentSnapshot().hasPendingChanges();
    }

    public Set<StateObject> getModified$runtime_release() {
        return getCurrentSnapshot().getModified$runtime_release();
    }

    public void setModified(Set<StateObject> value) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public boolean getReadOnly() {
        return getCurrentSnapshot().getReadOnly();
    }

    public SnapshotApplyResult apply() {
        return getCurrentSnapshot().apply();
    }

    public void recordModified$runtime_release(StateObject state) {
        Intrinsics.checkNotNullParameter(state, "state");
        getCurrentSnapshot().recordModified$runtime_release(state);
    }

    public Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver) {
        Function1 mergedReadObserver = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver$runtime_release(), false, 4, (Object) null);
        if (!this.mergeParentObservers) {
            return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(getCurrentSnapshot().takeNestedSnapshot((Function1<Object, Unit>) null), mergedReadObserver, true);
        }
        return getCurrentSnapshot().takeNestedSnapshot(mergedReadObserver);
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver) {
        Function1 mergedReadObserver = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver$runtime_release(), false, 4, (Object) null);
        Function1 mergedWriteObserver = SnapshotKt.mergedWriteObserver(writeObserver, getWriteObserver$runtime_release());
        if (!this.mergeParentObservers) {
            return new TransparentObserverMutableSnapshot(getCurrentSnapshot().takeNestedMutableSnapshot((Function1<Object, Unit>) null, mergedWriteObserver), mergedReadObserver, mergedWriteObserver, false, true);
        }
        return getCurrentSnapshot().takeNestedMutableSnapshot(mergedReadObserver, mergedWriteObserver);
    }

    public void notifyObjectsInitialized$runtime_release() {
        getCurrentSnapshot().notifyObjectsInitialized$runtime_release();
    }

    public Void nestedActivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public Void nestedDeactivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }
}
