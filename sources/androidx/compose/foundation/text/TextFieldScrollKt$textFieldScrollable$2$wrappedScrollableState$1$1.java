package androidx.compose.foundation.text;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldScroll.kt */
public final class TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1 implements ScrollableState {
    private final /* synthetic */ ScrollableState $$delegate_0;
    private final State canScrollBackward$delegate;
    private final State canScrollForward$delegate;

    public float dispatchRawDelta(float f) {
        return this.$$delegate_0.dispatchRawDelta(f);
    }

    public boolean isScrollInProgress() {
        return this.$$delegate_0.isScrollInProgress();
    }

    public Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return this.$$delegate_0.scroll(mutatePriority, function2, continuation);
    }

    TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1(ScrollableState $scrollableState, TextFieldScrollerPosition $scrollerPosition) {
        this.$$delegate_0 = $scrollableState;
        this.canScrollForward$delegate = SnapshotStateKt.derivedStateOf(new TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$canScrollForward$2($scrollerPosition));
        this.canScrollBackward$delegate = SnapshotStateKt.derivedStateOf(new TextFieldScrollKt$textFieldScrollable$2$wrappedScrollableState$1$1$canScrollBackward$2($scrollerPosition));
    }

    public boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    public boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }
}
