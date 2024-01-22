package com.example.joelmulongo;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.example.joelmulongo.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: com.example.joelmulongo.ComposableSingletons$MainActivityKt$lambda-3$1  reason: invalid class name */
/* compiled from: MainActivity.kt */
final class ComposableSingletons$MainActivityKt$lambda3$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$MainActivityKt$lambda3$1 INSTANCE = new ComposableSingletons$MainActivityKt$lambda3$1();

    ComposableSingletons$MainActivityKt$lambda3$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C18@692L281:MainActivity.kt#e5a1pq");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-641940758, $changed, -1, "com.example.joelmulongo.ComposableSingletons$MainActivityKt.lambda-3.<anonymous> (MainActivity.kt:17)");
            }
            ThemeKt.JoelMulongoTheme(false, false, ComposableSingletons$MainActivityKt.INSTANCE.m287getLambda2$app_debug(), $composer, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
