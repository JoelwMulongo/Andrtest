package androidx.compose.material;

import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ DraggableState $draggableState$inlined;
    final /* synthetic */ boolean $enabled$inlined;
    final /* synthetic */ State $gestureEndAction$inlined;
    final /* synthetic */ MutableInteractionSource $interactionSource$inlined;
    final /* synthetic */ boolean $isRtl$inlined;
    final /* synthetic */ float $maxPx$inlined;
    final /* synthetic */ MutableState $pressOffset$inlined;
    final /* synthetic */ State $rawOffset$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1(DraggableState draggableState, MutableInteractionSource mutableInteractionSource, float f, boolean z, State state, State state2, MutableState mutableState, boolean z2) {
        super(1);
        this.$draggableState$inlined = draggableState;
        this.$interactionSource$inlined = mutableInteractionSource;
        this.$maxPx$inlined = f;
        this.$isRtl$inlined = z;
        this.$rawOffset$inlined = state;
        this.$gestureEndAction$inlined = state2;
        this.$pressOffset$inlined = mutableState;
        this.$enabled$inlined = z2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((InspectorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        InspectorInfo $this$sliderTapModifier_u24lambda_u2420 = $this$null;
        $this$sliderTapModifier_u24lambda_u2420.setName("sliderTapModifier");
        $this$sliderTapModifier_u24lambda_u2420.getProperties().set("draggableState", this.$draggableState$inlined);
        $this$sliderTapModifier_u24lambda_u2420.getProperties().set("interactionSource", this.$interactionSource$inlined);
        $this$sliderTapModifier_u24lambda_u2420.getProperties().set("maxPx", Float.valueOf(this.$maxPx$inlined));
        $this$sliderTapModifier_u24lambda_u2420.getProperties().set("isRtl", Boolean.valueOf(this.$isRtl$inlined));
        $this$sliderTapModifier_u24lambda_u2420.getProperties().set("rawOffset", this.$rawOffset$inlined);
        $this$sliderTapModifier_u24lambda_u2420.getProperties().set("gestureEndAction", this.$gestureEndAction$inlined);
        $this$sliderTapModifier_u24lambda_u2420.getProperties().set("pressOffset", this.$pressOffset$inlined);
        $this$sliderTapModifier_u24lambda_u2420.getProperties().set("enabled", Boolean.valueOf(this.$enabled$inlined));
    }
}
