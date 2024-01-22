package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorCompose.kt */
final class VectorComposeKt$Group$2$3 extends Lambda implements Function2<GroupComponent, Float, Unit> {
    public static final VectorComposeKt$Group$2$3 INSTANCE = new VectorComposeKt$Group$2$3();

    VectorComposeKt$Group$2$3() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((GroupComponent) p1, ((Number) p2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(GroupComponent $this$set, float it) {
        Intrinsics.checkNotNullParameter($this$set, "$this$set");
        $this$set.setPivotX(it);
    }
}
