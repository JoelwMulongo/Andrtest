package androidx.compose.material3;

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
import androidx.compose.material3.tokens.BadgeTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
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
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102 \b\u0002\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f\u0018\u00010\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001aS\u0010\u0019\u001a\u00020\f2\u001c\u0010\u001a\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0002\u0010\u001c\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0019\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0019\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\"\u0019\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\n\u0010\u0003\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"BadgeOffset", "Landroidx/compose/ui/unit/Dp;", "getBadgeOffset", "()F", "F", "BadgeWithContentHorizontalOffset", "getBadgeWithContentHorizontalOffset", "BadgeWithContentHorizontalPadding", "getBadgeWithContentHorizontalPadding", "BadgeWithContentVerticalOffset", "getBadgeWithContentVerticalOffset", "Badge", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Badge-eopBjH0", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BadgedBox", "badge", "Landroidx/compose/foundation/layout/BoxScope;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Badge.kt */
public final class BadgeKt {
    private static final float BadgeOffset = Dp.m5986constructorimpl((float) 0);
    private static final float BadgeWithContentHorizontalOffset = Dp.m5986constructorimpl(-Dp.m5986constructorimpl((float) 4));
    private static final float BadgeWithContentHorizontalPadding = Dp.m5986constructorimpl((float) 4);
    private static final float BadgeWithContentVerticalOffset = Dp.m5986constructorimpl(-Dp.m5986constructorimpl((float) 4));

    @ExperimentalMaterial3Api
    public static final void BadgedBox(Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> badge, Modifier modifier, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0<ComposeUiNode> function0;
        Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3 = badge;
        Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function32 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function3, "badge");
        Intrinsics.checkNotNullParameter(function32, "content");
        Composer $composer3 = $composer.startRestartGroup(1404022535);
        ComposerKt.sourceInformation($composer3, "C(BadgedBox)P(!1,2)66@2566L2114:Badge.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer3.changed((Object) function3) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if ((i2 & 896) == 0) {
            $dirty |= $composer3.changed((Object) function32) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer3.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1404022535, $dirty2, -1, "androidx.compose.material3.BadgedBox (Badge.kt:61)");
            }
            MeasurePolicy measurePolicy$iv = BadgeKt$BadgedBox$2.INSTANCE;
            int $changed$iv = $dirty2 & 112;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            int $changed$iv$iv = (($changed$iv << 9) & 7168) | 6;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier4);
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function0 = constructor;
                $composer3.createNode(function0);
            } else {
                function0 = constructor;
                $composer3.useNode();
            }
            $composer3.disableReusing();
            modifier3 = modifier4;
            Composer $this$Layout_u24lambda_u2d0$iv = Updater.m2787constructorimpl($composer3);
            int i4 = $changed$iv;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer3.enableReusing();
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = materializerOf;
            function33.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int $changed2 = ($changed$iv$iv >> 9) & 14;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = function33;
            Composer $composer4 = $composer3;
            $composer4.startReplaceableGroup(483395760);
            ComposerKt.sourceInformation($composer4, "C68@2596L161,73@2770L105:Badge.kt#uh7d8r");
            int i5 = $changed2;
            if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                Modifier modifier$iv = LayoutIdKt.layoutId(Modifier.Companion, "anchor");
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                Function0<ComposeUiNode> function02 = function0;
                int $changed$iv2 = (($dirty2 << 3) & 7168) | 54;
                $composer4.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Density density = density$iv;
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, (($changed$iv2 >> 3) & 14) | (($changed$iv2 >> 3) & 112));
                Alignment alignment = contentAlignment$iv;
                $composer4.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                LayoutDirection layoutDirection = layoutDirection$iv;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Density density$iv$iv = (Density) consume4;
                ViewConfiguration viewConfiguration = viewConfiguration$iv;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume5;
                int i6 = $changed$iv$iv;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier$iv);
                Modifier modifier5 = modifier$iv;
                int $changed$iv$iv$iv = (((($changed$iv2 << 3) & 112) << 9) & 7168) | 6;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = materializerOf2;
                $composer2 = $composer3;
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    $composer4.createNode(constructor2);
                } else {
                    $composer4.useNode();
                }
                $composer4.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer4);
                Function0<ComposeUiNode> function03 = constructor2;
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer4.enableReusing();
                Density density2 = density$iv$iv;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function36 = function35;
                function36.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                $composer4.startReplaceableGroup(2058660585);
                int $changed$iv3 = ($changed$iv$iv$iv >> 9) & 14;
                Composer $composer$iv = $composer4;
                int i7 = $changed$iv$iv$iv;
                $composer$iv.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation($composer$iv, "C72@3384L9:Box.kt#2w3rfo");
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function37 = function36;
                int i8 = $changed$iv3;
                if (($changed$iv3 & 11) != 2 || !$composer$iv.getSkipping()) {
                    function32.invoke(BoxScopeInstance.INSTANCE, $composer$iv, Integer.valueOf((($changed$iv2 >> 6) & 112) | 6));
                } else {
                    $composer$iv.skipToGroupEnd();
                }
                $composer$iv.endReplaceableGroup();
                $composer4.endReplaceableGroup();
                $composer4.endNode();
                $composer4.endReplaceableGroup();
                $composer4.endReplaceableGroup();
                Modifier modifier$iv2 = LayoutIdKt.layoutId(Modifier.Companion, "badge");
                int $changed$iv4 = (($dirty2 << 9) & 7168) | 6;
                $composer4.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer4, (($changed$iv4 >> 3) & 14) | (($changed$iv4 >> 3) & 112));
                $composer4.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                Alignment alignment2 = contentAlignment$iv2;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume7 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Density density$iv$iv2 = (Density) consume7;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume8 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume8;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume9 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume9;
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
                int $changed$iv$iv$iv2 = (((($changed$iv4 << 3) & 112) << 9) & 7168) | 6;
                Modifier modifier6 = modifier$iv2;
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    $composer4.createNode(constructor3);
                } else {
                    $composer4.useNode();
                }
                $composer4.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2787constructorimpl($composer4);
                Function0<ComposeUiNode> function04 = constructor3;
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer4.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer4.startReplaceableGroup(2058660585);
                Composer $composer$iv2 = $composer4;
                Density density3 = density$iv$iv2;
                $composer$iv2.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation($composer$iv2, "C72@3384L9:Box.kt#2w3rfo");
                if ((($changed$iv$iv$iv2 >> 9) & 14 & 11) != 2 || !$composer$iv2.getSkipping()) {
                    function3.invoke(BoxScopeInstance.INSTANCE, $composer$iv2, Integer.valueOf((($changed$iv4 >> 6) & 112) | 6));
                } else {
                    $composer$iv2.skipToGroupEnd();
                }
                $composer$iv2.endReplaceableGroup();
                $composer4.endReplaceableGroup();
                $composer4.endNode();
                $composer4.endReplaceableGroup();
                $composer4.endReplaceableGroup();
            } else {
                $composer4.skipToGroupEnd();
                Function0<ComposeUiNode> function05 = function0;
                $composer2 = $composer3;
                Density density4 = density$iv;
                LayoutDirection layoutDirection2 = layoutDirection$iv;
                ViewConfiguration viewConfiguration2 = viewConfiguration$iv;
                int i9 = $changed$iv$iv;
            }
            $composer4.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BadgeKt$BadgedBox$3(badge, modifier3, content, $changed, i));
        }
    }

    @ExperimentalMaterial3Api
    /* renamed from: Badge-eopBjH0  reason: not valid java name */
    public static final void m1759BadgeeopBjH0(Modifier modifier, long containerColor, long contentColor, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        long j;
        long contentColor2;
        Function3 content2;
        Modifier modifier3;
        Function3 content3;
        long contentColor3;
        long contentColor4;
        long containerColor2;
        Modifier modifier4;
        Shape shape;
        Modifier modifier5;
        int i2;
        int i3;
        int i4 = $changed;
        Composer $composer2 = $composer.startRestartGroup(1298144073);
        ComposerKt.sourceInformation($composer2, "C(Badge)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color)141@5648L14,142@5690L31,153@6032L1119:Badge.kt#uh7d8r");
        int $dirty = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i4 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i4 & 112) == 0) {
            if ((i & 2) == 0) {
                j = containerColor;
                if ($composer2.changed(j)) {
                    i3 = 32;
                    $dirty |= i3;
                }
            } else {
                j = containerColor;
            }
            i3 = 16;
            $dirty |= i3;
        } else {
            j = containerColor;
        }
        if ((i4 & 896) == 0) {
            if ((i & 4) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                contentColor2 = contentColor;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            contentColor2 = contentColor;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            content2 = content;
        } else if ((i4 & 7168) == 0) {
            content2 = content;
            $dirty |= $composer2.changed((Object) content2) ? 2048 : 1024;
        } else {
            content2 = content;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i4 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i5 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 2) != 0) {
                    containerColor2 = BadgeDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty &= -113;
                } else {
                    containerColor2 = j;
                }
                if ((i & 4) != 0) {
                    contentColor2 = ColorSchemeKt.m1854contentColorForek8zF_U(containerColor2, $composer2, ($dirty >> 3) & 14);
                    $dirty &= -897;
                }
                if (i6 != 0) {
                    content2 = null;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 2) != 0) {
                    $dirty &= -113;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
                containerColor2 = j;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1298144073, $dirty, -1, "androidx.compose.material3.Badge (Badge.kt:139)");
            }
            BadgeTokens badgeTokens = BadgeTokens.INSTANCE;
            float size = content2 != null ? badgeTokens.m2271getLargeSizeD9Ej5fM() : badgeTokens.m2272getSizeD9Ej5fM();
            if (content2 != null) {
                $composer2.startReplaceableGroup(1947275116);
                ComposerKt.sourceInformation($composer2, "147@5933L9");
                shape = ShapesKt.toShape(BadgeTokens.INSTANCE.getLargeShape(), $composer2, 6);
                $composer2.endReplaceableGroup();
            } else {
                $composer2.startReplaceableGroup(1947275170);
                ComposerKt.sourceInformation($composer2, "149@5982L9");
                shape = ShapesKt.toShape(BadgeTokens.INSTANCE.getShape(), $composer2, 6);
                $composer2.endReplaceableGroup();
            }
            Modifier clip = ClipKt.clip(BackgroundKt.m448backgroundbw27NRU(SizeKt.m814defaultMinSizeVpY3zN4(modifier4, size, size), containerColor2, shape), shape);
            if (content2 != null) {
                float f = size;
                modifier5 = PaddingKt.m762paddingVpY3zN4$default(Modifier.Companion, BadgeWithContentHorizontalPadding, 0.0f, 2, (Object) null);
            } else {
                modifier5 = Modifier.Companion;
            }
            Modifier then = clip.then(modifier5);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            $composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation($composer2, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(center, centerVertically, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            modifier3 = modifier4;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            long containerColor3 = containerColor2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            Shape shape2 = shape;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(then);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            int i7 = $changed$iv$iv;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer2);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer2;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            $composer$iv.startReplaceableGroup(-678309503);
            ComposerKt.sourceInformation($composer$iv, "C80@3988L9:Row.kt#2w3rfo");
            Density density = density$iv$iv;
            if (($changed$iv & 11) != 2 || !$composer$iv.getSkipping()) {
                int $changed2 = ((432 >> 6) & 112) | 6;
                RowScope $this$Badge_eopBjH0_u24lambda_u2d1 = RowScopeInstance.INSTANCE;
                MeasurePolicy measurePolicy = measurePolicy$iv;
                Composer $composer3 = $composer$iv;
                $composer3.startReplaceableGroup(-1186521243);
                ComposerKt.sourceInformation($composer3, "C170@6681L454:Badge.kt#uh7d8r");
                int $dirty2 = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty2 |= $composer3.changed((Object) $this$Badge_eopBjH0_u24lambda_u2d1) ? 4 : 2;
                }
                int i8 = $changed$iv;
                LayoutDirection layoutDirection = layoutDirection$iv$iv;
                if (($dirty2 & 91) == 18 && $composer3.getSkipping()) {
                    $composer3.skipToGroupEnd();
                    RowScope rowScope = $this$Badge_eopBjH0_u24lambda_u2d1;
                    ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                } else if (content2 != null) {
                    ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv;
                    RowScope rowScope2 = $this$Badge_eopBjH0_u24lambda_u2d1;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(contentColor2))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer3, 5609066, true, new BadgeKt$Badge$1$1(content2, $this$Badge_eopBjH0_u24lambda_u2d1, $dirty2, $dirty)), $composer3, 56);
                } else {
                    ViewConfiguration viewConfiguration3 = viewConfiguration$iv$iv;
                }
                $composer3.endReplaceableGroup();
            } else {
                $composer$iv.skipToGroupEnd();
                MeasurePolicy measurePolicy2 = measurePolicy$iv;
                int i9 = $changed$iv;
                LayoutDirection layoutDirection2 = layoutDirection$iv$iv;
                ViewConfiguration viewConfiguration4 = viewConfiguration$iv$iv;
            }
            $composer$iv.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i10 = $dirty;
            content3 = content2;
            contentColor3 = contentColor2;
            contentColor4 = containerColor3;
        } else {
            $composer2.skipToGroupEnd();
            int i11 = $dirty;
            modifier3 = modifier2;
            content3 = content2;
            contentColor3 = contentColor2;
            contentColor4 = j;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BadgeKt$Badge$2(modifier3, contentColor4, contentColor3, content3, $changed, i));
        }
    }

    public static final float getBadgeWithContentHorizontalPadding() {
        return BadgeWithContentHorizontalPadding;
    }

    public static final float getBadgeWithContentHorizontalOffset() {
        return BadgeWithContentHorizontalOffset;
    }

    public static final float getBadgeWithContentVerticalOffset() {
        return BadgeWithContentVerticalOffset;
    }

    public static final float getBadgeOffset() {
        return BadgeOffset;
    }
}
