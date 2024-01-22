package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/AnnotatedString;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Savers.kt */
final class SaversKt$AnnotatedStringSaver$2 extends Lambda implements Function1<Object, AnnotatedString> {
    public static final SaversKt$AnnotatedStringSaver$2 INSTANCE = new SaversKt$AnnotatedStringSaver$2();

    SaversKt$AnnotatedStringSaver$2() {
        super(1);
    }

    public final AnnotatedString invoke(Object it) {
        List list;
        List list2;
        List list3;
        List list4;
        Intrinsics.checkNotNullParameter(it, "it");
        List list5 = (List) it;
        Object value$iv = list5.get(1);
        Saver saver$iv = SaversKt.AnnotationRangeListSaver;
        List list6 = null;
        if (Intrinsics.areEqual(value$iv, (Object) false)) {
            list = null;
        } else if (value$iv != null) {
            Object obj = value$iv;
            list = (List) saver$iv.restore(value$iv);
        } else {
            list = null;
        }
        List spanStylesOrNull = list;
        Object value$iv2 = list5.get(2);
        Saver saver$iv2 = SaversKt.AnnotationRangeListSaver;
        if (Intrinsics.areEqual(value$iv2, (Object) false)) {
            list2 = null;
        } else if (value$iv2 != null) {
            Object obj2 = value$iv2;
            list2 = (List) saver$iv2.restore(value$iv2);
        } else {
            list2 = null;
        }
        List paragraphStylesOrNull = list2;
        Object value$iv3 = list5.get(0);
        String str = value$iv3 != null ? (String) value$iv3 : null;
        Intrinsics.checkNotNull(str);
        if (spanStylesOrNull != null) {
            Collection collection = spanStylesOrNull;
            if (collection.isEmpty()) {
                collection = null;
            }
            list3 = (List) collection;
        } else {
            list3 = null;
        }
        if (paragraphStylesOrNull != null) {
            Collection collection2 = paragraphStylesOrNull;
            if (collection2.isEmpty()) {
                collection2 = null;
            }
            list4 = (List) collection2;
        } else {
            list4 = null;
        }
        Object value$iv4 = list5.get(3);
        Saver saver$iv3 = SaversKt.AnnotationRangeListSaver;
        if (!Intrinsics.areEqual(value$iv4, (Object) false) && value$iv4 != null) {
            Object obj3 = value$iv4;
            list6 = (List) saver$iv3.restore(value$iv4);
        }
        return new AnnotatedString(str, list3, list4, list6);
    }
}
