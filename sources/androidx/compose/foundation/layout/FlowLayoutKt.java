package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000¶\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aS\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001aS\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00022\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00050\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010 \u001a\u0001\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#2*\u0010$\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2$\u0010.\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00012\u0006\u0010\u001f\u001a\u00020\u0002H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100\u001ax\u00101\u001a\u00020\u00022\f\u00102\u001a\b\u0012\u0004\u0012\u000204032#\u00105\u001a\u001f\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000206¢\u0006\u0002\b\u00132#\u0010*\u001a\u001f\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000206¢\u0006\u0002\b\u00132\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0002\u001a>\u00101\u001a\u00020\u00022\f\u00102\u001a\b\u0012\u0004\u0012\u000204032\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0002\u001a9\u0010;\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010<\u001a9\u0010=\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010>\u001aS\u0010?\u001a\u00020\u00022\f\u00102\u001a\b\u0012\u0004\u0012\u000204032#\u00105\u001a\u001f\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000206¢\u0006\u0002\b\u00132\u0006\u0010@\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0002\u001ax\u0010A\u001a\u00020\u00022\f\u00102\u001a\b\u0012\u0004\u0012\u000204032#\u00105\u001a\u001f\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000206¢\u0006\u0002\b\u00132#\u0010*\u001a\u001f\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000206¢\u0006\u0002\b\u00132\u0006\u0010@\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0002\u001a)\u0010B\u001a\u00020\u001e2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010C\u001a,\u0010D\u001a\u00020E*\u00020\u00042\u0006\u0010F\u001a\u00020G2\u0006\u0010\"\u001a\u00020#2\u0006\u0010H\u001a\u00020I2\u0006\u0010\u001f\u001a\u00020\u0002H\u0000\u001a\u001c\u0010J\u001a\u00020\u0002*\u00020K2\u0006\u0010\"\u001a\u00020#2\u0006\u00105\u001a\u00020\u0002H\u0000\u001a\u0014\u0010*\u001a\u00020\u0002*\u00020L2\u0006\u0010\"\u001a\u00020#H\u0000\u001a\u001c\u0010M\u001a\u00020\u0002*\u00020K2\u0006\u0010\"\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0002H\u0000\u001a\u0014\u00105\u001a\u00020\u0002*\u00020L2\u0006\u0010\"\u001a\u00020#H\u0000\u001a2\u0010N\u001a\u00020\u0002*\u00020K2\u0006\u0010H\u001a\u00020I2\u0006\u0010\"\u001a\u00020#2\u0014\u0010O\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010L\u0012\u0004\u0012\u00020\u00050\u0010H\u0002\",\u0010\u0000\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0001X\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006P"}, d2 = {"crossAxisColumnArrangement", "Lkotlin/Function4;", "", "", "Landroidx/compose/ui/layout/MeasureScope;", "", "crossAxisRowArrangement", "FlowColumn", "modifier", "Landroidx/compose/ui/Modifier;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "maxItemsInEachColumn", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlowRow", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "maxItemsInEachRow", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "columnMeasurementHelper", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxItemsInMainAxis", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ILandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/layout/MeasurePolicy;", "flowMeasurePolicy", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "mainAxisArrangement", "Lkotlin/Function5;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "arrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSize", "Landroidx/compose/foundation/layout/SizeMode;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisArrangement", "flowMeasurePolicy-942rkJo", "(Landroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/functions/Function5;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Lkotlin/jvm/functions/Function4;I)Landroidx/compose/ui/layout/MeasurePolicy;", "intrinsicCrossAxisSize", "children", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "mainAxisSize", "Lkotlin/Function3;", "mainAxisAvailable", "mainAxisSpacing", "mainAxisSizes", "crossAxisSizes", "mainAxisColumnArrangement", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function5;", "mainAxisRowArrangement", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function5;", "maxIntrinsicMainAxisSize", "crossAxisAvailable", "minIntrinsicMainAxisSize", "rowMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;ILandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/layout/MeasurePolicy;", "breakDownItems", "Landroidx/compose/foundation/layout/FlowResult;", "measureHelper", "Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "crossAxisMin", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "mainAxisMin", "measureAndCache", "storePlaceable", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FlowLayout.kt */
public final class FlowLayoutKt {
    private static final Function4<Integer, int[], MeasureScope, int[], Unit> crossAxisColumnArrangement = FlowLayoutKt$crossAxisColumnArrangement$1.INSTANCE;
    private static final Function4<Integer, int[], MeasureScope, int[], Unit> crossAxisRowArrangement = FlowLayoutKt$crossAxisRowArrangement$1.INSTANCE;

    public static final void FlowRow(Modifier modifier, Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment, int maxItemsInEachRow, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Arrangement.Horizontal horizontal;
        Alignment.Vertical verticalAlignment2;
        int maxItemsInEachRow2;
        Arrangement.Horizontal horizontalArrangement2;
        Modifier modifier3;
        Alignment.Vertical verticalAlignment3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(1098475987);
        ComposerKt.sourceInformation($composer2, "C(FlowRow)P(3,1,4,2)60@2401L111,65@2517L130:FlowLayout.kt#2w3rfo");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i2 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            horizontal = horizontalArrangement;
        } else if ((i2 & 112) == 0) {
            horizontal = horizontalArrangement;
            $dirty |= $composer2.changed((Object) horizontal) ? 32 : 16;
        } else {
            horizontal = horizontalArrangement;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            verticalAlignment2 = verticalAlignment;
        } else if ((i2 & 896) == 0) {
            verticalAlignment2 = verticalAlignment;
            $dirty |= $composer2.changed((Object) verticalAlignment2) ? 256 : 128;
        } else {
            verticalAlignment2 = verticalAlignment;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            maxItemsInEachRow2 = maxItemsInEachRow;
        } else if ((i2 & 7168) == 0) {
            maxItemsInEachRow2 = maxItemsInEachRow;
            $dirty |= $composer2.changed(maxItemsInEachRow2) ? 2048 : 1024;
        } else {
            maxItemsInEachRow2 = maxItemsInEachRow;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((57344 & i2) == 0) {
            $dirty |= $composer2.changed((Object) function3) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if ((46811 & $dirty2) != 9362 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                horizontalArrangement2 = Arrangement.INSTANCE.getStart();
            } else {
                horizontalArrangement2 = horizontal;
            }
            if (i5 != 0) {
                verticalAlignment2 = Alignment.Companion.getTop();
            }
            if (i6 != 0) {
                maxItemsInEachRow2 = Integer.MAX_VALUE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1098475987, $dirty2, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:53)");
            }
            MeasurePolicy measurePolicy = rowMeasurementHelper(horizontalArrangement2, verticalAlignment2, maxItemsInEachRow2, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896), 0);
            int $changed$iv = ($dirty2 << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier3);
            int $changed$iv$iv = (($changed$iv << 9) & 7168) | 6;
            int i7 = $changed$iv;
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
            Composer $this$Layout_u24lambda_u2d0$iv = Updater.m2787constructorimpl($composer2);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            Composer $composer3 = $composer2;
            MeasurePolicy measurePolicy2 = measurePolicy;
            int i8 = ($changed$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 483375088, "C66@2562L9:FlowLayout.kt#2w3rfo");
            function3.invoke(RowScopeInstance.INSTANCE, $composer3, Integer.valueOf((($dirty2 >> 9) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            verticalAlignment3 = verticalAlignment2;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            horizontalArrangement2 = horizontal;
            verticalAlignment3 = verticalAlignment2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new FlowLayoutKt$FlowRow$2(modifier3, horizontalArrangement2, verticalAlignment3, maxItemsInEachRow2, content, $changed, i));
        }
    }

    public static final void FlowColumn(Modifier modifier, Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontalAlignment, int maxItemsInEachColumn, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        Arrangement.Vertical vertical;
        Alignment.Horizontal horizontalAlignment2;
        int maxItemsInEachColumn2;
        Arrangement.Vertical verticalArrangement2;
        Modifier modifier3;
        Alignment.Horizontal horizontalAlignment3;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(-310290901);
        ComposerKt.sourceInformation($composer2, "C(FlowColumn)P(3,4,1,2)110@4218L117,115@4340L133:FlowLayout.kt#2w3rfo");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if ((i2 & 14) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed((Object) modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
            vertical = verticalArrangement;
        } else if ((i2 & 112) == 0) {
            vertical = verticalArrangement;
            $dirty |= $composer2.changed((Object) vertical) ? 32 : 16;
        } else {
            vertical = verticalArrangement;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            horizontalAlignment2 = horizontalAlignment;
        } else if ((i2 & 896) == 0) {
            horizontalAlignment2 = horizontalAlignment;
            $dirty |= $composer2.changed((Object) horizontalAlignment2) ? 256 : 128;
        } else {
            horizontalAlignment2 = horizontalAlignment;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            maxItemsInEachColumn2 = maxItemsInEachColumn;
        } else if ((i2 & 7168) == 0) {
            maxItemsInEachColumn2 = maxItemsInEachColumn;
            $dirty |= $composer2.changed(maxItemsInEachColumn2) ? 2048 : 1024;
        } else {
            maxItemsInEachColumn2 = maxItemsInEachColumn;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if ((57344 & i2) == 0) {
            $dirty |= $composer2.changed((Object) function3) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if ((46811 & $dirty2) != 9362 || !$composer2.getSkipping()) {
            if (i3 != 0) {
                modifier3 = Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                verticalArrangement2 = Arrangement.INSTANCE.getTop();
            } else {
                verticalArrangement2 = vertical;
            }
            if (i5 != 0) {
                horizontalAlignment2 = Alignment.Companion.getStart();
            }
            if (i6 != 0) {
                maxItemsInEachColumn2 = Integer.MAX_VALUE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-310290901, $dirty2, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:103)");
            }
            MeasurePolicy measurePolicy = columnMeasurementHelper(verticalArrangement2, horizontalAlignment2, maxItemsInEachColumn2, $composer2, (($dirty2 >> 3) & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896), 0);
            int $changed$iv = ($dirty2 << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier3);
            int $changed$iv$iv = (($changed$iv << 9) & 7168) | 6;
            int i7 = $changed$iv;
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
            Composer $this$Layout_u24lambda_u2d0$iv = Updater.m2787constructorimpl($composer2);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            Composer $composer3 = $composer2;
            MeasurePolicy measurePolicy2 = measurePolicy;
            int i8 = ($changed$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -681937629, "C116@4388L9:FlowLayout.kt#2w3rfo");
            function3.invoke(ColumnScopeInstance.INSTANCE, $composer3, Integer.valueOf((($dirty2 >> 9) & 112) | 6));
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            horizontalAlignment3 = horizontalAlignment2;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            verticalArrangement2 = vertical;
            horizontalAlignment3 = horizontalAlignment2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new FlowLayoutKt$FlowColumn$2(modifier3, verticalArrangement2, horizontalAlignment3, maxItemsInEachColumn2, content, $changed, i));
        }
    }

    private static final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> mainAxisRowArrangement(Arrangement.Horizontal horizontalArrangement, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(746410833);
        ComposerKt.sourceInformation($composer, "C(mainAxisRowArrangement)125@4646L252:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(746410833, $changed, -1, "androidx.compose.foundation.layout.mainAxisRowArrangement (FlowLayout.kt:123)");
        }
        int i = $changed & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) horizontalArrangement);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function5) new FlowLayoutKt$mainAxisRowArrangement$1$1(horizontalArrangement);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function5<Integer, int[], LayoutDirection, Density, int[], Unit> function5 = (Function5) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function5;
    }

    private static final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> mainAxisColumnArrangement(Arrangement.Vertical verticalArrangement, Composer $composer, int $changed) {
        Object value$iv$iv;
        $composer.startReplaceableGroup(-1642644113);
        ComposerKt.sourceInformation($composer, "C(mainAxisColumnArrangement)136@5068L217:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1642644113, $changed, -1, "androidx.compose.foundation.layout.mainAxisColumnArrangement (FlowLayout.kt:134)");
        }
        int i = $changed & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) verticalArrangement);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function5) new FlowLayoutKt$mainAxisColumnArrangement$1$1(verticalArrangement);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Function5<Integer, int[], LayoutDirection, Density, int[], Unit> function5 = (Function5) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return function5;
    }

    private static final MeasurePolicy rowMeasurementHelper(Arrangement.Horizontal horizontalArrangement, Alignment.Vertical verticalAlignment, int maxItemsInMainAxis, Composer $composer, int $changed, int i) {
        Alignment.Vertical verticalAlignment2;
        Object value$iv$iv;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(1479255111);
        ComposerKt.sourceInformation(composer, "C(rowMeasurementHelper)P(!1,2)163@6016L45,164@6091L90,167@6193L499:FlowLayout.kt#2w3rfo");
        Arrangement.Horizontal horizontalArrangement2 = (i & 1) != 0 ? Arrangement.INSTANCE.getEnd() : horizontalArrangement;
        if ((i & 2) != 0) {
            verticalAlignment2 = Alignment.Companion.getTop();
        } else {
            verticalAlignment2 = verticalAlignment;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1479255111, i2, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:158)");
        }
        Function5<Integer, int[], LayoutDirection, Density, int[], Unit> mainAxisRowArrangement = mainAxisRowArrangement(horizontalArrangement2, composer, i2 & 14);
        int i3 = (i2 >> 3) & 14;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) verticalAlignment2);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = CrossAxisAlignment.Companion.vertical$foundation_layout_release(verticalAlignment2);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        CrossAxisAlignment crossAxisAlignment = (CrossAxisAlignment) value$iv$iv;
        Object key3$iv = Integer.valueOf(maxItemsInMainAxis);
        int i4 = (i2 & 14) | (i2 & 112) | (i2 & 896);
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv2 = $composer;
        boolean invalid$iv$iv2 = composer.changed((Object) horizontalArrangement2) | composer.changed((Object) verticalAlignment2) | composer.changed(key3$iv);
        Object value$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv2 || value$iv$iv2 == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv2;
            value$iv$iv2 = m730flowMeasurePolicy942rkJo(LayoutOrientation.Horizontal, mainAxisRowArrangement, horizontalArrangement2.m685getSpacingD9Ej5fM(), SizeMode.Wrap, crossAxisAlignment, crossAxisRowArrangement, maxItemsInMainAxis);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            Object obj2 = value$iv$iv2;
            Composer composer2 = $this$cache$iv$iv2;
        }
        $composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) value$iv$iv2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return measurePolicy;
    }

    private static final MeasurePolicy columnMeasurementHelper(Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontalAlignment, int maxItemsInMainAxis, Composer $composer, int $changed, int i) {
        Alignment.Horizontal horizontalAlignment2;
        Object value$iv$iv;
        Composer composer = $composer;
        int i2 = $changed;
        composer.startReplaceableGroup(-2013098357);
        ComposerKt.sourceInformation(composer, "C(columnMeasurementHelper)P(2)186@6953L46,187@7029L96,190@7137L497:FlowLayout.kt#2w3rfo");
        Arrangement.Vertical verticalArrangement2 = (i & 1) != 0 ? Arrangement.INSTANCE.getTop() : verticalArrangement;
        if ((i & 2) != 0) {
            horizontalAlignment2 = Alignment.Companion.getStart();
        } else {
            horizontalAlignment2 = horizontalAlignment;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013098357, i2, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:181)");
        }
        Function5<Integer, int[], LayoutDirection, Density, int[], Unit> mainAxisColumnArrangement = mainAxisColumnArrangement(verticalArrangement2, composer, i2 & 14);
        int i3 = (i2 >> 3) & 14;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) horizontalAlignment2);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = CrossAxisAlignment.Companion.horizontal$foundation_layout_release(horizontalAlignment2);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        CrossAxisAlignment crossAxisAlignment = (CrossAxisAlignment) value$iv$iv;
        Object key3$iv = Integer.valueOf(maxItemsInMainAxis);
        int i4 = (i2 & 14) | (i2 & 112) | (i2 & 896);
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv2 = $composer;
        boolean invalid$iv$iv2 = composer.changed((Object) verticalArrangement2) | composer.changed((Object) horizontalAlignment2) | composer.changed(key3$iv);
        Object value$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv2 || value$iv$iv2 == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv2;
            value$iv$iv2 = m730flowMeasurePolicy942rkJo(LayoutOrientation.Vertical, mainAxisColumnArrangement, verticalArrangement2.m699getSpacingD9Ej5fM(), SizeMode.Wrap, crossAxisAlignment, crossAxisColumnArrangement, maxItemsInMainAxis);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            Object obj2 = value$iv$iv2;
            Composer composer2 = $this$cache$iv$iv2;
        }
        $composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) value$iv$iv2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return measurePolicy;
    }

    /* renamed from: flowMeasurePolicy-942rkJo  reason: not valid java name */
    private static final MeasurePolicy m730flowMeasurePolicy942rkJo(LayoutOrientation orientation, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> mainAxisArrangement, float arrangementSpacing, SizeMode crossAxisSize, CrossAxisAlignment crossAxisAlignment, Function4<? super Integer, ? super int[], ? super MeasureScope, ? super int[], Unit> crossAxisArrangement, int maxItemsInMainAxis) {
        return new FlowLayoutKt$flowMeasurePolicy$1(orientation, mainAxisArrangement, arrangementSpacing, crossAxisSize, crossAxisAlignment, maxItemsInMainAxis, crossAxisArrangement);
    }

    /* access modifiers changed from: private */
    public static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> children, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> mainAxisSize, int crossAxisAvailable, int mainAxisSpacing, int maxItemsInMainAxis) {
        int fixedSpace = 0;
        int currentFixedSpace = 0;
        int lastBreak = 0;
        List $this$fastForEachIndexed$iv = children;
        int size = $this$fastForEachIndexed$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            int index = index$iv;
            int size2 = mainAxisSize.invoke((IntrinsicMeasurable) $this$fastForEachIndexed$iv.get(index$iv), Integer.valueOf(index), Integer.valueOf(crossAxisAvailable)).intValue() + mainAxisSpacing;
            if ((index + 1) - lastBreak == maxItemsInMainAxis || index + 1 == children.size()) {
                lastBreak = index;
                fixedSpace = Math.max(fixedSpace, currentFixedSpace + size2);
                currentFixedSpace = 0;
            } else {
                currentFixedSpace += size2;
            }
        }
        Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3 = mainAxisSize;
        int i = maxItemsInMainAxis;
        return fixedSpace;
    }

    /* access modifiers changed from: private */
    public static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> children, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> mainAxisSize, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> crossAxisSize, int crossAxisAvailable, int mainAxisSpacing, int maxItemsInMainAxis) {
        int i = crossAxisAvailable;
        int size = children.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = 0;
        }
        int[] mainAxisSizes = iArr;
        int size2 = children.size();
        int[] iArr2 = new int[size2];
        for (int i3 = 0; i3 < size2; i3++) {
            iArr2[i3] = 0;
        }
        int[] crossAxisSizes = iArr2;
        int size3 = children.size();
        for (int index = 0; index < size3; index++) {
            IntrinsicMeasurable child = (IntrinsicMeasurable) children.get(index);
            int mainAxisItemSize = mainAxisSize.invoke(child, Integer.valueOf(index), Integer.valueOf(crossAxisAvailable)).intValue();
            mainAxisSizes[index] = mainAxisItemSize;
            crossAxisSizes[index] = crossAxisSize.invoke(child, Integer.valueOf(index), Integer.valueOf(mainAxisItemSize)).intValue();
        }
        List<? extends IntrinsicMeasurable> list = children;
        Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3 = mainAxisSize;
        Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32 = crossAxisSize;
        int index2 = ArraysKt.sum(mainAxisSizes);
        int mainAxisUsed = index2;
        if (!(crossAxisSizes.length == 0)) {
            int crossAxisUsed = crossAxisSizes[0];
            IntIterator it = new IntRange(1, ArraysKt.getLastIndex(crossAxisSizes)).iterator();
            while (it.hasNext()) {
                int it2 = crossAxisSizes[it.nextInt()];
                if (crossAxisUsed < it2) {
                    crossAxisUsed = it2;
                }
            }
            if (!(mainAxisSizes.length == 0)) {
                int minimumItemSize = mainAxisSizes[0];
                IntIterator it3 = new IntRange(1, ArraysKt.getLastIndex(mainAxisSizes)).iterator();
                while (it3.hasNext()) {
                    int it4 = mainAxisSizes[it3.nextInt()];
                    if (minimumItemSize < it4) {
                        minimumItemSize = it4;
                    }
                }
                int crossAxisUsed2 = crossAxisUsed;
                int low = minimumItemSize;
                int high = index2;
                while (low < high && crossAxisUsed2 != i) {
                    int mid = (low + high) / 2;
                    int mainAxisUsed2 = mid;
                    int high2 = high;
                    crossAxisUsed2 = intrinsicCrossAxisSize(children, mainAxisSizes, crossAxisSizes, mainAxisUsed2, mainAxisSpacing, maxItemsInMainAxis);
                    if (crossAxisUsed2 == i) {
                        return mainAxisUsed2;
                    }
                    if (crossAxisUsed2 > i) {
                        low = mid + 1;
                        mainAxisUsed = mainAxisUsed2;
                        high = high2;
                    } else {
                        high = mid - 1;
                        mainAxisUsed = mainAxisUsed2;
                    }
                }
                return mainAxisUsed;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    private static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> children, int[] mainAxisSizes, int[] crossAxisSizes, int mainAxisAvailable, int mainAxisSpacing, int maxItemsInMainAxis) {
        return intrinsicCrossAxisSize(children, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) new FlowLayoutKt$intrinsicCrossAxisSize$1(mainAxisSizes), (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) new FlowLayoutKt$intrinsicCrossAxisSize$2(crossAxisSizes), mainAxisAvailable, mainAxisSpacing, maxItemsInMainAxis);
    }

    /* access modifiers changed from: private */
    public static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> children, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> mainAxisSize, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> crossAxisSize, int mainAxisAvailable, int mainAxisSpacing, int maxItemsInMainAxis) {
        int i;
        List<? extends IntrinsicMeasurable> list = children;
        Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3 = mainAxisSize;
        Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32 = crossAxisSize;
        if (children.isEmpty()) {
            return 0;
        }
        Object nextChild = CollectionsKt.getOrNull(list, 0);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) nextChild;
        int nextCrossAxisSize = intrinsicMeasurable != null ? function32.invoke(intrinsicMeasurable, 0, Integer.valueOf(mainAxisAvailable)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) nextChild;
        int nextMainAxisSize = intrinsicMeasurable2 != null ? function3.invoke(intrinsicMeasurable2, 0, Integer.valueOf(nextCrossAxisSize)).intValue() : 0;
        int remaining = mainAxisAvailable;
        int lastBreak = 0;
        int totalCrossAxisSize = 0;
        int lastBreak2 = 0;
        List $this$fastForEachIndexed$iv = children;
        int index$iv = 0;
        int size = $this$fastForEachIndexed$iv.size();
        while (index$iv < size) {
            IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) $this$fastForEachIndexed$iv.get(index$iv);
            int index = index$iv;
            Intrinsics.checkNotNull(nextChild);
            remaining -= nextMainAxisSize;
            int childCrossAxisSize = nextCrossAxisSize;
            lastBreak = Math.max(lastBreak, childCrossAxisSize);
            Object obj = nextChild;
            nextChild = CollectionsKt.getOrNull(list, index + 1);
            IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) nextChild;
            if (intrinsicMeasurable4 != null) {
                int i2 = childCrossAxisSize;
                int i3 = nextMainAxisSize;
                i = function32.invoke(intrinsicMeasurable4, Integer.valueOf(index + 1), Integer.valueOf(mainAxisAvailable)).intValue();
            } else {
                int i4 = nextMainAxisSize;
                i = 0;
            }
            nextCrossAxisSize = i;
            IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) nextChild;
            int nextMainAxisSize2 = intrinsicMeasurable5 != null ? function3.invoke(intrinsicMeasurable5, Integer.valueOf(index + 1), Integer.valueOf(nextCrossAxisSize)).intValue() + mainAxisSpacing : 0;
            if (remaining < 0 || index + 1 == children.size()) {
                int i5 = maxItemsInMainAxis;
            } else if ((index + 1) - lastBreak2 != maxItemsInMainAxis && remaining - nextMainAxisSize2 >= 0) {
                index$iv++;
                nextMainAxisSize = nextMainAxisSize2;
                list = children;
            }
            totalCrossAxisSize += lastBreak;
            remaining = mainAxisAvailable;
            nextMainAxisSize2 -= mainAxisSpacing;
            lastBreak2 = index + 1;
            lastBreak = 0;
            index$iv++;
            nextMainAxisSize = nextMainAxisSize2;
            list = children;
        }
        return totalCrossAxisSize;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.layout.FlowResult breakDownItems(androidx.compose.ui.layout.MeasureScope r28, androidx.compose.foundation.layout.RowColumnMeasurementHelper r29, androidx.compose.foundation.layout.LayoutOrientation r30, androidx.compose.foundation.layout.OrientationIndependentConstraints r31, int r32) {
        /*
            r6 = r28
            r7 = r30
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "measureHelper"
            r8 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "orientation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "constraints"
            r9 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 0
            r1 = 16
            r2 = 0
            androidx.compose.runtime.collection.MutableVector r3 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.foundation.layout.RowColumnMeasureHelperResult[] r4 = new androidx.compose.foundation.layout.RowColumnMeasureHelperResult[r1]
            r5 = 0
            r3.<init>(r4, r5)
            r10 = r3
            int r11 = r31.getMainAxisMax()
            int r12 = r31.getMainAxisMin()
            int r13 = r31.getCrossAxisMax()
            java.util.List r14 = r29.getMeasurables()
            androidx.compose.ui.layout.Placeable[] r15 = r29.getPlaceables()
            float r0 = r29.m801getArrangementSpacingD9Ej5fM()
            float r0 = r6.m5967toPx0680j_4(r0)
            double r0 = (double) r0
            double r0 = java.lang.Math.ceil(r0)
            float r0 = (float) r0
            int r4 = (int) r0
            androidx.compose.foundation.layout.OrientationIndependentConstraints r0 = new androidx.compose.foundation.layout.OrientationIndependentConstraints
            r0.<init>(r12, r11, r5, r13)
            r1 = r0
            java.lang.Object r0 = kotlin.collections.CollectionsKt.getOrNull(r14, r5)
            androidx.compose.ui.layout.Measurable r0 = (androidx.compose.ui.layout.Measurable) r0
            if (r0 == 0) goto L_0x0073
            androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$nextSize$1 r3 = new androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$nextSize$1
            r3.<init>(r15)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            int r0 = measureAndCache(r0, r1, r7, r3)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0074
        L_0x0073:
            r0 = 0
        L_0x0074:
            r3 = 0
            int r2 = r14.size()
            java.lang.Integer[] r2 = new java.lang.Integer[r2]
            r17 = 0
            r18 = r11
            r19 = r12
            r20 = 0
            r21 = 0
            int r5 = r14.size()
            r23 = r0
            r0 = r3
            r24 = r17
            r25 = r18
            r3 = r19
            r26 = r20
            r6 = r21
        L_0x0096:
            if (r6 >= r5) goto L_0x011f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r23)
            int r17 = r23.intValue()
            r18 = r5
            int r5 = r26 + r17
            int r25 = r25 - r17
            int r8 = r6 + 1
            java.lang.Object r8 = kotlin.collections.CollectionsKt.getOrNull(r14, r8)
            androidx.compose.ui.layout.Measurable r8 = (androidx.compose.ui.layout.Measurable) r8
            if (r8 == 0) goto L_0x00c3
            androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$1 r9 = new androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$1
            r9.<init>(r15, r6)
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            int r8 = measureAndCache(r8, r1, r7, r9)
            int r8 = r8 + r4
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x00c4
        L_0x00c3:
            r8 = 0
        L_0x00c4:
            int r9 = r6 + 1
            r27 = r12
            int r12 = r14.size()
            if (r9 >= r12) goto L_0x00e8
            int r9 = r6 + 1
            int r9 = r9 - r0
            r12 = r32
            if (r9 >= r12) goto L_0x00ea
            if (r8 == 0) goto L_0x00dd
            int r9 = r8.intValue()
            goto L_0x00de
        L_0x00dd:
            r9 = 0
        L_0x00de:
            int r9 = r25 - r9
            if (r9 >= 0) goto L_0x00e3
            goto L_0x00ea
        L_0x00e3:
            r26 = r5
            r23 = r8
            goto L_0x0113
        L_0x00e8:
            r12 = r32
        L_0x00ea:
            int r3 = java.lang.Math.max(r3, r5)
            r5 = 0
            r9 = r11
            int r0 = r6 + 1
            int r19 = r6 + 1
            java.lang.Integer r19 = java.lang.Integer.valueOf(r19)
            r2[r24] = r19
            int r24 = r24 + 1
            if (r8 == 0) goto L_0x0109
            int r19 = r8.intValue()
            int r19 = r19 - r4
            java.lang.Integer r19 = java.lang.Integer.valueOf(r19)
            goto L_0x010b
        L_0x0109:
            r19 = 0
        L_0x010b:
            r8 = r19
            r26 = r5
            r23 = r8
            r25 = r9
        L_0x0113:
            int r6 = r6 + 1
            r8 = r29
            r9 = r31
            r5 = r18
            r12 = r27
            goto L_0x0096
        L_0x011f:
            r27 = r12
            r12 = r32
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 14
            r22 = 0
            r16 = r1
            r17 = r3
            androidx.compose.foundation.layout.OrientationIndependentConstraints r5 = androidx.compose.foundation.layout.OrientationIndependentConstraints.copy$default(r16, r17, r18, r19, r20, r21, r22)
            long r5 = r5.m752toBoxConstraintsOenEA2s(r7)
            r8 = r2
            r19 = r3
            r2 = r5
            r0 = 0
            r5 = 0
            r6 = 0
            java.lang.Object r9 = kotlin.collections.ArraysKt.getOrNull((T[]) r8, (int) r6)
            java.lang.Integer r9 = (java.lang.Integer) r9
            r16 = r6
            r17 = r9
            r9 = r19
            r6 = r0
        L_0x014f:
            if (r17 == 0) goto L_0x0193
            int r18 = r17.intValue()
            r0 = r29
            r19 = r1
            r1 = r28
            r20 = r4
            r4 = r6
            r21 = r6
            r6 = r5
            r5 = r18
            androidx.compose.foundation.layout.RowColumnMeasureHelperResult r0 = r0.m802measureWithoutPlacing_EkL_Y(r1, r2, r4, r5)
            int r1 = r0.getCrossAxisSize()
            int r5 = r6 + r1
            int r1 = r0.getMainAxisSize()
            int r9 = java.lang.Math.max(r9, r1)
            r10.add(r0)
            int r6 = r17.intValue()
            int r1 = r16 + 1
            java.lang.Object r4 = kotlin.collections.ArraysKt.getOrNull((T[]) r8, (int) r1)
            r17 = r4
            java.lang.Integer r17 = (java.lang.Integer) r17
            r16 = r1
            r1 = r19
            r4 = r20
            goto L_0x014f
        L_0x0193:
            r19 = r1
            r20 = r4
            r21 = r6
            r6 = r5
            int r0 = r31.getCrossAxisMin()
            int r0 = java.lang.Math.max(r6, r0)
            int r1 = r31.getMainAxisMin()
            int r1 = java.lang.Math.max(r9, r1)
            androidx.compose.foundation.layout.FlowResult r4 = new androidx.compose.foundation.layout.FlowResult
            r4.<init>(r1, r0, r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.breakDownItems(androidx.compose.ui.layout.MeasureScope, androidx.compose.foundation.layout.RowColumnMeasurementHelper, androidx.compose.foundation.layout.LayoutOrientation, androidx.compose.foundation.layout.OrientationIndependentConstraints, int):androidx.compose.foundation.layout.FlowResult");
    }

    public static final int mainAxisMin(Measurable $this$mainAxisMin, LayoutOrientation orientation, int crossAxisSize) {
        Intrinsics.checkNotNullParameter($this$mainAxisMin, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == LayoutOrientation.Horizontal) {
            return $this$mainAxisMin.minIntrinsicWidth(crossAxisSize);
        }
        return $this$mainAxisMin.minIntrinsicHeight(crossAxisSize);
    }

    public static final int crossAxisMin(Measurable $this$crossAxisMin, LayoutOrientation orientation, int mainAxisSize) {
        Intrinsics.checkNotNullParameter($this$crossAxisMin, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == LayoutOrientation.Horizontal) {
            return $this$crossAxisMin.minIntrinsicHeight(mainAxisSize);
        }
        return $this$crossAxisMin.minIntrinsicWidth(mainAxisSize);
    }

    public static final int mainAxisSize(Placeable $this$mainAxisSize, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter($this$mainAxisSize, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return orientation == LayoutOrientation.Horizontal ? $this$mainAxisSize.getWidth() : $this$mainAxisSize.getHeight();
    }

    public static final int crossAxisSize(Placeable $this$crossAxisSize, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter($this$crossAxisSize, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return orientation == LayoutOrientation.Horizontal ? $this$crossAxisSize.getHeight() : $this$crossAxisSize.getWidth();
    }

    private static final int measureAndCache(Measurable $this$measureAndCache, OrientationIndependentConstraints constraints, LayoutOrientation orientation, Function1<? super Placeable, Unit> storePlaceable) {
        if (!(RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData($this$measureAndCache)) == 0.0f)) {
            return mainAxisMin($this$measureAndCache, orientation, Integer.MAX_VALUE);
        }
        Placeable placeable = $this$measureAndCache.m4863measureBRTryo0(OrientationIndependentConstraints.copy$default(constraints, 0, 0, 0, 0, 14, (Object) null).m752toBoxConstraintsOenEA2s(orientation));
        storePlaceable.invoke(placeable);
        return mainAxisSize(placeable, orientation);
    }
}
