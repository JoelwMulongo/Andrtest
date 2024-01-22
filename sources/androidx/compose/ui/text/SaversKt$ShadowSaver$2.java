package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/graphics/Shadow;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$ShadowSaver$2 extends Lambda implements Function1<Object, Shadow> {
    public static final SaversKt$ShadowSaver$2 INSTANCE = new SaversKt$ShadowSaver$2();

    SaversKt$ShadowSaver$2() {
        super(1);
    }

    public final Shadow invoke(Object it) {
        Color color;
        Offset offset;
        Intrinsics.checkNotNullParameter(it, "it");
        List list = (List) it;
        Object value$iv = list.get(0);
        Saver $this$restore_u24lambda_u243_u24lambda_u242$iv = SaversKt.getSaver(Color.Companion);
        Float f = null;
        if (Intrinsics.areEqual(value$iv, (Object) false)) {
            color = null;
        } else if (value$iv != null) {
            Object obj = value$iv;
            color = $this$restore_u24lambda_u243_u24lambda_u242$iv.restore(value$iv);
        } else {
            color = null;
        }
        Intrinsics.checkNotNull(color);
        long r3 = color.m3174unboximpl();
        Object value$iv2 = list.get(1);
        Saver $this$restore_u24lambda_u243_u24lambda_u242$iv2 = SaversKt.getSaver(Offset.Companion);
        if (Intrinsics.areEqual(value$iv2, (Object) false)) {
            offset = null;
        } else if (value$iv2 != null) {
            Object obj2 = value$iv2;
            offset = $this$restore_u24lambda_u243_u24lambda_u242$iv2.restore(value$iv2);
        } else {
            offset = null;
        }
        Intrinsics.checkNotNull(offset);
        long r9 = offset.m2925unboximpl();
        Object value$iv3 = list.get(2);
        if (value$iv3 != null) {
            f = (Float) value$iv3;
        }
        Intrinsics.checkNotNull(f);
        return new Shadow(r3, r9, f.floatValue(), (DefaultConstructorMarker) null);
    }
}
