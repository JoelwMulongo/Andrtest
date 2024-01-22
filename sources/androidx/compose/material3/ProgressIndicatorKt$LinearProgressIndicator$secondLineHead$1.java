package androidx.compose.material3;

import androidx.compose.animation.core.KeyframesSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1 extends Lambda implements Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit> {
    public static final ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1 INSTANCE = new ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1();

    ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) (KeyframesSpec.KeyframesSpecConfig) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> $this$keyframes) {
        Intrinsics.checkNotNullParameter($this$keyframes, "$this$keyframes");
        $this$keyframes.setDurationMillis(1800);
        $this$keyframes.with($this$keyframes.at(Float.valueOf(0.0f), 1000), ProgressIndicatorKt.SecondLineHeadEasing);
        $this$keyframes.at(Float.valueOf(1.0f), 1567);
    }
}
