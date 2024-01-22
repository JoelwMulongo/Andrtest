package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001b\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00028\u0000¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020(J\u0011\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0002H\u0002J\u0012\u0010+\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010.\u001a\u00020\u000eH\u0002J7\u0010/\u001a\u00020(2\u0006\u0010$\u001a\u00020\u00022!\u00100\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020(01H\bø\u0001\u0000J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010$\u001a\u00020\u0002H\u0002J\u001b\u00105\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00028\u0000¢\u0006\u0002\u0010&J\u0013\u00106\u001a\u00020(2\u0006\u0010%\u001a\u00028\u0000¢\u0006\u0002\u00107J/\u00108\u001a\u00020(2!\u00109\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020#01H\bø\u0001\u0000J#\u0010:\u001a\u00020(2\u0018\u0010;\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0004\u0012\u00020(01H\bJ\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010=\u001a\u00020\u000eH\u0002J\u0011\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u000eH\bR4\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u00058\u0000@\u0000X\u000e¢\u0006\u0016\n\u0002\u0010\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00158\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR.\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00058\u0000@\u0000X\u000e¢\u0006\u0016\n\u0002\u0010!\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u0002\u0007\n\u0005\b20\u0001¨\u0006?"}, d2 = {"Landroidx/compose/runtime/collection/IdentityScopeMap;", "T", "", "()V", "scopeSets", "", "Landroidx/compose/runtime/collection/IdentityArraySet;", "getScopeSets$annotations", "getScopeSets", "()[Landroidx/compose/runtime/collection/IdentityArraySet;", "setScopeSets", "([Landroidx/compose/runtime/collection/IdentityArraySet;)V", "[Landroidx/compose/runtime/collection/IdentityArraySet;", "size", "", "getSize$annotations", "getSize", "()I", "setSize", "(I)V", "valueOrder", "", "getValueOrder$annotations", "getValueOrder", "()[I", "setValueOrder", "([I)V", "values", "getValues$annotations", "getValues", "()[Ljava/lang/Object;", "setValues", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "add", "", "value", "scope", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "clear", "", "contains", "element", "find", "findExactIndex", "midIndex", "valueHash", "forEachScopeOf", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "getOrCreateIdentitySet", "remove", "removeScope", "(Ljava/lang/Object;)V", "removeValueIf", "predicate", "removingScopes", "removalOperation", "scopeSetAt", "index", "valueAt", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IdentityScopeMap.kt */
public final class IdentityScopeMap<T> {
    private IdentityArraySet<T>[] scopeSets;
    private int size;
    private int[] valueOrder;
    private Object[] values;

    public static /* synthetic */ void getScopeSets$annotations() {
    }

    public static /* synthetic */ void getSize$annotations() {
    }

    public static /* synthetic */ void getValueOrder$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public IdentityScopeMap() {
        int[] iArr = new int[50];
        for (int i = 0; i < 50; i++) {
            iArr[i] = i;
        }
        this.valueOrder = iArr;
        this.values = new Object[50];
        this.scopeSets = new IdentityArraySet[50];
    }

    public final int[] getValueOrder() {
        return this.valueOrder;
    }

    public final void setValueOrder(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.valueOrder = iArr;
    }

    public final Object[] getValues() {
        return this.values;
    }

    public final void setValues(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.values = objArr;
    }

    public final IdentityArraySet<T>[] getScopeSets() {
        return this.scopeSets;
    }

    public final void setScopeSets(IdentityArraySet<T>[] identityArraySetArr) {
        Intrinsics.checkNotNullParameter(identityArraySetArr, "<set-?>");
        this.scopeSets = identityArraySetArr;
    }

    public final int getSize() {
        return this.size;
    }

    public final void setSize(int i) {
        this.size = i;
    }

    private final Object valueAt(int index) {
        Object obj = this.values[this.valueOrder[index]];
        Intrinsics.checkNotNull(obj);
        return obj;
    }

    /* access modifiers changed from: private */
    public final IdentityArraySet<T> scopeSetAt(int index) {
        IdentityArraySet<T> identityArraySet = this.scopeSets[this.valueOrder[index]];
        Intrinsics.checkNotNull(identityArraySet);
        return identityArraySet;
    }

    public final boolean add(Object value, T scope) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return getOrCreateIdentitySet(value).add(scope);
    }

    public final boolean contains(Object element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return find(element) >= 0;
    }

    public final void forEachScopeOf(Object value, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(block, "block");
        int index = find(value);
        if (index >= 0) {
            IdentityArraySet this_$iv = scopeSetAt(index);
            int size2 = this_$iv.size();
            for (int i$iv = 0; i$iv < size2; i$iv++) {
                block.invoke(this_$iv.get(i$iv));
            }
        }
    }

    private final IdentityArraySet<T> getOrCreateIdentitySet(Object value) {
        int index;
        if (this.size > 0) {
            index = find(value);
            if (index >= 0) {
                return scopeSetAt(index);
            }
        } else {
            index = -1;
        }
        int insertIndex = -(index + 1);
        int i = this.size;
        int[] iArr = this.valueOrder;
        if (i < iArr.length) {
            int valueIndex = iArr[i];
            this.values[valueIndex] = value;
            IdentityArraySet scopeSet = this.scopeSets[valueIndex];
            if (scopeSet == null) {
                scopeSet = new IdentityArraySet();
                this.scopeSets[valueIndex] = scopeSet;
            }
            int i2 = this.size;
            if (insertIndex < i2) {
                int[] iArr2 = this.valueOrder;
                ArraysKt.copyInto(iArr2, iArr2, insertIndex + 1, insertIndex, i2);
            }
            this.valueOrder[insertIndex] = valueIndex;
            this.size++;
            return scopeSet;
        }
        int newSize = iArr.length * 2;
        int valueIndex2 = this.size;
        Object[] copyOf = Arrays.copyOf(this.scopeSets, newSize);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        this.scopeSets = (IdentityArraySet[]) copyOf;
        IdentityArraySet scopeSet2 = new IdentityArraySet();
        this.scopeSets[valueIndex2] = scopeSet2;
        Object[] copyOf2 = Arrays.copyOf(this.values, newSize);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        this.values = copyOf2;
        copyOf2[valueIndex2] = value;
        int[] newKeyOrder = new int[newSize];
        for (int i3 = this.size + 1; i3 < newSize; i3++) {
            newKeyOrder[i3] = i3;
        }
        int i4 = this.size;
        if (insertIndex < i4) {
            ArraysKt.copyInto(this.valueOrder, newKeyOrder, insertIndex + 1, insertIndex, i4);
        }
        newKeyOrder[insertIndex] = valueIndex2;
        if (insertIndex > 0) {
            ArraysKt.copyInto$default(this.valueOrder, newKeyOrder, 0, 0, insertIndex, 6, (Object) null);
        }
        this.valueOrder = newKeyOrder;
        this.size++;
        return scopeSet2;
    }

    public final void clear() {
        int length = this.scopeSets.length;
        for (int i = 0; i < length; i++) {
            IdentityArraySet<T> identityArraySet = this.scopeSets[i];
            if (identityArraySet != null) {
                identityArraySet.clear();
            }
            this.valueOrder[i] = i;
            this.values[i] = null;
        }
        this.size = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0013, code lost:
        r2 = r9.valueOrder[r0];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(java.lang.Object r10, T r11) {
        /*
            r9 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            int r0 = r9.find(r10)
            r1 = 0
            if (r0 < 0) goto L_0x004a
            int[] r2 = r9.valueOrder
            r2 = r2[r0]
            androidx.compose.runtime.collection.IdentityArraySet<T>[] r3 = r9.scopeSets
            r3 = r3[r2]
            if (r3 != 0) goto L_0x001e
            return r1
        L_0x001e:
            r1 = r3
            boolean r3 = r1.remove(r11)
            int r4 = r1.size()
            if (r4 != 0) goto L_0x0049
            int r4 = r0 + 1
            int r5 = r9.size
            if (r4 >= r5) goto L_0x0038
            int[] r6 = r9.valueOrder
            kotlin.collections.ArraysKt.copyInto((int[]) r6, (int[]) r6, (int) r0, (int) r4, (int) r5)
        L_0x0038:
            int[] r6 = r9.valueOrder
            int r7 = r9.size
            int r8 = r7 + -1
            r6[r8] = r2
            java.lang.Object[] r6 = r9.values
            r8 = 0
            r6[r2] = r8
            int r7 = r7 + -1
            r9.size = r7
        L_0x0049:
            return r3
        L_0x004a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.IdentityScopeMap.remove(java.lang.Object, java.lang.Object):boolean");
    }

    public final void removeValueIf(Function1<? super T, Boolean> predicate) {
        Function1<? super T, Boolean> function1 = predicate;
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int $i$f$removeValueIf = 0;
        int $i$f$removingScopes = false;
        int destinationIndex$iv = 0;
        int i$iv = 0;
        int size2 = getSize();
        while (i$iv < size2) {
            int valueIndex$iv = getValueOrder()[i$iv];
            IdentityArraySet set$iv = getScopeSets()[valueIndex$iv];
            Intrinsics.checkNotNull(set$iv);
            IdentityArraySet this_$iv = set$iv;
            int destinationIndex$iv2 = 0;
            int i$iv2 = 0;
            int size3 = this_$iv.size();
            while (i$iv2 < size3) {
                int $i$f$removeValueIf2 = $i$f$removeValueIf;
                Object item$iv = this_$iv.getValues()[i$iv2];
                int $i$f$removingScopes2 = $i$f$removingScopes;
                Intrinsics.checkNotNull(item$iv, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                if (!function1.invoke(item$iv).booleanValue()) {
                    if (destinationIndex$iv2 != i$iv2) {
                        this_$iv.getValues()[destinationIndex$iv2] = item$iv;
                    }
                    destinationIndex$iv2++;
                }
                i$iv2++;
                $i$f$removingScopes = $i$f$removingScopes2;
                $i$f$removeValueIf = $i$f$removeValueIf2;
            }
            int $i$f$removeValueIf3 = $i$f$removeValueIf;
            int $i$f$removingScopes3 = $i$f$removingScopes;
            int size4 = this_$iv.size();
            for (int i$iv3 = destinationIndex$iv2; i$iv3 < size4; i$iv3++) {
                this_$iv.getValues()[i$iv3] = null;
            }
            this_$iv.setSize(destinationIndex$iv2);
            if (set$iv.size() > 0) {
                if (destinationIndex$iv != i$iv) {
                    int destinationKeyOrder$iv = getValueOrder()[destinationIndex$iv];
                    getValueOrder()[destinationIndex$iv] = valueIndex$iv;
                    getValueOrder()[i$iv] = destinationKeyOrder$iv;
                }
                destinationIndex$iv++;
            }
            i$iv++;
            $i$f$removingScopes = $i$f$removingScopes3;
            $i$f$removeValueIf = $i$f$removeValueIf3;
        }
        int i = $i$f$removingScopes;
        int size5 = getSize();
        for (int i$iv4 = destinationIndex$iv; i$iv4 < size5; i$iv4++) {
            getValues()[getValueOrder()[i$iv4]] = null;
        }
        setSize(destinationIndex$iv);
    }

    public final void removeScope(T scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        int destinationIndex$iv = 0;
        int size2 = getSize();
        for (int i$iv = 0; i$iv < size2; i$iv++) {
            int valueIndex$iv = getValueOrder()[i$iv];
            IdentityArraySet set$iv = getScopeSets()[valueIndex$iv];
            Intrinsics.checkNotNull(set$iv);
            set$iv.remove(scope);
            if (set$iv.size() > 0) {
                if (destinationIndex$iv != i$iv) {
                    int destinationKeyOrder$iv = getValueOrder()[destinationIndex$iv];
                    getValueOrder()[destinationIndex$iv] = valueIndex$iv;
                    getValueOrder()[i$iv] = destinationKeyOrder$iv;
                }
                destinationIndex$iv++;
            }
        }
        int size3 = getSize();
        for (int i$iv2 = destinationIndex$iv; i$iv2 < size3; i$iv2++) {
            getValues()[getValueOrder()[i$iv2]] = null;
        }
        setSize(destinationIndex$iv);
    }

    private final void removingScopes(Function1<? super IdentityArraySet<T>, Unit> removalOperation) {
        int destinationIndex = 0;
        int size2 = getSize();
        for (int i = 0; i < size2; i++) {
            int valueIndex = getValueOrder()[i];
            IdentityArraySet set = getScopeSets()[valueIndex];
            Intrinsics.checkNotNull(set);
            removalOperation.invoke(set);
            if (set.size() > 0) {
                if (destinationIndex != i) {
                    int destinationKeyOrder = getValueOrder()[destinationIndex];
                    getValueOrder()[destinationIndex] = valueIndex;
                    getValueOrder()[i] = destinationKeyOrder;
                }
                destinationIndex++;
            }
        }
        int size3 = getSize();
        for (int i2 = destinationIndex; i2 < size3; i2++) {
            getValues()[getValueOrder()[i2]] = null;
        }
        setSize(destinationIndex);
    }

    /* access modifiers changed from: private */
    public final int find(Object value) {
        int valueIdentity = ActualJvm_jvmKt.identityHashCode(value);
        int low = 0;
        int high = this.size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Object obj = this.values[this.valueOrder[mid]];
            Intrinsics.checkNotNull(obj);
            Object midValue = obj;
            int midValHash = ActualJvm_jvmKt.identityHashCode(midValue);
            if (midValHash < valueIdentity) {
                low = mid + 1;
            } else if (midValHash > valueIdentity) {
                high = mid - 1;
            } else if (value == midValue) {
                return mid;
            } else {
                return findExactIndex(mid, value, valueIdentity);
            }
        }
        return -(low + 1);
    }

    private final int findExactIndex(int midIndex, Object value, int valueHash) {
        for (int i = midIndex - 1; -1 < i; i--) {
            Object obj = this.values[this.valueOrder[i]];
            Intrinsics.checkNotNull(obj);
            Object v = obj;
            if (v == value) {
                return i;
            }
            if (ActualJvm_jvmKt.identityHashCode(v) != valueHash) {
                break;
            }
        }
        int i2 = this.size;
        for (int i3 = midIndex + 1; i3 < i2; i3++) {
            Object obj2 = this.values[this.valueOrder[i3]];
            Intrinsics.checkNotNull(obj2);
            Object v2 = obj2;
            if (v2 == value) {
                return i3;
            }
            if (ActualJvm_jvmKt.identityHashCode(v2) != valueHash) {
                return -(i3 + 1);
            }
        }
        return -(this.size + 1);
    }
}
