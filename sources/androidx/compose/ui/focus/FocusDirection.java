package androidx.compose.ui.focus;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/focus/FocusDirection;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: FocusDirection.kt */
public final class FocusDirection {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Down = m2837constructorimpl(6);
    /* access modifiers changed from: private */
    public static final int Enter;
    /* access modifiers changed from: private */
    public static final int Exit;
    /* access modifiers changed from: private */
    public static final int In;
    /* access modifiers changed from: private */
    public static final int Left = m2837constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Next = m2837constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int Out;
    /* access modifiers changed from: private */
    public static final int Previous = m2837constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int Right = m2837constructorimpl(4);
    /* access modifiers changed from: private */
    public static final int Up = m2837constructorimpl(5);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ FocusDirection m2836boximpl(int i) {
        return new FocusDirection(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m2837constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2838equalsimpl(int i, Object obj) {
        return (obj instanceof FocusDirection) && i == ((FocusDirection) obj).m2842unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m2839equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2840hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m2838equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2840hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m2842unboximpl() {
        return this.value;
    }

    private /* synthetic */ FocusDirection(int value2) {
        this.value = value2;
    }

    public String toString() {
        return m2841toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2841toStringimpl(int arg0) {
        if (m2839equalsimpl0(arg0, Next)) {
            return "Next";
        }
        if (m2839equalsimpl0(arg0, Previous)) {
            return "Previous";
        }
        if (m2839equalsimpl0(arg0, Left)) {
            return "Left";
        }
        if (m2839equalsimpl0(arg0, Right)) {
            return "Right";
        }
        if (m2839equalsimpl0(arg0, Up)) {
            return "Up";
        }
        if (m2839equalsimpl0(arg0, Down)) {
            return "Down";
        }
        if (m2839equalsimpl0(arg0, Enter)) {
            return "Enter";
        }
        if (m2839equalsimpl0(arg0, Exit)) {
            return "Exit";
        }
        return "Invalid FocusDirection";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R'\u0010\b\u001a\u00020\u00048GX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0007\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0006R'\u0010\u000b\u001a\u00020\u00048GX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0007\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0006R'\u0010\u000e\u001a\u00020\u00048GX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0007\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0014\u0010\u0006R'\u0010\u0015\u001a\u00020\u00048GX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u0007\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001d\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/focus/FocusDirection$Companion;", "", "()V", "Down", "Landroidx/compose/ui/focus/FocusDirection;", "getDown-dhqQ-8s", "()I", "I", "Enter", "getEnter-dhqQ-8s$annotations", "getEnter-dhqQ-8s", "Exit", "getExit-dhqQ-8s$annotations", "getExit-dhqQ-8s", "In", "getIn-dhqQ-8s$annotations", "getIn-dhqQ-8s", "Left", "getLeft-dhqQ-8s", "Next", "getNext-dhqQ-8s", "Out", "getOut-dhqQ-8s$annotations", "getOut-dhqQ-8s", "Previous", "getPrevious-dhqQ-8s", "Right", "getRight-dhqQ-8s", "Up", "getUp-dhqQ-8s", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusDirection.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getEnter-dhqQ-8s$annotations  reason: not valid java name */
        public static /* synthetic */ void m2843getEnterdhqQ8s$annotations() {
        }

        /* renamed from: getExit-dhqQ-8s$annotations  reason: not valid java name */
        public static /* synthetic */ void m2844getExitdhqQ8s$annotations() {
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Use FocusDirection.Enter instead.", replaceWith = @ReplaceWith(expression = "Enter", imports = {"androidx.compose.ui.focus.FocusDirection.Companion.Enter"}))
        /* renamed from: getIn-dhqQ-8s$annotations  reason: not valid java name */
        public static /* synthetic */ void m2845getIndhqQ8s$annotations() {
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Use FocusDirection.Exit instead.", replaceWith = @ReplaceWith(expression = "Exit", imports = {"androidx.compose.ui.focus.FocusDirection.Companion.Exit"}))
        /* renamed from: getOut-dhqQ-8s$annotations  reason: not valid java name */
        public static /* synthetic */ void m2846getOutdhqQ8s$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getNext-dhqQ-8s  reason: not valid java name */
        public final int m2852getNextdhqQ8s() {
            return FocusDirection.Next;
        }

        /* renamed from: getPrevious-dhqQ-8s  reason: not valid java name */
        public final int m2854getPreviousdhqQ8s() {
            return FocusDirection.Previous;
        }

        /* renamed from: getLeft-dhqQ-8s  reason: not valid java name */
        public final int m2851getLeftdhqQ8s() {
            return FocusDirection.Left;
        }

        /* renamed from: getRight-dhqQ-8s  reason: not valid java name */
        public final int m2855getRightdhqQ8s() {
            return FocusDirection.Right;
        }

        /* renamed from: getUp-dhqQ-8s  reason: not valid java name */
        public final int m2856getUpdhqQ8s() {
            return FocusDirection.Up;
        }

        /* renamed from: getDown-dhqQ-8s  reason: not valid java name */
        public final int m2847getDowndhqQ8s() {
            return FocusDirection.Down;
        }

        /* renamed from: getEnter-dhqQ-8s  reason: not valid java name */
        public final int m2848getEnterdhqQ8s() {
            return FocusDirection.Enter;
        }

        /* renamed from: getExit-dhqQ-8s  reason: not valid java name */
        public final int m2849getExitdhqQ8s() {
            return FocusDirection.Exit;
        }

        /* renamed from: getIn-dhqQ-8s  reason: not valid java name */
        public final int m2850getIndhqQ8s() {
            return FocusDirection.In;
        }

        /* renamed from: getOut-dhqQ-8s  reason: not valid java name */
        public final int m2853getOutdhqQ8s() {
            return FocusDirection.Out;
        }
    }

    static {
        int r0 = m2837constructorimpl(7);
        Enter = r0;
        int r1 = m2837constructorimpl(8);
        Exit = r1;
        In = r0;
        Out = r1;
    }
}
