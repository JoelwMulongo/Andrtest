package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\bJ\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/text/selection/TextFieldSelectionManager$cursorDragObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "onCancel", "", "onDown", "point", "Landroidx/compose/ui/geometry/Offset;", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
public final class TextFieldSelectionManager$cursorDragObserver$1 implements TextDragObserver {
    final /* synthetic */ TextFieldSelectionManager this$0;

    TextFieldSelectionManager$cursorDragObserver$1(TextFieldSelectionManager $receiver) {
        this.this$0 = $receiver;
    }

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m1340onDownk4lQ0M(long point) {
        this.this$0.setDraggingHandle(Handle.Cursor);
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        textFieldSelectionManager.m1334setCurrentDragPosition_kEHs6E(Offset.m2904boximpl(SelectionHandlesKt.m1278getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m1339getHandlePositiontuRUvjQ$foundation_release(true))));
    }

    public void onUp() {
        this.this$0.setDraggingHandle((Handle) null);
        this.this$0.m1334setCurrentDragPosition_kEHs6E((Offset) null);
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m1342onStartk4lQ0M(long startPoint) {
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        textFieldSelectionManager.dragBeginPosition = SelectionHandlesKt.m1278getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m1339getHandlePositiontuRUvjQ$foundation_release(true));
        TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
        textFieldSelectionManager2.m1334setCurrentDragPosition_kEHs6E(Offset.m2904boximpl(textFieldSelectionManager2.dragBeginPosition));
        this.this$0.dragTotalDistance = Offset.Companion.m2931getZeroF1C5BW0();
        this.this$0.setDraggingHandle(Handle.Cursor);
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m1341onDragk4lQ0M(long delta) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult layoutResult2;
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        textFieldSelectionManager.dragTotalDistance = Offset.m2920plusMKHz9U(textFieldSelectionManager.dragTotalDistance, delta);
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release != null && (layoutResult = state$foundation_release.getLayoutResult()) != null && (layoutResult2 = layoutResult.getValue()) != null) {
            TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
            textFieldSelectionManager2.m1334setCurrentDragPosition_kEHs6E(Offset.m2904boximpl(Offset.m2920plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
            OffsetMapping offsetMapping$foundation_release = textFieldSelectionManager2.getOffsetMapping$foundation_release();
            Offset r4 = textFieldSelectionManager2.m1337getCurrentDragPosition_m7T9E();
            Intrinsics.checkNotNull(r4);
            int offset = offsetMapping$foundation_release.transformedToOriginal(layoutResult2.m5446getOffsetForPositionk4lQ0M(r4.m2925unboximpl()));
            long newSelection = TextRangeKt.TextRange(offset, offset);
            if (!TextRange.m5467equalsimpl0(newSelection, textFieldSelectionManager2.getValue$foundation_release().m5695getSelectiond9O1mEE())) {
                HapticFeedback hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack();
                if (hapticFeedBack != null) {
                    hapticFeedBack.m3899performHapticFeedbackCdsT49E(HapticFeedbackType.Companion.m3908getTextHandleMove5zf0vsI());
                }
                textFieldSelectionManager2.getOnValueChange$foundation_release().invoke(textFieldSelectionManager2.m1332createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation_release().getAnnotatedString(), newSelection));
            }
        }
    }

    public void onStop() {
        this.this$0.setDraggingHandle((Handle) null);
        this.this$0.m1334setCurrentDragPosition_kEHs6E((Offset) null);
    }

    public void onCancel() {
    }
}
