package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.ObserverNodeKt;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0001\u001a \u0010\u0003\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0003\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0001\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0001\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\u0002H\u0001\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002\u001a\f\u0010\f\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\r"}, d2 = {"captureFocus", "", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "clearChildFocus", "forced", "refreshFocusEvents", "clearFocus", "freeFocus", "grantFocus", "requestFocus", "requestFocusForChild", "childNode", "requestFocusForOwner", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusTransactions.kt */
public final class FocusTransactionsKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusTransactions.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean requestFocus(FocusTargetModifierNode $this$requestFocus) {
        Intrinsics.checkNotNullParameter($this$requestFocus, "<this>");
        if (!$this$requestFocus.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (!$this$requestFocus.fetchFocusProperties$ui_release().getCanFocus()) {
            return TwoDimensionalFocusSearchKt.m2876findChildCorrespondingToFocusEnterOMvw8($this$requestFocus, FocusDirection.Companion.m2848getEnterdhqQ8s(), FocusTransactionsKt$requestFocus$1.INSTANCE);
        } else {
            FocusTargetModifierNode focusTargetModifierNode = null;
            boolean success = true;
            switch (WhenMappings.$EnumSwitchMapping$0[$this$requestFocus.getFocusStateImpl$ui_release().ordinal()]) {
                case 1:
                case 2:
                    FocusEventModifierNodeKt.refreshFocusEventNodes($this$requestFocus);
                    return true;
                case 3:
                    if (!clearChildFocus$default($this$requestFocus, false, false, 3, (Object) null) || !grantFocus($this$requestFocus)) {
                        success = false;
                    }
                    if (success) {
                        FocusEventModifierNodeKt.refreshFocusEventNodes($this$requestFocus);
                    }
                    return success;
                case 4:
                    Modifier.Node nearestAncestor = DelegatableNodeKt.nearestAncestor($this$requestFocus, NodeKind.m5123constructorimpl(1024));
                    if (nearestAncestor instanceof FocusTargetModifierNode) {
                        focusTargetModifierNode = nearestAncestor;
                    }
                    FocusTargetModifierNode focusTargetModifierNode2 = focusTargetModifierNode;
                    if (focusTargetModifierNode2 != null) {
                        return requestFocusForChild(focusTargetModifierNode2, $this$requestFocus);
                    }
                    if (!requestFocusForOwner($this$requestFocus) || !grantFocus($this$requestFocus)) {
                        success = false;
                    }
                    if (success) {
                        FocusEventModifierNodeKt.refreshFocusEventNodes($this$requestFocus);
                    }
                    return success;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final boolean captureFocus(FocusTargetModifierNode $this$captureFocus) {
        Intrinsics.checkNotNullParameter($this$captureFocus, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$captureFocus.getFocusStateImpl$ui_release().ordinal()]) {
            case 1:
                $this$captureFocus.setFocusStateImpl$ui_release(FocusStateImpl.Captured);
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$captureFocus);
                return true;
            case 2:
                return true;
            case 3:
            case 4:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final boolean freeFocus(FocusTargetModifierNode $this$freeFocus) {
        Intrinsics.checkNotNullParameter($this$freeFocus, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$freeFocus.getFocusStateImpl$ui_release().ordinal()]) {
            case 1:
                return true;
            case 2:
                $this$freeFocus.setFocusStateImpl$ui_release(FocusStateImpl.Active);
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$freeFocus);
                return true;
            case 3:
            case 4:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ boolean clearFocus$default(FocusTargetModifierNode focusTargetModifierNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return clearFocus(focusTargetModifierNode, z, z2);
    }

    public static final boolean clearFocus(FocusTargetModifierNode $this$clearFocus, boolean forced, boolean refreshFocusEvents) {
        Intrinsics.checkNotNullParameter($this$clearFocus, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$clearFocus.getFocusStateImpl$ui_release().ordinal()]) {
            case 1:
                $this$clearFocus.setFocusStateImpl$ui_release(FocusStateImpl.Inactive);
                if (!refreshFocusEvents) {
                    return true;
                }
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$clearFocus);
                return true;
            case 2:
                if (forced) {
                    $this$clearFocus.setFocusStateImpl$ui_release(FocusStateImpl.Inactive);
                    if (refreshFocusEvents) {
                        FocusEventModifierNodeKt.refreshFocusEventNodes($this$clearFocus);
                    }
                }
                return forced;
            case 3:
                if (!clearChildFocus($this$clearFocus, forced, refreshFocusEvents)) {
                    return false;
                }
                $this$clearFocus.setFocusStateImpl$ui_release(FocusStateImpl.Inactive);
                if (!refreshFocusEvents) {
                    return true;
                }
                FocusEventModifierNodeKt.refreshFocusEventNodes($this$clearFocus);
                return true;
            case 4:
                return true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final boolean grantFocus(FocusTargetModifierNode $this$grantFocus) {
        ObserverNodeKt.observeReads($this$grantFocus, new FocusTransactionsKt$grantFocus$1($this$grantFocus));
        switch (WhenMappings.$EnumSwitchMapping$0[$this$grantFocus.getFocusStateImpl$ui_release().ordinal()]) {
            case 3:
            case 4:
                $this$grantFocus.setFocusStateImpl$ui_release(FocusStateImpl.Active);
                return true;
            default:
                return true;
        }
    }

    static /* synthetic */ boolean clearChildFocus$default(FocusTargetModifierNode focusTargetModifierNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return clearChildFocus(focusTargetModifierNode, z, z2);
    }

    private static final boolean clearChildFocus(FocusTargetModifierNode $this$clearChildFocus, boolean forced, boolean refreshFocusEvents) {
        FocusTargetModifierNode activeChild = FocusTraversalKt.getActiveChild($this$clearChildFocus);
        if (activeChild != null) {
            return clearFocus(activeChild, forced, refreshFocusEvents);
        }
        return true;
    }

    private static final boolean requestFocusForChild(FocusTargetModifierNode $this$requestFocusForChild, FocusTargetModifierNode childNode) {
        Modifier.Node nearestAncestor = DelegatableNodeKt.nearestAncestor(childNode, NodeKind.m5123constructorimpl(1024));
        FocusTargetModifierNode focusTargetModifierNode = null;
        if (!(nearestAncestor instanceof FocusTargetModifierNode)) {
            nearestAncestor = null;
        }
        if (Intrinsics.areEqual((Object) (FocusTargetModifierNode) nearestAncestor, (Object) $this$requestFocusForChild)) {
            boolean success = true;
            switch (WhenMappings.$EnumSwitchMapping$0[$this$requestFocusForChild.getFocusStateImpl$ui_release().ordinal()]) {
                case 1:
                    boolean success2 = grantFocus(childNode);
                    if (!success2) {
                        return success2;
                    }
                    $this$requestFocusForChild.setFocusStateImpl$ui_release(FocusStateImpl.ActiveParent);
                    FocusEventModifierNodeKt.refreshFocusEventNodes(childNode);
                    FocusEventModifierNodeKt.refreshFocusEventNodes($this$requestFocusForChild);
                    return success2;
                case 2:
                    return false;
                case 3:
                    if (FocusTraversalKt.getActiveChild($this$requestFocusForChild) != null) {
                        if (!clearChildFocus$default($this$requestFocusForChild, false, false, 3, (Object) null) || !grantFocus(childNode)) {
                            success = false;
                        }
                        if (success) {
                            FocusEventModifierNodeKt.refreshFocusEventNodes(childNode);
                        }
                        return success;
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                case 4:
                    Modifier.Node nearestAncestor2 = DelegatableNodeKt.nearestAncestor($this$requestFocusForChild, NodeKind.m5123constructorimpl(1024));
                    if (nearestAncestor2 instanceof FocusTargetModifierNode) {
                        focusTargetModifierNode = nearestAncestor2;
                    }
                    FocusTargetModifierNode focusParent = focusTargetModifierNode;
                    if (focusParent == null && requestFocusForOwner($this$requestFocusForChild)) {
                        $this$requestFocusForChild.setFocusStateImpl$ui_release(FocusStateImpl.Active);
                        FocusEventModifierNodeKt.refreshFocusEventNodes($this$requestFocusForChild);
                        return requestFocusForChild($this$requestFocusForChild, childNode);
                    } else if (focusParent == null || !requestFocusForChild(focusParent, $this$requestFocusForChild)) {
                        return false;
                    } else {
                        boolean requestFocusForChild = requestFocusForChild($this$requestFocusForChild, childNode);
                        boolean z = requestFocusForChild;
                        if ($this$requestFocusForChild.getFocusState() != FocusStateImpl.ActiveParent) {
                            success = false;
                        }
                        if (success) {
                            return requestFocusForChild;
                        }
                        throw new IllegalStateException("Check failed.".toString());
                    }
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            throw new IllegalStateException("Non child node cannot request focus.".toString());
        }
    }

    private static final boolean requestFocusForOwner(FocusTargetModifierNode $this$requestFocusForOwner) {
        LayoutNode layoutNode;
        Owner owner$ui_release;
        NodeCoordinator coordinator$ui_release = $this$requestFocusForOwner.getCoordinator$ui_release();
        if (coordinator$ui_release != null && (layoutNode = coordinator$ui_release.getLayoutNode()) != null && (owner$ui_release = layoutNode.getOwner$ui_release()) != null) {
            return owner$ui_release.requestFocus();
        }
        throw new IllegalStateException("Owner not initialized.".toString());
    }
}
