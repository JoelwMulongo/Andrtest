package androidx.compose.foundation.pager;

import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.pager.PagerKt$Pager$3$1", f = "Pager.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Pager.kt */
final class PagerKt$Pager$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PagerState $state;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerKt$Pager$3$1(PagerState pagerState, Continuation<? super PagerKt$Pager$3$1> continuation) {
        super(2, continuation);
        this.$state = pagerState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PagerKt$Pager$3$1(this.$state, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PagerKt$Pager$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final PagerState pagerState = this.$state;
                Flow drop = FlowKt.drop(new PagerKt$Pager$3$1$invokeSuspend$$inlined$filter$1(SnapshotStateKt.snapshotFlow(new Function0<Boolean>() {
                    public final Boolean invoke() {
                        return Boolean.valueOf(pagerState.isScrollInProgress());
                    }
                })), 1);
                final PagerState pagerState2 = this.$state;
                this.label = 1;
                if (drop.collect(new FlowCollector<Boolean>() {
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit(((Boolean) value).booleanValue(), (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(boolean it, Continuation<? super Unit> $completion) {
                        pagerState2.updateOnScrollStopped$foundation_release();
                        return Unit.INSTANCE;
                    }
                }, this) != coroutine_suspended) {
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
