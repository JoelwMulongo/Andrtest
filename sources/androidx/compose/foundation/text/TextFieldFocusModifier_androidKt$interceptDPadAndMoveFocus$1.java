package androidx.compose.foundation.text;

import android.view.InputDevice;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.text.input.TextInputSession;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "invoke-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldFocusModifier.android.kt */
final class TextFieldFocusModifier_androidKt$interceptDPadAndMoveFocus$1 extends Lambda implements Function1<KeyEvent, Boolean> {
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ TextFieldState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldFocusModifier_androidKt$interceptDPadAndMoveFocus$1(FocusManager focusManager, TextFieldState textFieldState) {
        super(1);
        this.$focusManager = focusManager;
        this.$state = textFieldState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return m1211invokeZmokQxo(((KeyEvent) p1).m4513unboximpl());
    }

    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m1211invokeZmokQxo(android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        InputDevice device = keyEvent.getDevice();
        boolean z = false;
        if (device == null) {
            return false;
        }
        if ((device.getKeyboardType() == 2 && device.isVirtual()) || !KeyEventType.m4517equalsimpl0(KeyEvent_androidKt.m4525getTypeZmokQxo(keyEvent), KeyEventType.Companion.m4521getKeyDownCS__XNY())) {
            return false;
        }
        switch (Key_androidKt.m4535getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m4524getKeyZmokQxo(keyEvent))) {
            case 19:
                z = this.$focusManager.m2857moveFocus3ESFkO8(FocusDirection.Companion.m2856getUpdhqQ8s());
                break;
            case 20:
                z = this.$focusManager.m2857moveFocus3ESFkO8(FocusDirection.Companion.m2847getDowndhqQ8s());
                break;
            case 21:
                z = this.$focusManager.m2857moveFocus3ESFkO8(FocusDirection.Companion.m2851getLeftdhqQ8s());
                break;
            case 22:
                z = this.$focusManager.m2857moveFocus3ESFkO8(FocusDirection.Companion.m2855getRightdhqQ8s());
                break;
            case 23:
                TextInputSession inputSession = this.$state.getInputSession();
                if (inputSession != null) {
                    inputSession.showSoftwareKeyboard();
                }
                z = true;
                break;
        }
        return Boolean.valueOf(z);
    }
}
