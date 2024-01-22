package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001NB\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001a\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010!\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J)\u0010%\u001a\u00020\u001b2\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'H\bJ\u0016\u0010)\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001dJ\u0016\u0010*\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010+\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010,J\u0015\u0010-\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u001bH\u0016J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0002J\u0015\u00102\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010.J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0016J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000042\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J.\u00105\u001a\u0002H6\"\u0004\b\u0001\u001062\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u0002H60'H\b¢\u0006\u0002\u00107J\"\u00108\u001a\u00020\u001b2\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u001b0'H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u000bH\u0016J\u0015\u0010;\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010<\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0015\u0010=\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010,J\u0016\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010J\u0016\u0010A\u001a\u00020\u001b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J+\u0010B\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0010H\u0000¢\u0006\u0002\bEJ\u001e\u0010F\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010GJ\u001e\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u0010H\u0016J\f\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006J)\u0010J\u001a\u00020\u001e2\u001e\u0010&\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(0'H\bJ3\u0010K\u001a\u0002H6\"\u0004\b\u0001\u001062\u001d\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u0002H60'¢\u0006\u0002\bLH\b¢\u0006\u0002\u00107J3\u0010M\u001a\u0002H6\"\u0004\b\u0001\u001062\u001d\u0010&\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0004\u0012\u0002H60'¢\u0006\u0002\bLH\b¢\u0006\u0002\u00107R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068AX\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00148@X\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012¨\u0006O"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList;", "T", "", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/List;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "size", "getSize", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "conditionalUpdate", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "mutate", "R", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "mutateBoolean", "prependStateRecord", "value", "remove", "removeAll", "removeAt", "removeRange", "fromIndex", "toIndex", "retainAll", "retainAllInRange", "start", "end", "retainAllInRange$runtime_release", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "toList", "update", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateListStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateList.kt */
public final class SnapshotStateList<T> implements List<T>, StateObject, KMutableList {
    public static final int $stable = 0;
    private StateRecord firstStateRecord = new StateListStateRecord(ExtensionsKt.persistentListOf());

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    public final /* bridge */ T remove(int index) {
        return removeAt(index);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        value.setNext$runtime_release(getFirstStateRecord());
        this.firstStateRecord = (StateListStateRecord) value;
    }

    public final List<T> toList() {
        return getReadable$runtime_release().getList$runtime_release();
    }

    public final int getModification$runtime_release() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2)).getModification$runtime_release();
    }

    public final StateListStateRecord<T> getReadable$runtime_release() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (StateListStateRecord) SnapshotKt.readable((StateListStateRecord) firstStateRecord2, this);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "list", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "getList$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "setList$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnapshotStateList.kt */
    public static final class StateListStateRecord<T> extends StateRecord {
        private PersistentList<? extends T> list;
        private int modification;

        public final PersistentList<T> getList$runtime_release() {
            return this.list;
        }

        public final void setList$runtime_release(PersistentList<? extends T> persistentList) {
            Intrinsics.checkNotNullParameter(persistentList, "<set-?>");
            this.list = persistentList;
        }

        public StateListStateRecord(PersistentList<? extends T> list2) {
            Intrinsics.checkNotNullParameter(list2, "list");
            this.list = list2;
        }

        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setModification$runtime_release(int i) {
            this.modification = i;
        }

        public void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            synchronized (SnapshotStateListKt.sync) {
                this.list = ((StateListStateRecord) value).list;
                this.modification = ((StateListStateRecord) value).modification;
                Unit unit = Unit.INSTANCE;
            }
        }

        public StateRecord create() {
            return new StateListStateRecord(this.list);
        }
    }

    public int getSize() {
        return getReadable$runtime_release().getList$runtime_release().size();
    }

    public boolean contains(Object element) {
        return getReadable$runtime_release().getList$runtime_release().contains(element);
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return getReadable$runtime_release().getList$runtime_release().containsAll(elements);
    }

    public T get(int index) {
        return getReadable$runtime_release().getList$runtime_release().get(index);
    }

    public int indexOf(Object element) {
        return getReadable$runtime_release().getList$runtime_release().indexOf(element);
    }

    public boolean isEmpty() {
        return getReadable$runtime_release().getList$runtime_release().isEmpty();
    }

    public Iterator<T> iterator() {
        return listIterator();
    }

    public int lastIndexOf(Object element) {
        return getReadable$runtime_release().getList$runtime_release().lastIndexOf(element);
    }

    public ListIterator<T> listIterator() {
        return new StateListIterator<>(this, 0);
    }

    public ListIterator<T> listIterator(int index) {
        return new StateListIterator<>(this, index);
    }

    public List<T> subList(int fromIndex, int toIndex) {
        boolean z = true;
        if (!(fromIndex >= 0 && fromIndex <= toIndex) || toIndex > size()) {
            z = false;
        }
        if (z) {
            return new SubList<>(this, fromIndex, toIndex);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public boolean add(androidx.compose.runtime.snapshots.Snapshot r26) {
        /*
            r25 = this;
            r1 = r25
            r2 = 0
            r3 = r1
            androidx.compose.runtime.snapshots.SnapshotStateList r3 = (androidx.compose.runtime.snapshots.SnapshotStateList) r3
            r4 = 0
            r5 = 0
        L_0x0008:
            r6 = 0
            r7 = 0
            java.lang.Object r8 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r9 = 0
            monitor-enter(r8)
            r0 = 0
            r10 = r3
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = r10.getFirstStateRecord()     // Catch:{ all -> 0x00f7 }
            java.lang.String r13 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r13)     // Catch:{ all -> 0x00f7 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r12     // Catch:{ all -> 0x00f7 }
            androidx.compose.runtime.snapshots.StateRecord r12 = (androidx.compose.runtime.snapshots.StateRecord) r12     // Catch:{ all -> 0x00f7 }
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r14 = androidx.compose.runtime.snapshots.SnapshotKt.current(r12)     // Catch:{ all -> 0x00f7 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r14 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r14     // Catch:{ all -> 0x00f7 }
            r15 = 0
            r10 = r14
            int r11 = r10.getModification$runtime_release()     // Catch:{ all -> 0x00f7 }
            r7 = r11
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r11 = r10.getList$runtime_release()     // Catch:{ all -> 0x00f7 }
            r6 = r11
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f7 }
            monitor-exit(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r0 = r6
            r8 = 0
            r10 = r26
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r0.add(r10)
            r8 = r0
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r6)
            if (r0 == 0) goto L_0x0055
            r0 = 0
            r22 = r1
            r23 = r2
            goto L_0x00cb
        L_0x0055:
            java.lang.Object r9 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r11 = 0
            monitor-enter(r9)
            r12 = 0
            r13 = r3
            r14 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r13.getFirstStateRecord()     // Catch:{ all -> 0x00f0 }
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r15)     // Catch:{ all -> 0x00f0 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00f0 }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x00f0 }
            r15 = r0
            r16 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r17 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x00f0 }
            r18 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x00f0 }
            r19 = r0
            r20 = 0
            monitor-enter(r19)     // Catch:{ all -> 0x00f0 }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r21 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00e7 }
            androidx.compose.runtime.snapshots.Snapshot r21 = r21.getCurrent()     // Catch:{ all -> 0x00e7 }
            r17 = r21
            r21 = r0
            r0 = r13
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00df }
            r22 = r1
            r1 = r17
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r15, r0, r1)     // Catch:{ all -> 0x00d9 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00d9 }
            r17 = 0
            r23 = r2
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00d5 }
            if (r2 != r7) goto L_0x00b0
            r0.setList$runtime_release(r8)     // Catch:{ all -> 0x00d5 }
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00d5 }
            r24 = 1
            int r2 = r2 + 1
            r0.setModification$runtime_release(r2)     // Catch:{ all -> 0x00d5 }
            goto L_0x00b2
        L_0x00b0:
            r24 = 0
        L_0x00b2:
            monitor-exit(r19)     // Catch:{ all -> 0x00ee }
            r0 = r24
            r2 = 0
            r17 = r0
            r0 = r13
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00ee }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r0)     // Catch:{ all -> 0x00ee }
            monitor-exit(r9)
            if (r24 == 0) goto L_0x00cf
            r0 = 1
        L_0x00cb:
            return r0
        L_0x00cf:
            r1 = r22
            r2 = r23
            goto L_0x0008
        L_0x00d5:
            r0 = move-exception
            r17 = r1
            goto L_0x00ec
        L_0x00d9:
            r0 = move-exception
            r23 = r2
            r17 = r1
            goto L_0x00ec
        L_0x00df:
            r0 = move-exception
            r22 = r1
            r23 = r2
            r1 = r17
            goto L_0x00ec
        L_0x00e7:
            r0 = move-exception
            r22 = r1
            r23 = r2
        L_0x00ec:
            monitor-exit(r19)     // Catch:{ all -> 0x00ee }
            throw r0     // Catch:{ all -> 0x00ee }
        L_0x00ee:
            r0 = move-exception
            goto L_0x00f5
        L_0x00f0:
            r0 = move-exception
            r22 = r1
            r23 = r2
        L_0x00f5:
            monitor-exit(r9)
            throw r0
        L_0x00f7:
            r0 = move-exception
            r10 = r26
            r22 = r1
            r23 = r2
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.add(java.lang.Object):boolean");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void add(int r29, T r30) {
        /*
            r28 = this;
            r1 = r28
            r2 = 0
            r3 = r1
            r4 = 0
            r5 = r3
            androidx.compose.runtime.snapshots.SnapshotStateList r5 = (androidx.compose.runtime.snapshots.SnapshotStateList) r5
            r6 = 0
            r7 = 0
        L_0x000a:
            r8 = 0
            r9 = 0
            java.lang.Object r10 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r11 = 0
            monitor-enter(r10)
            r0 = 0
            r12 = r5
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r14 = r12.getFirstStateRecord()     // Catch:{ all -> 0x0108 }
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14, r15)     // Catch:{ all -> 0x0108 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r14 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r14     // Catch:{ all -> 0x0108 }
            androidx.compose.runtime.snapshots.StateRecord r14 = (androidx.compose.runtime.snapshots.StateRecord) r14     // Catch:{ all -> 0x0108 }
            r15 = 0
            androidx.compose.runtime.snapshots.StateRecord r16 = androidx.compose.runtime.snapshots.SnapshotKt.current(r14)     // Catch:{ all -> 0x0108 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r16 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r16     // Catch:{ all -> 0x0108 }
            r17 = 0
            r12 = r16
            int r13 = r12.getModification$runtime_release()     // Catch:{ all -> 0x0108 }
            r9 = r13
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r13 = r12.getList$runtime_release()     // Catch:{ all -> 0x0108 }
            r8 = r13
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0108 }
            monitor-exit(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r0 = r8
            r10 = 0
            r12 = r29
            r13 = r30
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r0.add(r12, r13)
            r10 = r0
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r8)
            if (r0 == 0) goto L_0x005b
            r0 = 0
            r18 = r1
            r25 = r2
            goto L_0x00d7
        L_0x005b:
            java.lang.Object r11 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r14 = 0
            monitor-enter(r11)
            r15 = 0
            r16 = r5
            r17 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r16.getFirstStateRecord()     // Catch:{ all -> 0x0101 }
            r18 = r1
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)     // Catch:{ all -> 0x00fd }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00fd }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x00fd }
            r1 = r0
            r19 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r20 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x00fd }
            r21 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x00fd }
            r22 = r0
            r23 = 0
            monitor-enter(r22)     // Catch:{ all -> 0x00fd }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r24 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00f4 }
            androidx.compose.runtime.snapshots.Snapshot r24 = r24.getCurrent()     // Catch:{ all -> 0x00f4 }
            r20 = r24
            r24 = r0
            r0 = r16
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00ec }
            r25 = r2
            r2 = r20
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r1, r0, r2)     // Catch:{ all -> 0x00e6 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00e6 }
            r20 = 0
            r26 = r1
            int r1 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00e2 }
            if (r1 != r9) goto L_0x00bb
            r0.setList$runtime_release(r10)     // Catch:{ all -> 0x00e2 }
            int r1 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00e2 }
            r27 = 1
            int r1 = r1 + 1
            r0.setModification$runtime_release(r1)     // Catch:{ all -> 0x00e2 }
            goto L_0x00bd
        L_0x00bb:
            r27 = 0
        L_0x00bd:
            monitor-exit(r22)     // Catch:{ all -> 0x00fb }
            r0 = r27
            r1 = 0
            r20 = r0
            r0 = r16
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00fb }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r2, r0)     // Catch:{ all -> 0x00fb }
            monitor-exit(r11)
            if (r27 == 0) goto L_0x00dc
            r0 = 1
        L_0x00d7:
            return
        L_0x00dc:
            r1 = r18
            r2 = r25
            goto L_0x000a
        L_0x00e2:
            r0 = move-exception
            r20 = r2
            goto L_0x00f9
        L_0x00e6:
            r0 = move-exception
            r26 = r1
            r20 = r2
            goto L_0x00f9
        L_0x00ec:
            r0 = move-exception
            r26 = r1
            r25 = r2
            r2 = r20
            goto L_0x00f9
        L_0x00f4:
            r0 = move-exception
            r26 = r1
            r25 = r2
        L_0x00f9:
            monitor-exit(r22)     // Catch:{ all -> 0x00fb }
            throw r0     // Catch:{ all -> 0x00fb }
        L_0x00fb:
            r0 = move-exception
            goto L_0x0106
        L_0x00fd:
            r0 = move-exception
            r25 = r2
            goto L_0x0106
        L_0x0101:
            r0 = move-exception
            r18 = r1
            r25 = r2
        L_0x0106:
            monitor-exit(r11)
            throw r0
        L_0x0108:
            r0 = move-exception
            r12 = r29
            r13 = r30
            r18 = r1
            r25 = r2
            monitor-exit(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.add(int, java.lang.Object):void");
    }

    public boolean addAll(int index, Collection<? extends T> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return mutateBoolean(new SnapshotStateList$addAll$1(index, elements));
    }

    /* JADX INFO: finally extract failed */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public boolean addAll(java.util.Collection<? extends T> r25) {
        /*
            r24 = this;
            r1 = r25
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r2 = r24
            r3 = 0
            r4 = r2
            androidx.compose.runtime.snapshots.SnapshotStateList r4 = (androidx.compose.runtime.snapshots.SnapshotStateList) r4
            r5 = 0
            r6 = 0
        L_0x000f:
            r7 = 0
            r8 = 0
            java.lang.Object r9 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r10 = 0
            monitor-enter(r9)
            r0 = 0
            r11 = r4
            r12 = 0
            androidx.compose.runtime.snapshots.StateRecord r13 = r11.getFirstStateRecord()     // Catch:{ all -> 0x00f3 }
            java.lang.String r14 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r14)     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r13 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r13     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.StateRecord r13 = (androidx.compose.runtime.snapshots.StateRecord) r13     // Catch:{ all -> 0x00f3 }
            r14 = 0
            androidx.compose.runtime.snapshots.StateRecord r15 = androidx.compose.runtime.snapshots.SnapshotKt.current(r13)     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r15 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r15     // Catch:{ all -> 0x00f3 }
            r16 = 0
            r11 = r15
            int r12 = r11.getModification$runtime_release()     // Catch:{ all -> 0x00f3 }
            r8 = r12
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r12 = r11.getList$runtime_release()     // Catch:{ all -> 0x00f3 }
            r7 = r12
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f3 }
            monitor-exit(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r0 = r7
            r9 = 0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r0.addAll(r1)
            r9 = r0
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r7)
            if (r0 == 0) goto L_0x0059
            r0 = 0
            r22 = r2
            goto L_0x00cd
        L_0x0059:
            java.lang.Object r10 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r11 = 0
            monitor-enter(r10)
            r12 = 0
            r13 = r4
            r14 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r13.getFirstStateRecord()     // Catch:{ all -> 0x00ee }
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r15)     // Catch:{ all -> 0x00ee }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00ee }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x00ee }
            r15 = r0
            r16 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r17 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x00ee }
            r18 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x00ee }
            r19 = r0
            r20 = 0
            monitor-enter(r19)     // Catch:{ all -> 0x00ee }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r21 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00e7 }
            androidx.compose.runtime.snapshots.Snapshot r21 = r21.getCurrent()     // Catch:{ all -> 0x00e7 }
            r17 = r21
            r21 = r0
            r0 = r13
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00e1 }
            r1 = r17
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r15, r0, r1)     // Catch:{ all -> 0x00db }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00db }
            r17 = 0
            r22 = r2
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00d7 }
            if (r2 != r8) goto L_0x00b2
            r0.setList$runtime_release(r9)     // Catch:{ all -> 0x00d7 }
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00d7 }
            r23 = 1
            int r2 = r2 + 1
            r0.setModification$runtime_release(r2)     // Catch:{ all -> 0x00d7 }
            goto L_0x00b4
        L_0x00b2:
            r23 = 0
        L_0x00b4:
            monitor-exit(r19)     // Catch:{ all -> 0x00ec }
            r0 = r23
            r2 = 0
            r17 = r0
            r0 = r13
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00ec }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r0)     // Catch:{ all -> 0x00ec }
            monitor-exit(r10)
            if (r23 == 0) goto L_0x00d1
            r0 = 1
        L_0x00cd:
            return r0
        L_0x00d1:
            r1 = r25
            r2 = r22
            goto L_0x000f
        L_0x00d7:
            r0 = move-exception
            r17 = r1
            goto L_0x00ea
        L_0x00db:
            r0 = move-exception
            r22 = r2
            r17 = r1
            goto L_0x00ea
        L_0x00e1:
            r0 = move-exception
            r22 = r2
            r1 = r17
            goto L_0x00ea
        L_0x00e7:
            r0 = move-exception
            r22 = r2
        L_0x00ea:
            monitor-exit(r19)     // Catch:{ all -> 0x00ec }
            throw r0     // Catch:{ all -> 0x00ec }
        L_0x00ec:
            r0 = move-exception
            goto L_0x00f1
        L_0x00ee:
            r0 = move-exception
            r22 = r2
        L_0x00f1:
            monitor-exit(r10)
            throw r0
        L_0x00f3:
            r0 = move-exception
            r22 = r2
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.addAll(java.util.Collection):boolean");
    }

    public void clear() {
        Snapshot current;
        int modification$runtime_release;
        synchronized (SnapshotStateListKt.sync) {
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord $this$writable$iv$iv = (StateListStateRecord) firstStateRecord2;
            Snapshot snapshotInitializer = SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord $this$clear_u24lambda_u245_u24lambda_u244 = (StateListStateRecord) SnapshotKt.writableRecord($this$writable$iv$iv, this, current);
                $this$clear_u24lambda_u245_u24lambda_u244.setList$runtime_release(ExtensionsKt.persistentListOf());
                modification$runtime_release = $this$clear_u24lambda_u245_u24lambda_u244.getModification$runtime_release();
                $this$clear_u24lambda_u245_u24lambda_u244.setModification$runtime_release(modification$runtime_release + 1);
            }
            int i = modification$runtime_release;
            SnapshotKt.notifyWrite(current, this);
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public boolean remove(androidx.compose.runtime.snapshots.Snapshot r26) {
        /*
            r25 = this;
            r1 = r25
            r2 = 0
            r3 = r1
            androidx.compose.runtime.snapshots.SnapshotStateList r3 = (androidx.compose.runtime.snapshots.SnapshotStateList) r3
            r4 = 0
            r5 = 0
        L_0x0008:
            r6 = 0
            r7 = 0
            java.lang.Object r8 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r9 = 0
            monitor-enter(r8)
            r0 = 0
            r10 = r3
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = r10.getFirstStateRecord()     // Catch:{ all -> 0x00f7 }
            java.lang.String r13 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r13)     // Catch:{ all -> 0x00f7 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r12     // Catch:{ all -> 0x00f7 }
            androidx.compose.runtime.snapshots.StateRecord r12 = (androidx.compose.runtime.snapshots.StateRecord) r12     // Catch:{ all -> 0x00f7 }
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r14 = androidx.compose.runtime.snapshots.SnapshotKt.current(r12)     // Catch:{ all -> 0x00f7 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r14 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r14     // Catch:{ all -> 0x00f7 }
            r15 = 0
            r10 = r14
            int r11 = r10.getModification$runtime_release()     // Catch:{ all -> 0x00f7 }
            r7 = r11
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r11 = r10.getList$runtime_release()     // Catch:{ all -> 0x00f7 }
            r6 = r11
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f7 }
            monitor-exit(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r0 = r6
            r8 = 0
            r10 = r26
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r0.remove(r10)
            r8 = r0
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r6)
            if (r0 == 0) goto L_0x0055
            r0 = 0
            r22 = r1
            r23 = r2
            goto L_0x00cb
        L_0x0055:
            java.lang.Object r9 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r11 = 0
            monitor-enter(r9)
            r12 = 0
            r13 = r3
            r14 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r13.getFirstStateRecord()     // Catch:{ all -> 0x00f0 }
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r15)     // Catch:{ all -> 0x00f0 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00f0 }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x00f0 }
            r15 = r0
            r16 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r17 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x00f0 }
            r18 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x00f0 }
            r19 = r0
            r20 = 0
            monitor-enter(r19)     // Catch:{ all -> 0x00f0 }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r21 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00e7 }
            androidx.compose.runtime.snapshots.Snapshot r21 = r21.getCurrent()     // Catch:{ all -> 0x00e7 }
            r17 = r21
            r21 = r0
            r0 = r13
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00df }
            r22 = r1
            r1 = r17
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r15, r0, r1)     // Catch:{ all -> 0x00d9 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00d9 }
            r17 = 0
            r23 = r2
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00d5 }
            if (r2 != r7) goto L_0x00b0
            r0.setList$runtime_release(r8)     // Catch:{ all -> 0x00d5 }
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00d5 }
            r24 = 1
            int r2 = r2 + 1
            r0.setModification$runtime_release(r2)     // Catch:{ all -> 0x00d5 }
            goto L_0x00b2
        L_0x00b0:
            r24 = 0
        L_0x00b2:
            monitor-exit(r19)     // Catch:{ all -> 0x00ee }
            r0 = r24
            r2 = 0
            r17 = r0
            r0 = r13
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00ee }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r0)     // Catch:{ all -> 0x00ee }
            monitor-exit(r9)
            if (r24 == 0) goto L_0x00cf
            r0 = 1
        L_0x00cb:
            return r0
        L_0x00cf:
            r1 = r22
            r2 = r23
            goto L_0x0008
        L_0x00d5:
            r0 = move-exception
            r17 = r1
            goto L_0x00ec
        L_0x00d9:
            r0 = move-exception
            r23 = r2
            r17 = r1
            goto L_0x00ec
        L_0x00df:
            r0 = move-exception
            r22 = r1
            r23 = r2
            r1 = r17
            goto L_0x00ec
        L_0x00e7:
            r0 = move-exception
            r22 = r1
            r23 = r2
        L_0x00ec:
            monitor-exit(r19)     // Catch:{ all -> 0x00ee }
            throw r0     // Catch:{ all -> 0x00ee }
        L_0x00ee:
            r0 = move-exception
            goto L_0x00f5
        L_0x00f0:
            r0 = move-exception
            r22 = r1
            r23 = r2
        L_0x00f5:
            monitor-exit(r9)
            throw r0
        L_0x00f7:
            r0 = move-exception
            r10 = r26
            r22 = r1
            r23 = r2
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.remove(java.lang.Object):boolean");
    }

    /* JADX INFO: finally extract failed */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public boolean removeAll(java.util.Collection<? extends java.lang.Object> r25) {
        /*
            r24 = this;
            r1 = r25
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r2 = r24
            r3 = 0
            r4 = r2
            androidx.compose.runtime.snapshots.SnapshotStateList r4 = (androidx.compose.runtime.snapshots.SnapshotStateList) r4
            r5 = 0
            r6 = 0
        L_0x000f:
            r7 = 0
            r8 = 0
            java.lang.Object r9 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r10 = 0
            monitor-enter(r9)
            r0 = 0
            r11 = r4
            r12 = 0
            androidx.compose.runtime.snapshots.StateRecord r13 = r11.getFirstStateRecord()     // Catch:{ all -> 0x00f3 }
            java.lang.String r14 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r14)     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r13 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r13     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.StateRecord r13 = (androidx.compose.runtime.snapshots.StateRecord) r13     // Catch:{ all -> 0x00f3 }
            r14 = 0
            androidx.compose.runtime.snapshots.StateRecord r15 = androidx.compose.runtime.snapshots.SnapshotKt.current(r13)     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r15 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r15     // Catch:{ all -> 0x00f3 }
            r16 = 0
            r11 = r15
            int r12 = r11.getModification$runtime_release()     // Catch:{ all -> 0x00f3 }
            r8 = r12
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r12 = r11.getList$runtime_release()     // Catch:{ all -> 0x00f3 }
            r7 = r12
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f3 }
            monitor-exit(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r0 = r7
            r9 = 0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r0 = r0.removeAll(r1)
            r9 = r0
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r7)
            if (r0 == 0) goto L_0x0059
            r0 = 0
            r22 = r2
            goto L_0x00cd
        L_0x0059:
            java.lang.Object r10 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r11 = 0
            monitor-enter(r10)
            r12 = 0
            r13 = r4
            r14 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r13.getFirstStateRecord()     // Catch:{ all -> 0x00ee }
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r15)     // Catch:{ all -> 0x00ee }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00ee }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x00ee }
            r15 = r0
            r16 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r17 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x00ee }
            r18 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x00ee }
            r19 = r0
            r20 = 0
            monitor-enter(r19)     // Catch:{ all -> 0x00ee }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r21 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00e7 }
            androidx.compose.runtime.snapshots.Snapshot r21 = r21.getCurrent()     // Catch:{ all -> 0x00e7 }
            r17 = r21
            r21 = r0
            r0 = r13
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00e1 }
            r1 = r17
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r15, r0, r1)     // Catch:{ all -> 0x00db }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00db }
            r17 = 0
            r22 = r2
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00d7 }
            if (r2 != r8) goto L_0x00b2
            r0.setList$runtime_release(r9)     // Catch:{ all -> 0x00d7 }
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00d7 }
            r23 = 1
            int r2 = r2 + 1
            r0.setModification$runtime_release(r2)     // Catch:{ all -> 0x00d7 }
            goto L_0x00b4
        L_0x00b2:
            r23 = 0
        L_0x00b4:
            monitor-exit(r19)     // Catch:{ all -> 0x00ec }
            r0 = r23
            r2 = 0
            r17 = r0
            r0 = r13
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00ec }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r0)     // Catch:{ all -> 0x00ec }
            monitor-exit(r10)
            if (r23 == 0) goto L_0x00d1
            r0 = 1
        L_0x00cd:
            return r0
        L_0x00d1:
            r1 = r25
            r2 = r22
            goto L_0x000f
        L_0x00d7:
            r0 = move-exception
            r17 = r1
            goto L_0x00ea
        L_0x00db:
            r0 = move-exception
            r22 = r2
            r17 = r1
            goto L_0x00ea
        L_0x00e1:
            r0 = move-exception
            r22 = r2
            r1 = r17
            goto L_0x00ea
        L_0x00e7:
            r0 = move-exception
            r22 = r2
        L_0x00ea:
            monitor-exit(r19)     // Catch:{ all -> 0x00ec }
            throw r0     // Catch:{ all -> 0x00ec }
        L_0x00ec:
            r0 = move-exception
            goto L_0x00f1
        L_0x00ee:
            r0 = move-exception
            r22 = r2
        L_0x00f1:
            monitor-exit(r10)
            throw r0
        L_0x00f3:
            r0 = move-exception
            r22 = r2
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.removeAll(java.util.Collection):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004b, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
        r1 = r10.removeAt(r31);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005b, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10) == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005d, code lost:
        r19 = r3;
        r20 = r4;
        r27 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0066, code lost:
        r2 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006b, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006c, code lost:
        r15 = r7;
        r19 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r3 = r15.getFirstStateRecord();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0076, code lost:
        r20 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        r3 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r3;
        r21 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer();
        r23 = androidx.compose.runtime.snapshots.SnapshotKt.getLock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0093, code lost:
        monitor-enter(r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009c, code lost:
        r21 = androidx.compose.runtime.snapshots.Snapshot.Companion.getCurrent();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a3, code lost:
        r27 = r5;
        r5 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r4 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r3, r15, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ad, code lost:
        r28 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b5, code lost:
        if (r4.getModification$runtime_release() != r11) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r4.setList$runtime_release(r1);
        r29 = true;
        r4.setModification$runtime_release(r4.getModification$runtime_release() + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c7, code lost:
        r25 = r1;
        r21 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cc, code lost:
        r29 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        monitor-exit(r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d1, code lost:
        r3 = r29;
        r25 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e2, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e3, code lost:
        if (r29 == false) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fa, code lost:
        r25 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00fd, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00fe, code lost:
        r25 = r1;
        r21 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0103, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0104, code lost:
        r25 = r1;
        r28 = r3;
        r21 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x010b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x010c, code lost:
        r25 = r1;
        r28 = r3;
        r27 = r5;
        r5 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0115, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0116, code lost:
        r25 = r1;
        r28 = r3;
        r27 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        monitor-exit(r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x011f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0120, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0122, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0123, code lost:
        r25 = r1;
        r27 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0128, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0129, code lost:
        r25 = r1;
        r20 = r4;
        r27 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012f, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0130, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T removeAt(int r31) {
        /*
            r30 = this;
            java.lang.Object r0 = r30.get(r31)
            r1 = r0
            r2 = 0
            r3 = r30
            r4 = 0
            r5 = r3
            r6 = 0
            r7 = r5
            androidx.compose.runtime.snapshots.SnapshotStateList r7 = (androidx.compose.runtime.snapshots.SnapshotStateList) r7
            r8 = 0
            r9 = 0
        L_0x0010:
            r10 = 0
            r11 = 0
            java.lang.Object r12 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r13 = 0
            monitor-enter(r12)
            r14 = 0
            r15 = r7
            r16 = 0
            r17 = r1
            androidx.compose.runtime.snapshots.StateRecord r1 = r15.getFirstStateRecord()     // Catch:{ all -> 0x013b }
            r18 = r2
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)     // Catch:{ all -> 0x0131 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch:{ all -> 0x0131 }
            androidx.compose.runtime.snapshots.StateRecord r1 = (androidx.compose.runtime.snapshots.StateRecord) r1     // Catch:{ all -> 0x0131 }
            r2 = 0
            androidx.compose.runtime.snapshots.StateRecord r19 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch:{ all -> 0x0131 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r19 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r19     // Catch:{ all -> 0x0131 }
            r20 = 0
            r1 = r19
            int r2 = r1.getModification$runtime_release()     // Catch:{ all -> 0x0131 }
            r11 = r2
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r2 = r1.getList$runtime_release()     // Catch:{ all -> 0x0131 }
            r10 = r2
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0131 }
            monitor-exit(r12)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r1 = r10
            r2 = 0
            r14 = r31
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.removeAt(r14)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10)
            if (r2 == 0) goto L_0x0066
            r2 = 0
            r19 = r3
            r20 = r4
            r27 = r5
            goto L_0x00e7
        L_0x0066:
            java.lang.Object r2 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r12 = 0
            monitor-enter(r2)
            r13 = 0
            r15 = r7
            r16 = 0
            r19 = r3
            androidx.compose.runtime.snapshots.StateRecord r3 = r15.getFirstStateRecord()     // Catch:{ all -> 0x0128 }
            r20 = r4
            java.lang.String r4 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r4)     // Catch:{ all -> 0x0122 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r3 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r3     // Catch:{ all -> 0x0122 }
            androidx.compose.runtime.snapshots.StateRecord r3 = (androidx.compose.runtime.snapshots.StateRecord) r3     // Catch:{ all -> 0x0122 }
            r4 = 0
            r21 = 0
            androidx.compose.runtime.snapshots.Snapshot r22 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x0122 }
            r21 = r22
            r22 = 0
            java.lang.Object r23 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x0122 }
            r24 = 0
            monitor-enter(r23)     // Catch:{ all -> 0x0122 }
            r25 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r26 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0115 }
            androidx.compose.runtime.snapshots.Snapshot r26 = r26.getCurrent()     // Catch:{ all -> 0x0115 }
            r21 = r26
            r26 = r4
            r4 = r15
            androidx.compose.runtime.snapshots.StateObject r4 = (androidx.compose.runtime.snapshots.StateObject) r4     // Catch:{ all -> 0x010b }
            r27 = r5
            r5 = r21
            androidx.compose.runtime.snapshots.StateRecord r4 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r3, r4, r5)     // Catch:{ all -> 0x0103 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r4 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r4     // Catch:{ all -> 0x0103 }
            r21 = 0
            r28 = r3
            int r3 = r4.getModification$runtime_release()     // Catch:{ all -> 0x00fd }
            if (r3 != r11) goto L_0x00cc
            r4.setList$runtime_release(r1)     // Catch:{ all -> 0x00c6 }
            int r3 = r4.getModification$runtime_release()     // Catch:{ all -> 0x00c6 }
            r29 = 1
            int r3 = r3 + 1
            r4.setModification$runtime_release(r3)     // Catch:{ all -> 0x00c6 }
            goto L_0x00ce
        L_0x00c6:
            r0 = move-exception
            r25 = r1
            r21 = r5
            goto L_0x011e
        L_0x00cc:
            r29 = 0
        L_0x00ce:
            monitor-exit(r23)     // Catch:{ all -> 0x00f9 }
            r3 = r29
            r4 = 0
            r25 = r1
            r1 = r15
            androidx.compose.runtime.snapshots.StateObject r1 = (androidx.compose.runtime.snapshots.StateObject) r1     // Catch:{ all -> 0x0120 }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r1)     // Catch:{ all -> 0x0120 }
            monitor-exit(r2)
            if (r29 == 0) goto L_0x00ed
            r2 = 1
        L_0x00e7:
            return r0
        L_0x00ed:
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r27
            goto L_0x0010
        L_0x00f9:
            r0 = move-exception
            r25 = r1
            goto L_0x012f
        L_0x00fd:
            r0 = move-exception
            r25 = r1
            r21 = r5
            goto L_0x011e
        L_0x0103:
            r0 = move-exception
            r25 = r1
            r28 = r3
            r21 = r5
            goto L_0x011e
        L_0x010b:
            r0 = move-exception
            r25 = r1
            r28 = r3
            r27 = r5
            r5 = r21
            goto L_0x011e
        L_0x0115:
            r0 = move-exception
            r25 = r1
            r28 = r3
            r26 = r4
            r27 = r5
        L_0x011e:
            monitor-exit(r23)     // Catch:{ all -> 0x0120 }
            throw r0     // Catch:{ all -> 0x0120 }
        L_0x0120:
            r0 = move-exception
            goto L_0x012f
        L_0x0122:
            r0 = move-exception
            r25 = r1
            r27 = r5
            goto L_0x012f
        L_0x0128:
            r0 = move-exception
            r25 = r1
            r20 = r4
            r27 = r5
        L_0x012f:
            monitor-exit(r2)
            throw r0
        L_0x0131:
            r0 = move-exception
            r14 = r31
            r19 = r3
            r20 = r4
            r27 = r5
            goto L_0x0146
        L_0x013b:
            r0 = move-exception
            r14 = r31
            r18 = r2
            r19 = r3
            r20 = r4
            r27 = r5
        L_0x0146:
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.removeAt(int):java.lang.Object");
    }

    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return mutateBoolean(new SnapshotStateList$retainAll$1(elements));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004b, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
        r1 = r10.set(r32, r33);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005d, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10) == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005f, code lost:
        r20 = r3;
        r21 = r4;
        r28 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0068, code lost:
        r2 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006d, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006e, code lost:
        r16 = r7;
        r20 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r3 = r16.getFirstStateRecord();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
        r21 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        r3 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r3;
        r22 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer();
        r24 = androidx.compose.runtime.snapshots.SnapshotKt.getLock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0096, code lost:
        monitor-enter(r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009f, code lost:
        r22 = androidx.compose.runtime.snapshots.Snapshot.Companion.getCurrent();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a7, code lost:
        r28 = r5;
        r5 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r4 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r3, r16, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b1, code lost:
        r29 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b9, code lost:
        if (r4.getModification$runtime_release() != r11) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r4.setList$runtime_release(r1);
        r30 = true;
        r4.setModification$runtime_release(r4.getModification$runtime_release() + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ca, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cb, code lost:
        r26 = r1;
        r22 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d0, code lost:
        r30 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        monitor-exit(r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d5, code lost:
        r3 = r30;
        r26 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e7, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e8, code lost:
        if (r30 == false) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ff, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0100, code lost:
        r26 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0103, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0104, code lost:
        r26 = r1;
        r22 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0109, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x010a, code lost:
        r26 = r1;
        r29 = r3;
        r22 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0111, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0112, code lost:
        r26 = r1;
        r29 = r3;
        r28 = r5;
        r5 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x011b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x011c, code lost:
        r26 = r1;
        r29 = r3;
        r28 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        monitor-exit(r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0125, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0126, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0128, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0129, code lost:
        r26 = r1;
        r28 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012f, code lost:
        r26 = r1;
        r21 = r4;
        r28 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0135, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0136, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T set(int r32, T r33) {
        /*
            r31 = this;
            java.lang.Object r0 = r31.get(r32)
            r1 = r0
            r2 = 0
            r3 = r31
            r4 = 0
            r5 = r3
            r6 = 0
            r7 = r5
            androidx.compose.runtime.snapshots.SnapshotStateList r7 = (androidx.compose.runtime.snapshots.SnapshotStateList) r7
            r8 = 0
            r9 = 0
        L_0x0010:
            r10 = 0
            r11 = 0
            java.lang.Object r12 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r13 = 0
            monitor-enter(r12)
            r14 = 0
            r15 = r7
            r16 = 0
            r17 = r1
            androidx.compose.runtime.snapshots.StateRecord r1 = r15.getFirstStateRecord()     // Catch:{ all -> 0x0143 }
            r18 = r2
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)     // Catch:{ all -> 0x0137 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r1 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r1     // Catch:{ all -> 0x0137 }
            androidx.compose.runtime.snapshots.StateRecord r1 = (androidx.compose.runtime.snapshots.StateRecord) r1     // Catch:{ all -> 0x0137 }
            r2 = 0
            androidx.compose.runtime.snapshots.StateRecord r19 = androidx.compose.runtime.snapshots.SnapshotKt.current(r1)     // Catch:{ all -> 0x0137 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r19 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r19     // Catch:{ all -> 0x0137 }
            r20 = 0
            r1 = r19
            int r2 = r1.getModification$runtime_release()     // Catch:{ all -> 0x0137 }
            r11 = r2
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r2 = r1.getList$runtime_release()     // Catch:{ all -> 0x0137 }
            r10 = r2
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0137 }
            monitor-exit(r12)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r1 = r10
            r2 = 0
            r14 = r32
            r15 = r33
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r1 = r1.set(r14, r15)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10)
            if (r2 == 0) goto L_0x0068
            r2 = 0
            r20 = r3
            r21 = r4
            r28 = r5
            goto L_0x00ec
        L_0x0068:
            java.lang.Object r2 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r12 = 0
            monitor-enter(r2)
            r13 = 0
            r16 = r7
            r19 = 0
            r20 = r3
            androidx.compose.runtime.snapshots.StateRecord r3 = r16.getFirstStateRecord()     // Catch:{ all -> 0x012e }
            r21 = r4
            java.lang.String r4 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r4)     // Catch:{ all -> 0x0128 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r3 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r3     // Catch:{ all -> 0x0128 }
            androidx.compose.runtime.snapshots.StateRecord r3 = (androidx.compose.runtime.snapshots.StateRecord) r3     // Catch:{ all -> 0x0128 }
            r4 = 0
            r22 = 0
            androidx.compose.runtime.snapshots.Snapshot r23 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x0128 }
            r22 = r23
            r23 = 0
            java.lang.Object r24 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x0128 }
            r25 = 0
            monitor-enter(r24)     // Catch:{ all -> 0x0128 }
            r26 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r27 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x011b }
            androidx.compose.runtime.snapshots.Snapshot r27 = r27.getCurrent()     // Catch:{ all -> 0x011b }
            r22 = r27
            r27 = r4
            r4 = r16
            androidx.compose.runtime.snapshots.StateObject r4 = (androidx.compose.runtime.snapshots.StateObject) r4     // Catch:{ all -> 0x0111 }
            r28 = r5
            r5 = r22
            androidx.compose.runtime.snapshots.StateRecord r4 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r3, r4, r5)     // Catch:{ all -> 0x0109 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r4 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r4     // Catch:{ all -> 0x0109 }
            r22 = 0
            r29 = r3
            int r3 = r4.getModification$runtime_release()     // Catch:{ all -> 0x0103 }
            if (r3 != r11) goto L_0x00d0
            r4.setList$runtime_release(r1)     // Catch:{ all -> 0x00ca }
            int r3 = r4.getModification$runtime_release()     // Catch:{ all -> 0x00ca }
            r30 = 1
            int r3 = r3 + 1
            r4.setModification$runtime_release(r3)     // Catch:{ all -> 0x00ca }
            goto L_0x00d2
        L_0x00ca:
            r0 = move-exception
            r26 = r1
            r22 = r5
            goto L_0x0124
        L_0x00d0:
            r30 = 0
        L_0x00d2:
            monitor-exit(r24)     // Catch:{ all -> 0x00ff }
            r3 = r30
            r4 = 0
            r26 = r1
            r1 = r16
            androidx.compose.runtime.snapshots.StateObject r1 = (androidx.compose.runtime.snapshots.StateObject) r1     // Catch:{ all -> 0x0126 }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r5, r1)     // Catch:{ all -> 0x0126 }
            monitor-exit(r2)
            if (r30 == 0) goto L_0x00f3
            r2 = 1
        L_0x00ec:
            return r0
        L_0x00f3:
            r1 = r17
            r2 = r18
            r3 = r20
            r4 = r21
            r5 = r28
            goto L_0x0010
        L_0x00ff:
            r0 = move-exception
            r26 = r1
            goto L_0x0135
        L_0x0103:
            r0 = move-exception
            r26 = r1
            r22 = r5
            goto L_0x0124
        L_0x0109:
            r0 = move-exception
            r26 = r1
            r29 = r3
            r22 = r5
            goto L_0x0124
        L_0x0111:
            r0 = move-exception
            r26 = r1
            r29 = r3
            r28 = r5
            r5 = r22
            goto L_0x0124
        L_0x011b:
            r0 = move-exception
            r26 = r1
            r29 = r3
            r27 = r4
            r28 = r5
        L_0x0124:
            monitor-exit(r24)     // Catch:{ all -> 0x0126 }
            throw r0     // Catch:{ all -> 0x0126 }
        L_0x0126:
            r0 = move-exception
            goto L_0x0135
        L_0x0128:
            r0 = move-exception
            r26 = r1
            r28 = r5
            goto L_0x0135
        L_0x012e:
            r0 = move-exception
            r26 = r1
            r21 = r4
            r28 = r5
        L_0x0135:
            monitor-exit(r2)
            throw r0
        L_0x0137:
            r0 = move-exception
            r14 = r32
            r15 = r33
            r20 = r3
            r21 = r4
            r28 = r5
            goto L_0x0150
        L_0x0143:
            r0 = move-exception
            r14 = r32
            r15 = r33
            r18 = r2
            r20 = r3
            r21 = r4
            r28 = r5
        L_0x0150:
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.set(int, java.lang.Object):java.lang.Object");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final void removeRange(int r26, int r27) {
        /*
            r25 = this;
            r1 = r25
            r2 = 0
            r0 = 0
            r3 = r0
        L_0x0005:
            r4 = 0
            r5 = 0
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r7 = 0
            monitor-enter(r6)
            r0 = 0
            r8 = r1
            r9 = 0
            androidx.compose.runtime.snapshots.StateRecord r10 = r8.getFirstStateRecord()     // Catch:{ all -> 0x0101 }
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)     // Catch:{ all -> 0x0101 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r10 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r10     // Catch:{ all -> 0x0101 }
            androidx.compose.runtime.snapshots.StateRecord r10 = (androidx.compose.runtime.snapshots.StateRecord) r10     // Catch:{ all -> 0x0101 }
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = androidx.compose.runtime.snapshots.SnapshotKt.current(r10)     // Catch:{ all -> 0x0101 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r12     // Catch:{ all -> 0x0101 }
            r13 = 0
            r8 = r12
            int r9 = r8.getModification$runtime_release()     // Catch:{ all -> 0x0101 }
            r5 = r9
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r9 = r8.getList$runtime_release()     // Catch:{ all -> 0x0101 }
            r4 = r9
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0101 }
            monitor-exit(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder r6 = r4.builder()
            r0 = r6
            java.util.List r0 = (java.util.List) r0
            r7 = 0
            r8 = r26
            r9 = r27
            java.util.List r10 = r0.subList(r8, r9)
            r10.clear()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r3 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r7 = r6.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)
            if (r0 != 0) goto L_0x00fa
            java.lang.Object r10 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r11 = 0
            monitor-enter(r10)
            r12 = 0
            r13 = r1
            r14 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r13.getFirstStateRecord()     // Catch:{ all -> 0x00f3 }
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r15)     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x00f3 }
            r15 = r0
            r16 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r17 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x00f3 }
            r18 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x00f3 }
            r19 = r0
            r20 = 0
            monitor-enter(r19)     // Catch:{ all -> 0x00f3 }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r21 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00ea }
            androidx.compose.runtime.snapshots.Snapshot r21 = r21.getCurrent()     // Catch:{ all -> 0x00ea }
            r17 = r21
            r21 = r0
            r0 = r13
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00e2 }
            r22 = r1
            r1 = r17
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r15, r0, r1)     // Catch:{ all -> 0x00dc }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00dc }
            r17 = 0
            r23 = r2
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00d8 }
            if (r2 != r5) goto L_0x00b8
            r0.setList$runtime_release(r7)     // Catch:{ all -> 0x00d8 }
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00d8 }
            r24 = 1
            int r2 = r2 + 1
            r0.setModification$runtime_release(r2)     // Catch:{ all -> 0x00d8 }
            goto L_0x00ba
        L_0x00b8:
            r24 = 0
        L_0x00ba:
            monitor-exit(r19)     // Catch:{ all -> 0x00f1 }
            r0 = r24
            r2 = 0
            r17 = r0
            r0 = r13
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00f1 }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r0)     // Catch:{ all -> 0x00f1 }
            monitor-exit(r10)
            if (r24 == 0) goto L_0x00d2
            goto L_0x00fe
        L_0x00d2:
            r1 = r22
            r2 = r23
            goto L_0x0005
        L_0x00d8:
            r0 = move-exception
            r17 = r1
            goto L_0x00ef
        L_0x00dc:
            r0 = move-exception
            r23 = r2
            r17 = r1
            goto L_0x00ef
        L_0x00e2:
            r0 = move-exception
            r22 = r1
            r23 = r2
            r1 = r17
            goto L_0x00ef
        L_0x00ea:
            r0 = move-exception
            r22 = r1
            r23 = r2
        L_0x00ef:
            monitor-exit(r19)     // Catch:{ all -> 0x00f1 }
            throw r0     // Catch:{ all -> 0x00f1 }
        L_0x00f1:
            r0 = move-exception
            goto L_0x00f8
        L_0x00f3:
            r0 = move-exception
            r22 = r1
            r23 = r2
        L_0x00f8:
            monitor-exit(r10)
            throw r0
        L_0x00fa:
            r22 = r1
            r23 = r2
        L_0x00fe:
            return
        L_0x0101:
            r0 = move-exception
            r8 = r26
            r9 = r27
            r22 = r1
            r23 = r2
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.removeRange(int, int):void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final int retainAllInRange$runtime_release(java.util.Collection<? extends T> r27, androidx.compose.runtime.snapshots.Snapshot r28, boolean r29) {
        /*
            r26 = this;
            r1 = r27
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            int r2 = r26.size()
            r3 = r26
            r4 = 0
            r0 = 0
            r5 = r0
        L_0x0010:
            r6 = 0
            r7 = 0
            java.lang.Object r8 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r9 = 0
            monitor-enter(r8)
            r0 = 0
            r10 = r3
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = r10.getFirstStateRecord()     // Catch:{ all -> 0x010f }
            java.lang.String r13 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r13)     // Catch:{ all -> 0x010f }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r12     // Catch:{ all -> 0x010f }
            androidx.compose.runtime.snapshots.StateRecord r12 = (androidx.compose.runtime.snapshots.StateRecord) r12     // Catch:{ all -> 0x010f }
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r14 = androidx.compose.runtime.snapshots.SnapshotKt.current(r12)     // Catch:{ all -> 0x010f }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r14 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r14     // Catch:{ all -> 0x010f }
            r15 = 0
            r10 = r14
            int r11 = r10.getModification$runtime_release()     // Catch:{ all -> 0x010f }
            r7 = r11
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r11 = r10.getList$runtime_release()     // Catch:{ all -> 0x010f }
            r6 = r11
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x010f }
            monitor-exit(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder r8 = r6.builder()
            r0 = r8
            java.util.List r0 = (java.util.List) r0
            r9 = 0
            r10 = r28
            r11 = r29
            java.util.List r12 = r0.subList(r10, r11)
            r12.retainAll(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r5 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r9 = r8.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r6)
            if (r0 != 0) goto L_0x0104
            java.lang.Object r12 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r13 = 0
            monitor-enter(r12)
            r14 = 0
            r15 = r3
            r16 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r15.getFirstStateRecord()     // Catch:{ all -> 0x00ff }
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)     // Catch:{ all -> 0x00ff }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00ff }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x00ff }
            r1 = r0
            r17 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r18 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x00ff }
            r19 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x00ff }
            r20 = r0
            r21 = 0
            monitor-enter(r20)     // Catch:{ all -> 0x00ff }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r22 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00f6 }
            androidx.compose.runtime.snapshots.Snapshot r22 = r22.getCurrent()     // Catch:{ all -> 0x00f6 }
            r18 = r22
            r22 = r0
            r0 = r15
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00ee }
            r23 = r3
            r3 = r18
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r1, r0, r3)     // Catch:{ all -> 0x00e8 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00e8 }
            r18 = 0
            r24 = r1
            int r1 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00e4 }
            if (r1 != r7) goto L_0x00c4
            r0.setList$runtime_release(r9)     // Catch:{ all -> 0x00e4 }
            int r1 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00e4 }
            r25 = 1
            int r1 = r1 + 1
            r0.setModification$runtime_release(r1)     // Catch:{ all -> 0x00e4 }
            goto L_0x00c6
        L_0x00c4:
            r25 = 0
        L_0x00c6:
            monitor-exit(r20)     // Catch:{ all -> 0x00fd }
            r0 = r25
            r1 = 0
            r18 = r0
            r0 = r15
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00fd }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r3, r0)     // Catch:{ all -> 0x00fd }
            monitor-exit(r12)
            if (r25 == 0) goto L_0x00de
            goto L_0x0106
        L_0x00de:
            r1 = r27
            r3 = r23
            goto L_0x0010
        L_0x00e4:
            r0 = move-exception
            r18 = r3
            goto L_0x00fb
        L_0x00e8:
            r0 = move-exception
            r24 = r1
            r18 = r3
            goto L_0x00fb
        L_0x00ee:
            r0 = move-exception
            r24 = r1
            r23 = r3
            r3 = r18
            goto L_0x00fb
        L_0x00f6:
            r0 = move-exception
            r24 = r1
            r23 = r3
        L_0x00fb:
            monitor-exit(r20)     // Catch:{ all -> 0x00fd }
            throw r0     // Catch:{ all -> 0x00fd }
        L_0x00fd:
            r0 = move-exception
            goto L_0x0102
        L_0x00ff:
            r0 = move-exception
            r23 = r3
        L_0x0102:
            monitor-exit(r12)
            throw r0
        L_0x0104:
            r23 = r3
        L_0x0106:
            int r0 = r26.size()
            int r0 = r2 - r0
            return r0
        L_0x010f:
            r0 = move-exception
            r10 = r28
            r11 = r29
            r23 = r3
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.retainAllInRange$runtime_release(java.util.Collection, int, int):int");
    }

    public final List<T> getDebuggerDisplayValue() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2)).getList$runtime_release();
    }

    private final <R> R writable(Function1<? super StateListStateRecord<T>, ? extends R> block) {
        Snapshot current;
        R invoke;
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateRecord $this$writable$iv = (StateListStateRecord) firstStateRecord2;
        Object snapshot$iv = SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                invoke = block.invoke(SnapshotKt.writableRecord($this$writable$iv, this, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        R r = invoke;
        SnapshotKt.notifyWrite(current, this);
        return invoke;
    }

    private final <R> R withCurrent(Function1<? super StateListStateRecord<T>, ? extends R> block) {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return block.invoke(SnapshotKt.current((StateListStateRecord) firstStateRecord2));
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private final boolean mutateBoolean(androidx.compose.runtime.snapshots.Snapshot r25) {
        /*
            r24 = this;
            r1 = r24
            r2 = 0
            r0 = 0
            r3 = r0
        L_0x0005:
            r4 = 0
            r5 = 0
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r7 = 0
            monitor-enter(r6)
            r0 = 0
            r8 = r1
            r9 = 0
            androidx.compose.runtime.snapshots.StateRecord r10 = r8.getFirstStateRecord()     // Catch:{ all -> 0x00fa }
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)     // Catch:{ all -> 0x00fa }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r10 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r10     // Catch:{ all -> 0x00fa }
            androidx.compose.runtime.snapshots.StateRecord r10 = (androidx.compose.runtime.snapshots.StateRecord) r10     // Catch:{ all -> 0x00fa }
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = androidx.compose.runtime.snapshots.SnapshotKt.current(r10)     // Catch:{ all -> 0x00fa }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r12     // Catch:{ all -> 0x00fa }
            r13 = 0
            r8 = r12
            int r9 = r8.getModification$runtime_release()     // Catch:{ all -> 0x00fa }
            r5 = r9
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r9 = r8.getList$runtime_release()     // Catch:{ all -> 0x00fa }
            r4 = r9
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00fa }
            monitor-exit(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder r6 = r4.builder()
            r8 = r25
            java.lang.Object r3 = r8.invoke(r6)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r7 = r6.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)
            if (r0 != 0) goto L_0x00ec
            java.lang.Object r9 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r10 = 0
            monitor-enter(r9)
            r11 = 0
            r12 = r1
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r12.getFirstStateRecord()     // Catch:{ all -> 0x00e5 }
            java.lang.String r14 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r14)     // Catch:{ all -> 0x00e5 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00e5 }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x00e5 }
            r14 = r0
            r15 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r16 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x00e5 }
            r17 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x00e5 }
            r18 = r0
            r19 = 0
            monitor-enter(r18)     // Catch:{ all -> 0x00e5 }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r20 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00dc }
            androidx.compose.runtime.snapshots.Snapshot r20 = r20.getCurrent()     // Catch:{ all -> 0x00dc }
            r16 = r20
            r20 = r0
            r0 = r12
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00d4 }
            r21 = r1
            r1 = r16
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r14, r0, r1)     // Catch:{ all -> 0x00ce }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00ce }
            r16 = 0
            r22 = r2
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00ca }
            if (r2 != r5) goto L_0x00aa
            r0.setList$runtime_release(r7)     // Catch:{ all -> 0x00ca }
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00ca }
            r23 = 1
            int r2 = r2 + 1
            r0.setModification$runtime_release(r2)     // Catch:{ all -> 0x00ca }
            goto L_0x00ac
        L_0x00aa:
            r23 = 0
        L_0x00ac:
            monitor-exit(r18)     // Catch:{ all -> 0x00e3 }
            r0 = r23
            r2 = 0
            r16 = r0
            r0 = r12
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00e3 }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r0)     // Catch:{ all -> 0x00e3 }
            monitor-exit(r9)
            if (r23 == 0) goto L_0x00c4
            goto L_0x00f0
        L_0x00c4:
            r1 = r21
            r2 = r22
            goto L_0x0005
        L_0x00ca:
            r0 = move-exception
            r16 = r1
            goto L_0x00e1
        L_0x00ce:
            r0 = move-exception
            r22 = r2
            r16 = r1
            goto L_0x00e1
        L_0x00d4:
            r0 = move-exception
            r21 = r1
            r22 = r2
            r1 = r16
            goto L_0x00e1
        L_0x00dc:
            r0 = move-exception
            r21 = r1
            r22 = r2
        L_0x00e1:
            monitor-exit(r18)     // Catch:{ all -> 0x00e3 }
            throw r0     // Catch:{ all -> 0x00e3 }
        L_0x00e3:
            r0 = move-exception
            goto L_0x00ea
        L_0x00e5:
            r0 = move-exception
            r21 = r1
            r22 = r2
        L_0x00ea:
            monitor-exit(r9)
            throw r0
        L_0x00ec:
            r21 = r1
            r22 = r2
        L_0x00f0:
            r0 = r3
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
        L_0x00fa:
            r0 = move-exception
            r8 = r25
            r21 = r1
            r22 = r2
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.mutateBoolean(kotlin.jvm.functions.Function1):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r3);
        r5 = r3.builder();
        r2 = r24.invoke(r5);
        r6 = r5.build();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0054, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r3) != false) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0056, code lost:
        r8 = androidx.compose.runtime.snapshots.SnapshotStateListKt.access$getSync$p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005b, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        r12 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0 = getFirstStateRecord();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        r14 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0;
        r16 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer();
        r18 = androidx.compose.runtime.snapshots.SnapshotKt.getLock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007f, code lost:
        monitor-enter(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0087, code lost:
        r16 = androidx.compose.runtime.snapshots.Snapshot.Companion.getCurrent();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008c, code lost:
        r21 = r1;
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r9 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r14, r12, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009e, code lost:
        if (r9.getModification$runtime_release() != r4) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r9.setList$runtime_release(r6);
        r9.setModification$runtime_release(r9.getModification$runtime_release() + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ae, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b1, code lost:
        r16 = r1;
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b6, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bd, code lost:
        monitor-exit(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00be, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c1, code lost:
        r9 = r0;
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cd, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d6, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d7, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00da, code lost:
        if (r0 == false) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e1, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e2, code lost:
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e5, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e6, code lost:
        r22 = r3;
        r16 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00eb, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ec, code lost:
        r21 = r1;
        r22 = r3;
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f3, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f4, code lost:
        r21 = r1;
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fc, code lost:
        monitor-exit(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00fd, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0100, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0101, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0103, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0104, code lost:
        r21 = r1;
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0108, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x010c, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x010d, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0110, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0111, code lost:
        r21 = r1;
        r22 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <R> R mutate(kotlin.jvm.functions.Function1<? super java.util.List<T>, ? extends R> r24) {
        /*
            r23 = this;
            r1 = 0
            r0 = 0
            r2 = r0
        L_0x0003:
            r3 = 0
            r4 = 0
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r6 = 0
            monitor-enter(r5)
            r0 = 0
            r7 = r23
            r8 = 0
            r9 = 1
            androidx.compose.runtime.snapshots.StateRecord r10 = r7.getFirstStateRecord()     // Catch:{ all -> 0x011f }
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)     // Catch:{ all -> 0x011f }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r10 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r10     // Catch:{ all -> 0x011f }
            androidx.compose.runtime.snapshots.StateRecord r10 = (androidx.compose.runtime.snapshots.StateRecord) r10     // Catch:{ all -> 0x011f }
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = androidx.compose.runtime.snapshots.SnapshotKt.current(r10)     // Catch:{ all -> 0x011f }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r12     // Catch:{ all -> 0x011f }
            r13 = 0
            r7 = r12
            int r8 = r7.getModification$runtime_release()     // Catch:{ all -> 0x011f }
            r4 = r8
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r8 = r7.getList$runtime_release()     // Catch:{ all -> 0x011f }
            r3 = r8
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0117 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r9)
            monitor-exit(r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList$Builder r5 = r3.builder()
            r7 = r24
            java.lang.Object r2 = r7.invoke(r5)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r6 = r5.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r3)
            if (r0 != 0) goto L_0x0111
            java.lang.Object r8 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r10 = 0
            monitor-enter(r8)
            r11 = 0
            r12 = r23
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r12.getFirstStateRecord()     // Catch:{ all -> 0x0103 }
            java.lang.String r14 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r14)     // Catch:{ all -> 0x0103 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x0103 }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x0103 }
            r14 = r0
            r15 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r16 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x0103 }
            r17 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x0103 }
            r18 = r0
            r19 = 0
            monitor-enter(r18)     // Catch:{ all -> 0x0103 }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r20 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.Snapshot r20 = r20.getCurrent()     // Catch:{ all -> 0x00f3 }
            r16 = r20
            r9 = r12
            androidx.compose.runtime.snapshots.StateObject r9 = (androidx.compose.runtime.snapshots.StateObject) r9     // Catch:{ all -> 0x00eb }
            r21 = r1
            r1 = r16
            androidx.compose.runtime.snapshots.StateRecord r9 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r14, r9, r1)     // Catch:{ all -> 0x00e5 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r9 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r9     // Catch:{ all -> 0x00e5 }
            r16 = 0
            r22 = r0
            int r0 = r9.getModification$runtime_release()     // Catch:{ all -> 0x00e5 }
            if (r0 != r4) goto L_0x00b6
            r9.setList$runtime_release(r6)     // Catch:{ all -> 0x00b0 }
            int r0 = r9.getModification$runtime_release()     // Catch:{ all -> 0x00b0 }
            r20 = 1
            int r0 = r0 + 1
            r9.setModification$runtime_release(r0)     // Catch:{ all -> 0x00b0 }
            r0 = 1
            goto L_0x00b7
        L_0x00b0:
            r0 = move-exception
            r16 = r1
            r22 = r3
            goto L_0x00f8
        L_0x00b6:
            r0 = 0
        L_0x00b7:
            r9 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r9)     // Catch:{ all -> 0x00e1 }
            monitor-exit(r18)     // Catch:{ all -> 0x00e1 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r9)     // Catch:{ all -> 0x00e1 }
            r9 = r0
            r16 = 0
            r22 = r3
            r3 = r12
            androidx.compose.runtime.snapshots.StateObject r3 = (androidx.compose.runtime.snapshots.StateObject) r3     // Catch:{ all -> 0x0101 }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r3)     // Catch:{ all -> 0x0101 }
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r8)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            if (r0 == 0) goto L_0x00dd
            goto L_0x0115
        L_0x00dd:
            r1 = r21
            goto L_0x0003
        L_0x00e1:
            r0 = move-exception
            r22 = r3
            goto L_0x0108
        L_0x00e5:
            r0 = move-exception
            r22 = r3
            r16 = r1
            goto L_0x00f8
        L_0x00eb:
            r0 = move-exception
            r21 = r1
            r22 = r3
            r1 = r16
            goto L_0x00f8
        L_0x00f3:
            r0 = move-exception
            r21 = r1
            r22 = r3
        L_0x00f8:
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch:{ all -> 0x0101 }
            monitor-exit(r18)     // Catch:{ all -> 0x0101 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch:{ all -> 0x0101 }
            throw r0     // Catch:{ all -> 0x0101 }
        L_0x0101:
            r0 = move-exception
            goto L_0x0108
        L_0x0103:
            r0 = move-exception
            r21 = r1
            r22 = r3
        L_0x0108:
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r8)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        L_0x0111:
            r21 = r1
            r22 = r3
        L_0x0115:
            return r2
        L_0x0117:
            r0 = move-exception
            r7 = r24
            r21 = r1
            r22 = r3
            goto L_0x0124
        L_0x011f:
            r0 = move-exception
            r7 = r24
            r21 = r1
        L_0x0124:
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.mutate(kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private final void update(kotlin.jvm.functions.Function1<? super androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>, ? extends androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>> r27) {
        /*
            r26 = this;
            r1 = 0
            r2 = r26
            r3 = 0
            r4 = r2
            androidx.compose.runtime.snapshots.SnapshotStateList r4 = (androidx.compose.runtime.snapshots.SnapshotStateList) r4
            r5 = 0
            r6 = 0
        L_0x0009:
            r7 = 0
            r8 = 0
            java.lang.Object r9 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r10 = 0
            monitor-enter(r9)
            r0 = 0
            r11 = r4
            r12 = 0
            r13 = 1
            androidx.compose.runtime.snapshots.StateRecord r14 = r11.getFirstStateRecord()     // Catch:{ all -> 0x011f }
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14, r15)     // Catch:{ all -> 0x011f }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r14 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r14     // Catch:{ all -> 0x011f }
            androidx.compose.runtime.snapshots.StateRecord r14 = (androidx.compose.runtime.snapshots.StateRecord) r14     // Catch:{ all -> 0x011f }
            r15 = 0
            androidx.compose.runtime.snapshots.StateRecord r16 = androidx.compose.runtime.snapshots.SnapshotKt.current(r14)     // Catch:{ all -> 0x011f }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r16 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r16     // Catch:{ all -> 0x011f }
            r17 = 0
            r11 = r16
            int r12 = r11.getModification$runtime_release()     // Catch:{ all -> 0x011f }
            r8 = r12
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r12 = r11.getList$runtime_release()     // Catch:{ all -> 0x011f }
            r7 = r12
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x011f }
            kotlin.jvm.internal.InlineMarker.finallyStart(r13)
            monitor-exit(r9)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            r11 = r27
            java.lang.Object r0 = r11.invoke(r7)
            r9 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r9 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList) r9
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r7)
            if (r0 == 0) goto L_0x005f
            r0 = 0
            r24 = r1
            r25 = r2
            goto L_0x00e5
        L_0x005f:
            java.lang.Object r10 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r12 = 0
            monitor-enter(r10)
            r14 = 0
            r15 = r4
            r16 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r15.getFirstStateRecord()     // Catch:{ all -> 0x0111 }
            java.lang.String r13 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r13)     // Catch:{ all -> 0x0111 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x0111 }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x0111 }
            r13 = r0
            r18 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r19 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x0111 }
            r20 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x0111 }
            r21 = r0
            r22 = 0
            monitor-enter(r21)     // Catch:{ all -> 0x0111 }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r23 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0101 }
            androidx.compose.runtime.snapshots.Snapshot r23 = r23.getCurrent()     // Catch:{ all -> 0x0101 }
            r19 = r23
            r23 = r0
            r0 = r15
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00f9 }
            r24 = r1
            r1 = r19
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r13, r0, r1)     // Catch:{ all -> 0x00f3 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x00f3 }
            r19 = 0
            r25 = r2
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00ef }
            if (r2 != r8) goto L_0x00bc
            r0.setList$runtime_release(r9)     // Catch:{ all -> 0x00ef }
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00ef }
            r17 = 1
            int r2 = r2 + 1
            r0.setModification$runtime_release(r2)     // Catch:{ all -> 0x00ef }
            r2 = 1
            goto L_0x00bd
        L_0x00bc:
            r2 = 0
        L_0x00bd:
            r17 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r17)     // Catch:{ all -> 0x010f }
            monitor-exit(r21)     // Catch:{ all -> 0x010f }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r17)     // Catch:{ all -> 0x010f }
            r0 = r2
            r19 = 0
            r20 = r0
            r0 = r15
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x010f }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r0)     // Catch:{ all -> 0x010f }
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r10)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            if (r2 == 0) goto L_0x00e9
            r0 = 1
        L_0x00e5:
            return
        L_0x00e9:
            r1 = r24
            r2 = r25
            goto L_0x0009
        L_0x00ef:
            r0 = move-exception
            r19 = r1
            goto L_0x0106
        L_0x00f3:
            r0 = move-exception
            r25 = r2
            r19 = r1
            goto L_0x0106
        L_0x00f9:
            r0 = move-exception
            r24 = r1
            r25 = r2
            r1 = r19
            goto L_0x0106
        L_0x0101:
            r0 = move-exception
            r24 = r1
            r25 = r2
        L_0x0106:
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch:{ all -> 0x010f }
            monitor-exit(r21)     // Catch:{ all -> 0x010f }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch:{ all -> 0x010f }
            throw r0     // Catch:{ all -> 0x010f }
        L_0x010f:
            r0 = move-exception
            goto L_0x0116
        L_0x0111:
            r0 = move-exception
            r24 = r1
            r25 = r2
        L_0x0116:
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r10)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        L_0x011f:
            r0 = move-exception
            r11 = r27
            r24 = r1
            r25 = r2
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r9)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.update(kotlin.jvm.functions.Function1):void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private final boolean conditionalUpdate(kotlin.jvm.functions.Function1<? super androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>, ? extends androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList<? extends T>> r25) {
        /*
            r24 = this;
            r1 = 0
            r2 = r24
            androidx.compose.runtime.snapshots.SnapshotStateList r2 = (androidx.compose.runtime.snapshots.SnapshotStateList) r2
            r3 = 0
            r4 = 0
        L_0x0007:
            r5 = 0
            r6 = 0
            java.lang.Object r7 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r8 = 0
            monitor-enter(r7)
            r0 = 0
            r9 = r2
            r10 = 0
            r11 = 1
            androidx.compose.runtime.snapshots.StateRecord r12 = r9.getFirstStateRecord()     // Catch:{ all -> 0x011c }
            java.lang.String r13 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r13)     // Catch:{ all -> 0x011c }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r12     // Catch:{ all -> 0x011c }
            androidx.compose.runtime.snapshots.StateRecord r12 = (androidx.compose.runtime.snapshots.StateRecord) r12     // Catch:{ all -> 0x011c }
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r14 = androidx.compose.runtime.snapshots.SnapshotKt.current(r12)     // Catch:{ all -> 0x011c }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r14 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r14     // Catch:{ all -> 0x011c }
            r15 = 0
            r9 = r14
            int r10 = r9.getModification$runtime_release()     // Catch:{ all -> 0x011c }
            r6 = r10
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r10 = r9.getList$runtime_release()     // Catch:{ all -> 0x011c }
            r5 = r10
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x011c }
            kotlin.jvm.internal.InlineMarker.finallyStart(r11)
            monitor-exit(r7)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r9 = r25
            java.lang.Object r0 = r9.invoke(r5)
            r7 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList r7 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList) r7
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r5)
            if (r0 == 0) goto L_0x005b
            r0 = 0
            r22 = r1
            r23 = r2
            goto L_0x00e3
        L_0x005b:
            java.lang.Object r8 = androidx.compose.runtime.snapshots.SnapshotStateListKt.sync
            r10 = 0
            monitor-enter(r8)
            r12 = 0
            r13 = r2
            r14 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r13.getFirstStateRecord()     // Catch:{ all -> 0x010e }
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r15)     // Catch:{ all -> 0x010e }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r0     // Catch:{ all -> 0x010e }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x010e }
            r15 = r0
            r16 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r17 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x010e }
            r18 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x010e }
            r19 = r0
            r20 = 0
            monitor-enter(r19)     // Catch:{ all -> 0x010e }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r21 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00fe }
            androidx.compose.runtime.snapshots.Snapshot r21 = r21.getCurrent()     // Catch:{ all -> 0x00fe }
            r17 = r21
            r11 = r13
            androidx.compose.runtime.snapshots.StateObject r11 = (androidx.compose.runtime.snapshots.StateObject) r11     // Catch:{ all -> 0x00f6 }
            r22 = r1
            r1 = r17
            androidx.compose.runtime.snapshots.StateRecord r11 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r15, r11, r1)     // Catch:{ all -> 0x00f0 }
            androidx.compose.runtime.snapshots.SnapshotStateList$StateListStateRecord r11 = (androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord) r11     // Catch:{ all -> 0x00f0 }
            r17 = 0
            r23 = r0
            int r0 = r11.getModification$runtime_release()     // Catch:{ all -> 0x00f0 }
            if (r0 != r6) goto L_0x00bb
            r11.setList$runtime_release(r7)     // Catch:{ all -> 0x00b5 }
            int r0 = r11.getModification$runtime_release()     // Catch:{ all -> 0x00b5 }
            r21 = 1
            int r0 = r0 + 1
            r11.setModification$runtime_release(r0)     // Catch:{ all -> 0x00b5 }
            r0 = 1
            goto L_0x00bc
        L_0x00b5:
            r0 = move-exception
            r17 = r1
            r23 = r2
            goto L_0x0103
        L_0x00bb:
            r0 = 0
        L_0x00bc:
            r11 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r11)     // Catch:{ all -> 0x00ec }
            monitor-exit(r19)     // Catch:{ all -> 0x00ec }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r11)     // Catch:{ all -> 0x00ec }
            r11 = r0
            r17 = 0
            r23 = r2
            r2 = r13
            androidx.compose.runtime.snapshots.StateObject r2 = (androidx.compose.runtime.snapshots.StateObject) r2     // Catch:{ all -> 0x010c }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r2)     // Catch:{ all -> 0x010c }
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r8)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            if (r0 == 0) goto L_0x00e6
            r0 = 1
        L_0x00e3:
            return r0
        L_0x00e6:
            r1 = r22
            r2 = r23
            goto L_0x0007
        L_0x00ec:
            r0 = move-exception
            r23 = r2
            goto L_0x0113
        L_0x00f0:
            r0 = move-exception
            r23 = r2
            r17 = r1
            goto L_0x0103
        L_0x00f6:
            r0 = move-exception
            r22 = r1
            r23 = r2
            r1 = r17
            goto L_0x0103
        L_0x00fe:
            r0 = move-exception
            r22 = r1
            r23 = r2
        L_0x0103:
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch:{ all -> 0x010c }
            monitor-exit(r19)     // Catch:{ all -> 0x010c }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch:{ all -> 0x010c }
            throw r0     // Catch:{ all -> 0x010c }
        L_0x010c:
            r0 = move-exception
            goto L_0x0113
        L_0x010e:
            r0 = move-exception
            r22 = r1
            r23 = r2
        L_0x0113:
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r8)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        L_0x011c:
            r0 = move-exception
            r9 = r25
            r22 = r1
            r23 = r2
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r7)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateList.conditionalUpdate(kotlin.jvm.functions.Function1):boolean");
    }
}
