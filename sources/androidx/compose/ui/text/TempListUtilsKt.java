package androidx.compose.ui.text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\t\u001aG\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\f0\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a&\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001aA\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00130\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aA\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00130\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a$\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\b\b\u0000\u0010\u0002*\u00020\u0016*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000bH\u0000\u001aM\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00180\u000b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00190\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001ac\u0010\u001a\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0006\u0010\u001b\u001a\u0002H\u00182'\u0010\u001c\u001a#\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00180\u001dH\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010!\u001a}\u0010\"\u001a\u0002H#\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010#*\u00060\u0003j\u0002`\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0006\u0010$\u001a\u0002H#2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\u00102\b\b\u0002\u0010)\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010*\u001ab\u0010+\u001a\u00020,\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\u00102\b\b\u0002\u0010)\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0000\u001aR\u0010-\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00180.*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00180\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010/\u001aA\u00100\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00130\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u0002\u0007\n\u0005\b20\u0001¨\u00061"}, d2 = {"appendElement", "", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "element", "transform", "Lkotlin/Function1;", "", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "fastDistinctBy", "", "K", "selector", "fastDrop", "n", "", "fastFilter", "predicate", "", "fastFilterNot", "fastFilterNotNull", "", "fastFlatMap", "R", "", "fastFold", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fastJoinTo", "A", "buffer", "separator", "prefix", "postfix", "limit", "truncated", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "fastJoinToString", "", "fastMinByOrNull", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "fastTakeWhile", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TempListUtils.kt */
public final class TempListUtilsKt {
    public static final <T> List<T> fastFilter(List<? extends T> $this$fastFilter, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$fastFilter, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        List target = new ArrayList($this$fastFilter.size());
        List $this$fastForEach$iv = $this$fastFilter;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object it = $this$fastForEach$iv.get(index$iv);
            if (predicate.invoke(it).booleanValue()) {
                target.add(it);
            }
        }
        return target;
    }

    public static final <T, K> List<T> fastDistinctBy(List<? extends T> $this$fastDistinctBy, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter($this$fastDistinctBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet set = new HashSet($this$fastDistinctBy.size());
        List target = new ArrayList($this$fastDistinctBy.size());
        List $this$fastForEach$iv = $this$fastDistinctBy;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object e = $this$fastForEach$iv.get(index$iv);
            if (set.add(selector.invoke(e))) {
                target.add(e);
            }
        }
        return target;
    }

    public static final <T, R extends Comparable<? super R>> T fastMinByOrNull(List<? extends T> $this$fastMinByOrNull, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter($this$fastMinByOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if ($this$fastMinByOrNull.isEmpty()) {
            return null;
        }
        Object minElem = $this$fastMinByOrNull.get(0);
        Comparable minValue = (Comparable) selector.invoke(minElem);
        int i = 1;
        int lastIndex = CollectionsKt.getLastIndex($this$fastMinByOrNull);
        if (1 <= lastIndex) {
            while (true) {
                Object e = $this$fastMinByOrNull.get(i);
                Comparable v = (Comparable) selector.invoke(e);
                if (minValue.compareTo(v) > 0) {
                    minElem = e;
                    minValue = v;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return minElem;
    }

    public static final <T, R> R fastFold(List<? extends T> $this$fastFold, R initial, Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter($this$fastFold, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Object accumulator = initial;
        List $this$fastForEach$iv = $this$fastFold;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            accumulator = operation.invoke(accumulator, $this$fastForEach$iv.get(index$iv));
        }
        return accumulator;
    }

    public static final <T, R> List<R> fastFlatMap(List<? extends T> $this$fastFlatMap, Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter($this$fastFlatMap, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        List target = new ArrayList($this$fastFlatMap.size());
        List $this$fastForEach$iv = $this$fastFlatMap;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            CollectionsKt.addAll(target, (Iterable) transform.invoke($this$fastForEach$iv.get(index$iv)));
        }
        return target;
    }

    public static final <T> List<T> fastFilterNot(List<? extends T> $this$fastFilterNot, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$fastFilterNot, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        List target = new ArrayList($this$fastFilterNot.size());
        List $this$fastForEach$iv = $this$fastFilterNot;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object it = $this$fastForEach$iv.get(index$iv);
            if (!predicate.invoke(it).booleanValue()) {
                target.add(it);
            }
        }
        return target;
    }

    public static final <T> List<T> fastFilterNotNull(List<? extends T> $this$fastFilterNotNull) {
        Intrinsics.checkNotNullParameter($this$fastFilterNotNull, "<this>");
        List target = new ArrayList($this$fastFilterNotNull.size());
        List $this$fastForEach$iv = $this$fastFilterNotNull;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object it = $this$fastForEach$iv.get(index$iv);
            if (it != null) {
                target.add(it);
            }
        }
        return target;
    }

    public static final <T> List<T> fastTakeWhile(List<? extends T> $this$fastTakeWhile, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$fastTakeWhile, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList target = new ArrayList($this$fastTakeWhile.size());
        int size = $this$fastTakeWhile.size();
        for (int i = 0; i < size; i++) {
            Object item = $this$fastTakeWhile.get(i);
            if (!predicate.invoke(item).booleanValue()) {
                break;
            }
            target.add(item);
        }
        return target;
    }

    public static final <T> List<T> fastDrop(List<? extends T> $this$fastDrop, int n) {
        Intrinsics.checkNotNullParameter($this$fastDrop, "<this>");
        if (!(n >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + n + " is less than zero.").toString());
        } else if (n == 0) {
            return $this$fastDrop;
        } else {
            int resultSize = $this$fastDrop.size() - n;
            if (resultSize <= 0) {
                return CollectionsKt.emptyList();
            }
            if (resultSize == 1) {
                return CollectionsKt.listOf(CollectionsKt.last($this$fastDrop));
            }
            ArrayList target = new ArrayList(resultSize);
            int size = $this$fastDrop.size();
            for (int index = n; index < size; index++) {
                target.add($this$fastDrop.get(index));
            }
            return target;
        }
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
