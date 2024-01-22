package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"invertTo", "", "Landroidx/compose/ui/graphics/Matrix;", "other", "invertTo-JiSxe2E", "([F[F)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: InvertMatrix.kt */
public final class InvertMatrixKt {
    /* renamed from: invertTo-JiSxe2E  reason: not valid java name */
    public static final boolean m5238invertToJiSxe2E(float[] $this$invertTo_u2dJiSxe2E, float[] other) {
        float[] fArr = $this$invertTo_u2dJiSxe2E;
        float[] fArr2 = other;
        Intrinsics.checkNotNullParameter(fArr, "$this$invertTo");
        Intrinsics.checkNotNullParameter(fArr2, "other");
        float a00 = fArr[(0 * 4) + 0];
        float a01 = fArr[(0 * 4) + 1];
        float a02 = fArr[(0 * 4) + 2];
        float a03 = fArr[(0 * 4) + 3];
        float a10 = fArr[(1 * 4) + 0];
        float a11 = fArr[(1 * 4) + 1];
        float a12 = fArr[(1 * 4) + 2];
        float a13 = fArr[(1 * 4) + 3];
        float a20 = fArr[(2 * 4) + 0];
        float a21 = fArr[(2 * 4) + 1];
        float a22 = fArr[(2 * 4) + 2];
        float a23 = fArr[(2 * 4) + 3];
        float a30 = fArr[(3 * 4) + 0];
        float a31 = fArr[(3 * 4) + 1];
        float a32 = fArr[(3 * 4) + 2];
        float a33 = fArr[(3 * 4) + 3];
        float b00 = (a00 * a11) - (a01 * a10);
        float b01 = (a00 * a12) - (a02 * a10);
        float b02 = (a00 * a13) - (a03 * a10);
        float b03 = (a01 * a12) - (a02 * a11);
        float b04 = (a01 * a13) - (a03 * a11);
        float b05 = (a02 * a13) - (a03 * a12);
        float b06 = (a20 * a31) - (a21 * a30);
        float b07 = (a20 * a32) - (a22 * a30);
        float b08 = (a20 * a33) - (a23 * a30);
        float b09 = (a21 * a32) - (a22 * a31);
        float b10 = (a21 * a33) - (a23 * a31);
        float b11 = (a22 * a33) - (a23 * a32);
        float det = (((((b00 * b11) - (b01 * b10)) + (b02 * b09)) + (b03 * b08)) - (b04 * b07)) + (b05 * b06);
        if (det == 0.0f) {
            return false;
        }
        float invDet = 1.0f / det;
        fArr2[(0 * 4) + 0] = (((a11 * b11) - (a12 * b10)) + (a13 * b09)) * invDet;
        fArr2[(0 * 4) + 1] = ((((-a01) * b11) + (a02 * b10)) - (a03 * b09)) * invDet;
        fArr2[(0 * 4) + 2] = (((a31 * b05) - (a32 * b04)) + (a33 * b03)) * invDet;
        float a312 = a31;
        fArr2[(0 * 4) + 3] = ((((-a21) * b05) + (a22 * b04)) - (a23 * b03)) * invDet;
        float a212 = a21;
        fArr2[(1 * 4) + 0] = ((((-a10) * b11) + (a12 * b08)) - (a13 * b07)) * invDet;
        fArr2[(1 * 4) + 1] = (((a00 * b11) - (a02 * b08)) + (a03 * b07)) * invDet;
        fArr2[(1 * 4) + 2] = ((((-a30) * b05) + (a32 * b02)) - (a33 * b01)) * invDet;
        fArr2[(1 * 4) + 3] = (((a20 * b05) - (a22 * b02)) + (a23 * b01)) * invDet;
        fArr2[(2 * 4) + 0] = (((a10 * b10) - (a11 * b08)) + (a13 * b06)) * invDet;
        fArr2[(2 * 4) + 1] = ((((-a00) * b10) + (a01 * b08)) - (a03 * b06)) * invDet;
        fArr2[(2 * 4) + 2] = (((a30 * b04) - (a312 * b02)) + (a33 * b00)) * invDet;
        fArr2[(2 * 4) + 3] = ((((-a20) * b04) + (a212 * b02)) - (a23 * b00)) * invDet;
        fArr2[(3 * 4) + 0] = ((((-a10) * b09) + (a11 * b07)) - (a12 * b06)) * invDet;
        fArr2[(3 * 4) + 1] = (((a00 * b09) - (a01 * b07)) + (a02 * b06)) * invDet;
        fArr2[(3 * 4) + 2] = ((((-a30) * b03) + (a312 * b01)) - (a32 * b00)) * invDet;
        fArr2[(3 * 4) + 3] = (((a20 * b03) - (a212 * b01)) + (a22 * b00)) * invDet;
        return true;
    }
}
