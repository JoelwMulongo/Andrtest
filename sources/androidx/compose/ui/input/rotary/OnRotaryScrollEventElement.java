package androidx.compose.ui.input.rotary;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004HÆ\u0001J\b\u0010\f\u001a\u00020\u0002H\u0016J\u0013\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/input/rotary/OnRotaryScrollEventElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/rotary/RotaryInputModifierNodeImpl;", "onRotaryScrollEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "", "(Lkotlin/jvm/functions/Function1;)V", "getOnRotaryScrollEvent", "()Lkotlin/jvm/functions/Function1;", "component1", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RotaryInputModifierNode.kt */
public final class OnRotaryScrollEventElement extends ModifierNodeElement<RotaryInputModifierNodeImpl> {
    private final Function1<RotaryScrollEvent, Boolean> onRotaryScrollEvent;

    public static /* synthetic */ OnRotaryScrollEventElement copy$default(OnRotaryScrollEventElement onRotaryScrollEventElement, Function1<RotaryScrollEvent, Boolean> function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = onRotaryScrollEventElement.onRotaryScrollEvent;
        }
        return onRotaryScrollEventElement.copy(function1);
    }

    public final Function1<RotaryScrollEvent, Boolean> component1() {
        return this.onRotaryScrollEvent;
    }

    public final OnRotaryScrollEventElement copy(Function1<? super RotaryScrollEvent, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "onRotaryScrollEvent");
        return new OnRotaryScrollEventElement(function1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OnRotaryScrollEventElement) && Intrinsics.areEqual((Object) this.onRotaryScrollEvent, (Object) ((OnRotaryScrollEventElement) obj).onRotaryScrollEvent);
    }

    public int hashCode() {
        return this.onRotaryScrollEvent.hashCode();
    }

    public String toString() {
        return "OnRotaryScrollEventElement(onRotaryScrollEvent=" + this.onRotaryScrollEvent + ')';
    }

    public final Function1<RotaryScrollEvent, Boolean> getOnRotaryScrollEvent() {
        return this.onRotaryScrollEvent;
    }

    public OnRotaryScrollEventElement(Function1<? super RotaryScrollEvent, Boolean> onRotaryScrollEvent2) {
        Intrinsics.checkNotNullParameter(onRotaryScrollEvent2, "onRotaryScrollEvent");
        this.onRotaryScrollEvent = onRotaryScrollEvent2;
    }

    public RotaryInputModifierNodeImpl create() {
        return new RotaryInputModifierNodeImpl(this.onRotaryScrollEvent, (Function1<? super RotaryScrollEvent, Boolean>) null);
    }

    public RotaryInputModifierNodeImpl update(RotaryInputModifierNodeImpl node) {
        Intrinsics.checkNotNullParameter(node, "node");
        RotaryInputModifierNodeImpl $this$update_u24lambda_u240 = node;
        $this$update_u24lambda_u240.setOnEvent(this.onRotaryScrollEvent);
        $this$update_u24lambda_u240.setOnPreEvent((Function1<? super RotaryScrollEvent, Boolean>) null);
        return node;
    }

    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        Intrinsics.checkNotNullParameter($this$inspectableProperties, "<this>");
        $this$inspectableProperties.setName("onRotaryScrollEvent");
        $this$inspectableProperties.getProperties().set("onRotaryScrollEvent", this.onRotaryScrollEvent);
    }
}
