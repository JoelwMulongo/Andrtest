package androidx.compose.material3;

import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJQ\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(JQ\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u00112\b\b\u0002\u0010,\u001a\u00020\u00112\b\b\u0002\u0010-\u001a\u00020\u00112\b\b\u0002\u0010.\u001a\u00020\u00112\b\b\u0002\u0010/\u001a\u00020\u00042\b\b\u0002\u00100\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u0001\u00103\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u0010\u001eJQ\u00105\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00042\b\b\u0002\u0010\"\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u0010(R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, d2 = {"Landroidx/compose/material3/FilterChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "elevatedFilterChipColors", "Landroidx/compose/material3/SelectableChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "elevatedFilterChipColors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "elevatedFilterChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "elevatedFilterChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "filterChipBorder", "Landroidx/compose/material3/SelectableChipBorder;", "borderColor", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "filterChipBorder-gHcDVlo", "(JJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipBorder;", "filterChipColors", "filterChipColors-XqyqHi0", "filterChipElevation", "filterChipElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
/* compiled from: Chip.kt */
public final class FilterChipDefaults {
    public static final int $stable = 0;
    private static final float Height = FilterChipTokens.INSTANCE.m2474getContainerHeightD9Ej5fM();
    public static final FilterChipDefaults INSTANCE = new FilterChipDefaults();
    private static final float IconSize = FilterChipTokens.INSTANCE.m2490getIconSizeD9Ej5fM();

    private FilterChipDefaults() {
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public final float m1936getHeightD9Ej5fM() {
        return Height;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1937getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* renamed from: filterChipColors-XqyqHi0  reason: not valid java name */
    public final SelectableChipColors m1934filterChipColorsXqyqHi0(long containerColor, long labelColor, long iconColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconColor, long disabledTrailingIconColor, long selectedContainerColor, long disabledSelectedContainerColor, long selectedLabelColor, long selectedLeadingIconColor, long selectedTrailingIconColor, Composer $composer, int $changed, int $changed1, int i) {
        long labelColor2;
        long iconColor2;
        long disabledContainerColor2;
        long disabledLabelColor2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        long selectedContainerColor2;
        long disabledSelectedContainerColor2;
        long selectedLabelColor2;
        long selectedLeadingIconColor2;
        long selectedTrailingIconColor2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(-1831479801);
        ComposerKt.sourceInformation(composer, "C(filterChipColors)P(0:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,4:c#ui.graphics.Color,9:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color)827@41207L9,828@41282L9,830@41428L9,832@41585L9,835@41813L9,837@41936L9,839@42108L9,840@42196L9:Chip.kt#uh7d8r");
        long containerColor2 = (i2 & 1) != 0 ? Color.Companion.m3199getTransparent0d7_KjU() : containerColor;
        if ((i2 & 2) != 0) {
            labelColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getUnselectedLabelTextColor(), composer, 6);
        } else {
            labelColor2 = labelColor;
        }
        if ((i2 & 4) != 0) {
            iconColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getUnselectedIconColor(), composer, 6);
        } else {
            iconColor2 = iconColor;
        }
        if ((i2 & 8) != 0) {
            disabledContainerColor2 = Color.Companion.m3199getTransparent0d7_KjU();
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i2 & 16) != 0) {
            disabledLabelColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((i2 & 32) != 0) {
            disabledLeadingIconColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getDisabledIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i2 & 64) != 0) {
            disabledTrailingIconColor2 = disabledLeadingIconColor2;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((i2 & 128) != 0) {
            selectedContainerColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getFlatSelectedContainerColor(), composer, 6);
        } else {
            selectedContainerColor2 = selectedContainerColor;
        }
        if ((i2 & 256) != 0) {
            disabledSelectedContainerColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledSelectedContainerColor2 = disabledSelectedContainerColor;
        }
        if ((i2 & 512) != 0) {
            selectedLabelColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getSelectedLabelTextColor(), composer, 6);
        } else {
            selectedLabelColor2 = selectedLabelColor;
        }
        if ((i2 & 1024) != 0) {
            selectedLeadingIconColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getSelectedIconColor(), composer, 6);
        } else {
            selectedLeadingIconColor2 = selectedLeadingIconColor;
        }
        if ((i2 & 2048) != 0) {
            selectedTrailingIconColor2 = selectedLeadingIconColor2;
        } else {
            selectedTrailingIconColor2 = selectedTrailingIconColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1831479801, $changed, $changed1, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:825)");
        } else {
            int i3 = $changed;
            int i4 = $changed1;
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(containerColor2, labelColor2, iconColor2, iconColor2, disabledContainerColor2, disabledLabelColor2, disabledLeadingIconColor2, disabledTrailingIconColor2, selectedContainerColor2, disabledSelectedContainerColor2, selectedLabelColor2, selectedLeadingIconColor2, selectedTrailingIconColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return selectableChipColors;
    }

    /* renamed from: filterChipElevation-aqJV_2Y  reason: not valid java name */
    public final SelectableChipElevation m1935filterChipElevationaqJV_2Y(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float pressedElevation2;
        float focusedElevation2;
        float hoveredElevation2;
        float draggedElevation2;
        float disabledElevation2;
        Composer composer = $composer;
        composer.startReplaceableGroup(-757972185);
        ComposerKt.sourceInformation(composer, "C(filterChipElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Chip.kt#uh7d8r");
        float defaultElevation2 = (i & 1) != 0 ? FilterChipTokens.INSTANCE.m2481getFlatContainerElevationD9Ej5fM() : defaultElevation;
        if ((i & 2) != 0) {
            pressedElevation2 = FilterChipTokens.INSTANCE.m2485getFlatSelectedPressedContainerElevationD9Ej5fM();
        } else {
            pressedElevation2 = pressedElevation;
        }
        if ((i & 4) != 0) {
            focusedElevation2 = FilterChipTokens.INSTANCE.m2482getFlatSelectedFocusContainerElevationD9Ej5fM();
        } else {
            focusedElevation2 = focusedElevation;
        }
        if ((i & 8) != 0) {
            hoveredElevation2 = FilterChipTokens.INSTANCE.m2483getFlatSelectedHoverContainerElevationD9Ej5fM();
        } else {
            hoveredElevation2 = hoveredElevation;
        }
        if ((i & 16) != 0) {
            draggedElevation2 = FilterChipTokens.INSTANCE.m2475getDraggedContainerElevationD9Ej5fM();
        } else {
            draggedElevation2 = draggedElevation;
        }
        if ((i & 32) != 0) {
            disabledElevation2 = defaultElevation2;
        } else {
            disabledElevation2 = disabledElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-757972185, $changed, -1, "androidx.compose.material3.FilterChipDefaults.filterChipElevation (Chip.kt:871)");
        } else {
            int i2 = $changed;
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(defaultElevation2, pressedElevation2, focusedElevation2, hoveredElevation2, draggedElevation2, disabledElevation2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return selectableChipElevation;
    }

    /* renamed from: filterChipBorder-gHcDVlo  reason: not valid java name */
    public final SelectableChipBorder m1933filterChipBordergHcDVlo(long borderColor, long selectedBorderColor, long disabledBorderColor, long disabledSelectedBorderColor, float borderWidth, float selectedBorderWidth, Composer $composer, int $changed, int i) {
        long selectedBorderColor2;
        long disabledBorderColor2;
        long disabledSelectedBorderColor2;
        float borderWidth2;
        float selectedBorderWidth2;
        Composer composer = $composer;
        composer.startReplaceableGroup(-1884534961);
        ComposerKt.sourceInformation(composer, "C(filterChipBorder)P(0:c#ui.graphics.Color,4:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,1:c#ui.unit.Dp,5:c#ui.unit.Dp)902@45330L9,904@45486L9:Chip.kt#uh7d8r");
        long borderColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getFlatUnselectedOutlineColor(), composer, 6) : borderColor;
        if ((i & 2) != 0) {
            selectedBorderColor2 = Color.Companion.m3199getTransparent0d7_KjU();
        } else {
            selectedBorderColor2 = selectedBorderColor;
        }
        if ((i & 4) != 0) {
            disabledBorderColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        if ((i & 8) != 0) {
            disabledSelectedBorderColor2 = Color.Companion.m3199getTransparent0d7_KjU();
        } else {
            disabledSelectedBorderColor2 = disabledSelectedBorderColor;
        }
        if ((i & 16) != 0) {
            borderWidth2 = FilterChipTokens.INSTANCE.m2488getFlatUnselectedOutlineWidthD9Ej5fM();
        } else {
            borderWidth2 = borderWidth;
        }
        if ((i & 32) != 0) {
            selectedBorderWidth2 = FilterChipTokens.INSTANCE.m2484getFlatSelectedOutlineWidthD9Ej5fM();
        } else {
            selectedBorderWidth2 = selectedBorderWidth;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1884534961, $changed, -1, "androidx.compose.material3.FilterChipDefaults.filterChipBorder (Chip.kt:901)");
        } else {
            int i2 = $changed;
        }
        SelectableChipBorder selectableChipBorder = new SelectableChipBorder(borderColor2, selectedBorderColor2, disabledBorderColor2, disabledSelectedBorderColor2, borderWidth2, selectedBorderWidth2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return selectableChipBorder;
    }

    /* renamed from: elevatedFilterChipColors-XqyqHi0  reason: not valid java name */
    public final SelectableChipColors m1931elevatedFilterChipColorsXqyqHi0(long containerColor, long labelColor, long iconColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconColor, long disabledTrailingIconColor, long selectedContainerColor, long disabledSelectedContainerColor, long selectedLabelColor, long selectedLeadingIconColor, long selectedTrailingIconColor, Composer $composer, int $changed, int $changed1, int i) {
        long labelColor2;
        long iconColor2;
        long disabledContainerColor2;
        long disabledLabelColor2;
        long disabledLeadingIconColor2;
        long disabledTrailingIconColor2;
        long selectedContainerColor2;
        long disabledSelectedContainerColor2;
        long selectedLabelColor2;
        long selectedLeadingIconColor2;
        long selectedTrailingIconColor2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(-915841711);
        ComposerKt.sourceInformation(composer, "C(elevatedFilterChipColors)P(0:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,4:c#ui.graphics.Color,9:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color)938@47456L9,939@47537L9,940@47612L9,941@47711L9,943@47875L9,945@48032L9,948@48264L9,950@48423L9,951@48511L9:Chip.kt#uh7d8r");
        long containerColor2 = (i2 & 1) != 0 ? ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getElevatedUnselectedContainerColor(), composer, 6) : containerColor;
        if ((i2 & 2) != 0) {
            labelColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getUnselectedLabelTextColor(), composer, 6);
        } else {
            labelColor2 = labelColor;
        }
        if ((i2 & 4) != 0) {
            iconColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getUnselectedIconColor(), composer, 6);
        } else {
            iconColor2 = iconColor;
        }
        if ((i2 & 8) != 0) {
            disabledContainerColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i2 & 16) != 0) {
            disabledLabelColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((i2 & 32) != 0) {
            disabledLeadingIconColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getDisabledIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i2 & 64) != 0) {
            disabledTrailingIconColor2 = disabledLeadingIconColor2;
        } else {
            disabledTrailingIconColor2 = disabledTrailingIconColor;
        }
        if ((i2 & 128) != 0) {
            selectedContainerColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getElevatedSelectedContainerColor(), composer, 6);
        } else {
            selectedContainerColor2 = selectedContainerColor;
        }
        if ((i2 & 256) != 0) {
            disabledSelectedContainerColor2 = disabledContainerColor2;
        } else {
            disabledSelectedContainerColor2 = disabledSelectedContainerColor;
        }
        if ((i2 & 512) != 0) {
            selectedLabelColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getSelectedLabelTextColor(), composer, 6);
        } else {
            selectedLabelColor2 = selectedLabelColor;
        }
        if ((i2 & 1024) != 0) {
            selectedLeadingIconColor2 = ColorSchemeKt.toColor(FilterChipTokens.INSTANCE.getSelectedIconColor(), composer, 6);
        } else {
            selectedLeadingIconColor2 = selectedLeadingIconColor;
        }
        if ((i2 & 2048) != 0) {
            selectedTrailingIconColor2 = selectedLeadingIconColor2;
        } else {
            selectedTrailingIconColor2 = selectedTrailingIconColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-915841711, $changed, $changed1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:937)");
        } else {
            int i3 = $changed;
            int i4 = $changed1;
        }
        SelectableChipColors selectableChipColors = new SelectableChipColors(containerColor2, labelColor2, iconColor2, iconColor2, disabledContainerColor2, disabledLabelColor2, disabledLeadingIconColor2, disabledTrailingIconColor2, selectedContainerColor2, disabledSelectedContainerColor2, selectedLabelColor2, selectedLeadingIconColor2, selectedTrailingIconColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return selectableChipColors;
    }

    /* renamed from: elevatedFilterChipElevation-aqJV_2Y  reason: not valid java name */
    public final SelectableChipElevation m1932elevatedFilterChipElevationaqJV_2Y(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float pressedElevation2;
        float focusedElevation2;
        float hoveredElevation2;
        float draggedElevation2;
        float disabledElevation2;
        Composer composer = $composer;
        composer.startReplaceableGroup(684803697);
        ComposerKt.sourceInformation(composer, "C(elevatedFilterChipElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Chip.kt#uh7d8r");
        float defaultElevation2 = (i & 1) != 0 ? FilterChipTokens.INSTANCE.m2476getElevatedContainerElevationD9Ej5fM() : defaultElevation;
        if ((i & 2) != 0) {
            pressedElevation2 = FilterChipTokens.INSTANCE.m2480getElevatedPressedContainerElevationD9Ej5fM();
        } else {
            pressedElevation2 = pressedElevation;
        }
        if ((i & 4) != 0) {
            focusedElevation2 = FilterChipTokens.INSTANCE.m2478getElevatedFocusContainerElevationD9Ej5fM();
        } else {
            focusedElevation2 = focusedElevation;
        }
        if ((i & 8) != 0) {
            hoveredElevation2 = FilterChipTokens.INSTANCE.m2479getElevatedHoverContainerElevationD9Ej5fM();
        } else {
            hoveredElevation2 = hoveredElevation;
        }
        if ((i & 16) != 0) {
            draggedElevation2 = FilterChipTokens.INSTANCE.m2475getDraggedContainerElevationD9Ej5fM();
        } else {
            draggedElevation2 = draggedElevation;
        }
        if ((i & 32) != 0) {
            disabledElevation2 = FilterChipTokens.INSTANCE.m2477getElevatedDisabledContainerElevationD9Ej5fM();
        } else {
            disabledElevation2 = disabledElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(684803697, $changed, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipElevation (Chip.kt:982)");
        } else {
            int i2 = $changed;
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(defaultElevation2, pressedElevation2, focusedElevation2, hoveredElevation2, draggedElevation2, disabledElevation2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return selectableChipElevation;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1598643637);
        ComposerKt.sourceInformation($composer, "C999@50988L9:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1598643637, $changed, -1, "androidx.compose.material3.FilterChipDefaults.<get-shape> (Chip.kt:999)");
        }
        Shape shape = ShapesKt.toShape(FilterChipTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }
}
