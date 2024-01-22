package androidx.compose.material;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material.ripple.RippleThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"MaterialTheme", "", "colors", "Landroidx/compose/material/Colors;", "typography", "Landroidx/compose/material/Typography;", "shapes", "Landroidx/compose/material/Shapes;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material/Colors;Landroidx/compose/material/Typography;Landroidx/compose/material/Shapes;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: MaterialTheme.kt */
public final class MaterialThemeKt {
    public static final void MaterialTheme(Colors colors, Typography typography, Shapes shapes, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Colors colors2;
        Typography typography2;
        Shapes shapes2;
        Shapes shapes3;
        Typography typography3;
        Colors colors3;
        int $dirty;
        Shapes shapes4;
        Object value$iv$iv;
        int i2;
        int i3;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i5 = $changed;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-891417079);
        ComposerKt.sourceInformation($composer2, "C(MaterialTheme)P(!1,3,2)59@2947L6,60@2998L10,61@3045L6,*64@3120L184,69@3367L16,70@3410L45,73@3581L4,71@3460L492:MaterialTheme.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i5 & 14) == 0) {
            if ((i & 1) == 0) {
                colors2 = colors;
                if ($composer2.changed((Object) colors2)) {
                    i4 = 4;
                    $dirty2 |= i4;
                }
            } else {
                colors2 = colors;
            }
            i4 = 2;
            $dirty2 |= i4;
        } else {
            colors2 = colors;
        }
        if ((i5 & 112) == 0) {
            if ((i & 2) == 0) {
                typography2 = typography;
                if ($composer2.changed((Object) typography2)) {
                    i3 = 32;
                    $dirty2 |= i3;
                }
            } else {
                typography2 = typography;
            }
            i3 = 16;
            $dirty2 |= i3;
        } else {
            typography2 = typography;
        }
        if ((i5 & 896) == 0) {
            if ((i & 4) == 0) {
                shapes2 = shapes;
                if ($composer2.changed((Object) shapes2)) {
                    i2 = 256;
                    $dirty2 |= i2;
                }
            } else {
                shapes2 = shapes;
            }
            i2 = 128;
            $dirty2 |= i2;
        } else {
            shapes2 = shapes;
        }
        if ((i & 8) != 0) {
            $dirty2 |= 3072;
        } else if ((i5 & 7168) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 1) != 0) {
                    colors2 = MaterialTheme.INSTANCE.getColors($composer2, 6);
                    $dirty2 &= -15;
                }
                if ((i & 2) != 0) {
                    typography2 = MaterialTheme.INSTANCE.getTypography($composer2, 6);
                    $dirty2 &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty = $dirty2 & -897;
                    shapes4 = MaterialTheme.INSTANCE.getShapes($composer2, 6);
                } else {
                    $dirty = $dirty2;
                    shapes4 = shapes2;
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
                    shapes4 = shapes2;
                } else {
                    $dirty = $dirty2;
                    shapes4 = shapes2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-891417079, $dirty, -1, "androidx.compose.material.MaterialTheme (MaterialTheme.kt:58)");
            }
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = Colors.m1436copypvPzIIM$default(colors2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 8191, (Object) null);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            ColorsKt.updateColorsFrom((Colors) value$iv$iv, colors2);
            Colors rememberedColors = (Colors) value$iv$iv;
            int $dirty3 = $dirty;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ColorsKt.getLocalColors().provides(rememberedColors), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh($composer2, 6))), IndicationKt.getLocalIndication().provides(RippleKt.m1729rememberRipple9IZ8Weo(false, 0.0f, 0, $composer2, 0, 7)), RippleThemeKt.getLocalRippleTheme().provides(MaterialRippleTheme.INSTANCE), ShapesKt.getLocalShapes().provides(shapes4), TextSelectionColorsKt.getLocalTextSelectionColors().provides(MaterialTextSelectionColorsKt.rememberTextSelectionColors(rememberedColors, $composer2, 0)), TypographyKt.getLocalTypography().provides(typography2)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, -1740102967, true, new MaterialThemeKt$MaterialTheme$1(typography2, function2, $dirty3)), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shapes3 = shapes4;
            colors3 = colors2;
            int i6 = $dirty3;
            typography3 = typography2;
        } else {
            $composer2.skipToGroupEnd();
            int i7 = $dirty2;
            typography3 = typography2;
            shapes3 = shapes2;
            colors3 = colors2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new MaterialThemeKt$MaterialTheme$2(colors3, typography3, shapes3, content, $changed, i));
    }
}
