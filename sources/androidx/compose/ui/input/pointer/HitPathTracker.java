package androidx.compose.ui.input.pointer;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/input/pointer/HitPathTracker;", "", "rootCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "root", "Landroidx/compose/ui/input/pointer/NodeParent;", "getRoot$ui_release", "()Landroidx/compose/ui/input/pointer/NodeParent;", "addHitPath", "", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerInputNodes", "", "Landroidx/compose/ui/node/PointerInputModifierNode;", "addHitPath-KNwqfcY", "(JLjava/util/List;)V", "dispatchChanges", "", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "processCancel", "removeDetachedPointerInputFilters", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HitPathTracker.kt */
public final class HitPathTracker {
    private final NodeParent root = new NodeParent();
    private final LayoutCoordinates rootCoordinates;

    public HitPathTracker(LayoutCoordinates rootCoordinates2) {
        Intrinsics.checkNotNullParameter(rootCoordinates2, "rootCoordinates");
        this.rootCoordinates = rootCoordinates2;
    }

    public final NodeParent getRoot$ui_release() {
        return this.root;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r12v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: addHitPath-KNwqfcY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m4598addHitPathKNwqfcY(long r17, java.util.List<? extends androidx.compose.ui.node.PointerInputModifierNode> r19) {
        /*
            r16 = this;
            r0 = r19
            java.lang.String r1 = "pointerInputNodes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = r16
            androidx.compose.ui.input.pointer.NodeParent r2 = r1.root
            r3 = 1
            r4 = 0
            int r5 = r19.size()
        L_0x0012:
            if (r4 >= r5) goto L_0x008b
            java.lang.Object r6 = r0.get(r4)
            androidx.compose.ui.node.PointerInputModifierNode r6 = (androidx.compose.ui.node.PointerInputModifierNode) r6
            if (r3 == 0) goto L_0x006a
            androidx.compose.runtime.collection.MutableVector r7 = r2.getChildren()
            r8 = 0
            int r9 = r7.getSize()
            if (r9 <= 0) goto L_0x0043
            r10 = 0
            java.lang.Object[] r11 = r7.getContent()
        L_0x002d:
            r12 = r11[r10]
            r13 = r12
            androidx.compose.ui.input.pointer.Node r13 = (androidx.compose.ui.input.pointer.Node) r13
            r14 = 0
            androidx.compose.ui.node.PointerInputModifierNode r15 = r13.getPointerInputNode()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r6)
            if (r13 == 0) goto L_0x003e
            goto L_0x0044
        L_0x003e:
            int r10 = r10 + 1
            if (r10 < r9) goto L_0x002d
        L_0x0043:
            r12 = 0
        L_0x0044:
            r7 = r12
            androidx.compose.ui.input.pointer.Node r7 = (androidx.compose.ui.input.pointer.Node) r7
            if (r7 == 0) goto L_0x0069
            r7.markIsIn()
            androidx.compose.runtime.collection.MutableVector r8 = r7.getPointerIds()
            androidx.compose.ui.input.pointer.PointerId r9 = androidx.compose.ui.input.pointer.PointerId.m4649boximpl(r17)
            boolean r8 = r8.contains(r9)
            if (r8 != 0) goto L_0x0065
            androidx.compose.runtime.collection.MutableVector r8 = r7.getPointerIds()
            androidx.compose.ui.input.pointer.PointerId r9 = androidx.compose.ui.input.pointer.PointerId.m4649boximpl(r17)
            r8.add(r9)
        L_0x0065:
            r2 = r7
            androidx.compose.ui.input.pointer.NodeParent r2 = (androidx.compose.ui.input.pointer.NodeParent) r2
            goto L_0x0088
        L_0x0069:
            r3 = 0
        L_0x006a:
            androidx.compose.ui.input.pointer.Node r7 = new androidx.compose.ui.input.pointer.Node
            r7.<init>(r6)
            r8 = r7
            r9 = 0
            androidx.compose.runtime.collection.MutableVector r10 = r8.getPointerIds()
            androidx.compose.ui.input.pointer.PointerId r11 = androidx.compose.ui.input.pointer.PointerId.m4649boximpl(r17)
            r10.add(r11)
            androidx.compose.runtime.collection.MutableVector r8 = r2.getChildren()
            r8.add(r7)
            r2 = r7
            androidx.compose.ui.input.pointer.NodeParent r2 = (androidx.compose.ui.input.pointer.NodeParent) r2
        L_0x0088:
            int r4 = r4 + 1
            goto L_0x0012
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.HitPathTracker.m4598addHitPathKNwqfcY(long, java.util.List):void");
    }

    public static /* synthetic */ boolean dispatchChanges$default(HitPathTracker hitPathTracker, InternalPointerEvent internalPointerEvent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return hitPathTracker.dispatchChanges(internalPointerEvent, z);
    }

    public final boolean dispatchChanges(InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        if (!this.root.buildCache(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, isInBounds)) {
            return false;
        }
        boolean dispatchHit = this.root.dispatchMainEventPass(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, isInBounds);
        if (this.root.dispatchFinalEventPass(internalPointerEvent) || dispatchHit) {
            return true;
        }
        return false;
    }

    public final void processCancel() {
        this.root.dispatchCancel();
        this.root.clear();
    }

    public final void removeDetachedPointerInputFilters() {
        this.root.removeDetachedPointerInputFilters();
    }
}
