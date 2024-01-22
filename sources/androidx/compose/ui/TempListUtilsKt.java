package androidx.compose.ui;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\t\u001a_\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r0\u000b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\f\"\u0004\b\u0002\u0010\r*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r0\u000f0\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a}\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010\u0011*\u00060\u0003j\u0002`\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\u0006\u0010\u0012\u001a\u0002H\u00112\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\u0019\u001ab\u0010\u001a\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0000\u001aI\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u001d0\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a_\u0010\u001e\u001a\u0002H\u001f\"\u0004\b\u0000\u0010\u001f\"\b\b\u0001\u0010\u0002*\u0002H\u001f*\b\u0012\u0004\u0012\u0002H\u00020\u000e2'\u0010 \u001a#\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001f0!H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010%\u001a\u0010&\u001a\b\u0012\u0004\u0012\u0002H\r0\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001d\"\u0004\b\u0002\u0010\r*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u000e26\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b()\u0012\u0004\u0012\u0002H\r0!H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u001aM\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001d0!H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006+"}, d2 = {"appendElement", "", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "element", "transform", "Lkotlin/Function1;", "", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "fastAssociate", "", "K", "V", "", "Lkotlin/Pair;", "fastJoinTo", "A", "buffer", "separator", "prefix", "postfix", "limit", "", "truncated", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "fastJoinToString", "", "fastMapNotNull", "R", "fastReduce", "S", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fastZip", "other", "a", "b", "fastZipWithNext", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TempListUtils.kt */
public final class TempListUtilsKt {
    public static final <T, R> List<R> fastZipWithNext(List<? extends T> $this$fastZipWithNext, Function2<? super T, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter($this$fastZipWithNext, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if ($this$fastZipWithNext.size() == 0 || $this$fastZipWithNext.size() == 1) {
            return CollectionsKt.emptyList();
        }
        List result = new ArrayList();
        Object current = $this$fastZipWithNext.get(0);
        int lastIndex = CollectionsKt.getLastIndex($this$fastZipWithNext);
        for (int i = 0; i < lastIndex; i++) {
            Object next = $this$fastZipWithNext.get(i + 1);
            result.add(transform.invoke(current, next));
            current = next;
        }
        return result;
    }

    public static final <S, T extends S> S fastReduce(List<? extends T> $this$fastReduce, Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter($this$fastReduce, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (!$this$fastReduce.isEmpty()) {
            Object accumulator = CollectionsKt.first($this$fastReduce);
            int i = 1;
            int lastIndex = CollectionsKt.getLastIndex($this$fastReduce);
            if (1 <= lastIndex) {
                while (true) {
                    accumulator = operation.invoke(accumulator, $this$fastReduce.get(i));
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            return accumulator;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public static final <T, K, V> Map<K, V> fastAssociate(List<? extends T> $this$fastAssociate, Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter($this$fastAssociate, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        LinkedHashMap target = new LinkedHashMap($this$fastAssociate.size());
        List $this$fastForEach$iv = $this$fastAssociate;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Pair pair = (Pair) transform.invoke($this$fastForEach$iv.get(index$iv));
            target.put(pair.getFirst(), pair.getSecond());
        }
        return target;
    }

    public static final <T, R, V> List<V> fastZip(List<? extends T> $this$fastZip, List<? extends R> other, Function2<? super T, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter($this$fastZip, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int minSize = Math.min($this$fastZip.size(), other.size());
        ArrayList target = new ArrayList(minSize);
        for (int i = 0; i < minSize; i++) {
            target.add(transform.invoke($this$fastZip.get(i), other.get(i)));
        }
        return target;
    }

    public static final <T, R> List<R> fastMapNotNull(List<? extends T> $this$fastMapNotNull, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter($this$fastMapNotNull, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        List target = new ArrayList($this$fastMapNotNull.size());
        List $this$fastForEach$iv = $this$fastMapNotNull;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object it = transform.invoke($this$fastForEach$iv.get(index$iv));
            if (it != null) {
                target.add(it);
            }
        }
        return target;
    }

    public static /* synthetic */ String fastJoinToString$default(List list, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        int i3;
        CharSequence charSequence5;
        if ((i2 & 1) != 0) {
        }
        String str = (i2 & 2) != 0 ? "" : charSequence2;
        String str2 = (i2 & 4) != 0 ? "" : charSequence3;
        if ((i2 & 8) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 16) != 0) {
            charSequence5 = "...";
        } else {
            charSequence5 = charSequence4;
        }
        return fastJoinToString(list, charSequence, str, str2, i3, charSequence5, (i2 & 32) != 0 ? null : function1);
    }

    public static final <T> String fastJoinToString(List<? extends T> $this$fastJoinToString, CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, Function1<? super T, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter($this$fastJoinToString, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb = ((StringBuilder) fastJoinTo($this$fastJoinToString, new StringBuilder(), separator, prefix, postfix, limit, truncated, transform)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "fastJoinTo(StringBuilder…form)\n        .toString()");
        return sb;
    }

    static /* synthetic */ Appendable fastJoinTo$default(List list, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        CharSequence charSequence5;
        int i3;
        CharSequence charSequence6;
        Function1 function12;
        if ((i2 & 2) == 0) {
            charSequence5 = charSequence;
        }
        String str = (i2 & 4) != 0 ? "" : charSequence2;
        String str2 = (i2 & 8) != 0 ? "" : charSequence3;
        if ((i2 & 16) != 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        if ((i2 & 32) == 0) {
            charSequence6 = charSequence4;
        }
        if ((i2 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        return fastJoinTo(list, appendable, charSequence5, str, str2, i3, charSequence6, function12);
    }

    private static final <T, A extends Appendable> A fastJoinTo(List<? extends T> $this$fastJoinTo, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, Function1<? super T, ? extends CharSequence> transform) {
        buffer.append(prefix);
        int count = 0;
        int size = $this$fastJoinTo.size();
        for (int index = 0; index < size; index++) {
            Object element = $this$fastJoinTo.get(index);
            count++;
            if (count > 1) {
                buffer.append(separator);
            }
            if (limit >= 0 && count > limit) {
                break;
            }
            appendElement(buffer, element, transform);
        }
        if (limit >= 0 && count > limit) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    private static final <T> void appendElement(Appendable $this$appendElement, T element, Function1<? super T, ? extends CharSequence> transform) {
        if (transform != null) {
            $this$appendElement.append((CharSequence) transform.invoke(element));
            return;
        }
        if (element == null ? true : element instanceof CharSequence) {
            $this$appendElement.append((CharSequence) element);
        } else if (element instanceof Character) {
            $this$appendElement.append(((Character) element).charValue());
        } else {
            $this$appendElement.append(String.valueOf(element));
        }
    }
}
