package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J3\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0016J\u0012\u0010\u001a\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\r\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/material/TabRowDefaults;", "", "()V", "DividerOpacity", "", "DividerThickness", "Landroidx/compose/ui/unit/Dp;", "getDividerThickness-D9Ej5fM", "()F", "F", "IndicatorHeight", "getIndicatorHeight-D9Ej5fM", "ScrollableTabRowPadding", "getScrollableTabRowPadding-D9Ej5fM", "Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "color", "Landroidx/compose/ui/graphics/Color;", "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "Indicator", "height", "Indicator-9IZ8Weo", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material/TabPosition;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
public final class TabRowDefaults {
    public static final int $stable = 0;
    public static final float DividerOpacity = 0.12f;
    private static final float DividerThickness = Dp.m5986constructorimpl((float) 1);
    public static final TabRowDefaults INSTANCE = new TabRowDefaults();
    private static final float IndicatorHeight = Dp.m5986constructorimpl((float) 2);
    private static final float ScrollableTabRowPadding = Dp.m5986constructorimpl((float) 52);

    private TabRowDefaults() {
    }

    /* renamed from: Divider-9IZ8Weo  reason: not valid java name */
    public final void m1657Divider9IZ8Weo(Modifier modifier, float thickness, long color, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        float f;
        long color2;
        long color3;
        float thickness2;
        Modifier modifier3;
        float thickness3;
        Modifier modifier4;
        int i2;
        int i3;
        int i4 = $changed;
        Composer $composer2 = $composer.startRestartGroup(910934799);
        ComposerKt.sourceInformation($composer2, "C(Divider)P(1,2:c#ui.unit.Dp,0:c#ui.graphics.Color)366@16274L7,368@16353L66:TabRow.kt#jmzs0o");
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
                f = thickness;
                if ($composer2.changed(f)) {
                    i3 = 32;
                    $dirty |= i3;
                }
            } else {
                f = thickness;
            }
            i3 = 16;
            $dirty |= i3;
        } else {
            f = thickness;
        }
        if ((i4 & 896) == 0) {
            if ((i & 4) == 0) {
                color2 = color;
                if ($composer2.changed(color2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                color2 = color;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            color2 = color;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i4 & 7168) == 0) {
            $dirty |= $composer2.changed((Object) this) ? 2048 : 1024;
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
                    thickness3 = DividerThickness;
                    $dirty &= -113;
                } else {
                    thickness3 = f;
                }
                if ((i & 4) != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(ContentColorKt.getLocalContentColor());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty &= -897;
                    color2 = Color.m3163copywmQWz5c$default(((Color) consume).m3174unboximpl(), 0.12f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
                thickness3 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(910934799, $dirty, -1, "androidx.compose.material.TabRowDefaults.Divider (TabRow.kt:363)");
            }
            DividerKt.m1480DivideroMI9zvI(modifier4, color2, thickness3, 0.0f, $composer2, ($dirty & 14) | (($dirty >> 3) & 112) | (($dirty << 3) & 896), 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i6 = $dirty;
            modifier3 = modifier4;
            thickness2 = thickness3;
            color3 = color2;
        } else {
            $composer2.skipToGroupEnd();
            int i7 = $dirty;
            modifier3 = modifier2;
            thickness2 = f;
            color3 = color2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new TabRowDefaults$Divider$1(this, modifier3, thickness2, color3, $changed, i));
    }

    /* renamed from: Indicator-9IZ8Weo  reason: not valid java name */
    public final void m1658Indicator9IZ8Weo(Modifier modifier, float height, long color, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        float f;
        long color2;
        long color3;
        float height2;
        Modifier modifier3;
        float height3;
        Modifier modifier4;
        int i2;
        int i3;
        int i4 = $changed;
        Composer $composer2 = $composer.startRestartGroup(1499002201);
        ComposerKt.sourceInformation($composer2, "C(Indicator)P(2,1:c#ui.unit.Dp,0:c#ui.graphics.Color)383@16862L7,385@16886L142:TabRow.kt#jmzs0o");
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
                f = height;
                if ($composer2.changed(f)) {
                    i3 = 32;
                    $dirty |= i3;
                }
            } else {
                f = height;
            }
            i3 = 16;
            $dirty |= i3;
        } else {
            f = height;
        }
        if ((i4 & 896) == 0) {
            if ((i & 4) == 0) {
                color2 = color;
                if ($composer2.changed(color2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                color2 = color;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            color2 = color;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i4 & 7168) == 0) {
            $dirty |= $composer2.changed((Object) this) ? 2048 : 1024;
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
                    height3 = IndicatorHeight;
                    $dirty &= -113;
                } else {
                    height3 = f;
                }
                if ((i & 4) != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(ContentColorKt.getLocalContentColor());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $dirty &= -897;
                    color2 = ((Color) consume).m3174unboximpl();
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
                height3 = f;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1499002201, i4, -1, "androidx.compose.material.TabRowDefaults.Indicator (TabRow.kt:380)");
            }
            BoxKt.Box(BackgroundKt.m449backgroundbw27NRU$default(SizeKt.m816height3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), height3), color2, (Shape) null, 2, (Object) null), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i6 = $dirty;
            modifier3 = modifier4;
            height2 = height3;
            color3 = color2;
        } else {
            $composer2.skipToGroupEnd();
            int i7 = $dirty;
            modifier3 = modifier2;
            height2 = f;
            color3 = color2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabRowDefaults$Indicator$1(this, modifier3, height2, color3, $changed, i));
        }
    }

    public final Modifier tabIndicatorOffset(Modifier $this$tabIndicatorOffset, TabPosition currentTabPosition) {
        Intrinsics.checkNotNullParameter($this$tabIndicatorOffset, "<this>");
        Intrinsics.checkNotNullParameter(currentTabPosition, "currentTabPosition");
        return ComposedModifierKt.composed($this$tabIndicatorOffset, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1(currentTabPosition) : InspectableValueKt.getNoInspectorInfo(), new TabRowDefaults$tabIndicatorOffset$2(currentTabPosition));
    }

    /* renamed from: getDividerThickness-D9Ej5fM  reason: not valid java name */
    public final float m1659getDividerThicknessD9Ej5fM() {
        return DividerThickness;
    }

    /* renamed from: getIndicatorHeight-D9Ej5fM  reason: not valid java name */
    public final float m1660getIndicatorHeightD9Ej5fM() {
        return IndicatorHeight;
    }

    /* renamed from: getScrollableTabRowPadding-D9Ej5fM  reason: not valid java name */
    public final float m1661getScrollableTabRowPaddingD9Ej5fM() {
        return ScrollableTabRowPadding;
    }
}
