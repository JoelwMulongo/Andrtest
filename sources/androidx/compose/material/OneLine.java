package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
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
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0013\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u000e0\u0012¢\u0006\u0002\b\u00132\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0016R\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\t\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\n\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005R\u0019\u0010\f\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0005\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/material/OneLine;", "", "()V", "ContentLeftPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ContentRightPadding", "IconLeftPadding", "IconMinPaddedWidth", "IconVerticalPadding", "MinHeight", "MinHeightWithIcon", "TrailingRightPadding", "ListItem", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "text", "trailing", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class OneLine {
    private static final float ContentLeftPadding = Dp.m5986constructorimpl((float) 16);
    private static final float ContentRightPadding = Dp.m5986constructorimpl((float) 16);
    public static final OneLine INSTANCE = new OneLine();
    private static final float IconLeftPadding = Dp.m5986constructorimpl((float) 16);
    private static final float IconMinPaddedWidth = Dp.m5986constructorimpl((float) 40);
    private static final float IconVerticalPadding = Dp.m5986constructorimpl((float) 8);
    private static final float MinHeight = Dp.m5986constructorimpl((float) 48);
    private static final float MinHeightWithIcon = Dp.m5986constructorimpl((float) 56);
    private static final float TrailingRightPadding = Dp.m5986constructorimpl((float) 16);

    private OneLine() {
    }

    public final void ListItem(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> trailing, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Composer $composer2;
        Modifier modifier4;
        Composer $composer3;
        Composer $composer$iv;
        Function2<? super Composer, ? super Integer, Unit> function2 = icon;
        Function2<? super Composer, ? super Integer, Unit> function22 = text;
        Function2<? super Composer, ? super Integer, Unit> function23 = trailing;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function22, "text");
        Composer $composer4 = $composer.startRestartGroup(-1884451315);
        ComposerKt.sourceInformation($composer4, "C(ListItem)P(1)142@5412L1102:ListItem.kt#jmzs0o");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i2 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if ((i2 & 112) == 0) {
            $dirty |= $composer4.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if ((i2 & 896) == 0) {
            $dirty |= $composer4.changedInstance(function22) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if ((i2 & 7168) == 0) {
            $dirty |= $composer4.changedInstance(function23) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((57344 & i2) == 0) {
            $dirty |= $composer4.changed((Object) this) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if ((46811 & $dirty2) != 9362 || !$composer4.getSkipping()) {
            if (i3 != 0) {
                modifier4 = Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1884451315, $dirty2, -1, "androidx.compose.material.OneLine.ListItem (ListItem.kt:135)");
            }
            float minHeight = function2 == null ? MinHeight : MinHeightWithIcon;
            Modifier modifier$iv = SizeKt.m818heightInVpY3zN4$default(modifier4, minHeight, 0.0f, 2, (Object) null);
            $composer4.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation($composer4, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            $composer4.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            float f = minHeight;
            modifier3 = modifier4;
            Alignment.Vertical vertical = verticalAlignment$iv;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer4.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Density density$iv$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier5 = modifier$iv;
            int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                $composer4.createNode(constructor);
            } else {
                $composer4.useNode();
            }
            $composer4.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer4);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer4.enableReusing();
            Density density = density$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            function32.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer4.startReplaceableGroup(2058660585);
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv2 = $composer4;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            Composer $composer$iv3 = $composer$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            int $changed2 = ((0 >> 6) & 112) | 6;
            RowScope $this$ListItem_u24lambda_u243 = RowScopeInstance.INSTANCE;
            MeasurePolicy measurePolicy = measurePolicy$iv;
            int i4 = $changed$iv$iv$iv;
            Composer $composer5 = $composer$iv2;
            ComposerKt.sourceInformationMarkerStart($composer5, 1825884304, "C155@5989L262:ListItem.kt#jmzs0o");
            $composer5.startReplaceableGroup(1825884304);
            ComposerKt.sourceInformation($composer5, "144@5502L460");
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            if (function2 != null) {
                int i5 = $changed2;
                $composer$iv = $composer$iv3;
                int i6 = $changed$iv;
                Arrangement.Horizontal horizontal = horizontalArrangement$iv;
                Modifier r49 = SizeKt.m837widthInVpY3zN4$default($this$ListItem_u24lambda_u243.align(Modifier.Companion, Alignment.Companion.getCenterVertically()), Dp.m5986constructorimpl(IconLeftPadding + IconMinPaddedWidth), 0.0f, 2, (Object) null);
                float f2 = IconLeftPadding;
                float f3 = IconVerticalPadding;
                Modifier modifier$iv2 = PaddingKt.m764paddingqDBjuR0$default(r49, f2, f3, 0.0f, f3, 4, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenterStart();
                $composer5.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer5, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer5, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                Alignment alignment = contentAlignment$iv;
                $composer5.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer5.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer5);
                Density density$iv$iv2 = (Density) consume4;
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer5);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                $composer3 = $composer4;
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier$iv2);
                Modifier modifier6 = modifier$iv2;
                int $changed$iv$iv$iv2 = ((((48 << 3) & 112) << 9) & 7168) | 6;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = materializerOf2;
                if (!($composer5.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer5.startReusableNode();
                if ($composer5.getInserting()) {
                    $composer5.createNode(constructor2);
                } else {
                    $composer5.useNode();
                }
                $composer5.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2787constructorimpl($composer5);
                Function0<ComposeUiNode> function02 = constructor2;
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer5.enableReusing();
                Density density2 = density$iv$iv2;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
                function35.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer5.startReplaceableGroup(2058660585);
                Composer $composer$iv4 = $composer5;
                int i7 = $changed$iv$iv$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                int i8 = ((48 >> 6) & 112) | 6;
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function36 = function35;
                int i9 = ($changed$iv$iv$iv2 >> 9) & 14;
                Composer $composer6 = $composer$iv4;
                ComposerKt.sourceInformationMarkerStart($composer6, 1962584985, "C153@5954L6:ListItem.kt#jmzs0o");
                function2.invoke($composer6, Integer.valueOf(($dirty2 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                $composer5.endReplaceableGroup();
                $composer5.endNode();
                $composer5.endReplaceableGroup();
                $composer5.endReplaceableGroup();
            } else {
                $composer$iv = $composer$iv3;
                int i10 = $changed2;
                $composer3 = $composer4;
                int i11 = $changed$iv;
                Arrangement.Horizontal horizontal2 = horizontalArrangement$iv;
            }
            $composer5.endReplaceableGroup();
            Modifier modifier$iv3 = PaddingKt.m764paddingqDBjuR0$default($this$ListItem_u24lambda_u243.align(RowScope.weight$default($this$ListItem_u24lambda_u243, Modifier.Companion, 1.0f, false, 2, (Object) null), Alignment.Companion.getCenterVertically()), ContentLeftPadding, 0.0f, ContentRightPadding, 0.0f, 10, (Object) null);
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenterStart();
            $composer5.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer5, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer5, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            Alignment alignment2 = contentAlignment$iv2;
            $composer5.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume7 = $composer5.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Density density$iv$iv3 = (Density) consume7;
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume8 = $composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer5);
            LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume8;
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume9 = $composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume9;
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(modifier$iv3);
            Modifier modifier7 = modifier$iv3;
            int $changed$iv$iv$iv3 = (($changed$iv$iv << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function37 = materializerOf3;
            int i12 = $changed$iv$iv;
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                $composer5.createNode(constructor3);
            } else {
                $composer5.useNode();
            }
            $composer5.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m2787constructorimpl($composer5);
            Function0<ComposeUiNode> function03 = constructor3;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer5.enableReusing();
            Density density3 = density$iv$iv3;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function38 = function37;
            function38.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
            $composer5.startReplaceableGroup(2058660585);
            int i13 = ($changed$iv$iv$iv3 >> 9) & 14;
            Composer $composer$iv5 = $composer5;
            int i14 = $changed$iv$iv$iv3;
            ComposerKt.sourceInformationMarkerStart($composer$iv5, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            int i15 = ((48 >> 6) & 112) | 6;
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function39 = function38;
            LayoutDirection layoutDirection2 = layoutDirection$iv$iv3;
            Composer $composer7 = $composer$iv5;
            ComposerKt.sourceInformationMarkerStart($composer7, 1962585274, "C160@6243L6:ListItem.kt#jmzs0o");
            text.invoke($composer7, Integer.valueOf(($dirty2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
            $composer5.endReplaceableGroup();
            $composer5.endNode();
            $composer5.endReplaceableGroup();
            $composer5.endReplaceableGroup();
            $composer2 = $composer3;
            $composer2.startReplaceableGroup(-2068381427);
            ComposerKt.sourceInformation($composer2, "162@6304L186");
            Function2<? super Composer, ? super Integer, Unit> function24 = trailing;
            if (function24 != null) {
                Modifier modifier$iv4 = PaddingKt.m764paddingqDBjuR0$default($this$ListItem_u24lambda_u243.align(Modifier.Companion, Alignment.Companion.getCenterVertically()), 0.0f, 0.0f, TrailingRightPadding, 0.0f, 11, (Object) null);
                $composer5.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer5, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv4 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, false, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                RowScope rowScope = $this$ListItem_u24lambda_u243;
                $composer5.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer5, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume10 = $composer5.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer5);
                Density density$iv$iv4 = (Density) consume10;
                Alignment alignment3 = contentAlignment$iv3;
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume11 = $composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposerKt.sourceInformationMarkerEnd($composer5);
                LayoutDirection layoutDirection$iv$iv4 = (LayoutDirection) consume11;
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume12 = $composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ViewConfiguration viewConfiguration$iv$iv4 = (ViewConfiguration) consume12;
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv4);
                Modifier modifier8 = modifier$iv4;
                int $changed$iv$iv$iv4 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                if (!($composer5.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer5.startReusableNode();
                if ($composer5.getInserting()) {
                    $composer5.createNode(constructor4);
                } else {
                    $composer5.useNode();
                }
                $composer5.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv4 = Updater.m2787constructorimpl($composer5);
                Function0<ComposeUiNode> function04 = constructor4;
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv4, density$iv$iv4, ComposeUiNode.Companion.getSetDensity());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv4, layoutDirection$iv$iv4, ComposeUiNode.Companion.getSetLayoutDirection());
                Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv4, viewConfiguration$iv$iv4, ComposeUiNode.Companion.getSetViewConfiguration());
                $composer5.enableReusing();
                skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv4 >> 3) & 112));
                $composer5.startReplaceableGroup(2058660585);
                int i16 = ($changed$iv$iv$iv4 >> 9) & 14;
                Composer $composer$iv6 = $composer5;
                Density density4 = density$iv$iv4;
                ComposerKt.sourceInformationMarkerStart($composer$iv6, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                int i17 = ((0 >> 6) & 112) | 6;
                BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                int i18 = $changed$iv$iv$iv4;
                ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv4;
                Composer $composer8 = $composer$iv6;
                ComposerKt.sourceInformationMarkerStart($composer8, 1962585509, "C166@6478L10:ListItem.kt#jmzs0o");
                function24.invoke($composer8, Integer.valueOf(($dirty2 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd($composer8);
                ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                $composer5.endReplaceableGroup();
                $composer5.endNode();
                $composer5.endReplaceableGroup();
                $composer5.endReplaceableGroup();
            }
            $composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer4.skipToGroupEnd();
            modifier3 = modifier2;
            Function2<? super Composer, ? super Integer, Unit> function25 = function23;
            $composer2 = $composer4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new OneLine$ListItem$2(this, modifier3, icon, text, trailing, $changed, i));
        }
    }
}
