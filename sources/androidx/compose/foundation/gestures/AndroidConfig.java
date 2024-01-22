package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/gestures/AndroidConfig;", "Landroidx/compose/foundation/gestures/ScrollConfig;", "()V", "calculateMouseWheelScroll", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/unit/Density;", "event", "Landroidx/compose/ui/input/pointer/PointerEvent;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "calculateMouseWheelScroll-8xgXZGE", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/input/pointer/PointerEvent;J)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidScrollable.android.kt */
final class AndroidConfig implements ScrollConfig {
    public static final AndroidConfig INSTANCE = new AndroidConfig();

    private AndroidConfig() {
    }

    /* renamed from: calculateMouseWheelScroll-8xgXZGE  reason: not valid java name */
    public long m526calculateMouseWheelScroll8xgXZGE(Density $this$calculateMouseWheelScroll_u2d8xgXZGE, PointerEvent event, long bounds) {
        Density density = $this$calculateMouseWheelScroll_u2d8xgXZGE;
        Intrinsics.checkNotNullParameter(density, "$this$calculateMouseWheelScroll");
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        List $this$fastFold$iv = event.getChanges();
        Offset r5 = Offset.m2904boximpl(Offset.Companion.m2931getZeroF1C5BW0());
        List $this$fastForEach$iv$iv = $this$fastFold$iv;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            r5 = Offset.m2904boximpl(Offset.m2920plusMKHz9U(r5.m2925unboximpl(), ((PointerInputChange) $this$fastForEach$iv$iv.get(index$iv$iv)).m4669getScrollDeltaF1C5BW0()));
            index$iv$iv++;
            PointerEvent pointerEvent = event;
            $this$fastFold$iv = $this$fastFold$iv;
        }
        return Offset.m2922timestuRUvjQ(r5.m2925unboximpl(), -density.m5967toPx0680j_4(Dp.m5986constructorimpl((float) 64)));
    }
}
