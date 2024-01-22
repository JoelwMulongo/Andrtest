package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"getSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/input/TextFieldValue;", "getTextAfterSelection", "maxChars", "", "getTextBeforeSelection", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldValue.kt */
public final class TextFieldValueKt {
    public static final AnnotatedString getTextBeforeSelection(TextFieldValue $this$getTextBeforeSelection, int maxChars) {
        Intrinsics.checkNotNullParameter($this$getTextBeforeSelection, "<this>");
        return $this$getTextBeforeSelection.getAnnotatedString().subSequence(Math.max(0, TextRange.m5472getMinimpl($this$getTextBeforeSelection.m5695getSelectiond9O1mEE()) - maxChars), TextRange.m5472getMinimpl($this$getTextBeforeSelection.m5695getSelectiond9O1mEE()));
    }

    public static final AnnotatedString getTextAfterSelection(TextFieldValue $this$getTextAfterSelection, int maxChars) {
        Intrinsics.checkNotNullParameter($this$getTextAfterSelection, "<this>");
        return $this$getTextAfterSelection.getAnnotatedString().subSequence(TextRange.m5471getMaximpl($this$getTextAfterSelection.m5695getSelectiond9O1mEE()), Math.min(TextRange.m5471getMaximpl($this$getTextAfterSelection.m5695getSelectiond9O1mEE()) + maxChars, $this$getTextAfterSelection.getText().length()));
    }

    public static final AnnotatedString getSelectedText(TextFieldValue $this$getSelectedText) {
        Intrinsics.checkNotNullParameter($this$getSelectedText, "<this>");
        return $this$getSelectedText.getAnnotatedString().m5346subSequence5zctL8($this$getSelectedText.m5695getSelectiond9O1mEE());
    }
}
