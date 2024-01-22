package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.selection.SelectableGroupKt;
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

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a¬\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000123\b\u0002\u0010\u0010\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a¢\u0001\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r23\b\u0002\u0010\u0010\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0011¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "ScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "divider", "Lkotlin/Function0;", "tabs", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TabRow", "TabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
public final class TabRowKt {
    /* access modifiers changed from: private */
    public static final float ScrollableTabRowMinimumTabWidth = Dp.m5986constructorimpl((float) 90);
    /* access modifiers changed from: private */
    public static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null);

    /* renamed from: TabRow-pAZo6Ak  reason: not valid java name */
    public static final void m1663TabRowpAZo6Ak(int selectedTabIndex, Modifier modifier, long backgroundColor, long contentColor, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> divider, Function2<? super Composer, ? super Integer, Unit> tabs, Composer $composer, int $changed, int i) {
        long backgroundColor2;
        long contentColor2;
        Function3 indicator2;
        Function2 function2;
        Function2 divider2;
        Function3 indicator3;
        long contentColor3;
        long backgroundColor3;
        Modifier modifier2;
        Function2 divider3;
        Modifier modifier3;
        int i2;
        int i3;
        int i4 = selectedTabIndex;
        Function2<? super Composer, ? super Integer, Unit> function22 = tabs;
        int i5 = $changed;
        Intrinsics.checkNotNullParameter(function22, "tabs");
        Composer $composer2 = $composer.startRestartGroup(-249175289);
        ComposerKt.sourceInformation($composer2, "C(TabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)131@6500L6,132@6549L32,145@7022L1504:TabRow.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if ((i5 & 14) == 0) {
            $dirty |= $composer2.changed(i4) ? 4 : 2;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty |= 48;
            Modifier modifier4 = modifier;
        } else if ((i5 & 112) == 0) {
            $dirty |= $composer2.changed((Object) modifier) ? 32 : 16;
        } else {
            Modifier modifier5 = modifier;
        }
        if ((i5 & 896) == 0) {
            if ((i & 4) == 0) {
                backgroundColor2 = backgroundColor;
                if ($composer2.changed(backgroundColor2)) {
                    i3 = 256;
                    $dirty |= i3;
                }
            } else {
                backgroundColor2 = backgroundColor;
            }
            i3 = 128;
            $dirty |= i3;
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((i5 & 7168) == 0) {
            if ((i & 8) == 0) {
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
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
            indicator2 = indicator;
        } else if ((57344 & i5) == 0) {
            indicator2 = indicator;
            $dirty |= $composer2.changedInstance(indicator2) ? 16384 : 8192;
        } else {
            indicator2 = indicator;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function2 = divider;
        } else if ((458752 & i5) == 0) {
            function2 = divider;
            $dirty |= $composer2.changedInstance(function2) ? 131072 : 65536;
        } else {
            function2 = divider;
        }
        if ((i & 64) != 0) {
            $dirty |= 1572864;
        } else if ((i5 & 3670016) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 1048576 : 524288;
        }
        if (($dirty & 2995931) != 599186 || !$composer2.getSkipping()) {
            $composer2.startDefaults();
            if ((i5 & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i6 != 0) {
                    modifier3 = Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors($composer2, 6));
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    contentColor2 = ColorsKt.m1463contentColorForek8zF_U(backgroundColor2, $composer2, ($dirty >> 6) & 14);
                }
                if (i7 != 0) {
                    indicator2 = ComposableLambdaKt.composableLambda($composer2, -553782708, true, new TabRowKt$TabRow$1(i4));
                }
                divider3 = i8 != 0 ? ComposableSingletons$TabRowKt.INSTANCE.m1476getLambda1$material_release() : function2;
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    divider3 = function2;
                    modifier3 = modifier;
                } else {
                    modifier3 = modifier;
                    divider3 = function2;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-249175289, $dirty, -1, "androidx.compose.material.TabRow (TabRow.kt:128)");
            }
            SurfaceKt.m1620SurfaceFjzlyU(SelectableGroupKt.selectableGroup(modifier3), (Shape) null, backgroundColor2, contentColor2, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda($composer2, -1961746365, true, new TabRowKt$TabRow$2(function22, divider3, indicator2, $dirty)), $composer2, ($dirty & 896) | 1572864 | ($dirty & 7168), 50);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            int i9 = $dirty;
            divider2 = divider3;
            backgroundColor3 = backgroundColor2;
            contentColor3 = contentColor2;
            indicator3 = indicator2;
        } else {
            $composer2.skipToGroupEnd();
            int i10 = $dirty;
            backgroundColor3 = backgroundColor2;
            contentColor3 = contentColor2;
            indicator3 = indicator2;
            divider2 = function2;
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            Composer composer = $composer2;
            return;
        }
        Composer composer2 = $composer2;
        endRestartGroup.updateScope(new TabRowKt$TabRow$3(selectedTabIndex, modifier2, backgroundColor3, contentColor3, indicator3, divider2, tabs, $changed, i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:128:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0129  */
    /* renamed from: ScrollableTabRow-sKfQg0A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1662ScrollableTabRowsKfQg0A(int r28, androidx.compose.ui.Modifier r29, long r30, long r32, float r34, kotlin.jvm.functions.Function3<? super java.util.List<androidx.compose.material.TabPosition>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.runtime.Composer r38, int r39, int r40) {
        /*
            r13 = r28
            r14 = r37
            r15 = r39
            r12 = r40
            java.lang.String r0 = "tabs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -1473476840(0xffffffffa82c8718, float:-9.577212E-15)
            r1 = r38
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(ScrollableTabRow)P(6,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)225@11134L6,226@11183L32,240@11718L3006:TabRow.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r11, r1)
            r1 = r39
            r2 = r12 & 1
            if (r2 == 0) goto L_0x0025
            r1 = r1 | 6
            goto L_0x0033
        L_0x0025:
            r2 = r15 & 14
            if (r2 != 0) goto L_0x0033
            boolean r2 = r11.changed((int) r13)
            if (r2 == 0) goto L_0x0031
            r2 = 4
            goto L_0x0032
        L_0x0031:
            r2 = 2
        L_0x0032:
            r1 = r1 | r2
        L_0x0033:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x003c
            r1 = r1 | 48
            r3 = r29
            goto L_0x0051
        L_0x003c:
            r3 = r15 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004f
            r3 = r29
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x004b
            r4 = 32
            goto L_0x004d
        L_0x004b:
            r4 = 16
        L_0x004d:
            r1 = r1 | r4
            goto L_0x0051
        L_0x004f:
            r3 = r29
        L_0x0051:
            r4 = r15 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x006a
            r4 = r12 & 4
            if (r4 != 0) goto L_0x0064
            r4 = r30
            boolean r6 = r11.changed((long) r4)
            if (r6 == 0) goto L_0x0066
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0064:
            r4 = r30
        L_0x0066:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r1 = r1 | r6
            goto L_0x006c
        L_0x006a:
            r4 = r30
        L_0x006c:
            r6 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0085
            r6 = r12 & 8
            if (r6 != 0) goto L_0x007f
            r6 = r32
            boolean r8 = r11.changed((long) r6)
            if (r8 == 0) goto L_0x0081
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x007f:
            r6 = r32
        L_0x0081:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r1 = r1 | r8
            goto L_0x0087
        L_0x0085:
            r6 = r32
        L_0x0087:
            r8 = r12 & 16
            if (r8 == 0) goto L_0x0090
            r1 = r1 | 24576(0x6000, float:3.4438E-41)
            r9 = r34
            goto L_0x00a7
        L_0x0090:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r15
            if (r9 != 0) goto L_0x00a5
            r9 = r34
            boolean r10 = r11.changed((float) r9)
            if (r10 == 0) goto L_0x00a1
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x00a1:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r1 = r1 | r10
            goto L_0x00a7
        L_0x00a5:
            r9 = r34
        L_0x00a7:
            r10 = r12 & 32
            if (r10 == 0) goto L_0x00b2
            r16 = 196608(0x30000, float:2.75506E-40)
            r1 = r1 | r16
            r0 = r35
            goto L_0x00ca
        L_0x00b2:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r15 & r16
            if (r16 != 0) goto L_0x00c8
            r0 = r35
            boolean r17 = r11.changedInstance(r0)
            if (r17 == 0) goto L_0x00c3
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c5
        L_0x00c3:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00c5:
            r1 = r1 | r17
            goto L_0x00ca
        L_0x00c8:
            r0 = r35
        L_0x00ca:
            r17 = r12 & 64
            r18 = 1572864(0x180000, float:2.204052E-39)
            if (r17 == 0) goto L_0x00d5
            r1 = r1 | r18
            r0 = r36
            goto L_0x00ed
        L_0x00d5:
            r19 = 3670016(0x380000, float:5.142788E-39)
            r19 = r15 & r19
            if (r19 != 0) goto L_0x00eb
            r0 = r36
            boolean r19 = r11.changedInstance(r0)
            if (r19 == 0) goto L_0x00e6
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e8
        L_0x00e6:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00e8:
            r1 = r1 | r19
            goto L_0x00ed
        L_0x00eb:
            r0 = r36
        L_0x00ed:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00f5
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00f3:
            r1 = r1 | r0
            goto L_0x0106
        L_0x00f5:
            r0 = 29360128(0x1c00000, float:7.052966E-38)
            r0 = r0 & r15
            if (r0 != 0) goto L_0x0106
            boolean r0 = r11.changedInstance(r14)
            if (r0 == 0) goto L_0x0103
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f3
        L_0x0103:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00f3
        L_0x0106:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r1
            r3 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r3) goto L_0x0129
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x0116
            goto L_0x0129
        L_0x0116:
            r11.skipToGroupEnd()
            r16 = r29
            r22 = r35
            r23 = r36
            r24 = r1
            r17 = r4
            r19 = r6
            r21 = r9
            goto L_0x0210
        L_0x0129:
            r11.startDefaults()
            r0 = r15 & 1
            if (r0 == 0) goto L_0x0155
            boolean r0 = r11.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0137
            goto L_0x0155
        L_0x0137:
            r11.skipToGroupEnd()
            r0 = r12 & 4
            if (r0 == 0) goto L_0x0140
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0140:
            r0 = r12 & 8
            if (r0 == 0) goto L_0x014e
            r0 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r2 = r35
            r3 = r36
            r1 = r0
            r0 = r29
            goto L_0x01a7
        L_0x014e:
            r0 = r29
            r2 = r35
            r3 = r36
            goto L_0x01a7
        L_0x0155:
            if (r2 == 0) goto L_0x015c
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            goto L_0x015e
        L_0x015c:
            r0 = r29
        L_0x015e:
            r2 = r12 & 4
            if (r2 == 0) goto L_0x0170
            androidx.compose.material.MaterialTheme r2 = androidx.compose.material.MaterialTheme.INSTANCE
            r3 = 6
            androidx.compose.material.Colors r2 = r2.getColors(r11, r3)
            long r2 = androidx.compose.material.ColorsKt.getPrimarySurface(r2)
            r1 = r1 & -897(0xfffffffffffffc7f, float:NaN)
            r4 = r2
        L_0x0170:
            r2 = r12 & 8
            if (r2 == 0) goto L_0x017f
            int r2 = r1 >> 6
            r2 = r2 & 14
            long r2 = androidx.compose.material.ColorsKt.m1463contentColorForek8zF_U(r4, r11, r2)
            r1 = r1 & -7169(0xffffffffffffe3ff, float:NaN)
            r6 = r2
        L_0x017f:
            if (r8 == 0) goto L_0x0188
            androidx.compose.material.TabRowDefaults r2 = androidx.compose.material.TabRowDefaults.INSTANCE
            float r2 = r2.m1661getScrollableTabRowPaddingD9Ej5fM()
            r9 = r2
        L_0x0188:
            if (r10 == 0) goto L_0x019a
            androidx.compose.material.TabRowKt$ScrollableTabRow$1 r2 = new androidx.compose.material.TabRowKt$ScrollableTabRow$1
            r2.<init>(r13)
            r3 = -655609869(0xffffffffd8ec2ff3, float:-2.07752548E15)
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r3, r8, r2)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            goto L_0x019c
        L_0x019a:
            r2 = r35
        L_0x019c:
            if (r17 == 0) goto L_0x01a5
            androidx.compose.material.ComposableSingletons$TabRowKt r3 = androidx.compose.material.ComposableSingletons$TabRowKt.INSTANCE
            kotlin.jvm.functions.Function2 r3 = r3.m1477getLambda2$material_release()
            goto L_0x01a7
        L_0x01a5:
            r3 = r36
        L_0x01a7:
            r11.endDefaults()
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x01b9
            r8 = -1
            java.lang.String r10 = "androidx.compose.material.ScrollableTabRow (TabRow.kt:222)"
            r12 = -1473476840(0xffffffffa82c8718, float:-9.577212E-15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r12, r1, r8, r10)
        L_0x01b9:
            r17 = 0
            r22 = 0
            r23 = 0
            androidx.compose.material.TabRowKt$ScrollableTabRow$2 r8 = new androidx.compose.material.TabRowKt$ScrollableTabRow$2
            r29 = r8
            r30 = r9
            r31 = r37
            r32 = r3
            r33 = r28
            r34 = r2
            r35 = r1
            r29.<init>(r30, r31, r32, r33, r34, r35)
            r10 = 1455860572(0x56c6ab5c, float:1.09219643E14)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r8 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r10, r12, r8)
            r24 = r8
            kotlin.jvm.functions.Function2 r24 = (kotlin.jvm.functions.Function2) r24
            int r8 = r1 >> 3
            r8 = r8 & 14
            r8 = r8 | r18
            r10 = r1 & 896(0x380, float:1.256E-42)
            r8 = r8 | r10
            r10 = r1 & 7168(0x1c00, float:1.0045E-41)
            r26 = r8 | r10
            r27 = 50
            r16 = r0
            r18 = r4
            r20 = r6
            r25 = r11
            androidx.compose.material.SurfaceKt.m1620SurfaceFjzlyU(r16, r17, r18, r20, r22, r23, r24, r25, r26, r27)
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L_0x0202
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0202:
            r16 = r0
            r24 = r1
            r22 = r2
            r23 = r3
            r17 = r4
            r19 = r6
            r21 = r9
        L_0x0210:
            androidx.compose.runtime.ScopeUpdateScope r12 = r11.endRestartGroup()
            if (r12 != 0) goto L_0x0219
            r26 = r11
            goto L_0x023e
        L_0x0219:
            androidx.compose.material.TabRowKt$ScrollableTabRow$3 r25 = new androidx.compose.material.TabRowKt$ScrollableTabRow$3
            r0 = r25
            r1 = r28
            r2 = r16
            r3 = r17
            r5 = r19
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r37
            r26 = r11
            r11 = r39
            r13 = r12
            r12 = r40
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12)
            r0 = r25
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r13.updateScope(r0)
        L_0x023e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TabRowKt.m1662ScrollableTabRowsKfQg0A(int, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
