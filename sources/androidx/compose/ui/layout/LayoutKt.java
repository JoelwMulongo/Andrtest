package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\bø\u0001\u0000¢\u0006\u0002\u0010\n\u001a \u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\b¢\u0006\u0002\u0010\u000b\u001a>\u0010\u0000\u001a\u00020\u00012\u001c\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00050\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000eH\b¢\u0006\u0002\u0010\u000f\u001a7\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0011\u001a;\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u001c\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00050\rH\u0001¢\u0006\u0002\u0010\u0013\u001a4\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0001ø\u0001\u0001¢\u0006\u0002\u0010\u0019\u0002\u000b\n\u0005\b20\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Layout", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "contents", "", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MultiContentMeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "MultiMeasureLayout", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "combineAsVirtualLayouts", "(Ljava/util/List;)Lkotlin/jvm/functions/Function2;", "materializerOf", "Lkotlin/Function1;", "Landroidx/compose/runtime/SkippableUpdater;", "Landroidx/compose/ui/node/ComposeUiNode;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;)Lkotlin/jvm/functions/Function3;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Layout.kt */
public final class LayoutKt {
    public static final void Layout(Function2<? super Composer, ? super Integer, Unit> content, Modifier modifier, MeasurePolicy measurePolicy, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        $composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation($composer, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
        if ((i & 2) != 0) {
            modifier = Modifier.Companion;
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd($composer);
        LayoutDirection layoutDirection = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3 = $composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd($composer);
        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
        Function0 factory$iv = ComposeUiNode.Companion.getConstructor();
        Function3 skippableUpdate$iv = materializerOf(modifier);
        int $changed$iv = (($changed << 9) & 7168) | 6;
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            $composer.createNode(factory$iv);
        } else {
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240 = Updater.m2787constructorimpl($composer);
        Updater.m2794setimpl($this$Layout_u24lambda_u240, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m2794setimpl($this$Layout_u24lambda_u240, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m2794setimpl($this$Layout_u24lambda_u240, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m2794setimpl($this$Layout_u24lambda_u240, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        skippableUpdate$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), $composer, Integer.valueOf(($changed$iv >> 3) & 112));
        $composer.startReplaceableGroup(2058660585);
        content.invoke($composer, Integer.valueOf(($changed$iv >> 9) & 14));
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
    }

    public static final void Layout(Modifier modifier, MeasurePolicy measurePolicy, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        $composer.startReplaceableGroup(544976794);
        ComposerKt.sourceInformation($composer, "CC(Layout)P(1)119@4537L7,120@4592L7,121@4651L7,123@4724L439:Layout.kt#80mrfh");
        if ((i & 1) != 0) {
            modifier = Modifier.Companion;
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd($composer);
        LayoutDirection layoutDirection = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3 = $composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd($composer);
        ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
        Modifier materialized = ComposedModifierKt.materialize($composer, modifier);
        Function0 factory$iv = ComposeUiNode.Companion.getConstructor();
        $composer.startReplaceableGroup(1405779621);
        ComposerKt.sourceInformation($composer, "CC(ReusableComposeNode):Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            $composer.createNode(new LayoutKt$Layout$$inlined$ReusableComposeNode$1(factory$iv));
        } else {
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u241 = Updater.m2787constructorimpl($composer);
        Updater.m2794setimpl($this$Layout_u24lambda_u241, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m2794setimpl($this$Layout_u24lambda_u241, density, ComposeUiNode.Companion.getSetDensity());
        Updater.m2794setimpl($this$Layout_u24lambda_u241, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m2794setimpl($this$Layout_u24lambda_u241, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
        Updater.m2794setimpl($this$Layout_u24lambda_u241, materialized, ComposeUiNode.Companion.getSetModifier());
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }

    public static final void Layout(List<? extends Function2<? super Composer, ? super Integer, Unit>> contents, Modifier modifier, MultiContentMeasurePolicy measurePolicy, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        MultiContentMeasurePolicy multiContentMeasurePolicy = measurePolicy;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(contents, "contents");
        Intrinsics.checkNotNullParameter(multiContentMeasurePolicy, "measurePolicy");
        composer.startReplaceableGroup(1399185516);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)169@6767L62,166@6653L182:Layout.kt#80mrfh");
        Modifier modifier2 = (i & 2) != 0 ? Modifier.Companion : modifier;
        Function2 content$iv = combineAsVirtualLayouts(contents);
        int i2 = ($changed >> 6) & 14;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) multiContentMeasurePolicy);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = MultiContentMeasurePolicyKt.createMeasurePolicy(measurePolicy);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        MeasurePolicy measurePolicy$iv = (MeasurePolicy) value$iv$iv;
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density$iv = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd($composer);
        LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd($composer);
        ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
        Function0 factory$iv$iv = ComposeUiNode.Companion.getConstructor();
        Function3 skippableUpdate$iv$iv = materializerOf(modifier2);
        int $changed$iv$iv = ((($changed & 112) << 9) & 7168) | 6;
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            composer.createNode(factory$iv$iv);
        } else {
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv = Updater.m2787constructorimpl($composer);
        Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
        Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
        skippableUpdate$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        content$iv.invoke(composer, Integer.valueOf(($changed$iv$iv >> 9) & 14));
        $composer.endReplaceableGroup();
        $composer.endNode();
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
    }

    public static final Function2<Composer, Integer, Unit> combineAsVirtualLayouts(List<? extends Function2<? super Composer, ? super Integer, Unit>> contents) {
        Intrinsics.checkNotNullParameter(contents, "contents");
        return ComposableLambdaKt.composableLambdaInstance(-1953651383, true, new LayoutKt$combineAsVirtualLayouts$1(contents));
    }

    public static final Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        return ComposableLambdaKt.composableLambdaInstance(-1586257396, true, new LayoutKt$materializerOf$1(modifier));
    }

    @Deprecated(message = "This API is unsafe for UI performance at scale - using it incorrectly will lead to exponential performance issues. This API should be avoided whenever possible.")
    public static final void MultiMeasureLayout(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, MeasurePolicy measurePolicy, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        MeasurePolicy measurePolicy2 = measurePolicy;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function2, "content");
        Intrinsics.checkNotNullParameter(measurePolicy2, "measurePolicy");
        Composer $composer2 = $composer.startRestartGroup(1949933075);
        ComposerKt.sourceInformation($composer2, "C(MultiMeasureLayout)P(2)209@7989L7,210@8044L7,211@8103L7,213@8116L545:Layout.kt#80mrfh");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i2 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if ((i2 & 112) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if ((i2 & 896) == 0) {
            $dirty |= $composer2.changed((Object) measurePolicy2) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1949933075, $dirty2, -1, "androidx.compose.ui.layout.MultiMeasureLayout (Layout.kt:203)");
            }
            Modifier materialized = ComposedModifierKt.materialize($composer2, modifier4);
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration = (ViewConfiguration) consume3;
            Function0 factory$iv = LayoutNode.Companion.getConstructor$ui_release();
            int $changed$iv = (($dirty2 << 3) & 896) | 6;
            $composer2.startReplaceableGroup(-692256719);
            ComposerKt.sourceInformation($composer2, "CC(ReusableComposeNode)P(1,2)372@13941L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv);
            } else {
                $composer2.useNode();
            }
            Composer $this$MultiMeasureLayout_u24lambda_u243 = Updater.m2787constructorimpl($composer2);
            Updater.m2794setimpl($this$MultiMeasureLayout_u24lambda_u243, materialized, ComposeUiNode.Companion.getSetModifier());
            Updater.m2794setimpl($this$MultiMeasureLayout_u24lambda_u243, measurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$MultiMeasureLayout_u24lambda_u243, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$MultiMeasureLayout_u24lambda_u243, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$MultiMeasureLayout_u24lambda_u243, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            Updater.m2791initimpl($this$MultiMeasureLayout_u24lambda_u243, LayoutKt$MultiMeasureLayout$1$1.INSTANCE);
            function2.invoke($composer2, Integer.valueOf(($changed$iv >> 6) & 14));
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LayoutKt$MultiMeasureLayout$2(modifier3, content, measurePolicy, $changed, i));
        }
    }
}
