package androidx.activity.compose;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ActivityResultRegistry.kt */
final class ActivityResultRegistryKt$rememberLauncherForActivityResult$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ ActivityResultRegistry $activityResultRegistry;
    final /* synthetic */ ActivityResultContract<I, O> $contract;
    final /* synthetic */ State<Function1<O, Unit>> $currentOnResult;
    final /* synthetic */ String $key;
    final /* synthetic */ ActivityResultLauncherHolder<I> $realLauncher;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ActivityResultRegistryKt$rememberLauncherForActivityResult$1(ActivityResultLauncherHolder<I> activityResultLauncherHolder, ActivityResultRegistry activityResultRegistry, String str, ActivityResultContract<I, O> activityResultContract, State<? extends Function1<? super O, Unit>> state) {
        super(1);
        this.$realLauncher = activityResultLauncherHolder;
        this.$activityResultRegistry = activityResultRegistry;
        this.$key = str;
        this.$contract = activityResultContract;
        this.$currentOnResult = state;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        ActivityResultLauncherHolder<I> activityResultLauncherHolder = this.$realLauncher;
        ActivityResultRegistry activityResultRegistry = this.$activityResultRegistry;
        String str = this.$key;
        ActivityResultContract<I, O> activityResultContract = this.$contract;
        final State<Function1<O, Unit>> state = this.$currentOnResult;
        activityResultLauncherHolder.setLauncher(activityResultRegistry.register(str, activityResultContract, new ActivityResultCallback<O>() {
            public final void onActivityResult(O it) {
                state.getValue().invoke(it);
            }
        }));
        DisposableEffectScope disposableEffectScope = $this$DisposableEffect;
        return new ActivityResultRegistryKt$rememberLauncherForActivityResult$1$invoke$$inlined$onDispose$1(this.$realLauncher);
    }
}
