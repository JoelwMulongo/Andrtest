package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0000\u0018\u0000 _*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001_B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\u0002\u0010\u0007B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010\u001cJ#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0004H\u0002J\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\u0015\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010%J\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020\u0004H\u0002J#\u0010)\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010*J\u001c\u0010+\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u0004J\u0015\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0015\u00102\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0000¢\u0006\u0002\b3JE\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00028\u00002\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010:J=\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010?J3\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010AJ5\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\n\u0010C\u001a\u0006\u0012\u0002\b\u00030D¢\u0006\u0002\u0010EJ6\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ+\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u00109\u001a\u00020\tH\u0002¢\u0006\u0002\u0010JJ'\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u00002\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DH\u0002¢\u0006\u0002\u0010LJ,\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J'\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u00002\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DH\u0002¢\u0006\u0002\u0010LJ(\u0010O\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J\u001e\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002J(\u0010Q\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J;\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002¢\u0006\u0002\u0010?J5\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\n\u0010C\u001a\u0006\u0012\u0002\b\u00030D¢\u0006\u0002\u0010EJ2\u0010T\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ&\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010V\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002J2\u0010W\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ,\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00109\u001a\u00020\tH\u0002J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010.\u001a\u00020\u0004H\u0002J)\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004¢\u0006\u0002\u0010\u001cJ\u001e\u0010]\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010V\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J$\u0010^\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006`"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "E", "", "bitmap", "", "buffer", "", "(I[Ljava/lang/Object;)V", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "(I[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "getBitmap", "()I", "setBitmap", "(I)V", "getBuffer", "()[Ljava/lang/Object;", "setBuffer", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getOwnedBy", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "setOwnedBy", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "add", "elementHash", "element", "shift", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "addElementAt", "positionMask", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "calculateSize", "collisionAdd", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "collisionContainsElement", "", "(Ljava/lang/Object;)Z", "collisionRemove", "collisionRemoveElementAtIndex", "i", "contains", "(ILjava/lang/Object;I)Z", "containsAll", "otherNode", "elementAtIndex", "index", "(I)Ljava/lang/Object;", "elementsIdentityEquals", "hasNoCellAt", "indexOfCellAt", "indexOfCellAt$runtime_release", "makeNode", "elementHash1", "element1", "elementHash2", "element2", "owner", "(ILjava/lang/Object;ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "makeNodeAtIndex", "elementIndex", "newElementHash", "newElement", "(IILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "moveElementToNode", "(IILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAdd", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAddAll", "intersectionSizeRef", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutableAddElementAt", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAdd", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAddAll", "mutableCollisionRemove", "mutableCollisionRemoveAll", "mutableCollisionRemoveElementAtIndex", "mutableCollisionRetainAll", "mutableMoveElementToNode", "mutableRemove", "mutableRemoveAll", "mutableRemoveCellAtIndex", "cellIndex", "mutableRetainAll", "mutableUpdateNodeAtIndex", "nodeIndex", "newNode", "nodeAtIndex", "remove", "removeCellAtIndex", "updateNodeAtIndex", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TrieNode.kt */
public final class TrieNode<E> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TrieNode EMPTY = new TrieNode(0, new Object[0]);
    private int bitmap;
    private Object[] buffer;
    private MutabilityOwnership ownedBy;

    public TrieNode(int bitmap2, Object[] buffer2, MutabilityOwnership ownedBy2) {
        Intrinsics.checkNotNullParameter(buffer2, "buffer");
        this.bitmap = bitmap2;
        this.buffer = buffer2;
        this.ownedBy = ownedBy2;
    }

    public final int getBitmap() {
        return this.bitmap;
    }

    public final void setBitmap(int i) {
        this.bitmap = i;
    }

    public final Object[] getBuffer() {
        return this.buffer;
    }

    public final void setBuffer(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.buffer = objArr;
    }

    public final MutabilityOwnership getOwnedBy() {
        return this.ownedBy;
    }

    public final void setOwnedBy(MutabilityOwnership mutabilityOwnership) {
        this.ownedBy = mutabilityOwnership;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TrieNode(int bitmap2, Object[] buffer2) {
        this(bitmap2, buffer2, (MutabilityOwnership) null);
        Intrinsics.checkNotNullParameter(buffer2, "buffer");
    }

    private final boolean hasNoCellAt(int positionMask) {
        return (this.bitmap & positionMask) == 0;
    }

    public final int indexOfCellAt$runtime_release(int positionMask) {
        return Integer.bitCount(this.bitmap & (positionMask - 1));
    }

    private final E elementAtIndex(int index) {
        return this.buffer[index];
    }

    private final TrieNode<E> nodeAtIndex(int index) {
        Object obj = this.buffer[index];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        return (TrieNode) obj;
    }

    private final TrieNode<E> addElementAt(int positionMask, E element) {
        return new TrieNode<>(this.bitmap | positionMask, TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release(positionMask), element));
    }

    private final TrieNode<E> mutableAddElementAt(int positionMask, E element, MutabilityOwnership owner) {
        int index = indexOfCellAt$runtime_release(positionMask);
        if (this.ownedBy == owner) {
            this.buffer = TrieNodeKt.addElementAtIndex(this.buffer, index, element);
            this.bitmap |= positionMask;
            return this;
        }
        return new TrieNode<>(this.bitmap | positionMask, TrieNodeKt.addElementAtIndex(this.buffer, index, element), owner);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> updateNodeAtIndex(int r6, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> r7) {
        /*
            r5 = this;
            r0 = 0
            java.lang.Object[] r1 = r7.buffer
            int r2 = r1.length
            r3 = 1
            if (r2 != r3) goto L_0x001b
            r2 = 0
            r4 = r1[r2]
            boolean r4 = r4 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            if (r4 != 0) goto L_0x001b
            java.lang.Object[] r4 = r5.buffer
            int r4 = r4.length
            if (r4 != r3) goto L_0x0018
            int r2 = r5.bitmap
            r7.bitmap = r2
            return r7
        L_0x0018:
            r0 = r1[r2]
            goto L_0x001c
        L_0x001b:
            r0 = r7
        L_0x001c:
            java.lang.Object[] r2 = r5.buffer
            int r3 = r2.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r3)
            java.lang.String r3 = "copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r2[r6] = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r3 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            int r4 = r5.bitmap
            r3.<init>(r4, r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.updateNodeAtIndex(int, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode):androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableUpdateNodeAtIndex(int r6, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> r7, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r8) {
        /*
            r5 = this;
            r0 = 0
            java.lang.Object[] r1 = r7.buffer
            int r2 = r1.length
            r3 = 1
            if (r2 != r3) goto L_0x001b
            r2 = 0
            r4 = r1[r2]
            boolean r4 = r4 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            if (r4 != 0) goto L_0x001b
            java.lang.Object[] r4 = r5.buffer
            int r4 = r4.length
            if (r4 != r3) goto L_0x0018
            int r2 = r5.bitmap
            r7.bitmap = r2
            return r7
        L_0x0018:
            r0 = r1[r2]
            goto L_0x001c
        L_0x001b:
            r0 = r7
        L_0x001c:
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r2 = r5.ownedBy
            if (r2 != r8) goto L_0x0025
            java.lang.Object[] r2 = r5.buffer
            r2[r6] = r0
            return r5
        L_0x0025:
            java.lang.Object[] r2 = r5.buffer
            int r3 = r2.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r3)
            java.lang.String r3 = "copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r2[r6] = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r3 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            int r4 = r5.bitmap
            r3.<init>(r4, r2, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableUpdateNodeAtIndex(int, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership):androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode");
    }

    private final TrieNode<E> makeNodeAtIndex(int elementIndex, int newElementHash, E newElement, int shift, MutabilityOwnership owner) {
        Object storedElement = elementAtIndex(elementIndex);
        return makeNode(storedElement != null ? storedElement.hashCode() : 0, storedElement, newElementHash, newElement, shift + 5, owner);
    }

    private final TrieNode<E> moveElementToNode(int elementIndex, int newElementHash, E newElement, int shift) {
        Object[] objArr = this.buffer;
        Object[] newBuffer = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(newBuffer, "copyOf(this, size)");
        newBuffer[elementIndex] = makeNodeAtIndex(elementIndex, newElementHash, newElement, shift, (MutabilityOwnership) null);
        return new TrieNode<>(this.bitmap, newBuffer);
    }

    private final TrieNode<E> mutableMoveElementToNode(int elementIndex, int newElementHash, E newElement, int shift, MutabilityOwnership owner) {
        if (this.ownedBy == owner) {
            this.buffer[elementIndex] = makeNodeAtIndex(elementIndex, newElementHash, newElement, shift, owner);
            return this;
        }
        Object[] objArr = this.buffer;
        Object[] newBuffer = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(newBuffer, "copyOf(this, size)");
        newBuffer[elementIndex] = makeNodeAtIndex(elementIndex, newElementHash, newElement, shift, owner);
        return new TrieNode<>(this.bitmap, newBuffer, owner);
    }

    private final TrieNode<E> makeNode(int elementHash1, E element1, int elementHash2, E element2, int shift, MutabilityOwnership owner) {
        Object[] nodeBuffer;
        E e = element1;
        E e2 = element2;
        int i = shift;
        MutabilityOwnership mutabilityOwnership = owner;
        if (i > 30) {
            return new TrieNode<>(0, new Object[]{e, e2}, mutabilityOwnership);
        }
        int setBit1 = TrieNodeKt.indexSegment(elementHash1, i);
        int setBit2 = TrieNodeKt.indexSegment(elementHash2, i);
        if (setBit1 != setBit2) {
            if (setBit1 < setBit2) {
                nodeBuffer = new Object[]{e, e2};
            } else {
                nodeBuffer = new Object[]{e2, e};
            }
            return new TrieNode<>((1 << setBit1) | (1 << setBit2), nodeBuffer, mutabilityOwnership);
        }
        return new TrieNode<>(1 << setBit1, new Object[]{makeNode(elementHash1, element1, elementHash2, element2, i + 5, owner)}, mutabilityOwnership);
    }

    private final TrieNode<E> removeCellAtIndex(int cellIndex, int positionMask) {
        return new TrieNode<>(this.bitmap ^ positionMask, TrieNodeKt.removeCellAtIndex(this.buffer, cellIndex));
    }

    private final TrieNode<E> mutableRemoveCellAtIndex(int cellIndex, int positionMask, MutabilityOwnership owner) {
        if (this.ownedBy == owner) {
            this.buffer = TrieNodeKt.removeCellAtIndex(this.buffer, cellIndex);
            this.bitmap ^= positionMask;
            return this;
        }
        return new TrieNode<>(this.bitmap ^ positionMask, TrieNodeKt.removeCellAtIndex(this.buffer, cellIndex), owner);
    }

    private final TrieNode<E> collisionRemoveElementAtIndex(int i) {
        return new TrieNode<>(0, TrieNodeKt.removeCellAtIndex(this.buffer, i));
    }

    private final TrieNode<E> mutableCollisionRemoveElementAtIndex(int i, MutabilityOwnership owner) {
        if (this.ownedBy != owner) {
            return new TrieNode<>(0, TrieNodeKt.removeCellAtIndex(this.buffer, i), owner);
        }
        this.buffer = TrieNodeKt.removeCellAtIndex(this.buffer, i);
        return this;
    }

    private final boolean collisionContainsElement(E element) {
        return ArraysKt.contains((T[]) this.buffer, element);
    }

    private final TrieNode<E> collisionAdd(E element) {
        if (collisionContainsElement(element)) {
            return this;
        }
        return new TrieNode<>(0, TrieNodeKt.addElementAtIndex(this.buffer, 0, element));
    }

    private final TrieNode<E> mutableCollisionAdd(E element, PersistentHashSetBuilder<?> mutator) {
        if (collisionContainsElement(element)) {
            return this;
        }
        mutator.setSize(mutator.size() + 1);
        if (this.ownedBy != mutator.getOwnership$runtime_release()) {
            return new TrieNode<>(0, TrieNodeKt.addElementAtIndex(this.buffer, 0, element), mutator.getOwnership$runtime_release());
        }
        this.buffer = TrieNodeKt.addElementAtIndex(this.buffer, 0, element);
        return this;
    }

    private final TrieNode<E> collisionRemove(E element) {
        int index = ArraysKt.indexOf((T[]) this.buffer, element);
        if (index != -1) {
            return collisionRemoveElementAtIndex(index);
        }
        return this;
    }

    private final TrieNode<E> mutableCollisionRemove(E element, PersistentHashSetBuilder<?> mutator) {
        int index = ArraysKt.indexOf((T[]) this.buffer, element);
        if (index == -1) {
            return this;
        }
        mutator.setSize(mutator.size() - 1);
        return mutableCollisionRemoveElementAtIndex(index, mutator.getOwnership$runtime_release());
    }

    private final TrieNode<E> mutableCollisionAddAll(TrieNode<E> otherNode, DeltaCounter intersectionSizeRef, MutabilityOwnership owner) {
        Object[] objArr;
        TrieNode<E> trieNode = otherNode;
        DeltaCounter deltaCounter = intersectionSizeRef;
        MutabilityOwnership mutabilityOwnership = owner;
        if (this == trieNode) {
            deltaCounter.plusAssign(this.buffer.length);
            return this;
        }
        Object[] objArr2 = this.buffer;
        Object[] tempBuffer = Arrays.copyOf(objArr2, objArr2.length + trieNode.buffer.length);
        Intrinsics.checkNotNullExpressionValue(tempBuffer, "copyOf(this, newSize)");
        Object[] $this$filterTo$iv = trieNode.buffer;
        int newArrayOffset$iv = this.buffer.length;
        int i$iv = 0;
        int j$iv = 0;
        while (true) {
            boolean z = false;
            if (i$iv >= $this$filterTo$iv.length) {
                break;
            }
            CommonFunctionsKt.m2802assert(j$iv <= i$iv);
            if (!collisionContainsElement($this$filterTo$iv[i$iv])) {
                tempBuffer[newArrayOffset$iv + j$iv] = $this$filterTo$iv[i$iv];
                j$iv++;
                if (newArrayOffset$iv + j$iv <= tempBuffer.length) {
                    z = true;
                }
                CommonFunctionsKt.m2802assert(z);
            }
            i$iv++;
        }
        int totalSize = this.buffer.length + j$iv;
        deltaCounter.plusAssign(tempBuffer.length - totalSize);
        if (totalSize == this.buffer.length) {
            return this;
        }
        if (totalSize == trieNode.buffer.length) {
            return trieNode;
        }
        if (totalSize == tempBuffer.length) {
            objArr = tempBuffer;
        } else {
            objArr = Arrays.copyOf(tempBuffer, totalSize);
            Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(this, newSize)");
        }
        Object[] newBuffer = objArr;
        if (!Intrinsics.areEqual((Object) this.ownedBy, (Object) mutabilityOwnership)) {
            return new TrieNode<>(0, newBuffer, mutabilityOwnership);
        }
        this.buffer = newBuffer;
        return this;
    }

    private final Object mutableCollisionRetainAll(TrieNode<E> otherNode, DeltaCounter intersectionSizeRef, MutabilityOwnership owner) {
        Object[] tempBuffer;
        if (this == otherNode) {
            intersectionSizeRef.plusAssign(this.buffer.length);
            return this;
        }
        if (Intrinsics.areEqual((Object) owner, (Object) this.ownedBy)) {
            tempBuffer = this.buffer;
        } else {
            tempBuffer = new Object[Math.min(this.buffer.length, otherNode.buffer.length)];
        }
        Object[] $this$filterTo_u24default$iv = this.buffer;
        int i$iv = 0;
        int j$iv = 0;
        while (true) {
            boolean z = false;
            if (i$iv >= $this$filterTo_u24default$iv.length) {
                break;
            }
            CommonFunctionsKt.m2802assert(j$iv <= i$iv);
            if (otherNode.collisionContainsElement($this$filterTo_u24default$iv[i$iv])) {
                tempBuffer[0 + j$iv] = $this$filterTo_u24default$iv[i$iv];
                j$iv++;
                if (0 + j$iv <= tempBuffer.length) {
                    z = true;
                }
                CommonFunctionsKt.m2802assert(z);
            }
            i$iv++;
        }
        int totalWritten = j$iv;
        intersectionSizeRef.plusAssign(totalWritten);
        if (totalWritten == 0) {
            return EMPTY;
        }
        if (totalWritten == 1) {
            return tempBuffer[0];
        }
        if (totalWritten == this.buffer.length) {
            return this;
        }
        if (totalWritten == otherNode.buffer.length) {
            return otherNode;
        }
        if (totalWritten == tempBuffer.length) {
            return new TrieNode(0, tempBuffer, owner);
        }
        Object[] copyOf = Arrays.copyOf(tempBuffer, totalWritten);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return new TrieNode(0, copyOf, owner);
    }

    private final Object mutableCollisionRemoveAll(TrieNode<E> otherNode, DeltaCounter intersectionSizeRef, MutabilityOwnership owner) {
        if (this == otherNode) {
            intersectionSizeRef.plusAssign(this.buffer.length);
            return EMPTY;
        }
        Object[] tempBuffer = Intrinsics.areEqual((Object) owner, (Object) this.ownedBy) ? this.buffer : new Object[this.buffer.length];
        Object[] $this$filterTo_u24default$iv = this.buffer;
        int i$iv = 0;
        int j$iv = 0;
        while (true) {
            boolean z = false;
            if (i$iv >= $this$filterTo_u24default$iv.length) {
                break;
            }
            CommonFunctionsKt.m2802assert(j$iv <= i$iv);
            if (!otherNode.collisionContainsElement($this$filterTo_u24default$iv[i$iv])) {
                tempBuffer[0 + j$iv] = $this$filterTo_u24default$iv[i$iv];
                j$iv++;
                if (0 + j$iv <= tempBuffer.length) {
                    z = true;
                }
                CommonFunctionsKt.m2802assert(z);
            }
            i$iv++;
        }
        int totalWritten = j$iv;
        intersectionSizeRef.plusAssign(this.buffer.length - totalWritten);
        if (totalWritten == 0) {
            return EMPTY;
        }
        if (totalWritten == 1) {
            return tempBuffer[0];
        }
        if (totalWritten == this.buffer.length) {
            return this;
        }
        if (totalWritten == tempBuffer.length) {
            return new TrieNode(0, tempBuffer, owner);
        }
        Object[] copyOf = Arrays.copyOf(tempBuffer, totalWritten);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return new TrieNode(0, copyOf, owner);
    }

    private final int calculateSize() {
        int i;
        if (this.bitmap == 0) {
            return this.buffer.length;
        }
        int result = 0;
        for (Object e : this.buffer) {
            if (e instanceof TrieNode) {
                i = ((TrieNode) e).calculateSize();
            } else {
                i = 1;
            }
            result += i;
        }
        return result;
    }

    private final boolean elementsIdentityEquals(TrieNode<E> otherNode) {
        if (this == otherNode) {
            return true;
        }
        if (this.bitmap != otherNode.bitmap) {
            return false;
        }
        int length = this.buffer.length;
        for (int i = 0; i < length; i++) {
            if (this.buffer[i] != otherNode.buffer[i]) {
                return false;
            }
        }
        return true;
    }

    public final boolean contains(int elementHash, E element, int shift) {
        int cellPositionMask = 1 << TrieNodeKt.indexSegment(elementHash, shift);
        if (hasNoCellAt(cellPositionMask)) {
            return false;
        }
        int cellIndex = indexOfCellAt$runtime_release(cellPositionMask);
        Object obj = this.buffer[cellIndex];
        if (!(obj instanceof TrieNode)) {
            return Intrinsics.areEqual((Object) element, obj);
        }
        TrieNode targetNode = nodeAtIndex(cellIndex);
        if (shift == 30) {
            return targetNode.collisionContainsElement(element);
        }
        return targetNode.contains(elementHash, element, shift + 5);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> mutableAddAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> r31, int r32, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter r33, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?> r34) {
        /*
            r30 = this;
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r34
            java.lang.String r0 = "otherNode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "intersectionSizeRef"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "mutator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            if (r7 != r8) goto L_0x002b
            int r0 = r33.getCount()
            int r1 = r30.calculateSize()
            int r0 = r0 + r1
            r10.setCount(r0)
            return r7
        L_0x002b:
            r0 = 30
            if (r9 <= r0) goto L_0x0038
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r0 = r34.getOwnership$runtime_release()
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = r7.mutableCollisionAddAll(r8, r10, r0)
            return r0
        L_0x0038:
            int r0 = r7.bitmap
            int r1 = r8.bitmap
            r12 = r0 | r1
            if (r12 != r0) goto L_0x004f
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r0 = r7.ownedBy
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r1 = r34.getOwnership$runtime_release()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x004f
            r0 = r7
            goto L_0x005e
        L_0x004f:
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            int r1 = java.lang.Integer.bitCount(r12)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r2 = r34.getOwnership$runtime_release()
            r0.<init>(r12, r1, r2)
        L_0x005e:
            r13 = r0
            r14 = r12
            r15 = 0
            r0 = r14
            r1 = 0
            r16 = r0
            r17 = r1
        L_0x0067:
            if (r16 == 0) goto L_0x0197
            int r18 = java.lang.Integer.lowestOneBit(r16)
            r0 = r18
            r19 = r17
            r6 = r0
            r20 = 0
            int r21 = r7.indexOfCellAt$runtime_release(r6)
            int r22 = r8.indexOfCellAt$runtime_release(r6)
            java.lang.Object[] r5 = r13.buffer
            boolean r0 = r7.hasNoCellAt(r6)
            if (r0 == 0) goto L_0x008e
            java.lang.Object[] r0 = r8.buffer
            r0 = r0[r22]
            r23 = r5
            r24 = r6
            goto L_0x018d
        L_0x008e:
            boolean r0 = r8.hasNoCellAt(r6)
            if (r0 == 0) goto L_0x009e
            java.lang.Object[] r0 = r7.buffer
            r0 = r0[r21]
            r23 = r5
            r24 = r6
            goto L_0x018d
        L_0x009e:
            java.lang.Object[] r0 = r7.buffer
            r4 = r0[r21]
            java.lang.Object[] r0 = r8.buffer
            r3 = r0[r22]
            boolean r2 = r4 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            boolean r1 = r3 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            java.lang.String r0 = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda$6>"
            if (r2 == 0) goto L_0x00d3
            if (r1 == 0) goto L_0x00d3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r0)
            r23 = r4
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r23 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r23
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r0)
            r0 = r3
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r0
            r0 = r4
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r0
            r23 = r5
            r5 = r3
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r5 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r5
            r24 = r6
            int r6 = r9 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = r0.mutableAddAll(r5, r6, r10, r11)
            goto L_0x018d
        L_0x00d3:
            r23 = r5
            r24 = r6
            r5 = 0
            if (r2 == 0) goto L_0x0112
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r0)
            r0 = r4
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r0
            int r0 = r34.size()
            r6 = r4
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r6 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r6
            if (r3 == 0) goto L_0x00ee
            int r5 = r3.hashCode()
        L_0x00ee:
            r25 = r2
            int r2 = r9 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r2 = r6.mutableAdd(r5, r3, r2, r11)
            r5 = r2
            r6 = 0
            r26 = r2
            int r2 = r34.size()
            if (r2 != r0) goto L_0x010b
            int r2 = r33.getCount()
            int r2 = r2 + 1
            r10.setCount(r2)
        L_0x010b:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r0 = r26
            goto L_0x018d
        L_0x0112:
            r25 = r2
            if (r1 == 0) goto L_0x014a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r0)
            r0 = r3
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r0
            int r0 = r34.size()
            r2 = r3
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r2 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r2
            if (r4 == 0) goto L_0x012a
            int r5 = r4.hashCode()
        L_0x012a:
            int r6 = r9 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r2 = r2.mutableAdd(r5, r4, r6, r11)
            r5 = r2
            r6 = 0
            r26 = r1
            int r1 = r34.size()
            if (r1 != r0) goto L_0x0145
            int r1 = r33.getCount()
            int r1 = r1 + 1
            r10.setCount(r1)
        L_0x0145:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r0 = r2
            goto L_0x018d
        L_0x014a:
            r26 = r1
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0161
            r0 = r4
            r1 = 0
            int r2 = r33.getCount()
            int r2 = r2 + 1
            r10.setCount(r2)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r0 = r4
            goto L_0x018d
        L_0x0161:
            if (r4 == 0) goto L_0x016c
            int r0 = r4.hashCode()
            r1 = r0
            goto L_0x016d
        L_0x016c:
            r1 = r5
        L_0x016d:
            if (r3 == 0) goto L_0x0175
            int r0 = r3.hashCode()
            r5 = r0
        L_0x0175:
            int r6 = r9 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r27 = r34.getOwnership$runtime_release()
            r0 = r30
            r2 = r4
            r28 = r3
            r3 = r5
            r29 = r4
            r4 = r28
            r5 = r6
            r6 = r27
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = r0.makeNode(r1, r2, r3, r4, r5, r6)
        L_0x018d:
            r23[r19] = r0
            int r17 = r17 + 1
            r16 = r16 ^ r18
            goto L_0x0067
        L_0x0197:
            boolean r0 = r7.elementsIdentityEquals(r13)
            if (r0 == 0) goto L_0x01a1
            r0 = r7
            goto L_0x01aa
        L_0x01a1:
            boolean r0 = r8.elementsIdentityEquals(r13)
            if (r0 == 0) goto L_0x01a9
            r0 = r8
            goto L_0x01aa
        L_0x01a9:
            r0 = r13
        L_0x01aa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode, int, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder):androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode");
    }

    public final Object mutableRetainAll(TrieNode<E> otherNode, int shift, DeltaCounter intersectionSizeRef, PersistentHashSetBuilder<?> mutator) {
        TrieNode mutableNode;
        int newBitMap;
        Object it;
        TrieNode trieNode = this;
        TrieNode<E> trieNode2 = otherNode;
        int i = shift;
        DeltaCounter deltaCounter = intersectionSizeRef;
        PersistentHashSetBuilder<?> persistentHashSetBuilder = mutator;
        Intrinsics.checkNotNullParameter(trieNode2, "otherNode");
        Intrinsics.checkNotNullParameter(deltaCounter, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(persistentHashSetBuilder, "mutator");
        if (trieNode == trieNode2) {
            deltaCounter.plusAssign(calculateSize());
            return trieNode;
        } else if (i > 30) {
            return trieNode.mutableCollisionRetainAll(trieNode2, deltaCounter, mutator.getOwnership$runtime_release());
        } else {
            int newBitMap2 = trieNode.bitmap & trieNode2.bitmap;
            if (newBitMap2 == 0) {
                return EMPTY;
            }
            if (!Intrinsics.areEqual((Object) trieNode.ownedBy, (Object) mutator.getOwnership$runtime_release()) || newBitMap2 != trieNode.bitmap) {
                mutableNode = new TrieNode(newBitMap2, new Object[Integer.bitCount(newBitMap2)], mutator.getOwnership$runtime_release());
            } else {
                mutableNode = trieNode;
            }
            int realBitMap = 0;
            int $this$forEachOneBit$iv = newBitMap2;
            int $i$f$forEachOneBit = false;
            int mask$iv = $this$forEachOneBit$iv;
            int index$iv = 0;
            while (mask$iv != 0) {
                int bit$iv = Integer.lowestOneBit(mask$iv);
                int positionMask = bit$iv;
                int newNodeIndex = index$iv;
                int thisIndex = trieNode.indexOfCellAt$runtime_release(positionMask);
                int otherNodeIndex = trieNode2.indexOfCellAt$runtime_release(positionMask);
                TrieNode $this$mutableRetainAll_u24lambda_u249_u24lambda_u248 = trieNode;
                Object thisCell = $this$mutableRetainAll_u24lambda_u249_u24lambda_u248.buffer[thisIndex];
                int $this$forEachOneBit$iv2 = $this$forEachOneBit$iv;
                Object otherNodeCell = trieNode2.buffer[otherNodeIndex];
                int $i$f$forEachOneBit2 = $i$f$forEachOneBit;
                boolean thisIsNode = thisCell instanceof TrieNode;
                TrieNode trieNode3 = $this$mutableRetainAll_u24lambda_u249_u24lambda_u248;
                boolean otherIsNode = otherNodeCell instanceof TrieNode;
                if (!thisIsNode || !otherIsNode) {
                    newBitMap = newBitMap2;
                    if (thisIsNode) {
                        Intrinsics.checkNotNull(thisCell, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>");
                        TrieNode trieNode4 = (TrieNode) thisCell;
                        if (((TrieNode) thisCell).contains(otherNodeCell != null ? otherNodeCell.hashCode() : 0, otherNodeCell, i + 5)) {
                            deltaCounter.plusAssign(1);
                            it = otherNodeCell;
                        } else {
                            it = EMPTY;
                        }
                    } else {
                        if (otherIsNode) {
                            Intrinsics.checkNotNull(otherNodeCell, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>");
                            TrieNode trieNode5 = (TrieNode) otherNodeCell;
                            if (((TrieNode) otherNodeCell).contains(thisCell != null ? thisCell.hashCode() : 0, thisCell, i + 5)) {
                                deltaCounter.plusAssign(1);
                            } else {
                                it = EMPTY;
                            }
                        } else if (Intrinsics.areEqual(thisCell, otherNodeCell)) {
                            Object obj = thisCell;
                            deltaCounter.plusAssign(1);
                        } else {
                            it = EMPTY;
                        }
                        it = thisCell;
                    }
                } else {
                    Intrinsics.checkNotNull(thisCell, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>");
                    TrieNode trieNode6 = (TrieNode) thisCell;
                    Intrinsics.checkNotNull(otherNodeCell, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda$9$lambda$8>");
                    TrieNode trieNode7 = (TrieNode) otherNodeCell;
                    newBitMap = newBitMap2;
                    it = ((TrieNode) thisCell).mutableRetainAll((TrieNode) otherNodeCell, i + 5, deltaCounter, persistentHashSetBuilder);
                }
                if (it != EMPTY) {
                    realBitMap |= positionMask;
                }
                mutableNode.buffer[newNodeIndex] = it;
                index$iv++;
                mask$iv ^= bit$iv;
                trieNode = this;
                trieNode2 = otherNode;
                $this$forEachOneBit$iv = $this$forEachOneBit$iv2;
                $i$f$forEachOneBit = $i$f$forEachOneBit2;
                newBitMap2 = newBitMap;
            }
            int newBitMap3 = newBitMap2;
            int i2 = $this$forEachOneBit$iv;
            int i3 = $i$f$forEachOneBit;
            int realSize = Integer.bitCount(realBitMap);
            if (realBitMap == 0) {
                TrieNode<E> trieNode8 = otherNode;
                int i4 = realSize;
                return EMPTY;
            }
            int newBitMap4 = newBitMap3;
            if (realBitMap == newBitMap4) {
                if (mutableNode.elementsIdentityEquals(this)) {
                    TrieNode<E> trieNode9 = otherNode;
                    int i5 = realSize;
                    int i6 = newBitMap4;
                    return this;
                }
                TrieNode<E> trieNode10 = otherNode;
                if (mutableNode.elementsIdentityEquals(trieNode10)) {
                    int i7 = realSize;
                    int i8 = newBitMap4;
                    return trieNode10;
                }
                int i9 = realSize;
                int i10 = newBitMap4;
                return mutableNode;
            }
            TrieNode<E> trieNode11 = otherNode;
            if (realSize != 1 || i == 0) {
                Object[] realBuffer = new Object[realSize];
                Object[] $this$filterTo_u24default$iv = mutableNode.buffer;
                int i$iv = 0;
                int j$iv = 0;
                while (i$iv < $this$filterTo_u24default$iv.length) {
                    CommonFunctionsKt.m2802assert(j$iv <= i$iv);
                    int realSize2 = realSize;
                    int newBitMap5 = newBitMap4;
                    if ($this$filterTo_u24default$iv[i$iv] != Companion.getEMPTY$runtime_release()) {
                        realBuffer[0 + j$iv] = $this$filterTo_u24default$iv[i$iv];
                        j$iv++;
                        CommonFunctionsKt.m2802assert(0 + j$iv <= realBuffer.length);
                    }
                    i$iv++;
                    realSize = realSize2;
                    newBitMap4 = newBitMap5;
                }
                int i11 = newBitMap4;
                return new TrieNode(realBitMap, realBuffer, mutator.getOwnership$runtime_release());
            }
            Object single = mutableNode.buffer[mutableNode.indexOfCellAt$runtime_release(realBitMap)];
            if (single instanceof TrieNode) {
                int i12 = realSize;
                int i13 = newBitMap4;
                return new TrieNode(realBitMap, new Object[]{single}, mutator.getOwnership$runtime_release());
            }
            int i14 = realSize;
            int i15 = newBitMap4;
            return single;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f6, code lost:
        if ((r0 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) == false) goto L_0x0134;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object mutableRemoveAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E> r28, int r29, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter r30, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder<?> r31) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            java.lang.String r5 = "otherNode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
            java.lang.String r5 = "intersectionSizeRef"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r5)
            java.lang.String r5 = "mutator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            if (r0 != r1) goto L_0x0028
            int r5 = r27.calculateSize()
            r3.plusAssign(r5)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r5 = EMPTY
            return r5
        L_0x0028:
            r5 = 30
            if (r2 <= r5) goto L_0x0035
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r5 = r31.getOwnership$runtime_release()
            java.lang.Object r5 = r0.mutableCollisionRemoveAll(r1, r3, r5)
            return r5
        L_0x0035:
            int r5 = r0.bitmap
            int r6 = r1.bitmap
            r5 = r5 & r6
            if (r5 != 0) goto L_0x003d
            return r0
        L_0x003d:
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r6 = r0.ownedBy
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r7 = r31.getOwnership$runtime_release()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x004b
            r6 = r0
            goto L_0x0062
        L_0x004b:
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r6 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            int r7 = r0.bitmap
            java.lang.Object[] r8 = r0.buffer
            int r9 = r8.length
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r8, r9)
            java.lang.String r9 = "copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r9 = r31.getOwnership$runtime_release()
            r6.<init>(r7, r8, r9)
        L_0x0062:
            r7 = 0
            int r7 = r0.bitmap
            r8 = r5
            r9 = 0
            r10 = r8
            r11 = 0
        L_0x006b:
            if (r10 == 0) goto L_0x0152
            int r14 = java.lang.Integer.lowestOneBit(r10)
            r15 = r14
            r16 = 0
            int r17 = r0.indexOfCellAt$runtime_release(r15)
            int r18 = r1.indexOfCellAt$runtime_release(r15)
            r12 = r0
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r12 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r12
            r20 = 0
            java.lang.Object[] r13 = r12.buffer
            r13 = r13[r17]
            r22 = r5
            java.lang.Object[] r5 = r1.buffer
            r5 = r5[r18]
            boolean r1 = r13 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            r23 = r8
            boolean r8 = r5 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            r24 = r9
            java.lang.String r9 = "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda$11$lambda$10>"
            if (r1 == 0) goto L_0x00bc
            if (r8 == 0) goto L_0x00bc
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r9)
            r19 = r13
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r19 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r19
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r9)
            r9 = r5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r9 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r9
            r9 = r13
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r9 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r9
            r25 = r12
            r12 = r5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r12 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r12
            int r0 = r2 + 5
            java.lang.Object r0 = r9.mutableRemoveAll(r12, r0, r3, r4)
            r26 = r1
            goto L_0x0134
        L_0x00bc:
            r25 = r12
            if (r1 == 0) goto L_0x00fe
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r9)
            r0 = r13
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r0
            int r0 = r31.size()
            r9 = r13
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r9 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r9
            if (r5 == 0) goto L_0x00d5
            int r12 = r5.hashCode()
            goto L_0x00d6
        L_0x00d5:
            r12 = 0
        L_0x00d6:
            r26 = r1
            int r1 = r2 + 5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r1 = r9.mutableRemove(r12, r5, r1, r4)
            int r9 = r31.size()
            if (r0 == r9) goto L_0x00fb
            r9 = 1
            r3.plusAssign(r9)
            java.lang.Object[] r12 = r1.buffer
            r21 = r0
            int r0 = r12.length
            if (r0 != r9) goto L_0x00f9
            r0 = 0
            r0 = r12[r0]
            boolean r9 = r0 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            if (r9 != 0) goto L_0x00f9
            goto L_0x0134
        L_0x00f9:
            r0 = r1
            goto L_0x0134
        L_0x00fb:
            r21 = r0
            goto L_0x0133
        L_0x00fe:
            r26 = r1
            r0 = 0
            if (r8 == 0) goto L_0x0125
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r9)
            r1 = r5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r1 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r1
            r1 = r5
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r1 = (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) r1
            if (r13 == 0) goto L_0x0114
            int r12 = r13.hashCode()
            goto L_0x0115
        L_0x0114:
            r12 = r0
        L_0x0115:
            int r0 = r2 + 5
            boolean r0 = r1.contains(r12, r13, r0)
            if (r0 == 0) goto L_0x0124
            r0 = 1
            r3.plusAssign(r0)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = EMPTY
            goto L_0x0134
        L_0x0124:
            goto L_0x0133
        L_0x0125:
            r0 = 1
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r5)
            if (r1 == 0) goto L_0x0132
            r3.plusAssign(r0)
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = EMPTY
            goto L_0x0134
        L_0x0132:
        L_0x0133:
            r0 = r13
        L_0x0134:
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r1 = EMPTY
            if (r0 != r1) goto L_0x013d
            r1 = r7 ^ r15
            r7 = r1
        L_0x013d:
            java.lang.Object[] r1 = r6.buffer
            r1[r17] = r0
            int r11 = r11 + 1
            r10 = r10 ^ r14
            r0 = r27
            r1 = r28
            r5 = r22
            r8 = r23
            r9 = r24
            goto L_0x006b
        L_0x0152:
            r22 = r5
            r23 = r8
            r24 = r9
            r0 = 0
            int r1 = java.lang.Integer.bitCount(r7)
            if (r7 != 0) goto L_0x0166
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = EMPTY
            r5 = r27
            goto L_0x01e9
        L_0x0166:
            r5 = r27
            int r8 = r5.bitmap
            if (r7 != r8) goto L_0x0179
            boolean r0 = r6.elementsIdentityEquals(r5)
            if (r0 == 0) goto L_0x0176
            r0 = r5
            goto L_0x01e9
        L_0x0176:
            r0 = r6
            goto L_0x01e9
        L_0x0179:
            r9 = 1
            if (r1 != r9) goto L_0x019b
            if (r2 == 0) goto L_0x019b
            java.lang.Object[] r0 = r6.buffer
            int r8 = r6.indexOfCellAt$runtime_release(r7)
            r0 = r0[r8]
            boolean r8 = r0 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            if (r8 == 0) goto L_0x0199
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r8 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            java.lang.Object[] r9 = new java.lang.Object[]{r0}
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r10 = r31.getOwnership$runtime_release()
            r8.<init>(r7, r9, r10)
            r0 = r8
            goto L_0x01e9
        L_0x0199:
            goto L_0x01e9
        L_0x019b:
            java.lang.Object[] r8 = new java.lang.Object[r1]
            java.lang.Object[] r10 = r6.buffer
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x01a6:
            int r15 = r10.length
            if (r13 >= r15) goto L_0x01df
            if (r14 > r13) goto L_0x01ad
            r15 = r9
            goto L_0x01ae
        L_0x01ad:
            r15 = r0
        L_0x01ae:
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt.m2802assert(r15)
            r15 = r10[r13]
            r16 = 0
            r17 = r15
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode$Companion r18 = Companion
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = r18.getEMPTY$runtime_release()
            r9 = r17
            if (r9 == r0) goto L_0x01c3
            r9 = 1
            goto L_0x01c4
        L_0x01c3:
            r9 = 0
        L_0x01c4:
            if (r9 == 0) goto L_0x01da
            int r0 = r11 + r14
            r9 = r10[r13]
            r8[r0] = r9
            int r14 = r14 + 1
            int r0 = r11 + r14
            int r9 = r8.length
            if (r0 > r9) goto L_0x01d6
            r9 = 1
            goto L_0x01d7
        L_0x01d6:
            r9 = 0
        L_0x01d7:
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt.m2802assert(r9)
        L_0x01da:
            int r13 = r13 + 1
            r0 = 0
            r9 = 1
            goto L_0x01a6
        L_0x01df:
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r0 = new androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode
            androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership r9 = r31.getOwnership$runtime_release()
            r0.<init>(r7, r8, r9)
        L_0x01e9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode, int, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder):java.lang.Object");
    }

    public final boolean containsAll(TrieNode<E> otherNode, int shift) {
        int $this$forEachOneBit$iv;
        int potentialBitMap;
        boolean z;
        TrieNode trieNode = this;
        TrieNode<E> trieNode2 = otherNode;
        int i = shift;
        Intrinsics.checkNotNullParameter(trieNode2, "otherNode");
        if (trieNode == trieNode2) {
            return true;
        }
        if (i > 30) {
            for (Object element$iv : trieNode2.buffer) {
                if (!ArraysKt.contains((T[]) trieNode.buffer, element$iv)) {
                    return false;
                }
            }
            return true;
        }
        int i2 = trieNode.bitmap;
        int i3 = trieNode2.bitmap;
        int potentialBitMap2 = i2 & i3;
        if (potentialBitMap2 != i3) {
            return false;
        }
        int $this$forEachOneBit$iv2 = potentialBitMap2;
        int mask$iv = $this$forEachOneBit$iv2;
        int index$iv = 0;
        while (mask$iv != 0) {
            int bit$iv = Integer.lowestOneBit(mask$iv);
            int positionMask = bit$iv;
            int thisIndex = trieNode.indexOfCellAt$runtime_release(positionMask);
            int otherNodeIndex = trieNode2.indexOfCellAt$runtime_release(positionMask);
            Object thisCell = trieNode.buffer[thisIndex];
            Object otherNodeCell = trieNode2.buffer[otherNodeIndex];
            boolean thisIsNode = thisCell instanceof TrieNode;
            boolean otherIsNode = otherNodeCell instanceof TrieNode;
            if (!thisIsNode || !otherIsNode) {
                potentialBitMap = potentialBitMap2;
                $this$forEachOneBit$iv = $this$forEachOneBit$iv2;
                if (thisIsNode) {
                    Intrinsics.checkNotNull(thisCell, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda$13>");
                    TrieNode trieNode3 = (TrieNode) thisCell;
                    if (!((TrieNode) thisCell).contains(otherNodeCell != null ? otherNodeCell.hashCode() : 0, otherNodeCell, i + 5)) {
                        return false;
                    }
                    z = false;
                } else {
                    z = false;
                    if (otherIsNode || !Intrinsics.areEqual(thisCell, otherNodeCell)) {
                        return false;
                    }
                }
            } else {
                Intrinsics.checkNotNull(thisCell, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda$13>");
                TrieNode trieNode4 = (TrieNode) thisCell;
                Intrinsics.checkNotNull(otherNodeCell, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda$13>");
                TrieNode trieNode5 = (TrieNode) otherNodeCell;
                potentialBitMap = potentialBitMap2;
                $this$forEachOneBit$iv = $this$forEachOneBit$iv2;
                if (!((TrieNode) thisCell).containsAll((TrieNode) otherNodeCell, i + 5)) {
                    return false;
                }
                z = false;
            }
            index$iv++;
            mask$iv ^= bit$iv;
            trieNode = this;
            boolean z2 = z;
            potentialBitMap2 = potentialBitMap;
            $this$forEachOneBit$iv2 = $this$forEachOneBit$iv;
            trieNode2 = otherNode;
        }
        return true;
    }

    public final TrieNode<E> add(int elementHash, E element, int shift) {
        TrieNode newNode;
        int cellPositionMask = 1 << TrieNodeKt.indexSegment(elementHash, shift);
        if (hasNoCellAt(cellPositionMask)) {
            return addElementAt(cellPositionMask, element);
        }
        int cellIndex = indexOfCellAt$runtime_release(cellPositionMask);
        Object obj = this.buffer[cellIndex];
        if (obj instanceof TrieNode) {
            TrieNode targetNode = nodeAtIndex(cellIndex);
            if (shift == 30) {
                newNode = targetNode.collisionAdd(element);
            } else {
                newNode = targetNode.add(elementHash, element, shift + 5);
            }
            if (targetNode == newNode) {
                return this;
            }
            return updateNodeAtIndex(cellIndex, newNode);
        } else if (Intrinsics.areEqual((Object) element, obj)) {
            return this;
        } else {
            return moveElementToNode(cellIndex, elementHash, element, shift);
        }
    }

    public final TrieNode<E> mutableAdd(int elementHash, E element, int shift, PersistentHashSetBuilder<?> mutator) {
        TrieNode newNode;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int cellPosition = 1 << TrieNodeKt.indexSegment(elementHash, shift);
        if (hasNoCellAt(cellPosition)) {
            mutator.setSize(mutator.size() + 1);
            return mutableAddElementAt(cellPosition, element, mutator.getOwnership$runtime_release());
        }
        int cellIndex = indexOfCellAt$runtime_release(cellPosition);
        Object obj = this.buffer[cellIndex];
        if (obj instanceof TrieNode) {
            TrieNode targetNode = nodeAtIndex(cellIndex);
            if (shift == 30) {
                newNode = targetNode.mutableCollisionAdd(element, mutator);
            } else {
                newNode = targetNode.mutableAdd(elementHash, element, shift + 5, mutator);
            }
            if (targetNode == newNode) {
                return this;
            }
            return mutableUpdateNodeAtIndex(cellIndex, newNode, mutator.getOwnership$runtime_release());
        } else if (Intrinsics.areEqual((Object) element, obj)) {
            return this;
        } else {
            mutator.setSize(mutator.size() + 1);
            return mutableMoveElementToNode(cellIndex, elementHash, element, shift, mutator.getOwnership$runtime_release());
        }
    }

    public final TrieNode<E> remove(int elementHash, E element, int shift) {
        TrieNode newNode;
        int cellPositionMask = 1 << TrieNodeKt.indexSegment(elementHash, shift);
        if (hasNoCellAt(cellPositionMask)) {
            return this;
        }
        int cellIndex = indexOfCellAt$runtime_release(cellPositionMask);
        Object obj = this.buffer[cellIndex];
        if (obj instanceof TrieNode) {
            TrieNode targetNode = nodeAtIndex(cellIndex);
            if (shift == 30) {
                newNode = targetNode.collisionRemove(element);
            } else {
                newNode = targetNode.remove(elementHash, element, shift + 5);
            }
            if (targetNode == newNode) {
                return this;
            }
            return updateNodeAtIndex(cellIndex, newNode);
        } else if (Intrinsics.areEqual((Object) element, obj)) {
            return removeCellAtIndex(cellIndex, cellPositionMask);
        } else {
            return this;
        }
    }

    public final TrieNode<E> mutableRemove(int elementHash, E element, int shift, PersistentHashSetBuilder<?> mutator) {
        TrieNode newNode;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int cellPositionMask = 1 << TrieNodeKt.indexSegment(elementHash, shift);
        if (hasNoCellAt(cellPositionMask)) {
            return this;
        }
        int cellIndex = indexOfCellAt$runtime_release(cellPositionMask);
        Object obj = this.buffer[cellIndex];
        if (obj instanceof TrieNode) {
            TrieNode targetNode = nodeAtIndex(cellIndex);
            if (shift == 30) {
                newNode = targetNode.mutableCollisionRemove(element, mutator);
            } else {
                newNode = targetNode.mutableRemove(elementHash, element, shift + 5, mutator);
            }
            if (this.ownedBy == mutator.getOwnership$runtime_release() || targetNode != newNode) {
                return mutableUpdateNodeAtIndex(cellIndex, newNode, mutator.getOwnership$runtime_release());
            }
            return this;
        } else if (!Intrinsics.areEqual((Object) element, obj)) {
            return this;
        } else {
            mutator.setSize(mutator.size() - 1);
            return mutableRemoveCellAtIndex(cellIndex, cellPositionMask, mutator.getOwnership$runtime_release());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "", "getEMPTY$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TrieNode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TrieNode getEMPTY$runtime_release() {
            return TrieNode.EMPTY;
        }
    }
}
