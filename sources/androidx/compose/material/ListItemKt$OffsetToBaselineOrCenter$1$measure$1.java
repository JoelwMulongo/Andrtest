package androidx.compose.material;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemKt$OffsetToBaselineOrCenter$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ int $y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ListItemKt$OffsetToBaselineOrCenter$1$measure$1(Placeable placeable, int i) {
        super(1);
        this.$placeable = placeable;
        this.$y = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable.PlacementScope.placeRelative$default($this$layout, this.$placeable, 0, this.$y, 0.0f, 4, (Object) null);
    }
}
