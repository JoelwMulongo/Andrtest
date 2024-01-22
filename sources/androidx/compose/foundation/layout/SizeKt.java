package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0017\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a-\u0010\u0019\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0016\u0010 \u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001a\u0016\u0010!\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001a\u0016\u0010\"\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u001a!\u0010#\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010#\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%\u001a-\u0010&\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010\u001f\u001a!\u0010*\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010#\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010%\u001a-\u0010,\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010\u001f\u001a!\u0010.\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010/\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010%\u001a)\u0010.\u001a\u00020\u001a*\u00020\u001a2\u0006\u00101\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u0010\u001f\u001a!\u0010.\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010/\u001a\u000203H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\u001aA\u00106\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u00107\u001a\u00020\u001c2\b\b\u0002\u00108\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:\u001a!\u0010;\u001a\u00020\u001a*\u00020\u001a2\u0006\u00101\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b<\u0010%\u001a-\u0010=\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010\u001f\u001a!\u0010/\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010/\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b?\u0010%\u001a)\u0010/\u001a\u00020\u001a*\u00020\u001a2\u0006\u00101\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010\u001f\u001a!\u0010/\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010/\u001a\u000203H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bA\u00105\u001aA\u0010B\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u00107\u001a\u00020\u001c2\b\b\u0002\u00108\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010:\u001a!\u00101\u001a\u00020\u001a*\u00020\u001a2\u0006\u00101\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010%\u001a-\u0010E\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010'\u001a\u00020\u001c2\b\b\u0002\u0010(\u001a\u00020\u001cH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bF\u0010\u001f\u001a \u0010G\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\u001a \u0010H\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u00162\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\u001a \u0010I\u001a\u00020\u001a*\u00020\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u00182\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006J"}, d2 = {"FillWholeMaxHeight", "Landroidx/compose/foundation/layout/FillModifier;", "FillWholeMaxSize", "FillWholeMaxWidth", "WrapContentHeightCenter", "Landroidx/compose/foundation/layout/WrapContentModifier;", "WrapContentHeightTop", "WrapContentSizeCenter", "WrapContentSizeTopStart", "WrapContentWidthCenter", "WrapContentWidthStart", "createFillHeightModifier", "fraction", "", "createFillSizeModifier", "createFillWidthModifier", "createWrapContentHeightModifier", "align", "Landroidx/compose/ui/Alignment$Vertical;", "unbounded", "", "createWrapContentSizeModifier", "Landroidx/compose/ui/Alignment;", "createWrapContentWidthModifier", "Landroidx/compose/ui/Alignment$Horizontal;", "defaultMinSize", "Landroidx/compose/ui/Modifier;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "defaultMinSize-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "fillMaxHeight", "fillMaxSize", "fillMaxWidth", "height", "height-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "heightIn", "min", "max", "heightIn-VpY3zN4", "requiredHeight", "requiredHeight-3ABfNKs", "requiredHeightIn", "requiredHeightIn-VpY3zN4", "requiredSize", "size", "requiredSize-3ABfNKs", "width", "requiredSize-VpY3zN4", "Landroidx/compose/ui/unit/DpSize;", "requiredSize-6HolHcs", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "requiredSizeIn", "maxWidth", "maxHeight", "requiredSizeIn-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "requiredWidth", "requiredWidth-3ABfNKs", "requiredWidthIn", "requiredWidthIn-VpY3zN4", "size-3ABfNKs", "size-VpY3zN4", "size-6HolHcs", "sizeIn", "sizeIn-qDBjuR0", "width-3ABfNKs", "widthIn", "widthIn-VpY3zN4", "wrapContentHeight", "wrapContentSize", "wrapContentWidth", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
public final class SizeKt {
    private static final FillModifier FillWholeMaxHeight = createFillHeightModifier(1.0f);
    private static final FillModifier FillWholeMaxSize = createFillSizeModifier(1.0f);
    private static final FillModifier FillWholeMaxWidth = createFillWidthModifier(1.0f);
    private static final WrapContentModifier WrapContentHeightCenter = createWrapContentHeightModifier(Alignment.Companion.getCenterVertically(), false);
    private static final WrapContentModifier WrapContentHeightTop = createWrapContentHeightModifier(Alignment.Companion.getTop(), false);
    private static final WrapContentModifier WrapContentSizeCenter = createWrapContentSizeModifier(Alignment.Companion.getCenter(), false);
    private static final WrapContentModifier WrapContentSizeTopStart = createWrapContentSizeModifier(Alignment.Companion.getTopStart(), false);
    private static final WrapContentModifier WrapContentWidthCenter = createWrapContentWidthModifier(Alignment.Companion.getCenterHorizontally(), false);
    private static final WrapContentModifier WrapContentWidthStart = createWrapContentWidthModifier(Alignment.Companion.getStart(), false);

    /* renamed from: width-3ABfNKs  reason: not valid java name */
    public static final Modifier m835width3ABfNKs(Modifier $this$width_u2d3ABfNKs, float width) {
        Intrinsics.checkNotNullParameter($this$width_u2d3ABfNKs, "$this$width");
        return $this$width_u2d3ABfNKs.then(new SizeModifier(width, 0.0f, width, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$width3ABfNKs$$inlined$debugInspectorInfo$1(width) : InspectableValueKt.getNoInspectorInfo(), 10, (DefaultConstructorMarker) null));
    }

    /* renamed from: height-3ABfNKs  reason: not valid java name */
    public static final Modifier m816height3ABfNKs(Modifier $this$height_u2d3ABfNKs, float height) {
        Intrinsics.checkNotNullParameter($this$height_u2d3ABfNKs, "$this$height");
        return $this$height_u2d3ABfNKs.then(new SizeModifier(0.0f, height, 0.0f, height, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$height3ABfNKs$$inlined$debugInspectorInfo$1(height) : InspectableValueKt.getNoInspectorInfo(), 5, (DefaultConstructorMarker) null));
    }

    /* renamed from: size-3ABfNKs  reason: not valid java name */
    public static final Modifier m830size3ABfNKs(Modifier $this$size_u2d3ABfNKs, float size) {
        Intrinsics.checkNotNullParameter($this$size_u2d3ABfNKs, "$this$size");
        return $this$size_u2d3ABfNKs.then(new SizeModifier(size, size, size, size, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$size3ABfNKs$$inlined$debugInspectorInfo$1(size) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: size-VpY3zN4  reason: not valid java name */
    public static final Modifier m832sizeVpY3zN4(Modifier $this$size_u2dVpY3zN4, float width, float height) {
        Intrinsics.checkNotNullParameter($this$size_u2dVpY3zN4, "$this$size");
        return $this$size_u2dVpY3zN4.then(new SizeModifier(width, height, width, height, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$sizeVpY3zN4$$inlined$debugInspectorInfo$1(width, height) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: size-6HolHcs  reason: not valid java name */
    public static final Modifier m831size6HolHcs(Modifier $this$size_u2d6HolHcs, long size) {
        Intrinsics.checkNotNullParameter($this$size_u2d6HolHcs, "$this$size");
        return m832sizeVpY3zN4($this$size_u2d6HolHcs, DpSize.m6084getWidthD9Ej5fM(size), DpSize.m6082getHeightD9Ej5fM(size));
    }

    /* renamed from: widthIn-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m837widthInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        return m836widthInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: widthIn-VpY3zN4  reason: not valid java name */
    public static final Modifier m836widthInVpY3zN4(Modifier $this$widthIn_u2dVpY3zN4, float min, float max) {
        Intrinsics.checkNotNullParameter($this$widthIn_u2dVpY3zN4, "$this$widthIn");
        return $this$widthIn_u2dVpY3zN4.then(new SizeModifier(min, 0.0f, max, 0.0f, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$widthInVpY3zN4$$inlined$debugInspectorInfo$1(min, max) : InspectableValueKt.getNoInspectorInfo(), 10, (DefaultConstructorMarker) null));
    }

    /* renamed from: heightIn-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m818heightInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        return m817heightInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: heightIn-VpY3zN4  reason: not valid java name */
    public static final Modifier m817heightInVpY3zN4(Modifier $this$heightIn_u2dVpY3zN4, float min, float max) {
        Intrinsics.checkNotNullParameter($this$heightIn_u2dVpY3zN4, "$this$heightIn");
        return $this$heightIn_u2dVpY3zN4.then(new SizeModifier(0.0f, min, 0.0f, max, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$heightInVpY3zN4$$inlined$debugInspectorInfo$1(min, max) : InspectableValueKt.getNoInspectorInfo(), 5, (DefaultConstructorMarker) null));
    }

    /* renamed from: sizeIn-qDBjuR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m834sizeInqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f3 = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        if ((i & 8) != 0) {
            f4 = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        return m833sizeInqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* renamed from: sizeIn-qDBjuR0  reason: not valid java name */
    public static final Modifier m833sizeInqDBjuR0(Modifier $this$sizeIn_u2dqDBjuR0, float minWidth, float minHeight, float maxWidth, float maxHeight) {
        Intrinsics.checkNotNullParameter($this$sizeIn_u2dqDBjuR0, "$this$sizeIn");
        return $this$sizeIn_u2dqDBjuR0.then(new SizeModifier(minWidth, minHeight, maxWidth, maxHeight, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$sizeInqDBjuR0$$inlined$debugInspectorInfo$1(minWidth, minHeight, maxWidth, maxHeight) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredWidth-3ABfNKs  reason: not valid java name */
    public static final Modifier m827requiredWidth3ABfNKs(Modifier $this$requiredWidth_u2d3ABfNKs, float width) {
        Intrinsics.checkNotNullParameter($this$requiredWidth_u2d3ABfNKs, "$this$requiredWidth");
        return $this$requiredWidth_u2d3ABfNKs.then(new SizeModifier(width, 0.0f, width, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredWidth3ABfNKs$$inlined$debugInspectorInfo$1(width) : InspectableValueKt.getNoInspectorInfo(), 10, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredHeight-3ABfNKs  reason: not valid java name */
    public static final Modifier m819requiredHeight3ABfNKs(Modifier $this$requiredHeight_u2d3ABfNKs, float height) {
        Intrinsics.checkNotNullParameter($this$requiredHeight_u2d3ABfNKs, "$this$requiredHeight");
        return $this$requiredHeight_u2d3ABfNKs.then(new SizeModifier(0.0f, height, 0.0f, height, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredHeight3ABfNKs$$inlined$debugInspectorInfo$1(height) : InspectableValueKt.getNoInspectorInfo(), 5, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredSize-3ABfNKs  reason: not valid java name */
    public static final Modifier m822requiredSize3ABfNKs(Modifier $this$requiredSize_u2d3ABfNKs, float size) {
        Intrinsics.checkNotNullParameter($this$requiredSize_u2d3ABfNKs, "$this$requiredSize");
        return $this$requiredSize_u2d3ABfNKs.then(new SizeModifier(size, size, size, size, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredSize3ABfNKs$$inlined$debugInspectorInfo$1(size) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredSize-VpY3zN4  reason: not valid java name */
    public static final Modifier m824requiredSizeVpY3zN4(Modifier $this$requiredSize_u2dVpY3zN4, float width, float height) {
        Intrinsics.checkNotNullParameter($this$requiredSize_u2dVpY3zN4, "$this$requiredSize");
        return $this$requiredSize_u2dVpY3zN4.then(new SizeModifier(width, height, width, height, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredSizeVpY3zN4$$inlined$debugInspectorInfo$1(width, height) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredSize-6HolHcs  reason: not valid java name */
    public static final Modifier m823requiredSize6HolHcs(Modifier $this$requiredSize_u2d6HolHcs, long size) {
        Intrinsics.checkNotNullParameter($this$requiredSize_u2d6HolHcs, "$this$requiredSize");
        return m824requiredSizeVpY3zN4($this$requiredSize_u2d6HolHcs, DpSize.m6084getWidthD9Ej5fM(size), DpSize.m6082getHeightD9Ej5fM(size));
    }

    /* renamed from: requiredWidthIn-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m829requiredWidthInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        return m828requiredWidthInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: requiredWidthIn-VpY3zN4  reason: not valid java name */
    public static final Modifier m828requiredWidthInVpY3zN4(Modifier $this$requiredWidthIn_u2dVpY3zN4, float min, float max) {
        Intrinsics.checkNotNullParameter($this$requiredWidthIn_u2dVpY3zN4, "$this$requiredWidthIn");
        return $this$requiredWidthIn_u2dVpY3zN4.then(new SizeModifier(min, 0.0f, max, 0.0f, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredWidthInVpY3zN4$$inlined$debugInspectorInfo$1(min, max) : InspectableValueKt.getNoInspectorInfo(), 10, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredHeightIn-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m821requiredHeightInVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        return m820requiredHeightInVpY3zN4(modifier, f, f2);
    }

    /* renamed from: requiredHeightIn-VpY3zN4  reason: not valid java name */
    public static final Modifier m820requiredHeightInVpY3zN4(Modifier $this$requiredHeightIn_u2dVpY3zN4, float min, float max) {
        Intrinsics.checkNotNullParameter($this$requiredHeightIn_u2dVpY3zN4, "$this$requiredHeightIn");
        return $this$requiredHeightIn_u2dVpY3zN4.then(new SizeModifier(0.0f, min, 0.0f, max, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredHeightInVpY3zN4$$inlined$debugInspectorInfo$1(min, max) : InspectableValueKt.getNoInspectorInfo(), 5, (DefaultConstructorMarker) null));
    }

    /* renamed from: requiredSizeIn-qDBjuR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m826requiredSizeInqDBjuR0$default(Modifier modifier, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        if ((i & 4) != 0) {
            f3 = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        if ((i & 8) != 0) {
            f4 = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        return m825requiredSizeInqDBjuR0(modifier, f, f2, f3, f4);
    }

    /* renamed from: requiredSizeIn-qDBjuR0  reason: not valid java name */
    public static final Modifier m825requiredSizeInqDBjuR0(Modifier $this$requiredSizeIn_u2dqDBjuR0, float minWidth, float minHeight, float maxWidth, float maxHeight) {
        Intrinsics.checkNotNullParameter($this$requiredSizeIn_u2dqDBjuR0, "$this$requiredSizeIn");
        return $this$requiredSizeIn_u2dqDBjuR0.then(new SizeModifier(minWidth, minHeight, maxWidth, maxHeight, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$requiredSizeInqDBjuR0$$inlined$debugInspectorInfo$1(minWidth, minHeight, maxWidth, maxHeight) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    public static /* synthetic */ Modifier fillMaxWidth$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxWidth(modifier, f);
    }

    public static final Modifier fillMaxWidth(Modifier $this$fillMaxWidth, float fraction) {
        Intrinsics.checkNotNullParameter($this$fillMaxWidth, "<this>");
        return $this$fillMaxWidth.then((fraction > 1.0f ? 1 : (fraction == 1.0f ? 0 : -1)) == 0 ? FillWholeMaxWidth : createFillWidthModifier(fraction));
    }

    public static /* synthetic */ Modifier fillMaxHeight$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxHeight(modifier, f);
    }

    public static final Modifier fillMaxHeight(Modifier $this$fillMaxHeight, float fraction) {
        Intrinsics.checkNotNullParameter($this$fillMaxHeight, "<this>");
        return $this$fillMaxHeight.then((fraction > 1.0f ? 1 : (fraction == 1.0f ? 0 : -1)) == 0 ? FillWholeMaxHeight : createFillHeightModifier(fraction));
    }

    public static /* synthetic */ Modifier fillMaxSize$default(Modifier modifier, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        return fillMaxSize(modifier, f);
    }

    public static final Modifier fillMaxSize(Modifier $this$fillMaxSize, float fraction) {
        Intrinsics.checkNotNullParameter($this$fillMaxSize, "<this>");
        return $this$fillMaxSize.then((fraction > 1.0f ? 1 : (fraction == 1.0f ? 0 : -1)) == 0 ? FillWholeMaxSize : createFillSizeModifier(fraction));
    }

    public static /* synthetic */ Modifier wrapContentWidth$default(Modifier modifier, Alignment.Horizontal horizontal, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            horizontal = Alignment.Companion.getCenterHorizontally();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentWidth(modifier, horizontal, z);
    }

    public static final Modifier wrapContentWidth(Modifier $this$wrapContentWidth, Alignment.Horizontal align, boolean unbounded) {
        WrapContentModifier wrapContentModifier;
        Intrinsics.checkNotNullParameter($this$wrapContentWidth, "<this>");
        Intrinsics.checkNotNullParameter(align, "align");
        if (Intrinsics.areEqual((Object) align, (Object) Alignment.Companion.getCenterHorizontally()) && !unbounded) {
            wrapContentModifier = WrapContentWidthCenter;
        } else if (!Intrinsics.areEqual((Object) align, (Object) Alignment.Companion.getStart()) || unbounded) {
            wrapContentModifier = createWrapContentWidthModifier(align, unbounded);
        } else {
            wrapContentModifier = WrapContentWidthStart;
        }
        return $this$wrapContentWidth.then(wrapContentModifier);
    }

    public static /* synthetic */ Modifier wrapContentHeight$default(Modifier modifier, Alignment.Vertical vertical, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            vertical = Alignment.Companion.getCenterVertically();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentHeight(modifier, vertical, z);
    }

    public static final Modifier wrapContentHeight(Modifier $this$wrapContentHeight, Alignment.Vertical align, boolean unbounded) {
        WrapContentModifier wrapContentModifier;
        Intrinsics.checkNotNullParameter($this$wrapContentHeight, "<this>");
        Intrinsics.checkNotNullParameter(align, "align");
        if (Intrinsics.areEqual((Object) align, (Object) Alignment.Companion.getCenterVertically()) && !unbounded) {
            wrapContentModifier = WrapContentHeightCenter;
        } else if (!Intrinsics.areEqual((Object) align, (Object) Alignment.Companion.getTop()) || unbounded) {
            wrapContentModifier = createWrapContentHeightModifier(align, unbounded);
        } else {
            wrapContentModifier = WrapContentHeightTop;
        }
        return $this$wrapContentHeight.then(wrapContentModifier);
    }

    public static /* synthetic */ Modifier wrapContentSize$default(Modifier modifier, Alignment alignment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            alignment = Alignment.Companion.getCenter();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return wrapContentSize(modifier, alignment, z);
    }

    public static final Modifier wrapContentSize(Modifier $this$wrapContentSize, Alignment align, boolean unbounded) {
        WrapContentModifier wrapContentModifier;
        Intrinsics.checkNotNullParameter($this$wrapContentSize, "<this>");
        Intrinsics.checkNotNullParameter(align, "align");
        if (Intrinsics.areEqual((Object) align, (Object) Alignment.Companion.getCenter()) && !unbounded) {
            wrapContentModifier = WrapContentSizeCenter;
        } else if (!Intrinsics.areEqual((Object) align, (Object) Alignment.Companion.getTopStart()) || unbounded) {
            wrapContentModifier = createWrapContentSizeModifier(align, unbounded);
        } else {
            wrapContentModifier = WrapContentSizeTopStart;
        }
        return $this$wrapContentSize.then(wrapContentModifier);
    }

    /* renamed from: defaultMinSize-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m815defaultMinSizeVpY3zN4$default(Modifier modifier, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        if ((i & 2) != 0) {
            f2 = Dp.Companion.m6006getUnspecifiedD9Ej5fM();
        }
        return m814defaultMinSizeVpY3zN4(modifier, f, f2);
    }

    /* renamed from: defaultMinSize-VpY3zN4  reason: not valid java name */
    public static final Modifier m814defaultMinSizeVpY3zN4(Modifier $this$defaultMinSize_u2dVpY3zN4, float minWidth, float minHeight) {
        Intrinsics.checkNotNullParameter($this$defaultMinSize_u2dVpY3zN4, "$this$defaultMinSize");
        return $this$defaultMinSize_u2dVpY3zN4.then(new UnspecifiedConstraintsModifier(minWidth, minHeight, InspectableValueKt.isDebugInspectorInfoEnabled() ? new SizeKt$defaultMinSizeVpY3zN4$$inlined$debugInspectorInfo$1(minWidth, minHeight) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    private static final FillModifier createFillWidthModifier(float fraction) {
        return new FillModifier(Direction.Horizontal, fraction, new SizeKt$createFillWidthModifier$1(fraction));
    }

    private static final FillModifier createFillHeightModifier(float fraction) {
        return new FillModifier(Direction.Vertical, fraction, new SizeKt$createFillHeightModifier$1(fraction));
    }

    private static final FillModifier createFillSizeModifier(float fraction) {
        return new FillModifier(Direction.Both, fraction, new SizeKt$createFillSizeModifier$1(fraction));
    }

    private static final WrapContentModifier createWrapContentWidthModifier(Alignment.Horizontal align, boolean unbounded) {
        return new WrapContentModifier(Direction.Horizontal, unbounded, new SizeKt$createWrapContentWidthModifier$1(align), align, new SizeKt$createWrapContentWidthModifier$2(align, unbounded));
    }

    private static final WrapContentModifier createWrapContentHeightModifier(Alignment.Vertical align, boolean unbounded) {
        return new WrapContentModifier(Direction.Vertical, unbounded, new SizeKt$createWrapContentHeightModifier$1(align), align, new SizeKt$createWrapContentHeightModifier$2(align, unbounded));
    }

    private static final WrapContentModifier createWrapContentSizeModifier(Alignment align, boolean unbounded) {
        return new WrapContentModifier(Direction.Both, unbounded, new SizeKt$createWrapContentSizeModifier$1(align), align, new SizeKt$createWrapContentSizeModifier$2(align, unbounded));
    }
}
