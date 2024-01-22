package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\"\u0010\t\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016J/\u0010\u000b\u001a\u00020\f*\u00020\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0013\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J\"\u0010\u0014\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"androidx/compose/foundation/layout/RowColumnImplKt$rowColumnMeasurePolicy$1", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RowColumnImpl.kt */
public final class RowColumnImplKt$rowColumnMeasurePolicy$1 implements MeasurePolicy {
    final /* synthetic */ Function5<Integer, int[], LayoutDirection, Density, int[], Unit> $arrangement;
    final /* synthetic */ float $arrangementSpacing;
    final /* synthetic */ CrossAxisAlignment $crossAxisAlignment;
    final /* synthetic */ SizeMode $crossAxisSize;
    final /* synthetic */ LayoutOrientation $orientation;

    RowColumnImplKt$rowColumnMeasurePolicy$1(LayoutOrientation $orientation2, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> $arrangement2, float $arrangementSpacing2, SizeMode $crossAxisSize2, CrossAxisAlignment $crossAxisAlignment2) {
        this.$orientation = $orientation2;
        this.$arrangement = $arrangement2;
        this.$arrangementSpacing = $arrangementSpacing2;
        this.$crossAxisSize = $crossAxisSize2;
        this.$crossAxisAlignment = $crossAxisAlignment2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m800measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        int layoutHeight;
        int layoutWidth;
        MeasureScope measureScope = $this$measure_u2d3p2s80s;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        Placeable[] placeables = new Placeable[measurables.size()];
        RowColumnMeasurementHelper rowColumnMeasureHelper = new RowColumnMeasurementHelper(this.$orientation, this.$arrangement, this.$arrangementSpacing, this.$crossAxisSize, this.$crossAxisAlignment, measurables, placeables, (DefaultConstructorMarker) null);
        Placeable[] placeableArr = placeables;
        RowColumnMeasureHelperResult measureResult = rowColumnMeasureHelper.m802measureWithoutPlacing_EkL_Y($this$measure_u2d3p2s80s, constraints, 0, measurables.size());
        if (this.$orientation == LayoutOrientation.Horizontal) {
            layoutWidth = measureResult.getMainAxisSize();
            layoutHeight = measureResult.getCrossAxisSize();
        } else {
            layoutWidth = measureResult.getCrossAxisSize();
            layoutHeight = measureResult.getMainAxisSize();
        }
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, layoutWidth, layoutHeight, (Map) null, new RowColumnImplKt$rowColumnMeasurePolicy$1$measure$1(rowColumnMeasureHelper, measureResult, measureScope), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return ((Number) RowColumnImplKt.MinIntrinsicWidthMeasureBlock(this.$orientation).invoke(measurables, Integer.valueOf(height), Integer.valueOf($this$minIntrinsicWidth.m5961roundToPx0680j_4(this.$arrangementSpacing)))).intValue();
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return ((Number) RowColumnImplKt.MinIntrinsicHeightMeasureBlock(this.$orientation).invoke(measurables, Integer.valueOf(width), Integer.valueOf($this$minIntrinsicHeight.m5961roundToPx0680j_4(this.$arrangementSpacing)))).intValue();
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return ((Number) RowColumnImplKt.MaxIntrinsicWidthMeasureBlock(this.$orientation).invoke(measurables, Integer.valueOf(height), Integer.valueOf($this$maxIntrinsicWidth.m5961roundToPx0680j_4(this.$arrangementSpacing)))).intValue();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return ((Number) RowColumnImplKt.MaxIntrinsicHeightMeasureBlock(this.$orientation).invoke(measurables, Integer.valueOf(width), Integer.valueOf($this$maxIntrinsicHeight.m5961roundToPx0680j_4(this.$arrangementSpacing)))).intValue();
    }
}
