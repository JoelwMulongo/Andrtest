package com.example.joelmulongo;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: com.example.joelmulongo.ComposableSingletons$MainActivityKt$lambda-2$1  reason: invalid class name */
/* compiled from: MainActivity.kt */
final class ComposableSingletons$MainActivityKt$lambda2$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    public static final ComposableSingletons$MainActivityKt$lambda2$1 INSTANCE = new ComposableSingletons$MainActivityKt$lambda2$1();

    ComposableSingletons$MainActivityKt$lambda2$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C20@875L11,20@810L149:MainActivity.kt#e5a1pq");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(921765489, i, -1, "com.example.joelmulongo.ComposableSingletons$MainActivityKt.lambda-2.<anonymous> (MainActivity.kt:18)");
            }
            SurfaceKt.m2097SurfaceT9BRK9s(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Shape) null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).m1794getBackground0d7_KjU(), 0, 0.0f, 0.0f, (BorderStroke) null, ComposableSingletons$MainActivityKt.INSTANCE.m286getLambda1$app_debug(), $composer, 12582918, 122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
