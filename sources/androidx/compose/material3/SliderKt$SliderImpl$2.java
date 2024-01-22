package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$SliderImpl$2 implements MeasurePolicy {
    final /* synthetic */ float $positionFraction;
    final /* synthetic */ MutableState<Float> $thumbWidth;
    final /* synthetic */ MutableState<Integer> $totalWidth;

    SliderKt$SliderImpl$2(MutableState<Float> mutableState, MutableState<Integer> mutableState2, float f) {
        this.$thumbWidth = mutableState;
        this.$totalWidth = mutableState2;
        this.$positionFraction = f;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2062measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        boolean z;
        List<? extends Measurable> $this$first$iv = measurables;
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter($this$first$iv, "measurables");
        for (Object element$iv : $this$first$iv) {
            if (LayoutIdKt.getLayoutId((Measurable) element$iv) == SliderComponents.THUMB) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                Placeable thumbPlaceable = ((Measurable) element$iv).m4863measureBRTryo0(constraints);
                int maxTrackWidth = Constraints.m5930getMaxWidthimpl(constraints) - thumbPlaceable.getWidth();
                for (Object element$iv2 : $this$first$iv) {
                    if (LayoutIdKt.getLayoutId((Measurable) element$iv2) == SliderComponents.TRACK) {
                        Placeable trackPlaceable = ((Measurable) element$iv2).m4863measureBRTryo0(Constraints.m5921copyZbe2FdA$default(constraints, 0, maxTrackWidth, 0, 0, 8, (Object) null));
                        int sliderWidth = thumbPlaceable.getWidth() + trackPlaceable.getWidth();
                        int sliderHeight = Math.max(trackPlaceable.getHeight(), thumbPlaceable.getHeight());
                        this.$thumbWidth.setValue(Float.valueOf((float) thumbPlaceable.getWidth()));
                        this.$totalWidth.setValue(Integer.valueOf(sliderWidth));
                        return MeasureScope.layout$default($this$Layout, sliderWidth, sliderHeight, (Map) null, new SliderKt$SliderImpl$2$measure$1(trackPlaceable, thumbPlaceable.getWidth() / 2, (sliderHeight - trackPlaceable.getHeight()) / 2, thumbPlaceable, MathKt.roundToInt(((float) trackPlaceable.getWidth()) * this.$positionFraction), (sliderHeight - thumbPlaceable.getHeight()) / 2), 4, (Object) null);
                    }
                    long j = constraints;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
