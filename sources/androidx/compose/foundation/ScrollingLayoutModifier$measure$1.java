package androidx.compose.foundation;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scroll.kt */
final class ScrollingLayoutModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ int $side;
    final /* synthetic */ ScrollingLayoutModifier this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollingLayoutModifier$measure$1(ScrollingLayoutModifier scrollingLayoutModifier, int i, Placeable placeable) {
        super(1);
        this.this$0 = scrollingLayoutModifier;
        this.$side = i;
        this.$placeable = placeable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        int scroll = RangesKt.coerceIn(this.this$0.getScrollerState().getValue(), 0, this.$side);
        int absScroll = this.this$0.isReversed() ? scroll - this.$side : -scroll;
        Placeable.PlacementScope.placeRelativeWithLayer$default($this$layout, this.$placeable, this.this$0.isVertical() ? 0 : absScroll, this.this$0.isVertical() ? absScroll : 0, 0.0f, (Function1) null, 12, (Object) null);
    }
}
