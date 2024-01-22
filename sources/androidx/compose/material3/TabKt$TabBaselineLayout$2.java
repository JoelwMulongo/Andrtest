package androidx.compose.material3;

import androidx.compose.runtime.Composer;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Tab.kt */
final class TabKt$TabBaselineLayout$2 implements MeasurePolicy {
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    TabKt$TabBaselineLayout$2(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22) {
        this.$text = function2;
        this.$icon = function22;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2127measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        Placeable placeable;
        Placeable placeable2;
        float f;
        MeasureScope measureScope = $this$Layout;
        List<? extends Measurable> $this$first$iv = measurables;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter($this$first$iv, "measurables");
        if (this.$text != null) {
            for (Object element$iv : $this$first$iv) {
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv), (Object) "text")) {
                    placeable = ((Measurable) element$iv).m4863measureBRTryo0(Constraints.m5921copyZbe2FdA$default(constraints, 0, 0, 0, 0, 11, (Object) null));
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        placeable = null;
        Placeable textPlaceable = placeable;
        if (this.$icon != null) {
            for (Object element$iv2 : $this$first$iv) {
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv2), (Object) "icon")) {
                    placeable2 = ((Measurable) element$iv2).m4863measureBRTryo0(constraints);
                } else {
                    long j = constraints;
                }
            }
            long j2 = constraints;
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        long j3 = constraints;
        placeable2 = null;
        Placeable iconPlaceable = placeable2;
        int i = 0;
        int tabWidth = Math.max(textPlaceable != null ? textPlaceable.getWidth() : 0, iconPlaceable != null ? iconPlaceable.getWidth() : 0);
        if (textPlaceable == null || iconPlaceable == null) {
            f = TabKt.SmallTabHeight;
        } else {
            f = TabKt.LargeTabHeight;
        }
        int specHeight = measureScope.m5961roundToPx0680j_4(f);
        int height = iconPlaceable != null ? iconPlaceable.getHeight() : 0;
        if (textPlaceable != null) {
            i = textPlaceable.getHeight();
        }
        int tabHeight = Math.max(specHeight, height + i + measureScope.m5960roundToPxR2X_6o(TabKt.IconDistanceFromBaseline));
        int i2 = specHeight;
        Placeable placeable3 = textPlaceable;
        return MeasureScope.layout$default($this$Layout, tabWidth, tabHeight, (Map) null, new TabKt$TabBaselineLayout$2$measure$1(textPlaceable, iconPlaceable, $this$Layout, tabWidth, tabHeight, textPlaceable != null ? Integer.valueOf(textPlaceable.get(AlignmentLineKt.getFirstBaseline())) : null, textPlaceable != null ? Integer.valueOf(textPlaceable.get(AlignmentLineKt.getLastBaseline())) : null), 4, (Object) null);
    }
}
