package androidx.compose.ui.text.input;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.SaversKt;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/ui/text/input/TextFieldValue;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldValue.kt */
final class TextFieldValue$Companion$Saver$1 extends Lambda implements Function2<SaverScope, TextFieldValue, Object> {
    public static final TextFieldValue$Companion$Saver$1 INSTANCE = new TextFieldValue$Companion$Saver$1();

    TextFieldValue$Companion$Saver$1() {
        super(2);
    }

    public final Object invoke(SaverScope $this$Saver, TextFieldValue it) {
        Intrinsics.checkNotNullParameter($this$Saver, "$this$Saver");
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.arrayListOf(SaversKt.save(it.getAnnotatedString(), SaversKt.getAnnotatedStringSaver(), $this$Saver), SaversKt.save(TextRange.m5462boximpl(it.m5695getSelectiond9O1mEE()), SaversKt.getSaver(TextRange.Companion), $this$Saver));
    }
}
