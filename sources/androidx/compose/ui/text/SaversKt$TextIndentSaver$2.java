package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/style/TextIndent;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$TextIndentSaver$2 extends Lambda implements Function1<Object, TextIndent> {
    public static final SaversKt$TextIndentSaver$2 INSTANCE = new SaversKt$TextIndentSaver$2();

    SaversKt$TextIndentSaver$2() {
        super(1);
    }

    public final TextIndent invoke(Object it) {
        TextUnit textUnit;
        Intrinsics.checkNotNullParameter(it, "it");
        List list = (List) it;
        Object value$iv = list.get(0);
        Saver $this$restore_u24lambda_u243_u24lambda_u242$iv = SaversKt.getSaver(TextUnit.Companion);
        TextUnit textUnit2 = null;
        if (Intrinsics.areEqual(value$iv, (Object) false)) {
            textUnit = null;
        } else if (value$iv != null) {
            Object obj = value$iv;
            textUnit = $this$restore_u24lambda_u243_u24lambda_u242$iv.restore(value$iv);
        } else {
            textUnit = null;
        }
        Intrinsics.checkNotNull(textUnit);
        long r3 = textUnit.m6176unboximpl();
        Object value$iv2 = list.get(1);
        Saver $this$restore_u24lambda_u243_u24lambda_u242$iv2 = SaversKt.getSaver(TextUnit.Companion);
        if (!Intrinsics.areEqual(value$iv2, (Object) false) && value$iv2 != null) {
            Object obj2 = value$iv2;
            textUnit2 = $this$restore_u24lambda_u243_u24lambda_u242$iv2.restore(value$iv2);
        }
        Intrinsics.checkNotNull(textUnit2);
        return new TextIndent(r3, textUnit2.m6176unboximpl(), (DefaultConstructorMarker) null);
    }
}
