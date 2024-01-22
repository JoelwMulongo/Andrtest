package androidx.compose.foundation;

import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.BasicMarqueeKt$basicMarquee-1Mj1MLw$$inlined$debugInspectorInfo$1  reason: invalid class name */
/* compiled from: InspectableValue.kt */
public final class BasicMarqueeKt$basicMarquee1Mj1MLw$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ int $animationMode$inlined;
    final /* synthetic */ int $delayMillis$inlined;
    final /* synthetic */ int $initialDelayMillis$inlined;
    final /* synthetic */ int $iterations$inlined;
    final /* synthetic */ MarqueeSpacing $spacing$inlined;
    final /* synthetic */ float $velocity$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BasicMarqueeKt$basicMarquee1Mj1MLw$$inlined$debugInspectorInfo$1(int i, int i2, int i3, int i4, MarqueeSpacing marqueeSpacing, float f) {
        super(1);
        this.$iterations$inlined = i;
        this.$animationMode$inlined = i2;
        this.$delayMillis$inlined = i3;
        this.$initialDelayMillis$inlined = i4;
        this.$spacing$inlined = marqueeSpacing;
        this.$velocity$inlined = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((InspectorInfo) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo $this$null) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        InspectorInfo $this$basicMarquee_1Mj1MLw_u24lambda_u240 = $this$null;
        $this$basicMarquee_1Mj1MLw_u24lambda_u240.setName("basicMarquee");
        $this$basicMarquee_1Mj1MLw_u24lambda_u240.getProperties().set("iterations", Integer.valueOf(this.$iterations$inlined));
        $this$basicMarquee_1Mj1MLw_u24lambda_u240.getProperties().set("animationMode", MarqueeAnimationMode.m501boximpl(this.$animationMode$inlined));
        $this$basicMarquee_1Mj1MLw_u24lambda_u240.getProperties().set("delayMillis", Integer.valueOf(this.$delayMillis$inlined));
        $this$basicMarquee_1Mj1MLw_u24lambda_u240.getProperties().set("initialDelayMillis", Integer.valueOf(this.$initialDelayMillis$inlined));
        $this$basicMarquee_1Mj1MLw_u24lambda_u240.getProperties().set("spacing", this.$spacing$inlined);
        $this$basicMarquee_1Mj1MLw_u24lambda_u240.getProperties().set("velocity", Dp.m5984boximpl(this.$velocity$inlined));
    }
}
