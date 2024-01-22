package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField.kt */
final class BasicTextFieldKt$BasicTextField$8$1 extends Lambda implements Function1<TextFieldValue, Unit> {
    final /* synthetic */ Function1<TextFieldValue, Unit> $onValueChange;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextFieldKt$BasicTextField$8$1(TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1) {
        super(1);
        this.$value = textFieldValue;
        this.$onValueChange = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((TextFieldValue) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(TextFieldValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!Intrinsics.areEqual((Object) this.$value, (Object) it)) {
            this.$onValueChange.invoke(it);
        }
    }
}
