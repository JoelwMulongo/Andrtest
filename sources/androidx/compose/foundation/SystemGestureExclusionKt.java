package androidx.compose.foundation;

import android.os.Build;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u00012\u0016\b\b\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H\b¢\u0006\u0002\u0010\u0006\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0001\u001a\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¨\u0006\b"}, d2 = {"excludeFromSystemGestureQ", "Landroidx/compose/ui/Modifier;", "exclusion", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Rect;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "systemGestureExclusion", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SystemGestureExclusion.kt */
public final class SystemGestureExclusionKt {
    public static final Modifier systemGestureExclusion(Modifier $this$systemGestureExclusion) {
        Intrinsics.checkNotNullParameter($this$systemGestureExclusion, "<this>");
        if (Build.VERSION.SDK_INT < 29) {
            return $this$systemGestureExclusion;
        }
        return ComposedModifierKt.composed($this$systemGestureExclusion, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SystemGestureExclusionKt$systemGestureExclusion$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), SystemGestureExclusionKt$systemGestureExclusion$2.INSTANCE);
    }

    public static final Modifier systemGestureExclusion(Modifier $this$systemGestureExclusion, Function1<? super LayoutCoordinates, Rect> exclusion) {
        Intrinsics.checkNotNullParameter($this$systemGestureExclusion, "<this>");
        Intrinsics.checkNotNullParameter(exclusion, "exclusion");
        if (Build.VERSION.SDK_INT < 29) {
            return $this$systemGestureExclusion;
        }
        return ComposedModifierKt.composed($this$systemGestureExclusion, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SystemGestureExclusionKt$systemGestureExclusion$$inlined$debugInspectorInfo$2(exclusion) : InspectableValueKt.getNoInspectorInfo(), new SystemGestureExclusionKt$systemGestureExclusion$4(exclusion));
    }

    private static final Modifier excludeFromSystemGestureQ(Function1<? super LayoutCoordinates, Rect> exclusion, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(1687674107);
        ComposerKt.sourceInformation($composer, "CC(excludeFromSystemGestureQ)79@2790L7,80@2817L79,81@2901L98:SystemGestureExclusion.kt#71ulvw");
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        ComposerKt.sourceInformationMarkerEnd($composer);
        View view = (View) consume;
        int i = (($changed << 3) & 112) | 8;
        $composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) view) | $composer.changed((Object) exclusion);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = new ExcludeFromSystemGestureModifier(view, exclusion);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        ExcludeFromSystemGestureModifier modifier = (ExcludeFromSystemGestureModifier) value$iv$iv;
        EffectsKt.DisposableEffect((Object) modifier, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new SystemGestureExclusionKt$excludeFromSystemGestureQ$1(modifier), $composer, 0);
        $composer.endReplaceableGroup();
        return modifier;
    }
}
