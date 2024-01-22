package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Landroidx/compose/material/RadioButtonDefaults;", "", "()V", "colors", "Landroidx/compose/material/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledColor", "colors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/RadioButtonColors;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RadioButton.kt */
public final class RadioButtonDefaults {
    public static final int $stable = 0;
    public static final RadioButtonDefaults INSTANCE = new RadioButtonDefaults();

    private RadioButtonDefaults() {
    }

    /* renamed from: colors-RGew2ao  reason: not valid java name */
    public final RadioButtonColors m1588colorsRGew2ao(long selectedColor, long unselectedColor, long disabledColor, Composer $composer, int $changed, int i) {
        long unselectedColor2;
        long disabledColor2;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(1370708026);
        ComposerKt.sourceInformation(composer, "C(colors)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color,0:c#ui.graphics.Color)163@6598L6,164@6663L6,165@6745L6,165@6788L8,167@6840L197:RadioButton.kt#jmzs0o");
        long selectedColor2 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1447getSecondary0d7_KjU() : selectedColor;
        if ((i & 2) != 0) {
            unselectedColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            unselectedColor2 = unselectedColor;
        }
        if ((i & 4) != 0) {
            disabledColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledColor2 = disabledColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1370708026, i2, -1, "androidx.compose.material.RadioButtonDefaults.colors (RadioButton.kt:162)");
        }
        Object key1$iv = Color.m3154boximpl(selectedColor2);
        int i3 = (i2 & 14) | (i2 & 112) | (i2 & 896);
        Color r14 = Color.m3154boximpl(unselectedColor2);
        Color r12 = Color.m3154boximpl(disabledColor2);
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        boolean invalid$iv$iv = composer.changed(key1$iv) | composer.changed((Object) r14) | composer.changed((Object) r12);
        Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || value$iv$iv == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv;
            Color color = r12;
            Color color2 = r14;
            value$iv$iv = new DefaultRadioButtonColors(selectedColor2, unselectedColor2, disabledColor2, (DefaultConstructorMarker) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            Object obj2 = value$iv$iv;
            Color color3 = r12;
            Composer composer2 = $this$cache$iv$iv;
            Color color4 = r14;
        }
        $composer.endReplaceableGroup();
        DefaultRadioButtonColors defaultRadioButtonColors = (DefaultRadioButtonColors) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultRadioButtonColors;
    }
}
