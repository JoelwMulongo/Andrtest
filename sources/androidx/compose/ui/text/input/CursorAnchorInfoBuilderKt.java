package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u001c\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\f"}, d2 = {"build", "Landroid/view/inputmethod/CursorAnchorInfo;", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "matrix", "Landroid/graphics/Matrix;", "setInsertionMarker", "selectionStart", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CursorAnchorInfoBuilder.kt */
public final class CursorAnchorInfoBuilderKt {
    public static final CursorAnchorInfo build(CursorAnchorInfo.Builder $this$build, TextFieldValue textFieldValue, TextLayoutResult textLayoutResult, Matrix matrix) {
        Intrinsics.checkNotNullParameter($this$build, "<this>");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        $this$build.reset();
        $this$build.setMatrix(matrix);
        int selectionStart = TextRange.m5472getMinimpl(textFieldValue.m5695getSelectiond9O1mEE());
        $this$build.setSelectionRange(selectionStart, TextRange.m5471getMaximpl(textFieldValue.m5695getSelectiond9O1mEE()));
        setInsertionMarker($this$build, selectionStart, textLayoutResult);
        TextRange r2 = textFieldValue.m5694getCompositionMzsxiRA();
        int compositionEnd = -1;
        int compositionStart = r2 != null ? TextRange.m5472getMinimpl(r2.m5478unboximpl()) : -1;
        TextRange r4 = textFieldValue.m5694getCompositionMzsxiRA();
        if (r4 != null) {
            compositionEnd = TextRange.m5471getMaximpl(r4.m5478unboximpl());
        }
        boolean z = false;
        if (compositionStart >= 0 && compositionStart < compositionEnd) {
            z = true;
        }
        if (z) {
            $this$build.setComposingText(compositionStart, textFieldValue.getText().subSequence(compositionStart, compositionEnd));
        }
        CursorAnchorInfo build = $this$build.build();
        Intrinsics.checkNotNullExpressionValue(build, "build()");
        return build;
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder $this$setInsertionMarker, int selectionStart, TextLayoutResult textLayoutResult) {
        if (selectionStart < 0) {
            return $this$setInsertionMarker;
        }
        Rect cursorRect = textLayoutResult.getCursorRect(selectionStart);
        int flags = 0;
        if (textLayoutResult.getBidiRunDirection(selectionStart) == ResolvedTextDirection.Rtl) {
            flags = 0 | 4;
        }
        $this$setInsertionMarker.setInsertionMarkerLocation(cursorRect.getLeft(), cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), flags);
        return $this$setInsertionMarker;
    }
}
