package androidx.compose.ui.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\b\u0003\u001a;\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a;\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aB\u0010\u0007\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0005H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\b\u001a;\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\n0\u0005H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aA\u0010\f\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\n0\rH\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a;\u0010\u000f\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\n0\u0005H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aG\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00110\u0005H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a`\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u0010\b\u0002\u0010\u0014*\n\u0012\u0006\b\u0000\u0012\u0002H\u00110\u0015*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u00142\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00110\u0005H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u0017\u001aR\u0010\u0018\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u0019*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00110\u0005H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\b\u001a;\u0010\u001b\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000e0\u0005H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001c"}, d2 = {"fastAll", "", "T", "", "predicate", "Lkotlin/Function1;", "fastAny", "fastFirstOrNull", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "fastForEach", "", "action", "fastForEachIndexed", "Lkotlin/Function2;", "", "fastForEachReversed", "fastMap", "R", "transform", "fastMapTo", "C", "", "destination", "(Ljava/util/List;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "fastMaxBy", "", "selector", "fastSumBy", "ui-util_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
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

    public static final <T> void fastForEachReversed(List<? extends T> $this$fastForEachReversed, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter($this$fastForEachReversed, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int size = $this$fastForEachReversed.size() - 1;
        if (size >= 0) {
            do {
                int index = size;
                size--;
                action.invoke($this$fastForEachReversed.get(index));
            } while (size >= 0);
        }
    }

    public static final <T> void fastForEachIndexed(List<? extends T> $this$fastForEachIndexed, Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter($this$fastForEachIndexed, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int size = $this$fastForEachIndexed.size();
        for (int index = 0; index < size; index++) {
            action.invoke(Integer.valueOf(index), $this$fastForEachIndexed.get(index));
        }
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

    public static final <T> T fastFirstOrNull(List<? extends T> $this$fastFirstOrNull, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter($this$fastFirstOrNull, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        List $this$fastForEach$iv = $this$fastFirstOrNull;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object it = $this$fastForEach$iv.get(index$iv);
            if (predicate.invoke(it).booleanValue()) {
                return it;
            }
        }
        return null;
    }

    public static final <T> int fastSumBy(List<? extends T> $this$fastSumBy, Function1<? super T, Integer> selector) {
        Intrinsics.checkNotNullParameter($this$fastSumBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int sum = 0;
        List $this$fastForEach$iv = $this$fastSumBy;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            sum += selector.invoke($this$fastForEach$iv.get(index$iv)).intValue();
        }
        return sum;
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

    public static final <T, R extends Comparable<? super R>> T fastMaxBy(List<? extends T> $this$fastMaxBy, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter($this$fastMaxBy, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if ($this$fastMaxBy.isEmpty()) {
            return null;
        }
        Object maxElem = $this$fastMaxBy.get(0);
        Comparable maxValue = (Comparable) selector.invoke(maxElem);
        int i = 1;
        int lastIndex = CollectionsKt.getLastIndex($this$fastMaxBy);
        if (1 <= lastIndex) {
            while (true) {
                Object e = $this$fastMaxBy.get(i);
                Comparable v = (Comparable) selector.invoke(e);
                if (maxValue.compareTo(v) < 0) {
                    maxElem = e;
                    maxValue = v;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return maxElem;
    }

    public static final <T, R, C extends Collection<? super R>> C fastMapTo(List<? extends T> $this$fastMapTo, C destination, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter($this$fastMapTo, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        List $this$fastForEach$iv = $this$fastMapTo;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            destination.add(transform.invoke($this$fastForEach$iv.get(index$iv)));
        }
        return destination;
    }
}
