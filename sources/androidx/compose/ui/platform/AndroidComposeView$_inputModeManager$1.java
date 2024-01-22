package androidx.compose.ui.platform;

import androidx.compose.ui.input.InputMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/input/InputMode;", "invoke-iuPiT84", "(I)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
final class AndroidComposeView$_inputModeManager$1 extends Lambda implements Function1<InputMode, Boolean> {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidComposeView$_inputModeManager$1(AndroidComposeView androidComposeView) {
        super(1);
        this.this$0 = androidComposeView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return m5204invokeiuPiT84(((InputMode) p1).m3918unboximpl());
    }

    /* renamed from: invoke-iuPiT84  reason: not valid java name */
    public final Boolean m5204invokeiuPiT84(int it) {
        boolean z;
        if (InputMode.m3915equalsimpl0(it, InputMode.Companion.m3920getTouchaOaMEAU())) {
            z = this.this$0.isInTouchMode();
        } else if (InputMode.m3915equalsimpl0(it, InputMode.Companion.m3919getKeyboardaOaMEAU())) {
            z = this.this$0.isInTouchMode() ? this.this$0.requestFocusFromTouch() : true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
