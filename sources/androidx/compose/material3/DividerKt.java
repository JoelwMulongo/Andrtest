package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Divider.kt */
public final class DividerKt {
    /* renamed from: Divider-9IZ8Weo  reason: not valid java name */
    public static final void m1890Divider9IZ8Weo(Modifier modifier, float thickness, long color, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        float f;
        long j;
        long color2;
        float thickness2;
        Modifier modifier3;
        long color3;
        float thickness3;
        Modifier modifier4;
        float targetThickness;
        int i2;
        int i3 = $changed;
        Composer $composer2 = $composer.startRestartGroup(1562471785);
        ComposerKt.sourceInformation($composer2, "C(Divider)P(1,2:c#ui.unit.Dp,0:c#ui.graphics.Color)46@1862L5,53@2019L131:Divider.kt#uh7d8r");
        int $dirty = $changed;
        int i4 = i & 1;
        if (i4 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i3 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty |= 48;
            f = thickness;
        } else if ((i3 & 112) == 0) {
            f = thickness;
            $dirty |= $composer2.changed(f) ? 32 : 16;
        } else {
            f = thickness;
        }
        if ((i3 & 896) == 0) {
            if ((i & 4) == 0) {
                j = color;
                if ($composer2.changed(j)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                j = color;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            j = color;
        }
        if (($dirty & 731) != 146 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i3 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i5 != 0) {
                    thickness3 = DividerDefaults.INSTANCE.m1889getThicknessD9Ej5fM();
                } else {
                    thickness3 = f;
                }
                if ((i & 4) != 0) {
                    color3 = DividerDefaults.INSTANCE.getColor($composer2, 6);
                    $dirty &= -897;
                } else {
                    color3 = j;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
                thickness3 = f;
                color3 = j;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1562471785, i3, -1, "androidx.compose.material3.Divider (Divider.kt:43)");
            }
            $composer2.startReplaceableGroup(1232935509);
            ComposerKt.sourceInformation($composer2, "*49@1958L7");
            if (Dp.m5991equalsimpl0(thickness3, Dp.Companion.m6004getHairlineD9Ej5fM())) {
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer2);
                targetThickness = Dp.m5986constructorimpl(1.0f / ((Density) consume).getDensity());
            } else {
                targetThickness = thickness3;
            }
            $composer2.endReplaceableGroup();
            BoxKt.Box(BackgroundKt.m449backgroundbw27NRU$default(SizeKt.m816height3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), targetThickness), color3, (Shape) null, 2, (Object) null), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i6 = $dirty;
            modifier3 = modifier4;
            thickness2 = thickness3;
            color2 = color3;
        } else {
            $composer2.skipToGroupEnd();
            int i7 = $dirty;
            color2 = j;
            modifier3 = modifier2;
            thickness2 = f;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DividerKt$Divider$1(modifier3, thickness2, color2, $changed, i));
        }
    }
}
