package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b \b\u0017\u0018\u00002\u00020\u0001BC\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\b\u0010.\u001a\u00020\tH\u0002J\r\u0010/\u001a\u00020\tH\u0000¢\u0006\u0002\b0J'\u0010/\u001a\u0002H1\"\u0004\b\u0000\u001012\f\u00102\u001a\b\u0012\u0004\u0012\u0002H103H\bø\u0001\u0000¢\u0006\u0004\b0\u00104J\b\u00105\u001a\u000206H\u0016J\r\u00107\u001a\u00020\tH\u0010¢\u0006\u0002\b8J\b\u00109\u001a\u00020\tH\u0016J\b\u0010:\u001a\u00020\rH\u0016J3\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020\u00032\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020?\u0018\u00010>2\u0006\u0010@\u001a\u00020\u0005H\u0000¢\u0006\u0002\bAJ\u0015\u0010B\u001a\u00020\t2\u0006\u0010C\u001a\u00020\u0001H\u0010¢\u0006\u0002\bDJ\u0015\u0010E\u001a\u00020\t2\u0006\u0010C\u001a\u00020\u0001H\u0010¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020\tH\u0010¢\u0006\u0002\bHJ\u0015\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0014H\u0010¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bMJ\u0015\u0010N\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0005H\u0000¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bQJ\u0015\u0010R\u001a\u00020\t2\u0006\u0010S\u001a\u00020 H\u0000¢\u0006\u0002\bTJ\r\u0010U\u001a\u00020\tH\u0010¢\u0006\u0002\bVJ\r\u0010W\u001a\u00020\tH\u0000¢\u0006\u0002\bXJ8\u0010Y\u001a\u00020\u00002\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\u001e\u0010Z\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\r\u0010[\u001a\u00020\tH\u0000¢\u0006\u0002\b\\J\r\u0010]\u001a\u00020\tH\u0000¢\u0006\u0002\b^R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R4\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u000fR\u0014\u0010)\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&\u0002\u0007\n\u0005\b20\u0001¨\u0006_"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "applied", "", "getApplied$runtime_release", "()Z", "setApplied$runtime_release", "(Z)V", "<set-?>", "", "Landroidx/compose/runtime/snapshots/StateObject;", "modified", "getModified$runtime_release", "()Ljava/util/Set;", "setModified", "(Ljava/util/Set;)V", "previousIds", "getPreviousIds$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "previousPinnedSnapshots", "", "getPreviousPinnedSnapshots$runtime_release", "()[I", "setPreviousPinnedSnapshots$runtime_release", "([I)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "getWriteObserver$runtime_release", "abandon", "advance", "advance$runtime_release", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "closeLocked", "closeLocked$runtime_release", "dispose", "hasPendingChanges", "innerApplyLocked", "snapshotId", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "invalidSnapshots", "innerApplyLocked$runtime_release", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "recordPrevious", "recordPrevious$runtime_release", "recordPreviousList", "recordPreviousList$runtime_release", "recordPreviousPinnedSnapshot", "recordPreviousPinnedSnapshot$runtime_release", "recordPreviousPinnedSnapshots", "handles", "recordPreviousPinnedSnapshots$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "releasePreviouslyPinnedSnapshotsLocked", "releasePreviouslyPinnedSnapshotsLocked$runtime_release", "takeNestedMutableSnapshot", "takeNestedSnapshot", "validateNotApplied", "validateNotApplied$runtime_release", "validateNotAppliedOrPinned", "validateNotAppliedOrPinned$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snapshot.kt */
public class MutableSnapshot extends Snapshot {
    public static final int $stable = 8;
    private boolean applied;
    private Set<StateObject> modified;
    private SnapshotIdSet previousIds = SnapshotIdSet.Companion.getEMPTY();
    private int[] previousPinnedSnapshots = new int[0];
    private final Function1<Object, Unit> readObserver;
    private int snapshots = 1;
    private final Function1<Object, Unit> writeObserver;

    public Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutableSnapshot(int id, SnapshotIdSet invalid, Function1<Object, Unit> readObserver2, Function1<Object, Unit> writeObserver2) {
        super(id, invalid, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(invalid, "invalid");
        this.readObserver = readObserver2;
        this.writeObserver = writeObserver2;
    }

    public boolean hasPendingChanges() {
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        return modified$runtime_release != null && (modified$runtime_release.isEmpty() ^ true);
    }

    public static /* synthetic */ MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot mutableSnapshot, Function1 function1, Function1 function12, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                function1 = null;
            }
            if ((i & 2) != 0) {
                function12 = null;
            }
            return mutableSnapshot.takeNestedMutableSnapshot(function1, function12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0073, code lost:
        if (getApplied$runtime_release() != false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0079, code lost:
        if (getDisposed$runtime_release() != false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007b, code lost:
        r5 = getId();
        r7 = androidx.compose.runtime.snapshots.SnapshotKt.getLock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0085, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9 = androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId;
        androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId = r9 + 1;
        setId$runtime_release(r9);
        androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots.set(getId());
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a5, code lost:
        monitor-exit(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a6, code lost:
        setInvalid$runtime_release(androidx.compose.runtime.snapshots.SnapshotKt.addRange(getInvalid$runtime_release(), r5 + 1, getId()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c0, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006a, code lost:
        r3 = r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.runtime.snapshots.MutableSnapshot takeNestedMutableSnapshot(kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r19, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r20) {
        /*
            r18 = this;
            r18.validateNotDisposed$runtime_release()
            r18.validateNotAppliedOrPinned$runtime_release()
            r1 = r18
            r2 = 0
            int r0 = r1.getId()
            r1.recordPrevious$runtime_release(r0)
            r3 = 0
            r4 = 0
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r6 = 0
            monitor-enter(r5)
            r0 = 0
            int r7 = androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId     // Catch:{ all -> 0x00c3 }
            int r8 = r7 + 1
            androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId = r8     // Catch:{ all -> 0x00c3 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r8 = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots     // Catch:{ all -> 0x00c3 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r8 = r8.set(r7)     // Catch:{ all -> 0x00c3 }
            androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots = r8     // Catch:{ all -> 0x00c3 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r8 = r18.getInvalid$runtime_release()     // Catch:{ all -> 0x00c3 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r9 = r8.set(r7)     // Catch:{ all -> 0x00c3 }
            r15 = r18
            r15.setInvalid$runtime_release(r9)     // Catch:{ all -> 0x00c1 }
            androidx.compose.runtime.snapshots.NestedMutableSnapshot r16 = new androidx.compose.runtime.snapshots.NestedMutableSnapshot     // Catch:{ all -> 0x00c1 }
            int r9 = r18.getId()     // Catch:{ all -> 0x00c1 }
            int r9 = r9 + 1
            androidx.compose.runtime.snapshots.SnapshotIdSet r11 = androidx.compose.runtime.snapshots.SnapshotKt.addRange(r8, r9, r7)     // Catch:{ all -> 0x00c1 }
            kotlin.jvm.functions.Function1 r9 = r18.getReadObserver$runtime_release()     // Catch:{ all -> 0x00c1 }
            r10 = 4
            r12 = 0
            r13 = 0
            r14 = r19
            kotlin.jvm.functions.Function1 r12 = androidx.compose.runtime.snapshots.SnapshotKt.mergedReadObserver$default(r14, r9, r13, r10, r12)     // Catch:{ all -> 0x00c1 }
            kotlin.jvm.functions.Function1 r9 = r18.getWriteObserver$runtime_release()     // Catch:{ all -> 0x00c1 }
            r13 = r20
            kotlin.jvm.functions.Function1 r17 = androidx.compose.runtime.snapshots.SnapshotKt.mergedWriteObserver(r13, r9)     // Catch:{ all -> 0x00c1 }
            r9 = r16
            r10 = r7
            r13 = r17
            r14 = r18
            r9.<init>(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x00c1 }
            monitor-exit(r5)
            r3 = r16
            r4 = 0
            boolean r0 = r1.getApplied$runtime_release()
            if (r0 != 0) goto L_0x00bc
            boolean r0 = r1.getDisposed$runtime_release()
            if (r0 != 0) goto L_0x00bc
            int r5 = r1.getId()
            r6 = 0
            java.lang.Object r7 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r8 = 0
            monitor-enter(r7)
            r0 = 0
            int r9 = androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId     // Catch:{ all -> 0x00b9 }
            int r10 = r9 + 1
            androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId = r10     // Catch:{ all -> 0x00b9 }
            r1.setId$runtime_release(r9)     // Catch:{ all -> 0x00b9 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r9 = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots     // Catch:{ all -> 0x00b9 }
            int r10 = r1.getId()     // Catch:{ all -> 0x00b9 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r9 = r9.set(r10)     // Catch:{ all -> 0x00b9 }
            androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots = r9     // Catch:{ all -> 0x00b9 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00b9 }
            monitor-exit(r7)
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = r1.getInvalid$runtime_release()
            int r6 = r5 + 1
            int r7 = r1.getId()
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = androidx.compose.runtime.snapshots.SnapshotKt.addRange(r0, r6, r7)
            r1.setInvalid$runtime_release(r0)
            goto L_0x00bc
        L_0x00b9:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        L_0x00bc:
            androidx.compose.runtime.snapshots.MutableSnapshot r16 = (androidx.compose.runtime.snapshots.MutableSnapshot) r16
            return r16
        L_0x00c1:
            r0 = move-exception
            goto L_0x00c6
        L_0x00c3:
            r0 = move-exception
            r15 = r18
        L_0x00c6:
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.takeNestedMutableSnapshot(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):androidx.compose.runtime.snapshots.MutableSnapshot");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e8, code lost:
        r3 = (java.util.List) r1.component1();
        r1 = (java.util.Set) r1.component2();
        r14.applied = true;
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00fb, code lost:
        if (r4 == null) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0101, code lost:
        if (r4.isEmpty() == false) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0104, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0106, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0107, code lost:
        if (r4 != false) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0109, code lost:
        r4 = r3;
        r8 = 0;
        r9 = r4.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0111, code lost:
        if (r8 >= r9) goto L_0x0124;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0113, code lost:
        ((kotlin.jvm.functions.Function2) r4.get(r8)).invoke(r1, r14);
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0124, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0127, code lost:
        if (r4 == null) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x012d, code lost:
        if (r4.isEmpty() == false) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0130, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0131, code lost:
        if (r7 != false) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0133, code lost:
        r4 = r3;
        r6 = 0;
        r7 = r4.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x013b, code lost:
        if (r6 >= r7) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x013d, code lost:
        ((kotlin.jvm.functions.Function2) r4.get(r6)).invoke(r0, r14);
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x014e, code lost:
        r5 = androidx.compose.runtime.snapshots.SnapshotKt.getLock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0154, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        releasePinnedSnapshotsForCloseLocked$runtime_release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0159, code lost:
        if (r1 == null) goto L_0x0177;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x015b, code lost:
        r10 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0167, code lost:
        if (r10.hasNext() == false) goto L_0x0177;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0169, code lost:
        boolean unused = androidx.compose.runtime.snapshots.SnapshotKt.overwriteUnusedRecordsLocked((androidx.compose.runtime.snapshots.StateObject) r10.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0177, code lost:
        if (r0 == null) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0179, code lost:
        r10 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0185, code lost:
        if (r10.hasNext() == false) goto L_0x0194;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0187, code lost:
        boolean unused = androidx.compose.runtime.snapshots.SnapshotKt.overwriteUnusedRecordsLocked((androidx.compose.runtime.snapshots.StateObject) r10.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0194, code lost:
        r8 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0197, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x019d, code lost:
        return androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        /*
            r14 = this;
            java.util.Set r0 = r14.getModified$runtime_release()
            r1 = 0
            if (r0 == 0) goto L_0x0032
            java.util.concurrent.atomic.AtomicReference r2 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot
            java.lang.Object r2 = r2.get()
            java.lang.String r3 = "currentGlobalSnapshot.get()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            androidx.compose.runtime.snapshots.MutableSnapshot r2 = (androidx.compose.runtime.snapshots.MutableSnapshot) r2
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots
            java.util.concurrent.atomic.AtomicReference r4 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot
            java.lang.Object r4 = r4.get()
            androidx.compose.runtime.snapshots.GlobalSnapshot r4 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r4
            int r4 = r4.getId()
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r3.clear(r4)
            java.util.Map r2 = androidx.compose.runtime.snapshots.SnapshotKt.optimisticMerges(r2, r14, r3)
            goto L_0x0033
        L_0x0032:
            r2 = r1
        L_0x0033:
            r3 = 0
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r5 = 0
            monitor-enter(r4)
            r6 = 0
            r7 = r14
            androidx.compose.runtime.snapshots.Snapshot r7 = (androidx.compose.runtime.snapshots.Snapshot) r7     // Catch:{ all -> 0x01a1 }
            androidx.compose.runtime.snapshots.SnapshotKt.validateOpen(r7)     // Catch:{ all -> 0x01a1 }
            r7 = 1
            if (r0 == 0) goto L_0x00a2
            int r8 = r0.size()     // Catch:{ all -> 0x01a1 }
            if (r8 != 0) goto L_0x004c
            goto L_0x00a2
        L_0x004c:
            java.util.concurrent.atomic.AtomicReference r8 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot     // Catch:{ all -> 0x01a1 }
            java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x01a1 }
            androidx.compose.runtime.snapshots.GlobalSnapshot r8 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r8     // Catch:{ all -> 0x01a1 }
            int r9 = androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId     // Catch:{ all -> 0x01a1 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r10 = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots     // Catch:{ all -> 0x01a1 }
            int r11 = r8.getId()     // Catch:{ all -> 0x01a1 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r10 = r10.clear(r11)     // Catch:{ all -> 0x01a1 }
            androidx.compose.runtime.snapshots.SnapshotApplyResult r9 = r14.innerApplyLocked$runtime_release(r9, r2, r10)     // Catch:{ all -> 0x01a1 }
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r10 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE     // Catch:{ all -> 0x01a1 }
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)     // Catch:{ all -> 0x01a1 }
            if (r10 != 0) goto L_0x0076
            monitor-exit(r4)
            return r9
        L_0x0076:
            r14.closeLocked$runtime_release()     // Catch:{ all -> 0x01a1 }
            java.lang.String r10 = "previousGlobalSnapshot"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r10)     // Catch:{ all -> 0x01a1 }
            r10 = r8
            androidx.compose.runtime.snapshots.Snapshot r10 = (androidx.compose.runtime.snapshots.Snapshot) r10     // Catch:{ all -> 0x01a1 }
            kotlin.jvm.functions.Function1 r11 = androidx.compose.runtime.snapshots.SnapshotKt.emptyLambda     // Catch:{ all -> 0x01a1 }
            java.lang.Object unused = androidx.compose.runtime.snapshots.SnapshotKt.takeNewGlobalSnapshot(r10, r11)     // Catch:{ all -> 0x01a1 }
            java.util.Set r10 = r8.getModified$runtime_release()     // Catch:{ all -> 0x01a1 }
            r14.setModified(r1)     // Catch:{ all -> 0x01a1 }
            r8.setModified(r1)     // Catch:{ all -> 0x01a1 }
            java.util.List r1 = androidx.compose.runtime.snapshots.SnapshotKt.applyObservers     // Catch:{ all -> 0x01a1 }
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x01a1 }
            java.util.List r1 = kotlin.collections.CollectionsKt.toMutableList(r1)     // Catch:{ all -> 0x01a1 }
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r10)     // Catch:{ all -> 0x01a1 }
            goto L_0x00e6
        L_0x00a2:
            r14.closeLocked$runtime_release()     // Catch:{ all -> 0x01a1 }
            java.util.concurrent.atomic.AtomicReference r8 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot     // Catch:{ all -> 0x01a1 }
            java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x01a1 }
            androidx.compose.runtime.snapshots.GlobalSnapshot r8 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r8     // Catch:{ all -> 0x01a1 }
            java.lang.String r9 = "previousGlobalSnapshot"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch:{ all -> 0x01a1 }
            r9 = r8
            androidx.compose.runtime.snapshots.Snapshot r9 = (androidx.compose.runtime.snapshots.Snapshot) r9     // Catch:{ all -> 0x01a1 }
            kotlin.jvm.functions.Function1 r10 = androidx.compose.runtime.snapshots.SnapshotKt.emptyLambda     // Catch:{ all -> 0x01a1 }
            java.lang.Object unused = androidx.compose.runtime.snapshots.SnapshotKt.takeNewGlobalSnapshot(r9, r10)     // Catch:{ all -> 0x01a1 }
            java.util.Set r9 = r8.getModified$runtime_release()     // Catch:{ all -> 0x01a1 }
            if (r9 == 0) goto L_0x00de
            r10 = r9
            java.util.Collection r10 = (java.util.Collection) r10     // Catch:{ all -> 0x01a1 }
            boolean r10 = r10.isEmpty()     // Catch:{ all -> 0x01a1 }
            r10 = r10 ^ r7
            if (r10 == 0) goto L_0x00de
            java.util.List r1 = androidx.compose.runtime.snapshots.SnapshotKt.applyObservers     // Catch:{ all -> 0x01a1 }
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x01a1 }
            java.util.List r1 = kotlin.collections.CollectionsKt.toMutableList(r1)     // Catch:{ all -> 0x01a1 }
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r9)     // Catch:{ all -> 0x01a1 }
            goto L_0x00e6
        L_0x00de:
            java.util.List r10 = kotlin.collections.CollectionsKt.emptyList()     // Catch:{ all -> 0x01a1 }
            kotlin.Pair r1 = kotlin.TuplesKt.to(r10, r1)     // Catch:{ all -> 0x01a1 }
        L_0x00e6:
            monitor-exit(r4)
            java.lang.Object r3 = r1.component1()
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r1 = r1.component2()
            java.util.Set r1 = (java.util.Set) r1
            r14.applied = r7
            r4 = r1
            java.util.Collection r4 = (java.util.Collection) r4
            r5 = 0
            if (r4 == 0) goto L_0x0106
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0104
            goto L_0x0106
        L_0x0104:
            r4 = r5
            goto L_0x0107
        L_0x0106:
            r4 = r7
        L_0x0107:
            if (r4 != 0) goto L_0x0124
            r4 = r3
            r6 = 0
            r8 = 0
            int r9 = r4.size()
        L_0x0111:
            if (r8 >= r9) goto L_0x0123
            java.lang.Object r10 = r4.get(r8)
            r11 = r10
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r12 = 0
            r11.invoke(r1, r14)
            int r8 = r8 + 1
            goto L_0x0111
        L_0x0123:
        L_0x0124:
            r4 = r0
            java.util.Collection r4 = (java.util.Collection) r4
            if (r4 == 0) goto L_0x0131
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0130
            goto L_0x0131
        L_0x0130:
            r7 = r5
        L_0x0131:
            if (r7 != 0) goto L_0x014e
            r4 = r3
            r5 = 0
            r6 = 0
            int r7 = r4.size()
        L_0x013b:
            if (r6 >= r7) goto L_0x014d
            java.lang.Object r8 = r4.get(r6)
            r9 = r8
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r10 = 0
            r9.invoke(r0, r14)
            int r6 = r6 + 1
            goto L_0x013b
        L_0x014d:
        L_0x014e:
            r4 = 0
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r6 = 0
            monitor-enter(r5)
            r7 = 0
            r14.releasePinnedSnapshotsForCloseLocked$runtime_release()     // Catch:{ all -> 0x019e }
            if (r1 == 0) goto L_0x0177
            r8 = r1
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch:{ all -> 0x019e }
            r9 = 0
            java.util.Iterator r10 = r8.iterator()     // Catch:{ all -> 0x019e }
        L_0x0163:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x019e }
            if (r11 == 0) goto L_0x0176
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x019e }
            r12 = r11
            androidx.compose.runtime.snapshots.StateObject r12 = (androidx.compose.runtime.snapshots.StateObject) r12     // Catch:{ all -> 0x019e }
            r13 = 0
            boolean unused = androidx.compose.runtime.snapshots.SnapshotKt.overwriteUnusedRecordsLocked(r12)     // Catch:{ all -> 0x019e }
            goto L_0x0163
        L_0x0176:
        L_0x0177:
            if (r0 == 0) goto L_0x0197
            r8 = r0
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch:{ all -> 0x019e }
            r9 = 0
            java.util.Iterator r10 = r8.iterator()     // Catch:{ all -> 0x019e }
        L_0x0181:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x019e }
            if (r11 == 0) goto L_0x0194
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x019e }
            r12 = r11
            androidx.compose.runtime.snapshots.StateObject r12 = (androidx.compose.runtime.snapshots.StateObject) r12     // Catch:{ all -> 0x019e }
            r13 = 0
            boolean unused = androidx.compose.runtime.snapshots.SnapshotKt.overwriteUnusedRecordsLocked(r12)     // Catch:{ all -> 0x019e }
            goto L_0x0181
        L_0x0194:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x019e }
        L_0x0197:
            monitor-exit(r5)
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r4 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE
            androidx.compose.runtime.snapshots.SnapshotApplyResult r4 = (androidx.compose.runtime.snapshots.SnapshotApplyResult) r4
            return r4
        L_0x019e:
            r7 = move-exception
            monitor-exit(r5)
            throw r7
        L_0x01a1:
            r1 = move-exception
            monitor-exit(r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.apply():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    public boolean getReadOnly() {
        return false;
    }

    public Snapshot getRoot() {
        return this;
    }

    public void dispose() {
        if (!getDisposed$runtime_release()) {
            super.dispose();
            nestedDeactivated$runtime_release(this);
        }
    }

    public Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver2) {
        NestedReadonlySnapshot nestedReadonlySnapshot;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned$runtime_release();
        int previousId = getId();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            int readonlyId = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = readonlyId + 1;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(readonlyId);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(readonlyId, SnapshotKt.addRange(getInvalid$runtime_release(), previousId + 1, readonlyId), readObserver2, this);
        }
        NestedReadonlySnapshot nestedReadonlySnapshot2 = nestedReadonlySnapshot;
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int previousId$iv = getId();
            synchronized (SnapshotKt.getLock()) {
                int access$getNextSnapshotId$p = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p + 1;
                setId$runtime_release(access$getNextSnapshotId$p);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), previousId$iv + 1, getId()));
        }
        return nestedReadonlySnapshot;
    }

    public void nestedActivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.snapshots++;
    }

    public void nestedDeactivated$runtime_release(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        int i = this.snapshots;
        if (i > 0) {
            int i2 = i - 1;
            this.snapshots = i2;
            if (i2 == 0 && !this.applied) {
                abandon();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public void notifyObjectsInitialized$runtime_release() {
        if (!this.applied && !getDisposed$runtime_release()) {
            advance$runtime_release();
        }
    }

    public void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId()).andNot(this.previousIds);
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked$runtime_release();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    public final void validateNotApplied$runtime_release() {
        if (!(!this.applied)) {
            throw new IllegalStateException("Unsupported operation on a snapshot that has been applied".toString());
        }
    }

    public final void validateNotAppliedOrPinned$runtime_release() {
        boolean z = true;
        if (this.applied) {
            if ((this.pinningTrackingHandle >= 0 ? 1 : null) == null) {
                z = false;
            }
        }
        if (!z) {
            throw new IllegalStateException("Unsupported operation on a disposed or applied snapshot".toString());
        }
    }

    private final void abandon() {
        Set<StateObject> modified2 = getModified$runtime_release();
        if (modified2 != null) {
            validateNotApplied$runtime_release();
            setModified((Set<StateObject>) null);
            int id = getId();
            for (StateObject state : modified2) {
                for (StateRecord current = state.getFirstStateRecord(); current != null; current = current.getNext$runtime_release()) {
                    if (current.getSnapshotId$runtime_release() == id || CollectionsKt.contains(this.previousIds, Integer.valueOf(current.getSnapshotId$runtime_release()))) {
                        current.setSnapshotId$runtime_release(0);
                    }
                }
            }
        }
        closeAndReleasePinning$runtime_release();
    }

    public final SnapshotApplyResult innerApplyLocked$runtime_release(int snapshotId, Map<StateRecord, ? extends StateRecord> optimisticMerges, SnapshotIdSet invalidSnapshots) {
        StateRecord previous;
        StateRecord merged;
        List list;
        Pair pair;
        List list2;
        List list3;
        MutableSnapshot mutableSnapshot = this;
        Map<StateRecord, ? extends StateRecord> map = optimisticMerges;
        SnapshotIdSet snapshotIdSet = invalidSnapshots;
        Intrinsics.checkNotNullParameter(snapshotIdSet, "invalidSnapshots");
        SnapshotIdSet start = getInvalid$runtime_release().set(getId()).or(mutableSnapshot.previousIds);
        Set modified2 = getModified$runtime_release();
        Intrinsics.checkNotNull(modified2);
        List it = null;
        List list4 = null;
        for (StateObject state : modified2) {
            StateRecord first = state.getFirstStateRecord();
            StateRecord current = SnapshotKt.readable(first, snapshotId, snapshotIdSet);
            if (!(current == null || (previous = SnapshotKt.readable(first, getId(), start)) == null || Intrinsics.areEqual((Object) current, (Object) previous))) {
                StateRecord applied2 = SnapshotKt.readable(first, getId(), getInvalid$runtime_release());
                if (applied2 != null) {
                    if (map == null || (merged = (StateRecord) map.get(current)) == null) {
                        MutableSnapshot mutableSnapshot2 = mutableSnapshot;
                        merged = state.mergeRecords(previous, current, applied2);
                    }
                    if (merged == null) {
                        return new SnapshotApplyResult.Failure(mutableSnapshot);
                    }
                    if (!Intrinsics.areEqual((Object) merged, (Object) applied2)) {
                        if (Intrinsics.areEqual((Object) merged, (Object) current)) {
                            if (list4 == null) {
                                List it2 = new ArrayList();
                                List list5 = it2;
                                list2 = it2;
                                list4 = list5;
                            } else {
                                list2 = list4;
                            }
                            list4.add(TuplesKt.to(state, current.create()));
                            if (it == null) {
                                List it3 = new ArrayList();
                                it = it3;
                                list3 = it3;
                            } else {
                                list3 = it;
                            }
                            it.add(state);
                            it = list3;
                            list4 = list2;
                            mutableSnapshot = this;
                        } else {
                            if (list4 == null) {
                                List it4 = new ArrayList();
                                list4 = it4;
                                list = it4;
                            } else {
                                list = list4;
                            }
                            if (!Intrinsics.areEqual((Object) merged, (Object) previous)) {
                                pair = TuplesKt.to(state, merged);
                            } else {
                                pair = TuplesKt.to(state, previous.create());
                            }
                            list4.add(pair);
                            list4 = list;
                            mutableSnapshot = this;
                        }
                    }
                } else {
                    Void unused = SnapshotKt.readError();
                    throw new KotlinNothingValueException();
                }
            }
            mutableSnapshot = this;
        }
        int i = snapshotId;
        if (list4 != null) {
            List it5 = list4;
            advance$runtime_release();
            List $this$fastForEach$iv = it5;
            int size = $this$fastForEach$iv.size();
            int index$iv = 0;
            while (index$iv < size) {
                Pair merged2 = (Pair) $this$fastForEach$iv.get(index$iv);
                List it6 = it5;
                StateObject state2 = (StateObject) merged2.component1();
                StateRecord stateRecord = (StateRecord) merged2.component2();
                stateRecord.setSnapshotId$runtime_release(getId());
                synchronized (SnapshotKt.getLock()) {
                    stateRecord.setNext$runtime_release(state2.getFirstStateRecord());
                    state2.prependStateRecord(stateRecord);
                    Unit unit = Unit.INSTANCE;
                }
                index$iv++;
                Map<StateRecord, ? extends StateRecord> map2 = optimisticMerges;
                it5 = it6;
            }
        }
        if (it != null) {
            modified2.removeAll(it);
        }
        return SnapshotApplyResult.Success.INSTANCE;
    }

    public final <T> T advance$runtime_release(Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        recordPrevious$runtime_release(getId());
        T invoke = block.invoke();
        T t = invoke;
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int previousId = getId();
            synchronized (SnapshotKt.getLock()) {
                try {
                    int access$getNextSnapshotId$p = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p + 1;
                    setId$runtime_release(access$getNextSnapshotId$p);
                    SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), previousId + 1, getId()));
        }
        return invoke;
    }

    public final void advance$runtime_release() {
        recordPrevious$runtime_release(getId());
        Unit unit = Unit.INSTANCE;
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int previousId$iv = getId();
            synchronized (SnapshotKt.getLock()) {
                int access$getNextSnapshotId$p = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p + 1;
                setId$runtime_release(access$getNextSnapshotId$p);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                Unit unit2 = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), previousId$iv + 1, getId()));
        }
    }

    public final void recordPrevious$runtime_release(int id) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.set(id);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int id) {
        if (id >= 0) {
            this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, id);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(int[] handles) {
        Intrinsics.checkNotNullParameter(handles, "handles");
        boolean z = true;
        if (!(handles.length == 0)) {
            int[] pinned = this.previousPinnedSnapshots;
            if (pinned.length != 0) {
                z = false;
            }
            if (z) {
                this.previousPinnedSnapshots = handles;
            } else {
                this.previousPinnedSnapshots = ArraysKt.plus(pinned, handles);
            }
        }
    }

    public final void releasePreviouslyPinnedSnapshotsLocked$runtime_release() {
        for (int releasePinningLocked : this.previousPinnedSnapshots) {
            SnapshotKt.releasePinningLocked(releasePinningLocked);
        }
    }

    public final void recordPreviousList$runtime_release(SnapshotIdSet snapshots2) {
        Intrinsics.checkNotNullParameter(snapshots2, "snapshots");
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.or(snapshots2);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void recordModified$runtime_release(StateObject state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Set<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release == null) {
            HashSet it = new HashSet();
            setModified(it);
            modified$runtime_release = it;
        }
        modified$runtime_release.add(state);
    }

    public Set<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    public void setModified(Set<StateObject> set) {
        this.modified = set;
    }

    public final SnapshotIdSet getPreviousIds$runtime_release() {
        return this.previousIds;
    }

    public final void setPreviousIds$runtime_release(SnapshotIdSet snapshotIdSet) {
        Intrinsics.checkNotNullParameter(snapshotIdSet, "<set-?>");
        this.previousIds = snapshotIdSet;
    }

    public final int[] getPreviousPinnedSnapshots$runtime_release() {
        return this.previousPinnedSnapshots;
    }

    public final void setPreviousPinnedSnapshots$runtime_release(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.previousPinnedSnapshots = iArr;
    }

    public final boolean getApplied$runtime_release() {
        return this.applied;
    }

    public final void setApplied$runtime_release(boolean z) {
        this.applied = z;
    }
}
