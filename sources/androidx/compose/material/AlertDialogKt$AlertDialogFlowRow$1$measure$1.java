package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlertDialog.kt */
final class AlertDialogKt$AlertDialogFlowRow$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<Integer> $crossAxisPositions;
    final /* synthetic */ int $mainAxisLayoutSize;
    final /* synthetic */ float $mainAxisSpacing;
    final /* synthetic */ List<List<Placeable>> $sequences;
    final /* synthetic */ MeasureScope $this_Layout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlertDialogKt$AlertDialogFlowRow$1$measure$1(List<List<Placeable>> list, MeasureScope measureScope, float f, int i, List<Integer> list2) {
        super(1);
        this.$sequences = list;
        this.$this_Layout = measureScope;
        this.$mainAxisSpacing = f;
        this.$mainAxisLayoutSize = i;
        this.$crossAxisPositions = list2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        List $this$fastForEachIndexed$iv = this.$sequences;
        MeasureScope measureScope = this.$this_Layout;
        float f = this.$mainAxisSpacing;
        int i = this.$mainAxisLayoutSize;
        List<Integer> list = this.$crossAxisPositions;
        int size = $this$fastForEachIndexed$iv.size();
        int index$iv = 0;
        while (index$iv < size) {
            List placeables = $this$fastForEachIndexed$iv.get(index$iv);
            int i2 = index$iv;
            int size2 = placeables.size();
            int[] iArr = new int[size2];
            int i3 = 0;
            while (i3 < size2) {
                iArr[i3] = ((Placeable) placeables.get(i3)).getWidth() + (i3 < CollectionsKt.getLastIndex(placeables) ? measureScope.m5961roundToPx0680j_4(f) : 0);
                i3++;
            }
            int[] childrenMainAxisSizes = iArr;
            Arrangement.Vertical arrangement = Arrangement.INSTANCE.getBottom();
            int length = childrenMainAxisSizes.length;
            int[] iArr2 = new int[length];
            for (int i4 = 0; i4 < length; i4++) {
                iArr2[i4] = 0;
            }
            int[] mainAxisPositions = iArr2;
            arrangement.arrange(measureScope, i, childrenMainAxisSizes, mainAxisPositions);
            List $this$fastForEachIndexed$iv2 = placeables;
            int index$iv2 = 0;
            int size3 = $this$fastForEachIndexed$iv2.size();
            while (index$iv2 < size3) {
                Placeable.PlacementScope.place$default($this$layout, (Placeable) $this$fastForEachIndexed$iv2.get(index$iv2), mainAxisPositions[index$iv2], list.get(i2).intValue(), 0.0f, 4, (Object) null);
                index$iv2++;
                childrenMainAxisSizes = childrenMainAxisSizes;
                i2 = i2;
                placeables = placeables;
                index$iv = index$iv;
                size3 = size3;
                mainAxisPositions = mainAxisPositions;
            }
            int i5 = index$iv2;
            int[] iArr3 = mainAxisPositions;
            int[] iArr4 = childrenMainAxisSizes;
            int i6 = i2;
            List list2 = placeables;
            index$iv++;
        }
    }
}
