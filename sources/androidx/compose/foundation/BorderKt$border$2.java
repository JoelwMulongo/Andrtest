package androidx.compose.foundation;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Border.kt */
final class BorderKt$border$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Brush $brush;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ float $width;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BorderKt$border$2(float f, Shape shape, Brush brush) {
        super(3);
        this.$width = f;
        this.$shape = shape;
        this.$brush = brush;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        return invoke((Modifier) p1, (Composer) p2, ((Number) p3).intValue());
    }

    public final Modifier invoke(Modifier $this$composed, Composer $composer, int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        $composer.startReplaceableGroup(-1498088849);
        ComposerKt.sourceInformation($composer, "C97@4024L31:Border.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1498088849, $changed, -1, "androidx.compose.foundation.border.<anonymous> (Border.kt:93)");
        }
        $composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
        Composer $this$cache$iv$iv = $composer;
        Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            value$iv$iv = new Ref();
            $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer.endReplaceableGroup();
        final Ref borderCacheRef = (Ref) value$iv$iv;
        final float f = this.$width;
        final Shape shape = this.$shape;
        final Brush brush = this.$brush;
        Modifier then = $this$composed.then(DrawModifierKt.drawWithCache(Modifier.Companion, new Function1<CacheDrawScope, DrawResult>() {
            public final DrawResult invoke(CacheDrawScope $this$drawWithCache) {
                CacheDrawScope cacheDrawScope = $this$drawWithCache;
                Intrinsics.checkNotNullParameter(cacheDrawScope, "$this$drawWithCache");
                if (!(cacheDrawScope.m5967toPx0680j_4(f) >= 0.0f && Size.m2983getMinDimensionimpl($this$drawWithCache.m2824getSizeNHjbRc()) > 0.0f)) {
                    return BorderKt.drawContentWithoutBorder($this$drawWithCache);
                }
                float f = (float) 2;
                float strokeWidthPx = Math.min(Dp.m5991equalsimpl0(f, Dp.Companion.m6004getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil((double) cacheDrawScope.m5967toPx0680j_4(f)), (float) Math.ceil((double) (Size.m2983getMinDimensionimpl($this$drawWithCache.m2824getSizeNHjbRc()) / f)));
                float halfStroke = strokeWidthPx / f;
                long topLeft = OffsetKt.Offset(halfStroke, halfStroke);
                long borderSize = SizeKt.Size(Size.m2984getWidthimpl($this$drawWithCache.m2824getSizeNHjbRc()) - strokeWidthPx, Size.m2981getHeightimpl($this$drawWithCache.m2824getSizeNHjbRc()) - strokeWidthPx);
                boolean fillArea = f * strokeWidthPx > Size.m2983getMinDimensionimpl($this$drawWithCache.m2824getSizeNHjbRc());
                Outline outline = shape.m3518createOutlinePq9zytI($this$drawWithCache.m2824getSizeNHjbRc(), $this$drawWithCache.getLayoutDirection(), cacheDrawScope);
                if (outline instanceof Outline.Generic) {
                    return BorderKt.drawGenericBorder($this$drawWithCache, borderCacheRef, brush, (Outline.Generic) outline, fillArea, strokeWidthPx);
                } else if (outline instanceof Outline.Rounded) {
                    Outline outline2 = outline;
                    float f2 = halfStroke;
                    return BorderKt.m463drawRoundRectBorderSYlcjDY($this$drawWithCache, borderCacheRef, brush, (Outline.Rounded) outline, topLeft, borderSize, fillArea, strokeWidthPx);
                } else {
                    float f3 = halfStroke;
                    if (outline instanceof Outline.Rectangle) {
                        return BorderKt.m462drawRectBorderNsqcLGU($this$drawWithCache, brush, topLeft, borderSize, fillArea, strokeWidthPx);
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
        }));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return then;
    }
}
