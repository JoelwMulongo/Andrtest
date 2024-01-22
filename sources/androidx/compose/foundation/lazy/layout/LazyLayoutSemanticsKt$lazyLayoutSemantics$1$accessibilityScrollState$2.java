package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutSemantics.kt */
final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ LazyLayoutItemProvider $itemProvider;
    final /* synthetic */ LazyLayoutSemanticState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$2(LazyLayoutSemanticState lazyLayoutSemanticState, LazyLayoutItemProvider lazyLayoutItemProvider) {
        super(0);
        this.$state = lazyLayoutSemanticState;
        this.$itemProvider = lazyLayoutItemProvider;
    }

    public final Float invoke() {
        float f;
        if (this.$state.getCanScrollForward()) {
            f = ((float) this.$itemProvider.getItemCount()) + 1.0f;
        } else {
            f = this.$state.getCurrentPosition();
        }
        return Float.valueOf(f);
    }
}
