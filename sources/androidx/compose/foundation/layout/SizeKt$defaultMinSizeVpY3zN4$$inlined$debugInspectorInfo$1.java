package androidx.compose.foundation.layout;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.layout.SizeKt$defaultMinSize-VpY3zN4$$inlined$debugInspectorInfo$1  reason: invalid class name */
/* compiled from: InspectableValue.kt */
public final class SizeKt$defaultMinSizeVpY3zN4$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ float $minHeight$inlined;
    final /* synthetic */ float $minWidth$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SizeKt$defaultMinSizeVpY3zN4$$inlined$debugInspectorInfo$1(float f, float f2) {
        super(1);
        this.$minWidth$inlined = f;
        this.$minHeight$inlined = f2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((InspectorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        InspectorInfo $this$defaultMinSize_VpY3zN4_u24lambda_u2414 = $this$null;
        $this$defaultMinSize_VpY3zN4_u24lambda_u2414.setName("defaultMinSize");
        $this$defaultMinSize_VpY3zN4_u24lambda_u2414.getProperties().set("minWidth", Dp.m5984boximpl(this.$minWidth$inlined));
        $this$defaultMinSize_VpY3zN4_u24lambda_u2414.getProperties().set("minHeight", Dp.m5984boximpl(this.$minHeight$inlined));
    }
}
