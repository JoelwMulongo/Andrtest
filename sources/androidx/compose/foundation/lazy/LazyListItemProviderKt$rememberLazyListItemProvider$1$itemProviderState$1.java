package androidx.compose.foundation.lazy;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListItemProvider.kt */
final class LazyListItemProviderKt$rememberLazyListItemProvider$1$itemProviderState$1 extends Lambda implements Function0<LazyListItemProviderImpl> {
    final /* synthetic */ LazyItemScopeImpl $itemScope;
    final /* synthetic */ State<Function1<LazyListScope, Unit>> $latestContent;
    final /* synthetic */ State<IntRange> $nearestItemsRangeState;
    final /* synthetic */ LazyListState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListItemProviderKt$rememberLazyListItemProvider$1$itemProviderState$1(State<? extends Function1<? super LazyListScope, Unit>> state, State<IntRange> state2, LazyItemScopeImpl lazyItemScopeImpl, LazyListState lazyListState) {
        super(0);
        this.$latestContent = state;
        this.$nearestItemsRangeState = state2;
        this.$itemScope = lazyItemScopeImpl;
        this.$state = lazyListState;
    }

    public final LazyListItemProviderImpl invoke() {
        LazyListScopeImpl listScope = new LazyListScopeImpl();
        this.$latestContent.getValue().invoke(listScope);
        return new LazyListItemProviderImpl(listScope.getIntervals(), this.$nearestItemsRangeState.getValue(), listScope.getHeaderIndexes(), this.$itemScope, this.$state);
    }
}
