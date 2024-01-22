package androidx.compose.runtime.snapshots;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\t\u001a;\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a;\u0010\u000e\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aV\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2'\u0010\r\u001a#\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0010H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a;\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aA\u0010\u0017\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0010H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aS\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002H\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f0\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001a*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001a0\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a}\u0010\u001c\u001a\u0002H\u001d\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010\u001d*\u00060\u0003j\u0002`\u0004*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\u001e\u001a\u0002H\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010$\u001ab\u0010%\u001a\u00020&\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0000\u001aG\u0010'\u001a\b\u0012\u0004\u0012\u0002H(0\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H(0\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aI\u0010)\u001a\b\u0012\u0004\u0012\u0002H(0\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H(0\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a\u001e\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00020+\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006,"}, d2 = {"appendElement", "", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "element", "transform", "Lkotlin/Function1;", "", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "fastAll", "", "", "predicate", "fastAny", "fastFilterIndexed", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "fastForEach", "action", "fastForEachIndexed", "fastGroupBy", "", "K", "keySelector", "fastJoinTo", "A", "buffer", "separator", "prefix", "postfix", "limit", "truncated", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "fastJoinToString", "", "fastMap", "R", "fastMapNotNull", "fastToSet", "", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListUtils.kt */
public final class ListUtilsKt {
    public static final <T> void fastForEach(List<? extends T> $this$fastForEach, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter($this$fastForEach, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int size = $this$fastForEach.size();
        for (int index = 0; index < size; index++) {
            action.invoke($this$fastForEach.get(index));
        }
    }

    public static final <T> Set<T> fastToSet(List<? extends T> $this$fastToSet) {
        Intrinsics.checkNotNullParameter($this$fastToSet, "<this>");
        HashSet hashSet = new HashSet($this$fastToSet.size());
        HashSet set = hashSet;
        List $this$fastForEach$iv = $this$fastToSet;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            set.add($this$fastForEach$iv.get(index$iv));
        }
        return hashSet;
    }

    public static final <T> void fastForEachIndexed(List<? extends T> $this$fastForEachIndexed, Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter($this$fastForEachIndexed, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int size = $this$fastForEachIndexed.size();
        for (int index = 0; index < size; index++) {
            action.invoke(Integer.valueOf(index), $this$fastForEachIndexed.get(index));
        }
    }

    public static final <T, R> List<R> fastMap(List<? extends T> $this$fastMap, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter($this$fastMap, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        List target = new ArrayList($this$fastMap.size());
        List $this$fastForEach$iv = $this$fastMap;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            target.add(transform.invoke($this$fastForEach$iv.get(index$iv)));
        }
        return target;
    }

    public static final <T> boolean fastAny(List<? extends T> $this$fastAny, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$fastAny, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        List $this$fastForEach$iv = $this$fastAny;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            if (predicate.invoke($this$fastForEach$iv.get(index$iv)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <T> boolean fastAll(List<? extends T> $this$fastAll, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$fastAll, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        List $this$fastForEach$iv = $this$fastAll;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            if (!predicate.invoke($this$fastForEach$iv.get(index$iv)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T, K> Map<K, List<T>> fastGroupBy(List<? extends T> $this$fastGroupBy, Function1<? super T, ? extends K> keySelector) {
        Object answer$iv;
        Function1<? super T, ? extends K> function1 = keySelector;
        Intrinsics.checkNotNullParameter($this$fastGroupBy, "<this>");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        HashMap destination = new HashMap($this$fastGroupBy.size());
        List $this$fastForEach$iv = $this$fastGroupBy;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object it = $this$fastForEach$iv.get(index$iv);
            Object key = function1.invoke(it);
            Map $this$getOrPut$iv = destination;
            Object value$iv = $this$getOrPut$iv.get(key);
            if (value$iv == null) {
                answer$iv = new ArrayList();
                $this$getOrPut$iv.put(key, answer$iv);
            } else {
                answer$iv = value$iv;
            }
            ((ArrayList) answer$iv).add(it);
        }
        return destination;
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

    public static final <T> List<T> fastFilterIndexed(List<? extends T> $this$fastFilterIndexed, Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$fastFilterIndexed, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        List target = new ArrayList($this$fastFilterIndexed.size());
        List $this$fastForEachIndexed$iv = $this$fastFilterIndexed;
        int size = $this$fastForEachIndexed$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object e = $this$fastForEachIndexed$iv.get(index$iv);
            if (predicate.invoke(Integer.valueOf(index$iv), e).booleanValue()) {
                target.add(e);
            }
        }
        return target;
    }
}
