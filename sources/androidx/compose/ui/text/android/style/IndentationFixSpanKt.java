package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import android.text.Layout;
import android.text.TextPaint;
import androidx.compose.ui.text.android.TextLayoutKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\u001e\u0010\t\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"EllipsisChar", "", "getEllipsizedLeftPadding", "", "Landroid/text/Layout;", "lineIndex", "", "paint", "Landroid/graphics/Paint;", "getEllipsizedRightPadding", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: IndentationFixSpan.kt */
public final class IndentationFixSpanKt {
    private static final String EllipsisChar = "…";

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: IndentationFixSpan.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            try {
                iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ float getEllipsizedLeftPadding$default(Layout layout, int i, Paint paint, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            TextPaint paint2 = layout.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint2, "this.paint");
            paint = paint2;
        }
        return getEllipsizedLeftPadding(layout, i, paint);
    }

    public static final float getEllipsizedLeftPadding(Layout $this$getEllipsizedLeftPadding, int lineIndex, Paint paint) {
        Intrinsics.checkNotNullParameter($this$getEllipsizedLeftPadding, "<this>");
        Intrinsics.checkNotNullParameter(paint, "paint");
        float lineLeft = $this$getEllipsizedLeftPadding.getLineLeft(lineIndex);
        if (!TextLayoutKt.isLineEllipsized($this$getEllipsizedLeftPadding, lineIndex) || $this$getEllipsizedLeftPadding.getParagraphDirection(lineIndex) != 1 || lineLeft >= 0.0f) {
            return 0.0f;
        }
        float length = ($this$getEllipsizedLeftPadding.getPrimaryHorizontal($this$getEllipsizedLeftPadding.getLineStart(lineIndex) + $this$getEllipsizedLeftPadding.getEllipsisStart(lineIndex)) - lineLeft) + paint.measureText(EllipsisChar);
        Layout.Alignment paragraphAlignment = $this$getEllipsizedLeftPadding.getParagraphAlignment(lineIndex);
        if ((paragraphAlignment == null ? -1 : WhenMappings.$EnumSwitchMapping$0[paragraphAlignment.ordinal()]) == 1) {
            return Math.abs(lineLeft) + ((((float) $this$getEllipsizedLeftPadding.getWidth()) - length) / 2.0f);
        }
        return Math.abs(lineLeft) + (((float) $this$getEllipsizedLeftPadding.getWidth()) - length);
    }

    public static /* synthetic */ float getEllipsizedRightPadding$default(Layout layout, int i, Paint paint, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            TextPaint paint2 = layout.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint2, "this.paint");
            paint = paint2;
        }
        return getEllipsizedRightPadding(layout, i, paint);
    }

    public static final float getEllipsizedRightPadding(Layout $this$getEllipsizedRightPadding, int lineIndex, Paint paint) {
        Intrinsics.checkNotNullParameter($this$getEllipsizedRightPadding, "<this>");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (!TextLayoutKt.isLineEllipsized($this$getEllipsizedRightPadding, lineIndex)) {
            return 0.0f;
        }
        int i = -1;
        if ($this$getEllipsizedRightPadding.getParagraphDirection(lineIndex) != -1 || ((float) $this$getEllipsizedRightPadding.getWidth()) >= $this$getEllipsizedRightPadding.getLineRight(lineIndex)) {
            return 0.0f;
        }
        float length = ($this$getEllipsizedRightPadding.getLineRight(lineIndex) - $this$getEllipsizedRightPadding.getPrimaryHorizontal($this$getEllipsizedRightPadding.getLineStart(lineIndex) + $this$getEllipsizedRightPadding.getEllipsisStart(lineIndex))) + paint.measureText(EllipsisChar);
        Layout.Alignment paragraphAlignment = $this$getEllipsizedRightPadding.getParagraphAlignment(lineIndex);
        if (paragraphAlignment != null) {
            i = WhenMappings.$EnumSwitchMapping$0[paragraphAlignment.ordinal()];
        }
        if (i == 1) {
            return (((float) $this$getEllipsizedRightPadding.getWidth()) - $this$getEllipsizedRightPadding.getLineRight(lineIndex)) - ((((float) $this$getEllipsizedRightPadding.getWidth()) - length) / 2.0f);
        }
        return (((float) $this$getEllipsizedRightPadding.getWidth()) - $this$getEllipsizedRightPadding.getLineRight(lineIndex)) - (((float) $this$getEllipsizedRightPadding.getWidth()) - length);
    }
}
