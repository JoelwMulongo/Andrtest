package androidx.compose.ui.graphics.colorspace;

import androidx.autofill.HintConstants;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0010¢\u0006\u0002\b\u0018J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J%\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0010¢\u0006\u0002\b\u001bJ@\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006$"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Xyz;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "clamp", "", "x", "fromXyz", "", "v", "getMaxValue", "component", "getMinValue", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "y", "z", "a", "colorSpace", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Xyz.kt */
public final class Xyz extends ColorSpace {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Xyz(String name, int id) {
        super(name, ColorModel.Companion.m3610getXyzxdoWZVw(), id, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(name, HintConstants.AUTOFILL_HINT_NAME);
    }

    public boolean isWideGamut() {
        return true;
    }

    public float getMinValue(int component) {
        return -2.0f;
    }

    public float getMaxValue(int component) {
        return 2.0f;
    }

    public float[] toXyz(float[] v) {
        Intrinsics.checkNotNullParameter(v, "v");
        v[0] = clamp(v[0]);
        v[1] = clamp(v[1]);
        v[2] = clamp(v[2]);
        return v;
    }

    public long toXy$ui_graphics_release(float v0, float v1, float v2) {
        return (((long) Float.floatToIntBits(clamp(v0))) << 32) | (4294967295L & ((long) Float.floatToIntBits(clamp(v1))));
    }

    public float toZ$ui_graphics_release(float v0, float v1, float v2) {
        return clamp(v2);
    }

    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release  reason: not valid java name */
    public long m3641xyzaToColorJlNiLsg$ui_graphics_release(float x, float y, float z, float a, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        return ColorKt.Color(clamp(x), clamp(y), clamp(z), a, colorSpace);
    }

    public float[] fromXyz(float[] v) {
        Intrinsics.checkNotNullParameter(v, "v");
        v[0] = clamp(v[0]);
        v[1] = clamp(v[1]);
        v[2] = clamp(v[2]);
        return v;
    }

    private final float clamp(float x) {
        return RangesKt.coerceIn(x, -2.0f, 2.0f);
    }
}