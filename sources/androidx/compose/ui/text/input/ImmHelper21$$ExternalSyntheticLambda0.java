package androidx.compose.ui.text.input;

import android.view.inputmethod.InputMethodManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ImmHelper21$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ InputMethodManager f$0;
    public final /* synthetic */ ImmHelper21 f$1;

    public /* synthetic */ ImmHelper21$$ExternalSyntheticLambda0(InputMethodManager inputMethodManager, ImmHelper21 immHelper21) {
        this.f$0 = inputMethodManager;
        this.f$1 = immHelper21;
    }

    public final void run() {
        ImmHelper21.showSoftInput$lambda$0(this.f$0, this.f$1);
    }
}
