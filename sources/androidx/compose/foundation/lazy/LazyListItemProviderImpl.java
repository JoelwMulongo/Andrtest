package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B9\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001e\u001a\u00020\nH\u0001J\u0011\u0010!\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\nH\u0001R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\nX\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\n0\u00188VX\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemProviderImpl;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "intervals", "Landroidx/compose/foundation/lazy/layout/IntervalList;", "Landroidx/compose/foundation/lazy/LazyListIntervalContent;", "nearestItemsRange", "Lkotlin/ranges/IntRange;", "headerIndexes", "", "", "itemScope", "Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/layout/IntervalList;Lkotlin/ranges/IntRange;Ljava/util/List;Landroidx/compose/foundation/lazy/LazyItemScopeImpl;Landroidx/compose/foundation/lazy/LazyListState;)V", "getHeaderIndexes", "()Ljava/util/List;", "itemCount", "getItemCount", "()I", "getItemScope", "()Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "keyToIndexMap", "", "", "getKeyToIndexMap", "()Ljava/util/Map;", "Item", "", "index", "(ILandroidx/compose/runtime/Composer;I)V", "getContentType", "getKey", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListItemProvider.kt */
final class LazyListItemProviderImpl implements LazyListItemProvider, LazyLayoutItemProvider {
    private final /* synthetic */ LazyLayoutItemProvider $$delegate_0;
    private final List<Integer> headerIndexes;
    private final LazyItemScopeImpl itemScope;

    public void Item(int i, Composer composer, int i2) {
        Composer startRestartGroup = composer.startRestartGroup(-1645068522);
        ComposerKt.sourceInformation(startRestartGroup, "C(Item)-1@-2:LazyListItemProvider.kt#428nma");
        int i3 = i2;
        if ((i2 & 14) == 0) {
            i3 |= startRestartGroup.changed(i) ? 4 : 2;
        }
        if ((i2 & 112) == 0) {
            i3 |= startRestartGroup.changed((Object) this) ? 32 : 16;
        }
        if ((i3 & 91) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1645068522, i3, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item (LazyListItemProvider.kt:-1)");
            }
            this.$$delegate_0.Item(i, startRestartGroup, i3 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyListItemProviderImpl$Item$1(this, i, i2));
        }
    }

    public Object getContentType(int i) {
        return this.$$delegate_0.getContentType(i);
    }

    public int getItemCount() {
        return this.$$delegate_0.getItemCount();
    }

    public Object getKey(int i) {
        return this.$$delegate_0.getKey(i);
    }

    public Map<Object, Integer> getKeyToIndexMap() {
        return this.$$delegate_0.getKeyToIndexMap();
    }

    public LazyListItemProviderImpl(IntervalList<LazyListIntervalContent> intervals, IntRange nearestItemsRange, List<Integer> headerIndexes2, final LazyItemScopeImpl itemScope2, final LazyListState state) {
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        Intrinsics.checkNotNullParameter(nearestItemsRange, "nearestItemsRange");
        Intrinsics.checkNotNullParameter(headerIndexes2, "headerIndexes");
        Intrinsics.checkNotNullParameter(itemScope2, "itemScope");
        Intrinsics.checkNotNullParameter(state, "state");
        this.headerIndexes = headerIndexes2;
        this.itemScope = itemScope2;
        this.$$delegate_0 = LazyLayoutItemProviderKt.LazyLayoutItemProvider(intervals, nearestItemsRange, ComposableLambdaKt.composableLambdaInstance(2070454083, true, new Function4<IntervalList.Interval<? extends LazyListIntervalContent>, Integer, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((IntervalList.Interval<LazyListIntervalContent>) (IntervalList.Interval) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final IntervalList.Interval<LazyListIntervalContent> interval, int index, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(interval, "interval");
                ComposerKt.sourceInformation($composer, "CP(1)83@3369L263:LazyListItemProvider.kt#428nma");
                int $dirty = $changed;
                if (($changed & 14) == 0) {
                    $dirty |= $composer.changed((Object) interval) ? 4 : 2;
                }
                if (($changed & 112) == 0) {
                    $dirty |= $composer.changed(index) ? 32 : 16;
                }
                if (($dirty & 731) != 146 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2070454083, $dirty, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.$$delegate_0.<anonymous> (LazyListItemProvider.kt:81)");
                    }
                    final int localIndex = index - interval.getStartIndex();
                    Function1<Integer, Object> key = interval.getValue().getKey();
                    Object invoke = key != null ? key.invoke(Integer.valueOf(localIndex)) : null;
                    LazyLayoutPinnedItemList pinnedItems$foundation_release = state.getPinnedItems$foundation_release();
                    final LazyItemScopeImpl lazyItemScopeImpl = itemScope2;
                    LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(invoke, index, pinnedItems$foundation_release, ComposableLambdaKt.composableLambda($composer, 1210565839, true, new Function2<Composer, Integer, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                            invoke((Composer) p1, ((Number) p2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer, int $changed) {
                            ComposerKt.sourceInformation($composer, "C88@3589L29:LazyListItemProvider.kt#428nma");
                            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1210565839, $changed, -1, "androidx.compose.foundation.lazy.LazyListItemProviderImpl.$$delegate_0.<anonymous>.<anonymous> (LazyListItemProvider.kt:87)");
                                }
                                interval.getValue().getItem().invoke(lazyItemScopeImpl, Integer.valueOf(localIndex), $composer, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer.skipToGroupEnd();
                        }
                    }), $composer, ($dirty & 112) | 3592);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }));
    }

    public List<Integer> getHeaderIndexes() {
        return this.headerIndexes;
    }

    public LazyItemScopeImpl getItemScope() {
        return this.itemScope;
    }
}
