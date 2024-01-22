package androidx.compose.ui.graphics.colorspace;

import androidx.autofill.HintConstants;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J%\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J%\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0010¢\u0006\u0002\b\u0019J@\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b!\u0010\"R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006$"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "fromXyz", "", "v", "getMaxValue", "", "component", "getMinValue", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Lab.kt */
public final class Lab extends ColorSpace {
    private static final float A = 0.008856452f;
    private static final float B = 7.787037f;
    private static final float C = 0.13793103f;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float D = 0.20689656f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Lab(String name, int id) {
        super(name, ColorModel.Companion.m3608getLabxdoWZVw(), id, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(name, HintConstants.AUTOFILL_HINT_NAME);
    }

    public boolean isWideGamut() {
        return true;
    }

    public float getMinValue(int component) {
        return component == 0 ? 0.0f : -128.0f;
    }

    public float getMaxValue(int component) {
        return component == 0 ? 100.0f : 128.0f;
    }

    public float[] toXyz(float[] v) {
        Intrinsics.checkNotNullParameter(v, "v");
        v[0] = RangesKt.coerceIn(v[0], 0.0f, 100.0f);
        v[1] = RangesKt.coerceIn(v[1], -128.0f, 128.0f);
        v[2] = RangesKt.coerceIn(v[2], -128.0f, 128.0f);
        float fy = (v[0] + 16.0f) / 116.0f;
        float fx = (v[1] * 0.002f) + fy;
        float fz = fy - (v[2] * 0.005f);
        float x = fx > D ? fx * fx * fx : (fx - C) * 0.12841855f;
        float y = fy > D ? fy * fy * fy : (fy - C) * 0.12841855f;
        float z = fz > D ? fz * fz * fz : (fz - C) * 0.12841855f;
        v[0] = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[0] * x;
        v[1] = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[1] * y;
        v[2] = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2] * z;
        return v;
    }

    public long toXy$ui_graphics_release(float v0, float v1, float v2) {
        float f = v0;
        float fy = (16.0f + RangesKt.coerceIn(f, 0.0f, 100.0f)) / 116.0f;
        float fx = (0.002f * RangesKt.coerceIn(f, -128.0f, 128.0f)) + fy;
        return (((long) Float.floatToIntBits(Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[0] * (fx > D ? (fx * fx) * fx : (fx - C) * 0.12841855f))) << 32) | (((long) Float.floatToIntBits(Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[1] * (fy > D ? fy * fy * fy : (fy - C) * 0.12841855f))) & 4294967295L);
    }

    public float toZ$ui_graphics_release(float v0, float v1, float v2) {
        float fz = ((16.0f + RangesKt.coerceIn(v0, 0.0f, 100.0f)) / 116.0f) - (0.005f * RangesKt.coerceIn(v2, -128.0f, 128.0f));
        return Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2] * (fz > D ? fz * fz * fz : (fz - C) * 0.12841855f);
    }

    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release  reason: not valid java name */
    public long m3622xyzaToColorJlNiLsg$ui_graphics_release(float x, float y, float z, float a, ColorSpace colorSpace) {
        ColorSpace colorSpace2 = colorSpace;
        Intrinsics.checkNotNullParameter(colorSpace2, "colorSpace");
        float x1 = x / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[0];
        float y1 = y / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[1];
        float z1 = z / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
        float fx = x1 > A ? (float) Math.pow((double) x1, (double) 0.33333334f) : (x1 * B) + C;
        float fy = y1 > A ? (float) Math.pow((double) y1, (double) 0.33333334f) : (y1 * B) + C;
        return ColorKt.Color(RangesKt.coerceIn((116.0f * fy) - 16.0f, 0.0f, 100.0f), RangesKt.coerceIn((fx - fy) * 500.0f, -128.0f, 128.0f), RangesKt.coerceIn((fy - (z1 > A ? (float) Math.pow((double) z1, (double) 0.33333334f) : (B * z1) + C)) * 200.0f, -128.0f, 128.0f), a, colorSpace2);
    }

    public float[] fromXyz(float[] v) {
        float[] fArr = v;
        Intrinsics.checkNotNullParameter(fArr, "v");
        float x = fArr[0] / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[0];
        float y = fArr[1] / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[1];
        float z = fArr[2] / Illuminant.INSTANCE.getD50Xyz$ui_graphics_release()[2];
        float fx = x > A ? (float) Math.pow((double) x, (double) 0.33333334f) : (x * B) + C;
        float fy = y > A ? (float) Math.pow((double) y, (double) 0.33333334f) : (y * B) + C;
        float fz = z > A ? (float) Math.pow((double) z, (double) 0.33333334f) : (B * z) + C;
        fArr[0] = RangesKt.coerceIn((116.0f * fy) - 16.0f, 0.0f, 100.0f);
        fArr[1] = RangesKt.coerceIn((fx - fy) * 500.0f, -128.0f, 128.0f);
        fArr[2] = RangesKt.coerceIn((fy - fz) * 200.0f, -128.0f, 128.0f);
        return fArr;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Lab$Companion;", "", "()V", "A", "", "B", "C", "D", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Lab.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
