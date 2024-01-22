package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tab.kt */
final class TabKt$TabTransition$color$2 extends Lambda implements Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Color>> {
    public static final TabKt$TabTransition$color$2 INSTANCE = new TabKt$TabTransition$color$2();

    TabKt$TabTransition$color$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Transition.Segment<Boolean>) (Transition.Segment) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final FiniteAnimationSpec<Color> invoke(Transition.Segment<Boolean> $this$animateColor, Composer $composer, int $changed) {
        FiniteAnimationSpec<Color> finiteAnimationSpec;
        Intrinsics.checkNotNullParameter($this$animateColor, "$this$animateColor");
        $composer.startReplaceableGroup(-2120892502);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2120892502, $changed, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:270)");
        }
        if ($this$animateColor.isTransitioningTo(false, true)) {
            finiteAnimationSpec = AnimationSpecKt.tween(150, 100, EasingKt.getLinearEasing());
        } else {
            finiteAnimationSpec = AnimationSpecKt.tween$default(100, 0, EasingKt.getLinearEasing(), 2, (Object) null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return finiteAnimationSpec;
    }
}
