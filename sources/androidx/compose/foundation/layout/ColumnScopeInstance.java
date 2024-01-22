package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.SiblingsAlignedModifier;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J \u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0017J\u0014\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0017J\u001c\u0010\u000e\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0017¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/layout/ColumnScopeInstance;", "Landroidx/compose/foundation/layout/ColumnScope;", "()V", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "alignBy", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "alignmentLine", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "weight", "", "fill", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Column.kt */
public final class ColumnScopeInstance implements ColumnScope {
    public static final ColumnScopeInstance INSTANCE = new ColumnScopeInstance();

    private ColumnScopeInstance() {
    }

    public Modifier weight(Modifier $this$weight, float weight, boolean fill) {
        Intrinsics.checkNotNullParameter($this$weight, "<this>");
        if (((double) weight) > 0.0d) {
            return $this$weight.then(new LayoutWeightImpl(weight, fill, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ColumnScopeInstance$weight$$inlined$debugInspectorInfo$1(weight, fill) : InspectableValueKt.getNoInspectorInfo()));
        }
        throw new IllegalArgumentException(("invalid weight " + weight + "; must be greater than zero").toString());
    }

    public Modifier align(Modifier $this$align, Alignment.Horizontal alignment) {
        Intrinsics.checkNotNullParameter($this$align, "<this>");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return $this$align.then(new HorizontalAlignModifier(alignment, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ColumnScopeInstance$align$$inlined$debugInspectorInfo$1(alignment) : InspectableValueKt.getNoInspectorInfo()));
    }

    public Modifier alignBy(Modifier $this$alignBy, VerticalAlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter($this$alignBy, "<this>");
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return $this$alignBy.then(new SiblingsAlignedModifier.WithAlignmentLine(alignmentLine, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ColumnScopeInstance$alignBy$$inlined$debugInspectorInfo$1(alignmentLine) : InspectableValueKt.getNoInspectorInfo()));
    }

    public Modifier alignBy(Modifier $this$alignBy, Function1<? super Measured, Integer> alignmentLineBlock) {
        Intrinsics.checkNotNullParameter($this$alignBy, "<this>");
        Intrinsics.checkNotNullParameter(alignmentLineBlock, "alignmentLineBlock");
        return $this$alignBy.then(new SiblingsAlignedModifier.WithAlignmentLineBlock(alignmentLineBlock, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ColumnScopeInstance$alignBy$$inlined$debugInspectorInfo$2(alignmentLineBlock) : InspectableValueKt.getNoInspectorInfo()));
    }
}
