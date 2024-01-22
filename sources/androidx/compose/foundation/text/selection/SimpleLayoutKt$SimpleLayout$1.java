package androidx.compose.foundation.text.selection;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SimpleLayout.kt */
final class SimpleLayoutKt$SimpleLayout$1 implements MeasurePolicy {
    public static final SimpleLayoutKt$SimpleLayout$1 INSTANCE = new SimpleLayoutKt$SimpleLayout$1();

    SimpleLayoutKt$SimpleLayout$1() {
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1328measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List list = measurables;
        List target$iv = new ArrayList(list.size());
        List $this$fastForEach$iv$iv = list;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            Object obj = it$iv;
            target$iv.add(((Measurable) it$iv).m4863measureBRTryo0(constraints));
            index$iv$iv++;
            MeasureScope measureScope = $this$Layout;
        }
        long j = constraints;
        List placeables = target$iv;
        int initial$iv = 0;
        Object accumulator$iv = 0;
        List $this$fastForEach$iv$iv2 = placeables;
        int index$iv$iv2 = 0;
        int size2 = $this$fastForEach$iv$iv2.size();
        while (index$iv$iv2 < size2) {
            accumulator$iv = Integer.valueOf(Math.max(((Number) accumulator$iv).intValue(), ((Placeable) $this$fastForEach$iv$iv2.get(index$iv$iv2)).getWidth()));
            index$iv$iv2++;
            initial$iv = initial$iv;
        }
        int width = ((Number) accumulator$iv).intValue();
        int initial$iv2 = 0;
        List $this$fastFold$iv = placeables;
        Object accumulator$iv2 = 0;
        List $this$fastForEach$iv$iv3 = $this$fastFold$iv;
        int index$iv$iv3 = 0;
        int size3 = $this$fastForEach$iv$iv3.size();
        while (index$iv$iv3 < size3) {
            accumulator$iv2 = Integer.valueOf(Math.max(((Number) accumulator$iv2).intValue(), ((Placeable) $this$fastForEach$iv$iv3.get(index$iv$iv3)).getHeight()));
            index$iv$iv3++;
            initial$iv2 = initial$iv2;
            $this$fastFold$iv = $this$fastFold$iv;
        }
        List list2 = $this$fastFold$iv;
        return MeasureScope.layout$default($this$Layout, width, ((Number) accumulator$iv2).intValue(), (Map) null, new SimpleLayoutKt$SimpleLayout$1$measure$1(placeables), 4, (Object) null);
    }
}
