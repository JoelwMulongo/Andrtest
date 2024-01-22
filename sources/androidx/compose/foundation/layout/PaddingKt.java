package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a=\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001aA\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0007ø\u0001\u0001¢\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u001a\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0007ø\u0001\u0001¢\u0006\u0002\u0010\u0019\u001a\u0014\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0001H\u0007\u001a!\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a-\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001aA\u0010\u001b\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0015\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\""}, d2 = {"PaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "all", "Landroidx/compose/ui/unit/Dp;", "PaddingValues-0680j_4", "(F)Landroidx/compose/foundation/layout/PaddingValues;", "horizontal", "vertical", "PaddingValues-YgX7TsA", "(FF)Landroidx/compose/foundation/layout/PaddingValues;", "start", "top", "end", "bottom", "PaddingValues-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "absolutePadding", "Landroidx/compose/ui/Modifier;", "left", "right", "absolutePadding-qDBjuR0", "(Landroidx/compose/ui/Modifier;FFFF)Landroidx/compose/ui/Modifier;", "calculateEndPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateStartPadding", "padding", "paddingValues", "padding-3ABfNKs", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "padding-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "padding-qDBjuR0", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Padding.kt */
public final class PaddingKt {
    /* renamed from: padding-qDBjuR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m764paddingqDBjuR0$default(Modifier modifier, float $this$dp$iv, float $this$dp$iv2, float $this$dp$iv3, float $this$dp$iv4, int i, Object obj) {
        if ((i & 1) != 0) {
            $this$dp$iv = Dp.m5986constructorimpl((float) 0);
        }
        if ((i & 2) != 0) {
            $this$dp$iv2 = Dp.m5986constructorimpl((float) 0);
        }
        if ((i & 4) != 0) {
            $this$dp$iv3 = Dp.m5986constructorimpl((float) 0);
        }
        if ((i & 8) != 0) {
            $this$dp$iv4 = Dp.m5986constructorimpl((float) 0);
        }
        return m763paddingqDBjuR0(modifier, $this$dp$iv, $this$dp$iv2, $this$dp$iv3, $this$dp$iv4);
    }

    /* renamed from: padding-qDBjuR0  reason: not valid java name */
    public static final Modifier m763paddingqDBjuR0(Modifier $this$padding_u2dqDBjuR0, float start, float top, float end, float bottom) {
        Intrinsics.checkNotNullParameter($this$padding_u2dqDBjuR0, "$this$padding");
        return $this$padding_u2dqDBjuR0.then(new PaddingModifier(start, top, end, bottom, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PaddingKt$paddingqDBjuR0$$inlined$debugInspectorInfo$1(start, top, end, bottom) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: padding-VpY3zN4$default  reason: not valid java name */
    public static /* synthetic */ Modifier m762paddingVpY3zN4$default(Modifier modifier, float $this$dp$iv, float $this$dp$iv2, int i, Object obj) {
        if ((i & 1) != 0) {
            $this$dp$iv = Dp.m5986constructorimpl((float) 0);
        }
        if ((i & 2) != 0) {
            $this$dp$iv2 = Dp.m5986constructorimpl((float) 0);
        }
        return m761paddingVpY3zN4(modifier, $this$dp$iv, $this$dp$iv2);
    }

    /* renamed from: padding-VpY3zN4  reason: not valid java name */
    public static final Modifier m761paddingVpY3zN4(Modifier $this$padding_u2dVpY3zN4, float horizontal, float vertical) {
        Intrinsics.checkNotNullParameter($this$padding_u2dVpY3zN4, "$this$padding");
        return $this$padding_u2dVpY3zN4.then(new PaddingModifier(horizontal, vertical, horizontal, vertical, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PaddingKt$paddingVpY3zN4$$inlined$debugInspectorInfo$1(horizontal, vertical) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    /* renamed from: padding-3ABfNKs  reason: not valid java name */
    public static final Modifier m760padding3ABfNKs(Modifier $this$padding_u2d3ABfNKs, float all) {
        Intrinsics.checkNotNullParameter($this$padding_u2d3ABfNKs, "$this$padding");
        return $this$padding_u2d3ABfNKs.then(new PaddingModifier(all, all, all, all, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PaddingKt$padding3ABfNKs$$inlined$debugInspectorInfo$1(all) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    public static final Modifier padding(Modifier $this$padding, PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter($this$padding, "<this>");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return $this$padding.then(new PaddingValuesModifier(paddingValues, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PaddingKt$padding$$inlined$debugInspectorInfo$1(paddingValues) : InspectableValueKt.getNoInspectorInfo()));
    }

    /* renamed from: absolutePadding-qDBjuR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m759absolutePaddingqDBjuR0$default(Modifier modifier, float $this$dp$iv, float $this$dp$iv2, float $this$dp$iv3, float $this$dp$iv4, int i, Object obj) {
        if ((i & 1) != 0) {
            $this$dp$iv = Dp.m5986constructorimpl((float) 0);
        }
        if ((i & 2) != 0) {
            $this$dp$iv2 = Dp.m5986constructorimpl((float) 0);
        }
        if ((i & 4) != 0) {
            $this$dp$iv3 = Dp.m5986constructorimpl((float) 0);
        }
        if ((i & 8) != 0) {
            $this$dp$iv4 = Dp.m5986constructorimpl((float) 0);
        }
        return m758absolutePaddingqDBjuR0(modifier, $this$dp$iv, $this$dp$iv2, $this$dp$iv3, $this$dp$iv4);
    }

    /* renamed from: absolutePadding-qDBjuR0  reason: not valid java name */
    public static final Modifier m758absolutePaddingqDBjuR0(Modifier $this$absolutePadding_u2dqDBjuR0, float left, float top, float right, float bottom) {
        Intrinsics.checkNotNullParameter($this$absolutePadding_u2dqDBjuR0, "$this$absolutePadding");
        return $this$absolutePadding_u2dqDBjuR0.then(new PaddingModifier(left, top, right, bottom, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PaddingKt$absolutePaddingqDBjuR0$$inlined$debugInspectorInfo$1(left, top, right, bottom) : InspectableValueKt.getNoInspectorInfo(), (DefaultConstructorMarker) null));
    }

    public static final float calculateStartPadding(PaddingValues $this$calculateStartPadding, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter($this$calculateStartPadding, "<this>");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            return $this$calculateStartPadding.m771calculateLeftPaddingu2uoSUM(layoutDirection);
        }
        return $this$calculateStartPadding.m772calculateRightPaddingu2uoSUM(layoutDirection);
    }

    public static final float calculateEndPadding(PaddingValues $this$calculateEndPadding, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter($this$calculateEndPadding, "<this>");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            return $this$calculateEndPadding.m772calculateRightPaddingu2uoSUM(layoutDirection);
        }
        return $this$calculateEndPadding.m771calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    /* renamed from: PaddingValues-0680j_4  reason: not valid java name */
    public static final PaddingValues m753PaddingValues0680j_4(float all) {
        return new PaddingValuesImpl(all, all, all, all, (DefaultConstructorMarker) null);
    }

    /* renamed from: PaddingValues-YgX7TsA$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m755PaddingValuesYgX7TsA$default(float $this$dp$iv, float $this$dp$iv2, int i, Object obj) {
        if ((i & 1) != 0) {
            $this$dp$iv = Dp.m5986constructorimpl((float) 0);
        }
        if ((i & 2) != 0) {
            $this$dp$iv2 = Dp.m5986constructorimpl((float) 0);
        }
        return m754PaddingValuesYgX7TsA($this$dp$iv, $this$dp$iv2);
    }

    /* renamed from: PaddingValues-YgX7TsA  reason: not valid java name */
    public static final PaddingValues m754PaddingValuesYgX7TsA(float horizontal, float vertical) {
        return new PaddingValuesImpl(horizontal, vertical, horizontal, vertical, (DefaultConstructorMarker) null);
    }

    /* renamed from: PaddingValues-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ PaddingValues m757PaddingValuesa9UjIt4$default(float $this$dp$iv, float $this$dp$iv2, float $this$dp$iv3, float $this$dp$iv4, int i, Object obj) {
        if ((i & 1) != 0) {
            $this$dp$iv = Dp.m5986constructorimpl((float) 0);
        }
        if ((i & 2) != 0) {
            $this$dp$iv2 = Dp.m5986constructorimpl((float) 0);
        }
        if ((i & 4) != 0) {
            $this$dp$iv3 = Dp.m5986constructorimpl((float) 0);
        }
        if ((i & 8) != 0) {
            $this$dp$iv4 = Dp.m5986constructorimpl((float) 0);
        }
        return m756PaddingValuesa9UjIt4($this$dp$iv, $this$dp$iv2, $this$dp$iv3, $this$dp$iv4);
    }

    /* renamed from: PaddingValues-a9UjIt4  reason: not valid java name */
    public static final PaddingValues m756PaddingValuesa9UjIt4(float start, float top, float end, float bottom) {
        return new PaddingValuesImpl(start, top, end, bottom, (DefaultConstructorMarker) null);
    }
}
