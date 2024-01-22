package androidx.compose.material3;

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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
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
        MeasureScope measureScope = this.$this_Layout;
        float f = this.$mainAxisSpacing;
        int i = this.$mainAxisLayoutSize;
        List<Integer> list = this.$crossAxisPositions;
        int index$iv = 0;
        for (Object item$iv : this.$sequences) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            List placeables = (List) item$iv;
            int i2 = index$iv;
            int size = placeables.size();
            int[] iArr = new int[size];
            int i3 = 0;
            while (i3 < size) {
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
            int index$iv3 = 0;
            for (Object item$iv2 : placeables) {
                int index$iv4 = index$iv3 + 1;
                if (index$iv3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Placeable.PlacementScope.place$default($this$layout, (Placeable) item$iv2, mainAxisPositions[index$iv3], list.get(i2).intValue(), 0.0f, 4, (Object) null);
                index$iv3 = index$iv4;
                childrenMainAxisSizes = childrenMainAxisSizes;
                i2 = i2;
                placeables = placeables;
                mainAxisPositions = mainAxisPositions;
            }
            int[] iArr3 = childrenMainAxisSizes;
            int i5 = i2;
            List list2 = placeables;
            index$iv = index$iv2;
        }
    }
}
