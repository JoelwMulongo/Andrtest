package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSlider$2$gestureEndAction$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Ref.FloatRef $maxPx;
    final /* synthetic */ Ref.FloatRef $minPx;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ State<Function1<ClosedFloatingPointRange<Float>, Unit>> $onValueChangeState;
    final /* synthetic */ MutableState<Float> $rawOffsetEnd;
    final /* synthetic */ MutableState<Float> $rawOffsetStart;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ List<Float> $tickFractions;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$2$gestureEndAction$1(MutableState<Float> mutableState, MutableState<Float> mutableState2, List<Float> list, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Function0<Unit> function0, CoroutineScope coroutineScope, State<? extends Function1<? super ClosedFloatingPointRange<Float>, Unit>> state, ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        super(1);
        this.$rawOffsetStart = mutableState;
        this.$rawOffsetEnd = mutableState2;
        this.$tickFractions = list;
        this.$minPx = floatRef;
        this.$maxPx = floatRef2;
        this.$onValueChangeFinished = function0;
        this.$scope = coroutineScope;
        this.$onValueChangeState = state;
        this.$valueRange = closedFloatingPointRange;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isStart) {
        float current = (isStart ? this.$rawOffsetStart : this.$rawOffsetEnd).getValue().floatValue();
        float target = SliderKt.snapValueToTick(current, this.$tickFractions, this.$minPx.element, this.$maxPx.element);
        if (current == target) {
            Function0<Unit> function0 = this.$onValueChangeFinished;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        CoroutineScope coroutineScope = this.$scope;
        final Function0<Unit> function02 = this.$onValueChangeFinished;
        final MutableState<Float> mutableState = this.$rawOffsetStart;
        final MutableState<Float> mutableState2 = this.$rawOffsetEnd;
        final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state = this.$onValueChangeState;
        final Ref.FloatRef floatRef = this.$minPx;
        final Ref.FloatRef floatRef2 = this.$maxPx;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$valueRange;
        final float f = current;
        final float f2 = target;
        final boolean z = isStart;
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1", f = "Slider.kt", i = {}, l = {360}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.SliderKt$RangeSlider$2$gestureEndAction$1$1  reason: invalid class name */
    /* compiled from: Slider.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(f, f2, function02, z, mutableState, mutableState2, state, floatRef, floatRef2, closedFloatingPointRange, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            AnonymousClass1 r0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Object $result2 = $result;
                    Float boxFloat = Boxing.boxFloat(0.0f);
                    final boolean z = z;
                    final MutableState<Float> mutableState = mutableState;
                    final MutableState<Float> mutableState2 = mutableState2;
                    State<Function1<ClosedFloatingPointRange<Float>, Unit>> state = state;
                    Ref.FloatRef floatRef = floatRef;
                    Ref.FloatRef floatRef2 = floatRef2;
                    final ClosedFloatingPointRange<Float> closedFloatingPointRange = closedFloatingPointRange;
                    final State<Function1<ClosedFloatingPointRange<Float>, Unit>> state2 = state;
                    final Ref.FloatRef floatRef3 = floatRef;
                    final Ref.FloatRef floatRef4 = floatRef2;
                    this.label = 1;
                    if (AnimatableKt.Animatable$default(f, 0.0f, 2, (Object) null).animateTo(Boxing.boxFloat(f2), SliderKt.SliderToTickAnimation, boxFloat, new Function1<Animatable<Float, AnimationVector1D>, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            invoke((Animatable<Float, AnimationVector1D>) (Animatable) p1);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Animatable<Float, AnimationVector1D> $this$animateTo) {
                            Intrinsics.checkNotNullParameter($this$animateTo, "$this$animateTo");
                            (z ? mutableState : mutableState2).setValue($this$animateTo.getValue());
                            state2.getValue().invoke(SliderKt$RangeSlider$2.invoke$scaleToUserValue(floatRef3, floatRef4, closedFloatingPointRange, RangesKt.rangeTo(mutableState.getValue().floatValue(), mutableState2.getValue().floatValue())));
                        }
                    }, this) != coroutine_suspended) {
                        r0 = this;
                        Object obj = $result2;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    r0 = this;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Function0<Unit> function0 = function02;
            if (function0 != null) {
                function0.invoke();
            }
            return Unit.INSTANCE;
        }
    }
}
