package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Clickable.kt */
public final class ClickableKt$clickable$4$1$1 implements ModifierLocalConsumer {
    final /* synthetic */ MutableState<Boolean> $isClickableInScrollableContainer;

    ClickableKt$clickable$4$1$1(MutableState<Boolean> $isClickableInScrollableContainer2) {
        this.$isClickableInScrollableContainer = $isClickableInScrollableContainer2;
    }

    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.$isClickableInScrollableContainer.setValue(scope.getCurrent(ScrollableKt.getModifierLocalScrollableContainer()));
    }
}
