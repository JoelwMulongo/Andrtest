package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ModifierInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0002deB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0019J\u0018\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u0010H\u0002J\r\u0010+\u001a\u00020&H\u0000¢\u0006\u0002\b,J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0010H\u0002JE\u0010/\u001a\u0004\u0018\u0001H0\"\u0006\b\u0000\u00100\u0018\u00012\f\u00101\u001a\b\u0012\u0004\u0012\u0002H0022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020\u001904H\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b5\u00106J0\u00107\u001a\u00060\rR\u00020\u00002\u0006\u0010#\u001a\u00020\u00102\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;J!\u0010=\u001a\u00020\u00192\n\u00101\u001a\u0006\u0012\u0002\b\u000302H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b>\u0010?J\u0015\u0010=\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u0006H\u0000¢\u0006\u0002\bAJ.\u0010\u0011\u001a\u0004\u0018\u0001H0\"\u0006\b\u0000\u00100\u0018\u00012\f\u00101\u001a\b\u0012\u0004\u0012\u0002H002H\bø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bB\u0010CJ%\u0010D\u001a\u00020&2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020&04H\bø\u0001\u0000¢\u0006\u0002\bEJC\u0010D\u001a\u00020&\"\u0006\b\u0000\u00100\u0018\u00012\f\u00101\u001a\b\u0012\u0004\u0012\u0002H0022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020&04H\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bF\u0010GJ-\u0010D\u001a\u00020&2\u0006\u0010@\u001a\u00020\u00062\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020&04H\bø\u0001\u0000¢\u0006\u0002\bEJ%\u0010H\u001a\u00020&2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020&04H\bø\u0001\u0000¢\u0006\u0002\bIJ\u0018\u0010J\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010H\u0002J\b\u0010K\u001a\u00020&H\u0002J\u0010\u0010L\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0010H\u0002J\u0018\u0010M\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\u00102\u0006\u0010O\u001a\u00020\u0010H\u0002J\r\u0010P\u001a\u00020&H\u0000¢\u0006\u0002\bQJ<\u0010R\u001a\u00020&2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010S\u001a\u00020\u00062\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010T\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0010H\u0002J\b\u0010U\u001a\u00020&H\u0002J.\u0010#\u001a\u0004\u0018\u0001H0\"\u0006\b\u0000\u00100\u0018\u00012\f\u00101\u001a\b\u0012\u0004\u0012\u0002H002H\bø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bV\u0010CJ%\u0010W\u001a\u00020&2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020&04H\bø\u0001\u0000¢\u0006\u0002\bXJC\u0010W\u001a\u00020&\"\u0006\b\u0000\u00100\u0018\u00012\f\u00101\u001a\b\u0012\u0004\u0012\u0002H0022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020&04H\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bY\u0010GJ-\u0010W\u001a\u00020&2\u0006\u0010@\u001a\u00020\u00062\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020&04H\bø\u0001\u0000¢\u0006\u0002\bXJ\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020&H\u0002J\u0015\u0010]\u001a\u00020&2\u0006\u0010^\u001a\u00020_H\u0000¢\u0006\u0002\b`J \u0010a\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0010H\u0002J\u0017\u0010b\u001a\u00020&2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0002\bcR\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0018\u00010\rR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u001f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006f"}, d2 = {"Landroidx/compose/ui/node/NodeChain;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "aggregateChildKindSet", "", "getAggregateChildKindSet", "()I", "buffer", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "cachedDiffer", "Landroidx/compose/ui/node/NodeChain$Differ;", "current", "<set-?>", "Landroidx/compose/ui/Modifier$Node;", "head", "getHead$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "innerCoordinator", "Landroidx/compose/ui/node/InnerNodeCoordinator;", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/InnerNodeCoordinator;", "isUpdating", "", "()Z", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "logger", "Landroidx/compose/ui/node/NodeChain$Logger;", "Landroidx/compose/ui/node/NodeCoordinator;", "outerCoordinator", "getOuterCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "tail", "getTail$ui_release", "attach", "", "performInvalidations", "createAndInsertNodeAsParent", "element", "child", "detach", "detach$ui_release", "detachAndRemoveNode", "node", "firstFromHead", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "block", "Lkotlin/Function1;", "firstFromHead-aLcG6gQ$ui_release", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getDiffer", "before", "after", "getModifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "has", "has-H91voCI$ui_release", "(I)Z", "mask", "has$ui_release", "head-H91voCI$ui_release", "(I)Ljava/lang/Object;", "headToTail", "headToTail$ui_release", "headToTail-aLcG6gQ$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "headToTailExclusive", "headToTailExclusive$ui_release", "insertParent", "padChain", "removeNode", "replaceNode", "prev", "next", "resetState", "resetState$ui_release", "structuralUpdate", "beforeSize", "afterSize", "syncCoordinators", "tail-H91voCI$ui_release", "tailToHead", "tailToHead$ui_release", "tailToHead-aLcG6gQ$ui_release", "toString", "", "trimChain", "updateFrom", "m", "Landroidx/compose/ui/Modifier;", "updateFrom$ui_release", "updateNodeAndReplaceIfNeeded", "useLogger", "useLogger$ui_release", "Differ", "Logger", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeChain.kt */
public final class NodeChain {
    private MutableVector<Modifier.Element> buffer;
    private Differ cachedDiffer;
    private MutableVector<Modifier.Element> current;
    private Modifier.Node head;
    private final InnerNodeCoordinator innerCoordinator;
    private final LayoutNode layoutNode;
    /* access modifiers changed from: private */
    public Logger logger;
    private NodeCoordinator outerCoordinator;
    private final Modifier.Node tail;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J8\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeChain$Logger;", "", "linearDiffAborted", "", "index", "", "prev", "Landroidx/compose/ui/Modifier$Element;", "next", "node", "Landroidx/compose/ui/Modifier$Node;", "nodeInserted", "atIndex", "newIndex", "element", "child", "inserted", "nodeRemoved", "oldIndex", "nodeReused", "nodeUpdated", "before", "after", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NodeChain.kt */
    public interface Logger {
        void linearDiffAborted(int i, Modifier.Element element, Modifier.Element element2, Modifier.Node node);

        void nodeInserted(int i, int i2, Modifier.Element element, Modifier.Node node, Modifier.Node node2);

        void nodeRemoved(int i, Modifier.Element element, Modifier.Node node);

        void nodeReused(int i, int i2, Modifier.Element element, Modifier.Element element2, Modifier.Node node);

        void nodeUpdated(int i, int i2, Modifier.Element element, Modifier.Element element2, Modifier.Node node, Modifier.Node node2);
    }

    public NodeChain(LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        this.layoutNode = layoutNode2;
        InnerNodeCoordinator innerNodeCoordinator = new InnerNodeCoordinator(layoutNode2);
        this.innerCoordinator = innerNodeCoordinator;
        this.outerCoordinator = innerNodeCoordinator;
        Modifier.Node tail2 = innerNodeCoordinator.getTail();
        this.tail = tail2;
        this.head = tail2;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public final InnerNodeCoordinator getInnerCoordinator$ui_release() {
        return this.innerCoordinator;
    }

    public final NodeCoordinator getOuterCoordinator$ui_release() {
        return this.outerCoordinator;
    }

    public final Modifier.Node getTail$ui_release() {
        return this.tail;
    }

    public final Modifier.Node getHead$ui_release() {
        return this.head;
    }

    private final boolean isUpdating() {
        return this.head == NodeChainKt.SentinelHead;
    }

    /* access modifiers changed from: private */
    public final int getAggregateChildKindSet() {
        return this.head.getAggregateChildKindSet$ui_release();
    }

    public final void useLogger$ui_release(Logger logger2) {
        this.logger = logger2;
    }

    private final void padChain() {
        if (this.head != NodeChainKt.SentinelHead) {
            Modifier.Node currentHead = this.head;
            currentHead.setParent$ui_release(NodeChainKt.SentinelHead);
            NodeChainKt.SentinelHead.setChild$ui_release(currentHead);
            this.head = NodeChainKt.SentinelHead;
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final void trimChain() {
        boolean z = true;
        if (this.head == NodeChainKt.SentinelHead) {
            Modifier.Node child$ui_release = NodeChainKt.SentinelHead.getChild$ui_release();
            if (child$ui_release == null) {
                child$ui_release = this.tail;
            }
            this.head = child$ui_release;
            child$ui_release.setParent$ui_release((Modifier.Node) null);
            NodeChainKt.SentinelHead.setChild$ui_release((Modifier.Node) null);
            if (this.head == NodeChainKt.SentinelHead) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c7, code lost:
        if (r2.isAttached() != false) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c9, code lost:
        r0 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateFrom$ui_release(androidx.compose.ui.Modifier r23) {
        /*
            r22 = this;
            r6 = r22
            r7 = r23
            java.lang.String r0 = "m"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            r1 = 0
            r22.padChain()
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.Modifier$Element> r2 = r6.current
            r3 = 0
            if (r2 != 0) goto L_0x001e
            r2 = 0
            r4 = 0
            androidx.compose.runtime.collection.MutableVector r5 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Element[] r8 = new androidx.compose.ui.Modifier.Element[r2]
            r5.<init>(r8, r3)
            r2 = r5
        L_0x001e:
            r8 = r2
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.Modifier$Element> r2 = r6.buffer
            if (r2 != 0) goto L_0x0030
            r2 = 0
            r4 = 16
            r5 = 0
            androidx.compose.runtime.collection.MutableVector r9 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Element[] r10 = new androidx.compose.ui.Modifier.Element[r4]
            r9.<init>(r10, r3)
            r2 = r9
        L_0x0030:
            androidx.compose.runtime.collection.MutableVector r9 = androidx.compose.ui.node.NodeChainKt.fillVector(r7, r2)
            int r2 = r9.getSize()
            int r4 = r8.getSize()
            r10 = 1
            if (r2 != r4) goto L_0x0109
            int r11 = r8.getSize()
            androidx.compose.ui.Modifier$Node r2 = r6.tail
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            int r4 = r11 + -1
            r5 = 0
            r19 = r5
        L_0x004e:
            if (r2 == 0) goto L_0x00de
            if (r4 < 0) goto L_0x00de
            r5 = r8
            r12 = 0
            java.lang.Object[] r13 = r5.getContent()
            r5 = r13[r4]
            androidx.compose.ui.Modifier$Element r5 = (androidx.compose.ui.Modifier.Element) r5
            r12 = r9
            r13 = 0
            java.lang.Object[] r14 = r12.getContent()
            r12 = r14[r4]
            r15 = r12
            androidx.compose.ui.Modifier$Element r15 = (androidx.compose.ui.Modifier.Element) r15
            int r12 = androidx.compose.ui.node.NodeChainKt.actionForModifiers(r5, r15)
            switch(r12) {
                case 0: goto L_0x00ac;
                case 1: goto L_0x0087;
                case 2: goto L_0x0071;
                default: goto L_0x006e;
            }
        L_0x006e:
            r13 = r15
            goto L_0x00c3
        L_0x0071:
            androidx.compose.ui.node.NodeChain$Logger r12 = r6.logger
            if (r12 == 0) goto L_0x0082
            r13 = r4
            r14 = r4
            r20 = r15
            r15 = r5
            r16 = r20
            r17 = r2
            r12.nodeReused(r13, r14, r15, r16, r17)
            goto L_0x0084
        L_0x0082:
            r20 = r15
        L_0x0084:
            r13 = r20
            goto L_0x00c3
        L_0x0087:
            r20 = r15
            r15 = r2
            r14 = r20
            androidx.compose.ui.Modifier$Node r2 = r6.updateNodeAndReplaceIfNeeded(r5, r14, r15)
            androidx.compose.ui.node.NodeChain$Logger r12 = r6.logger
            if (r12 == 0) goto L_0x00a5
            r13 = r4
            r20 = r14
            r14 = r4
            r21 = r15
            r15 = r5
            r16 = r20
            r17 = r21
            r18 = r2
            r12.nodeUpdated(r13, r14, r15, r16, r17, r18)
            goto L_0x00a9
        L_0x00a5:
            r20 = r14
            r21 = r15
        L_0x00a9:
            r13 = r20
            goto L_0x00c3
        L_0x00ac:
            r20 = r15
            androidx.compose.ui.node.NodeChain$Logger r12 = r6.logger
            if (r12 == 0) goto L_0x00b8
            r13 = r20
            r12.linearDiffAborted(r4, r5, r13, r2)
            goto L_0x00ba
        L_0x00b8:
            r13 = r20
        L_0x00ba:
            int r4 = r4 + 1
            androidx.compose.ui.Modifier$Node r2 = r2.getChild$ui_release()
            r12 = r2
            r13 = r4
            goto L_0x00e0
        L_0x00c3:
            boolean r12 = r2.isAttached()
            if (r12 != 0) goto L_0x00ca
            r0 = 1
        L_0x00ca:
            int r12 = r2.getKindSet$ui_release()
            r12 = r19 | r12
            r2.setAggregateChildKindSet$ui_release(r12)
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            int r4 = r4 + -1
            r19 = r12
            goto L_0x004e
        L_0x00de:
            r12 = r2
            r13 = r4
        L_0x00e0:
            if (r13 <= 0) goto L_0x0192
            if (r12 == 0) goto L_0x00e5
            r3 = r10
        L_0x00e5:
            if (r3 == 0) goto L_0x00fd
            r14 = 1
            r15 = 1
            r0 = r22
            r1 = r8
            r2 = r13
            r3 = r9
            r4 = r13
            r5 = r12
            r0.structuralUpdate(r1, r2, r3, r4, r5)
            r0 = r14
            r1 = r15
            goto L_0x0192
        L_0x00fd:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "Check failed."
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L_0x0109:
            int r2 = r8.getSize()
            if (r2 != 0) goto L_0x0147
            r0 = 1
            r1 = 1
            int r2 = r9.getSize()
            int r2 = r2 - r10
            r3 = 0
            androidx.compose.ui.Modifier$Node r4 = r6.tail
        L_0x0119:
            if (r2 < 0) goto L_0x0192
            r5 = r9
            r11 = 0
            java.lang.Object[] r12 = r5.getContent()
            r5 = r12[r2]
            androidx.compose.ui.Modifier$Element r5 = (androidx.compose.ui.Modifier.Element) r5
            r15 = r4
            androidx.compose.ui.Modifier$Node r4 = r6.createAndInsertNodeAsParent(r5, r15)
            androidx.compose.ui.node.NodeChain$Logger r11 = r6.logger
            if (r11 == 0) goto L_0x0139
            r12 = 0
            r13 = r2
            r14 = r5
            r17 = r15
            r16 = r4
            r11.nodeInserted(r12, r13, r14, r15, r16)
            goto L_0x013b
        L_0x0139:
            r17 = r15
        L_0x013b:
            int r11 = r4.getKindSet$ui_release()
            r3 = r3 | r11
            r4.setAggregateChildKindSet$ui_release(r3)
            int r2 = r2 + -1
            goto L_0x0119
        L_0x0147:
            int r2 = r9.getSize()
            if (r2 != 0) goto L_0x017a
            r1 = 1
            int r2 = r8.getSize()
            int r2 = r2 - r10
            androidx.compose.ui.Modifier$Node r3 = r6.tail
            androidx.compose.ui.Modifier$Node r3 = r3.getParent$ui_release()
        L_0x0159:
            if (r3 == 0) goto L_0x0192
            if (r2 < 0) goto L_0x0192
            androidx.compose.ui.node.NodeChain$Logger r4 = r6.logger
            if (r4 == 0) goto L_0x016e
            r5 = r8
            r11 = 0
            java.lang.Object[] r12 = r5.getContent()
            r5 = r12[r2]
            androidx.compose.ui.Modifier$Element r5 = (androidx.compose.ui.Modifier.Element) r5
            r4.nodeRemoved(r2, r5, r3)
        L_0x016e:
            androidx.compose.ui.Modifier$Node r4 = r3.getParent$ui_release()
            r6.detachAndRemoveNode(r3)
            r3 = r4
            int r2 = r2 + -1
            goto L_0x0159
        L_0x017a:
            r11 = 1
            r12 = 1
            int r2 = r8.getSize()
            int r4 = r9.getSize()
            androidx.compose.ui.Modifier$Node r5 = r6.tail
            r0 = r22
            r1 = r8
            r3 = r9
            r0.structuralUpdate(r1, r2, r3, r4, r5)
            r0 = r11
            r1 = r12
        L_0x0192:
            r6.current = r9
            r2 = r8
            r3 = 0
            r2.clear()
            r6.buffer = r8
            r22.trimChain()
            if (r1 == 0) goto L_0x01a4
            r22.syncCoordinators()
        L_0x01a4:
            if (r0 == 0) goto L_0x01b1
            androidx.compose.ui.node.LayoutNode r2 = r6.layoutNode
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L_0x01b1
            r6.attach(r10)
        L_0x01b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeChain.updateFrom$ui_release(androidx.compose.ui.Modifier):void");
    }

    public final void resetState$ui_release() {
        MutableVector current2 = this.current;
        if (current2 != null) {
            int size = current2.getSize();
            Modifier.Node node = this.tail.getParent$ui_release();
            int i = size - 1;
            while (node != null && i >= 0) {
                if (node.isAttached()) {
                    node.reset$ui_release();
                    node.detach$ui_release();
                }
                node = node.getParent$ui_release();
                i--;
            }
        }
    }

    private final void syncCoordinators() {
        LayoutModifierNodeCoordinator c;
        NodeCoordinator coordinator = this.innerCoordinator;
        for (Modifier.Node node = this.tail.getParent$ui_release(); node != null; node = node.getParent$ui_release()) {
            if (!((node.getKindSet$ui_release() & NodeKind.m5123constructorimpl(2)) != 0) || !(node instanceof LayoutModifierNode)) {
                node.updateCoordinator$ui_release(coordinator);
            } else {
                if (node.getCoordinator$ui_release() != null) {
                    NodeCoordinator coordinator$ui_release = node.getCoordinator$ui_release();
                    Intrinsics.checkNotNull(coordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    c = (LayoutModifierNodeCoordinator) coordinator$ui_release;
                    LayoutModifierNode prevNode = c.getLayoutModifierNode();
                    c.setLayoutModifierNode$ui_release((LayoutModifierNode) node);
                    if (prevNode != node) {
                        c.onLayoutModifierNodeChanged();
                    }
                } else {
                    c = new LayoutModifierNodeCoordinator(this.layoutNode, (LayoutModifierNode) node);
                    node.updateCoordinator$ui_release(c);
                }
                coordinator.setWrappedBy$ui_release(c);
                c.setWrapped$ui_release(coordinator);
                coordinator = c;
            }
        }
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        coordinator.setWrappedBy$ui_release(parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null);
        this.outerCoordinator = coordinator;
    }

    public final void attach(boolean performInvalidations) {
        for (Modifier.Node node$iv = getHead$ui_release(); node$iv != null; node$iv = node$iv.getChild$ui_release()) {
            Modifier.Node it = node$iv;
            if (!it.isAttached()) {
                it.attach$ui_release();
                if (performInvalidations) {
                    if (it.getInsertedNodeAwaitingAttachForInvalidation$ui_release()) {
                        NodeKindKt.autoInvalidateInsertedNode(it);
                    }
                    if (it.getUpdatedNodeAwaitingAttachForInvalidation$ui_release()) {
                        NodeKindKt.autoInvalidateUpdatedNode(it);
                    }
                }
                it.setInsertedNodeAwaitingAttachForInvalidation$ui_release(false);
                it.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(false);
            }
        }
    }

    public final List<ModifierInfo> getModifierInfo() {
        MutableVector current2 = this.current;
        if (current2 == null) {
            return CollectionsKt.emptyList();
        }
        MutableVector infoList = new MutableVector(new ModifierInfo[current2.getSize()], 0);
        int i = 0;
        Modifier.Node node$iv = getHead$ui_release();
        while (node$iv != null && node$iv != getTail$ui_release()) {
            NodeCoordinator coordinator = node$iv.getCoordinator$ui_release();
            if (coordinator != null) {
                int i2 = i + 1;
                infoList.add(new ModifierInfo((Modifier) current2.getContent()[i], coordinator, coordinator.getLayer()));
                node$iv = node$iv.getChild$ui_release();
                i = i2;
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        return infoList.asMutableList();
    }

    public final void detach$ui_release() {
        for (Modifier.Node node$iv = getTail$ui_release(); node$iv != null; node$iv = node$iv.getParent$ui_release()) {
            Modifier.Node it = node$iv;
            if (it.isAttached()) {
                it.detach$ui_release();
            }
        }
    }

    private final Differ getDiffer(Modifier.Node tail2, MutableVector<Modifier.Element> before, MutableVector<Modifier.Element> after) {
        Differ current2 = this.cachedDiffer;
        if (current2 == null) {
            Differ it = new Differ(this, tail2, tail2.getAggregateChildKindSet$ui_release(), before, after);
            this.cachedDiffer = it;
            return it;
        }
        Differ it2 = current2;
        it2.setNode(tail2);
        it2.setAggregateChildKindSet(tail2.getAggregateChildKindSet$ui_release());
        it2.setBefore(before);
        it2.setAfter(after);
        return current2;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Landroidx/compose/ui/node/NodeChain$Differ;", "Landroidx/compose/ui/node/DiffCallback;", "node", "Landroidx/compose/ui/Modifier$Node;", "aggregateChildKindSet", "", "before", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "after", "(Landroidx/compose/ui/node/NodeChain;Landroidx/compose/ui/Modifier$Node;ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/runtime/collection/MutableVector;)V", "getAfter", "()Landroidx/compose/runtime/collection/MutableVector;", "setAfter", "(Landroidx/compose/runtime/collection/MutableVector;)V", "getAggregateChildKindSet", "()I", "setAggregateChildKindSet", "(I)V", "getBefore", "setBefore", "getNode", "()Landroidx/compose/ui/Modifier$Node;", "setNode", "(Landroidx/compose/ui/Modifier$Node;)V", "areItemsTheSame", "", "oldIndex", "newIndex", "insert", "", "atIndex", "remove", "same", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NodeChain.kt */
    private final class Differ implements DiffCallback {
        private MutableVector<Modifier.Element> after;
        private int aggregateChildKindSet;
        private MutableVector<Modifier.Element> before;
        private Modifier.Node node;
        final /* synthetic */ NodeChain this$0;

        public Differ(NodeChain this$02, Modifier.Node node2, int aggregateChildKindSet2, MutableVector<Modifier.Element> before2, MutableVector<Modifier.Element> after2) {
            Intrinsics.checkNotNullParameter(node2, "node");
            Intrinsics.checkNotNullParameter(before2, "before");
            Intrinsics.checkNotNullParameter(after2, "after");
            this.this$0 = this$02;
            this.node = node2;
            this.aggregateChildKindSet = aggregateChildKindSet2;
            this.before = before2;
            this.after = after2;
        }

        public final Modifier.Node getNode() {
            return this.node;
        }

        public final void setNode(Modifier.Node node2) {
            Intrinsics.checkNotNullParameter(node2, "<set-?>");
            this.node = node2;
        }

        public final int getAggregateChildKindSet() {
            return this.aggregateChildKindSet;
        }

        public final void setAggregateChildKindSet(int i) {
            this.aggregateChildKindSet = i;
        }

        public final MutableVector<Modifier.Element> getBefore() {
            return this.before;
        }

        public final void setBefore(MutableVector<Modifier.Element> mutableVector) {
            Intrinsics.checkNotNullParameter(mutableVector, "<set-?>");
            this.before = mutableVector;
        }

        public final MutableVector<Modifier.Element> getAfter() {
            return this.after;
        }

        public final void setAfter(MutableVector<Modifier.Element> mutableVector) {
            Intrinsics.checkNotNullParameter(mutableVector, "<set-?>");
            this.after = mutableVector;
        }

        public boolean areItemsTheSame(int oldIndex, int newIndex) {
            return NodeChainKt.actionForModifiers((Modifier.Element) this.before.getContent()[oldIndex], (Modifier.Element) this.after.getContent()[newIndex]) != 0;
        }

        public void insert(int atIndex, int newIndex) {
            Modifier.Node child = this.node;
            Modifier.Node access$createAndInsertNodeAsParent = this.this$0.createAndInsertNodeAsParent((Modifier.Element) this.after.getContent()[newIndex], child);
            this.node = access$createAndInsertNodeAsParent;
            if (!access$createAndInsertNodeAsParent.isAttached()) {
                this.node.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
                Logger access$getLogger$p = this.this$0.logger;
                if (access$getLogger$p != null) {
                    access$getLogger$p.nodeInserted(atIndex, newIndex, (Modifier.Element) this.after.getContent()[newIndex], child, this.node);
                }
                int kindSet$ui_release = this.aggregateChildKindSet | this.node.getKindSet$ui_release();
                this.aggregateChildKindSet = kindSet$ui_release;
                this.node.setAggregateChildKindSet$ui_release(kindSet$ui_release);
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public void remove(int oldIndex) {
            Modifier.Node parent$ui_release = this.node.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release);
            this.node = parent$ui_release;
            Logger access$getLogger$p = this.this$0.logger;
            if (access$getLogger$p != null) {
                access$getLogger$p.nodeRemoved(oldIndex, (Modifier.Element) this.before.getContent()[oldIndex], this.node);
            }
            this.node = this.this$0.detachAndRemoveNode(this.node);
        }

        public void same(int oldIndex, int newIndex) {
            Modifier.Node parent$ui_release = this.node.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release);
            this.node = parent$ui_release;
            Modifier.Element prev = (Modifier.Element) this.before.getContent()[oldIndex];
            Modifier.Element next = (Modifier.Element) this.after.getContent()[newIndex];
            if (!Intrinsics.areEqual((Object) prev, (Object) next)) {
                Modifier.Node beforeUpdate = this.node;
                this.node = this.this$0.updateNodeAndReplaceIfNeeded(prev, next, beforeUpdate);
                Logger access$getLogger$p = this.this$0.logger;
                if (access$getLogger$p != null) {
                    access$getLogger$p.nodeUpdated(oldIndex, newIndex, prev, next, beforeUpdate, this.node);
                }
            } else {
                Logger access$getLogger$p2 = this.this$0.logger;
                if (access$getLogger$p2 != null) {
                    access$getLogger$p2.nodeReused(oldIndex, newIndex, prev, next, this.node);
                }
            }
            int kindSet$ui_release = this.aggregateChildKindSet | this.node.getKindSet$ui_release();
            this.aggregateChildKindSet = kindSet$ui_release;
            this.node.setAggregateChildKindSet$ui_release(kindSet$ui_release);
        }
    }

    private final void structuralUpdate(MutableVector<Modifier.Element> before, int beforeSize, MutableVector<Modifier.Element> after, int afterSize, Modifier.Node tail2) {
        MyersDiffKt.executeDiff(beforeSize, afterSize, getDiffer(tail2, before, after));
    }

    private final Modifier.Node replaceNode(Modifier.Node prev, Modifier.Node next) {
        Modifier.Node parent = prev.getParent$ui_release();
        if (parent != null) {
            next.setParent$ui_release(parent);
            parent.setChild$ui_release(next);
            prev.setParent$ui_release((Modifier.Node) null);
        }
        Modifier.Node child = prev.getChild$ui_release();
        if (child != null) {
            next.setChild$ui_release(child);
            child.setParent$ui_release(next);
            prev.setChild$ui_release((Modifier.Node) null);
        }
        next.updateCoordinator$ui_release(prev.getCoordinator$ui_release());
        return next;
    }

    /* access modifiers changed from: private */
    public final Modifier.Node detachAndRemoveNode(Modifier.Node node) {
        if (node.isAttached()) {
            NodeKindKt.autoInvalidateRemovedNode(node);
            node.detach$ui_release();
        }
        return removeNode(node);
    }

    private final Modifier.Node removeNode(Modifier.Node node) {
        Modifier.Node child = node.getChild$ui_release();
        Modifier.Node parent = node.getParent$ui_release();
        if (child != null) {
            child.setParent$ui_release(parent);
            node.setChild$ui_release((Modifier.Node) null);
        }
        if (parent != null) {
            parent.setChild$ui_release(child);
            node.setParent$ui_release((Modifier.Node) null);
        }
        Intrinsics.checkNotNull(child);
        return child;
    }

    /* access modifiers changed from: private */
    public final Modifier.Node createAndInsertNodeAsParent(Modifier.Element element, Modifier.Node child) {
        Modifier.Node node;
        if (element instanceof ModifierNodeElement) {
            node = ((ModifierNodeElement) element).create();
            Modifier.Node it = node;
            it.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(it));
        } else {
            node = new BackwardsCompatNode(element);
        }
        if (!node.isAttached()) {
            node.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
            return insertParent(node, child);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private final Modifier.Node insertParent(Modifier.Node node, Modifier.Node child) {
        Modifier.Node theParent = child.getParent$ui_release();
        if (theParent != null) {
            theParent.setChild$ui_release(node);
            node.setParent$ui_release(theParent);
        }
        child.setParent$ui_release(node);
        node.setChild$ui_release(child);
        return node;
    }

    /* access modifiers changed from: private */
    public final Modifier.Node updateNodeAndReplaceIfNeeded(Modifier.Element prev, Modifier.Element next, Modifier.Node node) {
        if ((prev instanceof ModifierNodeElement) && (next instanceof ModifierNodeElement)) {
            Modifier.Node updated = NodeChainKt.updateUnsafe((ModifierNodeElement) next, node);
            if (updated == node) {
                if (((ModifierNodeElement) next).getAutoInvalidate()) {
                    if (updated.isAttached()) {
                        NodeKindKt.autoInvalidateUpdatedNode(updated);
                    } else {
                        updated.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
                    }
                }
                return updated;
            } else if (!updated.isAttached()) {
                updated.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
                if (node.isAttached()) {
                    NodeKindKt.autoInvalidateRemovedNode(node);
                    node.detach$ui_release();
                }
                return replaceNode(node, updated);
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        } else if (node instanceof BackwardsCompatNode) {
            ((BackwardsCompatNode) node).setElement(next);
            if (node.isAttached()) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
            } else {
                node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
            }
            return node;
        } else {
            throw new IllegalStateException("Unknown Modifier.Node type".toString());
        }
    }

    /* renamed from: firstFromHead-aLcG6gQ$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> T m5072firstFromHeadaLcG6gQ$ui_release(int type, Function1<? super T, Boolean> block) {
        Function1<? super T, Boolean> function1 = block;
        Intrinsics.checkNotNullParameter(function1, "block");
        int mask$iv$iv = type;
        if ((getAggregateChildKindSet() & mask$iv$iv) == 0) {
            return null;
        }
        for (Modifier.Node node$iv$iv$iv = getHead$ui_release(); node$iv$iv$iv != null; node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release()) {
            Modifier.Node node = node$iv$iv$iv;
            if ((node.getKindSet$ui_release() & mask$iv$iv) != 0) {
                Object it$iv = node;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (it$iv instanceof Object) {
                    Object it = it$iv;
                    if (function1.invoke(it).booleanValue()) {
                        return it;
                    }
                }
            }
            if ((node.getAggregateChildKindSet$ui_release() & mask$iv$iv) == 0) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: headToTail-aLcG6gQ$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> void m5075headToTailaLcG6gQ$ui_release(int type, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int mask$iv = type;
        if ((getAggregateChildKindSet() & mask$iv) != 0) {
            Modifier.Node node$iv$iv = getHead$ui_release();
            while (node$iv$iv != null) {
                Modifier.Node it$iv = node$iv$iv;
                if ((it$iv.getKindSet$ui_release() & mask$iv) != 0) {
                    Modifier.Node it = it$iv;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (it instanceof Object) {
                        block.invoke(it);
                    }
                }
                if ((it$iv.getAggregateChildKindSet$ui_release() & mask$iv) != 0) {
                    node$iv$iv = node$iv$iv.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    public final void headToTail$ui_release(int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if ((getAggregateChildKindSet() & mask) != 0) {
            Modifier.Node node$iv = getHead$ui_release();
            while (node$iv != null) {
                Modifier.Node it = node$iv;
                if ((it.getKindSet$ui_release() & mask) != 0) {
                    block.invoke(it);
                }
                if ((it.getAggregateChildKindSet$ui_release() & mask) != 0) {
                    node$iv = node$iv.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    public final void headToTail$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        for (Modifier.Node node = getHead$ui_release(); node != null; node = node.getChild$ui_release()) {
            block.invoke(node);
        }
    }

    public final void headToTailExclusive$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Modifier.Node node = getHead$ui_release();
        while (node != null && node != getTail$ui_release()) {
            block.invoke(node);
            node = node.getChild$ui_release();
        }
    }

    /* renamed from: tailToHead-aLcG6gQ$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> void m5077tailToHeadaLcG6gQ$ui_release(int type, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        int mask$iv = type;
        if ((getAggregateChildKindSet() & mask$iv) != 0) {
            for (Modifier.Node node$iv$iv = getTail$ui_release(); node$iv$iv != null; node$iv$iv = node$iv$iv.getParent$ui_release()) {
                Modifier.Node it$iv = node$iv$iv;
                if ((it$iv.getKindSet$ui_release() & mask$iv) != 0) {
                    Modifier.Node it = it$iv;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (it instanceof Object) {
                        block.invoke(it);
                    }
                }
            }
        }
    }

    public final void tailToHead$ui_release(int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if ((getAggregateChildKindSet() & mask) != 0) {
            for (Modifier.Node node$iv = getTail$ui_release(); node$iv != null; node$iv = node$iv.getParent$ui_release()) {
                Modifier.Node it = node$iv;
                if ((it.getKindSet$ui_release() & mask) != 0) {
                    block.invoke(it);
                }
            }
        }
    }

    public final void tailToHead$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        for (Modifier.Node node = getTail$ui_release(); node != null; node = node.getParent$ui_release()) {
            block.invoke(node);
        }
    }

    /* renamed from: tail-H91voCI$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> T m5076tailH91voCI$ui_release(int type) {
        int mask$iv$iv = type;
        if ((getAggregateChildKindSet() & mask$iv$iv) == 0) {
            return null;
        }
        for (Modifier.Node node$iv$iv$iv = getTail$ui_release(); node$iv$iv$iv != null; node$iv$iv$iv = node$iv$iv$iv.getParent$ui_release()) {
            Modifier.Node node = node$iv$iv$iv;
            if ((node.getKindSet$ui_release() & mask$iv$iv) != 0) {
                Object it$iv = node;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (it$iv instanceof Object) {
                    return it$iv;
                }
            }
        }
        return null;
    }

    /* renamed from: head-H91voCI$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> T m5074headH91voCI$ui_release(int type) {
        int mask$iv$iv = type;
        if ((getAggregateChildKindSet() & mask$iv$iv) == 0) {
            return null;
        }
        for (Modifier.Node node$iv$iv$iv = getHead$ui_release(); node$iv$iv$iv != null; node$iv$iv$iv = node$iv$iv$iv.getChild$ui_release()) {
            Modifier.Node node = node$iv$iv$iv;
            if ((node.getKindSet$ui_release() & mask$iv$iv) != 0) {
                Object it$iv = node;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (it$iv instanceof Object) {
                    return it$iv;
                }
            }
            if ((node.getAggregateChildKindSet$ui_release() & mask$iv$iv) == 0) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: has-H91voCI$ui_release  reason: not valid java name */
    public final boolean m5073hasH91voCI$ui_release(int type) {
        return (getAggregateChildKindSet() & type) != 0;
    }

    public final boolean has$ui_release(int mask) {
        return (getAggregateChildKindSet() & mask) != 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder $this$toString_u24lambda_u2415 = sb;
        $this$toString_u24lambda_u2415.append("[");
        if (this.head != this.tail) {
            Modifier.Node node$iv = getHead$ui_release();
            while (true) {
                if (node$iv == null || node$iv == getTail$ui_release()) {
                    break;
                }
                Modifier.Node it = node$iv;
                $this$toString_u24lambda_u2415.append(String.valueOf(it));
                if (it.getChild$ui_release() == this.tail) {
                    $this$toString_u24lambda_u2415.append("]");
                    break;
                }
                $this$toString_u24lambda_u2415.append(",");
                node$iv = node$iv.getChild$ui_release();
            }
        } else {
            $this$toString_u24lambda_u2415.append("]");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
