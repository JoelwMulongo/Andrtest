package androidx.compose.ui.window;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidDialog.android.kt */
final class AndroidDialog_androidKt$DialogLayout$1 implements MeasurePolicy {
    public static final AndroidDialog_androidKt$DialogLayout$1 INSTANCE = new AndroidDialog_androidKt$DialogLayout$1();

    AndroidDialog_androidKt$DialogLayout$1() {
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m6229measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> measurables, long constraints) {
        Object maxElem$iv;
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
        List $this$fastMaxBy$iv = placeables;
        Object maxElem$iv2 = null;
        if ($this$fastMaxBy$iv.isEmpty()) {
            maxElem$iv = null;
        } else {
            maxElem$iv = $this$fastMaxBy$iv.get(0);
            int maxValue$iv = ((Placeable) maxElem$iv).getWidth();
            int i$iv = 1;
            int lastIndex = CollectionsKt.getLastIndex($this$fastMaxBy$iv);
            if (1 <= lastIndex) {
                while (true) {
                    Object e$iv = $this$fastMaxBy$iv.get(i$iv);
                    int v$iv = ((Placeable) e$iv).getWidth();
                    if (maxValue$iv < v$iv) {
                        maxElem$iv = e$iv;
                        maxValue$iv = v$iv;
                    }
                    if (i$iv == lastIndex) {
                        break;
                    }
                    i$iv++;
                }
            }
        }
        Placeable placeable = (Placeable) maxElem$iv;
        int width = placeable != null ? placeable.getWidth() : Constraints.m5932getMinWidthimpl(constraints);
        List $this$fastMaxBy$iv2 = placeables;
        if (!$this$fastMaxBy$iv2.isEmpty()) {
            maxElem$iv2 = $this$fastMaxBy$iv2.get(0);
            int maxValue$iv2 = ((Placeable) maxElem$iv2).getHeight();
            int i$iv2 = 1;
            int lastIndex2 = CollectionsKt.getLastIndex($this$fastMaxBy$iv2);
            if (1 <= lastIndex2) {
                while (true) {
                    Object e$iv2 = $this$fastMaxBy$iv2.get(i$iv2);
                    int v$iv2 = ((Placeable) e$iv2).getHeight();
                    if (maxValue$iv2 < v$iv2) {
                        maxElem$iv2 = e$iv2;
                        maxValue$iv2 = v$iv2;
                    }
                    if (i$iv2 == lastIndex2) {
                        break;
                    }
                    i$iv2++;
                }
            }
        }
        Placeable placeable2 = (Placeable) maxElem$iv2;
        return MeasureScope.layout$default($this$Layout, width, placeable2 != null ? placeable2.getHeight() : Constraints.m5931getMinHeightimpl(constraints), (Map) null, new AndroidDialog_androidKt$DialogLayout$1$measure$1(placeables), 4, (Object) null);
    }
}
