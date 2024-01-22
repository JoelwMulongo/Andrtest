package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ=\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Landroidx/compose/material/FloatingActionButtonDefaults;", "", "()V", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "elevation-ixp7dh8", "(FFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "hoveredElevation", "focusedElevation", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatingActionButton.kt */
public final class FloatingActionButtonDefaults {
    public static final int $stable = 0;
    public static final FloatingActionButtonDefaults INSTANCE = new FloatingActionButtonDefaults();

    private FloatingActionButtonDefaults() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    /* renamed from: elevation-ixp7dh8  reason: not valid java name */
    public final /* synthetic */ FloatingActionButtonElevation m1522elevationixp7dh8(float defaultElevation, float pressedElevation, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-654132828);
        ComposerKt.sourceInformation($composer, "C(elevation)P(0:c#ui.unit.Dp,1:c#ui.unit.Dp)222@9757L134:FloatingActionButton.kt#jmzs0o");
        if ((i & 1) != 0) {
            defaultElevation = Dp.m5986constructorimpl((float) 6);
        }
        if ((i & 2) != 0) {
            pressedElevation = Dp.m5986constructorimpl((float) 12);
        }
        if (ComposerKt.isTraceInProgress() != 0) {
            ComposerKt.traceEventStart(-654132828, $changed, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:219)");
        }
        FloatingActionButtonElevation r14 = m1523elevationxZ9QkE(defaultElevation, pressedElevation, Dp.m5986constructorimpl((float) 8), Dp.m5986constructorimpl((float) 8), $composer, ($changed & 14) | 3456 | ($changed & 112) | (($changed << 6) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r14;
    }

    /* renamed from: elevation-xZ9-QkE  reason: not valid java name */
    public final FloatingActionButtonElevation m1523elevationxZ9QkE(float defaultElevation, float pressedElevation, float hoveredElevation, float focusedElevation, Composer $composer, int $changed, int i) {
        float pressedElevation2;
        float hoveredElevation2;
        float focusedElevation2;
        Composer composer = $composer;
        composer.startReplaceableGroup(380403812);
        ComposerKt.sourceInformation(composer, "C(elevation)P(0:c#ui.unit.Dp,3:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp)250@10753L367:FloatingActionButton.kt#jmzs0o");
        float defaultElevation2 = (i & 1) != 0 ? Dp.m5986constructorimpl((float) 6) : defaultElevation;
        if ((i & 2) != 0) {
            pressedElevation2 = Dp.m5986constructorimpl((float) 12);
        } else {
            pressedElevation2 = pressedElevation;
        }
        if ((i & 4) != 0) {
            hoveredElevation2 = Dp.m5986constructorimpl((float) 8);
        } else {
            hoveredElevation2 = hoveredElevation;
        }
        if ((i & 8) != 0) {
            focusedElevation2 = Dp.m5986constructorimpl((float) 8);
        } else {
            focusedElevation2 = focusedElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(380403812, $changed, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:244)");
        } else {
            int i2 = $changed;
        }
        Object[] keys$iv = {Dp.m5984boximpl(defaultElevation2), Dp.m5984boximpl(pressedElevation2), Dp.m5984boximpl(hoveredElevation2), Dp.m5984boximpl(focusedElevation2)};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv = false;
        for (Object key$iv : keys$iv) {
            invalid$iv |= composer.changed(key$iv);
        }
        Composer $this$cache$iv$iv = $composer;
        Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv || value$iv$iv == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv;
            value$iv$iv = new DefaultFloatingActionButtonElevation(defaultElevation2, pressedElevation2, hoveredElevation2, focusedElevation2, (DefaultConstructorMarker) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            Object obj2 = value$iv$iv;
            Composer composer2 = $this$cache$iv$iv;
        }
        $composer.endReplaceableGroup();
        DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation = (DefaultFloatingActionButtonElevation) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return defaultFloatingActionButtonElevation;
    }
}
