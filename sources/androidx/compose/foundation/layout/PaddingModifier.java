package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BQ\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J)\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%R\u001c\u0010\u0007\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/foundation/layout/PaddingModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM", "()F", "F", "getEnd-D9Ej5fM", "getRtlAware", "()Z", "getStart-D9Ej5fM", "getTop-D9Ej5fM", "equals", "other", "", "hashCode", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Padding.kt */
final class PaddingModifier extends InspectorValueInfo implements LayoutModifier {
    private final float bottom;
    private final float end;
    private final boolean rtlAware;
    private final float start;
    private final float top;

    public /* synthetic */ PaddingModifier(float f, float f2, float f3, float f4, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z, function1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaddingModifier(float r10, float r11, float r12, float r13, boolean r14, kotlin.jvm.functions.Function1 r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 1
            if (r0 == 0) goto L_0x000d
            r0 = 0
            r1 = 0
            float r2 = (float) r0
            float r0 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r2)
            r2 = r0
            goto L_0x000e
        L_0x000d:
            r2 = r10
        L_0x000e:
            r0 = r16 & 2
            if (r0 == 0) goto L_0x001b
            r0 = 0
            r1 = 0
            float r3 = (float) r0
            float r0 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r3)
            r3 = r0
            goto L_0x001c
        L_0x001b:
            r3 = r11
        L_0x001c:
            r0 = r16 & 4
            if (r0 == 0) goto L_0x0029
            r0 = 0
            r1 = 0
            float r4 = (float) r0
            float r0 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r4)
            r4 = r0
            goto L_0x002a
        L_0x0029:
            r4 = r12
        L_0x002a:
            r0 = r16 & 8
            if (r0 == 0) goto L_0x0037
            r0 = 0
            r1 = 0
            float r5 = (float) r0
            float r0 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r5)
            r5 = r0
            goto L_0x0038
        L_0x0037:
            r5 = r13
        L_0x0038:
            r8 = 0
            r1 = r9
            r6 = r14
            r7 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.PaddingModifier.<init>(float, float, float, float, boolean, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* renamed from: getStart-D9Ej5fM  reason: not valid java name */
    public final float m767getStartD9Ej5fM() {
        return this.start;
    }

    /* renamed from: getTop-D9Ej5fM  reason: not valid java name */
    public final float m768getTopD9Ej5fM() {
        return this.top;
    }

    /* renamed from: getEnd-D9Ej5fM  reason: not valid java name */
    public final float m766getEndD9Ej5fM() {
        return this.end;
    }

    /* renamed from: getBottom-D9Ej5fM  reason: not valid java name */
    public final float m765getBottomD9Ej5fM() {
        return this.bottom;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    private PaddingModifier(float start2, float top2, float end2, float bottom2, boolean rtlAware2, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        this.start = start2;
        this.top = top2;
        this.end = end2;
        this.bottom = bottom2;
        this.rtlAware = rtlAware2;
        if (!((start2 >= 0.0f || Dp.m5991equalsimpl0(start2, Dp.Companion.m6006getUnspecifiedD9Ej5fM())) && (top2 >= 0.0f || Dp.m5991equalsimpl0(top2, Dp.Companion.m6006getUnspecifiedD9Ej5fM())) && ((end2 >= 0.0f || Dp.m5991equalsimpl0(end2, Dp.Companion.m6006getUnspecifiedD9Ej5fM())) && (bottom2 >= 0.0f || Dp.m5991equalsimpl0(bottom2, Dp.Companion.m6006getUnspecifiedD9Ej5fM()))))) {
            throw new IllegalArgumentException("Padding must be non-negative".toString());
        }
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m769measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        MeasureScope measureScope = $this$measure_u2d3p2s80s;
        Measurable measurable2 = measurable;
        long j = constraints;
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable2, "measurable");
        int horizontal = measureScope.m5961roundToPx0680j_4(this.start) + measureScope.m5961roundToPx0680j_4(this.end);
        int vertical = measureScope.m5961roundToPx0680j_4(this.top) + measureScope.m5961roundToPx0680j_4(this.bottom);
        Placeable placeable = measurable2.m4863measureBRTryo0(ConstraintsKt.m5946offsetNN6EwU(j, -horizontal, -vertical));
        int width = ConstraintsKt.m5944constrainWidthK40F9xA(j, placeable.getWidth() + horizontal);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, width, ConstraintsKt.m5943constrainHeightK40F9xA(j, placeable.getHeight() + vertical), (Map) null, new PaddingModifier$measure$1(this, placeable, measureScope), 4, (Object) null);
    }

    public int hashCode() {
        return (((((((Dp.m5992hashCodeimpl(this.start) * 31) + Dp.m5992hashCodeimpl(this.top)) * 31) + Dp.m5992hashCodeimpl(this.end)) * 31) + Dp.m5992hashCodeimpl(this.bottom)) * 31) + Boolean.hashCode(this.rtlAware);
    }

    public boolean equals(Object other) {
        PaddingModifier otherModifier = other instanceof PaddingModifier ? (PaddingModifier) other : null;
        if (otherModifier != null && Dp.m5991equalsimpl0(this.start, otherModifier.start) && Dp.m5991equalsimpl0(this.top, otherModifier.top) && Dp.m5991equalsimpl0(this.end, otherModifier.end) && Dp.m5991equalsimpl0(this.bottom, otherModifier.bottom) && this.rtlAware == otherModifier.rtlAware) {
            return true;
        }
        return false;
    }
}
