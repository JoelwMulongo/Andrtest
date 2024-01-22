package androidx.compose.material;

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
import kotlin.ranges.RangesKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snackbar.kt */
final class SnackbarKt$OneRowSnackbar$2 implements MeasurePolicy {
    final /* synthetic */ String $actionTag;
    final /* synthetic */ String $textTag;

    SnackbarKt$OneRowSnackbar$2(String str, String str2) {
        this.$actionTag = str;
        this.$textTag = str2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1602measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        int textPlaceY;
        int containerHeight;
        int it;
        int i;
        SnackbarKt$OneRowSnackbar$2 snackbarKt$OneRowSnackbar$2 = this;
        MeasureScope measureScope = $this$Layout;
        List<? extends Measurable> $this$first$iv = measurables;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter($this$first$iv, "measurables");
        String str = snackbarKt$OneRowSnackbar$2.$actionTag;
        for (Object element$iv : $this$first$iv) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv), (Object) str)) {
                Placeable buttonPlaceable = ((Measurable) element$iv).m4863measureBRTryo0(constraints);
                int textMaxWidth = RangesKt.coerceAtLeast((Constraints.m5930getMaxWidthimpl(constraints) - buttonPlaceable.getWidth()) - measureScope.m5961roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing), Constraints.m5932getMinWidthimpl(constraints));
                String str2 = snackbarKt$OneRowSnackbar$2.$textTag;
                for (Object element$iv2 : $this$first$iv) {
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv2), (Object) str2)) {
                        Placeable textPlaceable = ((Measurable) element$iv2).m4863measureBRTryo0(Constraints.m5921copyZbe2FdA$default(constraints, 0, textMaxWidth, 0, 0, 9, (Object) null));
                        int firstTextBaseline = textPlaceable.get(AlignmentLineKt.getFirstBaseline());
                        boolean z = true;
                        if (firstTextBaseline != Integer.MIN_VALUE) {
                            int lastTextBaseline = textPlaceable.get(AlignmentLineKt.getLastBaseline());
                            if (lastTextBaseline != Integer.MIN_VALUE) {
                                if (firstTextBaseline != lastTextBaseline) {
                                    z = false;
                                }
                                boolean isOneLine = z;
                                int buttonPlaceX = Constraints.m5930getMaxWidthimpl(constraints) - buttonPlaceable.getWidth();
                                if (isOneLine) {
                                    int containerHeight2 = Math.max(measureScope.m5961roundToPx0680j_4(SnackbarKt.SnackbarMinHeightOneLine), buttonPlaceable.getHeight());
                                    int textPlaceY2 = (containerHeight2 - textPlaceable.getHeight()) / 2;
                                    int buttonBaseline = buttonPlaceable.get(AlignmentLineKt.getFirstBaseline());
                                    int i2 = buttonBaseline;
                                    int it2 = buttonBaseline;
                                    if (it2 != Integer.MIN_VALUE) {
                                        i = (textPlaceY2 + firstTextBaseline) - it2;
                                    } else {
                                        i = 0;
                                    }
                                    it = i;
                                    containerHeight = containerHeight2;
                                    textPlaceY = textPlaceY2;
                                } else {
                                    int textPlaceY3 = measureScope.m5961roundToPx0680j_4(SnackbarKt.HeightToFirstLine) - firstTextBaseline;
                                    int containerHeight3 = Math.max(measureScope.m5961roundToPx0680j_4(SnackbarKt.SnackbarMinHeightTwoLines), textPlaceY3 + textPlaceable.getHeight());
                                    it = (containerHeight3 - buttonPlaceable.getHeight()) / 2;
                                    containerHeight = containerHeight3;
                                    textPlaceY = textPlaceY3;
                                }
                                int i3 = lastTextBaseline;
                                Placeable placeable = buttonPlaceable;
                                return MeasureScope.layout$default($this$Layout, Constraints.m5930getMaxWidthimpl(constraints), containerHeight, (Map) null, new SnackbarKt$OneRowSnackbar$2$measure$4(textPlaceable, textPlaceY, buttonPlaceable, buttonPlaceX, it), 4, (Object) null);
                            }
                            throw new IllegalArgumentException("No baselines for text".toString());
                        }
                        throw new IllegalArgumentException("No baselines for text".toString());
                    }
                    Placeable placeable2 = buttonPlaceable;
                    long j = constraints;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            snackbarKt$OneRowSnackbar$2 = this;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
