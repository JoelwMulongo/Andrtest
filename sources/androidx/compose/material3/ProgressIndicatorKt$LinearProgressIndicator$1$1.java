package androidx.compose.material3;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$LinearProgressIndicator$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $color;
    final /* synthetic */ float $progress;
    final /* synthetic */ long $trackColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$LinearProgressIndicator$1$1(long j, float f, long j2) {
        super(1);
        this.$trackColor = j;
        this.$progress = f;
        this.$color = j2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        float strokeWidth = Size.m2981getHeightimpl($this$Canvas.m3772getSizeNHjbRc());
        ProgressIndicatorKt.m2048drawLinearIndicatorTrackbw27NRU($this$Canvas, this.$trackColor, strokeWidth);
        ProgressIndicatorKt.m2047drawLinearIndicator42QJj7c($this$Canvas, 0.0f, this.$progress, this.$color, strokeWidth);
    }
}
