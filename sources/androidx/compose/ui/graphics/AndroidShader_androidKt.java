package androidx.compose.ui.graphics;

import android.graphics.BitmapShader;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001aO\u0010\n\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001aO\u0010\u0016\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a?\u0010\u001b\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u001e\u001a\u00020\u001f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0001ø\u0001\u0001\u001a!\u0010 \u001a\u00020!2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\"\u001a\u00020\u001fH\u0001ø\u0001\u0001\u001a3\u0010#\u001a\u0004\u0018\u00010$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\"\u001a\u00020\u001fH\u0001ø\u0001\u0001\u001a)\u0010&\u001a\u00020'2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fH\u0002ø\u0001\u0001*\n\u0010(\"\u00020\u00012\u00020\u0001\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, d2 = {"ActualImageShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "tileModeX", "Landroidx/compose/ui/graphics/TileMode;", "tileModeY", "ActualImageShader-F49vj9s", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroid/graphics/Shader;", "ActualLinearGradientShader", "from", "Landroidx/compose/ui/geometry/Offset;", "to", "colors", "", "Landroidx/compose/ui/graphics/Color;", "colorStops", "", "tileMode", "ActualLinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualRadialGradientShader", "center", "radius", "ActualRadialGradientShader-8uybcMk", "(JFLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualSweepGradientShader", "ActualSweepGradientShader-9KIMszo", "(JLjava/util/List;Ljava/util/List;)Landroid/graphics/Shader;", "countTransparentColors", "", "makeTransparentColors", "", "numTransparentColors", "makeTransparentStops", "", "stops", "validateColorStops", "", "Shader", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidShader.android.kt */
public final class AndroidShader_androidKt {
    /* renamed from: ActualLinearGradientShader-VjE6UOU  reason: not valid java name */
    public static final Shader m3056ActualLinearGradientShaderVjE6UOU(long from, long to, List<Color> colors, List<Float> colorStops, int tileMode) {
        List<Color> list = colors;
        Intrinsics.checkNotNullParameter(list, "colors");
        validateColorStops(colors, colorStops);
        int numTransparentColors = countTransparentColors(colors);
        return new LinearGradient(Offset.m2915getXimpl(from), Offset.m2916getYimpl(from), Offset.m2915getXimpl(to), Offset.m2916getYimpl(to), makeTransparentColors(list, numTransparentColors), makeTransparentStops(colorStops, list, numTransparentColors), AndroidTileMode_androidKt.m3060toAndroidTileMode0vamqd0(tileMode));
    }

    /* renamed from: ActualRadialGradientShader-8uybcMk  reason: not valid java name */
    public static final Shader m3057ActualRadialGradientShader8uybcMk(long center, float radius, List<Color> colors, List<Float> colorStops, int tileMode) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        validateColorStops(colors, colorStops);
        int numTransparentColors = countTransparentColors(colors);
        return new RadialGradient(Offset.m2915getXimpl(center), Offset.m2916getYimpl(center), radius, makeTransparentColors(colors, numTransparentColors), makeTransparentStops(colorStops, colors, numTransparentColors), AndroidTileMode_androidKt.m3060toAndroidTileMode0vamqd0(tileMode));
    }

    /* renamed from: ActualSweepGradientShader-9KIMszo  reason: not valid java name */
    public static final Shader m3058ActualSweepGradientShader9KIMszo(long center, List<Color> colors, List<Float> colorStops) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        validateColorStops(colors, colorStops);
        int numTransparentColors = countTransparentColors(colors);
        return new SweepGradient(Offset.m2915getXimpl(center), Offset.m2916getYimpl(center), makeTransparentColors(colors, numTransparentColors), makeTransparentStops(colorStops, colors, numTransparentColors));
    }

    /* renamed from: ActualImageShader-F49vj9s  reason: not valid java name */
    public static final Shader m3055ActualImageShaderF49vj9s(ImageBitmap image, int tileModeX, int tileModeY) {
        Intrinsics.checkNotNullParameter(image, "image");
        return new BitmapShader(AndroidImageBitmap_androidKt.asAndroidBitmap(image), AndroidTileMode_androidKt.m3060toAndroidTileMode0vamqd0(tileModeX), AndroidTileMode_androidKt.m3060toAndroidTileMode0vamqd0(tileModeY));
    }

    public static final int countTransparentColors(List<Color> colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        return 0;
    }

    public static final int[] makeTransparentColors(List<Color> colors, int numTransparentColors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        int size = colors.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ColorKt.m3218toArgb8_81llA(colors.get(i).m3174unboximpl());
        }
        return iArr;
    }

    public static final float[] makeTransparentStops(List<Float> stops, List<Color> colors, int numTransparentColors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        if (numTransparentColors != 0) {
            float[] newStops = new float[(colors.size() + numTransparentColors)];
            newStops[0] = stops != null ? stops.get(0).floatValue() : 0.0f;
            int newStopsIndex = 1;
            int lastIndex = CollectionsKt.getLastIndex(colors);
            for (int i = 1; i < lastIndex; i++) {
                long color = colors.get(i).m3174unboximpl();
                float stop = stops != null ? stops.get(i).floatValue() : ((float) i) / ((float) CollectionsKt.getLastIndex(colors));
                int newStopsIndex2 = newStopsIndex + 1;
                newStops[newStopsIndex] = stop;
                if (Color.m3166getAlphaimpl(color) == 0.0f) {
                    newStopsIndex = newStopsIndex2 + 1;
                    newStops[newStopsIndex2] = stop;
                } else {
                    newStopsIndex = newStopsIndex2;
                }
            }
            newStops[newStopsIndex] = stops != null ? stops.get(CollectionsKt.getLastIndex(colors)).floatValue() : 1.0f;
            return newStops;
        } else if (stops != null) {
            return CollectionsKt.toFloatArray(stops);
        } else {
            return null;
        }
    }

    private static final void validateColorStops(List<Color> colors, List<Float> colorStops) {
        if (colorStops == null) {
            if (colors.size() < 2) {
                throw new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
            }
        } else if (colors.size() != colorStops.size()) {
            throw new IllegalArgumentException("colors and colorStops arguments must have equal length.");
        }
    }
}
