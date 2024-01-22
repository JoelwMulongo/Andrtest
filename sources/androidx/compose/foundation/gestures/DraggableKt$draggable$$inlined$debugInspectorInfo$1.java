package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class DraggableKt$draggable$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ Function1 $canDrag$inlined;
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ MutableInteractionSource $interactionSource$inlined;
    final /* synthetic */ Function3 $onDragStarted$inlined;
    final /* synthetic */ Function3 $onDragStopped$inlined;
    final /* synthetic */ Orientation $orientation$inlined;
    final /* synthetic */ boolean $reverseDirection$inlined;
    final /* synthetic */ Function0 $startDragImmediately$inlined;
    final /* synthetic */ DraggableState $state$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DraggableKt$draggable$$inlined$debugInspectorInfo$1(Function1 function1, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, Function0 function0, Function3 function3, Function3 function32, DraggableState draggableState) {
        super(1);
        this.$canDrag$inlined = function1;
        this.$orientation$inlined = orientation;
        this.$enabled$inlined = z;
        this.$reverseDirection$inlined = z2;
        this.$interactionSource$inlined = mutableInteractionSource;
        this.$startDragImmediately$inlined = function0;
        this.$onDragStarted$inlined = function3;
        this.$onDragStopped$inlined = function32;
        this.$state$inlined = draggableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((InspectorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        InspectorInfo $this$draggable_u24lambda_u241 = $this$null;
        $this$draggable_u24lambda_u241.setName("draggable");
        $this$draggable_u24lambda_u241.getProperties().set("canDrag", this.$canDrag$inlined);
        $this$draggable_u24lambda_u241.getProperties().set("orientation", this.$orientation$inlined);
        $this$draggable_u24lambda_u241.getProperties().set("enabled", Boolean.valueOf(this.$enabled$inlined));
        $this$draggable_u24lambda_u241.getProperties().set("reverseDirection", Boolean.valueOf(this.$reverseDirection$inlined));
        $this$draggable_u24lambda_u241.getProperties().set("interactionSource", this.$interactionSource$inlined);
        $this$draggable_u24lambda_u241.getProperties().set("startDragImmediately", this.$startDragImmediately$inlined);
        $this$draggable_u24lambda_u241.getProperties().set("onDragStarted", this.$onDragStarted$inlined);
        $this$draggable_u24lambda_u241.getProperties().set("onDragStopped", this.$onDragStopped$inlined);
        $this$draggable_u24lambda_u241.getProperties().set("state", this.$state$inlined);
    }
}
