package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.ui.semantics.CollectionInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazySemantics.kt */
public final class LazySemanticsKt$rememberLazyGridSemanticState$1$1 implements LazyLayoutSemanticState {
    final /* synthetic */ LazyGridState $state;

    LazySemanticsKt$rememberLazyGridSemanticState$1$1(LazyGridState $state2) {
        this.$state = $state2;
    }

    public float getCurrentPosition() {
        return ((float) this.$state.getFirstVisibleItemIndex()) + (((float) this.$state.getFirstVisibleItemScrollOffset()) / 100000.0f);
    }

    public boolean getCanScrollForward() {
        return this.$state.getCanScrollForward();
    }

    public Object animateScrollBy(float delta, Continuation<? super Unit> $completion) {
        Object animateScrollBy$default = ScrollExtensionsKt.animateScrollBy$default(this.$state, delta, (AnimationSpec) null, $completion, 2, (Object) null);
        return animateScrollBy$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollBy$default : Unit.INSTANCE;
    }

    public Object scrollToItem(int index, Continuation<? super Unit> $completion) {
        Object scrollToItem$default = LazyGridState.scrollToItem$default(this.$state, index, 0, $completion, 2, (Object) null);
        return scrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
    }

    public CollectionInfo collectionInfo() {
        return new CollectionInfo(-1, -1);
    }
}
