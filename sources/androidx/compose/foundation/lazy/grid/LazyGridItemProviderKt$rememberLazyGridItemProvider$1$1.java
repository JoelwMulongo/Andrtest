package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridItemProvider.kt */
public final class LazyGridItemProviderKt$rememberLazyGridItemProvider$1$1 implements LazyGridItemProvider, LazyLayoutItemProvider {
    private final /* synthetic */ LazyLayoutItemProvider $$delegate_0;
    final /* synthetic */ State<LazyGridItemProvider> $itemProviderState;

    public void Item(int i, Composer composer, int i2) {
        composer.startReplaceableGroup(125380152);
        ComposerKt.sourceInformation(composer, "C(Item)-1@-2:LazyGridItemProvider.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(125380152, i2, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridItemProvider.<anonymous>.<no name provided>.Item (LazyGridItemProvider.kt:-1)");
        }
        this.$$delegate_0.Item(i, composer, i2 & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    public Object getContentType(int i) {
        return this.$$delegate_0.getContentType(i);
    }

    public int getItemCount() {
        return this.$$delegate_0.getItemCount();
    }

    public Object getKey(int i) {
        return this.$$delegate_0.getKey(i);
    }

    public Map<Object, Integer> getKeyToIndexMap() {
        return this.$$delegate_0.getKeyToIndexMap();
    }

    LazyGridItemProviderKt$rememberLazyGridItemProvider$1$1(State<? extends LazyGridItemProvider> $itemProviderState2) {
        this.$itemProviderState = $itemProviderState2;
        this.$$delegate_0 = LazyLayoutItemProviderKt.DelegatingLazyLayoutItemProvider($itemProviderState2);
    }

    public LazyGridSpanLayoutProvider getSpanLayoutProvider() {
        return this.$itemProviderState.getValue().getSpanLayoutProvider();
    }

    public boolean getHasCustomSpans() {
        return this.$itemProviderState.getValue().getHasCustomSpans();
    }

    /* renamed from: getSpan-_-orMbw  reason: not valid java name */
    public long m960getSpan_orMbw(LazyGridItemSpanScope $this$getSpan_u2d__u2dorMbw, int index) {
        Intrinsics.checkNotNullParameter($this$getSpan_u2d__u2dorMbw, "$this$getSpan");
        return this.$itemProviderState.getValue().m958getSpan_orMbw($this$getSpan_u2d__u2dorMbw, index);
    }
}
