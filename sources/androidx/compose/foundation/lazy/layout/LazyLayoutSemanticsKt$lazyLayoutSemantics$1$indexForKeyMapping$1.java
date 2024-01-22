package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutSemantics.kt */
final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1 extends Lambda implements Function1<Object, Integer> {
    final /* synthetic */ LazyLayoutItemProvider $itemProvider;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1(LazyLayoutItemProvider lazyLayoutItemProvider) {
        super(1);
        this.$itemProvider = lazyLayoutItemProvider;
    }

    public final Integer invoke(Object needle) {
        Intrinsics.checkNotNullParameter(needle, "needle");
        int result = -1;
        int index = 0;
        int itemCount = this.$itemProvider.getItemCount();
        while (true) {
            if (index >= itemCount) {
                break;
            } else if (Intrinsics.areEqual(this.$itemProvider.getKey(index), needle)) {
                result = index;
                break;
            } else {
                index++;
            }
        }
        return Integer.valueOf(result);
    }
}
