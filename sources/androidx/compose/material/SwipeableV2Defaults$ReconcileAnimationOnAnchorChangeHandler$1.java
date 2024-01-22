package androidx.compose.material;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0015\u0010\u0003\u001a\u0011H\u0002¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062!\u0010\u0007\u001a\u001d\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072!\u0010\n\u001a\u001d\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\nH\n"}, d2 = {"<anonymous>", "", "T", "previousTarget", "Lkotlin/ParameterName;", "name", "previousTargetValue", "previousAnchors", "", "", "newAnchors"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeableV2.kt */
final class SwipeableV2Defaults$ReconcileAnimationOnAnchorChangeHandler$1 implements AnchorChangeHandler<T> {
    final /* synthetic */ Function2<T, Float, Unit> $animate;
    final /* synthetic */ Function1<T, Unit> $snap;
    final /* synthetic */ SwipeableV2State<T> $state;

    SwipeableV2Defaults$ReconcileAnimationOnAnchorChangeHandler$1(Function2<? super T, ? super Float, Unit> function2, SwipeableV2State<T> swipeableV2State, Function1<? super T, Unit> function1) {
        this.$animate = function2;
        this.$state = swipeableV2State;
        this.$snap = function1;
    }

    public final void onAnchorsChanged(T previousTarget, Map<T, Float> previousAnchors, Map<T, Float> newAnchors) {
        Intrinsics.checkNotNullParameter(previousAnchors, "previousAnchors");
        Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
        Float newTargetOffset = newAnchors.get(previousTarget);
        if (Intrinsics.areEqual(previousAnchors.get(previousTarget), newTargetOffset)) {
            return;
        }
        if (newTargetOffset != null) {
            this.$animate.invoke(previousTarget, Float.valueOf(this.$state.getLastVelocity()));
        } else {
            this.$snap.invoke(SwipeableV2Kt.closestAnchor$default(newAnchors, this.$state.requireOffset(), false, 2, (Object) null));
        }
    }
}
