package androidx.compose.ui.text;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/TextUnit;", "it", "", "invoke-XNhUCwk"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$TextUnitSaver$2 extends Lambda implements Function1<Object, TextUnit> {
    public static final SaversKt$TextUnitSaver$2 INSTANCE = new SaversKt$TextUnitSaver$2();

    SaversKt$TextUnitSaver$2() {
        super(1);
    }

    /* renamed from: invoke-XNhUCwk  reason: not valid java name */
    public final TextUnit invoke(Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        List list = (List) it;
        Object value$iv = list.get(0);
        TextUnitType textUnitType = null;
        Object it$iv = value$iv != null ? (Float) value$iv : null;
        Intrinsics.checkNotNull(it$iv);
        float floatValue = ((Number) it$iv).floatValue();
        Object value$iv2 = list.get(1);
        if (value$iv2 != null) {
            textUnitType = (TextUnitType) value$iv2;
        }
        Intrinsics.checkNotNull(textUnitType);
        return TextUnit.m6157boximpl(TextUnitKt.m6179TextUnitanM5pPY(floatValue, textUnitType.m6198unboximpl()));
    }
}
