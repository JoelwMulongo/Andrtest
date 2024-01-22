package androidx.compose.material3;

import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: RadioButton.kt */
final class RadioButtonKt$RadioButton$2$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Dp> $dotRadius;
    final /* synthetic */ State<Color> $radioColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RadioButtonKt$RadioButton$2$1(State<Color> state, State<Dp> state2) {
        super(1);
        this.$radioColor = state;
        this.$dotRadius = state2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope $this$Canvas) {
        DrawScope drawScope = $this$Canvas;
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        float strokeWidth = drawScope.m5967toPx0680j_4(RadioButtonKt.RadioStrokeWidth);
        long r10 = this.$radioColor.getValue().m3174unboximpl();
        float f = (float) 2;
        DrawScope.m3735drawCircleVaOC9Bg$default($this$Canvas, r10, drawScope.m5967toPx0680j_4(Dp.m5986constructorimpl(RadioButtonTokens.INSTANCE.m2653getIconSizeD9Ej5fM() / ((float) 2))) - (strokeWidth / f), 0, 0.0f, new Stroke(strokeWidth, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 108, (Object) null);
        if (Dp.m5985compareTo0680j_4(this.$dotRadius.getValue().m6000unboximpl(), Dp.m5986constructorimpl((float) 0)) > 0) {
            DrawScope.m3735drawCircleVaOC9Bg$default($this$Canvas, this.$radioColor.getValue().m3174unboximpl(), drawScope.m5967toPx0680j_4(this.$dotRadius.getValue().m6000unboximpl()) - (strokeWidth / f), 0, 0.0f, Fill.INSTANCE, (ColorFilter) null, 0, 108, (Object) null);
        }
    }
}
