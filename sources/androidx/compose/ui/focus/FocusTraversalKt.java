package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\u001a\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0001H\u0001\u001a=\u0010\u0016\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0018H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\" \u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00018@X\u0004¢\u0006\f\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00018@X\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\u0006\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"activeChild", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "getActiveChild$annotations", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;)V", "getActiveChild", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;)Landroidx/compose/ui/focus/FocusTargetModifierNode;", "isEligibleForFocusSearch", "", "isEligibleForFocusSearch$annotations", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;)Z", "customFocusSearch", "Landroidx/compose/ui/focus/FocusRequester;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "customFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/focus/FocusRequester;", "findActiveFocusNode", "findNonDeactivatedParent", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "focusSearch", "onFound", "Lkotlin/Function1;", "focusSearch-sMXa3k8", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;ILandroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function1;)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusTraversal.kt */
public final class FocusTraversalKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusTraversal.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static /* synthetic */ void getActiveChild$annotations(FocusTargetModifierNode focusTargetModifierNode) {
    }

    public static /* synthetic */ void isEligibleForFocusSearch$annotations(FocusTargetModifierNode focusTargetModifierNode) {
    }

    /* renamed from: customFocusSearch--OM-vw8  reason: not valid java name */
    public static final FocusRequester m2867customFocusSearchOMvw8(FocusTargetModifierNode $this$customFocusSearch_u2d_u2dOM_u2dvw8, int focusDirection, LayoutDirection layoutDirection) {
        FocusRequester it;
        FocusRequester it2;
        Intrinsics.checkNotNullParameter($this$customFocusSearch_u2d_u2dOM_u2dvw8, "$this$customFocusSearch");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        FocusProperties focusProperties = $this$customFocusSearch_u2d_u2dOM_u2dvw8.fetchFocusProperties$ui_release();
        if (FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2852getNextdhqQ8s())) {
            return focusProperties.getNext();
        }
        if (FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2854getPreviousdhqQ8s())) {
            return focusProperties.getPrevious();
        }
        if (FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2856getUpdhqQ8s())) {
            return focusProperties.getUp();
        }
        if (FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2847getDowndhqQ8s())) {
            return focusProperties.getDown();
        }
        if (FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2851getLeftdhqQ8s())) {
            switch (WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()]) {
                case 1:
                    it2 = focusProperties.getStart();
                    break;
                case 2:
                    it2 = focusProperties.getEnd();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (Intrinsics.areEqual((Object) it2, (Object) FocusRequester.Companion.getDefault())) {
                it2 = null;
            }
            if (it2 == null) {
                return focusProperties.getLeft();
            }
            return it2;
        } else if (FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2855getRightdhqQ8s())) {
            switch (WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()]) {
                case 1:
                    it = focusProperties.getEnd();
                    break;
                case 2:
                    it = focusProperties.getStart();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            if (Intrinsics.areEqual((Object) it, (Object) FocusRequester.Companion.getDefault())) {
                it = null;
            }
            if (it == null) {
                return focusProperties.getRight();
            }
            return it;
        } else if (FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2848getEnterdhqQ8s())) {
            return focusProperties.getEnter().invoke(FocusDirection.m2836boximpl(focusDirection));
        } else {
            if (FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2849getExitdhqQ8s())) {
                return focusProperties.getExit().invoke(FocusDirection.m2836boximpl(focusDirection));
            }
            throw new IllegalStateException("invalid FocusDirection".toString());
        }
    }

    /* renamed from: focusSearch-sMXa3k8  reason: not valid java name */
    public static final boolean m2868focusSearchsMXa3k8(FocusTargetModifierNode $this$focusSearch_u2dsMXa3k8, int focusDirection, LayoutDirection layoutDirection, Function1<? super FocusTargetModifierNode, Boolean> onFound) {
        int direction;
        Boolean r2;
        Intrinsics.checkNotNullParameter($this$focusSearch_u2dsMXa3k8, "$this$focusSearch");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        boolean z = true;
        if (FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2852getNextdhqQ8s()) ? true : FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2854getPreviousdhqQ8s())) {
            return OneDimensionalFocusSearchKt.m2871oneDimensionalFocusSearchOMvw8($this$focusSearch_u2dsMXa3k8, focusDirection, onFound);
        }
        if (!(FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2851getLeftdhqQ8s()) ? true : FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2855getRightdhqQ8s()) ? true : FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2856getUpdhqQ8s()))) {
            z = FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2847getDowndhqQ8s());
        }
        if (z) {
            Boolean r1 = TwoDimensionalFocusSearchKt.m2880twoDimensionalFocusSearchOMvw8($this$focusSearch_u2dsMXa3k8, focusDirection, onFound);
            if (r1 != null) {
                return r1.booleanValue();
            }
            return false;
        } else if (FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2848getEnterdhqQ8s())) {
            switch (WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()]) {
                case 1:
                    direction = FocusDirection.Companion.m2855getRightdhqQ8s();
                    break;
                case 2:
                    direction = FocusDirection.Companion.m2851getLeftdhqQ8s();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            FocusTargetModifierNode findActiveFocusNode = findActiveFocusNode($this$focusSearch_u2dsMXa3k8);
            if (findActiveFocusNode == null || (r2 = TwoDimensionalFocusSearchKt.m2880twoDimensionalFocusSearchOMvw8(findActiveFocusNode, direction, onFound)) == null) {
                return false;
            }
            return r2.booleanValue();
        } else if (FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2849getExitdhqQ8s())) {
            FocusTargetModifierNode findActiveFocusNode2 = findActiveFocusNode($this$focusSearch_u2dsMXa3k8);
            FocusTargetModifierNode it = findActiveFocusNode2 != null ? findNonDeactivatedParent(findActiveFocusNode2) : null;
            if (it == null || Intrinsics.areEqual((Object) it, (Object) $this$focusSearch_u2dsMXa3k8)) {
                return false;
            }
            return onFound.invoke(it).booleanValue();
        } else {
            throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + FocusDirection.m2841toStringimpl(focusDirection)).toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = androidx.compose.ui.layout.LayoutCoordinatesKt.findRootCoordinates(r0).localBoundingBoxOf(r0, false);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.geometry.Rect focusRect(androidx.compose.ui.focus.FocusTargetModifierNode r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            androidx.compose.ui.node.NodeCoordinator r0 = r5.getCoordinator$ui_release()
            if (r0 == 0) goto L_0x001d
            r1 = 0
            r2 = r0
            androidx.compose.ui.layout.LayoutCoordinates r2 = (androidx.compose.ui.layout.LayoutCoordinates) r2
            androidx.compose.ui.layout.LayoutCoordinates r2 = androidx.compose.ui.layout.LayoutCoordinatesKt.findRootCoordinates(r2)
            r3 = r0
            androidx.compose.ui.layout.LayoutCoordinates r3 = (androidx.compose.ui.layout.LayoutCoordinates) r3
            r4 = 0
            androidx.compose.ui.geometry.Rect r0 = r2.localBoundingBoxOf(r3, r4)
            if (r0 != 0) goto L_0x0023
        L_0x001d:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.Companion
            androidx.compose.ui.geometry.Rect r0 = r0.getZero()
        L_0x0023:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.focusRect(androidx.compose.ui.focus.FocusTargetModifierNode):androidx.compose.ui.geometry.Rect");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r0 = r0.getLayoutNode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isEligibleForFocusSearch(androidx.compose.ui.focus.FocusTargetModifierNode r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            androidx.compose.ui.node.NodeCoordinator r0 = r3.getCoordinator$ui_release()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001b
            androidx.compose.ui.node.LayoutNode r0 = r0.getLayoutNode()
            if (r0 == 0) goto L_0x001b
            boolean r0 = r0.isPlaced()
            if (r0 != r1) goto L_0x001b
            r0 = r1
            goto L_0x001c
        L_0x001b:
            r0 = r2
        L_0x001c:
            if (r0 == 0) goto L_0x0036
            androidx.compose.ui.node.NodeCoordinator r0 = r3.getCoordinator$ui_release()
            if (r0 == 0) goto L_0x0032
            androidx.compose.ui.node.LayoutNode r0 = r0.getLayoutNode()
            if (r0 == 0) goto L_0x0032
            boolean r0 = r0.isAttached()
            if (r0 != r1) goto L_0x0032
            r0 = r1
            goto L_0x0033
        L_0x0032:
            r0 = r2
        L_0x0033:
            if (r0 == 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r1 = r2
        L_0x0037:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.isEligibleForFocusSearch(androidx.compose.ui.focus.FocusTargetModifierNode):boolean");
    }

    public static final FocusTargetModifierNode getActiveChild(FocusTargetModifierNode $this$activeChild) {
        FocusTargetModifierNode $this$visitChildren_u2d6rFNWt0$iv = $this$activeChild;
        Intrinsics.checkNotNullParameter($this$visitChildren_u2d6rFNWt0$iv, "<this>");
        if (!$this$activeChild.getNode().isAttached()) {
            return null;
        }
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
                                FocusTargetModifierNode it = (FocusTargetModifierNode) it$iv;
                                switch (WhenMappings.$EnumSwitchMapping$1[it.getFocusStateImpl$ui_release().ordinal()]) {
                                    case 1:
                                    case 2:
                                    case 3:
                                        return it;
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
            return null;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final FocusTargetModifierNode findActiveFocusNode(FocusTargetModifierNode $this$findActiveFocusNode) {
        FocusTargetModifierNode it;
        FocusTargetModifierNode $this$visitChildren_u2d6rFNWt0$iv = $this$findActiveFocusNode;
        Intrinsics.checkNotNullParameter($this$visitChildren_u2d6rFNWt0$iv, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[$this$findActiveFocusNode.getFocusStateImpl$ui_release().ordinal()]) {
            case 1:
            case 3:
                return $this$visitChildren_u2d6rFNWt0$iv;
            case 2:
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
                                    if ((it$iv instanceof FocusTargetModifierNode) && (it = findActiveFocusNode((FocusTargetModifierNode) it$iv)) != null) {
                                        return it;
                                    }
                                } else {
                                    node$iv$iv = node$iv$iv.getChild$ui_release();
                                }
                            }
                        }
                    }
                    return null;
                }
                throw new IllegalStateException("Check failed.".toString());
            case 4:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final FocusTargetModifierNode findNonDeactivatedParent(FocusTargetModifierNode $this$findNonDeactivatedParent) {
        NodeChain nodes$ui_release;
        int mask$iv$iv = NodeKind.m5123constructorimpl(1024);
        DelegatableNode $this$visitAncestors$iv$iv = $this$findNonDeactivatedParent;
        if ($this$visitAncestors$iv$iv.getNode().isAttached()) {
            Modifier.Node node$iv$iv = $this$visitAncestors$iv$iv.getNode().getParent$ui_release();
            LayoutNode layout$iv$iv = DelegatableNodeKt.requireLayoutNode($this$visitAncestors$iv$iv);
            while (true) {
                Modifier.Node node = null;
                if (layout$iv$iv == null) {
                    return null;
                }
                if ((layout$iv$iv.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                    while (node$iv$iv != null) {
                        if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            Modifier.Node it$iv = node$iv$iv;
                            if (it$iv instanceof FocusTargetModifierNode) {
                                FocusTargetModifierNode it = (FocusTargetModifierNode) it$iv;
                                if (it.fetchFocusProperties$ui_release().getCanFocus()) {
                                    return it;
                                }
                            } else {
                                continue;
                            }
                        }
                        node$iv$iv = node$iv$iv.getParent$ui_release();
                    }
                }
                layout$iv$iv = layout$iv$iv.getParent$ui_release();
                if (!(layout$iv$iv == null || (nodes$ui_release = layout$iv$iv.getNodes$ui_release()) == null)) {
                    node = nodes$ui_release.getTail$ui_release();
                }
                node$iv$iv = node;
            }
        } else {
            throw new IllegalStateException("Check failed.".toString());
        }
    }
}
