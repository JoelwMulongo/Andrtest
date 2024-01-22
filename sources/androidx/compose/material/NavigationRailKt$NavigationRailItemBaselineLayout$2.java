package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationRail.kt */
final class NavigationRailKt$NavigationRailItemBaselineLayout$2 implements MeasurePolicy {
    final /* synthetic */ float $iconPositionAnimationProgress;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;

    NavigationRailKt$NavigationRailItemBaselineLayout$2(Function2<? super Composer, ? super Integer, Unit> function2, float f) {
        this.$label = function2;
        this.$iconPositionAnimationProgress = f;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1561measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        Placeable placeable;
        MeasureScope measureScope = $this$Layout;
        List<? extends Measurable> $this$first$iv = measurables;
        long j = constraints;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter($this$first$iv, "measurables");
        for (Object element$iv : $this$first$iv) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv), (Object) "icon")) {
                Placeable iconPlaceable = ((Measurable) element$iv).m4863measureBRTryo0(j);
                Function2 it = this.$label;
                if (it != null) {
                    for (Object element$iv2 : $this$first$iv) {
                        Function2 it2 = it;
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv2), (Object) "label")) {
                            placeable = ((Measurable) element$iv2).m4863measureBRTryo0(Constraints.m5921copyZbe2FdA$default(constraints, 0, 0, 0, 0, 11, (Object) null));
                        } else {
                            it = it2;
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                placeable = null;
                Placeable labelPlaceable = placeable;
                if (this.$label == null) {
                    Placeable placeable2 = iconPlaceable;
                    return NavigationRailKt.m1559placeIcon3p2s80s(measureScope, iconPlaceable, j);
                }
                Intrinsics.checkNotNull(labelPlaceable);
                Placeable placeable3 = iconPlaceable;
                return NavigationRailKt.m1560placeLabelAndIconDIyivk0($this$Layout, labelPlaceable, iconPlaceable, constraints, this.$iconPositionAnimationProgress);
            }
            j = constraints;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
