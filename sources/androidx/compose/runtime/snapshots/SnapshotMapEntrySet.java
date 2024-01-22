package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u000b\u001a\u00020\t2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\u001d\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0002J\"\u0010\u0010\u001a\u00020\u000f2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\u001b\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0012H\u0002J\u001c\u0010\u0013\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u0014\u001a\u00020\u000f2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\"\u0010\u0015\u001a\u00020\u000f2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotMapEntrySet;", "K", "V", "Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "add", "", "element", "addAll", "elements", "", "contains", "", "containsAll", "iterator", "", "remove", "removeAll", "retainAll", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateMap.kt */
final class SnapshotMapEntrySet<K, V> extends SnapshotMapSet<K, V, Map.Entry<K, V>> {
    public /* bridge */ /* synthetic */ boolean add(Object element) {
        return ((Boolean) add((Map.Entry) element)).booleanValue();
    }

    public final /* bridge */ boolean contains(Object element) {
        if (!TypeIntrinsics.isMutableMapEntry(element)) {
            return false;
        }
        return contains((Map.Entry) element);
    }

    public final /* bridge */ boolean remove(Object element) {
        if (!TypeIntrinsics.isMutableMapEntry(element)) {
            return false;
        }
        return remove((Map.Entry) element);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnapshotMapEntrySet(SnapshotStateMap<K, V> map) {
        super(map);
        Intrinsics.checkNotNullParameter(map, "map");
    }

    public Void add(Map.Entry<K, V> element) {
        Intrinsics.checkNotNullParameter(element, "element");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public Void addAll(Collection<? extends Map.Entry<K, V>> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new StateMapMutableEntriesIterator<>(getMap(), ((ImmutableSet) getMap().getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator());
    }

    public boolean remove(Map.Entry<K, V> element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return getMap().remove(element.getKey()) != null;
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean removed = false;
        Iterator<? extends Object> it = elements.iterator();
        while (it.hasNext()) {
            removed = getMap().remove(((Map.Entry) it.next()).getKey()) != null || removed;
        }
        return removed;
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
    public boolean retainAll(java.util.Collection<? extends java.lang.Object> r29) {
        /*
            r28 = this;
            r1 = r29
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = r1
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r2 = 0
            r3 = 10
            int r3 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r3)
            int r3 = kotlin.collections.MapsKt.mapCapacity(r3)
            r4 = 16
            int r3 = kotlin.ranges.RangesKt.coerceAtLeast((int) r3, (int) r4)
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>(r3)
            java.util.Map r4 = (java.util.Map) r4
            r5 = r0
            r6 = 0
            java.util.Iterator r7 = r5.iterator()
        L_0x0028:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x004e
            java.lang.Object r8 = r7.next()
            r9 = r8
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            r10 = 0
            java.lang.Object r11 = r9.getKey()
            java.lang.Object r12 = r9.getValue()
            kotlin.Pair r9 = kotlin.TuplesKt.to(r11, r12)
            java.lang.Object r10 = r9.getFirst()
            java.lang.Object r9 = r9.getSecond()
            r4.put(r10, r9)
            goto L_0x0028
        L_0x004e:
            r2 = r4
            androidx.compose.runtime.snapshots.SnapshotStateMap r3 = r28.getMap()
            r4 = 0
            r0 = 0
            r5 = r3
            r6 = 0
            r7 = 0
            r8 = r7
            r7 = r0
        L_0x005c:
            r9 = 0
            r10 = 0
            java.lang.Object r11 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r12 = 0
            monitor-enter(r11)
            r0 = 0
            r13 = r5
            r14 = 0
            androidx.compose.runtime.snapshots.StateRecord r15 = r13.getFirstStateRecord()     // Catch:{ all -> 0x01a5 }
            r16 = r0
            java.lang.String r0 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15, r0)     // Catch:{ all -> 0x01a5 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r15 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r15     // Catch:{ all -> 0x01a5 }
            androidx.compose.runtime.snapshots.StateRecord r15 = (androidx.compose.runtime.snapshots.StateRecord) r15     // Catch:{ all -> 0x01a5 }
            r0 = r15
            r15 = 0
            androidx.compose.runtime.snapshots.StateRecord r17 = androidx.compose.runtime.snapshots.SnapshotKt.current(r0)     // Catch:{ all -> 0x01a5 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r17 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r17     // Catch:{ all -> 0x01a5 }
            r18 = 0
            r0 = r17
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r13 = r0.getMap$runtime_release()     // Catch:{ all -> 0x01a5 }
            r9 = r13
            int r13 = r0.getModification$runtime_release()     // Catch:{ all -> 0x01a5 }
            r10 = r13
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01a5 }
            monitor-exit(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap$Builder r11 = r9.builder()
            r0 = r11
            java.util.Map r0 = (java.util.Map) r0
            r12 = 0
            java.util.Set r13 = r3.entrySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x00a8:
            boolean r14 = r13.hasNext()
            r16 = 1
            if (r14 == 0) goto L_0x00eb
            java.lang.Object r14 = r13.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r17 = r14
            r18 = 0
            java.lang.Object r15 = r17.getKey()
            boolean r15 = r2.containsKey(r15)
            if (r15 == 0) goto L_0x00d9
            java.lang.Object r15 = r17.getKey()
            java.lang.Object r15 = r2.get(r15)
            java.lang.Object r1 = r17.getValue()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r1)
            if (r1 != 0) goto L_0x00d7
            goto L_0x00d9
        L_0x00d7:
            r15 = 0
            goto L_0x00db
        L_0x00d9:
            r15 = r16
        L_0x00db:
            if (r15 == 0) goto L_0x00e8
            java.lang.Object r1 = r14.getKey()
            r0.remove(r1)
            r7 = 1
            r1 = r29
            goto L_0x00a8
        L_0x00e8:
            r1 = r29
            goto L_0x00a8
        L_0x00eb:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r8 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap r1 = r11.build()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r9)
            if (r0 != 0) goto L_0x019d
            java.lang.Object r12 = androidx.compose.runtime.snapshots.SnapshotStateMapKt.sync
            r13 = 0
            monitor-enter(r12)
            r14 = 0
            r15 = r5
            r17 = 0
            androidx.compose.runtime.snapshots.StateRecord r0 = r15.getFirstStateRecord()     // Catch:{ all -> 0x0196 }
            r18 = r2
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r2)     // Catch:{ all -> 0x0192 }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x0192 }
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0     // Catch:{ all -> 0x0192 }
            r2 = r0
            r20 = 0
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot r21 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()     // Catch:{ all -> 0x0192 }
            r22 = 0
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()     // Catch:{ all -> 0x0192 }
            r23 = r0
            r24 = 0
            monitor-enter(r23)     // Catch:{ all -> 0x0192 }
            r0 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r25 = androidx.compose.runtime.snapshots.Snapshot.Companion     // Catch:{ all -> 0x0189 }
            androidx.compose.runtime.snapshots.Snapshot r25 = r25.getCurrent()     // Catch:{ all -> 0x0189 }
            r21 = r25
            r25 = r0
            r0 = r15
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x0181 }
            r26 = r3
            r3 = r21
            androidx.compose.runtime.snapshots.StateRecord r0 = androidx.compose.runtime.snapshots.SnapshotKt.writableRecord(r2, r0, r3)     // Catch:{ all -> 0x017b }
            androidx.compose.runtime.snapshots.SnapshotStateMap$StateMapStateRecord r0 = (androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord) r0     // Catch:{ all -> 0x017b }
            r21 = 0
            r27 = r2
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x0177 }
            if (r2 != r10) goto L_0x0155
            r0.setMap$runtime_release(r1)     // Catch:{ all -> 0x0177 }
            int r2 = r0.getModification$runtime_release()     // Catch:{ all -> 0x0177 }
            int r2 = r2 + 1
            r0.setModification$runtime_release(r2)     // Catch:{ all -> 0x0177 }
            goto L_0x0157
        L_0x0155:
            r16 = 0
        L_0x0157:
            monitor-exit(r23)     // Catch:{ all -> 0x0190 }
            r0 = r16
            r2 = 0
            r19 = r0
            r0 = r15
            androidx.compose.runtime.snapshots.StateObject r0 = (androidx.compose.runtime.snapshots.StateObject) r0     // Catch:{ all -> 0x0190 }
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r3, r0)     // Catch:{ all -> 0x0190 }
            monitor-exit(r12)
            if (r16 == 0) goto L_0x016f
            goto L_0x01a1
        L_0x016f:
            r1 = r29
            r2 = r18
            r3 = r26
            goto L_0x005c
        L_0x0177:
            r0 = move-exception
            r21 = r3
            goto L_0x018e
        L_0x017b:
            r0 = move-exception
            r27 = r2
            r21 = r3
            goto L_0x018e
        L_0x0181:
            r0 = move-exception
            r27 = r2
            r26 = r3
            r3 = r21
            goto L_0x018e
        L_0x0189:
            r0 = move-exception
            r27 = r2
            r26 = r3
        L_0x018e:
            monitor-exit(r23)     // Catch:{ all -> 0x0190 }
            throw r0     // Catch:{ all -> 0x0190 }
        L_0x0190:
            r0 = move-exception
            goto L_0x019b
        L_0x0192:
            r0 = move-exception
            r26 = r3
            goto L_0x019b
        L_0x0196:
            r0 = move-exception
            r18 = r2
            r26 = r3
        L_0x019b:
            monitor-exit(r12)
            throw r0
        L_0x019d:
            r18 = r2
            r26 = r3
        L_0x01a1:
            return r7
        L_0x01a5:
            r0 = move-exception
            r18 = r2
            r26 = r3
            monitor-exit(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotMapEntrySet.retainAll(java.util.Collection):boolean");
    }

    public boolean contains(Map.Entry<K, V> element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return Intrinsics.areEqual(getMap().get(element.getKey()), (Object) element.getValue());
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterable<Map.Entry> $this$all$iv = elements;
        if (((Collection) $this$all$iv).isEmpty()) {
            return true;
        }
        for (Map.Entry it : $this$all$iv) {
            if (!contains((Object) it)) {
                return false;
            }
        }
        return true;
    }
}
