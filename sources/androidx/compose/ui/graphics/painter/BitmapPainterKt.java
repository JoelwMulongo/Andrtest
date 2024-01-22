package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"BitmapPainter", "Landroidx/compose/ui/graphics/painter/BitmapPainter;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "BitmapPainter-QZhYCtY", "(Landroidx/compose/ui/graphics/ImageBitmap;JJI)Landroidx/compose/ui/graphics/painter/BitmapPainter;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BitmapPainter.kt */
public final class BitmapPainterKt {
    /* renamed from: BitmapPainter-QZhYCtY$default  reason: not valid java name */
    public static /* synthetic */ BitmapPainter m3861BitmapPainterQZhYCtY$default(ImageBitmap imageBitmap, long j, long j2, int i, int i2, Object obj) {
        long j3;
        long j4;
        int i3;
        if ((i2 & 2) != 0) {
            j3 = IntOffset.Companion.m6114getZeronOccac();
        } else {
            j3 = j;
        }
        if ((i2 & 4) != 0) {
            j4 = IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight());
        } else {
            j4 = j2;
        }
        if ((i2 & 8) != 0) {
            i3 = FilterQuality.Companion.m3259getLowfv9h1I();
        } else {
            i3 = i;
        }
        return m3860BitmapPainterQZhYCtY(imageBitmap, j3, j4, i3);
    }

    /* renamed from: BitmapPainter-QZhYCtY  reason: not valid java name */
    public static final BitmapPainter m3860BitmapPainterQZhYCtY(ImageBitmap image, long srcOffset, long srcSize, int filterQuality) {
        Intrinsics.checkNotNullParameter(image, "image");
        BitmapPainter $this$BitmapPainter_QZhYCtY_u24lambda_u240 = new BitmapPainter(image, srcOffset, srcSize, (DefaultConstructorMarker) null);
        $this$BitmapPainter_QZhYCtY_u24lambda_u240.m3859setFilterQualityvDHp3xo$ui_graphics_release(filterQuality);
        return $this$BitmapPainter_QZhYCtY_u24lambda_u240;
    }
}
