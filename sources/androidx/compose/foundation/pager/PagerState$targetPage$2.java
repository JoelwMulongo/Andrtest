package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
final class PagerState$targetPage$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ PagerState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerState$targetPage$2(PagerState pagerState) {
        super(0);
        this.this$0 = pagerState;
    }

    public final Integer invoke() {
        int finalPage;
        if (!this.this$0.isScrollInProgress()) {
            finalPage = this.this$0.getCurrentPage();
        } else if (this.this$0.getAnimationTargetPage() != -1) {
            finalPage = this.this$0.getAnimationTargetPage();
        } else {
            if (!(this.this$0.getSnapRemainingScrollOffset$foundation_release() == 0.0f)) {
                finalPage = this.this$0.getCurrentPage() + MathKt.roundToInt(this.this$0.getSnapRemainingScrollOffset$foundation_release() / ((float) this.this$0.getPageAvailableSpace()));
            } else if (Math.abs(this.this$0.getCurrentPageOffsetFraction()) >= Math.abs(this.this$0.getPositionThresholdFraction())) {
                finalPage = this.this$0.getCurrentPage() + ((int) Math.signum(this.this$0.getCurrentPageOffsetFraction()));
            } else {
                finalPage = this.this$0.getCurrentPage();
            }
        }
        return Integer.valueOf(this.this$0.coerceInPageRange(finalPage));
    }
}
