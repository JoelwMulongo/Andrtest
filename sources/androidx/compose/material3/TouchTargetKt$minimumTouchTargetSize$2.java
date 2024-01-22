package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TouchTarget.kt */
final class TouchTargetKt$minimumTouchTargetSize$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    public static final TouchTargetKt$minimumTouchTargetSize$2 INSTANCE = new TouchTargetKt$minimumTouchTargetSize$2();

    TouchTargetKt$minimumTouchTargetSize$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Modifier modifier;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        $composer.startReplaceableGroup(-1937671640);
        ComposerKt.sourceInformation($composer, "C43@1922L7,46@2149L7:TouchTarget.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1937671640, $changed, -1, "androidx.compose.material3.minimumTouchTargetSize.<anonymous> (TouchTarget.kt:42)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(TouchTargetKt.getLocalMinimumTouchTargetEnforcement());
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (((Boolean) consume).booleanValue()) {
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            modifier = new MinimumTouchTargetModifier(((ViewConfiguration) consume2).m5282getMinimumTouchTargetSizeMYxV2XQ(), (DefaultConstructorMarker) null);
        } else {
            modifier = Modifier.Companion;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return modifier;
    }
}
