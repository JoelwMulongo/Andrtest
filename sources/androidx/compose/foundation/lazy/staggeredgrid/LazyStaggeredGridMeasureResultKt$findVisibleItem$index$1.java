package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "invoke", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasureResult.kt */
final class LazyStaggeredGridMeasureResultKt$findVisibleItem$index$1 extends Lambda implements Function1<LazyStaggeredGridItemInfo, Integer> {
    final /* synthetic */ int $itemIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridMeasureResultKt$findVisibleItem$index$1(int i) {
        super(1);
        this.$itemIndex = i;
    }

    public final Integer invoke(LazyStaggeredGridItemInfo it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Integer.valueOf(it.getIndex() - this.$itemIndex);
    }
}