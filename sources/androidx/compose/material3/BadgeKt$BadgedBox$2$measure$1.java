package androidx.compose.material3;

import androidx.compose.material3.tokens.BadgeTokens;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Badge.kt */
final class BadgeKt$BadgedBox$2$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $anchorPlaceable;
    final /* synthetic */ Placeable $badgePlaceable;
    final /* synthetic */ MeasureScope $this_Layout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BadgeKt$BadgedBox$2$measure$1(Placeable placeable, MeasureScope measureScope, Placeable placeable2) {
        super(1);
        this.$badgePlaceable = placeable;
        this.$this_Layout = measureScope;
        this.$anchorPlaceable = placeable2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        boolean hasContent = this.$badgePlaceable.getWidth() > this.$this_Layout.m5961roundToPx0680j_4(BadgeTokens.INSTANCE.m2272getSizeD9Ej5fM());
        float badgeHorizontalOffset = hasContent ? BadgeKt.getBadgeWithContentHorizontalOffset() : BadgeKt.getBadgeOffset();
        float badgeVerticalOffset = hasContent ? BadgeKt.getBadgeWithContentVerticalOffset() : BadgeKt.getBadgeOffset();
        Placeable.PlacementScope.placeRelative$default($this$layout, this.$anchorPlaceable, 0, 0, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default($this$layout, this.$badgePlaceable, this.$anchorPlaceable.getWidth() + this.$this_Layout.m5961roundToPx0680j_4(badgeHorizontalOffset), ((-this.$badgePlaceable.getHeight()) / 2) + this.$this_Layout.m5961roundToPx0680j_4(badgeVerticalOffset), 0.0f, 4, (Object) null);
    }
}
