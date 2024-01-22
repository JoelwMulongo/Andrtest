package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Rect;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BringIntoViewResponder.kt */
final class BringIntoViewResponderModifier$bringChildIntoView$parentRect$1 extends Lambda implements Function0<Rect> {
    final /* synthetic */ Function0<Rect> $boundsProvider;
    final /* synthetic */ LayoutCoordinates $childCoordinates;
    final /* synthetic */ BringIntoViewResponderModifier this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BringIntoViewResponderModifier$bringChildIntoView$parentRect$1(BringIntoViewResponderModifier bringIntoViewResponderModifier, LayoutCoordinates layoutCoordinates, Function0<Rect> function0) {
        super(0);
        this.this$0 = bringIntoViewResponderModifier;
        this.$childCoordinates = layoutCoordinates;
        this.$boundsProvider = function0;
    }

    public final Rect invoke() {
        Rect p0 = BringIntoViewResponderModifier.bringChildIntoView$localRect(this.this$0, this.$childCoordinates, this.$boundsProvider);
        if (p0 != null) {
            return this.this$0.getResponder().calculateRectForParent(p0);
        }
        return null;
    }
}
