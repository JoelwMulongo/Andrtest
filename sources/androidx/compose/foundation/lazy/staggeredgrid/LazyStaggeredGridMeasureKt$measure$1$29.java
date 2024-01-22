package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasure.kt */
final class LazyStaggeredGridMeasureKt$measure$1$29 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<LazyStaggeredGridPositionedItem> $extraItemsAfter;
    final /* synthetic */ List<LazyStaggeredGridPositionedItem> $extraItemsBefore;
    final /* synthetic */ List<LazyStaggeredGridPositionedItem> $positionedItems;
    final /* synthetic */ LazyStaggeredGridMeasureContext $this_measure;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridMeasureKt$measure$1$29(List<LazyStaggeredGridPositionedItem> list, List<LazyStaggeredGridPositionedItem> list2, List<LazyStaggeredGridPositionedItem> list3, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        super(1);
        this.$extraItemsBefore = list;
        this.$positionedItems = list2;
        this.$extraItemsAfter = list3;
        this.$this_measure = lazyStaggeredGridMeasureContext;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        List $this$fastForEach$iv = this.$extraItemsBefore;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = this.$this_measure;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            $this$fastForEach$iv.get(index$iv).place($this$layout, lazyStaggeredGridMeasureContext);
        }
        List $this$fastForEach$iv2 = this.$positionedItems;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = this.$this_measure;
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            $this$fastForEach$iv2.get(index$iv2).place($this$layout, lazyStaggeredGridMeasureContext2);
        }
        List $this$fastForEach$iv3 = this.$extraItemsAfter;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = this.$this_measure;
        int size3 = $this$fastForEach$iv3.size();
        for (int index$iv3 = 0; index$iv3 < size3; index$iv3++) {
            $this$fastForEach$iv3.get(index$iv3).place($this$layout, lazyStaggeredGridMeasureContext3);
        }
    }
}
