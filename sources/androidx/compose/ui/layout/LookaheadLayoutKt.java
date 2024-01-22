package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"LookaheadLayout", "", "content", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LookaheadLayoutScope;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadLayout.kt */
public final class LookaheadLayoutKt {
    public static final void LookaheadLayout(Function3<? super LookaheadLayoutScope, ? super Composer, ? super Integer, Unit> content, Modifier modifier, MeasurePolicy measurePolicy, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Object value$iv$iv;
        Function3<? super LookaheadLayoutScope, ? super Composer, ? super Integer, Unit> function3 = content;
        MeasurePolicy measurePolicy2 = measurePolicy;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function3, "content");
        Intrinsics.checkNotNullParameter(measurePolicy2, "measurePolicy");
        Composer $composer2 = $composer.startRestartGroup(1697006219);
        ComposerKt.sourceInformation($composer2, "C(LookaheadLayout)P(!1,2)73@3231L7,74@3286L7,75@3345L7,77@3370L39,78@3414L657:LookaheadLayout.kt#80mrfh");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
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
                ComposerKt.traceEventStart(1697006219, $dirty2, -1, "androidx.compose.ui.layout.LookaheadLayout (LookaheadLayout.kt:67)");
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
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            Modifier modifier5 = modifier4;
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new LookaheadLayoutScopeImpl();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            LookaheadLayoutScopeImpl scope = (LookaheadLayoutScopeImpl) value$iv$iv;
            Function0 factory$iv = LayoutNode.Companion.getConstructor$ui_release();
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
            Composer $this$LookaheadLayout_u24lambda_u241 = Updater.m2787constructorimpl($composer2);
            Updater.m2794setimpl($this$LookaheadLayout_u24lambda_u241, materialized, ComposeUiNode.Companion.getSetModifier());
            Updater.m2794setimpl($this$LookaheadLayout_u24lambda_u241, measurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$LookaheadLayout_u24lambda_u241, density, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$LookaheadLayout_u24lambda_u241, layoutDirection, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$LookaheadLayout_u24lambda_u241, viewConfiguration, ComposeUiNode.Companion.getSetViewConfiguration());
            Updater.m2794setimpl($this$LookaheadLayout_u24lambda_u241, scope, LookaheadLayoutKt$LookaheadLayout$1$1.INSTANCE);
            Updater.m2791initimpl($this$LookaheadLayout_u24lambda_u241, LookaheadLayoutKt$LookaheadLayout$1$2.INSTANCE);
            int i4 = (6 >> 6) & 14;
            Composer $composer3 = $composer2;
            Modifier modifier6 = materialized;
            Density density2 = density;
            ComposerKt.sourceInformationMarkerStart($composer3, -1853566040, "C94@4046L9:LookaheadLayout.kt#80mrfh");
            function3.invoke(scope, $composer3, Integer.valueOf((($dirty2 << 3) & 112) | 8));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LookaheadLayoutKt$LookaheadLayout$3(content, modifier3, measurePolicy, $changed, i));
        }
    }
}
