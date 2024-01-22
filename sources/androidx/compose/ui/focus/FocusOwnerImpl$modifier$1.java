package androidx.compose.ui.focus;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"androidx/compose/ui/focus/FocusOwnerImpl$modifier$1", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/focus/FocusTargetModifierNode;", "create", "equals", "", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusOwnerImpl.kt */
public final class FocusOwnerImpl$modifier$1 extends ModifierNodeElement<FocusTargetModifierNode> {
    final /* synthetic */ FocusOwnerImpl this$0;

    FocusOwnerImpl$modifier$1(FocusOwnerImpl $receiver) {
        this.this$0 = $receiver;
    }

    public FocusTargetModifierNode create() {
        return this.this$0.getRootFocusNode$ui_release();
    }

    public FocusTargetModifierNode update(FocusTargetModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        return node;
    }

    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
        $this$inspectableProperties.setName("RootFocusTarget");
    }

    public int hashCode() {
        return this.this$0.getRootFocusNode$ui_release().hashCode();
    }

    public boolean equals(Object other) {
        return other == this;
    }
}
