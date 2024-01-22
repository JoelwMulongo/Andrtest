package androidx.compose.foundation.text.selection;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
final class AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1 extends Lambda implements Function1<CacheDrawScope, DrawResult> {
    final /* synthetic */ ResolvedTextDirection $direction;
    final /* synthetic */ long $handleColor;
    final /* synthetic */ boolean $handlesCrossed;
    final /* synthetic */ boolean $isStartHandle;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1(long j, boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2) {
        super(1);
        this.$handleColor = j;
        this.$isStartHandle = z;
        this.$direction = resolvedTextDirection;
        this.$handlesCrossed = z2;
    }

    public final DrawResult invoke(CacheDrawScope $this$drawWithCache) {
        Intrinsics.checkNotNullParameter($this$drawWithCache, "$this$drawWithCache");
        ImageBitmap handleImage = AndroidSelectionHandles_androidKt.createHandleImage($this$drawWithCache, Size.m2984getWidthimpl($this$drawWithCache.m2824getSizeNHjbRc()) / 2.0f);
        ColorFilter colorFilter = ColorFilter.Companion.m3205tintxETnrds$default(ColorFilter.Companion, this.$handleColor, 0, 2, (Object) null);
        final boolean z = this.$isStartHandle;
        final ResolvedTextDirection resolvedTextDirection = this.$direction;
        final boolean z2 = this.$handlesCrossed;
        final ImageBitmap imageBitmap = handleImage;
        final ColorFilter colorFilter2 = colorFilter;
        return $this$drawWithCache.onDrawWithContent(new Function1<ContentDrawScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((ContentDrawScope) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(ContentDrawScope $this$onDrawWithContent) {
                ContentDrawScope contentDrawScope = $this$onDrawWithContent;
                Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
                $this$onDrawWithContent.drawContent();
                if (AndroidSelectionHandles_androidKt.isLeft(z, resolvedTextDirection, z2)) {
                    DrawScope $this$scale_u2dFgt4K4Q_u24default$iv = contentDrawScope;
                    ImageBitmap imageBitmap = imageBitmap;
                    ColorFilter colorFilter = colorFilter2;
                    long pivot$iv = $this$scale_u2dFgt4K4Q_u24default$iv.m3771getCenterF1C5BW0();
                    DrawScope $this$withTransform$iv$iv = $this$scale_u2dFgt4K4Q_u24default$iv;
                    DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform$iv$iv.getDrawContext();
                    long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.m3715getSizeNHjbRc();
                    $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
                    $this$withTransform_u24lambda_u246$iv$iv.getTransform().m3831scale0AR0LA0(-1.0f, 1.0f, pivot$iv);
                    DrawContext $this$withTransform_u24lambda_u246$iv$iv2 = $this$withTransform_u24lambda_u246$iv$iv;
                    long j = pivot$iv;
                    DrawScope.m3738drawImagegbVJVH8$default($this$withTransform$iv$iv, imageBitmap, 0, 0.0f, (DrawStyle) null, colorFilter, 0, 46, (Object) null);
                    $this$withTransform_u24lambda_u246$iv$iv2.getCanvas().restore();
                    $this$withTransform_u24lambda_u246$iv$iv2.m3716setSizeuvyYCjk(previousSize$iv$iv);
                    return;
                }
                DrawScope.m3738drawImagegbVJVH8$default(contentDrawScope, imageBitmap, 0, 0.0f, (DrawStyle) null, colorFilter2, 0, 46, (Object) null);
            }
        });
    }
}
