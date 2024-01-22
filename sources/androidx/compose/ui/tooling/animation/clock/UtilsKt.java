package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.Animation;
import androidx.compose.animation.core.AnimationKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.TransitionInfo;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.tooling.animation.states.TargetState;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0000\u001a5\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\f\u0018\u00010\u000b\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u0002H\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0000¢\u0006\u0002\u0010\u0011\u001a&\u0010\u0012\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0013R\u0006\u0012\u0002\b\u00030\u00140\u0001*\u0006\u0012\u0002\b\u00030\u0014H\u0000\u001aH\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\f\"\b\b\u0001\u0010\u0017*\u00020\u0018*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u00170\u00192\u0006\u0010\u001a\u001a\u00020\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\f0\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0006H\u0000\u001a>\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\f\"\b\b\u0001\u0010\u0017*\u00020\u0018*\u0012\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u00170\u001eR\u00020\u001f2\b\b\u0002\u0010\u001d\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0000\u001aB\u0010\u0015\u001a\u00020\u0016\"\u0004\b\u0000\u0010\f\"\b\b\u0001\u0010\u0017*\u00020\u0018\"\u0004\b\u0002\u0010!*\u0018\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u00170\u0013R\b\u0012\u0004\u0012\u0002H!0\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u0006H\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\""}, d2 = {"IGNORE_TRANSITIONS", "", "", "getIGNORE_TRANSITIONS", "()Ljava/util/List;", "millisToNanos", "", "timeMs", "nanosToMillis", "timeNs", "parseParametersToValue", "Landroidx/compose/ui/tooling/animation/states/TargetState;", "T", "currentValue", "par1", "", "par2", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/ui/tooling/animation/states/TargetState;", "allAnimations", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "Landroidx/compose/animation/core/Transition;", "createTransitionInfo", "Landroidx/compose/animation/tooling/TransitionInfo;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/Animation;", "label", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "stepMs", "Landroidx/compose/animation/core/InfiniteTransition$TransitionAnimationState;", "Landroidx/compose/animation/core/InfiniteTransition;", "endTimeMs", "S", "ui-tooling_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Utils.kt */
public final class UtilsKt {
    private static final List<String> IGNORE_TRANSITIONS = CollectionsKt.listOf("TransformOriginInterruptionHandling");

    public static final List<String> getIGNORE_TRANSITIONS() {
        return IGNORE_TRANSITIONS;
    }

    public static final long nanosToMillis(long timeNs) {
        return (((long) 999999) + timeNs) / ((long) DurationKt.NANOS_IN_MILLIS);
    }

    public static final long millisToNanos(long timeMs) {
        return AnimationKt.MillisToNanos * timeMs;
    }

    /* JADX WARNING: type inference failed for: r9v0, types: [java.lang.Object, androidx.compose.animation.core.Transition, androidx.compose.animation.core.Transition<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<androidx.compose.animation.core.Transition<?>.TransitionAnimationState<?, ?>> allAnimations(androidx.compose.animation.core.Transition<?> r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.util.List r0 = r9.getTransitions()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            r3 = r0
            r4 = 0
            java.util.Iterator r5 = r3.iterator()
        L_0x0019:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0031
            java.lang.Object r6 = r5.next()
            r7 = r6
            androidx.compose.animation.core.Transition r7 = (androidx.compose.animation.core.Transition) r7
            r8 = 0
            java.util.List r7 = allAnimations(r7)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            kotlin.collections.CollectionsKt.addAll(r2, r7)
            goto L_0x0019
        L_0x0031:
            java.util.List r2 = (java.util.List) r2
            r0 = r2
            java.util.List r1 = r9.getAnimations()
            java.util.Collection r1 = (java.util.Collection) r1
            r2 = r0
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.List r1 = kotlin.collections.CollectionsKt.plus(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.animation.clock.UtilsKt.allAnimations(androidx.compose.animation.core.Transition):java.util.List");
    }

    public static /* synthetic */ TransitionInfo createTransitionInfo$default(Transition.TransitionAnimationState transitionAnimationState, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1;
        }
        return createTransitionInfo(transitionAnimationState, j);
    }

    public static final <T, V extends AnimationVector, S> TransitionInfo createTransitionInfo(Transition<S>.TransitionAnimationState<T, V> $this$createTransitionInfo, long stepMs) {
        Intrinsics.checkNotNullParameter($this$createTransitionInfo, "<this>");
        return createTransitionInfo($this$createTransitionInfo.getAnimation(), $this$createTransitionInfo.getLabel(), $this$createTransitionInfo.getAnimationSpec(), stepMs);
    }

    public static /* synthetic */ TransitionInfo createTransitionInfo$default(Animation animation, String str, AnimationSpec animationSpec, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 1;
        }
        return createTransitionInfo(animation, str, animationSpec, j);
    }

    public static final <T, V extends AnimationVector> TransitionInfo createTransitionInfo(Animation<T, V> $this$createTransitionInfo, String label, AnimationSpec<T> animationSpec, long stepMs) {
        AnimationSpec<T> animationSpec2 = animationSpec;
        Intrinsics.checkNotNullParameter($this$createTransitionInfo, "<this>");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
        long endTimeMs = nanosToMillis($this$createTransitionInfo.getDurationNanos());
        Lazy startTimeMs$delegate = LazyKt.lazy(new UtilsKt$createTransitionInfo$startTimeMs$2(animationSpec2));
        Lazy values$delegate = LazyKt.lazy(new UtilsKt$createTransitionInfo$values$2($this$createTransitionInfo, endTimeMs, stepMs, startTimeMs$delegate));
        String name = animationSpec.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "animationSpec.javaClass.name");
        return new TransitionInfo(label, name, createTransitionInfo$lambda$1(startTimeMs$delegate), endTimeMs, createTransitionInfo$lambda$2(values$delegate));
    }

    /* access modifiers changed from: private */
    public static final long createTransitionInfo$lambda$1(Lazy<Long> $startTimeMs$delegate) {
        return $startTimeMs$delegate.getValue().longValue();
    }

    private static final <T> Map<Long, T> createTransitionInfo$lambda$2(Lazy<? extends Map<Long, T>> $values$delegate) {
        return (Map) $values$delegate.getValue();
    }

    public static /* synthetic */ TransitionInfo createTransitionInfo$default(InfiniteTransition.TransitionAnimationState transitionAnimationState, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1;
        }
        return createTransitionInfo(transitionAnimationState, j, j2);
    }

    public static final <T, V extends AnimationVector> TransitionInfo createTransitionInfo(InfiniteTransition.TransitionAnimationState<T, V> $this$createTransitionInfo, long stepMs, long endTimeMs) {
        InfiniteTransition.TransitionAnimationState<T, V> transitionAnimationState = $this$createTransitionInfo;
        Intrinsics.checkNotNullParameter($this$createTransitionInfo, "<this>");
        Lazy values$delegate = LazyKt.lazy(new UtilsKt$createTransitionInfo$values$4(0, $this$createTransitionInfo, endTimeMs, stepMs));
        String label = $this$createTransitionInfo.getLabel();
        String name = $this$createTransitionInfo.getAnimationSpec().getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "animationSpec.javaClass.name");
        return new TransitionInfo(label, name, 0, endTimeMs, createTransitionInfo$lambda$3(values$delegate));
    }

    private static final <T> Map<Long, T> createTransitionInfo$lambda$3(Lazy<? extends Map<Long, T>> $values$delegate) {
        return (Map) $values$delegate.getValue();
    }

    public static final <T> TargetState<T> parseParametersToValue(T currentValue, Object par1, Object par2) {
        TargetState<Dp> targetState;
        T t = currentValue;
        Object obj = par1;
        Object obj2 = par2;
        Intrinsics.checkNotNullParameter(obj, "par1");
        if (t == null) {
            return null;
        }
        TargetState it = parseParametersToValue$parseDp(currentValue, par1, par2);
        if (it != null) {
            return it;
        }
        if (parseParametersToValue$parametersAreValid(par1, par2) == 0) {
            return null;
        }
        Intrinsics.checkNotNull(par2);
        if (parseParametersToValue$parametersHasTheSameType(currentValue, par1, par2)) {
            return new TargetState<>(obj, obj2);
        }
        if (!(obj instanceof List) || !(obj2 instanceof List)) {
            return null;
        }
        try {
            if (t instanceof IntSize) {
                Object obj3 = ((List) obj).get(0);
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) obj3).intValue();
                Object obj4 = ((List) obj).get(1);
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
                IntSize r9 = IntSize.m6138boximpl(IntSizeKt.IntSize(intValue, ((Integer) obj4).intValue()));
                Object obj5 = ((List) obj2).get(0);
                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Int");
                int intValue2 = ((Integer) obj5).intValue();
                Object obj6 = ((List) obj2).get(1);
                Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Int");
                targetState = new TargetState<>(r9, IntSize.m6138boximpl(IntSizeKt.IntSize(intValue2, ((Integer) obj6).intValue())));
            } else if (t instanceof IntOffset) {
                Object obj7 = ((List) obj).get(0);
                Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Int");
                int intValue3 = ((Integer) obj7).intValue();
                Object obj8 = ((List) obj).get(1);
                Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.Int");
                IntOffset r92 = IntOffset.m6095boximpl(IntOffsetKt.IntOffset(intValue3, ((Integer) obj8).intValue()));
                Object obj9 = ((List) obj2).get(0);
                Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type kotlin.Int");
                int intValue4 = ((Integer) obj9).intValue();
                Object obj10 = ((List) obj2).get(1);
                Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type kotlin.Int");
                targetState = new TargetState<>(r92, IntOffset.m6095boximpl(IntOffsetKt.IntOffset(intValue4, ((Integer) obj10).intValue())));
            } else if (t instanceof Size) {
                Object obj11 = ((List) obj).get(0);
                Intrinsics.checkNotNull(obj11, "null cannot be cast to non-null type kotlin.Float");
                float floatValue = ((Float) obj11).floatValue();
                Object obj12 = ((List) obj).get(1);
                Intrinsics.checkNotNull(obj12, "null cannot be cast to non-null type kotlin.Float");
                Size r93 = Size.m2972boximpl(SizeKt.Size(floatValue, ((Float) obj12).floatValue()));
                Object obj13 = ((List) obj2).get(0);
                Intrinsics.checkNotNull(obj13, "null cannot be cast to non-null type kotlin.Float");
                float floatValue2 = ((Float) obj13).floatValue();
                Object obj14 = ((List) obj2).get(1);
                Intrinsics.checkNotNull(obj14, "null cannot be cast to non-null type kotlin.Float");
                targetState = new TargetState<>(r93, Size.m2972boximpl(SizeKt.Size(floatValue2, ((Float) obj14).floatValue())));
            } else if (t instanceof Offset) {
                Object obj15 = ((List) obj).get(0);
                Intrinsics.checkNotNull(obj15, "null cannot be cast to non-null type kotlin.Float");
                float floatValue3 = ((Float) obj15).floatValue();
                Object obj16 = ((List) obj).get(1);
                Intrinsics.checkNotNull(obj16, "null cannot be cast to non-null type kotlin.Float");
                Offset r94 = Offset.m2904boximpl(OffsetKt.Offset(floatValue3, ((Float) obj16).floatValue()));
                Object obj17 = ((List) obj2).get(0);
                Intrinsics.checkNotNull(obj17, "null cannot be cast to non-null type kotlin.Float");
                float floatValue4 = ((Float) obj17).floatValue();
                Object obj18 = ((List) obj2).get(1);
                Intrinsics.checkNotNull(obj18, "null cannot be cast to non-null type kotlin.Float");
                targetState = new TargetState<>(r94, Offset.m2904boximpl(OffsetKt.Offset(floatValue4, ((Float) obj18).floatValue())));
            } else if (t instanceof Rect) {
                Object obj19 = ((List) obj).get(0);
                Intrinsics.checkNotNull(obj19, "null cannot be cast to non-null type kotlin.Float");
                float floatValue5 = ((Float) obj19).floatValue();
                Object obj20 = ((List) obj).get(1);
                Intrinsics.checkNotNull(obj20, "null cannot be cast to non-null type kotlin.Float");
                float floatValue6 = ((Float) obj20).floatValue();
                Object obj21 = ((List) obj).get(2);
                Intrinsics.checkNotNull(obj21, "null cannot be cast to non-null type kotlin.Float");
                float floatValue7 = ((Float) obj21).floatValue();
                Object obj22 = ((List) obj).get(3);
                Intrinsics.checkNotNull(obj22, "null cannot be cast to non-null type kotlin.Float");
                Rect rect = new Rect(floatValue5, floatValue6, floatValue7, ((Float) obj22).floatValue());
                Object obj23 = ((List) obj2).get(0);
                Intrinsics.checkNotNull(obj23, "null cannot be cast to non-null type kotlin.Float");
                float floatValue8 = ((Float) obj23).floatValue();
                Object obj24 = ((List) obj2).get(1);
                Intrinsics.checkNotNull(obj24, "null cannot be cast to non-null type kotlin.Float");
                float floatValue9 = ((Float) obj24).floatValue();
                Object obj25 = ((List) obj2).get(2);
                Intrinsics.checkNotNull(obj25, "null cannot be cast to non-null type kotlin.Float");
                float floatValue10 = ((Float) obj25).floatValue();
                Object obj26 = ((List) obj2).get(3);
                Intrinsics.checkNotNull(obj26, "null cannot be cast to non-null type kotlin.Float");
                targetState = new TargetState<>(rect, new Rect(floatValue8, floatValue9, floatValue10, ((Float) obj26).floatValue()));
            } else if (t instanceof Color) {
                Object obj27 = ((List) obj).get(0);
                Intrinsics.checkNotNull(obj27, "null cannot be cast to non-null type kotlin.Float");
                float floatValue11 = ((Float) obj27).floatValue();
                Object obj28 = ((List) obj).get(1);
                Intrinsics.checkNotNull(obj28, "null cannot be cast to non-null type kotlin.Float");
                float floatValue12 = ((Float) obj28).floatValue();
                Object obj29 = ((List) obj).get(2);
                Intrinsics.checkNotNull(obj29, "null cannot be cast to non-null type kotlin.Float");
                float floatValue13 = ((Float) obj29).floatValue();
                Object obj30 = ((List) obj).get(3);
                Intrinsics.checkNotNull(obj30, "null cannot be cast to non-null type kotlin.Float");
                Color r11 = Color.m3154boximpl(ColorKt.Color$default(floatValue11, floatValue12, floatValue13, ((Float) obj30).floatValue(), (ColorSpace) null, 16, (Object) null));
                Object obj31 = ((List) obj2).get(0);
                Intrinsics.checkNotNull(obj31, "null cannot be cast to non-null type kotlin.Float");
                float floatValue14 = ((Float) obj31).floatValue();
                Object obj32 = ((List) obj2).get(1);
                Intrinsics.checkNotNull(obj32, "null cannot be cast to non-null type kotlin.Float");
                float floatValue15 = ((Float) obj32).floatValue();
                Object obj33 = ((List) obj2).get(2);
                Intrinsics.checkNotNull(obj33, "null cannot be cast to non-null type kotlin.Float");
                float floatValue16 = ((Float) obj33).floatValue();
                Object obj34 = ((List) obj2).get(3);
                Intrinsics.checkNotNull(obj34, "null cannot be cast to non-null type kotlin.Float");
                targetState = new TargetState<>(r11, Color.m3154boximpl(ColorKt.Color$default(floatValue14, floatValue15, floatValue16, ((Float) obj34).floatValue(), (ColorSpace) null, 16, (Object) null)));
            } else if (t instanceof Dp) {
                Object obj35 = ((List) obj).get(0);
                Intrinsics.checkNotNull(obj35);
                Object obj36 = ((List) obj2).get(0);
                Intrinsics.checkNotNull(obj36);
                targetState = parseParametersToValue$parseDp(t, obj35, obj36);
            } else {
                if (parseParametersToValue$parametersAreValid(((List) obj).get(0), ((List) obj2).get(0))) {
                    Object obj37 = ((List) obj).get(0);
                    Intrinsics.checkNotNull(obj37);
                    Object obj38 = ((List) obj2).get(0);
                    Intrinsics.checkNotNull(obj38);
                    if (parseParametersToValue$parametersHasTheSameType(t, obj37, obj38)) {
                        targetState = new TargetState<>(((List) obj).get(0), ((List) obj2).get(0));
                    }
                }
                return null;
            }
            Intrinsics.checkNotNull(targetState, "null cannot be cast to non-null type androidx.compose.ui.tooling.animation.states.TargetState<T of androidx.compose.ui.tooling.animation.clock.UtilsKt.parseParametersToValue>");
            return targetState;
        } catch (IndexOutOfBoundsException e) {
            IndexOutOfBoundsException indexOutOfBoundsException = e;
            return null;
        } catch (ClassCastException e2) {
            ClassCastException classCastException = e2;
            return null;
        } catch (IllegalArgumentException e3) {
            IllegalArgumentException illegalArgumentException = e3;
            return null;
        } catch (NullPointerException e4) {
            NullPointerException nullPointerException = e4;
            return null;
        }
    }

    private static final boolean parseParametersToValue$parametersAreValid(Object par1, Object par2) {
        return (par1 == null || par2 == null || par1.getClass() != par2.getClass()) ? false : true;
    }

    private static final boolean parseParametersToValue$parametersHasTheSameType(Object value, Object par1, Object par2) {
        return value.getClass() == par1.getClass() && value.getClass() == par2.getClass();
    }

    private static final Dp parseParametersToValue$getDp(Object par) {
        Dp dp = par instanceof Dp ? (Dp) par : null;
        if (dp == null) {
            Float f = par instanceof Float ? (Float) par : null;
            dp = f != null ? Dp.m5984boximpl(Dp.m5986constructorimpl(f.floatValue())) : null;
            if (dp == null) {
                Double d = par instanceof Double ? (Double) par : null;
                dp = d != null ? Dp.m5984boximpl(Dp.m5986constructorimpl((float) d.doubleValue())) : null;
                if (dp == null) {
                    Integer num = par instanceof Integer ? (Integer) par : null;
                    if (num != null) {
                        return Dp.m5984boximpl(Dp.m5986constructorimpl((float) num.intValue()));
                    }
                    return null;
                }
            }
        }
        return dp;
    }

    private static final <T> TargetState<Dp> parseParametersToValue$parseDp(T $currentValue, Object par1, Object par2) {
        if (!($currentValue instanceof Dp) || par2 == null) {
            return null;
        }
        if ((par1 instanceof Dp) && (par2 instanceof Dp)) {
            return new TargetState<>(par1, par2);
        }
        Dp dp1 = parseParametersToValue$getDp(par1);
        Dp dp2 = parseParametersToValue$getDp(par2);
        if (dp1 == null || dp2 == null) {
            return null;
        }
        return new TargetState<>(dp1, dp2);
    }
}
