package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2", f = "Scrollable.kt", i = {}, l = {442}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Scrollable.kt */
final class ScrollingLogic$doFlingAnimation$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $available;
    final /* synthetic */ Ref.LongRef $result;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollingLogic$doFlingAnimation$2(ScrollingLogic scrollingLogic, Ref.LongRef longRef, long j, Continuation<? super ScrollingLogic$doFlingAnimation$2> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
        this.$result = longRef;
        this.$available = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic$doFlingAnimation$2 scrollingLogic$doFlingAnimation$2 = new ScrollingLogic$doFlingAnimation$2(this.this$0, this.$result, this.$available, continuation);
        scrollingLogic$doFlingAnimation$2.L$0 = obj;
        return scrollingLogic$doFlingAnimation$2;
    }

    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((ScrollingLogic$doFlingAnimation$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result2) {
        ScrollingLogic scrollingLogic;
        ScrollingLogic scrollingLogic2;
        Ref.LongRef longRef;
        long j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                ScrollingLogic scrollingLogic3 = this.this$0;
                ScrollingLogic$doFlingAnimation$2$scope$1 $this$invokeSuspend_u24lambda_u241 = new ScrollingLogic$doFlingAnimation$2$scope$1(this.this$0, new ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1(scrollingLogic3, (ScrollScope) this.L$0));
                scrollingLogic2 = this.this$0;
                longRef = this.$result;
                long j2 = this.$available;
                FlingBehavior $this$invokeSuspend_u24lambda_u241_u24lambda_u240 = scrollingLogic2.getFlingBehavior();
                long j3 = longRef.element;
                float reverseIfNeeded = scrollingLogic2.reverseIfNeeded(scrollingLogic2.m633toFloatTH1AsA0(j2));
                this.L$0 = scrollingLogic2;
                this.L$1 = scrollingLogic2;
                this.L$2 = longRef;
                this.J$0 = j3;
                this.label = 1;
                Object performFling = $this$invokeSuspend_u24lambda_u241_u24lambda_u240.performFling($this$invokeSuspend_u24lambda_u241, reverseIfNeeded, this);
                if (performFling != coroutine_suspended) {
                    Object obj = $result2;
                    $result2 = performFling;
                    scrollingLogic = scrollingLogic2;
                    j = j3;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                j = this.J$0;
                longRef = (Ref.LongRef) this.L$2;
                scrollingLogic2 = (ScrollingLogic) this.L$1;
                ResultKt.throwOnFailure($result2);
                scrollingLogic = (ScrollingLogic) this.L$0;
                Object obj2 = $result2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        longRef.element = scrollingLogic2.m636updateQWom1Mo(j, scrollingLogic.reverseIfNeeded(((Number) $result2).floatValue()));
        return Unit.INSTANCE;
    }
}
