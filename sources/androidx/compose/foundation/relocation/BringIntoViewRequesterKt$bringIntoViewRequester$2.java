package androidx.compose.foundation.relocation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BringIntoViewRequester.kt */
final class BringIntoViewRequesterKt$bringIntoViewRequester$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BringIntoViewRequesterKt$bringIntoViewRequester$2(BringIntoViewRequester bringIntoViewRequester) {
        super(3);
        this.$bringIntoViewRequester = bringIntoViewRequester;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        $composer.startReplaceableGroup(-992853993);
        ComposerKt.sourceInformation($composer, "C106@4535L36,107@4591L91,111@4755L180:BringIntoViewRequester.kt#exjx5q");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-992853993, $changed, -1, "androidx.compose.foundation.relocation.bringIntoViewRequester.<anonymous> (BringIntoViewRequester.kt:105)");
        }
        BringIntoViewParent defaultResponder = BringIntoViewResponder_androidKt.rememberDefaultBringIntoViewParent($composer, 0);
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) defaultResponder);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = new BringIntoViewRequesterModifier(defaultResponder);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        final BringIntoViewRequesterModifier modifier = (BringIntoViewRequesterModifier) value$iv$iv;
        BringIntoViewRequester bringIntoViewRequester = this.$bringIntoViewRequester;
        if (bringIntoViewRequester instanceof BringIntoViewRequesterImpl) {
            final BringIntoViewRequester bringIntoViewRequester2 = this.$bringIntoViewRequester;
            EffectsKt.DisposableEffect((Object) bringIntoViewRequester, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new Function1<DisposableEffectScope, DisposableEffectResult>() {
                public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
                    Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
                    ((BringIntoViewRequesterImpl) bringIntoViewRequester2).getModifiers().add(modifier);
                    DisposableEffectScope disposableEffectScope = $this$DisposableEffect;
                    return new BringIntoViewRequesterKt$bringIntoViewRequester$2$1$invoke$$inlined$onDispose$1(bringIntoViewRequester2, modifier);
                }
            }, $composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return modifier;
    }
}
