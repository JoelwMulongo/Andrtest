package androidx.compose.foundation.lazy;

import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/compose/foundation/lazy/LazyListState$remeasurementModifier$1", "Landroidx/compose/ui/layout/RemeasurementModifier;", "onRemeasurementAvailable", "", "remeasurement", "Landroidx/compose/ui/layout/Remeasurement;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListState.kt */
public final class LazyListState$remeasurementModifier$1 implements RemeasurementModifier {
    final /* synthetic */ LazyListState this$0;

    LazyListState$remeasurementModifier$1(LazyListState $receiver) {
        this.this$0 = $receiver;
    }

    public void onRemeasurementAvailable(Remeasurement remeasurement) {
        Intrinsics.checkNotNullParameter(remeasurement, "remeasurement");
        this.this$0.setRemeasurement(remeasurement);
    }
}
