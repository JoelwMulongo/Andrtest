package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/node/LayoutNode;", "it", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
final class SubcomposeLayoutState$setRoot$1 extends Lambda implements Function2<LayoutNode, SubcomposeLayoutState, Unit> {
    final /* synthetic */ SubcomposeLayoutState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubcomposeLayoutState$setRoot$1(SubcomposeLayoutState subcomposeLayoutState) {
        super(2);
        this.this$0 = subcomposeLayoutState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((LayoutNode) p1, (SubcomposeLayoutState) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutNode $this$null, SubcomposeLayoutState it) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        Intrinsics.checkNotNullParameter(it, "it");
        SubcomposeLayoutState subcomposeLayoutState = this.this$0;
        LayoutNodeSubcompositionsState it2 = $this$null.getSubcompositionsState$ui_release();
        if (it2 == null) {
            it2 = new LayoutNodeSubcompositionsState($this$null, this.this$0.slotReusePolicy);
            $this$null.setSubcompositionsState$ui_release(it2);
        }
        subcomposeLayoutState._state = it2;
        this.this$0.getState().makeSureStateIsConsistent();
        this.this$0.getState().setSlotReusePolicy(this.this$0.slotReusePolicy);
    }
}
