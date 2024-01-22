package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a¬\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001af\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00142\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00142\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010'\u001a/\u0010(\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u000eH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a;\u0010.\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00062"}, d2 = {"Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "border", "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "content", "Landroidx/compose/runtime/Composable;", "Surface-9VG74zQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Surface-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-Ny5ogXk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "absoluteElevation", "surfaceColorAtElevation-cq6XJ1M", "(JLandroidx/compose/material/ElevationOverlay;FLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Surface.kt */
public final class SurfaceKt {
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x010b  */
    /* renamed from: Surface-F-jzlyU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1620SurfaceFjzlyU(androidx.compose.ui.Modifier r25, androidx.compose.ui.graphics.Shape r26, long r27, long r29, androidx.compose.foundation.BorderStroke r31, float r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r12 = r33
            r13 = r35
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 1412203386(0x542c837a, float:2.96376074E12)
            r1 = r34
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Surface)P(5,6,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp)107@5308L6,108@5350L22,*113@5525L7,114@5549L849:Surface.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r1)
            r1 = r35
            r2 = r36 & 1
            if (r2 == 0) goto L_0x0022
            r1 = r1 | 6
            r4 = r25
            goto L_0x0035
        L_0x0022:
            r4 = r13 & 14
            if (r4 != 0) goto L_0x0033
            r4 = r25
            boolean r5 = r14.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0030
            r5 = 4
            goto L_0x0031
        L_0x0030:
            r5 = 2
        L_0x0031:
            r1 = r1 | r5
            goto L_0x0035
        L_0x0033:
            r4 = r25
        L_0x0035:
            r5 = r36 & 2
            if (r5 == 0) goto L_0x003e
            r1 = r1 | 48
            r6 = r26
            goto L_0x0053
        L_0x003e:
            r6 = r13 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0051
            r6 = r26
            boolean r7 = r14.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x004d
            r7 = 32
            goto L_0x004f
        L_0x004d:
            r7 = 16
        L_0x004f:
            r1 = r1 | r7
            goto L_0x0053
        L_0x0051:
            r6 = r26
        L_0x0053:
            r7 = r13 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x006c
            r7 = r36 & 4
            if (r7 != 0) goto L_0x0066
            r7 = r27
            boolean r9 = r14.changed((long) r7)
            if (r9 == 0) goto L_0x0068
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x006a
        L_0x0066:
            r7 = r27
        L_0x0068:
            r9 = 128(0x80, float:1.794E-43)
        L_0x006a:
            r1 = r1 | r9
            goto L_0x006e
        L_0x006c:
            r7 = r27
        L_0x006e:
            r9 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0087
            r9 = r36 & 8
            if (r9 != 0) goto L_0x0081
            r9 = r29
            boolean r11 = r14.changed((long) r9)
            if (r11 == 0) goto L_0x0083
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0085
        L_0x0081:
            r9 = r29
        L_0x0083:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0085:
            r1 = r1 | r11
            goto L_0x0089
        L_0x0087:
            r9 = r29
        L_0x0089:
            r11 = r36 & 16
            if (r11 == 0) goto L_0x0092
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r15 = r31
            goto L_0x00aa
        L_0x0092:
            r15 = 57344(0xe000, float:8.0356E-41)
            r15 = r15 & r13
            if (r15 != 0) goto L_0x00a8
            r15 = r31
            boolean r16 = r14.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00a3
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a5:
            r1 = r1 | r16
            goto L_0x00aa
        L_0x00a8:
            r15 = r31
        L_0x00aa:
            r16 = r36 & 32
            if (r16 == 0) goto L_0x00b5
            r17 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r17
            r3 = r32
            goto L_0x00cd
        L_0x00b5:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r13 & r17
            if (r17 != 0) goto L_0x00cb
            r3 = r32
            boolean r17 = r14.changed((float) r3)
            if (r17 == 0) goto L_0x00c6
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c8
        L_0x00c6:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c8:
            r1 = r1 | r17
            goto L_0x00cd
        L_0x00cb:
            r3 = r32
        L_0x00cd:
            r17 = r36 & 64
            if (r17 == 0) goto L_0x00d6
            r17 = 1572864(0x180000, float:2.204052E-39)
        L_0x00d3:
            r1 = r1 | r17
            goto L_0x00e8
        L_0x00d6:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r13 & r17
            if (r17 != 0) goto L_0x00e8
            boolean r17 = r14.changedInstance(r12)
            if (r17 == 0) goto L_0x00e5
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d3
        L_0x00e5:
            r17 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00d3
        L_0x00e8:
            r17 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r1 & r17
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r3) goto L_0x010b
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x00f9
            goto L_0x010b
        L_0x00f9:
            r14.skipToGroupEnd()
            r22 = r32
            r23 = r1
            r16 = r6
            r17 = r7
            r19 = r9
            r21 = r15
            r15 = r4
            goto L_0x0229
        L_0x010b:
            r14.startDefaults()
            r0 = r13 & 1
            if (r0 == 0) goto L_0x013f
            boolean r0 = r14.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0119
            goto L_0x013f
        L_0x0119:
            r14.skipToGroupEnd()
            r0 = r36 & 4
            if (r0 == 0) goto L_0x0122
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0122:
            r0 = r36 & 8
            if (r0 == 0) goto L_0x0134
            r0 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r21 = r32
            r11 = r6
            r19 = r9
            r17 = r15
            r9 = r0
            r10 = r4
            r15 = r7
            goto L_0x0190
        L_0x0134:
            r21 = r32
            r11 = r6
            r19 = r9
            r17 = r15
            r9 = r1
            r10 = r4
            r15 = r7
            goto L_0x0190
        L_0x013f:
            if (r2 == 0) goto L_0x0146
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r4 = r0
        L_0x0146:
            if (r5 == 0) goto L_0x014d
            androidx.compose.ui.graphics.Shape r0 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r6 = r0
        L_0x014d:
            r0 = r36 & 4
            if (r0 == 0) goto L_0x015f
            androidx.compose.material.MaterialTheme r0 = androidx.compose.material.MaterialTheme.INSTANCE
            r2 = 6
            androidx.compose.material.Colors r0 = r0.getColors(r14, r2)
            long r2 = r0.m1449getSurface0d7_KjU()
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r7 = r2
        L_0x015f:
            r0 = r36 & 8
            if (r0 == 0) goto L_0x016e
            int r0 = r1 >> 6
            r0 = r0 & 14
            long r2 = androidx.compose.material.ColorsKt.m1463contentColorForek8zF_U(r7, r14, r0)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r9 = r2
        L_0x016e:
            if (r11 == 0) goto L_0x0172
            r0 = 0
            r15 = r0
        L_0x0172:
            if (r16 == 0) goto L_0x0186
            r0 = 0
            r2 = 0
            float r3 = (float) r0
            float r0 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r3)
            r21 = r0
            r11 = r6
            r19 = r9
            r17 = r15
            r9 = r1
            r10 = r4
            r15 = r7
            goto L_0x0190
        L_0x0186:
            r21 = r32
            r11 = r6
            r19 = r9
            r17 = r15
            r9 = r1
            r10 = r4
            r15 = r7
        L_0x0190:
            r14.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01a2
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.Surface (Surface.kt:104)"
            r2 = 1412203386(0x542c837a, float:2.96376074E12)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r9, r0, r1)
        L_0x01a2:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r3, r4)
            java.lang.Object r3 = r14.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.Dp r3 = (androidx.compose.ui.unit.Dp) r3
            float r0 = r3.m6000unboximpl()
            r1 = 0
            float r2 = r0 + r21
            float r5 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r2)
            r0 = 2
            androidx.compose.runtime.ProvidedValue[] r8 = new androidx.compose.runtime.ProvidedValue[r0]
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r1 = androidx.compose.ui.graphics.Color.m3154boximpl(r19)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r1 = 0
            r8[r1] = r0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.m5984boximpl(r5)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r7 = 1
            r8[r7] = r0
            androidx.compose.material.SurfaceKt$Surface$1 r6 = new androidx.compose.material.SurfaceKt$Surface$1
            r0 = r6
            r1 = r10
            r2 = r11
            r3 = r15
            r25 = r10
            r10 = r6
            r6 = r9
            r26 = r11
            r11 = r7
            r7 = r17
            r22 = r8
            r8 = r21
            r18 = r9
            r9 = r33
            r0.<init>(r1, r2, r3, r5, r6, r7, r8, r9)
            r0 = -1822160838(0xffffffff9364083a, float:-2.8781702E-27)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r0, r11, r10)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 56
            r2 = r22
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r14, (int) r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x021d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x021d:
            r23 = r18
            r22 = r21
            r21 = r17
            r17 = r15
            r15 = r25
            r16 = r26
        L_0x0229:
            androidx.compose.runtime.ScopeUpdateScope r11 = r14.endRestartGroup()
            if (r11 != 0) goto L_0x0230
            goto L_0x0250
        L_0x0230:
            androidx.compose.material.SurfaceKt$Surface$2 r24 = new androidx.compose.material.SurfaceKt$Surface$2
            r0 = r24
            r1 = r15
            r2 = r16
            r3 = r17
            r5 = r19
            r7 = r21
            r8 = r22
            r9 = r33
            r10 = r35
            r12 = r11
            r11 = r36
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            r0 = r24
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x0250:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1620SurfaceFjzlyU(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0316  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0319  */
    /* renamed from: Surface-LPr_se0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1621SurfaceLPr_se0(kotlin.jvm.functions.Function0<kotlin.Unit> r28, androidx.compose.ui.Modifier r29, boolean r30, androidx.compose.ui.graphics.Shape r31, long r32, long r34, androidx.compose.foundation.BorderStroke r36, float r37, androidx.compose.foundation.interaction.MutableInteractionSource r38, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, androidx.compose.runtime.Composer r40, int r41, int r42) {
        /*
            r15 = r28
            r14 = r39
            r13 = r41
            r12 = r42
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1560876237(0x5d0914cd, float:6.1735908E17)
            r1 = r40
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Surface)P(8,7,5,9,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)215@10749L6,216@10791L22,219@10925L39,*222@11057L7,223@11081L982:Surface.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r41
            r2 = r12 & 1
            if (r2 == 0) goto L_0x002a
            r1 = r1 | 6
            goto L_0x0038
        L_0x002a:
            r2 = r13 & 14
            if (r2 != 0) goto L_0x0038
            boolean r2 = r11.changedInstance(r15)
            if (r2 == 0) goto L_0x0036
            r2 = 4
            goto L_0x0037
        L_0x0036:
            r2 = 2
        L_0x0037:
            r1 = r1 | r2
        L_0x0038:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0041
            r1 = r1 | 48
            r4 = r29
            goto L_0x0056
        L_0x0041:
            r4 = r13 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0054
            r4 = r29
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0050
            r5 = 32
            goto L_0x0052
        L_0x0050:
            r5 = 16
        L_0x0052:
            r1 = r1 | r5
            goto L_0x0056
        L_0x0054:
            r4 = r29
        L_0x0056:
            r5 = r12 & 4
            if (r5 == 0) goto L_0x005f
            r1 = r1 | 384(0x180, float:5.38E-43)
            r6 = r30
            goto L_0x0074
        L_0x005f:
            r6 = r13 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0072
            r6 = r30
            boolean r7 = r11.changed((boolean) r6)
            if (r7 == 0) goto L_0x006e
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0070
        L_0x006e:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0070:
            r1 = r1 | r7
            goto L_0x0074
        L_0x0072:
            r6 = r30
        L_0x0074:
            r7 = r12 & 8
            if (r7 == 0) goto L_0x007d
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r8 = r31
            goto L_0x0092
        L_0x007d:
            r8 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0090
            r8 = r31
            boolean r9 = r11.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x008c
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x008e
        L_0x008c:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x008e:
            r1 = r1 | r9
            goto L_0x0092
        L_0x0090:
            r8 = r31
        L_0x0092:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r13
            if (r9 != 0) goto L_0x00ae
            r9 = r12 & 16
            if (r9 != 0) goto L_0x00a7
            r9 = r32
            boolean r16 = r11.changed((long) r9)
            if (r16 == 0) goto L_0x00a9
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ab
        L_0x00a7:
            r9 = r32
        L_0x00a9:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00ab:
            r1 = r1 | r16
            goto L_0x00b0
        L_0x00ae:
            r9 = r32
        L_0x00b0:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00cc
            r16 = r12 & 32
            if (r16 != 0) goto L_0x00c5
            r3 = r34
            boolean r16 = r11.changed((long) r3)
            if (r16 == 0) goto L_0x00c7
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c9
        L_0x00c5:
            r3 = r34
        L_0x00c7:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c9:
            r1 = r1 | r16
            goto L_0x00ce
        L_0x00cc:
            r3 = r34
        L_0x00ce:
            r16 = r12 & 64
            if (r16 == 0) goto L_0x00d9
            r17 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r17
            r0 = r36
            goto L_0x00f1
        L_0x00d9:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r13 & r17
            if (r17 != 0) goto L_0x00ef
            r0 = r36
            boolean r18 = r11.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x00ea
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ec
        L_0x00ea:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00ec:
            r1 = r1 | r18
            goto L_0x00f1
        L_0x00ef:
            r0 = r36
        L_0x00f1:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00fc
            r18 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r18
            r3 = r37
            goto L_0x0113
        L_0x00fc:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r13 & r18
            if (r18 != 0) goto L_0x0111
            r3 = r37
            boolean r4 = r11.changed((float) r3)
            if (r4 == 0) goto L_0x010d
            r4 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010f
        L_0x010d:
            r4 = 4194304(0x400000, float:5.877472E-39)
        L_0x010f:
            r1 = r1 | r4
            goto L_0x0113
        L_0x0111:
            r3 = r37
        L_0x0113:
            r4 = r12 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x011e
            r18 = 100663296(0x6000000, float:2.4074124E-35)
            r1 = r1 | r18
            r3 = r38
            goto L_0x0136
        L_0x011e:
            r18 = 234881024(0xe000000, float:1.5777218E-30)
            r18 = r13 & r18
            if (r18 != 0) goto L_0x0134
            r3 = r38
            boolean r18 = r11.changed((java.lang.Object) r3)
            if (r18 == 0) goto L_0x012f
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0131
        L_0x012f:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0131:
            r1 = r1 | r18
            goto L_0x0136
        L_0x0134:
            r3 = r38
        L_0x0136:
            r3 = r12 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x013e
            r3 = 805306368(0x30000000, float:4.656613E-10)
        L_0x013c:
            r1 = r1 | r3
            goto L_0x014f
        L_0x013e:
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r13
            if (r3 != 0) goto L_0x014f
            boolean r3 = r11.changedInstance(r14)
            if (r3 == 0) goto L_0x014c
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013c
        L_0x014c:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x013c
        L_0x014f:
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r3 & r1
            r6 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r6) goto L_0x0177
            boolean r3 = r11.getSkipping()
            if (r3 != 0) goto L_0x015f
            goto L_0x0177
        L_0x015f:
            r11.skipToGroupEnd()
            r16 = r29
            r18 = r30
            r22 = r34
            r24 = r36
            r25 = r37
            r26 = r38
            r17 = r1
            r19 = r8
            r20 = r9
            r15 = r11
            goto L_0x0310
        L_0x0177:
            r11.startDefaults()
            r3 = r13 & 1
            r6 = -458753(0xfffffffffff8ffff, float:NaN)
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x01c0
            boolean r3 = r11.getDefaultsInvalid()
            if (r3 == 0) goto L_0x018b
            goto L_0x01c0
        L_0x018b:
            r11.skipToGroupEnd()
            r0 = r12 & 16
            if (r0 == 0) goto L_0x0194
            r1 = r1 & r18
        L_0x0194:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x01ad
            r0 = r1 & r6
            r16 = r29
            r18 = r30
            r22 = r34
            r24 = r36
            r25 = r37
            r26 = r38
            r19 = r8
            r20 = r9
            r10 = r0
            goto L_0x027d
        L_0x01ad:
            r16 = r29
            r18 = r30
            r22 = r34
            r24 = r36
            r25 = r37
            r26 = r38
            r19 = r8
            r20 = r9
            r10 = r1
            goto L_0x027d
        L_0x01c0:
            if (r2 == 0) goto L_0x01c7
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x01c9
        L_0x01c7:
            r2 = r29
        L_0x01c9:
            if (r5 == 0) goto L_0x01cd
            r3 = 1
            goto L_0x01cf
        L_0x01cd:
            r3 = r30
        L_0x01cf:
            if (r7 == 0) goto L_0x01d6
            androidx.compose.ui.graphics.Shape r5 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            goto L_0x01d7
        L_0x01d6:
            r5 = r8
        L_0x01d7:
            r7 = r12 & 16
            if (r7 == 0) goto L_0x01e9
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            r8 = 6
            androidx.compose.material.Colors r7 = r7.getColors(r11, r8)
            long r7 = r7.m1449getSurface0d7_KjU()
            r1 = r1 & r18
            goto L_0x01ea
        L_0x01e9:
            r7 = r9
        L_0x01ea:
            r9 = r12 & 32
            if (r9 == 0) goto L_0x01f8
            int r9 = r1 >> 12
            r9 = r9 & 14
            long r9 = androidx.compose.material.ColorsKt.m1463contentColorForek8zF_U(r7, r11, r9)
            r1 = r1 & r6
            goto L_0x01fa
        L_0x01f8:
            r9 = r34
        L_0x01fa:
            if (r16 == 0) goto L_0x01fe
            r6 = 0
            goto L_0x0200
        L_0x01fe:
            r6 = r36
        L_0x0200:
            if (r0 == 0) goto L_0x020d
            r0 = 0
            r16 = 0
            r29 = r1
            float r1 = (float) r0
            float r0 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r1)
            goto L_0x0211
        L_0x020d:
            r29 = r1
            r0 = r37
        L_0x0211:
            if (r4 == 0) goto L_0x0269
            r1 = 0
            r4 = 0
            r30 = r0
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r0)
            r0 = 0
            r31 = r11
            r16 = 0
            r32 = r0
            java.lang.Object r0 = r31.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r33 = r1
            java.lang.Object r1 = r19.getEmpty()
            if (r0 != r1) goto L_0x0248
            r1 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r34 = r0
            r0 = r31
            r0.updateRememberedValue(r1)
            goto L_0x024e
        L_0x0248:
            r34 = r0
            r0 = r31
            r1 = r34
        L_0x024e:
            r11.endReplaceableGroup()
            r0 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = (androidx.compose.foundation.interaction.MutableInteractionSource) r0
            r25 = r30
            r26 = r0
            r16 = r2
            r18 = r3
            r19 = r5
            r24 = r6
            r20 = r7
            r22 = r9
            r10 = r29
            goto L_0x027d
        L_0x0269:
            r30 = r0
            r25 = r30
            r26 = r38
            r16 = r2
            r18 = r3
            r19 = r5
            r24 = r6
            r20 = r7
            r22 = r9
            r10 = r29
        L_0x027d:
            r11.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x028f
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.Surface (Surface.kt:210)"
            r2 = 1560876237(0x5d0914cd, float:6.1735908E17)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r10, r0, r1)
        L_0x028f:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.runtime.CompositionLocal r0 = (androidx.compose.runtime.CompositionLocal) r0
            r1 = 6
            r2 = 0
            r3 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r4 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r11, r3, r4)
            java.lang.Object r3 = r11.consume(r0)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r11)
            androidx.compose.ui.unit.Dp r3 = (androidx.compose.ui.unit.Dp) r3
            float r0 = r3.m6000unboximpl()
            r1 = 0
            float r2 = r0 + r25
            float r5 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r2)
            r0 = 2
            androidx.compose.runtime.ProvidedValue[] r9 = new androidx.compose.runtime.ProvidedValue[r0]
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r1 = androidx.compose.ui.graphics.Color.m3154boximpl(r22)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r1 = 0
            r9[r1] = r0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.m5984boximpl(r5)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r8 = 1
            r9[r8] = r0
            androidx.compose.material.SurfaceKt$Surface$4 r7 = new androidx.compose.material.SurfaceKt$Surface$4
            r0 = r7
            r1 = r16
            r2 = r19
            r3 = r20
            r6 = r10
            r13 = r7
            r7 = r24
            r14 = r8
            r8 = r25
            r27 = r9
            r9 = r26
            r17 = r10
            r10 = r18
            r15 = r11
            r11 = r28
            r12 = r39
            r0.<init>(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = 2031491085(0x7916180d, float:4.870827E34)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r14, r13)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = 56
            r2 = r27
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r15, (int) r1)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0310
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0310:
            androidx.compose.runtime.ScopeUpdateScope r14 = r15.endRestartGroup()
            if (r14 != 0) goto L_0x0319
            r29 = r15
            goto L_0x0342
        L_0x0319:
            androidx.compose.material.SurfaceKt$Surface$5 r27 = new androidx.compose.material.SurfaceKt$Surface$5
            r0 = r27
            r1 = r28
            r2 = r16
            r3 = r18
            r4 = r19
            r5 = r20
            r7 = r22
            r9 = r24
            r10 = r25
            r11 = r26
            r12 = r39
            r13 = r41
            r29 = r15
            r15 = r14
            r14 = r42
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14)
            r0 = r27
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x0342:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1621SurfaceLPr_se0(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: Surface-Ny5ogXk  reason: not valid java name */
    public static final void m1622SurfaceNy5ogXk(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i) {
        boolean z;
        int i2;
        int $dirty;
        MutableInteractionSource interactionSource2;
        float elevation2;
        BorderStroke border2;
        long contentColor2;
        long color2;
        Shape shape2;
        boolean enabled2;
        Modifier modifier2;
        Composer $composer2;
        int $dirty2;
        Modifier modifier3;
        boolean enabled3;
        Shape shape3;
        long color3;
        long contentColor3;
        BorderStroke border3;
        BorderStroke border4;
        float elevation3;
        Object value$iv$iv;
        int i3;
        int $dirty3;
        int i4;
        Function0<Unit> function0 = onClick;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i5 = $changed;
        int i6 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer3 = $composer.startRestartGroup(262027249);
        ComposerKt.sourceInformation($composer3, "C(Surface)P(9,8,7,5,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)329@16502L6,330@16544L22,333@16678L39,*336@16810L7,337@16834L1024:Surface.kt#jmzs0o");
        int $dirty4 = $changed;
        int $dirty1 = $changed1;
        if ((i6 & 1) != 0) {
            $dirty4 |= 6;
            boolean z2 = selected;
        } else if ((i5 & 14) == 0) {
            $dirty4 |= $composer3.changed(selected) ? 4 : 2;
        } else {
            boolean z3 = selected;
        }
        if ((i6 & 2) != 0) {
            $dirty4 |= 48;
        } else if ((i5 & 112) == 0) {
            $dirty4 |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int i7 = i6 & 4;
        if (i7 != 0) {
            $dirty4 |= 384;
            Modifier modifier4 = modifier;
        } else if ((i5 & 896) == 0) {
            $dirty4 |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier5 = modifier;
        }
        int i8 = i6 & 8;
        if (i8 != 0) {
            $dirty4 |= 3072;
            z = enabled;
        } else if ((i5 & 7168) == 0) {
            z = enabled;
            $dirty4 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i9 = i6 & 16;
        if (i9 != 0) {
            $dirty4 |= 24576;
            Shape shape4 = shape;
        } else if ((i5 & 57344) == 0) {
            $dirty4 |= $composer3.changed((Object) shape) ? 16384 : 8192;
        } else {
            Shape shape5 = shape;
        }
        if ((i5 & 458752) == 0) {
            if ((i6 & 32) == 0) {
                i2 = i8;
                if ($composer3.changed(color)) {
                    i4 = 131072;
                    $dirty4 |= i4;
                }
            } else {
                i2 = i8;
                long j = color;
            }
            i4 = 65536;
            $dirty4 |= i4;
        } else {
            i2 = i8;
            long j2 = color;
        }
        if ((i5 & 3670016) == 0) {
            if ((i6 & 64) == 0) {
                $dirty3 = $dirty4;
                if ($composer3.changed(contentColor)) {
                    i3 = 1048576;
                    $dirty = $dirty3 | i3;
                }
            } else {
                $dirty3 = $dirty4;
                long j3 = contentColor;
            }
            i3 = 524288;
            $dirty = $dirty3 | i3;
        } else {
            $dirty = $dirty4;
            long j4 = contentColor;
        }
        int i10 = i6 & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
            BorderStroke borderStroke = border;
        } else if ((29360128 & i5) == 0) {
            $dirty |= $composer3.changed((Object) border) ? 8388608 : 4194304;
        } else {
            BorderStroke borderStroke2 = border;
        }
        int i11 = i6 & 256;
        if (i11 != 0) {
            $dirty |= 100663296;
            float f = elevation;
        } else if ((i5 & 234881024) == 0) {
            $dirty |= $composer3.changed(elevation) ? 67108864 : 33554432;
        } else {
            float f2 = elevation;
        }
        int i12 = i6 & 512;
        if (i12 != 0) {
            $dirty |= 805306368;
            MutableInteractionSource mutableInteractionSource = interactionSource;
        } else if ((i5 & 1879048192) == 0) {
            $dirty |= $composer3.changed((Object) interactionSource) ? 536870912 : 268435456;
        } else {
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        }
        if ((i6 & 1024) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if (($dirty & 1533916891) == 306783378 && ($dirty1 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            shape2 = shape;
            color2 = color;
            contentColor2 = contentColor;
            border2 = border;
            elevation2 = elevation;
            interactionSource2 = interactionSource;
            int i13 = $dirty1;
            $composer2 = $composer3;
            int i14 = $dirty;
            enabled2 = z;
        } else {
            $composer3.startDefaults();
            if ((i5 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i2 != 0) {
                    enabled3 = true;
                } else {
                    enabled3 = z;
                }
                if (i9 != 0) {
                    shape3 = RectangleShapeKt.getRectangleShape();
                } else {
                    shape3 = shape;
                }
                if ((i6 & 32) != 0) {
                    $dirty &= -458753;
                    color3 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1449getSurface0d7_KjU();
                } else {
                    color3 = color;
                }
                if ((i6 & 64) != 0) {
                    contentColor3 = ColorsKt.m1463contentColorForek8zF_U(color3, $composer3, ($dirty >> 15) & 14);
                    $dirty &= -3670017;
                } else {
                    contentColor3 = contentColor;
                }
                if (i10 != 0) {
                    border3 = null;
                } else {
                    border3 = border;
                }
                if (i11 != 0) {
                    border4 = border3;
                    elevation3 = Dp.m5986constructorimpl((float) 0);
                } else {
                    border4 = border3;
                    elevation3 = elevation;
                }
                if (i12 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    float elevation4 = elevation3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        Object obj = it$iv$iv;
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        Object obj2 = it$iv$iv;
                        Object it$iv$iv2 = $this$cache$iv$iv;
                        value$iv$iv = obj2;
                    }
                    $composer3.endReplaceableGroup();
                    border2 = border4;
                    elevation2 = elevation4;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    modifier2 = modifier3;
                    $dirty2 = $dirty;
                    contentColor2 = contentColor3;
                    enabled2 = enabled3;
                    color2 = color3;
                    shape2 = shape3;
                } else {
                    border2 = border4;
                    elevation2 = elevation3;
                    interactionSource2 = interactionSource;
                    modifier2 = modifier3;
                    $dirty2 = $dirty;
                    contentColor2 = contentColor3;
                    enabled2 = enabled3;
                    color2 = color3;
                    shape2 = shape3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i6 & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i6 & 64) != 0) {
                    modifier2 = modifier;
                    shape2 = shape;
                    color2 = color;
                    contentColor2 = contentColor;
                    border2 = border;
                    elevation2 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty & -3670017;
                    enabled2 = z;
                } else {
                    modifier2 = modifier;
                    shape2 = shape;
                    color2 = color;
                    contentColor2 = contentColor;
                    border2 = border;
                    elevation2 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty;
                    enabled2 = z;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(262027249, $dirty2, $dirty1, "androidx.compose.material.Surface (Surface.kt:323)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(ElevationOverlayKt.getLocalAbsoluteElevation());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float absoluteElevation = Dp.m5986constructorimpl(((Dp) consume).m6000unboximpl() + elevation2);
            SurfaceKt$Surface$7 surfaceKt$Surface$7 = r0;
            int $dirty5 = $dirty2;
            SurfaceKt$Surface$7 surfaceKt$Surface$72 = new SurfaceKt$Surface$7(modifier2, shape2, color2, absoluteElevation, $dirty2, border2, elevation2, selected, interactionSource2, enabled2, onClick, content, $dirty1);
            $composer2 = $composer3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(contentColor2)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5984boximpl(absoluteElevation))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, -1391199439, true, surfaceKt$Surface$7), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i15 = $dirty5;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new SurfaceKt$Surface$8(selected, onClick, modifier2, enabled2, shape2, color2, contentColor2, border2, elevation2, interactionSource2, content, $changed, $changed1, i));
    }

    /* renamed from: Surface-Ny5ogXk  reason: not valid java name */
    public static final void m1623SurfaceNy5ogXk(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i) {
        boolean z;
        int i2;
        int $dirty;
        MutableInteractionSource interactionSource2;
        float elevation2;
        BorderStroke border2;
        long contentColor2;
        long color2;
        Shape shape2;
        boolean enabled2;
        Modifier modifier2;
        Composer $composer2;
        int $dirty2;
        Modifier modifier3;
        boolean enabled3;
        Shape shape3;
        long color3;
        long contentColor3;
        BorderStroke border3;
        BorderStroke border4;
        float elevation3;
        Object value$iv$iv;
        int i3;
        int $dirty3;
        int i4;
        Function1<? super Boolean, Unit> function1 = onCheckedChange;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i5 = $changed;
        int i6 = i;
        Intrinsics.checkNotNullParameter(function1, "onCheckedChange");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer3 = $composer.startRestartGroup(1341569296);
        ComposerKt.sourceInformation($composer3, "C(Surface)P(1,9,8,6,10,2:c#ui.graphics.Color,4:c#ui.graphics.Color!1,5:c#ui.unit.Dp,7)444@22372L6,445@22414L22,448@22548L39,*451@22680L7,452@22704L1034:Surface.kt#jmzs0o");
        int $dirty4 = $changed;
        int $dirty1 = $changed1;
        if ((i6 & 1) != 0) {
            $dirty4 |= 6;
            boolean z2 = checked;
        } else if ((i5 & 14) == 0) {
            $dirty4 |= $composer3.changed(checked) ? 4 : 2;
        } else {
            boolean z3 = checked;
        }
        if ((i6 & 2) != 0) {
            $dirty4 |= 48;
        } else if ((i5 & 112) == 0) {
            $dirty4 |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int i7 = i6 & 4;
        if (i7 != 0) {
            $dirty4 |= 384;
            Modifier modifier4 = modifier;
        } else if ((i5 & 896) == 0) {
            $dirty4 |= $composer3.changed((Object) modifier) ? 256 : 128;
        } else {
            Modifier modifier5 = modifier;
        }
        int i8 = i6 & 8;
        if (i8 != 0) {
            $dirty4 |= 3072;
            z = enabled;
        } else if ((i5 & 7168) == 0) {
            z = enabled;
            $dirty4 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        int i9 = i6 & 16;
        if (i9 != 0) {
            $dirty4 |= 24576;
            Shape shape4 = shape;
        } else if ((i5 & 57344) == 0) {
            $dirty4 |= $composer3.changed((Object) shape) ? 16384 : 8192;
        } else {
            Shape shape5 = shape;
        }
        if ((i5 & 458752) == 0) {
            if ((i6 & 32) == 0) {
                i2 = i8;
                if ($composer3.changed(color)) {
                    i4 = 131072;
                    $dirty4 |= i4;
                }
            } else {
                i2 = i8;
                long j = color;
            }
            i4 = 65536;
            $dirty4 |= i4;
        } else {
            i2 = i8;
            long j2 = color;
        }
        if ((i5 & 3670016) == 0) {
            if ((i6 & 64) == 0) {
                $dirty3 = $dirty4;
                if ($composer3.changed(contentColor)) {
                    i3 = 1048576;
                    $dirty = $dirty3 | i3;
                }
            } else {
                $dirty3 = $dirty4;
                long j3 = contentColor;
            }
            i3 = 524288;
            $dirty = $dirty3 | i3;
        } else {
            $dirty = $dirty4;
            long j4 = contentColor;
        }
        int i10 = i6 & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
            BorderStroke borderStroke = border;
        } else if ((29360128 & i5) == 0) {
            $dirty |= $composer3.changed((Object) border) ? 8388608 : 4194304;
        } else {
            BorderStroke borderStroke2 = border;
        }
        int i11 = i6 & 256;
        if (i11 != 0) {
            $dirty |= 100663296;
            float f = elevation;
        } else if ((i5 & 234881024) == 0) {
            $dirty |= $composer3.changed(elevation) ? 67108864 : 33554432;
        } else {
            float f2 = elevation;
        }
        int i12 = i6 & 512;
        if (i12 != 0) {
            $dirty |= 805306368;
            MutableInteractionSource mutableInteractionSource = interactionSource;
        } else if ((i5 & 1879048192) == 0) {
            $dirty |= $composer3.changed((Object) interactionSource) ? 536870912 : 268435456;
        } else {
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        }
        if ((i6 & 1024) != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if (($dirty & 1533916891) == 306783378 && ($dirty1 & 11) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            shape2 = shape;
            color2 = color;
            contentColor2 = contentColor;
            border2 = border;
            elevation2 = elevation;
            interactionSource2 = interactionSource;
            int i13 = $dirty1;
            $composer2 = $composer3;
            int i14 = $dirty;
            enabled2 = z;
        } else {
            $composer3.startDefaults();
            if ((i5 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i2 != 0) {
                    enabled3 = true;
                } else {
                    enabled3 = z;
                }
                if (i9 != 0) {
                    shape3 = RectangleShapeKt.getRectangleShape();
                } else {
                    shape3 = shape;
                }
                if ((i6 & 32) != 0) {
                    $dirty &= -458753;
                    color3 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1449getSurface0d7_KjU();
                } else {
                    color3 = color;
                }
                if ((i6 & 64) != 0) {
                    contentColor3 = ColorsKt.m1463contentColorForek8zF_U(color3, $composer3, ($dirty >> 15) & 14);
                    $dirty &= -3670017;
                } else {
                    contentColor3 = contentColor;
                }
                if (i10 != 0) {
                    border3 = null;
                } else {
                    border3 = border;
                }
                if (i11 != 0) {
                    border4 = border3;
                    elevation3 = Dp.m5986constructorimpl((float) 0);
                } else {
                    border4 = border3;
                    elevation3 = elevation;
                }
                if (i12 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    float elevation4 = elevation3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        Object obj = it$iv$iv;
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        Object obj2 = it$iv$iv;
                        Object it$iv$iv2 = $this$cache$iv$iv;
                        value$iv$iv = obj2;
                    }
                    $composer3.endReplaceableGroup();
                    border2 = border4;
                    elevation2 = elevation4;
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                    modifier2 = modifier3;
                    $dirty2 = $dirty;
                    contentColor2 = contentColor3;
                    enabled2 = enabled3;
                    color2 = color3;
                    shape2 = shape3;
                } else {
                    border2 = border4;
                    elevation2 = elevation3;
                    interactionSource2 = interactionSource;
                    modifier2 = modifier3;
                    $dirty2 = $dirty;
                    contentColor2 = contentColor3;
                    enabled2 = enabled3;
                    color2 = color3;
                    shape2 = shape3;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i6 & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i6 & 64) != 0) {
                    modifier2 = modifier;
                    shape2 = shape;
                    color2 = color;
                    contentColor2 = contentColor;
                    border2 = border;
                    elevation2 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty & -3670017;
                    enabled2 = z;
                } else {
                    modifier2 = modifier;
                    shape2 = shape;
                    color2 = color;
                    contentColor2 = contentColor;
                    border2 = border;
                    elevation2 = elevation;
                    interactionSource2 = interactionSource;
                    $dirty2 = $dirty;
                    enabled2 = z;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1341569296, $dirty2, $dirty1, "androidx.compose.material.Surface (Surface.kt:438)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(ElevationOverlayKt.getLocalAbsoluteElevation());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float absoluteElevation = Dp.m5986constructorimpl(((Dp) consume).m6000unboximpl() + elevation2);
            SurfaceKt$Surface$10 surfaceKt$Surface$10 = r0;
            int $dirty5 = $dirty2;
            SurfaceKt$Surface$10 surfaceKt$Surface$102 = new SurfaceKt$Surface$10(modifier2, shape2, color2, absoluteElevation, $dirty2, border2, elevation2, checked, interactionSource2, enabled2, onCheckedChange, content, $dirty1);
            $composer2 = $composer3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(contentColor2)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5984boximpl(absoluteElevation))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, -311657392, true, surfaceKt$Surface$10), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i15 = $dirty5;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new SurfaceKt$Surface$11(checked, onCheckedChange, modifier2, enabled2, shape2, color2, contentColor2, border2, elevation2, interactionSource2, content, $changed, $changed1, i));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "This API is deprecated with the introduction a newer Surface function overload that accepts an onClick().", replaceWith = @ReplaceWith(expression = "Surface(onClick, modifier, enabled, shape, color, contentColor, border, elevation, interactionSource, content)", imports = {}))
    /* renamed from: Surface-9VG74zQ  reason: not valid java name */
    public static final void m1619Surface9VG74zQ(Function0<Unit> onClick, Modifier modifier, Shape shape, long color, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, Indication indication, boolean enabled, String onClickLabel, Role role, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i) {
        Role role2;
        String onClickLabel2;
        boolean enabled2;
        Indication indication2;
        MutableInteractionSource interactionSource2;
        float elevation2;
        BorderStroke border2;
        long contentColor2;
        long color2;
        Shape shape2;
        Modifier modifier2;
        Composer $composer2;
        Role role3;
        String onClickLabel3;
        boolean enabled3;
        Indication indication3;
        MutableInteractionSource interactionSource3;
        float elevation3;
        BorderStroke border3;
        long color3;
        Shape shape3;
        Modifier modifier3;
        int $dirty;
        Modifier modifier4;
        Shape shape4;
        Modifier modifier5;
        int $dirty2;
        long color4;
        BorderStroke border4;
        long color5;
        float elevation4;
        float elevation5;
        MutableInteractionSource interactionSource4;
        MutableInteractionSource interactionSource5;
        Indication indication4;
        boolean enabled4;
        String onClickLabel4;
        Object value$iv$iv;
        int i2;
        int i3;
        int i4;
        Function0<Unit> function0 = onClick;
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i5 = $changed;
        int i6 = $changed1;
        int i7 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer3 = $composer.startRestartGroup(1585925488);
        ComposerKt.sourceInformation($composer3, "C(Surface)P(9,8,12,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,7,6,5,10,11:c#ui.semantics.Role)572@28940L6,573@28982L22,576@29116L39,577@29203L7,*583@29390L7,584@29414L1128:Surface.kt#jmzs0o");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if ((i7 & 1) != 0) {
            $dirty3 |= 6;
        } else if ((i5 & 14) == 0) {
            $dirty3 |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        int i8 = i7 & 2;
        if (i8 != 0) {
            $dirty3 |= 48;
            Modifier modifier6 = modifier;
        } else if ((i5 & 112) == 0) {
            $dirty3 |= $composer3.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier7 = modifier;
        }
        int i9 = i7 & 4;
        int i10 = 128;
        if (i9 != 0) {
            $dirty3 |= 384;
            Shape shape5 = shape;
        } else if ((i5 & 896) == 0) {
            $dirty3 |= $composer3.changed((Object) shape) ? 256 : 128;
        } else {
            Shape shape6 = shape;
        }
        if ((i5 & 7168) == 0) {
            if ((i7 & 8) != 0) {
                long j = color;
            } else if ($composer3.changed(color)) {
                i4 = 2048;
                $dirty3 |= i4;
            }
            i4 = 1024;
            $dirty3 |= i4;
        } else {
            long j2 = color;
        }
        if ((i5 & 57344) == 0) {
            if ((i7 & 16) != 0) {
                long j3 = contentColor;
            } else if ($composer3.changed(contentColor)) {
                i3 = 16384;
                $dirty3 |= i3;
            }
            i3 = 8192;
            $dirty3 |= i3;
        } else {
            long j4 = contentColor;
        }
        int i11 = i7 & 32;
        if (i11 != 0) {
            $dirty3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            BorderStroke borderStroke = border;
        } else if ((i5 & 458752) == 0) {
            $dirty3 |= $composer3.changed((Object) border) ? 131072 : 65536;
        } else {
            BorderStroke borderStroke2 = border;
        }
        int i12 = i7 & 64;
        if (i12 != 0) {
            $dirty3 |= 1572864;
            float f = elevation;
        } else if ((i5 & 3670016) == 0) {
            $dirty3 |= $composer3.changed(elevation) ? 1048576 : 524288;
        } else {
            float f2 = elevation;
        }
        int i13 = i7 & 128;
        if (i13 != 0) {
            $dirty3 |= 12582912;
            MutableInteractionSource mutableInteractionSource = interactionSource;
        } else if ((i5 & 29360128) == 0) {
            $dirty3 |= $composer3.changed((Object) interactionSource) ? 8388608 : 4194304;
        } else {
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        }
        if ((i5 & 234881024) == 0) {
            if ((i7 & 256) != 0) {
                Indication indication5 = indication;
            } else if ($composer3.changed((Object) indication)) {
                i2 = 67108864;
                $dirty3 |= i2;
            }
            i2 = 33554432;
            $dirty3 |= i2;
        } else {
            Indication indication6 = indication;
        }
        int i14 = i7 & 512;
        if (i14 != 0) {
            $dirty3 |= 805306368;
            boolean z = enabled;
        } else if ((i5 & 1879048192) == 0) {
            $dirty3 |= $composer3.changed(enabled) ? 536870912 : 268435456;
        } else {
            boolean z2 = enabled;
        }
        int i15 = i7 & 1024;
        if (i15 != 0) {
            $dirty1 |= 6;
            String str = onClickLabel;
        } else if ((i6 & 14) == 0) {
            $dirty1 |= $composer3.changed((Object) onClickLabel) ? 4 : 2;
        } else {
            String str2 = onClickLabel;
        }
        int i16 = i7 & 2048;
        if (i16 != 0) {
            $dirty1 |= 48;
            Role role4 = role;
        } else if ((i6 & 112) == 0) {
            $dirty1 |= $composer3.changed((Object) role) ? 32 : 16;
        } else {
            Role role5 = role;
        }
        if ((i7 & 4096) != 0) {
            $dirty1 |= 384;
        } else if ((i6 & 896) == 0) {
            if ($composer3.changedInstance(function2)) {
                i10 = 256;
            }
            $dirty1 |= i10;
        }
        int $dirty12 = $dirty1;
        if ((1533916891 & $dirty3) == 306783378 && ($dirty12 & 731) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            shape2 = shape;
            color2 = color;
            contentColor2 = contentColor;
            border2 = border;
            elevation2 = elevation;
            interactionSource2 = interactionSource;
            indication2 = indication;
            enabled2 = enabled;
            onClickLabel2 = onClickLabel;
            role2 = role;
            int i17 = $dirty3;
            int i18 = $dirty12;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if ((i5 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i8 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier;
                }
                if (i9 != 0) {
                    shape4 = RectangleShapeKt.getRectangleShape();
                } else {
                    shape4 = shape;
                }
                if ((i7 & 8) != 0) {
                    $dirty2 = $dirty3 & -7169;
                    modifier5 = modifier4;
                    color4 = MaterialTheme.INSTANCE.getColors($composer3, 6).m1449getSurface0d7_KjU();
                } else {
                    $dirty2 = $dirty3;
                    modifier5 = modifier4;
                    color4 = color;
                }
                if ((i7 & 16) != 0) {
                    contentColor2 = ColorsKt.m1463contentColorForek8zF_U(color4, $composer3, ($dirty2 >> 9) & 14);
                    $dirty2 &= -57345;
                } else {
                    contentColor2 = contentColor;
                }
                if (i11 != 0) {
                    border4 = null;
                } else {
                    border4 = border;
                }
                if (i12 != 0) {
                    color5 = color4;
                    elevation4 = Dp.m5986constructorimpl((float) 0);
                } else {
                    color5 = color4;
                    elevation4 = elevation;
                }
                if (i13 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    elevation5 = elevation4;
                    if (it$iv$iv == Composer.Companion.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        Object obj = it$iv$iv;
                        $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
                    } else {
                        Object obj2 = it$iv$iv;
                        Object it$iv$iv2 = $this$cache$iv$iv;
                        value$iv$iv = obj2;
                    }
                    $composer3.endReplaceableGroup();
                    interactionSource4 = (MutableInteractionSource) value$iv$iv;
                } else {
                    elevation5 = elevation4;
                    interactionSource4 = interactionSource;
                }
                if ((i7 & 256) != 0) {
                    interactionSource5 = interactionSource4;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(IndicationKt.getLocalIndication());
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    indication4 = (Indication) consume;
                    $dirty2 &= -234881025;
                } else {
                    interactionSource5 = interactionSource4;
                    indication4 = indication;
                }
                if (i14 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = enabled;
                }
                if (i15 != 0) {
                    onClickLabel4 = null;
                } else {
                    onClickLabel4 = onClickLabel;
                }
                if (i16 != 0) {
                    interactionSource3 = interactionSource5;
                    elevation3 = elevation5;
                    indication3 = indication4;
                    enabled3 = enabled4;
                    onClickLabel3 = onClickLabel4;
                    role3 = null;
                    border3 = border4;
                    color3 = color5;
                    modifier3 = modifier5;
                    shape3 = shape4;
                    $dirty = $dirty2;
                } else {
                    interactionSource3 = interactionSource5;
                    elevation3 = elevation5;
                    role3 = role;
                    indication3 = indication4;
                    enabled3 = enabled4;
                    onClickLabel3 = onClickLabel4;
                    border3 = border4;
                    color3 = color5;
                    modifier3 = modifier5;
                    shape3 = shape4;
                    $dirty = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i7 & 8) != 0) {
                    $dirty3 &= -7169;
                }
                if ((i7 & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i7 & 256) != 0) {
                    modifier3 = modifier;
                    shape3 = shape;
                    color3 = color;
                    contentColor2 = contentColor;
                    border3 = border;
                    elevation3 = elevation;
                    interactionSource3 = interactionSource;
                    indication3 = indication;
                    enabled3 = enabled;
                    onClickLabel3 = onClickLabel;
                    role3 = role;
                    $dirty = $dirty3 & -234881025;
                } else {
                    modifier3 = modifier;
                    shape3 = shape;
                    color3 = color;
                    contentColor2 = contentColor;
                    border3 = border;
                    elevation3 = elevation;
                    interactionSource3 = interactionSource;
                    indication3 = indication;
                    enabled3 = enabled;
                    onClickLabel3 = onClickLabel;
                    role3 = role;
                    $dirty = $dirty3;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1585925488, $dirty, $dirty12, "androidx.compose.material.Surface (Surface.kt:568)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(ElevationOverlayKt.getLocalAbsoluteElevation());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float absoluteElevation = Dp.m5986constructorimpl(((Dp) consume2).m6000unboximpl() + elevation3);
            SurfaceKt$Surface$13 surfaceKt$Surface$13 = r0;
            int $dirty4 = $dirty;
            SurfaceKt$Surface$13 surfaceKt$Surface$132 = new SurfaceKt$Surface$13(modifier3, shape3, color3, absoluteElevation, $dirty, border3, elevation3, interactionSource3, indication3, enabled3, onClickLabel3, role3, onClick, content, $dirty12);
            $composer2 = $composer3;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(contentColor2)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m5984boximpl(absoluteElevation))}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 149594672, true, surfaceKt$Surface$13), $composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i19 = $dirty4;
            role2 = role3;
            onClickLabel2 = onClickLabel3;
            enabled2 = enabled3;
            indication2 = indication3;
            interactionSource2 = interactionSource3;
            elevation2 = elevation3;
            border2 = border3;
            color2 = color3;
            modifier2 = modifier3;
            shape2 = shape3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new SurfaceKt$Surface$14(onClick, modifier2, shape2, color2, contentColor2, border2, elevation2, interactionSource2, indication2, enabled2, onClickLabel2, role2, content, $changed, $changed1, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: surface-8ww4TTg  reason: not valid java name */
    public static final Modifier m1626surface8ww4TTg(Modifier $this$surface_u2d8ww4TTg, Shape shape, long backgroundColor, BorderStroke border, float elevation) {
        Modifier r0 = ShadowKt.m2832shadows4CzXII$default($this$surface_u2d8ww4TTg, elevation, shape, false, 0, 0, 24, (Object) null);
        Modifier modifier = Modifier.Companion;
        if (border != null) {
            modifier = BorderKt.border(modifier, border, shape);
        }
        return ClipKt.clip(BackgroundKt.m448backgroundbw27NRU(r0.then(modifier), backgroundColor, shape), shape);
    }

    /* access modifiers changed from: private */
    /* renamed from: surfaceColorAtElevation-cq6XJ1M  reason: not valid java name */
    public static final long m1627surfaceColorAtElevationcq6XJ1M(long color, ElevationOverlay elevationOverlay, float absoluteElevation, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(1561611256);
        ComposerKt.sourceInformation($composer, "C(surfaceColorAtElevation)P(1:c#ui.graphics.Color,2,0:c#ui.unit.Dp)634@31048L6,635@31119L31:Surface.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1561611256, $changed, -1, "androidx.compose.material.surfaceColorAtElevation (Surface.kt:629)");
        }
        if (!Color.m3165equalsimpl0(color, MaterialTheme.INSTANCE.getColors($composer, 6).m1449getSurface0d7_KjU()) || elevationOverlay == null) {
            j = color;
        } else {
            j = elevationOverlay.m1504apply7g2Lkgo(color, absoluteElevation, $composer, ($changed & 14) | (($changed >> 3) & 112) | (($changed << 3) & 896));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return j;
    }
}
