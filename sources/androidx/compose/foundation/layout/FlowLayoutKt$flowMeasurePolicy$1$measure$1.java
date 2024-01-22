package androidx.compose.foundation.layout;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FlowLayout.kt */
final class FlowLayoutKt$flowMeasurePolicy$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ FlowResult $flowResult;
    final /* synthetic */ RowColumnMeasurementHelper $measureHelper;
    final /* synthetic */ int[] $outPosition;
    final /* synthetic */ MeasureScope $this_measure;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowLayoutKt$flowMeasurePolicy$1$measure$1(FlowResult flowResult, RowColumnMeasurementHelper rowColumnMeasurementHelper, int[] iArr, MeasureScope measureScope) {
        super(1);
        this.$flowResult = flowResult;
        this.$measureHelper = rowColumnMeasurementHelper;
        this.$outPosition = iArr;
        this.$this_measure = measureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        MutableVector this_$iv = this.$flowResult.getItems();
        RowColumnMeasurementHelper rowColumnMeasurementHelper = this.$measureHelper;
        int[] iArr = this.$outPosition;
        MeasureScope measureScope = this.$this_measure;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                rowColumnMeasurementHelper.placeHelper($this$layout, (RowColumnMeasureHelperResult) content$iv[i$iv], iArr[i$iv], measureScope.getLayoutDirection());
                i$iv++;
            } while (i$iv < size$iv);
        }
    }
}
