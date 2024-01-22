package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snackbar.kt */
final class SnackbarKt$TextOnlySnackbar$2 implements MeasurePolicy {
    public static final SnackbarKt$TextOnlySnackbar$2 INSTANCE = new SnackbarKt$TextOnlySnackbar$2();

    SnackbarKt$TextOnlySnackbar$2() {
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1603measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        float minHeight;
        MeasureScope measureScope = $this$Layout;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        boolean z = false;
        if (measurables.size() == 1) {
            Placeable textPlaceable = ((Measurable) CollectionsKt.first(measurables)).m4863measureBRTryo0(constraints);
            int firstBaseline = textPlaceable.get(AlignmentLineKt.getFirstBaseline());
            int lastBaseline = textPlaceable.get(AlignmentLineKt.getLastBaseline());
            if (firstBaseline != Integer.MIN_VALUE) {
                if (lastBaseline != Integer.MIN_VALUE) {
                    z = true;
                }
                if (z) {
                    if (firstBaseline == lastBaseline) {
                        minHeight = SnackbarKt.SnackbarMinHeightOneLine;
                    } else {
                        minHeight = SnackbarKt.SnackbarMinHeightTwoLines;
                    }
                    int containerHeight = Math.max(measureScope.m5961roundToPx0680j_4(minHeight), textPlaceable.getHeight());
                    return MeasureScope.layout$default($this$Layout, Constraints.m5930getMaxWidthimpl(constraints), containerHeight, (Map) null, new SnackbarKt$TextOnlySnackbar$2$measure$4(containerHeight, textPlaceable), 4, (Object) null);
                }
                throw new IllegalArgumentException("No baselines for text".toString());
            }
            throw new IllegalArgumentException("No baselines for text".toString());
        }
        long j = constraints;
        throw new IllegalArgumentException("text for Snackbar expected to have exactly only one child".toString());
    }
}
