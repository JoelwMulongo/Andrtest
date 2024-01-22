package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Landroidx/compose/ui/layout/RootMeasurePolicy;", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RootMeasurePolicy.kt */
public final class RootMeasurePolicy extends LayoutNode.NoIntrinsicsMeasurePolicy {
    public static final RootMeasurePolicy INSTANCE = new RootMeasurePolicy();

    private RootMeasurePolicy() {
        super("Undefined intrinsics block and it is required");
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m4913measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        List<? extends Measurable> list = measurables;
        long j = constraints;
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(list, "measurables");
        if (measurables.isEmpty()) {
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, Constraints.m5932getMinWidthimpl(constraints), Constraints.m5931getMinHeightimpl(constraints), (Map) null, RootMeasurePolicy$measure$1.INSTANCE, 4, (Object) null);
        } else if (measurables.size() == 1) {
            Placeable placeable = ((Measurable) list.get(0)).m4863measureBRTryo0(j);
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, ConstraintsKt.m5944constrainWidthK40F9xA(j, placeable.getWidth()), ConstraintsKt.m5943constrainHeightK40F9xA(j, placeable.getHeight()), (Map) null, new RootMeasurePolicy$measure$2(placeable), 4, (Object) null);
        } else {
            List list2 = measurables;
            List target$iv = new ArrayList(list2.size());
            List $this$fastForEach$iv$iv = list2;
            int size = $this$fastForEach$iv$iv.size();
            for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                target$iv.add(((Measurable) $this$fastForEach$iv$iv.get(index$iv$iv)).m4863measureBRTryo0(j));
            }
            List placeables = target$iv;
            List $this$fastForEach$iv = placeables;
            int size2 = $this$fastForEach$iv.size();
            int maxWidth = 0;
            int maxHeight = 0;
            for (int index$iv = 0; index$iv < size2; index$iv++) {
                Placeable placeable2 = (Placeable) $this$fastForEach$iv.get(index$iv);
                maxWidth = Math.max(placeable2.getWidth(), maxWidth);
                maxHeight = Math.max(placeable2.getHeight(), maxHeight);
            }
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, ConstraintsKt.m5944constrainWidthK40F9xA(j, maxWidth), ConstraintsKt.m5943constrainHeightK40F9xA(j, maxHeight), (Map) null, new RootMeasurePolicy$measure$4(placeables), 4, (Object) null);
        }
    }
}
