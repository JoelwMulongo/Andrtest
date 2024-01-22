package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002\u001a=\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"calculateNearestItemsRange", "Lkotlin/ranges/IntRange;", "firstVisibleItem", "", "slidingWindowSize", "extraItemCount", "rememberLazyNearestItemsRangeState", "Landroidx/compose/runtime/State;", "firstVisibleItemIndex", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyNearestItemsRange.kt */
public final class LazyNearestItemsRangeKt {
    public static final State<IntRange> rememberLazyNearestItemsRangeState(Function0<Integer> firstVisibleItemIndex, Function0<Integer> slidingWindowSize, Function0<Integer> extraItemCount, Composer $composer, int $changed) {
        Object value$iv$iv;
        Snapshot previous$iv$iv;
        Snapshot this_$iv$iv;
        Function0<Integer> function0 = firstVisibleItemIndex;
        Function0<Integer> function02 = slidingWindowSize;
        Function0<Integer> function03 = extraItemCount;
        Composer composer = $composer;
        int i = $changed;
        Intrinsics.checkNotNullParameter(function0, "firstVisibleItemIndex");
        Intrinsics.checkNotNullParameter(function02, "slidingWindowSize");
        Intrinsics.checkNotNullParameter(function03, "extraItemCount");
        composer.startReplaceableGroup(429733345);
        ComposerKt.sourceInformation(composer, "C(rememberLazyNearestItemsRangeState)P(1,2)46@1947L353,58@2328L254,58@2306L276:LazyNearestItemsRange.kt#wow0x6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(429733345, i, -1, "androidx.compose.foundation.lazy.layout.rememberLazyNearestItemsRangeState (LazyNearestItemsRange.kt:41)");
        }
        int $changed$iv = (i & 14) | (i & 112) | (i & 896);
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        boolean invalid$iv$iv = composer.changed((Object) function0) | composer.changed((Object) function02) | composer.changed((Object) function03);
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            Snapshot snapshot$iv = Snapshot.Companion.createNonObservableSnapshot();
            Snapshot this_$iv$iv2 = snapshot$iv;
            try {
                Snapshot previous$iv$iv2 = this_$iv$iv2.makeCurrent();
                try {
                    int i2 = $changed$iv;
                    try {
                        try {
                            value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(calculateNearestItemsRange(firstVisibleItemIndex.invoke().intValue(), slidingWindowSize.invoke().intValue(), extraItemCount.invoke().intValue()), (SnapshotMutationPolicy) null, 2, (Object) null);
                            try {
                                this_$iv$iv2.restoreCurrent(previous$iv$iv2);
                                snapshot$iv.dispose();
                                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                            } catch (Throwable th) {
                                th = th;
                                snapshot$iv.dispose();
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            this_$iv$iv = this_$iv$iv2;
                            previous$iv$iv = previous$iv$iv2;
                            this_$iv$iv.restoreCurrent(previous$iv$iv);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        this_$iv$iv = this_$iv$iv2;
                        previous$iv$iv = previous$iv$iv2;
                        this_$iv$iv.restoreCurrent(previous$iv$iv);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    int i3 = $changed$iv;
                    this_$iv$iv = this_$iv$iv2;
                    previous$iv$iv = previous$iv$iv2;
                    this_$iv$iv.restoreCurrent(previous$iv$iv);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                int i4 = $changed$iv;
                snapshot$iv.dispose();
                throw th;
            }
        } else {
            int i5 = $changed$iv;
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MutableState state = (MutableState) value$iv$iv;
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : new Object[]{function0, function02, function03, state}) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv2 = $composer;
        Object value$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv || value$iv$iv2 == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv2;
            value$iv$iv2 = new LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1(firstVisibleItemIndex, slidingWindowSize, extraItemCount, state, (Continuation<? super LazyNearestItemsRangeKt$rememberLazyNearestItemsRangeState$1$1>) null);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            Object obj2 = value$iv$iv2;
            Composer composer2 = $this$cache$iv$iv2;
        }
        $composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect((Object) state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv2, composer, 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return state;
    }

    /* access modifiers changed from: private */
    public static final IntRange calculateNearestItemsRange(int firstVisibleItem, int slidingWindowSize, int extraItemCount) {
        int slidingWindowStart = (firstVisibleItem / slidingWindowSize) * slidingWindowSize;
        return RangesKt.until(Math.max(slidingWindowStart - extraItemCount, 0), slidingWindowStart + slidingWindowSize + extraItemCount);
    }
}
