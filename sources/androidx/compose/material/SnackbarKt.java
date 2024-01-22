package androidx.compose.material;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a3\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001a3\u0010\u0012\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000f2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0011\u001ac\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u0001H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a{\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u00012\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a \u0010&\u001a\u00020\f2\u0011\u0010#\u001a\r\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010'\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\n\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006("}, d2 = {"HeightToFirstLine", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarMinHeightOneLine", "SnackbarMinHeightTwoLines", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "Snackbar", "snackbarData", "Landroidx/compose/material/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "actionColor", "elevation", "Snackbar-sPrSdHI", "(Landroidx/compose/material/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJFLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-7zSek6w", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TextOnlySnackbar", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snackbar.kt */
public final class SnackbarKt {
    /* access modifiers changed from: private */
    public static final float HeightToFirstLine = Dp.m5986constructorimpl((float) 30);
    private static final float HorizontalSpacing = Dp.m5986constructorimpl((float) 16);
    private static final float HorizontalSpacingButtonSide = Dp.m5986constructorimpl((float) 8);
    private static final float LongButtonVerticalOffset = Dp.m5986constructorimpl((float) 12);
    private static final float SeparateButtonExtraY = Dp.m5986constructorimpl((float) 2);
    /* access modifiers changed from: private */
    public static final float SnackbarMinHeightOneLine = Dp.m5986constructorimpl((float) 48);
    /* access modifiers changed from: private */
    public static final float SnackbarMinHeightTwoLines = Dp.m5986constructorimpl((float) 68);
    private static final float SnackbarVerticalPadding = Dp.m5986constructorimpl((float) 6);
    /* access modifiers changed from: private */
    public static final float TextEndExtraSpacing = Dp.m5986constructorimpl((float) 8);

    /* JADX WARNING: Removed duplicated region for block: B:135:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0135  */
    /* renamed from: Snackbar-7zSek6w  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1600Snackbar7zSek6w(androidx.compose.ui.Modifier r27, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, boolean r29, androidx.compose.ui.graphics.Shape r30, long r31, long r33, float r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r13 = r36
            r14 = r38
            r12 = r39
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -558258760(0xffffffffdeb9a5b8, float:-6.6886503E18)
            r1 = r37
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Snackbar)P(6!2,7,2:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.unit.Dp)84@3955L6,85@4015L15,86@4072L6,90@4158L631:Snackbar.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r38
            r2 = r12 & 1
            if (r2 == 0) goto L_0x0024
            r1 = r1 | 6
            r3 = r27
            goto L_0x0037
        L_0x0024:
            r3 = r14 & 14
            if (r3 != 0) goto L_0x0035
            r3 = r27
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0032
            r4 = 4
            goto L_0x0033
        L_0x0032:
            r4 = 2
        L_0x0033:
            r1 = r1 | r4
            goto L_0x0037
        L_0x0035:
            r3 = r27
        L_0x0037:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0040
            r1 = r1 | 48
            r5 = r28
            goto L_0x0055
        L_0x0040:
            r5 = r14 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0053
            r5 = r28
            boolean r6 = r11.changedInstance(r5)
            if (r6 == 0) goto L_0x004f
            r6 = 32
            goto L_0x0051
        L_0x004f:
            r6 = 16
        L_0x0051:
            r1 = r1 | r6
            goto L_0x0055
        L_0x0053:
            r5 = r28
        L_0x0055:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x005e
            r1 = r1 | 384(0x180, float:5.38E-43)
            r7 = r29
            goto L_0x0073
        L_0x005e:
            r7 = r14 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0071
            r7 = r29
            boolean r8 = r11.changed((boolean) r7)
            if (r8 == 0) goto L_0x006d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006f
        L_0x006d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006f:
            r1 = r1 | r8
            goto L_0x0073
        L_0x0071:
            r7 = r29
        L_0x0073:
            r8 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x008c
            r8 = r12 & 8
            if (r8 != 0) goto L_0x0086
            r8 = r30
            boolean r9 = r11.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0088
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x008a
        L_0x0086:
            r8 = r30
        L_0x0088:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x008a:
            r1 = r1 | r9
            goto L_0x008e
        L_0x008c:
            r8 = r30
        L_0x008e:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r14
            if (r9 != 0) goto L_0x00a9
            r9 = r12 & 16
            if (r9 != 0) goto L_0x00a3
            r9 = r31
            boolean r15 = r11.changed((long) r9)
            if (r15 == 0) goto L_0x00a5
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a7
        L_0x00a3:
            r9 = r31
        L_0x00a5:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x00a7:
            r1 = r1 | r15
            goto L_0x00ab
        L_0x00a9:
            r9 = r31
        L_0x00ab:
            r15 = 458752(0x70000, float:6.42848E-40)
            r16 = r14 & r15
            if (r16 != 0) goto L_0x00cb
            r16 = r12 & 32
            if (r16 != 0) goto L_0x00c2
            r37 = r1
            r0 = r33
            boolean r17 = r11.changed((long) r0)
            if (r17 == 0) goto L_0x00c6
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c8
        L_0x00c2:
            r37 = r1
            r0 = r33
        L_0x00c6:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c8:
            r17 = r37 | r17
            goto L_0x00d1
        L_0x00cb:
            r37 = r1
            r0 = r33
            r17 = r37
        L_0x00d1:
            r18 = r12 & 64
            r19 = 1572864(0x180000, float:2.204052E-39)
            if (r18 == 0) goto L_0x00dc
            r17 = r17 | r19
            r15 = r35
            goto L_0x00f4
        L_0x00dc:
            r20 = 3670016(0x380000, float:5.142788E-39)
            r20 = r14 & r20
            if (r20 != 0) goto L_0x00f2
            r15 = r35
            boolean r20 = r11.changed((float) r15)
            if (r20 == 0) goto L_0x00ed
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ef
        L_0x00ed:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00ef:
            r17 = r17 | r20
            goto L_0x00f4
        L_0x00f2:
            r15 = r35
        L_0x00f4:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00fd
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00fa:
            r17 = r17 | r0
            goto L_0x010e
        L_0x00fd:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r14
            if (r0 != 0) goto L_0x010e
            boolean r0 = r11.changedInstance(r13)
            if (r0 == 0) goto L_0x010b
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fa
        L_0x010b:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00fa
        L_0x010e:
            r0 = r17
            r1 = 23967451(0x16db6db, float:4.3661218E-38)
            r1 = r1 & r0
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r1 != r3) goto L_0x0135
            boolean r1 = r11.getSkipping()
            if (r1 != 0) goto L_0x0120
            goto L_0x0135
        L_0x0120:
            r11.skipToGroupEnd()
            r21 = r33
            r24 = r0
            r16 = r5
            r17 = r7
            r18 = r8
            r19 = r9
            r23 = r15
            r15 = r27
            goto L_0x0224
        L_0x0135:
            r11.startDefaults()
            r1 = r14 & 1
            r3 = -458753(0xfffffffffff8ffff, float:NaN)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r1 == 0) goto L_0x0164
            boolean r1 = r11.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0149
            goto L_0x0164
        L_0x0149:
            r11.skipToGroupEnd()
            r1 = r12 & 8
            if (r1 == 0) goto L_0x0152
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x0152:
            r1 = r12 & 16
            if (r1 == 0) goto L_0x0158
            r0 = r0 & r17
        L_0x0158:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x015d
            r0 = r0 & r3
        L_0x015d:
            r1 = r27
            r2 = r33
            r4 = r0
            r0 = r15
            goto L_0x01b9
        L_0x0164:
            if (r2 == 0) goto L_0x016b
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x016d
        L_0x016b:
            r1 = r27
        L_0x016d:
            if (r4 == 0) goto L_0x0171
            r2 = 0
            r5 = r2
        L_0x0171:
            if (r6 == 0) goto L_0x0175
            r2 = 0
            r7 = r2
        L_0x0175:
            r2 = r12 & 8
            r4 = 6
            if (r2 == 0) goto L_0x0189
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r2 = r2.getShapes(r11, r4)
            androidx.compose.foundation.shape.CornerBasedShape r2 = r2.getSmall()
            androidx.compose.ui.graphics.Shape r2 = (androidx.compose.ui.graphics.Shape) r2
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
            r8 = r2
        L_0x0189:
            r2 = r12 & 16
            if (r2 == 0) goto L_0x0195
            androidx.compose.material.SnackbarDefaults r2 = androidx.compose.material.SnackbarDefaults.INSTANCE
            long r9 = r2.getBackgroundColor(r11, r4)
            r0 = r0 & r17
        L_0x0195:
            r2 = r12 & 32
            if (r2 == 0) goto L_0x01a5
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r2 = r2.getColors(r11, r4)
            long r20 = r2.m1449getSurface0d7_KjU()
            r0 = r0 & r3
            goto L_0x01a7
        L_0x01a5:
            r20 = r33
        L_0x01a7:
            if (r18 == 0) goto L_0x01b5
            r2 = 6
            r3 = 0
            float r4 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m5986constructorimpl(r4)
            r4 = r0
            r0 = r2
            r2 = r20
            goto L_0x01b9
        L_0x01b5:
            r4 = r0
            r0 = r15
            r2 = r20
        L_0x01b9:
            r11.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x01cb
            r6 = -1
            java.lang.String r15 = "androidx.compose.material.Snackbar (Snackbar.kt:80)"
            r12 = -558258760(0xffffffffdeb9a5b8, float:-6.6886503E18)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r4, r6, r15)
        L_0x01cb:
            r21 = 0
            androidx.compose.material.SnackbarKt$Snackbar$1 r6 = new androidx.compose.material.SnackbarKt$Snackbar$1
            r6.<init>(r5, r13, r4, r7)
            r12 = -2084221700(0xffffffff83c54cfc, float:-1.1596294E-36)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r6 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r12, r15, r6)
            r23 = r6
            kotlin.jvm.functions.Function2 r23 = (kotlin.jvm.functions.Function2) r23
            r6 = r4 & 14
            r6 = r6 | r19
            int r12 = r4 >> 6
            r12 = r12 & 112(0x70, float:1.57E-43)
            r6 = r6 | r12
            int r12 = r4 >> 6
            r12 = r12 & 896(0x380, float:1.256E-42)
            r6 = r6 | r12
            int r12 = r4 >> 6
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r12
            int r12 = r4 >> 3
            r15 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r15
            r25 = r6 | r12
            r26 = 16
            r15 = r1
            r16 = r8
            r17 = r9
            r19 = r2
            r22 = r0
            r24 = r11
            androidx.compose.material.SurfaceKt.m1620SurfaceFjzlyU(r15, r16, r17, r19, r21, r22, r23, r24, r25, r26)
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x0215
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0215:
            r23 = r0
            r15 = r1
            r21 = r2
            r24 = r4
            r16 = r5
            r17 = r7
            r18 = r8
            r19 = r9
        L_0x0224:
            androidx.compose.runtime.ScopeUpdateScope r12 = r11.endRestartGroup()
            if (r12 != 0) goto L_0x022d
            r26 = r11
            goto L_0x0251
        L_0x022d:
            androidx.compose.material.SnackbarKt$Snackbar$2 r25 = new androidx.compose.material.SnackbarKt$Snackbar$2
            r0 = r25
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r7 = r21
            r9 = r23
            r10 = r36
            r26 = r11
            r11 = r38
            r13 = r12
            r12 = r39
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12)
            r0 = r25
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x0251:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SnackbarKt.m1600Snackbar7zSek6w(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.graphics.Shape, long, long, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: Snackbar-sPrSdHI  reason: not valid java name */
    public static final void m1601SnackbarsPrSdHI(SnackbarData snackbarData, Modifier modifier, boolean actionOnNewLine, Shape shape, long backgroundColor, long contentColor, long actionColor, float elevation, Composer $composer, int $changed, int i) {
        boolean z;
        Shape shape2;
        long contentColor2;
        long actionColor2;
        float elevation2;
        long actionColor3;
        long contentColor3;
        long backgroundColor2;
        Shape shape3;
        boolean actionOnNewLine2;
        Modifier modifier2;
        long actionColor4;
        Shape shape4;
        float elevation3;
        boolean actionOnNewLine3;
        Modifier modifier3;
        long actionColor5;
        Function2 actionComposable;
        long backgroundColor3;
        long actionColor6;
        int i2;
        int i3;
        int i4;
        int i5;
        SnackbarData snackbarData2 = snackbarData;
        int i6 = $changed;
        int i7 = i;
        Intrinsics.checkNotNullParameter(snackbarData2, "snackbarData");
        Composer $composer2 = $composer.startRestartGroup(258660814);
        ComposerKt.sourceInformation($composer2, "C(Snackbar)P(7,5,1,6,2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,4:c#ui.unit.Dp)155@7132L6,156@7192L15,157@7249L6,158@7307L18,173@7784L320:Snackbar.kt#jmzs0o");
        int $dirty = $changed;
        if ((i7 & 1) != 0) {
            $dirty |= 6;
        } else if ((i6 & 14) == 0) {
            $dirty |= $composer2.changed((Object) snackbarData2) ? 4 : 2;
        }
        int i8 = i7 & 2;
        if (i8 != 0) {
            $dirty |= 48;
            Modifier modifier4 = modifier;
        } else if ((i6 & 112) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier5 = modifier;
        }
        int i9 = i7 & 4;
        if (i9 != 0) {
            $dirty |= 384;
            z = actionOnNewLine;
        } else if ((i6 & 896) == 0) {
            z = actionOnNewLine;
            $dirty |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = actionOnNewLine;
        }
        if ((i6 & 7168) == 0) {
            if ((i7 & 8) == 0) {
                shape2 = shape;
                if ($composer2.changed((Object) shape2)) {
                    i5 = 2048;
                    $dirty |= i5;
                }
            } else {
                shape2 = shape;
            }
            i5 = 1024;
            $dirty |= i5;
        } else {
            shape2 = shape;
        }
        if ((i6 & 57344) == 0) {
            if ((i7 & 16) != 0) {
                long j = backgroundColor;
            } else if ($composer2.changed(backgroundColor)) {
                i4 = 16384;
                $dirty |= i4;
            }
            i4 = 8192;
            $dirty |= i4;
        } else {
            long j2 = backgroundColor;
        }
        if ((i6 & 458752) == 0) {
            if ((i7 & 32) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i3 = 131072;
                    $dirty |= i3;
                }
            } else {
                contentColor2 = contentColor;
            }
            i3 = 65536;
            $dirty |= i3;
        } else {
            contentColor2 = contentColor;
        }
        if ((i6 & 3670016) == 0) {
            if ((i7 & 64) == 0) {
                actionColor2 = actionColor;
                if ($composer2.changed(actionColor2)) {
                    i2 = 1048576;
                    $dirty |= i2;
                }
            } else {
                actionColor2 = actionColor;
            }
            i2 = 524288;
            $dirty |= i2;
        } else {
            actionColor2 = actionColor;
        }
        int i10 = i7 & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
            float f = elevation;
        } else if ((i6 & 29360128) == 0) {
            $dirty |= $composer2.changed(elevation) ? 8388608 : 4194304;
        } else {
            float f2 = elevation;
        }
        if (($dirty & 23967451) != 4793490 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i6 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i8 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i9 != 0) {
                    actionOnNewLine3 = false;
                } else {
                    actionOnNewLine3 = z;
                }
                if ((i7 & 8) != 0) {
                    shape4 = MaterialTheme.INSTANCE.getShapes($composer2, 6).getSmall();
                    $dirty &= -7169;
                } else {
                    shape4 = shape2;
                }
                if ((i7 & 16) != 0) {
                    backgroundColor3 = SnackbarDefaults.INSTANCE.getBackgroundColor($composer2, 6);
                    $dirty &= -57345;
                } else {
                    backgroundColor3 = backgroundColor;
                }
                if ((i7 & 32) != 0) {
                    contentColor2 = MaterialTheme.INSTANCE.getColors($composer2, 6).m1449getSurface0d7_KjU();
                    $dirty &= -458753;
                }
                if ((i7 & 64) != 0) {
                    actionColor6 = SnackbarDefaults.INSTANCE.getPrimaryActionColor($composer2, 6);
                    $dirty &= -3670017;
                } else {
                    actionColor6 = actionColor2;
                }
                if (i10 != 0) {
                    elevation3 = Dp.m5986constructorimpl((float) 6);
                    actionColor2 = actionColor6;
                    actionColor4 = backgroundColor3;
                } else {
                    elevation3 = elevation;
                    actionColor2 = actionColor6;
                    actionColor4 = backgroundColor3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i7 & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i7 & 16) != 0) {
                    $dirty &= -57345;
                }
                if ((i7 & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i7 & 64) != 0) {
                    elevation3 = elevation;
                    $dirty &= -3670017;
                    actionOnNewLine3 = z;
                    shape4 = shape2;
                    modifier3 = modifier;
                    actionColor4 = backgroundColor;
                } else {
                    modifier3 = modifier;
                    elevation3 = elevation;
                    actionOnNewLine3 = z;
                    shape4 = shape2;
                    actionColor4 = backgroundColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(258660814, $dirty, -1, "androidx.compose.material.Snackbar (Snackbar.kt:151)");
            }
            String actionLabel = snackbarData.getActionLabel();
            if (actionLabel != null) {
                actionColor5 = actionColor2;
                actionComposable = ComposableLambdaKt.composableLambda($composer2, 1843479216, true, new SnackbarKt$Snackbar$actionComposable$1(actionColor2, $dirty, snackbarData, actionLabel));
            } else {
                actionColor5 = actionColor2;
                actionComposable = null;
            }
            m1600Snackbar7zSek6w(PaddingKt.m760padding3ABfNKs(modifier3, Dp.m5986constructorimpl((float) 12)), actionComposable, actionOnNewLine3, shape4, actionColor4, contentColor2, elevation3, ComposableLambdaKt.composableLambda($composer2, -261845785, true, new SnackbarKt$Snackbar$3(snackbarData2)), $composer2, ($dirty & 896) | 12582912 | ($dirty & 7168) | (57344 & $dirty) | (458752 & $dirty) | (($dirty >> 3) & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            actionColor3 = actionColor5;
            modifier2 = modifier3;
            int i11 = $dirty;
            actionOnNewLine2 = actionOnNewLine3;
            elevation2 = elevation3;
            shape3 = shape4;
            backgroundColor2 = actionColor4;
            contentColor3 = contentColor2;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            backgroundColor2 = backgroundColor;
            elevation2 = elevation;
            int i12 = $dirty;
            actionOnNewLine2 = z;
            shape3 = shape2;
            actionColor3 = actionColor2;
            contentColor3 = contentColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new SnackbarKt$Snackbar$4(snackbarData, modifier2, actionOnNewLine2, shape3, backgroundColor2, contentColor3, actionColor3, elevation2, $changed, i));
    }

    /* access modifiers changed from: private */
    public static final void TextOnlySnackbar(Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Function2<? super Composer, ? super Integer, Unit> function2 = content;
        int i = $changed;
        Composer $composer2 = $composer.startRestartGroup(917397959);
        ComposerKt.sourceInformation($composer2, "C(TextOnlySnackbar)236@9927L1207:Snackbar.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if (($dirty & 11) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(917397959, $dirty, -1, "androidx.compose.material.TextOnlySnackbar (Snackbar.kt:235)");
            }
            MeasurePolicy measurePolicy$iv = SnackbarKt$TextOnlySnackbar$2.INSTANCE;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            Modifier modifier$iv = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m2787constructorimpl($composer2);
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            skippableUpdate$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Composer $composer3 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer3, -1987608331, "C237@9944L202:Snackbar.kt#jmzs0o");
            Modifier modifier$iv2 = PaddingKt.m761paddingVpY3zN4(Modifier.Companion, HorizontalSpacing, SnackbarVerticalPadding);
            $composer3.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            Modifier modifier = modifier$iv;
            Density density = density$iv;
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            Alignment alignment = contentAlignment$iv;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            LayoutDirection layoutDirection = layoutDirection$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv = (Density) consume4;
            ViewConfiguration viewConfiguration = viewConfiguration$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume5;
            int i2 = ($changed$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv2);
            Modifier modifier2 = modifier$iv2;
            int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
            Function0<ComposeUiNode> function0 = constructor;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor2);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer3);
            Function0<ComposeUiNode> function02 = constructor2;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer3.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int i3 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer$iv = $composer3;
            int i4 = $changed$iv$iv$iv;
            Density density2 = density$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((6 >> 6) & 112) | 6;
            Composer $composer4 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer4, 1159675981, "C243@10127L9:Snackbar.kt#jmzs0o");
            function2.invoke($composer4, Integer.valueOf($dirty & 14));
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer3.endReplaceableGroup();
            $composer3.endNode();
            $composer3.endReplaceableGroup();
            $composer3.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SnackbarKt$TextOnlySnackbar$3(function2, i));
        }
    }

    /* access modifiers changed from: private */
    public static final void NewLineButtonSnackbar(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> action, Composer $composer, int $changed) {
        Composer $composer2;
        Function0<ComposeUiNode> function0;
        Function2<? super Composer, ? super Integer, Unit> function2 = text;
        Function2<? super Composer, ? super Integer, Unit> function22 = action;
        int i = $changed;
        Composer $composer3 = $composer.startRestartGroup(-1229075900);
        ComposerKt.sourceInformation($composer3, "C(NewLineButtonSnackbar)P(1)274@11262L476:Snackbar.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1229075900, $dirty, -1, "androidx.compose.material.NewLineButtonSnackbar (Snackbar.kt:270)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            float f = HorizontalSpacing;
            float f2 = HorizontalSpacingButtonSide;
            Modifier modifier$iv = PaddingKt.m764paddingqDBjuR0$default(fillMaxWidth$default, f, 0.0f, f2, SeparateButtonExtraY, 2, (Object) null);
            $composer3.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer3, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            String str = "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                function0 = constructor;
                $composer3.createNode(function0);
            } else {
                function0 = constructor;
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Function0<ComposeUiNode> function02 = function0;
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer3);
            Arrangement.Vertical vertical = verticalArrangement$iv;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer3.enableReusing();
            ViewConfiguration viewConfiguration$iv$iv2 = viewConfiguration$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            function3.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            LayoutDirection layoutDirection = layoutDirection$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            Composer $composer4 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer4, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScope $this$NewLineButtonSnackbar_u24lambda_u244 = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            Composer $composer$iv = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer4, 71171629, "C282@11505L171,286@11685L47:Snackbar.kt#jmzs0o");
            int i3 = $changed$iv$iv$iv;
            Density density = density$iv$iv;
            int i4 = ($changed$iv$iv$iv >> 9) & 14;
            String str2 = "C:CompositionLocal.kt#9igjgp";
            String str3 = str;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
            MeasurePolicy measurePolicy$iv2 = measurePolicy$iv;
            Modifier modifier$iv2 = PaddingKt.m764paddingqDBjuR0$default(AlignmentLineKt.m657paddingFromBaselineVpY3zN4(Modifier.Companion, HeightToFirstLine, LongButtonVerticalOffset), 0.0f, 0.0f, f2, 0.0f, 11, (Object) null);
            Composer $composer5 = $composer4;
            $composer5.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer5, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            ViewConfiguration viewConfiguration = viewConfiguration$iv$iv2;
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy = measurePolicy$iv2;
            Alignment.Horizontal horizontal = horizontalAlignment$iv;
            MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer5, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            Alignment alignment = contentAlignment$iv;
            $composer5.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer5, str3);
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, str2);
            Object consume4 = $composer5.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Density density$iv$iv2 = (Density) consume4;
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, str2);
            Object consume5 = $composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer5);
            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, str2);
            Object consume6 = $composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier$iv2);
            Modifier modifier2 = modifier$iv2;
            int $changed$iv$iv$iv2 = ((((6 << 3) & 112) << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = materializerOf2;
            $composer2 = $composer3;
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                $composer5.createNode(constructor2);
            } else {
                $composer5.useNode();
            }
            $composer5.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2787constructorimpl($composer5);
            Function0<ComposeUiNode> function03 = constructor2;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv3, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer5.enableReusing();
            ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv3;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
            function35.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
            $composer5.startReplaceableGroup(2058660585);
            Composer $composer$iv2 = $composer5;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function36 = function35;
            int i5 = $changed$iv$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            int i6 = ((6 >> 6) & 112) | 6;
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i7 = ($changed$iv$iv$iv2 >> 9) & 14;
            Density density2 = density$iv$iv2;
            Composer $composer6 = $composer$iv2;
            ComposerKt.sourceInformationMarkerStart($composer6, 683214577, "C285@11668L6:Snackbar.kt#jmzs0o");
            function2.invoke($composer6, Integer.valueOf($dirty & 14));
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer5.endReplaceableGroup();
            $composer5.endNode();
            $composer5.endReplaceableGroup();
            $composer5.endReplaceableGroup();
            Modifier modifier$iv3 = $this$NewLineButtonSnackbar_u24lambda_u244.align(Modifier.Companion, Alignment.Companion.getEnd());
            $composer5.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer5, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv4 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            ColumnScope columnScope = $this$NewLineButtonSnackbar_u24lambda_u244;
            $composer5.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer5, str3);
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, str2);
            Object consume7 = $composer5.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Density density$iv$iv3 = (Density) consume7;
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, str2);
            Object consume8 = $composer5.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer5);
            LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume8;
            Alignment alignment2 = contentAlignment$iv2;
            ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, str2);
            Object consume9 = $composer5.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ViewConfiguration viewConfiguration$iv$iv4 = (ViewConfiguration) consume9;
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv3);
            Modifier modifier3 = modifier$iv3;
            int $changed$iv$iv$iv3 = ((((0 << 3) & 112) << 9) & 7168) | 6;
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                $composer5.createNode(constructor3);
            } else {
                $composer5.useNode();
            }
            $composer5.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m2787constructorimpl($composer5);
            Function0<ComposeUiNode> function04 = constructor3;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv4, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer5.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer5)), $composer5, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
            $composer5.startReplaceableGroup(2058660585);
            int i8 = ($changed$iv$iv$iv3 >> 9) & 14;
            Composer $composer$iv3 = $composer5;
            int i9 = $changed$iv$iv$iv3;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i10 = ((0 >> 6) & 112) | 6;
            Composer $composer7 = $composer$iv3;
            ComposerKt.sourceInformationMarkerStart($composer7, 683214631, "C286@11722L8:Snackbar.kt#jmzs0o");
            function22.invoke($composer7, Integer.valueOf(($dirty >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer5.endReplaceableGroup();
            $composer5.endNode();
            $composer5.endReplaceableGroup();
            $composer5.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i11 = $changed;
        } else {
            endRestartGroup.updateScope(new SnackbarKt$NewLineButtonSnackbar$2(function2, function22, $changed));
        }
    }

    /* access modifiers changed from: private */
    public static final void OneRowSnackbar(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> action, Composer $composer, int $changed) {
        Composer $composer2;
        Function2<? super Composer, ? super Integer, Unit> function2 = text;
        Function2<? super Composer, ? super Integer, Unit> function22 = action;
        int i = $changed;
        Composer $composer3 = $composer.startRestartGroup(-534813202);
        ComposerKt.sourceInformation($composer3, "C(OneRowSnackbar)P(1)297@11913L2543:Snackbar.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-534813202, $dirty, -1, "androidx.compose.material.OneRowSnackbar (Snackbar.kt:291)");
            }
            Modifier modifier$iv = PaddingKt.m764paddingqDBjuR0$default(Modifier.Companion, HorizontalSpacing, 0.0f, HorizontalSpacingButtonSide, 0.0f, 10, (Object) null);
            MeasurePolicy measurePolicy$iv = new SnackbarKt$OneRowSnackbar$2("action", "text");
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "CC(Layout)P(!1,2)73@2855L7,74@2910L7,75@2969L7,76@2981L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv = ((48 << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m2787constructorimpl($composer3);
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u240$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            function3.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            int i2 = ($changed$iv$iv >> 9) & 14;
            Composer $composer4 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer4, -849178871, "C299@11943L86,300@12042L46:Snackbar.kt#jmzs0o");
            Object obj = "text";
            ViewConfiguration viewConfiguration = viewConfiguration$iv;
            Modifier modifier$iv2 = PaddingKt.m762paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "text"), 0.0f, SnackbarVerticalPadding, 1, (Object) null);
            $composer4.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            Density density = density$iv;
            MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            $composer4.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Alignment alignment = contentAlignment$iv;
            LayoutDirection layoutDirection = layoutDirection$iv;
            Function0<ComposeUiNode> function0 = constructor;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume4 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Density density$iv$iv = (Density) consume4;
            int i3 = $changed$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume5 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume5;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume6 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume6;
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier$iv2);
            Modifier modifier2 = modifier$iv2;
            int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = materializerOf2;
            $composer2 = $composer3;
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                $composer4.createNode(constructor2);
            } else {
                $composer4.useNode();
            }
            $composer4.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer4);
            Function0<ComposeUiNode> function02 = constructor2;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer4.enableReusing();
            ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = function33;
            function34.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer4.startReplaceableGroup(2058660585);
            Composer $composer$iv = $composer4;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
            int i4 = $changed$iv$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            int i5 = ((6 >> 6) & 112) | 6;
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ($changed$iv$iv$iv >> 9) & 14;
            Composer $composer5 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer5, -202240392, "C299@12021L6:Snackbar.kt#jmzs0o");
            function2.invoke($composer5, Integer.valueOf($dirty & 14));
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer4.endReplaceableGroup();
            $composer4.endNode();
            $composer4.endReplaceableGroup();
            $composer4.endReplaceableGroup();
            Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.Companion, "action");
            $composer4.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            Object obj2 = "action";
            $composer4.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume7 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Density density$iv$iv2 = (Density) consume7;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume8 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume8;
            Alignment alignment2 = contentAlignment$iv2;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume9 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume9;
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv3);
            Modifier modifier3 = modifier$iv3;
            int $changed$iv$iv$iv2 = ((((6 << 3) & 112) << 9) & 7168) | 6;
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                $composer4.createNode(constructor3);
            } else {
                $composer4.useNode();
            }
            $composer4.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2787constructorimpl($composer4);
            Function0<ComposeUiNode> function03 = constructor3;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer4.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
            $composer4.startReplaceableGroup(2058660585);
            int i7 = ($changed$iv$iv$iv2 >> 9) & 14;
            Composer $composer$iv2 = $composer4;
            int i8 = $changed$iv$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i9 = ((6 >> 6) & 112) | 6;
            Composer $composer6 = $composer$iv2;
            ComposerKt.sourceInformationMarkerStart($composer6, -202240335, "C300@12078L8:Snackbar.kt#jmzs0o");
            function22.invoke($composer6, Integer.valueOf(($dirty >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer4.endReplaceableGroup();
            $composer4.endNode();
            $composer4.endReplaceableGroup();
            $composer4.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i10 = $changed;
        } else {
            endRestartGroup.updateScope(new SnackbarKt$OneRowSnackbar$3(function2, function22, $changed));
        }
    }
}
