package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a \u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0003\u001aE\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u0002H\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\t0\u0007H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u000e\u001aE\u0010\u000f\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u0002H\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\t0\u0007H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u000e\u001a \u0010\u0010\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0003\u001a=\u0010\u0011\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a5\u0010\u0018\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a \u0010\u001b\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0003\u001a \u0010\u001c\u001a\u00020\u0004*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0003\u001a=\u0010\u001d\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00040\u0007H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u0016\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"InvalidFocusDirection", "", "NoActiveChild", "backwardFocusSearch", "", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "onFound", "Lkotlin/Function1;", "forEachItemAfter", "", "T", "Landroidx/compose/runtime/collection/MutableVector;", "item", "action", "(Landroidx/compose/runtime/collection/MutableVector;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachItemBefore", "forwardFocusSearch", "generateAndSearchChildren", "focusedItem", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;Landroidx/compose/ui/focus/FocusTargetModifierNode;ILkotlin/jvm/functions/Function1;)Z", "isRoot", "oneDimensionalFocusSearch", "oneDimensionalFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;ILkotlin/jvm/functions/Function1;)Z", "pickChildForBackwardSearch", "pickChildForForwardSearch", "searchChildren", "searchChildren-4C6V_qg", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: OneDimensionalFocusSearch.kt */
public final class OneDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 1-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: OneDimensionalFocusSearch.kt */
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

    /* renamed from: oneDimensionalFocusSearch--OM-vw8  reason: not valid java name */
    public static final boolean m2871oneDimensionalFocusSearchOMvw8(FocusTargetModifierNode $this$oneDimensionalFocusSearch_u2d_u2dOM_u2dvw8, int direction, Function1<? super FocusTargetModifierNode, Boolean> onFound) {
        Intrinsics.checkNotNullParameter($this$oneDimensionalFocusSearch_u2d_u2dOM_u2dvw8, "$this$oneDimensionalFocusSearch");
        Intrinsics.checkNotNullParameter(onFound, "onFound");
        if (FocusDirection.m2839equalsimpl0(direction, FocusDirection.Companion.m2852getNextdhqQ8s())) {
            return forwardFocusSearch($this$oneDimensionalFocusSearch_u2d_u2dOM_u2dvw8, onFound);
        }
        if (FocusDirection.m2839equalsimpl0(direction, FocusDirection.Companion.m2854getPreviousdhqQ8s())) {
            return backwardFocusSearch($this$oneDimensionalFocusSearch_u2d_u2dOM_u2dvw8, onFound);
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final boolean forwardFocusSearch(FocusTargetModifierNode $this$forwardFocusSearch, Function1<? super FocusTargetModifierNode, Boolean> onFound) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$forwardFocusSearch.getFocusStateImpl$ui_release().ordinal()]) {
            case 1:
                FocusTargetModifierNode focusedChild = FocusTraversalKt.getActiveChild($this$forwardFocusSearch);
                if (focusedChild != null) {
                    return forwardFocusSearch(focusedChild, onFound) || m2870generateAndSearchChildren4C6V_qg($this$forwardFocusSearch, focusedChild, FocusDirection.Companion.m2852getNextdhqQ8s(), onFound);
                }
                throw new IllegalStateException(NoActiveChild.toString());
            case 2:
            case 3:
                return pickChildForForwardSearch($this$forwardFocusSearch, onFound);
            case 4:
                if ($this$forwardFocusSearch.fetchFocusProperties$ui_release().getCanFocus()) {
                    return onFound.invoke($this$forwardFocusSearch).booleanValue();
                }
                return pickChildForForwardSearch($this$forwardFocusSearch, onFound);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final boolean backwardFocusSearch(FocusTargetModifierNode $this$backwardFocusSearch, Function1<? super FocusTargetModifierNode, Boolean> onFound) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$backwardFocusSearch.getFocusStateImpl$ui_release().ordinal()]) {
            case 1:
                FocusTargetModifierNode focusedChild = FocusTraversalKt.getActiveChild($this$backwardFocusSearch);
                if (focusedChild != null) {
                    switch (WhenMappings.$EnumSwitchMapping$0[focusedChild.getFocusStateImpl$ui_release().ordinal()]) {
                        case 1:
                            if (backwardFocusSearch(focusedChild, onFound) || m2870generateAndSearchChildren4C6V_qg($this$backwardFocusSearch, focusedChild, FocusDirection.Companion.m2854getPreviousdhqQ8s(), onFound)) {
                                return true;
                            }
                            if (!$this$backwardFocusSearch.fetchFocusProperties$ui_release().getCanFocus() || !onFound.invoke(focusedChild).booleanValue()) {
                                return false;
                            }
                            return true;
                        case 2:
                        case 3:
                            return m2870generateAndSearchChildren4C6V_qg($this$backwardFocusSearch, focusedChild, FocusDirection.Companion.m2854getPreviousdhqQ8s(), onFound);
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
                return pickChildForBackwardSearch($this$backwardFocusSearch, onFound);
            case 4:
                if (pickChildForBackwardSearch($this$backwardFocusSearch, onFound)) {
                    return true;
                }
                if ($this$backwardFocusSearch.fetchFocusProperties$ui_release().getCanFocus() ? onFound.invoke($this$backwardFocusSearch).booleanValue() : false) {
                    return true;
                }
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg  reason: not valid java name */
    private static final boolean m2870generateAndSearchChildren4C6V_qg(FocusTargetModifierNode $this$generateAndSearchChildren_u2d4C6V_qg, FocusTargetModifierNode focusedItem, int direction, Function1<? super FocusTargetModifierNode, Boolean> onFound) {
        if (m2872searchChildren4C6V_qg($this$generateAndSearchChildren_u2d4C6V_qg, focusedItem, direction, onFound)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m2835searchBeyondBoundsOMvw8($this$generateAndSearchChildren_u2d4C6V_qg, direction, new OneDimensionalFocusSearchKt$generateAndSearchChildren$1($this$generateAndSearchChildren_u2d4C6V_qg, focusedItem, direction, onFound));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg  reason: not valid java name */
    public static final boolean m2872searchChildren4C6V_qg(FocusTargetModifierNode $this$searchChildren_u2d4C6V_qg, FocusTargetModifierNode focusedItem, int direction, Function1<? super FocusTargetModifierNode, Boolean> onFound) {
        FocusTargetModifierNode focusTargetModifierNode = $this$searchChildren_u2d4C6V_qg;
        FocusTargetModifierNode focusTargetModifierNode2 = focusedItem;
        int i = direction;
        Function1<? super FocusTargetModifierNode, Boolean> function1 = onFound;
        if ($this$searchChildren_u2d4C6V_qg.getFocusStateImpl$ui_release() == FocusStateImpl.ActiveParent) {
            MutableVector mutableVector = new MutableVector(new FocusTargetModifierNode[16], 0);
            MutableVector $this$searchChildren_4C6V_qg_u24lambda_u242 = mutableVector;
            DelegatableNode $this$visitChildren_u2d6rFNWt0$iv = focusTargetModifierNode;
            int mask$iv$iv = NodeKind.m5123constructorimpl(1024);
            DelegatableNode $this$visitChildren$iv$iv = $this$visitChildren_u2d6rFNWt0$iv;
            if ($this$visitChildren$iv$iv.getNode().isAttached()) {
                DelegatableNode delegatableNode = $this$visitChildren_u2d6rFNWt0$iv;
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
                                MutableVector branches$iv$iv2 = branches$iv$iv;
                                if (it$iv instanceof FocusTargetModifierNode) {
                                    $this$searchChildren_4C6V_qg_u24lambda_u242.add((FocusTargetModifierNode) it$iv);
                                }
                                branches$iv$iv = branches$iv$iv2;
                            } else {
                                node$iv$iv = node$iv$iv.getChild$ui_release();
                            }
                        }
                    } else {
                        DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                    }
                }
                MutableVector $this$searchChildren_4C6V_qg_u24lambda_u2422 = mutableVector;
                $this$searchChildren_4C6V_qg_u24lambda_u2422.sortWith(FocusableChildrenComparator.INSTANCE);
                if (FocusDirection.m2839equalsimpl0(i, FocusDirection.Companion.m2852getNextdhqQ8s())) {
                    MutableVector $this$forEachItemAfter$iv = $this$searchChildren_4C6V_qg_u24lambda_u2422;
                    boolean itemFound$iv = false;
                    IntRange intRange = new IntRange(0, $this$forEachItemAfter$iv.getSize() - 1);
                    int index$iv = intRange.getFirst();
                    int last = intRange.getLast();
                    if (index$iv <= last) {
                        while (true) {
                            if (itemFound$iv) {
                                FocusTargetModifierNode child = (FocusTargetModifierNode) $this$forEachItemAfter$iv.getContent()[index$iv];
                                if (FocusTraversalKt.isEligibleForFocusSearch(child) && forwardFocusSearch(child, function1)) {
                                    return true;
                                }
                            }
                            if (Intrinsics.areEqual($this$forEachItemAfter$iv.getContent()[index$iv], (Object) focusTargetModifierNode2)) {
                                itemFound$iv = true;
                            }
                            if (index$iv == last) {
                                break;
                            }
                            index$iv++;
                        }
                    }
                } else if (FocusDirection.m2839equalsimpl0(i, FocusDirection.Companion.m2854getPreviousdhqQ8s())) {
                    MutableVector $this$forEachItemBefore$iv = $this$searchChildren_4C6V_qg_u24lambda_u2422;
                    boolean itemFound$iv2 = false;
                    IntRange intRange2 = new IntRange(0, $this$forEachItemBefore$iv.getSize() - 1);
                    int first = intRange2.getFirst();
                    int index$iv2 = intRange2.getLast();
                    if (first <= index$iv2) {
                        while (true) {
                            if (itemFound$iv2) {
                                FocusTargetModifierNode child2 = (FocusTargetModifierNode) $this$forEachItemBefore$iv.getContent()[index$iv2];
                                if (FocusTraversalKt.isEligibleForFocusSearch(child2) && backwardFocusSearch(child2, function1)) {
                                    return true;
                                }
                            }
                            if (Intrinsics.areEqual($this$forEachItemBefore$iv.getContent()[index$iv2], (Object) focusTargetModifierNode2)) {
                                itemFound$iv2 = true;
                            }
                            if (index$iv2 == first) {
                                break;
                            }
                            index$iv2--;
                        }
                    }
                } else {
                    throw new IllegalStateException(InvalidFocusDirection.toString());
                }
                if (FocusDirection.m2839equalsimpl0(i, FocusDirection.Companion.m2852getNextdhqQ8s()) || !$this$searchChildren_u2d4C6V_qg.fetchFocusProperties$ui_release().getCanFocus() || isRoot($this$searchChildren_u2d4C6V_qg)) {
                    return false;
                }
                return function1.invoke(focusTargetModifierNode).booleanValue();
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("This function should only be used within a parent that has focus.".toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean pickChildForForwardSearch(androidx.compose.ui.focus.FocusTargetModifierNode r17, kotlin.jvm.functions.Function1<? super androidx.compose.ui.focus.FocusTargetModifierNode, java.lang.Boolean> r18) {
        /*
            r0 = 16
            r1 = 0
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.focus.FocusTargetModifierNode[] r3 = new androidx.compose.ui.focus.FocusTargetModifierNode[r0]
            r4 = 0
            r2.<init>(r3, r4)
            r0 = r2
            r1 = 0
            r3 = r17
            androidx.compose.ui.node.DelegatableNode r3 = (androidx.compose.ui.node.DelegatableNode) r3
            r5 = 0
            r6 = 1024(0x400, float:1.435E-42)
            int r5 = androidx.compose.ui.node.NodeKind.m5123constructorimpl(r6)
            r6 = 0
            r7 = r5
            r8 = r3
            r9 = 0
            androidx.compose.ui.Modifier$Node r10 = r8.getNode()
            boolean r10 = r10.isAttached()
            if (r10 == 0) goto L_0x00cc
            r10 = 0
            r11 = 16
            r12 = 0
            androidx.compose.runtime.collection.MutableVector r13 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r14 = new androidx.compose.ui.Modifier.Node[r11]
            r13.<init>(r14, r4)
            r10 = r13
            androidx.compose.ui.Modifier$Node r11 = r8.getNode()
            androidx.compose.ui.Modifier$Node r11 = r11.getChild$ui_release()
            if (r11 != 0) goto L_0x0048
            androidx.compose.ui.Modifier$Node r12 = r8.getNode()
            androidx.compose.ui.node.DelegatableNodeKt.addLayoutNodeChildren(r10, r12)
            goto L_0x004b
        L_0x0048:
            r10.add(r11)
        L_0x004b:
            boolean r12 = r10.isNotEmpty()
            r13 = 1
            if (r12 == 0) goto L_0x008e
            r12 = r10
            r14 = 0
            int r15 = r12.getSize()
            int r15 = r15 - r13
            java.lang.Object r12 = r10.removeAt(r15)
            androidx.compose.ui.Modifier$Node r12 = (androidx.compose.ui.Modifier.Node) r12
            int r13 = r12.getAggregateChildKindSet$ui_release()
            r13 = r13 & r7
            if (r13 != 0) goto L_0x006a
            androidx.compose.ui.node.DelegatableNodeKt.addLayoutNodeChildren(r10, r12)
            goto L_0x004b
        L_0x006a:
            r13 = r12
        L_0x006b:
            if (r13 == 0) goto L_0x008c
            int r14 = r13.getKindSet$ui_release()
            r14 = r14 & r7
            if (r14 == 0) goto L_0x0086
            r14 = r13
            r15 = 0
            boolean r4 = r14 instanceof androidx.compose.ui.focus.FocusTargetModifierNode
            if (r4 == 0) goto L_0x0083
            r4 = r14
            androidx.compose.ui.focus.FocusTargetModifierNode r4 = (androidx.compose.ui.focus.FocusTargetModifierNode) r4
            r16 = 0
            r0.add(r4)
        L_0x0083:
            r4 = 0
            goto L_0x004b
        L_0x0086:
            androidx.compose.ui.Modifier$Node r13 = r13.getChild$ui_release()
            r4 = 0
            goto L_0x006b
        L_0x008c:
            r4 = 0
            goto L_0x004b
        L_0x008e:
            r0 = r2
            androidx.compose.ui.focus.FocusableChildrenComparator r1 = androidx.compose.ui.focus.FocusableChildrenComparator.INSTANCE
            java.util.Comparator r1 = (java.util.Comparator) r1
            r0.sortWith(r1)
            r1 = r0
            r2 = 0
            int r3 = r1.getSize()
            if (r3 <= 0) goto L_0x00c8
            r4 = 0
            java.lang.Object[] r5 = r1.getContent()
        L_0x00a7:
            r6 = r5[r4]
            androidx.compose.ui.focus.FocusTargetModifierNode r6 = (androidx.compose.ui.focus.FocusTargetModifierNode) r6
            r7 = 0
            boolean r8 = androidx.compose.ui.focus.FocusTraversalKt.isEligibleForFocusSearch(r6)
            if (r8 == 0) goto L_0x00bc
            r10 = r18
            boolean r8 = forwardFocusSearch(r6, r10)
            if (r8 == 0) goto L_0x00be
            r6 = r13
            goto L_0x00bf
        L_0x00bc:
            r10 = r18
        L_0x00be:
            r6 = 0
        L_0x00bf:
            if (r6 == 0) goto L_0x00c3
            r4 = r13
            goto L_0x00cb
        L_0x00c3:
            int r4 = r4 + 1
            if (r4 < r3) goto L_0x00a7
            goto L_0x00ca
        L_0x00c8:
            r10 = r18
        L_0x00ca:
            r4 = 0
        L_0x00cb:
            return r4
        L_0x00cc:
            r10 = r18
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r4 = "Check failed."
            java.lang.String r4 = r4.toString()
            r2.<init>(r4)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.OneDimensionalFocusSearchKt.pickChildForForwardSearch(androidx.compose.ui.focus.FocusTargetModifierNode, kotlin.jvm.functions.Function1):boolean");
    }

    private static final boolean pickChildForBackwardSearch(FocusTargetModifierNode $this$pickChildForBackwardSearch, Function1<? super FocusTargetModifierNode, Boolean> onFound) {
        MutableVector mutableVector = new MutableVector(new FocusTargetModifierNode[16], 0);
        MutableVector $this$pickChildForBackwardSearch_u24lambda_u249 = mutableVector;
        int mask$iv$iv = NodeKind.m5123constructorimpl(1024);
        DelegatableNode $this$visitChildren$iv$iv = $this$pickChildForBackwardSearch;
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
                                $this$pickChildForBackwardSearch_u24lambda_u249.add((FocusTargetModifierNode) it$iv);
                            }
                        } else {
                            node$iv$iv = node$iv$iv.getChild$ui_release();
                        }
                    }
                } else {
                    DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
                }
            }
            MutableVector children = mutableVector;
            children.sortWith(FocusableChildrenComparator.INSTANCE);
            MutableVector this_$iv = children;
            int size$iv = this_$iv.getSize();
            if (size$iv > 0) {
                int i$iv = size$iv - 1;
                Object[] content$iv = this_$iv.getContent();
                do {
                    FocusTargetModifierNode it = (FocusTargetModifierNode) content$iv[i$iv];
                    if (!FocusTraversalKt.isEligibleForFocusSearch(it)) {
                        Function1<? super FocusTargetModifierNode, Boolean> function1 = onFound;
                    } else if (backwardFocusSearch(it, onFound)) {
                        return true;
                    }
                    i$iv--;
                } while (i$iv >= 0);
                return false;
            }
            Function1<? super FocusTargetModifierNode, Boolean> function12 = onFound;
            return false;
        }
        Function1<? super FocusTargetModifierNode, Boolean> function13 = onFound;
        throw new IllegalStateException("Check failed.".toString());
    }

    private static final boolean isRoot(FocusTargetModifierNode $this$isRoot) {
        Modifier.Node nearestAncestor = DelegatableNodeKt.nearestAncestor($this$isRoot, NodeKind.m5123constructorimpl(1024));
        if (!(nearestAncestor instanceof FocusTargetModifierNode)) {
            nearestAncestor = null;
        }
        return ((FocusTargetModifierNode) nearestAncestor) == null;
    }

    private static final <T> void forEachItemAfter(MutableVector<T> $this$forEachItemAfter, T item, Function1<? super T, Unit> action) {
        boolean itemFound = false;
        IntRange intRange = new IntRange(0, $this$forEachItemAfter.getSize() - 1);
        int index = intRange.getFirst();
        int last = intRange.getLast();
        if (index <= last) {
            while (true) {
                if (itemFound) {
                    action.invoke($this$forEachItemAfter.getContent()[index]);
                }
                if (Intrinsics.areEqual($this$forEachItemAfter.getContent()[index], (Object) item)) {
                    itemFound = true;
                }
                if (index != last) {
                    index++;
                } else {
                    return;
                }
            }
        }
    }

    private static final <T> void forEachItemBefore(MutableVector<T> $this$forEachItemBefore, T item, Function1<? super T, Unit> action) {
        boolean itemFound = false;
        IntRange intRange = new IntRange(0, $this$forEachItemBefore.getSize() - 1);
        int first = intRange.getFirst();
        int index = intRange.getLast();
        if (first <= index) {
            while (true) {
                if (itemFound) {
                    action.invoke($this$forEachItemBefore.getContent()[index]);
                }
                if (Intrinsics.areEqual($this$forEachItemBefore.getContent()[index], (Object) item)) {
                    itemFound = true;
                }
                if (index != first) {
                    index--;
                } else {
                    return;
                }
            }
        }
    }
}
