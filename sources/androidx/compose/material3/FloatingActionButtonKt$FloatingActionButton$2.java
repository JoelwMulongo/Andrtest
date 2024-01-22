package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.ExtendedFabPrimaryTokens;
import androidx.compose.material3.tokens.FabPrimaryTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: FloatingActionButton.kt */
final class FloatingActionButtonKt$FloatingActionButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FloatingActionButtonKt$FloatingActionButton$2(long j, Function2<? super Composer, ? super Integer, Unit> function2, int i) {
        super(2);
        this.$contentColor = j;
        this.$content = function2;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C113@5574L933:FloatingActionButton.kt#uh7d8r");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1249316354, $changed, -1, "androidx.compose.material3.FloatingActionButton.<anonymous> (FloatingActionButton.kt:112)");
            }
            ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(this.$contentColor))};
            final Function2<Composer, Integer, Unit> function2 = this.$content;
            final int i = this.$$dirty;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer, -945978686, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C119@6042L10,118@5994L503:FloatingActionButton.kt#uh7d8r");
                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-945978686, $changed, -1, "androidx.compose.material3.FloatingActionButton.<anonymous>.<anonymous> (FloatingActionButton.kt:113)");
                        }
                        TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer, 6), ExtendedFabPrimaryTokens.INSTANCE.getLabelTextFont());
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final int i = i;
                        TextKt.ProvideTextStyle(fromToken, ComposableLambdaKt.composableLambda($composer, 167946739, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                invoke((Composer) p1, ((Number) p2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer, int $changed) {
                                Composer composer = $composer;
                                int i = $changed;
                                ComposerKt.sourceInformation(composer, "C121@6136L347:FloatingActionButton.kt#uh7d8r");
                                if ((i & 11) != 2 || !$composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(167946739, i, -1, "androidx.compose.material3.FloatingActionButton.<anonymous>.<anonymous>.<anonymous> (FloatingActionButton.kt:120)");
                                    }
                                    Modifier modifier$iv = SizeKt.m814defaultMinSizeVpY3zN4(Modifier.Companion, FabPrimaryTokens.INSTANCE.m2412getContainerWidthD9Ej5fM(), FabPrimaryTokens.INSTANCE.m2411getContainerHeightD9Ej5fM());
                                    Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                                    Function2<Composer, Integer, Unit> function2 = function2;
                                    int i2 = i;
                                    composer.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
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
                                    int $changed$iv$iv$iv = ((((54 << 3) & 112) << 9) & 7168) | 6;
                                    Alignment alignment = contentAlignment$iv;
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
                                        int $changed2 = ((54 >> 6) & 112) | 6;
                                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                        int i3 = $changed$iv;
                                        Composer $composer2 = $composer$iv;
                                        $composer2.startReplaceableGroup(595057145);
                                        ComposerKt.sourceInformation($composer2, "C128@6472L9:FloatingActionButton.kt#uh7d8r");
                                        int i4 = $changed2;
                                        if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                            function2.invoke($composer2, Integer.valueOf((i2 >> 21) & 14));
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
                        }), $composer, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }), $composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
