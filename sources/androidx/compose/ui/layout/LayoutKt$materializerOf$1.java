package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u000b¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/SkippableUpdater;", "Landroidx/compose/ui/node/ComposeUiNode;", "invoke-Deg8D_g", "(Landroidx/compose/runtime/Composer;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Layout.kt */
final class LayoutKt$materializerOf$1 extends Lambda implements Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> {
    final /* synthetic */ Modifier $modifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutKt$materializerOf$1(Modifier modifier) {
        super(3);
        this.$modifier = modifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        m4846invokeDeg8D_g(((SkippableUpdater) p1).m2785unboximpl(), (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-Deg8D_g  reason: not valid java name */
    public final void m4846invokeDeg8D_g(Composer $this$null, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        ComposerKt.sourceInformation($composer, "C:Layout.kt#80mrfh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1586257396, $changed, -1, "androidx.compose.ui.layout.materializerOf.<anonymous> (Layout.kt:189)");
        }
        Modifier materialized = ComposedModifierKt.materialize($composer, this.$modifier);
        $this$null.startReplaceableGroup(509942095);
        Updater.m2794setimpl(Updater.m2787constructorimpl($this$null), materialized, ComposeUiNode.Companion.getSetModifier());
        $this$null.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress() != 0) {
            ComposerKt.traceEventEnd();
        }
    }
}
