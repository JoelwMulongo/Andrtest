package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.FabPrimaryTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: FloatingActionButton.kt */
final class FloatingActionButtonKt$ExtendedFloatingActionButton$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FloatingActionButtonKt$ExtendedFloatingActionButton$5(boolean z, Function2<? super Composer, ? super Integer, Unit> function2, int i, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.$expanded = z;
        this.$icon = function2;
        this.$$dirty = i;
        this.$text = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        float f;
        Composer $composer$iv;
        Composer $composer2;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C359@18094L838:FloatingActionButton.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1172118032, i, -1, "androidx.compose.material3.ExtendedFloatingActionButton.<anonymous> (FloatingActionButton.kt:355)");
            }
            float startPadding = this.$expanded ? FloatingActionButtonKt.ExtendedFabStartIconPadding : Dp.m5986constructorimpl((float) 0);
            float endPadding = this.$expanded ? FloatingActionButtonKt.ExtendedFabTextPadding : Dp.m5986constructorimpl((float) 0);
            Modifier modifier = Modifier.Companion;
            if (this.$expanded) {
                f = FloatingActionButtonKt.ExtendedFabMinimumWidth;
            } else {
                f = FabPrimaryTokens.INSTANCE.m2412getContainerWidthD9Ej5fM();
            }
            Modifier r3 = PaddingKt.m764paddingqDBjuR0$default(SizeKt.m834sizeInqDBjuR0$default(modifier, f, 0.0f, 0.0f, 0.0f, 14, (Object) null), startPadding, 0.0f, endPadding, 0.0f, 10, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal start = this.$expanded ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getCenter();
            Function2<Composer, Integer, Unit> function2 = this.$icon;
            int i2 = this.$$dirty;
            boolean z = this.$expanded;
            Function2<Composer, Integer, Unit> function22 = this.$text;
            composer.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composer, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(start, centerVertically, composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r3);
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
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer3 = $composer;
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            $composer3.startReplaceableGroup(-678309503);
            ComposerKt.sourceInformation($composer3, "C80@3988L9:Row.kt#2w3rfo");
            if (($changed$iv & 11) != 2 || !$composer3.getSkipping()) {
                int $changed2 = ((384 >> 6) & 112) | 6;
                RowScope $this$invoke_u24lambda_u2d0 = RowScopeInstance.INSTANCE;
                Composer composer2 = $composer3;
                Composer $composer$iv2 = $composer3;
                $composer3.startReplaceableGroup(1368928116);
                ComposerKt.sourceInformation($composer3, "C369@18542L6,370@18561L361:FloatingActionButton.kt#uh7d8r");
                int $dirty = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty |= $composer3.changed((Object) $this$invoke_u24lambda_u2d0) ? 4 : 2;
                }
                int i3 = $changed$iv;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
                if (($dirty & 91) != 18 || !$composer3.getSkipping()) {
                    function2.invoke($composer3, Integer.valueOf((i2 >> 3) & 14));
                    Function0<ComposeUiNode> function0 = constructor;
                    int i4 = ($dirty & 14) | 1600512 | ((i2 >> 9) & 112);
                    $composer2 = $composer3;
                    $composer$iv = $composer$iv2;
                    LayoutDirection layoutDirection = layoutDirection$iv$iv;
                    Density density = density$iv$iv;
                    AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u2d0, z, (Modifier) null, FloatingActionButtonKt.ExtendedFabExpandAnimation, FloatingActionButtonKt.ExtendedFabCollapseAnimation, (String) null, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer3, 176242764, true, new FloatingActionButtonKt$ExtendedFloatingActionButton$5$1$1(function22, i2)), $composer2, i4, 18);
                } else {
                    $composer3.skipToGroupEnd();
                    Function0<ComposeUiNode> function02 = constructor;
                    $composer2 = $composer3;
                    LayoutDirection layoutDirection2 = layoutDirection$iv$iv;
                    Density density2 = density$iv$iv;
                    $composer$iv = $composer$iv2;
                }
                $composer2.endReplaceableGroup();
            } else {
                $composer3.skipToGroupEnd();
                int i5 = $changed$iv;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = materializerOf;
                Function0<ComposeUiNode> function03 = constructor;
                $composer$iv = $composer3;
                LayoutDirection layoutDirection3 = layoutDirection$iv$iv;
                Density density3 = density$iv$iv;
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
