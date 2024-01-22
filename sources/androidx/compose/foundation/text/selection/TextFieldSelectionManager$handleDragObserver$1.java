package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\bJ\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/text/selection/TextFieldSelectionManager$handleDragObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "onCancel", "", "onDown", "point", "Landroidx/compose/ui/geometry/Offset;", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
public final class TextFieldSelectionManager$handleDragObserver$1 implements TextDragObserver {
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ TextFieldSelectionManager this$0;

    TextFieldSelectionManager$handleDragObserver$1(TextFieldSelectionManager $receiver, boolean $isStartHandle2) {
        this.this$0 = $receiver;
        this.$isStartHandle = $isStartHandle2;
    }

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m1343onDownk4lQ0M(long point) {
        this.this$0.setDraggingHandle(this.$isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        textFieldSelectionManager.m1334setCurrentDragPosition_kEHs6E(Offset.m2904boximpl(SelectionHandlesKt.m1278getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m1339getHandlePositiontuRUvjQ$foundation_release(this.$isStartHandle))));
    }

    public void onUp() {
        this.this$0.setDraggingHandle((Handle) null);
        this.this$0.m1334setCurrentDragPosition_kEHs6E((Offset) null);
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m1345onStartk4lQ0M(long startPoint) {
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        textFieldSelectionManager.dragBeginPosition = SelectionHandlesKt.m1278getAdjustedCoordinatesk4lQ0M(textFieldSelectionManager.m1339getHandlePositiontuRUvjQ$foundation_release(this.$isStartHandle));
        TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
        textFieldSelectionManager2.m1334setCurrentDragPosition_kEHs6E(Offset.m2904boximpl(textFieldSelectionManager2.dragBeginPosition));
        this.this$0.dragTotalDistance = Offset.Companion.m2931getZeroF1C5BW0();
        this.this$0.setDraggingHandle(this.$isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release != null) {
            state$foundation_release.setShowFloatingToolbar(false);
        }
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m1344onDragk4lQ0M(long delta) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult layoutResult2;
        int startOffset;
        int endOffset;
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        textFieldSelectionManager.dragTotalDistance = Offset.m2920plusMKHz9U(textFieldSelectionManager.dragTotalDistance, delta);
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null || (layoutResult2 = layoutResult.getValue()) == null)) {
            TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
            boolean z = this.$isStartHandle;
            textFieldSelectionManager2.m1334setCurrentDragPosition_kEHs6E(Offset.m2904boximpl(Offset.m2920plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
            if (z) {
                Offset r2 = textFieldSelectionManager2.m1337getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(r2);
                startOffset = layoutResult2.m5446getOffsetForPositionk4lQ0M(r2.m2925unboximpl());
            } else {
                startOffset = textFieldSelectionManager2.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m5474getStartimpl(textFieldSelectionManager2.getValue$foundation_release().m5695getSelectiond9O1mEE()));
            }
            if (z) {
                endOffset = textFieldSelectionManager2.getOffsetMapping$foundation_release().originalToTransformed(TextRange.m5469getEndimpl(textFieldSelectionManager2.getValue$foundation_release().m5695getSelectiond9O1mEE()));
            } else {
                Offset r22 = textFieldSelectionManager2.m1337getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(r22);
                endOffset = layoutResult2.m5446getOffsetForPositionk4lQ0M(r22.m2925unboximpl());
            }
            textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), startOffset, endOffset, z, SelectionAdjustment.Companion.getCharacter());
        }
        TextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
        if (state$foundation_release2 != null) {
            state$foundation_release2.setShowFloatingToolbar(false);
        }
    }

    public void onStop() {
        TextToolbarStatus textToolbarStatus = null;
        this.this$0.setDraggingHandle((Handle) null);
        this.this$0.m1334setCurrentDragPosition_kEHs6E((Offset) null);
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release != null) {
            state$foundation_release.setShowFloatingToolbar(true);
        }
        TextToolbar textToolbar = this.this$0.getTextToolbar();
        if (textToolbar != null) {
            textToolbarStatus = textToolbar.getStatus();
        }
        if (textToolbarStatus == TextToolbarStatus.Hidden) {
            this.this$0.showSelectionToolbar$foundation_release();
        }
    }

    public void onCancel() {
    }
}
