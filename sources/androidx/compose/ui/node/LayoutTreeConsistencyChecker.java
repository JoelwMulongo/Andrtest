package androidx.compose.ui.node;

import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\f\u0010\u0012\u001a\u00020\r*\u00020\u0003H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSet;", "postponedMeasureRequests", "", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/DepthSortedSet;Ljava/util/List;)V", "assertConsistent", "", "isTreeConsistent", "", "node", "logTree", "", "nodeToString", "consistentLayoutState", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutTreeConsistencyChecker.kt */
public final class LayoutTreeConsistencyChecker {
    private final List<MeasureAndLayoutDelegate.PostponedRequest> postponedMeasureRequests;
    private final DepthSortedSet relayoutNodes;
    private final LayoutNode root;

    public LayoutTreeConsistencyChecker(LayoutNode root2, DepthSortedSet relayoutNodes2, List<MeasureAndLayoutDelegate.PostponedRequest> postponedMeasureRequests2) {
        Intrinsics.checkNotNullParameter(root2, "root");
        Intrinsics.checkNotNullParameter(relayoutNodes2, "relayoutNodes");
        Intrinsics.checkNotNullParameter(postponedMeasureRequests2, "postponedMeasureRequests");
        this.root = root2;
        this.relayoutNodes = relayoutNodes2;
        this.postponedMeasureRequests = postponedMeasureRequests2;
    }

    public final void assertConsistent() {
        if (!isTreeConsistent(this.root)) {
            System.out.println(logTree());
            throw new IllegalStateException("Inconsistency found!");
        }
    }

    private final boolean isTreeConsistent(LayoutNode node) {
        if (!consistentLayoutState(node)) {
            return false;
        }
        List $this$fastForEach$iv = node.getChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            if (!isTreeConsistent($this$fastForEach$iv.get(index$iv))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0183, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3.getRoot(), (java.lang.Object) r1) != false) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        if ((r2 != null && r2.isPlaced()) != false) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0143, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3.getRoot(), (java.lang.Object) r1) != false) goto L_0x0148;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean consistentLayoutState(androidx.compose.ui.node.LayoutNode r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            androidx.compose.ui.node.LayoutNode r2 = r19.getParent$ui_release()
            if (r2 == 0) goto L_0x000f
            androidx.compose.ui.node.LayoutNode$LayoutState r4 = r2.getLayoutState$ui_release()
            goto L_0x0010
        L_0x000f:
            r4 = 0
        L_0x0010:
            boolean r5 = r19.isPlaced()
            r7 = 1
            if (r5 != 0) goto L_0x002d
            int r5 = r19.getPlaceOrder$ui_release()
            r8 = 2147483647(0x7fffffff, float:NaN)
            if (r5 == r8) goto L_0x00ba
            if (r2 == 0) goto L_0x002a
            boolean r5 = r2.isPlaced()
            if (r5 != r7) goto L_0x002a
            r5 = r7
            goto L_0x002b
        L_0x002a:
            r5 = 0
        L_0x002b:
            if (r5 == 0) goto L_0x00ba
        L_0x002d:
            boolean r5 = r19.getMeasurePending$ui_release()
            if (r5 == 0) goto L_0x006d
            java.util.List<androidx.compose.ui.node.MeasureAndLayoutDelegate$PostponedRequest> r5 = r0.postponedMeasureRequests
            r8 = 0
            r9 = r5
            r10 = 0
            r11 = 0
            int r12 = r9.size()
        L_0x0040:
            if (r11 >= r12) goto L_0x0068
            java.lang.Object r13 = r9.get(r11)
            r14 = r13
            r15 = 0
            r16 = r14
            androidx.compose.ui.node.MeasureAndLayoutDelegate$PostponedRequest r16 = (androidx.compose.ui.node.MeasureAndLayoutDelegate.PostponedRequest) r16
            r17 = 0
            androidx.compose.ui.node.LayoutNode r3 = r16.getNode()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r3 == 0) goto L_0x0060
            boolean r3 = r16.isLookahead()
            if (r3 != 0) goto L_0x0060
            r3 = r7
            goto L_0x0061
        L_0x0060:
            r3 = 0
        L_0x0061:
            if (r3 == 0) goto L_0x0064
            goto L_0x006a
        L_0x0064:
            int r11 = r11 + 1
            goto L_0x0040
        L_0x0068:
            r14 = 0
        L_0x006a:
            if (r14 == 0) goto L_0x006d
            return r7
        L_0x006d:
            boolean r3 = r19.getMeasurePending$ui_release()
            if (r3 == 0) goto L_0x0091
            androidx.compose.ui.node.DepthSortedSet r3 = r0.relayoutNodes
            boolean r3 = r3.contains(r1)
            if (r3 != 0) goto L_0x008f
            if (r2 == 0) goto L_0x0085
            boolean r3 = r2.getMeasurePending$ui_release()
            if (r3 != r7) goto L_0x0085
            r3 = r7
            goto L_0x0086
        L_0x0085:
            r3 = 0
        L_0x0086:
            if (r3 != 0) goto L_0x008f
            androidx.compose.ui.node.LayoutNode$LayoutState r3 = androidx.compose.ui.node.LayoutNode.LayoutState.Measuring
            if (r4 != r3) goto L_0x008d
            goto L_0x008f
        L_0x008d:
            r6 = 0
            goto L_0x0090
        L_0x008f:
            r6 = r7
        L_0x0090:
            return r6
        L_0x0091:
            boolean r3 = r19.getLayoutPending$ui_release()
            if (r3 == 0) goto L_0x00ba
            androidx.compose.ui.node.DepthSortedSet r3 = r0.relayoutNodes
            boolean r3 = r3.contains(r1)
            if (r3 != 0) goto L_0x00b8
            if (r2 == 0) goto L_0x00b8
            boolean r3 = r2.getMeasurePending$ui_release()
            if (r3 != 0) goto L_0x00b8
            boolean r3 = r2.getLayoutPending$ui_release()
            if (r3 != 0) goto L_0x00b8
            androidx.compose.ui.node.LayoutNode$LayoutState r3 = androidx.compose.ui.node.LayoutNode.LayoutState.Measuring
            if (r4 == r3) goto L_0x00b8
            androidx.compose.ui.node.LayoutNode$LayoutState r3 = androidx.compose.ui.node.LayoutNode.LayoutState.LayingOut
            if (r4 != r3) goto L_0x00b6
            goto L_0x00b8
        L_0x00b6:
            r6 = 0
            goto L_0x00b9
        L_0x00b8:
            r6 = r7
        L_0x00b9:
            return r6
        L_0x00ba:
            java.lang.Boolean r3 = r19.isPlacedInLookahead()
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r7)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x018a
            boolean r3 = r19.getLookaheadMeasurePending$ui_release()
            if (r3 == 0) goto L_0x0108
            java.util.List<androidx.compose.ui.node.MeasureAndLayoutDelegate$PostponedRequest> r3 = r0.postponedMeasureRequests
            r5 = 0
            r8 = r3
            r9 = 0
            r10 = 0
            int r11 = r8.size()
        L_0x00db:
            if (r10 >= r11) goto L_0x0103
            java.lang.Object r12 = r8.get(r10)
            r13 = r12
            r14 = 0
            r15 = r13
            androidx.compose.ui.node.MeasureAndLayoutDelegate$PostponedRequest r15 = (androidx.compose.ui.node.MeasureAndLayoutDelegate.PostponedRequest) r15
            r16 = 0
            androidx.compose.ui.node.LayoutNode r6 = r15.getNode()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            if (r6 == 0) goto L_0x00fa
            boolean r6 = r15.isLookahead()
            if (r6 == 0) goto L_0x00fa
            r6 = r7
            goto L_0x00fb
        L_0x00fa:
            r6 = 0
        L_0x00fb:
            if (r6 == 0) goto L_0x00ff
            r3 = r13
            goto L_0x0105
        L_0x00ff:
            int r10 = r10 + 1
            goto L_0x00db
        L_0x0103:
            r3 = 0
        L_0x0105:
            if (r3 == 0) goto L_0x0108
            return r7
        L_0x0108:
            boolean r3 = r19.getLookaheadMeasurePending$ui_release()
            if (r3 == 0) goto L_0x014a
            androidx.compose.ui.node.DepthSortedSet r3 = r0.relayoutNodes
            boolean r3 = r3.contains(r1)
            if (r3 != 0) goto L_0x0148
            if (r2 == 0) goto L_0x0120
            boolean r3 = r2.getLookaheadMeasurePending$ui_release()
            if (r3 != r7) goto L_0x0120
            r3 = r7
            goto L_0x0121
        L_0x0120:
            r3 = 0
        L_0x0121:
            if (r3 != 0) goto L_0x0148
            androidx.compose.ui.node.LayoutNode$LayoutState r3 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadMeasuring
            if (r4 == r3) goto L_0x0148
            if (r2 == 0) goto L_0x0131
            boolean r3 = r2.getMeasurePending$ui_release()
            if (r3 != r7) goto L_0x0131
            r3 = r7
            goto L_0x0132
        L_0x0131:
            r3 = 0
        L_0x0132:
            if (r3 == 0) goto L_0x0146
            androidx.compose.ui.layout.LookaheadScope r3 = r19.getMLookaheadScope$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            androidx.compose.ui.node.LayoutNode r3 = r3.getRoot()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r3 == 0) goto L_0x0146
            goto L_0x0148
        L_0x0146:
            r6 = 0
            goto L_0x0149
        L_0x0148:
            r6 = r7
        L_0x0149:
            return r6
        L_0x014a:
            boolean r3 = r19.getLookaheadLayoutPending$ui_release()
            if (r3 == 0) goto L_0x018a
            androidx.compose.ui.node.DepthSortedSet r3 = r0.relayoutNodes
            boolean r3 = r3.contains(r1)
            if (r3 != 0) goto L_0x0188
            if (r2 == 0) goto L_0x0188
            boolean r3 = r2.getLookaheadMeasurePending$ui_release()
            if (r3 != 0) goto L_0x0188
            boolean r3 = r2.getLookaheadLayoutPending$ui_release()
            if (r3 != 0) goto L_0x0188
            androidx.compose.ui.node.LayoutNode$LayoutState r3 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadMeasuring
            if (r4 == r3) goto L_0x0188
            androidx.compose.ui.node.LayoutNode$LayoutState r3 = androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadLayingOut
            if (r4 == r3) goto L_0x0188
            boolean r3 = r2.getLayoutPending$ui_release()
            if (r3 == 0) goto L_0x0186
            androidx.compose.ui.layout.LookaheadScope r3 = r19.getMLookaheadScope$ui_release()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            androidx.compose.ui.node.LayoutNode r3 = r3.getRoot()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r3 == 0) goto L_0x0186
            goto L_0x0188
        L_0x0186:
            r6 = 0
            goto L_0x0189
        L_0x0188:
            r6 = r7
        L_0x0189:
            return r6
        L_0x018a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutTreeConsistencyChecker.consistentLayoutState(androidx.compose.ui.node.LayoutNode):boolean");
    }

    private final String nodeToString(LayoutNode node) {
        StringBuilder $this$nodeToString_u24lambda_u243 = new StringBuilder();
        $this$nodeToString_u24lambda_u243.append(node);
        $this$nodeToString_u24lambda_u243.append(new StringBuilder().append('[').append(node.getLayoutState$ui_release()).append(']').toString());
        if (!node.isPlaced()) {
            $this$nodeToString_u24lambda_u243.append("[!isPlaced]");
        }
        $this$nodeToString_u24lambda_u243.append("[measuredByParent=" + node.getMeasuredByParent$ui_release() + ']');
        if (!consistentLayoutState(node)) {
            $this$nodeToString_u24lambda_u243.append("[INCONSISTENT]");
        }
        String sb = $this$nodeToString_u24lambda_u243.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "with(StringBuilder()) {\n…     toString()\n        }");
        return sb;
    }

    private final String logTree() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("Tree state:");
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append.append(10), "append('\\n')");
        logTree$printSubTree(this, stringBuilder, this.root, 0);
        String sb = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "stringBuilder.toString()");
        return sb;
    }

    private static final void logTree$printSubTree(LayoutTreeConsistencyChecker this$0, StringBuilder stringBuilder, LayoutNode node, int depth) {
        int childrenDepth = depth;
        String nodeRepresentation = this$0.nodeToString(node);
        if (nodeRepresentation.length() > 0) {
            for (int i = 0; i < depth; i++) {
                stringBuilder.append("..");
            }
            StringBuilder append = stringBuilder.append(nodeRepresentation);
            Intrinsics.checkNotNullExpressionValue(append, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append.append(10), "append('\\n')");
            childrenDepth++;
        }
        List $this$fastForEach$iv = node.getChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            logTree$printSubTree(this$0, stringBuilder, $this$fastForEach$iv.get(index$iv), childrenDepth);
        }
    }
}
