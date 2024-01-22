package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeableV2.kt */
final class SwipeableV2Kt$rememberSwipeableV2State$2 extends Lambda implements Function0<SwipeableV2State<T>> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Function1<T, Boolean> $confirmValueChange;
    final /* synthetic */ T $initialValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableV2Kt$rememberSwipeableV2State$2(T t, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> function1) {
        super(0);
        this.$initialValue = t;
        this.$animationSpec = animationSpec;
        this.$confirmValueChange = function1;
    }

    public final SwipeableV2State<T> invoke() {
        return new SwipeableV2State(this.$initialValue, this.$animationSpec, this.$confirmValueChange, SwipeableV2Defaults.INSTANCE.getPositionalThreshold(), SwipeableV2Defaults.INSTANCE.m1639getVelocityThresholdD9Ej5fM(), (DefaultConstructorMarker) null);
    }
}
