package androidx.compose.material.pullrefresh;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class PullRefreshKt$pullRefresh$$inlined$debugInspectorInfo$2 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ Function1 $onPull$inlined;
    final /* synthetic */ Function2 $onRelease$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PullRefreshKt$pullRefresh$$inlined$debugInspectorInfo$2(Function1 function1, Function2 function2, boolean z) {
        super(1);
        this.$onPull$inlined = function1;
        this.$onRelease$inlined = function2;
        this.$enabled$inlined = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((InspectorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        InspectorInfo $this$pullRefresh_u24lambda_u242 = $this$null;
        $this$pullRefresh_u24lambda_u242.setName("pullRefresh");
        $this$pullRefresh_u24lambda_u242.getProperties().set("onPull", this.$onPull$inlined);
        $this$pullRefresh_u24lambda_u242.getProperties().set("onRelease", this.$onRelease$inlined);
        $this$pullRefresh_u24lambda_u242.getProperties().set("enabled", Boolean.valueOf(this.$enabled$inlined));
    }
}
