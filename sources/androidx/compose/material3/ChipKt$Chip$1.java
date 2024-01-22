package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Chip.kt */
final class ChipKt$Chip$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ ChipColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ long $labelColor;
    final /* synthetic */ TextStyle $labelTextStyle;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ PaddingValues $paddingValues;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipKt$Chip$1(Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, long j, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, ChipColors chipColors, boolean z, int i, float f, PaddingValues paddingValues, int i2) {
        super(2);
        this.$label = function2;
        this.$labelTextStyle = textStyle;
        this.$labelColor = j;
        this.$leadingIcon = function22;
        this.$trailingIcon = function23;
        this.$colors = chipColors;
        this.$enabled = z;
        this.$$dirty = i;
        this.$minHeight = f;
        this.$paddingValues = paddingValues;
        this.$$dirty1 = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C1343@67435L32,1344@67514L33,1336@67168L473:Chip.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1985962652, i, -1, "androidx.compose.material3.Chip.<anonymous> (Chip.kt:1335)");
            }
            Function2<Composer, Integer, Unit> function2 = this.$label;
            TextStyle textStyle = this.$labelTextStyle;
            long j = this.$labelColor;
            Function2<Composer, Integer, Unit> function22 = this.$leadingIcon;
            Function2<Composer, Integer, Unit> function23 = this.$trailingIcon;
            ChipColors chipColors = this.$colors;
            boolean z = this.$enabled;
            int i2 = this.$$dirty;
            long r8 = chipColors.leadingIconContentColor$material3_release(z, composer, ((i2 >> 24) & 112) | ((i2 >> 6) & 14)).getValue().m3174unboximpl();
            ChipColors chipColors2 = this.$colors;
            boolean z2 = this.$enabled;
            int i3 = this.$$dirty;
            long r10 = chipColors2.trailingIconContentColor$material3_release(z2, composer, ((i3 >> 24) & 112) | ((i3 >> 6) & 14)).getValue().m3174unboximpl();
            float f = this.$minHeight;
            PaddingValues paddingValues = this.$paddingValues;
            int i4 = this.$$dirty;
            int i5 = this.$$dirty1;
            ChipKt.m1786ChipContentfe0OD_I(function2, textStyle, j, function22, (Function2<? super Composer, ? super Integer, Unit>) null, function23, r8, r10, f, paddingValues, $composer, ((i4 >> 6) & 458752) | ((i4 >> 9) & 14) | 24576 | ((i4 >> 9) & 112) | ((i4 >> 9) & 896) | ((i4 >> 9) & 7168) | ((i5 << 18) & 234881024) | ((i5 << 18) & 1879048192));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
