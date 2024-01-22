package androidx.compose.foundation;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidOverscroll.kt */
final class AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2 extends Lambda implements Function3<MeasureScope, Measurable, Constraints, MeasureResult> {
    public static final AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2 INSTANCE = new AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2();

    AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return m447invoke3p2s80s((MeasureScope) p1, (Measurable) p2, ((Constraints) p3).m5936unboximpl());
    }

    /* renamed from: invoke-3p2s80s  reason: not valid java name */
    public final MeasureResult m447invoke3p2s80s(MeasureScope $this$layout, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable placeable = measurable.m4863measureBRTryo0(constraints);
        final int extraSizePx = $this$layout.m5961roundToPx0680j_4(Dp.m5986constructorimpl(((float) 2) * ClipScrollableContainerKt.getMaxSupportedElevation()));
        int height = placeable.getHeight() + extraSizePx;
        return MeasureScope.layout$default($this$layout, placeable.getWidth() + extraSizePx, height, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Placeable.PlacementScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope $this$layout) {
                Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
                Placeable placeable = placeable;
                int i = extraSizePx;
                Placeable.PlacementScope.place$default($this$layout, placeable, i / 2, i / 2, 0.0f, 4, (Object) null);
            }
        }, 4, (Object) null);
    }
}
