package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\nH\u0016J%\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010&\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J%\u0010)\u001a\u00020%2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001d\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u001d\u00100\u001a\u00020%2\u0006\u0010-\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010/J%\u00102\u001a\u0002032\u0006\u0010\"\u001a\u00020\u000f2\u0006\u00104\u001a\u000205H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u001d\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020%H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010/R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u00020\u001a8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutCoordinatesImpl;", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "isAttached", "", "()Z", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "parentCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "relativeToSource", "localLookaheadPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;J)J", "localPositionOf", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToWindow", "localToWindow-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadLayoutCoordinates.kt */
public final class LookaheadLayoutCoordinatesImpl implements LookaheadLayoutCoordinates {
    private final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinatesImpl(LookaheadDelegate lookaheadDelegate2) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate2, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate2;
    }

    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    public final NodeCoordinator getCoordinator() {
        return this.lookaheadDelegate.getCoordinator();
    }

    /* renamed from: localLookaheadPositionOf-R5De75A  reason: not valid java name */
    public long m4857localLookaheadPositionOfR5De75A(LookaheadLayoutCoordinates sourceCoordinates, long relativeToSource) {
        LookaheadLayoutCoordinates lookaheadLayoutCoordinates = sourceCoordinates;
        Intrinsics.checkNotNullParameter(lookaheadLayoutCoordinates, "sourceCoordinates");
        LookaheadDelegate source = ((LookaheadLayoutCoordinatesImpl) lookaheadLayoutCoordinates).lookaheadDelegate;
        NodeCoordinator commonAncestor = getCoordinator().findCommonAncestor$ui_release(source.getCoordinator());
        LookaheadDelegate ancestor = commonAncestor.getLookaheadDelegate$ui_release();
        if (ancestor != null) {
            long arg0$iv = source.m5062positionInBjo55l4$ui_release(ancestor);
            long $this$round_u2dk_u2d4lQ0M$iv = relativeToSource;
            long other$iv = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m2915getXimpl($this$round_u2dk_u2d4lQ0M$iv)), MathKt.roundToInt(Offset.m2916getYimpl($this$round_u2dk_u2d4lQ0M$iv)));
            long arg0$iv2 = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(arg0$iv) + IntOffset.m6104getXimpl(other$iv), IntOffset.m6105getYimpl(arg0$iv) + IntOffset.m6105getYimpl(other$iv));
            long other$iv2 = this.lookaheadDelegate.m5062positionInBjo55l4$ui_release(ancestor);
            long arg0$iv3 = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(arg0$iv2) - IntOffset.m6104getXimpl(other$iv2), IntOffset.m6105getYimpl(arg0$iv2) - IntOffset.m6105getYimpl(other$iv2));
            LookaheadDelegate lookaheadDelegate2 = source;
            return OffsetKt.Offset((float) IntOffset.m6104getXimpl(arg0$iv3), (float) IntOffset.m6105getYimpl(arg0$iv3));
        }
        NodeCoordinator nodeCoordinator = commonAncestor;
        LookaheadDelegate sourceRoot = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(source);
        long arg0$iv4 = source.m5062positionInBjo55l4$ui_release(sourceRoot);
        long other$iv3 = sourceRoot.m5059getPositionnOccac();
        long arg0$iv5 = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(arg0$iv4) + IntOffset.m6104getXimpl(other$iv3), IntOffset.m6105getYimpl(arg0$iv4) + IntOffset.m6105getYimpl(other$iv3));
        long $this$round_u2dk_u2d4lQ0M$iv2 = relativeToSource;
        long other$iv4 = IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m2915getXimpl($this$round_u2dk_u2d4lQ0M$iv2)), MathKt.roundToInt(Offset.m2916getYimpl($this$round_u2dk_u2d4lQ0M$iv2)));
        long arg0$iv6 = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(arg0$iv5) + IntOffset.m6104getXimpl(other$iv4), IntOffset.m6105getYimpl(arg0$iv5) + IntOffset.m6105getYimpl(other$iv4));
        LookaheadDelegate $this$localLookaheadPositionOf_R5De75A_u24lambda_u242_u24lambda_u241 = this.lookaheadDelegate;
        long arg0$iv7 = $this$localLookaheadPositionOf_R5De75A_u24lambda_u242_u24lambda_u241.m5062positionInBjo55l4$ui_release(LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate($this$localLookaheadPositionOf_R5De75A_u24lambda_u242_u24lambda_u241));
        long other$iv5 = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate($this$localLookaheadPositionOf_R5De75A_u24lambda_u242_u24lambda_u241).m5059getPositionnOccac();
        LookaheadDelegate lookaheadDelegate3 = source;
        long other$iv6 = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(arg0$iv7) + IntOffset.m6104getXimpl(other$iv5), IntOffset.m6105getYimpl(arg0$iv7) + IntOffset.m6105getYimpl(other$iv5));
        long other$iv7 = IntOffsetKt.IntOffset(IntOffset.m6104getXimpl(arg0$iv6) - IntOffset.m6104getXimpl(other$iv6), IntOffset.m6105getYimpl(arg0$iv6) - IntOffset.m6105getYimpl(other$iv6));
        NodeCoordinator wrappedBy$ui_release = LookaheadLayoutCoordinatesKt.getRootLookaheadDelegate(this.lookaheadDelegate).getCoordinator().getWrappedBy$ui_release();
        Intrinsics.checkNotNull(wrappedBy$ui_release);
        NodeCoordinator wrappedBy$ui_release2 = sourceRoot.getCoordinator().getWrappedBy$ui_release();
        Intrinsics.checkNotNull(wrappedBy$ui_release2);
        long $this$toOffset_u2d_u2dgyyYBs$iv = other$iv7;
        return wrappedBy$ui_release.m5103localPositionOfR5De75A(wrappedBy$ui_release2, OffsetKt.Offset((float) IntOffset.m6104getXimpl($this$toOffset_u2d_u2dgyyYBs$iv), (float) IntOffset.m6105getYimpl($this$toOffset_u2d_u2dgyyYBs$iv)));
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public long m4856getSizeYbymL2g() {
        return getCoordinator().m5096getSizeYbymL2g();
    }

    public Set<AlignmentLine> getProvidedAlignmentLines() {
        return getCoordinator().getProvidedAlignmentLines();
    }

    public LayoutCoordinates getParentLayoutCoordinates() {
        return getCoordinator().getParentLayoutCoordinates();
    }

    public LayoutCoordinates getParentCoordinates() {
        return getCoordinator().getParentCoordinates();
    }

    public boolean isAttached() {
        return getCoordinator().isAttached();
    }

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    public long m4862windowToLocalMKHz9U(long relativeToWindow) {
        return getCoordinator().m5112windowToLocalMKHz9U(relativeToWindow);
    }

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    public long m4860localToWindowMKHz9U(long relativeToLocal) {
        return getCoordinator().m5105localToWindowMKHz9U(relativeToLocal);
    }

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    public long m4859localToRootMKHz9U(long relativeToLocal) {
        return getCoordinator().m5104localToRootMKHz9U(relativeToLocal);
    }

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    public long m4858localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        return getCoordinator().m5103localPositionOfR5De75A(sourceCoordinates, relativeToSource);
    }

    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        return getCoordinator().localBoundingBoxOf(sourceCoordinates, clipBounds);
    }

    /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
    public void m4861transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        getCoordinator().m5110transformFromEL8BTi8(sourceCoordinates, matrix);
    }

    public int get(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return getCoordinator().get(alignmentLine);
    }
}
