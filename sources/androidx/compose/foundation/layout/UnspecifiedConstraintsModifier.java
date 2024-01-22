package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u001c\u0010\u001b\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J)\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001c\u0010%\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\u001c\u0010&\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0015H\u0016R\u001c\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinHeight-D9Ej5fM", "()F", "F", "getMinWidth-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
final class UnspecifiedConstraintsModifier extends InspectorValueInfo implements LayoutModifier {
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ UnspecifiedConstraintsModifier(float f, float f2, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, function1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnspecifiedConstraintsModifier(float f, float f2, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.Companion.m6006getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.m6006getUnspecifiedD9Ej5fM() : f2, function1, (DefaultConstructorMarker) null);
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m845getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m844getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    private UnspecifiedConstraintsModifier(float minWidth2, float minHeight2, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        this.minWidth = minWidth2;
        this.minHeight = minHeight2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m846measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (Dp.m5991equalsimpl0(this.minWidth, Dp.Companion.m6006getUnspecifiedD9Ej5fM()) || Constraints.m5932getMinWidthimpl(constraints) != 0) {
            i = Constraints.m5932getMinWidthimpl(constraints);
        } else {
            i = RangesKt.coerceAtLeast(RangesKt.coerceAtMost($this$measure_u2d3p2s80s.m5961roundToPx0680j_4(this.minWidth), Constraints.m5930getMaxWidthimpl(constraints)), 0);
        }
        int r2 = Constraints.m5930getMaxWidthimpl(constraints);
        if (Dp.m5991equalsimpl0(this.minHeight, Dp.Companion.m6006getUnspecifiedD9Ej5fM()) || Constraints.m5931getMinHeightimpl(constraints) != 0) {
            i2 = Constraints.m5931getMinHeightimpl(constraints);
        } else {
            i2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost($this$measure_u2d3p2s80s.m5961roundToPx0680j_4(this.minHeight), Constraints.m5929getMaxHeightimpl(constraints)), 0);
        }
        Placeable placeable = measurable.m4863measureBRTryo0(ConstraintsKt.Constraints(i, r2, i2, Constraints.m5929getMaxHeightimpl(constraints)));
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, placeable.getWidth(), placeable.getHeight(), (Map) null, new UnspecifiedConstraintsModifier$measure$1(placeable), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return RangesKt.coerceAtLeast(measurable.minIntrinsicWidth(height), !Dp.m5991equalsimpl0(this.minWidth, Dp.Companion.m6006getUnspecifiedD9Ej5fM()) ? $this$minIntrinsicWidth.m5961roundToPx0680j_4(this.minWidth) : 0);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return RangesKt.coerceAtLeast(measurable.maxIntrinsicWidth(height), !Dp.m5991equalsimpl0(this.minWidth, Dp.Companion.m6006getUnspecifiedD9Ej5fM()) ? $this$maxIntrinsicWidth.m5961roundToPx0680j_4(this.minWidth) : 0);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return RangesKt.coerceAtLeast(measurable.minIntrinsicHeight(width), !Dp.m5991equalsimpl0(this.minHeight, Dp.Companion.m6006getUnspecifiedD9Ej5fM()) ? $this$minIntrinsicHeight.m5961roundToPx0680j_4(this.minHeight) : 0);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return RangesKt.coerceAtLeast(measurable.maxIntrinsicHeight(width), !Dp.m5991equalsimpl0(this.minHeight, Dp.Companion.m6006getUnspecifiedD9Ej5fM()) ? $this$maxIntrinsicHeight.m5961roundToPx0680j_4(this.minHeight) : 0);
    }

    public boolean equals(Object other) {
        if ((other instanceof UnspecifiedConstraintsModifier) && Dp.m5991equalsimpl0(this.minWidth, ((UnspecifiedConstraintsModifier) other).minWidth) && Dp.m5991equalsimpl0(this.minHeight, ((UnspecifiedConstraintsModifier) other).minHeight)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Dp.m5992hashCodeimpl(this.minWidth) * 31) + Dp.m5992hashCodeimpl(this.minHeight);
    }
}
