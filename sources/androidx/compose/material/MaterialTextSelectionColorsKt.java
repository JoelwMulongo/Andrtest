package androidx.compose.material;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001a%\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a5\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a-\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"DefaultSelectionBackgroundAlpha", "", "DesiredContrastRatio", "MinimumSelectionBackgroundAlpha", "binarySearchForAccessibleSelectionColorAlpha", "selectionColor", "Landroidx/compose/ui/graphics/Color;", "textColor", "backgroundColor", "binarySearchForAccessibleSelectionColorAlpha-ysEtTa8", "(JJJ)F", "calculateContrastRatio", "foreground", "background", "calculateContrastRatio--OWjLjI", "(JJ)F", "selectionColorAlpha", "calculateContrastRatio-nb2GgbA", "(JFJJ)F", "calculateSelectionBackgroundColor", "calculateSelectionBackgroundColor-ysEtTa8", "(JJJ)J", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "colors", "Landroidx/compose/material/Colors;", "(Landroidx/compose/material/Colors;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: MaterialTextSelectionColors.kt */
public final class MaterialTextSelectionColorsKt {
    private static final float DefaultSelectionBackgroundAlpha = 0.4f;
    private static final float DesiredContrastRatio = 4.5f;
    private static final float MinimumSelectionBackgroundAlpha = 0.2f;

    public static final TextSelectionColors rememberTextSelectionColors(Colors colors, Composer $composer, int $changed) {
        long j;
        Colors colors2 = colors;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(colors2, "colors");
        composer.startReplaceableGroup(-721696685);
        ComposerKt.sourceInformation(composer, "C(rememberTextSelectionColors)45@1902L6,47@1930L384:MaterialTextSelectionColors.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-721696685, $changed, -1, "androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)");
        } else {
            int i = $changed;
        }
        long primaryColor = colors.m1445getPrimary0d7_KjU();
        long backgroundColor = colors.m1438getBackground0d7_KjU();
        composer.startReplaceableGroup(35572910);
        ComposerKt.sourceInformation(composer, "*43@1845L7");
        long $this$takeOrElse_u2dDxMtmZc$iv = ColorsKt.m1462contentColorFor4WTKRHQ(colors2, backgroundColor);
        if ($this$takeOrElse_u2dDxMtmZc$iv != Color.Companion.m3200getUnspecified0d7_KjU()) {
            j = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(ContentColorKt.getLocalContentColor());
            ComposerKt.sourceInformationMarkerEnd($composer);
            j = ((Color) consume).m3174unboximpl();
        }
        $composer.endReplaceableGroup();
        long textColorWithLowestAlpha = Color.m3163copywmQWz5c$default(j, ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, (Object) null);
        Object key1$iv = Color.m3154boximpl(primaryColor);
        Color r6 = Color.m3154boximpl(backgroundColor);
        Object key3$iv = Color.m3154boximpl(textColorWithLowestAlpha);
        Color color = r6;
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        boolean invalid$iv$iv = composer.changed(key1$iv) | composer.changed((Object) color) | composer.changed(key3$iv);
        Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || value$iv$iv == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv;
            Color color2 = color;
            value$iv$iv = new TextSelectionColors(colors.m1445getPrimary0d7_KjU(), m1538calculateSelectionBackgroundColorysEtTa8(primaryColor, textColorWithLowestAlpha, backgroundColor), (DefaultConstructorMarker) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            Object obj2 = value$iv$iv;
            Color color3 = color;
            Composer composer2 = $this$cache$iv$iv;
        }
        $composer.endReplaceableGroup();
        TextSelectionColors textSelectionColors = (TextSelectionColors) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return textSelectionColors;
    }

    /* renamed from: calculateSelectionBackgroundColor-ysEtTa8  reason: not valid java name */
    public static final long m1538calculateSelectionBackgroundColorysEtTa8(long selectionColor, long textColor, long backgroundColor) {
        float alpha;
        float maximumContrastRatio = m1537calculateContrastRationb2GgbA(selectionColor, 0.4f, textColor, backgroundColor);
        float minimumContrastRatio = m1537calculateContrastRationb2GgbA(selectionColor, 0.2f, textColor, backgroundColor);
        if (maximumContrastRatio >= DesiredContrastRatio) {
            alpha = 0.4f;
        } else if (minimumContrastRatio < DesiredContrastRatio) {
            alpha = 0.2f;
        } else {
            alpha = m1535binarySearchForAccessibleSelectionColorAlphaysEtTa8(selectionColor, textColor, backgroundColor);
        }
        return Color.m3163copywmQWz5c$default(selectionColor, alpha, 0.0f, 0.0f, 0.0f, 14, (Object) null);
    }

    /* renamed from: binarySearchForAccessibleSelectionColorAlpha-ysEtTa8  reason: not valid java name */
    private static final float m1535binarySearchForAccessibleSelectionColorAlphaysEtTa8(long selectionColor, long textColor, long backgroundColor) {
        float lowAlpha = 0.2f;
        float alpha = 0.4f;
        float highAlpha = 0.4f;
        for (int attempts = 0; attempts < 7; attempts++) {
            float percentageError = (m1537calculateContrastRationb2GgbA(selectionColor, alpha, textColor, backgroundColor) / DesiredContrastRatio) - 1.0f;
            boolean z = false;
            if (0.0f <= percentageError && percentageError <= 0.01f) {
                z = true;
            }
            if (z) {
                break;
            }
            if (percentageError < 0.0f) {
                highAlpha = alpha;
            } else {
                lowAlpha = alpha;
            }
            alpha = (highAlpha + lowAlpha) / 2.0f;
        }
        return alpha;
    }

    /* renamed from: calculateContrastRatio-nb2GgbA  reason: not valid java name */
    private static final float m1537calculateContrastRationb2GgbA(long selectionColor, float selectionColorAlpha, long textColor, long backgroundColor) {
        long compositeBackground = ColorKt.m3209compositeOverOWjLjI(Color.m3163copywmQWz5c$default(selectionColor, selectionColorAlpha, 0.0f, 0.0f, 0.0f, 14, (Object) null), backgroundColor);
        return m1536calculateContrastRatioOWjLjI(ColorKt.m3209compositeOverOWjLjI(textColor, compositeBackground), compositeBackground);
    }

    /* renamed from: calculateContrastRatio--OWjLjI  reason: not valid java name */
    public static final float m1536calculateContrastRatioOWjLjI(long foreground, long background) {
        float foregroundLuminance = ColorKt.m3216luminance8_81llA(foreground) + 0.05f;
        float backgroundLuminance = ColorKt.m3216luminance8_81llA(background) + 0.05f;
        return Math.max(foregroundLuminance, backgroundLuminance) / Math.min(foregroundLuminance, backgroundLuminance);
    }
}
