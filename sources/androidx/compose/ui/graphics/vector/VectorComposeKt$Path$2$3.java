package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.PathFillType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorCompose.kt */
final class VectorComposeKt$Path$2$3 extends Lambda implements Function2<PathComponent, PathFillType, Unit> {
    public static final VectorComposeKt$Path$2$3 INSTANCE = new VectorComposeKt$Path$2$3();

    VectorComposeKt$Path$2$3() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        m3885invokepweu1eQ((PathComponent) p1, ((PathFillType) p2).m3456unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-pweu1eQ  reason: not valid java name */
    public final void m3885invokepweu1eQ(PathComponent $this$set, int it) {
        Intrinsics.checkNotNullParameter($this$set, "$this$set");
        $this$set.m3880setPathFillTypeoQ8Xj4U(it);
    }
}
