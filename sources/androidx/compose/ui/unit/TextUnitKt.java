package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\u001a#\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001d\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010\u0015\u001a%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a-\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a-\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u00020\fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a \u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\fH\u0001ø\u0001\u0000¢\u0006\u0002\u00107\u001a+\u00108\u001a\u00020\u0006*\u00020\u00062\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060:H\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a\"\u0010=\u001a\u00020\u0006*\u00020\u00072\u0006\u0010>\u001a\u00020\u0006H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a\"\u0010=\u001a\u00020\u0006*\u00020\f2\u0006\u0010>\u001a\u00020\u0006H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010#\u001a\"\u0010=\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010>\u001a\u00020\u0006H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010A\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"!\u0010\u0005\u001a\u00020\u0006*\u00020\u00078FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"!\u0010\u0005\u001a\u00020\u0006*\u00020\f8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\r\u001a\u0004\b\n\u0010\u000e\"!\u0010\u0005\u001a\u00020\u0006*\u00020\u000f8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\u0010\u001a\u0004\b\n\u0010\u0011\"\"\u0010\u0012\u001a\u00020\u0013*\u00020\u00068Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"!\u0010\u0018\u001a\u00020\u0013*\u00020\u00068FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017\"!\u0010\u001b\u001a\u00020\u0006*\u00020\u00078FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000b\"!\u0010\u001b\u001a\u00020\u0006*\u00020\f8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000e\"!\u0010\u001b\u001a\u00020\u0006*\u00020\u000f8FX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0011\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006B"}, d2 = {"UNIT_MASK", "", "UNIT_TYPE_EM", "UNIT_TYPE_SP", "UNIT_TYPE_UNSPECIFIED", "em", "Landroidx/compose/ui/unit/TextUnit;", "", "getEm$annotations", "(D)V", "getEm", "(D)J", "", "(F)V", "(F)J", "", "(I)V", "(I)J", "isSpecified", "", "isSpecified--R2X_6o$annotations", "(J)V", "isSpecified--R2X_6o", "(J)Z", "isUnspecified", "isUnspecified--R2X_6o$annotations", "isUnspecified--R2X_6o", "sp", "getSp$annotations", "getSp", "TextUnit", "value", "type", "Landroidx/compose/ui/unit/TextUnitType;", "TextUnit-anM5pPY", "(FJ)J", "checkArithmetic", "", "a", "checkArithmetic--R2X_6o", "b", "checkArithmetic-NB67dxo", "(JJ)V", "c", "checkArithmetic-vU-0ePk", "(JJJ)V", "lerp", "start", "stop", "fraction", "lerp-C3pnCVY", "(JJF)J", "pack", "unitType", "v", "(JF)J", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-eAf_CNQ", "(JLkotlin/jvm/functions/Function0;)J", "times", "other", "times-mpE4wyQ", "(DJ)J", "(IJ)J", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextUnit.kt */
public final class TextUnitKt {
    private static final long UNIT_MASK = 1095216660480L;
    private static final long UNIT_TYPE_EM = 8589934592L;
    private static final long UNIT_TYPE_SP = 4294967296L;
    private static final long UNIT_TYPE_UNSPECIFIED = 0;

    public static /* synthetic */ void getEm$annotations(double d) {
    }

    public static /* synthetic */ void getEm$annotations(float f) {
    }

    public static /* synthetic */ void getEm$annotations(int i) {
    }

    public static /* synthetic */ void getSp$annotations(double d) {
    }

    public static /* synthetic */ void getSp$annotations(float f) {
    }

    public static /* synthetic */ void getSp$annotations(int i) {
    }

    /* renamed from: isSpecified--R2X_6o$annotations  reason: not valid java name */
    public static /* synthetic */ void m6184isSpecifiedR2X_6o$annotations(long j) {
    }

    /* renamed from: isUnspecified--R2X_6o$annotations  reason: not valid java name */
    public static /* synthetic */ void m6186isUnspecifiedR2X_6o$annotations(long j) {
    }

    /* renamed from: TextUnit-anM5pPY  reason: not valid java name */
    public static final long m6179TextUnitanM5pPY(float value, long type) {
        return pack(type, value);
    }

    /* renamed from: isSpecified--R2X_6o  reason: not valid java name */
    public static final boolean m6183isSpecifiedR2X_6o(long $this$isSpecified) {
        return !m6185isUnspecifiedR2X_6o($this$isSpecified);
    }

    /* renamed from: isUnspecified--R2X_6o  reason: not valid java name */
    public static final boolean m6185isUnspecifiedR2X_6o(long $this$isUnspecified) {
        return TextUnit.m6165getRawTypeimpl($this$isUnspecified) == 0;
    }

    /* renamed from: takeOrElse-eAf_CNQ  reason: not valid java name */
    public static final long m6188takeOrElseeAf_CNQ(long $this$takeOrElse_u2deAf_CNQ, Function0<TextUnit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return m6185isUnspecifiedR2X_6o($this$takeOrElse_u2deAf_CNQ) ^ true ? $this$takeOrElse_u2deAf_CNQ : block.invoke().m6176unboximpl();
    }

    public static final long getSp(float $this$sp) {
        return pack(UNIT_TYPE_SP, $this$sp);
    }

    public static final long getEm(float $this$em) {
        return pack(UNIT_TYPE_EM, $this$em);
    }

    public static final long getSp(double $this$sp) {
        return pack(UNIT_TYPE_SP, (float) $this$sp);
    }

    public static final long getEm(double $this$em) {
        return pack(UNIT_TYPE_EM, (float) $this$em);
    }

    public static final long getSp(int $this$sp) {
        return pack(UNIT_TYPE_SP, (float) $this$sp);
    }

    public static final long getEm(int $this$em) {
        return pack(UNIT_TYPE_EM, (float) $this$em);
    }

    /* renamed from: times-mpE4wyQ  reason: not valid java name */
    public static final long m6190timesmpE4wyQ(float $this$times_u2dmpE4wyQ, long other) {
        m6180checkArithmeticR2X_6o(other);
        return pack(TextUnit.m6165getRawTypeimpl(other), TextUnit.m6167getValueimpl(other) * $this$times_u2dmpE4wyQ);
    }

    /* renamed from: times-mpE4wyQ  reason: not valid java name */
    public static final long m6189timesmpE4wyQ(double $this$times_u2dmpE4wyQ, long other) {
        m6180checkArithmeticR2X_6o(other);
        return pack(TextUnit.m6165getRawTypeimpl(other), ((float) $this$times_u2dmpE4wyQ) * TextUnit.m6167getValueimpl(other));
    }

    /* renamed from: times-mpE4wyQ  reason: not valid java name */
    public static final long m6191timesmpE4wyQ(int $this$times_u2dmpE4wyQ, long other) {
        m6180checkArithmeticR2X_6o(other);
        return pack(TextUnit.m6165getRawTypeimpl(other), ((float) $this$times_u2dmpE4wyQ) * TextUnit.m6167getValueimpl(other));
    }

    public static final long pack(long unitType, float v) {
        return TextUnit.m6159constructorimpl((((long) Float.floatToIntBits(v)) & 4294967295L) | unitType);
    }

    /* renamed from: checkArithmetic--R2X_6o  reason: not valid java name */
    public static final void m6180checkArithmeticR2X_6o(long a) {
        if (!(!m6185isUnspecifiedR2X_6o(a))) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        }
    }

    /* renamed from: checkArithmetic-NB67dxo  reason: not valid java name */
    public static final void m6181checkArithmeticNB67dxo(long a, long b) {
        if (!(!m6185isUnspecifiedR2X_6o(a) && !m6185isUnspecifiedR2X_6o(b))) {
            throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
        } else if (!TextUnitType.m6195equalsimpl0(TextUnit.m6166getTypeUIouoOA(a), TextUnit.m6166getTypeUIouoOA(b))) {
            throw new IllegalArgumentException(("Cannot perform operation for " + TextUnitType.m6197toStringimpl(TextUnit.m6166getTypeUIouoOA(a)) + " and " + TextUnitType.m6197toStringimpl(TextUnit.m6166getTypeUIouoOA(b))).toString());
        }
    }

    /* renamed from: checkArithmetic-vU-0ePk  reason: not valid java name */
    public static final void m6182checkArithmeticvU0ePk(long a, long b, long c) {
        boolean z = true;
        if (!m6185isUnspecifiedR2X_6o(a) && !m6185isUnspecifiedR2X_6o(b) && !m6185isUnspecifiedR2X_6o(c)) {
            if (!TextUnitType.m6195equalsimpl0(TextUnit.m6166getTypeUIouoOA(a), TextUnit.m6166getTypeUIouoOA(b)) || !TextUnitType.m6195equalsimpl0(TextUnit.m6166getTypeUIouoOA(b), TextUnit.m6166getTypeUIouoOA(c))) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException(("Cannot perform operation for " + TextUnitType.m6197toStringimpl(TextUnit.m6166getTypeUIouoOA(a)) + " and " + TextUnitType.m6197toStringimpl(TextUnit.m6166getTypeUIouoOA(b))).toString());
            }
            return;
        }
        throw new IllegalArgumentException("Cannot perform operation for Unspecified type.".toString());
    }

    /* renamed from: lerp-C3pnCVY  reason: not valid java name */
    public static final long m6187lerpC3pnCVY(long start, long stop, float fraction) {
        m6181checkArithmeticNB67dxo(start, stop);
        return pack(TextUnit.m6165getRawTypeimpl(start), MathHelpersKt.lerp(TextUnit.m6167getValueimpl(start), TextUnit.m6167getValueimpl(stop), fraction));
    }
}
