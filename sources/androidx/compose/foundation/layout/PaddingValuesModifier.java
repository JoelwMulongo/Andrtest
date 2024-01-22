package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B&\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J)\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function1;)V", "getPaddingValues", "()Landroidx/compose/foundation/layout/PaddingValues;", "equals", "", "other", "", "hashCode", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Padding.kt */
final class PaddingValuesModifier extends InspectorValueInfo implements LayoutModifier {
    private final PaddingValues paddingValues;

    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaddingValuesModifier(PaddingValues paddingValues2, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        Intrinsics.checkNotNullParameter(paddingValues2, "paddingValues");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.paddingValues = paddingValues2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m794measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        MeasureScope measureScope = $this$measure_u2d3p2s80s;
        Measurable measurable2 = measurable;
        long j = constraints;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable2, "measurable");
        if (Dp.m5985compareTo0680j_4(this.paddingValues.m771calculateLeftPaddingu2uoSUM($this$measure_u2d3p2s80s.getLayoutDirection()), Dp.m5986constructorimpl((float) 0)) >= 0 && Dp.m5985compareTo0680j_4(this.paddingValues.m773calculateTopPaddingD9Ej5fM(), Dp.m5986constructorimpl((float) 0)) >= 0 && Dp.m5985compareTo0680j_4(this.paddingValues.m772calculateRightPaddingu2uoSUM($this$measure_u2d3p2s80s.getLayoutDirection()), Dp.m5986constructorimpl((float) 0)) >= 0 && Dp.m5985compareTo0680j_4(this.paddingValues.m770calculateBottomPaddingD9Ej5fM(), Dp.m5986constructorimpl((float) 0)) >= 0) {
            int horizontal = measureScope.m5961roundToPx0680j_4(this.paddingValues.m771calculateLeftPaddingu2uoSUM($this$measure_u2d3p2s80s.getLayoutDirection())) + measureScope.m5961roundToPx0680j_4(this.paddingValues.m772calculateRightPaddingu2uoSUM($this$measure_u2d3p2s80s.getLayoutDirection()));
            int vertical = measureScope.m5961roundToPx0680j_4(this.paddingValues.m773calculateTopPaddingD9Ej5fM()) + measureScope.m5961roundToPx0680j_4(this.paddingValues.m770calculateBottomPaddingD9Ej5fM());
            Placeable placeable = measurable2.m4863measureBRTryo0(ConstraintsKt.m5946offsetNN6EwU(j, -horizontal, -vertical));
            return MeasureScope.layout$default($this$measure_u2d3p2s80s, ConstraintsKt.m5944constrainWidthK40F9xA(j, placeable.getWidth() + horizontal), ConstraintsKt.m5943constrainHeightK40F9xA(j, placeable.getHeight() + vertical), (Map) null, new PaddingValuesModifier$measure$2(placeable, measureScope, this), 4, (Object) null);
        }
        throw new IllegalArgumentException("Padding must be non-negative".toString());
    }

    public int hashCode() {
        return this.paddingValues.hashCode();
    }

    public boolean equals(Object other) {
        PaddingValuesModifier otherModifier = other instanceof PaddingValuesModifier ? (PaddingValuesModifier) other : null;
        if (otherModifier == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.paddingValues, (Object) otherModifier.paddingValues);
    }
}
