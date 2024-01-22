package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0012\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a.\u0010\u0018\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a.\u0010\u0019\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a.\u0010\u001a\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001ad\u0010\u001b\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\u001d\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u001d\u0010 \u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0002\u001aE\u0010#\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\u001d\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0002\u001at\u0010%\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\u001d\u0010&\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u001d\u0010'\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0017H\u0002\u001aa\u0010*\u001a\u00020+2\u0006\u0010\u0016\u001a\u00020\u00172*\u0010,\u001a&\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u0002010-2\u0006\u00102\u001a\u0002032\u0006\u0010 \u001a\u0002042\u0006\u0010\u0000\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u001a\u0010\t\u001a\u00020\u0006*\u0004\u0018\u00010\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b\"\u001a\u0010\n\u001a\u0004\u0018\u00010\u0002*\u00020\u000b8@X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u001a\u0010\u000e\u001a\u00020\u000f*\u0004\u0018\u00010\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00067"}, d2 = {"crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "Landroidx/compose/foundation/layout/RowColumnParentData;", "getCrossAxisAlignment", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Landroidx/compose/foundation/layout/CrossAxisAlignment;", "fill", "", "getFill", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Z", "isRelative", "rowColumnParentData", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getRowColumnParentData", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Landroidx/compose/foundation/layout/RowColumnParentData;", "weight", "", "getWeight", "(Landroidx/compose/foundation/layout/RowColumnParentData;)F", "MaxIntrinsicHeightMeasureBlock", "Lkotlin/Function3;", "", "", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "MaxIntrinsicWidthMeasureBlock", "MinIntrinsicHeightMeasureBlock", "MinIntrinsicWidthMeasureBlock", "intrinsicCrossAxisSize", "children", "mainAxisSize", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "crossAxisSize", "mainAxisAvailable", "mainAxisSpacing", "intrinsicMainAxisSize", "crossAxisAvailable", "intrinsicSize", "intrinsicMainSize", "intrinsicCrossSize", "layoutOrientation", "intrinsicOrientation", "rowColumnMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "arrangement", "Lkotlin/Function5;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "", "arrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/foundation/layout/SizeMode;", "rowColumnMeasurePolicy-TDGSqEk", "(Landroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/functions/Function5;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;)Landroidx/compose/ui/layout/MeasurePolicy;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: RowColumnImpl.kt */
public final class RowColumnImplKt {
    /* renamed from: rowColumnMeasurePolicy-TDGSqEk  reason: not valid java name */
    public static final MeasurePolicy m799rowColumnMeasurePolicyTDGSqEk(LayoutOrientation orientation, Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> arrangement, float arrangementSpacing, SizeMode crossAxisSize, CrossAxisAlignment crossAxisAlignment) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(arrangement, "arrangement");
        Intrinsics.checkNotNullParameter(crossAxisSize, "crossAxisSize");
        Intrinsics.checkNotNullParameter(crossAxisAlignment, "crossAxisAlignment");
        return new RowColumnImplKt$rowColumnMeasurePolicy$1(orientation, arrangement, arrangementSpacing, crossAxisSize, crossAxisAlignment);
    }

    public static final RowColumnParentData getRowColumnParentData(IntrinsicMeasurable $this$rowColumnParentData) {
        Intrinsics.checkNotNullParameter($this$rowColumnParentData, "<this>");
        Object parentData = $this$rowColumnParentData.getParentData();
        if (parentData instanceof RowColumnParentData) {
            return (RowColumnParentData) parentData;
        }
        return null;
    }

    public static final float getWeight(RowColumnParentData $this$weight) {
        if ($this$weight != null) {
            return $this$weight.getWeight();
        }
        return 0.0f;
    }

    public static final boolean getFill(RowColumnParentData $this$fill) {
        if ($this$fill != null) {
            return $this$fill.getFill();
        }
        return true;
    }

    public static final CrossAxisAlignment getCrossAxisAlignment(RowColumnParentData $this$crossAxisAlignment) {
        if ($this$crossAxisAlignment != null) {
            return $this$crossAxisAlignment.getCrossAxisAlignment();
        }
        return null;
    }

    public static final boolean isRelative(RowColumnParentData $this$isRelative) {
        CrossAxisAlignment crossAxisAlignment = getCrossAxisAlignment($this$isRelative);
        if (crossAxisAlignment != null) {
            return crossAxisAlignment.isRelative$foundation_layout_release();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MinIntrinsicWidthMeasureBlock(LayoutOrientation orientation) {
        if (orientation == LayoutOrientation.Horizontal) {
            return IntrinsicMeasureBlocks.INSTANCE.getHorizontalMinWidth();
        }
        return IntrinsicMeasureBlocks.INSTANCE.getVerticalMinWidth();
    }

    /* access modifiers changed from: private */
    public static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MinIntrinsicHeightMeasureBlock(LayoutOrientation orientation) {
        if (orientation == LayoutOrientation.Horizontal) {
            return IntrinsicMeasureBlocks.INSTANCE.getHorizontalMinHeight();
        }
        return IntrinsicMeasureBlocks.INSTANCE.getVerticalMinHeight();
    }

    /* access modifiers changed from: private */
    public static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MaxIntrinsicWidthMeasureBlock(LayoutOrientation orientation) {
        if (orientation == LayoutOrientation.Horizontal) {
            return IntrinsicMeasureBlocks.INSTANCE.getHorizontalMaxWidth();
        }
        return IntrinsicMeasureBlocks.INSTANCE.getVerticalMaxWidth();
    }

    /* access modifiers changed from: private */
    public static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MaxIntrinsicHeightMeasureBlock(LayoutOrientation orientation) {
        if (orientation == LayoutOrientation.Horizontal) {
            return IntrinsicMeasureBlocks.INSTANCE.getHorizontalMaxHeight();
        }
        return IntrinsicMeasureBlocks.INSTANCE.getVerticalMaxHeight();
    }

    /* access modifiers changed from: private */
    public static final int intrinsicSize(List<? extends IntrinsicMeasurable> children, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicMainSize, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> intrinsicCrossSize, int crossAxisAvailable, int mainAxisSpacing, LayoutOrientation layoutOrientation, LayoutOrientation intrinsicOrientation) {
        if (layoutOrientation == intrinsicOrientation) {
            return intrinsicMainAxisSize(children, intrinsicMainSize, crossAxisAvailable, mainAxisSpacing);
        }
        return intrinsicCrossAxisSize(children, intrinsicCrossSize, intrinsicMainSize, crossAxisAvailable, mainAxisSpacing);
    }

    private static final int intrinsicMainAxisSize(List<? extends IntrinsicMeasurable> children, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> mainAxisSize, int crossAxisAvailable, int mainAxisSpacing) {
        int weightUnitSpace = 0;
        int fixedSpace = 0;
        float totalWeight = 0.0f;
        List $this$fastForEach$iv = children;
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (true) {
            boolean z = true;
            if (index$iv < size) {
                IntrinsicMeasurable child = (IntrinsicMeasurable) $this$fastForEach$iv.get(index$iv);
                float weight = getWeight(getRowColumnParentData(child));
                int size2 = mainAxisSize.invoke(child, Integer.valueOf(crossAxisAvailable)).intValue();
                if (weight != 0.0f) {
                    z = false;
                }
                if (z) {
                    fixedSpace += size2;
                } else if (weight > 0.0f) {
                    totalWeight += weight;
                    weightUnitSpace = Math.max(weightUnitSpace, MathKt.roundToInt(((float) size2) / weight));
                }
                index$iv++;
            } else {
                Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2 = mainAxisSize;
                return MathKt.roundToInt(((float) weightUnitSpace) * totalWeight) + fixedSpace + ((children.size() - 1) * mainAxisSpacing);
            }
        }
    }

    private static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> children, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> mainAxisSize, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> crossAxisSize, int mainAxisAvailable, int mainAxisSpacing) {
        int i;
        float f;
        int i2;
        Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2 = crossAxisSize;
        int i3 = mainAxisAvailable;
        boolean z = true;
        int fixedSpace = Math.min((children.size() - 1) * mainAxisSpacing, i3);
        int crossAxisMax = 0;
        float totalWeight = 0.0f;
        List $this$fastForEach$iv = children;
        int index$iv = 0;
        int size = $this$fastForEach$iv.size();
        while (true) {
            i = 0;
            f = 0.0f;
            if (index$iv >= size) {
                break;
            }
            IntrinsicMeasurable child = (IntrinsicMeasurable) $this$fastForEach$iv.get(index$iv);
            float weight = getWeight(getRowColumnParentData(child));
            if (weight == 0.0f) {
                i = 1;
            }
            if (i != 0) {
                int mainAxisSpace = Math.min(mainAxisSize.invoke(child, Integer.MAX_VALUE).intValue(), i3 - fixedSpace);
                fixedSpace += mainAxisSpace;
                crossAxisMax = Math.max(crossAxisMax, function2.invoke(child, Integer.valueOf(mainAxisSpace)).intValue());
            } else {
                Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function22 = mainAxisSize;
                if (weight > 0.0f) {
                    totalWeight += weight;
                }
            }
            index$iv++;
        }
        if (totalWeight != 0.0f) {
            z = false;
        }
        if (!z) {
            if (i3 == Integer.MAX_VALUE) {
                i = Integer.MAX_VALUE;
            } else {
                i = MathKt.roundToInt(((float) Math.max(i3 - fixedSpace, 0)) / totalWeight);
            }
        }
        int weightUnitSpace = i;
        List $this$fastForEach$iv2 = children;
        int index$iv2 = 0;
        int size2 = $this$fastForEach$iv2.size();
        while (index$iv2 < size2) {
            IntrinsicMeasurable child2 = (IntrinsicMeasurable) $this$fastForEach$iv2.get(index$iv2);
            float weight2 = getWeight(getRowColumnParentData(child2));
            if (weight2 > f) {
                if (weightUnitSpace != Integer.MAX_VALUE) {
                    i2 = MathKt.roundToInt(((float) weightUnitSpace) * weight2);
                } else {
                    i2 = Integer.MAX_VALUE;
                }
                crossAxisMax = Math.max(crossAxisMax, function2.invoke(child2, Integer.valueOf(i2)).intValue());
            }
            index$iv2++;
            f = 0.0f;
        }
        return crossAxisMax;
    }
}
