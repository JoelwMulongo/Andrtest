package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u00002\u00020\u0001:\u0001FB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020\bJ%\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u001bH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b*J%\u0010+\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u001bH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b,J\u000e\u0010-\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003J\u0018\u0010.\u001a\u00020\b2\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020$\u0018\u000100J#\u0010.\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u001bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u0006\u00103\u001a\u00020$J\u000e\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020\u0003J\u0017\u00106\u001a\u00020$2\f\u00107\u001a\b\u0012\u0004\u0012\u00020$00H\bJ\u0010\u00108\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003H\u0002J\u000e\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020\u0013J\u0010\u0010;\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0003H\u0002J\u0010\u0010<\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003H\u0002J\u0018\u0010=\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\bJ\u0018\u0010?\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\bJ\u000e\u0010@\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0003J\u0018\u0010A\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\bJ\u0018\u0010B\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\bJ\u001b\u0010C\u001a\u00020$2\u0006\u0010)\u001a\u00020\u001bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010ER\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\u00020\b*\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u00020\b*\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0018\u0010!\u001a\u00020\b*\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "consistencyChecker", "Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "duringMeasureLayout", "", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "<set-?>", "", "measureIteration", "getMeasureIteration", "()J", "onLayoutCompletedListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "onPositionedDispatcher", "Landroidx/compose/ui/node/OnPositionedDispatcher;", "postponedMeasureRequests", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSet;", "rootConstraints", "Landroidx/compose/ui/unit/Constraints;", "canAffectParent", "getCanAffectParent", "(Landroidx/compose/ui/node/LayoutNode;)Z", "canAffectParentInLookahead", "getCanAffectParentInLookahead", "measureAffectsParent", "getMeasureAffectsParent", "callOnLayoutCompletedListeners", "", "dispatchOnPositionedCallbacks", "forceDispatch", "doLookaheadRemeasure", "layoutNode", "constraints", "doLookaheadRemeasure-sdFAvZA", "doRemeasure", "doRemeasure-sdFAvZA", "forceMeasureTheSubtree", "measureAndLayout", "onLayout", "Lkotlin/Function0;", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "measureOnly", "onNodeDetached", "node", "performMeasureAndLayout", "block", "recurseRemeasure", "registerOnLayoutCompletedListener", "listener", "remeasureAndRelayoutIfNeeded", "remeasureOnly", "requestLookaheadRelayout", "forced", "requestLookaheadRemeasure", "requestOnPositionedCallback", "requestRelayout", "requestRemeasure", "updateRootConstraints", "updateRootConstraints-BRTryo0", "(J)V", "PostponedRequest", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MeasureAndLayoutDelegate.kt */
public final class MeasureAndLayoutDelegate {
    private final LayoutTreeConsistencyChecker consistencyChecker;
    private boolean duringMeasureLayout;
    private long measureIteration = 1;
    private final MutableVector<Owner.OnLayoutCompletedListener> onLayoutCompletedListeners = new MutableVector<>(new Owner.OnLayoutCompletedListener[16], 0);
    private final OnPositionedDispatcher onPositionedDispatcher = new OnPositionedDispatcher();
    private final MutableVector<PostponedRequest> postponedMeasureRequests;
    private final DepthSortedSet relayoutNodes;
    /* access modifiers changed from: private */
    public final LayoutNode root;
    private Constraints rootConstraints;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MeasureAndLayoutDelegate.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutNode.LayoutState.values().length];
            try {
                iArr[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[LayoutNode.LayoutState.Idle.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MeasureAndLayoutDelegate(LayoutNode root2) {
        LayoutTreeConsistencyChecker layoutTreeConsistencyChecker;
        Intrinsics.checkNotNullParameter(root2, "root");
        this.root = root2;
        DepthSortedSet depthSortedSet = new DepthSortedSet(Owner.Companion.getEnableExtraAssertions());
        this.relayoutNodes = depthSortedSet;
        MutableVector<PostponedRequest> mutableVector = new MutableVector<>(new PostponedRequest[16], 0);
        this.postponedMeasureRequests = mutableVector;
        if (Owner.Companion.getEnableExtraAssertions()) {
            layoutTreeConsistencyChecker = new LayoutTreeConsistencyChecker(root2, depthSortedSet, mutableVector.asMutableList());
        } else {
            layoutTreeConsistencyChecker = null;
        }
        this.consistencyChecker = layoutTreeConsistencyChecker;
    }

    public final boolean getHasPendingMeasureOrLayout() {
        return !this.relayoutNodes.isEmpty();
    }

    public final long getMeasureIteration() {
        if (this.duringMeasureLayout) {
            return this.measureIteration;
        }
        throw new IllegalArgumentException("measureIteration should be only used during the measure/layout pass".toString());
    }

    /* renamed from: updateRootConstraints-BRTryo0  reason: not valid java name */
    public final void m5067updateRootConstraintsBRTryo0(long constraints) {
        Constraints constraints2 = this.rootConstraints;
        if (constraints2 == null ? false : Constraints.m5923equalsimpl0(constraints2.m5936unboximpl(), constraints)) {
            return;
        }
        if (!this.duringMeasureLayout) {
            this.rootConstraints = Constraints.m5918boximpl(constraints);
            this.root.markMeasurePending$ui_release();
            this.relayoutNodes.add(this.root);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static /* synthetic */ boolean requestLookaheadRemeasure$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, z);
    }

    public final boolean requestLookaheadRemeasure(LayoutNode layoutNode, boolean forced) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (layoutNode.getMLookaheadScope$ui_release() != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()]) {
                case 1:
                    return false;
                case 2:
                case 3:
                case 4:
                    this.postponedMeasureRequests.add(new PostponedRequest(layoutNode, true, forced));
                    LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                    if (layoutTreeConsistencyChecker != null) {
                        layoutTreeConsistencyChecker.assertConsistent();
                    }
                    return false;
                case 5:
                    if (layoutNode.getLookaheadMeasurePending$ui_release() && !forced) {
                        return false;
                    }
                    layoutNode.markLookaheadMeasurePending$ui_release();
                    layoutNode.markMeasurePending$ui_release();
                    if (Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) true) || getCanAffectParentInLookahead(layoutNode)) {
                        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                        if (!(parent$ui_release != null && parent$ui_release.getLookaheadMeasurePending$ui_release())) {
                            this.relayoutNodes.add(layoutNode);
                        }
                    }
                    if (!this.duringMeasureLayout) {
                        return true;
                    }
                    return false;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        } else {
            throw new IllegalStateException("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadLayout".toString());
        }
    }

    public static /* synthetic */ boolean requestRemeasure$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestRemeasure(layoutNode, z);
    }

    public final boolean requestRemeasure(LayoutNode layoutNode, boolean forced) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        switch (WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()]) {
            case 1:
            case 2:
                return false;
            case 3:
            case 4:
                this.postponedMeasureRequests.add(new PostponedRequest(layoutNode, false, forced));
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker == null) {
                    return false;
                }
                layoutTreeConsistencyChecker.assertConsistent();
                return false;
            case 5:
                if (layoutNode.getMeasurePending$ui_release() && !forced) {
                    return false;
                }
                layoutNode.markMeasurePending$ui_release();
                if (layoutNode.isPlaced() || getCanAffectParent(layoutNode)) {
                    LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                    if (!(parent$ui_release != null && parent$ui_release.getMeasurePending$ui_release())) {
                        this.relayoutNodes.add(layoutNode);
                    }
                }
                if (!this.duringMeasureLayout) {
                    return true;
                }
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ boolean requestLookaheadRelayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, z);
    }

    public final boolean requestLookaheadRelayout(LayoutNode layoutNode, boolean forced) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        switch (WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()]) {
            case 1:
            case 3:
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker == null) {
                    return false;
                }
                layoutTreeConsistencyChecker.assertConsistent();
                return false;
            case 2:
            case 4:
            case 5:
                if ((layoutNode.getLookaheadMeasurePending$ui_release() || layoutNode.getLookaheadLayoutPending$ui_release()) && !forced) {
                    LayoutTreeConsistencyChecker layoutTreeConsistencyChecker2 = this.consistencyChecker;
                    if (layoutTreeConsistencyChecker2 == null) {
                        return false;
                    }
                    layoutTreeConsistencyChecker2.assertConsistent();
                    return false;
                }
                layoutNode.markLookaheadLayoutPending$ui_release();
                layoutNode.markLayoutPending$ui_release();
                if (Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) true)) {
                    LayoutNode parent = layoutNode.getParent$ui_release();
                    if (!(parent != null && parent.getLookaheadMeasurePending$ui_release())) {
                        if (!(parent != null && parent.getLookaheadLayoutPending$ui_release())) {
                            this.relayoutNodes.add(layoutNode);
                        }
                    }
                }
                if (!this.duringMeasureLayout) {
                    return true;
                }
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ boolean requestRelayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return measureAndLayoutDelegate.requestRelayout(layoutNode, z);
    }

    public final boolean requestRelayout(LayoutNode layoutNode, boolean forced) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        switch (WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker == null) {
                    return false;
                }
                layoutTreeConsistencyChecker.assertConsistent();
                return false;
            case 5:
                if (forced || (!layoutNode.getMeasurePending$ui_release() && !layoutNode.getLayoutPending$ui_release())) {
                    layoutNode.markLayoutPending$ui_release();
                    if (layoutNode.isPlaced()) {
                        LayoutNode parent = layoutNode.getParent$ui_release();
                        if (!(parent != null && parent.getLayoutPending$ui_release())) {
                            if (!(parent != null && parent.getMeasurePending$ui_release())) {
                                this.relayoutNodes.add(layoutNode);
                            }
                        }
                    }
                    if (!this.duringMeasureLayout) {
                        return true;
                    }
                    return false;
                }
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker2 = this.consistencyChecker;
                if (layoutTreeConsistencyChecker2 == null) {
                    return false;
                }
                layoutTreeConsistencyChecker2.assertConsistent();
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void requestOnPositionedCallback(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.onPositionedDispatcher.onNodePositioned(layoutNode);
    }

    /* renamed from: doLookaheadRemeasure-sdFAvZA  reason: not valid java name */
    private final boolean m5064doLookaheadRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) {
        boolean lookaheadSizeChanged;
        if (layoutNode.getMLookaheadScope$ui_release() == null) {
            return false;
        }
        if (constraints != null) {
            lookaheadSizeChanged = layoutNode.m5001lookaheadRemeasure_Sx5XlM$ui_release(constraints);
        } else {
            lookaheadSizeChanged = LayoutNode.m4997lookaheadRemeasure_Sx5XlM$ui_release$default(layoutNode, (Constraints) null, 1, (Object) null);
        }
        LayoutNode parent = layoutNode.getParent$ui_release();
        if (lookaheadSizeChanged && parent != null) {
            if (parent.getMLookaheadScope$ui_release() == null) {
                requestRemeasure$default(this, parent, false, 2, (Object) null);
            } else if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                requestLookaheadRemeasure$default(this, parent, false, 2, (Object) null);
            } else if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                requestLookaheadRelayout$default(this, parent, false, 2, (Object) null);
            }
        }
        return lookaheadSizeChanged;
    }

    /* renamed from: doRemeasure-sdFAvZA  reason: not valid java name */
    private final boolean m5065doRemeasuresdFAvZA(LayoutNode layoutNode, Constraints constraints) {
        boolean sizeChanged;
        if (constraints != null) {
            sizeChanged = layoutNode.m5002remeasure_Sx5XlM$ui_release(constraints);
        } else {
            sizeChanged = LayoutNode.m4998remeasure_Sx5XlM$ui_release$default(layoutNode, (Constraints) null, 1, (Object) null);
        }
        LayoutNode parent = layoutNode.getParent$ui_release();
        if (sizeChanged && parent != null) {
            if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                requestRemeasure$default(this, parent, false, 2, (Object) null);
            } else if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                requestRelayout$default(this, parent, false, 2, (Object) null);
            }
        }
        return sizeChanged;
    }

    public static /* synthetic */ boolean measureAndLayout$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return measureAndLayoutDelegate.measureAndLayout(function0);
    }

    /* JADX INFO: finally extract failed */
    public final boolean measureAndLayout(Function0<Unit> onLayout) {
        boolean rootNodeResized = false;
        if (!this.root.isAttached()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!this.root.isPlaced()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!this.duringMeasureLayout) {
            if (this.rootConstraints != null) {
                this.duringMeasureLayout = true;
                try {
                    if (!this.relayoutNodes.isEmpty()) {
                        DepthSortedSet this_$iv = this.relayoutNodes;
                        while (!this_$iv.isEmpty()) {
                            LayoutNode layoutNode = this_$iv.pop();
                            boolean sizeChanged = remeasureAndRelayoutIfNeeded(layoutNode);
                            if (layoutNode == this.root && sizeChanged) {
                                rootNodeResized = true;
                            }
                        }
                        if (onLayout != null) {
                            onLayout.invoke();
                        }
                    }
                    this.duringMeasureLayout = false;
                    LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                    if (layoutTreeConsistencyChecker != null) {
                        layoutTreeConsistencyChecker.assertConsistent();
                    }
                } catch (Throwable th) {
                    this.duringMeasureLayout = false;
                    throw th;
                }
            }
            callOnLayoutCompletedListeners();
            return rootNodeResized;
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* JADX INFO: finally extract failed */
    public final void measureOnly() {
        if (!this.root.isAttached()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!this.root.isPlaced()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!(!this.duringMeasureLayout)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            try {
                recurseRemeasure(this.root);
                this.duringMeasureLayout = false;
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } catch (Throwable th) {
                this.duringMeasureLayout = false;
                throw th;
            }
        }
    }

    private final void recurseRemeasure(LayoutNode layoutNode) {
        remeasureOnly(layoutNode);
        MutableVector this_$iv = layoutNode.get_children$ui_release();
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                LayoutNode child = (LayoutNode) content$iv[i$iv];
                if (getMeasureAffectsParent(child)) {
                    recurseRemeasure(child);
                }
                i$iv++;
            } while (i$iv < size$iv);
        }
        remeasureOnly(layoutNode);
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: measureAndLayout-0kLqBqw  reason: not valid java name */
    public final void m5066measureAndLayout0kLqBqw(LayoutNode layoutNode, long constraints) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (!Intrinsics.areEqual((Object) layoutNode, (Object) this.root)) {
            if (!this.root.isAttached()) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else if (!this.root.isPlaced()) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            } else if (!this.duringMeasureLayout) {
                if (this.rootConstraints != null) {
                    this.duringMeasureLayout = true;
                    try {
                        this.relayoutNodes.remove(layoutNode);
                        boolean lookaheadSizeChanged = m5064doLookaheadRemeasuresdFAvZA(layoutNode, Constraints.m5918boximpl(constraints));
                        m5065doRemeasuresdFAvZA(layoutNode, Constraints.m5918boximpl(constraints));
                        if ((lookaheadSizeChanged || layoutNode.getLookaheadLayoutPending$ui_release()) && Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) true)) {
                            layoutNode.lookaheadReplace$ui_release();
                        }
                        if (layoutNode.getLayoutPending$ui_release() && layoutNode.isPlaced()) {
                            layoutNode.replace$ui_release();
                            this.onPositionedDispatcher.onNodePositioned(layoutNode);
                        }
                        this.duringMeasureLayout = false;
                        LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                        if (layoutTreeConsistencyChecker != null) {
                            layoutTreeConsistencyChecker.assertConsistent();
                        }
                    } catch (Throwable th) {
                        this.duringMeasureLayout = false;
                        throw th;
                    }
                }
                callOnLayoutCompletedListeners();
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* JADX INFO: finally extract failed */
    private final void performMeasureAndLayout(Function0<Unit> block) {
        if (!this.root.isAttached()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!this.root.isPlaced()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!(!this.duringMeasureLayout)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (this.rootConstraints != null) {
            this.duringMeasureLayout = true;
            try {
                block.invoke();
                InlineMarker.finallyStart(1);
                this.duringMeasureLayout = false;
                InlineMarker.finallyEnd(1);
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                this.duringMeasureLayout = false;
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
    }

    public final void registerOnLayoutCompletedListener(Owner.OnLayoutCompletedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onLayoutCompletedListeners.add(listener);
    }

    private final void callOnLayoutCompletedListeners() {
        MutableVector this_$iv = this.onLayoutCompletedListeners;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                ((Owner.OnLayoutCompletedListener) content$iv[i$iv]).onLayoutComplete();
                i$iv++;
            } while (i$iv < size$iv);
        }
        this.onLayoutCompletedListeners.clear();
    }

    /* access modifiers changed from: private */
    public final boolean remeasureAndRelayoutIfNeeded(LayoutNode layoutNode) {
        Constraints constraints;
        boolean sizeChanged = false;
        if (layoutNode.isPlaced() || getCanAffectParent(layoutNode) || Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) true) || getCanAffectParentInLookahead(layoutNode) || layoutNode.getAlignmentLinesRequired$ui_release()) {
            boolean lookaheadSizeChanged = false;
            if (layoutNode.getLookaheadMeasurePending$ui_release() || layoutNode.getMeasurePending$ui_release()) {
                if (layoutNode == this.root) {
                    constraints = this.rootConstraints;
                    Intrinsics.checkNotNull(constraints);
                } else {
                    constraints = null;
                }
                if (layoutNode.getLookaheadMeasurePending$ui_release()) {
                    lookaheadSizeChanged = m5064doLookaheadRemeasuresdFAvZA(layoutNode, constraints);
                }
                sizeChanged = m5065doRemeasuresdFAvZA(layoutNode, constraints);
            }
            if ((lookaheadSizeChanged || layoutNode.getLookaheadLayoutPending$ui_release()) && Intrinsics.areEqual((Object) layoutNode.isPlacedInLookahead(), (Object) true)) {
                layoutNode.lookaheadReplace$ui_release();
            }
            if (layoutNode.getLayoutPending$ui_release() && layoutNode.isPlaced()) {
                if (layoutNode == this.root) {
                    layoutNode.place$ui_release(0, 0);
                } else {
                    layoutNode.replace$ui_release();
                }
                this.onPositionedDispatcher.onNodePositioned(layoutNode);
                LayoutTreeConsistencyChecker layoutTreeConsistencyChecker = this.consistencyChecker;
                if (layoutTreeConsistencyChecker != null) {
                    layoutTreeConsistencyChecker.assertConsistent();
                }
            }
            if (this.postponedMeasureRequests.isNotEmpty()) {
                MutableVector this_$iv = this.postponedMeasureRequests;
                int size$iv = this_$iv.getSize();
                if (size$iv > 0) {
                    int i$iv = 0;
                    Object[] content$iv = this_$iv.getContent();
                    do {
                        PostponedRequest request = (PostponedRequest) content$iv[i$iv];
                        if (request.getNode().isAttached()) {
                            if (!request.isLookahead()) {
                                requestRemeasure(request.getNode(), request.isForced());
                            } else {
                                requestLookaheadRemeasure(request.getNode(), request.isForced());
                            }
                        }
                        i$iv++;
                    } while (i$iv < size$iv);
                }
                this.postponedMeasureRequests.clear();
            }
        }
        return sizeChanged;
    }

    private final void remeasureOnly(LayoutNode layoutNode) {
        Constraints constraints;
        if (layoutNode.getMeasurePending$ui_release() || layoutNode.getLookaheadMeasurePending$ui_release()) {
            if (layoutNode == this.root) {
                constraints = this.rootConstraints;
                Intrinsics.checkNotNull(constraints);
            } else {
                constraints = null;
            }
            if (layoutNode.getLookaheadMeasurePending$ui_release()) {
                m5064doLookaheadRemeasuresdFAvZA(layoutNode, constraints);
            }
            m5065doRemeasuresdFAvZA(layoutNode, constraints);
        }
    }

    public final void forceMeasureTheSubtree(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (!this.relayoutNodes.isEmpty()) {
            if (!this.duringMeasureLayout) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (!layoutNode.getMeasurePending$ui_release()) {
                MutableVector this_$iv$iv = layoutNode.get_children$ui_release();
                int size$iv$iv = this_$iv$iv.getSize();
                if (size$iv$iv > 0) {
                    int i$iv$iv = 0;
                    Object[] content$iv$iv = this_$iv$iv.getContent();
                    do {
                        LayoutNode child = (LayoutNode) content$iv$iv[i$iv$iv];
                        if (child.getMeasurePending$ui_release() && this.relayoutNodes.remove(child)) {
                            remeasureAndRelayoutIfNeeded(child);
                        }
                        if (!child.getMeasurePending$ui_release()) {
                            forceMeasureTheSubtree(child);
                        }
                        i$iv$iv++;
                    } while (i$iv$iv < size$iv$iv);
                }
                if (layoutNode.getMeasurePending$ui_release() && this.relayoutNodes.remove(layoutNode)) {
                    remeasureAndRelayoutIfNeeded(layoutNode);
                }
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }

    public static /* synthetic */ void dispatchOnPositionedCallbacks$default(MeasureAndLayoutDelegate measureAndLayoutDelegate, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
    }

    public final void dispatchOnPositionedCallbacks(boolean forceDispatch) {
        if (forceDispatch) {
            this.onPositionedDispatcher.onRootNodePositioned(this.root);
        }
        this.onPositionedDispatcher.dispatch();
    }

    public final void onNodeDetached(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.relayoutNodes.remove(node);
    }

    private final boolean getMeasureAffectsParent(LayoutNode $this$measureAffectsParent) {
        return $this$measureAffectsParent.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock || $this$measureAffectsParent.getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release();
    }

    private final boolean getCanAffectParent(LayoutNode $this$canAffectParent) {
        return $this$canAffectParent.getMeasurePending$ui_release() && getMeasureAffectsParent($this$canAffectParent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        r0 = r0.getAlignmentLines();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean getCanAffectParentInLookahead(androidx.compose.ui.node.LayoutNode r5) {
        /*
            r4 = this;
            boolean r0 = r5.getLookaheadLayoutPending$ui_release()
            r1 = 0
            if (r0 == 0) goto L_0x002d
            androidx.compose.ui.node.LayoutNode$UsageByParent r0 = r5.getMeasuredByParentInLookahead$ui_release()
            androidx.compose.ui.node.LayoutNode$UsageByParent r2 = androidx.compose.ui.node.LayoutNode.UsageByParent.InMeasureBlock
            r3 = 1
            if (r0 == r2) goto L_0x002b
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = r5.getLayoutDelegate$ui_release()
            androidx.compose.ui.node.AlignmentLinesOwner r0 = r0.getLookaheadAlignmentLinesOwner$ui_release()
            if (r0 == 0) goto L_0x0028
            androidx.compose.ui.node.AlignmentLines r0 = r0.getAlignmentLines()
            if (r0 == 0) goto L_0x0028
            boolean r0 = r0.getRequired$ui_release()
            if (r0 != r3) goto L_0x0028
            r0 = r3
            goto L_0x0029
        L_0x0028:
            r0 = r1
        L_0x0029:
            if (r0 == 0) goto L_0x002d
        L_0x002b:
            r1 = r3
            goto L_0x002e
        L_0x002d:
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.MeasureAndLayoutDelegate.getCanAffectParentInLookahead(androidx.compose.ui.node.LayoutNode):boolean");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/node/MeasureAndLayoutDelegate$PostponedRequest;", "", "node", "Landroidx/compose/ui/node/LayoutNode;", "isLookahead", "", "isForced", "(Landroidx/compose/ui/node/LayoutNode;ZZ)V", "()Z", "getNode", "()Landroidx/compose/ui/node/LayoutNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MeasureAndLayoutDelegate.kt */
    public static final class PostponedRequest {
        public static final int $stable = 8;
        private final boolean isForced;
        private final boolean isLookahead;
        private final LayoutNode node;

        public PostponedRequest(LayoutNode node2, boolean isLookahead2, boolean isForced2) {
            Intrinsics.checkNotNullParameter(node2, "node");
            this.node = node2;
            this.isLookahead = isLookahead2;
            this.isForced = isForced2;
        }

        public final LayoutNode getNode() {
            return this.node;
        }

        public final boolean isForced() {
            return this.isForced;
        }

        public final boolean isLookahead() {
            return this.isLookahead;
        }
    }
}
