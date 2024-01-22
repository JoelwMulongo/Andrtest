package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\u0007"}, d2 = {"getLocalPlaceholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "start", "", "end", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: MultiParagraphIntrinsics.kt */
public final class MultiParagraphIntrinsicsKt {
    /* access modifiers changed from: private */
    public static final List<AnnotatedString.Range<Placeholder>> getLocalPlaceholders(List<AnnotatedString.Range<Placeholder>> $this$getLocalPlaceholders, int start, int end) {
        int i = start;
        int i2 = end;
        List list = $this$getLocalPlaceholders;
        List target$iv = new ArrayList(list.size());
        List $this$fastForEach$iv$iv = list;
        int size = $this$fastForEach$iv$iv.size();
        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            AnnotatedString.Range it = (AnnotatedString.Range) it$iv;
            if (AnnotatedStringKt.intersect(i, i2, it.getStart(), it.getEnd())) {
                target$iv.add(it$iv);
            }
        }
        List $this$fastMap$iv = target$iv;
        int $i$f$fastMap = 0;
        ArrayList target$iv2 = new ArrayList($this$fastMap$iv.size());
        List $this$fastForEach$iv$iv2 = $this$fastMap$iv;
        int index$iv$iv2 = 0;
        int size2 = $this$fastForEach$iv$iv2.size();
        while (index$iv$iv2 < size2) {
            Collection collection = target$iv2;
            AnnotatedString.Range it2 = (AnnotatedString.Range) $this$fastForEach$iv$iv2.get(index$iv$iv2);
            if (i <= it2.getStart() && it2.getEnd() <= i2) {
                collection.add(new AnnotatedString.Range(it2.getItem(), it2.getStart() - i, it2.getEnd() - i));
                index$iv$iv2++;
                i2 = end;
                $this$fastMap$iv = $this$fastMap$iv;
                $i$f$fastMap = $i$f$fastMap;
            } else {
                throw new IllegalArgumentException("placeholder can not overlap with paragraph.".toString());
            }
        }
        return target$iv2;
    }
}
