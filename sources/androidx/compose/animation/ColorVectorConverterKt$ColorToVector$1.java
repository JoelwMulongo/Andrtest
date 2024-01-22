package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/TwoWayConverter;", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/animation/core/AnimationVector4D;", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ColorVectorConverter.kt */
final class ColorVectorConverterKt$ColorToVector$1 extends Lambda implements Function1<ColorSpace, TwoWayConverter<Color, AnimationVector4D>> {
    public static final ColorVectorConverterKt$ColorToVector$1 INSTANCE = new ColorVectorConverterKt$ColorToVector$1();

    ColorVectorConverterKt$ColorToVector$1() {
        super(1);
    }

    public final TwoWayConverter<Color, AnimationVector4D> invoke(final ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        return VectorConvertersKt.TwoWayConverter(AnonymousClass1.INSTANCE, new Function1<AnimationVector4D, Color>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return Color.m3154boximpl(m335invokevNxB06k((AnimationVector4D) p1));
            }

            /* renamed from: invoke-vNxB06k  reason: not valid java name */
            public final long m335invokevNxB06k(AnimationVector4D it) {
                Intrinsics.checkNotNullParameter(it, "it");
                double d = (double) 3.0f;
                float l = (float) Math.pow((double) it.getV2(), d);
                float a = (float) Math.pow((double) it.getV3(), d);
                float b = (float) Math.pow((double) it.getV4(), d);
                float x = ColorVectorConverterKt.multiplyColumn(0, l, a, b, ColorVectorConverterKt.InverseM1);
                float y = ColorVectorConverterKt.multiplyColumn(1, l, a, b, ColorVectorConverterKt.InverseM1);
                float z = ColorVectorConverterKt.multiplyColumn(2, l, a, b, ColorVectorConverterKt.InverseM1);
                return Color.m3161convertvNxB06k(ColorKt.Color(RangesKt.coerceIn(x, -2.0f, 2.0f), RangesKt.coerceIn(y, -2.0f, 2.0f), RangesKt.coerceIn(z, -2.0f, 2.0f), RangesKt.coerceIn(it.getV1(), 0.0f, 1.0f), ColorSpaces.INSTANCE.getCieXyz()), colorSpace);
            }
        });
    }
}
