package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a8\u0010\u0005\u001a\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0006\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006*\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a6\u0010\u000f\u001a\u0004\u0018\u0001H\u0007\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0010*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0003*\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a%\u0010\u0013\u001a\u00020\u0014*\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0001*\u00020\bH\u0007\u001a2\u0010\u0018\u001a\u0004\u0018\u0001H\u0007\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0012\u001a\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0003*\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a2\u0010\u001a\u001a\u0004\u0018\u0001H\u0007\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0012\u001a\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u0003*\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a6\u0010\u001c\u001a\u0004\u0018\u0001H\u0007\"\n\b\u0000\u0010\u0007\u0018\u0001*\u00020\u0010*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0012\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0003*\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a%\u0010\u001e\u001a\u00020\u001f*\u00020\b2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\nH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001a\f\u0010#\u001a\u00020$*\u00020\bH\u0001\u001a\f\u0010%\u001a\u00020&*\u00020\bH\u0001\u001aG\u0010'\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00010)H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+\u001a,\u0010'\u001a\u00020\u0001*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010)H\bø\u0001\u0002\u001aG\u0010,\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00010)H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010+\u001a,\u0010,\u001a\u00020\u0001*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010)H\bø\u0001\u0002\u001aG\u0010.\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00010)H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010+\u001a,\u0010.\u001a\u00020\u0001*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010)H\bø\u0001\u0002\u001aG\u00100\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00010)H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010+\u001a,\u00100\u001a\u00020\u0001*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010)H\bø\u0001\u0002\u001aG\u00102\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00010)H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u0010+\u001a,\u00102\u001a\u00020\u0001*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010)H\bø\u0001\u0002\u001aG\u00104\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0007\u0018\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00140)H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u0010+\u001a,\u00104\u001a\u00020\u0001*\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140)H\bø\u0001\u0002\u0002\u0012\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b20\u0001¨\u00066"}, d2 = {"addLayoutNodeChildren", "", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Node;", "node", "ancestors", "", "T", "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "ancestors-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/util/List;", "mask", "", "firstChild", "", "firstChild-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "has", "", "has-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Z", "invalidateSubtree", "localChild", "localChild-64DMado", "localParent", "localParent-64DMado", "nearestAncestor", "nearestAncestor-64DMado", "requireCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "kind", "requireCoordinator-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Landroidx/compose/ui/node/NodeCoordinator;", "requireLayoutNode", "Landroidx/compose/ui/node/LayoutNode;", "requireOwner", "Landroidx/compose/ui/node/Owner;", "visitAncestors", "block", "Lkotlin/Function1;", "visitAncestors-6rFNWt0", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;)V", "visitChildren", "visitChildren-6rFNWt0", "visitLocalChildren", "visitLocalChildren-6rFNWt0", "visitLocalParents", "visitLocalParents-6rFNWt0", "visitSubtree", "visitSubtree-6rFNWt0", "visitSubtreeIf", "visitSubtreeIf-6rFNWt0", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DelegatableNode.kt */
public final class DelegatableNodeKt {
    public static final Modifier.Node localChild(DelegatableNode $this$localChild, int mask) {
        Intrinsics.checkNotNullParameter($this$localChild, "<this>");
        Modifier.Node child = $this$localChild.getNode().getChild$ui_release();
        if (child == null || (child.getAggregateChildKindSet$ui_release() & mask) == 0) {
            return null;
        }
        for (Modifier.Node next = child; next != null; next = next.getChild$ui_release()) {
            if ((next.getKindSet$ui_release() & mask) != 0) {
                return next;
            }
        }
        return null;
    }

    public static final Modifier.Node localParent(DelegatableNode $this$localParent, int mask) {
        Intrinsics.checkNotNullParameter($this$localParent, "<this>");
        for (Modifier.Node next = $this$localParent.getNode().getParent$ui_release(); next != null; next = next.getParent$ui_release()) {
            if ((next.getKindSet$ui_release() & mask) != 0) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0049, code lost:
        r4 = r2.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void visitAncestors(androidx.compose.ui.node.DelegatableNode r5, int r6, kotlin.jvm.functions.Function1<? super androidx.compose.ui.Modifier.Node, kotlin.Unit> r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            androidx.compose.ui.Modifier$Node r1 = r5.getNode()
            boolean r1 = r1.isAttached()
            if (r1 == 0) goto L_0x0058
            androidx.compose.ui.Modifier$Node r1 = r5.getNode()
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r2 = requireLayoutNode(r5)
        L_0x0021:
            if (r2 == 0) goto L_0x0057
            androidx.compose.ui.node.NodeChain r3 = r2.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r3 = r3.getHead$ui_release()
            int r4 = r3.getAggregateChildKindSet$ui_release()
            r4 = r4 & r6
            if (r4 == 0) goto L_0x0043
        L_0x0032:
            if (r1 == 0) goto L_0x0043
            int r4 = r1.getKindSet$ui_release()
            r4 = r4 & r6
            if (r4 == 0) goto L_0x003e
            r7.invoke(r1)
        L_0x003e:
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            goto L_0x0032
        L_0x0043:
            androidx.compose.ui.node.LayoutNode r2 = r2.getParent$ui_release()
            if (r2 == 0) goto L_0x0054
            androidx.compose.ui.node.NodeChain r4 = r2.getNodes$ui_release()
            if (r4 == 0) goto L_0x0054
            androidx.compose.ui.Modifier$Node r4 = r4.getTail$ui_release()
            goto L_0x0055
        L_0x0054:
            r4 = 0
        L_0x0055:
            r1 = r4
            goto L_0x0021
        L_0x0057:
            return
        L_0x0058:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Check failed."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.DelegatableNodeKt.visitAncestors(androidx.compose.ui.node.DelegatableNode, int, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
        r4 = r2.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<androidx.compose.ui.Modifier.Node> ancestors(androidx.compose.ui.node.DelegatableNode r5, int r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            androidx.compose.ui.Modifier$Node r0 = r5.getNode()
            boolean r0 = r0.isAttached()
            if (r0 == 0) goto L_0x0060
            r0 = 0
            androidx.compose.ui.Modifier$Node r1 = r5.getNode()
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r2 = requireLayoutNode(r5)
        L_0x001c:
            if (r2 == 0) goto L_0x005f
            androidx.compose.ui.node.NodeChain r3 = r2.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r3 = r3.getHead$ui_release()
            int r4 = r3.getAggregateChildKindSet$ui_release()
            r4 = r4 & r6
            if (r4 == 0) goto L_0x004b
        L_0x002d:
            if (r1 == 0) goto L_0x004b
            int r4 = r1.getKindSet$ui_release()
            r4 = r4 & r6
            if (r4 == 0) goto L_0x0046
            if (r0 != 0) goto L_0x0040
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r0 = r4
            java.util.List r0 = (java.util.List) r0
        L_0x0040:
            r4 = r0
            java.util.Collection r4 = (java.util.Collection) r4
            r4.add(r1)
        L_0x0046:
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            goto L_0x002d
        L_0x004b:
            androidx.compose.ui.node.LayoutNode r2 = r2.getParent$ui_release()
            if (r2 == 0) goto L_0x005c
            androidx.compose.ui.node.NodeChain r4 = r2.getNodes$ui_release()
            if (r4 == 0) goto L_0x005c
            androidx.compose.ui.Modifier$Node r4 = r4.getTail$ui_release()
            goto L_0x005d
        L_0x005c:
            r4 = 0
        L_0x005d:
            r1 = r4
            goto L_0x001c
        L_0x005f:
            return r0
        L_0x0060:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Check failed."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.DelegatableNodeKt.ancestors(androidx.compose.ui.node.DelegatableNode, int):java.util.List");
    }

    public static final Modifier.Node nearestAncestor(DelegatableNode $this$nearestAncestor, int mask) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter($this$nearestAncestor, "<this>");
        if ($this$nearestAncestor.getNode().isAttached()) {
            Modifier.Node node = $this$nearestAncestor.getNode().getParent$ui_release();
            LayoutNode layout = requireLayoutNode($this$nearestAncestor);
            while (true) {
                Modifier.Node node2 = null;
                if (layout == null) {
                    return null;
                }
                if ((layout.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask) != 0) {
                    while (node != null) {
                        if ((node.getKindSet$ui_release() & mask) != 0) {
                            return node;
                        }
                        node = node.getParent$ui_release();
                    }
                }
                layout = layout.getParent$ui_release();
                if (!(layout == null || (nodes$ui_release = layout.getNodes$ui_release()) == null)) {
                    node2 = nodes$ui_release.getTail$ui_release();
                }
                node = node2;
            }
        } else {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public static final Modifier.Node firstChild(DelegatableNode $this$firstChild, int mask) {
        Intrinsics.checkNotNullParameter($this$firstChild, "<this>");
        if ($this$firstChild.getNode().isAttached()) {
            MutableVector branches = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child = $this$firstChild.getNode().getChild$ui_release();
            if (child == null) {
                addLayoutNodeChildren(branches, $this$firstChild.getNode());
            } else {
                branches.add(child);
            }
            while (branches.isNotEmpty()) {
                Modifier.Node branch = (Modifier.Node) branches.removeAt(branches.getSize() - 1);
                if ((branch.getAggregateChildKindSet$ui_release() & mask) == 0) {
                    addLayoutNodeChildren(branches, branch);
                } else {
                    for (Modifier.Node node = branch; node != null; node = node.getChild$ui_release()) {
                        if ((node.getKindSet$ui_release() & mask) != 0) {
                            return node;
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final void visitSubtree(DelegatableNode $this$visitSubtree, int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter($this$visitSubtree, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if ($this$visitSubtree.getNode().isAttached()) {
            Modifier.Node node = $this$visitSubtree.getNode().getChild$ui_release();
            NestedVectorStack nodes = new NestedVectorStack();
            for (LayoutNode layout = requireLayoutNode($this$visitSubtree); layout != null; layout = nodes.isNotEmpty() ? (LayoutNode) nodes.pop() : null) {
                node = node == null ? layout.getNodes$ui_release().getHead$ui_release() : node;
                if ((node.getAggregateChildKindSet$ui_release() & mask) != 0) {
                    while (node != null) {
                        if ((node.getKindSet$ui_release() & mask) != 0) {
                            block.invoke(node);
                        }
                        node = node.getChild$ui_release();
                    }
                    node = null;
                }
                nodes.push(layout.get_children$ui_release());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* access modifiers changed from: private */
    public static final void addLayoutNodeChildren(MutableVector<Modifier.Node> $this$addLayoutNodeChildren, Modifier.Node node) {
        MutableVector this_$iv = requireLayoutNode(node).get_children$ui_release();
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = size$iv - 1;
            Object[] content$iv = this_$iv.getContent();
            do {
                $this$addLayoutNodeChildren.add(((LayoutNode) content$iv[i$iv]).getNodes$ui_release().getHead$ui_release());
                i$iv--;
            } while (i$iv >= 0);
        }
    }

    public static final void visitChildren(DelegatableNode $this$visitChildren, int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter($this$visitChildren, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if ($this$visitChildren.getNode().isAttached()) {
            MutableVector branches = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child = $this$visitChildren.getNode().getChild$ui_release();
            if (child == null) {
                addLayoutNodeChildren(branches, $this$visitChildren.getNode());
            } else {
                branches.add(child);
            }
            while (branches.isNotEmpty()) {
                Modifier.Node branch = (Modifier.Node) branches.removeAt(branches.getSize() - 1);
                if ((branch.getAggregateChildKindSet$ui_release() & mask) == 0) {
                    addLayoutNodeChildren(branches, branch);
                } else {
                    Modifier.Node node = branch;
                    while (true) {
                        if (node == null) {
                            break;
                        } else if ((node.getKindSet$ui_release() & mask) != 0) {
                            block.invoke(node);
                            break;
                        } else {
                            node = node.getChild$ui_release();
                        }
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final void visitSubtreeIf(DelegatableNode $this$visitSubtreeIf, int mask, Function1<? super Modifier.Node, Boolean> block) {
        Intrinsics.checkNotNullParameter($this$visitSubtreeIf, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if ($this$visitSubtreeIf.getNode().isAttached()) {
            MutableVector branches = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child = $this$visitSubtreeIf.getNode().getChild$ui_release();
            if (child == null) {
                addLayoutNodeChildren(branches, $this$visitSubtreeIf.getNode());
            } else {
                branches.add(child);
            }
            while (branches.isNotEmpty()) {
                Modifier.Node branch = (Modifier.Node) branches.removeAt(branches.getSize() - 1);
                if ((branch.getAggregateChildKindSet$ui_release() & mask) != 0) {
                    Modifier.Node node = branch;
                    while (true) {
                        if (node != null) {
                            if ((node.getKindSet$ui_release() & mask) != 0 && !block.invoke(node).booleanValue()) {
                                break;
                            }
                            node = node.getChild$ui_release();
                        } else {
                            break;
                        }
                    }
                }
                addLayoutNodeChildren(branches, branch);
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final void visitLocalChildren(DelegatableNode $this$visitLocalChildren, int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter($this$visitLocalChildren, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if ($this$visitLocalChildren.getNode().isAttached()) {
            Modifier.Node self = $this$visitLocalChildren.getNode();
            if ((self.getAggregateChildKindSet$ui_release() & mask) != 0) {
                for (Modifier.Node next = self.getChild$ui_release(); next != null; next = next.getChild$ui_release()) {
                    if ((next.getKindSet$ui_release() & mask) != 0) {
                        block.invoke(next);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final void visitLocalParents(DelegatableNode $this$visitLocalParents, int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter($this$visitLocalParents, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if ($this$visitLocalParents.getNode().isAttached()) {
            for (Modifier.Node next = $this$visitLocalParents.getNode().getParent$ui_release(); next != null; next = next.getParent$ui_release()) {
                if ((next.getKindSet$ui_release() & mask) != 0) {
                    block.invoke(next);
                }
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: visitLocalChildren-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m4968visitLocalChildren6rFNWt0(DelegatableNode $this$visitLocalChildren_u2d6rFNWt0, int type, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter($this$visitLocalChildren_u2d6rFNWt0, "$this$visitLocalChildren");
        Intrinsics.checkNotNullParameter(block, "block");
        int mask$iv = type;
        DelegatableNode $this$visitLocalChildren$iv = $this$visitLocalChildren_u2d6rFNWt0;
        if ($this$visitLocalChildren$iv.getNode().isAttached()) {
            Modifier.Node self$iv = $this$visitLocalChildren$iv.getNode();
            if ((self$iv.getAggregateChildKindSet$ui_release() & mask$iv) != 0) {
                for (Modifier.Node next$iv = self$iv.getChild$ui_release(); next$iv != null; next$iv = next$iv.getChild$ui_release()) {
                    if ((next$iv.getKindSet$ui_release() & mask$iv) != 0) {
                        Modifier.Node it = next$iv;
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (it instanceof Object) {
                            block.invoke(it);
                        }
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: visitLocalParents-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m4969visitLocalParents6rFNWt0(DelegatableNode $this$visitLocalParents_u2d6rFNWt0, int type, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter($this$visitLocalParents_u2d6rFNWt0, "$this$visitLocalParents");
        Intrinsics.checkNotNullParameter(block, "block");
        int mask$iv = type;
        DelegatableNode $this$visitLocalParents$iv = $this$visitLocalParents_u2d6rFNWt0;
        if ($this$visitLocalParents$iv.getNode().isAttached()) {
            for (Modifier.Node next$iv = $this$visitLocalParents$iv.getNode().getParent$ui_release(); next$iv != null; next$iv = next$iv.getParent$ui_release()) {
                if ((next$iv.getKindSet$ui_release() & mask$iv) != 0) {
                    Modifier.Node it = next$iv;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (it instanceof Object) {
                        block.invoke(it);
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: localParent-64DMado  reason: not valid java name */
    public static final /* synthetic */ <T> T m4963localParent64DMado(DelegatableNode $this$localParent_u2d64DMado, int type) {
        Intrinsics.checkNotNullParameter($this$localParent_u2d64DMado, "$this$localParent");
        T localParent = localParent($this$localParent_u2d64DMado, type);
        Intrinsics.reifiedOperationMarker(2, "T");
        return (Object) localParent;
    }

    /* renamed from: localChild-64DMado  reason: not valid java name */
    public static final /* synthetic */ <T> T m4962localChild64DMado(DelegatableNode $this$localChild_u2d64DMado, int type) {
        Intrinsics.checkNotNullParameter($this$localChild_u2d64DMado, "$this$localChild");
        T localChild = localChild($this$localChild_u2d64DMado, type);
        Intrinsics.reifiedOperationMarker(2, "T");
        return (Object) localChild;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
        r7 = r5.getNodes$ui_release();
     */
    /* renamed from: visitAncestors-6rFNWt0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ <T> void m4966visitAncestors6rFNWt0(androidx.compose.ui.node.DelegatableNode r11, int r12, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r13) {
        /*
            java.lang.String r0 = "$this$visitAncestors"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = 0
            r1 = r12
            r2 = r11
            r3 = 0
            androidx.compose.ui.Modifier$Node r4 = r2.getNode()
            boolean r4 = r4.isAttached()
            if (r4 == 0) goto L_0x006b
            androidx.compose.ui.Modifier$Node r4 = r2.getNode()
            androidx.compose.ui.Modifier$Node r4 = r4.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r5 = requireLayoutNode(r2)
        L_0x0024:
            if (r5 == 0) goto L_0x0069
            androidx.compose.ui.node.NodeChain r6 = r5.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r6 = r6.getHead$ui_release()
            int r7 = r6.getAggregateChildKindSet$ui_release()
            r7 = r7 & r1
            if (r7 == 0) goto L_0x0055
        L_0x0035:
            if (r4 == 0) goto L_0x0055
            int r7 = r4.getKindSet$ui_release()
            r7 = r7 & r1
            if (r7 == 0) goto L_0x0050
            r7 = r4
            androidx.compose.ui.Modifier$Node r7 = (androidx.compose.ui.Modifier.Node) r7
            r8 = 0
            r9 = 3
            java.lang.String r10 = "T"
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r9, r10)
            boolean r9 = r7 instanceof java.lang.Object
            if (r9 == 0) goto L_0x004f
            r13.invoke(r7)
        L_0x004f:
        L_0x0050:
            androidx.compose.ui.Modifier$Node r4 = r4.getParent$ui_release()
            goto L_0x0035
        L_0x0055:
            androidx.compose.ui.node.LayoutNode r5 = r5.getParent$ui_release()
            if (r5 == 0) goto L_0x0066
            androidx.compose.ui.node.NodeChain r7 = r5.getNodes$ui_release()
            if (r7 == 0) goto L_0x0066
            androidx.compose.ui.Modifier$Node r7 = r7.getTail$ui_release()
            goto L_0x0067
        L_0x0066:
            r7 = 0
        L_0x0067:
            r4 = r7
            goto L_0x0024
        L_0x0069:
            return
        L_0x006b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Check failed."
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.DelegatableNodeKt.m4966visitAncestors6rFNWt0(androidx.compose.ui.node.DelegatableNode, int, kotlin.jvm.functions.Function1):void");
    }

    /* renamed from: ancestors-64DMado  reason: not valid java name */
    public static final /* synthetic */ <T> List<T> m4959ancestors64DMado(DelegatableNode $this$ancestors_u2d64DMado, int type) {
        Intrinsics.checkNotNullParameter($this$ancestors_u2d64DMado, "$this$ancestors");
        List<Modifier.Node> ancestors = ancestors($this$ancestors_u2d64DMado, type);
        if (ancestors instanceof List) {
            return ancestors;
        }
        return null;
    }

    /* renamed from: nearestAncestor-64DMado  reason: not valid java name */
    public static final /* synthetic */ <T> T m4964nearestAncestor64DMado(DelegatableNode $this$nearestAncestor_u2d64DMado, int type) {
        Intrinsics.checkNotNullParameter($this$nearestAncestor_u2d64DMado, "$this$nearestAncestor");
        T nearestAncestor = nearestAncestor($this$nearestAncestor_u2d64DMado, type);
        Intrinsics.reifiedOperationMarker(2, "T");
        return (Object) nearestAncestor;
    }

    /* renamed from: firstChild-64DMado  reason: not valid java name */
    public static final /* synthetic */ <T> T m4960firstChild64DMado(DelegatableNode $this$firstChild_u2d64DMado, int type) {
        Intrinsics.checkNotNullParameter($this$firstChild_u2d64DMado, "$this$firstChild");
        T firstChild = firstChild($this$firstChild_u2d64DMado, type);
        Intrinsics.reifiedOperationMarker(2, "T");
        return (Object) firstChild;
    }

    /* renamed from: visitSubtree-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m4970visitSubtree6rFNWt0(DelegatableNode $this$visitSubtree_u2d6rFNWt0, int type, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter($this$visitSubtree_u2d6rFNWt0, "$this$visitSubtree");
        Intrinsics.checkNotNullParameter(block, "block");
        int mask$iv = type;
        DelegatableNode $this$visitSubtree$iv = $this$visitSubtree_u2d6rFNWt0;
        if ($this$visitSubtree$iv.getNode().isAttached()) {
            Modifier.Node node$iv = $this$visitSubtree$iv.getNode().getChild$ui_release();
            NestedVectorStack nodes$iv = new NestedVectorStack();
            for (LayoutNode layout$iv = requireLayoutNode($this$visitSubtree$iv); layout$iv != null; layout$iv = nodes$iv.isNotEmpty() ? (LayoutNode) nodes$iv.pop() : null) {
                node$iv = node$iv == null ? layout$iv.getNodes$ui_release().getHead$ui_release() : node$iv;
                if ((node$iv.getAggregateChildKindSet$ui_release() & mask$iv) != 0) {
                    while (node$iv != null) {
                        if ((node$iv.getKindSet$ui_release() & mask$iv) != 0) {
                            Modifier.Node it = node$iv;
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if (it instanceof Object) {
                                block.invoke(it);
                            }
                        }
                        node$iv = node$iv.getChild$ui_release();
                    }
                    node$iv = null;
                }
                nodes$iv.push(layout$iv.get_children$ui_release());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: visitChildren-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m4967visitChildren6rFNWt0(DelegatableNode $this$visitChildren_u2d6rFNWt0, int type, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter($this$visitChildren_u2d6rFNWt0, "$this$visitChildren");
        Intrinsics.checkNotNullParameter(block, "block");
        int mask$iv = type;
        DelegatableNode $this$visitChildren$iv = $this$visitChildren_u2d6rFNWt0;
        if ($this$visitChildren$iv.getNode().isAttached()) {
            MutableVector branches$iv = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$iv = $this$visitChildren$iv.getNode().getChild$ui_release();
            if (child$iv == null) {
                addLayoutNodeChildren(branches$iv, $this$visitChildren$iv.getNode());
            } else {
                branches$iv.add(child$iv);
            }
            while (branches$iv.isNotEmpty()) {
                Modifier.Node branch$iv = (Modifier.Node) branches$iv.removeAt(branches$iv.getSize() - 1);
                if ((branch$iv.getAggregateChildKindSet$ui_release() & mask$iv) == 0) {
                    addLayoutNodeChildren(branches$iv, branch$iv);
                } else {
                    Modifier.Node node$iv = branch$iv;
                    while (true) {
                        if (node$iv == null) {
                            break;
                        } else if ((node$iv.getKindSet$ui_release() & mask$iv) != 0) {
                            Modifier.Node it = node$iv;
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if (it instanceof Object) {
                                block.invoke(it);
                            }
                        } else {
                            node$iv = node$iv.getChild$ui_release();
                        }
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: visitSubtreeIf-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m4971visitSubtreeIf6rFNWt0(DelegatableNode $this$visitSubtreeIf_u2d6rFNWt0, int type, Function1<? super T, Boolean> block) {
        Intrinsics.checkNotNullParameter($this$visitSubtreeIf_u2d6rFNWt0, "$this$visitSubtreeIf");
        Intrinsics.checkNotNullParameter(block, "block");
        int mask$iv = type;
        DelegatableNode $this$visitSubtreeIf$iv = $this$visitSubtreeIf_u2d6rFNWt0;
        if ($this$visitSubtreeIf$iv.getNode().isAttached()) {
            MutableVector branches$iv = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$iv = $this$visitSubtreeIf$iv.getNode().getChild$ui_release();
            if (child$iv == null) {
                addLayoutNodeChildren(branches$iv, $this$visitSubtreeIf$iv.getNode());
            } else {
                branches$iv.add(child$iv);
            }
            while (branches$iv.isNotEmpty()) {
                Modifier.Node branch$iv = (Modifier.Node) branches$iv.removeAt(branches$iv.getSize() - 1);
                if ((branch$iv.getAggregateChildKindSet$ui_release() & mask$iv) != 0) {
                    Modifier.Node node$iv = branch$iv;
                    while (true) {
                        if (node$iv == null) {
                            break;
                        }
                        if ((node$iv.getKindSet$ui_release() & mask$iv) != 0) {
                            Modifier.Node it = node$iv;
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if (!(it instanceof Object ? block.invoke(it).booleanValue() : true)) {
                                break;
                            }
                        }
                        node$iv = node$iv.getChild$ui_release();
                    }
                }
                addLayoutNodeChildren(branches$iv, branch$iv);
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: has-64DMado  reason: not valid java name */
    public static final boolean m4961has64DMado(DelegatableNode $this$has_u2d64DMado, int type) {
        Intrinsics.checkNotNullParameter($this$has_u2d64DMado, "$this$has");
        return ($this$has_u2d64DMado.getNode().getAggregateChildKindSet$ui_release() & type) != 0;
    }

    /* renamed from: requireCoordinator-64DMado  reason: not valid java name */
    public static final NodeCoordinator m4965requireCoordinator64DMado(DelegatableNode $this$requireCoordinator_u2d64DMado, int kind) {
        Intrinsics.checkNotNullParameter($this$requireCoordinator_u2d64DMado, "$this$requireCoordinator");
        NodeCoordinator coordinator = $this$requireCoordinator_u2d64DMado.getNode().getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator);
        if (coordinator.getTail() != $this$requireCoordinator_u2d64DMado || !NodeKindKt.m5131getIncludeSelfInTraversalH91voCI(kind)) {
            return coordinator;
        }
        NodeCoordinator wrapped$ui_release = coordinator.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        return wrapped$ui_release;
    }

    public static final LayoutNode requireLayoutNode(DelegatableNode $this$requireLayoutNode) {
        Intrinsics.checkNotNullParameter($this$requireLayoutNode, "<this>");
        NodeCoordinator coordinator$ui_release = $this$requireLayoutNode.getNode().getCoordinator$ui_release();
        if (coordinator$ui_release != null) {
            return coordinator$ui_release.getLayoutNode();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final Owner requireOwner(DelegatableNode $this$requireOwner) {
        Intrinsics.checkNotNullParameter($this$requireOwner, "<this>");
        Owner owner$ui_release = requireLayoutNode($this$requireOwner).getOwner$ui_release();
        if (owner$ui_release != null) {
            return owner$ui_release;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final void invalidateSubtree(DelegatableNode $this$invalidateSubtree) {
        Intrinsics.checkNotNullParameter($this$invalidateSubtree, "<this>");
        if ($this$invalidateSubtree.getNode().isAttached()) {
            LayoutNode.invalidateSubtree$default(requireLayoutNode($this$invalidateSubtree), false, 1, (Object) null);
        }
    }
}
