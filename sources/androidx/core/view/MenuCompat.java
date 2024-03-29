package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import androidx.core.internal.view.SupportMenu;

public final class MenuCompat {
    @Deprecated
    public static void setShowAsAction(MenuItem item, int actionEnum) {
        item.setShowAsAction(actionEnum);
    }

    public static void setGroupDividerEnabled(Menu menu, boolean enabled) {
        if (menu instanceof SupportMenu) {
            ((SupportMenu) menu).setGroupDividerEnabled(enabled);
        } else {
            Api28Impl.setGroupDividerEnabled(menu, enabled);
        }
    }

    private MenuCompat() {
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static void setGroupDividerEnabled(Menu menu, boolean groupDividerEnabled) {
            menu.setGroupDividerEnabled(groupDividerEnabled);
        }
    }
}
