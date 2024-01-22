package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a¬\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001af\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006!"}, d2 = {"Card", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "border", "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "content", "Landroidx/compose/runtime/Composable;", "Card-9VG74zQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Card-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Card-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Card.kt */
public final class CardKt {
    /* renamed from: Card-F-jzlyU  reason: not valid java name */
    public static final void m1421CardFjzlyU(Modifier modifier, Shape shape, long backgroundColor, long contentColor, BorderStroke border, float elevation, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        Shape shape2;
        long backgroundColor2;
        long contentColor2;
        BorderStroke border2;
        float elevation2;
        Composer composer = $composer;
        int i2 = $changed;
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(1956755640);
        ComposerKt.sourceInformation(composer, "C(Card)P(5,6,0:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp)60@2616L6,61@2674L6,62@2716L32,67@2854L218:Card.kt#jmzs0o");
        Modifier modifier2 = (i & 1) != 0 ? Modifier.Companion : modifier;
        if ((i & 2) != 0) {
            shape2 = MaterialTheme.INSTANCE.getShapes(composer, 6).getMedium();
        } else {
            shape2 = shape;
        }
        if ((i & 4) != 0) {
            backgroundColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1449getSurface0d7_KjU();
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((i & 8) != 0) {
            contentColor2 = ColorsKt.m1463contentColorForek8zF_U(backgroundColor2, composer, (i2 >> 6) & 14);
        } else {
            contentColor2 = contentColor;
        }
        if ((i & 16) != 0) {
            border2 = null;
        } else {
            border2 = border;
        }
        if ((i & 32) != 0) {
            elevation2 = Dp.m5986constructorimpl((float) 1);
        } else {
            elevation2 = elevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1956755640, i2, -1, "androidx.compose.material.Card (Card.kt:58)");
        }
        long j = backgroundColor2;
        SurfaceKt.m1620SurfaceFjzlyU(modifier2, shape2, backgroundColor2, contentColor2, border2, elevation2, content, $composer, (i2 & 14) | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    /* renamed from: Card-LPr_se0  reason: not valid java name */
    public static final void m1422CardLPr_se0(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long backgroundColor, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i) {
        boolean enabled2;
        Shape shape2;
        long backgroundColor2;
        long contentColor2;
        BorderStroke border2;
        float elevation2;
        MutableInteractionSource interactionSource2;
        MutableInteractionSource mutableInteractionSource;
        Composer composer = $composer;
        int i2 = $changed;
        int i3 = i;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(778538979);
        ComposerKt.sourceInformation(composer, "C(Card)P(8,7,5,9,0:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)111@4759L6,112@4817L6,113@4859L32,116@5003L39,119@5088L319:Card.kt#jmzs0o");
        Modifier modifier2 = (i3 & 2) != 0 ? Modifier.Companion : modifier;
        if ((i3 & 4) != 0) {
            enabled2 = true;
        } else {
            enabled2 = enabled;
        }
        if ((i3 & 8) != 0) {
            shape2 = MaterialTheme.INSTANCE.getShapes(composer, 6).getMedium();
        } else {
            shape2 = shape;
        }
        if ((i3 & 16) != 0) {
            backgroundColor2 = MaterialTheme.INSTANCE.getColors(composer, 6).m1449getSurface0d7_KjU();
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((i3 & 32) != 0) {
            contentColor2 = ColorsKt.m1463contentColorForek8zF_U(backgroundColor2, composer, (i2 >> 12) & 14);
        } else {
            contentColor2 = contentColor;
        }
        if ((i3 & 64) != 0) {
            border2 = null;
        } else {
            border2 = border;
        }
        if ((i3 & 128) != 0) {
            elevation2 = Dp.m5986constructorimpl((float) 1);
        } else {
            elevation2 = elevation;
        }
        if ((i3 & 256) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Composer $this$cache$iv$iv = $composer;
            Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                $this$cache$iv$iv.updateRememberedValue(mutableInteractionSource);
            } else {
                mutableInteractionSource = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            interactionSource2 = mutableInteractionSource;
        } else {
            interactionSource2 = interactionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(778538979, i2, -1, "androidx.compose.material.Card (Card.kt:107)");
        }
        long j = backgroundColor2;
        SurfaceKt.m1621SurfaceLPr_se0(onClick, modifier2, enabled2, shape2, backgroundColor2, contentColor2, border2, elevation2, interactionSource2, content, $composer, (i2 & 14) | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2) | (29360128 & i2) | (234881024 & i2) | (1879048192 & i2), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: androidx.compose.foundation.Indication} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: androidx.compose.foundation.interaction.MutableInteractionSource} */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "This API is deprecated with the introduction a newer Card function overload that accepts an onClick().", replaceWith = @kotlin.ReplaceWith(expression = "Card(onClick, modifier, enabled, shape, backgroundColor, contentColor, border, elevation, interactionSource, content)", imports = {}))
    /* renamed from: Card-9VG74zQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1420Card9VG74zQ(kotlin.jvm.functions.Function0<kotlin.Unit> r32, androidx.compose.ui.Modifier r33, androidx.compose.ui.graphics.Shape r34, long r35, long r37, androidx.compose.foundation.BorderStroke r39, float r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, androidx.compose.foundation.Indication r42, boolean r43, java.lang.String r44, androidx.compose.ui.semantics.Role r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, androidx.compose.runtime.Composer r47, int r48, int r49, int r50) {
        /*
            r15 = r47
            r14 = r48
            r13 = r49
            r0 = r50
            java.lang.String r1 = "onClick"
            r12 = r32
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r1 = "content"
            r11 = r46
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            r1 = 1353606722(0x50ae6642, float:2.34074972E10)
            r15.startReplaceableGroup(r1)
            java.lang.String r2 = "C(Card)P(9,8,12,0:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,7,6,5,10,11:c#ui.semantics.Role)182@7959L6,183@8017L6,184@8059L32,187@8203L39,188@8290L7,195@8465L410:Card.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r2)
            r2 = r0 & 2
            if (r2 == 0) goto L_0x002d
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            r19 = r2
            goto L_0x002f
        L_0x002d:
            r19 = r33
        L_0x002f:
            r2 = r0 & 4
            r3 = 6
            if (r2 == 0) goto L_0x0043
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r2 = r2.getShapes(r15, r3)
            androidx.compose.foundation.shape.CornerBasedShape r2 = r2.getMedium()
            androidx.compose.ui.graphics.Shape r2 = (androidx.compose.ui.graphics.Shape) r2
            r20 = r2
            goto L_0x0045
        L_0x0043:
            r20 = r34
        L_0x0045:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x0055
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r15, r3)
            long r2 = r2.m1449getSurface0d7_KjU()
            r9 = r2
            goto L_0x0057
        L_0x0055:
            r9 = r35
        L_0x0057:
            r2 = r0 & 16
            if (r2 == 0) goto L_0x0066
            int r2 = r14 >> 9
            r2 = r2 & 14
            long r2 = androidx.compose.material.ColorsKt.m1463contentColorForek8zF_U(r9, r15, r2)
            r21 = r2
            goto L_0x0068
        L_0x0066:
            r21 = r37
        L_0x0068:
            r2 = r0 & 32
            if (r2 == 0) goto L_0x0070
            r2 = 0
            r23 = r2
            goto L_0x0072
        L_0x0070:
            r23 = r39
        L_0x0072:
            r2 = r0 & 64
            if (r2 == 0) goto L_0x0080
            r2 = 1
            r3 = 0
            float r4 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r4)
            r24 = r2
            goto L_0x0082
        L_0x0080:
            r24 = r40
        L_0x0082:
            r2 = r0 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00ba
            r2 = 0
            r3 = 0
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r15.startReplaceableGroup(r4)
            java.lang.String r4 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r15, r4)
            r4 = 0
            r5 = r47
            r6 = 0
            java.lang.Object r7 = r5.rememberedValue()
            r8 = 0
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r16.getEmpty()
            if (r7 != r1) goto L_0x00af
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r5.updateRememberedValue(r1)
            goto L_0x00b0
        L_0x00af:
            r1 = r7
        L_0x00b0:
            r47.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r25 = r1
            goto L_0x00bc
        L_0x00ba:
            r25 = r41
        L_0x00bc:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x00dd
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.foundation.IndicationKt.getLocalIndication()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r2 = 0
            r3 = 0
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r15, r4, r5)
            java.lang.Object r4 = r15.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r47)
            r1 = r4
            androidx.compose.foundation.Indication r1 = (androidx.compose.foundation.Indication) r1
            r26 = r1
            goto L_0x00df
        L_0x00dd:
            r26 = r42
        L_0x00df:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x00e7
            r1 = 1
            r27 = r1
            goto L_0x00e9
        L_0x00e7:
            r27 = r43
        L_0x00e9:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x00f1
            r1 = 0
            r28 = r1
            goto L_0x00f3
        L_0x00f1:
            r28 = r44
        L_0x00f3:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x00fb
            r0 = 0
            r29 = r0
            goto L_0x00fd
        L_0x00fb:
            r29 = r45
        L_0x00fd:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x010b
            java.lang.String r0 = "androidx.compose.material.Card (Card.kt:179)"
            r1 = 1353606722(0x50ae6642, float:2.34074972E10)
            androidx.compose.runtime.ComposerKt.traceEventStart(r1, r14, r13, r0)
        L_0x010b:
            r0 = r14 & 14
            r1 = r14 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r14 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r14 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r14
            r0 = r0 | r1
            r1 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r14
            r0 = r0 | r1
            r1 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r14
            r0 = r0 | r1
            r1 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r14
            r0 = r0 | r1
            r1 = 234881024(0xe000000, float:1.5777218E-30)
            r1 = r1 & r14
            r0 = r0 | r1
            r1 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r14
            r16 = r0 | r1
            r0 = r13 & 14
            r1 = r13 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r1 = r13 & 896(0x380, float:1.256E-42)
            r17 = r0 | r1
            r18 = 0
            r0 = r32
            r1 = r19
            r2 = r20
            r3 = r9
            r5 = r21
            r7 = r23
            r8 = r24
            r30 = r9
            r9 = r25
            r10 = r26
            r11 = r27
            r12 = r28
            r13 = r29
            r14 = r46
            r15 = r47
            androidx.compose.material.SurfaceKt.m1619Surface9VG74zQ(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0170
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0170:
            r47.endReplaceableGroup()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.CardKt.m1420Card9VG74zQ(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.Indication, boolean, java.lang.String, androidx.compose.ui.semantics.Role, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
