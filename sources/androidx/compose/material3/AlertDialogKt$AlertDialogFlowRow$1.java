package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AlertDialog.kt */
final class AlertDialogKt$AlertDialogFlowRow$1 implements MeasurePolicy {
    final /* synthetic */ float $crossAxisSpacing;
    final /* synthetic */ float $mainAxisSpacing;

    AlertDialogKt$AlertDialogFlowRow$1(float f, float f2) {
        this.$mainAxisSpacing = f;
        this.$crossAxisSpacing = f2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1739measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        Ref.IntRef currentMainAxisSize;
        Ref.IntRef currentCrossAxisSize;
        MeasureScope measureScope = $this$Layout;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List sequences = new ArrayList();
        List crossAxisSizes = new ArrayList();
        List crossAxisPositions = new ArrayList();
        Ref.IntRef mainAxisSpace = new Ref.IntRef();
        Ref.IntRef crossAxisSpace = new Ref.IntRef();
        List currentSequence = new ArrayList();
        Ref.IntRef currentMainAxisSize2 = new Ref.IntRef();
        Ref.IntRef currentCrossAxisSize2 = new Ref.IntRef();
        for (Measurable measurable : measurables) {
            long j = constraints;
            Placeable placeable = measurable.m4863measureBRTryo0(j);
            Placeable placeable2 = placeable;
            if (!measure_3p2s80s$canAddToCurrentSequence(currentSequence, currentMainAxisSize2, $this$Layout, this.$mainAxisSpacing, j, placeable)) {
                Measurable measurable2 = measurable;
                currentCrossAxisSize = currentCrossAxisSize2;
                currentMainAxisSize = currentMainAxisSize2;
                measure_3p2s80s$startNewSequence(sequences, crossAxisSpace, $this$Layout, this.$crossAxisSpacing, currentSequence, crossAxisSizes, currentCrossAxisSize2, crossAxisPositions, mainAxisSpace, currentMainAxisSize2);
            } else {
                currentCrossAxisSize = currentCrossAxisSize2;
                currentMainAxisSize = currentMainAxisSize2;
            }
            if (!currentSequence.isEmpty()) {
                currentMainAxisSize2 = currentMainAxisSize;
                currentMainAxisSize2.element += measureScope.m5961roundToPx0680j_4(this.$mainAxisSpacing);
            } else {
                currentMainAxisSize2 = currentMainAxisSize;
            }
            Placeable placeable3 = placeable2;
            currentSequence.add(placeable3);
            currentMainAxisSize2.element += placeable3.getWidth();
            currentCrossAxisSize.element = Math.max(currentCrossAxisSize.element, placeable3.getHeight());
            currentCrossAxisSize2 = currentCrossAxisSize;
            List<? extends Measurable> list = measurables;
        }
        Ref.IntRef currentCrossAxisSize3 = currentCrossAxisSize2;
        if (!currentSequence.isEmpty()) {
            Ref.IntRef intRef = currentMainAxisSize2;
            measure_3p2s80s$startNewSequence(sequences, crossAxisSpace, $this$Layout, this.$crossAxisSpacing, currentSequence, crossAxisSizes, currentCrossAxisSize3, crossAxisPositions, mainAxisSpace, currentMainAxisSize2);
        }
        int mainAxisLayoutSize = Math.max(mainAxisSpace.element, Constraints.m5932getMinWidthimpl(constraints));
        List list2 = currentSequence;
        Ref.IntRef intRef2 = crossAxisSpace;
        Ref.IntRef intRef3 = mainAxisSpace;
        return MeasureScope.layout$default($this$Layout, mainAxisLayoutSize, Math.max(crossAxisSpace.element, Constraints.m5931getMinHeightimpl(constraints)), (Map) null, new AlertDialogKt$AlertDialogFlowRow$1$measure$1(sequences, $this$Layout, this.$mainAxisSpacing, mainAxisLayoutSize, crossAxisPositions), 4, (Object) null);
    }

    private static final boolean measure_3p2s80s$canAddToCurrentSequence(List<Placeable> currentSequence, Ref.IntRef currentMainAxisSize, MeasureScope $this_Layout, float $mainAxisSpacing2, long $constraints, Placeable placeable) {
        return currentSequence.isEmpty() || (currentMainAxisSize.element + $this_Layout.m5961roundToPx0680j_4($mainAxisSpacing2)) + placeable.getWidth() <= Constraints.m5930getMaxWidthimpl($constraints);
    }

    private static final void measure_3p2s80s$startNewSequence(List<List<Placeable>> sequences, Ref.IntRef crossAxisSpace, MeasureScope $this_Layout, float $crossAxisSpacing2, List<Placeable> currentSequence, List<Integer> crossAxisSizes, Ref.IntRef currentCrossAxisSize, List<Integer> crossAxisPositions, Ref.IntRef mainAxisSpace, Ref.IntRef currentMainAxisSize) {
        if (!sequences.isEmpty()) {
            crossAxisSpace.element += $this_Layout.m5961roundToPx0680j_4($crossAxisSpacing2);
        }
        sequences.add(CollectionsKt.toList(currentSequence));
        crossAxisSizes.add(Integer.valueOf(currentCrossAxisSize.element));
        crossAxisPositions.add(Integer.valueOf(crossAxisSpace.element));
        crossAxisSpace.element += currentCrossAxisSize.element;
        mainAxisSpace.element = Math.max(mainAxisSpace.element, currentMainAxisSize.element);
        currentSequence.clear();
        currentMainAxisSize.element = 0;
        currentCrossAxisSize.element = 0;
    }
}
