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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B2\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\u000b\u001a\u00060\fj\u0002`\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/graphics/SweepGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "center", "Landroidx/compose/ui/geometry/Offset;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "(JLjava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "Landroidx/compose/ui/geometry/Size;", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Brush.kt */
public final class SweepGradient extends ShaderBrush {
    private final long center;
    private final List<Color> colors;
    private final List<Float> stops;

    public /* synthetic */ SweepGradient(long j, List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, list, list2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SweepGradient(long r7, java.util.List r9, java.util.List r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r6 = this;
            r11 = r11 & 4
            if (r11 == 0) goto L_0x0007
            r10 = 0
            r4 = r10
            goto L_0x0008
        L_0x0007:
            r4 = r10
        L_0x0008:
            r5 = 0
            r0 = r6
            r1 = r7
            r3 = r9
            r0.<init>(r1, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.SweepGradient.<init>(long, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private SweepGradient(long center2, List<Color> colors2, List<Float> stops2) {
        this.center = center2;
        this.colors = colors2;
        this.stops = stops2;
    }

    /* renamed from: createShader-uvyYCjk  reason: not valid java name */
    public Shader m3560createShaderuvyYCjk(long size) {
        long j;
        if (OffsetKt.m2936isUnspecifiedk4lQ0M(this.center)) {
            j = SizeKt.m2994getCenteruvyYCjk(size);
        } else {
            boolean z = true;
            float r0 = (Offset.m2915getXimpl(this.center) > Float.POSITIVE_INFINITY ? 1 : (Offset.m2915getXimpl(this.center) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m2984getWidthimpl(size) : Offset.m2915getXimpl(this.center);
            if (Offset.m2916getYimpl(this.center) != Float.POSITIVE_INFINITY) {
                z = false;
            }
            j = OffsetKt.Offset(r0, z ? Size.m2981getHeightimpl(size) : Offset.m2916getYimpl(this.center));
        }
        return ShaderKt.m3510SweepGradientShader9KIMszo(j, this.colors, this.stops);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof SweepGradient) && Offset.m2912equalsimpl0(this.center, ((SweepGradient) other).center) && Intrinsics.areEqual((Object) this.colors, (Object) ((SweepGradient) other).colors) && Intrinsics.areEqual((Object) this.stops, (Object) ((SweepGradient) other).stops)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = ((Offset.m2917hashCodeimpl(this.center) * 31) + this.colors.hashCode()) * 31;
        List<Float> list = this.stops;
        return result + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "SweepGradient(" + (OffsetKt.m2934isSpecifiedk4lQ0M(this.center) ? "center=" + Offset.m2923toStringimpl(this.center) + ", " : "") + "colors=" + this.colors + ", stops=" + this.stops + ')';
    }
}
