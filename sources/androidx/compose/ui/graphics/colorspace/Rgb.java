package androidx.compose.ui.graphics.colorspace;

import androidx.autofill.HintConstants;
import androidx.compose.ui.graphics.ColorKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ^2\u00020\u0001:\u0001^B?\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nBW\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0015B/\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0002\u0010\u001aB'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0002\u0010\u001bB?\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u001cB\u001f\b\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0000\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u001fB[\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020 \u0012\u0006\u0010\t\u001a\u00020 \u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\"J\u0013\u0010<\u001a\u00020.2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u001e\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fJ\u000e\u0010?\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005J\u0010\u0010D\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0016J\u0006\u0010E\u001a\u00020\u0005J\u000e\u0010E\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005J\u0010\u0010F\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u0017H\u0016J\u0010\u0010H\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u0017H\u0016J\u0006\u0010I\u001a\u00020\u0005J\u000e\u0010I\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010J\u001a\u00020\u0005J\u000e\u0010J\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005J\b\u0010K\u001a\u00020\u0017H\u0016J\u001e\u0010L\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fJ\u000e\u0010L\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005J%\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000fH\u0010¢\u0006\u0002\bRJ\u0010\u0010S\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0016J%\u0010T\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000fH\u0010¢\u0006\u0002\bUJ@\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\\\u0010]R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010/R\u0014\u00100\u001a\u00020.X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0014\u00102\u001a\u00020 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'R\u0014\u00104\u001a\u00020 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010'R\u0014\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010,R\u0013\u0010!\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0014\u0010\u001e\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006_"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "toXYZ", "", "oetf", "Lkotlin/Function1;", "", "eotf", "(Ljava/lang/String;[FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "primaries", "whitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "min", "", "max", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FF)V", "function", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "id", "", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "gamma", "(Ljava/lang/String;[FD)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;D)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;DFFI)V", "colorSpace", "transform", "(Landroidx/compose/ui/graphics/colorspace/Rgb;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;)V", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "transferParameters", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;[FLandroidx/compose/ui/graphics/colorspace/DoubleFunction;Landroidx/compose/ui/graphics/colorspace/DoubleFunction;FFLandroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "getEotf", "()Lkotlin/jvm/functions/Function1;", "eotfFunc", "getEotfFunc$ui_graphics_release", "()Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "eotfOrig", "getEotfOrig$ui_graphics_release", "inverseTransform", "getInverseTransform$ui_graphics_release", "()[F", "isSrgb", "", "()Z", "isWideGamut", "getOetf", "oetfFunc", "getOetfFunc$ui_graphics_release", "oetfOrig", "getOetfOrig$ui_graphics_release", "getPrimaries$ui_graphics_release", "getTransferParameters", "()Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "getTransform$ui_graphics_release", "getWhitePoint", "()Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "equals", "other", "", "fromLinear", "r", "g", "b", "v", "fromXyz", "getInverseTransform", "getMaxValue", "component", "getMinValue", "getPrimaries", "getTransform", "hashCode", "toLinear", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Rgb.kt */
public final class Rgb extends ColorSpace {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final DoubleFunction DoubleIdentity = new Rgb$$ExternalSyntheticLambda1();
    private final Function1<Double, Double> eotf;
    private final DoubleFunction eotfFunc;
    private final DoubleFunction eotfOrig;
    private final float[] inverseTransform;
    private final boolean isSrgb;
    private final boolean isWideGamut;
    /* access modifiers changed from: private */
    public final float max;
    /* access modifiers changed from: private */
    public final float min;
    private final Function1<Double, Double> oetf;
    private final DoubleFunction oetfFunc;
    private final DoubleFunction oetfOrig;
    private final float[] primaries;
    private final TransferParameters transferParameters;
    private final float[] transform;
    private final WhitePoint whitePoint;

    public final WhitePoint getWhitePoint() {
        return this.whitePoint;
    }

    public final TransferParameters getTransferParameters() {
        return this.transferParameters;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Rgb(String name, float[] primaries2, WhitePoint whitePoint2, float[] transform2, DoubleFunction oetf2, DoubleFunction eotf2, float min2, float max2, TransferParameters transferParameters2, int id) {
        super(name, ColorModel.Companion.m3609getRgbxdoWZVw(), id, (DefaultConstructorMarker) null);
        float[] fArr = primaries2;
        WhitePoint whitePoint3 = whitePoint2;
        float[] fArr2 = transform2;
        DoubleFunction doubleFunction = oetf2;
        DoubleFunction doubleFunction2 = eotf2;
        float f = min2;
        float f2 = max2;
        Intrinsics.checkNotNullParameter(name, HintConstants.AUTOFILL_HINT_NAME);
        Intrinsics.checkNotNullParameter(fArr, "primaries");
        Intrinsics.checkNotNullParameter(whitePoint3, "whitePoint");
        Intrinsics.checkNotNullParameter(doubleFunction, "oetf");
        Intrinsics.checkNotNullParameter(doubleFunction2, "eotf");
        this.whitePoint = whitePoint3;
        this.min = f;
        this.max = f2;
        this.transferParameters = transferParameters2;
        this.oetfOrig = doubleFunction;
        this.oetf = new Rgb$oetf$1(this);
        this.oetfFunc = new Rgb$$ExternalSyntheticLambda7(this);
        this.eotfOrig = doubleFunction2;
        this.eotf = new Rgb$eotf$1(this);
        this.eotfFunc = new Rgb$$ExternalSyntheticLambda8(this);
        if (fArr.length != 6 && fArr.length != 9) {
            throw new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
        } else if (f < f2) {
            Companion companion = Companion;
            float[] access$xyPrimaries = companion.xyPrimaries(fArr);
            this.primaries = access$xyPrimaries;
            if (fArr2 == null) {
                this.transform = companion.computeXYZMatrix(access$xyPrimaries, whitePoint3);
            } else if (fArr2.length == 9) {
                this.transform = fArr2;
            } else {
                float f3 = f2;
                float f4 = f;
                throw new IllegalArgumentException("Transform must have 9 entries! Has " + fArr2.length);
            }
            this.inverseTransform = ColorSpaceKt.inverse3x3(this.transform);
            this.isWideGamut = companion.isWideGamut(access$xyPrimaries, f, f2);
            float[] fArr3 = access$xyPrimaries;
            float f5 = f2;
            float f6 = f;
            float[] fArr4 = fArr2;
            this.isSrgb = companion.isSrgb(fArr3, whitePoint2, oetf2, eotf2, min2, max2, id);
        } else {
            float[] fArr5 = fArr2;
            throw new IllegalArgumentException("Invalid range: min=" + f + ", max=" + f2 + "; min must be strictly < max");
        }
    }

    public final float[] getPrimaries$ui_graphics_release() {
        return this.primaries;
    }

    public final float[] getTransform$ui_graphics_release() {
        return this.transform;
    }

    public final float[] getInverseTransform$ui_graphics_release() {
        return this.inverseTransform;
    }

    public final DoubleFunction getOetfOrig$ui_graphics_release() {
        return this.oetfOrig;
    }

    public final Function1<Double, Double> getOetf() {
        return this.oetf;
    }

    public final DoubleFunction getOetfFunc$ui_graphics_release() {
        return this.oetfFunc;
    }

    /* access modifiers changed from: private */
    public static final double oetfFunc$lambda$0(Rgb this$0, double x) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return RangesKt.coerceIn(this$0.oetfOrig.invoke(x), (double) this$0.min, (double) this$0.max);
    }

    public final DoubleFunction getEotfOrig$ui_graphics_release() {
        return this.eotfOrig;
    }

    public final Function1<Double, Double> getEotf() {
        return this.eotf;
    }

    public final DoubleFunction getEotfFunc$ui_graphics_release() {
        return this.eotfFunc;
    }

    /* access modifiers changed from: private */
    public static final double eotfFunc$lambda$1(Rgb this$0, double x) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.eotfOrig.invoke(RangesKt.coerceIn(x, (double) this$0.min, (double) this$0.max));
    }

    public boolean isWideGamut() {
        return this.isWideGamut;
    }

    public boolean isSrgb() {
        return this.isSrgb;
    }

    public final float[] getPrimaries() {
        float[] fArr = this.primaries;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public final float[] getTransform() {
        float[] fArr = this.transform;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public final float[] getInverseTransform() {
        float[] fArr = this.inverseTransform;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(java.lang.String r17, float[] r18, kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r19, kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r20) {
        /*
            r16 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            java.lang.String r3 = "name"
            r15 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r3)
            java.lang.String r3 = "toXYZ"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "oetf"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "eotf"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r3 = Companion
            float[] r6 = r3.computePrimaries$ui_graphics_release(r0)
            androidx.compose.ui.graphics.colorspace.WhitePoint r7 = r3.computeWhitePoint(r0)
            r8 = 0
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda5 r9 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda5
            r9.<init>(r1)
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda6 r10 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda6
            r10.<init>(r2)
            r11 = 0
            r12 = 1065353216(0x3f800000, float:1.0)
            r13 = 0
            r14 = -1
            r4 = r16
            r5 = r17
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$2(Function1 $oetf, double x) {
        Intrinsics.checkNotNullParameter($oetf, "$oetf");
        return ((Number) $oetf.invoke(Double.valueOf(x))).doubleValue();
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$3(Function1 $eotf, double x) {
        Intrinsics.checkNotNullParameter($eotf, "$eotf");
        return ((Number) $eotf.invoke(Double.valueOf(x))).doubleValue();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(java.lang.String r17, float[] r18, androidx.compose.ui.graphics.colorspace.WhitePoint r19, kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r20, kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r21, float r22, float r23) {
        /*
            r16 = this;
            r0 = r20
            r1 = r21
            java.lang.String r2 = "name"
            r14 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r2)
            java.lang.String r2 = "primaries"
            r15 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r2)
            java.lang.String r2 = "whitePoint"
            r13 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r2)
            java.lang.String r2 = "oetf"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "eotf"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r7 = 0
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda0 r8 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda0
            r8.<init>(r0)
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda4 r9 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda4
            r9.<init>(r1)
            r12 = 0
            r2 = -1
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r10 = r22
            r11 = r23
            r13 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, float, float):void");
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$4(Function1 $oetf, double x) {
        Intrinsics.checkNotNullParameter($oetf, "$oetf");
        return ((Number) $oetf.invoke(Double.valueOf(x))).doubleValue();
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$5(Function1 $eotf, double x) {
        Intrinsics.checkNotNullParameter($eotf, "$eotf");
        return ((Number) $eotf.invoke(Double.valueOf(x))).doubleValue();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(java.lang.String r8, float[] r9, androidx.compose.ui.graphics.colorspace.TransferParameters r10) {
        /*
            r7 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "toXYZ"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "function"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r0 = Companion
            float[] r3 = r0.computePrimaries$ui_graphics_release(r9)
            androidx.compose.ui.graphics.colorspace.WhitePoint r4 = r0.computeWhitePoint(r9)
            r6 = -1
            r1 = r7
            r2 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.TransferParameters):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Rgb(String name, float[] primaries2, WhitePoint whitePoint2, TransferParameters function) {
        this(name, primaries2, whitePoint2, function, -1);
        Intrinsics.checkNotNullParameter(name, HintConstants.AUTOFILL_HINT_NAME);
        Intrinsics.checkNotNullParameter(primaries2, "primaries");
        Intrinsics.checkNotNullParameter(whitePoint2, "whitePoint");
        Intrinsics.checkNotNullParameter(function, "function");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(java.lang.String r16, float[] r17, androidx.compose.ui.graphics.colorspace.WhitePoint r18, androidx.compose.ui.graphics.colorspace.TransferParameters r19, int r20) {
        /*
            r15 = this;
            r11 = r19
            java.lang.String r0 = "name"
            r12 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "primaries"
            r13 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "whitePoint"
            r14 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "function"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r4 = 0
            double r0 = r19.getE()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            r5 = 0
            if (r0 != 0) goto L_0x002f
            r0 = r1
            goto L_0x0030
        L_0x002f:
            r0 = r5
        L_0x0030:
            if (r0 == 0) goto L_0x0046
            double r6 = r19.getF()
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x003c
            r0 = r1
            goto L_0x003d
        L_0x003c:
            r0 = r5
        L_0x003d:
            if (r0 == 0) goto L_0x0046
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda9 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda9
            r0.<init>(r11)
            r6 = r0
            goto L_0x004c
        L_0x0046:
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda10 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda10
            r0.<init>(r11)
            r6 = r0
        L_0x004c:
            double r7 = r19.getE()
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0056
            r0 = r1
            goto L_0x0057
        L_0x0056:
            r0 = r5
        L_0x0057:
            if (r0 == 0) goto L_0x006c
            double r7 = r19.getF()
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r1 = r5
        L_0x0063:
            if (r1 == 0) goto L_0x006c
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda11 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda11
            r0.<init>(r11)
            r7 = r0
            goto L_0x0072
        L_0x006c:
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda12 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda12
            r0.<init>(r11)
            r7 = r0
        L_0x0072:
            r8 = 0
            r9 = 1065353216(0x3f800000, float:1.0)
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r18
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r19
            r10 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, androidx.compose.ui.graphics.colorspace.TransferParameters, int):void");
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$6(TransferParameters $function, double x) {
        Intrinsics.checkNotNullParameter($function, "$function");
        return ColorSpaceKt.rcpResponse(x, $function.getA(), $function.getB(), $function.getC(), $function.getD(), $function.getGamma());
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$7(TransferParameters $function, double x) {
        Intrinsics.checkNotNullParameter($function, "$function");
        return ColorSpaceKt.rcpResponse(x, $function.getA(), $function.getB(), $function.getC(), $function.getD(), $function.getE(), $function.getF(), $function.getGamma());
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$8(TransferParameters $function, double x) {
        Intrinsics.checkNotNullParameter($function, "$function");
        return ColorSpaceKt.response(x, $function.getA(), $function.getB(), $function.getC(), $function.getD(), $function.getGamma());
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$9(TransferParameters $function, double x) {
        Intrinsics.checkNotNullParameter($function, "$function");
        return ColorSpaceKt.response(x, $function.getA(), $function.getB(), $function.getC(), $function.getD(), $function.getE(), $function.getF(), $function.getGamma());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(java.lang.String r11, float[] r12, double r13) {
        /*
            r10 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "toXYZ"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r0 = Companion
            float[] r3 = r0.computePrimaries$ui_graphics_release(r12)
            androidx.compose.ui.graphics.colorspace.WhitePoint r4 = r0.computeWhitePoint(r12)
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = -1
            r1 = r10
            r2 = r11
            r5 = r13
            r1.<init>((java.lang.String) r2, (float[]) r3, (androidx.compose.ui.graphics.colorspace.WhitePoint) r4, (double) r5, (float) r7, (float) r8, (int) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], double):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Rgb(String name, float[] primaries2, WhitePoint whitePoint2, double gamma) {
        this(name, primaries2, whitePoint2, gamma, 0.0f, 1.0f, -1);
        Intrinsics.checkNotNullParameter(name, HintConstants.AUTOFILL_HINT_NAME);
        Intrinsics.checkNotNullParameter(primaries2, "primaries");
        Intrinsics.checkNotNullParameter(whitePoint2, "whitePoint");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(java.lang.String r24, float[] r25, androidx.compose.ui.graphics.colorspace.WhitePoint r26, double r27, float r29, float r30, int r31) {
        /*
            r23 = this;
            r1 = r27
            java.lang.String r0 = "name"
            r15 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "primaries"
            r13 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "whitePoint"
            r14 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r17 = 0
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r5 = 1
            r6 = 0
            if (r0 != 0) goto L_0x0027
            r0 = r5
            goto L_0x0028
        L_0x0027:
            r0 = r6
        L_0x0028:
            if (r0 == 0) goto L_0x002f
            androidx.compose.ui.graphics.colorspace.DoubleFunction r0 = DoubleIdentity
            r18 = r0
            goto L_0x0036
        L_0x002f:
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda2 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda2
            r0.<init>(r1)
            r18 = r0
        L_0x0036:
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r5 = r6
        L_0x003c:
            if (r5 == 0) goto L_0x0043
            androidx.compose.ui.graphics.colorspace.DoubleFunction r0 = DoubleIdentity
            r19 = r0
            goto L_0x004a
        L_0x0043:
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda3 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda3
            r0.<init>(r1)
            r19 = r0
        L_0x004a:
            androidx.compose.ui.graphics.colorspace.TransferParameters r20 = new androidx.compose.ui.graphics.colorspace.TransferParameters
            r0 = r20
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r21 = 0
            r13 = r21
            r16 = 96
            r15 = r16
            r16 = 0
            r1 = r27
            r0.<init>(r1, r3, r5, r7, r9, r11, r13, r15, r16)
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r29
            r9 = r30
            r10 = r20
            r11 = r31
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, double, float, float, int):void");
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$10(double $gamma, double x) {
        double d = 0.0d;
        if (x >= 0.0d) {
            d = x;
        }
        return Math.pow(d, 1.0d / $gamma);
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$11(double $gamma, double x) {
        double d = 0.0d;
        if (x >= 0.0d) {
            d = x;
        }
        return Math.pow(d, $gamma);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Rgb(Rgb colorSpace, float[] transform2, WhitePoint whitePoint2) {
        this(colorSpace.getName(), colorSpace.primaries, whitePoint2, transform2, colorSpace.oetfOrig, colorSpace.eotfOrig, colorSpace.min, colorSpace.max, colorSpace.transferParameters, -1);
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        Intrinsics.checkNotNullParameter(transform2, "transform");
        Intrinsics.checkNotNullParameter(whitePoint2, "whitePoint");
    }

    public final float[] getPrimaries(float[] primaries2) {
        Intrinsics.checkNotNullParameter(primaries2, "primaries");
        return ArraysKt.copyInto$default(this.primaries, primaries2, 0, 0, 0, 14, (Object) null);
    }

    public final float[] getTransform(float[] transform2) {
        Intrinsics.checkNotNullParameter(transform2, "transform");
        return ArraysKt.copyInto$default(this.transform, transform2, 0, 0, 0, 14, (Object) null);
    }

    public final float[] getInverseTransform(float[] inverseTransform2) {
        Intrinsics.checkNotNullParameter(inverseTransform2, "inverseTransform");
        return ArraysKt.copyInto$default(this.inverseTransform, inverseTransform2, 0, 0, 0, 14, (Object) null);
    }

    public float getMinValue(int component) {
        return this.min;
    }

    public float getMaxValue(int component) {
        return this.max;
    }

    public final float[] toLinear(float r, float g, float b) {
        return toLinear(new float[]{r, g, b});
    }

    public final float[] toLinear(float[] v) {
        Intrinsics.checkNotNullParameter(v, "v");
        v[0] = (float) this.eotfFunc.invoke((double) v[0]);
        v[1] = (float) this.eotfFunc.invoke((double) v[1]);
        v[2] = (float) this.eotfFunc.invoke((double) v[2]);
        return v;
    }

    public final float[] fromLinear(float r, float g, float b) {
        return fromLinear(new float[]{r, g, b});
    }

    public final float[] fromLinear(float[] v) {
        Intrinsics.checkNotNullParameter(v, "v");
        v[0] = (float) this.oetfFunc.invoke((double) v[0]);
        v[1] = (float) this.oetfFunc.invoke((double) v[1]);
        v[2] = (float) this.oetfFunc.invoke((double) v[2]);
        return v;
    }

    public float[] toXyz(float[] v) {
        Intrinsics.checkNotNullParameter(v, "v");
        v[0] = (float) this.eotfFunc.invoke((double) v[0]);
        v[1] = (float) this.eotfFunc.invoke((double) v[1]);
        v[2] = (float) this.eotfFunc.invoke((double) v[2]);
        return ColorSpaceKt.mul3x3Float3(this.transform, v);
    }

    public long toXy$ui_graphics_release(float v0, float v1, float v2) {
        float v00 = (float) this.eotfFunc.invoke((double) v0);
        float v10 = (float) this.eotfFunc.invoke((double) v1);
        float v20 = (float) this.eotfFunc.invoke((double) v2);
        return (((long) Float.floatToIntBits(ColorSpaceKt.mul3x3Float3_0(this.transform, v00, v10, v20))) << 32) | (((long) Float.floatToIntBits(ColorSpaceKt.mul3x3Float3_1(this.transform, v00, v10, v20))) & 4294967295L);
    }

    public float toZ$ui_graphics_release(float v0, float v1, float v2) {
        return ColorSpaceKt.mul3x3Float3_2(this.transform, (float) this.eotfFunc.invoke((double) v0), (float) this.eotfFunc.invoke((double) v1), (float) this.eotfFunc.invoke((double) v2));
    }

    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release  reason: not valid java name */
    public long m3640xyzaToColorJlNiLsg$ui_graphics_release(float x, float y, float z, float a, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        return ColorKt.Color((float) this.oetfFunc.invoke((double) ColorSpaceKt.mul3x3Float3_0(this.inverseTransform, x, y, z)), (float) this.oetfFunc.invoke((double) ColorSpaceKt.mul3x3Float3_1(this.inverseTransform, x, y, z)), (float) this.oetfFunc.invoke((double) ColorSpaceKt.mul3x3Float3_2(this.inverseTransform, x, y, z)), a, colorSpace);
    }

    public float[] fromXyz(float[] v) {
        Intrinsics.checkNotNullParameter(v, "v");
        ColorSpaceKt.mul3x3Float3(this.inverseTransform, v);
        v[0] = (float) this.oetfFunc.invoke((double) v[0]);
        v[1] = (float) this.oetfFunc.invoke((double) v[1]);
        v[2] = (float) this.oetfFunc.invoke((double) v[2]);
        return v;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass() || !super.equals(other)) {
            return false;
        }
        Rgb rgb = (Rgb) other;
        if (Float.compare(rgb.min, this.min) != 0 || Float.compare(rgb.max, this.max) != 0 || !Intrinsics.areEqual((Object) this.whitePoint, (Object) rgb.whitePoint) || !Arrays.equals(this.primaries, rgb.primaries)) {
            return false;
        }
        TransferParameters transferParameters2 = this.transferParameters;
        if (transferParameters2 != null) {
            return Intrinsics.areEqual((Object) transferParameters2, (Object) rgb.transferParameters);
        }
        if (rgb.transferParameters == null) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) this.oetfOrig, (Object) rgb.oetfOrig)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.eotfOrig, (Object) rgb.eotfOrig);
    }

    public int hashCode() {
        int result = ((((super.hashCode() * 31) + this.whitePoint.hashCode()) * 31) + Arrays.hashCode(this.primaries)) * 31;
        float f = this.min;
        boolean z = true;
        int i = 0;
        int result2 = (result + (!((f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) == 0) ? Float.floatToIntBits(f) : 0)) * 31;
        float f2 = this.max;
        if (f2 != 0.0f) {
            z = false;
        }
        int result3 = (result2 + (!z ? Float.floatToIntBits(f2) : 0)) * 31;
        TransferParameters transferParameters2 = this.transferParameters;
        if (transferParameters2 != null) {
            i = transferParameters2.hashCode();
        }
        int result4 = result3 + i;
        if (this.transferParameters == null) {
            return (((result4 * 31) + this.oetfOrig.hashCode()) * 31) + this.eotfOrig.hashCode();
        }
        return result4;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J(\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J@\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0002J \u0010%\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010&\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb$Companion;", "", "()V", "DoubleIdentity", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "area", "", "primaries", "", "compare", "", "point", "", "a", "b", "computePrimaries", "toXYZ", "computePrimaries$ui_graphics_release", "computeWhitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "computeXYZMatrix", "whitePoint", "contains", "p1", "p2", "cross", "ax", "ay", "bx", "by", "isSrgb", "OETF", "EOTF", "min", "max", "id", "", "isWideGamut", "xyPrimaries", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Rgb.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean isSrgb(float[] primaries, WhitePoint whitePoint, DoubleFunction OETF, DoubleFunction EOTF, float min, float max, int id) {
            if (id == 0) {
                return true;
            }
            if (!ColorSpaceKt.compare(primaries, ColorSpaces.INSTANCE.getSrgbPrimaries$ui_graphics_release()) || !ColorSpaceKt.compare(whitePoint, Illuminant.INSTANCE.getD65())) {
                return false;
            }
            if (!(min == 0.0f)) {
                return false;
            }
            if (!(max == 1.0f)) {
                return false;
            }
            Rgb srgb = ColorSpaces.INSTANCE.getSrgb();
            for (double x = 0.0d; x <= 1.0d; x += 0.00392156862745098d) {
                if (!compare(x, OETF, srgb.getOetfOrig$ui_graphics_release()) || !compare(x, EOTF, srgb.getEotfOrig$ui_graphics_release())) {
                    return false;
                }
            }
            return true;
        }

        private final boolean compare(double point, DoubleFunction a, DoubleFunction b) {
            return Math.abs(a.invoke(point) - b.invoke(point)) <= 0.001d;
        }

        /* access modifiers changed from: private */
        public final boolean isWideGamut(float[] primaries, float min, float max) {
            return (area(primaries) / area(ColorSpaces.INSTANCE.getNtsc1953Primaries$ui_graphics_release()) > 0.9f && contains(primaries, ColorSpaces.INSTANCE.getSrgbPrimaries$ui_graphics_release())) || (min < 0.0f && max > 1.0f);
        }

        private final float area(float[] primaries) {
            float rx = primaries[0];
            float ry = primaries[1];
            float gx = primaries[2];
            float gy = primaries[3];
            float bx = primaries[4];
            float by = primaries[5];
            float r = 0.5f * ((((((rx * gy) + (ry * bx)) + (gx * by)) - (gy * bx)) - (ry * gx)) - (rx * by));
            return r < 0.0f ? -r : r;
        }

        private final float cross(float ax, float ay, float bx, float by) {
            return (ax * by) - (ay * bx);
        }

        private final boolean contains(float[] p1, float[] p2) {
            float[] p0 = {p1[0] - p2[0], p1[1] - p2[1], p1[2] - p2[2], p1[3] - p2[3], p1[4] - p2[4], p1[5] - p2[5]};
            if (cross(p0[0], p0[1], p2[0] - p2[4], p2[1] - p2[5]) < 0.0f || cross(p2[0] - p2[2], p2[1] - p2[3], p0[0], p0[1]) < 0.0f || cross(p0[2], p0[3], p2[2] - p2[0], p2[3] - p2[1]) < 0.0f || cross(p2[2] - p2[4], p2[3] - p2[5], p0[2], p0[3]) < 0.0f || cross(p0[4], p0[5], p2[4] - p2[2], p2[5] - p2[3]) < 0.0f || cross(p2[4] - p2[0], p2[5] - p2[1], p0[4], p0[5]) < 0.0f) {
                return false;
            }
            return true;
        }

        public final float[] computePrimaries$ui_graphics_release(float[] toXYZ) {
            Intrinsics.checkNotNullParameter(toXYZ, "toXYZ");
            float[] r = ColorSpaceKt.mul3x3Float3(toXYZ, new float[]{1.0f, 0.0f, 0.0f});
            float[] g = ColorSpaceKt.mul3x3Float3(toXYZ, new float[]{0.0f, 1.0f, 0.0f});
            float[] b = ColorSpaceKt.mul3x3Float3(toXYZ, new float[]{0.0f, 0.0f, 1.0f});
            float rSum = r[0] + r[1] + r[2];
            float gSum = g[0] + g[1] + g[2];
            float bSum = b[0] + b[1] + b[2];
            return new float[]{r[0] / rSum, r[1] / rSum, g[0] / gSum, g[1] / gSum, b[0] / bSum, b[1] / bSum};
        }

        /* access modifiers changed from: private */
        public final WhitePoint computeWhitePoint(float[] toXYZ) {
            float[] w = ColorSpaceKt.mul3x3Float3(toXYZ, new float[]{1.0f, 1.0f, 1.0f});
            float sum = w[0] + w[1] + w[2];
            return new WhitePoint(w[0] / sum, w[1] / sum);
        }

        /* access modifiers changed from: private */
        public final float[] xyPrimaries(float[] primaries) {
            float[] xyPrimaries = new float[6];
            if (primaries.length == 9) {
                float sum = primaries[0] + primaries[1] + primaries[2];
                xyPrimaries[0] = primaries[0] / sum;
                xyPrimaries[1] = primaries[1] / sum;
                float sum2 = primaries[3] + primaries[4] + primaries[5];
                xyPrimaries[2] = primaries[3] / sum2;
                xyPrimaries[3] = primaries[4] / sum2;
                float sum3 = primaries[6] + primaries[7] + primaries[8];
                xyPrimaries[4] = primaries[6] / sum3;
                xyPrimaries[5] = primaries[7] / sum3;
            } else {
                ArraysKt.copyInto$default(primaries, xyPrimaries, 0, 0, 6, 6, (Object) null);
            }
            return xyPrimaries;
        }

        /* access modifiers changed from: private */
        public final float[] computeXYZMatrix(float[] primaries, WhitePoint whitePoint) {
            float rx = primaries[0];
            float ry = primaries[1];
            float gx = primaries[2];
            float gy = primaries[3];
            float bx = primaries[4];
            float by = primaries[5];
            float wx = whitePoint.getX();
            float wy = whitePoint.getY();
            float f = (float) 1;
            float oneRxRy = (f - rx) / ry;
            float oneGxGy = (f - gx) / gy;
            float rxRy = rx / ry;
            float gxGy = gx / gy;
            float bxBy = bx / by;
            float wxWy = wx / wy;
            float bY = (((((f - wx) / wy) - oneRxRy) * (gxGy - rxRy)) - ((wxWy - rxRy) * (oneGxGy - oneRxRy))) / (((((f - bx) / by) - oneRxRy) * (gxGy - rxRy)) - ((bxBy - rxRy) * (oneGxGy - oneRxRy)));
            float gY = ((wxWy - rxRy) - ((bxBy - rxRy) * bY)) / (gxGy - rxRy);
            float rY = (1.0f - gY) - bY;
            float rYRy = rY / ry;
            float gYGy = gY / gy;
            float bYBy = bY / by;
            return new float[]{rYRy * rx, rY, ((1.0f - rx) - ry) * rYRy, gYGy * gx, gY, ((1.0f - gx) - gy) * gYGy, bYBy * bx, bY, ((1.0f - bx) - by) * bYBy};
        }
    }

    /* access modifiers changed from: private */
    public static final double DoubleIdentity$lambda$12(double d) {
        return d;
    }
}
