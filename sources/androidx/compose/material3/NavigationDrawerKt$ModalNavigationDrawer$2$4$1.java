package androidx.compose.material3;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NavigationDrawer.kt */
final class NavigationDrawerKt$ModalNavigationDrawer$2$4$1 extends Lambda implements Function1<Density, IntOffset> {
    final /* synthetic */ DrawerState $drawerState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NavigationDrawerKt$ModalNavigationDrawer$2$4$1(DrawerState drawerState) {
        super(1);
        this.$drawerState = drawerState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return IntOffset.m6095boximpl(m2015invokeBjo55l4((Density) p1));
    }

    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
    public final long m2015invokeBjo55l4(Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        return IntOffsetKt.IntOffset(MathKt.roundToInt(this.$drawerState.getOffset().getValue().floatValue()), 0);
    }
}
