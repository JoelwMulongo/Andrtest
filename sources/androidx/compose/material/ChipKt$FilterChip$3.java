package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
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
final class ChipKt$FilterChip$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ SelectableChipColors $colors;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ State<Color> $contentColor;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ Function2<Composer, Integer, Unit> $selectedIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipKt$FilterChip$3(State<Color> state, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i, SelectableChipColors selectableChipColors, boolean z2, int i2) {
        super(2);
        this.$contentColor = state;
        this.$leadingIcon = function2;
        this.$selected = z;
        this.$selectedIcon = function22;
        this.$trailingIcon = function23;
        this.$content = function3;
        this.$$dirty1 = i;
        this.$colors = selectableChipColors;
        this.$enabled = z2;
        this.$$dirty = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C210@9657L3645:Chip.kt#jmzs0o");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(722126431, i, -1, "androidx.compose.material.FilterChip.<anonymous> (Chip.kt:209)");
            }
            ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3166getAlphaimpl(this.$contentColor.getValue().m3174unboximpl())))};
            final Function2<Composer, Integer, Unit> function2 = this.$leadingIcon;
            final boolean z = this.$selected;
            final Function2<Composer, Integer, Unit> function22 = this.$selectedIcon;
            final Function2<Composer, Integer, Unit> function23 = this.$trailingIcon;
            final Function3<RowScope, Composer, Integer, Unit> function3 = this.$content;
            final int i2 = this.$$dirty1;
            final SelectableChipColors selectableChipColors = this.$colors;
            final boolean z2 = this.$enabled;
            int i3 = this.$$dirty;
            final State<Color> state = this.$contentColor;
            final int i4 = i3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 1582291359, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "C212@9805L10,211@9749L3543:Chip.kt#jmzs0o");
                    if (($changed & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1582291359, $changed, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:210)");
                        }
                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography($composer, 6).getBody2();
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final boolean z = z;
                        final Function2<Composer, Integer, Unit> function22 = function22;
                        final Function2<Composer, Integer, Unit> function23 = function23;
                        final Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                        final int i = i2;
                        final SelectableChipColors selectableChipColors = selectableChipColors;
                        final boolean z2 = z2;
                        final int i2 = i4;
                        final State<Color> state = state;
                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda($composer, -1543702066, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                invoke((Composer) p1, ((Number) p2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer, int $changed) {
                                float f;
                                float f2;
                                int $changed2;
                                RowScope $this$invoke_u24lambda_u242;
                                Composer $composer$iv;
                                Composer composer = $composer;
                                int i = $changed;
                                ComposerKt.sourceInformation(composer, "C214@9854L3424:Chip.kt#jmzs0o");
                                if ((i & 11) != 2 || !$composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1543702066, i, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:213)");
                                    }
                                    Modifier r9 = SizeKt.m815defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, ChipDefaults.INSTANCE.m1431getMinHeightD9Ej5fM(), 1, (Object) null);
                                    if (function2 != null || (z && function22 != null)) {
                                        f = Dp.m5986constructorimpl((float) 0);
                                    } else {
                                        f = ChipKt.HorizontalPadding;
                                    }
                                    if (function23 == null) {
                                        f2 = ChipKt.HorizontalPadding;
                                    } else {
                                        f2 = Dp.m5986constructorimpl((float) 0);
                                    }
                                    Modifier modifier$iv = PaddingKt.m764paddingqDBjuR0$default(r9, f, 0.0f, f2, 0.0f, 10, (Object) null);
                                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function2 = function2;
                                    boolean z = z;
                                    Function2<Composer, Integer, Unit> function22 = function22;
                                    Function3<RowScope, Composer, Integer, Unit> function3 = function3;
                                    int i2 = i;
                                    Function2<Composer, Integer, Unit> function23 = function23;
                                    SelectableChipColors selectableChipColors = selectableChipColors;
                                    boolean z2 = z2;
                                    int i3 = i2;
                                    State<Color> state = state;
                                    composer.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                                    composer.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                    Arrangement.Horizontal horizontal = horizontalArrangement$iv;
                                    Alignment.Vertical vertical = verticalAlignment$iv;
                                    Function2<Composer, Integer, Unit> function24 = function23;
                                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    Density density$iv$iv = (Density) consume;
                                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                                    int i4 = i2;
                                    ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                    Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
                                    Modifier modifier = modifier$iv;
                                    State<Color> state2 = state;
                                    int $changed$iv$iv$iv = ((((432 << 3) & 112) << 9) & 7168) | 6;
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = materializerOf;
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
                                    MeasurePolicy measurePolicy = measurePolicy$iv;
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = function33;
                                    function34.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                    composer.startReplaceableGroup(2058660585);
                                    int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
                                    int i5 = $changed$iv$iv$iv;
                                    Composer $composer$iv2 = $composer;
                                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -326682283, "C80@4021L9:Row.kt#2w3rfo");
                                    int $changed3 = ((432 >> 6) & 112) | 6;
                                    RowScope $this$invoke_u24lambda_u2422 = RowScopeInstance.INSTANCE;
                                    Density density = density$iv$iv;
                                    LayoutDirection layoutDirection = layoutDirection$iv$iv;
                                    ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                                    Composer $composer2 = $composer$iv2;
                                    ComposerKt.sourceInformationMarkerStart($composer2, -1943412077, "C276@13006L9:Chip.kt#jmzs0o");
                                    $composer2.startReplaceableGroup(-1943412077);
                                    ComposerKt.sourceInformation($composer2, "237@10866L47,238@10938L1955,274@12918L45");
                                    if (function2 != null || (z && function22 != null)) {
                                        SpacerKt.Spacer(SizeKt.m835width3ABfNKs(Modifier.Companion, ChipKt.LeadingIconStartSpacing), $composer2, 6);
                                        $composer2.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                        int i6 = $changed$iv;
                                        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                                        $composer$iv = $composer$iv2;
                                        MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                        $composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        Alignment alignment = contentAlignment$iv;
                                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume4 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
                                        ComposerKt.sourceInformationMarkerEnd($composer2);
                                        Density density$iv$iv2 = (Density) consume4;
                                        $this$invoke_u24lambda_u242 = $this$invoke_u24lambda_u2422;
                                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume5 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                        ComposerKt.sourceInformationMarkerEnd($composer2);
                                        LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                                        $changed2 = $changed3;
                                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume6 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                        ComposerKt.sourceInformationMarkerEnd($composer2);
                                        ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                                        String str = "C:CompositionLocal.kt#9igjgp";
                                        int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(Modifier.Companion);
                                        String str2 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
                                        if (!($composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer2.startReusableNode();
                                        if ($composer2.getInserting()) {
                                            $composer2.createNode(constructor2);
                                        } else {
                                            $composer2.useNode();
                                        }
                                        $composer2.disableReusing();
                                        Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2787constructorimpl($composer2);
                                        Function0<ComposeUiNode> function02 = constructor2;
                                        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                                        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                                        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                                        $composer2.enableReusing();
                                        LayoutDirection layoutDirection2 = layoutDirection$iv$iv2;
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function36 = materializerOf2;
                                        function36.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                                        $composer2.startReplaceableGroup(2058660585);
                                        Composer $composer$iv3 = $composer2;
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function37 = function36;
                                        MeasurePolicy measurePolicy2 = measurePolicy$iv2;
                                        ComposerKt.sourceInformationMarkerStart($composer$iv3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                                        int i7 = ((0 >> 6) & 112) | 6;
                                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                        int i8 = ($changed$iv$iv$iv2 >> 9) & 14;
                                        Density density2 = density$iv$iv2;
                                        Composer $composer3 = $composer$iv3;
                                        ComposerKt.sourceInformationMarkerStart($composer3, 649985655, "C:Chip.kt#jmzs0o");
                                        $composer3.startReplaceableGroup(649985655);
                                        ComposerKt.sourceInformation($composer3, "240@11061L141,244@11235L297");
                                        if (function2 != null) {
                                            State leadingIconColor = selectableChipColors.leadingIconColor(z2, z, $composer3, ((i3 >> 9) & 14) | ((i3 << 3) & 112) | ((i3 >> 15) & 896));
                                            ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv2;
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(leadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m3166getAlphaimpl(leadingIconColor.getValue().m3174unboximpl())))}, (Function2<? super Composer, ? super Integer, Unit>) function2, $composer3, ((i3 >> 21) & 112) | 8);
                                        }
                                        $composer3.endReplaceableGroup();
                                        $composer2.startReplaceableGroup(-1943411263);
                                        ComposerKt.sourceInformation($composer2, "263@12386L451");
                                        if (!z || function22 == null) {
                                        } else {
                                            Modifier overlayModifier = Modifier.Companion;
                                            long iconColor = state2.getValue().m3174unboximpl();
                                            $composer3.startReplaceableGroup(649986486);
                                            ComposerKt.sourceInformation($composer3, "261@12279L34");
                                            if (function2 != null) {
                                                overlayModifier = ClipKt.clip(BackgroundKt.m448backgroundbw27NRU(SizeKt.m822requiredSize3ABfNKs(Modifier.Companion, ChipKt.SelectedIconContainerSize), state2.getValue().m3174unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                                                iconColor = selectableChipColors.backgroundColor(z2, z, $composer3, ((i3 >> 9) & 14) | ((i3 << 3) & 112) | ((i3 >> 15) & 896)).getValue().m3174unboximpl();
                                            }
                                            $composer3.endReplaceableGroup();
                                            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                                            $composer3.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                            MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                                            int $changed$iv$iv = (48 << 3) & 112;
                                            $composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer3, str2);
                                            Alignment alignment2 = contentAlignment$iv2;
                                            String str3 = str;
                                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str3);
                                            Object consume7 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
                                            ComposerKt.sourceInformationMarkerEnd($composer3);
                                            Density density$iv$iv3 = (Density) consume7;
                                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str3);
                                            Object consume8 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                                            ComposerKt.sourceInformationMarkerEnd($composer3);
                                            LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume8;
                                            int i9 = $changed$iv$iv$iv2;
                                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str3);
                                            Object consume9 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                                            ComposerKt.sourceInformationMarkerEnd($composer3);
                                            ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume9;
                                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                                            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(overlayModifier);
                                            Modifier modifier2 = overlayModifier;
                                            int $changed$iv$iv$iv3 = (($changed$iv$iv << 9) & 7168) | 6;
                                            int i10 = $changed$iv$iv;
                                            if (!($composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer3.startReusableNode();
                                            if ($composer3.getInserting()) {
                                                $composer3.createNode(constructor3);
                                            } else {
                                                $composer3.useNode();
                                            }
                                            $composer3.disableReusing();
                                            Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m2787constructorimpl($composer3);
                                            Function0<ComposeUiNode> function03 = constructor3;
                                            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.Companion.getSetDensity());
                                            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.Companion.getSetLayoutDirection());
                                            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.Companion.getSetViewConfiguration());
                                            $composer3.enableReusing();
                                            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
                                            $composer3.startReplaceableGroup(2058660585);
                                            int i11 = ($changed$iv$iv$iv3 >> 9) & 14;
                                            Composer $composer$iv4 = $composer3;
                                            int i12 = $changed$iv$iv$iv3;
                                            ComposerKt.sourceInformationMarkerStart($composer$iv4, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                                            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                                            int i13 = ((48 >> 6) & 112) | 6;
                                            ViewConfiguration viewConfiguration3 = viewConfiguration$iv$iv3;
                                            Composer $composer4 = $composer$iv4;
                                            ComposerKt.sourceInformationMarkerStart($composer4, 333805171, "C267@12599L204:Chip.kt#jmzs0o");
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(iconColor))}, (Function2<? super Composer, ? super Integer, Unit>) function22, $composer4, ((i3 >> 24) & 112) | 8);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                                            $composer3.endReplaceableGroup();
                                            $composer3.endNode();
                                            $composer3.endReplaceableGroup();
                                            $composer3.endReplaceableGroup();
                                        }
                                        $composer2.endReplaceableGroup();
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                        $composer2.endReplaceableGroup();
                                        $composer2.endNode();
                                        $composer2.endReplaceableGroup();
                                        $composer2.endReplaceableGroup();
                                        SpacerKt.Spacer(SizeKt.m835width3ABfNKs(Modifier.Companion, ChipKt.LeadingIconEndSpacing), $composer2, 6);
                                    } else {
                                        $this$invoke_u24lambda_u242 = $this$invoke_u24lambda_u2422;
                                        $composer$iv = $composer$iv2;
                                        $changed2 = $changed3;
                                        int i14 = $changed$iv;
                                    }
                                    $composer2.endReplaceableGroup();
                                    function32.invoke($this$invoke_u24lambda_u242, $composer2, Integer.valueOf(($changed2 & 14) | (i4 & 112)));
                                    Composer composer2 = $composer;
                                    composer2.startReplaceableGroup(-1181292859);
                                    ComposerKt.sourceInformation(composer2, "278@13088L43,279@13156L14,280@13195L43");
                                    if (function24 != null) {
                                        SpacerKt.Spacer(SizeKt.m835width3ABfNKs(Modifier.Companion, ChipKt.TrailingIconSpacing), $composer2, 6);
                                        function24.invoke($composer2, Integer.valueOf(i4 & 14));
                                        SpacerKt.Spacer(SizeKt.m835width3ABfNKs(Modifier.Companion, ChipKt.TrailingIconSpacing), $composer2, 6);
                                    }
                                    $composer.endReplaceableGroup();
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
                        }), $composer, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }), composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
