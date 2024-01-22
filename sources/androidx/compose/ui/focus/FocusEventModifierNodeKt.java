package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0001¨\u0006\u0006"}, d2 = {"getFocusState", "Landroidx/compose/ui/focus/FocusState;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "refreshFocusEventNodes", "", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusEventModifierNode.kt */
public final class FocusEventModifierNodeKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusEventModifierNode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final FocusState getFocusState(FocusEventModifierNode $this$getFocusState) {
        FocusEventModifierNode $this$visitChildren_u2d6rFNWt0$iv = $this$getFocusState;
        Intrinsics.checkNotNullParameter($this$visitChildren_u2d6rFNWt0$iv, "<this>");
        int mask$iv$iv = NodeKind.m5123constructorimpl(1024);
        DelegatableNode $this$visitChildren$iv$iv = $this$visitChildren_u2d6rFNWt0$iv;
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
                            continue;
                        } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            Modifier.Node it$iv = node$iv$iv;
                            if (it$iv instanceof FocusTargetModifierNode) {
                                FocusStateImpl focusState = ((FocusTargetModifierNode) it$iv).getFocusStateImpl$ui_release();
                                switch (WhenMappings.$EnumSwitchMapping$0[focusState.ordinal()]) {
                                    case 1:
                                    case 2:
                                    case 3:
                                        return focusState;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                        }
                    }
                }
            }
            return FocusStateImpl.Inactive;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final void refreshFocusEventNodes(FocusTargetModifierNode $this$refreshFocusEventNodes) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter($this$refreshFocusEventNodes, "<this>");
        DelegatableNode $this$visitAncestors$iv = $this$refreshFocusEventNodes;
        int mask$iv = NodeKind.m5123constructorimpl(4096) | NodeKind.m5123constructorimpl(1024);
        if ($this$visitAncestors$iv.getNode().isAttached()) {
            Modifier.Node node$iv = $this$visitAncestors$iv.getNode().getParent$ui_release();
            LayoutNode layout$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv);
            while (layout$iv != null) {
                if ((layout$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv) != 0) {
                    while (node$iv != null) {
                        if ((node$iv.getKindSet$ui_release() & mask$iv) != 0) {
                            Modifier.Node it = node$iv;
                            if (!((it.getKindSet$ui_release() & NodeKind.m5123constructorimpl(1024)) != 0)) {
                                if (it instanceof FocusEventModifierNode) {
                                    ((FocusEventModifierNode) it).onFocusEvent(getFocusState((FocusEventModifierNode) it));
                                } else {
                                    throw new IllegalStateException("Check failed.".toString());
                                }
                            } else {
                                return;
                            }
                        }
                        node$iv = node$iv.getParent$ui_release();
                    }
                }
                layout$iv = layout$iv.getParent$ui_release();
                node$iv = (layout$iv == null || (nodes$ui_release = layout$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
