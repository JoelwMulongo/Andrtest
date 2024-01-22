package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeKind;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusInvalidationManager.kt */
final class FocusInvalidationManager$invalidateNodes$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FocusInvalidationManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusInvalidationManager$invalidateNodes$1(FocusInvalidationManager focusInvalidationManager) {
        super(0);
        this.this$0 = focusInvalidationManager;
    }

    public final void invoke() {
        Iterator it;
        int $i$f$forEach;
        Iterable $this$forEach$iv;
        FocusState focusState;
        Modifier.Node child$iv$iv;
        Modifier.Node child$iv$iv2;
        Iterable $this$forEach$iv2 = this.this$0.focusPropertiesNodes;
        FocusInvalidationManager focusInvalidationManager = this.this$0;
        int $i$f$forEach2 = false;
        Iterator it2 = $this$forEach$iv2.iterator();
        while (true) {
            int i = 1024;
            if (it2.hasNext()) {
                int mask$iv$iv = NodeKind.m5123constructorimpl(1024);
                DelegatableNode $this$visitChildren$iv$iv = (FocusPropertiesModifierNode) it2.next();
                if ($this$visitChildren$iv$iv.getNode().isAttached()) {
                    Iterable $this$forEach$iv3 = $this$forEach$iv2;
                    int $i$f$forEach3 = $i$f$forEach2;
                    Iterator it3 = it2;
                    MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
                    Modifier.Node child$iv$iv3 = $this$visitChildren$iv$iv.getNode().getChild$ui_release();
                    if (child$iv$iv3 == null) {
                        DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitChildren$iv$iv.getNode());
                    } else {
                        branches$iv$iv.add(child$iv$iv3);
                    }
                    while (branches$iv$iv.isNotEmpty()) {
                        Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                        if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                            Modifier.Node node$iv$iv = branch$iv$iv;
                            while (true) {
                                if (node$iv$iv == null) {
                                    Modifier.Node node = child$iv$iv3;
                                    break;
                                } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                                    Modifier.Node it$iv = node$iv$iv;
                                    MutableVector branches$iv$iv2 = branches$iv$iv;
                                    if (it$iv instanceof FocusTargetModifierNode) {
                                        child$iv$iv2 = child$iv$iv3;
                                        focusInvalidationManager.focusTargetNodes.add((FocusTargetModifierNode) it$iv);
                                    } else {
                                        child$iv$iv2 = child$iv$iv3;
                                    }
                                    branches$iv$iv = branches$iv$iv2;
                                    child$iv$iv3 = child$iv$iv2;
                                } else {
                                    Modifier.Node node2 = child$iv$iv3;
                                    node$iv$iv = node$iv$iv.getChild$ui_release();
                                }
                            }
                        } else {
                            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                        }
                    }
                    Modifier.Node node3 = child$iv$iv3;
                    $this$forEach$iv2 = $this$forEach$iv3;
                    $i$f$forEach2 = $i$f$forEach3;
                    it2 = it3;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                int i2 = $i$f$forEach2;
                this.this$0.focusPropertiesNodes.clear();
                Set focusTargetsWithInvalidatedFocusEvents = new LinkedHashSet();
                Iterable $this$forEach$iv4 = this.this$0.focusEventNodes;
                FocusInvalidationManager focusInvalidationManager2 = this.this$0;
                int $i$f$forEach4 = false;
                Iterator it4 = $this$forEach$iv4.iterator();
                while (it4.hasNext()) {
                    FocusEventModifierNode focusEventNode = (FocusEventModifierNode) it4.next();
                    if (focusEventNode.getNode().isAttached()) {
                        boolean requiresUpdate = true;
                        boolean aggregatedNode = false;
                        FocusTargetModifierNode focusTargetModifierNode = null;
                        int mask$iv$iv2 = NodeKind.m5123constructorimpl(i);
                        DelegatableNode $this$visitChildren$iv$iv2 = focusEventNode;
                        if ($this$visitChildren$iv$iv2.getNode().isAttached()) {
                            $this$forEach$iv = $this$forEach$iv4;
                            $i$f$forEach = $i$f$forEach4;
                            it = it4;
                            MutableVector branches$iv$iv3 = new MutableVector(new Modifier.Node[16], 0);
                            Modifier.Node child$iv$iv4 = $this$visitChildren$iv$iv2.getNode().getChild$ui_release();
                            if (child$iv$iv4 == null) {
                                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv3, $this$visitChildren$iv$iv2.getNode());
                            } else {
                                branches$iv$iv3.add(child$iv$iv4);
                            }
                            while (branches$iv$iv3.isNotEmpty()) {
                                Modifier.Node branch$iv$iv2 = (Modifier.Node) branches$iv$iv3.removeAt(branches$iv$iv3.getSize() - 1);
                                if ((branch$iv$iv2.getAggregateChildKindSet$ui_release() & mask$iv$iv2) != 0) {
                                    Modifier.Node node$iv$iv2 = branch$iv$iv2;
                                    while (true) {
                                        if (node$iv$iv2 == null) {
                                            break;
                                        } else if ((node$iv$iv2.getKindSet$ui_release() & mask$iv$iv2) != 0) {
                                            Modifier.Node it$iv2 = node$iv$iv2;
                                            MutableVector branches$iv$iv4 = branches$iv$iv3;
                                            if (it$iv2 instanceof FocusTargetModifierNode) {
                                                FocusTargetModifierNode it5 = (FocusTargetModifierNode) it$iv2;
                                                if (focusTargetModifierNode != null) {
                                                    aggregatedNode = true;
                                                }
                                                focusTargetModifierNode = it5;
                                                child$iv$iv = child$iv$iv4;
                                                if (focusInvalidationManager2.focusTargetNodes.contains(it5)) {
                                                    requiresUpdate = false;
                                                    focusTargetsWithInvalidatedFocusEvents.add(it5);
                                                }
                                            } else {
                                                child$iv$iv = child$iv$iv4;
                                            }
                                            branches$iv$iv3 = branches$iv$iv4;
                                            child$iv$iv4 = child$iv$iv;
                                        } else {
                                            Modifier.Node node4 = child$iv$iv4;
                                            node$iv$iv2 = node$iv$iv2.getChild$ui_release();
                                        }
                                    }
                                } else {
                                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv3, branch$iv$iv2);
                                }
                                branches$iv$iv3 = branches$iv$iv3;
                                child$iv$iv4 = child$iv$iv4;
                            }
                            Modifier.Node node5 = child$iv$iv4;
                            if (requiresUpdate) {
                                if (aggregatedNode) {
                                    focusState = FocusEventModifierNodeKt.getFocusState(focusEventNode);
                                } else if (focusTargetModifierNode == null || (focusState = focusTargetModifierNode.getFocusState()) == null) {
                                    focusState = FocusStateImpl.Inactive;
                                }
                                focusEventNode.onFocusEvent(focusState);
                            }
                        } else {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    } else {
                        $this$forEach$iv = $this$forEach$iv4;
                        $i$f$forEach = $i$f$forEach4;
                        it = it4;
                    }
                    $this$forEach$iv4 = $this$forEach$iv;
                    $i$f$forEach4 = $i$f$forEach;
                    it4 = it;
                    i = 1024;
                }
                int i3 = $i$f$forEach4;
                this.this$0.focusEventNodes.clear();
                for (FocusTargetModifierNode it6 : this.this$0.focusTargetNodes) {
                    if (it6.isAttached()) {
                        FocusState preInvalidationState = it6.getFocusState();
                        it6.invalidateFocus$ui_release();
                        if (!Intrinsics.areEqual((Object) preInvalidationState, (Object) it6.getFocusState()) || focusTargetsWithInvalidatedFocusEvents.contains(it6)) {
                            FocusEventModifierNodeKt.refreshFocusEventNodes(it6);
                        }
                    }
                }
                this.this$0.focusTargetNodes.clear();
                focusTargetsWithInvalidatedFocusEvents.clear();
                if (!this.this$0.focusPropertiesNodes.isEmpty()) {
                    throw new IllegalStateException("Check failed.".toString());
                } else if (!this.this$0.focusEventNodes.isEmpty()) {
                    throw new IllegalStateException("Check failed.".toString());
                } else if (!this.this$0.focusTargetNodes.isEmpty()) {
                    throw new IllegalStateException("Check failed.".toString());
                } else {
                    return;
                }
            }
        }
    }
}
