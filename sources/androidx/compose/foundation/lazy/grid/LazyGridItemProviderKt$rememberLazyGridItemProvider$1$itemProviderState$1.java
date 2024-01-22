package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridItemProvider.kt */
final class LazyGridItemProviderKt$rememberLazyGridItemProvider$1$itemProviderState$1 extends Lambda implements Function0<LazyGridItemProviderImpl> {
    final /* synthetic */ State<Function1<LazyGridScope, Unit>> $latestContent;
    final /* synthetic */ State<IntRange> $nearestItemsRangeState;
    final /* synthetic */ LazyGridState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridItemProviderKt$rememberLazyGridItemProvider$1$itemProviderState$1(State<? extends Function1<? super LazyGridScope, Unit>> state, LazyGridState lazyGridState, State<IntRange> state2) {
        super(0);
        this.$latestContent = state;
        this.$state = lazyGridState;
        this.$nearestItemsRangeState = state2;
    }

    public final LazyGridItemProviderImpl invoke() {
        LazyGridScopeImpl gridScope = new LazyGridScopeImpl();
        this.$latestContent.getValue().invoke(gridScope);
        return new LazyGridItemProviderImpl(gridScope.getIntervals$foundation_release(), gridScope.getHasCustomSpans$foundation_release(), this.$state, this.$nearestItemsRangeState.getValue());
    }
}
