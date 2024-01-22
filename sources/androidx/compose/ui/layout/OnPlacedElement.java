package androidx.compose.ui.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004HÆ\u0001J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\f\u0010\u0017\u001a\u00020\u0006*\u00020\u0018H\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/layout/OnPlacedElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/OnPlacedModifierImpl;", "onPlaced", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "", "(Lkotlin/jvm/functions/Function1;)V", "getOnPlaced", "()Lkotlin/jvm/functions/Function1;", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OnPlacedModifier.kt */
final class OnPlacedElement extends ModifierNodeElement<OnPlacedModifierImpl> {
    private final Function1<LayoutCoordinates, Unit> onPlaced;

    public static /* synthetic */ OnPlacedElement copy$default(OnPlacedElement onPlacedElement, Function1<LayoutCoordinates, Unit> function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = onPlacedElement.onPlaced;
        }
        return onPlacedElement.copy(function1);
    }

    public final Function1<LayoutCoordinates, Unit> component1() {
        return this.onPlaced;
    }

    public final OnPlacedElement copy(Function1<? super LayoutCoordinates, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onPlaced");
        return new OnPlacedElement(function1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OnPlacedElement) && Intrinsics.areEqual((Object) this.onPlaced, (Object) ((OnPlacedElement) obj).onPlaced);
    }

    public int hashCode() {
        return this.onPlaced.hashCode();
    }

    public String toString() {
        return "OnPlacedElement(onPlaced=" + this.onPlaced + ')';
    }

    public final Function1<LayoutCoordinates, Unit> getOnPlaced() {
        return this.onPlaced;
    }

    public OnPlacedElement(Function1<? super LayoutCoordinates, Unit> onPlaced2) {
        Intrinsics.checkNotNullParameter(onPlaced2, "onPlaced");
        this.onPlaced = onPlaced2;
    }

    public OnPlacedModifierImpl create() {
        return new OnPlacedModifierImpl(this.onPlaced);
    }

    public OnPlacedModifierImpl update(OnPlacedModifierImpl node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setCallback(this.onPlaced);
        return node;
    }

    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
        $this$inspectableProperties.setName("onPlaced");
        $this$inspectableProperties.getProperties().set("onPlaced", this.onPlaced);
    }
}
