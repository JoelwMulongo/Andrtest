package androidx.compose.ui.platform;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/input/key/KeyEvent;", "invoke-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
final class AndroidComposeView$keyInputModifier$1 extends Lambda implements Function1<KeyEvent, Boolean> {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidComposeView$keyInputModifier$1(AndroidComposeView androidComposeView) {
        super(1);
        this.this$0 = androidComposeView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return m5205invokeZmokQxo(((KeyEvent) p1).m4513unboximpl());
    }

    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m5205invokeZmokQxo(android.view.KeyEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        FocusDirection focusDirection = this.this$0.m5199getFocusDirectionP8AzH3I(it);
        if (focusDirection == null || !KeyEventType.m4517equalsimpl0(KeyEvent_androidKt.m4525getTypeZmokQxo(it), KeyEventType.Companion.m4521getKeyDownCS__XNY())) {
            return false;
        }
        return Boolean.valueOf(this.this$0.getFocusOwner().m2857moveFocus3ESFkO8(focusDirection.m2842unboximpl()));
    }
}
