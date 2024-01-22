package androidx.compose.ui.graphics;

import android.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B.\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\b\u0010\n\u001a\u00020\u000bH\u0015J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0019\u0010\u0006\u001a\u00020\u0007X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/graphics/BlurEffect;", "Landroidx/compose/ui/graphics/RenderEffect;", "renderEffect", "radiusX", "", "radiusY", "edgeTreatment", "Landroidx/compose/ui/graphics/TileMode;", "(Landroidx/compose/ui/graphics/RenderEffect;FFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "createRenderEffect", "Landroid/graphics/RenderEffect;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidRenderEffect.android.kt */
public final class BlurEffect extends RenderEffect {
    private final int edgeTreatment;
    private final float radiusX;
    private final float radiusY;
    private final RenderEffect renderEffect;

    public /* synthetic */ BlurEffect(RenderEffect renderEffect2, float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(renderEffect2, f, f2, i);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BlurEffect(androidx.compose.ui.graphics.RenderEffect r7, float r8, float r9, int r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r6 = this;
            r12 = r11 & 4
            if (r12 == 0) goto L_0x0006
            r3 = r8
            goto L_0x0007
        L_0x0006:
            r3 = r9
        L_0x0007:
            r9 = r11 & 8
            if (r9 == 0) goto L_0x0013
            androidx.compose.ui.graphics.TileMode$Companion r9 = androidx.compose.ui.graphics.TileMode.Companion
            int r10 = r9.m3568getClamp3opZhB0()
            r4 = r10
            goto L_0x0014
        L_0x0013:
            r4 = r10
        L_0x0014:
            r5 = 0
            r0 = r6
            r1 = r7
            r2 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.BlurEffect.<init>(androidx.compose.ui.graphics.RenderEffect, float, float, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private BlurEffect(RenderEffect renderEffect2, float radiusX2, float radiusY2, int edgeTreatment2) {
        super((DefaultConstructorMarker) null);
        this.renderEffect = renderEffect2;
        this.radiusX = radiusX2;
        this.radiusY = radiusY2;
        this.edgeTreatment = edgeTreatment2;
    }

    /* access modifiers changed from: protected */
    public RenderEffect createRenderEffect() {
        return RenderEffectVerificationHelper.INSTANCE.m3490createBlurEffect8A3gB4(this.renderEffect, this.radiusX, this.radiusY, this.edgeTreatment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlurEffect)) {
            return false;
        }
        if (!(this.radiusX == ((BlurEffect) other).radiusX)) {
            return false;
        }
        if ((this.radiusY == ((BlurEffect) other).radiusY) && TileMode.m3564equalsimpl0(this.edgeTreatment, ((BlurEffect) other).edgeTreatment) && Intrinsics.areEqual((Object) this.renderEffect, (Object) ((BlurEffect) other).renderEffect)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        RenderEffect renderEffect2 = this.renderEffect;
        return ((((((renderEffect2 != null ? renderEffect2.hashCode() : 0) * 31) + Float.hashCode(this.radiusX)) * 31) + Float.hashCode(this.radiusY)) * 31) + TileMode.m3565hashCodeimpl(this.edgeTreatment);
    }

    public String toString() {
        return "BlurEffect(renderEffect=" + this.renderEffect + ", radiusX=" + this.radiusX + ", radiusY=" + this.radiusY + ", edgeTreatment=" + TileMode.m3566toStringimpl(this.edgeTreatment) + ')';
    }
}
