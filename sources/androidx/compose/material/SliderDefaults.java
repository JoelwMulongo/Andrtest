package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jy\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/compose/material/SliderDefaults;", "", "()V", "DisabledActiveTrackAlpha", "", "DisabledInactiveTrackAlpha", "DisabledTickAlpha", "InactiveTrackAlpha", "TickAlpha", "colors", "Landroidx/compose/material/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "disabledThumbColor", "activeTrackColor", "inactiveTrackColor", "disabledActiveTrackColor", "disabledInactiveTrackColor", "activeTickColor", "inactiveTickColor", "disabledActiveTickColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material/SliderColors;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final float DisabledActiveTrackAlpha = 0.32f;
    public static final float DisabledInactiveTrackAlpha = 0.12f;
    public static final float DisabledTickAlpha = 0.12f;
    public static final SliderDefaults INSTANCE = new SliderDefaults();
    public static final float InactiveTrackAlpha = 0.24f;
    public static final float TickAlpha = 0.54f;

    private SliderDefaults() {
    }

    /* renamed from: colors-q0g_0yA  reason: not valid java name */
    public final SliderColors m1593colorsq0g_0yA(long thumbColor, long disabledThumbColor, long activeTrackColor, long inactiveTrackColor, long disabledActiveTrackColor, long disabledInactiveTrackColor, long activeTickColor, long inactiveTickColor, long disabledActiveTickColor, long disabledInactiveTickColor, Composer $composer, int $changed, int $changed1, int i) {
        long disabledThumbColor2;
        long activeTrackColor2;
        long inactiveTrackColor2;
        long disabledActiveTrackColor2;
        long disabledInactiveTrackColor2;
        long activeTickColor2;
        long inactiveTickColor2;
        long disabledActiveTickColor2;
        long disabledInactiveTickColor2;
        Composer composer = $composer;
        int i2 = $changed;
        int i3 = i;
        composer.startReplaceableGroup(436017687);
        ComposerKt.sourceInformation(composer, "C(colors)P(9:c#ui.graphics.Color,6:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,7:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color)479@20694L6,480@20760L6,481@20816L8,482@20867L6,483@20932L6,486@21103L6,489@21316L33:Slider.kt#jmzs0o");
        long thumbColor2 = (i3 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1445getPrimary0d7_KjU() : thumbColor;
        if ((i3 & 2) != 0) {
            disabledThumbColor2 = ColorKt.m3209compositeOverOWjLjI(Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).m1449getSurface0d7_KjU());
        } else {
            disabledThumbColor2 = disabledThumbColor;
        }
        if ((i3 & 4) != 0) {
            activeTrackColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1445getPrimary0d7_KjU();
        } else {
            activeTrackColor2 = activeTrackColor;
        }
        if ((i3 & 8) != 0) {
            inactiveTrackColor2 = Color.m3163copywmQWz5c$default(activeTrackColor2, 0.24f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            inactiveTrackColor2 = inactiveTrackColor;
        }
        if ((i3 & 16) != 0) {
            disabledActiveTrackColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), 0.32f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledActiveTrackColor2 = disabledActiveTrackColor;
        }
        if ((i3 & 32) != 0) {
            disabledInactiveTrackColor2 = Color.m3163copywmQWz5c$default(disabledActiveTrackColor2, 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledInactiveTrackColor2 = disabledInactiveTrackColor;
        }
        if ((i3 & 64) != 0) {
            activeTickColor2 = Color.m3163copywmQWz5c$default(ColorsKt.m1463contentColorForek8zF_U(activeTrackColor2, composer, (i2 >> 6) & 14), 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            activeTickColor2 = activeTickColor;
        }
        if ((i3 & 128) != 0) {
            inactiveTickColor2 = Color.m3163copywmQWz5c$default(activeTrackColor2, 0.54f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            inactiveTickColor2 = inactiveTickColor;
        }
        if ((i3 & 256) != 0) {
            disabledActiveTickColor2 = Color.m3163copywmQWz5c$default(activeTickColor2, 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledActiveTickColor2 = disabledActiveTickColor;
        }
        if ((i3 & 512) != 0) {
            disabledInactiveTickColor2 = Color.m3163copywmQWz5c$default(disabledInactiveTrackColor2, 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledInactiveTickColor2 = disabledInactiveTickColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(436017687, i2, $changed1, "androidx.compose.material.SliderDefaults.colors (Slider.kt:478)");
        } else {
            int i4 = $changed1;
        }
        DefaultSliderColors defaultSliderColors = new DefaultSliderColors(thumbColor2, disabledThumbColor2, activeTrackColor2, inactiveTrackColor2, disabledActiveTrackColor2, disabledInactiveTrackColor2, activeTickColor2, inactiveTickColor2, disabledActiveTickColor2, disabledInactiveTickColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultSliderColors;
    }
}
