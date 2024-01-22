package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001:\u0002UVB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010=\u001a\u00020>J\u0006\u0010?\u001a\u00020>J\r\u0010@\u001a\u00020>H\u0000¢\u0006\u0002\bAJ\r\u0010B\u001a\u00020>H\u0000¢\u0006\u0002\bCJ\r\u0010D\u001a\u00020>H\u0000¢\u0006\u0002\bEJ\r\u0010F\u001a\u00020>H\u0000¢\u0006\u0002\bGJ\u0017\u0010H\u001a\u00020>2\b\u0010I\u001a\u0004\u0018\u00010JH\u0000¢\u0006\u0002\bKJ\u001d\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010OJ\u001d\u0010P\u001a\u00020>2\u0006\u0010M\u001a\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bQ\u0010OJ\u0006\u0010R\u001a\u00020>J\u0006\u0010S\u001a\u00020>J\f\u0010T\u001a\u00020\u0010*\u00020\u0003H\u0002R\u0014\u0010\u0005\u001a\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00198Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00198Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u000e\u0010!\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\"@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\u0004\u0018\u00010\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\bR\u001e\u0010(\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0013R\u000e\u0010*\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0013R*\u0010.\u001a\b\u0018\u00010-R\u00020\u00002\f\u0010\u001e\u001a\b\u0018\u00010-R\u00020\u0000@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u00101\u001a\u000602R\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001e\u00105\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0013R\u0011\u00107\u001a\u0002088F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006W"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner$ui_release", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "value", "", "childrenAccessingCoordinatesDuringPlacement", "getChildrenAccessingCoordinatesDuringPlacement", "()I", "setChildrenAccessingCoordinatesDuringPlacement", "(I)V", "", "coordinatesAccessedDuringPlacement", "getCoordinatesAccessedDuringPlacement", "()Z", "setCoordinatesAccessedDuringPlacement", "(Z)V", "height", "getHeight$ui_release", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastLookaheadConstraints", "getLastLookaheadConstraints-DWUhwKw", "<set-?>", "layoutPending", "getLayoutPending$ui_release", "layoutPendingForAlignment", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "layoutState", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadAlignmentLinesOwner", "getLookaheadAlignmentLinesOwner$ui_release", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "lookaheadLayoutPendingForAlignment", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "lookaheadPassDelegate", "getLookaheadPassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePending", "getMeasurePending$ui_release", "outerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getOuterCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "width", "getWidth$ui_release", "invalidateParentData", "", "markChildrenDirty", "markLayoutPending", "markLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "onLookaheadScopeChanged", "newScope", "Landroidx/compose/ui/layout/LookaheadScope;", "onLookaheadScopeChanged$ui_release", "performLookaheadMeasure", "constraints", "performLookaheadMeasure-BRTryo0", "(J)V", "performMeasure", "performMeasure-BRTryo0", "resetAlignmentLines", "updateParentData", "isOutMostLookaheadRoot", "LookaheadPassDelegate", "MeasurePassDelegate", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeLayoutDelegate.kt */
public final class LayoutNodeLayoutDelegate {
    private int childrenAccessingCoordinatesDuringPlacement;
    private boolean coordinatesAccessedDuringPlacement;
    /* access modifiers changed from: private */
    public final LayoutNode layoutNode;
    /* access modifiers changed from: private */
    public boolean layoutPending;
    /* access modifiers changed from: private */
    public boolean layoutPendingForAlignment;
    /* access modifiers changed from: private */
    public LayoutNode.LayoutState layoutState = LayoutNode.LayoutState.Idle;
    /* access modifiers changed from: private */
    public boolean lookaheadLayoutPending;
    /* access modifiers changed from: private */
    public boolean lookaheadLayoutPendingForAlignment;
    private boolean lookaheadMeasurePending;
    private LookaheadPassDelegate lookaheadPassDelegate;
    private final MeasurePassDelegate measurePassDelegate = new MeasurePassDelegate();
    private boolean measurePending;

    public LayoutNodeLayoutDelegate(LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        this.layoutNode = layoutNode2;
    }

    public final NodeCoordinator getOuterCoordinator() {
        return this.layoutNode.getNodes$ui_release().getOuterCoordinator$ui_release();
    }

    /* renamed from: getLastConstraints-DWUhwKw  reason: not valid java name */
    public final Constraints m5045getLastConstraintsDWUhwKw() {
        return this.measurePassDelegate.m5052getLastConstraintsDWUhwKw();
    }

    /* renamed from: getLastLookaheadConstraints-DWUhwKw  reason: not valid java name */
    public final Constraints m5046getLastLookaheadConstraintsDWUhwKw() {
        LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null) {
            return lookaheadPassDelegate2.m5047getLastConstraintsDWUhwKw();
        }
        return null;
    }

    public final int getHeight$ui_release() {
        return this.measurePassDelegate.getHeight();
    }

    public final int getWidth$ui_release() {
        return this.measurePassDelegate.getWidth();
    }

    public final LayoutNode.LayoutState getLayoutState$ui_release() {
        return this.layoutState;
    }

    public final boolean getMeasurePending$ui_release() {
        return this.measurePending;
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutPending;
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.lookaheadMeasurePending;
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.lookaheadLayoutPending;
    }

    public final void markLayoutPending$ui_release() {
        this.layoutPending = true;
        this.layoutPendingForAlignment = true;
    }

    public final void markMeasurePending$ui_release() {
        this.measurePending = true;
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.lookaheadLayoutPending = true;
        this.lookaheadLayoutPendingForAlignment = true;
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.lookaheadMeasurePending = true;
    }

    public final AlignmentLinesOwner getAlignmentLinesOwner$ui_release() {
        return this.measurePassDelegate;
    }

    public final AlignmentLinesOwner getLookaheadAlignmentLinesOwner$ui_release() {
        return this.lookaheadPassDelegate;
    }

    public final boolean getCoordinatesAccessedDuringPlacement() {
        return this.coordinatesAccessedDuringPlacement;
    }

    public final void setCoordinatesAccessedDuringPlacement(boolean value) {
        if (this.coordinatesAccessedDuringPlacement != value) {
            this.coordinatesAccessedDuringPlacement = value;
            if (value) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
            } else {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final int getChildrenAccessingCoordinatesDuringPlacement() {
        return this.childrenAccessingCoordinatesDuringPlacement;
    }

    public final void setChildrenAccessingCoordinatesDuringPlacement(int value) {
        int oldValue = this.childrenAccessingCoordinatesDuringPlacement;
        this.childrenAccessingCoordinatesDuringPlacement = value;
        boolean z = false;
        boolean z2 = oldValue == 0;
        if (value == 0) {
            z = true;
        }
        if (z2 != z) {
            LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
            LayoutNodeLayoutDelegate parentLayoutDelegate = parent$ui_release != null ? parent$ui_release.getLayoutDelegate$ui_release() : null;
            if (parentLayoutDelegate == null) {
                return;
            }
            if (value == 0) {
                parentLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(parentLayoutDelegate.childrenAccessingCoordinatesDuringPlacement - 1);
            } else {
                parentLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(parentLayoutDelegate.childrenAccessingCoordinatesDuringPlacement + 1);
            }
        }
    }

    public final MeasurePassDelegate getMeasurePassDelegate$ui_release() {
        return this.measurePassDelegate;
    }

    public final LookaheadPassDelegate getLookaheadPassDelegate$ui_release() {
        return this.lookaheadPassDelegate;
    }

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0014\u0010<\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020,0=H\u0016J\u001c\u0010?\u001a\u00020$2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020$0\"H\u0016J\u0011\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020>H\u0002J\u000e\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020\u0010J\u0006\u0010E\u001a\u00020$J\b\u0010F\u001a\u00020$H\u0016J\u0010\u0010G\u001a\u00020,2\u0006\u0010H\u001a\u00020,H\u0016J\u0010\u0010I\u001a\u00020,2\u0006\u0010J\u001a\u00020,H\u0016J\u001d\u0010K\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u001eH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ\u0010\u0010O\u001a\u00020,2\u0006\u0010H\u001a\u00020,H\u0016J\u0010\u0010P\u001a\u00020,2\u0006\u0010J\u001a\u00020,H\u0016J\u0006\u0010Q\u001a\u00020$J\b\u0010R\u001a\u00020$H\u0002J\b\u0010S\u001a\u00020$H\u0002J@\u0010T\u001a\u00020$2\u0006\u0010U\u001a\u00020'2\u0006\u0010V\u001a\u00020*2\u0019\u0010W\u001a\u0015\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%H\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bX\u0010YJ@\u0010Z\u001a\u00020$2\u0006\u0010U\u001a\u00020'2\u0006\u0010V\u001a\u00020*2\u0019\u0010W\u001a\u0015\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b[\u0010YJ\u001b\u0010\\\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u001eø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b]\u0010^J\u0006\u0010_\u001a\u00020$J\b\u0010`\u001a\u00020$H\u0016J\b\u0010a\u001a\u00020$H\u0016J\u0006\u0010b\u001a\u00020\u0010J\f\u0010c\u001a\u00020$*\u00020dH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f8@X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001e8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R!\u0010!\u001a\u0015\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0018\u00010\"¢\u0006\u0002\b%X\u000e¢\u0006\u0002\n\u0000R\u0019\u0010&\u001a\u00020'X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u00020,8VX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020,8VX\u0004¢\u0006\u0006\u001a\u0004\b1\u0010.R\u0016\u00102\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\"\u00107\u001a\u0004\u0018\u0001062\b\u00105\u001a\u0004\u0018\u000106@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u000e\u0010:\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006e"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", "_childMeasurables", "Landroidx/compose/runtime/collection/MutableVector;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "childMeasurables", "", "getChildMeasurables$ui_release", "()Ljava/util/List;", "childMeasurablesDirty", "", "getChildMeasurablesDirty$ui_release", "()Z", "setChildMeasurablesDirty$ui_release", "(Z)V", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui_release", "setDuringAlignmentLinesQuery$ui_release", "innerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isPlaced", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastLayerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "lastPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "lastZIndex", "", "measuredHeight", "", "getMeasuredHeight", "()I", "measuredOnce", "measuredWidth", "getMeasuredWidth", "parentAlignmentLinesOwner", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "<set-?>", "", "parentData", "getParentData", "()Ljava/lang/Object;", "parentDataDirty", "placedOnce", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "forEachChildAlignmentLinesOwner", "block", "get", "alignmentLine", "invalidateIntrinsicsParent", "forceRequest", "invalidateParentData", "layoutChildren", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "notifyChildrenUsingCoordinatesWhilePlacing", "onBeforeLayoutChildren", "onIntrinsicsQueried", "placeAt", "position", "zIndex", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeOuterCoordinator", "placeOuterCoordinator-f8xVGno", "remeasure", "remeasure-BRTryo0", "(J)Z", "replace", "requestLayout", "requestMeasure", "updateParentData", "trackMeasurementByParent", "Landroidx/compose/ui/node/LayoutNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNodeLayoutDelegate.kt */
    public final class MeasurePassDelegate extends Placeable implements Measurable, AlignmentLinesOwner {
        private final MutableVector<Measurable> _childMeasurables = new MutableVector<>(new Measurable[16], 0);
        private final AlignmentLines alignmentLines = new LayoutNodeAlignmentLines(this);
        private boolean childMeasurablesDirty = true;
        private boolean duringAlignmentLinesQuery;
        private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
        private long lastPosition = IntOffset.Companion.m6114getZeronOccac();
        private float lastZIndex;
        private boolean measuredOnce;
        private Object parentData;
        private boolean parentDataDirty = true;
        private boolean placedOnce;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* compiled from: LayoutNodeLayoutDelegate.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[LayoutNode.LayoutState.values().length];
                try {
                    iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
                try {
                    iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                } catch (NoSuchFieldError e4) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public MeasurePassDelegate() {
        }

        /* renamed from: getLastConstraints-DWUhwKw  reason: not valid java name */
        public final Constraints m5052getLastConstraintsDWUhwKw() {
            if (this.measuredOnce) {
                return Constraints.m5918boximpl(m4899getMeasurementConstraintsmsEJaDk());
            }
            return null;
        }

        public final boolean getDuringAlignmentLinesQuery$ui_release() {
            return this.duringAlignmentLinesQuery;
        }

        public final void setDuringAlignmentLinesQuery$ui_release(boolean z) {
            this.duringAlignmentLinesQuery = z;
        }

        public Object getParentData() {
            return this.parentData;
        }

        public boolean isPlaced() {
            return LayoutNodeLayoutDelegate.this.layoutNode.isPlaced();
        }

        public NodeCoordinator getInnerCoordinator() {
            return LayoutNodeLayoutDelegate.this.layoutNode.getInnerCoordinator$ui_release();
        }

        public AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        public final boolean getChildMeasurablesDirty$ui_release() {
            return this.childMeasurablesDirty;
        }

        public final void setChildMeasurablesDirty$ui_release(boolean z) {
            this.childMeasurablesDirty = z;
        }

        public final List<Measurable> getChildMeasurables$ui_release() {
            LayoutNodeLayoutDelegate.this.layoutNode.updateChildrenIfDirty$ui_release();
            if (!this.childMeasurablesDirty) {
                return this._childMeasurables.asMutableList();
            }
            LayoutNodeLayoutDelegateKt.updateChildMeasurables(LayoutNodeLayoutDelegate.this.layoutNode, this._childMeasurables, LayoutNodeLayoutDelegate$MeasurePassDelegate$childMeasurables$1.INSTANCE);
            this.childMeasurablesDirty = false;
            return this._childMeasurables.asMutableList();
        }

        public void layoutChildren() {
            getAlignmentLines().recalculateQueryOwner();
            if (LayoutNodeLayoutDelegate.this.getLayoutPending$ui_release()) {
                onBeforeLayoutChildren();
            }
            if (LayoutNodeLayoutDelegate.this.layoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !getInnerCoordinator().isPlacingForAlignment$ui_release() && LayoutNodeLayoutDelegate.this.getLayoutPending$ui_release())) {
                LayoutNodeLayoutDelegate.this.layoutPending = false;
                LayoutNode.LayoutState oldLayoutState = LayoutNodeLayoutDelegate.this.getLayoutState$ui_release();
                LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LayingOut;
                LayoutNode $this$layoutChildren_u24lambda_u240 = LayoutNodeLayoutDelegate.this.layoutNode;
                LayoutNodeKt.requireOwner($this$layoutChildren_u24lambda_u240).getSnapshotObserver().observeLayoutSnapshotReads$ui_release($this$layoutChildren_u24lambda_u240, false, new LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildren$1$1(LayoutNodeLayoutDelegate.this, this, $this$layoutChildren_u24lambda_u240));
                LayoutNodeLayoutDelegate.this.layoutState = oldLayoutState;
                if (getInnerCoordinator().isPlacingForAlignment$ui_release() && LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringPlacement()) {
                    requestLayout();
                }
                LayoutNodeLayoutDelegate.this.layoutPendingForAlignment = false;
            }
            if (getAlignmentLines().getUsedDuringParentLayout$ui_release()) {
                getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
            }
            if (getAlignmentLines().getDirty$ui_release() && getAlignmentLines().getRequired$ui_release()) {
                getAlignmentLines().recalculate();
            }
        }

        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m5053measureBRTryo0(long constraints) {
            if (LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNodeLayoutDelegate.this.layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
            }
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            if (layoutNodeLayoutDelegate.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
                this.measuredOnce = true;
                m4902setMeasurementConstraintsBRTryo0(constraints);
                LayoutNodeLayoutDelegate.this.layoutNode.setMeasuredByParentInLookahead$ui_release(LayoutNode.UsageByParent.NotUsed);
                LookaheadPassDelegate lookaheadPassDelegate$ui_release = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                lookaheadPassDelegate$ui_release.m5048measureBRTryo0(constraints);
            }
            trackMeasurementByParent(LayoutNodeLayoutDelegate.this.layoutNode);
            m5055remeasureBRTryo0(constraints);
            return this;
        }

        /* renamed from: remeasure-BRTryo0  reason: not valid java name */
        public final boolean m5055remeasureBRTryo0(long constraints) {
            Owner owner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
            LayoutNode parent = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            boolean sizeChanged = true;
            LayoutNodeLayoutDelegate.this.layoutNode.setCanMultiMeasure$ui_release(LayoutNodeLayoutDelegate.this.layoutNode.getCanMultiMeasure$ui_release() || (parent != null && parent.getCanMultiMeasure$ui_release()));
            if (LayoutNodeLayoutDelegate.this.layoutNode.getMeasurePending$ui_release() || !Constraints.m5923equalsimpl0(m4899getMeasurementConstraintsmsEJaDk(), constraints)) {
                getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
                forEachChildAlignmentLinesOwner(LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$1.INSTANCE);
                this.measuredOnce = true;
                long outerPreviousMeasuredSize = LayoutNodeLayoutDelegate.this.getOuterCoordinator().m5096getSizeYbymL2g();
                m4902setMeasurementConstraintsBRTryo0(constraints);
                LayoutNodeLayoutDelegate.this.m5044performMeasureBRTryo0(constraints);
                if (IntSize.m6144equalsimpl0(LayoutNodeLayoutDelegate.this.getOuterCoordinator().m5096getSizeYbymL2g(), outerPreviousMeasuredSize) && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWidth() == getWidth() && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getHeight() == getHeight()) {
                    sizeChanged = false;
                }
                m4901setMeasuredSizeozmzZPI(IntSizeKt.IntSize(LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWidth(), LayoutNodeLayoutDelegate.this.getOuterCoordinator().getHeight()));
                return sizeChanged;
            }
            owner.forceMeasureTheSubtree(LayoutNodeLayoutDelegate.this.layoutNode);
            LayoutNodeLayoutDelegate.this.layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
            return false;
        }

        private final void trackMeasurementByParent(LayoutNode $this$trackMeasurementByParent) {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode parent = $this$trackMeasurementByParent.getParent$ui_release();
            if (parent != null) {
                if ($this$trackMeasurementByParent.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.NotUsed || $this$trackMeasurementByParent.getCanMultiMeasure$ui_release()) {
                    switch (WhenMappings.$EnumSwitchMapping$0[parent.getLayoutState$ui_release().ordinal()]) {
                        case 1:
                            usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                            break;
                        case 2:
                            usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                            break;
                        default:
                            throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent.getLayoutState$ui_release());
                    }
                    $this$trackMeasurementByParent.setMeasuredByParent$ui_release(usageByParent);
                    return;
                }
                throw new IllegalStateException(("measure() may not be called multiple times on the same Measurable. Current state " + $this$trackMeasurementByParent.getMeasuredByParent$ui_release() + ". Parent state " + parent.getLayoutState$ui_release() + '.').toString());
            }
            $this$trackMeasurementByParent.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
        }

        public int getMeasuredWidth() {
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().getMeasuredWidth();
        }

        public int getMeasuredHeight() {
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().getMeasuredHeight();
        }

        public int get(AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode.LayoutState layoutState = null;
            if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.Measuring) {
                getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
            } else {
                LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
                if (parent$ui_release2 != null) {
                    layoutState = parent$ui_release2.getLayoutState$ui_release();
                }
                if (layoutState == LayoutNode.LayoutState.LayingOut) {
                    getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
                }
            }
            this.duringAlignmentLinesQuery = true;
            int result = LayoutNodeLayoutDelegate.this.getOuterCoordinator().get(alignmentLine);
            this.duringAlignmentLinesQuery = false;
            return result;
        }

        /* access modifiers changed from: protected */
        /* renamed from: placeAt-f8xVGno  reason: not valid java name */
        public void m5054placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            if (!IntOffset.m6103equalsimpl0(position, this.lastPosition)) {
                notifyChildrenUsingCoordinatesWhilePlacing();
            }
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            if (layoutNodeLayoutDelegate.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
                Placeable.PlacementScope.Companion $this$placeAt_f8xVGno_u24lambda_u242 = Placeable.PlacementScope.Companion;
                LookaheadPassDelegate lookaheadPassDelegate$ui_release = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                Placeable.PlacementScope.place$default($this$placeAt_f8xVGno_u24lambda_u242, lookaheadPassDelegate$ui_release, IntOffset.m6104getXimpl(position), IntOffset.m6105getYimpl(position), 0.0f, 4, (Object) null);
            }
            LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LayingOut;
            m5051placeOuterCoordinatorf8xVGno(position, zIndex, layerBlock);
            LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.Idle;
        }

        /* renamed from: placeOuterCoordinator-f8xVGno  reason: not valid java name */
        private final void m5051placeOuterCoordinatorf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            this.lastPosition = position;
            this.lastZIndex = zIndex;
            this.lastLayerBlock = layerBlock;
            this.placedOnce = true;
            getAlignmentLines().setUsedByModifierLayout$ui_release(false);
            LayoutNodeLayoutDelegate.this.setCoordinatesAccessedDuringPlacement(false);
            LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode).getSnapshotObserver().observeLayoutModifierSnapshotReads$ui_release(LayoutNodeLayoutDelegate.this.layoutNode, false, new LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinator$1(layerBlock, LayoutNodeLayoutDelegate.this, position, zIndex));
        }

        public final void replace() {
            if (this.placedOnce) {
                m5051placeOuterCoordinatorf8xVGno(this.lastPosition, this.lastZIndex, this.lastLayerBlock);
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }

        public int minIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().minIntrinsicWidth(height);
        }

        public int maxIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().maxIntrinsicWidth(height);
        }

        public int minIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().minIntrinsicHeight(width);
        }

        public int maxIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().maxIntrinsicHeight(width);
        }

        private final void onIntrinsicsQueried() {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, (Object) null);
            LayoutNode parent = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent != null && LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNode access$getLayoutNode$p = LayoutNodeLayoutDelegate.this.layoutNode;
                switch (WhenMappings.$EnumSwitchMapping$0[parent.getLayoutState$ui_release().ordinal()]) {
                    case 1:
                        usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                        break;
                    case 2:
                        usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                        break;
                    default:
                        usageByParent = parent.getIntrinsicsUsageByParent$ui_release();
                        break;
                }
                access$getLayoutNode$p.setIntrinsicsUsageByParent$ui_release(usageByParent);
            }
        }

        public final void invalidateParentData() {
            this.parentDataDirty = true;
        }

        public final boolean updateParentData() {
            if (!this.parentDataDirty) {
                return false;
            }
            this.parentDataDirty = false;
            boolean changed = !Intrinsics.areEqual(getParentData(), LayoutNodeLayoutDelegate.this.getOuterCoordinator().getParentData());
            this.parentData = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getParentData();
            return changed;
        }

        public Map<AlignmentLine, Integer> calculateAlignmentLines() {
            if (!this.duringAlignmentLinesQuery) {
                if (LayoutNodeLayoutDelegate.this.getLayoutState$ui_release() == LayoutNode.LayoutState.Measuring) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                    if (getAlignmentLines().getDirty$ui_release()) {
                        LayoutNodeLayoutDelegate.this.markLayoutPending$ui_release();
                    }
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(true);
                }
            }
            getInnerCoordinator().setPlacingForAlignment$ui_release(true);
            layoutChildren();
            getInnerCoordinator().setPlacingForAlignment$ui_release(false);
            return getAlignmentLines().getLastCalculation();
        }

        public AlignmentLinesOwner getParentAlignmentLinesOwner() {
            LayoutNodeLayoutDelegate layoutDelegate$ui_release;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || (layoutDelegate$ui_release = parent$ui_release.getLayoutDelegate$ui_release()) == null) {
                return null;
            }
            return layoutDelegate$ui_release.getAlignmentLinesOwner$ui_release();
        }

        public void forEachChildAlignmentLinesOwner(Function1<? super AlignmentLinesOwner, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            List $this$fastForEach$iv = LayoutNodeLayoutDelegate.this.layoutNode.getChildren$ui_release();
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                block.invoke($this$fastForEach$iv.get(index$iv).getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release());
            }
        }

        public void requestLayout() {
            LayoutNode.requestRelayout$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, (Object) null);
        }

        public void requestMeasure() {
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, (Object) null);
        }

        public final void notifyChildrenUsingCoordinatesWhilePlacing() {
            if (LayoutNodeLayoutDelegate.this.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                List $this$fastForEach$iv = LayoutNodeLayoutDelegate.this.layoutNode.getChildren$ui_release();
                int size = $this$fastForEach$iv.size();
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    LayoutNode child = $this$fastForEach$iv.get(index$iv);
                    LayoutNodeLayoutDelegate childLayoutDelegate = child.getLayoutDelegate$ui_release();
                    if (childLayoutDelegate.getCoordinatesAccessedDuringPlacement() && !childLayoutDelegate.getLayoutPending$ui_release()) {
                        LayoutNode.requestRelayout$ui_release$default(child, false, 1, (Object) null);
                    }
                    childLayoutDelegate.getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
                }
            }
        }

        private final void onBeforeLayoutChildren() {
            LayoutNode this_$iv = LayoutNodeLayoutDelegate.this.layoutNode;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            MutableVector this_$iv$iv = this_$iv.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                    if (it.getMeasurePending$ui_release() && it.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && LayoutNode.m4998remeasure_Sx5XlM$ui_release$default(it, (Constraints) null, 1, (Object) null)) {
                        LayoutNode.requestRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, false, 1, (Object) null);
                    }
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }

        public final void invalidateIntrinsicsParent(boolean forceRequest) {
            LayoutNode parent$ui_release;
            LayoutNode parent = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode.UsageByParent intrinsicsUsageByParent = LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent$ui_release();
            if (parent != null && intrinsicsUsageByParent != LayoutNode.UsageByParent.NotUsed) {
                LayoutNode intrinsicsUsingParent = parent;
                while (intrinsicsUsingParent.getIntrinsicsUsageByParent$ui_release() == intrinsicsUsageByParent && (parent$ui_release = intrinsicsUsingParent.getParent$ui_release()) != null) {
                    intrinsicsUsingParent = parent$ui_release;
                }
                switch (WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent.ordinal()]) {
                    case 1:
                        intrinsicsUsingParent.requestRemeasure$ui_release(forceRequest);
                        return;
                    case 2:
                        intrinsicsUsingParent.requestRelayout$ui_release(forceRequest);
                        return;
                    default:
                        throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020*0;H\u0016J\u001c\u0010=\u001a\u00020>2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020>0@H\u0016J!\u0010A\u001a\u00020>2\u0016\u0010?\u001a\u0012\u0012\b\u0012\u00060\u0000R\u00020B\u0012\u0004\u0012\u00020>0@H\bJ\u0011\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020<H\u0002J\u000e\u0010E\u001a\u00020>2\u0006\u0010F\u001a\u00020\u0012J\u0006\u0010G\u001a\u00020>J\b\u0010H\u001a\u00020>H\u0016J\b\u0010I\u001a\u00020>H\u0002J\u0010\u0010J\u001a\u00020*2\u0006\u0010K\u001a\u00020*H\u0016J\u0010\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020*H\u0016J\u001d\u0010N\u001a\u00020\u00012\u0006\u0010O\u001a\u00020\"H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020*2\u0006\u0010K\u001a\u00020*H\u0016J\u0010\u0010S\u001a\u00020*2\u0006\u0010M\u001a\u00020*H\u0016J\u0006\u0010T\u001a\u00020>J\b\u0010U\u001a\u00020>H\u0002J\b\u0010V\u001a\u00020>H\u0002J\u0006\u0010W\u001a\u00020>J@\u0010X\u001a\u00020>2\u0006\u0010Y\u001a\u00020&2\u0006\u0010Z\u001a\u00020[2\u0019\u0010\\\u001a\u0015\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020>\u0018\u00010@¢\u0006\u0002\b^H\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b_\u0010`J\u001b\u0010a\u001a\u00020\u00122\u0006\u0010O\u001a\u00020\"ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bb\u0010cJ\u0006\u0010d\u001a\u00020>J\b\u0010e\u001a\u00020>H\u0016J\b\u0010f\u001a\u00020>H\u0016J\b\u0010g\u001a\u00020>H\u0002J\u0006\u0010h\u001a\u00020\u0012J\f\u0010i\u001a\u00020>*\u00020jH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u000e\u0010 \u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0019\u0010%\u001a\u00020&X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010'R\u0019\u0010(\u001a\u0004\u0018\u00010\"X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020*8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020*8VX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010,R\u0016\u00100\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\"\u00105\u001a\u0004\u0018\u0001042\b\u00103\u001a\u0004\u0018\u000104@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006k"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;Landroidx/compose/ui/layout/LookaheadScope;)V", "_childMeasurables", "Landroidx/compose/runtime/collection/MutableVector;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "childMeasurables", "", "getChildMeasurables$ui_release", "()Ljava/util/List;", "childMeasurablesDirty", "", "getChildMeasurablesDirty$ui_release", "()Z", "setChildMeasurablesDirty$ui_release", "(Z)V", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui_release", "setDuringAlignmentLinesQuery$ui_release", "innerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isPlaced", "setPlaced", "isPreviouslyPlaced", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "lookaheadConstraints", "measuredHeight", "", "getMeasuredHeight", "()I", "measuredOnce", "measuredWidth", "getMeasuredWidth", "parentAlignmentLinesOwner", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "<set-?>", "", "parentData", "getParentData", "()Ljava/lang/Object;", "parentDataDirty", "placedOnce", "calculateAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "forEachChildAlignmentLinesOwner", "", "block", "Lkotlin/Function1;", "forEachChildDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "get", "alignmentLine", "invalidateIntrinsicsParent", "forceRequest", "invalidateParentData", "layoutChildren", "markSubtreeNotPlaced", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "notifyChildrenUsingCoordinatesWhilePlacing", "onBeforeLayoutChildren", "onIntrinsicsQueried", "onPlaced", "placeAt", "position", "zIndex", "", "layerBlock", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "remeasure", "remeasure-BRTryo0", "(J)Z", "replace", "requestLayout", "requestMeasure", "requestSubtreeForLookahead", "updateParentData", "trackLookaheadMeasurementByParent", "Landroidx/compose/ui/node/LayoutNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutNodeLayoutDelegate.kt */
    public final class LookaheadPassDelegate extends Placeable implements Measurable, AlignmentLinesOwner {
        private final MutableVector<Measurable> _childMeasurables = new MutableVector<>(new Measurable[16], 0);
        private final AlignmentLines alignmentLines = new LookaheadAlignmentLines(this);
        private boolean childMeasurablesDirty = true;
        private boolean duringAlignmentLinesQuery;
        private boolean isPlaced = true;
        /* access modifiers changed from: private */
        public boolean isPreviouslyPlaced;
        private long lastPosition = IntOffset.Companion.m6114getZeronOccac();
        private Constraints lookaheadConstraints;
        private final LookaheadScope lookaheadScope;
        private boolean measuredOnce;
        private Object parentData;
        private boolean parentDataDirty = true;
        private boolean placedOnce;
        final /* synthetic */ LayoutNodeLayoutDelegate this$0;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* compiled from: LayoutNodeLayoutDelegate.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

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
                    iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
                try {
                    iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                } catch (NoSuchFieldError e6) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public LookaheadPassDelegate(LayoutNodeLayoutDelegate this$02, LookaheadScope lookaheadScope2) {
            Intrinsics.checkNotNullParameter(lookaheadScope2, "lookaheadScope");
            this.this$0 = this$02;
            this.lookaheadScope = lookaheadScope2;
            this.parentData = this$02.getMeasurePassDelegate$ui_release().getParentData();
        }

        public final boolean getDuringAlignmentLinesQuery$ui_release() {
            return this.duringAlignmentLinesQuery;
        }

        public final void setDuringAlignmentLinesQuery$ui_release(boolean z) {
            this.duringAlignmentLinesQuery = z;
        }

        /* renamed from: getLastConstraints-DWUhwKw  reason: not valid java name */
        public final Constraints m5047getLastConstraintsDWUhwKw() {
            return this.lookaheadConstraints;
        }

        public boolean isPlaced() {
            return this.isPlaced;
        }

        public void setPlaced(boolean z) {
            this.isPlaced = z;
        }

        public NodeCoordinator getInnerCoordinator() {
            return this.this$0.layoutNode.getInnerCoordinator$ui_release();
        }

        public AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        public final boolean getChildMeasurablesDirty$ui_release() {
            return this.childMeasurablesDirty;
        }

        public final void setChildMeasurablesDirty$ui_release(boolean z) {
            this.childMeasurablesDirty = z;
        }

        public final List<Measurable> getChildMeasurables$ui_release() {
            List<LayoutNode> children$ui_release = this.this$0.layoutNode.getChildren$ui_release();
            if (!this.childMeasurablesDirty) {
                return this._childMeasurables.asMutableList();
            }
            LayoutNodeLayoutDelegateKt.updateChildMeasurables(this.this$0.layoutNode, this._childMeasurables, LayoutNodeLayoutDelegate$LookaheadPassDelegate$childMeasurables$2.INSTANCE);
            this.childMeasurablesDirty = false;
            return this._childMeasurables.asMutableList();
        }

        private final void forEachChildDelegate(Function1<? super LookaheadPassDelegate, Unit> block) {
            MutableVector this_$iv$iv = this.this$0.layoutNode.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = ((LayoutNode) content$iv$iv[i$iv$iv]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    block.invoke(lookaheadPassDelegate$ui_release);
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }

        public void layoutChildren() {
            getAlignmentLines().recalculateQueryOwner();
            if (this.this$0.getLookaheadLayoutPending$ui_release()) {
                onBeforeLayoutChildren();
            }
            LookaheadDelegate lookaheadDelegate = getInnerCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate);
            if (this.this$0.lookaheadLayoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !lookaheadDelegate.isPlacingForAlignment$ui_release() && this.this$0.getLookaheadLayoutPending$ui_release())) {
                this.this$0.lookaheadLayoutPending = false;
                LayoutNode.LayoutState oldLayoutState = this.this$0.getLayoutState$ui_release();
                this.this$0.layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
                OwnerSnapshotObserver.observeLayoutSnapshotReads$ui_release$default(LayoutNodeKt.requireOwner(this.this$0.layoutNode).getSnapshotObserver(), this.this$0.layoutNode, false, new LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1(this, this.this$0, lookaheadDelegate), 2, (Object) null);
                this.this$0.layoutState = oldLayoutState;
                if (this.this$0.getCoordinatesAccessedDuringPlacement() && lookaheadDelegate.isPlacingForAlignment$ui_release()) {
                    requestLayout();
                }
                this.this$0.lookaheadLayoutPendingForAlignment = false;
            }
            if (getAlignmentLines().getUsedDuringParentLayout$ui_release()) {
                getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
            }
            if (getAlignmentLines().getDirty$ui_release() && getAlignmentLines().getRequired$ui_release()) {
                getAlignmentLines().recalculate();
            }
        }

        /* access modifiers changed from: private */
        public final void markSubtreeNotPlaced() {
            setPlaced(false);
            MutableVector this_$iv$iv$iv = this.this$0.layoutNode.get_children$ui_release();
            int size$iv$iv$iv = this_$iv$iv$iv.getSize();
            if (size$iv$iv$iv > 0) {
                int i$iv$iv$iv = 0;
                Object[] content$iv$iv$iv = this_$iv$iv$iv.getContent();
                do {
                    LookaheadPassDelegate it = ((LayoutNode) content$iv$iv$iv[i$iv$iv$iv]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(it);
                    it.markSubtreeNotPlaced();
                    i$iv$iv$iv++;
                } while (i$iv$iv$iv < size$iv$iv$iv);
            }
        }

        public Map<AlignmentLine, Integer> calculateAlignmentLines() {
            if (!this.duringAlignmentLinesQuery) {
                if (this.this$0.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadMeasuring) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                    if (getAlignmentLines().getDirty$ui_release()) {
                        this.this$0.markLookaheadLayoutPending$ui_release();
                    }
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(true);
                }
            }
            LookaheadDelegate lookaheadDelegate$ui_release = getInnerCoordinator().getLookaheadDelegate$ui_release();
            if (lookaheadDelegate$ui_release != null) {
                lookaheadDelegate$ui_release.setPlacingForAlignment$ui_release(true);
            }
            layoutChildren();
            LookaheadDelegate lookaheadDelegate$ui_release2 = getInnerCoordinator().getLookaheadDelegate$ui_release();
            if (lookaheadDelegate$ui_release2 != null) {
                lookaheadDelegate$ui_release2.setPlacingForAlignment$ui_release(false);
            }
            return getAlignmentLines().getLastCalculation();
        }

        public AlignmentLinesOwner getParentAlignmentLinesOwner() {
            LayoutNodeLayoutDelegate layoutDelegate$ui_release;
            LayoutNode parent$ui_release = this.this$0.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || (layoutDelegate$ui_release = parent$ui_release.getLayoutDelegate$ui_release()) == null) {
                return null;
            }
            return layoutDelegate$ui_release.getLookaheadAlignmentLinesOwner$ui_release();
        }

        public void forEachChildAlignmentLinesOwner(Function1<? super AlignmentLinesOwner, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            List $this$fastForEach$iv = this.this$0.layoutNode.getChildren$ui_release();
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = $this$fastForEach$iv.get(index$iv).getLayoutDelegate$ui_release().getLookaheadAlignmentLinesOwner$ui_release();
                Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
                block.invoke(lookaheadAlignmentLinesOwner$ui_release);
            }
        }

        public void requestLayout() {
            LayoutNode.requestLookaheadRelayout$ui_release$default(this.this$0.layoutNode, false, 1, (Object) null);
        }

        public void requestMeasure() {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(this.this$0.layoutNode, false, 1, (Object) null);
        }

        public final void notifyChildrenUsingCoordinatesWhilePlacing() {
            if (this.this$0.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                List $this$fastForEach$iv = this.this$0.layoutNode.getChildren$ui_release();
                int size = $this$fastForEach$iv.size();
                for (int index$iv = 0; index$iv < size; index$iv++) {
                    LayoutNode child = $this$fastForEach$iv.get(index$iv);
                    LayoutNodeLayoutDelegate childLayoutDelegate = child.getLayoutDelegate$ui_release();
                    if (childLayoutDelegate.getCoordinatesAccessedDuringPlacement() && !childLayoutDelegate.getLayoutPending$ui_release()) {
                        LayoutNode.requestLookaheadRelayout$ui_release$default(child, false, 1, (Object) null);
                    }
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = childLayoutDelegate.getLookaheadPassDelegate$ui_release();
                    if (lookaheadPassDelegate$ui_release != null) {
                        lookaheadPassDelegate$ui_release.notifyChildrenUsingCoordinatesWhilePlacing();
                    }
                }
            }
        }

        /* renamed from: measure-BRTryo0  reason: not valid java name */
        public Placeable m5048measureBRTryo0(long constraints) {
            trackLookaheadMeasurementByParent(this.this$0.layoutNode);
            if (this.this$0.layoutNode.getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                this.this$0.layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
            }
            m5050remeasureBRTryo0(constraints);
            return this;
        }

        private final void trackLookaheadMeasurementByParent(LayoutNode $this$trackLookaheadMeasurementByParent) {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode parent = $this$trackLookaheadMeasurementByParent.getParent$ui_release();
            if (parent != null) {
                if ($this$trackLookaheadMeasurementByParent.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.NotUsed || $this$trackLookaheadMeasurementByParent.getCanMultiMeasure$ui_release()) {
                    switch (WhenMappings.$EnumSwitchMapping$0[parent.getLayoutState$ui_release().ordinal()]) {
                        case 1:
                        case 2:
                            usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                            break;
                        case 3:
                        case 4:
                            usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                            break;
                        default:
                            throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent.getLayoutState$ui_release());
                    }
                    $this$trackLookaheadMeasurementByParent.setMeasuredByParentInLookahead$ui_release(usageByParent);
                    return;
                }
                throw new IllegalStateException(("measure() may not be called multiple times on the same Measurable. Current state " + $this$trackLookaheadMeasurementByParent.getMeasuredByParentInLookahead$ui_release() + ". Parent state " + parent.getLayoutState$ui_release() + '.').toString());
            }
            $this$trackLookaheadMeasurementByParent.setMeasuredByParentInLookahead$ui_release(LayoutNode.UsageByParent.NotUsed);
        }

        public Object getParentData() {
            return this.parentData;
        }

        /* renamed from: remeasure-BRTryo0  reason: not valid java name */
        public final boolean m5050remeasureBRTryo0(long constraints) {
            LayoutNode parent = this.this$0.layoutNode.getParent$ui_release();
            boolean sizeChanged = true;
            this.this$0.layoutNode.setCanMultiMeasure$ui_release(this.this$0.layoutNode.getCanMultiMeasure$ui_release() || (parent != null && parent.getCanMultiMeasure$ui_release()));
            if (!this.this$0.layoutNode.getLookaheadMeasurePending$ui_release()) {
                Constraints constraints2 = this.lookaheadConstraints;
                if (constraints2 == null ? false : Constraints.m5923equalsimpl0(constraints2.m5936unboximpl(), constraints)) {
                    return false;
                }
            }
            this.lookaheadConstraints = Constraints.m5918boximpl(constraints);
            getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
            forEachChildAlignmentLinesOwner(LayoutNodeLayoutDelegate$LookaheadPassDelegate$remeasure$1.INSTANCE);
            this.measuredOnce = true;
            LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            if (lookaheadDelegate != null) {
                long lastLookaheadSize = IntSizeKt.IntSize(lookaheadDelegate.getWidth(), lookaheadDelegate.getHeight());
                this.this$0.m5043performLookaheadMeasureBRTryo0(constraints);
                m4901setMeasuredSizeozmzZPI(IntSizeKt.IntSize(lookaheadDelegate.getWidth(), lookaheadDelegate.getHeight()));
                if (IntSize.m6146getWidthimpl(lastLookaheadSize) == lookaheadDelegate.getWidth() && IntSize.m6145getHeightimpl(lastLookaheadSize) == lookaheadDelegate.getHeight()) {
                    sizeChanged = false;
                }
                return sizeChanged;
            }
            throw new IllegalStateException("Lookahead result from lookaheadRemeasure cannot be null".toString());
        }

        /* access modifiers changed from: protected */
        /* renamed from: placeAt-f8xVGno  reason: not valid java name */
        public void m5049placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            this.this$0.layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
            this.placedOnce = true;
            if (!IntOffset.m6103equalsimpl0(position, this.lastPosition)) {
                notifyChildrenUsingCoordinatesWhilePlacing();
            }
            getAlignmentLines().setUsedByModifierLayout$ui_release(false);
            Owner owner = LayoutNodeKt.requireOwner(this.this$0.layoutNode);
            this.this$0.setCoordinatesAccessedDuringPlacement(false);
            OwnerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release$default(owner.getSnapshotObserver(), this.this$0.layoutNode, false, new LayoutNodeLayoutDelegate$LookaheadPassDelegate$placeAt$1(this.this$0, position), 2, (Object) null);
            this.lastPosition = position;
            this.this$0.layoutState = LayoutNode.LayoutState.Idle;
        }

        public int getMeasuredWidth() {
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.getMeasuredWidth();
        }

        public int getMeasuredHeight() {
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.getMeasuredHeight();
        }

        public int get(AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            LayoutNode parent$ui_release = this.this$0.layoutNode.getParent$ui_release();
            LayoutNode.LayoutState layoutState = null;
            if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LookaheadMeasuring) {
                getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
            } else {
                LayoutNode parent$ui_release2 = this.this$0.layoutNode.getParent$ui_release();
                if (parent$ui_release2 != null) {
                    layoutState = parent$ui_release2.getLayoutState$ui_release();
                }
                if (layoutState == LayoutNode.LayoutState.LookaheadLayingOut) {
                    getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
                }
            }
            this.duringAlignmentLinesQuery = true;
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            int result = lookaheadDelegate$ui_release.get(alignmentLine);
            this.duringAlignmentLinesQuery = false;
            return result;
        }

        public int minIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.minIntrinsicWidth(height);
        }

        public int maxIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.maxIntrinsicWidth(height);
        }

        public int minIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.minIntrinsicHeight(width);
        }

        public int maxIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            return lookaheadDelegate$ui_release.maxIntrinsicHeight(width);
        }

        private final void onIntrinsicsQueried() {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode.requestLookaheadRemeasure$ui_release$default(this.this$0.layoutNode, false, 1, (Object) null);
            LayoutNode parent = this.this$0.layoutNode.getParent$ui_release();
            if (parent != null && this.this$0.layoutNode.getIntrinsicsUsageByParent$ui_release() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNode access$getLayoutNode$p = this.this$0.layoutNode;
                switch (WhenMappings.$EnumSwitchMapping$0[parent.getLayoutState$ui_release().ordinal()]) {
                    case 2:
                        usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                        break;
                    case 3:
                        usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                        break;
                    default:
                        usageByParent = parent.getIntrinsicsUsageByParent$ui_release();
                        break;
                }
                access$getLayoutNode$p.setIntrinsicsUsageByParent$ui_release(usageByParent);
            }
        }

        public final void invalidateIntrinsicsParent(boolean forceRequest) {
            LayoutNode parent$ui_release;
            LayoutNode parent = this.this$0.layoutNode.getParent$ui_release();
            LayoutNode.UsageByParent intrinsicsUsageByParent = this.this$0.layoutNode.getIntrinsicsUsageByParent$ui_release();
            if (parent != null && intrinsicsUsageByParent != LayoutNode.UsageByParent.NotUsed) {
                LayoutNode intrinsicsUsingParent = parent;
                while (intrinsicsUsingParent.getIntrinsicsUsageByParent$ui_release() == intrinsicsUsageByParent && (parent$ui_release = intrinsicsUsingParent.getParent$ui_release()) != null) {
                    intrinsicsUsingParent = parent$ui_release;
                }
                switch (WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent.ordinal()]) {
                    case 1:
                        intrinsicsUsingParent.requestLookaheadRemeasure$ui_release(forceRequest);
                        return;
                    case 2:
                        intrinsicsUsingParent.requestLookaheadRelayout$ui_release(forceRequest);
                        return;
                    default:
                        throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
                }
            }
        }

        public final void invalidateParentData() {
            this.parentDataDirty = true;
        }

        public final boolean updateParentData() {
            if (!this.parentDataDirty) {
                return false;
            }
            this.parentDataDirty = false;
            Object parentData2 = getParentData();
            LookaheadDelegate lookaheadDelegate$ui_release = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release);
            boolean changed = !Intrinsics.areEqual(parentData2, lookaheadDelegate$ui_release.getParentData());
            LookaheadDelegate lookaheadDelegate$ui_release2 = this.this$0.getOuterCoordinator().getLookaheadDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadDelegate$ui_release2);
            this.parentData = lookaheadDelegate$ui_release2.getParentData();
            return changed;
        }

        public final void onPlaced() {
            if (!isPlaced()) {
                setPlaced(true);
                if (!this.isPreviouslyPlaced) {
                    requestSubtreeForLookahead();
                }
            }
        }

        private final void requestSubtreeForLookahead() {
            MutableVector this_$iv$iv = this.this$0.layoutNode.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                    it.rescheduleRemeasureOrRelayout$ui_release(it);
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = it.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                    Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                    lookaheadPassDelegate$ui_release.requestSubtreeForLookahead();
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }

        private final void onBeforeLayoutChildren() {
            LayoutNode this_$iv = this.this$0.layoutNode;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.this$0;
            MutableVector this_$iv$iv = this_$iv.get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                    if (it.getLookaheadMeasurePending$ui_release() && it.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                        LookaheadPassDelegate lookaheadPassDelegate$ui_release = it.getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                        Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                        Constraints r11 = m5047getLastConstraintsDWUhwKw();
                        Intrinsics.checkNotNull(r11);
                        if (lookaheadPassDelegate$ui_release.m5050remeasureBRTryo0(r11.m5936unboximpl())) {
                            LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, false, 1, (Object) null);
                        }
                    }
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }

        public final void replace() {
            if (this.placedOnce) {
                m5049placeAtf8xVGno(this.lastPosition, 0.0f, (Function1<? super GraphicsLayerScope, Unit>) null);
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* access modifiers changed from: private */
    public final boolean isOutMostLookaheadRoot(LayoutNode $this$isOutMostLookaheadRoot) {
        LookaheadScope mLookaheadScope$ui_release = $this$isOutMostLookaheadRoot.getMLookaheadScope$ui_release();
        return Intrinsics.areEqual((Object) mLookaheadScope$ui_release != null ? mLookaheadScope$ui_release.getRoot() : null, (Object) $this$isOutMostLookaheadRoot);
    }

    /* access modifiers changed from: private */
    /* renamed from: performMeasure-BRTryo0  reason: not valid java name */
    public final void m5044performMeasureBRTryo0(long constraints) {
        if (this.layoutState == LayoutNode.LayoutState.Idle) {
            this.layoutState = LayoutNode.LayoutState.Measuring;
            this.measurePending = false;
            LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver().observeMeasureSnapshotReads$ui_release(this.layoutNode, false, new LayoutNodeLayoutDelegate$performMeasure$2(this, constraints));
            if (this.layoutState == LayoutNode.LayoutState.Measuring) {
                markLayoutPending$ui_release();
                this.layoutState = LayoutNode.LayoutState.Idle;
                return;
            }
            return;
        }
        throw new IllegalStateException("layout state is not idle before measure starts".toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: performLookaheadMeasure-BRTryo0  reason: not valid java name */
    public final void m5043performLookaheadMeasureBRTryo0(long constraints) {
        this.layoutState = LayoutNode.LayoutState.LookaheadMeasuring;
        this.lookaheadMeasurePending = false;
        OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release$default(LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver(), this.layoutNode, false, new LayoutNodeLayoutDelegate$performLookaheadMeasure$1(this, constraints), 2, (Object) null);
        markLookaheadLayoutPending$ui_release();
        if (isOutMostLookaheadRoot(this.layoutNode)) {
            markLayoutPending$ui_release();
        } else {
            markMeasurePending$ui_release();
        }
        this.layoutState = LayoutNode.LayoutState.Idle;
    }

    public final void onLookaheadScopeChanged$ui_release(LookaheadScope newScope) {
        LookaheadPassDelegate lookaheadPassDelegate2;
        if (newScope != null) {
            lookaheadPassDelegate2 = new LookaheadPassDelegate(this, newScope);
        } else {
            lookaheadPassDelegate2 = null;
        }
        this.lookaheadPassDelegate = lookaheadPassDelegate2;
    }

    public final void updateParentData() {
        LayoutNode parent$ui_release;
        if (this.measurePassDelegate.updateParentData() && (parent$ui_release = this.layoutNode.getParent$ui_release()) != null) {
            LayoutNode.requestRemeasure$ui_release$default(parent$ui_release, false, 1, (Object) null);
        }
        LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
        if (!(lookaheadPassDelegate2 != null && lookaheadPassDelegate2.updateParentData())) {
            return;
        }
        if (isOutMostLookaheadRoot(this.layoutNode)) {
            LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
            if (parent$ui_release2 != null) {
                LayoutNode.requestRemeasure$ui_release$default(parent$ui_release2, false, 1, (Object) null);
                return;
            }
            return;
        }
        LayoutNode parent$ui_release3 = this.layoutNode.getParent$ui_release();
        if (parent$ui_release3 != null) {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(parent$ui_release3, false, 1, (Object) null);
        }
    }

    public final void invalidateParentData() {
        this.measurePassDelegate.invalidateParentData();
        LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null) {
            lookaheadPassDelegate2.invalidateParentData();
        }
    }

    public final void resetAlignmentLines() {
        AlignmentLines alignmentLines;
        this.measurePassDelegate.getAlignmentLines().reset$ui_release();
        LookaheadPassDelegate lookaheadPassDelegate2 = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null && (alignmentLines = lookaheadPassDelegate2.getAlignmentLines()) != null) {
            alignmentLines.reset$ui_release();
        }
    }

    public final void markChildrenDirty() {
        this.measurePassDelegate.setChildMeasurablesDirty$ui_release(true);
        LookaheadPassDelegate it = this.lookaheadPassDelegate;
        if (it != null) {
            it.setChildMeasurablesDirty$ui_release(true);
        }
    }
}
