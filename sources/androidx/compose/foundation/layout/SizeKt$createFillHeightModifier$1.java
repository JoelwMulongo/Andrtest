package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
final class SizeKt$createFillHeightModifier$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ float $fraction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SizeKt$createFillHeightModifier$1(float f) {
        super(1);
        this.$fraction = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((InspectorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo $this$$receiver) {
        Intrinsics.checkNotNullParameter($this$$receiver, "$this$$receiver");
        $this$$receiver.setName("fillMaxHeight");
        $this$$receiver.getProperties().set("fraction", Float.valueOf(this.$fraction));
    }
}
