package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import java.util.Arrays;
import java.util.Collection;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010*\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 (*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001(B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001b\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J#\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016J\u001d\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0016\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\"\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020%0$H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016J#\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0012R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006)"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "buffer", "", "", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "size", "", "getSize", "()I", "add", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "index", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "addAll", "c", "", "elements", "bufferOfSize", "(I)[Ljava/lang/Object;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "listIterator", "", "removeAll", "predicate", "Lkotlin/Function1;", "", "removeAt", "set", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SmallPersistentVector.kt */
public final class SmallPersistentVector<E> extends AbstractPersistentList<E> implements ImmutableList<E> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final SmallPersistentVector EMPTY = new SmallPersistentVector(new Object[0]);
    private final Object[] buffer;

    public SmallPersistentVector(Object[] buffer2) {
        Intrinsics.checkNotNullParameter(buffer2, "buffer");
        this.buffer = buffer2;
        CommonFunctionsKt.m2802assert(buffer2.length <= 32);
    }

    public int getSize() {
        return this.buffer.length;
    }

    private final Object[] bufferOfSize(int size) {
        return new Object[size];
    }

    public PersistentList<E> add(E element) {
        if (size() < 32) {
            Object[] newBuffer = Arrays.copyOf(this.buffer, size() + 1);
            Intrinsics.checkNotNullExpressionValue(newBuffer, "copyOf(this, newSize)");
            newBuffer[size()] = element;
            return new SmallPersistentVector<>(newBuffer);
        }
        return new PersistentVector<>(this.buffer, UtilsKt.presizedBufferWith(element), size() + 1, 0);
    }

    public PersistentList<E> addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (size() + elements.size() <= 32) {
            Object[] newBuffer = Arrays.copyOf(this.buffer, size() + elements.size());
            Intrinsics.checkNotNullExpressionValue(newBuffer, "copyOf(this, newSize)");
            int index = size();
            for (Object element : elements) {
                newBuffer[index] = element;
                index++;
            }
            return new SmallPersistentVector<>(newBuffer);
        }
        PersistentList.Builder it = builder();
        it.addAll(elements);
        return it.build();
    }

    public PersistentList<E> removeAll(Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] newBuffer = this.buffer;
        int newSize = size();
        boolean anyRemoved = false;
        int size = size();
        for (int index = 0; index < size; index++) {
            Object element = this.buffer[index];
            if (predicate.invoke(element).booleanValue()) {
                if (!anyRemoved) {
                    Object[] objArr = this.buffer;
                    Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                    newBuffer = copyOf;
                    newSize = index;
                    anyRemoved = true;
                }
            } else if (anyRemoved) {
                newBuffer[newSize] = element;
                newSize++;
            }
        }
        if (newSize == size()) {
            return this;
        }
        if (newSize == 0) {
            return EMPTY;
        }
        return new SmallPersistentVector<>(ArraysKt.copyOfRange((T[]) newBuffer, 0, newSize));
    }

    public PersistentList<E> addAll(int index, Collection<? extends E> c) {
        Intrinsics.checkNotNullParameter(c, "c");
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        if (size() + c.size() <= 32) {
            Object[] newBuffer = bufferOfSize(size() + c.size());
            ArraysKt.copyInto$default(this.buffer, newBuffer, 0, 0, index, 6, (Object) null);
            ArraysKt.copyInto((T[]) this.buffer, (T[]) newBuffer, c.size() + index, index, size());
            int position = index;
            for (Object element : c) {
                newBuffer[position] = element;
                position++;
            }
            return new SmallPersistentVector<>(newBuffer);
        }
        PersistentList.Builder it = builder();
        it.addAll(index, c);
        return it.build();
    }

    public PersistentList<E> add(int index, E element) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        if (index == size()) {
            return add((Object) element);
        }
        if (size() < 32) {
            Object[] newBuffer = bufferOfSize(size() + 1);
            ArraysKt.copyInto$default(this.buffer, newBuffer, 0, 0, index, 6, (Object) null);
            ArraysKt.copyInto((T[]) this.buffer, (T[]) newBuffer, index + 1, index, size());
            newBuffer[index] = element;
            return new SmallPersistentVector<>(newBuffer);
        }
        Object[] newBuffer2 = this.buffer;
        Object[] root = Arrays.copyOf(newBuffer2, newBuffer2.length);
        Intrinsics.checkNotNullExpressionValue(root, "copyOf(this, size)");
        ArraysKt.copyInto((T[]) this.buffer, (T[]) root, index + 1, index, size() - 1);
        root[index] = element;
        return new PersistentVector<>(root, UtilsKt.presizedBufferWith(this.buffer[31]), size() + 1, 0);
    }

    public PersistentList<E> removeAt(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        if (size() == 1) {
            return EMPTY;
        }
        Object[] newBuffer = Arrays.copyOf(this.buffer, size() - 1);
        Intrinsics.checkNotNullExpressionValue(newBuffer, "copyOf(this, newSize)");
        ArraysKt.copyInto((T[]) this.buffer, (T[]) newBuffer, index, index + 1, size());
        return new SmallPersistentVector<>(newBuffer);
    }

    public PersistentList.Builder<E> builder() {
        return new PersistentVectorBuilder<>(this, (Object[]) null, this.buffer, 0);
    }

    public int indexOf(Object element) {
        return ArraysKt.indexOf((T[]) this.buffer, element);
    }

    public int lastIndexOf(Object element) {
        return ArraysKt.lastIndexOf((T[]) this.buffer, element);
    }

    public ListIterator<E> listIterator(int index) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        return new BufferIterator<>(this.buffer, index, size());
    }

    public E get(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        return this.buffer[index];
    }

    public PersistentList<E> set(int index, E element) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        Object[] objArr = this.buffer;
        Object[] newBuffer = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(newBuffer, "copyOf(this, size)");
        newBuffer[index] = element;
        return new SmallPersistentVector<>(newBuffer);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector;", "", "getEMPTY", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/SmallPersistentVector;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SmallPersistentVector.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SmallPersistentVector getEMPTY() {
            return SmallPersistentVector.EMPTY;
        }
    }
}
