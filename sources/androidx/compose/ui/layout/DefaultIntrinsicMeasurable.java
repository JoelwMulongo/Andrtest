package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\u001d\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Landroidx/compose/ui/layout/DefaultIntrinsicMeasurable;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "minMax", "Landroidx/compose/ui/layout/IntrinsicMinMax;", "widthHeight", "Landroidx/compose/ui/layout/IntrinsicWidthHeight;", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/layout/IntrinsicMinMax;Landroidx/compose/ui/layout/IntrinsicWidthHeight;)V", "getMeasurable", "()Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getMinMax", "()Landroidx/compose/ui/layout/IntrinsicMinMax;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "getWidthHeight", "()Landroidx/compose/ui/layout/IntrinsicWidthHeight;", "maxIntrinsicHeight", "", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Layout.kt */
public final class DefaultIntrinsicMeasurable implements Measurable {
    private final IntrinsicMeasurable measurable;
    private final IntrinsicMinMax minMax;
    private final IntrinsicWidthHeight widthHeight;

    public DefaultIntrinsicMeasurable(IntrinsicMeasurable measurable2, IntrinsicMinMax minMax2, IntrinsicWidthHeight widthHeight2) {
        Intrinsics.checkNotNullParameter(measurable2, "measurable");
        Intrinsics.checkNotNullParameter(minMax2, "minMax");
        Intrinsics.checkNotNullParameter(widthHeight2, "widthHeight");
        this.measurable = measurable2;
        this.minMax = minMax2;
        this.widthHeight = widthHeight2;
    }

    public final IntrinsicMeasurable getMeasurable() {
        return this.measurable;
    }

    public final IntrinsicMinMax getMinMax() {
        return this.minMax;
    }

    public final IntrinsicWidthHeight getWidthHeight() {
        return this.widthHeight;
    }

    public Object getParentData() {
        return this.measurable.getParentData();
    }

    /* renamed from: measure-BRTryo0  reason: not valid java name */
    public Placeable m4821measureBRTryo0(long constraints) {
        int height;
        int width;
        if (this.widthHeight == IntrinsicWidthHeight.Width) {
            if (this.minMax == IntrinsicMinMax.Max) {
                width = this.measurable.maxIntrinsicWidth(Constraints.m5929getMaxHeightimpl(constraints));
            } else {
                width = this.measurable.minIntrinsicWidth(Constraints.m5929getMaxHeightimpl(constraints));
            }
            return new FixedSizeIntrinsicsPlaceable(width, Constraints.m5929getMaxHeightimpl(constraints));
        }
        if (this.minMax == IntrinsicMinMax.Max) {
            height = this.measurable.maxIntrinsicHeight(Constraints.m5930getMaxWidthimpl(constraints));
        } else {
            height = this.measurable.minIntrinsicHeight(Constraints.m5930getMaxWidthimpl(constraints));
        }
        return new FixedSizeIntrinsicsPlaceable(Constraints.m5930getMaxWidthimpl(constraints), height);
    }

    public int minIntrinsicWidth(int height) {
        return this.measurable.minIntrinsicWidth(height);
    }

    public int maxIntrinsicWidth(int height) {
        return this.measurable.maxIntrinsicWidth(height);
    }

    public int minIntrinsicHeight(int width) {
        return this.measurable.minIntrinsicHeight(width);
    }

    public int maxIntrinsicHeight(int width) {
        return this.measurable.maxIntrinsicHeight(width);
    }
}
