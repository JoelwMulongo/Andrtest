package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.Measurable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0007H\u0002¨\u0006\b"}, d2 = {"updateChildMeasurables", "", "Landroidx/compose/ui/node/LayoutNode;", "destination", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/layout/Measurable;", "transform", "Lkotlin/Function1;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeLayoutDelegate.kt */
public final class LayoutNodeLayoutDelegateKt {
    /* access modifiers changed from: private */
    public static final void updateChildMeasurables(LayoutNode $this$updateChildMeasurables, MutableVector<Measurable> destination, Function1<? super LayoutNode, ? extends Measurable> transform) {
        MutableVector this_$iv$iv = $this$updateChildMeasurables.get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            do {
                LayoutNode layoutNode = (LayoutNode) content$iv$iv[i$iv$iv];
                int i = i$iv$iv;
                if (destination.getSize() <= i) {
                    destination.add(transform.invoke(layoutNode));
                } else {
                    destination.set(i, transform.invoke(layoutNode));
                }
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
        destination.removeRange($this$updateChildMeasurables.getChildren$ui_release().size(), destination.getSize());
    }
}
