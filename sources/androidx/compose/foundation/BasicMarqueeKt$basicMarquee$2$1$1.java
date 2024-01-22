package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.BasicMarqueeKt$basicMarquee$2$1$1", f = "BasicMarquee.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BasicMarquee.kt */
final class BasicMarqueeKt$basicMarquee$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MarqueeModifier $modifier;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicMarqueeKt$basicMarquee$2$1$1(MarqueeModifier marqueeModifier, Continuation<? super BasicMarqueeKt$basicMarquee$2$1$1> continuation) {
        super(2, continuation);
        this.$modifier = marqueeModifier;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BasicMarqueeKt$basicMarquee$2$1$1(this.$modifier, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BasicMarqueeKt$basicMarquee$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$modifier.runAnimation(this) != coroutine_suspended) {
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
