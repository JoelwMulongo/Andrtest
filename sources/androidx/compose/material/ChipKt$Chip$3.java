package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
final class ChipKt$Chip$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ ChipColors $colors;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ State<Color> $contentColor$delegate;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipKt$Chip$3(State<Color> state, Function2<? super Composer, ? super Integer, Unit> function2, ChipColors chipColors, boolean z, int i, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$contentColor$delegate = state;
        this.$leadingIcon = function2;
        this.$colors = chipColors;
        this.$enabled = z;
        this.$$dirty = i;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C109@4864L1442:Chip.kt#jmzs0o");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(139076687, $changed, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:108)");
            }
            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3166getAlphaimpl(ChipKt.Chip$lambda$1(this.$contentColor$delegate))))};
            final Function2<Composer, Integer, Unit> function2 = this.$leadingIcon;
            final ChipColors chipColors = this.$colors;
            final boolean z = this.$enabled;
            final int i = this.$$dirty;
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.$content;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer, 667535631, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C111@5006L10,110@4950L1346:Chip.kt#jmzs0o");
                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(667535631, $changed, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:109)");
                        }
                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography($composer, 6).getBody2();
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final ChipColors chipColors = chipColors;
                        final boolean z = z;
                        final int i = i;
                        final Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda($composer, -1131213696, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                invoke((Composer) p1, ((Number) p2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer, int $changed) {
                                float f;
                                Composer composer = $composer;
                                int i = $changed;
                                ComposerKt.sourceInformation(composer, "C113@5055L1227:Chip.kt#jmzs0o");
                                if ((i & 11) != 2 || !$composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1131213696, i, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:112)");
                                    }
                                    Modifier r9 = SizeKt.m815defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, ChipDefaults.INSTANCE.m1431getMinHeightD9Ej5fM(), 1, (Object) null);
                                    if (function2 == null) {
                                        f = ChipKt.HorizontalPadding;
                                    } else {
                                        f = Dp.m5986constructorimpl((float) 0);
                                    }
                                    Modifier modifier$iv = PaddingKt.m764paddingqDBjuR0$default(r9, f, 0.0f, ChipKt.HorizontalPadding, 0.0f, 10, (Object) null);
                                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function2 = function2;
                                    ChipColors chipColors = chipColors;
                                    boolean z = z;
                                    int i2 = i;
                                    Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                                    composer.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
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
                                    Arrangement.Horizontal horizontal = horizontalArrangement$iv;
                                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                                    Modifier modifier = modifier$iv;
                                    Alignment.Vertical vertical = verticalAlignment$iv;
                                    int $changed$iv$iv$iv = ((((432 << 3) & 112) << 9) & 7168) | 6;
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
                                    Composer $composer$iv = $composer;
                                    ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                                    ComposerKt.sourceInformationMarkerStart($composer$iv, -326682283, "C80@4021L9:Row.kt#2w3rfo");
                                    int $changed2 = ((432 >> 6) & 112) | 6;
                                    RowScope $this$invoke_u24lambda_u241 = RowScopeInstance.INSTANCE;
                                    LayoutDirection layoutDirection = layoutDirection$iv$iv;
                                    int i3 = $changed$iv$iv$iv;
                                    int i4 = ($changed$iv$iv$iv >> 9) & 14;
                                    Composer $composer2 = $composer$iv;
                                    ComposerKt.sourceInformationMarkerStart($composer2, 2084788907, "C137@6255L9:Chip.kt#jmzs0o");
                                    $composer2.startReplaceableGroup(2084788907);
                                    ComposerKt.sourceInformation($composer2, "128@5708L47,129@5818L32,130@5875L267,135@6167L45");
                                    if (function2 != null) {
                                        SpacerKt.Spacer(SizeKt.m835width3ABfNKs(Modifier.Companion, ChipKt.LeadingIconStartSpacing), $composer2, 6);
                                        State leadingIconContentColor$delegate = chipColors.leadingIconContentColor(z, $composer2, ((i2 >> 6) & 14) | ((i2 >> 15) & 112));
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(invoke$lambda$1$lambda$0(leadingIconContentColor$delegate))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3166getAlphaimpl(invoke$lambda$1$lambda$0(leadingIconContentColor$delegate))))}, (Function2<? super Composer, ? super Integer, Unit>) function2, $composer2, ((i2 >> 18) & 112) | 8);
                                        SpacerKt.Spacer(SizeKt.m835width3ABfNKs(Modifier.Companion, ChipKt.LeadingIconEndSpacing), $composer2, 6);
                                    }
                                    $composer2.endReplaceableGroup();
                                    function3.invoke($this$invoke_u24lambda_u241, $composer2, Integer.valueOf(($changed2 & 14) | ((i2 >> 21) & 112)));
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
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

                            private static final long invoke$lambda$1$lambda$0(State<Color> $leadingIconContentColor$delegate) {
                                return ((Color) $leadingIconContentColor$delegate.getValue()).m3174unboximpl();
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
