package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$getAnimatedOffset$1", f = "LazyGridItemPlacementAnimator.kt", i = {}, l = {281}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LazyGridItemPlacementAnimator.kt */
final class LazyGridItemPlacementAnimator$getAnimatedOffset$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PlaceableInfo $item;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridItemPlacementAnimator$getAnimatedOffset$1(PlaceableInfo placeableInfo, Continuation<? super LazyGridItemPlacementAnimator$getAnimatedOffset$1> continuation) {
        super(2, continuation);
        this.$item = placeableInfo;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyGridItemPlacementAnimator$getAnimatedOffset$1(this.$item, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyGridItemPlacementAnimator$getAnimatedOffset$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        LazyGridItemPlacementAnimator$getAnimatedOffset$1 lazyGridItemPlacementAnimator$getAnimatedOffset$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$item.getAnimatedOffset().snapTo(IntOffset.m6095boximpl(this.$item.m1001getTargetOffsetnOccac()), this) != coroutine_suspended) {
                    lazyGridItemPlacementAnimator$getAnimatedOffset$1 = this;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                lazyGridItemPlacementAnimator$getAnimatedOffset$1 = this;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        lazyGridItemPlacementAnimator$getAnimatedOffset$1.$item.setInProgress(false);
        return Unit.INSTANCE;
    }
}
