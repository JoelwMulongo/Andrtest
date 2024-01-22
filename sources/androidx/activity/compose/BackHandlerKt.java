package androidx.activity.compose;

import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"BackHandler", "", "enabled", "", "onBack", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "activity-compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackHandler.kt */
public final class BackHandlerKt {
    public static final void BackHandler(boolean enabled, Function0<Unit> onBack, Composer $composer, int $changed, int i) {
        boolean z;
        boolean enabled2;
        Object value$iv$iv;
        Object value$iv$iv2;
        Function0<Unit> function0 = onBack;
        int i2 = $changed;
        int i3 = i;
        Intrinsics.checkNotNullParameter(function0, "onBack");
        Composer $composer2 = $composer.startRestartGroup(-361453782);
        ComposerKt.sourceInformation($composer2, "C(BackHandler)83@3458L28,85@3588L171,93@3860L48,93@3849L59,*96@3981L7,99@4160L7,100@4172L302:BackHandler.kt#q1dkbc");
        int $dirty = $changed;
        int i4 = i3 & 1;
        if (i4 != 0) {
            $dirty |= 6;
            z = enabled;
        } else if ((i2 & 14) == 0) {
            z = enabled;
            $dirty |= $composer2.changed(z) ? 4 : 2;
        } else {
            z = enabled;
        }
        if ((i3 & 2) != 0) {
            $dirty |= 48;
        } else if ((i2 & 112) == 0) {
            $dirty |= $composer2.changed((Object) function0) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            enabled2 = i4 != 0 ? true : z;
            State currentOnBack$delegate = SnapshotStateKt.rememberUpdatedState(function0, $composer2, ($dirty >> 3) & 14);
            $composer2.startReplaceableGroup(-3687241);
            ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer2;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = new BackHandlerKt$BackHandler$backCallback$1$1(enabled2, currentOnBack$delegate);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            BackHandlerKt$BackHandler$backCallback$1$1 backCallback = (BackHandlerKt$BackHandler$backCallback$1$1) value$iv$iv;
            Object key2$iv = Boolean.valueOf(enabled2);
            int i5 = (($dirty << 3) & 112) | 6;
            $composer2.startReplaceableGroup(-3686552);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed((Object) backCallback) | $composer2.changed(key2$iv);
            Composer $this$cache$iv$iv2 = $composer2;
            Object it$iv$iv2 = $this$cache$iv$iv2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv2 == Composer.Companion.getEmpty()) {
                int i6 = $dirty;
                value$iv$iv2 = (Function0) new BackHandlerKt$BackHandler$1$1(backCallback, enabled2);
                $this$cache$iv$iv2.updateRememberedValue(value$iv$iv2);
            } else {
                int i7 = $dirty;
                value$iv$iv2 = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) value$iv$iv2, $composer2, 0);
            OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent($composer2, 6);
            if (current != null) {
                OnBackPressedDispatcher backDispatcher = current.getOnBackPressedDispatcher();
                ComposerKt.sourceInformationMarkerStart($composer2, 103361330, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LifecycleOwner lifecycleOwner = (LifecycleOwner) consume;
                EffectsKt.DisposableEffect(lifecycleOwner, backDispatcher, new BackHandlerKt$BackHandler$2(backDispatcher, lifecycleOwner, backCallback), $composer2, 72);
            } else {
                throw new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner".toString());
            }
        } else {
            $composer2.skipToGroupEnd();
            int i8 = $dirty;
            enabled2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new BackHandlerKt$BackHandler$3(enabled2, function0, i2, i3));
        }
    }

    /* access modifiers changed from: private */
    public static final Function0<Unit> BackHandler$lambda$0(State<? extends Function0<Unit>> $currentOnBack$delegate) {
        return (Function0) $currentOnBack$delegate.getValue();
    }
}
