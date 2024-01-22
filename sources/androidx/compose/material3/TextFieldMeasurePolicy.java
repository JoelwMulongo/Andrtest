package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ8\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J<\u0010\u0011\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\n2\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0010H\u0002J\"\u0010\u0014\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u0015\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016J/\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\"\u0010\u001f\u001a\u00020\n*\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Landroidx/compose/material3/TextFieldMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "singleLine", "", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(ZFLandroidx/compose/foundation/layout/PaddingValues;)V", "intrinsicWidth", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "intrinsicMeasurer", "Lkotlin/Function2;", "intrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicHeight", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: androidx.compose.ui.layout.Measurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v9, resolved type: androidx.compose.ui.layout.Measurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.ui.layout.MeasureResult m2171measure3p2s80s(androidx.compose.ui.layout.MeasureScope r53, java.util.List<? extends androidx.compose.ui.layout.Measurable> r54, long r55) {
        /*
            r52 = this;
            r15 = r52
            r14 = r53
            r13 = r54
            java.lang.String r0 = "$this$measure"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "measurables"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            androidx.compose.foundation.layout.PaddingValues r0 = r15.paddingValues
            float r0 = r0.m773calculateTopPaddingD9Ej5fM()
            int r12 = r14.m5961roundToPx0680j_4(r0)
            androidx.compose.foundation.layout.PaddingValues r0 = r15.paddingValues
            float r0 = r0.m770calculateBottomPaddingD9Ej5fM()
            int r10 = r14.m5961roundToPx0680j_4(r0)
            float r0 = androidx.compose.material3.TextFieldKt.getTextFieldTopPadding()
            int r19 = r14.m5961roundToPx0680j_4(r0)
            r0 = 0
            r1 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 10
            r9 = 0
            r2 = r55
            long r4 = androidx.compose.ui.unit.Constraints.m5921copyZbe2FdA$default(r2, r4, r5, r6, r7, r8, r9)
            r2 = r13
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0043:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x005e
            java.lang.Object r3 = r2.next()
            r6 = r3
            androidx.compose.ui.layout.Measurable r6 = (androidx.compose.ui.layout.Measurable) r6
            r7 = 0
            java.lang.Object r8 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r6)
            java.lang.String r9 = "Leading"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r6 == 0) goto L_0x0043
            goto L_0x005f
        L_0x005e:
            r3 = 0
        L_0x005f:
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            if (r3 == 0) goto L_0x0069
            androidx.compose.ui.layout.Placeable r2 = r3.m4863measureBRTryo0(r4)
            r8 = r2
            goto L_0x006a
        L_0x0069:
            r8 = 0
        L_0x006a:
            int r2 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r8)
            int r0 = r0 + r2
            int r2 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r8)
            int r1 = java.lang.Math.max(r1, r2)
            r2 = r13
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0082:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x009d
            java.lang.Object r3 = r2.next()
            r6 = r3
            androidx.compose.ui.layout.Measurable r6 = (androidx.compose.ui.layout.Measurable) r6
            r7 = 0
            java.lang.Object r9 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r6)
            java.lang.String r11 = "Trailing"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r11)
            if (r6 == 0) goto L_0x0082
            goto L_0x009e
        L_0x009d:
            r3 = 0
        L_0x009e:
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            if (r3 == 0) goto L_0x00b8
            int r2 = -r0
            r23 = 0
            r24 = 2
            r25 = 0
            r20 = r4
            r22 = r2
            long r6 = androidx.compose.ui.unit.ConstraintsKt.m5947offsetNN6EwU$default(r20, r22, r23, r24, r25)
            androidx.compose.ui.layout.Placeable r2 = r3.m4863measureBRTryo0(r6)
            r9 = r2
            goto L_0x00b9
        L_0x00b8:
            r9 = 0
        L_0x00b9:
            int r2 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r9)
            int r3 = r0 + r2
            int r0 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r9)
            int r0 = java.lang.Math.max(r1, r0)
            int r1 = -r10
            int r2 = -r3
            long r1 = androidx.compose.ui.unit.ConstraintsKt.m5946offsetNN6EwU(r4, r2, r1)
            r6 = r13
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x00db:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0100
            java.lang.Object r7 = r6.next()
            r11 = r7
            androidx.compose.ui.layout.Measurable r11 = (androidx.compose.ui.layout.Measurable) r11
            r17 = 0
            r18 = r6
            java.lang.Object r6 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r11)
            r20 = r7
            java.lang.String r7 = "Label"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x00fd
            r7 = r20
            goto L_0x0101
        L_0x00fd:
            r6 = r18
            goto L_0x00db
        L_0x0100:
            r7 = 0
        L_0x0101:
            androidx.compose.ui.layout.Measurable r7 = (androidx.compose.ui.layout.Measurable) r7
            if (r7 == 0) goto L_0x010a
            androidx.compose.ui.layout.Placeable r6 = r7.m4863measureBRTryo0(r1)
            goto L_0x010b
        L_0x010a:
            r6 = 0
        L_0x010b:
            r11 = r6
            r17 = 0
            if (r11 == 0) goto L_0x0128
            androidx.compose.ui.layout.HorizontalAlignmentLine r6 = androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline()
            androidx.compose.ui.layout.AlignmentLine r6 = (androidx.compose.ui.layout.AlignmentLine) r6
            int r6 = r11.get(r6)
            r7 = 0
            r26 = r1
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r6 == r1) goto L_0x0122
            goto L_0x0127
        L_0x0122:
            int r1 = r11.getHeight()
            r6 = r1
        L_0x0127:
            goto L_0x012c
        L_0x0128:
            r26 = r1
            r6 = r17
        L_0x012c:
            r2 = r6
            int r39 = java.lang.Math.max(r2, r12)
            if (r11 == 0) goto L_0x0136
            int r1 = r39 + r19
            goto L_0x0137
        L_0x0136:
            r1 = r12
        L_0x0137:
            int r6 = -r1
            int r7 = r6 - r10
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 11
            r35 = 0
            r28 = r55
            r36 = r11
            r18 = r12
            long r11 = androidx.compose.ui.unit.Constraints.m5921copyZbe2FdA$default(r28, r30, r31, r32, r33, r34, r35)
            int r6 = -r3
            long r11 = androidx.compose.ui.unit.ConstraintsKt.m5946offsetNN6EwU(r11, r6, r7)
            r6 = r13
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r20 = 0
            java.util.Iterator r21 = r6.iterator()
        L_0x0165:
            boolean r22 = r21.hasNext()
            r40 = r2
            java.lang.String r2 = "Collection contains no element matching the predicate."
            if (r22 == 0) goto L_0x0394
            java.lang.Object r22 = r21.next()
            r23 = r22
            androidx.compose.ui.layout.Measurable r23 = (androidx.compose.ui.layout.Measurable) r23
            r24 = 0
            r41 = r3
            java.lang.Object r3 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r23)
            r25 = r6
            java.lang.String r6 = "TextField"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r6)
            if (r3 == 0) goto L_0x0372
            r3 = r22
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            androidx.compose.ui.layout.Placeable r6 = r3.m4863measureBRTryo0(r11)
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 14
            r35 = 0
            r28 = r11
            r42 = r2
            long r2 = androidx.compose.ui.unit.Constraints.m5921copyZbe2FdA$default(r28, r30, r31, r32, r33, r34, r35)
            r20 = r13
            java.lang.Iterable r20 = (java.lang.Iterable) r20
            java.util.Iterator r20 = r20.iterator()
        L_0x01af:
            boolean r21 = r20.hasNext()
            if (r21 == 0) goto L_0x01d5
            java.lang.Object r21 = r20.next()
            r22 = r21
            androidx.compose.ui.layout.Measurable r22 = (androidx.compose.ui.layout.Measurable) r22
            r23 = 0
            r24 = r7
            java.lang.Object r7 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r22)
            r28 = r11
            java.lang.String r11 = "Hint"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r11)
            if (r7 == 0) goto L_0x01d0
            goto L_0x01db
        L_0x01d0:
            r7 = r24
            r11 = r28
            goto L_0x01af
        L_0x01d5:
            r24 = r7
            r28 = r11
            r21 = 0
        L_0x01db:
            r7 = r21
            androidx.compose.ui.layout.Measurable r7 = (androidx.compose.ui.layout.Measurable) r7
            if (r7 == 0) goto L_0x01e7
            androidx.compose.ui.layout.Placeable r7 = r7.m4863measureBRTryo0(r2)
            goto L_0x01e8
        L_0x01e7:
            r7 = 0
        L_0x01e8:
            r43 = r24
            int r11 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r6)
            int r12 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r7)
            int r11 = java.lang.Math.max(r11, r12)
            int r11 = r11 + r1
            int r11 = r11 + r10
            int r11 = java.lang.Math.max(r0, r11)
            r12 = r11
            r22 = 0
            int r0 = -r12
            r24 = 1
            r25 = 0
            r20 = r4
            r23 = r0
            long r44 = androidx.compose.ui.unit.ConstraintsKt.m5947offsetNN6EwU$default(r20, r22, r23, r24, r25)
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 11
            r51 = 0
            long r20 = androidx.compose.ui.unit.Constraints.m5921copyZbe2FdA$default(r44, r46, r47, r48, r49, r50, r51)
            r22 = r20
            r0 = r13
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0228:
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x024e
            java.lang.Object r11 = r0.next()
            r20 = r11
            androidx.compose.ui.layout.Measurable r20 = (androidx.compose.ui.layout.Measurable) r20
            r21 = 0
            r24 = r0
            java.lang.Object r0 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r20)
            r44 = r1
            java.lang.String r1 = "Supporting"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0249
            goto L_0x0251
        L_0x0249:
            r0 = r24
            r1 = r44
            goto L_0x0228
        L_0x024e:
            r44 = r1
            r11 = 0
        L_0x0251:
            androidx.compose.ui.layout.Measurable r11 = (androidx.compose.ui.layout.Measurable) r11
            if (r11 == 0) goto L_0x025c
            r0 = r22
            androidx.compose.ui.layout.Placeable r11 = r11.m4863measureBRTryo0(r0)
            goto L_0x025f
        L_0x025c:
            r0 = r22
            r11 = 0
        L_0x025f:
            r45 = r28
            r23 = r36
            int r20 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r11)
            int r28 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r8)
            int r29 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r9)
            int r30 = r6.getWidth()
            int r31 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r23)
            int r32 = androidx.compose.material3.TextFieldImplKt.widthOrZero(r7)
            r33 = r55
            int r14 = androidx.compose.material3.TextFieldKt.m2170calculateWidthVsPV1Ek(r28, r29, r30, r31, r32, r33)
            int r28 = r6.getHeight()
            if (r23 == 0) goto L_0x028d
            r16 = 1
            r29 = r16
            goto L_0x028f
        L_0x028d:
            r29 = r17
        L_0x028f:
            int r31 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r8)
            int r32 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r9)
            int r33 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r7)
            int r34 = androidx.compose.material3.TextFieldImplKt.heightOrZero(r11)
            float r37 = r53.getDensity()
            r21 = r0
            androidx.compose.foundation.layout.PaddingValues r0 = r15.paddingValues
            r30 = r39
            r35 = r55
            r38 = r0
            int r24 = androidx.compose.material3.TextFieldKt.m2169calculateHeightjCXOeKk(r28, r29, r30, r31, r32, r33, r34, r35, r37, r38)
            int r1 = r24 - r20
            r0 = r13
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r16 = 0
            java.util.Iterator r25 = r0.iterator()
        L_0x02be:
            boolean r28 = r25.hasNext()
            if (r28 == 0) goto L_0x0366
            java.lang.Object r28 = r25.next()
            r29 = r28
            androidx.compose.ui.layout.Measurable r29 = (androidx.compose.ui.layout.Measurable) r29
            r30 = 0
            r31 = r0
            java.lang.Object r0 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r29)
            r32 = r2
            java.lang.String r2 = "Container"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0342
            r0 = r28
            androidx.compose.ui.layout.Measurable r0 = (androidx.compose.ui.layout.Measurable) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r14 == r2) goto L_0x02e9
            r3 = r14
            goto L_0x02eb
        L_0x02e9:
            r3 = r17
        L_0x02eb:
            if (r1 == r2) goto L_0x02f0
            r2 = r1
            goto L_0x02f2
        L_0x02f0:
            r2 = r17
        L_0x02f2:
            long r2 = androidx.compose.ui.unit.ConstraintsKt.Constraints(r3, r14, r2, r1)
            androidx.compose.ui.layout.Placeable r25 = r0.m4863measureBRTryo0(r2)
            r16 = 0
            androidx.compose.material3.TextFieldMeasurePolicy$measure$1 r17 = new androidx.compose.material3.TextFieldMeasurePolicy$measure$1
            r0 = r17
            r30 = r1
            r29 = r44
            r1 = r23
            r33 = r32
            r32 = r40
            r2 = r18
            r35 = r41
            r3 = r32
            r36 = r4
            r4 = r14
            r5 = r24
            r38 = r10
            r10 = r25
            r41 = r12
            r40 = r18
            r12 = r52
            r13 = r39
            r44 = r14
            r14 = r19
            r15 = r53
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r0 = r17
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r17 = 4
            r18 = 0
            r12 = r53
            r13 = r44
            r14 = r24
            r15 = r16
            r16 = r0
            androidx.compose.ui.layout.MeasureResult r0 = androidx.compose.ui.layout.MeasureScope.layout$default(r12, r13, r14, r15, r16, r17, r18)
            return r0
        L_0x0342:
            r30 = r1
            r36 = r4
            r38 = r10
            r33 = r32
            r32 = r40
            r35 = r41
            r29 = r44
            r41 = r12
            r44 = r14
            r40 = r18
            r15 = r52
            r13 = r54
            r0 = r31
            r2 = r33
            r44 = r29
            r40 = r32
            r41 = r35
            goto L_0x02be
        L_0x0366:
            r31 = r0
            r30 = r1
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r1 = r42
            r0.<init>(r1)
            throw r0
        L_0x0372:
            r29 = r1
            r43 = r7
            r38 = r10
            r45 = r11
            r23 = r36
            r32 = r40
            r35 = r41
            r36 = r4
            r40 = r18
            r15 = r52
            r14 = r53
            r13 = r54
            r6 = r25
            r2 = r32
            r3 = r35
            r36 = r23
            goto L_0x0165
        L_0x0394:
            r29 = r1
            r1 = r2
            java.util.NoSuchElementException r2 = new java.util.NoSuchElementException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldMeasurePolicy.m2171measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
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
            java.lang.Object r6 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r4)
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
            java.lang.Object r6 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r2)
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
            java.lang.Object r8 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r6)
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
            java.lang.Object r9 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r7)
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
            java.lang.Object r10 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r8)
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
            long r6 = androidx.compose.material3.TextFieldImplKt.getZeroConstraints()
            int r0 = androidx.compose.material3.TextFieldKt.m2170calculateWidthVsPV1Ek(r1, r2, r3, r4, r5, r6)
            return r0
        L_0x012a:
            java.util.NoSuchElementException r2 = new java.util.NoSuchElementException
            java.lang.String r3 = "Collection contains no element matching the predicate."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldMeasurePolicy.intrinsicWidth(java.util.List, int, kotlin.jvm.functions.Function2):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: androidx.compose.ui.layout.IntrinsicMeasurable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int intrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope r16, java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable> r17, int r18, kotlin.jvm.functions.Function2<? super androidx.compose.ui.layout.IntrinsicMeasurable, ? super java.lang.Integer, java.lang.Integer> r19) {
        /*
            r15 = this;
            r0 = r19
            r1 = r17
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r2 = 0
            java.util.Iterator r3 = r1.iterator()
        L_0x000b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x017d
            java.lang.Object r4 = r3.next()
            r5 = r4
            androidx.compose.ui.layout.IntrinsicMeasurable r5 = (androidx.compose.ui.layout.IntrinsicMeasurable) r5
            r6 = 0
            java.lang.Object r7 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r5)
            java.lang.String r8 = "TextField"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r5 == 0) goto L_0x017a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r18)
            java.lang.Object r1 = r0.invoke(r4, r1)
            java.lang.Number r1 = (java.lang.Number) r1
            int r2 = r1.intValue()
            r1 = r17
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
            java.lang.Object r7 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r5)
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
            java.lang.Integer r6 = java.lang.Integer.valueOf(r18)
            java.lang.Object r6 = r0.invoke(r3, r6)
            java.lang.Number r6 = (java.lang.Number) r6
            int r3 = r6.intValue()
            goto L_0x006f
        L_0x006e:
            r3 = r1
        L_0x006f:
            r13 = r3
            r3 = r17
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x0078:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0093
            java.lang.Object r5 = r3.next()
            r6 = r5
            androidx.compose.ui.layout.IntrinsicMeasurable r6 = (androidx.compose.ui.layout.IntrinsicMeasurable) r6
            r7 = 0
            java.lang.Object r8 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r6)
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
            java.lang.Integer r6 = java.lang.Integer.valueOf(r18)
            java.lang.Object r6 = r0.invoke(r3, r6)
            java.lang.Number r6 = (java.lang.Number) r6
            int r3 = r6.intValue()
            r6 = r3
            goto L_0x00ab
        L_0x00aa:
            r6 = r1
        L_0x00ab:
            r3 = r17
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x00b4:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x00cf
            java.lang.Object r5 = r3.next()
            r7 = r5
            androidx.compose.ui.layout.IntrinsicMeasurable r7 = (androidx.compose.ui.layout.IntrinsicMeasurable) r7
            r8 = 0
            java.lang.Object r9 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r7)
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
            java.lang.Integer r7 = java.lang.Integer.valueOf(r18)
            java.lang.Object r7 = r0.invoke(r3, r7)
            java.lang.Number r7 = (java.lang.Number) r7
            int r3 = r7.intValue()
            r5 = r3
            goto L_0x00e7
        L_0x00e6:
            r5 = r1
        L_0x00e7:
            r3 = r17
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x00f0:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x010b
            java.lang.Object r7 = r3.next()
            r8 = r7
            androidx.compose.ui.layout.IntrinsicMeasurable r8 = (androidx.compose.ui.layout.IntrinsicMeasurable) r8
            r9 = 0
            java.lang.Object r10 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r8)
            java.lang.String r11 = "Hint"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r8 == 0) goto L_0x00f0
            goto L_0x010c
        L_0x010b:
            r7 = r4
        L_0x010c:
            androidx.compose.ui.layout.IntrinsicMeasurable r7 = (androidx.compose.ui.layout.IntrinsicMeasurable) r7
            if (r7 == 0) goto L_0x0122
            r3 = r7
            r7 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r18)
            java.lang.Object r8 = r0.invoke(r3, r8)
            java.lang.Number r8 = (java.lang.Number) r8
            int r3 = r8.intValue()
            r7 = r3
            goto L_0x0123
        L_0x0122:
            r7 = r1
        L_0x0123:
            r3 = r17
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x012c:
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x0147
            java.lang.Object r8 = r3.next()
            r9 = r8
            androidx.compose.ui.layout.IntrinsicMeasurable r9 = (androidx.compose.ui.layout.IntrinsicMeasurable) r9
            r10 = 0
            java.lang.Object r11 = androidx.compose.material3.TextFieldImplKt.getLayoutId(r9)
            java.lang.String r12 = "Supporting"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
            if (r9 == 0) goto L_0x012c
            r4 = r8
        L_0x0147:
            androidx.compose.ui.layout.IntrinsicMeasurable r4 = (androidx.compose.ui.layout.IntrinsicMeasurable) r4
            if (r4 == 0) goto L_0x015d
            r3 = r4
            r4 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r18)
            java.lang.Object r8 = r0.invoke(r3, r8)
            java.lang.Number r8 = (java.lang.Number) r8
            int r3 = r8.intValue()
            r8 = r3
            goto L_0x015e
        L_0x015d:
            r8 = r1
        L_0x015e:
            if (r13 <= 0) goto L_0x0163
            r1 = 1
        L_0x0163:
            r3 = r1
            long r9 = androidx.compose.material3.TextFieldImplKt.getZeroConstraints()
            float r11 = r16.getDensity()
            r14 = r15
            androidx.compose.foundation.layout.PaddingValues r12 = r14.paddingValues
            r4 = r13
            int r1 = androidx.compose.material3.TextFieldKt.m2169calculateHeightjCXOeKk(r2, r3, r4, r5, r6, r7, r8, r9, r11, r12)
            return r1
        L_0x017a:
            r14 = r15
            goto L_0x000b
        L_0x017d:
            r14 = r15
            java.util.NoSuchElementException r3 = new java.util.NoSuchElementException
            java.lang.String r4 = "Collection contains no element matching the predicate."
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldMeasurePolicy.intrinsicHeight(androidx.compose.ui.layout.IntrinsicMeasureScope, java.util.List, int, kotlin.jvm.functions.Function2):int");
    }
}
