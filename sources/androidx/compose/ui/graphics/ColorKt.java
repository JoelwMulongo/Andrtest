package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a<\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a2\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a1\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\b\u001a-\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0002\u001a!\u0010'\u001a\u00020\u0002*\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0019\u0010+\u001a\u00020,*\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0019\u0010/\u001a\u00020\f*\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a+\u00102\u001a\u00020\u0002*\u00020\u00022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000204H\bø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u0019\u00107\u001a\u00020\u0014*\u00020\u0002H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\"\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\"\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u0002\u0012\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0005\b20\u0001¨\u0006:"}, d2 = {"isSpecified", "", "Landroidx/compose/ui/graphics/Color;", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "Color", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "color", "", "(I)J", "(IIII)J", "", "(J)J", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "saturate", "v", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "toArgb", "toArgb-8_81llA", "(J)I", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Color.kt */
public final class ColorKt {
    /* renamed from: isSpecified-8_81llA$annotations  reason: not valid java name */
    public static /* synthetic */ void m3212isSpecified8_81llA$annotations(long j) {
    }

    /* renamed from: isUnspecified-8_81llA$annotations  reason: not valid java name */
    public static /* synthetic */ void m3214isUnspecified8_81llA$annotations(long j) {
    }

    public static /* synthetic */ long Color$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f2, f3, f4, colorSpace);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0161  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long Color(float r18, float r19, float r20, float r21, androidx.compose.ui.graphics.colorspace.ColorSpace r22) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            java.lang.String r5 = "colorSpace"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            r5 = 0
            float r6 = r4.getMinValue(r5)
            float r7 = r4.getMaxValue(r5)
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            r8 = 1
            if (r7 > 0) goto L_0x0023
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 > 0) goto L_0x0023
            r6 = r8
            goto L_0x0024
        L_0x0023:
            r6 = r5
        L_0x0024:
            r7 = 1065353216(0x3f800000, float:1.0)
            r9 = 0
            if (r6 == 0) goto L_0x0063
            float r6 = r4.getMinValue(r8)
            float r10 = r4.getMaxValue(r8)
            int r10 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r10 > 0) goto L_0x003b
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 > 0) goto L_0x003b
            r6 = r8
            goto L_0x003c
        L_0x003b:
            r6 = r5
        L_0x003c:
            if (r6 == 0) goto L_0x0063
            r6 = 2
            float r10 = r4.getMinValue(r6)
            float r6 = r4.getMaxValue(r6)
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x0051
            int r6 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r6 > 0) goto L_0x0051
            r6 = r8
            goto L_0x0052
        L_0x0051:
            r6 = r5
        L_0x0052:
            if (r6 == 0) goto L_0x0063
            int r6 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x005e
            int r6 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r6 > 0) goto L_0x005e
            r6 = r8
            goto L_0x005f
        L_0x005e:
            r6 = r5
        L_0x005f:
            if (r6 == 0) goto L_0x0063
            r6 = r8
            goto L_0x0064
        L_0x0063:
            r6 = r5
        L_0x0064:
            if (r6 == 0) goto L_0x0161
            boolean r6 = r22.isSrgb()
            r10 = 32
            r11 = 16
            r12 = 1056964608(0x3f000000, float:0.5)
            if (r6 == 0) goto L_0x00a5
            r5 = 1132396544(0x437f0000, float:255.0)
            float r6 = r3 * r5
            float r6 = r6 + r12
            int r6 = (int) r6
            int r6 = r6 << 24
            float r7 = r0 * r5
            float r7 = r7 + r12
            int r7 = (int) r7
            int r7 = r7 << r11
            r6 = r6 | r7
            float r7 = r1 * r5
            float r7 = r7 + r12
            int r7 = (int) r7
            int r7 = r7 << 8
            r6 = r6 | r7
            float r5 = r5 * r2
            float r5 = r5 + r12
            int r5 = (int) r5
            r5 = r5 | r6
            long r6 = (long) r5
            long r6 = kotlin.ULong.m6447constructorimpl(r6)
            r8 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r6 = r6 & r8
            long r6 = kotlin.ULong.m6447constructorimpl(r6)
            long r6 = r6 << r10
            long r6 = kotlin.ULong.m6447constructorimpl(r6)
            long r6 = androidx.compose.ui.graphics.Color.m3160constructorimpl(r6)
            return r6
        L_0x00a5:
            int r6 = r22.getComponentCount()
            r13 = 3
            if (r6 != r13) goto L_0x00ae
            r6 = r8
            goto L_0x00af
        L_0x00ae:
            r6 = r5
        L_0x00af:
            if (r6 == 0) goto L_0x0153
            int r6 = r22.getId$ui_graphics_release()
            r13 = -1
            if (r6 == r13) goto L_0x00b9
            r5 = r8
        L_0x00b9:
            if (r5 == 0) goto L_0x0145
            short r5 = androidx.compose.ui.graphics.Float16.m3267constructorimpl((float) r18)
            short r8 = androidx.compose.ui.graphics.Float16.m3267constructorimpl((float) r19)
            short r13 = androidx.compose.ui.graphics.Float16.m3267constructorimpl((float) r20)
            float r7 = java.lang.Math.min(r3, r7)
            float r7 = java.lang.Math.max(r9, r7)
            r9 = 1149222912(0x447fc000, float:1023.0)
            float r7 = r7 * r9
            float r7 = r7 + r12
            int r7 = (int) r7
            long r14 = (long) r5
            long r14 = kotlin.ULong.m6447constructorimpl(r14)
            r16 = 65535(0xffff, double:3.23786E-319)
            long r14 = r14 & r16
            long r14 = kotlin.ULong.m6447constructorimpl(r14)
            r9 = 48
            long r14 = r14 << r9
            long r14 = kotlin.ULong.m6447constructorimpl(r14)
            long r11 = (long) r8
            long r11 = kotlin.ULong.m6447constructorimpl(r11)
            long r11 = r11 & r16
            long r11 = kotlin.ULong.m6447constructorimpl(r11)
            long r10 = r11 << r10
            long r10 = kotlin.ULong.m6447constructorimpl(r10)
            long r10 = r10 | r14
            long r10 = kotlin.ULong.m6447constructorimpl(r10)
            long r14 = (long) r13
            long r14 = kotlin.ULong.m6447constructorimpl(r14)
            long r14 = r14 & r16
            long r14 = kotlin.ULong.m6447constructorimpl(r14)
            r9 = 16
            long r14 = r14 << r9
            long r14 = kotlin.ULong.m6447constructorimpl(r14)
            long r9 = r10 | r14
            long r9 = kotlin.ULong.m6447constructorimpl(r9)
            long r11 = (long) r7
            long r11 = kotlin.ULong.m6447constructorimpl(r11)
            r14 = 1023(0x3ff, double:5.054E-321)
            long r11 = r11 & r14
            long r11 = kotlin.ULong.m6447constructorimpl(r11)
            r14 = 6
            long r11 = r11 << r14
            long r11 = kotlin.ULong.m6447constructorimpl(r11)
            long r9 = r9 | r11
            long r9 = kotlin.ULong.m6447constructorimpl(r9)
            long r11 = (long) r6
            long r11 = kotlin.ULong.m6447constructorimpl(r11)
            r14 = 63
            long r11 = r11 & r14
            long r11 = kotlin.ULong.m6447constructorimpl(r11)
            long r9 = r9 | r11
            long r9 = kotlin.ULong.m6447constructorimpl(r9)
            long r9 = androidx.compose.ui.graphics.Color.m3160constructorimpl(r9)
            return r9
        L_0x0145:
            r5 = 0
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Unknown color space, please use a color space in ColorSpaces"
            java.lang.String r7 = r7.toString()
            r5.<init>(r7)
            throw r5
        L_0x0153:
            r5 = 0
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Color only works with ColorSpaces with 3 components"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L_0x0161:
            r5 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "red = "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r7 = ", green = "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r1)
            java.lang.String r7 = ", blue = "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r2)
            java.lang.String r7 = ", alpha = "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r3)
            java.lang.String r7 = " outside the range for "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r4)
            java.lang.String r5 = r6.toString()
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.Color(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static final long Color(int color) {
        return Color.m3160constructorimpl(ULong.m6447constructorimpl(ULong.m6447constructorimpl((long) color) << 32));
    }

    public static final long Color(long color) {
        return Color.m3160constructorimpl(ULong.m6447constructorimpl(ULong.m6447constructorimpl(ULong.m6447constructorimpl(color) & 4294967295L) << 32));
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    public static final long Color(int red, int green, int blue, int alpha) {
        return Color(((alpha & 255) << 24) | ((red & 255) << 16) | ((green & 255) << 8) | (blue & 255));
    }

    /* renamed from: lerp-jxsXWHM  reason: not valid java name */
    public static final long m3215lerpjxsXWHM(long start, long stop, float fraction) {
        float f = fraction;
        ColorSpace colorSpace = ColorSpaces.INSTANCE.getOklab();
        long startColor = Color.m3161convertvNxB06k(start, colorSpace);
        long endColor = Color.m3161convertvNxB06k(stop, colorSpace);
        float startAlpha = Color.m3166getAlphaimpl(startColor);
        float startL = Color.m3170getRedimpl(startColor);
        float startA = Color.m3169getGreenimpl(startColor);
        float startB = Color.m3167getBlueimpl(startColor);
        float endAlpha = Color.m3166getAlphaimpl(endColor);
        float endL = Color.m3170getRedimpl(endColor);
        float endA = Color.m3169getGreenimpl(endColor);
        float endB = Color.m3167getBlueimpl(endColor);
        long j = startColor;
        return Color.m3161convertvNxB06k(Color(MathHelpersKt.lerp(startL, endL, f), MathHelpersKt.lerp(startA, endA, f), MathHelpersKt.lerp(startB, endB, f), MathHelpersKt.lerp(startAlpha, endAlpha, f), colorSpace), Color.m3168getColorSpaceimpl(stop));
    }

    /* renamed from: compositeOver--OWjLjI  reason: not valid java name */
    public static final long m3209compositeOverOWjLjI(long $this$compositeOver_u2d_u2dOWjLjI, long background) {
        long fg = Color.m3161convertvNxB06k($this$compositeOver_u2d_u2dOWjLjI, Color.m3168getColorSpaceimpl(background));
        float bgA = Color.m3166getAlphaimpl(background);
        float fgA = Color.m3166getAlphaimpl(fg);
        float a = ((1.0f - fgA) * bgA) + fgA;
        float b = 0.0f;
        boolean z = true;
        float r = (a > 0.0f ? 1 : (a == 0.0f ? 0 : -1)) == 0 ? 0.0f : ((Color.m3170getRedimpl(fg) * fgA) + ((Color.m3170getRedimpl(background) * bgA) * (1.0f - fgA))) / a;
        float fgC$iv = (a > 0.0f ? 1 : (a == 0.0f ? 0 : -1)) == 0 ? 0.0f : ((Color.m3169getGreenimpl(fg) * fgA) + ((Color.m3169getGreenimpl(background) * bgA) * (1.0f - fgA))) / a;
        float fgC$iv2 = Color.m3167getBlueimpl(fg);
        float bgC$iv = Color.m3167getBlueimpl(background);
        if (a != 0.0f) {
            z = false;
        }
        if (!z) {
            b = ((fgC$iv2 * fgA) + ((bgC$iv * bgA) * (1.0f - fgA))) / a;
        }
        return Color(r, fgC$iv, b, a, Color.m3168getColorSpaceimpl(background));
    }

    private static final float compositeComponent(float fgC, float bgC, float fgA, float bgA, float a) {
        if (a == 0.0f) {
            return 0.0f;
        }
        return ((fgC * fgA) + ((bgC * bgA) * (1.0f - fgA))) / a;
    }

    /* renamed from: getComponents-8_81llA  reason: not valid java name */
    private static final float[] m3210getComponents8_81llA(long $this$getComponents_u2d8_81llA) {
        return new float[]{Color.m3170getRedimpl($this$getComponents_u2d8_81llA), Color.m3169getGreenimpl($this$getComponents_u2d8_81llA), Color.m3167getBlueimpl($this$getComponents_u2d8_81llA), Color.m3166getAlphaimpl($this$getComponents_u2d8_81llA)};
    }

    /* renamed from: luminance-8_81llA  reason: not valid java name */
    public static final float m3216luminance8_81llA(long $this$luminance_u2d8_81llA) {
        ColorSpace colorSpace = Color.m3168getColorSpaceimpl($this$luminance_u2d8_81llA);
        if (ColorModel.m3602equalsimpl0(colorSpace.m3611getModelxdoWZVw(), ColorModel.Companion.m3609getRgbxdoWZVw())) {
            Intrinsics.checkNotNull(colorSpace, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            DoubleFunction eotf = ((Rgb) colorSpace).getEotfFunc$ui_graphics_release();
            return saturate((float) ((0.2126d * eotf.invoke((double) Color.m3170getRedimpl($this$luminance_u2d8_81llA))) + (0.7152d * eotf.invoke((double) Color.m3169getGreenimpl($this$luminance_u2d8_81llA))) + (0.0722d * eotf.invoke((double) Color.m3167getBlueimpl($this$luminance_u2d8_81llA)))));
        }
        throw new IllegalArgumentException(("The specified color must be encoded in an RGB color space. The supplied color space is " + ColorModel.m3605toStringimpl(colorSpace.m3611getModelxdoWZVw())).toString());
    }

    private static final float saturate(float v) {
        if (v <= 0.0f) {
            return 0.0f;
        }
        if (v >= 1.0f) {
            return 1.0f;
        }
        return v;
    }

    /* renamed from: toArgb-8_81llA  reason: not valid java name */
    public static final int m3218toArgb8_81llA(long $this$toArgb_u2d8_81llA) {
        return (int) ULong.m6447constructorimpl(Color.m3161convertvNxB06k($this$toArgb_u2d8_81llA, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }

    /* renamed from: isSpecified-8_81llA  reason: not valid java name */
    public static final boolean m3211isSpecified8_81llA(long $this$isSpecified) {
        return $this$isSpecified != Color.Companion.m3200getUnspecified0d7_KjU();
    }

    /* renamed from: isUnspecified-8_81llA  reason: not valid java name */
    public static final boolean m3213isUnspecified8_81llA(long $this$isUnspecified) {
        return $this$isUnspecified == Color.Companion.m3200getUnspecified0d7_KjU();
    }

    /* renamed from: takeOrElse-DxMtmZc  reason: not valid java name */
    public static final long m3217takeOrElseDxMtmZc(long $this$takeOrElse_u2dDxMtmZc, Function0<Color> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return ($this$takeOrElse_u2dDxMtmZc > Color.Companion.m3200getUnspecified0d7_KjU() ? 1 : ($this$takeOrElse_u2dDxMtmZc == Color.Companion.m3200getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? $this$takeOrElse_u2dDxMtmZc : block.invoke().m3174unboximpl();
    }
}
