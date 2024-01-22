package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/graphics/BlendMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: BlendMode.kt */
public final class BlendMode {
    /* access modifiers changed from: private */
    public static final int Clear = m3064constructorimpl(0);
    /* access modifiers changed from: private */
    public static final int Color = m3064constructorimpl(27);
    /* access modifiers changed from: private */
    public static final int ColorBurn = m3064constructorimpl(19);
    /* access modifiers changed from: private */
    public static final int ColorDodge = m3064constructorimpl(18);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int Darken = m3064constructorimpl(16);
    /* access modifiers changed from: private */
    public static final int Difference = m3064constructorimpl(22);
    /* access modifiers changed from: private */
    public static final int Dst = m3064constructorimpl(2);
    /* access modifiers changed from: private */
    public static final int DstAtop = m3064constructorimpl(10);
    /* access modifiers changed from: private */
    public static final int DstIn = m3064constructorimpl(6);
    /* access modifiers changed from: private */
    public static final int DstOut = m3064constructorimpl(8);
    /* access modifiers changed from: private */
    public static final int DstOver = m3064constructorimpl(4);
    /* access modifiers changed from: private */
    public static final int Exclusion = m3064constructorimpl(23);
    /* access modifiers changed from: private */
    public static final int Hardlight = m3064constructorimpl(20);
    /* access modifiers changed from: private */
    public static final int Hue = m3064constructorimpl(25);
    /* access modifiers changed from: private */
    public static final int Lighten = m3064constructorimpl(17);
    /* access modifiers changed from: private */
    public static final int Luminosity = m3064constructorimpl(28);
    /* access modifiers changed from: private */
    public static final int Modulate = m3064constructorimpl(13);
    /* access modifiers changed from: private */
    public static final int Multiply = m3064constructorimpl(24);
    /* access modifiers changed from: private */
    public static final int Overlay = m3064constructorimpl(15);
    /* access modifiers changed from: private */
    public static final int Plus = m3064constructorimpl(12);
    /* access modifiers changed from: private */
    public static final int Saturation = m3064constructorimpl(26);
    /* access modifiers changed from: private */
    public static final int Screen = m3064constructorimpl(14);
    /* access modifiers changed from: private */
    public static final int Softlight = m3064constructorimpl(21);
    /* access modifiers changed from: private */
    public static final int Src = m3064constructorimpl(1);
    /* access modifiers changed from: private */
    public static final int SrcAtop = m3064constructorimpl(9);
    /* access modifiers changed from: private */
    public static final int SrcIn = m3064constructorimpl(5);
    /* access modifiers changed from: private */
    public static final int SrcOut = m3064constructorimpl(7);
    /* access modifiers changed from: private */
    public static final int SrcOver = m3064constructorimpl(3);
    /* access modifiers changed from: private */
    public static final int Xor = m3064constructorimpl(11);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ BlendMode m3063boximpl(int i) {
        return new BlendMode(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m3064constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3065equalsimpl(int i, Object obj) {
        return (obj instanceof BlendMode) && i == ((BlendMode) obj).m3069unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3066equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3067hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m3065equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3067hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m3069unboximpl() {
        return this.value;
    }

    private /* synthetic */ BlendMode(int value2) {
        this.value = value2;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b<\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b#\u0010\u0006R\u001c\u0010$\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b%\u0010\u0006R\u001c\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b'\u0010\u0006R\u001c\u0010(\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b)\u0010\u0006R\u001c\u0010*\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b+\u0010\u0006R\u001c\u0010,\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b-\u0010\u0006R\u001c\u0010.\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b/\u0010\u0006R\u001c\u00100\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b1\u0010\u0006R\u001c\u00102\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b3\u0010\u0006R\u001c\u00104\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b5\u0010\u0006R\u001c\u00106\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b7\u0010\u0006R\u001c\u00108\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b9\u0010\u0006R\u001c\u0010:\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b;\u0010\u0006R\u001c\u0010<\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b=\u0010\u0006R\u001c\u0010>\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b?\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006@"}, d2 = {"Landroidx/compose/ui/graphics/BlendMode$Companion;", "", "()V", "Clear", "Landroidx/compose/ui/graphics/BlendMode;", "getClear-0nO6VwU", "()I", "I", "Color", "getColor-0nO6VwU", "ColorBurn", "getColorBurn-0nO6VwU", "ColorDodge", "getColorDodge-0nO6VwU", "Darken", "getDarken-0nO6VwU", "Difference", "getDifference-0nO6VwU", "Dst", "getDst-0nO6VwU", "DstAtop", "getDstAtop-0nO6VwU", "DstIn", "getDstIn-0nO6VwU", "DstOut", "getDstOut-0nO6VwU", "DstOver", "getDstOver-0nO6VwU", "Exclusion", "getExclusion-0nO6VwU", "Hardlight", "getHardlight-0nO6VwU", "Hue", "getHue-0nO6VwU", "Lighten", "getLighten-0nO6VwU", "Luminosity", "getLuminosity-0nO6VwU", "Modulate", "getModulate-0nO6VwU", "Multiply", "getMultiply-0nO6VwU", "Overlay", "getOverlay-0nO6VwU", "Plus", "getPlus-0nO6VwU", "Saturation", "getSaturation-0nO6VwU", "Screen", "getScreen-0nO6VwU", "Softlight", "getSoftlight-0nO6VwU", "Src", "getSrc-0nO6VwU", "SrcAtop", "getSrcAtop-0nO6VwU", "SrcIn", "getSrcIn-0nO6VwU", "SrcOut", "getSrcOut-0nO6VwU", "SrcOver", "getSrcOver-0nO6VwU", "Xor", "getXor-0nO6VwU", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BlendMode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getClear-0nO6VwU  reason: not valid java name */
        public final int m3070getClear0nO6VwU() {
            return BlendMode.Clear;
        }

        /* renamed from: getSrc-0nO6VwU  reason: not valid java name */
        public final int m3093getSrc0nO6VwU() {
            return BlendMode.Src;
        }

        /* renamed from: getDst-0nO6VwU  reason: not valid java name */
        public final int m3076getDst0nO6VwU() {
            return BlendMode.Dst;
        }

        /* renamed from: getSrcOver-0nO6VwU  reason: not valid java name */
        public final int m3097getSrcOver0nO6VwU() {
            return BlendMode.SrcOver;
        }

        /* renamed from: getDstOver-0nO6VwU  reason: not valid java name */
        public final int m3080getDstOver0nO6VwU() {
            return BlendMode.DstOver;
        }

        /* renamed from: getSrcIn-0nO6VwU  reason: not valid java name */
        public final int m3095getSrcIn0nO6VwU() {
            return BlendMode.SrcIn;
        }

        /* renamed from: getDstIn-0nO6VwU  reason: not valid java name */
        public final int m3078getDstIn0nO6VwU() {
            return BlendMode.DstIn;
        }

        /* renamed from: getSrcOut-0nO6VwU  reason: not valid java name */
        public final int m3096getSrcOut0nO6VwU() {
            return BlendMode.SrcOut;
        }

        /* renamed from: getDstOut-0nO6VwU  reason: not valid java name */
        public final int m3079getDstOut0nO6VwU() {
            return BlendMode.DstOut;
        }

        /* renamed from: getSrcAtop-0nO6VwU  reason: not valid java name */
        public final int m3094getSrcAtop0nO6VwU() {
            return BlendMode.SrcAtop;
        }

        /* renamed from: getDstAtop-0nO6VwU  reason: not valid java name */
        public final int m3077getDstAtop0nO6VwU() {
            return BlendMode.DstAtop;
        }

        /* renamed from: getXor-0nO6VwU  reason: not valid java name */
        public final int m3098getXor0nO6VwU() {
            return BlendMode.Xor;
        }

        /* renamed from: getPlus-0nO6VwU  reason: not valid java name */
        public final int m3089getPlus0nO6VwU() {
            return BlendMode.Plus;
        }

        /* renamed from: getModulate-0nO6VwU  reason: not valid java name */
        public final int m3086getModulate0nO6VwU() {
            return BlendMode.Modulate;
        }

        /* renamed from: getScreen-0nO6VwU  reason: not valid java name */
        public final int m3091getScreen0nO6VwU() {
            return BlendMode.Screen;
        }

        /* renamed from: getOverlay-0nO6VwU  reason: not valid java name */
        public final int m3088getOverlay0nO6VwU() {
            return BlendMode.Overlay;
        }

        /* renamed from: getDarken-0nO6VwU  reason: not valid java name */
        public final int m3074getDarken0nO6VwU() {
            return BlendMode.Darken;
        }

        /* renamed from: getLighten-0nO6VwU  reason: not valid java name */
        public final int m3084getLighten0nO6VwU() {
            return BlendMode.Lighten;
        }

        /* renamed from: getColorDodge-0nO6VwU  reason: not valid java name */
        public final int m3073getColorDodge0nO6VwU() {
            return BlendMode.ColorDodge;
        }

        /* renamed from: getColorBurn-0nO6VwU  reason: not valid java name */
        public final int m3072getColorBurn0nO6VwU() {
            return BlendMode.ColorBurn;
        }

        /* renamed from: getHardlight-0nO6VwU  reason: not valid java name */
        public final int m3082getHardlight0nO6VwU() {
            return BlendMode.Hardlight;
        }

        /* renamed from: getSoftlight-0nO6VwU  reason: not valid java name */
        public final int m3092getSoftlight0nO6VwU() {
            return BlendMode.Softlight;
        }

        /* renamed from: getDifference-0nO6VwU  reason: not valid java name */
        public final int m3075getDifference0nO6VwU() {
            return BlendMode.Difference;
        }

        /* renamed from: getExclusion-0nO6VwU  reason: not valid java name */
        public final int m3081getExclusion0nO6VwU() {
            return BlendMode.Exclusion;
        }

        /* renamed from: getMultiply-0nO6VwU  reason: not valid java name */
        public final int m3087getMultiply0nO6VwU() {
            return BlendMode.Multiply;
        }

        /* renamed from: getHue-0nO6VwU  reason: not valid java name */
        public final int m3083getHue0nO6VwU() {
            return BlendMode.Hue;
        }

        /* renamed from: getSaturation-0nO6VwU  reason: not valid java name */
        public final int m3090getSaturation0nO6VwU() {
            return BlendMode.Saturation;
        }

        /* renamed from: getColor-0nO6VwU  reason: not valid java name */
        public final int m3071getColor0nO6VwU() {
            return BlendMode.Color;
        }

        /* renamed from: getLuminosity-0nO6VwU  reason: not valid java name */
        public final int m3085getLuminosity0nO6VwU() {
            return BlendMode.Luminosity;
        }
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3068toStringimpl(int arg0) {
        if (m3066equalsimpl0(arg0, Clear)) {
            return "Clear";
        }
        if (m3066equalsimpl0(arg0, Src)) {
            return "Src";
        }
        if (m3066equalsimpl0(arg0, Dst)) {
            return "Dst";
        }
        if (m3066equalsimpl0(arg0, SrcOver)) {
            return "SrcOver";
        }
        if (m3066equalsimpl0(arg0, DstOver)) {
            return "DstOver";
        }
        if (m3066equalsimpl0(arg0, SrcIn)) {
            return "SrcIn";
        }
        if (m3066equalsimpl0(arg0, DstIn)) {
            return "DstIn";
        }
        if (m3066equalsimpl0(arg0, SrcOut)) {
            return "SrcOut";
        }
        if (m3066equalsimpl0(arg0, DstOut)) {
            return "DstOut";
        }
        if (m3066equalsimpl0(arg0, SrcAtop)) {
            return "SrcAtop";
        }
        if (m3066equalsimpl0(arg0, DstAtop)) {
            return "DstAtop";
        }
        if (m3066equalsimpl0(arg0, Xor)) {
            return "Xor";
        }
        if (m3066equalsimpl0(arg0, Plus)) {
            return "Plus";
        }
        if (m3066equalsimpl0(arg0, Modulate)) {
            return "Modulate";
        }
        if (m3066equalsimpl0(arg0, Screen)) {
            return "Screen";
        }
        if (m3066equalsimpl0(arg0, Overlay)) {
            return "Overlay";
        }
        if (m3066equalsimpl0(arg0, Darken)) {
            return "Darken";
        }
        if (m3066equalsimpl0(arg0, Lighten)) {
            return "Lighten";
        }
        if (m3066equalsimpl0(arg0, ColorDodge)) {
            return "ColorDodge";
        }
        if (m3066equalsimpl0(arg0, ColorBurn)) {
            return "ColorBurn";
        }
        if (m3066equalsimpl0(arg0, Hardlight)) {
            return "HardLight";
        }
        if (m3066equalsimpl0(arg0, Softlight)) {
            return "Softlight";
        }
        if (m3066equalsimpl0(arg0, Difference)) {
            return "Difference";
        }
        if (m3066equalsimpl0(arg0, Exclusion)) {
            return "Exclusion";
        }
        if (m3066equalsimpl0(arg0, Multiply)) {
            return "Multiply";
        }
        if (m3066equalsimpl0(arg0, Hue)) {
            return "Hue";
        }
        if (m3066equalsimpl0(arg0, Saturation)) {
            return "Saturation";
        }
        if (m3066equalsimpl0(arg0, Color)) {
            return "Color";
        }
        if (m3066equalsimpl0(arg0, Luminosity)) {
            return "Luminosity";
        }
        return "Unknown";
    }

    public String toString() {
        return m3068toStringimpl(this.value);
    }
}
