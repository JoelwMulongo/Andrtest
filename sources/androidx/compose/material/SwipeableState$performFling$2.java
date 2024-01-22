package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "anchors", "", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Swipeable.kt */
final class SwipeableState$performFling$2 implements FlowCollector<Map<Float, ? extends T>> {
    final /* synthetic */ float $velocity;
    final /* synthetic */ SwipeableState<T> this$0;

    SwipeableState$performFling$2(SwipeableState<T> swipeableState, float f) {
        this.this$0 = swipeableState;
        this.$velocity = f;
    }

    public final Object emit(Map<Float, ? extends T> anchors, Continuation<? super Unit> $completion) {
        Float access$getOffset = SwipeableKt.getOffset(anchors, this.this$0.getCurrentValue());
        Intrinsics.checkNotNull(access$getOffset);
        float lastAnchor = access$getOffset.floatValue();
        Object targetState = anchors.get(Boxing.boxFloat(SwipeableKt.computeTarget(this.this$0.getOffset().getValue().floatValue(), lastAnchor, anchors.keySet(), this.this$0.getThresholds$material_release(), this.$velocity, this.this$0.getVelocityThreshold$material_release())));
        if (targetState == null || !this.this$0.getConfirmStateChange$material_release().invoke(targetState).booleanValue()) {
            SwipeableState<T> swipeableState = this.this$0;
            Object access$animateInternalToOffset = swipeableState.animateInternalToOffset(lastAnchor, swipeableState.getAnimationSpec$material_release(), $completion);
            return access$animateInternalToOffset == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? access$animateInternalToOffset : Unit.INSTANCE;
        }
        Object animateTo$default = SwipeableState.animateTo$default(this.this$0, targetState, (AnimationSpec) null, $completion, 2, (Object) null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }
}
