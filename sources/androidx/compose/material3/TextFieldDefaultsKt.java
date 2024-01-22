package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"animateBorderStrokeAsState", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material3/TextFieldColors;", "focusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "unfocusedBorderThickness", "animateBorderStrokeAsState-NuRrP5Q", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextFieldDefaults.kt */
public final class TextFieldDefaultsKt {
    /* access modifiers changed from: private */
    /* renamed from: animateBorderStrokeAsState-NuRrP5Q  reason: not valid java name */
    public static final State<BorderStroke> m2161animateBorderStrokeAsStateNuRrP5Q(boolean enabled, boolean isError, InteractionSource interactionSource, TextFieldColors colors, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, int $changed) {
        State animatedThickness;
        Composer composer = $composer;
        int i = $changed;
        composer.startReplaceableGroup(-1633063017);
        ComposerKt.sourceInformation(composer, "C(animateBorderStrokeAsState)P(1,4,3!1,2:c#ui.unit.Dp,5:c#ui.unit.Dp)951@49025L25,952@49083L51,959@49440L107:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1633063017, i, -1, "androidx.compose.material3.animateBorderStrokeAsState (TextFieldDefaults.kt:943)");
        }
        State focused$delegate = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14);
        State indicatorColor = colors.indicatorColor$material3_release(enabled, isError, interactionSource, $composer, (i & 14) | (i & 112) | (i & 896) | (i & 7168));
        float targetThickness = m2162animateBorderStrokeAsState_NuRrP5Q$lambda0(focused$delegate) ? focusedBorderThickness : unfocusedBorderThickness;
        if (enabled) {
            composer.startReplaceableGroup(-1927801001);
            ComposerKt.sourceInformation(composer, "955@49278L76");
            animatedThickness = AnimateAsStateKt.m379animateDpAsStateKz89ssw(targetThickness, AnimationSpecKt.tween$default(150, 0, (Easing) null, 6, (Object) null), (Function1) null, $composer, 48, 4);
            $composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1927800903);
            ComposerKt.sourceInformation(composer, "957@49376L46");
            animatedThickness = SnapshotStateKt.rememberUpdatedState(Dp.m5984boximpl(unfocusedBorderThickness), composer, (i >> 15) & 14);
            $composer.endReplaceableGroup();
        }
        State<BorderStroke> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(new BorderStroke(((Dp) animatedThickness.getValue()).m6000unboximpl(), new SolidColor(indicatorColor.getValue().m3174unboximpl(), (DefaultConstructorMarker) null), (DefaultConstructorMarker) null), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberUpdatedState;
    }

    /* renamed from: animateBorderStrokeAsState_NuRrP5Q$lambda-0  reason: not valid java name */
    private static final boolean m2162animateBorderStrokeAsState_NuRrP5Q$lambda0(State<Boolean> $focused$delegate) {
        return ((Boolean) $focused$delegate.getValue()).booleanValue();
    }
}
