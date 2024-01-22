package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B.\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0019\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0016J\u001c\u0010\"\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016J)\u0010$\u001a\u00020%*\u00020&2\u0006\u0010\u001f\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001aH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u001c\u0010+\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0016J\u001c\u0010,\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016J#\u0010-\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J#\u00101\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00100J#\u00103\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00100J#\u00105\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00100R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00067"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FZLkotlin/jvm/functions/Function1;)V", "getAspectRatio", "()F", "getMatchHeightConstraintsFirst", "()Z", "equals", "other", "", "hashCode", "", "toString", "", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AspectRatio.kt */
final class AspectRatioModifier extends InspectorValueInfo implements LayoutModifier {
    private final float aspectRatio;
    private final boolean matchHeightConstraintsFirst;

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AspectRatioModifier(float aspectRatio2, boolean matchHeightConstraintsFirst2, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.aspectRatio = aspectRatio2;
        this.matchHeightConstraintsFirst = matchHeightConstraintsFirst2;
        if (!(aspectRatio2 > 0.0f)) {
            throw new IllegalArgumentException(("aspectRatio " + aspectRatio2 + " must be > 0").toString());
        }
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m710measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        long wrappedConstraints;
        Measurable measurable2 = measurable;
        Intrinsics.checkNotNullParameter($this$measure_u2d3p2s80s, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable2, "measurable");
        long j = constraints;
        long size = m701findSizeToXhtMw(j);
        if (!IntSize.m6144equalsimpl0(size, IntSize.Companion.m6151getZeroYbymL2g())) {
            wrappedConstraints = Constraints.Companion.m5938fixedJhjzzOo(IntSize.m6146getWidthimpl(size), IntSize.m6145getHeightimpl(size));
        } else {
            wrappedConstraints = j;
        }
        Placeable placeable = measurable2.m4863measureBRTryo0(wrappedConstraints);
        Placeable placeable2 = placeable;
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, placeable.getWidth(), placeable.getHeight(), (Map) null, new AspectRatioModifier$measure$1(placeable), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (height != Integer.MAX_VALUE) {
            return MathKt.roundToInt(((float) height) * this.aspectRatio);
        }
        return measurable.minIntrinsicWidth(height);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (height != Integer.MAX_VALUE) {
            return MathKt.roundToInt(((float) height) * this.aspectRatio);
        }
        return measurable.maxIntrinsicWidth(height);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (width != Integer.MAX_VALUE) {
            return MathKt.roundToInt(((float) width) / this.aspectRatio);
        }
        return measurable.minIntrinsicHeight(width);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (width != Integer.MAX_VALUE) {
            return MathKt.roundToInt(((float) width) / this.aspectRatio);
        }
        return measurable.maxIntrinsicHeight(width);
    }

    /* renamed from: findSize-ToXhtMw  reason: not valid java name */
    private final long m701findSizeToXhtMw(long $this$findSize_u2dToXhtMw) {
        if (!this.matchHeightConstraintsFirst) {
            long it = m705tryMaxWidthJN0ABg$default(this, $this$findSize_u2dToXhtMw, false, 1, (Object) null);
            if (!IntSize.m6144equalsimpl0(it, IntSize.Companion.m6151getZeroYbymL2g())) {
                return it;
            }
            long it2 = m703tryMaxHeightJN0ABg$default(this, $this$findSize_u2dToXhtMw, false, 1, (Object) null);
            if (!IntSize.m6144equalsimpl0(it2, IntSize.Companion.m6151getZeroYbymL2g())) {
                return it2;
            }
            long it3 = m709tryMinWidthJN0ABg$default(this, $this$findSize_u2dToXhtMw, false, 1, (Object) null);
            if (!IntSize.m6144equalsimpl0(it3, IntSize.Companion.m6151getZeroYbymL2g())) {
                return it3;
            }
            long it4 = m707tryMinHeightJN0ABg$default(this, $this$findSize_u2dToXhtMw, false, 1, (Object) null);
            if (!IntSize.m6144equalsimpl0(it4, IntSize.Companion.m6151getZeroYbymL2g())) {
                return it4;
            }
            long it5 = m704tryMaxWidthJN0ABg($this$findSize_u2dToXhtMw, false);
            if (!IntSize.m6144equalsimpl0(it5, IntSize.Companion.m6151getZeroYbymL2g())) {
                return it5;
            }
            long it6 = m702tryMaxHeightJN0ABg($this$findSize_u2dToXhtMw, false);
            if (!IntSize.m6144equalsimpl0(it6, IntSize.Companion.m6151getZeroYbymL2g())) {
                return it6;
            }
            long it7 = m708tryMinWidthJN0ABg($this$findSize_u2dToXhtMw, false);
            if (!IntSize.m6144equalsimpl0(it7, IntSize.Companion.m6151getZeroYbymL2g())) {
                return it7;
            }
            long it8 = m706tryMinHeightJN0ABg($this$findSize_u2dToXhtMw, false);
            if (!IntSize.m6144equalsimpl0(it8, IntSize.Companion.m6151getZeroYbymL2g())) {
                return it8;
            }
        } else {
            long it9 = m703tryMaxHeightJN0ABg$default(this, $this$findSize_u2dToXhtMw, false, 1, (Object) null);
            if (!IntSize.m6144equalsimpl0(it9, IntSize.Companion.m6151getZeroYbymL2g())) {
                return it9;
            }
            long it10 = m705tryMaxWidthJN0ABg$default(this, $this$findSize_u2dToXhtMw, false, 1, (Object) null);
            if (!IntSize.m6144equalsimpl0(it10, IntSize.Companion.m6151getZeroYbymL2g())) {
                return it10;
            }
            long it11 = m707tryMinHeightJN0ABg$default(this, $this$findSize_u2dToXhtMw, false, 1, (Object) null);
            if (!IntSize.m6144equalsimpl0(it11, IntSize.Companion.m6151getZeroYbymL2g())) {
                return it11;
            }
            long it12 = m709tryMinWidthJN0ABg$default(this, $this$findSize_u2dToXhtMw, false, 1, (Object) null);
            if (!IntSize.m6144equalsimpl0(it12, IntSize.Companion.m6151getZeroYbymL2g())) {
                return it12;
            }
            long it13 = m702tryMaxHeightJN0ABg($this$findSize_u2dToXhtMw, false);
            if (!IntSize.m6144equalsimpl0(it13, IntSize.Companion.m6151getZeroYbymL2g())) {
                return it13;
            }
            long it14 = m704tryMaxWidthJN0ABg($this$findSize_u2dToXhtMw, false);
            if (!IntSize.m6144equalsimpl0(it14, IntSize.Companion.m6151getZeroYbymL2g())) {
                return it14;
            }
            long it15 = m706tryMinHeightJN0ABg($this$findSize_u2dToXhtMw, false);
            if (!IntSize.m6144equalsimpl0(it15, IntSize.Companion.m6151getZeroYbymL2g())) {
                return it15;
            }
            long it16 = m708tryMinWidthJN0ABg($this$findSize_u2dToXhtMw, false);
            if (!IntSize.m6144equalsimpl0(it16, IntSize.Companion.m6151getZeroYbymL2g())) {
                return it16;
            }
        }
        return IntSize.Companion.m6151getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m705tryMaxWidthJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m704tryMaxWidthJN0ABg(j, z);
    }

    /* renamed from: tryMaxWidth-JN-0ABg  reason: not valid java name */
    private final long m704tryMaxWidthJN0ABg(long $this$tryMaxWidth_u2dJN_u2d0ABg, boolean enforceConstraints) {
        int height;
        int maxWidth = Constraints.m5930getMaxWidthimpl($this$tryMaxWidth_u2dJN_u2d0ABg);
        if (maxWidth != Integer.MAX_VALUE && (height = MathKt.roundToInt(((float) maxWidth) / this.aspectRatio)) > 0) {
            long size = IntSizeKt.IntSize(maxWidth, height);
            if (!enforceConstraints || ConstraintsKt.m5945isSatisfiedBy4WqzIAM($this$tryMaxWidth_u2dJN_u2d0ABg, size)) {
                return size;
            }
        }
        return IntSize.Companion.m6151getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m703tryMaxHeightJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m702tryMaxHeightJN0ABg(j, z);
    }

    /* renamed from: tryMaxHeight-JN-0ABg  reason: not valid java name */
    private final long m702tryMaxHeightJN0ABg(long $this$tryMaxHeight_u2dJN_u2d0ABg, boolean enforceConstraints) {
        int width;
        int maxHeight = Constraints.m5929getMaxHeightimpl($this$tryMaxHeight_u2dJN_u2d0ABg);
        if (maxHeight != Integer.MAX_VALUE && (width = MathKt.roundToInt(((float) maxHeight) * this.aspectRatio)) > 0) {
            long size = IntSizeKt.IntSize(width, maxHeight);
            if (!enforceConstraints || ConstraintsKt.m5945isSatisfiedBy4WqzIAM($this$tryMaxHeight_u2dJN_u2d0ABg, size)) {
                return size;
            }
        }
        return IntSize.Companion.m6151getZeroYbymL2g();
    }

    /* renamed from: tryMinWidth-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m709tryMinWidthJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m708tryMinWidthJN0ABg(j, z);
    }

    /* renamed from: tryMinWidth-JN-0ABg  reason: not valid java name */
    private final long m708tryMinWidthJN0ABg(long $this$tryMinWidth_u2dJN_u2d0ABg, boolean enforceConstraints) {
        int minWidth = Constraints.m5932getMinWidthimpl($this$tryMinWidth_u2dJN_u2d0ABg);
        int height = MathKt.roundToInt(((float) minWidth) / this.aspectRatio);
        if (height > 0) {
            long size = IntSizeKt.IntSize(minWidth, height);
            if (!enforceConstraints || ConstraintsKt.m5945isSatisfiedBy4WqzIAM($this$tryMinWidth_u2dJN_u2d0ABg, size)) {
                return size;
            }
        }
        return IntSize.Companion.m6151getZeroYbymL2g();
    }

    /* renamed from: tryMinHeight-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m707tryMinHeightJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m706tryMinHeightJN0ABg(j, z);
    }

    /* renamed from: tryMinHeight-JN-0ABg  reason: not valid java name */
    private final long m706tryMinHeightJN0ABg(long $this$tryMinHeight_u2dJN_u2d0ABg, boolean enforceConstraints) {
        int minHeight = Constraints.m5931getMinHeightimpl($this$tryMinHeight_u2dJN_u2d0ABg);
        int width = MathKt.roundToInt(((float) minHeight) * this.aspectRatio);
        if (width > 0) {
            long size = IntSizeKt.IntSize(width, minHeight);
            if (!enforceConstraints || ConstraintsKt.m5945isSatisfiedBy4WqzIAM($this$tryMinHeight_u2dJN_u2d0ABg, size)) {
                return size;
            }
        }
        return IntSize.Companion.m6151getZeroYbymL2g();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        AspectRatioModifier otherModifier = other instanceof AspectRatioModifier ? (AspectRatioModifier) other : null;
        if (otherModifier == null) {
            return false;
        }
        if (!(this.aspectRatio == otherModifier.aspectRatio) || this.matchHeightConstraintsFirst != ((AspectRatioModifier) other).matchHeightConstraintsFirst) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (Float.hashCode(this.aspectRatio) * 31) + Boolean.hashCode(this.matchHeightConstraintsFirst);
    }

    public String toString() {
        return "AspectRatioModifier(aspectRatio=" + this.aspectRatio + ')';
    }
}
