package androidx.compose.ui.layout;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class LookaheadLayoutScopeImpl$onPlaced$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ Function2 $onPlaced$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LookaheadLayoutScopeImpl$onPlaced$$inlined$debugInspectorInfo$1(Function2 function2) {
        super(1);
        this.$onPlaced$inlined = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((InspectorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        InspectorInfo $this$onPlaced_u24lambda_u240 = $this$null;
        $this$onPlaced_u24lambda_u240.setName("onPlaced");
        $this$onPlaced_u24lambda_u240.getProperties().set("onPlaced", this.$onPlaced$inlined);
    }
}
