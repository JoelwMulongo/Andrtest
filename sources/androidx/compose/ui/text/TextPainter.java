package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/text/TextPainter;", "", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextPainter.kt */
public final class TextPainter {
    public static final int $stable = 0;
    public static final TextPainter INSTANCE = new TextPainter();

    private TextPainter() {
    }

    public final void paint(Canvas canvas, TextLayoutResult textLayoutResult) {
        long color;
        float alpha;
        Canvas canvas2 = canvas;
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        boolean needClipping = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m5891equalsimpl0(textLayoutResult.getLayoutInput().m5443getOverflowgIe3tQ8(), TextOverflow.Companion.m5900getVisiblegIe3tQ8());
        if (needClipping) {
            Rect bounds = RectKt.m2955Recttz77jQw(Offset.Companion.m2931getZeroF1C5BW0(), SizeKt.Size((float) IntSize.m6146getWidthimpl(textLayoutResult.m5447getSizeYbymL2g()), (float) IntSize.m6145getHeightimpl(textLayoutResult.m5447getSizeYbymL2g())));
            canvas.save();
            Canvas.m3127clipRectmtrdDE$default(canvas2, bounds, 0, 2, (Object) null);
        }
        SpanStyle style = textLayoutResult.getLayoutInput().getStyle().getSpanStyle$ui_text_release();
        TextDecoration textDecoration = style.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = style.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        Shadow shadow2 = shadow;
        DrawStyle drawStyle = style.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        try {
            Brush brush = style.getBrush();
            if (brush != null) {
                if (style.getTextForegroundStyle$ui_text_release() != TextForegroundStyle.Unspecified.INSTANCE) {
                    alpha = style.getTextForegroundStyle$ui_text_release().getAlpha();
                } else {
                    alpha = 1.0f;
                }
                MultiParagraph.m5358painthn5TExg$default(textLayoutResult.getMultiParagraph(), canvas, brush, alpha, shadow2, textDecoration2, drawStyle2, 0, 64, (Object) null);
            } else {
                if (style.getTextForegroundStyle$ui_text_release() != TextForegroundStyle.Unspecified.INSTANCE) {
                    color = style.getTextForegroundStyle$ui_text_release().m5868getColor0d7_KjU();
                } else {
                    color = Color.Companion.m3190getBlack0d7_KjU();
                }
                MultiParagraph.m5356paintLG529CI$default(textLayoutResult.getMultiParagraph(), canvas, color, shadow2, textDecoration2, drawStyle2, 0, 32, (Object) null);
            }
        } finally {
            if (needClipping) {
                canvas.restore();
            }
        }
    }
}
