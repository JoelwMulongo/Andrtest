package androidx.compose.material;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemKt$OffsetToBaselineOrCenter$1 implements MeasurePolicy {
    final /* synthetic */ float $offset;

    ListItemKt$OffsetToBaselineOrCenter$1(float f) {
        this.$offset = f;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1533measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        int containerHeight;
        int y;
        MeasureScope measureScope = $this$Layout;
        List<? extends Measurable> list = measurables;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Placeable placeable = ((Measurable) list.get(0)).m4863measureBRTryo0(Constraints.m5921copyZbe2FdA$default(constraints, 0, 0, 0, 0, 11, (Object) null));
        int baseline = placeable.get(AlignmentLineKt.getFirstBaseline());
        if (baseline != Integer.MIN_VALUE) {
            int y2 = measureScope.m5961roundToPx0680j_4(this.$offset) - baseline;
            y = y2;
            containerHeight = Math.max(Constraints.m5931getMinHeightimpl(constraints), placeable.getHeight() + y2);
        } else {
            int containerHeight2 = Math.max(Constraints.m5931getMinHeightimpl(constraints), placeable.getHeight());
            y = IntOffset.m6105getYimpl(Alignment.Companion.getCenter().m2805alignKFBX0sM(IntSize.Companion.m6151getZeroYbymL2g(), IntSizeKt.IntSize(0, containerHeight2 - placeable.getHeight()), $this$Layout.getLayoutDirection()));
            containerHeight = containerHeight2;
        }
        return MeasureScope.layout$default($this$Layout, placeable.getWidth(), containerHeight, (Map) null, new ListItemKt$OffsetToBaselineOrCenter$1$measure$1(placeable, y), 4, (Object) null);
    }
}
