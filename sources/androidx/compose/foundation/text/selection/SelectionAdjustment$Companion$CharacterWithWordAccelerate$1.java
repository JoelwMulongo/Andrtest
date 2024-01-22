package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J?\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ(\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0002J8\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0002J@\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0014\u0010\u0019\u001a\u00020\n*\u00020\u00052\u0006\u0010\u001a\u001a\u00020\bH\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"androidx/compose/foundation/text/selection/SelectionAdjustment$Companion$CharacterWithWordAccelerate$1", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "adjust", "Landroidx/compose/ui/text/TextRange;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "newRawSelectionRange", "previousHandleOffset", "", "isStartHandle", "", "previousSelectionRange", "adjust-ZXO7KMw", "(Landroidx/compose/ui/text/TextLayoutResult;JIZLandroidx/compose/ui/text/TextRange;)J", "isExpanding", "newRawOffset", "previousRawOffset", "isStart", "previousReversed", "snapToWordBoundary", "currentLine", "otherBoundaryOffset", "isReversed", "updateSelectionBoundary", "previousAdjustedOffset", "isAtWordBoundary", "offset", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionAdjustment.kt */
public final class SelectionAdjustment$Companion$CharacterWithWordAccelerate$1 implements SelectionAdjustment {
    SelectionAdjustment$Companion$CharacterWithWordAccelerate$1() {
    }

    /* renamed from: adjust-ZXO7KMw  reason: not valid java name */
    public long m1268adjustZXO7KMw(TextLayoutResult textLayoutResult, long newRawSelectionRange, int previousHandleOffset, boolean isStartHandle, TextRange previousSelectionRange) {
        int end;
        int start;
        boolean z = isStartHandle;
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        if (previousSelectionRange == null) {
            return SelectionAdjustment.Companion.$$INSTANCE.getWord().m1264adjustZXO7KMw(textLayoutResult, newRawSelectionRange, previousHandleOffset, isStartHandle, previousSelectionRange);
        }
        if (TextRange.m5468getCollapsedimpl(newRawSelectionRange)) {
            return SelectionAdjustmentKt.ensureAtLeastOneChar(textLayoutResult.getLayoutInput().getText().getText(), TextRange.m5474getStartimpl(newRawSelectionRange), StringsKt.getLastIndex(textLayoutResult.getLayoutInput().getText()), z, TextRange.m5473getReversedimpl(previousSelectionRange.m5478unboximpl()));
        }
        if (z) {
            start = updateSelectionBoundary(textLayoutResult, TextRange.m5474getStartimpl(newRawSelectionRange), previousHandleOffset, TextRange.m5474getStartimpl(previousSelectionRange.m5478unboximpl()), TextRange.m5469getEndimpl(newRawSelectionRange), true, TextRange.m5473getReversedimpl(newRawSelectionRange));
            end = TextRange.m5469getEndimpl(newRawSelectionRange);
        } else {
            start = TextRange.m5474getStartimpl(newRawSelectionRange);
            end = updateSelectionBoundary(textLayoutResult, TextRange.m5469getEndimpl(newRawSelectionRange), previousHandleOffset, TextRange.m5469getEndimpl(previousSelectionRange.m5478unboximpl()), TextRange.m5474getStartimpl(newRawSelectionRange), false, TextRange.m5473getReversedimpl(newRawSelectionRange));
        }
        return TextRangeKt.TextRange(start, end);
    }

    private final int updateSelectionBoundary(TextLayoutResult textLayoutResult, int newRawOffset, int previousRawOffset, int previousAdjustedOffset, int otherBoundaryOffset, boolean isStart, boolean isReversed) {
        TextLayoutResult textLayoutResult2 = textLayoutResult;
        int i = newRawOffset;
        int i2 = previousRawOffset;
        int i3 = previousAdjustedOffset;
        if (i == i2) {
            return i3;
        }
        int currentLine = textLayoutResult.getLineForOffset(newRawOffset);
        if (currentLine != textLayoutResult2.getLineForOffset(i3)) {
            return snapToWordBoundary(textLayoutResult, newRawOffset, currentLine, otherBoundaryOffset, isStart, isReversed);
        }
        if (isExpanding(i, i2, isStart, isReversed) && isAtWordBoundary(textLayoutResult2, i3)) {
            return snapToWordBoundary(textLayoutResult, newRawOffset, currentLine, otherBoundaryOffset, isStart, isReversed);
        }
        return i;
    }

    private final int snapToWordBoundary(TextLayoutResult textLayoutResult, int newRawOffset, int currentLine, int otherBoundaryOffset, boolean isStart, boolean isReversed) {
        int start;
        int end;
        long wordBoundary = textLayoutResult.m5448getWordBoundaryjx7JFs(newRawOffset);
        if (textLayoutResult.getLineForOffset(TextRange.m5474getStartimpl(wordBoundary)) == currentLine) {
            start = TextRange.m5474getStartimpl(wordBoundary);
        } else {
            start = textLayoutResult.getLineStart(currentLine);
        }
        if (textLayoutResult.getLineForOffset(TextRange.m5469getEndimpl(wordBoundary)) == currentLine) {
            end = TextRange.m5469getEndimpl(wordBoundary);
        } else {
            end = TextLayoutResult.getLineEnd$default(textLayoutResult, currentLine, false, 2, (Object) null);
        }
        if (start == otherBoundaryOffset) {
            return end;
        }
        if (end == otherBoundaryOffset) {
            return start;
        }
        int threshold = (start + end) / 2;
        return (!(isStart ^ isReversed) ? newRawOffset < threshold : newRawOffset <= threshold) ? start : end;
    }

    private final boolean isAtWordBoundary(TextLayoutResult $this$isAtWordBoundary, int offset) {
        long wordBoundary = $this$isAtWordBoundary.m5448getWordBoundaryjx7JFs(offset);
        return offset == TextRange.m5474getStartimpl(wordBoundary) || offset == TextRange.m5469getEndimpl(wordBoundary);
    }

    private final boolean isExpanding(int newRawOffset, int previousRawOffset, boolean isStart, boolean previousReversed) {
        if (previousRawOffset == -1) {
            return true;
        }
        if (newRawOffset == previousRawOffset) {
            return false;
        }
        if (isStart ^ previousReversed) {
            if (newRawOffset < previousRawOffset) {
                return true;
            }
            return false;
        } else if (newRawOffset > previousRawOffset) {
            return true;
        } else {
            return false;
        }
    }
}
