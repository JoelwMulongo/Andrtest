package androidx.compose.ui.window;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPopup.android.kt */
final class AndroidPopup_androidKt$Popup$8$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    public static final AndroidPopup_androidKt$Popup$8$measure$1 INSTANCE = new AndroidPopup_androidKt$Popup$8$measure$1();

    AndroidPopup_androidKt$Popup$8$measure$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Placeable.PlacementScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
    }
}
