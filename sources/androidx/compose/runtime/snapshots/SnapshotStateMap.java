package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004:\u0001LB\u0005¢\u0006\u0002\u0010\u0005J1\u0010&\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*\u0012\u0004\u0012\u00020'0)H\bø\u0001\u0000¢\u0006\u0002\b+J1\u0010,\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010*\u0012\u0004\u0012\u00020'0)H\bø\u0001\u0000¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0015\u00100\u001a\u00020'2\u0006\u00101\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00102J\u0015\u00103\u001a\u00020'2\u0006\u00104\u001a\u00028\u0001H\u0016¢\u0006\u0002\u00102J\u0018\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\b\u00107\u001a\u00020'H\u0016J4\u00108\u001a\u0002H9\"\u0004\b\u0002\u001092\u001e\u0010:\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u0002H90)H\b¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020/2\u0006\u00104\u001a\u00020\u0011H\u0016J\u001f\u0010=\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u00002\u0006\u00104\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010>J\u001e\u0010?\u001a\u00020/2\u0014\u0010@\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u0017\u0010A\u001a\u0004\u0018\u00018\u00012\u0006\u00101\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00106J1\u0010B\u001a\u00020'2\u001e\u0010(\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\u0012\u0004\u0012\u00020'0)H\bø\u0001\u0000¢\u0006\u0002\bCJ\u0017\u0010D\u001a\u00020'2\u0006\u00104\u001a\u00028\u0001H\u0000¢\u0006\u0004\bE\u00102J\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007J5\u0010G\u001a\u00020/2*\u0010:\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010H\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010H0)H\bJ9\u0010I\u001a\u0002H9\"\u0004\b\u0002\u001092#\u0010:\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0004\u0012\u0002H90)¢\u0006\u0002\bJH\b¢\u0006\u0002\u0010;J9\u0010K\u001a\u0002H9\"\u0004\b\u0002\u001092#\u0010:\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c\u0012\u0004\u0012\u0002H90)¢\u0006\u0002\bJH\b¢\u0006\u0002\u0010;R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078AX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r0\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\u00188@X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c8@X\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001aR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010#X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u0002\u0007\n\u0005\b20\u0001¨\u0006M"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "K", "V", "", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/Map;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "keys", "getKeys", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "all", "", "predicate", "Lkotlin/Function1;", "", "all$runtime_release", "any", "any$runtime_release", "clear", "", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "mutate", "R", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "prependStateRecord", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "remove", "removeIf", "removeIf$runtime_release", "removeValue", "removeValue$runtime_release", "toMap", "update", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateMapStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateMap.kt */
public final class SnapshotStateMap<K, V> implements Map<K, V>, StateObject, KMutableMap {
    public static final int $stable = 0;
    private final Set<Map.Entry<K, V>> entries = new SnapshotMapEntrySet(this);
    private StateRecord firstStateRecord = new StateMapStateRecord(ExtensionsKt.persistentHashMapOf());
    private final Set<K> keys = new SnapshotMapKeySet(this);
    private final Collection<V> values = new SnapshotMapValueSet(this);

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.firstStateRecord = (StateMapStateRecord) value;
    }

    public final Map<K, V> toMap() {
        return getReadable$runtime_release().getMap$runtime_release();
    }

    public int getSize() {
        return getReadable$runtime_release().getMap$runtime_release().size();
    }

    public boolean containsKey(Object key) {
        return getReadable$runtime_release().getMap$runtime_release().containsKey(key);
    }

    public boolean containsValue(Object value) {
        return getReadable$runtime_release().getMap$runtime_release().containsValue(value);
    }

    public V get(Object key) {
        return getReadable$runtime_release().getMap$runtime_release().get(key);
    }

    public boolean isEmpty() {
        return getReadable$runtime_release().getMap$runtime_release().isEmpty();
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return this.entries;
    }

    public Set<K> getKeys() {
        return this.keys;
    }

    public Collection<V> getValues() {
        return this.values;
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
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void clear() {
        /*
            r25 = this;
            r1 = r25
            r2 = 0
            r3 = r1
            r4 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r3.getFirstStateRecord()
            java.lang.String r5 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r5)
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0
            r5 = r0
            androidx.compose.runtime.snapshots.StateRecord r5 = (androidx.compose.runtime.snapshots.StateRecord) r5
            r6 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.current(r5)
            r7 = r0
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r7 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r7
            r8 = 0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r0 = r7.getMap$runtime_release()
            r9 = 0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r0 = androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt.persistentHashMapOf()
            r9 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r0 = r7.getMap$runtime_release()
            if (r9 == r0) goto L_0x00b6
            java.lang.Object r10 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r11 = 0
            monitor-enter(r10)
            r12 = 0
            r13 = r1
            r14 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r13.getFirstStateRecord()     // Catch:{ all -> 0x00af }
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r15)     // Catch:{ all -> 0x00af }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x00af }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x00af }
            r15 = r0
            r16 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r17 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x00af }
            r18 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x00af }
            r19 = r0
            r20 = 0
            monitor-enter(r19)     // Catch:{ all -> 0x00af }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r21 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00a6 }
            androidx.compose.runtime.snapshots.Snapshot r21 = r21.getCurrent()     // Catch:{ all -> 0x00a6 }
            r17 = r21
            r21 = r0
            r0 = r13
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x009e }
            r22 = r1
            r1 = r17
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r15, r0, r1)     // Catch:{ all -> 0x0098 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x0098 }
            r17 = 0
            r0.setMap$runtime_release(r9)     // Catch:{ all -> 0x0098 }
            int r23 = r0.getModification$runtime_release()     // Catch:{ all -> 0x0098 }
            r24 = r2
            int r2 = r23 + 1
            r0.setModification$runtime_release(r2)     // Catch:{ all -> 0x0094 }
            monitor-exit(r19)     // Catch:{ all -> 0x00ad }
            r0 = r23
            r2 = 0
            r17 = r0
            r0 = r13
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00ad }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r0)     // Catch:{ all -> 0x00ad }
            monitor-exit(r10)
            goto L_0x00ba
        L_0x0094:
            r0 = move-exception
            r17 = r1
            goto L_0x00ab
        L_0x0098:
            r0 = move-exception
            r24 = r2
            r17 = r1
            goto L_0x00ab
        L_0x009e:
            r0 = move-exception
            r22 = r1
            r24 = r2
            r1 = r17
            goto L_0x00ab
        L_0x00a6:
            r0 = move-exception
            r22 = r1
            r24 = r2
        L_0x00ab:
            monitor-exit(r19)     // Catch:{ all -> 0x00ad }
            throw r0     // Catch:{ all -> 0x00ad }
        L_0x00ad:
            r0 = move-exception
            goto L_0x00b4
        L_0x00af:
            r0 = move-exception
            r22 = r1
            r24 = r2
        L_0x00b4:
            monitor-exit(r10)
            throw r0
        L_0x00b6:
            r22 = r1
            r24 = r2
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateMap.clear():void");
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
    public V put(K r26, V r27) {
        /*
            r25 = this;
            r1 = r25
            r2 = 0
            r0 = 0
            r3 = r0
        L_0x0005:
            r4 = 0
            r5 = 0
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r7 = 0
            monitor-enter(r6)
            r0 = 0
            r8 = r1
            r9 = 0
            androidx.compose.runtime.snapshots.StateRecord r10 = r8.getFirstStateRecord()     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)     // Catch:{ all -> 0x00fb }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r10 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r10     // Catch:{ all -> 0x00fb }
            androidx.compose.runtime.snapshots.StateRecord r10 = (androidx.compose.runtime.snapshots.StateRecord) r10     // Catch:{ all -> 0x00fb }
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = androidx.compose.runtime.snapshots.SnapshotKt.current(r10)     // Catch:{ all -> 0x00fb }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r12     // Catch:{ all -> 0x00fb }
            r13 = 0
            r8 = r12
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r9 = r8.getMap$runtime_release()     // Catch:{ all -> 0x00fb }
            r4 = r9
            int r9 = r8.getModification$runtime_release()     // Catch:{ all -> 0x00fb }
            r5 = r9
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00fb }
            monitor-exit(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder r6 = r4.builder()
            r0 = r6
            java.util.Map r0 = (java.util.Map) r0
            r7 = 0
            r8 = r26
            r9 = r27
            java.lang.Object r0 = r0.put(r8, r9)
            r3 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r7 = r6.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)
            if (r0 != 0) goto L_0x00f4
            java.lang.Object r10 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r11 = 0
            monitor-enter(r10)
            r12 = 0
            r13 = r1
            r14 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r13.getFirstStateRecord()     // Catch:{ all -> 0x00ed }
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r15)     // Catch:{ all -> 0x00ed }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x00ed }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x00ed }
            r15 = r0
            r16 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r17 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x00ed }
            r18 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x00ed }
            r19 = r0
            r20 = 0
            monitor-enter(r19)     // Catch:{ all -> 0x00ed }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r21 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00e4 }
            androidx.compose.runtime.snapshots.Snapshot r21 = r21.getCurrent()     // Catch:{ all -> 0x00e4 }
            r17 = r21
            r21 = r0
            r0 = r13
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00dc }
            r22 = r1
            r1 = r17
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r15, r0, r1)     // Catch:{ all -> 0x00d6 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x00d6 }
            r17 = 0
            r23 = r2
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00d2 }
            if (r2 != r5) goto L_0x00b2
            r0.setMap$runtime_release(r7)     // Catch:{ all -> 0x00d2 }
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00d2 }
            r24 = 1
            int r2 = r2 + 1
            r0.setModification$runtime_release(r2)     // Catch:{ all -> 0x00d2 }
            goto L_0x00b4
        L_0x00b2:
            r24 = 0
        L_0x00b4:
            monitor-exit(r19)     // Catch:{ all -> 0x00eb }
            r0 = r24
            r2 = 0
            r17 = r0
            r0 = r13
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00eb }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r0)     // Catch:{ all -> 0x00eb }
            monitor-exit(r10)
            if (r24 == 0) goto L_0x00cc
            goto L_0x00f8
        L_0x00cc:
            r1 = r22
            r2 = r23
            goto L_0x0005
        L_0x00d2:
            r0 = move-exception
            r17 = r1
            goto L_0x00e9
        L_0x00d6:
            r0 = move-exception
            r23 = r2
            r17 = r1
            goto L_0x00e9
        L_0x00dc:
            r0 = move-exception
            r22 = r1
            r23 = r2
            r1 = r17
            goto L_0x00e9
        L_0x00e4:
            r0 = move-exception
            r22 = r1
            r23 = r2
        L_0x00e9:
            monitor-exit(r19)     // Catch:{ all -> 0x00eb }
            throw r0     // Catch:{ all -> 0x00eb }
        L_0x00eb:
            r0 = move-exception
            goto L_0x00f2
        L_0x00ed:
            r0 = move-exception
            r22 = r1
            r23 = r2
        L_0x00f2:
            monitor-exit(r10)
            throw r0
        L_0x00f4:
            r22 = r1
            r23 = r2
        L_0x00f8:
            return r3
        L_0x00fb:
            r0 = move-exception
            r8 = r26
            r9 = r27
            r22 = r1
            r23 = r2
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateMap.put(java.lang.Object, java.lang.Object):java.lang.Object");
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void putAll(java.util.Map<? extends K, ? extends V> r24) {
        /*
            r23 = this;
            r1 = r24
            java.lang.String r0 = "from"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r2 = r23
            r3 = 0
            r0 = 0
            r4 = r0
        L_0x000c:
            r5 = 0
            r6 = 0
            java.lang.Object r7 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r8 = 0
            monitor-enter(r7)
            r0 = 0
            r9 = r2
            r10 = 0
            androidx.compose.runtime.snapshots.StateRecord r11 = r9.getFirstStateRecord()     // Catch:{ all -> 0x00f4 }
            java.lang.String r12 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11, r12)     // Catch:{ all -> 0x00f4 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r11 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r11     // Catch:{ all -> 0x00f4 }
            androidx.compose.runtime.snapshots.StateRecord r11 = (androidx.compose.runtime.snapshots.StateRecord) r11     // Catch:{ all -> 0x00f4 }
            r12 = 0
            androidx.compose.runtime.snapshots.StateRecord r13 = androidx.compose.runtime.snapshots.SnapshotKt.current(r11)     // Catch:{ all -> 0x00f4 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r13 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r13     // Catch:{ all -> 0x00f4 }
            r14 = 0
            r9 = r13
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r10 = r9.getMap$runtime_release()     // Catch:{ all -> 0x00f4 }
            r5 = r10
            int r10 = r9.getModification$runtime_release()     // Catch:{ all -> 0x00f4 }
            r6 = r10
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f4 }
            monitor-exit(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder r7 = r5.builder()
            r0 = r7
            java.util.Map r0 = (java.util.Map) r0
            r8 = 0
            r0.putAll(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r4 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r8 = r7.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r5)
            if (r0 != 0) goto L_0x00ef
            java.lang.Object r9 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r10 = 0
            monitor-enter(r9)
            r11 = 0
            r12 = r2
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r12.getFirstStateRecord()     // Catch:{ all -> 0x00ea }
            java.lang.String r14 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r14)     // Catch:{ all -> 0x00ea }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x00ea }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x00ea }
            r14 = r0
            r15 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r16 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x00ea }
            r17 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x00ea }
            r18 = r0
            r19 = 0
            monitor-enter(r18)     // Catch:{ all -> 0x00ea }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r20 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00e3 }
            androidx.compose.runtime.snapshots.Snapshot r20 = r20.getCurrent()     // Catch:{ all -> 0x00e3 }
            r16 = r20
            r20 = r0
            r0 = r12
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00dd }
            r1 = r16
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r14, r0, r1)     // Catch:{ all -> 0x00d7 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x00d7 }
            r16 = 0
            r21 = r2
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00d3 }
            if (r2 != r6) goto L_0x00b3
            r0.setMap$runtime_release(r8)     // Catch:{ all -> 0x00d3 }
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00d3 }
            r22 = 1
            int r2 = r2 + 1
            r0.setModification$runtime_release(r2)     // Catch:{ all -> 0x00d3 }
            goto L_0x00b5
        L_0x00b3:
            r22 = 0
        L_0x00b5:
            monitor-exit(r18)     // Catch:{ all -> 0x00e8 }
            r0 = r22
            r2 = 0
            r16 = r0
            r0 = r12
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00e8 }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r0)     // Catch:{ all -> 0x00e8 }
            monitor-exit(r9)
            if (r22 == 0) goto L_0x00cd
            goto L_0x00f1
        L_0x00cd:
            r1 = r24
            r2 = r21
            goto L_0x000c
        L_0x00d3:
            r0 = move-exception
            r16 = r1
            goto L_0x00e6
        L_0x00d7:
            r0 = move-exception
            r21 = r2
            r16 = r1
            goto L_0x00e6
        L_0x00dd:
            r0 = move-exception
            r21 = r2
            r1 = r16
            goto L_0x00e6
        L_0x00e3:
            r0 = move-exception
            r21 = r2
        L_0x00e6:
            monitor-exit(r18)     // Catch:{ all -> 0x00e8 }
            throw r0     // Catch:{ all -> 0x00e8 }
        L_0x00e8:
            r0 = move-exception
            goto L_0x00ed
        L_0x00ea:
            r0 = move-exception
            r21 = r2
        L_0x00ed:
            monitor-exit(r9)
            throw r0
        L_0x00ef:
            r21 = r2
        L_0x00f1:
            return
        L_0x00f4:
            r0 = move-exception
            r21 = r2
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateMap.putAll(java.util.Map):void");
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
    public V remove(androidx.compose.runtime.snapshots.Snapshot r25) {
        /*
            r24 = this;
            r1 = r24
            r2 = 0
            r0 = 0
            r3 = r0
        L_0x0005:
            r4 = 0
            r5 = 0
            java.lang.Object r6 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r7 = 0
            monitor-enter(r6)
            r0 = 0
            r8 = r1
            r9 = 0
            androidx.compose.runtime.snapshots.StateRecord r10 = r8.getFirstStateRecord()     // Catch:{ all -> 0x00f8 }
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)     // Catch:{ all -> 0x00f8 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r10 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r10     // Catch:{ all -> 0x00f8 }
            androidx.compose.runtime.snapshots.StateRecord r10 = (androidx.compose.runtime.snapshots.StateRecord) r10     // Catch:{ all -> 0x00f8 }
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = androidx.compose.runtime.snapshots.SnapshotKt.current(r10)     // Catch:{ all -> 0x00f8 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r12     // Catch:{ all -> 0x00f8 }
            r13 = 0
            r8 = r12
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r9 = r8.getMap$runtime_release()     // Catch:{ all -> 0x00f8 }
            r4 = r9
            int r9 = r8.getModification$runtime_release()     // Catch:{ all -> 0x00f8 }
            r5 = r9
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00f8 }
            monitor-exit(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder r6 = r4.builder()
            r0 = r6
            java.util.Map r0 = (java.util.Map) r0
            r7 = 0
            r8 = r25
            java.lang.Object r0 = r0.remove(r8)
            r3 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r7 = r6.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)
            if (r0 != 0) goto L_0x00f1
            java.lang.Object r9 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r10 = 0
            monitor-enter(r9)
            r11 = 0
            r12 = r1
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r12.getFirstStateRecord()     // Catch:{ all -> 0x00ea }
            java.lang.String r14 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r14)     // Catch:{ all -> 0x00ea }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x00ea }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x00ea }
            r14 = r0
            r15 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r16 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x00ea }
            r17 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x00ea }
            r18 = r0
            r19 = 0
            monitor-enter(r18)     // Catch:{ all -> 0x00ea }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r20 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00e1 }
            androidx.compose.runtime.snapshots.Snapshot r20 = r20.getCurrent()     // Catch:{ all -> 0x00e1 }
            r16 = r20
            r20 = r0
            r0 = r12
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00d9 }
            r21 = r1
            r1 = r16
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r14, r0, r1)     // Catch:{ all -> 0x00d3 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x00d3 }
            r16 = 0
            r22 = r2
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00cf }
            if (r2 != r5) goto L_0x00af
            r0.setMap$runtime_release(r7)     // Catch:{ all -> 0x00cf }
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00cf }
            r23 = 1
            int r2 = r2 + 1
            r0.setModification$runtime_release(r2)     // Catch:{ all -> 0x00cf }
            goto L_0x00b1
        L_0x00af:
            r23 = 0
        L_0x00b1:
            monitor-exit(r18)     // Catch:{ all -> 0x00e8 }
            r0 = r23
            r2 = 0
            r16 = r0
            r0 = r12
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00e8 }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r0)     // Catch:{ all -> 0x00e8 }
            monitor-exit(r9)
            if (r23 == 0) goto L_0x00c9
            goto L_0x00f5
        L_0x00c9:
            r1 = r21
            r2 = r22
            goto L_0x0005
        L_0x00cf:
            r0 = move-exception
            r16 = r1
            goto L_0x00e6
        L_0x00d3:
            r0 = move-exception
            r22 = r2
            r16 = r1
            goto L_0x00e6
        L_0x00d9:
            r0 = move-exception
            r21 = r1
            r22 = r2
            r1 = r16
            goto L_0x00e6
        L_0x00e1:
            r0 = move-exception
            r21 = r1
            r22 = r2
        L_0x00e6:
            monitor-exit(r18)     // Catch:{ all -> 0x00e8 }
            throw r0     // Catch:{ all -> 0x00e8 }
        L_0x00e8:
            r0 = move-exception
            goto L_0x00ef
        L_0x00ea:
            r0 = move-exception
            r21 = r1
            r22 = r2
        L_0x00ef:
            monitor-exit(r9)
            throw r0
        L_0x00f1:
            r21 = r1
            r22 = r2
        L_0x00f5:
            return r3
        L_0x00f8:
            r0 = move-exception
            r8 = r25
            r21 = r1
            r22 = r2
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateMap.remove(java.lang.Object):java.lang.Object");
    }

    public final int getModification$runtime_release() {
        return getReadable$runtime_release().getModification$runtime_release();
    }

    public final boolean removeValue$runtime_release(V value) {
        Object element$iv;
        Iterator it = entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            if (Intrinsics.areEqual(((Map.Entry) element$iv).getValue(), (Object) value)) {
                break;
            }
        }
        Map.Entry it2 = (Map.Entry) element$iv;
        if (it2 == null) {
            return false;
        }
        remove(it2.getKey());
        return true;
    }

    public final StateMapStateRecord<K, V> getReadable$runtime_release() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return (StateMapStateRecord) SnapshotKt.readable((StateMapStateRecord) firstStateRecord2, this);
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final boolean removeIf$runtime_release(kotlin.jvm.functions.Function1<? super java.util.Map.Entry<K, V>, java.lang.Boolean> r26) {
        /*
            r25 = this;
            r1 = r26
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r2 = 0
            r0 = 0
            r3 = r25
            r4 = 0
            r5 = 0
            r6 = r5
            r5 = r0
        L_0x0010:
            r7 = 0
            r8 = 0
            java.lang.Object r9 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r10 = 0
            monitor-enter(r9)
            r0 = 0
            r11 = r3
            r12 = 0
            r13 = 1
            androidx.compose.runtime.snapshots.StateRecord r14 = r11.getFirstStateRecord()     // Catch:{ all -> 0x0147 }
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14, r15)     // Catch:{ all -> 0x0147 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r14 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r14     // Catch:{ all -> 0x0147 }
            androidx.compose.runtime.snapshots.StateRecord r14 = (androidx.compose.runtime.snapshots.StateRecord) r14     // Catch:{ all -> 0x0147 }
            r15 = 0
            androidx.compose.runtime.snapshots.StateRecord r16 = androidx.compose.runtime.snapshots.SnapshotKt.current(r14)     // Catch:{ all -> 0x0147 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r16 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r16     // Catch:{ all -> 0x0147 }
            r17 = 0
            r11 = r16
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r12 = r11.getMap$runtime_release()     // Catch:{ all -> 0x0147 }
            r7 = r12
            int r12 = r11.getModification$runtime_release()     // Catch:{ all -> 0x0147 }
            r8 = r12
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0147 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r13)
            monitor-exit(r9)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r13)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder r9 = r7.builder()
            r0 = r9
            java.util.Map r0 = (java.util.Map) r0
            r10 = 0
            java.util.Set r11 = r25.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x0060:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0081
            java.lang.Object r12 = r11.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            java.lang.Object r14 = r1.invoke(r12)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x0060
            java.lang.Object r14 = r12.getKey()
            r0.remove(r14)
            r5 = 1
            goto L_0x0060
        L_0x0081:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r6 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r10 = r9.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r7)
            if (r0 != 0) goto L_0x0142
            java.lang.Object r11 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r12 = 0
            monitor-enter(r11)
            r14 = 0
            r15 = r3
            r16 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r15.getFirstStateRecord()     // Catch:{ all -> 0x0136 }
            java.lang.String r13 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r13)     // Catch:{ all -> 0x0136 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x0136 }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x0136 }
            r13 = r0
            r18 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r19 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x0136 }
            r20 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x0136 }
            r21 = r0
            r22 = 0
            monitor-enter(r21)     // Catch:{ all -> 0x0136 }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r23 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0128 }
            androidx.compose.runtime.snapshots.Snapshot r23 = r23.getCurrent()     // Catch:{ all -> 0x0128 }
            r19 = r23
            r23 = r0
            r0 = r15
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x0122 }
            r1 = r19
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r13, r0, r1)     // Catch:{ all -> 0x011c }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x011c }
            r19 = 0
            r24 = r2
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x0118 }
            if (r2 != r8) goto L_0x00ea
            r0.setMap$runtime_release(r10)     // Catch:{ all -> 0x0118 }
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x0118 }
            r17 = 1
            int r2 = r2 + 1
            r0.setModification$runtime_release(r2)     // Catch:{ all -> 0x0118 }
            r2 = 1
            goto L_0x00eb
        L_0x00ea:
            r2 = 0
        L_0x00eb:
            r17 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r17)     // Catch:{ all -> 0x0134 }
            monitor-exit(r21)     // Catch:{ all -> 0x0134 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r17)     // Catch:{ all -> 0x0134 }
            r0 = r2
            r19 = 0
            r20 = r0
            r0 = r15
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x0134 }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r0)     // Catch:{ all -> 0x0134 }
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r11)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            if (r2 == 0) goto L_0x0112
            goto L_0x0144
        L_0x0112:
            r1 = r26
            r2 = r24
            goto L_0x0010
        L_0x0118:
            r0 = move-exception
            r19 = r1
            goto L_0x012b
        L_0x011c:
            r0 = move-exception
            r24 = r2
            r19 = r1
            goto L_0x012b
        L_0x0122:
            r0 = move-exception
            r24 = r2
            r1 = r19
            goto L_0x012b
        L_0x0128:
            r0 = move-exception
            r24 = r2
        L_0x012b:
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch:{ all -> 0x0134 }
            monitor-exit(r21)     // Catch:{ all -> 0x0134 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch:{ all -> 0x0134 }
            throw r0     // Catch:{ all -> 0x0134 }
        L_0x0134:
            r0 = move-exception
            goto L_0x0139
        L_0x0136:
            r0 = move-exception
            r24 = r2
        L_0x0139:
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r11)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        L_0x0142:
            r24 = r2
        L_0x0144:
            return r5
        L_0x0147:
            r0 = move-exception
            r24 = r2
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r9)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateMap.removeIf$runtime_release(kotlin.jvm.functions.Function1):boolean");
    }

    public final boolean any$runtime_release(Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (Map.Entry entry : (ImmutableSet) getReadable$runtime_release().getMap$runtime_release().entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean all$runtime_release(Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (Map.Entry entry : (ImmutableSet) getReadable$runtime_release().getMap$runtime_release().entrySet()) {
            if (!predicate.invoke(entry).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public final Map<K, V> getDebuggerDisplayValue() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return ((StateMapStateRecord) SnapshotKt.current((StateMapStateRecord) firstStateRecord2)).getMap$runtime_release();
    }

    private final <R> R withCurrent(Function1<? super StateMapStateRecord<K, V>, ? extends R> block) {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        return block.invoke(SnapshotKt.current((StateMapStateRecord) firstStateRecord2));
    }

    private final <R> R writable(Function1<? super StateMapStateRecord<K, V>, ? extends R> block) {
        Snapshot current;
        R invoke;
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        StateRecord $this$writable$iv = (StateMapStateRecord) firstStateRecord2;
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
        r8 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.access$getSync$p();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005b, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        r12 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0 = getFirstStateRecord();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
        r14 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0;
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
        r9 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r14, r12, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009e, code lost:
        if (r9.getModification$runtime_release() != r4) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r9.setMap$runtime_release(r6);
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
    private final <R> R mutate(kotlin.jvm.functions.Function1<? super java.util.Map<K, V>, ? extends R> r24) {
        /*
            r23 = this;
            r1 = 0
            r0 = 0
            r2 = r0
        L_0x0003:
            r3 = 0
            r4 = 0
            java.lang.Object r5 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r6 = 0
            monitor-enter(r5)
            r0 = 0
            r7 = r23
            r8 = 0
            r9 = 1
            androidx.compose.runtime.snapshots.StateRecord r10 = r7.getFirstStateRecord()     // Catch:{ all -> 0x011f }
            java.lang.String r11 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)     // Catch:{ all -> 0x011f }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r10 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r10     // Catch:{ all -> 0x011f }
            androidx.compose.runtime.snapshots.StateRecord r10 = (androidx.compose.runtime.snapshots.StateRecord) r10     // Catch:{ all -> 0x011f }
            r11 = 0
            androidx.compose.runtime.snapshots.StateRecord r12 = androidx.compose.runtime.snapshots.SnapshotKt.current(r10)     // Catch:{ all -> 0x011f }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r12 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r12     // Catch:{ all -> 0x011f }
            r13 = 0
            r7 = r12
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r8 = r7.getMap$runtime_release()     // Catch:{ all -> 0x011f }
            r3 = r8
            int r8 = r7.getModification$runtime_release()     // Catch:{ all -> 0x0117 }
            r4 = r8
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0117 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r9)
            monitor-exit(r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder r5 = r3.builder()
            r7 = r24
            java.lang.Object r2 = r7.invoke(r5)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r6 = r5.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r3)
            if (r0 != 0) goto L_0x0111
            java.lang.Object r8 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r10 = 0
            monitor-enter(r8)
            r11 = 0
            r12 = r23
            r13 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r12.getFirstStateRecord()     // Catch:{ all -> 0x0103 }
            java.lang.String r14 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r14)     // Catch:{ all -> 0x0103 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x0103 }
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
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r9 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r9     // Catch:{ all -> 0x00e5 }
            r16 = 0
            r22 = r0
            int r0 = r9.getModification$runtime_release()     // Catch:{ all -> 0x00e5 }
            if (r0 != r4) goto L_0x00b6
            r9.setMap$runtime_release(r6)     // Catch:{ all -> 0x00b0 }
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateMap.mutate(kotlin.jvm.functions.Function1):java.lang.Object");
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
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private final void update(kotlin.jvm.functions.Function1<? super androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, ? extends V>, ? extends androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap<K, ? extends V>> r26) {
        /*
            r25 = this;
            r1 = 0
            r2 = r25
            r3 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r2.getFirstStateRecord()
            java.lang.String r4 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r4)
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0
            r4 = r0
            androidx.compose.runtime.snapshots.StateRecord r4 = (androidx.compose.runtime.snapshots.StateRecord) r4
            r5 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.current(r4)
            r6 = r0
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r6 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r6
            r7 = 0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r0 = r6.getMap$runtime_release()
            r8 = r26
            java.lang.Object r0 = r8.invoke(r0)
            r9 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r9 = (androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap) r9
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r0 = r6.getMap$runtime_release()
            if (r9 == r0) goto L_0x00d5
            java.lang.Object r10 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r11 = 0
            monitor-enter(r10)
            r12 = 0
            r13 = r25
            r14 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r13.getFirstStateRecord()     // Catch:{ all -> 0x00c7 }
            java.lang.String r15 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r15)     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x00c7 }
            r15 = r0
            r16 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r17 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x00c7 }
            r18 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x00c7 }
            r19 = r0
            r20 = 0
            monitor-enter(r19)     // Catch:{ all -> 0x00c7 }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r21 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x00b7 }
            androidx.compose.runtime.snapshots.Snapshot r21 = r21.getCurrent()     // Catch:{ all -> 0x00b7 }
            r17 = r21
            r21 = r0
            r0 = r13
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00af }
            r22 = r1
            r1 = r17
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r15, r0, r1)     // Catch:{ all -> 0x00a9 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x00a9 }
            r17 = 0
            r0.setMap$runtime_release(r9)     // Catch:{ all -> 0x00a9 }
            int r23 = r0.getModification$runtime_release()     // Catch:{ all -> 0x00a9 }
            r24 = r2
            int r2 = r23 + 1
            r0.setModification$runtime_release(r2)     // Catch:{ all -> 0x00a5 }
            r2 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)     // Catch:{ all -> 0x00c5 }
            monitor-exit(r19)     // Catch:{ all -> 0x00c5 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)     // Catch:{ all -> 0x00c5 }
            r0 = r23
            r2 = 0
            r17 = r0
            r0 = r13
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x00c5 }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r1, r0)     // Catch:{ all -> 0x00c5 }
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r10)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            goto L_0x00d9
        L_0x00a5:
            r0 = move-exception
            r17 = r1
            goto L_0x00bc
        L_0x00a9:
            r0 = move-exception
            r24 = r2
            r17 = r1
            goto L_0x00bc
        L_0x00af:
            r0 = move-exception
            r22 = r1
            r24 = r2
            r1 = r17
            goto L_0x00bc
        L_0x00b7:
            r0 = move-exception
            r22 = r1
            r24 = r2
        L_0x00bc:
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)     // Catch:{ all -> 0x00c5 }
            monitor-exit(r19)     // Catch:{ all -> 0x00c5 }
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)     // Catch:{ all -> 0x00c5 }
            throw r0     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r0 = move-exception
            goto L_0x00cc
        L_0x00c7:
            r0 = move-exception
            r22 = r1
            r24 = r2
        L_0x00cc:
            r1 = 1
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            monitor-exit(r10)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r0
        L_0x00d5:
            r22 = r1
            r24 = r2
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateMap.update(kotlin.jvm.functions.Function1):void");
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\b\u0000\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "K", "V", "Landroidx/compose/runtime/snapshots/StateRecord;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "getMap$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "setMap$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnapshotStateMap.kt */
    public static final class StateMapStateRecord<K, V> extends StateRecord {
        private PersistentMap<K, ? extends V> map;
        private int modification;

        public final PersistentMap<K, V> getMap$runtime_release() {
            return this.map;
        }

        public final void setMap$runtime_release(PersistentMap<K, ? extends V> persistentMap) {
            Intrinsics.checkNotNullParameter(persistentMap, "<set-?>");
            this.map = persistentMap;
        }

        public StateMapStateRecord(PersistentMap<K, ? extends V> map2) {
            Intrinsics.checkNotNullParameter(map2, "map");
            this.map = map2;
        }

        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setModification$runtime_release(int i) {
            this.modification = i;
        }

        public void assign(StateRecord value) {
            Intrinsics.checkNotNullParameter(value, "value");
            StateMapStateRecord other = (StateMapStateRecord) value;
            synchronized (SnapshotStateMapKt.sync) {
                this.map = other.map;
                this.modification = other.modification;
                Unit unit = Unit.INSTANCE;
            }
        }

        public StateRecord create() {
            return new StateMapStateRecord(this.map);
        }
    }
}
