package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextFieldImpl.kt */
final class TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ Function2<Composer, Integer, Unit> $container;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ MutableState<Size> $labelSize;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1(MutableState<Size> mutableState, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$labelSize = mutableState;
        this.$contentPadding = paddingValues;
        this.$container = function2;
        this.$$dirty1 = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C195@8236L302:TextFieldImpl.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(787383072, i, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:194)");
            }
            Modifier modifier$iv = OutlinedTextFieldKt.m2032outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.ContainerId), this.$labelSize.getValue().m2989unboximpl(), this.$contentPadding);
            Function2<Composer, Integer, Unit> function2 = this.$container;
            int i2 = this.$$dirty1;
            composer.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv$iv = ((((384 << 3) & 112) << 9) & 7168) | 6;
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                $composer.useNode();
            }
            $composer.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            $composer$iv.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation($composer$iv, "C72@3384L9:Box.kt#2w3rfo");
            if (($changed$iv & 11) != 2 || !$composer$iv.getSkipping()) {
                int $changed2 = ((384 >> 6) & 112) | 6;
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i3 = $changed$iv;
                Composer $composer2 = $composer$iv;
                $composer2.startReplaceableGroup(1492929242);
                ComposerKt.sourceInformation($composer2, "C201@8505L11:TextFieldImpl.kt#uh7d8r");
                int i4 = $changed2;
                if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                    function2.invoke($composer2, Integer.valueOf((i2 >> 15) & 14));
                } else {
                    $composer2.skipToGroupEnd();
                }
                $composer2.endReplaceableGroup();
            } else {
                $composer$iv.skipToGroupEnd();
                int i5 = $changed$iv;
            }
            $composer$iv.endReplaceableGroup();
            $composer.endReplaceableGroup();
            $composer.endNode();
            $composer.endReplaceableGroup();
            $composer.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
