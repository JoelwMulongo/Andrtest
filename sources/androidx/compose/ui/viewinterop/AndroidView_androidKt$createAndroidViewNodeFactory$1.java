package androidx.compose.ui.viewinterop;

import android.content.Context;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidView.android.kt */
final class AndroidView_androidKt$createAndroidViewNodeFactory$1 extends Lambda implements Function0<LayoutNode> {
    final /* synthetic */ Context $context;
    final /* synthetic */ NestedScrollDispatcher $dispatcher;
    final /* synthetic */ Function1<Context, T> $factory;
    final /* synthetic */ CompositionContext $parentReference;
    final /* synthetic */ String $stateKey;
    final /* synthetic */ SaveableStateRegistry $stateRegistry;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidView_androidKt$createAndroidViewNodeFactory$1(Context context, Function1<? super Context, ? extends T> function1, CompositionContext compositionContext, NestedScrollDispatcher nestedScrollDispatcher, SaveableStateRegistry saveableStateRegistry, String str) {
        super(0);
        this.$context = context;
        this.$factory = function1;
        this.$parentReference = compositionContext;
        this.$dispatcher = nestedScrollDispatcher;
        this.$stateRegistry = saveableStateRegistry;
        this.$stateKey = str;
    }

    public final LayoutNode invoke() {
        return new ViewFactoryHolder(this.$context, this.$factory, this.$parentReference, this.$dispatcher, this.$stateRegistry, this.$stateKey).getLayoutNode();
    }
}
