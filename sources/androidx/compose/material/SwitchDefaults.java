package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jy\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/compose/material/SwitchDefaults;", "", "()V", "colors", "Landroidx/compose/material/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedTrackAlpha", "", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedTrackAlpha", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "colors-SQMK_m0", "(JJFJJFJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material/SwitchColors;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();

    private SwitchDefaults() {
    }

    /* renamed from: colors-SQMK_m0  reason: not valid java name */
    public final SwitchColors m1644colorsSQMK_m0(long checkedThumbColor, long checkedTrackColor, float checkedTrackAlpha, long uncheckedThumbColor, long uncheckedTrackColor, float uncheckedTrackAlpha, long disabledCheckedThumbColor, long disabledCheckedTrackColor, long disabledUncheckedThumbColor, long disabledUncheckedTrackColor, Composer $composer, int $changed, int $changed1, int i) {
        long checkedTrackColor2;
        float checkedTrackAlpha2;
        long uncheckedThumbColor2;
        long uncheckedTrackColor2;
        float uncheckedTrackAlpha2;
        long checkedThumbColor2;
        long disabledCheckedThumbColor2;
        long disabledCheckedThumbColor3;
        long disabledCheckedTrackColor2;
        long uncheckedThumbColor3;
        long disabledUncheckedThumbColor2;
        long disabledUncheckedTrackColor2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(-1032127534);
        ComposerKt.sourceInformation(composer, "C(colors)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color!1,7:c#ui.graphics.Color,9:c#ui.graphics.Color,8,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color)283@11347L6,286@11519L6,287@11586L6,290@11748L8,291@11799L6,293@11916L8,294@11967L6,296@12088L8,297@12139L6,299@12260L8,300@12311L6:Switch.kt#jmzs0o");
        long checkedThumbColor3 = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1448getSecondaryVariant0d7_KjU() : checkedThumbColor;
        if ((i2 & 2) != 0) {
            checkedTrackColor2 = checkedThumbColor3;
        } else {
            checkedTrackColor2 = checkedTrackColor;
        }
        if ((i2 & 4) != 0) {
            checkedTrackAlpha2 = 0.54f;
        } else {
            checkedTrackAlpha2 = checkedTrackAlpha;
        }
        if ((i2 & 8) != 0) {
            uncheckedThumbColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1449getSurface0d7_KjU();
        } else {
            uncheckedThumbColor2 = uncheckedThumbColor;
        }
        if ((i2 & 16) != 0) {
            uncheckedTrackColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1444getOnSurface0d7_KjU();
        } else {
            uncheckedTrackColor2 = uncheckedTrackColor;
        }
        if ((i2 & 32) != 0) {
            uncheckedTrackAlpha2 = 0.38f;
        } else {
            uncheckedTrackAlpha2 = uncheckedTrackAlpha;
        }
        if ((i2 & 64) != 0) {
            checkedThumbColor2 = checkedThumbColor3;
            disabledCheckedThumbColor2 = ColorKt.m3209compositeOverOWjLjI(Color.m3163copywmQWz5c$default(checkedThumbColor3, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).m1449getSurface0d7_KjU());
        } else {
            checkedThumbColor2 = checkedThumbColor3;
            disabledCheckedThumbColor2 = disabledCheckedThumbColor;
        }
        if ((i2 & 128) != 0) {
            disabledCheckedThumbColor3 = disabledCheckedThumbColor2;
            disabledCheckedTrackColor2 = ColorKt.m3209compositeOverOWjLjI(Color.m3163copywmQWz5c$default(checkedTrackColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).m1449getSurface0d7_KjU());
        } else {
            disabledCheckedThumbColor3 = disabledCheckedThumbColor2;
            disabledCheckedTrackColor2 = disabledCheckedTrackColor;
        }
        if ((i2 & 256) != 0) {
            uncheckedThumbColor3 = uncheckedThumbColor2;
            disabledUncheckedThumbColor2 = ColorKt.m3209compositeOverOWjLjI(Color.m3163copywmQWz5c$default(uncheckedThumbColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).m1449getSurface0d7_KjU());
        } else {
            uncheckedThumbColor3 = uncheckedThumbColor2;
            disabledUncheckedThumbColor2 = disabledUncheckedThumbColor;
        }
        if ((i2 & 512) != 0) {
            disabledUncheckedTrackColor2 = ColorKt.m3209compositeOverOWjLjI(Color.m3163copywmQWz5c$default(uncheckedTrackColor2, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColors(composer, 6).m1449getSurface0d7_KjU());
        } else {
            disabledUncheckedTrackColor2 = disabledUncheckedTrackColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1032127534, $changed, $changed1, "androidx.compose.material.SwitchDefaults.colors (Switch.kt:282)");
        } else {
            int i3 = $changed;
            int i4 = $changed1;
        }
        DefaultSwitchColors defaultSwitchColors = new DefaultSwitchColors(checkedThumbColor2, Color.m3163copywmQWz5c$default(checkedTrackColor2, checkedTrackAlpha2, 0.0f, 0.0f, 0.0f, 14, (Object) null), uncheckedThumbColor3, Color.m3163copywmQWz5c$default(uncheckedTrackColor2, uncheckedTrackAlpha2, 0.0f, 0.0f, 0.0f, 14, (Object) null), disabledCheckedThumbColor3, Color.m3163copywmQWz5c$default(disabledCheckedTrackColor2, checkedTrackAlpha2, 0.0f, 0.0f, 0.0f, 14, (Object) null), disabledUncheckedThumbColor2, Color.m3163copywmQWz5c$default(disabledUncheckedTrackColor2, uncheckedTrackAlpha2, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultSwitchColors;
    }
}
