package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorCompose.kt */
final class VectorComposeKt$Group$2$1 extends Lambda implements Function2<GroupComponent, String, Unit> {
    public static final VectorComposeKt$Group$2$1 INSTANCE = new VectorComposeKt$Group$2$1();

    VectorComposeKt$Group$2$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((GroupComponent) p1, (String) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(GroupComponent $this$set, String it) {
        Intrinsics.checkNotNullParameter($this$set, "$this$set");
        Intrinsics.checkNotNullParameter(it, "it");
        $this$set.setName(it);
    }
}
