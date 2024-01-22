package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"HorizontalScrollableClipModifier", "Landroidx/compose/ui/Modifier;", "MaxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "getMaxSupportedElevation", "()F", "F", "VerticalScrollableClipModifier", "clipScrollableContainer", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ClipScrollableContainer.kt */
public final class ClipScrollableContainerKt {
    private static final Modifier HorizontalScrollableClipModifier = ClipKt.clip(Modifier.Companion, new ClipScrollableContainerKt$HorizontalScrollableClipModifier$1());
    private static final float MaxSupportedElevation = Dp.m5986constructorimpl((float) 30);
    private static final Modifier VerticalScrollableClipModifier = ClipKt.clip(Modifier.Companion, new ClipScrollableContainerKt$VerticalScrollableClipModifier$1());

    public static final Modifier clipScrollableContainer(Modifier $this$clipScrollableContainer, Orientation orientation) {
        Modifier modifier;
        Intrinsics.checkNotNullParameter($this$clipScrollableContainer, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == Orientation.Vertical) {
            modifier = VerticalScrollableClipModifier;
        } else {
            modifier = HorizontalScrollableClipModifier;
        }
        return $this$clipScrollableContainer.then(modifier);
    }

    public static final float getMaxSupportedElevation() {
        return MaxSupportedElevation;
    }
}
