package androidx.compose.material3;

import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Landroidx/compose/material3/RadioButtonDefaults;", "", "()V", "colors", "Landroidx/compose/material3/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledSelectedColor", "disabledUnselectedColor", "colors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RadioButtonColors;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RadioButton.kt */
public final class RadioButtonDefaults {
    public static final int $stable = 0;
    public static final RadioButtonDefaults INSTANCE = new RadioButtonDefaults();

    private RadioButtonDefaults() {
    }

    /* renamed from: colors-ro_MJ88  reason: not valid java name */
    public final RadioButtonColors m2049colorsro_MJ88(long selectedColor, long unselectedColor, long disabledSelectedColor, long disabledUnselectedColor, Composer $composer, int $changed, int i) {
        long unselectedColor2;
        long disabledSelectedColor2;
        long disabledUnselectedColor2;
        Composer composer = $composer;
        composer.startReplaceableGroup(-351083046);
        ComposerKt.sourceInformation(composer, "C(colors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)145@6266L9,146@6348L9,148@6455L9,151@6639L9:RadioButton.kt#uh7d8r");
        long selectedColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(RadioButtonTokens.INSTANCE.getSelectedIconColor(), composer, 6) : selectedColor;
        if ((i & 2) != 0) {
            unselectedColor2 = ColorSchemeKt.toColor(RadioButtonTokens.INSTANCE.getUnselectedIconColor(), composer, 6);
        } else {
            unselectedColor2 = unselectedColor;
        }
        if ((i & 4) != 0) {
            disabledSelectedColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(RadioButtonTokens.INSTANCE.getDisabledSelectedIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledSelectedColor2 = disabledSelectedColor;
        }
        if ((i & 8) != 0) {
            disabledUnselectedColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(RadioButtonTokens.INSTANCE.getDisabledUnselectedIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledUnselectedColor2 = disabledUnselectedColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-351083046, $changed, -1, "androidx.compose.material3.RadioButtonDefaults.colors (RadioButton.kt:144)");
        } else {
            int i2 = $changed;
        }
        RadioButtonColors radioButtonColors = new RadioButtonColors(selectedColor2, unselectedColor2, disabledSelectedColor2, disabledUnselectedColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return radioButtonColors;
    }
}
