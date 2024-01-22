package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TestModifierUpdater.kt */
final class TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1 implements MeasurePolicy {
    public static final TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1 INSTANCE = new TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1();

    TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1() {
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m4941measure3p2s80s(MeasureScope $this$MeasurePolicy, List<? extends Measurable> list, long constraints) {
        Intrinsics.checkNotNullParameter($this$MeasurePolicy, "$this$MeasurePolicy");
        Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
        return MeasureScope.layout$default($this$MeasurePolicy, Constraints.m5930getMaxWidthimpl(constraints), Constraints.m5929getMaxHeightimpl(constraints), (Map) null, TestModifierUpdaterKt$TestModifierUpdaterLayout$measurePolicy$1$measure$1.INSTANCE, 4, (Object) null);
    }
}
