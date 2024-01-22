package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a´\u0001\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0013\b\u0002\u0010\f\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0013\b\u0002\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0013\b\u0002\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t0\u001a¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0001\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00132\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t0\u001a¢\u0006\u0002\b\u000e2\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0011\u0010\u000f\u001a\r\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\b\u000eH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006$"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material3/FabPosition;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-TvnljyQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IJJLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ScaffoldLayout", "fabPosition", "snackbar", "fab", "ScaffoldLayout-FMILGgc", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Scaffold.kt */
public final class ScaffoldKt {
    /* access modifiers changed from: private */
    public static final float FabSpacing = Dp.m5986constructorimpl((float) 16);
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(ScaffoldKt$LocalFabPlacement$1.INSTANCE);

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v1, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v4, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v7, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v8, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v5, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x02bd  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02c2  */
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* renamed from: Scaffold-TvnljyQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2050ScaffoldTvnljyQ(androidx.compose.ui.Modifier r29, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, int r34, long r35, long r37, androidx.compose.foundation.layout.WindowInsets r39, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r15 = r40
            r14 = r42
            r13 = r43
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = -1219521777(0xffffffffb74f930f, float:-1.2372401E-5)
            r1 = r41
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Scaffold)P(7,9!1,8,5,6:c#material3.FabPosition,1:c#ui.graphics.Color,3:c#ui.graphics.Color,4)81@4088L11,82@4138L31,83@4228L19,86@4306L405:Scaffold.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r12, r1)
            r1 = r42
            r2 = r13 & 1
            if (r2 == 0) goto L_0x0024
            r1 = r1 | 6
            r3 = r29
            goto L_0x0037
        L_0x0024:
            r3 = r14 & 14
            if (r3 != 0) goto L_0x0035
            r3 = r29
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0032
            r4 = 4
            goto L_0x0033
        L_0x0032:
            r4 = 2
        L_0x0033:
            r1 = r1 | r4
            goto L_0x0037
        L_0x0035:
            r3 = r29
        L_0x0037:
            r4 = r13 & 2
            if (r4 == 0) goto L_0x0040
            r1 = r1 | 48
            r5 = r30
            goto L_0x0055
        L_0x0040:
            r5 = r14 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0053
            r5 = r30
            boolean r6 = r12.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x004f
            r6 = 32
            goto L_0x0051
        L_0x004f:
            r6 = 16
        L_0x0051:
            r1 = r1 | r6
            goto L_0x0055
        L_0x0053:
            r5 = r30
        L_0x0055:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x005e
            r1 = r1 | 384(0x180, float:5.38E-43)
            r7 = r31
            goto L_0x0073
        L_0x005e:
            r7 = r14 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0071
            r7 = r31
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x006d
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x006f
        L_0x006d:
            r8 = 128(0x80, float:1.794E-43)
        L_0x006f:
            r1 = r1 | r8
            goto L_0x0073
        L_0x0071:
            r7 = r31
        L_0x0073:
            r8 = r13 & 8
            if (r8 == 0) goto L_0x007c
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r9 = r32
            goto L_0x0091
        L_0x007c:
            r9 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x008f
            r9 = r32
            boolean r10 = r12.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x008b
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x008d
        L_0x008b:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x008d:
            r1 = r1 | r10
            goto L_0x0091
        L_0x008f:
            r9 = r32
        L_0x0091:
            r10 = r13 & 16
            if (r10 == 0) goto L_0x009a
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r11 = r33
            goto L_0x00b2
        L_0x009a:
            r11 = 57344(0xe000, float:8.0356E-41)
            r11 = r11 & r14
            if (r11 != 0) goto L_0x00b0
            r11 = r33
            boolean r16 = r12.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x00ab
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ad
        L_0x00ab:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00ad:
            r1 = r1 | r16
            goto L_0x00b2
        L_0x00b0:
            r11 = r33
        L_0x00b2:
            r16 = r13 & 32
            if (r16 == 0) goto L_0x00bd
            r17 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r17
            r0 = r34
            goto L_0x00d5
        L_0x00bd:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r14 & r17
            if (r17 != 0) goto L_0x00d3
            r0 = r34
            boolean r18 = r12.changed((int) r0)
            if (r18 == 0) goto L_0x00ce
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00d0
        L_0x00ce:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00d0:
            r1 = r1 | r18
            goto L_0x00d5
        L_0x00d3:
            r0 = r34
        L_0x00d5:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r14 & r18
            if (r18 != 0) goto L_0x00f5
            r18 = r13 & 64
            if (r18 != 0) goto L_0x00ec
            r41 = r10
            r9 = r35
            boolean r18 = r12.changed((long) r9)
            if (r18 == 0) goto L_0x00f0
            r18 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00f2
        L_0x00ec:
            r41 = r10
            r9 = r35
        L_0x00f0:
            r18 = 524288(0x80000, float:7.34684E-40)
        L_0x00f2:
            r1 = r1 | r18
            goto L_0x00f9
        L_0x00f5:
            r41 = r10
            r9 = r35
        L_0x00f9:
            r18 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r14 & r18
            if (r18 != 0) goto L_0x0114
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x010e
            r9 = r37
            boolean r0 = r12.changed((long) r9)
            if (r0 == 0) goto L_0x0110
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0112
        L_0x010e:
            r9 = r37
        L_0x0110:
            r0 = 4194304(0x400000, float:5.877472E-39)
        L_0x0112:
            r1 = r1 | r0
            goto L_0x0116
        L_0x0114:
            r9 = r37
        L_0x0116:
            r0 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r14
            if (r0 != 0) goto L_0x0131
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 != 0) goto L_0x012a
            r0 = r39
            boolean r18 = r12.changed((java.lang.Object) r0)
            if (r18 == 0) goto L_0x012c
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x012e
        L_0x012a:
            r0 = r39
        L_0x012c:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x012e:
            r1 = r1 | r18
            goto L_0x0133
        L_0x0131:
            r0 = r39
        L_0x0133:
            r0 = r13 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x013b
            r0 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0139:
            r1 = r1 | r0
            goto L_0x014c
        L_0x013b:
            r0 = 1879048192(0x70000000, float:1.58456325E29)
            r0 = r0 & r14
            if (r0 != 0) goto L_0x014c
            boolean r0 = r12.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0149
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0139
        L_0x0149:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0139
        L_0x014c:
            r0 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r0 = r0 & r1
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r0 != r3) goto L_0x0175
            boolean r0 = r12.getSkipping()
            if (r0 != 0) goto L_0x015c
            goto L_0x0175
        L_0x015c:
            r12.skipToGroupEnd()
            r15 = r29
            r18 = r32
            r20 = r34
            r21 = r35
            r25 = r39
            r26 = r1
            r16 = r5
            r17 = r7
            r23 = r9
            r19 = r11
            goto L_0x02b7
        L_0x0175:
            r12.startDefaults()
            r0 = r14 & 1
            r3 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r18 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r19 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r0 == 0) goto L_0x01c1
            boolean r0 = r12.getDefaultsInvalid()
            if (r0 == 0) goto L_0x018c
            goto L_0x01c1
        L_0x018c:
            r12.skipToGroupEnd()
            r0 = r13 & 64
            if (r0 == 0) goto L_0x0195
            r1 = r1 & r19
        L_0x0195:
            r0 = r13 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x019b
            r1 = r1 & r18
        L_0x019b:
            r0 = r13 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x01b1
            r0 = r1 & r3
            r1 = r34
            r3 = r35
            r2 = r5
            r8 = r9
            r6 = r11
            r5 = r32
            r10 = r39
            r11 = r0
            r0 = r29
            goto L_0x0241
        L_0x01b1:
            r0 = r29
            r3 = r35
            r2 = r5
            r8 = r9
            r6 = r11
            r5 = r32
            r10 = r39
            r11 = r1
            r1 = r34
            goto L_0x0241
        L_0x01c1:
            if (r2 == 0) goto L_0x01c8
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x01ca
        L_0x01c8:
            r0 = r29
        L_0x01ca:
            if (r4 == 0) goto L_0x01d3
            androidx.compose.material3.ComposableSingletons$ScaffoldKt r2 = androidx.compose.material3.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r2 = r2.m1872getLambda1$material3_release()
            goto L_0x01d4
        L_0x01d3:
            r2 = r5
        L_0x01d4:
            if (r6 == 0) goto L_0x01dd
            androidx.compose.material3.ComposableSingletons$ScaffoldKt r4 = androidx.compose.material3.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r4 = r4.m1873getLambda2$material3_release()
            goto L_0x01de
        L_0x01dd:
            r4 = r7
        L_0x01de:
            if (r8 == 0) goto L_0x01e7
            androidx.compose.material3.ComposableSingletons$ScaffoldKt r5 = androidx.compose.material3.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r5 = r5.m1874getLambda3$material3_release()
            goto L_0x01e9
        L_0x01e7:
            r5 = r32
        L_0x01e9:
            if (r41 == 0) goto L_0x01f2
            androidx.compose.material3.ComposableSingletons$ScaffoldKt r6 = androidx.compose.material3.ComposableSingletons$ScaffoldKt.INSTANCE
            kotlin.jvm.functions.Function2 r6 = r6.m1875getLambda4$material3_release()
            goto L_0x01f3
        L_0x01f2:
            r6 = r11
        L_0x01f3:
            if (r16 == 0) goto L_0x01fc
            androidx.compose.material3.FabPosition$Companion r7 = androidx.compose.material3.FabPosition.Companion
            int r7 = r7.m1930getEndERTFSPs()
            goto L_0x01fe
        L_0x01fc:
            r7 = r34
        L_0x01fe:
            r8 = r13 & 64
            r11 = 6
            if (r8 == 0) goto L_0x0214
            androidx.compose.material3.MaterialTheme r8 = androidx.compose.material3.MaterialTheme.INSTANCE
            androidx.compose.material3.ColorScheme r8 = r8.getColorScheme(r12, r11)
            long r20 = r8.m1794getBackground0d7_KjU()
            r1 = r1 & r19
            r29 = r4
            r3 = r20
            goto L_0x0218
        L_0x0214:
            r29 = r4
            r3 = r35
        L_0x0218:
            r8 = r13 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0227
            int r8 = r1 >> 18
            r8 = r8 & 14
            long r8 = androidx.compose.material3.ColorSchemeKt.m1854contentColorForek8zF_U(r3, r12, r8)
            r1 = r1 & r18
            goto L_0x0228
        L_0x0227:
            r8 = r9
        L_0x0228:
            r10 = r13 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x023b
            androidx.compose.material3.ScaffoldDefaults r10 = androidx.compose.material3.ScaffoldDefaults.INSTANCE
            androidx.compose.foundation.layout.WindowInsets r10 = r10.getContentWindowInsets(r12, r11)
            r11 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r1 = r1 & r11
            r11 = r1
            r1 = r7
            r7 = r29
            goto L_0x0241
        L_0x023b:
            r10 = r39
            r11 = r1
            r1 = r7
            r7 = r29
        L_0x0241:
            r12.endDefaults()
            boolean r16 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r16 == 0) goto L_0x0253
            r13 = -1
            java.lang.String r14 = "androidx.compose.material3.Scaffold (Scaffold.kt:74)"
            r15 = -1219521777(0xffffffffb74f930f, float:-1.2372401E-5)
            androidx.compose.runtime.ComposerKt.traceEventStart(r15, r11, r13, r14)
        L_0x0253:
            r17 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            androidx.compose.material3.ScaffoldKt$Scaffold$1 r13 = new androidx.compose.material3.ScaffoldKt$Scaffold$1
            r29 = r13
            r30 = r1
            r31 = r2
            r32 = r40
            r33 = r5
            r34 = r6
            r35 = r10
            r36 = r7
            r37 = r11
            r29.<init>(r30, r31, r32, r33, r34, r35, r36, r37)
            r14 = -1979205334(0xffffffff8a07b92a, float:-6.534839E-33)
            r15 = 1
            androidx.compose.runtime.internal.ComposableLambda r13 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r14, r15, r13)
            r25 = r13
            kotlin.jvm.functions.Function2 r25 = (kotlin.jvm.functions.Function2) r25
            r13 = r11 & 14
            r14 = 12582912(0xc00000, float:1.7632415E-38)
            r13 = r13 | r14
            int r14 = r11 >> 12
            r14 = r14 & 896(0x380, float:1.256E-42)
            r13 = r13 | r14
            int r14 = r11 >> 12
            r14 = r14 & 7168(0x1c00, float:1.0045E-41)
            r27 = r13 | r14
            r28 = 114(0x72, float:1.6E-43)
            r16 = r0
            r18 = r3
            r20 = r8
            r26 = r12
            androidx.compose.material3.SurfaceKt.m2097SurfaceT9BRK9s(r16, r17, r18, r20, r22, r23, r24, r25, r26, r27, r28)
            boolean r13 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r13 == 0) goto L_0x02a4
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02a4:
            r15 = r0
            r20 = r1
            r16 = r2
            r21 = r3
            r18 = r5
            r19 = r6
            r17 = r7
            r23 = r8
            r25 = r10
            r26 = r11
        L_0x02b7:
            androidx.compose.runtime.ScopeUpdateScope r14 = r12.endRestartGroup()
            if (r14 != 0) goto L_0x02c2
            r28 = r12
            r29 = r15
            goto L_0x02ec
        L_0x02c2:
            androidx.compose.material3.ScaffoldKt$Scaffold$2 r27 = new androidx.compose.material3.ScaffoldKt$Scaffold$2
            r0 = r27
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r9 = r23
            r11 = r25
            r28 = r12
            r12 = r40
            r13 = r42
            r29 = r15
            r15 = r14
            r14 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13, r14)
            r0 = r27
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x02ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ScaffoldKt.m2050ScaffoldTvnljyQ(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, int, long, long, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-FMILGgc  reason: not valid java name */
    public static final void m2051ScaffoldLayoutFMILGgc(int fabPosition, Function2<? super Composer, ? super Integer, Unit> topBar, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> content, Function2<? super Composer, ? super Integer, Unit> snackbar, Function2<? super Composer, ? super Integer, Unit> fab, WindowInsets contentWindowInsets, Function2<? super Composer, ? super Integer, Unit> bottomBar, Composer $composer, int $changed) {
        int i;
        int i2 = $changed;
        Composer $composer2 = $composer.startRestartGroup(-975511942);
        ComposerKt.sourceInformation($composer2, "C(ScaffoldLayout)P(4:c#material3.FabPosition,6,1,5,3,2)123@5669L6544,123@5652L6561:Scaffold.kt#uh7d8r");
        int $dirty = $changed;
        if ((i2 & 14) == 0) {
            $dirty |= $composer2.changed(fabPosition) ? 4 : 2;
        } else {
            int i3 = fabPosition;
        }
        if ((i2 & 112) == 0) {
            $dirty |= $composer2.changed((Object) topBar) ? 32 : 16;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function2 = topBar;
        }
        if ((i2 & 896) == 0) {
            $dirty |= $composer2.changed((Object) content) ? 256 : 128;
        } else {
            Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3 = content;
        }
        if ((i2 & 7168) == 0) {
            $dirty |= $composer2.changed((Object) snackbar) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function22 = snackbar;
        }
        if ((57344 & i2) == 0) {
            $dirty |= $composer2.changed((Object) fab) ? 16384 : 8192;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = fab;
        }
        if ((458752 & i2) == 0) {
            $dirty |= $composer2.changed((Object) contentWindowInsets) ? 131072 : 65536;
        } else {
            WindowInsets windowInsets = contentWindowInsets;
        }
        if ((3670016 & i2) == 0) {
            $dirty |= $composer2.changed((Object) bottomBar) ? 1048576 : 524288;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function24 = bottomBar;
        }
        if ((2995931 & $dirty) != 599186 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-975511942, $dirty, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:113)");
            }
            Object[] keys$iv = {topBar, snackbar, contentWindowInsets, fab, FabPosition.m1922boximpl(fabPosition), bottomBar, content};
            $composer2.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer2.changed(key$iv);
            }
            Composer $this$cache$iv$iv = $composer2;
            Object value$iv$iv = $this$cache$iv$iv.rememberedValue();
            if (invalid$iv || value$iv$iv == Composer.Companion.getEmpty()) {
                Object obj = value$iv$iv;
                Object[] objArr = keys$iv;
                i = 0;
                value$iv$iv = new ScaffoldKt$ScaffoldLayout$1$1(topBar, snackbar, fab, fabPosition, contentWindowInsets, bottomBar, $dirty, content);
                $this$cache$iv$iv.updateRememberedValue(value$iv$iv);
            } else {
                Object[] objArr2 = keys$iv;
                Object obj2 = value$iv$iv;
                Composer composer = $this$cache$iv$iv;
                i = 0;
            }
            $composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout((Modifier) null, (Function2) value$iv$iv, $composer2, i, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            int i4 = $dirty;
            return;
        }
        int i5 = $dirty;
        endRestartGroup.updateScope(new ScaffoldKt$ScaffoldLayout$2(fabPosition, topBar, content, snackbar, fab, contentWindowInsets, bottomBar, $changed));
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
