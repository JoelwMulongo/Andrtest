package androidx.compose.material3;

import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Snackbar.kt */
final class SnackbarKt$OneRowSnackbar$2 implements MeasurePolicy {
    final /* synthetic */ String $actionTag;
    final /* synthetic */ String $dismissActionTag;
    final /* synthetic */ String $textTag;

    SnackbarKt$OneRowSnackbar$2(String str, String str2, String str3) {
        this.$actionTag = str;
        this.$dismissActionTag = str2;
        this.$textTag = str3;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2071measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        Placeable placeable;
        Object element$iv;
        Object element$iv2;
        int textPlaceY;
        int containerHeight;
        int contentHeight;
        int dismissButtonPlaceY;
        int actionButtonPlaceY;
        MeasureScope measureScope = $this$Layout;
        List<? extends Measurable> $this$firstOrNull$iv = measurables;
        long j = constraints;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter($this$firstOrNull$iv, "measurables");
        int containerWidth = Math.min(Constraints.m5930getMaxWidthimpl(constraints), measureScope.m5961roundToPx0680j_4(SnackbarKt.ContainerMaxWidth));
        String str = this.$actionTag;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            placeable = null;
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv), (Object) str)) {
                break;
            }
        }
        Measurable measurable = (Measurable) element$iv;
        Placeable actionButtonPlaceable = measurable != null ? measurable.m4863measureBRTryo0(j) : null;
        String str2 = this.$dismissActionTag;
        Iterator it2 = $this$firstOrNull$iv.iterator();
        while (true) {
            if (!it2.hasNext()) {
                element$iv2 = null;
                break;
            }
            element$iv2 = it2.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv2), (Object) str2)) {
                break;
            }
        }
        Measurable measurable2 = (Measurable) element$iv2;
        if (measurable2 != null) {
            placeable = measurable2.m4863measureBRTryo0(j);
        }
        Placeable dismissButtonPlaceable = placeable;
        int actionButtonWidth = actionButtonPlaceable != null ? actionButtonPlaceable.getWidth() : 0;
        int actionButtonHeight = actionButtonPlaceable != null ? actionButtonPlaceable.getHeight() : 0;
        int dismissButtonWidth = dismissButtonPlaceable != null ? dismissButtonPlaceable.getWidth() : 0;
        int dismissButtonHeight = dismissButtonPlaceable != null ? dismissButtonPlaceable.getHeight() : 0;
        int textMaxWidth = RangesKt.coerceAtLeast(((containerWidth - actionButtonWidth) - dismissButtonWidth) - (dismissButtonWidth == 0 ? measureScope.m5961roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing) : 0), Constraints.m5932getMinWidthimpl(constraints));
        String str3 = this.$textTag;
        for (Object element$iv3 : $this$firstOrNull$iv) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv3), (Object) str3)) {
                Placeable textPlaceable = ((Measurable) element$iv3).m4863measureBRTryo0(Constraints.m5921copyZbe2FdA$default(constraints, 0, textMaxWidth, 0, 0, 9, (Object) null));
                int firstTextBaseline = textPlaceable.get(AlignmentLineKt.getFirstBaseline());
                boolean isOneLine = true;
                if (firstTextBaseline != Integer.MIN_VALUE) {
                    int lastTextBaseline = textPlaceable.get(AlignmentLineKt.getLastBaseline());
                    if (lastTextBaseline != Integer.MIN_VALUE) {
                        if (firstTextBaseline != lastTextBaseline) {
                            isOneLine = false;
                        }
                        int dismissButtonPlaceX = containerWidth - dismissButtonWidth;
                        int actionButtonPlaceX = dismissButtonPlaceX - actionButtonWidth;
                        if (isOneLine) {
                            int minContainerHeight = measureScope.m5961roundToPx0680j_4(SnackbarTokens.INSTANCE.m2669getSingleLineContainerHeightD9Ej5fM());
                            int contentHeight2 = Math.max(actionButtonHeight, dismissButtonHeight);
                            containerHeight = Math.max(minContainerHeight, contentHeight2);
                            int textPlaceY2 = (containerHeight - textPlaceable.getHeight()) / 2;
                            if (actionButtonPlaceable != null) {
                                int it3 = actionButtonPlaceable.get(AlignmentLineKt.getFirstBaseline());
                                int i = contentHeight2;
                                if (it3 != Integer.MIN_VALUE) {
                                    contentHeight = (textPlaceY2 + firstTextBaseline) - it3;
                                } else {
                                    contentHeight = 0;
                                }
                            } else {
                                contentHeight = 0;
                            }
                            textPlaceY = textPlaceY2;
                        } else {
                            int textPlaceY3 = measureScope.m5961roundToPx0680j_4(SnackbarKt.HeightToFirstLine) - firstTextBaseline;
                            containerHeight = Math.max(measureScope.m5961roundToPx0680j_4(SnackbarTokens.INSTANCE.m2670getTwoLinesContainerHeightD9Ej5fM()), textPlaceY3 + textPlaceable.getHeight());
                            if (actionButtonPlaceable != null) {
                                actionButtonPlaceY = (containerHeight - actionButtonPlaceable.getHeight()) / 2;
                            } else {
                                actionButtonPlaceY = 0;
                            }
                            contentHeight = actionButtonPlaceY;
                            textPlaceY = textPlaceY3;
                        }
                        if (dismissButtonPlaceable != null) {
                            dismissButtonPlaceY = (containerHeight - dismissButtonPlaceable.getHeight()) / 2;
                        } else {
                            dismissButtonPlaceY = 0;
                        }
                        int i2 = dismissButtonHeight;
                        int i3 = actionButtonHeight;
                        return MeasureScope.layout$default($this$Layout, containerWidth, containerHeight, (Map) null, new SnackbarKt$OneRowSnackbar$2$measure$4(textPlaceable, textPlaceY, dismissButtonPlaceable, dismissButtonPlaceX, dismissButtonPlaceY, actionButtonPlaceable, actionButtonPlaceX, contentHeight), 4, (Object) null);
                    }
                    throw new IllegalArgumentException("No baselines for text".toString());
                }
                throw new IllegalArgumentException("No baselines for text".toString());
            }
            int i4 = dismissButtonHeight;
            int i5 = actionButtonHeight;
            Placeable placeable2 = actionButtonPlaceable;
            long j2 = constraints;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
