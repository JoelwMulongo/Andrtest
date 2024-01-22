package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001BL\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\rø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J=\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"0!*\u00020#2\u0006\u0010$\u001a\u00020\u00062\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020'0&H@ø\u0001\u0000¢\u0006\u0002\u0010(JL\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"0!*\u00020#2\u0006\u0010$\u001a\u00020\u00062!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020'0&H@ø\u0001\u0000¢\u0006\u0002\u0010(J\u001d\u0010.\u001a\u00020\u0006*\u00020#2\u0006\u0010$\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010/J1\u0010.\u001a\u00020\u0006*\u00020#2\u0006\u0010$\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020'0&H@ø\u0001\u0000¢\u0006\u0002\u0010(JT\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"0!*\u00020#2\u0006\u00102\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020'0&H@ø\u0001\u0000¢\u0006\u0002\u00104J=\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"0!*\u00020#2\u0006\u0010\u001f\u001a\u00020\u00062\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020'0&H@ø\u0001\u0000¢\u0006\u0002\u0010(R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0019\u0010\f\u001a\u00020\rX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, d2 = {"Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "lowVelocityAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "highVelocityAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "density", "Landroidx/compose/ui/unit/Density;", "shortSnapVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/unit/Density;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "motionScaleDuration", "Landroidx/compose/ui/MotionDurationScale;", "getMotionScaleDuration$foundation_release", "()Landroidx/compose/ui/MotionDurationScale;", "setMotionScaleDuration$foundation_release", "(Landroidx/compose/ui/MotionDurationScale;)V", "F", "velocityThreshold", "equals", "", "other", "", "hashCode", "", "isDecayApproachPossible", "offset", "velocity", "fling", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "onRemainingScrollOffsetUpdate", "Lkotlin/Function1;", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "longSnap", "onAnimationStep", "Lkotlin/ParameterName;", "name", "remainingScrollOffset", "performFling", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSettlingDistanceUpdated", "runApproach", "initialTargetOffset", "delta", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shortSnap", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapFlingBehavior.kt */
public final class SnapFlingBehavior implements FlingBehavior {
    public static final int $stable = 0;
    private final Density density;
    private final DecayAnimationSpec<Float> highVelocityAnimationSpec;
    private final AnimationSpec<Float> lowVelocityAnimationSpec;
    private MotionDurationScale motionScaleDuration;
    private final float shortSnapVelocityThreshold;
    private final AnimationSpec<Float> snapAnimationSpec;
    private final SnapLayoutInfoProvider snapLayoutInfoProvider;
    /* access modifiers changed from: private */
    public final float velocityThreshold;

    public /* synthetic */ SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider2, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, AnimationSpec animationSpec2, Density density2, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(snapLayoutInfoProvider2, animationSpec, decayAnimationSpec, animationSpec2, density2, f);
    }

    private SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider2, AnimationSpec<Float> lowVelocityAnimationSpec2, DecayAnimationSpec<Float> highVelocityAnimationSpec2, AnimationSpec<Float> snapAnimationSpec2, Density density2, float shortSnapVelocityThreshold2) {
        this.snapLayoutInfoProvider = snapLayoutInfoProvider2;
        this.lowVelocityAnimationSpec = lowVelocityAnimationSpec2;
        this.highVelocityAnimationSpec = highVelocityAnimationSpec2;
        this.snapAnimationSpec = snapAnimationSpec2;
        this.density = density2;
        this.shortSnapVelocityThreshold = shortSnapVelocityThreshold2;
        this.velocityThreshold = density2.m5967toPx0680j_4(shortSnapVelocityThreshold2);
        this.motionScaleDuration = ScrollableKt.getDefaultScrollMotionDurationScale();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SnapFlingBehavior(androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider r10, androidx.compose.animation.core.AnimationSpec r11, androidx.compose.animation.core.DecayAnimationSpec r12, androidx.compose.animation.core.AnimationSpec r13, androidx.compose.ui.unit.Density r14, float r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 32
            if (r0 == 0) goto L_0x000a
            float r0 = androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.getMinFlingVelocityDp()
            r7 = r0
            goto L_0x000b
        L_0x000a:
            r7 = r15
        L_0x000b:
            r8 = 0
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.<init>(androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider, androidx.compose.animation.core.AnimationSpec, androidx.compose.animation.core.DecayAnimationSpec, androidx.compose.animation.core.AnimationSpec, androidx.compose.ui.unit.Density, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MotionDurationScale getMotionScaleDuration$foundation_release() {
        return this.motionScaleDuration;
    }

    public final void setMotionScaleDuration$foundation_release(MotionDurationScale motionDurationScale) {
        Intrinsics.checkNotNullParameter(motionDurationScale, "<set-?>");
        this.motionScaleDuration = motionDurationScale;
    }

    public Object performFling(ScrollScope $this$performFling, float initialVelocity, Continuation<? super Float> $completion) {
        return performFling($this$performFling, initialVelocity, SnapFlingBehavior$performFling$2.INSTANCE, $completion);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object performFling(androidx.compose.foundation.gestures.ScrollScope r5, float r6, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super java.lang.Float> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$3
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$3 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$3 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$3
            r0.<init>(r4, r8)
        L_0x0019:
            r8 = r0
            java.lang.Object r0 = r8.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r8.label
            r3 = 1
            switch(r2) {
                case 0: goto L_0x0033;
                case 1: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r0)
            r5 = r0
            goto L_0x0040
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r0)
            r2 = r4
            r8.label = r3
            java.lang.Object r5 = r2.fling(r5, r6, r7, r8)
            if (r5 != r1) goto L_0x0040
            return r1
        L_0x0040:
            androidx.compose.foundation.gestures.snapping.AnimationResult r5 = (androidx.compose.foundation.gestures.snapping.AnimationResult) r5
            java.lang.Object r6 = r5.component1()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            androidx.compose.animation.core.AnimationState r5 = r5.component2()
            r7 = 0
            r7 = 0
            int r1 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r1 != 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r3 = 0
        L_0x005a:
            if (r3 == 0) goto L_0x005d
            goto L_0x0067
        L_0x005d:
            java.lang.Object r6 = r5.getVelocity()
            java.lang.Number r6 = (java.lang.Number) r6
            float r7 = r6.floatValue()
        L_0x0067:
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.performFling(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fling(androidx.compose.foundation.gestures.ScrollScope r10, float r11, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r12, kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.snapping.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1
            r0.<init>(r9, r13)
        L_0x0019:
            r13 = r0
            java.lang.Object r0 = r13.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r13.label
            switch(r2) {
                case 0: goto L_0x0036;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x002d:
            java.lang.Object r10 = r13.L$0
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            kotlin.ResultKt.throwOnFailure(r0)
            r11 = r0
            goto L_0x0058
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r0)
            r8 = r9
            r3 = r11
            r5 = r10
            r10 = r12
            androidx.compose.ui.MotionDurationScale r11 = r8.motionScaleDuration
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1 r12 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1
            r7 = 0
            r2 = r12
            r4 = r8
            r6 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r13.L$0 = r10
            r2 = 1
            r13.label = r2
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r12, r13)
            if (r11 != r1) goto L_0x0058
            return r1
        L_0x0058:
            androidx.compose.foundation.gestures.snapping.AnimationResult r11 = (androidx.compose.foundation.gestures.snapping.AnimationResult) r11
            r12 = 0
            java.lang.Float r12 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r12)
            r10.invoke(r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.fling(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object shortSnap(ScrollScope $this$shortSnap, float velocity, Function1<? super Float, Unit> onRemainingScrollOffsetUpdate, Continuation<? super AnimationResult<Float, AnimationVector1D>> $completion) {
        float closestOffset = SnapFlingBehaviorKt.findClosestOffset(0.0f, this.snapLayoutInfoProvider, this.density);
        Ref.FloatRef remainingScrollOffset = new Ref.FloatRef();
        remainingScrollOffset.element = closestOffset;
        return SnapFlingBehaviorKt.animateSnap($this$shortSnap, closestOffset, closestOffset, AnimationStateKt.AnimationState$default(0.0f, velocity, 0, 0, false, 28, (Object) null), this.snapAnimationSpec, new SnapFlingBehavior$shortSnap$3(remainingScrollOffset, onRemainingScrollOffsetUpdate), $completion);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00f3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object longSnap(androidx.compose.foundation.gestures.ScrollScope r25, float r26, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r27, kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.snapping.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r28) {
        /*
            r24 = this;
            r0 = r28
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$1
            if (r1 == 0) goto L_0x0019
            r1 = r0
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$1 r1 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0019
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r0 = r1
            r2 = r24
            goto L_0x0021
        L_0x0019:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$1 r1 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$1
            r2 = r24
            r1.<init>(r2, r0)
            r0 = r1
        L_0x0021:
            java.lang.Object r1 = r0.result
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            switch(r3) {
                case 0: goto L_0x0052;
                case 1: goto L_0x003a;
                case 2: goto L_0x0034;
                default: goto L_0x002c;
            }
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r1)
            r3 = r1
            goto L_0x00f4
        L_0x003a:
            java.lang.Object r3 = r0.L$3
            kotlin.jvm.internal.Ref$FloatRef r3 = (kotlin.jvm.internal.Ref.FloatRef) r3
            java.lang.Object r4 = r0.L$2
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r0.L$1
            androidx.compose.foundation.gestures.ScrollScope r5 = (androidx.compose.foundation.gestures.ScrollScope) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r6 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehavior) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r3
            r12 = r4
            r11 = r5
            r3 = r1
            goto L_0x00a7
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r1)
            r9 = r24
            r6 = r26
            r11 = r25
            r12 = r27
            r3 = 0
            androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider r3 = r9.snapLayoutInfoProvider
            r4 = 0
            androidx.compose.ui.unit.Density r5 = r9.density
            float r3 = r3.calculateApproachOffset(r5, r6)
            r4 = 0
            float r5 = java.lang.Math.abs(r3)
            float r7 = java.lang.Math.signum(r6)
            float r5 = r5 * r7
            kotlin.jvm.internal.Ref$FloatRef r3 = new kotlin.jvm.internal.Ref$FloatRef
            r3.<init>()
            r13 = r3
            r13.element = r5
            float r3 = r13.element
            java.lang.Float r3 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
            r12.invoke(r3)
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$3 r3 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$3
            r3.<init>(r13, r12)
            r7 = r3
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            r0.L$0 = r9
            r0.L$1 = r11
            r0.L$2 = r12
            r0.L$3 = r13
            r3 = 1
            r0.label = r3
            r3 = r9
            r4 = r11
            r8 = r0
            java.lang.Object r3 = r3.runApproach(r4, r5, r6, r7, r8)
            if (r3 != r10) goto L_0x00a6
            return r10
        L_0x00a6:
            r6 = r9
        L_0x00a7:
            androidx.compose.foundation.gestures.snapping.AnimationResult r3 = (androidx.compose.foundation.gestures.snapping.AnimationResult) r3
            java.lang.Object r4 = r3.component1()
            java.lang.Number r4 = (java.lang.Number) r4
            float r5 = r4.floatValue()
            androidx.compose.animation.core.AnimationState r3 = r3.component2()
            r4 = 0
            r13.element = r5
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r22 = 30
            r23 = 0
            r14 = r3
            androidx.compose.animation.core.AnimationState r7 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r14, (float) r15, (float) r16, (long) r17, (long) r19, (boolean) r21, (int) r22, (java.lang.Object) r23)
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r8 = r6.snapAnimationSpec
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$5 r3 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$longSnap$5
            r3.<init>(r13, r12)
            r9 = r3
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r3 = 0
            r0.L$0 = r3
            r0.L$1 = r3
            r0.L$2 = r3
            r0.L$3 = r3
            r3 = 2
            r0.label = r3
            r3 = r11
            r4 = r5
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r0
            java.lang.Object r3 = androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.animateSnap(r3, r4, r5, r6, r7, r8, r9)
            if (r3 != r10) goto L_0x00f4
            return r10
        L_0x00f4:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.longSnap(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object runApproach(ScrollScope $this$runApproach, float initialTargetOffset, float initialVelocity, Function1<? super Float, Unit> onAnimationStep, Continuation<? super AnimationResult<Float, AnimationVector1D>> $completion) {
        ApproachAnimation animation;
        if (isDecayApproachPossible(initialTargetOffset, initialVelocity)) {
            animation = new HighVelocityApproachAnimation(this.highVelocityAnimationSpec);
        } else {
            animation = new LowVelocityApproachAnimation(this.lowVelocityAnimationSpec, this.snapLayoutInfoProvider, this.density);
        }
        return SnapFlingBehaviorKt.approach($this$runApproach, initialTargetOffset, initialVelocity, animation, this.snapLayoutInfoProvider, this.density, onAnimationStep, $completion);
    }

    private final boolean isDecayApproachPossible(float offset, float velocity) {
        return Math.abs(DecayAnimationSpecKt.calculateTargetValue(this.highVelocityAnimationSpec, 0.0f, velocity)) >= Math.abs(offset) + this.snapLayoutInfoProvider.calculateSnapStepSize(this.density);
    }

    public boolean equals(Object other) {
        if (!(other instanceof SnapFlingBehavior) || !Intrinsics.areEqual((Object) ((SnapFlingBehavior) other).snapAnimationSpec, (Object) this.snapAnimationSpec) || !Intrinsics.areEqual((Object) ((SnapFlingBehavior) other).highVelocityAnimationSpec, (Object) this.highVelocityAnimationSpec) || !Intrinsics.areEqual((Object) ((SnapFlingBehavior) other).lowVelocityAnimationSpec, (Object) this.lowVelocityAnimationSpec) || !Intrinsics.areEqual((Object) ((SnapFlingBehavior) other).snapLayoutInfoProvider, (Object) this.snapLayoutInfoProvider) || !Intrinsics.areEqual((Object) ((SnapFlingBehavior) other).density, (Object) this.density) || !Dp.m5991equalsimpl0(((SnapFlingBehavior) other).shortSnapVelocityThreshold, this.shortSnapVelocityThreshold)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((((0 * 31) + this.snapAnimationSpec.hashCode()) * 31) + this.highVelocityAnimationSpec.hashCode()) * 31) + this.lowVelocityAnimationSpec.hashCode()) * 31) + this.snapLayoutInfoProvider.hashCode()) * 31) + this.density.hashCode()) * 31) + Dp.m5992hashCodeimpl(this.shortSnapVelocityThreshold);
    }
}
