package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Scaffold.kt */
final class ScaffoldKt$Scaffold$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomBar;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ WindowInsets $contentWindowInsets;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ Function2<Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScaffoldKt$Scaffold$1(int i, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function24, int i2) {
        super(2);
        this.$floatingActionButtonPosition = i;
        this.$topBar = function2;
        this.$content = function3;
        this.$snackbarHost = function22;
        this.$floatingActionButton = function23;
        this.$contentWindowInsets = windowInsets;
        this.$bottomBar = function24;
        this.$$dirty = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C87@4398L307:Scaffold.kt#uh7d8r");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1979205334, $changed, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:86)");
            }
            int i = this.$floatingActionButtonPosition;
            Function2<Composer, Integer, Unit> function2 = this.$topBar;
            Function3<PaddingValues, Composer, Integer, Unit> function3 = this.$content;
            Function2<Composer, Integer, Unit> function22 = this.$snackbarHost;
            Function2<Composer, Integer, Unit> function23 = this.$floatingActionButton;
            WindowInsets windowInsets = this.$contentWindowInsets;
            Function2<Composer, Integer, Unit> function24 = this.$bottomBar;
            int i2 = this.$$dirty;
            ScaffoldKt.m2051ScaffoldLayoutFMILGgc(i, function2, function3, function22, function23, windowInsets, function24, $composer, ((i2 >> 15) & 14) | (i2 & 112) | ((i2 >> 21) & 896) | (i2 & 7168) | (57344 & i2) | ((i2 >> 9) & 458752) | ((i2 << 12) & 3670016));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
