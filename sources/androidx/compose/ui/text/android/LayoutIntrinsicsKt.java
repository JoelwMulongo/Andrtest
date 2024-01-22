package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import java.text.BreakIterator;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"minIntrinsicWidth", "", "text", "", "paint", "Landroid/text/TextPaint;", "shouldIncreaseMaxIntrinsic", "", "desiredWidth", "charSequence", "textPaint", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutIntrinsics.kt */
public final class LayoutIntrinsicsKt {
    public static final float minIntrinsicWidth(CharSequence text, TextPaint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        BreakIterator iterator = BreakIterator.getLineInstance(paint.getTextLocale());
        iterator.setText(new CharSequenceCharacterIterator(text, 0, text.length()));
        PriorityQueue<Pair> longestWordCandidates = new PriorityQueue<>(10, new LayoutIntrinsicsKt$$ExternalSyntheticLambda0());
        int start = 0;
        for (int end = iterator.next(); end != -1; end = iterator.next()) {
            if (longestWordCandidates.size() < 10) {
                longestWordCandidates.add(new Pair(Integer.valueOf(start), Integer.valueOf(end)));
            } else {
                Pair minPair = (Pair) longestWordCandidates.peek();
                if (minPair != null && ((Number) minPair.getSecond()).intValue() - ((Number) minPair.getFirst()).intValue() < end - start) {
                    longestWordCandidates.poll();
                    longestWordCandidates.add(new Pair(Integer.valueOf(start), Integer.valueOf(end)));
                }
            }
            start = end;
        }
        float minWidth = 0.0f;
        for (Pair pair : longestWordCandidates) {
            minWidth = Math.max(minWidth, Layout.getDesiredWidth(text, ((Number) pair.component1()).intValue(), ((Number) pair.component2()).intValue(), paint));
        }
        return minWidth;
    }

    /* access modifiers changed from: private */
    public static final int minIntrinsicWidth$lambda$0(Pair left, Pair right) {
        return (((Number) left.getSecond()).intValue() - ((Number) left.getFirst()).intValue()) - (((Number) right.getSecond()).intValue() - ((Number) right.getFirst()).intValue());
    }

    /* access modifiers changed from: private */
    public static final boolean shouldIncreaseMaxIntrinsic(float desiredWidth, CharSequence charSequence, TextPaint textPaint) {
        if (!(desiredWidth == 0.0f)) {
            if ((charSequence instanceof Spanned) && (SpannedExtensionsKt.hasSpan((Spanned) charSequence, LetterSpacingSpanPx.class) || SpannedExtensionsKt.hasSpan((Spanned) charSequence, LetterSpacingSpanEm.class))) {
                return true;
            }
            if (!(textPaint.getLetterSpacing() == 0.0f)) {
                return true;
            }
        }
        return false;
    }
}
