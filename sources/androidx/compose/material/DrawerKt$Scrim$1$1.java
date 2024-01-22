package androidx.compose.material;

import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Drawer.kt */
final class DrawerKt$Scrim$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $color;
    final /* synthetic */ Function0<Float> $fraction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawerKt$Scrim$1$1(long j, Function0<Float> function0) {
        super(1);
        this.$color = j;
        this.$fraction = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((DrawScope) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        DrawScope.m3748drawRectnJ9OG0$default($this$Canvas, this.$color, 0, 0, this.$fraction.invoke().floatValue(), (DrawStyle) null, (ColorFilter) null, 0, 118, (Object) null);
    }
}
