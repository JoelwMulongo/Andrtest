package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BQ\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u001c\u0010 \u001a\u00020\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001aH\u0016J)\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0012H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u001c\u0010)\u001a\u00020\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u001c\u0010*\u001a\u00020\u001a*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u001aH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\u0006\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0010R!\u0010\u0011\u001a\u00020\u0012*\u00020\u00138BX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/foundation/layout/SizeModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "equals", "other", "", "hashCode", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
final class SizeModifier extends InspectorValueInfo implements LayoutModifier {
    private final boolean enforceIncoming;
    private final float maxHeight;
    private final float maxWidth;
    private final float minHeight;
    private final float minWidth;

    public /* synthetic */ SizeModifier(float f, float f2, float f3, float f4, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z, function1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SizeModifier(float r10, float r11, float r12, float r13, boolean r14, kotlin.jvm.functions.Function1 r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 1
            if (r0 == 0) goto L_0x000c
            androidx.compose.ui.unit.Dp$Companion r0 = androidx.compose.ui.unit.Dp.Companion
            float r0 = r0.m6006getUnspecifiedD9Ej5fM()
            r2 = r0
            goto L_0x000d
        L_0x000c:
            r2 = r10
        L_0x000d:
            r0 = r16 & 2
            if (r0 == 0) goto L_0x0019
            androidx.compose.ui.unit.Dp$Companion r0 = androidx.compose.ui.unit.Dp.Companion
            float r0 = r0.m6006getUnspecifiedD9Ej5fM()
            r3 = r0
            goto L_0x001a
        L_0x0019:
            r3 = r11
        L_0x001a:
            r0 = r16 & 4
            if (r0 == 0) goto L_0x0026
            androidx.compose.ui.unit.Dp$Companion r0 = androidx.compose.ui.unit.Dp.Companion
            float r0 = r0.m6006getUnspecifiedD9Ej5fM()
            r4 = r0
            goto L_0x0027
        L_0x0026:
            r4 = r12
        L_0x0027:
            r0 = r16 & 8
            if (r0 == 0) goto L_0x0033
            androidx.compose.ui.unit.Dp$Companion r0 = androidx.compose.ui.unit.Dp.Companion
            float r0 = r0.m6006getUnspecifiedD9Ej5fM()
            r5 = r0
            goto L_0x0034
        L_0x0033:
            r5 = r13
        L_0x0034:
            r8 = 0
            r1 = r9
            r6 = r14
            r7 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.SizeModifier.<init>(float, float, float, float, boolean, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private SizeModifier(float minWidth2, float minHeight2, float maxWidth2, float maxHeight2, boolean enforceIncoming2, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        this.minWidth = minWidth2;
        this.minHeight = minHeight2;
        this.maxWidth = maxWidth2;
        this.maxHeight = maxHeight2;
        this.enforceIncoming = enforceIncoming2;
    }

    /* renamed from: getTargetConstraints-OenEA2s  reason: not valid java name */
    private final long m841getTargetConstraintsOenEA2s(Density $this$targetConstraints) {
        int maxWidth2;
        int maxHeight2;
        int it;
        int it2;
        if (!Dp.m5991equalsimpl0(this.maxWidth, Dp.Companion.m6006getUnspecifiedD9Ej5fM())) {
            maxWidth2 = $this$targetConstraints.m5961roundToPx0680j_4(((Dp) RangesKt.coerceAtLeast(Dp.m5984boximpl(this.maxWidth), Dp.m5984boximpl(Dp.m5986constructorimpl((float) 0)))).m6000unboximpl());
        } else {
            maxWidth2 = Integer.MAX_VALUE;
        }
        if (!Dp.m5991equalsimpl0(this.maxHeight, Dp.Companion.m6006getUnspecifiedD9Ej5fM())) {
            maxHeight2 = $this$targetConstraints.m5961roundToPx0680j_4(((Dp) RangesKt.coerceAtLeast(Dp.m5984boximpl(this.maxHeight), Dp.m5984boximpl(Dp.m5986constructorimpl((float) 0)))).m6000unboximpl());
        } else {
            maxHeight2 = Integer.MAX_VALUE;
        }
        int minHeight2 = 0;
        if (!Dp.m5991equalsimpl0(this.minWidth, Dp.Companion.m6006getUnspecifiedD9Ej5fM())) {
            it = RangesKt.coerceAtLeast(RangesKt.coerceAtMost($this$targetConstraints.m5961roundToPx0680j_4(this.minWidth), maxWidth2), 0);
            if (it == Integer.MAX_VALUE) {
                it = 0;
            }
        } else {
            it = 0;
        }
        if (!Dp.m5991equalsimpl0(this.minHeight, Dp.Companion.m6006getUnspecifiedD9Ej5fM()) && (it2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost($this$targetConstraints.m5961roundToPx0680j_4(this.minHeight), maxHeight2), 0)) != Integer.MAX_VALUE) {
            minHeight2 = it2;
        }
        return ConstraintsKt.Constraints(it, maxWidth2, minHeight2, maxHeight2);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m842measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        long targetConstraints;
        int resolvedMinWidth;
        int resolvedMaxWidth;
        int resolvedMinHeight;
        int resolvedMaxHeight;
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long targetConstraints2 = m841getTargetConstraintsOenEA2s($this$measure_u2d3p2s80s);
        if (this.enforceIncoming) {
            targetConstraints = ConstraintsKt.m5942constrainN9IONVI(constraints, targetConstraints2);
        } else {
            if (!Dp.m5991equalsimpl0(this.minWidth, Dp.Companion.m6006getUnspecifiedD9Ej5fM())) {
                resolvedMinWidth = Constraints.m5932getMinWidthimpl(targetConstraints2);
            } else {
                resolvedMinWidth = RangesKt.coerceAtMost(Constraints.m5932getMinWidthimpl(constraints), Constraints.m5930getMaxWidthimpl(targetConstraints2));
            }
            if (!Dp.m5991equalsimpl0(this.maxWidth, Dp.Companion.m6006getUnspecifiedD9Ej5fM())) {
                resolvedMaxWidth = Constraints.m5930getMaxWidthimpl(targetConstraints2);
            } else {
                resolvedMaxWidth = RangesKt.coerceAtLeast(Constraints.m5930getMaxWidthimpl(constraints), Constraints.m5932getMinWidthimpl(targetConstraints2));
            }
            if (!Dp.m5991equalsimpl0(this.minHeight, Dp.Companion.m6006getUnspecifiedD9Ej5fM())) {
                resolvedMinHeight = Constraints.m5931getMinHeightimpl(targetConstraints2);
            } else {
                resolvedMinHeight = RangesKt.coerceAtMost(Constraints.m5931getMinHeightimpl(constraints), Constraints.m5929getMaxHeightimpl(targetConstraints2));
            }
            if (!Dp.m5991equalsimpl0(this.maxHeight, Dp.Companion.m6006getUnspecifiedD9Ej5fM())) {
                resolvedMaxHeight = Constraints.m5929getMaxHeightimpl(targetConstraints2);
            } else {
                resolvedMaxHeight = RangesKt.coerceAtLeast(Constraints.m5929getMaxHeightimpl(constraints), Constraints.m5931getMinHeightimpl(targetConstraints2));
            }
            targetConstraints = ConstraintsKt.Constraints(resolvedMinWidth, resolvedMaxWidth, resolvedMinHeight, resolvedMaxHeight);
        }
        Placeable placeable = measurable.m4863measureBRTryo0(targetConstraints);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, placeable.getWidth(), placeable.getHeight(), (Map) null, new SizeModifier$measure$1(placeable), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long constraints = m841getTargetConstraintsOenEA2s($this$minIntrinsicWidth);
        if (Constraints.m5928getHasFixedWidthimpl(constraints)) {
            return Constraints.m5930getMaxWidthimpl(constraints);
        }
        return ConstraintsKt.m5944constrainWidthK40F9xA(constraints, measurable.minIntrinsicWidth(height));
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long constraints = m841getTargetConstraintsOenEA2s($this$minIntrinsicHeight);
        if (Constraints.m5927getHasFixedHeightimpl(constraints)) {
            return Constraints.m5929getMaxHeightimpl(constraints);
        }
        return ConstraintsKt.m5943constrainHeightK40F9xA(constraints, measurable.minIntrinsicHeight(width));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long constraints = m841getTargetConstraintsOenEA2s($this$maxIntrinsicWidth);
        if (Constraints.m5928getHasFixedWidthimpl(constraints)) {
            return Constraints.m5930getMaxWidthimpl(constraints);
        }
        return ConstraintsKt.m5944constrainWidthK40F9xA(constraints, measurable.maxIntrinsicWidth(height));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long constraints = m841getTargetConstraintsOenEA2s($this$maxIntrinsicHeight);
        if (Constraints.m5927getHasFixedHeightimpl(constraints)) {
            return Constraints.m5929getMaxHeightimpl(constraints);
        }
        return ConstraintsKt.m5943constrainHeightK40F9xA(constraints, measurable.maxIntrinsicHeight(width));
    }

    public boolean equals(Object other) {
        if ((other instanceof SizeModifier) && Dp.m5991equalsimpl0(this.minWidth, ((SizeModifier) other).minWidth) && Dp.m5991equalsimpl0(this.minHeight, ((SizeModifier) other).minHeight) && Dp.m5991equalsimpl0(this.maxWidth, ((SizeModifier) other).maxWidth) && Dp.m5991equalsimpl0(this.maxHeight, ((SizeModifier) other).maxHeight) && this.enforceIncoming == ((SizeModifier) other).enforceIncoming) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((Dp.m5992hashCodeimpl(this.minWidth) * 31) + Dp.m5992hashCodeimpl(this.minHeight)) * 31) + Dp.m5992hashCodeimpl(this.maxWidth)) * 31) + Dp.m5992hashCodeimpl(this.maxHeight)) * 31;
    }
}
