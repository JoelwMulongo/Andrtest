package androidx.compose.ui.text.input;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0003\u001a\u001b\u001cB#\u0012\u001c\u0010\u0002\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0002J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0014\"\b\b\u0000\u0010\u0015*\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0004H\u0007J*\u0010\u0017\u001a\f\u0012\u0004\u0012\u0002H\u00150\nR\u00020\u0000\"\b\b\u0000\u0010\u0015*\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0004H\u0002J%\u0010\u0018\u001a\u0002H\u0015\"\b\b\u0000\u0010\u0015*\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0004H\u0017¢\u0006\u0002\u0010\u0019R&\u0010\b\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0012\n\u0012\u0002\b\u00030\nR\u00020\u00000\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0002\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/text/input/PlatformTextInputPluginRegistryImpl;", "Landroidx/compose/ui/text/input/PlatformTextInputPluginRegistry;", "factory", "Lkotlin/Function2;", "Landroidx/compose/ui/text/input/PlatformTextInputPlugin;", "Landroidx/compose/ui/text/input/PlatformTextInput;", "Landroidx/compose/ui/text/input/PlatformTextInputAdapter;", "(Lkotlin/jvm/functions/Function2;)V", "adaptersByPlugin", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "Landroidx/compose/ui/text/input/PlatformTextInputPluginRegistryImpl$AdapterWithRefCount;", "adaptersMayNeedDisposal", "", "focusedAdapter", "getFocusedAdapter", "()Landroidx/compose/ui/text/input/PlatformTextInputAdapter;", "focusedPlugin", "disposeTombstonedAdapters", "", "getOrCreateAdapter", "Landroidx/compose/ui/text/input/PlatformTextInputPluginRegistryImpl$AdapterHandle;", "T", "plugin", "instantiateAdapter", "rememberAdapter", "(Landroidx/compose/ui/text/input/PlatformTextInputPlugin;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/input/PlatformTextInputAdapter;", "AdapterHandle", "AdapterInput", "AdapterWithRefCount", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PlatformTextInputAdapter.kt */
public final class PlatformTextInputPluginRegistryImpl implements PlatformTextInputPluginRegistry {
    public static final int $stable = 0;
    private final SnapshotStateMap<PlatformTextInputPlugin<?>, AdapterWithRefCount<?>> adaptersByPlugin = SnapshotStateKt.mutableStateMapOf();
    /* access modifiers changed from: private */
    public boolean adaptersMayNeedDisposal;
    private final Function2<PlatformTextInputPlugin<?>, PlatformTextInput, PlatformTextInputAdapter> factory;
    /* access modifiers changed from: private */
    public PlatformTextInputPlugin<?> focusedPlugin;

    public PlatformTextInputPluginRegistryImpl(Function2<? super PlatformTextInputPlugin<?>, ? super PlatformTextInput, ? extends PlatformTextInputAdapter> factory2) {
        Intrinsics.checkNotNullParameter(factory2, "factory");
        this.factory = factory2;
    }

    public final PlatformTextInputAdapter getFocusedAdapter() {
        AdapterWithRefCount adapterWithRefCount = (AdapterWithRefCount) this.adaptersByPlugin.get(this.focusedPlugin);
        PlatformTextInputAdapter adapter = adapterWithRefCount != null ? adapterWithRefCount.getAdapter() : null;
        PlatformTextInputAdapter platformTextInputAdapter = adapter;
        return adapter;
    }

    public <T extends PlatformTextInputAdapter> T rememberAdapter(PlatformTextInputPlugin<T> plugin, Composer $composer, int $changed) {
        AdapterHandle<T> adapterHandle;
        Object value$iv$iv$iv;
        PlatformTextInputPlugin<T> platformTextInputPlugin = plugin;
        Composer composer = $composer;
        int i = $changed;
        Intrinsics.checkNotNullParameter(platformTextInputPlugin, "plugin");
        composer.startReplaceableGroup(-845039128);
        ComposerKt.sourceInformation(composer, "C(rememberAdapter)166@6812L47,171@7094L24,172@7127L1452:PlatformTextInputAdapter.kt#n30j42");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-845039128, i, -1, "androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl.rememberAdapter (PlatformTextInputAdapter.kt:161)");
        }
        int i2 = i & 14;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = composer.changed((Object) platformTextInputPlugin);
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            adapterHandle = getOrCreateAdapter(plugin);
            $this$cache$iv$iv.updateRememberedValue(adapterHandle);
        } else {
            adapterHandle = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        AdapterHandle adapterHandle2 = adapterHandle;
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "C(rememberCoroutineScope)475@19849L144:Effects.kt#9igjgp");
        Composer composer$iv = $composer;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv$iv = $composer;
        Object it$iv$iv$iv = $this$cache$iv$iv$iv.rememberedValue();
        if (it$iv$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer$iv));
            $this$cache$iv$iv$iv.updateRememberedValue(value$iv$iv$iv);
        } else {
            value$iv$iv$iv = it$iv$iv$iv;
        }
        $composer.endReplaceableGroup();
        CoroutineScope scope = ((CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv).getCoroutineScope();
        $composer.endReplaceableGroup();
        EffectsKt.DisposableEffect((Object) adapterHandle2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new PlatformTextInputPluginRegistryImpl$rememberAdapter$1(adapterHandle2, scope, this), composer, 8);
        T adapter = adapterHandle2.getAdapter();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return adapter;
    }

    public final <T extends PlatformTextInputAdapter> AdapterHandle<T> getOrCreateAdapter(PlatformTextInputPlugin<T> plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        AdapterWithRefCount adapterWithRefCount = this.adaptersByPlugin.get(plugin);
        if (adapterWithRefCount == null) {
            adapterWithRefCount = instantiateAdapter(plugin);
        }
        adapterWithRefCount.incrementRefCount();
        return new AdapterHandle<>(adapterWithRefCount.getAdapter(), new PlatformTextInputPluginRegistryImpl$getOrCreateAdapter$1(adapterWithRefCount));
    }

    /* access modifiers changed from: private */
    public final void disposeTombstonedAdapters() {
        if (this.adaptersMayNeedDisposal) {
            this.adaptersMayNeedDisposal = false;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : this.adaptersByPlugin.entrySet()) {
                if (((AdapterWithRefCount) ((Map.Entry) element$iv$iv).getValue()).isRefCountZero()) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            List $this$fastForEach$iv = (List) destination$iv$iv;
            int size = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Map.Entry entry = (Map.Entry) $this$fastForEach$iv.get(index$iv);
                PlatformTextInputPlugin plugin = (PlatformTextInputPlugin) entry.getKey();
                AdapterWithRefCount adapter = (AdapterWithRefCount) entry.getValue();
                if (Intrinsics.areEqual((Object) this.focusedPlugin, (Object) plugin)) {
                    this.focusedPlugin = null;
                }
                this.adaptersByPlugin.remove(plugin);
                PlatformTextInputAdapter_androidKt.dispose(adapter.getAdapter());
            }
        }
    }

    private final <T extends PlatformTextInputAdapter> AdapterWithRefCount<T> instantiateAdapter(PlatformTextInputPlugin<T> plugin) {
        PlatformTextInputAdapter newAdapter = this.factory.invoke(plugin, new AdapterInput(this, plugin));
        Intrinsics.checkNotNull(newAdapter, "null cannot be cast to non-null type T of androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl.instantiateAdapter");
        AdapterWithRefCount withRefCount = new AdapterWithRefCount(this, newAdapter);
        this.adaptersByPlugin.put(plugin, withRefCount);
        return withRefCount;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u0007R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/input/PlatformTextInputPluginRegistryImpl$AdapterHandle;", "T", "Landroidx/compose/ui/text/input/PlatformTextInputAdapter;", "", "adapter", "onDispose", "Lkotlin/Function0;", "", "(Landroidx/compose/ui/text/input/PlatformTextInputAdapter;Lkotlin/jvm/functions/Function0;)V", "getAdapter", "()Landroidx/compose/ui/text/input/PlatformTextInputAdapter;", "Landroidx/compose/ui/text/input/PlatformTextInputAdapter;", "disposed", "dispose", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PlatformTextInputAdapter.kt */
    public static final class AdapterHandle<T extends PlatformTextInputAdapter> {
        public static final int $stable = 8;
        private final T adapter;
        private boolean disposed;
        private final Function0<Boolean> onDispose;

        public AdapterHandle(T adapter2, Function0<Boolean> onDispose2) {
            Intrinsics.checkNotNullParameter(adapter2, "adapter");
            Intrinsics.checkNotNullParameter(onDispose2, "onDispose");
            this.adapter = adapter2;
            this.onDispose = onDispose2;
        }

        public final T getAdapter() {
            return this.adapter;
        }

        public final boolean dispose() {
            if (!this.disposed) {
                this.disposed = true;
                return this.onDispose.invoke().booleanValue();
            }
            throw new IllegalStateException("AdapterHandle already disposed".toString());
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0016\u001a\u00020\u0017R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/input/PlatformTextInputPluginRegistryImpl$AdapterWithRefCount;", "T", "Landroidx/compose/ui/text/input/PlatformTextInputAdapter;", "", "adapter", "(Landroidx/compose/ui/text/input/PlatformTextInputPluginRegistryImpl;Landroidx/compose/ui/text/input/PlatformTextInputAdapter;)V", "getAdapter", "()Landroidx/compose/ui/text/input/PlatformTextInputAdapter;", "Landroidx/compose/ui/text/input/PlatformTextInputAdapter;", "isRefCountZero", "", "()Z", "<set-?>", "", "refCount", "getRefCount", "()I", "setRefCount", "(I)V", "refCount$delegate", "Landroidx/compose/runtime/MutableState;", "decrementRefCount", "incrementRefCount", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PlatformTextInputAdapter.kt */
    private final class AdapterWithRefCount<T extends PlatformTextInputAdapter> {
        private final T adapter;
        private final MutableState refCount$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
        final /* synthetic */ PlatformTextInputPluginRegistryImpl this$0;

        public AdapterWithRefCount(PlatformTextInputPluginRegistryImpl this$02, T adapter2) {
            Intrinsics.checkNotNullParameter(adapter2, "adapter");
            this.this$0 = this$02;
            this.adapter = adapter2;
        }

        public final T getAdapter() {
            return this.adapter;
        }

        private final int getRefCount() {
            return ((Number) this.refCount$delegate.getValue()).intValue();
        }

        private final void setRefCount(int i) {
            this.refCount$delegate.setValue(Integer.valueOf(i));
        }

        public final boolean isRefCountZero() {
            return getRefCount() == 0;
        }

        public final void incrementRefCount() {
            setRefCount(getRefCount() + 1);
        }

        public final boolean decrementRefCount() {
            setRefCount(getRefCount() - 1);
            if (!(getRefCount() >= 0)) {
                throw new IllegalStateException(("AdapterWithRefCount.decrementRefCount called too many times (refCount=" + getRefCount() + ')').toString());
            } else if (getRefCount() != 0) {
                return false;
            } else {
                this.this$0.adaptersMayNeedDisposal = true;
                return true;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/input/PlatformTextInputPluginRegistryImpl$AdapterInput;", "Landroidx/compose/ui/text/input/PlatformTextInput;", "plugin", "Landroidx/compose/ui/text/input/PlatformTextInputPlugin;", "(Landroidx/compose/ui/text/input/PlatformTextInputPluginRegistryImpl;Landroidx/compose/ui/text/input/PlatformTextInputPlugin;)V", "releaseInputFocus", "", "requestInputFocus", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PlatformTextInputAdapter.kt */
    private final class AdapterInput implements PlatformTextInput {
        private final PlatformTextInputPlugin<?> plugin;
        final /* synthetic */ PlatformTextInputPluginRegistryImpl this$0;

        public AdapterInput(PlatformTextInputPluginRegistryImpl this$02, PlatformTextInputPlugin<?> plugin2) {
            Intrinsics.checkNotNullParameter(plugin2, "plugin");
            this.this$0 = this$02;
            this.plugin = plugin2;
        }

        public void requestInputFocus() {
            this.this$0.focusedPlugin = this.plugin;
        }

        public void releaseInputFocus() {
            if (Intrinsics.areEqual((Object) this.this$0.focusedPlugin, (Object) this.plugin)) {
                this.this$0.focusedPlugin = null;
            }
        }
    }
}
