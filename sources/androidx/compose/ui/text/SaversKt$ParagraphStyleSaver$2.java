package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/ParagraphStyle;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$ParagraphStyleSaver$2 extends Lambda implements Function1<Object, ParagraphStyle> {
    public static final SaversKt$ParagraphStyleSaver$2 INSTANCE = new SaversKt$ParagraphStyleSaver$2();

    SaversKt$ParagraphStyleSaver$2() {
        super(1);
    }

    public final ParagraphStyle invoke(Object it) {
        TextAlign textAlign;
        TextDirection textDirection;
        TextUnit textUnit;
        TextIndent textIndent;
        Object obj = it;
        Intrinsics.checkNotNullParameter(obj, "it");
        List list = (List) obj;
        Object value$iv = list.get(0);
        if (value$iv != null) {
            textAlign = (TextAlign) value$iv;
        } else {
            textAlign = null;
        }
        Object value$iv2 = list.get(1);
        if (value$iv2 != null) {
            textDirection = (TextDirection) value$iv2;
        } else {
            textDirection = null;
        }
        Object value$iv3 = list.get(2);
        Saver $this$restore_u24lambda_u243_u24lambda_u242$iv = SaversKt.getSaver(TextUnit.Companion);
        if (Intrinsics.areEqual(value$iv3, (Object) false)) {
            textUnit = null;
        } else if (value$iv3 != null) {
            Object obj2 = value$iv3;
            textUnit = $this$restore_u24lambda_u243_u24lambda_u242$iv.restore(value$iv3);
        } else {
            textUnit = null;
        }
        Intrinsics.checkNotNull(textUnit);
        long r7 = textUnit.m6176unboximpl();
        Object value$iv4 = list.get(3);
        Saver $this$restore_u24lambda_u243_u24lambda_u242$iv2 = SaversKt.getSaver(TextIndent.Companion);
        if (Intrinsics.areEqual(value$iv4, (Object) false)) {
            textIndent = null;
        } else if (value$iv4 != null) {
            Object obj3 = value$iv4;
            textIndent = $this$restore_u24lambda_u243_u24lambda_u242$iv2.restore(value$iv4);
        } else {
            textIndent = null;
        }
        return new ParagraphStyle(textAlign, textDirection, r7, textIndent, (PlatformParagraphStyle) null, (LineHeightStyle) null, (LineBreak) null, (Hyphens) null, 240, (DefaultConstructorMarker) null);
    }
}
