package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.Transition$animateTo$1$1", f = "Transition.kt", i = {0}, l = {434}, m = "invokeSuspend", n = {"$this$LaunchedEffect"}, s = {"L$0"})
/* compiled from: Transition.kt */
final class Transition$animateTo$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Transition<S> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Transition$animateTo$1$1(Transition<S> transition, Continuation<? super Transition$animateTo$1$1> continuation) {
        super(2, continuation);
        this.this$0 = transition;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Transition$animateTo$1$1 transition$animateTo$1$1 = new Transition$animateTo$1$1(this.this$0, continuation);
        transition$animateTo$1$1.L$0 = obj;
        return transition$animateTo$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Transition$animateTo$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CoroutineScope $this$LaunchedEffect;
        Transition$animateTo$1$1 transition$animateTo$1$1;
        final float durationScale;
        final Transition<S> transition;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                transition$animateTo$1$1 = this;
                $this$LaunchedEffect = (CoroutineScope) transition$animateTo$1$1.L$0;
                break;
            case 1:
                transition$animateTo$1$1 = this;
                $this$LaunchedEffect = (CoroutineScope) transition$animateTo$1$1.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        do {
            durationScale = SuspendAnimationKt.getDurationScale($this$LaunchedEffect.getCoroutineContext());
            transition = transition$animateTo$1$1.this$0;
            transition$animateTo$1$1.L$0 = $this$LaunchedEffect;
            transition$animateTo$1$1.label = 1;
        } while (MonotonicFrameClockKt.withFrameNanos(new Function1<Long, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke(((Number) p1).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long it) {
                if (!transition.isSeeking()) {
                    transition.onFrame$animation_core_release(it / 1, durationScale);
                }
            }
        }, transition$animateTo$1$1) != coroutine_suspended);
        return coroutine_suspended;
    }
}
