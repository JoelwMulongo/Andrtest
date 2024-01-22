package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2", f = "Scrollable.kt", i = {0}, l = {545}, m = "invokeSuspend", n = {"velocityLeft"}, s = {"L$0"})
/* compiled from: Scrollable.kt */
final class DefaultFlingBehavior$performFling$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Float>, Object> {
    final /* synthetic */ float $initialVelocity;
    final /* synthetic */ ScrollScope $this_performFling;
    Object L$0;
    int label;
    final /* synthetic */ DefaultFlingBehavior this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultFlingBehavior$performFling$2(float f, DefaultFlingBehavior defaultFlingBehavior, ScrollScope scrollScope, Continuation<? super DefaultFlingBehavior$performFling$2> continuation) {
        super(2, continuation);
        this.$initialVelocity = f;
        this.this$0 = defaultFlingBehavior;
        this.$this_performFling = scrollScope;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultFlingBehavior$performFling$2(this.$initialVelocity, this.this$0, this.$this_performFling, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Float> continuation) {
        return ((DefaultFlingBehavior$performFling$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            r23 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r23
            int r2 = r1.label
            switch(r2) {
                case 0: goto L_0x001f;
                case 1: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0013:
            r0 = r23
            r2 = r24
            java.lang.Object r3 = r0.L$0
            kotlin.jvm.internal.Ref$FloatRef r3 = (kotlin.jvm.internal.Ref.FloatRef) r3
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x007b
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r24)
            r2 = r23
            r3 = r24
            float r4 = r2.$initialVelocity
            float r4 = java.lang.Math.abs(r4)
            r5 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x0083
            kotlin.jvm.internal.Ref$FloatRef r4 = new kotlin.jvm.internal.Ref$FloatRef
            r4.<init>()
            float r5 = r2.$initialVelocity
            r4.element = r5
            kotlin.jvm.internal.Ref$FloatRef r5 = new kotlin.jvm.internal.Ref$FloatRef
            r5.<init>()
            r6 = 0
            float r7 = r2.$initialVelocity
            r8 = 0
            r10 = 0
            r12 = 0
            r13 = 28
            r14 = 0
            androidx.compose.animation.core.AnimationState r15 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r6, r7, r8, r10, r12, r13, r14)
            androidx.compose.foundation.gestures.DefaultFlingBehavior r6 = r2.this$0
            androidx.compose.animation.core.DecayAnimationSpec r16 = r6.flingDecay
            r17 = 0
            androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2$1 r6 = new androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2$1
            androidx.compose.foundation.gestures.ScrollScope r7 = r2.$this_performFling
            androidx.compose.foundation.gestures.DefaultFlingBehavior r8 = r2.this$0
            r6.<init>(r5, r7, r4, r8)
            r18 = r6
            kotlin.jvm.functions.Function1 r18 = (kotlin.jvm.functions.Function1) r18
            r19 = r2
            kotlin.coroutines.Continuation r19 = (kotlin.coroutines.Continuation) r19
            r20 = 2
            r21 = 0
            r2.L$0 = r4
            r6 = 1
            r2.label = r6
            java.lang.Object r5 = androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r15, r16, r17, r18, r19, r20, r21)
            if (r5 != r0) goto L_0x0078
            return r0
        L_0x0078:
            r0 = r2
            r2 = r3
            r3 = r4
        L_0x007b:
            float r3 = r3.element
            r22 = r2
            r2 = r0
            r0 = r22
            goto L_0x008a
        L_0x0083:
            float r0 = r2.$initialVelocity
            r22 = r3
            r3 = r0
            r0 = r22
        L_0x008a:
            java.lang.Float r3 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
