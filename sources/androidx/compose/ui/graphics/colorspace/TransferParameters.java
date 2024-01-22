package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\""}, d2 = {"Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "", "gamma", "", "a", "b", "c", "d", "e", "f", "(DDDDDDD)V", "getA", "()D", "getB", "getC", "getD", "getE", "getF", "getGamma", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TransferParameters.kt */
public final class TransferParameters {
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;
    private final double gamma;

    public static /* synthetic */ TransferParameters copy$default(TransferParameters transferParameters, double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i, Object obj) {
        TransferParameters transferParameters2 = transferParameters;
        return transferParameters.copy((i & 1) != 0 ? transferParameters2.gamma : d2, (i & 2) != 0 ? transferParameters2.a : d3, (i & 4) != 0 ? transferParameters2.b : d4, (i & 8) != 0 ? transferParameters2.c : d5, (i & 16) != 0 ? transferParameters2.d : d6, (i & 32) != 0 ? transferParameters2.e : d7, (i & 64) != 0 ? transferParameters2.f : d8);
    }

    public final double component1() {
        return this.gamma;
    }

    public final double component2() {
        return this.a;
    }

    public final double component3() {
        return this.b;
    }

    public final double component4() {
        return this.c;
    }

    public final double component5() {
        return this.d;
    }

    public final double component6() {
        return this.e;
    }

    public final double component7() {
        return this.f;
    }

    public final TransferParameters copy(double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        return new TransferParameters(d2, d3, d4, d5, d6, d7, d8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransferParameters)) {
            return false;
        }
        TransferParameters transferParameters = (TransferParameters) obj;
        return Double.compare(this.gamma, transferParameters.gamma) == 0 && Double.compare(this.a, transferParameters.a) == 0 && Double.compare(this.b, transferParameters.b) == 0 && Double.compare(this.c, transferParameters.c) == 0 && Double.compare(this.d, transferParameters.d) == 0 && Double.compare(this.e, transferParameters.e) == 0 && Double.compare(this.f, transferParameters.f) == 0;
    }

    public int hashCode() {
        return (((((((((((Double.hashCode(this.gamma) * 31) + Double.hashCode(this.a)) * 31) + Double.hashCode(this.b)) * 31) + Double.hashCode(this.c)) * 31) + Double.hashCode(this.d)) * 31) + Double.hashCode(this.e)) * 31) + Double.hashCode(this.f);
    }

    public String toString() {
        return "TransferParameters(gamma=" + this.gamma + ", a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ", e=" + this.e + ", f=" + this.f + ')';
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007b, code lost:
        if ((r1 == 0.0d) == false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b4, code lost:
        if ((r1 == 0.0d) != false) goto L_0x00b6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TransferParameters(double r23, double r25, double r27, double r29, double r31, double r33, double r35) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r3 = r25
            r5 = r29
            r7 = r31
            r22.<init>()
            r0.gamma = r1
            r0.a = r3
            r9 = r27
            r0.b = r9
            r0.c = r5
            r0.d = r7
            r11 = r33
            r0.e = r11
            r13 = r35
            r0.f = r13
            boolean r15 = java.lang.Double.isNaN(r25)
            if (r15 != 0) goto L_0x0101
            boolean r15 = java.lang.Double.isNaN(r27)
            if (r15 != 0) goto L_0x0101
            boolean r15 = java.lang.Double.isNaN(r29)
            if (r15 != 0) goto L_0x0101
            boolean r15 = java.lang.Double.isNaN(r31)
            if (r15 != 0) goto L_0x0101
            boolean r15 = java.lang.Double.isNaN(r33)
            if (r15 != 0) goto L_0x0101
            boolean r15 = java.lang.Double.isNaN(r35)
            if (r15 != 0) goto L_0x0101
            boolean r15 = java.lang.Double.isNaN(r23)
            if (r15 != 0) goto L_0x0101
            r15 = 0
            int r17 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r17 < 0) goto L_0x00e7
            r17 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r19 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r19 > 0) goto L_0x00e7
            int r19 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            r20 = 1
            r21 = 0
            if (r19 != 0) goto L_0x0063
            r19 = r20
            goto L_0x0065
        L_0x0063:
            r19 = r21
        L_0x0065:
            if (r19 == 0) goto L_0x0087
            int r19 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r19 != 0) goto L_0x006e
            r19 = r20
            goto L_0x0070
        L_0x006e:
            r19 = r21
        L_0x0070:
            if (r19 != 0) goto L_0x007e
            int r19 = (r1 > r15 ? 1 : (r1 == r15 ? 0 : -1))
            if (r19 != 0) goto L_0x0079
            r19 = r20
            goto L_0x007b
        L_0x0079:
            r19 = r21
        L_0x007b:
            if (r19 != 0) goto L_0x007e
            goto L_0x0087
        L_0x007e:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Parameter a or g is zero, the transfer function is constant"
            r15.<init>(r0)
            throw r15
        L_0x0087:
            int r0 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r0 < 0) goto L_0x00a0
            int r0 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            if (r0 != 0) goto L_0x0092
            r0 = r20
            goto L_0x0094
        L_0x0092:
            r0 = r21
        L_0x0094:
            if (r0 != 0) goto L_0x0097
            goto L_0x00a0
        L_0x0097:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r15 = "Parameter c is zero, the transfer function is constant"
            r0.<init>(r15)
            throw r0
        L_0x00a0:
            int r0 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r0 != 0) goto L_0x00a7
            r0 = r20
            goto L_0x00a9
        L_0x00a7:
            r0 = r21
        L_0x00a9:
            if (r0 != 0) goto L_0x00b6
            int r0 = (r1 > r15 ? 1 : (r1 == r15 ? 0 : -1))
            if (r0 != 0) goto L_0x00b2
            r0 = r20
            goto L_0x00b4
        L_0x00b2:
            r0 = r21
        L_0x00b4:
            if (r0 == 0) goto L_0x00bf
        L_0x00b6:
            int r0 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            if (r0 != 0) goto L_0x00bb
            goto L_0x00bd
        L_0x00bb:
            r20 = r21
        L_0x00bd:
            if (r20 != 0) goto L_0x00de
        L_0x00bf:
            int r0 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            if (r0 < 0) goto L_0x00d6
            int r0 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r0 < 0) goto L_0x00cd
            int r0 = (r1 > r15 ? 1 : (r1 == r15 ? 0 : -1))
            if (r0 < 0) goto L_0x00cd
            return
        L_0x00cd:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r15 = "The transfer function must be positive or increasing"
            r0.<init>(r15)
            throw r0
        L_0x00d6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r15 = "The transfer function must be increasing"
            r0.<init>(r15)
            throw r0
        L_0x00de:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r15 = "Parameter a or g is zero, and c is zero, the transfer function is constant"
            r0.<init>(r15)
            throw r0
        L_0x00e7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r1 = "Parameter d must be in the range [0..1], was "
            java.lang.StringBuilder r1 = r15.append(r1)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0101:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Parameters cannot be NaN"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.TransferParameters.<init>(double, double, double, double, double, double, double):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TransferParameters(double r19, double r21, double r23, double r25, double r27, double r29, double r31, int r33, kotlin.jvm.internal.DefaultConstructorMarker r34) {
        /*
            r18 = this;
            r0 = r33 & 32
            r1 = 0
            if (r0 == 0) goto L_0x0008
            r14 = r1
            goto L_0x000a
        L_0x0008:
            r14 = r29
        L_0x000a:
            r0 = r33 & 64
            if (r0 == 0) goto L_0x0011
            r16 = r1
            goto L_0x0013
        L_0x0011:
            r16 = r31
        L_0x0013:
            r3 = r18
            r4 = r19
            r6 = r21
            r8 = r23
            r10 = r25
            r12 = r27
            r3.<init>(r4, r6, r8, r10, r12, r14, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.TransferParameters.<init>(double, double, double, double, double, double, double, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final double getGamma() {
        return this.gamma;
    }

    public final double getA() {
        return this.a;
    }

    public final double getB() {
        return this.b;
    }

    public final double getC() {
        return this.c;
    }

    public final double getD() {
        return this.d;
    }

    public final double getE() {
        return this.e;
    }

    public final double getF() {
        return this.f;
    }
}
