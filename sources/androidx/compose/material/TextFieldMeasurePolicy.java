package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J<\u0010\u0011\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\"\u0010\u0014\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u0015\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J/\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u001f\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Landroidx/compose/material/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextField.kt */
final class TextFieldMeasurePolicy implements MeasurePolicy {
    /* access modifiers changed from: private */
    public final float animationProgress;
    /* access modifiers changed from: private */
    public final PaddingValues paddingValues;
    /* access modifiers changed from: private */
    public final boolean singleLine;

    public TextFieldMeasurePolicy(boolean singleLine2, float animationProgress2, PaddingValues paddingValues2) {
        Intrinsics.checkNotNullParameter(paddingValues2, "paddingValues");
        this.singleLine = singleLine2;
        this.animationProgress = animationProgress2;
        this.paddingValues = paddingValues2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m1691measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends Measurable> measurables, long constraints) {
        Object obj;
        Object obj2;
        Object obj3;
        int it;
        int i;
        long textFieldConstraints;
        Object obj4;
        MeasureScope measureScope = $this$measure_u2d3p2s80s;
        List<? extends Measurable> $this$first$iv = measurables;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter($this$first$iv, "measurables");
        int topPaddingValue = measureScope.m5961roundToPx0680j_4(this.paddingValues.m773calculateTopPaddingD9Ej5fM());
        int bottomPaddingValue = measureScope.m5961roundToPx0680j_4(this.paddingValues.m770calculateBottomPaddingD9Ej5fM());
        int topPadding = measureScope.m5961roundToPx0680j_4(TextFieldKt.getTextFieldTopPadding());
        long looseConstraints = Constraints.m5921copyZbe2FdA$default(constraints, 0, 0, 0, 0, 10, (Object) null);
        Iterator it2 = $this$first$iv.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), (Object) "Leading")) {
                break;
            }
        }
        Measurable measurable = (Measurable) obj;
        Placeable leadingPlaceable = measurable != null ? measurable.m4863measureBRTryo0(looseConstraints) : null;
        int occupiedSpaceHorizontally = 0 + TextFieldImplKt.widthOrZero(leadingPlaceable);
        Iterator it3 = $this$first$iv.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it3.next();
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj2), (Object) "Trailing")) {
                break;
            }
        }
        Measurable measurable2 = (Measurable) obj2;
        Placeable trailingPlaceable = measurable2 != null ? measurable2.m4863measureBRTryo0(ConstraintsKt.m5947offsetNN6EwU$default(looseConstraints, -occupiedSpaceHorizontally, 0, 2, (Object) null)) : null;
        int occupiedSpaceHorizontally2 = occupiedSpaceHorizontally + TextFieldImplKt.widthOrZero(trailingPlaceable);
        long labelConstraints = ConstraintsKt.m5946offsetNN6EwU(looseConstraints, -occupiedSpaceHorizontally2, -bottomPaddingValue);
        Iterator it4 = $this$first$iv.iterator();
        while (true) {
            if (!it4.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it4.next();
            Iterator it5 = it4;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj3), (Object) "Label")) {
                break;
            }
            it4 = it5;
        }
        Measurable measurable3 = (Measurable) obj3;
        Placeable labelPlaceable = measurable3 != null ? measurable3.m4863measureBRTryo0(labelConstraints) : null;
        if (labelPlaceable != null) {
            it = labelPlaceable.get(AlignmentLineKt.getLastBaseline());
            if (it == Integer.MIN_VALUE) {
                it = labelPlaceable.getHeight();
            }
        } else {
            it = 0;
        }
        int lastBaseline = it;
        int effectiveLabelBaseline = Math.max(lastBaseline, topPaddingValue);
        if (labelPlaceable != null) {
            i = ((-bottomPaddingValue) - topPadding) - effectiveLabelBaseline;
        } else {
            i = (-topPaddingValue) - bottomPaddingValue;
        }
        int verticalConstraintOffset = i;
        long labelConstraints2 = labelConstraints;
        int lastBaseline2 = lastBaseline;
        long textFieldConstraints2 = ConstraintsKt.m5946offsetNN6EwU(Constraints.m5921copyZbe2FdA$default(constraints, 0, 0, 0, 0, 11, (Object) null), -occupiedSpaceHorizontally2, verticalConstraintOffset);
        for (Object element$iv : $this$first$iv) {
            int lastBaseline3 = lastBaseline2;
            long looseConstraints2 = looseConstraints;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) element$iv), (Object) "TextField")) {
                Placeable textFieldPlaceable = ((Measurable) element$iv).m4863measureBRTryo0(textFieldConstraints2);
                long placeholderConstraints = Constraints.m5921copyZbe2FdA$default(textFieldConstraints2, 0, 0, 0, 0, 14, (Object) null);
                Iterator it6 = $this$first$iv.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        textFieldConstraints = textFieldConstraints2;
                        obj4 = null;
                        break;
                    }
                    obj4 = it6.next();
                    textFieldConstraints = textFieldConstraints2;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj4), (Object) "Hint")) {
                        break;
                    }
                    textFieldConstraints2 = textFieldConstraints;
                }
                Measurable measurable4 = (Measurable) obj4;
                int i2 = verticalConstraintOffset;
                Placeable placeholderPlaceable = measurable4 != null ? measurable4.m4863measureBRTryo0(placeholderConstraints) : null;
                int width = TextFieldKt.m1690calculateWidthVsPV1Ek(TextFieldImplKt.widthOrZero(leadingPlaceable), TextFieldImplKt.widthOrZero(trailingPlaceable), textFieldPlaceable.getWidth(), TextFieldImplKt.widthOrZero(labelPlaceable), TextFieldImplKt.widthOrZero(placeholderPlaceable), constraints);
                int height = TextFieldKt.m1689calculateHeightO3s9Psw(textFieldPlaceable.getHeight(), labelPlaceable != null, effectiveLabelBaseline, TextFieldImplKt.heightOrZero(leadingPlaceable), TextFieldImplKt.heightOrZero(trailingPlaceable), TextFieldImplKt.heightOrZero(placeholderPlaceable), constraints, $this$measure_u2d3p2s80s.getDensity(), this.paddingValues);
                long j = textFieldConstraints;
                long j2 = labelConstraints2;
                Placeable placeable = labelPlaceable;
                long j3 = looseConstraints2;
                long j4 = placeholderConstraints;
                int i3 = occupiedSpaceHorizontally2;
                int i4 = bottomPaddingValue;
                int i5 = topPaddingValue;
                return MeasureScope.layout$default($this$measure_u2d3p2s80s, width, height, (Map) null, new TextFieldMeasurePolicy$measure$1(labelPlaceable, topPaddingValue, lastBaseline3, width, height, textFieldPlaceable, placeholderPlaceable, leadingPlaceable, trailingPlaceable, this, effectiveLabelBaseline, topPadding, $this$measure_u2d3p2s80s), 4, (Object) null);
            }
            Placeable placeable2 = labelPlaceable;
            int i6 = verticalConstraintOffset;
            int i7 = occupiedSpaceHorizontally2;
            int i8 = topPaddingValue;
            long j5 = labelConstraints2;
            int i9 = bottomPaddingValue;
            MeasureScope measureScope2 = $this$measure_u2d3p2s80s;
            $this$first$iv = measurables;
            lastBaseline2 = lastBaseline3;
            looseConstraints = looseConstraints2;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight($this$maxIntrinsicHeight, measurables, width, TextFieldMeasurePolicy$maxIntrinsicHeight$1.INSTANCE);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight($this$minIntrinsicHeight, measurables, width, TextFieldMeasurePolicy$minIntrinsicHeight$1.INSTANCE);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(measurables, height, TextFieldMeasurePolicy$maxIntrinsicWidth$1.INSTANCE);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(measurables, height, TextFieldMeasurePolicy$minIntrinsicWidth$1.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int intrinsicWidth(java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r13, int r14, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.IntrinsicMeasurable, ? super java.lang.Integer, java.lang.Integer> r15) {
        /*
            r12 = this;
            r0 = r13
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.Iterator r2 = r0.iterator()
        L_0x0008:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x012a
            java.lang.Object r3 = r2.next()
            r4 = r3
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            r5 = 0
            java.lang.Object r6 = androidx.compose.material.TextFieldImplKt.getLayoutId(r4)
            java.lang.String r7 = "TextField"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r4 == 0) goto L_0x0008
            java.lang.Integer r0 = java.lang.Integer.valueOf(r14)
            java.lang.Object r0 = r15.invoke(r3, r0)
            java.lang.Number r0 = (java.lang.Number) r0
            int r3 = r0.intValue()
            r0 = r13
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0038:
            boolean r1 = r0.hasNext()
            r5 = 0
            if (r1 == 0) goto L_0x0054
            java.lang.Object r1 = r0.next()
            r2 = r1
            androidx.compose.ui.layout.IntrinsicMeasurable r2 = (androidx.compose.ui.layout.IntrinsicMeasurable) r2
            r4 = 0
            java.lang.Object r6 = androidx.compose.material.TextFieldImplKt.getLayoutId(r2)
            java.lang.String r7 = "Label"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r2 == 0) goto L_0x0038
            goto L_0x0055
        L_0x0054:
            r1 = r5
        L_0x0055:
            androidx.compose.ui.layout.IntrinsicMeasurable r1 = (androidx.compose.ui.layout.IntrinsicMeasurable) r1
            r0 = 0
            if (r1 == 0) goto L_0x006b
            r2 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            java.lang.Object r4 = r15.invoke(r1, r4)
            java.lang.Number r4 = (java.lang.Number) r4
            int r1 = r4.intValue()
            r4 = r1
            goto L_0x006c
        L_0x006b:
            r4 = r0
        L_0x006c:
            r1 = r13
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0074:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x008f
            java.lang.Object r2 = r1.next()
            r6 = r2
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            r7 = 0
            java.lang.Object r8 = androidx.compose.material.TextFieldImplKt.getLayoutId(r6)
            java.lang.String r9 = "Trailing"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r6 == 0) goto L_0x0074
            goto L_0x0090
        L_0x008f:
            r2 = r5
        L_0x0090:
            androidx.compose.ui.layout.IntrinsicMeasurable r2 = (androidx.compose.ui.layout.IntrinsicMeasurable) r2
            if (r2 == 0) goto L_0x00a6
            r1 = r2
            r2 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r14)
            java.lang.Object r6 = r15.invoke(r1, r6)
            java.lang.Number r6 = (java.lang.Number) r6
            int r1 = r6.intValue()
            r2 = r1
            goto L_0x00a7
        L_0x00a6:
            r2 = r0
        L_0x00a7:
            r1 = r13
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x00af:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x00ca
            java.lang.Object r6 = r1.next()
            r7 = r6
            androidx.compose.ui.layout.IntrinsicMeasurable r7 = (androidx.compose.ui.layout.IntrinsicMeasurable) r7
            r8 = 0
            java.lang.Object r9 = androidx.compose.material.TextFieldImplKt.getLayoutId(r7)
            java.lang.String r10 = "Leading"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r7 == 0) goto L_0x00af
            goto L_0x00cb
        L_0x00ca:
            r6 = r5
        L_0x00cb:
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            if (r6 == 0) goto L_0x00e0
            r1 = r6
            r6 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r14)
            java.lang.Object r7 = r15.invoke(r1, r7)
            java.lang.Number r7 = (java.lang.Number) r7
            int r1 = r7.intValue()
            goto L_0x00e1
        L_0x00e0:
            r1 = r0
        L_0x00e1:
            r6 = r13
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x00e9:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0104
            java.lang.Object r7 = r6.next()
            r8 = r7
            androidx.compose.ui.layout.IntrinsicMeasurable r8 = (androidx.compose.ui.layout.IntrinsicMeasurable) r8
            r9 = 0
            java.lang.Object r10 = androidx.compose.material.TextFieldImplKt.getLayoutId(r8)
            java.lang.String r11 = "Hint"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r8 == 0) goto L_0x00e9
            r5 = r7
        L_0x0104:
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            if (r5 == 0) goto L_0x011a
            r0 = r5
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r14)
            java.lang.Object r6 = r15.invoke(r0, r6)
            java.lang.Number r6 = (java.lang.Number) r6
            int r0 = r6.intValue()
            r5 = r0
            goto L_0x011b
        L_0x011a:
            r5 = r0
        L_0x011b:
            long r6 = androidx.compose.material.TextFieldImplKt.getZeroConstraints()
            int r0 = androidx.compose.material.TextFieldKt.m1690calculateWidthVsPV1Ek(r1, r2, r3, r4, r5, r6)
            return r0
        L_0x012a:
            java.util.NoSuchElementException r2 = new java.util.NoSuchElementException
            java.lang.String r3 = "Collection contains no element matching the predicate."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldMeasurePolicy.intrinsicWidth(java.util.List, int, kotlin.jvm.functions.Function2):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int intrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope r15, java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r16, int r17, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.IntrinsicMeasurable, ? super java.lang.Integer, java.lang.Integer> r18) {
        /*
            r14 = this;
            r0 = r18
            r1 = r16
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r2 = 0
            java.util.Iterator r3 = r1.iterator()
        L_0x000b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0140
            java.lang.Object r4 = r3.next()
            r5 = r4
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            r6 = 0
            java.lang.Object r7 = androidx.compose.material.TextFieldImplKt.getLayoutId(r5)
            java.lang.String r8 = "TextField"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r5 == 0) goto L_0x013d
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r1 = r0.invoke(r4, r1)
            java.lang.Number r1 = (java.lang.Number) r1
            int r2 = r1.intValue()
            r1 = r16
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x003c:
            boolean r3 = r1.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x0058
            java.lang.Object r3 = r1.next()
            r5 = r3
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            r6 = 0
            java.lang.Object r7 = androidx.compose.material.TextFieldImplKt.getLayoutId(r5)
            java.lang.String r8 = "Label"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r5 == 0) goto L_0x003c
            goto L_0x0059
        L_0x0058:
            r3 = r4
        L_0x0059:
            androidx.compose.ui.layout.IntrinsicMeasurable r3 = (androidx.compose.ui.layout.IntrinsicMeasurable) r3
            r1 = 0
            if (r3 == 0) goto L_0x006e
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)
            java.lang.Object r6 = r0.invoke(r3, r6)
            java.lang.Number r6 = (java.lang.Number) r6
            int r3 = r6.intValue()
            goto L_0x006f
        L_0x006e:
            r3 = r1
        L_0x006f:
            r12 = r3
            r3 = r16
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x0078:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0093
            java.lang.Object r5 = r3.next()
            r6 = r5
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            r7 = 0
            java.lang.Object r8 = androidx.compose.material.TextFieldImplKt.getLayoutId(r6)
            java.lang.String r9 = "Trailing"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r6 == 0) goto L_0x0078
            goto L_0x0094
        L_0x0093:
            r5 = r4
        L_0x0094:
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            if (r5 == 0) goto L_0x00aa
            r3 = r5
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)
            java.lang.Object r6 = r0.invoke(r3, r6)
            java.lang.Number r6 = (java.lang.Number) r6
            int r3 = r6.intValue()
            r6 = r3
            goto L_0x00ab
        L_0x00aa:
            r6 = r1
        L_0x00ab:
            r3 = r16
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x00b4:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x00cf
            java.lang.Object r5 = r3.next()
            r7 = r5
            androidx.compose.ui.layout.IntrinsicMeasurable r7 = (androidx.compose.ui.layout.IntrinsicMeasurable) r7
            r8 = 0
            java.lang.Object r9 = androidx.compose.material.TextFieldImplKt.getLayoutId(r7)
            java.lang.String r10 = "Leading"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r7 == 0) goto L_0x00b4
            goto L_0x00d0
        L_0x00cf:
            r5 = r4
        L_0x00d0:
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            if (r5 == 0) goto L_0x00e6
            r3 = r5
            r5 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r17)
            java.lang.Object r7 = r0.invoke(r3, r7)
            java.lang.Number r7 = (java.lang.Number) r7
            int r3 = r7.intValue()
            r5 = r3
            goto L_0x00e7
        L_0x00e6:
            r5 = r1
        L_0x00e7:
            r3 = r16
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x00f0:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x010b
            java.lang.Object r7 = r3.next()
            r8 = r7
            androidx.compose.ui.layout.IntrinsicMeasurable r8 = (androidx.compose.ui.layout.IntrinsicMeasurable) r8
            r9 = 0
            java.lang.Object r10 = androidx.compose.material.TextFieldImplKt.getLayoutId(r8)
            java.lang.String r11 = "Hint"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r8 == 0) goto L_0x00f0
            r4 = r7
        L_0x010b:
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            if (r4 == 0) goto L_0x0121
            r3 = r4
            r4 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r17)
            java.lang.Object r7 = r0.invoke(r3, r7)
            java.lang.Number r7 = (java.lang.Number) r7
            int r3 = r7.intValue()
            r7 = r3
            goto L_0x0122
        L_0x0121:
            r7 = r1
        L_0x0122:
            if (r12 <= 0) goto L_0x0127
            r1 = 1
        L_0x0127:
            r3 = r1
            long r8 = androidx.compose.material.TextFieldImplKt.getZeroConstraints()
            float r10 = r15.getDensity()
            r13 = r14
            androidx.compose.foundation.layout.PaddingValues r11 = r13.paddingValues
            r4 = r12
            int r1 = androidx.compose.material.TextFieldKt.m1689calculateHeightO3s9Psw(r2, r3, r4, r5, r6, r7, r8, r10, r11)
            return r1
        L_0x013d:
            r13 = r14
            goto L_0x000b
        L_0x0140:
            r13 = r14
            java.util.NoSuchElementException r3 = new java.util.NoSuchElementException
            java.lang.String r4 = "Collection contains no element matching the predicate."
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldMeasurePolicy.intrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope, java.util.List, int, kotlin.jvm.functions.Function2):int");
    }
}
