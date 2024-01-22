package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NavigationRail.kt */
final class NavigationRailKt$NavigationRailItem$styledIcon$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ boolean $alwaysShowLabel;
    final /* synthetic */ NavigationRailItemColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ boolean $selected;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationRailKt$NavigationRailItem$styledIcon$1(NavigationRailItemColors navigationRailItemColors, boolean z, int i, Function2<? super Composer, ? super Integer, Unit> function2, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.$colors = navigationRailItemColors;
        this.$selected = z;
        this.$$dirty = i;
        this.$label = function2;
        this.$alwaysShowLabel = z2;
        this.$icon = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke$lambda-0  reason: not valid java name */
    private static final long m2025invoke$lambda0(State<Color> $iconColor$delegate) {
        return ((Color) $iconColor$delegate.getValue()).m3174unboximpl();
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C172@7735L30,175@7935L185:NavigationRail.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1023357515, i, -1, "androidx.compose.material3.NavigationRailItem.<anonymous> (NavigationRail.kt:171)");
            }
            NavigationRailItemColors navigationRailItemColors = this.$colors;
            boolean z = this.$selected;
            int i2 = this.$$dirty;
            State<Color> iconColor$material3_release = navigationRailItemColors.iconColor$material3_release(z, composer, ((i2 >> 18) & 112) | (i2 & 14));
            boolean clearSemantics = this.$label != null && (this.$alwaysShowLabel || this.$selected);
            Modifier modifier$iv = Modifier.Companion;
            if (clearSemantics) {
                modifier$iv = SemanticsModifierKt.clearAndSetSemantics(modifier$iv, AnonymousClass1.INSTANCE);
            }
            Function2<Composer, Integer, Unit> function2 = this.$icon;
            int i3 = this.$$dirty;
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
            boolean z2 = clearSemantics;
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
            Modifier modifier = modifier$iv;
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
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            $composer$iv.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation($composer$iv, "C72@3384L9:Box.kt#2w3rfo");
            if ((($changed$iv$iv$iv >> 9) & 14 & 11) != 2 || !$composer$iv.getSkipping()) {
                int $changed2 = ((0 >> 6) & 112) | 6;
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                Composer $composer2 = $composer$iv;
                $composer2.startReplaceableGroup(-1892243397);
                ComposerKt.sourceInformation($composer2, "C176@8032L78:NavigationRail.kt#uh7d8r");
                int i4 = $changed2;
                if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                    State<Color> state = iconColor$material3_release;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(m2025invoke$lambda0(iconColor$material3_release)))}, (Function2<? super Composer, ? super Integer, Unit>) function2, $composer2, ((i3 >> 3) & 112) | 8);
                } else {
                    $composer2.skipToGroupEnd();
                    State<Color> state2 = iconColor$material3_release;
                }
                $composer2.endReplaceableGroup();
            } else {
                $composer$iv.skipToGroupEnd();
                ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv;
                State<Color> state3 = iconColor$material3_release;
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
