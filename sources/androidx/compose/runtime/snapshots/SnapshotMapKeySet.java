package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import java.util.Collection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013H\u0002J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0015\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016J\u0016\u0010\u0016\u001a\u00020\u000f2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotMapKeySet;", "K", "V", "Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "add", "", "element", "(Ljava/lang/Object;)Ljava/lang/Void;", "addAll", "elements", "", "contains", "", "(Ljava/lang/Object;)Z", "containsAll", "iterator", "Landroidx/compose/runtime/snapshots/StateMapMutableKeysIterator;", "remove", "removeAll", "retainAll", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateMap.kt */
final class SnapshotMapKeySet<K, V> extends SnapshotMapSet<K, V, K> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapshotMapKeySet(SnapshotStateMap<K, V> map) {
        super(map);
        Intrinsics.checkNotNullParameter(map, "map");
    }

    public Void add(K element) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public Void addAll(Collection<? extends K> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public StateMapMutableKeysIterator<K, V> iterator() {
        return new StateMapMutableKeysIterator<>(getMap(), ((ImmutableSet) getMap().getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator());
    }

    public boolean remove(Object element) {
        return getMap().remove(element) != null;
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean removed = false;
        for (Object element$iv : elements) {
            removed = getMap().remove(element$iv) != null || removed;
        }
        return removed;
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
    public boolean retainAll(java.util.Collection<? extends java.lang.Object> r28) {
        /*
            r27 = this;
            r1 = r28
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = r1
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Set r2 = kotlin.collections.CollectionsKt.toSet(r0)
            androidx.compose.runtime.snapshots.SnapshotStateMap r3 = r27.getMap()
            r4 = 0
            r0 = 0
            r5 = r3
            r6 = 0
            r7 = 0
            r8 = r7
            r7 = r0
        L_0x0019:
            r9 = 0
            r10 = 0
            java.lang.Object r11 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r12 = 0
            monitor-enter(r11)
            r0 = 0
            r13 = r5
            r14 = 0
            androidx.compose.runtime.snapshots.StateRecord r15 = r13.getFirstStateRecord()     // Catch:{ all -> 0x0140 }
            r16 = r0
            java.lang.String r0 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15, r0)     // Catch:{ all -> 0x0140 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r15 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r15     // Catch:{ all -> 0x0140 }
            androidx.compose.runtime.snapshots.StateRecord r15 = (androidx.compose.runtime.snapshots.StateRecord) r15     // Catch:{ all -> 0x0140 }
            r0 = r15
            r15 = 0
            androidx.compose.runtime.snapshots.StateRecord r17 = androidx.compose.runtime.snapshots.SnapshotKt.current(r0)     // Catch:{ all -> 0x0140 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r17 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r17     // Catch:{ all -> 0x0140 }
            r18 = 0
            r0 = r17
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r13 = r0.getMap$runtime_release()     // Catch:{ all -> 0x0140 }
            r9 = r13
            int r13 = r0.getModification$runtime_release()     // Catch:{ all -> 0x0140 }
            r10 = r13
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0140 }
            monitor-exit(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder r11 = r9.builder()
            r0 = r11
            java.util.Map r0 = (java.util.Map) r0
            r12 = 0
            java.util.Set r13 = r3.entrySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x0065:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x008c
            java.lang.Object r14 = r13.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r16 = r14
            r17 = 0
            java.lang.Object r15 = r16.getKey()
            boolean r15 = r2.contains(r15)
            r16 = 1
            r15 = r15 ^ 1
            if (r15 == 0) goto L_0x0065
            java.lang.Object r15 = r14.getKey()
            r0.remove(r15)
            r7 = 1
            goto L_0x0065
        L_0x008c:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r8 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r12 = r11.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r9)
            if (r0 != 0) goto L_0x013a
            java.lang.Object r13 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r14 = 0
            monitor-enter(r13)
            r15 = 0
            r16 = r5
            r17 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r16.getFirstStateRecord()     // Catch:{ all -> 0x0135 }
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)     // Catch:{ all -> 0x0135 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x0135 }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x0135 }
            r1 = r0
            r19 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r20 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x0135 }
            r21 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x0135 }
            r22 = r0
            r23 = 0
            monitor-enter(r22)     // Catch:{ all -> 0x0135 }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r24 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x012c }
            androidx.compose.runtime.snapshots.Snapshot r24 = r24.getCurrent()     // Catch:{ all -> 0x012c }
            r20 = r24
            r24 = r0
            r0 = r16
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x0124 }
            r25 = r2
            r2 = r20
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r1, r0, r2)     // Catch:{ all -> 0x011e }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x011e }
            r20 = 0
            r26 = r1
            int r1 = r0.getModification$runtime_release()     // Catch:{ all -> 0x011a }
            if (r1 != r10) goto L_0x00fa
            r0.setMap$runtime_release(r12)     // Catch:{ all -> 0x011a }
            int r1 = r0.getModification$runtime_release()     // Catch:{ all -> 0x011a }
            r18 = 1
            int r1 = r1 + 1
            r0.setModification$runtime_release(r1)     // Catch:{ all -> 0x011a }
            r1 = r18
            goto L_0x00fb
        L_0x00fa:
            r1 = 0
        L_0x00fb:
            monitor-exit(r22)     // Catch:{ all -> 0x0133 }
            r0 = r1
            r18 = 0
            r20 = r0
            r0 = r16
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x0133 }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r2, r0)     // Catch:{ all -> 0x0133 }
            monitor-exit(r13)
            if (r1 == 0) goto L_0x0114
            goto L_0x013c
        L_0x0114:
            r1 = r28
            r2 = r25
            goto L_0x0019
        L_0x011a:
            r0 = move-exception
            r20 = r2
            goto L_0x0131
        L_0x011e:
            r0 = move-exception
            r26 = r1
            r20 = r2
            goto L_0x0131
        L_0x0124:
            r0 = move-exception
            r26 = r1
            r25 = r2
            r2 = r20
            goto L_0x0131
        L_0x012c:
            r0 = move-exception
            r26 = r1
            r25 = r2
        L_0x0131:
            monitor-exit(r22)     // Catch:{ all -> 0x0133 }
            throw r0     // Catch:{ all -> 0x0133 }
        L_0x0133:
            r0 = move-exception
            goto L_0x0138
        L_0x0135:
            r0 = move-exception
            r25 = r2
        L_0x0138:
            monitor-exit(r13)
            throw r0
        L_0x013a:
            r25 = r2
        L_0x013c:
            return r7
        L_0x0140:
            r0 = move-exception
            r25 = r2
            monitor-exit(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotMapKeySet.retainAll(java.util.Collection):boolean");
    }

    public boolean contains(Object element) {
        return getMap().containsKey(element);
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterable<Object> $this$all$iv = elements;
        if (((Collection) $this$all$iv).isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            if (!getMap().containsKey(element$iv)) {
                return false;
            }
        }
        return true;
    }
}
