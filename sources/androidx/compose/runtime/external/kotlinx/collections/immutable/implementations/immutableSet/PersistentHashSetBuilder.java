package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\u0016\u0010#\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001cJ\u0016\u0010$\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0002J\u0015\u0010'\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u0016\u0010(\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016J\u0016\u0010)\u001a\u00020\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR*\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "E", "Lkotlin/collections/AbstractMutableSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "set", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSet;)V", "<set-?>", "", "modCount", "getModCount$runtime_release", "()I", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "node", "getNode$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "ownership", "getOwnership$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "value", "size", "getSize", "setSize", "(I)V", "add", "", "element", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "build", "clear", "", "contains", "containsAll", "iterator", "", "remove", "removeAll", "retainAll", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PersistentHashSetBuilder.kt */
public final class PersistentHashSetBuilder<E> extends AbstractMutableSet<E> implements PersistentSet.Builder<E> {
    private int modCount;
    private TrieNode<E> node = this.set.getNode$runtime_release();
    private MutabilityOwnership ownership = new MutabilityOwnership();
    private PersistentHashSet<E> set;
    private int size = this.set.size();

    public PersistentHashSetBuilder(PersistentHashSet<E> set2) {
        Intrinsics.checkNotNullParameter(set2, "set");
        this.set = set2;
    }

    public final MutabilityOwnership getOwnership$runtime_release() {
        return this.ownership;
    }

    public final TrieNode<E> getNode$runtime_release() {
        return this.node;
    }

    public final int getModCount$runtime_release() {
        return this.modCount;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int value) {
        this.size = value;
        this.modCount++;
    }

    public PersistentHashSet<E> build() {
        PersistentHashSet<E> persistentHashSet;
        if (this.node == this.set.getNode$runtime_release()) {
            persistentHashSet = this.set;
        } else {
            this.ownership = new MutabilityOwnership();
            persistentHashSet = new PersistentHashSet<>(this.node, size());
        }
        this.set = persistentHashSet;
        return persistentHashSet;
    }

    public boolean contains(Object element) {
        return this.node.contains(element != null ? element.hashCode() : 0, element, 0);
    }

    public boolean add(E element) {
        int size2 = size();
        this.node = this.node.mutableAdd(element != null ? element.hashCode() : 0, element, 0, this);
        if (size2 != size()) {
            return true;
        }
        return false;
    }

    public boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentHashSet set2 = elements instanceof PersistentHashSet ? (PersistentHashSet) elements : null;
        if (set2 == null) {
            PersistentHashSetBuilder persistentHashSetBuilder = elements instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) elements : null;
            set2 = persistentHashSetBuilder != null ? persistentHashSetBuilder.build() : null;
        }
        if (set2 == null) {
            return super.addAll(elements);
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, (DefaultConstructorMarker) null);
        int size2 = size();
        TrieNode result = this.node.mutableAddAll(set2.getNode$runtime_release(), 0, deltaCounter, this);
        int newSize = (elements.size() + size2) - deltaCounter.getCount();
        if (size2 != newSize) {
            this.node = result;
            setSize(newSize);
        }
        if (size2 != size()) {
            return true;
        }
        return false;
    }

    public boolean retainAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentHashSet set2 = elements instanceof PersistentHashSet ? (PersistentHashSet) elements : null;
        if (set2 == null) {
            PersistentHashSetBuilder persistentHashSetBuilder = elements instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) elements : null;
            set2 = persistentHashSetBuilder != null ? persistentHashSetBuilder.build() : null;
        }
        if (set2 == null) {
            return super.retainAll(elements);
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, (DefaultConstructorMarker) null);
        int size2 = size();
        Object result = this.node.mutableRetainAll(set2.getNode$runtime_release(), 0, deltaCounter, this);
        int newSize = deltaCounter.getCount();
        if (newSize == 0) {
            clear();
        } else if (newSize != size2) {
            Intrinsics.checkNotNull(result, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
            this.node = (TrieNode) result;
            setSize(newSize);
        }
        if (size2 != size()) {
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        PersistentHashSet set2 = elements instanceof PersistentHashSet ? (PersistentHashSet) elements : null;
        if (set2 == null) {
            PersistentHashSetBuilder persistentHashSetBuilder = elements instanceof PersistentHashSetBuilder ? (PersistentHashSetBuilder) elements : null;
            set2 = persistentHashSetBuilder != null ? persistentHashSetBuilder.build() : null;
        }
        if (set2 == null) {
            return super.removeAll(elements);
        }
        DeltaCounter counter = new DeltaCounter(0, 1, (DefaultConstructorMarker) null);
        int size2 = size();
        Object result = this.node.mutableRemoveAll(set2.getNode$runtime_release(), 0, counter, this);
        int newSize = size2 - counter.getCount();
        if (newSize == 0) {
            clear();
        } else if (newSize != size2) {
            Intrinsics.checkNotNull(result, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
            this.node = (TrieNode) result;
            setSize(newSize);
        }
        if (size2 != size()) {
            return true;
        }
        return false;
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof PersistentHashSet) {
            return this.node.containsAll(((PersistentHashSet) elements).getNode$runtime_release(), 0);
        }
        if (elements instanceof PersistentHashSetBuilder) {
            return this.node.containsAll(((PersistentHashSetBuilder) elements).node, 0);
        }
        return super.containsAll(elements);
    }

    public boolean remove(Object element) {
        int size2 = size();
        this.node = this.node.mutableRemove(element != null ? element.hashCode() : 0, element, 0, this);
        if (size2 != size()) {
            return true;
        }
        return false;
    }

    public void clear() {
        TrieNode<E> eMPTY$runtime_release = TrieNode.Companion.getEMPTY$runtime_release();
        Intrinsics.checkNotNull(eMPTY$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder>");
        this.node = eMPTY$runtime_release;
        setSize(0);
    }

    public Iterator<E> iterator() {
        return new PersistentHashSetMutableIterator<>(this);
    }
}
