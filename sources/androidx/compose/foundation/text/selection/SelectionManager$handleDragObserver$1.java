package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001d\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\bJ\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"androidx/compose/foundation/text/selection/SelectionManager$handleDragObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "onCancel", "", "onDown", "point", "Landroidx/compose/ui/geometry/Offset;", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionManager.kt */
public final class SelectionManager$handleDragObserver$1 implements TextDragObserver {
    final /* synthetic */ boolean $isStartHandle;
    final /* synthetic */ SelectionManager this$0;

    SelectionManager$handleDragObserver$1(SelectionManager $receiver, boolean $isStartHandle2) {
        this.this$0 = $receiver;
        this.$isStartHandle = $isStartHandle2;
    }

    /* renamed from: onDown-k-4lQ0M  reason: not valid java name */
    public void m1308onDownk4lQ0M(long point) {
        LayoutCoordinates beginLayoutCoordinates;
        Selection selection = this.this$0.getSelection();
        if (selection != null) {
            Selectable selectable = this.this$0.getAnchorSelectable$foundation_release(this.$isStartHandle ? selection.getStart() : selection.getEnd());
            if (selectable != null && (beginLayoutCoordinates = selectable.getLayoutCoordinates()) != null) {
                long beginCoordinates = SelectionHandlesKt.m1278getAdjustedCoordinatesk4lQ0M(selectable.m1260getHandlePositiondBAh8RU(selection, this.$isStartHandle));
                SelectionManager selectionManager = this.this$0;
                selectionManager.m1292setCurrentDragPosition_kEHs6E(Offset.m2904boximpl(selectionManager.requireContainerCoordinates$foundation_release().m4840localPositionOfR5De75A(beginLayoutCoordinates, beginCoordinates)));
                this.this$0.setDraggingHandle(this.$isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
            }
        }
    }

    public void onUp() {
        this.this$0.setDraggingHandle((Handle) null);
        this.this$0.m1292setCurrentDragPosition_kEHs6E((Offset) null);
    }

    /* renamed from: onStart-k-4lQ0M  reason: not valid java name */
    public void m1310onStartk4lQ0M(long startPoint) {
        long j;
        this.this$0.hideSelectionToolbar$foundation_release();
        Selection selection = this.this$0.getSelection();
        Intrinsics.checkNotNull(selection);
        Selectable startSelectable = this.this$0.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(selection.getStart().getSelectableId()));
        Selectable endSelectable = this.this$0.selectionRegistrar.getSelectableMap$foundation_release().get(Long.valueOf(selection.getEnd().getSelectableId()));
        LayoutCoordinates layoutCoordinates = null;
        if (this.$isStartHandle) {
            if (startSelectable != null) {
                layoutCoordinates = startSelectable.getLayoutCoordinates();
            }
            Intrinsics.checkNotNull(layoutCoordinates);
        } else {
            if (endSelectable != null) {
                layoutCoordinates = endSelectable.getLayoutCoordinates();
            }
            Intrinsics.checkNotNull(layoutCoordinates);
        }
        LayoutCoordinates beginLayoutCoordinates = layoutCoordinates;
        if (this.$isStartHandle) {
            Intrinsics.checkNotNull(startSelectable);
            j = startSelectable.m1260getHandlePositiondBAh8RU(selection, true);
        } else {
            Intrinsics.checkNotNull(endSelectable);
            j = endSelectable.m1260getHandlePositiondBAh8RU(selection, false);
        }
        long beginCoordinates = SelectionHandlesKt.m1278getAdjustedCoordinatesk4lQ0M(j);
        SelectionManager selectionManager = this.this$0;
        selectionManager.m1293setDragBeginPositionk4lQ0M(selectionManager.requireContainerCoordinates$foundation_release().m4840localPositionOfR5De75A(beginLayoutCoordinates, beginCoordinates));
        this.this$0.m1294setDragTotalDistancek4lQ0M(Offset.Companion.m2931getZeroF1C5BW0());
    }

    /* renamed from: onDrag-k-4lQ0M  reason: not valid java name */
    public void m1309onDragk4lQ0M(long delta) {
        SelectionManager selectionManager = this.this$0;
        selectionManager.m1294setDragTotalDistancek4lQ0M(Offset.m2920plusMKHz9U(selectionManager.m1301getDragTotalDistanceF1C5BW0$foundation_release(), delta));
        long endPosition = Offset.m2920plusMKHz9U(this.this$0.m1300getDragBeginPositionF1C5BW0$foundation_release(), this.this$0.m1301getDragTotalDistanceF1C5BW0$foundation_release());
        if (this.this$0.m1305updateSelectionRHHTvR4$foundation_release(Offset.m2904boximpl(endPosition), Offset.m2904boximpl(this.this$0.m1300getDragBeginPositionF1C5BW0$foundation_release()), this.$isStartHandle, SelectionAdjustment.Companion.getCharacterWithWordAccelerate())) {
            this.this$0.m1293setDragBeginPositionk4lQ0M(endPosition);
            this.this$0.m1294setDragTotalDistancek4lQ0M(Offset.Companion.m2931getZeroF1C5BW0());
        }
    }

    public void onStop() {
        this.this$0.showSelectionToolbar$foundation_release();
        this.this$0.setDraggingHandle((Handle) null);
        this.this$0.m1292setCurrentDragPosition_kEHs6E((Offset) null);
    }

    public void onCancel() {
        this.this$0.showSelectionToolbar$foundation_release();
        this.this$0.setDraggingHandle((Handle) null);
        this.this$0.m1292setCurrentDragPosition_kEHs6E((Offset) null);
    }
}
