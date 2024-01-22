package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0001¨\u0006\u0006"}, d2 = {"invalidateLayer", "", "Landroidx/compose/ui/node/LayoutModifierNode;", "invalidateLayout", "invalidateMeasurements", "requestRemeasure", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutModifierNode.kt */
public final class LayoutModifierNodeKt {
    public static final void invalidateLayer(LayoutModifierNode $this$invalidateLayer) {
        Intrinsics.checkNotNullParameter($this$invalidateLayer, "<this>");
        DelegatableNodeKt.m4965requireCoordinator64DMado($this$invalidateLayer, NodeKind.m5123constructorimpl(2)).invalidateLayer();
    }

    public static final void invalidateLayout(LayoutModifierNode $this$invalidateLayout) {
        Intrinsics.checkNotNullParameter($this$invalidateLayout, "<this>");
        LayoutNode.requestRelayout$ui_release$default(DelegatableNodeKt.requireLayoutNode($this$invalidateLayout), false, 1, (Object) null);
    }

    public static final void invalidateMeasurements(LayoutModifierNode $this$invalidateMeasurements) {
        Intrinsics.checkNotNullParameter($this$invalidateMeasurements, "<this>");
        DelegatableNodeKt.requireLayoutNode($this$invalidateMeasurements).invalidateMeasurements$ui_release();
    }

    public static final void requestRemeasure(LayoutModifierNode $this$requestRemeasure) {
        Intrinsics.checkNotNullParameter($this$requestRemeasure, "<this>");
        LayoutNode.requestRemeasure$ui_release$default(DelegatableNodeKt.requireLayoutNode($this$requestRemeasure), false, 1, (Object) null);
    }
}
