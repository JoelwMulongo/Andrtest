package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class NavigationDrawerKt$ModalNavigationDrawer$2$3$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ DrawerState $drawerState;
    final /* synthetic */ float $maxValue;
    final /* synthetic */ float $minValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationDrawerKt$ModalNavigationDrawer$2$3$1(float f, float f2, DrawerState drawerState) {
        super(0);
        this.$minValue = f;
        this.$maxValue = f2;
        this.$drawerState = drawerState;
    }

    public final Float invoke() {
        return Float.valueOf(NavigationDrawerKt.calculateFraction(this.$minValue, this.$maxValue, this.$drawerState.getOffset().getValue().floatValue()));
    }
}
