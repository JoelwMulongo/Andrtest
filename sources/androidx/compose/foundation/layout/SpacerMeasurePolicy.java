package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/layout/SpacerMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Spacer.kt */
final class SpacerMeasurePolicy implements MeasurePolicy {
    public static final SpacerMeasurePolicy INSTANCE = new SpacerMeasurePolicy();

    private SpacerMeasurePolicy() {
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m843measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        MeasureScope measureScope = $this$measure_u2d3p2s80s;
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        List<? extends Measurable> list = measurables;
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        long $this$measure_3p2s80s_u24lambda_u240 = constraints;
        int height = 0;
        int width = Constraints.m5928getHasFixedWidthimpl($this$measure_3p2s80s_u24lambda_u240) ? Constraints.m5930getMaxWidthimpl($this$measure_3p2s80s_u24lambda_u240) : 0;
        if (Constraints.m5927getHasFixedHeightimpl($this$measure_3p2s80s_u24lambda_u240)) {
            height = Constraints.m5929getMaxHeightimpl($this$measure_3p2s80s_u24lambda_u240);
        }
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, width, height, (Map) null, SpacerMeasurePolicy$measure$1$1.INSTANCE, 4, (Object) null);
    }
}
