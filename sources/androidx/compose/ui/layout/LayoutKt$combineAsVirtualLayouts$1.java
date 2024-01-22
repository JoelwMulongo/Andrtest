package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Layout.kt */
final class LayoutKt$combineAsVirtualLayouts$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ List<Function2<Composer, Integer, Unit>> $contents;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutKt$combineAsVirtualLayouts$1(List<? extends Function2<? super Composer, ? super Integer, Unit>> list) {
        super(2);
        this.$contents = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C*178@7038L170:Layout.kt#80mrfh");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1953651383, $changed, -1, "androidx.compose.ui.layout.combineAsVirtualLayouts.<anonymous> (Layout.kt:176)");
            }
            List $this$fastForEach$iv = this.$contents;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Function2 content = $this$fastForEach$iv.get(index$iv);
                Function0 factory$iv = ComposeUiNode.Companion.getVirtualConstructor();
                $composer.startReplaceableGroup(-692256719);
                ComposerKt.sourceInformation($composer, "CC(ReusableComposeNode)P(1,2)372@13941L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    $composer.createNode(factory$iv);
                } else {
                    $composer.useNode();
                }
                Composer r10 = Updater.m2787constructorimpl($composer);
                content.invoke($composer, Integer.valueOf((6 >> 6) & 14));
                $composer.endNode();
                $composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
