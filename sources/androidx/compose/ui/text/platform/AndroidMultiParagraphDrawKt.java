package androidx.compose.ui.text.platform;

import android.graphics.Matrix;
import android.graphics.Shader;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aa\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001aW\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"drawMultiParagraph", "", "Landroidx/compose/ui/text/MultiParagraph;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "decoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawMultiParagraph-7AXcY_I", "(Landroidx/compose/ui/text/MultiParagraph;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "drawParagraphs", "drawParagraphs-7AXcY_I", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidMultiParagraphDraw.kt */
public final class AndroidMultiParagraphDrawKt {
    /* renamed from: drawMultiParagraph-7AXcY_I$default  reason: not valid java name */
    public static /* synthetic */ void m5704drawMultiParagraph7AXcY_I$default(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i, int i2, Object obj) {
        Shadow shadow2;
        TextDecoration textDecoration2;
        DrawStyle drawStyle2;
        int i3;
        float f2 = (i2 & 4) != 0 ? Float.NaN : f;
        if ((i2 & 8) != 0) {
            shadow2 = null;
        } else {
            shadow2 = shadow;
        }
        if ((i2 & 16) != 0) {
            textDecoration2 = null;
        } else {
            textDecoration2 = textDecoration;
        }
        if ((i2 & 32) != 0) {
            drawStyle2 = null;
        } else {
            drawStyle2 = drawStyle;
        }
        if ((i2 & 64) != 0) {
            i3 = BlendMode.Companion.m3097getSrcOver0nO6VwU();
        } else {
            i3 = i;
        }
        m5703drawMultiParagraph7AXcY_I(multiParagraph, canvas, brush, f2, shadow2, textDecoration2, drawStyle2, i3);
    }

    /* renamed from: drawMultiParagraph-7AXcY_I  reason: not valid java name */
    public static final void m5703drawMultiParagraph7AXcY_I(MultiParagraph $this$drawMultiParagraph_u2d7AXcY_I, Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        Canvas canvas2 = canvas;
        Brush brush2 = brush;
        Intrinsics.checkNotNullParameter($this$drawMultiParagraph_u2d7AXcY_I, "$this$drawMultiParagraph");
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        Intrinsics.checkNotNullParameter(brush2, "brush");
        canvas.save();
        if ($this$drawMultiParagraph_u2d7AXcY_I.getParagraphInfoList$ui_text_release().size() <= 1) {
            m5705drawParagraphs7AXcY_I($this$drawMultiParagraph_u2d7AXcY_I, canvas, brush, alpha, shadow, decoration, drawStyle, blendMode);
        } else if (brush2 instanceof SolidColor) {
            m5705drawParagraphs7AXcY_I($this$drawMultiParagraph_u2d7AXcY_I, canvas, brush, alpha, shadow, decoration, drawStyle, blendMode);
        } else if (brush2 instanceof ShaderBrush) {
            List $this$fastForEach$iv = $this$drawMultiParagraph_u2d7AXcY_I.getParagraphInfoList$ui_text_release();
            int size = $this$fastForEach$iv.size();
            float height = 0.0f;
            float width = 0.0f;
            for (int index$iv = 0; index$iv < size; index$iv++) {
                ParagraphInfo it = $this$fastForEach$iv.get(index$iv);
                height += it.getParagraph().getHeight();
                width = Math.max(width, it.getParagraph().getWidth());
            }
            Shader shader = ((ShaderBrush) brush2).m3503createShaderuvyYCjk(SizeKt.Size(width, height));
            Matrix matrix = new Matrix();
            shader.getLocalMatrix(matrix);
            List $this$fastForEach$iv2 = $this$drawMultiParagraph_u2d7AXcY_I.getParagraphInfoList$ui_text_release();
            int index$iv2 = 0;
            for (int size2 = $this$fastForEach$iv2.size(); index$iv2 < size2; size2 = size2) {
                ParagraphInfo it2 = $this$fastForEach$iv2.get(index$iv2);
                it2.getParagraph().m5371painthn5TExg(canvas, BrushKt.ShaderBrush(shader), alpha, shadow, decoration, drawStyle, blendMode);
                canvas2.translate(0.0f, it2.getParagraph().getHeight());
                matrix.setTranslate(0.0f, -it2.getParagraph().getHeight());
                shader.setLocalMatrix(matrix);
                index$iv2++;
            }
            int i = index$iv2;
        }
        canvas.restore();
    }

    /* renamed from: drawParagraphs-7AXcY_I  reason: not valid java name */
    private static final void m5705drawParagraphs7AXcY_I(MultiParagraph $this$drawParagraphs_u2d7AXcY_I, Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        List $this$fastForEach$iv = $this$drawParagraphs_u2d7AXcY_I.getParagraphInfoList$ui_text_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            ParagraphInfo it = $this$fastForEach$iv.get(index$iv);
            it.getParagraph().m5371painthn5TExg(canvas, brush, alpha, shadow, decoration, drawStyle, blendMode);
            canvas.translate(0.0f, it.getParagraph().getHeight());
        }
        Canvas canvas2 = canvas;
    }
}
