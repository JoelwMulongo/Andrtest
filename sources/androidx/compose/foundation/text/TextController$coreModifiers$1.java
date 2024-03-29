package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreText.kt */
final class TextController$coreModifiers$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ TextController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextController$coreModifiers$1(TextController textController) {
        super(1);
        this.this$0 = textController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((LayoutCoordinates) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutCoordinates it) {
        SelectionRegistrar access$getSelectionRegistrar$p;
        Intrinsics.checkNotNullParameter(it, "it");
        this.this$0.getState().setLayoutCoordinates(it);
        if (SelectionRegistrarKt.hasSelection(this.this$0.selectionRegistrar, this.this$0.getState().getSelectableId())) {
            long newGlobalPosition = LayoutCoordinatesKt.positionInWindow(it);
            if (!Offset.m2912equalsimpl0(newGlobalPosition, this.this$0.getState().m1236getPreviousGlobalPositionF1C5BW0()) && (access$getSelectionRegistrar$p = this.this$0.selectionRegistrar) != null) {
                access$getSelectionRegistrar$p.notifyPositionChange(this.this$0.getState().getSelectableId());
            }
            this.this$0.getState().m1238setPreviousGlobalPositionk4lQ0M(newGlobalPosition);
        }
    }
}
