package androidx.compose.ui.tooling;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewRootForTest;
import androidx.compose.ui.tooling.animation.PreviewAnimationClock;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeViewAdapter.kt */
final class ComposeViewAdapter$init$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ long $animationClockStartTime;
    final /* synthetic */ String $className;
    final /* synthetic */ String $methodName;
    final /* synthetic */ Function0<Unit> $onCommit;
    final /* synthetic */ Class<? extends PreviewParameterProvider<?>> $parameterProvider;
    final /* synthetic */ int $parameterProviderIndex;
    final /* synthetic */ ComposeViewAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComposeViewAdapter$init$3(Function0<Unit> function0, ComposeViewAdapter composeViewAdapter, long j, String str, String str2, Class<? extends PreviewParameterProvider<?>> cls, int i) {
        super(2);
        this.$onCommit = function0;
        this.this$0 = composeViewAdapter;
        this.$animationClockStartTime = j;
        this.$className = str;
        this.$methodName = str2;
        this.$parameterProvider = cls;
        this.$parameterProviderIndex = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C499@19077L20,501@19111L2532:ComposeViewAdapter.kt#hevd2p");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1704541905, $changed, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.init.<anonymous> (ComposeViewAdapter.kt:498)");
            }
            EffectsKt.SideEffect(this.$onCommit, $composer, 0);
            ComposeViewAdapter composeViewAdapter = this.this$0;
            final long j = this.$animationClockStartTime;
            final ComposeViewAdapter composeViewAdapter2 = this.this$0;
            final String str = this.$className;
            final String str2 = this.$methodName;
            final Class<? extends PreviewParameterProvider<?>> cls = this.$parameterProvider;
            final int i = this.$parameterProviderIndex;
            composeViewAdapter.WrapPreview(ComposableLambdaKt.composableLambda($composer, 1938351266, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C:ComposeViewAdapter.kt#hevd2p");
                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1938351266, $changed, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.init.<anonymous>.<anonymous> (ComposeViewAdapter.kt:501)");
                        }
                        Function0 composable = new ComposeViewAdapter$init$3$1$composable$1(str, str2, $composer, cls, i, composeViewAdapter2);
                        if (j >= 0) {
                            ComposeViewAdapter composeViewAdapter = composeViewAdapter2;
                            final ComposeViewAdapter composeViewAdapter2 = composeViewAdapter2;
                            composeViewAdapter.setClock$ui_tooling_release(new PreviewAnimationClock(new Function0<Unit>() {
                                public final void invoke() {
                                    View childAt = composeViewAdapter2.getChildAt(0);
                                    Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.compose.ui.platform.ComposeView");
                                    View childAt2 = ((ComposeView) childAt).getChildAt(0);
                                    ViewRootForTest viewRootForTest = childAt2 instanceof ViewRootForTest ? (ViewRootForTest) childAt2 : null;
                                    if (viewRootForTest != null) {
                                        viewRootForTest.invalidateDescendants();
                                    }
                                    Snapshot.Companion.sendApplyNotifications();
                                }
                            }));
                        }
                        composable.invoke();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }), $composer, 70);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
