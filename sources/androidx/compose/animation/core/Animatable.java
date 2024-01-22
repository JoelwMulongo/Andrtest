package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B/\b\u0017\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\tB7\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\\\u0010:\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010;2\u0006\u0010<\u001a\u00028\u00002\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>2'\b\u0002\u0010?\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020A\u0018\u00010@¢\u0006\u0002\bBH@ø\u0001\u0000¢\u0006\u0002\u0010CJh\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010;2\u0006\u0010)\u001a\u00028\u00002\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000E2\b\b\u0002\u0010<\u001a\u00028\u00002'\b\u0002\u0010?\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020A\u0018\u00010@¢\u0006\u0002\bBH@ø\u0001\u0000¢\u0006\u0002\u0010FJ\f\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00000HJ\u0015\u0010I\u001a\u00028\u00002\u0006\u00103\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010JJ\b\u0010K\u001a\u00020AH\u0002J`\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010;2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010N2\u0006\u0010<\u001a\u00028\u00002%\u0010?\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020A\u0018\u00010@¢\u0006\u0002\bBH@ø\u0001\u0000¢\u0006\u0002\u0010OJ\u0019\u0010P\u001a\u00020A2\u0006\u0010)\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010QJ\u0011\u0010R\u001a\u00020AH@ø\u0001\u0000¢\u0006\u0002\u0010SJ#\u0010T\u001a\u00020A2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u00100\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010UJ\u0019\u0010V\u001a\u00028\u0001*\u00028\u00002\u0006\u00103\u001a\u00020WH\u0002¢\u0006\u0002\u0010XR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168F@BX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00018\u00002\b\u0010\u0015\u001a\u0004\u0018\u00018\u0000@BX\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0010\u0010#\u001a\u00028\u0001X\u000e¢\u0006\u0004\n\u0002\u0010$R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00028\u0001X\u0004¢\u0006\u0004\n\u0002\u0010$R\u0010\u0010(\u001a\u00028\u0001X\u0004¢\u0006\u0004\n\u0002\u0010$R+\u0010)\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00008F@BX\u0002¢\u0006\u0012\n\u0004\b-\u0010\u001c\u001a\u0004\b*\u0010!\"\u0004\b+\u0010,R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00018\u00002\b\u0010\u0015\u001a\u0004\u0018\u00018\u0000@BX\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b1\u0010!R\u0010\u00102\u001a\u00028\u0001X\u000e¢\u0006\u0004\n\u0002\u0010$R\u0011\u00103\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b4\u0010!R\u0011\u00105\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b6\u0010!R\u0011\u00107\u001a\u00028\u00018F¢\u0006\u0006\u001a\u0004\b8\u00109R\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\"\u0002\u0004\n\u0002\b\u0019¨\u0006Y"}, d2 = {"Landroidx/compose/animation/core/Animatable;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "initialValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "visibilityThreshold", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)V", "label", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/String;)V", "defaultSpringSpec", "Landroidx/compose/animation/core/SpringSpec;", "getDefaultSpringSpec$animation_core_release", "()Landroidx/compose/animation/core/SpringSpec;", "internalState", "Landroidx/compose/animation/core/AnimationState;", "getInternalState$animation_core_release", "()Landroidx/compose/animation/core/AnimationState;", "<set-?>", "", "isRunning", "()Z", "setRunning", "(Z)V", "isRunning$delegate", "Landroidx/compose/runtime/MutableState;", "getLabel", "()Ljava/lang/String;", "lowerBound", "getLowerBound", "()Ljava/lang/Object;", "Ljava/lang/Object;", "lowerBoundVector", "Landroidx/compose/animation/core/AnimationVector;", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "negativeInfinityBounds", "positiveInfinityBounds", "targetValue", "getTargetValue", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "upperBound", "getUpperBound", "upperBoundVector", "value", "getValue", "velocity", "getVelocity", "velocityVector", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "animateDecay", "Landroidx/compose/animation/core/AnimationResult;", "initialVelocity", "animationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "Landroidx/compose/animation/core/AnimationSpec;", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asState", "Landroidx/compose/runtime/State;", "clampToBounds", "(Ljava/lang/Object;)Ljava/lang/Object;", "endAnimation", "runAnimation", "animation", "Landroidx/compose/animation/core/Animation;", "(Landroidx/compose/animation/core/Animation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBounds", "(Ljava/lang/Object;Ljava/lang/Object;)V", "createVector", "", "(Ljava/lang/Object;F)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Animatable.kt */
public final class Animatable<T, V extends AnimationVector> {
    public static final int $stable = 8;
    private final SpringSpec<T> defaultSpringSpec;
    private final AnimationState<T, V> internalState;
    private final MutableState isRunning$delegate;
    private final String label;
    private T lowerBound;
    private V lowerBoundVector;
    private final MutatorMutex mutatorMutex;
    private final V negativeInfinityBounds;
    private final V positiveInfinityBounds;
    private final MutableState targetValue$delegate;
    private final TwoWayConverter<T, V> typeConverter;
    private T upperBound;
    private V upperBoundVector;
    private final T visibilityThreshold;

    public Animatable(T initialValue, TwoWayConverter<T, V> typeConverter2, T visibilityThreshold2, String label2) {
        T t = initialValue;
        TwoWayConverter<T, V> twoWayConverter = typeConverter2;
        String str = label2;
        Intrinsics.checkNotNullParameter(twoWayConverter, "typeConverter");
        Intrinsics.checkNotNullParameter(str, "label");
        this.typeConverter = twoWayConverter;
        this.visibilityThreshold = visibilityThreshold2;
        this.label = str;
        AnimationState<T, V> animationState = r1;
        AnimationState<T, V> animationState2 = new AnimationState<>(typeConverter2, initialValue, (AnimationVector) null, 0, 0, false, 60, (DefaultConstructorMarker) null);
        this.internalState = animationState;
        this.isRunning$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.targetValue$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.mutatorMutex = new MutatorMutex();
        this.defaultSpringSpec = new SpringSpec(0.0f, 0.0f, visibilityThreshold2, 3, (DefaultConstructorMarker) null);
        V createVector = createVector(t, Float.NEGATIVE_INFINITY);
        this.negativeInfinityBounds = createVector;
        V createVector2 = createVector(t, Float.POSITIVE_INFINITY);
        this.positiveInfinityBounds = createVector2;
        this.lowerBoundVector = createVector;
        this.upperBoundVector = createVector2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Animatable(Object obj, TwoWayConverter twoWayConverter, Object obj2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, twoWayConverter, (i & 4) != 0 ? null : obj2, (i & 8) != 0 ? "Animatable" : str);
    }

    public final TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public final String getLabel() {
        return this.label;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Animatable(Object obj, TwoWayConverter twoWayConverter, Object obj2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, twoWayConverter, (i & 4) != 0 ? null : obj2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility", replaceWith = @ReplaceWith(expression = "Animatable(initialValue, typeConverter, visibilityThreshold, \"Animatable\")", imports = {}))
    public /* synthetic */ Animatable(Object initialValue, TwoWayConverter typeConverter2, Object visibilityThreshold2) {
        this(initialValue, typeConverter2, visibilityThreshold2, "Animatable");
        Intrinsics.checkNotNullParameter(typeConverter2, "typeConverter");
    }

    public final AnimationState<T, V> getInternalState$animation_core_release() {
        return this.internalState;
    }

    public final T getValue() {
        return this.internalState.getValue();
    }

    public final V getVelocityVector() {
        return this.internalState.getVelocityVector();
    }

    public final T getVelocity() {
        return this.typeConverter.getConvertFromVector().invoke(getVelocityVector());
    }

    /* access modifiers changed from: private */
    public final void setRunning(boolean z) {
        this.isRunning$delegate.setValue(Boolean.valueOf(z));
    }

    public final boolean isRunning() {
        return ((Boolean) this.isRunning$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public final void setTargetValue(T t) {
        this.targetValue$delegate.setValue(t);
    }

    public final T getTargetValue() {
        return this.targetValue$delegate.getValue();
    }

    public final T getLowerBound() {
        return this.lowerBound;
    }

    public final T getUpperBound() {
        return this.upperBound;
    }

    public final SpringSpec<T> getDefaultSpringSpec$animation_core_release() {
        return this.defaultSpringSpec;
    }

    private final V createVector(T $this$createVector, float value) {
        AnimationVector newVector = this.typeConverter.getConvertToVector().invoke($this$createVector);
        int size$animation_core_release = newVector.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            newVector.set$animation_core_release(i, value);
        }
        return newVector;
    }

    public static /* synthetic */ void updateBounds$default(Animatable animatable, T t, T t2, int i, Object obj) {
        if ((i & 1) != 0) {
            t = animatable.lowerBound;
        }
        if ((i & 2) != 0) {
            t2 = animatable.upperBound;
        }
        animatable.updateBounds(t, t2);
    }

    public final void updateBounds(T lowerBound2, T upperBound2) {
        AnimationVector animationVector;
        AnimationVector animationVector2;
        if (lowerBound2 == null || (animationVector = this.typeConverter.getConvertToVector().invoke(lowerBound2)) == null) {
            animationVector = this.negativeInfinityBounds;
        }
        AnimationVector lowerBoundVector2 = animationVector;
        if (upperBound2 == null || (animationVector2 = this.typeConverter.getConvertToVector().invoke(upperBound2)) == null) {
            animationVector2 = this.positiveInfinityBounds;
        }
        AnimationVector upperBoundVector2 = animationVector2;
        int i = 0;
        int size$animation_core_release = lowerBoundVector2.getSize$animation_core_release();
        while (i < size$animation_core_release) {
            if (lowerBoundVector2.get$animation_core_release(i) <= upperBoundVector2.get$animation_core_release(i)) {
                i++;
            } else {
                throw new IllegalStateException(("Lower bound must be no greater than upper bound on *all* dimensions. The provided lower bound: " + lowerBoundVector2 + " is greater than upper bound " + upperBoundVector2 + " on index " + i).toString());
            }
        }
        this.lowerBoundVector = lowerBoundVector2;
        this.upperBoundVector = upperBoundVector2;
        this.upperBound = upperBound2;
        this.lowerBound = lowerBound2;
        if (!isRunning()) {
            Object clampedValue = clampToBounds(getValue());
            if (!Intrinsics.areEqual(clampedValue, getValue())) {
                this.internalState.setValue$animation_core_release(clampedValue);
            }
        }
    }

    public static /* synthetic */ Object animateTo$default(Animatable animatable, Object obj, AnimationSpec animationSpec, Object obj2, Function1 function1, Continuation continuation, int i, Object obj3) {
        AnimationSpec animationSpec2;
        Object obj4;
        Function1 function12;
        if ((i & 2) != 0) {
            animationSpec2 = animatable.defaultSpringSpec;
        } else {
            animationSpec2 = animationSpec;
        }
        if ((i & 4) != 0) {
            obj4 = animatable.getVelocity();
        } else {
            obj4 = obj2;
        }
        if ((i & 8) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        return animatable.animateTo(obj, animationSpec2, obj4, function12, continuation);
    }

    public final Object animateTo(T targetValue, AnimationSpec<T> animationSpec, T initialVelocity, Function1<? super Animatable<T, V>, Unit> block, Continuation<? super AnimationResult<T, V>> $completion) {
        return runAnimation(AnimationKt.TargetBasedAnimation(animationSpec, this.typeConverter, getValue(), targetValue, initialVelocity), initialVelocity, block, $completion);
    }

    public static /* synthetic */ Object animateDecay$default(Animatable animatable, Object obj, DecayAnimationSpec decayAnimationSpec, Function1 function1, Continuation continuation, int i, Object obj2) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        return animatable.animateDecay(obj, decayAnimationSpec, function1, continuation);
    }

    public final Object animateDecay(T initialVelocity, DecayAnimationSpec<T> animationSpec, Function1<? super Animatable<T, V>, Unit> block, Continuation<? super AnimationResult<T, V>> $completion) {
        return runAnimation(new DecayAnimation(animationSpec, this.typeConverter, getValue(), (AnimationVector) this.typeConverter.getConvertToVector().invoke(initialVelocity)), initialVelocity, block, $completion);
    }

    /* access modifiers changed from: private */
    public final Object runAnimation(Animation<T, V> animation, T initialVelocity, Function1<? super Animatable<T, V>, Unit> block, Continuation<? super AnimationResult<T, V>> $completion) {
        long startTime = this.internalState.getLastFrameTimeNanos();
        return MutatorMutex.mutate$default(this.mutatorMutex, (MutatePriority) null, new Animatable$runAnimation$2(this, initialVelocity, animation, startTime, block, (Continuation<? super Animatable$runAnimation$2>) null), $completion, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final T clampToBounds(T value) {
        if (Intrinsics.areEqual((Object) this.lowerBoundVector, (Object) this.negativeInfinityBounds) && Intrinsics.areEqual((Object) this.upperBoundVector, (Object) this.positiveInfinityBounds)) {
            return value;
        }
        AnimationVector valueVector = (AnimationVector) this.typeConverter.getConvertToVector().invoke(value);
        boolean clamped = false;
        int size$animation_core_release = valueVector.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            if (valueVector.get$animation_core_release(i) < this.lowerBoundVector.get$animation_core_release(i) || valueVector.get$animation_core_release(i) > this.upperBoundVector.get$animation_core_release(i)) {
                clamped = true;
                valueVector.set$animation_core_release(i, RangesKt.coerceIn(valueVector.get$animation_core_release(i), this.lowerBoundVector.get$animation_core_release(i), this.upperBoundVector.get$animation_core_release(i)));
            }
        }
        if (clamped) {
            return this.typeConverter.getConvertFromVector().invoke(valueVector);
        }
        return value;
    }

    /* access modifiers changed from: private */
    public final void endAnimation() {
        AnimationState $this$endAnimation_u24lambda_u243 = this.internalState;
        $this$endAnimation_u24lambda_u243.getVelocityVector().reset$animation_core_release();
        $this$endAnimation_u24lambda_u243.setLastFrameTimeNanos$animation_core_release(Long.MIN_VALUE);
        setRunning(false);
    }

    public final Object snapTo(T targetValue, Continuation<? super Unit> $completion) {
        Object mutate$default = MutatorMutex.mutate$default(this.mutatorMutex, (MutatePriority) null, new Animatable$snapTo$2(this, targetValue, (Continuation<? super Animatable$snapTo$2>) null), $completion, 1, (Object) null);
        return mutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate$default : Unit.INSTANCE;
    }

    public final Object stop(Continuation<? super Unit> $completion) {
        Object mutate$default = MutatorMutex.mutate$default(this.mutatorMutex, (MutatePriority) null, new Animatable$stop$2(this, (Continuation<? super Animatable$stop$2>) null), $completion, 1, (Object) null);
        return mutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate$default : Unit.INSTANCE;
    }

    public final State<T> asState() {
        return this.internalState;
    }
}
