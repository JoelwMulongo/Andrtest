package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicMarquee.kt */
final class MarqueeModifier$spacingPx$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ MarqueeModifier this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MarqueeModifier$spacingPx$2(MarqueeModifier marqueeModifier) {
        super(0);
        this.this$0 = marqueeModifier;
    }

    public final Integer invoke() {
        MarqueeSpacing $this$invoke_u24lambda_u240 = this.this$0.getSpacing();
        MarqueeModifier marqueeModifier = this.this$0;
        return Integer.valueOf($this$invoke_u24lambda_u240.calculateSpacing(marqueeModifier.density, marqueeModifier.getContentWidth(), marqueeModifier.getContainerWidth()));
    }
}
