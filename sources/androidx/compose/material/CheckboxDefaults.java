package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Landroidx/compose/material/CheckboxDefaults;", "", "()V", "colors", "Landroidx/compose/material/CheckboxColors;", "checkedColor", "Landroidx/compose/ui/graphics/Color;", "uncheckedColor", "checkmarkColor", "disabledColor", "disabledIndeterminateColor", "colors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/CheckboxColors;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Checkbox.kt */
public final class CheckboxDefaults {
    public static final int $stable = 0;
    public static final CheckboxDefaults INSTANCE = new CheckboxDefaults();

    private CheckboxDefaults() {
    }

    /* renamed from: colors-zjMxDiM  reason: not valid java name */
    public final CheckboxColors m1423colorszjMxDiM(long checkedColor, long uncheckedColor, long checkmarkColor, long disabledColor, long disabledIndeterminateColor, Composer $composer, int $changed, int i) {
        long uncheckedColor2;
        long checkmarkColor2;
        long disabledColor2;
        long disabledIndeterminateColor2;
        Composer composer = $composer;
        composer.startReplaceableGroup(469524104);
        ComposerKt.sourceInformation(composer, "C(colors)P(0:c#ui.graphics.Color,4:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)227@9578L6,228@9642L6,229@9725L6,230@9786L6,230@9829L8,231@9923L8,233@9972L922:Checkbox.kt#jmzs0o");
        long checkedColor2 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1447getSecondary0d7_KjU() : checkedColor;
        if ((i & 2) != 0) {
            uncheckedColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            uncheckedColor2 = uncheckedColor;
        }
        if ((i & 4) != 0) {
            checkmarkColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1449getSurface0d7_KjU();
        } else {
            checkmarkColor2 = checkmarkColor;
        }
        if ((i & 8) != 0) {
            disabledColor2 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledColor2 = disabledColor;
        }
        if ((i & 16) != 0) {
            disabledIndeterminateColor2 = Color.m3163copywmQWz5c$default(checkedColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledIndeterminateColor2 = disabledIndeterminateColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(469524104, $changed, -1, "androidx.compose.material.CheckboxDefaults.colors (Checkbox.kt:226)");
        } else {
            int i2 = $changed;
        }
        Object[] keys$iv = {Color.m3154boximpl(checkedColor2), Color.m3154boximpl(uncheckedColor2), Color.m3154boximpl(checkmarkColor2), Color.m3154boximpl(disabledColor2), Color.m3154boximpl(disabledIndeterminateColor2)};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv = $composer;
        Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv;
            value$iv$iv = new DefaultCheckboxColors(checkmarkColor2, Color.m3163copywmQWz5c$default(checkmarkColor2, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), checkedColor2, Color.m3163copywmQWz5c$default(checkedColor2, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), disabledColor2, Color.m3163copywmQWz5c$default(disabledColor2, 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), disabledIndeterminateColor2, checkedColor2, uncheckedColor2, disabledColor2, disabledIndeterminateColor2, (DefaultConstructorMarker) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            Composer composer2 = $this$cache$iv$iv;
            Object obj2 = value$iv$iv;
        }
        $composer.endReplaceableGroup();
        DefaultCheckboxColors defaultCheckboxColors = (DefaultCheckboxColors) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultCheckboxColors;
    }
}
