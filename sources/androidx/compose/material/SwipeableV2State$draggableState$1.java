package androidx.compose.material;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeableV2.kt */
final class SwipeableV2State$draggableState$1 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ SwipeableV2State<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableV2State$draggableState$1(SwipeableV2State<T> swipeableV2State) {
        super(1);
        this.this$0 = swipeableV2State;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float it) {
        SwipeableV2State<T> swipeableV2State = this.this$0;
        Float offset = swipeableV2State.getOffset();
        swipeableV2State.setOffset(Float.valueOf(RangesKt.coerceIn((offset != null ? offset.floatValue() : 0.0f) + it, this.this$0.getMinOffset(), this.this$0.getMaxOffset())));
    }
}
