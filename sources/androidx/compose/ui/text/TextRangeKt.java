package androidx.compose.ui.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0010\r\n\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002\u001a)\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001f\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"TextRange", "Landroidx/compose/ui/text/TextRange;", "index", "", "(I)J", "start", "end", "(II)J", "packWithCheck", "", "constrain", "minimumValue", "maximumValue", "constrain-8ffj60Q", "(JII)J", "substring", "", "", "range", "substring-FDrldGo", "(Ljava/lang/CharSequence;J)Ljava/lang/String;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextRange.kt */
public final class TextRangeKt {
    /* renamed from: substring-FDrldGo  reason: not valid java name */
    public static final String m5481substringFDrldGo(CharSequence $this$substring_u2dFDrldGo, long range) {
        Intrinsics.checkNotNullParameter($this$substring_u2dFDrldGo, "$this$substring");
        return $this$substring_u2dFDrldGo.subSequence(TextRange.m5472getMinimpl(range), TextRange.m5471getMaximpl(range)).toString();
    }

    public static final long TextRange(int start, int end) {
        return TextRange.m5463constructorimpl(packWithCheck(start, end));
    }

    public static final long TextRange(int index) {
        return TextRange(index, index);
    }

    /* renamed from: constrain-8ffj60Q  reason: not valid java name */
    public static final long m5480constrain8ffj60Q(long $this$constrain_u2d8ffj60Q, int minimumValue, int maximumValue) {
        int newStart = RangesKt.coerceIn(TextRange.m5474getStartimpl($this$constrain_u2d8ffj60Q), minimumValue, maximumValue);
        int newEnd = RangesKt.coerceIn(TextRange.m5469getEndimpl($this$constrain_u2d8ffj60Q), minimumValue, maximumValue);
        if (newStart == TextRange.m5474getStartimpl($this$constrain_u2d8ffj60Q) && newEnd == TextRange.m5469getEndimpl($this$constrain_u2d8ffj60Q)) {
            return $this$constrain_u2d8ffj60Q;
        }
        return TextRange(newStart, newEnd);
    }

    private static final long packWithCheck(int start, int end) {
        boolean z = true;
        if (start >= 0) {
            if (end < 0) {
                z = false;
            }
            if (z) {
                return (((long) start) << 32) | (((long) end) & 4294967295L);
            }
            throw new IllegalArgumentException(("end cannot be negative. [start: " + start + ", end: " + end + ']').toString());
        }
        throw new IllegalArgumentException(("start cannot be negative. [start: " + start + ", end: " + end + ']').toString());
    }
}
