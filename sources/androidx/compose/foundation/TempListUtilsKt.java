package androidx.compose.foundation;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\u001aA\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001ac\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\b\u001a\u0002H\u00072'\u0010\t\u001a#\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00070\nH\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u000e\u001a^\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u00012)\u0010\u0010\u001a%\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\nH\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aR\u0010\u0013\u001a\u0004\u0018\u0001H\u0007\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00070\u0004H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u0016\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0017"}, d2 = {"fastFilter", "", "T", "predicate", "Lkotlin/Function1;", "", "fastFold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fastMapIndexedNotNull", "transform", "", "index", "fastMaxOfOrNull", "", "selector", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
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

    public static final <T, R> List<R> fastMapIndexedNotNull(List<? extends T> $this$fastMapIndexedNotNull, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter($this$fastMapIndexedNotNull, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        List target = new ArrayList($this$fastMapIndexedNotNull.size());
        List $this$fastForEachIndexed$iv = $this$fastMapIndexedNotNull;
        int size = $this$fastForEachIndexed$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object it = transform.invoke(Integer.valueOf(index$iv), $this$fastForEachIndexed$iv.get(index$iv));
            if (it != null) {
                target.add(it);
            }
        }
        return target;
    }

    public static final <T, R extends Comparable<? super R>> R fastMaxOfOrNull(List<? extends T> $this$fastMaxOfOrNull, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter($this$fastMaxOfOrNull, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if ($this$fastMaxOfOrNull.isEmpty()) {
            return null;
        }
        Comparable maxValue = (Comparable) selector.invoke($this$fastMaxOfOrNull.get(0));
        int i = 1;
        int lastIndex = CollectionsKt.getLastIndex($this$fastMaxOfOrNull);
        if (1 <= lastIndex) {
            while (true) {
                Comparable v = (Comparable) selector.invoke($this$fastMaxOfOrNull.get(i));
                if (v.compareTo(maxValue) > 0) {
                    maxValue = v;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return maxValue;
    }
}
