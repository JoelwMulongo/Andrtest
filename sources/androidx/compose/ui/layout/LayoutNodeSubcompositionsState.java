package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.Wrapper_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0002MNB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010!\u001a\u00020\"2\u001d\u0010#\u001a\u0019\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0$¢\u0006\u0002\b(ø\u0001\u0000J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0010H\u0002J\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0010J\u0006\u0010/\u001a\u00020,J\u0012\u00100\u001a\u0004\u0018\u00010\u00012\u0006\u0010*\u001a\u00020\u0010H\u0002J\u0017\u00101\u001a\u00020,2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020,02H\bJ\u0006\u00103\u001a\u00020,J\"\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00102\b\b\u0002\u00107\u001a\u00020\u0010H\u0002J(\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u00012\u0011\u0010;\u001a\r\u0012\u0004\u0012\u00020,02¢\u0006\u0002\b<¢\u0006\u0002\u0010=J\u0018\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u0013H\u0002J2\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020\u00032\b\u0010:\u001a\u0004\u0018\u00010\u00012\u0011\u0010;\u001a\r\u0012\u0004\u0012\u00020,02¢\u0006\u0002\b<H\u0002¢\u0006\u0002\u0010AJ.\u0010>\u001a\b\u0012\u0004\u0012\u00020C0B2\b\u0010:\u001a\u0004\u0018\u00010\u00012\u0011\u0010;\u001a\r\u0012\u0004\u0012\u00020,02¢\u0006\u0002\b<¢\u0006\u0002\u0010DJ:\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010F2\u0006\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\n2\u0011\u0010J\u001a\r\u0012\u0004\u0012\u00020,02¢\u0006\u0002\b<H\u0002¢\u0006\u0002\u0010KJ\u0014\u0010L\u001a\u0004\u0018\u00010\u00032\b\u0010:\u001a\u0004\u0018\u00010\u0001H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00030\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00060\u001aR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00030\u0012X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006O"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "slotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "NoIntrinsicsMessage", "", "compositionContext", "Landroidx/compose/runtime/CompositionContext;", "getCompositionContext", "()Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroidx/compose/runtime/CompositionContext;)V", "currentIndex", "", "nodeToNodeState", "", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "precomposeMap", "precomposedCount", "reusableCount", "reusableSlotIdsSet", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "scope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "slotIdToNode", "value", "getSlotReusePolicy", "()Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "setSlotReusePolicy", "(Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "createMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "createNodeAt", "index", "disposeCurrentNodes", "", "disposeOrReuseStartingFromIndex", "startIndex", "forceRecomposeChildren", "getSlotIdAtIndex", "ignoreRemeasureRequests", "Lkotlin/Function0;", "makeSureStateIsConsistent", "move", "from", "to", "count", "precompose", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "slotId", "content", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "subcompose", "node", "nodeState", "(Landroidx/compose/ui/node/LayoutNode;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "Landroidx/compose/ui/layout/Measurable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "subcomposeInto", "Landroidx/compose/runtime/Composition;", "existing", "container", "parent", "composable", "(Landroidx/compose/runtime/Composition;Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "takeNodeFromReusables", "NodeState", "Scope", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
public final class LayoutNodeSubcompositionsState {
    private final String NoIntrinsicsMessage = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing,, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";
    private CompositionContext compositionContext;
    /* access modifiers changed from: private */
    public int currentIndex;
    private final Map<LayoutNode, NodeState> nodeToNodeState = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final Map<Object, LayoutNode> precomposeMap = new LinkedHashMap();
    /* access modifiers changed from: private */
    public int precomposedCount;
    /* access modifiers changed from: private */
    public int reusableCount;
    private final SubcomposeSlotReusePolicy.SlotIdsSet reusableSlotIdsSet = new SubcomposeSlotReusePolicy.SlotIdsSet((Set) null, 1, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final LayoutNode root;
    /* access modifiers changed from: private */
    public final Scope scope = new Scope();
    private final Map<Object, LayoutNode> slotIdToNode = new LinkedHashMap();
    private SubcomposeSlotReusePolicy slotReusePolicy;

    public LayoutNodeSubcompositionsState(LayoutNode root2, SubcomposeSlotReusePolicy slotReusePolicy2) {
        Intrinsics.checkNotNullParameter(root2, "root");
        Intrinsics.checkNotNullParameter(slotReusePolicy2, "slotReusePolicy");
        this.root = root2;
        this.slotReusePolicy = slotReusePolicy2;
    }

    public final CompositionContext getCompositionContext() {
        return this.compositionContext;
    }

    public final void setCompositionContext(CompositionContext compositionContext2) {
        this.compositionContext = compositionContext2;
    }

    public final SubcomposeSlotReusePolicy getSlotReusePolicy() {
        return this.slotReusePolicy;
    }

    public final void setSlotReusePolicy(SubcomposeSlotReusePolicy value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.slotReusePolicy != value) {
            this.slotReusePolicy = value;
            disposeOrReuseStartingFromIndex(0);
        }
    }

    public final List<Measurable> subcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        Object answer$iv;
        Object obj;
        Intrinsics.checkNotNullParameter(content, "content");
        makeSureStateIsConsistent();
        LayoutNode.LayoutState layoutState = this.root.getLayoutState$ui_release();
        boolean z = false;
        if (layoutState == LayoutNode.LayoutState.Measuring || layoutState == LayoutNode.LayoutState.LayingOut) {
            Map $this$getOrPut$iv = this.slotIdToNode;
            Object value$iv = $this$getOrPut$iv.get(slotId);
            if (value$iv == null) {
                Object precomposed = (LayoutNode) this.precomposeMap.remove(slotId);
                if (precomposed != null) {
                    int i = this.precomposedCount;
                    if (i > 0) {
                        this.precomposedCount = i - 1;
                        obj = precomposed;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    obj = takeNodeFromReusables(slotId);
                    if (obj == null) {
                        obj = createNodeAt(this.currentIndex);
                    }
                }
                answer$iv = obj;
                $this$getOrPut$iv.put(slotId, answer$iv);
            } else {
                answer$iv = value$iv;
            }
            LayoutNode node = (LayoutNode) answer$iv;
            int itemIndex = this.root.getFoldedChildren$ui_release().indexOf(node);
            int i2 = this.currentIndex;
            if (itemIndex >= i2) {
                z = true;
            }
            if (z) {
                if (i2 != itemIndex) {
                    move$default(this, itemIndex, i2, 0, 4, (Object) null);
                }
                this.currentIndex++;
                subcompose(node, slotId, content);
                return node.getChildMeasurables$ui_release();
            }
            throw new IllegalArgumentException(("Key \"" + slotId + "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.").toString());
        }
        throw new IllegalStateException("subcompose can only be used inside the measure or layout blocks".toString());
    }

    private final void subcompose(LayoutNode node, Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        Object answer$iv;
        Map $this$getOrPut$iv = this.nodeToNodeState;
        Object value$iv = $this$getOrPut$iv.get(node);
        if (value$iv == null) {
            answer$iv = new NodeState(slotId, ComposableSingletons$SubcomposeLayoutKt.INSTANCE.m4805getLambda1$ui_release(), (Composition) null, 4, (DefaultConstructorMarker) null);
            $this$getOrPut$iv.put(node, answer$iv);
        } else {
            answer$iv = value$iv;
        }
        NodeState nodeState = (NodeState) answer$iv;
        Composition composition = nodeState.getComposition();
        boolean hasPendingChanges = composition != null ? composition.getHasInvalidations() : true;
        if (nodeState.getContent() != content || hasPendingChanges || nodeState.getForceRecompose()) {
            nodeState.setContent(content);
            subcompose(node, nodeState);
            nodeState.setForceRecompose(false);
        }
    }

    private final void subcompose(LayoutNode node, NodeState nodeState) {
        NodeState nodeState2 = nodeState;
        Snapshot.Companion this_$iv = Snapshot.Companion;
        Snapshot snapshot$iv = this_$iv.createNonObservableSnapshot();
        Snapshot this_$iv$iv = snapshot$iv;
        try {
            Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
            try {
                LayoutNode this_$iv$iv2 = this.root;
                this_$iv$iv2.ignoreRemeasureRequests = true;
                Function2 content = nodeState.getContent();
                Composition composition = nodeState.getComposition();
                CompositionContext compositionContext2 = this.compositionContext;
                if (compositionContext2 != null) {
                    Snapshot.Companion companion = this_$iv;
                    try {
                    } catch (Throwable th) {
                        th = th;
                        LayoutNode layoutNode = node;
                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                        throw th;
                    }
                    try {
                        try {
                            nodeState2.setComposition(subcomposeInto(composition, node, compositionContext2, ComposableLambdaKt.composableLambdaInstance(-34810602, true, new LayoutNodeSubcompositionsState$subcompose$3$1$1(nodeState2, content))));
                            this_$iv$iv2.ignoreRemeasureRequests = false;
                            Unit unit = Unit.INSTANCE;
                            try {
                                this_$iv$iv.restoreCurrent(previous$iv$iv);
                                snapshot$iv.dispose();
                            } catch (Throwable th2) {
                                th = th2;
                                snapshot$iv.dispose();
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        LayoutNode layoutNode2 = node;
                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                        throw th;
                    }
                } else {
                    LayoutNode layoutNode3 = node;
                    throw new IllegalStateException("parent composition reference not set".toString());
                }
            } catch (Throwable th5) {
                th = th5;
                Snapshot.Companion companion2 = this_$iv;
                LayoutNode layoutNode4 = node;
                this_$iv$iv.restoreCurrent(previous$iv$iv);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            Snapshot.Companion companion3 = this_$iv;
            LayoutNode layoutNode5 = node;
            snapshot$iv.dispose();
            throw th;
        }
    }

    private final Composition subcomposeInto(Composition existing, LayoutNode container, CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> composable) {
        Composition $this$subcomposeInto_u24lambda_u246;
        if (existing == null || existing.isDisposed()) {
            $this$subcomposeInto_u24lambda_u246 = Wrapper_androidKt.createSubcomposition(container, parent);
        } else {
            $this$subcomposeInto_u24lambda_u246 = existing;
        }
        $this$subcomposeInto_u24lambda_u246.setContent(composable);
        return $this$subcomposeInto_u24lambda_u246;
    }

    private final Object getSlotIdAtIndex(int index) {
        NodeState nodeState = this.nodeToNodeState.get(this.root.getFoldedChildren$ui_release().get(index));
        Intrinsics.checkNotNull(nodeState);
        return nodeState.getSlotId();
    }

    public final void disposeOrReuseStartingFromIndex(int startIndex) {
        int lastReusableIndex;
        boolean z;
        int i = startIndex;
        this.reusableCount = 0;
        int lastReusableIndex2 = (this.root.getFoldedChildren$ui_release().size() - this.precomposedCount) - 1;
        boolean needApplyNotification = false;
        if (i <= lastReusableIndex2) {
            this.reusableSlotIdsSet.clear();
            int i2 = startIndex;
            if (i2 <= lastReusableIndex2) {
                while (true) {
                    this.reusableSlotIdsSet.add(getSlotIdAtIndex(i2));
                    if (i2 == lastReusableIndex2) {
                        break;
                    }
                    i2++;
                }
            }
            this.slotReusePolicy.getSlotsToRetain(this.reusableSlotIdsSet);
            int i3 = lastReusableIndex2;
            Snapshot snapshot$iv = Snapshot.Companion.createNonObservableSnapshot();
            Snapshot this_$iv$iv = snapshot$iv;
            try {
                Snapshot previous$iv$iv = this_$iv$iv.makeCurrent();
                while (i3 >= i) {
                    try {
                        LayoutNode node = this.root.getFoldedChildren$ui_release().get(i3);
                        NodeState nodeState = this.nodeToNodeState.get(node);
                        Intrinsics.checkNotNull(nodeState);
                        NodeState nodeState2 = nodeState;
                        Object slotId = nodeState2.getSlotId();
                        if (this.reusableSlotIdsSet.contains(slotId)) {
                            try {
                                node.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                                this.reusableCount++;
                                if (nodeState2.getActive()) {
                                    nodeState2.setActive(false);
                                    needApplyNotification = true;
                                    lastReusableIndex = lastReusableIndex2;
                                    z = true;
                                } else {
                                    lastReusableIndex = lastReusableIndex2;
                                    z = true;
                                }
                            } catch (Throwable th) {
                                th = th;
                                int i4 = lastReusableIndex2;
                                this_$iv$iv.restoreCurrent(previous$iv$iv);
                                throw th;
                            }
                        } else {
                            LayoutNode this_$iv$iv2 = this.root;
                            this_$iv$iv2.ignoreRemeasureRequests = true;
                            this.nodeToNodeState.remove(node);
                            Composition composition = nodeState2.getComposition();
                            if (composition != null) {
                                composition.dispose();
                            }
                            lastReusableIndex = lastReusableIndex2;
                            z = true;
                            this.root.removeAt$ui_release(i3, 1);
                            this_$iv$iv2.ignoreRemeasureRequests = false;
                        }
                        this.slotIdToNode.remove(slotId);
                        i3--;
                        i = startIndex;
                        boolean z2 = z;
                        lastReusableIndex2 = lastReusableIndex;
                    } catch (Throwable th2) {
                        th = th2;
                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                        throw th;
                    }
                }
                Unit unit = Unit.INSTANCE;
                try {
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    snapshot$iv.dispose();
                } catch (Throwable th3) {
                    th = th3;
                    snapshot$iv.dispose();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                int i5 = lastReusableIndex2;
                snapshot$iv.dispose();
                throw th;
            }
        }
        if (needApplyNotification) {
            Snapshot.Companion.sendApplyNotifications();
        }
        makeSureStateIsConsistent();
    }

    public final void makeSureStateIsConsistent() {
        boolean z = true;
        if (this.nodeToNodeState.size() == this.root.getFoldedChildren$ui_release().size()) {
            if ((this.root.getFoldedChildren$ui_release().size() - this.reusableCount) - this.precomposedCount >= 0) {
                if (this.precomposeMap.size() != this.precomposedCount) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException(("Incorrect state. Precomposed children " + this.precomposedCount + ". Map size " + this.precomposeMap.size()).toString());
                }
                return;
            }
            throw new IllegalArgumentException(("Incorrect state. Total children " + this.root.getFoldedChildren$ui_release().size() + ". Reusable children " + this.reusableCount + ". Precomposed children " + this.precomposedCount).toString());
        }
        throw new IllegalArgumentException(("Inconsistency between the count of nodes tracked by the state (" + this.nodeToNodeState.size() + ") and the children count on the SubcomposeLayout (" + this.root.getFoldedChildren$ui_release().size() + "). Are you trying to use the state of the disposed SubcomposeLayout?").toString());
    }

    private final LayoutNode takeNodeFromReusables(Object slotId) {
        int index;
        if (this.reusableCount == 0) {
            return null;
        }
        int reusableNodesSectionEnd = this.root.getFoldedChildren$ui_release().size() - this.precomposedCount;
        int reusableNodesSectionStart = reusableNodesSectionEnd - this.reusableCount;
        int index2 = reusableNodesSectionEnd - 1;
        int chosenIndex = -1;
        while (true) {
            if (index < reusableNodesSectionStart) {
                break;
            } else if (Intrinsics.areEqual(getSlotIdAtIndex(index), slotId)) {
                chosenIndex = index;
                break;
            } else {
                index2 = index - 1;
            }
        }
        if (chosenIndex == -1) {
            index = reusableNodesSectionEnd - 1;
            while (true) {
                if (index < reusableNodesSectionStart) {
                    break;
                }
                NodeState nodeState = this.nodeToNodeState.get(this.root.getFoldedChildren$ui_release().get(index));
                Intrinsics.checkNotNull(nodeState);
                NodeState nodeState2 = nodeState;
                if (this.slotReusePolicy.areCompatible(slotId, nodeState2.getSlotId())) {
                    nodeState2.setSlotId(slotId);
                    chosenIndex = index;
                    break;
                }
                index--;
            }
        }
        if (chosenIndex == -1) {
            return null;
        }
        if (index != reusableNodesSectionStart) {
            move(index, reusableNodesSectionStart, 1);
        }
        this.reusableCount--;
        LayoutNode node = this.root.getFoldedChildren$ui_release().get(reusableNodesSectionStart);
        NodeState nodeState3 = this.nodeToNodeState.get(node);
        Intrinsics.checkNotNull(nodeState3);
        NodeState nodeState4 = nodeState3;
        nodeState4.setActive(true);
        nodeState4.setForceRecompose(true);
        Snapshot.Companion.sendApplyNotifications();
        return node;
    }

    public final MeasurePolicy createMeasurePolicy(Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new LayoutNodeSubcompositionsState$createMeasurePolicy$1(this, block, this.NoIntrinsicsMessage);
    }

    public final SubcomposeLayoutState.PrecomposedSlotHandle precompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        Object answer$iv;
        Object obj;
        Intrinsics.checkNotNullParameter(content, "content");
        makeSureStateIsConsistent();
        if (!this.slotIdToNode.containsKey(slotId)) {
            Map $this$getOrPut$iv = this.precomposeMap;
            Object value$iv = $this$getOrPut$iv.get(slotId);
            if (value$iv == null) {
                LayoutNode reusedNode = takeNodeFromReusables(slotId);
                if (reusedNode != null) {
                    move(this.root.getFoldedChildren$ui_release().indexOf(reusedNode), this.root.getFoldedChildren$ui_release().size(), 1);
                    this.precomposedCount++;
                    obj = reusedNode;
                } else {
                    obj = createNodeAt(this.root.getFoldedChildren$ui_release().size());
                    Object obj2 = obj;
                    this.precomposedCount++;
                }
                answer$iv = obj;
                $this$getOrPut$iv.put(slotId, answer$iv);
            } else {
                answer$iv = value$iv;
            }
            subcompose((LayoutNode) answer$iv, slotId, content);
        }
        return new LayoutNodeSubcompositionsState$precompose$1(this, slotId);
    }

    public final void forceRecomposeChildren() {
        for (Map.Entry<LayoutNode, NodeState> element$iv : this.nodeToNodeState.entrySet()) {
            ((NodeState) element$iv.getValue()).setForceRecompose(true);
        }
        if (!this.root.getMeasurePending$ui_release()) {
            LayoutNode.requestRemeasure$ui_release$default(this.root, false, 1, (Object) null);
        }
    }

    private final LayoutNode createNodeAt(int index) {
        LayoutNode node = new LayoutNode(true, 0, 2, (DefaultConstructorMarker) null);
        LayoutNode this_$iv$iv = this.root;
        this_$iv$iv.ignoreRemeasureRequests = true;
        this.root.insertAt$ui_release(index, node);
        this_$iv$iv.ignoreRemeasureRequests = false;
        return node;
    }

    static /* synthetic */ void move$default(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 1;
        }
        layoutNodeSubcompositionsState.move(i, i2, i3);
    }

    /* access modifiers changed from: private */
    public final void move(int from, int to, int count) {
        LayoutNode this_$iv$iv = this.root;
        this_$iv$iv.ignoreRemeasureRequests = true;
        this.root.move$ui_release(from, to, count);
        this_$iv$iv.ignoreRemeasureRequests = false;
    }

    private final void ignoreRemeasureRequests(Function0<Unit> block) {
        LayoutNode this_$iv = this.root;
        this_$iv.ignoreRemeasureRequests = true;
        block.invoke();
        this_$iv.ignoreRemeasureRequests = false;
    }

    public final void disposeCurrentNodes() {
        LayoutNode this_$iv = this.root;
        this_$iv.ignoreRemeasureRequests = true;
        for (NodeState it : this.nodeToNodeState.values()) {
            Composition composition = it.getComposition();
            if (composition != null) {
                composition.dispose();
            }
        }
        this.root.removeAll$ui_release();
        this_$iv.ignoreRemeasureRequests = false;
        this.nodeToNodeState.clear();
        this.slotIdToNode.clear();
        this.precomposedCount = 0;
        this.reusableCount = 0;
        this.precomposeMap.clear();
        makeSureStateIsConsistent();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0002\u0018\u00002\u00020\u0001B.\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR+\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R'\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "", "slotId", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "composition", "Landroidx/compose/runtime/Composition;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composition;)V", "<set-?>", "", "active", "getActive", "()Z", "setActive", "(Z)V", "active$delegate", "Landroidx/compose/runtime/MutableState;", "getComposition", "()Landroidx/compose/runtime/Composition;", "setComposition", "(Landroidx/compose/runtime/Composition;)V", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "forceRecompose", "getForceRecompose", "setForceRecompose", "getSlotId", "()Ljava/lang/Object;", "setSlotId", "(Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SubcomposeLayout.kt */
    private static final class NodeState {
        private final MutableState active$delegate;
        private Composition composition;
        private Function2<? super Composer, ? super Integer, Unit> content;
        private boolean forceRecompose;
        private Object slotId;

        public NodeState(Object slotId2, Function2<? super Composer, ? super Integer, Unit> content2, Composition composition2) {
            Intrinsics.checkNotNullParameter(content2, "content");
            this.slotId = slotId2;
            this.content = content2;
            this.composition = composition2;
            this.active$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NodeState(Object obj, Function2 function2, Composition composition2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, function2, (i & 4) != 0 ? null : composition2);
        }

        public final Object getSlotId() {
            return this.slotId;
        }

        public final void setSlotId(Object obj) {
            this.slotId = obj;
        }

        public final Function2<Composer, Integer, Unit> getContent() {
            return this.content;
        }

        public final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.content = function2;
        }

        public final Composition getComposition() {
            return this.composition;
        }

        public final void setComposition(Composition composition2) {
            this.composition = composition2;
        }

        public final boolean getForceRecompose() {
            return this.forceRecompose;
        }

        public final void setForceRecompose(boolean z) {
            this.forceRecompose = z;
        }

        public final boolean getActive() {
            return ((Boolean) this.active$delegate.getValue()).booleanValue();
        }

        public final void setActive(boolean z) {
            this.active$delegate.setValue(Boolean.valueOf(z));
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "density", "", "getDensity", "()F", "setDensity", "(F)V", "fontScale", "getFontScale", "setFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SubcomposeLayout.kt */
    private final class Scope implements SubcomposeMeasureScope {
        private float density;
        private float fontScale;
        private LayoutDirection layoutDirection = LayoutDirection.Rtl;

        public Scope() {
        }

        public LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public void setLayoutDirection(LayoutDirection layoutDirection2) {
            Intrinsics.checkNotNullParameter(layoutDirection2, "<set-?>");
            this.layoutDirection = layoutDirection2;
        }

        public float getDensity() {
            return this.density;
        }

        public void setDensity(float f) {
            this.density = f;
        }

        public float getFontScale() {
            return this.fontScale;
        }

        public void setFontScale(float f) {
            this.fontScale = f;
        }

        public List<Measurable> subcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return LayoutNodeSubcompositionsState.this.subcompose(slotId, content);
        }
    }
}
