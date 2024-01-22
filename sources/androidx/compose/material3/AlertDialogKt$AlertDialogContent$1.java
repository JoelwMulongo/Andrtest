package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AlertDialog.kt */
final class AlertDialogKt$AlertDialogContent$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $buttonContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $buttons;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ long $iconContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ long $textContentColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ long $titleContentColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlertDialogKt$AlertDialogContent$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, long j, int i, long j2, long j3, long j4, Function2<? super Composer, ? super Integer, Unit> function24) {
        super(2);
        this.$icon = function2;
        this.$title = function22;
        this.$text = function23;
        this.$iconContentColor = j;
        this.$$dirty = i;
        this.$titleContentColor = j2;
        this.$textContentColor = j3;
        this.$buttonContentColor = j4;
        this.$buttons = function24;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Function2<Composer, Integer, Unit> function2;
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C58@2022L2574:AlertDialog.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2126308228, i, -1, "androidx.compose.material3.AlertDialogContent.<anonymous> (AlertDialog.kt:57)");
            }
            Modifier modifier$iv = PaddingKt.padding(SizeKt.m834sizeInqDBjuR0$default(Modifier.Companion, AlertDialogKt.MinWidth, 0.0f, AlertDialogKt.MaxWidth, 0.0f, 10, (Object) null), AlertDialogKt.DialogPadding);
            Function2<Composer, Integer, Unit> function22 = this.$icon;
            Function2<Composer, Integer, Unit> function23 = this.$title;
            Function2<Composer, Integer, Unit> function24 = this.$text;
            long j = this.$iconContentColor;
            int i2 = this.$$dirty;
            long j2 = this.$titleContentColor;
            long j3 = this.$textContentColor;
            Function2<Composer, Integer, Unit> function25 = function22;
            long j4 = this.$buttonContentColor;
            Function2<Composer, Integer, Unit> function26 = this.$buttons;
            composer.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(composer, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            Function2<Composer, Integer, Unit> function27 = function26;
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            Arrangement.Vertical vertical = verticalArrangement$iv;
            composer.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Alignment.Horizontal horizontal = horizontalAlignment$iv;
            long j5 = j4;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density density$iv$iv = (Density) consume;
            String str = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            long j6 = j3;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
            String str2 = "C:CompositionLocal.kt#9igjgp";
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
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            Composer $composer$iv = $composer;
            $composer$iv.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation($composer$iv, "C79@3994L9:Column.kt#2w3rfo");
            if ((($changed$iv$iv$iv >> 9) & 14 & 11) != 2 || !$composer$iv.getSkipping()) {
                int $changed2 = ((6 >> 6) & 112) | 6;
                ColumnScope $this$invoke_u24lambda_u2d4 = ColumnScopeInstance.INSTANCE;
                Density density = density$iv$iv;
                Composer $composer2 = $composer$iv;
                $composer2.startReplaceableGroup(-1370717838);
                ComposerKt.sourceInformation($composer2, "C111@4213L373:AlertDialog.kt#uh7d8r");
                int $dirty = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty |= $composer2.changed((Object) $this$invoke_u24lambda_u2d4) ? 4 : 2;
                }
                int i3 = $changed$iv$iv$iv;
                int i4 = $dirty;
                if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
                    $composer2.startReplaceableGroup(76440864);
                    ComposerKt.sourceInformation($composer2, "*64@2220L339");
                    if (function25 == null) {
                        function2 = function25;
                        ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                    } else {
                        Function2<Composer, Integer, Unit> function28 = function25;
                        ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(j))};
                        function2 = function25;
                        ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 934657765, true, new AlertDialogKt$AlertDialogContent$1$1$1$1($this$invoke_u24lambda_u2d4, function2, i2)), $composer2, 56);
                        Unit unit = Unit.INSTANCE;
                        Unit unit2 = Unit.INSTANCE;
                    }
                    $composer2.endReplaceableGroup();
                    $composer2.startReplaceableGroup(76441259);
                    ComposerKt.sourceInformation($composer2, "*75@2615L895");
                    if (function23 != null) {
                        Function2<Composer, Integer, Unit> function29 = function23;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(j2))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 1845262876, true, new AlertDialogKt$AlertDialogContent$1$1$2$1($this$invoke_u24lambda_u2d4, function2, function23, i2)), $composer2, 56);
                        Unit unit3 = Unit.INSTANCE;
                        Unit unit4 = Unit.INSTANCE;
                    }
                    $composer2.endReplaceableGroup();
                    $composer2.startReplaceableGroup(76442209);
                    ComposerKt.sourceInformation($composer2, "*96@3565L621");
                    if (function24 != null) {
                        Function2<Composer, Integer, Unit> function210 = function24;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(j6))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 613970333, true, new AlertDialogKt$AlertDialogContent$1$1$3$1($this$invoke_u24lambda_u2d4, function24, i2)), $composer2, 56);
                        Unit unit5 = Unit.INSTANCE;
                        Unit unit6 = Unit.INSTANCE;
                    }
                    $composer2.endReplaceableGroup();
                    Modifier modifier$iv2 = $this$invoke_u24lambda_u2d4.align(Modifier.Companion, Alignment.Companion.getEnd());
                    $composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv = (0 << 3) & 112;
                    $composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer2, str);
                    ColumnScope columnScope = $this$invoke_u24lambda_u2d4;
                    String str3 = str2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str3);
                    Object consume4 = $composer2.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density density$iv$iv2 = (Density) consume4;
                    Alignment alignment = contentAlignment$iv;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str3);
                    Object consume5 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str3);
                    Object consume6 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                    Modifier modifier2 = modifier$iv2;
                    int $changed$iv$iv$iv2 = (($changed$iv$iv << 9) & 7168) | 6;
                    int i5 = $changed$iv$iv;
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
                    skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                    $composer2.startReplaceableGroup(2058660585);
                    Composer $composer$iv2 = $composer2;
                    int i6 = $changed$iv$iv$iv2;
                    $composer$iv2.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer$iv2, "C72@3384L9:Box.kt#2w3rfo");
                    ViewConfiguration viewConfiguration3 = viewConfiguration$iv$iv2;
                    if ((($changed$iv$iv$iv2 >> 9) & 14 & 11) != 2 || !$composer$iv2.getSkipping()) {
                        int $changed3 = ((0 >> 6) & 112) | 6;
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        Composer $composer3 = $composer$iv2;
                        $composer3.startReplaceableGroup(1902704376);
                        ComposerKt.sourceInformation($composer3, "C112@4277L295:AlertDialog.kt#uh7d8r");
                        int i7 = $changed3;
                        if (($changed3 & 81) != 16 || !$composer3.getSkipping()) {
                            Density density2 = density$iv$iv2;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(j5))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer3, -433542216, true, new AlertDialogKt$AlertDialogContent$1$1$4$1(function27, i2)), $composer3, 56);
                        } else {
                            $composer3.skipToGroupEnd();
                            Density density3 = density$iv$iv2;
                        }
                        $composer3.endReplaceableGroup();
                    } else {
                        $composer$iv2.skipToGroupEnd();
                        Density density4 = density$iv$iv2;
                    }
                    $composer$iv2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    $composer2.endNode();
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                } else {
                    $composer2.skipToGroupEnd();
                    ViewConfiguration viewConfiguration4 = viewConfiguration$iv$iv;
                    ColumnScope columnScope2 = $this$invoke_u24lambda_u2d4;
                }
                $composer2.endReplaceableGroup();
            } else {
                $composer$iv.skipToGroupEnd();
                Density density5 = density$iv$iv;
                int i8 = $changed$iv$iv$iv;
                ViewConfiguration viewConfiguration5 = viewConfiguration$iv$iv;
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
