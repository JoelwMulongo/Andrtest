package androidx.compose.ui.text;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/TextRange;", "it", "", "invoke-VqIyPBM"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$TextRangeSaver$2 extends Lambda implements Function1<Object, TextRange> {
    public static final SaversKt$TextRangeSaver$2 INSTANCE = new SaversKt$TextRangeSaver$2();

    SaversKt$TextRangeSaver$2() {
        super(1);
    }

    /* renamed from: invoke-VqIyPBM  reason: not valid java name */
    public final TextRange invoke(Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        List list = (List) it;
        Object value$iv = list.get(0);
        Object it$iv = null;
        Object it$iv2 = value$iv != null ? (Integer) value$iv : null;
        Intrinsics.checkNotNull(it$iv2);
        int intValue = ((Number) it$iv2).intValue();
        Object value$iv2 = list.get(1);
        if (value$iv2 != null) {
            it$iv = (Integer) value$iv2;
        }
        Intrinsics.checkNotNull(it$iv);
        return TextRange.m5462boximpl(TextRangeKt.TextRange(intValue, ((Number) it$iv).intValue()));
    }
}
