package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$TopAppBarLayout$2$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $actionIconsPlaceable;
    final /* synthetic */ long $constraints;
    final /* synthetic */ int $layoutHeight;
    final /* synthetic */ Placeable $navigationIconPlaceable;
    final /* synthetic */ MeasureScope $this_Layout;
    final /* synthetic */ int $titleBaseline;
    final /* synthetic */ int $titleBottomPadding;
    final /* synthetic */ Arrangement.Horizontal $titleHorizontalArrangement;
    final /* synthetic */ Placeable $titlePlaceable;
    final /* synthetic */ Arrangement.Vertical $titleVerticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBarKt$TopAppBarLayout$2$measure$1(Placeable placeable, int i, Placeable placeable2, Arrangement.Horizontal horizontal, long j, Placeable placeable3, MeasureScope measureScope, Arrangement.Vertical vertical, int i2, int i3) {
        super(1);
        this.$navigationIconPlaceable = placeable;
        this.$layoutHeight = i;
        this.$titlePlaceable = placeable2;
        this.$titleHorizontalArrangement = horizontal;
        this.$constraints = j;
        this.$actionIconsPlaceable = placeable3;
        this.$this_Layout = measureScope;
        this.$titleVerticalArrangement = vertical;
        this.$titleBottomPadding = i2;
        this.$titleBaseline = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable placeable = this.$navigationIconPlaceable;
        Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, (this.$layoutHeight - placeable.getHeight()) / 2, 0.0f, 4, (Object) null);
        Placeable placeable2 = this.$titlePlaceable;
        Arrangement.Horizontal horizontal = this.$titleHorizontalArrangement;
        if (Intrinsics.areEqual((Object) horizontal, (Object) Arrangement.INSTANCE.getCenter())) {
            i = (Constraints.m5930getMaxWidthimpl(this.$constraints) - this.$titlePlaceable.getWidth()) / 2;
        } else if (Intrinsics.areEqual((Object) horizontal, (Object) Arrangement.INSTANCE.getEnd())) {
            i = (Constraints.m5930getMaxWidthimpl(this.$constraints) - this.$titlePlaceable.getWidth()) - this.$actionIconsPlaceable.getWidth();
        } else {
            i = Math.max(this.$this_Layout.m5961roundToPx0680j_4(AppBarKt.TopAppBarTitleInset), this.$navigationIconPlaceable.getWidth());
        }
        Arrangement.Vertical vertical = this.$titleVerticalArrangement;
        if (Intrinsics.areEqual((Object) vertical, (Object) Arrangement.INSTANCE.getCenter())) {
            i2 = (this.$layoutHeight - this.$titlePlaceable.getHeight()) / 2;
        } else if (!Intrinsics.areEqual((Object) vertical, (Object) Arrangement.INSTANCE.getBottom())) {
            i2 = 0;
        } else if (this.$titleBottomPadding == 0) {
            i2 = this.$layoutHeight - this.$titlePlaceable.getHeight();
        } else {
            i2 = (this.$layoutHeight - this.$titlePlaceable.getHeight()) - Math.max(0, (this.$titleBottomPadding - this.$titlePlaceable.getHeight()) + this.$titleBaseline);
        }
        Placeable.PlacementScope.placeRelative$default($this$layout, placeable2, i, i2, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default($this$layout, this.$actionIconsPlaceable, Constraints.m5930getMaxWidthimpl(this.$constraints) - this.$actionIconsPlaceable.getWidth(), (this.$layoutHeight - this.$actionIconsPlaceable.getHeight()) / 2, 0.0f, 4, (Object) null);
    }
}
