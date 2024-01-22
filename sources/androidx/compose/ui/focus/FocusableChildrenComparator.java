package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002¨\u0006\r"}, d2 = {"Landroidx/compose/ui/focus/FocusableChildrenComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "Lkotlin/Comparator;", "()V", "compare", "", "focusTarget1", "focusTarget2", "pathFromRoot", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OneDimensionalFocusSearch.kt */
final class FocusableChildrenComparator implements Comparator<FocusTargetModifierNode> {
    public static final FocusableChildrenComparator INSTANCE = new FocusableChildrenComparator();

    private FocusableChildrenComparator() {
    }

    public int compare(FocusTargetModifierNode focusTarget1, FocusTargetModifierNode focusTarget2) {
        if (focusTarget1 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        } else if (focusTarget2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        } else if (FocusTraversalKt.isEligibleForFocusSearch(focusTarget1) && FocusTraversalKt.isEligibleForFocusSearch(focusTarget2)) {
            NodeCoordinator coordinator$ui_release = focusTarget1.getCoordinator$ui_release();
            LayoutNode layoutNode = null;
            LayoutNode layoutNode1 = coordinator$ui_release != null ? coordinator$ui_release.getLayoutNode() : null;
            if (layoutNode1 != null) {
                NodeCoordinator coordinator$ui_release2 = focusTarget2.getCoordinator$ui_release();
                if (coordinator$ui_release2 != null) {
                    layoutNode = coordinator$ui_release2.getLayoutNode();
                }
                if (layoutNode != null) {
                    LayoutNode layoutNode2 = layoutNode;
                    if (Intrinsics.areEqual((Object) layoutNode1, (Object) layoutNode2)) {
                        return 0;
                    }
                    MutableVector this_$iv = pathFromRoot(layoutNode1);
                    MutableVector this_$iv2 = pathFromRoot(layoutNode2);
                    int depth = 0;
                    int min = Math.min(this_$iv.getSize() - 1, this_$iv2.getSize() - 1);
                    if (0 <= min) {
                        while (Intrinsics.areEqual(this_$iv.getContent()[depth], this_$iv2.getContent()[depth])) {
                            if (depth != min) {
                                depth++;
                            }
                        }
                        return Intrinsics.compare(((LayoutNode) this_$iv.getContent()[depth]).getPlaceOrder$ui_release(), ((LayoutNode) this_$iv2.getContent()[depth]).getPlaceOrder$ui_release());
                    }
                    throw new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.".toString());
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
            throw new IllegalStateException("Required value was null.".toString());
        } else if (FocusTraversalKt.isEligibleForFocusSearch(focusTarget1)) {
            return -1;
        } else {
            return FocusTraversalKt.isEligibleForFocusSearch(focusTarget2) ? 1 : 0;
        }
    }

    private final MutableVector<LayoutNode> pathFromRoot(LayoutNode layoutNode) {
        MutableVector path = new MutableVector(new LayoutNode[16], 0);
        for (LayoutNode current = layoutNode; current != null; current = current.getParent$ui_release()) {
            path.add(0, current);
        }
        return path;
    }
}
