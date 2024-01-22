package androidx.compose.material3;

import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015Je\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!JQ\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+Je\u0010,\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010!JQ\u0010.\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u00042\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u0004H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010+R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, d2 = {"Landroidx/compose/material3/AssistChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "assistChipBorder", "Landroidx/compose/material3/ChipBorder;", "borderColor", "Landroidx/compose/ui/graphics/Color;", "disabledBorderColor", "borderWidth", "assistChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipBorder;", "assistChipColors", "Landroidx/compose/material3/ChipColors;", "containerColor", "labelColor", "leadingIconContentColor", "trailingIconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconContentColor", "disabledTrailingIconContentColor", "assistChipColors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipColors;", "assistChipElevation", "Landroidx/compose/material3/ChipElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "assistChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipElevation;", "elevatedAssistChipColors", "elevatedAssistChipColors-oq7We08", "elevatedAssistChipElevation", "elevatedAssistChipElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalMaterial3Api
/* compiled from: Chip.kt */
public final class AssistChipDefaults {
    public static final int $stable = 0;
    private static final float Height = AssistChipTokens.INSTANCE.m2261getContainerHeightD9Ej5fM();
    public static final AssistChipDefaults INSTANCE = new AssistChipDefaults();
    private static final float IconSize = AssistChipTokens.INSTANCE.m2270getIconSizeD9Ej5fM();

    private AssistChipDefaults() {
    }

    /* renamed from: getHeight-D9Ej5fM  reason: not valid java name */
    public final float m1757getHeightD9Ej5fM() {
        return Height;
    }

    /* renamed from: getIconSize-D9Ej5fM  reason: not valid java name */
    public final float m1758getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* renamed from: assistChipColors-oq7We08  reason: not valid java name */
    public final ChipColors m1753assistChipColorsoq7We08(long containerColor, long labelColor, long leadingIconContentColor, long trailingIconContentColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconContentColor, long disabledTrailingIconContentColor, Composer $composer, int $changed, int i) {
        long labelColor2;
        long leadingIconContentColor2;
        long trailingIconContentColor2;
        long disabledContainerColor2;
        long disabledLabelColor2;
        long disabledLeadingIconContentColor2;
        long disabledTrailingIconContentColor2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(-391745725);
        ComposerKt.sourceInformation(composer, "C(assistChipColors)P(0:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)650@32212L9,651@32291L9,654@32504L9,657@32680L9:Chip.kt#uh7d8r");
        long containerColor2 = (i2 & 1) != 0 ? Color.Companion.m3199getTransparent0d7_KjU() : containerColor;
        if ((i2 & 2) != 0) {
            labelColor2 = ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getLabelTextColor(), composer, 6);
        } else {
            labelColor2 = labelColor;
        }
        if ((i2 & 4) != 0) {
            leadingIconContentColor2 = ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getIconColor(), composer, 6);
        } else {
            leadingIconContentColor2 = leadingIconContentColor;
        }
        if ((i2 & 8) != 0) {
            trailingIconContentColor2 = leadingIconContentColor2;
        } else {
            trailingIconContentColor2 = trailingIconContentColor;
        }
        if ((i2 & 16) != 0) {
            disabledContainerColor2 = Color.Companion.m3199getTransparent0d7_KjU();
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i2 & 32) != 0) {
            disabledLabelColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((i2 & 64) != 0) {
            disabledLeadingIconContentColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getDisabledIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLeadingIconContentColor2 = disabledLeadingIconContentColor;
        }
        if ((i2 & 128) != 0) {
            disabledTrailingIconContentColor2 = disabledLeadingIconContentColor2;
        } else {
            disabledTrailingIconContentColor2 = disabledTrailingIconContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-391745725, $changed, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:648)");
        } else {
            int i3 = $changed;
        }
        ChipColors chipColors = new ChipColors(containerColor2, labelColor2, leadingIconContentColor2, trailingIconContentColor2, disabledContainerColor2, disabledLabelColor2, disabledLeadingIconContentColor2, disabledTrailingIconContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return chipColors;
    }

    /* renamed from: assistChipElevation-aqJV_2Y  reason: not valid java name */
    public final ChipElevation m1754assistChipElevationaqJV_2Y(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float pressedElevation2;
        float focusedElevation2;
        float hoveredElevation2;
        float draggedElevation2;
        float disabledElevation2;
        Composer composer = $composer;
        composer.startReplaceableGroup(245366099);
        ComposerKt.sourceInformation(composer, "C(assistChipElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Chip.kt#uh7d8r");
        float defaultElevation2 = (i & 1) != 0 ? AssistChipTokens.INSTANCE.m2268getFlatContainerElevationD9Ej5fM() : defaultElevation;
        if ((i & 2) != 0) {
            pressedElevation2 = defaultElevation2;
        } else {
            pressedElevation2 = pressedElevation;
        }
        if ((i & 4) != 0) {
            focusedElevation2 = defaultElevation2;
        } else {
            focusedElevation2 = focusedElevation;
        }
        if ((i & 8) != 0) {
            hoveredElevation2 = defaultElevation2;
        } else {
            hoveredElevation2 = hoveredElevation;
        }
        if ((i & 16) != 0) {
            draggedElevation2 = AssistChipTokens.INSTANCE.m2262getDraggedContainerElevationD9Ej5fM();
        } else {
            draggedElevation2 = draggedElevation;
        }
        if ((i & 32) != 0) {
            disabledElevation2 = defaultElevation2;
        } else {
            disabledElevation2 = disabledElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(245366099, $changed, -1, "androidx.compose.material3.AssistChipDefaults.assistChipElevation (Chip.kt:684)");
        } else {
            int i2 = $changed;
        }
        ChipElevation chipElevation = new ChipElevation(defaultElevation2, pressedElevation2, focusedElevation2, hoveredElevation2, draggedElevation2, disabledElevation2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return chipElevation;
    }

    /* renamed from: assistChipBorder-d_3_b6Q  reason: not valid java name */
    public final ChipBorder m1752assistChipBorderd_3_b6Q(long borderColor, long disabledBorderColor, float borderWidth, Composer $composer, int $changed, int i) {
        long disabledBorderColor2;
        float borderWidth2;
        Composer composer = $composer;
        composer.startReplaceableGroup(382372847);
        ComposerKt.sourceInformation(composer, "C(assistChipBorder)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,1:c#ui.unit.Dp)709@35136L9,710@35226L9:Chip.kt#uh7d8r");
        long borderColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getFlatOutlineColor(), composer, 6) : borderColor;
        if ((i & 2) != 0) {
            disabledBorderColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getFlatDisabledOutlineColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        if ((i & 4) != 0) {
            borderWidth2 = AssistChipTokens.INSTANCE.m2269getFlatOutlineWidthD9Ej5fM();
        } else {
            borderWidth2 = borderWidth;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(382372847, $changed, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:708)");
        } else {
            int i2 = $changed;
        }
        ChipBorder chipBorder = new ChipBorder(borderColor2, disabledBorderColor2, borderWidth2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return chipBorder;
    }

    /* renamed from: elevatedAssistChipColors-oq7We08  reason: not valid java name */
    public final ChipColors m1755elevatedAssistChipColorsoq7We08(long containerColor, long labelColor, long leadingIconContentColor, long trailingIconContentColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconContentColor, long disabledTrailingIconContentColor, Composer $composer, int $changed, int i) {
        long labelColor2;
        long leadingIconContentColor2;
        long trailingIconContentColor2;
        long disabledContainerColor2;
        long disabledLabelColor2;
        long disabledLeadingIconContentColor2;
        long disabledTrailingIconContentColor2;
        Composer composer = $composer;
        int i2 = i;
        composer.startReplaceableGroup(-535762675);
        ComposerKt.sourceInformation(composer, "C(elevatedAssistChipColors)P(0:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)734@36484L9,735@36555L9,736@36634L9,738@36800L9,740@36964L9,743@37140L9:Chip.kt#uh7d8r");
        long containerColor2 = (i2 & 1) != 0 ? ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getElevatedContainerColor(), composer, 6) : containerColor;
        if ((i2 & 2) != 0) {
            labelColor2 = ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getLabelTextColor(), composer, 6);
        } else {
            labelColor2 = labelColor;
        }
        if ((i2 & 4) != 0) {
            leadingIconContentColor2 = ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getIconColor(), composer, 6);
        } else {
            leadingIconContentColor2 = leadingIconContentColor;
        }
        if ((i2 & 8) != 0) {
            trailingIconContentColor2 = leadingIconContentColor2;
        } else {
            trailingIconContentColor2 = trailingIconContentColor;
        }
        if ((i2 & 16) != 0) {
            disabledContainerColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getElevatedDisabledContainerColor(), composer, 6), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledContainerColor2 = disabledContainerColor;
        }
        if ((i2 & 32) != 0) {
            disabledLabelColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getDisabledLabelTextColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLabelColor2 = disabledLabelColor;
        }
        if ((i2 & 64) != 0) {
            disabledLeadingIconContentColor2 = Color.m3163copywmQWz5c$default(ColorSchemeKt.toColor(AssistChipTokens.INSTANCE.getDisabledIconColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            disabledLeadingIconContentColor2 = disabledLeadingIconContentColor;
        }
        if ((i2 & 128) != 0) {
            disabledTrailingIconContentColor2 = disabledLeadingIconContentColor2;
        } else {
            disabledTrailingIconContentColor2 = disabledTrailingIconContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-535762675, $changed, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:733)");
        } else {
            int i3 = $changed;
        }
        ChipColors chipColors = new ChipColors(containerColor2, labelColor2, leadingIconContentColor2, trailingIconContentColor2, disabledContainerColor2, disabledLabelColor2, disabledLeadingIconContentColor2, disabledTrailingIconContentColor2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return chipColors;
    }

    /* renamed from: elevatedAssistChipElevation-aqJV_2Y  reason: not valid java name */
    public final ChipElevation m1756elevatedAssistChipElevationaqJV_2Y(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float pressedElevation2;
        float focusedElevation2;
        float hoveredElevation2;
        float draggedElevation2;
        float disabledElevation2;
        Composer composer = $composer;
        composer.startReplaceableGroup(1457698077);
        ComposerKt.sourceInformation(composer, "C(elevatedAssistChipElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Chip.kt#uh7d8r");
        float defaultElevation2 = (i & 1) != 0 ? AssistChipTokens.INSTANCE.m2263getElevatedContainerElevationD9Ej5fM() : defaultElevation;
        if ((i & 2) != 0) {
            pressedElevation2 = AssistChipTokens.INSTANCE.m2267getElevatedPressedContainerElevationD9Ej5fM();
        } else {
            pressedElevation2 = pressedElevation;
        }
        if ((i & 4) != 0) {
            focusedElevation2 = AssistChipTokens.INSTANCE.m2265getElevatedFocusContainerElevationD9Ej5fM();
        } else {
            focusedElevation2 = focusedElevation;
        }
        if ((i & 8) != 0) {
            hoveredElevation2 = AssistChipTokens.INSTANCE.m2266getElevatedHoverContainerElevationD9Ej5fM();
        } else {
            hoveredElevation2 = hoveredElevation;
        }
        if ((i & 16) != 0) {
            draggedElevation2 = AssistChipTokens.INSTANCE.m2262getDraggedContainerElevationD9Ej5fM();
        } else {
            draggedElevation2 = draggedElevation;
        }
        if ((i & 32) != 0) {
            disabledElevation2 = AssistChipTokens.INSTANCE.m2264getElevatedDisabledContainerElevationD9Ej5fM();
        } else {
            disabledElevation2 = disabledElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1457698077, $changed, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipElevation (Chip.kt:770)");
        } else {
            int i2 = $changed;
        }
        ChipElevation chipElevation = new ChipElevation(defaultElevation2, pressedElevation2, focusedElevation2, hoveredElevation2, draggedElevation2, disabledElevation2, (DefaultConstructorMarker) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return chipElevation;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1988153916);
        ComposerKt.sourceInformation($composer, "C787@39428L9:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1988153916, $changed, -1, "androidx.compose.material3.AssistChipDefaults.<get-shape> (Chip.kt:787)");
        }
        Shape shape = ShapesKt.toShape(AssistChipTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return shape;
    }
}
