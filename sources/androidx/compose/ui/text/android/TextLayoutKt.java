package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a=\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0002\u0010\u0011\u001a+\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0002\u0010\u0013\u001a\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\nH\u0002¢\u0006\u0002\u0010\u0015\u001a\u0018\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\nH\u0002\u001a\u0014\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"EmptyPair", "Lkotlin/Pair;", "", "SharedTextAndroidCanvas", "Landroidx/compose/ui/text/android/TextAndroidCanvas;", "getTextDirectionHeuristic", "Landroid/text/TextDirectionHeuristic;", "textDirectionHeuristic", "getLastLineMetrics", "Landroid/graphics/Paint$FontMetricsInt;", "Landroidx/compose/ui/text/android/TextLayout;", "textPaint", "Landroid/text/TextPaint;", "frameworkTextDir", "lineHeightSpans", "", "Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "(Landroidx/compose/ui/text/android/TextLayout;Landroid/text/TextPaint;Landroid/text/TextDirectionHeuristic;[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;)Lkotlin/Pair;", "getLineHeightPaddings", "(Landroidx/compose/ui/text/android/TextLayout;[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;)Lkotlin/Pair;", "getLineHeightSpans", "(Landroidx/compose/ui/text/android/TextLayout;)[Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "getVerticalPaddings", "isLineEllipsized", "", "Landroid/text/Layout;", "lineIndex", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLayout.kt */
public final class TextLayoutKt {
    private static final Pair<Integer, Integer> EmptyPair = new Pair<>(0, 0);
    /* access modifiers changed from: private */
    public static final TextAndroidCanvas SharedTextAndroidCanvas = new TextAndroidCanvas();

    public static final TextDirectionHeuristic getTextDirectionHeuristic(int textDirectionHeuristic) {
        switch (textDirectionHeuristic) {
            case 0:
                TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.LTR;
                Intrinsics.checkNotNullExpressionValue(textDirectionHeuristic2, "LTR");
                return textDirectionHeuristic2;
            case 1:
                TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.RTL;
                Intrinsics.checkNotNullExpressionValue(textDirectionHeuristic3, "RTL");
                return textDirectionHeuristic3;
            case 2:
                TextDirectionHeuristic textDirectionHeuristic4 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                Intrinsics.checkNotNullExpressionValue(textDirectionHeuristic4, "FIRSTSTRONG_LTR");
                return textDirectionHeuristic4;
            case 3:
                TextDirectionHeuristic textDirectionHeuristic5 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                Intrinsics.checkNotNullExpressionValue(textDirectionHeuristic5, "FIRSTSTRONG_RTL");
                return textDirectionHeuristic5;
            case 4:
                TextDirectionHeuristic textDirectionHeuristic6 = TextDirectionHeuristics.ANYRTL_LTR;
                Intrinsics.checkNotNullExpressionValue(textDirectionHeuristic6, "ANYRTL_LTR");
                return textDirectionHeuristic6;
            case 5:
                TextDirectionHeuristic textDirectionHeuristic7 = TextDirectionHeuristics.LOCALE;
                Intrinsics.checkNotNullExpressionValue(textDirectionHeuristic7, "LOCALE");
                return textDirectionHeuristic7;
            default:
                TextDirectionHeuristic textDirectionHeuristic8 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                Intrinsics.checkNotNullExpressionValue(textDirectionHeuristic8, "FIRSTSTRONG_LTR");
                return textDirectionHeuristic8;
        }
    }

    /* access modifiers changed from: private */
    public static final Pair<Integer, Integer> getVerticalPaddings(TextLayout $this$getVerticalPaddings) {
        int topPadding;
        Rect rect;
        int bottomPadding;
        if ($this$getVerticalPaddings.getIncludePadding() || $this$getVerticalPaddings.isFallbackLinespacingApplied$ui_text_release()) {
            return new Pair<>(0, 0);
        }
        TextPaint paint = $this$getVerticalPaddings.getLayout().getPaint();
        CharSequence text = $this$getVerticalPaddings.getLayout().getText();
        Intrinsics.checkNotNullExpressionValue(paint, "paint");
        Intrinsics.checkNotNullExpressionValue(text, "text");
        Rect firstLineTextBounds = PaintExtensionsKt.getCharSequenceBounds(paint, text, $this$getVerticalPaddings.getLayout().getLineStart(0), $this$getVerticalPaddings.getLayout().getLineEnd(0));
        int ascent = $this$getVerticalPaddings.getLayout().getLineAscent(0);
        if (firstLineTextBounds.top < ascent) {
            topPadding = ascent - firstLineTextBounds.top;
        } else {
            topPadding = $this$getVerticalPaddings.getLayout().getTopPadding();
        }
        if ($this$getVerticalPaddings.getLineCount() == 1) {
            rect = firstLineTextBounds;
        } else {
            int line = $this$getVerticalPaddings.getLineCount() - 1;
            rect = PaintExtensionsKt.getCharSequenceBounds(paint, text, $this$getVerticalPaddings.getLayout().getLineStart(line), $this$getVerticalPaddings.getLayout().getLineEnd(line));
        }
        Rect lastLineTextBounds = rect;
        int descent = $this$getVerticalPaddings.getLayout().getLineDescent($this$getVerticalPaddings.getLineCount() - 1);
        if (lastLineTextBounds.bottom > descent) {
            bottomPadding = lastLineTextBounds.bottom - descent;
        } else {
            bottomPadding = $this$getVerticalPaddings.getLayout().getBottomPadding();
        }
        if (topPadding == 0 && bottomPadding == 0) {
            return EmptyPair;
        }
        return new Pair<>(Integer.valueOf(topPadding), Integer.valueOf(bottomPadding));
    }

    /* access modifiers changed from: private */
    public static final Pair<Integer, Integer> getLineHeightPaddings(TextLayout $this$getLineHeightPaddings, LineHeightStyleSpan[] lineHeightSpans) {
        int firstAscentDiff = 0;
        int lastDescentDiff = 0;
        for (LineHeightStyleSpan span : lineHeightSpans) {
            if (span.getFirstAscentDiff() < 0) {
                firstAscentDiff = Math.max(firstAscentDiff, Math.abs(span.getFirstAscentDiff()));
            }
            if (span.getLastDescentDiff() < 0) {
                lastDescentDiff = Math.max(firstAscentDiff, Math.abs(span.getLastDescentDiff()));
            }
        }
        if (firstAscentDiff == 0 && lastDescentDiff == 0) {
            return EmptyPair;
        }
        return new Pair<>(Integer.valueOf(firstAscentDiff), Integer.valueOf(lastDescentDiff));
    }

    /* access modifiers changed from: private */
    public static final Pair<Paint.FontMetricsInt, Integer> getLastLineMetrics(TextLayout $this$getLastLineMetrics, TextPaint textPaint, TextDirectionHeuristic frameworkTextDir, LineHeightStyleSpan[] lineHeightSpans) {
        boolean z;
        int lastLine = $this$getLastLineMetrics.getLineCount() - 1;
        if ($this$getLastLineMetrics.getLayout().getLineStart(lastLine) == $this$getLastLineMetrics.getLayout().getLineEnd(lastLine)) {
            if (true ^ (lineHeightSpans.length == 0)) {
                SpannableString emptyText = new SpannableString("​");
                LineHeightStyleSpan lineHeightSpan = (LineHeightStyleSpan) ArraysKt.first((T[]) lineHeightSpans);
                int length = emptyText.length();
                if (lastLine == 0 || !lineHeightSpan.getTrimLastLineBottom()) {
                    z = lineHeightSpan.getTrimLastLineBottom();
                } else {
                    z = false;
                }
                emptyText.setSpan(lineHeightSpan.copy$ui_text_release(0, length, z), 0, emptyText.length(), 33);
                StaticLayout tmpLayout = StaticLayoutFactory.create$default(StaticLayoutFactory.INSTANCE, emptyText, 0, emptyText.length(), textPaint, Integer.MAX_VALUE, frameworkTextDir, (Layout.Alignment) null, 0, (TextUtils.TruncateAt) null, 0, 0.0f, 0.0f, 0, $this$getLastLineMetrics.getIncludePadding(), $this$getLastLineMetrics.getFallbackLineSpacing(), 0, 0, 0, 0, (int[]) null, (int[]) null, 2072512, (Object) null);
                Paint.FontMetricsInt fontMetricsInt = new Paint.FontMetricsInt();
                Paint.FontMetricsInt $this$getLastLineMetrics_u24lambda_u240 = fontMetricsInt;
                $this$getLastLineMetrics_u24lambda_u240.ascent = tmpLayout.getLineAscent(0);
                $this$getLastLineMetrics_u24lambda_u240.descent = tmpLayout.getLineDescent(0);
                $this$getLastLineMetrics_u24lambda_u240.top = tmpLayout.getLineTop(0);
                $this$getLastLineMetrics_u24lambda_u240.bottom = tmpLayout.getLineBottom(0);
                Paint.FontMetricsInt lastLineFontMetrics = fontMetricsInt;
                return new Pair<>(lastLineFontMetrics, Integer.valueOf(lastLineFontMetrics.bottom - ((int) $this$getLastLineMetrics.getLineHeight(lastLine))));
            }
            TextLayout textLayout = $this$getLastLineMetrics;
        } else {
            TextLayout textLayout2 = $this$getLastLineMetrics;
            LineHeightStyleSpan[] lineHeightStyleSpanArr = lineHeightSpans;
        }
        return new Pair<>(null, 0);
    }

    /* access modifiers changed from: private */
    public static final LineHeightStyleSpan[] getLineHeightSpans(TextLayout $this$getLineHeightSpans) {
        if (!($this$getLineHeightSpans.getText() instanceof Spanned)) {
            return new LineHeightStyleSpan[0];
        }
        CharSequence text = $this$getLineHeightSpans.getText();
        Intrinsics.checkNotNull(text, "null cannot be cast to non-null type android.text.Spanned");
        LineHeightStyleSpan[] lineHeightStyleSpans = (LineHeightStyleSpan[]) ((Spanned) text).getSpans(0, $this$getLineHeightSpans.getText().length(), LineHeightStyleSpan.class);
        Intrinsics.checkNotNullExpressionValue(lineHeightStyleSpans, "lineHeightStyleSpans");
        if (lineHeightStyleSpans.length == 0) {
            return new LineHeightStyleSpan[0];
        }
        return lineHeightStyleSpans;
    }

    public static final boolean isLineEllipsized(Layout $this$isLineEllipsized, int lineIndex) {
        Intrinsics.checkNotNullParameter($this$isLineEllipsized, "<this>");
        return $this$isLineEllipsized.getEllipsisCount(lineIndex) > 0;
    }
}
