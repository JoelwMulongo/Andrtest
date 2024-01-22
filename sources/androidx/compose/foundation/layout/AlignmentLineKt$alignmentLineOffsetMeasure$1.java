package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlignmentLine.kt */
final class AlignmentLineKt$alignmentLineOffsetMeasure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ AlignmentLine $alignmentLine;
    final /* synthetic */ float $before;
    final /* synthetic */ int $height;
    final /* synthetic */ int $paddingAfter;
    final /* synthetic */ int $paddingBefore;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ int $width;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlignmentLineKt$alignmentLineOffsetMeasure$1(AlignmentLine alignmentLine, float f, int i, int i2, int i3, Placeable placeable, int i4) {
        super(1);
        this.$alignmentLine = alignmentLine;
        this.$before = f;
        this.$paddingBefore = i;
        this.$width = i2;
        this.$paddingAfter = i3;
        this.$placeable = placeable;
        this.$height = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        int x;
        int y;
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        if (AlignmentLineKt.getHorizontal(this.$alignmentLine)) {
            x = 0;
        } else if (!Dp.m5991equalsimpl0(this.$before, Dp.Companion.m6006getUnspecifiedD9Ej5fM())) {
            x = this.$paddingBefore;
        } else {
            x = (this.$width - this.$paddingAfter) - this.$placeable.getWidth();
        }
        if (!AlignmentLineKt.getHorizontal(this.$alignmentLine)) {
            y = 0;
        } else if (!Dp.m5991equalsimpl0(this.$before, Dp.Companion.m6006getUnspecifiedD9Ej5fM())) {
            y = this.$paddingBefore;
        } else {
            y = (this.$height - this.$paddingAfter) - this.$placeable.getHeight();
        }
        Placeable.PlacementScope.placeRelative$default($this$layout, this.$placeable, x, y, 0.0f, 4, (Object) null);
    }
}
