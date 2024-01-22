package androidx.compose.ui.text.input;

import android.view.inputmethod.ExtractedText;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toExtractedText", "Landroid/view/inputmethod/ExtractedText;", "Landroidx/compose/ui/text/input/TextFieldValue;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: InputState.android.kt */
public final class InputState_androidKt {
    public static final ExtractedText toExtractedText(TextFieldValue $this$toExtractedText) {
        Intrinsics.checkNotNullParameter($this$toExtractedText, "<this>");
        ExtractedText res = new ExtractedText();
        res.text = $this$toExtractedText.getText();
        res.startOffset = 0;
        res.partialEndOffset = $this$toExtractedText.getText().length();
        res.partialStartOffset = -1;
        res.selectionStart = TextRange.m5472getMinimpl($this$toExtractedText.m5695getSelectiond9O1mEE());
        res.selectionEnd = TextRange.m5471getMaximpl($this$toExtractedText.m5695getSelectiond9O1mEE());
        res.flags = StringsKt.contains$default((CharSequence) $this$toExtractedText.getText(), 10, false, 2, (Object) null) ^ true ? 1 : 0;
        return res;
    }
}
