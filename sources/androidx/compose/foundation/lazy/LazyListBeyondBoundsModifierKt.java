package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"lazyListBeyondBoundsModifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListBeyondBoundsModifier.kt */
public final class LazyListBeyondBoundsModifierKt {
    public static final Modifier lazyListBeyondBoundsModifier(Modifier $this$lazyListBeyondBoundsModifier, LazyListState state, LazyListBeyondBoundsInfo beyondBoundsInfo, boolean reverseLayout, Orientation orientation, Composer $composer, int $changed) {
        LazyListBeyondBoundsState lazyListBeyondBoundsState;
        Modifier modifier = $this$lazyListBeyondBoundsModifier;
        LazyListState lazyListState = state;
        LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo = beyondBoundsInfo;
        Orientation orientation2 = orientation;
        Composer composer = $composer;
        int i = $changed;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(lazyListState, "state");
        Intrinsics.checkNotNullParameter(lazyListBeyondBoundsInfo, "beyondBoundsInfo");
        Intrinsics.checkNotNullParameter(orientation2, "orientation");
        composer.startReplaceableGroup(-62057177);
        ComposerKt.sourceInformation(composer, "C(lazyListBeyondBoundsModifier)P(3!1,2)38@1490L7,39@1526L52,40@1600L340:LazyListBeyondBoundsModifier.kt#428nma");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-62057177, i, -1, "androidx.compose.foundation.lazy.lazyListBeyondBoundsModifier (LazyListBeyondBoundsModifier.kt:32)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd($composer);
        LayoutDirection layoutDirection = (LayoutDirection) consume;
        int $changed$iv = (i >> 3) & 14;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) lazyListState);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            int i2 = $changed$iv;
            lazyListBeyondBoundsState = new LazyListBeyondBoundsState(lazyListState);
            $this$cache$iv$iv.updateRememberedValue(lazyListBeyondBoundsState);
        } else {
            int i3 = $changed$iv;
            lazyListBeyondBoundsState = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        LazyListBeyondBoundsState beyondBoundsState = lazyListBeyondBoundsState;
        Object[] keys$iv = {beyondBoundsState, lazyListBeyondBoundsInfo, Boolean.valueOf(reverseLayout), layoutDirection, orientation2};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv2 = $composer;
        Object value$iv$iv = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv;
            value$iv$iv = new LazyLayoutBeyondBoundsModifierLocal(beyondBoundsState, beyondBoundsInfo, reverseLayout, layoutDirection, orientation);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
        } else {
            Object obj2 = value$iv$iv;
            Composer composer2 = $this$cache$iv$iv2;
        }
        $composer.endReplaceableGroup();
        Modifier then = modifier.then((Modifier) value$iv$iv);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return then;
    }
}
