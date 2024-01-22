package androidx.compose.ui.tooling;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeViewAdapter.kt */
/* synthetic */ class ComposeViewAdapter$findAndTrackAnimations$2 extends FunctionReferenceImpl implements Function0<Unit> {
    ComposeViewAdapter$findAndTrackAnimations$2(Object obj) {
        super(0, obj, ComposeViewAdapter.class, "requestLayout", "requestLayout()V", 0);
    }

    public final void invoke() {
        ((ComposeViewAdapter) this.receiver).requestLayout();
    }
}
