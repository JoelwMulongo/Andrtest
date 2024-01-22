package androidx.compose.foundation;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Focusable.kt */
final class FocusableKt$focusable$2$4$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ MutableState<Boolean> $isFocused$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusableKt$focusable$2$4$1(MutableState<Boolean> mutableState, FocusRequester focusRequester) {
        super(1);
        this.$isFocused$delegate = mutableState;
        this.$focusRequester = focusRequester;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SemanticsPropertyReceiver) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        SemanticsPropertiesKt.setFocused($this$semantics, FocusableKt$focusable$2.invoke$lambda$2(this.$isFocused$delegate));
        final FocusRequester focusRequester = this.$focusRequester;
        final MutableState<Boolean> mutableState = this.$isFocused$delegate;
        SemanticsPropertiesKt.requestFocus$default($this$semantics, (String) null, new Function0<Boolean>() {
            public final Boolean invoke() {
                focusRequester.requestFocus();
                return Boolean.valueOf(FocusableKt$focusable$2.invoke$lambda$2(mutableState));
            }
        }, 1, (Object) null);
    }
}
