package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyNearestItemsRangeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0001¢\u0006\u0002\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"NearestItemsExtraItemCount", "", "NearestItemsSlidingWindowSize", "rememberLazyListItemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/LazyListItemProvider;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListItemProvider.kt */
public final class LazyListItemProviderKt {
    private static final int NearestItemsExtraItemCount = 100;
    private static final int NearestItemsSlidingWindowSize = 30;

    public static final LazyListItemProvider rememberLazyListItemProvider(LazyListState state, Function1<? super LazyListScope, Unit> content, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        LazyListState lazyListState = state;
        Function1<? super LazyListScope, Unit> function1 = content;
        Composer composer = $composer;
        int i = $changed;
        Intrinsics.checkNotNullParameter(lazyListState, "state");
        Intrinsics.checkNotNullParameter(function1, "content");
        composer.startReplaceableGroup(1939491467);
        ComposerKt.sourceInformation(composer, "C(rememberLazyListItemProvider)P(1)43@1742L29,45@1873L31,44@1805L225,50@2043L783:LazyListItemProvider.kt#428nma");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1939491467, i, -1, "androidx.compose.foundation.lazy.rememberLazyListItemProvider (LazyListItemProvider.kt:39)");
        }
        State latestContent = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 3) & 14);
        int i2 = i & 14;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) lazyListState);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function0) new LazyListItemProviderKt$rememberLazyListItemProvider$nearestItemsRangeState$1$1(lazyListState);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        State nearestItemsRangeState = LazyNearestItemsRangeKt.rememberLazyNearestItemsRangeState((Function0) value$iv$iv, LazyListItemProviderKt$rememberLazyListItemProvider$nearestItemsRangeState$2.INSTANCE, LazyListItemProviderKt$rememberLazyListItemProvider$nearestItemsRangeState$3.INSTANCE, composer, 432);
        int i3 = (i << 3) & 112;
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = composer.changed((Object) nearestItemsRangeState) | composer.changed((Object) lazyListState);
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv2 = new LazyListItemProviderKt$rememberLazyListItemProvider$1$1(SnapshotStateKt.derivedStateOf(new LazyListItemProviderKt$rememberLazyListItemProvider$1$itemProviderState$1(latestContent, nearestItemsRangeState, new LazyItemScopeImpl(), lazyListState)));
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        LazyListItemProviderKt$rememberLazyListItemProvider$1$1 lazyListItemProviderKt$rememberLazyListItemProvider$1$1 = (LazyListItemProviderKt$rememberLazyListItemProvider$1$1) value$iv$iv2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return lazyListItemProviderKt$rememberLazyListItemProvider$1$1;
    }
}
