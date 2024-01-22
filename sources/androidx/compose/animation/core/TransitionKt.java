package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a-\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a3\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\n2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000b\u001a\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u000e0\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001c0\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001f0\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020!0\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020#0\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020%0\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00032*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020'0\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u001a©\u0001\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00040\r\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0004\"\b\b\u0002\u0010)*\u00020**\b\u0012\u0004\u0012\u0002H\u000f0\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H)0,2*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u0002H\u00040\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0000¢\u0006\u0002\u0010-\u001a_\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u000f0\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072&\u0010/\u001a\"\u0012\u0013\u0012\u0011H\u000f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(0\u0012\u0004\u0012\u0002H\u00040\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0000¢\u0006\u0002\u00101\u001aA\u00102\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u000f0\u00032\u0006\u00103\u001a\u0002H\u00042\u0006\u0010\u0005\u001a\u0002H\u00042\u0006\u00104\u001a\u00020\u0007H\u0001¢\u0006\u0002\u00105\u001aa\u00106\u001a\u0018\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H)07R\b\u0012\u0004\u0012\u0002H\u000f0\u0003\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0004\"\b\b\u0002\u0010)*\u00020**\b\u0012\u0004\u0012\u0002H\u000f0\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H)0,2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u00108\u001am\u00109\u001a\b\u0012\u0004\u0012\u0002H\u00040\r\"\u0004\b\u0000\u0010\u000f\"\u0004\b\u0001\u0010\u0004\"\b\b\u0002\u0010)*\u00020**\b\u0012\u0004\u0012\u0002H\u000f0\u00032\u0006\u0010:\u001a\u0002H\u00042\u0006\u0010;\u001a\u0002H\u00042\f\u0010<\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00132\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H)0,2\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010=\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b20\u0001\n\u0002\b\u0019¨\u0006>"}, d2 = {"AnimationDebugDurationScale", "", "updateTransition", "Landroidx/compose/animation/core/Transition;", "T", "targetState", "label", "", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "transitionState", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "animateDp", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/unit/Dp;", "S", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animateFloat", "", "animateInt", "animateIntOffset", "Landroidx/compose/ui/unit/IntOffset;", "animateIntSize", "Landroidx/compose/ui/unit/IntSize;", "animateOffset", "Landroidx/compose/ui/geometry/Offset;", "animateRect", "Landroidx/compose/ui/geometry/Rect;", "animateSize", "Landroidx/compose/ui/geometry/Size;", "animateValue", "V", "Landroidx/compose/animation/core/AnimationVector;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "createChildTransition", "transformToChildState", "parentState", "(Landroidx/compose/animation/core/Transition;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "createChildTransitionInternal", "initialState", "childLabel", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/Transition;", "createDeferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition$DeferredAnimation;", "createTransitionAnimation", "initialValue", "targetValue", "animationSpec", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
public final class TransitionKt {
    public static final int AnimationDebugDurationScale = 1;

    public static final <T> Transition<T> updateTransition(T targetState, String label, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Object value$iv$iv2;
        $composer.startReplaceableGroup(2029166765);
        ComposerKt.sourceInformation($composer, "C(updateTransition)P(1)70@2894L51,71@2961L22,72@3017L195,72@2988L224:Transition.kt#pdpnli");
        if ((i & 2) != 0) {
            label = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2029166765, $changed, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:66)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = new Transition(targetState, label);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Transition transition = (Transition) value$iv$iv;
        transition.animateTo$animation_core_release(targetState, $composer, ($changed & 8) | 48 | ($changed & 14));
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) transition);
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv2 = (Function1) new TransitionKt$updateTransition$1$1(transition);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        EffectsKt.DisposableEffect((Object) transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) value$iv$iv2, $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return transition;
    }

    public static final <T> Transition<T> updateTransition(MutableTransitionState<T> transitionState, String label, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Intrinsics.checkNotNullParameter(transitionState, "transitionState");
        $composer.startReplaceableGroup(882913843);
        ComposerKt.sourceInformation($composer, "C(updateTransition)P(1)153@6566L94,156@6676L38,157@6748L195,157@6719L224:Transition.kt#pdpnli");
        if ((i & 2) != 0) {
            label = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(882913843, $changed, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:149)");
        }
        int i2 = $changed & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) transitionState);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = new Transition(transitionState, label);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Transition transition = (Transition) value$iv$iv;
        transition.animateTo$animation_core_release(transitionState.getTargetState(), $composer, 0);
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = $composer.changed((Object) transition);
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv2 = (Function1) new TransitionKt$updateTransition$2$1(transition);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        EffectsKt.DisposableEffect((Object) transition, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) value$iv$iv2, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return transition;
    }

    public static final <S, T, V extends AnimationVector> Transition<S>.DeferredAnimation<T, V> createDeferredAnimation(Transition<S> $this$createDeferredAnimation, TwoWayConverter<T, V> typeConverter, String label, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter($this$createDeferredAnimation, "<this>");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        $composer.startReplaceableGroup(-1714122528);
        ComposerKt.sourceInformation($composer, "C(createDeferredAnimation)P(1)752@29607L58,753@29670L102:Transition.kt#pdpnli");
        if ((i & 2) != 0) {
            label = "DeferredAnimation";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1714122528, $changed, -1, "androidx.compose.animation.core.createDeferredAnimation (Transition.kt:748)");
        }
        int i2 = $changed & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) $this$createDeferredAnimation);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = new Transition.DeferredAnimation($this$createDeferredAnimation, typeConverter, label);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Transition.DeferredAnimation lazyAnim = (Transition.DeferredAnimation) value$iv$iv;
        EffectsKt.DisposableEffect((Object) lazyAnim, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new TransitionKt$createDeferredAnimation$1($this$createDeferredAnimation, lazyAnim), $composer, 0);
        if ($this$createDeferredAnimation.isSeeking()) {
            lazyAnim.setupSeeking$animation_core_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return lazyAnim;
    }

    public static final <S, T> Transition<T> createChildTransition(Transition<S> $this$createChildTransition, String label, Function3<? super S, ? super Composer, ? super Integer, ? extends T> transformToChildState, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter($this$createChildTransition, "<this>");
        Intrinsics.checkNotNullParameter(transformToChildState, "transformToChildState");
        $composer.startReplaceableGroup(1215497572);
        ComposerKt.sourceInformation($composer, "CC(createChildTransition)785@31111L36,786@31171L74,787@31268L39,788@31319L63:Transition.kt#pdpnli");
        if ((i & 1) != 0) {
            label = "ChildTransition";
        }
        int i2 = $changed & 14;
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed((Object) $this$createChildTransition);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = $this$createChildTransition.getCurrentState();
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Transition<T> createChildTransitionInternal = createChildTransitionInternal($this$createChildTransition, transformToChildState.invoke($this$createChildTransition.isSeeking() ? $this$createChildTransition.getCurrentState() : value$iv$iv, $composer, Integer.valueOf(($changed >> 3) & 112)), transformToChildState.invoke($this$createChildTransition.getTargetState(), $composer, Integer.valueOf(($changed >> 3) & 112)), label, $composer, ($changed & 14) | (($changed << 6) & 7168));
        $composer.endReplaceableGroup();
        return createChildTransitionInternal;
    }

    public static final <S, T> Transition<T> createChildTransitionInternal(Transition<S> $this$createChildTransitionInternal, T initialState, T targetState, String childLabel, Composer $composer, int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Transition<S> transition = $this$createChildTransitionInternal;
        T t = initialState;
        T t2 = targetState;
        String str = childLabel;
        Composer composer = $composer;
        int i = $changed;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(str, "childLabel");
        composer.startReplaceableGroup(-198307638);
        ComposerKt.sourceInformation(composer, "C(createChildTransitionInternal)P(1,2)798@31582L110,802@31727L112,802@31698L141,816@32061L25:Transition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-198307638, i, -1, "androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:793)");
        }
        int $changed$iv = i & 14;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) transition);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            int i2 = $changed$iv;
            value$iv$iv = new Transition(new MutableTransitionState(t), $this$createChildTransitionInternal.getLabel() + " > " + str);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            int i3 = $changed$iv;
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        Transition transition2 = (Transition) value$iv$iv;
        int i4 = i & 14;
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = composer.changed((Object) transition) | composer.changed((Object) transition2);
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv2 == Composer.Companion.getEmpty()) {
            value$iv$iv2 = (Function1) new TransitionKt$createChildTransitionInternal$1$1(transition, transition2);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
        } else {
            value$iv$iv2 = it$iv$iv2;
        }
        $composer.endReplaceableGroup();
        EffectsKt.DisposableEffect((Object) transition2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) value$iv$iv2, composer, 0);
        if ($this$createChildTransitionInternal.isSeeking()) {
            transition2.seek(t, t2, $this$createChildTransitionInternal.getLastSeekedTimeNanos$animation_core_release());
        } else {
            transition2.updateTarget$animation_core_release(t2, composer, ((i >> 3) & 8) | ((i >> 6) & 14));
            transition2.setSeeking$animation_core_release(false);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return transition2;
    }

    public static final <S, T, V extends AnimationVector> State<T> animateValue(Transition<S> $this$animateValue, TwoWayConverter<T, V> typeConverter, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<T>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, ? extends T> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Function3<? super S, ? super Composer, ? super Integer, ? extends T> function3 = targetValueByState;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$animateValue, "<this>");
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(function3, "targetValueByState");
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
        Function3 transitionSpec2 = (i & 2) != 0 ? TransitionKt$animateValue$1.INSTANCE : transitionSpec;
        if ((i & 4) != 0) {
            label2 = "ValueAnimation";
        } else {
            label2 = label;
        }
        State<T> createTransitionAnimation = createTransitionAnimation($this$animateValue, function3.invoke($this$animateValue.getCurrentState(), composer, Integer.valueOf(($changed >> 9) & 112)), function3.invoke($this$animateValue.getTargetState(), composer, Integer.valueOf(($changed >> 9) & 112)), (FiniteAnimationSpec) transitionSpec2.invoke($this$animateValue.getSegment(), composer, Integer.valueOf(($changed >> 3) & 112)), typeConverter, label2, $composer, ($changed & 14) | (57344 & ($changed << 9)) | (($changed << 6) & 458752));
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S, T, V extends AnimationVector> State<T> createTransitionAnimation(Transition<S> $this$createTransitionAnimation, T initialValue, T targetValue, FiniteAnimationSpec<T> animationSpec, TwoWayConverter<T, V> typeConverter, String label, Composer $composer, int $changed) {
        Object value$iv$iv;
        Transition<S> transition = $this$createTransitionAnimation;
        T t = targetValue;
        FiniteAnimationSpec<T> finiteAnimationSpec = animationSpec;
        TwoWayConverter<T, V> twoWayConverter = typeConverter;
        Composer composer = $composer;
        int i = $changed;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(label, "label");
        composer.startReplaceableGroup(-304821198);
        ComposerKt.sourceInformation(composer, "C(createTransitionAnimation)P(1,3!1,4)872@34615L499,895@35498L128,895@35460L166:Transition.kt#pdpnli");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-304821198, i, -1, "androidx.compose.animation.core.createTransitionAnimation (Transition.kt:865)");
        }
        int i2 = i & 14;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) transition);
        Composer $this$cache$iv$iv = $composer;
        Object value$iv$iv2 = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || value$iv$iv2 == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv2;
            value$iv$iv2 = new Transition.TransitionAnimationState($this$createTransitionAnimation, initialValue, AnimationStateKt.createZeroVectorFrom(twoWayConverter, t), typeConverter, label);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv2);
        } else {
            Object obj2 = value$iv$iv2;
            Composer composer2 = $this$cache$iv$iv;
        }
        $composer.endReplaceableGroup();
        Transition.TransitionAnimationState transitionAnimation = (Transition.TransitionAnimationState) value$iv$iv2;
        if ($this$createTransitionAnimation.isSeeking()) {
            transitionAnimation.updateInitialAndTargetValue$animation_core_release(initialValue, t, finiteAnimationSpec);
        } else {
            T t2 = initialValue;
            transitionAnimation.updateTargetValue$animation_core_release(t, finiteAnimationSpec);
        }
        int i3 = i & 14;
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2):Composables.kt#9igjgp");
        boolean invalid$iv$iv2 = composer.changed((Object) transition) | composer.changed((Object) transitionAnimation);
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv2 || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function1) new TransitionKt$createTransitionAnimation$1$1(transition, transitionAnimation);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        EffectsKt.DisposableEffect((Object) transitionAnimation, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) value$iv$iv, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return transitionAnimation;
    }

    public static final <S> State<Float> animateFloat(Transition<S> $this$animateFloat, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Float>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, Float> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Function3<? super S, ? super Composer, ? super Integer, Float> function3 = targetValueByState;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$animateFloat, "<this>");
        Intrinsics.checkNotNullParameter(function3, "targetValueByState");
        composer.startReplaceableGroup(-1338768149);
        ComposerKt.sourceInformation(composer, "CC(animateFloat)P(2)938@37489L78:Transition.kt#pdpnli");
        Function3 transitionSpec2 = (i & 1) != 0 ? TransitionKt$animateFloat$1.INSTANCE : transitionSpec;
        if ((i & 2) != 0) {
            label2 = "FloatAnimation";
        } else {
            label2 = label;
        }
        TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
        Transition $this$animateValue$iv = $this$animateFloat;
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
        State<Float> createTransitionAnimation = createTransitionAnimation($this$animateValue$iv, function3.invoke($this$animateValue$iv.getCurrentState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), function3.invoke($this$animateValue$iv.getTargetState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), (FiniteAnimationSpec) transitionSpec2.invoke($this$animateValue$iv.getSegment(), composer, Integer.valueOf(($changed$iv >> 3) & 112)), vectorConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<Dp> animateDp(Transition<S> $this$animateDp, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Dp>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, Dp> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Function3<? super S, ? super Composer, ? super Integer, Dp> function3 = targetValueByState;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$animateDp, "<this>");
        Intrinsics.checkNotNullParameter(function3, "targetValueByState");
        composer.startReplaceableGroup(184732935);
        ComposerKt.sourceInformation(composer, "CC(animateDp)P(2)969@39203L75:Transition.kt#pdpnli");
        Function3 transitionSpec2 = (i & 1) != 0 ? TransitionKt$animateDp$1.INSTANCE : transitionSpec;
        if ((i & 2) != 0) {
            label2 = "DpAnimation";
        } else {
            label2 = label;
        }
        TwoWayConverter<Dp, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(Dp.Companion);
        Transition $this$animateValue$iv = $this$animateDp;
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
        State<Dp> createTransitionAnimation = createTransitionAnimation($this$animateValue$iv, function3.invoke($this$animateValue$iv.getCurrentState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), function3.invoke($this$animateValue$iv.getTargetState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), (FiniteAnimationSpec) transitionSpec2.invoke($this$animateValue$iv.getSegment(), composer, Integer.valueOf(($changed$iv >> 3) & 112)), vectorConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<Offset> animateOffset(Transition<S> $this$animateOffset, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Offset>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, Offset> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Function3<? super S, ? super Composer, ? super Integer, Offset> function3 = targetValueByState;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$animateOffset, "<this>");
        Intrinsics.checkNotNullParameter(function3, "targetValueByState");
        composer.startReplaceableGroup(2078477582);
        ComposerKt.sourceInformation(composer, "CC(animateOffset)P(2)1000@40943L79:Transition.kt#pdpnli");
        Function3 transitionSpec2 = (i & 1) != 0 ? TransitionKt$animateOffset$1.INSTANCE : transitionSpec;
        if ((i & 2) != 0) {
            label2 = "OffsetAnimation";
        } else {
            label2 = label;
        }
        TwoWayConverter<Offset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Offset.Companion);
        Transition $this$animateValue$iv = $this$animateOffset;
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
        State<Offset> createTransitionAnimation = createTransitionAnimation($this$animateValue$iv, function3.invoke($this$animateValue$iv.getCurrentState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), function3.invoke($this$animateValue$iv.getTargetState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), (FiniteAnimationSpec) transitionSpec2.invoke($this$animateValue$iv.getSegment(), composer, Integer.valueOf(($changed$iv >> 3) & 112)), vectorConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<Size> animateSize(Transition<S> $this$animateSize, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Size>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, Size> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Function3<? super S, ? super Composer, ? super Integer, Size> function3 = targetValueByState;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$animateSize, "<this>");
        Intrinsics.checkNotNullParameter(function3, "targetValueByState");
        composer.startReplaceableGroup(-802210820);
        ComposerKt.sourceInformation(composer, "CC(animateSize)P(2)1031@42672L77:Transition.kt#pdpnli");
        Function3 transitionSpec2 = (i & 1) != 0 ? TransitionKt$animateSize$1.INSTANCE : transitionSpec;
        if ((i & 2) != 0) {
            label2 = "SizeAnimation";
        } else {
            label2 = label;
        }
        TwoWayConverter<Size, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(Size.Companion);
        Transition $this$animateValue$iv = $this$animateSize;
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
        State<Size> createTransitionAnimation = createTransitionAnimation($this$animateValue$iv, function3.invoke($this$animateValue$iv.getCurrentState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), function3.invoke($this$animateValue$iv.getTargetState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), (FiniteAnimationSpec) transitionSpec2.invoke($this$animateValue$iv.getSegment(), composer, Integer.valueOf(($changed$iv >> 3) & 112)), vectorConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<IntOffset> animateIntOffset(Transition<S> $this$animateIntOffset, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntOffset>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, IntOffset> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Function3<? super S, ? super Composer, ? super Integer, IntOffset> function3 = targetValueByState;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$animateIntOffset, "<this>");
        Intrinsics.checkNotNullParameter(function3, "targetValueByState");
        composer.startReplaceableGroup(776131825);
        ComposerKt.sourceInformation(composer, "CC(animateIntOffset)P(2)1062@44420L82:Transition.kt#pdpnli");
        Function3 transitionSpec2 = (i & 1) != 0 ? TransitionKt$animateIntOffset$1.INSTANCE : transitionSpec;
        if ((i & 2) != 0) {
            label2 = "IntOffsetAnimation";
        } else {
            label2 = label;
        }
        TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
        Transition $this$animateValue$iv = $this$animateIntOffset;
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
        State<IntOffset> createTransitionAnimation = createTransitionAnimation($this$animateValue$iv, function3.invoke($this$animateValue$iv.getCurrentState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), function3.invoke($this$animateValue$iv.getTargetState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), (FiniteAnimationSpec) transitionSpec2.invoke($this$animateValue$iv.getSegment(), composer, Integer.valueOf(($changed$iv >> 3) & 112)), vectorConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<Integer> animateInt(Transition<S> $this$animateInt, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Integer>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, Integer> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Function3<? super S, ? super Composer, ? super Integer, Integer> function3 = targetValueByState;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$animateInt, "<this>");
        Intrinsics.checkNotNullParameter(function3, "targetValueByState");
        composer.startReplaceableGroup(1318902782);
        ComposerKt.sourceInformation(composer, "CC(animateInt)P(2)1093@46123L76:Transition.kt#pdpnli");
        Function3 transitionSpec2 = (i & 1) != 0 ? TransitionKt$animateInt$1.INSTANCE : transitionSpec;
        if ((i & 2) != 0) {
            label2 = "IntAnimation";
        } else {
            label2 = label;
        }
        TwoWayConverter<Integer, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
        Transition $this$animateValue$iv = $this$animateInt;
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
        State<Integer> createTransitionAnimation = createTransitionAnimation($this$animateValue$iv, function3.invoke($this$animateValue$iv.getCurrentState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), function3.invoke($this$animateValue$iv.getTargetState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), (FiniteAnimationSpec) transitionSpec2.invoke($this$animateValue$iv.getSegment(), composer, Integer.valueOf(($changed$iv >> 3) & 112)), vectorConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<IntSize> animateIntSize(Transition<S> $this$animateIntSize, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<IntSize>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, IntSize> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Function3<? super S, ? super Composer, ? super Integer, IntSize> function3 = targetValueByState;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$animateIntSize, "<this>");
        Intrinsics.checkNotNullParameter(function3, "targetValueByState");
        composer.startReplaceableGroup(-2104123233);
        ComposerKt.sourceInformation(composer, "CC(animateIntSize)P(2)1123@47852L80:Transition.kt#pdpnli");
        Function3 transitionSpec2 = (i & 1) != 0 ? TransitionKt$animateIntSize$1.INSTANCE : transitionSpec;
        if ((i & 2) != 0) {
            label2 = "IntSizeAnimation";
        } else {
            label2 = label;
        }
        TwoWayConverter<IntSize, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntSize.Companion);
        Transition $this$animateValue$iv = $this$animateIntSize;
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
        State<IntSize> createTransitionAnimation = createTransitionAnimation($this$animateValue$iv, function3.invoke($this$animateValue$iv.getCurrentState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), function3.invoke($this$animateValue$iv.getTargetState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), (FiniteAnimationSpec) transitionSpec2.invoke($this$animateValue$iv.getSegment(), composer, Integer.valueOf(($changed$iv >> 3) & 112)), vectorConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    public static final <S> State<Rect> animateRect(Transition<S> $this$animateRect, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Rect>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, Rect> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Function3<? super S, ? super Composer, ? super Integer, Rect> function3 = targetValueByState;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$animateRect, "<this>");
        Intrinsics.checkNotNullParameter(function3, "targetValueByState");
        composer.startReplaceableGroup(1496278239);
        ComposerKt.sourceInformation(composer, "CC(animateRect)P(2)1153@49578L77:Transition.kt#pdpnli");
        Function3 transitionSpec2 = (i & 1) != 0 ? TransitionKt$animateRect$1.INSTANCE : transitionSpec;
        if ((i & 2) != 0) {
            label2 = "RectAnimation";
        } else {
            label2 = label;
        }
        TwoWayConverter<Rect, AnimationVector4D> vectorConverter = VectorConvertersKt.getVectorConverter(Rect.Companion);
        Transition $this$animateValue$iv = $this$animateRect;
        int $changed$iv = (($changed << 3) & 57344) | ($changed & 14) | (($changed << 3) & 896) | (($changed << 3) & 7168);
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
        State<Rect> createTransitionAnimation = createTransitionAnimation($this$animateValue$iv, function3.invoke($this$animateValue$iv.getCurrentState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), function3.invoke($this$animateValue$iv.getTargetState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), (FiniteAnimationSpec) transitionSpec2.invoke($this$animateValue$iv.getSegment(), composer, Integer.valueOf(($changed$iv >> 3) & 112)), vectorConverter, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (($changed$iv << 6) & 458752));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }
}
