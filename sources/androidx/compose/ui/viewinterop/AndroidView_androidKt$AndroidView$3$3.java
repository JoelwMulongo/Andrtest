package androidx.compose.ui.viewinterop;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidView.android.kt */
final class AndroidView_androidKt$AndroidView$3$3 extends Lambda implements Function2<LayoutNode, Function1<? super T, ? extends Unit>, Unit> {
    public static final AndroidView_androidKt$AndroidView$3$3 INSTANCE = new AndroidView_androidKt$AndroidView$3$3();

    AndroidView_androidKt$AndroidView$3$3() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((LayoutNode) p1, (Function1) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutNode $this$set, Function1<? super T, Unit> it) {
        Intrinsics.checkNotNullParameter($this$set, "$this$set");
        Intrinsics.checkNotNullParameter(it, "it");
        AndroidView_androidKt.requireViewFactoryHolder($this$set).setReleaseBlock(it);
    }
}
