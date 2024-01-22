package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.app.FrameMetricsAggregator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0001\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010 \u001aÄ\u0001\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020#2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010%\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010&\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"HorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LeadingIconEndSpacing", "LeadingIconStartSpacing", "SelectedIconContainerSize", "SelectedOverlayOpacity", "", "SurfaceOverlayOpacity", "TrailingIconSpacing", "Chip", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "border", "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ChipColors;", "leadingIcon", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "selected", "Landroidx/compose/material/SelectableChipColors;", "selectedIcon", "trailingIcon", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/SelectableChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
public final class ChipKt {
    /* access modifiers changed from: private */
    public static final float HorizontalPadding = Dp.m5986constructorimpl((float) 12);
    /* access modifiers changed from: private */
    public static final float LeadingIconEndSpacing = Dp.m5986constructorimpl((float) 8);
    /* access modifiers changed from: private */
    public static final float LeadingIconStartSpacing = Dp.m5986constructorimpl((float) 4);
    /* access modifiers changed from: private */
    public static final float SelectedIconContainerSize = Dp.m5986constructorimpl((float) 24);
    private static final float SelectedOverlayOpacity = 0.16f;
    private static final float SurfaceOverlayOpacity = 0.12f;
    /* access modifiers changed from: private */
    public static final float TrailingIconSpacing = Dp.m5986constructorimpl((float) 8);

    /* JADX WARNING: Removed duplicated region for block: B:101:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0319  */
    /* JADX WARNING: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Chip(kotlin.jvm.functions.Function0<kotlin.Unit> r35, androidx.compose.ui.Modifier r36, boolean r37, androidx.compose.foundation.interaction.MutableInteractionSource r38, androidx.compose.ui.graphics.Shape r39, androidx.compose.foundation.BorderStroke r40, androidx.compose.material.ChipColors r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, androidx.compose.runtime.Composer r44, int r45, int r46) {
        /*
            r15 = r35
            r14 = r43
            r13 = r45
            r12 = r46
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -368396408(0xffffffffea0ab788, float:-4.1924616E25)
            r1 = r44
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Chip)P(7,6,3,4,8!2,5)91@4163L39,92@4237L6,94@4354L12,98@4499L21,104@4696L24,99@4525L1787:Chip.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r45
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
            r3 = r36
            goto L_0x0056
        L_0x0041:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0054
            r3 = r36
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0050
            r4 = 32
            goto L_0x0052
        L_0x0050:
            r4 = 16
        L_0x0052:
            r1 = r1 | r4
            goto L_0x0056
        L_0x0054:
            r3 = r36
        L_0x0056:
            r4 = r12 & 4
            if (r4 == 0) goto L_0x005f
            r1 = r1 | 384(0x180, float:5.38E-43)
            r5 = r37
            goto L_0x0074
        L_0x005f:
            r5 = r13 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0072
            r5 = r37
            boolean r6 = r11.changed((boolean) r5)
            if (r6 == 0) goto L_0x006e
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0070
        L_0x006e:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0070:
            r1 = r1 | r6
            goto L_0x0074
        L_0x0072:
            r5 = r37
        L_0x0074:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x007d
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r7 = r38
            goto L_0x0092
        L_0x007d:
            r7 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0090
            r7 = r38
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x008c
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x008e
        L_0x008c:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x008e:
            r1 = r1 | r8
            goto L_0x0092
        L_0x0090:
            r7 = r38
        L_0x0092:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r13
            if (r8 != 0) goto L_0x00ad
            r8 = r12 & 16
            if (r8 != 0) goto L_0x00a7
            r8 = r39
            boolean r9 = r11.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00a9
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ab
        L_0x00a7:
            r8 = r39
        L_0x00a9:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x00ab:
            r1 = r1 | r9
            goto L_0x00af
        L_0x00ad:
            r8 = r39
        L_0x00af:
            r9 = r12 & 32
            if (r9 == 0) goto L_0x00b9
            r10 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r10
            r10 = r40
            goto L_0x00d0
        L_0x00b9:
            r10 = 458752(0x70000, float:6.42848E-40)
            r10 = r10 & r13
            if (r10 != 0) goto L_0x00ce
            r10 = r40
            boolean r16 = r11.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00c9
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cb
        L_0x00c9:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00cb:
            r1 = r1 | r16
            goto L_0x00d0
        L_0x00ce:
            r10 = r40
        L_0x00d0:
            r32 = 3670016(0x380000, float:5.142788E-39)
            r16 = r13 & r32
            if (r16 != 0) goto L_0x00ec
            r16 = r12 & 64
            if (r16 != 0) goto L_0x00e5
            r0 = r41
            boolean r16 = r11.changed((java.lang.Object) r0)
            if (r16 == 0) goto L_0x00e7
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e9
        L_0x00e5:
            r0 = r41
        L_0x00e7:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00e9:
            r1 = r1 | r16
            goto L_0x00ee
        L_0x00ec:
            r0 = r41
        L_0x00ee:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00f9
            r16 = 12582912(0xc00000, float:1.7632415E-38)
            r1 = r1 | r16
            r3 = r42
            goto L_0x0111
        L_0x00f9:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x010f
            r3 = r42
            boolean r16 = r11.changedInstance(r3)
            if (r16 == 0) goto L_0x010a
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010c
        L_0x010a:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x010c:
            r1 = r1 | r16
            goto L_0x0111
        L_0x010f:
            r3 = r42
        L_0x0111:
            r3 = r12 & 256(0x100, float:3.59E-43)
            r33 = 234881024(0xe000000, float:1.5777218E-30)
            if (r3 == 0) goto L_0x011b
            r3 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x0119:
            r1 = r1 | r3
            goto L_0x012b
        L_0x011b:
            r3 = r13 & r33
            if (r3 != 0) goto L_0x012b
            boolean r3 = r11.changedInstance(r14)
            if (r3 == 0) goto L_0x0128
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0119
        L_0x0128:
            r3 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0119
        L_0x012b:
            r3 = 191739611(0xb6db6db, float:4.5782105E-32)
            r3 = r3 & r1
            r5 = 38347922(0x2492492, float:1.4777643E-37)
            if (r3 != r5) goto L_0x0152
            boolean r3 = r11.getSkipping()
            if (r3 != 0) goto L_0x013b
            goto L_0x0152
        L_0x013b:
            r11.skipToGroupEnd()
            r34 = r36
            r22 = r37
            r21 = r41
            r19 = r42
            r27 = r1
            r16 = r7
            r17 = r8
            r18 = r10
            r23 = r11
            goto L_0x0312
        L_0x0152:
            r11.startDefaults()
            r3 = r13 & 1
            r5 = -3670017(0xffffffffffc7ffff, float:NaN)
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x0197
            boolean r3 = r11.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0166
            goto L_0x0197
        L_0x0166:
            r11.skipToGroupEnd()
            r0 = r12 & 16
            if (r0 == 0) goto L_0x016f
            r1 = r1 & r16
        L_0x016f:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x0186
            r0 = r1 & r5
            r9 = r37
            r19 = r42
            r6 = r0
            r16 = r7
            r17 = r8
            r18 = r10
            r10 = r36
            r8 = r41
            goto L_0x0254
        L_0x0186:
            r9 = r37
            r19 = r42
            r6 = r1
            r16 = r7
            r17 = r8
            r18 = r10
            r10 = r36
            r8 = r41
            goto L_0x0254
        L_0x0197:
            if (r2 == 0) goto L_0x019e
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            goto L_0x01a0
        L_0x019e:
            r2 = r36
        L_0x01a0:
            if (r4 == 0) goto L_0x01a4
            r3 = 1
            goto L_0x01a6
        L_0x01a4:
            r3 = r37
        L_0x01a6:
            if (r6 == 0) goto L_0x01eb
            r4 = 0
            r6 = 0
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r5)
            java.lang.String r5 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r5)
            r5 = 0
            r36 = r11
            r17 = 0
            r34 = r2
            java.lang.Object r2 = r36.rememberedValue()
            r18 = 0
            androidx.compose.runtime.Composer$Companion r19 = androidx.compose.runtime.Composer.Companion
            r37 = r3
            java.lang.Object r3 = r19.getEmpty()
            if (r2 != r3) goto L_0x01db
            r3 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r19 = r2
            r2 = r36
            r2.updateRememberedValue(r3)
            goto L_0x01e1
        L_0x01db:
            r19 = r2
            r2 = r36
            r3 = r19
        L_0x01e1:
            r11.endReplaceableGroup()
            r2 = r3
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            r7 = r2
            goto L_0x01ef
        L_0x01eb:
            r34 = r2
            r37 = r3
        L_0x01ef:
            r2 = r12 & 16
            if (r2 == 0) goto L_0x020d
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r3 = 6
            androidx.compose.material.Shapes r2 = r2.getShapes(r11, r3)
            androidx.compose.foundation.shape.CornerBasedShape r2 = r2.getSmall()
            r3 = 50
            androidx.compose.foundation.shape.CornerSize r3 = androidx.compose.foundation.shape.CornerSizeKt.CornerSize((int) r3)
            androidx.compose.foundation.shape.CornerBasedShape r2 = r2.copy(r3)
            androidx.compose.ui.graphics.Shape r2 = (androidx.compose.ui.graphics.Shape) r2
            r1 = r1 & r16
            r8 = r2
        L_0x020d:
            if (r9 == 0) goto L_0x0211
            r2 = 0
            r10 = r2
        L_0x0211:
            r2 = r12 & 64
            if (r2 == 0) goto L_0x0232
            androidx.compose.material.ChipDefaults r16 = androidx.compose.material.ChipDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r30 = 1572864(0x180000, float:2.204052E-39)
            r31 = 63
            r29 = r11
            androidx.compose.material.ChipColors r2 = r16.m1428chipColors5tl4gsc(r17, r19, r21, r23, r25, r27, r29, r30, r31)
            r3 = -3670017(0xffffffffffc7ffff, float:NaN)
            r1 = r1 & r3
            goto L_0x0234
        L_0x0232:
            r2 = r41
        L_0x0234:
            if (r0 == 0) goto L_0x0246
            r0 = 0
            r9 = r37
            r19 = r0
            r6 = r1
            r16 = r7
            r17 = r8
            r18 = r10
            r10 = r34
            r8 = r2
            goto L_0x0254
        L_0x0246:
            r9 = r37
            r19 = r42
            r6 = r1
            r16 = r7
            r17 = r8
            r18 = r10
            r10 = r34
            r8 = r2
        L_0x0254:
            r11.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0266
            r0 = -1
            java.lang.String r1 = "androidx.compose.material.Chip (Chip.kt:87)"
            r2 = -368396408(0xffffffffea0ab788, float:-4.1924616E25)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r6, r0, r1)
        L_0x0266:
            int r0 = r6 >> 6
            r0 = r0 & 14
            int r1 = r6 >> 15
            r1 = r1 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            androidx.compose.runtime.State r20 = r8.contentColor(r9, r11, r0)
            androidx.compose.material.ChipKt$Chip$2 r0 = androidx.compose.material.ChipKt$Chip$2.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = 0
            r2 = 0
            r3 = 1
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r10, r2, r0, r3, r1)
            int r0 = r6 >> 6
            r0 = r0 & 14
            int r2 = r6 >> 15
            r2 = r2 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            androidx.compose.runtime.State r0 = r8.backgroundColor(r9, r11, r0)
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.graphics.Color r0 = (androidx.compose.ui.graphics.Color) r0
            long r4 = r0.m3174unboximpl()
            long r21 = Chip$lambda$1(r20)
            r23 = 1065353216(0x3f800000, float:1.0)
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 14
            r28 = 0
            long r21 = androidx.compose.ui.graphics.Color.m3163copywmQWz5c$default(r21, r23, r24, r25, r26, r27, r28)
            r23 = 0
            androidx.compose.material.ChipKt$Chip$3 r0 = new androidx.compose.material.ChipKt$Chip$3
            r36 = r0
            r37 = r20
            r38 = r19
            r39 = r8
            r40 = r9
            r41 = r6
            r42 = r43
            r36.<init>(r37, r38, r39, r40, r41, r42)
            r2 = 139076687(0x84a244f, float:6.0829844E-34)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r2, r3, r0)
            r24 = r0
            kotlin.jvm.functions.Function2 r24 = (kotlin.jvm.functions.Function2) r24
            r0 = r6 & 14
            r2 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r2
            r2 = r6 & 896(0x380, float:1.256E-42)
            r0 = r0 | r2
            int r2 = r6 >> 3
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r2
            int r2 = r6 << 3
            r2 = r2 & r32
            r0 = r0 | r2
            int r2 = r6 << 15
            r2 = r2 & r33
            r25 = r0 | r2
            r26 = 128(0x80, float:1.794E-43)
            r0 = r35
            r2 = r9
            r3 = r17
            r27 = r6
            r6 = r21
            r21 = r8
            r8 = r18
            r22 = r9
            r9 = r23
            r34 = r10
            r10 = r16
            r23 = r11
            r11 = r24
            r12 = r23
            r13 = r25
            r14 = r26
            androidx.compose.material.SurfaceKt.m1621SurfaceLPr_se0(r0, r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0312
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0312:
            androidx.compose.runtime.ScopeUpdateScope r12 = r23.endRestartGroup()
            if (r12 != 0) goto L_0x0319
            goto L_0x033a
        L_0x0319:
            androidx.compose.material.ChipKt$Chip$4 r13 = new androidx.compose.material.ChipKt$Chip$4
            r0 = r13
            r1 = r35
            r2 = r34
            r3 = r22
            r4 = r16
            r5 = r17
            r6 = r18
            r7 = r21
            r8 = r19
            r9 = r43
            r10 = r45
            r11 = r46
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r12.updateScope(r13)
        L_0x033a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ChipKt.Chip(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.material.ChipColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final long Chip$lambda$1(State<Color> $contentColor$delegate) {
        return ((Color) $contentColor$delegate.getValue()).m3174unboximpl();
    }

    public static final void FilterChip(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, Shape shape, BorderStroke border, SelectableChipColors colors, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> selectedIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int $changed1, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Composer $composer2;
        boolean enabled2;
        SelectableChipColors colors2;
        Function2 trailingIcon2;
        Function2 selectedIcon2;
        Function2 leadingIcon2;
        BorderStroke border2;
        Shape shape2;
        MutableInteractionSource interactionSource2;
        boolean enabled3;
        SelectableChipColors colors3;
        int $dirty;
        Modifier modifier4;
        boolean enabled4;
        boolean enabled5;
        Modifier modifier5;
        MutableInteractionSource interactionSource3;
        Shape shape3;
        BorderStroke border3;
        SelectableChipColors colors4;
        Function2 leadingIcon3;
        Function2 selectedIcon3;
        Object value$iv$iv;
        int i2;
        int i3;
        boolean z = selected;
        Function0<Unit> function0 = onClick;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3 = content;
        int i4 = $changed;
        int i5 = i;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer3 = $composer.startRestartGroup(-1259208246);
        ComposerKt.sourceInformation($composer3, "C(FilterChip)P(8,7,6,3,4,10!2,5,9,11)188@8703L39,189@8777L6,191@8904L18,198@9235L31,205@9473L34,199@9271L4037:Chip.kt#jmzs0o");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if ((i5 & 1) != 0) {
            $dirty2 |= 6;
        } else if ((i4 & 14) == 0) {
            $dirty2 |= $composer3.changed(z) ? 4 : 2;
        }
        if ((i5 & 2) != 0) {
            $dirty2 |= 48;
        } else if ((i4 & 112) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int i6 = i5 & 4;
        if (i6 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if ((i4 & 896) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed((Object) modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i7 = i5 & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            boolean z2 = enabled;
        } else if ((i4 & 7168) == 0) {
            $dirty2 |= $composer3.changed(enabled) ? 2048 : 1024;
        } else {
            boolean z3 = enabled;
        }
        int i8 = i5 & 16;
        if (i8 != 0) {
            $dirty2 |= 24576;
            MutableInteractionSource mutableInteractionSource = interactionSource;
        } else if ((i4 & 57344) == 0) {
            $dirty2 |= $composer3.changed((Object) interactionSource) ? 16384 : 8192;
        } else {
            MutableInteractionSource mutableInteractionSource2 = interactionSource;
        }
        if ((i4 & 458752) == 0) {
            if ((i5 & 32) != 0) {
                Shape shape4 = shape;
            } else if ($composer3.changed((Object) shape)) {
                i3 = 131072;
                $dirty2 |= i3;
            }
            i3 = 65536;
            $dirty2 |= i3;
        } else {
            Shape shape5 = shape;
        }
        int i9 = i5 & 64;
        if (i9 != 0) {
            $dirty2 |= 1572864;
            BorderStroke borderStroke = border;
        } else if ((i4 & 3670016) == 0) {
            $dirty2 |= $composer3.changed((Object) border) ? 1048576 : 524288;
        } else {
            BorderStroke borderStroke2 = border;
        }
        if ((i4 & 29360128) == 0) {
            if ((i5 & 128) != 0) {
                SelectableChipColors selectableChipColors = colors;
            } else if ($composer3.changed((Object) colors)) {
                i2 = 8388608;
                $dirty2 |= i2;
            }
            i2 = 4194304;
            $dirty2 |= i2;
        } else {
            SelectableChipColors selectableChipColors2 = colors;
        }
        int i10 = i5 & 256;
        if (i10 != 0) {
            $dirty2 |= 100663296;
            Function2<? super Composer, ? super Integer, Unit> function2 = leadingIcon;
        } else if ((i4 & 234881024) == 0) {
            $dirty2 |= $composer3.changedInstance(leadingIcon) ? 67108864 : 33554432;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function22 = leadingIcon;
        }
        int i11 = i5 & 512;
        if (i11 != 0) {
            $dirty2 |= 805306368;
            Function2<? super Composer, ? super Integer, Unit> function23 = selectedIcon;
        } else if ((i4 & 1879048192) == 0) {
            $dirty2 |= $composer3.changedInstance(selectedIcon) ? 536870912 : 268435456;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = selectedIcon;
        }
        int i12 = i5 & 1024;
        if (i12 != 0) {
            $dirty1 |= 6;
            Function2<? super Composer, ? super Integer, Unit> function25 = trailingIcon;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changedInstance(trailingIcon) ? 4 : 2;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function26 = trailingIcon;
        }
        if ((i5 & 2048) != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty1 |= $composer3.changedInstance(function3) ? 32 : 16;
        }
        int $dirty12 = $dirty1;
        if ((1533916891 & $dirty2) == 306783378 && ($dirty12 & 91) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            enabled2 = enabled;
            interactionSource2 = interactionSource;
            shape2 = shape;
            border2 = border;
            colors2 = colors;
            leadingIcon2 = leadingIcon;
            selectedIcon2 = selectedIcon;
            trailingIcon2 = trailingIcon;
            int i13 = $dirty2;
            int i14 = $dirty12;
            modifier3 = modifier2;
            $composer2 = $composer3;
        } else {
            $composer3.startDefaults();
            if ((i4 & 1) == 0 || $composer3.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i7 != 0) {
                    enabled4 = true;
                } else {
                    enabled4 = enabled;
                }
                if (i8 != 0) {
                    $composer3.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                    Composer $this$cache$iv$iv = $composer3;
                    modifier5 = modifier4;
                    Object it$iv$iv = $this$cache$iv$iv.rememberedValue();
                    enabled5 = enabled4;
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
                    interactionSource3 = (MutableInteractionSource) value$iv$iv;
                } else {
                    modifier5 = modifier4;
                    enabled5 = enabled4;
                    interactionSource3 = interactionSource;
                }
                if ((i5 & 32) != 0) {
                    shape3 = MaterialTheme.INSTANCE.getShapes($composer3, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    $dirty2 &= -458753;
                } else {
                    shape3 = shape;
                }
                if (i9 != 0) {
                    border3 = null;
                } else {
                    border3 = border;
                }
                if ((i5 & 128) != 0) {
                    colors4 = ChipDefaults.INSTANCE.m1429filterChipColorsJ08w3E(0, 0, 0, 0, 0, 0, 0, 0, 0, $composer3, 805306368, FrameMetricsAggregator.EVERY_DURATION);
                    $dirty2 &= -29360129;
                } else {
                    colors4 = colors;
                }
                if (i10 != 0) {
                    leadingIcon3 = null;
                } else {
                    leadingIcon3 = leadingIcon;
                }
                if (i11 != 0) {
                    selectedIcon3 = null;
                } else {
                    selectedIcon3 = selectedIcon;
                }
                if (i12 != 0) {
                    leadingIcon2 = leadingIcon3;
                    interactionSource2 = interactionSource3;
                    shape2 = shape3;
                    selectedIcon2 = selectedIcon3;
                    trailingIcon2 = null;
                    border2 = border3;
                    colors3 = colors4;
                    modifier2 = modifier5;
                    enabled3 = enabled5;
                    $dirty = $dirty2;
                } else {
                    trailingIcon2 = trailingIcon;
                    leadingIcon2 = leadingIcon3;
                    interactionSource2 = interactionSource3;
                    shape2 = shape3;
                    selectedIcon2 = selectedIcon3;
                    border2 = border3;
                    colors3 = colors4;
                    modifier2 = modifier5;
                    enabled3 = enabled5;
                    $dirty = $dirty2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i5 & 32) != 0) {
                    $dirty2 &= -458753;
                }
                if ((i5 & 128) != 0) {
                    enabled3 = enabled;
                    interactionSource2 = interactionSource;
                    shape2 = shape;
                    border2 = border;
                    colors3 = colors;
                    leadingIcon2 = leadingIcon;
                    selectedIcon2 = selectedIcon;
                    trailingIcon2 = trailingIcon;
                    $dirty = -29360129 & $dirty2;
                } else {
                    enabled3 = enabled;
                    interactionSource2 = interactionSource;
                    shape2 = shape;
                    border2 = border;
                    colors3 = colors;
                    leadingIcon2 = leadingIcon;
                    selectedIcon2 = selectedIcon;
                    trailingIcon2 = trailingIcon;
                    $dirty = $dirty2;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1259208246, $dirty, $dirty12, "androidx.compose.material.FilterChip (Chip.kt:183)");
            }
            State contentColor = colors3.contentColor(enabled3, z, $composer3, (($dirty >> 9) & 14) | (($dirty << 3) & 112) | (($dirty >> 15) & 896));
            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier2, false, ChipKt$FilterChip$2.INSTANCE, 1, (Object) null);
            long r16 = colors3.backgroundColor(enabled3, z, $composer3, (($dirty >> 9) & 14) | (($dirty << 3) & 112) | (($dirty >> 15) & 896)).getValue().m3174unboximpl();
            long r18 = Color.m3163copywmQWz5c$default(contentColor.getValue().m3174unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            ChipKt$FilterChip$3 chipKt$FilterChip$3 = r0;
            int $dirty3 = $dirty;
            colors2 = colors3;
            enabled2 = enabled3;
            modifier3 = modifier2;
            Modifier modifier6 = semantics$default;
            Composer $composer4 = $composer3;
            ChipKt$FilterChip$3 chipKt$FilterChip$32 = new ChipKt$FilterChip$3(contentColor, leadingIcon2, selected, selectedIcon2, trailingIcon2, content, $dirty12, colors2, enabled2, $dirty3);
            int $dirty4 = $dirty3;
            $composer2 = $composer4;
            SurfaceKt.m1622SurfaceNy5ogXk(selected, onClick, modifier6, enabled2, shape2, r16, r18, border2, 0.0f, interactionSource2, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer4, 722126431, true, chipKt$FilterChip$3), $composer4, ($dirty4 & 14) | ($dirty4 & 112) | ($dirty4 & 7168) | (($dirty4 >> 3) & 57344) | (($dirty4 << 3) & 29360128) | (($dirty4 << 15) & 1879048192), 6, 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            int i15 = $dirty4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ChipKt$FilterChip$4(selected, onClick, modifier3, enabled2, interactionSource2, shape2, border2, colors2, leadingIcon2, selectedIcon2, trailingIcon2, content, $changed, $changed1, i));
        }
    }
}
