package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SuspendAnimationKt;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/TransformScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2", f = "TransformableState.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TransformableState.kt */
final class TransformableStateKt$animateRotateBy$2 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ float $degrees;
    final /* synthetic */ Ref.FloatRef $previous;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransformableStateKt$animateRotateBy$2(Ref.FloatRef floatRef, float f, AnimationSpec<Float> animationSpec, Continuation<? super TransformableStateKt$animateRotateBy$2> continuation) {
        super(2, continuation);
        this.$previous = floatRef;
        this.$degrees = f;
        this.$animationSpec = animationSpec;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TransformableStateKt$animateRotateBy$2 transformableStateKt$animateRotateBy$2 = new TransformableStateKt$animateRotateBy$2(this.$previous, this.$degrees, this.$animationSpec, continuation);
        transformableStateKt$animateRotateBy$2.L$0 = obj;
        return transformableStateKt$animateRotateBy$2;
    }

    public final Object invoke(TransformScope transformScope, Continuation<? super Unit> continuation) {
        return ((TransformableStateKt$animateRotateBy$2) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Object $result2 = $result;
                final TransformScope $this$transform = (TransformScope) this.L$0;
                AnimationState AnimationState$default = AnimationStateKt.AnimationState$default(this.$previous.element, 0.0f, 0, 0, false, 30, (Object) null);
                Float boxFloat = Boxing.boxFloat(this.$degrees);
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                final Ref.FloatRef floatRef = this.$previous;
                this.label = 1;
                if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec, false, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke((AnimationScope<Float, AnimationVector1D>) (AnimationScope) p1);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimationScope<Float, AnimationVector1D> $this$animateTo) {
                        Intrinsics.checkNotNullParameter($this$animateTo, "$this$animateTo");
                        TransformScope.m643transformByd4ec7I$default($this$transform, 0.0f, 0, $this$animateTo.getValue().floatValue() - floatRef.element, 3, (Object) null);
                        floatRef.element = $this$animateTo.getValue().floatValue();
                    }
                }, this, 4, (Object) null) != coroutine_suspended) {
                    Object obj = $result2;
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
