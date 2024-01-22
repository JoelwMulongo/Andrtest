package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/material/SwipeableV2State;", "T", "", "it", "invoke", "(Ljava/lang/Object;)Landroidx/compose/material/SwipeableV2State;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeableV2.kt */
final class SwipeableV2State$Companion$Saver$2 extends Lambda implements Function1<T, SwipeableV2State<T>> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Function1<T, Boolean> $confirmValueChange;
    final /* synthetic */ Function2<Density, Float, Float> $positionalThreshold;
    final /* synthetic */ float $velocityThreshold;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableV2State$Companion$Saver$2(AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> function1, Function2<? super Density, ? super Float, Float> function2, float f) {
        super(1);
        this.$animationSpec = animationSpec;
        this.$confirmValueChange = function1;
        this.$positionalThreshold = function2;
        this.$velocityThreshold = f;
    }

    public final SwipeableV2State<T> invoke(T it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new SwipeableV2State(it, this.$animationSpec, this.$confirmValueChange, this.$positionalThreshold, this.$velocityThreshold, (DefaultConstructorMarker) null);
    }
}
