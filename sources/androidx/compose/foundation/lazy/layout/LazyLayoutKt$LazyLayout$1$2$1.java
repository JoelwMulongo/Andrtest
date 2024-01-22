package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayout.kt */
final class LazyLayoutKt$LazyLayout$1$2$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ LazyLayoutItemContentFactory $itemContentFactory;
    final /* synthetic */ Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> $measurePolicy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutKt$LazyLayout$1$2$1(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> function2) {
        super(2);
        this.$itemContentFactory = lazyLayoutItemContentFactory;
        this.$measurePolicy = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m1008invoke0kLqBqw((SubcomposeMeasureScope) p1, ((Constraints) p2).m5936unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m1008invoke0kLqBqw(SubcomposeMeasureScope $this$null, long constraints) {
        Intrinsics.checkNotNullParameter($this$null, "$this$null");
        return this.$measurePolicy.invoke(new LazyLayoutMeasureScopeImpl(this.$itemContentFactory, $this$null), Constraints.m5918boximpl(constraints));
    }
}
