package androidx.compose.foundation.lazy;

import androidx.compose.runtime.State;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BJ\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0018\u001a\u00020\fH\u0016J)\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"Landroidx/compose/foundation/lazy/ParentSizeModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "fraction", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "widthState", "Landroidx/compose/runtime/State;", "", "heightState", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;)V", "getFraction", "()F", "getHeightState", "()Landroidx/compose/runtime/State;", "getWidthState", "equals", "", "other", "", "hashCode", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyItemScopeImpl.kt */
final class ParentSizeModifier extends InspectorValueInfo implements LayoutModifier {
    private final float fraction;
    private final State<Integer> heightState;
    private final State<Integer> widthState;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParentSizeModifier(float f, Function1 function1, State state, State state2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, function1, (i & 4) != 0 ? null : state, (i & 8) != 0 ? null : state2);
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final State<Integer> getWidthState() {
        return this.widthState;
    }

    public final State<Integer> getHeightState() {
        return this.heightState;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ParentSizeModifier(float fraction2, Function1<? super InspectorInfo, Unit> inspectorInfo, State<Integer> widthState2, State<Integer> heightState2) {
        super(inspectorInfo);
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.fraction = fraction2;
        this.widthState = widthState2;
        this.heightState = heightState2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m920measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        int width;
        int i;
        Measurable measurable2 = measurable;
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable2, "measurable");
        State<Integer> state = this.widthState;
        if (state == null || state.getValue().intValue() == Integer.MAX_VALUE) {
            width = Integer.MAX_VALUE;
        } else {
            width = MathKt.roundToInt(this.widthState.getValue().floatValue() * this.fraction);
        }
        State<Integer> state2 = this.heightState;
        if (state2 == null || state2.getValue().intValue() == Integer.MAX_VALUE) {
            i = Integer.MAX_VALUE;
        } else {
            i = MathKt.roundToInt(this.heightState.getValue().floatValue() * this.fraction);
        }
        int height = i;
        Placeable placeable = measurable2.m4863measureBRTryo0(ConstraintsKt.Constraints(width != Integer.MAX_VALUE ? width : Constraints.m5932getMinWidthimpl(constraints), width != Integer.MAX_VALUE ? width : Constraints.m5930getMaxWidthimpl(constraints), height != Integer.MAX_VALUE ? height : Constraints.m5931getMinHeightimpl(constraints), height != Integer.MAX_VALUE ? height : Constraints.m5929getMaxHeightimpl(constraints)));
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, placeable.getWidth(), placeable.getHeight(), (Map) null, new ParentSizeModifier$measure$1(placeable), 4, (Object) null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ParentSizeModifier)) {
            return false;
        }
        if (Intrinsics.areEqual((Object) this.widthState, (Object) ((ParentSizeModifier) other).widthState) && Intrinsics.areEqual((Object) this.heightState, (Object) ((ParentSizeModifier) other).heightState)) {
            if (this.fraction == ((ParentSizeModifier) other).fraction) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        State<Integer> state = this.widthState;
        int i = 0;
        int hashCode = (state != null ? state.hashCode() : 0) * 31;
        State<Integer> state2 = this.heightState;
        if (state2 != null) {
            i = state2.hashCode();
        }
        return ((hashCode + i) * 31) + Float.hashCode(this.fraction);
    }
}
