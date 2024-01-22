package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "availableWidth", "mainAxisSpacing", "invoke", "(Ljava/util/List;II)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: RowColumnImpl.kt */
final class IntrinsicMeasureBlocks$VerticalMinHeight$1 extends Lambda implements Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> {
    public static final IntrinsicMeasureBlocks$VerticalMinHeight$1 INSTANCE = new IntrinsicMeasureBlocks$VerticalMinHeight$1();

    IntrinsicMeasureBlocks$VerticalMinHeight$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((List<? extends IntrinsicMeasurable>) (List) p1, ((Number) p2).intValue(), ((Number) p3).intValue());
    }

    public final Integer invoke(List<? extends IntrinsicMeasurable> measurables, int availableWidth, int mainAxisSpacing) {
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return Integer.valueOf(RowColumnImplKt.intrinsicSize(measurables, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, availableWidth, mainAxisSpacing, LayoutOrientation.Vertical, LayoutOrientation.Vertical));
    }
}
