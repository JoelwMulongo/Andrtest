package androidx.compose.foundation;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.PinnableContainer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Focusable.kt */
final class FocusableKt$focusable$2$3$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ MutableState<Boolean> $isFocused$delegate;
    final /* synthetic */ MutableState<PinnableContainer.PinnedHandle> $pinHandle$delegate;
    final /* synthetic */ PinnableContainer $pinnableContainer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusableKt$focusable$2$3$1(PinnableContainer pinnableContainer, MutableState<Boolean> mutableState, MutableState<PinnableContainer.PinnedHandle> mutableState2) {
        super(1);
        this.$pinnableContainer = pinnableContainer;
        this.$isFocused$delegate = mutableState;
        this.$pinHandle$delegate = mutableState2;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        if (FocusableKt$focusable$2.invoke$lambda$2(this.$isFocused$delegate)) {
            MutableState<PinnableContainer.PinnedHandle> mutableState = this.$pinHandle$delegate;
            PinnableContainer pinnableContainer = this.$pinnableContainer;
            FocusableKt$focusable$2.invoke$lambda$10(mutableState, pinnableContainer != null ? pinnableContainer.pin() : null);
        }
        DisposableEffectScope disposableEffectScope = $this$DisposableEffect;
        return new FocusableKt$focusable$2$3$1$invoke$$inlined$onDispose$1(this.$pinHandle$delegate);
    }
}
