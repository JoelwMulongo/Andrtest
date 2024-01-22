package com.example.joelmulongo;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: com.example.joelmulongo.ComposableSingletons$MainActivityKt$lambda-4$1  reason: invalid class name */
/* compiled from: MainActivity.kt */
final class ComposableSingletons$MainActivityKt$lambda4$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$MainActivityKt$lambda4$1 INSTANCE = new ComposableSingletons$MainActivityKt$lambda4$1();

    ComposableSingletons$MainActivityKt$lambda4$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C41@1261L27:MainActivity.kt#e5a1pq");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1361488897, $changed, -1, "com.example.joelmulongo.ComposableSingletons$MainActivityKt.lambda-4.<anonymous> (MainActivity.kt:40)");
            }
            MainActivityKt.Greeting(LiveLiterals$MainActivityKt.INSTANCE.m293String$arg0$callGreeting$fun$anonymous$$arg2$callJoelMulongoTheme$funWelcome_to_my_1st_project(), (Modifier) null, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
