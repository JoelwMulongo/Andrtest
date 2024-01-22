package androidx.compose.foundation.lazy.grid;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u0000H\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0005J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005J\u0019\u0010\u0014\u001a\u00020\u0000H\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0005J\u001e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u000bJ!\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0003H\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u000bJ!\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0003H\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/foundation/lazy/grid/LineIndex;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "compareTo", "other", "compareTo-bKFJvoY", "(II)I", "dec", "dec-hA7yfN8", "equals", "", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "inc", "inc-hA7yfN8", "minus", "i", "minus-fVkYB0M", "minus--_Ze7BM", "plus", "plus--_Ze7BM", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: ItemIndex.kt */
public final class LineIndex {
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ LineIndex m986boximpl(int i) {
        return new LineIndex(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m988constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m990equalsimpl(int i, Object obj) {
        return (obj instanceof LineIndex) && i == ((LineIndex) obj).m998unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m991equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m992hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m997toStringimpl(int i) {
        return "LineIndex(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m990equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m992hashCodeimpl(this.value);
    }

    public String toString() {
        return m997toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m998unboximpl() {
        return this.value;
    }

    private /* synthetic */ LineIndex(int value2) {
        this.value = value2;
    }

    public final int getValue() {
        return this.value;
    }

    /* renamed from: inc-hA7yfN8  reason: not valid java name */
    public static final int m993inchA7yfN8(int arg0) {
        return m988constructorimpl(arg0 + 1);
    }

    /* renamed from: dec-hA7yfN8  reason: not valid java name */
    public static final int m989dechA7yfN8(int arg0) {
        return m988constructorimpl(arg0 - 1);
    }

    /* renamed from: plus--_Ze7BM  reason: not valid java name */
    public static final int m996plus_Ze7BM(int arg0, int i) {
        return m988constructorimpl(arg0 + i);
    }

    /* renamed from: minus--_Ze7BM  reason: not valid java name */
    public static final int m994minus_Ze7BM(int arg0, int i) {
        return m988constructorimpl(arg0 - i);
    }

    /* renamed from: minus-fVkYB0M  reason: not valid java name */
    public static final int m995minusfVkYB0M(int arg0, int i) {
        return m988constructorimpl(arg0 - i);
    }

    /* renamed from: compareTo-bKFJvoY  reason: not valid java name */
    public static final int m987compareTobKFJvoY(int arg0, int other) {
        return arg0 - other;
    }
}
