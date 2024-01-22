package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadLayout.kt */
final class LookaheadLayoutKt$LookaheadLayout$1$2 extends Lambda implements Function1<LayoutNode, Unit> {
    public static final LookaheadLayoutKt$LookaheadLayout$1$2 INSTANCE = new LookaheadLayoutKt$LookaheadLayout$1$2();

    LookaheadLayoutKt$LookaheadLayout$1$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((LayoutNode) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutNode $this$init) {
        Intrinsics.checkNotNullParameter($this$init, "$this$init");
        $this$init.setLookaheadRoot(true);
    }
}
