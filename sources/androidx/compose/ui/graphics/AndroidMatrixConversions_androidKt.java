package androidx.compose.ui.graphics;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\t"}, d2 = {"setFrom", "", "Landroid/graphics/Matrix;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "setFrom-EL8BTi8", "(Landroid/graphics/Matrix;[F)V", "setFrom-tU-YjHk", "([FLandroid/graphics/Matrix;)V", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidMatrixConversions.android.kt */
public final class AndroidMatrixConversions_androidKt {
    /* renamed from: setFrom-tU-YjHk  reason: not valid java name */
    public static final void m3027setFromtUYjHk(float[] $this$setFrom_u2dtU_u2dYjHk, Matrix matrix) {
        Matrix matrix2 = matrix;
        Intrinsics.checkNotNullParameter($this$setFrom_u2dtU_u2dYjHk, "$this$setFrom");
        Intrinsics.checkNotNullParameter(matrix2, "matrix");
        float[] v = $this$setFrom_u2dtU_u2dYjHk;
        matrix2.getValues(v);
        float scaleX = v[0];
        float skewX = v[1];
        float translateX = v[2];
        float skewY = v[3];
        float scaleY = v[4];
        float translateY = v[5];
        float persp0 = v[6];
        float persp1 = v[7];
        float persp2 = v[8];
        v[0] = scaleX;
        v[1] = skewY;
        v[2] = 0.0f;
        v[3] = persp0;
        v[4] = skewX;
        v[5] = scaleY;
        v[6] = 0.0f;
        v[7] = persp1;
        v[8] = 0.0f;
        v[9] = 0.0f;
        v[10] = 1.0f;
        v[11] = 0.0f;
        v[12] = translateX;
        v[13] = translateY;
        v[14] = 0.0f;
        v[15] = persp2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e6  */
    /* renamed from: setFrom-EL8BTi8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m3026setFromEL8BTi8(android.graphics.Matrix r24, float[] r25) {
        /*
            r0 = r24
            r1 = r25
            java.lang.String r2 = "$this$setFrom"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "matrix"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = 0
            r3 = 2
            r4 = 0
            int r5 = r2 * 4
            int r5 = r5 + r3
            r2 = r1[r5]
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            r4 = 1
            r5 = 0
            if (r2 != 0) goto L_0x0020
            r2 = r4
            goto L_0x0021
        L_0x0020:
            r2 = r5
        L_0x0021:
            if (r2 == 0) goto L_0x008d
            r2 = 1
            r6 = 2
            r7 = 0
            int r8 = r2 * 4
            int r8 = r8 + r6
            r2 = r1[r8]
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x0031
            r2 = r4
            goto L_0x0032
        L_0x0031:
            r2 = r5
        L_0x0032:
            if (r2 == 0) goto L_0x008d
            r2 = 2
            r6 = 2
            r7 = 0
            int r8 = r2 * 4
            int r8 = r8 + r6
            r2 = r1[r8]
            r6 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x0044
            r2 = r4
            goto L_0x0045
        L_0x0044:
            r2 = r5
        L_0x0045:
            if (r2 == 0) goto L_0x008d
            r2 = 3
            r6 = 2
            r7 = 0
            int r8 = r2 * 4
            int r8 = r8 + r6
            r2 = r1[r8]
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x0055
            r2 = r4
            goto L_0x0056
        L_0x0055:
            r2 = r5
        L_0x0056:
            if (r2 == 0) goto L_0x008d
            r2 = 2
            r6 = 0
            r7 = 0
            int r8 = r2 * 4
            int r8 = r8 + r6
            r2 = r1[r8]
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x0066
            r2 = r4
            goto L_0x0067
        L_0x0066:
            r2 = r5
        L_0x0067:
            if (r2 == 0) goto L_0x008d
            r2 = 2
            r6 = 1
            r7 = 0
            int r8 = r2 * 4
            int r8 = r8 + r6
            r2 = r1[r8]
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x0077
            r2 = r4
            goto L_0x0078
        L_0x0077:
            r2 = r5
        L_0x0078:
            if (r2 == 0) goto L_0x008d
            r2 = 2
            r6 = 3
            r7 = 0
            int r8 = r2 * 4
            int r8 = r8 + r6
            r2 = r1[r8]
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x0088
            r2 = r4
            goto L_0x0089
        L_0x0088:
            r2 = r5
        L_0x0089:
            if (r2 == 0) goto L_0x008d
            r2 = r4
            goto L_0x008e
        L_0x008d:
            r2 = r5
        L_0x008e:
            if (r2 == 0) goto L_0x00e6
            r2 = r1[r5]
            r3 = r1[r4]
            r6 = 2
            r7 = r1[r6]
            r8 = 3
            r9 = r1[r8]
            r10 = 4
            r11 = r1[r10]
            r12 = 5
            r13 = r1[r12]
            r14 = 6
            r15 = r1[r14]
            r16 = 7
            r17 = r1[r16]
            r18 = 8
            r19 = r1[r18]
            r20 = 12
            r20 = r1[r20]
            r21 = 13
            r21 = r1[r21]
            r22 = 15
            r22 = r1[r22]
            r23 = r25
            r14 = r23
            r14[r5] = r2
            r14[r4] = r11
            r14[r6] = r20
            r14[r8] = r3
            r14[r10] = r13
            r14[r12] = r21
            r23 = 6
            r14[r23] = r9
            r14[r16] = r17
            r14[r18] = r22
            r0.setValues(r14)
            r14[r5] = r2
            r14[r4] = r3
            r14[r6] = r7
            r14[r8] = r9
            r14[r10] = r11
            r14[r12] = r13
            r4 = 6
            r14[r4] = r15
            r14[r16] = r17
            r14[r18] = r19
            return
        L_0x00e6:
            r2 = 0
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Android does not support arbitrary transforms"
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt.m3026setFromEL8BTi8(android.graphics.Matrix, float[]):void");
    }
}
