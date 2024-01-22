package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TextField.kt */
final class TextFieldKt$drawIndicatorLine$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ BorderStroke $indicatorBorder;
    final /* synthetic */ float $strokeWidthDp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldKt$drawIndicatorLine$1(float f, BorderStroke borderStroke) {
        super(1);
        this.$strokeWidthDp = f;
        this.$indicatorBorder = borderStroke;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((ContentDrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope $this$drawWithContent) {
        ContentDrawScope contentDrawScope = $this$drawWithContent;
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$drawWithContent");
        $this$drawWithContent.drawContent();
        if (!Dp.m5991equalsimpl0(this.$strokeWidthDp, Dp.Companion.m6004getHairlineD9Ej5fM())) {
            float strokeWidth = this.$strokeWidthDp * $this$drawWithContent.getDensity();
            float y = Size.m2981getHeightimpl($this$drawWithContent.m3772getSizeNHjbRc()) - (strokeWidth / ((float) 2));
            DrawScope.m3739drawLine1RTmtNc$default(contentDrawScope, this.$indicatorBorder.getBrush(), OffsetKt.Offset(0.0f, y), OffsetKt.Offset(Size.m2984getWidthimpl($this$drawWithContent.m3772getSizeNHjbRc()), y), strokeWidth, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
        }
    }
}
