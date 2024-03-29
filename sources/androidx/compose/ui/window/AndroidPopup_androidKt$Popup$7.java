package androidx.compose.ui.window;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
final class AndroidPopup_androidKt$Popup$7 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ PopupLayout $popupLayout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidPopup_androidKt$Popup$7(PopupLayout popupLayout) {
        super(1);
        this.$popupLayout = popupLayout;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((LayoutCoordinates) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutCoordinates childCoordinates) {
        Intrinsics.checkNotNullParameter(childCoordinates, "childCoordinates");
        LayoutCoordinates parentCoordinates = childCoordinates.getParentLayoutCoordinates();
        Intrinsics.checkNotNull(parentCoordinates);
        this.$popupLayout.updateParentLayoutCoordinates(parentCoordinates);
    }
}
