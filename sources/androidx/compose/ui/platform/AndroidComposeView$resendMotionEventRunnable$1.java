package androidx.compose.ui.platform;

import android.view.MotionEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Ljava/lang/Runnable;", "run", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidComposeView.android.kt */
public final class AndroidComposeView$resendMotionEventRunnable$1 implements Runnable {
    final /* synthetic */ AndroidComposeView this$0;

    AndroidComposeView$resendMotionEventRunnable$1(AndroidComposeView $receiver) {
        this.this$0 = $receiver;
    }

    public void run() {
        int newAction;
        this.this$0.removeCallbacks(this);
        MotionEvent lastMotionEvent = this.this$0.previousMotionEvent;
        if (lastMotionEvent != null) {
            boolean resend = false;
            boolean wasMouseEvent = lastMotionEvent.getToolType(0) == 3;
            int action = lastMotionEvent.getActionMasked();
            if (wasMouseEvent) {
                if (!(action == 10 || action == 1)) {
                    resend = true;
                }
            } else if (action != 1) {
                resend = true;
            }
            if (resend) {
                switch (action) {
                    case 7:
                    case 9:
                        newAction = 7;
                        break;
                    default:
                        newAction = 2;
                        break;
                }
                AndroidComposeView androidComposeView = this.this$0;
                androidComposeView.sendSimulatedEvent(lastMotionEvent, newAction, androidComposeView.relayoutTime, false);
            }
        }
    }
}
