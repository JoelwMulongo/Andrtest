package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scaffold.kt */
final class ScaffoldKt$Scaffold$child$1 extends Lambda implements Function3<Modifier, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomBar;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ boolean $isFloatingActionButtonDocked;
    final /* synthetic */ ScaffoldState $scaffoldState;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScaffoldKt$Scaffold$child$1(long j, long j2, int i, boolean z, int i2, Function2<? super Composer, ? super Integer, Unit> function2, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i3, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, ScaffoldState scaffoldState) {
        super(3);
        this.$backgroundColor = j;
        this.$contentColor = j2;
        this.$$dirty1 = i;
        this.$isFloatingActionButtonDocked = z;
        this.$floatingActionButtonPosition = i2;
        this.$topBar = function2;
        this.$content = function3;
        this.$floatingActionButton = function22;
        this.$bottomBar = function23;
        this.$$dirty = i3;
        this.$snackbarHost = function32;
        this.$scaffoldState = scaffoldState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Modifier childModifier, Composer $composer, int $changed) {
        Modifier modifier = childModifier;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(modifier, "childModifier");
        ComposerKt.sourceInformation(composer, "C179@8062L525:Scaffold.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= composer.changed((Object) modifier) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 91) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1823402604, $dirty2, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:178)");
            }
            long j = this.$backgroundColor;
            long j2 = this.$contentColor;
            boolean z = this.$isFloatingActionButtonDocked;
            int i = this.$floatingActionButtonPosition;
            Function2<Composer, Integer, Unit> function2 = this.$topBar;
            Function3<PaddingValues, Composer, Integer, Unit> function3 = this.$content;
            Function2<Composer, Integer, Unit> function22 = this.$floatingActionButton;
            Function2<Composer, Integer, Unit> function23 = this.$bottomBar;
            int i2 = this.$$dirty;
            final boolean z2 = z;
            final int i3 = i;
            final Function2<Composer, Integer, Unit> function24 = function2;
            final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
            final Function2<Composer, Integer, Unit> function25 = function22;
            final Function2<Composer, Integer, Unit> function26 = function23;
            final int i4 = i2;
            final int i5 = this.$$dirty1;
            final Function3<SnackbarHostState, Composer, Integer, Unit> function33 = this.$snackbarHost;
            final ScaffoldState scaffoldState = this.$scaffoldState;
            int i6 = this.$$dirty1;
            SurfaceKt.m1620SurfaceFjzlyU(childModifier, (Shape) null, j, j2, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composer, -1128984656, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C180@8164L413:Scaffold.kt#jmzs0o");
                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1128984656, $changed, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:179)");
                        }
                        boolean z = z2;
                        int i = i3;
                        Function2<Composer, Integer, Unit> function2 = function24;
                        Function3<PaddingValues, Composer, Integer, Unit> function3 = function32;
                        final Function3<SnackbarHostState, Composer, Integer, Unit> function32 = function33;
                        final ScaffoldState scaffoldState = scaffoldState;
                        final int i2 = i4;
                        Function2<Composer, Integer, Unit> function22 = function25;
                        Function2<Composer, Integer, Unit> function23 = function26;
                        int i3 = i4;
                        ScaffoldKt.m1590ScaffoldLayoutMDYNRJg(z, i, function2, function3, ComposableLambdaKt.composableLambda($composer, 533782017, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                invoke((Composer) p1, ((Number) p2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer, int $changed) {
                                ComposerKt.sourceInformation($composer, "C186@8417L45:Scaffold.kt#jmzs0o");
                                if (($changed & 11) != 2 || !$composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(533782017, $changed, -1, "androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:185)");
                                    }
                                    function32.invoke(scaffoldState.getSnackbarHostState(), $composer, Integer.valueOf((i2 >> 9) & 112));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer.skipToGroupEnd();
                            }
                        }), function22, function23, $composer, ((i3 >> 21) & 14) | 24576 | ((i3 >> 15) & 112) | (i3 & 896) | ((i5 >> 12) & 7168) | (458752 & i3) | ((i3 << 9) & 3670016));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }), $composer, 1572864 | ($dirty2 & 14) | ((i6 >> 9) & 896) | ((i6 >> 9) & 7168), 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
