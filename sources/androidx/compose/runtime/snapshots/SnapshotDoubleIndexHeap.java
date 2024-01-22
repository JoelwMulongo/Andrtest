package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0006\u0010\u001d\u001a\u00020\u0011J\u0016\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "", "()V", "firstFreeHandle", "", "handles", "", "index", "<set-?>", "size", "getSize", "()I", "values", "add", "value", "allocateHandle", "ensure", "", "atLeast", "freeHandle", "handle", "lowestOrDefault", "default", "remove", "shiftDown", "shiftUp", "swap", "a", "b", "validate", "validateHandle", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotDoubleIndexHeap.kt */
public final class SnapshotDoubleIndexHeap {
    private int firstFreeHandle;
    private int[] handles;
    private int[] index = new int[16];
    private int size;
    private int[] values = new int[16];

    public SnapshotDoubleIndexHeap() {
        int[] iArr = new int[16];
        int i = 0;
        while (i < 16) {
            int i2 = i + 1;
            iArr[i] = i2;
            i = i2;
        }
        this.handles = iArr;
    }

    public final int getSize() {
        return this.size;
    }

    public static /* synthetic */ int lowestOrDefault$default(SnapshotDoubleIndexHeap snapshotDoubleIndexHeap, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return snapshotDoubleIndexHeap.lowestOrDefault(i);
    }

    public final int lowestOrDefault(int i) {
        return this.size > 0 ? this.values[0] : i;
    }

    public final int add(int value) {
        ensure(this.size + 1);
        int i = this.size;
        this.size = i + 1;
        int handle = allocateHandle();
        this.values[i] = value;
        this.index[i] = handle;
        this.handles[handle] = i;
        shiftUp(i);
        return handle;
    }

    public final void remove(int handle) {
        int i = this.handles[handle];
        swap(i, this.size - 1);
        this.size--;
        shiftUp(i);
        shiftDown(i);
        freeHandle(handle);
    }

    public final void validate() {
        int index2 = 1;
        int i = this.size;
        while (index2 < i) {
            int[] iArr = this.values;
            if (iArr[((index2 + 1) >> 1) - 1] <= iArr[index2]) {
                index2++;
            } else {
                throw new IllegalStateException(("Index " + index2 + " is out of place").toString());
            }
        }
    }

    public final void validateHandle(int handle, int value) {
        int i = this.handles[handle];
        if (this.index[i] != handle) {
            throw new IllegalStateException(("Index for handle " + handle + " is corrupted").toString());
        } else if (this.values[i] != value) {
            throw new IllegalStateException(("Value for handle " + handle + " was " + this.values[i] + " but was supposed to be " + value).toString());
        }
    }

    private final void shiftUp(int index2) {
        int[] values2 = this.values;
        int value = values2[index2];
        int current = index2;
        while (current > 0) {
            int parent = ((current + 1) >> 1) - 1;
            if (values2[parent] > value) {
                swap(parent, current);
                current = parent;
            } else {
                return;
            }
        }
    }

    private final void shiftDown(int index2) {
        int[] values2 = this.values;
        int half = this.size >> 1;
        int current = index2;
        while (current < half) {
            int right = (current + 1) << 1;
            int left = right - 1;
            if (right >= this.size || values2[right] >= values2[left]) {
                if (values2[left] < values2[current]) {
                    swap(left, current);
                    current = left;
                } else {
                    return;
                }
            } else if (values2[right] < values2[current]) {
                swap(right, current);
                current = right;
            } else {
                return;
            }
        }
    }

    private final void swap(int a, int b) {
        int[] values2 = this.values;
        int[] index2 = this.index;
        int[] handles2 = this.handles;
        int t = values2[a];
        values2[a] = values2[b];
        values2[b] = t;
        int t2 = index2[a];
        index2[a] = index2[b];
        index2[b] = t2;
        handles2[index2[a]] = a;
        handles2[index2[b]] = b;
    }

    private final void ensure(int atLeast) {
        int[] iArr = this.values;
        int capacity = iArr.length;
        if (atLeast > capacity) {
            int newCapacity = capacity * 2;
            int[] newValues = new int[newCapacity];
            int[] newIndex = new int[newCapacity];
            ArraysKt.copyInto$default(iArr, newValues, 0, 0, 0, 14, (Object) null);
            ArraysKt.copyInto$default(this.index, newIndex, 0, 0, 0, 14, (Object) null);
            this.values = newValues;
            this.index = newIndex;
        }
    }

    private final int allocateHandle() {
        int capacity = this.handles.length;
        if (this.firstFreeHandle >= capacity) {
            int i = capacity * 2;
            int[] iArr = new int[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = i2 + 1;
                iArr[i2] = i3;
                i2 = i3;
            }
            int[] newHandles = iArr;
            ArraysKt.copyInto$default(this.handles, newHandles, 0, 0, 0, 14, (Object) null);
            this.handles = newHandles;
        }
        int handle = this.firstFreeHandle;
        this.firstFreeHandle = this.handles[this.firstFreeHandle];
        return handle;
    }

    private final void freeHandle(int handle) {
        this.handles[handle] = this.firstFreeHandle;
        this.firstFreeHandle = handle;
    }
}
