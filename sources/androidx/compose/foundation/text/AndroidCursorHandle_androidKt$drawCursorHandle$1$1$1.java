package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidCursorHandle.android.kt */
final class AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1 extends Lambda implements Function1<CacheDrawScope, DrawResult> {
    final /* synthetic */ long $handleColor;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1(long j) {
        super(1);
        this.$handleColor = j;
    }

    public final DrawResult invoke(CacheDrawScope $this$drawWithCache) {
        Intrinsics.checkNotNullParameter($this$drawWithCache, "$this$drawWithCache");
        final float radius = Size.m2984getWidthimpl($this$drawWithCache.m2824getSizeNHjbRc()) / 2.0f;
        final ImageBitmap imageBitmap = AndroidSelectionHandles_androidKt.createHandleImage($this$drawWithCache, radius);
        final ColorFilter colorFilter = ColorFilter.Companion.m3205tintxETnrds$default(ColorFilter.Companion, this.$handleColor, 0, 2, (Object) null);
        return $this$drawWithCache.onDrawWithContent(new Function1<ContentDrawScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((ContentDrawScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(ContentDrawScope $this$onDrawWithContent) {
                ContentDrawScope contentDrawScope = $this$onDrawWithContent;
                Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
                $this$onDrawWithContent.drawContent();
                DrawScope $this$withTransform$iv = contentDrawScope;
                float f = radius;
                ImageBitmap imageBitmap = imageBitmap;
                ColorFilter colorFilter = colorFilter;
                DrawContext $this$withTransform_u24lambda_u246$iv = $this$withTransform$iv.getDrawContext();
                long previousSize$iv = $this$withTransform_u24lambda_u246$iv.m3715getSizeNHjbRc();
                $this$withTransform_u24lambda_u246$iv.getCanvas().save();
                DrawTransform $this$invoke_u24lambda_u240 = $this$withTransform_u24lambda_u246$iv.getTransform();
                DrawTransform.translate$default($this$invoke_u24lambda_u240, f, 0.0f, 2, (Object) null);
                $this$invoke_u24lambda_u240.m3830rotateUv8p0NA(45.0f, Offset.Companion.m2931getZeroF1C5BW0());
                DrawScope.m3738drawImagegbVJVH8$default($this$withTransform$iv, imageBitmap, 0, 0.0f, (DrawStyle) null, colorFilter, 0, 46, (Object) null);
                $this$withTransform_u24lambda_u246$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u246$iv.m3716setSizeuvyYCjk(previousSize$iv);
            }
        });
    }
}
