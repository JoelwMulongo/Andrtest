package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001aA\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a5\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a5\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00162\b\b\u0002\u0010\u000b\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a-\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a-\u0010\u0019\u001a\u00020\u0013*\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"horizontal", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getHorizontal", "(Landroidx/compose/ui/layout/AlignmentLine;)Z", "alignmentLineOffsetMeasure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "alignmentLine", "before", "Landroidx/compose/ui/unit/Dp;", "after", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "alignmentLineOffsetMeasure-tjqqzMA", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/AlignmentLine;FFLandroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "paddingFrom", "Landroidx/compose/ui/Modifier;", "paddingFrom-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;FF)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/unit/TextUnit;", "paddingFrom-Y_r0B1c", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;JJ)Landroidx/compose/ui/Modifier;", "paddingFromBaseline", "top", "bottom", "paddingFromBaseline-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "paddingFromBaseline-wCyjxdI", "(Landroidx/compose/ui/Modifier;JJ)Landroidx/compose/ui/Modifier;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlignmentLine.kt */
public final class AlignmentLineKt {
    /* renamed from: paddingFrom-4j6BHR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m654paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f2 = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        return m653paddingFrom4j6BHR0(modifier, alignmentLine, f, f2);
    }

    /* renamed from: paddingFrom-4j6BHR0  reason: not valid java name */
    public static final Modifier m653paddingFrom4j6BHR0(Modifier $this$paddingFrom_u2d4j6BHR0, AlignmentLine alignmentLine, float before, float after) {
        Intrinsics.checkNotNullParameter($this$paddingFrom_u2d4j6BHR0, "$this$paddingFrom");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return $this$paddingFrom_u2d4j6BHR0.then(new AlignmentLineOffsetDp(alignmentLine, before, after, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AlignmentLineKt$paddingFrom4j6BHR0$$inlined$debugInspectorInfo$1(alignmentLine, before, after) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: paddingFrom-Y_r0B1c$default  reason: not valid java name */
    public static /* synthetic */ Modifier m656paddingFromY_r0B1c$default(Modifier modifier, AlignmentLine alignmentLine, long j, long j2, int i, Object obj) {
        long j3;
        long j4;
        if ((i & 2) != 0) {
            j3 = TextUnit.Companion.m6178getUnspecifiedXSAIIZE();
        } else {
            j3 = j;
        }
        if ((i & 4) != 0) {
            j4 = TextUnit.Companion.m6178getUnspecifiedXSAIIZE();
        } else {
            j4 = j2;
        }
        return m655paddingFromY_r0B1c(modifier, alignmentLine, j3, j4);
    }

    /* renamed from: paddingFrom-Y_r0B1c  reason: not valid java name */
    public static final Modifier m655paddingFromY_r0B1c(Modifier $this$paddingFrom_u2dY_r0B1c, AlignmentLine alignmentLine, long before, long after) {
        Intrinsics.checkNotNullParameter($this$paddingFrom_u2dY_r0B1c, "$this$paddingFrom");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return $this$paddingFrom_u2dY_r0B1c.then(new AlignmentLineOffsetTextUnit(alignmentLine, before, after, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AlignmentLineKt$paddingFromY_r0B1c$$inlined$debugInspectorInfo$1(alignmentLine, before, after) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: paddingFromBaseline-VpY3zN4  reason: not valid java name */
    public static final Modifier m657paddingFromBaselineVpY3zN4(Modifier $this$paddingFromBaseline_u2dVpY3zN4, float top, float bottom) {
        Modifier modifier;
        Modifier modifier2;
        Intrinsics.checkNotNullParameter($this$paddingFromBaseline_u2dVpY3zN4, "$this$paddingFromBaseline");
        if (!Dp.m5991equalsimpl0(top, Dp.Companion.m6006getUnspecifiedD9Ej5fM())) {
            modifier = m654paddingFrom4j6BHR0$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), top, 0.0f, 4, (Object) null);
        } else {
            modifier = Modifier.Companion;
        }
        Modifier then = $this$paddingFromBaseline_u2dVpY3zN4.then(modifier);
        if (!Dp.m5991equalsimpl0(bottom, Dp.Companion.m6006getUnspecifiedD9Ej5fM())) {
            modifier2 = m654paddingFrom4j6BHR0$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, bottom, 2, (Object) null);
        } else {
            modifier2 = Modifier.Companion;
        }
        return then.then(modifier2);
    }

    /* renamed from: paddingFromBaseline-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m658paddingFromBaselineVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        return m657paddingFromBaselineVpY3zN4(modifier, f, f2);
    }

    /* renamed from: paddingFromBaseline-wCyjxdI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m660paddingFromBaselinewCyjxdI$default(Modifier modifier, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = TextUnit.Companion.m6178getUnspecifiedXSAIIZE();
        }
        if ((i & 2) != 0) {
            j2 = TextUnit.Companion.m6178getUnspecifiedXSAIIZE();
        }
        return m659paddingFromBaselinewCyjxdI(modifier, j, j2);
    }

    /* renamed from: paddingFromBaseline-wCyjxdI  reason: not valid java name */
    public static final Modifier m659paddingFromBaselinewCyjxdI(Modifier $this$paddingFromBaseline_u2dwCyjxdI, long top, long bottom) {
        Intrinsics.checkNotNullParameter($this$paddingFromBaseline_u2dwCyjxdI, "$this$paddingFromBaseline");
        return $this$paddingFromBaseline_u2dwCyjxdI.then(!TextUnitKt.m6185isUnspecifiedR2X_6o(top) ? m656paddingFromY_r0B1c$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), top, 0, 4, (Object) null) : Modifier.Companion).then(!TextUnitKt.m6185isUnspecifiedR2X_6o(bottom) ? m656paddingFromY_r0B1c$default(Modifier.Companion, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0, bottom, 2, (Object) null) : Modifier.Companion);
    }

    /* access modifiers changed from: private */
    /* renamed from: alignmentLineOffsetMeasure-tjqqzMA  reason: not valid java name */
    public static final MeasureResult m652alignmentLineOffsetMeasuretjqqzMA(MeasureScope $this$alignmentLineOffsetMeasure_u2dtjqqzMA, AlignmentLine alignmentLine, float before, float after, Measurable measurable, long constraints) {
        long j;
        int width;
        int height;
        MeasureScope measureScope = $this$alignmentLineOffsetMeasure_u2dtjqqzMA;
        float f = before;
        float f2 = after;
        if (getHorizontal(alignmentLine)) {
            j = Constraints.m5921copyZbe2FdA$default(constraints, 0, 0, 0, 0, 11, (Object) null);
        } else {
            j = Constraints.m5921copyZbe2FdA$default(constraints, 0, 0, 0, 0, 14, (Object) null);
        }
        Placeable placeable = measurable.m4863measureBRTryo0(j);
        int it = placeable.get(alignmentLine);
        if (it == Integer.MIN_VALUE) {
            it = 0;
        }
        int linePosition = it;
        int axis = getHorizontal(alignmentLine) ? placeable.getHeight() : placeable.getWidth();
        int axisMax = getHorizontal(alignmentLine) ? Constraints.m5929getMaxHeightimpl(constraints) : Constraints.m5930getMaxWidthimpl(constraints);
        int paddingBefore = RangesKt.coerceIn((!Dp.m5991equalsimpl0(f, Dp.Companion.m6006getUnspecifiedD9Ej5fM()) ? measureScope.m5961roundToPx0680j_4(f) : 0) - linePosition, 0, axisMax - axis);
        int paddingAfter = RangesKt.coerceIn(((!Dp.m5991equalsimpl0(f2, Dp.Companion.m6006getUnspecifiedD9Ej5fM()) ? measureScope.m5961roundToPx0680j_4(f2) : 0) - axis) + linePosition, 0, (axisMax - axis) - paddingBefore);
        if (getHorizontal(alignmentLine)) {
            width = placeable.getWidth();
        } else {
            width = Math.max(paddingBefore + placeable.getWidth() + paddingAfter, Constraints.m5932getMinWidthimpl(constraints));
        }
        if (getHorizontal(alignmentLine)) {
            height = Math.max(paddingBefore + placeable.getHeight() + paddingAfter, Constraints.m5931getMinHeightimpl(constraints));
        } else {
            height = placeable.getHeight();
        }
        Placeable placeable2 = placeable;
        return MeasureScope.layout$default($this$alignmentLineOffsetMeasure_u2dtjqqzMA, width, height, (Map) null, new AlignmentLineKt$alignmentLineOffsetMeasure$1(alignmentLine, before, paddingBefore, width, paddingAfter, placeable, height), 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final boolean getHorizontal(AlignmentLine $this$horizontal) {
        return $this$horizontal instanceof HorizontalAlignmentLine;
    }
}
