package androidx.compose.material3;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSliderImpl$1$3 extends Lambda implements Function3<BoxScope, Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ String $endContentDescription;
    final /* synthetic */ MutableInteractionSource $endInteractionSource;
    final /* synthetic */ Modifier $endThumbSemantics;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSliderImpl$1$3(String str, MutableInteractionSource mutableInteractionSource, Modifier modifier, SliderColors sliderColors, boolean z, int i) {
        super(3);
        this.$endContentDescription = str;
        this.$endInteractionSource = mutableInteractionSource;
        this.$endThumbSemantics = modifier;
        this.$colors = sliderColors;
        this.$enabled = z;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((BoxScope) p1, (Composer) p2, ((Number) p3).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(BoxScope $this$TempRangeSliderThumb, Composer $composer, int $changed) {
        Object key1$iv;
        Composer composer = $composer;
        int i = $changed;
        Intrinsics.checkNotNullParameter($this$TempRangeSliderThumb, "$this$TempRangeSliderThumb");
        ComposerKt.sourceInformation(composer, "C571@25086L98,569@24979L473:Slider.kt#uh7d8r");
        if ((i & 81) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1141545019, i, -1, "androidx.compose.material3.RangeSliderImpl.<anonymous>.<anonymous> (Slider.kt:568)");
            }
            SliderDefaults sliderDefaults = SliderDefaults.INSTANCE;
            Modifier modifier = Modifier.Companion;
            String str = this.$endContentDescription;
            String str2 = this.$endContentDescription;
            composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = composer.changed((Object) str);
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
                String str3 = str;
                key1$iv = (Function1) new SliderKt$RangeSliderImpl$1$3$1$1(str2);
                $this$cache$iv$iv.updateRememberedValue(key1$iv);
            } else {
                String str4 = str;
                key1$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            Modifier then = FocusableKt.focusable(SemanticsModifierKt.semantics(modifier, true, (Function1) key1$iv), true, this.$endInteractionSource).then(this.$endThumbSemantics);
            MutableInteractionSource mutableInteractionSource = this.$endInteractionSource;
            SliderColors sliderColors = this.$colors;
            boolean z = this.$enabled;
            int i2 = this.$$dirty;
            sliderDefaults.m2054Thumb9LiSoMs(mutableInteractionSource, then, sliderColors, z, 0, $composer, ((i2 >> 21) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i2 >> 6) & 896) | ((i2 << 9) & 7168), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }
}
