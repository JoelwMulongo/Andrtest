package androidx.compose.ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.ui.text.TextRange;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\f\u0010\u0011\u001a\u00020\u000b*\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"DEBUG_CLASS", "", "hasFlag", "", "bits", "", "flag", "asExecutor", "Ljava/util/concurrent/Executor;", "Landroid/view/Choreographer;", "update", "", "Landroid/view/inputmethod/EditorInfo;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "updateWithEmojiCompat", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextInputServiceAndroid.android.kt */
public final class TextInputServiceAndroid_androidKt {
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    /* access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo $this$updateWithEmojiCompat) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo($this$updateWithEmojiCompat);
        }
    }

    public static final void update(EditorInfo $this$update, ImeOptions imeOptions, TextFieldValue textFieldValue) {
        Intrinsics.checkNotNullParameter($this$update, "<this>");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
        int r0 = imeOptions.m5645getImeActioneUduSuo();
        int i = 6;
        if (ImeAction.m5622equalsimpl0(r0, ImeAction.Companion.m5634getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m5622equalsimpl0(r0, ImeAction.Companion.m5638getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m5622equalsimpl0(r0, ImeAction.Companion.m5636getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m5622equalsimpl0(r0, ImeAction.Companion.m5637getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m5622equalsimpl0(r0, ImeAction.Companion.m5639getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m5622equalsimpl0(r0, ImeAction.Companion.m5640getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m5622equalsimpl0(r0, ImeAction.Companion.m5641getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m5622equalsimpl0(r0, ImeAction.Companion.m5635getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction".toString());
        }
        $this$update.imeOptions = i;
        int r02 = imeOptions.m5646getKeyboardTypePjHm6EE();
        if (KeyboardType.m5668equalsimpl0(r02, KeyboardType.Companion.m5688getTextPjHm6EE())) {
            $this$update.inputType = 1;
        } else if (KeyboardType.m5668equalsimpl0(r02, KeyboardType.Companion.m5681getAsciiPjHm6EE())) {
            $this$update.inputType = 1;
            $this$update.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m5668equalsimpl0(r02, KeyboardType.Companion.m5684getNumberPjHm6EE())) {
            $this$update.inputType = 2;
        } else if (KeyboardType.m5668equalsimpl0(r02, KeyboardType.Companion.m5687getPhonePjHm6EE())) {
            $this$update.inputType = 3;
        } else if (KeyboardType.m5668equalsimpl0(r02, KeyboardType.Companion.m5689getUriPjHm6EE())) {
            $this$update.inputType = 17;
        } else if (KeyboardType.m5668equalsimpl0(r02, KeyboardType.Companion.m5683getEmailPjHm6EE())) {
            $this$update.inputType = 33;
        } else if (KeyboardType.m5668equalsimpl0(r02, KeyboardType.Companion.m5686getPasswordPjHm6EE())) {
            $this$update.inputType = 129;
        } else if (KeyboardType.m5668equalsimpl0(r02, KeyboardType.Companion.m5685getNumberPasswordPjHm6EE())) {
            $this$update.inputType = 18;
        } else if (KeyboardType.m5668equalsimpl0(r02, KeyboardType.Companion.m5682getDecimalPjHm6EE())) {
            $this$update.inputType = InputDeviceCompat.SOURCE_MOUSE;
        } else {
            throw new IllegalStateException("Invalid Keyboard Type".toString());
        }
        if (!imeOptions.getSingleLine() && hasFlag($this$update.inputType, 1)) {
            $this$update.inputType |= 131072;
            if (ImeAction.m5622equalsimpl0(imeOptions.m5645getImeActioneUduSuo(), ImeAction.Companion.m5634getDefaulteUduSuo())) {
                $this$update.imeOptions |= 1073741824;
            }
        }
        if (hasFlag($this$update.inputType, 1)) {
            int r03 = imeOptions.m5644getCapitalizationIUNYP9k();
            if (KeyboardCapitalization.m5653equalsimpl0(r03, KeyboardCapitalization.Companion.m5661getCharactersIUNYP9k())) {
                $this$update.inputType |= 4096;
            } else if (KeyboardCapitalization.m5653equalsimpl0(r03, KeyboardCapitalization.Companion.m5664getWordsIUNYP9k())) {
                $this$update.inputType |= 8192;
            } else if (KeyboardCapitalization.m5653equalsimpl0(r03, KeyboardCapitalization.Companion.m5663getSentencesIUNYP9k())) {
                $this$update.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                $this$update.inputType |= 32768;
            }
        }
        $this$update.initialSelStart = TextRange.m5474getStartimpl(textFieldValue.m5695getSelectiond9O1mEE());
        $this$update.initialSelEnd = TextRange.m5469getEndimpl(textFieldValue.m5695getSelectiond9O1mEE());
        EditorInfoCompat.setInitialSurroundingText($this$update, textFieldValue.getText());
        $this$update.imeOptions |= 33554432;
    }

    public static final Executor asExecutor(Choreographer $this$asExecutor) {
        Intrinsics.checkNotNullParameter($this$asExecutor, "<this>");
        return new TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda1($this$asExecutor);
    }

    /* access modifiers changed from: private */
    public static final void asExecutor$lambda$1(Choreographer $this_asExecutor, Runnable runnable) {
        Intrinsics.checkNotNullParameter($this_asExecutor, "$this_asExecutor");
        $this_asExecutor.postFrameCallback(new TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0(runnable));
    }

    /* access modifiers changed from: private */
    public static final void asExecutor$lambda$1$lambda$0(Runnable $runnable, long it) {
        $runnable.run();
    }

    private static final boolean hasFlag(int bits, int flag) {
        return (bits & flag) == flag;
    }
}
