package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B&\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/VerticalAlignModifier;", "Landroidx/compose/ui/layout/ParentDataModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "vertical", "Landroidx/compose/ui/Alignment$Vertical;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Alignment$Vertical;Lkotlin/jvm/functions/Function1;)V", "getVertical", "()Landroidx/compose/ui/Alignment$Vertical;", "equals", "", "other", "", "hashCode", "", "toString", "", "modifyParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RowColumnImpl.kt */
public final class VerticalAlignModifier extends InspectorValueInfo implements ParentDataModifier {
    private final Alignment.Vertical vertical;

    public final Alignment.Vertical getVertical() {
        return this.vertical;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerticalAlignModifier(Alignment.Vertical vertical2, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        Intrinsics.checkNotNullParameter(vertical2, "vertical");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.vertical = vertical2;
    }

    public RowColumnParentData modifyParentData(Density $this$modifyParentData, Object parentData) {
        Intrinsics.checkNotNullParameter($this$modifyParentData, "<this>");
        RowColumnParentData it = parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null;
        if (it == null) {
            it = new RowColumnParentData(0.0f, false, (CrossAxisAlignment) null, 7, (DefaultConstructorMarker) null);
        }
        it.setCrossAxisAlignment(CrossAxisAlignment.Companion.vertical$foundation_layout_release(this.vertical));
        return it;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        VerticalAlignModifier otherModifier = other instanceof VerticalAlignModifier ? (VerticalAlignModifier) other : null;
        if (otherModifier == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.vertical, (Object) otherModifier.vertical);
    }

    public int hashCode() {
        return this.vertical.hashCode();
    }

    public String toString() {
        return "VerticalAlignModifier(vertical=" + this.vertical + ')';
    }
}
