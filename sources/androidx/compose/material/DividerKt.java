package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"DividerAlpha", "", "Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "thickness", "Landroidx/compose/ui/unit/Dp;", "startIndent", "Divider-oMI9zvI", "(Landroidx/compose/ui/Modifier;JFFLandroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Divider.kt */
public final class DividerKt {
    private static final float DividerAlpha = 0.12f;

    /* renamed from: Divider-oMI9zvI  reason: not valid java name */
    public static final void m1480DivideroMI9zvI(Modifier modifier, long color, float thickness, float startIndent, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        float f;
        float f2;
        float startIndent2;
        float thickness2;
        long color2;
        Modifier modifier3;
        float startIndent3;
        float thickness3;
        long color3;
        Modifier modifier4;
        Modifier indentMod;
        int i2;
        float targetThickness;
        int i3;
        int i4 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-1249392198);
        ComposerKt.sourceInformation($composer2, "C(Divider)P(1,0:c#ui.graphics.Color,3:c#ui.unit.Dp,2:c#ui.unit.Dp)45@1819L6,59@2200L147:Divider.kt#jmzs0o");
        int $dirty = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i4 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i4 & 112) == 0) {
            if ((i & 2) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i3 = 32;
                    $dirty |= i3;
                }
            } else {
                j = color;
            }
            i3 = 16;
            $dirty |= i3;
        } else {
            j = color;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty |= 384;
            f = thickness;
        } else if ((i4 & 896) == 0) {
            f = thickness;
            $dirty |= $composer2.changed(f) ? 256 : 128;
        } else {
            f = thickness;
        }
        int i7 = i & 8;
        if (i7 != 0) {
            $dirty |= 3072;
            f2 = startIndent;
        } else if ((i4 & 7168) == 0) {
            f2 = startIndent;
            $dirty |= $composer2.changed(f2) ? 2048 : 1024;
        } else {
            f2 = startIndent;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) != 0) {
                    color3 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors($composer2, 6).m1444getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    $dirty &= -113;
                } else {
                    color3 = j;
                }
                if (i6 != 0) {
                    thickness3 = Dp.m5986constructorimpl((float) 1);
                } else {
                    thickness3 = f;
                }
                if (i7 != 0) {
                    startIndent3 = Dp.m5986constructorimpl((float) 0);
                } else {
                    startIndent3 = f2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                modifier4 = modifier2;
                color3 = j;
                thickness3 = f;
                startIndent3 = f2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1249392198, i4, -1, "androidx.compose.material.Divider (Divider.kt:43)");
            }
            if (!(startIndent3 == 0.0f)) {
                i2 = 0;
                indentMod = PaddingKt.m764paddingqDBjuR0$default(Modifier.Companion, startIndent3, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            } else {
                i2 = 0;
                indentMod = Modifier.Companion;
            }
            $composer2.startReplaceableGroup(1228914189);
            ComposerKt.sourceInformation($composer2, "*55@2139L7");
            if (Dp.m5991equalsimpl0(thickness3, Dp.Companion.m6004getHairlineD9Ej5fM())) {
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer2);
                targetThickness = Dp.m5986constructorimpl(1.0f / ((Density) consume).getDensity());
            } else {
                targetThickness = thickness3;
            }
            $composer2.endReplaceableGroup();
            BoxKt.Box(BackgroundKt.m449backgroundbw27NRU$default(SizeKt.m816height3ABfNKs(SizeKt.fillMaxWidth$default(modifier4.then(indentMod), 0.0f, 1, (Object) null), targetThickness), color3, (Shape) null, 2, (Object) null), $composer2, i2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i8 = $dirty;
            modifier3 = modifier4;
            color2 = color3;
            thickness2 = thickness3;
            startIndent2 = startIndent3;
        } else {
            $composer2.skipToGroupEnd();
            int i9 = $dirty;
            modifier3 = modifier2;
            thickness2 = f;
            startIndent2 = f2;
            color2 = j;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DividerKt$Divider$1(modifier3, color2, thickness2, startIndent2, $changed, i));
        }
    }
}
