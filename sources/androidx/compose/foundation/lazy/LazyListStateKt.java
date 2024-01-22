package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"rememberLazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemScrollOffset", "(IILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/LazyListState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListState.kt */
public final class LazyListStateKt {
    public static final LazyListState rememberLazyListState(int initialFirstVisibleItemIndex, int initialFirstVisibleItemScrollOffset, Composer $composer, int $changed, int i) {
        int initialFirstVisibleItemScrollOffset2;
        Object value$iv$iv;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(1470655220);
        ComposerKt.sourceInformation(composer, "C(rememberLazyListState)63@2788L130,63@2742L176:LazyListState.kt#428nma");
        int initialFirstVisibleItemIndex2 = (i & 1) != 0 ? 0 : initialFirstVisibleItemIndex;
        if ((i & 2) != 0) {
            initialFirstVisibleItemScrollOffset2 = 0;
        } else {
            initialFirstVisibleItemScrollOffset2 = initialFirstVisibleItemScrollOffset;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1470655220, i2, -1, "androidx.compose.foundation.lazy.rememberLazyListState (LazyListState.kt:59)");
        }
        Object[] objArr = new Object[0];
        Saver saver = LazyListState.Companion.getSaver();
        Object key1$iv = Integer.valueOf(initialFirstVisibleItemIndex2);
        Object key2$iv = Integer.valueOf(initialFirstVisibleItemScrollOffset2);
        int i3 = (i2 & 14) | (i2 & 112);
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed(key1$iv) | composer.changed(key2$iv);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function0) new LazyListStateKt$rememberLazyListState$1$1(initialFirstVisibleItemIndex2, initialFirstVisibleItemScrollOffset2);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        LazyListState lazyListState = (LazyListState) RememberSaveableKt.rememberSaveable(objArr, saver, (String) null, value$iv$iv, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return lazyListState;
    }
}
