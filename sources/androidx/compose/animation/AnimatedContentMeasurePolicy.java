package androidx.compose.animation;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u000e\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J/\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u0019\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/AnimatedContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "rootScope", "Landroidx/compose/animation/AnimatedContentScope;", "(Landroidx/compose/animation/AnimatedContentScope;)V", "getRootScope", "()Landroidx/compose/animation/AnimatedContentScope;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentMeasurePolicy implements MeasurePolicy {
    private final AnimatedContentScope<?> rootScope;

    public AnimatedContentMeasurePolicy(AnimatedContentScope<?> rootScope2) {
        Intrinsics.checkNotNullParameter(rootScope2, "rootScope");
        this.rootScope = rootScope2;
    }

    public final AnimatedContentScope<?> getRootScope() {
        return this.rootScope;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m304measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        Placeable placeable;
        Placeable placeable2;
        long j = constraints;
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        Placeable[] placeables = new Placeable[measurables.size()];
        List $this$fastForEachIndexed$iv = measurables;
        int index$iv = 0;
        int size = $this$fastForEachIndexed$iv.size();
        while (true) {
            boolean z = true;
            if (index$iv >= size) {
                break;
            }
            Measurable measurable = (Measurable) $this$fastForEachIndexed$iv.get(index$iv);
            int index = index$iv;
            Object parentData = measurable.getParentData();
            AnimatedContentScope.ChildData childData = parentData instanceof AnimatedContentScope.ChildData ? (AnimatedContentScope.ChildData) parentData : null;
            if (childData == null || !childData.isTarget()) {
                z = false;
            }
            if (z) {
                placeables[index] = measurable.m4863measureBRTryo0(j);
            }
            index$iv++;
        }
        List $this$fastForEachIndexed$iv2 = measurables;
        int size2 = $this$fastForEachIndexed$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Measurable measurable2 = (Measurable) $this$fastForEachIndexed$iv2.get(index$iv2);
            int index2 = index$iv2;
            if (placeables[index2] == null) {
                placeables[index2] = measurable2.m4863measureBRTryo0(j);
            }
        }
        Placeable[] placeableArr = placeables;
        if (placeableArr.length == 0) {
            placeable = null;
        } else {
            placeable = placeableArr[0];
            int lastIndex$iv = ArraysKt.getLastIndex((T[]) placeableArr);
            if (lastIndex$iv != 0) {
                Placeable it = placeable;
                int maxValue$iv = it != null ? it.getWidth() : 0;
                IntIterator it2 = new IntRange(1, lastIndex$iv).iterator();
                while (it2.hasNext()) {
                    Placeable placeable3 = placeableArr[it2.nextInt()];
                    Placeable it3 = placeable3;
                    int v$iv = it3 != null ? it3.getWidth() : 0;
                    if (maxValue$iv < v$iv) {
                        placeable = placeable3;
                        maxValue$iv = v$iv;
                    }
                }
            }
        }
        int maxWidth = placeable != null ? placeable.getWidth() : 0;
        Placeable[] placeableArr2 = placeables;
        if (placeableArr2.length == 0) {
            placeable2 = null;
        } else {
            int v$iv2 = 0;
            placeable2 = placeableArr2[0];
            int lastIndex$iv2 = ArraysKt.getLastIndex((T[]) placeableArr2);
            if (lastIndex$iv2 != 0) {
                Placeable it4 = placeable2;
                int maxValue$iv2 = it4 != null ? it4.getHeight() : 0;
                IntIterator it5 = new IntRange(1, lastIndex$iv2).iterator();
                while (it5.hasNext()) {
                    Placeable placeable4 = placeableArr2[it5.nextInt()];
                    Placeable it6 = placeable4;
                    int v$iv3 = it6 != null ? it6.getHeight() : v$iv2;
                    if (maxValue$iv2 < v$iv3) {
                        placeable2 = placeable4;
                        maxValue$iv2 = v$iv3;
                        v$iv2 = 0;
                    } else {
                        v$iv2 = 0;
                    }
                }
            }
        }
        int maxHeight = placeable2 != null ? placeable2.getHeight() : 0;
        this.rootScope.m314setMeasuredSizeozmzZPI$animation_release(IntSizeKt.IntSize(maxWidth, maxHeight));
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, maxWidth, maxHeight, (Map) null, new AnimatedContentMeasurePolicy$measure$3(placeables, this, maxWidth, maxHeight), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(CollectionsKt.asSequence(measurables), new AnimatedContentMeasurePolicy$minIntrinsicWidth$1(height)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(CollectionsKt.asSequence(measurables), new AnimatedContentMeasurePolicy$minIntrinsicHeight$1(width)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(CollectionsKt.asSequence(measurables), new AnimatedContentMeasurePolicy$maxIntrinsicWidth$1(height)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(CollectionsKt.asSequence(measurables), new AnimatedContentMeasurePolicy$maxIntrinsicHeight$1(width)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
