package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BoxWithConstraints.kt */
final class BoxWithConstraintsKt$BoxWithConstraints$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function3<BoxWithConstraintsScope, Composer, Integer, Unit> $content;
    final /* synthetic */ MeasurePolicy $measurePolicy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BoxWithConstraintsKt$BoxWithConstraints$1$1(MeasurePolicy measurePolicy, Function3<? super BoxWithConstraintsScope, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$measurePolicy = measurePolicy;
        this.$content = function3;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return m713invoke0kLqBqw((SubcomposeMeasureScope) p1, ((Constraints) p2).m5936unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m713invoke0kLqBqw(SubcomposeMeasureScope $this$SubcomposeLayout, long constraints) {
        Intrinsics.checkNotNullParameter($this$SubcomposeLayout, "$this$SubcomposeLayout");
        return this.$measurePolicy.m4864measure3p2s80s($this$SubcomposeLayout, $this$SubcomposeLayout.subcompose(Unit.INSTANCE, ComposableLambdaKt.composableLambdaInstance(-1945019079, true, new BoxWithConstraintsKt$BoxWithConstraints$1$1$measurables$1(this.$content, new BoxWithConstraintsScopeImpl($this$SubcomposeLayout, constraints, (DefaultConstructorMarker) null), this.$$dirty))), constraints);
    }
}
