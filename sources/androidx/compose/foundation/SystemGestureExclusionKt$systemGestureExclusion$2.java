package androidx.compose.foundation;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SystemGestureExclusion.kt */
final class SystemGestureExclusionKt$systemGestureExclusion$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    public static final SystemGestureExclusionKt$systemGestureExclusion$2 INSTANCE = new SystemGestureExclusionKt$systemGestureExclusion$2();

    SystemGestureExclusionKt$systemGestureExclusion$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Object value$iv$iv$iv;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        composer.startReplaceableGroup(1120057036);
        ComposerKt.sourceInformation(composer, "C47@1700L31:SystemGestureExclusion.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1120057036, $changed, -1, "androidx.compose.foundation.systemGestureExclusion.<anonymous> (SystemGestureExclusion.kt:46)");
        } else {
            int i = $changed;
        }
        composer.startReplaceableGroup(1687674107);
        ComposerKt.sourceInformation(composer, "CC(excludeFromSystemGestureQ)79@2790L7,80@2817L79,81@2901L98:SystemGestureExclusion.kt#71ulvw");
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        ComposerKt.sourceInformationMarkerEnd($composer);
        View view$iv = (View) consume;
        int i2 = ((6 << 3) & 112) | 8;
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv$iv = composer.changed((Object) view$iv) | composer.changed((Object) null);
        Composer $this$cache$iv$iv$iv = $composer;
        Object it$iv$iv$iv = $this$cache$iv$iv$iv.rememberedValue();
        if (invalid$iv$iv$iv || it$iv$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv$iv = new ExcludeFromSystemGestureModifier(view$iv, (Function1<? super LayoutCoordinates, Rect>) null);
            $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
        } else {
            value$iv$iv$iv = it$iv$iv$iv;
        }
        $composer.endReplaceableGroup();
        ExcludeFromSystemGestureModifier modifier$iv = (ExcludeFromSystemGestureModifier) value$iv$iv$iv;
        EffectsKt.DisposableEffect((Object) modifier$iv, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new SystemGestureExclusionKt$excludeFromSystemGestureQ$1(modifier$iv), composer, 0);
        $composer.endReplaceableGroup();
        Modifier modifier = modifier$iv;
        if (ComposerKt.isTraceInProgress() != 0) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return modifier;
    }
}
