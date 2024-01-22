package androidx.compose.material;

import androidx.compose.ui.layout.MeasurePolicy;
import kotlin.Metadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlertDialog.kt */
final class AlertDialogKt$AlertDialogBaselineLayout$2 implements MeasurePolicy {
    public static final AlertDialogKt$AlertDialogBaselineLayout$2 INSTANCE = new AlertDialogKt$AlertDialogBaselineLayout$2();

    AlertDialogKt$AlertDialogBaselineLayout$2() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0148  */
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.layout.MeasureResult m1361measure3p2s80s(androidx.compose.ui.layout.MeasureScope r24, java.util.List<? extends androidx.compose.ui.layout.Measurable> r25, long r26) {
        /*
            r23 = this;
            r7 = r24
            r8 = r25
            java.lang.String r0 = "$this$Layout"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "measurables"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = r8
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.Iterator r2 = r0.iterator()
        L_0x0017:
            boolean r3 = r2.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x0034
            java.lang.Object r3 = r2.next()
            r5 = r3
            androidx.compose.ui.layout.Measurable r5 = (androidx.compose.ui.layout.Measurable) r5
            r6 = 0
            java.lang.Object r9 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r5)
            java.lang.String r10 = "title"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r5 == 0) goto L_0x0017
            goto L_0x0035
        L_0x0034:
            r3 = r4
        L_0x0035:
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            if (r3 == 0) goto L_0x004c
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 11
            r16 = 0
            r9 = r26
            long r0 = androidx.compose.ui.unit.Constraints.m5921copyZbe2FdA$default(r9, r11, r12, r13, r14, r15, r16)
            androidx.compose.ui.layout.Placeable r0 = r3.m4863measureBRTryo0(r0)
            goto L_0x004d
        L_0x004c:
            r0 = r4
        L_0x004d:
            r9 = r0
            r0 = r8
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.Iterator r2 = r0.iterator()
        L_0x0056:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0072
            java.lang.Object r3 = r2.next()
            r5 = r3
            androidx.compose.ui.layout.Measurable r5 = (androidx.compose.ui.layout.Measurable) r5
            r6 = 0
            java.lang.Object r10 = androidx.compose.ui.layout.LayoutIdKt.getLayoutId(r5)
            java.lang.String r11 = "text"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)
            if (r5 == 0) goto L_0x0056
            goto L_0x0073
        L_0x0072:
            r3 = r4
        L_0x0073:
            androidx.compose.ui.layout.Measurable r3 = (androidx.compose.ui.layout.Measurable) r3
            if (r3 == 0) goto L_0x008a
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 11
            r17 = 0
            r10 = r26
            long r0 = androidx.compose.ui.unit.Constraints.m5921copyZbe2FdA$default(r10, r12, r13, r14, r15, r16, r17)
            androidx.compose.ui.layout.Placeable r0 = r3.m4863measureBRTryo0(r0)
            goto L_0x008b
        L_0x008a:
            r0 = r4
        L_0x008b:
            r10 = r0
            r0 = 0
            if (r9 == 0) goto L_0x0094
            int r1 = r9.getWidth()
            goto L_0x0095
        L_0x0094:
            r1 = r0
        L_0x0095:
            if (r10 == 0) goto L_0x009c
            int r2 = r10.getWidth()
            goto L_0x009d
        L_0x009c:
            r2 = r0
        L_0x009d:
            int r11 = java.lang.Math.max(r1, r2)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r9 == 0) goto L_0x00c9
            androidx.compose.ui.layout.HorizontalAlignmentLine r2 = androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline()
            androidx.compose.ui.layout.AlignmentLine r2 = (androidx.compose.ui.layout.AlignmentLine) r2
            int r2 = r9.get(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            r3 = 0
            if (r2 != r1) goto L_0x00be
            r5 = r4
            goto L_0x00c2
        L_0x00be:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
        L_0x00c2:
            if (r5 == 0) goto L_0x00c9
            int r2 = r5.intValue()
            goto L_0x00ca
        L_0x00c9:
            r2 = r0
        L_0x00ca:
            r12 = r2
            if (r9 == 0) goto L_0x00e7
            androidx.compose.ui.layout.HorizontalAlignmentLine r2 = androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline()
            androidx.compose.ui.layout.AlignmentLine r2 = (androidx.compose.ui.layout.AlignmentLine) r2
            int r2 = r9.get(r2)
            r3 = 0
            if (r2 != r1) goto L_0x00dc
            r5 = r4
            goto L_0x00e0
        L_0x00dc:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
        L_0x00e0:
            if (r5 == 0) goto L_0x00e7
            int r2 = r5.intValue()
            goto L_0x00e8
        L_0x00e7:
            r2 = r0
        L_0x00e8:
            r13 = r2
            long r2 = androidx.compose.material.AlertDialogKt.TitleBaselineDistanceFromTop
            int r14 = r7.m5960roundToPxR2X_6o(r2)
            int r15 = r14 - r12
            if (r10 == 0) goto L_0x010e
            androidx.compose.ui.layout.HorizontalAlignmentLine r2 = androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline()
            androidx.compose.ui.layout.AlignmentLine r2 = (androidx.compose.ui.layout.AlignmentLine) r2
            int r2 = r10.get(r2)
            r3 = 0
            if (r2 != r1) goto L_0x0103
            goto L_0x0107
        L_0x0103:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
        L_0x0107:
            if (r4 == 0) goto L_0x010e
            int r1 = r4.intValue()
            goto L_0x010f
        L_0x010e:
            r1 = r0
        L_0x010f:
            r16 = r1
            if (r9 != 0) goto L_0x011c
            long r1 = androidx.compose.material.AlertDialogKt.TextBaselineDistanceFromTop
            int r1 = r7.m5960roundToPxR2X_6o(r1)
            goto L_0x0124
        L_0x011c:
            long r1 = androidx.compose.material.AlertDialogKt.TextBaselineDistanceFromTitle
            int r1 = r7.m5960roundToPxR2X_6o(r1)
        L_0x0124:
            r17 = r1
            if (r9 == 0) goto L_0x0130
            r1 = r9
            r2 = 0
            int r3 = r1.getHeight()
            int r3 = r3 + r15
            goto L_0x0131
        L_0x0130:
            r3 = r0
        L_0x0131:
            r18 = r3
            if (r9 != 0) goto L_0x0138
            int r1 = r17 - r16
            goto L_0x0145
        L_0x0138:
            if (r13 != 0) goto L_0x013f
            int r1 = r18 - r16
            int r1 = r1 + r17
            goto L_0x0145
        L_0x013f:
            int r1 = r15 + r13
            int r1 = r1 - r16
            int r1 = r1 + r17
        L_0x0145:
            r6 = r1
            if (r10 == 0) goto L_0x0168
            r1 = r10
            r2 = 0
            if (r13 != 0) goto L_0x0155
            int r0 = r10.getHeight()
            int r0 = r0 + r17
            int r0 = r0 - r16
            goto L_0x0166
        L_0x0155:
            int r3 = r10.getHeight()
            int r3 = r3 + r17
            int r3 = r3 - r16
            if (r9 == 0) goto L_0x0163
            int r0 = r9.getHeight()
        L_0x0163:
            int r0 = r0 - r13
            int r3 = r3 - r0
            r0 = r3
        L_0x0166:
            goto L_0x0169
        L_0x0168:
        L_0x0169:
            r19 = r0
            int r20 = r18 + r19
            r3 = 0
            androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2$measure$1 r0 = new androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2$measure$1
            r0.<init>(r9, r15, r10, r6)
            r4 = r0
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r5 = 4
            r21 = 0
            r0 = r24
            r1 = r11
            r2 = r20
            r22 = r6
            r6 = r21
            androidx.compose.ui.layout.MeasureResult r0 = androidx.compose.ui.layout.MeasureScope.layout$default(r0, r1, r2, r3, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2.m1361measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
    }
}
