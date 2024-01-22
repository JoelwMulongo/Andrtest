package androidx.compose.material;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Swipeable.kt */
final class SwipeableState$draggableState$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ SwipeableState<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableState$draggableState$1(SwipeableState<T> swipeableState) {
        super(1);
        this.this$0 = swipeableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float it) {
        float newAbsolute = ((Number) this.this$0.absoluteOffset.getValue()).floatValue() + it;
        float clamped = RangesKt.coerceIn(newAbsolute, this.this$0.getMinBound$material_release(), this.this$0.getMaxBound$material_release());
        float overflow = newAbsolute - clamped;
        ResistanceConfig resistance$material_release = this.this$0.getResistance$material_release();
        this.this$0.offsetState.setValue(Float.valueOf(clamped + (resistance$material_release != null ? resistance$material_release.computeResistance(overflow) : 0.0f)));
        this.this$0.overflowState.setValue(Float.valueOf(overflow));
        this.this$0.absoluteOffset.setValue(Float.valueOf(newAbsolute));
    }
}
