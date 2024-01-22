package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProgressIndicator.kt */
final class ProgressIndicatorKt$CircularProgressIndicator$3 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ State<Float> $baseRotation$delegate;
    final /* synthetic */ long $color;
    final /* synthetic */ State<Integer> $currentRotation$delegate;
    final /* synthetic */ State<Float> $endAngle$delegate;
    final /* synthetic */ State<Float> $startAngle$delegate;
    final /* synthetic */ Stroke $stroke;
    final /* synthetic */ float $strokeWidth;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressIndicatorKt$CircularProgressIndicator$3(long j, Stroke stroke, float f, long j2, State<Integer> state, State<Float> state2, State<Float> state3, State<Float> state4) {
        super(1);
        this.$backgroundColor = j;
        this.$stroke = stroke;
        this.$strokeWidth = f;
        this.$color = j2;
        this.$currentRotation$delegate = state;
        this.$endAngle$delegate = state2;
        this.$startAngle$delegate = state3;
        this.$baseRotation$delegate = state4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        ProgressIndicatorKt.m1583drawCircularIndicatorBackgroundbw27NRU($this$Canvas, this.$backgroundColor, this.$stroke);
        float sweep = Math.abs(ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$10(this.$endAngle$delegate) - ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$11(this.$startAngle$delegate));
        DrawScope drawScope = $this$Canvas;
        float f = sweep;
        ProgressIndicatorKt.m1585drawIndeterminateCircularIndicatorhrjfTZI(drawScope, ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$11(this.$startAngle$delegate) + -90.0f + ((((float) ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$8(this.$currentRotation$delegate)) * 216.0f) % 360.0f) + ProgressIndicatorKt.CircularProgressIndicator_LxG7B9w$lambda$9(this.$baseRotation$delegate), this.$strokeWidth, f, this.$color, this.$stroke);
    }
}
