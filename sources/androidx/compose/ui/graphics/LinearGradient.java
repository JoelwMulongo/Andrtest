package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BD\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\u00020\bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u001d\u0010\u000e\u001a\u00020\u000f8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\u00020\u000bX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0012\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/ui/graphics/LinearGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "(Ljava/util/List;Ljava/util/List;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Brush.kt */
public final class LinearGradient extends ShaderBrush {
    private final List<Color> colors;
    private final long end;
    private final long start;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j, j2, i);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LinearGradient(java.util.List r11, java.util.List r12, long r13, long r15, int r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r10 = this;
            r0 = r18 & 2
            if (r0 == 0) goto L_0x0007
            r0 = 0
            r3 = r0
            goto L_0x0008
        L_0x0007:
            r3 = r12
        L_0x0008:
            r0 = r18 & 16
            if (r0 == 0) goto L_0x0014
            androidx.compose.ui.graphics.TileMode$Companion r0 = androidx.compose.ui.graphics.TileMode.Companion
            int r0 = r0.m3568getClamp3opZhB0()
            r8 = r0
            goto L_0x0016
        L_0x0014:
            r8 = r17
        L_0x0016:
            r9 = 0
            r1 = r10
            r2 = r11
            r4 = r13
            r6 = r15
            r1.<init>(r2, r3, r4, r6, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.LinearGradient.<init>(java.util.List, java.util.List, long, long, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private LinearGradient(List<Color> colors2, List<Float> stops2, long start2, long end2, int tileMode2) {
        this.colors = colors2;
        this.stops = stops2;
        this.start = start2;
        this.end = end2;
        this.tileMode = tileMode2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005c  */
    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m3388getIntrinsicSizeNHjbRc() {
        /*
            r6 = this;
            long r0 = r6.start
            float r0 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r0)
            boolean r1 = java.lang.Float.isInfinite(r0)
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0016
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x0016
            r0 = r2
            goto L_0x0017
        L_0x0016:
            r0 = r3
        L_0x0017:
            r1 = 2143289344(0x7fc00000, float:NaN)
            if (r0 == 0) goto L_0x0044
            long r4 = r6.end
            float r0 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r4)
            boolean r4 = java.lang.Float.isInfinite(r0)
            if (r4 != 0) goto L_0x002f
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L_0x002f
            r0 = r2
            goto L_0x0030
        L_0x002f:
            r0 = r3
        L_0x0030:
            if (r0 == 0) goto L_0x0044
            long r4 = r6.start
            float r0 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r4)
            long r4 = r6.end
            float r4 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r4)
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            goto L_0x0045
        L_0x0044:
            r0 = r1
        L_0x0045:
            long r4 = r6.start
            float r4 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r4)
            boolean r5 = java.lang.Float.isInfinite(r4)
            if (r5 != 0) goto L_0x0059
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 != 0) goto L_0x0059
            r4 = r2
            goto L_0x005a
        L_0x0059:
            r4 = r3
        L_0x005a:
            if (r4 == 0) goto L_0x0083
            long r4 = r6.end
            float r4 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r4)
            boolean r5 = java.lang.Float.isInfinite(r4)
            if (r5 != 0) goto L_0x006f
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 != 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = r3
        L_0x0070:
            if (r2 == 0) goto L_0x0083
            long r1 = r6.start
            float r1 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r1)
            long r2 = r6.end
            float r2 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r2)
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
        L_0x0083:
            long r0 = androidx.compose.ui.geometry.SizeKt.Size(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.LinearGradient.m3388getIntrinsicSizeNHjbRc():long");
    }

    /* renamed from: createShader-uvyYCjk  reason: not valid java name */
    public Shader m3387createShaderuvyYCjk(long size) {
        boolean z = true;
        float startX = (Offset.m2915getXimpl(this.start) > Float.POSITIVE_INFINITY ? 1 : (Offset.m2915getXimpl(this.start) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m2984getWidthimpl(size) : Offset.m2915getXimpl(this.start);
        float startY = (Offset.m2916getYimpl(this.start) > Float.POSITIVE_INFINITY ? 1 : (Offset.m2916getYimpl(this.start) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m2981getHeightimpl(size) : Offset.m2916getYimpl(this.start);
        float endX = (Offset.m2915getXimpl(this.end) > Float.POSITIVE_INFINITY ? 1 : (Offset.m2915getXimpl(this.end) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m2984getWidthimpl(size) : Offset.m2915getXimpl(this.end);
        if (Offset.m2916getYimpl(this.end) != Float.POSITIVE_INFINITY) {
            z = false;
        }
        return ShaderKt.m3506LinearGradientShaderVjE6UOU(OffsetKt.Offset(startX, startY), OffsetKt.Offset(endX, z ? Size.m2981getHeightimpl(size) : Offset.m2916getYimpl(this.end)), this.colors, this.stops, this.tileMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof LinearGradient) && Intrinsics.areEqual((Object) this.colors, (Object) ((LinearGradient) other).colors) && Intrinsics.areEqual((Object) this.stops, (Object) ((LinearGradient) other).stops) && Offset.m2912equalsimpl0(this.start, ((LinearGradient) other).start) && Offset.m2912equalsimpl0(this.end, ((LinearGradient) other).end) && TileMode.m3564equalsimpl0(this.tileMode, ((LinearGradient) other).tileMode)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        return ((((((hashCode + (list != null ? list.hashCode() : 0)) * 31) + Offset.m2917hashCodeimpl(this.start)) * 31) + Offset.m2917hashCodeimpl(this.end)) * 31) + TileMode.m3565hashCodeimpl(this.tileMode);
    }

    public String toString() {
        String endValue = "";
        String startValue = OffsetKt.m2932isFinitek4lQ0M(this.start) ? "start=" + Offset.m2923toStringimpl(this.start) + ", " : endValue;
        if (OffsetKt.m2932isFinitek4lQ0M(this.end)) {
            endValue = "end=" + Offset.m2923toStringimpl(this.end) + ", ";
        }
        return "LinearGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + startValue + endValue + "tileMode=" + TileMode.m3566toStringimpl(this.tileMode) + ')';
    }
}
