package androidx.compose.material3;

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
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
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
/* compiled from: NavigationDrawer.kt */
final class NavigationDrawerKt$NavigationDrawerItem$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $badge;
    final /* synthetic */ NavigationDrawerItemColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ boolean $selected;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationDrawerKt$NavigationDrawerItem$2(Function2<? super Composer, ? super Integer, Unit> function2, NavigationDrawerItemColors navigationDrawerItemColors, boolean z, int i, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23) {
        super(2);
        this.$icon = function2;
        this.$colors = navigationDrawerItemColors;
        this.$selected = z;
        this.$$dirty = i;
        this.$badge = function22;
        this.$label = function23;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C680@26005L868:NavigationDrawer.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(191488423, i, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:679)");
            }
            Modifier modifier$iv = PaddingKt.m764paddingqDBjuR0$default(Modifier.Companion, Dp.m5986constructorimpl((float) 16), 0.0f, Dp.m5986constructorimpl((float) 24), 0.0f, 10, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Function2<Composer, Integer, Unit> function2 = this.$icon;
            NavigationDrawerItemColors navigationDrawerItemColors = this.$colors;
            boolean z = this.$selected;
            int i2 = this.$$dirty;
            Function2<Composer, Integer, Unit> function22 = this.$badge;
            Function2<Composer, Integer, Unit> function23 = this.$label;
            composer.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composer, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Alignment.Vertical vertical = verticalAlignment$iv;
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            Function2<Composer, Integer, Unit> function24 = function22;
            int $changed$iv$iv$iv = ((((390 << 3) & 112) << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
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
            Density density = density$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            function32.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer)), composer, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            composer.startReplaceableGroup(2058660585);
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
            Composer $composer$iv = $composer;
            $composer$iv.startReplaceableGroup(-678309503);
            ComposerKt.sourceInformation($composer$iv, "C80@3988L9:Row.kt#2w3rfo");
            if (($changed$iv & 11) != 2 || !$composer$iv.getSkipping()) {
                int $changed2 = ((390 >> 6) & 112) | 6;
                RowScope $this$invoke_u24lambda_u2d1 = RowScopeInstance.INSTANCE;
                LayoutDirection layoutDirection = layoutDirection$iv$iv;
                int i3 = $changed$iv$iv$iv;
                Composer $composer2 = $composer$iv;
                $composer2.startReplaceableGroup(1789891011);
                ComposerKt.sourceInformation($composer2, "C689@26403L203,694@26656L29,695@26726L20,696@26769L80:NavigationDrawer.kt#uh7d8r");
                int $dirty = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty |= $composer2.changed((Object) $this$invoke_u24lambda_u2d1) ? 4 : 2;
                }
                int i4 = $changed2;
                int i5 = $dirty;
                if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
                    $composer2.startReplaceableGroup(-1538531826);
                    ComposerKt.sourceInformation($composer2, "685@26210L19,686@26252L78,687@26347L29");
                    if (function2 != null) {
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(navigationDrawerItemColors.iconColor(z, $composer2, ((i2 >> 3) & 14) | ((i2 >> 18) & 112)).getValue().m3174unboximpl()))}, (Function2<? super Composer, ? super Integer, Unit>) function2, $composer2, ((i2 >> 9) & 112) | 8);
                        SpacerKt.Spacer(SizeKt.m835width3ABfNKs(Modifier.Companion, Dp.m5986constructorimpl((float) 12)), $composer2, 6);
                    }
                    $composer2.endReplaceableGroup();
                    Modifier modifier$iv2 = RowScope.weight$default($this$invoke_u24lambda_u2d1, Modifier.Companion, 1.0f, false, 2, (Object) null);
                    $composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    $composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume4 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density density$iv$iv2 = (Density) consume4;
                    Alignment alignment = contentAlignment$iv;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume5 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                    ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume6 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
                    Modifier modifier2 = modifier$iv2;
                    int $changed$iv$iv$iv2 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                    int i6 = $changed$iv;
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
                    skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                    $composer2.startReplaceableGroup(2058660585);
                    Composer $composer$iv2 = $composer2;
                    Density density2 = density$iv$iv2;
                    $composer$iv2.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer$iv2, "C72@3384L9:Box.kt#2w3rfo");
                    int i7 = $changed$iv$iv$iv2;
                    if ((($changed$iv$iv$iv2 >> 9) & 14 & 11) != 2 || !$composer$iv2.getSkipping()) {
                        int $changed3 = ((0 >> 6) & 112) | 6;
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        LayoutDirection layoutDirection2 = layoutDirection$iv$iv2;
                        Composer $composer3 = $composer$iv2;
                        $composer3.startReplaceableGroup(-1847258627);
                        ComposerKt.sourceInformation($composer3, "C690@26470L19,691@26512L80:NavigationDrawer.kt#uh7d8r");
                        int i8 = $changed3;
                        if (($changed3 & 81) != 16 || !$composer3.getSkipping()) {
                            ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv2;
                            MeasurePolicy measurePolicy = measurePolicy$iv2;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(navigationDrawerItemColors.textColor(z, $composer3, ((i2 >> 3) & 14) | ((i2 >> 18) & 112)).getValue().m3174unboximpl()))}, (Function2<? super Composer, ? super Integer, Unit>) function23, $composer3, ((i2 << 3) & 112) | 8);
                        } else {
                            $composer3.skipToGroupEnd();
                            ViewConfiguration viewConfiguration3 = viewConfiguration$iv$iv2;
                            MeasurePolicy measurePolicy2 = measurePolicy$iv2;
                        }
                        $composer3.endReplaceableGroup();
                    } else {
                        $composer$iv2.skipToGroupEnd();
                        LayoutDirection layoutDirection3 = layoutDirection$iv$iv2;
                        ViewConfiguration viewConfiguration4 = viewConfiguration$iv$iv2;
                        MeasurePolicy measurePolicy3 = measurePolicy$iv2;
                    }
                    $composer$iv2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    $composer2.endNode();
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    if (function24 != null) {
                        SpacerKt.Spacer(SizeKt.m835width3ABfNKs(Modifier.Companion, Dp.m5986constructorimpl((float) 12)), $composer2, 6);
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(navigationDrawerItemColors.badgeColor(z, $composer2, ((i2 >> 3) & 14) | ((i2 >> 18) & 112)).getValue().m3174unboximpl()))}, (Function2<? super Composer, ? super Integer, Unit>) function24, $composer2, ((i2 >> 12) & 112) | 8);
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    RowScope rowScope = $this$invoke_u24lambda_u2d1;
                    ViewConfiguration viewConfiguration5 = viewConfiguration$iv$iv;
                    int i9 = $changed$iv;
                }
                $composer2.endReplaceableGroup();
            } else {
                $composer$iv.skipToGroupEnd();
                LayoutDirection layoutDirection4 = layoutDirection$iv$iv;
                int i10 = $changed$iv$iv$iv;
                ViewConfiguration viewConfiguration6 = viewConfiguration$iv$iv;
                int i11 = $changed$iv;
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
