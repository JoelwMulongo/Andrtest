package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "a", "Landroidx/compose/foundation/text/selection/Selectable;", "b", "invoke", "(Landroidx/compose/foundation/text/selection/Selectable;Landroidx/compose/foundation/text/selection/Selectable;)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionRegistrarImpl.kt */
final class SelectionRegistrarImpl$sort$1 extends Lambda implements Function2<Selectable, Selectable, Integer> {
    final /* synthetic */ LayoutCoordinates $containerLayoutCoordinates;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionRegistrarImpl$sort$1(LayoutCoordinates layoutCoordinates) {
        super(2);
        this.$containerLayoutCoordinates = layoutCoordinates;
    }

    public final Integer invoke(Selectable a, Selectable b) {
        long positionA;
        long positionB;
        int i;
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        LayoutCoordinates layoutCoordinatesA = a.getLayoutCoordinates();
        LayoutCoordinates layoutCoordinatesB = b.getLayoutCoordinates();
        if (layoutCoordinatesA != null) {
            positionA = this.$containerLayoutCoordinates.m4840localPositionOfR5De75A(layoutCoordinatesA, Offset.Companion.m2931getZeroF1C5BW0());
        } else {
            positionA = Offset.Companion.m2931getZeroF1C5BW0();
        }
        if (layoutCoordinatesB != null) {
            positionB = this.$containerLayoutCoordinates.m4840localPositionOfR5De75A(layoutCoordinatesB, Offset.Companion.m2931getZeroF1C5BW0());
        } else {
            positionB = Offset.Companion.m2931getZeroF1C5BW0();
        }
        if (Offset.m2916getYimpl(positionA) == Offset.m2916getYimpl(positionB)) {
            i = ComparisonsKt.compareValues(Float.valueOf(Offset.m2915getXimpl(positionA)), Float.valueOf(Offset.m2915getXimpl(positionB)));
        } else {
            i = ComparisonsKt.compareValues(Float.valueOf(Offset.m2916getYimpl(positionA)), Float.valueOf(Offset.m2916getYimpl(positionB)));
        }
        return Integer.valueOf(i);
    }
}
