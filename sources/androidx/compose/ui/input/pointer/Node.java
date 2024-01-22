package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.PointerInputModifierNodeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J7\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0017\u0010#\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0%H\bJ7\u0010&\u001a\u00020\b2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0016ø\u0001\u0000J\u001a\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010)\u001a\u00020\u000bH\u0002J\u0006\u0010*\u001a\u00020\u001fJ\b\u0010+\u001a\u00020,H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u0014X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "pointerInputNode", "Landroidx/compose/ui/node/PointerInputModifierNode;", "(Landroidx/compose/ui/node/PointerInputModifierNode;)V", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/PointerId;", "getPointerIds", "()Landroidx/compose/runtime/collection/MutableVector;", "getPointerInputNode", "()Landroidx/compose/ui/node/PointerInputModifierNode;", "relevantChanges", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "wasIn", "buildCache", "changes", "", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HitPathTracker.kt */
public final class Node extends NodeParent {
    private LayoutCoordinates coordinates;
    private boolean hasExited = true;
    private boolean isIn = true;
    private PointerEvent pointerEvent;
    private final MutableVector<PointerId> pointerIds = new MutableVector<>(new PointerId[16], 0);
    private final PointerInputModifierNode pointerInputNode;
    private final Map<PointerId, PointerInputChange> relevantChanges = new LinkedHashMap();
    private boolean wasIn;

    public Node(PointerInputModifierNode pointerInputNode2) {
        Intrinsics.checkNotNullParameter(pointerInputNode2, "pointerInputNode");
        this.pointerInputNode = pointerInputNode2;
    }

    public final PointerInputModifierNode getPointerInputNode() {
        return this.pointerInputNode;
    }

    public final MutableVector<PointerId> getPointerIds() {
        return this.pointerIds;
    }

    public boolean dispatchMainEventPass(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        boolean z;
        InternalPointerEvent internalPointerEvent2 = internalPointerEvent;
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent2, "internalPointerEvent");
        Node this_$iv = this;
        if (this_$iv.relevantChanges.isEmpty()) {
            boolean z2 = isInBounds;
            return false;
        } else if (!PointerInputModifierNodeKt.isAttached(this_$iv.pointerInputNode)) {
            boolean z3 = isInBounds;
            return false;
        } else {
            PointerEvent event = this.pointerEvent;
            Intrinsics.checkNotNull(event);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long size = layoutCoordinates.m4839getSizeYbymL2g();
            this.pointerInputNode.m5177onPointerEventH0pRuoY(event, PointerEventPass.Initial, size);
            if (PointerInputModifierNodeKt.isAttached(this.pointerInputNode)) {
                MutableVector this_$iv2 = getChildren();
                int size$iv = this_$iv2.getSize();
                if (size$iv > 0) {
                    int i$iv = 0;
                    Object[] content$iv = this_$iv2.getContent();
                    while (true) {
                        Node this_$iv3 = this_$iv;
                        Map<PointerId, PointerInputChange> map = this.relevantChanges;
                        LayoutCoordinates layoutCoordinates2 = this.coordinates;
                        Intrinsics.checkNotNull(layoutCoordinates2);
                        ((Node) content$iv[i$iv]).dispatchMainEventPass(map, layoutCoordinates2, internalPointerEvent2, isInBounds);
                        z = true;
                        i$iv++;
                        if (i$iv >= size$iv) {
                            break;
                        }
                        Map<PointerId, PointerInputChange> map2 = changes;
                        LayoutCoordinates layoutCoordinates3 = parentCoordinates;
                        this_$iv = this_$iv3;
                    }
                } else {
                    boolean z4 = isInBounds;
                    Node node = this_$iv;
                    z = true;
                }
            } else {
                boolean z5 = isInBounds;
                Node node2 = this_$iv;
                z = true;
            }
            if (PointerInputModifierNodeKt.isAttached(this.pointerInputNode)) {
                this.pointerInputNode.m5177onPointerEventH0pRuoY(event, PointerEventPass.Main, size);
            }
            return z;
        }
    }

    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        MutableVector this_$iv;
        int size$iv;
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        boolean z = false;
        if (!this.relevantChanges.isEmpty() && PointerInputModifierNodeKt.isAttached(this.pointerInputNode)) {
            PointerEvent event = this.pointerEvent;
            Intrinsics.checkNotNull(event);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            this.pointerInputNode.m5177onPointerEventH0pRuoY(event, PointerEventPass.Final, layoutCoordinates.m4839getSizeYbymL2g());
            if (!PointerInputModifierNodeKt.isAttached(this.pointerInputNode) || (size$iv = this_$iv.getSize()) <= 0) {
                z = true;
            } else {
                int i$iv = 0;
                Object[] content$iv = (this_$iv = getChildren()).getContent();
                do {
                    ((Node) content$iv[i$iv]).dispatchFinalEventPass(internalPointerEvent);
                    i$iv++;
                } while (i$iv < size$iv);
                z = true;
            }
        }
        boolean result = z;
        cleanUpHits(internalPointerEvent);
        clearCache();
        return result;
    }

    public boolean buildCache(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        Object it$iv;
        boolean z;
        int i;
        Map<PointerId, PointerInputChange> map = changes;
        LayoutCoordinates layoutCoordinates = parentCoordinates;
        InternalPointerEvent internalPointerEvent2 = internalPointerEvent;
        Intrinsics.checkNotNullParameter(map, "changes");
        Intrinsics.checkNotNullParameter(layoutCoordinates, "parentCoordinates");
        Intrinsics.checkNotNullParameter(internalPointerEvent2, "internalPointerEvent");
        boolean childChanged = super.buildCache(changes, parentCoordinates, internalPointerEvent, isInBounds);
        if (!PointerInputModifierNodeKt.isAttached(this.pointerInputNode)) {
            return true;
        }
        this.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates(this.pointerInputNode);
        Iterator<Map.Entry<PointerId, PointerInputChange>> it = changes.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            long key = ((PointerId) next.getKey()).m4655unboximpl();
            PointerInputChange change = (PointerInputChange) next.getValue();
            if (this.pointerIds.contains(PointerId.m4649boximpl(key))) {
                List historical = new ArrayList();
                List $this$fastForEach$iv = change.getHistorical();
                int $i$f$fastForEach = false;
                int index$iv = 0;
                int size = $this$fastForEach$iv.size();
                while (index$iv < size) {
                    HistoricalChange it2 = $this$fastForEach$iv.get(index$iv);
                    long uptimeMillis = it2.getUptimeMillis();
                    Iterator<Map.Entry<PointerId, PointerInputChange>> it3 = it;
                    LayoutCoordinates layoutCoordinates2 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates2);
                    historical.add(new HistoricalChange(uptimeMillis, layoutCoordinates2.m4840localPositionOfR5De75A(layoutCoordinates, it2.m4597getPositionF1C5BW0()), (DefaultConstructorMarker) null));
                    index$iv++;
                    $this$fastForEach$iv = $this$fastForEach$iv;
                    $i$f$fastForEach = $i$f$fastForEach;
                    it = it3;
                }
                Iterator<Map.Entry<PointerId, PointerInputChange>> it4 = it;
                List list = $this$fastForEach$iv;
                int i2 = $i$f$fastForEach;
                Map<PointerId, PointerInputChange> map2 = this.relevantChanges;
                PointerId r6 = PointerId.m4649boximpl(key);
                LayoutCoordinates layoutCoordinates3 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates3);
                long r20 = layoutCoordinates3.m4840localPositionOfR5De75A(layoutCoordinates, change.m4668getPreviousPositionF1C5BW0());
                LayoutCoordinates layoutCoordinates4 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates4);
                map2.put(r6, PointerInputChange.m4659copyOHpmEuE$default(change, 0, 0, layoutCoordinates4.m4840localPositionOfR5De75A(layoutCoordinates, change.m4667getPositionF1C5BW0()), false, 0, r20, false, 0, historical, 0, 731, (Object) null));
                it = it4;
            } else {
                Iterator<Map.Entry<PointerId, PointerInputChange>> it5 = it;
            }
        }
        if (this.relevantChanges.isEmpty()) {
            this.pointerIds.clear();
            getChildren().clear();
            return true;
        }
        for (int i3 = this.pointerIds.getSize() - 1; -1 < i3; i3--) {
            if (!map.containsKey(PointerId.m4649boximpl(((PointerId) this.pointerIds.getContent()[i3]).m4655unboximpl()))) {
                this.pointerIds.removeAt(i3);
            }
        }
        PointerEvent event = new PointerEvent(CollectionsKt.toList(this.relevantChanges.values()), internalPointerEvent2);
        List $this$fastForEach$iv$iv = event.getChanges();
        int index$iv$iv = 0;
        int size2 = $this$fastForEach$iv$iv.size();
        while (true) {
            if (index$iv$iv >= size2) {
                it$iv = null;
                break;
            }
            it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            if (internalPointerEvent2.m4599issuesEnterExitEvent0FcD4WY(((PointerInputChange) it$iv).m4666getIdJ3iCeTQ())) {
                break;
            }
            index$iv$iv++;
            Map<PointerId, PointerInputChange> map3 = changes;
            LayoutCoordinates layoutCoordinates5 = parentCoordinates;
        }
        PointerInputChange enterExitChange = (PointerInputChange) it$iv;
        if (enterExitChange != null) {
            if (!isInBounds) {
                this.isIn = false;
                z = true;
            } else if (this.isIn) {
                z = true;
            } else if (enterExitChange.getPressed() || enterExitChange.getPreviousPressed()) {
                LayoutCoordinates layoutCoordinates6 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates6);
                z = true;
                this.isIn = !PointerEventKt.m4614isOutOfBoundsO0kMr_c(enterExitChange, layoutCoordinates6.m4839getSizeYbymL2g());
            } else {
                z = true;
            }
            if (this.isIn != this.wasIn && (PointerEventType.m4619equalsimpl0(event.m4612getType7fucELk(), PointerEventType.Companion.m4625getMove7fucELk()) || PointerEventType.m4619equalsimpl0(event.m4612getType7fucELk(), PointerEventType.Companion.m4623getEnter7fucELk()) || PointerEventType.m4619equalsimpl0(event.m4612getType7fucELk(), PointerEventType.Companion.m4624getExit7fucELk()))) {
                if (this.isIn) {
                    i = PointerEventType.Companion.m4623getEnter7fucELk();
                } else {
                    i = PointerEventType.Companion.m4624getExit7fucELk();
                }
                event.m4613setTypeEhbLWgg$ui_release(i);
            } else if (PointerEventType.m4619equalsimpl0(event.m4612getType7fucELk(), PointerEventType.Companion.m4623getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                event.m4613setTypeEhbLWgg$ui_release(PointerEventType.Companion.m4625getMove7fucELk());
            } else if (PointerEventType.m4619equalsimpl0(event.m4612getType7fucELk(), PointerEventType.Companion.m4624getExit7fucELk()) && this.isIn && enterExitChange.getPressed()) {
                event.m4613setTypeEhbLWgg$ui_release(PointerEventType.Companion.m4625getMove7fucELk());
            }
        } else {
            z = true;
        }
        boolean changed = (childChanged || !PointerEventType.m4619equalsimpl0(event.m4612getType7fucELk(), PointerEventType.Companion.m4625getMove7fucELk()) || hasPositionChanged(this.pointerEvent, event)) ? z : false;
        this.pointerEvent = event;
        return changed;
    }

    private final boolean hasPositionChanged(PointerEvent oldEvent, PointerEvent newEvent) {
        if (oldEvent == null || oldEvent.getChanges().size() != newEvent.getChanges().size()) {
            return true;
        }
        int size = newEvent.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m2912equalsimpl0(oldEvent.getChanges().get(i).m4667getPositionF1C5BW0(), newEvent.getChanges().get(i).m4667getPositionF1C5BW0())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> block) {
        if (this.relevantChanges.isEmpty() || !PointerInputModifierNodeKt.isAttached(this.pointerInputNode)) {
            return false;
        }
        block.invoke();
        return true;
    }

    public void dispatchCancel() {
        MutableVector this_$iv = getChildren();
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                ((Node) content$iv[i$iv]).dispatchCancel();
                i$iv++;
            } while (i$iv < size$iv);
        }
        this.pointerInputNode.onCancelPointerInput();
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        Intrinsics.checkNotNullParameter(internalPointerEvent, "internalPointerEvent");
        super.cleanUpHits(internalPointerEvent);
        PointerEvent event = this.pointerEvent;
        if (event != null) {
            this.wasIn = this.isIn;
            List $this$fastForEach$iv = event.getChanges();
            int index$iv = 0;
            int size = $this$fastForEach$iv.size();
            while (true) {
                boolean remove = false;
                if (index$iv < size) {
                    PointerInputChange change = $this$fastForEach$iv.get(index$iv);
                    if (!change.getPressed() && (!internalPointerEvent.m4599issuesEnterExitEvent0FcD4WY(change.m4666getIdJ3iCeTQ()) || !this.isIn)) {
                        remove = true;
                    }
                    if (remove) {
                        this.pointerIds.remove(PointerId.m4649boximpl(change.m4666getIdJ3iCeTQ()));
                    }
                    index$iv++;
                } else {
                    this.isIn = false;
                    this.hasExited = PointerEventType.m4619equalsimpl0(event.m4612getType7fucELk(), PointerEventType.Companion.m4624getExit7fucELk());
                    return;
                }
            }
        }
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.pointerInputNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }
}
