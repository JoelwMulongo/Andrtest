package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
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
/* compiled from: Menu.kt */
final class MenuKt$DropdownMenuItemContent$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ MenuItemColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ RowScope $this_Row;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MenuKt$DropdownMenuItemContent$1$1(Function2<? super Composer, ? super Integer, Unit> function2, MenuItemColors menuItemColors, boolean z, int i, Function2<? super Composer, ? super Integer, Unit> function22, RowScope rowScope, Function2<? super Composer, ? super Integer, Unit> function23) {
        super(2);
        this.$leadingIcon = function2;
        this.$colors = menuItemColors;
        this.$enabled = z;
        this.$$dirty = i;
        this.$trailingIcon = function22;
        this.$this_Row = rowScope;
        this.$text = function23;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C181@6637L18,181@6578L777,203@7492L26,202@7412L310:Menu.kt#uh7d8r");
        if (($changed & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1065051884, $changed, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous> (Menu.kt:171)");
            }
            $composer.startReplaceableGroup(1426254055);
            ComposerKt.sourceInformation($composer, "174@6323L25,173@6243L308");
            if (this.$leadingIcon != null) {
                ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                MenuItemColors menuItemColors = this.$colors;
                boolean z = this.$enabled;
                int i = this.$$dirty;
                ProvidedValue[] providedValueArr = {localContentColor.provides(menuItemColors.leadingIconColor$material3_release(z, $composer, ((i >> 15) & 112) | ((i >> 15) & 14)).getValue())};
                final Function2<Composer, Integer, Unit> function2 = this.$leadingIcon;
                final int i2 = this.$$dirty;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer, 2035552199, true, new Function2<Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        invoke((Composer) p1, ((Number) p2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer, int $changed) {
                        Composer composer = $composer;
                        int i = $changed;
                        ComposerKt.sourceInformation(composer, "C176@6396L137:Menu.kt#uh7d8r");
                        if ((i & 11) != 2 || !$composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2035552199, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:175)");
                            }
                            Modifier modifier$iv = SizeKt.m815defaultMinSizeVpY3zN4$default(Modifier.Companion, MenuTokens.INSTANCE.m2516getListItemLeadingIconSizeD9Ej5fM(), 0.0f, 2, (Object) null);
                            Function2<Composer, Integer, Unit> function2 = function2;
                            int i2 = i2;
                            composer.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
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
                            int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
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
                                int $changed2 = ((6 >> 6) & 112) | 6;
                                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                int i3 = $changed$iv;
                                Composer $composer2 = $composer$iv;
                                $composer2.startReplaceableGroup(1667854413);
                                ComposerKt.sourceInformation($composer2, "C177@6498L13:Menu.kt#uh7d8r");
                                int i4 = $changed2;
                                if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                    function2.invoke($composer2, Integer.valueOf((i2 >> 9) & 14));
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
                }), $composer, 56);
            }
            $composer.endReplaceableGroup();
            ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
            MenuItemColors menuItemColors2 = this.$colors;
            boolean z2 = this.$enabled;
            int i3 = this.$$dirty;
            ProvidedValue[] providedValueArr2 = {localContentColor2.provides(menuItemColors2.textColor$material3_release(z2, $composer, ((i3 >> 15) & 112) | ((i3 >> 15) & 14)).getValue())};
            final RowScope rowScope = this.$this_Row;
            final Function2<Composer, Integer, Unit> function22 = this.$leadingIcon;
            final Function2<Composer, Integer, Unit> function23 = this.$trailingIcon;
            final Function2<Composer, Integer, Unit> function24 = this.$text;
            final int i4 = this.$$dirty;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr2, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer, -1728894036, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    float f;
                    float f2;
                    Composer composer = $composer;
                    int i = $changed;
                    ComposerKt.sourceInformation(composer, "C182@6681L660:Menu.kt#uh7d8r");
                    if ((i & 11) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1728894036, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:181)");
                        }
                        Modifier weight$default = RowScope.weight$default(rowScope, Modifier.Companion, 1.0f, false, 2, (Object) null);
                        if (function22 != null) {
                            f = MenuKt.DropdownMenuItemHorizontalPadding;
                        } else {
                            f = Dp.m5986constructorimpl((float) 0);
                        }
                        if (function23 != null) {
                            f2 = MenuKt.DropdownMenuItemHorizontalPadding;
                        } else {
                            f2 = Dp.m5986constructorimpl((float) 0);
                        }
                        Modifier modifier$iv = PaddingKt.m764paddingqDBjuR0$default(weight$default, f, 0.0f, f2, 0.0f, 10, (Object) null);
                        Function2<Composer, Integer, Unit> function2 = function24;
                        int i2 = i4;
                        composer.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                        int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
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
                            int $changed2 = ((0 >> 6) & 112) | 6;
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            int i3 = $changed$iv;
                            Composer $composer2 = $composer$iv;
                            $composer2.startReplaceableGroup(-1301783630);
                            ComposerKt.sourceInformation($composer2, "C198@7317L6:Menu.kt#uh7d8r");
                            int i4 = $changed2;
                            if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                function2.invoke($composer2, Integer.valueOf(i2 & 14));
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
            }), $composer, 56);
            if (this.$trailingIcon != null) {
                ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                MenuItemColors menuItemColors3 = this.$colors;
                boolean z3 = this.$enabled;
                int i5 = this.$$dirty;
                ProvidedValue[] providedValueArr3 = {localContentColor3.provides(menuItemColors3.trailingIconColor$material3_release(z3, $composer, ((i5 >> 15) & 112) | ((i5 >> 15) & 14)).getValue())};
                final Function2<Composer, Integer, Unit> function25 = this.$trailingIcon;
                final int i6 = this.$$dirty;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer, 580312062, true, new Function2<Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        invoke((Composer) p1, ((Number) p2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer, int $changed) {
                        Composer composer = $composer;
                        int i = $changed;
                        ComposerKt.sourceInformation(composer, "C205@7565L139:Menu.kt#uh7d8r");
                        if ((i & 11) != 2 || !$composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(580312062, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:204)");
                            }
                            Modifier modifier$iv = SizeKt.m815defaultMinSizeVpY3zN4$default(Modifier.Companion, MenuTokens.INSTANCE.m2517getListItemTrailingIconSizeD9Ej5fM(), 0.0f, 2, (Object) null);
                            Function2<Composer, Integer, Unit> function2 = function25;
                            int i2 = i6;
                            composer.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
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
                            int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
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
                                int $changed2 = ((6 >> 6) & 112) | 6;
                                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                                int i3 = $changed$iv;
                                Composer $composer2 = $composer$iv;
                                $composer2.startReplaceableGroup(-589942012);
                                ComposerKt.sourceInformation($composer2, "C206@7668L14:Menu.kt#uh7d8r");
                                int i4 = $changed2;
                                if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                                    function2.invoke($composer2, Integer.valueOf((i2 >> 12) & 14));
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
                }), $composer, 56);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
