package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationVector1D;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "frameTime", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: UpdatableAnimationState.kt */
final class UpdatableAnimationState$animateToZero$3 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ Function1<Float, Unit> $beforeFrame;
    final /* synthetic */ float $durationScale;
    final /* synthetic */ UpdatableAnimationState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpdatableAnimationState$animateToZero$3(UpdatableAnimationState updatableAnimationState, float f, Function1<? super Float, Unit> function1) {
        super(1);
        this.this$0 = updatableAnimationState;
        this.$durationScale = f;
        this.$beforeFrame = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long frameTime) {
        long playTime;
        if (this.this$0.lastFrameTime == Long.MIN_VALUE) {
            this.this$0.lastFrameTime = frameTime;
        }
        AnimationVector1D vectorizedCurrentValue = new AnimationVector1D(this.this$0.getValue());
        if (this.$durationScale == 0.0f) {
            playTime = UpdatableAnimationState.Companion.getRebasableAnimationSpec().getDurationNanos(new AnimationVector1D(this.this$0.getValue()), UpdatableAnimationState.Companion.getZeroVector(), this.this$0.lastVelocity);
        } else {
            playTime = MathKt.roundToLong(((float) (frameTime - this.this$0.lastFrameTime)) / this.$durationScale);
        }
        float newValue = UpdatableAnimationState.Companion.getRebasableAnimationSpec().getValueFromNanos(playTime, vectorizedCurrentValue, UpdatableAnimationState.Companion.getZeroVector(), this.this$0.lastVelocity).getValue();
        this.this$0.lastVelocity = UpdatableAnimationState.Companion.getRebasableAnimationSpec().getVelocityFromNanos(playTime, vectorizedCurrentValue, UpdatableAnimationState.Companion.getZeroVector(), this.this$0.lastVelocity);
        this.this$0.lastFrameTime = frameTime;
        this.this$0.setValue(newValue);
        this.$beforeFrame.invoke(Float.valueOf(this.this$0.getValue() - newValue));
    }
}
