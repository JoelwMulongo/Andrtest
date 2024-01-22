package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField.kt */
final class BasicTextFieldKt$BasicTextField$3$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TextFieldValue $textFieldValue;
    final /* synthetic */ MutableState<TextFieldValue> $textFieldValueState$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextFieldKt$BasicTextField$3$1(TextFieldValue textFieldValue, MutableState<TextFieldValue> mutableState) {
        super(0);
        this.$textFieldValue = textFieldValue;
        this.$textFieldValueState$delegate = mutableState;
    }

    public final void invoke() {
        if (!TextRange.m5467equalsimpl0(this.$textFieldValue.m5695getSelectiond9O1mEE(), BasicTextFieldKt.BasicTextField$lambda$2(this.$textFieldValueState$delegate).m5695getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) this.$textFieldValue.m5694getCompositionMzsxiRA(), (Object) BasicTextFieldKt.BasicTextField$lambda$2(this.$textFieldValueState$delegate).m5694getCompositionMzsxiRA())) {
            BasicTextFieldKt.BasicTextField$lambda$3(this.$textFieldValueState$delegate, this.$textFieldValue);
        }
    }
}
