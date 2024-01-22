package androidx.compose.material;

import androidx.compose.ui.platform.InspectorInfo;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class SwipeableV2Kt$swipeAnchors$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ AnchorChangeHandler $anchorChangeHandler$inlined;
    final /* synthetic */ Function2 $calculateAnchor$inlined;
    final /* synthetic */ Set $possibleValues$inlined;
    final /* synthetic */ SwipeableV2State $state$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableV2Kt$swipeAnchors$$inlined$debugInspectorInfo$1(SwipeableV2State swipeableV2State, Set set, AnchorChangeHandler anchorChangeHandler, Function2 function2) {
        super(1);
        this.$state$inlined = swipeableV2State;
        this.$possibleValues$inlined = set;
        this.$anchorChangeHandler$inlined = anchorChangeHandler;
        this.$calculateAnchor$inlined = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((InspectorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        InspectorInfo $this$swipeAnchors_u24lambda_u240 = $this$null;
        $this$swipeAnchors_u24lambda_u240.setName("swipeAnchors");
        $this$swipeAnchors_u24lambda_u240.getProperties().set("state", this.$state$inlined);
        $this$swipeAnchors_u24lambda_u240.getProperties().set("possibleValues", this.$possibleValues$inlined);
        $this$swipeAnchors_u24lambda_u240.getProperties().set("anchorChangeHandler", this.$anchorChangeHandler$inlined);
        $this$swipeAnchors_u24lambda_u240.getProperties().set("calculateAnchor", this.$calculateAnchor$inlined);
    }
}
