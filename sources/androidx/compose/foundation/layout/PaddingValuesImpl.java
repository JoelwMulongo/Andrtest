package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B0\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0013\u001a\u00020\u0003H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000bJ \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u0003H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u000bJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016R'\u0010\u0006\u001a\u00020\u00038\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR'\u0010\u0005\u001a\u00020\u00038\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR'\u0010\u0002\u001a\u00020\u00038\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000bR'\u0010\u0004\u001a\u00020\u00038\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesImpl;", "Landroidx/compose/foundation/layout/PaddingValues;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM$annotations", "()V", "getBottom-D9Ej5fM", "()F", "F", "getEnd-D9Ej5fM$annotations", "getEnd-D9Ej5fM", "getStart-D9Ej5fM$annotations", "getStart-D9Ej5fM", "getTop-D9Ej5fM$annotations", "getTop-D9Ej5fM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Padding.kt */
public final class PaddingValuesImpl implements PaddingValues {
    private final float bottom;
    private final float end;
    private final float start;
    private final float top;

    public /* synthetic */ PaddingValuesImpl(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    /* renamed from: getBottom-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m782getBottomD9Ej5fM$annotations() {
    }

    /* renamed from: getEnd-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m783getEndD9Ej5fM$annotations() {
    }

    /* renamed from: getStart-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m784getStartD9Ej5fM$annotations() {
    }

    /* renamed from: getTop-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m785getTopD9Ej5fM$annotations() {
    }

    private PaddingValuesImpl(float start2, float top2, float end2, float bottom2) {
        this.start = start2;
        this.top = top2;
        this.end = end2;
        this.bottom = bottom2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaddingValuesImpl(float r7, float r8, float r9, float r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r6 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x000d
            r7 = 0
            r12 = 0
            float r0 = (float) r7
            float r7 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r0)
            r1 = r7
            goto L_0x000e
        L_0x000d:
            r1 = r7
        L_0x000e:
            r7 = r11 & 2
            if (r7 == 0) goto L_0x001b
            r7 = 0
            r8 = 0
            float r12 = (float) r7
            float r8 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r12)
            r2 = r8
            goto L_0x001c
        L_0x001b:
            r2 = r8
        L_0x001c:
            r7 = r11 & 4
            if (r7 == 0) goto L_0x0029
            r7 = 0
            r8 = 0
            float r9 = (float) r7
            float r9 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r9)
            r3 = r9
            goto L_0x002a
        L_0x0029:
            r3 = r9
        L_0x002a:
            r7 = r11 & 8
            if (r7 == 0) goto L_0x0037
            r7 = 0
            r8 = 0
            float r9 = (float) r7
            float r10 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r9)
            r4 = r10
            goto L_0x0038
        L_0x0037:
            r4 = r10
        L_0x0038:
            r5 = 0
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.PaddingValuesImpl.<init>(float, float, float, float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getStart-D9Ej5fM  reason: not valid java name */
    public final float m792getStartD9Ej5fM() {
        return this.start;
    }

    /* renamed from: getTop-D9Ej5fM  reason: not valid java name */
    public final float m793getTopD9Ej5fM() {
        return this.top;
    }

    /* renamed from: getEnd-D9Ej5fM  reason: not valid java name */
    public final float m791getEndD9Ej5fM() {
        return this.end;
    }

    /* renamed from: getBottom-D9Ej5fM  reason: not valid java name */
    public final float m790getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* renamed from: calculateLeftPadding-u2uoSUM  reason: not valid java name */
    public float m787calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return layoutDirection == LayoutDirection.Ltr ? this.start : this.end;
    }

    /* renamed from: calculateTopPadding-D9Ej5fM  reason: not valid java name */
    public float m789calculateTopPaddingD9Ej5fM() {
        return this.top;
    }

    /* renamed from: calculateRightPadding-u2uoSUM  reason: not valid java name */
    public float m788calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return layoutDirection == LayoutDirection.Ltr ? this.end : this.start;
    }

    /* renamed from: calculateBottomPadding-D9Ej5fM  reason: not valid java name */
    public float m786calculateBottomPaddingD9Ej5fM() {
        return this.bottom;
    }

    public boolean equals(Object other) {
        if ((other instanceof PaddingValuesImpl) && Dp.m5991equalsimpl0(this.start, ((PaddingValuesImpl) other).start) && Dp.m5991equalsimpl0(this.top, ((PaddingValuesImpl) other).top) && Dp.m5991equalsimpl0(this.end, ((PaddingValuesImpl) other).end) && Dp.m5991equalsimpl0(this.bottom, ((PaddingValuesImpl) other).bottom)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((Dp.m5992hashCodeimpl(this.start) * 31) + Dp.m5992hashCodeimpl(this.top)) * 31) + Dp.m5992hashCodeimpl(this.end)) * 31) + Dp.m5992hashCodeimpl(this.bottom);
    }

    public String toString() {
        return "PaddingValues(start=" + Dp.m5997toStringimpl(this.start) + ", top=" + Dp.m5997toStringimpl(this.top) + ", end=" + Dp.m5997toStringimpl(this.end) + ", bottom=" + Dp.m5997toStringimpl(this.bottom) + ')';
    }
}
