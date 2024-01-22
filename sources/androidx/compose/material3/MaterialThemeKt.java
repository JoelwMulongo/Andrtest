package androidx.compose.material3;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material.ripple.RippleThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\u0012\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"DefaultRippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "TextSelectionBackgroundOpacity", "", "MaterialTheme", "", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "shapes", "Landroidx/compose/material3/Shapes;", "typography", "Landroidx/compose/material3/Typography;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: MaterialTheme.kt */
public final class MaterialThemeKt {
    /* access modifiers changed from: private */
    public static final RippleAlpha DefaultRippleAlpha = new RippleAlpha(0.16f, 0.12f, 0.08f, 0.12f);
    public static final float TextSelectionBackgroundOpacity = 0.4f;

    public static final void MaterialTheme(ColorScheme colorScheme, Shapes shapes, Typography typography, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        ColorScheme colorScheme2;
        Shapes shapes2;
        Typography typography2;
        Typography typography3;
        Shapes shapes3;
        ColorScheme colorScheme3;
        int $dirty;
        Typography typography4;
        Object value$iv$iv;
        int i2;
        int i3;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i5 = $changed;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-2127166334);
        ComposerKt.sourceInformation($composer2, "C(MaterialTheme)P(!1,2,3)58@2824L11,59@2872L6,60@2923L10,*63@3007L194,70@3286L16,71@3329L50,72@3384L417:MaterialTheme.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i5 & 14) == 0) {
            if ((i & 1) == 0) {
                colorScheme2 = colorScheme;
                if ($composer2.changed((Object) colorScheme2)) {
                    i4 = 4;
                    $dirty2 |= i4;
                }
            } else {
                colorScheme2 = colorScheme;
            }
            i4 = 2;
            $dirty2 |= i4;
        } else {
            colorScheme2 = colorScheme;
        }
        if ((i5 & 112) == 0) {
            if ((i & 2) == 0) {
                shapes2 = shapes;
                if ($composer2.changed((Object) shapes2)) {
                    i3 = 32;
                    $dirty2 |= i3;
                }
            } else {
                shapes2 = shapes;
            }
            i3 = 16;
            $dirty2 |= i3;
        } else {
            shapes2 = shapes;
        }
        if ((i5 & 896) == 0) {
            if ((i & 4) == 0) {
                typography2 = typography;
                if ($composer2.changed((Object) typography2)) {
                    i2 = 256;
                    $dirty2 |= i2;
                }
            } else {
                typography2 = typography;
            }
            i2 = 128;
            $dirty2 |= i2;
        } else {
            typography2 = typography;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if ((i5 & 7168) == 0) {
            $dirty2 |= $composer2.changed((Object) function2) ? 2048 : 1024;
        }
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 1) != 0) {
                    colorScheme2 = MaterialTheme.INSTANCE.getColorScheme($composer2, 6);
                    $dirty2 &= -15;
                }
                if ((i & 2) != 0) {
                    shapes2 = MaterialTheme.INSTANCE.getShapes($composer2, 6);
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty = $dirty2 & -897;
                    typography4 = MaterialTheme.INSTANCE.getTypography($composer2, 6);
                } else {
                    $dirty = $dirty2;
                    typography4 = typography2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 1) != 0) {
                    $dirty2 &= -15;
                }
                if ((i & 2) != 0) {
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty = $dirty2 & -897;
                    typography4 = typography2;
                } else {
                    $dirty = $dirty2;
                    typography4 = typography2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2127166334, $dirty, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:57)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = ColorScheme.m1792copyG1PFcw$default(colorScheme2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 536870911, (Object) null);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            ColorSchemeKt.updateColorSchemeFrom((ColorScheme) value$iv$iv, colorScheme2);
            ColorScheme rememberedColorScheme = (ColorScheme) value$iv$iv;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ColorSchemeKt.getLocalColorScheme().provides(rememberedColorScheme), IndicationKt.getLocalIndication().provides(RippleKt.m1729rememberRipple9IZ8Weo(false, 0.0f, 0, $composer2, 0, 7)), RippleThemeKt.getLocalRippleTheme().provides(MaterialRippleTheme.INSTANCE), ShapesKt.getLocalShapes().provides(shapes2), TextSelectionColorsKt.getLocalTextSelectionColors().provides(rememberTextSelectionColors(rememberedColorScheme, $composer2, 0)), TypographyKt.getLocalTypography().provides(typography4)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, -1066563262, true, new MaterialThemeKt$MaterialTheme$1(typography4, function2, $dirty)), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            typography3 = typography4;
            colorScheme3 = colorScheme2;
            shapes3 = shapes2;
        } else {
            $composer2.skipToGroupEnd();
            int i6 = $dirty2;
            shapes3 = shapes2;
            typography3 = typography2;
            colorScheme3 = colorScheme2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new MaterialThemeKt$MaterialTheme$2(colorScheme3, shapes3, typography3, content, $changed, i));
    }

    public static final TextSelectionColors rememberTextSelectionColors(ColorScheme colorScheme, Composer $composer, int $changed) {
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        composer.startReplaceableGroup(1866455512);
        ComposerKt.sourceInformation(composer, "C(rememberTextSelectionColors)134@5274L198:MaterialTheme.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1866455512, $changed, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:132)");
        } else {
            int i = $changed;
        }
        long primaryColor = colorScheme.m1813getPrimary0d7_KjU();
        Object key1$iv = Color.m3154boximpl(primaryColor);
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        boolean invalid$iv$iv = composer.changed(key1$iv);
        Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || value$iv$iv == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv;
            value$iv$iv = new TextSelectionColors(primaryColor, Color.m3163copywmQWz5c$default(primaryColor, 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            Object obj2 = value$iv$iv;
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
}
