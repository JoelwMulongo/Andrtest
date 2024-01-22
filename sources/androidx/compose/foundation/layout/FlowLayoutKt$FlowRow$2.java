package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FlowLayout.kt */
final class FlowLayoutKt$FlowRow$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ int $maxItemsInEachRow;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowLayoutKt$FlowRow$2(Modifier modifier, Arrangement.Horizontal horizontal, Alignment.Vertical vertical, int i, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i2, int i3) {
        super(2);
        this.$modifier = modifier;
        this.$horizontalArrangement = horizontal;
        this.$verticalAlignment = vertical;
        this.$maxItemsInEachRow = i;
        this.$content = function3;
        this.$$changed = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        FlowLayoutKt.FlowRow(this.$modifier, this.$horizontalArrangement, this.$verticalAlignment, this.$maxItemsInEachRow, this.$content, composer, this.$$changed | 1, this.$$default);
    }
}
