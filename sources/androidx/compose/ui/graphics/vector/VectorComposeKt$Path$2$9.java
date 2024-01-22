package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorCompose.kt */
final class VectorComposeKt$Path$2$9 extends Lambda implements Function2<PathComponent, StrokeJoin, Unit> {
    public static final VectorComposeKt$Path$2$9 INSTANCE = new VectorComposeKt$Path$2$9();

    VectorComposeKt$Path$2$9() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        m3886invokekLtJ_vA((PathComponent) p1, ((StrokeJoin) p2).m3556unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-kLtJ_vA  reason: not valid java name */
    public final void m3886invokekLtJ_vA(PathComponent $this$set, int it) {
        Intrinsics.checkNotNullParameter($this$set, "$this$set");
        $this$set.m3882setStrokeLineJoinWw9F2mQ(it);
    }
}
