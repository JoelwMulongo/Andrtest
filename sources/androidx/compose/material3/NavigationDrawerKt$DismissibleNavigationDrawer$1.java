package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class NavigationDrawerKt$DismissibleNavigationDrawer$1 extends Lambda implements Function2<DrawerValue, DrawerValue, ThresholdConfig> {
    public static final NavigationDrawerKt$DismissibleNavigationDrawer$1 INSTANCE = new NavigationDrawerKt$DismissibleNavigationDrawer$1();

    NavigationDrawerKt$DismissibleNavigationDrawer$1() {
        super(2);
    }

    public final ThresholdConfig invoke(DrawerValue drawerValue, DrawerValue drawerValue2) {
        Intrinsics.checkNotNullParameter(drawerValue, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(drawerValue2, "<anonymous parameter 1>");
        return new FractionalThreshold(0.5f);
    }
}
