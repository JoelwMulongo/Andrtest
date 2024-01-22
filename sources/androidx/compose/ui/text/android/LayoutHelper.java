package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.TextUtils;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\rJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aJ\u0010\u0010\u001e\u001a\u00020\r2\b\b\u0001\u0010\u0015\u001a\u00020\rJ\u001a\u0010\u001f\u001a\u00020\r2\b\b\u0001\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\u001aJ\u0010\u0010 \u001a\u00020\r2\b\b\u0001\u0010\u0015\u001a\u00020\rJ\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u001a2\b\b\u0001\u0010\u0015\u001a\u00020\rJ\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/compose/ui/text/android/LayoutHelper;", "", "layout", "Landroid/text/Layout;", "(Landroid/text/Layout;)V", "bidiProcessedParagraphs", "", "getLayout", "()Landroid/text/Layout;", "paragraphBidi", "", "Ljava/text/Bidi;", "paragraphCount", "", "getParagraphCount", "()I", "paragraphEnds", "", "tmpBuffer", "", "analyzeBidi", "paragraphIndex", "getDownstreamHorizontal", "", "offset", "primary", "", "getHorizontalPosition", "usePrimaryDirection", "upstream", "getParagraphEnd", "getParagraphForOffset", "getParagraphStart", "isLineEndSpace", "c", "", "isRtlParagraph", "lineEndToVisibleEnd", "lineEnd", "BidiRun", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutHelper.kt */
public final class LayoutHelper {
    public static final int $stable = 8;
    private final boolean[] bidiProcessedParagraphs;
    private final Layout layout;
    private final List<Bidi> paragraphBidi;
    private final int paragraphCount;
    private final List<Integer> paragraphEnds;
    private char[] tmpBuffer;

    public LayoutHelper(Layout layout2) {
        Intrinsics.checkNotNullParameter(layout2, "layout");
        this.layout = layout2;
        int paragraphEnd = 0;
        List lineFeeds = new ArrayList();
        do {
            CharSequence text = this.layout.getText();
            Intrinsics.checkNotNullExpressionValue(text, "layout.text");
            int paragraphEnd2 = StringsKt.indexOf$default(text, 10, paragraphEnd, false, 4, (Object) null);
            if (paragraphEnd2 < 0) {
                paragraphEnd = this.layout.getText().length();
            } else {
                paragraphEnd = paragraphEnd2 + 1;
            }
            lineFeeds.add(Integer.valueOf(paragraphEnd));
        } while (paragraphEnd < this.layout.getText().length());
        this.paragraphEnds = lineFeeds;
        int size = lineFeeds.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            int i2 = i;
            arrayList.add((Object) null);
        }
        this.paragraphBidi = arrayList;
        this.bidiProcessedParagraphs = new boolean[this.paragraphEnds.size()];
        this.paragraphCount = this.paragraphEnds.size();
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final Bidi analyzeBidi(int paragraphIndex) {
        char[] cArr;
        Bidi bidi;
        int flag;
        if (this.bidiProcessedParagraphs[paragraphIndex]) {
            return this.paragraphBidi.get(paragraphIndex);
        }
        int paragraphStart = paragraphIndex == 0 ? 0 : this.paragraphEnds.get(paragraphIndex - 1).intValue();
        int paragraphEnd = this.paragraphEnds.get(paragraphIndex).intValue();
        int paragraphLength = paragraphEnd - paragraphStart;
        char[] buffer = this.tmpBuffer;
        if (buffer == null || buffer.length < paragraphLength) {
            cArr = new char[paragraphLength];
        } else {
            cArr = buffer;
        }
        char[] buffer2 = cArr;
        TextUtils.getChars(this.layout.getText(), paragraphStart, paragraphEnd, buffer2, 0);
        char[] cArr2 = null;
        if (Bidi.requiresBidi(buffer2, 0, paragraphLength)) {
            if (isRtlParagraph(paragraphIndex)) {
                flag = 1;
            } else {
                flag = 0;
            }
            bidi = new Bidi(buffer2, 0, (byte[]) null, 0, paragraphLength, flag);
            if (bidi.getRunCount() == 1) {
                bidi = null;
            }
        } else {
            bidi = null;
        }
        this.paragraphBidi.set(paragraphIndex, bidi);
        this.bidiProcessedParagraphs[paragraphIndex] = true;
        if (bidi != null) {
            char[] cArr3 = this.tmpBuffer;
            if (buffer2 != cArr3) {
                cArr2 = cArr3;
            }
        } else {
            cArr2 = buffer2;
        }
        this.tmpBuffer = cArr2;
        return bidi;
    }

    public final int getParagraphCount() {
        return this.paragraphCount;
    }

    public static /* synthetic */ int getParagraphForOffset$default(LayoutHelper layoutHelper, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return layoutHelper.getParagraphForOffset(i, z);
    }

    public final int getParagraphForOffset(int offset, boolean upstream) {
        int it = CollectionsKt.binarySearch$default((List) this.paragraphEnds, (Comparable) Integer.valueOf(offset), 0, 0, 6, (Object) null);
        int i = it + 1;
        if (it < 0) {
            i = -i;
        }
        int it2 = i;
        if (!upstream || it2 <= 0 || offset != this.paragraphEnds.get(it2 - 1).intValue()) {
            return it2;
        }
        return it2 - 1;
    }

    public final int getParagraphStart(int paragraphIndex) {
        if (paragraphIndex == 0) {
            return 0;
        }
        return this.paragraphEnds.get(paragraphIndex - 1).intValue();
    }

    public final int getParagraphEnd(int paragraphIndex) {
        return this.paragraphEnds.get(paragraphIndex).intValue();
    }

    public final boolean isRtlParagraph(int paragraphIndex) {
        return this.layout.getParagraphDirection(this.layout.getLineForOffset(getParagraphStart(paragraphIndex))) == -1;
    }

    public final float getHorizontalPosition(int offset, boolean usePrimaryDirection, boolean upstream) {
        boolean isStartLeft;
        int lineEndAdjustedOffset;
        boolean isLeftRequested;
        int index;
        boolean z;
        int i = offset;
        boolean z2 = upstream;
        if (!z2) {
            return getDownstreamHorizontal(offset, usePrimaryDirection);
        }
        int lineNo = LayoutCompatKt.getLineForOffset(this.layout, i, z2);
        int lineStart = this.layout.getLineStart(lineNo);
        int lineEnd = this.layout.getLineEnd(lineNo);
        if (i != lineStart && i != lineEnd) {
            return getDownstreamHorizontal(offset, usePrimaryDirection);
        }
        if (i == 0) {
        } else if (i == this.layout.getText().length()) {
            int i2 = lineEnd;
        } else {
            int paraNo = getParagraphForOffset(i, z2);
            boolean isParaRtl = isRtlParagraph(paraNo);
            int lineVisibleEnd = lineEndToVisibleEnd(lineEnd);
            int paragraphStart = getParagraphStart(paraNo);
            int bidiStart = lineStart - paragraphStart;
            int bidiEnd = lineVisibleEnd - paragraphStart;
            Bidi analyzeBidi = analyzeBidi(paraNo);
            Bidi lineBidi = analyzeBidi != null ? analyzeBidi.createLineBidi(bidiStart, bidiEnd) : null;
            if (lineBidi == null) {
                int i3 = paraNo;
                int i4 = paragraphStart;
                int i5 = bidiStart;
            } else if (lineBidi.getRunCount() == 1) {
                int i6 = lineEnd;
                int i7 = paraNo;
                int i8 = paragraphStart;
                int i9 = bidiStart;
            } else {
                int runCount = lineBidi.getRunCount();
                BidiRun[] bidiRunArr = new BidiRun[runCount];
                int i10 = 0;
                while (i10 < runCount) {
                    int lineEnd2 = lineEnd;
                    int paraNo2 = paraNo;
                    int paragraphStart2 = paragraphStart;
                    int bidiStart2 = bidiStart;
                    bidiRunArr[i10] = new BidiRun(lineStart + lineBidi.getRunStart(i10), lineStart + lineBidi.getRunLimit(i10), lineBidi.getRunLevel(i10) % 2 == 1);
                    i10++;
                    boolean z3 = upstream;
                    bidiStart = bidiStart2;
                    lineEnd = lineEnd2;
                    paraNo = paraNo2;
                    paragraphStart = paragraphStart2;
                }
                int i11 = paraNo;
                int i12 = paragraphStart;
                int i13 = bidiStart;
                BidiRun[] runs = bidiRunArr;
                int runCount2 = lineBidi.getRunCount();
                byte[] levels = new byte[runCount2];
                for (int i14 = 0; i14 < runCount2; i14++) {
                    levels[i14] = (byte) lineBidi.getRunLevel(i14);
                }
                Bidi.reorderVisually(levels, 0, runs, 0, runs.length);
                if (i == lineStart) {
                    BidiRun[] bidiRunArr2 = runs;
                    int index$iv = 0;
                    int length = bidiRunArr2.length;
                    while (true) {
                        if (index$iv >= length) {
                            index = -1;
                            break;
                        }
                        if (bidiRunArr2[index$iv].getStart() == i) {
                            index = index$iv;
                            break;
                        }
                        index$iv++;
                    }
                    BidiRun run = runs[index];
                    if (usePrimaryDirection || isParaRtl == run.isRtl()) {
                        z = !isParaRtl;
                    } else {
                        z = isParaRtl;
                    }
                    boolean isLeftRequested2 = z;
                    if (index == 0 && isLeftRequested2) {
                        return this.layout.getLineLeft(lineNo);
                    }
                    if (index == ArraysKt.getLastIndex((T[]) runs) && !isLeftRequested2) {
                        return this.layout.getLineRight(lineNo);
                    }
                    if (isLeftRequested2) {
                        return this.layout.getPrimaryHorizontal(runs[index - 1].getStart());
                    }
                    return this.layout.getPrimaryHorizontal(runs[index + 1].getStart());
                }
                if (i > lineVisibleEnd) {
                    lineEndAdjustedOffset = lineEndToVisibleEnd(offset);
                } else {
                    lineEndAdjustedOffset = i;
                }
                BidiRun[] bidiRunArr3 = runs;
                int index$iv2 = 0;
                int length2 = bidiRunArr3.length;
                while (true) {
                    if (index$iv2 >= length2) {
                        index$iv2 = -1;
                        break;
                    }
                    if (bidiRunArr3[index$iv2].getEnd() == lineEndAdjustedOffset) {
                        break;
                    }
                    index$iv2++;
                }
                int index2 = index$iv2;
                BidiRun run2 = runs[index2];
                if (usePrimaryDirection || isParaRtl == run2.isRtl()) {
                    isLeftRequested = isParaRtl;
                } else {
                    isLeftRequested = !isParaRtl;
                }
                if (index2 == 0 && isLeftRequested) {
                    return this.layout.getLineLeft(lineNo);
                }
                if (index2 == ArraysKt.getLastIndex((T[]) runs) && !isLeftRequested) {
                    return this.layout.getLineRight(lineNo);
                }
                if (isLeftRequested) {
                    return this.layout.getPrimaryHorizontal(runs[index2 - 1].getEnd());
                }
                return this.layout.getPrimaryHorizontal(runs[index2 + 1].getEnd());
            }
            boolean runDirection = this.layout.isRtlCharAt(lineStart);
            if (usePrimaryDirection || isParaRtl == runDirection) {
                isStartLeft = !isParaRtl;
            } else {
                isStartLeft = isParaRtl;
            }
            boolean isOffsetLeft = i == lineStart ? isStartLeft : !isStartLeft;
            Layout layout2 = this.layout;
            return isOffsetLeft ? layout2.getLineLeft(lineNo) : layout2.getLineRight(lineNo);
        }
        return getDownstreamHorizontal(offset, usePrimaryDirection);
    }

    private final float getDownstreamHorizontal(int offset, boolean primary) {
        if (primary) {
            return this.layout.getPrimaryHorizontal(offset);
        }
        return this.layout.getSecondaryHorizontal(offset);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "", "start", "", "end", "isRtl", "", "(IIZ)V", "getEnd", "()I", "()Z", "getStart", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LayoutHelper.kt */
    private static final class BidiRun {
        private final int end;
        private final boolean isRtl;
        private final int start;

        public static /* synthetic */ BidiRun copy$default(BidiRun bidiRun, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = bidiRun.start;
            }
            if ((i3 & 2) != 0) {
                i2 = bidiRun.end;
            }
            if ((i3 & 4) != 0) {
                z = bidiRun.isRtl;
            }
            return bidiRun.copy(i, i2, z);
        }

        public final int component1() {
            return this.start;
        }

        public final int component2() {
            return this.end;
        }

        public final boolean component3() {
            return this.isRtl;
        }

        public final BidiRun copy(int i, int i2, boolean z) {
            return new BidiRun(i, i2, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BidiRun)) {
                return false;
            }
            BidiRun bidiRun = (BidiRun) obj;
            return this.start == bidiRun.start && this.end == bidiRun.end && this.isRtl == bidiRun.isRtl;
        }

        public int hashCode() {
            int hashCode = ((Integer.hashCode(this.start) * 31) + Integer.hashCode(this.end)) * 31;
            boolean z = this.isRtl;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public String toString() {
            return "BidiRun(start=" + this.start + ", end=" + this.end + ", isRtl=" + this.isRtl + ')';
        }

        public BidiRun(int start2, int end2, boolean isRtl2) {
            this.start = start2;
            this.end = end2;
            this.isRtl = isRtl2;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public final boolean isRtl() {
            return this.isRtl;
        }
    }

    private final int lineEndToVisibleEnd(int lineEnd) {
        int visibleEnd = lineEnd;
        while (visibleEnd > 0 && isLineEndSpace(this.layout.getText().charAt(visibleEnd - 1))) {
            visibleEnd--;
        }
        return visibleEnd;
    }

    public final boolean isLineEndSpace(char c) {
        if (c == ' ' || c == 10 || c == 5760) {
            return true;
        }
        if (((8192 <= c && c < 8203) && c != 8199) || c == 8287 || c == 12288) {
            return true;
        }
        return false;
    }
}
