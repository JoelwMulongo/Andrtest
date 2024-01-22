package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001Br\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012*\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0017J2\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00162\b\u0010-\u001a\u0004\u0018\u00010)2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u0006H\u0002J(\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00104\u001a\u000205H\u0002J3\u00106\u001a\u0002072\u0006\u00104\u001a\u0002052\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J&\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u0002072\u0006\u0010B\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\bJ\n\u0010\r\u001a\u00020\u0006*\u00020\u0016J\n\u0010C\u001a\u00020\u0006*\u00020\u0016R5\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000b\u001a\u00020\fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001b\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0018\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u0015X\u0004¢\u0006\u0004\n\u0002\u0010*\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006D"}, d2 = {"Landroidx/compose/foundation/layout/RowColumnMeasurementHelper;", "", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "arrangement", "Lkotlin/Function5;", "", "", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "", "arrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSize", "Landroidx/compose/foundation/layout/SizeMode;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "(Landroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/functions/Function5;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Ljava/util/List;[Landroidx/compose/ui/layout/Placeable;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getArrangement", "()Lkotlin/jvm/functions/Function5;", "getArrangementSpacing-D9Ej5fM", "()F", "F", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisSize", "()Landroidx/compose/foundation/layout/SizeMode;", "getMeasurables", "()Ljava/util/List;", "getOrientation", "()Landroidx/compose/foundation/layout/LayoutOrientation;", "getPlaceables", "()[Landroidx/compose/ui/layout/Placeable;", "[Landroidx/compose/ui/layout/Placeable;", "rowColumnParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "[Landroidx/compose/foundation/layout/RowColumnParentData;", "getCrossAxisPosition", "placeable", "parentData", "crossAxisLayoutSize", "layoutDirection", "beforeCrossAxisAlignmentLine", "mainAxisPositions", "mainAxisLayoutSize", "childrenMainAxisSize", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "measureWithoutPlacing", "Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "startIndex", "endIndex", "measureWithoutPlacing-_EkL_-Y", "(Landroidx/compose/ui/layout/MeasureScope;JII)Landroidx/compose/foundation/layout/RowColumnMeasureHelperResult;", "placeHelper", "placeableScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "measureResult", "crossAxisOffset", "mainAxisSize", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RowColumnMeasurementHelper.kt */
public final class RowColumnMeasurementHelper {
    private final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> arrangement;
    private final float arrangementSpacing;
    private final CrossAxisAlignment crossAxisAlignment;
    private final SizeMode crossAxisSize;
    private final List<Measurable> measurables;
    private final LayoutOrientation orientation;
    private final Placeable[] placeables;
    private final RowColumnParentData[] rowColumnParentData;

    public /* synthetic */ RowColumnMeasurementHelper(LayoutOrientation layoutOrientation, Function5 function5, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment2, List list, Placeable[] placeableArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutOrientation, function5, f, sizeMode, crossAxisAlignment2, list, placeableArr);
    }

    private RowColumnMeasurementHelper(LayoutOrientation orientation2, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> arrangement2, float arrangementSpacing2, SizeMode crossAxisSize2, CrossAxisAlignment crossAxisAlignment2, List<? extends Measurable> measurables2, Placeable[] placeables2) {
        this.orientation = orientation2;
        this.arrangement = arrangement2;
        this.arrangementSpacing = arrangementSpacing2;
        this.crossAxisSize = crossAxisSize2;
        this.crossAxisAlignment = crossAxisAlignment2;
        this.measurables = measurables2;
        this.placeables = placeables2;
        int size = measurables2.size();
        RowColumnParentData[] rowColumnParentDataArr = new RowColumnParentData[size];
        for (int i = 0; i < size; i++) {
            rowColumnParentDataArr[i] = RowColumnImplKt.getRowColumnParentData(this.measurables.get(i));
        }
        this.rowColumnParentData = rowColumnParentDataArr;
    }

    public final LayoutOrientation getOrientation() {
        return this.orientation;
    }

    public final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> getArrangement() {
        return this.arrangement;
    }

    /* renamed from: getArrangementSpacing-D9Ej5fM  reason: not valid java name */
    public final float m801getArrangementSpacingD9Ej5fM() {
        return this.arrangementSpacing;
    }

    public final SizeMode getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final List<Measurable> getMeasurables() {
        return this.measurables;
    }

    public final Placeable[] getPlaceables() {
        return this.placeables;
    }

    public final int mainAxisSize(Placeable $this$mainAxisSize) {
        Intrinsics.checkNotNullParameter($this$mainAxisSize, "<this>");
        return this.orientation == LayoutOrientation.Horizontal ? $this$mainAxisSize.getWidth() : $this$mainAxisSize.getHeight();
    }

    public final int crossAxisSize(Placeable $this$crossAxisSize) {
        Intrinsics.checkNotNullParameter($this$crossAxisSize, "<this>");
        return this.orientation == LayoutOrientation.Horizontal ? $this$crossAxisSize.getHeight() : $this$crossAxisSize.getWidth();
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01bc  */
    /* renamed from: measureWithoutPlacing-_EkL_-Y  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.foundation.layout.RowColumnMeasureHelperResult m802measureWithoutPlacing_EkL_Y(androidx.compose.ui.layout.MeasureScope r31, long r32, int r34, int r35) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            r9 = r35
            java.lang.String r2 = "measureScope"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            androidx.compose.foundation.layout.OrientationIndependentConstraints r10 = new androidx.compose.foundation.layout.OrientationIndependentConstraints
            androidx.compose.foundation.layout.LayoutOrientation r2 = r0.orientation
            r3 = 0
            r7 = r32
            r10.<init>(r7, r2, r3)
            r2 = r31
            r4 = 0
            float r5 = r0.arrangementSpacing
            int r2 = r2.m5961roundToPx0680j_4(r5)
            r6 = r2
            r2 = 0
            r4 = 0
            r5 = 0
            r11 = 0
            r12 = 0
            int r15 = r9 - r34
            r13 = 0
            r14 = r34
            r17 = r2
            r18 = r11
            r2 = r12
            r19 = r13
        L_0x0031:
            r11 = 2147483647(0x7fffffff, float:NaN)
            r12 = 0
            r20 = 1
            if (r14 >= r9) goto L_0x00d1
            java.util.List<androidx.compose.ui.layout.Measurable> r3 = r0.measurables
            java.lang.Object r3 = r3.get(r14)
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            androidx.compose.foundation.layout.RowColumnParentData[] r13 = r0.rowColumnParentData
            r22 = r13[r14]
            float r23 = androidx.compose.foundation.layout.RowColumnImplKt.getWeight(r22)
            int r12 = (r23 > r12 ? 1 : (r23 == r12 ? 0 : -1))
            if (r12 <= 0) goto L_0x0057
            float r17 = r17 + r23
            int r18 = r18 + 1
            r25 = r14
            r29 = r15
            goto L_0x00ca
        L_0x0057:
            int r13 = r10.getMainAxisMax()
            androidx.compose.ui.layout.Placeable[] r12 = r0.placeables
            r12 = r12[r14]
            if (r12 != 0) goto L_0x0094
            r12 = 0
            if (r13 != r11) goto L_0x0068
            r24 = r11
            goto L_0x006c
        L_0x0068:
            int r11 = r13 - r4
            r24 = r11
        L_0x006c:
            r25 = 0
            r26 = 0
            r27 = 8
            r28 = 0
            r11 = r12
            r12 = r24
            r24 = r13
            r13 = r25
            r25 = r14
            r14 = r26
            r29 = r15
            r15 = r27
            r16 = r28
            androidx.compose.foundation.layout.OrientationIndependentConstraints r11 = androidx.compose.foundation.layout.OrientationIndependentConstraints.copy$default(r10, r11, r12, r13, r14, r15, r16)
            androidx.compose.foundation.layout.LayoutOrientation r12 = r0.orientation
            long r11 = r11.m752toBoxConstraintsOenEA2s(r12)
            androidx.compose.ui.layout.Placeable r12 = r3.m4863measureBRTryo0(r11)
            goto L_0x009a
        L_0x0094:
            r24 = r13
            r25 = r14
            r29 = r15
        L_0x009a:
            r11 = r12
            int r13 = r24 - r4
            int r12 = r0.mainAxisSize(r11)
            int r13 = r13 - r12
            int r12 = java.lang.Math.min(r6, r13)
            int r13 = r0.mainAxisSize(r11)
            int r13 = r13 + r12
            int r4 = r4 + r13
            int r13 = r0.crossAxisSize(r11)
            int r5 = java.lang.Math.max(r5, r13)
            if (r2 != 0) goto L_0x00c1
            boolean r13 = androidx.compose.foundation.layout.RowColumnImplKt.isRelative(r22)
            if (r13 == 0) goto L_0x00bf
            goto L_0x00c1
        L_0x00bf:
            r13 = 0
            goto L_0x00c3
        L_0x00c1:
            r13 = r20
        L_0x00c3:
            r2 = r13
            androidx.compose.ui.layout.Placeable[] r13 = r0.placeables
            r13[r25] = r11
            r19 = r12
        L_0x00ca:
            int r14 = r25 + 1
            r15 = r29
            r3 = 0
            goto L_0x0031
        L_0x00d1:
            r25 = r14
            r29 = r15
            r3 = 0
            if (r18 != 0) goto L_0x00e0
            int r4 = r4 - r19
            r1 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            goto L_0x0205
        L_0x00e0:
            int r13 = (r17 > r12 ? 1 : (r17 == r12 ? 0 : -1))
            if (r13 <= 0) goto L_0x00ef
            int r13 = r10.getMainAxisMax()
            if (r13 == r11) goto L_0x00ef
            int r13 = r10.getMainAxisMax()
            goto L_0x00f3
        L_0x00ef:
            int r13 = r10.getMainAxisMin()
        L_0x00f3:
            int r14 = r13 - r4
            int r15 = r18 + -1
            int r15 = r15 * r6
            int r14 = r14 - r15
            int r15 = (r17 > r12 ? 1 : (r17 == r12 ? 0 : -1))
            if (r15 <= 0) goto L_0x0104
            float r15 = (float) r14
            float r15 = r15 / r17
            goto L_0x0105
        L_0x0104:
            r15 = r12
        L_0x0105:
            kotlin.ranges.IntRange r16 = kotlin.ranges.RangesKt.until((int) r34, (int) r35)
            java.lang.Iterable r16 = (java.lang.Iterable) r16
            java.util.Iterator r16 = r16.iterator()
            r22 = 0
        L_0x0111:
            boolean r23 = r16.hasNext()
            if (r23 == 0) goto L_0x0134
            r23 = r16
            kotlin.collections.IntIterator r23 = (kotlin.collections.IntIterator) r23
            int r23 = r23.nextInt()
            r24 = 0
            androidx.compose.foundation.layout.RowColumnParentData[] r11 = r0.rowColumnParentData
            r11 = r11[r23]
            float r11 = androidx.compose.foundation.layout.RowColumnImplKt.getWeight(r11)
            float r11 = r11 * r15
            int r11 = kotlin.math.MathKt.roundToInt((float) r11)
            int r22 = r22 + r11
            r11 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0111
        L_0x0134:
            int r11 = r14 - r22
            r16 = r34
            r12 = r16
        L_0x013a:
            if (r12 >= r9) goto L_0x01ec
            androidx.compose.ui.layout.Placeable[] r7 = r0.placeables
            r7 = r7[r12]
            if (r7 != 0) goto L_0x01d6
            java.util.List<androidx.compose.ui.layout.Measurable> r7 = r0.measurables
            java.lang.Object r7 = r7.get(r12)
            androidx.compose.ui.layout.Measurable r7 = (androidx.compose.ui.layout.Measurable) r7
            androidx.compose.foundation.layout.RowColumnParentData[] r8 = r0.rowColumnParentData
            r8 = r8[r12]
            float r22 = androidx.compose.foundation.layout.RowColumnImplKt.getWeight(r8)
            r16 = 0
            int r23 = (r22 > r16 ? 1 : (r22 == r16 ? 0 : -1))
            if (r23 <= 0) goto L_0x015b
            r23 = r20
            goto L_0x015d
        L_0x015b:
            r23 = 0
        L_0x015d:
            if (r23 == 0) goto L_0x01c6
            int r23 = kotlin.math.MathKt.getSign((int) r11)
            int r11 = r11 - r23
            float r24 = r15 * r22
            int r24 = kotlin.math.MathKt.roundToInt((float) r24)
            r26 = r11
            int r11 = r24 + r23
            r24 = r13
            r13 = 0
            int r11 = java.lang.Math.max(r13, r11)
            androidx.compose.foundation.layout.OrientationIndependentConstraints r13 = new androidx.compose.foundation.layout.OrientationIndependentConstraints
            boolean r27 = androidx.compose.foundation.layout.RowColumnImplKt.getFill(r8)
            if (r27 == 0) goto L_0x018b
            r27 = r14
            r14 = 2147483647(0x7fffffff, float:NaN)
            if (r11 == r14) goto L_0x018d
            r14 = r11
            goto L_0x018e
        L_0x018b:
            r27 = r14
        L_0x018d:
            r14 = 0
        L_0x018e:
            r28 = r15
            int r15 = r10.getCrossAxisMax()
            r1 = 0
            r13.<init>(r14, r11, r1, r15)
            androidx.compose.foundation.layout.LayoutOrientation r1 = r0.orientation
            long r13 = r13.m752toBoxConstraintsOenEA2s(r1)
            androidx.compose.ui.layout.Placeable r1 = r7.m4863measureBRTryo0(r13)
            int r13 = r0.mainAxisSize(r1)
            int r3 = r3 + r13
            int r13 = r0.crossAxisSize(r1)
            int r5 = java.lang.Math.max(r5, r13)
            if (r2 != 0) goto L_0x01bc
            boolean r13 = androidx.compose.foundation.layout.RowColumnImplKt.isRelative(r8)
            if (r13 == 0) goto L_0x01ba
            goto L_0x01bc
        L_0x01ba:
            r13 = 0
            goto L_0x01be
        L_0x01bc:
            r13 = r20
        L_0x01be:
            r2 = r13
            androidx.compose.ui.layout.Placeable[] r13 = r0.placeables
            r13[r12] = r1
            r11 = r26
            goto L_0x01de
        L_0x01c6:
            r24 = r13
            r1 = 0
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r13 = "All weights <= 0 should have placeables"
            java.lang.String r13 = r13.toString()
            r1.<init>(r13)
            throw r1
        L_0x01d6:
            r24 = r13
            r27 = r14
            r28 = r15
            r16 = 0
        L_0x01de:
            int r12 = r12 + 1
            r1 = r31
            r7 = r32
            r13 = r24
            r14 = r27
            r15 = r28
            goto L_0x013a
        L_0x01ec:
            r24 = r13
            r27 = r14
            r28 = r15
            int r1 = r18 + -1
            int r1 = r1 * r6
            int r1 = r1 + r3
            int r7 = r10.getMainAxisMax()
            int r7 = r7 - r4
            int r1 = kotlin.ranges.RangesKt.coerceAtMost((int) r1, (int) r7)
            r3 = r1
            r1 = r2
            r11 = r3
            r12 = r4
            r13 = r5
        L_0x0205:
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x0269
            r4 = r34
        L_0x020b:
            if (r4 >= r9) goto L_0x0264
            androidx.compose.ui.layout.Placeable[] r5 = r0.placeables
            r5 = r5[r4]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            androidx.compose.foundation.layout.RowColumnParentData[] r7 = r0.rowColumnParentData
            r7 = r7[r4]
            androidx.compose.foundation.layout.CrossAxisAlignment r8 = androidx.compose.foundation.layout.RowColumnImplKt.getCrossAxisAlignment(r7)
            if (r8 == 0) goto L_0x0225
            java.lang.Integer r8 = r8.calculateAlignmentLinePosition$foundation_layout_release(r5)
            goto L_0x0226
        L_0x0225:
            r8 = 0
        L_0x0226:
            if (r8 == 0) goto L_0x025d
            r14 = r8
            java.lang.Number r14 = (java.lang.Number) r14
            int r14 = r14.intValue()
            r15 = 0
            r16 = r1
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r14 == r1) goto L_0x0239
            goto L_0x023a
        L_0x0239:
            r14 = 0
        L_0x023a:
            int r2 = java.lang.Math.max(r2, r14)
            int r14 = r0.crossAxisSize(r5)
            r15 = r8
            java.lang.Number r15 = (java.lang.Number) r15
            int r15 = r15.intValue()
            r20 = 0
            if (r15 == r1) goto L_0x0251
            r1 = r15
            goto L_0x0255
        L_0x0251:
            int r1 = r0.crossAxisSize(r5)
        L_0x0255:
            int r14 = r14 - r1
            int r3 = java.lang.Math.max(r3, r14)
            goto L_0x025f
        L_0x025d:
            r16 = r1
        L_0x025f:
            int r4 = r4 + 1
            r1 = r16
            goto L_0x020b
        L_0x0264:
            r16 = r1
            r1 = r2
            r14 = r3
            goto L_0x026d
        L_0x0269:
            r16 = r1
            r1 = r2
            r14 = r3
        L_0x026d:
            int r2 = r12 + r11
            int r3 = r10.getMainAxisMin()
            int r15 = java.lang.Math.max(r2, r3)
            int r2 = r10.getCrossAxisMax()
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 == r3) goto L_0x028c
            androidx.compose.foundation.layout.SizeMode r2 = r0.crossAxisSize
            androidx.compose.foundation.layout.SizeMode r3 = androidx.compose.foundation.layout.SizeMode.Expand
            if (r2 != r3) goto L_0x028c
            int r2 = r10.getCrossAxisMax()
            r3 = r2
            goto L_0x029d
        L_0x028c:
            int r2 = r10.getCrossAxisMin()
            int r3 = r1 + r14
            int r2 = java.lang.Math.max(r2, r3)
            int r2 = java.lang.Math.max(r13, r2)
            r3 = r2
        L_0x029d:
            r8 = r29
            int[] r2 = new int[r8]
            r4 = 0
        L_0x02a3:
            if (r4 >= r8) goto L_0x02ab
            r5 = 0
            r2[r4] = r5
            int r4 = r4 + 1
            goto L_0x02a3
        L_0x02ab:
            r5 = 0
            r7 = r2
            int[] r2 = new int[r8]
        L_0x02af:
            if (r5 >= r8) goto L_0x02c3
            androidx.compose.ui.layout.Placeable[] r4 = r0.placeables
            int r20 = r5 + r34
            r4 = r4[r20]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r4 = r0.mainAxisSize(r4)
            r2[r5] = r4
            int r5 = r5 + 1
            goto L_0x02af
        L_0x02c3:
            r5 = r2
            r4 = r31
            int[] r20 = r0.mainAxisPositions(r15, r5, r7, r4)
            androidx.compose.foundation.layout.RowColumnMeasureHelperResult r21 = new androidx.compose.foundation.layout.RowColumnMeasureHelperResult
            r2 = r21
            r4 = r15
            r22 = r5
            r5 = r34
            r23 = r6
            r6 = r35
            r24 = r7
            r7 = r1
            r25 = r8
            r8 = r20
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r21
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.RowColumnMeasurementHelper.m802measureWithoutPlacing_EkL_Y(androidx.compose.ui.layout.MeasureScope, long, int, int):androidx.compose.foundation.layout.RowColumnMeasureHelperResult");
    }

    private final int[] mainAxisPositions(int mainAxisLayoutSize, int[] childrenMainAxisSize, int[] mainAxisPositions, MeasureScope measureScope) {
        this.arrangement.invoke(Integer.valueOf(mainAxisLayoutSize), childrenMainAxisSize, measureScope.getLayoutDirection(), measureScope, mainAxisPositions);
        return mainAxisPositions;
    }

    private final int getCrossAxisPosition(Placeable placeable, RowColumnParentData parentData, int crossAxisLayoutSize, LayoutDirection layoutDirection, int beforeCrossAxisAlignmentLine) {
        CrossAxisAlignment childCrossAlignment;
        LayoutDirection layoutDirection2;
        if (parentData == null || (childCrossAlignment = parentData.getCrossAxisAlignment()) == null) {
            childCrossAlignment = this.crossAxisAlignment;
        }
        int crossAxisSize2 = crossAxisLayoutSize - crossAxisSize(placeable);
        if (this.orientation == LayoutOrientation.Horizontal) {
            layoutDirection2 = LayoutDirection.Ltr;
        } else {
            layoutDirection2 = layoutDirection;
        }
        return childCrossAlignment.align$foundation_layout_release(crossAxisSize2, layoutDirection2, placeable, beforeCrossAxisAlignmentLine);
    }

    public final void placeHelper(Placeable.PlacementScope placeableScope, RowColumnMeasureHelperResult measureResult, int crossAxisOffset, LayoutDirection layoutDirection) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(placeableScope, "placeableScope");
        Intrinsics.checkNotNullParameter(measureResult, "measureResult");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Placeable.PlacementScope $this$placeHelper_u24lambda_u245 = placeableScope;
        int i3 = measureResult.getStartIndex();
        int endIndex = measureResult.getEndIndex();
        int i4 = i3;
        while (i4 < endIndex) {
            Placeable placeable = this.placeables[i4];
            Intrinsics.checkNotNull(placeable);
            int[] mainAxisPositions = measureResult.getMainAxisPositions();
            Object parentData = this.measurables.get(i4).getParentData();
            int crossAxisPosition = getCrossAxisPosition(placeable, parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null, measureResult.getCrossAxisSize(), layoutDirection, measureResult.getBeforeCrossAxisAlignmentLine()) + crossAxisOffset;
            if (this.orientation == LayoutOrientation.Horizontal) {
                i = i4;
                i2 = endIndex;
                Placeable.PlacementScope.place$default($this$placeHelper_u24lambda_u245, placeable, mainAxisPositions[i4 - measureResult.getStartIndex()], crossAxisPosition, 0.0f, 4, (Object) null);
            } else {
                i = i4;
                i2 = endIndex;
                Placeable.PlacementScope.place$default($this$placeHelper_u24lambda_u245, placeable, crossAxisPosition, mainAxisPositions[i - measureResult.getStartIndex()], 0.0f, 4, (Object) null);
            }
            i4 = i + 1;
            LayoutDirection layoutDirection2 = layoutDirection;
            endIndex = i2;
        }
    }
}
