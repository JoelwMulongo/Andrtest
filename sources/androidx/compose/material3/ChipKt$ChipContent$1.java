package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
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
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Chip.kt */
final class ChipKt$ChipContent$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $avatar;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ long $leadingIconColor;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ PaddingValues $paddingValues;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ long $trailingIconColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipKt$ChipContent$1(float f, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function2, int i, Function2<? super Composer, ? super Integer, Unit> function22, long j, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, long j2) {
        super(2);
        this.$minHeight = f;
        this.$paddingValues = paddingValues;
        this.$avatar = function2;
        this.$$dirty = i;
        this.$leadingIcon = function22;
        this.$leadingIconColor = j;
        this.$label = function23;
        this.$trailingIcon = function24;
        this.$trailingIconColor = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C1418@69905L870:Chip.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1748799148, i, -1, "androidx.compose.material3.ChipContent.<anonymous> (Chip.kt:1417)");
            }
            Modifier modifier$iv = PaddingKt.padding(SizeKt.m815defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, this.$minHeight, 1, (Object) null), this.$paddingValues);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Function2<Composer, Integer, Unit> function2 = this.$avatar;
            int i2 = this.$$dirty;
            Function2<Composer, Integer, Unit> function22 = this.$leadingIcon;
            long j = this.$leadingIconColor;
            Function2<Composer, Integer, Unit> function23 = this.$label;
            Function2<Composer, Integer, Unit> function24 = this.$trailingIcon;
            int i3 = i2;
            long j2 = this.$trailingIconColor;
            composer.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(composer, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv$iv = (Density) consume;
            Arrangement.Horizontal horizontal = horizontalArrangement$iv;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            Alignment.Vertical vertical = verticalAlignment$iv;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            long j3 = j2;
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
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            $composer$iv.startReplaceableGroup(-678309503);
            ComposerKt.sourceInformation($composer$iv, "C80@3988L9:Row.kt#2w3rfo");
            if ((($changed$iv$iv$iv >> 9) & 14 & 11) != 2 || !$composer$iv.getSkipping()) {
                int $changed2 = ((432 >> 6) & 112) | 6;
                RowScope rowScope = RowScopeInstance.INSTANCE;
                ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                Composer $composer2 = $composer$iv;
                $composer2.startReplaceableGroup(827638800);
                ComposerKt.sourceInformation($composer2, "C1432@70431L49,1433@70493L7,1434@70513L49,1436@70619L132:Chip.kt#uh7d8r");
                int i4 = $changed2;
                if (($changed2 & 81) != 16 || !$composer2.getSkipping()) {
                    if (function2 != null) {
                        $composer2.startReplaceableGroup(650988385);
                        ComposerKt.sourceInformation($composer2, "1426@70203L8");
                        function2.invoke($composer2, Integer.valueOf((i3 >> 12) & 14));
                        $composer2.endReplaceableGroup();
                        MeasurePolicy measurePolicy = measurePolicy$iv;
                    } else if (function22 != null) {
                        $composer2.startReplaceableGroup(650988456);
                        ComposerKt.sourceInformation($composer2, "1428@70274L130");
                        MeasurePolicy measurePolicy2 = measurePolicy$iv;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(j))}, (Function2<? super Composer, ? super Integer, Unit>) function22, $composer2, ((i3 >> 6) & 112) | 8);
                        $composer2.endReplaceableGroup();
                    } else {
                        $composer2.startReplaceableGroup(650988618);
                        $composer2.endReplaceableGroup();
                    }
                    SpacerKt.Spacer(SizeKt.m835width3ABfNKs(Modifier.Companion, ChipKt.HorizontalElementsPadding), $composer2, 6);
                    function23.invoke($composer2, Integer.valueOf(i3 & 14));
                    SpacerKt.Spacer(SizeKt.m835width3ABfNKs(Modifier.Companion, ChipKt.HorizontalElementsPadding), $composer2, 6);
                    if (function24 != null) {
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(j3))}, (Function2<? super Composer, ? super Integer, Unit>) function24, $composer2, ((i3 >> 12) & 112) | 8);
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    MeasurePolicy measurePolicy3 = measurePolicy$iv;
                }
                $composer2.endReplaceableGroup();
            } else {
                $composer$iv.skipToGroupEnd();
                ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv;
                MeasurePolicy measurePolicy4 = measurePolicy$iv;
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
