package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$TempRangeSliderTrack$2 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Color> $activeTickColor;
    final /* synthetic */ State<Color> $activeTrackColor;
    final /* synthetic */ State<Color> $inactiveTickColor;
    final /* synthetic */ State<Color> $inactiveTrackColor;
    final /* synthetic */ float $positionFractionEnd;
    final /* synthetic */ float $positionFractionStart;
    final /* synthetic */ Ref.FloatRef $thumbRadiusPx;
    final /* synthetic */ float[] $tickFractions;
    final /* synthetic */ Ref.FloatRef $tickSize;
    final /* synthetic */ float $trackStrokeWidth;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$TempRangeSliderTrack$2(Ref.FloatRef floatRef, State<Color> state, float f, float f2, float f3, State<Color> state2, float[] fArr, State<Color> state3, State<Color> state4, Ref.FloatRef floatRef2) {
        super(1);
        this.$thumbRadiusPx = floatRef;
        this.$inactiveTrackColor = state;
        this.$trackStrokeWidth = f;
        this.$positionFractionEnd = f2;
        this.$positionFractionStart = f3;
        this.$activeTrackColor = state2;
        this.$tickFractions = fArr;
        this.$inactiveTickColor = state3;
        this.$activeTickColor = state4;
        this.$tickSize = floatRef2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope $this$Canvas) {
        boolean isRtl;
        Object answer$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        boolean isRtl2 = $this$Canvas.getLayoutDirection() == LayoutDirection.Rtl;
        long sliderLeft = OffsetKt.Offset(this.$thumbRadiusPx.element, Offset.m2916getYimpl($this$Canvas.m3771getCenterF1C5BW0()));
        long sliderRight = OffsetKt.Offset(Size.m2984getWidthimpl($this$Canvas.m3772getSizeNHjbRc()) - this.$thumbRadiusPx.element, Offset.m2916getYimpl($this$Canvas.m3771getCenterF1C5BW0()));
        long sliderStart = isRtl2 ? sliderRight : sliderLeft;
        long sliderEnd = isRtl2 ? sliderLeft : sliderRight;
        long sliderEnd2 = sliderEnd;
        long sliderStart2 = sliderStart;
        DrawScope.m3740drawLineNGM6Ib0$default($this$Canvas, this.$inactiveTrackColor.getValue().m3174unboximpl(), sliderStart, sliderEnd, this.$trackStrokeWidth, StrokeCap.Companion.m3548getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        DrawScope.m3740drawLineNGM6Ib0$default($this$Canvas, this.$activeTrackColor.getValue().m3174unboximpl(), OffsetKt.Offset(Offset.m2915getXimpl(sliderStart2) + ((Offset.m2915getXimpl(sliderEnd2) - Offset.m2915getXimpl(sliderStart2)) * this.$positionFractionStart), Offset.m2916getYimpl($this$Canvas.m3771getCenterF1C5BW0())), OffsetKt.Offset(Offset.m2915getXimpl(sliderStart2) + ((Offset.m2915getXimpl(sliderEnd2) - Offset.m2915getXimpl(sliderStart2)) * this.$positionFractionEnd), Offset.m2916getYimpl($this$Canvas.m3771getCenterF1C5BW0())), this.$trackStrokeWidth, StrokeCap.Companion.m3548getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
        float[] $this$groupBy$iv = this.$tickFractions;
        float f = this.$positionFractionEnd;
        float f2 = this.$positionFractionStart;
        Map destination$iv$iv = new LinkedHashMap();
        float[] $this$groupByTo$iv$iv = $this$groupBy$iv;
        int length = $this$groupByTo$iv$iv.length;
        int i = 0;
        while (i < length) {
            float element$iv$iv = $this$groupByTo$iv$iv[i];
            float it = element$iv$iv;
            Object key$iv$iv = Boolean.valueOf(it > f || it < f2);
            Map $this$getOrPut$iv$iv$iv = destination$iv$iv;
            Object value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                isRtl = isRtl2;
                answer$iv$iv$iv = new ArrayList();
                $this$getOrPut$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
            } else {
                isRtl = isRtl2;
                answer$iv$iv$iv = value$iv$iv$iv;
            }
            ((List) answer$iv$iv$iv).add(Float.valueOf(element$iv$iv));
            i++;
            isRtl2 = isRtl;
        }
        State<Color> state = this.$inactiveTickColor;
        State<Color> state2 = this.$activeTickColor;
        Ref.FloatRef floatRef = this.$tickSize;
        for (Map.Entry element$iv : destination$iv$iv.entrySet()) {
            boolean outsideFraction = ((Boolean) element$iv.getKey()).booleanValue();
            Iterable<Number> $this$map$iv = (List) element$iv.getValue();
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Number floatValue : $this$map$iv) {
                long sliderStart3 = sliderStart2;
                long sliderEnd3 = sliderEnd2;
                destination$iv$iv2.add(Offset.m2904boximpl(OffsetKt.Offset(Offset.m2915getXimpl(OffsetKt.m2938lerpWko1d7g(sliderStart3, sliderEnd3, floatValue.floatValue())), Offset.m2916getYimpl($this$Canvas.m3771getCenterF1C5BW0()))));
                sliderEnd2 = sliderEnd3;
                state = state;
                sliderStart2 = sliderStart3;
            }
            long sliderEnd4 = sliderEnd2;
            long sliderStart4 = sliderStart2;
            State<Color> state3 = state;
            DrawScope.m3745drawPointsF8ZwMP8$default($this$Canvas, (List) destination$iv$iv2, PointMode.Companion.m3482getPointsr_lszbg(), (outsideFraction ? state3 : state2).getValue().m3174unboximpl(), floatRef.element, StrokeCap.Companion.m3548getRoundKaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
            floatRef = floatRef;
            sliderEnd2 = sliderEnd4;
            state = state3;
            sliderStart2 = sliderStart4;
        }
    }
}
