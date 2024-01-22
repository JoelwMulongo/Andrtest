package androidx.compose.ui.layout;

import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bç\u0001\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J(\u0010\t\u001a\u00020\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016J5\u0010\u000b\u001a\u00020\f*\u00020\r2\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00060\u00062\u0006\u0010\u000f\u001a\u00020\u0010H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J(\u0010\u0013\u001a\u00020\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016J(\u0010\u0014\u001a\u00020\u0003*\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0016ø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MultiContentMeasurePolicy.kt */
public interface MultiContentMeasurePolicy {
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    MeasureResult m4891measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j);

    int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends List<? extends IntrinsicMeasurable>> measurables, int height) {
        IntrinsicMeasureScope intrinsicMeasureScope = $this$minIntrinsicWidth;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List $this$fastMap$iv = measurables;
        int $i$f$fastMap = false;
        ArrayList target$iv = new ArrayList($this$fastMap$iv.size());
        List $this$fastForEach$iv$iv = $this$fastMap$iv;
        int $i$f$fastForEach = false;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            Collection collection = target$iv;
            List $this$fastMap$iv2 = (List) it$iv;
            List $this$fastMap$iv3 = $this$fastMap$iv;
            List target$iv2 = new ArrayList($this$fastMap$iv2.size());
            List $this$fastForEach$iv$iv2 = $this$fastMap$iv2;
            int $i$f$fastMap2 = $i$f$fastMap;
            int $i$f$fastMap3 = $this$fastForEach$iv$iv2.size();
            List $this$fastForEach$iv$iv3 = $this$fastForEach$iv$iv;
            int index$iv$iv2 = 0;
            while (index$iv$iv2 < $i$f$fastMap3) {
                target$iv2.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) $this$fastForEach$iv$iv2.get(index$iv$iv2), IntrinsicMinMax.Min, IntrinsicWidthHeight.Width));
                index$iv$iv2++;
                $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv2;
                $i$f$fastMap3 = $i$f$fastMap3;
                $i$f$fastForEach = $i$f$fastForEach;
                size = size;
                it$iv = it$iv;
            }
            int i = $i$f$fastForEach;
            int i2 = size;
            Object obj = it$iv;
            collection.add(target$iv2);
            index$iv$iv++;
            List<? extends List<? extends IntrinsicMeasurable>> list = measurables;
            $this$fastMap$iv = $this$fastMap$iv3;
            $i$f$fastMap = $i$f$fastMap2;
            $this$fastForEach$iv$iv = $this$fastForEach$iv$iv3;
        }
        int i3 = $i$f$fastMap;
        List list2 = $this$fastForEach$iv$iv;
        int i4 = $i$f$fastForEach;
        return m4891measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, $this$minIntrinsicWidth.getLayoutDirection()), target$iv, ConstraintsKt.Constraints$default(0, 0, 0, height, 7, (Object) null)).getWidth();
    }

    int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends List<? extends IntrinsicMeasurable>> measurables, int width) {
        IntrinsicMeasureScope intrinsicMeasureScope = $this$minIntrinsicHeight;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List $this$fastMap$iv = measurables;
        int $i$f$fastMap = false;
        ArrayList target$iv = new ArrayList($this$fastMap$iv.size());
        List $this$fastForEach$iv$iv = $this$fastMap$iv;
        int $i$f$fastForEach = false;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            Collection collection = target$iv;
            List $this$fastMap$iv2 = (List) it$iv;
            List $this$fastMap$iv3 = $this$fastMap$iv;
            List target$iv2 = new ArrayList($this$fastMap$iv2.size());
            List $this$fastForEach$iv$iv2 = $this$fastMap$iv2;
            int $i$f$fastMap2 = $i$f$fastMap;
            int $i$f$fastMap3 = $this$fastForEach$iv$iv2.size();
            List $this$fastForEach$iv$iv3 = $this$fastForEach$iv$iv;
            int index$iv$iv2 = 0;
            while (index$iv$iv2 < $i$f$fastMap3) {
                target$iv2.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) $this$fastForEach$iv$iv2.get(index$iv$iv2), IntrinsicMinMax.Min, IntrinsicWidthHeight.Height));
                index$iv$iv2++;
                $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv2;
                $i$f$fastMap3 = $i$f$fastMap3;
                $i$f$fastForEach = $i$f$fastForEach;
                size = size;
                it$iv = it$iv;
            }
            int i = $i$f$fastForEach;
            int i2 = size;
            Object obj = it$iv;
            collection.add(target$iv2);
            index$iv$iv++;
            List<? extends List<? extends IntrinsicMeasurable>> list = measurables;
            $this$fastMap$iv = $this$fastMap$iv3;
            $i$f$fastMap = $i$f$fastMap2;
            $this$fastForEach$iv$iv = $this$fastForEach$iv$iv3;
        }
        int i3 = $i$f$fastMap;
        List list2 = $this$fastForEach$iv$iv;
        int i4 = $i$f$fastForEach;
        return m4891measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, $this$minIntrinsicHeight.getLayoutDirection()), target$iv, ConstraintsKt.Constraints$default(0, width, 0, 0, 13, (Object) null)).getHeight();
    }

    int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends List<? extends IntrinsicMeasurable>> measurables, int height) {
        IntrinsicMeasureScope intrinsicMeasureScope = $this$maxIntrinsicWidth;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List $this$fastMap$iv = measurables;
        int $i$f$fastMap = false;
        ArrayList target$iv = new ArrayList($this$fastMap$iv.size());
        List $this$fastForEach$iv$iv = $this$fastMap$iv;
        int $i$f$fastForEach = false;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            Collection collection = target$iv;
            List $this$fastMap$iv2 = (List) it$iv;
            List $this$fastMap$iv3 = $this$fastMap$iv;
            List target$iv2 = new ArrayList($this$fastMap$iv2.size());
            List $this$fastForEach$iv$iv2 = $this$fastMap$iv2;
            int $i$f$fastMap2 = $i$f$fastMap;
            int $i$f$fastMap3 = $this$fastForEach$iv$iv2.size();
            List $this$fastForEach$iv$iv3 = $this$fastForEach$iv$iv;
            int index$iv$iv2 = 0;
            while (index$iv$iv2 < $i$f$fastMap3) {
                target$iv2.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) $this$fastForEach$iv$iv2.get(index$iv$iv2), IntrinsicMinMax.Max, IntrinsicWidthHeight.Width));
                index$iv$iv2++;
                $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv2;
                $i$f$fastMap3 = $i$f$fastMap3;
                $i$f$fastForEach = $i$f$fastForEach;
                size = size;
                it$iv = it$iv;
            }
            int i = $i$f$fastForEach;
            int i2 = size;
            Object obj = it$iv;
            collection.add(target$iv2);
            index$iv$iv++;
            List<? extends List<? extends IntrinsicMeasurable>> list = measurables;
            $this$fastMap$iv = $this$fastMap$iv3;
            $i$f$fastMap = $i$f$fastMap2;
            $this$fastForEach$iv$iv = $this$fastForEach$iv$iv3;
        }
        int i3 = $i$f$fastMap;
        List list2 = $this$fastForEach$iv$iv;
        int i4 = $i$f$fastForEach;
        return m4891measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, $this$maxIntrinsicWidth.getLayoutDirection()), target$iv, ConstraintsKt.Constraints$default(0, 0, 0, height, 7, (Object) null)).getWidth();
    }

    int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends List<? extends IntrinsicMeasurable>> measurables, int width) {
        IntrinsicMeasureScope intrinsicMeasureScope = $this$maxIntrinsicHeight;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List $this$fastMap$iv = measurables;
        int $i$f$fastMap = false;
        ArrayList target$iv = new ArrayList($this$fastMap$iv.size());
        List $this$fastForEach$iv$iv = $this$fastMap$iv;
        int $i$f$fastForEach = false;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            Collection collection = target$iv;
            List $this$fastMap$iv2 = (List) it$iv;
            List $this$fastMap$iv3 = $this$fastMap$iv;
            List target$iv2 = new ArrayList($this$fastMap$iv2.size());
            List $this$fastForEach$iv$iv2 = $this$fastMap$iv2;
            int $i$f$fastMap2 = $i$f$fastMap;
            int $i$f$fastMap3 = $this$fastForEach$iv$iv2.size();
            List $this$fastForEach$iv$iv3 = $this$fastForEach$iv$iv;
            int index$iv$iv2 = 0;
            while (index$iv$iv2 < $i$f$fastMap3) {
                target$iv2.add(new DefaultIntrinsicMeasurable((IntrinsicMeasurable) $this$fastForEach$iv$iv2.get(index$iv$iv2), IntrinsicMinMax.Max, IntrinsicWidthHeight.Height));
                index$iv$iv2++;
                $this$fastForEach$iv$iv2 = $this$fastForEach$iv$iv2;
                $i$f$fastMap3 = $i$f$fastMap3;
                $i$f$fastForEach = $i$f$fastForEach;
                size = size;
                it$iv = it$iv;
            }
            int i = $i$f$fastForEach;
            int i2 = size;
            Object obj = it$iv;
            collection.add(target$iv2);
            index$iv$iv++;
            List<? extends List<? extends IntrinsicMeasurable>> list = measurables;
            $this$fastMap$iv = $this$fastMap$iv3;
            $i$f$fastMap = $i$f$fastMap2;
            $this$fastForEach$iv$iv = $this$fastForEach$iv$iv3;
        }
        int i3 = $i$f$fastMap;
        List list2 = $this$fastForEach$iv$iv;
        int i4 = $i$f$fastForEach;
        return m4891measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, $this$maxIntrinsicHeight.getLayoutDirection()), target$iv, ConstraintsKt.Constraints$default(0, width, 0, 0, 13, (Object) null)).getHeight();
    }
}
