package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\b\u001a \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0000\u001a\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0017\u001an\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001a0\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0 2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0\"H@ø\u0001\u0000¢\u0006\u0002\u0010&\u001av\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001a0\u001e2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0*2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0\"H@ø\u0001\u0000¢\u0006\u0002\u0010+\u001ax\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u001b2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001a002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0\"H@ø\u0001\u0000¢\u0006\u0002\u00101\u001a\u0014\u00102\u001a\u00020\b*\u00020\b2\u0006\u00103\u001a\u00020\bH\u0002\u001a(\u00104\u001a\u0002H5\"\u000e\b\u0000\u00105*\b\u0012\u0004\u0012\u0002H506*\b\u0012\u0004\u0012\u0002H507H\u0002¢\u0006\u0002\u00108\u001a(\u00109\u001a\u0002H5\"\u000e\b\u0000\u00105*\b\u0012\u0004\u0012\u0002H506*\b\u0012\u0004\u0012\u0002H507H\u0002¢\u0006\u0002\u00108\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"DEBUG", "", "MinFlingVelocityDp", "Landroidx/compose/ui/unit/Dp;", "getMinFlingVelocityDp", "()F", "F", "NoDistance", "", "NoVelocity", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "findClosestOffset", "velocity", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "density", "Landroidx/compose/ui/unit/Density;", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "animateDecay", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "targetOffset", "animationState", "Landroidx/compose/animation/core/AnimationState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "onAnimationStep", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "delta", "(Landroidx/compose/foundation/gestures/ScrollScope;FLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateSnap", "cancelOffset", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "approach", "initialTargetOffset", "initialVelocity", "animation", "Landroidx/compose/foundation/gestures/snapping/ApproachAnimation;", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/foundation/gestures/snapping/ApproachAnimation;Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coerceToTarget", "target", "component1", "T", "", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "component2", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapFlingBehavior.kt */
public final class SnapFlingBehaviorKt {
    private static final boolean DEBUG = false;
    private static final float MinFlingVelocityDp = Dp.m5986constructorimpl((float) 400);
    public static final float NoDistance = 0.0f;
    public static final float NoVelocity = 0.0f;

    public static final SnapFlingBehavior rememberSnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, Composer $composer, int $changed) {
        SnapLayoutInfoProvider snapLayoutInfoProvider2 = snapLayoutInfoProvider;
        Composer composer = $composer;
        int i = $changed;
        Intrinsics.checkNotNullParameter(snapLayoutInfoProvider2, "snapLayoutInfoProvider");
        composer.startReplaceableGroup(-473984552);
        ComposerKt.sourceInformation(composer, "C(rememberSnapFlingBehavior)271@11479L7,272@11549L26,273@11587L447:SnapFlingBehavior.kt#ppz6w6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-473984552, i, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (SnapFlingBehavior.kt:268)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        DecayAnimationSpec highVelocityApproachSpec = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, 0);
        int i2 = (i & 14) | 64;
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        boolean invalid$iv$iv = composer.changed((Object) snapLayoutInfoProvider2) | composer.changed((Object) highVelocityApproachSpec) | composer.changed((Object) density);
        Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || value$iv$iv == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv;
            value$iv$iv = new SnapFlingBehavior(snapLayoutInfoProvider, AnimationSpecKt.tween$default(0, 0, EasingKt.getLinearEasing(), 3, (Object) null), highVelocityApproachSpec, AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null), density, 0.0f, 32, (DefaultConstructorMarker) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            Object obj2 = value$iv$iv;
            Composer composer2 = $this$cache$iv$iv;
        }
        $composer.endReplaceableGroup();
        SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) value$iv$iv;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return snapFlingBehavior;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object approach(androidx.compose.foundation.gestures.ScrollScope r8, float r9, float r10, androidx.compose.foundation.gestures.snapping.ApproachAnimation<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r11, androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider r12, androidx.compose.ui.unit.Density r13, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r14, kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.snapping.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r15) {
        /*
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$approach$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$approach$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$approach$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$approach$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$approach$1
            r0.<init>(r15)
        L_0x0019:
            r15 = r0
            java.lang.Object r6 = r15.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r15.label
            switch(r0) {
                case 0: goto L_0x003b;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x002d:
            java.lang.Object r8 = r15.L$1
            androidx.compose.ui.unit.Density r8 = (androidx.compose.ui.unit.Density) r8
            java.lang.Object r9 = r15.L$0
            androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider r9 = (androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider) r9
            kotlin.ResultKt.throwOnFailure(r6)
            r11 = r8
            r8 = r6
            goto L_0x005f
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r6)
            r1 = r8
            r8 = r10
            r4 = r14
            r10 = r12
            r0 = r11
            r11 = r13
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r9)
            java.lang.Float r3 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r8)
            r15.L$0 = r10
            r15.L$1 = r11
            r8 = 1
            r15.label = r8
            r5 = r15
            java.lang.Object r8 = r0.approachAnimation(r1, r2, r3, r4, r5)
            if (r8 != r7) goto L_0x005e
            return r7
        L_0x005e:
            r9 = r10
        L_0x005f:
            androidx.compose.foundation.gestures.snapping.AnimationResult r8 = (androidx.compose.foundation.gestures.snapping.AnimationResult) r8
            androidx.compose.animation.core.AnimationState r8 = r8.component2()
            java.lang.Object r10 = r8.getVelocity()
            java.lang.Number r10 = (java.lang.Number) r10
            float r10 = r10.floatValue()
            float r10 = findClosestOffset(r10, r9, r11)
            androidx.compose.foundation.gestures.snapping.AnimationResult r12 = new androidx.compose.foundation.gestures.snapping.AnimationResult
            java.lang.Float r13 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10)
            r12.<init>(r13, r8)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.approach(androidx.compose.foundation.gestures.ScrollScope, float, float, androidx.compose.foundation.gestures.snapping.ApproachAnimation, androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider, androidx.compose.ui.unit.Density, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final boolean findClosestOffset$isValidDistance(float $this$findClosestOffset_u24isValidDistance) {
        if (!($this$findClosestOffset_u24isValidDistance == Float.POSITIVE_INFINITY)) {
            if (!($this$findClosestOffset_u24isValidDistance == Float.NEGATIVE_INFINITY)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0042, code lost:
        if (java.lang.Math.abs(r0) <= java.lang.Math.abs(r1)) goto L_0x0051;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final float findClosestOffset(float r7, androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider r8, androidx.compose.ui.unit.Density r9) {
        /*
            java.lang.String r0 = "snapLayoutInfoProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "density"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = r8
            r1 = 0
            kotlin.ranges.ClosedFloatingPointRange r0 = r0.calculateSnappingOffsetBounds(r9)
            java.lang.Comparable r1 = component1(r0)
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            java.lang.Comparable r0 = component2(r0)
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            r2 = 0
            float r2 = java.lang.Math.signum(r7)
            r3 = 0
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            r5 = 1
            r6 = 0
            if (r4 != 0) goto L_0x0035
            r4 = r5
            goto L_0x0036
        L_0x0035:
            r4 = r6
        L_0x0036:
            if (r4 == 0) goto L_0x0046
            float r2 = java.lang.Math.abs(r0)
            float r4 = java.lang.Math.abs(r1)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0045
            goto L_0x0051
        L_0x0045:
            goto L_0x005d
        L_0x0046:
            r4 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x004e
            r4 = r5
            goto L_0x004f
        L_0x004e:
            r4 = r6
        L_0x004f:
            if (r4 == 0) goto L_0x0053
        L_0x0051:
            r2 = r0
            goto L_0x0060
        L_0x0053:
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r5 = r6
        L_0x005b:
            if (r5 == 0) goto L_0x005f
        L_0x005d:
            r2 = r1
            goto L_0x0060
        L_0x005f:
            r2 = r3
        L_0x0060:
            boolean r4 = findClosestOffset$isValidDistance(r2)
            if (r4 == 0) goto L_0x0069
            r3 = r2
            goto L_0x006a
        L_0x0069:
        L_0x006a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.findClosestOffset(float, androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider, androidx.compose.ui.unit.Density):float");
    }

    private static final <T extends Comparable<? super T>> T component1(ClosedFloatingPointRange<T> $this$component1) {
        Intrinsics.checkNotNullParameter($this$component1, "<this>");
        return $this$component1.getStart();
    }

    private static final <T extends Comparable<? super T>> T component2(ClosedFloatingPointRange<T> $this$component2) {
        Intrinsics.checkNotNullParameter($this$component2, "<this>");
        return $this$component2.getEndInclusive();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Incorrect type for immutable var: ssa=androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>, code=androidx.compose.animation.core.AnimationState, for r8v0, types: [androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>, androidx.compose.animation.core.AnimationState, java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object animateDecay(androidx.compose.foundation.gestures.ScrollScope r6, float r7, androidx.compose.animation.core.AnimationState r8, androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r9, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r10, kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.snapping.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r11) {
        /*
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1
            r0.<init>(r11)
        L_0x0019:
            r11 = r0
            java.lang.Object r0 = r11.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            switch(r2) {
                case 0: goto L_0x003b;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x002d:
            float r6 = r11.F$0
            java.lang.Object r7 = r11.L$1
            kotlin.jvm.internal.Ref$FloatRef r7 = (kotlin.jvm.internal.Ref.FloatRef) r7
            java.lang.Object r8 = r11.L$0
            androidx.compose.animation.core.AnimationState r8 = (androidx.compose.animation.core.AnimationState) r8
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0071
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$FloatRef r2 = new kotlin.jvm.internal.Ref$FloatRef
            r2.<init>()
            java.lang.Object r3 = r8.getVelocity()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            r4 = 1
            if (r3 != 0) goto L_0x0057
            r3 = r4
            goto L_0x0058
        L_0x0057:
            r3 = 0
        L_0x0058:
            r3 = r3 ^ r4
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$2 r5 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$2
            r5.<init>(r7, r2, r6, r10)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r11.L$0 = r8
            r11.L$1 = r2
            r11.F$0 = r7
            r11.label = r4
            java.lang.Object r6 = androidx.compose.animation.core.SuspendAnimationKt.animateDecay(r8, r9, (boolean) r3, r5, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r11)
            if (r6 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r6 = r7
            r7 = r2
        L_0x0071:
            r9 = 0
            androidx.compose.foundation.gestures.snapping.AnimationResult r9 = new androidx.compose.foundation.gestures.snapping.AnimationResult
            float r10 = r7.element
            float r10 = r6 - r10
            java.lang.Float r10 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10)
            r9.<init>(r10, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.animateDecay(androidx.compose.foundation.gestures.ScrollScope, float, androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.DecayAnimationSpec, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void animateDecay$consumeDelta(AnimationScope<Float, AnimationVector1D> $this$animateDecay_u24consumeDelta, ScrollScope $this_animateDecay, Function1<? super Float, Unit> $onAnimationStep, float delta) {
        float consumed = $this_animateDecay.scrollBy(delta);
        $onAnimationStep.invoke(Float.valueOf(consumed));
        if (Math.abs(delta - consumed) > 0.5f) {
            $this$animateDecay_u24consumeDelta.cancelAnimation();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object animateSnap(androidx.compose.foundation.gestures.ScrollScope r20, float r21, float r22, androidx.compose.animation.core.AnimationState<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r23, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r24, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r25, kotlin.coroutines.Continuation<? super androidx.compose.foundation.gestures.snapping.AnimationResult<java.lang.Float, androidx.compose.animation.core.AnimationVector1D>> r26) {
        /*
            r0 = r26
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$1 r1 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$1 r1 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$1
            r1.<init>(r0)
        L_0x001b:
            r0 = r1
            java.lang.Object r7 = r0.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            switch(r1) {
                case 0: goto L_0x003f;
                case 1: goto L_0x002f;
                default: goto L_0x0027;
            }
        L_0x0027:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002f:
            float r1 = r0.F$1
            float r2 = r0.F$0
            java.lang.Object r3 = r0.L$1
            kotlin.jvm.internal.Ref$FloatRef r3 = (kotlin.jvm.internal.Ref.FloatRef) r3
            java.lang.Object r4 = r0.L$0
            androidx.compose.animation.core.AnimationState r4 = (androidx.compose.animation.core.AnimationState) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x009a
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r7)
            r9 = r20
            r10 = r22
            r3 = r24
            r11 = r21
            r12 = r23
            r13 = r25
            kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
            r1.<init>()
            r14 = r1
            java.lang.Object r1 = r12.getVelocity()
            java.lang.Number r1 = (java.lang.Number) r1
            float r15 = r1.floatValue()
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r11)
            java.lang.Object r1 = r12.getVelocity()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            r4 = 1
            if (r1 != 0) goto L_0x0076
            r1 = r4
            goto L_0x0077
        L_0x0076:
            r1 = 0
        L_0x0077:
            r5 = r1 ^ 1
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$2 r1 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateSnap$2
            r1.<init>(r10, r14, r9, r13)
            r6 = r1
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0.L$0 = r12
            r0.L$1 = r14
            r0.F$0 = r11
            r0.F$1 = r15
            r0.label = r4
            r1 = r12
            r4 = r5
            r5 = r6
            r6 = r0
            java.lang.Object r1 = androidx.compose.animation.core.SuspendAnimationKt.animateTo(r1, r2, r3, r4, r5, r6)
            if (r1 != r8) goto L_0x0096
            return r8
        L_0x0096:
            r2 = r11
            r4 = r12
            r3 = r14
            r1 = r15
        L_0x009a:
            java.lang.Object r5 = r4.getVelocity()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            float r5 = coerceToTarget(r5, r1)
            androidx.compose.foundation.gestures.snapping.AnimationResult r6 = new androidx.compose.foundation.gestures.snapping.AnimationResult
            float r8 = r3.element
            float r8 = r2 - r8
            java.lang.Float r15 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r8)
            r9 = 0
            r11 = 0
            r13 = 0
            r16 = 0
            r17 = 29
            r18 = 0
            r8 = r4
            r10 = r5
            r19 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            androidx.compose.animation.core.AnimationState r8 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r8, (float) r9, (float) r10, (long) r11, (long) r13, (boolean) r15, (int) r16, (java.lang.Object) r17)
            r9 = r19
            r6.<init>(r9, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.animateSnap(androidx.compose.foundation.gestures.ScrollScope, float, float, androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.AnimationSpec, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final float coerceToTarget(float $this$coerceToTarget, float target) {
        if (target == 0.0f) {
            return 0.0f;
        }
        return target > 0.0f ? RangesKt.coerceAtMost($this$coerceToTarget, target) : RangesKt.coerceAtLeast($this$coerceToTarget, target);
    }

    public static final float getMinFlingVelocityDp() {
        return MinFlingVelocityDp;
    }

    private static final void debugLog(Function0<String> generateMsg) {
    }
}
