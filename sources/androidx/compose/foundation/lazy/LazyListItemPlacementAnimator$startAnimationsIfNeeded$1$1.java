package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1", f = "LazyListItemPlacementAnimator.kt", i = {}, l = {297}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LazyListItemPlacementAnimator.kt */
final class LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<IntOffset> $animationSpec;
    final /* synthetic */ PlaceableInfo $placeableInfo;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1(PlaceableInfo placeableInfo, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, Continuation<? super LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1> continuation) {
        super(2, continuation);
        this.$placeableInfo = placeableInfo;
        this.$animationSpec = finiteAnimationSpec;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1(this.$placeableInfo, this.$animationSpec, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0.$placeableInfo.setInProgress(false);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            switch(r1) {
                case 0: goto L_0x0018;
                case 1: goto L_0x0011;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0011:
            r0 = r12
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x0016 }
            goto L_0x0062
        L_0x0016:
            r1 = move-exception
            goto L_0x006b
        L_0x0018:
            kotlin.ResultKt.throwOnFailure(r13)
            r1 = r12
            androidx.compose.foundation.lazy.PlaceableInfo r2 = r1.$placeableInfo
            androidx.compose.animation.core.Animatable r2 = r2.getAnimatedOffset()
            boolean r2 = r2.isRunning()
            if (r2 == 0) goto L_0x0038
            androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.unit.IntOffset> r2 = r1.$animationSpec
            boolean r3 = r2 instanceof androidx.compose.animation.core.SpringSpec
            if (r3 == 0) goto L_0x0031
            androidx.compose.animation.core.SpringSpec r2 = (androidx.compose.animation.core.SpringSpec) r2
            goto L_0x0035
        L_0x0031:
            androidx.compose.animation.core.SpringSpec r2 = androidx.compose.foundation.lazy.LazyListItemPlacementAnimatorKt.InterruptionSpec
        L_0x0035:
            androidx.compose.animation.core.FiniteAnimationSpec r2 = (androidx.compose.animation.core.FiniteAnimationSpec) r2
            goto L_0x003a
        L_0x0038:
            androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.unit.IntOffset> r2 = r1.$animationSpec
        L_0x003a:
            androidx.compose.foundation.lazy.PlaceableInfo r3 = r1.$placeableInfo     // Catch:{ CancellationException -> 0x0069 }
            androidx.compose.animation.core.Animatable r4 = r3.getAnimatedOffset()     // Catch:{ CancellationException -> 0x0069 }
            androidx.compose.foundation.lazy.PlaceableInfo r3 = r1.$placeableInfo     // Catch:{ CancellationException -> 0x0069 }
            long r5 = r3.m921getTargetOffsetnOccac()     // Catch:{ CancellationException -> 0x0069 }
            androidx.compose.ui.unit.IntOffset r5 = androidx.compose.ui.unit.IntOffset.m6095boximpl(r5)     // Catch:{ CancellationException -> 0x0069 }
            r6 = r2
            androidx.compose.animation.core.AnimationSpec r6 = (androidx.compose.animation.core.AnimationSpec) r6     // Catch:{ CancellationException -> 0x0069 }
            r7 = 0
            r8 = 0
            r9 = r1
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ CancellationException -> 0x0069 }
            r10 = 12
            r11 = 0
            r2 = 1
            r1.label = r2     // Catch:{ CancellationException -> 0x0069 }
            java.lang.Object r2 = androidx.compose.animation.core.Animatable.animateTo$default(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ CancellationException -> 0x0069 }
            if (r2 != r0) goto L_0x0061
            return r0
        L_0x0061:
            r0 = r1
        L_0x0062:
            androidx.compose.foundation.lazy.PlaceableInfo r1 = r0.$placeableInfo     // Catch:{ CancellationException -> 0x0016 }
            r2 = 0
            r1.setInProgress(r2)     // Catch:{ CancellationException -> 0x0016 }
            goto L_0x006b
        L_0x0069:
            r0 = move-exception
            r0 = r1
        L_0x006b:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
