package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "it", "", "invoke-x-9fifI"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$OffsetSaver$2 extends Lambda implements Function1<Object, Offset> {
    public static final SaversKt$OffsetSaver$2 INSTANCE = new SaversKt$OffsetSaver$2();

    SaversKt$OffsetSaver$2() {
        super(1);
    }

    /* renamed from: invoke-x-9fifI  reason: not valid java name */
    public final Offset invoke(Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(it, (Object) false)) {
            return Offset.m2904boximpl(Offset.Companion.m2930getUnspecifiedF1C5BW0());
        }
        List list = (List) it;
        Object value$iv = list.get(0);
        Object it$iv = null;
        Object it$iv2 = value$iv != null ? (Float) value$iv : null;
        Intrinsics.checkNotNull(it$iv2);
        float floatValue = ((Number) it$iv2).floatValue();
        Object value$iv2 = list.get(1);
        if (value$iv2 != null) {
            it$iv = (Float) value$iv2;
        }
        Intrinsics.checkNotNull(it$iv);
        return Offset.m2904boximpl(OffsetKt.Offset(floatValue, ((Number) it$iv).floatValue()));
    }
}
