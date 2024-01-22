package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.ripple.CommonRippleIndicationInstance$addRipple$2", f = "CommonRipple.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CommonRipple.kt */
final class CommonRippleIndicationInstance$addRipple$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PressInteraction.Press $interaction;
    final /* synthetic */ RippleAnimation $rippleAnimation;
    int label;
    final /* synthetic */ CommonRippleIndicationInstance this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonRippleIndicationInstance$addRipple$2(RippleAnimation rippleAnimation, CommonRippleIndicationInstance commonRippleIndicationInstance, PressInteraction.Press press, Continuation<? super CommonRippleIndicationInstance$addRipple$2> continuation) {
        super(2, continuation);
        this.$rippleAnimation = rippleAnimation;
        this.this$0 = commonRippleIndicationInstance;
        this.$interaction = press;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommonRippleIndicationInstance$addRipple$2(this.$rippleAnimation, this.this$0, this.$interaction, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CommonRippleIndicationInstance$addRipple$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        androidx.compose.material.ripple.CommonRippleIndicationInstance.access$getRipples$p(r0.this$0).remove(r0.$interaction);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003b, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            switch(r1) {
                case 0: goto L_0x0018;
                case 1: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0011:
            r0 = r6
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0016 }
            goto L_0x002d
        L_0x0016:
            r1 = move-exception
            goto L_0x0040
        L_0x0018:
            kotlin.ResultKt.throwOnFailure(r7)
            r1 = r6
            androidx.compose.material.ripple.RippleAnimation r2 = r1.$rippleAnimation     // Catch:{ all -> 0x003c }
            r3 = r1
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch:{ all -> 0x003c }
            r4 = 1
            r1.label = r4     // Catch:{ all -> 0x003c }
            java.lang.Object r2 = r2.animate(r3)     // Catch:{ all -> 0x003c }
            if (r2 != r0) goto L_0x002c
            return r0
        L_0x002c:
            r0 = r1
        L_0x002d:
            androidx.compose.material.ripple.CommonRippleIndicationInstance r1 = r0.this$0
            androidx.compose.runtime.snapshots.SnapshotStateMap r1 = r1.ripples
            androidx.compose.foundation.interaction.PressInteraction$Press r2 = r0.$interaction
            r1.remove(r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x003c:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x0040:
            androidx.compose.material.ripple.CommonRippleIndicationInstance r2 = r0.this$0
            androidx.compose.runtime.snapshots.SnapshotStateMap r2 = r2.ripples
            androidx.compose.foundation.interaction.PressInteraction$Press r3 = r0.$interaction
            r2.remove(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.CommonRippleIndicationInstance$addRipple$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
