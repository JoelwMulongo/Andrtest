package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridState.kt */
final class LazyStaggeredGridState$firstVisibleItemScrollOffset$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ LazyStaggeredGridState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridState$firstVisibleItemScrollOffset$2(LazyStaggeredGridState lazyStaggeredGridState) {
        super(0);
        this.this$0 = lazyStaggeredGridState;
    }

    public final Integer invoke() {
        int[] offsets = this.this$0.getScrollPosition$foundation_release().getOffsets();
        LazyStaggeredGridState lazyStaggeredGridState = this.this$0;
        int firstVisibleIndex = lazyStaggeredGridState.getFirstVisibleItemIndex();
        int[] indices = lazyStaggeredGridState.getScrollPosition$foundation_release().getIndices();
        int minOffset = Integer.MAX_VALUE;
        int length = offsets.length;
        for (int lane = 0; lane < length; lane++) {
            if (indices[lane] == firstVisibleIndex) {
                minOffset = Math.min(minOffset, offsets[lane]);
            }
        }
        if (minOffset == Integer.MAX_VALUE) {
            minOffset = 0;
        }
        return Integer.valueOf(minOffset);
    }
}
