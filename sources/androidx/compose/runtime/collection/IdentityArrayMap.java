package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u0005H\u0002JD\u0010\u001f\u001a\u00020\u001626\u0010 \u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00160!H\bø\u0001\u0000J\u0018\u0010%\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020\u0018J\u0006\u0010(\u001a\u00020\u0018J\u0015\u0010)\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010&JD\u0010*\u001a\u00020\u001626\u0010 \u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00180!H\bø\u0001\u0000J/\u0010+\u001a\u00020\u00162!\u0010 \u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00180,H\bø\u0001\u0000J\u001e\u0010-\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010.R$\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bX\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0006R$\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\bX\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f\u0002\u0007\n\u0005\b20\u0001¨\u0006/"}, d2 = {"Landroidx/compose/runtime/collection/IdentityArrayMap;", "Key", "", "Value", "capacity", "", "(I)V", "keys", "", "getKeys$runtime_release", "()[Ljava/lang/Object;", "setKeys$runtime_release", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "size", "getSize$runtime_release", "()I", "setSize$runtime_release", "values", "getValues$runtime_release", "setValues$runtime_release", "clear", "", "contains", "", "key", "(Ljava/lang/Object;)Z", "find", "findExactIndex", "midIndex", "keyHash", "forEach", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "remove", "removeIf", "removeValueIf", "Lkotlin/Function1;", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IdentityArrayMap.kt */
public final class IdentityArrayMap<Key, Value> {
    private Object[] keys;
    private int size;
    private Object[] values;

    public IdentityArrayMap() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public IdentityArrayMap(int capacity) {
        this.keys = new Object[capacity];
        this.values = new Object[capacity];
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IdentityArrayMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public final Object[] getKeys$runtime_release() {
        return this.keys;
    }

    public final void setKeys$runtime_release(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.keys = objArr;
    }

    public final Object[] getValues$runtime_release() {
        return this.values;
    }

    public final void setValues$runtime_release(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.values = objArr;
    }

    public final int getSize$runtime_release() {
        return this.size;
    }

    public final void setSize$runtime_release(int i) {
        this.size = i;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isNotEmpty() {
        return this.size > 0;
    }

    public final boolean contains(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return find(key) >= 0;
    }

    public final Value get(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int index = find(key);
        if (index >= 0) {
            return this.values[index];
        }
        return null;
    }

    public final void set(Key key, Value value) {
        Object[] objArr;
        Object[] objArr2;
        Intrinsics.checkNotNullParameter(key, "key");
        int index = find(key);
        if (index >= 0) {
            this.values[index] = value;
            return;
        }
        int insertIndex = -(index + 1);
        int i = this.size;
        Object[] objArr3 = this.keys;
        boolean resize = i == objArr3.length;
        if (resize) {
            objArr = new Object[(i * 2)];
        } else {
            objArr = objArr3;
        }
        Object[] destKeys = objArr;
        ArraysKt.copyInto((T[]) objArr3, (T[]) destKeys, insertIndex + 1, insertIndex, i);
        if (resize) {
            ArraysKt.copyInto$default(this.keys, destKeys, 0, 0, insertIndex, 6, (Object) null);
        }
        destKeys[insertIndex] = key;
        this.keys = destKeys;
        if (resize) {
            objArr2 = new Object[(this.size * 2)];
        } else {
            objArr2 = this.values;
        }
        Object[] destValues = objArr2;
        ArraysKt.copyInto((T[]) this.values, (T[]) destValues, insertIndex + 1, insertIndex, this.size);
        if (resize) {
            ArraysKt.copyInto$default(this.values, destValues, 0, 0, insertIndex, 6, (Object) null);
        }
        destValues[insertIndex] = value;
        this.values = destValues;
        this.size++;
    }

    public final Value remove(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int index = find(key);
        if (index < 0) {
            return null;
        }
        Object value = this.values[index];
        int size2 = this.size;
        Object[] keys2 = this.keys;
        Object[] values2 = this.values;
        ArraysKt.copyInto((T[]) keys2, (T[]) keys2, index, index + 1, size2);
        ArraysKt.copyInto((T[]) values2, (T[]) values2, index, index + 1, size2);
        int newSize = size2 - 1;
        keys2[newSize] = null;
        values2[newSize] = null;
        this.size = newSize;
        return value;
    }

    public final void clear() {
        this.size = 0;
        ArraysKt.fill$default(this.keys, (Object) null, 0, 0, 6, (Object) null);
        ArraysKt.fill$default(this.values, (Object) null, 0, 0, 6, (Object) null);
    }

    public final void removeIf(Function2<? super Key, ? super Value, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int current = 0;
        int size$runtime_release = getSize$runtime_release();
        for (int index = 0; index < size$runtime_release; index++) {
            Object key = getKeys$runtime_release()[index];
            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            if (!block.invoke(key, getValues$runtime_release()[index]).booleanValue()) {
                if (current != index) {
                    getKeys$runtime_release()[current] = key;
                    getValues$runtime_release()[current] = getValues$runtime_release()[index];
                }
                current++;
            }
        }
        if (getSize$runtime_release() > current) {
            int size$runtime_release2 = getSize$runtime_release();
            for (int index2 = current; index2 < size$runtime_release2; index2++) {
                getKeys$runtime_release()[index2] = null;
                getValues$runtime_release()[index2] = null;
            }
            setSize$runtime_release(current);
        }
    }

    public final void removeValueIf(Function1<? super Value, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int current$iv = 0;
        int size$runtime_release = getSize$runtime_release();
        for (int index$iv = 0; index$iv < size$runtime_release; index$iv++) {
            Object key$iv = getKeys$runtime_release()[index$iv];
            Intrinsics.checkNotNull(key$iv, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            if (!block.invoke(getValues$runtime_release()[index$iv]).booleanValue()) {
                if (current$iv != index$iv) {
                    getKeys$runtime_release()[current$iv] = key$iv;
                    getValues$runtime_release()[current$iv] = getValues$runtime_release()[index$iv];
                }
                current$iv++;
            }
        }
        if (getSize$runtime_release() > current$iv) {
            int size$runtime_release2 = getSize$runtime_release();
            for (int index$iv2 = current$iv; index$iv2 < size$runtime_release2; index$iv2++) {
                getKeys$runtime_release()[index$iv2] = null;
                getValues$runtime_release()[index$iv2] = null;
            }
            setSize$runtime_release(current$iv);
        }
    }

    public final void forEach(Function2<? super Key, ? super Value, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int size$runtime_release = getSize$runtime_release();
        for (int index = 0; index < size$runtime_release; index++) {
            Object obj = getKeys$runtime_release()[index];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.IdentityArrayMap");
            block.invoke(obj, getValues$runtime_release()[index]);
        }
    }

    private final int find(Object key) {
        int keyIdentity = ActualJvm_jvmKt.identityHashCode(key);
        int low = 0;
        int high = this.size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Object midKey = this.keys[mid];
            int midKeyHash = ActualJvm_jvmKt.identityHashCode(midKey);
            if (midKeyHash < keyIdentity) {
                low = mid + 1;
            } else if (midKeyHash > keyIdentity) {
                high = mid - 1;
            } else if (key == midKey) {
                return mid;
            } else {
                return findExactIndex(mid, key, keyIdentity);
            }
        }
        return -(low + 1);
    }

    private final int findExactIndex(int midIndex, Object key, int keyHash) {
        for (int i = midIndex - 1; -1 < i; i--) {
            Object k = this.keys[i];
            if (k == key) {
                return i;
            }
            if (ActualJvm_jvmKt.identityHashCode(k) != keyHash) {
                break;
            }
        }
        int i2 = this.size;
        for (int i3 = midIndex + 1; i3 < i2; i3++) {
            Object k2 = this.keys[i3];
            if (k2 == key) {
                return i3;
            }
            if (ActualJvm_jvmKt.identityHashCode(k2) != keyHash) {
                return -(i3 + 1);
            }
        }
        return -(this.size + 1);
    }
}
