package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "delta", "invoke-MK-Hz9U", "(J)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1 extends Lambda implements Function1<Offset, Offset> {
    final /* synthetic */ ScrollScope $$this$scroll;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1(ScrollingLogic scrollingLogic, ScrollScope scrollScope) {
        super(1);
        this.this$0 = scrollingLogic;
        this.$$this$scroll = scrollScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return Offset.m2904boximpl(m638invokeMKHz9U(((Offset) p1).m2925unboximpl()));
    }

    /* renamed from: invoke-MK-Hz9U  reason: not valid java name */
    public final long m638invokeMKHz9U(long delta) {
        ScrollingLogic scrollingLogic = this.this$0;
        return scrollingLogic.m630reverseIfNeededMKHz9U(scrollingLogic.m626dispatchScroll3eAAhYA(this.$$this$scroll, scrollingLogic.m630reverseIfNeededMKHz9U(delta), NestedScrollSource.Companion.m4567getFlingWNlRxjI()));
    }
}
