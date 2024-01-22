package androidx.compose.animation;

import androidx.compose.animation.SizeAnimationModifier;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationEndReason;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.ui.unit.IntSize;
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
@DebugMetadata(c = "androidx.compose.animation.SizeAnimationModifier$animateTo$data$1$1", f = "AnimationModifier.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnimationModifier.kt */
final class SizeAnimationModifier$animateTo$data$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $targetSize;
    final /* synthetic */ SizeAnimationModifier.AnimData $this_apply;
    int label;
    final /* synthetic */ SizeAnimationModifier this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SizeAnimationModifier$animateTo$data$1$1(SizeAnimationModifier.AnimData animData, long j, SizeAnimationModifier sizeAnimationModifier, Continuation<? super SizeAnimationModifier$animateTo$data$1$1> continuation) {
        super(2, continuation);
        this.$this_apply = animData;
        this.$targetSize = j;
        this.this$0 = sizeAnimationModifier;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SizeAnimationModifier$animateTo$data$1$1(this.$this_apply, this.$targetSize, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SizeAnimationModifier$animateTo$data$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        SizeAnimationModifier$animateTo$data$1$1 sizeAnimationModifier$animateTo$data$1$1;
        Function2<IntSize, IntSize, Unit> listener;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                sizeAnimationModifier$animateTo$data$1$1 = this;
                sizeAnimationModifier$animateTo$data$1$1.label = 1;
                Object animateTo$default = Animatable.animateTo$default(sizeAnimationModifier$animateTo$data$1$1.$this_apply.getAnim(), IntSize.m6138boximpl(sizeAnimationModifier$animateTo$data$1$1.$targetSize), sizeAnimationModifier$animateTo$data$1$1.this$0.getAnimSpec(), (Object) null, (Function1) null, sizeAnimationModifier$animateTo$data$1$1, 12, (Object) null);
                if (animateTo$default != coroutine_suspended) {
                    Object obj = $result;
                    $result = animateTo$default;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                sizeAnimationModifier$animateTo$data$1$1 = this;
                Object obj2 = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AnimationResult result = (AnimationResult) $result;
        if (result.getEndReason() == AnimationEndReason.Finished && (listener = sizeAnimationModifier$animateTo$data$1$1.this$0.getListener()) != null) {
            listener.invoke(IntSize.m6138boximpl(sizeAnimationModifier$animateTo$data$1$1.$this_apply.m369getStartSizeYbymL2g()), result.getEndState().getValue());
        }
        return Unit.INSTANCE;
    }
}
