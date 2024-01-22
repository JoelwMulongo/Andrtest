package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.SemanticsModifierNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\fH\u0002\u001a\"\u0010\u0011\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u0013H\u0000\u001a\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016*\u00020\u00022\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018H\u0002\u001a\f\u0010\u0019\u001a\u00020\u0010*\u00020\fH\u0002\" \u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\" \u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\f8BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"outerMergingSemantics", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/LayoutNode;", "getOuterMergingSemantics$annotations", "(Landroidx/compose/ui/node/LayoutNode;)V", "getOuterMergingSemantics", "(Landroidx/compose/ui/node/LayoutNode;)Landroidx/compose/ui/node/SemanticsModifierNode;", "outerSemantics", "getOuterSemantics$annotations", "getOuterSemantics", "role", "Landroidx/compose/ui/semantics/Role;", "Landroidx/compose/ui/semantics/SemanticsNode;", "getRole", "(Landroidx/compose/ui/semantics/SemanticsNode;)Landroidx/compose/ui/semantics/Role;", "contentDescriptionFakeNodeId", "", "findClosestParentNode", "selector", "Lkotlin/Function1;", "", "findOneLayerOfSemanticsWrappers", "", "list", "", "roleFakeNodeId", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SemanticsNode.kt */
public final class SemanticsNodeKt {
    public static /* synthetic */ void getOuterMergingSemantics$annotations(LayoutNode layoutNode) {
    }

    public static /* synthetic */ void getOuterSemantics$annotations(LayoutNode layoutNode) {
    }

    public static final SemanticsModifierNode getOuterSemantics(LayoutNode $this$outerSemantics) {
        Modifier.Node node;
        NodeChain this_$iv;
        Intrinsics.checkNotNullParameter($this$outerSemantics, "<this>");
        NodeChain this_$iv2 = $this$outerSemantics.getNodes$ui_release();
        int mask$iv$iv$iv = NodeKind.m5123constructorimpl(8);
        NodeChain this_$iv$iv$iv = this_$iv2;
        if ((this_$iv$iv$iv.getAggregateChildKindSet() & mask$iv$iv$iv) != 0) {
            Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv.getHead$ui_release();
            while (true) {
                if (node$iv$iv$iv$iv == null) {
                    break;
                }
                Modifier.Node it$iv$iv$iv = node$iv$iv$iv$iv;
                if ((it$iv$iv$iv.getKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                    Modifier.Node it$iv$iv = it$iv$iv$iv;
                    this_$iv = this_$iv2;
                    if (it$iv$iv instanceof SemanticsModifierNode) {
                        node = it$iv$iv;
                        break;
                    }
                } else {
                    this_$iv = this_$iv2;
                }
                if ((it$iv$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv$iv) == 0) {
                    break;
                }
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                this_$iv2 = this_$iv;
            }
            return (SemanticsModifierNode) node;
        }
        node = null;
        return (SemanticsModifierNode) node;
    }

    public static final SemanticsModifierNode getOuterMergingSemantics(LayoutNode $this$outerMergingSemantics) {
        Object it$iv;
        NodeChain this_$iv;
        Intrinsics.checkNotNullParameter($this$outerMergingSemantics, "<this>");
        NodeChain this_$iv2 = $this$outerMergingSemantics.getNodes$ui_release();
        int mask$iv$iv$iv = NodeKind.m5123constructorimpl(8);
        NodeChain this_$iv$iv$iv = this_$iv2;
        if ((this_$iv$iv$iv.getAggregateChildKindSet() & mask$iv$iv$iv) != 0) {
            Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv.getHead$ui_release();
            while (true) {
                if (node$iv$iv$iv$iv == null) {
                    break;
                }
                Modifier.Node it$iv$iv$iv = node$iv$iv$iv$iv;
                if ((it$iv$iv$iv.getKindSet$ui_release() & mask$iv$iv$iv) != 0) {
                    Object it$iv$iv = it$iv$iv$iv;
                    this_$iv = this_$iv2;
                    if (it$iv$iv instanceof SemanticsModifierNode) {
                        it$iv = it$iv$iv;
                        if (((SemanticsModifierNode) it$iv).getSemanticsConfiguration().isMergingSemanticsOfDescendants()) {
                            break;
                        }
                    }
                } else {
                    this_$iv = this_$iv2;
                }
                if ((it$iv$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv$iv) == 0) {
                    break;
                }
                node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild$ui_release();
                this_$iv2 = this_$iv;
            }
            return (SemanticsModifierNode) it$iv;
        }
        it$iv = null;
        return (SemanticsModifierNode) it$iv;
    }

    static /* synthetic */ List findOneLayerOfSemanticsWrappers$default(LayoutNode layoutNode, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return findOneLayerOfSemanticsWrappers(layoutNode, list);
    }

    private static final List<SemanticsModifierNode> findOneLayerOfSemanticsWrappers(LayoutNode $this$findOneLayerOfSemanticsWrappers, List<SemanticsModifierNode> list) {
        MutableVector this_$iv = $this$findOneLayerOfSemanticsWrappers.getZSortedChildren();
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                LayoutNode child = (LayoutNode) content$iv[i$iv];
                SemanticsModifierNode outerSemantics = getOuterSemantics(child);
                if (outerSemantics != null) {
                    list.add(outerSemantics);
                } else {
                    findOneLayerOfSemanticsWrappers(child, list);
                }
                i$iv++;
            } while (i$iv < size$iv);
        }
        return list;
    }

    public static final LayoutNode findClosestParentNode(LayoutNode $this$findClosestParentNode, Function1<? super LayoutNode, Boolean> selector) {
        Intrinsics.checkNotNullParameter($this$findClosestParentNode, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        for (LayoutNode currentParent = $this$findClosestParentNode.getParent$ui_release(); currentParent != null; currentParent = currentParent.getParent$ui_release()) {
            if (selector.invoke(currentParent).booleanValue()) {
                return currentParent;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final Role getRole(SemanticsNode $this$role) {
        return (Role) SemanticsConfigurationKt.getOrNull($this$role.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
    }

    /* access modifiers changed from: private */
    public static final int contentDescriptionFakeNodeId(SemanticsNode $this$contentDescriptionFakeNodeId) {
        return $this$contentDescriptionFakeNodeId.getId() + 2000000000;
    }

    /* access modifiers changed from: private */
    public static final int roleFakeNodeId(SemanticsNode $this$roleFakeNodeId) {
        return $this$roleFakeNodeId.getId() + 1000000000;
    }
}
