package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u0005*\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016R$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005@PX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0006¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/layout/LayoutIdModifier;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/layout/LayoutIdParentData;", "Landroidx/compose/ui/Modifier$Node;", "layoutId", "", "(Ljava/lang/Object;)V", "<set-?>", "getLayoutId", "()Ljava/lang/Object;", "setLayoutId$ui_release", "modifyParentData", "Landroidx/compose/ui/unit/Density;", "parentData", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutId.kt */
final class LayoutIdModifier extends Modifier.Node implements ParentDataModifierNode, LayoutIdParentData {
    private Object layoutId;

    public LayoutIdModifier(Object layoutId2) {
        Intrinsics.checkNotNullParameter(layoutId2, "layoutId");
        this.layoutId = layoutId2;
    }

    public Object getLayoutId() {
        return this.layoutId;
    }

    public void setLayoutId$ui_release(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.layoutId = obj;
    }

    public Object modifyParentData(Density $this$modifyParentData, Object parentData) {
        Intrinsics.checkNotNullParameter($this$modifyParentData, "<this>");
        return this;
    }
}
