package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Checkbox.kt */
final class CheckboxKt$CheckboxImpl$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Color> $borderColor;
    final /* synthetic */ State<Color> $boxColor;
    final /* synthetic */ CheckDrawingCache $checkCache;
    final /* synthetic */ State<Float> $checkCenterGravitationShiftFraction;
    final /* synthetic */ State<Color> $checkColor;
    final /* synthetic */ State<Float> $checkDrawFraction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckboxKt$CheckboxImpl$1$1(State<Color> state, State<Color> state2, State<Color> state3, State<Float> state4, State<Float> state5, CheckDrawingCache checkDrawingCache) {
        super(1);
        this.$boxColor = state;
        this.$borderColor = state2;
        this.$checkColor = state3;
        this.$checkDrawFraction = state4;
        this.$checkCenterGravitationShiftFraction = state5;
        this.$checkCache = checkDrawingCache;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        float strokeWidthPx = (float) Math.floor((double) $this$Canvas.m5967toPx0680j_4(CheckboxKt.StrokeWidth));
        DrawScope drawScope = $this$Canvas;
        CheckboxKt.m1783drawBox1wkBAMs(drawScope, this.$boxColor.getValue().m3174unboximpl(), this.$borderColor.getValue().m3174unboximpl(), $this$Canvas.m5967toPx0680j_4(CheckboxKt.RadiusSize), strokeWidthPx);
        CheckboxKt.m1784drawCheck3IgeMak(drawScope, this.$checkColor.getValue().m3174unboximpl(), this.$checkDrawFraction.getValue().floatValue(), this.$checkCenterGravitationShiftFraction.getValue().floatValue(), strokeWidthPx, this.$checkCache);
    }
}
