package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001ak\u0010\n\u001a\u00020\u0006*\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0001H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001am\u0010\n\u001a\u00020\u0006*\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0001H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0001\u0010\n\u001a\u00020\u0006*\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\u0014\b\u0002\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-0,2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0018\u001a\u00020\u0001H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001ao\u0010\n\u001a\u00020\u0006*\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u0002032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0018\u001a\u00020\u0001H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a)\u00106\u001a\u000207*\u00020\u000b2\u0006\u0010/\u001a\u0002002\u0006\u0010\u000e\u001a\u00020\u000fH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"DefaultTextBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getDefaultTextBlendMode", "()I", "I", "clip", "", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawText", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "brush", "Landroidx/compose/ui/graphics/Brush;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "drawText-LVfH_YU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Brush;JFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawText-d8-rzKo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;JJFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "size", "Landroidx/compose/ui/geometry/Size;", "drawText-JFhB2K4", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextStyle;IZILjava/util/List;JI)V", "", "drawText-TPWCCtM", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;IZIJI)V", "textLayoutConstraints", "Landroidx/compose/ui/unit/Constraints;", "textLayoutConstraints-v_w8tDc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJ)J", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextPainter.kt */
public final class TextPainterKt {
    private static final int DefaultTextBlendMode = BlendMode.Companion.m3097getSrcOver0nO6VwU();

    public static final int getDefaultTextBlendMode() {
        return DefaultTextBlendMode;
    }

    /* renamed from: drawText-JFhB2K4$default  reason: not valid java name */
    public static /* synthetic */ void m5454drawTextJFhB2K4$default(DrawScope drawScope, TextMeasurer textMeasurer, AnnotatedString annotatedString, long j, TextStyle textStyle, int i, boolean z, int i2, List list, long j2, int i3, int i4, Object obj) {
        long j3;
        TextStyle textStyle2;
        List list2;
        int i5 = i4;
        if ((i5 & 4) != 0) {
            j3 = Offset.Companion.m2931getZeroF1C5BW0();
        } else {
            j3 = j;
        }
        if ((i5 & 8) != 0) {
            textStyle2 = TextStyle.Companion.getDefault();
        } else {
            textStyle2 = textStyle;
        }
        int r9 = (i5 & 16) != 0 ? TextOverflow.Companion.m5898getClipgIe3tQ8() : i;
        boolean z2 = (i5 & 32) != 0 ? true : z;
        int i6 = (i5 & 64) != 0 ? Integer.MAX_VALUE : i2;
        if ((i5 & 128) != 0) {
            list2 = CollectionsKt.emptyList();
        } else {
            list2 = list;
        }
        m5453drawTextJFhB2K4(drawScope, textMeasurer, annotatedString, j3, textStyle2, r9, z2, i6, list2, (i5 & 256) != 0 ? Size.Companion.m2992getUnspecifiedNHjbRc() : j2, (i5 & 512) != 0 ? DrawScope.Companion.m3773getDefaultBlendMode0nO6VwU() : i3);
    }

    /* renamed from: drawText-JFhB2K4  reason: not valid java name */
    public static final void m5453drawTextJFhB2K4(DrawScope $this$drawText_u2dJFhB2K4, TextMeasurer textMeasurer, AnnotatedString text, long topLeft, TextStyle style, int overflow, boolean softWrap, int maxLines, List<AnnotatedString.Range<Placeholder>> placeholders, long size, int blendMode) {
        DrawScope drawScope = $this$drawText_u2dJFhB2K4;
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawText");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        long r16 = m5461textLayoutConstraintsv_w8tDc(drawScope, size, topLeft);
        TextLayoutResult textLayoutResult = TextMeasurer.m5450measurexDpz5zY$default(textMeasurer, text, style, overflow, softWrap, maxLines, placeholders, r16, $this$drawText_u2dJFhB2K4.getLayoutDirection(), drawScope, (FontFamily.Resolver) null, false, 1536, (Object) null);
        DrawScope $this$withTransform$iv = $this$drawText_u2dJFhB2K4;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$drawText_JFhB2K4_u24lambda_u240 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$drawText_JFhB2K4_u24lambda_u240.translate(Offset.m2915getXimpl(topLeft), Offset.m2916getYimpl(topLeft));
        clip($this$drawText_JFhB2K4_u24lambda_u240, textLayoutResult);
        MultiParagraph.m5356paintLG529CI$default(textLayoutResult.getMultiParagraph(), $this$withTransform$iv.getDrawContext().getCanvas(), 0, (Shadow) null, (TextDecoration) null, (DrawStyle) null, blendMode, 30, (Object) null);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: drawText-TPWCCtM$default  reason: not valid java name */
    public static /* synthetic */ void m5458drawTextTPWCCtM$default(DrawScope drawScope, TextMeasurer textMeasurer, String str, long j, TextStyle textStyle, int i, boolean z, int i2, long j2, int i3, int i4, Object obj) {
        long j3;
        TextStyle textStyle2;
        int i5 = i4;
        if ((i5 & 4) != 0) {
            j3 = Offset.Companion.m2931getZeroF1C5BW0();
        } else {
            j3 = j;
        }
        if ((i5 & 8) != 0) {
            textStyle2 = TextStyle.Companion.getDefault();
        } else {
            textStyle2 = textStyle;
        }
        m5457drawTextTPWCCtM(drawScope, textMeasurer, str, j3, textStyle2, (i5 & 16) != 0 ? TextOverflow.Companion.m5898getClipgIe3tQ8() : i, (i5 & 32) != 0 ? true : z, (i5 & 64) != 0 ? Integer.MAX_VALUE : i2, (i5 & 128) != 0 ? Size.Companion.m2992getUnspecifiedNHjbRc() : j2, (i5 & 256) != 0 ? DrawScope.Companion.m3773getDefaultBlendMode0nO6VwU() : i3);
    }

    /* renamed from: drawText-TPWCCtM  reason: not valid java name */
    public static final void m5457drawTextTPWCCtM(DrawScope $this$drawText_u2dTPWCCtM, TextMeasurer textMeasurer, String text, long topLeft, TextStyle style, int overflow, boolean softWrap, int maxLines, long size, int blendMode) {
        DrawScope drawScope = $this$drawText_u2dTPWCCtM;
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawText");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        TextLayoutResult textLayoutResult = TextMeasurer.m5450measurexDpz5zY$default(textMeasurer, new AnnotatedString(text, (List) null, (List) null, 6, (DefaultConstructorMarker) null), style, overflow, softWrap, maxLines, (List) null, m5461textLayoutConstraintsv_w8tDc(drawScope, size, topLeft), $this$drawText_u2dTPWCCtM.getLayoutDirection(), drawScope, (FontFamily.Resolver) null, false, 1568, (Object) null);
        DrawScope $this$withTransform$iv = $this$drawText_u2dTPWCCtM;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$drawText_TPWCCtM_u24lambda_u242 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$drawText_TPWCCtM_u24lambda_u242.translate(Offset.m2915getXimpl(topLeft), Offset.m2916getYimpl(topLeft));
        clip($this$drawText_TPWCCtM_u24lambda_u242, textLayoutResult);
        MultiParagraph.m5356paintLG529CI$default(textLayoutResult.getMultiParagraph(), $this$withTransform$iv.getDrawContext().getCanvas(), 0, (Shadow) null, (TextDecoration) null, (DrawStyle) null, blendMode, 30, (Object) null);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: drawText-d8-rzKo$default  reason: not valid java name */
    public static /* synthetic */ void m5460drawTextd8rzKo$default(DrawScope drawScope, TextLayoutResult textLayoutResult, long j, long j2, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i, int i2, Object obj) {
        long j3;
        long j4;
        float f2;
        Shadow shadow2;
        TextDecoration textDecoration2;
        int i3 = i2;
        if ((i3 & 2) != 0) {
            j3 = Color.Companion.m3200getUnspecified0d7_KjU();
        } else {
            j3 = j;
        }
        if ((i3 & 4) != 0) {
            j4 = Offset.Companion.m2931getZeroF1C5BW0();
        } else {
            j4 = j2;
        }
        if ((i3 & 8) != 0) {
            f2 = Float.NaN;
        } else {
            f2 = f;
        }
        DrawStyle drawStyle2 = null;
        if ((i3 & 16) != 0) {
            shadow2 = null;
        } else {
            shadow2 = shadow;
        }
        if ((i3 & 32) != 0) {
            textDecoration2 = null;
        } else {
            textDecoration2 = textDecoration;
        }
        if ((i3 & 64) == 0) {
            drawStyle2 = drawStyle;
        }
        m5459drawTextd8rzKo(drawScope, textLayoutResult, j3, j4, f2, shadow2, textDecoration2, drawStyle2, (i3 & 128) != 0 ? DrawScope.Companion.m3773getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawText-d8-rzKo  reason: not valid java name */
    public static final void m5459drawTextd8rzKo(DrawScope $this$drawText_u2dd8_u2drzKo, TextLayoutResult textLayoutResult, long color, long topLeft, float alpha, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        TextLayoutResult textLayoutResult2 = textLayoutResult;
        Intrinsics.checkNotNullParameter($this$drawText_u2dd8_u2drzKo, "$this$drawText");
        Intrinsics.checkNotNullParameter(textLayoutResult2, "textLayoutResult");
        Shadow newShadow = shadow == null ? textLayoutResult.getLayoutInput().getStyle().getShadow() : shadow;
        TextDecoration newTextDecoration = textDecoration == null ? textLayoutResult.getLayoutInput().getStyle().getTextDecoration() : textDecoration;
        DrawStyle newDrawStyle = drawStyle == null ? textLayoutResult.getLayoutInput().getStyle().getDrawStyle() : drawStyle;
        DrawScope $this$withTransform$iv = $this$drawText_u2dd8_u2drzKo;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$drawText_d8_rzKo_u24lambda_u244 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$drawText_d8_rzKo_u24lambda_u244.translate(Offset.m2915getXimpl(topLeft), Offset.m2916getYimpl(topLeft));
        clip($this$drawText_d8_rzKo_u24lambda_u244, textLayoutResult2);
        DrawScope $this$drawText_d8_rzKo_u24lambda_u246 = $this$withTransform$iv;
        Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
        boolean z = true;
        if (brush != null) {
            if (color == Color.Companion.m3200getUnspecified0d7_KjU()) {
                textLayoutResult.getMultiParagraph().m5363painthn5TExg($this$drawText_d8_rzKo_u24lambda_u246.getDrawContext().getCanvas(), brush, !Float.isNaN(alpha) ? alpha : textLayoutResult.getLayoutInput().getStyle().getAlpha(), newShadow, newTextDecoration, newDrawStyle, blendMode);
                float f = alpha;
                $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
            }
        }
        MultiParagraph multiParagraph = textLayoutResult.getMultiParagraph();
        Canvas canvas = $this$drawText_d8_rzKo_u24lambda_u246.getDrawContext().getCanvas();
        long $this$takeOrElse_u2dDxMtmZc$iv = color;
        if ($this$takeOrElse_u2dDxMtmZc$iv == Color.Companion.m3200getUnspecified0d7_KjU()) {
            z = false;
        }
        if (!z) {
            $this$takeOrElse_u2dDxMtmZc$iv = textLayoutResult.getLayoutInput().getStyle().m5494getColor0d7_KjU();
        }
        multiParagraph.m5361paintLG529CI(canvas, TextDrawStyleKt.m5867modulateDxMtmZc($this$takeOrElse_u2dDxMtmZc$iv, alpha), newShadow, newTextDecoration, newDrawStyle, blendMode);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
    }

    /* renamed from: drawText-LVfH_YU$default  reason: not valid java name */
    public static /* synthetic */ void m5456drawTextLVfH_YU$default(DrawScope drawScope, TextLayoutResult textLayoutResult, Brush brush, long j, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i, int i2, Object obj) {
        long j2;
        float f2;
        Shadow shadow2;
        TextDecoration textDecoration2;
        DrawStyle drawStyle2;
        int i3 = i2;
        if ((i3 & 4) != 0) {
            j2 = Offset.Companion.m2931getZeroF1C5BW0();
        } else {
            j2 = j;
        }
        if ((i3 & 8) != 0) {
            f2 = Float.NaN;
        } else {
            f2 = f;
        }
        if ((i3 & 16) != 0) {
            shadow2 = null;
        } else {
            shadow2 = shadow;
        }
        if ((i3 & 32) != 0) {
            textDecoration2 = null;
        } else {
            textDecoration2 = textDecoration;
        }
        if ((i3 & 64) != 0) {
            drawStyle2 = null;
        } else {
            drawStyle2 = drawStyle;
        }
        m5455drawTextLVfH_YU(drawScope, textLayoutResult, brush, j2, f2, shadow2, textDecoration2, drawStyle2, (i3 & 128) != 0 ? DrawScope.Companion.m3773getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawText-LVfH_YU  reason: not valid java name */
    public static final void m5455drawTextLVfH_YU(DrawScope $this$drawText_u2dLVfH_YU, TextLayoutResult textLayoutResult, Brush brush, long topLeft, float alpha, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        TextLayoutResult textLayoutResult2 = textLayoutResult;
        Intrinsics.checkNotNullParameter($this$drawText_u2dLVfH_YU, "$this$drawText");
        Intrinsics.checkNotNullParameter(textLayoutResult2, "textLayoutResult");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Shadow newShadow = shadow == null ? textLayoutResult.getLayoutInput().getStyle().getShadow() : shadow;
        TextDecoration newTextDecoration = textDecoration == null ? textLayoutResult.getLayoutInput().getStyle().getTextDecoration() : textDecoration;
        DrawStyle newDrawStyle = drawStyle == null ? textLayoutResult.getLayoutInput().getStyle().getDrawStyle() : drawStyle;
        DrawScope $this$withTransform$iv = $this$drawText_u2dLVfH_YU;
        DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
        long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv.getCanvas().save();
        DrawTransform $this$drawText_LVfH_YU_u24lambda_u247 = $this$withTransform_u24lambda_u246$iv.getTransform();
        $this$drawText_LVfH_YU_u24lambda_u247.translate(Offset.m2915getXimpl(topLeft), Offset.m2916getYimpl(topLeft));
        clip($this$drawText_LVfH_YU_u24lambda_u247, textLayoutResult2);
        DrawScope drawScope = $this$withTransform$iv;
        textLayoutResult.getMultiParagraph().m5363painthn5TExg($this$withTransform$iv.getDrawContext().getCanvas(), brush, !Float.isNaN(alpha) ? alpha : textLayoutResult.getLayoutInput().getStyle().getAlpha(), newShadow, newTextDecoration, newDrawStyle, blendMode);
        $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
    }

    private static final void clip(DrawTransform $this$clip, TextLayoutResult textLayoutResult) {
        if (textLayoutResult.getHasVisualOverflow() && !TextOverflow.m5891equalsimpl0(textLayoutResult.getLayoutInput().m5443getOverflowgIe3tQ8(), TextOverflow.Companion.m5900getVisiblegIe3tQ8())) {
            DrawTransform.m3823clipRectN_I0leg$default($this$clip, 0.0f, 0.0f, (float) IntSize.m6146getWidthimpl(textLayoutResult.m5447getSizeYbymL2g()), (float) IntSize.m6145getHeightimpl(textLayoutResult.m5447getSizeYbymL2g()), 0, 16, (Object) null);
        }
    }

    /* renamed from: textLayoutConstraints-v_w8tDc  reason: not valid java name */
    private static final long m5461textLayoutConstraintsv_w8tDc(DrawScope $this$textLayoutConstraints_u2dv_w8tDc, long size, long topLeft) {
        int maxWidth;
        int minWidth;
        int maxHeight;
        int minHeight;
        boolean isHeightNaN = true;
        if (((size > Size.Companion.m2992getUnspecifiedNHjbRc() ? 1 : (size == Size.Companion.m2992getUnspecifiedNHjbRc() ? 0 : -1)) == 0) || Float.isNaN(Size.m2984getWidthimpl(size))) {
            minWidth = 0;
            maxWidth = MathKt.roundToInt((float) Math.ceil((double) (Size.m2984getWidthimpl($this$textLayoutConstraints_u2dv_w8tDc.m3772getSizeNHjbRc()) - Offset.m2915getXimpl(topLeft))));
        } else {
            int fixedWidth = MathKt.roundToInt((float) Math.ceil((double) Size.m2984getWidthimpl(size)));
            minWidth = fixedWidth;
            maxWidth = fixedWidth;
        }
        if ((size == Size.Companion.m2992getUnspecifiedNHjbRc() ? 1 : 0) == 0 && !Float.isNaN(Size.m2981getHeightimpl(size))) {
            isHeightNaN = false;
        }
        if (isHeightNaN) {
            minHeight = 0;
            maxHeight = MathKt.roundToInt((float) Math.ceil((double) (Size.m2981getHeightimpl($this$textLayoutConstraints_u2dv_w8tDc.m3772getSizeNHjbRc()) - Offset.m2916getYimpl(topLeft))));
        } else {
            int fixedHeight = MathKt.roundToInt((float) Math.ceil((double) Size.m2981getHeightimpl(size)));
            minHeight = fixedHeight;
            maxHeight = fixedHeight;
        }
        return ConstraintsKt.Constraints(minWidth, maxWidth, minHeight, maxHeight);
    }
}
