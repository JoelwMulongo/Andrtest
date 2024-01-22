package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$TempRangeSliderThumb$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Function3<BoxScope, Composer, Integer, Unit> $content;
    final /* synthetic */ float $offset;
    final /* synthetic */ BoxScope $this_TempRangeSliderThumb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$TempRangeSliderThumb$1(BoxScope boxScope, float f, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$this_TempRangeSliderThumb = boxScope;
        this.$offset = f;
        this.$content = function3;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SliderKt.m2056TempRangeSliderThumbrAjV9yQ(this.$this_TempRangeSliderThumb, this.$offset, this.$content, composer, this.$$changed | 1);
    }
}
