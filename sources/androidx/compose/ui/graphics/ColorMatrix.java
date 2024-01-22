package androidx.compose.ui.graphics;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0014\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ5\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0012H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\t¢\u0006\u0004\b#\u0010\u000bJP\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f26\u0010&\u001a2\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\t0'H\b¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101J(\u0010.\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u000fH\n¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b9\u00107J\u0015\u0010:\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u000f¢\u0006\u0004\b;\u00107J\u0015\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u000f¢\u0006\u0004\b>\u00107J-\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000f¢\u0006\u0004\bD\u0010EJ\u001e\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\u0000H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u00101J\u0010\u0010I\u001a\u00020JHÖ\u0001¢\u0006\u0004\bK\u0010LR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006M"}, d2 = {"Landroidx/compose/ui/graphics/ColorMatrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "convertRgbToYuv", "", "convertRgbToYuv-impl", "([F)V", "convertYuvToRgb", "convertYuvToRgb-impl", "dot", "", "m1", "row", "", "m2", "column", "dot-Me4OoYI", "([F[FI[FI)F", "equals", "", "other", "equals-impl", "([FLjava/lang/Object;)Z", "get", "get-impl", "([FII)F", "hashCode", "hashCode-impl", "([F)I", "reset", "reset-impl", "rotateInternal", "degrees", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cosine", "sine", "rotateInternal-impl", "([FFLkotlin/jvm/functions/Function2;)V", "set", "src", "set-jHG-Opc", "([F[F)V", "v", "set-impl", "([FIIF)V", "setToRotateBlue", "setToRotateBlue-impl", "([FF)V", "setToRotateGreen", "setToRotateGreen-impl", "setToRotateRed", "setToRotateRed-impl", "setToSaturation", "sat", "setToSaturation-impl", "setToScale", "redScale", "greenScale", "blueScale", "alphaScale", "setToScale-impl", "([FFFFF)V", "timesAssign", "colorMatrix", "timesAssign-jHG-Opc", "toString", "", "toString-impl", "([F)Ljava/lang/String;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* compiled from: ColorMatrix.kt */
public final class ColorMatrix {
    private final float[] values;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ColorMatrix m3219boximpl(float[] fArr) {
        return new ColorMatrix(fArr);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static float[] m3220constructorimpl(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "values");
        return fArr;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3225equalsimpl(float[] fArr, Object obj) {
        return (obj instanceof ColorMatrix) && Intrinsics.areEqual((Object) fArr, (Object) ((ColorMatrix) obj).m3240unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3226equalsimpl0(float[] fArr, float[] fArr2) {
        return Intrinsics.areEqual((Object) fArr, (Object) fArr2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3228hashCodeimpl(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3239toStringimpl(float[] fArr) {
        return "ColorMatrix(values=" + Arrays.toString(fArr) + ')';
    }

    public boolean equals(Object obj) {
        return m3225equalsimpl(this.values, obj);
    }

    public int hashCode() {
        return m3228hashCodeimpl(this.values);
    }

    public String toString() {
        return m3239toStringimpl(this.values);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ float[] m3240unboximpl() {
        return this.values;
    }

    private /* synthetic */ ColorMatrix(float[] values2) {
        this.values = values2;
    }

    /* renamed from: constructor-impl$default  reason: not valid java name */
    public static /* synthetic */ float[] m3221constructorimpl$default(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        }
        return m3220constructorimpl(fArr);
    }

    public final float[] getValues() {
        return this.values;
    }

    /* renamed from: get-impl  reason: not valid java name */
    public static final float m3227getimpl(float[] arg0, int row, int column) {
        return arg0[(row * 5) + column];
    }

    /* renamed from: set-impl  reason: not valid java name */
    public static final void m3231setimpl(float[] arg0, int row, int column, float v) {
        arg0[(row * 5) + column] = v;
    }

    /* renamed from: reset-impl  reason: not valid java name */
    public static final void m3229resetimpl(float[] arg0) {
        ArraysKt.fill$default(arg0, 0.0f, 0, 0, 6, (Object) null);
        arg0[(0 * 5) + 0] = 1.0f;
        arg0[(2 * 5) + 2] = 1.0f;
        arg0[(1 * 5) + 1] = 1.0f;
        arg0[(3 * 5) + 3] = 1.0f;
    }

    /* renamed from: set-jHG-Opc  reason: not valid java name */
    public static final void m3232setjHGOpc(float[] arg0, float[] src) {
        Intrinsics.checkNotNullParameter(src, "src");
        ArraysKt.copyInto$default(src, arg0, 0, 0, 0, 14, (Object) null);
    }

    /* renamed from: rotateInternal-impl  reason: not valid java name */
    private static final void m3230rotateInternalimpl(float[] arg0, float degrees, Function2<? super Float, ? super Float, Unit> block) {
        m3229resetimpl(arg0);
        double radians = (((double) degrees) * 3.141592653589793d) / 180.0d;
        block.invoke(Float.valueOf((float) Math.cos(radians)), Float.valueOf((float) Math.sin(radians)));
    }

    /* renamed from: timesAssign-jHG-Opc  reason: not valid java name */
    public static final void m3238timesAssignjHGOpc(float[] arg0, float[] colorMatrix) {
        float[] fArr = arg0;
        float[] fArr2 = colorMatrix;
        Intrinsics.checkNotNullParameter(fArr2, "colorMatrix");
        float v00 = m3224dotMe4OoYI(fArr, fArr, 0, fArr2, 0);
        float v01 = m3224dotMe4OoYI(fArr, fArr, 0, fArr2, 1);
        float v02 = m3224dotMe4OoYI(fArr, fArr, 0, fArr2, 2);
        float v03 = m3224dotMe4OoYI(fArr, fArr, 0, fArr2, 3);
        float v04 = (fArr[(0 * 5) + 0] * fArr2[(0 * 5) + 4]) + (fArr[(0 * 5) + 1] * fArr2[(1 * 5) + 4]) + (fArr[(0 * 5) + 2] * fArr2[(2 * 5) + 4]) + (fArr[(0 * 5) + 3] * fArr2[(3 * 5) + 4]) + fArr[(0 * 5) + 4];
        float v10 = m3224dotMe4OoYI(fArr, fArr, 1, fArr2, 0);
        float v11 = m3224dotMe4OoYI(fArr, fArr, 1, fArr2, 1);
        float v12 = m3224dotMe4OoYI(fArr, fArr, 1, fArr2, 2);
        float v13 = m3224dotMe4OoYI(fArr, fArr, 1, fArr2, 3);
        float v14 = (fArr[(1 * 5) + 0] * fArr2[(0 * 5) + 4]) + (fArr[(1 * 5) + 1] * fArr2[(1 * 5) + 4]) + (fArr[(1 * 5) + 2] * fArr2[(2 * 5) + 4]) + (fArr[(1 * 5) + 3] * fArr2[(3 * 5) + 4]) + fArr[(1 * 5) + 4];
        float v20 = m3224dotMe4OoYI(fArr, fArr, 2, fArr2, 0);
        float v21 = m3224dotMe4OoYI(fArr, fArr, 2, fArr2, 1);
        float v22 = m3224dotMe4OoYI(fArr, fArr, 2, fArr2, 2);
        float v23 = m3224dotMe4OoYI(fArr, fArr, 2, fArr2, 3);
        float v24 = (fArr[(2 * 5) + 0] * fArr2[(0 * 5) + 4]) + (fArr[(2 * 5) + 1] * fArr2[(1 * 5) + 4]) + (fArr[(2 * 5) + 2] * fArr2[(2 * 5) + 4]) + (fArr[(2 * 5) + 3] * fArr2[(3 * 5) + 4]) + fArr[(2 * 5) + 4];
        float v30 = m3224dotMe4OoYI(fArr, fArr, 3, fArr2, 0);
        float v31 = m3224dotMe4OoYI(fArr, fArr, 3, fArr2, 1);
        float v32 = m3224dotMe4OoYI(fArr, fArr, 3, fArr2, 2);
        float v33 = m3224dotMe4OoYI(fArr, fArr, 3, fArr2, 3);
        fArr[(0 * 5) + 0] = v00;
        fArr[(0 * 5) + 1] = v01;
        fArr[(0 * 5) + 2] = v02;
        fArr[(0 * 5) + 3] = v03;
        fArr[(0 * 5) + 4] = v04;
        fArr[(1 * 5) + 0] = v10;
        fArr[(1 * 5) + 1] = v11;
        fArr[(1 * 5) + 2] = v12;
        fArr[(1 * 5) + 3] = v13;
        fArr[(1 * 5) + 4] = v14;
        fArr[(2 * 5) + 0] = v20;
        fArr[(2 * 5) + 1] = v21;
        fArr[(2 * 5) + 2] = v22;
        fArr[(2 * 5) + 3] = v23;
        fArr[(2 * 5) + 4] = v24;
        fArr[(3 * 5) + 0] = v30;
        fArr[(3 * 5) + 1] = v31;
        fArr[(3 * 5) + 2] = v32;
        fArr[(3 * 5) + 3] = v33;
        fArr[(3 * 5) + 4] = (fArr[(3 * 5) + 0] * fArr2[(0 * 5) + 4]) + (fArr[(3 * 5) + 1] * fArr2[(1 * 5) + 4]) + (fArr[(3 * 5) + 2] * fArr2[(2 * 5) + 4]) + (fArr[(3 * 5) + 3] * fArr2[(3 * 5) + 4]) + fArr[(3 * 5) + 4];
    }

    /* renamed from: dot-Me4OoYI  reason: not valid java name */
    private static final float m3224dotMe4OoYI(float[] arg0, float[] m1, int row, float[] m2, int column) {
        return (m1[(row * 5) + 0] * m2[(0 * 5) + column]) + (m1[(row * 5) + 1] * m2[(1 * 5) + column]) + (m1[(row * 5) + 2] * m2[(2 * 5) + column]) + (m1[(row * 5) + 3] * m2[(3 * 5) + column]);
    }

    /* renamed from: setToSaturation-impl  reason: not valid java name */
    public static final void m3236setToSaturationimpl(float[] arg0, float sat) {
        m3229resetimpl(arg0);
        float invSat = ((float) 1) - sat;
        float R = 0.213f * invSat;
        float G = 0.715f * invSat;
        float B = 0.072f * invSat;
        arg0[(0 * 5) + 0] = R + sat;
        arg0[(0 * 5) + 1] = G;
        arg0[(0 * 5) + 2] = B;
        arg0[(1 * 5) + 0] = R;
        arg0[(1 * 5) + 1] = G + sat;
        arg0[(1 * 5) + 2] = B;
        arg0[(2 * 5) + 0] = R;
        arg0[(2 * 5) + 1] = G;
        arg0[(2 * 5) + 2] = B + sat;
    }

    /* renamed from: setToScale-impl  reason: not valid java name */
    public static final void m3237setToScaleimpl(float[] arg0, float redScale, float greenScale, float blueScale, float alphaScale) {
        m3229resetimpl(arg0);
        arg0[(0 * 5) + 0] = redScale;
        arg0[(1 * 5) + 1] = greenScale;
        arg0[(2 * 5) + 2] = blueScale;
        arg0[(3 * 5) + 3] = alphaScale;
    }

    /* renamed from: setToRotateRed-impl  reason: not valid java name */
    public static final void m3235setToRotateRedimpl(float[] arg0, float degrees) {
        m3229resetimpl(arg0);
        double radians$iv = (((double) degrees) * 3.141592653589793d) / 180.0d;
        float cosine = (float) Math.cos(radians$iv);
        float sine = (float) Math.sin(radians$iv);
        arg0[(2 * 5) + 2] = cosine;
        arg0[(1 * 5) + 1] = cosine;
        arg0[(1 * 5) + 2] = sine;
        arg0[(2 * 5) + 1] = -sine;
    }

    /* renamed from: setToRotateGreen-impl  reason: not valid java name */
    public static final void m3234setToRotateGreenimpl(float[] arg0, float degrees) {
        m3229resetimpl(arg0);
        double radians$iv = (((double) degrees) * 3.141592653589793d) / 180.0d;
        float cosine = (float) Math.cos(radians$iv);
        float sine = (float) Math.sin(radians$iv);
        arg0[(2 * 5) + 2] = cosine;
        arg0[(0 * 5) + 0] = cosine;
        arg0[(0 * 5) + 2] = -sine;
        arg0[(2 * 5) + 0] = sine;
    }

    /* renamed from: setToRotateBlue-impl  reason: not valid java name */
    public static final void m3233setToRotateBlueimpl(float[] arg0, float degrees) {
        m3229resetimpl(arg0);
        double radians$iv = (((double) degrees) * 3.141592653589793d) / 180.0d;
        float cosine = (float) Math.cos(radians$iv);
        float sine = (float) Math.sin(radians$iv);
        arg0[(1 * 5) + 1] = cosine;
        arg0[(0 * 5) + 0] = cosine;
        arg0[(0 * 5) + 1] = sine;
        arg0[(1 * 5) + 0] = -sine;
    }

    /* renamed from: convertRgbToYuv-impl  reason: not valid java name */
    public static final void m3222convertRgbToYuvimpl(float[] arg0) {
        m3229resetimpl(arg0);
        arg0[(0 * 5) + 0] = 0.299f;
        arg0[(0 * 5) + 1] = 0.587f;
        arg0[(0 * 5) + 2] = 0.114f;
        arg0[(1 * 5) + 0] = -0.16874f;
        arg0[(1 * 5) + 1] = -0.33126f;
        arg0[(1 * 5) + 2] = 0.5f;
        arg0[(2 * 5) + 0] = 0.5f;
        arg0[(2 * 5) + 1] = -0.41869f;
        arg0[(2 * 5) + 2] = -0.08131f;
    }

    /* renamed from: convertYuvToRgb-impl  reason: not valid java name */
    public static final void m3223convertYuvToRgbimpl(float[] arg0) {
        m3229resetimpl(arg0);
        arg0[(0 * 5) + 2] = 1.402f;
        arg0[(1 * 5) + 0] = 1.0f;
        arg0[(1 * 5) + 1] = -0.34414f;
        arg0[(1 * 5) + 2] = -0.71414f;
        arg0[(2 * 5) + 0] = 1.0f;
        arg0[(2 * 5) + 1] = 1.772f;
        arg0[(2 * 5) + 2] = 0.0f;
    }
}
