package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeLayoutDelegate.kt */
final class LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LookaheadDelegate $lookaheadDelegate;
    final /* synthetic */ LayoutNodeLayoutDelegate.LookaheadPassDelegate this$0;
    final /* synthetic */ LayoutNodeLayoutDelegate this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1(LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate, LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, LookaheadDelegate lookaheadDelegate) {
        super(0);
        this.this$0 = lookaheadPassDelegate;
        this.this$1 = layoutNodeLayoutDelegate;
        this.$lookaheadDelegate = lookaheadDelegate;
    }

    public final void invoke() {
        MutableVector this_$iv$iv$iv = this.this$0.this$0.layoutNode.get_children$ui_release();
        int size$iv$iv$iv = this_$iv$iv$iv.getSize();
        if (size$iv$iv$iv > 0) {
            int i$iv$iv$iv = 0;
            Object[] content$iv$iv$iv = this_$iv$iv$iv.getContent();
            do {
                LayoutNodeLayoutDelegate.LookaheadPassDelegate it = ((LayoutNode) content$iv$iv$iv[i$iv$iv$iv]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(it);
                it.isPreviouslyPlaced = it.isPlaced();
                it.setPlaced(false);
                i$iv$iv$iv++;
            } while (i$iv$iv$iv < size$iv$iv$iv);
        }
        MutableVector this_$iv$iv = this.this$1.layoutNode.get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                LayoutNode it2 = (LayoutNode) content$iv$iv[i$iv$iv];
                if (it2.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                    it2.setMeasuredByParentInLookahead$ui_release(LayoutNode.UsageByParent.NotUsed);
                }
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
        this.this$0.forEachChildAlignmentLinesOwner(AnonymousClass3.INSTANCE);
        this.$lookaheadDelegate.getMeasureResult$ui_release().placeChildren();
        this.this$0.forEachChildAlignmentLinesOwner(AnonymousClass4.INSTANCE);
        MutableVector this_$iv$iv$iv2 = this.this$0.this$0.layoutNode.get_children$ui_release();
        int size$iv$iv$iv2 = this_$iv$iv$iv2.getSize();
        if (size$iv$iv$iv2 > 0) {
            int i$iv$iv$iv2 = 0;
            Object[] content$iv$iv$iv2 = this_$iv$iv$iv2.getContent();
            do {
                LayoutNodeLayoutDelegate.LookaheadPassDelegate it3 = ((LayoutNode) content$iv$iv$iv2[i$iv$iv$iv2]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(it3);
                if (!it3.isPlaced()) {
                    it3.markSubtreeNotPlaced();
                }
                i$iv$iv$iv2++;
            } while (i$iv$iv$iv2 < size$iv$iv$iv2);
        }
    }
}
