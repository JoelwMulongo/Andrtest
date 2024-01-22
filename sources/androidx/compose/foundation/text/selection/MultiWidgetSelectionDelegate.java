package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0010\u001a\u00020\u000bH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b \u0010!J\n\u0010\"\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010#\u001a\u00020$H\u0016J_\u0010%\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0004\u0012\u00020\u001a0&2\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0018H\u0016ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b.\u0010/R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00020\u000b*\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"Landroidx/compose/foundation/text/selection/MultiWidgetSelectionDelegate;", "Landroidx/compose/foundation/text/selection/Selectable;", "selectableId", "", "coordinatesCallback", "Lkotlin/Function0;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutResultCallback", "Landroidx/compose/ui/text/TextLayoutResult;", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "_previousLastVisibleOffset", "", "_previousTextLayoutResult", "getSelectableId", "()J", "lastVisibleOffset", "getLastVisibleOffset", "(Landroidx/compose/ui/text/TextLayoutResult;)I", "getBoundingBox", "Landroidx/compose/ui/geometry/Rect;", "offset", "getHandlePosition", "Landroidx/compose/ui/geometry/Offset;", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "isStartHandle", "", "getHandlePosition-dBAh8RU", "(Landroidx/compose/foundation/text/selection/Selection;Z)J", "getLayoutCoordinates", "getRangeOfLineContaining", "Landroidx/compose/ui/text/TextRange;", "getRangeOfLineContaining--jx7JFs", "(I)J", "getSelectAllSelection", "getText", "Landroidx/compose/ui/text/AnnotatedString;", "updateSelection", "Lkotlin/Pair;", "startHandlePosition", "endHandlePosition", "previousHandlePosition", "containerLayoutCoordinates", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "previousSelection", "updateSelection-qCDeeow", "(JJLandroidx/compose/ui/geometry/Offset;ZLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/foundation/text/selection/SelectionAdjustment;Landroidx/compose/foundation/text/selection/Selection;)Lkotlin/Pair;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MultiWidgetSelectionDelegate.kt */
public final class MultiWidgetSelectionDelegate implements Selectable {
    private int _previousLastVisibleOffset = -1;
    private TextLayoutResult _previousTextLayoutResult;
    private final Function0<LayoutCoordinates> coordinatesCallback;
    private final Function0<TextLayoutResult> layoutResultCallback;
    private final long selectableId;

    public MultiWidgetSelectionDelegate(long selectableId2, Function0<? extends LayoutCoordinates> coordinatesCallback2, Function0<TextLayoutResult> layoutResultCallback2) {
        Intrinsics.checkNotNullParameter(coordinatesCallback2, "coordinatesCallback");
        Intrinsics.checkNotNullParameter(layoutResultCallback2, "layoutResultCallback");
        this.selectableId = selectableId2;
        this.coordinatesCallback = coordinatesCallback2;
        this.layoutResultCallback = layoutResultCallback2;
    }

    public long getSelectableId() {
        return this.selectableId;
    }

    private final synchronized int getLastVisibleOffset(TextLayoutResult $this$lastVisibleOffset) {
        int finalVisibleLine;
        if (this._previousTextLayoutResult != $this$lastVisibleOffset) {
            if ($this$lastVisibleOffset.getDidOverflowHeight()) {
                if (!$this$lastVisibleOffset.getMultiParagraph().getDidExceedMaxLines()) {
                    finalVisibleLine = RangesKt.coerceAtMost($this$lastVisibleOffset.getLineForVerticalPosition((float) IntSize.m6145getHeightimpl($this$lastVisibleOffset.m5447getSizeYbymL2g())), $this$lastVisibleOffset.getLineCount() - 1);
                    while ($this$lastVisibleOffset.getLineTop(finalVisibleLine) >= ((float) IntSize.m6145getHeightimpl($this$lastVisibleOffset.m5447getSizeYbymL2g()))) {
                        finalVisibleLine--;
                    }
                    this._previousLastVisibleOffset = $this$lastVisibleOffset.getLineEnd(finalVisibleLine, true);
                    this._previousTextLayoutResult = $this$lastVisibleOffset;
                }
            }
            finalVisibleLine = $this$lastVisibleOffset.getLineCount() - 1;
            this._previousLastVisibleOffset = $this$lastVisibleOffset.getLineEnd(finalVisibleLine, true);
            this._previousTextLayoutResult = $this$lastVisibleOffset;
        }
        return this._previousLastVisibleOffset;
    }

    /* renamed from: updateSelection-qCDeeow  reason: not valid java name */
    public Pair<Selection, Boolean> m1253updateSelectionqCDeeow(long startHandlePosition, long endHandlePosition, Offset previousHandlePosition, boolean isStartHandle, LayoutCoordinates containerLayoutCoordinates, SelectionAdjustment adjustment, Selection previousSelection) {
        LayoutCoordinates layoutCoordinates = containerLayoutCoordinates;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "containerLayoutCoordinates");
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        boolean z = false;
        if (previousSelection == null || (getSelectableId() == previousSelection.getStart().getSelectableId() && getSelectableId() == previousSelection.getEnd().getSelectableId())) {
            z = true;
        }
        if (z) {
            LayoutCoordinates layoutCoordinates2 = getLayoutCoordinates();
            Offset localPreviousHandlePosition = null;
            if (layoutCoordinates2 == null) {
                return new Pair<>(null, false);
            }
            TextLayoutResult invoke = this.layoutResultCallback.invoke();
            if (invoke == null) {
                return new Pair<>(null, false);
            }
            TextLayoutResult textLayoutResult = invoke;
            long relativePosition = layoutCoordinates.m4840localPositionOfR5De75A(layoutCoordinates2, Offset.Companion.m2931getZeroF1C5BW0());
            long localStartPosition = Offset.m2919minusMKHz9U(startHandlePosition, relativePosition);
            long localEndPosition = Offset.m2919minusMKHz9U(endHandlePosition, relativePosition);
            if (previousHandlePosition != null) {
                localPreviousHandlePosition = Offset.m2904boximpl(Offset.m2919minusMKHz9U(previousHandlePosition.m2925unboximpl(), relativePosition));
            }
            long j = relativePosition;
            return MultiWidgetSelectionDelegateKt.m1257getTextSelectionInfoyM0VcXU(textLayoutResult, localStartPosition, localEndPosition, localPreviousHandlePosition, getSelectableId(), adjustment, previousSelection, isStartHandle);
        }
        throw new IllegalArgumentException("The given previousSelection doesn't belong to this selectable.".toString());
    }

    public Selection getSelectAllSelection() {
        TextLayoutResult textLayoutResult = this.layoutResultCallback.invoke();
        if (textLayoutResult == null) {
            return null;
        }
        return MultiWidgetSelectionDelegateKt.m1255getAssembledSelectionInfovJH6DeI(TextRangeKt.TextRange(0, textLayoutResult.getLayoutInput().getText().length()), false, getSelectableId(), textLayoutResult);
    }

    /* renamed from: getHandlePosition-dBAh8RU  reason: not valid java name */
    public long m1251getHandlePositiondBAh8RU(Selection selection, boolean isStartHandle) {
        Intrinsics.checkNotNullParameter(selection, "selection");
        if ((isStartHandle && selection.getStart().getSelectableId() != getSelectableId()) || (!isStartHandle && selection.getEnd().getSelectableId() != getSelectableId())) {
            return Offset.Companion.m2931getZeroF1C5BW0();
        }
        if (getLayoutCoordinates() == null) {
            return Offset.Companion.m2931getZeroF1C5BW0();
        }
        TextLayoutResult textLayoutResult = this.layoutResultCallback.invoke();
        if (textLayoutResult == null) {
            return Offset.Companion.m2931getZeroF1C5BW0();
        }
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(textLayoutResult, RangesKt.coerceIn((isStartHandle ? selection.getStart() : selection.getEnd()).getOffset(), 0, getLastVisibleOffset(textLayoutResult)), isStartHandle, selection.getHandlesCrossed());
    }

    public LayoutCoordinates getLayoutCoordinates() {
        LayoutCoordinates layoutCoordinates = this.coordinatesCallback.invoke();
        if (layoutCoordinates == null || !layoutCoordinates.isAttached()) {
            return null;
        }
        return layoutCoordinates;
    }

    public AnnotatedString getText() {
        TextLayoutResult textLayoutResult = this.layoutResultCallback.invoke();
        if (textLayoutResult == null) {
            return new AnnotatedString("", (List) null, (List) null, 6, (DefaultConstructorMarker) null);
        }
        return textLayoutResult.getLayoutInput().getText();
    }

    public Rect getBoundingBox(int offset) {
        TextLayoutResult textLayoutResult = this.layoutResultCallback.invoke();
        if (textLayoutResult == null) {
            return Rect.Companion.getZero();
        }
        int textLength = textLayoutResult.getLayoutInput().getText().length();
        if (textLength < 1) {
            return Rect.Companion.getZero();
        }
        return textLayoutResult.getBoundingBox(RangesKt.coerceIn(offset, 0, textLength - 1));
    }

    /* renamed from: getRangeOfLineContaining--jx7JFs  reason: not valid java name */
    public long m1252getRangeOfLineContainingjx7JFs(int offset) {
        TextLayoutResult textLayoutResult = this.layoutResultCallback.invoke();
        if (textLayoutResult == null) {
            return TextRange.Companion.m5479getZerod9O1mEE();
        }
        int visibleTextLength = getLastVisibleOffset(textLayoutResult);
        if (visibleTextLength < 1) {
            return TextRange.Companion.m5479getZerod9O1mEE();
        }
        int line = textLayoutResult.getLineForOffset(RangesKt.coerceIn(offset, 0, visibleTextLength - 1));
        return TextRangeKt.TextRange(textLayoutResult.getLineStart(line), textLayoutResult.getLineEnd(line, true));
    }

    public int getLastVisibleOffset() {
        TextLayoutResult textLayoutResult = this.layoutResultCallback.invoke();
        if (textLayoutResult == null) {
            return 0;
        }
        return getLastVisibleOffset(textLayoutResult);
    }
}
