package androidx.compose.ui.unit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

@JvmInline
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 %2\u00020\u0001:\u0001%B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010!\u001a\u00020\"H\u0017¢\u0006\u0004\b#\u0010$R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R#\u0010\b\u001a\u00020\t8FX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR#\u0010\r\u001a\u00020\t8FX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/ui/unit/DpOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "Landroidx/compose/ui/unit/Dp;", "getX-D9Ej5fM$annotations", "getX-D9Ej5fM", "(J)F", "y", "getY-D9Ej5fM$annotations", "getY-D9Ej5fM", "copy", "copy-tPigGR8", "(JFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-CB-Mgk4", "(JJ)J", "plus", "plus-CB-Mgk4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dp.kt */
public final class DpOffset {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Unspecified = DpKt.m6007DpOffsetYgX7TsA(Dp.Companion.m6006getUnspecifiedD9Ej5fM(), Dp.Companion.m6006getUnspecifiedD9Ej5fM());
    /* access modifiers changed from: private */
    public static final long Zero = DpKt.m6007DpOffsetYgX7TsA(Dp.m5986constructorimpl((float) 0), Dp.m5986constructorimpl((float) 0));
    private final long packedValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ DpOffset m6041boximpl(long j) {
        return new DpOffset(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m6042constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m6045equalsimpl(long j, Object obj) {
        return (obj instanceof DpOffset) && j == ((DpOffset) obj).m6055unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m6046equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getX-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m6048getXD9Ej5fM$annotations() {
    }

    /* renamed from: getY-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m6050getYD9Ej5fM$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m6051hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m6045equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m6051hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m6055unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ DpOffset(long packedValue2) {
        this.packedValue = packedValue2;
    }

    /* renamed from: getX-D9Ej5fM  reason: not valid java name */
    public static final float m6047getXD9Ej5fM(long arg0) {
        if (arg0 != Unspecified) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Dp.m5986constructorimpl(Float.intBitsToFloat((int) (arg0 >> 32)));
        }
        throw new IllegalStateException("DpOffset is unspecified".toString());
    }

    /* renamed from: getY-D9Ej5fM  reason: not valid java name */
    public static final float m6049getYD9Ej5fM(long arg0) {
        if (arg0 != Unspecified) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Dp.m5986constructorimpl(Float.intBitsToFloat((int) (4294967295L & arg0)));
        }
        throw new IllegalStateException("DpOffset is unspecified".toString());
    }

    /* renamed from: copy-tPigGR8  reason: not valid java name */
    public static final long m6043copytPigGR8(long arg0, float x, float y) {
        return DpKt.m6007DpOffsetYgX7TsA(x, y);
    }

    /* renamed from: copy-tPigGR8$default  reason: not valid java name */
    public static /* synthetic */ long m6044copytPigGR8$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m6047getXD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f2 = m6049getYD9Ej5fM(j);
        }
        return m6043copytPigGR8(j, f, f2);
    }

    /* renamed from: minus-CB-Mgk4  reason: not valid java name */
    public static final long m6052minusCBMgk4(long arg0, long other) {
        return DpKt.m6007DpOffsetYgX7TsA(Dp.m5986constructorimpl(m6047getXD9Ej5fM(arg0) - m6047getXD9Ej5fM(other)), Dp.m5986constructorimpl(m6049getYD9Ej5fM(arg0) - m6049getYD9Ej5fM(other)));
    }

    /* renamed from: plus-CB-Mgk4  reason: not valid java name */
    public static final long m6053plusCBMgk4(long arg0, long other) {
        return DpKt.m6007DpOffsetYgX7TsA(Dp.m5986constructorimpl(m6047getXD9Ej5fM(arg0) + m6047getXD9Ej5fM(other)), Dp.m5986constructorimpl(m6049getYD9Ej5fM(arg0) + m6049getYD9Ej5fM(other)));
    }

    public String toString() {
        return m6054toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m6054toStringimpl(long arg0) {
        if (arg0 != Companion.m6056getUnspecifiedRKDOV3M()) {
            return '(' + Dp.m5997toStringimpl(m6047getXD9Ej5fM(arg0)) + ", " + Dp.m5997toStringimpl(m6049getYD9Ej5fM(arg0)) + ')';
        }
        return "DpOffset.Unspecified";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/unit/DpOffset$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/unit/DpOffset;", "getUnspecified-RKDOV3M", "()J", "J", "Zero", "getZero-RKDOV3M", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Dp.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getZero-RKDOV3M  reason: not valid java name */
        public final long m6057getZeroRKDOV3M() {
            return DpOffset.Zero;
        }

        /* renamed from: getUnspecified-RKDOV3M  reason: not valid java name */
        public final long m6056getUnspecifiedRKDOV3M() {
            return DpOffset.Unspecified;
        }
    }
}
