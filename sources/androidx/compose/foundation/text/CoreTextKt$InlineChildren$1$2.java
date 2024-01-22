package androidx.compose.foundation.text;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreText.kt */
final class CoreTextKt$InlineChildren$1$2 implements MeasurePolicy {
    public static final CoreTextKt$InlineChildren$1$2 INSTANCE = new CoreTextKt$InlineChildren$1$2();

    CoreTextKt$InlineChildren$1$2() {
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1145measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> children, long constrains) {
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(children, "children");
        List list = children;
        List target$iv = new ArrayList(list.size());
        List $this$fastForEach$iv$iv = list;
        int index$iv$iv = 0;
        int size = $this$fastForEach$iv$iv.size();
        while (index$iv$iv < size) {
            Object it$iv = $this$fastForEach$iv$iv.get(index$iv$iv);
            Object obj = it$iv;
            target$iv.add(((Measurable) it$iv).m4863measureBRTryo0(constrains));
            index$iv$iv++;
            MeasureScope measureScope = $this$Layout;
        }
        long j = constrains;
        return MeasureScope.layout$default($this$Layout, Constraints.m5930getMaxWidthimpl(constrains), Constraints.m5929getMaxHeightimpl(constrains), (Map) null, new CoreTextKt$InlineChildren$1$2$measure$1(target$iv), 4, (Object) null);
    }
}
