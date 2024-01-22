package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ \u0010\u0010\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u0018\u001a\u00020\bJ\f\u0010\u0019\u001a\u00020\u0011*\u00020\u000fH\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/input/EditProcessor;", "", "()V", "<set-?>", "Landroidx/compose/ui/text/input/EditingBuffer;", "mBuffer", "getMBuffer$ui_text_release", "()Landroidx/compose/ui/text/input/EditingBuffer;", "Landroidx/compose/ui/text/input/TextFieldValue;", "mBufferState", "getMBufferState$ui_text_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "apply", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "generateBatchErrorMessage", "", "failedCommand", "reset", "", "value", "textInputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "toTextFieldValue", "toStringForLog", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EditProcessor.kt */
public final class EditProcessor {
    public static final int $stable = 8;
    private EditingBuffer mBuffer = new EditingBuffer(this.mBufferState.getAnnotatedString(), this.mBufferState.m5695getSelectiond9O1mEE(), (DefaultConstructorMarker) null);
    private TextFieldValue mBufferState = new TextFieldValue(AnnotatedStringKt.emptyAnnotatedString(), TextRange.Companion.m5479getZerod9O1mEE(), (TextRange) null, (DefaultConstructorMarker) null);

    public final TextFieldValue getMBufferState$ui_text_release() {
        return this.mBufferState;
    }

    public final EditingBuffer getMBuffer$ui_text_release() {
        return this.mBuffer;
    }

    public final void reset(TextFieldValue value, TextInputSession textInputSession) {
        TextFieldValue newValue;
        Intrinsics.checkNotNullParameter(value, "value");
        boolean textChanged = false;
        boolean selectionChanged = false;
        boolean compositionChanged = !Intrinsics.areEqual((Object) value.m5694getCompositionMzsxiRA(), (Object) this.mBuffer.m5616getCompositionMzsxiRA$ui_text_release());
        if (!Intrinsics.areEqual((Object) this.mBufferState.getAnnotatedString(), (Object) value.getAnnotatedString())) {
            this.mBuffer = new EditingBuffer(value.getAnnotatedString(), value.m5695getSelectiond9O1mEE(), (DefaultConstructorMarker) null);
            textChanged = true;
        } else if (!TextRange.m5467equalsimpl0(this.mBufferState.m5695getSelectiond9O1mEE(), value.m5695getSelectiond9O1mEE())) {
            this.mBuffer.setSelection$ui_text_release(TextRange.m5472getMinimpl(value.m5695getSelectiond9O1mEE()), TextRange.m5471getMaximpl(value.m5695getSelectiond9O1mEE()));
            selectionChanged = true;
        }
        if (value.m5694getCompositionMzsxiRA() == null) {
            this.mBuffer.commitComposition$ui_text_release();
        } else if (!TextRange.m5468getCollapsedimpl(value.m5694getCompositionMzsxiRA().m5478unboximpl())) {
            this.mBuffer.setComposition$ui_text_release(TextRange.m5472getMinimpl(value.m5694getCompositionMzsxiRA().m5478unboximpl()), TextRange.m5471getMaximpl(value.m5694getCompositionMzsxiRA().m5478unboximpl()));
        }
        if (textChanged || (!selectionChanged && compositionChanged)) {
            this.mBuffer.commitComposition$ui_text_release();
            newValue = TextFieldValue.m5690copy3r_uNRQ$default(value, (AnnotatedString) null, 0, (TextRange) null, 3, (Object) null);
        } else {
            newValue = value;
        }
        TextFieldValue oldValue = this.mBufferState;
        this.mBufferState = newValue;
        if (textInputSession != null) {
            textInputSession.updateState(oldValue, newValue);
        }
    }

    public final TextFieldValue apply(List<? extends EditCommand> editCommands) {
        Intrinsics.checkNotNullParameter(editCommands, "editCommands");
        List $this$fastForEach$iv = editCommands;
        try {
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                EditCommand it = (EditCommand) $this$fastForEach$iv.get(index$iv);
                Object lastCommand = it;
                it.applyTo(this.mBuffer);
            }
            TextFieldValue textFieldValue = new TextFieldValue(this.mBuffer.toAnnotatedString$ui_text_release(), this.mBuffer.m5617getSelectiond9O1mEE$ui_text_release(), this.mBuffer.m5616getCompositionMzsxiRA$ui_text_release(), (DefaultConstructorMarker) null);
            this.mBufferState = textFieldValue;
            return textFieldValue;
        } catch (Exception e) {
            throw new RuntimeException(generateBatchErrorMessage(editCommands, (EditCommand) null), e);
        }
    }

    public final TextFieldValue toTextFieldValue() {
        return this.mBufferState;
    }

    private final String generateBatchErrorMessage(List<? extends EditCommand> editCommands, EditCommand failedCommand) {
        StringBuilder sb = new StringBuilder();
        StringBuilder $this$generateBatchErrorMessage_u24lambda_u241 = sb;
        StringBuilder append = $this$generateBatchErrorMessage_u24lambda_u241.append("Error while applying EditCommand batch to buffer (length=" + this.mBuffer.getLength$ui_text_release() + ", composition=" + this.mBuffer.m5616getCompositionMzsxiRA$ui_text_release() + ", selection=" + TextRange.m5477toStringimpl(this.mBuffer.m5617getSelectiond9O1mEE$ui_text_release()) + "):");
        Intrinsics.checkNotNullExpressionValue(append, "append(value)");
        Intrinsics.checkNotNullExpressionValue(append.append(10), "append('\\n')");
        CollectionsKt.joinTo$default(editCommands, $this$generateBatchErrorMessage_u24lambda_u241, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new EditProcessor$generateBatchErrorMessage$1$1(failedCommand, this), 60, (Object) null);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* access modifiers changed from: private */
    public final String toStringForLog(EditCommand $this$toStringForLog) {
        if ($this$toStringForLog instanceof CommitTextCommand) {
            return "CommitTextCommand(text.length=" + ((CommitTextCommand) $this$toStringForLog).getText().length() + ", newCursorPosition=" + ((CommitTextCommand) $this$toStringForLog).getNewCursorPosition() + ')';
        }
        if ($this$toStringForLog instanceof SetComposingTextCommand) {
            return "SetComposingTextCommand(text.length=" + ((SetComposingTextCommand) $this$toStringForLog).getText().length() + ", newCursorPosition=" + ((SetComposingTextCommand) $this$toStringForLog).getNewCursorPosition() + ')';
        }
        if ($this$toStringForLog instanceof SetComposingRegionCommand) {
            return $this$toStringForLog.toString();
        }
        if ($this$toStringForLog instanceof DeleteSurroundingTextCommand) {
            return $this$toStringForLog.toString();
        }
        if ($this$toStringForLog instanceof DeleteSurroundingTextInCodePointsCommand) {
            return $this$toStringForLog.toString();
        }
        if ($this$toStringForLog instanceof SetSelectionCommand) {
            return $this$toStringForLog.toString();
        }
        if ($this$toStringForLog instanceof FinishComposingTextCommand) {
            return $this$toStringForLog.toString();
        }
        if ($this$toStringForLog instanceof BackspaceCommand) {
            return $this$toStringForLog.toString();
        }
        if ($this$toStringForLog instanceof MoveCursorCommand) {
            return $this$toStringForLog.toString();
        }
        if ($this$toStringForLog instanceof DeleteAllCommand) {
            return $this$toStringForLog.toString();
        }
        StringBuilder append = new StringBuilder().append("Unknown EditCommand: ");
        String simpleName = Reflection.getOrCreateKotlinClass($this$toStringForLog.getClass()).getSimpleName();
        if (simpleName == null) {
            simpleName = "{anonymous EditCommand}";
        }
        return append.append(simpleName).toString();
    }
}
