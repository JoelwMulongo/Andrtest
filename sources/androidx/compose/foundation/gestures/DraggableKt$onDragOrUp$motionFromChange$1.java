package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "invoke", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable.kt */
final class DraggableKt$onDragOrUp$motionFromChange$1 extends Lambda implements Function1<PointerInputChange, Float> {
    public static final DraggableKt$onDragOrUp$motionFromChange$1 INSTANCE = new DraggableKt$onDragOrUp$motionFromChange$1();

    DraggableKt$onDragOrUp$motionFromChange$1() {
        super(1);
    }

    public final Float invoke(PointerInputChange it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Float.valueOf(Offset.m2916getYimpl(PointerEventKt.positionChangeIgnoreConsumed(it)));
    }
}
