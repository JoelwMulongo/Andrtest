package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0006\u0010\u0018\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u001e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u000e\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/input/GapBuffer;", "", "initBuffer", "", "initGapStart", "", "initGapEnd", "([CII)V", "buffer", "capacity", "gapEnd", "gapStart", "append", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "delete", "start", "end", "gapLength", "get", "", "index", "length", "makeSureAvailableSpace", "requestSize", "replace", "text", "", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GapBuffer.kt */
final class GapBuffer {
    private char[] buffer;
    private int capacity;
    private int gapEnd;
    private int gapStart;

    public GapBuffer(char[] initBuffer, int initGapStart, int initGapEnd) {
        Intrinsics.checkNotNullParameter(initBuffer, "initBuffer");
        this.capacity = initBuffer.length;
        this.buffer = initBuffer;
        this.gapStart = initGapStart;
        this.gapEnd = initGapEnd;
    }

    private final int gapLength() {
        return this.gapEnd - this.gapStart;
    }

    public final char get(int index) {
        int i = this.gapStart;
        if (index < i) {
            return this.buffer[index];
        }
        return this.buffer[(index - i) + this.gapEnd];
    }

    private final void makeSureAvailableSpace(int requestSize) {
        if (requestSize > gapLength()) {
            int necessarySpace = requestSize - gapLength();
            int newCapacity = this.capacity;
            while (true) {
                newCapacity *= 2;
                if (newCapacity - this.capacity >= necessarySpace) {
                    char[] newBuffer = new char[newCapacity];
                    ArraysKt.copyInto(this.buffer, newBuffer, 0, 0, this.gapStart);
                    int i = this.capacity;
                    int i2 = this.gapEnd;
                    int tailLength = i - i2;
                    int newEnd = newCapacity - tailLength;
                    ArraysKt.copyInto(this.buffer, newBuffer, newEnd, i2, i2 + tailLength);
                    this.buffer = newBuffer;
                    this.capacity = newCapacity;
                    this.gapEnd = newEnd;
                    return;
                }
            }
        }
    }

    private final void delete(int start, int end) {
        int i = this.gapStart;
        if (start < i && end <= i) {
            int copyLen = i - end;
            char[] cArr = this.buffer;
            ArraysKt.copyInto(cArr, cArr, this.gapEnd - copyLen, end, i);
            this.gapStart = start;
            this.gapEnd -= copyLen;
        } else if (start >= i || end < i) {
            int startInBuffer = gapLength() + start;
            int i2 = this.gapEnd;
            char[] cArr2 = this.buffer;
            ArraysKt.copyInto(cArr2, cArr2, this.gapStart, i2, startInBuffer);
            this.gapStart += startInBuffer - i2;
            this.gapEnd = gapLength() + end;
        } else {
            this.gapEnd = gapLength() + end;
            this.gapStart = start;
        }
    }

    public final void replace(int start, int end, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        makeSureAvailableSpace(text.length() - (end - start));
        delete(start, end);
        GapBufferKt.toCharArray(text, this.buffer, this.gapStart);
        this.gapStart += text.length();
    }

    public final void append(StringBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.append(this.buffer, 0, this.gapStart);
        char[] cArr = this.buffer;
        int i = this.gapEnd;
        builder.append(cArr, i, this.capacity - i);
    }

    public final int length() {
        return this.capacity - gapLength();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder $this$toString_u24lambda_u240 = sb;
        $this$toString_u24lambda_u240.append($this$toString_u24lambda_u240);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply { append(this) }.toString()");
        return sb2;
    }
}
