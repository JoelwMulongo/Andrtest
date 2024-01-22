package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "childOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeAlignmentLines.kt */
final class AlignmentLines$recalculate$1 extends Lambda implements Function1<AlignmentLinesOwner, Unit> {
    final /* synthetic */ AlignmentLines this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlignmentLines$recalculate$1(AlignmentLines alignmentLines) {
        super(1);
        this.this$0 = alignmentLines;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((AlignmentLinesOwner) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(AlignmentLinesOwner childOwner) {
        Intrinsics.checkNotNullParameter(childOwner, "childOwner");
        if (childOwner.isPlaced()) {
            if (childOwner.getAlignmentLines().getDirty$ui_release()) {
                childOwner.layoutChildren();
            }
            Map $this$forEach$iv = childOwner.getAlignmentLines().alignmentLineMap;
            AlignmentLines alignmentLines = this.this$0;
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                alignmentLines.addAlignmentLine((AlignmentLine) element$iv.getKey(), ((Number) element$iv.getValue()).intValue(), childOwner.getInnerCoordinator());
            }
            NodeCoordinator wrappedBy$ui_release = childOwner.getInnerCoordinator().getWrappedBy$ui_release();
            Intrinsics.checkNotNull(wrappedBy$ui_release);
            while (true) {
                NodeCoordinator nodeCoordinator = wrappedBy$ui_release;
                if (!Intrinsics.areEqual((Object) nodeCoordinator, (Object) this.this$0.getAlignmentLinesOwner().getInnerCoordinator())) {
                    AlignmentLines alignmentLines2 = this.this$0;
                    for (AlignmentLine childLine : this.this$0.getAlignmentLinesMap(nodeCoordinator).keySet()) {
                        alignmentLines2.addAlignmentLine(childLine, alignmentLines2.getPositionFor(nodeCoordinator, childLine), nodeCoordinator);
                    }
                    wrappedBy$ui_release = nodeCoordinator.getWrappedBy$ui_release();
                    Intrinsics.checkNotNull(wrappedBy$ui_release);
                } else {
                    return;
                }
            }
        }
    }
}
