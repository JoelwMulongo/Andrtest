package androidx.core.app;

import android.app.Dialog;
import android.view.View;

public class DialogCompat {
    private DialogCompat() {
    }

    public static View requireViewById(Dialog dialog, int id) {
        return (View) Api28Impl.requireViewById(dialog, id);
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static <T> T requireViewById(Dialog dialog, int id) {
            return dialog.requireViewById(id);
        }
    }
}
