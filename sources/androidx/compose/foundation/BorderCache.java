package androidx.compose.foundation;

import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\tHÂ\u0003J9\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0006\u0010\u0015\u001a\u00020\tJ\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001JF\u0010\u0018\u001a\u00020\u0003*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f¢\u0006\u0002\b\"H\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b#\u0010$R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006%"}, d2 = {"Landroidx/compose/foundation/BorderCache;", "", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "borderPath", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;Landroidx/compose/ui/graphics/Path;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "obtainPath", "toString", "", "drawBorderCache", "Landroidx/compose/ui/draw/CacheDrawScope;", "borderSize", "Landroidx/compose/ui/unit/IntSize;", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawBorderCache-EMwLDEs", "(Landroidx/compose/ui/draw/CacheDrawScope;JILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/ImageBitmap;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Border.kt */
final class BorderCache {
    private Path borderPath;
    /* access modifiers changed from: private */
    public Canvas canvas;
    /* access modifiers changed from: private */
    public CanvasDrawScope canvasDrawScope;
    /* access modifiers changed from: private */
    public ImageBitmap imageBitmap;

    public BorderCache() {
        this((ImageBitmap) null, (Canvas) null, (CanvasDrawScope) null, (Path) null, 15, (DefaultConstructorMarker) null);
    }

    private final ImageBitmap component1() {
        return this.imageBitmap;
    }

    private final Canvas component2() {
        return this.canvas;
    }

    private final CanvasDrawScope component3() {
        return this.canvasDrawScope;
    }

    private final Path component4() {
        return this.borderPath;
    }

    public static /* synthetic */ BorderCache copy$default(BorderCache borderCache, ImageBitmap imageBitmap2, Canvas canvas2, CanvasDrawScope canvasDrawScope2, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            imageBitmap2 = borderCache.imageBitmap;
        }
        if ((i & 2) != 0) {
            canvas2 = borderCache.canvas;
        }
        if ((i & 4) != 0) {
            canvasDrawScope2 = borderCache.canvasDrawScope;
        }
        if ((i & 8) != 0) {
            path = borderCache.borderPath;
        }
        return borderCache.copy(imageBitmap2, canvas2, canvasDrawScope2, path);
    }

    public final BorderCache copy(ImageBitmap imageBitmap2, Canvas canvas2, CanvasDrawScope canvasDrawScope2, Path path) {
        return new BorderCache(imageBitmap2, canvas2, canvasDrawScope2, path);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderCache)) {
            return false;
        }
        BorderCache borderCache = (BorderCache) obj;
        return Intrinsics.areEqual((Object) this.imageBitmap, (Object) borderCache.imageBitmap) && Intrinsics.areEqual((Object) this.canvas, (Object) borderCache.canvas) && Intrinsics.areEqual((Object) this.canvasDrawScope, (Object) borderCache.canvasDrawScope) && Intrinsics.areEqual((Object) this.borderPath, (Object) borderCache.borderPath);
    }

    public int hashCode() {
        ImageBitmap imageBitmap2 = this.imageBitmap;
        int i = 0;
        int hashCode = (imageBitmap2 == null ? 0 : imageBitmap2.hashCode()) * 31;
        Canvas canvas2 = this.canvas;
        int hashCode2 = (hashCode + (canvas2 == null ? 0 : canvas2.hashCode())) * 31;
        CanvasDrawScope canvasDrawScope2 = this.canvasDrawScope;
        int hashCode3 = (hashCode2 + (canvasDrawScope2 == null ? 0 : canvasDrawScope2.hashCode())) * 31;
        Path path = this.borderPath;
        if (path != null) {
            i = path.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "BorderCache(imageBitmap=" + this.imageBitmap + ", canvas=" + this.canvas + ", canvasDrawScope=" + this.canvasDrawScope + ", borderPath=" + this.borderPath + ')';
    }

    public BorderCache(ImageBitmap imageBitmap2, Canvas canvas2, CanvasDrawScope canvasDrawScope2, Path borderPath2) {
        this.imageBitmap = imageBitmap2;
        this.canvas = canvas2;
        this.canvasDrawScope = canvasDrawScope2;
        this.borderPath = borderPath2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BorderCache(ImageBitmap imageBitmap2, Canvas canvas2, CanvasDrawScope canvasDrawScope2, Path path, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : imageBitmap2, (i & 2) != 0 ? null : canvas2, (i & 4) != 0 ? null : canvasDrawScope2, (i & 8) != 0 ? null : path);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004b, code lost:
        if (androidx.compose.ui.graphics.ImageBitmapConfig.m3375equalsimpl(r39, r6) != false) goto L_0x0050;
     */
    /* renamed from: drawBorderCache-EMwLDEs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.graphics.ImageBitmap m455drawBorderCacheEMwLDEs(androidx.compose.ui.draw.CacheDrawScope r36, long r37, int r39, kotlin.jvm.functions.Function1<? super androidx.compose.ui.graphics.drawscope.DrawScope, kotlin.Unit> r40) {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            r2 = r40
            java.lang.String r3 = "$this$drawBorderCache"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            r3 = 0
            androidx.compose.ui.graphics.ImageBitmap r4 = r35.imageBitmap
            androidx.compose.ui.graphics.Canvas r5 = r35.canvas
            r6 = 0
            if (r4 == 0) goto L_0x0025
            int r7 = r4.m3372getConfig_sVssgQ()
            androidx.compose.ui.graphics.ImageBitmapConfig r7 = androidx.compose.ui.graphics.ImageBitmapConfig.m3373boximpl(r7)
            goto L_0x0026
        L_0x0025:
            r7 = r6
        L_0x0026:
            androidx.compose.ui.graphics.ImageBitmapConfig$Companion r8 = androidx.compose.ui.graphics.ImageBitmapConfig.Companion
            int r8 = r8.m3381getArgb8888_sVssgQ()
            r9 = 0
            if (r7 != 0) goto L_0x0031
            r7 = r9
            goto L_0x0039
        L_0x0031:
            int r7 = r7.m3379unboximpl()
            boolean r7 = androidx.compose.ui.graphics.ImageBitmapConfig.m3376equalsimpl0(r7, r8)
        L_0x0039:
            if (r7 != 0) goto L_0x004e
            if (r4 == 0) goto L_0x0045
            int r6 = r4.m3372getConfig_sVssgQ()
            androidx.compose.ui.graphics.ImageBitmapConfig r6 = androidx.compose.ui.graphics.ImageBitmapConfig.m3373boximpl(r6)
        L_0x0045:
            r7 = r39
            boolean r6 = androidx.compose.ui.graphics.ImageBitmapConfig.m3375equalsimpl(r7, r6)
            if (r6 == 0) goto L_0x0051
            goto L_0x0050
        L_0x004e:
            r7 = r39
        L_0x0050:
            r9 = 1
        L_0x0051:
            r6 = r9
            if (r4 == 0) goto L_0x007a
            if (r5 == 0) goto L_0x007a
            long r8 = r36.m2824getSizeNHjbRc()
            float r8 = androidx.compose.ui.geometry.Size.m2984getWidthimpl(r8)
            int r9 = r4.getWidth()
            float r9 = (float) r9
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 > 0) goto L_0x007a
            long r8 = r36.m2824getSizeNHjbRc()
            float r8 = androidx.compose.ui.geometry.Size.m2981getHeightimpl(r8)
            int r9 = r4.getHeight()
            float r9 = (float) r9
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 > 0) goto L_0x007a
            if (r6 != 0) goto L_0x00a3
        L_0x007a:
            int r10 = androidx.compose.ui.unit.IntSize.m6146getWidthimpl(r37)
            int r11 = androidx.compose.ui.unit.IntSize.m6145getHeightimpl(r37)
            r13 = 0
            r14 = 0
            r15 = 24
            r16 = 0
            r12 = r39
            androidx.compose.ui.graphics.ImageBitmap r8 = androidx.compose.ui.graphics.ImageBitmapKt.m3386ImageBitmapx__hDU$default(r10, r11, r12, r13, r14, r15, r16)
            r9 = r8
            r10 = 0
            r0.imageBitmap = r9
            r4 = r8
            androidx.compose.ui.graphics.Canvas r8 = androidx.compose.ui.graphics.CanvasKt.Canvas(r4)
            r9 = r8
            r10 = 0
            r0.canvas = r9
            r5 = r8
        L_0x00a3:
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope r8 = r35.canvasDrawScope
            if (r8 != 0) goto L_0x00b3
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope r8 = new androidx.compose.ui.graphics.drawscope.CanvasDrawScope
            r8.<init>()
            r9 = r8
            r10 = 0
            r0.canvasDrawScope = r9
        L_0x00b3:
            long r14 = androidx.compose.ui.unit.IntSizeKt.m6156toSizeozmzZPI(r37)
            androidx.compose.ui.unit.LayoutDirection r9 = r36.getLayoutDirection()
            r12 = r9
            r22 = r8
            r23 = 0
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r9 = r22.getDrawParams()
            androidx.compose.ui.unit.Density r13 = r9.component1()
            androidx.compose.ui.unit.LayoutDirection r10 = r9.component2()
            androidx.compose.ui.graphics.Canvas r11 = r9.component3()
            r16 = r14
            r15 = r13
            long r13 = r9.m3672component4NHjbRc()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r9 = r22.getDrawParams()
            r18 = 0
            r0 = r1
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            r9.setDensity(r0)
            r9.setLayoutDirection(r12)
            r9.setCanvas(r5)
            r0 = r12
            r19 = r13
            r12 = r16
            r9.m3675setSizeuvyYCjk(r12)
            r5.save()
            r14 = r22
            androidx.compose.ui.graphics.drawscope.DrawScope r14 = (androidx.compose.ui.graphics.drawscope.DrawScope) r14
            r24 = 0
            androidx.compose.ui.graphics.Color$Companion r9 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r9.m3190getBlack0d7_KjU()
            r25 = 0
            r18 = 0
            r21 = 0
            r27 = 0
            androidx.compose.ui.graphics.BlendMode$Companion r9 = androidx.compose.ui.graphics.BlendMode.Companion
            int r28 = r9.m3070getClear0nO6VwU()
            r29 = 58
            r30 = 0
            r9 = r14
            r31 = r0
            r0 = r10
            r1 = r11
            r10 = r16
            r32 = r3
            r33 = r6
            r3 = r15
            r6 = r19
            r15 = r12
            r12 = r25
            r34 = r14
            r25 = r15
            r14 = r25
            r16 = r18
            r17 = r21
            r18 = r27
            r19 = r28
            r20 = r29
            r21 = r30
            androidx.compose.ui.graphics.drawscope.DrawScope.m3748drawRectnJ9OG0$default(r9, r10, r12, r14, r16, r17, r18, r19, r20, r21)
            r9 = r34
            r2.invoke(r9)
            r5.restore()
            androidx.compose.ui.graphics.drawscope.CanvasDrawScope$DrawParams r9 = r22.getDrawParams()
            r10 = 0
            r9.setDensity(r3)
            r9.setLayoutDirection(r0)
            r9.setCanvas(r1)
            r9.m3675setSizeuvyYCjk(r6)
            r4.prepareToDraw()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BorderCache.m455drawBorderCacheEMwLDEs(androidx.compose.ui.draw.CacheDrawScope, long, int, kotlin.jvm.functions.Function1):androidx.compose.ui.graphics.ImageBitmap");
    }

    public final Path obtainPath() {
        Path path = this.borderPath;
        if (path != null) {
            return path;
        }
        Path it = AndroidPath_androidKt.Path();
        this.borderPath = it;
        return it;
    }
}
