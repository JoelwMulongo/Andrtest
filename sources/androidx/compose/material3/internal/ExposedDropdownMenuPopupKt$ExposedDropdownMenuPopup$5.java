package androidx.compose.material3.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRectKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExposedDropdownMenuPopup.kt */
final class ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$5 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ PopupLayout $popupLayout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuPopupKt$ExposedDropdownMenuPopup$5(PopupLayout popupLayout) {
        super(1);
        this.$popupLayout = popupLayout;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((LayoutCoordinates) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutCoordinates childCoordinates) {
        Intrinsics.checkNotNullParameter(childCoordinates, "childCoordinates");
        LayoutCoordinates coordinates = childCoordinates.getParentLayoutCoordinates();
        Intrinsics.checkNotNull(coordinates);
        long layoutSize = coordinates.m4839getSizeYbymL2g();
        long position = LayoutCoordinatesKt.positionInWindow(coordinates);
        this.$popupLayout.setParentBounds(IntRectKt.m6136IntRectVbeCjmY(IntOffsetKt.IntOffset(MathKt.roundToInt(Offset.m2915getXimpl(position)), MathKt.roundToInt(Offset.m2916getYimpl(position))), layoutSize));
        this.$popupLayout.updatePosition();
    }
}
