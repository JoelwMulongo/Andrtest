package androidx.compose.material;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ModalBottomSheet.kt */
final class ModalBottomSheetKt$Scrim$dismissModifier$2$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ String $closeSheet;
    final /* synthetic */ Function0<Unit> $onDismiss;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheetKt$Scrim$dismissModifier$2$1(String str, Function0<Unit> function0) {
        super(1);
        this.$closeSheet = str;
        this.$onDismiss = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((SemanticsPropertyReceiver) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription($this$semantics, this.$closeSheet);
        final Function0<Unit> function0 = this.$onDismiss;
        SemanticsPropertiesKt.onClick$default($this$semantics, (String) null, new Function0<Boolean>() {
            public final Boolean invoke() {
                function0.invoke();
                return true;
            }
        }, 1, (Object) null);
    }
}
