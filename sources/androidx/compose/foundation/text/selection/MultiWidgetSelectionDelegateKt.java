package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a-\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001ak\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u0005H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"getAssembledSelectionInfo", "Landroidx/compose/foundation/text/selection/Selection;", "newSelectionRange", "Landroidx/compose/ui/text/TextRange;", "handlesCrossed", "", "selectableId", "", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getAssembledSelectionInfo-vJH6DeI", "(JZJLandroidx/compose/ui/text/TextLayoutResult;)Landroidx/compose/foundation/text/selection/Selection;", "getOffsetForPosition", "", "bounds", "Landroidx/compose/ui/geometry/Rect;", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-0AR0LA0", "(Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/geometry/Rect;J)I", "getTextSelectionInfo", "Lkotlin/Pair;", "startHandlePosition", "endHandlePosition", "previousHandlePosition", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "previousSelection", "isStartHandle", "getTextSelectionInfo-yM0VcXU", "(Landroidx/compose/ui/text/TextLayoutResult;JJLandroidx/compose/ui/geometry/Offset;JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Landroidx/compose/foundation/text/selection/Selection;Z)Lkotlin/Pair;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: MultiWidgetSelectionDelegate.kt */
public final class MultiWidgetSelectionDelegateKt {
    /* renamed from: getTextSelectionInfo-yM0VcXU$default  reason: not valid java name */
    public static /* synthetic */ Pair m1258getTextSelectionInfoyM0VcXU$default(TextLayoutResult textLayoutResult, long j, long j2, Offset offset, long j3, SelectionAdjustment selectionAdjustment, Selection selection, boolean z, int i, Object obj) {
        int i2 = i;
        return m1257getTextSelectionInfoyM0VcXU(textLayoutResult, j, j2, offset, j3, selectionAdjustment, (i2 & 64) != 0 ? null : selection, (i2 & 128) != 0 ? true : z);
    }

    /* renamed from: getTextSelectionInfo-yM0VcXU  reason: not valid java name */
    public static final Pair<Selection, Boolean> m1257getTextSelectionInfoyM0VcXU(TextLayoutResult textLayoutResult, long startHandlePosition, long endHandlePosition, Offset previousHandlePosition, long selectableId, SelectionAdjustment adjustment, Selection previousSelection, boolean isStartHandle) {
        int i;
        boolean handleUpdated;
        TextLayoutResult textLayoutResult2 = textLayoutResult;
        Selection selection = previousSelection;
        Intrinsics.checkNotNullParameter(textLayoutResult2, "textLayoutResult");
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        Rect bounds = new Rect(0.0f, 0.0f, (float) IntSize.m6146getWidthimpl(textLayoutResult.m5447getSizeYbymL2g()), (float) IntSize.m6145getHeightimpl(textLayoutResult.m5447getSizeYbymL2g()));
        TextRange textRange = null;
        boolean consumed = false;
        if (!SelectionMode.Vertical.m1320isSelected2x9bVx0$foundation_release(bounds, startHandlePosition, endHandlePosition)) {
            return new Pair<>(null, false);
        }
        int rawStartHandleOffset = m1256getOffsetForPosition0AR0LA0(textLayoutResult2, bounds, startHandlePosition);
        int rawEndHandleOffset = m1256getOffsetForPosition0AR0LA0(textLayoutResult2, bounds, endHandlePosition);
        if (previousHandlePosition != null) {
            i = m1256getOffsetForPosition0AR0LA0(textLayoutResult2, bounds, previousHandlePosition.m2925unboximpl());
        } else {
            i = -1;
        }
        int rawPreviousHandleOffset = i;
        long TextRange = TextRangeKt.TextRange(rawStartHandleOffset, rawEndHandleOffset);
        if (selection != null) {
            textRange = TextRange.m5462boximpl(previousSelection.m1263toTextRanged9O1mEE());
        }
        int rawPreviousHandleOffset2 = rawPreviousHandleOffset;
        Rect rect = bounds;
        long adjustedTextRange = adjustment.m1264adjustZXO7KMw(textLayoutResult, TextRange, rawPreviousHandleOffset2, isStartHandle, textRange);
        Selection newSelection = m1255getAssembledSelectionInfovJH6DeI(adjustedTextRange, TextRange.m5473getReversedimpl(adjustedTextRange), selectableId, textLayoutResult);
        boolean selectionUpdated = !Intrinsics.areEqual((Object) newSelection, (Object) selection);
        if (isStartHandle) {
            handleUpdated = rawStartHandleOffset != rawPreviousHandleOffset2;
        } else {
            handleUpdated = rawEndHandleOffset != rawPreviousHandleOffset2;
        }
        if (handleUpdated || selectionUpdated) {
            consumed = true;
        }
        return new Pair<>(newSelection, Boolean.valueOf(consumed));
    }

    /* renamed from: getOffsetForPosition-0AR0LA0  reason: not valid java name */
    public static final int m1256getOffsetForPosition0AR0LA0(TextLayoutResult textLayoutResult, Rect bounds, long position) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        int length = textLayoutResult.getLayoutInput().getText().length();
        if (bounds.m2941containsk4lQ0M(position)) {
            return RangesKt.coerceIn(textLayoutResult.m5446getOffsetForPositionk4lQ0M(position), 0, length);
        }
        if (SelectionMode.Vertical.m1319compare3MmeM6k$foundation_release(position, bounds) < 0) {
            return 0;
        }
        return length;
    }

    /* access modifiers changed from: private */
    /* renamed from: getAssembledSelectionInfo-vJH6DeI  reason: not valid java name */
    public static final Selection m1255getAssembledSelectionInfovJH6DeI(long newSelectionRange, boolean handlesCrossed, long selectableId, TextLayoutResult textLayoutResult) {
        return new Selection(new Selection.AnchorInfo(textLayoutResult.getBidiRunDirection(TextRange.m5474getStartimpl(newSelectionRange)), TextRange.m5474getStartimpl(newSelectionRange), selectableId), new Selection.AnchorInfo(textLayoutResult.getBidiRunDirection(Math.max(TextRange.m5469getEndimpl(newSelectionRange) - 1, 0)), TextRange.m5469getEndimpl(newSelectionRange), selectableId), handlesCrossed);
    }
}
