package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u001d\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'H\u0016J\n\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001d\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.J\b\u0010/\u001a\u00020\u0005H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u000202H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u000203H\u0016J\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0016H\u0016J\b\u00104\u001a\u00020\u0005H\u0016J\u001d\u00105\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u0010.J\u000e\u00107\u001a\u0004\u0018\u000108*\u000209H\u0002J\\\u0010:\u001a\u00020\u0005\"\n\b\u0000\u0010;\u0018\u0001*\u000209*\u0002H;2\f\u0010<\u001a\b\u0012\u0004\u0012\u0002H;0=2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u0002H;\u0012\u0004\u0012\u00020\u00050\u0003H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010AR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006B"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function1;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier$annotations", "()V", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "getRootFocusNode$ui_release$annotations", "getRootFocusNode$ui_release", "()Landroidx/compose/ui/focus/FocusTargetModifierNode;", "setRootFocusNode$ui_release", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;)V", "clearFocus", "force", "", "refreshFocusEvents", "dispatchKeyEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "dispatchKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchRotaryEvent", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "getFocusRect", "Landroidx/compose/ui/geometry/Rect;", "moveFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "moveFocus-3ESFkO8", "(I)Z", "releaseFocus", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "takeFocus", "wrapAroundFocus", "wrapAroundFocus-3ESFkO8", "lastLocalKeyInputNode", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/DelegatableNode;", "traverseAncestors", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "onPreVisit", "onVisit", "traverseAncestors-Y-YKmho", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusOwnerImpl.kt */
public final class FocusOwnerImpl implements FocusOwner {
    private final FocusInvalidationManager focusInvalidationManager;
    public LayoutDirection layoutDirection;
    private final Modifier modifier;
    private FocusTargetModifierNode rootFocusNode = new FocusTargetModifierNode();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusOwnerImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
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

    public static /* synthetic */ void getModifier$annotations() {
    }

    public static /* synthetic */ void getRootFocusNode$ui_release$annotations() {
    }

    public FocusOwnerImpl(Function1<? super Function0<Unit>, Unit> onRequestApplyChangesListener) {
        Intrinsics.checkNotNullParameter(onRequestApplyChangesListener, "onRequestApplyChangesListener");
        this.focusInvalidationManager = new FocusInvalidationManager(onRequestApplyChangesListener);
        this.modifier = new FocusOwnerImpl$modifier$1(this);
    }

    public final FocusTargetModifierNode getRootFocusNode$ui_release() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui_release(FocusTargetModifierNode focusTargetModifierNode) {
        Intrinsics.checkNotNullParameter(focusTargetModifierNode, "<set-?>");
        this.rootFocusNode = focusTargetModifierNode;
    }

    public Modifier getModifier() {
        return this.modifier;
    }

    public LayoutDirection getLayoutDirection() {
        LayoutDirection layoutDirection2 = this.layoutDirection;
        if (layoutDirection2 != null) {
            return layoutDirection2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutDirection");
        return null;
    }

    public void setLayoutDirection(LayoutDirection layoutDirection2) {
        Intrinsics.checkNotNullParameter(layoutDirection2, "<set-?>");
        this.layoutDirection = layoutDirection2;
    }

    public void takeFocus() {
        if (this.rootFocusNode.getFocusStateImpl$ui_release() == FocusStateImpl.Inactive) {
            this.rootFocusNode.setFocusStateImpl$ui_release(FocusStateImpl.Active);
        }
    }

    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    public void clearFocus(boolean force) {
        clearFocus(force, true);
    }

    public void clearFocus(boolean force, boolean refreshFocusEvents) {
        FocusStateImpl focusStateImpl;
        FocusStateImpl rootInitialState = this.rootFocusNode.getFocusStateImpl$ui_release();
        if (FocusTransactionsKt.clearFocus(this.rootFocusNode, force, refreshFocusEvents)) {
            FocusTargetModifierNode focusTargetModifierNode = this.rootFocusNode;
            switch (WhenMappings.$EnumSwitchMapping$0[rootInitialState.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    focusStateImpl = FocusStateImpl.Active;
                    break;
                case 4:
                    focusStateImpl = FocusStateImpl.Inactive;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            focusTargetModifierNode.setFocusStateImpl$ui_release(focusStateImpl);
        }
    }

    /* renamed from: moveFocus-3ESFkO8  reason: not valid java name */
    public boolean m2862moveFocus3ESFkO8(int focusDirection) {
        FocusTargetModifierNode source = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (source == null) {
            return false;
        }
        FocusRequester next = FocusTraversalKt.m2867customFocusSearchOMvw8(source, focusDirection, getLayoutDirection());
        if (Intrinsics.areEqual((Object) next, (Object) FocusRequester.Companion.getCancel())) {
            return false;
        }
        if (!Intrinsics.areEqual((Object) next, (Object) FocusRequester.Companion.getDefault())) {
            return next.findFocusTarget$ui_release(FocusOwnerImpl$moveFocus$1.INSTANCE);
        }
        if (FocusTraversalKt.m2868focusSearchsMXa3k8(this.rootFocusNode, focusDirection, getLayoutDirection(), new FocusOwnerImpl$moveFocus$foundNextItem$1(source)) || m2860wrapAroundFocus3ESFkO8(focusDirection)) {
            return true;
        }
        return false;
    }

    /* renamed from: dispatchKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m2861dispatchKeyEventZmokQxo(KeyEvent keyEvent) {
        KeyEvent keyEvent2 = keyEvent;
        Intrinsics.checkNotNullParameter(keyEvent2, "keyEvent");
        FocusTargetModifierNode activeFocusTarget = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (activeFocusTarget != null) {
            DelegatableNode $this$nearestAncestor_u2d64DMado$iv = lastLocalKeyInputNode(activeFocusTarget);
            List ancestors$iv = null;
            if ($this$nearestAncestor_u2d64DMado$iv == null) {
                DelegatableNode nearestAncestor = DelegatableNodeKt.nearestAncestor(activeFocusTarget, NodeKind.m5123constructorimpl(8192));
                if (!(nearestAncestor instanceof KeyInputModifierNode)) {
                    nearestAncestor = null;
                }
                $this$nearestAncestor_u2d64DMado$iv = (KeyInputModifierNode) nearestAncestor;
            }
            if ($this$nearestAncestor_u2d64DMado$iv == null) {
                return false;
            }
            DelegatableNode $this$traverseAncestors_u2dY_u2dYKmho$iv = $this$nearestAncestor_u2d64DMado$iv;
            List ancestors = DelegatableNodeKt.ancestors($this$traverseAncestors_u2dY_u2dYKmho$iv, NodeKind.m5123constructorimpl(8192));
            if (ancestors instanceof List) {
                ancestors$iv = ancestors;
            }
            if (ancestors$iv != null) {
                List $this$fastForEachReversed$iv$iv = ancestors$iv;
                int size = $this$fastForEachReversed$iv$iv.size() - 1;
                if (size >= 0) {
                    do {
                        int index$iv$iv = size;
                        size--;
                        if (((KeyInputModifierNode) $this$fastForEachReversed$iv$iv.get(index$iv$iv)).m4534onPreKeyEventZmokQxo(keyEvent2)) {
                            return true;
                        }
                    } while (size >= 0);
                }
            }
            if (((KeyInputModifierNode) $this$traverseAncestors_u2dY_u2dYKmho$iv).m4534onPreKeyEventZmokQxo(keyEvent2) || ((KeyInputModifierNode) $this$traverseAncestors_u2dY_u2dYKmho$iv).m4533onKeyEventZmokQxo(keyEvent2)) {
                return true;
            }
            if (ancestors$iv == null) {
                return false;
            }
            List $this$fastForEach$iv$iv = ancestors$iv;
            int size2 = $this$fastForEach$iv$iv.size();
            for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                if (((KeyInputModifierNode) $this$fastForEach$iv$iv.get(index$iv$iv2)).m4533onKeyEventZmokQxo(keyEvent2)) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalStateException("Event can't be processed because we do not have an active focus target.".toString());
    }

    public boolean dispatchRotaryEvent(RotaryScrollEvent event) {
        RotaryInputModifierNode rotaryInputModifierNode;
        RotaryScrollEvent rotaryScrollEvent = event;
        Intrinsics.checkNotNullParameter(rotaryScrollEvent, NotificationCompat.CATEGORY_EVENT);
        FocusTargetModifierNode $this$nearestAncestor_u2d64DMado$iv = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        List ancestors$iv = null;
        if ($this$nearestAncestor_u2d64DMado$iv != null) {
            Modifier.Node nearestAncestor = DelegatableNodeKt.nearestAncestor($this$nearestAncestor_u2d64DMado$iv, NodeKind.m5123constructorimpl(16384));
            if (!(nearestAncestor instanceof RotaryInputModifierNode)) {
                nearestAncestor = null;
            }
            rotaryInputModifierNode = (RotaryInputModifierNode) nearestAncestor;
        } else {
            rotaryInputModifierNode = null;
        }
        RotaryInputModifierNode focusedRotaryInputNode = rotaryInputModifierNode;
        if (focusedRotaryInputNode == null) {
            return false;
        }
        DelegatableNode $this$traverseAncestors_u2dY_u2dYKmho$iv = focusedRotaryInputNode;
        List ancestors = DelegatableNodeKt.ancestors($this$traverseAncestors_u2dY_u2dYKmho$iv, NodeKind.m5123constructorimpl(16384));
        if (ancestors instanceof List) {
            ancestors$iv = ancestors;
        }
        if (ancestors$iv != null) {
            List $this$fastForEachReversed$iv$iv = ancestors$iv;
            int size = $this$fastForEachReversed$iv$iv.size() - 1;
            if (size >= 0) {
                do {
                    int index$iv$iv = size;
                    size--;
                    if (((RotaryInputModifierNode) $this$fastForEachReversed$iv$iv.get(index$iv$iv)).onPreRotaryScrollEvent(rotaryScrollEvent)) {
                        return true;
                    }
                } while (size >= 0);
            }
        }
        if (((RotaryInputModifierNode) $this$traverseAncestors_u2dY_u2dYKmho$iv).onPreRotaryScrollEvent(rotaryScrollEvent) || ((RotaryInputModifierNode) $this$traverseAncestors_u2dY_u2dYKmho$iv).onRotaryScrollEvent(rotaryScrollEvent)) {
            return true;
        }
        if (ancestors$iv == null) {
            return false;
        }
        List $this$fastForEach$iv$iv = ancestors$iv;
        int size2 = $this$fastForEach$iv$iv.size();
        for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
            if (((RotaryInputModifierNode) $this$fastForEach$iv$iv.get(index$iv$iv2)).onRotaryScrollEvent(rotaryScrollEvent)) {
                return true;
            }
        }
        return false;
    }

    public void scheduleInvalidation(FocusTargetModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    public void scheduleInvalidation(FocusEventModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    public void scheduleInvalidation(FocusPropertiesModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    /* renamed from: traverseAncestors-Y-YKmho  reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m2859traverseAncestorsYYKmho(T $this$traverseAncestors_u2dY_u2dYKmho, int type, Function1<? super T, Unit> onPreVisit, Function1<? super T, Unit> onVisit) {
        List ancestors = DelegatableNodeKt.ancestors($this$traverseAncestors_u2dY_u2dYKmho, type);
        if (!(ancestors instanceof List)) {
            ancestors = null;
        }
        List ancestors2 = ancestors;
        if (ancestors2 != null) {
            List $this$fastForEachReversed$iv = ancestors2;
            int size = $this$fastForEachReversed$iv.size() - 1;
            if (size >= 0) {
                do {
                    int index$iv = size;
                    size--;
                    onPreVisit.invoke($this$fastForEachReversed$iv.get(index$iv));
                } while (size >= 0);
            }
        }
        onPreVisit.invoke($this$traverseAncestors_u2dY_u2dYKmho);
        onVisit.invoke($this$traverseAncestors_u2dY_u2dYKmho);
        if (ancestors2 != null) {
            List $this$fastForEach$iv = ancestors2;
            int size2 = $this$fastForEach$iv.size();
            for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                onVisit.invoke($this$fastForEach$iv.get(index$iv2));
            }
        }
    }

    public Rect getFocusRect() {
        FocusTargetModifierNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(findActiveFocusNode);
        }
        return null;
    }

    private final KeyInputModifierNode lastLocalKeyInputNode(DelegatableNode $this$lastLocalKeyInputNode) {
        Modifier.Node node = null;
        int mask$iv = NodeKind.m5123constructorimpl(1024) | NodeKind.m5123constructorimpl(8192);
        DelegatableNode $this$visitLocalChildren$iv = $this$lastLocalKeyInputNode;
        if ($this$visitLocalChildren$iv.getNode().isAttached()) {
            Modifier.Node self$iv = $this$visitLocalChildren$iv.getNode();
            if ((self$iv.getAggregateChildKindSet$ui_release() & mask$iv) != 0) {
                for (Modifier.Node next$iv = self$iv.getChild$ui_release(); next$iv != null; next$iv = next$iv.getChild$ui_release()) {
                    if ((next$iv.getKindSet$ui_release() & mask$iv) != 0) {
                        Modifier.Node modifierNode = next$iv;
                        if ((modifierNode.getKindSet$ui_release() & NodeKind.m5123constructorimpl(1024)) != 0) {
                            return (KeyInputModifierNode) node;
                        }
                        if (modifierNode instanceof KeyInputModifierNode) {
                            node = modifierNode;
                        } else {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    }
                }
            }
            return node;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: wrapAroundFocus-3ESFkO8  reason: not valid java name */
    private final boolean m2860wrapAroundFocus3ESFkO8(int focusDirection) {
        if (!this.rootFocusNode.getFocusState().getHasFocus() || this.rootFocusNode.getFocusState().isFocused()) {
            return false;
        }
        if (!(FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2852getNextdhqQ8s()) ? true : FocusDirection.m2839equalsimpl0(focusDirection, FocusDirection.Companion.m2854getPreviousdhqQ8s()))) {
            return false;
        }
        clearFocus(false);
        if (!this.rootFocusNode.getFocusState().isFocused()) {
            return false;
        }
        return m2862moveFocus3ESFkO8(focusDirection);
    }
}
