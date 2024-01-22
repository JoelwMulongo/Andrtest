package androidx.compose.ui.layout;

import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016J%\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"androidx/compose/ui/layout/LayoutNodeSubcompositionsState$precompose$1", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "placeablesCount", "", "getPlaceablesCount", "()I", "dispose", "", "premeasure", "index", "constraints", "Landroidx/compose/ui/unit/Constraints;", "premeasure-0kLqBqw", "(IJ)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
public final class LayoutNodeSubcompositionsState$precompose$1 implements SubcomposeLayoutState.PrecomposedSlotHandle {
    final /* synthetic */ Object $slotId;
    final /* synthetic */ LayoutNodeSubcompositionsState this$0;

    LayoutNodeSubcompositionsState$precompose$1(LayoutNodeSubcompositionsState $receiver, Object $slotId2) {
        this.this$0 = $receiver;
        this.$slotId = $slotId2;
    }

    public void dispose() {
        this.this$0.makeSureStateIsConsistent();
        LayoutNode node = (LayoutNode) this.this$0.precomposeMap.remove(this.$slotId);
        if (node != null) {
            boolean z = false;
            if (this.this$0.precomposedCount > 0) {
                int itemIndex = this.this$0.root.getFoldedChildren$ui_release().indexOf(node);
                if (itemIndex >= this.this$0.root.getFoldedChildren$ui_release().size() - this.this$0.precomposedCount) {
                    z = true;
                }
                if (z) {
                    LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.this$0;
                    layoutNodeSubcompositionsState.reusableCount = layoutNodeSubcompositionsState.reusableCount + 1;
                    LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = this.this$0;
                    layoutNodeSubcompositionsState2.precomposedCount = layoutNodeSubcompositionsState2.precomposedCount - 1;
                    int reusableStart = (this.this$0.root.getFoldedChildren$ui_release().size() - this.this$0.precomposedCount) - this.this$0.reusableCount;
                    this.this$0.move(itemIndex, reusableStart, 1);
                    this.this$0.disposeOrReuseStartingFromIndex(reusableStart);
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public int getPlaceablesCount() {
        List<LayoutNode> children$ui_release;
        LayoutNode layoutNode = (LayoutNode) this.this$0.precomposeMap.get(this.$slotId);
        if (layoutNode == null || (children$ui_release = layoutNode.getChildren$ui_release()) == null) {
            return 0;
        }
        return children$ui_release.size();
    }

    /* renamed from: premeasure-0kLqBqw  reason: not valid java name */
    public void m4850premeasure0kLqBqw(int index, long constraints) {
        LayoutNode node = (LayoutNode) this.this$0.precomposeMap.get(this.$slotId);
        if (node != null && node.isAttached()) {
            int size = node.getChildren$ui_release().size();
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index (" + index + ") is out of bound of [0, " + size + ')');
            } else if (!node.isPlaced()) {
                LayoutNode this_$iv = this.this$0.root;
                this_$iv.ignoreRemeasureRequests = true;
                LayoutNodeKt.requireOwner(node).m5176measureAndLayout0kLqBqw(node.getChildren$ui_release().get(index), constraints);
                this_$iv.ignoreRemeasureRequests = false;
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }
}
