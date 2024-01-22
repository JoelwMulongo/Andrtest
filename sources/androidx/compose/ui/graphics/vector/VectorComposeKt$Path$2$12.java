package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorCompose.kt */
final class VectorComposeKt$Path$2$12 extends Lambda implements Function2<PathComponent, Float, Unit> {
    public static final VectorComposeKt$Path$2$12 INSTANCE = new VectorComposeKt$Path$2$12();

    VectorComposeKt$Path$2$12() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((PathComponent) p1, ((Number) p2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(PathComponent $this$set, float it) {
        Intrinsics.checkNotNullParameter($this$set, "$this$set");
        $this$set.setTrimPathStart(it);
    }
}
