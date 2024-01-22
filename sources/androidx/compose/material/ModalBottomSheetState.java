package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nB=\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\fJ%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u0013\u0010(\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u0013\u0010+\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0004\b,\u0010*J\u0011\u0010-\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010*J\r\u0010.\u001a\u00020\u0006H\u0000¢\u0006\u0002\b/J\u0011\u00100\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010*J\u001b\u00101\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b2\u00103R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Landroidx/compose/material/ModalBottomSheetState;", "", "initialValue", "Landroidx/compose/material/ModalBottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "isSkipHalfExpanded", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;)V", "getAnimationSpec$material_release", "()Landroidx/compose/animation/core/AnimationSpec;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/ModalBottomSheetValue;", "hasHalfExpandedState", "getHasHalfExpandedState$material_release", "()Z", "isAnimationRunning", "isAnimationRunning$material_release", "isSkipHalfExpanded$material_release", "isVisible", "lastVelocity", "getLastVelocity$material_release", "()F", "swipeableState", "Landroidx/compose/material/SwipeableV2State;", "getSwipeableState$material_release", "()Landroidx/compose/material/SwipeableV2State;", "targetValue", "getTargetValue", "animateTo", "", "target", "velocity", "animateTo$material_release", "(Landroidx/compose/material/ModalBottomSheetValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expand", "expand$material_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "halfExpand", "halfExpand$material_release", "hide", "requireOffset", "requireOffset$material_release", "show", "snapTo", "snapTo$material_release", "(Landroidx/compose/material/ModalBottomSheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
public final class ModalBottomSheetState {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AnimationSpec<Float> animationSpec;
    private final boolean isSkipHalfExpanded;
    private final SwipeableV2State<ModalBottomSheetValue> swipeableState;

    @Deprecated(message = "This constructor is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "ModalBottomSheetState(initialValue, animationSpec, confirmStateChange, isSkipHalfExpanded)", imports = {}))
    public ModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec2, boolean isSkipHalfExpanded2, Function1<? super ModalBottomSheetValue, Boolean> confirmStateChange) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        this.animationSpec = animationSpec2;
        this.isSkipHalfExpanded = isSkipHalfExpanded2;
        this.swipeableState = new SwipeableV2State(initialValue, animationSpec2, confirmStateChange, ModalBottomSheetKt.PositionalThreshold, ModalBottomSheetKt.VelocityThreshold, (DefaultConstructorMarker) null);
        if (isSkipHalfExpanded2) {
            if (!(initialValue != ModalBottomSheetValue.HalfExpanded)) {
                throw new IllegalArgumentException("The initial value must not be set to HalfExpanded if skipHalfExpanded is set to true.".toString());
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec animationSpec2, boolean z, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(modalBottomSheetValue, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec2, (i & 4) != 0 ? false : z, function1);
    }

    public final AnimationSpec<Float> getAnimationSpec$material_release() {
        return this.animationSpec;
    }

    public final boolean isSkipHalfExpanded$material_release() {
        return this.isSkipHalfExpanded;
    }

    public final SwipeableV2State<ModalBottomSheetValue> getSwipeableState$material_release() {
        return this.swipeableState;
    }

    public final ModalBottomSheetValue getCurrentValue() {
        return this.swipeableState.getCurrentValue();
    }

    public final ModalBottomSheetValue getTargetValue() {
        return this.swipeableState.getTargetValue();
    }

    public final boolean isVisible() {
        return this.swipeableState.getCurrentValue() != ModalBottomSheetValue.Hidden;
    }

    public final boolean getHasHalfExpandedState$material_release() {
        return this.swipeableState.hasAnchorForValue(ModalBottomSheetValue.HalfExpanded);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "This constructor is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "ModalBottomSheetState(initialValue, animationSpec, confirmStateChange, false)", imports = {}))
    public ModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec2, Function1<? super ModalBottomSheetValue, Boolean> confirmStateChange) {
        this(initialValue, animationSpec2, false, confirmStateChange);
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec2, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
    }

    public final Object show(Continuation<? super Unit> $completion) {
        ModalBottomSheetValue targetValue;
        if (getHasHalfExpandedState$material_release()) {
            targetValue = ModalBottomSheetValue.HalfExpanded;
        } else {
            targetValue = ModalBottomSheetValue.Expanded;
        }
        Object animateTo$material_release$default = animateTo$material_release$default(this, targetValue, 0.0f, $completion, 2, (Object) null);
        return animateTo$material_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material_release$default : Unit.INSTANCE;
    }

    public final Object halfExpand$material_release(Continuation<? super Unit> $completion) {
        if (!getHasHalfExpandedState$material_release()) {
            return Unit.INSTANCE;
        }
        Object animateTo$material_release$default = animateTo$material_release$default(this, ModalBottomSheetValue.HalfExpanded, 0.0f, $completion, 2, (Object) null);
        return animateTo$material_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material_release$default : Unit.INSTANCE;
    }

    public final Object expand$material_release(Continuation<? super Unit> $completion) {
        if (!this.swipeableState.hasAnchorForValue(ModalBottomSheetValue.Expanded)) {
            return Unit.INSTANCE;
        }
        Object animateTo$material_release$default = animateTo$material_release$default(this, ModalBottomSheetValue.Expanded, 0.0f, $completion, 2, (Object) null);
        return animateTo$material_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material_release$default : Unit.INSTANCE;
    }

    public final Object hide(Continuation<? super Unit> $completion) {
        Object animateTo$material_release$default = animateTo$material_release$default(this, ModalBottomSheetValue.Hidden, 0.0f, $completion, 2, (Object) null);
        return animateTo$material_release$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$material_release$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$material_release$default(ModalBottomSheetState modalBottomSheetState, ModalBottomSheetValue modalBottomSheetValue, float f, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            f = modalBottomSheetState.swipeableState.getLastVelocity();
        }
        return modalBottomSheetState.animateTo$material_release(modalBottomSheetValue, f, continuation);
    }

    public final Object animateTo$material_release(ModalBottomSheetValue target, float velocity, Continuation<? super Unit> $completion) {
        Object animateTo = this.swipeableState.animateTo(target, velocity, $completion);
        return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
    }

    public final Object snapTo$material_release(ModalBottomSheetValue target, Continuation<? super Unit> $completion) {
        Object snapTo = this.swipeableState.snapTo(target, $completion);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }

    public final float requireOffset$material_release() {
        return this.swipeableState.requireOffset();
    }

    public final float getLastVelocity$material_release() {
        return this.swipeableState.getLastVelocity();
    }

    public final boolean isAnimationRunning$material_release() {
        return this.swipeableState.isAnimationRunning();
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\fJ<\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/ModalBottomSheetState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/ModalBottomSheetState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "Landroidx/compose/material/ModalBottomSheetValue;", "", "skipHalfExpanded", "confirmStateChange", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ModalBottomSheet.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<ModalBottomSheetState, ?> Saver(AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> confirmValueChange, boolean skipHalfExpanded) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
            return SaverKt.Saver(ModalBottomSheetState$Companion$Saver$1.INSTANCE, new ModalBottomSheetState$Companion$Saver$2(animationSpec, confirmValueChange, skipHalfExpanded));
        }

        @Deprecated(message = "This function is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "Saver(animationSpec, confirmStateChange, skipHalfExpanded)", imports = {}))
        public final Saver<ModalBottomSheetState, ?> Saver(AnimationSpec<Float> animationSpec, boolean skipHalfExpanded, Function1<? super ModalBottomSheetValue, Boolean> confirmStateChange) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
            return Saver(animationSpec, confirmStateChange, skipHalfExpanded);
        }
    }
}
