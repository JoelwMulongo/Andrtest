package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadLayout.kt */
final class LookaheadLayoutKt$LookaheadLayout$1$1 extends Lambda implements Function2<LayoutNode, LookaheadLayoutScopeImpl, Unit> {
    public static final LookaheadLayoutKt$LookaheadLayout$1$1 INSTANCE = new LookaheadLayoutKt$LookaheadLayout$1$1();

    LookaheadLayoutKt$LookaheadLayout$1$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((LayoutNode) p1, (LookaheadLayoutScopeImpl) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutNode $this$set, LookaheadLayoutScopeImpl scope) {
        Intrinsics.checkNotNullParameter($this$set, "$this$set");
        Intrinsics.checkNotNullParameter(scope, "scope");
        scope.setRoot($this$set.getInnerCoordinator$ui_release());
    }
}
