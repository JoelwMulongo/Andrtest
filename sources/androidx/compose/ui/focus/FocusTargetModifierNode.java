package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.modifier.ModifierLocalNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverNode;
import androidx.compose.ui.node.ObserverNodeKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0004J\r\u0010\u0013\u001a\u00020\u0014H\u0001¢\u0006\u0002\b\u0015J\r\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\r\u0010\u001b\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u001cR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetModifierNode;", "Landroidx/compose/ui/node/ObserverNode;", "Landroidx/compose/ui/modifier/ModifierLocalNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "beyondBoundsLayoutParent", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "getBeyondBoundsLayoutParent$ui_release", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "focusState", "Landroidx/compose/ui/focus/FocusState;", "getFocusState", "()Landroidx/compose/ui/focus/FocusState;", "focusStateImpl", "Landroidx/compose/ui/focus/FocusStateImpl;", "getFocusStateImpl$ui_release", "()Landroidx/compose/ui/focus/FocusStateImpl;", "setFocusStateImpl$ui_release", "(Landroidx/compose/ui/focus/FocusStateImpl;)V", "fetchFocusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "fetchFocusProperties$ui_release", "invalidateFocus", "", "invalidateFocus$ui_release", "onObservedReadsChanged", "onReset", "scheduleInvalidationForFocusEvents", "scheduleInvalidationForFocusEvents$ui_release", "FocusTargetModifierElement", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusTargetModifierNode.kt */
public final class FocusTargetModifierNode extends Modifier.Node implements ObserverNode, ModifierLocalNode {
    public static final int $stable = 8;
    private FocusStateImpl focusStateImpl = FocusStateImpl.Inactive;

    public final FocusState getFocusState() {
        return this.focusStateImpl;
    }

    public final FocusStateImpl getFocusStateImpl$ui_release() {
        return this.focusStateImpl;
    }

    public final void setFocusStateImpl$ui_release(FocusStateImpl focusStateImpl2) {
        Intrinsics.checkNotNullParameter(focusStateImpl2, "<set-?>");
        this.focusStateImpl = focusStateImpl2;
    }

    public final BeyondBoundsLayout getBeyondBoundsLayoutParent$ui_release() {
        return (BeyondBoundsLayout) getCurrent(BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout());
    }

    public void onObservedReadsChanged() {
        FocusState previousFocusState = getFocusState();
        invalidateFocus$ui_release();
        if (!Intrinsics.areEqual((Object) previousFocusState, (Object) getFocusState())) {
            FocusEventModifierNodeKt.refreshFocusEventNodes(this);
        }
    }

    public void onReset() {
        FocusState focusState = getFocusState();
        if (focusState == FocusStateImpl.Active || focusState == FocusStateImpl.Captured) {
            DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
        } else if (focusState == FocusStateImpl.ActiveParent) {
            scheduleInvalidationForFocusEvents$ui_release();
            this.focusStateImpl = FocusStateImpl.Inactive;
        } else if (focusState == FocusStateImpl.Inactive) {
            scheduleInvalidationForFocusEvents$ui_release();
        }
    }

    public final FocusProperties fetchFocusProperties$ui_release() {
        NodeChain nodes$ui_release;
        FocusPropertiesImpl properties = new FocusPropertiesImpl();
        DelegatableNode $this$visitAncestors$iv = this;
        int mask$iv = NodeKind.m5123constructorimpl(2048) | NodeKind.m5123constructorimpl(1024);
        if ($this$visitAncestors$iv.getNode().isAttached()) {
            Modifier.Node node$iv = $this$visitAncestors$iv.getNode().getParent$ui_release();
            LayoutNode layout$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv);
            while (layout$iv != null) {
                if ((layout$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv) != 0) {
                    while (node$iv != null) {
                        if ((node$iv.getKindSet$ui_release() & mask$iv) != 0) {
                            Modifier.Node it = node$iv;
                            if ((it.getKindSet$ui_release() & NodeKind.m5123constructorimpl(1024)) != 0) {
                                return properties;
                            }
                            if (it instanceof FocusPropertiesModifierNode) {
                                ((FocusPropertiesModifierNode) it).modifyFocusProperties(properties);
                            } else {
                                throw new IllegalStateException("Check failed.".toString());
                            }
                        }
                        node$iv = node$iv.getParent$ui_release();
                    }
                }
                layout$iv = layout$iv.getParent$ui_release();
                node$iv = (layout$iv == null || (nodes$ui_release = layout$iv.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            return properties;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void invalidateFocus$ui_release() {
        FocusProperties focusProperties;
        FocusState focusState = getFocusState();
        if (focusState == FocusStateImpl.Active || focusState == FocusStateImpl.Captured) {
            Ref.ObjectRef focusProperties2 = new Ref.ObjectRef();
            ObserverNodeKt.observeReads(this, new FocusTargetModifierNode$invalidateFocus$1(focusProperties2, this));
            if (focusProperties2.element == null) {
                Intrinsics.throwUninitializedPropertyAccessException("focusProperties");
                focusProperties = null;
            } else {
                focusProperties = (FocusProperties) focusProperties2.element;
            }
            if (!focusProperties.getCanFocus()) {
                DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
            }
        } else if (focusState != FocusStateImpl.ActiveParent) {
            FocusStateImpl focusStateImpl2 = FocusStateImpl.Inactive;
        }
    }

    public final void scheduleInvalidationForFocusEvents$ui_release() {
        NodeChain nodes$ui_release;
        DelegatableNode $this$visitAncestors$iv = this;
        int mask$iv = NodeKind.m5123constructorimpl(4096) | NodeKind.m5123constructorimpl(1024);
        if ($this$visitAncestors$iv.getNode().isAttached()) {
            Modifier.Node node$iv = $this$visitAncestors$iv.getNode().getParent$ui_release();
            LayoutNode layout$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv);
            while (layout$iv != null) {
                if ((layout$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv) != 0) {
                    while (node$iv != null) {
                        if ((node$iv.getKindSet$ui_release() & mask$iv) != 0) {
                            Modifier.Node it = node$iv;
                            if ((it.getKindSet$ui_release() & NodeKind.m5123constructorimpl(1024)) != 0) {
                                continue;
                            } else if (it instanceof FocusEventModifierNode) {
                                DelegatableNodeKt.requireOwner(this).getFocusOwner().scheduleInvalidation((FocusEventModifierNode) it);
                            } else {
                                throw new IllegalStateException("Check failed.".toString());
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

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016J\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/focus/FocusTargetModifierNode$FocusTargetModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "()V", "create", "equals", "", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusTargetModifierNode.kt */
    public static final class FocusTargetModifierElement extends ModifierNodeElement<FocusTargetModifierNode> {
        public static final FocusTargetModifierElement INSTANCE = new FocusTargetModifierElement();

        private FocusTargetModifierElement() {
        }

        public FocusTargetModifierNode create() {
            return new FocusTargetModifierNode();
        }

        public FocusTargetModifierNode update(FocusTargetModifierNode node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return node;
        }

        public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
            Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
            $this$inspectableProperties.setName("focusTarget");
        }

        public int hashCode() {
            return "focusTarget".hashCode();
        }

        public boolean equals(Object other) {
            return other == this;
        }
    }
}
