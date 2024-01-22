package androidx.compose.material;

import androidx.compose.ui.unit.IntSize;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "layoutSize", "Landroidx/compose/ui/unit/IntSize;", "invoke-ozmzZPI", "(J)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SwipeableV2.kt */
final class SwipeableV2Kt$swipeAnchors$2 extends Lambda implements Function1<IntSize, Unit> {
    final /* synthetic */ AnchorChangeHandler<T> $anchorChangeHandler;
    final /* synthetic */ Function2<T, IntSize, Float> $calculateAnchor;
    final /* synthetic */ Set<T> $possibleValues;
    final /* synthetic */ SwipeableV2State<T> $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwipeableV2Kt$swipeAnchors$2(SwipeableV2State<T> swipeableV2State, Set<? extends T> set, AnchorChangeHandler<T> anchorChangeHandler, Function2<? super T, ? super IntSize, Float> function2) {
        super(1);
        this.$state = swipeableV2State;
        this.$possibleValues = set;
        this.$anchorChangeHandler = anchorChangeHandler;
        this.$calculateAnchor = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        m1641invokeozmzZPI(((IntSize) p1).m6150unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-ozmzZPI  reason: not valid java name */
    public final void m1641invokeozmzZPI(long layoutSize) {
        AnchorChangeHandler<T> anchorChangeHandler;
        Map previousAnchors = this.$state.getAnchors$material_release();
        Map newAnchors = new LinkedHashMap();
        Function2<T, IntSize, Float> function2 = this.$calculateAnchor;
        for (Object it : this.$possibleValues) {
            Float anchorValue = function2.invoke(it, IntSize.m6138boximpl(layoutSize));
            if (anchorValue != null) {
                newAnchors.put(it, anchorValue);
            }
        }
        if (!Intrinsics.areEqual((Object) previousAnchors, (Object) newAnchors)) {
            Object previousTarget = this.$state.getTargetValue();
            if (this.$state.updateAnchors$material_release(newAnchors) && (anchorChangeHandler = this.$anchorChangeHandler) != null) {
                anchorChangeHandler.onAnchorsChanged(previousTarget, previousAnchors, newAnchors);
            }
        }
    }
}
