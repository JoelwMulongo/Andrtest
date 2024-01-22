package androidx.compose.ui.graphics;

import androidx.core.internal.view.SupportMenu;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.Regex;

@JvmInline
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\b@\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001RB\u0014\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005B\u0014\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0007B\u0012\u0012\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\nJ\u0016\u0010\u0015\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\nJ\u0016\u0010\u0017\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\nJ\u001e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0000H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b \u0010!J\u0016\u0010\"\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010\nJ\u0010\u0010$\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b%\u0010\u000eJ\r\u0010&\u001a\u00020\u001e¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u001e¢\u0006\u0004\b*\u0010(J\r\u0010+\u001a\u00020\u001e¢\u0006\u0004\b,\u0010(J\r\u0010-\u001a\u00020\u001e¢\u0006\u0004\b.\u0010(J\u0016\u0010/\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010\nJ\r\u00101\u001a\u00020\f¢\u0006\u0004\b2\u0010\u000eJ\r\u00103\u001a\u000204¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u0006¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\u0003¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020>¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\f¢\u0006\u0004\bB\u0010\u000eJ\r\u0010C\u001a\u00020D¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020\f¢\u0006\u0004\bH\u0010\u000eJ\r\u0010I\u001a\u00020\t¢\u0006\u0004\bJ\u0010\nJ\u000f\u0010K\u001a\u00020>H\u0016¢\u0006\u0004\bL\u0010@J\u0016\u0010M\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010\nJ\u001b\u0010O\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e\u0001\bø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006S"}, d2 = {"Landroidx/compose/ui/graphics/Float16;", "", "value", "", "constructor-impl", "(F)S", "", "(D)S", "halfValue", "", "(S)S", "exponent", "", "getExponent-impl", "(S)I", "getHalfValue", "()S", "sign", "getSign-slo4al4", "significand", "getSignificand-impl", "absoluteValue", "absoluteValue-slo4al4", "ceil", "ceil-slo4al4", "compareTo", "other", "compareTo-41bOqos", "(SS)I", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floor", "floor-slo4al4", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(S)Z", "isInfinite", "isInfinite-impl", "isNaN", "isNaN-impl", "isNormalized", "isNormalized-impl", "round", "round-slo4al4", "toBits", "toBits-impl", "toByte", "", "toByte-impl", "(S)B", "toDouble", "toDouble-impl", "(S)D", "toFloat", "toFloat-impl", "(S)F", "toHexString", "", "toHexString-impl", "(S)Ljava/lang/String;", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toRawBits", "toRawBits-impl", "toShort", "toShort-impl", "toString", "toString-impl", "trunc", "trunc-slo4al4", "withSign", "withSign-qCeQghg", "(SS)S", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Float16.kt */
public final class Float16 implements Comparable<Float16> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final short Epsilon = m3268constructorimpl(5120);
    private static final int FP16_COMBINED = 32767;
    private static final int FP16_EXPONENT_BIAS = 15;
    private static final int FP16_EXPONENT_MASK = 31;
    private static final int FP16_EXPONENT_MAX = 31744;
    private static final int FP16_EXPONENT_SHIFT = 10;
    private static final int FP16_SIGNIFICAND_MASK = 1023;
    private static final int FP16_SIGN_MASK = 32768;
    private static final int FP16_SIGN_SHIFT = 15;
    private static final float FP32_DENORMAL_FLOAT = Float.intBitsToFloat(FP32_DENORMAL_MAGIC);
    private static final int FP32_DENORMAL_MAGIC = 1056964608;
    private static final int FP32_EXPONENT_BIAS = 127;
    private static final int FP32_EXPONENT_MASK = 255;
    private static final int FP32_EXPONENT_SHIFT = 23;
    private static final int FP32_QNAN_MASK = 4194304;
    private static final int FP32_SIGNIFICAND_MASK = 8388607;
    private static final int FP32_SIGN_SHIFT = 31;
    /* access modifiers changed from: private */
    public static final short LowestValue = m3268constructorimpl(-1025);
    public static final int MaxExponent = 15;
    /* access modifiers changed from: private */
    public static final short MaxValue = m3268constructorimpl(31743);
    public static final int MinExponent = -14;
    /* access modifiers changed from: private */
    public static final short MinNormal = m3268constructorimpl(1024);
    /* access modifiers changed from: private */
    public static final short MinValue = m3268constructorimpl(1);
    /* access modifiers changed from: private */
    public static final short NaN = m3268constructorimpl(32256);
    /* access modifiers changed from: private */
    public static final short NegativeInfinity = m3268constructorimpl(-1024);
    private static final short NegativeOne = m3267constructorimpl(-1.0f);
    /* access modifiers changed from: private */
    public static final short NegativeZero = m3268constructorimpl((short) ShortCompanionObject.MIN_VALUE);
    private static final short One = m3267constructorimpl(1.0f);
    /* access modifiers changed from: private */
    public static final short PositiveInfinity = m3268constructorimpl(31744);
    /* access modifiers changed from: private */
    public static final short PositiveZero = m3268constructorimpl(0);
    public static final int Size = 16;
    private final short halfValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Float16 m3263boximpl(short s) {
        return new Float16(s);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m3268constructorimpl(short s) {
        return s;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3269equalsimpl(short s, Object obj) {
        return (obj instanceof Float16) && s == ((Float16) obj).m3294unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3270equalsimpl0(short s, short s2) {
        return s == s2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3275hashCodeimpl(short s) {
        return Short.hashCode(s);
    }

    public boolean equals(Object obj) {
        return m3269equalsimpl(this.halfValue, obj);
    }

    public int hashCode() {
        return m3275hashCodeimpl(this.halfValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ short m3294unboximpl() {
        return this.halfValue;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object other) {
        return m3293compareTo41bOqos(((Float16) other).m3294unboximpl());
    }

    private /* synthetic */ Float16(short halfValue2) {
        this.halfValue = halfValue2;
    }

    public final short getHalfValue() {
        return this.halfValue;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m3267constructorimpl(float value) {
        return m3268constructorimpl(Companion.floatToHalf(value));
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m3266constructorimpl(double value) {
        return m3267constructorimpl((float) value);
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    public static final byte m3282toByteimpl(short arg0) {
        return (byte) ((int) m3284toFloatimpl(arg0));
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    public static final short m3289toShortimpl(short arg0) {
        return (short) ((int) m3284toFloatimpl(arg0));
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m3286toIntimpl(short arg0) {
        return (int) m3284toFloatimpl(arg0);
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m3287toLongimpl(short arg0) {
        return (long) m3284toFloatimpl(arg0);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    public static final float m3284toFloatimpl(short arg0) {
        int bits = 65535 & arg0;
        int s = 32768 & bits;
        int e = (bits >>> 10) & 31;
        int m = bits & FP16_SIGNIFICAND_MASK;
        int outE = 0;
        int outM = 0;
        if (e != 0) {
            outM = m << 13;
            if (e == 31) {
                outE = 255;
                if (outM != 0) {
                    outM |= 4194304;
                }
            } else {
                outE = (e - 15) + 127;
            }
        } else if (m != 0) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            float o = Float.intBitsToFloat(FP32_DENORMAL_MAGIC + m) - FP32_DENORMAL_FLOAT;
            return s == 0 ? o : -o;
        }
        FloatCompanionObject floatCompanionObject2 = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((s << 16) | (outE << 23) | outM);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m3283toDoubleimpl(short arg0) {
        return (double) m3284toFloatimpl(arg0);
    }

    /* renamed from: toBits-impl  reason: not valid java name */
    public static final int m3281toBitsimpl(short arg0) {
        if (m3278isNaNimpl(arg0)) {
            return NaN;
        }
        return 65535 & arg0;
    }

    /* renamed from: toRawBits-impl  reason: not valid java name */
    public static final int m3288toRawBitsimpl(short arg0) {
        return 65535 & arg0;
    }

    public String toString() {
        return m3290toStringimpl(this.halfValue);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3290toStringimpl(short arg0) {
        return String.valueOf(m3284toFloatimpl(arg0));
    }

    /* renamed from: compareTo-41bOqos  reason: not valid java name */
    public int m3293compareTo41bOqos(short other) {
        return m3265compareTo41bOqos(this.halfValue, other);
    }

    /* renamed from: compareTo-41bOqos  reason: not valid java name */
    public static int m3265compareTo41bOqos(short arg0, short other) {
        if (m3278isNaNimpl(arg0)) {
            return m3278isNaNimpl(other) ^ true ? 1 : 0;
        }
        if (m3278isNaNimpl(other)) {
            return -1;
        }
        Companion companion = Companion;
        return Intrinsics.compare(companion.toCompareValue(arg0), companion.toCompareValue(other));
    }

    /* renamed from: getSign-slo4al4  reason: not valid java name */
    public static final short m3273getSignslo4al4(short arg0) {
        if (m3278isNaNimpl(arg0)) {
            return NaN;
        }
        if (m3265compareTo41bOqos(arg0, NegativeZero) < 0) {
            return NegativeOne;
        }
        if (m3265compareTo41bOqos(arg0, PositiveZero) > 0) {
            return One;
        }
        return arg0;
    }

    /* renamed from: withSign-qCeQghg  reason: not valid java name */
    public static final short m3292withSignqCeQghg(short arg0, short sign) {
        return m3268constructorimpl((short) ((32768 & sign) | (arg0 & ShortCompanionObject.MAX_VALUE)));
    }

    /* renamed from: absoluteValue-slo4al4  reason: not valid java name */
    public static final short m3262absoluteValueslo4al4(short arg0) {
        return m3268constructorimpl((short) (arg0 & ShortCompanionObject.MAX_VALUE));
    }

    /* renamed from: round-slo4al4  reason: not valid java name */
    public static final short m3280roundslo4al4(short arg0) {
        int i = SupportMenu.USER_MASK;
        int bits = arg0 & SupportMenu.USER_MASK;
        int e = bits & FP16_COMBINED;
        int result = bits;
        if (e < 15360) {
            int result2 = result & 32768;
            if (e < 14336) {
                i = 0;
            }
            result = result2 | (i & 15360);
        } else if (e < 25600) {
            int e2 = 25 - (e >> 10);
            result = (result + (1 << (e2 - 1))) & (~((1 << e2) - 1));
        }
        return m3268constructorimpl((short) result);
    }

    /* renamed from: ceil-slo4al4  reason: not valid java name */
    public static final short m3264ceilslo4al4(short arg0) {
        int bits = 65535 & arg0;
        int e = bits & FP16_COMBINED;
        int result = bits;
        int i = 1;
        if (e < 15360) {
            int result2 = result & 32768;
            int i2 = ~(bits >> 15);
            if (e == 0) {
                i = 0;
            }
            result = result2 | ((-(i & i2)) & 15360);
        } else if (e < 25600) {
            int mask = (1 << (25 - (e >> 10))) - 1;
            result = (result + (mask & ((bits >> 15) - 1))) & (~mask);
        }
        return m3268constructorimpl((short) result);
    }

    /* renamed from: floor-slo4al4  reason: not valid java name */
    public static final short m3271floorslo4al4(short arg0) {
        int i = SupportMenu.USER_MASK;
        int bits = arg0 & SupportMenu.USER_MASK;
        int e = bits & FP16_COMBINED;
        int result = bits;
        if (e < 15360) {
            int result2 = result & 32768;
            if (bits <= 32768) {
                i = 0;
            }
            result = result2 | (i & 15360);
        } else if (e < 25600) {
            int mask = (1 << (25 - (e >> 10))) - 1;
            result = (result + ((-(bits >> 15)) & mask)) & (~mask);
        }
        return m3268constructorimpl((short) result);
    }

    /* renamed from: trunc-slo4al4  reason: not valid java name */
    public static final short m3291truncslo4al4(short arg0) {
        int bits = 65535 & arg0;
        int e = bits & FP16_COMBINED;
        int result = bits;
        if (e < 15360) {
            result &= 32768;
        } else if (e < 25600) {
            result &= ~((1 << (25 - (e >> 10))) - 1);
        }
        return m3268constructorimpl((short) result);
    }

    /* renamed from: getExponent-impl  reason: not valid java name */
    public static final int m3272getExponentimpl(short arg0) {
        return ((arg0 >>> 10) & 31) - 15;
    }

    /* renamed from: getSignificand-impl  reason: not valid java name */
    public static final int m3274getSignificandimpl(short arg0) {
        return arg0 & 1023;
    }

    /* renamed from: isNaN-impl  reason: not valid java name */
    public static final boolean m3278isNaNimpl(short arg0) {
        return (arg0 & ShortCompanionObject.MAX_VALUE) > FP16_EXPONENT_MAX;
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m3277isInfiniteimpl(short arg0) {
        return (arg0 & ShortCompanionObject.MAX_VALUE) == FP16_EXPONENT_MAX;
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m3276isFiniteimpl(short arg0) {
        return (arg0 & ShortCompanionObject.MAX_VALUE) != FP16_EXPONENT_MAX;
    }

    /* renamed from: isNormalized-impl  reason: not valid java name */
    public static final boolean m3279isNormalizedimpl(short arg0) {
        return ((arg0 & 31744) == 0 || (arg0 & 31744) == FP16_EXPONENT_MAX) ? false : true;
    }

    /* renamed from: toHexString-impl  reason: not valid java name */
    public static final String m3285toHexStringimpl(short arg0) {
        StringBuilder o = new StringBuilder();
        int bits = 65535 & arg0;
        int s = bits >>> 15;
        int e = (bits >>> 10) & 31;
        int m = bits & FP16_SIGNIFICAND_MASK;
        if (e != 31) {
            if (s == 1) {
                o.append('-');
            }
            if (e != 0) {
                o.append("0x1.");
                String significand = Integer.toString(m, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(significand, "toString(this, checkRadix(radix))");
                o.append(new Regex("0{2,}$").replaceFirst(significand, ""));
                o.append('p');
                o.append(String.valueOf(e - 15));
            } else if (m == 0) {
                o.append("0x0.0p0");
            } else {
                o.append("0x0.");
                String significand2 = Integer.toString(m, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(significand2, "toString(this, checkRadix(radix))");
                o.append(new Regex("0{2,}$").replaceFirst(significand2, ""));
                o.append("p-14");
            }
        } else if (m == 0) {
            if (s != 0) {
                o.append('-');
            }
            o.append("Infinity");
        } else {
            o.append("NaN");
        }
        String sb = o.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "o.toString()");
        return sb;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0010\n\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0012H\u0002J\u0010\u00104\u001a\u00020\t2\u0006\u00105\u001a\u000202H\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u000e\u0010\u001c\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001e\u0010\u0006R\u000e\u0010\u001f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b#\u0010\u0006R\u001c\u0010$\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b%\u0010\u0006R\u001c\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b'\u0010\u0006R\u0019\u0010(\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0007R\u001c\u0010)\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b*\u0010\u0006R\u0019\u0010+\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0007R\u001c\u0010,\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b-\u0010\u0006R\u001c\u0010.\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b/\u0010\u0006R\u000e\u00100\u001a\u00020\tXT¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, d2 = {"Landroidx/compose/ui/graphics/Float16$Companion;", "", "()V", "Epsilon", "Landroidx/compose/ui/graphics/Float16;", "getEpsilon-slo4al4", "()S", "S", "FP16_COMBINED", "", "FP16_EXPONENT_BIAS", "FP16_EXPONENT_MASK", "FP16_EXPONENT_MAX", "FP16_EXPONENT_SHIFT", "FP16_SIGNIFICAND_MASK", "FP16_SIGN_MASK", "FP16_SIGN_SHIFT", "FP32_DENORMAL_FLOAT", "", "FP32_DENORMAL_MAGIC", "FP32_EXPONENT_BIAS", "FP32_EXPONENT_MASK", "FP32_EXPONENT_SHIFT", "FP32_QNAN_MASK", "FP32_SIGNIFICAND_MASK", "FP32_SIGN_SHIFT", "LowestValue", "getLowestValue-slo4al4", "MaxExponent", "MaxValue", "getMaxValue-slo4al4", "MinExponent", "MinNormal", "getMinNormal-slo4al4", "MinValue", "getMinValue-slo4al4", "NaN", "getNaN-slo4al4", "NegativeInfinity", "getNegativeInfinity-slo4al4", "NegativeOne", "NegativeZero", "getNegativeZero-slo4al4", "One", "PositiveInfinity", "getPositiveInfinity-slo4al4", "PositiveZero", "getPositiveZero-slo4al4", "Size", "floatToHalf", "", "f", "toCompareValue", "value", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Float16.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getEpsilon-slo4al4  reason: not valid java name */
        public final short m3295getEpsilonslo4al4() {
            return Float16.Epsilon;
        }

        /* renamed from: getLowestValue-slo4al4  reason: not valid java name */
        public final short m3296getLowestValueslo4al4() {
            return Float16.LowestValue;
        }

        /* renamed from: getMaxValue-slo4al4  reason: not valid java name */
        public final short m3297getMaxValueslo4al4() {
            return Float16.MaxValue;
        }

        /* renamed from: getMinNormal-slo4al4  reason: not valid java name */
        public final short m3298getMinNormalslo4al4() {
            return Float16.MinNormal;
        }

        /* renamed from: getMinValue-slo4al4  reason: not valid java name */
        public final short m3299getMinValueslo4al4() {
            return Float16.MinValue;
        }

        /* renamed from: getNaN-slo4al4  reason: not valid java name */
        public final short m3300getNaNslo4al4() {
            return Float16.NaN;
        }

        /* renamed from: getNegativeInfinity-slo4al4  reason: not valid java name */
        public final short m3301getNegativeInfinityslo4al4() {
            return Float16.NegativeInfinity;
        }

        /* renamed from: getNegativeZero-slo4al4  reason: not valid java name */
        public final short m3302getNegativeZeroslo4al4() {
            return Float16.NegativeZero;
        }

        /* renamed from: getPositiveInfinity-slo4al4  reason: not valid java name */
        public final short m3303getPositiveInfinityslo4al4() {
            return Float16.PositiveInfinity;
        }

        /* renamed from: getPositiveZero-slo4al4  reason: not valid java name */
        public final short m3304getPositiveZeroslo4al4() {
            return Float16.PositiveZero;
        }

        /* access modifiers changed from: private */
        public final int toCompareValue(short value) {
            if ((value & ShortCompanionObject.MIN_VALUE) != 0) {
                return 32768 - (value & UShort.MAX_VALUE);
            }
            return value & UShort.MAX_VALUE;
        }

        /* access modifiers changed from: private */
        public final short floatToHalf(float f) {
            int bits = Float.floatToRawIntBits(f);
            int s = bits >>> 31;
            int e = (bits >>> 23) & 255;
            int m = Float16.FP32_SIGNIFICAND_MASK & bits;
            int outE = 0;
            int outM = 0;
            if (e == 255) {
                outE = 31;
                outM = m != 0 ? 512 : 0;
            } else {
                int e2 = (e - 127) + 15;
                if (e2 >= 31) {
                    outE = 49;
                } else if (e2 > 0) {
                    outE = e2;
                    outM = m >> 13;
                    if ((m & 4096) != 0) {
                        return (short) ((s << 15) | (((outE << 10) | outM) + 1));
                    }
                } else if (e2 >= -10) {
                    int m2 = (8388608 | m) >> (1 - e2);
                    if ((m2 & 4096) != 0) {
                        m2 += 8192;
                    }
                    outM = m2 >> 13;
                }
            }
            return (short) ((s << 15) | (outE << 10) | outM);
        }
    }

    static {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
    }
}
