package androidx.compose.ui.text.input;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SaversKt;
import androidx.compose.ui.text.TextRange;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/input/TextFieldValue;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldValue.kt */
final class TextFieldValue$Companion$Saver$2 extends Lambda implements Function1<Object, TextFieldValue> {
    public static final TextFieldValue$Companion$Saver$2 INSTANCE = new TextFieldValue$Companion$Saver$2();

    TextFieldValue$Companion$Saver$2() {
        super(1);
    }

    public final TextFieldValue invoke(Object it) {
        AnnotatedString annotatedString;
        Intrinsics.checkNotNullParameter(it, "it");
        List list = (List) it;
        Object value$iv = list.get(0);
        Saver $this$restore_u24lambda_u243_u24lambda_u242$iv = SaversKt.getAnnotatedStringSaver();
        TextRange textRange = null;
        if (Intrinsics.areEqual(value$iv, (Object) false)) {
            annotatedString = null;
        } else if (value$iv != null) {
            Object obj = value$iv;
            annotatedString = $this$restore_u24lambda_u243_u24lambda_u242$iv.restore(value$iv);
        } else {
            annotatedString = null;
        }
        Intrinsics.checkNotNull(annotatedString);
        Object value$iv2 = list.get(1);
        Saver $this$restore_u24lambda_u243_u24lambda_u242$iv2 = SaversKt.getSaver(TextRange.Companion);
        if (!Intrinsics.areEqual(value$iv2, (Object) false) && value$iv2 != null) {
            Object obj2 = value$iv2;
            textRange = $this$restore_u24lambda_u243_u24lambda_u242$iv2.restore(value$iv2);
        }
        Intrinsics.checkNotNull(textRange);
        return new TextFieldValue(annotatedString, textRange.m5478unboximpl(), (TextRange) null, 4, (DefaultConstructorMarker) null);
    }
}
