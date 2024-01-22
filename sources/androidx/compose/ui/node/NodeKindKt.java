package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.layout.IntermediateLayoutModifier;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.LookaheadOnPlacedModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.semantics.SemanticsModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a&\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0006H\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\f*\u00020\u001bH\u0003\u001a\f\u0010\u001c\u001a\u00020\u0005*\u00020\u001bH\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"%\u0010\u0004\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u00068@X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Inserted", "", "Removed", "Updated", "includeSelfInTraversal", "", "Landroidx/compose/ui/node/NodeKind;", "getIncludeSelfInTraversal-H91voCI$annotations", "(I)V", "getIncludeSelfInTraversal-H91voCI", "(I)Z", "autoInvalidateInsertedNode", "", "node", "Landroidx/compose/ui/Modifier$Node;", "autoInvalidateNode", "phase", "autoInvalidateRemovedNode", "autoInvalidateUpdatedNode", "calculateNodeKindSetFrom", "element", "Landroidx/compose/ui/Modifier$Element;", "or", "other", "or-64DMado", "(II)I", "scheduleInvalidationOfAssociatedFocusTargets", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "specifiesCanFocusProperty", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeKind.kt */
public final class NodeKindKt {
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private static final int Updated = 0;

    /* renamed from: getIncludeSelfInTraversal-H91voCI$annotations  reason: not valid java name */
    public static /* synthetic */ void m5132getIncludeSelfInTraversalH91voCI$annotations(int i) {
    }

    /* renamed from: or-64DMado  reason: not valid java name */
    public static final int m5133or64DMado(int $this$or_u2d64DMado, int other) {
        return $this$or_u2d64DMado | other;
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI  reason: not valid java name */
    public static final boolean m5131getIncludeSelfInTraversalH91voCI(int $this$includeSelfInTraversal) {
        return (NodeKind.m5123constructorimpl(128) & $this$includeSelfInTraversal) != 0;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        int mask = NodeKind.m5123constructorimpl(1);
        if (element instanceof LayoutModifier) {
            mask = NodeKind.m5123constructorimpl(2) | mask;
        }
        if (element instanceof IntermediateLayoutModifier) {
            mask = NodeKind.m5123constructorimpl(512) | mask;
        }
        if (element instanceof DrawModifier) {
            mask = NodeKind.m5123constructorimpl(4) | mask;
        }
        if (element instanceof SemanticsModifier) {
            mask = NodeKind.m5123constructorimpl(8) | mask;
        }
        if (element instanceof PointerInputModifier) {
            mask = NodeKind.m5123constructorimpl(16) | mask;
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider)) {
            mask = NodeKind.m5123constructorimpl(32) | mask;
        }
        if (element instanceof FocusEventModifier) {
            mask = NodeKind.m5123constructorimpl(4096) | mask;
        }
        if (element instanceof FocusOrderModifier) {
            mask = NodeKind.m5123constructorimpl(2048) | mask;
        }
        if (element instanceof OnGloballyPositionedModifier) {
            mask = NodeKind.m5123constructorimpl(256) | mask;
        }
        if (element instanceof ParentDataModifier) {
            mask = NodeKind.m5123constructorimpl(64) | mask;
        }
        if ((element instanceof OnPlacedModifier) || (element instanceof OnRemeasuredModifier) || (element instanceof LookaheadOnPlacedModifier)) {
            return NodeKind.m5123constructorimpl(128) | mask;
        }
        return mask;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        int mask = NodeKind.m5123constructorimpl(1);
        if (node instanceof LayoutModifierNode) {
            mask = NodeKind.m5123constructorimpl(2) | mask;
        }
        if (node instanceof DrawModifierNode) {
            mask = NodeKind.m5123constructorimpl(4) | mask;
        }
        if (node instanceof SemanticsModifierNode) {
            mask = NodeKind.m5123constructorimpl(8) | mask;
        }
        if (node instanceof PointerInputModifierNode) {
            mask = NodeKind.m5123constructorimpl(16) | mask;
        }
        if (node instanceof ModifierLocalNode) {
            mask = NodeKind.m5123constructorimpl(32) | mask;
        }
        if (node instanceof ParentDataModifierNode) {
            mask = NodeKind.m5123constructorimpl(64) | mask;
        }
        if (node instanceof LayoutAwareModifierNode) {
            mask = NodeKind.m5123constructorimpl(128) | mask;
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            mask = NodeKind.m5123constructorimpl(256) | mask;
        }
        if (node instanceof IntermediateLayoutModifierNode) {
            mask = NodeKind.m5123constructorimpl(512) | mask;
        }
        if (node instanceof FocusTargetModifierNode) {
            mask = NodeKind.m5123constructorimpl(1024) | mask;
        }
        if (node instanceof FocusPropertiesModifierNode) {
            mask = NodeKind.m5123constructorimpl(2048) | mask;
        }
        if (node instanceof FocusEventModifierNode) {
            mask = NodeKind.m5123constructorimpl(4096) | mask;
        }
        if (node instanceof KeyInputModifierNode) {
            mask = NodeKind.m5123constructorimpl(8192) | mask;
        }
        if (node instanceof RotaryInputModifierNode) {
            return NodeKind.m5123constructorimpl(16384) | mask;
        }
        return mask;
    }

    public static final void autoInvalidateRemovedNode(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        autoInvalidateNode(node, 2);
    }

    public static final void autoInvalidateInsertedNode(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        autoInvalidateNode(node, 1);
    }

    public static final void autoInvalidateUpdatedNode(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        autoInvalidateNode(node, 0);
    }

    private static final void autoInvalidateNode(Modifier.Node node, int phase) {
        if (node.isAttached()) {
            boolean z = true;
            if (((node.getKindSet$ui_release() & NodeKind.m5123constructorimpl(2)) != 0 ? 1 : 0) != 0 && (node instanceof LayoutModifierNode)) {
                LayoutModifierNodeKt.invalidateMeasurements((LayoutModifierNode) node);
                if (phase == 2) {
                    DelegatableNodeKt.m4965requireCoordinator64DMado(node, NodeKind.m5123constructorimpl(2)).onRelease();
                }
            }
            if (((node.getKindSet$ui_release() & NodeKind.m5123constructorimpl(256)) != 0 ? 1 : 0) != 0 && (node instanceof GlobalPositionAwareModifierNode)) {
                DelegatableNodeKt.requireLayoutNode(node).invalidateMeasurements$ui_release();
            }
            if (((node.getKindSet$ui_release() & NodeKind.m5123constructorimpl(4)) != 0 ? 1 : 0) != 0 && (node instanceof DrawModifierNode)) {
                DrawModifierNodeKt.invalidateDraw((DrawModifierNode) node);
            }
            if (((node.getKindSet$ui_release() & NodeKind.m5123constructorimpl(8)) != 0 ? 1 : 0) != 0 && (node instanceof SemanticsModifierNode)) {
                SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode) node);
            }
            if (((node.getKindSet$ui_release() & NodeKind.m5123constructorimpl(64)) != 0 ? 1 : 0) != 0 && (node instanceof ParentDataModifierNode)) {
                ParentDataModifierNodeKt.invalidateParentData((ParentDataModifierNode) node);
            }
            if (((node.getKindSet$ui_release() & NodeKind.m5123constructorimpl(1024)) != 0 ? 1 : 0) != 0 && (node instanceof FocusTargetModifierNode)) {
                if (phase == 2) {
                    node.onReset();
                } else {
                    DelegatableNodeKt.requireOwner(node).getFocusOwner().scheduleInvalidation((FocusTargetModifierNode) node);
                }
            }
            if (((node.getKindSet$ui_release() & NodeKind.m5123constructorimpl(2048)) != 0 ? 1 : 0) != 0 && (node instanceof FocusPropertiesModifierNode) && specifiesCanFocusProperty((FocusPropertiesModifierNode) node)) {
                if (phase == 2) {
                    scheduleInvalidationOfAssociatedFocusTargets((FocusPropertiesModifierNode) node);
                } else {
                    DelegatableNodeKt.requireOwner(node).getFocusOwner().scheduleInvalidation((FocusPropertiesModifierNode) node);
                }
            }
            if ((node.getKindSet$ui_release() & NodeKind.m5123constructorimpl(4096)) == 0) {
                z = false;
            }
            if (z && (node instanceof FocusEventModifierNode) && phase != 2) {
                DelegatableNodeKt.requireOwner(node).getFocusOwner().scheduleInvalidation((FocusEventModifierNode) node);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private static final void scheduleInvalidationOfAssociatedFocusTargets(FocusPropertiesModifierNode $this$scheduleInvalidationOfAssociatedFocusTargets) {
        int mask$iv$iv = NodeKind.m5123constructorimpl(1024);
        DelegatableNode $this$visitChildren$iv$iv = $this$scheduleInvalidationOfAssociatedFocusTargets;
        if ($this$visitChildren$iv$iv.getNode().isAttached()) {
            MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$iv$iv = $this$visitChildren$iv$iv.getNode().getChild$ui_release();
            if (child$iv$iv == null) {
                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren$iv$iv.getNode());
            } else {
                branches$iv$iv.add(child$iv$iv);
            }
            while (branches$iv$iv.isNotEmpty()) {
                Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) == 0) {
                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                } else {
                    Modifier.Node node$iv$iv = branch$iv$iv;
                    while (true) {
                        if (node$iv$iv == null) {
                            break;
                        } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            Modifier.Node it$iv = node$iv$iv;
                            if (it$iv instanceof FocusTargetModifierNode) {
                                DelegatableNodeKt.requireOwner($this$scheduleInvalidationOfAssociatedFocusTargets).getFocusOwner().scheduleInvalidation((FocusTargetModifierNode) it$iv);
                            }
                        } else {
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                        }
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private static final boolean specifiesCanFocusProperty(FocusPropertiesModifierNode $this$specifiesCanFocusProperty) {
        CanFocusChecker.INSTANCE.reset();
        $this$specifiesCanFocusProperty.modifyFocusProperties(CanFocusChecker.INSTANCE);
        return CanFocusChecker.INSTANCE.isCanFocusSet();
    }
}
