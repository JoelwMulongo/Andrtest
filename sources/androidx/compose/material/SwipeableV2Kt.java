package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u0000\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00072\u0006\u0010\b\u001a\u00020\tH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a6\u0010\f\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00072\u0006\u0010\r\u001a\u00020\u0003H\u0001\u001aZ\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u0002H\u00102\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142#\b\u0002\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u0011H\u0010¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0001¢\u0006\u0002\u0010\u0019\u001a7\u0010\u001a\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00030\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\u001e\u001a%\u0010\u001f\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0010*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00030\u001bH\u0002¢\u0006\u0002\u0010 \u001a%\u0010!\u001a\u0004\u0018\u00010\u0003\"\u0004\b\u0000\u0010\u0010*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00030\u001bH\u0002¢\u0006\u0002\u0010 \u001a+\u0010\"\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0010*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010#\u001a\u0002H\u0010H\u0002¢\u0006\u0002\u0010$\u001a}\u0010%\u001a\u00020&\"\u0004\b\u0000\u0010\u0010*\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00100)2\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010+28\u0010,\u001a4\u0012\u0013\u0012\u0011H\u0010¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110-¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(.\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0001ø\u0001\u0001\u001aH\u0010/\u001a\u00020&\"\u0004\b\u0000\u0010\u0010*\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000f2\u0006\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u00020\u00182\b\b\u0002\u00103\u001a\u00020\u00182\n\b\u0002\u00104\u001a\u0004\u0018\u000105H\u0001\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00066"}, d2 = {"fixedPositionalThreshold", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "", "Lkotlin/ParameterName;", "name", "distance", "Lkotlin/ExtensionFunctionType;", "threshold", "Landroidx/compose/ui/unit/Dp;", "fixedPositionalThreshold-0680j_4", "(F)Lkotlin/jvm/functions/Function2;", "fractionalPositionalThreshold", "fraction", "rememberSwipeableV2State", "Landroidx/compose/material/SwipeableV2State;", "T", "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmValueChange", "Lkotlin/Function1;", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableV2State;", "closestAnchor", "", "offset", "searchUpwards", "(Ljava/util/Map;FZ)Ljava/lang/Object;", "maxOrNull", "(Ljava/util/Map;)Ljava/lang/Float;", "minOrNull", "requireAnchor", "value", "(Ljava/util/Map;Ljava/lang/Object;)F", "swipeAnchors", "Landroidx/compose/ui/Modifier;", "state", "possibleValues", "", "anchorChangeHandler", "Landroidx/compose/material/AnchorChangeHandler;", "calculateAnchor", "Landroidx/compose/ui/unit/IntSize;", "layoutSize", "swipeableV2", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeableV2.kt */
public final class SwipeableV2Kt {
    public static /* synthetic */ Modifier swipeableV2$default(Modifier modifier, SwipeableV2State swipeableV2State, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, int i, Object obj) {
        boolean z3;
        boolean z4;
        if ((i & 4) != 0) {
            z3 = true;
        } else {
            z3 = z;
        }
        if ((i & 8) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        return swipeableV2(modifier, swipeableV2State, orientation, z3, z4, (i & 16) != 0 ? null : mutableInteractionSource);
    }

    public static final <T> Modifier swipeableV2(Modifier $this$swipeableV2, SwipeableV2State<T> state, Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource) {
        SwipeableV2State<T> swipeableV2State = state;
        Modifier modifier = $this$swipeableV2;
        Intrinsics.checkNotNullParameter($this$swipeableV2, "<this>");
        Intrinsics.checkNotNullParameter(swipeableV2State, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        return DraggableKt.draggable$default($this$swipeableV2, state.getDraggableState$material_release(), orientation, enabled, interactionSource, state.isAnimationRunning(), (Function3) null, new SwipeableV2Kt$swipeableV2$1(swipeableV2State, (Continuation<? super SwipeableV2Kt$swipeableV2$1>) null), reverseDirection, 32, (Object) null);
    }

    public static /* synthetic */ Modifier swipeAnchors$default(Modifier modifier, SwipeableV2State swipeableV2State, Set set, AnchorChangeHandler anchorChangeHandler, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            anchorChangeHandler = null;
        }
        return swipeAnchors(modifier, swipeableV2State, set, anchorChangeHandler, function2);
    }

    public static final <T> Modifier swipeAnchors(Modifier $this$swipeAnchors, SwipeableV2State<T> state, Set<? extends T> possibleValues, AnchorChangeHandler<T> anchorChangeHandler, Function2<? super T, ? super IntSize, Float> calculateAnchor) {
        Intrinsics.checkNotNullParameter($this$swipeAnchors, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(possibleValues, "possibleValues");
        Intrinsics.checkNotNullParameter(calculateAnchor, "calculateAnchor");
        return $this$swipeAnchors.then(new SwipeAnchorsModifier(new SwipeableV2Kt$swipeAnchors$1(state), new SwipeableV2Kt$swipeAnchors$2(state, possibleValues, anchorChangeHandler, calculateAnchor), InspectableValueKt.isDebugInspectorInfoEnabled() ? new SwipeableV2Kt$swipeAnchors$$inlined$debugInspectorInfo$1(state, possibleValues, anchorChangeHandler, calculateAnchor) : InspectableValueKt.getNoInspectorInfo()));
    }

    public static final <T> SwipeableV2State<T> rememberSwipeableV2State(T initialValue, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> confirmValueChange, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-1791789117);
        ComposerKt.sourceInformation($composer, "C(rememberSwipeableV2State)P(2)482@20279L698:SwipeableV2.kt#jmzs0o");
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i & 2) != 0) {
            animationSpec2 = SwipeableV2Defaults.INSTANCE.getAnimationSpec();
        }
        Function1<? super T, Boolean> confirmValueChange2 = confirmValueChange;
        if ((i & 4) != 0) {
            confirmValueChange2 = SwipeableV2Kt$rememberSwipeableV2State$1.INSTANCE;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1791789117, $changed, -1, "androidx.compose.material.rememberSwipeableV2State (SwipeableV2.kt:477)");
        }
        SwipeableV2State<T> swipeableV2State = (SwipeableV2State) RememberSaveableKt.rememberSaveable(new Object[]{initialValue, animationSpec2, confirmValueChange2}, SwipeableV2State.Companion.m1643SavereqLRuRQ(animationSpec2, confirmValueChange2, SwipeableV2Defaults.INSTANCE.getPositionalThreshold(), SwipeableV2Defaults.INSTANCE.m1639getVelocityThresholdD9Ej5fM()), (String) null, new SwipeableV2Kt$rememberSwipeableV2State$2(initialValue, animationSpec2, confirmValueChange2), $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return swipeableV2State;
    }

    /* renamed from: fixedPositionalThreshold-0680j_4  reason: not valid java name */
    public static final Function2<Density, Float, Float> m1640fixedPositionalThreshold0680j_4(float threshold) {
        return new SwipeableV2Kt$fixedPositionalThreshold$1(threshold);
    }

    public static final Function2<Density, Float, Float> fractionalPositionalThreshold(float fraction) {
        return new SwipeableV2Kt$fractionalPositionalThreshold$1(fraction);
    }

    static /* synthetic */ Object closestAnchor$default(Map map, float f, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return closestAnchor(map, f, z);
    }

    /* access modifiers changed from: private */
    public static final <T> T closestAnchor(Map<T, Float> $this$closestAnchor, float offset, boolean searchUpwards) {
        if (!$this$closestAnchor.isEmpty()) {
            Iterator it = $this$closestAnchor.entrySet().iterator();
            if (it.hasNext()) {
                Object next = it.next();
                if (it.hasNext()) {
                    float anchor = ((Number) ((Map.Entry) next).getValue()).floatValue();
                    float delta = searchUpwards ? anchor - offset : offset - anchor;
                    if (delta < 0.0f) {
                        delta = Float.POSITIVE_INFINITY;
                    }
                    do {
                        Object next2 = it.next();
                        float anchor2 = ((Number) ((Map.Entry) next2).getValue()).floatValue();
                        float delta2 = searchUpwards ? anchor2 - offset : offset - anchor2;
                        if (delta2 < 0.0f) {
                            delta2 = Float.POSITIVE_INFINITY;
                        }
                        if (Float.compare(delta, delta2) > 0) {
                            next = next2;
                            delta = delta2;
                        }
                    } while (it.hasNext());
                }
                return ((Map.Entry) next).getKey();
            }
            throw new NoSuchElementException();
        }
        throw new IllegalArgumentException("The anchors were empty when trying to find the closest anchor".toString());
    }

    /* access modifiers changed from: private */
    public static final <T> Float minOrNull(Map<T, Float> $this$minOrNull) {
        Iterator it = $this$minOrNull.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
        while (it.hasNext() != 0) {
            floatValue = Math.min(floatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* access modifiers changed from: private */
    public static final <T> Float maxOrNull(Map<T, Float> $this$maxOrNull) {
        Iterator it = $this$maxOrNull.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = ((Number) ((Map.Entry) it.next()).getValue()).floatValue();
        while (it.hasNext() != 0) {
            floatValue = Math.max(floatValue, ((Number) ((Map.Entry) it.next()).getValue()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    private static final <T> float requireAnchor(Map<T, Float> $this$requireAnchor, T value) {
        Float f = $this$requireAnchor.get(value);
        if (f != null) {
            return f.floatValue();
        }
        throw new IllegalArgumentException(("Required anchor " + value + " was not found in anchors. Current anchors: " + MapsKt.toMap($this$requireAnchor)).toString());
    }
}
