package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicMarquee.kt */
final class BasicMarqueeKt$basicMarquee$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ int $animationMode;
    final /* synthetic */ int $delayMillis;
    final /* synthetic */ int $initialDelayMillis;
    final /* synthetic */ int $iterations;
    final /* synthetic */ MarqueeSpacing $spacing;
    final /* synthetic */ float $velocity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicMarqueeKt$basicMarquee$2(int i, int i2, int i3, float f, MarqueeSpacing marqueeSpacing, int i4) {
        super(3);
        this.$iterations = i;
        this.$delayMillis = i2;
        this.$initialDelayMillis = i3;
        this.$velocity = f;
        this.$spacing = marqueeSpacing;
        this.$animationMode = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        String str;
        Object value$iv$iv;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        composer.startReplaceableGroup(-562302205);
        ComposerKt.sourceInformation(composer, "C151@7528L7,152@7583L7,153@7610L421,172@8136L39,172@8111L64:BasicMarquee.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-562302205, $changed, -1, "androidx.compose.foundation.basicMarquee.<anonymous> (BasicMarquee.kt:150)");
        } else {
            int i = $changed;
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalDensity());
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd($composer);
        LayoutDirection layoutDirection = (LayoutDirection) consume2;
        Object[] keys$iv = {Integer.valueOf(this.$iterations), Integer.valueOf(this.$delayMillis), Integer.valueOf(this.$initialDelayMillis), Dp.m5984boximpl(this.$velocity), density, layoutDirection};
        int i2 = this.$iterations;
        int i3 = this.$delayMillis;
        int i4 = this.$initialDelayMillis;
        float f = this.$velocity;
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        int length = keys$iv.length;
        boolean invalid$iv = false;
        int i5 = 0;
        while (i5 < length) {
            invalid$iv |= composer.changed(keys$iv[i5]);
            i5++;
            Modifier modifier = $this$composed;
        }
        Composer $this$cache$iv$iv = $composer;
        Object value$iv$iv2 = $this$cache$iv$iv.rememberedValue();
        if (invalid$iv || value$iv$iv2 == Composer.Companion.getEmpty()) {
            Object obj = value$iv$iv2;
            float r14 = Dp.m5986constructorimpl(f * (layoutDirection == LayoutDirection.Ltr ? 1.0f : -1.0f));
            str = "CC(remember)P(1):Composables.kt#9igjgp";
            value$iv$iv2 = new MarqueeModifier(i2, i3, i4, r14, density, (DefaultConstructorMarker) null);
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv2);
        } else {
            Object obj2 = value$iv$iv2;
            str = "CC(remember)P(1):Composables.kt#9igjgp";
        }
        $composer.endReplaceableGroup();
        MarqueeModifier modifier2 = (MarqueeModifier) value$iv$iv2;
        modifier2.setSpacing(this.$spacing);
        modifier2.m514setAnimationMode97h66l8(this.$animationMode);
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, str);
        boolean invalid$iv$iv = composer.changed((Object) modifier2);
        Composer $this$cache$iv$iv2 = $composer;
        Object it$iv$iv = $this$cache$iv$iv2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = (Function2) new BasicMarqueeKt$basicMarquee$2$1$1(modifier2, (Continuation<? super BasicMarqueeKt$basicMarquee$2$1$1>) null);
            $this$cache$iv$iv2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect((Object) modifier2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) value$iv$iv, composer, 64);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return modifier2;
    }
}
