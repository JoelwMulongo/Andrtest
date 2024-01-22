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
final class ChipKt$SelectableChip$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ Function2<Composer, Integer, Unit> $avatar;
    final /* synthetic */ SelectableChipColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ TextStyle $labelTextStyle;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ PaddingValues $paddingValues;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipKt$SelectableChip$2(SelectableChipColors selectableChipColors, boolean z, boolean z2, int i, int i2, Function2<? super Composer, ? super Integer, Unit> function2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, float f, PaddingValues paddingValues) {
        super(2);
        this.$colors = selectableChipColors;
        this.$enabled = z;
        this.$selected = z2;
        this.$$dirty = i;
        this.$$dirty1 = i2;
        this.$label = function2;
        this.$labelTextStyle = textStyle;
        this.$leadingIcon = function22;
        this.$avatar = function23;
        this.$trailingIcon = function24;
        this.$minHeight = f;
        this.$paddingValues = paddingValues;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((Composer) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Composer composer = $composer;
        int i = $changed;
        ComposerKt.sourceInformation(composer, "C1391@69044L29,1393@69160L42,1394@69249L43,1386@68859L527:Chip.kt#uh7d8r");
        if ((i & 11) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-577614814, i, -1, "androidx.compose.material3.SelectableChip.<anonymous> (Chip.kt:1385)");
            }
            SelectableChipColors selectableChipColors = this.$colors;
            boolean z = this.$enabled;
            boolean z2 = this.$selected;
            int i2 = this.$$dirty;
            long r3 = selectableChipColors.labelColor$material3_release(z, z2, composer, ((i2 << 3) & 112) | ((i2 >> 9) & 14) | ((this.$$dirty1 << 6) & 896)).getValue().m3174unboximpl();
            SelectableChipColors selectableChipColors2 = this.$colors;
            boolean z3 = this.$enabled;
            boolean z4 = this.$selected;
            int i3 = this.$$dirty;
            long r8 = selectableChipColors2.leadingIconContentColor$material3_release(z3, z4, composer, ((i3 << 3) & 112) | ((i3 >> 9) & 14) | ((this.$$dirty1 << 6) & 896)).getValue().m3174unboximpl();
            SelectableChipColors selectableChipColors3 = this.$colors;
            boolean z5 = this.$enabled;
            boolean z6 = this.$selected;
            int i4 = this.$$dirty;
            long r10 = selectableChipColors3.trailingIconContentColor$material3_release(z5, z6, composer, ((i4 << 3) & 112) | ((i4 >> 9) & 14) | ((this.$$dirty1 << 6) & 896)).getValue().m3174unboximpl();
            Function2<Composer, Integer, Unit> function2 = this.$label;
            TextStyle textStyle = this.$labelTextStyle;
            Function2<Composer, Integer, Unit> function22 = this.$leadingIcon;
            Function2<Composer, Integer, Unit> function23 = this.$avatar;
            Function2<Composer, Integer, Unit> function24 = this.$trailingIcon;
            float f = this.$minHeight;
            PaddingValues paddingValues = this.$paddingValues;
            int i5 = this.$$dirty;
            int i6 = this.$$dirty1;
            int i7 = (i6 << 15) & 1879048192;
            ChipKt.m1786ChipContentfe0OD_I(function2, textStyle, r3, function22, function23, function24, r8, r10, f, paddingValues, $composer, i7 | ((i5 >> 9) & 458752) | ((i5 >> 12) & 14) | ((i5 >> 12) & 112) | ((i5 >> 9) & 7168) | ((i5 >> 9) & 57344) | ((i6 << 15) & 234881024));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
