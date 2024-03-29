package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadLayout.kt */
final class LookaheadLayoutScopeImpl$onPlaced$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function2<LookaheadLayoutCoordinates, LookaheadLayoutCoordinates, Unit> $onPlaced;
    final /* synthetic */ LookaheadLayoutScopeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LookaheadLayoutScopeImpl$onPlaced$2(Function2<? super LookaheadLayoutCoordinates, ? super LookaheadLayoutCoordinates, Unit> function2, LookaheadLayoutScopeImpl lookaheadLayoutScopeImpl) {
        super(3);
        this.$onPlaced = function2;
        this.this$0 = lookaheadLayoutScopeImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        $composer.startReplaceableGroup(-814093691);
        ComposerKt.sourceInformation($composer, "C177@7302L232:LookaheadLayout.kt#80mrfh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-814093691, $changed, -1, "androidx.compose.ui.layout.LookaheadLayoutScopeImpl.onPlaced.<anonymous> (LookaheadLayout.kt:176)");
        }
        Function2<LookaheadLayoutCoordinates, LookaheadLayoutCoordinates, Unit> function2 = this.$onPlaced;
        LookaheadLayoutScopeImpl lookaheadLayoutScopeImpl = this.this$0;
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = new LookaheadOnPlacedModifier(function2, new LookaheadLayoutScopeImpl$onPlaced$2$1$1(lookaheadLayoutScopeImpl));
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Modifier then = $this$composed.then((Modifier) value$iv$iv);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return then;
    }
}
