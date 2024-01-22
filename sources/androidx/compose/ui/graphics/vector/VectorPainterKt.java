package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.vector.VectorProperty;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t\u001a\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192@\u0010\u001a\u001a<\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00030\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001a£\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\"2@\u0010\u001a\u001a<\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00030\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u001a&\u0010%\u001a\u00020\u0003*\u00020&2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00030(¢\u0006\u0002\b)H\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006*"}, d2 = {"RootGroupName", "", "RenderVectorGroup", "", "group", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "configs", "", "Landroidx/compose/ui/graphics/vector/VectorConfig;", "(Landroidx/compose/ui/graphics/vector/VectorGroup;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)V", "rememberVectorPainter", "Landroidx/compose/ui/graphics/vector/VectorPainter;", "image", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/VectorPainter;", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "name", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "content", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "rememberVectorPainter-mlNsNFs", "(FFFFLjava/lang/String;JILkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "autoMirror", "", "rememberVectorPainter-vIP8VLU", "(FFFFLjava/lang/String;JIZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "mirror", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorPainter.kt */
public final class VectorPainterKt {
    public static final String RootGroupName = "VectorRootGroup";

    @Deprecated(message = "Replace rememberVectorPainter graphicsLayer that consumes the auto mirror flag", replaceWith = @ReplaceWith(expression = "rememberVectorPainter(defaultWidth, defaultHeight, viewportWidth, viewportHeight, name, tintColor, tintBlendMode, false, content)", imports = {"androidx.compose.ui.graphics.vector"}))
    /* renamed from: rememberVectorPainter-mlNsNFs  reason: not valid java name */
    public static final VectorPainter m3890rememberVectorPaintermlNsNFs(float defaultWidth, float defaultHeight, float viewportWidth, float viewportHeight, String name, long tintColor, int tintBlendMode, Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        float viewportHeight2;
        long tintColor2;
        int tintBlendMode2;
        Composer composer = $composer;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(-964365210);
        ComposerKt.sourceInformation(composer, "C(rememberVectorPainter)P(2:c#ui.unit.Dp,1:c#ui.unit.Dp,7,6,3,5:c#ui.graphics.Color,4:c#ui.graphics.BlendMode)83@3597L207:VectorPainter.kt#huu6hf");
        float viewportWidth2 = (i & 4) != 0 ? Float.NaN : viewportWidth;
        if ((i & 8) != 0) {
            viewportHeight2 = Float.NaN;
        } else {
            viewportHeight2 = viewportHeight;
        }
        String name2 = (i & 16) != 0 ? RootGroupName : name;
        if ((i & 32) != 0) {
            tintColor2 = Color.Companion.m3200getUnspecified0d7_KjU();
        } else {
            tintColor2 = tintColor;
        }
        if ((i & 64) != 0) {
            tintBlendMode2 = BlendMode.Companion.m3095getSrcIn0nO6VwU();
        } else {
            tintBlendMode2 = tintBlendMode;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-964365210, i2, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:73)");
        }
        VectorPainter r0 = m3891rememberVectorPaintervIP8VLU(defaultWidth, defaultHeight, viewportWidth2, viewportHeight2, name2, tintColor2, tintBlendMode2, false, content, $composer, (i2 & 14) | 12582912 | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2) | ((i2 << 3) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0194  */
    /* renamed from: rememberVectorPainter-vIP8VLU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.graphics.vector.VectorPainter m3891rememberVectorPaintervIP8VLU(float r21, float r22, float r23, float r24, java.lang.String r25, long r26, int r28, boolean r29, kotlin.jvm.functions.Function4<? super java.lang.Float, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r0 = r31
            r1 = r32
            r2 = r33
            java.lang.String r3 = "content"
            r4 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            r3 = 1068590786(0x3fb166c2, float:1.3859484)
            r0.startReplaceableGroup(r3)
            java.lang.String r5 = "C(rememberVectorPainter)P(3:c#ui.unit.Dp,2:c#ui.unit.Dp,8,7,4,6:c#ui.graphics.Color,5:c#ui.graphics.BlendMode)126@5382L7,133@5685L187,*141@5885L28,146@6158L46:VectorPainter.kt#huu6hf"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r5)
            r5 = r2 & 4
            if (r5 == 0) goto L_0x001f
            r5 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x0021
        L_0x001f:
            r5 = r23
        L_0x0021:
            r6 = r2 & 8
            if (r6 == 0) goto L_0x0028
            r6 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x002a
        L_0x0028:
            r6 = r24
        L_0x002a:
            r7 = r2 & 16
            if (r7 == 0) goto L_0x0031
            java.lang.String r7 = "VectorRootGroup"
            goto L_0x0033
        L_0x0031:
            r7 = r25
        L_0x0033:
            r8 = r2 & 32
            if (r8 == 0) goto L_0x003e
            androidx.compose.ui.graphics.Color$Companion r8 = androidx.compose.ui.graphics.Color.Companion
            long r8 = r8.m3200getUnspecified0d7_KjU()
            goto L_0x0040
        L_0x003e:
            r8 = r26
        L_0x0040:
            r10 = r2 & 64
            if (r10 == 0) goto L_0x004b
            androidx.compose.ui.graphics.BlendMode$Companion r10 = androidx.compose.ui.graphics.BlendMode.Companion
            int r10 = r10.m3095getSrcIn0nO6VwU()
            goto L_0x004d
        L_0x004b:
            r10 = r28
        L_0x004d:
            r2 = r2 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x0053
            r2 = 0
            goto L_0x0055
        L_0x0053:
            r2 = r29
        L_0x0055:
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0061
            r11 = -1
            java.lang.String r12 = "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:115)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r11, r12)
        L_0x0061:
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r11 = 6
            r12 = 0
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r14 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r0, r13, r14)
            java.lang.Object r13 = r0.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r31)
            r3 = r13
            androidx.compose.ui.unit.Density r3 = (androidx.compose.ui.unit.Density) r3
            r11 = r3
            r12 = 0
            r13 = r21
            float r11 = r11.m5967toPx0680j_4(r13)
            r12 = r3
            r14 = 0
            r15 = r22
            float r12 = r12.m5967toPx0680j_4(r15)
            boolean r14 = java.lang.Float.isNaN(r5)
            if (r14 == 0) goto L_0x0093
            r14 = r11
            goto L_0x0094
        L_0x0093:
            r14 = r5
        L_0x0094:
            r25 = r14
            boolean r14 = java.lang.Float.isNaN(r6)
            if (r14 == 0) goto L_0x009e
            r14 = r12
            goto L_0x009f
        L_0x009e:
            r14 = r6
        L_0x009f:
            r26 = r14
            androidx.compose.ui.graphics.Color r14 = androidx.compose.ui.graphics.Color.m3154boximpl(r8)
            androidx.compose.ui.graphics.BlendMode r16 = androidx.compose.ui.graphics.BlendMode.m3063boximpl(r10)
            int r17 = r1 >> 15
            r17 = r17 & 14
            int r18 = r1 >> 15
            r18 = r18 & 112(0x70, float:1.57E-43)
            r17 = r17 | r18
            r23 = r16
            r16 = 0
            r33 = r3
            r3 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r0.startReplaceableGroup(r3)
            java.lang.String r3 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r3)
            boolean r3 = r0.changed((java.lang.Object) r14)
            r4 = r23
            boolean r18 = r0.changed((java.lang.Object) r4)
            r3 = r3 | r18
            r23 = r31
            r18 = 0
            r24 = r4
            java.lang.Object r4 = r23.rememberedValue()
            r19 = 0
            if (r3 != 0) goto L_0x00f2
            androidx.compose.runtime.Composer$Companion r20 = androidx.compose.runtime.Composer.Companion
            r27 = r3
            java.lang.Object r3 = r20.getEmpty()
            if (r4 != r3) goto L_0x00eb
            goto L_0x00f4
        L_0x00eb:
            r28 = r4
            r3 = r28
            r4 = r23
            goto L_0x0115
        L_0x00f2:
            r27 = r3
        L_0x00f4:
            r3 = 0
            androidx.compose.ui.graphics.Color$Companion r20 = androidx.compose.ui.graphics.Color.Companion
            r29 = r3
            r28 = r4
            long r3 = r20.m3200getUnspecified0d7_KjU()
            boolean r3 = androidx.compose.ui.graphics.Color.m3165equalsimpl0(r8, r3)
            if (r3 != 0) goto L_0x010c
            androidx.compose.ui.graphics.ColorFilter$Companion r3 = androidx.compose.ui.graphics.ColorFilter.Companion
            androidx.compose.ui.graphics.ColorFilter r3 = r3.m3208tintxETnrds(r8, r10)
            goto L_0x010d
        L_0x010c:
            r3 = 0
        L_0x010d:
            r4 = r23
            r4.updateRememberedValue(r3)
        L_0x0115:
            r31.endReplaceableGroup()
            androidx.compose.ui.graphics.ColorFilter r3 = (androidx.compose.ui.graphics.ColorFilter) r3
            r4 = 0
            r14 = 0
            r23 = r4
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r0.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r4)
            r4 = 0
            r24 = r31
            r16 = 0
            java.lang.Object r0 = r24.rememberedValue()
            r17 = 0
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            r27 = r4
            java.lang.Object r4 = r18.getEmpty()
            if (r0 != r4) goto L_0x0151
            r4 = 0
            androidx.compose.ui.graphics.vector.VectorPainter r18 = new androidx.compose.ui.graphics.vector.VectorPainter
            r18.<init>()
            r4 = r18
            r28 = r0
            r0 = r24
            r0.updateRememberedValue(r4)
            goto L_0x0157
        L_0x0151:
            r28 = r0
            r0 = r24
            r4 = r28
        L_0x0157:
            r31.endReplaceableGroup()
            r0 = r4
            androidx.compose.ui.graphics.vector.VectorPainter r0 = (androidx.compose.ui.graphics.vector.VectorPainter) r0
            r14 = 0
            r16 = r5
            r17 = r6
            long r5 = androidx.compose.ui.geometry.SizeKt.Size(r11, r12)
            r0.m3889setSizeuvyYCjk$ui_release(r5)
            r0.setAutoMirror$ui_release(r2)
            r0.setIntrinsicColorFilter$ui_release(r3)
            int r5 = r1 >> 12
            r5 = r5 & 14
            r6 = 32768(0x8000, float:4.5918E-41)
            r5 = r5 | r6
            int r6 = r1 >> 15
            r6 = r6 & 7168(0x1c00, float:1.0045E-41)
            r5 = r5 | r6
            r23 = r0
            r24 = r7
            r27 = r30
            r28 = r31
            r29 = r5
            r23.RenderVector$ui_release(r24, r25, r26, r27, r28, r29)
            androidx.compose.ui.graphics.vector.VectorPainter r4 = (androidx.compose.ui.graphics.vector.VectorPainter) r4
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0197
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0197:
            r31.endReplaceableGroup()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorPainterKt.m3891rememberVectorPaintervIP8VLU(float, float, float, float, java.lang.String, long, int, boolean, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):androidx.compose.ui.graphics.vector.VectorPainter");
    }

    public static final VectorPainter rememberVectorPainter(ImageVector image, Composer $composer, int $changed) {
        ImageVector imageVector = image;
        Composer composer = $composer;
        Intrinsics.checkNotNullParameter(imageVector, "image");
        composer.startReplaceableGroup(1413834416);
        ComposerKt.sourceInformation(composer, "C(rememberVectorPainter)158@6529L424:VectorPainter.kt#huu6hf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413834416, $changed, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:157)");
        } else {
            int i = $changed;
        }
        VectorPainter r1 = m3891rememberVectorPaintervIP8VLU(image.m3870getDefaultWidthD9Ej5fM(), image.m3869getDefaultHeightD9Ej5fM(), image.getViewportWidth(), image.getViewportHeight(), image.getName(), image.m3872getTintColor0d7_KjU(), image.m3871getTintBlendMode0nO6VwU(), image.getAutoMirror(), ComposableLambdaKt.composableLambda(composer, 1873274766, true, new VectorPainterKt$rememberVectorPainter$3(imageVector)), $composer, 100663296, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return r1;
    }

    private static final void mirror(DrawScope $this$mirror, Function1<? super DrawScope, Unit> block) {
        DrawScope $this$scale_u2dFgt4K4Q_u24default$iv = $this$mirror;
        long pivot$iv = $this$scale_u2dFgt4K4Q_u24default$iv.m3771getCenterF1C5BW0();
        DrawScope $this$withTransform$iv$iv = $this$scale_u2dFgt4K4Q_u24default$iv;
        DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$withTransform$iv$iv.getDrawContext();
        long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.m3715getSizeNHjbRc();
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
        $this$withTransform_u24lambda_u246$iv$iv.getTransform().m3831scale0AR0LA0(-1.0f, 1.0f, pivot$iv);
        block.invoke($this$withTransform$iv$iv);
        $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
        $this$withTransform_u24lambda_u246$iv$iv.m3716setSizeuvyYCjk(previousSize$iv$iv);
    }

    public static final void RenderVectorGroup(VectorGroup group, Map<String, ? extends VectorConfig> configs, Composer $composer, int $changed, int i) {
        Composer $composer2;
        Map configs2;
        Map configs3;
        Map configs4;
        VectorGroup vectorGroup = group;
        int i2 = $changed;
        int i3 = i;
        Intrinsics.checkNotNullParameter(vectorGroup, "group");
        Composer $composer3 = $composer.startRestartGroup(-446179233);
        ComposerKt.sourceInformation($composer3, "C(RenderVectorGroup)P(1):VectorPainter.kt#huu6hf");
        int $dirty = $changed;
        if ((i3 & 1) != 0) {
            $dirty |= 6;
        } else if ((i2 & 14) == 0) {
            $dirty |= $composer3.changed((Object) vectorGroup) ? 4 : 2;
        }
        int i4 = i3 & 2;
        if (i4 != 0) {
            $dirty |= 16;
        }
        int $dirty2 = $dirty;
        if (i4 == 2 && ($dirty2 & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            configs2 = configs;
            $composer2 = $composer3;
        } else {
            if (i4 != 0) {
                configs3 = MapsKt.emptyMap();
            } else {
                configs3 = configs;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-446179233, i2, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup (VectorPainter.kt:327)");
            }
            Iterator<VectorNode> it = group.iterator();
            while (it.hasNext()) {
                VectorNode vectorNode = it.next();
                if (vectorNode instanceof VectorPath) {
                    $composer3.startReplaceableGroup(-326285735);
                    ComposerKt.sourceInformation($composer3, "334@12154L1719");
                    VectorConfig vectorConfig = (VectorConfig) configs3.get(((VectorPath) vectorNode).getName());
                    if (vectorConfig == null) {
                        vectorConfig = new VectorPainterKt$RenderVectorGroup$config$1();
                    }
                    VectorConfig config = vectorConfig;
                    Iterator<VectorNode> it2 = it;
                    VectorConfig config2 = config;
                    VectorNode vectorNode2 = vectorNode;
                    Map configs5 = configs3;
                    Composer $composer4 = $composer3;
                    Composer $composer5 = $composer4;
                    VectorComposeKt.m3883Path9cdaXJ4((List) config.getOrDefault(VectorProperty.PathData.INSTANCE, ((VectorPath) vectorNode).getPathData()), ((VectorPath) vectorNode).m3892getPathFillTypeRgk1Os(), ((VectorPath) vectorNode).getName(), (Brush) config.getOrDefault(VectorProperty.Fill.INSTANCE, ((VectorPath) vectorNode).getFill()), ((Number) config.getOrDefault(VectorProperty.FillAlpha.INSTANCE, Float.valueOf(((VectorPath) vectorNode).getFillAlpha()))).floatValue(), (Brush) config.getOrDefault(VectorProperty.Stroke.INSTANCE, ((VectorPath) vectorNode).getStroke()), ((Number) config.getOrDefault(VectorProperty.StrokeAlpha.INSTANCE, Float.valueOf(((VectorPath) vectorNode).getStrokeAlpha()))).floatValue(), ((Number) config.getOrDefault(VectorProperty.StrokeLineWidth.INSTANCE, Float.valueOf(((VectorPath) vectorNode).getStrokeLineWidth()))).floatValue(), ((VectorPath) vectorNode).m3893getStrokeLineCapKaPHkGw(), ((VectorPath) vectorNode).m3894getStrokeLineJoinLxFBmk8(), ((VectorPath) vectorNode2).getStrokeLineMiter(), ((Number) config2.getOrDefault(VectorProperty.TrimPathStart.INSTANCE, Float.valueOf(((VectorPath) vectorNode2).getTrimPathStart()))).floatValue(), ((Number) config2.getOrDefault(VectorProperty.TrimPathEnd.INSTANCE, Float.valueOf(((VectorPath) vectorNode2).getTrimPathEnd()))).floatValue(), ((Number) config2.getOrDefault(VectorProperty.TrimPathOffset.INSTANCE, Float.valueOf(((VectorPath) vectorNode2).getTrimPathOffset()))).floatValue(), $composer5, 8, 0, 0);
                    $composer5.endReplaceableGroup();
                    VectorGroup vectorGroup2 = group;
                    configs4 = configs5;
                    int i5 = $changed;
                    int i6 = i;
                    $composer3 = $composer5;
                    it = it2;
                } else {
                    Iterator<VectorNode> it3 = it;
                    VectorNode vectorNode3 = vectorNode;
                    Map configs6 = configs3;
                    Composer $composer6 = $composer3;
                    if (vectorNode3 instanceof VectorGroup) {
                        $composer6.startReplaceableGroup(-326283877);
                        ComposerKt.sourceInformation($composer6, "379@14012L1368");
                        Map configs7 = configs6;
                        VectorConfig config3 = (VectorConfig) configs7.get(((VectorGroup) vectorNode3).getName());
                        if (config3 == null) {
                            config3 = new VectorPainterKt$RenderVectorGroup$config$2();
                        }
                        VectorComposeKt.Group(((VectorGroup) vectorNode3).getName(), ((Number) config3.getOrDefault(VectorProperty.Rotation.INSTANCE, Float.valueOf(((VectorGroup) vectorNode3).getRotation()))).floatValue(), ((Number) config3.getOrDefault(VectorProperty.PivotX.INSTANCE, Float.valueOf(((VectorGroup) vectorNode3).getPivotX()))).floatValue(), ((Number) config3.getOrDefault(VectorProperty.PivotY.INSTANCE, Float.valueOf(((VectorGroup) vectorNode3).getPivotY()))).floatValue(), ((Number) config3.getOrDefault(VectorProperty.ScaleX.INSTANCE, Float.valueOf(((VectorGroup) vectorNode3).getScaleX()))).floatValue(), ((Number) config3.getOrDefault(VectorProperty.ScaleY.INSTANCE, Float.valueOf(((VectorGroup) vectorNode3).getScaleY()))).floatValue(), ((Number) config3.getOrDefault(VectorProperty.TranslateX.INSTANCE, Float.valueOf(((VectorGroup) vectorNode3).getTranslationX()))).floatValue(), ((Number) config3.getOrDefault(VectorProperty.TranslateY.INSTANCE, Float.valueOf(((VectorGroup) vectorNode3).getTranslationY()))).floatValue(), (List) config3.getOrDefault(VectorProperty.PathData.INSTANCE, ((VectorGroup) vectorNode3).getClipPathData()), ComposableLambdaKt.composableLambda($composer6, 1450046638, true, new VectorPainterKt$RenderVectorGroup$1(vectorNode3, configs7)), $composer6, 939524096, 0);
                        $composer6.endReplaceableGroup();
                        VectorGroup vectorGroup3 = group;
                        int i7 = $changed;
                        configs4 = configs7;
                        $composer3 = $composer6;
                        it = it3;
                        int i8 = i;
                    } else {
                        $composer6.startReplaceableGroup(-326282407);
                        $composer6.endReplaceableGroup();
                        VectorGroup vectorGroup4 = group;
                        int i9 = $changed;
                        configs4 = configs6;
                        $composer3 = $composer6;
                        it = it3;
                        int i10 = i;
                    }
                }
            }
            configs2 = configs3;
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            VectorGroup vectorGroup5 = group;
            int i11 = $changed;
            return;
        }
        endRestartGroup.updateScope(new VectorPainterKt$RenderVectorGroup$2(group, configs2, $changed, i));
    }
}
