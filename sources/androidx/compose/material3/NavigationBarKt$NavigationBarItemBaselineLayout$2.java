package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NavigationBar.kt */
final class NavigationBarKt$NavigationBarItemBaselineLayout$2 implements MeasurePolicy {
    final /* synthetic */ boolean $alwaysShowLabel;
    final /* synthetic */ float $animationProgress;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;

    NavigationBarKt$NavigationBarItemBaselineLayout$2(float f, Function2<? super Composer, ? super Integer, Unit> function2, boolean z) {
        this.$animationProgress = f;
        this.$label = function2;
        this.$alwaysShowLabel = z;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2004measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        int totalIndicatorWidth;
        Object element$iv;
        Placeable labelPlaceable;
        MeasureScope measureScope = $this$Layout;
        List<? extends Measurable> $this$first$iv = measurables;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter($this$first$iv, "measurables");
        for (Object element$iv2 : $this$first$iv) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv2), (Object) "icon")) {
                Placeable iconPlaceable = ((Measurable) element$iv2).m4863measureBRTryo0(constraints);
                int totalIndicatorWidth2 = iconPlaceable.getWidth() + measureScope.m5961roundToPx0680j_4(Dp.m5986constructorimpl(((float) 2) * NavigationBarKt.IndicatorHorizontalPadding));
                int animatedIndicatorWidth = MathKt.roundToInt(((float) totalIndicatorWidth2) * this.$animationProgress);
                int indicatorHeight = iconPlaceable.getHeight() + measureScope.m5961roundToPx0680j_4(Dp.m5986constructorimpl(((float) 2) * NavigationBarKt.IndicatorVerticalPadding));
                Iterable $this$first$iv2 = $this$first$iv;
                int $i$f$first = 0;
                for (Object element$iv3 : $this$first$iv2) {
                    Iterable $this$first$iv3 = $this$first$iv2;
                    int $i$f$first2 = $i$f$first;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv3), (Object) "indicatorRipple")) {
                        Placeable indicatorRipplePlaceable = ((Measurable) element$iv3).m4863measureBRTryo0(Constraints.Companion.m5938fixedJhjzzOo(totalIndicatorWidth2, indicatorHeight));
                        Iterator it = $this$first$iv.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                totalIndicatorWidth = totalIndicatorWidth2;
                                element$iv = null;
                                break;
                            }
                            element$iv = it.next();
                            totalIndicatorWidth = totalIndicatorWidth2;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv), (Object) "indicator")) {
                                break;
                            }
                            totalIndicatorWidth2 = totalIndicatorWidth;
                        }
                        Measurable measurable = (Measurable) element$iv;
                        Placeable indicatorPlaceable = measurable != null ? measurable.m4863measureBRTryo0(Constraints.Companion.m5938fixedJhjzzOo(animatedIndicatorWidth, indicatorHeight)) : null;
                        Function2 it2 = this.$label;
                        if (it2 != null) {
                            Iterable $this$first$iv4 = $this$first$iv;
                            for (Object element$iv4 : $this$first$iv4) {
                                Function2 it3 = it2;
                                Iterable $this$first$iv5 = $this$first$iv4;
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv4), (Object) "label")) {
                                    int i = indicatorHeight;
                                    int i2 = animatedIndicatorWidth;
                                    labelPlaceable = ((Measurable) element$iv4).m4863measureBRTryo0(Constraints.m5921copyZbe2FdA$default(constraints, 0, 0, 0, 0, 11, (Object) null));
                                } else {
                                    int i3 = animatedIndicatorWidth;
                                    long j = constraints;
                                    it2 = it3;
                                    $this$first$iv4 = $this$first$iv5;
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        int i4 = indicatorHeight;
                        int i5 = animatedIndicatorWidth;
                        labelPlaceable = null;
                        if (this.$label == null) {
                            int i6 = totalIndicatorWidth;
                            return NavigationBarKt.m1999placeIconX9ElhV4($this$Layout, iconPlaceable, indicatorRipplePlaceable, indicatorPlaceable, constraints);
                        }
                        Intrinsics.checkNotNull(labelPlaceable);
                        return NavigationBarKt.m2000placeLabelAndIconzUg2_y0($this$Layout, labelPlaceable, iconPlaceable, indicatorRipplePlaceable, indicatorPlaceable, constraints, this.$alwaysShowLabel, this.$animationProgress);
                    }
                    int i7 = indicatorHeight;
                    int i8 = animatedIndicatorWidth;
                    MeasureScope measureScope2 = $this$Layout;
                    $this$first$iv = measurables;
                    long j2 = constraints;
                    $this$first$iv2 = $this$first$iv3;
                    $i$f$first = $i$f$first2;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            measureScope = $this$Layout;
            $this$first$iv = measurables;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
