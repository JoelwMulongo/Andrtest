package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B^\u0012A\u0010\u0004\u001a=\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0002\b\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0015\u0010 \u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0002\u0010!J*\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\n0\u001c2\u0006\u0010#\u001a\u00020\u00112\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0003J\u0012\u0010%\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\nH\u0016JT\u0010'\u001a\u0002H(\"\u0004\b\u0001\u0010(2\u0006\u0010\u000b\u001a\u00020\n26\u0010)\u001a2\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(*\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(+\u0012\u0004\u0012\u0002H(0\u0005H\b¢\u0006\u0002\u0010,R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014RN\u0010\u0004\u001a=\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\u0002\b\r¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\n0\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Landroidx/compose/foundation/lazy/layout/DefaultLazyLayoutItemsProvider;", "IntervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "itemContentProvider", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/IntervalList$Interval;", "Lkotlin/ParameterName;", "name", "interval", "", "index", "", "Landroidx/compose/runtime/Composable;", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "nearestItemsRange", "Lkotlin/ranges/IntRange;", "(Lkotlin/jvm/functions/Function4;Landroidx/compose/foundation/lazy/layout/IntervalList;Lkotlin/ranges/IntRange;)V", "getIntervals", "()Landroidx/compose/foundation/lazy/layout/IntervalList;", "getItemContentProvider", "()Lkotlin/jvm/functions/Function4;", "Lkotlin/jvm/functions/Function4;", "itemCount", "getItemCount", "()I", "keyToIndexMap", "", "", "getKeyToIndexMap", "()Ljava/util/Map;", "Item", "(ILandroidx/compose/runtime/Composer;I)V", "generateKeyToIndexMap", "range", "list", "getContentType", "getKey", "withLocalIntervalIndex", "T", "block", "localIndex", "content", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutItemProvider.kt */
final class DefaultLazyLayoutItemsProvider<IntervalContent extends LazyLayoutIntervalContent> implements LazyLayoutItemProvider {
    private final IntervalList<IntervalContent> intervals;
    private final Function4<IntervalList.Interval<? extends IntervalContent>, Integer, Composer, Integer, Unit> itemContentProvider;
    private final Map<Object, Integer> keyToIndexMap;

    public DefaultLazyLayoutItemsProvider(Function4<? super IntervalList.Interval<? extends IntervalContent>, ? super Integer, ? super Composer, ? super Integer, Unit> itemContentProvider2, IntervalList<? extends IntervalContent> intervals2, IntRange nearestItemsRange) {
        Intrinsics.checkNotNullParameter(itemContentProvider2, "itemContentProvider");
        Intrinsics.checkNotNullParameter(intervals2, "intervals");
        Intrinsics.checkNotNullParameter(nearestItemsRange, "nearestItemsRange");
        this.itemContentProvider = itemContentProvider2;
        this.intervals = intervals2;
        this.keyToIndexMap = generateKeyToIndexMap(nearestItemsRange, intervals2);
    }

    public final Function4<IntervalList.Interval<? extends IntervalContent>, Integer, Composer, Integer, Unit> getItemContentProvider() {
        return this.itemContentProvider;
    }

    public final IntervalList<IntervalContent> getIntervals() {
        return this.intervals;
    }

    public int getItemCount() {
        return this.intervals.getSize();
    }

    public Map<Object, Integer> getKeyToIndexMap() {
        return this.keyToIndexMap;
    }

    public void Item(int index, Composer $composer, int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1877726744);
        ComposerKt.sourceInformation($composer2, "C(Item)117@4181L44:LazyLayoutItemProvider.kt#wow0x6");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(index) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed((Object) this) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1877726744, $dirty, -1, "androidx.compose.foundation.lazy.layout.DefaultLazyLayoutItemsProvider.Item (LazyLayoutItemProvider.kt:116)");
            }
            this.itemContentProvider.invoke(this.intervals.get(index), Integer.valueOf(index), $composer2, Integer.valueOf(($dirty << 3) & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DefaultLazyLayoutItemsProvider$Item$1(this, index, $changed));
        }
    }

    public Object getKey(int index) {
        Object invoke;
        IntervalList.Interval interval$iv = this.intervals.get(index);
        int localIndex = index - interval$iv.getStartIndex();
        Function1<Integer, Object> key = ((LazyLayoutIntervalContent) interval$iv.getValue()).getKey();
        if (key == null || (invoke = key.invoke(Integer.valueOf(localIndex))) == null) {
            return Lazy_androidKt.getDefaultLazyLayoutKey(index);
        }
        return invoke;
    }

    public Object getContentType(int index) {
        IntervalList.Interval interval$iv = this.intervals.get(index);
        return ((LazyLayoutIntervalContent) interval$iv.getValue()).getType().invoke(Integer.valueOf(index - interval$iv.getStartIndex()));
    }

    private final <T> T withLocalIntervalIndex(int index, Function2<? super Integer, ? super IntervalContent, ? extends T> block) {
        IntervalList.Interval interval = this.intervals.get(index);
        return block.invoke(Integer.valueOf(index - interval.getStartIndex()), interval.getValue());
    }

    private final Map<Object, Integer> generateKeyToIndexMap(IntRange range, IntervalList<? extends LazyLayoutIntervalContent> list) {
        int first = range.getFirst();
        if (first >= 0) {
            int last = Math.min(range.getLast(), list.getSize() - 1);
            if (last < first) {
                return MapsKt.emptyMap();
            }
            HashMap map = new HashMap();
            list.forEach(first, last, new DefaultLazyLayoutItemsProvider$generateKeyToIndexMap$1$1(first, last, map));
            return map;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
