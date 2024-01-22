package androidx.compose.material;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackdropScaffold.kt */
final class BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1 extends Lambda implements Function1<Constraints, Constraints> {
    final /* synthetic */ float $headerHeightPx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackdropScaffoldKt$BackdropScaffold$calculateBackLayerConstraints$1$1(float f) {
        super(1);
        this.$headerHeightPx = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return Constraints.m5918boximpl(m1381invokeZezNO4M(((Constraints) p1).m5936unboximpl()));
    }

    /* renamed from: invoke-ZezNO4M  reason: not valid java name */
    public final long m1381invokeZezNO4M(long it) {
        return ConstraintsKt.m5947offsetNN6EwU$default(Constraints.m5921copyZbe2FdA$default(it, 0, 0, 0, 0, 10, (Object) null), 0, -MathKt.roundToInt(this.$headerHeightPx), 1, (Object) null);
    }
}
