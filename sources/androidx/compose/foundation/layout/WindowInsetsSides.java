package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\b@\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0000H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005J\u001e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsSides;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hasAny", "sides", "hasAny-bkgdKaI$foundation_layout_release", "(II)Z", "hashCode", "hashCode-impl", "plus", "plus-gK_yJZ4", "(II)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "valueToString", "valueToString-impl", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: WindowInsets.kt */
public final class WindowInsetsSides {
    /* access modifiers changed from: private */
    public static final int AllowLeftInLtr;
    /* access modifiers changed from: private */
    public static final int AllowLeftInRtl;
    /* access modifiers changed from: private */
    public static final int AllowRightInLtr;
    /* access modifiers changed from: private */
    public static final int AllowRightInRtl;
    /* access modifiers changed from: private */
    public static final int Bottom;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int End;
    /* access modifiers changed from: private */
    public static final int Horizontal;
    /* access modifiers changed from: private */
    public static final int Left;
    /* access modifiers changed from: private */
    public static final int Right;
    /* access modifiers changed from: private */
    public static final int Start;
    /* access modifiers changed from: private */
    public static final int Top;
    /* access modifiers changed from: private */
    public static final int Vertical;
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ WindowInsetsSides m858boximpl(int i) {
        return new WindowInsetsSides(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m859constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m860equalsimpl(int i, Object obj) {
        return (obj instanceof WindowInsetsSides) && i == ((WindowInsetsSides) obj).m867unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m861equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m863hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m860equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m863hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m867unboximpl() {
        return this.value;
    }

    private /* synthetic */ WindowInsetsSides(int value2) {
        this.value = value2;
    }

    /* renamed from: plus-gK_yJZ4  reason: not valid java name */
    public static final int m864plusgK_yJZ4(int arg0, int sides) {
        return m859constructorimpl(arg0 | sides);
    }

    /* renamed from: hasAny-bkgdKaI$foundation_layout_release  reason: not valid java name */
    public static final boolean m862hasAnybkgdKaI$foundation_layout_release(int arg0, int sides) {
        return (arg0 & sides) != 0;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m865toStringimpl(int arg0) {
        return "WindowInsetsSides(" + m866valueToStringimpl(arg0) + ')';
    }

    public String toString() {
        return m865toStringimpl(this.value);
    }

    /* renamed from: valueToString-impl  reason: not valid java name */
    private static final String m866valueToStringimpl(int arg0) {
        StringBuilder sb = new StringBuilder();
        StringBuilder $this$valueToString_impl_u24lambda_u240 = sb;
        int i = Start;
        if ((arg0 & i) == i) {
            valueToString_impl$lambda$0$appendPlus($this$valueToString_impl_u24lambda_u240, "Start");
        }
        int i2 = Left;
        if ((arg0 & i2) == i2) {
            valueToString_impl$lambda$0$appendPlus($this$valueToString_impl_u24lambda_u240, "Left");
        }
        int i3 = Top;
        if ((arg0 & i3) == i3) {
            valueToString_impl$lambda$0$appendPlus($this$valueToString_impl_u24lambda_u240, "Top");
        }
        int i4 = End;
        if ((arg0 & i4) == i4) {
            valueToString_impl$lambda$0$appendPlus($this$valueToString_impl_u24lambda_u240, "End");
        }
        int i5 = Right;
        if ((arg0 & i5) == i5) {
            valueToString_impl$lambda$0$appendPlus($this$valueToString_impl_u24lambda_u240, "Right");
        }
        int i6 = Bottom;
        if ((arg0 & i6) == i6) {
            valueToString_impl$lambda$0$appendPlus($this$valueToString_impl_u24lambda_u240, "Bottom");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private static final void valueToString_impl$lambda$0$appendPlus(StringBuilder $this_buildString, String text) {
        if ($this_buildString.length() > 0) {
            $this_buildString.append('+');
        }
        $this_buildString.append(text);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001f\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001f\u0010\n\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001f\u0010\f\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001d\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsSides$Companion;", "", "()V", "AllowLeftInLtr", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "getAllowLeftInLtr-JoeWqyM$foundation_layout_release", "()I", "I", "AllowLeftInRtl", "getAllowLeftInRtl-JoeWqyM$foundation_layout_release", "AllowRightInLtr", "getAllowRightInLtr-JoeWqyM$foundation_layout_release", "AllowRightInRtl", "getAllowRightInRtl-JoeWqyM$foundation_layout_release", "Bottom", "getBottom-JoeWqyM", "End", "getEnd-JoeWqyM", "Horizontal", "getHorizontal-JoeWqyM", "Left", "getLeft-JoeWqyM", "Right", "getRight-JoeWqyM", "Start", "getStart-JoeWqyM", "Top", "getTop-JoeWqyM", "Vertical", "getVertical-JoeWqyM", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: WindowInsets.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getAllowLeftInLtr-JoeWqyM$foundation_layout_release  reason: not valid java name */
        public final int m868getAllowLeftInLtrJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowLeftInLtr;
        }

        /* renamed from: getAllowRightInLtr-JoeWqyM$foundation_layout_release  reason: not valid java name */
        public final int m870getAllowRightInLtrJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowRightInLtr;
        }

        /* renamed from: getAllowLeftInRtl-JoeWqyM$foundation_layout_release  reason: not valid java name */
        public final int m869getAllowLeftInRtlJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowLeftInRtl;
        }

        /* renamed from: getAllowRightInRtl-JoeWqyM$foundation_layout_release  reason: not valid java name */
        public final int m871getAllowRightInRtlJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowRightInRtl;
        }

        /* renamed from: getStart-JoeWqyM  reason: not valid java name */
        public final int m877getStartJoeWqyM() {
            return WindowInsetsSides.Start;
        }

        /* renamed from: getEnd-JoeWqyM  reason: not valid java name */
        public final int m873getEndJoeWqyM() {
            return WindowInsetsSides.End;
        }

        /* renamed from: getTop-JoeWqyM  reason: not valid java name */
        public final int m878getTopJoeWqyM() {
            return WindowInsetsSides.Top;
        }

        /* renamed from: getBottom-JoeWqyM  reason: not valid java name */
        public final int m872getBottomJoeWqyM() {
            return WindowInsetsSides.Bottom;
        }

        /* renamed from: getLeft-JoeWqyM  reason: not valid java name */
        public final int m875getLeftJoeWqyM() {
            return WindowInsetsSides.Left;
        }

        /* renamed from: getRight-JoeWqyM  reason: not valid java name */
        public final int m876getRightJoeWqyM() {
            return WindowInsetsSides.Right;
        }

        /* renamed from: getHorizontal-JoeWqyM  reason: not valid java name */
        public final int m874getHorizontalJoeWqyM() {
            return WindowInsetsSides.Horizontal;
        }

        /* renamed from: getVertical-JoeWqyM  reason: not valid java name */
        public final int m879getVerticalJoeWqyM() {
            return WindowInsetsSides.Vertical;
        }
    }

    static {
        int r0 = m859constructorimpl(8);
        AllowLeftInLtr = r0;
        int r1 = m859constructorimpl(4);
        AllowRightInLtr = r1;
        int r2 = m859constructorimpl(2);
        AllowLeftInRtl = r2;
        int r3 = m859constructorimpl(1);
        AllowRightInRtl = r3;
        Start = m864plusgK_yJZ4(r0, r3);
        End = m864plusgK_yJZ4(r1, r2);
        int r4 = m859constructorimpl(16);
        Top = r4;
        int r5 = m859constructorimpl(32);
        Bottom = r5;
        int r02 = m864plusgK_yJZ4(r0, r2);
        Left = r02;
        int r12 = m864plusgK_yJZ4(r1, r3);
        Right = r12;
        Horizontal = m864plusgK_yJZ4(r02, r12);
        Vertical = m864plusgK_yJZ4(r4, r5);
    }
}
