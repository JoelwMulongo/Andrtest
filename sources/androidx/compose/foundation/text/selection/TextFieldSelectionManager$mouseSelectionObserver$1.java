package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\rJ%\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"androidx/compose/foundation/text/selection/TextFieldSelectionManager$mouseSelectionObserver$1", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "onDrag", "", "dragPosition", "Landroidx/compose/ui/geometry/Offset;", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "onDrag-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "onExtend", "downPosition", "onExtend-k-4lQ0M", "(J)Z", "onExtendDrag", "onExtendDrag-k-4lQ0M", "onStart", "onStart-3MmeM6k", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
public final class TextFieldSelectionManager$mouseSelectionObserver$1 implements MouseSelectionObserver {
    final /* synthetic */ TextFieldSelectionManager this$0;

    TextFieldSelectionManager$mouseSelectionObserver$1(TextFieldSelectionManager $receiver) {
        this.this$0 = $receiver;
    }

    /* renamed from: onExtend-k-4lQ0M  reason: not valid java name */
    public boolean m1347onExtendk4lQ0M(long downPosition) {
        TextLayoutResultProxy layoutResult;
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
            return false;
        }
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        int startOffset = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m5474getStartimpl(textFieldSelectionManager.getValue$foundation_release().m5695getSelectiond9O1mEE()));
        int clickOffset = TextLayoutResultProxy.m1230getOffsetForPosition3MmeM6k$default(layoutResult, downPosition, false, 2, (Object) null);
        textFieldSelectionManager.updateSelection(textFieldSelectionManager.getValue$foundation_release(), startOffset, clickOffset, false, SelectionAdjustment.Companion.getNone());
        return true;
    }

    /* renamed from: onExtendDrag-k-4lQ0M  reason: not valid java name */
    public boolean m1348onExtendDragk4lQ0M(long dragPosition) {
        TextFieldState state$foundation_release;
        TextLayoutResultProxy layoutResult;
        if ((this.this$0.getValue$foundation_release().getText().length() == 0) || (state$foundation_release = this.this$0.getState$foundation_release()) == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
            return false;
        }
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        textFieldSelectionManager.updateSelection(textFieldSelectionManager.getValue$foundation_release(), textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m5474getStartimpl(textFieldSelectionManager.getValue$foundation_release().m5695getSelectiond9O1mEE())), layoutResult.m1232getOffsetForPosition3MmeM6k(dragPosition, false), false, SelectionAdjustment.Companion.getNone());
        return true;
    }

    /* renamed from: onStart-3MmeM6k  reason: not valid java name */
    public boolean m1349onStart3MmeM6k(long downPosition, SelectionAdjustment adjustment) {
        TextLayoutResultProxy layoutResult;
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        FocusRequester focusRequester = this.this$0.getFocusRequester();
        if (focusRequester != null) {
            focusRequester.requestFocus();
        }
        this.this$0.dragBeginPosition = downPosition;
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
            return false;
        }
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        textFieldSelectionManager.dragBeginOffsetInText = Integer.valueOf(TextLayoutResultProxy.m1230getOffsetForPosition3MmeM6k$default(layoutResult, downPosition, false, 2, (Object) null));
        int clickOffset = TextLayoutResultProxy.m1230getOffsetForPosition3MmeM6k$default(layoutResult, textFieldSelectionManager.dragBeginPosition, false, 2, (Object) null);
        textFieldSelectionManager.updateSelection(textFieldSelectionManager.getValue$foundation_release(), clickOffset, clickOffset, false, adjustment);
        return true;
    }

    /* renamed from: onDrag-3MmeM6k  reason: not valid java name */
    public boolean m1346onDrag3MmeM6k(long dragPosition, SelectionAdjustment adjustment) {
        TextFieldState state$foundation_release;
        TextLayoutResultProxy layoutResult;
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        if ((this.this$0.getValue$foundation_release().getText().length() == 0) || (state$foundation_release = this.this$0.getState$foundation_release()) == null || (layoutResult = state$foundation_release.getLayoutResult()) == null) {
            return false;
        }
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        int dragOffset = layoutResult.m1232getOffsetForPosition3MmeM6k(dragPosition, false);
        TextFieldValue value$foundation_release = textFieldSelectionManager.getValue$foundation_release();
        Integer access$getDragBeginOffsetInText$p = textFieldSelectionManager.dragBeginOffsetInText;
        Intrinsics.checkNotNull(access$getDragBeginOffsetInText$p);
        textFieldSelectionManager.updateSelection(value$foundation_release, access$getDragBeginOffsetInText$p.intValue(), dragOffset, false, adjustment);
        return true;
    }
}
