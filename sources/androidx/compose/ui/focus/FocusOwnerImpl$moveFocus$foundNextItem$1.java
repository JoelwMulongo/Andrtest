package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "destination", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "invoke", "(Landroidx/compose/ui/focus/FocusTargetModifierNode;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusOwnerImpl.kt */
final class FocusOwnerImpl$moveFocus$foundNextItem$1 extends Lambda implements Function1<FocusTargetModifierNode, Boolean> {
    final /* synthetic */ FocusTargetModifierNode $source;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusOwnerImpl$moveFocus$foundNextItem$1(FocusTargetModifierNode focusTargetModifierNode) {
        super(1);
        this.$source = focusTargetModifierNode;
    }

    public final Boolean invoke(FocusTargetModifierNode destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (Intrinsics.areEqual((Object) destination, (Object) this.$source)) {
            return false;
        }
        Modifier.Node nearestAncestor = DelegatableNodeKt.nearestAncestor(destination, NodeKind.m5123constructorimpl(1024));
        if (!(nearestAncestor instanceof FocusTargetModifierNode)) {
            nearestAncestor = null;
        }
        if (((FocusTargetModifierNode) nearestAncestor) != null) {
            return Boolean.valueOf(FocusTransactionsKt.requestFocus(destination));
        }
        throw new IllegalStateException("Focus search landed at the root.".toString());
    }
}
