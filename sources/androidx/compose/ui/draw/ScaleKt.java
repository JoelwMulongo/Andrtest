package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\u0005"}, d2 = {"scale", "Landroidx/compose/ui/Modifier;", "", "scaleX", "scaleY", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scale.kt */
public final class ScaleKt {
    public static final Modifier scale(Modifier $this$scale, float scaleX, float scaleY) {
        Modifier modifier = $this$scale;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        boolean z = true;
        if (scaleX == 1.0f) {
            if (scaleY != 1.0f) {
                z = false;
            }
            if (z) {
                return modifier;
            }
        }
        return GraphicsLayerModifierKt.m3310graphicsLayerAp8cVGQ$default($this$scale, scaleX, scaleY, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 0, 131068, (Object) null);
    }

    public static final Modifier scale(Modifier $this$scale, float scale) {
        Intrinsics.checkNotNullParameter($this$scale, "<this>");
        return scale($this$scale, scale, scale);
    }
}
