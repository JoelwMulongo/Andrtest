package androidx.compose.material;

import androidx.compose.animation.core.KeyframesSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$CircularProgressIndicator$endAngle$2 extends Lambda implements Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit> {
    public static final ProgressIndicatorKt$CircularProgressIndicator$endAngle$2 INSTANCE = new ProgressIndicatorKt$CircularProgressIndicator$endAngle$2();

    ProgressIndicatorKt$CircularProgressIndicator$endAngle$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) (KeyframesSpec.KeyframesSpecConfig) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> $this$keyframes) {
        Intrinsics.checkNotNullParameter($this$keyframes, "$this$keyframes");
        $this$keyframes.setDurationMillis(1332);
        $this$keyframes.with($this$keyframes.at(Float.valueOf(0.0f), 0), ProgressIndicatorKt.CircularEasing);
        $this$keyframes.at(Float.valueOf(290.0f), 666);
    }
}
