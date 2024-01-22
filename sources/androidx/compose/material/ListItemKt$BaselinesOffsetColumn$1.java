package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemKt$BaselinesOffsetColumn$1 implements MeasurePolicy {
    final /* synthetic */ List<Dp> $offsets;

    ListItemKt$BaselinesOffsetColumn$1(List<Dp> list) {
        this.$offsets = list;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1532measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        int $i$f$fastForEachIndexed;
        List $this$fastForEachIndexed$iv;
        int toPreviousBaseline;
        MeasureScope measureScope = $this$Layout;
        List<? extends Measurable> list = measurables;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        long childConstraints = Constraints.m5921copyZbe2FdA$default(constraints, 0, 0, 0, Integer.MAX_VALUE, 3, (Object) null);
        Iterable<Measurable> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Measurable it : $this$map$iv) {
            destination$iv$iv.add(it.m4863measureBRTryo0(childConstraints));
        }
        List<Placeable> placeables = (List) destination$iv$iv;
        int accumulator$iv = 0;
        for (Placeable placeable : placeables) {
            accumulator$iv = Math.max(accumulator$iv, placeable.getWidth());
        }
        int containerWidth = accumulator$iv;
        int size = placeables.size();
        Integer[] numArr = new Integer[size];
        for (int i = 0; i < size; i++) {
            numArr[i] = 0;
        }
        Integer[] y = numArr;
        List<Dp> list2 = this.$offsets;
        List $this$fastForEachIndexed$iv2 = placeables;
        int $i$f$fastForEachIndexed2 = false;
        int index$iv = 0;
        int size2 = $this$fastForEachIndexed$iv2.size();
        int containerHeight = 0;
        while (index$iv < size2) {
            Object item$iv = $this$fastForEachIndexed$iv2.get(index$iv);
            Placeable placeable2 = (Placeable) item$iv;
            Object obj = item$iv;
            int index = index$iv;
            if (index > 0) {
                $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
                $i$f$fastForEachIndexed = $i$f$fastForEachIndexed2;
                toPreviousBaseline = ((Placeable) placeables.get(index - 1)).getHeight() - ((Placeable) placeables.get(index - 1)).get(AlignmentLineKt.getLastBaseline());
            } else {
                $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
                $i$f$fastForEachIndexed = $i$f$fastForEachIndexed2;
                toPreviousBaseline = 0;
            }
            int topPadding = Math.max(0, (measureScope.m5961roundToPx0680j_4(list2.get(index).m6000unboximpl()) - placeable2.get(AlignmentLineKt.getFirstBaseline())) - toPreviousBaseline);
            y[index] = Integer.valueOf(topPadding + containerHeight);
            containerHeight += topPadding + placeable2.getHeight();
            index$iv++;
            $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv;
            $i$f$fastForEachIndexed2 = $i$f$fastForEachIndexed;
            List<? extends Measurable> list3 = measurables;
        }
        int i2 = $i$f$fastForEachIndexed2;
        return MeasureScope.layout$default($this$Layout, containerWidth, containerHeight, (Map) null, new ListItemKt$BaselinesOffsetColumn$1$measure$2(placeables, y), 4, (Object) null);
    }
}
