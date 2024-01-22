package androidx.compose.foundation;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Image.kt */
final class ImageKt$Image$2 implements MeasurePolicy {
    public static final ImageKt$Image$2 INSTANCE = new ImageKt$Image$2();

    ImageKt$Image$2() {
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m494measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, long constraints) {
        Intrinsics.checkNotNullParameter($this$Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
        return MeasureScope.layout$default($this$Layout, Constraints.m5932getMinWidthimpl(constraints), Constraints.m5931getMinHeightimpl(constraints), (Map) null, ImageKt$Image$2$measure$1.INSTANCE, 4, (Object) null);
    }
}
