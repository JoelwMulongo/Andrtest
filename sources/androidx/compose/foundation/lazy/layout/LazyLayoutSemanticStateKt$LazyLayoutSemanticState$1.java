package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.ui.semantics.CollectionInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0019\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"androidx/compose/foundation/lazy/layout/LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "canScrollForward", "", "getCanScrollForward", "()Z", "currentPosition", "", "getCurrentPosition", "()F", "animateScrollBy", "", "delta", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectionInfo", "Landroidx/compose/ui/semantics/CollectionInfo;", "scrollToItem", "index", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutSemanticState.kt */
public final class LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1 implements LazyLayoutSemanticState {
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ LazyListState $state;

    LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1(LazyListState $state2, boolean $isVertical2) {
        this.$state = $state2;
        this.$isVertical = $isVertical2;
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
        Object scrollToItem$default = LazyListState.scrollToItem$default(this.$state, index, 0, $completion, 2, (Object) null);
        return scrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
    }

    public CollectionInfo collectionInfo() {
        if (this.$isVertical) {
            return new CollectionInfo(-1, 1);
        }
        return new CollectionInfo(1, -1);
    }
}
