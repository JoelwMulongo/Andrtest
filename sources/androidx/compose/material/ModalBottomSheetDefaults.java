package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/material/ModalBottomSheetDefaults;", "", "()V", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "scrimColor", "Landroidx/compose/ui/graphics/Color;", "getScrimColor", "(Landroidx/compose/runtime/Composer;I)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
public final class ModalBottomSheetDefaults {
    public static final int $stable = 0;
    private static final float Elevation = Dp.m5986constructorimpl((float) 16);
    public static final ModalBottomSheetDefaults INSTANCE = new ModalBottomSheetDefaults();

    private ModalBottomSheetDefaults() {
    }

    /* renamed from: getElevation-D9Ej5fM  reason: not valid java name */
    public final float m1541getElevationD9Ej5fM() {
        return Elevation;
    }

    public final long getScrimColor(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-112572414);
        ComposerKt.sourceInformation($composer, "C594@24162L6:ModalBottomSheet.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-112572414, $changed, -1, "androidx.compose.material.ModalBottomSheetDefaults.<get-scrimColor> (ModalBottomSheet.kt:594)");
        }
        long r0 = Color.m3163copywmQWz5c$default(MaterialTheme.INSTANCE.getColors($composer, 6).m1444getOnSurface0d7_KjU(), 0.32f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r0;
    }
}
