package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\f\u001a\u00020\rH\u0016J\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0007J\u001d\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0007J\u001d\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0007J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R%\u0010\u0002\u001a\u00020\u0003X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R%\u0010\t\u001a\u00020\u0003X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"androidx/compose/foundation/text/TextController$update$1", "Landroidx/compose/foundation/text/TextDragObserver;", "dragTotalDistance", "Landroidx/compose/ui/geometry/Offset;", "getDragTotalDistance", "()J", "setDragTotalDistance", "(J)V", "J", "lastPosition", "getLastPosition", "setLastPosition", "onCancel", "", "onDown", "point", "onDown-k-4lQ0M", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreText.kt */
public final class TextController$update$1 implements TextDragObserver {
    final /* synthetic */ SelectionRegistrar $selectionRegistrar;
    private long dragTotalDistance = Offset.Companion.m2931getZeroF1C5BW0();
    private long lastPosition = Offset.Companion.m2931getZeroF1C5BW0();
    final /* synthetic */ TextController this$0;

    TextController$update$1(TextController $receiver, SelectionRegistrar $selectionRegistrar2) {
        this.this$0 = $receiver;
        this.$selectionRegistrar = $selectionRegistrar2;
    }

    public final long getLastPosition() {
        return this.lastPosition;
    }

    public final void setLastPosition(long j) {
        this.lastPosition = j;
    }

    public final long getDragTotalDistance() {
        return this.dragTotalDistance;
    }

    public final void setDragTotalDistance(long j) {
        this.dragTotalDistance = j;
    }

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m1191onDownk4lQ0M(long point) {
    }

    public void onUp() {
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m1193onStartk4lQ0M(long startPoint) {
        LayoutCoordinates it = this.this$0.getState().getLayoutCoordinates();
        if (it != null) {
            TextController textController = this.this$0;
            SelectionRegistrar selectionRegistrar = this.$selectionRegistrar;
            if (it.isAttached()) {
                if (textController.m1189outOfBoundary0a9Yr6o(startPoint, startPoint)) {
                    selectionRegistrar.notifySelectionUpdateSelectAll(textController.getState().getSelectableId());
                } else {
                    selectionRegistrar.m1324notifySelectionUpdateStartd4ec7I(it, startPoint, SelectionAdjustment.Companion.getWord());
                }
                this.lastPosition = startPoint;
            } else {
                return;
            }
        }
        if (SelectionRegistrarKt.hasSelection(this.$selectionRegistrar, this.this$0.getState().getSelectableId())) {
            this.dragTotalDistance = Offset.Companion.m2931getZeroF1C5BW0();
        }
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m1192onDragk4lQ0M(long delta) {
        LayoutCoordinates it = this.this$0.getState().getLayoutCoordinates();
        if (it != null) {
            SelectionRegistrar selectionRegistrar = this.$selectionRegistrar;
            TextController textController = this.this$0;
            if (it.isAttached() && SelectionRegistrarKt.hasSelection(selectionRegistrar, textController.getState().getSelectableId())) {
                long r3 = Offset.m2920plusMKHz9U(this.dragTotalDistance, delta);
                this.dragTotalDistance = r3;
                long newPosition = Offset.m2920plusMKHz9U(this.lastPosition, r3);
                if (!textController.m1189outOfBoundary0a9Yr6o(this.lastPosition, newPosition)) {
                    if (selectionRegistrar.m1323notifySelectionUpdate5iVPX68(it, newPosition, this.lastPosition, false, SelectionAdjustment.Companion.getCharacterWithWordAccelerate())) {
                        this.lastPosition = newPosition;
                        this.dragTotalDistance = Offset.Companion.m2931getZeroF1C5BW0();
                    }
                }
            }
        }
    }

    public void onStop() {
        if (SelectionRegistrarKt.hasSelection(this.$selectionRegistrar, this.this$0.getState().getSelectableId())) {
            this.$selectionRegistrar.notifySelectionUpdateEnd();
        }
    }

    public void onCancel() {
        if (SelectionRegistrarKt.hasSelection(this.$selectionRegistrar, this.this$0.getState().getSelectableId())) {
            this.$selectionRegistrar.notifySelectionUpdateEnd();
        }
    }
}
