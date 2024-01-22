package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0000\u001a!\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0013*\u00020\u0018H\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "manager", "Landroidx/compose/foundation/text/selection/SelectionManager;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/SelectionManager;J)J", "getCurrentSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "selectable", "Landroidx/compose/foundation/text/selection/Selectable;", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "merge", "lhs", "rhs", "containsInclusive", "", "Landroidx/compose/ui/geometry/Rect;", "offset", "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "visibleBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionManager.kt */
public final class SelectionManagerKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SelectionManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.SelectionStart.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Handle.SelectionEnd.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Handle.Cursor.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r1.merge(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.text.selection.Selection merge(androidx.compose.foundation.text.selection.Selection r1, androidx.compose.foundation.text.selection.Selection r2) {
        /*
            if (r1 == 0) goto L_0x0008
            androidx.compose.foundation.text.selection.Selection r0 = r1.merge(r2)
            if (r0 != 0) goto L_0x0009
        L_0x0008:
            r0 = r2
        L_0x0009:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManagerKt.merge(androidx.compose.foundation.text.selection.Selection, androidx.compose.foundation.text.selection.Selection):androidx.compose.foundation.text.selection.Selection");
    }

    private static final long calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(SelectionManager $manager, long $magnifierSize, Selection.AnchorInfo anchor, boolean isStartHandle) {
        Selectable selectable = $manager.getAnchorSelectable$foundation_release(anchor);
        if (selectable == null) {
            return Offset.Companion.m2930getUnspecifiedF1C5BW0();
        }
        LayoutCoordinates containerCoordinates = $manager.getContainerLayoutCoordinates();
        if (containerCoordinates == null) {
            return Offset.Companion.m2930getUnspecifiedF1C5BW0();
        }
        LayoutCoordinates selectableCoordinates = selectable.getLayoutCoordinates();
        if (selectableCoordinates == null) {
            return Offset.Companion.m2930getUnspecifiedF1C5BW0();
        }
        int offset = anchor.getOffset();
        if (!isStartHandle) {
            offset--;
        }
        if (offset > selectable.getLastVisibleOffset()) {
            return Offset.Companion.m2930getUnspecifiedF1C5BW0();
        }
        Offset r6 = $manager.m1299getCurrentDragPosition_m7T9E();
        Intrinsics.checkNotNull(r6);
        float dragX = Offset.m2915getXimpl(selectableCoordinates.m4840localPositionOfR5De75A(containerCoordinates, r6.m2925unboximpl()));
        long line = selectable.m1261getRangeOfLineContainingjx7JFs(offset);
        Rect lineMin = selectable.getBoundingBox(TextRange.m5472getMinimpl(line));
        Rect lineMax = selectable.getBoundingBox(RangesKt.coerceAtLeast(TextRange.m5471getMaximpl(line) - 1, TextRange.m5472getMinimpl(line)));
        float centerX = RangesKt.coerceIn(dragX, Math.min(lineMin.getLeft(), lineMax.getLeft()), Math.max(lineMin.getRight(), lineMax.getRight()));
        if (Math.abs(dragX - centerX) > ((float) (IntSize.m6146getWidthimpl($magnifierSize) / 2))) {
            return Offset.Companion.m2930getUnspecifiedF1C5BW0();
        }
        return containerCoordinates.m4840localPositionOfR5De75A(selectableCoordinates, OffsetKt.Offset(centerX, Offset.m2916getYimpl(selectable.getBoundingBox(offset).m2945getCenterF1C5BW0())));
    }

    /* renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c  reason: not valid java name */
    public static final long m1313calculateSelectionMagnifierCenterAndroidO0kMr_c(SelectionManager manager, long magnifierSize) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Selection selection = manager.getSelection();
        if (selection == null) {
            return Offset.Companion.m2930getUnspecifiedF1C5BW0();
        }
        Handle draggingHandle = manager.getDraggingHandle();
        switch (draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()]) {
            case -1:
                return Offset.Companion.m2930getUnspecifiedF1C5BW0();
            case 1:
                return calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(manager, magnifierSize, selection.getStart(), true);
            case 2:
                return calculateSelectionMagnifierCenterAndroid_O0kMr_c$getMagnifierCenter(manager, magnifierSize, selection.getEnd(), false);
            case 3:
                throw new IllegalStateException("SelectionContainer does not support cursor".toString());
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final AnnotatedString getCurrentSelectedText(Selectable selectable, Selection selection) {
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        Intrinsics.checkNotNullParameter(selection, "selection");
        AnnotatedString currentText = selectable.getText();
        if (selectable.getSelectableId() != selection.getStart().getSelectableId() && selectable.getSelectableId() != selection.getEnd().getSelectableId()) {
            return currentText;
        }
        if (selectable.getSelectableId() == selection.getStart().getSelectableId() && selectable.getSelectableId() == selection.getEnd().getSelectableId()) {
            if (selection.getHandlesCrossed()) {
                return currentText.subSequence(selection.getEnd().getOffset(), selection.getStart().getOffset());
            }
            return currentText.subSequence(selection.getStart().getOffset(), selection.getEnd().getOffset());
        } else if (selectable.getSelectableId() == selection.getStart().getSelectableId()) {
            if (selection.getHandlesCrossed()) {
                return currentText.subSequence(0, selection.getStart().getOffset());
            }
            return currentText.subSequence(selection.getStart().getOffset(), currentText.length());
        } else if (selection.getHandlesCrossed()) {
            return currentText.subSequence(selection.getEnd().getOffset(), currentText.length());
        } else {
            return currentText.subSequence(0, selection.getEnd().getOffset());
        }
    }

    public static final Rect visibleBounds(LayoutCoordinates $this$visibleBounds) {
        Intrinsics.checkNotNullParameter($this$visibleBounds, "<this>");
        Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow($this$visibleBounds);
        return RectKt.m2953Rect0a9Yr6o($this$visibleBounds.m4844windowToLocalMKHz9U(boundsInWindow.m2950getTopLeftF1C5BW0()), $this$visibleBounds.m4844windowToLocalMKHz9U(boundsInWindow.m2944getBottomRightF1C5BW0()));
    }

    /* renamed from: containsInclusive-Uv8p0NA  reason: not valid java name */
    public static final boolean m1314containsInclusiveUv8p0NA(Rect $this$containsInclusive_u2dUv8p0NA, long offset) {
        Intrinsics.checkNotNullParameter($this$containsInclusive_u2dUv8p0NA, "$this$containsInclusive");
        float left = $this$containsInclusive_u2dUv8p0NA.getLeft();
        float right = $this$containsInclusive_u2dUv8p0NA.getRight();
        float r2 = Offset.m2915getXimpl(offset);
        if (left <= r2 && r2 <= right) {
            float top = $this$containsInclusive_u2dUv8p0NA.getTop();
            float bottom = $this$containsInclusive_u2dUv8p0NA.getBottom();
            float r22 = Offset.m2916getYimpl(offset);
            if (top <= r22 && r22 <= bottom) {
                return true;
            }
        }
        return false;
    }
}
