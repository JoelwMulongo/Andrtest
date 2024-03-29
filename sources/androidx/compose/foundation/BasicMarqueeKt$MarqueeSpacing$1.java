package androidx.compose.foundation;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/unit/Density;", "<anonymous parameter 0>", "<anonymous parameter 1>"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicMarquee.kt */
final class BasicMarqueeKt$MarqueeSpacing$1 implements MarqueeSpacing {
    final /* synthetic */ float $spacing;

    BasicMarqueeKt$MarqueeSpacing$1(float f) {
        this.$spacing = f;
    }

    public final int calculateSpacing(Density $this$MarqueeSpacing, int i, int i2) {
        Intrinsics.checkNotNullParameter($this$MarqueeSpacing, "$this$MarqueeSpacing");
        return $this$MarqueeSpacing.m5961roundToPx0680j_4(this.$spacing);
    }
}
