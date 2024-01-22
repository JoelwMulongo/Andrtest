package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Drawer.kt */
final class DrawerKt$BottomDrawer$1$1$2$1 extends Lambda implements Function1<Density, IntOffset> {
    final /* synthetic */ BottomDrawerState $drawerState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerKt$BottomDrawer$1$1$2$1(BottomDrawerState bottomDrawerState) {
        super(1);
        this.$drawerState = bottomDrawerState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return IntOffset.m6095boximpl(m1492invokeBjo55l4((Density) p1));
    }

    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
    public final long m1492invokeBjo55l4(Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        return IntOffsetKt.IntOffset(0, MathKt.roundToInt(this.$drawerState.getOffset().getValue().floatValue()));
    }
}
