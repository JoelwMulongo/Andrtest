package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0013J%\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u000fR%\u0010\u0002\u001a\u00020\u0003X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"androidx/compose/foundation/text/TextController$update$mouseSelectionObserver$1", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "lastPosition", "Landroidx/compose/ui/geometry/Offset;", "getLastPosition", "()J", "setLastPosition", "(J)V", "J", "onDrag", "", "dragPosition", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "onDrag-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "onExtend", "downPosition", "onExtend-k-4lQ0M", "(J)Z", "onExtendDrag", "onExtendDrag-k-4lQ0M", "onStart", "onStart-3MmeM6k", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreText.kt */
public final class TextController$update$mouseSelectionObserver$1 implements MouseSelectionObserver {
    final /* synthetic */ SelectionRegistrar $selectionRegistrar;
    private long lastPosition = Offset.Companion.m2931getZeroF1C5BW0();
    final /* synthetic */ TextController this$0;

    TextController$update$mouseSelectionObserver$1(TextController $receiver, SelectionRegistrar $selectionRegistrar2) {
        this.this$0 = $receiver;
        this.$selectionRegistrar = $selectionRegistrar2;
    }

    public final long getLastPosition() {
        return this.lastPosition;
    }

    public final void setLastPosition(long j) {
        this.lastPosition = j;
    }

    /* renamed from: onExtend-k-4lQ0M  reason: not valid java name */
    public boolean m1195onExtendk4lQ0M(long downPosition) {
        LayoutCoordinates layoutCoordinates = this.this$0.getState().getLayoutCoordinates();
        if (layoutCoordinates == null) {
            return false;
        }
        SelectionRegistrar it = this.$selectionRegistrar;
        TextController textController = this.this$0;
        if (!layoutCoordinates.isAttached()) {
            return false;
        }
        if (it.m1323notifySelectionUpdate5iVPX68(layoutCoordinates, downPosition, this.lastPosition, false, SelectionAdjustment.Companion.getNone())) {
            this.lastPosition = downPosition;
        }
        return SelectionRegistrarKt.hasSelection(it, textController.getState().getSelectableId());
    }

    /* renamed from: onExtendDrag-k-4lQ0M  reason: not valid java name */
    public boolean m1196onExtendDragk4lQ0M(long dragPosition) {
        LayoutCoordinates layoutCoordinates = this.this$0.getState().getLayoutCoordinates();
        if (layoutCoordinates == null) {
            return true;
        }
        SelectionRegistrar selectionRegistrar = this.$selectionRegistrar;
        TextController textController = this.this$0;
        if (!layoutCoordinates.isAttached() || !SelectionRegistrarKt.hasSelection(selectionRegistrar, textController.getState().getSelectableId())) {
            return false;
        }
        if (!selectionRegistrar.m1323notifySelectionUpdate5iVPX68(layoutCoordinates, dragPosition, this.lastPosition, false, SelectionAdjustment.Companion.getNone())) {
            return true;
        }
        this.lastPosition = dragPosition;
        return true;
    }

    /* renamed from: onStart-3MmeM6k  reason: not valid java name */
    public boolean m1197onStart3MmeM6k(long downPosition, SelectionAdjustment adjustment) {
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        LayoutCoordinates it = this.this$0.getState().getLayoutCoordinates();
        if (it == null) {
            return false;
        }
        SelectionRegistrar selectionRegistrar = this.$selectionRegistrar;
        TextController textController = this.this$0;
        if (!it.isAttached()) {
            return false;
        }
        selectionRegistrar.m1324notifySelectionUpdateStartd4ec7I(it, downPosition, adjustment);
        this.lastPosition = downPosition;
        return SelectionRegistrarKt.hasSelection(selectionRegistrar, textController.getState().getSelectableId());
    }

    /* renamed from: onDrag-3MmeM6k  reason: not valid java name */
    public boolean m1194onDrag3MmeM6k(long dragPosition, SelectionAdjustment adjustment) {
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        LayoutCoordinates it = this.this$0.getState().getLayoutCoordinates();
        if (it != null) {
            SelectionRegistrar selectionRegistrar = this.$selectionRegistrar;
            TextController textController = this.this$0;
            if (!it.isAttached() || !SelectionRegistrarKt.hasSelection(selectionRegistrar, textController.getState().getSelectableId())) {
                return false;
            }
            if (selectionRegistrar.m1323notifySelectionUpdate5iVPX68(it, dragPosition, this.lastPosition, false, adjustment)) {
                this.lastPosition = dragPosition;
            }
        }
        return true;
    }
}
