package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BS\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u0012ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J)\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R#\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Landroidx/compose/foundation/layout/WrapContentModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "direction", "Landroidx/compose/foundation/layout/Direction;", "unbounded", "", "alignmentCallback", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/IntOffset;", "align", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/layout/Direction;ZLkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "equals", "other", "hashCode", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
final class WrapContentModifier extends InspectorValueInfo implements LayoutModifier {
    private final Object align;
    /* access modifiers changed from: private */
    public final Function2<IntSize, LayoutDirection, IntOffset> alignmentCallback;
    private final Direction direction;
    private final boolean unbounded;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WrapContentModifier(Direction direction2, boolean unbounded2, Function2<? super IntSize, ? super LayoutDirection, IntOffset> alignmentCallback2, Object align2, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        Intrinsics.checkNotNullParameter(direction2, "direction");
        Intrinsics.checkNotNullParameter(alignmentCallback2, "alignmentCallback");
        Intrinsics.checkNotNullParameter(align2, "align");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.direction = direction2;
        this.unbounded = unbounded2;
        this.alignmentCallback = alignmentCallback2;
        this.align = align2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m880measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        int i;
        Measurable measurable2 = measurable;
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable2, "measurable");
        int i2 = 0;
        int r0 = this.direction != Direction.Vertical ? 0 : Constraints.m5932getMinWidthimpl(constraints);
        if (this.direction == Direction.Horizontal) {
            i2 = Constraints.m5931getMinHeightimpl(constraints);
        }
        int i3 = Integer.MAX_VALUE;
        if (this.direction == Direction.Vertical || !this.unbounded) {
            i = Constraints.m5930getMaxWidthimpl(constraints);
        } else {
            i = Integer.MAX_VALUE;
        }
        if (this.direction == Direction.Horizontal || !this.unbounded) {
            i3 = Constraints.m5929getMaxHeightimpl(constraints);
        }
        long wrappedConstraints = ConstraintsKt.Constraints(r0, i, i2, i3);
        Placeable placeable = measurable2.m4863measureBRTryo0(wrappedConstraints);
        int wrapperWidth = RangesKt.coerceIn(placeable.getWidth(), Constraints.m5932getMinWidthimpl(constraints), Constraints.m5930getMaxWidthimpl(constraints));
        int wrapperHeight = RangesKt.coerceIn(placeable.getHeight(), Constraints.m5931getMinHeightimpl(constraints), Constraints.m5929getMaxHeightimpl(constraints));
        long j = wrappedConstraints;
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, wrapperWidth, wrapperHeight, (Map) null, new WrapContentModifier$measure$1(this, wrapperWidth, placeable, wrapperHeight, $this$measure_u2d3p2s80s), 4, (Object) null);
    }

    public boolean equals(Object other) {
        if ((other instanceof WrapContentModifier) && this.direction == ((WrapContentModifier) other).direction && this.unbounded == ((WrapContentModifier) other).unbounded && Intrinsics.areEqual(this.align, ((WrapContentModifier) other).align)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.direction.hashCode() * 31) + Boolean.hashCode(this.unbounded)) * 31) + this.align.hashCode();
    }
}
