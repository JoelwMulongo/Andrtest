package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composables.kt */
public final class SubcomposeLayoutKt$SubcomposeLayout$$inlined$ComposeNode$1 extends Lambda implements Function0<LayoutNode> {
    final /* synthetic */ Function0 $factory;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubcomposeLayoutKt$SubcomposeLayout$$inlined$ComposeNode$1(Function0 function0) {
        super(0);
        this.$factory = function0;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [androidx.compose.ui.node.LayoutNode, java.lang.Object] */
    public final LayoutNode invoke() {
        return this.$factory.invoke();
    }
}
