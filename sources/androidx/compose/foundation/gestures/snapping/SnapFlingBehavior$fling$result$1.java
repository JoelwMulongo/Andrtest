package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H@"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1", f = "SnapFlingBehavior.kt", i = {}, l = {134, 136}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SnapFlingBehavior.kt */
final class SnapFlingBehavior$fling$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AnimationResult<Float, AnimationVector1D>>, Object> {
    final /* synthetic */ float $initialVelocity;
    final /* synthetic */ Function1<Float, Unit> $onRemainingScrollOffsetUpdate;
    final /* synthetic */ ScrollScope $this_fling;
    int label;
    final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapFlingBehavior$fling$result$1(float f, SnapFlingBehavior snapFlingBehavior, ScrollScope scrollScope, Function1<? super Float, Unit> function1, Continuation<? super SnapFlingBehavior$fling$result$1> continuation) {
        super(2, continuation);
        this.$initialVelocity = f;
        this.this$0 = snapFlingBehavior;
        this.$this_fling = scrollScope;
        this.$onRemainingScrollOffsetUpdate = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SnapFlingBehavior$fling$result$1(this.$initialVelocity, this.this$0, this.$this_fling, this.$onRemainingScrollOffsetUpdate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        return ((SnapFlingBehavior$fling$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return (androidx.compose.foundation.gestures.snapping.AnimationResult) r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return (androidx.compose.foundation.gestures.snapping.AnimationResult) r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            switch(r1) {
                case 0: goto L_0x001f;
                case 1: goto L_0x0018;
                case 2: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0011:
            r0 = r8
            kotlin.ResultKt.throwOnFailure(r9)
            r1 = r0
            r0 = r9
            goto L_0x0068
        L_0x0018:
            r0 = r8
            kotlin.ResultKt.throwOnFailure(r9)
            r1 = r0
            r0 = r9
            goto L_0x004e
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r9)
            r1 = r8
            float r2 = r1.$initialVelocity
            float r2 = java.lang.Math.abs(r2)
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r3 = r1.this$0
            float r3 = r3.velocityThreshold
            float r3 = java.lang.Math.abs(r3)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x0051
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r2 = r1.this$0
            androidx.compose.foundation.gestures.ScrollScope r3 = r1.$this_fling
            float r4 = r1.$initialVelocity
            kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit> r5 = r1.$onRemainingScrollOffsetUpdate
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7 = 1
            r1.label = r7
            java.lang.Object r2 = r2.shortSnap(r3, r4, r5, r6)
            if (r2 != r0) goto L_0x004c
            return r0
        L_0x004c:
            r0 = r9
            r9 = r2
        L_0x004e:
            androidx.compose.foundation.gestures.snapping.AnimationResult r9 = (androidx.compose.foundation.gestures.snapping.AnimationResult) r9
            goto L_0x006a
        L_0x0051:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r2 = r1.this$0
            androidx.compose.foundation.gestures.ScrollScope r3 = r1.$this_fling
            float r4 = r1.$initialVelocity
            kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit> r5 = r1.$onRemainingScrollOffsetUpdate
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7 = 2
            r1.label = r7
            java.lang.Object r2 = r2.longSnap(r3, r4, r5, r6)
            if (r2 != r0) goto L_0x0066
            return r0
        L_0x0066:
            r0 = r9
            r9 = r2
        L_0x0068:
            androidx.compose.foundation.gestures.snapping.AnimationResult r9 = (androidx.compose.foundation.gestures.snapping.AnimationResult) r9
        L_0x006a:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
