package androidx.compose.ui.text.caches;

import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0019J\u0006\u0010\u0007\u001a\u00020\u0005J/\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u00012\b\u0010\u001f\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u001bJ\u0006\u0010\b\u001a\u00020\u0005J\u0015\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u001d\u0010#\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001¢\u0006\u0002\u0010%J\u0006\u0010\u0013\u001a\u00020\u0005J\u0015\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010(\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010)J\u001d\u0010*\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010)J\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010,J'\u0010-\u001a\u0002H.\"\u0004\b\u0002\u0010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H.00H\bø\u0001\u0000¢\u0006\u0004\b1\u00102J\b\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000bj\b\u0012\u0004\u0012\u00028\u0000`\fX\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000ej\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00058G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0002\u0007\n\u0005\b20\u0001¨\u00066"}, d2 = {"Landroidx/compose/ui/text/caches/LruCache;", "K", "V", "", "maxSize", "", "(I)V", "createCount", "evictionCount", "hitCount", "keySet", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "missCount", "monitor", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "putCount", "<set-?>", "size", "()I", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "evictAll", "get", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "resize", "safeSizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "sizeOf", "snapshot", "", "synchronizedValue", "R", "block", "Lkotlin/Function0;", "synchronizedValue$ui_text_release", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toString", "", "trimToSize", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LruCache.kt */
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashSet<K> keySet;
    private final HashMap<K, V> map;
    private int maxSize;
    private int missCount;
    /* access modifiers changed from: private */
    public final SynchronizedObject monitor = Synchronization_jvmKt.createSynchronizedObject();
    private int putCount;
    private int size;

    public final int size() {
        int i;
        synchronized (this.monitor) {
            i = this.size;
        }
        return i;
    }

    public LruCache(int maxSize2) {
        if (maxSize2 > 0) {
            this.maxSize = maxSize2;
            this.map = new HashMap<>(0, 0.75f);
            this.keySet = new LinkedHashSet<>();
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    public void resize(int maxSize2) {
        if (maxSize2 > 0) {
            synchronized (this.monitor) {
                this.maxSize = maxSize2;
                Unit unit = Unit.INSTANCE;
            }
            trimToSize(maxSize2);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        r1 = create(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r1 != null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        r2 = r8.monitor;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r8.createCount++;
        r5 = r8.map.put(r9, r1);
        r8.keySet.remove(r9);
        r8.keySet.add(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        if (r5 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        r8.map.put(r9, r5);
        r0 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        r8.size = size() + safeSizeOf(r9, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
        r4 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0064, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
        if (r0 == null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0067, code lost:
        entryRemoved(false, r9, r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006b, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006c, code lost:
        trimToSize(r8.maxSize);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0071, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K r9) {
        /*
            r8 = this;
            r0 = 0
            androidx.compose.ui.text.platform.SynchronizedObject r1 = r8.monitor
            r2 = 0
            monitor-enter(r1)
            r3 = 0
            java.util.HashMap<K, V> r4 = r8.map     // Catch:{ all -> 0x0075 }
            java.lang.Object r4 = r4.get(r9)     // Catch:{ all -> 0x0075 }
            r0 = r4
            if (r0 == 0) goto L_0x0022
            java.util.LinkedHashSet<K> r4 = r8.keySet     // Catch:{ all -> 0x0075 }
            r4.remove(r9)     // Catch:{ all -> 0x0075 }
            java.util.LinkedHashSet<K> r4 = r8.keySet     // Catch:{ all -> 0x0075 }
            r4.add(r9)     // Catch:{ all -> 0x0075 }
            int r4 = r8.hitCount     // Catch:{ all -> 0x0075 }
            int r4 = r4 + 1
            r8.hitCount = r4     // Catch:{ all -> 0x0075 }
            monitor-exit(r1)
            return r0
        L_0x0022:
            int r4 = r8.missCount     // Catch:{ all -> 0x0075 }
            int r4 = r4 + 1
            r8.missCount = r4     // Catch:{ all -> 0x0075 }
            monitor-exit(r1)
            java.lang.Object r1 = r8.create(r9)
            if (r1 != 0) goto L_0x0032
            r2 = 0
            return r2
        L_0x0032:
            androidx.compose.ui.text.platform.SynchronizedObject r2 = r8.monitor
            r3 = 0
            monitor-enter(r2)
            r4 = 0
            int r5 = r8.createCount     // Catch:{ all -> 0x0072 }
            int r5 = r5 + 1
            r8.createCount = r5     // Catch:{ all -> 0x0072 }
            java.util.HashMap<K, V> r5 = r8.map     // Catch:{ all -> 0x0072 }
            java.lang.Object r5 = r5.put(r9, r1)     // Catch:{ all -> 0x0072 }
            java.util.LinkedHashSet<K> r6 = r8.keySet     // Catch:{ all -> 0x0072 }
            r6.remove(r9)     // Catch:{ all -> 0x0072 }
            java.util.LinkedHashSet<K> r6 = r8.keySet     // Catch:{ all -> 0x0072 }
            r6.add(r9)     // Catch:{ all -> 0x0072 }
            if (r5 == 0) goto L_0x0056
            java.util.HashMap<K, V> r6 = r8.map     // Catch:{ all -> 0x0072 }
            r6.put(r9, r5)     // Catch:{ all -> 0x0072 }
            r0 = r5
            goto L_0x0061
        L_0x0056:
            int r6 = r8.size()     // Catch:{ all -> 0x0072 }
            int r7 = r8.safeSizeOf(r9, r1)     // Catch:{ all -> 0x0072 }
            int r6 = r6 + r7
            r8.size = r6     // Catch:{ all -> 0x0072 }
        L_0x0061:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0072 }
            monitor-exit(r2)
            if (r0 == 0) goto L_0x006c
            r2 = 0
            r8.entryRemoved(r2, r9, r1, r0)
            return r0
        L_0x006c:
            int r2 = r8.maxSize
            r8.trimToSize(r2)
            return r1
        L_0x0072:
            r4 = move-exception
            monitor-exit(r2)
            throw r4
        L_0x0075:
            r3 = move-exception
            monitor-exit(r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.caches.LruCache.get(java.lang.Object):java.lang.Object");
    }

    public final V put(K key, V value) {
        Object previous;
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        synchronized (this.monitor) {
            this.putCount++;
            this.size = size() + safeSizeOf(key, value);
            previous = this.map.put(key, value);
            if (previous != null) {
                this.size = size() - safeSizeOf(key, previous);
            }
            if (this.keySet.contains(key)) {
                this.keySet.remove(key);
            }
            this.keySet.add(key);
        }
        if (previous != null) {
            entryRemoved(false, key, previous, value);
        }
        trimToSize(this.maxSize);
        return previous;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a2, code lost:
        throw new java.lang.IllegalStateException("map/keySet size inconsistency");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r9) {
        /*
            r8 = this;
        L_0x0001:
            r0 = 0
            r1 = 0
            androidx.compose.ui.text.platform.SynchronizedObject r2 = r8.monitor
            r3 = 0
            monitor-enter(r2)
            r4 = 0
            int r5 = r8.size()     // Catch:{ all -> 0x00a3 }
            if (r5 < 0) goto L_0x009a
            java.util.HashMap<K, V> r5 = r8.map     // Catch:{ all -> 0x00a3 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x00a3 }
            if (r5 == 0) goto L_0x001d
            int r5 = r8.size()     // Catch:{ all -> 0x00a3 }
            if (r5 != 0) goto L_0x009a
        L_0x001d:
            java.util.HashMap<K, V> r5 = r8.map     // Catch:{ all -> 0x00a3 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x00a3 }
            java.util.LinkedHashSet<K> r6 = r8.keySet     // Catch:{ all -> 0x00a3 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x00a3 }
            if (r5 != r6) goto L_0x009a
            int r5 = r8.size()     // Catch:{ all -> 0x00a3 }
            r6 = 1
            if (r5 <= r9) goto L_0x0084
            java.util.HashMap<K, V> r5 = r8.map     // Catch:{ all -> 0x00a3 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x00a3 }
            if (r5 != 0) goto L_0x0084
            java.util.LinkedHashSet<K> r5 = r8.keySet     // Catch:{ all -> 0x00a3 }
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ all -> 0x00a3 }
            java.lang.Object r5 = kotlin.collections.CollectionsKt.first(r5)     // Catch:{ all -> 0x00a3 }
            r0 = r5
            java.util.HashMap<K, V> r5 = r8.map     // Catch:{ all -> 0x00a3 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ all -> 0x00a3 }
            java.lang.Object r5 = r5.get(r0)     // Catch:{ all -> 0x00a3 }
            if (r5 == 0) goto L_0x007b
            r1 = r5
            java.util.HashMap<K, V> r5 = r8.map     // Catch:{ all -> 0x00a3 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ all -> 0x00a3 }
            java.util.Map r5 = kotlin.jvm.internal.TypeIntrinsics.asMutableMap(r5)     // Catch:{ all -> 0x00a3 }
            r5.remove(r0)     // Catch:{ all -> 0x00a3 }
            java.util.LinkedHashSet<K> r5 = r8.keySet     // Catch:{ all -> 0x00a3 }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x00a3 }
            java.util.Collection r5 = kotlin.jvm.internal.TypeIntrinsics.asMutableCollection(r5)     // Catch:{ all -> 0x00a3 }
            r5.remove(r0)     // Catch:{ all -> 0x00a3 }
            int r5 = r8.size()     // Catch:{ all -> 0x00a3 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x00a3 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch:{ all -> 0x00a3 }
            int r7 = r8.safeSizeOf(r0, r1)     // Catch:{ all -> 0x00a3 }
            int r5 = r5 - r7
            r8.size = r5     // Catch:{ all -> 0x00a3 }
            int r5 = r8.evictionCount     // Catch:{ all -> 0x00a3 }
            int r5 = r5 + r6
            r8.evictionCount = r5     // Catch:{ all -> 0x00a3 }
            goto L_0x0084
        L_0x007b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a3 }
            java.lang.String r6 = "inconsistent state"
            r5.<init>(r6)     // Catch:{ all -> 0x00a3 }
            throw r5     // Catch:{ all -> 0x00a3 }
        L_0x0084:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00a3 }
            monitor-exit(r2)
            if (r0 != 0) goto L_0x008e
            if (r1 != 0) goto L_0x008e
            return
        L_0x008e:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r2 = 0
            r8.entryRemoved(r6, r0, r1, r2)
            goto L_0x0001
        L_0x009a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00a3 }
            java.lang.String r6 = "map/keySet size inconsistency"
            r5.<init>(r6)     // Catch:{ all -> 0x00a3 }
            throw r5     // Catch:{ all -> 0x00a3 }
        L_0x00a3:
            r4 = move-exception
            monitor-exit(r2)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.caches.LruCache.trimToSize(int):void");
    }

    public final V remove(K key) {
        Object previous;
        if (key != null) {
            synchronized (this.monitor) {
                previous = this.map.remove(key);
                this.keySet.remove(key);
                if (previous != null) {
                    this.size = size() - safeSizeOf(key, previous);
                }
                Unit unit = Unit.INSTANCE;
            }
            if (previous != null) {
                entryRemoved(false, key, previous, (Object) null);
            }
            return previous;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
    }

    /* access modifiers changed from: protected */
    public V create(K key) {
        return null;
    }

    private final int safeSizeOf(K key, V value) {
        int result = sizeOf(key, value);
        if (result >= 0) {
            return result;
        }
        throw new IllegalStateException(("Negative size: " + key + '=' + value).toString());
    }

    /* access modifiers changed from: protected */
    public int sizeOf(K key, V value) {
        return 1;
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int maxSize() {
        int i;
        synchronized (this.monitor) {
            i = this.maxSize;
        }
        return i;
    }

    public final int hitCount() {
        int i;
        synchronized (this.monitor) {
            i = this.hitCount;
        }
        return i;
    }

    public final int missCount() {
        int i;
        synchronized (this.monitor) {
            i = this.missCount;
        }
        return i;
    }

    public final int createCount() {
        int i;
        synchronized (this.monitor) {
            i = this.createCount;
        }
        return i;
    }

    public final int putCount() {
        int i;
        synchronized (this.monitor) {
            i = this.putCount;
        }
        return i;
    }

    public final int evictionCount() {
        int i;
        synchronized (this.monitor) {
            i = this.evictionCount;
        }
        return i;
    }

    public final Map<K, V> snapshot() {
        Map<K, V> map2;
        synchronized (this.monitor) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = this.keySet.iterator();
            while (it.hasNext()) {
                Object key = it.next();
                V v = this.map.get(key);
                Intrinsics.checkNotNull(v);
                linkedHashMap.put(key, v);
            }
            map2 = linkedHashMap;
        }
        return map2;
    }

    public String toString() {
        String str;
        synchronized (this.monitor) {
            int i = this.hitCount;
            int accesses = this.missCount + i;
            str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (accesses != 0 ? (i * 100) / accesses : 0) + "%]";
        }
        return str;
    }

    public final <R> R synchronizedValue$ui_text_release(Function0<? extends R> block) {
        R invoke;
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (this.monitor) {
            try {
                invoke = block.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return invoke;
    }
}
