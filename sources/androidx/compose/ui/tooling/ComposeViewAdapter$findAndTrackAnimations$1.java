package androidx.compose.ui.tooling;

import androidx.compose.ui.tooling.animation.PreviewAnimationClock;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeViewAdapter.kt */
/* synthetic */ class ComposeViewAdapter$findAndTrackAnimations$1 extends MutablePropertyReference0Impl {
    ComposeViewAdapter$findAndTrackAnimations$1(Object obj) {
        super(obj, ComposeViewAdapter.class, "clock", "getClock$ui_tooling_release()Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", 0);
    }

    public Object get() {
        return ((ComposeViewAdapter) this.receiver).getClock$ui_tooling_release();
    }

    public void set(Object value) {
        ((ComposeViewAdapter) this.receiver).setClock$ui_tooling_release((PreviewAnimationClock) value);
    }
}
