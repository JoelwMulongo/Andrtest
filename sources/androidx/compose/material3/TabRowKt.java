package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00012.\b\u0002\u0010\u0011\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u00182\u0013\b\u0002\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u00182\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0001\u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2.\b\u0002\u0010\u0011\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\b0\u0012¢\u0006\u0002\b\u00182\u0013\b\u0002\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u00182\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\b0\u001a¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowPadding", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "ScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "divider", "Lkotlin/Function0;", "tabs", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TabRow", "TabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TabRow.kt */
public final class TabRowKt {
    /* access modifiers changed from: private */
    public static final float ScrollableTabRowMinimumTabWidth = Dp.m5986constructorimpl((float) 90);
    private static final float ScrollableTabRowPadding = Dp.m5986constructorimpl((float) 52);
    /* access modifiers changed from: private */
    public static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null);

    /* JADX WARNING: Removed duplicated region for block: B:114:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0103  */
    /* renamed from: TabRow-pAZo6Ak  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2135TabRowpAZo6Ak(int r28, androidx.compose.ui.Modifier r29, long r30, long r32, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material3.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, int r38, int r39) {
        /*
            r12 = r28
            r13 = r36
            r14 = r38
            java.lang.String r0 = "tabs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -1199178586(0xffffffffb885fca6, float:-6.388994E-5)
            r1 = r37
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(TabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)128@6357L14,129@6414L12,140@6770L1732:TabRow.kt#uh7d8r"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r38
            r2 = r39 & 1
            if (r2 == 0) goto L_0x0023
            r1 = r1 | 6
            goto L_0x0031
        L_0x0023:
            r2 = r14 & 14
            if (r2 != 0) goto L_0x0031
            boolean r2 = r11.changed((int) r12)
            if (r2 == 0) goto L_0x002f
            r2 = 4
            goto L_0x0030
        L_0x002f:
            r2 = 2
        L_0x0030:
            r1 = r1 | r2
        L_0x0031:
            r2 = r39 & 2
            if (r2 == 0) goto L_0x003a
            r1 = r1 | 48
            r3 = r29
            goto L_0x004f
        L_0x003a:
            r3 = r14 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004d
            r3 = r29
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0049
            r4 = 32
            goto L_0x004b
        L_0x0049:
            r4 = 16
        L_0x004b:
            r1 = r1 | r4
            goto L_0x004f
        L_0x004d:
            r3 = r29
        L_0x004f:
            r4 = r14 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0068
            r4 = r39 & 4
            if (r4 != 0) goto L_0x0062
            r4 = r30
            boolean r6 = r11.changed((long) r4)
            if (r6 == 0) goto L_0x0064
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0062:
            r4 = r30
        L_0x0064:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r1 = r1 | r6
            goto L_0x006a
        L_0x0068:
            r4 = r30
        L_0x006a:
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0083
            r6 = r39 & 8
            if (r6 != 0) goto L_0x007d
            r6 = r32
            boolean r8 = r11.changed((long) r6)
            if (r8 == 0) goto L_0x007f
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007d:
            r6 = r32
        L_0x007f:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r1 = r1 | r8
            goto L_0x0085
        L_0x0083:
            r6 = r32
        L_0x0085:
            r8 = r39 & 16
            if (r8 == 0) goto L_0x008e
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r9 = r34
            goto L_0x00a5
        L_0x008e:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r14
            if (r9 != 0) goto L_0x00a3
            r9 = r34
            boolean r10 = r11.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x009f
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a1
        L_0x009f:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a1:
            r1 = r1 | r10
            goto L_0x00a5
        L_0x00a3:
            r9 = r34
        L_0x00a5:
            r10 = r39 & 32
            if (r10 == 0) goto L_0x00af
            r15 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r15
            r15 = r35
            goto L_0x00c6
        L_0x00af:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r14
            if (r15 != 0) goto L_0x00c4
            r15 = r35
            boolean r16 = r11.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00bf
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c1
        L_0x00bf:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00c1:
            r1 = r1 | r16
            goto L_0x00c6
        L_0x00c4:
            r15 = r35
        L_0x00c6:
            r16 = r39 & 64
            if (r16 == 0) goto L_0x00cf
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00cc:
            r1 = r1 | r16
            goto L_0x00e1
        L_0x00cf:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r14 & r16
            if (r16 != 0) goto L_0x00e1
            boolean r16 = r11.changed((java.lang.Object) r13)
            if (r16 == 0) goto L_0x00de
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00cc
        L_0x00de:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00cc
        L_0x00e1:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r1 & r16
            r3 = 599186(0x92492, float:8.39638E-40)
            if (r0 != r3) goto L_0x0103
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x00f2
            goto L_0x0103
        L_0x00f2:
            r11.skipToGroupEnd()
            r22 = r1
            r16 = r4
            r18 = r6
            r20 = r9
            r21 = r15
            r15 = r29
            goto L_0x01c0
        L_0x0103:
            r11.startDefaults()
            r0 = r14 & 1
            if (r0 == 0) goto L_0x0129
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0111
            goto L_0x0129
        L_0x0111:
            r11.skipToGroupEnd()
            r0 = r39 & 4
            if (r0 == 0) goto L_0x011a
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x011a:
            r0 = r39 & 8
            if (r0 == 0) goto L_0x0125
            r0 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r1 = r0
            r2 = r15
            r0 = r29
            goto L_0x0168
        L_0x0125:
            r0 = r29
            r2 = r15
            goto L_0x0168
        L_0x0129:
            if (r2 == 0) goto L_0x0130
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x0132
        L_0x0130:
            r0 = r29
        L_0x0132:
            r2 = r39 & 4
            r3 = 6
            if (r2 == 0) goto L_0x013f
            androidx.compose.material3.TabRowDefaults r2 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r4 = r2.getContainerColor(r11, r3)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x013f:
            r2 = r39 & 8
            if (r2 == 0) goto L_0x014c
            androidx.compose.material3.TabRowDefaults r2 = androidx.compose.material3.TabRowDefaults.INSTANCE
            long r2 = r2.getContentColor(r11, r3)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r6 = r2
        L_0x014c:
            if (r8 == 0) goto L_0x015e
            androidx.compose.material3.TabRowKt$TabRow$1 r2 = new androidx.compose.material3.TabRowKt$TabRow$1
            r2.<init>(r12)
            r3 = -2052073983(0xffffffff85afd601, float:-1.6535534E-35)
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r3, r8, r2)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            r9 = r2
        L_0x015e:
            if (r10 == 0) goto L_0x0167
            androidx.compose.material3.ComposableSingletons$TabRowKt r2 = androidx.compose.material3.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r2 = r2.m1878getLambda1$material3_release()
            goto L_0x0168
        L_0x0167:
            r2 = r15
        L_0x0168:
            r11.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x017a
            r3 = -1
            java.lang.String r8 = "androidx.compose.material3.TabRow (TabRow.kt:125)"
            r10 = -1199178586(0xffffffffb885fca6, float:-6.388994E-5)
            androidx.compose.runtime.ComposerKt.traceEventStart(r10, r1, r3, r8)
        L_0x017a:
            androidx.compose.ui.Modifier r15 = androidx.compose.foundation.selection.SelectableGroupKt.selectableGroup(r0)
            r16 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            androidx.compose.material3.TabRowKt$TabRow$2 r3 = new androidx.compose.material3.TabRowKt$TabRow$2
            r3.<init>(r13, r2, r9, r1)
            r8 = 1273256619(0x4be45aab, float:2.9930838E7)
            r10 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r8, r10, r3)
            r24 = r3
            kotlin.jvm.functions.Function2 r24 = (kotlin.jvm.functions.Function2) r24
            r3 = 12582912(0xc00000, float:1.7632415E-38)
            r8 = r1 & 896(0x380, float:1.256E-42)
            r3 = r3 | r8
            r8 = r1 & 7168(0x1c00, float:1.0045E-41)
            r26 = r3 | r8
            r27 = 114(0x72, float:1.6E-43)
            r17 = r4
            r19 = r6
            r25 = r11
            androidx.compose.material3.SurfaceKt.m2097SurfaceT9BRK9s(r15, r16, r17, r19, r21, r22, r23, r24, r25, r26, r27)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01b5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01b5:
            r15 = r0
            r22 = r1
            r21 = r2
            r16 = r4
            r18 = r6
            r20 = r9
        L_0x01c0:
            androidx.compose.runtime.ScopeUpdateScope r10 = r11.endRestartGroup()
            if (r10 != 0) goto L_0x01c9
            r24 = r11
            goto L_0x01eb
        L_0x01c9:
            androidx.compose.material3.TabRowKt$TabRow$3 r23 = new androidx.compose.material3.TabRowKt$TabRow$3
            r0 = r23
            r1 = r28
            r2 = r15
            r3 = r16
            r5 = r18
            r7 = r20
            r8 = r21
            r9 = r36
            r12 = r10
            r10 = r38
            r24 = r11
            r11 = r39
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            r0 = r23
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r12.updateScope(r0)
        L_0x01eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TabRowKt.m2135TabRowpAZo6Ak(int, androidx.compose.ui.Modifier, long, long, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: ScrollableTabRow-sKfQg0A  reason: not valid java name */
    public static final void m2134ScrollableTabRowsKfQg0A(int selectedTabIndex, Modifier modifier, long containerColor, long contentColor, float edgePadding, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> divider, Function2<? super Composer, ? super Integer, Unit> tabs, Composer $composer, int $changed, int i) {
        long containerColor2;
        long contentColor2;
        float edgePadding2;
        Function2 divider2;
        Function3 indicator2;
        float edgePadding3;
        long contentColor3;
        long containerColor3;
        Modifier modifier2;
        Function2 divider3;
        Function3 indicator3;
        Modifier modifier3;
        int i2;
        int i3;
        int i4 = selectedTabIndex;
        Function2<? super Composer, ? super Integer, Unit> function2 = tabs;
        int i5 = $changed;
        int i6 = i;
        Intrinsics.checkNotNullParameter(function2, "tabs");
        Composer $composer2 = $composer.startRestartGroup(-497821003);
        ComposerKt.sourceInformation($composer2, "C(ScrollableTabRow)P(6,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)224@10825L14,225@10882L12,237@11285L3200:TabRow.kt#uh7d8r");
        int $dirty = $changed;
        if ((i6 & 1) != 0) {
            $dirty |= 6;
        } else if ((i5 & 14) == 0) {
            $dirty |= $composer2.changed(i4) ? 4 : 2;
        }
        int i7 = i6 & 2;
        if (i7 != 0) {
            $dirty |= 48;
            Modifier modifier4 = modifier;
        } else if ((i5 & 112) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier5 = modifier;
        }
        if ((i5 & 896) == 0) {
            if ((i6 & 4) == 0) {
                containerColor2 = containerColor;
                if ($composer2.changed(containerColor2)) {
                    i3 = 256;
                    $dirty |= i3;
                }
            } else {
                containerColor2 = containerColor;
            }
            i3 = 128;
            $dirty |= i3;
        } else {
            containerColor2 = containerColor;
        }
        if ((i5 & 7168) == 0) {
            if ((i6 & 8) == 0) {
                contentColor2 = contentColor;
                if ($composer2.changed(contentColor2)) {
                    i2 = 2048;
                    $dirty |= i2;
                }
            } else {
                contentColor2 = contentColor;
            }
            i2 = 1024;
            $dirty |= i2;
        } else {
            contentColor2 = contentColor;
        }
        int i8 = i6 & 16;
        if (i8 != 0) {
            $dirty |= 24576;
            edgePadding2 = edgePadding;
        } else if ((57344 & i5) == 0) {
            edgePadding2 = edgePadding;
            $dirty |= $composer2.changed(edgePadding2) ? 16384 : 8192;
        } else {
            edgePadding2 = edgePadding;
        }
        int i9 = i6 & 32;
        if (i9 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3 = indicator;
        } else if ((i5 & 458752) == 0) {
            $dirty |= $composer2.changed((Object) indicator) ? 131072 : 65536;
        } else {
            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32 = indicator;
        }
        int i10 = i6 & 64;
        if (i10 != 0) {
            $dirty |= 1572864;
            Function2<? super Composer, ? super Integer, Unit> function22 = divider;
        } else if ((i5 & 3670016) == 0) {
            $dirty |= $composer2.changed((Object) divider) ? 1048576 : 524288;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function23 = divider;
        }
        if ((i6 & 128) != 0) {
            $dirty |= 12582912;
        } else if ((29360128 & i5) == 0) {
            $dirty |= $composer2.changed((Object) function2) ? 8388608 : 4194304;
        }
        if ((23967451 & $dirty) != 4793490 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i7 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if ((i6 & 4) != 0) {
                    containerColor2 = TabRowDefaults.INSTANCE.getContainerColor($composer2, 6);
                    $dirty &= -897;
                }
                if ((i6 & 8) != 0) {
                    $dirty &= -7169;
                    contentColor2 = TabRowDefaults.INSTANCE.getContentColor($composer2, 6);
                }
                if (i8 != 0) {
                    edgePadding2 = ScrollableTabRowPadding;
                }
                if (i9 != 0) {
                    indicator3 = ComposableLambdaKt.composableLambda($composer2, -913748678, true, new TabRowKt$ScrollableTabRow$1(i4));
                } else {
                    indicator3 = indicator;
                }
                divider3 = i10 != 0 ? ComposableSingletons$TabRowKt.INSTANCE.m1879getLambda2$material3_release() : divider;
            } else {
                $composer2.skipToGroupEnd();
                if ((i6 & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i6 & 8) != 0) {
                    indicator3 = indicator;
                    divider3 = divider;
                    $dirty &= -7169;
                    modifier3 = modifier;
                } else {
                    modifier3 = modifier;
                    indicator3 = indicator;
                    divider3 = divider;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-497821003, $dirty, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:221)");
            }
            SurfaceKt.m2097SurfaceT9BRK9s(modifier3, (Shape) null, containerColor2, contentColor2, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.composableLambda($composer2, 286469328, true, new TabRowKt$ScrollableTabRow$2(edgePadding2, tabs, divider3, selectedTabIndex, indicator3, $dirty)), $composer2, (($dirty >> 3) & 14) | 12582912 | ($dirty & 896) | ($dirty & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            int i11 = $dirty;
            indicator2 = indicator3;
            divider2 = divider3;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            edgePadding3 = edgePadding2;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            indicator2 = indicator;
            divider2 = divider;
            int i12 = $dirty;
            containerColor3 = containerColor2;
            contentColor3 = contentColor2;
            edgePadding3 = edgePadding2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new TabRowKt$ScrollableTabRow$3(selectedTabIndex, modifier2, containerColor3, contentColor3, edgePadding3, indicator2, divider2, tabs, $changed, i));
    }
}
