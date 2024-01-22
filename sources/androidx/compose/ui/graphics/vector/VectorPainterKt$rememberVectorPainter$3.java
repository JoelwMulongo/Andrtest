package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorPainter.kt */
final class VectorPainterKt$rememberVectorPainter$3 extends Lambda implements Function4<Float, Float, Composer, Integer, Unit> {
    final /* synthetic */ ImageVector $image;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VectorPainterKt$rememberVectorPainter$3(ImageVector imageVector) {
        super(4);
        this.$image = imageVector;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
        invoke(((Number) p1).floatValue(), ((Number) p2).floatValue(), (Composer) p3, ((Number) p4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f, float f2, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C167@6908L37:VectorPainter.kt#huu6hf");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1873274766, $changed, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous> (VectorPainter.kt:167)");
            }
            VectorPainterKt.RenderVectorGroup(this.$image.getRoot(), (Map<String, ? extends VectorConfig>) null, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
