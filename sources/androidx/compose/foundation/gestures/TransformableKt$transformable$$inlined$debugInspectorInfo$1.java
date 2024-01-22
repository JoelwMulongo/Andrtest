package androidx.compose.foundation.gestures;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class TransformableKt$transformable$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ boolean $lockRotationOnZoomPan$inlined;
    final /* synthetic */ TransformableState $state$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransformableKt$transformable$$inlined$debugInspectorInfo$1(TransformableState transformableState, boolean z, boolean z2) {
        super(1);
        this.$state$inlined = transformableState;
        this.$enabled$inlined = z;
        this.$lockRotationOnZoomPan$inlined = z2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((InspectorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        InspectorInfo $this$transformable_u24lambda_u240 = $this$null;
        $this$transformable_u24lambda_u240.setName("transformable");
        $this$transformable_u24lambda_u240.getProperties().set("state", this.$state$inlined);
        $this$transformable_u24lambda_u240.getProperties().set("enabled", Boolean.valueOf(this.$enabled$inlined));
        $this$transformable_u24lambda_u240.getProperties().set("lockRotationOnZoomPan", Boolean.valueOf(this.$lockRotationOnZoomPan$inlined));
    }
}
