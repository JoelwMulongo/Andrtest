package androidx.compose.material3;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$SliderImpl$2$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ int $thumbOffsetX;
    final /* synthetic */ int $thumbOffsetY;
    final /* synthetic */ Placeable $thumbPlaceable;
    final /* synthetic */ int $trackOffsetX;
    final /* synthetic */ int $trackOffsetY;
    final /* synthetic */ Placeable $trackPlaceable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$SliderImpl$2$measure$1(Placeable placeable, int i, int i2, Placeable placeable2, int i3, int i4) {
        super(1);
        this.$trackPlaceable = placeable;
        this.$trackOffsetX = i;
        this.$trackOffsetY = i2;
        this.$thumbPlaceable = placeable2;
        this.$thumbOffsetX = i3;
        this.$thumbOffsetY = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable.PlacementScope placementScope = $this$layout;
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$trackPlaceable, this.$trackOffsetX, this.$trackOffsetY, 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$thumbPlaceable, this.$thumbOffsetX, this.$thumbOffsetY, 0.0f, 4, (Object) null);
    }
}
