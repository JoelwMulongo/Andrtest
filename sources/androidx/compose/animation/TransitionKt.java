package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001aG\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u001a\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2*\b\n\u0010\u0010\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\n\u001a\u00020\u000b2&\u0010\u0016\u001a\"\u0012\u0013\u0012\u0011H\u000e¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00020\u0011¢\u0006\u0002\b\u0014H\bø\u0001\u0002ø\u0001\u0001¢\u0006\u0002\u0010\u001a\u0002\u0012\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006\u001b"}, d2 = {"animateColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/InfiniteTransition;", "initialValue", "targetValue", "animationSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "animateColor-RIQooxk", "(Landroidx/compose/animation/core/InfiniteTransition;JJLandroidx/compose/animation/core/InfiniteRepeatableSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "label", "", "animateColor-DTcfvLk", "(Landroidx/compose/animation/core/InfiniteTransition;JJLandroidx/compose/animation/core/InfiniteRepeatableSpec;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "S", "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function3;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
public final class TransitionKt {
    public static final <S> State<Color> animateColor(Transition<S> $this$animateColor, Function3<? super Transition.Segment<S>, ? super Composer, ? super Integer, ? extends FiniteAnimationSpec<Color>> transitionSpec, String label, Function3<? super S, ? super Composer, ? super Integer, Color> targetValueByState, Composer $composer, int $changed, int i) {
        String label2;
        Object value$iv$iv;
        Function3<? super S, ? super Composer, ? super Integer, Color> function3 = targetValueByState;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$animateColor, "<this>");
        Intrinsics.checkNotNullParameter(function3, "targetValueByState");
        composer.startReplaceableGroup(-1939694975);
        ComposerKt.sourceInformation(composer, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
        Function3 transitionSpec2 = (i & 1) != 0 ? TransitionKt$animateColor$1.INSTANCE : transitionSpec;
        if ((i & 2) != 0) {
            label2 = "ColorAnimation";
        } else {
            label2 = label;
        }
        ColorSpace colorSpace = Color.m3168getColorSpaceimpl(function3.invoke($this$animateColor.getTargetState(), composer, Integer.valueOf(($changed >> 6) & 112)).m3174unboximpl());
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) colorSpace);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpace);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        int $changed$iv = ($changed & 14) | 64 | (($changed << 3) & 896) | (($changed << 3) & 7168) | (($changed << 3) & 57344);
        Transition $this$animateValue$iv = $this$animateColor;
        composer.startReplaceableGroup(-142660079);
        ComposerKt.sourceInformation(composer, "CC(animateValue)P(3,2)856@34079L32,857@34134L31,858@34190L23,860@34226L89:Transition.kt#pdpnli");
        State<Color> createTransitionAnimation = androidx.compose.animation.core.TransitionKt.createTransitionAnimation($this$animateValue$iv, function3.invoke($this$animateValue$iv.getCurrentState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), function3.invoke($this$animateValue$iv.getTargetState(), composer, Integer.valueOf(($changed$iv >> 9) & 112)), (FiniteAnimationSpec) transitionSpec2.invoke($this$animateValue$iv.getSegment(), composer, Integer.valueOf(($changed$iv >> 3) & 112)), (TwoWayConverter) value$iv$iv, label2, $composer, ($changed$iv & 14) | (57344 & ($changed$iv << 9)) | (458752 & ($changed$iv << 6)));
        $composer.endReplaceableGroup();
        $composer.endReplaceableGroup();
        return createTransitionAnimation;
    }

    /* renamed from: animateColor-DTcfvLk  reason: not valid java name */
    public static final State<Color> m376animateColorDTcfvLk(InfiniteTransition $this$animateColor_u2dDTcfvLk, long initialValue, long targetValue, InfiniteRepeatableSpec<Color> animationSpec, String label, Composer $composer, int $changed, int i) {
        Object value$iv$iv;
        Composer composer = $composer;
        int i2 = $changed;
        InfiniteTransition infiniteTransition = $this$animateColor_u2dDTcfvLk;
        Intrinsics.checkNotNullParameter($this$animateColor_u2dDTcfvLk, "$this$animateColor");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        composer.startReplaceableGroup(1901963533);
        ComposerKt.sourceInformation(composer, "C(animateColor)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color)102@4596L72,105@4680L72:Transition.kt#xbi5r1");
        String label2 = (i & 8) != 0 ? "ColorAnimation" : label;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1901963533, i2, -1, "androidx.compose.animation.animateColor (Transition.kt:96)");
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.m3168getColorSpaceimpl(targetValue));
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        State<Color> animateValue = InfiniteTransitionKt.animateValue($this$animateColor_u2dDTcfvLk, Color.m3154boximpl(initialValue), Color.m3154boximpl(targetValue), (TwoWayConverter) value$iv$iv, animationSpec, label2, $composer, InfiniteTransition.$stable | 4096 | (i2 & 14) | (i2 & 112) | (i2 & 896) | (InfiniteRepeatableSpec.$stable << 12) | ((i2 << 3) & 57344) | (458752 & (i2 << 3)), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return animateValue;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animateColor APIs now have a new label parameter added.")
    /* renamed from: animateColor-RIQooxk  reason: not valid java name */
    public static final /* synthetic */ State m377animateColorRIQooxk(InfiniteTransition $this$animateColor_u2dRIQooxk, long initialValue, long targetValue, InfiniteRepeatableSpec animationSpec, Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        InfiniteTransition infiniteTransition = $this$animateColor_u2dRIQooxk;
        Intrinsics.checkNotNullParameter($this$animateColor_u2dRIQooxk, "$this$animateColor");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        composer.startReplaceableGroup(1400583834);
        ComposerKt.sourceInformation(composer, "C(animateColor)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color)117@5040L143:Transition.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1400583834, i, -1, "androidx.compose.animation.animateColor (Transition.kt:113)");
        }
        State<Color> r0 = m376animateColorDTcfvLk($this$animateColor_u2dRIQooxk, initialValue, targetValue, animationSpec, "ColorAnimation", $composer, InfiniteTransition.$stable | 24576 | (i & 14) | (i & 112) | (i & 896) | (InfiniteRepeatableSpec.$stable << 9) | (i & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r0;
    }
}
