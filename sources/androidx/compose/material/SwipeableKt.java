package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.InspectableValueKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002\u001a$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0002\u001aZ\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u00022\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00182#\b\u0002\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u001aH\u0007¢\u0006\u0002\u0010\u001f\u001aI\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u00152\u0006\u0010!\u001a\u0002H\u00022\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020#0\u001a2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0018H\u0001¢\u0006\u0002\u0010$\u001a-\u0010%\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00020&2\u0006\u0010'\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u0010(\u001a¹\u0001\u0010)\u001a\u00020*\"\u0004\b\u0000\u0010\u0002*\u00020*2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u0002H\u00020&2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u001e2\b\b\u0002\u0010.\u001a\u00020\u001e2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010028\b\u0002\u0010\u000e\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(1\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(2\u0012\u0004\u0012\u0002030\u000f2\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\b\b\u0002\u0010\u0011\u001a\u000206H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108\"*\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038@X\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00069"}, d2 = {"PreUpPostDownNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "T", "Landroidx/compose/material/SwipeableState;", "getPreUpPostDownNestedScrollConnection$annotations", "(Landroidx/compose/material/SwipeableState;)V", "getPreUpPostDownNestedScrollConnection", "(Landroidx/compose/material/SwipeableState;)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "computeTarget", "", "offset", "lastValue", "anchors", "", "thresholds", "Lkotlin/Function2;", "velocity", "velocityThreshold", "findBounds", "", "rememberSwipeableState", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableState;", "rememberSwipeableStateFor", "value", "onValueChange", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableState;", "getOffset", "", "state", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Float;", "swipeable", "Landroidx/compose/ui/Modifier;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "from", "to", "Landroidx/compose/material/ThresholdConfig;", "resistance", "Landroidx/compose/material/ResistanceConfig;", "Landroidx/compose/ui/unit/Dp;", "swipeable-pPrIpRY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SwipeableState;Ljava/util/Map;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/ResistanceConfig;F)Landroidx/compose/ui/Modifier;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Swipeable.kt */
public final class SwipeableKt {
    public static /* synthetic */ void getPreUpPostDownNestedScrollConnection$annotations(SwipeableState swipeableState) {
    }

    public static final <T> SwipeableState<T> rememberSwipeableState(T initialValue, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmStateChange, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-1237755169);
        ComposerKt.sourceInformation($composer, "C(rememberSwipeableState)P(2)472@19144L344:Swipeable.kt#jmzs0o");
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i & 2) != 0) {
            animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        Function1<? super T, Boolean> confirmStateChange2 = confirmStateChange;
        if ((i & 4) != 0) {
            confirmStateChange2 = SwipeableKt$rememberSwipeableState$1.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1237755169, $changed, -1, "androidx.compose.material.rememberSwipeableState (Swipeable.kt:467)");
        }
        SwipeableState<T> swipeableState = (SwipeableState) RememberSaveableKt.rememberSaveable(new Object[0], SwipeableState.Companion.Saver(animationSpec2, confirmStateChange2), (String) null, new SwipeableKt$rememberSwipeableState$2(initialValue, animationSpec2, confirmStateChange2), $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return swipeableState;
    }

    public static final <T> SwipeableState<T> rememberSwipeableStateFor(T value, Function1<? super T, Unit> onValueChange, AnimationSpec<Float> animationSpec, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Object value$iv$iv2;
        T t = value;
        Function1<? super T, Unit> function1 = onValueChange;
        Composer composer = $composer;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(t, "value");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        composer.startReplaceableGroup(1156387078);
        ComposerKt.sourceInformation(composer, "C(rememberSwipeableStateFor)P(2,1)501@20311L169,508@20511L34,509@20550L162,514@20717L259:Swipeable.kt#jmzs0o");
        AnimationSpec animationSpec2 = (i & 4) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1156387078, i2, -1, "androidx.compose.material.rememberSwipeableStateFor (Swipeable.kt:496)");
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = new SwipeableState(t, animationSpec2, SwipeableKt$rememberSwipeableStateFor$swipeableState$1$1.INSTANCE);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        SwipeableState swipeableState = (SwipeableState) value$iv$iv;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (it$iv$iv2 == Composer.Companion.getEmpty()) {
            AnimationSpec<Float> animationSpec3 = animationSpec2;
            value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        MutableState forceAnimationCheck = (MutableState) value$iv$iv2;
        EffectsKt.LaunchedEffect(t, forceAnimationCheck.getValue(), new SwipeableKt$rememberSwipeableStateFor$1(t, swipeableState, (Continuation<? super SwipeableKt$rememberSwipeableStateFor$1>) null), composer, (i2 & 8) | 512 | (i2 & 14));
        EffectsKt.DisposableEffect((Object) swipeableState.getCurrentValue(), (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new SwipeableKt$rememberSwipeableStateFor$2(t, swipeableState, function1, forceAnimationCheck), composer, i2 & 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return swipeableState;
    }

    /* renamed from: swipeable-pPrIpRY$default  reason: not valid java name */
    public static /* synthetic */ Modifier m1633swipeablepPrIpRY$default(Modifier modifier, SwipeableState swipeableState, Map map, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, Function2 function2, ResistanceConfig resistanceConfig, float f, int i, Object obj) {
        boolean z3;
        Function2 function22;
        int i2 = i;
        if ((i2 & 8) != 0) {
            z3 = true;
        } else {
            z3 = z;
        }
        boolean z4 = (i2 & 16) != 0 ? false : z2;
        MutableInteractionSource mutableInteractionSource2 = (i2 & 32) != 0 ? null : mutableInteractionSource;
        if ((i2 & 64) != 0) {
            function22 = SwipeableKt$swipeable$1.INSTANCE;
        } else {
            function22 = function2;
        }
        return m1632swipeablepPrIpRY(modifier, swipeableState, map, orientation, z3, z4, mutableInteractionSource2, function22, (i2 & 128) != 0 ? SwipeableDefaults.resistanceConfig$default(SwipeableDefaults.INSTANCE, map.keySet(), 0.0f, 0.0f, 6, (Object) null) : resistanceConfig, (i2 & 256) != 0 ? SwipeableDefaults.INSTANCE.m1631getVelocityThresholdD9Ej5fM() : f);
    }

    /* renamed from: swipeable-pPrIpRY  reason: not valid java name */
    public static final <T> Modifier m1632swipeablepPrIpRY(Modifier $this$swipeable_u2dpPrIpRY, SwipeableState<T> state, Map<Float, ? extends T> anchors, Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource, Function2<? super T, ? super T, ? extends ThresholdConfig> thresholds, ResistanceConfig resistance, float velocityThreshold) {
        Modifier modifier = $this$swipeable_u2dpPrIpRY;
        Intrinsics.checkNotNullParameter(modifier, "$this$swipeable");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(anchors, "anchors");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(thresholds, "thresholds");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SwipeableKt$swipeablepPrIpRY$$inlined$debugInspectorInfo$1(state, anchors, orientation, enabled, reverseDirection, interactionSource, thresholds, resistance, velocityThreshold) : InspectableValueKt.getNoInspectorInfo(), new SwipeableKt$swipeable$3(anchors, state, orientation, enabled, interactionSource, reverseDirection, resistance, thresholds, velocityThreshold));
    }

    /* access modifiers changed from: private */
    public static final List<Float> findBounds(float offset, Set<Float> anchors) {
        float f = offset;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : anchors) {
            if (((double) ((Number) element$iv$iv).floatValue()) <= ((double) f) + 0.001d) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Float a = CollectionsKt.maxOrNull((List) destination$iv$iv);
        Iterable $this$filter$iv = anchors;
        int $i$f$filter = false;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv) {
            Iterable $this$filter$iv2 = $this$filter$iv;
            int $i$f$filter2 = $i$f$filter;
            if (((double) ((Number) element$iv$iv2).floatValue()) >= ((double) f) - 0.001d) {
                destination$iv$iv2.add(element$iv$iv2);
            }
            $this$filter$iv = $this$filter$iv2;
            $i$f$filter = $i$f$filter2;
        }
        int i = $i$f$filter;
        Float b = CollectionsKt.minOrNull((List) destination$iv$iv2);
        if (a == null) {
            return CollectionsKt.listOfNotNull(b);
        }
        if (b == null) {
            return CollectionsKt.listOf(a);
        }
        if (Intrinsics.areEqual(a, b)) {
            return CollectionsKt.listOf(a);
        }
        return CollectionsKt.listOf(a, b);
    }

    /* access modifiers changed from: private */
    public static final float computeTarget(float offset, float lastValue, Set<Float> anchors, Function2<? super Float, ? super Float, Float> thresholds, float velocity, float velocityThreshold) {
        List bounds = findBounds(offset, anchors);
        switch (bounds.size()) {
            case 0:
                return lastValue;
            case 1:
                return bounds.get(0).floatValue();
            default:
                float lower = bounds.get(0).floatValue();
                float upper = bounds.get(1).floatValue();
                if (lastValue <= offset) {
                    if (velocity >= velocityThreshold) {
                        return upper;
                    }
                    if (offset < thresholds.invoke(Float.valueOf(lower), Float.valueOf(upper)).floatValue()) {
                        return lower;
                    }
                } else if (velocity <= (-velocityThreshold) || offset <= thresholds.invoke(Float.valueOf(upper), Float.valueOf(lower)).floatValue()) {
                    return lower;
                }
                return upper;
        }
    }

    /* access modifiers changed from: private */
    public static final <T> Float getOffset(Map<Float, ? extends T> $this$getOffset, T state) {
        Object element$iv;
        Iterator it = $this$getOffset.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            if (Intrinsics.areEqual(((Map.Entry) element$iv).getValue(), (Object) state)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) element$iv;
        if (entry != null) {
            return (Float) entry.getKey();
        }
        return null;
    }

    public static final <T> NestedScrollConnection getPreUpPostDownNestedScrollConnection(SwipeableState<T> $this$PreUpPostDownNestedScrollConnection) {
        Intrinsics.checkNotNullParameter($this$PreUpPostDownNestedScrollConnection, "<this>");
        return new SwipeableKt$PreUpPostDownNestedScrollConnection$1($this$PreUpPostDownNestedScrollConnection);
    }
}
