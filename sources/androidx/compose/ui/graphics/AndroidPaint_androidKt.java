package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u0005*\u00060\u0003j\u0002`\u0006H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\b*\u00060\u0003j\u0002`\u0006H\u0000\u001a\u0018\u0010\t\u001a\u00020\n*\u00060\u0003j\u0002`\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u0018\u0010\f\u001a\u00020\r*\u00060\u0003j\u0002`\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u0018\u0010\u000f\u001a\u00020\u0010*\u00060\u0003j\u0002`\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u0018\u0010\u0011\u001a\u00020\u0012*\u00060\u0003j\u0002`\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u0010\u0010\u0013\u001a\u00020\u0005*\u00060\u0003j\u0002`\u0006H\u0000\u001a\u0010\u0010\u0014\u001a\u00020\u0005*\u00060\u0003j\u0002`\u0006H\u0000\u001a\u0018\u0010\u0015\u001a\u00020\u0016*\u00060\u0003j\u0002`\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u0018\u0010\u0017\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u001a\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0000\u001a%\u0010\u001b\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010 \u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\nH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001a\u0010#\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010$H\u0000\u001a%\u0010%\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\rH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u001f\u001a\u001a\u0010'\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010(H\u0000\u001a \u0010)\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u000e\u0010\u0019\u001a\n\u0018\u00010*j\u0004\u0018\u0001`+H\u0000\u001a%\u0010,\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\u0010H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010\u001f\u001a%\u0010.\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\u0012H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u001f\u001a\u0018\u00100\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\u0005H\u0000\u001a\u0018\u00101\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\u0005H\u0000\u001a%\u00102\u001a\u00020\u0018*\u00060\u0003j\u0002`\u00062\u0006\u0010\u0019\u001a\u00020\u0016H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u0010\u001f\u001a\n\u00104\u001a\u00020\u0001*\u00020\u0003*\n\u00105\"\u00020\u00032\u00020\u0003\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Paint", "Landroidx/compose/ui/graphics/Paint;", "makeNativePaint", "Landroid/graphics/Paint;", "getNativeAlpha", "", "Landroidx/compose/ui/graphics/NativePaint;", "getNativeAntiAlias", "", "getNativeColor", "Landroidx/compose/ui/graphics/Color;", "(Landroid/graphics/Paint;)J", "getNativeFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "(Landroid/graphics/Paint;)I", "getNativeStrokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getNativeStrokeJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getNativeStrokeMiterLimit", "getNativeStrokeWidth", "getNativeStyle", "Landroidx/compose/ui/graphics/PaintingStyle;", "setNativeAlpha", "", "value", "setNativeAntiAlias", "setNativeBlendMode", "mode", "Landroidx/compose/ui/graphics/BlendMode;", "setNativeBlendMode-GB0RdKg", "(Landroid/graphics/Paint;I)V", "setNativeColor", "setNativeColor-4WTKRHQ", "(Landroid/graphics/Paint;J)V", "setNativeColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "setNativeFilterQuality", "setNativeFilterQuality-50PEsBU", "setNativePathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "setNativeShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "setNativeStrokeCap", "setNativeStrokeCap-CSYIeUk", "setNativeStrokeJoin", "setNativeStrokeJoin-kLtJ_vA", "setNativeStrokeMiterLimit", "setNativeStrokeWidth", "setNativeStyle", "setNativeStyle--5YerkU", "toComposePaint", "NativePaint", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPaint.android.kt */
public final class AndroidPaint_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidPaint.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[Paint.Style.values().length];
            try {
                iArr[Paint.Style.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Paint.Cap.values().length];
            try {
                iArr2[Paint.Cap.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr2[Paint.Cap.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr2[Paint.Cap.SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[Paint.Join.values().length];
            try {
                iArr3[Paint.Join.MITER.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr3[Paint.Join.BEVEL.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr3[Paint.Join.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final Paint Paint() {
        return new AndroidPaint();
    }

    public static final Paint toComposePaint(Paint $this$toComposePaint) {
        Intrinsics.checkNotNullParameter($this$toComposePaint, "<this>");
        return new AndroidPaint($this$toComposePaint);
    }

    public static final Paint makeNativePaint() {
        return new Paint(7);
    }

    /* renamed from: setNativeBlendMode-GB0RdKg  reason: not valid java name */
    public static final void m3040setNativeBlendModeGB0RdKg(Paint $this$setNativeBlendMode_u2dGB0RdKg, int mode) {
        Intrinsics.checkNotNullParameter($this$setNativeBlendMode_u2dGB0RdKg, "$this$setNativeBlendMode");
        if (Build.VERSION.SDK_INT >= 29) {
            WrapperVerificationHelperMethods.INSTANCE.m3598setBlendModeGB0RdKg($this$setNativeBlendMode_u2dGB0RdKg, mode);
        } else {
            $this$setNativeBlendMode_u2dGB0RdKg.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m3008toPorterDuffModes9anfk8(mode)));
        }
    }

    public static final void setNativeColorFilter(Paint $this$setNativeColorFilter, ColorFilter value) {
        Intrinsics.checkNotNullParameter($this$setNativeColorFilter, "<this>");
        $this$setNativeColorFilter.setColorFilter(value != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(value) : null);
    }

    public static final float getNativeAlpha(Paint $this$getNativeAlpha) {
        Intrinsics.checkNotNullParameter($this$getNativeAlpha, "<this>");
        return ((float) $this$getNativeAlpha.getAlpha()) / 255.0f;
    }

    public static final void setNativeAlpha(Paint $this$setNativeAlpha, float value) {
        Intrinsics.checkNotNullParameter($this$setNativeAlpha, "<this>");
        $this$setNativeAlpha.setAlpha((int) ((float) Math.rint((double) (255.0f * value))));
    }

    public static final boolean getNativeAntiAlias(Paint $this$getNativeAntiAlias) {
        Intrinsics.checkNotNullParameter($this$getNativeAntiAlias, "<this>");
        return $this$getNativeAntiAlias.isAntiAlias();
    }

    public static final void setNativeAntiAlias(Paint $this$setNativeAntiAlias, boolean value) {
        Intrinsics.checkNotNullParameter($this$setNativeAntiAlias, "<this>");
        $this$setNativeAntiAlias.setAntiAlias(value);
    }

    public static final long getNativeColor(Paint $this$getNativeColor) {
        Intrinsics.checkNotNullParameter($this$getNativeColor, "<this>");
        return ColorKt.Color($this$getNativeColor.getColor());
    }

    /* renamed from: setNativeColor-4WTKRHQ  reason: not valid java name */
    public static final void m3041setNativeColor4WTKRHQ(Paint $this$setNativeColor_u2d4WTKRHQ, long value) {
        Intrinsics.checkNotNullParameter($this$setNativeColor_u2d4WTKRHQ, "$this$setNativeColor");
        $this$setNativeColor_u2d4WTKRHQ.setColor(ColorKt.m3218toArgb8_81llA(value));
    }

    /* renamed from: setNativeStyle--5YerkU  reason: not valid java name */
    public static final void m3045setNativeStyle5YerkU(Paint $this$setNativeStyle_u2d_u2d5YerkU, int value) {
        Paint.Style style;
        Intrinsics.checkNotNullParameter($this$setNativeStyle_u2d_u2d5YerkU, "$this$setNativeStyle");
        if (PaintingStyle.m3435equalsimpl0(value, PaintingStyle.Companion.m3440getStrokeTiuSbCo())) {
            style = Paint.Style.STROKE;
        } else {
            style = Paint.Style.FILL;
        }
        $this$setNativeStyle_u2d_u2d5YerkU.setStyle(style);
    }

    public static final int getNativeStyle(Paint $this$getNativeStyle) {
        Intrinsics.checkNotNullParameter($this$getNativeStyle, "<this>");
        Paint.Style style = $this$getNativeStyle.getStyle();
        if ((style == null ? -1 : WhenMappings.$EnumSwitchMapping$0[style.ordinal()]) == 1) {
            return PaintingStyle.Companion.m3440getStrokeTiuSbCo();
        }
        return PaintingStyle.Companion.m3439getFillTiuSbCo();
    }

    public static final float getNativeStrokeWidth(Paint $this$getNativeStrokeWidth) {
        Intrinsics.checkNotNullParameter($this$getNativeStrokeWidth, "<this>");
        return $this$getNativeStrokeWidth.getStrokeWidth();
    }

    public static final void setNativeStrokeWidth(Paint $this$setNativeStrokeWidth, float value) {
        Intrinsics.checkNotNullParameter($this$setNativeStrokeWidth, "<this>");
        $this$setNativeStrokeWidth.setStrokeWidth(value);
    }

    public static final int getNativeStrokeCap(Paint $this$getNativeStrokeCap) {
        Intrinsics.checkNotNullParameter($this$getNativeStrokeCap, "<this>");
        Paint.Cap strokeCap = $this$getNativeStrokeCap.getStrokeCap();
        switch (strokeCap == null ? -1 : WhenMappings.$EnumSwitchMapping$1[strokeCap.ordinal()]) {
            case 1:
                return StrokeCap.Companion.m3547getButtKaPHkGw();
            case 2:
                return StrokeCap.Companion.m3548getRoundKaPHkGw();
            case 3:
                return StrokeCap.Companion.m3549getSquareKaPHkGw();
            default:
                return StrokeCap.Companion.m3547getButtKaPHkGw();
        }
    }

    /* renamed from: setNativeStrokeCap-CSYIeUk  reason: not valid java name */
    public static final void m3043setNativeStrokeCapCSYIeUk(Paint $this$setNativeStrokeCap_u2dCSYIeUk, int value) {
        Paint.Cap cap;
        Intrinsics.checkNotNullParameter($this$setNativeStrokeCap_u2dCSYIeUk, "$this$setNativeStrokeCap");
        if (StrokeCap.m3543equalsimpl0(value, StrokeCap.Companion.m3549getSquareKaPHkGw())) {
            cap = Paint.Cap.SQUARE;
        } else if (StrokeCap.m3543equalsimpl0(value, StrokeCap.Companion.m3548getRoundKaPHkGw())) {
            cap = Paint.Cap.ROUND;
        } else if (StrokeCap.m3543equalsimpl0(value, StrokeCap.Companion.m3547getButtKaPHkGw())) {
            cap = Paint.Cap.BUTT;
        } else {
            cap = Paint.Cap.BUTT;
        }
        $this$setNativeStrokeCap_u2dCSYIeUk.setStrokeCap(cap);
    }

    public static final int getNativeStrokeJoin(Paint $this$getNativeStrokeJoin) {
        Intrinsics.checkNotNullParameter($this$getNativeStrokeJoin, "<this>");
        Paint.Join strokeJoin = $this$getNativeStrokeJoin.getStrokeJoin();
        switch (strokeJoin == null ? -1 : WhenMappings.$EnumSwitchMapping$2[strokeJoin.ordinal()]) {
            case 1:
                return StrokeJoin.Companion.m3558getMiterLxFBmk8();
            case 2:
                return StrokeJoin.Companion.m3557getBevelLxFBmk8();
            case 3:
                return StrokeJoin.Companion.m3559getRoundLxFBmk8();
            default:
                return StrokeJoin.Companion.m3558getMiterLxFBmk8();
        }
    }

    /* renamed from: setNativeStrokeJoin-kLtJ_vA  reason: not valid java name */
    public static final void m3044setNativeStrokeJoinkLtJ_vA(Paint $this$setNativeStrokeJoin_u2dkLtJ_vA, int value) {
        Paint.Join join;
        Intrinsics.checkNotNullParameter($this$setNativeStrokeJoin_u2dkLtJ_vA, "$this$setNativeStrokeJoin");
        if (StrokeJoin.m3553equalsimpl0(value, StrokeJoin.Companion.m3558getMiterLxFBmk8())) {
            join = Paint.Join.MITER;
        } else if (StrokeJoin.m3553equalsimpl0(value, StrokeJoin.Companion.m3557getBevelLxFBmk8())) {
            join = Paint.Join.BEVEL;
        } else if (StrokeJoin.m3553equalsimpl0(value, StrokeJoin.Companion.m3559getRoundLxFBmk8())) {
            join = Paint.Join.ROUND;
        } else {
            join = Paint.Join.MITER;
        }
        $this$setNativeStrokeJoin_u2dkLtJ_vA.setStrokeJoin(join);
    }

    public static final float getNativeStrokeMiterLimit(Paint $this$getNativeStrokeMiterLimit) {
        Intrinsics.checkNotNullParameter($this$getNativeStrokeMiterLimit, "<this>");
        return $this$getNativeStrokeMiterLimit.getStrokeMiter();
    }

    public static final void setNativeStrokeMiterLimit(Paint $this$setNativeStrokeMiterLimit, float value) {
        Intrinsics.checkNotNullParameter($this$setNativeStrokeMiterLimit, "<this>");
        $this$setNativeStrokeMiterLimit.setStrokeMiter(value);
    }

    public static final int getNativeFilterQuality(Paint $this$getNativeFilterQuality) {
        Intrinsics.checkNotNullParameter($this$getNativeFilterQuality, "<this>");
        if (!$this$getNativeFilterQuality.isFilterBitmap()) {
            return FilterQuality.Companion.m3261getNonefv9h1I();
        }
        return FilterQuality.Companion.m3259getLowfv9h1I();
    }

    /* renamed from: setNativeFilterQuality-50PEsBU  reason: not valid java name */
    public static final void m3042setNativeFilterQuality50PEsBU(Paint $this$setNativeFilterQuality_u2d50PEsBU, int value) {
        Intrinsics.checkNotNullParameter($this$setNativeFilterQuality_u2d50PEsBU, "$this$setNativeFilterQuality");
        $this$setNativeFilterQuality_u2d50PEsBU.setFilterBitmap(!FilterQuality.m3254equalsimpl0(value, FilterQuality.Companion.m3261getNonefv9h1I()));
    }

    public static final void setNativeShader(Paint $this$setNativeShader, Shader value) {
        Intrinsics.checkNotNullParameter($this$setNativeShader, "<this>");
        $this$setNativeShader.setShader(value);
    }

    public static final void setNativePathEffect(Paint $this$setNativePathEffect, PathEffect value) {
        Intrinsics.checkNotNullParameter($this$setNativePathEffect, "<this>");
        AndroidPathEffect androidPathEffect = (AndroidPathEffect) value;
        $this$setNativePathEffect.setPathEffect(androidPathEffect != null ? androidPathEffect.getNativePathEffect() : null);
    }
}
