package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/material/SwipeableState;", "T", "", "it", "invoke", "(Ljava/lang/Object;)Landroidx/compose/material/SwipeableState;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Swipeable.kt */
final class SwipeableState$Companion$Saver$2 extends Lambda implements Function1<T, SwipeableState<T>> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Function1<T, Boolean> $confirmStateChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableState$Companion$Saver$2(AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> function1) {
        super(1);
        this.$animationSpec = animationSpec;
        this.$confirmStateChange = function1;
    }

    public final SwipeableState<T> invoke(T it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new SwipeableState<>(it, this.$animationSpec, this.$confirmStateChange);
    }
}
