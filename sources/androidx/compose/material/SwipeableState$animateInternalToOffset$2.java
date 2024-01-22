package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.DragScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SwipeableState$animateInternalToOffset$2", f = "Swipeable.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Swipeable.kt */
final class SwipeableState$animateInternalToOffset$2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimationSpec<Float> $spec;
    final /* synthetic */ float $target;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SwipeableState<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableState$animateInternalToOffset$2(SwipeableState<T> swipeableState, float f, AnimationSpec<Float> animationSpec, Continuation<? super SwipeableState$animateInternalToOffset$2> continuation) {
        super(2, continuation);
        this.this$0 = swipeableState;
        this.$target = f;
        this.$spec = animationSpec;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SwipeableState$animateInternalToOffset$2 swipeableState$animateInternalToOffset$2 = new SwipeableState$animateInternalToOffset$2(this.this$0, this.$target, this.$spec, continuation);
        swipeableState$animateInternalToOffset$2.L$0 = obj;
        return swipeableState$animateInternalToOffset$2;
    }

    public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
        return ((SwipeableState$animateInternalToOffset$2) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SwipeableState$animateInternalToOffset$2 swipeableState$animateInternalToOffset$2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                swipeableState$animateInternalToOffset$2 = this;
                Object obj = $result;
                final DragScope $this$drag = (DragScope) swipeableState$animateInternalToOffset$2.L$0;
                final Ref.FloatRef prevValue = new Ref.FloatRef();
                prevValue.element = ((Number) swipeableState$animateInternalToOffset$2.this$0.absoluteOffset.getValue()).floatValue();
                swipeableState$animateInternalToOffset$2.this$0.animationTarget.setValue(Boxing.boxFloat(swipeableState$animateInternalToOffset$2.$target));
                swipeableState$animateInternalToOffset$2.this$0.setAnimationRunning(true);
                swipeableState$animateInternalToOffset$2.label = 1;
                if (Animatable.animateTo$default(AnimatableKt.Animatable$default(prevValue.element, 0.0f, 2, (Object) null), Boxing.boxFloat(swipeableState$animateInternalToOffset$2.$target), swipeableState$animateInternalToOffset$2.$spec, (Object) null, new Function1<Animatable<Float, AnimationVector1D>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke((Animatable<Float, AnimationVector1D>) (Animatable) p1);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Animatable<Float, AnimationVector1D> $this$animateTo) {
                        Intrinsics.checkNotNullParameter($this$animateTo, "$this$animateTo");
                        $this$drag.dragBy($this$animateTo.getValue().floatValue() - prevValue.element);
                        prevValue.element = $this$animateTo.getValue().floatValue();
                    }
                }, swipeableState$animateInternalToOffset$2, 4, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                swipeableState$animateInternalToOffset$2 = this;
                try {
                    ResultKt.throwOnFailure($result);
                    break;
                } catch (Throwable th) {
                    swipeableState$animateInternalToOffset$2.this$0.animationTarget.setValue(null);
                    swipeableState$animateInternalToOffset$2.this$0.setAnimationRunning(false);
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        swipeableState$animateInternalToOffset$2.this$0.animationTarget.setValue(null);
        swipeableState$animateInternalToOffset$2.this$0.setAnimationRunning(false);
        return Unit.INSTANCE;
    }
}
