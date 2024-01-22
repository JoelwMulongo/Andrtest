package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u001a5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a5\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\f\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0013H\u0003\u001a\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a\u001a\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019H\u0003\u001a1\u0010\u001a\u001a\u0004\u0018\u00010\u0013*\b\u0012\u0004\u0012\u00020\u00130\u00192\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a5\u0010\u001e\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001a=\u0010#\u001a\u00020\u0004*\u00020\u00132\u0006\u0010$\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\u001a=\u0010'\u001a\u00020\u0004*\u00020\u00132\u0006\u0010$\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010&\u001a\f\u0010)\u001a\u00020\u0006*\u00020\u0006H\u0002\u001a7\u0010*\u001a\u0004\u0018\u00010\u0004*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00040 H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006-"}, d2 = {"InvalidFocusDirection", "", "NoActiveChild", "beamBeats", "", "source", "Landroidx/compose/ui/geometry/Rect;", "rect1", "rect2", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "beamBeats-I7lrPNg", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;I)Z", "isBetterCandidate", "proposedCandidate", "currentCandidate", "focusedRect", "isBetterCandidate-I7lrPNg", "activeNode", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "bottomRight", "collectAccessibleChildren", "", "Landroidx/compose/ui/node/DelegatableNode;", "accessibleChildren", "Landroidx/compose/runtime/collection/MutableVector;", "findBestCandidate", "focusRect", "findBestCandidate-4WY_MpI", "(Landroidx/compose/runtime/collection/MutableVector;Landroidx/compose/ui/geometry/Rect;I)Landroidx/compose/ui/focus/FocusTargetModifierNode;", "findChildCorrespondingToFocusEnter", "onFound", "Lkotlin/Function1;", "findChildCorrespondingToFocusEnter--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;ILkotlin/jvm/functions/Function1;)Z", "generateAndSearchChildren", "focusedItem", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;Landroidx/compose/ui/focus/FocusTargetModifierNode;ILkotlin/jvm/functions/Function1;)Z", "searchChildren", "searchChildren-4C6V_qg", "topLeft", "twoDimensionalFocusSearch", "twoDimensionalFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TwoDimensionalFocusSearch.kt */
public final class TwoDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 2-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: TwoDimensionalFocusSearch.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 2;
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

    /* renamed from: twoDimensionalFocusSearch--OM-vw8  reason: not valid java name */
    public static final Boolean m2880twoDimensionalFocusSearchOMvw8(FocusTargetModifierNode $this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8, int direction, Function1<? super FocusTargetModifierNode, Boolean> onFound) {
        Intrinsics.checkNotNullParameter($this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8, "$this$twoDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8.getFocusStateImpl$ui_release().ordinal()]) {
            case 1:
                FocusTargetModifierNode focusedChild = FocusTraversalKt.getActiveChild($this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8);
                if (focusedChild != null) {
                    switch (WhenMappings.$EnumSwitchMapping$0[focusedChild.getFocusStateImpl$ui_release().ordinal()]) {
                        case 1:
                            Boolean found = m2880twoDimensionalFocusSearchOMvw8(focusedChild, direction, onFound);
                            if (!Intrinsics.areEqual((Object) found, (Object) false)) {
                                return found;
                            }
                            FocusRequester it = focusedChild.fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.m2836boximpl(direction));
                            if (Intrinsics.areEqual((Object) it, (Object) FocusRequester.Companion.getDefault())) {
                                it = null;
                            }
                            FocusRequester it2 = it;
                            if (it2 == null) {
                                return Boolean.valueOf(m2877generateAndSearchChildren4C6V_qg($this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8, activeNode(focusedChild), direction, onFound));
                            }
                            if (Intrinsics.areEqual((Object) it2, (Object) FocusRequester.Companion.getCancel())) {
                                return null;
                            }
                            return Boolean.valueOf(it2.findFocusTarget$ui_release(onFound));
                        case 2:
                        case 3:
                            return Boolean.valueOf(m2877generateAndSearchChildren4C6V_qg($this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8, focusedChild, direction, onFound));
                        case 4:
                            throw new IllegalStateException(NoActiveChild.toString());
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                } else {
                    throw new IllegalStateException(NoActiveChild.toString());
                }
            case 2:
            case 3:
                return Boolean.valueOf(m2876findChildCorrespondingToFocusEnterOMvw8($this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8, direction, onFound));
            case 4:
                if ($this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8.fetchFocusProperties$ui_release().getCanFocus()) {
                    return onFound.invoke($this$twoDimensionalFocusSearch_u2d_u2dOM_u2dvw8);
                }
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: androidx.compose.ui.focus.FocusTargetModifierNode} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: findChildCorrespondingToFocusEnter--OM-vw8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean m2876findChildCorrespondingToFocusEnterOMvw8(androidx.compose.ui.focus.FocusTargetModifierNode r8, int r9, kotlin.jvm.functions.Function1<? super androidx.compose.ui.focus.FocusTargetModifierNode, java.lang.Boolean> r10) {
        /*
            java.lang.String r0 = "$this$findChildCorrespondingToFocusEnter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "onFound"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            androidx.compose.ui.focus.FocusProperties r0 = r8.fetchFocusProperties$ui_release()
            kotlin.jvm.functions.Function1 r0 = r0.getEnter()
            androidx.compose.ui.focus.FocusDirection r1 = androidx.compose.ui.focus.FocusDirection.m2836boximpl(r9)
            java.lang.Object r0 = r0.invoke(r1)
            r1 = r0
            androidx.compose.ui.focus.FocusRequester r1 = (androidx.compose.ui.focus.FocusRequester) r1
            r2 = 0
            androidx.compose.ui.focus.FocusRequester$Companion r3 = androidx.compose.ui.focus.FocusRequester.Companion
            androidx.compose.ui.focus.FocusRequester r3 = r3.getDefault()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            r2 = 0
            if (r1 != 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r0 = r2
        L_0x002e:
            androidx.compose.ui.focus.FocusRequester r0 = (androidx.compose.ui.focus.FocusRequester) r0
            r1 = 0
            if (r0 == 0) goto L_0x0046
            r2 = 0
            androidx.compose.ui.focus.FocusRequester$Companion r3 = androidx.compose.ui.focus.FocusRequester.Companion
            androidx.compose.ui.focus.FocusRequester r3 = r3.getCancel()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0041
            goto L_0x0045
        L_0x0041:
            boolean r1 = r0.findFocusTarget$ui_release(r10)
        L_0x0045:
            return r1
        L_0x0046:
            r0 = 16
            r3 = 0
            androidx.compose.runtime.collection.MutableVector r4 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.focus.FocusTargetModifierNode[] r5 = new androidx.compose.ui.focus.FocusTargetModifierNode[r0]
            r4.<init>(r5, r1)
            r0 = r4
            r3 = r8
            androidx.compose.ui.node.DelegatableNode r3 = (androidx.compose.ui.node.DelegatableNode) r3
            collectAccessibleChildren(r3, r0)
            int r3 = r0.getSize()
            r4 = 1
            if (r3 > r4) goto L_0x0084
            r3 = r0
            r4 = 0
            boolean r5 = r3.isEmpty()
            if (r5 == 0) goto L_0x0068
            goto L_0x0072
        L_0x0068:
            r2 = 0
            r5 = r3
            r6 = 0
            java.lang.Object[] r7 = r5.getContent()
            r7 = r7[r2]
            r2 = r7
        L_0x0072:
            androidx.compose.ui.focus.FocusTargetModifierNode r2 = (androidx.compose.ui.focus.FocusTargetModifierNode) r2
            if (r2 == 0) goto L_0x0083
            r1 = r2
            r2 = 0
            java.lang.Object r3 = r10.invoke(r1)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r1 = r3.booleanValue()
        L_0x0083:
            return r1
        L_0x0084:
            androidx.compose.ui.focus.FocusDirection$Companion r2 = androidx.compose.ui.focus.FocusDirection.Companion
            int r2 = r2.m2848getEnterdhqQ8s()
            boolean r2 = androidx.compose.ui.focus.FocusDirection.m2839equalsimpl0(r9, r2)
            if (r2 == 0) goto L_0x0099
            androidx.compose.ui.focus.FocusDirection$Companion r2 = androidx.compose.ui.focus.FocusDirection.Companion
            int r2 = r2.m2855getRightdhqQ8s()
            goto L_0x009a
        L_0x0099:
            r2 = r9
        L_0x009a:
            androidx.compose.ui.focus.FocusDirection$Companion r3 = androidx.compose.ui.focus.FocusDirection.Companion
            int r3 = r3.m2855getRightdhqQ8s()
            boolean r3 = androidx.compose.ui.focus.FocusDirection.m2839equalsimpl0(r2, r3)
            if (r3 == 0) goto L_0x00aa
            r3 = r4
            goto L_0x00b4
        L_0x00aa:
            androidx.compose.ui.focus.FocusDirection$Companion r3 = androidx.compose.ui.focus.FocusDirection.Companion
            int r3 = r3.m2847getDowndhqQ8s()
            boolean r3 = androidx.compose.ui.focus.FocusDirection.m2839equalsimpl0(r2, r3)
        L_0x00b4:
            if (r3 == 0) goto L_0x00bf
            androidx.compose.ui.geometry.Rect r3 = androidx.compose.ui.focus.FocusTraversalKt.focusRect(r8)
            androidx.compose.ui.geometry.Rect r3 = topLeft(r3)
            goto L_0x00e0
        L_0x00bf:
            androidx.compose.ui.focus.FocusDirection$Companion r3 = androidx.compose.ui.focus.FocusDirection.Companion
            int r3 = r3.m2851getLeftdhqQ8s()
            boolean r3 = androidx.compose.ui.focus.FocusDirection.m2839equalsimpl0(r2, r3)
            if (r3 == 0) goto L_0x00cc
            goto L_0x00d6
        L_0x00cc:
            androidx.compose.ui.focus.FocusDirection$Companion r3 = androidx.compose.ui.focus.FocusDirection.Companion
            int r3 = r3.m2856getUpdhqQ8s()
            boolean r4 = androidx.compose.ui.focus.FocusDirection.m2839equalsimpl0(r2, r3)
        L_0x00d6:
            if (r4 == 0) goto L_0x00f4
            androidx.compose.ui.geometry.Rect r3 = androidx.compose.ui.focus.FocusTraversalKt.focusRect(r8)
            androidx.compose.ui.geometry.Rect r3 = bottomRight(r3)
        L_0x00e0:
            androidx.compose.ui.focus.FocusTargetModifierNode r4 = m2875findBestCandidate4WY_MpI(r0, r3, r2)
            if (r4 == 0) goto L_0x00f3
            r1 = r4
            r5 = 0
            java.lang.Object r6 = r10.invoke(r1)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r1 = r6.booleanValue()
        L_0x00f3:
            return r1
        L_0x00f4:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r3 = "This function should only be used for 2-D focus search"
            java.lang.String r3 = r3.toString()
            r1.<init>(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.TwoDimensionalFocusSearchKt.m2876findChildCorrespondingToFocusEnterOMvw8(androidx.compose.ui.focus.FocusTargetModifierNode, int, kotlin.jvm.functions.Function1):boolean");
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg  reason: not valid java name */
    private static final boolean m2877generateAndSearchChildren4C6V_qg(FocusTargetModifierNode $this$generateAndSearchChildren_u2d4C6V_qg, FocusTargetModifierNode focusedItem, int direction, Function1<? super FocusTargetModifierNode, Boolean> onFound) {
        if (m2879searchChildren4C6V_qg($this$generateAndSearchChildren_u2d4C6V_qg, focusedItem, direction, onFound)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m2835searchBeyondBoundsOMvw8($this$generateAndSearchChildren_u2d4C6V_qg, direction, new TwoDimensionalFocusSearchKt$generateAndSearchChildren$1($this$generateAndSearchChildren_u2d4C6V_qg, focusedItem, direction, onFound));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg  reason: not valid java name */
    public static final boolean m2879searchChildren4C6V_qg(FocusTargetModifierNode $this$searchChildren_u2d4C6V_qg, FocusTargetModifierNode focusedItem, int direction, Function1<? super FocusTargetModifierNode, Boolean> onFound) {
        int i = direction;
        Function1<? super FocusTargetModifierNode, Boolean> function1 = onFound;
        MutableVector mutableVector = new MutableVector(new FocusTargetModifierNode[16], 0);
        MutableVector $this$searchChildren_4C6V_qg_u24lambda_u247 = mutableVector;
        int mask$iv$iv = NodeKind.m5123constructorimpl(1024);
        DelegatableNode $this$visitChildren$iv$iv = $this$searchChildren_u2d4C6V_qg;
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
                if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                    Modifier.Node node$iv$iv = branch$iv$iv;
                    while (true) {
                        if (node$iv$iv == null) {
                            break;
                        } else if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            Modifier.Node it$iv = node$iv$iv;
                            if (it$iv instanceof FocusTargetModifierNode) {
                                $this$searchChildren_4C6V_qg_u24lambda_u247.add((FocusTargetModifierNode) it$iv);
                            }
                        } else {
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                        }
                    }
                } else {
                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                }
            }
            MutableVector $this$searchChildren_4C6V_qg_u24lambda_u2472 = mutableVector;
            while ($this$searchChildren_4C6V_qg_u24lambda_u2472.isNotEmpty()) {
                FocusTargetModifierNode nextItem = m2875findBestCandidate4WY_MpI($this$searchChildren_4C6V_qg_u24lambda_u2472, FocusTraversalKt.focusRect(focusedItem), i);
                if (nextItem == null) {
                    return false;
                }
                if (nextItem.fetchFocusProperties$ui_release().getCanFocus()) {
                    return function1.invoke(nextItem).booleanValue();
                }
                FocusRequester it = nextItem.fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m2836boximpl(direction));
                if (Intrinsics.areEqual((Object) it, (Object) FocusRequester.Companion.getDefault())) {
                    it = null;
                }
                FocusRequester it2 = it;
                if (it2 != null) {
                    if (Intrinsics.areEqual((Object) it2, (Object) FocusRequester.Companion.getCancel())) {
                        return false;
                    }
                    return it2.findFocusTarget$ui_release(function1);
                } else if (m2877generateAndSearchChildren4C6V_qg(nextItem, focusedItem, i, function1)) {
                    return true;
                } else {
                    $this$searchChildren_4C6V_qg_u24lambda_u2472.remove(nextItem);
                }
            }
            FocusTargetModifierNode focusTargetModifierNode = focusedItem;
            return false;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private static final void collectAccessibleChildren(DelegatableNode $this$collectAccessibleChildren, MutableVector<FocusTargetModifierNode> accessibleChildren) {
        DelegatableNode $this$visitSubtreeIf_u2d6rFNWt0$iv;
        int type$iv;
        boolean z;
        MutableVector<FocusTargetModifierNode> mutableVector = accessibleChildren;
        int type$iv2 = NodeKind.m5123constructorimpl(1024);
        DelegatableNode $this$visitSubtreeIf_u2d6rFNWt0$iv2 = $this$collectAccessibleChildren;
        int mask$iv$iv = type$iv2;
        DelegatableNode $this$visitSubtreeIf$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
        if ($this$visitSubtreeIf$iv$iv.getNode().isAttached()) {
            boolean diveDeeper$iv$iv = false;
            MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$iv$iv = $this$visitSubtreeIf$iv$iv.getNode().getChild$ui_release();
            if (child$iv$iv == null) {
                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitSubtreeIf$iv$iv.getNode());
            } else {
                branches$iv$iv.add(child$iv$iv);
            }
            while (branches$iv$iv.isNotEmpty()) {
                boolean z2 = true;
                Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
                if ((branch$iv$iv.getAggregateChildKindSet$ui_release() & mask$iv$iv) != 0) {
                    Modifier.Node node$iv$iv = branch$iv$iv;
                    while (true) {
                        if (node$iv$iv == null) {
                            break;
                        }
                        if ((node$iv$iv.getKindSet$ui_release() & mask$iv$iv) != 0) {
                            Modifier.Node it$iv = node$iv$iv;
                            if (it$iv instanceof FocusTargetModifierNode) {
                                FocusTargetModifierNode it = (FocusTargetModifierNode) it$iv;
                                if (it.fetchFocusProperties$ui_release().getCanFocus()) {
                                    mutableVector.add(it);
                                    type$iv = type$iv2;
                                    $this$visitSubtreeIf_u2d6rFNWt0$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                                    z = z2;
                                } else {
                                    FocusRequester it2 = it.fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m2836boximpl(FocusDirection.Companion.m2848getEnterdhqQ8s()));
                                    type$iv = type$iv2;
                                    if (Intrinsics.areEqual((Object) it2, (Object) FocusRequester.Companion.getDefault())) {
                                        it2 = null;
                                    }
                                    FocusRequester focusRequester = it2;
                                    if (focusRequester != null) {
                                        FocusRequester it3 = focusRequester;
                                        if (!Intrinsics.areEqual((Object) it3, (Object) FocusRequester.Companion.getCancel())) {
                                            MutableVector this_$iv = it3.getFocusRequesterNodes$ui_release();
                                            FocusRequester focusRequester2 = it3;
                                            int size$iv = this_$iv.getSize();
                                            if (size$iv > 0) {
                                                int i$iv = 0;
                                                Object[] content$iv = this_$iv.getContent();
                                                while (true) {
                                                    $this$visitSubtreeIf_u2d6rFNWt0$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                                                    collectAccessibleChildren((FocusRequesterModifierNode) content$iv[i$iv], mutableVector);
                                                    z = true;
                                                    int i$iv2 = i$iv + 1;
                                                    if (i$iv2 >= size$iv) {
                                                        break;
                                                    }
                                                    i$iv = i$iv2;
                                                    $this$visitSubtreeIf_u2d6rFNWt0$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                                                    mutableVector = accessibleChildren;
                                                }
                                            } else {
                                                $this$visitSubtreeIf_u2d6rFNWt0$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                                                z = true;
                                            }
                                        } else {
                                            $this$visitSubtreeIf_u2d6rFNWt0$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                                            z = true;
                                        }
                                        diveDeeper$iv$iv = false;
                                    } else {
                                        $this$visitSubtreeIf_u2d6rFNWt0$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                                        z = true;
                                        diveDeeper$iv$iv = true;
                                    }
                                }
                            } else {
                                type$iv = type$iv2;
                                $this$visitSubtreeIf_u2d6rFNWt0$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                                z = z2;
                                diveDeeper$iv$iv = z;
                            }
                            if (!diveDeeper$iv$iv) {
                                mutableVector = accessibleChildren;
                                type$iv2 = type$iv;
                                $this$visitSubtreeIf_u2d6rFNWt0$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                                diveDeeper$iv$iv = false;
                                break;
                            }
                        } else {
                            type$iv = type$iv2;
                            $this$visitSubtreeIf_u2d6rFNWt0$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                            z = z2;
                        }
                        node$iv$iv = node$iv$iv.getChild$ui_release();
                        mutableVector = accessibleChildren;
                        z2 = z;
                        type$iv2 = type$iv;
                        $this$visitSubtreeIf_u2d6rFNWt0$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv;
                        diveDeeper$iv$iv = false;
                    }
                }
                DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                mutableVector = accessibleChildren;
                type$iv2 = type$iv2;
                $this$visitSubtreeIf_u2d6rFNWt0$iv2 = $this$visitSubtreeIf_u2d6rFNWt0$iv2;
                diveDeeper$iv$iv = false;
            }
            return;
        }
        int i = type$iv2;
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: findBestCandidate-4WY_MpI  reason: not valid java name */
    private static final FocusTargetModifierNode m2875findBestCandidate4WY_MpI(MutableVector<FocusTargetModifierNode> $this$findBestCandidate_u2d4WY_MpI, Rect focusRect, int direction) {
        Rect rect;
        if (FocusDirection.m2839equalsimpl0(direction, FocusDirection.Companion.m2851getLeftdhqQ8s())) {
            rect = focusRect.translate(focusRect.getWidth() + ((float) 1), 0.0f);
        } else if (FocusDirection.m2839equalsimpl0(direction, FocusDirection.Companion.m2855getRightdhqQ8s())) {
            rect = focusRect.translate(-(focusRect.getWidth() + ((float) 1)), 0.0f);
        } else if (FocusDirection.m2839equalsimpl0(direction, FocusDirection.Companion.m2856getUpdhqQ8s())) {
            rect = focusRect.translate(0.0f, focusRect.getHeight() + ((float) 1));
        } else if (FocusDirection.m2839equalsimpl0(direction, FocusDirection.Companion.m2847getDowndhqQ8s())) {
            rect = focusRect.translate(0.0f, -(focusRect.getHeight() + ((float) 1)));
        } else {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        }
        Rect rect2 = rect;
        FocusTargetModifierNode focusTargetModifierNode = null;
        MutableVector this_$iv = $this$findBestCandidate_u2d4WY_MpI;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                FocusTargetModifierNode candidateNode = (FocusTargetModifierNode) content$iv[i$iv];
                if (FocusTraversalKt.isEligibleForFocusSearch(candidateNode)) {
                    Rect candidateRect = FocusTraversalKt.focusRect(candidateNode);
                    if (m2878isBetterCandidateI7lrPNg(candidateRect, rect2, focusRect, direction)) {
                        rect2 = candidateRect;
                        focusTargetModifierNode = candidateNode;
                    }
                }
                i$iv++;
            } while (i$iv < size$iv);
        }
        return focusTargetModifierNode;
    }

    private static final boolean isBetterCandidate_I7lrPNg$isCandidate(Rect $this$isBetterCandidate_I7lrPNg_u24isCandidate, int $direction, Rect $focusedRect) {
        if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2851getLeftdhqQ8s())) {
            return ($focusedRect.getRight() > $this$isBetterCandidate_I7lrPNg_u24isCandidate.getRight() || $focusedRect.getLeft() >= $this$isBetterCandidate_I7lrPNg_u24isCandidate.getRight()) && $focusedRect.getLeft() > $this$isBetterCandidate_I7lrPNg_u24isCandidate.getLeft();
        }
        if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2855getRightdhqQ8s())) {
            if (($focusedRect.getLeft() < $this$isBetterCandidate_I7lrPNg_u24isCandidate.getLeft() || $focusedRect.getRight() <= $this$isBetterCandidate_I7lrPNg_u24isCandidate.getLeft()) && $focusedRect.getRight() < $this$isBetterCandidate_I7lrPNg_u24isCandidate.getRight()) {
                return true;
            }
            return false;
        } else if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2856getUpdhqQ8s())) {
            if (($focusedRect.getBottom() > $this$isBetterCandidate_I7lrPNg_u24isCandidate.getBottom() || $focusedRect.getTop() >= $this$isBetterCandidate_I7lrPNg_u24isCandidate.getBottom()) && $focusedRect.getTop() > $this$isBetterCandidate_I7lrPNg_u24isCandidate.getTop()) {
                return true;
            }
            return false;
        } else if (!FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2847getDowndhqQ8s())) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        } else if (($focusedRect.getTop() < $this$isBetterCandidate_I7lrPNg_u24isCandidate.getTop() || $focusedRect.getBottom() <= $this$isBetterCandidate_I7lrPNg_u24isCandidate.getTop()) && $focusedRect.getBottom() < $this$isBetterCandidate_I7lrPNg_u24isCandidate.getBottom()) {
            return true;
        } else {
            return false;
        }
    }

    private static final float isBetterCandidate_I7lrPNg$majorAxisDistance(Rect $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance, int $direction, Rect $focusedRect) {
        float majorAxisDistance;
        if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2851getLeftdhqQ8s())) {
            majorAxisDistance = $focusedRect.getLeft() - $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance.getRight();
        } else if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2855getRightdhqQ8s())) {
            majorAxisDistance = $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance.getLeft() - $focusedRect.getRight();
        } else if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2856getUpdhqQ8s())) {
            majorAxisDistance = $focusedRect.getTop() - $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance.getBottom();
        } else if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2847getDowndhqQ8s())) {
            majorAxisDistance = $this$isBetterCandidate_I7lrPNg_u24majorAxisDistance.getTop() - $focusedRect.getBottom();
        } else {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        }
        return Math.max(0.0f, majorAxisDistance);
    }

    private static final float isBetterCandidate_I7lrPNg$minorAxisDistance(Rect $this$isBetterCandidate_I7lrPNg_u24minorAxisDistance, int $direction, Rect $focusedRect) {
        boolean z = true;
        if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2851getLeftdhqQ8s()) ? true : FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2855getRightdhqQ8s())) {
            float f = (float) 2;
            return ($focusedRect.getTop() + ($focusedRect.getHeight() / f)) - ($this$isBetterCandidate_I7lrPNg_u24minorAxisDistance.getTop() + ($this$isBetterCandidate_I7lrPNg_u24minorAxisDistance.getHeight() / f));
        }
        if (!FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2856getUpdhqQ8s())) {
            z = FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2847getDowndhqQ8s());
        }
        if (z) {
            float f2 = (float) 2;
            return ($focusedRect.getLeft() + ($focusedRect.getWidth() / f2)) - ($this$isBetterCandidate_I7lrPNg_u24minorAxisDistance.getLeft() + ($this$isBetterCandidate_I7lrPNg_u24minorAxisDistance.getWidth() / f2));
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final long isBetterCandidate_I7lrPNg$weightedDistance(int $direction, Rect $focusedRect, Rect candidate) {
        long majorAxisDistance = (long) Math.abs(isBetterCandidate_I7lrPNg$majorAxisDistance(candidate, $direction, $focusedRect));
        long minorAxisDistance = (long) Math.abs(isBetterCandidate_I7lrPNg$minorAxisDistance(candidate, $direction, $focusedRect));
        return (((long) 13) * majorAxisDistance * majorAxisDistance) + (minorAxisDistance * minorAxisDistance);
    }

    /* renamed from: isBetterCandidate-I7lrPNg  reason: not valid java name */
    private static final boolean m2878isBetterCandidateI7lrPNg(Rect proposedCandidate, Rect currentCandidate, Rect focusedRect, int direction) {
        if (!isBetterCandidate_I7lrPNg$isCandidate(proposedCandidate, direction, focusedRect)) {
            return false;
        }
        if (!isBetterCandidate_I7lrPNg$isCandidate(currentCandidate, direction, focusedRect)) {
            return true;
        }
        if (m2874beamBeatsI7lrPNg(focusedRect, proposedCandidate, currentCandidate, direction)) {
            return true;
        }
        if (!m2874beamBeatsI7lrPNg(focusedRect, currentCandidate, proposedCandidate, direction) && isBetterCandidate_I7lrPNg$weightedDistance(direction, focusedRect, proposedCandidate) < isBetterCandidate_I7lrPNg$weightedDistance(direction, focusedRect, currentCandidate)) {
            return true;
        }
        return false;
    }

    private static final boolean beamBeats_I7lrPNg$inSourceBeam(Rect $this$beamBeats_I7lrPNg_u24inSourceBeam, int $direction, Rect $source) {
        if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2851getLeftdhqQ8s()) ? true : FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2855getRightdhqQ8s())) {
            return $this$beamBeats_I7lrPNg_u24inSourceBeam.getBottom() > $source.getTop() && $this$beamBeats_I7lrPNg_u24inSourceBeam.getTop() < $source.getBottom();
        }
        if (!(FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2856getUpdhqQ8s()) ? true : FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2847getDowndhqQ8s()))) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        } else if ($this$beamBeats_I7lrPNg_u24inSourceBeam.getRight() <= $source.getLeft() || $this$beamBeats_I7lrPNg_u24inSourceBeam.getLeft() >= $source.getRight()) {
            return false;
        } else {
            return true;
        }
    }

    private static final boolean beamBeats_I7lrPNg$isInDirectionOfSearch(Rect $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch, int $direction, Rect $source) {
        if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2851getLeftdhqQ8s())) {
            return $source.getLeft() >= $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch.getRight();
        }
        if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2855getRightdhqQ8s())) {
            if ($source.getRight() <= $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch.getLeft()) {
                return true;
            }
            return false;
        } else if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2856getUpdhqQ8s())) {
            if ($source.getTop() >= $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch.getBottom()) {
                return true;
            }
            return false;
        } else if (!FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2847getDowndhqQ8s())) {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        } else if ($source.getBottom() <= $this$beamBeats_I7lrPNg_u24isInDirectionOfSearch.getTop()) {
            return true;
        } else {
            return false;
        }
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistance$15(Rect $this$beamBeats_I7lrPNg_u24majorAxisDistance_u2415, int $direction, Rect $source) {
        float majorAxisDistance;
        if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2851getLeftdhqQ8s())) {
            majorAxisDistance = $source.getLeft() - $this$beamBeats_I7lrPNg_u24majorAxisDistance_u2415.getRight();
        } else if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2855getRightdhqQ8s())) {
            majorAxisDistance = $this$beamBeats_I7lrPNg_u24majorAxisDistance_u2415.getLeft() - $source.getRight();
        } else if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2856getUpdhqQ8s())) {
            majorAxisDistance = $source.getTop() - $this$beamBeats_I7lrPNg_u24majorAxisDistance_u2415.getBottom();
        } else if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2847getDowndhqQ8s())) {
            majorAxisDistance = $this$beamBeats_I7lrPNg_u24majorAxisDistance_u2415.getTop() - $source.getBottom();
        } else {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        }
        return Math.max(0.0f, majorAxisDistance);
    }

    private static final float beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(Rect $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge, int $direction, Rect $source) {
        float majorAxisDistance;
        if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2851getLeftdhqQ8s())) {
            majorAxisDistance = $source.getLeft() - $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge.getLeft();
        } else if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2855getRightdhqQ8s())) {
            majorAxisDistance = $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge.getRight() - $source.getRight();
        } else if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2856getUpdhqQ8s())) {
            majorAxisDistance = $source.getTop() - $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge.getTop();
        } else if (FocusDirection.m2839equalsimpl0($direction, FocusDirection.Companion.m2847getDowndhqQ8s())) {
            majorAxisDistance = $this$beamBeats_I7lrPNg_u24majorAxisDistanceToFarEdge.getBottom() - $source.getBottom();
        } else {
            throw new IllegalStateException(InvalidFocusDirection.toString());
        }
        return Math.max(1.0f, majorAxisDistance);
    }

    /* renamed from: beamBeats-I7lrPNg  reason: not valid java name */
    private static final boolean m2874beamBeatsI7lrPNg(Rect source, Rect rect1, Rect rect2, int direction) {
        if (beamBeats_I7lrPNg$inSourceBeam(rect2, direction, source) || !beamBeats_I7lrPNg$inSourceBeam(rect1, direction, source)) {
            return false;
        }
        if (!beamBeats_I7lrPNg$isInDirectionOfSearch(rect2, direction, source)) {
            return true;
        }
        if (FocusDirection.m2839equalsimpl0(direction, FocusDirection.Companion.m2851getLeftdhqQ8s()) || FocusDirection.m2839equalsimpl0(direction, FocusDirection.Companion.m2855getRightdhqQ8s())) {
            return true;
        }
        if (beamBeats_I7lrPNg$majorAxisDistance$15(rect1, direction, source) < beamBeats_I7lrPNg$majorAxisDistanceToFarEdge(rect2, direction, source)) {
            return true;
        }
        return false;
    }

    private static final Rect topLeft(Rect $this$topLeft) {
        return new Rect($this$topLeft.getLeft(), $this$topLeft.getTop(), $this$topLeft.getLeft(), $this$topLeft.getTop());
    }

    private static final Rect bottomRight(Rect $this$bottomRight) {
        return new Rect($this$bottomRight.getRight(), $this$bottomRight.getBottom(), $this$bottomRight.getRight(), $this$bottomRight.getBottom());
    }

    private static final FocusTargetModifierNode activeNode(FocusTargetModifierNode $this$activeNode) {
        if ($this$activeNode.getFocusState() == FocusStateImpl.ActiveParent) {
            FocusTargetModifierNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode($this$activeNode);
            if (findActiveFocusNode != null) {
                return findActiveFocusNode;
            }
            throw new IllegalStateException(NoActiveChild.toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
