package androidx.compose.material3;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007ø\u0001\u0000¢\u0006\u0002\u0010\nJ5\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\fJ\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u001b\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003JF\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/material3/DropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "contentOffset", "Landroidx/compose/ui/unit/DpOffset;", "density", "Landroidx/compose/ui/unit/Density;", "onPositionCalculated", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", "", "(JLandroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentOffset-RKDOV3M", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "calculatePosition", "Landroidx/compose/ui/unit/IntOffset;", "anchorBounds", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "popupContentSize", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "component1", "component1-RKDOV3M", "component2", "component3", "copy", "copy-rOJDEFc", "(JLandroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function2;)Landroidx/compose/material3/DropdownMenuPositionProvider;", "equals", "", "other", "", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Menu.kt */
public final class DropdownMenuPositionProvider implements PopupPositionProvider {
    private final long contentOffset;
    private final Density density;
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;

    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density2, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density2, function2);
    }

    /* renamed from: copy-rOJDEFc$default  reason: not valid java name */
    public static /* synthetic */ DropdownMenuPositionProvider m1899copyrOJDEFc$default(DropdownMenuPositionProvider dropdownMenuPositionProvider, long j, Density density2, Function2<IntRect, IntRect, Unit> function2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = dropdownMenuPositionProvider.contentOffset;
        }
        if ((i & 2) != 0) {
            density2 = dropdownMenuPositionProvider.density;
        }
        if ((i & 4) != 0) {
            function2 = dropdownMenuPositionProvider.onPositionCalculated;
        }
        return dropdownMenuPositionProvider.m1902copyrOJDEFc(j, density2, function2);
    }

    /* renamed from: component1-RKDOV3M  reason: not valid java name */
    public final long m1901component1RKDOV3M() {
        return this.contentOffset;
    }

    public final Density component2() {
        return this.density;
    }

    public final Function2<IntRect, IntRect, Unit> component3() {
        return this.onPositionCalculated;
    }

    /* renamed from: copy-rOJDEFc  reason: not valid java name */
    public final DropdownMenuPositionProvider m1902copyrOJDEFc(long j, Density density2, Function2<? super IntRect, ? super IntRect, Unit> function2) {
        Intrinsics.checkNotNullParameter(density2, "density");
        Intrinsics.checkNotNullParameter(function2, "onPositionCalculated");
        return new DropdownMenuPositionProvider(j, density2, function2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DropdownMenuPositionProvider)) {
            return false;
        }
        DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) obj;
        return DpOffset.m6046equalsimpl0(this.contentOffset, dropdownMenuPositionProvider.contentOffset) && Intrinsics.areEqual((Object) this.density, (Object) dropdownMenuPositionProvider.density) && Intrinsics.areEqual((Object) this.onPositionCalculated, (Object) dropdownMenuPositionProvider.onPositionCalculated);
    }

    public int hashCode() {
        return (((DpOffset.m6051hashCodeimpl(this.contentOffset) * 31) + this.density.hashCode()) * 31) + this.onPositionCalculated.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + DpOffset.m6054toStringimpl(this.contentOffset) + ", density=" + this.density + ", onPositionCalculated=" + this.onPositionCalculated + ')';
    }

    private DropdownMenuPositionProvider(long contentOffset2, Density density2, Function2<? super IntRect, ? super IntRect, Unit> onPositionCalculated2) {
        this.contentOffset = contentOffset2;
        this.density = density2;
        this.onPositionCalculated = onPositionCalculated2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DropdownMenuPositionProvider(long r7, androidx.compose.ui.unit.Density r9, kotlin.jvm.functions.Function2 r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r6 = this;
            r11 = r11 & 4
            if (r11 == 0) goto L_0x000a
            androidx.compose.material3.DropdownMenuPositionProvider$1 r10 = androidx.compose.material3.DropdownMenuPositionProvider.AnonymousClass1.INSTANCE
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r4 = r10
            goto L_0x000b
        L_0x000a:
            r4 = r10
        L_0x000b:
            r5 = 0
            r0 = r6
            r1 = r7
            r3 = r9
            r0.<init>(r1, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DropdownMenuPositionProvider.<init>(long, androidx.compose.ui.unit.Density, kotlin.jvm.functions.Function2, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getContentOffset-RKDOV3M  reason: not valid java name */
    public final long m1903getContentOffsetRKDOV3M() {
        return this.contentOffset;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final Function2<IntRect, IntRect, Unit> getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v0, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x016e A[LOOP:1: B:29:0x0137->B:40:0x016e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x016b A[SYNTHETIC] */
    /* renamed from: calculatePosition-llwVHH4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long m1900calculatePositionllwVHH4(androidx.compose.ui.unit.IntRect r27, long r28, androidx.compose.ui.unit.LayoutDirection r30, long r31) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r2 = r30
            java.lang.String r3 = "anchorBounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "layoutDirection"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            androidx.compose.ui.unit.Density r3 = r0.density
            r4 = 0
            float r5 = androidx.compose.material3.MenuKt.getMenuVerticalMargin()
            int r3 = r3.m5961roundToPx0680j_4(r5)
            androidx.compose.ui.unit.Density r4 = r0.density
            r5 = 0
            long r6 = r0.contentOffset
            float r6 = androidx.compose.ui.unit.DpOffset.m6047getXD9Ej5fM(r6)
            int r4 = r4.m5961roundToPx0680j_4(r6)
            androidx.compose.ui.unit.Density r5 = r0.density
            r6 = 0
            long r7 = r0.contentOffset
            float r7 = androidx.compose.ui.unit.DpOffset.m6049getYD9Ej5fM(r7)
            int r5 = r5.m5961roundToPx0680j_4(r7)
            int r6 = r27.getLeft()
            int r6 = r6 + r4
            int r7 = r27.getRight()
            int r7 = r7 - r4
            int r8 = androidx.compose.ui.unit.IntSize.m6146getWidthimpl(r31)
            int r7 = r7 - r8
            int r8 = androidx.compose.ui.unit.IntSize.m6146getWidthimpl(r28)
            int r9 = androidx.compose.ui.unit.IntSize.m6146getWidthimpl(r31)
            int r8 = r8 - r9
            r9 = 0
            androidx.compose.ui.unit.LayoutDirection r10 = androidx.compose.ui.unit.LayoutDirection.Ltr
            r11 = 3
            r12 = 2
            r13 = 1
            r14 = 0
            if (r2 != r10) goto L_0x007b
            java.lang.Integer[] r10 = new java.lang.Integer[r11]
            java.lang.Integer r15 = java.lang.Integer.valueOf(r6)
            r10[r14] = r15
            java.lang.Integer r15 = java.lang.Integer.valueOf(r7)
            r10[r13] = r15
            int r15 = r27.getLeft()
            if (r15 < 0) goto L_0x006e
            r15 = r8
            goto L_0x006f
        L_0x006e:
            r15 = r9
        L_0x006f:
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r10[r12] = r15
            kotlin.sequences.Sequence r10 = kotlin.sequences.SequencesKt.sequenceOf(r10)
            goto L_0x00a2
        L_0x007b:
            java.lang.Integer[] r10 = new java.lang.Integer[r11]
            java.lang.Integer r15 = java.lang.Integer.valueOf(r7)
            r10[r14] = r15
            java.lang.Integer r15 = java.lang.Integer.valueOf(r6)
            r10[r13] = r15
            int r15 = r27.getRight()
            int r11 = androidx.compose.ui.unit.IntSize.m6146getWidthimpl(r28)
            if (r15 > r11) goto L_0x0096
            r11 = r9
            goto L_0x0097
        L_0x0096:
            r11 = r8
        L_0x0097:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r10[r12] = r11
            kotlin.sequences.Sequence r10 = kotlin.sequences.SequencesKt.sequenceOf(r10)
        L_0x00a2:
            r11 = 0
            java.util.Iterator r15 = r10.iterator()
        L_0x00a8:
            boolean r17 = r15.hasNext()
            r18 = 0
            if (r17 == 0) goto L_0x00d5
            java.lang.Object r17 = r15.next()
            r19 = r17
            java.lang.Number r19 = (java.lang.Number) r19
            int r19 = r19.intValue()
            r20 = 0
            if (r19 < 0) goto L_0x00ce
            int r21 = androidx.compose.ui.unit.IntSize.m6146getWidthimpl(r31)
            int r13 = r19 + r21
            int r14 = androidx.compose.ui.unit.IntSize.m6146getWidthimpl(r28)
            if (r13 > r14) goto L_0x00ce
            r13 = 1
            goto L_0x00cf
        L_0x00ce:
            r13 = 0
        L_0x00cf:
            if (r13 == 0) goto L_0x00d2
            goto L_0x00d7
        L_0x00d2:
            r13 = 1
            r14 = 0
            goto L_0x00a8
        L_0x00d5:
            r17 = r18
        L_0x00d7:
            java.lang.Integer r17 = (java.lang.Integer) r17
            if (r17 == 0) goto L_0x00e0
            int r10 = r17.intValue()
            goto L_0x00e1
        L_0x00e0:
            r10 = r7
        L_0x00e1:
            int r11 = r27.getBottom()
            int r11 = r11 + r5
            int r11 = java.lang.Math.max(r11, r3)
            int r13 = r27.getTop()
            int r13 = r13 - r5
            int r14 = androidx.compose.ui.unit.IntSize.m6145getHeightimpl(r31)
            int r13 = r13 - r14
            int r14 = r27.getTop()
            int r15 = androidx.compose.ui.unit.IntSize.m6145getHeightimpl(r31)
            int r15 = r15 / r12
            int r14 = r14 - r15
            int r15 = androidx.compose.ui.unit.IntSize.m6145getHeightimpl(r28)
            int r17 = androidx.compose.ui.unit.IntSize.m6145getHeightimpl(r31)
            int r15 = r15 - r17
            int r15 = r15 - r3
            r12 = 4
            java.lang.Integer[] r12 = new java.lang.Integer[r12]
            java.lang.Integer r19 = java.lang.Integer.valueOf(r11)
            r20 = 0
            r12[r20] = r19
            java.lang.Integer r19 = java.lang.Integer.valueOf(r13)
            r21 = 1
            r12[r21] = r19
            java.lang.Integer r19 = java.lang.Integer.valueOf(r14)
            r17 = 2
            r12[r17] = r19
            java.lang.Integer r17 = java.lang.Integer.valueOf(r15)
            r16 = 3
            r12[r16] = r17
            kotlin.sequences.Sequence r12 = kotlin.sequences.SequencesKt.sequenceOf(r12)
            r16 = 0
            java.util.Iterator r17 = r12.iterator()
        L_0x0137:
            boolean r19 = r17.hasNext()
            if (r19 == 0) goto L_0x0173
            java.lang.Object r19 = r17.next()
            r22 = r19
            java.lang.Number r22 = (java.lang.Number) r22
            int r2 = r22.intValue()
            r22 = 0
            if (r2 < r3) goto L_0x0162
            int r23 = androidx.compose.ui.unit.IntSize.m6145getHeightimpl(r31)
            r24 = r4
            int r4 = r2 + r23
            int r23 = androidx.compose.ui.unit.IntSize.m6145getHeightimpl(r28)
            r25 = r2
            int r2 = r23 - r3
            if (r4 > r2) goto L_0x0166
            r2 = r21
            goto L_0x0168
        L_0x0162:
            r25 = r2
            r24 = r4
        L_0x0166:
            r2 = r20
        L_0x0168:
            if (r2 == 0) goto L_0x016e
            r18 = r19
            goto L_0x0175
        L_0x016e:
            r2 = r30
            r4 = r24
            goto L_0x0137
        L_0x0173:
            r24 = r4
        L_0x0175:
            java.lang.Integer r18 = (java.lang.Integer) r18
            if (r18 == 0) goto L_0x017e
            int r2 = r18.intValue()
            goto L_0x017f
        L_0x017e:
            r2 = r13
        L_0x017f:
            kotlin.jvm.functions.Function2<androidx.compose.ui.unit.IntRect, androidx.compose.ui.unit.IntRect, kotlin.Unit> r4 = r0.onPositionCalculated
            androidx.compose.ui.unit.IntRect r12 = new androidx.compose.ui.unit.IntRect
            int r16 = androidx.compose.ui.unit.IntSize.m6146getWidthimpl(r31)
            int r0 = r10 + r16
            int r16 = androidx.compose.ui.unit.IntSize.m6145getHeightimpl(r31)
            r17 = r3
            int r3 = r2 + r16
            r12.<init>(r10, r2, r0, r3)
            r4.invoke(r1, r12)
            long r3 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r10, r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DropdownMenuPositionProvider.m1900calculatePositionllwVHH4(androidx.compose.ui.unit.IntRect, long, androidx.compose.ui.unit.LayoutDirection, long):long");
    }
}
