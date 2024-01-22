package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$SliderImpl$gestureEndAction$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SliderDraggableState $draggableState;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$SliderImpl$gestureEndAction$1(SliderDraggableState sliderDraggableState, Function0<Unit> function0) {
        super(0);
        this.$draggableState = sliderDraggableState;
        this.$onValueChangeFinished = function0;
    }

    public final void invoke() {
        Function0<Unit> function0;
        if (!this.$draggableState.isDragging() && (function0 = this.$onValueChangeFinished) != null) {
            function0.invoke();
        }
    }
}
