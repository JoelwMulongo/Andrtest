package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.layout.PaddingKt$padding-qDBjuR0$$inlined$debugInspectorInfo$1  reason: invalid class name */
/* compiled from: InspectableValue.kt */
public final class PaddingKt$paddingqDBjuR0$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ float $bottom$inlined;
    final /* synthetic */ float $end$inlined;
    final /* synthetic */ float $start$inlined;
    final /* synthetic */ float $top$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaddingKt$paddingqDBjuR0$$inlined$debugInspectorInfo$1(float f, float f2, float f3, float f4) {
        super(1);
        this.$start$inlined = f;
        this.$top$inlined = f2;
        this.$end$inlined = f3;
        this.$bottom$inlined = f4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((InspectorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        InspectorInfo $this$padding_qDBjuR0_u24lambda_u240 = $this$null;
        $this$padding_qDBjuR0_u24lambda_u240.setName("padding");
        $this$padding_qDBjuR0_u24lambda_u240.getProperties().set("start", Dp.m5984boximpl(this.$start$inlined));
        $this$padding_qDBjuR0_u24lambda_u240.getProperties().set("top", Dp.m5984boximpl(this.$top$inlined));
        $this$padding_qDBjuR0_u24lambda_u240.getProperties().set("end", Dp.m5984boximpl(this.$end$inlined));
        $this$padding_qDBjuR0_u24lambda_u240.getProperties().set("bottom", Dp.m5984boximpl(this.$bottom$inlined));
    }
}
