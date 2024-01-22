package androidx.compose.material3;

import androidx.compose.foundation.layout.AlignmentLineKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001ah\u0010\n\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001aj\u0010\u0018\u001a\u00020\u000b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000e2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0013\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0017\u001am\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0014H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0001\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00142\b\b\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0007\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\b\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\t\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"ContainerMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "HeightToFirstLine", "HorizontalSpacing", "HorizontalSpacingButtonSide", "LongButtonVerticalOffset", "SeparateButtonExtraY", "SnackbarVerticalPadding", "TextEndExtraSpacing", "NewLineButtonSnackbar", "", "text", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "action", "dismissAction", "actionTextStyle", "Landroidx/compose/ui/text/TextStyle;", "actionContentColor", "Landroidx/compose/ui/graphics/Color;", "dismissActionContentColor", "NewLineButtonSnackbar-kKq0p4A", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JJLandroidx/compose/runtime/Composer;I)V", "OneRowSnackbar", "actionTextColor", "dismissActionColor", "OneRowSnackbar-kKq0p4A", "Snackbar", "snackbarData", "Landroidx/compose/material3/SnackbarData;", "modifier", "Landroidx/compose/ui/Modifier;", "actionOnNewLine", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "contentColor", "actionColor", "Snackbar-sDKtq54", "(Landroidx/compose/material3/SnackbarData;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJJJJLandroidx/compose/runtime/Composer;II)V", "content", "Snackbar-eQBnUkQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/graphics/Shape;JJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Snackbar.kt */
public final class SnackbarKt {
    /* access modifiers changed from: private */
    public static final float ContainerMaxWidth = Dp.m5986constructorimpl((float) 600);
    /* access modifiers changed from: private */
    public static final float HeightToFirstLine = Dp.m5986constructorimpl((float) 30);
    private static final float HorizontalSpacing = Dp.m5986constructorimpl((float) 16);
    private static final float HorizontalSpacingButtonSide = Dp.m5986constructorimpl((float) 8);
    private static final float LongButtonVerticalOffset = Dp.m5986constructorimpl((float) 12);
    private static final float SeparateButtonExtraY = Dp.m5986constructorimpl((float) 2);
    private static final float SnackbarVerticalPadding = Dp.m5986constructorimpl((float) 6);
    /* access modifiers changed from: private */
    public static final float TextEndExtraSpacing = Dp.m5986constructorimpl((float) 8);

    /* JADX WARNING: Removed duplicated region for block: B:113:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x02cf  */
    /* renamed from: Snackbar-eQBnUkQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2067SnackbareQBnUkQ(androidx.compose.ui.Modifier r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, boolean r37, androidx.compose.ui.graphics.Shape r38, long r39, long r41, long r43, long r45, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, int r49, int r50) {
        /*
            r15 = r47
            r14 = r49
            r12 = r50
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = -1235788955(0xffffffffb6575b65, float:-3.2090695E-6)
            r1 = r48
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Snackbar)P(8!1,6,2,9,3:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,7:c#ui.graphics.Color)96@4568L5,97@4620L5,98@4670L12,99@4733L18,100@4809L25,103@4880L1420:Snackbar.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r49
            r2 = r12 & 1
            if (r2 == 0) goto L_0x0024
            r1 = r1 | 6
            r3 = r34
            goto L_0x0037
        L_0x0024:
            r3 = r14 & 14
            if (r3 != 0) goto L_0x0035
            r3 = r34
            boolean r4 = r13.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0032
            r4 = 4
            goto L_0x0033
        L_0x0032:
            r4 = 2
        L_0x0033:
            r1 = r1 | r4
            goto L_0x0037
        L_0x0035:
            r3 = r34
        L_0x0037:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x0040
            r1 = r1 | 48
            r5 = r35
            goto L_0x0055
        L_0x0040:
            r5 = r14 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0053
            r5 = r35
            boolean r6 = r13.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004f
            r6 = 32
            goto L_0x0051
        L_0x004f:
            r6 = 16
        L_0x0051:
            r1 = r1 | r6
            goto L_0x0055
        L_0x0053:
            r5 = r35
        L_0x0055:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x005e
            r1 = r1 | 384(0x180, float:5.38E-43)
            r7 = r36
            goto L_0x0073
        L_0x005e:
            r7 = r14 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0071
            r7 = r36
            boolean r8 = r13.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x006d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006f
        L_0x006d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006f:
            r1 = r1 | r8
            goto L_0x0073
        L_0x0071:
            r7 = r36
        L_0x0073:
            r8 = r12 & 8
            if (r8 == 0) goto L_0x007c
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r9 = r37
            goto L_0x0091
        L_0x007c:
            r9 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x008f
            r9 = r37
            boolean r10 = r13.changed((boolean) r9)
            if (r10 == 0) goto L_0x008b
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x008d
        L_0x008b:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x008d:
            r1 = r1 | r10
            goto L_0x0091
        L_0x008f:
            r9 = r37
        L_0x0091:
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r14
            if (r10 != 0) goto L_0x00ac
            r10 = r12 & 16
            if (r10 != 0) goto L_0x00a6
            r10 = r38
            boolean r11 = r13.changed((java.lang.Object) r10)
            if (r11 == 0) goto L_0x00a8
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00aa
        L_0x00a6:
            r10 = r38
        L_0x00a8:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x00aa:
            r1 = r1 | r11
            goto L_0x00ae
        L_0x00ac:
            r10 = r38
        L_0x00ae:
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r14
            if (r11 != 0) goto L_0x00cd
            r11 = r12 & 32
            if (r11 != 0) goto L_0x00c4
            r48 = r1
            r0 = r39
            boolean r16 = r13.changed((long) r0)
            if (r16 == 0) goto L_0x00c8
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ca
        L_0x00c4:
            r48 = r1
            r0 = r39
        L_0x00c8:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00ca:
            r16 = r48 | r16
            goto L_0x00d3
        L_0x00cd:
            r48 = r1
            r0 = r39
            r16 = r48
        L_0x00d3:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r14 & r17
            if (r17 != 0) goto L_0x00ef
            r17 = r12 & 64
            if (r17 != 0) goto L_0x00e8
            r11 = r41
            boolean r17 = r13.changed((long) r11)
            if (r17 == 0) goto L_0x00ea
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ec
        L_0x00e8:
            r11 = r41
        L_0x00ea:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00ec:
            r16 = r16 | r17
            goto L_0x00f1
        L_0x00ef:
            r11 = r41
        L_0x00f1:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r14 & r17
            if (r17 != 0) goto L_0x010f
            r12 = r50
            r11 = r12 & 128(0x80, float:1.794E-43)
            if (r11 != 0) goto L_0x0108
            r0 = r43
            boolean r11 = r13.changed((long) r0)
            if (r11 == 0) goto L_0x010a
            r11 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010c
        L_0x0108:
            r0 = r43
        L_0x010a:
            r11 = 4194304(0x400000, float:5.877472E-39)
        L_0x010c:
            r16 = r16 | r11
            goto L_0x0113
        L_0x010f:
            r0 = r43
            r12 = r50
        L_0x0113:
            r11 = 234881024(0xe000000, float:1.5777218E-30)
            r11 = r11 & r14
            if (r11 != 0) goto L_0x012e
            r11 = r12 & 256(0x100, float:3.59E-43)
            if (r11 != 0) goto L_0x0127
            r0 = r45
            boolean r11 = r13.changed((long) r0)
            if (r11 == 0) goto L_0x0129
            r11 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012b
        L_0x0127:
            r0 = r45
        L_0x0129:
            r11 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012b:
            r16 = r16 | r11
            goto L_0x0130
        L_0x012e:
            r0 = r45
        L_0x0130:
            r11 = r12 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0139
            r11 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0136:
            r16 = r16 | r11
            goto L_0x014a
        L_0x0139:
            r11 = 1879048192(0x70000000, float:1.58456325E29)
            r11 = r11 & r14
            if (r11 != 0) goto L_0x014a
            boolean r11 = r13.changed((java.lang.Object) r15)
            if (r11 == 0) goto L_0x0147
            r11 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0136
        L_0x0147:
            r11 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0136
        L_0x014a:
            r11 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r11 = r16 & r11
            r0 = 306783378(0x12492492, float:6.3469493E-28)
            if (r11 != r0) goto L_0x0174
            boolean r0 = r13.getSkipping()
            if (r0 != 0) goto L_0x015b
            goto L_0x0174
        L_0x015b:
            r13.skipToGroupEnd()
            r22 = r39
            r24 = r41
            r26 = r43
            r28 = r45
            r17 = r3
            r18 = r5
            r19 = r7
            r20 = r9
            r21 = r10
            r30 = r16
            goto L_0x02c6
        L_0x0174:
            r13.startDefaults()
            r0 = r14 & 1
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r11 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r17 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            if (r0 == 0) goto L_0x01d3
            boolean r0 = r13.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0191
            goto L_0x01d3
        L_0x0191:
            r13.skipToGroupEnd()
            r0 = r12 & 16
            if (r0 == 0) goto L_0x019a
            r16 = r16 & r19
        L_0x019a:
            r0 = r12 & 32
            if (r0 == 0) goto L_0x01a0
            r16 = r16 & r18
        L_0x01a0:
            r0 = r12 & 64
            if (r0 == 0) goto L_0x01a6
            r16 = r16 & r17
        L_0x01a6:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x01ac
            r16 = r16 & r11
        L_0x01ac:
            r0 = r12 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x01c2
            r0 = r16 & r1
            r18 = r43
            r20 = r45
            r1 = r0
            r0 = r3
            r2 = r5
            r3 = r7
            r4 = r9
            r5 = r10
            r7 = r39
            r9 = r41
            goto L_0x023a
        L_0x01c2:
            r18 = r43
            r20 = r45
            r0 = r3
            r2 = r5
            r3 = r7
            r4 = r9
            r5 = r10
            r1 = r16
            r7 = r39
            r9 = r41
            goto L_0x023a
        L_0x01d3:
            if (r2 == 0) goto L_0x01da
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01db
        L_0x01da:
            r0 = r3
        L_0x01db:
            if (r4 == 0) goto L_0x01df
            r2 = 0
            goto L_0x01e0
        L_0x01df:
            r2 = r5
        L_0x01e0:
            if (r6 == 0) goto L_0x01e4
            r3 = 0
            goto L_0x01e5
        L_0x01e4:
            r3 = r7
        L_0x01e5:
            if (r8 == 0) goto L_0x01e9
            r4 = 0
            goto L_0x01ea
        L_0x01e9:
            r4 = r9
        L_0x01ea:
            r5 = r12 & 16
            r6 = 6
            if (r5 == 0) goto L_0x01f8
            androidx.compose.material3.SnackbarDefaults r5 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            androidx.compose.ui.graphics.Shape r5 = r5.getShape(r13, r6)
            r16 = r16 & r19
            goto L_0x01f9
        L_0x01f8:
            r5 = r10
        L_0x01f9:
            r7 = r12 & 32
            if (r7 == 0) goto L_0x0206
            androidx.compose.material3.SnackbarDefaults r7 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r7 = r7.getColor(r13, r6)
            r16 = r16 & r18
            goto L_0x0208
        L_0x0206:
            r7 = r39
        L_0x0208:
            r9 = r12 & 64
            if (r9 == 0) goto L_0x0215
            androidx.compose.material3.SnackbarDefaults r9 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r9 = r9.getContentColor(r13, r6)
            r16 = r16 & r17
            goto L_0x0217
        L_0x0215:
            r9 = r41
        L_0x0217:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0224
            androidx.compose.material3.SnackbarDefaults r1 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r18 = r1.getActionContentColor(r13, r6)
            r16 = r16 & r11
            goto L_0x0226
        L_0x0224:
            r18 = r43
        L_0x0226:
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0236
            androidx.compose.material3.SnackbarDefaults r1 = androidx.compose.material3.SnackbarDefaults.INSTANCE
            long r20 = r1.getDismissActionContentColor(r13, r6)
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r16 & r1
            goto L_0x023a
        L_0x0236:
            r20 = r45
            r1 = r16
        L_0x023a:
            r13.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x024c
            r6 = -1
            java.lang.String r11 = "androidx.compose.material3.Snackbar (Snackbar.kt:91)"
            r12 = -1235788955(0xffffffffb6575b65, float:-3.2090695E-6)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r1, r6, r11)
        L_0x024c:
            androidx.compose.material3.tokens.SnackbarTokens r11 = androidx.compose.material3.tokens.SnackbarTokens.INSTANCE
            float r11 = r11.m2667getContainerElevationD9Ej5fM()
            androidx.compose.material3.SnackbarKt$Snackbar$1 r12 = new androidx.compose.material3.SnackbarKt$Snackbar$1
            r34 = r12
            r35 = r2
            r36 = r47
            r37 = r3
            r38 = r18
            r40 = r20
            r42 = r1
            r43 = r4
            r34.<init>(r35, r36, r37, r38, r40, r42, r43)
            r6 = -1829663446(0xffffffff92f18d2a, float:-1.5244038E-27)
            r48 = r2
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r6, r2, r12)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r6 = 12779520(0xc30000, float:1.7907922E-38)
            r12 = r1 & 14
            r6 = r6 | r12
            int r12 = r1 >> 9
            r12 = r12 & 112(0x70, float:1.57E-43)
            r6 = r6 | r12
            int r12 = r1 >> 9
            r12 = r12 & 896(0x380, float:1.256E-42)
            r6 = r6 | r12
            int r12 = r1 >> 9
            r12 = r12 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 | r12
            r12 = 80
            r34 = r0
            r35 = r5
            r36 = r7
            r38 = r9
            r16 = 0
            r40 = r16
            r41 = r11
            r11 = 0
            r42 = r11
            r43 = r2
            r44 = r13
            r45 = r6
            r46 = r12
            androidx.compose.material3.SurfaceKt.m2097SurfaceT9BRK9s(r34, r35, r36, r38, r40, r41, r42, r43, r44, r45, r46)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x02b2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02b2:
            r17 = r0
            r30 = r1
            r22 = r7
            r24 = r9
            r26 = r18
            r28 = r20
            r18 = r48
            r19 = r3
            r20 = r4
            r21 = r5
        L_0x02c6:
            androidx.compose.runtime.ScopeUpdateScope r12 = r13.endRestartGroup()
            if (r12 != 0) goto L_0x02cf
            r32 = r13
            goto L_0x02fb
        L_0x02cf:
            androidx.compose.material3.SnackbarKt$Snackbar$2 r31 = new androidx.compose.material3.SnackbarKt$Snackbar$2
            r0 = r31
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r8 = r24
            r10 = r26
            r33 = r12
            r32 = r13
            r12 = r28
            r14 = r47
            r15 = r49
            r16 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r12, r14, r15, r16)
            r0 = r31
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r33
            r1.updateScope(r0)
        L_0x02fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SnackbarKt.m2067SnackbareQBnUkQ(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.graphics.Shape, long, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: Snackbar-sDKtq54  reason: not valid java name */
    public static final void m2068SnackbarsDKtq54(SnackbarData snackbarData, Modifier modifier, boolean actionOnNewLine, Shape shape, long containerColor, long contentColor, long actionColor, long actionContentColor, long dismissActionContentColor, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        boolean z;
        Shape shape2;
        long contentColor2;
        long actionColor2;
        int $dirty;
        long dismissActionContentColor2;
        long actionContentColor2;
        long actionColor3;
        long contentColor3;
        long containerColor2;
        Shape shape3;
        boolean actionOnNewLine2;
        Modifier modifier3;
        long containerColor3;
        Shape shape4;
        boolean actionOnNewLine3;
        Modifier modifier4;
        Function2 actionComposable;
        Function2 dismissActionComposable;
        long actionContentColor3;
        int i2;
        int i3;
        int $dirty2;
        int i4;
        int i5;
        int i6;
        int i7;
        SnackbarData snackbarData2 = snackbarData;
        int i8 = $changed;
        int i9 = i;
        Intrinsics.checkNotNullParameter(snackbarData2, "snackbarData");
        Composer $composer2 = $composer.startRestartGroup(274621471);
        ComposerKt.sourceInformation($composer2, "C(Snackbar)P(8,6,2,7,3:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color)198@9092L5,199@9144L5,200@9194L12,201@9250L11,202@9312L18,203@9388L25,233@10414L456:Snackbar.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i9 & 1) != 0) {
            $dirty3 |= 6;
        } else if ((i8 & 14) == 0) {
            $dirty3 |= $composer2.changed((Object) snackbarData2) ? 4 : 2;
        }
        int i10 = i9 & 2;
        if (i10 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if ((i8 & 112) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed((Object) modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i11 = i9 & 4;
        if (i11 != 0) {
            $dirty3 |= 384;
            z = actionOnNewLine;
        } else if ((i8 & 896) == 0) {
            z = actionOnNewLine;
            $dirty3 |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = actionOnNewLine;
        }
        if ((i8 & 7168) == 0) {
            if ((i9 & 8) == 0) {
                shape2 = shape;
                if ($composer2.changed((Object) shape2)) {
                    i7 = 2048;
                    $dirty3 |= i7;
                }
            } else {
                shape2 = shape;
            }
            i7 = 1024;
            $dirty3 |= i7;
        } else {
            shape2 = shape;
        }
        if ((i8 & 57344) == 0) {
            if ((i9 & 16) != 0) {
                long j = containerColor;
            } else if ($composer2.changed(containerColor)) {
                i6 = 16384;
                $dirty3 |= i6;
            }
            i6 = 8192;
            $dirty3 |= i6;
        } else {
            long j2 = containerColor;
        }
        if ((i8 & 458752) == 0) {
            if ((i9 & 32) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i5 = 131072;
                    $dirty3 |= i5;
                }
            } else {
                contentColor2 = contentColor;
            }
            i5 = 65536;
            $dirty3 |= i5;
        } else {
            contentColor2 = contentColor;
        }
        if ((i8 & 3670016) == 0) {
            if ((i9 & 64) == 0) {
                actionColor2 = actionColor;
                if ($composer2.changed(actionColor2)) {
                    i4 = 1048576;
                    $dirty3 |= i4;
                }
            } else {
                actionColor2 = actionColor;
            }
            i4 = 524288;
            $dirty3 |= i4;
        } else {
            actionColor2 = actionColor;
        }
        if ((i8 & 29360128) == 0) {
            if ((i9 & 128) == 0) {
                $dirty2 = $dirty3;
                if ($composer2.changed(actionContentColor)) {
                    i3 = 8388608;
                    $dirty = $dirty2 | i3;
                }
            } else {
                $dirty2 = $dirty3;
                long j3 = actionContentColor;
            }
            i3 = 4194304;
            $dirty = $dirty2 | i3;
        } else {
            $dirty = $dirty3;
            long j4 = actionContentColor;
        }
        if ((i8 & 234881024) == 0) {
            if ((i9 & 256) != 0) {
                long j5 = dismissActionContentColor;
            } else if ($composer2.changed(dismissActionContentColor)) {
                i2 = 67108864;
                $dirty |= i2;
            }
            i2 = 33554432;
            $dirty |= i2;
        } else {
            long j6 = dismissActionContentColor;
        }
        int $dirty4 = $dirty;
        if (($dirty4 & 191739611) != 38347922 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i8 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i10 != 0) {
                    modifier4 = Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i11 != 0) {
                    actionOnNewLine3 = false;
                } else {
                    actionOnNewLine3 = z;
                }
                if ((i9 & 8) != 0) {
                    shape4 = SnackbarDefaults.INSTANCE.getShape($composer2, 6);
                    $dirty4 &= -7169;
                } else {
                    shape4 = shape2;
                }
                if ((i9 & 16) != 0) {
                    containerColor3 = SnackbarDefaults.INSTANCE.getColor($composer2, 6);
                    $dirty4 &= -57345;
                } else {
                    containerColor3 = containerColor;
                }
                if ((i9 & 32) != 0) {
                    contentColor2 = SnackbarDefaults.INSTANCE.getContentColor($composer2, 6);
                    $dirty4 &= -458753;
                }
                if ((i9 & 64) != 0) {
                    actionColor2 = SnackbarDefaults.INSTANCE.getActionColor($composer2, 6);
                    $dirty4 &= -3670017;
                }
                if ((i9 & 128) != 0) {
                    actionContentColor3 = SnackbarDefaults.INSTANCE.getActionContentColor($composer2, 6);
                    $dirty4 &= -29360129;
                } else {
                    actionContentColor3 = actionContentColor;
                }
                if ((i9 & 256) != 0) {
                    $dirty4 = -234881025 & $dirty4;
                    actionContentColor2 = actionContentColor3;
                    dismissActionContentColor2 = SnackbarDefaults.INSTANCE.getDismissActionContentColor($composer2, 6);
                } else {
                    dismissActionContentColor2 = dismissActionContentColor;
                    actionContentColor2 = actionContentColor3;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i9 & 8) != 0) {
                    $dirty4 &= -7169;
                }
                if ((i9 & 16) != 0) {
                    $dirty4 &= -57345;
                }
                if ((i9 & 32) != 0) {
                    $dirty4 &= -458753;
                }
                if ((i9 & 64) != 0) {
                    $dirty4 &= -3670017;
                }
                if ((i9 & 128) != 0) {
                    $dirty4 &= -29360129;
                }
                if ((i9 & 256) != 0) {
                    actionContentColor2 = actionContentColor;
                    dismissActionContentColor2 = dismissActionContentColor;
                    $dirty4 = -234881025 & $dirty4;
                    modifier4 = modifier2;
                    actionOnNewLine3 = z;
                    shape4 = shape2;
                    containerColor3 = containerColor;
                } else {
                    actionContentColor2 = actionContentColor;
                    dismissActionContentColor2 = dismissActionContentColor;
                    modifier4 = modifier2;
                    actionOnNewLine3 = z;
                    shape4 = shape2;
                    containerColor3 = containerColor;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(274621471, $dirty4, -1, "androidx.compose.material3.Snackbar (Snackbar.kt:194)");
            }
            String actionLabel = snackbarData.getVisuals().getActionLabel();
            if (actionLabel != null) {
                String str = actionLabel;
                actionComposable = ComposableLambdaKt.composableLambda($composer2, -1378313599, true, new SnackbarKt$Snackbar$actionComposable$1(actionColor2, $dirty4, snackbarData, actionLabel));
            } else {
                Function2 function2 = null;
                actionComposable = null;
            }
            if (snackbarData.getVisuals().getWithDismissAction()) {
                dismissActionComposable = ComposableLambdaKt.composableLambda($composer2, -1812633777, true, new SnackbarKt$Snackbar$dismissActionComposable$1(snackbarData2, $dirty4));
            } else {
                Function2 function22 = null;
                dismissActionComposable = null;
            }
            m2067SnackbareQBnUkQ(PaddingKt.m760padding3ABfNKs(modifier4, Dp.m5986constructorimpl((float) 12)), actionComposable, dismissActionComposable, actionOnNewLine3, shape4, containerColor3, contentColor2, actionContentColor2, dismissActionContentColor2, ComposableLambdaKt.composableLambda($composer2, -1266389126, true, new SnackbarKt$Snackbar$3(snackbarData2)), $composer2, (($dirty4 << 3) & 7168) | 805306368 | (($dirty4 << 3) & 57344) | (($dirty4 << 3) & 458752) | (($dirty4 << 3) & 3670016) | ($dirty4 & 29360128) | ($dirty4 & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            actionOnNewLine2 = actionOnNewLine3;
            shape3 = shape4;
            containerColor2 = containerColor3;
            contentColor3 = contentColor2;
            actionColor3 = actionColor2;
            int i12 = $dirty4;
        } else {
            $composer2.skipToGroupEnd();
            containerColor2 = containerColor;
            actionContentColor2 = actionContentColor;
            dismissActionContentColor2 = dismissActionContentColor;
            modifier3 = modifier2;
            actionOnNewLine2 = z;
            shape3 = shape2;
            contentColor3 = contentColor2;
            actionColor3 = actionColor2;
            int i13 = $dirty4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new SnackbarKt$Snackbar$4(snackbarData, modifier3, actionOnNewLine2, shape3, containerColor2, contentColor3, actionColor3, actionContentColor2, dismissActionContentColor2, $changed, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: NewLineButtonSnackbar-kKq0p4A  reason: not valid java name */
    public static final void m2065NewLineButtonSnackbarkKq0p4A(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> action, Function2<? super Composer, ? super Integer, Unit> dismissAction, TextStyle actionTextStyle, long actionContentColor, long dismissActionContentColor, Composer $composer, int $changed) {
        Composer $composer2;
        Composer $composer$iv;
        Function2<? super Composer, ? super Integer, Unit> function2 = text;
        Function2<? super Composer, ? super Integer, Unit> function22 = action;
        Function2<? super Composer, ? super Integer, Unit> function23 = dismissAction;
        TextStyle textStyle = actionTextStyle;
        int i = $changed;
        Composer $composer3 = $composer.startRestartGroup(-1332496681);
        ComposerKt.sourceInformation($composer3, "C(NewLineButtonSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)256@11145L1173:Snackbar.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer3.changed((Object) function2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer3.changed((Object) function22) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer3.changed((Object) function23) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer3.changed((Object) textStyle) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            $dirty |= $composer3.changed(actionContentColor) ? 16384 : 8192;
        } else {
            long j = actionContentColor;
        }
        if ((458752 & i) == 0) {
            $dirty |= $composer3.changed(dismissActionContentColor) ? 131072 : 65536;
        } else {
            long j2 = dismissActionContentColor;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1332496681, $dirty2, -1, "androidx.compose.material3.NewLineButtonSnackbar (Snackbar.kt:248)");
            }
            Modifier modifier$iv = PaddingKt.m764paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(SizeKt.m837widthInVpY3zN4$default(Modifier.Companion, 0.0f, ContainerMaxWidth, 1, (Object) null), 0.0f, 1, (Object) null), HorizontalSpacing, 0.0f, 0.0f, SeparateButtonExtraY, 6, (Object) null);
            $composer3.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer3, "C(Column)P(2,3,1)77@3880L61,78@3946L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            Alignment.Horizontal horizontal = horizontalAlignment$iv;
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            Arrangement.Vertical vertical = verticalArrangement$iv;
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
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier = modifier$iv;
            int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2787constructorimpl($composer3);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer3.enableReusing();
            Density density = density$iv$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            function32.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int $changed$iv = ($changed$iv$iv$iv >> 9) & 14;
            int i2 = $changed$iv$iv$iv;
            Composer $composer$iv2 = $composer3;
            $composer$iv2.startReplaceableGroup(-1163856341);
            ComposerKt.sourceInformation($composer$iv2, "C79@3994L9:Column.kt#2w3rfo");
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
            if (($changed$iv & 11) != 2 || !$composer$iv2.getSkipping()) {
                int $changed2 = ((6 >> 6) & 112) | 6;
                ColumnScope $this$NewLineButtonSnackbar_kKq0p4A_u24lambda_u2d3 = ColumnScopeInstance.INSTANCE;
                MeasurePolicy measurePolicy = measurePolicy$iv;
                Composer $composer4 = $composer$iv2;
                $composer4.startReplaceableGroup(-363148767);
                ComposerKt.sourceInformation($composer4, "C266@11452L171,271@11633L679:Snackbar.kt#uh7d8r");
                int $dirty3 = $changed2;
                if (($changed2 & 14) == 0) {
                    $dirty3 |= $composer4.changed((Object) $this$NewLineButtonSnackbar_kKq0p4A_u24lambda_u2d3) ? 4 : 2;
                }
                LayoutDirection layoutDirection = layoutDirection$iv$iv;
                int i3 = $dirty3;
                if (($dirty3 & 91) != 18 || !$composer4.getSkipping()) {
                    ViewConfiguration viewConfiguration = viewConfiguration$iv$iv;
                    Modifier r39 = AlignmentLineKt.m657paddingFromBaselineVpY3zN4(Modifier.Companion, HeightToFirstLine, LongButtonVerticalOffset);
                    float f = HorizontalSpacingButtonSide;
                    Modifier modifier$iv2 = PaddingKt.m764paddingqDBjuR0$default(r39, 0.0f, 0.0f, f, 0.0f, 11, (Object) null);
                    float f2 = f;
                    $composer4.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    int i4 = $changed2;
                    MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    Alignment alignment = contentAlignment$iv;
                    $composer4.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume4 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Density density$iv$iv2 = (Density) consume4;
                    int i5 = $changed$iv;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume5 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                    $composer2 = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume6 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier$iv2);
                    Modifier modifier2 = modifier$iv2;
                    int $changed$iv$iv$iv2 = ((((6 << 3) & 112) << 9) & 7168) | 6;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = materializerOf2;
                    $composer$iv = $composer$iv2;
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
                    Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2787constructorimpl($composer4);
                    Function0<ComposeUiNode> function02 = constructor2;
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.Companion.getSetDensity());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.Companion.getSetLayoutDirection());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.Companion.getSetViewConfiguration());
                    $composer4.enableReusing();
                    Density density2 = density$iv$iv2;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
                    function35.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                    $composer4.startReplaceableGroup(2058660585);
                    int $changed$iv2 = ($changed$iv$iv$iv2 >> 9) & 14;
                    Composer $composer$iv3 = $composer4;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function36 = function35;
                    $composer$iv3.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer$iv3, "C72@3384L9:Box.kt#2w3rfo");
                    int i6 = $changed$iv2;
                    if (($changed$iv2 & 11) != 2 || !$composer$iv3.getSkipping()) {
                        int $changed3 = ((6 >> 6) & 112) | 6;
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i7 = $changed$iv$iv$iv2;
                        Composer $composer5 = $composer$iv3;
                        $composer5.startReplaceableGroup(74621659);
                        ComposerKt.sourceInformation($composer5, "C269@11615L6:Snackbar.kt#uh7d8r");
                        int i8 = $changed3;
                        if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                            function2.invoke($composer5, Integer.valueOf($dirty2 & 14));
                        } else {
                            $composer5.skipToGroupEnd();
                        }
                        $composer5.endReplaceableGroup();
                    } else {
                        $composer$iv3.skipToGroupEnd();
                        int i9 = $changed$iv$iv$iv2;
                    }
                    $composer$iv3.endReplaceableGroup();
                    $composer4.endReplaceableGroup();
                    $composer4.endNode();
                    $composer4.endReplaceableGroup();
                    $composer4.endReplaceableGroup();
                    Modifier modifier$iv3 = PaddingKt.m764paddingqDBjuR0$default($this$NewLineButtonSnackbar_kKq0p4A_u24lambda_u2d3.align(Modifier.Companion, Alignment.Companion.getEnd()), 0.0f, 0.0f, function23 == null ? f2 : Dp.m5986constructorimpl((float) 0), 0.0f, 11, (Object) null);
                    $composer4.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv3 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv2, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    $composer4.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ColumnScope columnScope = $this$NewLineButtonSnackbar_kKq0p4A_u24lambda_u2d3;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume7 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Density density$iv$iv3 = (Density) consume7;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume8 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume8;
                    Alignment alignment2 = contentAlignment$iv2;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume9 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume9;
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(modifier$iv3);
                    Modifier modifier3 = modifier$iv3;
                    int $changed$iv$iv$iv3 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function37 = materializerOf3;
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
                    Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m2787constructorimpl($composer4);
                    Function0<ComposeUiNode> function03 = constructor3;
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.Companion.getSetDensity());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.Companion.getSetLayoutDirection());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.Companion.getSetViewConfiguration());
                    $composer4.enableReusing();
                    Density density3 = density$iv$iv3;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function38 = function37;
                    function38.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
                    $composer4.startReplaceableGroup(2058660585);
                    int $changed$iv3 = ($changed$iv$iv$iv3 >> 9) & 14;
                    Composer $composer$iv4 = $composer4;
                    int i10 = $changed$iv$iv$iv3;
                    $composer$iv4.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer$iv4, "C72@3384L9:Box.kt#2w3rfo");
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function39 = function38;
                    if (($changed$iv3 & 11) != 2 || !$composer$iv4.getSkipping()) {
                        int $changed4 = ((0 >> 6) & 112) | 6;
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        LayoutDirection layoutDirection2 = layoutDirection$iv$iv3;
                        Composer $composer6 = $composer$iv4;
                        $composer6.startReplaceableGroup(1640608516);
                        ComposerKt.sourceInformation($composer6, "C275@11801L501:Snackbar.kt#uh7d8r");
                        int i11 = $changed4;
                        if (($changed4 & 81) != 16 || !$composer6.getSkipping()) {
                            $composer6.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation($composer6, "C(Row)P(2,1,3)78@3880L58,79@3943L130:Row.kt#2w3rfo");
                            Modifier modifier$iv4 = Modifier.Companion;
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                            ViewConfiguration viewConfiguration2 = viewConfiguration$iv$iv3;
                            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                            int i12 = $changed$iv3;
                            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer6, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            Arrangement.Horizontal horizontal2 = horizontalArrangement$iv;
                            $composer6.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer6, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume10 = $composer6.consume(CompositionLocalsKt.getLocalDensity());
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            Density density$iv$iv4 = (Density) consume10;
                            Alignment.Vertical vertical2 = verticalAlignment$iv;
                            ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume11 = $composer6.consume(CompositionLocalsKt.getLocalLayoutDirection());
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            LayoutDirection layoutDirection$iv$iv4 = (LayoutDirection) consume11;
                            ComposerKt.sourceInformationMarkerStart($composer6, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume12 = $composer6.consume(CompositionLocalsKt.getLocalViewConfiguration());
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            ViewConfiguration viewConfiguration$iv$iv4 = (ViewConfiguration) consume12;
                            Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv4);
                            Modifier modifier4 = modifier$iv4;
                            int $changed$iv$iv$iv4 = ((((0 << 3) & 112) << 9) & 7168) | 6;
                            MeasurePolicy measurePolicy2 = measurePolicy$iv3;
                            if (!($composer6.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer6.startReusableNode();
                            if ($composer6.getInserting()) {
                                $composer6.createNode(constructor4);
                            } else {
                                $composer6.useNode();
                            }
                            $composer6.disableReusing();
                            Composer $this$Layout_u24lambda_u2d0$iv$iv4 = Updater.m2787constructorimpl($composer6);
                            Function0<ComposeUiNode> function04 = constructor4;
                            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv4, density$iv$iv4, ComposeUiNode.Companion.getSetDensity());
                            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv4, layoutDirection$iv$iv4, ComposeUiNode.Companion.getSetLayoutDirection());
                            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv4, viewConfiguration$iv$iv4, ComposeUiNode.Companion.getSetViewConfiguration());
                            $composer6.enableReusing();
                            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer6)), $composer6, Integer.valueOf(($changed$iv$iv$iv4 >> 3) & 112));
                            $composer6.startReplaceableGroup(2058660585);
                            Composer $composer$iv5 = $composer6;
                            Density density4 = density$iv$iv4;
                            $composer$iv5.startReplaceableGroup(-678309503);
                            ComposerKt.sourceInformation($composer$iv5, "C80@3988L9:Row.kt#2w3rfo");
                            int i13 = $changed$iv$iv$iv4;
                            if ((($changed$iv$iv$iv4 >> 9) & 14 & 11) != 2 || !$composer$iv5.getSkipping()) {
                                int $changed5 = ((0 >> 6) & 112) | 6;
                                RowScope rowScope = RowScopeInstance.INSTANCE;
                                Composer $composer7 = $composer$iv5;
                                $composer7.startReplaceableGroup(-1595822816);
                                ComposerKt.sourceInformation($composer7, "C276@11823L208,282@12097L173:Snackbar.kt#uh7d8r");
                                int i14 = $changed5;
                                if (($changed5 & 81) != 16 || !$composer7.getSkipping()) {
                                    LayoutDirection layoutDirection3 = layoutDirection$iv$iv4;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(actionContentColor)), TextKt.getLocalTextStyle().provides(textStyle)}, function22, $composer7, ($dirty2 & 112) | 8);
                                    if (function23 != null) {
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(dismissActionContentColor))}, function23, $composer7, (($dirty2 >> 3) & 112) | 8);
                                    }
                                } else {
                                    $composer7.skipToGroupEnd();
                                    LayoutDirection layoutDirection4 = layoutDirection$iv$iv4;
                                }
                                $composer7.endReplaceableGroup();
                            } else {
                                $composer$iv5.skipToGroupEnd();
                                LayoutDirection layoutDirection5 = layoutDirection$iv$iv4;
                            }
                            $composer$iv5.endReplaceableGroup();
                            $composer6.endReplaceableGroup();
                            $composer6.endNode();
                            $composer6.endReplaceableGroup();
                            $composer6.endReplaceableGroup();
                        } else {
                            $composer6.skipToGroupEnd();
                            ViewConfiguration viewConfiguration3 = viewConfiguration$iv$iv3;
                            int i15 = $changed$iv3;
                            MeasurePolicy measurePolicy3 = measurePolicy$iv3;
                        }
                        $composer6.endReplaceableGroup();
                    } else {
                        $composer$iv4.skipToGroupEnd();
                        LayoutDirection layoutDirection6 = layoutDirection$iv$iv3;
                        ViewConfiguration viewConfiguration4 = viewConfiguration$iv$iv3;
                        int i16 = $changed$iv3;
                        MeasurePolicy measurePolicy4 = measurePolicy$iv3;
                    }
                    $composer$iv4.endReplaceableGroup();
                    $composer4.endReplaceableGroup();
                    $composer4.endNode();
                    $composer4.endReplaceableGroup();
                    $composer4.endReplaceableGroup();
                } else {
                    $composer4.skipToGroupEnd();
                    $composer$iv = $composer$iv2;
                    ColumnScope columnScope2 = $this$NewLineButtonSnackbar_kKq0p4A_u24lambda_u2d3;
                    ViewConfiguration viewConfiguration5 = viewConfiguration$iv$iv;
                    int i17 = $changed2;
                    int i18 = $changed$iv;
                    $composer2 = $composer3;
                }
                $composer4.endReplaceableGroup();
            } else {
                $composer$iv2.skipToGroupEnd();
                $composer$iv = $composer$iv2;
                MeasurePolicy measurePolicy5 = measurePolicy$iv;
                LayoutDirection layoutDirection7 = layoutDirection$iv$iv;
                ViewConfiguration viewConfiguration6 = viewConfiguration$iv$iv;
                int i19 = $changed$iv;
                $composer2 = $composer3;
            }
            $composer$iv.endReplaceableGroup();
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
            int i20 = $dirty2;
            return;
        }
        int i21 = $dirty2;
        endRestartGroup.updateScope(new SnackbarKt$NewLineButtonSnackbar$2(text, action, dismissAction, actionTextStyle, actionContentColor, dismissActionContentColor, $changed));
    }

    /* access modifiers changed from: private */
    /* renamed from: OneRowSnackbar-kKq0p4A  reason: not valid java name */
    public static final void m2066OneRowSnackbarkKq0p4A(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> action, Function2<? super Composer, ? super Integer, Unit> dismissAction, TextStyle actionTextStyle, long actionTextColor, long dismissActionColor, Composer $composer, int $changed) {
        Composer $composer2;
        float f;
        Function2<? super Composer, ? super Integer, Unit> function2 = text;
        Function2<? super Composer, ? super Integer, Unit> function22 = action;
        Function2<? super Composer, ? super Integer, Unit> function23 = dismissAction;
        TextStyle textStyle = actionTextStyle;
        int i = $changed;
        Composer $composer3 = $composer.startRestartGroup(-903235475);
        ComposerKt.sourceInformation($composer3, "C(OneRowSnackbar)P(5!1,3,2,1:c#ui.graphics.Color,4:c#ui.graphics.Color)304@12676L4435:Snackbar.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 14) == 0) {
            $dirty |= $composer3.changed((Object) function2) ? 4 : 2;
        }
        if ((i & 112) == 0) {
            $dirty |= $composer3.changed((Object) function22) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            $dirty |= $composer3.changed((Object) function23) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            $dirty |= $composer3.changed((Object) textStyle) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            $dirty |= $composer3.changed(actionTextColor) ? 16384 : 8192;
        } else {
            long j = actionTextColor;
        }
        if ((458752 & i) == 0) {
            $dirty |= $composer3.changed(dismissActionColor) ? 131072 : 65536;
        } else {
            long j2 = dismissActionColor;
        }
        int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903235475, $dirty2, -1, "androidx.compose.material3.OneRowSnackbar (Snackbar.kt:293)");
            }
            Modifier modifier = Modifier.Companion;
            float f2 = HorizontalSpacing;
            if (function23 == null) {
                f = HorizontalSpacingButtonSide;
            } else {
                f = Dp.m5986constructorimpl((float) 0);
            }
            Modifier modifier$iv = PaddingKt.m764paddingqDBjuR0$default(modifier, f2, 0.0f, f, 0.0f, 10, (Object) null);
            MeasurePolicy measurePolicy$iv = new SnackbarKt$OneRowSnackbar$2("action", "dismissAction", "text");
            $composer3.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2907L7,75@2962L7,76@3021L7,77@3033L460:Layout.kt#80mrfh");
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(CompositionLocalsKt.getLocalDensity());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density$iv = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LayoutDirection layoutDirection$iv = (LayoutDirection) consume2;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ViewConfiguration viewConfiguration$iv = (ViewConfiguration) consume3;
            Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier$iv);
            Modifier modifier2 = modifier$iv;
            int $changed$iv$iv = ((0 << 9) & 7168) | 6;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3 = materializerOf;
            String dismissActionTag = "dismissAction";
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            $composer3.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv = Updater.m2787constructorimpl($composer3);
            Function0<ComposeUiNode> function0 = constructor;
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, density$iv, ComposeUiNode.Companion.getSetDensity());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, layoutDirection$iv, ComposeUiNode.Companion.getSetLayoutDirection());
            Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv, viewConfiguration$iv, ComposeUiNode.Companion.getSetViewConfiguration());
            $composer3.enableReusing();
            MeasurePolicy measurePolicy = measurePolicy$iv;
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function32 = function3;
            function32.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv >> 3) & 112));
            $composer3.startReplaceableGroup(2058660585);
            int $changed2 = ($changed$iv$iv >> 9) & 14;
            int i2 = $changed$iv$iv;
            Composer $composer4 = $composer3;
            $composer4.startReplaceableGroup(-1961334364);
            ComposerKt.sourceInformation($composer4, "C306@12706L86,317@13210L247:Snackbar.kt#uh7d8r");
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function33 = function32;
            if (($changed2 & 11) != 2 || !$composer4.getSkipping()) {
                Object obj = "text";
                ViewConfiguration viewConfiguration = viewConfiguration$iv;
                Density density = density$iv;
                Modifier modifier$iv2 = PaddingKt.m762paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.Companion, "text"), 0.0f, SnackbarVerticalPadding, 1, (Object) null);
                $composer4.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                LayoutDirection layoutDirection = layoutDirection$iv;
                MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                $composer4.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                Alignment alignment = contentAlignment$iv;
                int i3 = $changed2;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Density density$iv$iv = (Density) consume4;
                $composer2 = $composer3;
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
                Modifier modifier3 = modifier$iv2;
                int $changed$iv$iv$iv = ((((6 << 3) & 112) << 9) & 7168) | 6;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function34 = materializerOf2;
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
                Density density2 = density$iv$iv;
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function35 = function34;
                function35.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                $composer4.startReplaceableGroup(2058660585);
                Composer $composer$iv = $composer4;
                int i4 = $changed$iv$iv$iv;
                $composer$iv.startReplaceableGroup(-2137368960);
                ComposerKt.sourceInformation($composer$iv, "C72@3384L9:Box.kt#2w3rfo");
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function36 = function35;
                MeasurePolicy measurePolicy2 = measurePolicy$iv2;
                if ((($changed$iv$iv$iv >> 9) & 14 & 11) != 2 || !$composer$iv.getSkipping()) {
                    int $changed3 = ((6 >> 6) & 112) | 6;
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    Composer $composer5 = $composer$iv;
                    $composer5.startReplaceableGroup(-789862614);
                    ComposerKt.sourceInformation($composer5, "C306@12784L6:Snackbar.kt#uh7d8r");
                    int i5 = $changed3;
                    if (($changed3 & 81) != 16 || !$composer5.getSkipping()) {
                        function2.invoke($composer5, Integer.valueOf($dirty2 & 14));
                    } else {
                        $composer5.skipToGroupEnd();
                    }
                    $composer5.endReplaceableGroup();
                } else {
                    $composer$iv.skipToGroupEnd();
                }
                $composer$iv.endReplaceableGroup();
                $composer4.endReplaceableGroup();
                $composer4.endNode();
                $composer4.endReplaceableGroup();
                $composer4.endReplaceableGroup();
                $composer4.startReplaceableGroup(-167734710);
                ComposerKt.sourceInformation($composer4, "308@12843L295");
                if (function22 != null) {
                    Modifier modifier$iv3 = LayoutIdKt.layoutId(Modifier.Companion, "action");
                    $composer4.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
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
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(modifier$iv3);
                    Modifier modifier4 = modifier$iv3;
                    int $changed$iv$iv$iv2 = ((((6 << 3) & 112) << 9) & 7168) | 6;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function37 = materializerOf3;
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
                    Density density3 = density$iv$iv2;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function38 = function37;
                    function38.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                    $composer4.startReplaceableGroup(2058660585);
                    Composer $composer$iv2 = $composer4;
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function39 = function38;
                    $composer$iv2.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer$iv2, "C72@3384L9:Box.kt#2w3rfo");
                    int i6 = $changed$iv$iv$iv2;
                    if ((($changed$iv$iv$iv2 >> 9) & 14 & 11) != 2 || !$composer$iv2.getSkipping()) {
                        int $changed4 = ((6 >> 6) & 112) | 6;
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        Composer $composer6 = $composer$iv2;
                        $composer6.startReplaceableGroup(801714373);
                        ComposerKt.sourceInformation($composer6, "C309@12899L221:Snackbar.kt#uh7d8r");
                        int i7 = $changed4;
                        if (($changed4 & 81) != 16 || !$composer6.getSkipping()) {
                            LayoutDirection layoutDirection2 = layoutDirection$iv$iv2;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(actionTextColor)), TextKt.getLocalTextStyle().provides(actionTextStyle)}, function22, $composer6, ($dirty2 & 112) | 8);
                        } else {
                            $composer6.skipToGroupEnd();
                            LayoutDirection layoutDirection3 = layoutDirection$iv$iv2;
                            TextStyle textStyle2 = actionTextStyle;
                        }
                        $composer6.endReplaceableGroup();
                    } else {
                        $composer$iv2.skipToGroupEnd();
                        LayoutDirection layoutDirection4 = layoutDirection$iv$iv2;
                        TextStyle textStyle3 = actionTextStyle;
                    }
                    $composer$iv2.endReplaceableGroup();
                    $composer4.endReplaceableGroup();
                    $composer4.endNode();
                    $composer4.endReplaceableGroup();
                    $composer4.endReplaceableGroup();
                } else {
                    TextStyle textStyle4 = actionTextStyle;
                    Object obj3 = "action";
                }
                $composer4.endReplaceableGroup();
                Function2<? super Composer, ? super Integer, Unit> function24 = dismissAction;
                if (function24 != null) {
                    String dismissActionTag2 = dismissActionTag;
                    Modifier modifier$iv4 = LayoutIdKt.layoutId(Modifier.Companion, dismissActionTag2);
                    $composer4.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer4, "C(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv4 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv3, false, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    String str = dismissActionTag2;
                    $composer4.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume10 = $composer4.consume(CompositionLocalsKt.getLocalDensity());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Density density$iv$iv3 = (Density) consume10;
                    Alignment alignment3 = contentAlignment$iv3;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume11 = $composer4.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume11;
                    ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume12 = $composer4.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume12;
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.Companion.getConstructor();
                    Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv4);
                    Modifier modifier5 = modifier$iv4;
                    int $changed$iv$iv$iv3 = ((((6 << 3) & 112) << 9) & 7168) | 6;
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        $composer4.createNode(constructor4);
                    } else {
                        $composer4.useNode();
                    }
                    $composer4.disableReusing();
                    Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m2787constructorimpl($composer4);
                    Function0<ComposeUiNode> function04 = constructor4;
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.Companion.getSetDensity());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.Companion.getSetLayoutDirection());
                    Updater.m2794setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.Companion.getSetViewConfiguration());
                    $composer4.enableReusing();
                    skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2778boximpl(SkippableUpdater.m2779constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
                    $composer4.startReplaceableGroup(2058660585);
                    Composer $composer$iv3 = $composer4;
                    int i8 = $changed$iv$iv$iv3;
                    $composer$iv3.startReplaceableGroup(-2137368960);
                    ComposerKt.sourceInformation($composer$iv3, "C72@3384L9:Box.kt#2w3rfo");
                    if ((($changed$iv$iv$iv3 >> 9) & 14 & 11) != 2 || !$composer$iv3.getSkipping()) {
                        int $changed5 = ((6 >> 6) & 112) | 6;
                        BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
                        Density density4 = density$iv$iv3;
                        Composer $composer7 = $composer$iv3;
                        $composer7.startReplaceableGroup(88411260);
                        ComposerKt.sourceInformation($composer7, "C318@13273L166:Snackbar.kt#uh7d8r");
                        int i9 = $changed5;
                        if (($changed5 & 81) != 16 || !$composer7.getSkipping()) {
                            LayoutDirection layoutDirection5 = layoutDirection$iv$iv3;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m3154boximpl(dismissActionColor))}, function24, $composer7, (($dirty2 >> 3) & 112) | 8);
                        } else {
                            $composer7.skipToGroupEnd();
                            LayoutDirection layoutDirection6 = layoutDirection$iv$iv3;
                        }
                        $composer7.endReplaceableGroup();
                    } else {
                        $composer$iv3.skipToGroupEnd();
                        Density density5 = density$iv$iv3;
                        LayoutDirection layoutDirection7 = layoutDirection$iv$iv3;
                    }
                    $composer$iv3.endReplaceableGroup();
                    $composer4.endReplaceableGroup();
                    $composer4.endNode();
                    $composer4.endReplaceableGroup();
                    $composer4.endReplaceableGroup();
                }
            } else {
                $composer4.skipToGroupEnd();
                Object obj4 = "text";
                Object obj5 = "action";
                ViewConfiguration viewConfiguration2 = viewConfiguration$iv;
                Density density6 = density$iv;
                LayoutDirection layoutDirection8 = layoutDirection$iv;
                Function2<? super Composer, ? super Integer, Unit> function25 = function23;
                int i10 = $changed2;
                $composer2 = $composer3;
                String str2 = dismissActionTag;
            }
            $composer4.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            Function2<? super Composer, ? super Integer, Unit> function26 = function23;
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i11 = $dirty2;
            return;
        }
        int i12 = $dirty2;
        endRestartGroup.updateScope(new SnackbarKt$OneRowSnackbar$3(text, action, dismissAction, actionTextStyle, actionTextColor, dismissActionColor, $changed));
    }
}
