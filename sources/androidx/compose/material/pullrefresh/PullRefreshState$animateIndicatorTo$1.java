package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1", f = "PullRefreshState.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PullRefreshState.kt */
final class PullRefreshState$animateIndicatorTo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $offset;
    int label;
    final /* synthetic */ PullRefreshState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullRefreshState$animateIndicatorTo$1(PullRefreshState pullRefreshState, float f, Continuation<? super PullRefreshState$animateIndicatorTo$1> continuation) {
        super(2, continuation);
        this.this$0 = pullRefreshState;
        this.$offset = f;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PullRefreshState$animateIndicatorTo$1(this.this$0, this.$offset, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PullRefreshState$animateIndicatorTo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1$1", f = "PullRefreshState.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.pullrefresh.PullRefreshState$animateIndicatorTo$1$1  reason: invalid class name */
    /* compiled from: PullRefreshState.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(pullRefreshState, f, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    float access$get_position = pullRefreshState.get_position();
                    float f = f;
                    final PullRefreshState pullRefreshState = pullRefreshState;
                    this.label = 1;
                    if (SuspendAnimationKt.animate$default(access$get_position, f, 0.0f, (AnimationSpec) null, new Function2<Float, Float, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                            invoke(((Number) p1).floatValue(), ((Number) p2).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float value, float f) {
                            pullRefreshState.set_position(value);
                        }
                    }, this, 12, (Object) null) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MutatorMutex access$getMutatorMutex$p = this.this$0.mutatorMutex;
                final PullRefreshState pullRefreshState = this.this$0;
                final float f = this.$offset;
                this.label = 1;
                if (MutatorMutex.mutate$default(access$getMutatorMutex$p, (MutatePriority) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this, 1, (Object) null) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
