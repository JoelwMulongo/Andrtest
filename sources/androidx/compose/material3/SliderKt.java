package androidx.compose.material3;

import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000º\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0018\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010\u001f\u001a\u00020 2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010%\u001ae\u0010&\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00101\u001a±\u0001\u00102\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b52\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010\u001f\u001a\u00020 2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u00106\u001a\u00020-2\u0019\b\u0002\u00107\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b5H\u0007¢\u0006\u0002\u00108\u001a}\u00102\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010\u001f\u001a\u00020 2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u00106\u001a\u00020-H\u0007¢\u0006\u0002\u00109\u001a\u0001\u00102\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010\u001f\u001a\u00020 2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u00106\u001a\u00020-2\u0017\u00107\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b5H\u0007¢\u0006\u0002\u0010:\u001a\u0001\u0010;\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00106\u001a\u00020-2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0017\u00107\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b52\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b5H\u0003¢\u0006\u0002\u0010<\u001aU\u0010=\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\bH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a1\u0010B\u001a\u00020\u00162\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010H\u001a \u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\bH\u0002\u001a0\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\bH\u0002\u001a<\u0010M\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010N\u001a\u00020\b2\u0006\u0010O\u001a\u00020\b2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\bH\u0002\u001a(\u0010T\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010U\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0002\u001a\u0010\u0010W\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020 H\u0002\u001a?\u0010X\u001a\u00020\u0016*\u00020Y2\u0006\u0010Z\u001a\u00020\u00032\u001c\u0010[\u001a\u0018\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020\u00160\u001a¢\u0006\u0002\b5¢\u0006\u0002\b\\H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b]\u0010^\u001a;\u0010_\u001a\u0010\u0012\u0004\u0012\u00020a\u0012\u0004\u0012\u00020\b\u0018\u00010`*\u00020b2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020fH@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\bg\u0010h\u001a\u0001\u0010i\u001a\u00020\u0001*\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\b0k2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\b0k2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010m\u001a\u00020\u001d2\u0006\u0010V\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0018\u0010n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00160\u001a0k2\u001e\u0010o\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160p0kH\u0002\u001a\\\u0010q\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\"2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\b\b\u0002\u0010\u001f\u001a\u00020 H\u0002\u001ad\u0010r\u001a\u00020\u0001*\u00020\u00012\u0006\u0010C\u001a\u00020D2\u0006\u00106\u001a\u00020-2\u0006\u0010V\u001a\u00020 2\u0006\u0010m\u001a\u00020\u001d2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\b0k2\u0012\u0010n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\"0k2\f\u0010t\u001a\b\u0012\u0004\u0012\u00020\b0u2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\n\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u000b\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\f\u001a\u00020\rX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000e\"\u0019\u0010\u000f\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\u0011\"\u0013\u0010\u0012\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0019\u0010\u0013\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0014\u0010\u0011\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006v"}, d2 = {"DefaultSliderConstraints", "Landroidx/compose/ui/Modifier;", "SliderHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SliderMinWidth", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "", "ThumbDefaultElevation", "ThumbHeight", "ThumbPressedElevation", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "ThumbWidth", "getThumbWidth", "()F", "TickSize", "TrackHeight", "getTrackHeight", "RangeSlider", "", "value", "Lkotlin/ranges/ClosedFloatingPointRange;", "onValueChange", "Lkotlin/Function1;", "modifier", "enabled", "", "valueRange", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material3/SliderColors;", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "positionFractionStart", "positionFractionEnd", "tickFractions", "", "width", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumbSemantics", "endThumbSemantics", "(ZFF[FLandroidx/compose/material3/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Slider", "track", "Landroidx/compose/material3/SliderPositions;", "Landroidx/compose/runtime/Composable;", "interactionSource", "thumb", "(FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;IFLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "TempRangeSliderTrack", "thumbWidth", "trackStrokeWidth", "TempRangeSliderTrack-au3_HiA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZFF[FFFLandroidx/compose/runtime/Composer;I)V", "animateToTarget", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "current", "target", "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calcFraction", "a", "b", "pos", "scale", "a1", "b1", "x1", "a2", "b2", "x", "snapValueToTick", "minPx", "maxPx", "stepsToTickFractions", "TempRangeSliderThumb", "Landroidx/compose/foundation/layout/BoxScope;", "offset", "content", "Lkotlin/ExtensionFunctionType;", "TempRangeSliderThumb-rAjV9yQ", "(Landroidx/compose/foundation/layout/BoxScope;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "Landroidx/compose/runtime/State;", "rawOffsetEnd", "isRtl", "gestureEndAction", "onDrag", "Lkotlin/Function2;", "sliderSemantics", "sliderTapModifier", "rawOffset", "pressOffset", "Landroidx/compose/runtime/MutableState;", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
public final class SliderKt {
    private static final Modifier DefaultSliderConstraints;
    private static final float SliderHeight;
    private static final float SliderMinWidth;
    /* access modifiers changed from: private */
    public static final TweenSpec<Float> SliderToTickAnimation = new TweenSpec(100, 0, (Easing) null, 6, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final float ThumbDefaultElevation = Dp.m5986constructorimpl((float) 1);
    private static final float ThumbHeight;
    /* access modifiers changed from: private */
    public static final float ThumbPressedElevation = Dp.m5986constructorimpl((float) 6);
    /* access modifiers changed from: private */
    public static final long ThumbSize;
    private static final float ThumbWidth;
    /* access modifiers changed from: private */
    public static final float TickSize = SliderTokens.INSTANCE.m2665getTickMarksContainerSizeD9Ej5fM();
    private static final float TrackHeight = SliderTokens.INSTANCE.m2660getInactiveTrackHeightD9Ej5fM();

    /* JADX WARNING: Removed duplicated region for block: B:158:0x0389  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Slider(float r44, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r45, androidx.compose.ui.Modifier r46, boolean r47, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r48, int r49, kotlin.jvm.functions.Function0<kotlin.Unit> r50, androidx.compose.material3.SliderColors r51, androidx.compose.foundation.interaction.MutableInteractionSource r52, androidx.compose.runtime.Composer r53, int r54, int r55) {
        /*
            r15 = r45
            r14 = r54
            r13 = r55
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = -202044027(0xfffffffff3f50d85, float:-3.8830168E31)
            r1 = r53
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Slider)P(7,4,3,1,8,6,5)163@7815L8,164@7875L39,176@8248L230,183@8496L226,166@7923L805:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r54
            r2 = r13 & 1
            if (r2 == 0) goto L_0x0025
            r1 = r1 | 6
            r11 = r44
            goto L_0x0038
        L_0x0025:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0036
            r11 = r44
            boolean r2 = r12.changed((float) r11)
            if (r2 == 0) goto L_0x0033
            r2 = 4
            goto L_0x0034
        L_0x0033:
            r2 = 2
        L_0x0034:
            r1 = r1 | r2
            goto L_0x0038
        L_0x0036:
            r11 = r44
        L_0x0038:
            r2 = r13 & 2
            if (r2 == 0) goto L_0x003f
            r1 = r1 | 48
            goto L_0x004f
        L_0x003f:
            r2 = r14 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004f
            boolean r2 = r12.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x004c
            r2 = 32
            goto L_0x004e
        L_0x004c:
            r2 = 16
        L_0x004e:
            r1 = r1 | r2
        L_0x004f:
            r2 = r13 & 4
            if (r2 == 0) goto L_0x0058
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r46
            goto L_0x006d
        L_0x0058:
            r3 = r14 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x006b
            r3 = r46
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0067
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0067:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0069:
            r1 = r1 | r4
            goto L_0x006d
        L_0x006b:
            r3 = r46
        L_0x006d:
            r4 = r13 & 8
            if (r4 == 0) goto L_0x0076
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r47
            goto L_0x008b
        L_0x0076:
            r5 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0089
            r5 = r47
            boolean r6 = r12.changed((boolean) r5)
            if (r6 == 0) goto L_0x0085
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x0087
        L_0x0085:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x0087:
            r1 = r1 | r6
            goto L_0x008b
        L_0x0089:
            r5 = r47
        L_0x008b:
            r6 = 57344(0xe000, float:8.0356E-41)
            r7 = r14 & r6
            if (r7 != 0) goto L_0x00a7
            r7 = r13 & 16
            if (r7 != 0) goto L_0x00a1
            r7 = r48
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x00a3
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a1:
            r7 = r48
        L_0x00a3:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x00a5:
            r1 = r1 | r8
            goto L_0x00a9
        L_0x00a7:
            r7 = r48
        L_0x00a9:
            r8 = r13 & 32
            r9 = 458752(0x70000, float:6.42848E-40)
            if (r8 == 0) goto L_0x00b5
            r10 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r10
            r10 = r49
            goto L_0x00cb
        L_0x00b5:
            r10 = r14 & r9
            if (r10 != 0) goto L_0x00c9
            r10 = r49
            boolean r16 = r12.changed((int) r10)
            if (r16 == 0) goto L_0x00c4
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c6
        L_0x00c4:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c6:
            r1 = r1 | r16
            goto L_0x00cb
        L_0x00c9:
            r10 = r49
        L_0x00cb:
            r16 = r13 & 64
            r41 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00d8
            r17 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r17
            r9 = r50
            goto L_0x00ee
        L_0x00d8:
            r17 = r14 & r41
            if (r17 != 0) goto L_0x00ec
            r9 = r50
            boolean r17 = r12.changed((java.lang.Object) r9)
            if (r17 == 0) goto L_0x00e7
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e9
        L_0x00e7:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00e9:
            r1 = r1 | r17
            goto L_0x00ee
        L_0x00ec:
            r9 = r50
        L_0x00ee:
            r42 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r14 & r42
            if (r17 != 0) goto L_0x010a
            r6 = r13 & 128(0x80, float:1.794E-43)
            if (r6 != 0) goto L_0x0103
            r6 = r51
            boolean r17 = r12.changed((java.lang.Object) r6)
            if (r17 == 0) goto L_0x0105
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0107
        L_0x0103:
            r6 = r51
        L_0x0105:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x0107:
            r1 = r1 | r17
            goto L_0x010c
        L_0x010a:
            r6 = r51
        L_0x010c:
            r0 = r13 & 256(0x100, float:3.59E-43)
            r43 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x0119
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r17
            r3 = r52
            goto L_0x012f
        L_0x0119:
            r17 = r14 & r43
            if (r17 != 0) goto L_0x012d
            r3 = r52
            boolean r17 = r12.changed((java.lang.Object) r3)
            if (r17 == 0) goto L_0x0128
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012a
        L_0x0128:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012a:
            r1 = r1 | r17
            goto L_0x012f
        L_0x012d:
            r3 = r52
        L_0x012f:
            r17 = 191739611(0xb6db6db, float:4.5782105E-32)
            r3 = r1 & r17
            r5 = 38347922(0x2492492, float:1.4777643E-37)
            if (r3 != r5) goto L_0x0157
            boolean r3 = r12.getSkipping()
            if (r3 != 0) goto L_0x0140
            goto L_0x0157
        L_0x0140:
            r12.skipToGroupEnd()
            r16 = r46
            r27 = r47
            r25 = r52
            r24 = r1
            r26 = r6
            r17 = r7
            r19 = r9
            r18 = r10
            r20 = r12
            goto L_0x038c
        L_0x0157:
            r12.startDefaults()
            r3 = r14 & 1
            r5 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x019a
            boolean r3 = r12.getDefaultsInvalid()
            if (r3 == 0) goto L_0x016b
            goto L_0x019a
        L_0x016b:
            r12.skipToGroupEnd()
            r0 = r13 & 16
            if (r0 == 0) goto L_0x0174
            r1 = r1 & r17
        L_0x0174:
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x018a
            r0 = r1 & r5
            r16 = r46
            r8 = r52
            r17 = r7
            r19 = r9
            r18 = r10
            r10 = r47
            r7 = r0
            r9 = r6
            goto L_0x0242
        L_0x018a:
            r16 = r46
            r8 = r52
            r17 = r7
            r19 = r9
            r18 = r10
            r10 = r47
            r7 = r1
            r9 = r6
            goto L_0x0242
        L_0x019a:
            if (r2 == 0) goto L_0x01a1
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x01a3
        L_0x01a1:
            r2 = r46
        L_0x01a3:
            if (r4 == 0) goto L_0x01a7
            r3 = 1
            goto L_0x01a9
        L_0x01a7:
            r3 = r47
        L_0x01a9:
            r4 = r13 & 16
            if (r4 == 0) goto L_0x01b7
            r4 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r4 = kotlin.ranges.RangesKt.rangeTo((float) r4, (float) r5)
            r1 = r1 & r17
            goto L_0x01b8
        L_0x01b7:
            r4 = r7
        L_0x01b8:
            if (r8 == 0) goto L_0x01bc
            r5 = 0
            goto L_0x01bd
        L_0x01bc:
            r5 = r10
        L_0x01bd:
            if (r16 == 0) goto L_0x01c1
            r7 = 0
            goto L_0x01c2
        L_0x01c1:
            r7 = r9
        L_0x01c2:
            r8 = r13 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x01ec
            androidx.compose.material3.SliderDefaults r16 = androidx.compose.material3.SliderDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r38 = 0
            r39 = 6
            r40 = 1023(0x3ff, float:1.434E-42)
            r37 = r12
            androidx.compose.material3.SliderColors r6 = r16.m2055colorsq0g_0yA(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r39, r40)
            r8 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r8
        L_0x01ec:
            if (r0 == 0) goto L_0x0232
            r0 = 0
            r8 = 0
            r9 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r12.startReplaceableGroup(r9)
            java.lang.String r9 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r9)
            r9 = 0
            r10 = r12
            r16 = 0
            r46 = r0
            java.lang.Object r0 = r10.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r47 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r0 != r1) goto L_0x021b
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r10.updateRememberedValue(r1)
            goto L_0x021c
        L_0x021b:
            r1 = r0
        L_0x021c:
            r12.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r8 = r0
            r16 = r2
            r10 = r3
            r17 = r4
            r18 = r5
            r9 = r6
            r19 = r7
            r7 = r47
            goto L_0x0242
        L_0x0232:
            r47 = r1
            r8 = r52
            r16 = r2
            r10 = r3
            r17 = r4
            r18 = r5
            r9 = r6
            r19 = r7
            r7 = r47
        L_0x0242:
            r12.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0254
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.Slider (Slider.kt:154)"
            r2 = -202044027(0xfffffffff3f50d85, float:-3.8830168E31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r7, r0, r1)
        L_0x0254:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)
            int r1 = r7 >> 24
            r1 = r1 & 14
            int r2 = r7 >> 18
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r7 >> 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = 0
            r3 = 1618982084(0x607fb4c4, float:7.370227E19)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1,2,3):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            boolean r3 = r12.changed((java.lang.Object) r8)
            boolean r4 = r12.changed((java.lang.Object) r9)
            r3 = r3 | r4
            boolean r4 = r12.changed((java.lang.Object) r0)
            r3 = r3 | r4
            r4 = r12
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r20 = 0
            r46 = r0
            if (r3 != 0) goto L_0x029c
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r21.getEmpty()
            if (r6 != r0) goto L_0x0296
            goto L_0x029c
        L_0x0296:
            r49 = r1
            r50 = r2
            r0 = r6
            goto L_0x02b6
        L_0x029c:
            r0 = 0
            r48 = r0
            androidx.compose.material3.SliderKt$Slider$2$1 r0 = new androidx.compose.material3.SliderKt$Slider$2$1
            r0.<init>(r8, r9, r10, r7)
            r49 = r1
            r1 = -1923353268(0xffffffff8d5bf54c, float:-6.777985E-31)
            r50 = r2
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r1, r2, r0)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r4.updateRememberedValue(r0)
        L_0x02b6:
            r12.endReplaceableGroup()
            r20 = r0
            kotlin.jvm.functions.Function3 r20 = (kotlin.jvm.functions.Function3) r20
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)
            int r1 = r7 >> 21
            r1 = r1 & 14
            int r2 = r7 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = 0
            r3 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r12.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r3)
            boolean r3 = r12.changed((java.lang.Object) r9)
            boolean r4 = r12.changed((java.lang.Object) r0)
            r3 = r3 | r4
            r4 = r12
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r21 = 0
            if (r3 != 0) goto L_0x02fe
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r46 = r0
            java.lang.Object r0 = r22.getEmpty()
            if (r6 != r0) goto L_0x02f8
            goto L_0x0300
        L_0x02f8:
            r49 = r1
            r50 = r2
            r0 = r6
            goto L_0x031a
        L_0x02fe:
            r46 = r0
        L_0x0300:
            r0 = 0
            r48 = r0
            androidx.compose.material3.SliderKt$Slider$3$1 r0 = new androidx.compose.material3.SliderKt$Slider$3$1
            r0.<init>(r9, r10, r7)
            r49 = r1
            r1 = 1022381539(0x3cf04de3, float:0.029334014)
            r50 = r2
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r1, r2, r0)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r4.updateRememberedValue(r0)
        L_0x031a:
            r12.endReplaceableGroup()
            r2 = r0
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            r0 = r7 & 14
            r1 = r7 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r7 << 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r7 << 3
            r3 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r7 << 3
            r3 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r7 << 3
            r1 = r1 & r41
            r0 = r0 | r1
            int r1 = r7 << 3
            r1 = r1 & r42
            r0 = r0 | r1
            int r1 = r7 << 3
            r1 = r1 & r43
            r0 = r0 | r1
            r1 = 1879048192(0x70000000, float:1.58456325E29)
            int r3 = r7 << 3
            r1 = r1 & r3
            r21 = r0 | r1
            r22 = 0
            r23 = 0
            r0 = r44
            r1 = r45
            r3 = r16
            r4 = r10
            r5 = r17
            r6 = r18
            r24 = r7
            r7 = r19
            r25 = r8
            r8 = r9
            r26 = r9
            r9 = r25
            r27 = r10
            r10 = r20
            r11 = r12
            r20 = r12
            r12 = r21
            r13 = r22
            r14 = r23
            Slider(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x038c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x038c:
            androidx.compose.runtime.ScopeUpdateScope r12 = r20.endRestartGroup()
            if (r12 != 0) goto L_0x0393
            goto L_0x03b4
        L_0x0393:
            androidx.compose.material3.SliderKt$Slider$4 r13 = new androidx.compose.material3.SliderKt$Slider$4
            r0 = r13
            r1 = r44
            r2 = r45
            r3 = r16
            r4 = r27
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r26
            r9 = r25
            r10 = r54
            r11 = r55
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x03b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0355  */
    /* JADX WARNING: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Slider(float r45, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r46, androidx.compose.ui.Modifier r47, boolean r48, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r49, int r50, kotlin.jvm.functions.Function0<kotlin.Unit> r51, androidx.compose.material3.SliderColors r52, androidx.compose.foundation.interaction.MutableInteractionSource r53, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, androidx.compose.runtime.Composer r55, int r56, int r57) {
        /*
            r15 = r46
            r14 = r54
            r13 = r56
            r12 = r57
            java.lang.String r0 = "onValueChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "thumb"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1785516312(0x6a6cd118, float:7.1573478E25)
            r1 = r55
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Slider)P(8,4,3,1,9,6,5)244@11547L8,245@11607L39,259@12053L226,248@11705L580:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r56
            r2 = r12 & 1
            if (r2 == 0) goto L_0x002d
            r1 = r1 | 6
            r10 = r45
            goto L_0x0040
        L_0x002d:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x003e
            r10 = r45
            boolean r2 = r11.changed((float) r10)
            if (r2 == 0) goto L_0x003b
            r2 = 4
            goto L_0x003c
        L_0x003b:
            r2 = 2
        L_0x003c:
            r1 = r1 | r2
            goto L_0x0040
        L_0x003e:
            r10 = r45
        L_0x0040:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0047
            r1 = r1 | 48
            goto L_0x0057
        L_0x0047:
            r2 = r13 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0057
            boolean r2 = r11.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x0054
            r2 = 32
            goto L_0x0056
        L_0x0054:
            r2 = 16
        L_0x0056:
            r1 = r1 | r2
        L_0x0057:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x0060
            r1 = r1 | 384(0x180, float:5.38E-43)
            r3 = r47
            goto L_0x0075
        L_0x0060:
            r3 = r13 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0073
            r3 = r47
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x006f
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0071
        L_0x006f:
            r4 = 128(0x80, float:1.794E-43)
        L_0x0071:
            r1 = r1 | r4
            goto L_0x0075
        L_0x0073:
            r3 = r47
        L_0x0075:
            r4 = r12 & 8
            if (r4 == 0) goto L_0x007e
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r5 = r48
            goto L_0x0093
        L_0x007e:
            r5 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0091
            r5 = r48
            boolean r6 = r11.changed((boolean) r5)
            if (r6 == 0) goto L_0x008d
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x008f
        L_0x008d:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x008f:
            r1 = r1 | r6
            goto L_0x0093
        L_0x0091:
            r5 = r48
        L_0x0093:
            r6 = 57344(0xe000, float:8.0356E-41)
            r7 = r13 & r6
            if (r7 != 0) goto L_0x00af
            r7 = r12 & 16
            if (r7 != 0) goto L_0x00a9
            r7 = r49
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x00ab
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ad
        L_0x00a9:
            r7 = r49
        L_0x00ab:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x00ad:
            r1 = r1 | r8
            goto L_0x00b1
        L_0x00af:
            r7 = r49
        L_0x00b1:
            r8 = r12 & 32
            r9 = 458752(0x70000, float:6.42848E-40)
            if (r8 == 0) goto L_0x00be
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r9 = r50
            goto L_0x00d4
        L_0x00be:
            r16 = r13 & r9
            if (r16 != 0) goto L_0x00d2
            r9 = r50
            boolean r16 = r11.changed((int) r9)
            if (r16 == 0) goto L_0x00cd
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cf
        L_0x00cd:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00cf:
            r1 = r1 | r16
            goto L_0x00d4
        L_0x00d2:
            r9 = r50
        L_0x00d4:
            r16 = r12 & 64
            r41 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00e1
            r17 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r17
            r6 = r51
            goto L_0x00f7
        L_0x00e1:
            r17 = r13 & r41
            if (r17 != 0) goto L_0x00f5
            r6 = r51
            boolean r17 = r11.changed((java.lang.Object) r6)
            if (r17 == 0) goto L_0x00f0
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f2
        L_0x00f0:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00f2:
            r1 = r1 | r17
            goto L_0x00f7
        L_0x00f5:
            r6 = r51
        L_0x00f7:
            r42 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r13 & r42
            if (r17 != 0) goto L_0x0113
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x010c
            r0 = r52
            boolean r17 = r11.changed((java.lang.Object) r0)
            if (r17 == 0) goto L_0x010e
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0110
        L_0x010c:
            r0 = r52
        L_0x010e:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x0110:
            r1 = r1 | r17
            goto L_0x0115
        L_0x0113:
            r0 = r52
        L_0x0115:
            r0 = r12 & 256(0x100, float:3.59E-43)
            r43 = 234881024(0xe000000, float:1.5777218E-30)
            if (r0 == 0) goto L_0x0122
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r17
            r3 = r53
            goto L_0x0138
        L_0x0122:
            r17 = r13 & r43
            if (r17 != 0) goto L_0x0136
            r3 = r53
            boolean r17 = r11.changed((java.lang.Object) r3)
            if (r17 == 0) goto L_0x0131
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0133
        L_0x0131:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0133:
            r1 = r1 | r17
            goto L_0x0138
        L_0x0136:
            r3 = r53
        L_0x0138:
            r3 = r12 & 512(0x200, float:7.175E-43)
            r44 = 1879048192(0x70000000, float:1.58456325E29)
            if (r3 == 0) goto L_0x0142
            r3 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0140:
            r1 = r1 | r3
            goto L_0x0152
        L_0x0142:
            r3 = r13 & r44
            if (r3 != 0) goto L_0x0152
            boolean r3 = r11.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x014f
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0140
        L_0x014f:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0140
        L_0x0152:
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r3 & r1
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r5) goto L_0x0179
            boolean r3 = r11.getSkipping()
            if (r3 != 0) goto L_0x0162
            goto L_0x0179
        L_0x0162:
            r11.skipToGroupEnd()
            r16 = r47
            r26 = r48
            r25 = r52
            r20 = r53
            r24 = r1
            r19 = r6
            r17 = r7
            r18 = r9
            r27 = r11
            goto L_0x034e
        L_0x0179:
            r11.startDefaults()
            r3 = r13 & 1
            r5 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x01be
            boolean r3 = r11.getDefaultsInvalid()
            if (r3 == 0) goto L_0x018d
            goto L_0x01be
        L_0x018d:
            r11.skipToGroupEnd()
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0196
            r1 = r1 & r17
        L_0x0196:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01ad
            r0 = r1 & r5
            r16 = r47
            r8 = r52
            r20 = r53
            r19 = r6
            r17 = r7
            r18 = r9
            r9 = r48
            r7 = r0
            goto L_0x0272
        L_0x01ad:
            r16 = r47
            r8 = r52
            r20 = r53
            r19 = r6
            r17 = r7
            r18 = r9
            r9 = r48
            r7 = r1
            goto L_0x0272
        L_0x01be:
            if (r2 == 0) goto L_0x01c5
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x01c7
        L_0x01c5:
            r2 = r47
        L_0x01c7:
            if (r4 == 0) goto L_0x01cb
            r3 = 1
            goto L_0x01cd
        L_0x01cb:
            r3 = r48
        L_0x01cd:
            r4 = r12 & 16
            if (r4 == 0) goto L_0x01db
            r4 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            kotlin.ranges.ClosedFloatingPointRange r4 = kotlin.ranges.RangesKt.rangeTo((float) r4, (float) r5)
            r1 = r1 & r17
            goto L_0x01dc
        L_0x01db:
            r4 = r7
        L_0x01dc:
            if (r8 == 0) goto L_0x01e0
            r5 = 0
            goto L_0x01e1
        L_0x01e0:
            r5 = r9
        L_0x01e1:
            if (r16 == 0) goto L_0x01e4
            r6 = 0
        L_0x01e4:
            r7 = r12 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x020f
            androidx.compose.material3.SliderDefaults r16 = androidx.compose.material3.SliderDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r29 = 0
            r31 = 0
            r33 = 0
            r35 = 0
            r38 = 0
            r39 = 6
            r40 = 1023(0x3ff, float:1.434E-42)
            r37 = r11
            androidx.compose.material3.SliderColors r7 = r16.m2055colorsq0g_0yA(r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r38, r39, r40)
            r8 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r1 = r1 & r8
            goto L_0x0211
        L_0x020f:
            r7 = r52
        L_0x0211:
            if (r0 == 0) goto L_0x0262
            r0 = 0
            r8 = 0
            r9 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r9)
            java.lang.String r9 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r9)
            r9 = 0
            r47 = r11
            r16 = 0
            r48 = r0
            java.lang.Object r0 = r47.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r49 = r1
            java.lang.Object r1 = r18.getEmpty()
            if (r0 != r1) goto L_0x0245
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r50 = r0
            r0 = r47
            r0.updateRememberedValue(r1)
            goto L_0x024b
        L_0x0245:
            r50 = r0
            r0 = r47
            r1 = r50
        L_0x024b:
            r11.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r20 = r0
            r16 = r2
            r9 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r8 = r7
            r7 = r49
            goto L_0x0272
        L_0x0262:
            r49 = r1
            r20 = r53
            r16 = r2
            r9 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r8 = r7
            r7 = r49
        L_0x0272:
            r11.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0284
            r0 = -1
            java.lang.String r1 = "androidx.compose.material3.Slider (Slider.kt:235)"
            r2 = 1785516312(0x6a6cd118, float:7.1573478E25)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r7, r0, r1)
        L_0x0284:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r9)
            int r1 = r7 >> 21
            r1 = r1 & 14
            int r2 = r7 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = 0
            r3 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r11.startReplaceableGroup(r3)
            java.lang.String r3 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r3)
            boolean r3 = r11.changed((java.lang.Object) r8)
            boolean r4 = r11.changed((java.lang.Object) r0)
            r3 = r3 | r4
            r4 = r11
            r5 = 0
            java.lang.Object r6 = r4.rememberedValue()
            r21 = 0
            if (r3 != 0) goto L_0x02c3
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r47 = r0
            java.lang.Object r0 = r22.getEmpty()
            if (r6 != r0) goto L_0x02bd
            goto L_0x02c5
        L_0x02bd:
            r49 = r1
            r50 = r2
            r0 = r6
            goto L_0x02df
        L_0x02c3:
            r47 = r0
        L_0x02c5:
            r0 = 0
            r48 = r0
            androidx.compose.material3.SliderKt$Slider$6$1 r0 = new androidx.compose.material3.SliderKt$Slider$6$1
            r0.<init>(r8, r9, r7)
            r49 = r1
            r1 = 1252336501(0x4aa52375, float:5411258.5)
            r50 = r2
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambdaInstance(r1, r2, r0)
            kotlin.jvm.functions.Function3 r0 = (kotlin.jvm.functions.Function3) r0
            r4.updateRememberedValue(r0)
        L_0x02df:
            r11.endReplaceableGroup()
            r2 = r0
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            r0 = r7 & 14
            r1 = r7 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            int r1 = r7 << 3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            int r1 = r7 << 3
            r3 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r7 << 3
            r3 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r3
            r0 = r0 | r1
            int r1 = r7 << 3
            r1 = r1 & r41
            r0 = r0 | r1
            int r1 = r7 << 3
            r1 = r1 & r42
            r0 = r0 | r1
            int r1 = r7 << 3
            r1 = r1 & r43
            r0 = r0 | r1
            int r1 = r7 << 3
            r1 = r1 & r44
            r21 = r0 | r1
            int r0 = r7 >> 27
            r22 = r0 & 14
            r23 = 0
            r0 = r45
            r1 = r46
            r3 = r16
            r4 = r9
            r5 = r17
            r6 = r18
            r24 = r7
            r7 = r19
            r25 = r8
            r26 = r9
            r9 = r20
            r10 = r54
            r27 = r11
            r12 = r21
            r13 = r22
            r14 = r23
            Slider(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x034e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x034e:
            androidx.compose.runtime.ScopeUpdateScope r13 = r27.endRestartGroup()
            if (r13 != 0) goto L_0x0355
            goto L_0x0378
        L_0x0355:
            androidx.compose.material3.SliderKt$Slider$7 r14 = new androidx.compose.material3.SliderKt$Slider$7
            r0 = r14
            r1 = r45
            r2 = r46
            r3 = r16
            r4 = r26
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r25
            r9 = r20
            r10 = r54
            r11 = r56
            r12 = r57
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.updateScope(r14)
        L_0x0378:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    @ExperimentalMaterial3Api
    public static final void Slider(float value, Function1<? super Float, Unit> onValueChange, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> track, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> valueRange, int steps, Function0<Unit> onValueChangeFinished, SliderColors colors, MutableInteractionSource interactionSource, Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> thumb, Composer $composer, int $changed, int $changed1, int i) {
        boolean z;
        int steps2;
        Composer $composer2;
        Function3 thumb2;
        MutableInteractionSource interactionSource2;
        SliderColors colors2;
        Modifier modifier2;
        Function0 onValueChangeFinished2;
        int steps3;
        ClosedFloatingPointRange valueRange2;
        boolean enabled2;
        int $dirty;
        int steps4;
        int $dirty2;
        Modifier modifier3;
        boolean enabled3;
        ClosedFloatingPointRange valueRange3;
        Function0 onValueChangeFinished3;
        SliderColors colors3;
        Function0 onValueChangeFinished4;
        MutableInteractionSource interactionSource3;
        int $dirty3;
        MutableInteractionSource interactionSource4;
        Object value$iv$iv;
        Object value$iv$iv2;
        int i2;
        int i3;
        int i4;
        Function1<? super Float, Unit> function1 = onValueChange;
        Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function3 = track;
        int i5 = $changed;
        int i6 = i;
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Intrinsics.checkNotNullParameter(function3, "track");
        Composer $composer3 = $composer.startRestartGroup(387052651);
        ComposerKt.sourceInformation($composer3, "C(Slider)P(9,4,8,3,1,10,6,5)322@15315L8,323@15375L39,325@15475L230,335@15766L338:Slider.kt#uh7d8r");
        int $dirty4 = $changed;
        int $dirty1 = $changed1;
        if ((i6 & 1) != 0) {
            $dirty4 |= 6;
            float f = value;
        } else if ((i5 & 14) == 0) {
            $dirty4 |= $composer3.changed(value) ? 4 : 2;
        } else {
            float f2 = value;
        }
        if ((i6 & 2) != 0) {
            $dirty4 |= 48;
        } else if ((i5 & 112) == 0) {
            $dirty4 |= $composer3.changed((Object) function1) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            $dirty4 |= 384;
        } else if ((i5 & 896) == 0) {
            $dirty4 |= $composer3.changed((Object) function3) ? 256 : 128;
        }
        int i7 = i6 & 8;
        if (i7 != 0) {
            $dirty4 |= 3072;
            Modifier modifier4 = modifier;
        } else if ((i5 & 7168) == 0) {
            $dirty4 |= $composer3.changed((Object) modifier) ? 2048 : 1024;
        } else {
            Modifier modifier5 = modifier;
        }
        int i8 = i6 & 16;
        if (i8 != 0) {
            $dirty4 |= 24576;
            z = enabled;
        } else if ((i5 & 57344) == 0) {
            z = enabled;
            $dirty4 |= $composer3.changed(z) ? 16384 : 8192;
        } else {
            z = enabled;
        }
        if ((i5 & 458752) == 0) {
            if ((i6 & 32) != 0) {
                ClosedFloatingPointRange<Float> closedFloatingPointRange = valueRange;
            } else if ($composer3.changed((Object) valueRange)) {
                i4 = 131072;
                $dirty4 |= i4;
            }
            i4 = 65536;
            $dirty4 |= i4;
        } else {
            ClosedFloatingPointRange<Float> closedFloatingPointRange2 = valueRange;
        }
        int i9 = i6 & 64;
        if (i9 != 0) {
            $dirty4 |= 1572864;
            steps2 = steps;
        } else if ((i5 & 3670016) == 0) {
            steps2 = steps;
            $dirty4 |= $composer3.changed(steps2) ? 1048576 : 524288;
        } else {
            steps2 = steps;
        }
        int i10 = i6 & 128;
        if (i10 != 0) {
            $dirty4 |= 12582912;
            Function0<Unit> function0 = onValueChangeFinished;
        } else if ((i5 & 29360128) == 0) {
            $dirty4 |= $composer3.changed((Object) onValueChangeFinished) ? 8388608 : 4194304;
        } else {
            Function0<Unit> function02 = onValueChangeFinished;
        }
        if ((i5 & 234881024) == 0) {
            if ((i6 & 256) != 0) {
                SliderColors sliderColors = colors;
            } else if ($composer3.changed((Object) colors)) {
                i3 = 67108864;
                $dirty4 |= i3;
            }
            i3 = 33554432;
            $dirty4 |= i3;
        } else {
            SliderColors sliderColors2 = colors;
        }
        int i11 = i6 & 512;
        if (i11 != 0) {
            $dirty4 |= 805306368;
            MutableInteractionSource mutableInteractionSource = interactionSource;
        } else if ((i5 & 1879048192) == 0) {
            $dirty4 |= $composer3.changed((Object) interactionSource) ? 536870912 : 268435456;
        } else {
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        }
        if (($changed1 & 14) == 0) {
            if ((i6 & 1024) != 0) {
                Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function32 = thumb;
            } else if ($composer3.changed((Object) thumb)) {
                i2 = 4;
                $dirty1 |= i2;
            }
            i2 = 2;
            $dirty1 |= i2;
        } else {
            Function3<? super SliderPositions, ? super Composer, ? super Integer, Unit> function33 = thumb;
        }
        if (($dirty4 & 1533916891) == 306783378 && ($dirty1 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            valueRange2 = valueRange;
            onValueChangeFinished2 = onValueChangeFinished;
            colors2 = colors;
            interactionSource2 = interactionSource;
            thumb2 = thumb;
            int i12 = $dirty4;
            int i13 = $dirty1;
            steps3 = steps2;
            enabled2 = z;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if ((i5 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i8 != 0) {
                    enabled3 = true;
                } else {
                    enabled3 = z;
                }
                if ((i6 & 32) != 0) {
                    valueRange3 = RangesKt.rangeTo(0.0f, 1.0f);
                    $dirty4 &= -458753;
                } else {
                    valueRange3 = valueRange;
                }
                if (i9 != 0) {
                    steps2 = 0;
                }
                if (i10 != 0) {
                    onValueChangeFinished3 = null;
                } else {
                    onValueChangeFinished3 = onValueChangeFinished;
                }
                if ((i6 & 256) != 0) {
                    colors3 = SliderDefaults.INSTANCE.m2055colorsq0g_0yA(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer3, 0, 6, 1023);
                    $dirty4 &= -234881025;
                } else {
                    colors3 = colors;
                }
                if (i11 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    onValueChangeFinished4 = onValueChangeFinished3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    modifier2 = modifier3;
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv2 = InteractionSourceKt.MutableInteractionSource();
                        Object obj = it$iv$iv;
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv2);
                    } else {
                        Object obj2 = it$iv$iv;
                        Object it$iv$iv2 = $this$cache$iv$iv;
                        value$iv$iv2 = obj2;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource3 = (MutableInteractionSource) value$iv$iv2;
                } else {
                    onValueChangeFinished4 = onValueChangeFinished3;
                    modifier2 = modifier3;
                    interactionSource3 = interactionSource;
                }
                if ((i6 & 1024) != 0) {
                    Boolean valueOf = Boolean.valueOf(enabled3);
                    int i14 = (($dirty4 >> 27) & 14) | (($dirty4 >> 21) & 112) | (($dirty4 >> 6) & 896);
                    $composer3.startReplaceableGroup(1618982084);
                    ComposerKt.sourceInformation($composer3, "C(remember)P(1,2,3):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer3.changed((Object) interactionSource3) | $composer3.changed((Object) colors3) | $composer3.changed((Object) valueOf);
                    Composer $this$cache$iv$iv2 = $composer3;
                    Boolean bool = valueOf;
                    Object it$iv$iv3 = $this$cache$iv$iv2.rememberedValue();
                    if (!invalid$iv$iv) {
                        boolean z2 = invalid$iv$iv;
                        if (it$iv$iv3 != Composer.Companion.getEmpty()) {
                            interactionSource4 = interactionSource3;
                            $dirty3 = $dirty4;
                            value$iv$iv = it$iv$iv3;
                            $dirty2 = 1;
                            Object it$iv$iv4 = $this$cache$iv$iv2;
                            $composer3.endReplaceableGroup();
                            thumb2 = (Function3) value$iv$iv;
                            enabled2 = enabled3;
                            valueRange2 = valueRange3;
                            colors2 = colors3;
                            interactionSource2 = interactionSource4;
                            $dirty = $dirty3;
                            onValueChangeFinished2 = onValueChangeFinished4;
                            steps3 = steps2;
                            steps4 = $dirty1 & -15;
                        }
                    }
                    Object obj3 = it$iv$iv3;
                    SliderKt$Slider$9$1 sliderKt$Slider$9$1 = new SliderKt$Slider$9$1(interactionSource3, colors3, enabled3, $dirty4);
                    interactionSource4 = interactionSource3;
                    $dirty3 = $dirty4;
                    $dirty2 = 1;
                    value$iv$iv = ComposableLambdaKt.composableLambdaInstance(1647281944, true, sliderKt$Slider$9$1);
                    $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
                    $composer3.endReplaceableGroup();
                    thumb2 = (Function3) value$iv$iv;
                    enabled2 = enabled3;
                    valueRange2 = valueRange3;
                    colors2 = colors3;
                    interactionSource2 = interactionSource4;
                    $dirty = $dirty3;
                    onValueChangeFinished2 = onValueChangeFinished4;
                    steps3 = steps2;
                    steps4 = $dirty1 & -15;
                } else {
                    int $dirty5 = $dirty4;
                    $dirty2 = 1;
                    thumb2 = thumb;
                    enabled2 = enabled3;
                    valueRange2 = valueRange3;
                    colors2 = colors3;
                    interactionSource2 = interactionSource3;
                    $dirty = $dirty5;
                    onValueChangeFinished2 = onValueChangeFinished4;
                    steps3 = steps2;
                    steps4 = $dirty1;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i6 & 32) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i6 & 256) != 0) {
                    $dirty4 &= -234881025;
                }
                if ((i6 & 1024) != 0) {
                    modifier2 = modifier;
                    valueRange2 = valueRange;
                    onValueChangeFinished2 = onValueChangeFinished;
                    colors2 = colors;
                    interactionSource2 = interactionSource;
                    thumb2 = thumb;
                    steps3 = steps2;
                    enabled2 = z;
                    steps4 = $dirty1 & -15;
                    $dirty = $dirty4;
                    $dirty2 = 1;
                } else {
                    modifier2 = modifier;
                    valueRange2 = valueRange;
                    onValueChangeFinished2 = onValueChangeFinished;
                    colors2 = colors;
                    interactionSource2 = interactionSource;
                    thumb2 = thumb;
                    steps3 = steps2;
                    enabled2 = z;
                    $dirty = $dirty4;
                    steps4 = $dirty1;
                    $dirty2 = 1;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(387052651, $dirty, steps4, "androidx.compose.material3.Slider (Slider.kt:312)");
            }
            if ((steps3 >= 0 ? $dirty2 : 0) != 0) {
                int i15 = steps4;
                int i16 = $dirty;
                $composer2 = $composer3;
                SliderImpl(modifier2, enabled2, interactionSource2, onValueChange, onValueChangeFinished2, steps3, value, valueRange2, thumb2, track, $composer3, (($dirty >> 9) & 14) | (($dirty >> 9) & 112) | (($dirty >> 21) & 896) | (($dirty << 6) & 7168) | (($dirty >> 9) & 57344) | (($dirty >> 3) & 458752) | (($dirty << 18) & 3670016) | (($dirty << 6) & 29360128) | ((steps4 << 24) & 234881024) | (($dirty << 21) & 1879048192));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$Slider$11(value, onValueChange, track, modifier2, enabled2, valueRange2, steps3, onValueChangeFinished2, colors2, interactionSource2, thumb2, $changed, $changed1, i));
        }
    }

    @ExperimentalMaterial3Api
    public static final void RangeSlider(ClosedFloatingPointRange<Float> value, Function1<? super ClosedFloatingPointRange<Float>, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> valueRange, int steps, Function0<Unit> onValueChangeFinished, SliderColors colors, Composer $composer, int $changed, int i) {
        boolean enabled2;
        ClosedFloatingPointRange valueRange2;
        int steps2;
        Function0 onValueChangeFinished2;
        SliderColors colors2;
        Function0 onValueChangeFinished3;
        int steps3;
        ClosedFloatingPointRange valueRange3;
        boolean enabled3;
        Modifier modifier2;
        Composer $composer2;
        int $dirty;
        Object value$iv$iv;
        Object value$iv$iv2;
        Object value$iv$iv3;
        float[] value$iv$iv4;
        Modifier modifier3;
        int i2;
        int i3;
        ClosedFloatingPointRange<Float> closedFloatingPointRange = value;
        Function1<? super ClosedFloatingPointRange<Float>, Unit> function1 = onValueChange;
        int i4 = $changed;
        int i5 = i;
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "value");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        Composer $composer3 = $composer.startRestartGroup(-743091416);
        ComposerKt.sourceInformation($composer3, "C(RangeSlider)P(6,3,2,1,7,5,4)393@18465L8,395@18537L39,396@18634L39,399@18819L74,399@18755L138,404@18918L59,408@18983L3983:Slider.kt#uh7d8r");
        int $dirty2 = $changed;
        if ((i5 & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i4 & 14) == 0) {
            $dirty2 |= $composer3.changed((Object) closedFloatingPointRange) ? 4 : 2;
        }
        if ((i5 & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i4 & 112) == 0) {
            $dirty2 |= $composer3.changed((Object) function1) ? 32 : 16;
        }
        int i6 = i5 & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            Modifier modifier4 = modifier;
        } else if ((i4 & 896) == 0) {
            $dirty2 |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier5 = modifier;
        }
        int i7 = i5 & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            enabled2 = enabled;
        } else if ((i4 & 7168) == 0) {
            enabled2 = enabled;
            $dirty2 |= $composer3.changed(enabled2) ? 2048 : 1024;
        } else {
            enabled2 = enabled;
        }
        if ((57344 & i4) == 0) {
            if ((i5 & 16) == 0) {
                valueRange2 = valueRange;
                if ($composer3.changed((Object) valueRange2)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                valueRange2 = valueRange;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            valueRange2 = valueRange;
        }
        int i8 = i5 & 32;
        if (i8 != 0) {
            $dirty2 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            steps2 = steps;
        } else if ((458752 & i4) == 0) {
            steps2 = steps;
            $dirty2 |= $composer3.changed(steps2) ? 131072 : 65536;
        } else {
            steps2 = steps;
        }
        int i9 = i5 & 64;
        if (i9 != 0) {
            $dirty2 |= 1572864;
            onValueChangeFinished2 = onValueChangeFinished;
        } else if ((3670016 & i4) == 0) {
            onValueChangeFinished2 = onValueChangeFinished;
            $dirty2 |= $composer3.changed((Object) onValueChangeFinished2) ? 1048576 : 524288;
        } else {
            onValueChangeFinished2 = onValueChangeFinished;
        }
        if ((i4 & 29360128) == 0) {
            if ((i5 & 128) != 0) {
                SliderColors sliderColors = colors;
            } else if ($composer3.changed((Object) colors)) {
                i2 = 8388608;
                $dirty2 |= i2;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        } else {
            SliderColors sliderColors2 = colors;
        }
        if (($dirty2 & 23967451) != 4793490 || !$composer3.getSkipping()) {
            $composer3.startDefaults();
            if ((i4 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i7 != 0) {
                    enabled2 = true;
                }
                if ((i5 & 16) != 0) {
                    $dirty2 &= -57345;
                    valueRange2 = RangesKt.rangeTo(0.0f, 1.0f);
                }
                if (i8 != 0) {
                    steps2 = 0;
                }
                if (i9 != 0) {
                    onValueChangeFinished2 = null;
                }
                if ((i5 & 128) != 0) {
                    modifier2 = modifier3;
                    colors2 = SliderDefaults.INSTANCE.m2055colorsq0g_0yA(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, $composer3, 0, 6, 1023);
                    enabled3 = enabled2;
                    valueRange3 = valueRange2;
                    steps3 = steps2;
                    onValueChangeFinished3 = onValueChangeFinished2;
                    $dirty = $dirty2 & -29360129;
                } else {
                    colors2 = colors;
                    modifier2 = modifier3;
                    enabled3 = enabled2;
                    valueRange3 = valueRange2;
                    steps3 = steps2;
                    onValueChangeFinished3 = onValueChangeFinished2;
                    $dirty = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i5 & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i5 & 128) != 0) {
                    modifier2 = modifier;
                    colors2 = colors;
                    enabled3 = enabled2;
                    valueRange3 = valueRange2;
                    steps3 = steps2;
                    onValueChangeFinished3 = onValueChangeFinished2;
                    $dirty = $dirty2 & -29360129;
                } else {
                    modifier2 = modifier;
                    colors2 = colors;
                    enabled3 = enabled2;
                    valueRange3 = valueRange2;
                    steps3 = steps2;
                    onValueChangeFinished3 = onValueChangeFinished2;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-743091416, $dirty, -1, "androidx.compose.material3.RangeSlider (Slider.kt:384)");
            }
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer3;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer3.endReplaceableGroup();
            MutableInteractionSource startInteractionSource = (MutableInteractionSource) value$iv$iv;
            $composer3.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer3, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv2 = $composer3;
            Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
            if (it$iv$iv2 == Composer.Companion.getEmpty()) {
                value$iv$iv2 = InteractionSourceKt.MutableInteractionSource();
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer3.endReplaceableGroup();
            MutableInteractionSource endInteractionSource = (MutableInteractionSource) value$iv$iv2;
            if (steps3 >= 0) {
                int i10 = ($dirty & 14) | ($dirty & 112);
                $composer3.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer3, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer3.changed((Object) closedFloatingPointRange) | $composer3.changed((Object) function1);
                Composer $this$cache$iv$iv3 = $composer3;
                Object it$iv$iv3 = $this$cache$iv$iv3.rememberedValue();
                if (invalid$iv$iv || it$iv$iv3 == Composer.Companion.getEmpty()) {
                    value$iv$iv3 = new SliderKt$RangeSlider$onValueChangeState$1$1(closedFloatingPointRange, function1);
                    $this$cache$iv$iv3.updateRememberedValue(value$iv$iv3);
                } else {
                    value$iv$iv3 = it$iv$iv3;
                }
                $composer3.endReplaceableGroup();
                State onValueChangeState = SnapshotStateKt.rememberUpdatedState(value$iv$iv3, $composer3, 0);
                Object key1$iv = Integer.valueOf(steps3);
                int i11 = ($dirty >> 15) & 14;
                $composer3.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer3, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer3.changed(key1$iv);
                Composer $this$cache$iv$iv4 = $composer3;
                Object it$iv$iv4 = $this$cache$iv$iv4.rememberedValue();
                if (invalid$iv$iv2 || it$iv$iv4 == Composer.Companion.getEmpty()) {
                    value$iv$iv4 = stepsToTickFractions(steps3);
                    $this$cache$iv$iv4.updateRememberedValue(value$iv$iv4);
                } else {
                    value$iv$iv4 = it$iv$iv4;
                }
                $composer3.endReplaceableGroup();
                Modifier r26 = SizeKt.m826requiredSizeInqDBjuR0$default(TouchTargetKt.minimumTouchTargetSize(modifier2), Dp.m5986constructorimpl(((float) 2) * ThumbWidth), Dp.m5986constructorimpl(((float) 2) * ThumbHeight), 0.0f, 0.0f, 12, (Object) null);
                SliderKt$RangeSlider$2 sliderKt$RangeSlider$2 = r0;
                int i12 = $dirty;
                $composer2 = $composer3;
                SliderKt$RangeSlider$2 sliderKt$RangeSlider$22 = new SliderKt$RangeSlider$2(onValueChangeFinished3, $dirty, startInteractionSource, endInteractionSource, enabled3, valueRange3, value, steps3, onValueChangeState, value$iv$iv4, colors2);
                BoxWithConstraintsKt.BoxWithConstraints(r26, (Alignment) null, false, ComposableLambdaKt.composableLambda($composer2, -990606702, true, sliderKt$RangeSlider$2), $composer2, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            colors2 = colors;
            int i13 = $dirty2;
            enabled3 = enabled2;
            valueRange3 = valueRange2;
            steps3 = steps2;
            onValueChangeFinished3 = onValueChangeFinished2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$RangeSlider$3(value, onValueChange, modifier2, enabled3, valueRange3, steps3, onValueChangeFinished3, colors2, $changed, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void RangeSliderImpl(boolean enabled, float positionFractionStart, float positionFractionEnd, float[] tickFractions, SliderColors colors, float width, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, Modifier modifier, Modifier startThumbSemantics, Modifier endThumbSemantics, Composer $composer, int $changed, int $changed1) {
        Composer $composer$iv;
        Composer $composer2 = $composer.startRestartGroup(-597471305);
        ComposerKt.sourceInformation($composer2, "C(RangeSliderImpl)P(1,6,5,9!1,10,7!1,4,8)524@23449L35,525@23517L33,526@23555L1927:Slider.kt#uh7d8r");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-597471305, $dirty, $dirty1, "androidx.compose.material3.RangeSliderImpl (Slider.kt:511)");
        }
        String startContentDescription = Strings_androidKt.m2089getStringNWtq28(Strings.Companion.m2088getSliderRangeStartadMyvUU(), $composer2, 6);
        String endContentDescription = Strings_androidKt.m2089getStringNWtq28(Strings.Companion.m2087getSliderRangeEndadMyvUU(), $composer2, 6);
        Modifier modifier$iv = modifier.then(DefaultSliderConstraints);
        $composer2.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
        $composer2.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer2);
        Density density$iv$iv = (Density) consume;
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd($composer2);
        LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
        Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
        Alignment alignment = contentAlignment$iv;
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
        int $changed$iv$iv$iv = ((((0 << 3) & 112) << 9) & 7168) | 6;
        if (!($composer2.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer2.startReusableNode();
        if ($composer2.getInserting()) {
            $composer2.createNode(constructor);
        } else {
            $composer2.useNode();
        }
        $composer2.disableReusing();
        Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer2);
        Function0<ComposeUiNode> function0 = constructor;
        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
        Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
        $composer2.enableReusing();
        int i = $dirty1;
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
        function3.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
        $composer2.startReplaceableGroup(2058660585);
        int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
        Composer $composer$iv2 = $composer2;
        $composer$iv2.startReplaceableGroup(-2137368960);
        ComposerKt.sourceInformation($composer$iv2, "C72@3384L9:Box.kt#2w3rfo");
        LayoutDirection layoutDirection = layoutDirection$iv$iv;
        if (($changed$iv & 11) != 2 || !$composer$iv2.getSkipping()) {
            int $changed2 = ((0 >> 6) & 112) | 6;
            BoxScope $this$RangeSliderImpl_u24lambda_u2d14 = BoxScopeInstance.INSTANCE;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            Composer $composer3 = $composer$iv2;
            $composer3.startReplaceableGroup(1755032509);
            ComposerKt.sourceInformation($composer3, "C*529@23688L7,537@23916L319,550@24245L616,566@24870L606:Slider.kt#uh7d8r");
            int $dirty2 = $changed2;
            if (($changed2 & 14) == 0) {
                $dirty2 |= $composer3.changed((Object) $this$RangeSliderImpl_u24lambda_u2d14) ? 4 : 2;
            }
            int $dirty3 = $dirty2;
            Density density$iv$iv2 = density$iv$iv;
            if (($dirty3 & 91) != 18 || !$composer3.getSkipping()) {
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density $this$RangeSliderImpl_u24lambda_u2d14_u24lambda_u2d13 = (Density) consume4;
                float trackStrokeWidth = $this$RangeSliderImpl_u24lambda_u2d14_u24lambda_u2d13.m5967toPx0680j_4(TrackHeight);
                float widthDp = $this$RangeSliderImpl_u24lambda_u2d14_u24lambda_u2d13.m5963toDpu2uoSUM(width);
                float offsetStart = Dp.m5986constructorimpl(widthDp * positionFractionStart);
                float offsetEnd = Dp.m5986constructorimpl(widthDp * positionFractionEnd);
                Modifier modifier2 = modifier$iv;
                m2057TempRangeSliderTrackau3_HiA(SizeKt.fillMaxSize$default($this$RangeSliderImpl_u24lambda_u2d14.align(Modifier.Companion, Alignment.Companion.getCenterStart()), 0.0f, 1, (Object) null), colors, enabled, positionFractionStart, positionFractionEnd, tickFractions, ThumbWidth, trackStrokeWidth, $composer3, (($dirty >> 9) & 112) | 1835008 | (($dirty << 6) & 896) | (($dirty << 6) & 7168) | (($dirty << 6) & 57344));
                String str = startContentDescription;
                String str2 = startContentDescription;
                SliderKt$RangeSliderImpl$1$2 sliderKt$RangeSliderImpl$1$2 = r3;
                Density density = density$iv$iv2;
                MeasurePolicy measurePolicy = measurePolicy$iv;
                SliderColors sliderColors = colors;
                ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                $composer$iv = $composer$iv2;
                SliderKt$RangeSliderImpl$1$2 sliderKt$RangeSliderImpl$1$22 = new SliderKt$RangeSliderImpl$1$2(str, startInteractionSource, startThumbSemantics, sliderColors, enabled, $dirty);
                BoxScope $this$RangeSliderImpl_u24lambda_u2d142 = $this$RangeSliderImpl_u24lambda_u2d14;
                float offsetStart2 = offsetStart;
                m2056TempRangeSliderThumbrAjV9yQ($this$RangeSliderImpl_u24lambda_u2d142, offsetStart2, ComposableLambdaKt.composableLambda($composer3, -1592025586, true, sliderKt$RangeSliderImpl$1$2), $composer3, ($dirty3 & 14) | 384);
                float f = offsetStart2;
                m2056TempRangeSliderThumbrAjV9yQ($this$RangeSliderImpl_u24lambda_u2d142, offsetEnd, ComposableLambdaKt.composableLambda($composer3, -1141545019, true, new SliderKt$RangeSliderImpl$1$3(endContentDescription, endInteractionSource, endThumbSemantics, sliderColors, enabled, $dirty)), $composer3, ($dirty3 & 14) | 384);
            } else {
                $composer3.skipToGroupEnd();
                Density density2 = density$iv$iv2;
                String str3 = startContentDescription;
                BoxScope boxScope = $this$RangeSliderImpl_u24lambda_u2d14;
                MeasurePolicy measurePolicy2 = measurePolicy$iv;
                ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv;
                $composer$iv = $composer$iv2;
                Modifier modifier3 = modifier$iv;
            }
            $composer3.endReplaceableGroup();
        } else {
            $composer$iv2.skipToGroupEnd();
            String str4 = startContentDescription;
            Density density3 = density$iv$iv;
            MeasurePolicy measurePolicy3 = measurePolicy$iv;
            ViewConfiguration viewConfiguration3 = viewConfiguration$iv$iv;
            $composer$iv = $composer$iv2;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function3;
            Modifier modifier4 = modifier$iv;
        }
        $composer$iv.endReplaceableGroup();
        $composer2.endReplaceableGroup();
        $composer2.endNode();
        $composer2.endReplaceableGroup();
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$RangeSliderImpl$2(enabled, positionFractionStart, positionFractionEnd, tickFractions, colors, width, startInteractionSource, endInteractionSource, modifier, startThumbSemantics, endThumbSemantics, $changed, $changed1));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0352  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0385  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0396  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0446  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0456  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0557  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0563  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0569  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x05e1  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x05f8  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0952  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SliderImpl(androidx.compose.ui.Modifier r59, boolean r60, androidx.compose.foundation.interaction.MutableInteractionSource r61, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r62, kotlin.jvm.functions.Function0<kotlin.Unit> r63, int r64, float r65, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r66, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r67, kotlin.jvm.functions.Function3<? super androidx.compose.material3.SliderPositions, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r68, androidx.compose.runtime.Composer r69, int r70) {
        /*
            r15 = r60
            r14 = r61
            r13 = r62
            r12 = r63
            r11 = r65
            r10 = r66
            r9 = r67
            r8 = r68
            r7 = r70
            r0 = 851260148(0x32bd32f4, float:2.2025667E-8)
            r1 = r69
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(SliderImpl)P(2!5,8,9)810@35465L74,810@35427L112,816@35565L59,820@35647L45,821@35714L30,829@36086L7,830@36137L57,831@36217L31,835@36444L61,839@36638L492,850@37159L217,873@37816L40,878@37958L2112:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r1)
            r1 = r70
            r2 = r7 & 14
            if (r2 != 0) goto L_0x0033
            r3 = r59
            boolean r2 = r6.changed((java.lang.Object) r3)
            if (r2 == 0) goto L_0x0030
            r2 = 4
            goto L_0x0031
        L_0x0030:
            r2 = 2
        L_0x0031:
            r1 = r1 | r2
            goto L_0x0035
        L_0x0033:
            r3 = r59
        L_0x0035:
            r2 = r7 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0045
            boolean r2 = r6.changed((boolean) r15)
            if (r2 == 0) goto L_0x0042
            r2 = 32
            goto L_0x0044
        L_0x0042:
            r2 = 16
        L_0x0044:
            r1 = r1 | r2
        L_0x0045:
            r2 = r7 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0055
            boolean r2 = r6.changed((java.lang.Object) r14)
            if (r2 == 0) goto L_0x0052
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0054
        L_0x0052:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0054:
            r1 = r1 | r2
        L_0x0055:
            r2 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x0065
            boolean r2 = r6.changed((java.lang.Object) r13)
            if (r2 == 0) goto L_0x0062
            r2 = 2048(0x800, float:2.87E-42)
            goto L_0x0064
        L_0x0062:
            r2 = 1024(0x400, float:1.435E-42)
        L_0x0064:
            r1 = r1 | r2
        L_0x0065:
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r7
            if (r2 != 0) goto L_0x0077
            boolean r2 = r6.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0074
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0076
        L_0x0074:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x0076:
            r1 = r1 | r2
        L_0x0077:
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r7
            if (r2 != 0) goto L_0x008c
            r2 = r64
            boolean r16 = r6.changed((int) r2)
            if (r16 == 0) goto L_0x0087
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0089
        L_0x0087:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x0089:
            r1 = r1 | r16
            goto L_0x008e
        L_0x008c:
            r2 = r64
        L_0x008e:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r7 & r16
            if (r16 != 0) goto L_0x00a1
            boolean r16 = r6.changed((float) r11)
            if (r16 == 0) goto L_0x009d
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x009f
        L_0x009d:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x009f:
            r1 = r1 | r16
        L_0x00a1:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r7 & r16
            if (r16 != 0) goto L_0x00b4
            boolean r16 = r6.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00b0
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00b2
        L_0x00b0:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00b2:
            r1 = r1 | r16
        L_0x00b4:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r7 & r16
            if (r16 != 0) goto L_0x00c7
            boolean r16 = r6.changed((java.lang.Object) r9)
            if (r16 == 0) goto L_0x00c3
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x00c5
        L_0x00c3:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x00c5:
            r1 = r1 | r16
        L_0x00c7:
            r16 = 1879048192(0x70000000, float:1.58456325E29)
            r16 = r7 & r16
            if (r16 != 0) goto L_0x00da
            boolean r16 = r6.changed((java.lang.Object) r8)
            if (r16 == 0) goto L_0x00d6
            r16 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x00d8
        L_0x00d6:
            r16 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x00d8:
            r1 = r1 | r16
        L_0x00da:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r4 = r1 & r16
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r4 != r5) goto L_0x00f4
            boolean r4 = r6.getSkipping()
            if (r4 != 0) goto L_0x00eb
            goto L_0x00f4
        L_0x00eb:
            r6.skipToGroupEnd()
            r16 = r1
            r4 = r6
            r3 = r8
            goto L_0x0955
        L_0x00f4:
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0100
            r4 = -1
            java.lang.String r5 = "androidx.compose.material3.SliderImpl (Slider.kt:798)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r4, r5)
        L_0x0100:
            java.lang.Float r0 = java.lang.Float.valueOf(r65)
            int r4 = r1 >> 18
            r4 = r4 & 14
            int r5 = r1 >> 6
            r5 = r5 & 112(0x70, float:1.57E-43)
            r4 = r4 | r5
            r5 = 0
            r2 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r6.startReplaceableGroup(r2)
            java.lang.String r2 = "C(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r2)
            boolean r2 = r6.changed((java.lang.Object) r0)
            boolean r16 = r6.changed((java.lang.Object) r13)
            r2 = r2 | r16
            r16 = r6
            r17 = 0
            r18 = r0
            java.lang.Object r0 = r16.rememberedValue()
            r19 = 0
            if (r2 != 0) goto L_0x0142
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r2
            java.lang.Object r2 = r20.getEmpty()
            if (r0 != r2) goto L_0x013d
            goto L_0x0144
        L_0x013d:
            r20 = r0
            r2 = r16
            goto L_0x0154
        L_0x0142:
            r21 = r2
        L_0x0144:
            r2 = 0
            r20 = r0
            androidx.compose.material3.SliderKt$SliderImpl$onValueChangeState$1$1 r0 = new androidx.compose.material3.SliderKt$SliderImpl$onValueChangeState$1$1
            r0.<init>(r11, r13)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r2 = r16
            r2.updateRememberedValue(r0)
        L_0x0154:
            r6.endReplaceableGroup()
            r5 = 0
            androidx.compose.runtime.State r25 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r0, r6, r5)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r64)
            int r2 = r1 >> 15
            r2 = r2 & 14
            r4 = 0
            r5 = 1157296644(0x44faf204, float:2007.563)
            r6.startReplaceableGroup(r5)
            java.lang.String r5 = "C(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r5)
            boolean r16 = r6.changed((java.lang.Object) r0)
            r17 = r6
            r18 = 0
            r19 = r0
            java.lang.Object r0 = r17.rememberedValue()
            r20 = 0
            if (r16 != 0) goto L_0x0196
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r22 = r2
            java.lang.Object r2 = r21.getEmpty()
            if (r0 != r2) goto L_0x0190
            goto L_0x0198
        L_0x0190:
            r2 = r0
            r21 = r2
            r0 = r17
            goto L_0x01a5
        L_0x0196:
            r22 = r2
        L_0x0198:
            r2 = 0
            float[] r2 = stepsToTickFractions(r64)
            r21 = r0
            r0 = r17
            r0.updateRememberedValue(r2)
        L_0x01a5:
            r6.endReplaceableGroup()
            float[] r2 = (float[]) r2
            r0 = 0
            r4 = r0
            r0 = 0
            r16 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r0)
            java.lang.String r0 = "C(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r18 = 0
            r19 = r6
            r20 = 0
            java.lang.Object r3 = r19.rememberedValue()
            r21 = 0
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            r23 = r4
            java.lang.Object r4 = r22.getEmpty()
            r9 = 0
            if (r3 != r4) goto L_0x01ec
            r4 = 0
            float r22 = getThumbWidth()
            r28 = r3
            java.lang.Float r3 = java.lang.Float.valueOf(r22)
            r22 = r4
            r4 = 2
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r9, r4, r9)
            r4 = r19
            r4.updateRememberedValue(r3)
            goto L_0x01f0
        L_0x01ec:
            r28 = r3
            r4 = r19
        L_0x01f0:
            r6.endReplaceableGroup()
            androidx.compose.runtime.MutableState r3 = (androidx.compose.runtime.MutableState) r3
            r4 = 0
            r16 = r4
            r4 = 0
            r9 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r9)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r9 = 0
            r18 = r6
            r19 = 0
            r20 = r4
            java.lang.Object r4 = r18.rememberedValue()
            r21 = 0
            androidx.compose.runtime.Composer$Companion r22 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r22.getEmpty()
            if (r4 != r7) goto L_0x0231
            r7 = 0
            r23 = r4
            r22 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r22)
            r29 = r7
            r7 = 2
            r8 = 0
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r8, r7, r8)
            r7 = r18
            r7.updateRememberedValue(r4)
            goto L_0x0235
        L_0x0231:
            r23 = r4
            r7 = r18
        L_0x0235:
            r6.endReplaceableGroup()
            r9 = r4
            androidx.compose.runtime.MutableState r9 = (androidx.compose.runtime.MutableState) r9
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r7 = 0
            r8 = 0
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r14 = "C:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r6, r15, r14)
            java.lang.Object r15 = r6.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r6)
            androidx.compose.ui.unit.LayoutDirection r4 = androidx.compose.ui.unit.LayoutDirection.Rtl
            if (r15 != r4) goto L_0x025a
            r4 = 1
            goto L_0x025b
        L_0x025a:
            r4 = 0
        L_0x025b:
            r15 = 16
            r7 = 0
            r8 = r7
            r7 = 0
            r15 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r15)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r15 = 0
            r16 = r6
            r18 = 0
            r19 = r7
            java.lang.Object r7 = r16.rememberedValue()
            r20 = 0
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            r22 = r8
            java.lang.Object r8 = r21.getEmpty()
            r13 = 0
            if (r7 != r8) goto L_0x029b
            r8 = 0
            float r21 = SliderImpl$scaleToOffset(r10, r13, r13, r11)
            java.lang.Float r13 = java.lang.Float.valueOf(r21)
            r21 = r7
            r24 = r8
            r7 = 2
            r8 = 0
            androidx.compose.runtime.MutableState r13 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r13, r8, r7, r8)
            r7 = r16
            r7.updateRememberedValue(r13)
            goto L_0x02a1
        L_0x029b:
            r21 = r7
            r7 = r16
            r13 = r21
        L_0x02a1:
            r6.endReplaceableGroup()
            r30 = r13
            androidx.compose.runtime.MutableState r30 = (androidx.compose.runtime.MutableState) r30
            r7 = 0
            r8 = r7
            r7 = 0
            r13 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r13)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r13 = 0
            r15 = r6
            r16 = 0
            r18 = r7
            java.lang.Object r7 = r15.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r8
            java.lang.Object r8 = r20.getEmpty()
            if (r7 != r8) goto L_0x02e4
            r8 = 0
            r22 = r7
            r20 = 0
            java.lang.Float r7 = java.lang.Float.valueOf(r20)
            r20 = r8
            r23 = r13
            r8 = 2
            r13 = 0
            androidx.compose.runtime.MutableState r7 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r7, r13, r8, r13)
            r15.updateRememberedValue(r7)
            goto L_0x02e9
        L_0x02e4:
            r22 = r7
            r23 = r13
            r8 = 2
        L_0x02e9:
            r6.endReplaceableGroup()
            r24 = r7
            androidx.compose.runtime.MutableState r24 = (androidx.compose.runtime.MutableState) r24
            java.lang.Comparable r7 = r66.getStart()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            java.lang.Comparable r13 = r66.getEndInclusive()
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            float r15 = kotlin.ranges.RangesKt.coerceIn((float) r11, (float) r7, (float) r13)
            java.lang.Comparable r7 = r66.getStart()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            java.lang.Comparable r13 = r66.getEndInclusive()
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            float r13 = calcFraction(r7, r13, r15)
            r7 = 0
            r16 = r7
            r7 = 0
            r8 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r8)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r0)
            r0 = 0
            r8 = r6
            r17 = 0
            r18 = r0
            java.lang.Object r0 = r8.rememberedValue()
            r19 = 0
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r21 = r7
            java.lang.Object r7 = r20.getEmpty()
            if (r0 != r7) goto L_0x0352
            r7 = 0
            r20 = r0
            androidx.compose.material3.SliderPositions r0 = new androidx.compose.material3.SliderPositions
            r0.<init>(r13, r2)
            r8.updateRememberedValue(r0)
            goto L_0x0354
        L_0x0352:
            r20 = r0
        L_0x0354:
            r6.endReplaceableGroup()
            r8 = r0
            androidx.compose.material3.SliderPositions r8 = (androidx.compose.material3.SliderPositions) r8
            r8.setPositionFraction$material3_release(r13)
            r8.setTickFractions$material3_release(r2)
            int r0 = r1 >> 21
            r0 = r0 & 14
            r7 = 0
            r32 = r7
            r7 = 1157296644(0x44faf204, float:2007.563)
            r6.startReplaceableGroup(r7)
            androidx.compose.runtime.ComposerKt.sourceInformation(r6, r5)
            boolean r16 = r6.changed((java.lang.Object) r10)
            r27 = r6
            r33 = r16
            r34 = 0
            java.lang.Object r7 = r27.rememberedValue()
            r36 = 0
            if (r33 != 0) goto L_0x0396
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            r37 = r0
            java.lang.Object r0 = r16.getEmpty()
            if (r7 != r0) goto L_0x0390
            goto L_0x0398
        L_0x0390:
            r16 = r1
            r0 = r7
            r1 = r27
            goto L_0x03c1
        L_0x0396:
            r37 = r0
        L_0x0398:
            r0 = 0
            r38 = r0
            androidx.compose.material3.SliderDraggableState r0 = new androidx.compose.material3.SliderDraggableState
            androidx.compose.material3.SliderKt$SliderImpl$draggableState$1$1 r39 = new androidx.compose.material3.SliderKt$SliderImpl$draggableState$1$1
            r16 = r39
            r17 = r9
            r18 = r3
            r19 = r30
            r20 = r24
            r21 = r2
            r22 = r25
            r23 = r66
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)
            r16 = r1
            r1 = r39
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r0.<init>(r1)
            r1 = r27
            r1.updateRememberedValue(r0)
        L_0x03c1:
            r6.endReplaceableGroup()
            r7 = r0
            androidx.compose.material3.SliderDraggableState r7 = (androidx.compose.material3.SliderDraggableState) r7
            androidx.compose.material3.SliderKt$SliderImpl$gestureEndAction$1 r0 = new androidx.compose.material3.SliderKt$SliderImpl$gestureEndAction$1
            r0.<init>(r7, r12)
            r1 = 0
            androidx.compose.runtime.State r0 = androidx.compose.runtime.SnapshotStateKt.rememberUpdatedState(r0, r6, r1)
            androidx.compose.ui.Modifier$Companion r17 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r17 = (androidx.compose.ui.Modifier) r17
            r18 = r7
            androidx.compose.foundation.gestures.DraggableState r18 = (androidx.compose.foundation.gestures.DraggableState) r18
            java.lang.Object r19 = r9.getValue()
            java.lang.Number r19 = (java.lang.Number) r19
            int r19 = r19.intValue()
            r20 = r30
            androidx.compose.runtime.State r20 = (androidx.compose.runtime.State) r20
            r21 = r0
            r0 = r17
            r17 = r1
            r1 = r18
            r18 = r2
            r2 = r61
            r40 = r3
            r3 = r19
            r19 = r9
            r10 = 1157296644(0x44faf204, float:2007.563)
            r9 = r5
            r5 = r20
            r20 = r15
            r15 = r6
            r6 = r21
            r22 = r7
            r7 = r24
            r42 = r8
            r8 = r60
            androidx.compose.ui.Modifier r0 = sliderTapModifier(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.foundation.gestures.Orientation r7 = androidx.compose.foundation.gestures.Orientation.Horizontal
            boolean r2 = r22.isDragging()
            r5 = r1
            androidx.compose.ui.Modifier r5 = (androidx.compose.ui.Modifier) r5
            r6 = r22
            androidx.compose.foundation.gestures.DraggableState r6 = (androidx.compose.foundation.gestures.DraggableState) r6
            r3 = 64
            r8 = 0
            r15.startReplaceableGroup(r10)
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r9)
            r10 = r21
            boolean r9 = r15.changed((java.lang.Object) r10)
            r21 = r15
            r23 = 0
            java.lang.Object r1 = r21.rememberedValue()
            r27 = 0
            if (r9 != 0) goto L_0x0456
            androidx.compose.runtime.Composer$Companion r31 = androidx.compose.runtime.Composer.Companion
            r32 = r3
            java.lang.Object r3 = r31.getEmpty()
            if (r1 != r3) goto L_0x0451
            goto L_0x0458
        L_0x0451:
            r31 = r1
            r3 = r21
            goto L_0x046b
        L_0x0456:
            r32 = r3
        L_0x0458:
            r3 = 0
            r31 = r1
            androidx.compose.material3.SliderKt$SliderImpl$drag$1$1 r1 = new androidx.compose.material3.SliderKt$SliderImpl$drag$1$1
            r33 = r3
            r3 = 0
            r1.<init>(r10, r3)
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r3 = r21
            r3.updateRememberedValue(r1)
        L_0x046b:
            r15.endReplaceableGroup()
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r3 = 32
            r21 = 0
            r8 = r60
            r43 = r19
            r9 = r61
            r19 = r10
            r10 = r2
            r2 = 0
            r11 = r2
            r12 = r1
            r1 = r13
            r13 = r4
            r2 = r61
            r44 = r14
            r14 = r3
            r3 = r60
            r69 = r4
            r4 = r15
            r15 = r21
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            androidx.compose.ui.Modifier r5 = androidx.compose.material3.TouchTargetKt.minimumTouchTargetSize(r59)
            androidx.compose.material3.tokens.SliderTokens r6 = androidx.compose.material3.tokens.SliderTokens.INSTANCE
            float r6 = r6.m2659getHandleWidthD9Ej5fM()
            androidx.compose.material3.tokens.SliderTokens r7 = androidx.compose.material3.tokens.SliderTokens.INSTANCE
            float r7 = r7.m2658getHandleHeightD9Ej5fM()
            r8 = 0
            r9 = 0
            r10 = 12
            r11 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m826requiredSizeInqDBjuR0$default(r5, r6, r7, r8, r9, r10, r11)
            r6 = r65
            r7 = r60
            r8 = r62
            r9 = r63
            r10 = r66
            r11 = r64
            androidx.compose.ui.Modifier r5 = sliderSemantics(r5, r6, r7, r8, r9, r10, r11)
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.FocusableKt.focusable(r5, r3, r2)
            androidx.compose.ui.Modifier r5 = r5.then(r0)
            androidx.compose.ui.Modifier r5 = r5.then(r12)
            androidx.compose.material3.SliderKt$SliderImpl$2 r6 = new androidx.compose.material3.SliderKt$SliderImpl$2
            r7 = r40
            r8 = r43
            r6.<init>(r7, r8, r1)
            androidx.compose.ui.layout.MeasurePolicy r6 = (androidx.compose.ui.layout.MeasurePolicy) r6
            r9 = r17
            r10 = 0
            r11 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r4.startReplaceableGroup(r11)
            java.lang.String r13 = "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r4, r13)
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r14 = 6
            r15 = 0
            r21 = r0
            r11 = r44
            r0 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r11)
            java.lang.Object r23 = r4.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r13 = r23
            androidx.compose.ui.unit.Density r13 = (androidx.compose.ui.unit.Density) r13
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r14 = (androidx.compose.runtime.CompositionLocal) r14
            r15 = 6
            r23 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r11)
            java.lang.Object r26 = r4.consume(r14)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r14 = r26
            androidx.compose.ui.unit.LayoutDirection r14 = (androidx.compose.ui.unit.LayoutDirection) r14
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r15 = (androidx.compose.runtime.CompositionLocal) r15
            r23 = 6
            r26 = 0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r4, r0, r11)
            java.lang.Object r27 = r4.consume(r15)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r4)
            r15 = r27
            androidx.compose.ui.platform.ViewConfiguration r15 = (androidx.compose.ui.platform.ViewConfiguration) r15
            androidx.compose.ui.node.ComposeUiNode$Companion r23 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r23 = r23.getConstructor()
            kotlin.jvm.functions.Function3 r26 = androidx.compose.ui.layout.LayoutKt.materializerOf(r5)
            int r0 = r9 << 9
            r0 = r0 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | 6
            r27 = r26
            r26 = r23
            r23 = 0
            r28 = r1
            androidx.compose.runtime.Applier r1 = r4.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x055a
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x055a:
            r4.startReusableNode()
            boolean r1 = r4.getInserting()
            if (r1 == 0) goto L_0x0569
            r1 = r26
            r4.createNode(r1)
            goto L_0x056e
        L_0x0569:
            r1 = r26
            r4.useNode()
        L_0x056e:
            r4.disableReusing()
            r26 = r1
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m2787constructorimpl(r4)
            r29 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r31 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r31.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r1, r6, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r1, r13, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r1, r14, r2)
            androidx.compose.ui.node.ComposeUiNode$Companion r2 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r2 = r2.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r1, r15, r2)
            r4.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r4)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r1)
            int r2 = r0 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = r27
            r3.invoke(r1, r4, r2)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r4.startReplaceableGroup(r1)
            int r2 = r0 >> 9
            r2 = r2 & 14
            r27 = r4
            r29 = 0
            r1 = 1870435165(0x6f7c935d, float:7.8168374E28)
            r32 = r0
            r0 = r27
            r0.startReplaceableGroup(r1)
            java.lang.String r1 = "C880@37988L84,881@38085L84:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r2 & 11
            r27 = r2
            r2 = 2
            if (r1 != r2) goto L_0x05f8
            boolean r1 = r0.getSkipping()
            if (r1 != 0) goto L_0x05e1
            goto L_0x05f8
        L_0x05e1:
            r0.skipToGroupEnd()
            r34 = r3
            r35 = r5
            r38 = r6
            r46 = r7
            r47 = r8
            r49 = r9
            r43 = r10
            r5 = r42
            r3 = r68
            goto L_0x093d
        L_0x05f8:
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.material3.SliderComponents r2 = androidx.compose.material3.SliderComponents.THUMB
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r1, r2)
            r2 = 6
            r33 = 0
            r34 = r3
            r3 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getTopStart()
            r35 = r5
            r5 = 0
            int r36 = r2 >> 3
            r36 = r36 & 14
            int r37 = r2 >> 3
            r37 = r37 & 112(0x70, float:1.57E-43)
            r38 = r6
            r6 = r36 | r37
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r3, r5, r0, r6)
            int r36 = r2 << 3
            r36 = r36 & 112(0x70, float:1.57E-43)
            r37 = 0
            r39 = r3
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r40 = 6
            r43 = 0
            r44 = r5
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r5, r11)
            java.lang.Object r5 = r0.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            r3 = r5
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r5 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r5 = (androidx.compose.runtime.CompositionLocal) r5
            r40 = 6
            r43 = 0
            r46 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r7, r11)
            java.lang.Object r7 = r0.consume(r5)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            r5 = r7
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r40 = 6
            r43 = 0
            r47 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r8, r11)
            java.lang.Object r8 = r0.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            r7 = r8
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
            kotlin.jvm.functions.Function3 r40 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            r43 = r1
            int r1 = r36 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | 6
            r48 = r40
            r40 = 0
            r49 = r9
            androidx.compose.runtime.Applier r9 = r0.getApplier()
            boolean r9 = r9 instanceof androidx.compose.runtime.Applier
            if (r9 != 0) goto L_0x06b7
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x06b7:
            r0.startReusableNode()
            boolean r9 = r0.getInserting()
            if (r9 == 0) goto L_0x06c4
            r0.createNode(r8)
            goto L_0x06c7
        L_0x06c4:
            r0.useNode()
        L_0x06c7:
            r0.disableReusing()
            androidx.compose.runtime.Composer r9 = androidx.compose.runtime.Updater.m2787constructorimpl(r0)
            r50 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r51 = androidx.compose.ui.node.ComposeUiNode.Companion
            r52 = r8
            kotlin.jvm.functions.Function2 r8 = r51.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r9, r6, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r9, r3, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r9, r5, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r9, r7, r8)
            r0.enableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r8)
            int r9 = r1 >> 3
            r9 = r9 & 112(0x70, float:1.57E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r50 = r3
            r3 = r48
            r3.invoke(r8, r0, r9)
            r8 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r8)
            int r8 = r1 >> 9
            r8 = r8 & 14
            r9 = r0
            r48 = 0
            r51 = r1
            r1 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r9.startReplaceableGroup(r1)
            java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r9, r1)
            r1 = r8 & 11
            r53 = r3
            r3 = 2
            if (r1 != r3) goto L_0x0747
            boolean r1 = r9.getSkipping()
            if (r1 != 0) goto L_0x0739
            goto L_0x0747
        L_0x0739:
            r9.skipToGroupEnd()
            r3 = r67
            r57 = r2
            r58 = r42
            r42 = r5
            r5 = r58
            goto L_0x0799
        L_0x0747:
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r3 = r2 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r54 = r9
            r55 = 0
            r56 = r1
            r1 = -1220826601(0xffffffffb73baa17, float:-1.1185671E-5)
            r57 = r2
            r2 = r54
            r2.startReplaceableGroup(r1)
            java.lang.String r1 = "C880@38048L22:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            r1 = r3 & 81
            r54 = r3
            r3 = 16
            if (r1 != r3) goto L_0x0781
            boolean r1 = r2.getSkipping()
            if (r1 != 0) goto L_0x0775
            goto L_0x0781
        L_0x0775:
            r2.skipToGroupEnd()
            r3 = r67
            r58 = r42
            r42 = r5
            r5 = r58
            goto L_0x0796
        L_0x0781:
            int r1 = r16 >> 21
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3 = r67
            r58 = r42
            r42 = r5
            r5 = r58
            r3.invoke(r5, r2, r1)
        L_0x0796:
            r2.endReplaceableGroup()
        L_0x0799:
            r9.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.material3.SliderComponents r2 = androidx.compose.material3.SliderComponents.TRACK
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.LayoutIdKt.layoutId(r1, r2)
            r2 = 6
            r6 = 0
            r7 = 733328855(0x2bb5b5d7, float:1.2911294E-12)
            r0.startReplaceableGroup(r7)
            java.lang.String r7 = "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r7)
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r7 = r7.getTopStart()
            r8 = 0
            int r9 = r2 >> 3
            r9 = r9 & 14
            int r33 = r2 >> 3
            r33 = r33 & 112(0x70, float:1.57E-43)
            r9 = r9 | r33
            androidx.compose.ui.layout.MeasurePolicy r9 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r7, r8, r0, r9)
            int r33 = r2 << 3
            r33 = r33 & 112(0x70, float:1.57E-43)
            r36 = 0
            r3 = -1323940314(0xffffffffb1164626, float:-2.1867748E-9)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r17 = 6
            r37 = 0
            r39 = r6
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r6, r11)
            java.lang.Object r6 = r0.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            r3 = r6
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r6 = (androidx.compose.runtime.CompositionLocal) r6
            r17 = 6
            r37 = 0
            r40 = r7
            r7 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r7, r11)
            java.lang.Object r7 = r0.consume(r6)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            r6 = r7
            androidx.compose.ui.unit.LayoutDirection r6 = (androidx.compose.ui.unit.LayoutDirection) r6
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalViewConfiguration()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r17 = 6
            r37 = 0
            r42 = r8
            r8 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r8, r11)
            java.lang.Object r8 = r0.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r0)
            r7 = r8
            androidx.compose.ui.platform.ViewConfiguration r7 = (androidx.compose.ui.platform.ViewConfiguration) r7
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r8.getConstructor()
            kotlin.jvm.functions.Function3 r11 = androidx.compose.ui.layout.LayoutKt.materializerOf(r1)
            r17 = r1
            int r1 = r33 << 9
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | 6
            r37 = 0
            r43 = r10
            androidx.compose.runtime.Applier r10 = r0.getApplier()
            boolean r10 = r10 instanceof androidx.compose.runtime.Applier
            if (r10 != 0) goto L_0x085f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x085f:
            r0.startReusableNode()
            boolean r10 = r0.getInserting()
            if (r10 == 0) goto L_0x086c
            r0.createNode(r8)
            goto L_0x086f
        L_0x086c:
            r0.useNode()
        L_0x086f:
            r0.disableReusing()
            androidx.compose.runtime.Composer r10 = androidx.compose.runtime.Updater.m2787constructorimpl(r0)
            r44 = 0
            androidx.compose.ui.node.ComposeUiNode$Companion r45 = androidx.compose.ui.node.ComposeUiNode.Companion
            r48 = r8
            kotlin.jvm.functions.Function2 r8 = r45.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r10, r9, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetDensity()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r10, r3, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r10, r6, r8)
            androidx.compose.ui.node.ComposeUiNode$Companion r8 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function2 r8 = r8.getSetViewConfiguration()
            androidx.compose.runtime.Updater.m2794setimpl((androidx.compose.runtime.Composer) r10, r7, r8)
            r0.enableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m2779constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m2778boximpl(r8)
            int r10 = r1 >> 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r11.invoke(r8, r0, r10)
            r8 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r8)
            int r8 = r1 >> 9
            r8 = r8 & 14
            r10 = r0
            r31 = 0
            r44 = r1
            r1 = -2137368960(0xffffffff809a5680, float:-1.4173697E-38)
            r10.startReplaceableGroup(r1)
            java.lang.String r1 = "C72@3384L9:Box.kt#2w3rfo"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r8 & 11
            r45 = r3
            r3 = 2
            if (r1 != r3) goto L_0x08e5
            boolean r1 = r10.getSkipping()
            if (r1 != 0) goto L_0x08dd
            goto L_0x08e5
        L_0x08dd:
            r10.skipToGroupEnd()
            r3 = r68
            r52 = r2
            goto L_0x092b
        L_0x08e5:
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r3 = r2 >> 6
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | 6
            androidx.compose.foundation.layout.BoxScope r1 = (androidx.compose.foundation.layout.BoxScope) r1
            r41 = r10
            r50 = 0
            r51 = r1
            r1 = 971611456(0x39e99d40, float:4.4558384E-4)
            r52 = r2
            r2 = r41
            r2.startReplaceableGroup(r1)
            java.lang.String r1 = "C881@38145L22:Slider.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r2, r1)
            r1 = r3 & 81
            r41 = r3
            r3 = 16
            if (r1 != r3) goto L_0x0919
            boolean r1 = r2.getSkipping()
            if (r1 != 0) goto L_0x0913
            goto L_0x0919
        L_0x0913:
            r2.skipToGroupEnd()
            r3 = r68
            goto L_0x0928
        L_0x0919:
            int r1 = r16 >> 24
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3 = r68
            r3.invoke(r5, r2, r1)
        L_0x0928:
            r2.endReplaceableGroup()
        L_0x092b:
            r10.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x093d:
            r0.endReplaceableGroup()
            r4.endReplaceableGroup()
            r4.endNode()
            r4.endReplaceableGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0955
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0955:
            androidx.compose.runtime.ScopeUpdateScope r12 = r4.endRestartGroup()
            if (r12 != 0) goto L_0x095d
            r14 = r4
            goto L_0x097f
        L_0x095d:
            androidx.compose.material3.SliderKt$SliderImpl$3 r13 = new androidx.compose.material3.SliderKt$SliderImpl$3
            r0 = r13
            r1 = r59
            r2 = r60
            r3 = r61
            r14 = r4
            r4 = r62
            r5 = r63
            r6 = r64
            r7 = r65
            r8 = r66
            r9 = r67
            r10 = r68
            r11 = r70
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x097f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.SliderImpl(androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, int, float, kotlin.ranges.ClosedFloatingPointRange, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final float SliderImpl$scaleToUserValue(ClosedFloatingPointRange<Float> $valueRange, float minPx, float maxPx, float offset) {
        return scale(minPx, maxPx, offset, $valueRange.getStart().floatValue(), $valueRange.getEndInclusive().floatValue());
    }

    /* access modifiers changed from: private */
    public static final float SliderImpl$scaleToOffset(ClosedFloatingPointRange<Float> $valueRange, float minPx, float maxPx, float userValue) {
        return scale($valueRange.getStart().floatValue(), $valueRange.getEndInclusive().floatValue(), userValue, minPx, maxPx);
    }

    /* access modifiers changed from: private */
    /* renamed from: TempRangeSliderThumb-rAjV9yQ  reason: not valid java name */
    public static final void m2056TempRangeSliderThumbrAjV9yQ(BoxScope $this$TempRangeSliderThumb_u2drAjV9yQ, float offset, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        BoxScope boxScope = $this$TempRangeSliderThumb_u2drAjV9yQ;
        float f = offset;
        Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(-2104116536);
        ComposerKt.sourceInformation($composer2, "C(TempRangeSliderThumb)P(1:c#ui.unit.Dp)950@40233L133:Slider.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changed((Object) boxScope) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer2.changed(f) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer2.changed((Object) function3) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2104116536, $dirty2, -1, "androidx.compose.material3.TempRangeSliderThumb (Slider.kt:946)");
            }
            Modifier modifier$iv = boxScope.align(PaddingKt.m764paddingqDBjuR0$default(Modifier.Companion, offset, 0.0f, 0.0f, 0.0f, 14, (Object) null), Alignment.Companion.getCenterStart());
            int $changed$iv = ($dirty2 << 3) & 7168;
            $composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer2, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            Alignment alignment = contentAlignment$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            int i2 = $changed$iv$iv;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer2);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            Composer $composer$iv = $composer2;
            int i3 = $changed$iv$iv$iv;
            $composer$iv.startReplaceableGroup(-2137368960);
            ComposerKt.sourceInformation($composer$iv, "C72@3384L9:Box.kt#2w3rfo");
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
            if ((($changed$iv$iv$iv >> 9) & 14 & 11) != 2 || !$composer$iv.getSkipping()) {
                function3.invoke(BoxScopeInstance.INSTANCE, $composer$iv, Integer.valueOf((($changed$iv >> 6) & 112) | 6));
            } else {
                $composer$iv.skipToGroupEnd();
            }
            $composer$iv.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SliderKt$TempRangeSliderThumb$1(boxScope, f, function3, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: TempRangeSliderTrack-au3_HiA  reason: not valid java name */
    public static final void m2057TempRangeSliderTrackau3_HiA(Modifier modifier, SliderColors colors, boolean enabled, float positionFractionStart, float positionFractionEnd, float[] tickFractions, float thumbWidth, float trackStrokeWidth, Composer $composer, int $changed) {
        SliderColors sliderColors = colors;
        boolean z = enabled;
        Composer $composer2 = $composer.startRestartGroup(1015664062);
        ComposerKt.sourceInformation($composer2, "C(TempRangeSliderTrack)P(2!2,4!1,6,5:c#ui.unit.Dp)*972@40747L7,976@40881L35,977@40951L34,978@41021L34,979@41089L33,980@41127L1518:Slider.kt#uh7d8r");
        int $dirty = $changed;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1015664062, $dirty, -1, "androidx.compose.material3.TempRangeSliderTrack (Slider.kt:960)");
        }
        Ref.FloatRef thumbRadiusPx = new Ref.FloatRef();
        Ref.FloatRef tickSize = new Ref.FloatRef();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer2);
        Density $this$TempRangeSliderTrack_au3_HiA_u24lambda_u2d27 = (Density) consume;
        thumbRadiusPx.element = $this$TempRangeSliderTrack_au3_HiA_u24lambda_u2d27.m5967toPx0680j_4(thumbWidth) / ((float) 2);
        tickSize.element = $this$TempRangeSliderTrack_au3_HiA_u24lambda_u2d27.m5967toPx0680j_4(TickSize);
        Modifier modifier2 = modifier;
        CanvasKt.Canvas(modifier2, new SliderKt$TempRangeSliderTrack$2(thumbRadiusPx, sliderColors.trackColor$material3_release(z, false, $composer2, (($dirty >> 6) & 14) | 48 | (($dirty << 3) & 896)), trackStrokeWidth, positionFractionEnd, positionFractionStart, sliderColors.trackColor$material3_release(z, true, $composer2, (($dirty >> 6) & 14) | 48 | (($dirty << 3) & 896)), tickFractions, sliderColors.tickColor$material3_release(z, false, $composer2, (($dirty >> 6) & 14) | 48 | (($dirty << 3) & 896)), sliderColors.tickColor$material3_release(z, true, $composer2, (($dirty >> 6) & 14) | 48 | (($dirty << 3) & 896)), tickSize), $composer2, $dirty & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Ref.FloatRef floatRef = tickSize;
            Ref.FloatRef floatRef2 = thumbRadiusPx;
            return;
        }
        Ref.FloatRef floatRef3 = tickSize;
        Ref.FloatRef floatRef4 = thumbRadiusPx;
        endRestartGroup.updateScope(new SliderKt$TempRangeSliderTrack$3(modifier, colors, enabled, positionFractionStart, positionFractionEnd, tickFractions, thumbWidth, trackStrokeWidth, $changed));
    }

    /* access modifiers changed from: private */
    public static final float snapValueToTick(float current, float[] tickFractions, float minPx, float maxPx) {
        Float f;
        float[] $this$minByOrNull$iv = tickFractions;
        if ($this$minByOrNull$iv.length == 0) {
            f = null;
        } else {
            float minElem$iv = $this$minByOrNull$iv[0];
            int lastIndex$iv = ArraysKt.getLastIndex($this$minByOrNull$iv);
            if (lastIndex$iv == 0) {
                f = Float.valueOf(minElem$iv);
            } else {
                float minValue$iv = Math.abs(MathHelpersKt.lerp(minPx, maxPx, minElem$iv) - current);
                IntIterator it = new IntRange(1, lastIndex$iv).iterator();
                while (it.hasNext()) {
                    float e$iv = $this$minByOrNull$iv[it.nextInt()];
                    float v$iv = Math.abs(MathHelpersKt.lerp(minPx, maxPx, e$iv) - current);
                    if (Float.compare(minValue$iv, v$iv) > 0) {
                        minElem$iv = e$iv;
                        minValue$iv = v$iv;
                    }
                }
                f = Float.valueOf(minElem$iv);
            }
        }
        if (f != null) {
            return MathHelpersKt.lerp(minPx, maxPx, f.floatValue());
        }
        return current;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: awaitSlop-8vUncbI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m2061awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, long r9, int r11, kotlin.coroutines.Continuation<? super kotlin.Pair<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float>> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.material3.SliderKt$awaitSlop$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = (androidx.compose.material3.SliderKt$awaitSlop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = new androidx.compose.material3.SliderKt$awaitSlop$1
            r0.<init>(r12)
        L_0x0019:
            r12 = r0
            java.lang.Object r6 = r12.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r12.label
            switch(r0) {
                case 0: goto L_0x0036;
                case 1: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x002d:
            java.lang.Object r8 = r12.L$0
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref.FloatRef) r8
            kotlin.ResultKt.throwOnFailure(r6)
            r9 = r6
            goto L_0x0056
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            r0 = r8
            r1 = r9
            r3 = r11
            kotlin.jvm.internal.Ref$FloatRef r8 = new kotlin.jvm.internal.Ref$FloatRef
            r8.<init>()
            androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1 r9 = new androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1
            r9.<init>(r8)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r12.L$0 = r8
            r10 = 1
            r12.label = r10
            r4 = r9
            r5 = r12
            java.lang.Object r9 = androidx.compose.material3.DragGestureDetectorCopyKt.m1891awaitHorizontalPointerSlopOrCancellationgDDlDlE(r0, r1, r3, r4, r5)
            if (r9 != r7) goto L_0x0056
            return r7
        L_0x0056:
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 == 0) goto L_0x0065
            float r10 = r8.element
            java.lang.Float r10 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10)
            kotlin.Pair r10 = kotlin.TuplesKt.to(r9, r10)
            goto L_0x0066
        L_0x0065:
            r10 = 0
        L_0x0066:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.m2061awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final float[] stepsToTickFractions(int steps) {
        if (steps == 0) {
            return new float[0];
        }
        int i = steps + 2;
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            fArr[i2] = ((float) i2) / ((float) (steps + 1));
        }
        return fArr;
    }

    /* access modifiers changed from: private */
    public static final float scale(float a1, float b1, float x1, float a2, float b2) {
        return MathHelpersKt.lerp(a2, b2, calcFraction(a1, b1, x1));
    }

    /* access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> scale(float a1, float b1, ClosedFloatingPointRange<Float> x, float a2, float b2) {
        return RangesKt.rangeTo(scale(a1, b1, x.getStart().floatValue(), a2, b2), scale(a1, b1, x.getEndInclusive().floatValue(), a2, b2));
    }

    /* access modifiers changed from: private */
    public static final float calcFraction(float a, float b, float pos) {
        return RangesKt.coerceIn(((b - a) > 0.0f ? 1 : ((b - a) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (pos - a) / (b - a), 0.0f, 1.0f);
    }

    static /* synthetic */ Modifier sliderSemantics$default(Modifier modifier, float f, boolean z, Function1 function1, Function0 function0, ClosedFloatingPointRange closedFloatingPointRange, int i, int i2, Object obj) {
        Function0 function02;
        if ((i2 & 8) != 0) {
            function02 = null;
        } else {
            function02 = function0;
        }
        return sliderSemantics(modifier, f, z, function1, function02, (i2 & 16) != 0 ? RangesKt.rangeTo(0.0f, 1.0f) : closedFloatingPointRange, (i2 & 32) != 0 ? 0 : i);
    }

    /* access modifiers changed from: private */
    public static final Modifier sliderSemantics(Modifier $this$sliderSemantics, float value, boolean enabled, Function1<? super Float, Unit> onValueChange, Function0<Unit> onValueChangeFinished, ClosedFloatingPointRange<Float> valueRange, int steps) {
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default($this$sliderSemantics, false, new SliderKt$sliderSemantics$1(enabled, valueRange, steps, RangesKt.coerceIn(value, valueRange.getStart().floatValue(), valueRange.getEndInclusive().floatValue()), onValueChange, onValueChangeFinished), 1, (Object) null), value, valueRange, steps);
    }

    private static final Modifier sliderTapModifier(Modifier $this$sliderTapModifier, DraggableState draggableState, MutableInteractionSource interactionSource, int maxPx, boolean isRtl, State<Float> rawOffset, State<? extends Function0<Unit>> gestureEndAction, MutableState<Float> pressOffset, boolean enabled) {
        Modifier modifier = $this$sliderTapModifier;
        return ComposedModifierKt.composed($this$sliderTapModifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1(draggableState, interactionSource, maxPx, isRtl, rawOffset, gestureEndAction, pressOffset, enabled) : InspectableValueKt.getNoInspectorInfo(), new SliderKt$sliderTapModifier$2(enabled, draggableState, interactionSource, maxPx, isRtl, pressOffset, rawOffset, gestureEndAction));
    }

    /* access modifiers changed from: private */
    public static final Object animateToTarget(DraggableState draggableState, float current, float target, float velocity, Continuation<? super Unit> $completion) {
        Object drag$default = DraggableState.drag$default(draggableState, (MutatePriority) null, new SliderKt$animateToTarget$2(current, target, velocity, (Continuation<? super SliderKt$animateToTarget$2>) null), $completion, 1, (Object) null);
        return drag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? drag$default : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Modifier rangeSliderPressDragModifier(Modifier $this$rangeSliderPressDragModifier, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, State<Float> rawOffsetStart, State<Float> rawOffsetEnd, boolean enabled, boolean isRtl, float maxPx, ClosedFloatingPointRange<Float> valueRange, State<? extends Function1<? super Boolean, Unit>> gestureEndAction, State<? extends Function2<? super Boolean, ? super Float, Unit>> onDrag) {
        if (enabled) {
            Modifier modifier = $this$rangeSliderPressDragModifier;
            return SuspendingPointerInputFilterKt.pointerInput($this$rangeSliderPressDragModifier, new Object[]{startInteractionSource, endInteractionSource, Float.valueOf(maxPx), Boolean.valueOf(isRtl), valueRange}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SliderKt$rangeSliderPressDragModifier$1(startInteractionSource, endInteractionSource, rawOffsetStart, rawOffsetEnd, onDrag, isRtl, maxPx, gestureEndAction, (Continuation<? super SliderKt$rangeSliderPressDragModifier$1>) null));
        }
        MutableInteractionSource mutableInteractionSource = startInteractionSource;
        MutableInteractionSource mutableInteractionSource2 = endInteractionSource;
        ClosedFloatingPointRange<Float> closedFloatingPointRange = valueRange;
        return $this$rangeSliderPressDragModifier;
    }

    static {
        float r0 = SliderTokens.INSTANCE.m2659getHandleWidthD9Ej5fM();
        ThumbWidth = r0;
        float r1 = SliderTokens.INSTANCE.m2658getHandleHeightD9Ej5fM();
        ThumbHeight = r1;
        ThumbSize = DpKt.m6008DpSizeYgX7TsA(r0, r1);
        float r02 = Dp.m5986constructorimpl((float) 48);
        SliderHeight = r02;
        float r12 = Dp.m5986constructorimpl((float) 144);
        SliderMinWidth = r12;
        DefaultSliderConstraints = SizeKt.m818heightInVpY3zN4$default(SizeKt.m837widthInVpY3zN4$default(Modifier.Companion, r12, 0.0f, 2, (Object) null), 0.0f, r02, 1, (Object) null);
    }

    public static final float getThumbWidth() {
        return ThumbWidth;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }
}
