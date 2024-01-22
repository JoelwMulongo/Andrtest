package androidx.compose.ui.text.input;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PlatformTextInputAdapter.kt */
final class PlatformTextInputPluginRegistryImpl$rememberAdapter$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ PlatformTextInputPluginRegistryImpl.AdapterHandle<T> $adapterHandle;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ PlatformTextInputPluginRegistryImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlatformTextInputPluginRegistryImpl$rememberAdapter$1(PlatformTextInputPluginRegistryImpl.AdapterHandle<T> adapterHandle, CoroutineScope coroutineScope, PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistryImpl) {
        super(1);
        this.$adapterHandle = adapterHandle;
        this.$scope = coroutineScope;
        this.this$0 = platformTextInputPluginRegistryImpl;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        DisposableEffectScope disposableEffectScope = $this$DisposableEffect;
        return new PlatformTextInputPluginRegistryImpl$rememberAdapter$1$invoke$$inlined$onDispose$1(this.$adapterHandle, this.$scope, this.this$0);
    }
}
