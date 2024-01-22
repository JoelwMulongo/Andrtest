package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"TestModifierUpdaterLayout", "", "onAttached", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/TestModifierUpdater;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TestModifierUpdater.kt */
public final class TestModifierUpdaterKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "It is a test API, do not use it in the real applications")
    public static final void TestModifierUpdaterLayout(Function1<? super TestModifierUpdater, Unit> onAttached, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(onAttached, "onAttached");
        Composer $composer2 = $composer.startRestartGroup(-1673066036);
        ComposerKt.sourceInformation($composer2, "C(TestModifierUpdaterLayout)49@1621L237:TestModifierUpdater.kt#80mrfh");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(onAttached) ? 4 : 2;
        }
        if (($dirty & 11) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1673066036, $changed, -1, "androidx.compose.ui.layout.TestModifierUpdaterLayout (TestModifierUpdater.kt:45)");
            }
            MeasurePolicy measurePolicy = TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1.INSTANCE;
            Function0 factory$iv = LayoutNode.Companion.getConstructor$ui_release();
            $composer2.startReplaceableGroup(1886828752);
            ComposerKt.sourceInformation($composer2, "CC(ComposeNode):Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(new TestModifierUpdaterKt$TestModifierUpdaterLayout$$inlined$ComposeNode$1(factory$iv));
            } else {
                $composer2.useNode();
            }
            Composer $this$TestModifierUpdaterLayout_u24lambda_u240 = Updater.m2787constructorimpl($composer2);
            Updater.m2794setimpl($this$TestModifierUpdaterLayout_u24lambda_u240, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2791initimpl($this$TestModifierUpdaterLayout_u24lambda_u240, new TestModifierUpdaterKt$TestModifierUpdaterLayout$1$1(onAttached));
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TestModifierUpdaterKt$TestModifierUpdaterLayout$2(onAttached, $changed));
        }
    }
}
