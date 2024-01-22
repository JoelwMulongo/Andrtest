package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Switch.kt */
final class SwitchKt$Switch$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ float $minBound;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $offset;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwitchKt$Switch$2(Animatable<Float, AnimationVector1D> animatable, float f) {
        super(0);
        this.$offset = animatable;
        this.$minBound = f;
    }

    public final void invoke() {
        Animatable.updateBounds$default(this.$offset, Float.valueOf(this.$minBound), (Object) null, 2, (Object) null);
    }
}
