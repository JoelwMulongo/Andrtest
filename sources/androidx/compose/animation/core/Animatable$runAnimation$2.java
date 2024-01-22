package androidx.compose.animation.core;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/AnimationResult;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.Animatable$runAnimation$2", f = "Animatable.kt", i = {0, 0}, l = {305}, m = "invokeSuspend", n = {"endState", "clampingNeeded"}, s = {"L$0", "L$1"})
/* compiled from: Animatable.kt */
final class Animatable$runAnimation$2 extends SuspendLambda implements Function1<Continuation<? super AnimationResult<T, V>>, Object> {
    final /* synthetic */ Animation<T, V> $animation;
    final /* synthetic */ Function1<Animatable<T, V>, Unit> $block;
    final /* synthetic */ T $initialVelocity;
    final /* synthetic */ long $startTime;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Animatable<T, V> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Animatable$runAnimation$2(Animatable<T, V> animatable, T t, Animation<T, V> animation, long j, Function1<? super Animatable<T, V>, Unit> function1, Continuation<? super Animatable$runAnimation$2> continuation) {
        super(1, continuation);
        this.this$0 = animatable;
        this.$initialVelocity = t;
        this.$animation = animation;
        this.$startTime = j;
        this.$block = function1;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Animatable$runAnimation$2(this.this$0, this.$initialVelocity, this.$animation, this.$startTime, this.$block, continuation);
    }

    public final Object invoke(Continuation<? super AnimationResult<T, V>> continuation) {
        return ((Animatable$runAnimation$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Animatable$runAnimation$2 animatable$runAnimation$2;
        final AnimationState endState;
        Ref.BooleanRef clampingNeeded;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                animatable$runAnimation$2 = this;
                Object obj2 = obj;
                animatable$runAnimation$2.this$0.getInternalState$animation_core_release().setVelocityVector$animation_core_release((AnimationVector) animatable$runAnimation$2.this$0.getTypeConverter().getConvertToVector().invoke(animatable$runAnimation$2.$initialVelocity));
                animatable$runAnimation$2.this$0.setTargetValue(animatable$runAnimation$2.$animation.getTargetValue());
                animatable$runAnimation$2.this$0.setRunning(true);
                endState = AnimationStateKt.copy$default((AnimationState) animatable$runAnimation$2.this$0.getInternalState$animation_core_release(), (Object) null, (AnimationVector) null, 0, Long.MIN_VALUE, false, 23, (Object) null);
                final Ref.BooleanRef clampingNeeded2 = new Ref.BooleanRef();
                Animation<T, V> animation = animatable$runAnimation$2.$animation;
                long j = animatable$runAnimation$2.$startTime;
                final Animatable<T, V> animatable = animatable$runAnimation$2.this$0;
                final Function1<Animatable<T, V>, Unit> function1 = animatable$runAnimation$2.$block;
                animatable$runAnimation$2.L$0 = endState;
                animatable$runAnimation$2.L$1 = clampingNeeded2;
                animatable$runAnimation$2.label = 1;
                if (SuspendAnimationKt.animate(endState, animation, j, new Function1<AnimationScope<T, V>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke((AnimationScope) p1);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimationScope<T, V> $this$animate) {
                        Intrinsics.checkNotNullParameter($this$animate, "$this$animate");
                        SuspendAnimationKt.updateState($this$animate, animatable.getInternalState$animation_core_release());
                        Object clamped = animatable.clampToBounds($this$animate.getValue());
                        if (!Intrinsics.areEqual(clamped, (Object) $this$animate.getValue())) {
                            animatable.getInternalState$animation_core_release().setValue$animation_core_release(clamped);
                            endState.setValue$animation_core_release(clamped);
                            Function1<Animatable<T, V>, Unit> function1 = function1;
                            if (function1 != null) {
                                function1.invoke(animatable);
                            }
                            $this$animate.cancelAnimation();
                            clampingNeeded2.element = true;
                            return;
                        }
                        Function1<Animatable<T, V>, Unit> function12 = function1;
                        if (function12 != null) {
                            function12.invoke(animatable);
                        }
                    }
                }, animatable$runAnimation$2) != coroutine_suspended) {
                    clampingNeeded = clampingNeeded2;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                animatable$runAnimation$2 = this;
                Object $result = obj;
                clampingNeeded = (Ref.BooleanRef) animatable$runAnimation$2.L$1;
                endState = (AnimationState) animatable$runAnimation$2.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    break;
                } catch (CancellationException e) {
                    animatable$runAnimation$2.this$0.endAnimation();
                    throw e;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AnimationEndReason endReason = clampingNeeded.element ? AnimationEndReason.BoundReached : AnimationEndReason.Finished;
        animatable$runAnimation$2.this$0.endAnimation();
        return new AnimationResult(endState, endReason);
    }
}
