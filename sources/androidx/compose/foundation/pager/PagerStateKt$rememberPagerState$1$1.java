package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
final class PagerStateKt$rememberPagerState$1$1 extends Lambda implements Function0<PagerState> {
    final /* synthetic */ int $initialPage;
    final /* synthetic */ float $initialPageOffsetFraction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerStateKt$rememberPagerState$1$1(int i, float f) {
        super(0);
        this.$initialPage = i;
        this.$initialPageOffsetFraction = f;
    }

    public final PagerState invoke() {
        return new PagerState(this.$initialPage, this.$initialPageOffsetFraction);
    }
}
