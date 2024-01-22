package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u000e\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J/\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u0019\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/AnimatedEnterExitMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "scope", "Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "(Landroidx/compose/animation/AnimatedVisibilityScopeImpl;)V", "getScope", "()Landroidx/compose/animation/AnimatedVisibilityScopeImpl;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedVisibility.kt */
final class AnimatedEnterExitMeasurePolicy implements MeasurePolicy {
    private final AnimatedVisibilityScopeImpl scope;

    public AnimatedEnterExitMeasurePolicy(AnimatedVisibilityScopeImpl scope2) {
        Intrinsics.checkNotNullParameter(scope2, "scope");
        this.scope = scope2;
    }

    public final AnimatedVisibilityScopeImpl getScope() {
        return this.scope;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: androidx.compose.ui.layout.Placeable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.ui.layout.MeasureResult m332measure3p2s80s(androidx.compose.ui.layout.MeasureScope r18, java.util.List<? extends androidx.compose.ui.layout.Measurable> r19, long r20) {
        /*
            r17 = this;
            r0 = r19
            java.lang.String r1 = "$this$measure"
            r9 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            java.lang.String r1 = "measurables"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = r0
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r4)
            r3.<init>(r4)
            java.util.Collection r3 = (java.util.Collection) r3
            r4 = r1
            r5 = 0
            java.util.Iterator r6 = r4.iterator()
        L_0x0026:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x003e
            java.lang.Object r7 = r6.next()
            r8 = r7
            androidx.compose.ui.layout.Measurable r8 = (androidx.compose.ui.layout.Measurable) r8
            r10 = 0
            r11 = r20
            androidx.compose.ui.layout.Placeable r8 = r8.m4863measureBRTryo0(r11)
            r3.add(r8)
            goto L_0x0026
        L_0x003e:
            r11 = r20
            java.util.List r3 = (java.util.List) r3
            r1 = r3
            r2 = r1
            r3 = 0
            boolean r4 = r2.isEmpty()
            r5 = 0
            r6 = 0
            if (r4 == 0) goto L_0x0051
            r4 = r5
            goto L_0x007c
        L_0x0051:
            java.lang.Object r4 = r2.get(r6)
            r7 = r4
            androidx.compose.ui.layout.Placeable r7 = (androidx.compose.ui.layout.Placeable) r7
            r8 = 0
            int r7 = r7.getWidth()
            r8 = 1
            int r10 = kotlin.collections.CollectionsKt.getLastIndex(r2)
            if (r8 > r10) goto L_0x007b
        L_0x0065:
            java.lang.Object r13 = r2.get(r8)
            r14 = r13
            androidx.compose.ui.layout.Placeable r14 = (androidx.compose.ui.layout.Placeable) r14
            r15 = 0
            int r14 = r14.getWidth()
            if (r7 >= r14) goto L_0x0076
            r4 = r13
            r7 = r14
        L_0x0076:
            if (r8 == r10) goto L_0x007b
            int r8 = r8 + 1
            goto L_0x0065
        L_0x007b:
        L_0x007c:
            androidx.compose.ui.layout.Placeable r4 = (androidx.compose.ui.layout.Placeable) r4
            if (r4 == 0) goto L_0x0085
            int r2 = r4.getWidth()
            goto L_0x0086
        L_0x0085:
            r2 = r6
        L_0x0086:
            r10 = r2
            r2 = r1
            r3 = 0
            boolean r4 = r2.isEmpty()
            if (r4 == 0) goto L_0x0091
            goto L_0x00c1
        L_0x0091:
            java.lang.Object r4 = r2.get(r6)
            r5 = r4
            androidx.compose.ui.layout.Placeable r5 = (androidx.compose.ui.layout.Placeable) r5
            r7 = 0
            int r5 = r5.getHeight()
            r7 = 1
            int r8 = kotlin.collections.CollectionsKt.getLastIndex(r2)
            if (r7 > r8) goto L_0x00bb
        L_0x00a5:
            java.lang.Object r13 = r2.get(r7)
            r14 = r13
            androidx.compose.ui.layout.Placeable r14 = (androidx.compose.ui.layout.Placeable) r14
            r15 = 0
            int r14 = r14.getHeight()
            if (r5 >= r14) goto L_0x00b6
            r4 = r13
            r5 = r14
        L_0x00b6:
            if (r7 == r8) goto L_0x00bb
            int r7 = r7 + 1
            goto L_0x00a5
        L_0x00bb:
            r16 = r5
            r5 = r4
            r4 = r16
        L_0x00c1:
            androidx.compose.ui.layout.Placeable r5 = (androidx.compose.ui.layout.Placeable) r5
            if (r5 == 0) goto L_0x00c9
            int r6 = r5.getHeight()
        L_0x00c9:
            r13 = r6
            r14 = r17
            androidx.compose.animation.AnimatedVisibilityScopeImpl r2 = r14.scope
            androidx.compose.runtime.MutableState r2 = r2.getTargetSize$animation_release()
            long r3 = androidx.compose.ui.unit.IntSizeKt.IntSize(r10, r13)
            androidx.compose.ui.unit.IntSize r3 = androidx.compose.ui.unit.IntSize.m6138boximpl(r3)
            r2.setValue(r3)
            r5 = 0
            androidx.compose.animation.AnimatedEnterExitMeasurePolicy$measure$1 r2 = new androidx.compose.animation.AnimatedEnterExitMeasurePolicy$measure$1
            r2.<init>(r1)
            r6 = r2
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r7 = 4
            r8 = 0
            r2 = r18
            r3 = r10
            r4 = r13
            androidx.compose.ui.layout.MeasureResult r2 = androidx.compose.ui.layout.MeasureScope.layout$default(r2, r3, r4, r5, r6, r7, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.AnimatedEnterExitMeasurePolicy.m332measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(CollectionsKt.asSequence(measurables), new AnimatedEnterExitMeasurePolicy$minIntrinsicWidth$1(height)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(CollectionsKt.asSequence(measurables), new AnimatedEnterExitMeasurePolicy$minIntrinsicHeight$1(width)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(CollectionsKt.asSequence(measurables), new AnimatedEnterExitMeasurePolicy$maxIntrinsicWidth$1(height)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(CollectionsKt.asSequence(measurables), new AnimatedEnterExitMeasurePolicy$maxIntrinsicHeight$1(width)));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
