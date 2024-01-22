package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridItemProvider.kt */
final class LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$itemProviderState$1 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ State<Function1<LazyStaggeredGridScope, Unit>> $latestContent;
    final /* synthetic */ State<IntRange> $nearestItemsRangeState;
    final /* synthetic */ LazyStaggeredGridState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProvider$1$itemProviderState$1(State<? extends Function1<? super LazyStaggeredGridScope, Unit>> state, State<IntRange> state2, LazyStaggeredGridState lazyStaggeredGridState) {
        super(0);
        this.$latestContent = state;
        this.$nearestItemsRangeState = state2;
        this.$state = lazyStaggeredGridState;
    }

    public final AnonymousClass1 invoke() {
        LazyStaggeredGridScopeImpl scope = new LazyStaggeredGridScopeImpl();
        this.$latestContent.getValue().invoke(scope);
        return new Object(scope, this.$nearestItemsRangeState, this.$state) {
            private final /* synthetic */ LazyLayoutItemProvider $$delegate_0;
            private final LazyStaggeredGridSpanProvider spanProvider;

            public void Item(int i, Composer composer, int i2) {
                composer.startReplaceableGroup(1163616889);
                ComposerKt.sourceInformation(composer, "C(Item)-1@-2:LazyStaggeredGridItemProvider.kt#fzvcnm");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1163616889, i2, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridItemProvider.<anonymous>.<anonymous>.<no name provided>.Item (LazyStaggeredGridItemProvider.kt:-1)");
                }
                this.$$delegate_0.Item(i, composer, i2 & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
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

            {
                this.$$delegate_0 = LazyLayoutItemProviderKt.LazyLayoutItemProvider($scope.getIntervals(), $nearestItemsRangeState.getValue(), ComposableLambdaKt.composableLambdaInstance(-364721306, true, new Function4<IntervalList.Interval<? extends LazyStaggeredGridIntervalContent>, Integer, Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                        invoke((IntervalList.Interval<LazyStaggeredGridIntervalContent>) (IntervalList.Interval) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final IntervalList.Interval<LazyStaggeredGridIntervalContent> interval, int index, Composer $composer, int $changed) {
                        Intrinsics.checkNotNullParameter(interval, "interval");
                        ComposerKt.sourceInformation($composer, "CP(1)53@2305L332:LazyStaggeredGridItemProvider.kt#fzvcnm");
                        int $dirty = $changed;
                        if (($changed & 14) == 0) {
                            $dirty |= $composer.changed((Object) interval) ? 4 : 2;
                        }
                        if (($changed & 112) == 0) {
                            $dirty |= $composer.changed(index) ? 32 : 16;
                        }
                        if (($dirty & 731) != 146 || !$composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-364721306, $dirty, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridItemProvider.<anonymous>.<anonymous>.<no name provided>.$$delegate_0.<anonymous> (LazyStaggeredGridItemProvider.kt:51)");
                            }
                            final int localIndex = index - interval.getStartIndex();
                            Function1<Integer, Object> key = interval.getValue().getKey();
                            LazyLayoutPinnableItemKt.LazyLayoutPinnableItem(key != null ? key.invoke(Integer.valueOf(localIndex)) : null, index, $state.getPinnedItems$foundation_release(), ComposableLambdaKt.composableLambda($composer, 1181040114, true, new Function2<Composer, Integer, Unit>() {
                                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                    invoke((Composer) p1, ((Number) p2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer $composer, int $changed) {
                                    ComposerKt.sourceInformation($composer, "C58@2565L50:LazyStaggeredGridItemProvider.kt#fzvcnm");
                                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1181040114, $changed, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridItemProvider.<anonymous>.<anonymous>.<no name provided>.$$delegate_0.<anonymous>.<anonymous> (LazyStaggeredGridItemProvider.kt:57)");
                                        }
                                        interval.getValue().getItem().invoke(LazyStaggeredGridItemScopeImpl.INSTANCE, Integer.valueOf(localIndex), $composer, 6);
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
                this.spanProvider = new LazyStaggeredGridSpanProvider($scope.getIntervals());
            }

            public LazyStaggeredGridSpanProvider getSpanProvider() {
                return this.spanProvider;
            }
        };
    }
}
