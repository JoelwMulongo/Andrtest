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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0011\u0010$\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0011\u0010&\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0006\u0010'\u001a\u00020\u0006J\u001b\u0010(\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b)\u0010*R\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\t8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00068FX\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Landroidx/compose/material/BottomSheetState;", "", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "currentValue", "getCurrentValue", "()Landroidx/compose/material/BottomSheetValue;", "isAnimationRunning", "isAnimationRunning$material_release", "()Z", "isCollapsed", "isExpanded", "offset", "getOffset$annotations", "()V", "getOffset", "()F", "progress", "getProgress", "swipeableState", "Landroidx/compose/material/SwipeableV2State;", "getSwipeableState$material_release", "()Landroidx/compose/material/SwipeableV2State;", "animateTo", "", "target", "velocity", "animateTo$material_release", "(Landroidx/compose/material/BottomSheetValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collapse", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expand", "requireOffset", "snapTo", "snapTo$material_release", "(Landroidx/compose/material/BottomSheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
public final class BottomSheetState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final SwipeableV2State<BottomSheetValue> swipeableState;

    @Deprecated(message = "Use requireOffset() to access the offset.", replaceWith = @ReplaceWith(expression = "requireOffset()", imports = {}))
    public static /* synthetic */ void getOffset$annotations() {
    }

    public BottomSheetState(BottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> confirmValueChange) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        this.swipeableState = new SwipeableV2State(initialValue, animationSpec, confirmValueChange, (Function2) null, 0.0f, 24, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BottomSheetState(BottomSheetValue bottomSheetValue, AnimationSpec animationSpec, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bottomSheetValue, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 4) != 0 ? AnonymousClass1.INSTANCE : function1);
    }

    public final SwipeableV2State<BottomSheetValue> getSwipeableState$material_release() {
        return this.swipeableState;
    }

    public final BottomSheetValue getCurrentValue() {
        return this.swipeableState.getCurrentValue();
    }

    public final boolean isExpanded() {
        return this.swipeableState.getCurrentValue() == BottomSheetValue.Expanded;
    }

    public final boolean isCollapsed() {
        return this.swipeableState.getCurrentValue() == BottomSheetValue.Collapsed;
    }

    public final float getProgress() {
        return this.swipeableState.getProgress();
    }

    public final Object expand(Continuation<? super Unit> $completion) {
        Object animateTo$default = SwipeableV2State.animateTo$default(this.swipeableState, this.swipeableState.hasAnchorForValue(BottomSheetValue.Expanded) ? BottomSheetValue.Expanded : BottomSheetValue.Collapsed, 0.0f, $completion, 2, (Object) null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    public final Object collapse(Continuation<? super Unit> $completion) {
        Object animateTo$default = SwipeableV2State.animateTo$default(this.swipeableState, BottomSheetValue.Collapsed, 0.0f, $completion, 2, (Object) null);
        return animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo$default : Unit.INSTANCE;
    }

    public final float getOffset() {
        throw new IllegalStateException("Use requireOffset() to access the offset.".toString());
    }

    public final float requireOffset() {
        return this.swipeableState.requireOffset();
    }

    public static /* synthetic */ Object animateTo$material_release$default(BottomSheetState bottomSheetState, BottomSheetValue bottomSheetValue, float f, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            f = bottomSheetState.swipeableState.getLastVelocity();
        }
        return bottomSheetState.animateTo$material_release(bottomSheetValue, f, continuation);
    }

    public final Object animateTo$material_release(BottomSheetValue target, float velocity, Continuation<? super Unit> $completion) {
        Object animateTo = this.swipeableState.animateTo(target, velocity, $completion);
        return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
    }

    public final Object snapTo$material_release(BottomSheetValue target, Continuation<? super Unit> $completion) {
        Object snapTo = this.swipeableState.snapTo(target, $completion);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }

    public final boolean isAnimationRunning$material_release() {
        return this.swipeableState.isAnimationRunning();
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¨\u0006\r"}, d2 = {"Landroidx/compose/material/BottomSheetState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/BottomSheetState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Landroidx/compose/material/BottomSheetValue;", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BottomSheetScaffold.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<BottomSheetState, ?> Saver(AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> confirmStateChange) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
            return SaverKt.Saver(BottomSheetState$Companion$Saver$1.INSTANCE, new BottomSheetState$Companion$Saver$2(animationSpec, confirmStateChange));
        }
    }
}
