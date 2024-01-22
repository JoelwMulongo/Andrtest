package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\t\u001a8\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001aR\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\u0002\b\u0011H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0005H\u0000\u001a \u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002\u001a\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000\u001a$\u0010\u001f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"DefaultSelectionHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "handlesCrossed", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZLandroidx/compose/runtime/Composer;I)V", "HandlePopup", "position", "Landroidx/compose/ui/geometry/Offset;", "handleReferencePoint", "Landroidx/compose/foundation/text/selection/HandleReferencePoint;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "HandlePopup-ULxng0E", "(JLandroidx/compose/foundation/text/selection/HandleReferencePoint;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionHandle", "SelectionHandle-8fL75-g", "(JZLandroidx/compose/ui/text/style/ResolvedTextDirection;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "isHandleLtrDirection", "areHandlesCrossed", "isLeft", "createHandleImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/draw/CacheDrawScope;", "radius", "", "drawSelectionHandle", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
public final class AndroidSelectionHandles_androidKt {
    /* renamed from: SelectionHandle-8fL75-g  reason: not valid java name */
    public static final void m1242SelectionHandle8fL75g(long position, boolean isStartHandle, ResolvedTextDirection direction, boolean handlesCrossed, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Composer $composer2;
        HandleReferencePoint handleReferencePoint;
        ResolvedTextDirection resolvedTextDirection = direction;
        Modifier modifier2 = modifier;
        int i = $changed;
        Intrinsics.checkNotNullParameter(resolvedTextDirection, "direction");
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Composer $composer3 = $composer.startRestartGroup(-616295642);
        ComposerKt.sourceInformation($composer3, "C(SelectionHandle)P(5:c#ui.geometry.Offset,3,1,2,4)69@2795L823:AndroidSelectionHandles.android.kt#eksfi3");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer3.changed(position) ? 4 : 2;
        } else {
            long j = position;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer3.changed(isStartHandle) ? 32 : 16;
        } else {
            boolean z = isStartHandle;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer3.changed((Object) resolvedTextDirection) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer3.changed(handlesCrossed) ? 2048 : 1024;
        } else {
            boolean z2 = handlesCrossed;
        }
        if ((57344 & i) == 0) {
            $dirty |= $composer3.changed((Object) modifier2) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            $dirty |= $composer3.changedInstance(content) ? 131072 : 65536;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function2 = content;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-616295642, $dirty2, -1, "androidx.compose.foundation.text.selection.SelectionHandle (AndroidSelectionHandles.android.kt:53)");
            }
            if (isLeft(isStartHandle, direction, handlesCrossed)) {
                handleReferencePoint = HandleReferencePoint.TopRight;
            } else {
                handleReferencePoint = HandleReferencePoint.TopLeft;
            }
            int $dirty3 = $dirty2;
            AndroidSelectionHandles_androidKt$SelectionHandle$1 androidSelectionHandles_androidKt$SelectionHandle$1 = r0;
            AndroidSelectionHandles_androidKt$SelectionHandle$1 androidSelectionHandles_androidKt$SelectionHandle$12 = new AndroidSelectionHandles_androidKt$SelectionHandle$1(content, modifier, isStartHandle, position, $dirty3, direction, handlesCrossed);
            $composer2 = $composer3;
            m1241HandlePopupULxng0E(position, handleReferencePoint, ComposableLambdaKt.composableLambda($composer3, 732099485, true, androidSelectionHandles_androidKt$SelectionHandle$1), $composer2, ($dirty3 & 14) | 384);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            int i2 = $dirty2;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidSelectionHandles_androidKt$SelectionHandle$2(position, isStartHandle, direction, handlesCrossed, modifier, content, $changed));
        }
    }

    public static final void DefaultSelectionHandle(Modifier modifier, boolean isStartHandle, ResolvedTextDirection direction, boolean handlesCrossed, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Composer $composer2 = $composer.startRestartGroup(47957398);
        ComposerKt.sourceInformation($composer2, "C(DefaultSelectionHandle)P(3,2)101@3820L137:AndroidSelectionHandles.android.kt#eksfi3");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(isStartHandle) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed((Object) direction) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(handlesCrossed) ? 2048 : 1024;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(47957398, $changed, -1, "androidx.compose.foundation.text.selection.DefaultSelectionHandle (AndroidSelectionHandles.android.kt:95)");
            }
            SpacerKt.Spacer(drawSelectionHandle(SizeKt.m832sizeVpY3zN4(modifier, SelectionHandlesKt.getHandleWidth(), SelectionHandlesKt.getHandleHeight()), isStartHandle, direction, handlesCrossed), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AndroidSelectionHandles_androidKt$DefaultSelectionHandle$1(modifier, isStartHandle, direction, handlesCrossed, $changed));
        }
    }

    public static final Modifier drawSelectionHandle(Modifier $this$drawSelectionHandle, boolean isStartHandle, ResolvedTextDirection direction, boolean handlesCrossed) {
        Intrinsics.checkNotNullParameter($this$drawSelectionHandle, "<this>");
        Intrinsics.checkNotNullParameter(direction, "direction");
        return ComposedModifierKt.composed$default($this$drawSelectionHandle, (Function1) null, new AndroidSelectionHandles_androidKt$drawSelectionHandle$1(isStartHandle, direction, handlesCrossed), 1, (Object) null);
    }

    public static final ImageBitmap createHandleImage(CacheDrawScope $this$createHandleImage, float radius) {
        ImageBitmap imageBitmap;
        Canvas canvas;
        CanvasDrawScope drawScope;
        CacheDrawScope cacheDrawScope = $this$createHandleImage;
        float f = radius;
        Intrinsics.checkNotNullParameter(cacheDrawScope, "<this>");
        int edge = ((int) ((float) Math.ceil((double) f))) * 2;
        ImageBitmap imageBitmap2 = HandleImageCache.INSTANCE.getImageBitmap();
        Canvas canvas2 = HandleImageCache.INSTANCE.getCanvas();
        CanvasDrawScope drawScope2 = HandleImageCache.INSTANCE.getCanvasDrawScope();
        if (imageBitmap2 == null || canvas2 == null || edge > imageBitmap2.getWidth() || edge > imageBitmap2.getHeight()) {
            ImageBitmap imageBitmap3 = ImageBitmapKt.m3386ImageBitmapx__hDU$default(edge, edge, ImageBitmapConfig.Companion.m3380getAlpha8_sVssgQ(), false, (ColorSpace) null, 24, (Object) null);
            HandleImageCache.INSTANCE.setImageBitmap(imageBitmap3);
            Canvas canvas3 = CanvasKt.Canvas(imageBitmap3);
            HandleImageCache.INSTANCE.setCanvas(canvas3);
            imageBitmap = imageBitmap3;
            canvas = canvas3;
        } else {
            imageBitmap = imageBitmap2;
            canvas = canvas2;
        }
        if (drawScope2 == null) {
            CanvasDrawScope drawScope3 = new CanvasDrawScope();
            HandleImageCache.INSTANCE.setCanvasDrawScope(drawScope3);
            drawScope = drawScope3;
        } else {
            drawScope = drawScope2;
        }
        LayoutDirection layoutDirection = $this$createHandleImage.getLayoutDirection();
        CanvasDrawScope this_$iv = drawScope;
        long size$iv = androidx.compose.ui.geometry.SizeKt.Size((float) imageBitmap.getWidth(), (float) imageBitmap.getHeight());
        LayoutDirection layoutDirection$iv = layoutDirection;
        CanvasDrawScope.DrawParams drawParams = this_$iv.getDrawParams();
        Density prevDensity$iv = drawParams.component1();
        LayoutDirection prevLayoutDirection$iv = drawParams.component2();
        Canvas prevCanvas$iv = drawParams.component3();
        long prevSize$iv = drawParams.m3672component4NHjbRc();
        CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u240$iv = this_$iv.getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u240$iv.setDensity(cacheDrawScope);
        $this$draw_yzxVdVo_u24lambda_u240$iv.setLayoutDirection(layoutDirection$iv);
        $this$draw_yzxVdVo_u24lambda_u240$iv.setCanvas(canvas);
        $this$draw_yzxVdVo_u24lambda_u240$iv.m3675setSizeuvyYCjk(size$iv);
        canvas.save();
        DrawScope $this$createHandleImage_u24lambda_u240 = this_$iv;
        DrawScope drawScope4 = $this$createHandleImage_u24lambda_u240;
        DrawScope.m3748drawRectnJ9OG0$default(drawScope4, Color.Companion.m3190getBlack0d7_KjU(), 0, $this$createHandleImage_u24lambda_u240.m3772getSizeNHjbRc(), 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.m3070getClear0nO6VwU(), 58, (Object) null);
        DrawScope.m3748drawRectnJ9OG0$default(drawScope4, ColorKt.Color(4278190080L), Offset.Companion.m2931getZeroF1C5BW0(), androidx.compose.ui.geometry.SizeKt.Size(f, f), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
        LayoutDirection layoutDirection2 = layoutDirection$iv;
        long j = size$iv;
        DrawScope.m3735drawCircleVaOC9Bg$default($this$createHandleImage_u24lambda_u240, ColorKt.Color(4278190080L), radius, OffsetKt.Offset(f, f), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
        canvas.restore();
        CanvasDrawScope.DrawParams $this$draw_yzxVdVo_u24lambda_u241$iv = this_$iv.getDrawParams();
        $this$draw_yzxVdVo_u24lambda_u241$iv.setDensity(prevDensity$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.setLayoutDirection(prevLayoutDirection$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.setCanvas(prevCanvas$iv);
        $this$draw_yzxVdVo_u24lambda_u241$iv.m3675setSizeuvyYCjk(prevSize$iv);
        return imageBitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x010b  */
    /* renamed from: HandlePopup-ULxng0E  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1241HandlePopupULxng0E(long r25, androidx.compose.foundation.text.selection.HandleReferencePoint r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, int r30) {
        /*
            r6 = r27
            r14 = r28
            r15 = r30
            java.lang.String r0 = "handleReferencePoint"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -1409050158(0xffffffffac0399d2, float:-1.8701607E-12)
            r1 = r29
            androidx.compose.runtime.Composer r5 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(HandlePopup)P(2:c#ui.geometry.Offset,1)231@8057L113,235@8176L217:AndroidSelectionHandles.android.kt#eksfi3"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r1)
            r1 = r30
            r2 = r15 & 14
            if (r2 != 0) goto L_0x0032
            r3 = r25
            boolean r2 = r5.changed((long) r3)
            if (r2 == 0) goto L_0x002f
            r2 = 4
            goto L_0x0030
        L_0x002f:
            r2 = 2
        L_0x0030:
            r1 = r1 | r2
            goto L_0x0034
        L_0x0032:
            r3 = r25
        L_0x0034:
            r2 = r15 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0044
            boolean r2 = r5.changed((java.lang.Object) r6)
            if (r2 == 0) goto L_0x0041
            r2 = 32
            goto L_0x0043
        L_0x0041:
            r2 = 16
        L_0x0043:
            r1 = r1 | r2
        L_0x0044:
            r2 = r15 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x0054
            boolean r2 = r5.changedInstance(r14)
            if (r2 == 0) goto L_0x0051
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0053
        L_0x0051:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0053:
            r1 = r1 | r2
        L_0x0054:
            r2 = r1 & 731(0x2db, float:1.024E-42)
            r7 = 146(0x92, float:2.05E-43)
            if (r2 != r7) goto L_0x0066
            boolean r2 = r5.getSkipping()
            if (r2 != 0) goto L_0x0061
            goto L_0x0066
        L_0x0061:
            r5.skipToGroupEnd()
            goto L_0x010e
        L_0x0066:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0072
            r2 = -1
            java.lang.String r7 = "androidx.compose.foundation.text.selection.HandlePopup (AndroidSelectionHandles.android.kt:224)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r7)
        L_0x0072:
            float r0 = androidx.compose.ui.geometry.Offset.m2915getXimpl(r25)
            int r0 = kotlin.math.MathKt.roundToInt((float) r0)
            float r2 = androidx.compose.ui.geometry.Offset.m2916getYimpl(r25)
            int r2 = kotlin.math.MathKt.roundToInt((float) r2)
            long r12 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r0, r2)
            androidx.compose.ui.unit.IntOffset r0 = androidx.compose.ui.unit.IntOffset.m6095boximpl(r12)
            int r2 = r1 >> 3
            r2 = r2 & 14
            r7 = 0
            r8 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r5.startReplaceableGroup(r8)
            java.lang.String r8 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r5, r8)
            boolean r8 = r5.changed((java.lang.Object) r6)
            boolean r9 = r5.changed((java.lang.Object) r0)
            r8 = r8 | r9
            r9 = r5
            r10 = 0
            java.lang.Object r11 = r9.rememberedValue()
            r16 = 0
            if (r8 != 0) goto L_0x00be
            androidx.compose.runtime.Composer$Companion r17 = androidx.compose.runtime.Composer.Companion
            r29 = r0
            java.lang.Object r0 = r17.getEmpty()
            if (r11 != r0) goto L_0x00ba
            goto L_0x00c0
        L_0x00ba:
            r18 = r2
            r0 = r11
            goto L_0x00d0
        L_0x00be:
            r29 = r0
        L_0x00c0:
            r0 = 0
            r17 = r0
            androidx.compose.foundation.text.selection.HandlePositionProvider r0 = new androidx.compose.foundation.text.selection.HandlePositionProvider
            r18 = r2
            r2 = 0
            r0.<init>(r6, r12, r2)
            r9.updateRememberedValue(r0)
        L_0x00d0:
            r5.endReplaceableGroup()
            androidx.compose.foundation.text.selection.HandlePositionProvider r0 = (androidx.compose.foundation.text.selection.HandlePositionProvider) r0
            r7 = r0
            androidx.compose.ui.window.PopupPositionProvider r7 = (androidx.compose.ui.window.PopupPositionProvider) r7
            r8 = 0
            androidx.compose.ui.window.PopupProperties r9 = new androidx.compose.ui.window.PopupProperties
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 1
            r22 = 0
            r23 = 15
            r24 = 0
            r16 = r9
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)
            int r2 = r1 << 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | 384(0x180, float:5.38E-43)
            r16 = 2
            r10 = r28
            r11 = r5
            r17 = r12
            r12 = r2
            r13 = r16
            androidx.compose.ui.window.AndroidPopup_androidKt.Popup(r7, r8, r9, r10, r11, r12, r13)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x010e
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x010e:
            androidx.compose.runtime.ScopeUpdateScope r7 = r5.endRestartGroup()
            if (r7 != 0) goto L_0x0117
            r9 = r1
            r10 = r5
            goto L_0x012c
        L_0x0117:
            androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$HandlePopup$1 r8 = new androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$HandlePopup$1
            r0 = r8
            r9 = r1
            r1 = r25
            r3 = r27
            r4 = r28
            r10 = r5
            r5 = r30
            r0.<init>(r1, r3, r4, r5)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r7.updateScope(r8)
        L_0x012c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.m1241HandlePopupULxng0E(long, androidx.compose.foundation.text.selection.HandleReferencePoint, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    public static final boolean isLeft(boolean isStartHandle, ResolvedTextDirection direction, boolean handlesCrossed) {
        if (isStartHandle) {
            return isHandleLtrDirection(direction, handlesCrossed);
        }
        return !isHandleLtrDirection(direction, handlesCrossed);
    }

    public static final boolean isHandleLtrDirection(ResolvedTextDirection direction, boolean areHandlesCrossed) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        return (direction == ResolvedTextDirection.Ltr && !areHandlesCrossed) || (direction == ResolvedTextDirection.Rtl && areHandlesCrossed);
    }
}
