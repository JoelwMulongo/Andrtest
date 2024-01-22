package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/intl/LocaleList;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$LocaleListSaver$2 extends Lambda implements Function1<Object, LocaleList> {
    public static final SaversKt$LocaleListSaver$2 INSTANCE = new SaversKt$LocaleListSaver$2();

    SaversKt$LocaleListSaver$2() {
        super(1);
    }

    public final LocaleList invoke(Object it) {
        Locale locale;
        Object obj = it;
        Intrinsics.checkNotNullParameter(obj, "it");
        List $this$fastMap$iv = (List) obj;
        ArrayList target$iv = new ArrayList($this$fastMap$iv.size());
        List $this$fastForEach$iv$iv = $this$fastMap$iv;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            Collection collection = target$iv;
            Object item = $this$fastForEach$iv$iv.get(index$iv$iv);
            Saver $this$restore_u24lambda_u243_u24lambda_u242$iv = SaversKt.getSaver(Locale.Companion);
            if (Intrinsics.areEqual(item, (Object) false)) {
                locale = null;
            } else if (item != null) {
                Object obj2 = item;
                locale = $this$restore_u24lambda_u243_u24lambda_u242$iv.restore(item);
            } else {
                locale = null;
            }
            Intrinsics.checkNotNull(locale);
            collection.add(locale);
            index$iv$iv++;
            Object obj3 = it;
        }
        return new LocaleList((List<Locale>) target$iv);
    }
}
