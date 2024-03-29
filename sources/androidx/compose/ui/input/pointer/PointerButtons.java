package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0016\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\r\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00060\u0003j\u0002`\u0004ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerButtons;", "", "packedValue", "", "Landroidx/compose/ui/input/pointer/NativePointerButtons;", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: PointerEvent.kt */
public final class PointerButtons {
    private final int packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ PointerButtons m4602boximpl(int i) {
        return new PointerButtons(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m4603constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m4604equalsimpl(int i, Object obj) {
        return (obj instanceof PointerButtons) && i == ((PointerButtons) obj).m4608unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m4605equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m4606hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m4607toStringimpl(int i) {
        return "PointerButtons(packedValue=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m4604equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m4606hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m4607toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m4608unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ PointerButtons(int packedValue2) {
        this.packedValue = packedValue2;
    }
}
