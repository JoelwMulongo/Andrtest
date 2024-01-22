package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$TopAppBarLayout$2 implements MeasurePolicy {
    final /* synthetic */ float $heightPx;
    final /* synthetic */ int $titleBottomPadding;
    final /* synthetic */ Arrangement.Horizontal $titleHorizontalArrangement;
    final /* synthetic */ Arrangement.Vertical $titleVerticalArrangement;

    AppBarKt$TopAppBarLayout$2(float f, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i) {
        this.$heightPx = f;
        this.$titleHorizontalArrangement = horizontal;
        this.$titleVerticalArrangement = vertical;
        this.$titleBottomPadding = i;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1751measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        int maxTitleWidth;
        int titleBaseline;
        List<? extends Measurable> $this$first$iv = measurables;
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter($this$first$iv, "measurables");
        for (Object element$iv : $this$first$iv) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv), (Object) "navigationIcon")) {
                Placeable navigationIconPlaceable = ((Measurable) element$iv).m4863measureBRTryo0(Constraints.m5921copyZbe2FdA$default(constraints, 0, 0, 0, 0, 14, (Object) null));
                for (Object element$iv2 : $this$first$iv) {
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv2), (Object) "actionIcons")) {
                        Placeable actionIconsPlaceable = ((Measurable) element$iv2).m4863measureBRTryo0(Constraints.m5921copyZbe2FdA$default(constraints, 0, 0, 0, 0, 14, (Object) null));
                        if (Constraints.m5930getMaxWidthimpl(constraints) == Integer.MAX_VALUE) {
                            maxTitleWidth = Constraints.m5930getMaxWidthimpl(constraints);
                        } else {
                            maxTitleWidth = RangesKt.coerceAtLeast((Constraints.m5930getMaxWidthimpl(constraints) - navigationIconPlaceable.getWidth()) - actionIconsPlaceable.getWidth(), 0);
                        }
                        for (Object element$iv3 : $this$first$iv) {
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv3), (Object) "title")) {
                                Placeable titlePlaceable = ((Measurable) element$iv3).m4863measureBRTryo0(Constraints.m5921copyZbe2FdA$default(constraints, 0, maxTitleWidth, 0, 0, 12, (Object) null));
                                if (titlePlaceable.get(AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE) {
                                    titleBaseline = titlePlaceable.get(AlignmentLineKt.getLastBaseline());
                                } else {
                                    titleBaseline = 0;
                                }
                                int layoutHeight = MathKt.roundToInt(this.$heightPx);
                                return MeasureScope.layout$default($this$Layout, Constraints.m5930getMaxWidthimpl(constraints), layoutHeight, (Map) null, new AppBarKt$TopAppBarLayout$2$measure$1(navigationIconPlaceable, layoutHeight, titlePlaceable, this.$titleHorizontalArrangement, constraints, actionIconsPlaceable, $this$Layout, this.$titleVerticalArrangement, this.$titleBottomPadding, titleBaseline), 4, (Object) null);
                            }
                            MeasureScope measureScope = $this$Layout;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    MeasureScope measureScope2 = $this$Layout;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            MeasureScope measureScope3 = $this$Layout;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
