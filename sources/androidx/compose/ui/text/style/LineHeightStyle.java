package androidx.compose.ui.text.style;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0003\u0014\u0015\u0016B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle;", "", "alignment", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "trim", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "(FILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment-PIaL0Z0", "()F", "F", "getTrim-EVpEnUU", "()I", "I", "equals", "", "other", "hashCode", "", "toString", "", "Alignment", "Companion", "Trim", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LineHeightStyle.kt */
public final class LineHeightStyle {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final LineHeightStyle Default = new LineHeightStyle(Alignment.Companion.m5827getProportionalPIaL0Z0(), Trim.Companion.m5838getBothEVpEnUU(), (DefaultConstructorMarker) null);
    private final float alignment;
    private final int trim;

    public /* synthetic */ LineHeightStyle(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, i);
    }

    private LineHeightStyle(float alignment2, int trim2) {
        this.alignment = alignment2;
        this.trim = trim2;
    }

    /* renamed from: getAlignment-PIaL0Z0  reason: not valid java name */
    public final float m5812getAlignmentPIaL0Z0() {
        return this.alignment;
    }

    /* renamed from: getTrim-EVpEnUU  reason: not valid java name */
    public final int m5813getTrimEVpEnUU() {
        return this.trim;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/style/LineHeightStyle;", "getDefault", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LineHeightStyle.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LineHeightStyle getDefault() {
            return LineHeightStyle.Default;
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof LineHeightStyle) && Alignment.m5817equalsimpl0(this.alignment, ((LineHeightStyle) other).alignment) && Trim.m5832equalsimpl0(this.trim, ((LineHeightStyle) other).trim)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Alignment.m5818hashCodeimpl(this.alignment) * 31) + Trim.m5833hashCodeimpl(this.trim);
    }

    public String toString() {
        return "LineHeightStyle(alignment=" + Alignment.m5819toStringimpl(this.alignment) + ", trim=" + Trim.m5836toStringimpl(this.trim) + ')';
    }

    @JvmInline
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isTrimFirstLineTop", "isTrimFirstLineTop-impl$ui_text_release", "(I)Z", "isTrimLastLineBottom", "isTrimLastLineBottom-impl$ui_text_release", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LineHeightStyle.kt */
    public static final class Trim {
        /* access modifiers changed from: private */
        public static final int Both = m5830constructorimpl(17);
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final int FirstLineTop = m5830constructorimpl(1);
        private static final int FlagTrimBottom = 16;
        private static final int FlagTrimTop = 1;
        /* access modifiers changed from: private */
        public static final int LastLineBottom = m5830constructorimpl(16);
        /* access modifiers changed from: private */
        public static final int None = m5830constructorimpl(0);
        private final int value;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Trim m5829boximpl(int i) {
            return new Trim(i);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        private static int m5830constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m5831equalsimpl(int i, Object obj) {
            return (obj instanceof Trim) && i == ((Trim) obj).m5837unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m5832equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m5833hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object obj) {
            return m5831equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5833hashCodeimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m5837unboximpl() {
            return this.value;
        }

        private /* synthetic */ Trim(int value2) {
            this.value = value2;
        }

        public String toString() {
            return m5836toStringimpl(this.value);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m5836toStringimpl(int arg0) {
            if (arg0 == FirstLineTop) {
                return "LineHeightStyle.Trim.FirstLineTop";
            }
            if (arg0 == LastLineBottom) {
                return "LineHeightStyle.Trim.LastLineBottom";
            }
            if (arg0 == Both) {
                return "LineHeightStyle.Trim.Both";
            }
            if (arg0 == None) {
                return "LineHeightStyle.Trim.None";
            }
            return "Invalid";
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0010\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Trim$Companion;", "", "()V", "Both", "Landroidx/compose/ui/text/style/LineHeightStyle$Trim;", "getBoth-EVpEnUU", "()I", "I", "FirstLineTop", "getFirstLineTop-EVpEnUU", "FlagTrimBottom", "", "FlagTrimTop", "LastLineBottom", "getLastLineBottom-EVpEnUU", "None", "getNone-EVpEnUU", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: LineHeightStyle.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* renamed from: getFirstLineTop-EVpEnUU  reason: not valid java name */
            public final int m5839getFirstLineTopEVpEnUU() {
                return Trim.FirstLineTop;
            }

            /* renamed from: getLastLineBottom-EVpEnUU  reason: not valid java name */
            public final int m5840getLastLineBottomEVpEnUU() {
                return Trim.LastLineBottom;
            }

            /* renamed from: getBoth-EVpEnUU  reason: not valid java name */
            public final int m5838getBothEVpEnUU() {
                return Trim.Both;
            }

            /* renamed from: getNone-EVpEnUU  reason: not valid java name */
            public final int m5841getNoneEVpEnUU() {
                return Trim.None;
            }
        }

        /* renamed from: isTrimFirstLineTop-impl$ui_text_release  reason: not valid java name */
        public static final boolean m5834isTrimFirstLineTopimpl$ui_text_release(int arg0) {
            return (arg0 & 1) > 0;
        }

        /* renamed from: isTrimLastLineBottom-impl$ui_text_release  reason: not valid java name */
        public static final boolean m5835isTrimLastLineBottomimpl$ui_text_release(int arg0) {
            return (arg0 & 16) > 0;
        }
    }

    @JvmInline
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0014\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "", "topRatio", "", "constructor-impl", "(F)F", "equals", "", "other", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(F)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LineHeightStyle.kt */
    public static final class Alignment {
        /* access modifiers changed from: private */
        public static final float Bottom = m5815constructorimpl(1.0f);
        /* access modifiers changed from: private */
        public static final float Center = m5815constructorimpl(0.5f);
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final float Proportional = m5815constructorimpl(-1.0f);
        /* access modifiers changed from: private */
        public static final float Top = m5815constructorimpl(0.0f);
        private final float topRatio;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Alignment m5814boximpl(float f) {
            return new Alignment(f);
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m5816equalsimpl(float f, Object obj) {
            return (obj instanceof Alignment) && Float.compare(f, ((Alignment) obj).m5820unboximpl()) == 0;
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m5817equalsimpl0(float f, float f2) {
            return Float.compare(f, f2) == 0;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m5818hashCodeimpl(float f) {
            return Float.hashCode(f);
        }

        public boolean equals(Object obj) {
            return m5816equalsimpl(this.topRatio, obj);
        }

        public int hashCode() {
            return m5818hashCodeimpl(this.topRatio);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ float m5820unboximpl() {
            return this.topRatio;
        }

        private /* synthetic */ Alignment(float topRatio2) {
            this.topRatio = topRatio2;
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static float m5815constructorimpl(float topRatio2) {
            boolean z = true;
            if (!(0.0f <= topRatio2 && topRatio2 <= 1.0f)) {
                if (!(topRatio2 == -1.0f)) {
                    z = false;
                }
            }
            if (z) {
                return topRatio2;
            }
            throw new IllegalStateException("topRatio should be in [0..1] range or -1".toString());
        }

        public String toString() {
            return m5819toStringimpl(this.topRatio);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m5819toStringimpl(float arg0) {
            boolean z = true;
            if (arg0 == Top) {
                return "LineHeightStyle.Alignment.Top";
            }
            if (arg0 == Center) {
                return "LineHeightStyle.Alignment.Center";
            }
            if (arg0 == Proportional) {
                return "LineHeightStyle.Alignment.Proportional";
            }
            if (arg0 != Bottom) {
                z = false;
            }
            if (z) {
                return "LineHeightStyle.Alignment.Bottom";
            }
            return "LineHeightStyle.Alignment(topPercentage = " + arg0 + ')';
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R\"\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007R\"\u0010\u000f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineHeightStyle$Alignment$Companion;", "", "()V", "Bottom", "Landroidx/compose/ui/text/style/LineHeightStyle$Alignment;", "getBottom-PIaL0Z0$annotations", "getBottom-PIaL0Z0", "()F", "F", "Center", "getCenter-PIaL0Z0$annotations", "getCenter-PIaL0Z0", "Proportional", "getProportional-PIaL0Z0$annotations", "getProportional-PIaL0Z0", "Top", "getTop-PIaL0Z0$annotations", "getTop-PIaL0Z0", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: LineHeightStyle.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getBottom-PIaL0Z0$annotations  reason: not valid java name */
            public static /* synthetic */ void m5821getBottomPIaL0Z0$annotations() {
            }

            /* renamed from: getCenter-PIaL0Z0$annotations  reason: not valid java name */
            public static /* synthetic */ void m5822getCenterPIaL0Z0$annotations() {
            }

            /* renamed from: getProportional-PIaL0Z0$annotations  reason: not valid java name */
            public static /* synthetic */ void m5823getProportionalPIaL0Z0$annotations() {
            }

            /* renamed from: getTop-PIaL0Z0$annotations  reason: not valid java name */
            public static /* synthetic */ void m5824getTopPIaL0Z0$annotations() {
            }

            private Companion() {
            }

            /* renamed from: getTop-PIaL0Z0  reason: not valid java name */
            public final float m5828getTopPIaL0Z0() {
                return Alignment.Top;
            }

            /* renamed from: getCenter-PIaL0Z0  reason: not valid java name */
            public final float m5826getCenterPIaL0Z0() {
                return Alignment.Center;
            }

            /* renamed from: getProportional-PIaL0Z0  reason: not valid java name */
            public final float m5827getProportionalPIaL0Z0() {
                return Alignment.Proportional;
            }

            /* renamed from: getBottom-PIaL0Z0  reason: not valid java name */
            public final float m5825getBottomPIaL0Z0() {
                return Alignment.Bottom;
            }
        }
    }
}
