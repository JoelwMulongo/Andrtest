package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\bJ\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/text/selection/TextFieldSelectionManager$touchSelectionObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "onCancel", "", "onDown", "point", "Landroidx/compose/ui/geometry/Offset;", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionManager.kt */
public final class TextFieldSelectionManager$touchSelectionObserver$1 implements TextDragObserver {
    final /* synthetic */ TextFieldSelectionManager this$0;

    TextFieldSelectionManager$touchSelectionObserver$1(TextFieldSelectionManager $receiver) {
        this.this$0 = $receiver;
    }

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m1350onDownk4lQ0M(long point) {
    }

    public void onUp() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
        r0 = r0.getLayoutResult();
     */
    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1352onStartk4lQ0M(long r11) {
        /*
            r10 = this;
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r10.this$0
            androidx.compose.foundation.text.Handle r0 = r0.getDraggingHandle()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r10.this$0
            androidx.compose.foundation.text.Handle r1 = androidx.compose.foundation.text.Handle.SelectionEnd
            r0.setDraggingHandle(r1)
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r10.this$0
            r0.hideSelectionToolbar$foundation_release()
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r10.this$0
            androidx.compose.foundation.text.TextFieldState r0 = r0.getState$foundation_release()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002d
            androidx.compose.foundation.text.TextLayoutResultProxy r0 = r0.getLayoutResult()
            if (r0 == 0) goto L_0x002d
            boolean r0 = r0.m1233isPositionOnTextk4lQ0M(r11)
            if (r0 != r1) goto L_0x002d
            r0 = r1
            goto L_0x002e
        L_0x002d:
            r0 = r2
        L_0x002e:
            if (r0 != 0) goto L_0x0083
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r10.this$0
            androidx.compose.foundation.text.TextFieldState r0 = r0.getState$foundation_release()
            if (r0 == 0) goto L_0x0083
            androidx.compose.foundation.text.TextLayoutResultProxy r0 = r0.getLayoutResult()
            if (r0 == 0) goto L_0x0083
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r1 = r10.this$0
            r3 = 0
            androidx.compose.ui.text.input.OffsetMapping r4 = r1.getOffsetMapping$foundation_release()
            float r5 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r11)
            int r5 = r0.getLineForVerticalPosition(r5)
            r6 = 2
            r7 = 0
            int r2 = androidx.compose.foundation.text.TextLayoutResultProxy.getLineEnd$default(r0, r5, r2, r6, r7)
            int r2 = r4.transformedToOriginal(r2)
            androidx.compose.ui.hapticfeedback.HapticFeedback r4 = r1.getHapticFeedBack()
            if (r4 == 0) goto L_0x0067
            androidx.compose.ui.hapticfeedback.HapticFeedbackType$Companion r5 = androidx.compose.ui.hapticfeedback.HapticFeedbackType.Companion
            int r5 = r5.m3908getTextHandleMove5zf0vsI()
            r4.m3899performHapticFeedbackCdsT49E(r5)
        L_0x0067:
            androidx.compose.ui.text.input.TextFieldValue r4 = r1.getValue$foundation_release()
            androidx.compose.ui.text.AnnotatedString r4 = r4.getAnnotatedString()
            long r5 = androidx.compose.ui.text.TextRangeKt.TextRange(r2, r2)
            androidx.compose.ui.text.input.TextFieldValue r4 = r1.m1332createTextFieldValueFDrldGo(r4, r5)
            r1.enterSelectionMode$foundation_release()
            kotlin.jvm.functions.Function1 r1 = r1.getOnValueChange$foundation_release()
            r1.invoke(r4)
            return
        L_0x0083:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r10.this$0
            androidx.compose.ui.text.input.TextFieldValue r0 = r0.getValue$foundation_release()
            java.lang.String r0 = r0.getText()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0096
            goto L_0x0097
        L_0x0096:
            r1 = r2
        L_0x0097:
            if (r1 == 0) goto L_0x009a
            return
        L_0x009a:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r10.this$0
            r0.enterSelectionMode$foundation_release()
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r10.this$0
            androidx.compose.foundation.text.TextFieldState r0 = r0.getState$foundation_release()
            if (r0 == 0) goto L_0x00d4
            androidx.compose.foundation.text.TextLayoutResultProxy r1 = r0.getLayoutResult()
            if (r1 == 0) goto L_0x00d4
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r10.this$0
            r8 = 0
            r4 = 0
            r5 = 2
            r6 = 0
            r2 = r11
            int r9 = androidx.compose.foundation.text.TextLayoutResultProxy.m1230getOffsetForPosition3MmeM6k$default(r1, r2, r4, r5, r6)
            androidx.compose.ui.text.input.TextFieldValue r3 = r0.getValue$foundation_release()
            r6 = 0
            androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r2 = androidx.compose.foundation.text.selection.SelectionAdjustment.Companion
            androidx.compose.foundation.text.selection.SelectionAdjustment r7 = r2.getWord()
            r2 = r0
            r4 = r9
            r5 = r9
            r2.updateSelection(r3, r4, r5, r6, r7)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
            r0.dragBeginOffsetInText = r2
        L_0x00d4:
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r10.this$0
            r0.dragBeginPosition = r11
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r10.this$0
            long r1 = r0.dragBeginPosition
            androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m2904boximpl(r1)
            r0.m1334setCurrentDragPosition_kEHs6E(r1)
            androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r10.this$0
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.Companion
            long r1 = r1.m2931getZeroF1C5BW0()
            r0.dragTotalDistance = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1.m1352onStartk4lQ0M(long):void");
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m1351onDragk4lQ0M(long delta) {
        TextLayoutResultProxy layoutResult;
        if (!(this.this$0.getValue$foundation_release().getText().length() == 0)) {
            TextFieldSelectionManager textFieldSelectionManager = this.this$0;
            textFieldSelectionManager.dragTotalDistance = Offset.m2920plusMKHz9U(textFieldSelectionManager.dragTotalDistance, delta);
            TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
            if (!(state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null)) {
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                textFieldSelectionManager2.m1334setCurrentDragPosition_kEHs6E(Offset.m2904boximpl(Offset.m2920plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
                Integer access$getDragBeginOffsetInText$p = textFieldSelectionManager2.dragBeginOffsetInText;
                int startOffset = access$getDragBeginOffsetInText$p != null ? access$getDragBeginOffsetInText$p.intValue() : layoutResult.m1232getOffsetForPosition3MmeM6k(textFieldSelectionManager2.dragBeginPosition, false);
                Offset r3 = textFieldSelectionManager2.m1337getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(r3);
                textFieldSelectionManager2.updateSelection(textFieldSelectionManager2.getValue$foundation_release(), startOffset, layoutResult.m1232getOffsetForPosition3MmeM6k(r3.m2925unboximpl(), false), false, SelectionAdjustment.Companion.getWord());
            }
            TextFieldState state$foundation_release2 = this.this$0.getState$foundation_release();
            if (state$foundation_release2 != null) {
                state$foundation_release2.setShowFloatingToolbar(false);
            }
        }
    }

    public void onStop() {
        this.this$0.setDraggingHandle((Handle) null);
        this.this$0.m1334setCurrentDragPosition_kEHs6E((Offset) null);
        TextFieldState state$foundation_release = this.this$0.getState$foundation_release();
        if (state$foundation_release != null) {
            state$foundation_release.setShowFloatingToolbar(true);
        }
        TextToolbar textToolbar = this.this$0.getTextToolbar();
        if ((textToolbar != null ? textToolbar.getStatus() : null) == TextToolbarStatus.Hidden) {
            this.this$0.showSelectionToolbar$foundation_release();
        }
        this.this$0.dragBeginOffsetInText = null;
    }

    public void onCancel() {
    }
}
