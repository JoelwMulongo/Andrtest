package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$Slider$3$gestureEndAction$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ SliderDraggableState $draggableState;
    final /* synthetic */ Ref.FloatRef $maxPx;
    final /* synthetic */ Ref.FloatRef $minPx;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ MutableState<Float> $rawOffset;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ List<Float> $tickFractions;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$Slider$3$gestureEndAction$1(MutableState<Float> mutableState, List<Float> list, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, CoroutineScope coroutineScope, SliderDraggableState sliderDraggableState, Function0<Unit> function0) {
        super(1);
        this.$rawOffset = mutableState;
        this.$tickFractions = list;
        this.$minPx = floatRef;
        this.$maxPx = floatRef2;
        this.$scope = coroutineScope;
        this.$draggableState = sliderDraggableState;
        this.$onValueChangeFinished = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float velocity) {
        Function0<Unit> function0;
        float current = this.$rawOffset.getValue().floatValue();
        float target = SliderKt.snapValueToTick(current, this.$tickFractions, this.$minPx.element, this.$maxPx.element);
        if (!(current == target)) {
            CoroutineScope coroutineScope = this.$scope;
            final SliderDraggableState sliderDraggableState = this.$draggableState;
            final Function0<Unit> function02 = this.$onValueChangeFinished;
            final float f = current;
            final float f2 = target;
            final float f3 = velocity;
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        } else if (!this.$draggableState.isDragging() && (function0 = this.$onValueChangeFinished) != null) {
            function0.invoke();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1", f = "Slider.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1  reason: invalid class name */
    /* compiled from: Slider.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(sliderDraggableState, f, f2, f3, function02, continuation);
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
                    this.label = 1;
                    if (SliderKt.animateToTarget(sliderDraggableState, f, f2, f3, this) != coroutine_suspended) {
                        r0 = this;
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
