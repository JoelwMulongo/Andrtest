package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutSemantics.kt */
final class LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ LazyLayoutSemanticState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$1(LazyLayoutSemanticState lazyLayoutSemanticState) {
        super(0);
        this.$state = lazyLayoutSemanticState;
    }

    public final Float invoke() {
        return Float.valueOf(this.$state.getCurrentPosition());
    }
}
