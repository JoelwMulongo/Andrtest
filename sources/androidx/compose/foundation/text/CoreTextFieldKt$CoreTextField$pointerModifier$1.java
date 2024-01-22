package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$pointerModifier$1 extends Lambda implements Function1<Offset, Unit> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ TextFieldState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$pointerModifier$1(TextFieldState textFieldState, FocusRequester focusRequester, boolean z, TextFieldSelectionManager textFieldSelectionManager, OffsetMapping offsetMapping) {
        super(1);
        this.$state = textFieldState;
        this.$focusRequester = focusRequester;
        this.$readOnly = z;
        this.$manager = textFieldSelectionManager;
        this.$offsetMapping = offsetMapping;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        m1139invokek4lQ0M(((Offset) p1).m2925unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
    public final void m1139invokek4lQ0M(long offset) {
        boolean z = true;
        CoreTextFieldKt.tapToFocus(this.$state, this.$focusRequester, !this.$readOnly);
        if (!this.$state.getHasFocus()) {
            return;
        }
        if (this.$state.getHandleState() != HandleState.Selection) {
            TextLayoutResultProxy layoutResult = this.$state.getLayoutResult();
            if (layoutResult != null) {
                TextFieldState textFieldState = this.$state;
                long j = offset;
                TextFieldDelegate.Companion.m1210setCursorOffsetULxng0E$foundation_release(j, layoutResult, textFieldState.getProcessor(), this.$offsetMapping, textFieldState.getOnValueChange());
                if (textFieldState.getTextDelegate().getText().length() <= 0) {
                    z = false;
                }
                if (z) {
                    textFieldState.setHandleState(HandleState.Cursor);
                    return;
                }
                return;
            }
            return;
        }
        this.$manager.m1336deselect_kEHs6E$foundation_release(Offset.m2904boximpl(offset));
    }
}
