package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
final class SwitchKt$SwitchImpl$3$1 extends Lambda implements Function1<Density, IntOffset> {
    final /* synthetic */ State<Float> $thumbValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwitchKt$SwitchImpl$3$1(State<Float> state) {
        super(1);
        this.$thumbValue = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        return IntOffset.m6095boximpl(m1647invokeBjo55l4((Density) p1));
    }

    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
    public final long m1647invokeBjo55l4(Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        return IntOffsetKt.IntOffset(MathKt.roundToInt(this.$thumbValue.getValue().floatValue()), 0);
    }
}
