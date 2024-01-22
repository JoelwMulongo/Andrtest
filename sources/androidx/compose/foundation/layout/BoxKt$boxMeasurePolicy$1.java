package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Box.kt */
final class BoxKt$boxMeasurePolicy$1 implements MeasurePolicy {
    final /* synthetic */ Alignment $alignment;
    final /* synthetic */ boolean $propagateMinConstraints;

    BoxKt$boxMeasurePolicy$1(boolean z, Alignment alignment) {
        this.$propagateMinConstraints = z;
        this.$alignment = alignment;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m712measure3p2s80s(MeasureScope $this$MeasurePolicy, List<? extends Measurable> measurables, long constraints) {
        long j;
        Placeable placeable;
        int boxHeight;
        int boxWidth;
        List<? extends Measurable> list = measurables;
        Intrinsics.checkNotNullParameter($this$MeasurePolicy, "$this$MeasurePolicy");
        Intrinsics.checkNotNullParameter(list, "measurables");
        if (measurables.isEmpty()) {
            return MeasureScope.layout$default($this$MeasurePolicy, Constraints.m5932getMinWidthimpl(constraints), Constraints.m5931getMinHeightimpl(constraints), (Map) null, BoxKt$boxMeasurePolicy$1$measure$1.INSTANCE, 4, (Object) null);
        }
        if (this.$propagateMinConstraints) {
            j = constraints;
        } else {
            j = Constraints.m5921copyZbe2FdA$default(constraints, 0, 0, 0, 0, 10, (Object) null);
        }
        long contentConstraints = j;
        if (measurables.size() == 1) {
            Measurable measurable = (Measurable) list.get(0);
            if (!BoxKt.getMatchesParentSize(measurable)) {
                placeable = measurable.m4863measureBRTryo0(contentConstraints);
                boxWidth = Math.max(Constraints.m5932getMinWidthimpl(constraints), placeable.getWidth());
                boxHeight = Math.max(Constraints.m5931getMinHeightimpl(constraints), placeable.getHeight());
            } else {
                boxWidth = Constraints.m5932getMinWidthimpl(constraints);
                boxHeight = Constraints.m5931getMinHeightimpl(constraints);
                placeable = measurable.m4863measureBRTryo0(Constraints.Companion.m5938fixedJhjzzOo(Constraints.m5932getMinWidthimpl(constraints), Constraints.m5931getMinHeightimpl(constraints)));
            }
            return MeasureScope.layout$default($this$MeasurePolicy, boxWidth, boxHeight, (Map) null, new BoxKt$boxMeasurePolicy$1$measure$2(placeable, measurable, $this$MeasurePolicy, boxWidth, boxHeight, this.$alignment), 4, (Object) null);
        }
        Placeable[] placeables = new Placeable[measurables.size()];
        Ref.IntRef boxWidth2 = new Ref.IntRef();
        boxWidth2.element = Constraints.m5932getMinWidthimpl(constraints);
        Ref.IntRef boxHeight2 = new Ref.IntRef();
        boxHeight2.element = Constraints.m5931getMinHeightimpl(constraints);
        List $this$fastForEachIndexed$iv = measurables;
        int size = $this$fastForEachIndexed$iv.size();
        boolean hasMatchParentSizeChildren = false;
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object obj = $this$fastForEachIndexed$iv.get(index$iv);
            Measurable measurable2 = (Measurable) obj;
            int index = index$iv;
            if (!BoxKt.getMatchesParentSize(measurable2)) {
                Placeable placeable2 = measurable2.m4863measureBRTryo0(contentConstraints);
                placeables[index] = placeable2;
                Object obj2 = obj;
                boxWidth2.element = Math.max(boxWidth2.element, placeable2.getWidth());
                boxHeight2.element = Math.max(boxHeight2.element, placeable2.getHeight());
            } else {
                Object item$iv = obj;
                hasMatchParentSizeChildren = true;
            }
        }
        if (hasMatchParentSizeChildren) {
            long matchParentSizeConstraints = ConstraintsKt.Constraints(boxWidth2.element != Integer.MAX_VALUE ? boxWidth2.element : 0, boxWidth2.element, boxHeight2.element != Integer.MAX_VALUE ? boxHeight2.element : 0, boxHeight2.element);
            List $this$fastForEachIndexed$iv2 = measurables;
            int size2 = $this$fastForEachIndexed$iv2.size();
            for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                Measurable measurable3 = (Measurable) $this$fastForEachIndexed$iv2.get(index$iv2);
                int index2 = index$iv2;
                if (BoxKt.getMatchesParentSize(measurable3)) {
                    placeables[index2] = measurable3.m4863measureBRTryo0(matchParentSizeConstraints);
                }
            }
        }
        long j2 = contentConstraints;
        Ref.IntRef intRef = boxHeight2;
        Ref.IntRef intRef2 = boxWidth2;
        Placeable[] placeableArr = placeables;
        return MeasureScope.layout$default($this$MeasurePolicy, boxWidth2.element, boxHeight2.element, (Map) null, new BoxKt$boxMeasurePolicy$1$measure$5(placeables, measurables, $this$MeasurePolicy, boxWidth2, boxHeight2, this.$alignment), 4, (Object) null);
    }
}
