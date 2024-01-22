package androidx.compose.runtime.snapshots;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J \u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u0012H\bø\u0001\u0000J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0002J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "upperSet", "", "lowerSet", "lowerBound", "belowBound", "", "(JJI[I)V", "and", "bits", "andNot", "clear", "bit", "fastForEach", "", "block", "Lkotlin/Function1;", "get", "", "iterator", "", "lowest", "default", "or", "set", "toString", "", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotIdSet.kt */
public final class SnapshotIdSet implements Iterable<Integer>, KMappedMarker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, (int[]) null);
    /* access modifiers changed from: private */
    public final int[] belowBound;
    /* access modifiers changed from: private */
    public final int lowerBound;
    /* access modifiers changed from: private */
    public final long lowerSet;
    /* access modifiers changed from: private */
    public final long upperSet;

    private SnapshotIdSet(long upperSet2, long lowerSet2, int lowerBound2, int[] belowBound2) {
        this.upperSet = upperSet2;
        this.lowerSet = lowerSet2;
        this.lowerBound = lowerBound2;
        this.belowBound = belowBound2;
    }

    public final boolean get(int bit) {
        int[] it;
        int offset = bit - this.lowerBound;
        boolean z = true;
        if (offset < 0 || offset >= 64) {
            if (offset < 64 || offset >= 128) {
                if (offset > 0 || (it = this.belowBound) == null) {
                    return false;
                }
                if (SnapshotIdSetKt.binarySearch(it, bit) < 0) {
                    z = false;
                }
                return z;
            } else if (((1 << (offset - 64)) & this.upperSet) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (((1 << offset) & this.lowerSet) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final SnapshotIdSet set(int bit) {
        int[] iArr;
        long j;
        char c;
        int i = bit;
        int i2 = this.lowerBound;
        int offset = i - i2;
        long j2 = 1;
        long j3 = 0;
        char c2 = '@';
        if (offset >= 0 && offset < 64) {
            long mask = 1 << offset;
            long j4 = this.lowerSet;
            if ((j4 & mask) == 0) {
                return new SnapshotIdSet(this.upperSet, j4 | mask, i2, this.belowBound);
            }
        } else if (offset >= 64 && offset < 128) {
            long mask2 = 1 << (offset - 64);
            long j5 = this.upperSet;
            if ((j5 & mask2) == 0) {
                return new SnapshotIdSet(j5 | mask2, this.lowerSet, i2, this.belowBound);
            }
        } else if (offset < 128) {
            int[] array = this.belowBound;
            if (array == null) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, i2, new int[]{bit});
            }
            int location = SnapshotIdSetKt.binarySearch(array, i);
            if (location < 0) {
                int insertLocation = -(location + 1);
                int newSize = array.length + 1;
                int[] newBelowBound = new int[newSize];
                ArraysKt.copyInto(array, newBelowBound, 0, 0, insertLocation);
                ArraysKt.copyInto(array, newBelowBound, insertLocation + 1, insertLocation, newSize - 1);
                newBelowBound[insertLocation] = i;
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, newBelowBound);
            }
        } else if (!get(bit)) {
            long newUpperSet = this.upperSet;
            long newLowerSet = this.lowerSet;
            int newLowerBound = this.lowerBound;
            List list = null;
            int targetLowerBound = ((i + 1) / 64) * 64;
            while (true) {
                if (newLowerBound >= targetLowerBound) {
                    break;
                }
                if (newLowerSet != j3) {
                    if (list == null) {
                        List arrayList = new ArrayList();
                        List $this$set_u24lambda_u243 = arrayList;
                        int[] it = this.belowBound;
                        if (it != null) {
                            for (int element$iv : it) {
                                int i3 = element$iv;
                                $this$set_u24lambda_u243.add(Integer.valueOf(element$iv));
                            }
                        }
                        list = arrayList;
                    }
                    int i4 = 0;
                    while (true) {
                        c = '@';
                        if (i4 >= 64) {
                            break;
                        }
                        int bitOffset = i4;
                        if ((newLowerSet & (1 << bitOffset)) != 0) {
                            list.add(Integer.valueOf(bitOffset + newLowerBound));
                        }
                        i4++;
                    }
                    j = 1;
                } else {
                    j = j2;
                    c = c2;
                }
                j3 = 0;
                if (newUpperSet == 0) {
                    newLowerBound = targetLowerBound;
                    newLowerSet = 0;
                    break;
                }
                newLowerSet = newUpperSet;
                newUpperSet = 0;
                newLowerBound += 64;
                c2 = c;
                j2 = j;
            }
            if (list == null || (iArr = CollectionsKt.toIntArray(list)) == null) {
                iArr = this.belowBound;
            }
            return new SnapshotIdSet(newUpperSet, newLowerSet, newLowerBound, iArr).set(i);
        }
        return this;
    }

    public final SnapshotIdSet clear(int bit) {
        int[] array;
        int location;
        int i = bit;
        int i2 = this.lowerBound;
        int offset = i - i2;
        if (offset >= 0 && offset < 64) {
            long mask = 1 << offset;
            long j = this.lowerSet;
            if ((j & mask) != 0) {
                return new SnapshotIdSet(this.upperSet, j & (~mask), i2, this.belowBound);
            }
        } else if (offset >= 64 && offset < 128) {
            long mask2 = 1 << (offset - 64);
            long j2 = this.upperSet;
            if ((j2 & mask2) != 0) {
                return new SnapshotIdSet(j2 & (~mask2), this.lowerSet, i2, this.belowBound);
            }
        } else if (offset < 0 && (array = this.belowBound) != null && (location = SnapshotIdSetKt.binarySearch(array, i)) >= 0) {
            int newSize = array.length - 1;
            if (newSize == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, (int[]) null);
            }
            int[] newBelowBound = new int[newSize];
            if (location > 0) {
                ArraysKt.copyInto(array, newBelowBound, 0, 0, location);
            }
            if (location < newSize) {
                ArraysKt.copyInto(array, newBelowBound, location, location + 1, newSize + 1);
            }
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, newBelowBound);
        }
        return this;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet bits) {
        int[] iArr;
        Intrinsics.checkNotNullParameter(bits, "bits");
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (bits == snapshotIdSet) {
            return this;
        }
        if (this == snapshotIdSet) {
            return snapshotIdSet;
        }
        int i = bits.lowerBound;
        int i2 = this.lowerBound;
        if (i == i2 && bits.belowBound == (iArr = this.belowBound)) {
            return new SnapshotIdSet(this.upperSet & (~bits.upperSet), this.lowerSet & (~bits.lowerSet), i2, iArr);
        }
        Object accumulator$iv = this;
        Iterator it = bits.iterator();
        while (it.hasNext()) {
            accumulator$iv = ((SnapshotIdSet) accumulator$iv).clear(((Number) it.next()).intValue());
        }
        return (SnapshotIdSet) accumulator$iv;
    }

    public final SnapshotIdSet and(SnapshotIdSet bits) {
        int[] iArr;
        SnapshotIdSet<Number> $this$fold$iv = bits;
        Intrinsics.checkNotNullParameter($this$fold$iv, "bits");
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (Intrinsics.areEqual((Object) $this$fold$iv, (Object) snapshotIdSet) || Intrinsics.areEqual((Object) this, (Object) snapshotIdSet)) {
            return snapshotIdSet;
        }
        int i = $this$fold$iv.lowerBound;
        int i2 = this.lowerBound;
        if (i == i2 && $this$fold$iv.belowBound == (iArr = this.belowBound)) {
            long j = this.upperSet;
            long j2 = $this$fold$iv.upperSet;
            long j3 = this.lowerSet;
            long j4 = $this$fold$iv.lowerSet;
            long newLower = j3 & j4;
            if ((j & j2) == 0 && newLower == 0 && iArr == null) {
                return snapshotIdSet;
            }
            return new SnapshotIdSet(j2 & j, j3 & j4, i2, iArr);
        } else if (this.belowBound == null) {
            SnapshotIdSet snapshotIdSet2 = EMPTY;
            for (Number intValue : this) {
                int index = intValue.intValue();
                SnapshotIdSet previous = snapshotIdSet2;
                if ($this$fold$iv.get(index)) {
                    previous = previous.set(index);
                }
                snapshotIdSet2 = previous;
            }
            return snapshotIdSet2;
        } else {
            SnapshotIdSet snapshotIdSet3 = EMPTY;
            for (Number intValue2 : $this$fold$iv) {
                int index2 = intValue2.intValue();
                SnapshotIdSet previous2 = snapshotIdSet3;
                if (get(index2)) {
                    previous2 = previous2.set(index2);
                }
                snapshotIdSet3 = previous2;
            }
            return snapshotIdSet3;
        }
    }

    public final SnapshotIdSet or(SnapshotIdSet bits) {
        int[] iArr;
        Intrinsics.checkNotNullParameter(bits, "bits");
        SnapshotIdSet snapshotIdSet = EMPTY;
        if (bits == snapshotIdSet) {
            return this;
        }
        if (this == snapshotIdSet) {
            return bits;
        }
        int i = bits.lowerBound;
        int i2 = this.lowerBound;
        if (i == i2 && bits.belowBound == (iArr = this.belowBound)) {
            return new SnapshotIdSet(this.upperSet | bits.upperSet, this.lowerSet | bits.lowerSet, i2, iArr);
        }
        if (this.belowBound == null) {
            SnapshotIdSet previous = bits;
            Iterator it = iterator();
            while (it.hasNext()) {
                previous = previous.set(((Number) it.next()).intValue());
            }
            return previous;
        }
        Object accumulator$iv = this;
        Iterator it2 = bits.iterator();
        while (it2.hasNext()) {
            accumulator$iv = ((SnapshotIdSet) accumulator$iv).set(((Number) it2.next()).intValue());
        }
        return (SnapshotIdSet) accumulator$iv;
    }

    public Iterator<Integer> iterator() {
        return SequencesKt.sequence(new SnapshotIdSet$iterator$1(this, (Continuation<? super SnapshotIdSet$iterator$1>) null)).iterator();
    }

    public final void fastForEach(Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int[] belowBound2 = this.belowBound;
        if (belowBound2 != null) {
            for (int element : belowBound2) {
                block.invoke(Integer.valueOf(element));
            }
        }
        if (this.lowerSet != 0) {
            for (int index = 0; index < 64; index++) {
                if ((this.lowerSet & (1 << index)) != 0) {
                    block.invoke(Integer.valueOf(this.lowerBound + index));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int index2 = 0; index2 < 64; index2++) {
                if ((this.upperSet & (1 << index2)) != 0) {
                    block.invoke(Integer.valueOf(index2 + 64 + this.lowerBound));
                }
            }
        }
    }

    public final int lowest(int i) {
        int[] belowBound2 = this.belowBound;
        if (belowBound2 != null) {
            return belowBound2[0];
        }
        long j = this.lowerSet;
        if (j != 0) {
            return this.lowerBound + SnapshotIdSetKt.lowestBitOf(j);
        }
        long j2 = this.upperSet;
        if (j2 != 0) {
            return this.lowerBound + 64 + SnapshotIdSetKt.lowestBitOf(j2);
        }
        return i;
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append(super.toString()).append(" [");
        Iterable<Number> $this$map$iv = this;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Number intValue : $this$map$iv) {
            destination$iv$iv.add(String.valueOf(intValue.intValue()));
        }
        return append.append(ListUtilsKt.fastJoinToString$default((List) destination$iv$iv, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).append(']').toString();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnapshotIdSet.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }
    }
}
