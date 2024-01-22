package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BD\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0019\u0010\u0007\u001a\u00020\bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u00020\u000f8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\u00020\u000bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0012\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/ui/graphics/RadialGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "center", "Landroidx/compose/ui/geometry/Offset;", "radius", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "(Ljava/util/List;Ljava/util/List;JFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Brush.kt */
public final class RadialGradient extends ShaderBrush {
    private final long center;
    private final List<Color> colors;
    private final float radius;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ RadialGradient(List list, List list2, long j, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j, f, i);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RadialGradient(java.util.List r10, java.util.List r11, long r12, float r14, int r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 2
            if (r0 == 0) goto L_0x0007
            r0 = 0
            r3 = r0
            goto L_0x0008
        L_0x0007:
            r3 = r11
        L_0x0008:
            r0 = r16 & 16
            if (r0 == 0) goto L_0x0014
            androidx.compose.ui.graphics.TileMode$Companion r0 = androidx.compose.ui.graphics.TileMode.Companion
            int r0 = r0.m3568getClamp3opZhB0()
            r7 = r0
            goto L_0x0015
        L_0x0014:
            r7 = r15
        L_0x0015:
            r8 = 0
            r1 = r9
            r2 = r10
            r4 = r12
            r6 = r14
            r1.<init>(r2, r3, r4, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.RadialGradient.<init>(java.util.List, java.util.List, long, float, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private RadialGradient(List<Color> colors2, List<Float> stops2, long center2, float radius2, int tileMode2) {
        this.colors = colors2;
        this.stops = stops2;
        this.center = center2;
        this.radius = radius2;
        this.tileMode = tileMode2;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public long m3485getIntrinsicSizeNHjbRc() {
        float f = this.radius;
        if (!(!Float.isInfinite(f) && !Float.isNaN(f))) {
            return Size.Companion.m2992getUnspecifiedNHjbRc();
        }
        float f2 = this.radius;
        float f3 = (float) 2;
        return SizeKt.Size(f2 * f3, f2 * f3);
    }

    /* renamed from: createShader-uvyYCjk  reason: not valid java name */
    public Shader m3484createShaderuvyYCjk(long size) {
        float centerY;
        float centerX;
        boolean z = true;
        if (OffsetKt.m2936isUnspecifiedk4lQ0M(this.center)) {
            long drawCenter = SizeKt.m2994getCenteruvyYCjk(size);
            centerX = Offset.m2915getXimpl(drawCenter);
            centerY = Offset.m2916getYimpl(drawCenter);
        } else {
            centerX = (Offset.m2915getXimpl(this.center) > Float.POSITIVE_INFINITY ? 1 : (Offset.m2915getXimpl(this.center) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m2984getWidthimpl(size) : Offset.m2915getXimpl(this.center);
            centerY = (Offset.m2916getYimpl(this.center) > Float.POSITIVE_INFINITY ? 1 : (Offset.m2916getYimpl(this.center) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m2981getHeightimpl(size) : Offset.m2916getYimpl(this.center);
        }
        List<Color> list = this.colors;
        List<Float> list2 = this.stops;
        long Offset = OffsetKt.Offset(centerX, centerY);
        float f = this.radius;
        if (f != Float.POSITIVE_INFINITY) {
            z = false;
        }
        if (z) {
            f = Size.m2983getMinDimensionimpl(size) / ((float) 2);
        }
        return ShaderKt.m3508RadialGradientShader8uybcMk(Offset, f, list, list2, this.tileMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RadialGradient) || !Intrinsics.areEqual((Object) this.colors, (Object) ((RadialGradient) other).colors) || !Intrinsics.areEqual((Object) this.stops, (Object) ((RadialGradient) other).stops) || !Offset.m2912equalsimpl0(this.center, ((RadialGradient) other).center)) {
            return false;
        }
        if ((this.radius == ((RadialGradient) other).radius) && TileMode.m3564equalsimpl0(this.tileMode, ((RadialGradient) other).tileMode)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        return ((((((hashCode + (list != null ? list.hashCode() : 0)) * 31) + Offset.m2917hashCodeimpl(this.center)) * 31) + Float.hashCode(this.radius)) * 31) + TileMode.m3565hashCodeimpl(this.tileMode);
    }

    public String toString() {
        String radiusValue = "";
        String centerValue = OffsetKt.m2934isSpecifiedk4lQ0M(this.center) ? "center=" + Offset.m2923toStringimpl(this.center) + ", " : radiusValue;
        float f = this.radius;
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            radiusValue = "radius=" + this.radius + ", ";
        }
        return "RadialGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + centerValue + radiusValue + "tileMode=" + TileMode.m3566toStringimpl(this.tileMode) + ')';
    }
}
