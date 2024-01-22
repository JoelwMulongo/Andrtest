package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextInputSession;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001aR\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/text/KeyboardActionRunner;", "Landroidx/compose/foundation/text/KeyboardActionScope;", "()V", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "setFocusManager", "(Landroidx/compose/ui/focus/FocusManager;)V", "inputSession", "Landroidx/compose/ui/text/input/TextInputSession;", "getInputSession", "()Landroidx/compose/ui/text/input/TextInputSession;", "setInputSession", "(Landroidx/compose/ui/text/input/TextInputSession;)V", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "getKeyboardActions", "()Landroidx/compose/foundation/text/KeyboardActions;", "setKeyboardActions", "(Landroidx/compose/foundation/text/KeyboardActions;)V", "defaultKeyboardAction", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "defaultKeyboardAction-KlQnJC8", "(I)V", "runAction", "runAction-KlQnJC8", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: KeyboardActionRunner.kt */
public final class KeyboardActionRunner implements KeyboardActionScope {
    public FocusManager focusManager;
    private TextInputSession inputSession;
    public KeyboardActions keyboardActions;

    public final KeyboardActions getKeyboardActions() {
        KeyboardActions keyboardActions2 = this.keyboardActions;
        if (keyboardActions2 != null) {
            return keyboardActions2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        return null;
    }

    public final void setKeyboardActions(KeyboardActions keyboardActions2) {
        Intrinsics.checkNotNullParameter(keyboardActions2, "<set-?>");
        this.keyboardActions = keyboardActions2;
    }

    public final FocusManager getFocusManager() {
        FocusManager focusManager2 = this.focusManager;
        if (focusManager2 != null) {
            return focusManager2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
        return null;
    }

    public final void setFocusManager(FocusManager focusManager2) {
        Intrinsics.checkNotNullParameter(focusManager2, "<set-?>");
        this.focusManager = focusManager2;
    }

    public final TextInputSession getInputSession() {
        return this.inputSession;
    }

    public final void setInputSession(TextInputSession textInputSession) {
        this.inputSession = textInputSession;
    }

    /* renamed from: runAction-KlQnJC8  reason: not valid java name */
    public final void m1153runActionKlQnJC8(int imeAction) {
        Function1 keyboardAction;
        Unit unit = null;
        if (ImeAction.m5622equalsimpl0(imeAction, ImeAction.Companion.m5635getDoneeUduSuo())) {
            keyboardAction = getKeyboardActions().getOnDone();
        } else if (ImeAction.m5622equalsimpl0(imeAction, ImeAction.Companion.m5636getGoeUduSuo())) {
            keyboardAction = getKeyboardActions().getOnGo();
        } else if (ImeAction.m5622equalsimpl0(imeAction, ImeAction.Companion.m5637getNexteUduSuo())) {
            keyboardAction = getKeyboardActions().getOnNext();
        } else if (ImeAction.m5622equalsimpl0(imeAction, ImeAction.Companion.m5639getPreviouseUduSuo())) {
            keyboardAction = getKeyboardActions().getOnPrevious();
        } else if (ImeAction.m5622equalsimpl0(imeAction, ImeAction.Companion.m5640getSearcheUduSuo())) {
            keyboardAction = getKeyboardActions().getOnSearch();
        } else if (ImeAction.m5622equalsimpl0(imeAction, ImeAction.Companion.m5641getSendeUduSuo())) {
            keyboardAction = getKeyboardActions().getOnSend();
        } else {
            if (ImeAction.m5622equalsimpl0(imeAction, ImeAction.Companion.m5634getDefaulteUduSuo()) ? true : ImeAction.m5622equalsimpl0(imeAction, ImeAction.Companion.m5638getNoneeUduSuo())) {
                keyboardAction = null;
            } else {
                throw new IllegalStateException("invalid ImeAction".toString());
            }
        }
        if (keyboardAction != null) {
            keyboardAction.invoke(this);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            m1152defaultKeyboardActionKlQnJC8(imeAction);
        }
    }

    /* renamed from: defaultKeyboardAction-KlQnJC8  reason: not valid java name */
    public void m1152defaultKeyboardActionKlQnJC8(int imeAction) {
        if (ImeAction.m5622equalsimpl0(imeAction, ImeAction.Companion.m5637getNexteUduSuo())) {
            getFocusManager().m2857moveFocus3ESFkO8(FocusDirection.Companion.m2852getNextdhqQ8s());
        } else if (ImeAction.m5622equalsimpl0(imeAction, ImeAction.Companion.m5639getPreviouseUduSuo())) {
            getFocusManager().m2857moveFocus3ESFkO8(FocusDirection.Companion.m2854getPreviousdhqQ8s());
        } else if (ImeAction.m5622equalsimpl0(imeAction, ImeAction.Companion.m5635getDoneeUduSuo())) {
            TextInputSession textInputSession = this.inputSession;
            if (textInputSession != null) {
                textInputSession.hideSoftwareKeyboard();
            }
        } else {
            boolean z = true;
            if (!(ImeAction.m5622equalsimpl0(imeAction, ImeAction.Companion.m5636getGoeUduSuo()) ? true : ImeAction.m5622equalsimpl0(imeAction, ImeAction.Companion.m5640getSearcheUduSuo()) ? true : ImeAction.m5622equalsimpl0(imeAction, ImeAction.Companion.m5641getSendeUduSuo()))) {
                z = ImeAction.m5622equalsimpl0(imeAction, ImeAction.Companion.m5634getDefaulteUduSuo());
            }
            if (!z) {
                ImeAction.m5622equalsimpl0(imeAction, ImeAction.Companion.m5638getNoneeUduSuo());
            }
        }
    }
}
