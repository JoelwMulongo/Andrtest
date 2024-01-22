package androidx.compose.runtime.snapshots;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u000fJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u0011J\r\u0010\u0012\u001a\u00020\nH\u0010¢\u0006\u0002\b\u0013J4\u0010\u0014\u001a\u00020\u00012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n\u0018\u00010\u00162\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016H\u0016J\u001e\u0010\u0019\u001a\u00020\u000e2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016H\u0016¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "dispose", "", "nestedActivated", "", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "takeNestedMutableSnapshot", "readObserver", "Lkotlin/Function1;", "", "writeObserver", "takeNestedSnapshot", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snapshot.kt */
public final class GlobalSnapshot extends MutableSnapshot {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GlobalSnapshot(int r9, androidx.compose.runtime.snapshots.SnapshotIdSet r10) {
        /*
            r8 = this;
            java.lang.String r0 = "invalid"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 0
            java.lang.Object r1 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r2 = 0
            monitor-enter(r1)
            r3 = 0
            java.util.List r4 = androidx.compose.runtime.snapshots.SnapshotKt.globalWriteObservers     // Catch:{ all -> 0x0049 }
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ all -> 0x0049 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0049 }
            r4 = r4 ^ 1
            r5 = 0
            if (r4 == 0) goto L_0x002b
            java.util.List r4 = androidx.compose.runtime.snapshots.SnapshotKt.globalWriteObservers     // Catch:{ all -> 0x0049 }
            java.util.Collection r4 = (java.util.Collection) r4     // Catch:{ all -> 0x0049 }
            java.util.List r4 = kotlin.collections.CollectionsKt.toMutableList(r4)     // Catch:{ all -> 0x0049 }
            goto L_0x002c
        L_0x002b:
            r4 = r5
        L_0x002c:
            if (r4 == 0) goto L_0x0042
            r6 = 0
            java.lang.Object r7 = kotlin.collections.CollectionsKt.singleOrNull(r4)     // Catch:{ all -> 0x0049 }
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7     // Catch:{ all -> 0x0049 }
            if (r7 != 0) goto L_0x0041
            androidx.compose.runtime.snapshots.GlobalSnapshot$1$1$1 r7 = new androidx.compose.runtime.snapshots.GlobalSnapshot$1$1$1     // Catch:{ all -> 0x0049 }
            r7.<init>(r4)     // Catch:{ all -> 0x0049 }
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7     // Catch:{ all -> 0x0049 }
        L_0x0041:
            goto L_0x0043
        L_0x0042:
            r7 = r5
        L_0x0043:
            monitor-exit(r1)
            r8.<init>(r9, r10, r5, r7)
            return
        L_0x0049:
            r3 = move-exception
            monitor-exit(r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.GlobalSnapshot.<init>(int, androidx.compose.runtime.snapshots.SnapshotIdSet):void");
    }

    public Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver) {
        return SnapshotKt.takeNewSnapshot(new GlobalSnapshot$takeNestedSnapshot$1(readObserver));
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver) {
        return (MutableSnapshot) SnapshotKt.takeNewSnapshot(new GlobalSnapshot$takeNestedMutableSnapshot$1(readObserver, writeObserver));
    }

    public void notifyObjectsInitialized$runtime_release() {
        SnapshotKt.advanceGlobalSnapshot();
    }

    public Void nestedDeactivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public Void nestedActivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public SnapshotApplyResult apply() {
        throw new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot".toString());
    }

    public void dispose() {
        synchronized (SnapshotKt.getLock()) {
            releasePinnedSnapshotLocked$runtime_release();
            Unit unit = Unit.INSTANCE;
        }
    }
}
