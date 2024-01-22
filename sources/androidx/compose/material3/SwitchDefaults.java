package androidx.compose.material3;

import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jµ\u0001\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000bH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/SwitchDefaults;", "", "()V", "IconSize", "Landroidx/compose/ui/unit/Dp;", "getIconSize-D9Ej5fM", "()F", "F", "colors", "Landroidx/compose/material3/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "colors-V1nXRL4", "(JJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SwitchColors;", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Switch.kt */
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();
    private static final float IconSize = Dp.m5986constructorimpl((float) 16);

    private SwitchDefaults() {
    }

    /* renamed from: colors-V1nXRL4  reason: not valid java name */
    public final SwitchColors m2113colorsV1nXRL4(long checkedThumbColor, long checkedTrackColor, long checkedBorderColor, long checkedIconColor, long uncheckedThumbColor, long uncheckedTrackColor, long uncheckedBorderColor, long uncheckedIconColor, long disabledCheckedThumbColor, long disabledCheckedTrackColor, long disabledCheckedBorderColor, long disabledCheckedIconColor, long disabledUncheckedThumbColor, long disabledUncheckedTrackColor, long disabledUncheckedBorderColor, long disabledUncheckedIconColor, Composer $composer, int $changed, int $changed1, int i) {
        long checkedTrackColor2;
        long checkedBorderColor2;
        long checkedIconColor2;
        long uncheckedThumbColor2;
        long uncheckedTrackColor2;
        long uncheckedBorderColor2;
        long uncheckedIconColor2;
        long disabledCheckedThumbColor2;
        long disabledCheckedTrackColor2;
        long disabledCheckedBorderColor2;
        long disabledCheckedIconColor2;
        long disabledUncheckedThumbColor2;
        long disabledUncheckedTrackColor2;
        long disabledUncheckedBorderColor2;
        long disabledUncheckedIconColor2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(1937926421);
        ComposerKt.sourceInformation(composer, "C(colors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,14:c#ui.graphics.Color,15:c#ui.graphics.Color,12:c#ui.graphics.Color,13:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color,8:c#ui.graphics.Color,9:c#ui.graphics.Color)280@11577L9,281@11655L9,283@11786L9,284@11869L9,285@11951L9,286@12046L9,287@12126L9,288@12221L9,290@12342L11,291@12447L9,293@12559L11,295@12725L9,297@12844L11,298@12954L9,300@13077L11,301@13186L9,303@13298L11,305@13427L9,307@13547L11,308@13654L9,310@13775L11:Switch.kt#uh7d8r");
        long checkedThumbColor2 = (i2 & 1) != 0 ? ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getSelectedHandleColor(), composer, 6) : checkedThumbColor;
        if ((i2 & 2) != 0) {
            checkedTrackColor2 = ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getSelectedTrackColor(), composer, 6);
        } else {
            checkedTrackColor2 = checkedTrackColor;
        }
        if ((i2 & 4) != 0) {
            checkedBorderColor2 = Color.Companion.m3199getTransparent0d7_KjU();
        } else {
            checkedBorderColor2 = checkedBorderColor;
        }
        if ((i2 & 8) != 0) {
            checkedIconColor2 = ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getSelectedIconColor(), composer, 6);
        } else {
            checkedIconColor2 = checkedIconColor;
        }
        if ((i2 & 16) != 0) {
            uncheckedThumbColor2 = ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getUnselectedHandleColor(), composer, 6);
        } else {
            uncheckedThumbColor2 = uncheckedThumbColor;
        }
        if ((i2 & 32) != 0) {
            uncheckedTrackColor2 = ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getUnselectedTrackColor(), composer, 6);
        } else {
            uncheckedTrackColor2 = uncheckedTrackColor;
        }
        if ((i2 & 64) != 0) {
            uncheckedBorderColor2 = ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor(), composer, 6);
        } else {
            uncheckedBorderColor2 = uncheckedBorderColor;
        }
        if ((i2 & 128) != 0) {
            uncheckedIconColor2 = ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getUnselectedIconColor(), composer, 6);
        } else {
            uncheckedIconColor2 = uncheckedIconColor;
        }
        if ((i2 & 256) != 0) {
            disabledCheckedThumbColor2 = ColorKt.m3209compositeOverOWjLjI(Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledSelectedHandleColor(), composer, 6), 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1818getSurface0d7_KjU());
        } else {
            disabledCheckedThumbColor2 = disabledCheckedThumbColor;
        }
        if ((i2 & 512) != 0) {
            disabledCheckedTrackColor2 = ColorKt.m3209compositeOverOWjLjI(Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledSelectedTrackColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1818getSurface0d7_KjU());
        } else {
            disabledCheckedTrackColor2 = disabledCheckedTrackColor;
        }
        if ((i2 & 1024) != 0) {
            disabledCheckedBorderColor2 = Color.Companion.m3199getTransparent0d7_KjU();
        } else {
            disabledCheckedBorderColor2 = disabledCheckedBorderColor;
        }
        if ((i2 & 2048) != 0) {
            disabledCheckedIconColor2 = ColorKt.m3209compositeOverOWjLjI(Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledSelectedIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1818getSurface0d7_KjU());
        } else {
            disabledCheckedIconColor2 = disabledCheckedIconColor;
        }
        if ((i2 & 4096) != 0) {
            disabledUncheckedThumbColor2 = ColorKt.m3209compositeOverOWjLjI(Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1818getSurface0d7_KjU());
        } else {
            disabledUncheckedThumbColor2 = disabledUncheckedThumbColor;
        }
        if ((i2 & 8192) != 0) {
            disabledUncheckedTrackColor2 = ColorKt.m3209compositeOverOWjLjI(Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1818getSurface0d7_KjU());
        } else {
            disabledUncheckedTrackColor2 = disabledUncheckedTrackColor;
        }
        if ((i2 & 16384) != 0) {
            disabledUncheckedBorderColor2 = ColorKt.m3209compositeOverOWjLjI(Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1818getSurface0d7_KjU());
        } else {
            disabledUncheckedBorderColor2 = disabledUncheckedBorderColor;
        }
        if ((i2 & 32768) != 0) {
            disabledUncheckedIconColor2 = ColorKt.m3209compositeOverOWjLjI(Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(SwitchTokens.INSTANCE.getDisabledUnselectedIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).m1818getSurface0d7_KjU());
        } else {
            disabledUncheckedIconColor2 = disabledUncheckedIconColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1937926421, $changed, $changed1, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:279)");
        } else {
            int i3 = $changed;
            int i4 = $changed1;
        }
        SwitchColors switchColors = new SwitchColors(checkedThumbColor2, checkedTrackColor2, checkedBorderColor2, checkedIconColor2, uncheckedThumbColor2, uncheckedTrackColor2, uncheckedBorderColor2, uncheckedIconColor2, disabledCheckedThumbColor2, disabledCheckedTrackColor2, disabledCheckedBorderColor2, disabledCheckedIconColor2, disabledUncheckedThumbColor2, disabledUncheckedTrackColor2, disabledUncheckedBorderColor2, disabledUncheckedIconColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return switchColors;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m2114getIconSizeD9Ej5fM() {
        return IconSize;
    }
}
