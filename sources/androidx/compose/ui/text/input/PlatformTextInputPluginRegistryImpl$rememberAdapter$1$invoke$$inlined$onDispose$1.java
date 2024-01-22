package androidx.compose.ui.text.input;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonCancellable;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Effects.kt */
public final class PlatformTextInputPluginRegistryImpl$rememberAdapter$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ PlatformTextInputPluginRegistryImpl.AdapterHandle $adapterHandle$inlined;
    final /* synthetic */ CoroutineScope $scope$inlined;
    final /* synthetic */ PlatformTextInputPluginRegistryImpl this$0;

    public PlatformTextInputPluginRegistryImpl$rememberAdapter$1$invoke$$inlined$onDispose$1(PlatformTextInputPluginRegistryImpl.AdapterHandle adapterHandle, CoroutineScope coroutineScope, PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistryImpl) {
        this.$adapterHandle$inlined = adapterHandle;
        this.$scope$inlined = coroutineScope;
        this.this$0 = platformTextInputPluginRegistryImpl;
    }

    public void dispose() {
        if (this.$adapterHandle$inlined.dispose()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.$scope$inlined, NonCancellable.INSTANCE, (CoroutineStart) null, new PlatformTextInputPluginRegistryImpl$rememberAdapter$1$1$1(this.this$0, (Continuation<? super PlatformTextInputPluginRegistryImpl$rememberAdapter$1$1$1>) null), 2, (Object) null);
        }
    }
}
